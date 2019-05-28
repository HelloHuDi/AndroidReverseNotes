package android.support.p057v4.p060b.p061a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.p057v4.view.C0455b;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.b.a.b */
public interface C0369b extends MenuItem {
    /* renamed from: a */
    C0369b mo637a(C0455b c0455b);

    boolean collapseActionView();

    /* renamed from: dG */
    C0455b mo639dG();

    boolean expandActionView();

    View getActionView();

    int getAlphabeticModifiers();

    CharSequence getContentDescription();

    ColorStateList getIconTintList();

    Mode getIconTintMode();

    int getNumericModifiers();

    CharSequence getTooltipText();

    /* renamed from: i */
    C0369b mo648i(CharSequence charSequence);

    boolean isActionViewExpanded();

    /* renamed from: j */
    C0369b mo650j(CharSequence charSequence);

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    MenuItem setAlphabeticShortcut(char c, int i);

    MenuItem setIconTintList(ColorStateList colorStateList);

    MenuItem setIconTintMode(Mode mode);

    MenuItem setNumericShortcut(char c, int i);

    MenuItem setShortcut(char c, char c2, int i, int i2);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
