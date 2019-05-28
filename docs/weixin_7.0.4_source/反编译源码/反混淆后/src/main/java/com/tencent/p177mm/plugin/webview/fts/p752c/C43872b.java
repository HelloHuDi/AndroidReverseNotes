package com.tencent.p177mm.plugin.webview.fts.p752c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.websearch.p1066ui.WebSearchWebVideoViewControlBar;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.C40222b;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.C40222b.C144595;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.C40222b.C14460a;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.C40222b.C228103;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.C40222b.C297732;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.C40222b.C297744;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.C40222b.C355881;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.FtsWebVideoView;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.FtsWebVideoView.C14458a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.sdk.platformtools.C35993bg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.fts.c.b */
public final class C43872b implements C22792e {
    private Context context;
    C40222b uhA;
    private C35993bg<FtsWebVideoView> uhB = new C35993bg(3);
    private C22791b uhv;
    public C44786d uhz;

    /* renamed from: com.tencent.mm.plugin.webview.fts.c.b$a */
    public interface C22790a {
        void aDI();

        void cWy();

        void cWz();

        void onDestroy();

        /* renamed from: wU */
        void mo38384wU();

        /* renamed from: wW */
        void mo38385wW();

        /* renamed from: wY */
        boolean mo38386wY();
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.c.b$b */
    public interface C22791b {
        /* renamed from: a */
        void mo9679a(C22790a c22790a);

        void cWA();

        /* renamed from: s */
        void mo9686s(View view, boolean z);
    }

    public C43872b(Context context, MMWebView mMWebView, C22791b c22791b) {
        AppMethodBeat.m2504i(5940);
        this.context = context;
        this.uhv = c22791b;
        this.uhA = new C40222b(mMWebView, c22791b);
        AppMethodBeat.m2505o(5940);
    }

    /* renamed from: G */
    public final void mo38387G(final int i, String str, String str2) {
        AppMethodBeat.m2504i(5941);
        C4990ab.m7417i("FtsVideoPlayerMgr", "insert player id %d,viewProps %s,videoProps %s", Integer.valueOf(i), str, str2);
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                C4990ab.m7412e("FtsVideoPlayerMgr", "insert args invalid");
                AppMethodBeat.m2505o(5941);
                return;
            }
            FtsWebVideoView ftsWebVideoView;
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            FtsWebVideoView ftsWebVideoView2 = (FtsWebVideoView) this.uhB.mo56734aA();
            if (ftsWebVideoView2 == null) {
                ftsWebVideoView = new FtsWebVideoView(this.context, jSONObject2.optBoolean("autoPlay"));
            } else {
                ftsWebVideoView2.stop();
                ftsWebVideoView = ftsWebVideoView2;
            }
            ftsWebVideoView.setIsShowBasicControls(true);
            ftsWebVideoView.setVideoSizeByte(jSONObject2.optInt("fileSize"));
            ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
            ftsWebVideoView.setCover$16da05f7(jSONObject2.optString("coverUrl"));
            ftsWebVideoView.setVideoPlayerId(i);
            ftsWebVideoView.setAutoPlay(jSONObject2.optBoolean("autoPlay"));
            ftsWebVideoView.mo74598bL(C43875c.m78692aL(jSONObject2), jSONObject2.optInt("durationSec"));
            final C438731 c438731 = new C43871a() {
                public final void aDI() {
                    AppMethodBeat.m2504i(5929);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
                    if (ftsWebVideoView.ugQ.hZM) {
                        ftsWebVideoView.ugQ.aDF();
                    }
                    ftsWebVideoView.mo74600er(false);
                    AppMethodBeat.m2505o(5929);
                }
            };
            ftsWebVideoView.setFullScreenDelegate(new C14458a() {
                /* renamed from: nI */
                public final void mo26706nI(boolean z) {
                    AppMethodBeat.m2504i(5930);
                    C40222b c40222b = C43872b.this.uhA;
                    C297744 c297744 = new C297744(Boolean.FALSE, i, c438731, z);
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) c297744.mo10372b(null)).booleanValue();
                        AppMethodBeat.m2505o(5930);
                        return;
                    }
                    ((Boolean) c297744.mo10372b(c40222b.mHandler)).booleanValue();
                    AppMethodBeat.m2505o(5930);
                }

                public final void aDF() {
                    AppMethodBeat.m2504i(5931);
                    C40222b c40222b = C43872b.this.uhA;
                    C144595 c144595 = new C144595(Boolean.FALSE, i);
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) c144595.mo10372b(null)).booleanValue();
                        AppMethodBeat.m2505o(5931);
                        return;
                    }
                    ((Boolean) c144595.mo10372b(c40222b.mHandler)).booleanValue();
                    AppMethodBeat.m2505o(5931);
                }

                public final boolean isFullScreen() {
                    AppMethodBeat.m2504i(5932);
                    boolean pB = C43872b.this.uhA.mo63572pB(i);
                    AppMethodBeat.m2505o(5932);
                    return pB;
                }
            });
            C438743 c438743 = new C22790a() {
                /* renamed from: wU */
                public final void mo38384wU() {
                    AppMethodBeat.m2504i(5933);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onUIResume");
                    ftsWebVideoView.ugP.akW();
                    AppMethodBeat.m2505o(5933);
                }

                /* renamed from: wW */
                public final void mo38385wW() {
                    AppMethodBeat.m2504i(5934);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onUIPause");
                    ftsWebVideoView.ugP.akV();
                    AppMethodBeat.m2505o(5934);
                }

                public final void onDestroy() {
                    AppMethodBeat.m2504i(5935);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onUIDestroy");
                    C4990ab.m7416i("MicroMsg.FtsWebVideoView", "clean");
                    ftsWebVideoView.stop();
                    ftsWebVideoView.ugP.aEX();
                    WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = ftsWebVideoView.ugQ;
                    if (webSearchWebVideoViewControlBar.hZL != null) {
                        webSearchWebVideoViewControlBar.hZL.stopTimer();
                    }
                    if (webSearchWebVideoViewControlBar.hZK != null) {
                        webSearchWebVideoViewControlBar.hZK.stopTimer();
                    }
                    try {
                        ftsWebVideoView.getContext().unregisterReceiver(ftsWebVideoView.uhk);
                        AppMethodBeat.m2505o(5935);
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(5935);
                    }
                }

                public final void aDI() {
                    AppMethodBeat.m2504i(5936);
                    C40222b c40222b = C43872b.this.uhA;
                    C14460a IC = c40222b.mo63568IC(c40222b.iuy);
                    float[] fArr = c40222b.iuv;
                    if (IC == null || IC.iuM == null || fArr == null) {
                        AppMethodBeat.m2505o(5936);
                        return;
                    }
                    View view = (View) IC.iuM.get();
                    if (view != null) {
                        if (c40222b.iuy != c40222b.iuu) {
                            C14460a IC2 = c40222b.mo63568IC(c40222b.iuu);
                            if (!(IC2 == null || IC2.iuM == null)) {
                                View view2 = (View) IC2.iuM.get();
                                if (view2 != null) {
                                    c40222b.mo63570a(c40222b.iuu, fArr, view2.getVisibility());
                                }
                            }
                        }
                        int i = c40222b.iuy;
                        c40222b.iuu = -1;
                        c40222b.iuy = -1;
                        if (c40222b.uhu != null) {
                            c40222b.uhu.aDI();
                            c40222b.uhu = null;
                        }
                        c40222b.mo63570a(i, fArr, view.getVisibility());
                    }
                    AppMethodBeat.m2505o(5936);
                }

                /* renamed from: wY */
                public final boolean mo38386wY() {
                    AppMethodBeat.m2504i(5937);
                    if (ftsWebVideoView.aFb()) {
                        ftsWebVideoView.mo74609nH(false);
                        AppMethodBeat.m2505o(5937);
                        return true;
                    }
                    AppMethodBeat.m2505o(5937);
                    return false;
                }

                public final void cWy() {
                    AppMethodBeat.m2504i(5938);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    if (!ftsWebVideoView.eif && ftsWebVideoView.getSystemVolume() == 0) {
                        ftsWebVideoView.setMute(true);
                    }
                    AppMethodBeat.m2505o(5938);
                }

                public final void cWz() {
                    AppMethodBeat.m2504i(5939);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    if (ftsWebVideoView.eif && ftsWebVideoView.getSystemVolume() > 0) {
                        ftsWebVideoView.setMute(false);
                    }
                    AppMethodBeat.m2505o(5939);
                }
            };
            ftsWebVideoView.setUiLifecycleListener(c438743);
            this.uhv.mo9679a(c438743);
            ftsWebVideoView.setCallback(new C43876d(ftsWebVideoView, this.uhv, this.uhz));
            C40222b c40222b = this.uhA;
            C355881 c355881 = new C355881(Boolean.FALSE, ftsWebVideoView, i, C43875c.m78691a(jSONObject, this.context), C43875c.m78696t(jSONObject));
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ((Boolean) c355881.mo10372b(null)).booleanValue();
                AppMethodBeat.m2505o(5941);
                return;
            }
            ((Boolean) c355881.mo10372b(c40222b.mHandler)).booleanValue();
            AppMethodBeat.m2505o(5941);
        } catch (JSONException e) {
            C4990ab.m7413e("FtsVideoPlayerMgr", "", e);
            AppMethodBeat.m2505o(5941);
        }
    }

    /* renamed from: H */
    public final void mo38388H(int i, String str, String str2) {
        AppMethodBeat.m2504i(5942);
        C4990ab.m7417i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", Integer.valueOf(i), str, str2);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                C40222b c40222b = this.uhA;
                C228103 c228103 = new C228103(Boolean.FALSE, i, C43875c.m78691a(jSONObject, this.context), C43875c.m78696t(jSONObject));
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    ((Boolean) c228103.mo10372b(null)).booleanValue();
                } else {
                    ((Boolean) c228103.mo10372b(c40222b.mHandler)).booleanValue();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject(str2);
                FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.uhA.mo63574q(i);
                if (ftsWebVideoView == null) {
                    C4990ab.m7417i("FtsVideoPlayerMgr", "can not find video View by id %d", Integer.valueOf(i));
                    AppMethodBeat.m2505o(5942);
                    return;
                }
                if (jSONObject2.has("autoPlay")) {
                    ftsWebVideoView.setAutoPlay(jSONObject2.optBoolean("autoPlay"));
                }
                if (jSONObject2.has("coverUrl")) {
                    ftsWebVideoView.setCover$16da05f7(jSONObject2.optString("coverUrl"));
                }
                if (jSONObject2.has("durationSec")) {
                    ftsWebVideoView.setDuration(jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("playUrl")) {
                    ftsWebVideoView.mo74598bL(C43875c.m78692aL(jSONObject2), jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("isMute")) {
                    ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
                }
            }
            AppMethodBeat.m2505o(5942);
        } catch (JSONException e) {
            C4990ab.m7413e("FtsVideoPlayerMgr", "", e);
            AppMethodBeat.m2505o(5942);
        }
    }

    /* renamed from: ID */
    public final void mo38389ID(int i) {
        AppMethodBeat.m2504i(5943);
        C4990ab.m7417i("FtsVideoPlayerMgr", "remove palyer id %d", Integer.valueOf(i));
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.uhA.mo63574q(i);
        if (ftsWebVideoView != null) {
            ftsWebVideoView.getUiLifecycleListener();
        } else {
            C4990ab.m7421w("FtsVideoPlayerMgr", "can not find player by id %d", Integer.valueOf(i));
        }
        C40222b c40222b = this.uhA;
        C297732 c297732 = new C297732(Boolean.FALSE, i);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ((Boolean) c297732.mo10372b(null)).booleanValue();
        } else {
            ((Boolean) c297732.mo10372b(c40222b.mHandler)).booleanValue();
        }
        if (ftsWebVideoView != null) {
            ftsWebVideoView.stop();
            ftsWebVideoView.getCallback().clean();
            ftsWebVideoView.setCallback(null);
            ftsWebVideoView.setVisibility(0);
            ftsWebVideoView.setAllowMobileNetPlay(false);
            this.uhB.release(ftsWebVideoView);
        }
        AppMethodBeat.m2505o(5943);
    }

    /* renamed from: bC */
    public final void mo38390bC(int i, String str) {
        AppMethodBeat.m2504i(5944);
        C4990ab.m7417i("FtsVideoPlayerMgr", "op player id %d,type %s", Integer.valueOf(i), str);
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.uhA.mo63574q(i);
        if (ftsWebVideoView != null) {
            int i2 = -1;
            switch (str.hashCode()) {
                case 3443508:
                    if (str.equals("play")) {
                        i2 = 0;
                        break;
                    }
                    break;
                case 3540994:
                    if (str.equals("stop")) {
                        i2 = 2;
                        break;
                    }
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 640038740:
                    if (str.equals("setUnMute")) {
                        i2 = 4;
                        break;
                    }
                    break;
                case 1984790939:
                    if (str.equals("setMute")) {
                        i2 = 3;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case 0:
                    ftsWebVideoView.mo74599cg(false);
                    AppMethodBeat.m2505o(5944);
                    return;
                case 1:
                    ftsWebVideoView.pause();
                    AppMethodBeat.m2505o(5944);
                    return;
                case 2:
                    ftsWebVideoView.stop();
                    AppMethodBeat.m2505o(5944);
                    return;
                case 3:
                    ftsWebVideoView.setMute(true);
                    AppMethodBeat.m2505o(5944);
                    return;
                case 4:
                    ftsWebVideoView.setMute(false);
                    AppMethodBeat.m2505o(5944);
                    return;
                default:
                    C4990ab.m7417i("FtsVideoPlayerMgr", "unknown op type %s", str);
                    AppMethodBeat.m2505o(5944);
                    return;
            }
        }
        C4990ab.m7417i("FtsVideoPlayerMgr", "can not find player by id %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(5944);
    }
}
