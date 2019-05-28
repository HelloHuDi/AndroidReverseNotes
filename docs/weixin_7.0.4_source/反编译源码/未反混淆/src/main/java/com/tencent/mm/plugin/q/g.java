package com.tencent.mm.plugin.q;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;

public final class g {
    public static String bQX() {
        AppMethodBeat.i(22916);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(c.Rt()).append("msgsynchronize/syncFile/").toString();
        AppMethodBeat.o(22916);
        return stringBuilder2;
    }

    public static String bQY() {
        AppMethodBeat.i(22917);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(c.Rt()).append("msgsynchronize/").toString();
        AppMethodBeat.o(22917);
        return stringBuilder2;
    }

    public static String bQZ() {
        AppMethodBeat.i(22918);
        String stringBuilder;
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            aw.ZK();
            stringBuilder = stringBuilder2.append(c.Rt()).append("msgsynchronize.zip").toString();
            b bVar = new b(stringBuilder);
            if (!bVar.exists()) {
                bVar.createNewFile();
            }
            AppMethodBeat.o(22918);
            return stringBuilder;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", e, "", new Object[0]);
            stringBuilder = "";
            AppMethodBeat.o(22918);
            return stringBuilder;
        }
    }

    public static void f(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(22919);
        if (TextUtils.isEmpty(str) || bArr == null) {
            ab.e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", str, str2);
            AppMethodBeat.o(22919);
            return;
        }
        int i = 3;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                long EY = com.tencent.mm.plugin.backup.b.g.EY(str + str2);
                i = g(str, str2, bArr);
                long EY2 = com.tencent.mm.plugin.backup.b.g.EY(str + str2);
                if (i != 0 || EY2 < ((long) bArr.length)) {
                    ab.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(EY), Long.valueOf(EY2), Integer.valueOf(bArr.length));
                    i = i2;
                } else {
                    AppMethodBeat.o(22919);
                    return;
                }
            }
            AppMethodBeat.o(22919);
            return;
        }
    }

    private static int g(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(22920);
        try {
            b bVar = new b(str);
            if (!bVar.exists()) {
                bVar.mkdirs();
            }
            String str3 = str + "/" + str2;
            b bVar2 = new b(str3);
            if (!bVar2.exists()) {
                bVar2.createNewFile();
            }
            int a = e.a(str3, bArr, bArr.length);
            AppMethodBeat.o(22920);
            return a;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", e, "", new Object[0]);
            AppMethodBeat.o(22920);
            return -1;
        }
    }
}
