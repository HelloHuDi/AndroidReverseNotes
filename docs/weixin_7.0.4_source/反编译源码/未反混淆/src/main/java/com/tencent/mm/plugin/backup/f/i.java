package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class i {

    public static class a {
        int cyQ;
        String filePath;
        gu jvB;
        LinkedList<u> jvC;
        boolean jvD = true;
        String jvE;
        boolean jvF;
        u jvy;

        public a(String str, gu guVar, LinkedList<u> linkedList, int i, boolean z, boolean z2, u uVar) {
            this.filePath = str;
            this.jvB = guVar;
            this.jvC = linkedList;
            this.cyQ = i;
            this.jvD = z;
            this.jvF = z2;
            this.jvy = uVar;
        }

        public a(String str, gu guVar, LinkedList<u> linkedList, int i, boolean z, String str2, boolean z2) {
            this.filePath = str;
            this.jvB = guVar;
            this.jvC = linkedList;
            this.cyQ = i;
            this.jvD = z;
            this.jvE = str2;
            this.jvF = z2;
            this.jvy = null;
        }
    }

    public static int a(a aVar) {
        AppMethodBeat.i(17468);
        if (aVar.jvB == null) {
            ab.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", "backupItemInfo.backupitem");
            AppMethodBeat.o(17468);
            return 0;
        }
        int asZ = (int) e.asZ(aVar.filePath);
        if (asZ <= 0) {
            ab.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + aVar.filePath);
            AppMethodBeat.o(17468);
            return 0;
        } else if (aVar.jvD) {
            AppMethodBeat.o(17468);
            return asZ;
        } else if (aVar.jvC == null) {
            ab.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
            AppMethodBeat.o(17468);
            return 0;
        } else {
            String str = aVar.jvB.vEB.toString() + "_" + aVar.jvB.vEC.toString() + "_" + aVar.jvB.ptF + "_backup" + (aVar.jvE == null ? "" : aVar.jvE);
            ab.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", str, aVar.filePath);
            aVar.jvB.vJb.add(new bts().alV(str));
            aVar.jvB.vJc.add(new btt().LQ(aVar.cyQ));
            aVar.jvB.vJa = aVar.jvB.vJb.size();
            if (aVar.jvy == null) {
                aVar.jvy = new u();
            }
            aVar.jvy.jCr = aVar.jvB.ptF;
            aVar.jvy.cHr = str;
            aVar.jvy.path = aVar.filePath;
            aVar.jvy.type = aVar.cyQ;
            if (!aVar.jvF) {
                aVar.jvC.add(aVar.jvy);
            }
            AppMethodBeat.o(17468);
            return 0;
        }
    }
}
