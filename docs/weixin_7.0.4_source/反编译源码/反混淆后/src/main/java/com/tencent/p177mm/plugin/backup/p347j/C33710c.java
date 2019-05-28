package com.tencent.p177mm.plugin.backup.p347j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C42759b;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C41257a;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p345d.C41258b;

/* renamed from: com.tencent.mm.plugin.backup.j.c */
public final class C33710c {
    private static String TAG = "MicroMsg.BackupModelFactory";

    /* renamed from: rK */
    public static C38634d m55092rK(int i) {
        AppMethodBeat.m2504i(18108);
        C38634d aUB;
        switch (i) {
            case -1:
                aUB = C41257a.aUB();
                AppMethodBeat.m2505o(18108);
                return aUB;
            case 1:
                aUB = C42759b.aTD();
                AppMethodBeat.m2505o(18108);
                return aUB;
            case 2:
                aUB = C41258b.aSZ();
                AppMethodBeat.m2505o(18108);
                return aUB;
            default:
                AppMethodBeat.m2505o(18108);
                return null;
        }
    }
}
