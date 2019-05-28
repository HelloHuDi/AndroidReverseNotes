package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k extends j<j> {
    public static final String[] fnj = new String[]{j.a(j.ccO, "BizChatUserInfo")};
    public e bSd;
    final l<a, b> fuL = new l<a, b>() {
        public final /* bridge */ /* synthetic */ void w(Object obj, Object obj2) {
        }
    };
    Map<String, String> fxs = new HashMap();

    public interface a {

        public enum a {
            INSTERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.o(11594);
            }
        }

        public static class b {
            public a fyc;
            public j fyd;
            public String userId;
        }
    }

    static {
        AppMethodBeat.i(11605);
        AppMethodBeat.o(11605);
    }

    public k(e eVar) {
        super(eVar, j.ccO, "BizChatUserInfo", null);
        AppMethodBeat.i(11595);
        this.bSd = eVar;
        eVar.hY("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
        this.fxs.clear();
        AppMethodBeat.o(11595);
    }

    public final j cH(String str) {
        AppMethodBeat.i(11596);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
            AppMethodBeat.o(11596);
            return null;
        }
        c jVar = new j();
        jVar.field_userId = str;
        super.b(jVar, new String[0]);
        AppMethodBeat.o(11596);
        return jVar;
    }

    public final boolean a(j jVar) {
        AppMethodBeat.i(11597);
        ab.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
        if (jVar == null) {
            ab.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
            AppMethodBeat.o(11597);
            return false;
        }
        boolean b = super.b((c) jVar);
        if (b) {
            b bVar = new b();
            bVar.userId = jVar.field_userId;
            bVar.fyc = a.INSTERT;
            bVar.fyd = jVar;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11597);
        return b;
    }

    public final boolean b(j jVar) {
        AppMethodBeat.i(11598);
        ab.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
        if (jVar == null) {
            ab.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
            AppMethodBeat.o(11598);
            return false;
        }
        if (jVar == null || bo.isNullOrNil(jVar.field_userName)) {
            ab.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
        } else {
            jVar.field_userNamePY = g.vo(jVar.field_userName);
        }
        boolean a = super.a(jVar);
        if (a) {
            b bVar = new b();
            bVar.userId = jVar.field_userId;
            bVar.fyc = a.UPDATE;
            bVar.fyd = jVar;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11598);
        return a;
    }

    public final int rC(String str) {
        AppMethodBeat.i(11599);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
            AppMethodBeat.o(11599);
            return -1;
        }
        j cH = cH(str);
        if (cH != null) {
            int i = cH.field_UserVersion;
            AppMethodBeat.o(11599);
            return i;
        }
        ab.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
        AppMethodBeat.o(11599);
        return -1;
    }

    public final j rD(String str) {
        AppMethodBeat.i(11600);
        if (str == null) {
            ab.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
            AppMethodBeat.o(11600);
            return null;
        }
        String cI = cI(str);
        if (cI == null) {
            ab.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
            AppMethodBeat.o(11600);
            return null;
        }
        j cH = cH(cI);
        AppMethodBeat.o(11600);
        return cH;
    }

    public final String cI(String str) {
        AppMethodBeat.i(11601);
        if (str == null) {
            ab.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
            AppMethodBeat.o(11601);
            return null;
        }
        ab.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", str);
        String str2;
        if (!this.fxs.containsKey(str) || this.fxs.get(str) == null) {
            f rA = z.aeW().rA(str);
            if (rA != null) {
                ab.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", str, rA.field_userId);
                this.fxs.put(str, rA.field_userId);
                str2 = rA.field_userId;
                AppMethodBeat.o(11601);
                return str2;
            }
            ab.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", str);
            AppMethodBeat.o(11601);
            return null;
        }
        str2 = (String) this.fxs.get(str);
        AppMethodBeat.o(11601);
        return str2;
    }

    public final void c(j jVar) {
        AppMethodBeat.i(11602);
        ab.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
        j cH = cH(jVar.field_userId);
        if (cH == null) {
            a(jVar);
        } else if (!(bo.isNullOrNil(jVar.field_userName) || jVar.field_userName.equals(cH.field_userName))) {
            cH.field_userName = jVar.field_userName;
            b(cH);
            AppMethodBeat.o(11602);
            return;
        }
        AppMethodBeat.o(11602);
    }

    public static String a(String[] strArr, List<String> list) {
        AppMethodBeat.i(11603);
        String str;
        if (strArr == null || strArr.length == 0) {
            str = "";
            AppMethodBeat.o(11603);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(" 1=1 ");
        str = "";
        if (list != null && list.size() > 0) {
            String str2;
            Iterator it = list.iterator();
            while (true) {
                str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                str = str2 + " and userId != '" + ((String) it.next()) + "'";
            }
            str = str2;
        }
        stringBuilder.append(str);
        stringBuilder.append(" and ");
        stringBuilder.append("userId in(");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append(" '").append(strArr[i]).append("' ");
        }
        stringBuilder.append(" )");
        str = stringBuilder.toString();
        AppMethodBeat.o(11603);
        return str;
    }
}
