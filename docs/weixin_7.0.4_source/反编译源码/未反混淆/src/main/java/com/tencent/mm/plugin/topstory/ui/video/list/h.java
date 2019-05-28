package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.UUID;

public final class h extends com.tencent.mm.plugin.topstory.ui.video.h implements a {
    public View jNV;
    public MMNeat7extView jXy;
    public View ltW;
    public TextView mLM;
    public TextView mLN;
    public TextView qeX;
    public ImageView sDW;
    public View sFZ;
    public f sGZ;
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

    public h(View view, b bVar, boolean z) {
        super(view, bVar);
        this.sHf = z;
    }

    public final void ej(View view) {
        AppMethodBeat.i(2087);
        super.ej(view);
        this.sGr = (FrameLayout) view.findViewById(R.id.exl);
        this.sDW = (ImageView) view.findViewById(R.id.ewr);
        this.qeX = (TextView) view.findViewById(R.id.z5);
        this.jXy = (MMNeat7extView) view.findViewById(R.id.qm);
        this.sGm = view.findViewById(R.id.ews);
        this.ltW = view.findViewById(R.id.ewu);
        this.sHa = view.findViewById(R.id.ewv);
        this.sHb = (ImageView) view.findViewById(R.id.eww);
        this.sGc = (TextView) view.findViewById(R.id.ewx);
        this.sFZ = view.findViewById(R.id.ewt);
        this.sGg = view.findViewById(R.id.ewz);
        this.sGh = (TextView) view.findViewById(R.id.ex6);
        this.sGi = view.findViewById(R.id.ex0);
        this.sGj = view.findViewById(R.id.ex3);
        this.mLM = (TextView) view.findViewById(R.id.ex2);
        this.mLN = (TextView) view.findViewById(R.id.ex5);
        this.sGk = (ImageView) view.findViewById(R.id.ex1);
        this.sGl = (ImageView) view.findViewById(R.id.ex4);
        this.sHc = view.findViewById(R.id.eym);
        this.sHd = view.findViewById(R.id.eyl);
        this.sHe = view.findViewById(R.id.eyn);
        this.jNV = view.findViewById(R.id.byt);
        if (this.sHf) {
            this.sGg.setVisibility(0);
            AppMethodBeat.o(2087);
            return;
        }
        this.sGg.setVisibility(8);
        AppMethodBeat.o(2087);
    }

    public final void cHj() {
        AppMethodBeat.i(2088);
        ab.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", Integer.valueOf(hashCode()));
        this.sHe.animate().cancel();
        this.sHd.animate().cancel();
        this.sHc.animate().cancel();
        this.sHc.setAlpha(0.8f);
        this.sHe.setAlpha(0.8f);
        this.sHd.setAlpha(0.8f);
        AppMethodBeat.o(2088);
    }

    public final void cHk() {
        AppMethodBeat.i(2089);
        ab.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", Integer.valueOf(hashCode()));
        this.sHe.animate().cancel();
        this.sHd.animate().cancel();
        this.sHc.animate().cancel();
        this.sHc.setAlpha(0.0f);
        this.sHe.setAlpha(0.0f);
        this.sHd.setAlpha(0.0f);
        AppMethodBeat.o(2089);
    }

    public final void cFO() {
        AppMethodBeat.i(2090);
        super.cFO();
        this.sHe.animate().cancel();
        this.sHd.animate().cancel();
        this.sHe.setAlpha(0.0f);
        this.sHd.setAlpha(0.0f);
        AppMethodBeat.o(2090);
    }

    public final void cFN() {
        AppMethodBeat.i(2091);
        super.cFN();
        AppMethodBeat.o(2091);
    }

    public final boolean cGy() {
        AppMethodBeat.i(2092);
        if (this.sHe.getAlpha() == 0.0f || this.sHd.getAlpha() == 0.0f) {
            AppMethodBeat.o(2092);
            return false;
        }
        AppMethodBeat.o(2092);
        return true;
    }

    public final void mc(boolean z) {
        AppMethodBeat.i(2093);
        super.mc(z);
        cHk();
        this.sDN.FD(cFP());
        if (this.sGZ.O(z, false)) {
            cFO();
            super.cFN();
        }
        AppMethodBeat.o(2093);
    }

    public final void cGz() {
        AppMethodBeat.i(2094);
        if (bo.isNullOrNil(this.sAX.title)) {
            this.jXy.setVisibility(8);
        } else {
            this.jXy.ah(this.sAX.title);
            this.jXy.setVisibility(0);
            this.jXy.requestLayout();
        }
        this.jXy.setOnClickListener(this.pLd);
        this.qeX.setText(this.sAX.source);
        if (bo.isNullOrNil(this.sAX.phw)) {
            this.sGm.setVisibility(8);
        } else {
            this.sGm.setVisibility(0);
        }
        this.sDW.setOnClickListener(this.pLd);
        this.qeX.setOnClickListener(this.pLd);
        this.sGm.setOnClickListener(this.pLd);
        if (bo.isNullOrNil(this.sAX.xgY)) {
            this.sDW.setImageResource(R.drawable.ad2);
        } else {
            o.ahp().a(this.sAX.xgY, this.sDW, c.sBm);
        }
        if (this.sDN.cFZ()) {
            this.ltW.setVisibility(0);
            this.ltW.setOnClickListener(this.pLd);
        } else {
            this.ltW.setVisibility(8);
        }
        this.sFZ.setTag(this.sAX);
        this.sFZ.setOnClickListener(this.pLd);
        if (bo.ek(this.sAX.xhc)) {
            this.sFZ.setVisibility(8);
        } else {
            this.sFZ.setVisibility(0);
        }
        this.jNV.setOnClickListener(this.pLd);
        this.sHc.setVisibility(0);
        this.sHd.setVisibility(0);
        this.sHe.setVisibility(0);
        if (this.sGZ == null) {
            this.sGZ = new f(this.sDN.bKU(), this.sDN, this);
            this.sGr.removeAllViews();
            FrameLayout frameLayout = this.sGr;
            f fVar = this.sGZ;
            ab.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", Integer.valueOf(this.sDN.getVideoWidth()), Integer.valueOf(this.sDN.getVideoHeight()));
            frameLayout.addView(fVar, new LayoutParams(this.sDN.getVideoWidth(), this.sDN.getVideoHeight()));
        }
        this.sGZ.a(this.sAX, cFP());
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
            if (!bo.isNullOrNil(bzs.cIY)) {
                o.ahp().a(bzs.cIY, this.sGk, c.sBn);
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
                if (!bo.isNullOrNil(bzs.cIY)) {
                    o.ahp().a(bzs.cIY, this.sGl, c.sBn);
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
                this.sHb.setImageResource(R.raw.top_story_wow_selected);
                this.sGc.setTextColor(this.sGc.getResources().getColor(R.color.a3n));
                AppMethodBeat.o(2094);
                return;
            }
            this.sHb.setImageResource(R.raw.top_story_wow_unselected);
            this.sGc.setTextColor(this.sGc.getResources().getColor(R.color.a69));
            AppMethodBeat.o(2094);
            return;
        }
        this.sHa.setVisibility(8);
        AppMethodBeat.o(2094);
    }

    public final f cGA() {
        return this.sGZ;
    }

    public final void ek(View view) {
        AppMethodBeat.i(2095);
        if (g.cFm() && view.getId() == this.jXy.getId()) {
            this.sDN.cFV().sFy = true;
        }
        super.ek(view);
        AppMethodBeat.o(2095);
    }

    public final void el(View view) {
        int i = 1;
        AppMethodBeat.i(2096);
        if (view.getId() == this.jXy.getId()) {
            if (!(this.sAX == null || bo.isNullOrNil(this.sAX.uaj))) {
                String str = this.sAX.uaj;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                d.b(this.sDN.bKU(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                if (this.sDN.cFV().sFw) {
                    this.sGZ.cGw();
                    this.sDN.cFV().cpN();
                }
                this.sDN.cFR().f(this.sAX);
                ((b) com.tencent.mm.kernel.g.M(b.class)).getReporter().a(this.sDN.cFT(), this.sAX, cFP(), 1, "");
                AppMethodBeat.o(2096);
                return;
            }
        } else if (view.getId() == this.ltW.getId()) {
            a.kT(8);
            a(this.sDN, this.sDN.bKU(), this.sGZ, cFP());
            AppMethodBeat.o(2096);
            return;
        } else if (view.getId() == this.sFZ.getId()) {
            this.sDN.ad(this.sFZ, cFP());
            AppMethodBeat.o(2096);
            return;
        } else if (view.getId() == this.mLM.getId() || view.getId() == this.mLN.getId()) {
            tn tnVar;
            this.sDN.cFQ().sEM = true;
            this.sDN.cFV().stopPlay();
            this.sGZ.cGq();
            bzs bzs = (bzs) view.getTag();
            chv a = g.a(this.sDN.cFT());
            a.xgj = UUID.randomUUID().toString();
            a.xgC = this.sAX.xgS;
            a.xgG = bzs.wYN;
            a.xgH = null;
            a.xgI = bzs;
            a.eif = this.sDN.DX();
            a.xgJ = this.sDN.cFQ().sEM;
            Iterator it = a.tZG.iterator();
            while (it.hasNext()) {
                tnVar = (tn) it.next();
                if ("show_tag_list".equals(tnVar.key)) {
                    tnVar.waE = bzs.id;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                tnVar = new tn();
                tnVar.key = "show_tag_list";
                tnVar.waE = bzs.id;
                a.tZG.add(tnVar);
            }
            aa.a(this.sDN.bKU(), a);
            a.kT(28);
            ((b) com.tencent.mm.kernel.g.M(b.class)).getReporter().a(this.sDN.cFT(), this.sAX, cFP(), 4, bzs.cEh + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bzs.id);
            AppMethodBeat.o(2096);
            return;
        } else if (view.getId() == this.sDW.getId() || view.getId() == this.qeX.getId() || view.getId() == this.sGm.getId()) {
            if (!(this.sAX == null || bo.isNullOrNil(this.sAX.phw))) {
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", this.sAX.phw);
                d.b(this.sDN.bKU().getApplicationContext(), "webview", ".ui.tools.WebViewUI", intent2);
                ((b) com.tencent.mm.kernel.g.M(b.class)).getReporter().a(this.sDN.cFT(), this.sAX, cFP(), 3, "");
                AppMethodBeat.o(2096);
                return;
            }
        } else if (view.getId() == this.sHa.getId()) {
            this.sDN.a(this.sAX);
            if (this.sAX.xhh) {
                this.sHb.setImageResource(R.raw.top_story_wow_selected);
                this.sGc.setTextColor(this.sGc.getResources().getColor(R.color.a3n));
                AppMethodBeat.o(2096);
                return;
            }
            this.sHb.setImageResource(R.raw.top_story_wow_unselected);
            this.sGc.setTextColor(this.sGc.getResources().getColor(R.color.a69));
        }
        AppMethodBeat.o(2096);
    }

    public final View getWowView() {
        return this.sHa;
    }
}
