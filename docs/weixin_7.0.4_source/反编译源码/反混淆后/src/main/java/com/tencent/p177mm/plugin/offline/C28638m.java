package com.tencent.p177mm.plugin.offline;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1529bw.p1530a.C37623a;
import com.tencent.p177mm.p230g.p231a.C42073vg;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C21409e;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C21411f;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C3562a;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C3563c;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.plugin.offline.m */
public final class C28638m implements C3562a {
    C4884c nZv = new C286391();

    /* renamed from: com.tencent.mm.plugin.offline.m$1 */
    class C286391 extends C4884c<C42073vg> {
        C286391() {
            AppMethodBeat.m2504i(43376);
            this.xxI = C42073vg.class.getName().hashCode();
            AppMethodBeat.m2505o(43376);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43377);
            C42073vg c42073vg = (C42073vg) c4883b;
            if (c42073vg instanceof C42073vg) {
                switch (c42073vg.cSe.action) {
                    case 3:
                        if (!((C40167b) C1720g.m3528K(C40167b.class)).cTj()) {
                            if (!C14241r.cPI().cQl()) {
                                if (!C14241r.cPI().cQi()) {
                                    if (!C14241r.cPI().cQg() || !C28630a.bYd()) {
                                        if (!C14241r.cPI().cQg() || C28630a.bYd()) {
                                            if (C14241r.cPI().cQh()) {
                                                c42073vg.cSf.cSg = 3;
                                                break;
                                            }
                                        }
                                        c42073vg.cSf.cSg = 4;
                                        break;
                                    }
                                    C7007k.bXg();
                                    C12741e bXi = C7007k.bXi();
                                    C4990ab.m7417i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", Integer.valueOf(9), Integer.valueOf(0), C5046bo.dpG().toString());
                                    String r = bXi.mo24748r(9, 0, "");
                                    Bitmap b = C37623a.m63542b(C4996ah.getContext(), r, 5, 0);
                                    Bitmap b2 = C37623a.m63542b(C4996ah.getContext(), r, 12, 3);
                                    c42073vg.cSf.cSg = 1;
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                    c42073vg.cSf.cSk = byteArrayOutputStream.toByteArray();
                                    byteArrayOutputStream.reset();
                                    b2.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                    c42073vg.cSf.cSl = byteArrayOutputStream.toByteArray();
                                    c42073vg.cSf.cSm = C36391e.atx(r);
                                    if (C28630a.bYf() == null) {
                                        C4990ab.m7416i("MicroMsg.Wear.WearOfflineLogic", "get payway fail");
                                        break;
                                    }
                                    c42073vg.cSf.cSn = C4996ah.getContext().getString(C25738R.string.fv8, new Object[]{r0.field_desc});
                                    C4990ab.m7417i("MicroMsg.Wear.WearOfflineLogic", "payway %s", c42073vg.cSf.cSn);
                                    break;
                                }
                                c42073vg.cSf.cSg = 3;
                                break;
                            }
                            c42073vg.cSf.cSg = 2;
                            break;
                        }
                        c42073vg.cSf.cSg = 5;
                        break;
                        break;
                }
            }
            AppMethodBeat.m2505o(43377);
            return false;
        }
    }

    public C28638m() {
        AppMethodBeat.m2504i(43378);
        C4879a.xxA.mo10052c(this.nZv);
        C7007k.bXg();
        C7007k.bXh().mo36866a(this);
        AppMethodBeat.m2505o(43378);
    }

    /* renamed from: aU */
    private static void m45531aU(int i, String str) {
        AppMethodBeat.m2504i(43379);
        C42073vg c42073vg = new C42073vg();
        c42073vg.cSe.cSg = i;
        c42073vg.cSe.action = 4;
        c42073vg.cSe.content = str;
        C4879a.xxA.mo10055m(c42073vg);
        AppMethodBeat.m2505o(43379);
    }

    /* renamed from: a */
    public final boolean mo8122a(C3563c c3563c) {
        AppMethodBeat.m2504i(43380);
        if (c3563c.oYS == 6) {
            C21411f c21411f = (C21411f) c3563c;
            if (c21411f.oZa.tAq == null || c21411f.oZa.tAq.size() <= 0) {
                C28638m.m45531aU(9, C4996ah.getContext().getString(C25738R.string.fut));
            } else {
                Commodity commodity = (Commodity) c21411f.oZa.tAq.get(0);
                C28638m.m45531aU(0, C4996ah.getContext().getString(C25738R.string.fuv, new Object[]{C36391e.m60006e(commodity.kCJ, commodity.pcl)}));
            }
        } else if (c3563c.oYS == 8) {
            C28638m.m45531aU(6, C4996ah.getContext().getString(C25738R.string.fut));
        } else if (c3563c.oYS == 5) {
            C28638m.m45531aU(7, C5046bo.m7532bc(((C21409e) c3563c).oYW, ""));
        } else if (c3563c.oYS == 4) {
            C28638m.m45531aU(8, C4996ah.getContext().getString(C25738R.string.fuu));
        }
        AppMethodBeat.m2505o(43380);
        return false;
    }
}
