package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.b.b;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

final class l extends k {

    class a extends a implements VisibilityListener {
        b acf;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public final View onCreateActionView(MenuItem menuItem) {
            return this.acc.onCreateActionView(menuItem);
        }

        public final boolean overridesItemVisibility() {
            return this.acc.overridesItemVisibility();
        }

        public final boolean isVisible() {
            return this.acc.isVisible();
        }

        public final void a(b bVar) {
            this.acf = bVar;
            this.acc.setVisibilityListener(this);
        }

        public final void onActionProviderVisibilityChanged(boolean z) {
            if (this.acf != null) {
                this.acf.en();
            }
        }
    }

    l(Context context, android.support.v4.b.a.b bVar) {
        super(context, bVar);
    }

    /* Access modifiers changed, original: final */
    public final a a(ActionProvider actionProvider) {
        return new a(this.mContext, actionProvider);
    }
}
