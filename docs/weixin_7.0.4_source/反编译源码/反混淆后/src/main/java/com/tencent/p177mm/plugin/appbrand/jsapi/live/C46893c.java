package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C26932g;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import com.tencent.p177mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.c */
public final class C46893c extends C45578c {
    private static final int CTRL_INDEX = 367;
    public static final String NAME = "operateLivePlayer";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(96110);
        int optInt = jSONObject.optInt("livePlayerId");
        AppMethodBeat.m2505o(96110);
        return optInt;
    }

    public final boolean aCE() {
        return true;
    }

    /* renamed from: b */
    public final boolean mo6138b(final C33303e c33303e, int i, View view, JSONObject jSONObject, final C26932g c26932g) {
        int i2 = 1;
        boolean z = false;
        AppMethodBeat.m2504i(96111);
        C4990ab.m7417i("MicroMsg.JsApiOperateLivePlayer", "onOperateView : livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).mo60996ah(View.class);
            if (view2 instanceof AppBrandLivePlayerView) {
                AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) view2;
                String optString = jSONObject.optString("type");
                C4990ab.m7417i("MicroMsg.JsApiOperateLivePlayer", "onOperateView operateType=%s", optString);
                String str;
                if (optString.equalsIgnoreCase("snapshot")) {
                    appBrandLivePlayerView.setSnapshotListener(new ITXSnapshotListener() {
                        public final void onSnapshot(Bitmap bitmap) {
                            AppMethodBeat.m2504i(96109);
                            if (bitmap == null || bitmap.isRecycled()) {
                                C4990ab.m7412e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: bitmap nil");
                                c26932g.mo44674AR(C46893c.this.mo73394j("fail:snapshot error", null));
                                AppMethodBeat.m2505o(96109);
                                return;
                            }
                            String str = C6457e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            try {
                                C5056d.m7625a(bitmap, 90, CompressFormat.JPEG, str, true);
                                C19681j c19681j = new C19681j();
                                if (c33303e.asE().mo5835a(new File(str), "jpg", true, c19681j) != C45518j.OK) {
                                    c26932g.mo44674AR(C46893c.this.mo73394j("fail:snapshot error", null));
                                    AppMethodBeat.m2505o(96109);
                                    return;
                                }
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    C4990ab.m7416i("MicroMsg.JsApiOperateLivePlayer", "bitmap recycle " + bitmap.toString());
                                    bitmap.recycle();
                                }
                                C4990ab.m7417i("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: actualPath:%s path:%s", str, c19681j.value);
                                HashMap hashMap = new HashMap();
                                hashMap.put("tempImagePath", c19681j.value);
                                hashMap.put("width", Integer.valueOf(width));
                                hashMap.put("height", Integer.valueOf(height));
                                c26932g.mo44674AR(C46893c.this.mo73394j("ok", hashMap));
                                AppMethodBeat.m2505o(96109);
                            } catch (IOException e) {
                                C4990ab.m7413e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: exception %s", e.getMessage());
                                c26932g.mo44674AR(C46893c.this.mo73394j("fail:snapshot error", null));
                                AppMethodBeat.m2505o(96109);
                            }
                        }
                    });
                    if (!appBrandLivePlayerView.mo67993Bc("snapshot")) {
                        c26932g.mo44674AR(mo73394j("fail:snapshot error", null));
                    }
                } else if (optString.equalsIgnoreCase("requestFullScreen")) {
                    int i3;
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        C4990ab.m7420w("MicroMsg.JsApiOperateLivePlayer", "onOperateView directionArr nil");
                        i3 = 0;
                    } else {
                        i3 = optJSONArray.optInt(0, 0);
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", Integer.valueOf(i3));
                    if (appBrandLivePlayerView.hLc == null) {
                        C4990ab.m7420w("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
                        i2 = 0;
                    } else if (appBrandLivePlayerView.hLc.isFullScreen()) {
                        C4990ab.m7416i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
                    } else {
                        appBrandLivePlayerView.hLc.mo61006on(i3);
                        appBrandLivePlayerView.hLe = i3;
                        appBrandLivePlayerView.mo67994dZ(true);
                    }
                    if (i2 != 0) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    c26932g.mo44674AR(mo73394j(str, null));
                } else if (optString.equalsIgnoreCase("exitFullScreen")) {
                    C4990ab.m7416i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
                    if (appBrandLivePlayerView.hLc == null) {
                        C4990ab.m7420w("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
                    } else if (appBrandLivePlayerView.hLc.isFullScreen()) {
                        appBrandLivePlayerView.hLc.aDF();
                        z = true;
                    } else {
                        C4990ab.m7416i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
                        z = true;
                    }
                    if (z) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    c26932g.mo44674AR(mo73394j(str, null));
                } else {
                    if (appBrandLivePlayerView.mo67993Bc(optString)) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    c26932g.mo44674AR(mo73394j(str, null));
                }
                z = super.mo6138b(c33303e, i, view, jSONObject, c26932g);
                AppMethodBeat.m2505o(96111);
                return z;
            }
            C4990ab.m7412e("MicroMsg.JsApiOperateLivePlayer", "targetView not AppBrandLivePlayerView");
            AppMethodBeat.m2505o(96111);
            return false;
        }
        C4990ab.m7421w("MicroMsg.JsApiOperateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(96111);
        return false;
    }
}
