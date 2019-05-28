package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.b;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class a implements b {
    private int Dj = 16;
    private CharSequence IT;
    private final int ZM;
    private final int ZN;
    private final int ZO;
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
    private ColorStateList lE = null;
    private Context mContext;
    private final int mId;
    private Intent mIntent;

    public a(Context context, CharSequence charSequence) {
        this.mContext = context;
        this.mId = 16908332;
        this.ZM = 0;
        this.ZN = 0;
        this.ZO = 0;
        this.IT = charSequence;
    }

    public final char getAlphabeticShortcut() {
        return this.ZS;
    }

    public final int getAlphabeticModifiers() {
        return this.ZT;
    }

    public final int getGroupId() {
        return this.ZM;
    }

    public final Drawable getIcon() {
        return this.ZU;
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
        return this.ZQ;
    }

    public final int getNumericModifiers() {
        return this.ZR;
    }

    public final int getOrder() {
        return this.ZO;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final CharSequence getTitle() {
        return this.IT;
    }

    public final CharSequence getTitleCondensed() {
        return this.ZP != null ? this.ZP : this.IT;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isCheckable() {
        return (this.Dj & 1) != 0;
    }

    public final boolean isChecked() {
        return (this.Dj & 2) != 0;
    }

    public final boolean isEnabled() {
        return (this.Dj & 16) != 0;
    }

    public final boolean isVisible() {
        return (this.Dj & 8) == 0;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        this.ZS = Character.toLowerCase(c);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c, int i) {
        this.ZS = Character.toLowerCase(c);
        this.ZT = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.Dj = (z ? 1 : 0) | (this.Dj & -2);
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        this.Dj = (z ? 2 : 0) | (this.Dj & -3);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.Dj = (z ? 16 : 0) | (this.Dj & -17);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.ZU = drawable;
        this.ZV = 0;
        gh();
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.ZV = i;
        this.ZU = android.support.v4.content.b.g(this.mContext, i);
        gh();
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        this.ZQ = c;
        return this;
    }

    public final MenuItem setNumericShortcut(char c, int i) {
        this.ZQ = c;
        this.ZR = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.ZW = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.ZQ = c;
        this.ZS = Character.toLowerCase(c2);
        return this;
    }

    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.ZQ = c;
        this.ZR = KeyEvent.normalizeMetaState(i);
        this.ZS = Character.toLowerCase(c2);
        this.ZT = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.IT = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.IT = this.mContext.getResources().getString(i);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.ZP = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        this.Dj = (z ? 0 : 8) | (this.Dj & 8);
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

    public final android.support.v4.view.b dG() {
        return null;
    }

    public final b a(android.support.v4.view.b bVar) {
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

    public final b i(CharSequence charSequence) {
        this.ZX = charSequence;
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.ZX;
    }

    public final b j(CharSequence charSequence) {
        this.ZY = charSequence;
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.ZY;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.lE = colorStateList;
        this.aaa = true;
        gh();
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.lE;
    }

    public final MenuItem setIconTintMode(Mode mode) {
        this.ZZ = mode;
        this.aab = true;
        gh();
        return this;
    }

    public final Mode getIconTintMode() {
        return this.ZZ;
    }

    private void gh() {
        if (this.ZU == null) {
            return;
        }
        if (this.aaa || this.aab) {
            this.ZU = android.support.v4.a.a.a.f(this.ZU);
            this.ZU = this.ZU.mutate();
            if (this.aaa) {
                android.support.v4.a.a.a.a(this.ZU, this.lE);
            }
            if (this.aab) {
                android.support.v4.a.a.a.a(this.ZU, this.ZZ);
            }
        }
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        this.ZY = charSequence;
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        this.ZX = charSequence;
        return this;
    }
}
