package android.support.p057v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.p057v4.p060b.p061a.C0369b;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;

/* renamed from: android.support.v4.view.g */
public final class C0464g {
    /* renamed from: Ml */
    static final C0462c f559Ml;

    /* renamed from: android.support.v4.view.g$c */
    interface C0462c {
        /* renamed from: a */
        void mo1056a(MenuItem menuItem, char c, int i);

        /* renamed from: a */
        void mo1057a(MenuItem menuItem, ColorStateList colorStateList);

        /* renamed from: a */
        void mo1058a(MenuItem menuItem, Mode mode);

        /* renamed from: a */
        void mo1059a(MenuItem menuItem, CharSequence charSequence);

        /* renamed from: b */
        void mo1060b(MenuItem menuItem, char c, int i);

        /* renamed from: b */
        void mo1061b(MenuItem menuItem, CharSequence charSequence);
    }

    @Deprecated
    /* renamed from: android.support.v4.view.g$d */
    public interface C0463d {
        /* renamed from: eo */
        boolean mo1062eo();

        /* renamed from: ep */
        boolean mo1063ep();
    }

    /* renamed from: android.support.v4.view.g$b */
    static class C0465b implements C0462c {
        C0465b() {
        }

        /* renamed from: a */
        public void mo1059a(MenuItem menuItem, CharSequence charSequence) {
        }

        /* renamed from: b */
        public void mo1061b(MenuItem menuItem, CharSequence charSequence) {
        }

        /* renamed from: b */
        public void mo1060b(MenuItem menuItem, char c, int i) {
        }

        /* renamed from: a */
        public void mo1056a(MenuItem menuItem, char c, int i) {
        }

        /* renamed from: a */
        public void mo1057a(MenuItem menuItem, ColorStateList colorStateList) {
        }

        /* renamed from: a */
        public void mo1058a(MenuItem menuItem, Mode mode) {
        }
    }

    /* renamed from: android.support.v4.view.g$a */
    static class C0466a extends C0465b {
        C0466a() {
        }

        /* renamed from: a */
        public final void mo1059a(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        /* renamed from: b */
        public final void mo1061b(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }

        /* renamed from: b */
        public final void mo1060b(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        /* renamed from: a */
        public final void mo1056a(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        /* renamed from: a */
        public final void mo1057a(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        /* renamed from: a */
        public final void mo1058a(MenuItem menuItem, Mode mode) {
            menuItem.setIconTintMode(mode);
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f559Ml = new C0466a();
        } else {
            f559Ml = new C0465b();
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m806a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    @Deprecated
    /* renamed from: a */
    public static MenuItem m803a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    @Deprecated
    /* renamed from: a */
    public static View m804a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    /* renamed from: a */
    public static MenuItem m801a(MenuItem menuItem, C0455b c0455b) {
        if (menuItem instanceof C0369b) {
            return ((C0369b) menuItem).mo637a(c0455b);
        }
        return menuItem;
    }

    @Deprecated
    /* renamed from: b */
    public static boolean m812b(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    @Deprecated
    /* renamed from: c */
    public static boolean m813c(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    /* renamed from: a */
    public static MenuItem m802a(MenuItem menuItem, final C0463d c0463d) {
        return menuItem.setOnActionExpandListener(new OnActionExpandListener() {
            public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                return c0463d.mo1062eo();
            }

            public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return c0463d.mo1063ep();
            }
        });
    }

    /* renamed from: a */
    public static void m809a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0369b) {
            ((C0369b) menuItem).mo648i(charSequence);
        } else {
            f559Ml.mo1059a(menuItem, charSequence);
        }
    }

    /* renamed from: b */
    public static void m811b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0369b) {
            ((C0369b) menuItem).mo650j(charSequence);
        } else {
            f559Ml.mo1061b(menuItem, charSequence);
        }
    }

    /* renamed from: a */
    public static void m805a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0369b) {
            ((C0369b) menuItem).setNumericShortcut(c, i);
        } else {
            f559Ml.mo1056a(menuItem, c, i);
        }
    }

    /* renamed from: b */
    public static void m810b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0369b) {
            ((C0369b) menuItem).setAlphabeticShortcut(c, i);
        } else {
            f559Ml.mo1060b(menuItem, c, i);
        }
    }

    /* renamed from: a */
    public static void m807a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof C0369b) {
            ((C0369b) menuItem).setIconTintList(colorStateList);
        } else {
            f559Ml.mo1057a(menuItem, colorStateList);
        }
    }

    /* renamed from: a */
    public static void m808a(MenuItem menuItem, Mode mode) {
        if (menuItem instanceof C0369b) {
            ((C0369b) menuItem).setIconTintMode(mode);
        } else {
            f559Ml.mo1058a(menuItem, mode);
        }
    }
}
