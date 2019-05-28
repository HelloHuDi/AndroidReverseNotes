package com.tencent.p177mm.plugin.card.p352b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C11286b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.protocal.protobuf.C15395wy;
import com.tencent.p177mm.protocal.protobuf.C23422od;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.b.f */
public final class C38728f {
    private int emC = 3;
    private MMActivity jiE;
    public C42837b kaS;
    public List<C11286b> kaW = new ArrayList();
    public C11286b kaX;
    private ArrayList<C23422od> kaY;

    public C38728f(MMActivity mMActivity) {
        AppMethodBeat.m2504i(87674);
        this.jiE = mMActivity;
        AppMethodBeat.m2505o(87674);
    }

    /* renamed from: a */
    public final void mo61605a(C42837b c42837b, ArrayList<C23422od> arrayList, int i) {
        this.kaS = c42837b;
        this.kaY = arrayList;
        this.emC = i;
    }

    public final List<C11286b> baw() {
        C11286b c11286b;
        int i;
        AppMethodBeat.m2504i(87675);
        this.kaW.clear();
        if (!(this.kaS.aZW().vSn == null || C5046bo.isNullOrNil(this.kaS.aZW().vSn.title))) {
            c11286b = new C11286b();
            c11286b.kcg = 1;
            c11286b.title = this.kaS.aZW().vSn.title;
            c11286b.kfM = "";
            c11286b.url = "card://jump_card_gift";
            c11286b.kKZ = this.kaS.aZW().vSn.kKZ;
            this.kaW.add(c11286b);
        }
        if (this.kaS.aZW().vRW != null && this.kaS.aZW().vRW.size() > 0) {
            List bj = C38736l.m65722bj(this.kaS.aZW().vRW);
            if (bj != null) {
                ((C11286b) bj.get(0)).kch = false;
                this.kaW.addAll(bj);
            }
        }
        if (((this.emC == 6 && this.kaS.aZW().vSa <= 0) || C38736l.m65736to(this.emC)) && this.kaS.isNormal() && this.kaS.aZB() && this.kaS.aZJ()) {
            c11286b = new C11286b();
            c11286b.kcg = 1;
            if (!C5046bo.isNullOrNil(this.kaS.aZV().vUI)) {
                c11286b.title = this.kaS.aZV().vUI;
            } else if (this.kaS.aZH()) {
                c11286b.title = C4996ah.getResources().getString(C25738R.string.ag2);
            } else {
                c11286b.title = C4996ah.getContext().getString(C25738R.string.ag1);
            }
            c11286b.kfM = "";
            c11286b.url = "card://jump_gift";
            this.kaW.add(c11286b);
        }
        if (!(this.kaS.aZW().status == 0 || this.kaS.aZW().status == 1)) {
            this.kaS.aZW();
        }
        if (this.emC != 3 && this.emC == 6) {
            this.kaS.aZW();
        }
        C15395wy c15395wy = this.kaS.aZV().vUo;
        if (this.kaS.aZW().vSg != null) {
            TextUtils.isEmpty(this.kaS.aZW().vSg.title);
        }
        C11286b c11286b2 = new C11286b();
        if (this.kaS.aZH()) {
            i = 0;
        } else if (c15395wy == null || c15395wy.wcS == null || c15395wy.wcS.size() <= 0 || TextUtils.isEmpty((CharSequence) c15395wy.wcS.get(0))) {
            i = 1;
        } else {
            i = 0;
        }
        c11286b2.kch = false;
        c11286b2.kcg = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTitle());
        stringBuilder.append(getString(C25738R.string.adj));
        c11286b2.title = stringBuilder.toString();
        c11286b2.kbW = "";
        c11286b2.kfM = "";
        c11286b2.url = "card://jump_detail";
        if (i != 0) {
            this.kaW.add(c11286b2);
        }
        if (!this.kaS.aZF() || this.kaS.aZV().vUa <= 0) {
            C23422od c23422od;
            if (!this.kaS.aZD() || this.kaS.aZV().vUa <= 0) {
                if (this.kaS.aZV().vUa > 0) {
                    C4990ab.m7412e("MicroMsg.CardDetailDataMgr", "shop_count:" + this.kaS.aZV().vUa);
                    if (this.kaS.aZV().vUa > 0 && this.kaY != null && this.kaY.size() > 0) {
                        c23422od = (C23422od) this.kaY.get(0);
                        if (c23422od != null && c23422od.qVo < 50000.0f) {
                            c11286b2 = new C11286b();
                            c11286b2.kcg = 2;
                            c11286b2.title = c23422od.name;
                            c11286b2.kbW = this.jiE.getString(C25738R.string.ahn, new Object[]{C38736l.m65730g(this.jiE, c23422od.qVo), c23422od.fBg});
                            c11286b2.kfM = "";
                            c11286b2.url = "card://jump_shop";
                            c11286b2.kck = c23422od.kck;
                            c11286b2.color = this.kaS.aZV().color;
                            this.kaW.add(c11286b2);
                        } else if (c23422od != null) {
                            C4990ab.m7412e("MicroMsg.CardDetailDataMgr", "distance:" + c23422od.qVo);
                        }
                    }
                }
            }
            if (this.kaS.aZV().vUa > 0 && this.kaY == null) {
                c11286b = new C11286b();
                c11286b.kcg = 1;
                if (TextUtils.isEmpty(this.kaS.aZV().vUz)) {
                    c11286b.title = getString(C25738R.string.acr);
                } else {
                    c11286b.title = this.kaS.aZV().vUz;
                }
                c11286b.kbW = "";
                c11286b.kfM = "";
                c11286b.url = "card://jump_shop_list";
                this.kaW.add(c11286b);
            } else if (this.kaS.aZV().vUa > 0 && this.kaY != null && this.kaY.size() > 0) {
                c11286b2 = new C11286b();
                c11286b2.kcg = 1;
                c23422od = (C23422od) this.kaY.get(0);
                if (!TextUtils.isEmpty(this.kaS.aZV().vUz)) {
                    c11286b2.title = this.kaS.aZV().vUz;
                } else if (this.kaS.aZD() || c23422od.qVo >= 5000.0f) {
                    c11286b2.title = getString(C25738R.string.acr);
                } else if (this.kaS.aZV().vUa == 1 || this.kaY.size() == 1) {
                    C4990ab.m7416i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
                } else {
                    c11286b2.title = getString(C25738R.string.acy);
                }
                if (!this.kaS.aZD() || c23422od.qVo >= 2000.0f) {
                    c11286b2.kbW = "";
                } else if (this.kaS.aZV().vUa > 1 || (this.kaY != null && this.kaY.size() > 1)) {
                    c11286b2.kbW = this.jiE.getString(C25738R.string.afx, new Object[]{C38736l.m65730g(this.jiE, c23422od.qVo)});
                } else {
                    c11286b2.kbW = C38736l.m65730g(this.jiE, c23422od.qVo);
                }
                c11286b2.kfM = "";
                c11286b2.url = "card://jump_shop_list";
                this.kaW.add(c11286b2);
            }
        }
        if (!((this.kaS.aZH() && this.kaS.aZW().status == 3) || TextUtils.isEmpty(this.kaS.aZV().vTT))) {
            this.kaW.add(baz());
        }
        List list = this.kaW;
        AppMethodBeat.m2505o(87675);
        return list;
    }

    private boolean bax() {
        AppMethodBeat.m2504i(87676);
        if (C38736l.m65734tm(this.emC) || C38736l.m65735tn(this.emC) || this.emC == 23) {
            if (!(!this.kaS.isAcceptable() || this.kaS.aZV().vUq == null || TextUtils.isEmpty(this.kaS.aZV().vUq.text) || TextUtils.isEmpty(this.kaS.aZV().vTT))) {
                AppMethodBeat.m2505o(87676);
                return true;
            }
        } else if (!(this.emC != 6 || !this.kaS.aZS() || this.kaS.aZV().vUq == null || TextUtils.isEmpty(this.kaS.aZV().vUq.text) || TextUtils.isEmpty(this.kaS.aZV().vTT))) {
            AppMethodBeat.m2505o(87676);
            return true;
        }
        AppMethodBeat.m2505o(87676);
        return false;
    }

    public final boolean bay() {
        if (this.kaX == null) {
            return false;
        }
        return this.kaX.kcj;
    }

    public final C11286b baz() {
        AppMethodBeat.m2504i(87677);
        C11286b c11286b = new C11286b();
        c11286b.kcg = 1;
        c11286b.kci = bax();
        if (!c11286b.kci && !TextUtils.isEmpty(this.kaS.aZV().vUj)) {
            c11286b.title = this.kaS.aZV().vUj;
        } else if (C1855t.m3912mY(this.kaS.aZV().vTT)) {
            c11286b.title = getString(C25738R.string.ag0);
            c11286b.kci = false;
        } else {
            c11286b.title = getString(C25738R.string.afz);
            if (this.kaS.aZV().vUq == null || this.kaS.aZV().vUq.wkd != 1) {
                c11286b.kcj = false;
            } else {
                c11286b.kcj = true;
            }
        }
        if (!TextUtils.isEmpty(this.kaS.aZV().vUl)) {
            c11286b.kbW = this.kaS.aZV().vUl;
        }
        c11286b.kfM = "";
        c11286b.url = "card://jump_service";
        this.kaX = c11286b;
        c11286b = this.kaX;
        AppMethodBeat.m2505o(87677);
        return c11286b;
    }

    public final String getTitle() {
        AppMethodBeat.m2504i(87678);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.kaS.aZV().kdf)) {
            stringBuilder.append(this.kaS.aZV().kdf);
        } else if (this.kaS.aZD()) {
            stringBuilder.append(getString(C25738R.string.afv));
        } else if (this.kaS.aZE()) {
            stringBuilder.append(getString(C25738R.string.ade));
        } else if (this.kaS.aZF()) {
            stringBuilder.append(getString(C25738R.string.acw));
        } else if (this.kaS.aZG()) {
            stringBuilder.append(getString(C25738R.string.ado));
        } else if (this.kaS.aZH()) {
            stringBuilder.append(getString(C25738R.string.af1));
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(87678);
        return stringBuilder2;
    }

    private String getString(int i) {
        AppMethodBeat.m2504i(87679);
        String string = this.jiE.getString(i);
        AppMethodBeat.m2505o(87679);
        return string;
    }
}
