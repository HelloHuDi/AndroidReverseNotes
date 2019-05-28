package com.tencent.luggage.p146d;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.bridge.C0986k;
import com.tencent.luggage.bridge.C37387d;
import com.tencent.luggage.bridge.C37392o;
import com.tencent.luggage.bridge.C45119l;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.luggage.p146d.p1171a.C25685a;
import com.tencent.luggage.p146d.p1171a.C41704b;
import com.tencent.luggage.p146d.p1171a.C45121c;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.webview.C37407a;
import com.tencent.luggage.webview.C37407a.C32193a;
import com.tencent.luggage.webview.default_impl.C25703a;
import com.tencent.luggage.webview.p1172a.C17830b;
import com.tencent.luggage.webview.p1172a.C17832d;
import com.tencent.luggage.webview.p1172a.C25700a;
import com.tencent.luggage.webview.p1172a.C41713e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.p1430a.C41166a;

/* renamed from: com.tencent.luggage.d.k */
public final class C32186k implements C25687b {
    C37392o bOA;
    public C37407a bPA;
    boolean bPB = false;
    public C25685a bPC;
    public C17830b bPD;
    C17832d bPE;
    final ConcurrentHashMap<String, Class<? extends C37393a>> bPF = new ConcurrentHashMap();
    private C32193a bPG = new C321904();
    private final MutableContextWrapper bPx;
    final Class<? extends C37407a> bPy;
    public C17819l bPz;
    private Handler mHandler;
    public String mUrl;

    /* renamed from: com.tencent.luggage.d.k$2 */
    class C321882 implements C45121c {
        final /* synthetic */ C37393a bPH;
        final /* synthetic */ C0986k bPJ;

        C321882(C37393a c37393a, C0986k c0986k) {
            this.bPH = c37393a;
            this.bPJ = c0986k;
        }

        /* renamed from: a */
        public final void mo52837a(C41704b c41704b) {
            AppMethodBeat.m2504i(90814);
            if (c41704b == C41704b.PASS) {
                C37393a c37393a = this.bPH;
                C37393a c37393a2 = this.bPH;
                C0986k c0986k = this.bPJ;
                C32183a c32183a = new C32183a();
                c32183a.bOZ = c37393a2.bOY;
                c32183a.bPa = c0986k;
                c37393a.mo38432a(c32183a);
                AppMethodBeat.m2505o(90814);
                return;
            }
            this.bPJ.mo3951a("system:access_denied", null);
            AppMethodBeat.m2505o(90814);
        }
    }

    /* renamed from: com.tencent.luggage.d.k$4 */
    class C321904 implements C32193a {
        private boolean bPL = false;

        C321904() {
        }

        /* renamed from: bD */
        public final boolean mo52839bD(String str) {
            AppMethodBeat.m2504i(90816);
            Iterator it = C32186k.this.bPE.bRO.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                C41713e c41713e = (C41713e) pair.first;
                Pattern pattern = (Pattern) pair.second;
                if (pattern != null && pattern.matcher(str).matches()) {
                    boolean yl = c41713e.mo67387yl();
                    AppMethodBeat.m2505o(90816);
                    return yl;
                }
            }
            AppMethodBeat.m2505o(90816);
            return false;
        }

        /* renamed from: bE */
        public final void mo52840bE(String str) {
            AppMethodBeat.m2504i(90817);
            this.bPL = false;
            C32186k.this.mUrl = str;
            C32186k.this.bOA.bOI.mo20032wO();
            if (C32186k.this.bPz != null) {
                C32186k.this.bPz.mo3960bE(str);
            }
            AppMethodBeat.m2505o(90817);
        }

        /* renamed from: bF */
        public final void mo52841bF(String str) {
            AppMethodBeat.m2504i(90818);
            C32186k.this.mUrl = str;
            C32186k.this.bOA.bOI.onReady();
            if (C32186k.this.bPz != null) {
                C32186k.this.bOA.mo60230bw(C32186k.this.bPz.mo3962xt());
                C32186k.this.bPz.mo3961bF(str);
            }
            AppMethodBeat.m2505o(90818);
        }

        /* renamed from: bG */
        public final WebResourceResponse mo52842bG(String str) {
            AppMethodBeat.m2504i(90819);
            WebResourceResponse bR = C32186k.this.bPD.mo33006bR(str);
            AppMethodBeat.m2505o(90819);
            return bR;
        }

        /* renamed from: a */
        public final WebResourceResponse mo52838a(WebResourceRequest webResourceRequest, Bundle bundle) {
            WebResourceResponse a;
            AppMethodBeat.m2504i(90820);
            if (C32186k.this.bPz != null) {
                a = C32186k.this.bPz.mo3959a(webResourceRequest, bundle);
                if (a != null) {
                    AppMethodBeat.m2505o(90820);
                    return a;
                }
            }
            a = C32186k.this.bPD.mo33006bR(webResourceRequest.getUrl().toString());
            AppMethodBeat.m2505o(90820);
            return a;
        }

        /* renamed from: bH */
        public final String mo52843bH(String str) {
            AppMethodBeat.m2504i(90821);
            String bx = C32186k.this.bOA.bOI.mo20030bx(str);
            AppMethodBeat.m2505o(90821);
            return bx;
        }

        /* renamed from: bI */
        public final void mo52844bI(String str) {
            boolean z = false;
            AppMethodBeat.m2504i(90822);
            if (!this.bPL) {
                if (!(str == null || str.length() == 0)) {
                    String path = Uri.parse(str).getPath();
                    if (path != null && path.trim().endsWith("html")) {
                        z = true;
                    }
                }
                if (z) {
                    AppMethodBeat.m2505o(90822);
                    return;
                }
                C32186k.this.bOA.bOI.onReady();
                if (C32186k.this.bPz != null) {
                    C32186k.this.bOA.mo60230bw(C32186k.this.bPz.mo3962xt());
                }
                this.bPL = true;
            }
            AppMethodBeat.m2505o(90822);
        }
    }

    public C32186k(Context context, Class<? extends C37407a> cls) {
        Class cls2;
        AppMethodBeat.m2504i(90823);
        this.bPx = new MutableContextWrapper(context);
        if (cls2 == null) {
            cls2 = C25703a.class;
        }
        this.bPy = cls2;
        this.mHandler = new Handler(Looper.getMainLooper());
        m52488xn();
        this.bPA = (C37407a) C41166a.m71619be(this.bPy).mo65755ab(this.bPx).object;
        this.bPA.setWebCore(this);
        this.bPA.mo7543a(this.bPG);
        this.bOA = new C37392o(this.bPA);
        AppMethodBeat.m2505o(90823);
    }

    /* renamed from: xn */
    private void m52488xn() {
        AppMethodBeat.m2504i(90824);
        this.bPD = new C17830b();
        this.bPE = new C17832d();
        m52489xo();
        AppMethodBeat.m2505o(90824);
    }

    /* renamed from: xo */
    private void m52489xo() {
        AppMethodBeat.m2504i(90825);
        this.bPD.mo33005a(new C25700a(this.bPx));
        AppMethodBeat.m2505o(90825);
    }

    /* renamed from: xp */
    public final C25685a mo52833xp() {
        return this.bPC == null ? C25685a.bPT : this.bPC;
    }

    public final void setContext(Context context) {
        AppMethodBeat.m2504i(90826);
        this.bPx.setBaseContext(context);
        if (this.bPA != null) {
            this.bPA.setContext(context);
        }
        AppMethodBeat.m2505o(90826);
    }

    /* renamed from: a */
    public final void mo52827a(List<Class<? extends C37393a>> list, C25687b c25687b) {
        AppMethodBeat.m2504i(90827);
        for (Class cls : list) {
            try {
                final C37393a c37393a = (C37393a) cls.newInstance();
                try {
                    c37393a.bOY = c25687b;
                    this.bPF.put(c37393a.name(), cls);
                    C37392o c37392o = this.bOA;
                    c37392o.bOJ.put(c37393a.name(), new C45119l() {
                        /* renamed from: a */
                        public final void mo52836a(C0986k c0986k) {
                            AppMethodBeat.m2504i(90813);
                            C32186k c32186k = C32186k.this;
                            C37393a c37393a = c37393a;
                            c32186k.mo52833xp().mo32975a(c37393a.name(), new C321882(c37393a, c0986k));
                            AppMethodBeat.m2505o(90813);
                        }
                    });
                } catch (Exception e) {
                    C45124d.m82927e("Luggage.LuggageWebCore", "registerJsApi: ".concat(String.valueOf(e)));
                }
            } catch (Exception e2) {
                C45124d.m82928e("Luggage.LuggageWebCore", "JsApi Initialize failed, %s, %s", cls.getName(), e2);
            }
        }
        AppMethodBeat.m2505o(90827);
    }

    /* renamed from: a */
    public final void mo52826a(final C17817c c17817c) {
        AppMethodBeat.m2504i(90828);
        C321893 c321893 = new C45121c() {
            /* renamed from: a */
            public final void mo52837a(C41704b c41704b) {
                AppMethodBeat.m2504i(90815);
                if (c17817c == null) {
                    C45124d.m82927e("Luggage.LuggageWebCore", "Null Event, Ignore");
                    AppMethodBeat.m2505o(90815);
                    return;
                }
                if (c41704b == C41704b.PASS) {
                    C37392o c37392o = C32186k.this.bOA;
                    c37392o.bOH.mo52820a(new C37387d(c17817c.name(), c17817c.mo7075wQ()));
                }
                AppMethodBeat.m2505o(90815);
            }
        };
        C25685a xp = mo52833xp();
        c17817c.name();
        xp.mo32974a(c321893);
        AppMethodBeat.m2505o(90828);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: xq */
    public final void mo52834xq() {
        AppMethodBeat.m2504i(90829);
        if (this.bPB) {
            this.bPB = false;
            m52488xn();
        }
        AppMethodBeat.m2505o(90829);
    }

    @Deprecated
    /* renamed from: xr */
    public final <T> T mo52835xr() {
        AppMethodBeat.m2504i(90830);
        try {
            View view = getView();
            AppMethodBeat.m2505o(90830);
            return view;
        } catch (Exception e) {
            C45124d.m82928e(getClass().getSimpleName(), "CoreImpl cast failed", e);
            AppMethodBeat.m2505o(90830);
            return null;
        }
    }

    public final View getView() {
        AppMethodBeat.m2504i(90831);
        View view = this.bPA.getView();
        AppMethodBeat.m2505o(90831);
        return view;
    }

    public final void loadUrl(String str) {
        AppMethodBeat.m2504i(90832);
        this.bPA.loadUrl(str);
        AppMethodBeat.m2505o(90832);
    }

    public final void stopLoading() {
        AppMethodBeat.m2504i(90833);
        this.bPA.stopLoading();
        AppMethodBeat.m2505o(90833);
    }

    /* renamed from: xs */
    private void m52490xs() {
        AppMethodBeat.m2504i(90834);
        ViewParent parent = getView().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(getView());
        }
        AppMethodBeat.m2505o(90834);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(90835);
        m52490xs();
        if (!this.bPB) {
            this.bPA.destroy();
        }
        AppMethodBeat.m2505o(90835);
    }
}
