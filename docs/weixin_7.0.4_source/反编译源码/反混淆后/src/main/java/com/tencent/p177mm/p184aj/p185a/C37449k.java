package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.aj.a.k */
public final class C37449k extends C7563j<C45143j> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C45143j.ccO, "BizChatUserInfo")};
    public C4927e bSd;
    final C4934l<C37450a, C32236b> fuL = new C63041();
    Map<String, String> fxs = new HashMap();

    /* renamed from: com.tencent.mm.aj.a.k$1 */
    class C63041 extends C4934l<C37450a, C32236b> {
        C63041() {
        }

        /* renamed from: w */
        public final /* bridge */ /* synthetic */ void mo10134w(Object obj, Object obj2) {
        }
    }

    /* renamed from: com.tencent.mm.aj.a.k$a */
    public interface C37450a {

        /* renamed from: com.tencent.mm.aj.a.k$a$a */
        public enum C32235a {
            INSTERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.m2505o(11594);
            }
        }

        /* renamed from: com.tencent.mm.aj.a.k$a$b */
        public static class C32236b {
            public C32235a fyc;
            public C45143j fyd;
            public String userId;
        }
    }

    static {
        AppMethodBeat.m2504i(11605);
        AppMethodBeat.m2505o(11605);
    }

    public C37449k(C4927e c4927e) {
        super(c4927e, C45143j.ccO, "BizChatUserInfo", null);
        AppMethodBeat.m2504i(11595);
        this.bSd = c4927e;
        c4927e.mo10108hY("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
        this.fxs.clear();
        AppMethodBeat.m2505o(11595);
    }

    /* renamed from: cH */
    public final C45143j mo60356cH(String str) {
        AppMethodBeat.m2504i(11596);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
            AppMethodBeat.m2505o(11596);
            return null;
        }
        C4925c c45143j = new C45143j();
        c45143j.field_userId = str;
        super.mo10102b(c45143j, new String[0]);
        AppMethodBeat.m2505o(11596);
        return c45143j;
    }

    /* renamed from: a */
    public final boolean mo60353a(C45143j c45143j) {
        AppMethodBeat.m2504i(11597);
        C4990ab.m7410d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
        if (c45143j == null) {
            C4990ab.m7420w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
            AppMethodBeat.m2505o(11597);
            return false;
        }
        boolean b = super.mo10101b((C4925c) c45143j);
        if (b) {
            C32236b c32236b = new C32236b();
            c32236b.userId = c45143j.field_userId;
            c32236b.fyc = C32235a.INSTERT;
            c32236b.fyd = c45143j;
            this.fuL.mo10126cF(c32236b);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11597);
        return b;
    }

    /* renamed from: b */
    public final boolean mo60354b(C45143j c45143j) {
        AppMethodBeat.m2504i(11598);
        C4990ab.m7410d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
        if (c45143j == null) {
            C4990ab.m7420w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
            AppMethodBeat.m2505o(11598);
            return false;
        }
        if (c45143j == null || C5046bo.isNullOrNil(c45143j.field_userName)) {
            C4990ab.m7416i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
        } else {
            c45143j.field_userNamePY = C9790g.m17432vo(c45143j.field_userName);
        }
        boolean a = super.mo10099a(c45143j);
        if (a) {
            C32236b c32236b = new C32236b();
            c32236b.userId = c45143j.field_userId;
            c32236b.fyc = C32235a.UPDATE;
            c32236b.fyd = c45143j;
            this.fuL.mo10126cF(c32236b);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11598);
        return a;
    }

    /* renamed from: rC */
    public final int mo60358rC(String str) {
        AppMethodBeat.m2504i(11599);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
            AppMethodBeat.m2505o(11599);
            return -1;
        }
        C45143j cH = mo60356cH(str);
        if (cH != null) {
            int i = cH.field_UserVersion;
            AppMethodBeat.m2505o(11599);
            return i;
        }
        C4990ab.m7420w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
        AppMethodBeat.m2505o(11599);
        return -1;
    }

    /* renamed from: rD */
    public final C45143j mo60359rD(String str) {
        AppMethodBeat.m2504i(11600);
        if (str == null) {
            C4990ab.m7416i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
            AppMethodBeat.m2505o(11600);
            return null;
        }
        String cI = mo60357cI(str);
        if (cI == null) {
            C4990ab.m7416i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
            AppMethodBeat.m2505o(11600);
            return null;
        }
        C45143j cH = mo60356cH(cI);
        AppMethodBeat.m2505o(11600);
        return cH;
    }

    /* renamed from: cI */
    public final String mo60357cI(String str) {
        AppMethodBeat.m2504i(11601);
        if (str == null) {
            C4990ab.m7416i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
            AppMethodBeat.m2505o(11601);
            return null;
        }
        C4990ab.m7417i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", str);
        String str2;
        if (!this.fxs.containsKey(str) || this.fxs.get(str) == null) {
            C8925f rA = C41747z.aeW().mo43711rA(str);
            if (rA != null) {
                C4990ab.m7411d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", str, rA.field_userId);
                this.fxs.put(str, rA.field_userId);
                str2 = rA.field_userId;
                AppMethodBeat.m2505o(11601);
                return str2;
            }
            C4990ab.m7421w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", str);
            AppMethodBeat.m2505o(11601);
            return null;
        }
        str2 = (String) this.fxs.get(str);
        AppMethodBeat.m2505o(11601);
        return str2;
    }

    /* renamed from: c */
    public final void mo60355c(C45143j c45143j) {
        AppMethodBeat.m2504i(11602);
        C4990ab.m7416i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
        C45143j cH = mo60356cH(c45143j.field_userId);
        if (cH == null) {
            mo60353a(c45143j);
        } else if (!(C5046bo.isNullOrNil(c45143j.field_userName) || c45143j.field_userName.equals(cH.field_userName))) {
            cH.field_userName = c45143j.field_userName;
            mo60354b(cH);
            AppMethodBeat.m2505o(11602);
            return;
        }
        AppMethodBeat.m2505o(11602);
    }

    /* renamed from: a */
    public static String m63135a(String[] strArr, List<String> list) {
        AppMethodBeat.m2504i(11603);
        String str;
        if (strArr == null || strArr.length == 0) {
            str = "";
            AppMethodBeat.m2505o(11603);
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
        AppMethodBeat.m2505o(11603);
        return str;
    }
}
