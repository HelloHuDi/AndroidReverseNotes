package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.walletlock.c.b;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI extends MMActivity {
    private String JU;
    private String gHr = null;
    private String gtl;
    private c hSs = null;
    private boolean isCancelled = false;
    private TextView juY;
    private ProgressDialog kvA = null;
    private int msy = 0;
    private boolean ozH = true;
    private boolean tVe = false;
    private TextView tVl;
    private TextView tVm;
    private TextView tVn;
    private Animation tVo;
    private String tVp;
    private String tVq;
    private d tVr;
    private h tVs;
    private b tVt;
    private String tVu = "-1";
    private int tVv = -1;
    private int tVw = -1;

    public class a implements b {
        private WeakReference<FingerprintWalletLockUI> msL = null;

        public a(FingerprintWalletLockUI fingerprintWalletLockUI) {
            AppMethodBeat.i(51513);
            this.msL = new WeakReference(fingerprintWalletLockUI);
            AppMethodBeat.o(51513);
        }

        private FingerprintWalletLockUI cTx() {
            AppMethodBeat.i(51514);
            if (this.msL != null) {
                FingerprintWalletLockUI fingerprintWalletLockUI = (FingerprintWalletLockUI) this.msL.get();
                AppMethodBeat.o(51514);
                return fingerprintWalletLockUI;
            }
            AppMethodBeat.o(51514);
            return null;
        }

        public final void cTy() {
            AppMethodBeat.i(51515);
            FingerprintWalletLockUI.a(FingerprintWalletLockUI.this);
            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this);
            AppMethodBeat.o(51515);
        }

        public final void T(int i, String str) {
            bj bjVar;
            AppMethodBeat.i(51516);
            ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", Integer.valueOf(i), str, Boolean.valueOf(FingerprintWalletLockUI.this.isCancelled));
            if (FingerprintWalletLockUI.this.JU != null && FingerprintWalletLockUI.this.JU.equals("action.switch_on_pattern")) {
                bjVar = new bj();
                bjVar.cVT = 3;
                bjVar.dcm = 1;
                bjVar.ajK();
            }
            if (FingerprintWalletLockUI.this.JU != null && FingerprintWalletLockUI.this.JU.equals("action.verify_pattern")) {
                if (FingerprintWalletLockUI.this.tVw == 1) {
                    bjVar = new bj();
                    bjVar.cVT = 7;
                    bjVar.dcm = 1;
                    bjVar.ajK();
                } else if (FingerprintWalletLockUI.this.tVw == 2) {
                    bjVar = new bj();
                    bjVar.cVT = 9;
                    bjVar.dcm = 1;
                    bjVar.ajK();
                }
            }
            if (FingerprintWalletLockUI.this.isCancelled) {
                AppMethodBeat.o(51516);
                return;
            }
            switch (i) {
                case 0:
                    ab.i("MicroMsg.FingerprintWalletLockUI", "identify success");
                    if (cTx() != null) {
                        FingerprintWalletLockUI.f(cTx());
                    }
                    if (FingerprintWalletLockUI.this.JU != null && FingerprintWalletLockUI.this.JU.equals("action.switch_on_pattern")) {
                        bjVar = new bj();
                        bjVar.cVT = 3;
                        bjVar.dcm = 2;
                        bjVar.ajK();
                    }
                    if (FingerprintWalletLockUI.this.JU != null && FingerprintWalletLockUI.this.JU.equals("action.verify_pattern")) {
                        if (FingerprintWalletLockUI.this.tVw == 1) {
                            bjVar = new bj();
                            bjVar.cVT = 7;
                            bjVar.dcm = 2;
                            bjVar.ajK();
                            AppMethodBeat.o(51516);
                            return;
                        } else if (FingerprintWalletLockUI.this.tVw == 2) {
                            bjVar = new bj();
                            bjVar.cVT = 9;
                            bjVar.dcm = 2;
                            bjVar.ajK();
                            AppMethodBeat.o(51516);
                            return;
                        }
                    }
                    break;
                case 1:
                    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
                    if (cTx() != null) {
                        FingerprintWalletLockUI.a(cTx(), i, FingerprintWalletLockUI.this.getString(R.string.fhb));
                        AppMethodBeat.o(51516);
                        return;
                    }
                    break;
                case 2:
                    if (cTx() != null) {
                        FingerprintWalletLockUI.b(cTx(), i, FingerprintWalletLockUI.this.getString(R.string.fh4));
                        AppMethodBeat.o(51516);
                        return;
                    }
                    break;
                case 3:
                    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", Integer.valueOf(i));
                    if (cTx() != null) {
                        FingerprintWalletLockUI.b(cTx(), i, FingerprintWalletLockUI.this.getString(R.string.fha));
                        break;
                    }
                    break;
                case 4:
                    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
                    AppMethodBeat.o(51516);
                    return;
                case 5:
                    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
                    if (cTx() != null) {
                        FingerprintWalletLockUI.a(cTx(), i, FingerprintWalletLockUI.this.getString(R.string.fhb));
                        AppMethodBeat.o(51516);
                        return;
                    }
                    break;
                case 8:
                    if (cTx() != null) {
                        FingerprintWalletLockUI.b(cTx(), i, FingerprintWalletLockUI.this.getString(R.string.fhk));
                        AppMethodBeat.o(51516);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(51516);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(51535);
        fingerprintWalletLockUI.aDw();
        AppMethodBeat.o(51535);
    }

    static /* synthetic */ void a(FingerprintWalletLockUI fingerprintWalletLockUI, String str) {
        AppMethodBeat.i(51542);
        fingerprintWalletLockUI.bv(4, str);
        AppMethodBeat.o(51542);
    }

    static /* synthetic */ void b(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(51536);
        fingerprintWalletLockUI.cTs();
        AppMethodBeat.o(51536);
    }

    static /* synthetic */ void b(FingerprintWalletLockUI fingerprintWalletLockUI, String str) {
        AppMethodBeat.i(51544);
        fingerprintWalletLockUI.Dv(str);
        AppMethodBeat.o(51544);
    }

    static /* synthetic */ void g(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(51540);
        fingerprintWalletLockUI.HC(1);
        AppMethodBeat.o(51540);
    }

    static /* synthetic */ void h(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(51543);
        fingerprintWalletLockUI.cTu();
        AppMethodBeat.o(51543);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(51517);
        super.onCreate(bundle);
        ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", Long.valueOf(System.currentTimeMillis()));
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
        Intent intent = getIntent();
        this.JU = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        this.tVq = this.JU;
        this.tVp = intent.getStringExtra("next_action");
        this.gtl = intent.getStringExtra("token");
        this.gHr = intent.getStringExtra("key_pay_passwd");
        this.tVw = intent.getIntExtra("scene", -1);
        ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", this.JU, this.tVp);
        if (this.JU.equals("action.verify_pattern")) {
            this.tVv = 2;
            com.tencent.mm.plugin.walletlock.c.h.cUc();
            AppMethodBeat.o(51517);
            return;
        }
        if (this.JU.equals("action.switch_on_pattern")) {
            this.tVv = 1;
        }
        AppMethodBeat.o(51517);
    }

    public void onResume() {
        AppMethodBeat.i(51518);
        super.onResume();
        ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", Boolean.valueOf(this.ozH));
        if (this.ozH) {
            this.tVr = new com.tencent.mm.plugin.walletlock.fingerprint.a.c();
            this.tVs = new h();
            this.isCancelled = false;
            f.dRn().dRo();
            this.kvA = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.un), false, null);
            cTs();
            if (this.JU.equals("action.switch_on_pattern")) {
                this.tVe = false;
            } else {
                this.tVe = true;
            }
            ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.tVe));
            g gVar = g.tWY;
            boolean cTY = g.cTY();
            g gVar2 = g.tWY;
            if (g.cTn() && !cTY) {
                ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", Boolean.valueOf(cTY));
                if (e.cTz()) {
                    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
                    ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).HB(1);
                    gVar = g.tWY;
                    g.cTW();
                    finish();
                    Intent intent = new Intent(this, GestureGuardLogicUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
                    intent.setPackage(ah.getPackageName());
                    if (!com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, false)) {
                        intent.putExtra("verify_title", getString(R.string.fhq));
                        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, Boolean.TRUE);
                        com.tencent.mm.kernel.g.RP().Ry().dsb();
                    }
                    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", Boolean.valueOf(r1));
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.h.pYm.e(12097, Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                } else {
                    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
                    aDw();
                    this.hSs = new com.tencent.mm.ui.widget.a.c.a(this).PZ(R.string.fhl).Qc(R.string.fhp).a(new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(51512);
                            ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
                            ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).b(FingerprintWalletLockUI.this, 1, 4);
                            AppMethodBeat.o(51512);
                        }
                    }).f(new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(51511);
                            ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
                            FingerprintWalletLockUI.this.finish();
                            FingerprintWalletLockUI.cTw();
                            AppMethodBeat.o(51511);
                        }
                    }).aMb();
                    this.hSs.setCanceledOnTouchOutside(false);
                    this.hSs.b(getString(R.string.fgy), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(51499);
                            ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
                            ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).i(FingerprintWalletLockUI.this, 5);
                            AppMethodBeat.o(51499);
                        }
                    });
                    this.hSs.show();
                }
            } else if (com.tencent.soter.core.a.iR(this)) {
                Bundle bundle = new Bundle();
                bundle.putString("key_pay_passwd", this.gHr);
                bundle.putBoolean("key_fp_lock_offline_mode", this.tVe);
                this.tVr.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a() {
                    public final void aC(int i, String str) {
                        AppMethodBeat.i(51507);
                        ab.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", Integer.valueOf(i), str, Long.valueOf(System.currentTimeMillis()));
                        if (FingerprintWalletLockUI.this.isCancelled) {
                            ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
                            AppMethodBeat.o(51507);
                        } else if (i == 0) {
                            FingerprintWalletLockUI.h(FingerprintWalletLockUI.this);
                            AppMethodBeat.o(51507);
                        } else {
                            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(R.string.fh4));
                            AppMethodBeat.o(51507);
                        }
                    }
                }, bundle);
            } else {
                cTt();
            }
            ab.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(51518);
            return;
        }
        AppMethodBeat.o(51518);
    }

    public void onPause() {
        AppMethodBeat.i(51519);
        super.onPause();
        ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
        dismissDialog();
        release();
        this.ozH = true;
        AppMethodBeat.o(51519);
    }

    public final void initView() {
        AppMethodBeat.i(51520);
        super.initView();
        this.tVl = (TextView) findViewById(R.id.bu3);
        this.tVm = (TextView) findViewById(R.id.bu4);
        this.juY = (TextView) findViewById(R.id.bu0);
        this.tVn = (TextView) findViewById(R.id.bu1);
        this.tVm.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(51498);
                FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
                AppMethodBeat.o(51498);
            }
        });
        this.juY.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(51505);
                FingerprintWalletLockUI.cTw();
                FingerprintWalletLockUI.a(FingerprintWalletLockUI.this, "user cancel setting fingerprint lock");
                AppMethodBeat.o(51505);
            }
        });
        this.tVn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(51506);
                FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
                AppMethodBeat.o(51506);
            }
        });
        AppMethodBeat.o(51520);
    }

    private void cTs() {
        AppMethodBeat.i(51521);
        if (this.JU.equals("action.verify_pattern")) {
            this.tVl.setText(R.string.fhd);
            this.tVl.setTextColor(getResources().getColor(R.color.w4));
            this.tVn.setVisibility(0);
            AppMethodBeat.o(51521);
            return;
        }
        this.tVl.setText(R.string.fh7);
        this.tVl.setTextColor(getResources().getColor(R.color.w4));
        this.tVn.setVisibility(8);
        AppMethodBeat.o(51521);
    }

    public final int getLayoutId() {
        return R.layout.zy;
    }

    private void cTt() {
        AppMethodBeat.i(51522);
        aDw();
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
        ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", Integer.valueOf(this.tVv));
        if (this.tVv == 2) {
            aVar.PZ(R.string.fhk).Qc(R.string.fho).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(51509);
                    FingerprintWalletLockUI.i(FingerprintWalletLockUI.this);
                    AppMethodBeat.o(51509);
                }
            }).Qd(R.string.or).b(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(51508);
                    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
                    AppMethodBeat.o(51508);
                }
            });
        } else {
            aVar.PZ(R.string.fhj).asJ(getString(R.string.s6)).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(51510);
                    FingerprintWalletLockUI.this.finish();
                    FingerprintWalletLockUI.cTw();
                    AppMethodBeat.o(51510);
                }
            });
        }
        this.hSs = aVar.aMb();
        this.hSs.setCanceledOnTouchOutside(false);
        this.hSs.show();
        AppMethodBeat.o(51522);
    }

    private void dismissDialog() {
        AppMethodBeat.i(51523);
        aDw();
        if (this.hSs != null && this.hSs.isShowing()) {
            this.hSs.dismiss();
        }
        AppMethodBeat.o(51523);
    }

    public void onBackPressed() {
        AppMethodBeat.i(51524);
        ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
        finish();
        i.tXc.cUg();
        AppMethodBeat.o(51524);
    }

    private void cTu() {
        AppMethodBeat.i(51525);
        ab.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", this.tVq);
        if (bo.isNullOrNil(this.tVq)) {
            finish();
            AppMethodBeat.o(51525);
            return;
        }
        String str = this.tVq;
        boolean z = true;
        switch (str.hashCode()) {
            case -1423990800:
                if (str.equals("next_action.goto_protected_page")) {
                    z = true;
                    break;
                }
                break;
            case -1305462654:
                if (str.equals("action.verify_pattern")) {
                    z = true;
                    break;
                }
                break;
            case -639789777:
                if (str.equals("next_action.switch_on_pattern")) {
                    z = true;
                    break;
                }
                break;
            case 1420518755:
                if (str.equals("action.switch_on_pattern")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
                this.tVt = new a(this);
                this.tVu = "-1";
                if (this.tVs == null) {
                    this.tVs = new h();
                }
                h hVar = this.tVs;
                b bVar = this.tVt;
                com.tencent.soter.a.a.b anonymousClass1 = new com.tencent.mm.plugin.walletlock.fingerprint.a.h.AnonymousClass1(bVar);
                hVar.tVi = new com.tencent.soter.a.a.a();
                com.tencent.soter.a.g.b bVar2 = new com.tencent.soter.a.g.b.a().iW(this).Rk(1).a(hVar.tVi).a(anonymousClass1).aug(g.tWY.tWZ).Rj(3).Awk;
                g.tWY.tXa = null;
                ab.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
                com.tencent.soter.a.a.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.h.AnonymousClass2(bVar), bVar2);
                AppMethodBeat.o(51525);
                return;
            case true:
                j jVar = g.tWY.tXa;
                if (jVar == null) {
                    Dv(getString(R.string.fh9));
                    AppMethodBeat.o(51525);
                    return;
                }
                String str2 = jVar.Avx;
                String str3 = jVar.signature;
                if (this.tVr != null) {
                    this.kvA = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.fhf), false, null);
                    this.tVr.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a() {
                        public final void aC(int i, String str) {
                            AppMethodBeat.i(51503);
                            ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                            if (i == 0) {
                                FingerprintWalletLockUI.k(FingerprintWalletLockUI.this);
                                AppMethodBeat.o(51503);
                                return;
                            }
                            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(R.string.fh5));
                            AppMethodBeat.o(51503);
                        }
                    }, this.gtl, str2, str3);
                }
                AppMethodBeat.o(51525);
                return;
            case true:
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.lK(SystemClock.elapsedRealtime());
                cTv();
                break;
        }
        AppMethodBeat.o(51525);
    }

    private void cTv() {
        AppMethodBeat.i(51526);
        this.ozH = false;
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(51500);
                FingerprintWalletLockUI.this.finish();
                AppMethodBeat.o(51500);
            }
        }, 200);
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
            i.tXc.nB(true);
            i.tXc.nC(true);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            startActivity(intent);
            overridePendingTransition(R.anim.db, R.anim.dg);
            AppMethodBeat.o(51526);
            return;
        }
        ab.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
        AppMethodBeat.o(51526);
    }

    private void HC(int i) {
        AppMethodBeat.i(51527);
        Intent intent = new Intent();
        if (i == 1) {
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.touchlock_verify_by_paypwd");
        } else if (i == 2) {
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.touchlock_need_verify_paypwd");
            intent.putExtra("key_wallet_lock_input_new_fp_tips", getString(R.string.fhi));
        }
        intent.putExtra("key_wallet_lock_type", 2);
        com.tencent.mm.bp.d.b((Context) this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i);
        AppMethodBeat.o(51527);
    }

    private void aDw() {
        AppMethodBeat.i(51528);
        if (this.kvA != null && this.kvA.isShowing()) {
            this.kvA.dismiss();
        }
        AppMethodBeat.o(51528);
    }

    private void JN(String str) {
        AppMethodBeat.i(51529);
        if (bo.isNullOrNil(str)) {
            str = getString(R.string.fhc);
        }
        dismissDialog();
        this.hSs = com.tencent.mm.ui.base.h.a((Context) this, str, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(51501);
                FingerprintWalletLockUI.this.finish();
                AppMethodBeat.o(51501);
            }
        });
        this.hSs.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(51529);
    }

    private void Dv(String str) {
        AppMethodBeat.i(51530);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - this.msy > 1) {
            this.msy = currentTimeMillis;
            dismissDialog();
            if (this.tVl != null) {
                this.tVl.setText(str);
                this.tVl.setTextColor(getResources().getColor(R.color.xy));
                this.tVl.setVisibility(4);
                if (this.tVo == null) {
                    this.tVo = AnimationUtils.loadAnimation(this.mController.ylL, R.anim.b8);
                }
                this.tVl.startAnimation(this.tVo);
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(51502);
                        FingerprintWalletLockUI.this.tVl.setVisibility(0);
                        AppMethodBeat.o(51502);
                    }
                }, this.tVo.getDuration());
            }
            AppMethodBeat.o(51530);
            return;
        }
        AppMethodBeat.o(51530);
    }

    private void release() {
        AppMethodBeat.i(51531);
        ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", Boolean.valueOf(this.isCancelled));
        if (this.isCancelled) {
            AppMethodBeat.o(51531);
            return;
        }
        this.isCancelled = true;
        if (this.tVs != null) {
            this.tVs.release();
        }
        if (this.tVr != null) {
            this.tVr.release();
        }
        f.dRn().dRo();
        AppMethodBeat.o(51531);
    }

    private void bv(int i, String str) {
        AppMethodBeat.i(51532);
        ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", Integer.valueOf(-1), Integer.valueOf(i), str);
        release();
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        intent.putExtra("key_err_msg", str);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(51532);
    }

    public void finish() {
        AppMethodBeat.i(51533);
        super.finish();
        release();
        AppMethodBeat.o(51533);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(51534);
        ab.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            ab.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
            AppMethodBeat.o(51534);
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", -1);
        ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", Integer.valueOf(intExtra));
        if (i == 1) {
            if (intExtra == 0) {
                cTv();
                com.tencent.mm.plugin.walletlock.c.h.cUa();
                AppMethodBeat.o(51534);
                return;
            } else if (intExtra == -1) {
                this.ozH = false;
                JN(getString(R.string.fhs));
                AppMethodBeat.o(51534);
                return;
            }
        } else if (i == 2) {
            if (intExtra == 0) {
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.ado(this.tVu);
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.lK(SystemClock.elapsedRealtime());
                cTv();
                AppMethodBeat.o(51534);
                return;
            } else if (intExtra == -1) {
                this.ozH = false;
                JN(getString(R.string.fhs));
                AppMethodBeat.o(51534);
                return;
            }
        } else if (i == 3) {
            if (intExtra == 0) {
                cTv();
                AppMethodBeat.o(51534);
                return;
            }
            finish();
            i.tXc.cUg();
            AppMethodBeat.o(51534);
            return;
        } else if (i == 4) {
            if (intExtra == 0) {
                cTv();
                AppMethodBeat.o(51534);
                return;
            } else if (intExtra == -1) {
                this.ozH = false;
                JN(getString(R.string.fhg));
                AppMethodBeat.o(51534);
                return;
            } else {
                finish();
                i.tXc.cUg();
                AppMethodBeat.o(51534);
                return;
            }
        } else if (i == 5) {
            if (intExtra == 0) {
                ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).HB(0);
                g gVar = g.tWY;
                g.cTq();
                Toast.makeText(this, getString(R.string.fgz), 0).show();
                cTv();
                AppMethodBeat.o(51534);
                return;
            } else if (intExtra == -1) {
                this.ozH = false;
                JN(getString(R.string.fh0));
                AppMethodBeat.o(51534);
                return;
            } else if (intExtra == 4) {
                finish();
                i.tXc.cUg();
            }
        }
        AppMethodBeat.o(51534);
    }

    static /* synthetic */ void f(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(51537);
        com.tencent.mm.plugin.walletlock.c.h.am(fingerprintWalletLockUI.tVw, 2, 0);
        j jVar = g.tWY.tXa;
        if (jVar != null) {
            fingerprintWalletLockUI.tVu = jVar.Avq;
            ab.v("MicroMsg.FingerprintWalletLockUI", "alvinluo authSuccess and mFid: %s", fingerprintWalletLockUI.tVu);
            if (fingerprintWalletLockUI.tVq.equals("action.switch_on_pattern")) {
                fingerprintWalletLockUI.tVq = fingerprintWalletLockUI.tVp;
                fingerprintWalletLockUI.cTu();
                AppMethodBeat.o(51537);
                return;
            } else if (fingerprintWalletLockUI.tVq.equals("action.verify_pattern")) {
                if (com.tencent.mm.plugin.walletlock.fingerprint.a.a.adp(fingerprintWalletLockUI.tVu)) {
                    fingerprintWalletLockUI.tVq = fingerprintWalletLockUI.tVp;
                    fingerprintWalletLockUI.cTu();
                    AppMethodBeat.o(51537);
                    return;
                }
                fingerprintWalletLockUI.HC(2);
            }
        }
        AppMethodBeat.o(51537);
    }

    static /* synthetic */ void a(FingerprintWalletLockUI fingerprintWalletLockUI, int i, String str) {
        AppMethodBeat.i(51538);
        ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenFailed errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        com.tencent.mm.plugin.walletlock.c.h.am(fingerprintWalletLockUI.tVw, 2, 1);
        fingerprintWalletLockUI.Dv(str);
        AppMethodBeat.o(51538);
    }

    static /* synthetic */ void b(FingerprintWalletLockUI fingerprintWalletLockUI, int i, String str) {
        AppMethodBeat.i(51539);
        ab.e("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenError errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.cTq();
        fingerprintWalletLockUI.dismissDialog();
        if (i == 3) {
            com.tencent.mm.plugin.walletlock.c.h.am(fingerprintWalletLockUI.tVw, 2, 2);
            com.tencent.mm.plugin.walletlock.fingerprint.a.a.ac(System.currentTimeMillis(), 0);
            fingerprintWalletLockUI.tVl.setText(R.string.fha);
            fingerprintWalletLockUI.tVl.setTextColor(fingerprintWalletLockUI.getResources().getColor(R.color.xy));
            AppMethodBeat.o(51539);
        } else if (i == 8) {
            fingerprintWalletLockUI.cTt();
            AppMethodBeat.o(51539);
        } else {
            fingerprintWalletLockUI.Dv(str);
            AppMethodBeat.o(51539);
        }
    }

    static /* synthetic */ void cTw() {
        AppMethodBeat.i(51541);
        i.tXc.cUg();
        AppMethodBeat.o(51541);
    }

    static /* synthetic */ void i(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(51545);
        Intent intent = new Intent();
        intent.putExtra("key_wallet_lock_setting_scene", 1);
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).b((Activity) fingerprintWalletLockUI, intent, 3);
        AppMethodBeat.o(51545);
    }

    static /* synthetic */ void k(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(51546);
        fingerprintWalletLockUI.dismissDialog();
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(51504);
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.cTm();
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.ado(FingerprintWalletLockUI.this.tVu);
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.lK(-1);
                g gVar = g.tWY;
                g.cTW();
                AppMethodBeat.o(51504);
            }
        });
        Toast.makeText(fingerprintWalletLockUI, R.string.fh6, 0).show();
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).HB(2);
        i.tXc.cUf();
        fingerprintWalletLockUI.bv(0, "open fingerprint lock ok");
        AppMethodBeat.o(51546);
    }
}
