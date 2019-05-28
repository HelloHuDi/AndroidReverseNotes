package android.support.p069v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C0497w;
import android.support.p057v4.view.C6203y;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.p071c.p072a.C0589b;
import android.support.p069v7.view.menu.C0628o;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C6231a;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.support.p069v7.widget.Toolbar.C0671a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.bd */
public final class C6256bd implements C0728x {
    /* renamed from: IT */
    CharSequence f1942IT;
    /* renamed from: IU */
    private CharSequence f1943IU;
    /* renamed from: Wm */
    Callback f1944Wm;
    private ActionMenuPresenter acx;
    private Drawable auA;
    private int aur;
    private View aus;
    private Drawable aut;
    private Drawable auu;
    private boolean auv;
    private CharSequence auw;
    boolean aux;
    private int auy;
    private int auz;
    /* renamed from: oM */
    Toolbar f1945oM;
    /* renamed from: rP */
    private Drawable f1946rP;
    /* renamed from: sQ */
    private View f1947sQ;

    /* renamed from: android.support.v7.widget.bd$1 */
    class C07001 implements OnClickListener {
        final C6231a auB = new C6231a(C6256bd.this.f1945oM.getContext(), C6256bd.this.f1942IT);

        C07001() {
        }

        public final void onClick(View view) {
            if (C6256bd.this.f1944Wm != null && C6256bd.this.aux) {
                C6256bd.this.f1944Wm.onMenuItemSelected(0, this.auB);
            }
        }
    }

    public C6256bd(Toolbar toolbar, boolean z) {
        this(toolbar, z, (byte) 0);
    }

    private C6256bd(Toolbar toolbar, boolean z, byte b) {
        this.auy = 0;
        this.auz = 0;
        this.f1945oM = toolbar;
        this.f1942IT = toolbar.getTitle();
        this.f1943IU = toolbar.getSubtitle();
        this.auv = this.f1942IT != null;
        this.auu = toolbar.getNavigationIcon();
        C0699bc a = C0699bc.m1555a(toolbar.getContext(), null, C0554a.ActionBar, C25738R.attr.f5614dt, 0);
        this.auA = a.getDrawable(28);
        int resourceId;
        if (z) {
            Toolbar toolbar2;
            Context context;
            CharSequence text = a.getText(1);
            if (!TextUtils.isEmpty(text)) {
                this.auv = true;
                m10200o(text);
            }
            text = a.getText(4);
            if (!TextUtils.isEmpty(text)) {
                this.f1943IU = text;
                if ((this.aur & 8) != 0) {
                    this.f1945oM.setSubtitle(text);
                }
            }
            Drawable drawable = a.getDrawable(8);
            if (drawable != null) {
                setLogo(drawable);
            }
            drawable = a.getDrawable(7);
            if (drawable != null) {
                setIcon(drawable);
            }
            if (this.auu == null && this.auA != null) {
                this.auu = this.auA;
                m10198ls();
            }
            setDisplayOptions(a.getInt(3, 0));
            resourceId = a.getResourceId(13, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.f1945oM.getContext()).inflate(resourceId, this.f1945oM, false));
                setDisplayOptions(this.aur | 16);
            }
            resourceId = a.getLayoutDimension(0, 0);
            if (resourceId > 0) {
                LayoutParams layoutParams = this.f1945oM.getLayoutParams();
                layoutParams.height = resourceId;
                this.f1945oM.setLayoutParams(layoutParams);
            }
            resourceId = a.getDimensionPixelOffset(20, -1);
            int dimensionPixelOffset = a.getDimensionPixelOffset(21, -1);
            if (resourceId >= 0 || dimensionPixelOffset >= 0) {
                Toolbar toolbar3 = this.f1945oM;
                resourceId = Math.max(resourceId, 0);
                dimensionPixelOffset = Math.max(dimensionPixelOffset, 0);
                toolbar3.mo1869lq();
                toolbar3.atX.mo2003aI(resourceId, dimensionPixelOffset);
            }
            resourceId = a.getResourceId(5, 0);
            if (resourceId != 0) {
                toolbar2 = this.f1945oM;
                context = this.f1945oM.getContext();
                toolbar2.atP = resourceId;
                if (toolbar2.atH != null) {
                    toolbar2.atH.setTextAppearance(context, resourceId);
                }
            }
            resourceId = a.getResourceId(6, 0);
            if (resourceId != 0) {
                toolbar2 = this.f1945oM;
                context = this.f1945oM.getContext();
                toolbar2.atQ = resourceId;
                if (toolbar2.atI != null) {
                    toolbar2.atI.setTextAppearance(context, resourceId);
                }
            }
            resourceId = a.getResourceId(27, 0);
            if (resourceId != 0) {
                this.f1945oM.setPopupTheme(resourceId);
            }
        } else {
            resourceId = 11;
            if (this.f1945oM.getNavigationIcon() != null) {
                resourceId = 15;
                this.auA = this.f1945oM.getNavigationIcon();
            }
            this.aur = resourceId;
        }
        a.atG.recycle();
        if (C25738R.string.f8601c != this.auz) {
            this.auz = C25738R.string.f8601c;
            if (TextUtils.isEmpty(this.f1945oM.getNavigationContentDescription())) {
                setNavigationContentDescription(this.auz);
            }
        }
        this.auw = this.f1945oM.getNavigationContentDescription();
        this.f1945oM.setNavigationOnClickListener(new C07001());
    }

    /* renamed from: hW */
    public final ViewGroup mo2159hW() {
        return this.f1945oM;
    }

    public final Context getContext() {
        return this.f1945oM.getContext();
    }

    public final boolean hasExpandedActionView() {
        Toolbar toolbar = this.f1945oM;
        return (toolbar.auk == null || toolbar.auk.aun == null) ? false : true;
    }

    public final void collapseActionView() {
        this.f1945oM.collapseActionView();
    }

    public final void setWindowCallback(Callback callback) {
        this.f1944Wm = callback;
    }

    public final void setWindowTitle(CharSequence charSequence) {
        if (!this.auv) {
            m10200o(charSequence);
        }
    }

    public final CharSequence getTitle() {
        return this.f1945oM.getTitle();
    }

    /* renamed from: o */
    private void m10200o(CharSequence charSequence) {
        this.f1942IT = charSequence;
        if ((this.aur & 8) != 0) {
            this.f1945oM.setTitle(charSequence);
        }
    }

    public final void setIcon(int i) {
        setIcon(i != 0 ? C0589b.m1275g(this.f1945oM.getContext(), i) : null);
    }

    public final void setIcon(Drawable drawable) {
        this.f1946rP = drawable;
        m10197lr();
    }

    public final void setLogo(int i) {
        setLogo(i != 0 ? C0589b.m1275g(this.f1945oM.getContext(), i) : null);
    }

    public final void setLogo(Drawable drawable) {
        this.aut = drawable;
        m10197lr();
    }

    /* renamed from: lr */
    private void m10197lr() {
        Drawable drawable = null;
        if ((this.aur & 2) != 0) {
            drawable = (this.aur & 1) != 0 ? this.aut != null ? this.aut : this.f1946rP : this.f1946rP;
        }
        this.f1945oM.setLogo(drawable);
    }

    /* renamed from: gV */
    public final boolean mo2148gV() {
        Toolbar toolbar = this.f1945oM;
        return toolbar.getVisibility() == 0 && toolbar.acw != null && toolbar.acw.ady;
    }

    public final boolean isOverflowMenuShowing() {
        return this.f1945oM.isOverflowMenuShowing();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: gW */
    public final boolean mo2149gW() {
        Toolbar toolbar = this.f1945oM;
        if (toolbar.acw != null) {
            boolean z;
            ActionMenuView actionMenuView = toolbar.acw;
            if (actionMenuView.adX != null) {
                ActionMenuPresenter actionMenuPresenter = actionMenuView.adX;
                if (actionMenuPresenter.adM != null || actionMenuPresenter.isOverflowMenuShowing()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        return this.f1945oM.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        Toolbar toolbar = this.f1945oM;
        if (toolbar.acw != null) {
            boolean z;
            ActionMenuView actionMenuView = toolbar.acw;
            if (actionMenuView.adX == null || !actionMenuView.adX.hideOverflowMenu()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: gX */
    public final void mo2150gX() {
        this.aux = true;
    }

    /* renamed from: a */
    public final void mo2144a(Menu menu, C0627a c0627a) {
        if (this.acx == null) {
            this.acx = new ActionMenuPresenter(this.f1945oM.getContext());
            this.acx.mId = 2131820547;
        }
        this.acx.f1906lL = c0627a;
        Toolbar toolbar = this.f1945oM;
        C6236h c6236h = (C6236h) menu;
        C0628o c0628o = this.acx;
        if (c6236h != null || toolbar.acw != null) {
            toolbar.mo1867lm();
            C6236h c6236h2 = toolbar.acw.f1937lo;
            if (c6236h2 != c6236h) {
                if (c6236h2 != null) {
                    c6236h2.mo14126b(toolbar.auj);
                    c6236h2.mo14126b(toolbar.auk);
                }
                if (toolbar.auk == null) {
                    toolbar.auk = new C0671a();
                }
                c0628o.adG = true;
                if (c6236h != null) {
                    c6236h.mo14115a(c0628o, toolbar.acv);
                    c6236h.mo14115a(toolbar.auk, toolbar.acv);
                } else {
                    c0628o.mo1598a(toolbar.acv, null);
                    toolbar.auk.mo1598a(toolbar.acv, null);
                    c0628o.mo1606n(true);
                    toolbar.auk.mo1606n(true);
                }
                toolbar.acw.setPopupTheme(toolbar.adW);
                toolbar.acw.setPresenter(c0628o);
                toolbar.auj = c0628o;
            }
        }
    }

    public final void dismissPopupMenus() {
        Toolbar toolbar = this.f1945oM;
        if (toolbar.acw != null) {
            toolbar.acw.dismissPopupMenus();
        }
    }

    public final int getDisplayOptions() {
        return this.aur;
    }

    public final void setDisplayOptions(int i) {
        int i2 = this.aur ^ i;
        this.aur = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m10199lt();
                }
                m10198ls();
            }
            if ((i2 & 3) != 0) {
                m10197lr();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1945oM.setTitle(this.f1942IT);
                    this.f1945oM.setSubtitle(this.f1943IU);
                } else {
                    this.f1945oM.setTitle(null);
                    this.f1945oM.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f1947sQ != null) {
                if ((i & 16) != 0) {
                    this.f1945oM.addView(this.f1947sQ);
                } else {
                    this.f1945oM.removeView(this.f1947sQ);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo2143a(C0695au c0695au) {
        if (this.aus != null && this.aus.getParent() == this.f1945oM) {
            this.f1945oM.removeView(this.aus);
        }
        this.aus = c0695au;
        if (c0695au != null && this.auy == 2) {
            this.f1945oM.addView(this.aus, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.aus.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            c0695au.setAllowCollapse(true);
        }
    }

    public final void setCollapsible(boolean z) {
        this.f1945oM.setCollapsible(z);
    }

    public final int getNavigationMode() {
        return this.auy;
    }

    public final void setCustomView(View view) {
        if (!(this.f1947sQ == null || (this.aur & 16) == 0)) {
            this.f1945oM.removeView(this.f1947sQ);
        }
        this.f1947sQ = view;
        if (view != null && (this.aur & 16) != 0) {
            this.f1945oM.addView(this.f1947sQ);
        }
    }

    public final View getCustomView() {
        return this.f1947sQ;
    }

    /* renamed from: c */
    public final C0497w mo2145c(final int i, long j) {
        return C0477s.m910ab(this.f1945oM).mo1161t(i == 0 ? 1.0f : 0.0f).mo1158l(j).mo1153a(new C6203y() {
            /* renamed from: xH */
            private boolean f1948xH = false;

            /* renamed from: az */
            public final void mo1166az(View view) {
                C6256bd.this.f1945oM.setVisibility(0);
            }

            /* renamed from: aA */
            public final void mo1164aA(View view) {
                if (!this.f1948xH) {
                    C6256bd.this.f1945oM.setVisibility(i);
                }
            }

            /* renamed from: aB */
            public final void mo1165aB(View view) {
                this.f1948xH = true;
            }
        });
    }

    /* renamed from: ls */
    private void m10198ls() {
        if ((this.aur & 4) != 0) {
            this.f1945oM.setNavigationIcon(this.auu != null ? this.auu : this.auA);
        } else {
            this.f1945oM.setNavigationIcon(null);
        }
    }

    private void setNavigationContentDescription(CharSequence charSequence) {
        this.auw = charSequence;
        m10199lt();
    }

    public final void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : this.f1945oM.getContext().getString(i));
    }

    /* renamed from: lt */
    private void m10199lt() {
        if ((this.aur & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.auw)) {
            this.f1945oM.setNavigationContentDescription(this.auz);
        } else {
            this.f1945oM.setNavigationContentDescription(this.auw);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        C0477s.m904a(this.f1945oM, drawable);
    }

    public final int getHeight() {
        return this.f1945oM.getHeight();
    }

    public final void setVisibility(int i) {
        this.f1945oM.setVisibility(i);
    }

    public final int getVisibility() {
        return this.f1945oM.getVisibility();
    }

    /* renamed from: a */
    public final void mo2142a(C0627a c0627a, C0623a c0623a) {
        Toolbar toolbar = this.f1945oM;
        toolbar.adY = c0627a;
        toolbar.adZ = c0623a;
        if (toolbar.acw != null) {
            toolbar.acw.mo14272a(c0627a, c0623a);
        }
    }

    public final Menu getMenu() {
        return this.f1945oM.getMenu();
    }
}
