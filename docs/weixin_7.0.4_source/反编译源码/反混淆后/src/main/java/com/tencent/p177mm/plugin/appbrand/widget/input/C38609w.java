package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0477s;
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
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38606u.C33633b;
import com.tencent.p177mm.plugin.appbrand.widget.input.p1238b.C19869a;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.C19904f;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.C27415e;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.C27415e.C11032a;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.C27415e.C27416b;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w */
public class C38609w extends LinearLayout implements C45719ac, C33633b {
    private static final int huq = 2131820561;
    private static final C27419b jfY = new C38608f();
    private Context context;
    private final Runnable jfK = new C386101();
    private C33635d jfL;
    private C33634c jfM;
    private boolean jfN = false;
    private C33636e jfO;
    private C27415e jfP;
    private View jfQ;
    private View jfR;
    private ImageButton jfS;
    private boolean jfT;
    private View jfU;
    private boolean jfV;
    protected EditText jfW;
    private final C2559ad jfX;
    private int state = 2;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$a */
    public interface C11043a {
        void setIsHide(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$4 */
    class C247114 implements C19904f {
        C247114() {
        }

        public final void append(String str) {
            AppMethodBeat.m2504i(123770);
            if (C38609w.this.jfL != null) {
                C38609w.this.jfL.mo35131EH(str);
            }
            AppMethodBeat.m2505o(123770);
        }

        public final void aRg() {
            AppMethodBeat.m2504i(123771);
            if (C38609w.this.jfL != null) {
                C38609w.this.jfL.mo35131EH("[DELETE_EMOTION]");
            }
            AppMethodBeat.m2505o(123771);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$b */
    interface C27419b {
        /* renamed from: c */
        void mo45152c(C38609w c38609w, int i);

        /* renamed from: m */
        void mo45153m(C38609w c38609w);

        /* renamed from: n */
        void mo45154n(C38609w c38609w);

        /* renamed from: o */
        void mo45155o(C38609w c38609w);

        /* renamed from: p */
        void mo45156p(C38609w c38609w);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$c */
    public interface C33634c {
        /* renamed from: fd */
        void mo22677fd(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$d */
    public interface C33635d {
        /* renamed from: EH */
        boolean mo35131EH(String str);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$e */
    public interface C33636e {
        /* renamed from: nS */
        void mo35132nS(int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$f */
    static final class C38608f implements C27419b {
        private C38608f() {
        }

        /* synthetic */ C38608f(byte b) {
            this();
        }

        /* renamed from: m */
        public final void mo45153m(C38609w c38609w) {
            AppMethodBeat.m2504i(123773);
            if (c38609w.isShown()) {
                c38609w.jfQ.setVisibility(0);
            }
            c38609w.jfP.aRE();
            AppMethodBeat.m2505o(123773);
        }

        /* renamed from: n */
        public final void mo45154n(C38609w c38609w) {
            AppMethodBeat.m2504i(123774);
            if (C42696n.m75622ct(c38609w)) {
                c38609w.mo61418qG(8);
                C38609w.m65446g(c38609w);
                AppMethodBeat.m2505o(123774);
                return;
            }
            if (c38609w.isShown()) {
                c38609w.jfQ.setVisibility(0);
            }
            if (c38609w.jfT) {
                c38609w.jfP.aRD();
                AppMethodBeat.m2505o(123774);
                return;
            }
            c38609w.jfP.aRE();
            AppMethodBeat.m2505o(123774);
        }

        /* renamed from: c */
        public final void mo45152c(C38609w c38609w, int i) {
            AppMethodBeat.m2504i(123775);
            if (C42696n.m75622ct(c38609w)) {
                c38609w.mo61418qG(8);
                AppMethodBeat.m2505o(123775);
            } else if (c38609w.jfQ == null || i <= 0) {
                AppMethodBeat.m2505o(123775);
            } else {
                C38609w.m65439b(c38609w, i);
                AppMethodBeat.m2505o(123775);
            }
        }

        /* renamed from: o */
        public final void mo45155o(C38609w c38609w) {
            AppMethodBeat.m2504i(123776);
            c38609w.jfX.showVKB();
            C38609w.m65449j(c38609w);
            AppMethodBeat.m2505o(123776);
        }

        /* renamed from: p */
        public final void mo45156p(C38609w c38609w) {
            AppMethodBeat.m2504i(123777);
            c38609w.jfX.aqX();
            C38609w.m65450k(c38609w);
            c38609w.mo6334oD(C40619x.m70073gs(c38609w.context));
            AppMethodBeat.m2505o(123777);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$1 */
    class C386101 implements Runnable {
        C386101() {
        }

        public final void run() {
            AppMethodBeat.m2504i(123767);
            if (C38609w.this.jfQ == null || !C0477s.m930av(C38609w.this.jfQ)) {
                AppMethodBeat.m2505o(123767);
            } else if (C38609w.this.jfP.aQZ()) {
                C4990ab.m7410d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
                C38609w.this.post(this);
                AppMethodBeat.m2505o(123767);
            } else {
                C38609w.m65440c(C38609w.this);
                AppMethodBeat.m2505o(123767);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$2 */
    class C386112 implements OnClickListener {
        C386112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(123768);
            if (view.isSelected()) {
                C38609w.jfY.mo45155o(C38609w.this);
                view.setSelected(false);
                AppMethodBeat.m2505o(123768);
                return;
            }
            C38609w.jfY.mo45156p(C38609w.this);
            view.setSelected(true);
            AppMethodBeat.m2505o(123768);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$3 */
    class C386123 implements OnClickListener {
        C386123() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(123769);
            C38609w.this.mo61409fd(true);
            AppMethodBeat.m2505o(123769);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$g */
    static final class C38613g extends FrameLayout implements C11043a {
        private boolean jgc = false;

        public C38613g(Context context) {
            super(context);
            AppMethodBeat.m2504i(123778);
            LayoutInflater.from(context).inflate(2130968774, this);
            AppMethodBeat.m2505o(123778);
        }

        public final void setIsHide(boolean z) {
            AppMethodBeat.m2504i(123779);
            Object obj = z != this.jgc ? 1 : null;
            this.jgc = z;
            if (obj != null && (VERSION.SDK_INT < 18 || !isInLayout())) {
                requestLayout();
            }
            AppMethodBeat.m2505o(123779);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onMeasure(int i, int i2) {
            AppMethodBeat.m2504i(123780);
            if (this.jgc || !isShown()) {
                i = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
                i2 = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
            }
            super.onMeasure(i, i2);
            AppMethodBeat.m2505o(123780);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m65439b(C38609w c38609w, int i) {
        AppMethodBeat.m2504i(123812);
        c38609w.setPanelHeightImpl(i);
        AppMethodBeat.m2505o(123812);
    }

    /* renamed from: g */
    static /* synthetic */ void m65446g(C38609w c38609w) {
        AppMethodBeat.m2504i(123811);
        c38609w.aRc();
        AppMethodBeat.m2505o(123811);
    }

    /* renamed from: j */
    static /* synthetic */ void m65449j(C38609w c38609w) {
        AppMethodBeat.m2504i(123813);
        c38609w.aRe();
        AppMethodBeat.m2505o(123813);
    }

    /* renamed from: k */
    static /* synthetic */ void m65450k(C38609w c38609w) {
        AppMethodBeat.m2504i(123814);
        c38609w.aRd();
        AppMethodBeat.m2505o(123814);
    }

    static {
        AppMethodBeat.m2504i(123815);
        AppMethodBeat.m2505o(123815);
    }

    /* renamed from: cN */
    public static C38609w m65441cN(View view) {
        AppMethodBeat.m2504i(123781);
        C38609w c38609w = (C38609w) view.getRootView().findViewById(huq);
        AppMethodBeat.m2505o(123781);
        return c38609w;
    }

    /* renamed from: cO */
    public static C38609w m65442cO(View view) {
        AppMethodBeat.m2504i(123782);
        C42740n cG = C42740n.m75740cG(view);
        if (cG.getOnLayoutListener() == null || !(cG.getOnLayoutListener() instanceof C38606u)) {
            cG.setOnLayoutListener(new C38606u());
        }
        C38609w cN = C38609w.m65441cN(view);
        if (cN == null) {
            Context cY = C5546d.m8371cY(view.getContext());
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
            C38609w c38609w = new C38609w(cY);
            cG.mo68193cH(c38609w);
            cN = c38609w;
        }
        AppMethodBeat.m2505o(123782);
        return cN;
    }

    public final boolean aQV() {
        AppMethodBeat.m2504i(123783);
        boolean aQV = this.jfP.aQV();
        AppMethodBeat.m2505o(123783);
        return aQV;
    }

    /* renamed from: oD */
    public final void mo6334oD(int i) {
        AppMethodBeat.m2504i(123784);
        C4990ab.m7411d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", Integer.valueOf(i));
        jfY.mo45152c(this, i);
        AppMethodBeat.m2505o(123784);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(123785);
        super.onLayout(z, i, i2, i3, i4);
        C4990ab.m7419v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", Integer.valueOf(getMeasuredHeight()));
        AppMethodBeat.m2505o(123785);
    }

    /* renamed from: et */
    public final void mo6332et(boolean z) {
        AppMethodBeat.m2504i(123786);
        C4990ab.m7411d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", Boolean.valueOf(z));
        if (z) {
            mo61418qG(0);
            aRe();
            AppMethodBeat.m2505o(123786);
            return;
        }
        if (isShown()) {
            if (this.jfT && 1 == this.state) {
                aRd();
                AppMethodBeat.m2505o(123786);
                return;
            }
            hide();
        }
        AppMethodBeat.m2505o(123786);
    }

    private void setPanelHeightImpl(int i) {
        AppMethodBeat.m2504i(123787);
        if (this.jfP.mo22694qD(i)) {
            this.jfK.run();
        }
        AppMethodBeat.m2505o(123787);
    }

    public int getMinimumHeight() {
        AppMethodBeat.m2504i(123788);
        if (getVisibility() == 0) {
            int fromDPToPix = C1338a.fromDPToPix(getContext(), 48);
            AppMethodBeat.m2505o(123788);
            return fromDPToPix;
        }
        AppMethodBeat.m2505o(123788);
        return 0;
    }

    public void setOnSmileyChosenListener(C33635d c33635d) {
        this.jfL = c33635d;
    }

    public void setOnDoneListener(C33634c c33634c) {
        this.jfM = c33634c;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: fd */
    public final void mo61409fd(boolean z) {
        AppMethodBeat.m2504i(123789);
        if (!(this.jfN || this.jfM == null)) {
            this.jfN = true;
            this.jfM.mo22677fd(z);
            this.jfN = false;
        }
        AppMethodBeat.m2505o(123789);
    }

    public void setOnVisibilityChangedListener(C33636e c33636e) {
        this.jfO = c33636e;
    }

    public C38609w(Context context) {
        C2559ad c2559ad;
        super(context);
        AppMethodBeat.m2504i(123790);
        this.context = context;
        if (context instanceof C2559ad) {
            c2559ad = (C2559ad) context;
        } else {
            c2559ad = new C19869a();
        }
        this.jfX = c2559ad;
        super.setId(huq);
        setOrientation(1);
        View aBL = aBL();
        this.jfR = aBL;
        addView(aBL);
        C27416b c27416b = (C27416b) C37384e.m62985B(C27416b.class);
        this.jfP = c27416b == null ? null : c27416b.mo34799cT(this.context);
        if (this.jfP == null) {
            this.jfP = new C11032a(this.context);
        }
        this.jfQ = this.jfP.getPanelView();
        this.jfQ.setVisibility(8);
        this.jfQ.setBackgroundColor(0);
        this.jfP.setOnTextOperationListener(new C247114());
        addView(this.jfQ);
        aBJ();
        AppMethodBeat.m2505o(123790);
    }

    public void setId(int i) {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: qE */
    public final void mo61417qE(int i) {
        AppMethodBeat.m2504i(139079);
        super.setId(i);
        AppMethodBeat.m2505o(139079);
    }

    /* Access modifiers changed, original: protected */
    public <T extends View & C11043a> T aBL() {
        AppMethodBeat.m2504i(123792);
        C38613g c38613g = new C38613g(getContext());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, C4996ah.getResources().getDrawable(C25738R.drawable.bix));
        stateListDrawable.addState(new int[0], C4996ah.getResources().getDrawable(C25738R.drawable.biw));
        this.jfS = (ImageButton) c38613g.findViewById(2131821510);
        this.jfS.setSelected(false);
        this.jfS.setImageDrawable(stateListDrawable);
        this.jfS.setOnClickListener(new C386112());
        this.jfU = c38613g.findViewById(2131821509);
        this.jfU.setOnClickListener(new C386123());
        AppMethodBeat.m2505o(123792);
        return c38613g;
    }

    private void aRa() {
        AppMethodBeat.m2504i(123793);
        ((C38606u) C42740n.m75740cG(this).getOnLayoutListener()).jft = this;
        AppMethodBeat.m2505o(123793);
    }

    private void aRb() {
        AppMethodBeat.m2504i(123794);
        ((C38606u) C42740n.m75740cG(this).getOnLayoutListener()).jft = null;
        AppMethodBeat.m2505o(123794);
    }

    /* renamed from: qF */
    private void m65452qF(final int i) {
        AppMethodBeat.m2504i(123795);
        final boolean z = this.jfN;
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(123772);
                int e = C38609w.this.state;
                if (C38609w.this.isShown()) {
                    C38609w.this.state = i;
                } else {
                    C38609w.this.state = 2;
                }
                if (C38609w.this.jfO == null) {
                    AppMethodBeat.m2505o(123772);
                    return;
                }
                if (!(e == C38609w.this.state || z)) {
                    C38609w.this.jfO.mo35132nS(C38609w.this.state);
                }
                AppMethodBeat.m2505o(123772);
            }
        });
        AppMethodBeat.m2505o(123795);
    }

    private void aRc() {
        AppMethodBeat.m2504i(123796);
        aRe();
        if (this.jfW != null) {
            InputMethodManager cS = C45720aj.m84475cS(this.jfW);
            if (!cS.showSoftInput(this.jfW, 1)) {
                cS.showSoftInput(this.jfW, 2);
            }
            AppMethodBeat.m2505o(123796);
            return;
        }
        this.jfX.showVKB();
        AppMethodBeat.m2505o(123796);
    }

    private void aRd() {
        AppMethodBeat.m2504i(123797);
        jfY.mo45154n(this);
        if (this.jfS != null) {
            this.jfS.setSelected(true);
        }
        m65452qF(1);
        AppMethodBeat.m2505o(123797);
    }

    private void aRe() {
        AppMethodBeat.m2504i(123798);
        jfY.mo45153m(this);
        if (this.jfS != null) {
            this.jfS.setSelected(false);
        }
        m65452qF(0);
        AppMethodBeat.m2505o(123798);
    }

    /* Access modifiers changed, original: protected */
    public void aBJ() {
        boolean z = false;
        AppMethodBeat.m2504i(123799);
        if (this.jfR == null) {
            AppMethodBeat.m2505o(123799);
            return;
        }
        int i;
        C11043a c11043a = (C11043a) this.jfR;
        if (this.jfT) {
            i = 0;
        } else {
            i = 1;
        }
        if ((i & (!this.jfV ? 1 : 0)) != 0 || C42696n.m75622ct(this)) {
            z = true;
        }
        c11043a.setIsHide(z);
        AppMethodBeat.m2505o(123799);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(123800);
        super.onMeasure(i, i2);
        C4990ab.m7410d("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
        AppMethodBeat.m2505o(123800);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(123801);
        super.onAttachedToWindow();
        aRa();
        AppMethodBeat.m2505o(123801);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(123802);
        super.onDetachedFromWindow();
        mo61418qG(8);
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
        AppMethodBeat.m2505o(123802);
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(123803);
        if (i == 8) {
            if (getVisibility() != i) {
                mo61409fd(false);
            }
            hide();
            AppMethodBeat.m2505o(123803);
        } else if (i == 0) {
            show();
            AppMethodBeat.m2505o(123803);
        } else {
            mo61418qG(i);
            AppMethodBeat.m2505o(123803);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qG */
    public final void mo61418qG(int i) {
        AppMethodBeat.m2504i(123804);
        if (i == 0 && C42696n.m75622ct(this)) {
            i = 8;
        }
        if (getVisibility() == i) {
            AppMethodBeat.m2505o(123804);
            return;
        }
        super.setVisibility(i);
        if (i == 0) {
            aRa();
            AppMethodBeat.m2505o(123804);
            return;
        }
        aRb();
        AppMethodBeat.m2505o(123804);
    }

    public void setCanSmileyInput(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(123805);
        this.jfT = false;
        if (this.jfS != null) {
            ImageButton imageButton = this.jfS;
            if (!this.jfT) {
                i = 4;
            }
            imageButton.setVisibility(i);
        }
        aBJ();
        AppMethodBeat.m2505o(123805);
    }

    public void setShowDoneButton(boolean z) {
        AppMethodBeat.m2504i(123806);
        this.jfV = z;
        if (this.jfU != null) {
            this.jfU.setVisibility(this.jfV ? 0 : 4);
        }
        aBJ();
        AppMethodBeat.m2505o(123806);
    }

    public EditText getAttachedEditText() {
        return this.jfW;
    }

    /* renamed from: b */
    public final boolean mo61408b(EditText editText) {
        if (editText != this.jfW) {
            return false;
        }
        this.jfW = null;
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void aBK() {
        AppMethodBeat.m2504i(123807);
        setCanSmileyInput(this.jfT);
        setShowDoneButton(this.jfV);
        aBJ();
        AppMethodBeat.m2505o(123807);
    }

    public void show() {
        AppMethodBeat.m2504i(123808);
        aRc();
        aBK();
        if (!isShown()) {
            mo61418qG(0);
        }
        AppMethodBeat.m2505o(123808);
    }

    public final void hide() {
        AppMethodBeat.m2504i(123809);
        if (isShown()) {
            mo61418qG(8);
            if (!this.jfX.aRp()) {
                C45720aj.m84475cS(this).hideSoftInputFromWindow(getWindowToken(), 0);
            }
            aRe();
            AppMethodBeat.m2505o(123809);
            return;
        }
        AppMethodBeat.m2505o(123809);
    }

    /* renamed from: c */
    static /* synthetic */ void m65440c(C38609w c38609w) {
        AppMethodBeat.m2504i(123810);
        C4990ab.m7418v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] forceMeasurePanel enter");
        c38609w.jfQ.requestLayout();
        AppMethodBeat.m2505o(123810);
    }
}
