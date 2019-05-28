package android.support.p069v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.p060b.p061a.C0369b;
import android.support.p057v4.view.C0455b;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.a */
public final class C6231a implements C0369b {
    /* renamed from: Dj */
    private int f1889Dj = 16;
    /* renamed from: IT */
    private CharSequence f1890IT;
    /* renamed from: ZM */
    private final int f1891ZM;
    /* renamed from: ZN */
    private final int f1892ZN;
    /* renamed from: ZO */
    private final int f1893ZO;
    /* renamed from: ZP */
    private CharSequence f1894ZP;
    /* renamed from: ZQ */
    private char f1895ZQ;
    /* renamed from: ZR */
    private int f1896ZR = 4096;
    /* renamed from: ZS */
    private char f1897ZS;
    /* renamed from: ZT */
    private int f1898ZT = 4096;
    /* renamed from: ZU */
    private Drawable f1899ZU;
    /* renamed from: ZV */
    private int f1900ZV = 0;
    /* renamed from: ZW */
    private OnMenuItemClickListener f1901ZW;
    /* renamed from: ZX */
    private CharSequence f1902ZX;
    /* renamed from: ZY */
    private CharSequence f1903ZY;
    /* renamed from: ZZ */
    private Mode f1904ZZ = null;
    private boolean aaa = false;
    private boolean aab = false;
    /* renamed from: lE */
    private ColorStateList f1905lE = null;
    private Context mContext;
    private final int mId;
    private Intent mIntent;

    public C6231a(Context context, CharSequence charSequence) {
        this.mContext = context;
        this.mId = 16908332;
        this.f1891ZM = 0;
        this.f1892ZN = 0;
        this.f1893ZO = 0;
        this.f1890IT = charSequence;
    }

    public final char getAlphabeticShortcut() {
        return this.f1897ZS;
    }

    public final int getAlphabeticModifiers() {
        return this.f1898ZT;
    }

    public final int getGroupId() {
        return this.f1891ZM;
    }

    public final Drawable getIcon() {
        return this.f1899ZU;
    }

    public final Intent getIntent() {
        return this.mIntent;
    }

    public final int getItemId() {
        return this.mId;
    }

    public final ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final char getNumericShortcut() {
        return this.f1895ZQ;
    }

    public final int getNumericModifiers() {
        return this.f1896ZR;
    }

    public final int getOrder() {
        return this.f1893ZO;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final CharSequence getTitle() {
        return this.f1890IT;
    }

    public final CharSequence getTitleCondensed() {
        return this.f1894ZP != null ? this.f1894ZP : this.f1890IT;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isCheckable() {
        return (this.f1889Dj & 1) != 0;
    }

    public final boolean isChecked() {
        return (this.f1889Dj & 2) != 0;
    }

    public final boolean isEnabled() {
        return (this.f1889Dj & 16) != 0;
    }

    public final boolean isVisible() {
        return (this.f1889Dj & 8) == 0;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        this.f1897ZS = Character.toLowerCase(c);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c, int i) {
        this.f1897ZS = Character.toLowerCase(c);
        this.f1898ZT = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.f1889Dj = (z ? 1 : 0) | (this.f1889Dj & -2);
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        this.f1889Dj = (z ? 2 : 0) | (this.f1889Dj & -3);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.f1889Dj = (z ? 16 : 0) | (this.f1889Dj & -17);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.f1899ZU = drawable;
        this.f1900ZV = 0;
        m10051gh();
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.f1900ZV = i;
        this.f1899ZU = C0380b.m649g(this.mContext, i);
        m10051gh();
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        this.f1895ZQ = c;
        return this;
    }

    public final MenuItem setNumericShortcut(char c, int i) {
        this.f1895ZQ = c;
        this.f1896ZR = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1901ZW = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.f1895ZQ = c;
        this.f1897ZS = Character.toLowerCase(c2);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1895ZQ = c;
        this.f1896ZR = KeyEvent.normalizeMetaState(i);
        this.f1897ZS = Character.toLowerCase(c2);
        this.f1898ZT = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f1890IT = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.f1890IT = this.mContext.getResources().getString(i);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1894ZP = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        this.f1889Dj = (z ? 0 : 8) | (this.f1889Dj & 8);
        return this;
    }

    public final void setShowAsAction(int i) {
    }

    public final View getActionView() {
        return null;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: dG */
    public final C0455b mo639dG() {
        return null;
    }

    /* renamed from: a */
    public final C0369b mo637a(C0455b c0455b) {
        throw new UnsupportedOperationException();
    }

    public final boolean expandActionView() {
        return false;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: i */
    public final C0369b mo648i(CharSequence charSequence) {
        this.f1902ZX = charSequence;
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.f1902ZX;
    }

    /* renamed from: j */
    public final C0369b mo650j(CharSequence charSequence) {
        this.f1903ZY = charSequence;
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.f1903ZY;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1905lE = colorStateList;
        this.aaa = true;
        m10051gh();
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.f1905lE;
    }

    public final MenuItem setIconTintMode(Mode mode) {
        this.f1904ZZ = mode;
        this.aab = true;
        m10051gh();
        return this;
    }

    public final Mode getIconTintMode() {
        return this.f1904ZZ;
    }

    /* renamed from: gh */
    private void m10051gh() {
        if (this.f1899ZU == null) {
            return;
        }
        if (this.aaa || this.aab) {
            this.f1899ZU = C0280a.m467f(this.f1899ZU);
            this.f1899ZU = this.f1899ZU.mutate();
            if (this.aaa) {
                C0280a.m457a(this.f1899ZU, this.f1905lE);
            }
            if (this.aab) {
                C0280a.m460a(this.f1899ZU, this.f1904ZZ);
            }
        }
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        this.f1903ZY = charSequence;
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        this.f1902ZX = charSequence;
        return this;
    }
}
