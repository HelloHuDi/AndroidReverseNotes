package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;

public final class a {
    private static String[] ulE = null;

    static class a implements i<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(6563);
            Bundle cXt = b.cXt();
            AppMethodBeat.o(6563);
            return cXt;
        }
    }

    public static final class b {
        public static Bundle cXt() {
            AppMethodBeat.i(6564);
            String O = g.Nv().O("WebViewConfig", "mediaEnableAutoPlayHostPaths");
            Bundle bundle = new Bundle();
            bundle.putString("enable_auto_play_host_paths", O);
            AppMethodBeat.o(6564);
            return bundle;
        }
    }

    public static void c(final MMWebView mMWebView) {
        AppMethodBeat.i(6565);
        if (mMWebView == null) {
            ab.e("MicroMsg.AutoPlayLogic", "webView null");
            AppMethodBeat.o(6565);
            return;
        }
        final String url = mMWebView.getUrl();
        ab.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", url);
        if (bo.isNullOrNil(url)) {
            AppMethodBeat.o(6565);
            return;
        }
        l.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6562);
                final boolean cW = a.cW(url);
                l.q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(6561);
                        if (cW) {
                            a.a(mMWebView, true);
                            ab.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (true)");
                            AppMethodBeat.o(6561);
                            return;
                        }
                        a.a(mMWebView, false);
                        ab.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (false)");
                        AppMethodBeat.o(6561);
                    }
                });
                AppMethodBeat.o(6562);
            }
        });
        AppMethodBeat.o(6565);
    }

    static /* synthetic */ boolean cW(String str) {
        AppMethodBeat.i(6566);
        if (ulE == null) {
            String string;
            Bundle bundle = (Bundle) f.a("com.tencent.mm", null, a.class);
            if (bundle != null) {
                string = bundle.getString("enable_auto_play_host_paths");
            } else {
                string = null;
            }
            ab.i("MicroMsg.AutoPlayLogic", "autoPlayHostsStr config:%s", string);
            if (bo.isNullOrNil(string)) {
                string = "mp.weixin.qq.com/s;mp.weixin.qq.com/mp/appmsg/show;game.weixin.qq.com";
            }
            ulE = string.split(";");
        }
        Uri parse = Uri.parse(str);
        String str2 = parse.getAuthority() + parse.getPath();
        for (String startsWith : ulE) {
            if (str2.startsWith(startsWith)) {
                AppMethodBeat.o(6566);
                return true;
            }
        }
        AppMethodBeat.o(6566);
        return false;
    }

    static /* synthetic */ void a(MMWebView mMWebView, boolean z) {
        AppMethodBeat.i(6567);
        mMWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        if (mMWebView.getIsX5Kernel()) {
            try {
                boolean z2;
                Bundle bundle = new Bundle();
                String str = "require";
                if (z) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                bundle.putBoolean(str, z2);
                org.a.a.ep(mMWebView.getX5WebViewExtension()).u("invokeMiscMethod", "setVideoPlaybackRequiresUserGesture", bundle);
                AppMethodBeat.o(6567);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.AutoPlayLogic", "enableAutoPlay :%s", e);
                AppMethodBeat.o(6567);
                return;
            }
        }
        ab.i("MicroMsg.AutoPlayLogic", "not x5 all enable");
        AppMethodBeat.o(6567);
    }
}
