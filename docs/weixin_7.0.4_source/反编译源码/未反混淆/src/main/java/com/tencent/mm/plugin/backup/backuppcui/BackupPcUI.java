package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(3)
public class BackupPcUI extends MMWizardActivity {
    private static boolean gqB = false;
    private TextView juU;
    private TextView juV;
    private TextView juW;
    private TextView juX;
    private TextView juY;
    private ImageView juZ;
    public c jwO = new c() {
        public final void aSs() {
            AppMethodBeat.i(17612);
            ab.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", Integer.valueOf(b.aTD().aTE().jwa));
            switch (b.aTD().aTE().jwa) {
                case 1:
                    b.aTD().aSu().jqW = 11;
                    rj(11);
                    AppMethodBeat.o(17612);
                    return;
                case 2:
                    b.aTD().aSu().jqW = 21;
                    rj(21);
                    AppMethodBeat.o(17612);
                    return;
                case 3:
                    b.aTD().aSu().jqW = 12;
                    rj(12);
                    AppMethodBeat.o(17612);
                    return;
                case 4:
                    b.aTD().aSu().jqW = 22;
                    rj(22);
                    break;
            }
            AppMethodBeat.o(17612);
        }

        public final void rj(int i) {
            AppMethodBeat.i(17613);
            while (true) {
                int i2 = b.aTD().aTE().jwa;
                ab.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                e aSu = b.aTD().aSu();
                TextView c;
                BackupPcUI backupPcUI;
                Object[] objArr;
                switch (i) {
                    case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                        BackupPcUI.a(BackupPcUI.this);
                        AppMethodBeat.o(17613);
                        return;
                    case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                        rv(i2);
                        BackupPcUI.this.juW.setText(R.string.a05);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        break;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        rv(i2);
                        BackupPcUI.this.juW.setText(R.string.a08);
                        b.aTD().aTa().stop();
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                        rv(i2);
                        BackupPcUI.this.juW.setText(R.string.a0f);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case -13:
                        rv(i2);
                        BackupPcUI.this.juW.setText(R.string.a0c);
                        b.aTD().aTa().stop();
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case -5:
                        rv(i2);
                        BackupPcUI.this.juW.setText(R.string.a04);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case -4:
                        if (1 == i2 || 3 == i2) {
                            BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_error);
                            BackupPcUI.this.juW.setText(BackupPcUI.this.getString(R.string.a1b, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), "0M"}));
                            BackupPcUI.this.juX.setText(R.string.a09);
                            BackupPcUI.this.juV.setText(R.string.a19);
                            BackupPcUI.this.juV.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(17595);
                                    h.a(BackupPcUI.this, (int) R.string.zy, (int) R.string.zx, (int) R.string.a19, (int) R.string.xb, false, new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(17594);
                                            ab.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                                            com.tencent.mm.plugin.report.service.h.pYm.a(400, 10, 1, false);
                                            b.aTD().aTF().rt(4);
                                            b.aTD().aTa().stop();
                                            b.aTD().aTF().cancel(true);
                                            b.aTD().aSu().jqW = -100;
                                            BackupPcUI.l(BackupPcUI.this);
                                            AppMethodBeat.o(17594);
                                        }
                                    }, null, (int) R.color.go);
                                    AppMethodBeat.o(17595);
                                }
                            });
                        } else if (2 == i2 || 4 == i2) {
                            BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_recover_error);
                            BackupPcUI.this.juW.setText(BackupPcUI.this.getString(R.string.a0y, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), "0M"}));
                            BackupPcUI.this.juX.setText(R.string.a0g);
                            BackupPcUI.this.juV.setText(R.string.a1a);
                            BackupPcUI.this.juV.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(17597);
                                    h.a(BackupPcUI.this, (int) R.string.a00, (int) R.string.zz, (int) R.string.a1_, (int) R.string.xb, false, new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(17596);
                                            ab.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                                            com.tencent.mm.plugin.report.service.h.pYm.a(400, 18, 1, false);
                                            b.aTD().aTG().rt(4);
                                            b.aTD().aTa().stop();
                                            b.aTD().aTG().c(true, true, -100);
                                            AppMethodBeat.o(17596);
                                        }
                                    }, null, (int) R.color.go);
                                    AppMethodBeat.o(17597);
                                }
                            });
                        }
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.go));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(0);
                        aTR();
                        AppMethodBeat.o(17613);
                        return;
                    case -3:
                        rv(i2);
                        BackupPcUI.this.juW.setText(R.string.a03);
                        BackupPcUI.this.juV.setText(R.string.a0i);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(0);
                        BackupPcUI.this.juV.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17599);
                                BackupPcUI.m(BackupPcUI.this);
                                AppMethodBeat.o(17599);
                            }
                        });
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case -2:
                    case -1:
                        rv(i2);
                        BackupPcUI.this.juW.setText(R.string.a0d);
                        String ds = g.ds(BackupPcUI.this);
                        if (ds == null || ds.equals("")) {
                            BackupPcUI.this.juX.setText(BackupPcUI.this.getString(R.string.a0e, new Object[]{b.aTD().aTE().jwb, "移动网络"}));
                        } else {
                            BackupPcUI.this.juX.setText(BackupPcUI.this.getString(R.string.a0e, new Object[]{b.aTD().aTE().jwb, ds}));
                        }
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.go));
                        BackupPcUI.this.juV.setText(R.string.a0i);
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(0);
                        BackupPcUI.this.juV.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17598);
                                BackupPcUI.m(BackupPcUI.this);
                                AppMethodBeat.o(17598);
                            }
                        });
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case 1:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_icon);
                        BackupPcUI.this.juW.setText(R.string.zu);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case 4:
                        switch (i2) {
                            case 1:
                            case 3:
                                BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_icon);
                                c = BackupPcUI.this.juW;
                                backupPcUI = BackupPcUI.this;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aSu.jqX);
                                objArr[1] = Integer.valueOf(aSu.jqY);
                                b.aTD().aTE();
                                objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aTJ();
                                c.setText(backupPcUI.getString(R.string.a1b, objArr));
                                break;
                            case 2:
                            case 4:
                                BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_recover_icon);
                                c = BackupPcUI.this.juW;
                                backupPcUI = BackupPcUI.this;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aSu.jqX);
                                objArr[1] = Integer.valueOf(aSu.jqY);
                                b.aTD().aTE();
                                objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aTJ();
                                c.setText(backupPcUI.getString(R.string.a0y, objArr));
                                break;
                        }
                        BackupPcUI.this.juX.setText(R.string.a1d);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.go));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTR();
                        AppMethodBeat.o(17613);
                        return;
                    case 5:
                        switch (i2) {
                            case 1:
                            case 3:
                                BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_icon);
                                c = BackupPcUI.this.juW;
                                backupPcUI = BackupPcUI.this;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aSu.jqX);
                                objArr[1] = Integer.valueOf(aSu.jqY);
                                b.aTD().aTE();
                                objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aTJ();
                                c.setText(backupPcUI.getString(R.string.a1b, objArr));
                                BackupPcUI.this.juV.setText(R.string.a19);
                                BackupPcUI.this.juV.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(17611);
                                        h.a(BackupPcUI.this, (int) R.string.zy, (int) R.string.zx, (int) R.string.a19, (int) R.string.xb, false, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(17610);
                                                ab.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                                                b.aTD().aTa().stop();
                                                b.aTD().aTF().cancel(true);
                                                b.aTD().aSu().jqW = -100;
                                                com.tencent.mm.plugin.report.service.h.pYm.a(400, 52, 1, false);
                                                b.aTD().aTF().rt(4);
                                                BackupPcUI.k(BackupPcUI.this);
                                                AppMethodBeat.o(17610);
                                            }
                                        }, null, (int) R.color.go);
                                        AppMethodBeat.o(17611);
                                    }
                                });
                                break;
                            case 2:
                            case 4:
                                BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_recover_icon);
                                c = BackupPcUI.this.juW;
                                backupPcUI = BackupPcUI.this;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aSu.jqX);
                                objArr[1] = Integer.valueOf(aSu.jqY);
                                b.aTD().aTE();
                                objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aTJ();
                                c.setText(backupPcUI.getString(R.string.a0y, objArr));
                                BackupPcUI.this.juV.setText(R.string.a1a);
                                BackupPcUI.this.juV.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(17593);
                                        h.a(BackupPcUI.this, (int) R.string.a00, (int) R.string.zz, (int) R.string.a1_, (int) R.string.xb, false, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(17592);
                                                ab.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                                                b.aTD().aTa().stop();
                                                b.aTD().aTG().c(true, true, -100);
                                                com.tencent.mm.plugin.report.service.h.pYm.a(400, 52, 1, false);
                                                b.aTD().aTG().rt(4);
                                                AppMethodBeat.o(17592);
                                            }
                                        }, null, (int) R.color.go);
                                        AppMethodBeat.o(17593);
                                    }
                                });
                                break;
                        }
                        BackupPcUI.this.juX.setText(R.string.a1c);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.go));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(0);
                        aTR();
                        AppMethodBeat.o(17613);
                        return;
                    case 11:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_icon);
                        BackupPcUI.this.juW.setText(R.string.a18);
                        BackupPcUI.this.juX.setText(R.string.a17);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.gp));
                        BackupPcUI.this.juU.setText(R.string.a15);
                        BackupPcUI.this.juV.setText(R.string.a16);
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(0);
                        BackupPcUI.this.juV.setVisibility(0);
                        aTQ();
                        BackupPcUI.this.juU.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17591);
                                aw.ZK();
                                ab.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", Boolean.valueOf(((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()));
                                if (((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                                    h.a(BackupPcUI.this, (int) R.string.a0k, 0, (int) R.string.a1u, 0, false, new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(17590);
                                            b.aTD().aTE().rs(2);
                                            b.aTD().aSu().jqW = 12;
                                            AnonymousClass3.this.rj(12);
                                            b.aTD().aTH().aTC();
                                            b.aTD().aTH().fn(true);
                                            com.tencent.mm.plugin.report.service.h.pYm.a(400, 7, 1, false);
                                            com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(9), Integer.valueOf(b.aTD().aTE().jwg));
                                            AppMethodBeat.o(17590);
                                        }
                                    }, null, (int) R.color.gn);
                                    AppMethodBeat.o(17591);
                                    return;
                                }
                                b.aTD().aTE().rs(2);
                                b.aTD().aSu().jqW = 12;
                                AnonymousClass3.this.rj(12);
                                b.aTD().aTH().cancel();
                                b.aTD().aTH().aTC();
                                b.aTD().aTH().fn(true);
                                com.tencent.mm.plugin.report.service.h.pYm.a(400, 7, 1, false);
                                com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(9), Integer.valueOf(b.aTD().aTE().jwg));
                                AppMethodBeat.o(17591);
                            }
                        });
                        BackupPcUI.this.juV.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17602);
                                MMWizardActivity.J(BackupPcUI.this, new Intent(BackupPcUI.this, BackupPcChooseUI.class));
                                b.aTD().aTH().cancel();
                                b.aTD().aTH().aTC();
                                b.aTD().aTH().fn(false);
                                AppMethodBeat.o(17602);
                            }
                        });
                        AppMethodBeat.o(17613);
                        return;
                    case 12:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_icon);
                        BackupPcUI.this.juW.setText(R.string.a0n);
                        BackupPcUI.this.juX.setText(R.string.a0o);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.gp));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTR();
                        AppMethodBeat.o(17613);
                        return;
                    case 14:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_icon);
                        c = BackupPcUI.this.juW;
                        backupPcUI = BackupPcUI.this;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aSu.jqX);
                        objArr[1] = Integer.valueOf(aSu.jqY);
                        b.aTD().aTE();
                        objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aTJ();
                        c.setText(backupPcUI.getString(R.string.a1b, objArr));
                        BackupPcUI.this.juX.setText(R.string.a0o);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.gp));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTR();
                        AppMethodBeat.o(17613);
                        return;
                    case 15:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_finished);
                        BackupPcUI.this.juW.setText(R.string.zl);
                        BackupPcUI.this.juX.setText(BackupPcUI.this.getString(R.string.zm, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY)}));
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.gp));
                        BackupPcUI.this.juU.setText(R.string.xh);
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(0);
                        BackupPcUI.this.juV.setVisibility(4);
                        BackupPcUI.this.juU.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17603);
                                b.aTD().aTa().stop();
                                b.aTD().aTF().cancel(true);
                                b.aTD().aSu().jqW = -100;
                                BackupPcUI.g(BackupPcUI.this);
                                AppMethodBeat.o(17603);
                            }
                        });
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case 21:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_recover_icon);
                        BackupPcUI.this.juW.setText(R.string.a0w);
                        BackupPcUI.this.juU.setText(R.string.a0v);
                        BackupPcUI.this.juX.setVisibility(4);
                        BackupPcUI.this.juU.setVisibility(0);
                        BackupPcUI.this.juV.setVisibility(4);
                        BackupPcUI.this.juU.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17604);
                                com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(23), Integer.valueOf(b.aTD().aTE().jwg));
                                b.aTD().aTE().rs(4);
                                b.aTD().aSu().jqW = 22;
                                AnonymousClass3.this.rj(22);
                                com.tencent.mm.plugin.report.service.h.pYm.a(400, 16, 1, false);
                                AppMethodBeat.o(17604);
                            }
                        });
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case 22:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_recover_icon);
                        BackupPcUI.this.juW.setText(R.string.a0n);
                        BackupPcUI.this.juX.setText(R.string.a0o);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.gp));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTR();
                        AppMethodBeat.o(17613);
                        return;
                    case 23:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_recover_icon);
                        c = BackupPcUI.this.juW;
                        backupPcUI = BackupPcUI.this;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aSu.jqX);
                        objArr[1] = Integer.valueOf(aSu.jqY);
                        b.aTD().aTE();
                        objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aTJ();
                        c.setText(backupPcUI.getString(R.string.a0y, objArr));
                        BackupPcUI.this.juX.setText(R.string.a0o);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.gp));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTR();
                        AppMethodBeat.o(17613);
                        return;
                    case 24:
                        if (BackupPcUI.gqB) {
                            BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_recover_icon);
                            BackupPcUI.this.juW.setText(R.string.a0z);
                            BackupPcUI.this.juX.setText(R.string.a11);
                            BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.gp));
                            BackupPcUI.this.juU.setText(R.string.a0u);
                            BackupPcUI.this.juV.setText(R.string.a0x);
                            BackupPcUI.this.juY.setText(R.string.a1f);
                            BackupPcUI.this.juX.setVisibility(0);
                            BackupPcUI.this.juU.setVisibility(0);
                            BackupPcUI.this.juV.setVisibility(0);
                            BackupPcUI.this.juU.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(17605);
                                    ab.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
                                    b.aTD().aTG();
                                    if (!d.aTe()) {
                                        b.aTD().aTG();
                                        if (!d.aTe()) {
                                            b.aTD().aSu().jqW = -22;
                                            AnonymousClass3.this.rj(-22);
                                            com.tencent.mm.plugin.report.service.h.pYm.a(400, 64, 1, false);
                                            AppMethodBeat.o(17605);
                                            return;
                                        }
                                    }
                                    com.tencent.mm.plugin.report.service.h.pYm.e(13735, Integer.valueOf(27), Integer.valueOf(b.aTD().aTE().jwg));
                                    b.aTD().aTG().aSL();
                                    AppMethodBeat.o(17605);
                                }
                            });
                            BackupPcUI.this.juV.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(17607);
                                    h.a(BackupPcUI.this, (int) R.string.a00, (int) R.string.zz, (int) R.string.a1_, (int) R.string.xb, false, new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(17606);
                                            ab.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                                            com.tencent.mm.plugin.report.service.h.pYm.a(400, 26, 1, false);
                                            b.aTD().aTa().stop();
                                            b.aTD().aTG().c(true, true, -100);
                                            AppMethodBeat.o(17606);
                                        }
                                    }, null, (int) R.color.go);
                                    AppMethodBeat.o(17607);
                                }
                            });
                            BackupPcUI.this.juY.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(17608);
                                    b.aTD().aSu().jqW = 25;
                                    BackupPcUI.i(BackupPcUI.this);
                                    AppMethodBeat.o(17608);
                                }
                            });
                            AppMethodBeat.o(17613);
                            return;
                        } else if (bo.cv(BackupPcUI.this)) {
                            b.aTD().aTG();
                            if (d.aTe()) {
                                b.aTD().aTG().aSL();
                                AppMethodBeat.o(17613);
                                return;
                            }
                            b.aTD().aSu().jqW = -22;
                            rj(-22);
                            com.tencent.mm.plugin.report.service.h.pYm.a(400, 64, 1, false);
                            AppMethodBeat.o(17613);
                            return;
                        }
                        break;
                    case 25:
                        if (!bo.cv(BackupPcUI.this)) {
                            break;
                        }
                        b.aTD().aSu().jqW = 24;
                        i = 24;
                    case 26:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_recover_icon);
                        BackupPcUI.this.juW.setText(BackupPcUI.this.getString(R.string.a0t, new Object[]{Integer.valueOf(aSu.jqZ)}));
                        BackupPcUI.this.juX.setText(R.string.a0s);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.gp));
                        BackupPcUI.this.juY.setText(R.string.a0x);
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case 27:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_recover_finished);
                        BackupPcUI.this.juW.setText(R.string.a0q);
                        BackupPcUI.this.juX.setText(BackupPcUI.this.getString(R.string.a0r, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY)}));
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.gp));
                        BackupPcUI.this.juU.setText(R.string.xh);
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(0);
                        BackupPcUI.this.juV.setVisibility(4);
                        BackupPcUI.this.juU.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(17609);
                                b.aTD().aTa().stop();
                                b.aTD().aSu().jqW = -100;
                                BackupPcUI.j(BackupPcUI.this);
                                AppMethodBeat.o(17609);
                            }
                        });
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    case 30:
                        BackupPcUI.this.juZ.setImageResource(R.raw.backup_move_recover);
                        BackupPcUI.this.juW.setText(R.string.a1e);
                        BackupPcUI.this.juX.setText(R.string.yy);
                        BackupPcUI.this.juX.setTextColor(BackupPcUI.this.getResources().getColor(R.color.gp));
                        BackupPcUI.this.juX.setVisibility(0);
                        BackupPcUI.this.juU.setVisibility(4);
                        BackupPcUI.this.juV.setVisibility(4);
                        aTQ();
                        AppMethodBeat.o(17613);
                        return;
                    default:
                        break;
                }
            }
            AppMethodBeat.o(17613);
        }

        private void rv(int i) {
            AppMethodBeat.i(17614);
            if (2 == i || 4 == i) {
                BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_recover_error);
                AppMethodBeat.o(17614);
                return;
            }
            BackupPcUI.this.juZ.setImageResource(R.raw.backup_pc_error);
            AppMethodBeat.o(17614);
        }

        private void aTQ() {
            AppMethodBeat.i(17615);
            BackupPcUI.this.juY.setText(R.string.xg);
            BackupPcUI.this.juY.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(17600);
                    BackupPcUI.n(BackupPcUI.this);
                    AppMethodBeat.o(17600);
                }
            });
            AppMethodBeat.o(17615);
        }

        private void aTR() {
            AppMethodBeat.i(17616);
            BackupPcUI.this.juY.setText(R.string.xi);
            BackupPcUI.this.juY.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(17601);
                    BackupPcUI.o(BackupPcUI.this);
                    AppMethodBeat.o(17601);
                }
            });
            AppMethodBeat.o(17616);
        }

        public final void aSt() {
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupPcUI() {
        AppMethodBeat.i(17617);
        AppMethodBeat.o(17617);
    }

    static /* synthetic */ void n(BackupPcUI backupPcUI) {
        AppMethodBeat.i(17634);
        backupPcUI.aTw();
        AppMethodBeat.o(17634);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17618);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(17618);
            return;
        }
        ab.i("MicroMsg.BackupPcUI", "onCreate.");
        getSupportActionBar().hide();
        com.tencent.mm.plugin.backup.a.gkE.BV();
        initView();
        if (b.aTD().aTE().jwh) {
            b.aTD().aTE().jwh = false;
            final int aSG = g.aSG();
            if (aSG < 50) {
                com.tencent.mm.plugin.report.service.h.pYm.a(400, 4, 1, false);
                com.tencent.mm.plugin.report.service.h.pYm.e(13736, Integer.valueOf(4), b.aTD().aTE().jwb, g.ds(this), Integer.valueOf(0), Integer.valueOf(b.aTD().aTE().jwg));
                h.a((Context) this, (int) R.string.a07, (int) R.string.a06, (int) R.string.a1u, 0, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(17588);
                        ab.i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", Integer.valueOf(aSG));
                        AppMethodBeat.o(17588);
                    }
                }, null, (int) R.color.gn);
            }
        }
        AppMethodBeat.o(17618);
    }

    public void onStart() {
        AppMethodBeat.i(17619);
        super.onStart();
        ab.i("MicroMsg.BackupPcUI", "onStart.");
        gqB = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
        AppMethodBeat.o(17619);
    }

    public void onPause() {
        AppMethodBeat.i(17620);
        super.onPause();
        ab.i("MicroMsg.BackupPcUI", "onPause.");
        com.tencent.mm.plugin.backup.backuppcmodel.e aTF = b.aTD().aTF();
        c cVar = this.jwO;
        synchronized (aTF.jwm) {
            try {
                aTF.jwm.remove(cVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(17620);
            }
        }
        d aTG = b.aTD().aTG();
        cVar = this.jwO;
        synchronized (aTG.jwm) {
            try {
                aTG.jwm.remove(cVar);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(17620);
                }
            }
        }
    }

    public void onResume() {
        AppMethodBeat.i(17621);
        super.onResume();
        ab.i("MicroMsg.BackupPcUI", "onResume.");
        com.tencent.mm.plugin.backup.backuppcmodel.e aTF = b.aTD().aTF();
        c cVar = this.jwO;
        synchronized (aTF.jwm) {
            try {
                aTF.jwm.add(cVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(17621);
            }
        }
        d aTG = b.aTD().aTG();
        cVar = this.jwO;
        synchronized (aTG.jwm) {
            try {
                aTG.jwm.add(cVar);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(17621);
                }
            }
        }
        this.jwO.rj(b.aTD().aSu().jqW);
    }

    public final void initView() {
        AppMethodBeat.i(17622);
        this.juY = (TextView) findViewById(R.id.a14);
        this.juZ = (ImageView) findViewById(R.id.a15);
        this.juW = (TextView) findViewById(R.id.a16);
        this.juX = (TextView) findViewById(R.id.a17);
        this.juU = (TextView) findViewById(R.id.a19);
        this.juV = (TextView) findViewById(R.id.a18);
        AppMethodBeat.o(17622);
    }

    public final int getLayoutId() {
        return R.layout.f_;
    }

    public void onDestroy() {
        AppMethodBeat.i(17623);
        ab.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", bo.dpG());
        super.onDestroy();
        AppMethodBeat.o(17623);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(17624);
        if (i == 4) {
            aTw();
            AppMethodBeat.o(17624);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(17624);
        return onKeyDown;
    }

    private void aTw() {
        AppMethodBeat.i(17625);
        int i = b.aTD().aSu().jqW;
        int i2 = b.aTD().aTE().jwa;
        ab.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d, commandMode:%d", Integer.valueOf(i), Integer.valueOf(i2));
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
                        b.aTD().aSu().jqW = -100;
                        break;
                    }
                    b.aTD().aTG().c(false, false, -100);
                    AppMethodBeat.o(17625);
                    return;
                }
                b.aTD().aTF().cancel(false);
                b.aTD().aSu().jqW = -100;
                break;
                break;
            case 15:
                ab.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
                aTP();
                AppMethodBeat.o(17625);
                return;
            case 24:
                b.aTD().aSu().jqW = 25;
                break;
            case 26:
            case 30:
                h.a((Context) this, (int) R.string.a00, (int) R.string.zz, (int) R.string.a1_, (int) R.string.xb, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(17589);
                        ab.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
                        com.tencent.mm.plugin.report.service.h.pYm.a(400, 26, 1, false);
                        b.aTD().aTa().stop();
                        b.aTD().aTG().c(true, true, -100);
                        AppMethodBeat.o(17589);
                    }
                }, null, (int) R.color.go);
                AppMethodBeat.o(17625);
                return;
            case 27:
                ab.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
                aTP();
                AppMethodBeat.o(17625);
                return;
        }
        Ni(1);
        AppMethodBeat.o(17625);
    }

    private void aTP() {
        AppMethodBeat.i(17626);
        ab.i("MicroMsg.BackupPcUI", "exitBackupPc.");
        if (1 == b.aTD().aTE().jwa || 3 == b.aTD().aTE().jwa) {
            b.aTD().aTH().cancel();
            b.aTD().aTH().aTC();
            b.aTD().aTF().cancel(true);
            b.aTD().aTa().stop();
            b.aTD().aSu().jqW = -100;
            Ni(1);
            AppMethodBeat.o(17626);
            return;
        }
        if (2 == b.aTD().aTE().jwa || 4 == b.aTD().aTE().jwa) {
            b.aTD().aTG().c(true, true, -100);
            b.aTD().aTa().stop();
        }
        AppMethodBeat.o(17626);
    }

    static /* synthetic */ void a(BackupPcUI backupPcUI) {
        AppMethodBeat.i(17627);
        backupPcUI.Ni(1);
        AppMethodBeat.o(17627);
    }

    static /* synthetic */ void g(BackupPcUI backupPcUI) {
        AppMethodBeat.i(17628);
        backupPcUI.Ni(1);
        AppMethodBeat.o(17628);
    }

    static /* synthetic */ void i(BackupPcUI backupPcUI) {
        AppMethodBeat.i(17629);
        backupPcUI.Ni(1);
        AppMethodBeat.o(17629);
    }

    static /* synthetic */ void j(BackupPcUI backupPcUI) {
        AppMethodBeat.i(17630);
        backupPcUI.Ni(1);
        AppMethodBeat.o(17630);
    }

    static /* synthetic */ void k(BackupPcUI backupPcUI) {
        AppMethodBeat.i(17631);
        backupPcUI.Ni(1);
        AppMethodBeat.o(17631);
    }

    static /* synthetic */ void l(BackupPcUI backupPcUI) {
        AppMethodBeat.i(17632);
        backupPcUI.Ni(1);
        AppMethodBeat.o(17632);
    }

    static /* synthetic */ void m(BackupPcUI backupPcUI) {
        AppMethodBeat.i(17633);
        ab.i("MicroMsg.BackupPcUI", "jumpToNetworkDisconnectDoc.");
        Intent intent = new Intent();
        intent.putExtra("title", backupPcUI.getString(R.string.a0l));
        intent.putExtra("rawUrl", backupPcUI.getString(R.string.g5k, new Object[]{aa.dor()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.bp.d.b((Context) backupPcUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(17633);
    }

    static /* synthetic */ void o(BackupPcUI backupPcUI) {
        AppMethodBeat.i(17635);
        backupPcUI.Ni(1);
        AppMethodBeat.o(17635);
    }
}
