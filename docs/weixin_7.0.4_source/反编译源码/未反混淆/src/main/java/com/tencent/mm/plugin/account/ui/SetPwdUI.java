package com.tencent.mm.plugin.account.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;

public abstract class SetPwdUI extends MMActivity implements f {
    protected ProgressDialog ehJ = null;
    protected String gHW;
    protected String gHX;
    public boolean gHY = true;

    public abstract void a(a aVar);

    public abstract m ark();

    public abstract String arl();

    public abstract String arm();

    public abstract boolean k(int i, int i2, String str);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        g.Rg().a(arn(), (f) this);
        super.onCreate(bundle);
        a(0, getString(R.string.qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125567);
                SetPwdUI.this.art();
                AppMethodBeat.o(125567);
                return true;
            }
        }, b.GREEN);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125568);
                SetPwdUI setPwdUI = SetPwdUI.this;
                if (setPwdUI.aru() && setPwdUI.gHY) {
                    ab.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                    h.pYm.e(11868, Integer.valueOf(1));
                }
                setPwdUI.aqX();
                setPwdUI.setResult(0);
                setPwdUI.finish();
                AppMethodBeat.o(125568);
                return true;
            }
        });
    }

    public void onDestroy() {
        g.Rg().b(arn(), (f) this);
        super.onDestroy();
    }

    /* Access modifiers changed, original: protected */
    public ProgressDialog a(Context context, String str, OnCancelListener onCancelListener) {
        return com.tencent.mm.ui.base.h.b(context, str, true, onCancelListener);
    }

    /* Access modifiers changed, original: protected */
    public int arn() {
        return 383;
    }

    /* Access modifiers changed, original: protected|final */
    public final void arJ() {
        this.gHW = arl();
        this.gHX = arm();
        if (!bo.isNullOrNil(this.gHW)) {
            if (!this.gHW.equals(this.gHX)) {
                a(a.TwoPasswordsNotMatch);
            } else if (this.gHW.length() > 16) {
                a(a.BeyondMaximumLength);
            } else if (bo.amT(this.gHW)) {
                com.tencent.mm.ui.base.h.g(this, R.string.dkt, R.string.dln);
            } else if (bo.amY(this.gHW)) {
                aqX();
                final m ark = ark();
                g.Rg().a(ark, 0);
                getString(R.string.tz);
                this.ehJ = a(this, getString(R.string.dju), new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125566);
                        g.Rg().c(ark);
                        AppMethodBeat.o(125566);
                    }
                });
                if (aru() && !this.gHY) {
                    ab.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
                    h.pYm.e(11868, Integer.valueOf(0));
                }
            } else if (this.gHW.length() < 8 || this.gHW.length() >= 16) {
                a(a.NotReachMinimumLength);
            } else {
                a(a.DisallowShortNumericPassword);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void art() {
        arJ();
    }

    public void onSceneEnd(final int i, final int i2, final String str, m mVar) {
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (mVar.getType() == arn()) {
            if (mVar.getType() == 383) {
                if (i == 0 && i2 == 0) {
                    String string;
                    byg byg;
                    if (bo.isNullOrNil((String) g.RP().Ry().get(6, null))) {
                        ab.i("MicroMsg.SetPwdUI", "has not bind mobile");
                        string = getString(R.string.d7o);
                    } else {
                        ab.i("MicroMsg.SetPwdUI", "has bind mobile");
                        string = getString(R.string.a8a);
                    }
                    x xVar = (x) mVar;
                    if (xVar.ehh == null || xVar.ehh.fsH.fsP == null) {
                        byg = null;
                    } else {
                        byg = (byg) xVar.ehh.fsH.fsP;
                    }
                    if (!(byg == null || byg.vHH == null)) {
                        byte[] toByteArray = byg.vHH.getBuffer().toByteArray();
                        Editor edit = ah.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.h.Mu()).edit();
                        edit.putBoolean("key_auth_info_prefs_created", true);
                        edit.putInt("key_auth_update_version", d.vxo);
                        edit.putString("_auth_key", bo.cd(toByteArray));
                        g.RN();
                        edit.putInt("_auth_uin", com.tencent.mm.kernel.a.QF());
                        edit.commit();
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, string, "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125569);
                            SetPwdUI.this.setResult(-1);
                            if (SetPwdUI.this.k(i, i2, str)) {
                                AppMethodBeat.o(125569);
                            } else {
                                AppMethodBeat.o(125569);
                            }
                        }
                    });
                }
            } else if (!k(i, i2, str)) {
                Toast.makeText(this, getString(R.string.byr, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean j(int i, int i2, String str) {
        if (com.tencent.mm.plugin.account.a.a.gkF.a(this.mController.ylL, i, i2, str)) {
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
                ab.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                h.pYm.e(11868, Integer.valueOf(1));
            }
            super.onBackPressed();
        }
    }
}
