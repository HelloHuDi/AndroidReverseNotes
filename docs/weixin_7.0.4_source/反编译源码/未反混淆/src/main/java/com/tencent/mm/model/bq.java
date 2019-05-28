package com.tencent.mm.model;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bq {
    private e bSd;
    private bd fnq;

    public bq(e eVar, bd bdVar) {
        this.bSd = eVar;
        this.fnq = bdVar;
    }

    public final Cursor a(String str, String str2, List<String> list, boolean z) {
        AppMethodBeat.i(16339);
        Cursor a = a(str, str2, list, z, 1, null);
        AppMethodBeat.o(16339);
        return a;
    }

    public final Cursor a(String str, String str2, List<String> list, List<String> list2) {
        AppMethodBeat.i(16340);
        Cursor a = a(str, str2, list, true, 2, list2);
        AppMethodBeat.o(16340);
        return a;
    }

    public final Cursor b(String str, String str2, List<String> list, List<String> list2) {
        AppMethodBeat.i(16341);
        Cursor a = a(str, str2, list, true, 2, list2);
        AppMethodBeat.o(16341);
        return a;
    }

    public final Cursor a(String str, String str2, List<String> list, boolean z, int i, List<String> list2) {
        Cursor a;
        AppMethodBeat.i(16342);
        String str3 = "select * ,rowid from rcontact ";
        if (i == 2) {
            str3 = "select 2, *,rowid from rcontact ";
        }
        str3 = str3 + this.fnq.e(str2, null, list) + this.fnq.aoV(str) + this.fnq.aet();
        ab.v("Micro.SimpleSearchConversationModel", str3);
        Cursor rawQuery = this.bSd.rawQuery(str3, null);
        if (z) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (rawQuery.moveToNext()) {
                str3 = rawQuery.getString(rawQuery.getColumnIndex("username"));
                if (t.kH(str3)) {
                    arrayList2.add(str3);
                } else {
                    arrayList.add(str3);
                }
            }
            if (!(list2 == null || list2.size() == 0)) {
                arrayList.addAll(list2);
            }
            if (arrayList.size() != 0) {
                a = a(str, arrayList, arrayList2, null, list);
                a = new MergeCursor(new Cursor[]{rawQuery, a});
                AppMethodBeat.o(16342);
                return a;
            }
        }
        a = rawQuery;
        AppMethodBeat.o(16342);
        return a;
    }

    public final Cursor a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, List<String> list) {
        AppMethodBeat.i(16343);
        String str2 = "select * ,rowid from rcontact " + this.fnq.e("@all.contact.android", "", list) + a(str, (ArrayList) arrayList, (ArrayList) arrayList2, (ArrayList) arrayList3) + this.fnq.aet();
        ab.v("Micro.SimpleSearchConversationModel", "roomsSql ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        AppMethodBeat.o(16343);
        return rawQuery;
    }

    private static String a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        Iterator it;
        AppMethodBeat.i(16344);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" and (username in (");
        stringBuffer.append("select chatroomname from chatroom where ");
        if (!(arrayList2 == null || arrayList2.size() == 0)) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                stringBuffer.append("chatroomname != '" + ((String) it.next()) + "' and ");
            }
        }
        stringBuffer.append("(memberlist like '%" + str + "%'");
        it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(" or memberlist like '%" + ((String) it.next()) + "%'");
        }
        if (!(arrayList3 == null || arrayList3.size() == 0)) {
            it = arrayList3.iterator();
            while (it.hasNext()) {
                stringBuffer.append(" or chatroomname = '" + ((String) it.next()) + "'");
            }
        }
        stringBuffer.append(")))");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(16344);
        return stringBuffer2;
    }
}
