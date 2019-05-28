package com.tencent.p177mm.platformtools;

import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* renamed from: com.tencent.mm.platformtools.SpellMap */
public class SpellMap {
    public static HashMap<String, String> ghK = new HashMap();

    public static native String spellGetJni(int i, int i2);

    /* renamed from: r */
    public static String m42342r(char c) {
        AppMethodBeat.m2504i(58733);
        int s = SpellMap.m42343s(c);
        String valueOf;
        if (s < 65536) {
            valueOf = String.valueOf(c);
            AppMethodBeat.m2505o(58733);
            return valueOf;
        }
        String str;
        int i = s >> 16;
        s &= 255;
        if (i < GmsClientSupervisor.DEFAULT_BIND_FLAGS || i > C31128d.MIC_PTU_ZIPAI_OKINAWA) {
            str = null;
        } else if (s < 63 || s > C31128d.MIC_PTU_ZIPAI_LIGHTRED) {
            str = null;
        } else {
            str = SpellMap.spellGetJni(i - 129, s - 63);
        }
        if (str == null) {
            AppMethodBeat.m2505o(58733);
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length < 2) {
            AppMethodBeat.m2505o(58733);
            return str;
        }
        valueOf = split[0];
        AppMethodBeat.m2505o(58733);
        return valueOf;
    }

    /* renamed from: s */
    private static int m42343s(char c) {
        AppMethodBeat.m2504i(58734);
        if (c <= 128) {
            AppMethodBeat.m2505o(58734);
            return c;
        }
        try {
            byte[] bytes = String.valueOf(c).getBytes("GBK");
            int i;
            if (bytes == null || bytes.length > 2 || bytes.length <= 0) {
                AppMethodBeat.m2505o(58734);
                return 0;
            } else if (bytes.length == 1) {
                i = bytes[0];
                AppMethodBeat.m2505o(58734);
                return i;
            } else if (bytes.length == 2) {
                i = ((bytes[0] + 256) << 16) + (bytes[1] + 256);
                AppMethodBeat.m2505o(58734);
                return i;
            } else {
                AppMethodBeat.m2505o(58734);
                return 0;
            }
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.m2505o(58734);
            return 0;
        }
    }

    static {
        AppMethodBeat.m2504i(58735);
        AppMethodBeat.m2505o(58735);
    }
}
