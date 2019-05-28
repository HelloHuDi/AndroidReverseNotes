package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.List;

public final class f implements j {
    public final Cursor i(String str, String[] strArr) {
        AppMethodBeat.i(136564);
        g.RQ();
        Cursor a = g.RP().eJO.a(str, strArr, 2);
        AppMethodBeat.o(136564);
        return a;
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.i(136565);
        g.RQ();
        Cursor a = g.RP().eJO.a(str, strArr, 0);
        AppMethodBeat.o(136565);
        return a;
    }

    public final ad MU(String str) {
        AppMethodBeat.i(136566);
        ad aoI = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoI(str);
        if (aoI == null) {
            aoI = new ad();
            Cursor i = i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[]{str});
            if (i.moveToNext()) {
                aoI.ewQ = i.getLong(0);
                aoI.setUsername(i.getString(1));
                aoI.iy(i.getString(2));
                aoI.iz(i.getString(3));
                aoI.iB(i.getString(4));
                aoI.hw(i.getInt(5));
                aoI.setType(i.getInt(6));
                aoI.H(i.getBlob(7));
                aoI.iI(i.getString(8));
                aoI.hy(0);
            }
            i.close();
        }
        AppMethodBeat.o(136566);
        return aoI;
    }

    public final boolean MV(String str) {
        AppMethodBeat.i(136567);
        Cursor i = i(String.format("SELECT 1 FROM rconversation WHERE username = ?", new Object[0]), new String[]{str});
        try {
            boolean moveToNext = i.moveToNext();
            return moveToNext;
        } finally {
            if (i != null) {
                i.close();
            }
            AppMethodBeat.o(136567);
        }
    }

    public final long MW(String str) {
        AppMethodBeat.i(136568);
        Cursor i = i("SELECT conversationTime FROM rconversation WHERE username=?;", new String[]{str});
        long j = 0;
        if (i != null && i.moveToFirst()) {
            j = i.getLong(0);
        }
        if (i != null) {
            i.close();
        }
        AppMethodBeat.o(136568);
        return j;
    }

    public final List<String> MX(String str) {
        AppMethodBeat.i(136569);
        ArrayList arrayList = new ArrayList();
        if (str.endsWith("\u0000")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.length() == 0) {
            AppMethodBeat.o(136569);
        } else {
            Cursor i = i(String.format("SELECT labelName FROM ContactLabel WHERE labelID IN (%s);", new Object[]{str}), null);
            while (i.moveToNext()) {
                arrayList.add(i.getString(0));
            }
            i.close();
            AppMethodBeat.o(136569);
        }
        return arrayList;
    }
}
