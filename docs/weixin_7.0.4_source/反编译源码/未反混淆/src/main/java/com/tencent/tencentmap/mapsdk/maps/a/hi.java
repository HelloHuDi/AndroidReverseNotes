package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class hi<E> {
    private int a;
    private volatile Object[] b;
    private volatile int c = 0;
    private volatile int d = 0;

    public hi(int i) {
        AppMethodBeat.i(99539);
        this.a = i;
        this.b = new Object[i];
        AppMethodBeat.o(99539);
    }

    private void e() {
        this.d = 0;
        this.c = 0;
    }

    public boolean a(E e) {
        AppMethodBeat.i(99540);
        if (c()) {
            AppMethodBeat.o(99540);
            return false;
        }
        this.d %= this.a;
        Object[] objArr = this.b;
        int i = this.d;
        this.d = i + 1;
        objArr[i] = e;
        AppMethodBeat.o(99540);
        return true;
    }

    public E a() {
        AppMethodBeat.i(99541);
        if (d()) {
            AppMethodBeat.o(99541);
            return null;
        }
        this.c %= this.a;
        E e = this.b[this.c];
        this.b[this.c] = null;
        this.c++;
        AppMethodBeat.o(99541);
        return e;
    }

    public void b() {
        AppMethodBeat.i(99542);
        e();
        for (int i = 0; i < this.b.length; i++) {
            this.b[i] = null;
        }
        AppMethodBeat.o(99542);
    }

    public boolean c() {
        return (this.d + 1) % this.a == this.c;
    }

    public boolean d() {
        return this.d == this.c;
    }
}
