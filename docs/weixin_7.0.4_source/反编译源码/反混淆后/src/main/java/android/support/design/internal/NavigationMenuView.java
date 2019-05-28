package android.support.design.internal;

import android.content.Context;
import android.support.p069v7.view.menu.C0630p;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.util.AttributeSet;

public class NavigationMenuView extends RecyclerView implements C0630p {
    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(1));
    }

    /* renamed from: a */
    public final void mo1612a(C6236h c6236h) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}
