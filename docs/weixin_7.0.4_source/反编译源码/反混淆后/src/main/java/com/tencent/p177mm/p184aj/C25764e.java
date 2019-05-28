package com.tencent.p177mm.p184aj;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16536b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.tencent.mm.aj.e */
public final class C25764e extends C7563j<C16527d> {
    public static final String[] diI = new String[]{"CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) "};
    public static final String[] fnj = new String[]{C7563j.m13217a(C16527d.ccO, "bizinfo")};
    public static Map<String, String> fwe = new HashMap();
    private final C4934l<C25765a, C8934b> fuL = new C89331();

    /* renamed from: com.tencent.mm.aj.e$1 */
    class C89331 extends C4934l<C25765a, C8934b> {
        C89331() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(11322);
            ((C25765a) obj).mo11091a((C8934b) obj2);
            AppMethodBeat.m2505o(11322);
        }
    }

    /* renamed from: com.tencent.mm.aj.e$a */
    public interface C25765a {

        /* renamed from: com.tencent.mm.aj.e$a$b */
        public static class C8934b {
            public String fuO;
            public boolean fvo;
            public C25766a fwk;
            public C16527d fwl;
        }

        /* renamed from: com.tencent.mm.aj.e$a$a */
        public enum C25766a {
            INSTERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.m2505o(11325);
            }
        }

        /* renamed from: a */
        void mo11091a(C8934b c8934b);
    }

    static {
        AppMethodBeat.m2504i(11358);
        AppMethodBeat.m2505o(11358);
    }

    public C25764e(C4927e c4927e) {
        super(c4927e, C16527d.ccO, "bizinfo", diI);
        AppMethodBeat.m2504i(11326);
        AppMethodBeat.m2505o(11326);
    }

    /* renamed from: a */
    public final void mo43722a(C25765a c25765a, Looper looper) {
        AppMethodBeat.m2504i(11327);
        this.fuL.mo10125a(c25765a, looper);
        AppMethodBeat.m2505o(11327);
    }

    /* renamed from: a */
    public final void mo43721a(C25765a c25765a) {
        AppMethodBeat.m2504i(11328);
        if (this.fuL != null) {
            this.fuL.remove(c25765a);
        }
        AppMethodBeat.m2505o(11328);
    }

    /* renamed from: qP */
    public final C16527d mo43729qP(String str) {
        AppMethodBeat.m2504i(11329);
        C4925c c16527d = new C16527d();
        c16527d.field_username = str;
        super.mo10102b(c16527d, new String[0]);
        AppMethodBeat.m2505o(11329);
        return c16527d;
    }

    public final void delete(String str) {
        AppMethodBeat.m2504i(11330);
        C4925c c16527d = new C16527d();
        c16527d.field_username = str;
        String[] strArr = new String[]{"username"};
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.mo16760a(c16527d, strArr)), str);
        C8934b c8934b = new C8934b();
        c8934b.fuO = str;
        c8934b.fwk = C25766a.DELETE;
        c8934b.fwl = c16527d;
        this.fuL.mo10126cF(c8934b);
        this.fuL.doNotify();
        AppMethodBeat.m2505o(11330);
    }

    /* renamed from: c */
    public final void mo43723c(C16527d c16527d) {
        AppMethodBeat.m2504i(11331);
        String[] strArr = new String[]{"username"};
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.mo16760a((C4925c) c16527d, strArr)), c16527d.field_username);
        C8934b c8934b = new C8934b();
        c8934b.fuO = c16527d.field_username;
        c8934b.fwk = C25766a.DELETE;
        c8934b.fwl = c16527d;
        this.fuL.mo10126cF(c8934b);
        this.fuL.doNotify();
        AppMethodBeat.m2505o(11331);
    }

    /* renamed from: d */
    public final boolean mo43724d(C16527d c16527d) {
        AppMethodBeat.m2504i(11332);
        c16527d.field_updateTime = System.currentTimeMillis();
        c16527d.adK();
        C4990ab.m7419v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", c16527d.field_username, c16527d.field_brandList, Integer.valueOf(c16527d.field_brandFlag), c16527d.field_brandInfo, c16527d.field_extInfo, c16527d.field_brandIconURL, Long.valueOf(c16527d.field_updateTime));
        C16529b cJ = c16527d.mo30481cJ(false);
        if (cJ != null) {
            C16536b aej = cJ.aej();
            if (aej != null) {
                c16527d.field_specialType = aej.fvJ;
            }
        }
        boolean b = super.mo10101b((C4925c) c16527d);
        if (b && !C1855t.m3896kH(c16527d.field_username)) {
            C8934b c8934b = new C8934b();
            c8934b.fuO = c16527d.field_username;
            c8934b.fvo = c16527d.adL();
            c8934b.fwk = C25766a.INSTERT;
            c8934b.fwl = c16527d;
            this.fuL.mo10126cF(c8934b);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11332);
        return b;
    }

    /* renamed from: e */
    public final boolean mo43726e(C16527d c16527d) {
        AppMethodBeat.m2504i(11333);
        c16527d.field_updateTime = System.currentTimeMillis();
        c16527d.adK();
        C16529b cJ = c16527d.mo30481cJ(false);
        if (cJ != null) {
            C16536b aej = cJ.aej();
            if (aej != null) {
                c16527d.field_specialType = aej.fvJ;
            }
        }
        boolean a = super.mo10099a(c16527d);
        if (a && !C1855t.m3896kH(c16527d.field_username)) {
            C8934b c8934b = new C8934b();
            c8934b.fuO = c16527d.field_username;
            c8934b.fvo = c16527d.adL();
            c8934b.fwk = C25766a.UPDATE;
            c8934b.fwl = c16527d;
            this.fuL.mo10126cF(c8934b);
            this.fuL.doNotify();
        }
        AppMethodBeat.m2505o(11333);
        return a;
    }

    /* renamed from: le */
    public final List<String> mo43727le(int i) {
        AppMethodBeat.m2504i(11334);
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getList: sql[%s]", String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[]{"username", "bizinfo", "acceptType", Integer.valueOf(i)}));
        long yz = C5046bo.m7588yz();
        Cursor rawQuery = rawQuery(r0, new String[0]);
        LinkedList linkedList = new LinkedList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            C4990ab.m7417i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", Integer.valueOf(i), Long.valueOf(C5046bo.m7525az(yz)));
            List eE = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15755eE(linkedList);
            AppMethodBeat.m2505o(11334);
            return eE;
        }
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", Integer.valueOf(i), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(11334);
        return linkedList;
    }

    /* renamed from: lf */
    public final int mo43728lf(int i) {
        AppMethodBeat.m2504i(11335);
        List le = mo43727le(i);
        if (C5046bo.m7548ek(le)) {
            AppMethodBeat.m2505o(11335);
            return 0;
        }
        int size = le.size();
        AppMethodBeat.m2505o(11335);
        return size;
    }

    public static String aet() {
        AppMethodBeat.m2504i(11336);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(11336);
        return stringBuffer2;
    }

    private static String aeu() {
        AppMethodBeat.m2504i(11337);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.type & 2048 desc, ");
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(11337);
        return stringBuffer2;
    }

    /* renamed from: a */
    public static void m40943a(StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(11338);
        stringBuilder.append("select bizinfo.username ");
        AppMethodBeat.m2505o(11338);
    }

    /* renamed from: b */
    private static void m40946b(StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(11339);
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.brandFlag");
        stringBuilder.append(", bizinfo.extInfo");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.type ");
        AppMethodBeat.m2505o(11339);
    }

    /* renamed from: c */
    public static void m40948c(StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(11340);
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag & ").append(C7616ad.dsh()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type & 1) != 0 ");
        AppMethodBeat.m2505o(11340);
    }

    /* renamed from: d */
    public static void m40949d(StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(11341);
        stringBuilder.append(" and bizinfo.type = 3 ");
        AppMethodBeat.m2505o(11341);
    }

    /* renamed from: a */
    private static void m40944a(StringBuilder stringBuilder, String str) {
        AppMethodBeat.m2504i(11342);
        stringBuilder.append(" and bizinfo.type = 3");
        stringBuilder.append(" and bizinfo.enterpriseFather = '").append(str).append("' ");
        AppMethodBeat.m2505o(11342);
    }

    /* renamed from: a */
    public static void m40945a(StringBuilder stringBuilder, boolean z) {
        AppMethodBeat.m2504i(11343);
        stringBuilder.append(" and (bizinfo.bitFlag & 1) ");
        stringBuilder.append(z ? "!=" : "==").append(" 0 ");
        AppMethodBeat.m2505o(11343);
    }

    /* renamed from: b */
    private static void m40947b(StringBuilder stringBuilder, boolean z) {
        AppMethodBeat.m2504i(11344);
        stringBuilder.append(" and (bizinfo.brandFlag & 1) ");
        stringBuilder.append(z ? "==" : "!=").append(" 0 ");
        AppMethodBeat.m2505o(11344);
    }

    /* renamed from: V */
    public static Cursor m40942V(String str, int i) {
        AppMethodBeat.m2504i(11345);
        StringBuilder stringBuilder = new StringBuilder();
        C25764e.m40946b(stringBuilder);
        C25764e.m40948c(stringBuilder);
        C25764e.m40944a(stringBuilder, str);
        C25764e.m40945a(stringBuilder, false);
        C25764e.m40947b(stringBuilder, true);
        stringBuilder.append(" and (bizinfo.acceptType & ").append(i).append(") > 0 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(C25764e.aet());
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", stringBuilder.toString());
        Cursor a = C1720g.m3536RP().eJN.mo10104a(r0, null, 0);
        AppMethodBeat.m2505o(11345);
        return a;
    }

    /* renamed from: qQ */
    public final Cursor mo43730qQ(String str) {
        String str2;
        AppMethodBeat.m2504i(11346);
        List<String> qS = C25764e.m40951qS(str);
        ArrayList arrayList = new ArrayList();
        for (String str22 : qS) {
            if (!C5046bo.isNullOrNil(mo43729qP(str22).adW())) {
                arrayList.add(str22);
            }
        }
        if (arrayList.size() <= 0) {
            AppMethodBeat.m2505o(11346);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C25764e.m40946b(stringBuilder);
        C25764e.m40948c(stringBuilder);
        C25764e.m40944a(stringBuilder, str);
        C25764e.m40947b(stringBuilder, true);
        stringBuilder.append(" and (");
        for (int i = 0; i < arrayList.size(); i++) {
            str22 = (String) arrayList.get(i);
            if (i > 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("rcontact.username = '").append(str22).append("'");
        }
        stringBuilder.append(") order by ");
        stringBuilder.append(C25764e.aeu());
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", stringBuilder.toString());
        Cursor a = C1720g.m3536RP().eJN.mo10104a(str22, null, 0);
        AppMethodBeat.m2505o(11346);
        return a;
    }

    public static List<String> aev() {
        AppMethodBeat.m2504i(11347);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rcontact.username");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.bitFlag & 1");
        C25764e.m40948c(stringBuilder);
        C25764e.m40949d(stringBuilder);
        stringBuilder.append(" and (");
        stringBuilder.append(" (bizinfo.bitFlag & 1) != 0");
        stringBuilder.append(" or ");
        stringBuilder.append(" (bizinfo.acceptType & 128) > 0 ");
        stringBuilder.append(" and (bizinfo.brandFlag & 1) == 0) ");
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", stringBuilder.toString());
        Cursor a = C1720g.m3536RP().eJN.mo10104a(r0, null, 2);
        ArrayList arrayList = new ArrayList();
        if (a == null) {
            AppMethodBeat.m2505o(11347);
            return arrayList;
        }
        while (a.moveToNext()) {
            int i;
            if (a.getInt(2) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                i = 0;
            } else {
                i = 1;
            }
            arrayList.add(a.getString(i));
        }
        a.close();
        List<String> eE = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15755eE(arrayList);
        AppMethodBeat.m2505o(11347);
        return eE;
    }

    /* renamed from: F */
    public static Cursor m40941F(String str, boolean z) {
        AppMethodBeat.m2504i(11348);
        StringBuilder stringBuilder = new StringBuilder();
        C25764e.m40946b(stringBuilder);
        C25764e.m40948c(stringBuilder);
        C25764e.m40944a(stringBuilder, str);
        C25764e.m40947b(stringBuilder, true);
        if (z) {
            C25764e.m40945a(stringBuilder, false);
        }
        stringBuilder.append(" order by ");
        stringBuilder.append(C25764e.aeu());
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", stringBuilder.toString());
        Cursor a = C1720g.m3536RP().eJN.mo10104a(r0, null, 0);
        AppMethodBeat.m2505o(11348);
        return a;
    }

    /* renamed from: qR */
    public static Cursor m40950qR(String str) {
        AppMethodBeat.m2504i(11349);
        StringBuilder stringBuilder = new StringBuilder();
        C25764e.m40946b(stringBuilder);
        C25764e.m40948c(stringBuilder);
        C25764e.m40944a(stringBuilder, str);
        C25764e.m40947b(stringBuilder, false);
        C25764e.m40945a(stringBuilder, false);
        stringBuilder.append(" order by ");
        stringBuilder.append(C25764e.aeu());
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", stringBuilder.toString());
        Cursor a = C1720g.m3536RP().eJN.mo10104a(r0, null, 0);
        AppMethodBeat.m2505o(11349);
        return a;
    }

    /* renamed from: qS */
    public static List<String> m40951qS(String str) {
        List<String> list = null;
        AppMethodBeat.m2504i(11350);
        StringBuilder stringBuilder = new StringBuilder();
        C25764e.m40943a(stringBuilder);
        C25764e.m40948c(stringBuilder);
        C25764e.m40944a(stringBuilder, str);
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", stringBuilder.toString());
        Cursor a = C1720g.m3536RP().eJN.mo10104a(r1, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(11350);
        } else {
            list = new ArrayList();
            while (a.moveToNext()) {
                list.add(a.getString(0));
            }
            a.close();
            AppMethodBeat.m2505o(11350);
        }
        return list;
    }

    /* renamed from: qT */
    public static String m40952qT(String str) {
        AppMethodBeat.m2504i(11351);
        String string;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
            AppMethodBeat.m2505o(11351);
            return null;
        } else if (fwe == null || !fwe.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            C25764e.m40943a(stringBuilder);
            C25764e.m40948c(stringBuilder);
            C25764e.m40944a(stringBuilder, str);
            C25764e.m40945a(stringBuilder, true);
            C4990ab.m7417i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", stringBuilder.toString());
            Cursor a = C1720g.m3536RP().eJN.mo10104a(string, null, 2);
            if (a == null) {
                AppMethodBeat.m2505o(11351);
                return null;
            }
            if (a.moveToFirst()) {
                string = a.getString(0);
                fwe.put(str, string);
            } else {
                string = null;
            }
            a.close();
            AppMethodBeat.m2505o(11351);
            return string;
        } else {
            string = (String) fwe.get(str);
            if (C5046bo.isNullOrNil(string) || !C1855t.m3912mY(string)) {
                AppMethodBeat.m2505o(11351);
                return null;
            }
            AppMethodBeat.m2505o(11351);
            return string;
        }
    }

    public static List<String> aew() {
        AppMethodBeat.m2504i(11352);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.username");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where bizinfo.specialType = 1");
        stringBuilder.append(" and rcontact.username = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag & ").append(C7616ad.dsh()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type & 1) != 0 ");
        C4990ab.m7417i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", stringBuilder.toString());
        ArrayList arrayList = new ArrayList();
        Cursor a = C1720g.m3536RP().eJN.mo10104a(r0, null, 2);
        int columnIndex = a.getColumnIndex("username");
        while (a.moveToNext()) {
            arrayList.add(a.getString(columnIndex));
        }
        a.close();
        AppMethodBeat.m2505o(11352);
        return arrayList;
    }

    /* renamed from: qU */
    public static boolean m40953qU(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(11353);
        if (C5046bo.isNullOrNil(str) || !C17903f.m28110rd(str)) {
            AppMethodBeat.m2505o(11353);
        } else {
            C16527d qX = C17903f.m28104qX(str);
            if (!(qX.mo30481cJ(false) == null || qX.mo30481cJ(false).aer() == null || C5046bo.isNullOrNil(qX.adX()))) {
                C7617ak apn = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apn(qX.adX());
                if (apn != null && apn.field_username.equals(str) && apn.field_unReadCount > 0) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apb(qX.adX());
                }
            }
            Cursor Rk = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15257Rk(str);
            Rk.moveToFirst();
            while (!Rk.isAfterLast()) {
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(Rk);
                c7620bi.setStatus(4);
                C4990ab.m7410d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + c7620bi.field_msgSvrId + " status = " + c7620bi.field_status);
                Rk.moveToNext();
                z = true;
            }
            Rk.close();
            if (z) {
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apb(str);
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15255Ri(str);
            }
            AppMethodBeat.m2505o(11353);
        }
        return z;
    }

    /* renamed from: qV */
    public static void m40954qV(String str) {
        AppMethodBeat.m2504i(11354);
        if (C5046bo.isNullOrNil(str) || !C17903f.m28110rd(str)) {
            AppMethodBeat.m2505o(11354);
            return;
        }
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41582jO(str);
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41566BV();
        AppMethodBeat.m2505o(11354);
    }

    /* renamed from: qW */
    public static void m40955qW(String str) {
        AppMethodBeat.m2504i(11355);
        if (C5046bo.isNullOrNil(str) || !C17903f.m28110rd(str)) {
            AppMethodBeat.m2505o(11355);
            return;
        }
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41582jO("");
        AppMethodBeat.m2505o(11355);
    }
}
