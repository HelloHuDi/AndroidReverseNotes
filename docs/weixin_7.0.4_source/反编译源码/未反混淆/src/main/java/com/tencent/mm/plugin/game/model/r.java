package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.LinkedList;

public final class r extends j<n> {
    public static final String[] fnj = new String[]{j.a(n.ccO, "GameRawMessage")};

    static {
        AppMethodBeat.i(111334);
        AppMethodBeat.o(111334);
    }

    public r(e eVar) {
        super(eVar, n.ccO, "GameRawMessage", null);
    }

    public final n iP(long j) {
        AppMethodBeat.i(111327);
        n nVar = new n();
        nVar.field_msgId = j;
        if (b((c) nVar, new String[0])) {
            AppMethodBeat.o(111327);
            return nVar;
        }
        AppMethodBeat.o(111327);
        return null;
    }

    public final LinkedList<n> b(int i, long j, int i2, int i3) {
        Object obj;
        String str;
        AppMethodBeat.i(111328);
        if (j == 0) {
            obj = "9223372036854775807";
        } else {
            String obj2 = String.valueOf(j);
        }
        if (i2 == 0) {
            str = "(isRead=1 or isRead=0) ";
        } else if (i2 == 1) {
            str = "isRead=0 ";
        } else if (i2 == 2) {
            str = "isRead=1 ";
        } else {
            AppMethodBeat.o(111328);
            return null;
        }
        String str2 = "";
        if (i != 65536) {
            str2 = "msgType=" + i + " and ";
        }
        String valueOf = String.valueOf(i3);
        str2 = String.format("select * from GameRawMessage where " + str2 + "msgId<%s and " + str + "order by createTime desc limit %s", new Object[]{obj2, valueOf});
        LinkedList<n> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery(str2, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(111328);
            return linkedList;
        }
        if (rawQuery.moveToFirst()) {
            do {
                n nVar = new n();
                nVar.d(rawQuery);
                linkedList.add(nVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        AppMethodBeat.o(111328);
        return linkedList;
    }

    public final boolean d(long[] jArr) {
        AppMethodBeat.i(111329);
        if (jArr.length != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("msgId in (");
            for (int i = 0; i < jArr.length; i++) {
                stringBuilder.append(jArr[i]);
                if (i != jArr.length - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append(")");
            String stringBuilder2 = stringBuilder.toString();
            String str = "GameRawMessage";
            boolean hY = hY(str, String.format("update GameRawMessage set isRead=1 where %s", new Object[]{stringBuilder2}));
            AppMethodBeat.o(111329);
            return hY;
        }
        AppMethodBeat.o(111329);
        return false;
    }

    public final void bEu() {
        AppMethodBeat.i(111330);
        hY("GameRawMessage", "update GameRawMessage set isHidden = 0 where isHidden = 1");
        AppMethodBeat.o(111330);
    }

    public final void bEv() {
        AppMethodBeat.i(111331);
        String str = "GameRawMessage";
        hY(str, "update GameRawMessage set isRead=1 where isRead=0 and " + v(2, 5, 6, 10, 11, 100) + " and isHidden = 0");
        AppMethodBeat.o(111331);
    }

    public final int bEw() {
        int i = 0;
        AppMethodBeat.i(111332);
        Cursor rawQuery = rawQuery("select count(*) from GameRawMessage where " + v(2, 5, 6, 10, 11, 100) + " and isRead=0 and showInMsgList = 1 and isHidden = 0", new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(111332);
        } else {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(111332);
        }
        return i;
    }

    public static String v(int... iArr) {
        AppMethodBeat.i(111333);
        String str = "" + "(";
        for (int i = 0; i < 5; i++) {
            str = str + "msgType=" + iArr[i] + " or ";
        }
        String str2 = (str + "msgType=" + iArr[5]) + ")";
        AppMethodBeat.o(111333);
        return str2;
    }
}
