package android.support.p069v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0497w;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;

/* renamed from: android.support.v7.widget.x */
public interface C0728x {
    /* renamed from: a */
    void mo2142a(C0627a c0627a, C0623a c0623a);

    /* renamed from: a */
    void mo2143a(C0695au c0695au);

    /* renamed from: a */
    void mo2144a(Menu menu, C0627a c0627a);

    /* renamed from: c */
    C0497w mo2145c(int i, long j);

    void collapseActionView();

    void dismissPopupMenus();

    /* renamed from: gV */
    boolean mo2148gV();

    /* renamed from: gW */
    boolean mo2149gW();

    /* renamed from: gX */
    void mo2150gX();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getTitle();

    int getVisibility();

    /* renamed from: hW */
    ViewGroup mo2159hW();

    boolean hasExpandedActionView();

    boolean hideOverflowMenu();

    boolean isOverflowMenuShowing();

    void setBackgroundDrawable(Drawable drawable);

    void setCollapsible(boolean z);

    void setCustomView(View view);

    void setDisplayOptions(int i);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setLogo(int i);

    void setLogo(Drawable drawable);

    void setNavigationContentDescription(int i);

    void setVisibility(int i);

    void setWindowCallback(Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}
