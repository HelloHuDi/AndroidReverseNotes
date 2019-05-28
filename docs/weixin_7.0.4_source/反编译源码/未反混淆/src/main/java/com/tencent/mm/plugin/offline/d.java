package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class d extends b {
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43298);
        a.xxA.m(new lf());
        c(activity, WalletOfflineEntranceUI.class);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(43298);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(43299);
        super.c(activity, i);
        AppMethodBeat.o(43299);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(43300);
        g anonymousClass2;
        if (mMActivity instanceof WalletVerifyCodeUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(43294);
                    s sVar = (s) objArr[1];
                    sVar.flag = "1";
                    this.Agm.a(new q(sVar), true, 1);
                    AppMethodBeat.o(43294);
                    return true;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(43295);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof y) {
                            if (!(((WalletBaseUI) this.hwd).mBundle == null || ((WalletBaseUI) this.hwd).mBundle.getInt("key_bind_scene", -1) != 5 || com.tencent.mm.plugin.offline.c.a.bYd())) {
                                d.i(this.hwd);
                                AppMethodBeat.o(43295);
                                return true;
                            }
                        } else if (mVar instanceof k) {
                            com.tencent.mm.wallet_core.a.j(this.hwd, ((WalletBaseUI) this.hwd).mBundle);
                            com.tencent.mm.plugin.offline.c.a.W(this.hwd);
                            AppMethodBeat.o(43295);
                            return true;
                        }
                    }
                    AppMethodBeat.o(43295);
                    return false;
                }
            };
            AppMethodBeat.o(43300);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(43296);
                    this.Agm.a(new com.tencent.mm.plugin.wallet_core.b.a.b((s) objArr[0]), true, 1);
                    AppMethodBeat.o(43296);
                    return true;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(43297);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof y) {
                            if (!(((WalletBaseUI) this.hwd).mBundle == null || ((WalletBaseUI) this.hwd).mBundle.getInt("key_bind_scene", -1) != 5 || com.tencent.mm.plugin.offline.c.a.bYd())) {
                                d.i(this.hwd);
                            }
                            AppMethodBeat.o(43297);
                            return true;
                        } else if (mVar instanceof k) {
                            Bundle bundle = ((WalletBaseUI) this.hwd).mBundle;
                            bundle.putBoolean("intent_bind_end", true);
                            com.tencent.mm.wallet_core.a.j(this.hwd, bundle);
                            com.tencent.mm.plugin.offline.c.a.W(this.hwd);
                            AppMethodBeat.o(43297);
                            return true;
                        }
                    }
                    AppMethodBeat.o(43297);
                    return false;
                }
            };
            AppMethodBeat.o(43300);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(43300);
            return anonymousClass2;
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43301);
        boolean c = super.c(activity, bundle);
        AppMethodBeat.o(43301);
        return c;
    }

    public final String bxP() {
        return "OfflineBindCardRegProcess";
    }

    static /* synthetic */ void i(MMActivity mMActivity) {
        AppMethodBeat.i(43302);
        String string = ((WalletBaseUI) mMActivity).mBundle.getString("key_pwd1");
        int i = ((WalletBaseUI) mMActivity).mBundle.getInt("offline_add_fee", 0);
        Bankcard bYg = com.tencent.mm.plugin.offline.c.a.bYg();
        if (bYg != null) {
            ((WalletBaseUI) mMActivity).a(new k(bYg, string, i), true, false);
        }
        AppMethodBeat.o(43302);
    }
}
