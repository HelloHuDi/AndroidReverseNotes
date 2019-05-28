package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public final class f {
    private int emC = 3;
    private MMActivity jiE;
    public b kaS;
    public List<com.tencent.mm.plugin.card.model.b> kaW = new ArrayList();
    public com.tencent.mm.plugin.card.model.b kaX;
    private ArrayList<od> kaY;

    public f(MMActivity mMActivity) {
        AppMethodBeat.i(87674);
        this.jiE = mMActivity;
        AppMethodBeat.o(87674);
    }

    public final void a(b bVar, ArrayList<od> arrayList, int i) {
        this.kaS = bVar;
        this.kaY = arrayList;
        this.emC = i;
    }

    public final List<com.tencent.mm.plugin.card.model.b> baw() {
        com.tencent.mm.plugin.card.model.b bVar;
        int i;
        AppMethodBeat.i(87675);
        this.kaW.clear();
        if (!(this.kaS.aZW().vSn == null || bo.isNullOrNil(this.kaS.aZW().vSn.title))) {
            bVar = new com.tencent.mm.plugin.card.model.b();
            bVar.kcg = 1;
            bVar.title = this.kaS.aZW().vSn.title;
            bVar.kfM = "";
            bVar.url = "card://jump_card_gift";
            bVar.kKZ = this.kaS.aZW().vSn.kKZ;
            this.kaW.add(bVar);
        }
        if (this.kaS.aZW().vRW != null && this.kaS.aZW().vRW.size() > 0) {
            List bj = l.bj(this.kaS.aZW().vRW);
            if (bj != null) {
                ((com.tencent.mm.plugin.card.model.b) bj.get(0)).kch = false;
                this.kaW.addAll(bj);
            }
        }
        if (((this.emC == 6 && this.kaS.aZW().vSa <= 0) || l.to(this.emC)) && this.kaS.isNormal() && this.kaS.aZB() && this.kaS.aZJ()) {
            bVar = new com.tencent.mm.plugin.card.model.b();
            bVar.kcg = 1;
            if (!bo.isNullOrNil(this.kaS.aZV().vUI)) {
                bVar.title = this.kaS.aZV().vUI;
            } else if (this.kaS.aZH()) {
                bVar.title = ah.getResources().getString(R.string.ag2);
            } else {
                bVar.title = ah.getContext().getString(R.string.ag1);
            }
            bVar.kfM = "";
            bVar.url = "card://jump_gift";
            this.kaW.add(bVar);
        }
        if (!(this.kaS.aZW().status == 0 || this.kaS.aZW().status == 1)) {
            this.kaS.aZW();
        }
        if (this.emC != 3 && this.emC == 6) {
            this.kaS.aZW();
        }
        wy wyVar = this.kaS.aZV().vUo;
        if (this.kaS.aZW().vSg != null) {
            TextUtils.isEmpty(this.kaS.aZW().vSg.title);
        }
        com.tencent.mm.plugin.card.model.b bVar2 = new com.tencent.mm.plugin.card.model.b();
        if (this.kaS.aZH()) {
            i = 0;
        } else if (wyVar == null || wyVar.wcS == null || wyVar.wcS.size() <= 0 || TextUtils.isEmpty((CharSequence) wyVar.wcS.get(0))) {
            i = 1;
        } else {
            i = 0;
        }
        bVar2.kch = false;
        bVar2.kcg = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTitle());
        stringBuilder.append(getString(R.string.adj));
        bVar2.title = stringBuilder.toString();
        bVar2.kbW = "";
        bVar2.kfM = "";
        bVar2.url = "card://jump_detail";
        if (i != 0) {
            this.kaW.add(bVar2);
        }
        if (!this.kaS.aZF() || this.kaS.aZV().vUa <= 0) {
            od odVar;
            if (!this.kaS.aZD() || this.kaS.aZV().vUa <= 0) {
                if (this.kaS.aZV().vUa > 0) {
                    ab.e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.kaS.aZV().vUa);
                    if (this.kaS.aZV().vUa > 0 && this.kaY != null && this.kaY.size() > 0) {
                        odVar = (od) this.kaY.get(0);
                        if (odVar != null && odVar.qVo < 50000.0f) {
                            bVar2 = new com.tencent.mm.plugin.card.model.b();
                            bVar2.kcg = 2;
                            bVar2.title = odVar.name;
                            bVar2.kbW = this.jiE.getString(R.string.ahn, new Object[]{l.g(this.jiE, odVar.qVo), odVar.fBg});
                            bVar2.kfM = "";
                            bVar2.url = "card://jump_shop";
                            bVar2.kck = odVar.kck;
                            bVar2.color = this.kaS.aZV().color;
                            this.kaW.add(bVar2);
                        } else if (odVar != null) {
                            ab.e("MicroMsg.CardDetailDataMgr", "distance:" + odVar.qVo);
                        }
                    }
                }
            }
            if (this.kaS.aZV().vUa > 0 && this.kaY == null) {
                bVar = new com.tencent.mm.plugin.card.model.b();
                bVar.kcg = 1;
                if (TextUtils.isEmpty(this.kaS.aZV().vUz)) {
                    bVar.title = getString(R.string.acr);
                } else {
                    bVar.title = this.kaS.aZV().vUz;
                }
                bVar.kbW = "";
                bVar.kfM = "";
                bVar.url = "card://jump_shop_list";
                this.kaW.add(bVar);
            } else if (this.kaS.aZV().vUa > 0 && this.kaY != null && this.kaY.size() > 0) {
                bVar2 = new com.tencent.mm.plugin.card.model.b();
                bVar2.kcg = 1;
                odVar = (od) this.kaY.get(0);
                if (!TextUtils.isEmpty(this.kaS.aZV().vUz)) {
                    bVar2.title = this.kaS.aZV().vUz;
                } else if (this.kaS.aZD() || odVar.qVo >= 5000.0f) {
                    bVar2.title = getString(R.string.acr);
                } else if (this.kaS.aZV().vUa == 1 || this.kaY.size() == 1) {
                    ab.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
                } else {
                    bVar2.title = getString(R.string.acy);
                }
                if (!this.kaS.aZD() || odVar.qVo >= 2000.0f) {
                    bVar2.kbW = "";
                } else if (this.kaS.aZV().vUa > 1 || (this.kaY != null && this.kaY.size() > 1)) {
                    bVar2.kbW = this.jiE.getString(R.string.afx, new Object[]{l.g(this.jiE, odVar.qVo)});
                } else {
                    bVar2.kbW = l.g(this.jiE, odVar.qVo);
                }
                bVar2.kfM = "";
                bVar2.url = "card://jump_shop_list";
                this.kaW.add(bVar2);
            }
        }
        if (!((this.kaS.aZH() && this.kaS.aZW().status == 3) || TextUtils.isEmpty(this.kaS.aZV().vTT))) {
            this.kaW.add(baz());
        }
        List list = this.kaW;
        AppMethodBeat.o(87675);
        return list;
    }

    private boolean bax() {
        AppMethodBeat.i(87676);
        if (l.tm(this.emC) || l.tn(this.emC) || this.emC == 23) {
            if (!(!this.kaS.isAcceptable() || this.kaS.aZV().vUq == null || TextUtils.isEmpty(this.kaS.aZV().vUq.text) || TextUtils.isEmpty(this.kaS.aZV().vTT))) {
                AppMethodBeat.o(87676);
                return true;
            }
        } else if (!(this.emC != 6 || !this.kaS.aZS() || this.kaS.aZV().vUq == null || TextUtils.isEmpty(this.kaS.aZV().vUq.text) || TextUtils.isEmpty(this.kaS.aZV().vTT))) {
            AppMethodBeat.o(87676);
            return true;
        }
        AppMethodBeat.o(87676);
        return false;
    }

    public final boolean bay() {
        if (this.kaX == null) {
            return false;
        }
        return this.kaX.kcj;
    }

    public final com.tencent.mm.plugin.card.model.b baz() {
        AppMethodBeat.i(87677);
        com.tencent.mm.plugin.card.model.b bVar = new com.tencent.mm.plugin.card.model.b();
        bVar.kcg = 1;
        bVar.kci = bax();
        if (!bVar.kci && !TextUtils.isEmpty(this.kaS.aZV().vUj)) {
            bVar.title = this.kaS.aZV().vUj;
        } else if (t.mY(this.kaS.aZV().vTT)) {
            bVar.title = getString(R.string.ag0);
            bVar.kci = false;
        } else {
            bVar.title = getString(R.string.afz);
            if (this.kaS.aZV().vUq == null || this.kaS.aZV().vUq.wkd != 1) {
                bVar.kcj = false;
            } else {
                bVar.kcj = true;
            }
        }
        if (!TextUtils.isEmpty(this.kaS.aZV().vUl)) {
            bVar.kbW = this.kaS.aZV().vUl;
        }
        bVar.kfM = "";
        bVar.url = "card://jump_service";
        this.kaX = bVar;
        bVar = this.kaX;
        AppMethodBeat.o(87677);
        return bVar;
    }

    public final String getTitle() {
        AppMethodBeat.i(87678);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.kaS.aZV().kdf)) {
            stringBuilder.append(this.kaS.aZV().kdf);
        } else if (this.kaS.aZD()) {
            stringBuilder.append(getString(R.string.afv));
        } else if (this.kaS.aZE()) {
            stringBuilder.append(getString(R.string.ade));
        } else if (this.kaS.aZF()) {
            stringBuilder.append(getString(R.string.acw));
        } else if (this.kaS.aZG()) {
            stringBuilder.append(getString(R.string.ado));
        } else if (this.kaS.aZH()) {
            stringBuilder.append(getString(R.string.af1));
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(87678);
        return stringBuilder2;
    }

    private String getString(int i) {
        AppMethodBeat.i(87679);
        String string = this.jiE.getString(i);
        AppMethodBeat.o(87679);
        return string;
    }
}
