package com.tencent.luggage.bridge.a;

import com.tencent.luggage.a.d;

public final class a {
    public static b bOP;

    public interface a extends c {
    }

    public interface b {
        void a(a aVar);

        void a(c cVar);
    }

    public interface c {
        <T extends com.tencent.luggage.a.b> void a(Class<T> cls, T t);

        <T extends d> void a(Class<T> cls, T t);
    }
}
