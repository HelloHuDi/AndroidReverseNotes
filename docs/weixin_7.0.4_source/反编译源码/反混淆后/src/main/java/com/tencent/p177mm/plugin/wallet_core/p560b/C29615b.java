package com.tencent.p177mm.plugin.wallet_core.p560b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.C35477h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.p560b.p1050a.C14221a;
import com.tencent.p177mm.plugin.wallet_core.p560b.p1050a.C29614b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletBankcardIdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletBindCardResultUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCardElementUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCardImportUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSetPasswordUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletVerifyCodeUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22563q;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_core.b.b */
public class C29615b extends C22557a {
    /* renamed from: a */
    public C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(46476);
        mo64557F("start", activity, bundle);
        C4990ab.m7410d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            C36381z.m59954hL(6, bundle.getInt("key_bind_scene"));
            C36379x.m59950QN(bundle.getInt("key_bind_scene"));
        } else {
            C36381z.m59954hL(6, 0);
            C36379x.m59950QN(0);
        }
        if (C14241r.cPI().cQg()) {
            mo64571b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.m2505o(46476);
            return this;
        }
        if (bundle != null) {
            C40148d.m68849gj(bundle.getInt("key_bind_scene", 0), 1);
        }
        if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
            this = super.mo8123a(activity, bundle);
            AppMethodBeat.m2505o(46476);
            return this;
        }
        mo64571b(activity, WalletCardImportUI.class, bundle);
        AppMethodBeat.m2505o(46476);
        return this;
    }

    /* renamed from: a */
    public void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(46477);
        mo64557F("forward", activity, Integer.valueOf(i), bundle);
        C4990ab.m7416i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
        int i2;
        BindCardOrder bindCardOrder;
        String string;
        String string2;
        String string3;
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                mo64571b(activity, WalletCardImportUI.class, bundle);
                AppMethodBeat.m2505o(46477);
                return;
            }
            mo64571b(activity, WalletBankcardIdUI.class, bundle);
            AppMethodBeat.m2505o(46477);
        } else if ((activity instanceof WalletCardElementUI) || (activity instanceof WalletCardImportUI)) {
            if (!cRY()) {
                C4990ab.m7416i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
                mo64571b(activity, WalletVerifyCodeUI.class, bundle);
                AppMethodBeat.m2505o(46477);
            } else if (C14241r.cPI().cQg()) {
                C4990ab.m7416i("MicroMsg.BindCardProcess", "bind bank card success!!");
                bundle.putBoolean("intent_bind_end", true);
                C30379h.m48465bQ(activity, activity.getString(C25738R.string.f_2));
                mo8125b(activity, bundle);
                AppMethodBeat.m2505o(46477);
            } else {
                C4990ab.m7416i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
                mo64571b(activity, WalletSetPasswordUI.class, bundle);
                AppMethodBeat.m2505o(46477);
            }
        } else if ((activity instanceof WalletVerifyCodeUI) && C14241r.cPI().cQg()) {
            C4990ab.m7416i("MicroMsg.BindCardProcess", "end process after verify!");
            i2 = this.mqu.getInt("key_bind_scene", -1);
            bindCardOrder = (BindCardOrder) this.mqu.getParcelable("key_bindcard_value_result");
            if (bindCardOrder == null || i2 != 15) {
                mo8125b(activity, bundle);
                AppMethodBeat.m2505o(46477);
                return;
            }
            string = this.mqu.getString("key_bind_card_type");
            string2 = this.mqu.getString("key_bind_card_show1");
            string3 = this.mqu.getString("key_bind_card_show2");
            C4990ab.m7417i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", string, string2, Integer.valueOf(this.mqu.getInt("key_bind_scene")), Integer.valueOf(this.mqu.getInt("realname_scene")));
            bindCardOrder.pbn = string;
            bindCardOrder.txI = string2;
            bindCardOrder.txJ = string3;
            bindCardOrder.txL = r4;
            bindCardOrder.txM = r5;
            mo64571b(activity, WalletBindCardResultUI.class, bundle);
            AppMethodBeat.m2505o(46477);
        } else if (activity instanceof WalletPwdConfirmUI) {
            C4990ab.m7416i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
            C40148d.m68849gj(this.mqu.getInt("key_bind_scene", 0), 7);
            bundle.putBoolean("intent_bind_end", true);
            C30379h.m48465bQ(activity, activity.getString(C25738R.string.f_2));
            bindCardOrder = (BindCardOrder) this.mqu.getParcelable("key_bindcard_value_result");
            i2 = this.mqu.getInt("key_bind_scene", -1);
            if (bindCardOrder == null || i2 != 15) {
                mo8125b(activity, bundle);
                AppMethodBeat.m2505o(46477);
                return;
            }
            string = this.mqu.getString("key_bind_card_type");
            string2 = this.mqu.getString("key_bind_card_show1");
            string3 = this.mqu.getString("key_bind_card_show2");
            C4990ab.m7417i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", string, string2, Integer.valueOf(this.mqu.getInt("key_bind_scene")), Integer.valueOf(this.mqu.getInt("realname_scene")));
            bindCardOrder.pbn = string;
            bindCardOrder.txI = string2;
            bindCardOrder.txJ = string3;
            bindCardOrder.txL = r4;
            bindCardOrder.txM = r5;
            mo64571b(activity, WalletBindCardResultUI.class, bundle);
            AppMethodBeat.m2505o(46477);
        } else if (activity instanceof WalletBindCardResultUI) {
            mo8125b(activity, bundle);
            AppMethodBeat.m2505o(46477);
        } else {
            C4990ab.m7416i("MicroMsg.BindCardProcess", "super forward!");
            super.mo8124a(activity, 0, bundle);
            AppMethodBeat.m2505o(46477);
        }
    }

    /* renamed from: a */
    public C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(46478);
        C44432g c43822;
        if (mMActivity instanceof WalletCheckPwdUI) {
            C43811 c43811 = new C44432g(mMActivity, c30868i) {
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
                    AppMethodBeat.m2504i(46468);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(C25738R.string.fdd);
                            AppMethodBeat.m2505o(46468);
                            return string;
                        case 1:
                            string = this.hwd.getString(C25738R.string.ffz);
                            AppMethodBeat.m2505o(46468);
                            return string;
                        default:
                            string = super.mo9364Au(i);
                            AppMethodBeat.m2505o(46468);
                            return string;
                    }
                }
            };
            AppMethodBeat.m2505o(46478);
            return c43811;
        } else if ((mMActivity instanceof WalletCardElementUI) || (mMActivity instanceof WalletCardImportUI)) {
            c43822 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(46469);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C14221a) {
                            C29615b.this.mqu.putString("kreq_token", ((C14221a) c1207m).token);
                            if (C29615b.this.mo8128c(this.hwd, C29615b.this.mqu)) {
                                C4990ab.m7416i("MicroMsg.BindCardProcess", "need update bankcardlist");
                                this.Agm.mo36581a(new C35475y(null, 12), false);
                            } else {
                                C4990ab.m7416i("MicroMsg.BindCardProcess", "not need update bankcardlist");
                                C29615b.this.mo8124a(this.hwd, 0, C29615b.this.mqu);
                            }
                            AppMethodBeat.m2505o(46469);
                            return true;
                        } else if (c1207m instanceof C35475y) {
                            C4990ab.m7416i("MicroMsg.BindCardProcess", "update bankcardlist success!");
                            C29615b.this.mo8124a(this.hwd, 0, C29615b.this.mqu);
                            AppMethodBeat.m2505o(46469);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(46469);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(46470);
                    C29615b.this.mo64557F("onNext", objArr);
                    C4990ab.m7416i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
                    Authen authen = (Authen) objArr[0];
                    authen.bJt = C29615b.m46970e(C29615b.this);
                    this.Agm.mo49367a(new C14221a(authen), true, 1);
                    AppMethodBeat.m2505o(46470);
                    return true;
                }
            };
            AppMethodBeat.m2505o(46478);
            return c43822;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            c43822 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(46471);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C14221a) {
                            C4990ab.m7416i("MicroMsg.BindCardProcess", "verify code success!");
                            C29615b.this.mqu.putString("kreq_token", ((C14221a) c1207m).token);
                            AppMethodBeat.m2505o(46471);
                            return true;
                        } else if (c1207m instanceof C22563q) {
                            C29615b.this.mo47857a(this.Agm);
                            if (((C22563q) c1207m).ttK != null) {
                                C29615b.this.mqu.putParcelable("key_bindcard_value_result", ((C22563q) c1207m).ttK);
                            }
                        } else if (c1207m instanceof C35477h) {
                            AppMethodBeat.m2505o(46471);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(46471);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(46472);
                    C29615b.this.mo64557F("WalletVerifyCodeUI onNext", objArr);
                    C4990ab.m7416i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
                    C14264s c14264s = (C14264s) objArr[1];
                    if (C14241r.cPI().cQg()) {
                        c14264s.flag = "2";
                    } else {
                        c14264s.flag = "1";
                    }
                    if ("realname_verify_process".equals(C29615b.this.bxP())) {
                        this.Agm.mo49367a(new C22563q(c14264s, C29615b.this.mqu.getInt("entry_scene", -1)), true, 1);
                    } else {
                        this.Agm.mo49367a(new C22563q(c14264s), true, 1);
                    }
                    AppMethodBeat.m2505o(46472);
                    return true;
                }

                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(46473);
                    String string = this.hwd.getString(C25738R.string.fu4);
                    AppMethodBeat.m2505o(46473);
                    return string;
                }
            };
            AppMethodBeat.m2505o(46478);
            return c43822;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            c43822 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(46474);
                    if (c1207m instanceof C29614b) {
                        C29615b.this.mo47857a(this.Agm);
                        if (((C29614b) c1207m).ttK != null) {
                            C29615b.this.mqu.putParcelable("key_bindcard_value_result", ((C29614b) c1207m).ttK);
                        }
                    } else if (c1207m instanceof C35477h) {
                        AppMethodBeat.m2505o(46474);
                        return true;
                    }
                    AppMethodBeat.m2505o(46474);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(46475);
                    C14264s c14264s = (C14264s) objArr[0];
                    C29615b.this.mqu.getString("verify_card_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    if ("realname_verify_process".equals(C29615b.this.bxP())) {
                        this.Agm.mo36581a(new C29614b(c14264s, C29615b.this.mqu.getInt("entry_scene", -1)), true);
                    } else {
                        this.Agm.mo36581a(new C29614b(c14264s), true);
                    }
                    AppMethodBeat.m2505o(46475);
                    return false;
                }
            };
            AppMethodBeat.m2505o(46478);
            return c43822;
        } else {
            c43822 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(46478);
            return c43822;
        }
    }

    /* renamed from: a */
    public final void mo47857a(C30868i c30868i) {
        AppMethodBeat.m2504i(46479);
        C4990ab.m7410d("MicroMsg.BindCardProcess", "do set user exinfo");
        c30868i.mo49367a(new C35477h(this.mqu.getString("key_country_code", ""), this.mqu.getString("key_province_code", ""), this.mqu.getString("key_city_code", ""), (Profession) this.mqu.getParcelable("key_profession"), this.mqu.getString("key_country_iso")), false, 1);
        AppMethodBeat.m2505o(46479);
    }

    /* renamed from: b */
    public void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(46480);
        mo64557F("end", activity, bundle);
        C4990ab.m7416i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
        C36379x.dNV();
        dNI();
        if (bundle == null || !bundle.getBoolean("key_need_bind_response", false)) {
            mo64575d(activity, "mall", ".ui.MallIndexUI");
            AppMethodBeat.m2505o(46480);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        mo64564a(activity, "wallet", ".bind.ui.WalletBindUI", -1, intent, false);
        AppMethodBeat.m2505o(46480);
    }

    /* renamed from: c */
    public boolean mo8128c(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(46481);
        if (!C14241r.cPI().cQg()) {
            boolean z = activity instanceof WalletPwdConfirmUI;
            AppMethodBeat.m2505o(46481);
            return z;
        } else if ((activity instanceof WalletCardElementUI) && cRY()) {
            AppMethodBeat.m2505o(46481);
            return true;
        } else if (activity instanceof WalletVerifyCodeUI) {
            AppMethodBeat.m2505o(46481);
            return true;
        } else {
            AppMethodBeat.m2505o(46481);
            return false;
        }
    }

    public String bxP() {
        return "BindCardProcess";
    }

    /* renamed from: e */
    static /* synthetic */ int m46970e(C29615b c29615b) {
        AppMethodBeat.m2504i(46482);
        if (c29615b.cRY()) {
            if (C14241r.cPI().cQg()) {
                AppMethodBeat.m2505o(46482);
                return 5;
            }
            AppMethodBeat.m2505o(46482);
            return 4;
        } else if (C14241r.cPI().cQg()) {
            AppMethodBeat.m2505o(46482);
            return 2;
        } else {
            AppMethodBeat.m2505o(46482);
            return 1;
        }
    }
}
