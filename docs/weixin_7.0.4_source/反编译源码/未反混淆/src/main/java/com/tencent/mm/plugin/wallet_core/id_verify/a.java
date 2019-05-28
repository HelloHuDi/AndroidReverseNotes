package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends b {
    private int bFZ = 0;
    private boolean eTf = false;
    private String mActivityName = null;
    private int mMode;
    private String tuM = null;
    private boolean tuN = false;
    private int tuO = -1;

    static /* synthetic */ void a(a aVar, Activity activity, String str, String str2, int i, Intent intent, boolean z) {
        AppMethodBeat.i(46585);
        aVar.a(activity, str, str2, i, intent, z);
        AppMethodBeat.o(46585);
    }

    public final c a(Activity activity, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(46580);
        F("start", activity, bundle);
        if (this.mqu == null) {
            this.mqu = new Bundle();
        }
        if (bundle == null) {
            bundle = this.mqu;
        }
        if (bundle != null) {
            this.mMode = bundle.getInt("real_name_verify_mode", 0);
        } else {
            this.mMode = 0;
        }
        this.tuO = this.mMode;
        bundle.putBoolean("key_is_realname_verify_process", true);
        this.tuM = bundle.getString("realname_verify_process_jump_plugin", "");
        this.mActivityName = bundle.getString("realname_verify_process_jump_activity", "");
        if (bundle.getInt("realname_verify_process_allow_idverify", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.tuN = z;
        ab.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", Boolean.valueOf(this.tuN), this.tuM, this.mActivityName);
        switch (this.mMode) {
            case 0:
                x.QN(10);
                b(activity, SwitchRealnameVerifyModeUI.class, bundle);
                break;
            case 1:
                bundle.putBoolean("key_need_bind_response", true);
                x.QN(10);
                super.a(activity, bundle);
                break;
            case 2:
                b(activity, WalletRealNameVerifyUI.class, bundle);
                break;
        }
        AppMethodBeat.o(46580);
        return this;
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(46581);
        F("back", activity, Integer.valueOf(i));
        x.dNV();
        if (activity instanceof SwitchRealnameVerifyModeUI) {
            if (i == 0) {
                b(activity, this.mqu);
            }
        } else if ((activity instanceof WalletRealNameVerifyUI) || (activity instanceof WalletBankcardIdUI)) {
            if (this.tuO != 0) {
                b(activity, this.mqu);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, this.mqu);
        }
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
        AppMethodBeat.o(46581);
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(46582);
        F("forward", activity, "actionCode:".concat(String.valueOf(i)), bundle);
        int i2 = this.mqu.getInt("real_name_verify_mode", this.mMode);
        if (this.mMode != i2) {
            this.mMode = i2;
        }
        if (this.mMode == 2) {
            if (activity instanceof WalletRealNameVerifyUI) {
                b(activity, WalletSetPasswordUI.class, bundle);
                AppMethodBeat.o(46582);
                return;
            } else if (activity instanceof WalletSetPasswordUI) {
                b(activity, WalletPwdConfirmUI.class, bundle);
                AppMethodBeat.o(46582);
                return;
            } else if (!(activity instanceof WalletPwdConfirmUI) && (activity instanceof SwitchRealnameVerifyModeUI)) {
                b(activity, WalletRealNameVerifyUI.class, bundle);
                this.mMode = 2;
                AppMethodBeat.o(46582);
                return;
            }
        } else if (this.mMode == 1) {
            if (activity instanceof SwitchRealnameVerifyModeUI) {
                if (r.cPI().cQg()) {
                    b(activity, WalletCheckPwdUI.class, bundle);
                    AppMethodBeat.o(46582);
                    return;
                }
                b(activity, WalletBankcardIdUI.class, bundle);
                AppMethodBeat.o(46582);
                return;
            } else if (activity instanceof WalletCheckPwdUI) {
                b(activity, WalletBankcardIdUI.class, bundle);
                AppMethodBeat.o(46582);
                return;
            } else {
                super.a(activity, i, bundle);
                AppMethodBeat.o(46582);
                return;
            }
        } else if (activity instanceof WalletRealNameVerifyUI) {
            b(activity, WalletBankcardIdUI.class, bundle);
            this.mMode = 1;
            AppMethodBeat.o(46582);
            return;
        } else {
            super.a(activity, i, bundle);
        }
        AppMethodBeat.o(46582);
    }

    public final void b(final Activity activity, Bundle bundle) {
        Bundle bundle2;
        AppMethodBeat.i(46583);
        F("end", activity, bundle);
        x.dNV();
        if (bundle == null) {
            bundle2 = this.mqu;
        } else {
            bundle2 = bundle;
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if (this.mMode == 1) {
            dNI();
            if (bundle2.getBoolean("intent_bind_end", false)) {
                this.bFZ = -1;
            } else {
                this.bFZ = 0;
            }
        } else if (bundle2.containsKey("realname_verify_process_ret")) {
            this.bFZ = bundle2.getInt("realname_verify_process_ret", -1);
        } else {
            this.bFZ = 0;
        }
        if (bundle2.containsKey("intent_bind_end")) {
            bundle2.remove("intent_bind_end");
        }
        if (bundle2.containsKey("key_is_bind_reg_process")) {
            bundle2.remove("key_is_bind_reg_process");
        }
        bundle2.putInt("realname_verify_process_ret", this.bFZ);
        final Intent intent = new Intent();
        intent.putExtras(bundle2);
        if (this.bFZ == -1) {
            Toast.makeText(activity, activity.getString(R.string.din), 0).show();
        }
        final uq uqVar = new uq();
        if (this.bFZ == -1) {
            uqVar.cQP.scene = 17;
        } else if (this.bFZ == 0) {
            uqVar.cQP.scene = 18;
        } else {
            uqVar.cQP.scene = 0;
        }
        uqVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(46575);
                uqVar.callback = null;
                a.this.eTf = true;
                vc vcVar;
                if (bo.isNullOrNil(a.this.tuM) || bo.isNullOrNil(a.this.mActivityName)) {
                    a.this.aG(activity);
                    if (a.this.bFZ == -1) {
                        vcVar = new vc();
                        vcVar.cRZ.result = a.this.bFZ;
                        com.tencent.mm.sdk.b.a.xxA.m(vcVar);
                    }
                    AppMethodBeat.o(46575);
                    return;
                }
                ab.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + a.this.tuM + a.this.mActivityName);
                boolean z = a.this.mqu.getBoolean("process_finish_stay_orgpage", true);
                intent.putExtra("key_process_is_end", true);
                intent.putExtra("key_process_is_stay", z);
                a.a(a.this, activity, a.this.tuM, a.this.mActivityName, a.this.bFZ, intent, z);
                if (a.this.bFZ == -1) {
                    vcVar = new vc();
                    vcVar.cRZ.result = a.this.bFZ;
                    com.tencent.mm.sdk.b.a.xxA.m(vcVar);
                }
                AppMethodBeat.o(46575);
            }
        };
        uqVar.callback.run();
        AppMethodBeat.o(46583);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(46584);
        g a;
        if (mMActivity instanceof WalletPwdConfirmUI) {
            if (this.mMode == 2) {
                AnonymousClass2 anonymousClass2 = new g(mMActivity, iVar) {
                    public final boolean p(Object... objArr) {
                        AppMethodBeat.i(46577);
                        s sVar = (s) objArr[0];
                        String string = a.this.mqu.getString("key_real_name_token");
                        if (sVar == null || bo.isNullOrNil(sVar.guu)) {
                            ab.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
                        } else if (bo.isNullOrNil(string)) {
                            ab.e("MicroMsg.RealNameVerifyProcess", "get token error");
                        } else {
                            this.Agm.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.c(sVar.guu, string, a.this.mqu.getInt("entry_scene", -1)), true);
                        }
                        AppMethodBeat.o(46577);
                        return true;
                    }

                    public final boolean c(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(46578);
                        if (mVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.c) {
                            if (i == 0 && i2 == 0) {
                                a.this.mqu.putInt("realname_verify_process_ret", -1);
                                ab.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
                                r.cPI().Km();
                                uq uqVar = new uq();
                                uqVar.cQP.scene = 16;
                                uqVar.callback = new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(46576);
                                        ab.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                                        AppMethodBeat.o(46576);
                                    }
                                };
                                com.tencent.mm.sdk.b.a.xxA.m(uqVar);
                                a.a(a.this, this.Agm);
                                a.this.b(this.hwd, a.this.mqu);
                                AppMethodBeat.o(46578);
                                return true;
                            }
                        } else if (mVar instanceof h) {
                            AppMethodBeat.o(46578);
                            return true;
                        }
                        AppMethodBeat.o(46578);
                        return false;
                    }
                };
                AppMethodBeat.o(46584);
                return anonymousClass2;
            }
            a = super.a(mMActivity, iVar);
            AppMethodBeat.o(46584);
            return a;
        } else if (mMActivity instanceof WalletRealNameVerifyUI) {
            a = new g(mMActivity, iVar) {
                public final CharSequence Au(int i) {
                    AppMethodBeat.i(46579);
                    CharSequence charSequence = null;
                    if (i == 0) {
                        String string = this.hwd.getString(R.string.fqa);
                        String string2 = this.hwd.getString(R.string.fq7);
                        string = this.hwd.getString(R.string.fqg, new Object[]{string, string2});
                        j jVar = new j(this.hwd);
                        SpannableString spannableString = new SpannableString(string);
                        spannableString.setSpan(jVar, string.length() - string2.length(), string.length(), 33);
                        charSequence = spannableString.subSequence(0, spannableString.length());
                    }
                    AppMethodBeat.o(46579);
                    return charSequence;
                }

                public final boolean p(Object... objArr) {
                    return false;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }
            };
            AppMethodBeat.o(46584);
            return a;
        } else {
            a = super.a(mMActivity, iVar);
            AppMethodBeat.o(46584);
            return a;
        }
    }

    public final String bxP() {
        return "realname_verify_process";
    }

    public final int a(MMActivity mMActivity, int i) {
        return R.string.fgu;
    }
}
