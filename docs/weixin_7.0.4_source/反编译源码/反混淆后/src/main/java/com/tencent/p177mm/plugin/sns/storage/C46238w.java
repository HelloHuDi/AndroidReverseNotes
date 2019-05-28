package com.tencent.p177mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.w */
public final class C46238w {
    public boolean rfK = false;

    /* renamed from: a */
    public static boolean m86493a(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(38029);
        try {
            if (C5046bo.isNullOrNil(c7480h.getKey())) {
                c7480h2.mo10108hY("", "ATTACH DATABASE '" + c7480h.getPath() + "' AS old ");
            } else {
                c7480h2.mo10108hY("", "ATTACH DATABASE '" + c7480h.getPath() + "' AS old KEY '" + c7480h.getKey() + "'");
            }
            C4990ab.m7416i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + c7480h.getKey());
            AppMethodBeat.m2505o(38029);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.TrimSnsDb", e, "", new Object[0]);
            AppMethodBeat.m2505o(38029);
            return false;
        }
    }

    /* renamed from: a */
    public static int m86492a(C7480h c7480h, C7480h c7480h2, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(38030);
        Cursor a = c7480h.mo10104a(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
        if (a != null) {
            if (a.getCount() == 1) {
                a.moveToFirst();
                str2 = a.getString(0);
            }
            a.close();
        }
        if (str2 == null) {
            C4990ab.m7420w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
            AppMethodBeat.m2505o(38030);
            return -1;
        }
        C4990ab.m7417i("MicroMsg.TrimSnsDb", "create sql %s", str2);
        C4990ab.m7416i("MicroMsg.TrimSnsDb", "create result ".concat(String.valueOf(c7480h2.mo10108hY("", str2))));
        AppMethodBeat.m2505o(38030);
        return 1;
    }

    /* renamed from: Zq */
    public static void m86491Zq(String str) {
        AppMethodBeat.m2504i(38031);
        List<C5712a> cl = C5730e.m8627cl(str, false);
        if (cl == null) {
            AppMethodBeat.m2505o(38031);
            return;
        }
        for (C5712a c5712a : cl) {
            if (c5712a.name.startsWith("SnsMicroMsg.dberr")) {
                C4990ab.m7417i("MicroMsg.TrimSnsDb", "find error %s", str + c5712a.name);
                c5712a.delete();
            }
        }
        AppMethodBeat.m2505o(38031);
    }
}
