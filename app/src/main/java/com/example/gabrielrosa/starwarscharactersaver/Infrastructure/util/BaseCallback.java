package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.util;

/**
 * Created by gabrielrosa on 06/02/18.
 */

public class BaseCallback {
    public interface ApiCaseCallback<R> {
        void onSuccess(R response);
        void onError();
    }
}
