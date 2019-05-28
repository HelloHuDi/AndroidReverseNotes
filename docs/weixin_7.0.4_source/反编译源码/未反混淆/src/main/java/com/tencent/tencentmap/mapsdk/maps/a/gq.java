package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.PointF;
import com.tencent.map.lib.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class gq implements gf {
    private ArrayList<gf> a = new ArrayList();

    public gq() {
        AppMethodBeat.i(99425);
        AppMethodBeat.o(99425);
    }

    public synchronized void a(gf gfVar) {
        AppMethodBeat.i(99426);
        if (!(gfVar == null || this.a.contains(gfVar))) {
            this.a.add(gfVar);
        }
        AppMethodBeat.o(99426);
    }

    public synchronized void b(gf gfVar) {
        AppMethodBeat.i(99427);
        this.a.remove(gfVar);
        AppMethodBeat.o(99427);
    }

    public synchronized boolean a(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99428);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).a(f, f2)) {
                z = true;
                AppMethodBeat.o(99428);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99428);
        return z;
    }

    public synchronized boolean b(float f, float f2) {
        boolean z;
        int size;
        AppMethodBeat.i(99429);
        for (size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).b(f, f2)) {
                z = true;
                AppMethodBeat.o(99429);
                break;
            }
        }
        d.a("notify onSingleTap");
        for (size = this.a.size() - 1; size >= 0; size--) {
            ((gf) this.a.get(size)).a();
        }
        z = false;
        AppMethodBeat.o(99429);
        return z;
    }

    public void a() {
        AppMethodBeat.i(99430);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((gf) this.a.get(size)).a();
        }
        AppMethodBeat.o(99430);
    }

    public synchronized boolean c(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99431);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).c(f, f2)) {
                z = true;
                AppMethodBeat.o(99431);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99431);
        return z;
    }

    public synchronized boolean d(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99432);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).d(f, f2)) {
                z = true;
                AppMethodBeat.o(99432);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99432);
        return z;
    }

    public synchronized boolean e(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99433);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).e(f, f2)) {
                z = true;
                AppMethodBeat.o(99433);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99433);
        return z;
    }

    public synchronized boolean f(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99434);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).f(f, f2)) {
                z = true;
                AppMethodBeat.o(99434);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99434);
        return z;
    }

    public synchronized boolean g(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99435);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).g(f, f2)) {
                z = true;
                AppMethodBeat.o(99435);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99435);
        return z;
    }

    public synchronized boolean h(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99436);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).h(f, f2)) {
                z = true;
                AppMethodBeat.o(99436);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99436);
        return z;
    }

    public synchronized boolean b() {
        boolean z;
        AppMethodBeat.i(99437);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).b()) {
                z = true;
                AppMethodBeat.o(99437);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99437);
        return z;
    }

    public synchronized boolean c() {
        boolean z;
        AppMethodBeat.i(99438);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).c()) {
                z = true;
                AppMethodBeat.o(99438);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99438);
        return z;
    }

    public synchronized boolean a(float f) {
        boolean z;
        AppMethodBeat.i(99439);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).a(f)) {
                z = true;
                AppMethodBeat.o(99439);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99439);
        return z;
    }

    public synchronized boolean d() {
        boolean z;
        AppMethodBeat.i(99440);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).d()) {
                z = true;
                AppMethodBeat.o(99440);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99440);
        return z;
    }

    public synchronized boolean a(PointF pointF, PointF pointF2, float f) {
        boolean z;
        AppMethodBeat.i(99441);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).a(pointF, pointF2, f)) {
                z = true;
                AppMethodBeat.o(99441);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99441);
        return z;
    }

    public synchronized boolean a(PointF pointF, PointF pointF2, double d, double d2) {
        boolean z;
        AppMethodBeat.i(99442);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).a(pointF, pointF2, d, d2)) {
                z = true;
                AppMethodBeat.o(99442);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99442);
        return z;
    }

    public synchronized boolean i(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99443);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).i(f, f2)) {
                z = true;
                AppMethodBeat.o(99443);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99443);
        return z;
    }

    public synchronized boolean j(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99444);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).j(f, f2)) {
                z = true;
                AppMethodBeat.o(99444);
                break;
            }
        }
        z = false;
        AppMethodBeat.o(99444);
        return z;
    }

    public boolean k(float f, float f2) {
        AppMethodBeat.i(99445);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (((gf) this.a.get(size)).k(f, f2)) {
                AppMethodBeat.o(99445);
                return true;
            }
        }
        AppMethodBeat.o(99445);
        return false;
    }
}
