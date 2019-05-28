package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends c {
    private static final int CTRL_INDEX = 114;
    public static final String NAME = "operateVideoPlayer";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(126563);
        int optInt = jSONObject.optInt("videoPlayerId");
        AppMethodBeat.o(126563);
        return optInt;
    }

    public final boolean c(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(126564);
        ab.i("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView : videoPlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).ah(AppBrandVideoView.class);
            if (appBrandVideoView == null) {
                ab.e("MicroMsg.JsApiOperateVideoPlayer", "view not AppBrandVideoView");
                AppMethodBeat.o(126564);
                return false;
            }
            String optString = jSONObject.optString("type");
            ab.i("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView operateType=%s", optString);
            Object obj = -1;
            switch (optString.hashCode()) {
                case -802181223:
                    if (optString.equals("exitFullScreen")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1222225:
                    if (optString.equals("sendDanmu")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 3443508:
                    if (optString.equals("play")) {
                        obj = null;
                        break;
                    }
                    break;
                case 3526264:
                    if (optString.equals("seek")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 3540994:
                    if (optString.equals("stop")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 106440182:
                    if (optString.equals("pause")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 458133450:
                    if (optString.equals("requestFullScreen")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1355420059:
                    if (optString.equals("playbackRate")) {
                        obj = 5;
                        break;
                    }
                    break;
            }
            JSONArray optJSONArray;
            double optDouble;
            switch (obj) {
                case null:
                    appBrandVideoView.start();
                    break;
                case 1:
                    appBrandVideoView.pause();
                    break;
                case 2:
                    appBrandVideoView.stop();
                    break;
                case 3:
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("data");
                    int i2 = -1;
                    if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                        ab.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView directionArr nil");
                    } else {
                        i2 = optJSONArray2.optInt(0, -1);
                    }
                    appBrandVideoView.j(true, i2);
                    break;
                case 4:
                    appBrandVideoView.j(false, -1);
                    break;
                case 5:
                    optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        optDouble = optJSONArray.optDouble(0, -1.0d);
                        if (optDouble >= 0.0d) {
                            ab.i("MicroMsg.AppBrandVideoView", "setPlaybackRate %s", Float.valueOf((float) optDouble));
                            appBrandVideoView.hYM.as(r1);
                            break;
                        }
                        ab.i("MicroMsg.JsApiOperateVideoPlayer", "rate invalid %f", Double.valueOf(optDouble));
                        AppMethodBeat.o(126564);
                        return false;
                    }
                    ab.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
                    AppMethodBeat.o(126564);
                    return false;
                    break;
                case 6:
                    optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        optDouble = optJSONArray.optDouble(0, -1.0d);
                        if (optDouble >= 0.0d) {
                            appBrandVideoView.d(optDouble, false);
                            break;
                        }
                        ab.i("MicroMsg.JsApiOperateVideoPlayer", "pos invalid %s", Double.valueOf(optDouble));
                        AppMethodBeat.o(126564);
                        return false;
                    }
                    ab.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
                    AppMethodBeat.o(126564);
                    return false;
                    break;
                case 7:
                    optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        if (optJSONArray.length() != 1) {
                            appBrandVideoView.co(optJSONArray.optString(0, ""), optJSONArray.optString(1, ""));
                            break;
                        }
                        appBrandVideoView.co(optJSONArray.optString(0, ""), "");
                        break;
                    }
                    ab.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
                    AppMethodBeat.o(126564);
                    return false;
                    break;
                default:
                    ab.w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView operateType not supported: %s", optString);
                    AppMethodBeat.o(126564);
                    return false;
            }
            AppMethodBeat.o(126564);
            return true;
        }
        ab.w("MicroMsg.JsApiOperateVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(126564);
        return false;
    }
}
