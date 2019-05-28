package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui;

import android.content.Context;
import android.webkit.ValueCallback;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2702b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C27540m;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.PreloadSession;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p351b.C20082b;
import com.tencent.p177mm.plugin.webview.preload.C43924a;
import com.tencent.p177mm.plugin.webview.preload.TmplParams;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p051k.C25274k;
import p000a.p051k.C31820v;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 H2\u00020\u0001:\u0002HIB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u00100\u001a\u00020\u001f2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001f0\"J\b\u00102\u001a\u00020\u001fH\u0002J\b\u00103\u001a\u00020\u001fH\u0002J\u0006\u00104\u001a\u00020\u001fJ\b\u00105\u001a\u00020\nH\u0014J\n\u00106\u001a\u0004\u0018\u00010\nH\u0016J\b\u00107\u001a\u00020\u001fH\u0014J\b\u00108\u001a\u00020\u001fH\u0016J\b\u00109\u001a\u00020\u001fH\u0014J\b\u0010:\u001a\u00020\u001fH\u0014J7\u0010;\u001a\u00020\u001f\"\b\b\u0000\u0010<*\u00020=2\u0006\u0010\u0002\u001a\u0002H<2\u0018\u0010>\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0?\u0012\u0004\u0012\u00020\u001f0\"¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020#H\u0002J&\u0010C\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)J&\u0010D\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010*\u001a\u00020&2\u0006\u0010%\u001a\u00020&J\u000e\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020GR\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u000e¢\u0006\u0002\n\u0000R \u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001f0\"0!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R$\u0010+\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020#@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006J"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWxJsWebView;", "context", "Landroid/content/Context;", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "delayInitJsAPI", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/webview/preload/TmplParams;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "contentId", "curUrl", "getDelayInitJsAPI", "()Z", "fullUrl", "hasAuthData", "hasUpdateData", "isCheckingInject", "isEvalFinished", "<set-?>", "isInjectDataSuccess", "setInjectDataSuccess", "(Z)V", "isNotifyPageSuccess", "setNotifyPageSuccess", "isSuccess", "onEvalFinished", "Lkotlin/Function0;", "", "onStateChangeListeners", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "rawUrl", "receivePageData", "", "recodeInject", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "startLoadPage", "state", "getState", "()I", "setState", "(I)V", "addOnStateChangeListener", "onStateChange", "adjustInnerWidth", "checkInject", "clearOnStateChange", "getPageString", "getUrl", "initJsEnvironment", "loadUrlAndData", "onInjectReady", "onPageReady", "setOnEvalFinished", "T", "", "callback", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "transferToState", "newState", "updateAuth", "updateData", "updateKV", "kv", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "Companion", "OnStateChange", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b */
public final class C44724b extends C42828e {
    public static final C20089a jUr = new C20089a();
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
    LinkedList<C17126b<Integer, C37091y>> jUj = new LinkedList();
    boolean jUk;
    boolean jUl;
    boolean jUm;
    C31214a<C37091y> jUn = C20090c.jUt;
    private boolean jUo;
    private boolean jUp;
    private final boolean jUq;
    private int state = 1;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView$Companion;", "", "()V", "STATE_AUTH", "", "STATE_DATA_INJECTED", "STATE_DATA_UPDATED", "STATE_ERROR", "STATE_NOT_READY", "STATE_READY", "rawTAG", "", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b$a */
    public static final class C20089a {
        private C20089a() {
        }

        public /* synthetic */ C20089a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b$c */
    static final class C20090c extends C25053k implements C31214a<C37091y> {
        public static final C20090c jUt = new C20090c();

        static {
            AppMethodBeat.m2504i(15008);
            AppMethodBeat.m2505o(15008);
        }

        C20090c() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b$d */
    static final class C20091d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C17126b exI;
        final /* synthetic */ Object jUu;

        C20091d(C17126b c17126b, Object obj) {
            this.exI = c17126b;
            this.jUu = obj;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15009);
            this.exI.mo50am(new WeakReference(this.jUu));
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(15009);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b$b */
    static final class C27556b<T> implements ValueCallback<String> {
        final /* synthetic */ C44724b jUs;

        C27556b(C44724b c44724b) {
            this.jUs = c44724b;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(15007);
            String str = (String) obj;
            C4990ab.m7416i(C44724b.m81439a(this.jUs), "load pageFrame : ".concat(String.valueOf(str)));
            this.jUs.getPerformanceHelper().mo69758aI("onTmplLoadEnd", System.currentTimeMillis());
            C25052j.m39375o(str, "value");
            boolean a = C31820v.m51526a((CharSequence) str, (CharSequence) "ok", false);
            if (!this.jUs.jUp) {
                this.jUs.jUp = true;
                C20082b c20082b = C20082b.jTH;
                TmplParams tmplParams = this.jUs.jRb;
                C25052j.m39375o(tmplParams, "tmplParams");
                C20082b.m31059a(tmplParams, a);
            }
            if (a) {
                C44724b.m81440a(this.jUs, 2);
                if (this.jUs.jUb) {
                    C44724b c44724b = this.jUs;
                    String e = this.jUs.jUc;
                    if (e == null) {
                        C25052j.dWJ();
                    }
                    String f = this.jUs.cOG;
                    if (f == null) {
                        C25052j.dWJ();
                    }
                    c44724b.mo71794b(e, f, this.jUs.jUd, this.jUs.jUe);
                }
                C43924a.m78791gu(this.jUs.jRb.upQ, 114);
            } else if (C31820v.m51526a((CharSequence) str, (CharSequence) "fail", false)) {
                C44724b.m81440a(this.jUs, 6);
                C43924a.m78791gu(this.jUs.jRb.upQ, 115);
            }
            this.jUs.jUo = false;
            AppMethodBeat.m2505o(15007);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b$e */
    static final class C42824e<T> implements ValueCallback<String> {
        final /* synthetic */ C44724b jUs;

        C42824e(C44724b c44724b) {
            this.jUs = c44724b;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(15010);
            String str = (String) obj;
            C4990ab.m7416i(C44724b.m81439a(this.jUs), "terry trace 2.2.1 updateAuth ret:".concat(String.valueOf(str)));
            C4990ab.m7416i(C44724b.m81439a(this.jUs), "onPageAuthOK, jsContent evaluateJavascript cb, ret = " + str + ", view " + this.jUs.getRandomStr());
            AppMethodBeat.m2505o(15010);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b$f */
    static final class C42825f<T> implements ValueCallback<String> {
        final /* synthetic */ C44724b jUs;

        C42825f(C44724b c44724b) {
            this.jUs = c44724b;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(15011);
            C4990ab.m7416i(C44724b.m81439a(this.jUs), "onPageAuthFail, jsContent evaluateJavascript cb, ret = " + ((String) obj) + ", view " + this.jUs.getRandomStr());
            AppMethodBeat.m2505o(15011);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b$g */
    static final class C42827g<T> implements ValueCallback<String> {
        final /* synthetic */ C44724b jUs;
        final /* synthetic */ long jUv;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.b$g$1 */
        static final class C428261 implements Runnable {
            final /* synthetic */ C42827g jUw;

            C428261(C42827g c42827g) {
                this.jUw = c42827g;
            }

            public final void run() {
                AppMethodBeat.m2504i(15012);
                this.jUw.jUs.aXN();
                AppMethodBeat.m2505o(15012);
            }
        }

        C42827g(C44724b c44724b, long j) {
            this.jUs = c44724b;
            this.jUv = j;
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            List a;
            AppMethodBeat.m2504i(15013);
            String str = (String) obj;
            C4990ab.m7416i(C44724b.m81439a(this.jUs), "onReceivePageData, jsContent evaluateJavascript cb, ret = " + str + ", view " + this.jUs.getRandomStr());
            long currentTimeMillis = System.currentTimeMillis();
            C44724b c44724b = this.jUs;
            C25052j.m39375o(str, "value");
            c44724b.jUk = C31820v.m51540d((CharSequence) str, (CharSequence) "ok");
            C43924a.m78791gu(this.jUs.jRb.upQ, this.jUs.jUk ? 130 : GmsClientSupervisor.DEFAULT_BIND_FLAGS);
            this.jUs.getPerformanceHelper().mo69758aI("onInjectEnd", currentTimeMillis);
            List r = new C25274k(",").mo42121r(C6163u.m9838i(str, "\"", "", false), 0);
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
                        a = C25035t.m39324a((Iterable) r, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            a = C17115v.AUP;
            Collection collection = a;
            C44941v c44941v;
            if (collection == null) {
                c44941v = new C44941v("null cannot be cast to non-null type java.util.Collection<T>");
                AppMethodBeat.m2505o(15013);
                throw c44941v;
            }
            Object[] toArray = collection.toArray(new String[0]);
            if (toArray == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.m2505o(15013);
                throw c44941v;
            }
            String[] strArr = (String[]) toArray;
            if (!(strArr.length == 0)) {
                if (new C25274k("[0-9\\.]+").mo42119aq(strArr[strArr.length - 1])) {
                    this.jUs.getPerformanceHelper().mo69758aI("onWebInjectEnd", (long) Double.valueOf(strArr[strArr.length - 1]).doubleValue());
                }
            }
            C4990ab.m7416i(C44724b.m81439a(this.jUs), "terry trace 2.1 onReceivePageData ret:" + str + " eval:" + (currentTimeMillis - this.jUv));
            this.jUs.jUn.invoke();
            this.jUs.jUm = true;
            C44724b.m81440a(this.jUs, 4);
            if (this.jUs.jUf) {
                this.jUs.mo71793a(this.jUs.cxT, this.jUs.jUg, this.jUs.jUh);
            }
            if (this.jUs.getDelayInitJsAPI()) {
                C5004al.m7442n(new C428261(this), 300);
            }
            AppMethodBeat.m2505o(15013);
        }
    }

    static {
        AppMethodBeat.m2504i(15028);
        AppMethodBeat.m2505o(15028);
    }

    public C44724b(Context context, TmplParams tmplParams, boolean z) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(tmplParams, "tmplParams");
        super(context, tmplParams);
        AppMethodBeat.m2504i(15027);
        this.jUq = z;
        getPerformanceHelper().mo69758aI("onTmplLoadStart", System.currentTimeMillis());
        C4990ab.m7417i(getTAG(), "terry trace 1.1 createTmplWebView:delayInitJsAPI=%b", Boolean.valueOf(this.jUq));
        aXM();
        if (!this.jUq) {
            aXN();
        }
        AppMethodBeat.m2505o(15027);
    }

    /* renamed from: a */
    public static final /* synthetic */ String m81439a(C44724b c44724b) {
        AppMethodBeat.m2504i(15029);
        String tag = c44724b.getTAG();
        AppMethodBeat.m2505o(15029);
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
        AppMethodBeat.m2504i(15014);
        String str = "MicroMsg.Preload.WebView:" + getTmplWebViewId();
        AppMethodBeat.m2505o(15014);
        return str;
    }

    public final void aXM() {
        AppMethodBeat.m2504i(15015);
        C4990ab.m7416i(getTAG(), "terry trace 1.2 loadUrlAndData");
        C4990ab.m7416i(getTAG(), "[loadUrlAndData]");
        super.aXM();
        C43924a.m78791gu(this.jRb.upQ, 112);
        AppMethodBeat.m2505o(15015);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aXN() {
        AppMethodBeat.m2504i(15016);
        C4990ab.m7416i(getTAG(), "terry trace 1.3 initJsEnvironment");
        C4990ab.m7416i(getTAG(), "[initJsEnvironment]");
        super.aXN();
        AppMethodBeat.m2505o(15016);
    }

    /* renamed from: c */
    public final void mo71795c(C17126b<? super Integer, C37091y> c17126b) {
        AppMethodBeat.m2504i(15017);
        C25052j.m39376p(c17126b, "onStateChange");
        this.jUj.add(c17126b);
        AppMethodBeat.m2505o(15017);
    }

    /* renamed from: sz */
    private final void m81457sz(int i) {
        AppMethodBeat.m2504i(15018);
        C4990ab.m7417i(getTAG(), "transferToState() state:%d, newState:%d", Integer.valueOf(this.state), Integer.valueOf(i));
        this.state = i;
        for (C17126b am : this.jUj) {
            am.mo50am(Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(15018);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJq() {
        AppMethodBeat.m2504i(15019);
        C4990ab.m7418v(getTAG(), "onPageReady");
        super.aJq();
        aXP();
        AppMethodBeat.m2505o(15019);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aXO() {
        AppMethodBeat.m2504i(15020);
        C4990ab.m7418v(getTAG(), "onInjectReady");
        aXP();
        AppMethodBeat.m2505o(15020);
    }

    private final void aXP() {
        AppMethodBeat.m2504i(15021);
        if (this.jUo) {
            AppMethodBeat.m2505o(15021);
            return;
        }
        this.jUo = true;
        synchronized (this) {
            try {
                if (this.state != 1) {
                    C4990ab.m7421w(getTAG(), "[onPageReady] state:%d alreay preload", Integer.valueOf(this.state));
                } else {
                    C37091y c37091y = C37091y.AUy;
                    C43924a.m78791gu(this.jRb.upQ, 113);
                    evaluateJavascript("javascript:JSON.stringify(window.__appmsg_skeleton_success__)", new C27556b(this));
                    aXQ();
                    C4990ab.m7416i(getTAG(), "[onPageReady]");
                    AppMethodBeat.m2505o(15021);
                }
            } finally {
                AppMethodBeat.m2505o(15021);
            }
        }
    }

    private final void aXQ() {
        AppMethodBeat.m2504i(15022);
        int gd = C1338a.m2868gd(getContext());
        float density = C1338a.getDensity(getContext());
        C4990ab.m7416i(getTAG(), "adjustInnerWidth() screenWidth:" + gd + ", density:" + density);
        if (gd > 0 && density > 0.0f) {
            gd = (int) (((float) gd) / density);
            C4990ab.m7416i(getTAG(), "adjustInnerWidth() innerWidth:".concat(String.valueOf(gd)));
            evaluateJavascript("javascript:window.innerWidth = ".concat(String.valueOf(gd)), null);
        }
        AppMethodBeat.m2505o(15022);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:3:0x000d, code skipped:
            if (r0 == null) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String getPageString() {
        AppMethodBeat.m2504i(15023);
        String str = this.jUc;
        if (str != null) {
            str = C2702b.m4925FM(str);
        }
        str = "";
        AppMethodBeat.m2505o(15023);
        return str;
    }

    /* JADX WARNING: Missing block: B:12:0x0051, code skipped:
            r4 = java.lang.System.currentTimeMillis();
            getPerformanceHelper().mo69758aI("onInjectStart", r4);
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i(getTAG(), "[updateData]data contentId:" + r10 + " startLoadPage:" + r12 + " receivePageData:" + r14);
            r9.jUc = r10;
            r9.cOG = r11;
            r0 = new org.json.JSONObject().put("data", "@param").put(com.google.android.gms.measurement.AppMeasurement.Param.TIMESTAMP, new org.json.JSONObject().put("startLoadPage", r12).put("receivePageData", r14)).put("url", r11).put("key", getRandomStr()).toString();
            p000a.p005f.p007b.C25052j.m39375o(r0, "JSONObject()\n//         …              .toString()");
            r2 = "[window.onReceivePageData(" + r0 + "),Date.now()].join(',')";
            r1 = null;
     */
    /* JADX WARNING: Missing block: B:13:0x00f4, code skipped:
            if (com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43986f.m78916c((com.tencent.xweb.WebView) r9) == false) goto L_0x0198;
     */
    /* JADX WARNING: Missing block: B:14:0x00f6, code skipped:
            r0 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2702b.m4926FN(r10);
            r3 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.C45765c.m84597sA(r0);
            r6 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2702b.m4927a(r10, r3);
     */
    /* JADX WARNING: Missing block: B:15:0x0102, code skipped:
            if (r6 != r0) goto L_0x0198;
     */
    /* JADX WARNING: Missing block: B:17:0x010b, code skipped:
            if (r9.jRb.version < 4503325) goto L_0x0179;
     */
    /* JADX WARNING: Missing block: B:18:0x010d, code skipped:
            r0 = p000a.p051k.C6163u.m9836aI(r2, "\"@param\"", "@param");
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i(getTAG(), "onReceivePageData buff parse native:".concat(java.lang.String.valueOf(r0)));
     */
    /* JADX WARNING: Missing block: B:19:0x0129, code skipped:
            r0 = new com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C40342m(r0, r3.AiQ, r6).toString();
            p000a.p005f.p007b.C25052j.m39375o(r0, "XWebCodeCacheMeta(script…pointer, size).toString()");
            r1 = 1;
     */
    /* JADX WARNING: Missing block: B:20:0x013b, code skipped:
            if (r1 != null) goto L_0x0196;
     */
    /* JADX WARNING: Missing block: B:21:0x013d, code skipped:
            r1 = new java.lang.StringBuilder("javascript:");
            r3 = getInjectAPI();
            p000a.p005f.p007b.C25052j.m39375o(r3, "injectAPI");
            r1 = r1.append(p000a.p051k.C6163u.m9836aI(r0, "\"@param\"", r3)).toString();
     */
    /* JADX WARNING: Missing block: B:22:0x015f, code skipped:
            evaluateJavascript(r1, new com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.C44724b.C42827g(r9, r4));
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(15024);
     */
    /* JADX WARNING: Missing block: B:25:0x0179, code skipped:
            r0 = p000a.p051k.C6163u.m9836aI(r2, "\"@param\"", "JSON.stringify(@param)");
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i(getTAG(), "onReceivePageData buff parse stringify:".concat(java.lang.String.valueOf(r0)));
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
    /* renamed from: b */
    public final boolean mo71794b(String str, String str2, long j, long j2) {
        AppMethodBeat.m2504i(15024);
        C25052j.m39376p(str, "contentId");
        C25052j.m39376p(str2, "rawUrl");
        synchronized (this) {
            try {
                if (this.state != 2) {
                    C4990ab.m7420w(getTAG(), "[updateData]delay update data state:" + this.state + ", return");
                    this.jUc = str;
                    this.cOG = str2;
                    this.jUd = j;
                    this.jUe = j2;
                    this.jUb = true;
                } else {
                    m81457sz(3);
                    C37091y c37091y = C37091y.AUy;
                }
            } finally {
                AppMethodBeat.m2505o(15024);
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
            r8 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C27540m.m43709a(r8, r9);
     */
    /* JADX WARNING: Missing block: B:18:0x004b, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i(getTAG(), "terry trace 2.2 updateAuth");
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i(getTAG(), "[updateAuth]ok fullUrl:%s", r8);
            evaluateJavascript("javascript:window.onPageAuthOK(" + new org.json.JSONObject().put("fullUrl", r8) + ')', new com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.C44724b.C42824e(r6));
            com.tencent.p177mm.plugin.webview.preload.C43924a.m78791gu(r6.jRb.upQ, com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e.CTRL_INDEX);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(138515);
     */
    /* JADX WARNING: Missing block: B:21:0x00a2, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i(getTAG(), "[updateAuth]fail");
            evaluateJavascript("javascript:window.onPageAuthFail()", new com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.C44724b.C42825f(r6));
            com.tencent.p177mm.plugin.webview.preload.C43924a.m78791gu(r6.jRb.upQ, com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d.CTRL_INDEX);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(138515);
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo71793a(boolean z, String str, PreloadSession preloadSession) {
        AppMethodBeat.m2504i(138515);
        synchronized (this) {
            try {
                if (this.state != 4) {
                    C4990ab.m7421w(getTAG(), "[updateAuth]delay update auth, return, state:%d", Integer.valueOf(this.state));
                    this.jUf = true;
                    this.cxT = z;
                    this.jUg = str;
                    if (preloadSession != null) {
                        this.jUh = preloadSession;
                    }
                } else {
                    this.jUi = str;
                    m81457sz(5);
                    C37091y c37091y = C37091y.AUy;
                }
            } finally {
                AppMethodBeat.m2505o(138515);
            }
        }
    }

    public final String getUrl() {
        AppMethodBeat.m2504i(15026);
        String url = super.getUrl();
        if (this.state == 5 && url != null && C27540m.m43703FC(url)) {
            url = this.jUi;
            AppMethodBeat.m2505o(15026);
            return url;
        }
        AppMethodBeat.m2505o(15026);
        return url;
    }
}
