package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;
import java.math.BigDecimal;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 364;
    public static final String NAME = "insertLivePlayer";

    static final class c extends ah {
        private static final int CTRL_INDEX = 369;
        private static final String NAME = "onLivePlayerEvent";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    static final class b extends ah {
        private static final int CTRL_INDEX = 412;
        private static final String NAME = "onLivePlayerNetStatus";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class a extends ah {
        private static final int CTRL_INDEX = 371;
        private static final String NAME = "onLivePlayerFullScreenChange";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(96081);
        j.aDJ();
        if (jSONObject.optInt("mode", 0) != 2) {
            super.a(cVar, jSONObject, i);
            AppMethodBeat.o(96081);
        } else if (cVar.getContext() instanceof Activity) {
            try {
                if (android.support.v4.content.b.checkSelfPermission((Activity) cVar.getContext(), "android.permission.RECORD_AUDIO") == 0) {
                    super.a(cVar, jSONObject, i);
                    AppMethodBeat.o(96081);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10001));
                cVar.M(i, j("fail:system permission denied", hashMap));
                AppMethodBeat.o(96081);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", e);
                cVar.M(i, j("fail", null));
                AppMethodBeat.o(96081);
            }
        } else {
            ab.w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(96081);
        }
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(96082);
        int i = jSONObject.getInt("livePlayerId");
        AppMethodBeat.o(96082);
        return i;
    }

    public final View a(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(96083);
        CoverViewContainer coverViewContainer = new CoverViewContainer(eVar.getContext(), new AppBrandLivePlayerView(eVar.getContext()));
        coverViewContainer.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.o(96083);
        return coverViewContainer;
    }

    public final void a(final e eVar, final int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(96084);
        ab.i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[]{eVar.getAppId()}));
            final AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) ((CoverViewContainer) view).ah(AppBrandLivePlayerView.class);
            final AnonymousClass1 anonymousClass1 = new an() {
                public final void aDI() {
                    AppMethodBeat.i(96070);
                    AppBrandLivePlayerView appBrandLivePlayerView = appBrandLivePlayerView;
                    ab.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
                    appBrandLivePlayerView.dZ(false);
                    AppMethodBeat.o(96070);
                }
            };
            final AnonymousClass2 anonymousClass2 = new d() {
                public final void wU() {
                    i Bd;
                    AppMethodBeat.i(96071);
                    k kVar = appBrandLivePlayerView.hLb;
                    if (kVar.hLO) {
                        Bd = kVar.Bd("resume");
                    } else {
                        Bd = new i();
                    }
                    ab.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", Integer.valueOf(Bd.errorCode), Bd.hLF);
                    AppMethodBeat.o(96071);
                }
            };
            final AnonymousClass3 anonymousClass3 = new com.tencent.mm.plugin.appbrand.jsapi.f.b() {
                public final void wW() {
                    AppMethodBeat.i(96072);
                    g.d wV = g.wV(eVar.getAppId());
                    ab.i("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", wV.name());
                    if (wV == g.d.LAUNCH_NATIVE_PAGE) {
                        appBrandLivePlayerView.om(2);
                        AppMethodBeat.o(96072);
                    } else if (wV == g.d.HIDE) {
                        appBrandLivePlayerView.om(1);
                        AppMethodBeat.o(96072);
                    } else {
                        appBrandLivePlayerView.om(3);
                        AppMethodBeat.o(96072);
                    }
                }
            };
            AnonymousClass4 anonymousClass4 = new com.tencent.mm.plugin.appbrand.jsapi.f.c() {
                public final void onDestroy() {
                    AppMethodBeat.i(96073);
                    appBrandLivePlayerView.onExit();
                    eVar.b((com.tencent.mm.plugin.appbrand.jsapi.f.c) this);
                    AppMethodBeat.o(96073);
                }
            };
            eVar.a((d) anonymousClass2);
            eVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.b) anonymousClass3);
            eVar.a((com.tencent.mm.plugin.appbrand.jsapi.f.c) anonymousClass4);
            appBrandLivePlayerView.setFullScreenDelegate(new com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.a() {
                public final void on(int i) {
                    AppMethodBeat.i(96074);
                    eVar.aBf().a(i, anonymousClass1, i);
                    AppMethodBeat.o(96074);
                }

                public final void aDF() {
                    AppMethodBeat.i(96075);
                    eVar.aBf().pC(i);
                    AppMethodBeat.o(96075);
                }

                public final boolean isFullScreen() {
                    AppMethodBeat.i(96076);
                    boolean pB = eVar.aBf().pB(i);
                    AppMethodBeat.o(96076);
                    return pB;
                }
            });
            appBrandLivePlayerView.setExitListener(new com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.b() {
                public final void aDG() {
                    AppMethodBeat.i(96077);
                    eVar.b(anonymousClass3);
                    eVar.b(anonymousClass2);
                    AppMethodBeat.o(96077);
                }
            });
            appBrandLivePlayerView.setNeedEvent(jSONObject.optBoolean("needEvent", false));
            appBrandLivePlayerView.setOnFullScreenChangeListener(new com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.c() {
                public final void i(boolean z, int i) {
                    AppMethodBeat.i(96078);
                    a aVar = new a();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("fullScreen", z);
                        jSONObject.put(TencentLocation.EXTRA_DIRECTION, i);
                        jSONObject.put("livePlayerId", i);
                    } catch (JSONException e) {
                    }
                    eVar.b(aVar.AM(jSONObject.toString()));
                    AppMethodBeat.o(96078);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("playUrl", jSONObject.optString("playUrl"));
            bundle.putInt("mode", jSONObject.optInt("mode", 0));
            bundle.putBoolean("autoplay", jSONObject.optBoolean("autoplay", false));
            bundle.putBoolean("muted", jSONObject.optBoolean("muted", false));
            bundle.putString("orientation", jSONObject.optString("orientation"));
            bundle.putString("objectFit", jSONObject.optString("objectFit"));
            bundle.putBoolean("backgroundMute", jSONObject.optBoolean("backgroundMute", true));
            bundle.putFloat("minCache", BigDecimal.valueOf(jSONObject.optDouble("minCache", 1.0d)).floatValue());
            bundle.putFloat("maxCache", BigDecimal.valueOf(jSONObject.optDouble("maxCache", 3.0d)).floatValue());
            bundle.putBoolean("needEvent", jSONObject.optBoolean("needEvent", false));
            bundle.putBoolean("debug", jSONObject.optBoolean("debug", false));
            bundle.putString("soundMode", jSONObject.optString("soundMode", "speaker"));
            bundle.putBoolean("autoPauseIfNavigate", jSONObject.optBoolean("autoPauseIfNavigate", true));
            bundle.putBoolean("autoPauseIfOpenNative", jSONObject.optBoolean("autoPauseIfOpenNative", true));
            ab.i("MicroMsg.JsApiInsertLivePlayer", "convertParams playUrl:%s", jSONObject.optString("playUrl"));
            k kVar = appBrandLivePlayerView.hLb;
            k.l("initLivePlayer", bundle);
            kVar.hLH = appBrandLivePlayerView;
            kVar.hLH.disableLog(false);
            kVar.hLJ.setPlayerView(appBrandLivePlayerView);
            kVar.hLM = bundle.getString("playUrl", kVar.hLM);
            kVar.hLN = kVar.z(bundle);
            kVar.A(bundle);
            kVar.mAutoPlay = bundle.getBoolean("autoplay", kVar.mAutoPlay);
            if (!(!kVar.mAutoPlay || kVar.hLM == null || kVar.hLM.isEmpty())) {
                ab.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
                kVar.Be(kVar.hLM);
                kVar.hLJ.startPlay(kVar.hLM, kVar.hLN);
            }
            kVar.mInited = true;
            i iVar = new i();
            ab.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.hLF);
            appBrandLivePlayerView.setPlayEventListener(new ITXLivePlayListener() {
                public final void onPlayEvent(int i, Bundle bundle) {
                    AppMethodBeat.i(96079);
                    ab.i("MicroMsg.JsApiInsertLivePlayer", "onPlayEvent errCode:%d", Integer.valueOf(i));
                    c cVar = new c();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("errMsg", bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
                        jSONObject.put("livePlayerId", i);
                    } catch (JSONException e) {
                    }
                    eVar.b(cVar.AM(jSONObject.toString()));
                    AppMethodBeat.o(96079);
                }

                public final void onNetStatus(Bundle bundle) {
                    AppMethodBeat.i(96080);
                    b bVar = new b();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("livePlayerId", i);
                        JSONObject jSONObject2 = new JSONObject();
                        if (bundle != null) {
                            for (String str : bundle.keySet()) {
                                jSONObject2.put(str, bundle.get(str));
                            }
                        }
                        jSONObject.put("info", jSONObject2);
                    } catch (JSONException e) {
                    }
                    eVar.b(bVar.AM(jSONObject.toString()));
                    AppMethodBeat.o(96080);
                }
            });
            appBrandLivePlayerView.setContentDescription(bundle.getInt("mode", 0) == 5 ? view.getContext().getString(R.string.g8) : view.getContext().getString(R.string.g7));
            AppMethodBeat.o(96084);
            return;
        }
        ab.w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(96084);
    }
}
