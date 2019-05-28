package com.tencent.p177mm.loader.p1197h;

import com.tencent.p177mm.loader.p1197h.p1199b.C18545a;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.loader.h.f */
public abstract class C42162f<T> {
    T data;

    /* renamed from: com.tencent.mm.loader.h.f$a */
    public interface C42163a<T> {
        /* renamed from: TX */
        C18545a mo33802TX();
    }

    /* renamed from: TW */
    public abstract C18545a mo33800TW();

    /* renamed from: a */
    public abstract void mo33801a(OutputStream outputStream);

    C42162f() {
    }

    public C42162f(T t) {
        this.data = t;
    }

    public final T value() {
        return this.data;
    }
}
