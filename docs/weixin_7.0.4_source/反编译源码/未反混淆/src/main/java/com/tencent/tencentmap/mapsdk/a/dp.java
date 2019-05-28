package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class dp implements dn {
    private ArrayList<dn> a = new ArrayList();

    public dp() {
        AppMethodBeat.i(101092);
        AppMethodBeat.o(101092);
    }

    public synchronized void a(dn dnVar) {
        AppMethodBeat.i(101093);
        if (!(dnVar == null || this.a.contains(dnVar))) {
            this.a.add(dnVar);
        }
        AppMethodBeat.o(101093);
    }

    public synchronized void b(dn dnVar) {
        AppMethodBeat.i(101094);
        this.a.remove(dnVar);
        AppMethodBeat.o(101094);
    }

    public synchronized boolean a(float f, float f2) {
        AppMethodBeat.i(101095);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((dn) this.a.get(size)).a(f, f2);
        }
        AppMethodBeat.o(101095);
        return false;
    }

    public synchronized boolean b(float f, float f2) {
        AppMethodBeat.i(101096);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((dn) this.a.get(size)).b(f, f2);
        }
        AppMethodBeat.o(101096);
        return false;
    }

    public synchronized boolean c(float f, float f2) {
        AppMethodBeat.i(101097);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((dn) this.a.get(size)).c(f, f2);
        }
        AppMethodBeat.o(101097);
        return false;
    }

    public synchronized boolean d(float f, float f2) {
        AppMethodBeat.i(101098);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((dn) this.a.get(size)).d(f, f2);
        }
        AppMethodBeat.o(101098);
        return false;
    }

    public synchronized boolean e(float f, float f2) {
        AppMethodBeat.i(101099);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((dn) this.a.get(size)).e(f, f2);
        }
        AppMethodBeat.o(101099);
        return false;
    }

    public synchronized boolean f(float f, float f2) {
        AppMethodBeat.i(101100);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((dn) this.a.get(size)).f(f, f2);
        }
        AppMethodBeat.o(101100);
        return false;
    }

    public synchronized boolean g(float f, float f2) {
        AppMethodBeat.i(101101);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((dn) this.a.get(size)).g(f, f2);
        }
        AppMethodBeat.o(101101);
        return false;
    }

    public synchronized void a() {
        AppMethodBeat.i(101102);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ((dn) this.a.get(size)).a();
        }
        AppMethodBeat.o(101102);
    }
}
