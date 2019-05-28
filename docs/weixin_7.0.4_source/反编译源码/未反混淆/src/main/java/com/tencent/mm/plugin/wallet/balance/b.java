package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.pay.a.d.f;
import com.tencent.mm.plugin.wallet.pay.a.e.j;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b extends c {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45213);
        x.QN(14);
        if (activity instanceof WalletBalanceFetchUI) {
            s.cNC();
            if (!s.cND().cQg()) {
                this.mqu.putInt("key_pay_flag", 1);
                b(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.mqu.getParcelable("key_bankcard")) != null) {
                this.mqu.putInt("key_pay_flag", 3);
                this.mqu.putString("key_pwd_cash_title", activity.getString(R.string.f8z));
                Orders orders = (Orders) this.mqu.getParcelable("key_orders");
                if (orders != null) {
                    this.mqu.putString("key_pwd_cash_money", e.G(orders.pTN));
                }
                b(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.mqu.putInt("key_pay_flag", 2);
                b(activity, WalletCheckPwdUI.class, bundle);
            }
        } else {
            b(activity, WalletBalanceFetchUI.class, bundle);
        }
        AppMethodBeat.o(45213);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(45214);
        if (activity instanceof WalletBalanceFetchUI) {
            s.cNC();
            if (!s.cND().cQg()) {
                this.mqu.putInt("key_pay_flag", 1);
                b(activity, WalletBankcardIdUI.class, bundle);
                AppMethodBeat.o(45214);
            } else if (((Bankcard) this.mqu.getParcelable("key_bankcard")) != null) {
                this.mqu.putInt("key_pay_flag", 3);
                this.mqu.putString("key_pwd_cash_title", activity.getString(R.string.f8z));
                Orders orders = (Orders) this.mqu.getParcelable("key_orders");
                if (orders != null) {
                    this.mqu.putString("key_pwd_cash_money", e.G(orders.pTN));
                }
                b(activity, WalletBalanceFetchPwdInputUI.class, bundle);
                AppMethodBeat.o(45214);
            } else {
                this.mqu.putInt("key_pay_flag", 2);
                b(activity, WalletCheckPwdUI.class, bundle);
                AppMethodBeat.o(45214);
            }
        } else if (activity instanceof WalletBalanceFetchPwdInputUI) {
            if (bundle.getBoolean("key_need_verify_sms", false)) {
                b(activity, WalletVerifyCodeUI.class, bundle);
                AppMethodBeat.o(45214);
                return;
            }
            b(activity, WalletBalanceFetchResultUI.class, bundle);
            AppMethodBeat.o(45214);
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, WalletBankcardIdUI.class, bundle);
            AppMethodBeat.o(45214);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            b(activity, WalletCardElementUI.class, bundle);
            AppMethodBeat.o(45214);
        } else if (activity instanceof WalletCardElementUI) {
            b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.o(45214);
        } else if (activity instanceof WalletVerifyCodeUI) {
            s.cNC();
            if (s.cND().cQg()) {
                b(activity, WalletBalanceFetchResultUI.class, bundle);
                AppMethodBeat.o(45214);
                return;
            }
            b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.o(45214);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.o(45214);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, WalletBalanceFetchResultUI.class, bundle);
            AppMethodBeat.o(45214);
        } else {
            if (activity instanceof WalletBalanceFetchResultUI) {
                b(activity, bundle);
            }
            AppMethodBeat.o(45214);
        }
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(45215);
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
            AppMethodBeat.o(45215);
        } else if (activity instanceof WalletBalanceResultUI) {
            x.dNV();
            b(activity, this.mqu);
            AppMethodBeat.o(45215);
        } else {
            x.dNV();
            F(activity);
            AppMethodBeat.o(45215);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45216);
        a(activity, WalletBalanceManagerUI.class, -1, true);
        AppMethodBeat.o(45216);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(45217);
        g anonymousClass2;
        if (mMActivity instanceof WalletBalanceFetchUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean w(Object... objArr) {
                    String str;
                    AppMethodBeat.i(45199);
                    s.cNC();
                    b.this.mqu.putParcelable("key_history_bankcard", s.cND().tCU);
                    PayInfo payInfo = (PayInfo) b.this.mqu.get("key_pay_info");
                    i iVar = this.Agm;
                    if (payInfo == null) {
                        str = null;
                    } else {
                        str = payInfo.czZ;
                    }
                    iVar.a(new v(str), true);
                    AppMethodBeat.o(45199);
                    return false;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45200);
                    b.this.a(this.hwd, 0, b.this.mqu);
                    AppMethodBeat.o(45200);
                    return true;
                }
            };
            AppMethodBeat.o(45217);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletBalanceFetchPwdInputUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    boolean z = false;
                    AppMethodBeat.i(45201);
                    if (i == 0 && i2 == 0 && (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) mVar;
                        b.this.mqu.putString("kreq_token", bVar.token);
                        b.this.mqu.putParcelable("key_authen", bVar.toh);
                        Bundle d = b.this.mqu;
                        String str2 = "key_need_verify_sms";
                        if (!bVar.tof) {
                            z = true;
                        }
                        d.putBoolean(str2, z);
                        RealnameGuideHelper realnameGuideHelper = bVar.oYc;
                        if (realnameGuideHelper != null) {
                            b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                        }
                        if (bVar.too != null) {
                            b.this.mqu.putString("key_fetch_result_show_info", bVar.too.toString());
                        }
                        a.j(this.hwd, b.this.mqu);
                        this.hwd.finish();
                        AppMethodBeat.o(45201);
                        return true;
                    }
                    AppMethodBeat.o(45201);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45202);
                    Bankcard bankcard = (Bankcard) b.this.mqu.getParcelable("key_bankcard");
                    b.this.mqu.putString("key_pwd1", (String) objArr[0]);
                    b.this.mqu.putString("key_mobile", bankcard.field_mobile);
                    Authen authen = new Authen();
                    authen.bJt = 3;
                    authen.twc = (String) objArr[0];
                    authen.pbo = bankcard.field_bindSerial;
                    authen.pbn = bankcard.field_bankcardType;
                    authen.pGr = (PayInfo) b.this.mqu.getParcelable("key_pay_info");
                    authen.twk = bankcard.field_arrive_type;
                    this.Agm.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) b.this.mqu.getParcelable("key_orders")), true, 1);
                    AppMethodBeat.o(45202);
                    return true;
                }
            };
            AppMethodBeat.o(45217);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletCardElementUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45203);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) mVar;
                            b.this.mqu.putString("kreq_token", bVar.token);
                            if (bVar.tpw) {
                                b.this.mqu.putParcelable("key_orders", bVar.tog);
                            }
                        }
                        if (b.this.c(this.hwd, null)) {
                            this.Agm.a(new y(b.o(b.this), 13), true, 1);
                            AppMethodBeat.o(45203);
                            return true;
                        }
                        b.this.a(this.hwd, 0, b.this.mqu);
                        AppMethodBeat.o(45203);
                        return true;
                    }
                    AppMethodBeat.o(45203);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45204);
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    switch (b.this.mqu.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (!b.this.cRY()) {
                                authen.bJt = 1;
                                break;
                            }
                            authen.bJt = 4;
                            break;
                        case 2:
                            if (!b.this.cRY()) {
                                authen.bJt = 2;
                                break;
                            }
                            authen.bJt = 5;
                            break;
                        case 3:
                            if (!b.this.cRY()) {
                                authen.bJt = 3;
                                break;
                            }
                            authen.bJt = 6;
                            break;
                        default:
                            AppMethodBeat.o(45204);
                            return false;
                    }
                    b.this.mqu.putParcelable("key_authen", authen);
                    this.Agm.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                    AppMethodBeat.o(45204);
                    return true;
                }
            };
            AppMethodBeat.o(45217);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45205);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof f) {
                            f fVar = (f) mVar;
                            if (fVar.tpw) {
                                b.this.mqu.putParcelable("key_orders", fVar.tog);
                            }
                            a.j(this.hwd, b.this.mqu);
                            AppMethodBeat.o(45205);
                            return true;
                        } else if (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) mVar;
                            RealnameGuideHelper realnameGuideHelper = bVar.oYc;
                            if (realnameGuideHelper != null) {
                                b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                            b.this.mqu.putString("kreq_token", bVar.token);
                            AppMethodBeat.o(45205);
                            return true;
                        }
                    }
                    AppMethodBeat.o(45205);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45206);
                    com.tencent.mm.plugin.wallet_core.model.s sVar = (com.tencent.mm.plugin.wallet_core.model.s) objArr[1];
                    if (!(sVar == null || sVar.pGr == null)) {
                        sVar.pGr.cIf = 21;
                    }
                    Orders orders = (Orders) b.this.mqu.getParcelable("key_orders");
                    switch (b.this.mqu.getInt("key_pay_flag", 0)) {
                        case 1:
                            sVar.flag = "1";
                            break;
                        case 2:
                            if (!b.this.cRY()) {
                                sVar.flag = "2";
                                break;
                            }
                            sVar.flag = "5";
                            break;
                        case 3:
                            if (!b.this.cRY()) {
                                sVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                                break;
                            }
                            sVar.flag = "6";
                            break;
                        default:
                            AppMethodBeat.o(45206);
                            return false;
                    }
                    this.Agm.a(new f(sVar, orders), true, 1);
                    AppMethodBeat.o(45206);
                    return true;
                }

                public final boolean x(Object... objArr) {
                    AppMethodBeat.i(45207);
                    Authen authen = (Authen) b.this.mqu.getParcelable("key_authen");
                    this.Agm.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) b.this.mqu.getParcelable("key_orders")), true, 1);
                    AppMethodBeat.o(45207);
                    return true;
                }
            };
            AppMethodBeat.o(45217);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletBalanceFetchResultUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean w(Object... objArr) {
                    AppMethodBeat.i(45208);
                    Orders orders = (Orders) b.this.mqu.getParcelable("key_orders");
                    Bankcard bankcard = r.cPI().thy;
                    bankcard.twS -= orders.pTN;
                    b.this.mqu.putInt("key_balance_result_logo", R.raw.remittance_wait);
                    boolean w = super.w(objArr);
                    AppMethodBeat.o(45208);
                    return w;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }

                public final boolean p(Object... objArr) {
                    return false;
                }

                public final CharSequence Au(int i) {
                    CharSequence string;
                    AppMethodBeat.i(45209);
                    Orders orders;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(R.string.f9k);
                            AppMethodBeat.o(45209);
                            return string;
                        case 1:
                            orders = (Orders) b.this.mqu.getParcelable("key_orders");
                            if (orders == null || bo.isNullOrNil(orders.tAl)) {
                                string = this.hwd.getString(R.string.f9h);
                                AppMethodBeat.o(45209);
                                return string;
                            }
                            string = orders.tAl;
                            AppMethodBeat.o(45209);
                            return string;
                        case 2:
                            orders = (Orders) b.this.mqu.getParcelable("key_orders");
                            if (orders != null && orders.tAk > 0) {
                                string = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orders.tAk));
                                AppMethodBeat.o(45209);
                                return string;
                            }
                    }
                    string = super.Au(i);
                    AppMethodBeat.o(45209);
                    return string;
                }
            };
            AppMethodBeat.o(45217);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45210);
                    if (i == 0 && i2 == 0 && (mVar instanceof j)) {
                        j jVar = (j) mVar;
                        if (jVar.tpw) {
                            b.this.mqu.putParcelable("key_orders", jVar.tog);
                        }
                        b.this.a(this.hwd, 0, b.this.mqu);
                        AppMethodBeat.o(45210);
                        return true;
                    }
                    AppMethodBeat.o(45210);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45211);
                    this.Agm.a(new j((com.tencent.mm.plugin.wallet_core.model.s) objArr[0], (Orders) b.this.mqu.getParcelable("key_orders")), true, 1);
                    AppMethodBeat.o(45211);
                    return true;
                }

                public final /* synthetic */ CharSequence Au(int i) {
                    AppMethodBeat.i(45212);
                    String string = this.hwd.getString(R.string.ftd);
                    AppMethodBeat.o(45212);
                    return string;
                }
            };
            AppMethodBeat.o(45217);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(45217);
            return anonymousClass2;
        }
    }

    public final int a(MMActivity mMActivity, int i) {
        return R.string.f8u;
    }

    public final String bxP() {
        return "BalanceFetchProcess";
    }

    static /* synthetic */ String o(b bVar) {
        String str;
        AppMethodBeat.i(45218);
        if (bVar.mqu != null) {
            PayInfo payInfo = (PayInfo) bVar.mqu.getParcelable("key_pay_info");
            if (payInfo != null) {
                str = payInfo.czZ;
                AppMethodBeat.o(45218);
                return str;
            }
        }
        str = "";
        AppMethodBeat.o(45218);
        return str;
    }
}
