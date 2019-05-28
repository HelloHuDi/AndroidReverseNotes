package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.b.a.b;
import android.support.v7.view.menu.p.a;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;

public final class j implements b {
    static String abW;
    static String abX;
    static String abY;
    static String abZ;
    private int Dj = 16;
    private CharSequence IT;
    private final int ZM;
    private final int ZN;
    final int ZO;
    private CharSequence ZP;
    private char ZQ;
    private int ZR = 4096;
    private char ZS;
    private int ZT = 4096;
    private Drawable ZU;
    private int ZV = 0;
    private OnMenuItemClickListener ZW;
    private CharSequence ZX;
    private CharSequence ZY;
    private Mode ZZ = null;
    private boolean aaa = false;
    private boolean aab = false;
    private u abN;
    private Runnable abO;
    private boolean abP = false;
    private int abQ = 0;
    private View abR;
    public android.support.v4.view.b abS;
    private OnActionExpandListener abT;
    private boolean abU = false;
    ContextMenuInfo abV;
    private ColorStateList lE = null;
    h lo;
    private final int mId;
    private Intent mIntent;

    j(h hVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.lo = hVar;
        this.mId = i2;
        this.ZM = i;
        this.ZN = i3;
        this.ZO = i4;
        this.IT = charSequence;
        this.abQ = i5;
    }

    public final boolean gF() {
        if ((this.ZW != null && this.ZW.onMenuItemClick(this)) || this.lo.d(this.lo, this)) {
            return true;
        }
        if (this.abO != null) {
            this.abO.run();
            return true;
        }
        if (this.mIntent != null) {
            try {
                this.lo.mContext.startActivity(this.mIntent);
                return true;
            } catch (ActivityNotFoundException e) {
            }
        }
        if (this.abS == null || !this.abS.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.Dj & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.Dj |= 16;
        } else {
            this.Dj &= -17;
        }
        this.lo.p(false);
        return this;
    }

    public final int getGroupId() {
        return this.ZM;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.mId;
    }

    public final int getOrder() {
        return this.ZN;
    }

    public final Intent getIntent() {
        return this.mIntent;
    }

    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.ZS;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.ZS != c) {
            this.ZS = Character.toLowerCase(c);
            this.lo.p(false);
        }
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (!(this.ZS == c && this.ZT == i)) {
            this.ZS = Character.toLowerCase(c);
            this.ZT = KeyEvent.normalizeMetaState(i);
            this.lo.p(false);
        }
        return this;
    }

    public final int getAlphabeticModifiers() {
        return this.ZT;
    }

    public final char getNumericShortcut() {
        return this.ZQ;
    }

    public final int getNumericModifiers() {
        return this.ZR;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.ZQ != c) {
            this.ZQ = c;
            this.lo.p(false);
        }
        return this;
    }

    public final MenuItem setNumericShortcut(char c, int i) {
        if (!(this.ZQ == c && this.ZR == i)) {
            this.ZQ = c;
            this.ZR = KeyEvent.normalizeMetaState(i);
            this.lo.p(false);
        }
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.ZQ = c;
        this.ZS = Character.toLowerCase(c2);
        this.lo.p(false);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.ZQ = c;
        this.ZR = KeyEvent.normalizeMetaState(i);
        this.ZS = Character.toLowerCase(c2);
        this.ZT = KeyEvent.normalizeMetaState(i2);
        this.lo.p(false);
        return this;
    }

    /* Access modifiers changed, original: final */
    public final char gG() {
        return this.lo.gv() ? this.ZS : this.ZQ;
    }

    /* Access modifiers changed, original: final */
    public final boolean gH() {
        return this.lo.gw() && gG() != 0;
    }

    public final SubMenu getSubMenu() {
        return this.abN;
    }

    public final boolean hasSubMenu() {
        return this.abN != null;
    }

    public final void b(u uVar) {
        this.abN = uVar;
        uVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.IT;
    }

    /* Access modifiers changed, original: final */
    public final CharSequence a(a aVar) {
        if (aVar.br()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.IT = charSequence;
        this.lo.p(false);
        if (this.abN != null) {
            this.abN.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.lo.mContext.getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.ZP != null ? this.ZP : this.IT;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.ZP = charSequence;
        this.lo.p(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.ZU != null) {
            return i(this.ZU);
        }
        if (this.ZV == 0) {
            return null;
        }
        Drawable g = android.support.v7.c.a.b.g(this.lo.mContext, this.ZV);
        this.ZV = 0;
        this.ZU = g;
        return i(g);
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.ZV = 0;
        this.ZU = drawable;
        this.abP = true;
        this.lo.p(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.ZU = null;
        this.ZV = i;
        this.abP = true;
        this.lo.p(false);
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.lE = colorStateList;
        this.aaa = true;
        this.abP = true;
        this.lo.p(false);
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.lE;
    }

    public final MenuItem setIconTintMode(Mode mode) {
        this.ZZ = mode;
        this.aab = true;
        this.abP = true;
        this.lo.p(false);
        return this;
    }

    public final Mode getIconTintMode() {
        return this.ZZ;
    }

    private Drawable i(Drawable drawable) {
        if (drawable != null && this.abP && (this.aaa || this.aab)) {
            drawable = android.support.v4.a.a.a.f(drawable).mutate();
            if (this.aaa) {
                android.support.v4.a.a.a.a(drawable, this.lE);
            }
            if (this.aab) {
                android.support.v4.a.a.a.a(drawable, this.ZZ);
            }
            this.abP = false;
        }
        return drawable;
    }

    public final boolean isCheckable() {
        return (this.Dj & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.Dj;
        this.Dj = (z ? 1 : 0) | (this.Dj & -2);
        if (i != this.Dj) {
            this.lo.p(false);
        }
        return this;
    }

    public final void V(boolean z) {
        this.Dj = (z ? 4 : 0) | (this.Dj & -5);
    }

    public final boolean gI() {
        return (this.Dj & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.Dj & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.Dj & 4) != 0) {
            h hVar = this.lo;
            int groupId = getGroupId();
            int size = hVar.mItems.size();
            hVar.gx();
            for (int i = 0; i < size; i++) {
                j jVar = (j) hVar.mItems.get(i);
                if (jVar.getGroupId() == groupId && jVar.gI() && jVar.isCheckable()) {
                    jVar.W(jVar == this);
                }
            }
            hVar.gy();
        } else {
            W(z);
        }
        return this;
    }

    private void W(boolean z) {
        int i;
        int i2 = this.Dj;
        int i3 = this.Dj & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.Dj = i | i3;
        if (i2 != this.Dj) {
            this.lo.p(false);
        }
    }

    public final boolean isVisible() {
        if (this.abS == null || !this.abS.overridesItemVisibility()) {
            if ((this.Dj & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.Dj & 8) == 0 && this.abS.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean X(boolean z) {
        int i = this.Dj;
        this.Dj = (z ? 0 : 8) | (this.Dj & -9);
        if (i != this.Dj) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (X(z)) {
            this.lo.gz();
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.ZW = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.IT != null ? this.IT.toString() : null;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.abV;
    }

    public final boolean gJ() {
        return (this.Dj & 32) == 32;
    }

    public final boolean gK() {
        return (this.abQ & 1) == 1;
    }

    public final boolean gL() {
        return (this.abQ & 2) == 2;
    }

    public final void Y(boolean z) {
        if (z) {
            this.Dj |= 32;
        } else {
            this.Dj &= -33;
        }
    }

    public final boolean gM() {
        return (this.abQ & 4) == 4;
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.abQ = i;
                this.lo.gA();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    private b aT(View view) {
        this.abR = view;
        this.abS = null;
        if (view != null && view.getId() == -1 && this.mId > 0) {
            view.setId(this.mId);
        }
        this.lo.gA();
        return this;
    }

    public final View getActionView() {
        if (this.abR != null) {
            return this.abR;
        }
        if (this.abS == null) {
            return null;
        }
        this.abR = this.abS.onCreateActionView(this);
        return this.abR;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final android.support.v4.view.b dG() {
        return this.abS;
    }

    public final b a(android.support.v4.view.b bVar) {
        if (this.abS != null) {
            android.support.v4.view.b bVar2 = this.abS;
            bVar2.LH = null;
            bVar2.LG = null;
        }
        this.abR = null;
        this.abS = bVar;
        this.lo.p(true);
        if (this.abS != null) {
            this.abS.a(new android.support.v4.view.b.b() {
                public final void en() {
                    j.this.lo.gz();
                }
            });
        }
        return this;
    }

    public final boolean expandActionView() {
        if (!gN()) {
            return false;
        }
        if (this.abT == null || this.abT.onMenuItemActionExpand(this)) {
            return this.lo.g(this);
        }
        return false;
    }

    public final boolean collapseActionView() {
        if ((this.abQ & 8) == 0) {
            return false;
        }
        if (this.abR == null) {
            return true;
        }
        if (this.abT == null || this.abT.onMenuItemActionCollapse(this)) {
            return this.lo.h(this);
        }
        return false;
    }

    public final boolean gN() {
        if ((this.abQ & 8) == 0) {
            return false;
        }
        if (this.abR == null && this.abS != null) {
            this.abR = this.abS.onCreateActionView(this);
        }
        if (this.abR != null) {
            return true;
        }
        return false;
    }

    public final void Z(boolean z) {
        this.abU = z;
        this.lo.p(false);
    }

    public final boolean isActionViewExpanded() {
        return this.abU;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.abT = onActionExpandListener;
        return this;
    }

    /* renamed from: i */
    public final b setContentDescription(CharSequence charSequence) {
        this.ZX = charSequence;
        this.lo.p(false);
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.ZX;
    }

    /* renamed from: j */
    public final b setTooltipText(CharSequence charSequence) {
        this.ZY = charSequence;
        this.lo.p(false);
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.ZY;
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }
}
