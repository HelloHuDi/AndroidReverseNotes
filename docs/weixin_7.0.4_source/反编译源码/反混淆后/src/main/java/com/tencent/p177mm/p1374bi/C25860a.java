package com.tencent.p177mm.p1374bi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C41338bt;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.bi.a */
public final class C25860a {
    /* renamed from: tS */
    public static ArrayList<String> m41167tS(String str) {
        AppMethodBeat.m2504i(16613);
        ArrayList arrayList = new ArrayList();
        C7570bf[] er = C41789d.akQ().mo56741er(str, 10);
        if (er != null) {
            for (C7570bf c7570bf : er) {
                arrayList.add(c7570bf.field_sayhicontent);
            }
        }
        C4990ab.m7410d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
        AppMethodBeat.m2505o(16613);
        return arrayList;
    }

    /* renamed from: tT */
    public static ArrayList<String> m41168tT(String str) {
        AppMethodBeat.m2504i(16614);
        ArrayList arrayList = new ArrayList();
        C41338bt[] et = C41789d.akR().mo74764et(str, 10);
        if (et != null) {
            for (C41338bt c41338bt : et) {
                arrayList.add(c41338bt.field_sayhicontent);
            }
        }
        C4990ab.m7410d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
        AppMethodBeat.m2505o(16614);
        return arrayList;
    }

    /* renamed from: tU */
    public static ArrayList<String> m41169tU(String str) {
        AppMethodBeat.m2504i(16615);
        ArrayList arrayList = new ArrayList();
        C9638aw.m17190ZK();
        Cursor Rj = C18628c.m29080XO().mo15256Rj(str);
        if (!(Rj == null || Rj.getCount() == 0)) {
            if (Rj.moveToFirst()) {
                int i = 0;
                while (!Rj.isAfterLast()) {
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.mo8995d(Rj);
                    Rj.moveToNext();
                    if (c7620bi.isText()) {
                        arrayList.add(c7620bi.field_content);
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
        AppMethodBeat.m2505o(16615);
        return arrayList;
    }

    /* renamed from: z */
    public static ArrayList<String> m41170z(int i, String str) {
        AppMethodBeat.m2504i(16616);
        ArrayList arrayList = new ArrayList();
        C7569ax[] eq = C41789d.akO().mo17081eq(str, 10);
        if (eq != null) {
            for (C7569ax c7569ax : eq) {
                if (c7569ax.field_type == 1) {
                    arrayList.add(C5046bo.nullAsNil(C5138d.apF(c7569ax.field_msgContent).content));
                }
            }
        }
        C4990ab.m7411d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", Integer.valueOf(i));
        AppMethodBeat.m2505o(16616);
        return arrayList;
    }
}
