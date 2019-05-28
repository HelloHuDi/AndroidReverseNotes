package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static a hGh;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(94341);
        if (hGh != null) {
            String.format(str2, objArr);
            hGh.e(str, str2, objArr);
        }
        AppMethodBeat.o(94341);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(94342);
        if (hGh != null) {
            String.format(str2, objArr);
            hGh.w(str, str2, objArr);
        }
        AppMethodBeat.o(94342);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(94343);
        if (hGh != null) {
            String.format(str2, objArr);
            hGh.i(str, str2, objArr);
        }
        AppMethodBeat.o(94343);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(94344);
        if (hGh != null) {
            String.format(str2, objArr);
            hGh.d(str, str2, objArr);
        }
        AppMethodBeat.o(94344);
    }
}
