package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v7.a.a.a;
import android.support.v7.c.a.b;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import com.tencent.mm.R;

public final class bd implements x {
    CharSequence IT;
    private CharSequence IU;
    Callback Wm;
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
    Toolbar oM;
    private Drawable rP;
    private View sQ;

    public bd(Toolbar toolbar, boolean z) {
        this(toolbar, z, (byte) 0);
    }

    private bd(Toolbar toolbar, boolean z, byte b) {
        this.auy = 0;
        this.auz = 0;
        this.oM = toolbar;
        this.IT = toolbar.getTitle();
        this.IU = toolbar.getSubtitle();
        this.auv = this.IT != null;
        this.auu = toolbar.getNavigationIcon();
        bc a = bc.a(toolbar.getContext(), null, a.ActionBar, R.attr.dt, 0);
        this.auA = a.getDrawable(28);
        int resourceId;
        if (z) {
            Toolbar toolbar2;
            Context context;
            CharSequence text = a.getText(1);
            if (!TextUtils.isEmpty(text)) {
                this.auv = true;
                o(text);
            }
            text = a.getText(4);
            if (!TextUtils.isEmpty(text)) {
                this.IU = text;
                if ((this.aur & 8) != 0) {
                    this.oM.setSubtitle(text);
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
                ls();
            }
            setDisplayOptions(a.getInt(3, 0));
            resourceId = a.getResourceId(13, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.oM.getContext()).inflate(resourceId, this.oM, false));
                setDisplayOptions(this.aur | 16);
            }
            resourceId = a.getLayoutDimension(0, 0);
            if (resourceId > 0) {
                LayoutParams layoutParams = this.oM.getLayoutParams();
                layoutParams.height = resourceId;
                this.oM.setLayoutParams(layoutParams);
            }
            resourceId = a.getDimensionPixelOffset(20, -1);
            int dimensionPixelOffset = a.getDimensionPixelOffset(21, -1);
            if (resourceId >= 0 || dimensionPixelOffset >= 0) {
                Toolbar toolbar3 = this.oM;
                resourceId = Math.max(resourceId, 0);
                dimensionPixelOffset = Math.max(dimensionPixelOffset, 0);
                toolbar3.lq();
                toolbar3.atX.aI(resourceId, dimensionPixelOffset);
            }
            resourceId = a.getResourceId(5, 0);
            if (resourceId != 0) {
                toolbar2 = this.oM;
                context = this.oM.getContext();
                toolbar2.atP = resourceId;
                if (toolbar2.atH != null) {
                    toolbar2.atH.setTextAppearance(context, resourceId);
                }
            }
            resourceId = a.getResourceId(6, 0);
            if (resourceId != 0) {
                toolbar2 = this.oM;
                context = this.oM.getContext();
                toolbar2.atQ = resourceId;
                if (toolbar2.atI != null) {
                    toolbar2.atI.setTextAppearance(context, resourceId);
                }
            }
            resourceId = a.getResourceId(27, 0);
            if (resourceId != 0) {
                this.oM.setPopupTheme(resourceId);
            }
        } else {
            resourceId = 11;
            if (this.oM.getNavigationIcon() != null) {
                resourceId = 15;
                this.auA = this.oM.getNavigationIcon();
            }
            this.aur = resourceId;
        }
        a.atG.recycle();
        if (R.string.c != this.auz) {
            this.auz = R.string.c;
            if (TextUtils.isEmpty(this.oM.getNavigationContentDescription())) {
                setNavigationContentDescription(this.auz);
            }
        }
        this.auw = this.oM.getNavigationContentDescription();
        this.oM.setNavigationOnClickListener(new OnClickListener() {
            final android.support.v7.view.menu.a auB = new android.support.v7.view.menu.a(bd.this.oM.getContext(), bd.this.IT);

            public final void onClick(View view) {
                if (bd.this.Wm != null && bd.this.aux) {
                    bd.this.Wm.onMenuItemSelected(0, this.auB);
                }
            }
        });
    }

    public final ViewGroup hW() {
        return this.oM;
    }

    public final Context getContext() {
        return this.oM.getContext();
    }

    public final boolean hasExpandedActionView() {
        Toolbar toolbar = this.oM;
        return (toolbar.auk == null || toolbar.auk.aun == null) ? false : true;
    }

    public final void collapseActionView() {
        this.oM.collapseActionView();
    }

    public final void setWindowCallback(Callback callback) {
        this.Wm = callback;
    }

    public final void setWindowTitle(CharSequence charSequence) {
        if (!this.auv) {
            o(charSequence);
        }
    }

    public final CharSequence getTitle() {
        return this.oM.getTitle();
    }

    private void o(CharSequence charSequence) {
        this.IT = charSequence;
        if ((this.aur & 8) != 0) {
            this.oM.setTitle(charSequence);
        }
    }

    public final void setIcon(int i) {
        setIcon(i != 0 ? b.g(this.oM.getContext(), i) : null);
    }

    public final void setIcon(Drawable drawable) {
        this.rP = drawable;
        lr();
    }

    public final void setLogo(int i) {
        setLogo(i != 0 ? b.g(this.oM.getContext(), i) : null);
    }

    public final void setLogo(Drawable drawable) {
        this.aut = drawable;
        lr();
    }

    private void lr() {
        Drawable drawable = null;
        if ((this.aur & 2) != 0) {
            drawable = (this.aur & 1) != 0 ? this.aut != null ? this.aut : this.rP : this.rP;
        }
        this.oM.setLogo(drawable);
    }

    public final boolean gV() {
        Toolbar toolbar = this.oM;
        return toolbar.getVisibility() == 0 && toolbar.acw != null && toolbar.acw.ady;
    }

    public final boolean isOverflowMenuShowing() {
        return this.oM.isOverflowMenuShowing();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean gW() {
        Toolbar toolbar = this.oM;
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
        return this.oM.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        Toolbar toolbar = this.oM;
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

    public final void gX() {
        this.aux = true;
    }

    public final void a(Menu menu, o.a aVar) {
        if (this.acx == null) {
            this.acx = new ActionMenuPresenter(this.oM.getContext());
            this.acx.mId = R.id.d;
        }
        this.acx.lL = aVar;
        Toolbar toolbar = this.oM;
        h hVar = (h) menu;
        o oVar = this.acx;
        if (hVar != null || toolbar.acw != null) {
            toolbar.lm();
            h hVar2 = toolbar.acw.lo;
            if (hVar2 != hVar) {
                if (hVar2 != null) {
                    hVar2.b(toolbar.auj);
                    hVar2.b(toolbar.auk);
                }
                if (toolbar.auk == null) {
                    toolbar.auk = new a();
                }
                oVar.adG = true;
                if (hVar != null) {
                    hVar.a(oVar, toolbar.acv);
                    hVar.a(toolbar.auk, toolbar.acv);
                } else {
                    oVar.a(toolbar.acv, null);
                    toolbar.auk.a(toolbar.acv, null);
                    oVar.n(true);
                    toolbar.auk.n(true);
                }
                toolbar.acw.setPopupTheme(toolbar.adW);
                toolbar.acw.setPresenter(oVar);
                toolbar.auj = oVar;
            }
        }
    }

    public final void dismissPopupMenus() {
        Toolbar toolbar = this.oM;
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
                    lt();
                }
                ls();
            }
            if ((i2 & 3) != 0) {
                lr();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.oM.setTitle(this.IT);
                    this.oM.setSubtitle(this.IU);
                } else {
                    this.oM.setTitle(null);
                    this.oM.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.sQ != null) {
                if ((i & 16) != 0) {
                    this.oM.addView(this.sQ);
                } else {
                    this.oM.removeView(this.sQ);
                }
            }
        }
    }

    public final void a(au auVar) {
        if (this.aus != null && this.aus.getParent() == this.oM) {
            this.oM.removeView(this.aus);
        }
        this.aus = auVar;
        if (auVar != null && this.auy == 2) {
            this.oM.addView(this.aus, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.aus.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            auVar.setAllowCollapse(true);
        }
    }

    public final void setCollapsible(boolean z) {
        this.oM.setCollapsible(z);
    }

    public final int getNavigationMode() {
        return this.auy;
    }

    public final void setCustomView(View view) {
        if (!(this.sQ == null || (this.aur & 16) == 0)) {
            this.oM.removeView(this.sQ);
        }
        this.sQ = view;
        if (view != null && (this.aur & 16) != 0) {
            this.oM.addView(this.sQ);
        }
    }

    public final View getCustomView() {
        return this.sQ;
    }

    public final w c(final int i, long j) {
        return s.ab(this.oM).t(i == 0 ? 1.0f : 0.0f).l(j).a(new y() {
            private boolean xH = false;

            public final void az(View view) {
                bd.this.oM.setVisibility(0);
            }

            public final void aA(View view) {
                if (!this.xH) {
                    bd.this.oM.setVisibility(i);
                }
            }

            public final void aB(View view) {
                this.xH = true;
            }
        });
    }

    private void ls() {
        if ((this.aur & 4) != 0) {
            this.oM.setNavigationIcon(this.auu != null ? this.auu : this.auA);
        } else {
            this.oM.setNavigationIcon(null);
        }
    }

    private void setNavigationContentDescription(CharSequence charSequence) {
        this.auw = charSequence;
        lt();
    }

    public final void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i == 0 ? null : this.oM.getContext().getString(i));
    }

    private void lt() {
        if ((this.aur & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.auw)) {
            this.oM.setNavigationContentDescription(this.auz);
        } else {
            this.oM.setNavigationContentDescription(this.auw);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        s.a(this.oM, drawable);
    }

    public final int getHeight() {
        return this.oM.getHeight();
    }

    public final void setVisibility(int i) {
        this.oM.setVisibility(i);
    }

    public final int getVisibility() {
        return this.oM.getVisibility();
    }

    public final void a(o.a aVar, h.a aVar2) {
        Toolbar toolbar = this.oM;
        toolbar.adY = aVar;
        toolbar.adZ = aVar2;
        if (toolbar.acw != null) {
            toolbar.acw.a(aVar, aVar2);
        }
    }

    public final Menu getMenu() {
        return this.oM.getMenu();
    }
}
