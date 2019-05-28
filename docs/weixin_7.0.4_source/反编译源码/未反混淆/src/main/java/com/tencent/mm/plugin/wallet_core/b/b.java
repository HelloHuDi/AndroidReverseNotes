package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b extends a {
    public c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(46476);
        F("start", activity, bundle);
        ab.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            z.hL(6, bundle.getInt("key_bind_scene"));
            x.QN(bundle.getInt("key_bind_scene"));
        } else {
            z.hL(6, 0);
            x.QN(0);
        }
        if (r.cPI().cQg()) {
            b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.o(46476);
            return this;
        }
        if (bundle != null) {
            d.gj(bundle.getInt("key_bind_scene", 0), 1);
        }
        if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
            this = super.a(activity, bundle);
            AppMethodBeat.o(46476);
            return this;
        }
        b(activity, WalletCardImportUI.class, bundle);
        AppMethodBeat.o(46476);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(46477);
        F("forward", activity, Integer.valueOf(i), bundle);
        ab.i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
        int i2;
        BindCardOrder bindCardOrder;
        String string;
        String string2;
        String string3;
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                b(activity, WalletCardImportUI.class, bundle);
                AppMethodBeat.o(46477);
                return;
            }
            b(activity, WalletBankcardIdUI.class, bundle);
            AppMethodBeat.o(46477);
        } else if ((activity instanceof WalletCardElementUI) || (activity instanceof WalletCardImportUI)) {
            if (!cRY()) {
                ab.i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
                b(activity, WalletVerifyCodeUI.class, bundle);
                AppMethodBeat.o(46477);
            } else if (r.cPI().cQg()) {
                ab.i("MicroMsg.BindCardProcess", "bind bank card success!!");
                bundle.putBoolean("intent_bind_end", true);
                h.bQ(activity, activity.getString(R.string.f_2));
                b(activity, bundle);
                AppMethodBeat.o(46477);
            } else {
                ab.i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
                b(activity, WalletSetPasswordUI.class, bundle);
                AppMethodBeat.o(46477);
            }
        } else if ((activity instanceof WalletVerifyCodeUI) && r.cPI().cQg()) {
            ab.i("MicroMsg.BindCardProcess", "end process after verify!");
            i2 = this.mqu.getInt("key_bind_scene", -1);
            bindCardOrder = (BindCardOrder) this.mqu.getParcelable("key_bindcard_value_result");
            if (bindCardOrder == null || i2 != 15) {
                b(activity, bundle);
                AppMethodBeat.o(46477);
                return;
            }
            string = this.mqu.getString("key_bind_card_type");
            string2 = this.mqu.getString("key_bind_card_show1");
            string3 = this.mqu.getString("key_bind_card_show2");
            ab.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", string, string2, Integer.valueOf(this.mqu.getInt("key_bind_scene")), Integer.valueOf(this.mqu.getInt("realname_scene")));
            bindCardOrder.pbn = string;
            bindCardOrder.txI = string2;
            bindCardOrder.txJ = string3;
            bindCardOrder.txL = r4;
            bindCardOrder.txM = r5;
            b(activity, WalletBindCardResultUI.class, bundle);
            AppMethodBeat.o(46477);
        } else if (activity instanceof WalletPwdConfirmUI) {
            ab.i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
            d.gj(this.mqu.getInt("key_bind_scene", 0), 7);
            bundle.putBoolean("intent_bind_end", true);
            h.bQ(activity, activity.getString(R.string.f_2));
            bindCardOrder = (BindCardOrder) this.mqu.getParcelable("key_bindcard_value_result");
            i2 = this.mqu.getInt("key_bind_scene", -1);
            if (bindCardOrder == null || i2 != 15) {
                b(activity, bundle);
                AppMethodBeat.o(46477);
                return;
            }
            string = this.mqu.getString("key_bind_card_type");
            string2 = this.mqu.getString("key_bind_card_show1");
            string3 = this.mqu.getString("key_bind_card_show2");
            ab.i("MicroMsg.BindCardProcess", "order ok bank_type %s  bank_type_show %s scene %s realnameScene %s", string, string2, Integer.valueOf(this.mqu.getInt("key_bind_scene")), Integer.valueOf(this.mqu.getInt("realname_scene")));
            bindCardOrder.pbn = string;
            bindCardOrder.txI = string2;
            bindCardOrder.txJ = string3;
            bindCardOrder.txL = r4;
            bindCardOrder.txM = r5;
            b(activity, WalletBindCardResultUI.class, bundle);
            AppMethodBeat.o(46477);
        } else if (activity instanceof WalletBindCardResultUI) {
            b(activity, bundle);
            AppMethodBeat.o(46477);
        } else {
            ab.i("MicroMsg.BindCardProcess", "super forward!");
            super.a(activity, 0, bundle);
            AppMethodBeat.o(46477);
        }
    }

    public g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(46478);
        g anonymousClass2;
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }

                public final boolean p(Object... objArr) {
                    return false;
                }

                public final CharSequence Au(int i) {
                    AppMethodBeat.i(46468);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(R.string.fdd);
                            AppMethodBeat.o(46468);
                            return string;
                        case 1:
                            string = this.hwd.getString(R.string.ffz);
                            AppMethodBeat.o(46468);
                            return string;
                        default:
                            string = super.Au(i);
                            AppMethodBeat.o(46468);
                            return string;
                    }
                }
            };
            AppMethodBeat.o(46478);
            return anonymousClass1;
        } else if ((mMActivity instanceof WalletCardElementUI) || (mMActivity instanceof WalletCardImportUI)) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(46469);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof a) {
                            b.this.mqu.putString("kreq_token", ((a) mVar).token);
                            if (b.this.c(this.hwd, b.this.mqu)) {
                                ab.i("MicroMsg.BindCardProcess", "need update bankcardlist");
                                this.Agm.a(new y(null, 12), false);
                            } else {
                                ab.i("MicroMsg.BindCardProcess", "not need update bankcardlist");
                                b.this.a(this.hwd, 0, b.this.mqu);
                            }
                            AppMethodBeat.o(46469);
                            return true;
                        } else if (mVar instanceof y) {
                            ab.i("MicroMsg.BindCardProcess", "update bankcardlist success!");
                            b.this.a(this.hwd, 0, b.this.mqu);
                            AppMethodBeat.o(46469);
                            return true;
                        }
                    }
                    AppMethodBeat.o(46469);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(46470);
                    b.this.F("onNext", objArr);
                    ab.i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
                    Authen authen = (Authen) objArr[0];
                    authen.bJt = b.e(b.this);
                    this.Agm.a(new a(authen), true, 1);
                    AppMethodBeat.o(46470);
                    return true;
                }
            };
            AppMethodBeat.o(46478);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(46471);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof a) {
                            ab.i("MicroMsg.BindCardProcess", "verify code success!");
                            b.this.mqu.putString("kreq_token", ((a) mVar).token);
                            AppMethodBeat.o(46471);
                            return true;
                        } else if (mVar instanceof q) {
                            b.this.a(this.Agm);
                            if (((q) mVar).ttK != null) {
                                b.this.mqu.putParcelable("key_bindcard_value_result", ((q) mVar).ttK);
                            }
                        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h) {
                            AppMethodBeat.o(46471);
                            return true;
                        }
                    }
                    AppMethodBeat.o(46471);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(46472);
                    b.this.F("WalletVerifyCodeUI onNext", objArr);
                    ab.i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
                    s sVar = (s) objArr[1];
                    if (r.cPI().cQg()) {
                        sVar.flag = "2";
                    } else {
                        sVar.flag = "1";
                    }
                    if ("realname_verify_process".equals(b.this.bxP())) {
                        this.Agm.a(new q(sVar, b.this.mqu.getInt("entry_scene", -1)), true, 1);
                    } else {
                        this.Agm.a(new q(sVar), true, 1);
                    }
                    AppMethodBeat.o(46472);
                    return true;
                }

                public final CharSequence Au(int i) {
                    AppMethodBeat.i(46473);
                    String string = this.hwd.getString(R.string.fu4);
                    AppMethodBeat.o(46473);
                    return string;
                }
            };
            AppMethodBeat.o(46478);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(46474);
                    if (mVar instanceof com.tencent.mm.plugin.wallet_core.b.a.b) {
                        b.this.a(this.Agm);
                        if (((com.tencent.mm.plugin.wallet_core.b.a.b) mVar).ttK != null) {
                            b.this.mqu.putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.b.a.b) mVar).ttK);
                        }
                    } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h) {
                        AppMethodBeat.o(46474);
                        return true;
                    }
                    AppMethodBeat.o(46474);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(46475);
                    s sVar = (s) objArr[0];
                    b.this.mqu.getString("verify_card_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    if ("realname_verify_process".equals(b.this.bxP())) {
                        this.Agm.a(new com.tencent.mm.plugin.wallet_core.b.a.b(sVar, b.this.mqu.getInt("entry_scene", -1)), true);
                    } else {
                        this.Agm.a(new com.tencent.mm.plugin.wallet_core.b.a.b(sVar), true);
                    }
                    AppMethodBeat.o(46475);
                    return false;
                }
            };
            AppMethodBeat.o(46478);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(46478);
            return anonymousClass2;
        }
    }

    public final void a(i iVar) {
        AppMethodBeat.i(46479);
        ab.d("MicroMsg.BindCardProcess", "do set user exinfo");
        iVar.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.h(this.mqu.getString("key_country_code", ""), this.mqu.getString("key_province_code", ""), this.mqu.getString("key_city_code", ""), (Profession) this.mqu.getParcelable("key_profession"), this.mqu.getString("key_country_iso")), false, 1);
        AppMethodBeat.o(46479);
    }

    public void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(46480);
        F("end", activity, bundle);
        ab.i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
        x.dNV();
        dNI();
        if (bundle == null || !bundle.getBoolean("key_need_bind_response", false)) {
            d(activity, "mall", ".ui.MallIndexUI");
            AppMethodBeat.o(46480);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(activity, "wallet", ".bind.ui.WalletBindUI", -1, intent, false);
        AppMethodBeat.o(46480);
    }

    public boolean c(Activity activity, Bundle bundle) {
        AppMethodBeat.i(46481);
        if (!r.cPI().cQg()) {
            boolean z = activity instanceof WalletPwdConfirmUI;
            AppMethodBeat.o(46481);
            return z;
        } else if ((activity instanceof WalletCardElementUI) && cRY()) {
            AppMethodBeat.o(46481);
            return true;
        } else if (activity instanceof WalletVerifyCodeUI) {
            AppMethodBeat.o(46481);
            return true;
        } else {
            AppMethodBeat.o(46481);
            return false;
        }
    }

    public String bxP() {
        return "BindCardProcess";
    }

    static /* synthetic */ int e(b bVar) {
        AppMethodBeat.i(46482);
        if (bVar.cRY()) {
            if (r.cPI().cQg()) {
                AppMethodBeat.o(46482);
                return 5;
            }
            AppMethodBeat.o(46482);
            return 4;
        } else if (r.cPI().cQg()) {
            AppMethodBeat.o(46482);
            return 2;
        } else {
            AppMethodBeat.o(46482);
            return 1;
        }
    }
}
