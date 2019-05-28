package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.plugin.wxcredit.a.a;
import com.tencent.mm.plugin.wxcredit.a.b;
import com.tencent.mm.plugin.wxcredit.a.h;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class e extends c {
    static /* synthetic */ boolean an(e eVar) {
        AppMethodBeat.i(48644);
        boolean dNI = eVar.dNI();
        AppMethodBeat.o(48644);
        return dNI;
    }

    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48639);
        if (!r.cPI().cQl()) {
            if (r.cPI().cQg()) {
                b(activity, WalletCheckPwdUI.class, bundle);
            } else {
                b(activity, WalletWXCreditOpenUI.class, bundle);
            }
        }
        AppMethodBeat.o(48639);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48640);
        if (activity instanceof WalletWXCreditOpenUI) {
            b(activity, WalletCheckIdentityUI.class, bundle);
            AppMethodBeat.o(48640);
        } else if (activity instanceof WalletCheckPwdUI) {
            F(activity);
            b(activity, WalletWXCreditOpenUI.class, bundle);
            AppMethodBeat.o(48640);
        } else if (activity instanceof WalletWXCreditOpenUI) {
            b(activity, WalletCheckIdentityUI.class, bundle);
            AppMethodBeat.o(48640);
        } else if (activity instanceof WalletCheckIdentityUI) {
            if (bundle.getBoolean("key_need_bind_deposit", true)) {
                b(activity, WalletBindDepositUI.class, bundle);
                AppMethodBeat.o(48640);
                return;
            }
            b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.o(48640);
        } else if (activity instanceof WalletBindDepositUI) {
            b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.o(48640);
        } else if (activity instanceof WalletVerifyCodeUI) {
            if (r.cPI().cQg()) {
                b(activity, WalletWXCreditOpenResultUI.class, bundle);
                AppMethodBeat.o(48640);
                return;
            }
            b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.o(48640);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.o(48640);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, WalletWXCreditOpenResultUI.class, bundle);
            AppMethodBeat.o(48640);
        } else {
            if (activity instanceof WalletWXCreditOpenResultUI) {
                b(activity, bundle);
            }
            AppMethodBeat.o(48640);
        }
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(48641);
        F(activity);
        AppMethodBeat.o(48641);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48642);
        d(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
        AppMethodBeat.o(48642);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48643);
        g anonymousClass2;
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48625);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof b) {
                            b bVar = (b) mVar;
                            e.this.mqu.putString("KEY_SESSION_KEY", bVar.token);
                            e.this.mqu.putString("key_pre_name", bVar.name);
                            e.this.mqu.putString("key_pre_indentity", bVar.uYt);
                            e.this.mqu.putBoolean("key_has_indentity_info", bVar.uYu);
                        }
                        e.this.a(this.hwd, 0, e.this.mqu);
                        AppMethodBeat.o(48625);
                        return true;
                    }
                    AppMethodBeat.o(48625);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    int i = 0;
                    AppMethodBeat.i(48626);
                    e.this.mqu.putString("key_pwd1", (String) objArr[0]);
                    i iVar = this.Agm;
                    String str = (String) objArr[0];
                    if (objArr[1] != null) {
                        i = bo.ank((String) objArr[1]);
                    }
                    iVar.a(new b(str, i, e.this.mqu.getString("key_bank_type")), true, 1);
                    AppMethodBeat.o(48626);
                    return true;
                }
            };
            AppMethodBeat.o(48643);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletCheckIdentityUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48627);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof a) {
                            a aVar = (a) mVar;
                            e.this.mqu.putString("KEY_SESSION_KEY", aVar.token);
                            e.this.mqu.putString("key_mobile", aVar.cFl);
                            e.this.mqu.putBoolean("key_need_bind_deposit", aVar.cQU);
                            e.this.mqu.putBoolean("key_is_bank_user", aVar.uYs);
                        }
                        e.this.a(this.hwd, 0, e.this.mqu);
                        AppMethodBeat.o(48627);
                        return true;
                    }
                    AppMethodBeat.o(48627);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48628);
                    String str = (String) objArr[0];
                    String str2 = (String) objArr[1];
                    e.this.mqu.putString("key_name", str);
                    e.this.mqu.putString("key_indentity", str2);
                    this.Agm.a(new a(str, str2, e.this.mqu.getString("KEY_SESSION_KEY"), e.this.mqu.getString("key_bank_type")), true, 1);
                    AppMethodBeat.o(48628);
                    return true;
                }
            };
            AppMethodBeat.o(48643);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48629);
                    if (i != 0 || i2 != 0) {
                        AppMethodBeat.o(48629);
                        return false;
                    } else if (mVar instanceof com.tencent.mm.plugin.wxcredit.a.g) {
                        String str2 = ((com.tencent.mm.plugin.wxcredit.a.g) mVar).cIe;
                        if (!bo.isNullOrNil(str2)) {
                            e.this.mqu.putString("key_bank_username", str2);
                        }
                        e.this.a(this.hwd, 0, e.this.mqu);
                        AppMethodBeat.o(48629);
                        return true;
                    } else if (mVar instanceof h) {
                        e.this.a(this.hwd, 0, e.this.mqu);
                        AppMethodBeat.o(48629);
                        return true;
                    } else if (mVar instanceof q) {
                        if (r.cPI().cQg()) {
                            this.Agm.a(new y(), true, 1);
                            AppMethodBeat.o(48629);
                            return true;
                        }
                        e.this.a(this.hwd, 0, e.this.mqu);
                        AppMethodBeat.o(48629);
                        return true;
                    } else if (mVar instanceof y) {
                        this.Agm.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.mqu.getString("key_verify_code"), e.this.mqu.getString("KEY_SESSION_KEY"), e.this.mqu.getString("key_pwd1"), r.cPI().cQL(), e.this.mqu.getString("key_bank_type")), true, 1);
                        AppMethodBeat.o(48629);
                        return true;
                    } else {
                        AppMethodBeat.o(48629);
                        return false;
                    }
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48630);
                    String str = (String) objArr[0];
                    e.this.mqu.putString("key_verify_code", str);
                    s sVar;
                    if (r.cPI().cQg()) {
                        if (!e.this.mqu.getBoolean("key_need_bind_deposit", true) || e.this.mqu.getBoolean("key_is_bank_user")) {
                            this.Agm.a(new com.tencent.mm.plugin.wxcredit.a.g(str, e.this.mqu.getString("KEY_SESSION_KEY"), e.this.mqu.getString("key_pwd1"), e.this.mqu.getString("key_bind_serial"), e.this.mqu.getString("key_bank_type")), true, 1);
                        } else {
                            sVar = (s) objArr[1];
                            sVar.flag = "2";
                            this.Agm.a(new q(sVar), true, 1);
                        }
                    } else if (e.this.mqu.getBoolean("key_is_bank_user", false)) {
                        e.this.mqu.putString("key_verify_code", str);
                        this.Agm.a(new h(str, e.this.mqu.getString("KEY_SESSION_KEY"), e.this.mqu.getString("key_pwd1"), e.this.mqu.getString("key_bind_serial"), e.this.mqu.getString("key_bank_type")), true, 1);
                    } else {
                        sVar = (s) objArr[1];
                        sVar.flag = "1";
                        this.Agm.a(new q(sVar), true, 1);
                    }
                    AppMethodBeat.o(48630);
                    return true;
                }

                public final /* synthetic */ CharSequence Au(int i) {
                    AppMethodBeat.i(48631);
                    if (e.this.mqu.getBoolean("key_is_bank_user", false)) {
                        Bankcard bankcard = (Bankcard) e.this.mqu.getParcelable("key_bankcard");
                        String string = this.hwd.getString(R.string.fum, new Object[]{bankcard.field_bankName, bankcard.field_bankName, e.this.mqu.getString("key_mobile")});
                        AppMethodBeat.o(48631);
                        return string;
                    }
                    CharSequence string2 = this.hwd.getString(R.string.fun, new Object[]{e.this.mqu.getString("key_mobile")});
                    AppMethodBeat.o(48631);
                    return string2;
                }
            };
            AppMethodBeat.o(48643);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletBindDepositUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48632);
                    if (i == 0 && i2 == 0 && (mVar instanceof com.tencent.mm.plugin.wallet_core.b.a.a)) {
                        com.tencent.mm.plugin.wallet_core.b.a.a aVar = (com.tencent.mm.plugin.wallet_core.b.a.a) mVar;
                        new StringBuilder("reqKey  ").append(aVar.tos);
                        e.this.mqu.putString("kreq_token", aVar.token);
                        e.this.a(this.hwd, 0, e.this.mqu);
                        AppMethodBeat.o(48632);
                        return true;
                    }
                    AppMethodBeat.o(48632);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48633);
                    d.cSP();
                    Authen authen = new Authen();
                    authen.twg = (String) objArr[0];
                    authen.pbn = (String) objArr[1];
                    authen.tuk = (String) objArr[2];
                    e.this.mqu.putString("key_bank_phone", (String) objArr[3]);
                    authen.bJt = r.cPI().cQg() ? 2 : 1;
                    authen.twf = 1;
                    authen.pGr = (PayInfo) e.this.mqu.getParcelable("key_pay_info");
                    authen.twc = e.this.mqu.getString("key_pwd1");
                    if (!e.this.mqu.getBoolean("key_has_indentity_info", false)) {
                        authen.twd = e.this.mqu.getString("key_name");
                        authen.twe = e.this.mqu.getString("key_indentity");
                    }
                    e.this.mqu.putString("key_mobile", com.tencent.mm.wallet_core.ui.e.atu(authen.tuk));
                    e.this.mqu.putBoolean("key_is_oversea", false);
                    this.Agm.a(new com.tencent.mm.plugin.wallet_core.b.a.a(authen), true, 1);
                    AppMethodBeat.o(48633);
                    return true;
                }

                public final boolean x(Object... objArr) {
                    AppMethodBeat.i(48634);
                    this.Agm.a(new t("", (String) objArr[0], (PayInfo) e.this.mqu.getParcelable("key_pay_info")), true, 1);
                    AppMethodBeat.o(48634);
                    return true;
                }
            };
            AppMethodBeat.o(48643);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48635);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof com.tencent.mm.plugin.wallet_core.b.a.b) {
                            this.Agm.a(new y(), true, 1);
                            AppMethodBeat.o(48635);
                            return true;
                        } else if (mVar instanceof y) {
                            this.Agm.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.mqu.getString("key_verify_code"), e.this.mqu.getString("KEY_SESSION_KEY"), e.this.mqu.getString("key_pwd1"), r.cPI().cQL(), e.this.mqu.getString("key_bank_type")), true, 1);
                            AppMethodBeat.o(48635);
                            return true;
                        } else if (mVar instanceof com.tencent.mm.plugin.wxcredit.a.g) {
                            String str2 = ((com.tencent.mm.plugin.wxcredit.a.g) mVar).cIe;
                            if (!bo.isNullOrNil(str2)) {
                                e.this.mqu.putString("key_bank_username", str2);
                            }
                            e.this.a(this.hwd, 0, e.this.mqu);
                            AppMethodBeat.o(48635);
                            return true;
                        }
                    }
                    AppMethodBeat.o(48635);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48636);
                    if (e.this.mqu.getBoolean("key_is_bank_user", false)) {
                        this.Agm.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.mqu.getString("key_verify_code"), e.this.mqu.getString("KEY_SESSION_KEY"), e.this.mqu.getString("key_pwd1"), r.cPI().cQL(), e.this.mqu.getString("key_bank_type")), true, 1);
                    } else {
                        this.Agm.a(new com.tencent.mm.plugin.wallet_core.b.a.b((s) objArr[0]), true, 1);
                    }
                    AppMethodBeat.o(48636);
                    return true;
                }
            };
            AppMethodBeat.o(48643);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletWXCreditOpenResultUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48637);
                    if (i == 0 && i2 == 0) {
                        e.this.a(this.hwd, 0, e.this.mqu);
                        AppMethodBeat.o(48637);
                        return true;
                    }
                    AppMethodBeat.o(48637);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48638);
                    e.this.mqu.putBoolean("key_is_follow_bank_username", ((Boolean) objArr[0]).booleanValue());
                    e.an(e.this);
                    this.Agm.a(new y(), true, 1);
                    AppMethodBeat.o(48638);
                    return true;
                }
            };
            AppMethodBeat.o(48643);
            return anonymousClass2;
        } else {
            AppMethodBeat.o(48643);
            return null;
        }
    }

    public final String bxP() {
        return "WXCreditOpenProcess";
    }
}
