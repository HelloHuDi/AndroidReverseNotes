package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.au;
import android.support.v7.widget.x;
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
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class o extends ActionBar implements android.support.v7.widget.ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean $assertionsDisabled = (!o.class.desiredAssertionStatus());
    private static final Interpolator WF = new AccelerateInterpolator();
    private static final Interpolator WG = new DecelerateInterpolator();
    private Context WH;
    ActionBarOverlayLayout WI;
    ActionBarContainer WJ;
    ActionBarContextView WK;
    View WL;
    au WM;
    private int WN = -1;
    private boolean WO;
    a WP;
    b WQ;
    android.support.v7.view.b.a WR;
    private boolean WS;
    private int WT = 0;
    boolean WV = true;
    boolean WW;
    boolean WX;
    private boolean WY;
    private boolean WZ = true;
    x Wk;
    private boolean Wo;
    private ArrayList<Object> Wp = new ArrayList();
    h Xa;
    private boolean Xb;
    boolean Xc;
    final android.support.v4.view.x Xd = new y() {
        public final void aA(View view) {
            if (o.this.WV && o.this.WL != null) {
                o.this.WL.setTranslationY(0.0f);
                o.this.WJ.setTranslationY(0.0f);
            }
            o.this.WJ.setVisibility(8);
            o.this.WJ.setTransitioning(false);
            o.this.Xa = null;
            o oVar = o.this;
            if (oVar.WR != null) {
                oVar.WR.a(oVar.WQ);
                oVar.WQ = null;
                oVar.WR = null;
            }
            if (o.this.WI != null) {
                s.ak(o.this.WI);
            }
        }
    };
    final android.support.v4.view.x Xe = new y() {
        public final void aA(View view) {
            o.this.Xa = null;
            o.this.WJ.requestLayout();
        }
    };
    final z Xf = new z() {
        public final void es() {
            ((View) o.this.WJ.getParent()).invalidate();
        }
    };
    private Activity mActivity;
    Context mContext;
    private Dialog mDialog;
    private ArrayList<Object> rS = new ArrayList();

    public class a extends b implements android.support.v7.view.menu.h.a {
        private final Context Xh;
        private android.support.v7.view.b.a Xi;
        private WeakReference<View> Xj;
        final android.support.v7.view.menu.h lo;

        public a(Context context, android.support.v7.view.b.a aVar) {
            this.Xh = context;
            this.Xi = aVar;
            android.support.v7.view.menu.h hVar = new android.support.v7.view.menu.h(context);
            this.lo = hVar;
            this.lo.a((android.support.v7.view.menu.h.a) this);
        }

        public final MenuInflater getMenuInflater() {
            return new g(this.Xh);
        }

        public final Menu getMenu() {
            return this.lo;
        }

        public final void finish() {
            if (o.this.WP == this) {
                if (o.e(o.this.WW, o.this.WX, false)) {
                    this.Xi.a(this);
                } else {
                    o.this.WQ = this;
                    o.this.WR = this.Xi;
                }
                this.Xi = null;
                o.this.S(false);
                o.this.WK.gR();
                o.this.Wk.hW().sendAccessibilityEvent(32);
                o.this.WI.setHideOnContentScrollEnabled(o.this.Xc);
                o.this.WP = null;
            }
        }

        public final void invalidate() {
            if (o.this.WP == this) {
                this.lo.gx();
                try {
                    this.Xi.b(this, this.lo);
                } finally {
                    this.lo.gy();
                }
            }
        }

        public final boolean fK() {
            this.lo.gx();
            try {
                boolean a = this.Xi.a((b) this, this.lo);
                return a;
            } finally {
                this.lo.gy();
            }
        }

        public final void setCustomView(View view) {
            o.this.WK.setCustomView(view);
            this.Xj = new WeakReference(view);
        }

        public final void setSubtitle(CharSequence charSequence) {
            o.this.WK.setSubtitle(charSequence);
        }

        public final void setTitle(CharSequence charSequence) {
            o.this.WK.setTitle(charSequence);
        }

        public final void setTitle(int i) {
            setTitle(o.this.mContext.getResources().getString(i));
        }

        public final void setSubtitle(int i) {
            setSubtitle(o.this.mContext.getResources().getString(i));
        }

        public final CharSequence getTitle() {
            return o.this.WK.getTitle();
        }

        public final CharSequence getSubtitle() {
            return o.this.WK.getSubtitle();
        }

        public final void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            o.this.WK.setTitleOptional(z);
        }

        public final boolean isTitleOptional() {
            return o.this.WK.acR;
        }

        public final View getCustomView() {
            return this.Xj != null ? (View) this.Xj.get() : null;
        }

        public final boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            if (this.Xi != null) {
                return this.Xi.a((b) this, menuItem);
            }
            return false;
        }

        public final void b(android.support.v7.view.menu.h hVar) {
            if (this.Xi != null) {
                invalidate();
                o.this.WK.showOverflowMenu();
            }
        }
    }

    public o(Activity activity, boolean z) {
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        aR(decorView);
        if (!z) {
            this.WL = decorView.findViewById(16908290);
        }
    }

    public o(Dialog dialog) {
        this.mDialog = dialog;
        aR(dialog.getWindow().getDecorView());
    }

    private void aR(View view) {
        this.WI = (ActionBarOverlayLayout) view.findViewById(R.id.jz);
        if (this.WI != null) {
            this.WI.setActionBarVisibilityCallback(this);
        }
        this.Wk = aS(view.findViewById(R.id.k1));
        this.WK = (ActionBarContextView) view.findViewById(R.id.k2);
        this.WJ = (ActionBarContainer) view.findViewById(R.id.k0);
        if (this.Wk == null || this.WK == null || this.WJ == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = this.Wk.getContext();
        if ((this.Wk.getDisplayOptions() & 4) != 0) {
            this.WO = true;
        }
        android.support.v7.view.a X = android.support.v7.view.a.X(this.mContext);
        X.ga();
        N(X.fZ());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, android.support.v7.a.a.a.ActionBar, R.attr.dt, 0);
        if (obtainStyledAttributes.getBoolean(19, false)) {
            fe();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(26, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private static x aS(View view) {
        if (view instanceof x) {
            return (x) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of ".concat(String.valueOf(view)) != null ? view.getClass().getSimpleName() : BuildConfig.COMMAND);
    }

    public final void setElevation(float f) {
        s.h(this.WJ, f);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        N(android.support.v7.view.a.X(this.mContext).fZ());
    }

    private void N(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.WS = z;
        if (this.WS) {
            this.WJ.setTabContainer(null);
            this.Wk.a(this.WM);
        } else {
            this.Wk.a(null);
            this.WJ.setTabContainer(this.WM);
        }
        if (getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.WM != null) {
            if (z2) {
                this.WM.setVisibility(0);
                if (this.WI != null) {
                    s.ak(this.WI);
                }
            } else {
                this.WM.setVisibility(8);
            }
        }
        x xVar = this.Wk;
        if (this.WS || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        xVar.setCollapsible(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.WI;
        if (this.WS || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    public final void onWindowVisibilityChanged(int i) {
        this.WT = i;
    }

    public final void L(boolean z) {
        this.Xb = z;
        if (!z && this.Xa != null) {
            this.Xa.cancel();
        }
    }

    public final void M(boolean z) {
        if (z != this.Wo) {
            this.Wo = z;
            int size = this.Wp.size();
            for (int i = 0; i < size; i++) {
                this.Wp.get(i);
            }
        }
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.Wk.hW(), false));
    }

    public final void fb() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public final void fc() {
        setDisplayOptions(0, 8);
    }

    public final void fd() {
        setDisplayOptions(16, 16);
    }

    public final void setWindowTitle(CharSequence charSequence) {
        this.Wk.setWindowTitle(charSequence);
    }

    public final void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.WO = true;
        }
        this.Wk.setDisplayOptions(i);
    }

    private void setDisplayOptions(int i, int i2) {
        int displayOptions = this.Wk.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.WO = true;
        }
        this.Wk.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.WJ.setPrimaryBackground(drawable);
    }

    public final View getCustomView() {
        return this.Wk.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.Wk.getTitle();
    }

    private int getNavigationMode() {
        return this.Wk.getNavigationMode();
    }

    public final int getDisplayOptions() {
        return this.Wk.getDisplayOptions();
    }

    public final b a(android.support.v7.view.b.a aVar) {
        if (this.WP != null) {
            this.WP.finish();
        }
        this.WI.setHideOnContentScrollEnabled(false);
        this.WK.gS();
        a aVar2 = new a(this.WK.getContext(), aVar);
        if (!aVar2.fK()) {
            return null;
        }
        this.WP = aVar2;
        aVar2.invalidate();
        this.WK.c(aVar2);
        S(true);
        this.WK.sendAccessibilityEvent(32);
        return aVar2;
    }

    public final int getHeight() {
        return this.WJ.getHeight();
    }

    public final void O(boolean z) {
        this.WV = z;
    }

    public final void show() {
        if (this.WW) {
            this.WW = false;
            P(false);
        }
    }

    private void fF() {
        if (!this.WY) {
            this.WY = true;
            if (this.WI != null) {
                this.WI.setShowingForActionMode(true);
            }
            P(false);
        }
    }

    public final void fG() {
        if (this.WX) {
            this.WX = false;
            P(true);
        }
    }

    public final void hide() {
        if (!this.WW) {
            this.WW = true;
            P(false);
        }
    }

    private void fH() {
        if (this.WY) {
            this.WY = false;
            if (this.WI != null) {
                this.WI.setShowingForActionMode(false);
            }
            P(false);
        }
    }

    public final void fI() {
        if (!this.WX) {
            this.WX = true;
            P(true);
        }
    }

    public final void fe() {
        if (this.WI.adb) {
            this.Xc = true;
            this.WI.setHideOnContentScrollEnabled(true);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    static boolean e(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void P(boolean z) {
        if (e(this.WW, this.WX, this.WY)) {
            if (!this.WZ) {
                this.WZ = true;
                Q(z);
            }
        } else if (this.WZ) {
            this.WZ = false;
            R(z);
        }
    }

    private void Q(boolean z) {
        if (this.Xa != null) {
            this.Xa.cancel();
        }
        this.WJ.setVisibility(0);
        if (this.WT == 0 && (this.Xb || z)) {
            this.WJ.setTranslationY(0.0f);
            float f = (float) (-this.WJ.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.WJ.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.WJ.setTranslationY(f);
            h hVar = new h();
            w u = s.ab(this.WJ).u(0.0f);
            u.a(this.Xf);
            hVar.a(u);
            if (this.WV && this.WL != null) {
                this.WL.setTranslationY(f);
                hVar.a(s.ab(this.WL).u(0.0f));
            }
            hVar.d(WG);
            hVar.gg();
            hVar.b(this.Xe);
            this.Xa = hVar;
            hVar.start();
        } else {
            this.WJ.setAlpha(1.0f);
            this.WJ.setTranslationY(0.0f);
            if (this.WV && this.WL != null) {
                this.WL.setTranslationY(0.0f);
            }
            this.Xe.aA(null);
        }
        if (this.WI != null) {
            s.ak(this.WI);
        }
    }

    private void R(boolean z) {
        if (this.Xa != null) {
            this.Xa.cancel();
        }
        if (this.WT == 0 && (this.Xb || z)) {
            this.WJ.setAlpha(1.0f);
            this.WJ.setTransitioning(true);
            h hVar = new h();
            float f = (float) (-this.WJ.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.WJ.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            w u = s.ab(this.WJ).u(f);
            u.a(this.Xf);
            hVar.a(u);
            if (this.WV && this.WL != null) {
                hVar.a(s.ab(this.WL).u(f));
            }
            hVar.d(WF);
            hVar.gg();
            hVar.b(this.Xd);
            this.Xa = hVar;
            hVar.start();
            return;
        }
        this.Xd.aA(null);
    }

    public final void S(boolean z) {
        if (z) {
            fF();
        } else {
            fH();
        }
        if (s.as(this.WJ)) {
            w c;
            w c2;
            if (z) {
                c = this.Wk.c(4, 100);
                c2 = this.WK.c(0, 200);
            } else {
                c2 = this.Wk.c(0, 200);
                c = this.WK.c(8, 100);
            }
            h hVar = new h();
            hVar.a(c, c2);
            hVar.start();
        } else if (z) {
            this.Wk.setVisibility(4);
            this.WK.setVisibility(0);
        } else {
            this.Wk.setVisibility(0);
            this.WK.setVisibility(8);
        }
    }

    public final Context getThemedContext() {
        if (this.WH == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.dw, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.WH = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.WH = this.mContext;
            }
        }
        return this.WH;
    }

    public final void setHomeActionContentDescription(int i) {
        this.Wk.setNavigationContentDescription(i);
    }

    public final void fJ() {
        if (this.Xa != null) {
            this.Xa.cancel();
            this.Xa = null;
        }
    }

    public final boolean collapseActionView() {
        if (this.Wk == null || !this.Wk.hasExpandedActionView()) {
            return false;
        }
        this.Wk.collapseActionView();
        return true;
    }

    public final void setCustomView(View view) {
        this.Wk.setCustomView(view);
    }

    public final void fa() {
        this.Wk.setIcon((int) R.drawable.a8g);
    }

    public final void setLogo(Drawable drawable) {
        this.Wk.setLogo(drawable);
    }

    public final void K(boolean z) {
        if (!this.WO) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        if (this.WP == null) {
            return false;
        }
        android.support.v7.view.menu.h hVar = this.WP.lo;
        if (hVar == null) {
            return false;
        }
        boolean z;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
            z = true;
        } else {
            z = false;
        }
        hVar.setQwertyMode(z);
        return hVar.performShortcut(i, keyEvent, 0);
    }

    public final boolean isShowing() {
        int height = this.WJ.getHeight();
        return this.WZ && (height == 0 || this.WI.getActionBarHideOffset() < height);
    }
}
