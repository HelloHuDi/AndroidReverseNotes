package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class d {
    private static d ckR;
    public volatile LinkedList<String> ckO = new LinkedList();
    public volatile HashMap<String, c> ckP = new HashMap();
    public volatile Object ckQ = new Object();

    private d() {
        AppMethodBeat.i(136992);
        AppMethodBeat.o(136992);
    }

    public static d Dm() {
        AppMethodBeat.i(136993);
        if (ckR == null) {
            synchronized (d.class) {
                try {
                    if (ckR == null) {
                        ckR = new d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(136993);
                    }
                }
            }
        }
        d dVar = ckR;
        AppMethodBeat.o(136993);
        return dVar;
    }

    public final c dv(String str) {
        c cVar;
        AppMethodBeat.i(136994);
        synchronized (this.ckQ) {
            try {
                if (!this.ckO.contains(str)) {
                    this.ckO.add(str);
                }
                cVar = (c) this.ckP.get(str);
                if (cVar == null) {
                    cVar = new c(str);
                    this.ckP.put(str, cVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136994);
            }
        }
        return cVar;
    }

    public final int dw(String str) {
        AppMethodBeat.i(136995);
        synchronized (this.ckQ) {
            try {
                if (this.ckO.contains(str)) {
                    c cVar = (c) this.ckP.get(str);
                    if (cVar != null) {
                        int size = cVar.size();
                        AppMethodBeat.o(136995);
                        return size;
                    }
                    AppMethodBeat.o(136995);
                    return 0;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136995);
            }
        }
        return 0;
    }

    public final boolean dx(String str) {
        AppMethodBeat.i(136996);
        synchronized (this.ckQ) {
            try {
                if (this.ckO.contains(str)) {
                    c cVar = (c) this.ckP.get(str);
                    if (cVar == null || cVar.size() <= 0 || !cVar.cky) {
                        AppMethodBeat.o(136996);
                        return false;
                    }
                    AppMethodBeat.o(136996);
                    return true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136996);
            }
        }
        return false;
    }

    public final long dy(String str) {
        AppMethodBeat.i(136998);
        synchronized (this.ckQ) {
            try {
                if (this.ckO.contains(str)) {
                    c cVar = (c) this.ckP.get(str);
                    if (cVar == null || !cVar.cky) {
                        AppMethodBeat.o(136998);
                        return 0;
                    }
                    long Da = cVar.Da();
                    AppMethodBeat.o(136998);
                    return Da;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136998);
            }
        }
        return 0;
    }

    public final long Dn() {
        AppMethodBeat.i(136999);
        long j = 0;
        synchronized (this.ckQ) {
            try {
                Iterator it = this.ckO.iterator();
                while (it.hasNext()) {
                    long j2;
                    c cVar = (c) this.ckP.get((String) it.next());
                    if (cVar == null || !cVar.cky || cVar.ckB) {
                        j2 = j;
                    } else {
                        j2 = cVar.Da() + j;
                    }
                    j = j2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136999);
            }
        }
        return j;
    }

    public final ArrayList<String> Do() {
        ArrayList<String> arrayList;
        AppMethodBeat.i(137000);
        synchronized (this.ckQ) {
            try {
                arrayList = new ArrayList();
                arrayList.addAll(this.ckO);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137000);
            }
        }
        return arrayList;
    }

    public final void clearCache() {
        AppMethodBeat.i(136997);
        synchronized (this.ckQ) {
            try {
                Iterator it = this.ckO.iterator();
                while (it.hasNext()) {
                    c cVar = (c) this.ckP.get((String) it.next());
                    if (cVar != null) {
                        cVar.reset();
                    }
                }
                this.ckO.clear();
                this.ckP.clear();
            } finally {
                AppMethodBeat.o(136997);
            }
        }
    }
}
