package com.tencent.p177mm.plugin.emoji.p381a.p946a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;

/* renamed from: com.tencent.mm.plugin.emoji.a.a.e */
public final class C27727e {
    /* renamed from: a */
    public static boolean m44036a(EmotionSummary emotionSummary) {
        AppMethodBeat.m2504i(52797);
        if (emotionSummary == null) {
            AppMethodBeat.m2505o(52797);
            return false;
        }
        boolean dR = C27727e.m44040dR(emotionSummary.PackFlag, 1);
        AppMethodBeat.m2505o(52797);
        return dR;
    }

    /* renamed from: b */
    public static boolean m44037b(EmotionSummary emotionSummary) {
        AppMethodBeat.m2504i(52798);
        if (C27727e.m44038c(emotionSummary) || C27727e.m44039d(emotionSummary)) {
            AppMethodBeat.m2505o(52798);
            return true;
        }
        AppMethodBeat.m2505o(52798);
        return false;
    }

    /* renamed from: c */
    private static boolean m44038c(EmotionSummary emotionSummary) {
        AppMethodBeat.m2504i(52800);
        if (emotionSummary == null) {
            AppMethodBeat.m2505o(52800);
            return false;
        }
        boolean dR = C27727e.m44040dR(emotionSummary.PackType, 4);
        AppMethodBeat.m2505o(52800);
        return dR;
    }

    /* renamed from: d */
    private static boolean m44039d(EmotionSummary emotionSummary) {
        AppMethodBeat.m2504i(52801);
        if (emotionSummary == null) {
            AppMethodBeat.m2505o(52801);
            return false;
        }
        boolean dR = C27727e.m44040dR(emotionSummary.PackType, 8);
        AppMethodBeat.m2505o(52801);
        return dR;
    }

    /* renamed from: e */
    public static boolean m44041e(EmotionSummary emotionSummary) {
        AppMethodBeat.m2504i(52802);
        if (emotionSummary == null) {
            AppMethodBeat.m2505o(52802);
            return false;
        }
        boolean dR = C27727e.m44040dR(emotionSummary.PackFlag, 8);
        AppMethodBeat.m2505o(52802);
        return dR;
    }

    /* renamed from: dR */
    public static boolean m44040dR(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: uc */
    public static boolean m44042uc(int i) {
        AppMethodBeat.m2504i(52799);
        if (C27727e.m44040dR(i, 4) || C27727e.m44040dR(i, 8)) {
            AppMethodBeat.m2505o(52799);
            return true;
        }
        AppMethodBeat.m2505o(52799);
        return false;
    }
}
