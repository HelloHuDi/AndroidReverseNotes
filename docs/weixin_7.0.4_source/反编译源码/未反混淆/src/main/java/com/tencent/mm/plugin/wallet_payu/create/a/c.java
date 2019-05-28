package com.tencent.mm.plugin.wallet_payu.create.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_payu.a.b;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48382);
        ab.d("MicroMsg.PayUOpenProcess", "hy: start process PayUOpenProcess");
        s.cNC();
        String agi = s.agi();
        s.cNC();
        String cNE = s.cNE();
        if (bundle != null) {
            bundle.putString("key_mobile", agi);
            bundle.putString("dial_code", cNE);
        }
        b(activity, WalletPayUStartOpenUI.class, bundle);
        AppMethodBeat.o(48382);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48383);
        if (activity instanceof WalletPayUStartOpenUI) {
            b(activity, WalletPayUVerifyCodeUI.class, bundle);
        }
        if (activity instanceof WalletPayUVerifyCodeUI) {
            if (bundle.getBoolean("key_is_has_mobile")) {
                b(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
            } else {
                b(activity, WalletPayUSecurityQuestionSettingUI.class, bundle);
            }
        }
        if (activity instanceof WalletPayUSecurityQuestionSettingUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        }
        if (activity instanceof WalletPayUSetPasswordUI) {
            b(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        }
        AppMethodBeat.o(48383);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(48384);
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i);
            AppMethodBeat.o(48384);
            return;
        }
        b(activity, this.mqu);
        AppMethodBeat.o(48384);
    }

    public final boolean h(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48385);
        bundle.putInt("key_open_error_code", 1);
        t.makeText(activity, activity.getString(R.string.fpi), 0).show();
        b(activity, bundle);
        AppMethodBeat.o(48385);
        return true;
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48386);
        if (bundle.getInt("key_open_error_code", -1) == 0) {
            ab.i("MicroMsg.PayUOpenProcess", "hy: user open success");
            d(activity, "mall", ".ui.MallIndexUI");
            AppMethodBeat.o(48386);
            return;
        }
        ab.i("MicroMsg.PayUOpenProcess", "hy: user interrupted the process. go to preference");
        super.aG(activity);
        e.iu(activity);
        AppMethodBeat.o(48386);
    }

    public final int a(MMActivity mMActivity, int i) {
        AppMethodBeat.i(48387);
        if (i == 1) {
            AppMethodBeat.o(48387);
            return R.string.fp8;
        }
        int a = super.a(mMActivity, i);
        AppMethodBeat.o(48387);
        return a;
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48388);
        g anonymousClass2;
        if (mMActivity instanceof WalletPayUStartOpenUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48372);
                    if (mVar instanceof b) {
                        ab.d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            b bVar = (b) mVar;
                            c.this.mqu.putString("payu_reference", bVar.cEW);
                            ab.d("MicroMsg.PayUOpenProcess", "hy: session: %s", bVar.cEW);
                            c.this.mqu.putBoolean("key_is_has_mobile", bVar.tTz);
                            a.j(this.hwd, c.this.mqu);
                            AppMethodBeat.o(48372);
                            return true;
                        }
                    }
                    AppMethodBeat.o(48372);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48373);
                    this.Agm.a(new b(c.this.mqu.getString("dial_code"), c.this.mqu.getString("key_mobile")), true);
                    AppMethodBeat.o(48373);
                    return false;
                }
            };
            AppMethodBeat.o(48388);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletPayUVerifyCodeUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean x(Object... objArr) {
                    AppMethodBeat.i(48374);
                    this.Agm.a(new b(c.this.mqu.getString("dial_code"), c.this.mqu.getString("key_mobile")), true, 1);
                    AppMethodBeat.o(48374);
                    return true;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48375);
                    if (mVar instanceof com.tencent.mm.plugin.wallet_payu.a.a) {
                        com.tencent.mm.plugin.wallet_payu.a.a aVar = (com.tencent.mm.plugin.wallet_payu.a.a) mVar;
                        if (i == 0 && i2 == 0 && aVar.qnM) {
                            c.this.mqu.putString("payu_reference", aVar.tTy);
                            a.j(this.hwd, c.this.mqu);
                            AppMethodBeat.o(48375);
                            return true;
                        }
                    } else if ((mVar instanceof b) && i == 0 && i2 == 0) {
                        c.this.mqu.putString("payu_reference", ((b) mVar).cEW);
                        AppMethodBeat.o(48375);
                        return true;
                    }
                    AppMethodBeat.o(48375);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48376);
                    this.Agm.a(new com.tencent.mm.plugin.wallet_payu.a.a((String) objArr[0], c.this.mqu.getString("payu_reference")), true);
                    AppMethodBeat.o(48376);
                    return true;
                }

                public final CharSequence Au(int i) {
                    AppMethodBeat.i(48377);
                    if (i == 0) {
                        String string = this.hwd.getString(R.string.fu6, new Object[]{e.atu("+" + c.this.mqu.getString("dial_code") + c.this.mqu.getString("key_mobile"))});
                        AppMethodBeat.o(48377);
                        return string;
                    }
                    CharSequence Au = super.Au(i);
                    AppMethodBeat.o(48377);
                    return Au;
                }
            };
            AppMethodBeat.o(48388);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletPayUSecurityQuestionSettingUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean w(Object... objArr) {
                    AppMethodBeat.i(48378);
                    this.Agm.a(new d(), true);
                    AppMethodBeat.o(48378);
                    return false;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48379);
                    if ((mVar instanceof d) && i == 0 && i2 == 0) {
                        c.this.mqu.putParcelableArrayList("key_security_question_list", ((d) mVar).tUM);
                        AppMethodBeat.o(48379);
                        return true;
                    }
                    AppMethodBeat.o(48379);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(48388);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletPayUPwdConfirmUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(48380);
                    if ((mVar instanceof a) && i == 0 && i2 == 0) {
                        ab.d("MicroMsg.PayUOpenProcess", "hy: create user success");
                        a.b(this.hwd, c.this.mqu, 0);
                        c.this.mqu.putInt("key_open_error_code", 0);
                        t.makeText(this.hwd, this.hwd.getString(R.string.fpo), 0).show();
                        AppMethodBeat.o(48380);
                        return true;
                    } else if ((mVar instanceof b) && i == 0 && i2 == 0) {
                        ab.d("MicroMsg.PayUOpenProcess", "hy: link user success");
                        a.b(this.hwd, c.this.mqu, 0);
                        c.this.mqu.putInt("key_open_error_code", 0);
                        t.makeText(this.hwd, this.hwd.getString(R.string.fpo), 0).show();
                        AppMethodBeat.o(48380);
                        return true;
                    } else {
                        AppMethodBeat.o(48380);
                        return false;
                    }
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48381);
                    com.tencent.mm.plugin.wallet_core.model.s sVar = (com.tencent.mm.plugin.wallet_core.model.s) objArr[0];
                    String string = c.this.mqu.getString("dial_code");
                    String string2 = c.this.mqu.getString("key_mobile");
                    String str = sVar.guu;
                    String string3 = c.this.mqu.getString("key_question_id");
                    String string4 = c.this.mqu.getString("key_question_answer");
                    String string5 = c.this.mqu.getString("payu_reference");
                    if (c.this.mqu.getBoolean("key_is_has_mobile")) {
                        this.Agm.a(new b(string, string2, str, string5), true);
                    } else {
                        this.Agm.a(new a(string, string2, str, string3, string4, string5), true);
                    }
                    AppMethodBeat.o(48381);
                    return true;
                }
            };
            AppMethodBeat.o(48388);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            anonymousClass2 = new com.tencent.mm.plugin.wallet_payu.security_question.model.a(mMActivity, iVar, this.mqu);
            AppMethodBeat.o(48388);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(48388);
            return anonymousClass2;
        }
    }

    public final String bxP() {
        return "PayUOpenProcess";
    }
}
