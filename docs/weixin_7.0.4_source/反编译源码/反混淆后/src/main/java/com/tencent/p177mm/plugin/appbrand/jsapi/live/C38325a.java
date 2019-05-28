package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.support.p057v4.content.C0380b;
import android.view.View;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.C2301c;
import com.tencent.p177mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.C33347b;
import com.tencent.p177mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.C38324a;
import com.tencent.p177mm.plugin.appbrand.page.C38462an;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;
import java.math.BigDecimal;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.a */
public final class C38325a extends C45577a {
    private static final int CTRL_INDEX = 364;
    public static final String NAME = "insertLivePlayer";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.a$c */
    static final class C10452c extends C42467ah {
        private static final int CTRL_INDEX = 369;
        private static final String NAME = "onLivePlayerEvent";

        private C10452c() {
        }

        /* synthetic */ C10452c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.a$b */
    static final class C27020b extends C42467ah {
        private static final int CTRL_INDEX = 412;
        private static final String NAME = "onLivePlayerNetStatus";

        private C27020b() {
        }

        /* synthetic */ C27020b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.a$a */
    static final class C38327a extends C42467ah {
        private static final int CTRL_INDEX = 371;
        private static final String NAME = "onLivePlayerFullScreenChange";

        private C38327a() {
        }

        /* synthetic */ C38327a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(96081);
        C38335j.aDJ();
        if (jSONObject.optInt("mode", 0) != 2) {
            super.mo5994a(c2241c, jSONObject, i);
            AppMethodBeat.m2505o(96081);
        } else if (c2241c.getContext() instanceof Activity) {
            try {
                if (C0380b.checkSelfPermission((Activity) c2241c.getContext(), "android.permission.RECORD_AUDIO") == 0) {
                    super.mo5994a(c2241c, jSONObject, i);
                    AppMethodBeat.m2505o(96081);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10001));
                c2241c.mo6107M(i, mo73394j("fail:system permission denied", hashMap));
                AppMethodBeat.m2505o(96081);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", e);
                c2241c.mo6107M(i, mo73394j("fail", null));
                AppMethodBeat.m2505o(96081);
            }
        } else {
            C4990ab.m7420w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(96081);
        }
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(96082);
        int i = jSONObject.getInt("livePlayerId");
        AppMethodBeat.m2505o(96082);
        return i;
    }

    /* renamed from: a */
    public final View mo6126a(C33303e c33303e, JSONObject jSONObject) {
        AppMethodBeat.m2504i(96083);
        CoverViewContainer coverViewContainer = new CoverViewContainer(c33303e.getContext(), new AppBrandLivePlayerView(c33303e.getContext()));
        coverViewContainer.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.m2505o(96083);
        return coverViewContainer;
    }

    /* renamed from: a */
    public final void mo6140a(final C33303e c33303e, final int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(96084);
        C4990ab.m7417i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[]{c33303e.getAppId()}));
            final AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) ((CoverViewContainer) view).mo60996ah(AppBrandLivePlayerView.class);
            final C194191 c194191 = new C38462an() {
                public final void aDI() {
                    AppMethodBeat.m2504i(96070);
                    AppBrandLivePlayerView appBrandLivePlayerView = appBrandLivePlayerView;
                    C4990ab.m7416i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
                    appBrandLivePlayerView.mo67994dZ(false);
                    AppMethodBeat.m2505o(96070);
                }
            };
            final C23022 c23022 = new C10381d() {
                /* renamed from: wU */
                public final void mo6095wU() {
                    C33353i Bd;
                    AppMethodBeat.m2504i(96071);
                    C38336k c38336k = appBrandLivePlayerView.hLb;
                    if (c38336k.hLO) {
                        Bd = c38336k.mo61009Bd("resume");
                    } else {
                        Bd = new C33353i();
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", Integer.valueOf(Bd.errorCode), Bd.hLF);
                    AppMethodBeat.m2505o(96071);
                }
            };
            final C333493 c333493 = new C10379b() {
                /* renamed from: wW */
                public final void mo21857wW() {
                    AppMethodBeat.m2504i(96072);
                    C33184d wV = C33183g.m54286wV(c33303e.getAppId());
                    C4990ab.m7417i("MicroMsg.JsApiInsertLivePlayer", "LivePlayer enter background, pause type:%s", wV.name());
                    if (wV == C33184d.LAUNCH_NATIVE_PAGE) {
                        appBrandLivePlayerView.mo67995om(2);
                        AppMethodBeat.m2505o(96072);
                    } else if (wV == C33184d.HIDE) {
                        appBrandLivePlayerView.mo67995om(1);
                        AppMethodBeat.m2505o(96072);
                    } else {
                        appBrandLivePlayerView.mo67995om(3);
                        AppMethodBeat.m2505o(96072);
                    }
                }
            };
            C333504 c333504 = new C10380c() {
                public final void onDestroy() {
                    AppMethodBeat.m2504i(96073);
                    appBrandLivePlayerView.onExit();
                    c33303e.mo53833b((C10380c) this);
                    AppMethodBeat.m2505o(96073);
                }
            };
            c33303e.mo53829a((C10381d) c23022);
            c33303e.mo53827a((C10379b) c333493);
            c33303e.mo53828a((C10380c) c333504);
            appBrandLivePlayerView.setFullScreenDelegate(new C38324a() {
                /* renamed from: on */
                public final void mo61006on(int i) {
                    AppMethodBeat.m2504i(96074);
                    c33303e.aBf().mo73441a(i, c194191, i);
                    AppMethodBeat.m2505o(96074);
                }

                public final void aDF() {
                    AppMethodBeat.m2504i(96075);
                    c33303e.aBf().mo73448pC(i);
                    AppMethodBeat.m2505o(96075);
                }

                public final boolean isFullScreen() {
                    AppMethodBeat.m2504i(96076);
                    boolean pB = c33303e.aBf().mo73447pB(i);
                    AppMethodBeat.m2505o(96076);
                    return pB;
                }
            });
            appBrandLivePlayerView.setExitListener(new C33347b() {
                public final void aDG() {
                    AppMethodBeat.m2504i(96077);
                    c33303e.mo53832b(c333493);
                    c33303e.mo53834b(c23022);
                    AppMethodBeat.m2505o(96077);
                }
            });
            appBrandLivePlayerView.setNeedEvent(jSONObject.optBoolean("needEvent", false));
            appBrandLivePlayerView.setOnFullScreenChangeListener(new C2301c() {
                /* renamed from: i */
                public final void mo6171i(boolean z, int i) {
                    AppMethodBeat.m2504i(96078);
                    C38327a c38327a = new C38327a();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("fullScreen", z);
                        jSONObject.put(TencentLocation.EXTRA_DIRECTION, i);
                        jSONObject.put("livePlayerId", i);
                    } catch (JSONException e) {
                    }
                    c33303e.mo6115b(c38327a.mo61028AM(jSONObject.toString()));
                    AppMethodBeat.m2505o(96078);
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
            C4990ab.m7417i("MicroMsg.JsApiInsertLivePlayer", "convertParams playUrl:%s", jSONObject.optString("playUrl"));
            C38336k c38336k = appBrandLivePlayerView.hLb;
            C38336k.m64874l("initLivePlayer", bundle);
            c38336k.hLH = appBrandLivePlayerView;
            c38336k.hLH.disableLog(false);
            c38336k.hLJ.setPlayerView(appBrandLivePlayerView);
            c38336k.hLM = bundle.getString("playUrl", c38336k.hLM);
            c38336k.hLN = c38336k.mo61011z(bundle);
            c38336k.mo61008A(bundle);
            c38336k.mAutoPlay = bundle.getBoolean("autoplay", c38336k.mAutoPlay);
            if (!(!c38336k.mAutoPlay || c38336k.hLM == null || c38336k.hLM.isEmpty())) {
                C4990ab.m7416i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
                c38336k.mo61010Be(c38336k.hLM);
                c38336k.hLJ.startPlay(c38336k.hLM, c38336k.hLN);
            }
            c38336k.mInited = true;
            C33353i c33353i = new C33353i();
            C4990ab.m7417i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", Integer.valueOf(c33353i.errorCode), c33353i.hLF);
            appBrandLivePlayerView.setPlayEventListener(new ITXLivePlayListener() {
                public final void onPlayEvent(int i, Bundle bundle) {
                    AppMethodBeat.m2504i(96079);
                    C4990ab.m7417i("MicroMsg.JsApiInsertLivePlayer", "onPlayEvent errCode:%d", Integer.valueOf(i));
                    C10452c c10452c = new C10452c();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("errMsg", bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
                        jSONObject.put("livePlayerId", i);
                    } catch (JSONException e) {
                    }
                    c33303e.mo6115b(c10452c.mo61028AM(jSONObject.toString()));
                    AppMethodBeat.m2505o(96079);
                }

                public final void onNetStatus(Bundle bundle) {
                    AppMethodBeat.m2504i(96080);
                    C27020b c27020b = new C27020b();
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
                    c33303e.mo6115b(c27020b.mo61028AM(jSONObject.toString()));
                    AppMethodBeat.m2505o(96080);
                }
            });
            appBrandLivePlayerView.setContentDescription(bundle.getInt("mode", 0) == 5 ? view.getContext().getString(C25738R.string.f8830g8) : view.getContext().getString(C25738R.string.f8829g7));
            AppMethodBeat.m2505o(96084);
            return;
        }
        C4990ab.m7421w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(96084);
    }
}
