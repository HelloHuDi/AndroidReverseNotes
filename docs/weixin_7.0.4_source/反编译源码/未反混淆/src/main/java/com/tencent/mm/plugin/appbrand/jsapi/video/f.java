package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.view.View;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends a {
    private static final int CTRL_INDEX = 6;
    public static final String NAME = "insertVideoPlayer";

    public final View a(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(126556);
        Context context = eVar.getContext();
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, AppBrandVideoView.aEW().cM(context));
        AppMethodBeat.o(126556);
        return coverViewContainer;
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126557);
        int i = jSONObject.getInt("videoPlayerId");
        AppMethodBeat.o(126557);
        return i;
    }

    public final void a(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126558);
        ab.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", Integer.valueOf(i));
        final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).ah(AppBrandVideoView.class);
        if (appBrandVideoView == null) {
            ab.e("MicroMsg.JsApiInsertVideoPlayer", "onInsertView appBrandVideoView null");
            AppMethodBeat.o(126558);
            return;
        }
        final AnonymousClass1 anonymousClass1 = new an() {
            public final void aDI() {
                AppMethodBeat.i(126549);
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                ab.i("MicroMsg.AppBrandVideoView", "onExitFullScreen");
                if (appBrandVideoView.hYP.aFI()) {
                    appBrandVideoView.hYP.aDF();
                }
                appBrandVideoView.er(false);
                AppMethodBeat.o(126549);
            }
        };
        final AnonymousClass2 anonymousClass2 = new d() {
            public final void wU() {
                AppMethodBeat.i(126550);
                appBrandVideoView.akW();
                AppMethodBeat.o(126550);
            }
        };
        final e eVar2 = eVar;
        final AnonymousClass3 anonymousClass3 = new b() {
            public final void wW() {
                AppMethodBeat.i(126551);
                g.d wV = g.wV(eVar2.getAppId());
                ab.i("MicroMsg.JsApiInsertVideoPlayer", "VideoPlayer enter background, pause type:%s", wV.name());
                if (wV == g.d.LAUNCH_NATIVE_PAGE) {
                    appBrandVideoView.ow(2);
                    AppMethodBeat.o(126551);
                } else if (wV == g.d.HIDE) {
                    appBrandVideoView.ow(1);
                    AppMethodBeat.o(126551);
                } else {
                    appBrandVideoView.ow(3);
                    AppMethodBeat.o(126551);
                }
            }
        };
        final e eVar3 = eVar;
        AnonymousClass4 anonymousClass4 = new c() {
            public final void onDestroy() {
                AppMethodBeat.i(126552);
                appBrandVideoView.aEX();
                eVar3.b(anonymousClass2);
                eVar3.b(anonymousClass3);
                eVar3.b((c) this);
                AppMethodBeat.o(126552);
            }
        };
        eVar.a((d) anonymousClass2);
        eVar.a((b) anonymousClass3);
        eVar.a((c) anonymousClass4);
        eVar2 = eVar;
        final int i2 = i;
        appBrandVideoView.setFullScreenDelegate(new AppBrandVideoView.a() {
            public final void on(int i) {
                AppMethodBeat.i(126553);
                eVar2.aBf().a(i2, anonymousClass1, i);
                AppMethodBeat.o(126553);
            }

            public final void aDF() {
                AppMethodBeat.i(126554);
                eVar2.aBf().pC(i2);
                AppMethodBeat.o(126554);
            }

            public final boolean isFullScreen() {
                AppMethodBeat.i(126555);
                boolean pB = eVar2.aBf().pB(i2);
                AppMethodBeat.o(126555);
                return pB;
            }
        });
        appBrandVideoView.setContentDescription(view.getContext().getString(R.string.ga));
        appBrandVideoView.setMute(jSONObject.optBoolean("muted", false));
        boolean optBoolean = jSONObject.optBoolean("needEvent", false);
        ab.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", Boolean.valueOf(jSONObject.optBoolean("autoplay", false)), Boolean.valueOf(optBoolean));
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
        appBrandVideoView.setComponent(eVar);
        appBrandVideoView.setCookieData(optString3);
        appBrandVideoView.setIsShowBasicControls(optBoolean4);
        appBrandVideoView.setCover$16da05f7(optString2);
        appBrandVideoView.setFullScreenDirection(optInt);
        appBrandVideoView.setObjectFit(optString);
        appBrandVideoView.setLoop(optBoolean5);
        appBrandVideoView.setPageGesture(optBoolean6);
        appBrandVideoView.setPageGestureInFullscreen(optBoolean7);
        try {
            appBrandVideoView.setVideoPlayerId(r(jSONObject));
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", e);
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
        appBrandVideoView.eq(optBoolean12);
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
            appBrandVideoView.setCallback(new k(appBrandVideoView, eVar));
        }
        int optInt2 = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, -1);
        ab.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", jSONObject.optString("filePath"), Boolean.valueOf(jSONObject.optBoolean("live", false)));
        appBrandVideoView.e(r5, r7, optInt2);
        AppMethodBeat.o(126558);
    }
}
