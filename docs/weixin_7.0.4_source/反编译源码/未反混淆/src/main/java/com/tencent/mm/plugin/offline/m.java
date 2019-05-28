package com.tencent.mm.plugin.offline;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.io.ByteArrayOutputStream;

public final class m implements a {
    c nZv = new c<vg>() {
        {
            AppMethodBeat.i(43376);
            this.xxI = vg.class.getName().hashCode();
            AppMethodBeat.o(43376);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(43377);
            vg vgVar = (vg) bVar;
            if (vgVar instanceof vg) {
                switch (vgVar.cSe.action) {
                    case 3:
                        if (!((com.tencent.mm.plugin.walletlock.a.b) g.K(com.tencent.mm.plugin.walletlock.a.b.class)).cTj()) {
                            if (!r.cPI().cQl()) {
                                if (!r.cPI().cQi()) {
                                    if (!r.cPI().cQg() || !com.tencent.mm.plugin.offline.c.a.bYd()) {
                                        if (!r.cPI().cQg() || com.tencent.mm.plugin.offline.c.a.bYd()) {
                                            if (r.cPI().cQh()) {
                                                vgVar.cSf.cSg = 3;
                                                break;
                                            }
                                        }
                                        vgVar.cSf.cSg = 4;
                                        break;
                                    }
                                    k.bXg();
                                    e bXi = k.bXi();
                                    ab.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", Integer.valueOf(9), Integer.valueOf(0), bo.dpG().toString());
                                    String r = bXi.r(9, 0, "");
                                    Bitmap b = com.tencent.mm.bw.a.a.b(ah.getContext(), r, 5, 0);
                                    Bitmap b2 = com.tencent.mm.bw.a.a.b(ah.getContext(), r, 12, 3);
                                    vgVar.cSf.cSg = 1;
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                    vgVar.cSf.cSk = byteArrayOutputStream.toByteArray();
                                    byteArrayOutputStream.reset();
                                    b2.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                    vgVar.cSf.cSl = byteArrayOutputStream.toByteArray();
                                    vgVar.cSf.cSm = e.atx(r);
                                    if (com.tencent.mm.plugin.offline.c.a.bYf() == null) {
                                        ab.i("MicroMsg.Wear.WearOfflineLogic", "get payway fail");
                                        break;
                                    }
                                    vgVar.cSf.cSn = ah.getContext().getString(R.string.fv8, new Object[]{r0.field_desc});
                                    ab.i("MicroMsg.Wear.WearOfflineLogic", "payway %s", vgVar.cSf.cSn);
                                    break;
                                }
                                vgVar.cSf.cSg = 3;
                                break;
                            }
                            vgVar.cSf.cSg = 2;
                            break;
                        }
                        vgVar.cSf.cSg = 5;
                        break;
                        break;
                }
            }
            AppMethodBeat.o(43377);
            return false;
        }
    };

    public m() {
        AppMethodBeat.i(43378);
        com.tencent.mm.sdk.b.a.xxA.c(this.nZv);
        k.bXg();
        k.bXh().a(this);
        AppMethodBeat.o(43378);
    }

    private static void aU(int i, String str) {
        AppMethodBeat.i(43379);
        vg vgVar = new vg();
        vgVar.cSe.cSg = i;
        vgVar.cSe.action = 4;
        vgVar.cSe.content = str;
        com.tencent.mm.sdk.b.a.xxA.m(vgVar);
        AppMethodBeat.o(43379);
    }

    public final boolean a(s.c cVar) {
        AppMethodBeat.i(43380);
        if (cVar.oYS == 6) {
            f fVar = (f) cVar;
            if (fVar.oZa.tAq == null || fVar.oZa.tAq.size() <= 0) {
                aU(9, ah.getContext().getString(R.string.fut));
            } else {
                Commodity commodity = (Commodity) fVar.oZa.tAq.get(0);
                aU(0, ah.getContext().getString(R.string.fuv, new Object[]{e.e(commodity.kCJ, commodity.pcl)}));
            }
        } else if (cVar.oYS == 8) {
            aU(6, ah.getContext().getString(R.string.fut));
        } else if (cVar.oYS == 5) {
            aU(7, bo.bc(((s.e) cVar).oYW, ""));
        } else if (cVar.oYS == 4) {
            aU(8, ah.getContext().getString(R.string.fuu));
        }
        AppMethodBeat.o(43380);
        return false;
    }
}
