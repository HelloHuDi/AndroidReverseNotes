package com.tencent.p177mm.plugin.p1014q;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.q.g */
public final class C43398g {
    public static String bQX() {
        AppMethodBeat.m2504i(22916);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.m29068Rt()).append("msgsynchronize/syncFile/").toString();
        AppMethodBeat.m2505o(22916);
        return stringBuilder2;
    }

    public static String bQY() {
        AppMethodBeat.m2504i(22917);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.m29068Rt()).append("msgsynchronize/").toString();
        AppMethodBeat.m2505o(22917);
        return stringBuilder2;
    }

    public static String bQZ() {
        AppMethodBeat.m2504i(22918);
        String stringBuilder;
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            C9638aw.m17190ZK();
            stringBuilder = stringBuilder2.append(C18628c.m29068Rt()).append("msgsynchronize.zip").toString();
            C5728b c5728b = new C5728b(stringBuilder);
            if (!c5728b.exists()) {
                c5728b.createNewFile();
            }
            AppMethodBeat.m2505o(22918);
            return stringBuilder;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", e, "", new Object[0]);
            stringBuilder = "";
            AppMethodBeat.m2505o(22918);
            return stringBuilder;
        }
    }

    /* renamed from: f */
    public static void m77455f(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(22919);
        if (TextUtils.isEmpty(str) || bArr == null) {
            C4990ab.m7413e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", str, str2);
            AppMethodBeat.m2505o(22919);
            return;
        }
        int i = 3;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                long EY = C38635g.m65501EY(str + str2);
                i = C43398g.m77456g(str, str2, bArr);
                long EY2 = C38635g.m65501EY(str + str2);
                if (i != 0 || EY2 < ((long) bArr.length)) {
                    C4990ab.m7413e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(EY), Long.valueOf(EY2), Integer.valueOf(bArr.length));
                    i = i2;
                } else {
                    AppMethodBeat.m2505o(22919);
                    return;
                }
            }
            AppMethodBeat.m2505o(22919);
            return;
        }
    }

    /* renamed from: g */
    private static int m77456g(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(22920);
        try {
            C5728b c5728b = new C5728b(str);
            if (!c5728b.exists()) {
                c5728b.mkdirs();
            }
            String str3 = str + "/" + str2;
            C5728b c5728b2 = new C5728b(str3);
            if (!c5728b2.exists()) {
                c5728b2.createNewFile();
            }
            int a = C5730e.m8619a(str3, bArr, bArr.length);
            AppMethodBeat.m2505o(22920);
            return a;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(22920);
            return -1;
        }
    }
}
