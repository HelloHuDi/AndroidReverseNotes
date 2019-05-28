package com.tencent.p177mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C28113j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.f */
public final class C43123f implements C28113j {
    /* renamed from: i */
    public final Cursor mo46037i(String str, String[] strArr) {
        AppMethodBeat.m2504i(136564);
        C1720g.m3537RQ();
        Cursor a = C1720g.m3536RP().eJO.mo10104a(str, strArr, 2);
        AppMethodBeat.m2505o(136564);
        return a;
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.m2504i(136565);
        C1720g.m3537RQ();
        Cursor a = C1720g.m3536RP().eJO.mo10104a(str, strArr, 0);
        AppMethodBeat.m2505o(136565);
        return a;
    }

    /* renamed from: MU */
    public final C7616ad mo46033MU(String str) {
        AppMethodBeat.m2504i(136566);
        C7616ad aoI = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoI(str);
        if (aoI == null) {
            aoI = new C7616ad();
            Cursor i = mo46037i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[]{str});
            if (i.moveToNext()) {
                aoI.ewQ = i.getLong(0);
                aoI.setUsername(i.getString(1));
                aoI.mo14728iy(i.getString(2));
                aoI.mo14729iz(i.getString(3));
                aoI.mo14703iB(i.getString(4));
                aoI.mo14698hw(i.getInt(5));
                aoI.setType(i.getInt(6));
                aoI.mo14672H(i.getBlob(7));
                aoI.mo14710iI(i.getString(8));
                aoI.mo14700hy(0);
            }
            i.close();
        }
        AppMethodBeat.m2505o(136566);
        return aoI;
    }

    /* renamed from: MV */
    public final boolean mo46034MV(String str) {
        AppMethodBeat.m2504i(136567);
        Cursor i = mo46037i(String.format("SELECT 1 FROM rconversation WHERE username = ?", new Object[0]), new String[]{str});
        try {
            boolean moveToNext = i.moveToNext();
            return moveToNext;
        } finally {
            if (i != null) {
                i.close();
            }
            AppMethodBeat.m2505o(136567);
        }
    }

    /* renamed from: MW */
    public final long mo46035MW(String str) {
        AppMethodBeat.m2504i(136568);
        Cursor i = mo46037i("SELECT conversationTime FROM rconversation WHERE username=?;", new String[]{str});
        long j = 0;
        if (i != null && i.moveToFirst()) {
            j = i.getLong(0);
        }
        if (i != null) {
            i.close();
        }
        AppMethodBeat.m2505o(136568);
        return j;
    }

    /* renamed from: MX */
    public final List<String> mo46036MX(String str) {
        AppMethodBeat.m2504i(136569);
        ArrayList arrayList = new ArrayList();
        if (str.endsWith("\u0000")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.length() == 0) {
            AppMethodBeat.m2505o(136569);
        } else {
            Cursor i = mo46037i(String.format("SELECT labelName FROM ContactLabel WHERE labelID IN (%s);", new Object[]{str}), null);
            while (i.moveToNext()) {
                arrayList.add(i.getString(0));
            }
            i.close();
            AppMethodBeat.m2505o(136569);
        }
        return arrayList;
    }
}
