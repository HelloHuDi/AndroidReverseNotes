package com.tencent.mm.platformtools;

import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class SpellMap {
    public static HashMap<String, String> ghK = new HashMap();

    public static native String spellGetJni(int i, int i2);

    public static String r(char c) {
        AppMethodBeat.i(58733);
        int s = s(c);
        String valueOf;
        if (s < 65536) {
            valueOf = String.valueOf(c);
            AppMethodBeat.o(58733);
            return valueOf;
        }
        String str;
        int i = s >> 16;
        s &= 255;
        if (i < GmsClientSupervisor.DEFAULT_BIND_FLAGS || i > d.MIC_PTU_ZIPAI_OKINAWA) {
            str = null;
        } else if (s < 63 || s > d.MIC_PTU_ZIPAI_LIGHTRED) {
            str = null;
        } else {
            str = spellGetJni(i - 129, s - 63);
        }
        if (str == null) {
            AppMethodBeat.o(58733);
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length < 2) {
            AppMethodBeat.o(58733);
            return str;
        }
        valueOf = split[0];
        AppMethodBeat.o(58733);
        return valueOf;
    }

    private static int s(char c) {
        AppMethodBeat.i(58734);
        if (c <= 128) {
            AppMethodBeat.o(58734);
            return c;
        }
        try {
            byte[] bytes = String.valueOf(c).getBytes("GBK");
            int i;
            if (bytes == null || bytes.length > 2 || bytes.length <= 0) {
                AppMethodBeat.o(58734);
                return 0;
            } else if (bytes.length == 1) {
                i = bytes[0];
                AppMethodBeat.o(58734);
                return i;
            } else if (bytes.length == 2) {
                i = ((bytes[0] + 256) << 16) + (bytes[1] + 256);
                AppMethodBeat.o(58734);
                return i;
            } else {
                AppMethodBeat.o(58734);
                return 0;
            }
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.o(58734);
            return 0;
        }
    }

    static {
        AppMethodBeat.i(58735);
        AppMethodBeat.o(58735);
    }
}
