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

public class c extends b {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43288);
        com.tencent.mm.wallet_core.c a = super.a(activity, bundle);
        AppMethodBeat.o(43288);
        return a;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(43289);
        super.a(activity, i, bundle);
        AppMethodBeat.o(43289);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43290);
        a.xxA.m(new lf());
        if (com.tencent.mm.plugin.offline.c.a.bYd()) {
            c(activity, WalletOfflineEntranceUI.class);
        } else if (bundle.getInt("key_entry_scene", -1) == 2) {
            d(activity, "offline", "ui.WalletOfflineEntranceUI");
        } else {
            d(activity, "mall", ".ui.MallIndexUI");
        }
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(43290);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(43291);
        g anonymousClass2;
        if (mMActivity instanceof WalletVerifyCodeUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(43284);
                    s sVar = (s) objArr[1];
                    sVar.flag = "2";
                    this.Agm.a(new q(sVar), true, 1);
                    AppMethodBeat.o(43284);
                    return true;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(43285);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof y) {
                            if (!(((WalletBaseUI) this.hwd).mBundle == null || ((WalletBaseUI) this.hwd).mBundle.getInt("key_bind_scene", -1) != 5 || com.tencent.mm.plugin.offline.c.a.bYd())) {
                                c.h(this.hwd);
                                AppMethodBeat.o(43285);
                                return true;
                            }
                        } else if (mVar instanceof k) {
                            com.tencent.mm.wallet_core.a.j(this.hwd, ((WalletBaseUI) this.hwd).mBundle);
                            com.tencent.mm.plugin.offline.c.a.W(this.hwd);
                            AppMethodBeat.o(43285);
                            return true;
                        }
                    }
                    AppMethodBeat.o(43285);
                    return false;
                }
            };
            AppMethodBeat.o(43291);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(43286);
                    this.Agm.a(new com.tencent.mm.plugin.wallet_core.b.a.b((s) objArr[0]), true, 1);
                    AppMethodBeat.o(43286);
                    return true;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(43287);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof y) {
                            if (!(((WalletBaseUI) this.hwd).mBundle == null || ((WalletBaseUI) this.hwd).mBundle.getInt("key_bind_scene", -1) != 5 || com.tencent.mm.plugin.offline.c.a.bYd())) {
                                c.h(this.hwd);
                                AppMethodBeat.o(43287);
                                return true;
                            }
                        } else if (mVar instanceof k) {
                            Bundle bundle = ((WalletBaseUI) this.hwd).mBundle;
                            bundle.putBoolean("intent_bind_end", true);
                            com.tencent.mm.wallet_core.a.j(this.hwd, bundle);
                            com.tencent.mm.plugin.offline.c.a.W(this.hwd);
                            AppMethodBeat.o(43287);
                            return true;
                        }
                    }
                    AppMethodBeat.o(43287);
                    return false;
                }
            };
            AppMethodBeat.o(43291);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(43291);
            return anonymousClass2;
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43292);
        boolean c = super.c(activity, bundle);
        AppMethodBeat.o(43292);
        return c;
    }

    public final String bxP() {
        return "OfflineBindCardProcess";
    }

    static /* synthetic */ void h(MMActivity mMActivity) {
        AppMethodBeat.i(43293);
        String string = ((WalletBaseUI) mMActivity).mBundle.getString("key_pwd1");
        int i = ((WalletBaseUI) mMActivity).mBundle.getInt("offline_add_fee", 0);
        Bankcard bYg = com.tencent.mm.plugin.offline.c.a.bYg();
        if (bYg != null) {
            ((WalletBaseUI) mMActivity).a(new k(bYg, string, i), true, false);
        }
        AppMethodBeat.o(43293);
    }
}
