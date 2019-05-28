package com.tencent.p177mm.p612ui.p614b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.p069v7.app.ActionBar;
import android.support.p069v7.view.C0604b;
import android.support.p069v7.view.C0604b.C0603a;
import android.support.p069v7.view.C0607f.C0608a;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.b.a */
public abstract class C5236a {
    /* renamed from: Vj */
    C0604b f1299Vj = null;
    public ActionBar mActionBar;
    public final Activity mActivity;
    /* renamed from: mY */
    public MenuInflater f1300mY;

    /* renamed from: com.tencent.mm.ui.b.a$a */
    class C5237a implements C0603a {
        /* renamed from: VE */
        private C0603a f1301VE;

        public C5237a(C0603a c0603a) {
            this.f1301VE = c0603a;
        }

        /* renamed from: a */
        public final boolean mo1485a(C0604b c0604b, Menu menu) {
            AppMethodBeat.m2504i(106145);
            boolean a = this.f1301VE.mo1485a(c0604b, menu);
            AppMethodBeat.m2505o(106145);
            return a;
        }

        /* renamed from: b */
        public final boolean mo1487b(C0604b c0604b, Menu menu) {
            AppMethodBeat.m2504i(106146);
            boolean b = this.f1301VE.mo1487b(c0604b, menu);
            AppMethodBeat.m2505o(106146);
            return b;
        }

        /* renamed from: a */
        public final boolean mo1486a(C0604b c0604b, MenuItem menuItem) {
            AppMethodBeat.m2504i(106147);
            boolean a = this.f1301VE.mo1486a(c0604b, menuItem);
            AppMethodBeat.m2505o(106147);
            return a;
        }

        /* renamed from: a */
        public final void mo1484a(C0604b c0604b) {
            AppMethodBeat.m2504i(106148);
            this.f1301VE.mo1484a(c0604b);
            C5236a.this.f1299Vj = null;
            AppMethodBeat.m2505o(106148);
        }
    }

    public abstract ActionBar dzl();

    public C5236a(Activity activity) {
        this.mActivity = activity;
    }

    public final ActionBar getSupportActionBar() {
        if (this.mActionBar == null) {
            this.mActionBar = dzl();
        }
        return this.mActionBar;
    }

    @TargetApi(11)
    public final ActionMode startActionMode(Callback callback) {
        C0608a c0608a = new C0608a(this.mActivity, callback);
        C0604b startSupportActionMode = startSupportActionMode(c0608a);
        if (startSupportActionMode != null) {
            return c0608a.mo1527b(startSupportActionMode);
        }
        return null;
    }

    private C0604b startSupportActionMode(C0603a c0603a) {
        if (this.f1299Vj != null) {
            this.f1299Vj.finish();
        }
        C5237a c5237a = new C5237a(c0603a);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.f1299Vj = supportActionBar.mo1334a(c5237a);
        }
        return this.f1299Vj;
    }
}
