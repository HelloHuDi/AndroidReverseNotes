package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.h.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import java.nio.charset.Charset;

public final class k {
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static i h(a aVar) {
        Exception exception;
        i iVar;
        AppMethodBeat.i(35889);
        i iVar2 = new i();
        g.RQ();
        String str = (String) g.RP().Ry().get(aVar, null);
        if (str == null) {
            ab.i("MicroMsg.RedDotUtil", "load: redDotList data empty");
            AppMethodBeat.o(35889);
            return iVar2;
        }
        i iVar3;
        try {
            iVar3 = (i) new i().parseFrom(str.getBytes(Charset.forName("ISO-8859-1")));
            if (iVar3 == null) {
                try {
                    iVar3 = new i();
                } catch (Exception e) {
                    exception = e;
                    iVar = iVar3;
                    ab.e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
                    iVar3 = iVar;
                    if (iVar3 == null) {
                    }
                    AppMethodBeat.o(35889);
                    return iVar3;
                }
            }
        } catch (Exception e2) {
            exception = e2;
            iVar = iVar2;
            ab.e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
            iVar3 = iVar;
            if (iVar3 == null) {
            }
            AppMethodBeat.o(35889);
            return iVar3;
        }
        if (iVar3 == null) {
            iVar3 = new i();
        }
        AppMethodBeat.o(35889);
        return iVar3;
    }
}
