package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import java.util.UUID;

public abstract class f extends RelativeLayout {
    public static c sCQ;
    public String cvF = "";
    protected TextView gne;
    protected ImageView kuG;
    public chw sAX;
    protected View sDA;
    protected View sDB;
    protected View sDC;
    public FrameLayout sDD;
    public ImageView sDE;
    public ImageView sDF;
    public a sDG;
    protected TextView sDH;
    public a sDI = a.UNKNOWN;
    public b sDo;
    protected FrameLayout sDp;
    public TextView sDq;
    protected View sDr;
    protected TextView sDs;
    protected ImageView sDt;
    protected ImageView sDu;
    protected Button sDv;
    protected TextView sDw;
    protected TextView sDx;
    protected View sDy;
    protected View sDz;

    public enum a {
        UNKNOWN,
        MOBILE_NET,
        NO_NET;

        static {
            AppMethodBeat.o(1712);
        }
    }

    public abstract void cGn();

    public abstract void cGo();

    public abstract g getControlBar();

    public abstract int getLayoutId();

    public abstract b getVideoViewCallback();

    static {
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePH = true;
        aVar.ePG = true;
        sCQ = aVar.ahG();
    }

    public f(Context context, b bVar, a aVar) {
        super(context);
        this.sDo = bVar;
        this.sDG = aVar;
        init();
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.sDp = (FrameLayout) findViewById(R.id.ex_);
        this.sDq = (TextView) findViewById(R.id.exk);
        this.sDy = findViewById(R.id.exb);
        this.sDz = findViewById(R.id.exa);
        this.sDA = findViewById(R.id.exg);
        this.sDB = findViewById(R.id.exc);
        this.sDC = findViewById(R.id.exh);
        this.sDr = findViewById(R.id.exj);
        this.kuG = (ImageView) findViewById(R.id.a82);
        this.sDs = (TextView) findViewById(R.id.exf);
        this.gne = (TextView) findViewById(R.id.qm);
        this.sDt = (ImageView) findViewById(R.id.bzz);
        this.sDu = (ImageView) findViewById(R.id.exd);
        this.sDx = (TextView) findViewById(R.id.exe);
        this.sDv = (Button) findViewById(R.id.exi);
        this.sDw = (TextView) findViewById(R.id.c02);
        this.sDE = (ImageView) findViewById(R.id.wu);
        this.sDF = (ImageView) findViewById(R.id.wt);
        this.sDD = (FrameLayout) findViewById(R.id.ws);
        this.sDH = (TextView) findViewById(R.id.eyg);
    }

    public void cGp() {
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", Integer.valueOf(this.sDG.cFP()));
        this.sDz.setVisibility(8);
        this.kuG.setVisibility(8);
        this.sDq.setVisibility(8);
        this.sDy.setVisibility(8);
        this.sDp.setVisibility(0);
        this.sDp.setAlpha(1.0f);
    }

    public final void cGq() {
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", Integer.valueOf(this.sDG.cFP()));
        this.kuG.setVisibility(0);
        this.sDz.setVisibility(0);
        this.sDD.setVisibility(8);
        this.sDA.setVisibility(8);
        this.sDy.setVisibility(0);
        this.sDB.setVisibility(0);
        this.sDt.setVisibility(0);
        this.sDu.setVisibility(8);
        this.sDx.setVisibility(8);
        this.sDs.setVisibility(8);
    }

    public final void cGr() {
        gE(getNoNetTip(), this.sDo.bKU().getString(R.string.f1r));
        getContext().getString(R.string.exa, new Object[]{bo.b(this.sAX.xha, 100.0d)});
    }

    public final void gE(String str, String str2) {
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", str, str2);
        this.kuG.setVisibility(0);
        this.sDz.setVisibility(0);
        this.sDA.setVisibility(0);
        this.sDy.setVisibility(0);
        this.sDB.setVisibility(8);
        this.sDC.setVisibility(0);
        this.sDr.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            this.sDw.setVisibility(8);
        } else {
            this.sDw.setText(str);
            this.sDw.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.sDv.setVisibility(8);
            return;
        }
        this.sDv.setText(str2);
        this.sDv.setVisibility(0);
    }

    public FrameLayout getVideoViewParent() {
        return this.sDp;
    }

    /* Access modifiers changed, original: protected */
    public String getMobileNetTip() {
        if (this.sAX.xha == 0) {
            return getContext().getString(R.string.exb);
        }
        return getContext().getString(R.string.exa, new Object[]{bo.b(this.sAX.xha, 100.0d)});
    }

    public String getNoNetTip() {
        return getContext().getString(R.string.f1e);
    }

    public final void a(chw chw, int i) {
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", Integer.valueOf(i));
        this.sAX = chw;
        cu();
    }

    /* Access modifiers changed, original: protected */
    public void cu() {
        this.kuG.setImageDrawable(null);
        o.ahp().a(this.sAX.xgQ, this.kuG, sCQ);
        if (this.sDH != null) {
            this.sDH.animate().cancel();
            this.sDH.setVisibility(8);
        }
    }

    public void cGs() {
    }

    public void cGt() {
    }

    public boolean O(boolean z, boolean z2) {
        String cGh = this.sDo.cGh();
        String cFq = g.cFq();
        int cGi = this.sDo.cGi();
        if (this.sDo.cFQ().isConnected()) {
            if (!(cFq.equals("wifi") || cFq.equals(cGh))) {
                if (cFq.equals("wangka")) {
                    if (!(cGi == 1 || cGi == 2)) {
                        this.sDo.FE(1);
                        if (this.sDH != null) {
                            this.sDH.setVisibility(0);
                            this.sDH.setAlpha(1.0f);
                            this.sDH.animate().alpha(0.0f).setDuration(3000).start();
                        } else {
                            t.makeText(this.sDo.bKU(), R.string.exc, 0).show();
                        }
                    }
                } else if (cGi != 2) {
                    cGu();
                    this.sDo.cFV().a(this, getScaleType());
                    return false;
                }
            }
            cGw();
            this.sDo.abI(cFq);
            cGv();
            this.sDI = a.UNKNOWN;
            ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
            this.sDz.setVisibility(0);
            this.sDB.setVisibility(8);
            this.sDy.setVisibility(8);
            this.sDD.setVisibility(8);
            this.sDA.setVisibility(0);
            this.sDC.setVisibility(8);
            this.sDr.setVisibility(0);
            this.sDr.setVisibility(0);
            this.sDr.setAlpha(0.0f);
            this.sDr.animate().setDuration(4000).setInterpolator(new AccelerateInterpolator()).alpha(1.0f).start();
            this.kuG.setVisibility(0);
            this.sDq.setVisibility(8);
            this.sDp.setVisibility(0);
            this.sDp.setAlpha(0.0f);
            this.sDo.cFV().a(this, getScaleType());
            r cFV = this.sDo.cFV();
            b bVar = this.sDo;
            chw chw = this.sAX;
            String str = this.cvF;
            ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s", Integer.valueOf(this.sDG.cFP()), chw.xgS);
            if (cFV.sFv != null) {
                if (!cFV.sFv.ubA.equals(chw.ubA) || z2) {
                    cFV.sFt.stop();
                    bVar.cFR().b(bVar.cFT());
                    bVar.cFR().cGS();
                }
                return true;
            }
            if (bo.isNullOrNil(chw.videoUrl)) {
                ab.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", str, chw.xgS, chw.title);
            } else {
                bVar.cFR().a(chw, r6, str);
                cFV.sDo.cFR().e(chw);
                cFV.sFt.setLoop(false);
                cFV.sFt.setVideoInfo(chw);
                cFV.sFt.setMute(bVar.DX());
                cFV.sFt.setKeepScreenOn(true);
                cFV.sFt.abJ(str);
                cFV.sFt.cGV();
                cFV.sFv = chw;
                cFV.sFw = true;
                cFV.sFx = false;
            }
            return true;
        }
        this.sDI = a.NO_NET;
        cGs();
        gE(getNoNetTip(), getContext().getString(R.string.f1r));
        this.sDo.cFV().a(this, getScaleType());
        return false;
    }

    public final void cGu() {
        this.sDI = a.MOBILE_NET;
        cGs();
        gE(getMobileNetTip(), getContext().getString(R.string.ews));
    }

    public d getScaleType() {
        return d.DEFAULT;
    }

    public final String cGv() {
        this.cvF = UUID.randomUUID().toString();
        return this.cvF;
    }

    public final void seekTo(int i) {
        int currPosSec = this.sDo.cFV().getCurrPosSec();
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", Integer.valueOf(i), Integer.valueOf(currPosSec));
        r cFV = this.sDo.cFV();
        if (cFV.sFt != null) {
            cFV.sFt.C(i, true);
        }
        com.tencent.mm.plugin.topstory.a.b.a aVar = this.sDo.cFR().sFp;
        if (aVar != null) {
            aVar.sAJ = 1;
        }
    }

    public void cGw() {
    }

    public final void cGx() {
        this.sDD.setVisibility(0);
    }

    public a getItemUIComponent() {
        return this.sDG;
    }

    public a getPauseReason() {
        return this.sDI;
    }
}
