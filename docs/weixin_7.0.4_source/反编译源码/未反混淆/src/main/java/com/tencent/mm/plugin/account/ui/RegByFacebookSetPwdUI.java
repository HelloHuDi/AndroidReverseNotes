package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.plugin.account.friend.a.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class RegByFacebookSetPwdUI extends SetPwdUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125325);
        super.onCreate(bundle);
        setMMTitle((int) R.string.dl3);
        AppMethodBeat.o(125325);
    }

    public void onDestroy() {
        AppMethodBeat.i(125326);
        super.onDestroy();
        AppMethodBeat.o(125326);
    }

    public final int getLayoutId() {
        return R.layout.ao1;
    }

    public final void initView() {
        AppMethodBeat.i(139153);
        setMMTitle((int) R.string.dl3);
        AppMethodBeat.o(139153);
    }

    /* Access modifiers changed, original: protected|final */
    public final ProgressDialog a(Context context, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.i(125328);
        p b = h.b(context, getString(R.string.dku), true, onCancelListener);
        AppMethodBeat.o(125328);
        return b;
    }

    /* Access modifiers changed, original: protected|final */
    public final m ark() {
        AppMethodBeat.i(125329);
        ak akVar = new ak(this.gHW);
        AppMethodBeat.o(125329);
        return akVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final String arl() {
        AppMethodBeat.i(125330);
        String obj = ((EditText) findViewById(R.id.dxe)).getText().toString();
        AppMethodBeat.o(125330);
        return obj;
    }

    /* Access modifiers changed, original: protected|final */
    public final String arm() {
        AppMethodBeat.i(125331);
        String obj = ((EditText) findViewById(R.id.dxf)).getText().toString();
        AppMethodBeat.o(125331);
        return obj;
    }

    /* Access modifiers changed, original: protected|final */
    public final int arn() {
        return 382;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        AppMethodBeat.i(125332);
        switch (aVar) {
            case TwoPasswordsNotMatch:
                h.g(this, R.string.dkq, R.string.dks);
                AppMethodBeat.o(125332);
                return;
            case BeyondMaximumLength:
                h.g(this, R.string.dkr, R.string.dks);
                AppMethodBeat.o(125332);
                return;
            case DisallowShortNumericPassword:
                h.g(this, R.string.f0r, R.string.pq);
                AppMethodBeat.o(125332);
                return;
            case NotReachMinimumLength:
                h.g(this, R.string.f0t, R.string.pq);
                break;
        }
        AppMethodBeat.o(125332);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean k(int i, int i2, String str) {
        AppMethodBeat.i(125333);
        if (i == 0 && i2 == 0) {
            g.RP().Ry().set(57, Integer.valueOf(0));
            h.a((Context) this, getString(R.string.dl1, new Object[]{(String) g.RP().Ry().get(5, null)}), getString(R.string.dks), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(125323);
                    RegByFacebookSetPwdUI.this.finish();
                    AppMethodBeat.o(125323);
                }
            });
            AppMethodBeat.o(125333);
            return true;
        }
        boolean j = j(i, i2, str);
        AppMethodBeat.o(125333);
        return j;
    }
}
