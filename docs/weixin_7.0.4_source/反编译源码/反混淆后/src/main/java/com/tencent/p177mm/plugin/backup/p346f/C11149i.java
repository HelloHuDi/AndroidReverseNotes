package com.tencent.p177mm.plugin.backup.p346f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.btt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.f.i */
public final class C11149i {

    /* renamed from: com.tencent.mm.plugin.backup.f.i$a */
    public static class C11150a {
        int cyQ;
        String filePath;
        C40522gu jvB;
        LinkedList<C19993u> jvC;
        boolean jvD = true;
        String jvE;
        boolean jvF;
        C19993u jvy;

        public C11150a(String str, C40522gu c40522gu, LinkedList<C19993u> linkedList, int i, boolean z, boolean z2, C19993u c19993u) {
            this.filePath = str;
            this.jvB = c40522gu;
            this.jvC = linkedList;
            this.cyQ = i;
            this.jvD = z;
            this.jvF = z2;
            this.jvy = c19993u;
        }

        public C11150a(String str, C40522gu c40522gu, LinkedList<C19993u> linkedList, int i, boolean z, String str2, boolean z2) {
            this.filePath = str;
            this.jvB = c40522gu;
            this.jvC = linkedList;
            this.cyQ = i;
            this.jvD = z;
            this.jvE = str2;
            this.jvF = z2;
            this.jvy = null;
        }
    }

    /* renamed from: a */
    public static int m18856a(C11150a c11150a) {
        AppMethodBeat.m2504i(17468);
        if (c11150a.jvB == null) {
            C4990ab.m7413e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", "backupItemInfo.backupitem");
            AppMethodBeat.m2505o(17468);
            return 0;
        }
        int asZ = (int) C5730e.asZ(c11150a.filePath);
        if (asZ <= 0) {
            C4990ab.m7412e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + c11150a.filePath);
            AppMethodBeat.m2505o(17468);
            return 0;
        } else if (c11150a.jvD) {
            AppMethodBeat.m2505o(17468);
            return asZ;
        } else if (c11150a.jvC == null) {
            C4990ab.m7412e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
            AppMethodBeat.m2505o(17468);
            return 0;
        } else {
            String str = c11150a.jvB.vEB.toString() + "_" + c11150a.jvB.vEC.toString() + "_" + c11150a.jvB.ptF + "_backup" + (c11150a.jvE == null ? "" : c11150a.jvE);
            C4990ab.m7411d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", str, c11150a.filePath);
            c11150a.jvB.vJb.add(new bts().alV(str));
            c11150a.jvB.vJc.add(new btt().mo64053LQ(c11150a.cyQ));
            c11150a.jvB.vJa = c11150a.jvB.vJb.size();
            if (c11150a.jvy == null) {
                c11150a.jvy = new C19993u();
            }
            c11150a.jvy.jCr = c11150a.jvB.ptF;
            c11150a.jvy.cHr = str;
            c11150a.jvy.path = c11150a.filePath;
            c11150a.jvy.type = c11150a.cyQ;
            if (!c11150a.jvF) {
                c11150a.jvC.add(c11150a.jvy);
            }
            AppMethodBeat.m2505o(17468);
            return 0;
        }
    }
}
