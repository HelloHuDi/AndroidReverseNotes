package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6979l;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.storage.bu */
public final class C46622bu extends C7563j<C41338bt> implements C6979l {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )"};
    public static final String[] fnj = new String[]{C7563j.m13217a(C41338bt.ccO, "shakeverifymessage")};
    public C4927e bSd;

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(1471);
        boolean a = mo74759a((C41338bt) c4925c);
        AppMethodBeat.m2505o(1471);
        return a;
    }

    static {
        AppMethodBeat.m2504i(1472);
        AppMethodBeat.m2505o(1472);
    }

    public C46622bu(C4927e c4927e) {
        super(c4927e, C41338bt.ccO, "shakeverifymessage", diI);
        this.bSd = c4927e;
    }

    public final int baS() {
        AppMethodBeat.m2504i(1461);
        Cursor a = this.bSd.mo10104a("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            if (i > 0) {
                AppMethodBeat.m2505o(1461);
                return i;
            }
            AppMethodBeat.m2505o(1461);
            return 0;
        }
        a.close();
        AppMethodBeat.m2505o(1461);
        return 0;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(1462);
        Cursor a = this.bSd.mo10104a("select count(*) from " + getTableName(), null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            if (i > 0) {
                AppMethodBeat.m2505o(1462);
                return i;
            }
            AppMethodBeat.m2505o(1462);
            return 0;
        }
        a.close();
        AppMethodBeat.m2505o(1462);
        return 0;
    }

    public final C41338bt duu() {
        AppMethodBeat.m2504i(1463);
        Cursor a = this.bSd.mo10104a("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(1463);
            return null;
        } else if (a.moveToFirst()) {
            C41338bt c41338bt = new C41338bt();
            c41338bt.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(1463);
            return c41338bt;
        } else {
            a.close();
            AppMethodBeat.m2505o(1463);
            return null;
        }
    }

    /* renamed from: xm */
    public final Cursor mo74765xm(int i) {
        AppMethodBeat.m2504i(1464);
        Cursor rawQuery = this.bSd.rawQuery("SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + i, null);
        AppMethodBeat.m2505o(1464);
        return rawQuery;
    }

    /* renamed from: QT */
    public final void mo74758QT(String str) {
        AppMethodBeat.m2504i(1465);
        int delete = this.bSd.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        C4990ab.m7416i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(delete)));
        AppMethodBeat.m2505o(1465);
    }

    public final void axQ() {
        AppMethodBeat.m2504i(1466);
        this.bSd.delete(getTableName(), null, null);
        AppMethodBeat.m2505o(1466);
    }

    /* renamed from: a */
    public final boolean mo74759a(C41338bt c41338bt) {
        AppMethodBeat.m2504i(1467);
        if (c41338bt == null) {
            C4990ab.m7412e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
            AppMethodBeat.m2505o(1467);
            return false;
        } else if (super.mo10101b((C4925c) c41338bt)) {
            anF(c41338bt.xDa);
            AppMethodBeat.m2505o(1467);
            return true;
        } else {
            AppMethodBeat.m2505o(1467);
            return false;
        }
    }

    /* renamed from: et */
    public final C41338bt[] mo74764et(String str, int i) {
        AppMethodBeat.m2504i(1468);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
            AppMethodBeat.m2505o(1468);
            return null;
        }
        Cursor a = this.bSd.mo10104a("select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + C5046bo.m7586vA(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            C41338bt c41338bt = new C41338bt();
            c41338bt.mo8995d(a);
            arrayList.add(c41338bt);
        }
        a.close();
        if (arrayList.size() == 0) {
            AppMethodBeat.m2505o(1468);
            return null;
        }
        C41338bt[] c41338btArr = (C41338bt[]) arrayList.toArray(new C41338bt[arrayList.size()]);
        AppMethodBeat.m2505o(1468);
        return c41338btArr;
    }

    public final C41338bt[] apY(String str) {
        AppMethodBeat.m2504i(1469);
        C4990ab.m7410d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
        Cursor a = this.bSd.mo10104a("select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + C5046bo.m7586vA(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            C41338bt c41338bt = new C41338bt();
            c41338bt.mo8995d(a);
            arrayList.add(c41338bt);
        }
        a.close();
        if (arrayList.size() == 0) {
            AppMethodBeat.m2505o(1469);
            return null;
        }
        C41338bt[] c41338btArr = (C41338bt[]) arrayList.toArray(new C41338bt[arrayList.size()]);
        AppMethodBeat.m2505o(1469);
        return c41338btArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: QV */
    public final long mo15363QV(String str) {
        long j;
        long anT;
        AppMethodBeat.m2504i(1470);
        if (str != null) {
            C41338bt duu = ((C46622bu) ((C6982j) C1720g.m3528K(C6982j.class)).bOn()).duu();
            if (duu != null) {
                j = duu.field_createtime + 1;
                anT = C5046bo.anT();
                if (j <= anT) {
                    AppMethodBeat.m2505o(1470);
                    return j;
                }
                AppMethodBeat.m2505o(1470);
                return anT;
            }
        }
        j = 0;
        anT = C5046bo.anT();
        if (j <= anT) {
        }
    }
}
