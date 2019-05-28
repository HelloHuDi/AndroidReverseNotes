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
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.offline.c */
public class C12739c extends C29615b {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43288);
        C40931c a = super.mo8123a(activity, bundle);
        AppMethodBeat.m2505o(43288);
        return a;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(43289);
        super.mo8124a(activity, i, bundle);
        AppMethodBeat.m2505o(43289);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43290);
        C4879a.xxA.mo10055m(new C37756lf());
        if (C28630a.bYd()) {
            mo64573c(activity, WalletOfflineEntranceUI.class);
        } else if (bundle.getInt("key_entry_scene", -1) == 2) {
            mo64575d(activity, "offline", "ui.WalletOfflineEntranceUI");
        } else {
            mo64575d(activity, "mall", ".ui.MallIndexUI");
        }
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.m2505o(43290);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(43291);
        C44432g c127402;
        if (mMActivity instanceof WalletVerifyCodeUI) {
            C127371 c127371 = new C44432g(mMActivity, c30868i) {
                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(43284);
                    C14264s c14264s = (C14264s) objArr[1];
                    c14264s.flag = "2";
                    this.Agm.mo49367a(new C22563q(c14264s), true, 1);
                    AppMethodBeat.m2505o(43284);
                    return true;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(43285);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C35475y) {
                            if (!(((WalletBaseUI) this.hwd).mBundle == null || ((WalletBaseUI) this.hwd).mBundle.getInt("key_bind_scene", -1) != 5 || C28630a.bYd())) {
                                C12739c.m20755h(this.hwd);
                                AppMethodBeat.m2505o(43285);
                                return true;
                            }
                        } else if (c1207m instanceof C21402k) {
                            C24143a.m37116j(this.hwd, ((WalletBaseUI) this.hwd).mBundle);
                            C28630a.m45510W(this.hwd);
                            AppMethodBeat.m2505o(43285);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(43285);
                    return false;
                }
            };
            AppMethodBeat.m2505o(43291);
            return c127371;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            c127402 = new C44432g(mMActivity, c30868i) {
                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(43286);
                    this.Agm.mo49367a(new C29614b((C14264s) objArr[0]), true, 1);
                    AppMethodBeat.m2505o(43286);
                    return true;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(43287);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C35475y) {
                            if (!(((WalletBaseUI) this.hwd).mBundle == null || ((WalletBaseUI) this.hwd).mBundle.getInt("key_bind_scene", -1) != 5 || C28630a.bYd())) {
                                C12739c.m20755h(this.hwd);
                                AppMethodBeat.m2505o(43287);
                                return true;
                            }
                        } else if (c1207m instanceof C21402k) {
                            Bundle bundle = ((WalletBaseUI) this.hwd).mBundle;
                            bundle.putBoolean("intent_bind_end", true);
                            C24143a.m37116j(this.hwd, bundle);
                            C28630a.m45510W(this.hwd);
                            AppMethodBeat.m2505o(43287);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(43287);
                    return false;
                }
            };
            AppMethodBeat.m2505o(43291);
            return c127402;
        } else {
            c127402 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(43291);
            return c127402;
        }
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43292);
        boolean c = super.mo8128c(activity, bundle);
        AppMethodBeat.m2505o(43292);
        return c;
    }

    public final String bxP() {
        return "OfflineBindCardProcess";
    }

    /* renamed from: h */
    static /* synthetic */ void m20755h(MMActivity mMActivity) {
        AppMethodBeat.m2504i(43293);
        String string = ((WalletBaseUI) mMActivity).mBundle.getString("key_pwd1");
        int i = ((WalletBaseUI) mMActivity).mBundle.getInt("offline_add_fee", 0);
        Bankcard bYg = C28630a.bYg();
        if (bYg != null) {
            ((WalletBaseUI) mMActivity).mo39970a(new C21402k(bYg, string, i), true, false);
        }
        AppMethodBeat.m2505o(43293);
    }
}
