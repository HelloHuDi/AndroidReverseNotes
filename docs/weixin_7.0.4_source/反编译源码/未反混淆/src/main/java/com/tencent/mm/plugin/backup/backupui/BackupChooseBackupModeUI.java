package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.backup.backupmoveui.BackupUI;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

@a(3)
public class BackupChooseBackupModeUI extends MMPreference {
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17723);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        setMMTitle((int) R.string.a1v);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17722);
                BackupChooseBackupModeUI.this.finish();
                AppMethodBeat.o(17722);
                return true;
            }
        });
        AppMethodBeat.o(17723);
    }

    public final int JC() {
        return R.xml.l;
    }

    public void onDestroy() {
        AppMethodBeat.i(17725);
        ab.d("MicroMsg.BackupChooseBackupModeUI", "BackupChooseBackupModeUI onDestroy.");
        super.onDestroy();
        b.aSZ().aTd().cancel();
        com.tencent.mm.plugin.backup.d.a aTd = b.aSZ().aTd();
        ab.i("MicroMsg.BackupMoveChooseServer", "clearChooseData");
        aTd.jsV = null;
        aTd.jsX = null;
        aTd.jsW = null;
        aTd.jsZ = false;
        aTd.jsY = false;
        AppMethodBeat.o(17725);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(17724);
        if (preference.mKey.equals("backup_move_to_device")) {
            MMWizardActivity.J(this, new Intent(this.mController.ylL, BackupUI.class));
            AppMethodBeat.o(17724);
            return true;
        } else if (preference.mKey.equals("backup_to_pc")) {
            Intent intent = new Intent();
            intent.putExtra("title", getString(R.string.zv));
            intent.putExtra("rawUrl", getString(R.string.g5l, new Object[]{aa.dor()}));
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(17724);
            return true;
        } else {
            AppMethodBeat.o(17724);
            return false;
        }
    }
}
