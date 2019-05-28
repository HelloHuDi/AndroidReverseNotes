package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.base.c {
    private static final int CTRL_INDEX = 367;
    public static final String NAME = "operateLivePlayer";

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(96110);
        int optInt = jSONObject.optInt("livePlayerId");
        AppMethodBeat.o(96110);
        return optInt;
    }

    public final boolean aCE() {
        return true;
    }

    public final boolean b(final e eVar, int i, View view, JSONObject jSONObject, final g gVar) {
        int i2 = 1;
        boolean z = false;
        AppMethodBeat.i(96111);
        ab.i("MicroMsg.JsApiOperateLivePlayer", "onOperateView : livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).ah(View.class);
            if (view2 instanceof AppBrandLivePlayerView) {
                AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) view2;
                String optString = jSONObject.optString("type");
                ab.i("MicroMsg.JsApiOperateLivePlayer", "onOperateView operateType=%s", optString);
                String str;
                if (optString.equalsIgnoreCase("snapshot")) {
                    appBrandLivePlayerView.setSnapshotListener(new ITXSnapshotListener() {
                        public final void onSnapshot(Bitmap bitmap) {
                            AppMethodBeat.i(96109);
                            if (bitmap == null || bitmap.isRecycled()) {
                                ab.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: bitmap nil");
                                gVar.AR(c.this.j("fail:snapshot error", null));
                                AppMethodBeat.o(96109);
                                return;
                            }
                            String str = com.tencent.mm.compatible.util.e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            try {
                                d.a(bitmap, 90, CompressFormat.JPEG, str, true);
                                j jVar = new j();
                                if (eVar.asE().a(new File(str), "jpg", true, jVar) != com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                                    gVar.AR(c.this.j("fail:snapshot error", null));
                                    AppMethodBeat.o(96109);
                                    return;
                                }
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    ab.i("MicroMsg.JsApiOperateLivePlayer", "bitmap recycle " + bitmap.toString());
                                    bitmap.recycle();
                                }
                                ab.i("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: actualPath:%s path:%s", str, jVar.value);
                                HashMap hashMap = new HashMap();
                                hashMap.put("tempImagePath", jVar.value);
                                hashMap.put("width", Integer.valueOf(width));
                                hashMap.put("height", Integer.valueOf(height));
                                gVar.AR(c.this.j("ok", hashMap));
                                AppMethodBeat.o(96109);
                            } catch (IOException e) {
                                ab.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: exception %s", e.getMessage());
                                gVar.AR(c.this.j("fail:snapshot error", null));
                                AppMethodBeat.o(96109);
                            }
                        }
                    });
                    if (!appBrandLivePlayerView.Bc("snapshot")) {
                        gVar.AR(j("fail:snapshot error", null));
                    }
                } else if (optString.equalsIgnoreCase("requestFullScreen")) {
                    int i3;
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        ab.w("MicroMsg.JsApiOperateLivePlayer", "onOperateView directionArr nil");
                        i3 = 0;
                    } else {
                        i3 = optJSONArray.optInt(0, 0);
                    }
                    ab.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", Integer.valueOf(i3));
                    if (appBrandLivePlayerView.hLc == null) {
                        ab.w("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
                        i2 = 0;
                    } else if (appBrandLivePlayerView.hLc.isFullScreen()) {
                        ab.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
                    } else {
                        appBrandLivePlayerView.hLc.on(i3);
                        appBrandLivePlayerView.hLe = i3;
                        appBrandLivePlayerView.dZ(true);
                    }
                    if (i2 != 0) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    gVar.AR(j(str, null));
                } else if (optString.equalsIgnoreCase("exitFullScreen")) {
                    ab.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
                    if (appBrandLivePlayerView.hLc == null) {
                        ab.w("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
                    } else if (appBrandLivePlayerView.hLc.isFullScreen()) {
                        appBrandLivePlayerView.hLc.aDF();
                        z = true;
                    } else {
                        ab.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
                        z = true;
                    }
                    if (z) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    gVar.AR(j(str, null));
                } else {
                    if (appBrandLivePlayerView.Bc(optString)) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    gVar.AR(j(str, null));
                }
                z = super.b(eVar, i, view, jSONObject, gVar);
                AppMethodBeat.o(96111);
                return z;
            }
            ab.e("MicroMsg.JsApiOperateLivePlayer", "targetView not AppBrandLivePlayerView");
            AppMethodBeat.o(96111);
            return false;
        }
        ab.w("MicroMsg.JsApiOperateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.o(96111);
        return false;
    }
}
