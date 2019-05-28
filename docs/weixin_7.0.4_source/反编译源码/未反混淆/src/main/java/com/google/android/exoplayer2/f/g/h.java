package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {
    private static final Pattern boP = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern boQ = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    static {
        AppMethodBeat.i(95748);
        AppMethodBeat.o(95748);
    }

    public static void I(l lVar) {
        AppMethodBeat.i(95744);
        String readLine = lVar.readLine();
        if (readLine == null || !boQ.matcher(readLine).matches()) {
            f fVar = new f("Expected WEBVTT. Got ".concat(String.valueOf(readLine)));
            AppMethodBeat.o(95744);
            throw fVar;
        }
        AppMethodBeat.o(95744);
    }

    public static long aD(String str) {
        int i = 0;
        AppMethodBeat.i(95745);
        long j = 0;
        String[] split = str.split("\\.", 2);
        String[] split2 = split[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        while (i < split2.length) {
            j = (j * 60) + Long.parseLong(split2[i]);
            i++;
        }
        long parseLong = (Long.parseLong(split[1]) + (j * 1000)) * 1000;
        AppMethodBeat.o(95745);
        return parseLong;
    }

    public static float aE(String str) {
        AppMethodBeat.i(95746);
        if (str.endsWith("%")) {
            float parseFloat = Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
            AppMethodBeat.o(95746);
            return parseFloat;
        }
        NumberFormatException numberFormatException = new NumberFormatException("Percentages must end with %");
        AppMethodBeat.o(95746);
        throw numberFormatException;
    }

    public static Matcher J(l lVar) {
        AppMethodBeat.i(95747);
        while (true) {
            String readLine = lVar.readLine();
            if (readLine == null) {
                AppMethodBeat.o(95747);
                return null;
            } else if (boP.matcher(readLine).matches()) {
                while (true) {
                    readLine = lVar.readLine();
                    if (readLine == null || readLine.isEmpty()) {
                        break;
                    }
                }
            } else {
                Matcher matcher = f.boE.matcher(readLine);
                if (matcher.matches()) {
                    AppMethodBeat.o(95747);
                    return matcher;
                }
            }
        }
    }
}
