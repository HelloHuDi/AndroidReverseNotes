package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class k extends com.tencent.mm.sdk.e.k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) "};
    public h fni;

    public k(h hVar) {
        this.fni = hVar;
    }

    /* JADX WARNING: Missing block: B:6:0x005c, code skipped:
            if (r2 > 0) goto L_0x005e;
     */
    /* JADX WARNING: Missing block: B:12:0x007c, code skipped:
            if (((int) r9.fni.insert("friend_ext", "username", r10.Hl())) == -1) goto L_0x007e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(j jVar) {
        boolean z = true;
        AppMethodBeat.i(108358);
        Cursor a = this.fni.a("select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bo.vA(String.valueOf(jVar.getUsername())) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            if (jVar != null) {
                ContentValues Hl = jVar.Hl();
                int update;
                if (Hl.size() > 0) {
                    update = this.fni.update("friend_ext", Hl, "username=?", new String[]{"username"});
                } else {
                    update = 0;
                }
            }
            z = false;
        } else {
            if (jVar != null) {
                jVar.bJt = -1;
            }
            z = false;
        }
        doNotify();
        AppMethodBeat.o(108358);
        return z;
    }

    public final boolean aa(List<j> list) {
        AppMethodBeat.i(108359);
        if (list.size() <= 0) {
            AppMethodBeat.o(108359);
            return false;
        }
        boolean z;
        bm bmVar = new bm("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
        bmVar.addSplit("transation begin");
        long iV = this.fni.iV(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                j jVar = (j) list.get(i);
                if (jVar != null) {
                    a(jVar);
                }
                i++;
            } catch (Exception e) {
                ab.e("MicroMsg.FriendExtStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.fni.mB(iV);
        bmVar.addSplit("transation end");
        bmVar.dumpToLog();
        doNotify();
        AppMethodBeat.o(108359);
        return z;
    }
}
