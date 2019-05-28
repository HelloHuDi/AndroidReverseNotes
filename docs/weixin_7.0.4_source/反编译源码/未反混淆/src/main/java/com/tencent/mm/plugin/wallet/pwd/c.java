package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.a.n;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(46160);
        ab.d("MicroMsg.ResetPwdProcessByToken", "start Process : ResetPwdProcessByToken");
        b(activity, WalletSetPasswordUI.class, bundle);
        AppMethodBeat.o(46160);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(46161);
        if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.o(46161);
            return;
        }
        if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
        }
        AppMethodBeat.o(46161);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(46162);
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
        AppMethodBeat.o(46162);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(46163);
        Intent intent = new Intent(activity, WalletResetPwdAdapterUI.class);
        intent.putExtra("RESET_PWD_USER_ACTION", bundle.getInt("RESET_PWD_USER_ACTION", 0));
        a(activity, WalletResetPwdAdapterUI.class, -1, intent, false);
        AppMethodBeat.o(46163);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(46164);
        g anonymousClass2;
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(46154);
                    this.Agm.a(new r((String) objArr[0], 3, (String) objArr[1]), true, 1);
                    AppMethodBeat.o(46154);
                    return true;
                }

                public final CharSequence Au(int i) {
                    AppMethodBeat.i(46155);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(R.string.fda);
                            AppMethodBeat.o(46155);
                            return string;
                        case 1:
                            string = this.hwd.getString(R.string.fnd);
                            AppMethodBeat.o(46155);
                            return string;
                        default:
                            string = super.Au(i);
                            AppMethodBeat.o(46155);
                            return string;
                    }
                }
            };
            AppMethodBeat.o(46164);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(46157);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof n) {
                            c.this.mqu.putInt("RESET_PWD_USER_ACTION", 1);
                            c.this.a(this.hwd, 0, c.this.mqu);
                            h.bQ(this.hwd, this.hwd.getString(R.string.fmw));
                        }
                        AppMethodBeat.o(46157);
                        return true;
                    } else if (mVar instanceof n) {
                        h.a(this.hwd, str, "", false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(46156);
                                c.this.mqu.putInt("RESET_PWD_USER_ACTION", 2);
                                c.this.a(AnonymousClass2.this.hwd, 0, c.this.mqu);
                                AppMethodBeat.o(46156);
                            }
                        });
                        AppMethodBeat.o(46157);
                        return true;
                    } else {
                        AppMethodBeat.o(46157);
                        return false;
                    }
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(46158);
                    s sVar = (s) objArr[0];
                    c.this.mqu.getString("key_pwd1");
                    this.Agm.a(new n(sVar.guu, sVar.token), true, 1);
                    AppMethodBeat.o(46158);
                    return true;
                }
            };
            AppMethodBeat.o(46164);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(46164);
            return anonymousClass2;
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        AppMethodBeat.i(46165);
        switch (i) {
            case 404:
                h.a((Context) walletBaseUI, str, null, walletBaseUI.getString(R.string.ft6), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(46159);
                        c.this.b(walletBaseUI, c.this.mqu);
                        if (walletBaseUI.bwP()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.dOB();
                        AppMethodBeat.o(46159);
                    }
                });
                AppMethodBeat.o(46165);
                return true;
            default:
                AppMethodBeat.o(46165);
                return false;
        }
    }

    public final int a(MMActivity mMActivity, int i) {
        return R.string.ft6;
    }

    public final String bxP() {
        return "ResetPwdProcessByToken";
    }
}
