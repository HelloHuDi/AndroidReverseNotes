package com.tencent.p177mm.plugin.sns.storage;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p711c.C32693ej;
import com.tencent.p177mm.plugin.sns.p1024b.C21874d;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.storage.k */
public final class C29096k extends C7563j<C21992j> implements C21874d {
    public static final String[] fnj = new String[]{C7563j.m13217a(C21992j.ccO, "SnsComment")};
    public C7480h fni;

    static {
        AppMethodBeat.m2504i(37854);
        AppMethodBeat.m2505o(37854);
    }

    public C29096k(C7480h c7480h) {
        super(c7480h, C21992j.ccO, "SnsComment", C32693ej.diI);
        this.fni = c7480h;
    }

    public static String cqE() {
        return "select *, rowid from SnsComment";
    }

    public final int baS() {
        int i = 0;
        AppMethodBeat.m2504i(37843);
        Cursor a = this.fni.mo10104a(" select count(*) from SnsComment where isRead = ? and isSilence != ? ", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "1"}, 2);
        if (a == null) {
            AppMethodBeat.m2505o(37843);
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.m2505o(37843);
        }
        return i;
    }

    /* renamed from: DH */
    public final Cursor mo47200DH(int i) {
        AppMethodBeat.m2504i(37844);
        String concat = "select *, rowid from SnsComment where isSend = 0 order by createTime desc LIMIT ".concat(String.valueOf(i));
        C4990ab.m7418v("MicroMsg.SnsCommentStorage", "getCursor sql:".concat(String.valueOf(concat)));
        Cursor a = this.fni.mo10104a(concat, null, 0);
        AppMethodBeat.m2505o(37844);
        return a;
    }

    public final Cursor cqF() {
        AppMethodBeat.m2504i(37845);
        Cursor a = this.fni.mo10104a("select *, rowid from SnsComment where isRead = ?  and isSilence != ?  order by createTime desc", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "1"}, 0);
        AppMethodBeat.m2505o(37845);
        return a;
    }

    /* renamed from: a */
    public final boolean mo47201a(long j, String str, int i, String str2) {
        String str3;
        AppMethodBeat.m2504i(37846);
        if (C5046bo.isNullOrNil(str2)) {
            str3 = "select count(*) from SnsComment where snsID = " + j + " and createTime = " + i + " and talker = '" + str + "'";
        } else {
            str3 = "select count(*) from SnsComment where snsID = " + j + " and clientId = '" + str2 + "'";
        }
        Cursor rawQuery = rawQuery(str3, new String[0]);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            int i2 = rawQuery.getInt(0);
            rawQuery.close();
            if (i2 > 0) {
                AppMethodBeat.m2505o(37846);
                return true;
            }
            AppMethodBeat.m2505o(37846);
            return false;
        }
        AppMethodBeat.m2505o(37846);
        return false;
    }

    public final int cqG() {
        AppMethodBeat.m2504i(37847);
        Cursor rawQuery = rawQuery("select count(*) from SnsComment where isSend = 0", new String[0]);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            AppMethodBeat.m2505o(37847);
            return i;
        }
        AppMethodBeat.m2505o(37847);
        return 0;
    }

    /* renamed from: f */
    public final C21992j mo47206f(long j, long j2, int i) {
        C21992j c21992j;
        AppMethodBeat.m2504i(37848);
        String str = "";
        if (i == 9) {
            str = str + "(2)";
        }
        if (i == 10) {
            str = str + "(8,16)";
        }
        Cursor rawQuery = rawQuery("select *, rowid from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type in " + str, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                c21992j = new C21992j();
                c21992j.mo8995d(rawQuery);
            } else {
                c21992j = null;
            }
            rawQuery.close();
        } else {
            c21992j = null;
        }
        AppMethodBeat.m2505o(37848);
        return c21992j;
    }

    /* renamed from: ky */
    public final boolean mo47208ky(long j) {
        AppMethodBeat.m2504i(37849);
        boolean hY = this.fni.mo10108hY("SnsComment", "delete from SnsComment where snsID = ".concat(String.valueOf(j)));
        AppMethodBeat.m2505o(37849);
        return hY;
    }

    /* renamed from: g */
    public final boolean mo47207g(long j, long j2, int i) {
        AppMethodBeat.m2504i(37850);
        String str = "";
        if (i == 9) {
            str = str + "(2)";
        }
        if (i == 10) {
            str = str + "(8,16)";
        }
        boolean hY = this.fni.mo10108hY("SnsComment", "delete from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type in " + str);
        AppMethodBeat.m2505o(37850);
        return hY;
    }

    public final boolean baT() {
        AppMethodBeat.m2504i(37851);
        boolean hY = this.fni.mo10108hY("SnsComment", " update SnsComment set isRead = 1 where isRead = 0");
        AppMethodBeat.m2505o(37851);
        return hY;
    }

    /* renamed from: y */
    public final boolean mo47209y(long j, boolean z) {
        AppMethodBeat.m2504i(37852);
        int i = z ? 1 : 0;
        String str = " update SnsComment set isSilence = " + i + " where isSilence != " + i + " and  snsID = " + j;
        C4990ab.m7416i("MicroMsg.SnsCommentStorage", "updateIsSilence ".concat(String.valueOf(str)));
        boolean hY = this.fni.mo10108hY("SnsComment", str);
        AppMethodBeat.m2505o(37852);
        return hY;
    }

    public final void cqH() {
        AppMethodBeat.m2504i(37853);
        this.fni.aqx("SnsComment");
        AppMethodBeat.m2505o(37853);
    }
}
