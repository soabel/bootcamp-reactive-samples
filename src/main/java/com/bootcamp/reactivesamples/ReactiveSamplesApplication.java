package com.bootcamp.reactivesamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ReactiveSamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveSamplesApplication.class, args);

        imperativo();
        funcional();

        reactiva();


    }

    public static void imperativo() {
        System.out.println("======= IMPERATIVO ======== ");
        List<Integer> listaEnteros = List.of(1, 2, 3, 5, 8, 13, 21, 34);
        System.out.println("listaEnteros = " + listaEnteros);

        List<Integer> listaPares = new ArrayList<>();
        for (Integer item : listaEnteros) {
            if (item % 2 == 0) {
                listaPares.add(item);
            }
        }
        System.out.println("listaPares = " + listaPares);

        List<Integer> listaCuadrados = new ArrayList<>();
        for (Integer item : listaPares) {
            listaCuadrados.add(item * item);
        }
        System.out.println("listaCuadrados = " + listaCuadrados);


        List<Integer> listaSumaCuadrados = new ArrayList<>();
        Integer suma = 0;
        for (Integer item : listaCuadrados) {
            suma += item;
        }
        System.out.println("suma = " + suma);

    }

    public static void funcional() {
        System.out.println("======= FUNCIONAL ======== ");

        List<Integer> listaEnteros = List.of(1, 2, 3, 5, 8, 34, 8, 13, 21, 34);

        listaEnteros = listaEnteros.stream().distinct().collect(Collectors.toList());
        System.out.println("listaEnteros = " + listaEnteros);

        List<Integer> listaOrdenada = listaEnteros
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("listaOrdenada = " + listaOrdenada);

        List<Integer> listaPares = listaEnteros.stream()
//                .filter(x -> x > 10)
                .filter(x -> x % 2 == 0)
//                .filter(x -> x > 10 && x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("listaPares = " + listaPares);

        boolean existePar = listaEnteros.stream()
                .anyMatch(x -> x % 2 == 0);
        System.out.println("existePar = " + existePar);

        List<String> listaCuadrados = new ArrayList<>();
        listaCuadrados = listaPares.stream()
//                .map(ReactiveSamplesApplication::cuadrado)
                .map(x -> {
                    Integer c = x * x;
                    return c.toString();
                })
//                .map(x -> cuadrado(x) )
                .collect(Collectors.toList());
        System.out.println("listaCuadrados = " + listaCuadrados);

        List<Integer> listaCuadrados2 = new ArrayList<>();
        listaCuadrados2 = listaEnteros.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .collect(Collectors.toList());

        System.out.println("listaCuadrados2 = " + listaCuadrados2);

//        Integer sumaCuadrados = listaCuadrados2.stream()
//                .reduce((suma, element) -> suma + element)
//                .get();

        Integer sumaCuadrados = listaEnteros.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .reduce((sum, element) -> sum + element)
                .get();

        System.out.println("sumaCuadrados = " + sumaCuadrados);


        Integer maximoCuadrado = listaEnteros.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .max(Comparator.naturalOrder())
                .get();

        System.out.println("maximoCuadrado = " + maximoCuadrado);


        Integer minimoCuadrado = listaEnteros.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .min(Comparator.naturalOrder())
                .get();

        System.out.println("minimoCuadrado = " + minimoCuadrado);


        int total = listaPares
                .stream()
                .parallel()
                .map(ReactiveSamplesApplication::cuadradoSlow)
                .map(ReactiveSamplesApplication::cuadradoSlow)
                .reduce((sum, element) -> sum + element)
                .get();

        System.out.println("total = " + total);

    }

    public static void reactiva() {
        System.out.println("======= REACTIVA ======== ");

        Mono<Integer> monoInteger = Mono.just(12);

        monoInteger.
                subscribe(x -> System.out.println("x = " + x));

        Flux<Integer> fluxInteger = Flux.just(1, 2, 4);
        fluxInteger.subscribe(y -> System.out.println("y = " + y));

        List<Integer> listaEnteros = List.of(1, 2, 3, 5, 8, 34, 8, 13, 21, 34);

        Flux<Integer> fluxEnteros = Flux.fromIterable(listaEnteros);

        fluxEnteros
                .filter(y -> y < 8)
                .map(y -> y * 2)
                .sort(Comparator.reverseOrder())
                .subscribe(y -> System.out.println("y = " + y));


    }

    private static Integer cuadrado(Integer x) {

        return x * x;
    }

    private static Integer cuadradoSlow(Integer x) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return x * x;
    }


}
