package com.bumptech.glide.c.a;

import com.bumptech.glide.g;

public interface d<T> {

    public interface a<T> {
        void S(T t);

        void b(Exception exception);
    }

    void a(g gVar, a<? super T> aVar);

    void cancel();

    void cleanup();

    Class<T> mg();

    com.bumptech.glide.c.a mh();
}
