package com.tencent.p177mm.p612ui.p614b;

import android.app.Activity;
import android.content.Context;
import android.support.p069v7.app.ActionBar;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.support.p069v7.widget.C0728x;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.b.b */
public final class C7318b extends C5236a implements C0623a, C0627a {
    /* renamed from: SW */
    public ViewGroup f1971SW;
    /* renamed from: Vo */
    private boolean f1972Vo;
    /* renamed from: lo */
    private C6236h f1973lo;
    C5239a yrc;
    boolean yrd;
    private final Runnable yre = new C52381();

    /* renamed from: com.tencent.mm.ui.b.b$1 */
    class C52381 implements Runnable {
        C52381() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106149);
            C0623a c0623a = C7318b.this;
            Context context = c0623a.mActivity;
            ActionBar supportActionBar = c0623a.getSupportActionBar();
            if (supportActionBar != null) {
                context = supportActionBar.getThemedContext();
            }
            C6236h c6236h = new C6236h(context);
            c6236h.mo14113a(c0623a);
            if (C7318b.this.yrc != null) {
                C7318b.this.yrc.mo10746d(c6236h);
                C7318b.this.yrc.mo10745c(c6236h);
                C7318b.m12402a(C7318b.this, c6236h);
            } else {
                C7318b.m12402a(C7318b.this, null);
            }
            c6236h.mo14152p(true);
            C7318b.this.yrd = false;
            AppMethodBeat.m2505o(106149);
        }
    }

    /* renamed from: com.tencent.mm.ui.b.b$a */
    public interface C5239a {
        /* renamed from: c */
        boolean mo10745c(Menu menu);

        /* renamed from: d */
        boolean mo10746d(Menu menu);

        /* renamed from: h */
        boolean mo10747h(MenuItem menuItem);
    }

    public C7318b(Activity activity, C5239a c5239a) {
        super(activity);
        AppMethodBeat.m2504i(106150);
        this.yrc = c5239a;
        AppMethodBeat.m2505o(106150);
    }

    public final ActionBar dzl() {
        AppMethodBeat.m2504i(106151);
        m12403fr();
        if (this.mActionBar == null) {
            this.mActionBar = new C7321d(this.mActivity, this.f1971SW);
        }
        ActionBar actionBar = this.mActionBar;
        AppMethodBeat.m2505o(106151);
        return actionBar;
    }

    /* renamed from: fr */
    private void m12403fr() {
        AppMethodBeat.m2504i(106152);
        if (!this.f1972Vo) {
            this.f1972Vo = true;
            supportInvalidateOptionsMenu();
        }
        AppMethodBeat.m2505o(106152);
    }

    /* renamed from: a */
    public final boolean mo1584a(C6236h c6236h, MenuItem menuItem) {
        AppMethodBeat.m2504i(106153);
        if (this.yrc != null) {
            boolean h = this.yrc.mo10747h(menuItem);
            AppMethodBeat.m2505o(106153);
            return h;
        }
        AppMethodBeat.m2505o(106153);
        return false;
    }

    /* renamed from: a */
    public final void mo1596a(C6236h c6236h, boolean z) {
    }

    /* renamed from: d */
    public final boolean mo1597d(C6236h c6236h) {
        return false;
    }

    public final void supportInvalidateOptionsMenu() {
        AppMethodBeat.m2504i(106155);
        if (!this.yrd) {
            this.yrd = true;
            this.yre.run();
        }
        AppMethodBeat.m2505o(106155);
    }

    /* renamed from: b */
    public final void mo1585b(C6236h c6236h) {
        AppMethodBeat.m2504i(106154);
        if (this.mActionBar != null) {
            C0728x c0728x = ((C7321d) this.mActionBar).f1993Wk;
            if (c0728x != null && c0728x.mo2148gV()) {
                if (c0728x.isOverflowMenuShowing()) {
                    c0728x.hideOverflowMenu();
                } else if (c0728x.getVisibility() == 0) {
                    c0728x.showOverflowMenu();
                    AppMethodBeat.m2505o(106154);
                    return;
                }
                AppMethodBeat.m2505o(106154);
                return;
            }
        }
        c6236h.close();
        AppMethodBeat.m2505o(106154);
    }
}
