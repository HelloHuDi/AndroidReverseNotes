package com.tencent.mm.plugin.backup.backupmoveui;

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
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BackupMoveQRCodeUI extends MMWizardActivity {
    private d jsv = new d() {
        public final void rj(int i) {
            AppMethodBeat.i(17345);
            ab.i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", Integer.valueOf(i));
            if (BackupMoveQRCodeUI.this.juR) {
                AppMethodBeat.o(17345);
                return;
            }
            switch (i) {
                case -33:
                    BackupMoveQRCodeUI.this.juR = true;
                    h.a(BackupMoveQRCodeUI.this, (int) R.string.yb, 0, (int) R.string.xa, (int) R.string.xb, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(17343);
                            ab.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click move all.");
                            BackupMoveQRCodeUI.this.juR = false;
                            b.aSZ().aTb().fl(true);
                            AppMethodBeat.o(17343);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(17344);
                            ab.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click cancel.");
                            BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
                            AppMethodBeat.o(17344);
                        }
                    }, (int) R.color.gn);
                    break;
                case -32:
                    BackupMoveQRCodeUI.this.juR = true;
                    h.a(BackupMoveQRCodeUI.this, (int) R.string.yc, 0, (int) R.string.x_, (int) R.string.xb, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(17340);
                            ab.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
                            BackupMoveQRCodeUI.this.juR = false;
                            b.aSZ().aTb().fl(true);
                            AppMethodBeat.o(17340);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(17341);
                            ab.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click cancel.");
                            BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
                            AppMethodBeat.o(17341);
                        }
                    }, (int) R.color.gn);
                    AppMethodBeat.o(17345);
                    return;
                case -31:
                    BackupMoveQRCodeUI.this.juR = true;
                    h.a(BackupMoveQRCodeUI.this, (int) R.string.yd, 0, (int) R.string.xa, (int) R.string.xb, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(17338);
                            ab.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click move all.");
                            BackupMoveQRCodeUI.this.juR = false;
                            b.aSZ().aTb().fl(true);
                            AppMethodBeat.o(17338);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(17339);
                            ab.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click cancel.");
                            BackupMoveQRCodeUI.e(BackupMoveQRCodeUI.this);
                            AppMethodBeat.o(17339);
                        }
                    }, (int) R.color.gn);
                    AppMethodBeat.o(17345);
                    return;
                case -12:
                    h.a(BackupMoveQRCodeUI.this, (int) R.string.yf, 0, (int) R.string.a1u, 0, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(17342);
                            ab.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
                            AppMethodBeat.o(17342);
                        }
                    }, null, (int) R.color.gn);
                    AppMethodBeat.o(17345);
                    return;
                case -11:
                case -4:
                    BackupMoveQRCodeUI.this.juP.setText(R.string.y5);
                    BackupMoveQRCodeUI.this.juP.setTextColor(BackupMoveQRCodeUI.this.mController.ylL.getResources().getColor(R.color.xy));
                    BackupMoveQRCodeUI.this.juO.setImageResource(R.raw.backup_move_qrcode_light);
                    BackupMoveQRCodeUI.this.juQ.setVisibility(4);
                    AppMethodBeat.o(17345);
                    return;
                case 2:
                    ab.i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
                    b.aSZ().aSu().jqW = 12;
                    MMWizardActivity.J(BackupMoveQRCodeUI.this, new Intent(BackupMoveQRCodeUI.this, BackupMoveUI.class));
                    AppMethodBeat.o(17345);
                    return;
                case 51:
                    byte[] bArr = b.aSZ().aTb().bitmapData;
                    BackupMoveQRCodeUI.this.juO.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    BackupMoveQRCodeUI.this.juP.setText(R.string.yu);
                    BackupMoveQRCodeUI.this.juP.setTextColor(BackupMoveQRCodeUI.this.mController.ylL.getResources().getColor(R.color.h4));
                    BackupMoveQRCodeUI.this.juQ.setVisibility(4);
                    AppMethodBeat.o(17345);
                    return;
            }
            AppMethodBeat.o(17345);
        }

        public final void aSt() {
        }
    };
    private ImageView juO;
    private TextView juP;
    private TextView juQ;
    private boolean juR = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupMoveQRCodeUI() {
        AppMethodBeat.i(17348);
        AppMethodBeat.o(17348);
    }

    static /* synthetic */ void f(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        AppMethodBeat.i(17357);
        backupMoveQRCodeUI.aTv();
        AppMethodBeat.o(17357);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17349);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(17349);
        } else if (aw.RK()) {
            initView();
            com.tencent.mm.plugin.backup.g.b.clear();
            com.tencent.mm.plugin.backup.g.b.d aTb = b.aSZ().aTb();
            com.tencent.mm.plugin.backup.g.b.a(aTb.jtM);
            com.tencent.mm.plugin.backup.b.d.rk(21);
            com.tencent.mm.plugin.backup.g.b.a(aTb.jtL);
            b.aSZ().aSv();
            com.tencent.mm.plugin.backup.g.b.a(aTb);
            com.tencent.mm.plugin.backup.g.b.a(b.aSZ().aTa());
            com.tencent.mm.plugin.backup.g.b.rk(2);
            b.aSZ().jqR = null;
            aTb.jtV = false;
            b.aSZ().aTb().jtW = c.jqH;
            com.tencent.mm.plugin.backup.b.d.aSA();
            AppMethodBeat.o(17349);
        } else {
            finish();
            AppMethodBeat.o(17349);
        }
    }

    public void onStart() {
        AppMethodBeat.i(17350);
        super.onStart();
        com.tencent.mm.plugin.backup.g.b.a(b.aSZ().aTb());
        b.aSZ().aTb().jsv = this.jsv;
        b.aSZ().aTb().jub.start();
        AppMethodBeat.o(17350);
    }

    public void onResume() {
        AppMethodBeat.i(17351);
        super.onResume();
        this.jsv.rj(b.aSZ().aSu().jqW);
        AppMethodBeat.o(17351);
    }

    public final void initView() {
        AppMethodBeat.i(17352);
        setMMTitle((int) R.string.xj);
        this.juO = (ImageView) findViewById(R.id.a10);
        this.juP = (TextView) findViewById(R.id.a11);
        this.juQ = (TextView) findViewById(R.id.a12);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17346);
                BackupMoveQRCodeUI.f(BackupMoveQRCodeUI.this);
                AppMethodBeat.o(17346);
                return true;
            }
        });
        AppMethodBeat.o(17352);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(17353);
        if (i == 4) {
            aTv();
            AppMethodBeat.o(17353);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(17353);
        return onKeyDown;
    }

    private void aTv() {
        AppMethodBeat.i(17354);
        if (aw.QT()) {
            h.a((Context) this, (int) R.string.yt, (int) R.string.ys, (int) R.string.zd, (int) R.string.xb, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(17347);
                    ab.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
                    b.aSZ().aTa().stop();
                    b.aSZ().aTb().cancel(true);
                    b.aSZ().aSu().jqW = -100;
                    BackupMoveQRCodeUI.g(BackupMoveQRCodeUI.this);
                    AppMethodBeat.o(17347);
                }
            }, null, (int) R.color.go);
            AppMethodBeat.o(17354);
            return;
        }
        ab.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
        b.aSZ().aTa().stop();
        b.aSZ().aTb().cancel(true);
        b.aSZ().aSu().jqW = -100;
        Ni(1);
        AppMethodBeat.o(17354);
    }

    public void onStop() {
        AppMethodBeat.i(17355);
        ab.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
        if (b.aSZ().aTb().jub != null) {
            b.aSZ().aTb().jub.stop();
        }
        super.onStop();
        AppMethodBeat.o(17355);
    }

    public final int getLayoutId() {
        return R.layout.f9;
    }

    static /* synthetic */ void e(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        AppMethodBeat.i(17356);
        backupMoveQRCodeUI.juR = false;
        b.aSZ().aTb().fl(false);
        b.aSZ().aTa().stop();
        b.aSZ().aTb().cancel(false);
        b.aSZ().aSu().jqW = -100;
        backupMoveQRCodeUI.Ni(1);
        AppMethodBeat.o(17356);
    }

    static /* synthetic */ void g(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        AppMethodBeat.i(17358);
        backupMoveQRCodeUI.Ni(1);
        AppMethodBeat.o(17358);
    }
}
