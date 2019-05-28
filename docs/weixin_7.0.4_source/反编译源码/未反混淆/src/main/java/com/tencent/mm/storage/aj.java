package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.cd.d;
import com.tencent.mm.cd.h;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd.a;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class aj extends n implements bd {
    public static final String[] diI = new String[]{"CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) "};
    public static final String[] fnj = new String[]{j.a(ad.ccO, "rcontact"), j.a(ad.ccO, "bottlecontact"), j.a(ae.ccO, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );"};
    private static String xXn = "showHead = 32";
    private static String xXo = "type & 64 !=0 ";
    private e bSd;
    private final l<a, ad> fuL = new l<a, ad>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(1103);
            ((a) obj).a(aj.this, (ad) obj2);
            AppMethodBeat.o(1103);
        }
    };
    private e xXk;
    public final f<String, ad> xXl = new c(200);
    public final f<String, Integer> xXm = new c(400);

    private static String aoG(String str) {
        AppMethodBeat.i(1104);
        String str2 = "select *,rowid from " + aoH(str) + " ";
        AppMethodBeat.o(1104);
        return str2;
    }

    private static String aoH(String str) {
        AppMethodBeat.i(1105);
        String str2;
        if (ad.mR(str)) {
            str2 = "bottlecontact";
            AppMethodBeat.o(1105);
            return str2;
        }
        str2 = "rcontact";
        AppMethodBeat.o(1105);
        return str2;
    }

    static {
        AppMethodBeat.i(1192);
        AppMethodBeat.o(1192);
    }

    public aj(h hVar) {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.i(1106);
        Cursor a = hVar.a("PRAGMA table_info( contact_ext )", null, 2);
        int columnIndex = a.getColumnIndex("name");
        int i3 = 0;
        int i4 = 0;
        while (a.moveToNext() && (i4 == 0 || i3 == 0)) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("weiboNickname".equalsIgnoreCase(string)) {
                    i3 = 1;
                } else if ("weiboFlag".equalsIgnoreCase(string)) {
                    i4 = 1;
                }
            }
        }
        a.close();
        if (i4 == 0) {
            hVar.hY("contact_ext", "Alter table contact_ext add weiboFlag INT DEFAULT 0 ");
        }
        if (i3 == 0) {
            hVar.hY("contact_ext", "Alter table contact_ext add weiboNickname INT DEFAULT 0 ");
        }
        Cursor a2 = hVar.a("PRAGMA table_info( rcontact )", null, 2);
        i4 = a2.getColumnIndex("name");
        while (a2.moveToNext()) {
            if (i4 >= 0) {
                if ("verifyFlag".equalsIgnoreCase(a2.getString(i4))) {
                    break;
                }
            }
        }
        i = 0;
        a2.close();
        if (i == 0) {
            hVar.hY("rcontact", "Alter table rcontact add verifyFlag INT DEFAULT 0 ");
        }
        for (String hY : j.a(com.tencent.mm.n.a.ccO, "bottlecontact", (e) hVar)) {
            hVar.hY("bottlecontact", hY);
        }
        for (String hY2 : j.a(com.tencent.mm.n.a.ccO, "rcontact", (e) hVar)) {
            hVar.hY("rcontact", hY2);
        }
        String[] strArr = diI;
        i = strArr.length;
        while (i2 < i) {
            hVar.hY("rcontact", strArr[i2]);
            i2++;
        }
        this.bSd = hVar;
        this.xXk = hVar;
        AppMethodBeat.o(1106);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(1107);
        this.fuL.a(aVar, null);
        AppMethodBeat.o(1107);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_NO_FACE);
        if (this.fuL != null) {
            this.fuL.remove(aVar);
        }
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_NO_FACE);
    }

    public final ad aoI(String str) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_SHIFTING);
        ad adVar = (ad) this.xXl.ai(str);
        if (adVar != null) {
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_SHIFTING);
            return adVar;
        }
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_SHIFTING);
        return null;
    }

    public final void W(ad adVar) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_DARK);
        if (adVar == null || adVar.field_username == null || adVar.field_type == 0) {
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_DARK);
            return;
        }
        this.xXl.k(adVar.field_username, adVar);
        this.xXm.k(adVar.field_username, Integer.valueOf(adVar.field_type));
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_DARK);
    }

    private void MQ(String str) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_HACKER);
        if (!bo.isNullOrNil(str)) {
            this.xXl.remove(str);
            this.xXm.remove(str);
        }
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_HACKER);
    }

    public final boolean aoJ(String str) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_BRIGHT);
        if (bo.isNullOrNil(str) || (str.contains("@") && !str.endsWith("@stranger"))) {
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_BRIGHT);
            return false;
        }
        Integer num = (Integer) this.xXm.get(str);
        boolean jh;
        if (num != null) {
            jh = com.tencent.mm.n.a.jh(num.intValue());
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_BRIGHT);
            return jh;
        }
        ad aoO = aoO(str);
        if (aoO == null || !(aoO.field_username.equals(str) || str.equals(aoO.field_encryptUsername))) {
            this.xXm.k(str, Integer.valueOf(0));
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_BRIGHT);
            return false;
        }
        this.xXm.k(str, Integer.valueOf(aoO.field_type));
        jh = com.tencent.mm.n.a.jh(aoO.field_type);
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_BRIGHT);
        return jh;
    }

    public final ad aoK(String str) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_RIGHT);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_RIGHT);
            return null;
        }
        ad adVar = new ad();
        Cursor a = this.bSd.a("select *,rowid from rcontact where alias=" + h.escape(str), null, 2);
        if (a.moveToFirst()) {
            adVar.d(a);
            W(adVar);
        }
        a.close();
        adVar.dsk();
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_RIGHT);
        return adVar;
    }

    public final Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_UP);
        String str3 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + e(str, str2, list) + ey(list2) + dsx();
        ab.v("MicroMsg.ContactStorage", str3);
        Cursor a;
        if (z) {
            com.tencent.mm.cd.a.f[] fVarArr = new com.tencent.mm.cd.a.f[2];
            String str4 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + l(list, z2) + dsy();
            ab.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str3)));
            a = this.bSd.a(str4, null, 4);
            Cursor a2 = this.bSd.a(str3, null, 4);
            if ((a instanceof com.tencent.mm.cd.a.f) && (a2 instanceof com.tencent.mm.cd.a.f)) {
                fVarArr[0] = (com.tencent.mm.cd.a.f) a;
                fVarArr[1] = (com.tencent.mm.cd.a.f) a2;
                com.tencent.mm.cd.a.e eVar = new com.tencent.mm.cd.a.e(fVarArr);
                AppMethodBeat.o(FaceManager.FACE_ACQUIRED_UP);
                return eVar;
            }
            a = d.dvo();
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_UP);
            return a;
        }
        a = this.bSd.a(str3, null, 4);
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_UP);
        return a;
    }

    public final List<String> dsq() {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_DOWN);
        Cursor a = this.bSd.a(" select acctTypeId from OpenIMAppIdInfo where appid in (" + (" select openImAppid from rcontact" + dsE() + " group by openImAppid ") + ") group by acctTypeId", null, 4);
        LinkedList linkedList = new LinkedList();
        if (a.moveToFirst()) {
            do {
                String string = a.getString(0);
                if (!bo.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            } while (a.moveToNext());
        }
        a.close();
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_DOWN);
        return linkedList;
    }

    private static String a(String str, List<String> list, String str2, List<String> list2) {
        Iterator it;
        String str3;
        AppMethodBeat.i(FaceManager.FACE_WITH_EYES_CLOSED);
        String str4 = (str + " and OpenIMWordingInfo.language='" + str2 + "' ") + dsE();
        String str5 = "";
        if (list2 != null && list2.size() > 0) {
            it = list2.iterator();
            while (true) {
                str3 = str5;
                if (!it.hasNext()) {
                    break;
                }
                str5 = (String) it.next();
                if (str3.equals("")) {
                    str3 = str3 + " and (";
                } else {
                    str3 = str3 + " or ";
                }
                str5 = str3 + "openImAppid == '" + str5 + "'";
            }
            str5 = str3 + " )";
        }
        str4 = str4 + str5;
        str5 = "";
        if (list != null && list.size() > 0) {
            it = list.iterator();
            while (true) {
                str3 = str5;
                if (!it.hasNext()) {
                    break;
                }
                str5 = str3 + " and username != '" + ((String) it.next()) + "'";
            }
            str5 = str3;
        }
        ab.v("MicroMsg.ContactStorage", "getOpenIMCursor:%s", str4 + str5);
        AppMethodBeat.o(FaceManager.FACE_WITH_EYES_CLOSED);
        return str4 + str5;
    }

    public final Cursor a(List<String> list, String str, List<String> list2) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_NO_FOCUS);
        Cursor a = this.bSd.a(a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", list, str, list2) + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ", null, 4);
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_NO_FOCUS);
        return a;
    }

    public final Cursor b(List<String> list, String str, List<String> list2) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_MOUTH_OCCLUSION);
        ab.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", (a("select count(*)  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", list, str, list2) + "group by OpenIMWordingInfo.wording ") + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ");
        Cursor a = this.bSd.a(r0, null, 4);
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_MOUTH_OCCLUSION);
        return a;
    }

    public final Cursor c(List<String> list, String str, List<String> list2) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_NOSE_OCCLUSION);
        ab.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", (a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", list, str, list2) + "group by OpenIMWordingInfo.wording ") + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ");
        Cursor a = this.bSd.a(r0, null, 4);
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_NOSE_OCCLUSION);
        return a;
    }

    public final Cursor aoL(String str) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_MULTI_FACE);
        Cursor a = this.bSd.a(str, null, 4);
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_MULTI_FACE);
        return a;
    }

    public final Cursor eu(List<String> list) {
        boolean z;
        int i = 0;
        AppMethodBeat.i(1122);
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,type from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        Cursor rawQuery = this.bSd.rawQuery(str + dsx(), null);
        AppMethodBeat.o(1122);
        return rawQuery;
    }

    public final Cursor ev(List<String> list) {
        boolean z;
        int i = 0;
        AppMethodBeat.i(1123);
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        Cursor rawQuery = this.bSd.rawQuery(str + dsx(), null);
        AppMethodBeat.o(1123);
        return rawQuery;
    }

    public final Cursor b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        AppMethodBeat.i(1124);
        String str3 = "select username from rcontact " + e(str, str2, list) + ey(list2) + dsx();
        ab.v("MicroMsg.ContactStorage", str3);
        Cursor a;
        if (z) {
            com.tencent.mm.cd.a.f[] fVarArr = new com.tencent.mm.cd.a.f[2];
            String str4 = "select username from rcontact " + l(list, z2) + dsy();
            ab.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str3)));
            a = this.bSd.a(str4, null, 4);
            Cursor a2 = this.bSd.a(str3, null, 4);
            if ((a instanceof com.tencent.mm.cd.a.f) && (a2 instanceof com.tencent.mm.cd.a.f)) {
                fVarArr[0] = (com.tencent.mm.cd.a.f) a;
                fVarArr[1] = (com.tencent.mm.cd.a.f) a2;
                com.tencent.mm.cd.a.e eVar = new com.tencent.mm.cd.a.e(fVarArr);
                AppMethodBeat.o(1124);
                return eVar;
            }
            a = d.dvo();
            AppMethodBeat.o(1124);
            return a;
        }
        a = this.bSd.rawQuery(str3, null);
        AppMethodBeat.o(1124);
        return a;
    }

    public final ad aoM(String str) {
        AppMethodBeat.i(1125);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1125);
            return null;
        }
        if (ad.mR(str)) {
            str = ad.aoC(str);
        }
        ad aoI = aoI(str);
        if (aoI != null) {
            aoI.dsk();
            AppMethodBeat.o(1125);
            return aoI;
        }
        aoI = new ad();
        Cursor a = this.bSd.a(aoG(str) + " where username=" + h.escape(str), null, 2);
        if (a.moveToFirst()) {
            aoI.d(a);
            W(aoI);
        }
        a.close();
        aoI.dsk();
        AppMethodBeat.o(1125);
        return aoI;
    }

    public final ad aoN(String str) {
        AppMethodBeat.i(1126);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1126);
            return null;
        }
        if (ad.mR(str)) {
            str = ad.aoC(str);
        }
        ad aoI = aoI(str);
        if (aoI != null) {
            AppMethodBeat.o(1126);
            return aoI;
        }
        aoI = new ad();
        Cursor a = this.bSd.a(aoG(str) + " where username=" + h.escape(str) + " or encryptUsername=" + h.escape(str), null, 2);
        if (a.moveToFirst()) {
            aoI.d(a);
            W(aoI);
        }
        a.close();
        AppMethodBeat.o(1126);
        return aoI;
    }

    public final ad aoO(String str) {
        AppMethodBeat.i(1127);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1127);
            return null;
        }
        if (ad.mR(str)) {
            str = ad.aoC(str);
        }
        ad aoI = aoI(str);
        if (aoI != null) {
            AppMethodBeat.o(1127);
            return aoI;
        }
        aoI = new ad();
        Cursor a = this.bSd.a(aoG(str) + " where username=" + h.escape(str) + " or encryptUsername=" + h.escape(str), null, 2);
        if (a.moveToFirst()) {
            aoI.d(a);
            a.close();
            aoI.dsk();
            W(aoI);
        } else {
            a.close();
        }
        AppMethodBeat.o(1127);
        return aoI;
    }

    public final ad mQ(long j) {
        ad adVar = null;
        AppMethodBeat.i(1128);
        if (j <= 0) {
            AppMethodBeat.o(1128);
        } else {
            Cursor a = this.bSd.a("select * ,rowid from rcontact  where rowid=".concat(String.valueOf(j)), null, 2);
            if (a.moveToFirst()) {
                adVar = new ad();
                adVar.d(a);
                W(adVar);
            }
            a.close();
            if (adVar != null) {
                adVar.dsk();
            }
            AppMethodBeat.o(1128);
        }
        return adVar;
    }

    public final long aoP(String str) {
        AppMethodBeat.i(1129);
        long j = -1;
        ad aoO = aoO(str);
        if (aoO != null && aoO.ewQ > 0) {
            j = (long) ((int) aoO.ewQ);
        }
        AppMethodBeat.o(1129);
        return j;
    }

    public final boolean aoQ(String str) {
        AppMethodBeat.i(1130);
        ad aoO = aoO(str);
        if (aoO == null || bo.isNullOrNil(aoO.field_username) || !aoO.field_username.equals(str)) {
            AppMethodBeat.o(1130);
            return false;
        }
        AppMethodBeat.o(1130);
        return true;
    }

    public final boolean aoR(String str) {
        boolean z = false;
        AppMethodBeat.i(1131);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1131);
        } else {
            Cursor a = this.bSd.a("select count(*) from " + aoH(str) + " where type & " + com.tencent.mm.n.a.NT() + " !=0 and username=" + h.escape(str), null, 2);
            if (a.moveToFirst() && a.getInt(0) > 0) {
                z = true;
            }
            a.close();
            AppMethodBeat.o(1131);
        }
        return z;
    }

    public final boolean Y(ad adVar) {
        AppMethodBeat.i(1132);
        Assert.assertTrue("contact NULL !", adVar != null);
        if (ab(adVar)) {
            boolean z;
            adVar.hu(adVar.Ny());
            this.fuL.cF(adVar);
            this.fuL.doNotify();
            ab.d("MicroMsg.ContactStorage", "replace : username=%s, showHead=%d, verifyFlag=%d", adVar.field_username, Integer.valueOf(adVar.field_showHead), Integer.valueOf(adVar.field_verifyFlag));
            ContentValues Hl = adVar.Hl();
            if (((int) adVar.ewQ) > 0) {
                Hl.put("rowid", Integer.valueOf((int) adVar.ewQ));
            }
            if (this.bSd.replace(aoH(adVar.field_username), com.tencent.mm.n.a.ccO.xDc, Hl) > 0) {
                z = true;
            } else {
                z = false;
            }
            MQ(adVar.field_username);
            if (!bo.isNullOrNil(adVar.field_encryptUsername)) {
                MQ(adVar.field_encryptUsername);
            }
            if (z) {
                b(4, this, adVar.field_username);
                AppMethodBeat.o(1132);
                return true;
            }
            AppMethodBeat.o(1132);
            return false;
        }
        AppMethodBeat.o(1132);
        return true;
    }

    public final boolean Z(ad adVar) {
        AppMethodBeat.i(1133);
        if (aa(adVar) > 0) {
            AppMethodBeat.o(1133);
            return true;
        }
        AppMethodBeat.o(1133);
        return false;
    }

    public final int F(String str, byte[] bArr) {
        int i = -1;
        AppMethodBeat.i(1135);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            AppMethodBeat.o(1135);
            return -1;
        }
        ae aeVar = new ae();
        aeVar.field_cmdbuf = bArr;
        aeVar.field_username = str;
        int replace = (int) this.bSd.replace("ContactCmdBuf", "username", aeVar.Hl());
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "setCmdbuf user:%s buf:%d result:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(replace);
        ab.d(str2, str3, objArr);
        AppMethodBeat.o(1135);
        return replace;
    }

    public final byte[] aoS(String str) {
        AppMethodBeat.i(1136);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            AppMethodBeat.o(1136);
            return null;
        }
        int i;
        ae aeVar = new ae();
        Cursor a = this.bSd.a("ContactCmdBuf", null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            aeVar.d(a);
        }
        a.close();
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "getCmdbuf user:%s buf:%d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (aeVar.field_cmdbuf == null) {
            i = -1;
        } else {
            i = aeVar.field_cmdbuf.length;
        }
        objArr[1] = Integer.valueOf(i);
        ab.d(str2, str3, objArr);
        byte[] bArr = aeVar.field_cmdbuf;
        AppMethodBeat.o(1136);
        return bArr;
    }

    public final int aoT(String str) {
        AppMethodBeat.i(1137);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
            AppMethodBeat.o(1137);
            return -1;
        }
        ab.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", str, Integer.valueOf(this.bSd.delete("ContactCmdBuf", "username=?", new String[]{String.valueOf(str)})));
        AppMethodBeat.o(1137);
        return this.bSd.delete("ContactCmdBuf", "username=?", new String[]{String.valueOf(str)});
    }

    public final int aoU(String str) {
        AppMethodBeat.i(1138);
        Assert.assertTrue(str.length() > 0);
        if (ad.mR(str)) {
            str = ad.aoC(str);
        }
        MQ(str);
        ad adVar = new ad(str);
        adVar.setType(0);
        adVar.setUsername("fake_" + bo.anU());
        adVar.iH("fake_" + bo.anU());
        adVar.setSource(0);
        int update = this.bSd.update(aoH(str), adVar.Hl(), "username=?", new String[]{String.valueOf(str)});
        aoT(str);
        ab.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", str, Integer.valueOf(update), bo.dpG());
        if (update == 0) {
            AppMethodBeat.o(1138);
        } else {
            b(5, this, str);
            AppMethodBeat.o(1138);
        }
        return update;
    }

    public final int b(String str, ad adVar) {
        AppMethodBeat.i(1139);
        ab.i("MicroMsg.ContactStorage", "begin to update contact : ".concat(String.valueOf(str)));
        if (ab(adVar)) {
            int update;
            long currentTimeMillis = System.currentTimeMillis();
            if (ad.mR(str)) {
                str = ad.aoC(str);
            }
            adVar.hu(adVar.Ny());
            this.fuL.cF(adVar);
            this.fuL.doNotify();
            ContentValues Hl = adVar.Hl();
            if (((int) adVar.ewQ) > 0) {
                Hl.put("rowid", Integer.valueOf((int) adVar.ewQ));
            }
            if (Hl.size() > 0) {
                update = this.bSd.update(aoH(str), Hl, "username=?", new String[]{String.valueOf(str)});
            } else {
                update = 0;
            }
            ab.i("MicroMsg.ContactStorage", "update : username=%s, showHead=%d, verifyFlag=%d, result1=%d, take[%d]ms", adVar.field_username, Integer.valueOf(adVar.field_showHead), Integer.valueOf(adVar.field_verifyFlag), Integer.valueOf(update), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            MQ(str);
            if (!bo.isNullOrNil(adVar.field_encryptUsername)) {
                MQ(adVar.field_encryptUsername);
            }
            if (update != 0) {
                b(4, this, str);
            }
            AppMethodBeat.o(1139);
            return update;
        }
        AppMethodBeat.o(1139);
        return 1;
    }

    public final int c(String str, ad adVar) {
        int i = 0;
        AppMethodBeat.i(1140);
        if (bo.isNullOrNil(str) || adVar == null || bo.isNullOrNil(adVar.field_username)) {
            ab.e("MicroMsg.ContactStorage", "update : wrong input!");
            AppMethodBeat.o(1140);
            return 0;
        }
        ab.d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + adVar.field_username + " enUsername: " + str);
        if (ab(adVar)) {
            if (ad.mR(adVar.field_username)) {
                adVar.setUsername(ad.aoC(adVar.field_username));
            }
            adVar.hu(adVar.Ny());
            this.fuL.cF(adVar);
            this.fuL.doNotify();
            ab.d("MicroMsg.ContactStorage", "update : oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", str, adVar.field_username, Integer.valueOf(adVar.field_showHead), Integer.valueOf(adVar.field_verifyFlag));
            ContentValues Hl = adVar.Hl();
            ad adVar2;
            if (adVar.ewQ <= 0) {
                adVar2 = new ad(str);
                adVar2.setType(0);
                adVar2.setUsername("fake_" + bo.anU());
                adVar2.iH("fake_" + bo.anU());
                ab.d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + aoH(str) + " user :" + str + ", res:" + this.bSd.update(aoH(str), adVar2.Hl(), "username=?", new String[]{String.valueOf(str)}));
                if (Hl.size() > 0) {
                    i = (int) this.bSd.replace(aoH(adVar.field_username), com.tencent.mm.n.a.ccO.xDc, Hl);
                }
            } else if (!str.equals(adVar.field_username)) {
                adVar2 = new ad(str);
                adVar2.setType(0);
                adVar2.setUsername("fake_" + bo.anU());
                adVar2.iH("fake_" + bo.anU());
                ab.d("MicroMsg.ContactStorage", "delete " + aoH(str) + " user :" + str + ", res:" + this.bSd.update(aoH(str), adVar2.Hl(), "username=?", new String[]{String.valueOf(str)}));
                if (Hl.size() > 0) {
                    i = this.bSd.update(aoH(adVar.field_username), Hl, "rowid=?", new String[]{adVar.ewQ});
                }
            } else if (Hl.size() > 0) {
                ab.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", adVar.field_username, Integer.valueOf(this.bSd.update(aoH(adVar.field_username), Hl, "rowid=?", new String[]{adVar.ewQ})), Long.valueOf(adVar.ewQ));
                i = r1;
            }
            MQ(adVar.field_username);
            if (!bo.isNullOrNil(adVar.field_encryptUsername)) {
                MQ(adVar.field_encryptUsername);
            }
            b(3, this, str);
            b(3, this, adVar.field_username);
            AppMethodBeat.o(1140);
            return i;
        }
        AppMethodBeat.o(1140);
        return 1;
    }

    public final void d(String str, ad adVar) {
        AppMethodBeat.i(1141);
        if (str == null) {
            AppMethodBeat.o(1141);
            return;
        }
        if (ad.mR(str)) {
            str = ad.aoC(str);
        }
        adVar.hu(adVar.Ny());
        if (t.e(adVar)) {
            adVar.hu(43);
            adVar.iC(g.vp(adVar.Oi()));
            adVar.iD(g.vo(adVar.Oi()));
            adVar.iF(g.vo(adVar.Oj()));
            adVar.iG(adVar.Oj());
            AppMethodBeat.o(1141);
            return;
        }
        if (t.ny(adVar.field_username)) {
            ab.i("MicroMsg.ContactStorage", "update official account helper showhead %d", Integer.valueOf(31));
            adVar.hu(31);
        }
        this.fuL.cF(adVar);
        this.fuL.doNotify();
        ab.d("MicroMsg.ContactStorage", "username=%s, showHead=%d, verifyFlag=%d", adVar.field_username, Integer.valueOf(adVar.field_showHead), Integer.valueOf(adVar.field_verifyFlag));
        ContentValues Hl = adVar.Hl();
        if (((int) adVar.ewQ) > 0) {
            Hl.put("rowid", Integer.valueOf((int) adVar.ewQ));
        }
        if (Hl.size() > 0) {
            this.bSd.update(aoH(str), Hl, "username=?", new String[]{String.valueOf(str)});
        }
        AppMethodBeat.o(1141);
    }

    public final Cursor ew(List<String> list) {
        boolean z;
        int i = 0;
        AppMethodBeat.i(1142);
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select * ,rowid from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        Cursor rawQuery = this.bSd.rawQuery(str + dsx(), null);
        AppMethodBeat.o(1142);
        return rawQuery;
    }

    public final Cursor ex(List<String> list) {
        boolean z;
        int i = 0;
        AppMethodBeat.i(1143);
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select * ,rowid from rcontact  where (";
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i2)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i2)) + "'";
            }
        }
        str = str + ") order by case username ";
        while (i < list.size()) {
            str = str + " when '" + ((String) list.get(i)) + "' then " + i;
            i++;
        }
        str = str + " end";
        ab.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:".concat(String.valueOf(str)));
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.o(1143);
        return rawQuery;
    }

    public final List<String> dsr() {
        AppMethodBeat.i(1144);
        Cursor a = this.bSd.a("select username from rcontact where " + dsB(), null, 2);
        ArrayList arrayList = new ArrayList();
        if (a == null) {
            AppMethodBeat.o(1144);
        } else {
            if (a.moveToFirst()) {
                do {
                    arrayList.add(a.getString(0));
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(1144);
        }
        return arrayList;
    }

    public final Cursor dss() {
        AppMethodBeat.i(1145);
        Cursor rawQuery = this.bSd.rawQuery("select * ,rowid from rcontact  where " + ("type & " + com.tencent.mm.n.a.NT() + "=0 and username like '%@chatroom'"), null);
        AppMethodBeat.o(1145);
        return rawQuery;
    }

    public final Cursor dst() {
        AppMethodBeat.i(1146);
        String str = "select * ,rowid from rcontact " + dsA() + " AND type & 256 !=0 " + dsx();
        ab.v("MicroMsg.ContactStorage", str);
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.o(1146);
        return rawQuery;
    }

    public final Cursor dsu() {
        AppMethodBeat.i(1147);
        String str = "select * ,rowid from rcontact  where " + xXo + " and verifyFlag & " + ad.dsh() + " !=0 ";
        ab.v("MicroMsg.ContactStorage", "dkbf:".concat(String.valueOf(str)));
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.o(1147);
        return rawQuery;
    }

    public final Cursor dsv() {
        AppMethodBeat.i(1148);
        String str = "select * ,rowid from rcontact " + dsA() + " AND " + xXo + " AND " + xXn + dsy();
        ab.v("MicroMsg.ContactStorage", str);
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.o(1148);
        return rawQuery;
    }

    private static String ey(List<String> list) {
        AppMethodBeat.i(1149);
        String str;
        if (list == null || list.size() == 0) {
            str = "";
            AppMethodBeat.o(1149);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : list) {
            stringBuilder.append(" or username = '").append(str2).append("'");
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.o(1149);
        return str2;
    }

    public final Cursor b(String str, String str2, List<String> list) {
        AppMethodBeat.i(1150);
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list) + ey(null) + dsx();
        ab.v("MicroMsg.ContactStorage", str3);
        Cursor rawQuery = this.bSd.rawQuery(str3, null);
        AppMethodBeat.o(1150);
        return rawQuery;
    }

    private static String ez(List<String> list) {
        AppMethodBeat.i(1151);
        String ey = ey(list);
        int indexOf = ey.indexOf("or");
        if (indexOf <= 2) {
            ey = ey.substring(indexOf + 2);
        }
        AppMethodBeat.o(1151);
        return ey;
    }

    public final Cursor k(List<String> list, boolean z) {
        AppMethodBeat.i(1152);
        Object obj = "select * ,rowid from rcontact  where " + ez(list);
        if (z) {
            obj = obj + " " + dsx();
        }
        ab.d("MicroMsg.ContactStorage", "sql ".concat(String.valueOf(obj)));
        Cursor rawQuery = this.bSd.rawQuery(obj, null);
        AppMethodBeat.o(1152);
        return rawQuery;
    }

    public final Cursor eA(List<String> list) {
        AppMethodBeat.i(1153);
        Cursor rawQuery = this.bSd.rawQuery("select * ,rowid from rcontact where (" + xXo + ") and (" + ez(list) + ")" + dsy(), null);
        AppMethodBeat.o(1153);
        return rawQuery;
    }

    public final Cursor eB(List<String> list) {
        AppMethodBeat.i(1154);
        Cursor rawQuery = this.bSd.rawQuery("select * ,rowid from rcontact where (" + xXo + ") and (" + ez(list) + ")" + dsy() + " and (username like  '%@openim' )", null);
        AppMethodBeat.o(1154);
        return rawQuery;
    }

    public final Cursor eC(List<String> list) {
        AppMethodBeat.i(1155);
        String str = "select * ,rowid from rcontact " + l(list, false) + dsy();
        ab.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str)));
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.o(1155);
        return rawQuery;
    }

    public final Cursor eD(List<String> list) {
        AppMethodBeat.i(1156);
        String str = "select * ,rowid from rcontact " + eH(list) + dsy();
        ab.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str)));
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.o(1156);
        return rawQuery;
    }

    public final Cursor c(String str, String str2, List<String> list) {
        AppMethodBeat.i(1157);
        Cursor b = b(str, str2, (List) list);
        AppMethodBeat.o(1157);
        return b;
    }

    public final Cursor d(String str, String str2, List<String> list) {
        AppMethodBeat.i(1158);
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list) + dsx();
        ab.v("MicroMsg.ContactStorage", str3);
        Cursor rawQuery = this.bSd.rawQuery(str3, null);
        AppMethodBeat.o(1158);
        return rawQuery;
    }

    public final int dsw() {
        int i = 0;
        AppMethodBeat.i(1159);
        String str = "select count(rowid) from rcontact " + e("@biz.contact", null, null);
        ab.v("MicroMsg.ContactStorage", str);
        Cursor a = this.bSd.a(str, null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(1159);
        return i;
    }

    public final List<String> eE(List<String> list) {
        AppMethodBeat.i(1160);
        if (list.isEmpty()) {
            ab.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(1160);
            return linkedList;
        }
        long yz = bo.yz();
        LinkedList linkedList2 = new LinkedList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("username='").append((String) list.get(0)).append("'");
        for (int i = 1; i < list.size(); i++) {
            stringBuilder.append(" or username='").append((String) list.get(i)).append("'");
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("showHead asc, ");
        stringBuilder2.append("pyInitial asc, ");
        stringBuilder2.append("quanPin asc, ");
        stringBuilder2.append("nickname asc, ");
        stringBuilder2.append("username asc ");
        ab.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[]{"username", "rcontact", stringBuilder.toString(), "type", Integer.valueOf(com.tencent.mm.n.a.NS()), stringBuilder2.toString()}));
        Cursor a = this.bSd.a(r0, null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                linkedList2.add(a.getString(0));
            }
            a.close();
        }
        ab.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", Long.valueOf(bo.az(yz)), list, linkedList2.toString());
        AppMethodBeat.o(1160);
        return linkedList2;
    }

    public final int[] b(String str, String str2, String[] strArr, List<String> list) {
        AppMethodBeat.i(1161);
        String str3 = "select distinct showHead from rcontact " + e(str, str2, list) + S(strArr) + dsx();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.bSd.rawQuery(str3, null);
        ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(1161);
        return iArr;
    }

    public final int[] b(String str, String str2, String str3, List<String> list) {
        AppMethodBeat.i(1162);
        String str4 = "select distinct showHead from rcontact " + e(str, str2, list) + aoV(str3) + dsx();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.bSd.rawQuery(str4, null);
        ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(1162);
        return iArr;
    }

    public final int[] eF(List<String> list) {
        AppMethodBeat.i(1163);
        String str = "select distinct showHead from rcontact  where (" + ez(list) + ") " + dsx();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(1163);
        return iArr;
    }

    public final int[] c(String str, String str2, String str3, List<String> list) {
        int[] iArr = null;
        AppMethodBeat.i(1164);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.bSd.rawQuery(("select count(*) from rcontact " + e(str, str2, list) + aoV(str3)) + " group by showHead", null);
        ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount();
        ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(1164);
        return iArr;
    }

    public final int[] eG(List<String> list) {
        int[] iArr = null;
        AppMethodBeat.i(1165);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = this.bSd.a(("select count(*) from rcontact " + "where " + ez(list)) + " group by showHead", null, 2);
        ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = a.getCount();
        ab.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                a.moveToPosition(i);
                iArr[i] = a.getInt(0);
            }
        }
        a.close();
        AppMethodBeat.o(1165);
        return iArr;
    }

    public final int[] c(String str, String str2, String[] strArr, List<String> list) {
        int[] iArr = null;
        AppMethodBeat.i(1166);
        Cursor rawQuery = this.bSd.rawQuery(("select count(*) from rcontact " + e(str, str2, list) + S(strArr)) + " group by showHead", null);
        if (rawQuery.getCount() > 0) {
            int count = rawQuery.getCount();
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(1166);
        return iArr;
    }

    public final Cursor a(String[] strArr, String str, List<String> list) {
        AppMethodBeat.i(1167);
        Object obj = "select * ,rowid from rcontact " + e(str, null, list) + S(strArr);
        if (strArr != null && strArr.length > 0) {
            obj = obj + " order by 1=1 ";
            for (String str2 : strArr) {
                obj = obj + ",username='" + str2 + "' desc";
            }
        }
        ab.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : ".concat(String.valueOf(obj)));
        Cursor rawQuery = this.bSd.rawQuery(obj, null);
        AppMethodBeat.o(1167);
        return rawQuery;
    }

    public final Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2) {
        AppMethodBeat.i(1168);
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list2) + S(strArr) + y(str2, list) + dsx();
        ab.i("MicroMsg.ContactStorage", str3);
        Cursor rawQuery = this.bSd.rawQuery(str3, null);
        AppMethodBeat.o(1168);
        return rawQuery;
    }

    private static String y(String str, List<String> list) {
        AppMethodBeat.i(1169);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.o(1169);
            return str2;
        }
        str2 = " and (";
        if (!(list == null || list.size() == 0)) {
            String str3;
            Iterator it = list.iterator();
            while (true) {
                str3 = str2;
                if (!it.hasNext()) {
                    break;
                }
                str2 = str3 + "username = '" + ((String) it.next()) + "' or ";
            }
            str2 = str3;
        }
        str2 = (((((((str2 + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
        AppMethodBeat.o(1169);
        return str2;
    }

    private static String S(String[] strArr) {
        AppMethodBeat.i(1170);
        String str;
        if (strArr == null || strArr.length == 0) {
            str = "";
            AppMethodBeat.o(1170);
            return str;
        }
        str = " and (";
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                str = str + " or ";
            }
            str = str + "username = '" + strArr[i] + "' ";
        }
        str = str + " )";
        AppMethodBeat.o(1170);
        return str;
    }

    public final String aoV(String str) {
        AppMethodBeat.i(1171);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.o(1171);
            return str2;
        }
        str2 = (((((((" and (" + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
        AppMethodBeat.o(1171);
        return str2;
    }

    private static String dsx() {
        AppMethodBeat.i(1172);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(1172);
        return stringBuffer2;
    }

    public final String aet() {
        AppMethodBeat.i(139143);
        String dsx = dsx();
        AppMethodBeat.o(139143);
        return dsx;
    }

    private static String dsy() {
        AppMethodBeat.i(1174);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by case when verifyFlag & " + ad.dsh() + " != 0 then 0 else 1 end , showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(1174);
        return stringBuffer2;
    }

    private static String ae(boolean z, boolean z2) {
        AppMethodBeat.i(1175);
        String str = "type & " + com.tencent.mm.n.a.NS() + "!=0";
        if (z) {
            str = str + " or type & " + com.tencent.mm.n.a.NV() + "!=0";
        }
        str = ((" where (" + str + ")") + " and type & " + com.tencent.mm.n.a.NW() + "=0 ") + " and type & " + com.tencent.mm.n.a.NT() + " =0 ";
        if (!z2) {
            str = str + " and verifyFlag & " + ad.dsh() + " =0 ";
        }
        AppMethodBeat.o(1175);
        return str;
    }

    private static String dsz() {
        AppMethodBeat.i(1176);
        String str = ((" where (" + ("type & " + com.tencent.mm.n.a.NS() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.n.a.NW() + " =0 and ") + "type & " + com.tencent.mm.n.a.NT() + " =0";
        AppMethodBeat.o(1176);
        return str;
    }

    private static String dsA() {
        AppMethodBeat.i(1177);
        String str = (" where (" + ("type & " + com.tencent.mm.n.a.NS() + "!=0") + ") and ") + "type & " + com.tencent.mm.n.a.NW() + "=0  ";
        AppMethodBeat.o(1177);
        return str;
    }

    private static String dsB() {
        AppMethodBeat.i(1178);
        String str = "( (" + ("type & " + com.tencent.mm.n.a.NS() + "!=0") + ") and type & " + com.tencent.mm.n.a.NT() + "=0 and (username like '%@chatroom') or (username like '%@im.chatroom'))";
        AppMethodBeat.o(1178);
        return str;
    }

    private static String dsC() {
        AppMethodBeat.i(1179);
        String str = "( (" + ("type & " + com.tencent.mm.n.a.NS() + "!=0") + ") and type & " + com.tencent.mm.n.a.NT() + "=0 and username like '%@talkroom')";
        AppMethodBeat.o(1179);
        return str;
    }

    private static String dsD() {
        AppMethodBeat.i(1180);
        String str = "type & " + com.tencent.mm.n.a.NT() + "=0 and username like '%@openim'";
        AppMethodBeat.o(1180);
        return str;
    }

    private static String dsE() {
        AppMethodBeat.i(1181);
        String str = dsA() + " and " + dsD();
        AppMethodBeat.o(1181);
        return str;
    }

    private static String l(List<String> list, boolean z) {
        AppMethodBeat.i(1182);
        String str = ae(false, z) + " AND " + xXo;
        String str2 = "";
        if (list != null && list.size() > 0) {
            String str3;
            Iterator it = list.iterator();
            while (true) {
                str3 = str2;
                if (!it.hasNext()) {
                    break;
                }
                str2 = str3 + " AND username != '" + ((String) it.next()) + "'";
            }
            str2 = str3;
        }
        str2 = str + str2;
        AppMethodBeat.o(1182);
        return str2;
    }

    private static String eH(List<String> list) {
        AppMethodBeat.i(1183);
        String str = (ae(false, false) + " AND " + xXo) + " and ( username not like '%@openim')";
        String str2 = "";
        if (list != null && list.size() > 0) {
            String str3;
            Iterator it = list.iterator();
            while (true) {
                str3 = str2;
                if (!it.hasNext()) {
                    break;
                }
                str2 = str3 + " AND username != '" + ((String) it.next()) + "'";
            }
            str2 = str3;
        }
        str2 = str + str2;
        AppMethodBeat.o(1183);
        return str2;
    }

    public final String e(String str, String str2, List<String> list) {
        String str3;
        String str4;
        boolean z = true;
        AppMethodBeat.i(1184);
        String str5 = "";
        StringBuilder append;
        String ae;
        if (str == null || str.equals("@all.android")) {
            str3 = str5 + ae(true, false);
        } else if (str.equals("@all.contact.android")) {
            str3 = str5 + dsA();
        } else if (str.equals("@all.chatroom.contact")) {
            str3 = str5 + ((" where (" + ("(type & " + com.tencent.mm.n.a.NS() + "!=0 and (username like '%@chatroom' or username like '%@im.chatroom'))") + ") and ") + "type & " + com.tencent.mm.n.a.NW() + "=0 ");
        } else if (str.equals("@all.contact.without.chatroom")) {
            append = new StringBuilder().append(str5);
            ae = ae(false, false);
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and ( username not like '%@%'" + (" or (" + dsC() + ')' + " or (" + dsD() + ")") + ")").toString();
        } else if (str.equals("@all.contact.without.chatroom.without.openim") || str.equals("@all.contact.without.chatroom.without.openim.without.openimfavour")) {
            append = new StringBuilder().append(str5);
            ae = ae(false, false);
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and ( username not like '%@%'" + (" or (" + dsC() + ')') + ")").toString();
        } else if (str.equals("@black.android")) {
            str3 = str5 + (" where type & " + com.tencent.mm.n.a.NT() + "!=0");
        } else if (str.equals("@werun.black.android")) {
            str3 = str5 + (" where type & " + com.tencent.mm.n.a.NU() + "!=0");
        } else if (str.equals("@t.qq.com")) {
            str3 = str5 + (" where username like '%" + "@t.qq.com" + "'");
        } else if (str.equals("@domain.android")) {
            append = new StringBuilder().append(str5);
            ae = ae(true, false);
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and domainList like '%" + str2 + "%'").toString();
        } else if (str.equals("@micromsg.qq.com")) {
            append = new StringBuilder().append(str5);
            ae = ae(false, false);
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str4 = " or (" + dsB() + ')';
            str3 = append.append(ae + " and ( username not like '%@%'" + str4 + (" or (" + dsC() + ')') + ")").toString();
        } else if (str.equals("@micromsg.no.verify.biz.qq.com")) {
            append = new StringBuilder().append(str5);
            ae = (((" where (" + ("type & " + com.tencent.mm.n.a.NS() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.n.a.NW() + " =0 and ") + "type & " + com.tencent.mm.n.a.NT() + " =0 and ") + "verifyFlag & " + ad.dsh() + " =0";
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and ( username not like '%@%'" + (" or (" + dsB() + ')') + ")").toString();
        } else if (str.equals("@micromsg.with.all.biz.qq.com")) {
            append = new StringBuilder().append(str5);
            ae = dsz();
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and ( username not like '%@%'" + (" or (" + dsB() + ')') + ")").toString();
        } else if (str.equals("@micromsg.with.all.biz.qq.com.openim")) {
            append = new StringBuilder().append(str5);
            ae = dsz();
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and ( username not like '%@%'" + (" or (" + dsB() + ')') + " or (username like '%@openim'))").toString();
        } else if (str.equals("@qqim")) {
            append = new StringBuilder().append(str5);
            ae = "@qqim";
            String ae2 = ae(false, false);
            if (ae2 == null || ae2.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae2 + " and username like '%" + ae + "'").toString();
        } else if (str.equals("@all.chatroom")) {
            str3 = str5 + (" where (" + (((("type & " + com.tencent.mm.n.a.NS() + " !=0") + " or type & 2 !=0") + " or type & 4 !=0") + " or 1") + ") ");
        } else if (str.equals("@verify.contact")) {
            str3 = str5 + (" where (" + (("type & " + com.tencent.mm.n.a.NS() + " != 0 and ") + "verifyFlag & " + ad.dsg() + " != 0") + ") ");
        } else if (str.equals("@biz.contact")) {
            str3 = str5 + (" where (" + (("type & " + com.tencent.mm.n.a.NS() + " != 0 and ") + "verifyFlag & " + ad.dsh() + " != 0") + ") ");
        } else if (str.equals("@all.weixin.android")) {
            str3 = str5 + (" where (" + ("type & " + com.tencent.mm.n.a.NS() + " != 0 or  (username not like '%@qqim' and username not like '%@qr' and username not like '%@bottle' and username not like '%@fb' and username not like '%@google' and username not like '%@t.qq.com' and username not like '%@t.sina.com' and username not like '%@t.sina.com" + "')") + ") ");
        } else if (str.equals("@openim.contact")) {
            str3 = str5 + dsE();
        } else {
            ab.d("MicroMsg.ContactStorage", "unknow role type");
            str3 = str5 + ae(false, false);
        }
        str4 = "";
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (true) {
                str5 = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = str5 + " and username != '" + ((String) it.next()) + "'";
            }
            str4 = str5;
        }
        str4 = str3 + str4;
        AppMethodBeat.o(1184);
        return str4;
    }

    public final int b(String[] strArr, String... strArr2) {
        int i;
        AppMethodBeat.i(1185);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NS()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NW()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NT()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8 = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        if (strArr != null && strArr.length > 0) {
            for (String append : strArr) {
                stringBuilder.append(" and rcontact.username != '").append(append).append("'");
            }
        }
        for (i = 0; i < 4; i++) {
            stringBuilder.append(" and rcontact.username != '").append(strArr2[i]).append("'");
        }
        stringBuilder.append(" or username = 'weixin'");
        Cursor a = this.bSd.a(stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
            a.close();
        }
        ab.d("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d", r2, Integer.valueOf(i));
        AppMethodBeat.o(1185);
        return i;
    }

    public final int c(String[] strArr, String... strArr2) {
        int i;
        AppMethodBeat.i(1186);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NS()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NW()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NT()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8 = 0 and ");
        stringBuilder.append("(( username like '%@chatroom') or ");
        stringBuilder.append("( username like '%@im.chatroom'))");
        if (strArr != null && strArr.length > 0) {
            for (String append : strArr) {
                stringBuilder.append(" and rcontact.username != '").append(append).append("'");
            }
        }
        for (i = 0; i < 4; i++) {
            stringBuilder.append(" and rcontact.username != '").append(strArr2[i]).append("'");
        }
        Cursor a = this.bSd.a(stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
            a.close();
        }
        ab.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", r2, Integer.valueOf(i));
        AppMethodBeat.o(1186);
        return i;
    }

    public final Cursor dsF() {
        AppMethodBeat.i(1187);
        Cursor rawQuery = this.bSd.rawQuery("select * ,rowid from rcontact  where rowid = -1", null);
        AppMethodBeat.o(1187);
        return rawQuery;
    }

    public final boolean apK() {
        AppMethodBeat.i(1188);
        if (this.bSd == null || this.bSd.dpU()) {
            String str = "MicroMsg.ContactStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.bSd == null ? BuildConfig.COMMAND : Boolean.valueOf(this.bSd.dpU());
            ab.w(str, str2, objArr);
            AppMethodBeat.o(1188);
            return false;
        }
        AppMethodBeat.o(1188);
        return true;
    }

    private static boolean ab(ad adVar) {
        boolean z = false;
        AppMethodBeat.i(1189);
        if (adVar == null) {
            AppMethodBeat.o(1189);
        } else {
            int i = adVar.versionCode;
            if (i > 0) {
                z = true;
            }
            ab.d("MicroMsg.ContactStorage", "it need to update contact: " + z + " version code : " + i + " user: " + adVar.field_username);
            AppMethodBeat.o(1189);
        }
        return z;
    }

    public final Cursor dsG() {
        AppMethodBeat.i(1190);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NS()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NW()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NT()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8 = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        stringBuilder.append(" or username = 'weixin'");
        Cursor a = this.bSd.a(stringBuilder.toString(), null, 2);
        ab.i("MicroMsg.ContactStorage", "[oneliang]getNormalContactCursor, sql:%s", r0);
        AppMethodBeat.o(1190);
        return a;
    }

    public final Cursor dsH() {
        AppMethodBeat.i(1191);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NS()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NW()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.n.a.NT()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8 = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        stringBuilder.append(" or username = 'weixin'");
        Cursor a = this.bSd.a(stringBuilder.toString(), null, 2);
        AppMethodBeat.o(1191);
        return a;
    }

    public final boolean X(ad adVar) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_LEFT);
        if (aoQ(adVar.field_username)) {
            if (b(adVar.field_username, adVar) == 0) {
                AppMethodBeat.o(FaceManager.FACE_ACQUIRED_LEFT);
                return true;
            }
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_LEFT);
            return false;
        } else if (aa(adVar) >= 0) {
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_LEFT);
            return true;
        } else {
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_LEFT);
            return false;
        }
    }

    public final int aa(ad adVar) {
        AppMethodBeat.i(1134);
        if (bo.nullAsNil(adVar.field_username).length() <= 0) {
            ab.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
            AppMethodBeat.o(1134);
            return -1;
        }
        int i;
        adVar.hu(adVar.Ny());
        this.fuL.cF(adVar);
        this.fuL.doNotify();
        int insert = (int) this.bSd.insert(aoH(adVar.field_username), com.tencent.mm.n.a.ccO.xDc, adVar.Hl());
        int gb = (int) bo.gb(System.currentTimeMillis());
        boolean z = b.foreground;
        com.tencent.mm.plugin.report.e eVar = com.tencent.mm.plugin.report.e.pXa;
        int i2 = z ? 11 : 14;
        if (z) {
            i = 12;
        } else {
            i = 15;
        }
        eVar.d(463, i2, i, gb, false);
        ab.i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", adVar.field_username, Integer.valueOf(adVar.field_showHead), Integer.valueOf(adVar.field_verifyFlag), Integer.valueOf(insert), Integer.valueOf(gb), Boolean.valueOf(z));
        if (insert != -1) {
            adVar.ewQ = (long) insert;
            W(adVar);
            b(2, this, adVar.field_username);
            AppMethodBeat.o(1134);
            return insert;
        }
        ab.e("MicroMsg.ContactStorage", "insert failed: username=" + adVar.field_username);
        AppMethodBeat.o(1134);
        return -1;
    }
}
