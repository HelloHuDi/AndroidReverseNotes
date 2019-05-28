package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class k extends c<android.support.v4.b.a.b> implements MenuItem {
    public Method acb;

    class a extends android.support.v4.view.b {
        final ActionProvider acc;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.acc = actionProvider;
        }

        public final View onCreateActionView() {
            return this.acc.onCreateActionView();
        }

        public final boolean onPerformDefaultAction() {
            return this.acc.onPerformDefaultAction();
        }

        public final boolean hasSubMenu() {
            return this.acc.hasSubMenu();
        }

        public final void onPrepareSubMenu(SubMenu subMenu) {
            this.acc.onPrepareSubMenu(k.this.a(subMenu));
        }
    }

    static class b extends FrameLayout implements android.support.v7.view.c {
        final CollapsibleActionView ace;

        b(View view) {
            super(view.getContext());
            this.ace = (CollapsibleActionView) view;
            addView(view);
        }

        public final void onActionViewExpanded() {
            this.ace.onActionViewExpanded();
        }

        public final void onActionViewCollapsed() {
            this.ace.onActionViewCollapsed();
        }
    }

    class c extends d<OnActionExpandListener> implements OnActionExpandListener {
        c(OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.aar).onMenuItemActionExpand(k.this.e(menuItem));
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.aar).onMenuItemActionCollapse(k.this.e(menuItem));
        }
    }

    class d extends d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        d(OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.aar).onMenuItemClick(k.this.e(menuItem));
        }
    }

    k(Context context, android.support.v4.b.a.b bVar) {
        super(context, bVar);
    }

    public int getItemId() {
        return ((android.support.v4.b.a.b) this.aar).getItemId();
    }

    public int getGroupId() {
        return ((android.support.v4.b.a.b) this.aar).getGroupId();
    }

    public int getOrder() {
        return ((android.support.v4.b.a.b) this.aar).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((android.support.v4.b.a.b) this.aar).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((android.support.v4.b.a.b) this.aar).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((android.support.v4.b.a.b) this.aar).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((android.support.v4.b.a.b) this.aar).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((android.support.v4.b.a.b) this.aar).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((android.support.v4.b.a.b) this.aar).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((android.support.v4.b.a.b) this.aar).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((android.support.v4.b.a.b) this.aar).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((android.support.v4.b.a.b) this.aar).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((android.support.v4.b.a.b) this.aar).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((android.support.v4.b.a.b) this.aar).setShortcut(c, c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        ((android.support.v4.b.a.b) this.aar).setShortcut(c, c2, i, i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((android.support.v4.b.a.b) this.aar).setNumericShortcut(c);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        ((android.support.v4.b.a.b) this.aar).setNumericShortcut(c, i);
        return this;
    }

    public char getNumericShortcut() {
        return ((android.support.v4.b.a.b) this.aar).getNumericShortcut();
    }

    public int getNumericModifiers() {
        return ((android.support.v4.b.a.b) this.aar).getNumericModifiers();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((android.support.v4.b.a.b) this.aar).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        ((android.support.v4.b.a.b) this.aar).setAlphabeticShortcut(c, i);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((android.support.v4.b.a.b) this.aar).getAlphabeticShortcut();
    }

    public int getAlphabeticModifiers() {
        return ((android.support.v4.b.a.b) this.aar).getAlphabeticModifiers();
    }

    public MenuItem setCheckable(boolean z) {
        ((android.support.v4.b.a.b) this.aar).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((android.support.v4.b.a.b) this.aar).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((android.support.v4.b.a.b) this.aar).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((android.support.v4.b.a.b) this.aar).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((android.support.v4.b.a.b) this.aar).setVisible(z);
    }

    public boolean isVisible() {
        return ((android.support.v4.b.a.b) this.aar).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((android.support.v4.b.a.b) this.aar).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((android.support.v4.b.a.b) this.aar).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((android.support.v4.b.a.b) this.aar).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(((android.support.v4.b.a.b) this.aar).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((android.support.v4.b.a.b) this.aar).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((android.support.v4.b.a.b) this.aar).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((android.support.v4.b.a.b) this.aar).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((android.support.v4.b.a.b) this.aar).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((android.support.v4.b.a.b) this.aar).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((android.support.v4.b.a.b) this.aar).setActionView(i);
        View actionView = ((android.support.v4.b.a.b) this.aar).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((android.support.v4.b.a.b) this.aar).setActionView(new b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((android.support.v4.b.a.b) this.aar).getActionView();
        return actionView instanceof b ? (View) ((b) actionView).ace : actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((android.support.v4.b.a.b) this.aar).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        android.support.v4.view.b dG = ((android.support.v4.b.a.b) this.aar).dG();
        if (dG instanceof a) {
            return ((a) dG).acc;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((android.support.v4.b.a.b) this.aar).expandActionView();
    }

    public boolean collapseActionView() {
        return ((android.support.v4.b.a.b) this.aar).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((android.support.v4.b.a.b) this.aar).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((android.support.v4.b.a.b) this.aar).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((android.support.v4.b.a.b) this.aar).i(charSequence);
        return this;
    }

    public CharSequence getContentDescription() {
        return ((android.support.v4.b.a.b) this.aar).getContentDescription();
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((android.support.v4.b.a.b) this.aar).j(charSequence);
        return this;
    }

    public CharSequence getTooltipText() {
        return ((android.support.v4.b.a.b) this.aar).getTooltipText();
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((android.support.v4.b.a.b) this.aar).setIconTintList(colorStateList);
        return this;
    }

    public ColorStateList getIconTintList() {
        return ((android.support.v4.b.a.b) this.aar).getIconTintList();
    }

    public MenuItem setIconTintMode(Mode mode) {
        ((android.support.v4.b.a.b) this.aar).setIconTintMode(mode);
        return this;
    }

    public Mode getIconTintMode() {
        return ((android.support.v4.b.a.b) this.aar).getIconTintMode();
    }

    /* Access modifiers changed, original: 0000 */
    public a a(ActionProvider actionProvider) {
        return new a(this.mContext, actionProvider);
    }
}
