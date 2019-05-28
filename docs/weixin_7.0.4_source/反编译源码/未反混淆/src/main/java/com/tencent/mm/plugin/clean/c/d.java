package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashSet;

public final class d {
    private static long kvW = 0;
    private static long kvX = 0;
    private static b kwh;
    private static long kwm = 0;
    private static long kwn = 0;
    private static final ak kwv = new ak();
    private static HashSet<String> kww;
    private static ArrayList<b> kwx;
    private static int kwy = 0;

    static {
        AppMethodBeat.i(18699);
        AppMethodBeat.o(18699);
    }

    public static void a(b bVar) {
        kwh = bVar;
    }

    public static b bfQ() {
        boolean z = true;
        AppMethodBeat.i(18695);
        String str = "MicroMsg.CleanLogic";
        String str2 = "getThreadController threadController is null? %b";
        Object[] objArr = new Object[1];
        if (kwh != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.d(str, str2, objArr);
        b bVar = kwh;
        AppMethodBeat.o(18695);
        return bVar;
    }

    public static void b(HashSet<String> hashSet) {
        kww = hashSet;
    }

    public static HashSet<String> bfR() {
        return kww;
    }

    public static void u(ArrayList<b> arrayList) {
        boolean z = true;
        AppMethodBeat.i(18696);
        String str = "MicroMsg.CleanLogic";
        String str2 = "set analyse data: is null? %b";
        Object[] objArr = new Object[1];
        if (arrayList != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        kwx = arrayList;
        AppMethodBeat.o(18696);
    }

    public static ArrayList<b> bfS() {
        return kwx;
    }

    public static void hd(long j) {
        kwn = j;
    }

    public static long bfT() {
        return kwn;
    }

    public static void he(long j) {
        kvW = j;
    }

    public static long bfU() {
        return kvW;
    }

    public static void hf(long j) {
        if (j <= 0) {
            j = 0;
        }
        kvX = j;
    }

    public static long bfV() {
        return kvX;
    }

    public static void hg(long j) {
        kwm = j;
    }

    public static long bfW() {
        return kwm;
    }

    public static final void bfX() {
        AppMethodBeat.i(18697);
        ab.i("MicroMsg.CleanLogic", "startCleanDataNow");
        kwv.removeCallbacksAndMessages(null);
        kwn = 0;
        kwm = 0;
        u(null);
        kwy = 0;
        AppMethodBeat.o(18697);
    }

    public static final void bfY() {
        AppMethodBeat.i(18698);
        ab.i("MicroMsg.CleanLogic", "start to post clean runnable!!");
        kwv.removeCallbacksAndMessages(null);
        kwv.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18694);
                if (d.kwy == 0) {
                    ab.i("MicroMsg.CleanLogic", "clean data");
                    d.hd(0);
                    d.u(null);
                    AppMethodBeat.o(18694);
                    return;
                }
                ab.i("MicroMsg.CleanLogic", "clean data is using");
                AppMethodBeat.o(18694);
            }
        }, 300000);
        AppMethodBeat.o(18698);
    }

    public static final void bfZ() {
        kwy++;
    }

    public static final void bga() {
        kwy--;
    }
}
