package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C45454x;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a.C18796a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.byg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.SetPwdUI */
public abstract class SetPwdUI extends MMActivity implements C1202f {
    protected ProgressDialog ehJ = null;
    protected String gHW;
    protected String gHX;
    public boolean gHY = true;

    /* renamed from: com.tencent.mm.plugin.account.ui.SetPwdUI$2 */
    class C423002 implements OnMenuItemClickListener {
        C423002() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125567);
            SetPwdUI.this.art();
            AppMethodBeat.m2505o(125567);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.SetPwdUI$3 */
    class C423013 implements OnMenuItemClickListener {
        C423013() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125568);
            SetPwdUI setPwdUI = SetPwdUI.this;
            if (setPwdUI.aru() && setPwdUI.gHY) {
                C4990ab.m7410d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                C7060h.pYm.mo8381e(11868, Integer.valueOf(1));
            }
            setPwdUI.aqX();
            setPwdUI.setResult(0);
            setPwdUI.finish();
            AppMethodBeat.m2505o(125568);
            return true;
        }
    }

    /* renamed from: a */
    public abstract void mo53562a(C18796a c18796a);

    public abstract C1207m ark();

    public abstract String arl();

    public abstract String arm();

    /* renamed from: k */
    public abstract boolean mo53567k(int i, int i2, String str);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        C1720g.m3540Rg().mo14539a(arn(), (C1202f) this);
        super.onCreate(bundle);
        mo17379a(0, getString(C25738R.string.f9142qt), (OnMenuItemClickListener) new C423002(), C5535b.GREEN);
        setBackBtn(new C423013());
    }

    public void onDestroy() {
        C1720g.m3540Rg().mo14546b(arn(), (C1202f) this);
        super.onDestroy();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public ProgressDialog mo53561a(Context context, String str, OnCancelListener onCancelListener) {
        return C30379h.m48458b(context, str, true, onCancelListener);
    }

    /* Access modifiers changed, original: protected */
    public int arn() {
        return 383;
    }

    /* Access modifiers changed, original: protected|final */
    public final void arJ() {
        this.gHW = arl();
        this.gHX = arm();
        if (!C5046bo.isNullOrNil(this.gHW)) {
            if (!this.gHW.equals(this.gHX)) {
                mo53562a(C18796a.TwoPasswordsNotMatch);
            } else if (this.gHW.length() > 16) {
                mo53562a(C18796a.BeyondMaximumLength);
            } else if (C5046bo.amT(this.gHW)) {
                C30379h.m48467g(this, C25738R.string.dkt, C25738R.string.dln);
            } else if (C5046bo.amY(this.gHW)) {
                aqX();
                final C1207m ark = ark();
                C1720g.m3540Rg().mo14541a(ark, 0);
                getString(C25738R.string.f9238tz);
                this.ehJ = mo53561a(this, getString(C25738R.string.dju), new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(125566);
                        C1720g.m3540Rg().mo14547c(ark);
                        AppMethodBeat.m2505o(125566);
                    }
                });
                if (aru() && !this.gHY) {
                    C4990ab.m7410d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
                    C7060h.pYm.mo8381e(11868, Integer.valueOf(0));
                }
            } else if (this.gHW.length() < 8 || this.gHW.length() >= 16) {
                mo53562a(C18796a.NotReachMinimumLength);
            } else {
                mo53562a(C18796a.DisallowShortNumericPassword);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void art() {
        arJ();
    }

    public void onSceneEnd(final int i, final int i2, final String str, C1207m c1207m) {
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (c1207m.getType() == arn()) {
            if (c1207m.getType() == 383) {
                if (i == 0 && i2 == 0) {
                    String string;
                    byg byg;
                    if (C5046bo.isNullOrNil((String) C1720g.m3536RP().mo5239Ry().get(6, null))) {
                        C4990ab.m7416i("MicroMsg.SetPwdUI", "has not bind mobile");
                        string = getString(C25738R.string.d7o);
                    } else {
                        C4990ab.m7416i("MicroMsg.SetPwdUI", "has bind mobile");
                        string = getString(C25738R.string.a8a);
                    }
                    C45454x c45454x = (C45454x) c1207m;
                    if (c45454x.ehh == null || c45454x.ehh.fsH.fsP == null) {
                        byg = null;
                    } else {
                        byg = (byg) c45454x.ehh.fsH.fsP;
                    }
                    if (!(byg == null || byg.vHH == null)) {
                        byte[] toByteArray = byg.vHH.getBuffer().toByteArray();
                        Editor edit = C4996ah.getContext().getSharedPreferences("auth_info_key_prefs", C1448h.m3078Mu()).edit();
                        edit.putBoolean("key_auth_info_prefs_created", true);
                        edit.putInt("key_auth_update_version", C7243d.vxo);
                        edit.putString("_auth_key", C5046bo.m7543cd(toByteArray));
                        C1720g.m3534RN();
                        edit.putInt("_auth_uin", C1668a.m3383QF());
                        edit.commit();
                    }
                    C30379h.m48448a((Context) this, string, "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(125569);
                            SetPwdUI.this.setResult(-1);
                            if (SetPwdUI.this.mo53567k(i, i2, str)) {
                                AppMethodBeat.m2505o(125569);
                            } else {
                                AppMethodBeat.m2505o(125569);
                            }
                        }
                    });
                }
            } else if (!mo53567k(i, i2, str)) {
                Toast.makeText(this, getString(C25738R.string.byr, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: j */
    public final boolean mo67826j(int i, int i2, String str) {
        if (C24679a.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
            return true;
        }
        return false;
    }

    public boolean aru() {
        return false;
    }

    public void onBackPressed() {
        if (this.gHY) {
            if (aru()) {
                C4990ab.m7410d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                C7060h.pYm.mo8381e(11868, Integer.valueOf(1));
            }
            super.onBackPressed();
        }
    }
}
