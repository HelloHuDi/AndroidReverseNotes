package com.tencent.p177mm.plugin.clean.p362c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.clean.p362c.p363a.C11387b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.clean.c.d */
public final class C27642d {
    private static long kvW = 0;
    private static long kvX = 0;
    private static C11387b kwh;
    private static long kwm = 0;
    private static long kwn = 0;
    private static final C7306ak kwv = new C7306ak();
    private static HashSet<String> kww;
    private static ArrayList<C27641b> kwx;
    private static int kwy = 0;

    /* renamed from: com.tencent.mm.plugin.clean.c.d$1 */
    static class C276431 implements Runnable {
        C276431() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18694);
            if (C27642d.kwy == 0) {
                C4990ab.m7416i("MicroMsg.CleanLogic", "clean data");
                C27642d.m43918hd(0);
                C27642d.m43922u(null);
                AppMethodBeat.m2505o(18694);
                return;
            }
            C4990ab.m7416i("MicroMsg.CleanLogic", "clean data is using");
            AppMethodBeat.m2505o(18694);
        }
    }

    static {
        AppMethodBeat.m2504i(18699);
        AppMethodBeat.m2505o(18699);
    }

    /* renamed from: a */
    public static void m43916a(C11387b c11387b) {
        kwh = c11387b;
    }

    public static C11387b bfQ() {
        boolean z = true;
        AppMethodBeat.m2504i(18695);
        String str = "MicroMsg.CleanLogic";
        String str2 = "getThreadController threadController is null? %b";
        Object[] objArr = new Object[1];
        if (kwh != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7411d(str, str2, objArr);
        C11387b c11387b = kwh;
        AppMethodBeat.m2505o(18695);
        return c11387b;
    }

    /* renamed from: b */
    public static void m43917b(HashSet<String> hashSet) {
        kww = hashSet;
    }

    public static HashSet<String> bfR() {
        return kww;
    }

    /* renamed from: u */
    public static void m43922u(ArrayList<C27641b> arrayList) {
        boolean z = true;
        AppMethodBeat.m2504i(18696);
        String str = "MicroMsg.CleanLogic";
        String str2 = "set analyse data: is null? %b";
        Object[] objArr = new Object[1];
        if (arrayList != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        kwx = arrayList;
        AppMethodBeat.m2505o(18696);
    }

    public static ArrayList<C27641b> bfS() {
        return kwx;
    }

    /* renamed from: hd */
    public static void m43918hd(long j) {
        kwn = j;
    }

    public static long bfT() {
        return kwn;
    }

    /* renamed from: he */
    public static void m43919he(long j) {
        kvW = j;
    }

    public static long bfU() {
        return kvW;
    }

    /* renamed from: hf */
    public static void m43920hf(long j) {
        if (j <= 0) {
            j = 0;
        }
        kvX = j;
    }

    public static long bfV() {
        return kvX;
    }

    /* renamed from: hg */
    public static void m43921hg(long j) {
        kwm = j;
    }

    public static long bfW() {
        return kwm;
    }

    public static final void bfX() {
        AppMethodBeat.m2504i(18697);
        C4990ab.m7416i("MicroMsg.CleanLogic", "startCleanDataNow");
        kwv.removeCallbacksAndMessages(null);
        kwn = 0;
        kwm = 0;
        C27642d.m43922u(null);
        kwy = 0;
        AppMethodBeat.m2505o(18697);
    }

    public static final void bfY() {
        AppMethodBeat.m2504i(18698);
        C4990ab.m7416i("MicroMsg.CleanLogic", "start to post clean runnable!!");
        kwv.removeCallbacksAndMessages(null);
        kwv.postDelayed(new C276431(), 300000);
        AppMethodBeat.m2505o(18698);
    }

    public static final void bfZ() {
        kwy++;
    }

    public static final void bga() {
        kwy--;
    }
}
