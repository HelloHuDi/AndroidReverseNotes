package android.support.p069v7.view.menu;

import android.content.Context;
import android.support.p057v4.p060b.p061a.C0369b;
import android.support.p057v4.view.C0455b.C0453b;
import android.support.p069v7.view.menu.C7455k.C6240a;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.view.menu.l */
final class C7592l extends C7455k {

    /* renamed from: android.support.v7.view.menu.l$a */
    class C7456a extends C6240a implements VisibilityListener {
        C0453b acf;

        public C7456a(Context context, ActionProvider actionProvider) {
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

        /* renamed from: a */
        public final void mo1045a(C0453b c0453b) {
            this.acf = c0453b;
            this.acc.setVisibilityListener(this);
        }

        public final void onActionProviderVisibilityChanged(boolean z) {
            if (this.acf != null) {
                this.acf.mo1042en();
            }
        }
    }

    C7592l(Context context, C0369b c0369b) {
        super(context, c0369b);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C6240a mo16384a(ActionProvider actionProvider) {
        return new C7456a(this.mContext, actionProvider);
    }
}
