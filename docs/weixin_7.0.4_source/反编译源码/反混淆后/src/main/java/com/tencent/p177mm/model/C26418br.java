package com.tencent.p177mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7310be;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.model.br */
public final class C26418br {
    private C4927e bSd;
    private C7310be fnr;

    public C26418br(C4927e c4927e, C7310be c7310be) {
        this.bSd = c4927e;
        this.fnr = c7310be;
    }

    /* renamed from: oI */
    private String m42065oI(String str) {
        String string;
        String str2;
        AppMethodBeat.m2504i(16346);
        String str3 = "";
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a("select username from rcontact where (username like '%" + str + "%' or nickname like '%" + str + "%' or alias like '%" + str + "%' or pyInitial like '%" + str + "%' or quanPin like '%" + str + "%' or conRemark like '%" + str + "%' )and username not like '%@%' and type & " + C7486a.m12939NW() + "=0 ", null, 2);
        C4990ab.m7419v("Micro.SimpleSearchConversationModel", "contactsql %s", string);
        while (a.moveToNext()) {
            string = a.getString(a.getColumnIndex("username"));
            if (!string.endsWith("@chatroom")) {
                arrayList.add(string);
            }
        }
        a.close();
        if (arrayList.size() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" ( rconversation.username in ( select chatroomname from chatroom where ");
            stringBuffer.append("memberlist like '%" + str + "%'");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                stringBuffer.append(" or memberlist like '%" + ((String) it.next()) + "%'");
            }
            stringBuffer.append("))");
            str2 = str3 + stringBuffer.toString() + " or ";
        } else {
            str2 = str3;
        }
        str2 = " and ( rconversation.username like '%" + str + "%' or " + str2 + "rconversation.content like '%" + str + "%' or rcontact.nickname like '%" + str + "%' or rcontact.alias like '%" + str + "%' or rcontact.pyInitial like '%" + str + "%' or rcontact.quanPin like '%" + str + "%' or rcontact.conRemark like '%" + str + "%'  ) ";
        AppMethodBeat.m2505o(16346);
        return str2;
    }

    /* renamed from: b */
    public final Cursor mo44190b(String str, List<String> list, String str2) {
        AppMethodBeat.m2504i(16345);
        String str3 = " ";
        String str4 = " ";
        if (str2 != null && str2.length() > 0) {
            str4 = " and rconversation.username = rcontact.username ";
        }
        String str5 = "select 1,unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rcontact.nickname from rconversation," + "rcontact" + str3 + " where rconversation.username = rcontact.username" + str4 + C5046bo.nullAsNil(str);
        str4 = "";
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (true) {
                str3 = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = str3 + " and rconversation.username != '" + ((String) it.next()) + "'";
            }
            str4 = str3;
        }
        str4 = str5 + str4;
        if (str2 != null && str2.length() > 0) {
            str4 = str4 + m42065oI(str2);
        }
        C4990ab.m7419v("Micro.SimpleSearchConversationModel", "convsql %s", ((str4 + " order by ") + "rconversation.username like '%@chatroom' asc, ") + "flag desc, conversationTime desc");
        Cursor rawQuery = this.bSd.rawQuery(str4, null);
        AppMethodBeat.m2505o(16345);
        return rawQuery;
    }
}
