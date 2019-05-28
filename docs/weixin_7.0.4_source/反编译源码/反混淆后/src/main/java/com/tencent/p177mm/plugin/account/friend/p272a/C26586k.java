package com.tencent.p177mm.plugin.account.friend.p272a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5042bm;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.friend.a.k */
public final class C26586k extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) "};
    public C7480h fni;

    public C26586k(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* JADX WARNING: Missing block: B:6:0x005c, code skipped:
            if (r2 > 0) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:12:0x007c, code skipped:
            if (((int) r9.fni.insert("friend_ext", "username", r10.mo21237Hl())) == -1) goto L_0x007e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo44367a(C9879j c9879j) {
        boolean z = true;
        AppMethodBeat.m2504i(108358);
        Cursor a = this.fni.mo10104a("select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + C5046bo.m7586vA(String.valueOf(c9879j.getUsername())) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            if (c9879j != null) {
                ContentValues Hl = c9879j.mo21237Hl();
                int update;
                if (Hl.size() > 0) {
                    update = this.fni.update("friend_ext", Hl, "username=?", new String[]{"username"});
                } else {
                    update = 0;
                }
            }
            z = false;
        } else {
            if (c9879j != null) {
                c9879j.bJt = -1;
            }
            z = false;
        }
        doNotify();
        AppMethodBeat.m2505o(108358);
        return z;
    }

    /* renamed from: aa */
    public final boolean mo44368aa(List<C9879j> list) {
        AppMethodBeat.m2504i(108359);
        if (list.size() <= 0) {
            AppMethodBeat.m2505o(108359);
            return false;
        }
        boolean z;
        C5042bm c5042bm = new C5042bm("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
        c5042bm.addSplit("transation begin");
        long iV = this.fni.mo15639iV(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                C9879j c9879j = (C9879j) list.get(i);
                if (c9879j != null) {
                    mo44367a(c9879j);
                }
                i++;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.FriendExtStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.fni.mo15640mB(iV);
        c5042bm.addSplit("transation end");
        c5042bm.dumpToLog();
        doNotify();
        AppMethodBeat.m2505o(108359);
        return z;
    }
}
