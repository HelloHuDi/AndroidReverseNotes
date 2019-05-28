package com.tencent.mm.opensdk.channel.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static byte[] a(String str, int i, String str2) {
        AppMethodBeat.i(128138);
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = com.tencent.mm.opensdk.utils.b.c(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
        AppMethodBeat.o(128138);
        return bytes;
    }
}
