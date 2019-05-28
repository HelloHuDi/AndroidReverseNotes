package com.tencent.p177mm.opensdk.channel.p1213a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.utils.C18750b;

/* renamed from: com.tencent.mm.opensdk.channel.a.b */
public final class C18744b {
    /* renamed from: a */
    public static byte[] m29297a(String str, int i, String str2) {
        AppMethodBeat.m2504i(128138);
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = C18750b.m29302c(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
        AppMethodBeat.m2505o(128138);
        return bytes;
    }
}
