package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.a.t;
import a.f.b.j;
import a.f.b.k;
import a.k.u;
import a.k.v;
import a.l;
import a.y;
import android.content.Context;
import android.webkit.ValueCallback;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.PreloadSession;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 H2\u00020\u0001:\u0002HIB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u00100\u001a\u00020\u001f2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001f0\"J\b\u00102\u001a\u00020\u001fH\u0002J\b\u00103\u001a\u00020\u001fH\u0002J\u0006\u00104\u001a\u00020\u001fJ\b\u00105\u001a\u00020\nH\u0014J\n\u00106\u001a\u0004\u0018\u00010\nH\u0016J\b\u00107\u001a\u00020\u001fH\u0014J\b\u00108\u001a\u00020\u001fH\u0016J\b\u00109\u001a\u00020\u001fH\u0014J\b\u0010:\u001a\u00020\u001fH\u0014J7\u0010;\u001a\u00020\u001f\"\b\b\u0000\u0010<*\u00020=2\u0006\u0010\u0002\u001a\u0002H<2\u0018\u0010>\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0?\u0012\u0004\u0012\u00020\u001f0\"¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020#H\u0002J&\u0010C\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)J&\u0010D\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010*\u001a\u00020&2\u0006\u0010%\u001a\u00020&J\u000e\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020GR\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u000e¢\u0006\u0002\n\u0000R \u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001f0\"0!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R$\u0010+\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020#@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006J"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWxJsWebView;", "context", "Landroid/content/Context;", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "delayInitJsAPI", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/preload/TmplParams;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "contentId", "curUrl", "getDelayInitJsAPI", "()Z", "fullUrl", "hasAuthData", "hasUpdateData", "isCheckingInject", "isEvalFinished", "<set-?>", "isInjectDataSuccess", "setInjectDataSuccess", "(Z)V", "isNotifyPageSuccess", "setNotifyPageSuccess", "isSuccess", "onEvalFinished", "Lkotlin/Function0;", "", "onStateChangeListeners", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "rawUrl", "receivePageData", "", "recodeInject", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "startLoadPage", "state", "getState", "()I", "setState", "(I)V", "addOnStateChangeListener", "onStateChange", "adjustInnerWidth", "checkInject", "clearOnStateChange", "getPageString", "getUrl", "initJsEnvironment", "loadUrlAndData", "onInjectReady", "onPageReady", "setOnEvalFinished", "T", "", "callback", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "transferToState", "newState", "updateAuth", "updateData", "updateKV", "kv", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "Companion", "OnStateChange", "plugin-brandservice_release"})
public final class b extends e {
    public static final a jUr = new a();
    private String cOG;
    private boolean cxT;
    private boolean jUb;
    private String jUc;
    private long jUd;
    private long jUe;
    private boolean jUf;
    private String jUg;
    private PreloadSession jUh;
    private String jUi;
    LinkedList<a.f.a.b<Integer, y>> jUj = new LinkedList();
    boolean jUk;
    boolean jUl;
    boolean jUm;
    a.f.a.a<y> jUn = c.jUt;
    private boolean jUo;
    private boolean jUp;
    private final boolean jUq;
    private int state = 1;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView$Companion;", "", "()V", "STATE_AUTH", "", "STATE_DATA_INJECTED", "STATE_DATA_UPDATED", "STATE_ERROR", "STATE_NOT_READY", "STATE_READY", "rawTAG", "", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends k implements a.f.a.a<y> {
        public static final c jUt = new c();

        static {
            AppMethodBeat.i(15008);
            AppMethodBeat.o(15008);
        }

        c() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "", "invoke"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ a.f.a.b exI;
        final /* synthetic */ Object jUu;

        d(a.f.a.b bVar, Object obj) {
            this.exI = bVar;
            this.jUu = obj;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15009);
            this.exI.am(new WeakReference(this.jUu));
            y yVar = y.AUy;
            AppMethodBeat.o(15009);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class b<T> implements ValueCallback<String> {
        final /* synthetic */ b jUs;

        b(b bVar) {
            this.jUs = bVar;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.i(15007);
            String str = (String) obj;
            ab.i(b.a(this.jUs), "load pageFrame : ".concat(String.valueOf(str)));
            this.jUs.getPerformanceHelper().aI("onTmplLoadEnd", System.currentTimeMillis());
            j.o(str, "value");
            boolean a = v.a((CharSequence) str, (CharSequence) "ok", false);
            if (!this.jUs.jUp) {
                this.jUs.jUp = true;
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b bVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.jTH;
                TmplParams tmplParams = this.jUs.jRb;
                j.o(tmplParams, "tmplParams");
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.a(tmplParams, a);
            }
            if (a) {
                b.a(this.jUs, 2);
                if (this.jUs.jUb) {
                    b bVar2 = this.jUs;
                    String e = this.jUs.jUc;
                    if (e == null) {
                        j.dWJ();
                    }
                    String f = this.jUs.cOG;
                    if (f == null) {
                        j.dWJ();
                    }
                    bVar2.b(e, f, this.jUs.jUd, this.jUs.jUe);
                }
                com.tencent.mm.plugin.webview.preload.a.gu(this.jUs.jRb.upQ, 114);
            } else if (v.a((CharSequence) str, (CharSequence) "fail", false)) {
                b.a(this.jUs, 6);
                com.tencent.mm.plugin.webview.preload.a.gu(this.jUs.jRb.upQ, 115);
            }
            this.jUs.jUo = false;
            AppMethodBeat.o(15007);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class e<T> implements ValueCallback<String> {
        final /* synthetic */ b jUs;

        e(b bVar) {
            this.jUs = bVar;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.i(15010);
            String str = (String) obj;
            ab.i(b.a(this.jUs), "terry trace 2.2.1 updateAuth ret:".concat(String.valueOf(str)));
            ab.i(b.a(this.jUs), "onPageAuthOK, jsContent evaluateJavascript cb, ret = " + str + ", view " + this.jUs.getRandomStr());
            AppMethodBeat.o(15010);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class f<T> implements ValueCallback<String> {
        final /* synthetic */ b jUs;

        f(b bVar) {
            this.jUs = bVar;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.i(15011);
            ab.i(b.a(this.jUs), "onPageAuthFail, jsContent evaluateJavascript cb, ret = " + ((String) obj) + ", view " + this.jUs.getRandomStr());
            AppMethodBeat.o(15011);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class g<T> implements ValueCallback<String> {
        final /* synthetic */ b jUs;
        final /* synthetic */ long jUv;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b$g$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ g jUw;

            AnonymousClass1(g gVar) {
                this.jUw = gVar;
            }

            public final void run() {
                AppMethodBeat.i(15012);
                this.jUw.jUs.aXN();
                AppMethodBeat.o(15012);
            }
        }

        g(b bVar, long j) {
            this.jUs = bVar;
            this.jUv = j;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            List a;
            AppMethodBeat.i(15013);
            String str = (String) obj;
            ab.i(b.a(this.jUs), "onReceivePageData, jsContent evaluateJavascript cb, ret = " + str + ", view " + this.jUs.getRandomStr());
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = this.jUs;
            j.o(str, "value");
            bVar.jUk = v.d((CharSequence) str, (CharSequence) "ok");
            com.tencent.mm.plugin.webview.preload.a.gu(this.jUs.jRb.upQ, this.jUs.jUk ? 130 : GmsClientSupervisor.DEFAULT_BIND_FLAGS);
            this.jUs.getPerformanceHelper().aI("onInjectEnd", currentTimeMillis);
            List r = new a.k.k(",").r(u.i(str, "\"", "", false), 0);
            if (!r.isEmpty()) {
                ListIterator listIterator = r.listIterator(r.size());
                while (listIterator.hasPrevious()) {
                    boolean z;
                    if (((String) listIterator.previous()).length() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        a = t.a((Iterable) r, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            a = a.a.v.AUP;
            Collection collection = a;
            a.v vVar;
            if (collection == null) {
                vVar = new a.v("null cannot be cast to non-null type java.util.Collection<T>");
                AppMethodBeat.o(15013);
                throw vVar;
            }
            Object[] toArray = collection.toArray(new String[0]);
            if (toArray == null) {
                vVar = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(15013);
                throw vVar;
            }
            String[] strArr = (String[]) toArray;
            if (!(strArr.length == 0)) {
                if (new a.k.k("[0-9\\.]+").aq(strArr[strArr.length - 1])) {
                    this.jUs.getPerformanceHelper().aI("onWebInjectEnd", (long) Double.valueOf(strArr[strArr.length - 1]).doubleValue());
                }
            }
            ab.i(b.a(this.jUs), "terry trace 2.1 onReceivePageData ret:" + str + " eval:" + (currentTimeMillis - this.jUv));
            this.jUs.jUn.invoke();
            this.jUs.jUm = true;
            b.a(this.jUs, 4);
            if (this.jUs.jUf) {
                this.jUs.a(this.jUs.cxT, this.jUs.jUg, this.jUs.jUh);
            }
            if (this.jUs.getDelayInitJsAPI()) {
                al.n(new AnonymousClass1(this), 300);
            }
            AppMethodBeat.o(15013);
        }
    }

    static {
        AppMethodBeat.i(15028);
        AppMethodBeat.o(15028);
    }

    public b(Context context, TmplParams tmplParams, boolean z) {
        j.p(context, "context");
        j.p(tmplParams, "tmplParams");
        super(context, tmplParams);
        AppMethodBeat.i(15027);
        this.jUq = z;
        getPerformanceHelper().aI("onTmplLoadStart", System.currentTimeMillis());
        ab.i(getTAG(), "terry trace 1.1 createTmplWebView:delayInitJsAPI=%b", Boolean.valueOf(this.jUq));
        aXM();
        if (!this.jUq) {
            aXN();
        }
        AppMethodBeat.o(15027);
    }

    public static final /* synthetic */ String a(b bVar) {
        AppMethodBeat.i(15029);
        String tag = bVar.getTAG();
        AppMethodBeat.o(15029);
        return tag;
    }

    public final boolean getDelayInitJsAPI() {
        return this.jUq;
    }

    private final void setState(int i) {
        this.state = i;
    }

    public final int getState() {
        return this.state;
    }

    private final void setInjectDataSuccess(boolean z) {
        this.jUk = z;
    }

    public final void setNotifyPageSuccess(boolean z) {
        this.jUl = z;
    }

    /* Access modifiers changed, original: final */
    public final String getTAG() {
        AppMethodBeat.i(15014);
        String str = "MicroMsg.Preload.WebView:" + getTmplWebViewId();
        AppMethodBeat.o(15014);
        return str;
    }

    public final void aXM() {
        AppMethodBeat.i(15015);
        ab.i(getTAG(), "terry trace 1.2 loadUrlAndData");
        ab.i(getTAG(), "[loadUrlAndData]");
        super.aXM();
        com.tencent.mm.plugin.webview.preload.a.gu(this.jRb.upQ, 112);
        AppMethodBeat.o(15015);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aXN() {
        AppMethodBeat.i(15016);
        ab.i(getTAG(), "terry trace 1.3 initJsEnvironment");
        ab.i(getTAG(), "[initJsEnvironment]");
        super.aXN();
        AppMethodBeat.o(15016);
    }

    public final void c(a.f.a.b<? super Integer, y> bVar) {
        AppMethodBeat.i(15017);
        j.p(bVar, "onStateChange");
        this.jUj.add(bVar);
        AppMethodBeat.o(15017);
    }

    private final void sz(int i) {
        AppMethodBeat.i(15018);
        ab.i(getTAG(), "transferToState() state:%d, newState:%d", Integer.valueOf(this.state), Integer.valueOf(i));
        this.state = i;
        for (a.f.a.b am : this.jUj) {
            am.am(Integer.valueOf(i));
        }
        AppMethodBeat.o(15018);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJq() {
        AppMethodBeat.i(15019);
        ab.v(getTAG(), "onPageReady");
        super.aJq();
        aXP();
        AppMethodBeat.o(15019);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aXO() {
        AppMethodBeat.i(15020);
        ab.v(getTAG(), "onInjectReady");
        aXP();
        AppMethodBeat.o(15020);
    }

    private final void aXP() {
        AppMethodBeat.i(15021);
        if (this.jUo) {
            AppMethodBeat.o(15021);
            return;
        }
        this.jUo = true;
        synchronized (this) {
            try {
                if (this.state != 1) {
                    ab.w(getTAG(), "[onPageReady] state:%d alreay preload", Integer.valueOf(this.state));
                } else {
                    y yVar = y.AUy;
                    com.tencent.mm.plugin.webview.preload.a.gu(this.jRb.upQ, 113);
                    evaluateJavascript("javascript:JSON.stringify(window.__appmsg_skeleton_success__)", new b(this));
                    aXQ();
                    ab.i(getTAG(), "[onPageReady]");
                    AppMethodBeat.o(15021);
                }
            } finally {
                AppMethodBeat.o(15021);
            }
        }
    }

    private final void aXQ() {
        AppMethodBeat.i(15022);
        int gd = com.tencent.mm.bz.a.gd(getContext());
        float density = com.tencent.mm.bz.a.getDensity(getContext());
        ab.i(getTAG(), "adjustInnerWidth() screenWidth:" + gd + ", density:" + density);
        if (gd > 0 && density > 0.0f) {
            gd = (int) (((float) gd) / density);
            ab.i(getTAG(), "adjustInnerWidth() innerWidth:".concat(String.valueOf(gd)));
            evaluateJavascript("javascript:window.innerWidth = ".concat(String.valueOf(gd)), null);
        }
        AppMethodBeat.o(15022);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:3:0x000d, code skipped:
            if (r0 == null) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String getPageString() {
        AppMethodBeat.i(15023);
        String str = this.jUc;
        if (str != null) {
            str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.FM(str);
        }
        str = "";
        AppMethodBeat.o(15023);
        return str;
    }

    /* JADX WARNING: Missing block: B:12:0x0051, code skipped:
            r4 = java.lang.System.currentTimeMillis();
            getPerformanceHelper().aI("onInjectStart", r4);
            com.tencent.mm.sdk.platformtools.ab.i(getTAG(), "[updateData]data contentId:" + r10 + " startLoadPage:" + r12 + " receivePageData:" + r14);
            r9.jUc = r10;
            r9.cOG = r11;
            r0 = new org.json.JSONObject().put("data", "@param").put(com.google.android.gms.measurement.AppMeasurement.Param.TIMESTAMP, new org.json.JSONObject().put("startLoadPage", r12).put("receivePageData", r14)).put("url", r11).put("key", getRandomStr()).toString();
            a.f.b.j.o(r0, "JSONObject()\n//         …              .toString()");
            r2 = "[window.onReceivePageData(" + r0 + "),Date.now()].join(',')";
            r1 = null;
     */
    /* JADX WARNING: Missing block: B:13:0x00f4, code skipped:
            if (com.tencent.mm.plugin.webview.ui.tools.jsapi.f.c((com.tencent.xweb.WebView) r9) == false) goto L_0x0198;
     */
    /* JADX WARNING: Missing block: B:14:0x00f6, code skipped:
            r0 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.FN(r10);
            r3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c.sA(r0);
            r6 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a(r10, r3);
     */
    /* JADX WARNING: Missing block: B:15:0x0102, code skipped:
            if (r6 != r0) goto L_0x0198;
     */
    /* JADX WARNING: Missing block: B:17:0x010b, code skipped:
            if (r9.jRb.version < 4503325) goto L_0x0179;
     */
    /* JADX WARNING: Missing block: B:18:0x010d, code skipped:
            r0 = a.k.u.aI(r2, "\"@param\"", "@param");
            com.tencent.mm.sdk.platformtools.ab.i(getTAG(), "onReceivePageData buff parse native:".concat(java.lang.String.valueOf(r0)));
     */
    /* JADX WARNING: Missing block: B:19:0x0129, code skipped:
            r0 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.m(r0, r3.AiQ, r6).toString();
            a.f.b.j.o(r0, "XWebCodeCacheMeta(script…pointer, size).toString()");
            r1 = 1;
     */
    /* JADX WARNING: Missing block: B:20:0x013b, code skipped:
            if (r1 != null) goto L_0x0196;
     */
    /* JADX WARNING: Missing block: B:21:0x013d, code skipped:
            r1 = new java.lang.StringBuilder("javascript:");
            r3 = getInjectAPI();
            a.f.b.j.o(r3, "injectAPI");
            r1 = r1.append(a.k.u.aI(r0, "\"@param\"", r3)).toString();
     */
    /* JADX WARNING: Missing block: B:22:0x015f, code skipped:
            evaluateJavascript(r1, new com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b.g(r9, r4));
            com.tencent.matrix.trace.core.AppMethodBeat.o(15024);
     */
    /* JADX WARNING: Missing block: B:25:0x0179, code skipped:
            r0 = a.k.u.aI(r2, "\"@param\"", "JSON.stringify(@param)");
            com.tencent.mm.sdk.platformtools.ab.i(getTAG(), "onReceivePageData buff parse stringify:".concat(java.lang.String.valueOf(r0)));
     */
    /* JADX WARNING: Missing block: B:26:0x0196, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:27:0x0198, code skipped:
            r0 = r2;
     */
    /* JADX WARNING: Missing block: B:29:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(String str, String str2, long j, long j2) {
        AppMethodBeat.i(15024);
        j.p(str, "contentId");
        j.p(str2, "rawUrl");
        synchronized (this) {
            try {
                if (this.state != 2) {
                    ab.w(getTAG(), "[updateData]delay update data state:" + this.state + ", return");
                    this.jUc = str;
                    this.cOG = str2;
                    this.jUd = j;
                    this.jUe = j2;
                    this.jUb = true;
                } else {
                    sz(3);
                    y yVar = y.AUy;
                }
            } finally {
                AppMethodBeat.o(15024);
            }
        }
        return false;
    }

    /* JADX WARNING: Missing block: B:12:0x003d, code skipped:
            if (r7 == false) goto L_0x00a2;
     */
    /* JADX WARNING: Missing block: B:13:0x003f, code skipped:
            if (r9 != null) goto L_0x0043;
     */
    /* JADX WARNING: Missing block: B:14:0x0041, code skipped:
            r9 = r6.jUh;
     */
    /* JADX WARNING: Missing block: B:15:0x0043, code skipped:
            if (r8 == null) goto L_0x004b;
     */
    /* JADX WARNING: Missing block: B:16:0x0045, code skipped:
            if (r9 == null) goto L_0x004b;
     */
    /* JADX WARNING: Missing block: B:17:0x0047, code skipped:
            r8 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(r8, r9);
     */
    /* JADX WARNING: Missing block: B:18:0x004b, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i(getTAG(), "terry trace 2.2 updateAuth");
            com.tencent.mm.sdk.platformtools.ab.i(getTAG(), "[updateAuth]ok fullUrl:%s", r8);
            evaluateJavascript("javascript:window.onPageAuthOK(" + new org.json.JSONObject().put("fullUrl", r8) + ')', new com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b.e(r6));
            com.tencent.mm.plugin.webview.preload.a.gu(r6.jRb.upQ, com.tencent.mm.plugin.appbrand.jsapi.g.e.CTRL_INDEX);
            com.tencent.matrix.trace.core.AppMethodBeat.o(138515);
     */
    /* JADX WARNING: Missing block: B:21:0x00a2, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i(getTAG(), "[updateAuth]fail");
            evaluateJavascript("javascript:window.onPageAuthFail()", new com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b.f(r6));
            com.tencent.mm.plugin.webview.preload.a.gu(r6.jRb.upQ, com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX);
            com.tencent.matrix.trace.core.AppMethodBeat.o(138515);
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean z, String str, PreloadSession preloadSession) {
        AppMethodBeat.i(138515);
        synchronized (this) {
            try {
                if (this.state != 4) {
                    ab.w(getTAG(), "[updateAuth]delay update auth, return, state:%d", Integer.valueOf(this.state));
                    this.jUf = true;
                    this.cxT = z;
                    this.jUg = str;
                    if (preloadSession != null) {
                        this.jUh = preloadSession;
                    }
                } else {
                    this.jUi = str;
                    sz(5);
                    y yVar = y.AUy;
                }
            } finally {
                AppMethodBeat.o(138515);
            }
        }
    }

    public final String getUrl() {
        AppMethodBeat.i(15026);
        String url = super.getUrl();
        if (this.state == 5 && url != null && m.FC(url)) {
            url = this.jUi;
            AppMethodBeat.o(15026);
            return url;
        }
        AppMethodBeat.o(15026);
        return url;
    }
}
