package com.tencent.p177mm.plugin.wallet.bind;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet.bind.p1311a.C40065d;
import com.tencent.p177mm.plugin.wallet.bind.p553ui.WalletBankcardDetailUI;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet.bind.a */
public class C41325a extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45718);
        C4990ab.m7410d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            mo65990d(activity, bundle);
        } else {
            mo64571b(activity, WalletCheckPwdUI.class, bundle);
        }
        AppMethodBeat.m2505o(45718);
        return this;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: d */
    public void mo65990d(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45719);
        mo64571b(activity, WalletBankcardDetailUI.class, bundle);
        AppMethodBeat.m2505o(45719);
    }

    /* renamed from: a */
    public void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(45720);
        if (activity instanceof WalletBankcardDetailUI) {
            mo64571b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.m2505o(45720);
            return;
        }
        if (activity instanceof WalletCheckPwdUI) {
            mo8125b(activity, bundle);
        }
        AppMethodBeat.m2505o(45720);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(45721);
        mo55241F(activity);
        AppMethodBeat.m2505o(45721);
    }

    /* renamed from: b */
    public void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45722);
        if (this.mqu.getInt("scene", -1) == 1) {
            Activity activity2 = activity;
            mo64565a(activity2, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", bundle.getInt("key_process_result_code", 0), false);
            AppMethodBeat.m2505o(45722);
        } else if (this.mqu.getInt("scene", -1) == 2) {
            mo64575d(activity, "wallet", ".balance.ui.WalletBalanceManagerUI");
            AppMethodBeat.m2505o(45722);
        } else {
            mo64575d(activity, "mall", ".ui.MallIndexUI");
            AppMethodBeat.m2505o(45722);
        }
    }

    /* renamed from: a */
    public C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(45723);
        if (mMActivity instanceof WalletCheckPwdUI) {
            C43511 c43511 = new C44432g(mMActivity, c30868i) {
                private String czZ = null;

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45714);
                    if (c1207m instanceof C40065d) {
                        if (i == 0 && i2 == 0) {
                            C41325a.this.mqu.putInt("key_process_result_code", -1);
                            if (C41325a.this.mo8128c(this.hwd, null)) {
                                this.Agm.mo49367a(new C35475y(this.czZ, 14), true, 1);
                            } else {
                                C41325a.this.mo8124a(this.hwd, 0, null);
                                if (this.hwd instanceof WalletBaseUI) {
                                    ((WalletBaseUI) this.hwd).mo8137wU(0);
                                }
                                this.hwd.finish();
                            }
                            AppMethodBeat.m2505o(45714);
                            return true;
                        }
                        C41325a.this.mqu.putInt("key_process_result_code", 1);
                    }
                    AppMethodBeat.m2505o(45714);
                    return false;
                }

                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    AppMethodBeat.m2504i(45715);
                    Bankcard bankcard = (Bankcard) C41325a.this.mqu.getParcelable("key_bankcard");
                    if (bankcard == null || bankcard.field_bankcardState != 1) {
                        C41325a.this.mqu.putInt("key_process_result_code", 1);
                        boolean w = super.mo9367w(objArr);
                        AppMethodBeat.m2505o(45715);
                        return w;
                    }
                    boolean z;
                    C30868i c30868i = this.Agm;
                    String str = bankcard.field_bankcardType;
                    String str2 = bankcard.field_bindSerial;
                    if (C41325a.this.mqu.getInt("scene", -1) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    c30868i.mo49367a(new C40065d(str, str2, z), true, 1);
                    C41325a.this.mqu.putBoolean("key_is_expired_bankcard", true);
                    AppMethodBeat.m2505o(45715);
                    return true;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45716);
                    Bankcard bankcard = (Bankcard) C41325a.this.mqu.getParcelable("key_bankcard");
                    String str = (String) objArr[0];
                    this.czZ = (String) objArr[1];
                    if (bankcard != null) {
                        boolean z;
                        C30868i c30868i = this.Agm;
                        String str2 = bankcard.field_bankcardType;
                        String str3 = bankcard.field_bindSerial;
                        if (C41325a.this.mqu.getInt("scene", -1) == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c30868i.mo49367a(new C40065d(str2, str3, str, z), true, 1);
                        AppMethodBeat.m2505o(45716);
                        return true;
                    }
                    C41325a.this.mqu.putInt("key_process_result_code", 1);
                    AppMethodBeat.m2505o(45716);
                    return false;
                }

                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(45717);
                    CharSequence string;
                    switch (i) {
                        case 1:
                            string = this.hwd.getString(C25738R.string.fgg);
                            AppMethodBeat.m2505o(45717);
                            return string;
                        default:
                            string = super.mo9364Au(i);
                            AppMethodBeat.m2505o(45717);
                            return string;
                    }
                }
            };
            AppMethodBeat.m2505o(45723);
            return c43511;
        }
        C44432g a = super.mo24745a(mMActivity, c30868i);
        AppMethodBeat.m2505o(45723);
        return a;
    }

    /* renamed from: c */
    public boolean mo8128c(Activity activity, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            return true;
        }
        return false;
    }

    public final String bxP() {
        return "UnbindProcess";
    }
}
