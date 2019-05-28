package com.tencent.p177mm.p612ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.storage.C7617ak;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.g */
public final class C5450g {
    /* renamed from: fm */
    public static final Cursor m8254fm(List<String> list) {
        AppMethodBeat.m2504i(105201);
        List fn = C5450g.m8255fn(list);
        Cursor dsF;
        if (fn.size() == 0) {
            C1720g.m3537RQ();
            dsF = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().dsF();
            AppMethodBeat.m2505o(105201);
            return dsF;
        }
        C1720g.m3537RQ();
        dsF = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15760ew(fn);
        AppMethodBeat.m2505o(105201);
        return dsF;
    }

    /* renamed from: fn */
    private static final List<String> m8255fn(List<String> list) {
        AppMethodBeat.m2504i(105202);
        ArrayList arrayList = new ArrayList();
        Cursor a = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15770a(C1855t.fkP, (List) list, true, null);
        if (a.moveToFirst()) {
            int i = 0;
            do {
                C7617ak c7617ak = new C7617ak();
                c7617ak.mo8995d(a);
                if (C5450g.m8253ZG(c7617ak.field_username)) {
                    arrayList.add(c7617ak.field_username);
                    i++;
                    if (i >= 4) {
                        break;
                    }
                }
            } while (a.moveToNext());
        }
        a.close();
        AppMethodBeat.m2505o(105202);
        return arrayList;
    }

    /* renamed from: ZG */
    private static final boolean m8253ZG(String str) {
        AppMethodBeat.m2504i(105203);
        for (Object equals : C1855t.fkY) {
            if (str.equals(equals)) {
                AppMethodBeat.m2505o(105203);
                return false;
            }
        }
        if (C1855t.m3896kH(str)) {
            AppMethodBeat.m2505o(105203);
            return false;
        } else if (C1855t.m3913mZ(str)) {
            AppMethodBeat.m2505o(105203);
            return false;
        } else {
            AppMethodBeat.m2505o(105203);
            return true;
        }
    }
}
