package android.support.p069v7.view;

import android.content.Context;
import android.support.p069v7.view.C0604b.C0603a;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.support.p069v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.view.e */
public final class C6229e extends C0604b implements C0623a {
    /* renamed from: WK */
    private ActionBarContextView f1879WK;
    /* renamed from: Xi */
    private C0603a f1880Xi;
    /* renamed from: Xj */
    private WeakReference<View> f1881Xj;
    /* renamed from: YP */
    private boolean f1882YP;
    /* renamed from: lo */
    private C6236h f1883lo;
    private Context mContext;
    private boolean mFinished;

    public C6229e(Context context, ActionBarContextView actionBarContextView, C0603a c0603a, boolean z) {
        this.mContext = context;
        this.f1879WK = actionBarContextView;
        this.f1880Xi = c0603a;
        C6236h c6236h = new C6236h(actionBarContextView.getContext());
        this.f1883lo = c6236h;
        this.f1883lo.mo14113a((C0623a) this);
        this.f1882YP = z;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f1879WK.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.f1879WK.setSubtitle(charSequence);
    }

    public final void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public final void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public final void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.f1879WK.setTitleOptional(z);
    }

    public final boolean isTitleOptional() {
        return this.f1879WK.acR;
    }

    public final void setCustomView(View view) {
        this.f1879WK.setCustomView(view);
        this.f1881Xj = view != null ? new WeakReference(view) : null;
    }

    public final void invalidate() {
        this.f1880Xi.mo1487b(this, this.f1883lo);
    }

    public final void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.f1879WK.sendAccessibilityEvent(32);
            this.f1880Xi.mo1484a(this);
        }
    }

    public final Menu getMenu() {
        return this.f1883lo;
    }

    public final CharSequence getTitle() {
        return this.f1879WK.getTitle();
    }

    public final CharSequence getSubtitle() {
        return this.f1879WK.getSubtitle();
    }

    public final View getCustomView() {
        return this.f1881Xj != null ? (View) this.f1881Xj.get() : null;
    }

    public final MenuInflater getMenuInflater() {
        return new C0611g(this.f1879WK.getContext());
    }

    /* renamed from: a */
    public final boolean mo1584a(C6236h c6236h, MenuItem menuItem) {
        return this.f1880Xi.mo1486a((C0604b) this, menuItem);
    }

    /* renamed from: b */
    public final void mo1585b(C6236h c6236h) {
        invalidate();
        this.f1879WK.showOverflowMenu();
    }
}
