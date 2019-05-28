package com.tencent.p177mm.plugin.setting.p505ui.fixtools;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.model.C28929a;
import com.tencent.p177mm.plugin.setting.p505ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C5059g;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI */
public class FixToolsUI extends MMPreference {
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI$1 */
    class C37791 implements OnMenuItemClickListener {
        C37791() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126883);
            FixToolsUI.this.finish();
            AppMethodBeat.m2505o(126883);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(126884);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        setMMTitle((int) C25738R.string.bvl);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.ehK.aqO("fix_tools_micromsg_header");
        String ar = C5059g.m7672ar(this.mController.ylL, C7243d.vxo);
        if (C7243d.vxr) {
            ar = ar + " " + getString(C25738R.string.f8807fk);
        }
        settingsAboutMMHeaderPreference.qlS = ar;
        C7060h.pYm.mo8378a(873, (long) getIntent().getIntExtra("entry_fix_tools", 2), 1, false);
        C7060h.pYm.mo8378a(873, 0, 1, false);
        setBackBtn(new C37791());
        AppMethodBeat.m2505o(126884);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8510au;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(126885);
        Intent intent;
        if (preference.mKey.equals("fix_tools_uplog")) {
            if (C28929a.cir().fPO) {
                MMWizardActivity.m23791J(this, new Intent(this.mController.ylL, FixToolsUpLogUploadingUI.class));
            } else {
                intent = new Intent(this.mController.ylL, FixToolsUplogUI.class);
                intent.putExtra("entry_fix_tools_uplog", 9);
                MMWizardActivity.m23791J(this, intent);
            }
            AppMethodBeat.m2505o(126885);
            return true;
        } else if (preference.mKey.equals("fix_tools_db_recover")) {
            intent = new Intent().setClassName(this.mController.ylL, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
            intent.putExtra("scene", 2);
            this.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(126885);
            return true;
        } else {
            AppMethodBeat.m2505o(126885);
            return false;
        }
    }
}
