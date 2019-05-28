package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.w;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o.a;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;

public interface x {
    void a(a aVar, h.a aVar2);

    void a(au auVar);

    void a(Menu menu, a aVar);

    w c(int i, long j);

    void collapseActionView();

    void dismissPopupMenus();

    boolean gV();

    boolean gW();

    void gX();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getTitle();

    int getVisibility();

    ViewGroup hW();

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
