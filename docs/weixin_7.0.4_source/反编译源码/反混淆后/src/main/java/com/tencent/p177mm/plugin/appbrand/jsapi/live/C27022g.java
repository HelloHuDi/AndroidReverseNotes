package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.g */
public final class C27022g extends C45578c {
    private static final int CTRL_INDEX = 365;
    public static final String NAME = "updateLivePlayer";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(96120);
        int optInt = jSONObject.optInt("livePlayerId");
        AppMethodBeat.m2505o(96120);
        return optInt;
    }

    /* renamed from: c */
    public final boolean mo6167c(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(96121);
        C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).mo60996ah(View.class);
            if (view2 instanceof AppBrandLivePlayerView) {
                C33353i c33353i;
                AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) view2;
                Bundle A = C27022g.m42966A(jSONObject);
                appBrandLivePlayerView.hLf = A.getBoolean("needEvent", appBrandLivePlayerView.hLf);
                C38336k c38336k = appBrandLivePlayerView.hLb;
                if (c38336k.mInited) {
                    C38336k.m64874l(NAME, A);
                    c38336k.mo61008A(A);
                    boolean isPlaying = c38336k.hLJ.isPlaying();
                    String string = A.getString("playUrl", c38336k.hLM);
                    if (!(string == null || string.isEmpty() || c38336k.hLM == null || c38336k.hLM.equalsIgnoreCase(string) || !c38336k.hLJ.isPlaying())) {
                        C4990ab.m7416i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + c38336k.hLM + " playUrl-new = " + string);
                        c38336k.hLJ.stopPlay(true);
                    }
                    c38336k.hLM = string;
                    int z = c38336k.mo61011z(A);
                    if (z != c38336k.hLN && c38336k.hLJ.isPlaying()) {
                        C4990ab.m7416i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + c38336k.hLN + " playType-new = " + z);
                        c38336k.hLJ.stopPlay(true);
                    }
                    c38336k.hLN = z;
                    c38336k.mAutoPlay = A.getBoolean("autoplay", c38336k.mAutoPlay);
                    if (!((!c38336k.mAutoPlay && !isPlaying) || c38336k.hLM == null || c38336k.hLM.isEmpty() || c38336k.hLJ.isPlaying())) {
                        C4990ab.m7416i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
                        c38336k.mo61010Be(c38336k.hLM);
                        c38336k.hLJ.startPlay(c38336k.hLM, c38336k.hLN);
                    }
                    c33353i = new C33353i();
                } else {
                    c33353i = new C33353i(-3, "uninited livePlayer");
                }
                C4990ab.m7417i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", Integer.valueOf(c33353i.errorCode), c33353i.hLF);
                AppMethodBeat.m2505o(96121);
                return true;
            }
            C4990ab.m7412e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
            AppMethodBeat.m2505o(96121);
            return false;
        }
        C4990ab.m7421w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(96121);
        return false;
    }

    /* renamed from: A */
    private static Bundle m42966A(JSONObject jSONObject) {
        AppMethodBeat.m2504i(96122);
        Bundle bundle = new Bundle();
        try {
            if (jSONObject.has("playUrl")) {
                bundle.putString("playUrl", jSONObject.getString("playUrl"));
                C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "convertParams playUrl:%s", jSONObject.getString("playUrl"));
            }
        } catch (JSONException e) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "playUrl", e.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mode")) {
                bundle.putInt("mode", jSONObject.getInt("mode"));
            }
        } catch (JSONException e2) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "mode", e2.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoplay")) {
                bundle.putBoolean("autoplay", jSONObject.getBoolean("autoplay"));
            }
        } catch (JSONException e22) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "autoplay", e22.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muted")) {
                bundle.putBoolean("muted", jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "muted", e222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("orientation")) {
                bundle.putString("orientation", jSONObject.getString("orientation"));
            }
        } catch (JSONException e2222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "orientation", e2222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("objectFit")) {
                bundle.putString("objectFit", jSONObject.getString("objectFit"));
            }
        } catch (JSONException e22222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "objectFit", e22222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("backgroundMute")) {
                bundle.putBoolean("backgroundMute", jSONObject.getBoolean("backgroundMute"));
            }
        } catch (JSONException e222222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "backgroundMute", e222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("minCache")) {
                bundle.putFloat("minCache", BigDecimal.valueOf(jSONObject.getDouble("minCache")).floatValue());
            }
        } catch (JSONException e2222222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "minCache", e2222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("maxCache")) {
                bundle.putFloat("maxCache", BigDecimal.valueOf(jSONObject.getDouble("maxCache")).floatValue());
            }
        } catch (JSONException e22222222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "maxCache", e22222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needEvent")) {
                bundle.putBoolean("needEvent", jSONObject.getBoolean("needEvent"));
            }
        } catch (JSONException e222222222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "needEvent", e222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("debug")) {
                bundle.putBoolean("debug", jSONObject.getBoolean("debug"));
            }
        } catch (JSONException e2222222222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "debug", e2222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("soundMode")) {
                bundle.putString("soundMode", jSONObject.getString("soundMode"));
                C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "convertParams soundMode:%s", jSONObject.getString("soundMode"));
            }
        } catch (JSONException e22222222222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "soundMode", e22222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfNavigate")) {
                bundle.putBoolean("autoPauseIfNavigate", jSONObject.getBoolean("autoPauseIfNavigate"));
            }
        } catch (JSONException e222222222222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "autoPauseIfNavigate", e222222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfOpenNative")) {
                bundle.putBoolean("autoPauseIfOpenNative", jSONObject.getBoolean("autoPauseIfOpenNative"));
            }
        } catch (JSONException e2222222222222) {
            C4990ab.m7417i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "autoPauseIfOpenNative", e2222222222222.getLocalizedMessage());
        }
        AppMethodBeat.m2505o(96122);
        return bundle;
    }
}
