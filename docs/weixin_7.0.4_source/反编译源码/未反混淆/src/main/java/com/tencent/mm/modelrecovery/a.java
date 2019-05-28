package com.tencent.mm.modelrecovery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.rtmp.sharp.jni.QLog;
import java.io.IOException;

public final class a {
    public static void aiz() {
        AppMethodBeat.i(16543);
        b bVar = new b(ah.getContext().getFilesDir(), "/recovery/recovery.log");
        String str = null;
        if (bVar.exists() && bVar.length() > 0) {
            try {
                str = e.cy(j.w(bVar.dMD()));
                bVar.delete();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.Recovery.RecoveryLogUtil", e, "recoveryLog", new Object[0]);
            }
        }
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.Recovery.RecoveryLogUtil", "not found recovery log");
            AppMethodBeat.o(16543);
            return;
        }
        for (String str2 : str2.split("​​")) {
            String[] split = str2.split("​");
            if (split != null && split.length == 3) {
                String str3 = split[0];
                int i = -1;
                switch (str3.hashCode()) {
                    case 69:
                        if (str3.equals(QLog.TAG_REPORTLEVEL_USER)) {
                            i = 0;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        ab.e(split[1], split[2]);
                        break;
                    default:
                        ab.i(split[1], split[2]);
                        break;
                }
            }
            ab.i("MicroMsg.Recovery.RecoveryLogUtil", str2);
        }
        AppMethodBeat.o(16543);
    }
}
