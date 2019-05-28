package com.tencent.mm.plugin.expt.hellhound.core.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;

public final class b {
    public static void v(String str, byte[] bArr) {
        AppMethodBeat.i(73352);
        if (TextUtils.isEmpty(str) || bArr == null) {
            AppMethodBeat.o(73352);
            return;
        }
        as.amF("_hellhound_mmkv").encode(str, bArr);
        AppMethodBeat.o(73352);
    }

    public static byte[] getBytes(String str) {
        AppMethodBeat.i(73353);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(73353);
            return null;
        }
        byte[] decodeBytes = as.amF("_hellhound_mmkv").decodeBytes(str);
        AppMethodBeat.o(73353);
        return decodeBytes;
    }

    public static void putInt(String str, int i) {
        AppMethodBeat.i(73354);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(73354);
            return;
        }
        as.amF("_hellhound_mmkv").putInt(str, i);
        AppMethodBeat.o(73354);
    }
}
