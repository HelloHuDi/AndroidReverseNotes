package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p213cd.C6394d;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.p214a.C37629e;
import com.tencent.p177mm.p213cd.p214a.C7595f;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd.C5131a;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.storage.aj */
public final class C40624aj extends C7298n implements C7309bd {
    public static final String[] diI = new String[]{"CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) "};
    public static final String[] fnj = new String[]{C7563j.m13217a(C7616ad.ccO, "rcontact"), C7563j.m13217a(C7616ad.ccO, "bottlecontact"), C7563j.m13217a(C15431ae.ccO, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );"};
    private static String xXn = "showHead = 32";
    private static String xXo = "type & 64 !=0 ";
    private C4927e bSd;
    private final C4934l<C5131a, C7616ad> fuL = new C406251();
    private C4927e xXk;
    public final C1177f<String, C7616ad> xXl = new C7598c(200);
    public final C1177f<String, Integer> xXm = new C7598c(400);

    /* renamed from: com.tencent.mm.storage.aj$1 */
    class C406251 extends C4934l<C5131a, C7616ad> {
        C406251() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(1103);
            ((C5131a) obj).mo10530a(C40624aj.this, (C7616ad) obj2);
            AppMethodBeat.m2505o(1103);
        }
    }

    private static String aoG(String str) {
        AppMethodBeat.m2504i(1104);
        String str2 = "select *,rowid from " + C40624aj.aoH(str) + " ";
        AppMethodBeat.m2505o(1104);
        return str2;
    }

    private static String aoH(String str) {
        AppMethodBeat.m2504i(1105);
        String str2;
        if (C7616ad.m13548mR(str)) {
            str2 = "bottlecontact";
            AppMethodBeat.m2505o(1105);
            return str2;
        }
        str2 = "rcontact";
        AppMethodBeat.m2505o(1105);
        return str2;
    }

    static {
        AppMethodBeat.m2504i(1192);
        AppMethodBeat.m2505o(1192);
    }

    public C40624aj(C7480h c7480h) {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.m2504i(1106);
        Cursor a = c7480h.mo10104a("PRAGMA table_info( contact_ext )", null, 2);
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
            c7480h.mo10108hY("contact_ext", "Alter table contact_ext add weiboFlag INT DEFAULT 0 ");
        }
        if (i3 == 0) {
            c7480h.mo10108hY("contact_ext", "Alter table contact_ext add weiboNickname INT DEFAULT 0 ");
        }
        Cursor a2 = c7480h.mo10104a("PRAGMA table_info( rcontact )", null, 2);
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
            c7480h.mo10108hY("rcontact", "Alter table rcontact add verifyFlag INT DEFAULT 0 ");
        }
        for (String hY : C7563j.m13219a(C7486a.ccO, "bottlecontact", (C4927e) c7480h)) {
            c7480h.mo10108hY("bottlecontact", hY);
        }
        for (String hY2 : C7563j.m13219a(C7486a.ccO, "rcontact", (C4927e) c7480h)) {
            c7480h.mo10108hY("rcontact", hY2);
        }
        String[] strArr = diI;
        i = strArr.length;
        while (i2 < i) {
            c7480h.mo10108hY("rcontact", strArr[i2]);
            i2++;
        }
        this.bSd = c7480h;
        this.xXk = c7480h;
        AppMethodBeat.m2505o(1106);
    }

    /* renamed from: a */
    public final void mo15707a(C5131a c5131a) {
        AppMethodBeat.m2504i(1107);
        this.fuL.mo10125a(c5131a, null);
        AppMethodBeat.m2505o(1107);
    }

    /* renamed from: b */
    public final void mo15729b(C5131a c5131a) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_NO_FACE);
        if (this.fuL != null) {
            this.fuL.remove(c5131a);
        }
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_NO_FACE);
    }

    public final C7616ad aoI(String str) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_SHIFTING);
        C7616ad c7616ad = (C7616ad) this.xXl.mo4404ai(str);
        if (c7616ad != null) {
            AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_SHIFTING);
            return c7616ad;
        }
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_SHIFTING);
        return null;
    }

    /* renamed from: W */
    public final void mo15699W(C7616ad c7616ad) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_DARK);
        if (c7616ad == null || c7616ad.field_username == null || c7616ad.field_type == 0) {
            AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_DARK);
            return;
        }
        this.xXl.mo4412k(c7616ad.field_username, c7616ad);
        this.xXm.mo4412k(c7616ad.field_username, Integer.valueOf(c7616ad.field_type));
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_DARK);
    }

    /* renamed from: MQ */
    private void m70102MQ(String str) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_HACKER);
        if (!C5046bo.isNullOrNil(str)) {
            this.xXl.remove(str);
            this.xXm.remove(str);
        }
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_HACKER);
    }

    public final boolean aoJ(String str) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_BRIGHT);
        if (C5046bo.isNullOrNil(str) || (str.contains("@") && !str.endsWith("@stranger"))) {
            AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_BRIGHT);
            return false;
        }
        Integer num = (Integer) this.xXm.get(str);
        boolean jh;
        if (num != null) {
            jh = C7486a.m12942jh(num.intValue());
            AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_BRIGHT);
            return jh;
        }
        C7616ad aoO = aoO(str);
        if (aoO == null || !(aoO.field_username.equals(str) || str.equals(aoO.field_encryptUsername))) {
            this.xXm.mo4412k(str, Integer.valueOf(0));
            AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_BRIGHT);
            return false;
        }
        this.xXm.mo4412k(str, Integer.valueOf(aoO.field_type));
        jh = C7486a.m12942jh(aoO.field_type);
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_BRIGHT);
        return jh;
    }

    public final C7616ad aoK(String str) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_RIGHT);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_RIGHT);
            return null;
        }
        C7616ad c7616ad = new C7616ad();
        Cursor a = this.bSd.mo10104a("select *,rowid from rcontact where alias=" + C7480h.escape(str), null, 2);
        if (a.moveToFirst()) {
            c7616ad.mo8995d(a);
            mo15699W(c7616ad);
        }
        a.close();
        c7616ad.dsk();
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_RIGHT);
        return c7616ad;
    }

    /* renamed from: a */
    public final Cursor mo15703a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_UP);
        String str3 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + mo15750e(str, str2, list) + C40624aj.m70108ey(list2) + C40624aj.dsx();
        C4990ab.m7418v("MicroMsg.ContactStorage", str3);
        Cursor a;
        if (z) {
            C7595f[] c7595fArr = new C7595f[2];
            String str4 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + C40624aj.m70110l(list, z2) + C40624aj.dsy();
            C4990ab.m7418v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str3)));
            a = this.bSd.mo10104a(str4, null, 4);
            Cursor a2 = this.bSd.mo10104a(str3, null, 4);
            if ((a instanceof C7595f) && (a2 instanceof C7595f)) {
                c7595fArr[0] = (C7595f) a;
                c7595fArr[1] = (C7595f) a2;
                C37629e c37629e = new C37629e(c7595fArr);
                AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_UP);
                return c37629e;
            }
            a = C6394d.dvo();
            AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_UP);
            return a;
        }
        a = this.bSd.mo10104a(str3, null, 4);
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_UP);
        return a;
    }

    public final List<String> dsq() {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_DOWN);
        Cursor a = this.bSd.mo10104a(" select acctTypeId from OpenIMAppIdInfo where appid in (" + (" select openImAppid from rcontact" + C40624aj.dsE() + " group by openImAppid ") + ") group by acctTypeId", null, 4);
        LinkedList linkedList = new LinkedList();
        if (a.moveToFirst()) {
            do {
                String string = a.getString(0);
                if (!C5046bo.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            } while (a.moveToNext());
        }
        a.close();
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_DOWN);
        return linkedList;
    }

    /* renamed from: a */
    private static String m70104a(String str, List<String> list, String str2, List<String> list2) {
        Iterator it;
        String str3;
        AppMethodBeat.m2504i(FaceManager.FACE_WITH_EYES_CLOSED);
        String str4 = (str + " and OpenIMWordingInfo.language='" + str2 + "' ") + C40624aj.dsE();
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
        C4990ab.m7419v("MicroMsg.ContactStorage", "getOpenIMCursor:%s", str4 + str5);
        AppMethodBeat.m2505o(FaceManager.FACE_WITH_EYES_CLOSED);
        return str4 + str5;
    }

    /* renamed from: a */
    public final Cursor mo15704a(List<String> list, String str, List<String> list2) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_NO_FOCUS);
        Cursor a = this.bSd.mo10104a(C40624aj.m70104a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", list, str, list2) + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ", null, 4);
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_NO_FOCUS);
        return a;
    }

    /* renamed from: b */
    public final Cursor mo15728b(List<String> list, String str, List<String> list2) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_MOUTH_OCCLUSION);
        C4990ab.m7419v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", (C40624aj.m70104a("select count(*)  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", list, str, list2) + "group by OpenIMWordingInfo.wording ") + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ");
        Cursor a = this.bSd.mo10104a(r0, null, 4);
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_MOUTH_OCCLUSION);
        return a;
    }

    /* renamed from: c */
    public final Cursor mo15735c(List<String> list, String str, List<String> list2) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_NOSE_OCCLUSION);
        C4990ab.m7419v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", (C40624aj.m70104a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", list, str, list2) + "group by OpenIMWordingInfo.wording ") + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ");
        Cursor a = this.bSd.mo10104a(r0, null, 4);
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_NOSE_OCCLUSION);
        return a;
    }

    public final Cursor aoL(String str) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_MULTI_FACE);
        Cursor a = this.bSd.mo10104a(str, null, 4);
        AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_MULTI_FACE);
        return a;
    }

    /* renamed from: eu */
    public final Cursor mo15758eu(List<String> list) {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(1122);
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
        Cursor rawQuery = this.bSd.rawQuery(str + C40624aj.dsx(), null);
        AppMethodBeat.m2505o(1122);
        return rawQuery;
    }

    /* renamed from: ev */
    public final Cursor mo15759ev(List<String> list) {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(1123);
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
        Cursor rawQuery = this.bSd.rawQuery(str + C40624aj.dsx(), null);
        AppMethodBeat.m2505o(1123);
        return rawQuery;
    }

    /* renamed from: b */
    public final Cursor mo15727b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(1124);
        String str3 = "select username from rcontact " + mo15750e(str, str2, list) + C40624aj.m70108ey(list2) + C40624aj.dsx();
        C4990ab.m7418v("MicroMsg.ContactStorage", str3);
        Cursor a;
        if (z) {
            C7595f[] c7595fArr = new C7595f[2];
            String str4 = "select username from rcontact " + C40624aj.m70110l(list, z2) + C40624aj.dsy();
            C4990ab.m7418v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str3)));
            a = this.bSd.mo10104a(str4, null, 4);
            Cursor a2 = this.bSd.mo10104a(str3, null, 4);
            if ((a instanceof C7595f) && (a2 instanceof C7595f)) {
                c7595fArr[0] = (C7595f) a;
                c7595fArr[1] = (C7595f) a2;
                C37629e c37629e = new C37629e(c7595fArr);
                AppMethodBeat.m2505o(1124);
                return c37629e;
            }
            a = C6394d.dvo();
            AppMethodBeat.m2505o(1124);
            return a;
        }
        a = this.bSd.rawQuery(str3, null);
        AppMethodBeat.m2505o(1124);
        return a;
    }

    public final C7616ad aoM(String str) {
        AppMethodBeat.m2504i(1125);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1125);
            return null;
        }
        if (C7616ad.m13548mR(str)) {
            str = C7616ad.aoC(str);
        }
        C7616ad aoI = aoI(str);
        if (aoI != null) {
            aoI.dsk();
            AppMethodBeat.m2505o(1125);
            return aoI;
        }
        aoI = new C7616ad();
        Cursor a = this.bSd.mo10104a(C40624aj.aoG(str) + " where username=" + C7480h.escape(str), null, 2);
        if (a.moveToFirst()) {
            aoI.mo8995d(a);
            mo15699W(aoI);
        }
        a.close();
        aoI.dsk();
        AppMethodBeat.m2505o(1125);
        return aoI;
    }

    public final C7616ad aoN(String str) {
        AppMethodBeat.m2504i(1126);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1126);
            return null;
        }
        if (C7616ad.m13548mR(str)) {
            str = C7616ad.aoC(str);
        }
        C7616ad aoI = aoI(str);
        if (aoI != null) {
            AppMethodBeat.m2505o(1126);
            return aoI;
        }
        aoI = new C7616ad();
        Cursor a = this.bSd.mo10104a(C40624aj.aoG(str) + " where username=" + C7480h.escape(str) + " or encryptUsername=" + C7480h.escape(str), null, 2);
        if (a.moveToFirst()) {
            aoI.mo8995d(a);
            mo15699W(aoI);
        }
        a.close();
        AppMethodBeat.m2505o(1126);
        return aoI;
    }

    public final C7616ad aoO(String str) {
        AppMethodBeat.m2504i(1127);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1127);
            return null;
        }
        if (C7616ad.m13548mR(str)) {
            str = C7616ad.aoC(str);
        }
        C7616ad aoI = aoI(str);
        if (aoI != null) {
            AppMethodBeat.m2505o(1127);
            return aoI;
        }
        aoI = new C7616ad();
        Cursor a = this.bSd.mo10104a(C40624aj.aoG(str) + " where username=" + C7480h.escape(str) + " or encryptUsername=" + C7480h.escape(str), null, 2);
        if (a.moveToFirst()) {
            aoI.mo8995d(a);
            a.close();
            aoI.dsk();
            mo15699W(aoI);
        } else {
            a.close();
        }
        AppMethodBeat.m2505o(1127);
        return aoI;
    }

    /* renamed from: mQ */
    public final C7616ad mo15763mQ(long j) {
        C7616ad c7616ad = null;
        AppMethodBeat.m2504i(1128);
        if (j <= 0) {
            AppMethodBeat.m2505o(1128);
        } else {
            Cursor a = this.bSd.mo10104a("select * ,rowid from rcontact  where rowid=".concat(String.valueOf(j)), null, 2);
            if (a.moveToFirst()) {
                c7616ad = new C7616ad();
                c7616ad.mo8995d(a);
                mo15699W(c7616ad);
            }
            a.close();
            if (c7616ad != null) {
                c7616ad.dsk();
            }
            AppMethodBeat.m2505o(1128);
        }
        return c7616ad;
    }

    public final long aoP(String str) {
        AppMethodBeat.m2504i(1129);
        long j = -1;
        C7616ad aoO = aoO(str);
        if (aoO != null && aoO.ewQ > 0) {
            j = (long) ((int) aoO.ewQ);
        }
        AppMethodBeat.m2505o(1129);
        return j;
    }

    public final boolean aoQ(String str) {
        AppMethodBeat.m2504i(1130);
        C7616ad aoO = aoO(str);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username) || !aoO.field_username.equals(str)) {
            AppMethodBeat.m2505o(1130);
            return false;
        }
        AppMethodBeat.m2505o(1130);
        return true;
    }

    public final boolean aoR(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(1131);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1131);
        } else {
            Cursor a = this.bSd.mo10104a("select count(*) from " + C40624aj.aoH(str) + " where type & " + C7486a.m12936NT() + " !=0 and username=" + C7480h.escape(str), null, 2);
            if (a.moveToFirst() && a.getInt(0) > 0) {
                z = true;
            }
            a.close();
            AppMethodBeat.m2505o(1131);
        }
        return z;
    }

    /* renamed from: Y */
    public final boolean mo15701Y(C7616ad c7616ad) {
        AppMethodBeat.m2504i(1132);
        Assert.assertTrue("contact NULL !", c7616ad != null);
        if (C40624aj.m70105ab(c7616ad)) {
            boolean z;
            c7616ad.mo14696hu(c7616ad.mo16696Ny());
            this.fuL.mo10126cF(c7616ad);
            this.fuL.doNotify();
            C4990ab.m7411d("MicroMsg.ContactStorage", "replace : username=%s, showHead=%d, verifyFlag=%d", c7616ad.field_username, Integer.valueOf(c7616ad.field_showHead), Integer.valueOf(c7616ad.field_verifyFlag));
            ContentValues Hl = c7616ad.mo10098Hl();
            if (((int) c7616ad.ewQ) > 0) {
                Hl.put("rowid", Integer.valueOf((int) c7616ad.ewQ));
            }
            if (this.bSd.replace(C40624aj.aoH(c7616ad.field_username), C7486a.ccO.xDc, Hl) > 0) {
                z = true;
            } else {
                z = false;
            }
            m70102MQ(c7616ad.field_username);
            if (!C5046bo.isNullOrNil(c7616ad.field_encryptUsername)) {
                m70102MQ(c7616ad.field_encryptUsername);
            }
            if (z) {
                mo10120b(4, this, c7616ad.field_username);
                AppMethodBeat.m2505o(1132);
                return true;
            }
            AppMethodBeat.m2505o(1132);
            return false;
        }
        AppMethodBeat.m2505o(1132);
        return true;
    }

    /* renamed from: Z */
    public final boolean mo15702Z(C7616ad c7616ad) {
        AppMethodBeat.m2504i(1133);
        if (mo15708aa(c7616ad) > 0) {
            AppMethodBeat.m2505o(1133);
            return true;
        }
        AppMethodBeat.m2505o(1133);
        return false;
    }

    /* renamed from: F */
    public final int mo15698F(String str, byte[] bArr) {
        int i = -1;
        AppMethodBeat.m2504i(1135);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            AppMethodBeat.m2505o(1135);
            return -1;
        }
        C15431ae c15431ae = new C15431ae();
        c15431ae.field_cmdbuf = bArr;
        c15431ae.field_username = str;
        int replace = (int) this.bSd.replace("ContactCmdBuf", "username", c15431ae.mo10098Hl());
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "setCmdbuf user:%s buf:%d result:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(replace);
        C4990ab.m7411d(str2, str3, objArr);
        AppMethodBeat.m2505o(1135);
        return replace;
    }

    public final byte[] aoS(String str) {
        AppMethodBeat.m2504i(1136);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            AppMethodBeat.m2505o(1136);
            return null;
        }
        int i;
        C15431ae c15431ae = new C15431ae();
        Cursor a = this.bSd.mo10105a("ContactCmdBuf", null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            c15431ae.mo8995d(a);
        }
        a.close();
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "getCmdbuf user:%s buf:%d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (c15431ae.field_cmdbuf == null) {
            i = -1;
        } else {
            i = c15431ae.field_cmdbuf.length;
        }
        objArr[1] = Integer.valueOf(i);
        C4990ab.m7411d(str2, str3, objArr);
        byte[] bArr = c15431ae.field_cmdbuf;
        AppMethodBeat.m2505o(1136);
        return bArr;
    }

    public final int aoT(String str) {
        AppMethodBeat.m2504i(1137);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
            AppMethodBeat.m2505o(1137);
            return -1;
        }
        C4990ab.m7411d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", str, Integer.valueOf(this.bSd.delete("ContactCmdBuf", "username=?", new String[]{String.valueOf(str)})));
        AppMethodBeat.m2505o(1137);
        return this.bSd.delete("ContactCmdBuf", "username=?", new String[]{String.valueOf(str)});
    }

    public final int aoU(String str) {
        AppMethodBeat.m2504i(1138);
        Assert.assertTrue(str.length() > 0);
        if (C7616ad.m13548mR(str)) {
            str = C7616ad.aoC(str);
        }
        m70102MQ(str);
        C7616ad c7616ad = new C7616ad(str);
        c7616ad.setType(0);
        c7616ad.setUsername("fake_" + C5046bo.anU());
        c7616ad.mo14709iH("fake_" + C5046bo.anU());
        c7616ad.setSource(0);
        int update = this.bSd.update(C40624aj.aoH(str), c7616ad.mo10098Hl(), "username=?", new String[]{String.valueOf(str)});
        aoT(str);
        C4990ab.m7421w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", str, Integer.valueOf(update), C5046bo.dpG());
        if (update == 0) {
            AppMethodBeat.m2505o(1138);
        } else {
            mo10120b(5, this, str);
            AppMethodBeat.m2505o(1138);
        }
        return update;
    }

    /* renamed from: b */
    public final int mo15724b(String str, C7616ad c7616ad) {
        AppMethodBeat.m2504i(1139);
        C4990ab.m7416i("MicroMsg.ContactStorage", "begin to update contact : ".concat(String.valueOf(str)));
        if (C40624aj.m70105ab(c7616ad)) {
            int update;
            long currentTimeMillis = System.currentTimeMillis();
            if (C7616ad.m13548mR(str)) {
                str = C7616ad.aoC(str);
            }
            c7616ad.mo14696hu(c7616ad.mo16696Ny());
            this.fuL.mo10126cF(c7616ad);
            this.fuL.doNotify();
            ContentValues Hl = c7616ad.mo10098Hl();
            if (((int) c7616ad.ewQ) > 0) {
                Hl.put("rowid", Integer.valueOf((int) c7616ad.ewQ));
            }
            if (Hl.size() > 0) {
                update = this.bSd.update(C40624aj.aoH(str), Hl, "username=?", new String[]{String.valueOf(str)});
            } else {
                update = 0;
            }
            C4990ab.m7417i("MicroMsg.ContactStorage", "update : username=%s, showHead=%d, verifyFlag=%d, result1=%d, take[%d]ms", c7616ad.field_username, Integer.valueOf(c7616ad.field_showHead), Integer.valueOf(c7616ad.field_verifyFlag), Integer.valueOf(update), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            m70102MQ(str);
            if (!C5046bo.isNullOrNil(c7616ad.field_encryptUsername)) {
                m70102MQ(c7616ad.field_encryptUsername);
            }
            if (update != 0) {
                mo10120b(4, this, str);
            }
            AppMethodBeat.m2505o(1139);
            return update;
        }
        AppMethodBeat.m2505o(1139);
        return 1;
    }

    /* renamed from: c */
    public final int mo15732c(String str, C7616ad c7616ad) {
        int i = 0;
        AppMethodBeat.m2504i(1140);
        if (C5046bo.isNullOrNil(str) || c7616ad == null || C5046bo.isNullOrNil(c7616ad.field_username)) {
            C4990ab.m7412e("MicroMsg.ContactStorage", "update : wrong input!");
            AppMethodBeat.m2505o(1140);
            return 0;
        }
        C4990ab.m7410d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + c7616ad.field_username + " enUsername: " + str);
        if (C40624aj.m70105ab(c7616ad)) {
            if (C7616ad.m13548mR(c7616ad.field_username)) {
                c7616ad.setUsername(C7616ad.aoC(c7616ad.field_username));
            }
            c7616ad.mo14696hu(c7616ad.mo16696Ny());
            this.fuL.mo10126cF(c7616ad);
            this.fuL.doNotify();
            C4990ab.m7411d("MicroMsg.ContactStorage", "update : oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", str, c7616ad.field_username, Integer.valueOf(c7616ad.field_showHead), Integer.valueOf(c7616ad.field_verifyFlag));
            ContentValues Hl = c7616ad.mo10098Hl();
            C7616ad c7616ad2;
            if (c7616ad.ewQ <= 0) {
                c7616ad2 = new C7616ad(str);
                c7616ad2.setType(0);
                c7616ad2.setUsername("fake_" + C5046bo.anU());
                c7616ad2.mo14709iH("fake_" + C5046bo.anU());
                C4990ab.m7410d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + C40624aj.aoH(str) + " user :" + str + ", res:" + this.bSd.update(C40624aj.aoH(str), c7616ad2.mo10098Hl(), "username=?", new String[]{String.valueOf(str)}));
                if (Hl.size() > 0) {
                    i = (int) this.bSd.replace(C40624aj.aoH(c7616ad.field_username), C7486a.ccO.xDc, Hl);
                }
            } else if (!str.equals(c7616ad.field_username)) {
                c7616ad2 = new C7616ad(str);
                c7616ad2.setType(0);
                c7616ad2.setUsername("fake_" + C5046bo.anU());
                c7616ad2.mo14709iH("fake_" + C5046bo.anU());
                C4990ab.m7410d("MicroMsg.ContactStorage", "delete " + C40624aj.aoH(str) + " user :" + str + ", res:" + this.bSd.update(C40624aj.aoH(str), c7616ad2.mo10098Hl(), "username=?", new String[]{String.valueOf(str)}));
                if (Hl.size() > 0) {
                    i = this.bSd.update(C40624aj.aoH(c7616ad.field_username), Hl, "rowid=?", new String[]{c7616ad.ewQ});
                }
            } else if (Hl.size() > 0) {
                C4990ab.m7417i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", c7616ad.field_username, Integer.valueOf(this.bSd.update(C40624aj.aoH(c7616ad.field_username), Hl, "rowid=?", new String[]{c7616ad.ewQ})), Long.valueOf(c7616ad.ewQ));
                i = r1;
            }
            m70102MQ(c7616ad.field_username);
            if (!C5046bo.isNullOrNil(c7616ad.field_encryptUsername)) {
                m70102MQ(c7616ad.field_encryptUsername);
            }
            mo10120b(3, this, str);
            mo10120b(3, this, c7616ad.field_username);
            AppMethodBeat.m2505o(1140);
            return i;
        }
        AppMethodBeat.m2505o(1140);
        return 1;
    }

    /* renamed from: d */
    public final void mo15739d(String str, C7616ad c7616ad) {
        AppMethodBeat.m2504i(1141);
        if (str == null) {
            AppMethodBeat.m2505o(1141);
            return;
        }
        if (C7616ad.m13548mR(str)) {
            str = C7616ad.aoC(str);
        }
        c7616ad.mo14696hu(c7616ad.mo16696Ny());
        if (C1855t.m3889e(c7616ad)) {
            c7616ad.mo14696hu(43);
            c7616ad.mo14704iC(C9790g.m17433vp(c7616ad.mo16706Oi()));
            c7616ad.mo14705iD(C9790g.m17432vo(c7616ad.mo16706Oi()));
            c7616ad.mo14707iF(C9790g.m17432vo(c7616ad.mo16707Oj()));
            c7616ad.mo14708iG(c7616ad.mo16707Oj());
            AppMethodBeat.m2505o(1141);
            return;
        }
        if (C1855t.m3956ny(c7616ad.field_username)) {
            C4990ab.m7417i("MicroMsg.ContactStorage", "update official account helper showhead %d", Integer.valueOf(31));
            c7616ad.mo14696hu(31);
        }
        this.fuL.mo10126cF(c7616ad);
        this.fuL.doNotify();
        C4990ab.m7411d("MicroMsg.ContactStorage", "username=%s, showHead=%d, verifyFlag=%d", c7616ad.field_username, Integer.valueOf(c7616ad.field_showHead), Integer.valueOf(c7616ad.field_verifyFlag));
        ContentValues Hl = c7616ad.mo10098Hl();
        if (((int) c7616ad.ewQ) > 0) {
            Hl.put("rowid", Integer.valueOf((int) c7616ad.ewQ));
        }
        if (Hl.size() > 0) {
            this.bSd.update(C40624aj.aoH(str), Hl, "username=?", new String[]{String.valueOf(str)});
        }
        AppMethodBeat.m2505o(1141);
    }

    /* renamed from: ew */
    public final Cursor mo15760ew(List<String> list) {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(1142);
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
        Cursor rawQuery = this.bSd.rawQuery(str + C40624aj.dsx(), null);
        AppMethodBeat.m2505o(1142);
        return rawQuery;
    }

    /* renamed from: ex */
    public final Cursor mo15761ex(List<String> list) {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(1143);
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
        C4990ab.m7410d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:".concat(String.valueOf(str)));
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.m2505o(1143);
        return rawQuery;
    }

    public final List<String> dsr() {
        AppMethodBeat.m2504i(1144);
        Cursor a = this.bSd.mo10104a("select username from rcontact where " + C40624aj.dsB(), null, 2);
        ArrayList arrayList = new ArrayList();
        if (a == null) {
            AppMethodBeat.m2505o(1144);
        } else {
            if (a.moveToFirst()) {
                do {
                    arrayList.add(a.getString(0));
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(1144);
        }
        return arrayList;
    }

    public final Cursor dss() {
        AppMethodBeat.m2504i(1145);
        Cursor rawQuery = this.bSd.rawQuery("select * ,rowid from rcontact  where " + ("type & " + C7486a.m12936NT() + "=0 and username like '%@chatroom'"), null);
        AppMethodBeat.m2505o(1145);
        return rawQuery;
    }

    public final Cursor dst() {
        AppMethodBeat.m2504i(1146);
        String str = "select * ,rowid from rcontact " + C40624aj.dsA() + " AND type & 256 !=0 " + C40624aj.dsx();
        C4990ab.m7418v("MicroMsg.ContactStorage", str);
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.m2505o(1146);
        return rawQuery;
    }

    public final Cursor dsu() {
        AppMethodBeat.m2504i(1147);
        String str = "select * ,rowid from rcontact  where " + xXo + " and verifyFlag & " + C7616ad.dsh() + " !=0 ";
        C4990ab.m7418v("MicroMsg.ContactStorage", "dkbf:".concat(String.valueOf(str)));
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.m2505o(1147);
        return rawQuery;
    }

    public final Cursor dsv() {
        AppMethodBeat.m2504i(1148);
        String str = "select * ,rowid from rcontact " + C40624aj.dsA() + " AND " + xXo + " AND " + xXn + C40624aj.dsy();
        C4990ab.m7418v("MicroMsg.ContactStorage", str);
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.m2505o(1148);
        return rawQuery;
    }

    /* renamed from: ey */
    private static String m70108ey(List<String> list) {
        AppMethodBeat.m2504i(1149);
        String str;
        if (list == null || list.size() == 0) {
            str = "";
            AppMethodBeat.m2505o(1149);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : list) {
            stringBuilder.append(" or username = '").append(str2).append("'");
        }
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(1149);
        return str2;
    }

    /* renamed from: b */
    public final Cursor mo15726b(String str, String str2, List<String> list) {
        AppMethodBeat.m2504i(1150);
        String str3 = "select * ,rowid from rcontact " + mo15750e(str, str2, list) + C40624aj.m70108ey(null) + C40624aj.dsx();
        C4990ab.m7418v("MicroMsg.ContactStorage", str3);
        Cursor rawQuery = this.bSd.rawQuery(str3, null);
        AppMethodBeat.m2505o(1150);
        return rawQuery;
    }

    /* renamed from: ez */
    private static String m70109ez(List<String> list) {
        AppMethodBeat.m2504i(1151);
        String ey = C40624aj.m70108ey(list);
        int indexOf = ey.indexOf("or");
        if (indexOf <= 2) {
            ey = ey.substring(indexOf + 2);
        }
        AppMethodBeat.m2505o(1151);
        return ey;
    }

    /* renamed from: k */
    public final Cursor mo15762k(List<String> list, boolean z) {
        AppMethodBeat.m2504i(1152);
        Object obj = "select * ,rowid from rcontact  where " + C40624aj.m70109ez(list);
        if (z) {
            obj = obj + " " + C40624aj.dsx();
        }
        C4990ab.m7410d("MicroMsg.ContactStorage", "sql ".concat(String.valueOf(obj)));
        Cursor rawQuery = this.bSd.rawQuery(obj, null);
        AppMethodBeat.m2505o(1152);
        return rawQuery;
    }

    /* renamed from: eA */
    public final Cursor mo15751eA(List<String> list) {
        AppMethodBeat.m2504i(1153);
        Cursor rawQuery = this.bSd.rawQuery("select * ,rowid from rcontact where (" + xXo + ") and (" + C40624aj.m70109ez(list) + ")" + C40624aj.dsy(), null);
        AppMethodBeat.m2505o(1153);
        return rawQuery;
    }

    /* renamed from: eB */
    public final Cursor mo15752eB(List<String> list) {
        AppMethodBeat.m2504i(1154);
        Cursor rawQuery = this.bSd.rawQuery("select * ,rowid from rcontact where (" + xXo + ") and (" + C40624aj.m70109ez(list) + ")" + C40624aj.dsy() + " and (username like  '%@openim' )", null);
        AppMethodBeat.m2505o(1154);
        return rawQuery;
    }

    /* renamed from: eC */
    public final Cursor mo15753eC(List<String> list) {
        AppMethodBeat.m2504i(1155);
        String str = "select * ,rowid from rcontact " + C40624aj.m70110l(list, false) + C40624aj.dsy();
        C4990ab.m7418v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str)));
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.m2505o(1155);
        return rawQuery;
    }

    /* renamed from: eD */
    public final Cursor mo15754eD(List<String> list) {
        AppMethodBeat.m2504i(1156);
        String str = "select * ,rowid from rcontact " + C40624aj.m70107eH(list) + C40624aj.dsy();
        C4990ab.m7418v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str)));
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        AppMethodBeat.m2505o(1156);
        return rawQuery;
    }

    /* renamed from: c */
    public final Cursor mo15734c(String str, String str2, List<String> list) {
        AppMethodBeat.m2504i(1157);
        Cursor b = mo15726b(str, str2, (List) list);
        AppMethodBeat.m2505o(1157);
        return b;
    }

    /* renamed from: d */
    public final Cursor mo15738d(String str, String str2, List<String> list) {
        AppMethodBeat.m2504i(1158);
        String str3 = "select * ,rowid from rcontact " + mo15750e(str, str2, list) + C40624aj.dsx();
        C4990ab.m7418v("MicroMsg.ContactStorage", str3);
        Cursor rawQuery = this.bSd.rawQuery(str3, null);
        AppMethodBeat.m2505o(1158);
        return rawQuery;
    }

    public final int dsw() {
        int i = 0;
        AppMethodBeat.m2504i(1159);
        String str = "select count(rowid) from rcontact " + mo15750e("@biz.contact", null, null);
        C4990ab.m7418v("MicroMsg.ContactStorage", str);
        Cursor a = this.bSd.mo10104a(str, null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(1159);
        return i;
    }

    /* renamed from: eE */
    public final List<String> mo15755eE(List<String> list) {
        AppMethodBeat.m2504i(1160);
        if (list.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.m2505o(1160);
            return linkedList;
        }
        long yz = C5046bo.m7588yz();
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
        C4990ab.m7417i("MicroMsg.ContactStorage", "getFilterList: sql is %s", String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[]{"username", "rcontact", stringBuilder.toString(), "type", Integer.valueOf(C7486a.m12935NS()), stringBuilder2.toString()}));
        Cursor a = this.bSd.mo10104a(r0, null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                linkedList2.add(a.getString(0));
            }
            a.close();
        }
        C4990ab.m7417i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", Long.valueOf(C5046bo.m7525az(yz)), list, linkedList2.toString());
        AppMethodBeat.m2505o(1160);
        return linkedList2;
    }

    /* renamed from: b */
    public final int[] mo15731b(String str, String str2, String[] strArr, List<String> list) {
        AppMethodBeat.m2504i(1161);
        String str3 = "select distinct showHead from rcontact " + mo15750e(str, str2, list) + C40624aj.m70103S(strArr) + C40624aj.dsx();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.bSd.rawQuery(str3, null);
        C4990ab.m7410d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        C4990ab.m7410d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.m2505o(1161);
        return iArr;
    }

    /* renamed from: b */
    public final int[] mo15730b(String str, String str2, String str3, List<String> list) {
        AppMethodBeat.m2504i(1162);
        String str4 = "select distinct showHead from rcontact " + mo15750e(str, str2, list) + aoV(str3) + C40624aj.dsx();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.bSd.rawQuery(str4, null);
        C4990ab.m7410d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        C4990ab.m7410d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.m2505o(1162);
        return iArr;
    }

    /* renamed from: eF */
    public final int[] mo15756eF(List<String> list) {
        AppMethodBeat.m2504i(1163);
        String str = "select distinct showHead from rcontact  where (" + C40624aj.m70109ez(list) + ") " + C40624aj.dsx();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.bSd.rawQuery(str, null);
        C4990ab.m7410d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        C4990ab.m7410d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.m2505o(1163);
        return iArr;
    }

    /* renamed from: c */
    public final int[] mo15736c(String str, String str2, String str3, List<String> list) {
        int[] iArr = null;
        AppMethodBeat.m2504i(1164);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.bSd.rawQuery(("select count(*) from rcontact " + mo15750e(str, str2, list) + aoV(str3)) + " group by showHead", null);
        C4990ab.m7410d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount();
        C4990ab.m7410d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.m2505o(1164);
        return iArr;
    }

    /* renamed from: eG */
    public final int[] mo15757eG(List<String> list) {
        int[] iArr = null;
        AppMethodBeat.m2504i(1165);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = this.bSd.mo10104a(("select count(*) from rcontact " + "where " + C40624aj.m70109ez(list)) + " group by showHead", null, 2);
        C4990ab.m7410d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = a.getCount();
        C4990ab.m7410d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                a.moveToPosition(i);
                iArr[i] = a.getInt(0);
            }
        }
        a.close();
        AppMethodBeat.m2505o(1165);
        return iArr;
    }

    /* renamed from: c */
    public final int[] mo15737c(String str, String str2, String[] strArr, List<String> list) {
        int[] iArr = null;
        AppMethodBeat.m2504i(1166);
        Cursor rawQuery = this.bSd.rawQuery(("select count(*) from rcontact " + mo15750e(str, str2, list) + C40624aj.m70103S(strArr)) + " group by showHead", null);
        if (rawQuery.getCount() > 0) {
            int count = rawQuery.getCount();
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.m2505o(1166);
        return iArr;
    }

    /* renamed from: a */
    public final Cursor mo15706a(String[] strArr, String str, List<String> list) {
        AppMethodBeat.m2504i(1167);
        Object obj = "select * ,rowid from rcontact " + mo15750e(str, null, list) + C40624aj.m70103S(strArr);
        if (strArr != null && strArr.length > 0) {
            obj = obj + " order by 1=1 ";
            for (String str2 : strArr) {
                obj = obj + ",username='" + str2 + "' desc";
            }
        }
        C4990ab.m7418v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : ".concat(String.valueOf(obj)));
        Cursor rawQuery = this.bSd.rawQuery(obj, null);
        AppMethodBeat.m2505o(1167);
        return rawQuery;
    }

    /* renamed from: a */
    public final Cursor mo15705a(String[] strArr, String str, String str2, List<String> list, List<String> list2) {
        AppMethodBeat.m2504i(1168);
        String str3 = "select * ,rowid from rcontact " + mo15750e(str, str2, list2) + C40624aj.m70103S(strArr) + C40624aj.m70111y(str2, list) + C40624aj.dsx();
        C4990ab.m7416i("MicroMsg.ContactStorage", str3);
        Cursor rawQuery = this.bSd.rawQuery(str3, null);
        AppMethodBeat.m2505o(1168);
        return rawQuery;
    }

    /* renamed from: y */
    private static String m70111y(String str, List<String> list) {
        AppMethodBeat.m2504i(1169);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.m2505o(1169);
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
        AppMethodBeat.m2505o(1169);
        return str2;
    }

    /* renamed from: S */
    private static String m70103S(String[] strArr) {
        AppMethodBeat.m2504i(1170);
        String str;
        if (strArr == null || strArr.length == 0) {
            str = "";
            AppMethodBeat.m2505o(1170);
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
        AppMethodBeat.m2505o(1170);
        return str;
    }

    public final String aoV(String str) {
        AppMethodBeat.m2504i(1171);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.m2505o(1171);
            return str2;
        }
        str2 = (((((((" and (" + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
        AppMethodBeat.m2505o(1171);
        return str2;
    }

    private static String dsx() {
        AppMethodBeat.m2504i(1172);
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
        AppMethodBeat.m2505o(1172);
        return stringBuffer2;
    }

    public final String aet() {
        AppMethodBeat.m2504i(139143);
        String dsx = C40624aj.dsx();
        AppMethodBeat.m2505o(139143);
        return dsx;
    }

    private static String dsy() {
        AppMethodBeat.m2504i(1174);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by case when verifyFlag & " + C7616ad.dsh() + " != 0 then 0 else 1 end , showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(1174);
        return stringBuffer2;
    }

    /* renamed from: ae */
    private static String m70106ae(boolean z, boolean z2) {
        AppMethodBeat.m2504i(1175);
        String str = "type & " + C7486a.m12935NS() + "!=0";
        if (z) {
            str = str + " or type & " + C7486a.m12938NV() + "!=0";
        }
        str = ((" where (" + str + ")") + " and type & " + C7486a.m12939NW() + "=0 ") + " and type & " + C7486a.m12936NT() + " =0 ";
        if (!z2) {
            str = str + " and verifyFlag & " + C7616ad.dsh() + " =0 ";
        }
        AppMethodBeat.m2505o(1175);
        return str;
    }

    private static String dsz() {
        AppMethodBeat.m2504i(1176);
        String str = ((" where (" + ("type & " + C7486a.m12935NS() + " !=0 ") + ") and ") + "type & " + C7486a.m12939NW() + " =0 and ") + "type & " + C7486a.m12936NT() + " =0";
        AppMethodBeat.m2505o(1176);
        return str;
    }

    private static String dsA() {
        AppMethodBeat.m2504i(1177);
        String str = (" where (" + ("type & " + C7486a.m12935NS() + "!=0") + ") and ") + "type & " + C7486a.m12939NW() + "=0  ";
        AppMethodBeat.m2505o(1177);
        return str;
    }

    private static String dsB() {
        AppMethodBeat.m2504i(1178);
        String str = "( (" + ("type & " + C7486a.m12935NS() + "!=0") + ") and type & " + C7486a.m12936NT() + "=0 and (username like '%@chatroom') or (username like '%@im.chatroom'))";
        AppMethodBeat.m2505o(1178);
        return str;
    }

    private static String dsC() {
        AppMethodBeat.m2504i(1179);
        String str = "( (" + ("type & " + C7486a.m12935NS() + "!=0") + ") and type & " + C7486a.m12936NT() + "=0 and username like '%@talkroom')";
        AppMethodBeat.m2505o(1179);
        return str;
    }

    private static String dsD() {
        AppMethodBeat.m2504i(1180);
        String str = "type & " + C7486a.m12936NT() + "=0 and username like '%@openim'";
        AppMethodBeat.m2505o(1180);
        return str;
    }

    private static String dsE() {
        AppMethodBeat.m2504i(1181);
        String str = C40624aj.dsA() + " and " + C40624aj.dsD();
        AppMethodBeat.m2505o(1181);
        return str;
    }

    /* renamed from: l */
    private static String m70110l(List<String> list, boolean z) {
        AppMethodBeat.m2504i(1182);
        String str = C40624aj.m70106ae(false, z) + " AND " + xXo;
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
        AppMethodBeat.m2505o(1182);
        return str2;
    }

    /* renamed from: eH */
    private static String m70107eH(List<String> list) {
        AppMethodBeat.m2504i(1183);
        String str = (C40624aj.m70106ae(false, false) + " AND " + xXo) + " and ( username not like '%@openim')";
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
        AppMethodBeat.m2505o(1183);
        return str2;
    }

    /* renamed from: e */
    public final String mo15750e(String str, String str2, List<String> list) {
        String str3;
        String str4;
        boolean z = true;
        AppMethodBeat.m2504i(1184);
        String str5 = "";
        StringBuilder append;
        String ae;
        if (str == null || str.equals("@all.android")) {
            str3 = str5 + C40624aj.m70106ae(true, false);
        } else if (str.equals("@all.contact.android")) {
            str3 = str5 + C40624aj.dsA();
        } else if (str.equals("@all.chatroom.contact")) {
            str3 = str5 + ((" where (" + ("(type & " + C7486a.m12935NS() + "!=0 and (username like '%@chatroom' or username like '%@im.chatroom'))") + ") and ") + "type & " + C7486a.m12939NW() + "=0 ");
        } else if (str.equals("@all.contact.without.chatroom")) {
            append = new StringBuilder().append(str5);
            ae = C40624aj.m70106ae(false, false);
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and ( username not like '%@%'" + (" or (" + C40624aj.dsC() + ')' + " or (" + C40624aj.dsD() + ")") + ")").toString();
        } else if (str.equals("@all.contact.without.chatroom.without.openim") || str.equals("@all.contact.without.chatroom.without.openim.without.openimfavour")) {
            append = new StringBuilder().append(str5);
            ae = C40624aj.m70106ae(false, false);
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and ( username not like '%@%'" + (" or (" + C40624aj.dsC() + ')') + ")").toString();
        } else if (str.equals("@black.android")) {
            str3 = str5 + (" where type & " + C7486a.m12936NT() + "!=0");
        } else if (str.equals("@werun.black.android")) {
            str3 = str5 + (" where type & " + C7486a.m12937NU() + "!=0");
        } else if (str.equals("@t.qq.com")) {
            str3 = str5 + (" where username like '%" + "@t.qq.com" + "'");
        } else if (str.equals("@domain.android")) {
            append = new StringBuilder().append(str5);
            ae = C40624aj.m70106ae(true, false);
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and domainList like '%" + str2 + "%'").toString();
        } else if (str.equals("@micromsg.qq.com")) {
            append = new StringBuilder().append(str5);
            ae = C40624aj.m70106ae(false, false);
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str4 = " or (" + C40624aj.dsB() + ')';
            str3 = append.append(ae + " and ( username not like '%@%'" + str4 + (" or (" + C40624aj.dsC() + ')') + ")").toString();
        } else if (str.equals("@micromsg.no.verify.biz.qq.com")) {
            append = new StringBuilder().append(str5);
            ae = (((" where (" + ("type & " + C7486a.m12935NS() + " !=0 ") + ") and ") + "type & " + C7486a.m12939NW() + " =0 and ") + "type & " + C7486a.m12936NT() + " =0 and ") + "verifyFlag & " + C7616ad.dsh() + " =0";
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and ( username not like '%@%'" + (" or (" + C40624aj.dsB() + ')') + ")").toString();
        } else if (str.equals("@micromsg.with.all.biz.qq.com")) {
            append = new StringBuilder().append(str5);
            ae = C40624aj.dsz();
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and ( username not like '%@%'" + (" or (" + C40624aj.dsB() + ')') + ")").toString();
        } else if (str.equals("@micromsg.with.all.biz.qq.com.openim")) {
            append = new StringBuilder().append(str5);
            ae = C40624aj.dsz();
            if (ae == null || ae.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae + " and ( username not like '%@%'" + (" or (" + C40624aj.dsB() + ')') + " or (username like '%@openim'))").toString();
        } else if (str.equals("@qqim")) {
            append = new StringBuilder().append(str5);
            ae = "@qqim";
            String ae2 = C40624aj.m70106ae(false, false);
            if (ae2 == null || ae2.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(ae2 + " and username like '%" + ae + "'").toString();
        } else if (str.equals("@all.chatroom")) {
            str3 = str5 + (" where (" + (((("type & " + C7486a.m12935NS() + " !=0") + " or type & 2 !=0") + " or type & 4 !=0") + " or 1") + ") ");
        } else if (str.equals("@verify.contact")) {
            str3 = str5 + (" where (" + (("type & " + C7486a.m12935NS() + " != 0 and ") + "verifyFlag & " + C7616ad.dsg() + " != 0") + ") ");
        } else if (str.equals("@biz.contact")) {
            str3 = str5 + (" where (" + (("type & " + C7486a.m12935NS() + " != 0 and ") + "verifyFlag & " + C7616ad.dsh() + " != 0") + ") ");
        } else if (str.equals("@all.weixin.android")) {
            str3 = str5 + (" where (" + ("type & " + C7486a.m12935NS() + " != 0 or  (username not like '%@qqim' and username not like '%@qr' and username not like '%@bottle' and username not like '%@fb' and username not like '%@google' and username not like '%@t.qq.com' and username not like '%@t.sina.com' and username not like '%@t.sina.com" + "')") + ") ");
        } else if (str.equals("@openim.contact")) {
            str3 = str5 + C40624aj.dsE();
        } else {
            C4990ab.m7410d("MicroMsg.ContactStorage", "unknow role type");
            str3 = str5 + C40624aj.m70106ae(false, false);
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
        AppMethodBeat.m2505o(1184);
        return str4;
    }

    /* renamed from: b */
    public final int mo15725b(String[] strArr, String... strArr2) {
        int i;
        AppMethodBeat.m2504i(1185);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(C7486a.m12935NS()).append(" !=0 and ");
        stringBuilder.append("type & ").append(C7486a.m12939NW()).append(" =0 and ");
        stringBuilder.append("type & ").append(C7486a.m12936NT()).append(" =0 and ");
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
        Cursor a = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
            a.close();
        }
        C4990ab.m7411d("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d", r2, Integer.valueOf(i));
        AppMethodBeat.m2505o(1185);
        return i;
    }

    /* renamed from: c */
    public final int mo15733c(String[] strArr, String... strArr2) {
        int i;
        AppMethodBeat.m2504i(1186);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(C7486a.m12935NS()).append(" !=0 and ");
        stringBuilder.append("type & ").append(C7486a.m12939NW()).append(" =0 and ");
        stringBuilder.append("type & ").append(C7486a.m12936NT()).append(" =0 and ");
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
        Cursor a = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
            a.close();
        }
        C4990ab.m7419v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", r2, Integer.valueOf(i));
        AppMethodBeat.m2505o(1186);
        return i;
    }

    public final Cursor dsF() {
        AppMethodBeat.m2504i(1187);
        Cursor rawQuery = this.bSd.rawQuery("select * ,rowid from rcontact  where rowid = -1", null);
        AppMethodBeat.m2505o(1187);
        return rawQuery;
    }

    public final boolean apK() {
        AppMethodBeat.m2504i(1188);
        if (this.bSd == null || this.bSd.dpU()) {
            String str = "MicroMsg.ContactStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.bSd == null ? BuildConfig.COMMAND : Boolean.valueOf(this.bSd.dpU());
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(1188);
            return false;
        }
        AppMethodBeat.m2505o(1188);
        return true;
    }

    /* renamed from: ab */
    private static boolean m70105ab(C7616ad c7616ad) {
        boolean z = false;
        AppMethodBeat.m2504i(1189);
        if (c7616ad == null) {
            AppMethodBeat.m2505o(1189);
        } else {
            int i = c7616ad.versionCode;
            if (i > 0) {
                z = true;
            }
            C4990ab.m7410d("MicroMsg.ContactStorage", "it need to update contact: " + z + " version code : " + i + " user: " + c7616ad.field_username);
            AppMethodBeat.m2505o(1189);
        }
        return z;
    }

    public final Cursor dsG() {
        AppMethodBeat.m2504i(1190);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
        stringBuilder.append("type & ").append(C7486a.m12935NS()).append(" !=0 and ");
        stringBuilder.append("type & ").append(C7486a.m12939NW()).append(" =0 and ");
        stringBuilder.append("type & ").append(C7486a.m12936NT()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8 = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        stringBuilder.append(" or username = 'weixin'");
        Cursor a = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
        C4990ab.m7417i("MicroMsg.ContactStorage", "[oneliang]getNormalContactCursor, sql:%s", r0);
        AppMethodBeat.m2505o(1190);
        return a;
    }

    public final Cursor dsH() {
        AppMethodBeat.m2504i(1191);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
        stringBuilder.append("type & ").append(C7486a.m12935NS()).append(" !=0 and ");
        stringBuilder.append("type & ").append(C7486a.m12939NW()).append(" =0 and ");
        stringBuilder.append("type & ").append(C7486a.m12936NT()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8 = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        stringBuilder.append(" or username = 'weixin'");
        Cursor a = this.bSd.mo10104a(stringBuilder.toString(), null, 2);
        AppMethodBeat.m2505o(1191);
        return a;
    }

    /* renamed from: X */
    public final boolean mo15700X(C7616ad c7616ad) {
        AppMethodBeat.m2504i(FaceManager.FACE_ACQUIRED_LEFT);
        if (aoQ(c7616ad.field_username)) {
            if (mo15724b(c7616ad.field_username, c7616ad) == 0) {
                AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_LEFT);
                return true;
            }
            AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_LEFT);
            return false;
        } else if (mo15708aa(c7616ad) >= 0) {
            AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_LEFT);
            return true;
        } else {
            AppMethodBeat.m2505o(FaceManager.FACE_ACQUIRED_LEFT);
            return false;
        }
    }

    /* renamed from: aa */
    public final int mo15708aa(C7616ad c7616ad) {
        AppMethodBeat.m2504i(1134);
        if (C5046bo.nullAsNil(c7616ad.field_username).length() <= 0) {
            C4990ab.m7412e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
            AppMethodBeat.m2505o(1134);
            return -1;
        }
        int i;
        c7616ad.mo14696hu(c7616ad.mo16696Ny());
        this.fuL.mo10126cF(c7616ad);
        this.fuL.doNotify();
        int insert = (int) this.bSd.insert(C40624aj.aoH(c7616ad.field_username), C7486a.ccO.xDc, c7616ad.mo10098Hl());
        int gb = (int) C5046bo.m7566gb(System.currentTimeMillis());
        boolean z = C4872b.foreground;
        C7053e c7053e = C7053e.pXa;
        int i2 = z ? 11 : 14;
        if (z) {
            i = 12;
        } else {
            i = 15;
        }
        c7053e.mo8380d(463, i2, i, gb, false);
        C4990ab.m7417i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", c7616ad.field_username, Integer.valueOf(c7616ad.field_showHead), Integer.valueOf(c7616ad.field_verifyFlag), Integer.valueOf(insert), Integer.valueOf(gb), Boolean.valueOf(z));
        if (insert != -1) {
            c7616ad.ewQ = (long) insert;
            mo15699W(c7616ad);
            mo10120b(2, this, c7616ad.field_username);
            AppMethodBeat.m2505o(1134);
            return insert;
        }
        C4990ab.m7412e("MicroMsg.ContactStorage", "insert failed: username=" + c7616ad.field_username);
        AppMethodBeat.m2505o(1134);
        return -1;
    }
}
