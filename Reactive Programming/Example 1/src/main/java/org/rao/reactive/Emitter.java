package org.rao.reactive;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.List;

public class Emitter {

    public static Observable<CityInfo> getData(List<String> cities) {

        System.out.println("Observable Created");
        return Observable.create(emitter -> emit(emitter, cities));
    }

    private static void emit(ObservableEmitter<CityInfo> emitter, List<String> cities) {
        System.out.println("Ready to emit");
        while (true) {
            cities.stream()
                  .map(CityInfo::fetch)
                  .forEach(emitter::onNext);
        }
    }
}
