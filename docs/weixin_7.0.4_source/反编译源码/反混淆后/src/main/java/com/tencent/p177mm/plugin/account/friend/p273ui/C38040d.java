package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.content.Context;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.plugin.account.friend.p272a.C45496ap;
import com.tencent.p177mm.plugin.account.friend.p272a.C9878ao;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.d */
public abstract class C38040d extends C46692p<C9878ao> implements C8915a {

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.d$a */
    public interface C18835a {
        /* renamed from: mT */
        void mo34111mT(int i);
    }

    public C38040d(Context context, C9878ao c9878ao) {
        super(context, c9878ao);
    }

    /* renamed from: a */
    public void mo21259a(C18835a c18835a) {
    }

    /* renamed from: vM */
    public void mo21261vM(String str) {
    }

    /* renamed from: wl */
    public static void m64370wl(String str) {
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
            return;
        }
        C9878ao wj = ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73286wj(str);
        if (wj != null) {
            wj.gwD = 2;
            ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73281a(wj.gwC, wj);
        }
        C7486a aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null) {
            C4990ab.m7420w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
            return;
        }
        C7486a aoO2;
        if (C5046bo.isNullOrNil(aoO.field_username)) {
            aoO.setUsername(str);
        }
        if (((int) aoO.ewQ) == 0) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15708aa(aoO);
            if (!C5046bo.isNullOrNil(aoO.field_username)) {
                aoO2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aoO.field_username);
            } else {
                return;
            }
        }
        aoO2 = aoO;
        if (((int) aoO2.ewQ) <= 0) {
            C4990ab.m7412e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
            return;
        }
        C1855t.m3960q(aoO2);
        C37907bv.aaq().mo60662c(26, new Object[0]);
    }
}
