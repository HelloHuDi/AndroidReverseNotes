package com.tencent.p177mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.model.ac */
public final class C32774ac {
    /* renamed from: Zr */
    public static void m53536Zr() {
        AppMethodBeat.m2504i(16275);
        Cursor dsu = C18628c.m29078XM().dsu();
        String str = "MicroMsg.HardCodeUpdateTask";
        String str2 = "[unstarAllBizContactFor50] size:%s";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(dsu == null ? 0 : dsu.getCount());
        C4990ab.m7417i(str, str2, objArr);
        if (dsu.moveToFirst()) {
            do {
                C7616ad c7616ad = new C7616ad();
                c7616ad.mo8995d(dsu);
                c7616ad.mo16688NN();
                C18628c.m29078XM().mo15724b(c7616ad.field_username, c7616ad);
            } while (dsu.moveToNext());
        }
        dsu.close();
        AppMethodBeat.m2505o(16275);
    }
}
