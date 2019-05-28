package com.tencent.p177mm.plugin.expt.hellhound.core.p1258a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5018as;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.a.b */
public final class C20599b {
    /* renamed from: v */
    public static void m31826v(String str, byte[] bArr) {
        AppMethodBeat.m2504i(73352);
        if (TextUtils.isEmpty(str) || bArr == null) {
            AppMethodBeat.m2505o(73352);
            return;
        }
        C5018as.amF("_hellhound_mmkv").encode(str, bArr);
        AppMethodBeat.m2505o(73352);
    }

    public static byte[] getBytes(String str) {
        AppMethodBeat.m2504i(73353);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(73353);
            return null;
        }
        byte[] decodeBytes = C5018as.amF("_hellhound_mmkv").decodeBytes(str);
        AppMethodBeat.m2505o(73353);
        return decodeBytes;
    }

    public static void putInt(String str, int i) {
        AppMethodBeat.m2504i(73354);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(73354);
            return;
        }
        C5018as.amF("_hellhound_mmkv").putInt(str, i);
        AppMethodBeat.m2505o(73354);
    }
}
