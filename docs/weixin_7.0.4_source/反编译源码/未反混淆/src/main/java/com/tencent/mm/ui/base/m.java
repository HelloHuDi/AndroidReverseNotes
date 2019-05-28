package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m implements MenuItem {
    private int Zb;
    private int Zi;
    public String hAh;
    private int iconId;
    private Intent intent;
    private Context mContext;
    public CharSequence mKB = null;
    private CharSequence title;
    public boolean xeS = false;
    private int yvU;
    private Drawable yvV;
    public ContextMenuInfo yvW;
    private OnMenuItemClickListener yvX;

    public m(Context context, int i, int i2) {
        this.mContext = context;
        this.Zi = i;
        this.Zb = i2;
    }

    public final int getItemId() {
        return this.Zi;
    }

    public final int getGroupId() {
        return this.Zb;
    }

    public final int getOrder() {
        return 0;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.title = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.yvU = i;
        return this;
    }

    public final CharSequence getTitle() {
        AppMethodBeat.i(112555);
        if (this.title != null) {
            CharSequence charSequence = this.title;
            AppMethodBeat.o(112555);
            return charSequence;
        } else if (this.yvU == 0 || this.mContext == null) {
            AppMethodBeat.o(112555);
            return null;
        } else {
            String string = this.mContext.getString(this.yvU);
            AppMethodBeat.o(112555);
            return string;
        }
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        return this;
    }

    public final CharSequence getTitleCondensed() {
        return null;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.yvV = drawable;
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.iconId = i;
        return this;
    }

    public final Drawable getIcon() {
        AppMethodBeat.i(112556);
        Drawable drawable;
        if (this.yvV != null) {
            drawable = this.yvV;
            AppMethodBeat.o(112556);
            return drawable;
        } else if (this.iconId == 0 || this.mContext == null) {
            AppMethodBeat.o(112556);
            return null;
        } else {
            drawable = this.mContext.getResources().getDrawable(this.iconId);
            AppMethodBeat.o(112556);
            return drawable;
        }
    }

    public final MenuItem setIntent(Intent intent) {
        this.intent = intent;
        return this;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final MenuItem setShortcut(char c, char c2) {
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        return this;
    }

    public final char getNumericShortcut() {
        return 0;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        return this;
    }

    public final char getAlphabeticShortcut() {
        return 0;
    }

    public final MenuItem setCheckable(boolean z) {
        return this;
    }

    public final boolean isCheckable() {
        return false;
    }

    public final MenuItem setChecked(boolean z) {
        return this;
    }

    public final boolean isChecked() {
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        return this;
    }

    public final boolean isVisible() {
        return true;
    }

    public final MenuItem setEnabled(boolean z) {
        return this;
    }

    public final boolean isEnabled() {
        return true;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.yvX = onMenuItemClickListener;
        return this;
    }

    public final boolean performClick() {
        AppMethodBeat.i(112557);
        if (this.yvX != null) {
            boolean onMenuItemClick = this.yvX.onMenuItemClick(this);
            AppMethodBeat.o(112557);
            return onMenuItemClick;
        }
        AppMethodBeat.o(112557);
        return false;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.yvW;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean expandActionView() {
        return false;
    }

    public final ActionProvider getActionProvider() {
        return null;
    }

    public final View getActionView() {
        return null;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        return null;
    }

    public final MenuItem setActionView(View view) {
        return null;
    }

    public final MenuItem setActionView(int i) {
        return null;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        return null;
    }

    public final void setShowAsAction(int i) {
    }

    public final MenuItem setShowAsActionFlags(int i) {
        return null;
    }
}
