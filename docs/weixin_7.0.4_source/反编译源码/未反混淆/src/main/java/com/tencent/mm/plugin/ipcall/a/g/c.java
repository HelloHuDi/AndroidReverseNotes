package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ck;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class c extends ck {
    public static a ccO;
    public ArrayList<String> nzx;

    public final a Ag() {
        return ccO;
    }

    public static boolean eJ(String str, String str2) {
        AppMethodBeat.i(21921);
        if (str == null && str2 != null) {
            AppMethodBeat.o(21921);
            return false;
        } else if (str == null || str.equals(str2)) {
            AppMethodBeat.o(21921);
            return true;
        } else {
            AppMethodBeat.o(21921);
            return false;
        }
    }

    static {
        AppMethodBeat.i(21922);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wechatUsername";
        aVar.xDd.put("wechatUsername", "TEXT");
        stringBuilder.append(" wechatUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "systemAddressBookUsername";
        aVar.xDd.put("systemAddressBookUsername", "TEXT");
        stringBuilder.append(" systemAddressBookUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "contactId";
        aVar.xDd.put("contactId", "TEXT");
        stringBuilder.append(" contactId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sortKey";
        aVar.xDd.put("sortKey", "TEXT");
        stringBuilder.append(" sortKey TEXT");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(21922);
    }
}
