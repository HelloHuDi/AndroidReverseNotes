package com.tencent.p177mm.plugin.webview.modelcache.downloaderimpl;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18429vm;
import com.tencent.p177mm.plugin.webview.modelcache.downloaderimpl.C4553b.C4554a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C30043n.C30044a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35790d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35792l;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4721g;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4722h;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4723i;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper */
public final class WebViewCacheDownloadHelper {
    private static final byte[] uot = new byte[0];
    private static volatile WebViewCacheDownloadHelper uou = null;

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper$ResDownloaderPlugin */
    public static final class ResDownloaderPlugin implements C4721g {
        private final C35790d uov = new C45511();

        /* renamed from: com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper$ResDownloaderPlugin$1 */
        class C45511 implements C35790d {
            C45511() {
            }

            /* renamed from: b */
            public final void mo9629b(String str, C40432m c40432m) {
                AppMethodBeat.m2504i(6893);
                C45511.m6929Ah(str);
                C4554a.m6932c(str, c40432m);
                AppMethodBeat.m2505o(6893);
            }

            public final void aeQ(String str) {
                AppMethodBeat.m2504i(6894);
                C45511.m6929Ah(str);
                AppMethodBeat.m2505o(6894);
            }

            public final String awa() {
                return "WebViewCache";
            }

            /* renamed from: a */
            public final void mo9626a(String str, C40432m c40432m) {
                AppMethodBeat.m2504i(6892);
                C4554a.m6932c(str, c40432m);
                AppMethodBeat.m2505o(6892);
            }

            /* renamed from: Ah */
            private static void m6929Ah(String str) {
                AppMethodBeat.m2504i(6895);
                C44049s ajg = C14857a.vfA.ajg(str);
                if (ajg != null) {
                    C40433a.ajj(ajg.field_filePath);
                }
                AppMethodBeat.m2505o(6895);
            }
        }

        public ResDownloaderPlugin() {
            AppMethodBeat.m2504i(6896);
            AppMethodBeat.m2505o(6896);
        }

        public final void onAccountRelease() {
            AppMethodBeat.m2504i(6898);
            C4555c.clearCache();
            C14856q diy = C14857a.vfA;
            String str = "WebViewCache";
            C35790d c35790d = this.uov;
            if (diy.hrm) {
                C4723i c4723i = diy.vfz;
                if (c35790d != null) {
                    int hashCode = str.hashCode();
                    synchronized (c4723i.vfe) {
                        try {
                            List list = (List) c4723i.vfd.get(hashCode);
                            if (list == null) {
                            } else {
                                list.remove(c35790d);
                                AppMethodBeat.m2505o(6898);
                                return;
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(6898);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(6898);
        }

        public final String awa() {
            return "WebViewCache";
        }

        /* renamed from: c */
        public final C30044a mo9622c(C35792l c35792l) {
            AppMethodBeat.m2504i(6899);
            if (c35792l == null || !(c35792l instanceof C36857e)) {
                C4990ab.m7412e("MicroMsg.ResDownloader.WebViewCacheDownloadHelper", "getNetworkRequestHandler, get invalid request = ".concat(String.valueOf(c35792l)));
                AppMethodBeat.m2505o(6899);
                return null;
            }
            C30044a c4555c = new C4555c((C36857e) c35792l);
            AppMethodBeat.m2505o(6899);
            return c4555c;
        }

        public final C4722h cYu() {
            AppMethodBeat.m2504i(6900);
            C40268d c40268d = new C40268d();
            AppMethodBeat.m2505o(6900);
            return c40268d;
        }

        public final void cYt() {
            AppMethodBeat.m2504i(6897);
            C14857a.vfA.mo27177b("WebViewCache", this.uov);
            AppMethodBeat.m2505o(6897);
        }
    }

    private WebViewCacheDownloadHelper() {
    }

    public static WebViewCacheDownloadHelper cYr() {
        AppMethodBeat.m2504i(6901);
        if (uou == null) {
            synchronized (uot) {
                try {
                    if (uou == null) {
                        uou = new WebViewCacheDownloadHelper();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(6901);
                    }
                }
            }
        }
        WebViewCacheDownloadHelper webViewCacheDownloadHelper = uou;
        AppMethodBeat.m2505o(6901);
        return webViewCacheDownloadHelper;
    }

    public static void cYs() {
        AppMethodBeat.m2504i(6902);
        C5730e.m8618N(C4552a.uos, true);
        AppMethodBeat.m2505o(6902);
    }

    /* renamed from: a */
    static void m6927a(C35616f c35616f) {
        AppMethodBeat.m2504i(6903);
        C4883b c18429vm = new C18429vm();
        c18429vm.cSw.url = c35616f.url;
        c18429vm.cSw.filePath = c35616f.filePath;
        c18429vm.cSw.version = c35616f.version;
        c18429vm.cSw.appId = c35616f.appId;
        c18429vm.cSw.cSx = c35616f.cSx;
        c18429vm.cSw.cSy = c35616f.cSy;
        c18429vm.cSw.cSz = c35616f.cSz;
        c18429vm.cSw.bqF = c35616f.bqF;
        c18429vm.cSw.exception = c35616f.exception;
        c18429vm.cSw.aHW = c35616f.aHW;
        C4879a.xxA.mo10048a(c18429vm, Looper.getMainLooper());
        AppMethodBeat.m2505o(6903);
    }
}
