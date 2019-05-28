package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bm extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )"};
    public h fni;

    public static String oH(String str) {
        AppMethodBeat.i(76727);
        String str2 = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + str + "  ";
        AppMethodBeat.o(76727);
        return str2;
    }

    public static String kH(int i) {
        AppMethodBeat.i(76728);
        String str;
        if (i == 20) {
            str = "readerappnews1";
            AppMethodBeat.o(76728);
            return str;
        } else if (i == 11) {
            str = "readerappweibo";
            AppMethodBeat.o(76728);
            return str;
        } else {
            Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
            AppMethodBeat.o(76728);
            return null;
        }
    }

    public bm(h hVar) {
        this.fni = hVar;
    }

    public final Cursor cp(int i, int i2) {
        AppMethodBeat.i(76729);
        Cursor a = this.fni.a("SELECT reserved3 from " + kH(i2) + " GROUP BY reserved3 ORDER BY time ASC  LIMIT " + i + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + kH(i2) + " GROUP BY reserved3)) -" + i, null, 0);
        AppMethodBeat.o(76729);
        return a;
    }

    public final int kI(int i) {
        int i2 = 0;
        AppMethodBeat.i(76730);
        Cursor a = this.fni.a("select count(*) from (SELECT count(*) FROM " + kH(i) + " group by reserved3)", null, 2);
        if (a.moveToFirst()) {
            i2 = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(76730);
        return i2;
    }

    public final List<bl> fn(long j) {
        AppMethodBeat.i(76731);
        ArrayList arrayList = new ArrayList();
        String str = oH(kH(20)) + " where reserved2 = " + j;
        ab.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(str)));
        Cursor a = this.fni.a(str, null, 2);
        while (a.moveToNext()) {
            bl blVar = new bl();
            blVar.d(a);
            arrayList.add(blVar);
        }
        a.close();
        AppMethodBeat.o(76731);
        return arrayList;
    }

    public final List<bl> Q(String str, int i) {
        AppMethodBeat.i(76732);
        ArrayList arrayList = new ArrayList();
        String str2 = oH(kH(i)) + "where reserved3 = " + h.escape(str) + " order by istop desc , tweetid asc ";
        ab.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(str2)));
        Cursor a = this.fni.a(str2, null, 2);
        while (a.moveToNext()) {
            bl blVar = new bl();
            blVar.d(a);
            arrayList.add(blVar);
        }
        a.close();
        AppMethodBeat.o(76732);
        return arrayList;
    }

    public final List<bl> R(String str, int i) {
        AppMethodBeat.i(76733);
        Cursor a = this.fni.a(kH(i), new String[]{"*"}, "reserved3=?", new String[]{str}, null, null, null, 2);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    ArrayList arrayList = new ArrayList();
                    do {
                        bl blVar = new bl();
                        blVar.d(a);
                        arrayList.add(blVar);
                    } while (a.moveToNext());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.o(76733);
                    return arrayList;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.ReaderAppInfoStorage", "getByFunctionMsgId, error: %s", e.getMessage());
                if (a != null) {
                    a.close();
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(76733);
            }
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.o(76733);
        return null;
    }

    public final void kJ(int i) {
        AppMethodBeat.i(76734);
        ak aoZ = ((j) g.K(j.class)).XR().aoZ(bl.kG(i));
        if (aoZ == null || !aoZ.field_username.equals(bl.kG(i))) {
            AppMethodBeat.o(76734);
            return;
        }
        aoZ.setUsername(bl.kG(i));
        aoZ.setContent("");
        aoZ.hO(0);
        aoZ.hM(0);
        ((j) g.K(j.class)).XR().a(aoZ, bl.kG(i));
        if (this.fni.hY(kH(i), "delete from " + kH(i))) {
            doNotify();
        }
        AppMethodBeat.o(76734);
    }

    public final void kK(int i) {
        AppMethodBeat.i(76735);
        ab.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", oH(kH(i)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2");
        Cursor a = this.fni.a(r0, null, 2);
        if (a.moveToFirst()) {
            bl blVar = new bl();
            blVar.d(a);
            a.close();
            ak akVar = new ak();
            akVar.setUsername(bl.kG(i));
            akVar.setContent(blVar.getTitle());
            akVar.eD(blVar.time);
            akVar.hO(0);
            akVar.hM(0);
            ((j) g.K(j.class)).XR().a(akVar, bl.kG(i));
            AppMethodBeat.o(76735);
            return;
        }
        a.close();
        ak akVar2 = new ak();
        akVar2.setUsername(bl.kG(i));
        akVar2.setContent("");
        akVar2.eD(0);
        akVar2.hO(0);
        akVar2.hM(0);
        ((j) g.K(j.class)).XR().a(akVar2, bl.kG(i));
        AppMethodBeat.o(76735);
    }
}
