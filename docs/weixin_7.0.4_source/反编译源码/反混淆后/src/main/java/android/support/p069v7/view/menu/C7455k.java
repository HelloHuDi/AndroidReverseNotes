package android.support.p069v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p057v4.p060b.p061a.C0369b;
import android.support.p057v4.view.C0455b;
import android.support.p069v7.view.C0605c;
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

/* renamed from: android.support.v7.view.menu.k */
public class C7455k extends C6233c<C0369b> implements MenuItem {
    public Method acb;

    /* renamed from: android.support.v7.view.menu.k$a */
    class C6240a extends C0455b {
        final ActionProvider acc;

        public C6240a(Context context, ActionProvider actionProvider) {
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
            this.acc.onPrepareSubMenu(C7455k.this.mo14105a(subMenu));
        }
    }

    /* renamed from: android.support.v7.view.menu.k$b */
    static class C6241b extends FrameLayout implements C0605c {
        final CollapsibleActionView ace;

        C6241b(View view) {
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

    /* renamed from: android.support.v7.view.menu.k$c */
    class C6242c extends C0616d<OnActionExpandListener> implements OnActionExpandListener {
        C6242c(OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.aar).onMenuItemActionExpand(C7455k.this.mo14106e(menuItem));
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.aar).onMenuItemActionCollapse(C7455k.this.mo14106e(menuItem));
        }
    }

    /* renamed from: android.support.v7.view.menu.k$d */
    class C6243d extends C0616d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        C6243d(OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.aar).onMenuItemClick(C7455k.this.mo14106e(menuItem));
        }
    }

    C7455k(Context context, C0369b c0369b) {
        super(context, c0369b);
    }

    public int getItemId() {
        return ((C0369b) this.aar).getItemId();
    }

    public int getGroupId() {
        return ((C0369b) this.aar).getGroupId();
    }

    public int getOrder() {
        return ((C0369b) this.aar).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0369b) this.aar).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0369b) this.aar).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((C0369b) this.aar).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0369b) this.aar).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((C0369b) this.aar).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0369b) this.aar).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0369b) this.aar).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((C0369b) this.aar).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((C0369b) this.aar).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((C0369b) this.aar).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0369b) this.aar).setShortcut(c, c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        ((C0369b) this.aar).setShortcut(c, c2, i, i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0369b) this.aar).setNumericShortcut(c);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        ((C0369b) this.aar).setNumericShortcut(c, i);
        return this;
    }

    public char getNumericShortcut() {
        return ((C0369b) this.aar).getNumericShortcut();
    }

    public int getNumericModifiers() {
        return ((C0369b) this.aar).getNumericModifiers();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0369b) this.aar).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        ((C0369b) this.aar).setAlphabeticShortcut(c, i);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((C0369b) this.aar).getAlphabeticShortcut();
    }

    public int getAlphabeticModifiers() {
        return ((C0369b) this.aar).getAlphabeticModifiers();
    }

    public MenuItem setCheckable(boolean z) {
        ((C0369b) this.aar).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((C0369b) this.aar).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((C0369b) this.aar).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((C0369b) this.aar).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((C0369b) this.aar).setVisible(z);
    }

    public boolean isVisible() {
        return ((C0369b) this.aar).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((C0369b) this.aar).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((C0369b) this.aar).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((C0369b) this.aar).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return mo14105a(((C0369b) this.aar).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0369b) this.aar).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C6243d(onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0369b) this.aar).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((C0369b) this.aar).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0369b) this.aar).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C6241b(view);
        }
        ((C0369b) this.aar).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0369b) this.aar).setActionView(i);
        View actionView = ((C0369b) this.aar).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0369b) this.aar).setActionView(new C6241b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((C0369b) this.aar).getActionView();
        return actionView instanceof C6241b ? (View) ((C6241b) actionView).ace : actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0369b) this.aar).mo637a(actionProvider != null ? mo16384a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        C0455b dG = ((C0369b) this.aar).mo639dG();
        if (dG instanceof C6240a) {
            return ((C6240a) dG).acc;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((C0369b) this.aar).expandActionView();
    }

    public boolean collapseActionView() {
        return ((C0369b) this.aar).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((C0369b) this.aar).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0369b) this.aar).setOnActionExpandListener(onActionExpandListener != null ? new C6242c(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((C0369b) this.aar).mo648i(charSequence);
        return this;
    }

    public CharSequence getContentDescription() {
        return ((C0369b) this.aar).getContentDescription();
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((C0369b) this.aar).mo650j(charSequence);
        return this;
    }

    public CharSequence getTooltipText() {
        return ((C0369b) this.aar).getTooltipText();
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((C0369b) this.aar).setIconTintList(colorStateList);
        return this;
    }

    public ColorStateList getIconTintList() {
        return ((C0369b) this.aar).getIconTintList();
    }

    public MenuItem setIconTintMode(Mode mode) {
        ((C0369b) this.aar).setIconTintMode(mode);
        return this;
    }

    public Mode getIconTintMode() {
        return ((C0369b) this.aar).getIconTintMode();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public C6240a mo16384a(ActionProvider actionProvider) {
        return new C6240a(this.mContext, actionProvider);
    }
}
