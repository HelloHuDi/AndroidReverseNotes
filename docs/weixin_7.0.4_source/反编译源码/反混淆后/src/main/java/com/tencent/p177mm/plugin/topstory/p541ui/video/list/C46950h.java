package com.tencent.p177mm.plugin.topstory.p541ui.video.list;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C35305f;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46927h;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.bzs;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.UUID;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.h */
public final class C46950h extends C46927h implements C29455a {
    public View jNV;
    public MMNeat7extView jXy;
    public View ltW;
    public TextView mLM;
    public TextView mLN;
    public TextView qeX;
    public ImageView sDW;
    public View sFZ;
    public C35305f sGZ;
    public TextView sGc;
    public View sGg;
    public TextView sGh;
    public View sGi;
    public View sGj;
    public ImageView sGk;
    public ImageView sGl;
    public View sGm;
    public FrameLayout sGr;
    public View sHa;
    public ImageView sHb;
    public View sHc;
    public View sHd;
    public View sHe;
    private boolean sHf;

    public C46950h(View view, C13969b c13969b, boolean z) {
        super(view, c13969b);
        this.sHf = z;
    }

    /* renamed from: ej */
    public final void mo47705ej(View view) {
        AppMethodBeat.m2504i(2087);
        super.mo47705ej(view);
        this.sGr = (FrameLayout) view.findViewById(2131828298);
        this.sDW = (ImageView) view.findViewById(2131828267);
        this.qeX = (TextView) view.findViewById(2131821512);
        this.jXy = (MMNeat7extView) view.findViewById(2131821185);
        this.sGm = view.findViewById(2131828268);
        this.ltW = view.findViewById(2131828270);
        this.sHa = view.findViewById(2131828271);
        this.sHb = (ImageView) view.findViewById(2131828272);
        this.sGc = (TextView) view.findViewById(2131828273);
        this.sFZ = view.findViewById(2131828269);
        this.sGg = view.findViewById(2131828275);
        this.sGh = (TextView) view.findViewById(2131828282);
        this.sGi = view.findViewById(2131828276);
        this.sGj = view.findViewById(2131828279);
        this.mLM = (TextView) view.findViewById(2131828278);
        this.mLN = (TextView) view.findViewById(2131828281);
        this.sGk = (ImageView) view.findViewById(2131828277);
        this.sGl = (ImageView) view.findViewById(2131828280);
        this.sHc = view.findViewById(2131828336);
        this.sHd = view.findViewById(2131828335);
        this.sHe = view.findViewById(2131828337);
        this.jNV = view.findViewById(2131824237);
        if (this.sHf) {
            this.sGg.setVisibility(0);
            AppMethodBeat.m2505o(2087);
            return;
        }
        this.sGg.setVisibility(8);
        AppMethodBeat.m2505o(2087);
    }

    public final void cHj() {
        AppMethodBeat.m2504i(2088);
        C4990ab.m7411d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", Integer.valueOf(hashCode()));
        this.sHe.animate().cancel();
        this.sHd.animate().cancel();
        this.sHc.animate().cancel();
        this.sHc.setAlpha(0.8f);
        this.sHe.setAlpha(0.8f);
        this.sHd.setAlpha(0.8f);
        AppMethodBeat.m2505o(2088);
    }

    public final void cHk() {
        AppMethodBeat.m2504i(2089);
        C4990ab.m7411d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", Integer.valueOf(hashCode()));
        this.sHe.animate().cancel();
        this.sHd.animate().cancel();
        this.sHc.animate().cancel();
        this.sHc.setAlpha(0.0f);
        this.sHe.setAlpha(0.0f);
        this.sHd.setAlpha(0.0f);
        AppMethodBeat.m2505o(2089);
    }

    public final void cFO() {
        AppMethodBeat.m2504i(2090);
        super.cFO();
        this.sHe.animate().cancel();
        this.sHd.animate().cancel();
        this.sHe.setAlpha(0.0f);
        this.sHd.setAlpha(0.0f);
        AppMethodBeat.m2505o(2090);
    }

    public final void cFN() {
        AppMethodBeat.m2504i(2091);
        super.cFN();
        AppMethodBeat.m2505o(2091);
    }

    public final boolean cGy() {
        AppMethodBeat.m2504i(2092);
        if (this.sHe.getAlpha() == 0.0f || this.sHd.getAlpha() == 0.0f) {
            AppMethodBeat.m2505o(2092);
            return false;
        }
        AppMethodBeat.m2505o(2092);
        return true;
    }

    /* renamed from: mc */
    public final void mo47707mc(boolean z) {
        AppMethodBeat.m2504i(2093);
        super.mo47707mc(z);
        cHk();
        this.sDN.mo9158FD(cFP());
        if (this.sGZ.mo56045O(z, false)) {
            cFO();
            super.cFN();
        }
        AppMethodBeat.m2505o(2093);
    }

    public final void cGz() {
        AppMethodBeat.m2504i(2094);
        if (C5046bo.isNullOrNil(this.sAX.title)) {
            this.jXy.setVisibility(8);
        } else {
            this.jXy.mo15921ah(this.sAX.title);
            this.jXy.setVisibility(0);
            this.jXy.requestLayout();
        }
        this.jXy.setOnClickListener(this.pLd);
        this.qeX.setText(this.sAX.source);
        if (C5046bo.isNullOrNil(this.sAX.phw)) {
            this.sGm.setVisibility(8);
        } else {
            this.sGm.setVisibility(0);
        }
        this.sDW.setOnClickListener(this.pLd);
        this.qeX.setOnClickListener(this.pLd);
        this.sGm.setOnClickListener(this.pLd);
        if (C5046bo.isNullOrNil(this.sAX.xgY)) {
            this.sDW.setImageResource(C25738R.drawable.ad2);
        } else {
            C32291o.ahp().mo43766a(this.sAX.xgY, this.sDW, C4210c.sBm);
        }
        if (this.sDN.cFZ()) {
            this.ltW.setVisibility(0);
            this.ltW.setOnClickListener(this.pLd);
        } else {
            this.ltW.setVisibility(8);
        }
        this.sFZ.setTag(this.sAX);
        this.sFZ.setOnClickListener(this.pLd);
        if (C5046bo.m7548ek(this.sAX.xhc)) {
            this.sFZ.setVisibility(8);
        } else {
            this.sFZ.setVisibility(0);
        }
        this.jNV.setOnClickListener(this.pLd);
        this.sHc.setVisibility(0);
        this.sHd.setVisibility(0);
        this.sHe.setVisibility(0);
        if (this.sGZ == null) {
            this.sGZ = new C46310f(this.sDN.bKU(), this.sDN, this);
            this.sGr.removeAllViews();
            FrameLayout frameLayout = this.sGr;
            C35305f c35305f = this.sGZ;
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", Integer.valueOf(this.sDN.getVideoWidth()), Integer.valueOf(this.sDN.getVideoHeight()));
            frameLayout.addView(c35305f, new LayoutParams(this.sDN.getVideoWidth(), this.sDN.getVideoHeight()));
        }
        this.sGZ.mo56046a(this.sAX, cFP());
        if (this.sDN.cFY() == cFP()) {
            super.cFN();
        }
        this.sGh.setText(this.sAX.qVw);
        if (!this.sHf || this.sAX.wiH.size() <= 0) {
            this.sGg.setVisibility(8);
        } else {
            this.sGg.setVisibility(0);
            bzs bzs = (bzs) this.sAX.wiH.get(0);
            this.mLM.setTag(bzs);
            this.mLM.setText(bzs.cEh);
            this.mLM.setVisibility(0);
            this.mLM.setOnClickListener(this.pLd);
            this.sGi.setVisibility(0);
            this.sGk.setVisibility(8);
            if (!C5046bo.isNullOrNil(bzs.cIY)) {
                C32291o.ahp().mo43766a(bzs.cIY, this.sGk, C4210c.sBn);
                this.sGk.setVisibility(0);
            }
            if (this.sAX.wiH.size() > 1) {
                bzs = (bzs) this.sAX.wiH.get(1);
                this.mLN.setTag(bzs);
                this.mLN.setText(bzs.cEh);
                this.mLN.setOnClickListener(this.pLd);
                this.mLN.setVisibility(0);
                this.sGj.setVisibility(0);
                this.sGl.setVisibility(8);
                if (!C5046bo.isNullOrNil(bzs.cIY)) {
                    C32291o.ahp().mo43766a(bzs.cIY, this.sGl, C4210c.sBn);
                    this.sGl.setVisibility(0);
                }
            } else {
                this.sGj.setVisibility(8);
                this.mLN.setVisibility(8);
            }
        }
        if (this.sDN.cFY() != cFP()) {
            cHj();
        }
        if ((this.sAX.xhd & 128) > 0) {
            this.sHa.setVisibility(0);
            this.sHa.setOnClickListener(this.pLd);
            if (this.sAX.xhh) {
                this.sHb.setImageResource(C1318a.top_story_wow_selected);
                this.sGc.setTextColor(this.sGc.getResources().getColor(C25738R.color.a3n));
                AppMethodBeat.m2505o(2094);
                return;
            }
            this.sHb.setImageResource(C1318a.top_story_wow_unselected);
            this.sGc.setTextColor(this.sGc.getResources().getColor(C25738R.color.a69));
            AppMethodBeat.m2505o(2094);
            return;
        }
        this.sHa.setVisibility(8);
        AppMethodBeat.m2505o(2094);
    }

    public final C35305f cGA() {
        return this.sGZ;
    }

    /* renamed from: ek */
    public final void mo76166ek(View view) {
        AppMethodBeat.m2504i(2095);
        if (C39964g.cFm() && view.getId() == this.jXy.getId()) {
            this.sDN.cFV().sFy = true;
        }
        super.mo76166ek(view);
        AppMethodBeat.m2505o(2095);
    }

    /* renamed from: el */
    public final void mo76167el(View view) {
        int i = 1;
        AppMethodBeat.m2504i(2096);
        if (view.getId() == this.jXy.getId()) {
            if (!(this.sAX == null || C5046bo.isNullOrNil(this.sAX.uaj))) {
                String str = this.sAX.uaj;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                C25985d.m41467b(this.sDN.bKU(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                if (this.sDN.cFV().sFw) {
                    this.sGZ.cGw();
                    this.sDN.cFV().cpN();
                }
                this.sDN.cFR().mo74507f(this.sAX);
                ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(this.sDN.cFT(), this.sAX, cFP(), 1, "");
                AppMethodBeat.m2505o(2096);
                return;
            }
        } else if (view.getId() == this.ltW.getId()) {
            C14419a.m22633kT(8);
            mo76163a(this.sDN, this.sDN.bKU(), this.sGZ, cFP());
            AppMethodBeat.m2505o(2096);
            return;
        } else if (view.getId() == this.sFZ.getId()) {
            this.sDN.mo9164ad(this.sFZ, cFP());
            AppMethodBeat.m2505o(2096);
            return;
        } else if (view.getId() == this.mLM.getId() || view.getId() == this.mLN.getId()) {
            C23447tn c23447tn;
            this.sDN.cFQ().sEM = true;
            this.sDN.cFV().stopPlay();
            this.sGZ.cGq();
            bzs bzs = (bzs) view.getTag();
            chv a = C39964g.m68428a(this.sDN.cFT());
            a.xgj = UUID.randomUUID().toString();
            a.xgC = this.sAX.xgS;
            a.xgG = bzs.wYN;
            a.xgH = null;
            a.xgI = bzs;
            a.eif = this.sDN.mo9156DX();
            a.xgJ = this.sDN.cFQ().sEM;
            Iterator it = a.tZG.iterator();
            while (it.hasNext()) {
                c23447tn = (C23447tn) it.next();
                if ("show_tag_list".equals(c23447tn.key)) {
                    c23447tn.waE = bzs.f4415id;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                c23447tn = new C23447tn();
                c23447tn.key = "show_tag_list";
                c23447tn.waE = bzs.f4415id;
                a.tZG.add(c23447tn);
            }
            C46400aa.m87322a(this.sDN.bKU(), a);
            C14419a.m22633kT(28);
            ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(this.sDN.cFT(), this.sAX, cFP(), 4, bzs.cEh + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bzs.f4415id);
            AppMethodBeat.m2505o(2096);
            return;
        } else if (view.getId() == this.sDW.getId() || view.getId() == this.qeX.getId() || view.getId() == this.sGm.getId()) {
            if (!(this.sAX == null || C5046bo.isNullOrNil(this.sAX.phw))) {
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", this.sAX.phw);
                C25985d.m41467b(this.sDN.bKU().getApplicationContext(), "webview", ".ui.tools.WebViewUI", intent2);
                ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(this.sDN.cFT(), this.sAX, cFP(), 3, "");
                AppMethodBeat.m2505o(2096);
                return;
            }
        } else if (view.getId() == this.sHa.getId()) {
            this.sDN.mo9161a(this.sAX);
            if (this.sAX.xhh) {
                this.sHb.setImageResource(C1318a.top_story_wow_selected);
                this.sGc.setTextColor(this.sGc.getResources().getColor(C25738R.color.a3n));
                AppMethodBeat.m2505o(2096);
                return;
            }
            this.sHb.setImageResource(C1318a.top_story_wow_unselected);
            this.sGc.setTextColor(this.sGc.getResources().getColor(C25738R.color.a69));
        }
        AppMethodBeat.m2505o(2096);
    }

    public final View getWowView() {
        return this.sHa;
    }
}
