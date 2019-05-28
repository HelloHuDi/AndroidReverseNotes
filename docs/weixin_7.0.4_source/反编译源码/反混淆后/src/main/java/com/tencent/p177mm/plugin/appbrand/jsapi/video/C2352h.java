package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.h */
public final class C2352h extends C45578c {
    private static final int CTRL_INDEX = 114;
    public static final String NAME = "operateVideoPlayer";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126563);
        int optInt = jSONObject.optInt("videoPlayerId");
        AppMethodBeat.m2505o(126563);
        return optInt;
    }

    /* renamed from: c */
    public final boolean mo6167c(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126564);
        C4990ab.m7417i("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView : videoPlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).mo60996ah(AppBrandVideoView.class);
            if (appBrandVideoView == null) {
                C4990ab.m7412e("MicroMsg.JsApiOperateVideoPlayer", "view not AppBrandVideoView");
                AppMethodBeat.m2505o(126564);
                return false;
            }
            String optString = jSONObject.optString("type");
            C4990ab.m7417i("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView operateType=%s", optString);
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
                        C4990ab.m7420w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView directionArr nil");
                    } else {
                        i2 = optJSONArray2.optInt(0, -1);
                    }
                    appBrandVideoView.mo34634j(true, i2);
                    break;
                case 4:
                    appBrandVideoView.mo34634j(false, -1);
                    break;
                case 5:
                    optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        optDouble = optJSONArray.optDouble(0, -1.0d);
                        if (optDouble >= 0.0d) {
                            C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setPlaybackRate %s", Float.valueOf((float) optDouble));
                            appBrandVideoView.hYM.mo61579as(r1);
                            break;
                        }
                        C4990ab.m7417i("MicroMsg.JsApiOperateVideoPlayer", "rate invalid %f", Double.valueOf(optDouble));
                        AppMethodBeat.m2505o(126564);
                        return false;
                    }
                    C4990ab.m7420w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
                    AppMethodBeat.m2505o(126564);
                    return false;
                    break;
                case 6:
                    optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        optDouble = optJSONArray.optDouble(0, -1.0d);
                        if (optDouble >= 0.0d) {
                            appBrandVideoView.mo34624d(optDouble, false);
                            break;
                        }
                        C4990ab.m7417i("MicroMsg.JsApiOperateVideoPlayer", "pos invalid %s", Double.valueOf(optDouble));
                        AppMethodBeat.m2505o(126564);
                        return false;
                    }
                    C4990ab.m7420w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
                    AppMethodBeat.m2505o(126564);
                    return false;
                    break;
                case 7:
                    optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        if (optJSONArray.length() != 1) {
                            appBrandVideoView.mo34623co(optJSONArray.optString(0, ""), optJSONArray.optString(1, ""));
                            break;
                        }
                        appBrandVideoView.mo34623co(optJSONArray.optString(0, ""), "");
                        break;
                    }
                    C4990ab.m7420w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView dataArr nil");
                    AppMethodBeat.m2505o(126564);
                    return false;
                    break;
                default:
                    C4990ab.m7421w("MicroMsg.JsApiOperateVideoPlayer", "onUpdateView operateType not supported: %s", optString);
                    AppMethodBeat.m2505o(126564);
                    return false;
            }
            AppMethodBeat.m2505o(126564);
            return true;
        }
        C4990ab.m7421w("MicroMsg.JsApiOperateVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(126564);
        return false;
    }
}
