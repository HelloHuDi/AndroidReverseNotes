package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.bind.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class d extends a {
    public final void d(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48349);
        b(activity, WalletPayUBankcardDetailUI.class, bundle);
        AppMethodBeat.o(48349);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48350);
        if (this.mqu.getInt("key_errcode_payu", -1) == 0) {
            t.makeText(activity, R.string.fle, 0).show();
        } else {
            t.makeText(activity, R.string.fen, 0).show();
        }
        d(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.o(48350);
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48351);
        if (activity instanceof WalletBankcardDetailUI) {
            b(activity, WalletPayUCheckPwdUI.class, bundle);
            AppMethodBeat.o(48351);
            return;
        }
        if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, bundle);
        }
        AppMethodBeat.o(48351);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48352);
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final CharSequence Au(int i) {
                    AppMethodBeat.i(48346);
                    if (i == 0) {
                        String string = this.hwd.getString(R.string.fdi);
                        AppMethodBeat.o(48346);
                        return string;
                    }
                    CharSequence Au = super.Au(i);
                    AppMethodBeat.o(48346);
                    return Au;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48347);
                    if (mVar instanceof c) {
                        if (i2 == 0 && i == 0) {
                            c cVar = (c) mVar;
                            d.this.mqu.putString("payu_reference", cVar.token);
                            if (bo.isNullOrNil(cVar.token)) {
                                ab.w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
                            } else {
                                ab.d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
                                Bankcard bankcard = (Bankcard) d.this.mqu.getParcelable("key_bankcard");
                                if (bankcard != null) {
                                    this.Agm.a(new b(bankcard.field_bindSerial, d.this.mqu.getString("payu_reference")), true);
                                }
                            }
                        }
                    } else if (mVar instanceof b) {
                        if (i == 0 && i2 == 0) {
                            d.this.mqu.putInt("key_errcode_payu", 0);
                            d.this.b(this.hwd, d.this.mqu);
                        }
                        AppMethodBeat.o(48347);
                        return false;
                    }
                    AppMethodBeat.o(48347);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48348);
                    d.this.mqu.putString("key_pwd1", (String) objArr[0]);
                    this.Agm.a(new c(d.this.mqu.getString("key_pwd1")), true);
                    AppMethodBeat.o(48348);
                    return true;
                }
            };
            AppMethodBeat.o(48352);
            return anonymousClass1;
        }
        g a = super.a(mMActivity, iVar);
        AppMethodBeat.o(48352);
        return a;
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }
}
