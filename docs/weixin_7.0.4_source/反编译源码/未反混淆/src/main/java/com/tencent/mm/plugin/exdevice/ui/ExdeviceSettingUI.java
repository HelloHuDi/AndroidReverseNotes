package com.tencent.mm.plugin.exdevice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.f.a.n;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.ttpic.FilterEnum4Shaka;

public class ExdeviceSettingUI extends MMPreference implements f {
    int bJt = -1;
    private final String lDL = "notify_rank";
    private final String lDM = "notify_like";
    private final String lDN = "join_rank";
    boolean lDO;
    private ProgressDialog lDP;
    private CheckBoxPreference lDQ;
    private CheckBoxPreference lDR;
    private CheckBoxPreference lDS;
    private boolean lDT;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20218);
        super.onCreate(bundle);
        d.kT(38);
        aw.Rg().a((int) FilterEnum4Shaka.MIC_SHAKA_ADD2_9, (f) this);
        this.lDQ = (CheckBoxPreference) this.yCw.aqO("notify_rank");
        this.lDR = (CheckBoxPreference) this.yCw.aqO("notify_like");
        this.lDS = (CheckBoxPreference) this.yCw.aqO("join_rank");
        aw.ZK();
        Integer num = (Integer) c.Ry().get(397310, Integer.valueOf(0));
        ab.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", num);
        if (num == null || num.intValue() == 0) {
            this.lDO = false;
            this.lDQ.uOT = true;
            this.lDR.uOT = true;
            this.lDS.uOT = true;
            this.yCw.notifyDataSetChanged();
            this.lDP = p.show(this, "", "", true, false);
        } else {
            this.lDO = true;
            this.bJt = num.intValue();
            bqc();
        }
        aw.Rg().a(new n(2, 0), 0);
        setMMTitle((int) R.string.dl0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20215);
                ExdeviceSettingUI.this.finish();
                AppMethodBeat.o(20215);
                return false;
            }
        });
        AppMethodBeat.o(20218);
    }

    public void onDestroy() {
        AppMethodBeat.i(20219);
        super.onDestroy();
        aw.Rg().b((int) FilterEnum4Shaka.MIC_SHAKA_ADD2_9, (f) this);
        if (this.lDP != null && this.lDP.isShowing()) {
            this.lDP.dismiss();
        }
        if (this.lDO) {
            if (this.lDQ.isChecked()) {
                this.bJt |= 1;
            } else {
                this.bJt &= -2;
            }
            if (this.lDR.isChecked()) {
                this.bJt |= 2;
            } else {
                this.bJt &= -3;
            }
            if (this.lDS.isChecked()) {
                this.bJt |= 8;
            } else {
                this.bJt &= -9;
            }
            aw.ZK();
            c.Ry().set(397310, Integer.valueOf(this.bJt));
            ab.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", Integer.valueOf(this.bJt));
            aw.Rg().a(new n(1, this.bJt), 0);
        }
        AppMethodBeat.o(20219);
    }

    public final int JC() {
        return R.xml.ao;
    }

    private void bqc() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(20220);
        CheckBoxPreference checkBoxPreference = this.lDQ;
        if ((this.bJt & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference.uOT = z;
        checkBoxPreference = this.lDR;
        if ((this.bJt & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference.uOT = z;
        CheckBoxPreference checkBoxPreference2 = this.lDS;
        if ((this.bJt & 8) != 8) {
            z2 = false;
        }
        checkBoxPreference2.uOT = z2;
        this.yCw.notifyDataSetChanged();
        AppMethodBeat.o(20220);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(20221);
        if (i == 0 && i2 == 0) {
            ab.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
            n nVar = (n) mVar;
            if (nVar.opType != 2) {
                ab.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", Integer.valueOf(nVar.opType));
                AppMethodBeat.o(20221);
                return;
            }
            if (this.lDP != null && this.lDP.isShowing()) {
                runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(20216);
                        ExdeviceSettingUI.this.lDP.dismiss();
                        AppMethodBeat.o(20216);
                    }
                });
            }
            this.lDO = true;
            if (this.bJt == nVar.lwd) {
                ab.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", Integer.valueOf(this.bJt));
                AppMethodBeat.o(20221);
                return;
            }
            this.bJt = nVar.lwd;
            ab.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", Integer.valueOf(this.bJt));
            aw.ZK();
            c.Ry().set(397310, Integer.valueOf(this.bJt));
            if (!this.lDT) {
                bqc();
            }
            AppMethodBeat.o(20221);
            return;
        }
        if (this.lDP != null && this.lDP.isShowing()) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20217);
                    ExdeviceSettingUI.this.lDP.dismiss();
                    AppMethodBeat.o(20217);
                }
            });
        }
        Toast.makeText(this, "scene error", 0).show();
        finish();
        AppMethodBeat.o(20221);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(20222);
        ab.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", preference.mKey);
        if (preference.mKey.equals("black_contact_list")) {
            com.tencent.mm.bp.d.H(this, "sport", ".ui.SportBlackListUI");
        } else {
            this.lDT = true;
        }
        AppMethodBeat.o(20222);
        return false;
    }
}
