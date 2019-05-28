package com.tencent.mm.aj;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class e extends j<d> {
    public static final String[] diI = new String[]{"CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) "};
    public static final String[] fnj = new String[]{j.a(d.ccO, "bizinfo")};
    public static Map<String, String> fwe = new HashMap();
    private final l<a, b> fuL = new l<a, b>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(11322);
            ((a) obj).a((b) obj2);
            AppMethodBeat.o(11322);
        }
    };

    public interface a {

        public static class b {
            public String fuO;
            public boolean fvo;
            public a fwk;
            public d fwl;
        }

        public enum a {
            INSTERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.o(11325);
            }
        }

        void a(b bVar);
    }

    static {
        AppMethodBeat.i(11358);
        AppMethodBeat.o(11358);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.ccO, "bizinfo", diI);
        AppMethodBeat.i(11326);
        AppMethodBeat.o(11326);
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(11327);
        this.fuL.a(aVar, looper);
        AppMethodBeat.o(11327);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(11328);
        if (this.fuL != null) {
            this.fuL.remove(aVar);
        }
        AppMethodBeat.o(11328);
    }

    public final d qP(String str) {
        AppMethodBeat.i(11329);
        c dVar = new d();
        dVar.field_username = str;
        super.b(dVar, new String[0]);
        AppMethodBeat.o(11329);
        return dVar;
    }

    public final void delete(String str) {
        AppMethodBeat.i(11330);
        c dVar = new d();
        dVar.field_username = str;
        String[] strArr = new String[]{"username"};
        ab.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.a(dVar, strArr)), str);
        b bVar = new b();
        bVar.fuO = str;
        bVar.fwk = a.DELETE;
        bVar.fwl = dVar;
        this.fuL.cF(bVar);
        this.fuL.doNotify();
        AppMethodBeat.o(11330);
    }

    public final void c(d dVar) {
        AppMethodBeat.i(11331);
        String[] strArr = new String[]{"username"};
        ab.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.a((c) dVar, strArr)), dVar.field_username);
        b bVar = new b();
        bVar.fuO = dVar.field_username;
        bVar.fwk = a.DELETE;
        bVar.fwl = dVar;
        this.fuL.cF(bVar);
        this.fuL.doNotify();
        AppMethodBeat.o(11331);
    }

    public final boolean d(d dVar) {
        AppMethodBeat.i(11332);
        dVar.field_updateTime = System.currentTimeMillis();
        dVar.adK();
        ab.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", dVar.field_username, dVar.field_brandList, Integer.valueOf(dVar.field_brandFlag), dVar.field_brandInfo, dVar.field_extInfo, dVar.field_brandIconURL, Long.valueOf(dVar.field_updateTime));
        b cJ = dVar.cJ(false);
        if (cJ != null) {
            b.b aej = cJ.aej();
            if (aej != null) {
                dVar.field_specialType = aej.fvJ;
            }
        }
        boolean b = super.b((c) dVar);
        if (b && !t.kH(dVar.field_username)) {
            b bVar = new b();
            bVar.fuO = dVar.field_username;
            bVar.fvo = dVar.adL();
            bVar.fwk = a.INSTERT;
            bVar.fwl = dVar;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11332);
        return b;
    }

    public final boolean e(d dVar) {
        AppMethodBeat.i(11333);
        dVar.field_updateTime = System.currentTimeMillis();
        dVar.adK();
        b cJ = dVar.cJ(false);
        if (cJ != null) {
            b.b aej = cJ.aej();
            if (aej != null) {
                dVar.field_specialType = aej.fvJ;
            }
        }
        boolean a = super.a(dVar);
        if (a && !t.kH(dVar.field_username)) {
            b bVar = new b();
            bVar.fuO = dVar.field_username;
            bVar.fvo = dVar.adL();
            bVar.fwk = a.UPDATE;
            bVar.fwl = dVar;
            this.fuL.cF(bVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11333);
        return a;
    }

    public final List<String> le(int i) {
        AppMethodBeat.i(11334);
        ab.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[]{"username", "bizinfo", "acceptType", Integer.valueOf(i)}));
        long yz = bo.yz();
        Cursor rawQuery = rawQuery(r0, new String[0]);
        LinkedList linkedList = new LinkedList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            ab.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", Integer.valueOf(i), Long.valueOf(bo.az(yz)));
            List eE = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().eE(linkedList);
            AppMethodBeat.o(11334);
            return eE;
        }
        ab.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", Integer.valueOf(i), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(11334);
        return linkedList;
    }

    public final int lf(int i) {
        AppMethodBeat.i(11335);
        List le = le(i);
        if (bo.ek(le)) {
            AppMethodBeat.o(11335);
            return 0;
        }
        int size = le.size();
        AppMethodBeat.o(11335);
        return size;
    }

    public static String aet() {
        AppMethodBeat.i(11336);
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
        AppMethodBeat.o(11336);
        return stringBuffer2;
    }

    private static String aeu() {
        AppMethodBeat.i(11337);
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
        AppMethodBeat.o(11337);
        return stringBuffer2;
    }

    public static void a(StringBuilder stringBuilder) {
        AppMethodBeat.i(11338);
        stringBuilder.append("select bizinfo.username ");
        AppMethodBeat.o(11338);
    }

    private static void b(StringBuilder stringBuilder) {
        AppMethodBeat.i(11339);
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
        AppMethodBeat.o(11339);
    }

    public static void c(StringBuilder stringBuilder) {
        AppMethodBeat.i(11340);
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag & ").append(ad.dsh()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type & 1) != 0 ");
        AppMethodBeat.o(11340);
    }

    public static void d(StringBuilder stringBuilder) {
        AppMethodBeat.i(11341);
        stringBuilder.append(" and bizinfo.type = 3 ");
        AppMethodBeat.o(11341);
    }

    private static void a(StringBuilder stringBuilder, String str) {
        AppMethodBeat.i(11342);
        stringBuilder.append(" and bizinfo.type = 3");
        stringBuilder.append(" and bizinfo.enterpriseFather = '").append(str).append("' ");
        AppMethodBeat.o(11342);
    }

    public static void a(StringBuilder stringBuilder, boolean z) {
        AppMethodBeat.i(11343);
        stringBuilder.append(" and (bizinfo.bitFlag & 1) ");
        stringBuilder.append(z ? "!=" : "==").append(" 0 ");
        AppMethodBeat.o(11343);
    }

    private static void b(StringBuilder stringBuilder, boolean z) {
        AppMethodBeat.i(11344);
        stringBuilder.append(" and (bizinfo.brandFlag & 1) ");
        stringBuilder.append(z ? "==" : "!=").append(" 0 ");
        AppMethodBeat.o(11344);
    }

    public static Cursor V(String str, int i) {
        AppMethodBeat.i(11345);
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        a(stringBuilder, false);
        b(stringBuilder, true);
        stringBuilder.append(" and (bizinfo.acceptType & ").append(i).append(") > 0 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(aet());
        ab.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", stringBuilder.toString());
        Cursor a = g.RP().eJN.a(r0, null, 0);
        AppMethodBeat.o(11345);
        return a;
    }

    public final Cursor qQ(String str) {
        String str2;
        AppMethodBeat.i(11346);
        List<String> qS = qS(str);
        ArrayList arrayList = new ArrayList();
        for (String str22 : qS) {
            if (!bo.isNullOrNil(qP(str22).adW())) {
                arrayList.add(str22);
            }
        }
        if (arrayList.size() <= 0) {
            AppMethodBeat.o(11346);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        stringBuilder.append(" and (");
        for (int i = 0; i < arrayList.size(); i++) {
            str22 = (String) arrayList.get(i);
            if (i > 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("rcontact.username = '").append(str22).append("'");
        }
        stringBuilder.append(") order by ");
        stringBuilder.append(aeu());
        ab.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", stringBuilder.toString());
        Cursor a = g.RP().eJN.a(str22, null, 0);
        AppMethodBeat.o(11346);
        return a;
    }

    public static List<String> aev() {
        AppMethodBeat.i(11347);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rcontact.username");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.bitFlag & 1");
        c(stringBuilder);
        d(stringBuilder);
        stringBuilder.append(" and (");
        stringBuilder.append(" (bizinfo.bitFlag & 1) != 0");
        stringBuilder.append(" or ");
        stringBuilder.append(" (bizinfo.acceptType & 128) > 0 ");
        stringBuilder.append(" and (bizinfo.brandFlag & 1) == 0) ");
        ab.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", stringBuilder.toString());
        Cursor a = g.RP().eJN.a(r0, null, 2);
        ArrayList arrayList = new ArrayList();
        if (a == null) {
            AppMethodBeat.o(11347);
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
        List<String> eE = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().eE(arrayList);
        AppMethodBeat.o(11347);
        return eE;
    }

    public static Cursor F(String str, boolean z) {
        AppMethodBeat.i(11348);
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        if (z) {
            a(stringBuilder, false);
        }
        stringBuilder.append(" order by ");
        stringBuilder.append(aeu());
        ab.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", stringBuilder.toString());
        Cursor a = g.RP().eJN.a(r0, null, 0);
        AppMethodBeat.o(11348);
        return a;
    }

    public static Cursor qR(String str) {
        AppMethodBeat.i(11349);
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, false);
        a(stringBuilder, false);
        stringBuilder.append(" order by ");
        stringBuilder.append(aeu());
        ab.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", stringBuilder.toString());
        Cursor a = g.RP().eJN.a(r0, null, 0);
        AppMethodBeat.o(11349);
        return a;
    }

    public static List<String> qS(String str) {
        List<String> list = null;
        AppMethodBeat.i(11350);
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        ab.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", stringBuilder.toString());
        Cursor a = g.RP().eJN.a(r1, null, 2);
        if (a == null) {
            AppMethodBeat.o(11350);
        } else {
            list = new ArrayList();
            while (a.moveToNext()) {
                list.add(a.getString(0));
            }
            a.close();
            AppMethodBeat.o(11350);
        }
        return list;
    }

    public static String qT(String str) {
        AppMethodBeat.i(11351);
        String string;
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
            AppMethodBeat.o(11351);
            return null;
        } else if (fwe == null || !fwe.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            a(stringBuilder);
            c(stringBuilder);
            a(stringBuilder, str);
            a(stringBuilder, true);
            ab.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", stringBuilder.toString());
            Cursor a = g.RP().eJN.a(string, null, 2);
            if (a == null) {
                AppMethodBeat.o(11351);
                return null;
            }
            if (a.moveToFirst()) {
                string = a.getString(0);
                fwe.put(str, string);
            } else {
                string = null;
            }
            a.close();
            AppMethodBeat.o(11351);
            return string;
        } else {
            string = (String) fwe.get(str);
            if (bo.isNullOrNil(string) || !t.mY(string)) {
                AppMethodBeat.o(11351);
                return null;
            }
            AppMethodBeat.o(11351);
            return string;
        }
    }

    public static List<String> aew() {
        AppMethodBeat.i(11352);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.username");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where bizinfo.specialType = 1");
        stringBuilder.append(" and rcontact.username = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag & ").append(ad.dsh()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type & 1) != 0 ");
        ab.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", stringBuilder.toString());
        ArrayList arrayList = new ArrayList();
        Cursor a = g.RP().eJN.a(r0, null, 2);
        int columnIndex = a.getColumnIndex("username");
        while (a.moveToNext()) {
            arrayList.add(a.getString(columnIndex));
        }
        a.close();
        AppMethodBeat.o(11352);
        return arrayList;
    }

    public static boolean qU(String str) {
        boolean z = false;
        AppMethodBeat.i(11353);
        if (bo.isNullOrNil(str) || !f.rd(str)) {
            AppMethodBeat.o(11353);
        } else {
            d qX = f.qX(str);
            if (!(qX.cJ(false) == null || qX.cJ(false).aer() == null || bo.isNullOrNil(qX.adX()))) {
                ak apn = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().apn(qX.adX());
                if (apn != null && apn.field_username.equals(str) && apn.field_unReadCount > 0) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().apb(qX.adX());
                }
            }
            Cursor Rk = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Rk(str);
            Rk.moveToFirst();
            while (!Rk.isAfterLast()) {
                bi biVar = new bi();
                biVar.d(Rk);
                biVar.setStatus(4);
                ab.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + biVar.field_msgSvrId + " status = " + biVar.field_status);
                Rk.moveToNext();
                z = true;
            }
            Rk.close();
            if (z) {
                ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().apb(str);
                ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Ri(str);
            }
            AppMethodBeat.o(11353);
        }
        return z;
    }

    public static void qV(String str) {
        AppMethodBeat.i(11354);
        if (bo.isNullOrNil(str) || !f.rd(str)) {
            AppMethodBeat.o(11354);
            return;
        }
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().jO(str);
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().BV();
        AppMethodBeat.o(11354);
    }

    public static void qW(String str) {
        AppMethodBeat.i(11355);
        if (bo.isNullOrNil(str) || !f.rd(str)) {
            AppMethodBeat.o(11355);
            return;
        }
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().jO("");
        AppMethodBeat.o(11355);
    }
}
