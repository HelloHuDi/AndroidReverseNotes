package com.tencent.p177mm.plugin.appbrand.game.p292b.p1222a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.game.b.a.c */
public final class C45555c extends C7563j<C19224b> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C19224b.ccO, "WxagGameInfo")};
    private final boolean hrm;

    static {
        AppMethodBeat.m2504i(130120);
        AppMethodBeat.m2505o(130120);
    }

    public C45555c(C4927e c4927e) {
        super(c4927e, C19224b.ccO, "WxagGameInfo", null);
        AppMethodBeat.m2504i(130109);
        this.hrm = c4927e != null;
        if (!this.hrm) {
            C4990ab.m7412e("MicroMsg.MiniGameInfoStorage", "storage can not work!!!");
        }
        AppMethodBeat.m2505o(130109);
    }

    public final List<C19224b> aAH() {
        List<C19224b> list = null;
        AppMethodBeat.m2504i(130110);
        if (this.hrm) {
            Cursor rawQuery = rawQuery(String.format("select * from %s", new Object[]{"WxagGameInfo"}), new String[0]);
            C4990ab.m7417i("MicroMsg.MiniGameInfoStorage", "getMiniGameList queryStr:%s", r1);
            if (rawQuery == null) {
                C4990ab.m7416i("MicroMsg.MiniGameInfoStorage", "cursor is null");
                AppMethodBeat.m2505o(130110);
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    C19224b c19224b = new C19224b();
                    c19224b.mo8995d(rawQuery);
                    list.add(c19224b);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                C4990ab.m7417i("MicroMsg.MiniGameInfoStorage", "record list size:%s", Integer.valueOf(list.size()));
                AppMethodBeat.m2505o(130110);
            } else {
                rawQuery.close();
                C4990ab.m7416i("MicroMsg.MiniGameInfoStorage", "no record");
                AppMethodBeat.m2505o(130110);
            }
        } else {
            AppMethodBeat.m2505o(130110);
        }
        return list;
    }

    /* renamed from: As */
    public final C19224b mo73360As(String str) {
        AppMethodBeat.m2504i(130111);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(130111);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WxagGameInfo", "RecordId"}), str);
        if (rawQuery.moveToFirst()) {
            C19224b c19224b = new C19224b();
            c19224b.mo8995d(rawQuery);
            rawQuery.close();
            AppMethodBeat.m2505o(130111);
            return c19224b;
        }
        C4990ab.m7417i("MicroMsg.MiniGameInfoStorage", "getMiniGame recordId:%s, no record in DB", str);
        rawQuery.close();
        AppMethodBeat.m2505o(130111);
        return null;
    }

    /* renamed from: c */
    public final void mo10116c(C4931a c4931a) {
        AppMethodBeat.m2504i(130112);
        mo10114a(c4931a, C42677e.aNS().oAl.getLooper());
        AppMethodBeat.m2505o(130112);
    }

    /* renamed from: b */
    public final boolean mo73365b(List<C24694a> list, boolean z) {
        AppMethodBeat.m2504i(130113);
        if (!this.hrm || C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(130113);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (C24694a c24694a : list) {
            mo73361a(c24694a, false);
            arrayList.add(c24694a.euD);
        }
        if (z) {
            mo15641b("batch", 2, arrayList);
        }
        C4990ab.m7417i("MicroMsg.MiniGameInfoStorage", "insert miniGame size:%d,   isSync:%b", Integer.valueOf(list.size()), Boolean.FALSE);
        AppMethodBeat.m2505o(130113);
        return true;
    }

    /* renamed from: ae */
    public final boolean mo73364ae(String str, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(130114);
        if (!this.hrm || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(130114);
        } else {
            C4925c c19224b = new C19224b();
            c19224b.field_RecordId = str;
            z2 = super.mo16760a(c19224b, new String[0]);
            if (z2 && z) {
                mo15641b("single", 5, str);
            }
            AppMethodBeat.m2505o(130114);
        }
        return z2;
    }

    /* renamed from: aH */
    public final boolean mo73363aH(List<String> list) {
        AppMethodBeat.m2504i(130115);
        if (!this.hrm || C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(130115);
            return false;
        }
        for (String ae : list) {
            mo73364ae(ae, false);
        }
        mo15641b("batch", 5, list);
        AppMethodBeat.m2505o(130115);
        return true;
    }

    /* renamed from: a */
    public final boolean mo73361a(C24694a c24694a, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(130116);
        if (!this.hrm || c24694a == null) {
            AppMethodBeat.m2505o(130116);
        } else {
            boolean z3;
            C19224b bd = m84015bd(c24694a.fKh, c24694a.gVs);
            if (bd == null || !bd.field_isSync) {
                z3 = true;
            } else {
                z3 = false;
            }
            C4990ab.m7417i("MicroMsg.MiniGameInfoStorage", "needUpdate:%b", Boolean.valueOf(z3));
            if (z3) {
                m84014a(bd);
                C19224b c19224b = new C19224b();
                if (C5046bo.isNullOrNil(c24694a.euD)) {
                    c24694a.euD = C45555c.m84016be(c24694a.jBB, c24694a.gVs);
                }
                c19224b.field_RecordId = c24694a.euD;
                c19224b.field_AppId = c24694a.fKh;
                c19224b.field_AppName = c24694a.ncH;
                c19224b.field_UserName = c24694a.jBB;
                c19224b.field_IconUrl = c24694a.IconUrl;
                c19224b.field_BriefIntro = c24694a.nay;
                c19224b.field_isSync = false;
                c19224b.field_createTime = System.currentTimeMillis();
                z2 = mo10101b((C4925c) c19224b);
                if (z2 && z) {
                    mo15641b("single", 2, c19224b.field_RecordId);
                }
                AppMethodBeat.m2505o(130116);
            } else {
                AppMethodBeat.m2505o(130116);
            }
        }
        return z2;
    }

    /* renamed from: a */
    private boolean m84014a(C19224b c19224b) {
        AppMethodBeat.m2504i(130117);
        if (!this.hrm || c19224b == null) {
            AppMethodBeat.m2505o(130117);
            return false;
        }
        boolean a = super.mo16760a((C4925c) c19224b, new String[0]);
        AppMethodBeat.m2505o(130117);
        return a;
    }

    /* renamed from: bd */
    private C19224b m84015bd(String str, int i) {
        AppMethodBeat.m2504i(130118);
        if (this.hrm) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=?", new Object[]{"WxagGameInfo", "AppId", "debugType"}), str, String.valueOf(i));
            if (rawQuery.moveToFirst()) {
                C19224b c19224b = new C19224b();
                c19224b.mo8995d(rawQuery);
                rawQuery.close();
                AppMethodBeat.m2505o(130118);
                return c19224b;
            }
            rawQuery.close();
            AppMethodBeat.m2505o(130118);
            return null;
        }
        AppMethodBeat.m2505o(130118);
        return null;
    }

    /* renamed from: be */
    private static String m84016be(String str, int i) {
        AppMethodBeat.m2504i(130119);
        String valueOf = String.valueOf(String.format(Locale.US, "%s|%d", new Object[]{str, Integer.valueOf(i)}).hashCode());
        AppMethodBeat.m2505o(130119);
        return valueOf;
    }
}
