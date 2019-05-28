package com.tencent.luggage.p146d;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.p146d.C8860e.C8862a;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p1358me.imid.swipebacklayout.lib.SwipeBackLayout;
import p1358me.imid.swipebacklayout.lib.SwipeBackLayout.C24597a;

/* renamed from: com.tencent.luggage.d.n */
public class C17821n extends C8860e implements C25687b {
    /* renamed from: WL */
    public View f4285WL;
    public C32186k bPN;
    protected SwipeBackLayout bPO;
    public Bundle bPP;
    private String bPQ;
    private C17819l bPz;

    /* renamed from: com.tencent.luggage.d.n$2 */
    class C09892 extends C17819l {
        C09892() {
        }

        /* renamed from: bE */
        public final void mo3960bE(String str) {
            AppMethodBeat.m2504i(90843);
            if (C17821n.this.mo32976xu() != null) {
                C17821n.this.mo32976xu().mo32978a(C17821n.this, str);
            }
            AppMethodBeat.m2505o(90843);
        }

        /* renamed from: bF */
        public final void mo3961bF(String str) {
            AppMethodBeat.m2504i(90844);
            if (C17821n.this.mo32976xu() != null) {
                C17821n.this.mo32976xu().mo32979b(C17821n.this, str);
            }
            C17821n.this.mo20043wS();
            AppMethodBeat.m2505o(90844);
        }

        /* renamed from: xt */
        public final String mo3962xt() {
            AppMethodBeat.m2504i(90845);
            String a = C17821n.m27873a(C17821n.this);
            AppMethodBeat.m2505o(90845);
            return a;
        }

        /* renamed from: a */
        public final WebResourceResponse mo3959a(WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.m2504i(90846);
            if (C17821n.this.mo32976xu() != null) {
                WebResourceResponse a = C17821n.this.mo32976xu().mo32977a(webResourceRequest, bundle);
                AppMethodBeat.m2505o(90846);
                return a;
            }
            AppMethodBeat.m2505o(90846);
            return null;
        }
    }

    /* renamed from: com.tencent.luggage.d.n$a */
    public static class C17822a extends C8862a {
        protected C17822a(C8862a c8862a) {
            super(c8862a);
        }

        /* renamed from: a */
        public void mo32978a(C17821n c17821n, String str) {
            AppMethodBeat.m2504i(90847);
            if (this.bPh instanceof C17822a) {
                ((C17822a) this.bPh).mo32978a(c17821n, str);
            }
            AppMethodBeat.m2505o(90847);
        }

        /* renamed from: b */
        public void mo32979b(C17821n c17821n, String str) {
            AppMethodBeat.m2504i(90848);
            if (this.bPh instanceof C17822a) {
                ((C17822a) this.bPh).mo32979b(c17821n, str);
            }
            AppMethodBeat.m2505o(90848);
        }

        /* renamed from: a */
        public WebResourceResponse mo32977a(WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.m2504i(90849);
            if (this.bPh instanceof C17822a) {
                WebResourceResponse a = ((C17822a) this.bPh).mo32977a(webResourceRequest, bundle);
                AppMethodBeat.m2505o(90849);
                return a;
            }
            AppMethodBeat.m2505o(90849);
            return null;
        }
    }

    public C17821n(C41709g c41709g, Bundle bundle) {
        this(c41709g, null, bundle);
    }

    public C17821n(C41709g c41709g, C32186k c32186k, Bundle bundle) {
        super(c41709g);
        AppMethodBeat.m2504i(90850);
        this.bPQ = null;
        this.bPz = new C09892();
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.bPP = bundle;
        this.bPN = c32186k;
        C32186k c32186k2 = this.bPN;
        if (c32186k2 == null) {
            c32186k2 = this.bPe.mo43474xd();
        }
        if (c32186k2 == null) {
            c32186k2 = new C32186k(this.mContext, this.bPe.mo43475xe());
        }
        this.bPN = c32186k2;
        c32186k2 = this.bPN;
        c32186k2.mo52827a(this.bPe.mo43478xj(), this);
        c32186k2.bPz = this.bPz;
        View wR = mo20042wR();
        this.bPO = new SwipeBackLayout(this.mContext);
        this.bPO.setScrimColor(0);
        this.bPO.addView(wR);
        this.bPO.setContentView(wR);
        final boolean[] zArr = new boolean[]{false};
        this.bPO.mo65734a(new C24597a() {
            /* renamed from: xv */
            public final void mo3958xv() {
                AppMethodBeat.m2504i(90841);
                if (C17821n.this.bPe.mo43476xh().size() <= 1) {
                    C17821n.this.bPO.setEnableGesture(false);
                }
                AppMethodBeat.m2505o(90841);
            }

            /* renamed from: l */
            public final void mo3957l(MotionEvent motionEvent) {
            }

            /* renamed from: ba */
            public final boolean mo3955ba(boolean z) {
                return false;
            }

            /* renamed from: h */
            public final void mo3956h(int i, float f) {
                C8860e c8860e;
                AppMethodBeat.m2504i(90842);
                C17821n c17821n = C17821n.this;
                int indexOf = c17821n.bPe.mo43476xh().indexOf(c17821n);
                if (indexOf >= c17821n.bPe.mo43476xh().size() - 1) {
                    c8860e = null;
                } else {
                    c8860e = (C8860e) c17821n.bPe.mo43476xh().get(indexOf + 1);
                }
                if (c8860e == null) {
                    AppMethodBeat.m2505o(90842);
                    return;
                }
                if (Float.compare(1.0f, f) <= 0 && !zArr[0]) {
                    View contentView = c8860e.getContentView();
                    contentView.clearAnimation();
                    contentView.setTranslationX(0.0f);
                    C17821n.this.bPe.mo43477xi().mo60233aZ(false);
                    zArr[0] = true;
                }
                C45124d.m82930i("", "scrollPercent %f", Float.valueOf(f));
                AppMethodBeat.m2505o(90842);
            }
        });
        this.f4285WL = this.bPO;
        AppMethodBeat.m2505o(90850);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: wR */
    public View mo20042wR() {
        AppMethodBeat.m2504i(90852);
        View view = this.bPN.getView();
        AppMethodBeat.m2505o(90852);
        return view;
    }

    public final View getContentView() {
        return this.f4285WL;
    }

    /* renamed from: a */
    public final void mo20035a(C8862a c8862a) {
        AppMethodBeat.m2504i(90853);
        if (c8862a instanceof C17822a) {
            this.bPf = c8862a;
            AppMethodBeat.m2505o(90853);
            return;
        }
        this.bPf = new C17822a(c8862a);
        AppMethodBeat.m2505o(90853);
    }

    /* renamed from: xu */
    public final C17822a mo32976xu() {
        return (C17822a) this.bPf;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(90855);
        mo20050wZ();
        this.bPN.destroy();
        AppMethodBeat.m2505o(90855);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: xt */
    public String mo30766xt() {
        return "";
    }

    /* renamed from: g */
    public void mo20038g(String str, Bundle bundle) {
        AppMethodBeat.m2504i(90851);
        this.bPN.loadUrl(str);
        AppMethodBeat.m2505o(90851);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: wY */
    public final boolean mo20049wY() {
        AppMethodBeat.m2504i(90854);
        if (this.bPN.bPA.canGoBack()) {
            this.bPN.bPA.goBack();
            AppMethodBeat.m2505o(90854);
            return true;
        }
        AppMethodBeat.m2505o(90854);
        return false;
    }
}
