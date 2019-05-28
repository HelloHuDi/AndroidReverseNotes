package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

public final class c {
    private static String TAG = "MicroMsg.BackupModelFactory";

    public static d rK(int i) {
        AppMethodBeat.i(18108);
        d aUB;
        switch (i) {
            case -1:
                aUB = a.aUB();
                AppMethodBeat.o(18108);
                return aUB;
            case 1:
                aUB = b.aTD();
                AppMethodBeat.o(18108);
                return aUB;
            case 2:
                aUB = com.tencent.mm.plugin.backup.d.b.aSZ();
                AppMethodBeat.o(18108);
                return aUB;
            default:
                AppMethodBeat.o(18108);
                return null;
        }
    }
}
