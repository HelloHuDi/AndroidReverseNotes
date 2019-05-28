package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.a.b;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bkb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public class PayUMallOrderRecordListUI extends MallOrderRecordListUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void bZf() {
        AppMethodBeat.i(48432);
        nf(1519);
        nf(1544);
        AppMethodBeat.o(48432);
    }

    public final void bZg() {
        AppMethodBeat.i(48433);
        ng(1519);
        ng(1544);
        AppMethodBeat.o(48433);
    }

    public final void fz(String str, String str2) {
        AppMethodBeat.i(48434);
        a(new b(str), true, true);
        AppMethodBeat.o(48434);
    }

    public final void bZh() {
        AppMethodBeat.i(48435);
        a(new a(this.Lp), true, true);
        AppMethodBeat.o(48435);
    }

    public final String AI(int i) {
        AppMethodBeat.i(48436);
        String a = e.a(i, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
        AppMethodBeat.o(48436);
        return a;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48437);
        Iterator it;
        if (mVar instanceof a) {
            if (this.msu != null) {
                this.msu.dismiss();
                this.msu = null;
            }
            a aVar = (a) mVar;
            LinkedList linkedList = ((bjr) aVar.ehh.fsH.fsP).wNb;
            LinkedList linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                bkb bkb = (bkb) it.next();
                i iVar = new i();
                iVar.ncH = bkb.ncH;
                iVar.pde = bkb.pde;
                iVar.pdf = bkb.pdf;
                iVar.pcX = bkb.pcX;
                iVar.pda = bkb.pda;
                iVar.pcW = bkb.pcW;
                iVar.pdd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                iVar.pcZ = bkb.pcZ;
                iVar.pdc = bkb.pdc;
                iVar.pdi = 1;
                iVar.pdh = bkb.pdh;
                iVar.pdg = bkb.pdg;
                iVar.pdb = bkb.pdb;
                iVar.pcV = (double) bkb.wMU;
                iVar.pcY = bkb.pcY;
                iVar.pcU = bkb.pcU;
                linkedList2.add(iVar);
            }
            cw(linkedList2);
            cx(null);
            this.mCount = this.pea.size();
            this.ocG = aVar.cTg() > this.mCount;
            this.pdZ.notifyDataSetChanged();
            ab.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
            ab.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + aVar.cTg());
            ab.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.ocG);
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(48430);
                    if (PayUMallOrderRecordListUI.this.ocG) {
                        ab.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
                        if (!PayUMallOrderRecordListUI.this.pec) {
                            PayUMallOrderRecordListUI.this.emT.dzN();
                            PayUMallOrderRecordListUI.this.emT.setAdapter(PayUMallOrderRecordListUI.this.pdZ);
                            PayUMallOrderRecordListUI.this.pec = true;
                        }
                    } else {
                        ab.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
                        PayUMallOrderRecordListUI.this.emT.dzO();
                    }
                    PayUMallOrderRecordListUI.this.pdZ.notifyDataSetChanged();
                    AppMethodBeat.o(48430);
                }
            });
            this.isLoading = false;
        } else if (mVar instanceof g) {
            if (this.msu != null) {
                this.msu.dismiss();
                this.msu = null;
            }
            g gVar = (g) mVar;
            if (gVar.bZa() == 2) {
                if (this.pea != null) {
                    this.pea.clear();
                }
                this.mCount = 0;
                this.ocG = false;
                this.emT.dzO();
            } else {
                String bZb = gVar.bZb();
                ab.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(bZb)));
                if (!bo.isNullOrNil(bZb)) {
                    for (i iVar2 : this.pea) {
                        if (bZb.equals(iVar2.pcU)) {
                            this.pea.remove(iVar2);
                            this.mCount = this.pea.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(48431);
                    PayUMallOrderRecordListUI.this.pdZ.notifyDataSetChanged();
                    AppMethodBeat.o(48431);
                }
            });
        }
        if (this.mCount > 0 || this.pea.size() != 0) {
            showOptionMenu(true);
            findViewById(R.id.d4z).setVisibility(8);
        } else {
            showOptionMenu(false);
            findViewById(R.id.d4z).setVisibility(0);
        }
        AppMethodBeat.o(48437);
        return true;
    }
}
