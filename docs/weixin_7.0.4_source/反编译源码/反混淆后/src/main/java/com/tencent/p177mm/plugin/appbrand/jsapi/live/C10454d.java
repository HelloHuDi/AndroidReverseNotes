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
import com.tencent.p177mm.plugin.appbrand.p329s.C45682b;
import com.tencent.p177mm.plugin.appbrand.p329s.C45682b.C19711a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.d */
public final class C10454d extends C45578c {
    private static final int CTRL_INDEX = 363;
    public static final String NAME = "operateLivePusher";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(96114);
        int optInt = jSONObject.optInt("livePusherId");
        AppMethodBeat.m2505o(96114);
        return optInt;
    }

    public final boolean aCE() {
        return true;
    }

    /* renamed from: b */
    public final boolean mo6138b(final C33303e c33303e, int i, View view, JSONObject jSONObject, final C26932g c26932g) {
        AppMethodBeat.m2504i(96115);
        C4990ab.m7417i("MicroMsg.JsApiOperateLivePusher", "onOperateView : livePusherId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            View view2 = (View) ((CoverViewContainer) view).mo60996ah(View.class);
            if (view2 instanceof AppBrandLivePusherView) {
                final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) view2;
                String optString = jSONObject.optString("type");
                C4990ab.m7417i("MicroMsg.JsApiOperateLivePusher", "onOperateView operateType=%s", optString);
                if (optString.equalsIgnoreCase("snapshot")) {
                    appBrandLivePusherView.setSnapshotListener(new ITXSnapshotListener() {
                        public final void onSnapshot(Bitmap bitmap) {
                            AppMethodBeat.m2504i(96113);
                            if (bitmap == null || bitmap.isRecycled()) {
                                C4990ab.m7412e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: bitmap nil");
                                c26932g.mo44674AR(C10454d.this.mo73394j("fail:snapshot error", null));
                                AppMethodBeat.m2505o(96113);
                                return;
                            }
                            String str = C6457e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            try {
                                C5056d.m7625a(bitmap, 90, CompressFormat.JPEG, str, true);
                                C19681j c19681j = new C19681j();
                                if (c33303e.asE().mo5835a(new File(str), "jpg", true, c19681j) != C45518j.OK) {
                                    c26932g.mo44674AR(C10454d.this.mo73394j("fail:snapshot error", null));
                                    AppMethodBeat.m2505o(96113);
                                    return;
                                }
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    C4990ab.m7416i("MicroMsg.JsApiOperateLivePusher", "bitmap recycle " + bitmap.toString());
                                    bitmap.recycle();
                                }
                                C4990ab.m7417i("MicroMsg.JsApiOperateLivePusher", "onSnapshot: actualPath:%s path:%s", str, c19681j.value);
                                HashMap hashMap = new HashMap();
                                hashMap.put("tempImagePath", c19681j.value);
                                hashMap.put("width", Integer.valueOf(width));
                                hashMap.put("height", Integer.valueOf(height));
                                c26932g.mo44674AR(C10454d.this.mo73394j("ok", hashMap));
                                AppMethodBeat.m2505o(96113);
                            } catch (IOException e) {
                                C4990ab.m7413e("MicroMsg.JsApiOperateLivePusher", "onSnapshot: exception %s", e.getMessage());
                                c26932g.mo44674AR(C10454d.this.mo73394j("fail:snapshot error", null));
                                AppMethodBeat.m2505o(96113);
                            }
                        }
                    });
                    if (!appBrandLivePusherView.mo65883b("snapshot", null)) {
                        c26932g.mo44674AR(mo73394j("fail:snapshot error", null));
                    }
                } else if (optString.equalsIgnoreCase("playBGM")) {
                    final String optString2 = jSONObject.optString("url");
                    if (C5046bo.isNullOrNil(optString2)) {
                        C4990ab.m7420w("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, url is nil");
                        c26932g.mo44674AR(mo73394j("fail:url is nil", null));
                    } else {
                        C45682b.m84381a(c33303e, optString2, null, new C19711a() {
                            /* renamed from: AN */
                            public final void mo21737AN(String str) {
                                AppMethodBeat.m2504i(96112);
                                HashMap hashMap;
                                if (C5046bo.isNullOrNil(str)) {
                                    C4990ab.m7413e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, download file fail, url:%s", optString2);
                                    hashMap = new HashMap();
                                    hashMap.put("url", optString2);
                                    appBrandLivePusherView.mo65882a(10003, "download file fail", hashMap);
                                    AppMethodBeat.m2505o(96112);
                                    return;
                                }
                                C4990ab.m7417i("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, local file path:%s", str);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("BGMFilePath", str);
                                } catch (JSONException e) {
                                    C4990ab.m7413e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, set param fail", e);
                                }
                                if (!appBrandLivePusherView.mo65883b("playBGM", jSONObject)) {
                                    C4990ab.m7413e("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, play bgm fail, url:%s", optString2);
                                    hashMap = new HashMap();
                                    hashMap.put("url", optString2);
                                    appBrandLivePusherView.mo65882a(10003, "download file fail", hashMap);
                                }
                                AppMethodBeat.m2505o(96112);
                            }
                        });
                        c26932g.mo44674AR(mo73394j("ok", null));
                    }
                } else if (appBrandLivePusherView.mo65883b(optString, jSONObject)) {
                    c26932g.mo44674AR(mo73394j("ok", null));
                } else {
                    c26932g.mo44674AR(mo73394j("fail", null));
                }
                boolean b = super.mo6138b(c33303e, i, view, jSONObject, c26932g);
                AppMethodBeat.m2505o(96115);
                return b;
            }
            C4990ab.m7412e("MicroMsg.JsApiOperateLivePusher", "targetView not AppBrandLivePusherView");
            AppMethodBeat.m2505o(96115);
            return false;
        }
        C4990ab.m7421w("MicroMsg.JsApiOperateLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        AppMethodBeat.m2505o(96115);
        return false;
    }
}
