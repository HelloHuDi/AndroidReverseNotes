package com.tencent.p177mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceFetchPwdInputUI;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceFetchResultUI;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceFetchUI;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceManagerUI;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceResultUI;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C22531f;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C14157b;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C31457j;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletBankcardIdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCardElementUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletConfirmCardIDUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSetPasswordUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletVerifyCodeUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.p749c.C36836v;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.plugin.wallet.balance.b */
public class C41322b extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45213);
        C36379x.m59950QN(14);
        if (activity instanceof WalletBalanceFetchUI) {
            C46332s.cNC();
            if (!C46332s.cND().cQg()) {
                this.mqu.putInt("key_pay_flag", 1);
                mo64571b(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.mqu.getParcelable("key_bankcard")) != null) {
                this.mqu.putInt("key_pay_flag", 3);
                this.mqu.putString("key_pwd_cash_title", activity.getString(C25738R.string.f8z));
                Orders orders = (Orders) this.mqu.getParcelable("key_orders");
                if (orders != null) {
                    this.mqu.putString("key_pwd_cash_money", C36391e.m59972G(orders.pTN));
                }
                mo64571b(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.mqu.putInt("key_pay_flag", 2);
                mo64571b(activity, WalletCheckPwdUI.class, bundle);
            }
        } else {
            mo64571b(activity, WalletBalanceFetchUI.class, bundle);
        }
        AppMethodBeat.m2505o(45213);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(45214);
        if (activity instanceof WalletBalanceFetchUI) {
            C46332s.cNC();
            if (!C46332s.cND().cQg()) {
                this.mqu.putInt("key_pay_flag", 1);
                mo64571b(activity, WalletBankcardIdUI.class, bundle);
                AppMethodBeat.m2505o(45214);
            } else if (((Bankcard) this.mqu.getParcelable("key_bankcard")) != null) {
                this.mqu.putInt("key_pay_flag", 3);
                this.mqu.putString("key_pwd_cash_title", activity.getString(C25738R.string.f8z));
                Orders orders = (Orders) this.mqu.getParcelable("key_orders");
                if (orders != null) {
                    this.mqu.putString("key_pwd_cash_money", C36391e.m59972G(orders.pTN));
                }
                mo64571b(activity, WalletBalanceFetchPwdInputUI.class, bundle);
                AppMethodBeat.m2505o(45214);
            } else {
                this.mqu.putInt("key_pay_flag", 2);
                mo64571b(activity, WalletCheckPwdUI.class, bundle);
                AppMethodBeat.m2505o(45214);
            }
        } else if (activity instanceof WalletBalanceFetchPwdInputUI) {
            if (bundle.getBoolean("key_need_verify_sms", false)) {
                mo64571b(activity, WalletVerifyCodeUI.class, bundle);
                AppMethodBeat.m2505o(45214);
                return;
            }
            mo64571b(activity, WalletBalanceFetchResultUI.class, bundle);
            AppMethodBeat.m2505o(45214);
        } else if (activity instanceof WalletCheckPwdUI) {
            mo64571b(activity, WalletBankcardIdUI.class, bundle);
            AppMethodBeat.m2505o(45214);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            mo64571b(activity, WalletCardElementUI.class, bundle);
            AppMethodBeat.m2505o(45214);
        } else if (activity instanceof WalletCardElementUI) {
            mo64571b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.m2505o(45214);
        } else if (activity instanceof WalletVerifyCodeUI) {
            C46332s.cNC();
            if (C46332s.cND().cQg()) {
                mo64571b(activity, WalletBalanceFetchResultUI.class, bundle);
                AppMethodBeat.m2505o(45214);
                return;
            }
            mo64571b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.m2505o(45214);
        } else if (activity instanceof WalletSetPasswordUI) {
            mo64571b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.m2505o(45214);
        } else if (activity instanceof WalletPwdConfirmUI) {
            mo64571b(activity, WalletBalanceFetchResultUI.class, bundle);
            AppMethodBeat.m2505o(45214);
        } else {
            if (activity instanceof WalletBalanceFetchResultUI) {
                mo8125b(activity, bundle);
            }
            AppMethodBeat.m2505o(45214);
        }
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(45215);
        if (activity instanceof WalletPwdConfirmUI) {
            mo64558a(activity, WalletSetPasswordUI.class, i);
            AppMethodBeat.m2505o(45215);
        } else if (activity instanceof WalletBalanceResultUI) {
            C36379x.dNV();
            mo8125b(activity, this.mqu);
            AppMethodBeat.m2505o(45215);
        } else {
            C36379x.dNV();
            mo55241F(activity);
            AppMethodBeat.m2505o(45215);
        }
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45216);
        mo64560a(activity, WalletBalanceManagerUI.class, -1, true);
        AppMethodBeat.m2505o(45216);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(45217);
        C44432g c141162;
        if (mMActivity instanceof WalletBalanceFetchUI) {
            C295431 c295431 = new C44432g(mMActivity, c30868i) {
                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    String str;
                    AppMethodBeat.m2504i(45199);
                    C46332s.cNC();
                    C41322b.this.mqu.putParcelable("key_history_bankcard", C46332s.cND().tCU);
                    PayInfo payInfo = (PayInfo) C41322b.this.mqu.get("key_pay_info");
                    C30868i c30868i = this.Agm;
                    if (payInfo == null) {
                        str = null;
                    } else {
                        str = payInfo.czZ;
                    }
                    c30868i.mo36581a(new C36836v(str), true);
                    AppMethodBeat.m2505o(45199);
                    return false;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45200);
                    C41322b.this.mo8124a(this.hwd, 0, C41322b.this.mqu);
                    AppMethodBeat.m2505o(45200);
                    return true;
                }
            };
            AppMethodBeat.m2505o(45217);
            return c295431;
        } else if (mMActivity instanceof WalletBalanceFetchPwdInputUI) {
            c141162 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    boolean z = false;
                    AppMethodBeat.m2504i(45201);
                    if (i == 0 && i2 == 0 && (c1207m instanceof C14157b)) {
                        C14157b c14157b = (C14157b) c1207m;
                        C41322b.this.mqu.putString("kreq_token", c14157b.token);
                        C41322b.this.mqu.putParcelable("key_authen", c14157b.toh);
                        Bundle d = C41322b.this.mqu;
                        String str2 = "key_need_verify_sms";
                        if (!c14157b.tof) {
                            z = true;
                        }
                        d.putBoolean(str2, z);
                        RealnameGuideHelper realnameGuideHelper = c14157b.oYc;
                        if (realnameGuideHelper != null) {
                            C41322b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                        }
                        if (c14157b.too != null) {
                            C41322b.this.mqu.putString("key_fetch_result_show_info", c14157b.too.toString());
                        }
                        C24143a.m37116j(this.hwd, C41322b.this.mqu);
                        this.hwd.finish();
                        AppMethodBeat.m2505o(45201);
                        return true;
                    }
                    AppMethodBeat.m2505o(45201);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45202);
                    Bankcard bankcard = (Bankcard) C41322b.this.mqu.getParcelable("key_bankcard");
                    C41322b.this.mqu.putString("key_pwd1", (String) objArr[0]);
                    C41322b.this.mqu.putString("key_mobile", bankcard.field_mobile);
                    Authen authen = new Authen();
                    authen.bJt = 3;
                    authen.twc = (String) objArr[0];
                    authen.pbo = bankcard.field_bindSerial;
                    authen.pbn = bankcard.field_bankcardType;
                    authen.pGr = (PayInfo) C41322b.this.mqu.getParcelable("key_pay_info");
                    authen.twk = bankcard.field_arrive_type;
                    this.Agm.mo49367a(new C14157b(authen, (Orders) C41322b.this.mqu.getParcelable("key_orders")), true, 1);
                    AppMethodBeat.m2505o(45202);
                    return true;
                }
            };
            AppMethodBeat.m2505o(45217);
            return c141162;
        } else if (mMActivity instanceof WalletCardElementUI) {
            c141162 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45203);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C14157b) {
                            C14157b c14157b = (C14157b) c1207m;
                            C41322b.this.mqu.putString("kreq_token", c14157b.token);
                            if (c14157b.tpw) {
                                C41322b.this.mqu.putParcelable("key_orders", c14157b.tog);
                            }
                        }
                        if (C41322b.this.mo8128c(this.hwd, null)) {
                            this.Agm.mo49367a(new C35475y(C41322b.m72035o(C41322b.this), 13), true, 1);
                            AppMethodBeat.m2505o(45203);
                            return true;
                        }
                        C41322b.this.mo8124a(this.hwd, 0, C41322b.this.mqu);
                        AppMethodBeat.m2505o(45203);
                        return true;
                    }
                    AppMethodBeat.m2505o(45203);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45204);
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    switch (C41322b.this.mqu.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (!C41322b.this.cRY()) {
                                authen.bJt = 1;
                                break;
                            }
                            authen.bJt = 4;
                            break;
                        case 2:
                            if (!C41322b.this.cRY()) {
                                authen.bJt = 2;
                                break;
                            }
                            authen.bJt = 5;
                            break;
                        case 3:
                            if (!C41322b.this.cRY()) {
                                authen.bJt = 3;
                                break;
                            }
                            authen.bJt = 6;
                            break;
                        default:
                            AppMethodBeat.m2505o(45204);
                            return false;
                    }
                    C41322b.this.mqu.putParcelable("key_authen", authen);
                    this.Agm.mo49367a(new C14157b(authen, orders), true, 1);
                    AppMethodBeat.m2505o(45204);
                    return true;
                }
            };
            AppMethodBeat.m2505o(45217);
            return c141162;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            c141162 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45205);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C22531f) {
                            C22531f c22531f = (C22531f) c1207m;
                            if (c22531f.tpw) {
                                C41322b.this.mqu.putParcelable("key_orders", c22531f.tog);
                            }
                            C24143a.m37116j(this.hwd, C41322b.this.mqu);
                            AppMethodBeat.m2505o(45205);
                            return true;
                        } else if (c1207m instanceof C14157b) {
                            C14157b c14157b = (C14157b) c1207m;
                            RealnameGuideHelper realnameGuideHelper = c14157b.oYc;
                            if (realnameGuideHelper != null) {
                                C41322b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                            C41322b.this.mqu.putString("kreq_token", c14157b.token);
                            AppMethodBeat.m2505o(45205);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(45205);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45206);
                    C14264s c14264s = (C14264s) objArr[1];
                    if (!(c14264s == null || c14264s.pGr == null)) {
                        c14264s.pGr.cIf = 21;
                    }
                    Orders orders = (Orders) C41322b.this.mqu.getParcelable("key_orders");
                    switch (C41322b.this.mqu.getInt("key_pay_flag", 0)) {
                        case 1:
                            c14264s.flag = "1";
                            break;
                        case 2:
                            if (!C41322b.this.cRY()) {
                                c14264s.flag = "2";
                                break;
                            }
                            c14264s.flag = "5";
                            break;
                        case 3:
                            if (!C41322b.this.cRY()) {
                                c14264s.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                                break;
                            }
                            c14264s.flag = "6";
                            break;
                        default:
                            AppMethodBeat.m2505o(45206);
                            return false;
                    }
                    this.Agm.mo49367a(new C22531f(c14264s, orders), true, 1);
                    AppMethodBeat.m2505o(45206);
                    return true;
                }

                /* renamed from: x */
                public final boolean mo38265x(Object... objArr) {
                    AppMethodBeat.m2504i(45207);
                    Authen authen = (Authen) C41322b.this.mqu.getParcelable("key_authen");
                    this.Agm.mo49367a(new C14157b(authen, (Orders) C41322b.this.mqu.getParcelable("key_orders")), true, 1);
                    AppMethodBeat.m2505o(45207);
                    return true;
                }
            };
            AppMethodBeat.m2505o(45217);
            return c141162;
        } else if (mMActivity instanceof WalletBalanceFetchResultUI) {
            c141162 = new C44432g(mMActivity, c30868i) {
                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    AppMethodBeat.m2504i(45208);
                    Orders orders = (Orders) C41322b.this.mqu.getParcelable("key_orders");
                    Bankcard bankcard = C14241r.cPI().thy;
                    bankcard.twS -= orders.pTN;
                    C41322b.this.mqu.putInt("key_balance_result_logo", C1318a.remittance_wait);
                    boolean w = super.mo9367w(objArr);
                    AppMethodBeat.m2505o(45208);
                    return w;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    return false;
                }

                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    CharSequence string;
                    AppMethodBeat.m2504i(45209);
                    Orders orders;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(C25738R.string.f9k);
                            AppMethodBeat.m2505o(45209);
                            return string;
                        case 1:
                            orders = (Orders) C41322b.this.mqu.getParcelable("key_orders");
                            if (orders == null || C5046bo.isNullOrNil(orders.tAl)) {
                                string = this.hwd.getString(C25738R.string.f9h);
                                AppMethodBeat.m2505o(45209);
                                return string;
                            }
                            string = orders.tAl;
                            AppMethodBeat.m2505o(45209);
                            return string;
                        case 2:
                            orders = (Orders) C41322b.this.mqu.getParcelable("key_orders");
                            if (orders != null && orders.tAk > 0) {
                                string = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orders.tAk));
                                AppMethodBeat.m2505o(45209);
                                return string;
                            }
                    }
                    string = super.mo9364Au(i);
                    AppMethodBeat.m2505o(45209);
                    return string;
                }
            };
            AppMethodBeat.m2505o(45217);
            return c141162;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            c141162 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45210);
                    if (i == 0 && i2 == 0 && (c1207m instanceof C31457j)) {
                        C31457j c31457j = (C31457j) c1207m;
                        if (c31457j.tpw) {
                            C41322b.this.mqu.putParcelable("key_orders", c31457j.tog);
                        }
                        C41322b.this.mo8124a(this.hwd, 0, C41322b.this.mqu);
                        AppMethodBeat.m2505o(45210);
                        return true;
                    }
                    AppMethodBeat.m2505o(45210);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45211);
                    this.Agm.mo49367a(new C31457j((C14264s) objArr[0], (Orders) C41322b.this.mqu.getParcelable("key_orders")), true, 1);
                    AppMethodBeat.m2505o(45211);
                    return true;
                }

                /* renamed from: Au */
                public final /* synthetic */ CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(45212);
                    String string = this.hwd.getString(C25738R.string.ftd);
                    AppMethodBeat.m2505o(45212);
                    return string;
                }
            };
            AppMethodBeat.m2505o(45217);
            return c141162;
        } else {
            c141162 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(45217);
            return c141162;
        }
    }

    /* renamed from: a */
    public final int mo26468a(MMActivity mMActivity, int i) {
        return C25738R.string.f8u;
    }

    public final String bxP() {
        return "BalanceFetchProcess";
    }

    /* renamed from: o */
    static /* synthetic */ String m72035o(C41322b c41322b) {
        String str;
        AppMethodBeat.m2504i(45218);
        if (c41322b.mqu != null) {
            PayInfo payInfo = (PayInfo) c41322b.mqu.getParcelable("key_pay_info");
            if (payInfo != null) {
                str = payInfo.czZ;
                AppMethodBeat.m2505o(45218);
                return str;
            }
        }
        str = "";
        AppMethodBeat.m2505o(45218);
        return str;
    }
}
