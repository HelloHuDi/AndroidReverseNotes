package com.tencent.p177mm.plugin.wallet_ecard.p562b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletBankcardIdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCardImportUI;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.p649c.C36381z;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.b.a */
public class C31461a extends C29615b {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48071);
        mo64557F("start", activity, bundle);
        C4990ab.m7410d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            C36381z.m59954hL(6, bundle.getInt("key_bind_scene"));
            C36379x.m59950QN(bundle.getInt("key_bind_scene"));
        } else {
            C36381z.m59954hL(6, 0);
            C36379x.m59950QN(0);
        }
        if (!C14241r.cPI().cQg()) {
            if (bundle != null) {
                C40148d.m68849gj(bundle.getInt("key_bind_scene", 0), 1);
            }
            if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
                this = super.mo8123a(activity, bundle);
                AppMethodBeat.m2505o(48071);
                return this;
            }
            mo64571b(activity, WalletCardImportUI.class, bundle);
            AppMethodBeat.m2505o(48071);
            return this;
        } else if (bundle != null) {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                mo64571b(activity, WalletCardImportUI.class, bundle);
            } else {
                mo64571b(activity, WalletBankcardIdUI.class, bundle);
            }
            AppMethodBeat.m2505o(48071);
            return this;
        } else {
            C40931c thisR = super.mo8123a(activity, bundle);
            AppMethodBeat.m2505o(48071);
            return thisR;
        }
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48072);
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            mo64564a(activity, "wallet_ecard", ".ui.WalletECardBindCardListUI", 0, new Intent(), true);
            activity.finish();
            AppMethodBeat.m2505o(48072);
            return;
        }
        Activity activity2 = activity;
        mo64564a(activity2, "wallet_ecard", ".ui.WalletECardBindCardListUI", -1, new Intent(), true);
        AppMethodBeat.m2505o(48072);
    }

    public final String bxP() {
        return "OpenECardBindCardProcess";
    }
}
