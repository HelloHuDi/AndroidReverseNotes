package com.tencent.p177mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.p560b.p1050a.C14221a;
import com.tencent.p177mm.plugin.wallet_core.p560b.p1050a.C29614b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSetPasswordUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletVerifyCodeUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14225t;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22563q;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C23209b;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C23210h;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C30023a;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C30024g;
import com.tencent.p177mm.plugin.wxcredit.p590ui.WalletBindDepositUI;
import com.tencent.p177mm.plugin.wxcredit.p590ui.WalletCheckIdentityUI;
import com.tencent.p177mm.plugin.wxcredit.p590ui.WalletWXCreditOpenResultUI;
import com.tencent.p177mm.plugin.wxcredit.p590ui.WalletWXCreditOpenUI;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wxcredit.e */
public class C44028e extends C40931c {
    /* renamed from: an */
    static /* synthetic */ boolean m79067an(C44028e c44028e) {
        AppMethodBeat.m2504i(48644);
        boolean dNI = c44028e.dNI();
        AppMethodBeat.m2505o(48644);
        return dNI;
    }

    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48639);
        if (!C14241r.cPI().cQl()) {
            if (C14241r.cPI().cQg()) {
                mo64571b(activity, WalletCheckPwdUI.class, bundle);
            } else {
                mo64571b(activity, WalletWXCreditOpenUI.class, bundle);
            }
        }
        AppMethodBeat.m2505o(48639);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48640);
        if (activity instanceof WalletWXCreditOpenUI) {
            mo64571b(activity, WalletCheckIdentityUI.class, bundle);
            AppMethodBeat.m2505o(48640);
        } else if (activity instanceof WalletCheckPwdUI) {
            mo55241F(activity);
            mo64571b(activity, WalletWXCreditOpenUI.class, bundle);
            AppMethodBeat.m2505o(48640);
        } else if (activity instanceof WalletWXCreditOpenUI) {
            mo64571b(activity, WalletCheckIdentityUI.class, bundle);
            AppMethodBeat.m2505o(48640);
        } else if (activity instanceof WalletCheckIdentityUI) {
            if (bundle.getBoolean("key_need_bind_deposit", true)) {
                mo64571b(activity, WalletBindDepositUI.class, bundle);
                AppMethodBeat.m2505o(48640);
                return;
            }
            mo64571b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.m2505o(48640);
        } else if (activity instanceof WalletBindDepositUI) {
            mo64571b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.m2505o(48640);
        } else if (activity instanceof WalletVerifyCodeUI) {
            if (C14241r.cPI().cQg()) {
                mo64571b(activity, WalletWXCreditOpenResultUI.class, bundle);
                AppMethodBeat.m2505o(48640);
                return;
            }
            mo64571b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.m2505o(48640);
        } else if (activity instanceof WalletSetPasswordUI) {
            mo64571b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.m2505o(48640);
        } else if (activity instanceof WalletPwdConfirmUI) {
            mo64571b(activity, WalletWXCreditOpenResultUI.class, bundle);
            AppMethodBeat.m2505o(48640);
        } else {
            if (activity instanceof WalletWXCreditOpenResultUI) {
                mo8125b(activity, bundle);
            }
            AppMethodBeat.m2505o(48640);
        }
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(48641);
        mo55241F(activity);
        AppMethodBeat.m2505o(48641);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48642);
        mo64575d(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
        AppMethodBeat.m2505o(48642);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48643);
        C44432g c47072;
        if (mMActivity instanceof WalletCheckPwdUI) {
            C148161 c148161 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48625);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C23209b) {
                            C23209b c23209b = (C23209b) c1207m;
                            C44028e.this.mqu.putString("KEY_SESSION_KEY", c23209b.token);
                            C44028e.this.mqu.putString("key_pre_name", c23209b.name);
                            C44028e.this.mqu.putString("key_pre_indentity", c23209b.uYt);
                            C44028e.this.mqu.putBoolean("key_has_indentity_info", c23209b.uYu);
                        }
                        C44028e.this.mo8124a(this.hwd, 0, C44028e.this.mqu);
                        AppMethodBeat.m2505o(48625);
                        return true;
                    }
                    AppMethodBeat.m2505o(48625);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    int i = 0;
                    AppMethodBeat.m2504i(48626);
                    C44028e.this.mqu.putString("key_pwd1", (String) objArr[0]);
                    C30868i c30868i = this.Agm;
                    String str = (String) objArr[0];
                    if (objArr[1] != null) {
                        i = C5046bo.ank((String) objArr[1]);
                    }
                    c30868i.mo49367a(new C23209b(str, i, C44028e.this.mqu.getString("key_bank_type")), true, 1);
                    AppMethodBeat.m2505o(48626);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48643);
            return c148161;
        } else if (mMActivity instanceof WalletCheckIdentityUI) {
            c47072 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48627);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C30023a) {
                            C30023a c30023a = (C30023a) c1207m;
                            C44028e.this.mqu.putString("KEY_SESSION_KEY", c30023a.token);
                            C44028e.this.mqu.putString("key_mobile", c30023a.cFl);
                            C44028e.this.mqu.putBoolean("key_need_bind_deposit", c30023a.cQU);
                            C44028e.this.mqu.putBoolean("key_is_bank_user", c30023a.uYs);
                        }
                        C44028e.this.mo8124a(this.hwd, 0, C44028e.this.mqu);
                        AppMethodBeat.m2505o(48627);
                        return true;
                    }
                    AppMethodBeat.m2505o(48627);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48628);
                    String str = (String) objArr[0];
                    String str2 = (String) objArr[1];
                    C44028e.this.mqu.putString("key_name", str);
                    C44028e.this.mqu.putString("key_indentity", str2);
                    this.Agm.mo49367a(new C30023a(str, str2, C44028e.this.mqu.getString("KEY_SESSION_KEY"), C44028e.this.mqu.getString("key_bank_type")), true, 1);
                    AppMethodBeat.m2505o(48628);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48643);
            return c47072;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            c47072 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48629);
                    if (i != 0 || i2 != 0) {
                        AppMethodBeat.m2505o(48629);
                        return false;
                    } else if (c1207m instanceof C30024g) {
                        String str2 = ((C30024g) c1207m).cIe;
                        if (!C5046bo.isNullOrNil(str2)) {
                            C44028e.this.mqu.putString("key_bank_username", str2);
                        }
                        C44028e.this.mo8124a(this.hwd, 0, C44028e.this.mqu);
                        AppMethodBeat.m2505o(48629);
                        return true;
                    } else if (c1207m instanceof C23210h) {
                        C44028e.this.mo8124a(this.hwd, 0, C44028e.this.mqu);
                        AppMethodBeat.m2505o(48629);
                        return true;
                    } else if (c1207m instanceof C22563q) {
                        if (C14241r.cPI().cQg()) {
                            this.Agm.mo49367a(new C35475y(), true, 1);
                            AppMethodBeat.m2505o(48629);
                            return true;
                        }
                        C44028e.this.mo8124a(this.hwd, 0, C44028e.this.mqu);
                        AppMethodBeat.m2505o(48629);
                        return true;
                    } else if (c1207m instanceof C35475y) {
                        this.Agm.mo49367a(new C30024g(C44028e.this.mqu.getString("key_verify_code"), C44028e.this.mqu.getString("KEY_SESSION_KEY"), C44028e.this.mqu.getString("key_pwd1"), C14241r.cPI().cQL(), C44028e.this.mqu.getString("key_bank_type")), true, 1);
                        AppMethodBeat.m2505o(48629);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(48629);
                        return false;
                    }
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48630);
                    String str = (String) objArr[0];
                    C44028e.this.mqu.putString("key_verify_code", str);
                    C14264s c14264s;
                    if (C14241r.cPI().cQg()) {
                        if (!C44028e.this.mqu.getBoolean("key_need_bind_deposit", true) || C44028e.this.mqu.getBoolean("key_is_bank_user")) {
                            this.Agm.mo49367a(new C30024g(str, C44028e.this.mqu.getString("KEY_SESSION_KEY"), C44028e.this.mqu.getString("key_pwd1"), C44028e.this.mqu.getString("key_bind_serial"), C44028e.this.mqu.getString("key_bank_type")), true, 1);
                        } else {
                            c14264s = (C14264s) objArr[1];
                            c14264s.flag = "2";
                            this.Agm.mo49367a(new C22563q(c14264s), true, 1);
                        }
                    } else if (C44028e.this.mqu.getBoolean("key_is_bank_user", false)) {
                        C44028e.this.mqu.putString("key_verify_code", str);
                        this.Agm.mo49367a(new C23210h(str, C44028e.this.mqu.getString("KEY_SESSION_KEY"), C44028e.this.mqu.getString("key_pwd1"), C44028e.this.mqu.getString("key_bind_serial"), C44028e.this.mqu.getString("key_bank_type")), true, 1);
                    } else {
                        c14264s = (C14264s) objArr[1];
                        c14264s.flag = "1";
                        this.Agm.mo49367a(new C22563q(c14264s), true, 1);
                    }
                    AppMethodBeat.m2505o(48630);
                    return true;
                }

                /* renamed from: Au */
                public final /* synthetic */ CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(48631);
                    if (C44028e.this.mqu.getBoolean("key_is_bank_user", false)) {
                        Bankcard bankcard = (Bankcard) C44028e.this.mqu.getParcelable("key_bankcard");
                        String string = this.hwd.getString(C25738R.string.fum, new Object[]{bankcard.field_bankName, bankcard.field_bankName, C44028e.this.mqu.getString("key_mobile")});
                        AppMethodBeat.m2505o(48631);
                        return string;
                    }
                    CharSequence string2 = this.hwd.getString(C25738R.string.fun, new Object[]{C44028e.this.mqu.getString("key_mobile")});
                    AppMethodBeat.m2505o(48631);
                    return string2;
                }
            };
            AppMethodBeat.m2505o(48643);
            return c47072;
        } else if (mMActivity instanceof WalletBindDepositUI) {
            c47072 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48632);
                    if (i == 0 && i2 == 0 && (c1207m instanceof C14221a)) {
                        C14221a c14221a = (C14221a) c1207m;
                        new StringBuilder("reqKey  ").append(c14221a.tos);
                        C44028e.this.mqu.putString("kreq_token", c14221a.token);
                        C44028e.this.mo8124a(this.hwd, 0, C44028e.this.mqu);
                        AppMethodBeat.m2505o(48632);
                        return true;
                    }
                    AppMethodBeat.m2505o(48632);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48633);
                    C40148d.cSP();
                    Authen authen = new Authen();
                    authen.twg = (String) objArr[0];
                    authen.pbn = (String) objArr[1];
                    authen.tuk = (String) objArr[2];
                    C44028e.this.mqu.putString("key_bank_phone", (String) objArr[3]);
                    authen.bJt = C14241r.cPI().cQg() ? 2 : 1;
                    authen.twf = 1;
                    authen.pGr = (PayInfo) C44028e.this.mqu.getParcelable("key_pay_info");
                    authen.twc = C44028e.this.mqu.getString("key_pwd1");
                    if (!C44028e.this.mqu.getBoolean("key_has_indentity_info", false)) {
                        authen.twd = C44028e.this.mqu.getString("key_name");
                        authen.twe = C44028e.this.mqu.getString("key_indentity");
                    }
                    C44028e.this.mqu.putString("key_mobile", C36391e.atu(authen.tuk));
                    C44028e.this.mqu.putBoolean("key_is_oversea", false);
                    this.Agm.mo49367a(new C14221a(authen), true, 1);
                    AppMethodBeat.m2505o(48633);
                    return true;
                }

                /* renamed from: x */
                public final boolean mo38265x(Object... objArr) {
                    AppMethodBeat.m2504i(48634);
                    this.Agm.mo49367a(new C14225t("", (String) objArr[0], (PayInfo) C44028e.this.mqu.getParcelable("key_pay_info")), true, 1);
                    AppMethodBeat.m2505o(48634);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48643);
            return c47072;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            c47072 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48635);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C29614b) {
                            this.Agm.mo49367a(new C35475y(), true, 1);
                            AppMethodBeat.m2505o(48635);
                            return true;
                        } else if (c1207m instanceof C35475y) {
                            this.Agm.mo49367a(new C30024g(C44028e.this.mqu.getString("key_verify_code"), C44028e.this.mqu.getString("KEY_SESSION_KEY"), C44028e.this.mqu.getString("key_pwd1"), C14241r.cPI().cQL(), C44028e.this.mqu.getString("key_bank_type")), true, 1);
                            AppMethodBeat.m2505o(48635);
                            return true;
                        } else if (c1207m instanceof C30024g) {
                            String str2 = ((C30024g) c1207m).cIe;
                            if (!C5046bo.isNullOrNil(str2)) {
                                C44028e.this.mqu.putString("key_bank_username", str2);
                            }
                            C44028e.this.mo8124a(this.hwd, 0, C44028e.this.mqu);
                            AppMethodBeat.m2505o(48635);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(48635);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48636);
                    if (C44028e.this.mqu.getBoolean("key_is_bank_user", false)) {
                        this.Agm.mo49367a(new C30024g(C44028e.this.mqu.getString("key_verify_code"), C44028e.this.mqu.getString("KEY_SESSION_KEY"), C44028e.this.mqu.getString("key_pwd1"), C14241r.cPI().cQL(), C44028e.this.mqu.getString("key_bank_type")), true, 1);
                    } else {
                        this.Agm.mo49367a(new C29614b((C14264s) objArr[0]), true, 1);
                    }
                    AppMethodBeat.m2505o(48636);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48643);
            return c47072;
        } else if (mMActivity instanceof WalletWXCreditOpenResultUI) {
            c47072 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48637);
                    if (i == 0 && i2 == 0) {
                        C44028e.this.mo8124a(this.hwd, 0, C44028e.this.mqu);
                        AppMethodBeat.m2505o(48637);
                        return true;
                    }
                    AppMethodBeat.m2505o(48637);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48638);
                    C44028e.this.mqu.putBoolean("key_is_follow_bank_username", ((Boolean) objArr[0]).booleanValue());
                    C44028e.m79067an(C44028e.this);
                    this.Agm.mo49367a(new C35475y(), true, 1);
                    AppMethodBeat.m2505o(48638);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48643);
            return c47072;
        } else {
            AppMethodBeat.m2505o(48643);
            return null;
        }
    }

    public final String bxP() {
        return "WXCreditOpenProcess";
    }
}
