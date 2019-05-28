package com.tencent.p177mm.plugin.topstory.p541ui.video;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.p1414b.C29428a;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.UUID;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.f */
public abstract class C35305f extends RelativeLayout {
    public static C25814c sCQ;
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
    public C46304a sDG;
    protected TextView sDH;
    public C13955a sDI = C13955a.UNKNOWN;
    public C4232b sDo;
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

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.f$a */
    public enum C13955a {
        UNKNOWN,
        MOBILE_NET,
        NO_NET;

        static {
            AppMethodBeat.m2505o(1712);
        }
    }

    public abstract void cGn();

    public abstract void cGo();

    public abstract C35307g getControlBar();

    public abstract int getLayoutId();

    public abstract C23324b getVideoViewCallback();

    static {
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePG = true;
        sCQ = c17927a.ahG();
    }

    public C35305f(Context context, C4232b c4232b, C46304a c46304a) {
        super(context);
        this.sDo = c4232b;
        this.sDG = c46304a;
        init();
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.sDp = (FrameLayout) findViewById(2131828286);
        this.sDq = (TextView) findViewById(2131828297);
        this.sDy = findViewById(2131828288);
        this.sDz = findViewById(2131828287);
        this.sDA = findViewById(2131828293);
        this.sDB = findViewById(2131828289);
        this.sDC = findViewById(2131828294);
        this.sDr = findViewById(2131828296);
        this.kuG = (ImageView) findViewById(2131821842);
        this.sDs = (TextView) findViewById(2131828292);
        this.gne = (TextView) findViewById(2131821185);
        this.sDt = (ImageView) findViewById(2131824280);
        this.sDu = (ImageView) findViewById(2131828290);
        this.sDx = (TextView) findViewById(2131828291);
        this.sDv = (Button) findViewById(2131828295);
        this.sDw = (TextView) findViewById(2131824283);
        this.sDE = (ImageView) findViewById(2131821415);
        this.sDF = (ImageView) findViewById(2131821414);
        this.sDD = (FrameLayout) findViewById(2131821413);
        this.sDH = (TextView) findViewById(2131828330);
    }

    public void cGp() {
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", Integer.valueOf(this.sDG.cFP()));
        this.sDz.setVisibility(8);
        this.kuG.setVisibility(8);
        this.sDq.setVisibility(8);
        this.sDy.setVisibility(8);
        this.sDp.setVisibility(0);
        this.sDp.setAlpha(1.0f);
    }

    public final void cGq() {
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", Integer.valueOf(this.sDG.cFP()));
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
        mo56052gE(getNoNetTip(), this.sDo.bKU().getString(C25738R.string.f1r));
        getContext().getString(C25738R.string.exa, new Object[]{C5046bo.m7526b(this.sAX.xha, 100.0d)});
    }

    /* renamed from: gE */
    public final void mo56052gE(String str, String str2) {
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", str, str2);
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
            return getContext().getString(C25738R.string.exb);
        }
        return getContext().getString(C25738R.string.exa, new Object[]{C5046bo.m7526b(this.sAX.xha, 100.0d)});
    }

    public String getNoNetTip() {
        return getContext().getString(C25738R.string.f1e);
    }

    /* renamed from: a */
    public final void mo56046a(chw chw, int i) {
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", Integer.valueOf(i));
        this.sAX = chw;
        mo47684cu();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cu */
    public void mo47684cu() {
        this.kuG.setImageDrawable(null);
        C32291o.ahp().mo43766a(this.sAX.xgQ, this.kuG, sCQ);
        if (this.sDH != null) {
            this.sDH.animate().cancel();
            this.sDH.setVisibility(8);
        }
    }

    public void cGs() {
    }

    public void cGt() {
    }

    /* renamed from: O */
    public boolean mo56045O(boolean z, boolean z2) {
        String cGh = this.sDo.cGh();
        String cFq = C39964g.cFq();
        int cGi = this.sDo.cGi();
        if (this.sDo.cFQ().isConnected()) {
            if (!(cFq.equals("wifi") || cFq.equals(cGh))) {
                if (cFq.equals("wangka")) {
                    if (!(cGi == 1 || cGi == 2)) {
                        this.sDo.mo9159FE(1);
                        if (this.sDH != null) {
                            this.sDH.setVisibility(0);
                            this.sDH.setAlpha(1.0f);
                            this.sDH.animate().alpha(0.0f).setDuration(3000).start();
                        } else {
                            C23639t.makeText(this.sDo.bKU(), C25738R.string.exc, 0).show();
                        }
                    }
                } else if (cGi != 2) {
                    cGu();
                    this.sDo.cFV().mo63217a(this, getScaleType());
                    return false;
                }
            }
            cGw();
            this.sDo.abI(cFq);
            cGv();
            this.sDI = C13955a.UNKNOWN;
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
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
            this.sDo.cFV().mo63217a(this, getScaleType());
            C39996r cFV = this.sDo.cFV();
            C4232b c4232b = this.sDo;
            chw chw = this.sAX;
            String str = this.cvF;
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s", Integer.valueOf(this.sDG.cFP()), chw.xgS);
            if (cFV.sFv != null) {
                if (!cFV.sFv.ubA.equals(chw.ubA) || z2) {
                    cFV.sFt.stop();
                    c4232b.cFR().mo74503b(c4232b.cFT());
                    c4232b.cFR().cGS();
                }
                return true;
            }
            if (C5046bo.isNullOrNil(chw.videoUrl)) {
                C4990ab.m7413e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", str, chw.xgS, chw.title);
            } else {
                c4232b.cFR().mo74501a(chw, r6, str);
                cFV.sDo.cFR().mo74506e(chw);
                cFV.sFt.setLoop(false);
                cFV.sFt.setVideoInfo(chw);
                cFV.sFt.setMute(c4232b.mo9156DX());
                cFV.sFt.setKeepScreenOn(true);
                cFV.sFt.abJ(str);
                cFV.sFt.cGV();
                cFV.sFv = chw;
                cFV.sFw = true;
                cFV.sFx = false;
            }
            return true;
        }
        this.sDI = C13955a.NO_NET;
        cGs();
        mo56052gE(getNoNetTip(), getContext().getString(C25738R.string.f1r));
        this.sDo.cFV().mo63217a(this, getScaleType());
        return false;
    }

    public final void cGu() {
        this.sDI = C13955a.MOBILE_NET;
        cGs();
        mo56052gE(getMobileNetTip(), getContext().getString(C25738R.string.ews));
    }

    public C35873d getScaleType() {
        return C35873d.DEFAULT;
    }

    public final String cGv() {
        this.cvF = UUID.randomUUID().toString();
        return this.cvF;
    }

    public final void seekTo(int i) {
        int currPosSec = this.sDo.cFV().getCurrPosSec();
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", Integer.valueOf(i), Integer.valueOf(currPosSec));
        C39996r cFV = this.sDo.cFV();
        if (cFV.sFt != null) {
            cFV.sFt.mo44252C(i, true);
        }
        C29428a c29428a = this.sDo.cFR().sFp;
        if (c29428a != null) {
            c29428a.sAJ = 1;
        }
    }

    public void cGw() {
    }

    public final void cGx() {
        this.sDD.setVisibility(0);
    }

    public C46304a getItemUIComponent() {
        return this.sDG;
    }

    public C13955a getPauseReason() {
        return this.sDI;
    }
}
