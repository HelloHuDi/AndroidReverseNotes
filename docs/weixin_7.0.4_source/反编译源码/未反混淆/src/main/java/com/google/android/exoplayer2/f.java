package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.i;

public interface f extends q {

    public static final class c {
        public final b aMN;
        public final int aMO = 1;
        public final Object aMP;

        public c(b bVar, Object obj) {
            this.aMN = bVar;
            this.aMP = obj;
        }
    }

    @Deprecated
    public interface a extends com.google.android.exoplayer2.q.a {
    }

    public interface b {
        void c(int i, Object obj);
    }

    void a(i iVar);

    void a(c... cVarArr);

    void b(c... cVarArr);
}
