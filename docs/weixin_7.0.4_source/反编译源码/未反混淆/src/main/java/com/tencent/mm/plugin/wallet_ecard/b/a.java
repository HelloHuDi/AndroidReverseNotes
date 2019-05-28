package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.c.z;

public class a extends b {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48071);
        F("start", activity, bundle);
        ab.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            z.hL(6, bundle.getInt("key_bind_scene"));
            x.QN(bundle.getInt("key_bind_scene"));
        } else {
            z.hL(6, 0);
            x.QN(0);
        }
        if (!r.cPI().cQg()) {
            if (bundle != null) {
                d.gj(bundle.getInt("key_bind_scene", 0), 1);
            }
            if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
                this = super.a(activity, bundle);
                AppMethodBeat.o(48071);
                return this;
            }
            b(activity, WalletCardImportUI.class, bundle);
            AppMethodBeat.o(48071);
            return this;
        } else if (bundle != null) {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                b(activity, WalletCardImportUI.class, bundle);
            } else {
                b(activity, WalletBankcardIdUI.class, bundle);
            }
            AppMethodBeat.o(48071);
            return this;
        } else {
            c thisR = super.a(activity, bundle);
            AppMethodBeat.o(48071);
            return thisR;
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48072);
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            a(activity, "wallet_ecard", ".ui.WalletECardBindCardListUI", 0, new Intent(), true);
            activity.finish();
            AppMethodBeat.o(48072);
            return;
        }
        Activity activity2 = activity;
        a(activity2, "wallet_ecard", ".ui.WalletECardBindCardListUI", -1, new Intent(), true);
        AppMethodBeat.o(48072);
    }

    public final String bxP() {
        return "OpenECardBindCardProcess";
    }
}
