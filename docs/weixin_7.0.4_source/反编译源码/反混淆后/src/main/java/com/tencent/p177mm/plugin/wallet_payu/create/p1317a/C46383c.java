package com.tencent.p177mm.plugin.wallet_payu.create.p1317a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_payu.create.p569ui.WalletPayUStartOpenUI;
import com.tencent.p177mm.plugin.wallet_payu.create.p569ui.WalletPayUVerifyCodeUI;
import com.tencent.p177mm.plugin.wallet_payu.p1561a.C40156b;
import com.tencent.p177mm.plugin.wallet_payu.p1561a.C46381a;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui.WalletPayUPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui.WalletPayUSetPasswordUI;
import com.tencent.p177mm.plugin.wallet_payu.security_question.model.C22711a;
import com.tencent.p177mm.plugin.wallet_payu.security_question.model.C43830d;
import com.tencent.p177mm.plugin.wallet_payu.security_question.p574ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.p177mm.plugin.wallet_payu.security_question.p574ui.WalletPayUSecurityQuestionSettingUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_payu.create.a.c */
public class C46383c extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48382);
        C4990ab.m7410d("MicroMsg.PayUOpenProcess", "hy: start process PayUOpenProcess");
        C46332s.cNC();
        String agi = C46332s.agi();
        C46332s.cNC();
        String cNE = C46332s.cNE();
        if (bundle != null) {
            bundle.putString("key_mobile", agi);
            bundle.putString("dial_code", cNE);
        }
        mo64571b(activity, WalletPayUStartOpenUI.class, bundle);
        AppMethodBeat.m2505o(48382);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48383);
        if (activity instanceof WalletPayUStartOpenUI) {
            mo64571b(activity, WalletPayUVerifyCodeUI.class, bundle);
        }
        if (activity instanceof WalletPayUVerifyCodeUI) {
            if (bundle.getBoolean("key_is_has_mobile")) {
                mo64571b(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
            } else {
                mo64571b(activity, WalletPayUSecurityQuestionSettingUI.class, bundle);
            }
        }
        if (activity instanceof WalletPayUSecurityQuestionSettingUI) {
            mo64571b(activity, WalletPayUSetPasswordUI.class, bundle);
        }
        if (activity instanceof WalletPayUSetPasswordUI) {
            mo64571b(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            mo64571b(activity, WalletPayUSetPasswordUI.class, bundle);
        }
        AppMethodBeat.m2505o(48383);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(48384);
        if (activity instanceof WalletPayUPwdConfirmUI) {
            mo64558a(activity, WalletPayUSetPasswordUI.class, i);
            AppMethodBeat.m2505o(48384);
            return;
        }
        mo8125b(activity, this.mqu);
        AppMethodBeat.m2505o(48384);
    }

    /* renamed from: h */
    public final boolean mo38264h(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48385);
        bundle.putInt("key_open_error_code", 1);
        C23639t.makeText(activity, activity.getString(C25738R.string.fpi), 0).show();
        mo8125b(activity, bundle);
        AppMethodBeat.m2505o(48385);
        return true;
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48386);
        if (bundle.getInt("key_open_error_code", -1) == 0) {
            C4990ab.m7416i("MicroMsg.PayUOpenProcess", "hy: user open success");
            mo64575d(activity, "mall", ".ui.MallIndexUI");
            AppMethodBeat.m2505o(48386);
            return;
        }
        C4990ab.m7416i("MicroMsg.PayUOpenProcess", "hy: user interrupted the process. go to preference");
        super.mo64570aG(activity);
        C36391e.m60010iu(activity);
        AppMethodBeat.m2505o(48386);
    }

    /* renamed from: a */
    public final int mo26468a(MMActivity mMActivity, int i) {
        AppMethodBeat.m2504i(48387);
        if (i == 1) {
            AppMethodBeat.m2505o(48387);
            return C25738R.string.fp8;
        }
        int a = super.mo26468a(mMActivity, i);
        AppMethodBeat.m2505o(48387);
        return a;
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48388);
        C44432g c226952;
        if (mMActivity instanceof WalletPayUStartOpenUI) {
            C226941 c226941 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48372);
                    if (c1207m instanceof C40156b) {
                        C4990ab.m7411d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            C40156b c40156b = (C40156b) c1207m;
                            C46383c.this.mqu.putString("payu_reference", c40156b.cEW);
                            C4990ab.m7411d("MicroMsg.PayUOpenProcess", "hy: session: %s", c40156b.cEW);
                            C46383c.this.mqu.putBoolean("key_is_has_mobile", c40156b.tTz);
                            C24143a.m37116j(this.hwd, C46383c.this.mqu);
                            AppMethodBeat.m2505o(48372);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(48372);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48373);
                    this.Agm.mo36581a(new C40156b(C46383c.this.mqu.getString("dial_code"), C46383c.this.mqu.getString("key_mobile")), true);
                    AppMethodBeat.m2505o(48373);
                    return false;
                }
            };
            AppMethodBeat.m2505o(48388);
            return c226941;
        } else if (mMActivity instanceof WalletPayUVerifyCodeUI) {
            c226952 = new C44432g(mMActivity, c30868i) {
                /* renamed from: x */
                public final boolean mo38265x(Object... objArr) {
                    AppMethodBeat.m2504i(48374);
                    this.Agm.mo49367a(new C40156b(C46383c.this.mqu.getString("dial_code"), C46383c.this.mqu.getString("key_mobile")), true, 1);
                    AppMethodBeat.m2505o(48374);
                    return true;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48375);
                    if (c1207m instanceof C46381a) {
                        C46381a c46381a = (C46381a) c1207m;
                        if (i == 0 && i2 == 0 && c46381a.qnM) {
                            C46383c.this.mqu.putString("payu_reference", c46381a.tTy);
                            C24143a.m37116j(this.hwd, C46383c.this.mqu);
                            AppMethodBeat.m2505o(48375);
                            return true;
                        }
                    } else if ((c1207m instanceof C40156b) && i == 0 && i2 == 0) {
                        C46383c.this.mqu.putString("payu_reference", ((C40156b) c1207m).cEW);
                        AppMethodBeat.m2505o(48375);
                        return true;
                    }
                    AppMethodBeat.m2505o(48375);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48376);
                    this.Agm.mo36581a(new C46381a((String) objArr[0], C46383c.this.mqu.getString("payu_reference")), true);
                    AppMethodBeat.m2505o(48376);
                    return true;
                }

                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(48377);
                    if (i == 0) {
                        String string = this.hwd.getString(C25738R.string.fu6, new Object[]{C36391e.atu("+" + C46383c.this.mqu.getString("dial_code") + C46383c.this.mqu.getString("key_mobile"))});
                        AppMethodBeat.m2505o(48377);
                        return string;
                    }
                    CharSequence Au = super.mo9364Au(i);
                    AppMethodBeat.m2505o(48377);
                    return Au;
                }
            };
            AppMethodBeat.m2505o(48388);
            return c226952;
        } else if (mMActivity instanceof WalletPayUSecurityQuestionSettingUI) {
            c226952 = new C44432g(mMActivity, c30868i) {
                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    AppMethodBeat.m2504i(48378);
                    this.Agm.mo36581a(new C43830d(), true);
                    AppMethodBeat.m2505o(48378);
                    return false;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48379);
                    if ((c1207m instanceof C43830d) && i == 0 && i2 == 0) {
                        C46383c.this.mqu.putParcelableArrayList("key_security_question_list", ((C43830d) c1207m).tUM);
                        AppMethodBeat.m2505o(48379);
                        return true;
                    }
                    AppMethodBeat.m2505o(48379);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.m2505o(48388);
            return c226952;
        } else if (mMActivity instanceof WalletPayUPwdConfirmUI) {
            c226952 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48380);
                    if ((c1207m instanceof C36854a) && i == 0 && i2 == 0) {
                        C4990ab.m7410d("MicroMsg.PayUOpenProcess", "hy: create user success");
                        C24143a.m37113b(this.hwd, C46383c.this.mqu, 0);
                        C46383c.this.mqu.putInt("key_open_error_code", 0);
                        C23639t.makeText(this.hwd, this.hwd.getString(C25738R.string.fpo), 0).show();
                        AppMethodBeat.m2505o(48380);
                        return true;
                    } else if ((c1207m instanceof C40157b) && i == 0 && i2 == 0) {
                        C4990ab.m7410d("MicroMsg.PayUOpenProcess", "hy: link user success");
                        C24143a.m37113b(this.hwd, C46383c.this.mqu, 0);
                        C46383c.this.mqu.putInt("key_open_error_code", 0);
                        C23639t.makeText(this.hwd, this.hwd.getString(C25738R.string.fpo), 0).show();
                        AppMethodBeat.m2505o(48380);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(48380);
                        return false;
                    }
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48381);
                    C14264s c14264s = (C14264s) objArr[0];
                    String string = C46383c.this.mqu.getString("dial_code");
                    String string2 = C46383c.this.mqu.getString("key_mobile");
                    String str = c14264s.guu;
                    String string3 = C46383c.this.mqu.getString("key_question_id");
                    String string4 = C46383c.this.mqu.getString("key_question_answer");
                    String string5 = C46383c.this.mqu.getString("payu_reference");
                    if (C46383c.this.mqu.getBoolean("key_is_has_mobile")) {
                        this.Agm.mo36581a(new C40157b(string, string2, str, string5), true);
                    } else {
                        this.Agm.mo36581a(new C36854a(string, string2, str, string3, string4, string5), true);
                    }
                    AppMethodBeat.m2505o(48381);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48388);
            return c226952;
        } else if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            c226952 = new C22711a(mMActivity, c30868i, this.mqu);
            AppMethodBeat.m2505o(48388);
            return c226952;
        } else {
            c226952 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(48388);
            return c226952;
        }
    }

    public final String bxP() {
        return "PayUOpenProcess";
    }
}
