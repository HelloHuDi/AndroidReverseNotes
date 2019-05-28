package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6974e;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.storage.ay */
public final class C7619ay extends C7563j<C7569ax> implements C6974e {
    public static final String[] fnj = new String[]{C7563j.m13217a(C7569ax.ccO, "fmessage_msginfo")};
    private static final String[] xIq = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )"};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(1302);
        AppMethodBeat.m2505o(1302);
    }

    public C7619ay(C4927e c4927e) {
        super(c4927e, C7569ax.ccO, "fmessage_msginfo", xIq);
        this.bSd = c4927e;
    }

    public final C7569ax[] apv(String str) {
        AppMethodBeat.m2504i(1294);
        C4990ab.m7410d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
        Cursor a = this.bSd.mo10104a("select *, rowid from fmessage_msginfo  where talker = '" + C5046bo.m7586vA(str) + "' order by createTime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            C7569ax c7569ax = new C7569ax();
            c7569ax.mo8995d(a);
            arrayList.add(c7569ax);
        }
        a.close();
        C7569ax[] c7569axArr = (C7569ax[]) arrayList.toArray(new C7569ax[arrayList.size()]);
        AppMethodBeat.m2505o(1294);
        return c7569axArr;
    }

    public final C7569ax apw(String str) {
        C7569ax c7569ax = null;
        AppMethodBeat.m2504i(1295);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
            AppMethodBeat.m2505o(1295);
        } else {
            Cursor a = this.bSd.mo10104a("select * from fmessage_msginfo where talker = '" + C5046bo.m7586vA(str) + "' order by createTime DESC limit 1", null, 2);
            c7569ax = new C7569ax();
            if (a.moveToFirst()) {
                c7569ax.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(1295);
        }
        return c7569ax;
    }

    public final C7569ax apx(String str) {
        AppMethodBeat.m2504i(1296);
        C7569ax[] eq = mo17081eq(str, 1);
        if (eq == null || eq.length <= 0) {
            AppMethodBeat.m2505o(1296);
            return null;
        }
        C7569ax c7569ax = eq[0];
        AppMethodBeat.m2505o(1296);
        return c7569ax;
    }

    /* renamed from: eq */
    public final C7569ax[] mo17081eq(String str, int i) {
        AppMethodBeat.m2504i(1297);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
            AppMethodBeat.m2505o(1297);
            return null;
        }
        Cursor a = this.bSd.mo10104a("select * from fmessage_msginfo where isSend != 1 and talker = '" + C5046bo.m7586vA(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            C7569ax c7569ax = new C7569ax();
            c7569ax.mo8995d(a);
            arrayList.add(c7569ax);
        }
        a.close();
        C7569ax[] c7569axArr = (C7569ax[]) arrayList.toArray(new C7569ax[arrayList.size()]);
        AppMethodBeat.m2505o(1297);
        return c7569axArr;
    }

    /* renamed from: b */
    public final boolean mo17080b(C7569ax c7569ax) {
        AppMethodBeat.m2504i(1298);
        if (c7569ax == null) {
            C4990ab.m7412e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
            AppMethodBeat.m2505o(1298);
            return false;
        } else if (super.mo10101b((C4925c) c7569ax)) {
            anF(c7569ax.xDa);
            AppMethodBeat.m2505o(1298);
            return true;
        } else {
            AppMethodBeat.m2505o(1298);
            return false;
        }
    }

    public final List<C7569ax> bOw() {
        AppMethodBeat.m2504i(1299);
        C4990ab.m7410d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, type = 0");
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a("select *, rowid from fmessage_msginfo where type = 0", null, 2);
        while (a.moveToNext()) {
            C7569ax c7569ax = new C7569ax();
            c7569ax.mo8995d(a);
            arrayList.add(c7569ax);
        }
        a.close();
        C4990ab.m7410d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + arrayList.size());
        AppMethodBeat.m2505o(1299);
        return arrayList;
    }

    /* renamed from: QS */
    public final boolean mo15227QS(String str) {
        AppMethodBeat.m2504i(1300);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
            AppMethodBeat.m2505o(1300);
            return false;
        }
        boolean hY = this.bSd.mo10108hY("fmessage_msginfo", "delete from fmessage_msginfo where talker = '" + C5046bo.m7586vA(str) + "'");
        AppMethodBeat.m2505o(1300);
        return hY;
    }
}
