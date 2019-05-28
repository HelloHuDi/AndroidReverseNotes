package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;

public final class g {
    static final c Ml;

    interface c {
        void a(MenuItem menuItem, char c, int i);

        void a(MenuItem menuItem, ColorStateList colorStateList);

        void a(MenuItem menuItem, Mode mode);

        void a(MenuItem menuItem, CharSequence charSequence);

        void b(MenuItem menuItem, char c, int i);

        void b(MenuItem menuItem, CharSequence charSequence);
    }

    @Deprecated
    public interface d {
        boolean eo();

        boolean ep();
    }

    static class b implements c {
        b() {
        }

        public void a(MenuItem menuItem, CharSequence charSequence) {
        }

        public void b(MenuItem menuItem, CharSequence charSequence) {
        }

        public void b(MenuItem menuItem, char c, int i) {
        }

        public void a(MenuItem menuItem, char c, int i) {
        }

        public void a(MenuItem menuItem, ColorStateList colorStateList) {
        }

        public void a(MenuItem menuItem, Mode mode) {
        }
    }

    static class a extends b {
        a() {
        }

        public final void a(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        public final void b(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }

        public final void b(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        public final void a(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        public final void a(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        public final void a(MenuItem menuItem, Mode mode) {
            menuItem.setIconTintMode(mode);
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            Ml = new a();
        } else {
            Ml = new b();
        }
    }

    @Deprecated
    public static void a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    @Deprecated
    public static MenuItem a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    @Deprecated
    public static View a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static MenuItem a(MenuItem menuItem, b bVar) {
        if (menuItem instanceof android.support.v4.b.a.b) {
            return ((android.support.v4.b.a.b) menuItem).a(bVar);
        }
        return menuItem;
    }

    @Deprecated
    public static boolean b(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    @Deprecated
    public static boolean c(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static MenuItem a(MenuItem menuItem, final d dVar) {
        return menuItem.setOnActionExpandListener(new OnActionExpandListener() {
            public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                return dVar.eo();
            }

            public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return dVar.ep();
            }
        });
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof android.support.v4.b.a.b) {
            ((android.support.v4.b.a.b) menuItem).i(charSequence);
        } else {
            Ml.a(menuItem, charSequence);
        }
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof android.support.v4.b.a.b) {
            ((android.support.v4.b.a.b) menuItem).j(charSequence);
        } else {
            Ml.b(menuItem, charSequence);
        }
    }

    public static void a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof android.support.v4.b.a.b) {
            ((android.support.v4.b.a.b) menuItem).setNumericShortcut(c, i);
        } else {
            Ml.a(menuItem, c, i);
        }
    }

    public static void b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof android.support.v4.b.a.b) {
            ((android.support.v4.b.a.b) menuItem).setAlphabeticShortcut(c, i);
        } else {
            Ml.b(menuItem, c, i);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof android.support.v4.b.a.b) {
            ((android.support.v4.b.a.b) menuItem).setIconTintList(colorStateList);
        } else {
            Ml.a(menuItem, colorStateList);
        }
    }

    public static void a(MenuItem menuItem, Mode mode) {
        if (menuItem instanceof android.support.v4.b.a.b) {
            ((android.support.v4.b.a.b) menuItem).setIconTintMode(mode);
        } else {
            Ml.a(menuItem, mode);
        }
    }
}
