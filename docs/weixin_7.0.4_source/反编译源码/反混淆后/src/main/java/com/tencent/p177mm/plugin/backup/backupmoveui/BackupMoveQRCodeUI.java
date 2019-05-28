package com.tencent.p177mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19939d;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C45732c;
import com.tencent.p177mm.plugin.backup.p345d.C41258b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19977d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI */
public class BackupMoveQRCodeUI extends MMWizardActivity {
    private C19939d jsv = new C199431();
    private ImageView juO;
    private TextView juP;
    private TextView juQ;
    private boolean juR = false;

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI$1 */
    class C199431 implements C19939d {

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI$1$2 */
        class C26062 implements OnClickListener {
            C26062() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(17339);
                C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click cancel.");
                BackupMoveQRCodeUI.m30848e(BackupMoveQRCodeUI.this);
                AppMethodBeat.m2505o(17339);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI$1$1 */
        class C199421 implements OnClickListener {
            C199421() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(17338);
                C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click move all.");
                BackupMoveQRCodeUI.this.juR = false;
                C41258b.aSZ().aTb().mo15073fl(true);
                AppMethodBeat.m2505o(17338);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI$1$7 */
        class C199447 implements OnClickListener {
            C199447() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(17344);
                C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click cancel.");
                BackupMoveQRCodeUI.m30848e(BackupMoveQRCodeUI.this);
                AppMethodBeat.m2505o(17344);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI$1$3 */
        class C199453 implements OnClickListener {
            C199453() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(17340);
                C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
                BackupMoveQRCodeUI.this.juR = false;
                C41258b.aSZ().aTb().mo15073fl(true);
                AppMethodBeat.m2505o(17340);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI$1$4 */
        class C199464 implements OnClickListener {
            C199464() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(17341);
                C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click cancel.");
                BackupMoveQRCodeUI.m30848e(BackupMoveQRCodeUI.this);
                AppMethodBeat.m2505o(17341);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI$1$5 */
        class C199475 implements OnClickListener {
            C199475() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(17342);
                C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
                AppMethodBeat.m2505o(17342);
            }
        }

        /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI$1$6 */
        class C199486 implements OnClickListener {
            C199486() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(17343);
                C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click move all.");
                BackupMoveQRCodeUI.this.juR = false;
                C41258b.aSZ().aTb().mo15073fl(true);
                AppMethodBeat.m2505o(17343);
            }
        }

        C199431() {
        }

        /* renamed from: rj */
        public final void mo6681rj(int i) {
            AppMethodBeat.m2504i(17345);
            C4990ab.m7417i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", Integer.valueOf(i));
            if (BackupMoveQRCodeUI.this.juR) {
                AppMethodBeat.m2505o(17345);
                return;
            }
            switch (i) {
                case -33:
                    BackupMoveQRCodeUI.this.juR = true;
                    C30379h.m48430a(BackupMoveQRCodeUI.this, (int) C25738R.string.f9380yb, 0, (int) C25738R.string.f9344xa, (int) C25738R.string.f9345xb, false, new C199486(), new C199447(), (int) C25738R.color.f11768gn);
                    break;
                case -32:
                    BackupMoveQRCodeUI.this.juR = true;
                    C30379h.m48430a(BackupMoveQRCodeUI.this, (int) C25738R.string.f9381yc, 0, (int) C25738R.string.f9343x_, (int) C25738R.string.f9345xb, false, new C199453(), new C199464(), (int) C25738R.color.f11768gn);
                    AppMethodBeat.m2505o(17345);
                    return;
                case -31:
                    BackupMoveQRCodeUI.this.juR = true;
                    C30379h.m48430a(BackupMoveQRCodeUI.this, (int) C25738R.string.f9382yd, 0, (int) C25738R.string.f9344xa, (int) C25738R.string.f9345xb, false, new C199421(), new C26062(), (int) C25738R.color.f11768gn);
                    AppMethodBeat.m2505o(17345);
                    return;
                case -12:
                    C30379h.m48430a(BackupMoveQRCodeUI.this, (int) C25738R.string.f9384yf, 0, (int) C25738R.string.a1u, 0, false, new C199475(), null, (int) C25738R.color.f11768gn);
                    AppMethodBeat.m2505o(17345);
                    return;
                case -11:
                case -4:
                    BackupMoveQRCodeUI.this.juP.setText(C25738R.string.f9373y5);
                    BackupMoveQRCodeUI.this.juP.setTextColor(BackupMoveQRCodeUI.this.mController.ylL.getResources().getColor(C25738R.color.f12266xy));
                    BackupMoveQRCodeUI.this.juO.setImageResource(C1318a.backup_move_qrcode_light);
                    BackupMoveQRCodeUI.this.juQ.setVisibility(4);
                    AppMethodBeat.m2505o(17345);
                    return;
                case 2:
                    C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
                    C41258b.aSZ().aSu().jqW = 12;
                    MMWizardActivity.m23791J(BackupMoveQRCodeUI.this, new Intent(BackupMoveQRCodeUI.this, BackupMoveUI.class));
                    AppMethodBeat.m2505o(17345);
                    return;
                case 51:
                    byte[] bArr = C41258b.aSZ().aTb().bitmapData;
                    BackupMoveQRCodeUI.this.juO.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    BackupMoveQRCodeUI.this.juP.setText(C25738R.string.f9399yu);
                    BackupMoveQRCodeUI.this.juP.setTextColor(BackupMoveQRCodeUI.this.mController.ylL.getResources().getColor(C25738R.color.f11782h4));
                    BackupMoveQRCodeUI.this.juQ.setVisibility(4);
                    AppMethodBeat.m2505o(17345);
                    return;
            }
            AppMethodBeat.m2505o(17345);
        }

        public final void aSt() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI$3 */
    class C199493 implements OnClickListener {
        C199493() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(17347);
            C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
            C41258b.aSZ().aTa().stop();
            C41258b.aSZ().aTb().cancel(true);
            C41258b.aSZ().aSu().jqW = -100;
            BackupMoveQRCodeUI.m30850g(BackupMoveQRCodeUI.this);
            AppMethodBeat.m2505o(17347);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI$2 */
    class C199502 implements OnMenuItemClickListener {
        C199502() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17346);
            BackupMoveQRCodeUI.m30849f(BackupMoveQRCodeUI.this);
            AppMethodBeat.m2505o(17346);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BackupMoveQRCodeUI() {
        AppMethodBeat.m2504i(17348);
        AppMethodBeat.m2505o(17348);
    }

    /* renamed from: f */
    static /* synthetic */ void m30849f(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        AppMethodBeat.m2504i(17357);
        backupMoveQRCodeUI.aTv();
        AppMethodBeat.m2505o(17357);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17349);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(17349);
        } else if (C9638aw.m17179RK()) {
            initView();
            C19978b.clear();
            C19977d aTb = C41258b.aSZ().aTb();
            C19978b.m30885a(aTb.jtM);
            C38634d.m65498rk(21);
            C19978b.m30882a(aTb.jtL);
            C41258b.aSZ().aSv();
            C19978b.m30883a(aTb);
            C19978b.m30880a(C41258b.aSZ().aTa());
            C19978b.m30890rk(2);
            C41258b.aSZ().jqR = null;
            aTb.jtV = false;
            C41258b.aSZ().aTb().jtW = C45732c.jqH;
            C38634d.aSA();
            AppMethodBeat.m2505o(17349);
        } else {
            finish();
            AppMethodBeat.m2505o(17349);
        }
    }

    public void onStart() {
        AppMethodBeat.m2504i(17350);
        super.onStart();
        C19978b.m30883a(C41258b.aSZ().aTb());
        C41258b.aSZ().aTb().jsv = this.jsv;
        C41258b.aSZ().aTb().jub.start();
        AppMethodBeat.m2505o(17350);
    }

    public void onResume() {
        AppMethodBeat.m2504i(17351);
        super.onResume();
        this.jsv.mo6681rj(C41258b.aSZ().aSu().jqW);
        AppMethodBeat.m2505o(17351);
    }

    public final void initView() {
        AppMethodBeat.m2504i(17352);
        setMMTitle((int) C25738R.string.f9353xj);
        this.juO = (ImageView) findViewById(2131821581);
        this.juP = (TextView) findViewById(2131821582);
        this.juQ = (TextView) findViewById(2131821583);
        setBackBtn(new C199502());
        AppMethodBeat.m2505o(17352);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(17353);
        if (i == 4) {
            aTv();
            AppMethodBeat.m2505o(17353);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(17353);
        return onKeyDown;
    }

    private void aTv() {
        AppMethodBeat.m2504i(17354);
        if (C9638aw.m17178QT()) {
            C30379h.m48430a((Context) this, (int) C25738R.string.f9398yt, (int) C25738R.string.f9397ys, (int) C25738R.string.f9419zd, (int) C25738R.string.f9345xb, false, new C199493(), null, (int) C25738R.color.f11769go);
            AppMethodBeat.m2505o(17354);
            return;
        }
        C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
        C41258b.aSZ().aTa().stop();
        C41258b.aSZ().aTb().cancel(true);
        C41258b.aSZ().aSu().jqW = -100;
        mo27541Ni(1);
        AppMethodBeat.m2505o(17354);
    }

    public void onStop() {
        AppMethodBeat.m2504i(17355);
        C4990ab.m7416i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
        if (C41258b.aSZ().aTb().jub != null) {
            C41258b.aSZ().aTb().jub.stop();
        }
        super.onStop();
        AppMethodBeat.m2505o(17355);
    }

    public final int getLayoutId() {
        return 2130968796;
    }

    /* renamed from: e */
    static /* synthetic */ void m30848e(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        AppMethodBeat.m2504i(17356);
        backupMoveQRCodeUI.juR = false;
        C41258b.aSZ().aTb().mo15073fl(false);
        C41258b.aSZ().aTa().stop();
        C41258b.aSZ().aTb().cancel(false);
        C41258b.aSZ().aSu().jqW = -100;
        backupMoveQRCodeUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17356);
    }

    /* renamed from: g */
    static /* synthetic */ void m30850g(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        AppMethodBeat.m2504i(17358);
        backupMoveQRCodeUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17358);
    }
}
