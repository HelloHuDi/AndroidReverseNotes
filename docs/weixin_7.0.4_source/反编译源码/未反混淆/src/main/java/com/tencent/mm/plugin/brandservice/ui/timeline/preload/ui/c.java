package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mmkv.d;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001c\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\b\u0010!\u001a\u00020\"H\u0002J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010%\u001a\u00020\"H\u0007J(\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager;", "", "()V", "TAG", "", "cacheWebView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "getCacheWebView$plugin_brandservice_release", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "setCacheWebView$plugin_brandservice_release", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;)V", "contentBuff", "Lcom/tencent/mmkv/NativeBuffer;", "lastCreating", "", "getLastCreating$plugin_brandservice_release", "()J", "setLastCreating$plugin_brandservice_release", "(J)V", "priorityWebView", "", "createWebView", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "delayInitJsAPI", "getNativeBuffer", "size", "", "obtainPreloadTmplWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "obtainTmplWebView", "preloadWebViewInner", "", "replaceContext", "mmWebView", "tryPreloadTmplWebview", "updateTmplWebview", "type", "contentId", "url", "startLoadPage", "plugin-brandservice_release"})
public final class c {
    private static final String TAG = TAG;
    private static d jUA = new d(0, 0);
    public static final c jUB = new c();
    private static b jUx;
    private static long jUy;
    private static boolean jUz;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        public static final c jUE = new c();

        static {
            AppMethodBeat.i(15036);
            AppMethodBeat.o(15036);
        }

        c() {
        }

        public final void run() {
            AppMethodBeat.i(15035);
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.i(15034);
                    Looper.myQueue().removeIdleHandler(this);
                    c.a(c.jUB);
                    AppMethodBeat.o(15034);
                    return false;
                }
            });
            AppMethodBeat.o(15035);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "state", "", "invoke"})
    static final class a extends k implements a.f.a.b<Integer, y> {
        public static final a jUC = new a();

        static {
            AppMethodBeat.i(15032);
            AppMethodBeat.o(15032);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(15031);
            int intValue = ((Number) obj).intValue();
            c cVar = c.jUB;
            ab.v(c.TAG, "priority webview state changed:".concat(String.valueOf(intValue)));
            c cVar2 = c.jUB;
            c.jUz = false;
            y yVar = y.AUy;
            AppMethodBeat.o(15031);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "state", "", "invoke"})
    static final class b extends k implements a.f.a.b<Integer, y> {
        final /* synthetic */ b jUD;

        b(b bVar) {
            this.jUD = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(15033);
            int intValue = ((Number) obj).intValue();
            c cVar = c.jUB;
            ab.i(c.TAG, "[preloadWebViewInner]state:%d", Integer.valueOf(intValue));
            c cVar2;
            if (intValue == 6) {
                cVar2 = c.jUB;
                ab.e(c.TAG, "[preloadWebViewInner]fail");
            } else if (intValue == 2) {
                cVar2 = c.jUB;
                ab.i(c.TAG, "[preloadWebViewInner]success");
                this.jUD.jUj.clear();
                cVar2 = c.jUB;
                c.p(this.jUD);
                cVar2 = c.jUB;
                c.aXR();
            }
            y yVar = y.AUy;
            AppMethodBeat.o(15033);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(15045);
        AppMethodBeat.o(15045);
    }

    private c() {
    }

    public static final /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(15046);
        cVar.aXS();
        AppMethodBeat.o(15046);
    }

    public static void p(b bVar) {
        jUx = bVar;
    }

    public static void aXR() {
        jUy = 0;
    }

    public static final void aVR() {
        AppMethodBeat.i(15037);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = g.jSD;
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXl()) {
            AppMethodBeat.o(15037);
        } else if (jUz) {
            AppMethodBeat.o(15037);
        } else {
            al.d(c.jUE);
            AppMethodBeat.o(15037);
        }
    }

    public static final d sA(int i) {
        d createNativeBuffer;
        AppMethodBeat.i(15038);
        int ceil = 1048576 * ((int) Math.ceil(((double) i) / 1048576.0d));
        if (jUA.AiQ == 0) {
            createNativeBuffer = as.createNativeBuffer(ceil);
            j.o(createNativeBuffer, "MultiProcessMMKV.createNativeBuffer(calcSize)");
            jUA = createNativeBuffer;
        } else if (jUA.size < ceil) {
            as.destroyNativeBuffer(jUA);
            createNativeBuffer = as.createNativeBuffer(ceil);
            j.o(createNativeBuffer, "MultiProcessMMKV.createNativeBuffer(calcSize)");
            jUA = createNativeBuffer;
        }
        createNativeBuffer = jUA;
        AppMethodBeat.o(15038);
        return createNativeBuffer;
    }

    private final synchronized void aXS() {
        AppMethodBeat.i(15039);
        ab.i(TAG, "[preloadWebViewInner]tmplParams");
        if (jUx != null) {
            ab.w(TAG, "[preloadWebViewInner] already preinit, ignore");
            AppMethodBeat.o(15039);
        } else {
            TmplParams sx = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.sx(0);
            jUy = System.currentTimeMillis();
            b b = b(sx, false);
            if (b != null) {
                b.c((a.f.a.b) new b(b));
                AppMethodBeat.o(15039);
            } else {
                AppMethodBeat.o(15039);
            }
        }
    }

    public static final synchronized void a(int i, String str, String str2, long j) {
        synchronized (c.class) {
            AppMethodBeat.i(15040);
            j.p(str, "contentId");
            j.p(str2, "url");
            if (i == 0 && jUx != null) {
                b bVar = jUx;
                if (bVar == null) {
                    j.dWJ();
                }
                bVar.b(str, str2, j, System.currentTimeMillis());
            }
            AppMethodBeat.o(15040);
        }
    }

    private static b b(TmplParams tmplParams, boolean z) {
        AppMethodBeat.i(15041);
        if (tmplParams == null) {
            ab.w(TAG, "[preloadWebViewInner] tmplParams is null");
            AppMethodBeat.o(15041);
            return null;
        } else if (tmplParams.jSV == -1) {
            ab.w(TAG, "[preloadWebViewInner] tmplType %d", Integer.valueOf(tmplParams.jSV));
            AppMethodBeat.o(15041);
            return null;
        } else if (bo.isNullOrNil(tmplParams.jVi)) {
            ab.w(TAG, "[preloadWebViewInner] initUrl " + tmplParams.jVi + " is empty");
            AppMethodBeat.o(15041);
            return null;
        } else if (e.ct(tmplParams.upO)) {
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = new b(new MutableContextWrapper(ah.getContext()), tmplParams, z);
            if (z) {
                jUz = true;
                bVar.c((a.f.a.b) a.jUC);
            }
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            ab.v(TAG, "terry performance create tmplWebView:%dms", Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(15041);
            return bVar;
        } else {
            ab.w(TAG, "[preloadWebViewInner] filePath %s isn't exist", tmplParams.upO);
            AppMethodBeat.o(15041);
            return null;
        }
    }

    private static MMWebView a(MMWebView mMWebView, Context context) {
        AppMethodBeat.i(15044);
        j.p(mMWebView, "mmWebView");
        j.p(context, "context");
        if (mMWebView.getContext() instanceof MutableContextWrapper) {
            Context context2 = mMWebView.getContext();
            if (context2 == null) {
                v vVar = new v("null cannot be cast to non-null type android.content.MutableContextWrapper");
                AppMethodBeat.o(15044);
                throw vVar;
            }
            ((MutableContextWrapper) context2).setBaseContext(context);
        }
        AppMethodBeat.o(15044);
        return mMWebView;
    }

    public static final synchronized MMWebView a(Context context, TmplParams tmplParams) {
        MMWebView mMWebView = null;
        synchronized (c.class) {
            AppMethodBeat.i(15042);
            j.p(context, "context");
            long currentTimeMillis = System.currentTimeMillis();
            if (tmplParams == null) {
                ab.w(TAG, "[obtainPreloadWebview]tmplParams is null");
                AppMethodBeat.o(15042);
            } else {
                ab.v(TAG, "[obtainPreloadWebview]tmplParams:%s", tmplParams);
                if (tmplParams.jSV != 0 || jUx == null) {
                    AppMethodBeat.o(15042);
                } else {
                    b bVar = jUx;
                    jUx = null;
                    ab.v(TAG, "[obtainPreloadWebview] preloadWebviews");
                    if (bVar == null) {
                        j.dWJ();
                    }
                    mMWebView = a((MMWebView) bVar, context);
                    mMWebView.getPerformanceHelper().aI("onCreateStart", currentTimeMillis);
                    mMWebView.getPerformanceHelper().aI("onCreateEnd", System.currentTimeMillis());
                    AppMethodBeat.o(15042);
                }
            }
        }
        return mMWebView;
    }

    public static final synchronized MMWebView b(Context context, TmplParams tmplParams) {
        MMWebView mMWebView;
        synchronized (c.class) {
            AppMethodBeat.i(15043);
            j.p(context, "context");
            long currentTimeMillis = System.currentTimeMillis();
            ab.v(TAG, "[obtainTmplWebView]tmplParams:%s", tmplParams);
            b b;
            if (tmplParams == null) {
                Object[] objArr = new Object[1];
                j.dWJ();
                objArr[0] = tmplParams.jVi;
                ab.w(TAG, "[preloadWebViewInner] tmplParams %s is null", objArr);
                AppMethodBeat.o(15043);
                mMWebView = null;
            } else if (tmplParams.jSV != 0 || jUx == null) {
                b = b(tmplParams, true);
                if (b == null) {
                    AppMethodBeat.o(15043);
                    mMWebView = null;
                } else {
                    mMWebView = a((MMWebView) b, context);
                    mMWebView.getPerformanceHelper().aI("onCreateStart", currentTimeMillis);
                    mMWebView.getPerformanceHelper().aI("onCreateEnd", System.currentTimeMillis());
                    AppMethodBeat.o(15043);
                }
            } else {
                b = jUx;
                jUx = null;
                ab.v(TAG, "[obtainTmplWebView] preloadWebviews");
                if (b == null) {
                    j.dWJ();
                }
                mMWebView = a((MMWebView) b, context);
                mMWebView.getPerformanceHelper().aI("onCreateStart", currentTimeMillis);
                mMWebView.getPerformanceHelper().aI("onCreateEnd", System.currentTimeMillis());
                AppMethodBeat.o(15043);
            }
        }
        return mMWebView;
    }
}
