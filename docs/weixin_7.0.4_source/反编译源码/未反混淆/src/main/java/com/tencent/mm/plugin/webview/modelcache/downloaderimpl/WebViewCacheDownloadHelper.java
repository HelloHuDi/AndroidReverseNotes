package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.g;
import com.tencent.mm.pluginsdk.g.a.c.h;
import com.tencent.mm.pluginsdk.g.a.c.i;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.List;

public final class WebViewCacheDownloadHelper {
    private static final byte[] uot = new byte[0];
    private static volatile WebViewCacheDownloadHelper uou = null;

    public static final class ResDownloaderPlugin implements g {
        private final d uov = new d() {
            public final void b(String str, m mVar) {
                AppMethodBeat.i(6893);
                AnonymousClass1.Ah(str);
                a.c(str, mVar);
                AppMethodBeat.o(6893);
            }

            public final void aeQ(String str) {
                AppMethodBeat.i(6894);
                AnonymousClass1.Ah(str);
                AppMethodBeat.o(6894);
            }

            public final String awa() {
                return "WebViewCache";
            }

            public final void a(String str, m mVar) {
                AppMethodBeat.i(6892);
                a.c(str, mVar);
                AppMethodBeat.o(6892);
            }

            private static void Ah(String str) {
                AppMethodBeat.i(6895);
                s ajg = a.vfA.ajg(str);
                if (ajg != null) {
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(ajg.field_filePath);
                }
                AppMethodBeat.o(6895);
            }
        };

        public ResDownloaderPlugin() {
            AppMethodBeat.i(6896);
            AppMethodBeat.o(6896);
        }

        public final void onAccountRelease() {
            AppMethodBeat.i(6898);
            c.clearCache();
            q diy = a.vfA;
            String str = "WebViewCache";
            d dVar = this.uov;
            if (diy.hrm) {
                i iVar = diy.vfz;
                if (dVar != null) {
                    int hashCode = str.hashCode();
                    synchronized (iVar.vfe) {
                        try {
                            List list = (List) iVar.vfd.get(hashCode);
                            if (list == null) {
                            } else {
                                list.remove(dVar);
                                AppMethodBeat.o(6898);
                                return;
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(6898);
                        }
                    }
                }
            }
            AppMethodBeat.o(6898);
        }

        public final String awa() {
            return "WebViewCache";
        }

        public final n.a c(l lVar) {
            AppMethodBeat.i(6899);
            if (lVar == null || !(lVar instanceof e)) {
                ab.e("MicroMsg.ResDownloader.WebViewCacheDownloadHelper", "getNetworkRequestHandler, get invalid request = ".concat(String.valueOf(lVar)));
                AppMethodBeat.o(6899);
                return null;
            }
            n.a cVar = new c((e) lVar);
            AppMethodBeat.o(6899);
            return cVar;
        }

        public final h cYu() {
            AppMethodBeat.i(6900);
            d dVar = new d();
            AppMethodBeat.o(6900);
            return dVar;
        }

        public final void cYt() {
            AppMethodBeat.i(6897);
            a.vfA.b("WebViewCache", this.uov);
            AppMethodBeat.o(6897);
        }
    }

    private WebViewCacheDownloadHelper() {
    }

    public static WebViewCacheDownloadHelper cYr() {
        AppMethodBeat.i(6901);
        if (uou == null) {
            synchronized (uot) {
                try {
                    if (uou == null) {
                        uou = new WebViewCacheDownloadHelper();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(6901);
                    }
                }
            }
        }
        WebViewCacheDownloadHelper webViewCacheDownloadHelper = uou;
        AppMethodBeat.o(6901);
        return webViewCacheDownloadHelper;
    }

    public static void cYs() {
        AppMethodBeat.i(6902);
        e.N(a.uos, true);
        AppMethodBeat.o(6902);
    }

    static void a(f fVar) {
        AppMethodBeat.i(6903);
        b vmVar = new vm();
        vmVar.cSw.url = fVar.url;
        vmVar.cSw.filePath = fVar.filePath;
        vmVar.cSw.version = fVar.version;
        vmVar.cSw.appId = fVar.appId;
        vmVar.cSw.cSx = fVar.cSx;
        vmVar.cSw.cSy = fVar.cSy;
        vmVar.cSw.cSz = fVar.cSz;
        vmVar.cSw.bqF = fVar.bqF;
        vmVar.cSw.exception = fVar.exception;
        vmVar.cSw.aHW = fVar.aHW;
        com.tencent.mm.sdk.b.a.xxA.a(vmVar, Looper.getMainLooper());
        AppMethodBeat.o(6903);
    }
}
