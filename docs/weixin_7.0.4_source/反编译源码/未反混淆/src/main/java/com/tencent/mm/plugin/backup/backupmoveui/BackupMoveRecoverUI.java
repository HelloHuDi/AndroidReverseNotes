package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.reflect.Method;

@a(3)
public class BackupMoveRecoverUI extends MMWizardActivity {
    private static boolean gqB = false;
    private static boolean jvb = false;
    private d jsv = new d() {
        public final void rj(int i) {
            AppMethodBeat.i(17385);
            while (true) {
                e aSu = b.aSZ().aSu();
                ab.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", Integer.valueOf(i), Boolean.valueOf(BackupMoveRecoverUI.jvb), Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), Integer.valueOf(aSu.jqZ));
                TextView textView;
                BackupMoveRecoverUI backupMoveRecoverUI;
                Object[] objArr;
                switch (i) {
                    case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                        BackupMoveRecoverUI.a(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(R.string.a08);
                        b.aSZ().aTa().stop();
                        BackupMoveRecoverUI.this.juX.setVisibility(4);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        break;
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(R.string.a0f);
                        BackupMoveRecoverUI.this.juX.setVisibility(4);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case -13:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(R.string.y8);
                        BackupMoveRecoverUI.this.juX.setText(BackupMoveRecoverUI.this.getString(R.string.y9, new Object[]{bo.ga(b.aSZ().aTc().jtJ)}));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case -12:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(R.string.xr);
                        BackupMoveRecoverUI.this.juX.setText(R.string.yl);
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        h.a(BackupMoveRecoverUI.this, (int) R.string.y6, 0, (int) R.string.a1u, 0, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(17376);
                                ab.i("MicroMsg.BackupMoveRecoverUI", "move phone old version");
                                BackupMoveRecoverUI.h(BackupMoveRecoverUI.this);
                                AppMethodBeat.o(17376);
                            }
                        }, null, (int) R.color.gn);
                        AppMethodBeat.o(17385);
                        return;
                    case -5:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(R.string.y0);
                        BackupMoveRecoverUI.this.juU.setText(R.string.z1);
                        BackupMoveRecoverUI.this.juV.setText(R.string.z4);
                        BackupMoveRecoverUI.this.juX.setVisibility(4);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17372);
                                com.tencent.mm.plugin.report.service.h.pYm.e(11788, Integer.valueOf(9));
                                Intent intent = new Intent();
                                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                                intent.setFlags(268435456);
                                com.tencent.mm.bp.d.b(BackupMoveRecoverUI.this.mController.ylL, "scanner", ".ui.BaseScanUI", intent);
                                AppMethodBeat.o(17372);
                            }
                        });
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17375);
                                h.a(BackupMoveRecoverUI.this, (int) R.string.xw, (int) R.string.xv, (int) R.string.z4, (int) R.string.xb, false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(17374);
                                        ab.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", Integer.valueOf(i));
                                        com.tencent.mm.plugin.report.service.h.pYm.a(485, 44, 1, false);
                                        b.aSZ().aTc().rn(5);
                                        b.aSZ().aTa().stop();
                                        b.aSZ().aTc().c(true, true, -100);
                                        AppMethodBeat.o(17374);
                                    }
                                }, null, (int) R.color.go);
                                AppMethodBeat.o(17375);
                            }
                        });
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case -4:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(BackupMoveRecoverUI.this.getString(R.string.ym, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), "0M"}));
                        BackupMoveRecoverUI.this.juX.setText(R.string.y7);
                        BackupMoveRecoverUI.this.juU.setText(R.string.z1);
                        BackupMoveRecoverUI.this.juV.setText(R.string.z4);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17366);
                                com.tencent.mm.plugin.report.service.h.pYm.e(11789, Integer.valueOf(7));
                                Intent intent = new Intent();
                                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                                intent.setFlags(268435456);
                                com.tencent.mm.bp.d.b(BackupMoveRecoverUI.this.mController.ylL, "scanner", ".ui.BaseScanUI", intent);
                                AppMethodBeat.o(17366);
                            }
                        });
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17368);
                                h.a(BackupMoveRecoverUI.this, (int) R.string.xw, (int) R.string.xv, (int) R.string.z4, (int) R.string.xb, false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(17367);
                                        ab.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", Integer.valueOf(i));
                                        com.tencent.mm.plugin.report.service.h.pYm.a(485, 44, 1, false);
                                        b.aSZ().aTc().rn(6);
                                        b.aSZ().aTa().stop();
                                        b.aSZ().aTc().c(true, true, -100);
                                        AppMethodBeat.o(17367);
                                    }
                                }, null, (int) R.color.go);
                                AppMethodBeat.o(17368);
                            }
                        });
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.go));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case -3:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(R.string.xy);
                        BackupMoveRecoverUI.this.juX.setText(R.string.xz);
                        BackupMoveRecoverUI.this.juU.setText(R.string.yz);
                        BackupMoveRecoverUI.this.juV.setText(R.string.z4);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.go));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17369);
                                Intent intent = new Intent();
                                intent.putExtra("title", BackupMoveRecoverUI.this.getString(R.string.yn));
                                intent.putExtra("rawUrl", BackupMoveRecoverUI.this.getString(R.string.g5i, new Object[]{aa.dor()}));
                                intent.putExtra("showShare", false);
                                intent.putExtra("neverGetA8Key", true);
                                com.tencent.mm.bp.d.b(BackupMoveRecoverUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.o(17369);
                            }
                        });
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17371);
                                h.a(BackupMoveRecoverUI.this, (int) R.string.xw, (int) R.string.xv, (int) R.string.z4, (int) R.string.xb, false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(17370);
                                        ab.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", Integer.valueOf(i));
                                        com.tencent.mm.plugin.report.service.h.pYm.a(485, 44, 1, false);
                                        b.aSZ().aTc().rn(5);
                                        b.aSZ().aTa().stop();
                                        b.aSZ().aTc().c(true, true, -100);
                                        AppMethodBeat.o(17370);
                                    }
                                }, null, (int) R.color.go);
                                AppMethodBeat.o(17371);
                            }
                        });
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case -2:
                    case -1:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move_error);
                        BackupMoveRecoverUI.this.juW.setText(R.string.y_);
                        String ds = g.ds(BackupMoveRecoverUI.this);
                        if (ds == null || ds.equals("")) {
                            BackupMoveRecoverUI.this.juX.setText(BackupMoveRecoverUI.this.getString(R.string.ya, new Object[]{"移动网络", b.aSZ().aTc().jtC}));
                        } else {
                            BackupMoveRecoverUI.this.juX.setText(BackupMoveRecoverUI.this.getString(R.string.ya, new Object[]{ds, b.aSZ().aTc().jtC}));
                        }
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.go));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case 1:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(R.string.xr);
                        BackupMoveRecoverUI.this.juX.setText(R.string.yl);
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case 3:
                        BackupMoveRecoverUI.this.finish();
                        AppMethodBeat.o(17385);
                        return;
                    case 4:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move);
                        textView = BackupMoveRecoverUI.this.juW;
                        backupMoveRecoverUI = BackupMoveRecoverUI.this;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aSu.jqX);
                        objArr[1] = Integer.valueOf(aSu.jqY);
                        b.aSZ().aTc();
                        objArr[2] = c.aTi();
                        textView.setText(backupMoveRecoverUI.getString(R.string.z5, objArr));
                        BackupMoveRecoverUI.this.juX.setText(R.string.zh);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(8);
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setProgress(aSu.aSD());
                        BackupMoveRecoverUI.this.jva.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17364);
                                ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                                b.aSZ().aTc().aTh();
                                AppMethodBeat.o(17364);
                            }
                        });
                        BackupMoveRecoverUI.this.juV.setText(R.string.zi);
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17365);
                                try {
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
                                    BackupMoveRecoverUI.this.startActivity(intent);
                                    AppMethodBeat.o(17365);
                                } catch (Exception e) {
                                    ab.e("MicroMsg.BackupMoveRecoverUI", "jump to Settings$TetherSettingsActivity failed");
                                    BackupMoveRecoverUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                    AppMethodBeat.o(17365);
                                }
                            }
                        });
                        BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case 22:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(R.string.z0);
                        BackupMoveRecoverUI.this.juX.setText(R.string.yl);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case 23:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move);
                        textView = BackupMoveRecoverUI.this.juW;
                        backupMoveRecoverUI = BackupMoveRecoverUI.this;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aSu.jqX);
                        objArr[1] = Integer.valueOf(aSu.jqY);
                        b.aSZ().aTc();
                        objArr[2] = c.aTi();
                        textView.setText(backupMoveRecoverUI.getString(R.string.z5, objArr));
                        BackupMoveRecoverUI.this.juX.setText(R.string.yl);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(8);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setProgress(aSu.aSD());
                        BackupMoveRecoverUI.this.jva.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17377);
                                ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove click pause button.");
                                b.aSZ().aTc().aTh();
                                AppMethodBeat.o(17377);
                            }
                        });
                        BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case 24:
                        ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", Boolean.valueOf(BackupMoveRecoverUI.gqB));
                        if (BackupMoveRecoverUI.gqB) {
                            BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move);
                            BackupMoveRecoverUI.this.juW.setText(R.string.z6);
                            BackupMoveRecoverUI.this.juX.setText(R.string.z8);
                            BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.gp));
                            BackupMoveRecoverUI.this.juU.setText(R.string.z2);
                            BackupMoveRecoverUI.this.juV.setText(R.string.z3);
                            BackupMoveRecoverUI.this.juY.setText(R.string.a1f);
                            BackupMoveRecoverUI.this.juX.setVisibility(0);
                            BackupMoveRecoverUI.this.juU.setVisibility(0);
                            BackupMoveRecoverUI.this.juV.setVisibility(0);
                            BackupMoveRecoverUI.this.jva.setVisibility(8);
                            BackupMoveRecoverUI.this.juU.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(17384);
                                    ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
                                    b.aSZ().aTc();
                                    if (c.aTe()) {
                                        b.aSZ().aTc().aSL();
                                        AppMethodBeat.o(17384);
                                        return;
                                    }
                                    ab.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                                    b.aSZ().aSu().jqW = -22;
                                    AnonymousClass1.this.rj(-22);
                                    com.tencent.mm.plugin.report.service.h.pYm.a(485, 6, 1, false);
                                    AppMethodBeat.o(17384);
                                }
                            });
                            BackupMoveRecoverUI.this.juV.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(17361);
                                    ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                                    h.a(BackupMoveRecoverUI.this, (int) R.string.xu, (int) R.string.xt, (int) R.string.z3, (int) R.string.xb, false, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(17360);
                                            ab.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", Integer.valueOf(i));
                                            com.tencent.mm.plugin.report.service.h.pYm.a(485, 48, 1, false);
                                            b.aSZ().aTa().stop();
                                            b.aSZ().aTc().c(true, true, -100);
                                            AppMethodBeat.o(17360);
                                        }
                                    }, null, (int) R.color.go);
                                    AppMethodBeat.o(17361);
                                }
                            });
                            BackupMoveRecoverUI.this.juY.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(17362);
                                    b.aSZ().aSu().jqW = 25;
                                    BackupMoveRecoverUI.f(BackupMoveRecoverUI.this);
                                    AppMethodBeat.o(17362);
                                }
                            });
                            AppMethodBeat.o(17385);
                            return;
                        } else if (BackupMoveRecoverUI.jvb) {
                            b.aSZ().aTc();
                            if (c.aTe()) {
                                b.aSZ().aTc().aSL();
                                AppMethodBeat.o(17385);
                                return;
                            }
                            ab.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                            b.aSZ().aSu().jqW = -22;
                            rj(-22);
                            com.tencent.mm.plugin.report.service.h.pYm.a(485, 6, 1, false);
                            AppMethodBeat.o(17385);
                            return;
                        }
                        break;
                    case 25:
                        if (!BackupMoveRecoverUI.jvb) {
                            break;
                        }
                        b.aSZ().aSu().jqW = 24;
                        i = 24;
                    case 26:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move_recover);
                        BackupMoveRecoverUI.this.juW.setText(BackupMoveRecoverUI.this.getString(R.string.yx, new Object[]{Integer.valueOf(aSu.jqZ)}));
                        BackupMoveRecoverUI.this.juX.setText(R.string.yy);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case 27:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move_recover_finish);
                        BackupMoveRecoverUI.this.juW.setText(R.string.yv);
                        BackupMoveRecoverUI.this.juX.setText(BackupMoveRecoverUI.this.getString(R.string.yw, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY)}));
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.gp));
                        BackupMoveRecoverUI.this.juU.setText(R.string.xh);
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17363);
                                b.aSZ().aTa().stop();
                                b.aSZ().aSu().jqW = -100;
                                BackupMoveRecoverUI.g(BackupMoveRecoverUI.this);
                                AppMethodBeat.o(17363);
                            }
                        });
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(R.string.yo);
                        BackupMoveRecoverUI.this.juX.setText(R.string.yq);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setText(R.string.yp);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17378);
                                ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click scan qrcode.");
                                Intent intent = new Intent();
                                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                                intent.setFlags(268435456);
                                com.tencent.mm.bp.d.b(BackupMoveRecoverUI.this.mController.ylL, "scanner", ".ui.BaseScanUI", intent);
                                AppMethodBeat.o(17378);
                            }
                        });
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setText(R.string.z4);
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17379);
                                ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move button.");
                                ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move.");
                                b.aSZ().aSu().jqW = 29;
                                AnonymousClass1.this.rj(29);
                                AppMethodBeat.o(17379);
                            }
                        });
                        BackupMoveRecoverUI.d(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case 29:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(R.string.zc);
                        BackupMoveRecoverUI.this.juX.setText(R.string.ze);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setText(R.string.zb);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17380);
                                ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove stop click start merge already move data.");
                                b.aSZ().aTc();
                                if (c.aTe()) {
                                    b.aSZ().aTc().aSL();
                                    AppMethodBeat.o(17380);
                                    return;
                                }
                                ab.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                                b.aSZ().aSu().jqW = -22;
                                AnonymousClass1.this.rj(-22);
                                com.tencent.mm.plugin.report.service.h.pYm.a(485, 6, 1, false);
                                AppMethodBeat.o(17380);
                            }
                        });
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setText(R.string.xs);
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17382);
                                ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
                                h.a(BackupMoveRecoverUI.this, (int) R.string.xu, (int) R.string.xt, (int) R.string.z3, (int) R.string.xb, false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(17381);
                                        ab.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d].", Integer.valueOf(i));
                                        com.tencent.mm.plugin.report.service.h.pYm.a(485, 48, 1, false);
                                        b.aSZ().aTa().stop();
                                        b.aSZ().aTc().c(true, true, -100);
                                        AppMethodBeat.o(17381);
                                    }
                                }, null, (int) R.color.go);
                                AppMethodBeat.o(17382);
                            }
                        });
                        BackupMoveRecoverUI.this.juY.setText(R.string.a1f);
                        BackupMoveRecoverUI.this.juY.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17383);
                                b.aSZ().aSu().jqW = 25;
                                BackupMoveRecoverUI.e(BackupMoveRecoverUI.this);
                                AppMethodBeat.o(17383);
                            }
                        });
                        AppMethodBeat.o(17385);
                        return;
                    case 30:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move_recover);
                        BackupMoveRecoverUI.this.juW.setText(R.string.a1e);
                        BackupMoveRecoverUI.this.juX.setText(R.string.yy);
                        BackupMoveRecoverUI.this.juX.setTextColor(BackupMoveRecoverUI.this.getResources().getColor(R.color.gp));
                        BackupMoveRecoverUI.this.juX.setVisibility(0);
                        BackupMoveRecoverUI.this.juU.setVisibility(4);
                        BackupMoveRecoverUI.this.juV.setVisibility(4);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    case 52:
                        BackupMoveRecoverUI.this.juZ.setImageResource(R.raw.backup_move);
                        BackupMoveRecoverUI.this.juW.setText(R.string.yi);
                        BackupMoveRecoverUI.this.juU.setText(R.string.yk);
                        BackupMoveRecoverUI.this.juV.setText(R.string.yj);
                        BackupMoveRecoverUI.this.juX.setVisibility(4);
                        BackupMoveRecoverUI.this.juU.setVisibility(0);
                        BackupMoveRecoverUI.this.juV.setVisibility(0);
                        BackupMoveRecoverUI.this.jva.setVisibility(8);
                        BackupMoveRecoverUI.this.juU.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17359);
                                b.aSZ().aTc().fk(false);
                                AppMethodBeat.o(17359);
                            }
                        });
                        BackupMoveRecoverUI.this.juV.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17373);
                                b.aSZ().aTc().fk(true);
                                AppMethodBeat.o(17373);
                            }
                        });
                        BackupMoveRecoverUI.c(BackupMoveRecoverUI.this);
                        AppMethodBeat.o(17385);
                        return;
                    default:
                        break;
                }
            }
            AppMethodBeat.o(17385);
        }

        public final void aSt() {
        }
    };
    public TextView juU;
    public TextView juV;
    public TextView juW;
    public TextView juX;
    public TextView juY;
    public ImageView juZ;
    private RoundProgressBtn jva;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupMoveRecoverUI() {
        AppMethodBeat.i(17390);
        AppMethodBeat.o(17390);
    }

    static /* synthetic */ void i(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(17405);
        backupMoveRecoverUI.aTw();
        AppMethodBeat.o(17405);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17391);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(17391);
            return;
        }
        ab.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
        getSupportActionBar().hide();
        com.tencent.mm.plugin.backup.a.gkE.BV();
        initView();
        try {
            Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            b.aSZ().aTc().jtw = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
            ab.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", Boolean.valueOf(b.aSZ().aTc().jtw));
            AppMethodBeat.o(17391);
        } catch (Exception e) {
            ab.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", bo.dpG());
            AppMethodBeat.o(17391);
        }
    }

    public final void initView() {
        AppMethodBeat.i(17392);
        this.juY = (TextView) findViewById(R.id.a14);
        this.juZ = (ImageView) findViewById(R.id.a15);
        this.juW = (TextView) findViewById(R.id.a16);
        this.juX = (TextView) findViewById(R.id.a17);
        this.juU = (TextView) findViewById(R.id.a19);
        this.juV = (TextView) findViewById(R.id.a18);
        this.jva = (RoundProgressBtn) findViewById(R.id.a1_);
        AppMethodBeat.o(17392);
    }

    public void onResume() {
        AppMethodBeat.i(17393);
        super.onResume();
        ab.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
        jvb = true;
        b.aSZ().aTc().jsv = this.jsv;
        gqB = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
        this.jsv.rj(b.aSZ().aSu().jqW);
        AppMethodBeat.o(17393);
    }

    public void onPause() {
        AppMethodBeat.i(17394);
        super.onPause();
        ab.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
        jvb = false;
        AppMethodBeat.o(17394);
    }

    public void onDestroy() {
        AppMethodBeat.i(17395);
        ab.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
        super.onDestroy();
        AppMethodBeat.o(17395);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(17396);
        if (i == 4) {
            aTw();
            AppMethodBeat.o(17396);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(17396);
        return onKeyDown;
    }

    private void aTw() {
        AppMethodBeat.i(17397);
        final int i = b.aSZ().aSu().jqW;
        ab.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", Integer.valueOf(i), Integer.valueOf(i));
        switch (i) {
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -13:
            case -5:
            case -3:
            case -2:
            case -1:
            case 1:
                b.aSZ().aTc().c(false, false, -100);
                AppMethodBeat.o(17397);
                return;
            case 24:
                b.aSZ().aSu().jqW = 25;
                break;
            case 26:
            case 30:
                h.a((Context) this, (int) R.string.a00, (int) R.string.zz, (int) R.string.a1_, (int) R.string.xb, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(17388);
                        ab.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", Integer.valueOf(i));
                        com.tencent.mm.plugin.report.service.h.pYm.a(485, 48, 1, false);
                        b.aSZ().aTa().stop();
                        b.aSZ().aTc().c(true, true, -100);
                        AppMethodBeat.o(17388);
                    }
                }, null, (int) R.color.go);
                AppMethodBeat.o(17397);
                return;
            case 27:
                ab.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", Integer.valueOf(i));
                b.aSZ().aTc().c(true, false, -100);
                b.aSZ().aTa().stop();
                AppMethodBeat.o(17397);
                return;
            case 52:
                h.a((Context) this, (int) R.string.xw, (int) R.string.xv, (int) R.string.z4, (int) R.string.xb, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(17387);
                        ab.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", Integer.valueOf(i));
                        com.tencent.mm.plugin.report.service.h.pYm.a(485, 44, 1, false);
                        b.aSZ().aTc().rn(5);
                        b.aSZ().aTa().stop();
                        b.aSZ().aTc().c(true, true, -100);
                        AppMethodBeat.o(17387);
                    }
                }, null, (int) R.color.go);
                AppMethodBeat.o(17397);
                return;
        }
        Ni(1);
        AppMethodBeat.o(17397);
    }

    public final int getLayoutId() {
        return R.layout.f_;
    }

    static /* synthetic */ void a(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(17398);
        backupMoveRecoverUI.Ni(1);
        AppMethodBeat.o(17398);
    }

    static /* synthetic */ void c(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(17399);
        backupMoveRecoverUI.juY.setText(R.string.xg);
        backupMoveRecoverUI.juY.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(17386);
                BackupMoveRecoverUI.i(BackupMoveRecoverUI.this);
                AppMethodBeat.o(17386);
            }
        });
        AppMethodBeat.o(17399);
    }

    static /* synthetic */ void d(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(17400);
        backupMoveRecoverUI.juY.setText(R.string.xi);
        backupMoveRecoverUI.juY.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(17389);
                ab.i("MicroMsg.BackupMoveRecoverUI", "minimize BackupMoveRecoverUI");
                BackupMoveRecoverUI.j(BackupMoveRecoverUI.this);
                AppMethodBeat.o(17389);
            }
        });
        AppMethodBeat.o(17400);
    }

    static /* synthetic */ void e(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(17401);
        backupMoveRecoverUI.Ni(1);
        AppMethodBeat.o(17401);
    }

    static /* synthetic */ void f(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(17402);
        backupMoveRecoverUI.Ni(1);
        AppMethodBeat.o(17402);
    }

    static /* synthetic */ void g(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(17403);
        backupMoveRecoverUI.Ni(1);
        AppMethodBeat.o(17403);
    }

    static /* synthetic */ void h(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(17404);
        backupMoveRecoverUI.Ni(1);
        AppMethodBeat.o(17404);
    }

    static /* synthetic */ void j(BackupMoveRecoverUI backupMoveRecoverUI) {
        AppMethodBeat.i(17406);
        backupMoveRecoverUI.Ni(1);
        AppMethodBeat.o(17406);
    }
}
