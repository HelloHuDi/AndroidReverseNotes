package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45316cl.C9307b;
import com.tencent.p177mm.plugin.fav.p407a.C11850al;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C34157b.C341581;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.bca;
import com.tencent.p177mm.protocal.protobuf.bcd;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.ui.a */
public final class C34152a extends C4884c<C45316cl> {
    public C34152a() {
        AppMethodBeat.m2504i(73914);
        this.xxI = C45316cl.class.getName().hashCode();
        AppMethodBeat.m2505o(73914);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        int i = -2;
        AppMethodBeat.m2504i(73915);
        C45316cl c45316cl = (C45316cl) c4883b;
        if (-2 == c45316cl.cvA.type) {
            long j = C5046bo.getLong(c45316cl.cvA.cvq, -1);
            if (0 >= j) {
                C4990ab.m7420w("MicroMsg.Fav.FavAddItemListener", "error fav info local id");
            } else {
                C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(j);
                if (iE == null) {
                    C4990ab.m7420w("MicroMsg.Fav.FavAddItemListener", "error fav info null");
                } else {
                    if (C5046bo.isNullOrNil(iE.field_favProto.hHV)) {
                        C7060h.pYm.mo8381e(10873, Integer.valueOf(6));
                    } else {
                        C7060h.pYm.mo8381e(10874, Integer.valueOf(6));
                    }
                    iE.field_favProto.alA(c45316cl.cvA.desc);
                    ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iE, "rowid");
                    String str = c45316cl.cvA.desc;
                    if (iE == null) {
                        C4990ab.m7420w("MicroMsg.Fav.FavAddItemListener", "modRemark, item info is null");
                    } else if (iE.field_id <= 0) {
                        C4990ab.m7421w("MicroMsg.Fav.FavAddItemListener", "modRemark favid:%d", Integer.valueOf(iE.field_id));
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
                        C1720g.m3540Rg().mo14541a(new C11850al(iE.field_id, linkedList, linkedList2), 0);
                    }
                }
            }
        } else {
            C9307b c9307b = c45316cl.cvB;
            if (c45316cl == null || c45316cl.cvA == null) {
                i = -1;
            } else {
                int i2;
                if (c45316cl.cvA.cvC == null) {
                    C4990ab.m7420w("MicroMsg.Fav.FavAddService", "handleEvent error, event is null");
                    if (c45316cl.cvA.cvG == 0) {
                        c45316cl.cvA.cvG = C25738R.string.boh;
                    }
                    i2 = c45316cl.cvA.cvG;
                } else {
                    i2 = 0;
                }
                if (c45316cl.cvA.activity == null && c45316cl.cvA.fragment == null) {
                    C4990ab.m7416i("MicroMsg.Fav.FavAddService", "handleEvent context = null && frament = null");
                }
                if (c45316cl.cvA.cvG > 0) {
                    i = c45316cl.cvA.cvG;
                } else {
                    if (C39037b.m66420vu(c45316cl.cvA.type)) {
                        C37721gh c37721gh = new C37721gh();
                        c37721gh.cAH.type = 36;
                        C4879a.xxA.mo10055m(c37721gh);
                        if (c37721gh.cAI.ret != 1) {
                            i = c45316cl.cvA.cvG;
                            c45316cl.cvA.cvI = new C341581(c45316cl);
                        }
                    } else {
                        i = i2;
                    }
                    if (i == 0 && !C34157b.m56008a(c45316cl)) {
                        i = -10;
                    }
                }
                if (((Integer) C1720g.m3536RP().mo5239Ry().get(225281, Integer.valueOf(0))).intValue() != 1) {
                    C4990ab.m7416i("MicroMsg.Fav.FavAddService", "try show intro ui");
                    C39037b.m66371b(c45316cl.cvA.activity, ".ui.FavTipsUI", new Intent());
                    C1720g.m3536RP().mo5239Ry().set(225281, Integer.valueOf(1));
                }
                C45932c.m85257a(c45316cl.cvA.type, i, c45316cl.cvA.activity, c45316cl.cvA.fragment, c45316cl.cvA.cvJ, c45316cl.cvA.cvI, null);
                C4990ab.m7417i("MicroMsg.Fav.FavAddService", "err Type = %d", Integer.valueOf(i));
                if (i == -9 || i == 0) {
                    i = C34157b.m56009b(c45316cl);
                }
            }
            c9307b.ret = i;
        }
        AppMethodBeat.m2505o(73915);
        return false;
    }
}
