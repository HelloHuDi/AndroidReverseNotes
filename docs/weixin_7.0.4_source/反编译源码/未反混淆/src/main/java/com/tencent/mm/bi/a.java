package com.tencent.mm.bi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import java.util.ArrayList;

public final class a {
    public static ArrayList<String> tS(String str) {
        AppMethodBeat.i(16613);
        ArrayList arrayList = new ArrayList();
        bf[] er = d.akQ().er(str, 10);
        if (er != null) {
            for (bf bfVar : er) {
                arrayList.add(bfVar.field_sayhicontent);
            }
        }
        ab.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
        AppMethodBeat.o(16613);
        return arrayList;
    }

    public static ArrayList<String> tT(String str) {
        AppMethodBeat.i(16614);
        ArrayList arrayList = new ArrayList();
        bt[] et = d.akR().et(str, 10);
        if (et != null) {
            for (bt btVar : et) {
                arrayList.add(btVar.field_sayhicontent);
            }
        }
        ab.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
        AppMethodBeat.o(16614);
        return arrayList;
    }

    public static ArrayList<String> tU(String str) {
        AppMethodBeat.i(16615);
        ArrayList arrayList = new ArrayList();
        aw.ZK();
        Cursor Rj = c.XO().Rj(str);
        if (!(Rj == null || Rj.getCount() == 0)) {
            if (Rj.moveToFirst()) {
                int i = 0;
                while (!Rj.isAfterLast()) {
                    bi biVar = new bi();
                    biVar.d(Rj);
                    Rj.moveToNext();
                    if (biVar.isText()) {
                        arrayList.add(biVar.field_content);
                    } else {
                        arrayList.add("");
                    }
                    i++;
                    if (i == 10) {
                        break;
                    }
                }
            }
            Rj.close();
        }
        AppMethodBeat.o(16615);
        return arrayList;
    }

    public static ArrayList<String> z(int i, String str) {
        AppMethodBeat.i(16616);
        ArrayList arrayList = new ArrayList();
        ax[] eq = d.akO().eq(str, 10);
        if (eq != null) {
            for (ax axVar : eq) {
                if (axVar.field_type == 1) {
                    arrayList.add(bo.nullAsNil(d.apF(axVar.field_msgContent).content));
                }
            }
        }
        ab.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", Integer.valueOf(i));
        AppMethodBeat.o(16616);
        return arrayList;
    }
}
