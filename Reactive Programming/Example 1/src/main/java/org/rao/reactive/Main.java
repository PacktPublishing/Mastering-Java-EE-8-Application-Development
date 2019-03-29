package org.rao.reactive;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> symbols = Arrays.asList("London,UK","Bangalore,IN","Mumbai,IN");
        Observable<CityInfo> data = Emitter.getData(symbols);

        System.out.println("Got the Observable instance");
        //data.subscribe();

        data.subscribe(cityInfo -> System.out.println(cityInfo));


    }
}
