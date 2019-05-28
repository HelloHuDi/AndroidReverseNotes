package com.tencent.p177mm.plugin.backup.backupmoveui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.backup.C42757a;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19939d;
import com.tencent.p177mm.plugin.backup.p342b.C42758e;
import com.tencent.p177mm.plugin.backup.p342b.C45732c;
import com.tencent.p177mm.plugin.backup.p345d.C41258b;
import com.tencent.p177mm.plugin.backup.p345d.C6793d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.reflect.Method;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI */
public class BackupMoveUI extends MMWizardActivity {
    private C19939d jsv = new C110961();
    public TextView juU;
    public TextView juV;
    public TextView juW;
    public TextView juX;
    public TextView juY;
    public ImageView juZ;

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI$1 */
    class C110961 implements C19939d {

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI$1$1 */
        class C110951 implements OnClickListener {
            C110951() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(17407);
                C41258b.aSZ().aTa().stop();
                C41258b.aSZ().aTb().cancel(true);
                C41258b.aSZ().aSu().jqW = -100;
                BackupMoveUI.m30854c(BackupMoveUI.this);
                AppMethodBeat.m2505o(17407);
            }
        }

        C110961() {
        }

        /* renamed from: rj */
        public final void mo6681rj(int i) {
            AppMethodBeat.m2504i(17408);
            C42758e aSu = C41258b.aSZ().aSu();
            C4990ab.m7417i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", Integer.valueOf(i), Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY));
            TextView textView;
            BackupMoveUI backupMoveUI;
            Object[] objArr;
            switch (i) {
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    BackupMoveUI.m30852a(BackupMoveUI.this);
                    AppMethodBeat.m2505o(17408);
                    return;
                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                    BackupMoveUI.this.juZ.setImageResource(C1318a.backup_move_error);
                    BackupMoveUI.this.juW.setText(C25738R.string.f9370y1);
                    BackupMoveUI.this.juX.setVisibility(4);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.m30853b(BackupMoveUI.this);
                    break;
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                    BackupMoveUI.this.juZ.setImageResource(C1318a.backup_move_error);
                    BackupMoveUI.this.juW.setText(C25738R.string.f9383ye);
                    BackupMoveUI.this.juX.setVisibility(4);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.m30853b(BackupMoveUI.this);
                    AppMethodBeat.m2505o(17408);
                    return;
                case -11:
                    BackupMoveUI.this.juZ.setImageResource(C1318a.backup_move_qrcode_dark);
                    BackupMoveUI.this.juW.setText(BackupMoveUI.this.getString(C25738R.string.f9391ym, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), "0M"}));
                    BackupMoveUI.this.juX.setText(C25738R.string.f9373y5);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.mController.ylL.getResources().getColor(C25738R.color.f12266xy));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.m30853b(BackupMoveUI.this);
                    AppMethodBeat.m2505o(17408);
                    return;
                case -4:
                    BackupMoveUI.this.juZ.setImageResource(C1318a.backup_move_qrcode_dark);
                    C41258b.aSZ().aTb().jub.start();
                    BackupMoveUI.this.juW.setText(BackupMoveUI.this.getString(C25738R.string.f9391ym, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY), "0M"}));
                    BackupMoveUI.this.juX.setText(C25738R.string.f9375y7);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.mController.ylL.getResources().getColor(C25738R.color.f12266xy));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.m30855d(BackupMoveUI.this);
                    C41258b.aSZ().aTb().jtW = C45732c.jqI;
                    AppMethodBeat.m2505o(17408);
                    return;
                case 1:
                    BackupMoveUI.this.juZ.setImageResource(C1318a.backup_move);
                    BackupMoveUI.this.juW.setText(C25738R.string.f9360xr);
                    BackupMoveUI.this.juX.setText(C25738R.string.f9390yl);
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.m30853b(BackupMoveUI.this);
                    AppMethodBeat.m2505o(17408);
                    return;
                case 3:
                    BackupMoveUI.this.finish();
                    AppMethodBeat.m2505o(17408);
                    return;
                case 4:
                    BackupMoveUI.this.juZ.setImageResource(C1318a.backup_move);
                    textView = BackupMoveUI.this.juW;
                    backupMoveUI = BackupMoveUI.this;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aSu.jqX);
                    objArr[1] = Integer.valueOf(aSu.jqY);
                    C41258b.aSZ().aTb();
                    objArr[2] = C6793d.aTq();
                    textView.setText(backupMoveUI.getString(C25738R.string.f9422zg, objArr));
                    BackupMoveUI.this.juX.setText(C25738R.string.f9423zh);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.getResources().getColor(C25738R.color.f11770gp));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.m30853b(BackupMoveUI.this);
                    AppMethodBeat.m2505o(17408);
                    return;
                case 12:
                    BackupMoveUI.this.juZ.setImageResource(C1318a.backup_move);
                    BackupMoveUI.this.juW.setText(C25738R.string.f9396yr);
                    BackupMoveUI.this.juX.setText(C25738R.string.f9390yl);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.getResources().getColor(C25738R.color.f11770gp));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.m30853b(BackupMoveUI.this);
                    AppMethodBeat.m2505o(17408);
                    return;
                case 13:
                    BackupMoveUI.this.juZ.setImageResource(C1318a.backup_move);
                    BackupMoveUI.this.juW.setText(BackupMoveUI.this.getString(C25738R.string.f9354xk, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY)}));
                    BackupMoveUI.this.juX.setText(C25738R.string.f9390yl);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.getResources().getColor(C25738R.color.f11770gp));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.m30853b(BackupMoveUI.this);
                    AppMethodBeat.m2505o(17408);
                    return;
                case 14:
                    BackupMoveUI.this.juZ.setImageResource(C1318a.backup_move);
                    textView = BackupMoveUI.this.juW;
                    backupMoveUI = BackupMoveUI.this;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aSu.jqX);
                    objArr[1] = Integer.valueOf(aSu.jqY);
                    C41258b.aSZ().aTb();
                    objArr[2] = C6793d.aTq();
                    textView.setText(backupMoveUI.getString(C25738R.string.f9422zg, objArr));
                    BackupMoveUI.this.juX.setText(C25738R.string.f9390yl);
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.getResources().getColor(C25738R.color.f11770gp));
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.m30853b(BackupMoveUI.this);
                    AppMethodBeat.m2505o(17408);
                    return;
                case 15:
                    BackupMoveUI.this.juZ.setImageResource(C1318a.backup_move_finish);
                    BackupMoveUI.this.juW.setText(C25738R.string.f9385yg);
                    BackupMoveUI.this.juX.setText(BackupMoveUI.this.getString(C25738R.string.f9386yh, new Object[]{Integer.valueOf(aSu.jqX), Integer.valueOf(aSu.jqY)}));
                    BackupMoveUI.this.juX.setTextColor(BackupMoveUI.this.getResources().getColor(C25738R.color.f11770gp));
                    BackupMoveUI.this.juU.setText(C25738R.string.f9351xh);
                    BackupMoveUI.this.juX.setVisibility(0);
                    BackupMoveUI.this.juU.setVisibility(0);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.this.juU.setOnClickListener(new C110951());
                    BackupMoveUI.m30853b(BackupMoveUI.this);
                    AppMethodBeat.m2505o(17408);
                    return;
                case 51:
                    byte[] bArr = C41258b.aSZ().aTb().bitmapData;
                    BackupMoveUI.this.juZ.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    BackupMoveUI.this.juW.setText(C25738R.string.f9399yu);
                    BackupMoveUI.this.juW.setTextColor(BackupMoveUI.this.mController.ylL.getResources().getColor(C25738R.color.f11782h4));
                    BackupMoveUI.this.juX.setVisibility(4);
                    BackupMoveUI.this.juU.setVisibility(4);
                    BackupMoveUI.this.juV.setVisibility(4);
                    BackupMoveUI.m30853b(BackupMoveUI.this);
                    AppMethodBeat.m2505o(17408);
                    return;
            }
            AppMethodBeat.m2505o(17408);
        }

        public final void aSt() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI$3 */
    class C199523 implements DialogInterface.OnClickListener {
        C199523() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(17410);
            C4990ab.m7416i("MicroMsg.BackupMoveUI", "user click close. stop move.");
            C7060h.pYm.mo8378a(485, 25, 1, false);
            C41258b.aSZ().aTa().stop();
            C41258b.aSZ().aTb().cancel(false);
            C41258b.aSZ().aSu().jqW = -100;
            BackupMoveUI.m30857f(BackupMoveUI.this);
            AppMethodBeat.m2505o(17410);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI$2 */
    class C199532 implements OnClickListener {
        C199532() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17409);
            BackupMoveUI.m30856e(BackupMoveUI.this);
            AppMethodBeat.m2505o(17409);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI$4 */
    class C199544 implements OnClickListener {
        C199544() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(17411);
            BackupMoveUI.m30858g(BackupMoveUI.this);
            AppMethodBeat.m2505o(17411);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BackupMoveUI() {
        AppMethodBeat.m2504i(17412);
        AppMethodBeat.m2505o(17412);
    }

    /* renamed from: e */
    static /* synthetic */ void m30856e(BackupMoveUI backupMoveUI) {
        AppMethodBeat.m2504i(17424);
        backupMoveUI.aTw();
        AppMethodBeat.m2505o(17424);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17413);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(17413);
            return;
        }
        C4990ab.m7416i("MicroMsg.BackupMoveUI", "onCreate.");
        getSupportActionBar().hide();
        C42757a.gkE.mo38889BV();
        initView();
        try {
            Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            C41258b.aSZ().aTb().jtw = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
            C4990ab.m7411d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", Boolean.valueOf(C41258b.aSZ().aTb().jtw));
            AppMethodBeat.m2505o(17413);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", C5046bo.dpG());
            AppMethodBeat.m2505o(17413);
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(17414);
        this.juY = (TextView) findViewById(2131821585);
        this.juZ = (ImageView) findViewById(2131821586);
        this.juW = (TextView) findViewById(2131821587);
        this.juX = (TextView) findViewById(2131821588);
        this.juU = (TextView) findViewById(2131821590);
        this.juV = (TextView) findViewById(2131821589);
        AppMethodBeat.m2505o(17414);
    }

    public final int getLayoutId() {
        return 2130968797;
    }

    public void onResume() {
        AppMethodBeat.m2504i(17415);
        super.onResume();
        C41258b.aSZ().aTb().jsv = this.jsv;
        this.jsv.mo6681rj(C41258b.aSZ().aSu().jqW);
        AppMethodBeat.m2505o(17415);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17416);
        C4990ab.m7410d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
        if (C41258b.aSZ().aTb().jub != null) {
            C41258b.aSZ().aTb().jub.stop();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(17416);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(17417);
        if (i == 4) {
            aTw();
            AppMethodBeat.m2505o(17417);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(17417);
        return onKeyDown;
    }

    private void aTw() {
        AppMethodBeat.m2504i(17418);
        C4990ab.m7417i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", Integer.valueOf(C41258b.aSZ().aSu().jqW));
        switch (C41258b.aSZ().aSu().jqW) {
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
                C30379h.m48430a((Context) this, (int) C25738R.string.f9398yt, (int) C25738R.string.f9397ys, (int) C25738R.string.f9419zd, (int) C25738R.string.f9345xb, false, new C199523(), null, (int) C25738R.color.f11769go);
                AppMethodBeat.m2505o(17418);
                return;
            case 15:
                C4990ab.m7416i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
                aTy();
                AppMethodBeat.m2505o(17418);
                return;
            default:
                mo27541Ni(1);
                AppMethodBeat.m2505o(17418);
                return;
        }
    }

    private void aTy() {
        AppMethodBeat.m2504i(17419);
        C41258b.aSZ().aTd().cancel();
        C41258b.aSZ().aTb().cancel(true);
        C41258b.aSZ().aTa().stop();
        C41258b.aSZ().aSu().jqW = -100;
        mo27541Ni(1);
        AppMethodBeat.m2505o(17419);
    }

    /* renamed from: a */
    static /* synthetic */ void m30852a(BackupMoveUI backupMoveUI) {
        AppMethodBeat.m2504i(17420);
        backupMoveUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17420);
    }

    /* renamed from: b */
    static /* synthetic */ void m30853b(BackupMoveUI backupMoveUI) {
        AppMethodBeat.m2504i(17421);
        backupMoveUI.juY.setText(C25738R.string.f9350xg);
        backupMoveUI.juY.setOnClickListener(new C199532());
        AppMethodBeat.m2505o(17421);
    }

    /* renamed from: c */
    static /* synthetic */ void m30854c(BackupMoveUI backupMoveUI) {
        AppMethodBeat.m2504i(17422);
        backupMoveUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17422);
    }

    /* renamed from: d */
    static /* synthetic */ void m30855d(BackupMoveUI backupMoveUI) {
        AppMethodBeat.m2504i(17423);
        backupMoveUI.juY.setText(C25738R.string.f9352xi);
        backupMoveUI.juY.setOnClickListener(new C199544());
        AppMethodBeat.m2505o(17423);
    }

    /* renamed from: f */
    static /* synthetic */ void m30857f(BackupMoveUI backupMoveUI) {
        AppMethodBeat.m2504i(17425);
        backupMoveUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17425);
    }

    /* renamed from: g */
    static /* synthetic */ void m30858g(BackupMoveUI backupMoveUI) {
        AppMethodBeat.m2504i(17426);
        backupMoveUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17426);
    }
}
