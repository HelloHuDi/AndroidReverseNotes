package com.google.firebase.components;

import com.google.firebase.p1372a.C25579a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.firebase.components.s */
public final class C37303s implements C45069b {
    private final Set<Class<?>> bvm;
    private final Set<Class<?>> bvn;
    private final C45069b bvo;

    /* renamed from: x */
    public final <T> T mo19762x(Class<T> cls) {
        AppMethodBeat.m2504i(10633);
        if (this.bvm.contains(cls)) {
            Object x = this.bvo.mo19762x(cls);
            AppMethodBeat.m2505o(10633);
            return x;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Requesting %s is not allowed.", new Object[]{cls}));
        AppMethodBeat.m2505o(10633);
        throw illegalArgumentException;
    }

    /* renamed from: z */
    public final <T> C25579a<T> mo19763z(Class<T> cls) {
        AppMethodBeat.m2504i(10634);
        if (this.bvn.contains(cls)) {
            C25579a z = this.bvo.mo19763z(cls);
            AppMethodBeat.m2505o(10634);
            return z;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", new Object[]{cls}));
        AppMethodBeat.m2505o(10634);
        throw illegalArgumentException;
    }

    public C37303s(Iterable<C25581f> iterable, C45069b c45069b) {
        AppMethodBeat.m2504i(10632);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (C25581f c25581f : iterable) {
            if (c25581f.mo43233uB()) {
                hashSet.add(c25581f.buW);
            } else {
                hashSet2.add(c25581f.buW);
            }
        }
        this.bvm = Collections.unmodifiableSet(hashSet);
        this.bvn = Collections.unmodifiableSet(hashSet2);
        this.bvo = c45069b;
        AppMethodBeat.m2505o(10632);
    }
}
