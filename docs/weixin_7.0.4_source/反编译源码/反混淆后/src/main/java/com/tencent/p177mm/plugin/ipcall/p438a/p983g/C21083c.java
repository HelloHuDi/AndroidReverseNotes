package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9524ck;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.c */
public final class C21083c extends C9524ck {
    public static C4924a ccO;
    public ArrayList<String> nzx;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: eJ */
    public static boolean m32390eJ(String str, String str2) {
        AppMethodBeat.m2504i(21921);
        if (str == null && str2 != null) {
            AppMethodBeat.m2505o(21921);
            return false;
        } else if (str == null || str.equals(str2)) {
            AppMethodBeat.m2505o(21921);
            return true;
        } else {
            AppMethodBeat.m2505o(21921);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(21922);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "wechatUsername";
        c4924a.xDd.put("wechatUsername", "TEXT");
        stringBuilder.append(" wechatUsername TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "systemAddressBookUsername";
        c4924a.xDd.put("systemAddressBookUsername", "TEXT");
        stringBuilder.append(" systemAddressBookUsername TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "contactId";
        c4924a.xDd.put("contactId", "TEXT");
        stringBuilder.append(" contactId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "sortKey";
        c4924a.xDd.put("sortKey", "TEXT");
        stringBuilder.append(" sortKey TEXT");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(21922);
    }
}
