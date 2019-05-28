package com.tencent.mm.cd.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a.f.a;
import java.util.ArrayList;

public abstract class g<K, T extends a> {
    public d ycB;

    public abstract ArrayList<T> ao(ArrayList<Object> arrayList);

    public abstract T dvB();

    public g(d dVar, int i) {
        this.ycB = dVar;
        this.ycB.pt(true);
        this.ycB.a(new a() {
            public final a dvz() {
                AppMethodBeat.i(59205);
                a dvB = g.this.dvB();
                AppMethodBeat.o(59205);
                return dvB;
            }

            public final ArrayList<a> ao(ArrayList<Object> arrayList) {
                AppMethodBeat.i(59206);
                ArrayList ao = g.this.ao(arrayList);
                AppMethodBeat.o(59206);
                return ao;
            }
        });
        if (i != 0) {
            this.ycB.MH(i);
        }
        getCount();
    }

    public final void close() {
        this.ycB.close();
        this.ycB = null;
    }

    public final int getCount() {
        return this.ycB.getCount();
    }

    public final boolean isClosed() {
        return this.ycB.isClosed();
    }

    public final boolean dvr() {
        return this.ycB.dvr();
    }

    public final void c(Object obj, T t) {
        this.ycB.a(obj, t);
    }

    public final SparseArray<K>[] dvp() {
        return this.ycB.dvp();
    }

    public final boolean cK(Object obj) {
        return this.ycB.cK(obj);
    }
}
