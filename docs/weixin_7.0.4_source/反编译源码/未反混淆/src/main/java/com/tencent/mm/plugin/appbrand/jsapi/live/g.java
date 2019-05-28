package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends c {
    private static final int CTRL_INDEX = 365;
    public static final String NAME = "updateLivePlayer";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(96120);
        int optInt = jSONObject.optInt("livePlayerId");
        AppMethodBeat.o(96120);
        return optInt;
    }

    public final boolean c(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(96121);
        ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).ah(View.class);
            if (view2 instanceof AppBrandLivePlayerView) {
                i iVar;
                AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) view2;
                Bundle A = A(jSONObject);
                appBrandLivePlayerView.hLf = A.getBoolean("needEvent", appBrandLivePlayerView.hLf);
                k kVar = appBrandLivePlayerView.hLb;
                if (kVar.mInited) {
                    k.l(NAME, A);
                    kVar.A(A);
                    boolean isPlaying = kVar.hLJ.isPlaying();
                    String string = A.getString("playUrl", kVar.hLM);
                    if (!(string == null || string.isEmpty() || kVar.hLM == null || kVar.hLM.equalsIgnoreCase(string) || !kVar.hLJ.isPlaying())) {
                        ab.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + kVar.hLM + " playUrl-new = " + string);
                        kVar.hLJ.stopPlay(true);
                    }
                    kVar.hLM = string;
                    int z = kVar.z(A);
                    if (z != kVar.hLN && kVar.hLJ.isPlaying()) {
                        ab.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + kVar.hLN + " playType-new = " + z);
                        kVar.hLJ.stopPlay(true);
                    }
                    kVar.hLN = z;
                    kVar.mAutoPlay = A.getBoolean("autoplay", kVar.mAutoPlay);
                    if (!((!kVar.mAutoPlay && !isPlaying) || kVar.hLM == null || kVar.hLM.isEmpty() || kVar.hLJ.isPlaying())) {
                        ab.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
                        kVar.Be(kVar.hLM);
                        kVar.hLJ.startPlay(kVar.hLM, kVar.hLN);
                    }
                    iVar = new i();
                } else {
                    iVar = new i(-3, "uninited livePlayer");
                }
                ab.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.hLF);
                AppMethodBeat.o(96121);
                return true;
            }
            ab.e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
            AppMethodBeat.o(96121);
            return false;
        }
        ab.w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(96121);
        return false;
    }

    private static Bundle A(JSONObject jSONObject) {
        AppMethodBeat.i(96122);
        Bundle bundle = new Bundle();
        try {
            if (jSONObject.has("playUrl")) {
                bundle.putString("playUrl", jSONObject.getString("playUrl"));
                ab.i("MicroMsg.JsApiUpdateLivePlayer", "convertParams playUrl:%s", jSONObject.getString("playUrl"));
            }
        } catch (JSONException e) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "playUrl", e.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mode")) {
                bundle.putInt("mode", jSONObject.getInt("mode"));
            }
        } catch (JSONException e2) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "mode", e2.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoplay")) {
                bundle.putBoolean("autoplay", jSONObject.getBoolean("autoplay"));
            }
        } catch (JSONException e22) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "autoplay", e22.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muted")) {
                bundle.putBoolean("muted", jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "muted", e222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("orientation")) {
                bundle.putString("orientation", jSONObject.getString("orientation"));
            }
        } catch (JSONException e2222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "orientation", e2222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("objectFit")) {
                bundle.putString("objectFit", jSONObject.getString("objectFit"));
            }
        } catch (JSONException e22222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "objectFit", e22222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("backgroundMute")) {
                bundle.putBoolean("backgroundMute", jSONObject.getBoolean("backgroundMute"));
            }
        } catch (JSONException e222222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "backgroundMute", e222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("minCache")) {
                bundle.putFloat("minCache", BigDecimal.valueOf(jSONObject.getDouble("minCache")).floatValue());
            }
        } catch (JSONException e2222222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "minCache", e2222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("maxCache")) {
                bundle.putFloat("maxCache", BigDecimal.valueOf(jSONObject.getDouble("maxCache")).floatValue());
            }
        } catch (JSONException e22222222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "maxCache", e22222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needEvent")) {
                bundle.putBoolean("needEvent", jSONObject.getBoolean("needEvent"));
            }
        } catch (JSONException e222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "needEvent", e222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("debug")) {
                bundle.putBoolean("debug", jSONObject.getBoolean("debug"));
            }
        } catch (JSONException e2222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "debug", e2222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("soundMode")) {
                bundle.putString("soundMode", jSONObject.getString("soundMode"));
                ab.i("MicroMsg.JsApiUpdateLivePlayer", "convertParams soundMode:%s", jSONObject.getString("soundMode"));
            }
        } catch (JSONException e22222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "soundMode", e22222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfNavigate")) {
                bundle.putBoolean("autoPauseIfNavigate", jSONObject.getBoolean("autoPauseIfNavigate"));
            }
        } catch (JSONException e222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "autoPauseIfNavigate", e222222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfOpenNative")) {
                bundle.putBoolean("autoPauseIfOpenNative", jSONObject.getBoolean("autoPauseIfOpenNative"));
            }
        } catch (JSONException e2222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", "autoPauseIfOpenNative", e2222222222222.getLocalizedMessage());
        }
        AppMethodBeat.o(96122);
        return bundle;
    }
}
