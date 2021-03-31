package com.mycompany;

import com.mycompany.app.*;
import io.reactivex.rxjava3.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        IfstatObservable ifstatObs = new IfstatObservable();
        Observable<String> ifstatObserver = ifstatObs.ifstatObservable();

        ifstatObserver.subscribe(
                ifstat ->  LOGGER.info("Receiving data " + ifstat),
                error -> LOGGER.error("error "),
                () -> LOGGER.info("done")
        );
    }
}