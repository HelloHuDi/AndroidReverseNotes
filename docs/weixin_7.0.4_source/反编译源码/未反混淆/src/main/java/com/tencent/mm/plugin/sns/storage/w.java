package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.e;
import java.util.List;

public final class w {
    public boolean rfK = false;

    public static boolean a(h hVar, h hVar2) {
        AppMethodBeat.i(38029);
        try {
            if (bo.isNullOrNil(hVar.getKey())) {
                hVar2.hY("", "ATTACH DATABASE '" + hVar.getPath() + "' AS old ");
            } else {
                hVar2.hY("", "ATTACH DATABASE '" + hVar.getPath() + "' AS old KEY '" + hVar.getKey() + "'");
            }
            ab.i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + hVar.getKey());
            AppMethodBeat.o(38029);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", e.getMessage());
            ab.printErrStackTrace("MicroMsg.TrimSnsDb", e, "", new Object[0]);
            AppMethodBeat.o(38029);
            return false;
        }
    }

    public static int a(h hVar, h hVar2, String str) {
        String str2 = null;
        AppMethodBeat.i(38030);
        Cursor a = hVar.a(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
        if (a != null) {
            if (a.getCount() == 1) {
                a.moveToFirst();
                str2 = a.getString(0);
            }
            a.close();
        }
        if (str2 == null) {
            ab.w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
            AppMethodBeat.o(38030);
            return -1;
        }
        ab.i("MicroMsg.TrimSnsDb", "create sql %s", str2);
        ab.i("MicroMsg.TrimSnsDb", "create result ".concat(String.valueOf(hVar2.hY("", str2))));
        AppMethodBeat.o(38030);
        return 1;
    }

    public static void Zq(String str) {
        AppMethodBeat.i(38031);
        List<a> cl = e.cl(str, false);
        if (cl == null) {
            AppMethodBeat.o(38031);
            return;
        }
        for (a aVar : cl) {
            if (aVar.name.startsWith("SnsMicroMsg.dberr")) {
                ab.i("MicroMsg.TrimSnsDb", "find error %s", str + aVar.name);
                aVar.delete();
            }
        }
        AppMethodBeat.o(38031);
    }
}
