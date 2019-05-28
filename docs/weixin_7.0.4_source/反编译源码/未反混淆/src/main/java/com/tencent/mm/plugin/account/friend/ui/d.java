package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;

public abstract class d extends p<ao> implements com.tencent.mm.ah.d.a {

    public interface a {
        void mT(int i);
    }

    public d(Context context, ao aoVar) {
        super(context, aoVar);
    }

    public void a(a aVar) {
    }

    public void vM(String str) {
    }

    public static void wl(String str) {
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
            return;
        }
        ao wj = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).wj(str);
        if (wj != null) {
            wj.gwD = 2;
            ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(wj.gwC, wj);
        }
        com.tencent.mm.n.a aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null) {
            ab.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
            return;
        }
        com.tencent.mm.n.a aoO2;
        if (bo.isNullOrNil(aoO.field_username)) {
            aoO.setUsername(str);
        }
        if (((int) aoO.ewQ) == 0) {
            ((j) g.K(j.class)).XM().aa(aoO);
            if (!bo.isNullOrNil(aoO.field_username)) {
                aoO2 = ((j) g.K(j.class)).XM().aoO(aoO.field_username);
            } else {
                return;
            }
        }
        aoO2 = aoO;
        if (((int) aoO2.ewQ) <= 0) {
            ab.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
            return;
        }
        t.q(aoO2);
        bv.aaq().c(26, new Object[0]);
    }
}
