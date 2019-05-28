package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass4;
import com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass5;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements e {
    private Context context;
    com.tencent.mm.plugin.webview.fts.ui.b uhA;
    private bg<FtsWebVideoView> uhB = new bg(3);
    private b uhv;
    public d uhz;

    public interface a {
        void aDI();

        void cWy();

        void cWz();

        void onDestroy();

        void wU();

        void wW();

        boolean wY();
    }

    public interface b {
        void a(a aVar);

        void cWA();

        void s(View view, boolean z);
    }

    public b(Context context, MMWebView mMWebView, b bVar) {
        AppMethodBeat.i(5940);
        this.context = context;
        this.uhv = bVar;
        this.uhA = new com.tencent.mm.plugin.webview.fts.ui.b(mMWebView, bVar);
        AppMethodBeat.o(5940);
    }

    public final void G(final int i, String str, String str2) {
        AppMethodBeat.i(5941);
        ab.i("FtsVideoPlayerMgr", "insert player id %d,viewProps %s,videoProps %s", Integer.valueOf(i), str, str2);
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                ab.e("FtsVideoPlayerMgr", "insert args invalid");
                AppMethodBeat.o(5941);
                return;
            }
            FtsWebVideoView ftsWebVideoView;
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            FtsWebVideoView ftsWebVideoView2 = (FtsWebVideoView) this.uhB.aA();
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
            ftsWebVideoView.bL(c.aL(jSONObject2), jSONObject2.optInt("durationSec"));
            final AnonymousClass1 anonymousClass1 = new a() {
                public final void aDI() {
                    AppMethodBeat.i(5929);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    ab.i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
                    if (ftsWebVideoView.ugQ.hZM) {
                        ftsWebVideoView.ugQ.aDF();
                    }
                    ftsWebVideoView.er(false);
                    AppMethodBeat.o(5929);
                }
            };
            ftsWebVideoView.setFullScreenDelegate(new com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a() {
                public final void nI(boolean z) {
                    AppMethodBeat.i(5930);
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.uhA;
                    AnonymousClass4 anonymousClass4 = new AnonymousClass4(Boolean.FALSE, i, anonymousClass1, z);
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) anonymousClass4.b(null)).booleanValue();
                        AppMethodBeat.o(5930);
                        return;
                    }
                    ((Boolean) anonymousClass4.b(bVar.mHandler)).booleanValue();
                    AppMethodBeat.o(5930);
                }

                public final void aDF() {
                    AppMethodBeat.i(5931);
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.uhA;
                    AnonymousClass5 anonymousClass5 = new AnonymousClass5(Boolean.FALSE, i);
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) anonymousClass5.b(null)).booleanValue();
                        AppMethodBeat.o(5931);
                        return;
                    }
                    ((Boolean) anonymousClass5.b(bVar.mHandler)).booleanValue();
                    AppMethodBeat.o(5931);
                }

                public final boolean isFullScreen() {
                    AppMethodBeat.i(5932);
                    boolean pB = b.this.uhA.pB(i);
                    AppMethodBeat.o(5932);
                    return pB;
                }
            });
            AnonymousClass3 anonymousClass3 = new a() {
                public final void wU() {
                    AppMethodBeat.i(5933);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    ab.i("MicroMsg.FtsWebVideoView", "onUIResume");
                    ftsWebVideoView.ugP.akW();
                    AppMethodBeat.o(5933);
                }

                public final void wW() {
                    AppMethodBeat.i(5934);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    ab.i("MicroMsg.FtsWebVideoView", "onUIPause");
                    ftsWebVideoView.ugP.akV();
                    AppMethodBeat.o(5934);
                }

                public final void onDestroy() {
                    AppMethodBeat.i(5935);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    ab.i("MicroMsg.FtsWebVideoView", "onUIDestroy");
                    ab.i("MicroMsg.FtsWebVideoView", "clean");
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
                        AppMethodBeat.o(5935);
                    } catch (Exception e) {
                        AppMethodBeat.o(5935);
                    }
                }

                public final void aDI() {
                    AppMethodBeat.i(5936);
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.uhA;
                    com.tencent.mm.plugin.webview.fts.ui.b.a IC = bVar.IC(bVar.iuy);
                    float[] fArr = bVar.iuv;
                    if (IC == null || IC.iuM == null || fArr == null) {
                        AppMethodBeat.o(5936);
                        return;
                    }
                    View view = (View) IC.iuM.get();
                    if (view != null) {
                        if (bVar.iuy != bVar.iuu) {
                            com.tencent.mm.plugin.webview.fts.ui.b.a IC2 = bVar.IC(bVar.iuu);
                            if (!(IC2 == null || IC2.iuM == null)) {
                                View view2 = (View) IC2.iuM.get();
                                if (view2 != null) {
                                    bVar.a(bVar.iuu, fArr, view2.getVisibility());
                                }
                            }
                        }
                        int i = bVar.iuy;
                        bVar.iuu = -1;
                        bVar.iuy = -1;
                        if (bVar.uhu != null) {
                            bVar.uhu.aDI();
                            bVar.uhu = null;
                        }
                        bVar.a(i, fArr, view.getVisibility());
                    }
                    AppMethodBeat.o(5936);
                }

                public final boolean wY() {
                    AppMethodBeat.i(5937);
                    if (ftsWebVideoView.aFb()) {
                        ftsWebVideoView.nH(false);
                        AppMethodBeat.o(5937);
                        return true;
                    }
                    AppMethodBeat.o(5937);
                    return false;
                }

                public final void cWy() {
                    AppMethodBeat.i(5938);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    if (!ftsWebVideoView.eif && ftsWebVideoView.getSystemVolume() == 0) {
                        ftsWebVideoView.setMute(true);
                    }
                    AppMethodBeat.o(5938);
                }

                public final void cWz() {
                    AppMethodBeat.i(5939);
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    if (ftsWebVideoView.eif && ftsWebVideoView.getSystemVolume() > 0) {
                        ftsWebVideoView.setMute(false);
                    }
                    AppMethodBeat.o(5939);
                }
            };
            ftsWebVideoView.setUiLifecycleListener(anonymousClass3);
            this.uhv.a(anonymousClass3);
            ftsWebVideoView.setCallback(new d(ftsWebVideoView, this.uhv, this.uhz));
            com.tencent.mm.plugin.webview.fts.ui.b bVar = this.uhA;
            com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass1 anonymousClass12 = new com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass1(Boolean.FALSE, ftsWebVideoView, i, c.a(jSONObject, this.context), c.t(jSONObject));
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ((Boolean) anonymousClass12.b(null)).booleanValue();
                AppMethodBeat.o(5941);
                return;
            }
            ((Boolean) anonymousClass12.b(bVar.mHandler)).booleanValue();
            AppMethodBeat.o(5941);
        } catch (JSONException e) {
            ab.e("FtsVideoPlayerMgr", "", e);
            AppMethodBeat.o(5941);
        }
    }

    public final void H(int i, String str, String str2) {
        AppMethodBeat.i(5942);
        ab.i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", Integer.valueOf(i), str, str2);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                com.tencent.mm.plugin.webview.fts.ui.b bVar = this.uhA;
                com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass3 anonymousClass3 = new com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass3(Boolean.FALSE, i, c.a(jSONObject, this.context), c.t(jSONObject));
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    ((Boolean) anonymousClass3.b(null)).booleanValue();
                } else {
                    ((Boolean) anonymousClass3.b(bVar.mHandler)).booleanValue();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject(str2);
                FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.uhA.q(i);
                if (ftsWebVideoView == null) {
                    ab.i("FtsVideoPlayerMgr", "can not find video View by id %d", Integer.valueOf(i));
                    AppMethodBeat.o(5942);
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
                    ftsWebVideoView.bL(c.aL(jSONObject2), jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("isMute")) {
                    ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
                }
            }
            AppMethodBeat.o(5942);
        } catch (JSONException e) {
            ab.e("FtsVideoPlayerMgr", "", e);
            AppMethodBeat.o(5942);
        }
    }

    public final void ID(int i) {
        AppMethodBeat.i(5943);
        ab.i("FtsVideoPlayerMgr", "remove palyer id %d", Integer.valueOf(i));
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.uhA.q(i);
        if (ftsWebVideoView != null) {
            ftsWebVideoView.getUiLifecycleListener();
        } else {
            ab.w("FtsVideoPlayerMgr", "can not find player by id %d", Integer.valueOf(i));
        }
        com.tencent.mm.plugin.webview.fts.ui.b bVar = this.uhA;
        com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass2(Boolean.FALSE, i);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ((Boolean) anonymousClass2.b(null)).booleanValue();
        } else {
            ((Boolean) anonymousClass2.b(bVar.mHandler)).booleanValue();
        }
        if (ftsWebVideoView != null) {
            ftsWebVideoView.stop();
            ftsWebVideoView.getCallback().clean();
            ftsWebVideoView.setCallback(null);
            ftsWebVideoView.setVisibility(0);
            ftsWebVideoView.setAllowMobileNetPlay(false);
            this.uhB.release(ftsWebVideoView);
        }
        AppMethodBeat.o(5943);
    }

    public final void bC(int i, String str) {
        AppMethodBeat.i(5944);
        ab.i("FtsVideoPlayerMgr", "op player id %d,type %s", Integer.valueOf(i), str);
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.uhA.q(i);
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
                    ftsWebVideoView.cg(false);
                    AppMethodBeat.o(5944);
                    return;
                case 1:
                    ftsWebVideoView.pause();
                    AppMethodBeat.o(5944);
                    return;
                case 2:
                    ftsWebVideoView.stop();
                    AppMethodBeat.o(5944);
                    return;
                case 3:
                    ftsWebVideoView.setMute(true);
                    AppMethodBeat.o(5944);
                    return;
                case 4:
                    ftsWebVideoView.setMute(false);
                    AppMethodBeat.o(5944);
                    return;
                default:
                    ab.i("FtsVideoPlayerMgr", "unknown op type %s", str);
                    AppMethodBeat.o(5944);
                    return;
            }
        }
        ab.i("FtsVideoPlayerMgr", "can not find player by id %d", Integer.valueOf(i));
        AppMethodBeat.o(5944);
    }
}
