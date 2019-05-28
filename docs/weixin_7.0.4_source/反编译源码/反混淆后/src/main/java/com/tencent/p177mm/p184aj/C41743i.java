package com.tencent.p177mm.p184aj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.aj.i */
public final class C41743i extends C7563j<C46874g> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C46874g.ccO, "BizKF")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(11400);
        AppMethodBeat.m2505o(11400);
    }

    public C41743i(C4927e c4927e) {
        super(c4927e, C46874g.ccO, "BizKF", null);
        AppMethodBeat.m2504i(11392);
        this.bSd = c4927e;
        c4927e.mo10108hY("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
        c4927e.mo10108hY("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
        AppMethodBeat.m2505o(11392);
    }

    /* renamed from: rg */
    public final C46874g mo67510rg(String str) {
        AppMethodBeat.m2504i(11393);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(11393);
            return null;
        }
        Cursor a = this.bSd.mo10105a("BizKF", null, "openId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            C46874g c46874g = new C46874g();
            c46874g.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(11393);
            return c46874g;
        }
        C4990ab.m7420w("MicroMsg.BizKFStorage", "get null with openId:".concat(String.valueOf(str)));
        a.close();
        AppMethodBeat.m2505o(11393);
        return null;
    }

    /* renamed from: a */
    public static boolean m73577a(C46874g c46874g) {
        AppMethodBeat.m2504i(11394);
        if (c46874g == null) {
            AppMethodBeat.m2505o(11394);
            return false;
        } else if (System.currentTimeMillis() - c46874g.field_updateTime >= 86400000) {
            AppMethodBeat.m2505o(11394);
            return true;
        } else {
            AppMethodBeat.m2505o(11394);
            return false;
        }
    }

    /* renamed from: b */
    private boolean m73578b(C46874g c46874g) {
        AppMethodBeat.m2504i(11395);
        if (c46874g == null || C5046bo.isNullOrNil(c46874g.field_openId) || C5046bo.isNullOrNil(c46874g.field_brandUsername)) {
            C4990ab.m7420w("MicroMsg.BizKFStorage", "wrong argument");
            AppMethodBeat.m2505o(11395);
            return false;
        }
        boolean z;
        if (this.bSd.replace("BizKF", C46874g.ccO.xDc, c46874g.mo10098Hl()) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", c46874g.field_openId, c46874g.field_brandUsername, Boolean.valueOf(z));
        AppMethodBeat.m2505o(11395);
        return z;
    }

    /* renamed from: rh */
    public final C46874g mo67511rh(String str) {
        AppMethodBeat.m2504i(11396);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(11396);
            return null;
        }
        Cursor a = this.bSd.mo10105a("BizKF", null, "brandUsername = ? order by kfType desc ", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            C46874g c46874g = new C46874g();
            c46874g.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(11396);
            return c46874g;
        }
        C4990ab.m7420w("MicroMsg.BizKFStorage", "get null with brandUsername:".concat(String.valueOf(str)));
        a.close();
        AppMethodBeat.m2505o(11396);
        return null;
    }

    /* renamed from: ri */
    public final int mo67512ri(String str) {
        AppMethodBeat.m2504i(11397);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(11397);
            return -1;
        }
        C4990ab.m7417i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", str, Integer.valueOf(this.bSd.delete("BizKF", "brandUsername = ?", new String[]{str})));
        AppMethodBeat.m2505o(11397);
        return this.bSd.delete("BizKF", "brandUsername = ?", new String[]{str});
    }

    /* renamed from: f */
    public final int mo67509f(LinkedList<C46874g> linkedList) {
        AppMethodBeat.m2504i(11398);
        if (linkedList.size() <= 0) {
            C4990ab.m7412e("MicroMsg.BizKFStorage", "null kfs");
            AppMethodBeat.m2505o(11398);
            return 0;
        }
        long iV;
        if (this.bSd instanceof C7480h) {
            iV = ((C7480h) this.bSd).mo15639iV(Thread.currentThread().getId());
        } else {
            iV = 0;
        }
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C46874g c46874g = (C46874g) it.next();
            if (c46874g != null && m73578b(c46874g)) {
                i++;
            }
            i = i;
        }
        if (this.bSd instanceof C7480h) {
            C1720g.m3536RP().eJN.mo15640mB(iV);
        }
        C4990ab.m7417i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(11398);
        return i;
    }
}
