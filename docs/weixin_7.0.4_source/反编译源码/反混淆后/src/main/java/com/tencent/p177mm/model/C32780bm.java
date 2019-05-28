package com.tencent.p177mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7617ak;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.model.bm */
public final class C32780bm extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerappfunctionId ON readerappnews1 ( reserved3 )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )"};
    public C7480h fni;

    /* renamed from: oH */
    public static String m53550oH(String str) {
        AppMethodBeat.m2504i(76727);
        String str2 = "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + str + "  ";
        AppMethodBeat.m2505o(76727);
        return str2;
    }

    /* renamed from: kH */
    public static String m53549kH(int i) {
        AppMethodBeat.m2504i(76728);
        String str;
        if (i == 20) {
            str = "readerappnews1";
            AppMethodBeat.m2505o(76728);
            return str;
        } else if (i == 11) {
            str = "readerappweibo";
            AppMethodBeat.m2505o(76728);
            return str;
        } else {
            Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
            AppMethodBeat.m2505o(76728);
            return null;
        }
    }

    public C32780bm(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: cp */
    public final Cursor mo53336cp(int i, int i2) {
        AppMethodBeat.m2504i(76729);
        Cursor a = this.fni.mo10104a("SELECT reserved3 from " + C32780bm.m53549kH(i2) + " GROUP BY reserved3 ORDER BY time ASC  LIMIT " + i + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + C32780bm.m53549kH(i2) + " GROUP BY reserved3)) -" + i, null, 0);
        AppMethodBeat.m2505o(76729);
        return a;
    }

    /* renamed from: kI */
    public final int mo53338kI(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(76730);
        Cursor a = this.fni.mo10104a("select count(*) from (SELECT count(*) FROM " + C32780bm.m53549kH(i) + " group by reserved3)", null, 2);
        if (a.moveToFirst()) {
            i2 = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(76730);
        return i2;
    }

    /* renamed from: fn */
    public final List<C32779bl> mo53337fn(long j) {
        AppMethodBeat.m2504i(76731);
        ArrayList arrayList = new ArrayList();
        String str = C32780bm.m53550oH(C32780bm.m53549kH(20)) + " where reserved2 = " + j;
        C4990ab.m7410d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :".concat(String.valueOf(str)));
        Cursor a = this.fni.mo10104a(str, null, 2);
        while (a.moveToNext()) {
            C32779bl c32779bl = new C32779bl();
            c32779bl.mo53329d(a);
            arrayList.add(c32779bl);
        }
        a.close();
        AppMethodBeat.m2505o(76731);
        return arrayList;
    }

    /* renamed from: Q */
    public final List<C32779bl> mo53334Q(String str, int i) {
        AppMethodBeat.m2504i(76732);
        ArrayList arrayList = new ArrayList();
        String str2 = C32780bm.m53550oH(C32780bm.m53549kH(i)) + "where reserved3 = " + C7480h.escape(str) + " order by istop desc , tweetid asc ";
        C4990ab.m7410d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :".concat(String.valueOf(str2)));
        Cursor a = this.fni.mo10104a(str2, null, 2);
        while (a.moveToNext()) {
            C32779bl c32779bl = new C32779bl();
            c32779bl.mo53329d(a);
            arrayList.add(c32779bl);
        }
        a.close();
        AppMethodBeat.m2505o(76732);
        return arrayList;
    }

    /* renamed from: R */
    public final List<C32779bl> mo53335R(String str, int i) {
        AppMethodBeat.m2504i(76733);
        Cursor a = this.fni.mo10105a(C32780bm.m53549kH(i), new String[]{"*"}, "reserved3=?", new String[]{str}, null, null, null, 2);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    ArrayList arrayList = new ArrayList();
                    do {
                        C32779bl c32779bl = new C32779bl();
                        c32779bl.mo53329d(a);
                        arrayList.add(c32779bl);
                    } while (a.moveToNext());
                    if (a != null) {
                        a.close();
                    }
                    AppMethodBeat.m2505o(76733);
                    return arrayList;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ReaderAppInfoStorage", "getByFunctionMsgId, error: %s", e.getMessage());
                if (a != null) {
                    a.close();
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.m2505o(76733);
            }
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.m2505o(76733);
        return null;
    }

    /* renamed from: kJ */
    public final void mo53339kJ(int i) {
        AppMethodBeat.m2504i(76734);
        C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(C32779bl.m53547kG(i));
        if (aoZ == null || !aoZ.field_username.equals(C32779bl.m53547kG(i))) {
            AppMethodBeat.m2505o(76734);
            return;
        }
        aoZ.setUsername(C32779bl.m53547kG(i));
        aoZ.setContent("");
        aoZ.mo14750hO(0);
        aoZ.mo14748hM(0);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, C32779bl.m53547kG(i));
        if (this.fni.mo10108hY(C32780bm.m53549kH(i), "delete from " + C32780bm.m53549kH(i))) {
            doNotify();
        }
        AppMethodBeat.m2505o(76734);
    }

    /* renamed from: kK */
    public final void mo53340kK(int i) {
        AppMethodBeat.m2504i(76735);
        C4990ab.m7417i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", C32780bm.m53550oH(C32780bm.m53549kH(i)) + " where istop = 1  group by reserved3 ORDER BY time DESC  limit 2");
        Cursor a = this.fni.mo10104a(r0, null, 2);
        if (a.moveToFirst()) {
            C32779bl c32779bl = new C32779bl();
            c32779bl.mo53329d(a);
            a.close();
            C7617ak c7617ak = new C7617ak();
            c7617ak.setUsername(C32779bl.m53547kG(i));
            c7617ak.setContent(c32779bl.getTitle());
            c7617ak.mo14742eD(c32779bl.time);
            c7617ak.mo14750hO(0);
            c7617ak.mo14748hM(0);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(c7617ak, C32779bl.m53547kG(i));
            AppMethodBeat.m2505o(76735);
            return;
        }
        a.close();
        C7617ak c7617ak2 = new C7617ak();
        c7617ak2.setUsername(C32779bl.m53547kG(i));
        c7617ak2.setContent("");
        c7617ak2.mo14742eD(0);
        c7617ak2.mo14750hO(0);
        c7617ak2.mo14748hM(0);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(c7617ak2, C32779bl.m53547kG(i));
        AppMethodBeat.m2505o(76735);
    }
}
