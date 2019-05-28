package com.tencent.luggage.d;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

public class n extends e implements b {
    public View WL;
    public k bPN;
    protected SwipeBackLayout bPO;
    public Bundle bPP;
    private String bPQ;
    private l bPz;

    public static class a extends com.tencent.luggage.d.e.a {
        protected a(com.tencent.luggage.d.e.a aVar) {
            super(aVar);
        }

        public void a(n nVar, String str) {
            AppMethodBeat.i(90847);
            if (this.bPh instanceof a) {
                ((a) this.bPh).a(nVar, str);
            }
            AppMethodBeat.o(90847);
        }

        public void b(n nVar, String str) {
            AppMethodBeat.i(90848);
            if (this.bPh instanceof a) {
                ((a) this.bPh).b(nVar, str);
            }
            AppMethodBeat.o(90848);
        }

        public WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.i(90849);
            if (this.bPh instanceof a) {
                WebResourceResponse a = ((a) this.bPh).a(webResourceRequest, bundle);
                AppMethodBeat.o(90849);
                return a;
            }
            AppMethodBeat.o(90849);
            return null;
        }
    }

    public n(g gVar, Bundle bundle) {
        this(gVar, null, bundle);
    }

    public n(g gVar, k kVar, Bundle bundle) {
        super(gVar);
        AppMethodBeat.i(90850);
        this.bPQ = null;
        this.bPz = new l() {
            public final void bE(String str) {
                AppMethodBeat.i(90843);
                if (n.this.xu() != null) {
                    n.this.xu().a(n.this, str);
                }
                AppMethodBeat.o(90843);
            }

            public final void bF(String str) {
                AppMethodBeat.i(90844);
                if (n.this.xu() != null) {
                    n.this.xu().b(n.this, str);
                }
                n.this.wS();
                AppMethodBeat.o(90844);
            }

            public final String xt() {
                AppMethodBeat.i(90845);
                String a = n.a(n.this);
                AppMethodBeat.o(90845);
                return a;
            }

            public final WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
                AppMethodBeat.i(90846);
                if (n.this.xu() != null) {
                    WebResourceResponse a = n.this.xu().a(webResourceRequest, bundle);
                    AppMethodBeat.o(90846);
                    return a;
                }
                AppMethodBeat.o(90846);
                return null;
            }
        };
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.bPP = bundle;
        this.bPN = kVar;
        k kVar2 = this.bPN;
        if (kVar2 == null) {
            kVar2 = this.bPe.xd();
        }
        if (kVar2 == null) {
            kVar2 = new k(this.mContext, this.bPe.xe());
        }
        this.bPN = kVar2;
        kVar2 = this.bPN;
        kVar2.a(this.bPe.xj(), this);
        kVar2.bPz = this.bPz;
        View wR = wR();
        this.bPO = new SwipeBackLayout(this.mContext);
        this.bPO.setScrimColor(0);
        this.bPO.addView(wR);
        this.bPO.setContentView(wR);
        final boolean[] zArr = new boolean[]{false};
        this.bPO.a(new me.imid.swipebacklayout.lib.SwipeBackLayout.a() {
            public final void xv() {
                AppMethodBeat.i(90841);
                if (n.this.bPe.xh().size() <= 1) {
                    n.this.bPO.setEnableGesture(false);
                }
                AppMethodBeat.o(90841);
            }

            public final void l(MotionEvent motionEvent) {
            }

            public final boolean ba(boolean z) {
                return false;
            }

            public final void h(int i, float f) {
                e eVar;
                AppMethodBeat.i(90842);
                n nVar = n.this;
                int indexOf = nVar.bPe.xh().indexOf(nVar);
                if (indexOf >= nVar.bPe.xh().size() - 1) {
                    eVar = null;
                } else {
                    eVar = (e) nVar.bPe.xh().get(indexOf + 1);
                }
                if (eVar == null) {
                    AppMethodBeat.o(90842);
                    return;
                }
                if (Float.compare(1.0f, f) <= 0 && !zArr[0]) {
                    View contentView = eVar.getContentView();
                    contentView.clearAnimation();
                    contentView.setTranslationX(0.0f);
                    n.this.bPe.xi().aZ(false);
                    zArr[0] = true;
                }
                d.i("", "scrollPercent %f", Float.valueOf(f));
                AppMethodBeat.o(90842);
            }
        });
        this.WL = this.bPO;
        AppMethodBeat.o(90850);
    }

    /* Access modifiers changed, original: protected */
    public View wR() {
        AppMethodBeat.i(90852);
        View view = this.bPN.getView();
        AppMethodBeat.o(90852);
        return view;
    }

    public final View getContentView() {
        return this.WL;
    }

    public final void a(com.tencent.luggage.d.e.a aVar) {
        AppMethodBeat.i(90853);
        if (aVar instanceof a) {
            this.bPf = aVar;
            AppMethodBeat.o(90853);
            return;
        }
        this.bPf = new a(aVar);
        AppMethodBeat.o(90853);
    }

    public final a xu() {
        return (a) this.bPf;
    }

    public final void destroy() {
        AppMethodBeat.i(90855);
        wZ();
        this.bPN.destroy();
        AppMethodBeat.o(90855);
    }

    /* Access modifiers changed, original: protected */
    public String xt() {
        return "";
    }

    public void g(String str, Bundle bundle) {
        AppMethodBeat.i(90851);
        this.bPN.loadUrl(str);
        AppMethodBeat.o(90851);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean wY() {
        AppMethodBeat.i(90854);
        if (this.bPN.bPA.canGoBack()) {
            this.bPN.bPA.goBack();
            AppMethodBeat.o(90854);
            return true;
        }
        AppMethodBeat.o(90854);
        return false;
    }
}
