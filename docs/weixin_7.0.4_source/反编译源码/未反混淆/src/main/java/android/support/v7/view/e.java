package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class e extends b implements a {
    private ActionBarContextView WK;
    private b.a Xi;
    private WeakReference<View> Xj;
    private boolean YP;
    private h lo;
    private Context mContext;
    private boolean mFinished;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.mContext = context;
        this.WK = actionBarContextView;
        this.Xi = aVar;
        h hVar = new h(actionBarContextView.getContext());
        this.lo = hVar;
        this.lo.a((a) this);
        this.YP = z;
    }

    public final void setTitle(CharSequence charSequence) {
        this.WK.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.WK.setSubtitle(charSequence);
    }

    public final void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public final void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public final void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.WK.setTitleOptional(z);
    }

    public final boolean isTitleOptional() {
        return this.WK.acR;
    }

    public final void setCustomView(View view) {
        this.WK.setCustomView(view);
        this.Xj = view != null ? new WeakReference(view) : null;
    }

    public final void invalidate() {
        this.Xi.b(this, this.lo);
    }

    public final void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.WK.sendAccessibilityEvent(32);
            this.Xi.a(this);
        }
    }

    public final Menu getMenu() {
        return this.lo;
    }

    public final CharSequence getTitle() {
        return this.WK.getTitle();
    }

    public final CharSequence getSubtitle() {
        return this.WK.getSubtitle();
    }

    public final View getCustomView() {
        return this.Xj != null ? (View) this.Xj.get() : null;
    }

    public final MenuInflater getMenuInflater() {
        return new g(this.WK.getContext());
    }

    public final boolean a(h hVar, MenuItem menuItem) {
        return this.Xi.a((b) this, menuItem);
    }

    public final void b(h hVar) {
        invalidate();
        this.WK.showOverflowMenu();
    }
}
