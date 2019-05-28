package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.c.ej;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class k extends j<j> implements d {
    public static final String[] fnj = new String[]{j.a(j.ccO, "SnsComment")};
    public h fni;

    static {
        AppMethodBeat.i(37854);
        AppMethodBeat.o(37854);
    }

    public k(h hVar) {
        super(hVar, j.ccO, "SnsComment", ej.diI);
        this.fni = hVar;
    }

    public static String cqE() {
        return "select *, rowid from SnsComment";
    }

    public final int baS() {
        int i = 0;
        AppMethodBeat.i(37843);
        Cursor a = this.fni.a(" select count(*) from SnsComment where isRead = ? and isSilence != ? ", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "1"}, 2);
        if (a == null) {
            AppMethodBeat.o(37843);
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.o(37843);
        }
        return i;
    }

    public final Cursor DH(int i) {
        AppMethodBeat.i(37844);
        String concat = "select *, rowid from SnsComment where isSend = 0 order by createTime desc LIMIT ".concat(String.valueOf(i));
        ab.v("MicroMsg.SnsCommentStorage", "getCursor sql:".concat(String.valueOf(concat)));
        Cursor a = this.fni.a(concat, null, 0);
        AppMethodBeat.o(37844);
        return a;
    }

    public final Cursor cqF() {
        AppMethodBeat.i(37845);
        Cursor a = this.fni.a("select *, rowid from SnsComment where isRead = ?  and isSilence != ?  order by createTime desc", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "1"}, 0);
        AppMethodBeat.o(37845);
        return a;
    }

    public final boolean a(long j, String str, int i, String str2) {
        String str3;
        AppMethodBeat.i(37846);
        if (bo.isNullOrNil(str2)) {
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
                AppMethodBeat.o(37846);
                return true;
            }
            AppMethodBeat.o(37846);
            return false;
        }
        AppMethodBeat.o(37846);
        return false;
    }

    public final int cqG() {
        AppMethodBeat.i(37847);
        Cursor rawQuery = rawQuery("select count(*) from SnsComment where isSend = 0", new String[0]);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            AppMethodBeat.o(37847);
            return i;
        }
        AppMethodBeat.o(37847);
        return 0;
    }

    public final j f(long j, long j2, int i) {
        j jVar;
        AppMethodBeat.i(37848);
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
                jVar = new j();
                jVar.d(rawQuery);
            } else {
                jVar = null;
            }
            rawQuery.close();
        } else {
            jVar = null;
        }
        AppMethodBeat.o(37848);
        return jVar;
    }

    public final boolean ky(long j) {
        AppMethodBeat.i(37849);
        boolean hY = this.fni.hY("SnsComment", "delete from SnsComment where snsID = ".concat(String.valueOf(j)));
        AppMethodBeat.o(37849);
        return hY;
    }

    public final boolean g(long j, long j2, int i) {
        AppMethodBeat.i(37850);
        String str = "";
        if (i == 9) {
            str = str + "(2)";
        }
        if (i == 10) {
            str = str + "(8,16)";
        }
        boolean hY = this.fni.hY("SnsComment", "delete from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type in " + str);
        AppMethodBeat.o(37850);
        return hY;
    }

    public final boolean baT() {
        AppMethodBeat.i(37851);
        boolean hY = this.fni.hY("SnsComment", " update SnsComment set isRead = 1 where isRead = 0");
        AppMethodBeat.o(37851);
        return hY;
    }

    public final boolean y(long j, boolean z) {
        AppMethodBeat.i(37852);
        int i = z ? 1 : 0;
        String str = " update SnsComment set isSilence = " + i + " where isSilence != " + i + " and  snsID = " + j;
        ab.i("MicroMsg.SnsCommentStorage", "updateIsSilence ".concat(String.valueOf(str)));
        boolean hY = this.fni.hY("SnsComment", str);
        AppMethodBeat.o(37852);
        return hY;
    }

    public final void cqH() {
        AppMethodBeat.i(37853);
        this.fni.aqx("SnsComment");
        AppMethodBeat.o(37853);
    }
}
