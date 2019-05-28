package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class s implements b {
    private final Set<Class<?>> bvm;
    private final Set<Class<?>> bvn;
    private final b bvo;

    public final <T> T x(Class<T> cls) {
        AppMethodBeat.i(10633);
        if (this.bvm.contains(cls)) {
            Object x = this.bvo.x(cls);
            AppMethodBeat.o(10633);
            return x;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Requesting %s is not allowed.", new Object[]{cls}));
        AppMethodBeat.o(10633);
        throw illegalArgumentException;
    }

    public final <T> a<T> z(Class<T> cls) {
        AppMethodBeat.i(10634);
        if (this.bvn.contains(cls)) {
            a z = this.bvo.z(cls);
            AppMethodBeat.o(10634);
            return z;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", new Object[]{cls}));
        AppMethodBeat.o(10634);
        throw illegalArgumentException;
    }

    public s(Iterable<f> iterable, b bVar) {
        AppMethodBeat.i(10632);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (f fVar : iterable) {
            if (fVar.uB()) {
                hashSet.add(fVar.buW);
            } else {
                hashSet2.add(fVar.buW);
            }
        }
        this.bvm = Collections.unmodifiableSet(hashSet);
        this.bvn = Collections.unmodifiableSet(hashSet2);
        this.bvo = bVar;
        AppMethodBeat.o(10632);
    }
}
