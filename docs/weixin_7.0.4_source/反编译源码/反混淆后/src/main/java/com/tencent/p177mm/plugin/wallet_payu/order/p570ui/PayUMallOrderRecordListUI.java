package com.tencent.p177mm.plugin.wallet_payu.order.p570ui;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.order.model.C43362g;
import com.tencent.p177mm.plugin.order.model.C43364i;
import com.tencent.p177mm.plugin.order.p480ui.MallOrderRecordListUI;
import com.tencent.p177mm.plugin.wallet_payu.order.p1318a.C22698a;
import com.tencent.p177mm.plugin.wallet_payu.order.p1318a.C36855b;
import com.tencent.p177mm.protocal.protobuf.bjr;
import com.tencent.p177mm.protocal.protobuf.bkb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI */
public class PayUMallOrderRecordListUI extends MallOrderRecordListUI {

    /* renamed from: com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI$1 */
    class C143651 implements Runnable {
        C143651() {
        }

        public final void run() {
            AppMethodBeat.m2504i(48430);
            if (PayUMallOrderRecordListUI.this.ocG) {
                C4990ab.m7418v("MicroMsg.PayUMallOrderRecordListUI", "has more");
                if (!PayUMallOrderRecordListUI.this.pec) {
                    PayUMallOrderRecordListUI.this.emT.dzN();
                    PayUMallOrderRecordListUI.this.emT.setAdapter(PayUMallOrderRecordListUI.this.pdZ);
                    PayUMallOrderRecordListUI.this.pec = true;
                }
            } else {
                C4990ab.m7418v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
                PayUMallOrderRecordListUI.this.emT.dzO();
            }
            PayUMallOrderRecordListUI.this.pdZ.notifyDataSetChanged();
            AppMethodBeat.m2505o(48430);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI$2 */
    class C226992 implements Runnable {
        C226992() {
        }

        public final void run() {
            AppMethodBeat.m2504i(48431);
            PayUMallOrderRecordListUI.this.pdZ.notifyDataSetChanged();
            AppMethodBeat.m2505o(48431);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void bZf() {
        AppMethodBeat.m2504i(48432);
        mo39992nf(1519);
        mo39992nf(1544);
        AppMethodBeat.m2505o(48432);
    }

    public final void bZg() {
        AppMethodBeat.m2504i(48433);
        mo39993ng(1519);
        mo39993ng(1544);
        AppMethodBeat.m2505o(48433);
    }

    /* renamed from: fz */
    public final void mo8163fz(String str, String str2) {
        AppMethodBeat.m2504i(48434);
        mo39970a(new C36855b(str), true, true);
        AppMethodBeat.m2505o(48434);
    }

    public final void bZh() {
        AppMethodBeat.m2504i(48435);
        mo39970a(new C22698a(this.f1276Lp), true, true);
        AppMethodBeat.m2505o(48435);
    }

    /* renamed from: AI */
    public final String mo8157AI(int i) {
        AppMethodBeat.m2504i(48436);
        String a = C36391e.m59980a(i, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
        AppMethodBeat.m2505o(48436);
        return a;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48437);
        Iterator it;
        if (c1207m instanceof C22698a) {
            if (this.msu != null) {
                this.msu.dismiss();
                this.msu = null;
            }
            C22698a c22698a = (C22698a) c1207m;
            LinkedList linkedList = ((bjr) c22698a.ehh.fsH.fsP).wNb;
            LinkedList linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                bkb bkb = (bkb) it.next();
                C43364i c43364i = new C43364i();
                c43364i.ncH = bkb.ncH;
                c43364i.pde = bkb.pde;
                c43364i.pdf = bkb.pdf;
                c43364i.pcX = bkb.pcX;
                c43364i.pda = bkb.pda;
                c43364i.pcW = bkb.pcW;
                c43364i.pdd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                c43364i.pcZ = bkb.pcZ;
                c43364i.pdc = bkb.pdc;
                c43364i.pdi = 1;
                c43364i.pdh = bkb.pdh;
                c43364i.pdg = bkb.pdg;
                c43364i.pdb = bkb.pdb;
                c43364i.pcV = (double) bkb.wMU;
                c43364i.pcY = bkb.pcY;
                c43364i.pcU = bkb.pcU;
                linkedList2.add(c43364i);
            }
            mo8161cw(linkedList2);
            mo8162cx(null);
            this.mCount = this.pea.size();
            this.ocG = c22698a.cTg() > this.mCount;
            this.pdZ.notifyDataSetChanged();
            C4990ab.m7410d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
            C4990ab.m7410d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + c22698a.cTg());
            C4990ab.m7410d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.ocG);
            this.mHandler.post(new C143651());
            this.isLoading = false;
        } else if (c1207m instanceof C43362g) {
            if (this.msu != null) {
                this.msu.dismiss();
                this.msu = null;
            }
            C43362g c43362g = (C43362g) c1207m;
            if (c43362g.bZa() == 2) {
                if (this.pea != null) {
                    this.pea.clear();
                }
                this.mCount = 0;
                this.ocG = false;
                this.emT.dzO();
            } else {
                String bZb = c43362g.bZb();
                C4990ab.m7410d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(bZb)));
                if (!C5046bo.isNullOrNil(bZb)) {
                    for (C43364i c43364i2 : this.pea) {
                        if (bZb.equals(c43364i2.pcU)) {
                            this.pea.remove(c43364i2);
                            this.mCount = this.pea.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new C226992());
        }
        if (this.mCount > 0 || this.pea.size() != 0) {
            showOptionMenu(true);
            findViewById(2131825833).setVisibility(8);
        } else {
            showOptionMenu(false);
            findViewById(2131825833).setVisibility(0);
        }
        AppMethodBeat.m2505o(48437);
        return true;
    }
}
