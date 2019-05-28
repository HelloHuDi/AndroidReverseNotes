package com.tencent.mm.ui.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a {
    b Vj = null;
    public ActionBar mActionBar;
    public final Activity mActivity;
    public MenuInflater mY;

    class a implements android.support.v7.view.b.a {
        private android.support.v7.view.b.a VE;

        public a(android.support.v7.view.b.a aVar) {
            this.VE = aVar;
        }

        public final boolean a(b bVar, Menu menu) {
            AppMethodBeat.i(106145);
            boolean a = this.VE.a(bVar, menu);
            AppMethodBeat.o(106145);
            return a;
        }

        public final boolean b(b bVar, Menu menu) {
            AppMethodBeat.i(106146);
            boolean b = this.VE.b(bVar, menu);
            AppMethodBeat.o(106146);
            return b;
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            AppMethodBeat.i(106147);
            boolean a = this.VE.a(bVar, menuItem);
            AppMethodBeat.o(106147);
            return a;
        }

        public final void a(b bVar) {
            AppMethodBeat.i(106148);
            this.VE.a(bVar);
            a.this.Vj = null;
            AppMethodBeat.o(106148);
        }
    }

    public abstract ActionBar dzl();

    public a(Activity activity) {
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
        android.support.v7.view.f.a aVar = new android.support.v7.view.f.a(this.mActivity, callback);
        b startSupportActionMode = startSupportActionMode(aVar);
        if (startSupportActionMode != null) {
            return aVar.b(startSupportActionMode);
        }
        return null;
    }

    private b startSupportActionMode(android.support.v7.view.b.a aVar) {
        if (this.Vj != null) {
            this.Vj.finish();
        }
        a aVar2 = new a(aVar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.Vj = supportActionBar.a(aVar2);
        }
        return this.Vj;
    }
}
