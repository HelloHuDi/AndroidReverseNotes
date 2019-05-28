package com.tencent.mm.loader.h;

import java.io.OutputStream;

public abstract class f<T> {
    T data;

    public interface a<T> {
        com.tencent.mm.loader.h.b.a TX();
    }

    public abstract com.tencent.mm.loader.h.b.a TW();

    public abstract void a(OutputStream outputStream);

    f() {
    }

    public f(T t) {
        this.data = t;
    }

    public final T value() {
        return this.data;
    }
}
