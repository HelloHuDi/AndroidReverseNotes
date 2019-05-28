package com.tencent.p177mm.plugin.backup.backupui;

import android.content.Context;
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
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.backup.backupmoveui.BackupUI;
import com.tencent.p177mm.plugin.backup.p345d.C41258b;
import com.tencent.p177mm.plugin.backup.p345d.C45743a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI */
public class BackupChooseBackupModeUI extends MMPreference {
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI$1 */
    class C199601 implements OnMenuItemClickListener {
        C199601() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17722);
            BackupChooseBackupModeUI.this.finish();
            AppMethodBeat.m2505o(17722);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17723);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        setMMTitle((int) C25738R.string.a1v);
        setBackBtn(new C199601());
        AppMethodBeat.m2505o(17723);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8472l;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17725);
        C4990ab.m7410d("MicroMsg.BackupChooseBackupModeUI", "BackupChooseBackupModeUI onDestroy.");
        super.onDestroy();
        C41258b.aSZ().aTd().cancel();
        C45743a aTd = C41258b.aSZ().aTd();
        C4990ab.m7416i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
        aTd.jsV = null;
        aTd.jsX = null;
        aTd.jsW = null;
        aTd.jsZ = false;
        aTd.jsY = false;
        AppMethodBeat.m2505o(17725);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(17724);
        if (preference.mKey.equals("backup_move_to_device")) {
            MMWizardActivity.m23791J(this, new Intent(this.mController.ylL, BackupUI.class));
            AppMethodBeat.m2505o(17724);
            return true;
        } else if (preference.mKey.equals("backup_to_pc")) {
            Intent intent = new Intent();
            intent.putExtra("title", getString(C25738R.string.f9433zv));
            intent.putExtra("rawUrl", getString(C25738R.string.g5l, new Object[]{C4988aa.dor()}));
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(17724);
            return true;
        } else {
            AppMethodBeat.m2505o(17724);
            return false;
        }
    }
}
