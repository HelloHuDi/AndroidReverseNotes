package com.tencent.p177mm.plugin.offline;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18416uq;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.offline.p478a.C21402k;
import com.tencent.p177mm.plugin.offline.p478a.C39469i;
import com.tencent.p177mm.plugin.offline.p478a.C39470p;
import com.tencent.p177mm.plugin.offline.p478a.C43353n;
import com.tencent.p177mm.plugin.offline.p479ui.WalletOfflineEntranceUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C30868i.C308678;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.offline.h */
public class C34646h extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43331);
        mo64571b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.m2505o(43331);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(43332);
        if (activity instanceof WalletCheckPwdUI) {
            mo55241F(activity);
        }
        AppMethodBeat.m2505o(43332);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(43333);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.m2505o(43333);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(43334);
        mo55241F(activity);
        if (bundle != null && bundle.getBoolean("is_offline_create")) {
            C28630a.m45510W((WalletBaseUI) activity);
        }
        AppMethodBeat.m2505o(43334);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: F */
    public final void mo55241F(Activity activity) {
        int i = 2;
        AppMethodBeat.m2504i(43335);
        if (activity != null) {
            int i2 = this.mqu.getInt("offline_from_scene", -1);
            if (i2 != 1) {
                if (i2 == 2) {
                    i = 1;
                } else if (i2 == 3) {
                    i = 3;
                } else if (i2 == 4) {
                    i = 6;
                } else if (i2 == 8) {
                    i = 4;
                } else {
                    i = 1;
                }
            }
            C7060h.pYm.mo8381e(14096, Integer.valueOf(i));
            Intent intent = new Intent(activity, WalletOfflineEntranceUI.class);
            intent.putExtra("key_from_scene", i2);
            intent.putExtra("is_offline_create", true);
            mo64561a(activity, WalletOfflineEntranceUI.class, intent);
            activity.finish();
        }
        AppMethodBeat.m2505o(43335);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(43336);
        if (mMActivity instanceof WalletCheckPwdUI) {
            C346471 c346471 = new C44432g(mMActivity, c30868i) {

                /* renamed from: com.tencent.mm.plugin.offline.h$1$1 */
                class C346481 implements Runnable {
                    C346481() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(43324);
                        C4990ab.m7410d("MicroMsg.OfflineProcess", "tofutest do callback");
                        C34646h.this.mo8124a(C346471.this.hwd, 0, C34646h.this.mqu);
                        C346471.this.Agm.cNM();
                        AppMethodBeat.m2505o(43324);
                    }
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(43327);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C21402k) {
                            C4990ab.m7416i("MicroMsg.OfflineProcess", "Offline is Create ");
                            bXe();
                            C34646h.this.mqu.putBoolean("is_offline_create", true);
                        } else if (c1207m instanceof C43353n) {
                            C4990ab.m7416i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
                            C30868i c30868i = this.Agm;
                            if (c30868i.gII == null || !(c30868i.gII == null || c30868i.gII.isShowing())) {
                                if (c30868i.gII != null) {
                                    c30868i.gII.dismiss();
                                }
                                if (c30868i.mContext == null) {
                                    C4990ab.m7420w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                                } else {
                                    c30868i.gII = C30901g.m49317a(c30868i.mContext, false, new C308678());
                                }
                            }
                            C18416uq c18416uq = new C18416uq();
                            c18416uq.cQP.scene = 8;
                            c18416uq.cQQ.cQH = new C346481();
                            C4879a.xxA.mo10055m(c18416uq);
                        } else if (c1207m instanceof C39469i) {
                            C39469i c39469i = (C39469i) c1207m;
                            if ("1".equals(c39469i.oYi)) {
                                Activity activity = this.hwd;
                                String str2 = c39469i.cFl;
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("key_authen", new Authen());
                                bundle.putString("key_pwd1", C34646h.this.mqu.getString("key_pwd1"));
                                bundle.putString("key_mobile", str2);
                                bundle.putInt("verify_scene", 1);
                                bundle.putInt("offline_add_fee", C34646h.this.mqu.getInt("offline_chg_fee", 0));
                                C24143a.m37105a(activity, C3564l.class, bundle);
                                C34646h.this.mo8124a(activity, 0, C34646h.this.mqu);
                            } else {
                                C34646h.this.mqu.putBoolean("back_to_coin_purse_ui", true);
                                bXe();
                            }
                        } else if (c1207m instanceof C39470p) {
                            C28630a.m45496Ud("");
                            C7007k.bXg();
                            C7007k.bXh().oYL = null;
                            C34646h.this.mo8124a(this.hwd, 0, C34646h.this.mqu);
                        }
                        AppMethodBeat.m2505o(43327);
                        return true;
                    }
                    if (c1207m instanceof C21402k) {
                        C4990ab.m7416i("MicroMsg.OfflineProcess", "Offline Create is failed!");
                        C21402k c21402k = (C21402k) c1207m;
                        if (i2 == 410) {
                            final MMActivity mMActivity = this.hwd;
                            final int i3 = c21402k.oYw;
                            C30379h.m48466d(mMActivity, str, "", mMActivity.getString(C25738R.string.fnt), mMActivity.getString(C25738R.string.f9076or), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(43325);
                                    C35899h.m58861aj(mMActivity, i3);
                                    C34646h.this.mo8124a(mMActivity, 0, C34646h.this.mqu);
                                    AppMethodBeat.m2505o(43325);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(43326);
                                    C34646h.this.mo8124a(mMActivity, 0, C34646h.this.mqu);
                                    AppMethodBeat.m2505o(43326);
                                }
                            });
                            AppMethodBeat.m2505o(43327);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(43327);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(43328);
                    String str = (String) objArr[0];
                    C34646h.this.mqu.putString("key_pwd1", str);
                    Bankcard bYg = C28630a.bYg();
                    if (bYg == null) {
                        C4990ab.m7412e("MicroMsg.OfflineProcess", "no support bank car for offline");
                        bYg = C28630a.bYh();
                    }
                    if (bYg == null) {
                        C4990ab.m7412e("MicroMsg.OfflineProcess", "no any bank car for offline");
                        AppMethodBeat.m2505o(43328);
                        return false;
                    }
                    String string = C34646h.this.mqu.getString("oper");
                    if (!C28630a.bYd()) {
                        C4990ab.m7416i("MicroMsg.OfflineProcess", "Offline is not Create ");
                        this.Agm.mo49367a(new C21402k(bYg, (String) objArr[0], C34646h.this.mqu.getInt("offline_chg_fee", 0)), true, 1);
                    } else if (string != null) {
                        C4990ab.m7416i("MicroMsg.OfflineProcess", "oper == ".concat(String.valueOf(string)));
                        if (string.equals("create")) {
                            this.Agm.mo49367a(new C21402k(bYg, (String) objArr[0], C34646h.this.mqu.getInt("offline_chg_fee", 0)), true, 1);
                        } else if (string.equals("clr")) {
                            this.Agm.mo49367a(new C39469i(bYg, str, "clr", 0, ""), true, 1);
                        } else if (string.equals("changeto")) {
                            this.Agm.mo49367a(new C39469i(bYg, str, "changeto", C34646h.this.mqu.getInt("offline_chg_fee"), ""), true, 1);
                        } else if (string.equals("freeze")) {
                            this.Agm.mo49367a(new C39470p(str), true, 1);
                        } else {
                            AppMethodBeat.m2505o(43328);
                            return false;
                        }
                    }
                    AppMethodBeat.m2505o(43328);
                    return true;
                }

                private void bXe() {
                    AppMethodBeat.m2504i(43329);
                    this.Agm.mo49367a(new C43353n(System.currentTimeMillis(), C28630a.pbe), false, 1);
                    AppMethodBeat.m2505o(43329);
                }

                /* renamed from: Au */
                public final /* synthetic */ CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(43330);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(C25738R.string.fdd);
                            AppMethodBeat.m2505o(43330);
                            return string;
                        case 1:
                            string = this.hwd.getString(C25738R.string.fdc);
                            AppMethodBeat.m2505o(43330);
                            return string;
                        default:
                            String str = "";
                            AppMethodBeat.m2505o(43330);
                            return str;
                    }
                }
            };
            AppMethodBeat.m2505o(43336);
            return c346471;
        }
        C44432g a = super.mo24745a(mMActivity, c30868i);
        AppMethodBeat.m2505o(43336);
        return a;
    }

    public final String bxP() {
        return "OfflineProcess";
    }
}
