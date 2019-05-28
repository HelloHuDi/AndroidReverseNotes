package android.support.p069v7.view;

import android.content.Context;
import android.support.p057v4.p060b.p061a.C0368a;
import android.support.p057v4.p060b.p061a.C0369b;
import android.support.p057v4.p065f.C0417m;
import android.support.p069v7.view.C0604b.C0603a;
import android.support.p069v7.view.menu.C0631q;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.f */
public final class C0607f extends ActionMode {
    /* renamed from: YQ */
    final C0604b f944YQ;
    final Context mContext;

    /* renamed from: android.support.v7.view.f$a */
    public static class C0608a implements C0603a {
        /* renamed from: YR */
        final Callback f945YR;
        /* renamed from: YS */
        final ArrayList<C0607f> f946YS = new ArrayList();
        /* renamed from: YT */
        final C0417m<Menu, Menu> f947YT = new C0417m();
        final Context mContext;

        public C0608a(Context context, Callback callback) {
            this.mContext = context;
            this.f945YR = callback;
        }

        /* renamed from: a */
        public final boolean mo1485a(C0604b c0604b, Menu menu) {
            return this.f945YR.onCreateActionMode(mo1527b(c0604b), m1312b(menu));
        }

        /* renamed from: b */
        public final boolean mo1487b(C0604b c0604b, Menu menu) {
            return this.f945YR.onPrepareActionMode(mo1527b(c0604b), m1312b(menu));
        }

        /* renamed from: a */
        public final boolean mo1486a(C0604b c0604b, MenuItem menuItem) {
            return this.f945YR.onActionItemClicked(mo1527b(c0604b), C0631q.m1360a(this.mContext, (C0369b) menuItem));
        }

        /* renamed from: a */
        public final void mo1484a(C0604b c0604b) {
            this.f945YR.onDestroyActionMode(mo1527b(c0604b));
        }

        /* renamed from: b */
        private Menu m1312b(Menu menu) {
            Menu menu2 = (Menu) this.f947YT.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = C0631q.m1359a(this.mContext, (C0368a) menu);
            this.f947YT.put(menu, menu2);
            return menu2;
        }

        /* renamed from: b */
        public final ActionMode mo1527b(C0604b c0604b) {
            C0607f c0607f;
            int size = this.f946YS.size();
            for (int i = 0; i < size; i++) {
                c0607f = (C0607f) this.f946YS.get(i);
                if (c0607f != null && c0607f.f944YQ == c0604b) {
                    return c0607f;
                }
            }
            c0607f = new C0607f(this.mContext, c0604b);
            this.f946YS.add(c0607f);
            return c0607f;
        }
    }

    public C0607f(Context context, C0604b c0604b) {
        this.mContext = context;
        this.f944YQ = c0604b;
    }

    public final Object getTag() {
        return this.f944YQ.f941sO;
    }

    public final void setTag(Object obj) {
        this.f944YQ.f941sO = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f944YQ.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.f944YQ.setSubtitle(charSequence);
    }

    public final void invalidate() {
        this.f944YQ.invalidate();
    }

    public final void finish() {
        this.f944YQ.finish();
    }

    public final Menu getMenu() {
        return C0631q.m1359a(this.mContext, (C0368a) this.f944YQ.getMenu());
    }

    public final CharSequence getTitle() {
        return this.f944YQ.getTitle();
    }

    public final void setTitle(int i) {
        this.f944YQ.setTitle(i);
    }

    public final CharSequence getSubtitle() {
        return this.f944YQ.getSubtitle();
    }

    public final void setSubtitle(int i) {
        this.f944YQ.setSubtitle(i);
    }

    public final View getCustomView() {
        return this.f944YQ.getCustomView();
    }

    public final void setCustomView(View view) {
        this.f944YQ.setCustomView(view);
    }

    public final MenuInflater getMenuInflater() {
        return this.f944YQ.getMenuInflater();
    }

    public final boolean getTitleOptionalHint() {
        return this.f944YQ.f940YM;
    }

    public final void setTitleOptionalHint(boolean z) {
        this.f944YQ.setTitleOptionalHint(z);
    }

    public final boolean isTitleOptional() {
        return this.f944YQ.isTitleOptional();
    }
}
