package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class b extends c {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(46148);
        ab.d("MicroMsg.ProcessManager", "start Process : ModifyPwdProcess");
        b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.o(46148);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(46149);
        if (activity instanceof WalletCheckPwdUI) {
            b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.o(46149);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.o(46149);
        } else {
            if (activity instanceof WalletPwdConfirmUI) {
                b(activity, bundle);
            }
            AppMethodBeat.o(46149);
        }
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(46150);
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
        AppMethodBeat.o(46150);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(46151);
        a(activity, WalletPasswordSettingUI.class, -1, false);
        AppMethodBeat.o(46151);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(46152);
        g anonymousClass2;
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(46142);
                    this.Agm.a(new r((String) objArr[0], 3, (String) objArr[1]), true, 1);
                    AppMethodBeat.o(46142);
                    return true;
                }

                public final CharSequence Au(int i) {
                    AppMethodBeat.i(46143);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(R.string.fda);
                            AppMethodBeat.o(46143);
                            return string;
                        case 1:
                            string = this.hwd.getString(R.string.fnd);
                            AppMethodBeat.o(46143);
                            return string;
                        default:
                            string = super.Au(i);
                            AppMethodBeat.o(46143);
                            return string;
                    }
                }
            };
            AppMethodBeat.o(46152);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(46145);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof com.tencent.mm.plugin.wallet.pwd.a.i) {
                            b.this.a(this.hwd, 0, b.this.mqu);
                            h.bQ(this.hwd, this.hwd.getString(R.string.fmw));
                        }
                        AppMethodBeat.o(46145);
                        return true;
                    } else if (mVar instanceof com.tencent.mm.plugin.wallet.pwd.a.i) {
                        h.a(this.hwd, str, "", false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(46144);
                                b.this.c(AnonymousClass2.this.hwd, 0);
                                AppMethodBeat.o(46144);
                            }
                        });
                        AppMethodBeat.o(46145);
                        return true;
                    } else {
                        AppMethodBeat.o(46145);
                        return false;
                    }
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(46146);
                    s sVar = (s) objArr[0];
                    this.Agm.a(new com.tencent.mm.plugin.wallet.pwd.a.i(b.this.mqu.getString("key_pwd1"), sVar.guu), true, 1);
                    AppMethodBeat.o(46146);
                    return true;
                }
            };
            AppMethodBeat.o(46152);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(46152);
            return anonymousClass2;
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        AppMethodBeat.i(46153);
        switch (i) {
            case 404:
                h.a((Context) walletBaseUI, str, null, walletBaseUI.getString(R.string.ft6), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(46147);
                        b.this.b(walletBaseUI, b.this.mqu);
                        if (walletBaseUI.bwP()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.dOB();
                        AppMethodBeat.o(46147);
                    }
                });
                AppMethodBeat.o(46153);
                return true;
            default:
                AppMethodBeat.o(46153);
                return false;
        }
    }

    public final int a(MMActivity mMActivity, int i) {
        return R.string.ft6;
    }

    public final String bxP() {
        return "ModifyPwdProcess";
    }
}
