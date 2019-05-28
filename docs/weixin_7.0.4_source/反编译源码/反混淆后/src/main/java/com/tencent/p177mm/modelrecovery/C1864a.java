package com.tencent.p177mm.modelrecovery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.rtmp.sharp.jni.QLog;
import java.io.IOException;

/* renamed from: com.tencent.mm.modelrecovery.a */
public final class C1864a {
    public static void aiz() {
        AppMethodBeat.m2504i(16543);
        C5728b c5728b = new C5728b(C4996ah.getContext().getFilesDir(), "/recovery/recovery.log");
        String str = null;
        if (c5728b.exists() && c5728b.length() > 0) {
            try {
                str = C5730e.m8631cy(C5736j.m8649w(c5728b.dMD()));
                c5728b.delete();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Recovery.RecoveryLogUtil", e, "recoveryLog", new Object[0]);
            }
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.Recovery.RecoveryLogUtil", "not found recovery log");
            AppMethodBeat.m2505o(16543);
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
                        C4990ab.m7412e(split[1], split[2]);
                        break;
                    default:
                        C4990ab.m7416i(split[1], split[2]);
                        break;
                }
            }
            C4990ab.m7416i("MicroMsg.Recovery.RecoveryLogUtil", str2);
        }
        AppMethodBeat.m2505o(16543);
    }
}
