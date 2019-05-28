package android.support.v7.view;

import android.content.Context;
import android.support.v4.b.a.b;
import android.support.v4.f.m;
import android.support.v7.view.menu.q;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public final class f extends ActionMode {
    final b YQ;
    final Context mContext;

    public static class a implements android.support.v7.view.b.a {
        final Callback YR;
        final ArrayList<f> YS = new ArrayList();
        final m<Menu, Menu> YT = new m();
        final Context mContext;

        public a(Context context, Callback callback) {
            this.mContext = context;
            this.YR = callback;
        }

        public final boolean a(b bVar, Menu menu) {
            return this.YR.onCreateActionMode(b(bVar), b(menu));
        }

        public final boolean b(b bVar, Menu menu) {
            return this.YR.onPrepareActionMode(b(bVar), b(menu));
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            return this.YR.onActionItemClicked(b(bVar), q.a(this.mContext, (b) menuItem));
        }

        public final void a(b bVar) {
            this.YR.onDestroyActionMode(b(bVar));
        }

        private Menu b(Menu menu) {
            Menu menu2 = (Menu) this.YT.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = q.a(this.mContext, (android.support.v4.b.a.a) menu);
            this.YT.put(menu, menu2);
            return menu2;
        }

        public final ActionMode b(b bVar) {
            f fVar;
            int size = this.YS.size();
            for (int i = 0; i < size; i++) {
                fVar = (f) this.YS.get(i);
                if (fVar != null && fVar.YQ == bVar) {
                    return fVar;
                }
            }
            fVar = new f(this.mContext, bVar);
            this.YS.add(fVar);
            return fVar;
        }
    }

    public f(Context context, b bVar) {
        this.mContext = context;
        this.YQ = bVar;
    }

    public final Object getTag() {
        return this.YQ.sO;
    }

    public final void setTag(Object obj) {
        this.YQ.sO = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        this.YQ.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.YQ.setSubtitle(charSequence);
    }

    public final void invalidate() {
        this.YQ.invalidate();
    }

    public final void finish() {
        this.YQ.finish();
    }

    public final Menu getMenu() {
        return q.a(this.mContext, (android.support.v4.b.a.a) this.YQ.getMenu());
    }

    public final CharSequence getTitle() {
        return this.YQ.getTitle();
    }

    public final void setTitle(int i) {
        this.YQ.setTitle(i);
    }

    public final CharSequence getSubtitle() {
        return this.YQ.getSubtitle();
    }

    public final void setSubtitle(int i) {
        this.YQ.setSubtitle(i);
    }

    public final View getCustomView() {
        return this.YQ.getCustomView();
    }

    public final void setCustomView(View view) {
        this.YQ.setCustomView(view);
    }

    public final MenuInflater getMenuInflater() {
        return this.YQ.getMenuInflater();
    }

    public final boolean getTitleOptionalHint() {
        return this.YQ.YM;
    }

    public final void setTitleOptionalHint(boolean z) {
        this.YQ.setTitleOptionalHint(z);
    }

    public final boolean isTitleOptional() {
        return this.YQ.isTitleOptional();
    }
}
