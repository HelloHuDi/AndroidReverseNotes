package com.tencent.p177mm.plugin.exdevice.p393ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C6850n;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI */
public class ExdeviceSettingUI extends MMPreference implements C1202f {
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

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI$1 */
    class C278871 implements OnMenuItemClickListener {
        C278871() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(20215);
            ExdeviceSettingUI.this.finish();
            AppMethodBeat.m2505o(20215);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI$3 */
    class C340663 implements Runnable {
        C340663() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20217);
            ExdeviceSettingUI.this.lDP.dismiss();
            AppMethodBeat.m2505o(20217);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI$2 */
    class C389812 implements Runnable {
        C389812() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20216);
            ExdeviceSettingUI.this.lDP.dismiss();
            AppMethodBeat.m2505o(20216);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20218);
        super.onCreate(bundle);
        C22162d.m33785kT(38);
        C9638aw.m17182Rg().mo14539a((int) FilterEnum4Shaka.MIC_SHAKA_ADD2_9, (C1202f) this);
        this.lDQ = (CheckBoxPreference) this.yCw.aqO("notify_rank");
        this.lDR = (CheckBoxPreference) this.yCw.aqO("notify_like");
        this.lDS = (CheckBoxPreference) this.yCw.aqO("join_rank");
        C9638aw.m17190ZK();
        Integer num = (Integer) C18628c.m29072Ry().get(397310, Integer.valueOf(0));
        C4990ab.m7411d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", num);
        if (num == null || num.intValue() == 0) {
            this.lDO = false;
            this.lDQ.uOT = true;
            this.lDR.uOT = true;
            this.lDS.uOT = true;
            this.yCw.notifyDataSetChanged();
            this.lDP = C44275p.show(this, "", "", true, false);
        } else {
            this.lDO = true;
            this.bJt = num.intValue();
            bqc();
        }
        C9638aw.m17182Rg().mo14541a(new C6850n(2, 0), 0);
        setMMTitle((int) C25738R.string.dl0);
        setBackBtn(new C278871());
        AppMethodBeat.m2505o(20218);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(20219);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b((int) FilterEnum4Shaka.MIC_SHAKA_ADD2_9, (C1202f) this);
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
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(397310, Integer.valueOf(this.bJt));
            C4990ab.m7411d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", Integer.valueOf(this.bJt));
            C9638aw.m17182Rg().mo14541a(new C6850n(1, this.bJt), 0);
        }
        AppMethodBeat.m2505o(20219);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8504ao;
    }

    private void bqc() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(20220);
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
        AppMethodBeat.m2505o(20220);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(20221);
        if (i == 0 && i2 == 0) {
            C4990ab.m7410d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
            C6850n c6850n = (C6850n) c1207m;
            if (c6850n.opType != 2) {
                C4990ab.m7417i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", Integer.valueOf(c6850n.opType));
                AppMethodBeat.m2505o(20221);
                return;
            }
            if (this.lDP != null && this.lDP.isShowing()) {
                runOnUiThread(new C389812());
            }
            this.lDO = true;
            if (this.bJt == c6850n.lwd) {
                C4990ab.m7417i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", Integer.valueOf(this.bJt));
                AppMethodBeat.m2505o(20221);
                return;
            }
            this.bJt = c6850n.lwd;
            C4990ab.m7411d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", Integer.valueOf(this.bJt));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(397310, Integer.valueOf(this.bJt));
            if (!this.lDT) {
                bqc();
            }
            AppMethodBeat.m2505o(20221);
            return;
        }
        if (this.lDP != null && this.lDP.isShowing()) {
            runOnUiThread(new C340663());
        }
        Toast.makeText(this, "scene error", 0).show();
        finish();
        AppMethodBeat.m2505o(20221);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(20222);
        C4990ab.m7411d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", preference.mKey);
        if (preference.mKey.equals("black_contact_list")) {
            C25985d.m41448H(this, "sport", ".ui.SportBlackListUI");
        } else {
            this.lDT = true;
        }
        AppMethodBeat.m2505o(20222);
        return false;
    }
}
