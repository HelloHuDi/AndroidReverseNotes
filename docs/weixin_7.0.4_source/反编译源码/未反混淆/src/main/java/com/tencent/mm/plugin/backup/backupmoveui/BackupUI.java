package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI extends MMWizardActivity {
    private static boolean jvn = false;
    private TextView juX;
    private ap jui = new ap(Looper.getMainLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(17430);
            if (bo.isNullOrNil(g.ds(BackupUI.this))) {
                if (BackupUI.jvn) {
                    BackupUI.this.juX.setText(R.string.a1r);
                    BackupUI.this.juX.setTextColor(BackupUI.this.getResources().getColor(R.color.go));
                    BackupUI.this.jvm.setEnabled(false);
                    BackupUI.jvn = false;
                    h.pYm.e(11788, Integer.valueOf(2));
                }
            } else if (!BackupUI.jvn) {
                BackupUI.this.juX.setText(R.string.a1s);
                BackupUI.this.juX.setTextColor(BackupUI.this.getResources().getColor(R.color.gp));
                BackupUI.this.jvm.setEnabled(true);
                BackupUI.jvn = true;
            }
            AppMethodBeat.o(17430);
            return true;
        }
    }, true);
    private Button jvm;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupUI() {
        AppMethodBeat.i(17431);
        AppMethodBeat.o(17431);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17432);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(17432);
            return;
        }
        setMMTitle((int) R.string.xj);
        h.pYm.e(11788, Integer.valueOf(1));
        b.aTZ();
        this.juX = (TextView) findViewById(R.id.a1d);
        this.jvm = (Button) findViewById(R.id.a1e);
        com.tencent.mm.plugin.backup.d.b.aSZ();
        Editor edit = d.aSz().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        edit.commit();
        if (com.tencent.mm.plugin.backup.d.b.aSZ().aTd().jsY) {
            com.tencent.mm.plugin.backup.d.b.aSZ().aTd().aSX();
        } else {
            com.tencent.mm.plugin.backup.d.a aTd = com.tencent.mm.plugin.backup.d.b.aSZ().aTd();
            com.tencent.mm.plugin.backup.h.d.aUr().aUu();
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17221);
                    if (a.this.jsS != null) {
                        a.this.jsS.cancel();
                    }
                    a.this.jsS = new com.tencent.mm.plugin.backup.c.b();
                    if (a.this.aSU() == null || a.this.aSU().size() == 0) {
                        ab.e("MicroMsg.BackupMoveChooseServer", "backupSessionInfo is null or nill!");
                        a.this.jsS.a(a.this);
                    }
                    AppMethodBeat.o(17221);
                }
            }, "BakMoveChooseServer.calculateToChoose");
        }
        if (bo.isNullOrNil(g.ds(this))) {
            this.juX.setText(R.string.a1r);
            this.juX.setTextColor(getResources().getColor(R.color.go));
            this.jvm.setEnabled(false);
            jvn = false;
            h.pYm.e(11788, Integer.valueOf(2));
        } else {
            this.juX.setText(R.string.a1s);
            this.juX.setTextColor(getResources().getColor(R.color.gp));
            this.jvm.setEnabled(true);
            jvn = true;
        }
        this.jvm.setOnClickListener(new OnClickListener() {
            /* JADX WARNING: Missing block: B:8:0x0068, code skipped:
            if (((java.lang.Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, java.lang.Boolean.FALSE)).booleanValue() != false) goto L_0x006a;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(View view) {
                Intent className;
                AppMethodBeat.i(17428);
                aw.ZK();
                if (((Boolean) c.Ry().get(ac.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    if (com.tencent.mm.plugin.backup.d.b.aSZ().aSu().jqW == -100) {
                        aw.ZK();
                        c.Ry().set(ac.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.FALSE);
                    } else {
                        className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                        className.addFlags(335544320);
                        className.putExtra("nofification_type", "backup_move_notification");
                        ah.getContext().startActivity(className);
                        AppMethodBeat.o(17428);
                        return;
                    }
                }
                aw.ZK();
                if (!((Boolean) c.Ry().get(ac.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    aw.ZK();
                }
                if (com.tencent.mm.plugin.backup.backuppcmodel.b.aTD().aSu().jqW == -100) {
                    aw.ZK();
                    c.Ry().set(ac.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE);
                    aw.ZK();
                    c.Ry().set(ac.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.FALSE);
                    final int aSG = g.aSG();
                    if (aSG < 50) {
                        h.pYm.a(485, 7, 1, false);
                        h.pYm.e(11787, Integer.valueOf(4));
                        com.tencent.mm.ui.base.h.a(BackupUI.this, (int) R.string.y4, (int) R.string.y3, (int) R.string.a1u, (int) R.string.xb, false, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(17427);
                                ab.i("MicroMsg.BackupUI", "low battery, user click sure. battery:%d", Integer.valueOf(aSG));
                                h.pYm.a(485, 21, 1, false);
                                h.pYm.e(11788, Integer.valueOf(3));
                                MMWizardActivity.J(BackupUI.this, new Intent(BackupUI.this, BackupMoveChooseUI.class));
                                AppMethodBeat.o(17427);
                            }
                        }, null, (int) R.color.gn);
                        AppMethodBeat.o(17428);
                        return;
                    }
                    h.pYm.a(485, 21, 1, false);
                    h.pYm.e(11788, Integer.valueOf(3));
                    MMWizardActivity.J(BackupUI.this, new Intent(BackupUI.this, BackupMoveChooseUI.class));
                    AppMethodBeat.o(17428);
                    return;
                }
                className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                ah.getContext().startActivity(className);
                AppMethodBeat.o(17428);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17429);
                BackupUI.this.finish();
                AppMethodBeat.o(17429);
                return true;
            }
        });
        AppMethodBeat.o(17432);
    }

    public void onStart() {
        AppMethodBeat.i(17433);
        super.onStart();
        this.jui.ae(5000, 5000);
        AppMethodBeat.o(17433);
    }

    public void onStop() {
        AppMethodBeat.i(17434);
        super.onStop();
        this.jui.stopTimer();
        AppMethodBeat.o(17434);
    }

    public final int getLayoutId() {
        return R.layout.fb;
    }
}
