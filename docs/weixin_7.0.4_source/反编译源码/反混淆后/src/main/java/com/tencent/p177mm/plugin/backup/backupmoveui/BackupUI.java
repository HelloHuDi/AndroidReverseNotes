package com.tencent.p177mm.plugin.backup.backupmoveui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C42759b;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p345d.C41258b;
import com.tencent.p177mm.plugin.backup.p345d.C45743a;
import com.tencent.p177mm.plugin.backup.p345d.C45743a.C274841;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupUI */
public class BackupUI extends MMWizardActivity {
    private static boolean jvn = false;
    private TextView juX;
    private C7564ap jui = new C7564ap(Looper.getMainLooper(), new C336643(), true);
    private Button jvm;

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupUI$1 */
    class C336621 implements OnClickListener {
        C336621() {
        }

        /* JADX WARNING: Missing block: B:8:0x0068, code skipped:
            if (((java.lang.Boolean) com.tencent.p177mm.model.C18628c.m29072Ry().get(com.tencent.p177mm.storage.C5128ac.C5127a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, java.lang.Boolean.FALSE)).booleanValue() != false) goto L_0x006a;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            Intent className;
            AppMethodBeat.m2504i(17428);
            C9638aw.m17190ZK();
            if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                if (C41258b.aSZ().aSu().jqW == -100) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.FALSE);
                } else {
                    className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "backup_move_notification");
                    C4996ah.getContext().startActivity(className);
                    AppMethodBeat.m2505o(17428);
                    return;
                }
            }
            C9638aw.m17190ZK();
            if (!((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                C9638aw.m17190ZK();
            }
            if (C42759b.aTD().aSu().jqW == -100) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.FALSE);
                final int aSG = C38635g.aSG();
                if (aSG < 50) {
                    C7060h.pYm.mo8378a(485, 7, 1, false);
                    C7060h.pYm.mo8381e(11787, Integer.valueOf(4));
                    C30379h.m48430a(BackupUI.this, (int) C25738R.string.f9372y4, (int) C25738R.string.f9371y3, (int) C25738R.string.a1u, (int) C25738R.string.f9345xb, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(17427);
                            C4990ab.m7417i("MicroMsg.BackupUI", "low battery, user click sure. battery:%d", Integer.valueOf(aSG));
                            C7060h.pYm.mo8378a(485, 21, 1, false);
                            C7060h.pYm.mo8381e(11788, Integer.valueOf(3));
                            MMWizardActivity.m23791J(BackupUI.this, new Intent(BackupUI.this, BackupMoveChooseUI.class));
                            AppMethodBeat.m2505o(17427);
                        }
                    }, null, (int) C25738R.color.f11768gn);
                    AppMethodBeat.m2505o(17428);
                    return;
                }
                C7060h.pYm.mo8378a(485, 21, 1, false);
                C7060h.pYm.mo8381e(11788, Integer.valueOf(3));
                MMWizardActivity.m23791J(BackupUI.this, new Intent(BackupUI.this, BackupMoveChooseUI.class));
                AppMethodBeat.m2505o(17428);
                return;
            }
            className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
            className.addFlags(335544320);
            className.putExtra("nofification_type", "back_to_pcmgr_notification");
            C4996ah.getContext().startActivity(className);
            AppMethodBeat.m2505o(17428);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupUI$2 */
    class C336632 implements OnMenuItemClickListener {
        C336632() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17429);
            BackupUI.this.finish();
            AppMethodBeat.m2505o(17429);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupUI$3 */
    class C336643 implements C5015a {
        C336643() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(17430);
            if (C5046bo.isNullOrNil(C38635g.m65526ds(BackupUI.this))) {
                if (BackupUI.jvn) {
                    BackupUI.this.juX.setText(C25738R.string.a1r);
                    BackupUI.this.juX.setTextColor(BackupUI.this.getResources().getColor(C25738R.color.f11769go));
                    BackupUI.this.jvm.setEnabled(false);
                    BackupUI.jvn = false;
                    C7060h.pYm.mo8381e(11788, Integer.valueOf(2));
                }
            } else if (!BackupUI.jvn) {
                BackupUI.this.juX.setText(C25738R.string.a1s);
                BackupUI.this.juX.setTextColor(BackupUI.this.getResources().getColor(C25738R.color.f11770gp));
                BackupUI.this.jvm.setEnabled(true);
                BackupUI.jvn = true;
            }
            AppMethodBeat.m2505o(17430);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BackupUI() {
        AppMethodBeat.m2504i(17431);
        AppMethodBeat.m2505o(17431);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17432);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(17432);
            return;
        }
        setMMTitle((int) C25738R.string.f9353xj);
        C7060h.pYm.mo8381e(11788, Integer.valueOf(1));
        C19978b.aTZ();
        this.juX = (TextView) findViewById(2131821595);
        this.jvm = (Button) findViewById(2131821596);
        C41258b.aSZ();
        Editor edit = C38634d.aSz().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        edit.commit();
        if (C41258b.aSZ().aTd().jsY) {
            C41258b.aSZ().aTd().aSX();
        } else {
            C45743a aTd = C41258b.aSZ().aTd();
            C38658d.aUr().aUu();
            C7305d.post(new C274841(), "BakMoveChooseServer.calculateToChoose");
        }
        if (C5046bo.isNullOrNil(C38635g.m65526ds(this))) {
            this.juX.setText(C25738R.string.a1r);
            this.juX.setTextColor(getResources().getColor(C25738R.color.f11769go));
            this.jvm.setEnabled(false);
            jvn = false;
            C7060h.pYm.mo8381e(11788, Integer.valueOf(2));
        } else {
            this.juX.setText(C25738R.string.a1s);
            this.juX.setTextColor(getResources().getColor(C25738R.color.f11770gp));
            this.jvm.setEnabled(true);
            jvn = true;
        }
        this.jvm.setOnClickListener(new C336621());
        setBackBtn(new C336632());
        AppMethodBeat.m2505o(17432);
    }

    public void onStart() {
        AppMethodBeat.m2504i(17433);
        super.onStart();
        this.jui.mo16770ae(5000, 5000);
        AppMethodBeat.m2505o(17433);
    }

    public void onStop() {
        AppMethodBeat.m2504i(17434);
        super.onStop();
        this.jui.stopTimer();
        AppMethodBeat.m2505o(17434);
    }

    public final int getLayoutId() {
        return 2130968799;
    }
}
