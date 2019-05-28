package com.google.android.exoplayer2.p111i;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.i.i */
public final class C37265i {
    /* renamed from: aH */
    public static boolean m62522aH(String str) {
        AppMethodBeat.m2504i(95880);
        boolean equals = SlookAirButtonRecentMediaAdapter.AUDIO_TYPE.equals(C37265i.m62527aM(str));
        AppMethodBeat.m2505o(95880);
        return equals;
    }

    /* renamed from: aI */
    public static boolean m62523aI(String str) {
        AppMethodBeat.m2504i(95881);
        boolean equals = "video".equals(C37265i.m62527aM(str));
        AppMethodBeat.m2505o(95881);
        return equals;
    }

    /* renamed from: aJ */
    public static boolean m62524aJ(String str) {
        AppMethodBeat.m2504i(95882);
        boolean equals = "text".equals(C37265i.m62527aM(str));
        AppMethodBeat.m2505o(95882);
        return equals;
    }

    /* renamed from: aK */
    public static String m62525aK(String str) {
        AppMethodBeat.m2504i(95883);
        if (str == null) {
            AppMethodBeat.m2505o(95883);
            return null;
        }
        String trim = str.trim();
        String str2;
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            str2 = "video/avc";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            str2 = "video/hevc";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
            str2 = "video/x-vnd.on2.vp9";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
            str2 = "video/x-vnd.on2.vp8";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else if (trim.startsWith("mp4a")) {
            str2 = "audio/mp4a-latm";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            str2 = "audio/ac3";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
            str2 = "audio/eac3";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
            str2 = "audio/vnd.dts";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
            str2 = "audio/vnd.dts.hd";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else if (trim.startsWith("opus")) {
            str2 = "audio/opus";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else if (trim.startsWith("vorbis")) {
            str2 = "audio/vorbis";
            AppMethodBeat.m2505o(95883);
            return str2;
        } else {
            AppMethodBeat.m2505o(95883);
            return null;
        }
    }

    /* renamed from: aL */
    public static int m62526aL(String str) {
        AppMethodBeat.m2504i(95884);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(95884);
            return -1;
        } else if (C37265i.m62522aH(str)) {
            AppMethodBeat.m2505o(95884);
            return 1;
        } else if (C37265i.m62523aI(str)) {
            AppMethodBeat.m2505o(95884);
            return 2;
        } else if (C37265i.m62524aJ(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            AppMethodBeat.m2505o(95884);
            return 3;
        } else if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-camera-motion".equals(str)) {
            AppMethodBeat.m2505o(95884);
            return 4;
        } else {
            AppMethodBeat.m2505o(95884);
            return -1;
        }
    }

    /* renamed from: aM */
    private static String m62527aM(String str) {
        AppMethodBeat.m2504i(95885);
        if (str == null) {
            AppMethodBeat.m2505o(95885);
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid mime type: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(95885);
            throw illegalArgumentException;
        }
        String substring = str.substring(0, indexOf);
        AppMethodBeat.m2505o(95885);
        return substring;
    }
}
