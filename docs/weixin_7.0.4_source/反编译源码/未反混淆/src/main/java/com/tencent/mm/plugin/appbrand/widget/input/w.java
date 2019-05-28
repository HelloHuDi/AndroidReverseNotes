package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.s;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public class w extends LinearLayout implements ac, b {
    private static final int huq = R.id.r;
    private static final b jfY = new f();
    private Context context;
    private final Runnable jfK = new Runnable() {
        public final void run() {
            AppMethodBeat.i(123767);
            if (w.this.jfQ == null || !s.av(w.this.jfQ)) {
                AppMethodBeat.o(123767);
            } else if (w.this.jfP.aQZ()) {
                ab.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
                w.this.post(this);
                AppMethodBeat.o(123767);
            } else {
                w.c(w.this);
                AppMethodBeat.o(123767);
            }
        }
    };
    private d jfL;
    private c jfM;
    private boolean jfN = false;
    private e jfO;
    private com.tencent.mm.plugin.appbrand.widget.input.panel.e jfP;
    private View jfQ;
    private View jfR;
    private ImageButton jfS;
    private boolean jfT;
    private View jfU;
    private boolean jfV;
    protected EditText jfW;
    private final ad jfX;
    private int state = 2;

    public interface a {
        void setIsHide(boolean z);
    }

    interface b {
        void c(w wVar, int i);

        void m(w wVar);

        void n(w wVar);

        void o(w wVar);

        void p(w wVar);
    }

    public interface c {
        void fd(boolean z);
    }

    public interface d {
        boolean EH(String str);
    }

    public interface e {
        void nS(int i);
    }

    static final class f implements b {
        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }

        public final void m(w wVar) {
            AppMethodBeat.i(123773);
            if (wVar.isShown()) {
                wVar.jfQ.setVisibility(0);
            }
            wVar.jfP.aRE();
            AppMethodBeat.o(123773);
        }

        public final void n(w wVar) {
            AppMethodBeat.i(123774);
            if (n.ct(wVar)) {
                wVar.qG(8);
                w.g(wVar);
                AppMethodBeat.o(123774);
                return;
            }
            if (wVar.isShown()) {
                wVar.jfQ.setVisibility(0);
            }
            if (wVar.jfT) {
                wVar.jfP.aRD();
                AppMethodBeat.o(123774);
                return;
            }
            wVar.jfP.aRE();
            AppMethodBeat.o(123774);
        }

        public final void c(w wVar, int i) {
            AppMethodBeat.i(123775);
            if (n.ct(wVar)) {
                wVar.qG(8);
                AppMethodBeat.o(123775);
            } else if (wVar.jfQ == null || i <= 0) {
                AppMethodBeat.o(123775);
            } else {
                w.b(wVar, i);
                AppMethodBeat.o(123775);
            }
        }

        public final void o(w wVar) {
            AppMethodBeat.i(123776);
            wVar.jfX.showVKB();
            w.j(wVar);
            AppMethodBeat.o(123776);
        }

        public final void p(w wVar) {
            AppMethodBeat.i(123777);
            wVar.jfX.aqX();
            w.k(wVar);
            wVar.oD(x.gs(wVar.context));
            AppMethodBeat.o(123777);
        }
    }

    static final class g extends FrameLayout implements a {
        private boolean jgc = false;

        public g(Context context) {
            super(context);
            AppMethodBeat.i(123778);
            LayoutInflater.from(context).inflate(R.layout.en, this);
            AppMethodBeat.o(123778);
        }

        public final void setIsHide(boolean z) {
            AppMethodBeat.i(123779);
            Object obj = z != this.jgc ? 1 : null;
            this.jgc = z;
            if (obj != null && (VERSION.SDK_INT < 18 || !isInLayout())) {
                requestLayout();
            }
            AppMethodBeat.o(123779);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onMeasure(int i, int i2) {
            AppMethodBeat.i(123780);
            if (this.jgc || !isShown()) {
                i = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
                i2 = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
            }
            super.onMeasure(i, i2);
            AppMethodBeat.o(123780);
        }
    }

    static /* synthetic */ void b(w wVar, int i) {
        AppMethodBeat.i(123812);
        wVar.setPanelHeightImpl(i);
        AppMethodBeat.o(123812);
    }

    static /* synthetic */ void g(w wVar) {
        AppMethodBeat.i(123811);
        wVar.aRc();
        AppMethodBeat.o(123811);
    }

    static /* synthetic */ void j(w wVar) {
        AppMethodBeat.i(123813);
        wVar.aRe();
        AppMethodBeat.o(123813);
    }

    static /* synthetic */ void k(w wVar) {
        AppMethodBeat.i(123814);
        wVar.aRd();
        AppMethodBeat.o(123814);
    }

    static {
        AppMethodBeat.i(123815);
        AppMethodBeat.o(123815);
    }

    public static w cN(View view) {
        AppMethodBeat.i(123781);
        w wVar = (w) view.getRootView().findViewById(huq);
        AppMethodBeat.o(123781);
        return wVar;
    }

    public static w cO(View view) {
        AppMethodBeat.i(123782);
        n cG = n.cG(view);
        if (cG.getOnLayoutListener() == null || !(cG.getOnLayoutListener() instanceof u)) {
            cG.setOnLayoutListener(new u());
        }
        w cN = cN(view);
        if (cN == null) {
            Context cY = com.tencent.mm.ui.statusbar.d.cY(view.getContext());
            if (cY == null) {
                cY = view.getContext();
                while (cY != null) {
                    if (!(cY instanceof ContextThemeWrapper)) {
                        if (!(cY instanceof ContextWrapper)) {
                            break;
                        }
                        Context baseContext = ((ContextWrapper) cY).getBaseContext();
                        if (baseContext == cY) {
                            break;
                        }
                        cY = baseContext;
                    } else {
                        cY = (ContextThemeWrapper) cY;
                        break;
                    }
                }
                cY = null;
            }
            w wVar = new w(cY);
            cG.cH(wVar);
            cN = wVar;
        }
        AppMethodBeat.o(123782);
        return cN;
    }

    public final boolean aQV() {
        AppMethodBeat.i(123783);
        boolean aQV = this.jfP.aQV();
        AppMethodBeat.o(123783);
        return aQV;
    }

    public final void oD(int i) {
        AppMethodBeat.i(123784);
        ab.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", Integer.valueOf(i));
        jfY.c(this, i);
        AppMethodBeat.o(123784);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(123785);
        super.onLayout(z, i, i2, i3, i4);
        ab.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", Integer.valueOf(getMeasuredHeight()));
        AppMethodBeat.o(123785);
    }

    public final void et(boolean z) {
        AppMethodBeat.i(123786);
        ab.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", Boolean.valueOf(z));
        if (z) {
            qG(0);
            aRe();
            AppMethodBeat.o(123786);
            return;
        }
        if (isShown()) {
            if (this.jfT && 1 == this.state) {
                aRd();
                AppMethodBeat.o(123786);
                return;
            }
            hide();
        }
        AppMethodBeat.o(123786);
    }

    private void setPanelHeightImpl(int i) {
        AppMethodBeat.i(123787);
        if (this.jfP.qD(i)) {
            this.jfK.run();
        }
        AppMethodBeat.o(123787);
    }

    public int getMinimumHeight() {
        AppMethodBeat.i(123788);
        if (getVisibility() == 0) {
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(getContext(), 48);
            AppMethodBeat.o(123788);
            return fromDPToPix;
        }
        AppMethodBeat.o(123788);
        return 0;
    }

    public void setOnSmileyChosenListener(d dVar) {
        this.jfL = dVar;
    }

    public void setOnDoneListener(c cVar) {
        this.jfM = cVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void fd(boolean z) {
        AppMethodBeat.i(123789);
        if (!(this.jfN || this.jfM == null)) {
            this.jfN = true;
            this.jfM.fd(z);
            this.jfN = false;
        }
        AppMethodBeat.o(123789);
    }

    public void setOnVisibilityChangedListener(e eVar) {
        this.jfO = eVar;
    }

    public w(Context context) {
        ad adVar;
        super(context);
        AppMethodBeat.i(123790);
        this.context = context;
        if (context instanceof ad) {
            adVar = (ad) context;
        } else {
            adVar = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
        }
        this.jfX = adVar;
        super.setId(huq);
        setOrientation(1);
        View aBL = aBL();
        this.jfR = aBL;
        addView(aBL);
        com.tencent.mm.plugin.appbrand.widget.input.panel.e.b bVar = (com.tencent.mm.plugin.appbrand.widget.input.panel.e.b) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.widget.input.panel.e.b.class);
        this.jfP = bVar == null ? null : bVar.cT(this.context);
        if (this.jfP == null) {
            this.jfP = new com.tencent.mm.plugin.appbrand.widget.input.panel.e.a(this.context);
        }
        this.jfQ = this.jfP.getPanelView();
        this.jfQ.setVisibility(8);
        this.jfQ.setBackgroundColor(0);
        this.jfP.setOnTextOperationListener(new com.tencent.mm.plugin.appbrand.widget.input.panel.f() {
            public final void append(String str) {
                AppMethodBeat.i(123770);
                if (w.this.jfL != null) {
                    w.this.jfL.EH(str);
                }
                AppMethodBeat.o(123770);
            }

            public final void aRg() {
                AppMethodBeat.i(123771);
                if (w.this.jfL != null) {
                    w.this.jfL.EH("[DELETE_EMOTION]");
                }
                AppMethodBeat.o(123771);
            }
        });
        addView(this.jfQ);
        aBJ();
        AppMethodBeat.o(123790);
    }

    public void setId(int i) {
    }

    /* Access modifiers changed, original: protected|final */
    public final void qE(int i) {
        AppMethodBeat.i(139079);
        super.setId(i);
        AppMethodBeat.o(139079);
    }

    /* Access modifiers changed, original: protected */
    public <T extends View & a> T aBL() {
        AppMethodBeat.i(123792);
        g gVar = new g(getContext());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, ah.getResources().getDrawable(R.drawable.bix));
        stateListDrawable.addState(new int[0], ah.getResources().getDrawable(R.drawable.biw));
        this.jfS = (ImageButton) gVar.findViewById(R.id.z3);
        this.jfS.setSelected(false);
        this.jfS.setImageDrawable(stateListDrawable);
        this.jfS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(123768);
                if (view.isSelected()) {
                    w.jfY.o(w.this);
                    view.setSelected(false);
                    AppMethodBeat.o(123768);
                    return;
                }
                w.jfY.p(w.this);
                view.setSelected(true);
                AppMethodBeat.o(123768);
            }
        });
        this.jfU = gVar.findViewById(R.id.z2);
        this.jfU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(123769);
                w.this.fd(true);
                AppMethodBeat.o(123769);
            }
        });
        AppMethodBeat.o(123792);
        return gVar;
    }

    private void aRa() {
        AppMethodBeat.i(123793);
        ((u) n.cG(this).getOnLayoutListener()).jft = this;
        AppMethodBeat.o(123793);
    }

    private void aRb() {
        AppMethodBeat.i(123794);
        ((u) n.cG(this).getOnLayoutListener()).jft = null;
        AppMethodBeat.o(123794);
    }

    private void qF(final int i) {
        AppMethodBeat.i(123795);
        final boolean z = this.jfN;
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(123772);
                int e = w.this.state;
                if (w.this.isShown()) {
                    w.this.state = i;
                } else {
                    w.this.state = 2;
                }
                if (w.this.jfO == null) {
                    AppMethodBeat.o(123772);
                    return;
                }
                if (!(e == w.this.state || z)) {
                    w.this.jfO.nS(w.this.state);
                }
                AppMethodBeat.o(123772);
            }
        });
        AppMethodBeat.o(123795);
    }

    private void aRc() {
        AppMethodBeat.i(123796);
        aRe();
        if (this.jfW != null) {
            InputMethodManager cS = aj.cS(this.jfW);
            if (!cS.showSoftInput(this.jfW, 1)) {
                cS.showSoftInput(this.jfW, 2);
            }
            AppMethodBeat.o(123796);
            return;
        }
        this.jfX.showVKB();
        AppMethodBeat.o(123796);
    }

    private void aRd() {
        AppMethodBeat.i(123797);
        jfY.n(this);
        if (this.jfS != null) {
            this.jfS.setSelected(true);
        }
        qF(1);
        AppMethodBeat.o(123797);
    }

    private void aRe() {
        AppMethodBeat.i(123798);
        jfY.m(this);
        if (this.jfS != null) {
            this.jfS.setSelected(false);
        }
        qF(0);
        AppMethodBeat.o(123798);
    }

    /* Access modifiers changed, original: protected */
    public void aBJ() {
        boolean z = false;
        AppMethodBeat.i(123799);
        if (this.jfR == null) {
            AppMethodBeat.o(123799);
            return;
        }
        int i;
        a aVar = (a) this.jfR;
        if (this.jfT) {
            i = 0;
        } else {
            i = 1;
        }
        if ((i & (!this.jfV ? 1 : 0)) != 0 || n.ct(this)) {
            z = true;
        }
        aVar.setIsHide(z);
        AppMethodBeat.o(123799);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(123800);
        super.onMeasure(i, i2);
        ab.d("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
        AppMethodBeat.o(123800);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(123801);
        super.onAttachedToWindow();
        aRa();
        AppMethodBeat.o(123801);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(123802);
        super.onDetachedFromWindow();
        qG(8);
        if (this.context != null) {
            if (this.jfW != null) {
                this.jfX.hideVKB(this.jfW);
            } else {
                this.jfX.aqX();
            }
        }
        this.jfP.onDestroy();
        if (this.jfS != null) {
            this.jfS.setOnClickListener(null);
        }
        this.jfL = null;
        removeAllViews();
        this.context = null;
        aRb();
        AppMethodBeat.o(123802);
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(123803);
        if (i == 8) {
            if (getVisibility() != i) {
                fd(false);
            }
            hide();
            AppMethodBeat.o(123803);
        } else if (i == 0) {
            show();
            AppMethodBeat.o(123803);
        } else {
            qG(i);
            AppMethodBeat.o(123803);
        }
    }

    /* Access modifiers changed, original: final */
    public final void qG(int i) {
        AppMethodBeat.i(123804);
        if (i == 0 && n.ct(this)) {
            i = 8;
        }
        if (getVisibility() == i) {
            AppMethodBeat.o(123804);
            return;
        }
        super.setVisibility(i);
        if (i == 0) {
            aRa();
            AppMethodBeat.o(123804);
            return;
        }
        aRb();
        AppMethodBeat.o(123804);
    }

    public void setCanSmileyInput(boolean z) {
        int i = 0;
        AppMethodBeat.i(123805);
        this.jfT = false;
        if (this.jfS != null) {
            ImageButton imageButton = this.jfS;
            if (!this.jfT) {
                i = 4;
            }
            imageButton.setVisibility(i);
        }
        aBJ();
        AppMethodBeat.o(123805);
    }

    public void setShowDoneButton(boolean z) {
        AppMethodBeat.i(123806);
        this.jfV = z;
        if (this.jfU != null) {
            this.jfU.setVisibility(this.jfV ? 0 : 4);
        }
        aBJ();
        AppMethodBeat.o(123806);
    }

    public EditText getAttachedEditText() {
        return this.jfW;
    }

    public final boolean b(EditText editText) {
        if (editText != this.jfW) {
            return false;
        }
        this.jfW = null;
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void aBK() {
        AppMethodBeat.i(123807);
        setCanSmileyInput(this.jfT);
        setShowDoneButton(this.jfV);
        aBJ();
        AppMethodBeat.o(123807);
    }

    public void show() {
        AppMethodBeat.i(123808);
        aRc();
        aBK();
        if (!isShown()) {
            qG(0);
        }
        AppMethodBeat.o(123808);
    }

    public final void hide() {
        AppMethodBeat.i(123809);
        if (isShown()) {
            qG(8);
            if (!this.jfX.aRp()) {
                aj.cS(this).hideSoftInputFromWindow(getWindowToken(), 0);
            }
            aRe();
            AppMethodBeat.o(123809);
            return;
        }
        AppMethodBeat.o(123809);
    }

    static /* synthetic */ void c(w wVar) {
        AppMethodBeat.i(123810);
        ab.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] forceMeasurePanel enter");
        wVar.jfQ.requestLayout();
        AppMethodBeat.o(123810);
    }
}
