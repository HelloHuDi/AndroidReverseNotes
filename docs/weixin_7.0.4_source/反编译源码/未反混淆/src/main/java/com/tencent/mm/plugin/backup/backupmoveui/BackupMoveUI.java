package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.reflect.Method;

@a(3)
public class BackupMoveUI extends MMWizardActivity {
    private d jsv = new d() {
        public final void rj(int i) {
            AppMethodBeat.i(17408);
            e aSu = b.aSZ().aSu();
            ab.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", Integer.valueOf(i), Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY));
            TextView textView;
            BackupMoveUI backupMoveUI;
            Object[] objArr;
            switch (i) {
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    BackupMoveUI.a(BackupMoveUI.this);
                    AppMethodBeat.o(17408);
                    return;
                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                    BackupMoveUI.this.juZ.setImageResource(R.raw.backup_move_error);
                    BackupMoveUI.this.juW.setText(R.string.y1);
                    BackupMoveUI.this.juX.setVisibility(4);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    break;
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                    BackupMoveUI.this.juZ.setImageResource(R.raw.backup_move_error);
                    BackupMoveUI.this.juW.setText(R.string.ye);
                    BackupMoveUI.this.juX.setVisibility(4);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(17408);
                    return;
                case -11:
                    BackupMoveUI.this.juZ.setImageResource(R.raw.backup_move_qrcode_dark);
                    BackupMoveUI.this.juW.setText(BackupMoveUI.this.getString(R.string.ym, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), "0M"}));
                    BackupMoveUI.this.juX.setText(R.string.y5);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.mController.ylL.getResources().getColor(R.color.xy));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(17408);
                    return;
                case -4:
                    BackupMoveUI.this.juZ.setImageResource(R.raw.backup_move_qrcode_dark);
                    b.aSZ().aTb().jub.start();
                    BackupMoveUI.this.juW.setText(BackupMoveUI.this.getString(R.string.ym, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), "0M"}));
                    BackupMoveUI.this.juX.setText(R.string.y7);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.mController.ylL.getResources().getColor(R.color.xy));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.d(BackupMoveUI.this);
                    b.aSZ().aTb().jtW = c.jqI;
                    AppMethodBeat.o(17408);
                    return;
                case 1:
                    BackupMoveUI.this.juZ.setImageResource(R.raw.backup_move);
                    BackupMoveUI.this.juW.setText(R.string.xr);
                    BackupMoveUI.this.juX.setText(R.string.yl);
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(17408);
                    return;
                case 3:
                    BackupMoveUI.this.finish();
                    AppMethodBeat.o(17408);
                    return;
                case 4:
                    BackupMoveUI.this.juZ.setImageResource(R.raw.backup_move);
                    textView = BackupMoveUI.this.juW;
                    backupMoveUI = BackupMoveUI.this;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aSu.jqX);
                    objArr[1] = Integer.valueOf(aSu.jqY);
                    b.aSZ().aTb();
                    objArr[2] = com.tencent.mm.plugin.backup.d.d.aTq();
                    textView.setText(backupMoveUI.getString(R.string.zg, objArr));
                    BackupMoveUI.this.juX.setText(R.string.zh);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.getResources().getColor(R.color.gp));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(17408);
                    return;
                case 12:
                    BackupMoveUI.this.juZ.setImageResource(R.raw.backup_move);
                    BackupMoveUI.this.juW.setText(R.string.yr);
                    BackupMoveUI.this.juX.setText(R.string.yl);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.getResources().getColor(R.color.gp));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(17408);
                    return;
                case 13:
                    BackupMoveUI.this.juZ.setImageResource(R.raw.backup_move);
                    BackupMoveUI.this.juW.setText(BackupMoveUI.this.getString(R.string.xk, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY)}));
                    BackupMoveUI.this.juX.setText(R.string.yl);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.getResources().getColor(R.color.gp));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(17408);
                    return;
                case 14:
                    BackupMoveUI.this.juZ.setImageResource(R.raw.backup_move);
                    textView = BackupMoveUI.this.juW;
                    backupMoveUI = BackupMoveUI.this;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aSu.jqX);
                    objArr[1] = Integer.valueOf(aSu.jqY);
                    b.aSZ().aTb();
                    objArr[2] = com.tencent.mm.plugin.backup.d.d.aTq();
                    textView.setText(backupMoveUI.getString(R.string.zg, objArr));
                    BackupMoveUI.this.juX.setText(R.string.yl);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.getResources().getColor(R.color.gp));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(17408);
                    return;
                case 15:
                    BackupMoveUI.this.juZ.setImageResource(R.raw.backup_move_finish);
                    BackupMoveUI.this.juW.setText(R.string.yg);
                    BackupMoveUI.this.juX.setText(BackupMoveUI.this.getString(R.string.yh, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY)}));
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.getResources().getColor(R.color.gp));
                    BackupMoveUI.this.juU.setText(R.string.xh);
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(0);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.this.juU.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(17407);
                            b.aSZ().aTa().stop();
                            b.aSZ().aTb().cancel(true);
                            b.aSZ().aSu().jqW = -100;
                            BackupMoveUI.c(BackupMoveUI.this);
                            AppMethodBeat.o(17407);
                        }
                    });
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(17408);
                    return;
                case 51:
                    byte[] bArr = b.aSZ().aTb().bitmapData;
                    BackupMoveUI.this.juZ.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    BackupMoveUI.this.juW.setText(R.string.yu);
                    BackupMoveUI.this.juW.setTextColor(BackupMoveUI.this.mController.ylL.getResources().getColor(R.color.h4));
                    BackupMoveUI.this.juX.setVisibility(4);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.b(BackupMoveUI.this);
                    AppMethodBeat.o(17408);
                    return;
            }
            AppMethodBeat.o(17408);
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupMoveUI() {
        AppMethodBeat.i(17412);
        AppMethodBeat.o(17412);
    }

    static /* synthetic */ void e(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(17424);
        backupMoveUI.aTw();
        AppMethodBeat.o(17424);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17413);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(17413);
            return;
        }
        ab.i("MicroMsg.BackupMoveUI", "onCreate.");
        getSupportActionBar().hide();
        com.tencent.mm.plugin.backup.a.gkE.BV();
        initView();
        try {
            Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            b.aSZ().aTb().jtw = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
            ab.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", Boolean.valueOf(b.aSZ().aTb().jtw));
            AppMethodBeat.o(17413);
        } catch (Exception e) {
            ab.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", bo.dpG());
            AppMethodBeat.o(17413);
        }
    }

    public final void initView() {
        AppMethodBeat.i(17414);
        this.juY = (TextView) findViewById(R.id.a14);
        this.juZ = (ImageView) findViewById(R.id.a15);
        this.juW = (TextView) findViewById(R.id.a16);
        this.juX = (TextView) findViewById(R.id.a17);
        this.juU = (TextView) findViewById(R.id.a19);
        this.juV = (TextView) findViewById(R.id.a18);
        AppMethodBeat.o(17414);
    }

    public final int getLayoutId() {
        return R.layout.f_;
    }

    public void onResume() {
        AppMethodBeat.i(17415);
        super.onResume();
        b.aSZ().aTb().jsv = this.jsv;
        this.jsv.rj(b.aSZ().aSu().jqW);
        AppMethodBeat.o(17415);
    }

    public void onDestroy() {
        AppMethodBeat.i(17416);
        ab.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
        if (b.aSZ().aTb().jub != null) {
            b.aSZ().aTb().jub.stop();
        }
        super.onDestroy();
        AppMethodBeat.o(17416);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(17417);
        if (i == 4) {
            aTw();
            AppMethodBeat.o(17417);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(17417);
        return onKeyDown;
    }

    private void aTw() {
        AppMethodBeat.i(17418);
        ab.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", Integer.valueOf(b.aSZ().aSu().jqW));
        switch (b.aSZ().aSu().jqW) {
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -11:
            case -4:
            case 1:
            case 4:
            case 12:
            case 13:
            case 14:
            case 51:
                h.a((Context) this, (int) R.string.yt, (int) R.string.ys, (int) R.string.zd, (int) R.string.xb, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(17410);
                        ab.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
                        com.tencent.mm.plugin.report.service.h.pYm.a(485, 25, 1, false);
                        b.aSZ().aTa().stop();
                        b.aSZ().aTb().cancel(false);
                        b.aSZ().aSu().jqW = -100;
                        BackupMoveUI.f(BackupMoveUI.this);
                        AppMethodBeat.o(17410);
                    }
                }, null, (int) R.color.go);
                AppMethodBeat.o(17418);
                return;
            case 15:
                ab.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
                aTy();
                AppMethodBeat.o(17418);
                return;
            default:
                Ni(1);
                AppMethodBeat.o(17418);
                return;
        }
    }

    private void aTy() {
        AppMethodBeat.i(17419);
        b.aSZ().aTd().cancel();
        b.aSZ().aTb().cancel(true);
        b.aSZ().aTa().stop();
        b.aSZ().aSu().jqW = -100;
        Ni(1);
        AppMethodBeat.o(17419);
    }

    static /* synthetic */ void a(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(17420);
        backupMoveUI.Ni(1);
        AppMethodBeat.o(17420);
    }

    static /* synthetic */ void b(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(17421);
        backupMoveUI.juY.setText(R.string.xg);
        backupMoveUI.juY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(17409);
                BackupMoveUI.e(BackupMoveUI.this);
                AppMethodBeat.o(17409);
            }
        });
        AppMethodBeat.o(17421);
    }

    static /* synthetic */ void c(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(17422);
        backupMoveUI.Ni(1);
        AppMethodBeat.o(17422);
    }

    static /* synthetic */ void d(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(17423);
        backupMoveUI.juY.setText(R.string.xi);
        backupMoveUI.juY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(17411);
                BackupMoveUI.g(BackupMoveUI.this);
                AppMethodBeat.o(17411);
            }
        });
        AppMethodBeat.o(17423);
    }

    static /* synthetic */ void f(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(17425);
        backupMoveUI.Ni(1);
        AppMethodBeat.o(17425);
    }

    static /* synthetic */ void g(BackupMoveUI backupMoveUI) {
        AppMethodBeat.i(17426);
        backupMoveUI.Ni(1);
        AppMethodBeat.o(17426);
    }
}
