package com.mycompany.app;
import io.reactivex.rxjava3.core.Observable;
import java.io.*;

public class IfstatObservable {

    public static  Observable<String> ifstatObservable() {
        //getting ifstat command
        ProcessBuilder pb = new ProcessBuilder("ifstat", "-i", "wlx4401bb8de24f");

        return Observable.create(emitter -> {

            pb.redirectErrorStream(true);
            Process process = pb.start();
            InputStream processStdOutput = process.getInputStream();
            Reader r = new InputStreamReader(processStdOutput);
            BufferedReader br = new BufferedReader(r);
            String line;
            while ((line = br.readLine()) != null) {
                emitter.onNext(line);
            }

            emitter.onComplete();

        });
    }
}