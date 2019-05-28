package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

/* renamed from: com.tencent.mm.wallet_core.c.x */
public final class C36379x {
    private static boolean AfR = false;
    private static int AfS = -1;
    private static String AfT = "";

    public static boolean dNS() {
        return AfR;
    }

    public static int dNT() {
        return AfS;
    }

    public static String dNU() {
        return AfT;
    }

    /* renamed from: QN */
    public static void m59950QN(int i) {
        AppMethodBeat.m2504i(49086);
        if (!AfR) {
            AfR = true;
            AfS = i;
            AfT = UUID.randomUUID().toString();
        }
        AppMethodBeat.m2505o(49086);
    }

    public static void dNV() {
        AfR = false;
        AfS = -1;
        AfT = "";
    }
}
