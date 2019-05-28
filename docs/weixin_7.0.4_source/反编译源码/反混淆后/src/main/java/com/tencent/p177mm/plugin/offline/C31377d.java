package com.tencent.p177mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37756lf;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.offline.p478a.C21402k;
import com.tencent.p177mm.plugin.offline.p479ui.WalletOfflineEntranceUI;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;
import com.tencent.p177mm.plugin.wallet_core.p560b.p1050a.C29614b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletVerifyCodeUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22563q;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.offline.d */
public class C31377d extends C29615b {
    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43298);
        C4879a.xxA.mo10055m(new C37756lf());
        mo64573c(activity, WalletOfflineEntranceUI.class);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.m2505o(43298);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(43299);
        super.mo8127c(activity, i);
        AppMethodBeat.m2505o(43299);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(43300);
        C44432g c313792;
        if (mMActivity instanceof WalletVerifyCodeUI) {
            C313781 c313781 = new C44432g(mMActivity, c30868i) {
                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(43294);
                    C14264s c14264s = (C14264s) objArr[1];
                    c14264s.flag = "1";
                    this.Agm.mo49367a(new C22563q(c14264s), true, 1);
                    AppMethodBeat.m2505o(43294);
                    return true;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(43295);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C35475y) {
                            if (!(((WalletBaseUI) this.hwd).mBundle == null || ((WalletBaseUI) this.hwd).mBundle.getInt("key_bind_scene", -1) != 5 || C28630a.bYd())) {
                                C31377d.m50712i(this.hwd);
                                AppMethodBeat.m2505o(43295);
                                return true;
                            }
                        } else if (c1207m instanceof C21402k) {
                            C24143a.m37116j(this.hwd, ((WalletBaseUI) this.hwd).mBundle);
                            C28630a.m45510W(this.hwd);
                            AppMethodBeat.m2505o(43295);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(43295);
                    return false;
                }
            };
            AppMethodBeat.m2505o(43300);
            return c313781;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            c313792 = new C44432g(mMActivity, c30868i) {
                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(43296);
                    this.Agm.mo49367a(new C29614b((C14264s) objArr[0]), true, 1);
                    AppMethodBeat.m2505o(43296);
                    return true;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(43297);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C35475y) {
                            if (!(((WalletBaseUI) this.hwd).mBundle == null || ((WalletBaseUI) this.hwd).mBundle.getInt("key_bind_scene", -1) != 5 || C28630a.bYd())) {
                                C31377d.m50712i(this.hwd);
                            }
                            AppMethodBeat.m2505o(43297);
                            return true;
                        } else if (c1207m instanceof C21402k) {
                            Bundle bundle = ((WalletBaseUI) this.hwd).mBundle;
                            bundle.putBoolean("intent_bind_end", true);
                            C24143a.m37116j(this.hwd, bundle);
                            C28630a.m45510W(this.hwd);
                            AppMethodBeat.m2505o(43297);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(43297);
                    return false;
                }
            };
            AppMethodBeat.m2505o(43300);
            return c313792;
        } else {
            c313792 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(43300);
            return c313792;
        }
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43301);
        boolean c = super.mo8128c(activity, bundle);
        AppMethodBeat.m2505o(43301);
        return c;
    }

    public final String bxP() {
        return "OfflineBindCardRegProcess";
    }

    /* renamed from: i */
    static /* synthetic */ void m50712i(MMActivity mMActivity) {
        AppMethodBeat.m2504i(43302);
        String string = ((WalletBaseUI) mMActivity).mBundle.getString("key_pwd1");
        int i = ((WalletBaseUI) mMActivity).mBundle.getInt("offline_add_fee", 0);
        Bankcard bYg = C28630a.bYg();
        if (bYg != null) {
            ((WalletBaseUI) mMActivity).mo39970a(new C21402k(bYg, string, i), true, false);
        }
        AppMethodBeat.m2505o(43302);
    }
}
