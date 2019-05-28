package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.x;
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
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d extends ActionBar implements android.support.v7.widget.ActionBarOverlayLayout.a {
    private static final Interpolator WF = new AccelerateInterpolator();
    private static final Interpolator WG = new DecelerateInterpolator();
    private static final boolean yrg = (VERSION.SDK_INT >= 14);
    private Context WH;
    private ActionBarContainer WJ;
    private ActionBarContextView WK;
    private View WL;
    private boolean WO;
    b WQ;
    android.support.v7.view.b.a WR;
    private int WT = 0;
    private boolean WV = true;
    private boolean WW;
    private boolean WX;
    private boolean WY;
    private boolean WZ = true;
    x Wk;
    private boolean Wo;
    private ArrayList<Object> Wp = new ArrayList();
    private h Xa;
    private boolean Xb;
    final android.support.v4.view.x Xd = new y() {
        public final void aA(View view) {
            AppMethodBeat.i(106158);
            if (d.this.WV && d.this.WL != null) {
                s.d(d.this.WL, 0.0f);
                s.d(d.this.WJ, 0.0f);
            }
            d.this.WJ.setVisibility(8);
            d.this.WJ.setTransitioning(false);
            d.this.Xa = null;
            d dVar = d.this;
            if (dVar.WR != null) {
                dVar.WR.a(dVar.WQ);
                dVar.WQ = null;
                dVar.WR = null;
            }
            AppMethodBeat.o(106158);
        }
    };
    final android.support.v4.view.x Xe = new y() {
        public final void aA(View view) {
            AppMethodBeat.i(106159);
            d.this.Xa = null;
            d.this.WJ.requestLayout();
            AppMethodBeat.o(106159);
        }
    };
    final z Xf = new z() {
        public final void es() {
            AppMethodBeat.i(106160);
            ((View) d.this.WJ.getParent()).invalidate();
            AppMethodBeat.o(106160);
        }
    };
    private Activity mActivity;
    private Context mContext;
    a yrh;

    public class a extends b implements android.support.v7.view.menu.h.a {
        private final Context Xh;
        private android.support.v7.view.b.a Xi;
        private WeakReference<View> Xj;
        private final android.support.v7.view.menu.h lo;

        public a(Context context, android.support.v7.view.b.a aVar) {
            AppMethodBeat.i(106161);
            this.Xh = context;
            this.Xi = aVar;
            android.support.v7.view.menu.h hVar = new android.support.v7.view.menu.h(context);
            this.lo = hVar;
            this.lo.a((android.support.v7.view.menu.h.a) this);
            AppMethodBeat.o(106161);
        }

        public final MenuInflater getMenuInflater() {
            AppMethodBeat.i(106162);
            g gVar = new g(this.Xh);
            AppMethodBeat.o(106162);
            return gVar;
        }

        public final Menu getMenu() {
            return this.lo;
        }

        public final void finish() {
            AppMethodBeat.i(106163);
            if (d.this.yrh != this) {
                AppMethodBeat.o(106163);
                return;
            }
            if (d.ah(d.this.WW, d.this.WX)) {
                this.Xi.a(this);
            } else {
                d.this.WQ = this;
                d.this.WR = this.Xi;
            }
            this.Xi = null;
            d.this.S(false);
            d.this.WK.gR();
            d.this.Wk.hW().sendAccessibilityEvent(32);
            d.this.yrh = null;
            AppMethodBeat.o(106163);
        }

        public final void invalidate() {
            AppMethodBeat.i(106164);
            if (d.this.yrh != this) {
                AppMethodBeat.o(106164);
                return;
            }
            this.lo.gx();
            try {
                this.Xi.b(this, this.lo);
            } finally {
                this.lo.gy();
                AppMethodBeat.o(106164);
            }
        }

        public final boolean fK() {
            AppMethodBeat.i(106165);
            this.lo.gx();
            try {
                boolean a = this.Xi.a((b) this, this.lo);
                return a;
            } finally {
                this.lo.gy();
                AppMethodBeat.o(106165);
            }
        }

        public final void setCustomView(View view) {
            AppMethodBeat.i(106166);
            d.this.WK.setCustomView(view);
            this.Xj = new WeakReference(view);
            AppMethodBeat.o(106166);
        }

        public final void setSubtitle(CharSequence charSequence) {
            AppMethodBeat.i(106167);
            d.this.WK.setSubtitle(charSequence);
            AppMethodBeat.o(106167);
        }

        public final void setTitle(CharSequence charSequence) {
            AppMethodBeat.i(106168);
            d.this.WK.setTitle(charSequence);
            AppMethodBeat.o(106168);
        }

        public final void setTitle(int i) {
            AppMethodBeat.i(106169);
            setTitle(d.this.mContext.getResources().getString(i));
            AppMethodBeat.o(106169);
        }

        public final void setSubtitle(int i) {
            AppMethodBeat.i(106170);
            setSubtitle(d.this.mContext.getResources().getString(i));
            AppMethodBeat.o(106170);
        }

        public final CharSequence getTitle() {
            AppMethodBeat.i(106171);
            CharSequence title = d.this.WK.getTitle();
            AppMethodBeat.o(106171);
            return title;
        }

        public final CharSequence getSubtitle() {
            AppMethodBeat.i(106172);
            CharSequence subtitle = d.this.WK.getSubtitle();
            AppMethodBeat.o(106172);
            return subtitle;
        }

        public final void setTitleOptionalHint(boolean z) {
            AppMethodBeat.i(106173);
            super.setTitleOptionalHint(z);
            d.this.WK.setTitleOptional(z);
            AppMethodBeat.o(106173);
        }

        public final boolean isTitleOptional() {
            AppMethodBeat.i(106174);
            boolean z = d.this.WK.acR;
            AppMethodBeat.o(106174);
            return z;
        }

        public final View getCustomView() {
            AppMethodBeat.i(106175);
            if (this.Xj != null) {
                View view = (View) this.Xj.get();
                AppMethodBeat.o(106175);
                return view;
            }
            AppMethodBeat.o(106175);
            return null;
        }

        public final boolean a(android.support.v7.view.menu.h hVar, MenuItem menuItem) {
            AppMethodBeat.i(106176);
            if (this.Xi != null) {
                boolean a = this.Xi.a((b) this, menuItem);
                AppMethodBeat.o(106176);
                return a;
            }
            AppMethodBeat.o(106176);
            return false;
        }

        public final void b(android.support.v7.view.menu.h hVar) {
            AppMethodBeat.i(106177);
            if (this.Xi == null) {
                AppMethodBeat.o(106177);
                return;
            }
            invalidate();
            d.this.WK.showOverflowMenu();
            AppMethodBeat.o(106177);
        }
    }

    static /* synthetic */ boolean ah(boolean z, boolean z2) {
        AppMethodBeat.i(106216);
        boolean e = e(z, z2, false);
        AppMethodBeat.o(106216);
        return e;
    }

    static {
        AppMethodBeat.i(106217);
        AppMethodBeat.o(106217);
    }

    public d(Activity activity, ViewGroup viewGroup) {
        x xVar;
        AppMethodBeat.i(106178);
        this.mActivity = activity;
        View findViewById = viewGroup.findViewById(R.id.k1);
        if (findViewById instanceof x) {
            xVar = (x) findViewById;
        } else if (findViewById instanceof Toolbar) {
            xVar = ((Toolbar) findViewById).getWrapper();
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Can't make a decor toolbar out of ".concat(String.valueOf(findViewById)) != null ? findViewById.getClass().getSimpleName() : BuildConfig.COMMAND);
            AppMethodBeat.o(106178);
            throw illegalStateException;
        }
        this.Wk = xVar;
        this.WK = (ActionBarContextView) viewGroup.findViewById(R.id.k2);
        this.WJ = (ActionBarContainer) viewGroup.findViewById(R.id.k0);
        if (this.Wk == null || this.WK == null || this.WJ == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
            AppMethodBeat.o(106178);
            throw illegalStateException2;
        }
        this.mContext = this.Wk.getContext();
        if ((this.Wk.getDisplayOptions() & 4) != 0) {
            this.WO = true;
        }
        android.support.v7.view.a.X(this.mContext).ga();
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, android.support.v7.a.a.a.ActionBar, R.attr.dt, 0);
        obtainStyledAttributes.getBoolean(19, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(26, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
        this.WL = null;
        AppMethodBeat.o(106178);
    }

    public final void setElevation(float f) {
        AppMethodBeat.i(106179);
        s.h(this.WJ, f);
        AppMethodBeat.o(106179);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(106180);
        LayoutParams layoutParams = this.Wk.hW().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = com.tencent.mm.compatible.util.a.bG(this.mActivity);
        }
        this.Wk.hW().setLayoutParams(layoutParams);
        AppMethodBeat.o(106180);
    }

    public final void onWindowVisibilityChanged(int i) {
        this.WT = i;
    }

    public final void L(boolean z) {
        AppMethodBeat.i(106181);
        this.Xb = z;
        if (!(z || this.Xa == null)) {
            this.Xa.cancel();
        }
        AppMethodBeat.o(106181);
    }

    public final void M(boolean z) {
        AppMethodBeat.i(106182);
        if (z == this.Wo) {
            AppMethodBeat.o(106182);
            return;
        }
        this.Wo = z;
        int size = this.Wp.size();
        for (int i = 0; i < size; i++) {
            this.Wp.get(i);
        }
        AppMethodBeat.o(106182);
    }

    public final void setCustomView(int i) {
        AppMethodBeat.i(106183);
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.Wk.hW(), false));
        AppMethodBeat.o(106183);
    }

    public final void fb() {
        AppMethodBeat.i(106184);
        setDisplayOptions(0, 2);
        AppMethodBeat.o(106184);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        AppMethodBeat.i(106185);
        setDisplayOptions(z ? 4 : 0, 4);
        AppMethodBeat.o(106185);
    }

    public final void fc() {
        AppMethodBeat.i(106186);
        setDisplayOptions(0, 8);
        AppMethodBeat.o(106186);
    }

    public final void fd() {
        AppMethodBeat.i(106187);
        setDisplayOptions(16, 16);
        AppMethodBeat.o(106187);
    }

    public final void setWindowTitle(CharSequence charSequence) {
        AppMethodBeat.i(106188);
        this.Wk.setWindowTitle(charSequence);
        AppMethodBeat.o(106188);
    }

    public final void setDisplayOptions(int i) {
        AppMethodBeat.i(106189);
        if ((i & 4) != 0) {
            this.WO = true;
        }
        this.Wk.setDisplayOptions(i);
        AppMethodBeat.o(106189);
    }

    private void setDisplayOptions(int i, int i2) {
        AppMethodBeat.i(106190);
        int displayOptions = this.Wk.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.WO = true;
        }
        this.Wk.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
        AppMethodBeat.o(106190);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        AppMethodBeat.i(106191);
        this.WJ.setPrimaryBackground(drawable);
        AppMethodBeat.o(106191);
    }

    public final View getCustomView() {
        AppMethodBeat.i(106192);
        View customView = this.Wk.getCustomView();
        AppMethodBeat.o(106192);
        return customView;
    }

    public final CharSequence getTitle() {
        AppMethodBeat.i(106193);
        CharSequence title = this.Wk.getTitle();
        AppMethodBeat.o(106193);
        return title;
    }

    public final int getDisplayOptions() {
        AppMethodBeat.i(106194);
        int displayOptions = this.Wk.getDisplayOptions();
        AppMethodBeat.o(106194);
        return displayOptions;
    }

    public final b a(android.support.v7.view.b.a aVar) {
        AppMethodBeat.i(106195);
        if (this.yrh != null) {
            this.yrh.finish();
        }
        this.WK.gS();
        a aVar2 = new a(this.WK.getContext(), aVar);
        if (aVar2.fK()) {
            aVar2.invalidate();
            this.WK.c(aVar2);
            S(true);
            this.WK.sendAccessibilityEvent(32);
            this.yrh = aVar2;
            AppMethodBeat.o(106195);
            return aVar2;
        }
        AppMethodBeat.o(106195);
        return null;
    }

    public final int getHeight() {
        AppMethodBeat.i(106196);
        int height = this.WJ.getHeight();
        AppMethodBeat.o(106196);
        return height;
    }

    public final void O(boolean z) {
        this.WV = z;
    }

    public final void show() {
        AppMethodBeat.i(106197);
        if (this.WW) {
            this.WW = false;
            P(false);
        }
        AppMethodBeat.o(106197);
    }

    private void fF() {
        AppMethodBeat.i(106198);
        if (!this.WY) {
            this.WY = true;
            P(false);
        }
        AppMethodBeat.o(106198);
    }

    public final void fG() {
        AppMethodBeat.i(106199);
        if (this.WX) {
            this.WX = false;
            P(true);
        }
        AppMethodBeat.o(106199);
    }

    public final void hide() {
        AppMethodBeat.i(106200);
        if (!this.WW) {
            this.WW = true;
            P(false);
        }
        AppMethodBeat.o(106200);
    }

    private void fH() {
        AppMethodBeat.i(106201);
        if (this.WY) {
            this.WY = false;
            P(false);
        }
        AppMethodBeat.o(106201);
    }

    public final void fI() {
        AppMethodBeat.i(106202);
        if (!this.WX) {
            this.WX = true;
            P(true);
        }
        AppMethodBeat.o(106202);
    }

    public final void fe() {
    }

    private static boolean e(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void P(boolean z) {
        AppMethodBeat.i(106203);
        if (e(this.WW, this.WX, this.WY)) {
            if (!this.WZ) {
                this.WZ = true;
                Q(z);
                AppMethodBeat.o(106203);
                return;
            }
        } else if (this.WZ) {
            this.WZ = false;
            R(z);
        }
        AppMethodBeat.o(106203);
    }

    private void Q(boolean z) {
        AppMethodBeat.i(106204);
        if (this.Xa != null) {
            this.Xa.cancel();
        }
        this.WJ.setVisibility(0);
        if (this.WT == 0 && yrg && (this.Xb || z)) {
            s.d(this.WJ, 0.0f);
            float f = (float) (-this.WJ.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.WJ.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            s.d(this.WJ, f);
            h hVar = new h();
            w u = s.ab(this.WJ).u(0.0f);
            u.a(this.Xf);
            hVar.a(u);
            if (this.WV && this.WL != null) {
                s.d(this.WL, f);
                hVar.a(s.ab(this.WL).u(0.0f));
            }
            hVar.d(WG);
            hVar.gg();
            hVar.b(this.Xe);
            this.Xa = hVar;
            hVar.start();
            AppMethodBeat.o(106204);
            return;
        }
        s.e(this.WJ, 1.0f);
        s.d(this.WJ, 0.0f);
        if (this.WV && this.WL != null) {
            s.d(this.WL, 0.0f);
        }
        this.Xe.aA(null);
        AppMethodBeat.o(106204);
    }

    private void R(boolean z) {
        AppMethodBeat.i(106205);
        if (this.Xa != null) {
            this.Xa.cancel();
        }
        if (this.WT == 0 && yrg && (this.Xb || z)) {
            s.e(this.WJ, 1.0f);
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
            AppMethodBeat.o(106205);
            return;
        }
        this.Xd.aA(null);
        AppMethodBeat.o(106205);
    }

    public final void S(boolean z) {
        w c;
        w c2;
        AppMethodBeat.i(106207);
        if (z) {
            fF();
        } else {
            fH();
        }
        if (z) {
            c = this.Wk.c(8, 100);
            c2 = this.WK.c(0, 200);
        } else {
            c2 = this.Wk.c(0, 200);
            c = this.WK.c(8, 100);
        }
        h hVar = new h();
        hVar.a(c, c2);
        hVar.start();
        AppMethodBeat.o(106207);
    }

    public final Context getThemedContext() {
        AppMethodBeat.i(106208);
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
        Context context = this.WH;
        AppMethodBeat.o(106208);
        return context;
    }

    public final void setHomeActionContentDescription(int i) {
        AppMethodBeat.i(106209);
        this.Wk.setNavigationContentDescription(i);
        AppMethodBeat.o(106209);
    }

    public final void fJ() {
        AppMethodBeat.i(106210);
        if (this.Xa != null) {
            this.Xa.cancel();
            this.Xa = null;
        }
        AppMethodBeat.o(106210);
    }

    public final boolean collapseActionView() {
        AppMethodBeat.i(106211);
        if (this.Wk == null || !this.Wk.hasExpandedActionView()) {
            AppMethodBeat.o(106211);
            return false;
        }
        this.Wk.collapseActionView();
        AppMethodBeat.o(106211);
        return true;
    }

    public final void setCustomView(View view) {
        AppMethodBeat.i(106212);
        this.Wk.setCustomView(view);
        AppMethodBeat.o(106212);
    }

    public final void fa() {
        AppMethodBeat.i(106213);
        this.Wk.setIcon((int) R.drawable.a8g);
        AppMethodBeat.o(106213);
    }

    public final void setLogo(Drawable drawable) {
        AppMethodBeat.i(106214);
        this.Wk.setLogo(drawable);
        AppMethodBeat.o(106214);
    }

    public final void K(boolean z) {
        AppMethodBeat.i(106215);
        if (!this.WO) {
            setDisplayHomeAsUpEnabled(z);
        }
        AppMethodBeat.o(106215);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(106206);
        int height = this.WJ.getHeight();
        if (!this.WZ || (height != 0 && height <= 0)) {
            AppMethodBeat.o(106206);
            return false;
        }
        AppMethodBeat.o(106206);
        return true;
    }
}
