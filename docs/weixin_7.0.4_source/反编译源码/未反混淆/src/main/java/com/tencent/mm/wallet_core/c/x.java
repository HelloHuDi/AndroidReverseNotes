package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class x {
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

    public static void QN(int i) {
        AppMethodBeat.i(49086);
        if (!AfR) {
            AfR = true;
            AfS = i;
            AfT = UUID.randomUUID().toString();
        }
        AppMethodBeat.o(49086);
    }

    public static void dNV() {
        AfR = false;
        AfS = -1;
        AfT = "";
    }
}
