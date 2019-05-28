package com.tencent.p177mm.plugin.backup.backuppcui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.backup.C42757a;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C41256d;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C42759b;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C42760e;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C45736c;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19938c;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C42758e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI */
public class BackupPcUI extends MMWizardActivity {
    private static boolean gqB = false;
    private TextView juU;
    private TextView juV;
    private TextView juW;
    private TextView juX;
    private TextView juY;
    private ImageView juZ;
    public C19938c jwO = new C26183();

    /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$2 */
    class C26172 implements OnClickListener {
        C26172() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(17589);
            C4990ab.m7416i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
            C7060h.pYm.mo8378a(400, 26, 1, false);
            C42759b.aTD().aTa().stop();
            C42759b.aTD().aTG().mo65912c(true, true, -100);
            AppMethodBeat.m2505o(17589);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3 */
    class C26183 implements C19938c {

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$15 */
        class C261915 implements View.OnClickListener {
            C261915() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17609);
                C42759b.aTD().aTa().stop();
                C42759b.aTD().aSu().jqW = -100;
                BackupPcUI.m4872j(BackupPcUI.this);
                AppMethodBeat.m2505o(17609);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$13 */
        class C262013 implements View.OnClickListener {

            /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$13$1 */
            class C26211 implements OnClickListener {
                C26211() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(17606);
                    C4990ab.m7416i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                    C7060h.pYm.mo8378a(400, 26, 1, false);
                    C42759b.aTD().aTa().stop();
                    C42759b.aTD().aTG().mo65912c(true, true, -100);
                    AppMethodBeat.m2505o(17606);
                }
            }

            C262013() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17607);
                C30379h.m48430a(BackupPcUI.this, (int) C25738R.string.a00, (int) C25738R.string.f9436zz, (int) C25738R.string.a1_, (int) C25738R.string.f9345xb, false, new C26211(), null, (int) C25738R.color.f11769go);
                AppMethodBeat.m2505o(17607);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$14 */
        class C262214 implements View.OnClickListener {
            C262214() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17608);
                C42759b.aTD().aSu().jqW = 25;
                BackupPcUI.m4871i(BackupPcUI.this);
                AppMethodBeat.m2505o(17608);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$2 */
        class C26232 implements View.OnClickListener {

            /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$2$1 */
            class C26241 implements OnClickListener {
                C26241() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(17592);
                    C4990ab.m7416i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                    C42759b.aTD().aTa().stop();
                    C42759b.aTD().aTG().mo65912c(true, true, -100);
                    C7060h.pYm.mo8378a(400, 52, 1, false);
                    C42759b.aTD().aTG().mo65914rt(4);
                    AppMethodBeat.m2505o(17592);
                }
            }

            C26232() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17593);
                C30379h.m48430a(BackupPcUI.this, (int) C25738R.string.a00, (int) C25738R.string.f9436zz, (int) C25738R.string.a1_, (int) C25738R.string.f9345xb, false, new C26241(), null, (int) C25738R.color.f11769go);
                AppMethodBeat.m2505o(17593);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$3 */
        class C26253 implements View.OnClickListener {

            /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$3$1 */
            class C26261 implements OnClickListener {
                C26261() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(17594);
                    C4990ab.m7416i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                    C7060h.pYm.mo8378a(400, 10, 1, false);
                    C42759b.aTD().aTF().mo68235rt(4);
                    C42759b.aTD().aTa().stop();
                    C42759b.aTD().aTF().cancel(true);
                    C42759b.aTD().aSu().jqW = -100;
                    BackupPcUI.m4874l(BackupPcUI.this);
                    AppMethodBeat.m2505o(17594);
                }
            }

            C26253() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17595);
                C30379h.m48430a(BackupPcUI.this, (int) C25738R.string.f9435zy, (int) C25738R.string.f9434zx, (int) C25738R.string.a19, (int) C25738R.string.f9345xb, false, new C26261(), null, (int) C25738R.color.f11769go);
                AppMethodBeat.m2505o(17595);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$4 */
        class C26274 implements View.OnClickListener {

            /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$4$1 */
            class C26161 implements OnClickListener {
                C26161() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(17596);
                    C4990ab.m7416i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                    C7060h.pYm.mo8378a(400, 18, 1, false);
                    C42759b.aTD().aTG().mo65914rt(4);
                    C42759b.aTD().aTa().stop();
                    C42759b.aTD().aTG().mo65912c(true, true, -100);
                    AppMethodBeat.m2505o(17596);
                }
            }

            C26274() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17597);
                C30379h.m48430a(BackupPcUI.this, (int) C25738R.string.a00, (int) C25738R.string.f9436zz, (int) C25738R.string.a1_, (int) C25738R.string.f9345xb, false, new C26161(), null, (int) C25738R.color.f11769go);
                AppMethodBeat.m2505o(17597);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$9 */
        class C26289 implements View.OnClickListener {
            C26289() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17602);
                MMWizardActivity.m23791J(BackupPcUI.this, new Intent(BackupPcUI.this, BackupPcChooseUI.class));
                C42759b.aTD().aTH().cancel();
                C42759b.aTD().aTH().aTC();
                C42759b.aTD().aTH().mo35204fn(false);
                AppMethodBeat.m2505o(17602);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$1 */
        class C26291 implements View.OnClickListener {

            /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$1$1 */
            class C26301 implements OnClickListener {
                C26301() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(17590);
                    C42759b.aTD().aTE().mo73535rs(2);
                    C42759b.aTD().aSu().jqW = 12;
                    C26183.this.mo6681rj(12);
                    C42759b.aTD().aTH().aTC();
                    C42759b.aTD().aTH().mo35204fn(true);
                    C7060h.pYm.mo8378a(400, 7, 1, false);
                    C7060h.pYm.mo8381e(13735, Integer.valueOf(9), Integer.valueOf(C42759b.aTD().aTE().jwg));
                    AppMethodBeat.m2505o(17590);
                }
            }

            C26291() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17591);
                C9638aw.m17190ZK();
                C4990ab.m7417i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", Boolean.valueOf(((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()));
                if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    C30379h.m48430a(BackupPcUI.this, (int) C25738R.string.a0k, 0, (int) C25738R.string.a1u, 0, false, new C26301(), null, (int) C25738R.color.f11768gn);
                    AppMethodBeat.m2505o(17591);
                    return;
                }
                C42759b.aTD().aTE().mo73535rs(2);
                C42759b.aTD().aSu().jqW = 12;
                C26183.this.mo6681rj(12);
                C42759b.aTD().aTH().cancel();
                C42759b.aTD().aTH().aTC();
                C42759b.aTD().aTH().mo35204fn(true);
                C7060h.pYm.mo8378a(400, 7, 1, false);
                C7060h.pYm.mo8381e(13735, Integer.valueOf(9), Integer.valueOf(C42759b.aTD().aTE().jwg));
                AppMethodBeat.m2505o(17591);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$16 */
        class C263116 implements View.OnClickListener {

            /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$16$1 */
            class C26321 implements OnClickListener {
                C26321() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(17610);
                    C4990ab.m7416i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                    C42759b.aTD().aTa().stop();
                    C42759b.aTD().aTF().cancel(true);
                    C42759b.aTD().aSu().jqW = -100;
                    C7060h.pYm.mo8378a(400, 52, 1, false);
                    C42759b.aTD().aTF().mo68235rt(4);
                    BackupPcUI.m4873k(BackupPcUI.this);
                    AppMethodBeat.m2505o(17610);
                }
            }

            C263116() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17611);
                C30379h.m48430a(BackupPcUI.this, (int) C25738R.string.f9435zy, (int) C25738R.string.f9434zx, (int) C25738R.string.a19, (int) C25738R.string.f9345xb, false, new C26321(), null, (int) C25738R.color.f11769go);
                AppMethodBeat.m2505o(17611);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$10 */
        class C263310 implements View.OnClickListener {
            C263310() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17603);
                C42759b.aTD().aTa().stop();
                C42759b.aTD().aTF().cancel(true);
                C42759b.aTD().aSu().jqW = -100;
                BackupPcUI.m4869g(BackupPcUI.this);
                AppMethodBeat.m2505o(17603);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$12 */
        class C263412 implements View.OnClickListener {
            C263412() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17605);
                C4990ab.m7416i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
                C42759b.aTD().aTG();
                if (!C41256d.aTe()) {
                    C42759b.aTD().aTG();
                    if (!C41256d.aTe()) {
                        C42759b.aTD().aSu().jqW = -22;
                        C26183.this.mo6681rj(-22);
                        C7060h.pYm.mo8378a(400, 64, 1, false);
                        AppMethodBeat.m2505o(17605);
                        return;
                    }
                }
                C7060h.pYm.mo8381e(13735, Integer.valueOf(27), Integer.valueOf(C42759b.aTD().aTE().jwg));
                C42759b.aTD().aTG().aSL();
                AppMethodBeat.m2505o(17605);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$5 */
        class C26355 implements View.OnClickListener {
            C26355() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17598);
                BackupPcUI.m4875m(BackupPcUI.this);
                AppMethodBeat.m2505o(17598);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$6 */
        class C26366 implements View.OnClickListener {
            C26366() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17599);
                BackupPcUI.m4875m(BackupPcUI.this);
                AppMethodBeat.m2505o(17599);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$7 */
        class C26377 implements View.OnClickListener {
            C26377() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17600);
                BackupPcUI.m4876n(BackupPcUI.this);
                AppMethodBeat.m2505o(17600);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$8 */
        class C26388 implements View.OnClickListener {
            C26388() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17601);
                BackupPcUI.m4877o(BackupPcUI.this);
                AppMethodBeat.m2505o(17601);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backuppcui.BackupPcUI$3$11 */
        class C263911 implements View.OnClickListener {
            C263911() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17604);
                C7060h.pYm.mo8381e(13735, Integer.valueOf(23), Integer.valueOf(C42759b.aTD().aTE().jwg));
                C42759b.aTD().aTE().mo73535rs(4);
                C42759b.aTD().aSu().jqW = 22;
                C26183.this.mo6681rj(22);
                C7060h.pYm.mo8378a(400, 16, 1, false);
                AppMethodBeat.m2505o(17604);
            }
        }

        C26183() {
        }

        public final void aSs() {
            AppMethodBeat.m2504i(17612);
            C4990ab.m7417i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", Integer.valueOf(C42759b.aTD().aTE().jwa));
            switch (C42759b.aTD().aTE().jwa) {
                case 1:
                    C42759b.aTD().aSu().jqW = 11;
                    mo6681rj(11);
                    AppMethodBeat.m2505o(17612);
                    return;
                case 2:
                    C42759b.aTD().aSu().jqW = 21;
                    mo6681rj(21);
                    AppMethodBeat.m2505o(17612);
                    return;
                case 3:
                    C42759b.aTD().aSu().jqW = 12;
                    mo6681rj(12);
                    AppMethodBeat.m2505o(17612);
                    return;
                case 4:
                    C42759b.aTD().aSu().jqW = 22;
                    mo6681rj(22);
                    break;
            }
            AppMethodBeat.m2505o(17612);
        }

        /* renamed from: rj */
        public final void mo6681rj(int i) {
            AppMethodBeat.m2504i(17613);
            while (true) {
                int i2 = C42759b.aTD().aTE().jwa;
                C4990ab.m7417i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                C42758e aSu = C42759b.aTD().aSu();
                TextView c;
                BackupPcUI backupPcUI;
                Object[] objArr;
                switch (i) {
                    case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                        BackupPcUI.m4863a(BackupPcUI.this);
                        AppMethodBeat.m2505o(17613);
                        return;
                    case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                        m4878rv(i2);
                        BackupPcUI.this.juW.setText(C25738R.string.a05);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        break;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        m4878rv(i2);
                        BackupPcUI.this.juW.setText(C25738R.string.a08);
                        C42759b.aTD().aTa().stop();
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                        m4878rv(i2);
                        BackupPcUI.this.juW.setText(C25738R.string.a0f);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case -13:
                        m4878rv(i2);
                        BackupPcUI.this.juW.setText(C25738R.string.a0c);
                        C42759b.aTD().aTa().stop();
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case -5:
                        m4878rv(i2);
                        BackupPcUI.this.juW.setText(C25738R.string.a04);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case -4:
                        if (1 == i2 || 3 == i2) {
                            BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_error);
                            BackupPcUI.this.juW.setText(BackupPcUI.this.getString(C25738R.string.a1b, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), "0M"}));
                            BackupPcUI.this.juX.setText(C25738R.string.a09);
                            BackupPcUI.this.juV.setText(C25738R.string.a19);
                            BackupPcUI.this.juV.setOnClickListener(new C26253());
                        } else if (2 == i2 || 4 == i2) {
                            BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_recover_error);
                            BackupPcUI.this.juW.setText(BackupPcUI.this.getString(C25738R.string.a0y, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), "0M"}));
                            BackupPcUI.this.juX.setText(C25738R.string.a0g);
                            BackupPcUI.this.juV.setText(C25738R.string.a1a);
                            BackupPcUI.this.juV.setOnClickListener(new C26274());
                        }
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11769go));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(0);
                        aTR();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case -3:
                        m4878rv(i2);
                        BackupPcUI.this.juW.setText(C25738R.string.a03);
                        BackupPcUI.this.juV.setText(C25738R.string.a0i);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(0);
                        BackupPcUI.this.juV.setOnClickListener(new C26366());
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case -2:
                    case -1:
                        m4878rv(i2);
                        BackupPcUI.this.juW.setText(C25738R.string.a0d);
                        String ds = C38635g.m65526ds(BackupPcUI.this);
                        if (ds == null || ds.equals("")) {
                            BackupPcUI.this.juX.setText(BackupPcUI.this.getString(C25738R.string.a0e, new Object[]{C42759b.aTD().aTE().jwb, "移动网络"}));
                        } else {
                            BackupPcUI.this.juX.setText(BackupPcUI.this.getString(C25738R.string.a0e, new Object[]{C42759b.aTD().aTE().jwb, ds}));
                        }
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11769go));
                        BackupPcUI.this.juV.setText(C25738R.string.a0i);
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(0);
                        BackupPcUI.this.juV.setOnClickListener(new C26355());
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 1:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_icon);
                        BackupPcUI.this.juW.setText(C25738R.string.f9432zu);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 4:
                        switch (i2) {
                            case 1:
                            case 3:
                                BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_icon);
                                c = BackupPcUI.this.juW;
                                backupPcUI = BackupPcUI.this;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aSu.jqX);
                                objArr[1] = Integer.valueOf(aSu.jqY);
                                C42759b.aTD().aTE();
                                objArr[2] = C45736c.aTJ();
                                c.setText(backupPcUI.getString(C25738R.string.a1b, objArr));
                                break;
                            case 2:
                            case 4:
                                BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_recover_icon);
                                c = BackupPcUI.this.juW;
                                backupPcUI = BackupPcUI.this;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aSu.jqX);
                                objArr[1] = Integer.valueOf(aSu.jqY);
                                C42759b.aTD().aTE();
                                objArr[2] = C45736c.aTJ();
                                c.setText(backupPcUI.getString(C25738R.string.a0y, objArr));
                                break;
                        }
                        BackupPcUI.this.juX.setText(C25738R.string.a1d);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11769go));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTR();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 5:
                        switch (i2) {
                            case 1:
                            case 3:
                                BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_icon);
                                c = BackupPcUI.this.juW;
                                backupPcUI = BackupPcUI.this;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aSu.jqX);
                                objArr[1] = Integer.valueOf(aSu.jqY);
                                C42759b.aTD().aTE();
                                objArr[2] = C45736c.aTJ();
                                c.setText(backupPcUI.getString(C25738R.string.a1b, objArr));
                                BackupPcUI.this.juV.setText(C25738R.string.a19);
                                BackupPcUI.this.juV.setOnClickListener(new C263116());
                                break;
                            case 2:
                            case 4:
                                BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_recover_icon);
                                c = BackupPcUI.this.juW;
                                backupPcUI = BackupPcUI.this;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aSu.jqX);
                                objArr[1] = Integer.valueOf(aSu.jqY);
                                C42759b.aTD().aTE();
                                objArr[2] = C45736c.aTJ();
                                c.setText(backupPcUI.getString(C25738R.string.a0y, objArr));
                                BackupPcUI.this.juV.setText(C25738R.string.a1a);
                                BackupPcUI.this.juV.setOnClickListener(new C26232());
                                break;
                        }
                        BackupPcUI.this.juX.setText(C25738R.string.a1c);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11769go));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(0);
                        aTR();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 11:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_icon);
                        BackupPcUI.this.juW.setText(C25738R.string.a18);
                        BackupPcUI.this.juX.setText(C25738R.string.a17);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupPcUI.this.juU.setText(C25738R.string.a15);
                        BackupPcUI.this.juV.setText(C25738R.string.a16);
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(0);
                        BackupPcUI.this.juV.setVisibility(0);
                        aTQ();
                        BackupPcUI.this.juU.setOnClickListener(new C26291());
                        BackupPcUI.this.juV.setOnClickListener(new C26289());
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 12:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_icon);
                        BackupPcUI.this.juW.setText(C25738R.string.a0n);
                        BackupPcUI.this.juX.setText(C25738R.string.a0o);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTR();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 14:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_icon);
                        c = BackupPcUI.this.juW;
                        backupPcUI = BackupPcUI.this;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aSu.jqX);
                        objArr[1] = Integer.valueOf(aSu.jqY);
                        C42759b.aTD().aTE();
                        objArr[2] = C45736c.aTJ();
                        c.setText(backupPcUI.getString(C25738R.string.a1b, objArr));
                        BackupPcUI.this.juX.setText(C25738R.string.a0o);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTR();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 15:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_finished);
                        BackupPcUI.this.juW.setText(C25738R.string.f9425zl);
                        BackupPcUI.this.juX.setText(BackupPcUI.this.getString(C25738R.string.f9426zm, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY)}));
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupPcUI.this.juU.setText(C25738R.string.f9351xh);
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(0);
                        BackupPcUI.this.juV.setVisibility(4);
                        BackupPcUI.this.juU.setOnClickListener(new C263310());
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 21:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_recover_icon);
                        BackupPcUI.this.juW.setText(C25738R.string.a0w);
                        BackupPcUI.this.juU.setText(C25738R.string.a0v);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(0);
                        BackupPcUI.this.juV.setVisibility(4);
                        BackupPcUI.this.juU.setOnClickListener(new C263911());
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 22:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_recover_icon);
                        BackupPcUI.this.juW.setText(C25738R.string.a0n);
                        BackupPcUI.this.juX.setText(C25738R.string.a0o);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTR();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 23:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_recover_icon);
                        c = BackupPcUI.this.juW;
                        backupPcUI = BackupPcUI.this;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aSu.jqX);
                        objArr[1] = Integer.valueOf(aSu.jqY);
                        C42759b.aTD().aTE();
                        objArr[2] = C45736c.aTJ();
                        c.setText(backupPcUI.getString(C25738R.string.a0y, objArr));
                        BackupPcUI.this.juX.setText(C25738R.string.a0o);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTR();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 24:
                        if (BackupPcUI.gqB) {
                            BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_recover_icon);
                            BackupPcUI.this.juW.setText(C25738R.string.a0z);
                            BackupPcUI.this.juX.setText(C25738R.string.a11);
                            BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11770gp));
                            BackupPcUI.this.juU.setText(C25738R.string.a0u);
                            BackupPcUI.this.juV.setText(C25738R.string.a0x);
                            BackupPcUI.this.juY.setText(C25738R.string.a1f);
                            BackupPcUI.this.juX.setVisibility(0);
                            BackupPcUI.this.juU.setVisibility(0);
                            BackupPcUI.this.juV.setVisibility(0);
                            BackupPcUI.this.juU.setOnClickListener(new C263412());
                            BackupPcUI.this.juV.setOnClickListener(new C262013());
                            BackupPcUI.this.juY.setOnClickListener(new C262214());
                            AppMethodBeat.m2505o(17613);
                            return;
                        } else if (C5046bo.m7544cv(BackupPcUI.this)) {
                            C42759b.aTD().aTG();
                            if (C41256d.aTe()) {
                                C42759b.aTD().aTG().aSL();
                                AppMethodBeat.m2505o(17613);
                                return;
                            }
                            C42759b.aTD().aSu().jqW = -22;
                            mo6681rj(-22);
                            C7060h.pYm.mo8378a(400, 64, 1, false);
                            AppMethodBeat.m2505o(17613);
                            return;
                        }
                        break;
                    case 25:
                        if (!C5046bo.m7544cv(BackupPcUI.this)) {
                            break;
                        }
                        C42759b.aTD().aSu().jqW = 24;
                        i = 24;
                    case 26:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_recover_icon);
                        BackupPcUI.this.juW.setText(BackupPcUI.this.getString(C25738R.string.a0t, new Object[]{Integer.valueOf(aSu.jqZ)}));
                        BackupPcUI.this.juX.setText(C25738R.string.a0s);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupPcUI.this.juY.setText(C25738R.string.a0x);
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 27:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_recover_finished);
                        BackupPcUI.this.juW.setText(C25738R.string.a0q);
                        BackupPcUI.this.juX.setText(BackupPcUI.this.getString(C25738R.string.a0r, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY)}));
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupPcUI.this.juU.setText(C25738R.string.f9351xh);
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(0);
                        BackupPcUI.this.juV.setVisibility(4);
                        BackupPcUI.this.juU.setOnClickListener(new C261915());
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    case 30:
                        BackupPcUI.this.juZ.setImageResource(C1318a.backup_move_recover);
                        BackupPcUI.this.juW.setText(C25738R.string.a1e);
                        BackupPcUI.this.juX.setText(C25738R.string.f9403yy);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.m2505o(17613);
                        return;
                    default:
                        break;
                }
            }
            AppMethodBeat.m2505o(17613);
        }

        /* renamed from: rv */
        private void m4878rv(int i) {
            AppMethodBeat.m2504i(17614);
            if (2 == i || 4 == i) {
                BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_recover_error);
                AppMethodBeat.m2505o(17614);
                return;
            }
            BackupPcUI.this.juZ.setImageResource(C1318a.backup_pc_error);
            AppMethodBeat.m2505o(17614);
        }

        private void aTQ() {
            AppMethodBeat.m2504i(17615);
            BackupPcUI.this.juY.setText(C25738R.string.f9350xg);
            BackupPcUI.this.juY.setOnClickListener(new C26377());
            AppMethodBeat.m2505o(17615);
        }

        private void aTR() {
            AppMethodBeat.m2504i(17616);
            BackupPcUI.this.juY.setText(C25738R.string.f9352xi);
            BackupPcUI.this.juY.setOnClickListener(new C26388());
            AppMethodBeat.m2505o(17616);
        }

        public final void aSt() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BackupPcUI() {
        AppMethodBeat.m2504i(17617);
        AppMethodBeat.m2505o(17617);
    }

    /* renamed from: n */
    static /* synthetic */ void m4876n(BackupPcUI backupPcUI) {
        AppMethodBeat.m2504i(17634);
        backupPcUI.aTw();
        AppMethodBeat.m2505o(17634);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17618);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(17618);
            return;
        }
        C4990ab.m7416i("MicroMsg.BackupPcUI", "onCreate.");
        getSupportActionBar().hide();
        C42757a.gkE.mo38889BV();
        initView();
        if (C42759b.aTD().aTE().jwh) {
            C42759b.aTD().aTE().jwh = false;
            final int aSG = C38635g.aSG();
            if (aSG < 50) {
                C7060h.pYm.mo8378a(400, 4, 1, false);
                C7060h.pYm.mo8381e(13736, Integer.valueOf(4), C42759b.aTD().aTE().jwb, C38635g.m65526ds(this), Integer.valueOf(0), Integer.valueOf(C42759b.aTD().aTE().jwg));
                C30379h.m48430a((Context) this, (int) C25738R.string.a07, (int) C25738R.string.a06, (int) C25738R.string.a1u, 0, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(17588);
                        C4990ab.m7417i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", Integer.valueOf(aSG));
                        AppMethodBeat.m2505o(17588);
                    }
                }, null, (int) C25738R.color.f11768gn);
            }
        }
        AppMethodBeat.m2505o(17618);
    }

    public void onStart() {
        AppMethodBeat.m2504i(17619);
        super.onStart();
        C4990ab.m7416i("MicroMsg.BackupPcUI", "onStart.");
        gqB = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
        AppMethodBeat.m2505o(17619);
    }

    public void onPause() {
        AppMethodBeat.m2504i(17620);
        super.onPause();
        C4990ab.m7416i("MicroMsg.BackupPcUI", "onPause.");
        C42760e aTF = C42759b.aTD().aTF();
        C19938c c19938c = this.jwO;
        synchronized (aTF.jwm) {
            try {
                aTF.jwm.remove(c19938c);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(17620);
            }
        }
        C41256d aTG = C42759b.aTD().aTG();
        c19938c = this.jwO;
        synchronized (aTG.jwm) {
            try {
                aTG.jwm.remove(c19938c);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(17620);
                }
            }
        }
    }

    public void onResume() {
        AppMethodBeat.m2504i(17621);
        super.onResume();
        C4990ab.m7416i("MicroMsg.BackupPcUI", "onResume.");
        C42760e aTF = C42759b.aTD().aTF();
        C19938c c19938c = this.jwO;
        synchronized (aTF.jwm) {
            try {
                aTF.jwm.add(c19938c);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(17621);
            }
        }
        C41256d aTG = C42759b.aTD().aTG();
        c19938c = this.jwO;
        synchronized (aTG.jwm) {
            try {
                aTG.jwm.add(c19938c);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(17621);
                }
            }
        }
        this.jwO.mo6681rj(C42759b.aTD().aSu().jqW);
    }

    public final void initView() {
        AppMethodBeat.m2504i(17622);
        this.juY = (TextView) findViewById(2131821585);
        this.juZ = (ImageView) findViewById(2131821586);
        this.juW = (TextView) findViewById(2131821587);
        this.juX = (TextView) findViewById(2131821588);
        this.juU = (TextView) findViewById(2131821590);
        this.juV = (TextView) findViewById(2131821589);
        AppMethodBeat.m2505o(17622);
    }

    public final int getLayoutId() {
        return 2130968797;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17623);
        C4990ab.m7417i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", C5046bo.dpG());
        super.onDestroy();
        AppMethodBeat.m2505o(17623);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(17624);
        if (i == 4) {
            aTw();
            AppMethodBeat.m2505o(17624);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(17624);
        return onKeyDown;
    }

    private void aTw() {
        AppMethodBeat.m2504i(17625);
        int i = C42759b.aTD().aSu().jqW;
        int i2 = C42759b.aTD().aTE().jwa;
        C4990ab.m7417i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d, commandMode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -13:
            case -5:
            case -3:
            case -2:
            case -1:
            case 1:
            case 11:
            case 21:
                if (1 != i2 && 3 != i2) {
                    if (2 != i2 && 4 != i2) {
                        C42759b.aTD().aSu().jqW = -100;
                        break;
                    }
                    C42759b.aTD().aTG().mo65912c(false, false, -100);
                    AppMethodBeat.m2505o(17625);
                    return;
                }
                C42759b.aTD().aTF().cancel(false);
                C42759b.aTD().aSu().jqW = -100;
                break;
                break;
            case 15:
                C4990ab.m7416i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
                aTP();
                AppMethodBeat.m2505o(17625);
                return;
            case 24:
                C42759b.aTD().aSu().jqW = 25;
                break;
            case 26:
            case 30:
                C30379h.m48430a((Context) this, (int) C25738R.string.a00, (int) C25738R.string.f9436zz, (int) C25738R.string.a1_, (int) C25738R.string.f9345xb, false, new C26172(), null, (int) C25738R.color.f11769go);
                AppMethodBeat.m2505o(17625);
                return;
            case 27:
                C4990ab.m7416i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
                aTP();
                AppMethodBeat.m2505o(17625);
                return;
        }
        mo27541Ni(1);
        AppMethodBeat.m2505o(17625);
    }

    private void aTP() {
        AppMethodBeat.m2504i(17626);
        C4990ab.m7416i("MicroMsg.BackupPcUI", "exitBackupPc.");
        if (1 == C42759b.aTD().aTE().jwa || 3 == C42759b.aTD().aTE().jwa) {
            C42759b.aTD().aTH().cancel();
            C42759b.aTD().aTH().aTC();
            C42759b.aTD().aTF().cancel(true);
            C42759b.aTD().aTa().stop();
            C42759b.aTD().aSu().jqW = -100;
            mo27541Ni(1);
            AppMethodBeat.m2505o(17626);
            return;
        }
        if (2 == C42759b.aTD().aTE().jwa || 4 == C42759b.aTD().aTE().jwa) {
            C42759b.aTD().aTG().mo65912c(true, true, -100);
            C42759b.aTD().aTa().stop();
        }
        AppMethodBeat.m2505o(17626);
    }

    /* renamed from: a */
    static /* synthetic */ void m4863a(BackupPcUI backupPcUI) {
        AppMethodBeat.m2504i(17627);
        backupPcUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17627);
    }

    /* renamed from: g */
    static /* synthetic */ void m4869g(BackupPcUI backupPcUI) {
        AppMethodBeat.m2504i(17628);
        backupPcUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17628);
    }

    /* renamed from: i */
    static /* synthetic */ void m4871i(BackupPcUI backupPcUI) {
        AppMethodBeat.m2504i(17629);
        backupPcUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17629);
    }

    /* renamed from: j */
    static /* synthetic */ void m4872j(BackupPcUI backupPcUI) {
        AppMethodBeat.m2504i(17630);
        backupPcUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17630);
    }

    /* renamed from: k */
    static /* synthetic */ void m4873k(BackupPcUI backupPcUI) {
        AppMethodBeat.m2504i(17631);
        backupPcUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17631);
    }

    /* renamed from: l */
    static /* synthetic */ void m4874l(BackupPcUI backupPcUI) {
        AppMethodBeat.m2504i(17632);
        backupPcUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17632);
    }

    /* renamed from: m */
    static /* synthetic */ void m4875m(BackupPcUI backupPcUI) {
        AppMethodBeat.m2504i(17633);
        C4990ab.m7416i("MicroMsg.BackupPcUI", "jumpToNetworkDisconnectDoc.");
        Intent intent = new Intent();
        intent.putExtra("title", backupPcUI.getString(C25738R.string.a0l));
        intent.putExtra("rawUrl", backupPcUI.getString(C25738R.string.g5k, new Object[]{C4988aa.dor()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        C25985d.m41467b((Context) backupPcUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(17633);
    }

    /* renamed from: o */
    static /* synthetic */ void m4877o(BackupPcUI backupPcUI) {
        AppMethodBeat.m2504i(17635);
        backupPcUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17635);
    }
}
