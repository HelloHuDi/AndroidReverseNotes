package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fg implements Cloneable {
    private static final fi<Integer> d = new fc();
    private static final fi<Number> e = new ez();
    int a;
    Class<?> b;
    fe c;
    private fi f;

    static class a extends fg {
        fa d;

        public /* synthetic */ fg a() {
            AppMethodBeat.i(98888);
            a c = c();
            AppMethodBeat.o(98888);
            return c;
        }

        public /* synthetic */ Object clone() {
            AppMethodBeat.i(98889);
            a c = c();
            AppMethodBeat.o(98889);
            return c;
        }

        public a(int i, double... dArr) {
            super(i);
            AppMethodBeat.i(98885);
            a(dArr);
            AppMethodBeat.o(98885);
        }

        public void a(double... dArr) {
            AppMethodBeat.i(98886);
            super.a(dArr);
            this.d = (fa) this.c;
            AppMethodBeat.o(98886);
        }

        public a c() {
            AppMethodBeat.i(98887);
            a aVar = (a) super.a();
            aVar.d = (fa) aVar.c;
            AppMethodBeat.o(98887);
            return aVar;
        }
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.i(98897);
        fg a = a();
        AppMethodBeat.o(98897);
        return a;
    }

    static {
        AppMethodBeat.i(98898);
        AppMethodBeat.o(98898);
    }

    private fg(int i) {
        this.c = null;
        this.a = i;
    }

    public static fg a(int i, double... dArr) {
        AppMethodBeat.i(98890);
        a aVar = new a(i, dArr);
        AppMethodBeat.o(98890);
        return aVar;
    }

    public static fg a(int i, fi<Object> fiVar, Object... objArr) {
        AppMethodBeat.i(98891);
        fg fgVar = new fg(i);
        fgVar.a(objArr);
        fgVar.a((fi) fiVar);
        AppMethodBeat.o(98891);
        return fgVar;
    }

    public void a(double... dArr) {
        AppMethodBeat.i(98892);
        this.b = Double.TYPE;
        this.c = fe.a(dArr);
        AppMethodBeat.o(98892);
    }

    public void a(Object... objArr) {
        AppMethodBeat.i(98893);
        this.b = objArr[0].getClass();
        this.c = fe.a(objArr);
        AppMethodBeat.o(98893);
    }

    public fg a() {
        AppMethodBeat.i(98894);
        try {
            fg fgVar = (fg) super.clone();
            fgVar.a = this.a;
            fgVar.c = this.c.b();
            fgVar.f = this.f;
            AppMethodBeat.o(98894);
            return fgVar;
        } catch (CloneNotSupportedException e) {
            AppMethodBeat.o(98894);
            return null;
        }
    }

    public void a(fi fiVar) {
        AppMethodBeat.i(98895);
        this.f = fiVar;
        this.c.a(fiVar);
        AppMethodBeat.o(98895);
    }

    public int b() {
        return this.a;
    }

    public String toString() {
        AppMethodBeat.i(98896);
        String str = this.a + ": " + this.c.toString();
        AppMethodBeat.o(98896);
        return str;
    }
}
