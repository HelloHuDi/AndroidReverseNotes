package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.o;

abstract class d {
    protected final m aTw;

    public static final class a extends o {
        public a(String str) {
            super(str);
        }
    }

    public abstract void a(l lVar, long j);

    public abstract boolean a(l lVar);

    protected d(m mVar) {
        this.aTw = mVar;
    }

    public final void b(l lVar, long j) {
        if (a(lVar)) {
            a(lVar, j);
        }
    }
}
