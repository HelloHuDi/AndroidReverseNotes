package com.tencent.p177mm.p612ui.p614b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C0497w;
import android.support.p057v4.view.C0499x;
import android.support.p057v4.view.C0500z;
import android.support.p057v4.view.C6203y;
import android.support.p069v7.app.ActionBar;
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
import android.support.p069v7.widget.ActionBarOverlayLayout.C0639a;
import android.support.p069v7.widget.C0728x;
import android.support.p069v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1441a;
import com.tencent.p177mm.loader.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.b.d */
public final class C7321d extends ActionBar implements C0639a {
    /* renamed from: WF */
    private static final Interpolator f1978WF = new AccelerateInterpolator();
    /* renamed from: WG */
    private static final Interpolator f1979WG = new DecelerateInterpolator();
    private static final boolean yrg = (VERSION.SDK_INT >= 14);
    /* renamed from: WH */
    private Context f1980WH;
    /* renamed from: WJ */
    private ActionBarContainer f1981WJ;
    /* renamed from: WK */
    private ActionBarContextView f1982WK;
    /* renamed from: WL */
    private View f1983WL;
    /* renamed from: WO */
    private boolean f1984WO;
    /* renamed from: WQ */
    C0604b f1985WQ;
    /* renamed from: WR */
    C0603a f1986WR;
    /* renamed from: WT */
    private int f1987WT = 0;
    /* renamed from: WV */
    private boolean f1988WV = true;
    /* renamed from: WW */
    private boolean f1989WW;
    /* renamed from: WX */
    private boolean f1990WX;
    /* renamed from: WY */
    private boolean f1991WY;
    /* renamed from: WZ */
    private boolean f1992WZ = true;
    /* renamed from: Wk */
    C0728x f1993Wk;
    /* renamed from: Wo */
    private boolean f1994Wo;
    /* renamed from: Wp */
    private ArrayList<Object> f1995Wp = new ArrayList();
    /* renamed from: Xa */
    private C0612h f1996Xa;
    /* renamed from: Xb */
    private boolean f1997Xb;
    /* renamed from: Xd */
    final C0499x f1998Xd = new C73221();
    /* renamed from: Xe */
    final C0499x f1999Xe = new C73232();
    /* renamed from: Xf */
    final C0500z f2000Xf = new C73193();
    private Activity mActivity;
    private Context mContext;
    C7320a yrh;

    /* renamed from: com.tencent.mm.ui.b.d$3 */
    class C73193 implements C0500z {
        C73193() {
        }

        /* renamed from: es */
        public final void mo1167es() {
            AppMethodBeat.m2504i(106160);
            ((View) C7321d.this.f1981WJ.getParent()).invalidate();
            AppMethodBeat.m2505o(106160);
        }
    }

    /* renamed from: com.tencent.mm.ui.b.d$a */
    public class C7320a extends C0604b implements C0623a {
        /* renamed from: Xh */
        private final Context f1974Xh;
        /* renamed from: Xi */
        private C0603a f1975Xi;
        /* renamed from: Xj */
        private WeakReference<View> f1976Xj;
        /* renamed from: lo */
        private final C6236h f1977lo;

        public C7320a(Context context, C0603a c0603a) {
            AppMethodBeat.m2504i(106161);
            this.f1974Xh = context;
            this.f1975Xi = c0603a;
            C6236h c6236h = new C6236h(context);
            this.f1977lo = c6236h;
            this.f1977lo.mo14113a((C0623a) this);
            AppMethodBeat.m2505o(106161);
        }

        public final MenuInflater getMenuInflater() {
            AppMethodBeat.m2504i(106162);
            C0611g c0611g = new C0611g(this.f1974Xh);
            AppMethodBeat.m2505o(106162);
            return c0611g;
        }

        public final Menu getMenu() {
            return this.f1977lo;
        }

        public final void finish() {
            AppMethodBeat.m2504i(106163);
            if (C7321d.this.yrh != this) {
                AppMethodBeat.m2505o(106163);
                return;
            }
            if (C7321d.m12416ah(C7321d.this.f1989WW, C7321d.this.f1990WX)) {
                this.f1975Xi.mo1484a(this);
            } else {
                C7321d.this.f1985WQ = this;
                C7321d.this.f1986WR = this.f1975Xi;
            }
            this.f1975Xi = null;
            C7321d.this.mo15830S(false);
            C7321d.this.f1982WK.mo14230gR();
            C7321d.this.f1993Wk.mo2159hW().sendAccessibilityEvent(32);
            C7321d.this.yrh = null;
            AppMethodBeat.m2505o(106163);
        }

        public final void invalidate() {
            AppMethodBeat.m2504i(106164);
            if (C7321d.this.yrh != this) {
                AppMethodBeat.m2505o(106164);
                return;
            }
            this.f1977lo.mo14146gx();
            try {
                this.f1975Xi.mo1487b(this, this.f1977lo);
            } finally {
                this.f1977lo.mo14147gy();
                AppMethodBeat.m2505o(106164);
            }
        }

        /* renamed from: fK */
        public final boolean mo15829fK() {
            AppMethodBeat.m2504i(106165);
            this.f1977lo.mo14146gx();
            try {
                boolean a = this.f1975Xi.mo1485a((C0604b) this, this.f1977lo);
                return a;
            } finally {
                this.f1977lo.mo14147gy();
                AppMethodBeat.m2505o(106165);
            }
        }

        public final void setCustomView(View view) {
            AppMethodBeat.m2504i(106166);
            C7321d.this.f1982WK.setCustomView(view);
            this.f1976Xj = new WeakReference(view);
            AppMethodBeat.m2505o(106166);
        }

        public final void setSubtitle(CharSequence charSequence) {
            AppMethodBeat.m2504i(106167);
            C7321d.this.f1982WK.setSubtitle(charSequence);
            AppMethodBeat.m2505o(106167);
        }

        public final void setTitle(CharSequence charSequence) {
            AppMethodBeat.m2504i(106168);
            C7321d.this.f1982WK.setTitle(charSequence);
            AppMethodBeat.m2505o(106168);
        }

        public final void setTitle(int i) {
            AppMethodBeat.m2504i(106169);
            setTitle(C7321d.this.mContext.getResources().getString(i));
            AppMethodBeat.m2505o(106169);
        }

        public final void setSubtitle(int i) {
            AppMethodBeat.m2504i(106170);
            setSubtitle(C7321d.this.mContext.getResources().getString(i));
            AppMethodBeat.m2505o(106170);
        }

        public final CharSequence getTitle() {
            AppMethodBeat.m2504i(106171);
            CharSequence title = C7321d.this.f1982WK.getTitle();
            AppMethodBeat.m2505o(106171);
            return title;
        }

        public final CharSequence getSubtitle() {
            AppMethodBeat.m2504i(106172);
            CharSequence subtitle = C7321d.this.f1982WK.getSubtitle();
            AppMethodBeat.m2505o(106172);
            return subtitle;
        }

        public final void setTitleOptionalHint(boolean z) {
            AppMethodBeat.m2504i(106173);
            super.setTitleOptionalHint(z);
            C7321d.this.f1982WK.setTitleOptional(z);
            AppMethodBeat.m2505o(106173);
        }

        public final boolean isTitleOptional() {
            AppMethodBeat.m2504i(106174);
            boolean z = C7321d.this.f1982WK.acR;
            AppMethodBeat.m2505o(106174);
            return z;
        }

        public final View getCustomView() {
            AppMethodBeat.m2504i(106175);
            if (this.f1976Xj != null) {
                View view = (View) this.f1976Xj.get();
                AppMethodBeat.m2505o(106175);
                return view;
            }
            AppMethodBeat.m2505o(106175);
            return null;
        }

        /* renamed from: a */
        public final boolean mo1584a(C6236h c6236h, MenuItem menuItem) {
            AppMethodBeat.m2504i(106176);
            if (this.f1975Xi != null) {
                boolean a = this.f1975Xi.mo1486a((C0604b) this, menuItem);
                AppMethodBeat.m2505o(106176);
                return a;
            }
            AppMethodBeat.m2505o(106176);
            return false;
        }

        /* renamed from: b */
        public final void mo1585b(C6236h c6236h) {
            AppMethodBeat.m2504i(106177);
            if (this.f1975Xi == null) {
                AppMethodBeat.m2505o(106177);
                return;
            }
            invalidate();
            C7321d.this.f1982WK.showOverflowMenu();
            AppMethodBeat.m2505o(106177);
        }
    }

    /* renamed from: com.tencent.mm.ui.b.d$1 */
    class C73221 extends C6203y {
        C73221() {
        }

        /* renamed from: aA */
        public final void mo1164aA(View view) {
            AppMethodBeat.m2504i(106158);
            if (C7321d.this.f1988WV && C7321d.this.f1983WL != null) {
                C0477s.m938d(C7321d.this.f1983WL, 0.0f);
                C0477s.m938d(C7321d.this.f1981WJ, 0.0f);
            }
            C7321d.this.f1981WJ.setVisibility(8);
            C7321d.this.f1981WJ.setTransitioning(false);
            C7321d.this.f1996Xa = null;
            C7321d c7321d = C7321d.this;
            if (c7321d.f1986WR != null) {
                c7321d.f1986WR.mo1484a(c7321d.f1985WQ);
                c7321d.f1985WQ = null;
                c7321d.f1986WR = null;
            }
            AppMethodBeat.m2505o(106158);
        }
    }

    /* renamed from: com.tencent.mm.ui.b.d$2 */
    class C73232 extends C6203y {
        C73232() {
        }

        /* renamed from: aA */
        public final void mo1164aA(View view) {
            AppMethodBeat.m2504i(106159);
            C7321d.this.f1996Xa = null;
            C7321d.this.f1981WJ.requestLayout();
            AppMethodBeat.m2505o(106159);
        }
    }

    /* renamed from: ah */
    static /* synthetic */ boolean m12416ah(boolean z, boolean z2) {
        AppMethodBeat.m2504i(106216);
        boolean e = C7321d.m12421e(z, z2, false);
        AppMethodBeat.m2505o(106216);
        return e;
    }

    static {
        AppMethodBeat.m2504i(106217);
        AppMethodBeat.m2505o(106217);
    }

    public C7321d(Activity activity, ViewGroup viewGroup) {
        C0728x c0728x;
        AppMethodBeat.m2504i(106178);
        this.mActivity = activity;
        View findViewById = viewGroup.findViewById(2131820941);
        if (findViewById instanceof C0728x) {
            c0728x = (C0728x) findViewById;
        } else if (findViewById instanceof Toolbar) {
            c0728x = ((Toolbar) findViewById).getWrapper();
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Can't make a decor toolbar out of ".concat(String.valueOf(findViewById)) != null ? findViewById.getClass().getSimpleName() : BuildConfig.COMMAND);
            AppMethodBeat.m2505o(106178);
            throw illegalStateException;
        }
        this.f1993Wk = c0728x;
        this.f1982WK = (ActionBarContextView) viewGroup.findViewById(2131820942);
        this.f1981WJ = (ActionBarContainer) viewGroup.findViewById(2131820940);
        if (this.f1993Wk == null || this.f1982WK == null || this.f1981WJ == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
            AppMethodBeat.m2505o(106178);
            throw illegalStateException2;
        }
        this.mContext = this.f1993Wk.getContext();
        if ((this.f1993Wk.getDisplayOptions() & 4) != 0) {
            this.f1984WO = true;
        }
        C0602a.m1303X(this.mContext).mo1483ga();
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, C0554a.ActionBar, C25738R.attr.f5614dt, 0);
        obtainStyledAttributes.getBoolean(19, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(26, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
        this.f1983WL = null;
        AppMethodBeat.m2505o(106178);
    }

    public final void setElevation(float f) {
        AppMethodBeat.m2504i(106179);
        C0477s.m945h(this.f1981WJ, f);
        AppMethodBeat.m2505o(106179);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(106180);
        LayoutParams layoutParams = this.f1993Wk.mo2159hW().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = C1441a.m3065bG(this.mActivity);
        }
        this.f1993Wk.mo2159hW().setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(106180);
    }

    public final void onWindowVisibilityChanged(int i) {
        this.f1987WT = i;
    }

    /* renamed from: L */
    public final void mo1332L(boolean z) {
        AppMethodBeat.m2504i(106181);
        this.f1997Xb = z;
        if (!(z || this.f1996Xa == null)) {
            this.f1996Xa.cancel();
        }
        AppMethodBeat.m2505o(106181);
    }

    /* renamed from: M */
    public final void mo1333M(boolean z) {
        AppMethodBeat.m2504i(106182);
        if (z == this.f1994Wo) {
            AppMethodBeat.m2505o(106182);
            return;
        }
        this.f1994Wo = z;
        int size = this.f1995Wp.size();
        for (int i = 0; i < size; i++) {
            this.f1995Wp.get(i);
        }
        AppMethodBeat.m2505o(106182);
    }

    public final void setCustomView(int i) {
        AppMethodBeat.m2504i(106183);
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.f1993Wk.mo2159hW(), false));
        AppMethodBeat.m2505o(106183);
    }

    /* renamed from: fb */
    public final void mo1338fb() {
        AppMethodBeat.m2504i(106184);
        setDisplayOptions(0, 2);
        AppMethodBeat.m2505o(106184);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        AppMethodBeat.m2504i(106185);
        setDisplayOptions(z ? 4 : 0, 4);
        AppMethodBeat.m2505o(106185);
    }

    /* renamed from: fc */
    public final void mo1339fc() {
        AppMethodBeat.m2504i(106186);
        setDisplayOptions(0, 8);
        AppMethodBeat.m2505o(106186);
    }

    /* renamed from: fd */
    public final void mo1340fd() {
        AppMethodBeat.m2504i(106187);
        setDisplayOptions(16, 16);
        AppMethodBeat.m2505o(106187);
    }

    public final void setWindowTitle(CharSequence charSequence) {
        AppMethodBeat.m2504i(106188);
        this.f1993Wk.setWindowTitle(charSequence);
        AppMethodBeat.m2505o(106188);
    }

    public final void setDisplayOptions(int i) {
        AppMethodBeat.m2504i(106189);
        if ((i & 4) != 0) {
            this.f1984WO = true;
        }
        this.f1993Wk.setDisplayOptions(i);
        AppMethodBeat.m2505o(106189);
    }

    private void setDisplayOptions(int i, int i2) {
        AppMethodBeat.m2504i(106190);
        int displayOptions = this.f1993Wk.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.f1984WO = true;
        }
        this.f1993Wk.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
        AppMethodBeat.m2505o(106190);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(106191);
        this.f1981WJ.setPrimaryBackground(drawable);
        AppMethodBeat.m2505o(106191);
    }

    public final View getCustomView() {
        AppMethodBeat.m2504i(106192);
        View customView = this.f1993Wk.getCustomView();
        AppMethodBeat.m2505o(106192);
        return customView;
    }

    public final CharSequence getTitle() {
        AppMethodBeat.m2504i(106193);
        CharSequence title = this.f1993Wk.getTitle();
        AppMethodBeat.m2505o(106193);
        return title;
    }

    public final int getDisplayOptions() {
        AppMethodBeat.m2504i(106194);
        int displayOptions = this.f1993Wk.getDisplayOptions();
        AppMethodBeat.m2505o(106194);
        return displayOptions;
    }

    /* renamed from: a */
    public final C0604b mo1334a(C0603a c0603a) {
        AppMethodBeat.m2504i(106195);
        if (this.yrh != null) {
            this.yrh.finish();
        }
        this.f1982WK.mo14231gS();
        C7320a c7320a = new C7320a(this.f1982WK.getContext(), c0603a);
        if (c7320a.mo15829fK()) {
            c7320a.invalidate();
            this.f1982WK.mo14229c(c7320a);
            mo15830S(true);
            this.f1982WK.sendAccessibilityEvent(32);
            this.yrh = c7320a;
            AppMethodBeat.m2505o(106195);
            return c7320a;
        }
        AppMethodBeat.m2505o(106195);
        return null;
    }

    public final int getHeight() {
        AppMethodBeat.m2504i(106196);
        int height = this.f1981WJ.getHeight();
        AppMethodBeat.m2505o(106196);
        return height;
    }

    /* renamed from: O */
    public final void mo1643O(boolean z) {
        this.f1988WV = z;
    }

    public final void show() {
        AppMethodBeat.m2504i(106197);
        if (this.f1989WW) {
            this.f1989WW = false;
            m12412P(false);
        }
        AppMethodBeat.m2505o(106197);
    }

    /* renamed from: fF */
    private void m12423fF() {
        AppMethodBeat.m2504i(106198);
        if (!this.f1991WY) {
            this.f1991WY = true;
            m12412P(false);
        }
        AppMethodBeat.m2505o(106198);
    }

    /* renamed from: fG */
    public final void mo1644fG() {
        AppMethodBeat.m2504i(106199);
        if (this.f1990WX) {
            this.f1990WX = false;
            m12412P(true);
        }
        AppMethodBeat.m2505o(106199);
    }

    public final void hide() {
        AppMethodBeat.m2504i(106200);
        if (!this.f1989WW) {
            this.f1989WW = true;
            m12412P(false);
        }
        AppMethodBeat.m2505o(106200);
    }

    /* renamed from: fH */
    private void m12424fH() {
        AppMethodBeat.m2504i(106201);
        if (this.f1991WY) {
            this.f1991WY = false;
            m12412P(false);
        }
        AppMethodBeat.m2505o(106201);
    }

    /* renamed from: fI */
    public final void mo1645fI() {
        AppMethodBeat.m2504i(106202);
        if (!this.f1990WX) {
            this.f1990WX = true;
            m12412P(true);
        }
        AppMethodBeat.m2505o(106202);
    }

    /* renamed from: fe */
    public final void mo1341fe() {
    }

    /* renamed from: e */
    private static boolean m12421e(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    /* renamed from: P */
    private void m12412P(boolean z) {
        AppMethodBeat.m2504i(106203);
        if (C7321d.m12421e(this.f1989WW, this.f1990WX, this.f1991WY)) {
            if (!this.f1992WZ) {
                this.f1992WZ = true;
                m12413Q(z);
                AppMethodBeat.m2505o(106203);
                return;
            }
        } else if (this.f1992WZ) {
            this.f1992WZ = false;
            m12414R(z);
        }
        AppMethodBeat.m2505o(106203);
    }

    /* renamed from: Q */
    private void m12413Q(boolean z) {
        AppMethodBeat.m2504i(106204);
        if (this.f1996Xa != null) {
            this.f1996Xa.cancel();
        }
        this.f1981WJ.setVisibility(0);
        if (this.f1987WT == 0 && yrg && (this.f1997Xb || z)) {
            C0477s.m938d(this.f1981WJ, 0.0f);
            float f = (float) (-this.f1981WJ.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1981WJ.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            C0477s.m938d(this.f1981WJ, f);
            C0612h c0612h = new C0612h();
            C0497w u = C0477s.m910ab(this.f1981WJ).mo1162u(0.0f);
            u.mo1154a(this.f2000Xf);
            c0612h.mo1535a(u);
            if (this.f1988WV && this.f1983WL != null) {
                C0477s.m938d(this.f1983WL, f);
                c0612h.mo1535a(C0477s.m910ab(this.f1983WL).mo1162u(0.0f));
            }
            c0612h.mo1539d(f1979WG);
            c0612h.mo1540gg();
            c0612h.mo1537b(this.f1999Xe);
            this.f1996Xa = c0612h;
            c0612h.start();
            AppMethodBeat.m2505o(106204);
            return;
        }
        C0477s.m941e(this.f1981WJ, 1.0f);
        C0477s.m938d(this.f1981WJ, 0.0f);
        if (this.f1988WV && this.f1983WL != null) {
            C0477s.m938d(this.f1983WL, 0.0f);
        }
        this.f1999Xe.mo1164aA(null);
        AppMethodBeat.m2505o(106204);
    }

    /* renamed from: R */
    private void m12414R(boolean z) {
        AppMethodBeat.m2504i(106205);
        if (this.f1996Xa != null) {
            this.f1996Xa.cancel();
        }
        if (this.f1987WT == 0 && yrg && (this.f1997Xb || z)) {
            C0477s.m941e(this.f1981WJ, 1.0f);
            this.f1981WJ.setTransitioning(true);
            C0612h c0612h = new C0612h();
            float f = (float) (-this.f1981WJ.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1981WJ.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            C0497w u = C0477s.m910ab(this.f1981WJ).mo1162u(f);
            u.mo1154a(this.f2000Xf);
            c0612h.mo1535a(u);
            if (this.f1988WV && this.f1983WL != null) {
                c0612h.mo1535a(C0477s.m910ab(this.f1983WL).mo1162u(f));
            }
            c0612h.mo1539d(f1978WF);
            c0612h.mo1540gg();
            c0612h.mo1537b(this.f1998Xd);
            this.f1996Xa = c0612h;
            c0612h.start();
            AppMethodBeat.m2505o(106205);
            return;
        }
        this.f1998Xd.mo1164aA(null);
        AppMethodBeat.m2505o(106205);
    }

    /* renamed from: S */
    public final void mo15830S(boolean z) {
        C0497w c;
        C0497w c2;
        AppMethodBeat.m2504i(106207);
        if (z) {
            m12423fF();
        } else {
            m12424fH();
        }
        if (z) {
            c = this.f1993Wk.mo2145c(8, 100);
            c2 = this.f1982WK.mo1920c(0, 200);
        } else {
            c2 = this.f1993Wk.mo2145c(0, 200);
            c = this.f1982WK.mo1920c(8, 100);
        }
        C0612h c0612h = new C0612h();
        c0612h.mo1536a(c, c2);
        c0612h.start();
        AppMethodBeat.m2505o(106207);
    }

    public final Context getThemedContext() {
        AppMethodBeat.m2504i(106208);
        if (this.f1980WH == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C25738R.attr.f5617dw, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1980WH = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.f1980WH = this.mContext;
            }
        }
        Context context = this.f1980WH;
        AppMethodBeat.m2505o(106208);
        return context;
    }

    public final void setHomeActionContentDescription(int i) {
        AppMethodBeat.m2504i(106209);
        this.f1993Wk.setNavigationContentDescription(i);
        AppMethodBeat.m2505o(106209);
    }

    /* renamed from: fJ */
    public final void mo1646fJ() {
        AppMethodBeat.m2504i(106210);
        if (this.f1996Xa != null) {
            this.f1996Xa.cancel();
            this.f1996Xa = null;
        }
        AppMethodBeat.m2505o(106210);
    }

    public final boolean collapseActionView() {
        AppMethodBeat.m2504i(106211);
        if (this.f1993Wk == null || !this.f1993Wk.hasExpandedActionView()) {
            AppMethodBeat.m2505o(106211);
            return false;
        }
        this.f1993Wk.collapseActionView();
        AppMethodBeat.m2505o(106211);
        return true;
    }

    public final void setCustomView(View view) {
        AppMethodBeat.m2504i(106212);
        this.f1993Wk.setCustomView(view);
        AppMethodBeat.m2505o(106212);
    }

    /* renamed from: fa */
    public final void mo1337fa() {
        AppMethodBeat.m2504i(106213);
        this.f1993Wk.setIcon((int) C25738R.drawable.a8g);
        AppMethodBeat.m2505o(106213);
    }

    public final void setLogo(Drawable drawable) {
        AppMethodBeat.m2504i(106214);
        this.f1993Wk.setLogo(drawable);
        AppMethodBeat.m2505o(106214);
    }

    /* renamed from: K */
    public final void mo1331K(boolean z) {
        AppMethodBeat.m2504i(106215);
        if (!this.f1984WO) {
            setDisplayHomeAsUpEnabled(z);
        }
        AppMethodBeat.m2505o(106215);
    }

    public final boolean isShowing() {
        AppMethodBeat.m2504i(106206);
        int height = this.f1981WJ.getHeight();
        if (!this.f1992WZ || (height != 0 && height <= 0)) {
            AppMethodBeat.m2505o(106206);
            return false;
        }
        AppMethodBeat.m2505o(106206);
        return true;
    }
}
