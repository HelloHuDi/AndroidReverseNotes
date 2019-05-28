package com.google.android.exoplayer2.p105f.p108g;

import com.google.android.exoplayer2.p105f.C41607f;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.f.g.h */
public final class C17660h {
    private static final Pattern boP = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern boQ = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    static {
        AppMethodBeat.m2504i(95748);
        AppMethodBeat.m2505o(95748);
    }

    /* renamed from: I */
    public static void m27520I(C32065l c32065l) {
        AppMethodBeat.m2504i(95744);
        String readLine = c32065l.readLine();
        if (readLine == null || !boQ.matcher(readLine).matches()) {
            C41607f c41607f = new C41607f("Expected WEBVTT. Got ".concat(String.valueOf(readLine)));
            AppMethodBeat.m2505o(95744);
            throw c41607f;
        }
        AppMethodBeat.m2505o(95744);
    }

    /* renamed from: aD */
    public static long m27522aD(String str) {
        int i = 0;
        AppMethodBeat.m2504i(95745);
        long j = 0;
        String[] split = str.split("\\.", 2);
        String[] split2 = split[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        while (i < split2.length) {
            j = (j * 60) + Long.parseLong(split2[i]);
            i++;
        }
        long parseLong = (Long.parseLong(split[1]) + (j * 1000)) * 1000;
        AppMethodBeat.m2505o(95745);
        return parseLong;
    }

    /* renamed from: aE */
    public static float m27523aE(String str) {
        AppMethodBeat.m2504i(95746);
        if (str.endsWith("%")) {
            float parseFloat = Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
            AppMethodBeat.m2505o(95746);
            return parseFloat;
        }
        NumberFormatException numberFormatException = new NumberFormatException("Percentages must end with %");
        AppMethodBeat.m2505o(95746);
        throw numberFormatException;
    }

    /* renamed from: J */
    public static Matcher m27521J(C32065l c32065l) {
        AppMethodBeat.m2504i(95747);
        while (true) {
            String readLine = c32065l.readLine();
            if (readLine == null) {
                AppMethodBeat.m2505o(95747);
                return null;
            } else if (boP.matcher(readLine).matches()) {
                while (true) {
                    readLine = c32065l.readLine();
                    if (readLine == null || readLine.isEmpty()) {
                        break;
                    }
                }
            } else {
                Matcher matcher = C0861f.boE.matcher(readLine);
                if (matcher.matches()) {
                    AppMethodBeat.m2505o(95747);
                    return matcher;
                }
            }
        }
    }
}
