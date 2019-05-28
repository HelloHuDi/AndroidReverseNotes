package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

@a(3)
public abstract class WalletPreferenceUI extends MMPreference implements f {
    protected c Ahq = null;
    protected i Ahr = null;
    protected g Ahs = null;

    public abstract boolean f(int i, int i2, String str, m mVar);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final i dOM() {
        if (this.Ahr == null) {
            this.Ahr = new i(this, this);
        }
        return this.Ahr;
    }

    public final void b(int i, int i2, String str, m mVar, boolean z) {
        if (!f(i, i2, str, mVar) && i2 != 0) {
            if (bo.isNullOrNil(str)) {
                str = getString(R.string.fdx);
            }
            h.a((Context) this, str, null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(49334);
                    WalletPreferenceUI.this.finish();
                    AppMethodBeat.o(49334);
                }
            });
        }
    }

    public void onDestroy() {
        this.Ahr.ng(385);
        this.Ahr.ng(1518);
        this.Ahr = null;
        super.onDestroy();
    }

    public void onCreate(Bundle bundle) {
        this.yll = true;
        super.onCreate(bundle);
        bht();
        this.Ahr = new i(this, this);
        this.Ahr.nf(385);
        this.Ahr.nf(1518);
        if (getLayoutId() > 0) {
            e.dOJ();
        }
    }

    /* Access modifiers changed, original: protected */
    public void bht() {
        xE(this.mController.dyj());
    }
}
