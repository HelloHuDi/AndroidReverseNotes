package com.tencent.luggage.d;

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
import com.tencent.luggage.bridge.l;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.d.a.c;
import com.tencent.luggage.webview.a;
import com.tencent.luggage.webview.a.b;
import com.tencent.luggage.webview.a.d;
import com.tencent.luggage.webview.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class k implements b {
    o bOA;
    public a bPA;
    boolean bPB = false;
    public com.tencent.luggage.d.a.a bPC;
    public b bPD;
    d bPE;
    final ConcurrentHashMap<String, Class<? extends a>> bPF = new ConcurrentHashMap();
    private a.a bPG = new a.a() {
        private boolean bPL = false;

        public final boolean bD(String str) {
            AppMethodBeat.i(90816);
            Iterator it = k.this.bPE.bRO.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                e eVar = (e) pair.first;
                Pattern pattern = (Pattern) pair.second;
                if (pattern != null && pattern.matcher(str).matches()) {
                    boolean yl = eVar.yl();
                    AppMethodBeat.o(90816);
                    return yl;
                }
            }
            AppMethodBeat.o(90816);
            return false;
        }

        public final void bE(String str) {
            AppMethodBeat.i(90817);
            this.bPL = false;
            k.this.mUrl = str;
            k.this.bOA.bOI.wO();
            if (k.this.bPz != null) {
                k.this.bPz.bE(str);
            }
            AppMethodBeat.o(90817);
        }

        public final void bF(String str) {
            AppMethodBeat.i(90818);
            k.this.mUrl = str;
            k.this.bOA.bOI.onReady();
            if (k.this.bPz != null) {
                k.this.bOA.bw(k.this.bPz.xt());
                k.this.bPz.bF(str);
            }
            AppMethodBeat.o(90818);
        }

        public final WebResourceResponse bG(String str) {
            AppMethodBeat.i(90819);
            WebResourceResponse bR = k.this.bPD.bR(str);
            AppMethodBeat.o(90819);
            return bR;
        }

        public final WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
            WebResourceResponse a;
            AppMethodBeat.i(90820);
            if (k.this.bPz != null) {
                a = k.this.bPz.a(webResourceRequest, bundle);
                if (a != null) {
                    AppMethodBeat.o(90820);
                    return a;
                }
            }
            a = k.this.bPD.bR(webResourceRequest.getUrl().toString());
            AppMethodBeat.o(90820);
            return a;
        }

        public final String bH(String str) {
            AppMethodBeat.i(90821);
            String bx = k.this.bOA.bOI.bx(str);
            AppMethodBeat.o(90821);
            return bx;
        }

        public final void bI(String str) {
            boolean z = false;
            AppMethodBeat.i(90822);
            if (!this.bPL) {
                if (!(str == null || str.length() == 0)) {
                    String path = Uri.parse(str).getPath();
                    if (path != null && path.trim().endsWith("html")) {
                        z = true;
                    }
                }
                if (z) {
                    AppMethodBeat.o(90822);
                    return;
                }
                k.this.bOA.bOI.onReady();
                if (k.this.bPz != null) {
                    k.this.bOA.bw(k.this.bPz.xt());
                }
                this.bPL = true;
            }
            AppMethodBeat.o(90822);
        }
    };
    private final MutableContextWrapper bPx;
    final Class<? extends a> bPy;
    public l bPz;
    private Handler mHandler;
    public String mUrl;

    /* renamed from: com.tencent.luggage.d.k$2 */
    class AnonymousClass2 implements c {
        final /* synthetic */ a bPH;
        final /* synthetic */ com.tencent.luggage.bridge.k bPJ;

        AnonymousClass2(a aVar, com.tencent.luggage.bridge.k kVar) {
            this.bPH = aVar;
            this.bPJ = kVar;
        }

        public final void a(com.tencent.luggage.d.a.b bVar) {
            AppMethodBeat.i(90814);
            if (bVar == com.tencent.luggage.d.a.b.PASS) {
                a aVar = this.bPH;
                a aVar2 = this.bPH;
                com.tencent.luggage.bridge.k kVar = this.bPJ;
                a.a aVar3 = new a.a();
                aVar3.bOZ = aVar2.bOY;
                aVar3.bPa = kVar;
                aVar.a(aVar3);
                AppMethodBeat.o(90814);
                return;
            }
            this.bPJ.a("system:access_denied", null);
            AppMethodBeat.o(90814);
        }
    }

    public k(Context context, Class<? extends a> cls) {
        Class cls2;
        AppMethodBeat.i(90823);
        this.bPx = new MutableContextWrapper(context);
        if (cls2 == null) {
            cls2 = com.tencent.luggage.webview.default_impl.a.class;
        }
        this.bPy = cls2;
        this.mHandler = new Handler(Looper.getMainLooper());
        xn();
        this.bPA = (a) org.a.a.be(this.bPy).ab(this.bPx).object;
        this.bPA.setWebCore(this);
        this.bPA.a(this.bPG);
        this.bOA = new o(this.bPA);
        AppMethodBeat.o(90823);
    }

    private void xn() {
        AppMethodBeat.i(90824);
        this.bPD = new b();
        this.bPE = new d();
        xo();
        AppMethodBeat.o(90824);
    }

    private void xo() {
        AppMethodBeat.i(90825);
        this.bPD.a(new com.tencent.luggage.webview.a.a(this.bPx));
        AppMethodBeat.o(90825);
    }

    public final com.tencent.luggage.d.a.a xp() {
        return this.bPC == null ? com.tencent.luggage.d.a.a.bPT : this.bPC;
    }

    public final void setContext(Context context) {
        AppMethodBeat.i(90826);
        this.bPx.setBaseContext(context);
        if (this.bPA != null) {
            this.bPA.setContext(context);
        }
        AppMethodBeat.o(90826);
    }

    public final void a(List<Class<? extends a>> list, b bVar) {
        AppMethodBeat.i(90827);
        for (Class cls : list) {
            try {
                final a aVar = (a) cls.newInstance();
                try {
                    aVar.bOY = bVar;
                    this.bPF.put(aVar.name(), cls);
                    o oVar = this.bOA;
                    oVar.bOJ.put(aVar.name(), new l() {
                        public final void a(com.tencent.luggage.bridge.k kVar) {
                            AppMethodBeat.i(90813);
                            k kVar2 = k.this;
                            a aVar = aVar;
                            kVar2.xp().a(aVar.name(), new AnonymousClass2(aVar, kVar));
                            AppMethodBeat.o(90813);
                        }
                    });
                } catch (Exception e) {
                    com.tencent.luggage.g.d.e("Luggage.LuggageWebCore", "registerJsApi: ".concat(String.valueOf(e)));
                }
            } catch (Exception e2) {
                com.tencent.luggage.g.d.e("Luggage.LuggageWebCore", "JsApi Initialize failed, %s, %s", cls.getName(), e2);
            }
        }
        AppMethodBeat.o(90827);
    }

    public final void a(final c cVar) {
        AppMethodBeat.i(90828);
        AnonymousClass3 anonymousClass3 = new c() {
            public final void a(com.tencent.luggage.d.a.b bVar) {
                AppMethodBeat.i(90815);
                if (cVar == null) {
                    com.tencent.luggage.g.d.e("Luggage.LuggageWebCore", "Null Event, Ignore");
                    AppMethodBeat.o(90815);
                    return;
                }
                if (bVar == com.tencent.luggage.d.a.b.PASS) {
                    o oVar = k.this.bOA;
                    oVar.bOH.a(new com.tencent.luggage.bridge.d(cVar.name(), cVar.wQ()));
                }
                AppMethodBeat.o(90815);
            }
        };
        com.tencent.luggage.d.a.a xp = xp();
        cVar.name();
        xp.a(anonymousClass3);
        AppMethodBeat.o(90828);
    }

    /* Access modifiers changed, original: final */
    public final void xq() {
        AppMethodBeat.i(90829);
        if (this.bPB) {
            this.bPB = false;
            xn();
        }
        AppMethodBeat.o(90829);
    }

    @Deprecated
    public final <T> T xr() {
        AppMethodBeat.i(90830);
        try {
            View view = getView();
            AppMethodBeat.o(90830);
            return view;
        } catch (Exception e) {
            com.tencent.luggage.g.d.e(getClass().getSimpleName(), "CoreImpl cast failed", e);
            AppMethodBeat.o(90830);
            return null;
        }
    }

    public final View getView() {
        AppMethodBeat.i(90831);
        View view = this.bPA.getView();
        AppMethodBeat.o(90831);
        return view;
    }

    public final void loadUrl(String str) {
        AppMethodBeat.i(90832);
        this.bPA.loadUrl(str);
        AppMethodBeat.o(90832);
    }

    public final void stopLoading() {
        AppMethodBeat.i(90833);
        this.bPA.stopLoading();
        AppMethodBeat.o(90833);
    }

    private void xs() {
        AppMethodBeat.i(90834);
        ViewParent parent = getView().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(getView());
        }
        AppMethodBeat.o(90834);
    }

    public final void destroy() {
        AppMethodBeat.i(90835);
        xs();
        if (!this.bPB) {
            this.bPA.destroy();
        }
        AppMethodBeat.o(90835);
    }
}
