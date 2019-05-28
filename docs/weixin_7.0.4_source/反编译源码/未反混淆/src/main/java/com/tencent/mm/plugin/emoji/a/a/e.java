package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionSummary;

public final class e {
    public static boolean a(EmotionSummary emotionSummary) {
        AppMethodBeat.i(52797);
        if (emotionSummary == null) {
            AppMethodBeat.o(52797);
            return false;
        }
        boolean dR = dR(emotionSummary.PackFlag, 1);
        AppMethodBeat.o(52797);
        return dR;
    }

    public static boolean b(EmotionSummary emotionSummary) {
        AppMethodBeat.i(52798);
        if (c(emotionSummary) || d(emotionSummary)) {
            AppMethodBeat.o(52798);
            return true;
        }
        AppMethodBeat.o(52798);
        return false;
    }

    private static boolean c(EmotionSummary emotionSummary) {
        AppMethodBeat.i(52800);
        if (emotionSummary == null) {
            AppMethodBeat.o(52800);
            return false;
        }
        boolean dR = dR(emotionSummary.PackType, 4);
        AppMethodBeat.o(52800);
        return dR;
    }

    private static boolean d(EmotionSummary emotionSummary) {
        AppMethodBeat.i(52801);
        if (emotionSummary == null) {
            AppMethodBeat.o(52801);
            return false;
        }
        boolean dR = dR(emotionSummary.PackType, 8);
        AppMethodBeat.o(52801);
        return dR;
    }

    public static boolean e(EmotionSummary emotionSummary) {
        AppMethodBeat.i(52802);
        if (emotionSummary == null) {
            AppMethodBeat.o(52802);
            return false;
        }
        boolean dR = dR(emotionSummary.PackFlag, 8);
        AppMethodBeat.o(52802);
        return dR;
    }

    public static boolean dR(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean uc(int i) {
        AppMethodBeat.i(52799);
        if (dR(i, 4) || dR(i, 8)) {
            AppMethodBeat.o(52799);
            return true;
        }
        AppMethodBeat.o(52799);
        return false;
    }
}
