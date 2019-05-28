package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends c {
    private static final int CTRL_INDEX = 363;
    public static final String NAME = "operateLivePusher";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(96114);
        int optInt = jSONObject.optInt("livePusherId");
        AppMethodBeat.o(96114);
        return optInt;
    }

    public final boolean aCE() {
        return true;
    }

    public final boolean b(final e eVar, int i, View view, JSONObject jSONObject, final g gVar) {
        AppMethodBeat.i(96115);
        ab.i("MicroMsg.JsApiOperateLivePusher", "onOperateView : livePusherId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).ah(View.class);
            if (view2 instanceof AppBrandLivePusherView) {
                final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) view2;
                String optString = jSONObject.optString("type");
                ab.i("MicroMsg.JsApiOperateLivePusher", "onOperateView operateType=%s", optString);
                if (optString.equalsIgnoreCase("snapshot")) {
                    appBrandLivePusherView.setSnapshotListener(new ITXSnapshotListener() {
                        public final void onSnapshot(Bitmap bitmap) {
                            AppMethodBeat.i(96113);
                            if (bitmap == null || bitmap.isRecycled()) {
                                ab.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: bitmap nil");
                                gVar.AR(d.this.j("fail:snapshot error", null));
                                AppMethodBeat.o(96113);
                                return;
                            }
                            String str = com.tencent.mm.compatible.util.e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            try {
                                com.tencent.mm.sdk.platformtools.d.a(bitmap, 90, CompressFormat.JPEG, str, true);
                                j jVar = new j();
                                if (eVar.asE().a(new File(str), "jpg", true, jVar) != com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                                    gVar.AR(d.this.j("fail:snapshot error", null));
                                    AppMethodBeat.o(96113);
                                    return;
                                }
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    ab.i("MicroMsg.JsApiOperateLivePusher", "bitmap recycle " + bitmap.toString());
                                    bitmap.recycle();
                                }
                                ab.i("MicroMsg.JsApiOperateLivePusher", "onSnapshot: actualPath:%s path:%s", str, jVar.value);
                                HashMap hashMap = new HashMap();
                                hashMap.put("tempImagePath", jVar.value);
                                hashMap.put("width", Integer.valueOf(width));
                                hashMap.put("height", Integer.valueOf(height));
                                gVar.AR(d.this.j("ok", hashMap));
                                AppMethodBeat.o(96113);
                            } catch (IOException e) {
                                ab.e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: exception %s", e.getMessage());
                                gVar.AR(d.this.j("fail:snapshot error", null));
                                AppMethodBeat.o(96113);
                            }
                        }
                    });
                    if (!appBrandLivePusherView.b("snapshot", null)) {
                        gVar.AR(j("fail:snapshot error", null));
                    }
                } else if (optString.equalsIgnoreCase("playBGM")) {
                    final String optString2 = jSONObject.optString("url");
                    if (bo.isNullOrNil(optString2)) {
                        ab.w("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, url is nil");
                        gVar.AR(j("fail:url is nil", null));
                    } else {
                        b.a(eVar, optString2, null, new a() {
                            public final void AN(String str) {
                                AppMethodBeat.i(96112);
                                HashMap hashMap;
                                if (bo.isNullOrNil(str)) {
                                    ab.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, download file fail, url:%s", optString2);
                                    hashMap = new HashMap();
                                    hashMap.put("url", optString2);
                                    appBrandLivePusherView.a(10003, "download file fail", hashMap);
                                    AppMethodBeat.o(96112);
                                    return;
                                }
                                ab.i("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, local file path:%s", str);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("BGMFilePath", str);
                                } catch (JSONException e) {
                                    ab.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, set param fail", e);
                                }
                                if (!appBrandLivePusherView.b("playBGM", jSONObject)) {
                                    ab.e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, play bgm fail, url:%s", optString2);
                                    hashMap = new HashMap();
                                    hashMap.put("url", optString2);
                                    appBrandLivePusherView.a(10003, "download file fail", hashMap);
                                }
                                AppMethodBeat.o(96112);
                            }
                        });
                        gVar.AR(j("ok", null));
                    }
                } else if (appBrandLivePusherView.b(optString, jSONObject)) {
                    gVar.AR(j("ok", null));
                } else {
                    gVar.AR(j("fail", null));
                }
                boolean b = super.b(eVar, i, view, jSONObject, gVar);
                AppMethodBeat.o(96115);
                return b;
            }
            ab.e("MicroMsg.JsApiOperateLivePusher", "targetView not AppBrandLivePusherView");
            AppMethodBeat.o(96115);
            return false;
        }
        ab.w("MicroMsg.JsApiOperateLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(96115);
        return false;
    }
}
