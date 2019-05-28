package com.tencent.p177mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C8939o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.model.i */
public final class C26428i {
    /* renamed from: mn */
    public static void m42084mn(String str) {
        AppMethodBeat.m2504i(11228);
        Assert.assertTrue(!C5046bo.isNullOrNil(str));
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            AppMethodBeat.m2505o(11228);
            return;
        }
        aoO.setType(aoO.field_type | 2048);
        C1855t.m3964u(aoO);
        if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(str) == null && aoO.dsf()) {
            if (C17903f.m28106qZ(str)) {
                C7617ak c7617ak;
                if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ("officialaccounts") == null) {
                    c7617ak = new C7617ak("officialaccounts");
                    c7617ak.dsI();
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(c7617ak);
                }
                c7617ak = new C7617ak(str);
                c7617ak.mo14742eD(System.currentTimeMillis());
                c7617ak.mo14760jj("officialaccounts");
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(c7617ak);
            } else if (C17903f.m28108rb(str) && !C17903f.m28103kq(str)) {
                C7617ak c7617ak2;
                C16527d qX = C17903f.m28104qX(str);
                if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(qX.field_enterpriseFather) == null) {
                    c7617ak2 = new C7617ak(qX.field_enterpriseFather);
                    c7617ak2.dsI();
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(c7617ak2);
                }
                c7617ak2 = new C7617ak(str);
                c7617ak2.mo14742eD(System.currentTimeMillis());
                c7617ak2.mo14760jj(qX.adX());
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(c7617ak2);
            }
            C4990ab.m7416i("MicroMsg.BizConversationLogic", "setPlacedTop username = ".concat(String.valueOf(str)));
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apf(str);
        AppMethodBeat.m2505o(11228);
    }

    /* renamed from: a */
    public static int m42083a(final String str, final long j, final C1827a c1827a) {
        AppMethodBeat.m2504i(11229);
        C4990ab.m7411d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", Long.valueOf(j));
        C1720g.m3539RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.model.i$1$1 */
            class C186381 implements Runnable {
                C186381() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(11225);
                    if (c1827a != null) {
                        c1827a.mo5406JV();
                    }
                    AppMethodBeat.m2505o(11225);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(11226);
                Cursor aP = ((C8939o) C1720g.m3528K(C8939o.class)).mo20357XP().mo74795aP(str, j);
                if (aP.moveToFirst()) {
                    while (!aP.isAfterLast() && (c1827a == null || !c1827a.mo5405JU())) {
                        C7620bi c7620bi = new C7620bi();
                        c7620bi.mo8995d(aP);
                        C1829bf.m3753m(c7620bi);
                        aP.moveToNext();
                    }
                }
                aP.close();
                ((C8939o) C1720g.m3528K(C8939o.class)).mo20357XP().mo74794aO(str, j);
                C5004al.m7441d(new C186381());
                AppMethodBeat.m2505o(11226);
            }

            public final String toString() {
                AppMethodBeat.m2504i(11227);
                String str = super.toString() + "|deleteMsgByTalker";
                AppMethodBeat.m2505o(11227);
                return str;
            }
        });
        AppMethodBeat.m2505o(11229);
        return 0;
    }
}
