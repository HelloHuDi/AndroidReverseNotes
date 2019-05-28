package com.tencent.p177mm.model;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7309bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.model.bq */
public final class C9650bq {
    private C4927e bSd;
    private C7309bd fnq;

    public C9650bq(C4927e c4927e, C7309bd c7309bd) {
        this.bSd = c4927e;
        this.fnq = c7309bd;
    }

    /* renamed from: a */
    public final Cursor mo20974a(String str, String str2, List<String> list, boolean z) {
        AppMethodBeat.m2504i(16339);
        Cursor a = mo20975a(str, str2, list, z, 1, null);
        AppMethodBeat.m2505o(16339);
        return a;
    }

    /* renamed from: a */
    public final Cursor mo20973a(String str, String str2, List<String> list, List<String> list2) {
        AppMethodBeat.m2504i(16340);
        Cursor a = mo20975a(str, str2, list, true, 2, list2);
        AppMethodBeat.m2505o(16340);
        return a;
    }

    /* renamed from: b */
    public final Cursor mo20977b(String str, String str2, List<String> list, List<String> list2) {
        AppMethodBeat.m2504i(16341);
        Cursor a = mo20975a(str, str2, list, true, 2, list2);
        AppMethodBeat.m2505o(16341);
        return a;
    }

    /* renamed from: a */
    public final Cursor mo20975a(String str, String str2, List<String> list, boolean z, int i, List<String> list2) {
        Cursor a;
        AppMethodBeat.m2504i(16342);
        String str3 = "select * ,rowid from rcontact ";
        if (i == 2) {
            str3 = "select 2, *,rowid from rcontact ";
        }
        str3 = str3 + this.fnq.mo15750e(str2, null, list) + this.fnq.aoV(str) + this.fnq.aet();
        C4990ab.m7418v("Micro.SimpleSearchConversationModel", str3);
        Cursor rawQuery = this.bSd.rawQuery(str3, null);
        if (z) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (rawQuery.moveToNext()) {
                str3 = rawQuery.getString(rawQuery.getColumnIndex("username"));
                if (C1855t.m3896kH(str3)) {
                    arrayList2.add(str3);
                } else {
                    arrayList.add(str3);
                }
            }
            if (!(list2 == null || list2.size() == 0)) {
                arrayList.addAll(list2);
            }
            if (arrayList.size() != 0) {
                a = mo20976a(str, arrayList, arrayList2, null, list);
                a = new MergeCursor(new Cursor[]{rawQuery, a});
                AppMethodBeat.m2505o(16342);
                return a;
            }
        }
        a = rawQuery;
        AppMethodBeat.m2505o(16342);
        return a;
    }

    /* renamed from: a */
    public final Cursor mo20976a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, List<String> list) {
        AppMethodBeat.m2504i(16343);
        String str2 = "select * ,rowid from rcontact " + this.fnq.mo15750e("@all.contact.android", "", list) + C9650bq.m17211a(str, (ArrayList) arrayList, (ArrayList) arrayList2, (ArrayList) arrayList3) + this.fnq.aet();
        C4990ab.m7418v("Micro.SimpleSearchConversationModel", "roomsSql ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        AppMethodBeat.m2505o(16343);
        return rawQuery;
    }

    /* renamed from: a */
    private static String m17211a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        Iterator it;
        AppMethodBeat.m2504i(16344);
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
        AppMethodBeat.m2505o(16344);
        return stringBuffer2;
    }
}
