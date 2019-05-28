package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

@a(3)
public class FixToolsUI extends MMPreference {
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126884);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        setMMTitle((int) R.string.bvl);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.ehK.aqO("fix_tools_micromsg_header");
        String ar = g.ar(this.mController.ylL, d.vxo);
        if (d.vxr) {
            ar = ar + " " + getString(R.string.fk);
        }
        settingsAboutMMHeaderPreference.qlS = ar;
        h.pYm.a(873, (long) getIntent().getIntExtra("entry_fix_tools", 2), 1, false);
        h.pYm.a(873, 0, 1, false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126883);
                FixToolsUI.this.finish();
                AppMethodBeat.o(126883);
                return true;
            }
        });
        AppMethodBeat.o(126884);
    }

    public final int JC() {
        return R.xml.au;
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(126885);
        Intent intent;
        if (preference.mKey.equals("fix_tools_uplog")) {
            if (com.tencent.mm.plugin.setting.model.a.cir().fPO) {
                MMWizardActivity.J(this, new Intent(this.mController.ylL, FixToolsUpLogUploadingUI.class));
            } else {
                intent = new Intent(this.mController.ylL, FixToolsUplogUI.class);
                intent.putExtra("entry_fix_tools_uplog", 9);
                MMWizardActivity.J(this, intent);
            }
            AppMethodBeat.o(126885);
            return true;
        } else if (preference.mKey.equals("fix_tools_db_recover")) {
            intent = new Intent().setClassName(this.mController.ylL, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
            intent.putExtra("scene", 2);
            this.mController.ylL.startActivity(intent);
            AppMethodBeat.o(126885);
            return true;
        } else {
            AppMethodBeat.o(126885);
            return false;
        }
    }
}
