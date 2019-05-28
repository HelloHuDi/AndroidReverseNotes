package com.tencent.mm.plugin.wallet.bind;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.bind.a.d;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a extends c {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45718);
        ab.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            d(activity, bundle);
        } else {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        AppMethodBeat.o(45718);
        return this;
    }

    /* Access modifiers changed, original: protected */
    public void d(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45719);
        b(activity, WalletBankcardDetailUI.class, bundle);
        AppMethodBeat.o(45719);
    }

    public void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(45720);
        if (activity instanceof WalletBankcardDetailUI) {
            b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.o(45720);
            return;
        }
        if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
        }
        AppMethodBeat.o(45720);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(45721);
        F(activity);
        AppMethodBeat.o(45721);
    }

    public void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45722);
        if (this.mqu.getInt("scene", -1) == 1) {
            Activity activity2 = activity;
            a(activity2, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", bundle.getInt("key_process_result_code", 0), false);
            AppMethodBeat.o(45722);
        } else if (this.mqu.getInt("scene", -1) == 2) {
            d(activity, "wallet", ".balance.ui.WalletBalanceManagerUI");
            AppMethodBeat.o(45722);
        } else {
            d(activity, "mall", ".ui.MallIndexUI");
            AppMethodBeat.o(45722);
        }
    }

    public g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(45723);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                private String czZ = null;

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45714);
                    if (mVar instanceof d) {
                        if (i == 0 && i2 == 0) {
                            a.this.mqu.putInt("key_process_result_code", -1);
                            if (a.this.c(this.hwd, null)) {
                                this.Agm.a(new y(this.czZ, 14), true, 1);
                            } else {
                                a.this.a(this.hwd, 0, null);
                                if (this.hwd instanceof WalletBaseUI) {
                                    ((WalletBaseUI) this.hwd).wU(0);
                                }
                                this.hwd.finish();
                            }
                            AppMethodBeat.o(45714);
                            return true;
                        }
                        a.this.mqu.putInt("key_process_result_code", 1);
                    }
                    AppMethodBeat.o(45714);
                    return false;
                }

                public final boolean w(Object... objArr) {
                    AppMethodBeat.i(45715);
                    Bankcard bankcard = (Bankcard) a.this.mqu.getParcelable("key_bankcard");
                    if (bankcard == null || bankcard.field_bankcardState != 1) {
                        a.this.mqu.putInt("key_process_result_code", 1);
                        boolean w = super.w(objArr);
                        AppMethodBeat.o(45715);
                        return w;
                    }
                    boolean z;
                    i iVar = this.Agm;
                    String str = bankcard.field_bankcardType;
                    String str2 = bankcard.field_bindSerial;
                    if (a.this.mqu.getInt("scene", -1) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    iVar.a(new d(str, str2, z), true, 1);
                    a.this.mqu.putBoolean("key_is_expired_bankcard", true);
                    AppMethodBeat.o(45715);
                    return true;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45716);
                    Bankcard bankcard = (Bankcard) a.this.mqu.getParcelable("key_bankcard");
                    String str = (String) objArr[0];
                    this.czZ = (String) objArr[1];
                    if (bankcard != null) {
                        boolean z;
                        i iVar = this.Agm;
                        String str2 = bankcard.field_bankcardType;
                        String str3 = bankcard.field_bindSerial;
                        if (a.this.mqu.getInt("scene", -1) == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        iVar.a(new d(str2, str3, str, z), true, 1);
                        AppMethodBeat.o(45716);
                        return true;
                    }
                    a.this.mqu.putInt("key_process_result_code", 1);
                    AppMethodBeat.o(45716);
                    return false;
                }

                public final CharSequence Au(int i) {
                    AppMethodBeat.i(45717);
                    CharSequence string;
                    switch (i) {
                        case 1:
                            string = this.hwd.getString(R.string.fgg);
                            AppMethodBeat.o(45717);
                            return string;
                        default:
                            string = super.Au(i);
                            AppMethodBeat.o(45717);
                            return string;
                    }
                }
            };
            AppMethodBeat.o(45723);
            return anonymousClass1;
        }
        g a = super.a(mMActivity, iVar);
        AppMethodBeat.o(45723);
        return a;
    }

    public boolean c(Activity activity, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            return true;
        }
        return false;
    }

    public final String bxP() {
        return "UnbindProcess";
    }
}
