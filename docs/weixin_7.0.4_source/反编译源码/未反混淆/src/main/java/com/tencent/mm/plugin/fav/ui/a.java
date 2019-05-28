package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.b.AnonymousClass1;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class a extends c<cl> {
    public a() {
        AppMethodBeat.i(73914);
        this.xxI = cl.class.getName().hashCode();
        AppMethodBeat.o(73914);
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = -2;
        AppMethodBeat.i(73915);
        cl clVar = (cl) bVar;
        if (-2 == clVar.cvA.type) {
            long j = bo.getLong(clVar.cvA.cvq, -1);
            if (0 >= j) {
                ab.w("MicroMsg.Fav.FavAddItemListener", "error fav info local id");
            } else {
                g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
                if (iE == null) {
                    ab.w("MicroMsg.Fav.FavAddItemListener", "error fav info null");
                } else {
                    if (bo.isNullOrNil(iE.field_favProto.hHV)) {
                        h.pYm.e(10873, Integer.valueOf(6));
                    } else {
                        h.pYm.e(10874, Integer.valueOf(6));
                    }
                    iE.field_favProto.alA(clVar.cvA.desc);
                    ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().a(iE, "rowid");
                    String str = clVar.cvA.desc;
                    if (iE == null) {
                        ab.w("MicroMsg.Fav.FavAddItemListener", "modRemark, item info is null");
                    } else if (iE.field_id <= 0) {
                        ab.w("MicroMsg.Fav.FavAddItemListener", "modRemark favid:%d", Integer.valueOf(iE.field_id));
                    } else {
                        j = System.currentTimeMillis();
                        LinkedList linkedList = new LinkedList();
                        bca bca = new bca();
                        bca.wGC = 4;
                        bca.wGD = 0;
                        linkedList.add(bca);
                        LinkedList linkedList2 = new LinkedList();
                        bcd bcd = new bcd();
                        bcd.ncF = "favitem.remark";
                        bcd.pXM = str;
                        linkedList2.add(bcd);
                        bcd bcd2 = new bcd();
                        bcd2.ncF = "favitem.remark";
                        bcd2.wGI = "time";
                        bcd2.pXM = String.valueOf(j);
                        linkedList2.add(bcd2);
                        com.tencent.mm.kernel.g.Rg().a(new al(iE.field_id, linkedList, linkedList2), 0);
                    }
                }
            }
        } else {
            cl.b bVar2 = clVar.cvB;
            if (clVar == null || clVar.cvA == null) {
                i = -1;
            } else {
                int i2;
                if (clVar.cvA.cvC == null) {
                    ab.w("MicroMsg.Fav.FavAddService", "handleEvent error, event is null");
                    if (clVar.cvA.cvG == 0) {
                        clVar.cvA.cvG = R.string.boh;
                    }
                    i2 = clVar.cvA.cvG;
                } else {
                    i2 = 0;
                }
                if (clVar.cvA.activity == null && clVar.cvA.fragment == null) {
                    ab.i("MicroMsg.Fav.FavAddService", "handleEvent context = null && frament = null");
                }
                if (clVar.cvA.cvG > 0) {
                    i = clVar.cvA.cvG;
                } else {
                    if (com.tencent.mm.plugin.fav.a.b.vu(clVar.cvA.type)) {
                        gh ghVar = new gh();
                        ghVar.cAH.type = 36;
                        com.tencent.mm.sdk.b.a.xxA.m(ghVar);
                        if (ghVar.cAI.ret != 1) {
                            i = clVar.cvA.cvG;
                            clVar.cvA.cvI = new AnonymousClass1(clVar);
                        }
                    } else {
                        i = i2;
                    }
                    if (i == 0 && !b.a(clVar)) {
                        i = -10;
                    }
                }
                if (((Integer) com.tencent.mm.kernel.g.RP().Ry().get(225281, Integer.valueOf(0))).intValue() != 1) {
                    ab.i("MicroMsg.Fav.FavAddService", "try show intro ui");
                    com.tencent.mm.plugin.fav.a.b.b(clVar.cvA.activity, ".ui.FavTipsUI", new Intent());
                    com.tencent.mm.kernel.g.RP().Ry().set(225281, Integer.valueOf(1));
                }
                c.a(clVar.cvA.type, i, clVar.cvA.activity, clVar.cvA.fragment, clVar.cvA.cvJ, clVar.cvA.cvI, null);
                ab.i("MicroMsg.Fav.FavAddService", "err Type = %d", Integer.valueOf(i));
                if (i == -9 || i == 0) {
                    i = b.b(clVar);
                }
            }
            bVar2.ret = i;
        }
        AppMethodBeat.o(73915);
        return false;
    }
}
