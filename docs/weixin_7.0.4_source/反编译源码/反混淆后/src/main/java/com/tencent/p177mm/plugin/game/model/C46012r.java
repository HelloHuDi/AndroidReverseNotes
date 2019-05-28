package com.tencent.p177mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.r */
public final class C46012r extends C7563j<C28229n> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C28229n.ccO, "GameRawMessage")};

    static {
        AppMethodBeat.m2504i(111334);
        AppMethodBeat.m2505o(111334);
    }

    public C46012r(C4927e c4927e) {
        super(c4927e, C28229n.ccO, "GameRawMessage", null);
    }

    /* renamed from: iP */
    public final C28229n mo73903iP(long j) {
        AppMethodBeat.m2504i(111327);
        C28229n c28229n = new C28229n();
        c28229n.field_msgId = j;
        if (mo10102b((C4925c) c28229n, new String[0])) {
            AppMethodBeat.m2505o(111327);
            return c28229n;
        }
        AppMethodBeat.m2505o(111327);
        return null;
    }

    /* renamed from: b */
    public final LinkedList<C28229n> mo73898b(int i, long j, int i2, int i3) {
        Object obj;
        String str;
        AppMethodBeat.m2504i(111328);
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
            AppMethodBeat.m2505o(111328);
            return null;
        }
        String str2 = "";
        if (i != 65536) {
            str2 = "msgType=" + i + " and ";
        }
        String valueOf = String.valueOf(i3);
        str2 = String.format("select * from GameRawMessage where " + str2 + "msgId<%s and " + str + "order by createTime desc limit %s", new Object[]{obj2, valueOf});
        LinkedList<C28229n> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery(str2, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.m2505o(111328);
            return linkedList;
        }
        if (rawQuery.moveToFirst()) {
            do {
                C28229n c28229n = new C28229n();
                c28229n.mo8995d(rawQuery);
                linkedList.add(c28229n);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        AppMethodBeat.m2505o(111328);
        return linkedList;
    }

    /* renamed from: d */
    public final boolean mo73902d(long[] jArr) {
        AppMethodBeat.m2504i(111329);
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
            boolean hY = mo16768hY(str, String.format("update GameRawMessage set isRead=1 where %s", new Object[]{stringBuilder2}));
            AppMethodBeat.m2505o(111329);
            return hY;
        }
        AppMethodBeat.m2505o(111329);
        return false;
    }

    public final void bEu() {
        AppMethodBeat.m2504i(111330);
        mo16768hY("GameRawMessage", "update GameRawMessage set isHidden = 0 where isHidden = 1");
        AppMethodBeat.m2505o(111330);
    }

    public final void bEv() {
        AppMethodBeat.m2504i(111331);
        String str = "GameRawMessage";
        mo16768hY(str, "update GameRawMessage set isRead=1 where isRead=0 and " + C46012r.m85504v(2, 5, 6, 10, 11, 100) + " and isHidden = 0");
        AppMethodBeat.m2505o(111331);
    }

    public final int bEw() {
        int i = 0;
        AppMethodBeat.m2504i(111332);
        Cursor rawQuery = rawQuery("select count(*) from GameRawMessage where " + C46012r.m85504v(2, 5, 6, 10, 11, 100) + " and isRead=0 and showInMsgList = 1 and isHidden = 0", new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.m2505o(111332);
        } else {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.m2505o(111332);
        }
        return i;
    }

    /* renamed from: v */
    public static String m85504v(int... iArr) {
        AppMethodBeat.m2504i(111333);
        String str = "" + "(";
        for (int i = 0; i < 5; i++) {
            str = str + "msgType=" + iArr[i] + " or ";
        }
        String str2 = (str + "msgType=" + iArr[5]) + ")";
        AppMethodBeat.m2505o(111333);
        return str2;
    }
}
