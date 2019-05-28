package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.tencentmap.mapsdk.a.a;
import com.tencent.tencentmap.mapsdk.a.b;
import com.tencent.tencentmap.mapsdk.a.e;
import java.util.ArrayList;
import java.util.HashMap;

public final class at {
    private av a;
    private Context b;
    private int c = i.sHCENCODEVIDEOTIMEOUT;
    private int d = 0;
    private Runnable e = new Runnable() {
        public final void run() {
            AppMethodBeat.i(98506);
            try {
                at.this.a();
                AppMethodBeat.o(98506);
            } catch (Throwable th) {
                ag.a(th);
                AppMethodBeat.o(98506);
            }
        }
    };

    public at(Context context) {
        AppMethodBeat.i(98507);
        this.b = context;
        HashMap hashMap = new HashMap(2);
        boolean g = a.g(this.b);
        e.a(context);
        hashMap.put("A33", e.g(context));
        if (g) {
            hashMap.put("A66", "F");
        } else {
            hashMap.put("A66", "B");
        }
        hashMap.put("A68", a.h(this.b));
        hashMap.put("A85", a.b ? "Y" : "N");
        this.a = e.a(this.b, "rqd_heartbeat", true, 0, 0, hashMap, false);
        AppMethodBeat.o(98507);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        AppMethodBeat.i(98508);
        if (e.m(this.b)) {
            be f = ax.d().f();
            if (f != null) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(this.a);
                f.a(new a(this.b, arrayList));
            }
            a(c() + 1);
            if (c() % 10 == 0) {
                b.a().a(108, this.e, 600000, (long) this.c);
                a(0);
            }
            AppMethodBeat.o(98508);
            return;
        }
        AppMethodBeat.o(98508);
    }

    public final void b() {
        AppMethodBeat.i(98509);
        if (e.g().equals(a.b(this.b, "HEART_DENGTA", ""))) {
            ag.a("heartbeat has been uploaded today!", new Object[0]);
            AppMethodBeat.o(98509);
            return;
        }
        b.a().a(108, this.e, 0, (long) this.c);
        AppMethodBeat.o(98509);
    }

    private synchronized int c() {
        return this.d;
    }

    private synchronized void a(int i) {
        this.d = i;
    }
}
