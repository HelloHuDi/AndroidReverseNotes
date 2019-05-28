package com.tencent.p177mm.plugin.webview.model;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.p1430a.C41166a;

/* renamed from: com.tencent.mm.plugin.webview.model.a */
public final class C40252a {
    private static String[] ulE = null;

    /* renamed from: com.tencent.mm.plugin.webview.model.a$a */
    static class C22873a implements C45413i<Bundle, Bundle> {
        private C22873a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(6563);
            Bundle cXt = C22874b.cXt();
            AppMethodBeat.m2505o(6563);
            return cXt;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.model.a$b */
    public static final class C22874b {
        public static Bundle cXt() {
            AppMethodBeat.m2504i(6564);
            String O = C26373g.m41965Nv().mo5301O("WebViewConfig", "mediaEnableAutoPlayHostPaths");
            Bundle bundle = new Bundle();
            bundle.putString("enable_auto_play_host_paths", O);
            AppMethodBeat.m2505o(6564);
            return bundle;
        }
    }

    /* renamed from: c */
    public static void m69033c(final MMWebView mMWebView) {
        AppMethodBeat.m2504i(6565);
        if (mMWebView == null) {
            C4990ab.m7412e("MicroMsg.AutoPlayLogic", "webView null");
            AppMethodBeat.m2505o(6565);
            return;
        }
        final String url = mMWebView.getUrl();
        C4990ab.m7417i("MicroMsg.AutoPlayLogic", "currentUrl:%s", url);
        if (C5046bo.isNullOrNil(url)) {
            AppMethodBeat.m2505o(6565);
            return;
        }
        C18514l.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(6562);
                final boolean cW = C40252a.m69034cW(url);
                C18514l.m28819q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(6561);
                        if (cW) {
                            C40252a.m69032a(mMWebView, true);
                            C4990ab.m7416i("MicroMsg.AutoPlayLogic", "enableAutoPlay (true)");
                            AppMethodBeat.m2505o(6561);
                            return;
                        }
                        C40252a.m69032a(mMWebView, false);
                        C4990ab.m7416i("MicroMsg.AutoPlayLogic", "enableAutoPlay (false)");
                        AppMethodBeat.m2505o(6561);
                    }
                });
                AppMethodBeat.m2505o(6562);
            }
        });
        AppMethodBeat.m2505o(6565);
    }

    /* renamed from: cW */
    static /* synthetic */ boolean m69034cW(String str) {
        AppMethodBeat.m2504i(6566);
        if (ulE == null) {
            String string;
            Bundle bundle = (Bundle) C9549f.m17010a("com.tencent.mm", null, C22873a.class);
            if (bundle != null) {
                string = bundle.getString("enable_auto_play_host_paths");
            } else {
                string = null;
            }
            C4990ab.m7417i("MicroMsg.AutoPlayLogic", "autoPlayHostsStr config:%s", string);
            if (C5046bo.isNullOrNil(string)) {
                string = "mp.weixin.qq.com/s;mp.weixin.qq.com/mp/appmsg/show;game.weixin.qq.com";
            }
            ulE = string.split(";");
        }
        Uri parse = Uri.parse(str);
        String str2 = parse.getAuthority() + parse.getPath();
        for (String startsWith : ulE) {
            if (str2.startsWith(startsWith)) {
                AppMethodBeat.m2505o(6566);
                return true;
            }
        }
        AppMethodBeat.m2505o(6566);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m69032a(MMWebView mMWebView, boolean z) {
        AppMethodBeat.m2504i(6567);
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
                C41166a.m71622ep(mMWebView.getX5WebViewExtension()).mo65761u("invokeMiscMethod", "setVideoPlaybackRequiresUserGesture", bundle);
                AppMethodBeat.m2505o(6567);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AutoPlayLogic", "enableAutoPlay :%s", e);
                AppMethodBeat.m2505o(6567);
                return;
            }
        }
        C4990ab.m7416i("MicroMsg.AutoPlayLogic", "not x5 all enable");
        AppMethodBeat.m2505o(6567);
    }
}
