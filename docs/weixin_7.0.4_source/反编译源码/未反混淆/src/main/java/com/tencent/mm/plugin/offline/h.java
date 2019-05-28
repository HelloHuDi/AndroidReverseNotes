package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.p;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class h extends c {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43331);
        b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.o(43331);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(43332);
        if (activity instanceof WalletCheckPwdUI) {
            F(activity);
        }
        AppMethodBeat.o(43332);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(43333);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(43333);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43334);
        F(activity);
        if (bundle != null && bundle.getBoolean("is_offline_create")) {
            a.W((WalletBaseUI) activity);
        }
        AppMethodBeat.o(43334);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final void F(Activity activity) {
        int i = 2;
        AppMethodBeat.i(43335);
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
            com.tencent.mm.plugin.report.service.h.pYm.e(14096, Integer.valueOf(i));
            Intent intent = new Intent(activity, WalletOfflineEntranceUI.class);
            intent.putExtra("key_from_scene", i2);
            intent.putExtra("is_offline_create", true);
            a(activity, WalletOfflineEntranceUI.class, intent);
            activity.finish();
        }
        AppMethodBeat.o(43335);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(43336);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(43327);
                    if (i == 0 && i2 == 0) {
                        if (mVar instanceof k) {
                            ab.i("MicroMsg.OfflineProcess", "Offline is Create ");
                            bXe();
                            h.this.mqu.putBoolean("is_offline_create", true);
                        } else if (mVar instanceof n) {
                            ab.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
                            i iVar = this.Agm;
                            if (iVar.gII == null || !(iVar.gII == null || iVar.gII.isShowing())) {
                                if (iVar.gII != null) {
                                    iVar.gII.dismiss();
                                }
                                if (iVar.mContext == null) {
                                    ab.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                                } else {
                                    iVar.gII = com.tencent.mm.wallet_core.ui.g.a(iVar.mContext, false, new OnCancelListener() {
                                        public final void onCancel(DialogInterface dialogInterface) {
                                            AppMethodBeat.i(49146);
                                            i.this.bLz();
                                            AppMethodBeat.o(49146);
                                        }
                                    });
                                }
                            }
                            uq uqVar = new uq();
                            uqVar.cQP.scene = 8;
                            uqVar.cQQ.cQH = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(43324);
                                    ab.d("MicroMsg.OfflineProcess", "tofutest do callback");
                                    h.this.a(AnonymousClass1.this.hwd, 0, h.this.mqu);
                                    AnonymousClass1.this.Agm.cNM();
                                    AppMethodBeat.o(43324);
                                }
                            };
                            com.tencent.mm.sdk.b.a.xxA.m(uqVar);
                        } else if (mVar instanceof com.tencent.mm.plugin.offline.a.i) {
                            com.tencent.mm.plugin.offline.a.i iVar2 = (com.tencent.mm.plugin.offline.a.i) mVar;
                            if ("1".equals(iVar2.oYi)) {
                                Activity activity = this.hwd;
                                String str2 = iVar2.cFl;
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("key_authen", new Authen());
                                bundle.putString("key_pwd1", h.this.mqu.getString("key_pwd1"));
                                bundle.putString("key_mobile", str2);
                                bundle.putInt("verify_scene", 1);
                                bundle.putInt("offline_add_fee", h.this.mqu.getInt("offline_chg_fee", 0));
                                com.tencent.mm.wallet_core.a.a(activity, l.class, bundle);
                                h.this.a(activity, 0, h.this.mqu);
                            } else {
                                h.this.mqu.putBoolean("back_to_coin_purse_ui", true);
                                bXe();
                            }
                        } else if (mVar instanceof p) {
                            a.Ud("");
                            k.bXg();
                            k.bXh().oYL = null;
                            h.this.a(this.hwd, 0, h.this.mqu);
                        }
                        AppMethodBeat.o(43327);
                        return true;
                    }
                    if (mVar instanceof k) {
                        ab.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
                        k kVar = (k) mVar;
                        if (i2 == 410) {
                            final MMActivity mMActivity = this.hwd;
                            final int i3 = kVar.oYw;
                            com.tencent.mm.ui.base.h.d(mMActivity, str, "", mMActivity.getString(R.string.fnt), mMActivity.getString(R.string.or), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(43325);
                                    com.tencent.mm.pluginsdk.wallet.h.aj(mMActivity, i3);
                                    h.this.a(mMActivity, 0, h.this.mqu);
                                    AppMethodBeat.o(43325);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(43326);
                                    h.this.a(mMActivity, 0, h.this.mqu);
                                    AppMethodBeat.o(43326);
                                }
                            });
                            AppMethodBeat.o(43327);
                            return true;
                        }
                    }
                    AppMethodBeat.o(43327);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(43328);
                    String str = (String) objArr[0];
                    h.this.mqu.putString("key_pwd1", str);
                    Bankcard bYg = a.bYg();
                    if (bYg == null) {
                        ab.e("MicroMsg.OfflineProcess", "no support bank car for offline");
                        bYg = a.bYh();
                    }
                    if (bYg == null) {
                        ab.e("MicroMsg.OfflineProcess", "no any bank car for offline");
                        AppMethodBeat.o(43328);
                        return false;
                    }
                    String string = h.this.mqu.getString("oper");
                    if (!a.bYd()) {
                        ab.i("MicroMsg.OfflineProcess", "Offline is not Create ");
                        this.Agm.a(new k(bYg, (String) objArr[0], h.this.mqu.getInt("offline_chg_fee", 0)), true, 1);
                    } else if (string != null) {
                        ab.i("MicroMsg.OfflineProcess", "oper == ".concat(String.valueOf(string)));
                        if (string.equals("create")) {
                            this.Agm.a(new k(bYg, (String) objArr[0], h.this.mqu.getInt("offline_chg_fee", 0)), true, 1);
                        } else if (string.equals("clr")) {
                            this.Agm.a(new com.tencent.mm.plugin.offline.a.i(bYg, str, "clr", 0, ""), true, 1);
                        } else if (string.equals("changeto")) {
                            this.Agm.a(new com.tencent.mm.plugin.offline.a.i(bYg, str, "changeto", h.this.mqu.getInt("offline_chg_fee"), ""), true, 1);
                        } else if (string.equals("freeze")) {
                            this.Agm.a(new p(str), true, 1);
                        } else {
                            AppMethodBeat.o(43328);
                            return false;
                        }
                    }
                    AppMethodBeat.o(43328);
                    return true;
                }

                private void bXe() {
                    AppMethodBeat.i(43329);
                    this.Agm.a(new n(System.currentTimeMillis(), a.pbe), false, 1);
                    AppMethodBeat.o(43329);
                }

                public final /* synthetic */ CharSequence Au(int i) {
                    AppMethodBeat.i(43330);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(R.string.fdd);
                            AppMethodBeat.o(43330);
                            return string;
                        case 1:
                            string = this.hwd.getString(R.string.fdc);
                            AppMethodBeat.o(43330);
                            return string;
                        default:
                            String str = "";
                            AppMethodBeat.o(43330);
                            return str;
                    }
                }
            };
            AppMethodBeat.o(43336);
            return anonymousClass1;
        }
        g a = super.a(mMActivity, iVar);
        AppMethodBeat.o(43336);
        return a;
    }

    public final String bxP() {
        return "OfflineProcess";
    }
}
