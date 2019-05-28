package android.support.p069v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C0497w;
import android.support.p057v4.view.C0499x;
import android.support.p057v4.view.C0500z;
import android.support.p057v4.view.C6203y;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.view.C0602a;
import android.support.p069v7.view.C0604b;
import android.support.p069v7.view.C0604b.C0603a;
import android.support.p069v7.view.C0611g;
import android.support.p069v7.view.C0612h;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.support.p069v7.widget.ActionBarContainer;
import android.support.p069v7.widget.ActionBarContextView;
import android.support.p069v7.widget.ActionBarOverlayLayout;
import android.support.p069v7.widget.ActionBarOverlayLayout.C0639a;
import android.support.p069v7.widget.C0695au;
import android.support.p069v7.widget.C0728x;
import android.support.p069v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: android.support.v7.app.o */
public class C6226o extends ActionBar implements C0639a {
    static final /* synthetic */ boolean $assertionsDisabled = (!C6226o.class.desiredAssertionStatus());
    /* renamed from: WF */
    private static final Interpolator f1847WF = new AccelerateInterpolator();
    /* renamed from: WG */
    private static final Interpolator f1848WG = new DecelerateInterpolator();
    /* renamed from: WH */
    private Context f1849WH;
    /* renamed from: WI */
    ActionBarOverlayLayout f1850WI;
    /* renamed from: WJ */
    ActionBarContainer f1851WJ;
    /* renamed from: WK */
    ActionBarContextView f1852WK;
    /* renamed from: WL */
    View f1853WL;
    /* renamed from: WM */
    C0695au f1854WM;
    /* renamed from: WN */
    private int f1855WN = -1;
    /* renamed from: WO */
    private boolean f1856WO;
    /* renamed from: WP */
    C6225a f1857WP;
    /* renamed from: WQ */
    C0604b f1858WQ;
    /* renamed from: WR */
    C0603a f1859WR;
    /* renamed from: WS */
    private boolean f1860WS;
    /* renamed from: WT */
    private int f1861WT = 0;
    /* renamed from: WV */
    boolean f1862WV = true;
    /* renamed from: WW */
    boolean f1863WW;
    /* renamed from: WX */
    boolean f1864WX;
    /* renamed from: WY */
    private boolean f1865WY;
    /* renamed from: WZ */
    private boolean f1866WZ = true;
    /* renamed from: Wk */
    C0728x f1867Wk;
    /* renamed from: Wo */
    private boolean f1868Wo;
    /* renamed from: Wp */
    private ArrayList<Object> f1869Wp = new ArrayList();
    /* renamed from: Xa */
    C0612h f1870Xa;
    /* renamed from: Xb */
    private boolean f1871Xb;
    /* renamed from: Xc */
    boolean f1872Xc;
    /* renamed from: Xd */
    final C0499x f1873Xd = new C62271();
    /* renamed from: Xe */
    final C0499x f1874Xe = new C62282();
    /* renamed from: Xf */
    final C0500z f1875Xf = new C62243();
    private Activity mActivity;
    Context mContext;
    private Dialog mDialog;
    /* renamed from: rS */
    private ArrayList<Object> f1876rS = new ArrayList();

    /* renamed from: android.support.v7.app.o$3 */
    class C62243 implements C0500z {
        C62243() {
        }

        /* renamed from: es */
        public final void mo1167es() {
            ((View) C6226o.this.f1851WJ.getParent()).invalidate();
        }
    }

    /* renamed from: android.support.v7.app.o$a */
    public class C6225a extends C0604b implements C0623a {
        /* renamed from: Xh */
        private final Context f1843Xh;
        /* renamed from: Xi */
        private C0603a f1844Xi;
        /* renamed from: Xj */
        private WeakReference<View> f1845Xj;
        /* renamed from: lo */
        final C6236h f1846lo;

        public C6225a(Context context, C0603a c0603a) {
            this.f1843Xh = context;
            this.f1844Xi = c0603a;
            C6236h c6236h = new C6236h(context);
            this.f1846lo = c6236h;
            this.f1846lo.mo14113a((C0623a) this);
        }

        public final MenuInflater getMenuInflater() {
            return new C0611g(this.f1843Xh);
        }

        public final Menu getMenu() {
            return this.f1846lo;
        }

        public final void finish() {
            if (C6226o.this.f1857WP == this) {
                if (C6226o.m10022e(C6226o.this.f1863WW, C6226o.this.f1864WX, false)) {
                    this.f1844Xi.mo1484a(this);
                } else {
                    C6226o.this.f1858WQ = this;
                    C6226o.this.f1859WR = this.f1844Xi;
                }
                this.f1844Xi = null;
                C6226o.this.mo14054S(false);
                C6226o.this.f1852WK.mo14230gR();
                C6226o.this.f1867Wk.mo2159hW().sendAccessibilityEvent(32);
                C6226o.this.f1850WI.setHideOnContentScrollEnabled(C6226o.this.f1872Xc);
                C6226o.this.f1857WP = null;
            }
        }

        public final void invalidate() {
            if (C6226o.this.f1857WP == this) {
                this.f1846lo.mo14146gx();
                try {
                    this.f1844Xi.mo1487b(this, this.f1846lo);
                } finally {
                    this.f1846lo.mo14147gy();
                }
            }
        }

        /* renamed from: fK */
        public final boolean mo14053fK() {
            this.f1846lo.mo14146gx();
            try {
                boolean a = this.f1844Xi.mo1485a((C0604b) this, this.f1846lo);
                return a;
            } finally {
                this.f1846lo.mo14147gy();
            }
        }

        public final void setCustomView(View view) {
            C6226o.this.f1852WK.setCustomView(view);
            this.f1845Xj = new WeakReference(view);
        }

        public final void setSubtitle(CharSequence charSequence) {
            C6226o.this.f1852WK.setSubtitle(charSequence);
        }

        public final void setTitle(CharSequence charSequence) {
            C6226o.this.f1852WK.setTitle(charSequence);
        }

        public final void setTitle(int i) {
            setTitle(C6226o.this.mContext.getResources().getString(i));
        }

        public final void setSubtitle(int i) {
            setSubtitle(C6226o.this.mContext.getResources().getString(i));
        }

        public final CharSequence getTitle() {
            return C6226o.this.f1852WK.getTitle();
        }

        public final CharSequence getSubtitle() {
            return C6226o.this.f1852WK.getSubtitle();
        }

        public final void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            C6226o.this.f1852WK.setTitleOptional(z);
        }

        public final boolean isTitleOptional() {
            return C6226o.this.f1852WK.acR;
        }

        public final View getCustomView() {
            return this.f1845Xj != null ? (View) this.f1845Xj.get() : null;
        }

        /* renamed from: a */
        public final boolean mo1584a(C6236h c6236h, MenuItem menuItem) {
            if (this.f1844Xi != null) {
                return this.f1844Xi.mo1486a((C0604b) this, menuItem);
            }
            return false;
        }

        /* renamed from: b */
        public final void mo1585b(C6236h c6236h) {
            if (this.f1844Xi != null) {
                invalidate();
                C6226o.this.f1852WK.showOverflowMenu();
            }
        }
    }

    /* renamed from: android.support.v7.app.o$1 */
    class C62271 extends C6203y {
        C62271() {
        }

        /* renamed from: aA */
        public final void mo1164aA(View view) {
            if (C6226o.this.f1862WV && C6226o.this.f1853WL != null) {
                C6226o.this.f1853WL.setTranslationY(0.0f);
                C6226o.this.f1851WJ.setTranslationY(0.0f);
            }
            C6226o.this.f1851WJ.setVisibility(8);
            C6226o.this.f1851WJ.setTransitioning(false);
            C6226o.this.f1870Xa = null;
            C6226o c6226o = C6226o.this;
            if (c6226o.f1859WR != null) {
                c6226o.f1859WR.mo1484a(c6226o.f1858WQ);
                c6226o.f1858WQ = null;
                c6226o.f1859WR = null;
            }
            if (C6226o.this.f1850WI != null) {
                C0477s.m919ak(C6226o.this.f1850WI);
            }
        }
    }

    /* renamed from: android.support.v7.app.o$2 */
    class C62282 extends C6203y {
        C62282() {
        }

        /* renamed from: aA */
        public final void mo1164aA(View view) {
            C6226o.this.f1870Xa = null;
            C6226o.this.f1851WJ.requestLayout();
        }
    }

    public C6226o(Activity activity, boolean z) {
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        m10020aR(decorView);
        if (!z) {
            this.f1853WL = decorView.findViewById(16908290);
        }
    }

    public C6226o(Dialog dialog) {
        this.mDialog = dialog;
        m10020aR(dialog.getWindow().getDecorView());
    }

    /* renamed from: aR */
    private void m10020aR(View view) {
        this.f1850WI = (ActionBarOverlayLayout) view.findViewById(2131820939);
        if (this.f1850WI != null) {
            this.f1850WI.setActionBarVisibilityCallback(this);
        }
        this.f1867Wk = C6226o.m10021aS(view.findViewById(2131820941));
        this.f1852WK = (ActionBarContextView) view.findViewById(2131820942);
        this.f1851WJ = (ActionBarContainer) view.findViewById(2131820940);
        if (this.f1867Wk == null || this.f1852WK == null || this.f1851WJ == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = this.f1867Wk.getContext();
        if ((this.f1867Wk.getDisplayOptions() & 4) != 0) {
            this.f1856WO = true;
        }
        C0602a X = C0602a.m1303X(this.mContext);
        X.mo1483ga();
        m10016N(X.mo1482fZ());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, C0554a.ActionBar, C25738R.attr.f5614dt, 0);
        if (obtainStyledAttributes.getBoolean(19, false)) {
            mo1341fe();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(26, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: aS */
    private static C0728x m10021aS(View view) {
        if (view instanceof C0728x) {
            return (C0728x) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of ".concat(String.valueOf(view)) != null ? view.getClass().getSimpleName() : BuildConfig.COMMAND);
    }

    public final void setElevation(float f) {
        C0477s.m945h(this.f1851WJ, f);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        m10016N(C0602a.m1303X(this.mContext).mo1482fZ());
    }

    /* renamed from: N */
    private void m10016N(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.f1860WS = z;
        if (this.f1860WS) {
            this.f1851WJ.setTabContainer(null);
            this.f1867Wk.mo2143a(this.f1854WM);
        } else {
            this.f1867Wk.mo2143a(null);
            this.f1851WJ.setTabContainer(this.f1854WM);
        }
        if (getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f1854WM != null) {
            if (z2) {
                this.f1854WM.setVisibility(0);
                if (this.f1850WI != null) {
                    C0477s.m919ak(this.f1850WI);
                }
            } else {
                this.f1854WM.setVisibility(8);
            }
        }
        C0728x c0728x = this.f1867Wk;
        if (this.f1860WS || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        c0728x.setCollapsible(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1850WI;
        if (this.f1860WS || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    public final void onWindowVisibilityChanged(int i) {
        this.f1861WT = i;
    }

    /* renamed from: L */
    public final void mo1332L(boolean z) {
        this.f1871Xb = z;
        if (!z && this.f1870Xa != null) {
            this.f1870Xa.cancel();
        }
    }

    /* renamed from: M */
    public final void mo1333M(boolean z) {
        if (z != this.f1868Wo) {
            this.f1868Wo = z;
            int size = this.f1869Wp.size();
            for (int i = 0; i < size; i++) {
                this.f1869Wp.get(i);
            }
        }
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.f1867Wk.mo2159hW(), false));
    }

    /* renamed from: fb */
    public final void mo1338fb() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    /* renamed from: fc */
    public final void mo1339fc() {
        setDisplayOptions(0, 8);
    }

    /* renamed from: fd */
    public final void mo1340fd() {
        setDisplayOptions(16, 16);
    }

    public final void setWindowTitle(CharSequence charSequence) {
        this.f1867Wk.setWindowTitle(charSequence);
    }

    public final void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.f1856WO = true;
        }
        this.f1867Wk.setDisplayOptions(i);
    }

    private void setDisplayOptions(int i, int i2) {
        int displayOptions = this.f1867Wk.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.f1856WO = true;
        }
        this.f1867Wk.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.f1851WJ.setPrimaryBackground(drawable);
    }

    public final View getCustomView() {
        return this.f1867Wk.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.f1867Wk.getTitle();
    }

    private int getNavigationMode() {
        return this.f1867Wk.getNavigationMode();
    }

    public final int getDisplayOptions() {
        return this.f1867Wk.getDisplayOptions();
    }

    /* renamed from: a */
    public final C0604b mo1334a(C0603a c0603a) {
        if (this.f1857WP != null) {
            this.f1857WP.finish();
        }
        this.f1850WI.setHideOnContentScrollEnabled(false);
        this.f1852WK.mo14231gS();
        C6225a c6225a = new C6225a(this.f1852WK.getContext(), c0603a);
        if (!c6225a.mo14053fK()) {
            return null;
        }
        this.f1857WP = c6225a;
        c6225a.invalidate();
        this.f1852WK.mo14229c(c6225a);
        mo14054S(true);
        this.f1852WK.sendAccessibilityEvent(32);
        return c6225a;
    }

    public final int getHeight() {
        return this.f1851WJ.getHeight();
    }

    /* renamed from: O */
    public final void mo1643O(boolean z) {
        this.f1862WV = z;
    }

    public final void show() {
        if (this.f1863WW) {
            this.f1863WW = false;
            m10017P(false);
        }
    }

    /* renamed from: fF */
    private void m10023fF() {
        if (!this.f1865WY) {
            this.f1865WY = true;
            if (this.f1850WI != null) {
                this.f1850WI.setShowingForActionMode(true);
            }
            m10017P(false);
        }
    }

    /* renamed from: fG */
    public final void mo1644fG() {
        if (this.f1864WX) {
            this.f1864WX = false;
            m10017P(true);
        }
    }

    public final void hide() {
        if (!this.f1863WW) {
            this.f1863WW = true;
            m10017P(false);
        }
    }

    /* renamed from: fH */
    private void m10024fH() {
        if (this.f1865WY) {
            this.f1865WY = false;
            if (this.f1850WI != null) {
                this.f1850WI.setShowingForActionMode(false);
            }
            m10017P(false);
        }
    }

    /* renamed from: fI */
    public final void mo1645fI() {
        if (!this.f1864WX) {
            this.f1864WX = true;
            m10017P(true);
        }
    }

    /* renamed from: fe */
    public final void mo1341fe() {
        if (this.f1850WI.adb) {
            this.f1872Xc = true;
            this.f1850WI.setHideOnContentScrollEnabled(true);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    /* renamed from: e */
    static boolean m10022e(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    /* renamed from: P */
    private void m10017P(boolean z) {
        if (C6226o.m10022e(this.f1863WW, this.f1864WX, this.f1865WY)) {
            if (!this.f1866WZ) {
                this.f1866WZ = true;
                m10018Q(z);
            }
        } else if (this.f1866WZ) {
            this.f1866WZ = false;
            m10019R(z);
        }
    }

    /* renamed from: Q */
    private void m10018Q(boolean z) {
        if (this.f1870Xa != null) {
            this.f1870Xa.cancel();
        }
        this.f1851WJ.setVisibility(0);
        if (this.f1861WT == 0 && (this.f1871Xb || z)) {
            this.f1851WJ.setTranslationY(0.0f);
            float f = (float) (-this.f1851WJ.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1851WJ.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.f1851WJ.setTranslationY(f);
            C0612h c0612h = new C0612h();
            C0497w u = C0477s.m910ab(this.f1851WJ).mo1162u(0.0f);
            u.mo1154a(this.f1875Xf);
            c0612h.mo1535a(u);
            if (this.f1862WV && this.f1853WL != null) {
                this.f1853WL.setTranslationY(f);
                c0612h.mo1535a(C0477s.m910ab(this.f1853WL).mo1162u(0.0f));
            }
            c0612h.mo1539d(f1848WG);
            c0612h.mo1540gg();
            c0612h.mo1537b(this.f1874Xe);
            this.f1870Xa = c0612h;
            c0612h.start();
        } else {
            this.f1851WJ.setAlpha(1.0f);
            this.f1851WJ.setTranslationY(0.0f);
            if (this.f1862WV && this.f1853WL != null) {
                this.f1853WL.setTranslationY(0.0f);
            }
            this.f1874Xe.mo1164aA(null);
        }
        if (this.f1850WI != null) {
            C0477s.m919ak(this.f1850WI);
        }
    }

    /* renamed from: R */
    private void m10019R(boolean z) {
        if (this.f1870Xa != null) {
            this.f1870Xa.cancel();
        }
        if (this.f1861WT == 0 && (this.f1871Xb || z)) {
            this.f1851WJ.setAlpha(1.0f);
            this.f1851WJ.setTransitioning(true);
            C0612h c0612h = new C0612h();
            float f = (float) (-this.f1851WJ.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1851WJ.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            C0497w u = C0477s.m910ab(this.f1851WJ).mo1162u(f);
            u.mo1154a(this.f1875Xf);
            c0612h.mo1535a(u);
            if (this.f1862WV && this.f1853WL != null) {
                c0612h.mo1535a(C0477s.m910ab(this.f1853WL).mo1162u(f));
            }
            c0612h.mo1539d(f1847WF);
            c0612h.mo1540gg();
            c0612h.mo1537b(this.f1873Xd);
            this.f1870Xa = c0612h;
            c0612h.start();
            return;
        }
        this.f1873Xd.mo1164aA(null);
    }

    /* renamed from: S */
    public final void mo14054S(boolean z) {
        if (z) {
            m10023fF();
        } else {
            m10024fH();
        }
        if (C0477s.m927as(this.f1851WJ)) {
            C0497w c;
            C0497w c2;
            if (z) {
                c = this.f1867Wk.mo2145c(4, 100);
                c2 = this.f1852WK.mo1920c(0, 200);
            } else {
                c2 = this.f1867Wk.mo2145c(0, 200);
                c = this.f1852WK.mo1920c(8, 100);
            }
            C0612h c0612h = new C0612h();
            c0612h.mo1536a(c, c2);
            c0612h.start();
        } else if (z) {
            this.f1867Wk.setVisibility(4);
            this.f1852WK.setVisibility(0);
        } else {
            this.f1867Wk.setVisibility(0);
            this.f1852WK.setVisibility(8);
        }
    }

    public final Context getThemedContext() {
        if (this.f1849WH == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C25738R.attr.f5617dw, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1849WH = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.f1849WH = this.mContext;
            }
        }
        return this.f1849WH;
    }

    public final void setHomeActionContentDescription(int i) {
        this.f1867Wk.setNavigationContentDescription(i);
    }

    /* renamed from: fJ */
    public final void mo1646fJ() {
        if (this.f1870Xa != null) {
            this.f1870Xa.cancel();
            this.f1870Xa = null;
        }
    }

    public final boolean collapseActionView() {
        if (this.f1867Wk == null || !this.f1867Wk.hasExpandedActionView()) {
            return false;
        }
        this.f1867Wk.collapseActionView();
        return true;
    }

    public final void setCustomView(View view) {
        this.f1867Wk.setCustomView(view);
    }

    /* renamed from: fa */
    public final void mo1337fa() {
        this.f1867Wk.setIcon((int) C25738R.drawable.a8g);
    }

    public final void setLogo(Drawable drawable) {
        this.f1867Wk.setLogo(drawable);
    }

    /* renamed from: K */
    public final void mo1331K(boolean z) {
        if (!this.f1856WO) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        if (this.f1857WP == null) {
            return false;
        }
        C6236h c6236h = this.f1857WP.f1846lo;
        if (c6236h == null) {
            return false;
        }
        boolean z;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
            z = true;
        } else {
            z = false;
        }
        c6236h.setQwertyMode(z);
        return c6236h.performShortcut(i, keyEvent, 0);
    }

    public final boolean isShowing() {
        int height = this.f1851WJ.getHeight();
        return this.f1866WZ && (height == 0 || this.f1850WI.getActionBarHideOffset() < height);
    }
}
