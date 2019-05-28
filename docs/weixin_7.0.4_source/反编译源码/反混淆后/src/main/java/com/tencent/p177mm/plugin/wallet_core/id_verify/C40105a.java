package com.tencent.p177mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18416uq;
import com.tencent.p177mm.p230g.p231a.C26260vc;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.C35477h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.C46365c;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletBankcardIdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSetPasswordUI;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.a */
public class C40105a extends C29615b {
    private int bFZ = 0;
    private boolean eTf = false;
    private String mActivityName = null;
    private int mMode;
    private String tuM = null;
    private boolean tuN = false;
    private int tuO = -1;

    /* renamed from: a */
    static /* synthetic */ void m68736a(C40105a c40105a, Activity activity, String str, String str2, int i, Intent intent, boolean z) {
        AppMethodBeat.m2504i(46585);
        c40105a.mo64564a(activity, str, str2, i, intent, z);
        AppMethodBeat.m2505o(46585);
    }

    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        boolean z;
        AppMethodBeat.m2504i(46580);
        mo64557F("start", activity, bundle);
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
        C4990ab.m7417i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", Boolean.valueOf(this.tuN), this.tuM, this.mActivityName);
        switch (this.mMode) {
            case 0:
                C36379x.m59950QN(10);
                mo64571b(activity, SwitchRealnameVerifyModeUI.class, bundle);
                break;
            case 1:
                bundle.putBoolean("key_need_bind_response", true);
                C36379x.m59950QN(10);
                super.mo8123a(activity, bundle);
                break;
            case 2:
                mo64571b(activity, WalletRealNameVerifyUI.class, bundle);
                break;
        }
        AppMethodBeat.m2505o(46580);
        return this;
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(46581);
        mo64557F("back", activity, Integer.valueOf(i));
        C36379x.dNV();
        if (activity instanceof SwitchRealnameVerifyModeUI) {
            if (i == 0) {
                mo8125b(activity, this.mqu);
            }
        } else if ((activity instanceof WalletRealNameVerifyUI) || (activity instanceof WalletBankcardIdUI)) {
            if (this.tuO != 0) {
                mo8125b(activity, this.mqu);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            mo8125b(activity, this.mqu);
        }
        if (activity instanceof WalletPwdConfirmUI) {
            mo64558a(activity, WalletSetPasswordUI.class, i);
        }
        AppMethodBeat.m2505o(46581);
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(46582);
        mo64557F("forward", activity, "actionCode:".concat(String.valueOf(i)), bundle);
        int i2 = this.mqu.getInt("real_name_verify_mode", this.mMode);
        if (this.mMode != i2) {
            this.mMode = i2;
        }
        if (this.mMode == 2) {
            if (activity instanceof WalletRealNameVerifyUI) {
                mo64571b(activity, WalletSetPasswordUI.class, bundle);
                AppMethodBeat.m2505o(46582);
                return;
            } else if (activity instanceof WalletSetPasswordUI) {
                mo64571b(activity, WalletPwdConfirmUI.class, bundle);
                AppMethodBeat.m2505o(46582);
                return;
            } else if (!(activity instanceof WalletPwdConfirmUI) && (activity instanceof SwitchRealnameVerifyModeUI)) {
                mo64571b(activity, WalletRealNameVerifyUI.class, bundle);
                this.mMode = 2;
                AppMethodBeat.m2505o(46582);
                return;
            }
        } else if (this.mMode == 1) {
            if (activity instanceof SwitchRealnameVerifyModeUI) {
                if (C14241r.cPI().cQg()) {
                    mo64571b(activity, WalletCheckPwdUI.class, bundle);
                    AppMethodBeat.m2505o(46582);
                    return;
                }
                mo64571b(activity, WalletBankcardIdUI.class, bundle);
                AppMethodBeat.m2505o(46582);
                return;
            } else if (activity instanceof WalletCheckPwdUI) {
                mo64571b(activity, WalletBankcardIdUI.class, bundle);
                AppMethodBeat.m2505o(46582);
                return;
            } else {
                super.mo8124a(activity, i, bundle);
                AppMethodBeat.m2505o(46582);
                return;
            }
        } else if (activity instanceof WalletRealNameVerifyUI) {
            mo64571b(activity, WalletBankcardIdUI.class, bundle);
            this.mMode = 1;
            AppMethodBeat.m2505o(46582);
            return;
        } else {
            super.mo8124a(activity, i, bundle);
        }
        AppMethodBeat.m2505o(46582);
    }

    /* renamed from: b */
    public final void mo8125b(final Activity activity, Bundle bundle) {
        Bundle bundle2;
        AppMethodBeat.m2504i(46583);
        mo64557F("end", activity, bundle);
        C36379x.dNV();
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
            Toast.makeText(activity, activity.getString(C25738R.string.din), 0).show();
        }
        final C18416uq c18416uq = new C18416uq();
        if (this.bFZ == -1) {
            c18416uq.cQP.scene = 17;
        } else if (this.bFZ == 0) {
            c18416uq.cQP.scene = 18;
        } else {
            c18416uq.cQP.scene = 0;
        }
        c18416uq.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(46575);
                c18416uq.callback = null;
                C40105a.this.eTf = true;
                C26260vc c26260vc;
                if (C5046bo.isNullOrNil(C40105a.this.tuM) || C5046bo.isNullOrNil(C40105a.this.mActivityName)) {
                    C40105a.this.mo64570aG(activity);
                    if (C40105a.this.bFZ == -1) {
                        c26260vc = new C26260vc();
                        c26260vc.cRZ.result = C40105a.this.bFZ;
                        C4879a.xxA.mo10055m(c26260vc);
                    }
                    AppMethodBeat.m2505o(46575);
                    return;
                }
                C4990ab.m7416i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + C40105a.this.tuM + C40105a.this.mActivityName);
                boolean z = C40105a.this.mqu.getBoolean("process_finish_stay_orgpage", true);
                intent.putExtra("key_process_is_end", true);
                intent.putExtra("key_process_is_stay", z);
                C40105a.m68736a(C40105a.this, activity, C40105a.this.tuM, C40105a.this.mActivityName, C40105a.this.bFZ, intent, z);
                if (C40105a.this.bFZ == -1) {
                    c26260vc = new C26260vc();
                    c26260vc.cRZ.result = C40105a.this.bFZ;
                    C4879a.xxA.mo10055m(c26260vc);
                }
                AppMethodBeat.m2505o(46575);
            }
        };
        c18416uq.callback.run();
        AppMethodBeat.m2505o(46583);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(46584);
        C44432g a;
        if (mMActivity instanceof WalletPwdConfirmUI) {
            if (this.mMode == 2) {
                C401062 c401062 = new C44432g(mMActivity, c30868i) {

                    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.a$2$1 */
                    class C401031 implements Runnable {
                        C401031() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(46576);
                            C4990ab.m7416i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                            AppMethodBeat.m2505o(46576);
                        }
                    }

                    /* renamed from: p */
                    public final boolean mo9366p(Object... objArr) {
                        AppMethodBeat.m2504i(46577);
                        C14264s c14264s = (C14264s) objArr[0];
                        String string = C40105a.this.mqu.getString("key_real_name_token");
                        if (c14264s == null || C5046bo.isNullOrNil(c14264s.guu)) {
                            C4990ab.m7412e("MicroMsg.RealNameVerifyProcess", "get pwd error");
                        } else if (C5046bo.isNullOrNil(string)) {
                            C4990ab.m7412e("MicroMsg.RealNameVerifyProcess", "get token error");
                        } else {
                            this.Agm.mo36581a(new C46365c(c14264s.guu, string, C40105a.this.mqu.getInt("entry_scene", -1)), true);
                        }
                        AppMethodBeat.m2505o(46577);
                        return true;
                    }

                    /* renamed from: c */
                    public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(46578);
                        if (c1207m instanceof C46365c) {
                            if (i == 0 && i2 == 0) {
                                C40105a.this.mqu.putInt("realname_verify_process_ret", -1);
                                C4990ab.m7416i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
                                C14241r.cPI().mo38129Km();
                                C18416uq c18416uq = new C18416uq();
                                c18416uq.cQP.scene = 16;
                                c18416uq.callback = new C401031();
                                C4879a.xxA.mo10055m(c18416uq);
                                C40105a.m68737a(C40105a.this, this.Agm);
                                C40105a.this.mo8125b(this.hwd, C40105a.this.mqu);
                                AppMethodBeat.m2505o(46578);
                                return true;
                            }
                        } else if (c1207m instanceof C35477h) {
                            AppMethodBeat.m2505o(46578);
                            return true;
                        }
                        AppMethodBeat.m2505o(46578);
                        return false;
                    }
                };
                AppMethodBeat.m2505o(46584);
                return c401062;
            }
            a = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(46584);
            return a;
        } else if (mMActivity instanceof WalletRealNameVerifyUI) {
            a = new C44432g(mMActivity, c30868i) {
                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(46579);
                    CharSequence charSequence = null;
                    if (i == 0) {
                        String string = this.hwd.getString(C25738R.string.fqa);
                        String string2 = this.hwd.getString(C25738R.string.fq7);
                        string = this.hwd.getString(C25738R.string.fqg, new Object[]{string, string2});
                        C46373j c46373j = new C46373j(this.hwd);
                        SpannableString spannableString = new SpannableString(string);
                        spannableString.setSpan(c46373j, string.length() - string2.length(), string.length(), 33);
                        charSequence = spannableString.subSequence(0, spannableString.length());
                    }
                    AppMethodBeat.m2505o(46579);
                    return charSequence;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    return false;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    return false;
                }
            };
            AppMethodBeat.m2505o(46584);
            return a;
        } else {
            a = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(46584);
            return a;
        }
    }

    public final String bxP() {
        return "realname_verify_process";
    }

    /* renamed from: a */
    public final int mo26468a(MMActivity mMActivity, int i) {
        return C25738R.string.fgu;
    }
}
