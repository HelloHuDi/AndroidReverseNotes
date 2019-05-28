package android.support.p069v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.view.b */
public abstract class C0604b {
    /* renamed from: YM */
    boolean f940YM;
    /* renamed from: sO */
    Object f941sO;

    /* renamed from: android.support.v7.view.b$a */
    public interface C0603a {
        /* renamed from: a */
        void mo1484a(C0604b c0604b);

        /* renamed from: a */
        boolean mo1485a(C0604b c0604b, Menu menu);

        /* renamed from: a */
        boolean mo1486a(C0604b c0604b, MenuItem menuItem);

        /* renamed from: b */
        boolean mo1487b(C0604b c0604b, Menu menu);
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public abstract CharSequence getTitle();

    public abstract void invalidate();

    public abstract void setCustomView(View view);

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charSequence);

    public abstract void setTitle(int i);

    public abstract void setTitle(CharSequence charSequence);

    public void setTitleOptionalHint(boolean z) {
        this.f940YM = z;
    }

    public boolean isTitleOptional() {
        return false;
    }
}
