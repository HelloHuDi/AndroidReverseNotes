package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigDecimal;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends c {
    private static final int CTRL_INDEX = 361;
    public static final String NAME = "updateLivePusher";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(96125);
        int optInt = jSONObject.optInt("livePusherId");
        AppMethodBeat.o(96125);
        return optInt;
    }

    public final boolean c(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(96126);
        ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView : livePusherId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).ah(View.class);
            if (view2 instanceof AppBrandLivePusherView) {
                final String string;
                String optString;
                final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) view2;
                appBrandLivePusherView.y(A(jSONObject));
                try {
                    if (jSONObject.has("backgroundImage")) {
                        string = jSONObject.getString("backgroundImage");
                        optString = jSONObject.optString("backgroundMD5");
                        if (bo.isNullOrNil(string)) {
                            ab.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, url is null");
                        } else {
                            b.a(eVar, string, optString, new a() {
                                public final void AN(String str) {
                                    AppMethodBeat.i(96123);
                                    if (bo.isNullOrNil(str)) {
                                        ab.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("url", string);
                                        appBrandLivePusherView.a(10004, "load background image fail", hashMap);
                                        AppMethodBeat.o(96123);
                                        return;
                                    }
                                    ab.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, localPath:%s", str);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("backgroundImage", str);
                                    appBrandLivePusherView.y(bundle);
                                    AppMethodBeat.o(96123);
                                }
                            });
                        }
                    }
                } catch (JSONException e) {
                    ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "backgroundImage", e.getLocalizedMessage());
                }
                try {
                    if (jSONObject.has("watermarkImage")) {
                        string = jSONObject.getString("watermarkImage");
                        optString = jSONObject.optString("watermarkMD5");
                        if (bo.isNullOrNil(string)) {
                            ab.i("MicroMsg.JsApiUpdateLivePusher", "convertWatermarkImageToLocalPath, url is null");
                        } else {
                            b.a(eVar, string, optString, new a() {
                                public final void AN(String str) {
                                    AppMethodBeat.i(96124);
                                    if (!bo.isNullOrNil(str)) {
                                        ab.i("MicroMsg.JsApiUpdateLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", str);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("watermarkImage", str);
                                        appBrandLivePusherView.y(bundle);
                                    }
                                    AppMethodBeat.o(96124);
                                }
                            });
                        }
                    }
                } catch (JSONException e2) {
                    ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "watermarkImage", e2.getLocalizedMessage());
                }
                AppMethodBeat.o(96126);
                return true;
            }
            ab.e("MicroMsg.JsApiUpdateLivePusher", "targetView not AppBrandLivePusherView");
            AppMethodBeat.o(96126);
            return false;
        }
        ab.w("MicroMsg.JsApiUpdateLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(96126);
        return false;
    }

    private static Bundle A(JSONObject jSONObject) {
        AppMethodBeat.i(96127);
        Bundle bundle = new Bundle();
        try {
            if (jSONObject.has("pushUrl")) {
                bundle.putString("pushUrl", jSONObject.getString("pushUrl"));
                ab.i("MicroMsg.JsApiUpdateLivePusher", "convertParams pushUrl:%s", jSONObject.getString("pushUrl"));
            }
        } catch (JSONException e) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "pushUrl", e.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mode")) {
                bundle.putInt("mode", jSONObject.getInt("mode"));
            }
        } catch (JSONException e2) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "mode", e2.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autopush")) {
                bundle.putBoolean("autopush", jSONObject.getBoolean("autopush"));
            }
        } catch (JSONException e22) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "autopush", e22.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("audioQuality")) {
                bundle.putString("audioQuality", jSONObject.getString("audioQuality"));
            }
        } catch (JSONException e222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "audioQuality", e222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muted")) {
                bundle.putBoolean("muted", jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e2222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "muted", e2222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableCamera")) {
                bundle.putBoolean("enableCamera", jSONObject.getBoolean("enableCamera"));
            }
        } catch (JSONException e22222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "enableCamera", e22222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("focusMode")) {
                bundle.putInt("focusMode", jSONObject.getInt("focusMode"));
            }
        } catch (JSONException e222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "focusMode", e222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("orientation")) {
                bundle.putString("orientation", jSONObject.getString("orientation"));
            }
        } catch (JSONException e2222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "orientation", e2222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("beauty")) {
                bundle.putInt("beauty", jSONObject.getInt("beauty"));
            }
        } catch (JSONException e22222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "beauty", e22222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("whiteness")) {
                bundle.putInt("whiteness", jSONObject.getInt("whiteness"));
            }
        } catch (JSONException e222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "whiteness", e222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("aspect")) {
                bundle.putInt("aspect", jSONObject.getInt("aspect"));
            }
        } catch (JSONException e2222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "aspect", e2222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("minBitrate")) {
                bundle.putInt("minBitrate", jSONObject.getInt("minBitrate"));
            }
        } catch (JSONException e22222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "minBitrate", e22222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("maxBitrate")) {
                bundle.putInt("maxBitrate", jSONObject.getInt("maxBitrate"));
            }
        } catch (JSONException e222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "maxBitrate", e222222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needEvent")) {
                bundle.putBoolean("needEvent", jSONObject.getBoolean("needEvent"));
            }
        } catch (JSONException e2222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "needEvent", e2222222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("debug")) {
                bundle.putBoolean("debug", jSONObject.getBoolean("debug"));
            }
        } catch (JSONException e22222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "debug", e22222222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mirror")) {
                bundle.putBoolean("mirror", jSONObject.getBoolean("mirror"));
            }
        } catch (JSONException e222222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "mirror", e222222222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("watermarkLeft")) {
                bundle.putFloat("watermarkLeft", BigDecimal.valueOf(jSONObject.getDouble("watermarkLeft")).floatValue());
            }
        } catch (JSONException e2222222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "watermarkLeft", e2222222222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("watermarkTop")) {
                bundle.putFloat("watermarkTop", BigDecimal.valueOf(jSONObject.getDouble("watermarkTop")).floatValue());
            }
        } catch (JSONException e22222222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "watermarkTop", e22222222222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("watermarkWidth")) {
                bundle.putFloat("watermarkWidth", BigDecimal.valueOf(jSONObject.getDouble("watermarkWidth")).floatValue());
            }
        } catch (JSONException e222222222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "watermarkWidth", e222222222222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("devicePosition")) {
                bundle.putString("devicePosition", jSONObject.getString("devicePosition"));
            }
        } catch (JSONException e2222222222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "devicePosition", e2222222222222222222.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needBGMEvent")) {
                bundle.putBoolean("needBGMEvent", jSONObject.getBoolean("needBGMEvent"));
            }
        } catch (JSONException e22222222222222222222) {
            ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", "needBGMEvent", e22222222222222222222.getLocalizedMessage());
        }
        AppMethodBeat.o(96127);
        return bundle;
    }
}
