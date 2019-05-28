package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.view.View;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.AppBrandVideoView.C19501a;
import com.tencent.p177mm.plugin.appbrand.page.C38462an;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.f */
public final class C46894f extends C45577a {
    private static final int CTRL_INDEX = 6;
    public static final String NAME = "insertVideoPlayer";

    /* renamed from: a */
    public final View mo6126a(C33303e c33303e, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126556);
        Context context = c33303e.getContext();
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, AppBrandVideoView.aEW().mo34685cM(context));
        AppMethodBeat.m2505o(126556);
        return coverViewContainer;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126557);
        int i = jSONObject.getInt("videoPlayerId");
        AppMethodBeat.m2505o(126557);
        return i;
    }

    /* renamed from: a */
    public final void mo6140a(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126558);
        C4990ab.m7417i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", Integer.valueOf(i));
        final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).mo60996ah(AppBrandVideoView.class);
        if (appBrandVideoView == null) {
            C4990ab.m7412e("MicroMsg.JsApiInsertVideoPlayer", "onInsertView appBrandVideoView null");
            AppMethodBeat.m2505o(126558);
            return;
        }
        final C412371 c412371 = new C38462an() {
            public final void aDI() {
                AppMethodBeat.m2504i(126549);
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onExitFullScreen");
                if (appBrandVideoView.hYP.aFI()) {
                    appBrandVideoView.hYP.aDF();
                }
                appBrandVideoView.mo34627er(false);
                AppMethodBeat.m2505o(126549);
            }
        };
        final C456312 c456312 = new C10381d() {
            /* renamed from: wU */
            public final void mo6095wU() {
                AppMethodBeat.m2504i(126550);
                appBrandVideoView.akW();
                AppMethodBeat.m2505o(126550);
            }
        };
        final C33303e c33303e2 = c33303e;
        final C334013 c334013 = new C10379b() {
            /* renamed from: wW */
            public final void mo21857wW() {
                AppMethodBeat.m2504i(126551);
                C33184d wV = C33183g.m54286wV(c33303e2.getAppId());
                C4990ab.m7417i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", wV.name());
                if (wV == C33184d.LAUNCH_NATIVE_PAGE) {
                    appBrandVideoView.mo34636ow(2);
                    AppMethodBeat.m2505o(126551);
                } else if (wV == C33184d.HIDE) {
                    appBrandVideoView.mo34636ow(1);
                    AppMethodBeat.m2505o(126551);
                } else {
                    appBrandVideoView.mo34636ow(3);
                    AppMethodBeat.m2505o(126551);
                }
            }
        };
        final C33303e c33303e3 = c33303e;
        C334024 c334024 = new C10380c() {
            public final void onDestroy() {
                AppMethodBeat.m2504i(126552);
                appBrandVideoView.aEX();
                c33303e3.mo53834b(c456312);
                c33303e3.mo53832b(c334013);
                c33303e3.mo53833b((C10380c) this);
                AppMethodBeat.m2505o(126552);
            }
        };
        c33303e.mo53829a((C10381d) c456312);
        c33303e.mo53827a((C10379b) c334013);
        c33303e.mo53828a((C10380c) c334024);
        c33303e2 = c33303e;
        final int i2 = i;
        appBrandVideoView.setFullScreenDelegate(new C19501a() {
            /* renamed from: on */
            public final void mo22052on(int i) {
                AppMethodBeat.m2504i(126553);
                c33303e2.aBf().mo73441a(i2, c412371, i);
                AppMethodBeat.m2505o(126553);
            }

            public final void aDF() {
                AppMethodBeat.m2504i(126554);
                c33303e2.aBf().mo73448pC(i2);
                AppMethodBeat.m2505o(126554);
            }

            public final boolean isFullScreen() {
                AppMethodBeat.m2504i(126555);
                boolean pB = c33303e2.aBf().mo73447pB(i2);
                AppMethodBeat.m2505o(126555);
                return pB;
            }
        });
        appBrandVideoView.setContentDescription(view.getContext().getString(C25738R.string.f8833ga));
        appBrandVideoView.setMute(jSONObject.optBoolean("muted", false));
        boolean optBoolean = jSONObject.optBoolean("needEvent", false);
        C4990ab.m7417i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", Boolean.valueOf(jSONObject.optBoolean("autoplay", false)), Boolean.valueOf(optBoolean));
        boolean optBoolean2 = jSONObject.optBoolean("showDanmuBtn", true);
        boolean optBoolean3 = jSONObject.optBoolean("enableDanmu", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("danmuList");
        String optString = jSONObject.optString("objectFit");
        String optString2 = jSONObject.optString("poster");
        boolean optBoolean4 = jSONObject.optBoolean("showBasicControls", true);
        String optString3 = jSONObject.optString("data");
        int optInt = jSONObject.optInt(TencentLocation.EXTRA_DIRECTION, -1);
        boolean optBoolean5 = jSONObject.optBoolean("loop", false);
        boolean optBoolean6 = jSONObject.optBoolean("pageGesture", false);
        boolean optBoolean7 = jSONObject.optBoolean("pageGestureInFullscreen", true);
        double optDouble = jSONObject.optDouble("initialTime", 0.0d);
        boolean optBoolean8 = jSONObject.optBoolean("showProgress", true);
        boolean optBoolean9 = jSONObject.optBoolean("showFullScreenBtn", true);
        boolean optBoolean10 = jSONObject.optBoolean("showPlayBtn", true);
        boolean optBoolean11 = jSONObject.optBoolean("showCenterPlayBtn", true);
        boolean optBoolean12 = jSONObject.optBoolean("enableProgressGesture", true);
        String optString4 = jSONObject.optString("scene", "default");
        boolean optBoolean13 = jSONObject.optBoolean("showMuteBtn", false);
        String optString5 = jSONObject.optString("title", "");
        boolean optBoolean14 = jSONObject.optBoolean("showControlProgress", true);
        String optString6 = jSONObject.optString("playBtnPosition", "bottom");
        boolean optBoolean15 = jSONObject.optBoolean("enablePlayGesture", false);
        boolean optBoolean16 = jSONObject.optBoolean("autoPauseIfNavigate", true);
        boolean optBoolean17 = jSONObject.optBoolean("autoPauseIfOpenNative", true);
        appBrandVideoView.setComponent(c33303e);
        appBrandVideoView.setCookieData(optString3);
        appBrandVideoView.setIsShowBasicControls(optBoolean4);
        appBrandVideoView.setCover$16da05f7(optString2);
        appBrandVideoView.setFullScreenDirection(optInt);
        appBrandVideoView.setObjectFit(optString);
        appBrandVideoView.setLoop(optBoolean5);
        appBrandVideoView.setPageGesture(optBoolean6);
        appBrandVideoView.setPageGestureInFullscreen(optBoolean7);
        try {
            appBrandVideoView.setVideoPlayerId(mo6130r(jSONObject));
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", e);
        }
        appBrandVideoView.setAutoPlay(r7);
        appBrandVideoView.setShowDanmakuBtn(optBoolean2);
        appBrandVideoView.setDanmakuEnable(optBoolean3);
        appBrandVideoView.setDanmakuItemList(optJSONArray);
        appBrandVideoView.setInitialTime(optDouble);
        appBrandVideoView.setShowControlProgress(optBoolean14);
        appBrandVideoView.setShowProgress(optBoolean8);
        appBrandVideoView.setShowFullScreenBtn(optBoolean9);
        appBrandVideoView.setShowPlayBtn(optBoolean10);
        appBrandVideoView.setShowCenterPlayBtn(optBoolean11);
        appBrandVideoView.mo34626eq(optBoolean12);
        if (optString4.equalsIgnoreCase("default")) {
            appBrandVideoView.setVideoSource(0);
        } else {
            appBrandVideoView.setVideoSource(1);
        }
        appBrandVideoView.setShowMuteBtn(optBoolean13);
        appBrandVideoView.setTitle(optString5);
        appBrandVideoView.setPlayBtnPosition(optString6);
        appBrandVideoView.setEnablePlayGesture(optBoolean15);
        appBrandVideoView.setAutoPauseIfNavigate(optBoolean16);
        appBrandVideoView.setAutoPauseIfOpenNative(optBoolean17);
        if (optBoolean) {
            appBrandVideoView.setCallback(new C33404k(appBrandVideoView, c33303e));
        }
        int optInt2 = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, -1);
        C4990ab.m7417i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", jSONObject.optString("filePath"), Boolean.valueOf(jSONObject.optBoolean("live", false)));
        appBrandVideoView.mo34625e(r5, r7, optInt2);
        AppMethodBeat.m2505o(126558);
    }
}
