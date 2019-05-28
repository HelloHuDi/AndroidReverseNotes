package com.tencent.p177mm.p178a;

import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.a.f */
public interface C1177f<K, O> {

    /* renamed from: com.tencent.mm.a.f$a */
    public interface C1174a<K, O> {
    }

    /* renamed from: com.tencent.mm.a.f$b */
    public interface C1175b<K, O> {
        /* renamed from: c */
        void mo4401c(K k, O o, O o2);
    }

    /* renamed from: com.tencent.mm.a.f$c */
    public interface C1176c<K, O> {
        /* renamed from: l */
        int mo4402l(K k, O o);
    }

    /* renamed from: a */
    void mo4403a(C1174a<K, O> c1174a);

    /* renamed from: ai */
    O mo4404ai(K k);

    /* renamed from: aj */
    boolean mo4405aj(K k);

    /* renamed from: ak */
    boolean mo4406ak(K k);

    void clear();

    int createCount();

    int evictionCount();

    O get(K k);

    int hitCount();

    /* renamed from: k */
    void mo4412k(K k, O o);

    Set<K> keySet();

    int maxSize();

    int missCount();

    O put(K k, O o);

    int putCount();

    O remove(K k);

    int size();

    int sizeOf(K k, O o);

    Map<K, O> snapshot();

    void trimToSize(int i);
}
