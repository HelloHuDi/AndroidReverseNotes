package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mmkv.C5766d;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C33739g;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C33739g.C33740a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p351b.C20082b;
import com.tencent.p177mm.plugin.webview.preload.TmplParams;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001c\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\b\u0010!\u001a\u00020\"H\u0002J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010%\u001a\u00020\"H\u0007J(\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager;", "", "()V", "TAG", "", "cacheWebView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "getCacheWebView$plugin_brandservice_release", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "setCacheWebView$plugin_brandservice_release", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;)V", "contentBuff", "Lcom/tencent/mmkv/NativeBuffer;", "lastCreating", "", "getLastCreating$plugin_brandservice_release", "()J", "setLastCreating$plugin_brandservice_release", "(J)V", "priorityWebView", "", "createWebView", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "delayInitJsAPI", "getNativeBuffer", "size", "", "obtainPreloadTmplWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "obtainTmplWebView", "preloadWebViewInner", "", "replaceContext", "mmWebView", "tryPreloadTmplWebview", "updateTmplWebview", "type", "contentId", "url", "startLoadPage", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c */
public final class C45765c {
    private static final String TAG = TAG;
    private static C5766d jUA = new C5766d(0, 0);
    public static final C45765c jUB = new C45765c();
    private static C44724b jUx;
    private static long jUy;
    private static boolean jUz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c$c */
    static final class C11258c implements Runnable {
        public static final C11258c jUE = new C11258c();

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$tryPreloadTmplWebview$1$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c$c$1 */
        public static final class C112571 implements IdleHandler {
            C112571() {
            }

            public final boolean queueIdle() {
                AppMethodBeat.m2504i(15034);
                Looper.myQueue().removeIdleHandler(this);
                C45765c.m84593a(C45765c.jUB);
                AppMethodBeat.m2505o(15034);
                return false;
            }
        }

        static {
            AppMethodBeat.m2504i(15036);
            AppMethodBeat.m2505o(15036);
        }

        C11258c() {
        }

        public final void run() {
            AppMethodBeat.m2504i(15035);
            Looper.myQueue().addIdleHandler(new C112571());
            AppMethodBeat.m2505o(15035);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "state", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c$a */
    static final class C31343a extends C25053k implements C17126b<Integer, C37091y> {
        public static final C31343a jUC = new C31343a();

        static {
            AppMethodBeat.m2504i(15032);
            AppMethodBeat.m2505o(15032);
        }

        C31343a() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(15031);
            int intValue = ((Number) obj).intValue();
            C45765c c45765c = C45765c.jUB;
            C4990ab.m7418v(C45765c.TAG, "priority webview state changed:".concat(String.valueOf(intValue)));
            C45765c c45765c2 = C45765c.jUB;
            C45765c.jUz = false;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(15031);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "state", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c$b */
    static final class C31344b extends C25053k implements C17126b<Integer, C37091y> {
        final /* synthetic */ C44724b jUD;

        C31344b(C44724b c44724b) {
            this.jUD = c44724b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(15033);
            int intValue = ((Number) obj).intValue();
            C45765c c45765c = C45765c.jUB;
            C4990ab.m7417i(C45765c.TAG, "[preloadWebViewInner]state:%d", Integer.valueOf(intValue));
            C45765c c45765c2;
            if (intValue == 6) {
                c45765c2 = C45765c.jUB;
                C4990ab.m7412e(C45765c.TAG, "[preloadWebViewInner]fail");
            } else if (intValue == 2) {
                c45765c2 = C45765c.jUB;
                C4990ab.m7416i(C45765c.TAG, "[preloadWebViewInner]success");
                this.jUD.jUj.clear();
                c45765c2 = C45765c.jUB;
                C45765c.m84596p(this.jUD);
                c45765c2 = C45765c.jUB;
                C45765c.aXR();
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(15033);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(15045);
        AppMethodBeat.m2505o(15045);
    }

    private C45765c() {
    }

    /* renamed from: a */
    public static final /* synthetic */ void m84593a(C45765c c45765c) {
        AppMethodBeat.m2504i(15046);
        c45765c.aXS();
        AppMethodBeat.m2505o(15046);
    }

    /* renamed from: p */
    public static void m84596p(C44724b c44724b) {
        jUx = c44724b;
    }

    public static void aXR() {
        jUy = 0;
    }

    public static final void aVR() {
        AppMethodBeat.m2504i(15037);
        C33740a c33740a = C33739g.jSD;
        if (C33740a.aXl()) {
            AppMethodBeat.m2505o(15037);
        } else if (jUz) {
            AppMethodBeat.m2505o(15037);
        } else {
            C5004al.m7441d(C11258c.jUE);
            AppMethodBeat.m2505o(15037);
        }
    }

    /* renamed from: sA */
    public static final C5766d m84597sA(int i) {
        C5766d createNativeBuffer;
        AppMethodBeat.m2504i(15038);
        int ceil = 1048576 * ((int) Math.ceil(((double) i) / 1048576.0d));
        if (jUA.AiQ == 0) {
            createNativeBuffer = C5018as.createNativeBuffer(ceil);
            C25052j.m39375o(createNativeBuffer, "MultiProcessMMKV.createNativeBuffer(calcSize)");
            jUA = createNativeBuffer;
        } else if (jUA.size < ceil) {
            C5018as.destroyNativeBuffer(jUA);
            createNativeBuffer = C5018as.createNativeBuffer(ceil);
            C25052j.m39375o(createNativeBuffer, "MultiProcessMMKV.createNativeBuffer(calcSize)");
            jUA = createNativeBuffer;
        }
        createNativeBuffer = jUA;
        AppMethodBeat.m2505o(15038);
        return createNativeBuffer;
    }

    private final synchronized void aXS() {
        AppMethodBeat.m2504i(15039);
        C4990ab.m7416i(TAG, "[preloadWebViewInner]tmplParams");
        if (jUx != null) {
            C4990ab.m7420w(TAG, "[preloadWebViewInner] already preinit, ignore");
            AppMethodBeat.m2505o(15039);
        } else {
            TmplParams sx = C20082b.m31070sx(0);
            jUy = System.currentTimeMillis();
            C44724b b = C45765c.m84594b(sx, false);
            if (b != null) {
                b.mo71795c((C17126b) new C31344b(b));
                AppMethodBeat.m2505o(15039);
            } else {
                AppMethodBeat.m2505o(15039);
            }
        }
    }

    /* renamed from: a */
    public static final synchronized void m84592a(int i, String str, String str2, long j) {
        synchronized (C45765c.class) {
            AppMethodBeat.m2504i(15040);
            C25052j.m39376p(str, "contentId");
            C25052j.m39376p(str2, "url");
            if (i == 0 && jUx != null) {
                C44724b c44724b = jUx;
                if (c44724b == null) {
                    C25052j.dWJ();
                }
                c44724b.mo71794b(str, str2, j, System.currentTimeMillis());
            }
            AppMethodBeat.m2505o(15040);
        }
    }

    /* renamed from: b */
    private static C44724b m84594b(TmplParams tmplParams, boolean z) {
        AppMethodBeat.m2504i(15041);
        if (tmplParams == null) {
            C4990ab.m7420w(TAG, "[preloadWebViewInner] tmplParams is null");
            AppMethodBeat.m2505o(15041);
            return null;
        } else if (tmplParams.jSV == -1) {
            C4990ab.m7421w(TAG, "[preloadWebViewInner] tmplType %d", Integer.valueOf(tmplParams.jSV));
            AppMethodBeat.m2505o(15041);
            return null;
        } else if (C5046bo.isNullOrNil(tmplParams.jVi)) {
            C4990ab.m7420w(TAG, "[preloadWebViewInner] initUrl " + tmplParams.jVi + " is empty");
            AppMethodBeat.m2505o(15041);
            return null;
        } else if (C1173e.m2561ct(tmplParams.upO)) {
            long currentTimeMillis = System.currentTimeMillis();
            C44724b c44724b = new C44724b(new MutableContextWrapper(C4996ah.getContext()), tmplParams, z);
            if (z) {
                jUz = true;
                c44724b.mo71795c((C17126b) C31343a.jUC);
            }
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            C4990ab.m7419v(TAG, "terry performance create tmplWebView:%dms", Long.valueOf(currentTimeMillis));
            AppMethodBeat.m2505o(15041);
            return c44724b;
        } else {
            C4990ab.m7421w(TAG, "[preloadWebViewInner] filePath %s isn't exist", tmplParams.upO);
            AppMethodBeat.m2505o(15041);
            return null;
        }
    }

    /* renamed from: a */
    private static MMWebView m84591a(MMWebView mMWebView, Context context) {
        AppMethodBeat.m2504i(15044);
        C25052j.m39376p(mMWebView, "mmWebView");
        C25052j.m39376p(context, "context");
        if (mMWebView.getContext() instanceof MutableContextWrapper) {
            Context context2 = mMWebView.getContext();
            if (context2 == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.content.MutableContextWrapper");
                AppMethodBeat.m2505o(15044);
                throw c44941v;
            }
            ((MutableContextWrapper) context2).setBaseContext(context);
        }
        AppMethodBeat.m2505o(15044);
        return mMWebView;
    }

    /* renamed from: a */
    public static final synchronized MMWebView m84590a(Context context, TmplParams tmplParams) {
        MMWebView mMWebView = null;
        synchronized (C45765c.class) {
            AppMethodBeat.m2504i(15042);
            C25052j.m39376p(context, "context");
            long currentTimeMillis = System.currentTimeMillis();
            if (tmplParams == null) {
                C4990ab.m7420w(TAG, "[obtainPreloadWebview]tmplParams is null");
                AppMethodBeat.m2505o(15042);
            } else {
                C4990ab.m7419v(TAG, "[obtainPreloadWebview]tmplParams:%s", tmplParams);
                if (tmplParams.jSV != 0 || jUx == null) {
                    AppMethodBeat.m2505o(15042);
                } else {
                    C44724b c44724b = jUx;
                    jUx = null;
                    C4990ab.m7418v(TAG, "[obtainPreloadWebview] preloadWebviews");
                    if (c44724b == null) {
                        C25052j.dWJ();
                    }
                    mMWebView = C45765c.m84591a((MMWebView) c44724b, context);
                    mMWebView.getPerformanceHelper().mo69758aI("onCreateStart", currentTimeMillis);
                    mMWebView.getPerformanceHelper().mo69758aI("onCreateEnd", System.currentTimeMillis());
                    AppMethodBeat.m2505o(15042);
                }
            }
        }
        return mMWebView;
    }

    /* renamed from: b */
    public static final synchronized MMWebView m84595b(Context context, TmplParams tmplParams) {
        MMWebView mMWebView;
        synchronized (C45765c.class) {
            AppMethodBeat.m2504i(15043);
            C25052j.m39376p(context, "context");
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7419v(TAG, "[obtainTmplWebView]tmplParams:%s", tmplParams);
            C44724b b;
            if (tmplParams == null) {
                Object[] objArr = new Object[1];
                C25052j.dWJ();
                objArr[0] = tmplParams.jVi;
                C4990ab.m7421w(TAG, "[preloadWebViewInner] tmplParams %s is null", objArr);
                AppMethodBeat.m2505o(15043);
                mMWebView = null;
            } else if (tmplParams.jSV != 0 || jUx == null) {
                b = C45765c.m84594b(tmplParams, true);
                if (b == null) {
                    AppMethodBeat.m2505o(15043);
                    mMWebView = null;
                } else {
                    mMWebView = C45765c.m84591a((MMWebView) b, context);
                    mMWebView.getPerformanceHelper().mo69758aI("onCreateStart", currentTimeMillis);
                    mMWebView.getPerformanceHelper().mo69758aI("onCreateEnd", System.currentTimeMillis());
                    AppMethodBeat.m2505o(15043);
                }
            } else {
                b = jUx;
                jUx = null;
                C4990ab.m7418v(TAG, "[obtainTmplWebView] preloadWebviews");
                if (b == null) {
                    C25052j.dWJ();
                }
                mMWebView = C45765c.m84591a((MMWebView) b, context);
                mMWebView.getPerformanceHelper().mo69758aI("onCreateStart", currentTimeMillis);
                mMWebView.getPerformanceHelper().mo69758aI("onCreateEnd", System.currentTimeMillis());
                AppMethodBeat.m2505o(15043);
            }
        }
        return mMWebView;
    }
}
