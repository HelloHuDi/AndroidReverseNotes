package com.tencent.p177mm.plugin.backup.backupmoveui;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.progress.RoundProgressBtn;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.backup.C42757a;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19939d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C42758e;
import com.tencent.p177mm.plugin.backup.p345d.C33697c;
import com.tencent.p177mm.plugin.backup.p345d.C41258b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.view.C31128d;
import java.lang.reflect.Method;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI */
public class BackupMoveRecoverUI extends MMWizardActivity {
    private static boolean gqB = false;
    private static boolean jvb = false;
    private C19939d jsv = new C110761();
    public TextView juU;
    public TextView juV;
    public TextView juW;
    public TextView juX;
    public TextView juY;
    public ImageView juZ;
    private RoundProgressBtn jva;

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$2 */
    class C26102 implements OnClickListener {
        C26102() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17386);
            BackupMoveRecoverUI.m43546i(BackupMoveRecoverUI.this);
            AppMethodBeat.m2505o(17386);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1 */
    class C110761 implements C19939d {

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$17 */
        class C1107117 implements OnClickListener {
            C1107117() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17379);
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move button.");
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move.");
                C41258b.aSZ().aSu().jqW = 29;
                C110761.this.mo6681rj(29);
                AppMethodBeat.m2505o(17379);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$20 */
        class C1107220 implements OnClickListener {
            C1107220() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17383);
                C41258b.aSZ().aSu().jqW = 25;
                BackupMoveRecoverUI.m43542e(BackupMoveRecoverUI.this);
                AppMethodBeat.m2505o(17383);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$21 */
        class C1107321 implements OnClickListener {
            C1107321() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17384);
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
                C41258b.aSZ().aTc();
                if (C33697c.aTe()) {
                    C41258b.aSZ().aTc().aSL();
                    AppMethodBeat.m2505o(17384);
                    return;
                }
                C4990ab.m7412e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                C41258b.aSZ().aSu().jqW = -22;
                C110761.this.mo6681rj(-22);
                C7060h.pYm.mo8378a(485, 6, 1, false);
                AppMethodBeat.m2505o(17384);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$4 */
        class C110744 implements OnClickListener {
            C110744() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17363);
                C41258b.aSZ().aTa().stop();
                C41258b.aSZ().aSu().jqW = -100;
                BackupMoveRecoverUI.m43544g(BackupMoveRecoverUI.this);
                AppMethodBeat.m2505o(17363);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$6 */
        class C110786 implements OnClickListener {
            C110786() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17365);
                try {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
                    BackupMoveRecoverUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(17365);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.BackupMoveRecoverUI", "jump to Settings$TetherSettingsActivity failed");
                    BackupMoveRecoverUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    AppMethodBeat.m2505o(17365);
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$16 */
        class C1107916 implements OnClickListener {
            C1107916() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17378);
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click scan qrcode.");
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.setFlags(268435456);
                C25985d.m41467b(BackupMoveRecoverUI.this.mController.ylL, "scanner", ".ui.BaseScanUI", intent);
                AppMethodBeat.m2505o(17378);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$18 */
        class C1108018 implements OnClickListener {
            C1108018() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17380);
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
                C41258b.aSZ().aTc();
                if (C33697c.aTe()) {
                    C41258b.aSZ().aTc().aSL();
                    AppMethodBeat.m2505o(17380);
                    return;
                }
                C4990ab.m7412e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                C41258b.aSZ().aSu().jqW = -22;
                C110761.this.mo6681rj(-22);
                C7060h.pYm.mo8378a(485, 6, 1, false);
                AppMethodBeat.m2505o(17380);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$5 */
        class C110815 implements OnClickListener {
            C110815() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17364);
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                C41258b.aSZ().aTc().aTh();
                AppMethodBeat.m2505o(17364);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$15 */
        class C1108215 implements OnClickListener {
            C1108215() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17377);
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                C41258b.aSZ().aTc().aTh();
                AppMethodBeat.m2505o(17377);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$7 */
        class C110837 implements OnClickListener {
            C110837() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17366);
                C7060h.pYm.mo8381e(11789, Integer.valueOf(7));
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.setFlags(268435456);
                C25985d.m41467b(BackupMoveRecoverUI.this.mController.ylL, "scanner", ".ui.BaseScanUI", intent);
                AppMethodBeat.m2505o(17366);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$9 */
        class C110849 implements OnClickListener {
            C110849() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17369);
                Intent intent = new Intent();
                intent.putExtra("title", BackupMoveRecoverUI.this.getString(C25738R.string.f9392yn));
                intent.putExtra("rawUrl", BackupMoveRecoverUI.this.getString(C25738R.string.g5i, new Object[]{C4988aa.dor()}));
                intent.putExtra("showShare", false);
                intent.putExtra("neverGetA8Key", true);
                C25985d.m41467b(BackupMoveRecoverUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(17369);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$12 */
        class C1108512 implements OnClickListener {
            C1108512() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17373);
                C41258b.aSZ().aTc().mo54258fk(true);
                AppMethodBeat.m2505o(17373);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$14 */
        class C1108614 implements DialogInterface.OnClickListener {
            C1108614() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(17376);
                C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "move phone old version");
                BackupMoveRecoverUI.m43545h(BackupMoveRecoverUI.this);
                AppMethodBeat.m2505o(17376);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$1 */
        class C110871 implements OnClickListener {
            C110871() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17359);
                C41258b.aSZ().aTc().mo54258fk(false);
                AppMethodBeat.m2505o(17359);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$3 */
        class C110893 implements OnClickListener {
            C110893() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17362);
                C41258b.aSZ().aSu().jqW = 25;
                BackupMoveRecoverUI.m43543f(BackupMoveRecoverUI.this);
                AppMethodBeat.m2505o(17362);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$11 */
        class C1109011 implements OnClickListener {
            C1109011() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17372);
                C7060h.pYm.mo8381e(11788, Integer.valueOf(9));
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.setFlags(268435456);
                C25985d.m41467b(BackupMoveRecoverUI.this.mController.ylL, "scanner", ".ui.BaseScanUI", intent);
                AppMethodBeat.m2505o(17372);
            }
        }

        C110761() {
        }

        /* renamed from: rj */
        public final void mo6681rj(int i) {
            AppMethodBeat.m2504i(17385);
            while (true) {
                C42758e aSu = C41258b.aSZ().aSu();
                C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", Integer.valueOf(i), Boolean.valueOf(BackupMoveRecoverUI.jvb), Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), Integer.valueOf(aSu.jqZ));
                TextView textView;
                BackupMoveRecoverUI backupMoveRecoverUI;
                Object[] objArr;
                switch (i) {
                    case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                        BackupMoveRecoverUI.m43538a(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.a08);
                        C41258b.aSZ().aTa().stop();
                        BackupMoveRecoverUI.this.juX.setVisibility(4);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        break;
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.a0f);
                        BackupMoveRecoverUI.this.juX.setVisibility(4);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case -13:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9376y8);
                        BackupMoveRecoverUI.this.juX.setText(BackupMoveRecoverUI.this.getString(C25738R.string.f9377y9, new Object[]{C5046bo.m7565ga(C41258b.aSZ().aTc().jtJ)}));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case -12:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9360xr);
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9390yl);
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        C30379h.m48430a(BackupMoveRecoverUI.this, (int) C25738R.string.f9374y6, 0, (int) C25738R.string.a1u, 0, false, new C1108614(), null, (int) C25738R.color.f11768gn);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case -5:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9369y0);
                        BackupMoveRecoverUI.this.juU.setText(C25738R.string.f9406z1);
                        BackupMoveRecoverUI.this.juV.setText(C25738R.string.f9409z4);
                        BackupMoveRecoverUI.this.juX.setVisibility(4);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new C1109011());
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new OnClickListener() {

                            /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$13$1 */
                            class C110921 implements DialogInterface.OnClickListener {
                                C110921() {
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(17374);
                                    C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", Integer.valueOf(i));
                                    C7060h.pYm.mo8378a(485, 44, 1, false);
                                    C41258b.aSZ().aTc().mo54259rn(5);
                                    C41258b.aSZ().aTa().stop();
                                    C41258b.aSZ().aTc().mo54257c(true, true, -100);
                                    AppMethodBeat.m2505o(17374);
                                }
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(17375);
                                C30379h.m48430a(BackupMoveRecoverUI.this, (int) C25738R.string.f9365xw, (int) C25738R.string.f9364xv, (int) C25738R.string.f9409z4, (int) C25738R.string.f9345xb, false, new C110921(), null, (int) C25738R.color.f11769go);
                                AppMethodBeat.m2505o(17375);
                            }
                        });
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case -4:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(BackupMoveRecoverUI.this.getString(C25738R.string.f9391ym, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), "0M"}));
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9375y7);
                        BackupMoveRecoverUI.this.juU.setText(C25738R.string.f9406z1);
                        BackupMoveRecoverUI.this.juV.setText(C25738R.string.f9409z4);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new C110837());
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new OnClickListener() {

                            /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$8$1 */
                            class C110751 implements DialogInterface.OnClickListener {
                                C110751() {
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(17367);
                                    C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", Integer.valueOf(i));
                                    C7060h.pYm.mo8378a(485, 44, 1, false);
                                    C41258b.aSZ().aTc().mo54259rn(6);
                                    C41258b.aSZ().aTa().stop();
                                    C41258b.aSZ().aTc().mo54257c(true, true, -100);
                                    AppMethodBeat.m2505o(17367);
                                }
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(17368);
                                C30379h.m48430a(BackupMoveRecoverUI.this, (int) C25738R.string.f9365xw, (int) C25738R.string.f9364xv, (int) C25738R.string.f9409z4, (int) C25738R.string.f9345xb, false, new C110751(), null, (int) C25738R.color.f11769go);
                                AppMethodBeat.m2505o(17368);
                            }
                        });
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11769go));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.m43541d(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case -3:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9367xy);
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9368xz);
                        BackupMoveRecoverUI.this.juU.setText(C25738R.string.f9404yz);
                        BackupMoveRecoverUI.this.juV.setText(C25738R.string.f9409z4);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11769go));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new C110849());
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new OnClickListener() {

                            /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$10$1 */
                            class C26081 implements DialogInterface.OnClickListener {
                                C26081() {
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(17370);
                                    C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", Integer.valueOf(i));
                                    C7060h.pYm.mo8378a(485, 44, 1, false);
                                    C41258b.aSZ().aTc().mo54259rn(5);
                                    C41258b.aSZ().aTa().stop();
                                    C41258b.aSZ().aTc().mo54257c(true, true, -100);
                                    AppMethodBeat.m2505o(17370);
                                }
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(17371);
                                C30379h.m48430a(BackupMoveRecoverUI.this, (int) C25738R.string.f9365xw, (int) C25738R.string.f9364xv, (int) C25738R.string.f9409z4, (int) C25738R.string.f9345xb, false, new C26081(), null, (int) C25738R.color.f11769go);
                                AppMethodBeat.m2505o(17371);
                            }
                        });
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case -2:
                    case -1:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9378y_);
                        String ds = C38635g.m65526ds(BackupMoveRecoverUI.this);
                        if (ds == null || ds.equals("")) {
                            BackupMoveRecoverUI.this.juX.setText(BackupMoveRecoverUI.this.getString(C25738R.string.f9379ya, new Object[]{"移动网络", C41258b.aSZ().aTc().jtC}));
                        } else {
                            BackupMoveRecoverUI.this.juX.setText(BackupMoveRecoverUI.this.getString(C25738R.string.f9379ya, new Object[]{ds, C41258b.aSZ().aTc().jtC}));
                        }
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11769go));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case 1:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9360xr);
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9390yl);
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case 3:
                        BackupMoveRecoverUI.this.finish();
                        AppMethodBeat.m2505o(17385);
                        return;
                    case 4:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move);
                        textView = BackupMoveRecoverUI.this.juW;
                        backupMoveRecoverUI = BackupMoveRecoverUI.this;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aSu.jqX);
                        objArr[1] = Integer.valueOf(aSu.jqY);
                        C41258b.aSZ().aTc();
                        objArr[2] = C33697c.aTi();
                        textView.setText(backupMoveRecoverUI.getString(C25738R.string.f9410z5, objArr));
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9423zh);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(8);
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setProgress(aSu.aSD());
                        BackupMoveRecoverUI.this.jva.setOnClickListener(new C110815());
                        BackupMoveRecoverUI.this.juV.setText(C25738R.string.f9424zi);
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new C110786());
                        BackupMoveRecoverUI.m43541d(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case 22:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9405z0);
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9390yl);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.m43541d(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case 23:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move);
                        textView = BackupMoveRecoverUI.this.juW;
                        backupMoveRecoverUI = BackupMoveRecoverUI.this;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aSu.jqX);
                        objArr[1] = Integer.valueOf(aSu.jqY);
                        C41258b.aSZ().aTc();
                        objArr[2] = C33697c.aTi();
                        textView.setText(backupMoveRecoverUI.getString(C25738R.string.f9410z5, objArr));
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9390yl);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(8);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setProgress(aSu.aSD());
                        BackupMoveRecoverUI.this.jva.setOnClickListener(new C1108215());
                        BackupMoveRecoverUI.m43541d(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case 24:
                        C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", Boolean.valueOf(BackupMoveRecoverUI.gqB));
                        if (BackupMoveRecoverUI.gqB) {
                            BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move);
                            BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9411z6);
                            BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9413z8);
                            BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11770gp));
                            BackupMoveRecoverUI.this.juU.setText(C25738R.string.f9407z2);
                            BackupMoveRecoverUI.this.juV.setText(C25738R.string.f9408z3);
                            BackupMoveRecoverUI.this.juY.setText(C25738R.string.a1f);
                            BackupMoveRecoverUI.this.juX.setVisibility(0);
                            BackupMoveRecoverUI.this.juU.setVisibility(0);
                            BackupMoveRecoverUI.this.juV.setVisibility(0);
                            BackupMoveRecoverUI.this.jva.setVisibility(8);
                            BackupMoveRecoverUI.this.juU.setOnClickListener(new C1107321());
                            BackupMoveRecoverUI.this.juV.setOnClickListener(new OnClickListener() {

                                /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$2$1 */
                                class C110941 implements DialogInterface.OnClickListener {
                                    C110941() {
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.m2504i(17360);
                                        C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", Integer.valueOf(i));
                                        C7060h.pYm.mo8378a(485, 48, 1, false);
                                        C41258b.aSZ().aTa().stop();
                                        C41258b.aSZ().aTc().mo54257c(true, true, -100);
                                        AppMethodBeat.m2505o(17360);
                                    }
                                }

                                public final void onClick(View view) {
                                    AppMethodBeat.m2504i(17361);
                                    C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                                    C30379h.m48430a(BackupMoveRecoverUI.this, (int) C25738R.string.f9363xu, (int) C25738R.string.f9362xt, (int) C25738R.string.f9408z3, (int) C25738R.string.f9345xb, false, new C110941(), null, (int) C25738R.color.f11769go);
                                    AppMethodBeat.m2505o(17361);
                                }
                            });
                            BackupMoveRecoverUI.this.juY.setOnClickListener(new C110893());
                            AppMethodBeat.m2505o(17385);
                            return;
                        } else if (BackupMoveRecoverUI.jvb) {
                            C41258b.aSZ().aTc();
                            if (C33697c.aTe()) {
                                C41258b.aSZ().aTc().aSL();
                                AppMethodBeat.m2505o(17385);
                                return;
                            }
                            C4990ab.m7412e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                            C41258b.aSZ().aSu().jqW = -22;
                            mo6681rj(-22);
                            C7060h.pYm.mo8378a(485, 6, 1, false);
                            AppMethodBeat.m2505o(17385);
                            return;
                        }
                        break;
                    case 25:
                        if (!BackupMoveRecoverUI.jvb) {
                            break;
                        }
                        C41258b.aSZ().aSu().jqW = 24;
                        i = 24;
                    case 26:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move_recover);
                        BackupMoveRecoverUI.this.juW.setText(BackupMoveRecoverUI.this.getString(C25738R.string.f9402yx, new Object[]{Integer.valueOf(aSu.jqZ)}));
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9403yy);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case 27:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move_recover_finish);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9400yv);
                        BackupMoveRecoverUI.this.juX.setText(BackupMoveRecoverUI.this.getString(C25738R.string.f9401yw, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY)}));
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupMoveRecoverUI.this.juU.setText(C25738R.string.f9351xh);
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new C110744());
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9393yo);
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9395yq);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setText(C25738R.string.f9394yp);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new C1107916());
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setText(C25738R.string.f9409z4);
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new C1107117());
                        BackupMoveRecoverUI.m43541d(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case 29:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9418zc);
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9420ze);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setText(C25738R.string.f9417zb);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new C1108018());
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setText(C25738R.string.f9361xs);
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new OnClickListener() {

                            /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$1$19$1 */
                            class C26091 implements DialogInterface.OnClickListener {
                                C26091() {
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(17381);
                                    C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", Integer.valueOf(i));
                                    C7060h.pYm.mo8378a(485, 48, 1, false);
                                    C41258b.aSZ().aTa().stop();
                                    C41258b.aSZ().aTc().mo54257c(true, true, -100);
                                    AppMethodBeat.m2505o(17381);
                                }
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(17382);
                                C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
                                C30379h.m48430a(BackupMoveRecoverUI.this, (int) C25738R.string.f9363xu, (int) C25738R.string.f9362xt, (int) C25738R.string.f9408z3, (int) C25738R.string.f9345xb, false, new C26091(), null, (int) C25738R.color.f11769go);
                                AppMethodBeat.m2505o(17382);
                            }
                        });
                        BackupMoveRecoverUI.this.juY.setText(C25738R.string.a1f);
                        BackupMoveRecoverUI.this.juY.setOnClickListener(new C1107220());
                        AppMethodBeat.m2505o(17385);
                        return;
                    case 30:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move_recover);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.a1e);
                        BackupMoveRecoverUI.this.juX.setText(C25738R.string.f9403yy);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(C25738R.color.f11770gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    case 52:
                        BackupMoveRecoverUI.this.juZ.setImageResource(C1318a.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(C25738R.string.f9387yi);
                        BackupMoveRecoverUI.this.juU.setText(C25738R.string.f9389yk);
                        BackupMoveRecoverUI.this.juV.setText(C25738R.string.f9388yj);
                        BackupMoveRecoverUI.this.juX.setVisibility(4);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new C110871());
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new C1108512());
                        BackupMoveRecoverUI.m43540c(BackupMoveRecoverUI.this);
                        AppMethodBeat.m2505o(17385);
                        return;
                    default:
                        break;
                }
            }
            AppMethodBeat.m2505o(17385);
        }

        public final void aSt() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI$5 */
    class C274455 implements OnClickListener {
        C274455() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17389);
            C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "minimize BackupMoveRecoverUI");
            BackupMoveRecoverUI.m43547j(BackupMoveRecoverUI.this);
            AppMethodBeat.m2505o(17389);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BackupMoveRecoverUI() {
        AppMethodBeat.m2504i(17390);
        AppMethodBeat.m2505o(17390);
    }

    /* renamed from: i */
    static /* synthetic */ void m43546i(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.m2504i(17405);
        backupMoveRecoverUI.aTw();
        AppMethodBeat.m2505o(17405);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17391);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(17391);
            return;
        }
        C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
        getSupportActionBar().hide();
        C42757a.gkE.mo38889BV();
        initView();
        try {
            Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            C41258b.aSZ().aTc().jtw = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
            C4990ab.m7411d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", Boolean.valueOf(C41258b.aSZ().aTc().jtw));
            AppMethodBeat.m2505o(17391);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", C5046bo.dpG());
            AppMethodBeat.m2505o(17391);
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(17392);
        this.juY = (TextView) findViewById(2131821585);
        this.juZ = (ImageView) findViewById(2131821586);
        this.juW = (TextView) findViewById(2131821587);
        this.juX = (TextView) findViewById(2131821588);
        this.juU = (TextView) findViewById(2131821590);
        this.juV = (TextView) findViewById(2131821589);
        this.jva = (RoundProgressBtn) findViewById(2131821591);
        AppMethodBeat.m2505o(17392);
    }

    public void onResume() {
        AppMethodBeat.m2504i(17393);
        super.onResume();
        C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "onResume.");
        jvb = true;
        C41258b.aSZ().aTc().jsv = this.jsv;
        gqB = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
        this.jsv.mo6681rj(C41258b.aSZ().aSu().jqW);
        AppMethodBeat.m2505o(17393);
    }

    public void onPause() {
        AppMethodBeat.m2504i(17394);
        super.onPause();
        C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "onPause.");
        jvb = false;
        AppMethodBeat.m2505o(17394);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17395);
        C4990ab.m7416i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
        super.onDestroy();
        AppMethodBeat.m2505o(17395);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(17396);
        if (i == 4) {
            aTw();
            AppMethodBeat.m2505o(17396);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(17396);
        return onKeyDown;
    }

    private void aTw() {
        AppMethodBeat.m2504i(17397);
        final int i = C41258b.aSZ().aSu().jqW;
        C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", Integer.valueOf(i), Integer.valueOf(i));
        switch (i) {
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -13:
            case -5:
            case -3:
            case -2:
            case -1:
            case 1:
                C41258b.aSZ().aTc().mo54257c(false, false, -100);
                AppMethodBeat.m2505o(17397);
                return;
            case 24:
                C41258b.aSZ().aSu().jqW = 25;
                break;
            case 26:
            case 30:
                C30379h.m48430a((Context) this, (int) C25738R.string.a00, (int) C25738R.string.f9436zz, (int) C25738R.string.a1_, (int) C25738R.string.f9345xb, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(17388);
                        C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", Integer.valueOf(i));
                        C7060h.pYm.mo8378a(485, 48, 1, false);
                        C41258b.aSZ().aTa().stop();
                        C41258b.aSZ().aTc().mo54257c(true, true, -100);
                        AppMethodBeat.m2505o(17388);
                    }
                }, null, (int) C25738R.color.f11769go);
                AppMethodBeat.m2505o(17397);
                return;
            case 27:
                C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", Integer.valueOf(i));
                C41258b.aSZ().aTc().mo54257c(true, false, -100);
                C41258b.aSZ().aTa().stop();
                AppMethodBeat.m2505o(17397);
                return;
            case 52:
                C30379h.m48430a((Context) this, (int) C25738R.string.f9365xw, (int) C25738R.string.f9364xv, (int) C25738R.string.f9409z4, (int) C25738R.string.f9345xb, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(17387);
                        C4990ab.m7417i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", Integer.valueOf(i));
                        C7060h.pYm.mo8378a(485, 44, 1, false);
                        C41258b.aSZ().aTc().mo54259rn(5);
                        C41258b.aSZ().aTa().stop();
                        C41258b.aSZ().aTc().mo54257c(true, true, -100);
                        AppMethodBeat.m2505o(17387);
                    }
                }, null, (int) C25738R.color.f11769go);
                AppMethodBeat.m2505o(17397);
                return;
        }
        mo27541Ni(1);
        AppMethodBeat.m2505o(17397);
    }

    public final int getLayoutId() {
        return 2130968797;
    }

    /* renamed from: a */
    static /* synthetic */ void m43538a(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.m2504i(17398);
        backupMoveRecoverUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17398);
    }

    /* renamed from: c */
    static /* synthetic */ void m43540c(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.m2504i(17399);
        backupMoveRecoverUI.juY.setText(C25738R.string.f9350xg);
        backupMoveRecoverUI.juY.setOnClickListener(new C26102());
        AppMethodBeat.m2505o(17399);
    }

    /* renamed from: d */
    static /* synthetic */ void m43541d(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.m2504i(17400);
        backupMoveRecoverUI.juY.setText(C25738R.string.f9352xi);
        backupMoveRecoverUI.juY.setOnClickListener(new C274455());
        AppMethodBeat.m2505o(17400);
    }

    /* renamed from: e */
    static /* synthetic */ void m43542e(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.m2504i(17401);
        backupMoveRecoverUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17401);
    }

    /* renamed from: f */
    static /* synthetic */ void m43543f(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.m2504i(17402);
        backupMoveRecoverUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17402);
    }

    /* renamed from: g */
    static /* synthetic */ void m43544g(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.m2504i(17403);
        backupMoveRecoverUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17403);
    }

    /* renamed from: h */
    static /* synthetic */ void m43545h(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.m2504i(17404);
        backupMoveRecoverUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17404);
    }

    /* renamed from: j */
    static /* synthetic */ void m43547j(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.m2504i(17406);
        backupMoveRecoverUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17406);
    }
}
