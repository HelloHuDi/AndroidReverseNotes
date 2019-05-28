package android.support.p069v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.p060b.p061a.C0369b;
import android.support.p057v4.view.C0455b;
import android.support.p057v4.view.C0455b.C0453b;
import android.support.p069v7.p071c.p072a.C0589b;
import android.support.p069v7.view.menu.C0630p.C0629a;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;

/* renamed from: android.support.v7.view.menu.j */
public final class C6239j implements C0369b {
    static String abW;
    static String abX;
    static String abY;
    static String abZ;
    /* renamed from: Dj */
    private int f1911Dj = 16;
    /* renamed from: IT */
    private CharSequence f1912IT;
    /* renamed from: ZM */
    private final int f1913ZM;
    /* renamed from: ZN */
    private final int f1914ZN;
    /* renamed from: ZO */
    final int f1915ZO;
    /* renamed from: ZP */
    private CharSequence f1916ZP;
    /* renamed from: ZQ */
    private char f1917ZQ;
    /* renamed from: ZR */
    private int f1918ZR = 4096;
    /* renamed from: ZS */
    private char f1919ZS;
    /* renamed from: ZT */
    private int f1920ZT = 4096;
    /* renamed from: ZU */
    private Drawable f1921ZU;
    /* renamed from: ZV */
    private int f1922ZV = 0;
    /* renamed from: ZW */
    private OnMenuItemClickListener f1923ZW;
    /* renamed from: ZX */
    private CharSequence f1924ZX;
    /* renamed from: ZY */
    private CharSequence f1925ZY;
    /* renamed from: ZZ */
    private Mode f1926ZZ = null;
    private boolean aaa = false;
    private boolean aab = false;
    private C7459u abN;
    private Runnable abO;
    private boolean abP = false;
    private int abQ = 0;
    private View abR;
    public C0455b abS;
    private OnActionExpandListener abT;
    private boolean abU = false;
    ContextMenuInfo abV;
    /* renamed from: lE */
    private ColorStateList f1927lE = null;
    /* renamed from: lo */
    C6236h f1928lo;
    private final int mId;
    private Intent mIntent;

    /* renamed from: android.support.v7.view.menu.j$1 */
    class C62381 implements C0453b {
        C62381() {
        }

        /* renamed from: en */
        public final void mo1042en() {
            C6239j.this.f1928lo.mo14148gz();
        }
    }

    C6239j(C6236h c6236h, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1928lo = c6236h;
        this.mId = i2;
        this.f1913ZM = i;
        this.f1914ZN = i3;
        this.f1915ZO = i4;
        this.f1912IT = charSequence;
        this.abQ = i5;
    }

    /* renamed from: gF */
    public final boolean mo14171gF() {
        if ((this.f1923ZW != null && this.f1923ZW.onMenuItemClick(this)) || this.f1928lo.mo14132d(this.f1928lo, this)) {
            return true;
        }
        if (this.abO != null) {
            this.abO.run();
            return true;
        }
        if (this.mIntent != null) {
            try {
                this.f1928lo.mContext.startActivity(this.mIntent);
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
        return (this.f1911Dj & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1911Dj |= 16;
        } else {
            this.f1911Dj &= -17;
        }
        this.f1928lo.mo14152p(false);
        return this;
    }

    public final int getGroupId() {
        return this.f1913ZM;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.mId;
    }

    public final int getOrder() {
        return this.f1914ZN;
    }

    public final Intent getIntent() {
        return this.mIntent;
    }

    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.f1919ZS;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.f1919ZS != c) {
            this.f1919ZS = Character.toLowerCase(c);
            this.f1928lo.mo14152p(false);
        }
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (!(this.f1919ZS == c && this.f1920ZT == i)) {
            this.f1919ZS = Character.toLowerCase(c);
            this.f1920ZT = KeyEvent.normalizeMetaState(i);
            this.f1928lo.mo14152p(false);
        }
        return this;
    }

    public final int getAlphabeticModifiers() {
        return this.f1920ZT;
    }

    public final char getNumericShortcut() {
        return this.f1917ZQ;
    }

    public final int getNumericModifiers() {
        return this.f1918ZR;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.f1917ZQ != c) {
            this.f1917ZQ = c;
            this.f1928lo.mo14152p(false);
        }
        return this;
    }

    public final MenuItem setNumericShortcut(char c, int i) {
        if (!(this.f1917ZQ == c && this.f1918ZR == i)) {
            this.f1917ZQ = c;
            this.f1918ZR = KeyEvent.normalizeMetaState(i);
            this.f1928lo.mo14152p(false);
        }
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.f1917ZQ = c;
        this.f1919ZS = Character.toLowerCase(c2);
        this.f1928lo.mo14152p(false);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1917ZQ = c;
        this.f1918ZR = KeyEvent.normalizeMetaState(i);
        this.f1919ZS = Character.toLowerCase(c2);
        this.f1920ZT = KeyEvent.normalizeMetaState(i2);
        this.f1928lo.mo14152p(false);
        return this;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: gG */
    public final char mo14172gG() {
        return this.f1928lo.mo14144gv() ? this.f1919ZS : this.f1917ZQ;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: gH */
    public final boolean mo14173gH() {
        return this.f1928lo.mo14145gw() && mo14172gG() != 0;
    }

    public final SubMenu getSubMenu() {
        return this.abN;
    }

    public final boolean hasSubMenu() {
        return this.abN != null;
    }

    /* renamed from: b */
    public final void mo14170b(C7459u c7459u) {
        this.abN = c7459u;
        c7459u.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.f1912IT;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final CharSequence mo14169a(C0629a c0629a) {
        if (c0629a.mo1610br()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f1912IT = charSequence;
        this.f1928lo.mo14152p(false);
        if (this.abN != null) {
            this.abN.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.f1928lo.mContext.getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1916ZP != null ? this.f1916ZP : this.f1912IT;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1916ZP = charSequence;
        this.f1928lo.mo14152p(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.f1921ZU != null) {
            return m10118i(this.f1921ZU);
        }
        if (this.f1922ZV == 0) {
            return null;
        }
        Drawable g = C0589b.m1275g(this.f1928lo.mContext, this.f1922ZV);
        this.f1922ZV = 0;
        this.f1921ZU = g;
        return m10118i(g);
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.f1922ZV = 0;
        this.f1921ZU = drawable;
        this.abP = true;
        this.f1928lo.mo14152p(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.f1921ZU = null;
        this.f1922ZV = i;
        this.abP = true;
        this.f1928lo.mo14152p(false);
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1927lE = colorStateList;
        this.aaa = true;
        this.abP = true;
        this.f1928lo.mo14152p(false);
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.f1927lE;
    }

    public final MenuItem setIconTintMode(Mode mode) {
        this.f1926ZZ = mode;
        this.aab = true;
        this.abP = true;
        this.f1928lo.mo14152p(false);
        return this;
    }

    public final Mode getIconTintMode() {
        return this.f1926ZZ;
    }

    /* renamed from: i */
    private Drawable m10118i(Drawable drawable) {
        if (drawable != null && this.abP && (this.aaa || this.aab)) {
            drawable = C0280a.m467f(drawable).mutate();
            if (this.aaa) {
                C0280a.m457a(drawable, this.f1927lE);
            }
            if (this.aab) {
                C0280a.m460a(drawable, this.f1926ZZ);
            }
            this.abP = false;
        }
        return drawable;
    }

    public final boolean isCheckable() {
        return (this.f1911Dj & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.f1911Dj;
        this.f1911Dj = (z ? 1 : 0) | (this.f1911Dj & -2);
        if (i != this.f1911Dj) {
            this.f1928lo.mo14152p(false);
        }
        return this;
    }

    /* renamed from: V */
    public final void mo14165V(boolean z) {
        this.f1911Dj = (z ? 4 : 0) | (this.f1911Dj & -5);
    }

    /* renamed from: gI */
    public final boolean mo14174gI() {
        return (this.f1911Dj & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.f1911Dj & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.f1911Dj & 4) != 0) {
            C6236h c6236h = this.f1928lo;
            int groupId = getGroupId();
            int size = c6236h.mItems.size();
            c6236h.mo14146gx();
            for (int i = 0; i < size; i++) {
                C6239j c6239j = (C6239j) c6236h.mItems.get(i);
                if (c6239j.getGroupId() == groupId && c6239j.mo14174gI() && c6239j.isCheckable()) {
                    c6239j.m10116W(c6239j == this);
                }
            }
            c6236h.mo14147gy();
        } else {
            m10116W(z);
        }
        return this;
    }

    /* renamed from: W */
    private void m10116W(boolean z) {
        int i;
        int i2 = this.f1911Dj;
        int i3 = this.f1911Dj & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f1911Dj = i | i3;
        if (i2 != this.f1911Dj) {
            this.f1928lo.mo14152p(false);
        }
    }

    public final boolean isVisible() {
        if (this.abS == null || !this.abS.overridesItemVisibility()) {
            if ((this.f1911Dj & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f1911Dj & 8) == 0 && this.abS.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: X */
    public final boolean mo14166X(boolean z) {
        int i = this.f1911Dj;
        this.f1911Dj = (z ? 0 : 8) | (this.f1911Dj & -9);
        if (i != this.f1911Dj) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (mo14166X(z)) {
            this.f1928lo.mo14148gz();
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1923ZW = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.f1912IT != null ? this.f1912IT.toString() : null;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.abV;
    }

    /* renamed from: gJ */
    public final boolean mo14175gJ() {
        return (this.f1911Dj & 32) == 32;
    }

    /* renamed from: gK */
    public final boolean mo14176gK() {
        return (this.abQ & 1) == 1;
    }

    /* renamed from: gL */
    public final boolean mo14177gL() {
        return (this.abQ & 2) == 2;
    }

    /* renamed from: Y */
    public final void mo14167Y(boolean z) {
        if (z) {
            this.f1911Dj |= 32;
        } else {
            this.f1911Dj &= -33;
        }
    }

    /* renamed from: gM */
    public final boolean mo14178gM() {
        return (this.abQ & 4) == 4;
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.abQ = i;
                this.f1928lo.mo14137gA();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    /* renamed from: aT */
    private C0369b m10117aT(View view) {
        this.abR = view;
        this.abS = null;
        if (view != null && view.getId() == -1 && this.mId > 0) {
            view.setId(this.mId);
        }
        this.f1928lo.mo14137gA();
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

    /* renamed from: dG */
    public final C0455b mo639dG() {
        return this.abS;
    }

    /* renamed from: a */
    public final C0369b mo637a(C0455b c0455b) {
        if (this.abS != null) {
            C0455b c0455b2 = this.abS;
            c0455b2.f554LH = null;
            c0455b2.f553LG = null;
        }
        this.abR = null;
        this.abS = c0455b;
        this.f1928lo.mo14152p(true);
        if (this.abS != null) {
            this.abS.mo1045a(new C62381());
        }
        return this;
    }

    public final boolean expandActionView() {
        if (!mo14179gN()) {
            return false;
        }
        if (this.abT == null || this.abT.onMenuItemActionExpand(this)) {
            return this.f1928lo.mo14136g(this);
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
            return this.f1928lo.mo14149h(this);
        }
        return false;
    }

    /* renamed from: gN */
    public final boolean mo14179gN() {
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

    /* renamed from: Z */
    public final void mo14168Z(boolean z) {
        this.abU = z;
        this.f1928lo.mo14152p(false);
    }

    public final boolean isActionViewExpanded() {
        return this.abU;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.abT = onActionExpandListener;
        return this;
    }

    /* renamed from: i */
    public final C0369b setContentDescription(CharSequence charSequence) {
        this.f1924ZX = charSequence;
        this.f1928lo.mo14152p(false);
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.f1924ZX;
    }

    /* renamed from: j */
    public final C0369b setTooltipText(CharSequence charSequence) {
        this.f1925ZY = charSequence;
        this.f1928lo.mo14152p(false);
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.f1925ZY;
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }
}
