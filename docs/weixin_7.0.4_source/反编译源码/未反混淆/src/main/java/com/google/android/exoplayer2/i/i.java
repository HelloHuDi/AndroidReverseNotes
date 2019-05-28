package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public static boolean aH(String str) {
        AppMethodBeat.i(95880);
        boolean equals = SlookAirButtonRecentMediaAdapter.AUDIO_TYPE.equals(aM(str));
        AppMethodBeat.o(95880);
        return equals;
    }

    public static boolean aI(String str) {
        AppMethodBeat.i(95881);
        boolean equals = "video".equals(aM(str));
        AppMethodBeat.o(95881);
        return equals;
    }

    public static boolean aJ(String str) {
        AppMethodBeat.i(95882);
        boolean equals = "text".equals(aM(str));
        AppMethodBeat.o(95882);
        return equals;
    }

    public static String aK(String str) {
        AppMethodBeat.i(95883);
        if (str == null) {
            AppMethodBeat.o(95883);
            return null;
        }
        String trim = str.trim();
        String str2;
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            str2 = "video/avc";
            AppMethodBeat.o(95883);
            return str2;
        } else if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            str2 = "video/hevc";
            AppMethodBeat.o(95883);
            return str2;
        } else if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
            str2 = "video/x-vnd.on2.vp9";
            AppMethodBeat.o(95883);
            return str2;
        } else if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
            str2 = "video/x-vnd.on2.vp8";
            AppMethodBeat.o(95883);
            return str2;
        } else if (trim.startsWith("mp4a")) {
            str2 = "audio/mp4a-latm";
            AppMethodBeat.o(95883);
            return str2;
        } else if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            str2 = "audio/ac3";
            AppMethodBeat.o(95883);
            return str2;
        } else if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
            str2 = "audio/eac3";
            AppMethodBeat.o(95883);
            return str2;
        } else if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
            str2 = "audio/vnd.dts";
            AppMethodBeat.o(95883);
            return str2;
        } else if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
            str2 = "audio/vnd.dts.hd";
            AppMethodBeat.o(95883);
            return str2;
        } else if (trim.startsWith("opus")) {
            str2 = "audio/opus";
            AppMethodBeat.o(95883);
            return str2;
        } else if (trim.startsWith("vorbis")) {
            str2 = "audio/vorbis";
            AppMethodBeat.o(95883);
            return str2;
        } else {
            AppMethodBeat.o(95883);
            return null;
        }
    }

    public static int aL(String str) {
        AppMethodBeat.i(95884);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(95884);
            return -1;
        } else if (aH(str)) {
            AppMethodBeat.o(95884);
            return 1;
        } else if (aI(str)) {
            AppMethodBeat.o(95884);
            return 2;
        } else if (aJ(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            AppMethodBeat.o(95884);
            return 3;
        } else if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-camera-motion".equals(str)) {
            AppMethodBeat.o(95884);
            return 4;
        } else {
            AppMethodBeat.o(95884);
            return -1;
        }
    }

    private static String aM(String str) {
        AppMethodBeat.i(95885);
        if (str == null) {
            AppMethodBeat.o(95885);
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid mime type: ".concat(String.valueOf(str)));
            AppMethodBeat.o(95885);
            throw illegalArgumentException;
        }
        String substring = str.substring(0, indexOf);
        AppMethodBeat.o(95885);
        return substring;
    }
}
