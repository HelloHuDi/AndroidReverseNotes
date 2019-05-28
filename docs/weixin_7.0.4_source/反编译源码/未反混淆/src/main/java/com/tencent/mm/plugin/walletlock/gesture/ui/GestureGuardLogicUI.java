package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.walletlock.c.h;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.a.g;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI extends MMActivity implements OnClickListener, com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a {
    private String gtl = null;
    private ak mHandler = new ak(Looper.getMainLooper());
    private int mStatus;
    private int tVF = 0;
    private int tVG = 0;
    private int tVH = 0;
    private a[] tVI = null;
    private Animation tVJ = null;
    private List<f> tVK = null;
    private List<f> tVL = null;
    private boolean tVM = false;
    private int tVN = 0;
    private m tVO = null;
    private m tVP = null;
    private String tVQ = null;
    private ViewFlipper tVR = null;
    private Dialog tVS = null;
    private boolean tVT = true;
    private boolean tVU = false;
    private String tVV;
    private int tVw = -1;

    interface a {
        void onDone();
    }

    public GestureGuardLogicUI() {
        AppMethodBeat.i(51614);
        AppMethodBeat.o(51614);
    }

    static /* synthetic */ void a(GestureGuardLogicUI gestureGuardLogicUI, int i, int i2, String str) {
        AppMethodBeat.i(51641);
        gestureGuardLogicUI.w(i, i2, str);
        AppMethodBeat.o(51641);
    }

    static /* synthetic */ void e(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(51642);
        gestureGuardLogicUI.cTL();
        AppMethodBeat.o(51642);
    }

    static /* synthetic */ void g(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(51643);
        gestureGuardLogicUI.aq(1, true);
        AppMethodBeat.o(51643);
    }

    static /* synthetic */ void h(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(51644);
        gestureGuardLogicUI.cTK();
        AppMethodBeat.o(51644);
    }

    static /* synthetic */ int k(GestureGuardLogicUI gestureGuardLogicUI) {
        int i = gestureGuardLogicUI.tVN + 1;
        gestureGuardLogicUI.tVN = i;
        return i;
    }

    static /* synthetic */ void o(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(51645);
        gestureGuardLogicUI.aDw();
        AppMethodBeat.o(51645);
    }

    static /* synthetic */ void t(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(51647);
        gestureGuardLogicUI.cTM();
        AppMethodBeat.o(51647);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.i(51615);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!ah.getPackageName().equals(intent.getPackage()) || bo.isNullOrNil(intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION)) || bo.isNullOrNil(intent.getStringExtra("next_action"))) {
            ab.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
            finish();
            AppMethodBeat.o(51615);
            return;
        }
        this.tVR = new ViewFlipper(this);
        this.tVI = new a[]{new a(this), new a(this), new a(this)};
        a[] aVarArr = this.tVI;
        int length = aVarArr.length;
        while (i < length) {
            a aVar = aVarArr[i];
            this.tVR.addView(aVar.mView);
            aVar.tWe.setOnPatternListener(this);
            aVar.tWf.setOnClickListener(this);
            i++;
        }
        setContentView((View) this.tVR);
        this.gtl = getIntent().getStringExtra("token");
        this.tVQ = getIntent().getStringExtra("type");
        this.tVV = getIntent().getStringExtra("verify_title");
        this.tVw = getIntent().getIntExtra("scene", -1);
        if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            h.cUc();
        }
        initView();
        AppMethodBeat.o(51615);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* JADX WARNING: Missing block: B:9:0x003b, code skipped:
            if (r7.tVN == -1) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        AppMethodBeat.i(51616);
        super.onResume();
        if (this.mStatus == 0) {
            int i;
            g cTD = d.cTD();
            if (cTD.tVD != -1) {
                e.a(cTD);
                if (cTD.tVE / 1000 < 600) {
                    d.ad(cTD.tVD, cTD.tVE);
                    i = 1;
                    if (i != 0) {
                        this.tVN = d.cTH();
                    }
                    this.tVN = 0;
                } else {
                    d.cTE();
                }
            }
            i = 0;
            if (i != 0) {
            }
            this.tVN = 0;
        }
        AppMethodBeat.o(51616);
    }

    public void onDestroy() {
        AppMethodBeat.i(51617);
        super.onDestroy();
        if (this.tVO != null) {
            com.tencent.mm.kernel.g.Rg().c(this.tVO);
            this.tVO = null;
        }
        if (this.tVP != null) {
            com.tencent.mm.kernel.g.Rg().c(this.tVP);
            this.tVP = null;
        }
        if (this.tVS != null && this.tVS.isShowing()) {
            this.tVS.dismiss();
        }
        if (this.tVR != null) {
            this.tVR.removeAllViews();
            this.tVR = null;
        }
        for (int i = 0; i < this.tVI.length; i++) {
            a aVar = this.tVI[i];
            aVar.tWe.setOnClickListener(null);
            aVar.tWf.setOnClickListener(null);
            aVar.mView = null;
            aVar.tWc = null;
            aVar.tWd = null;
            aVar.tWe = null;
            aVar.tWf = null;
            this.tVI[i] = null;
        }
        this.tVI = null;
        AppMethodBeat.o(51617);
    }

    public final void initView() {
        AppMethodBeat.i(51618);
        aqX();
        setMMSubTitle((int) R.string.g0d);
        this.tVJ = AnimationUtils.loadAnimation(this, R.anim.cz);
        this.tVF = getResources().getColor(R.color.r5);
        this.tVG = getResources().getColor(R.color.r6);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        intent.getStringExtra("next_action");
        if ("action.switch_on_pattern".equals(stringExtra)) {
            this.mStatus = 16;
            aq(1, false);
        } else if ("action.verify_pattern".equals(stringExtra)) {
            if (b.cTA()) {
                this.tVM = true;
                this.mStatus = 20;
            } else {
                this.tVM = false;
                this.mStatus = 0;
            }
            aq(0, false);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(51586);
                if (GestureGuardLogicUI.a(GestureGuardLogicUI.this)) {
                    AppMethodBeat.o(51586);
                } else {
                    GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
                    AppMethodBeat.o(51586);
                }
                return true;
            }
        });
        ab.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[]{Integer.valueOf(this.mStatus)}));
        cTK();
        AppMethodBeat.o(51618);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(51619);
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (intent == null) {
                ab.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
                AppMethodBeat.o(51619);
                return;
            }
            int intExtra = intent.getIntExtra("key_err_code", 0);
            if (intExtra == 0) {
                this.gtl = intent.getStringExtra("key_token");
                this.tVQ = intent.getStringExtra("key_type");
                String stringExtra = getIntent().getStringExtra("next_action");
                if ("next_action.goto_protected_page".equals(stringExtra) || "next_action.modify_pattern".equals(stringExtra)) {
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        this.tVU = true;
                    }
                    this.tVT = false;
                    setBackBtn(null);
                    pP(false);
                    this.mStatus = 16;
                    aq(1, false);
                } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                    String str = this.gtl;
                    final AnonymousClass12 anonymousClass12 = new com.tencent.mm.ai.w.a() {
                        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                            AppMethodBeat.i(51597);
                            if (i2 == 0) {
                                d.cTI();
                                d.cTC();
                                d.cTE();
                                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c9j), 0).show();
                            } else {
                                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c92), 0).show();
                            }
                            GestureGuardLogicUI.this.gtl = null;
                            GestureGuardLogicUI.this.tVQ = null;
                            GestureGuardLogicUI.this.finish();
                            AppMethodBeat.o(51597);
                            return 0;
                        }
                    };
                    c(new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(51598);
                            GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWe.cTT();
                            if (!(GestureGuardLogicUI.this.tVO == null || GestureGuardLogicUI.this.tVO.bqV)) {
                                com.tencent.mm.kernel.g.Rg().c(GestureGuardLogicUI.this.tVO);
                            }
                            AppMethodBeat.o(51598);
                        }
                    });
                    if (str == null) {
                        aDw();
                        anonymousClass12.a(3, -6, getString(R.string.c94), null, null);
                    } else {
                        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                        aVar.fsJ = new bqz();
                        aVar.fsK = new bra();
                        aVar.fsI = 688;
                        aVar.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
                        com.tencent.mm.ai.b acD = aVar.acD();
                        bqz bqz = (bqz) acD.fsG.fsP;
                        bqz.wTq = new SKBuiltinBuffer_t().setBuffer(str.getBytes());
                        bqz.Cn = 3;
                        w.a(acD, new com.tencent.mm.ai.w.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                                AppMethodBeat.i(51599);
                                ab.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                                if (i == 0 && i2 == 0) {
                                    d.a(((bra) bVar.fsH.fsP).wJw);
                                    com.tencent.mm.plugin.walletlock.c.g gVar = com.tencent.mm.plugin.walletlock.c.g.tWY;
                                    com.tencent.mm.plugin.walletlock.c.g.nx(false);
                                    GestureGuardLogicUI.cTQ();
                                }
                                i.tXc.cUf();
                                if (anonymousClass12 != null) {
                                    int a = anonymousClass12.a(i, i2, str, bVar, mVar);
                                    AppMethodBeat.o(51599);
                                    return a;
                                }
                                AppMethodBeat.o(51599);
                                return 0;
                            }
                        }, false);
                    }
                } else {
                    this.mStatus = 1;
                }
                cTK();
                AppMethodBeat.o(51619);
                return;
            } else if (intExtra == -1) {
                Toast.makeText(this, getString(R.string.c92), 0).show();
            }
        }
        AppMethodBeat.o(51619);
    }

    public void onClick(View view) {
        AppMethodBeat.i(51620);
        if (view.getId() == R.id.cir) {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("key_wallet_lock_type", 1);
            com.tencent.mm.bp.d.b((Context) this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, 1001);
        }
        AppMethodBeat.o(51620);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(51621);
        if (i != 4) {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.o(51621);
            return onKeyDown;
        } else if (cTJ()) {
            AppMethodBeat.o(51621);
            return false;
        } else {
            w(0, 4, "user cancel when setting gesture");
            AppMethodBeat.o(51621);
            return false;
        }
    }

    private void w(int i, int i2, String str) {
        AppMethodBeat.i(51622);
        ab.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        setResult(i, intent);
        finish();
        AppMethodBeat.o(51622);
    }

    private boolean cTJ() {
        AppMethodBeat.i(51623);
        if (this.mStatus == 20 || this.mStatus == 0 || this.mStatus == 2 || this.mStatus == 1) {
            cTM();
            AppMethodBeat.o(51623);
            return false;
        }
        if (this.tVT) {
            cTP();
        } else {
            cTO();
        }
        AppMethodBeat.o(51623);
        return true;
    }

    private void cTK() {
        AppMethodBeat.i(51624);
        while (true) {
            final a aVar = this.tVI[this.tVH];
            String stringExtra;
            long elapsedRealtime;
            bj bjVar;
            switch (this.mStatus) {
                case 0:
                    setMMTitle(getString(R.string.c9f));
                    this.tVM = false;
                    aVar.tWe.setEnableInput(true);
                    aVar.tWe.setOnPatternListener(this);
                    if (!"next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        aVar.tWc.setText(getString(R.string.c9d));
                    } else if (bo.isNullOrNil(this.tVV)) {
                        aVar.tWc.setText(getString(R.string.c9e));
                    } else {
                        aVar.tWc.setText(this.tVV);
                    }
                    aVar.tWc.setTextColor(this.tVF);
                    if (aVar.tWf.getVisibility() != 0) {
                        aVar.tWf.setVisibility(0);
                        AppMethodBeat.o(51624);
                        return;
                    }
                    break;
                case 1:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        aVar.tWe.cTT();
                        aq(1, true);
                        this.mStatus = 16;
                    } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                        a(this.tVL, new com.tencent.mm.ai.w.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                                AppMethodBeat.i(51612);
                                if (i2 == 0) {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c9j), 0).show();
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c92), 0).show();
                                }
                                GestureGuardLogicUI.this.tVL = null;
                                GestureGuardLogicUI.this.finish();
                                AppMethodBeat.o(51612);
                                return 0;
                            }
                        });
                        AppMethodBeat.o(51624);
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra)) {
                        d.lK(SystemClock.elapsedRealtime());
                        cTL();
                        h.am(this.tVw, 1, 0);
                        AppMethodBeat.o(51624);
                        return;
                    }
                    break;
                case 2:
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    d.ad(elapsedRealtime, 0);
                    d.HD(this.tVN);
                    d.cTq();
                    if (this.tVN == 5) {
                        this.tVM = true;
                        d.ac(elapsedRealtime, 0);
                        aVar.tWe.cTT();
                        aVar.tWe.setEnableInput(false);
                        this.mStatus = 20;
                        cTK();
                        cTN();
                    } else {
                        aVar.tWe.setEnableInput(false);
                        aVar.tWe.setDisplayMode(PatternLockView.b.Wrong);
                        a(String.format(getResources().getString(R.string.c95), new Object[]{Integer.valueOf(5 - this.tVN)}), new a() {
                            public final void onDone() {
                                AppMethodBeat.i(51613);
                                GestureGuardLogicUI.this.mStatus = 0;
                                aVar.tWe.cTT();
                                aVar.tWe.setEnableInput(true);
                                AppMethodBeat.o(51613);
                            }
                        });
                    }
                    ab.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", getIntent().getStringExtra("next_action"));
                    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        if (this.tVN != 5) {
                            h.am(this.tVw, 1, 1);
                            break;
                        }
                        h.am(this.tVw, 1, 2);
                        AppMethodBeat.o(51624);
                        return;
                    }
                    break;
                case 16:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        setMMTitle(getString(R.string.c9g));
                        bjVar = new bj();
                        bjVar.cVT = 5;
                        bjVar.dcm = 1;
                        bjVar.ajK();
                    } else if ("next_action.switch_on_pattern".equals(stringExtra)) {
                        setMMTitle(getString(R.string.c9h));
                        bjVar = new bj();
                        bjVar.cVT = 4;
                        bjVar.dcm = 1;
                        bjVar.ajK();
                    } else {
                        setMMTitle(getString(R.string.c9g));
                        bjVar = new bj();
                        bjVar.cVT = 5;
                        bjVar.dcm = 1;
                        bjVar.ajK();
                    }
                    this.tVM = false;
                    aVar.tWe.setEnableInput(true);
                    aVar.tWe.setOnPatternListener(this);
                    aVar.tWc.setText(getString(R.string.c9c));
                    aVar.tWc.setTextColor(getResources().getColor(R.color.r5));
                    if (aVar.tWf.getVisibility() != 8) {
                        aVar.tWf.setVisibility(8);
                        AppMethodBeat.o(51624);
                        return;
                    }
                    break;
                case 17:
                    aVar.tWc.setText(getResources().getString(R.string.c9a));
                    aVar.tWc.setTextColor(this.tVF);
                    aVar.tWe.cTT();
                    aVar.tWe.setEnableInput(true);
                    if (aVar.tWf.getVisibility() != 8) {
                        aVar.tWf.setVisibility(8);
                        AppMethodBeat.o(51624);
                        return;
                    }
                    break;
                case 18:
                    String stringExtra2 = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra2)) {
                        if (this.tVU) {
                            this.tVU = false;
                            a(this.gtl, this.tVK, new com.tencent.mm.ai.w.a() {
                                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                                    AppMethodBeat.i(51606);
                                    if (i2 == 0) {
                                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c9l), 0).show();
                                        com.tencent.mm.plugin.report.service.h.pYm.e(11474, new Object[0]);
                                    } else {
                                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c92), 0).show();
                                    }
                                    GestureGuardLogicUI.this.gtl = null;
                                    GestureGuardLogicUI.this.tVK = null;
                                    GestureGuardLogicUI.this.finish();
                                    AppMethodBeat.o(51606);
                                    return 0;
                                }
                            });
                            AppMethodBeat.o(51624);
                            return;
                        }
                        a(this.tVL, this.tVK, new com.tencent.mm.ai.w.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                                AppMethodBeat.i(51607);
                                if (i2 == 0) {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c9l), 0).show();
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c92), 0).show();
                                }
                                GestureGuardLogicUI.this.tVL = null;
                                GestureGuardLogicUI.this.tVK = null;
                                GestureGuardLogicUI.this.finish();
                                AppMethodBeat.o(51607);
                                return 0;
                            }
                        });
                        AppMethodBeat.o(51624);
                        return;
                    } else if ("next_action.switch_on_pattern".equals(stringExtra2)) {
                        a(this.gtl, this.tVK, new com.tencent.mm.ai.w.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                                AppMethodBeat.i(51608);
                                GestureGuardLogicUI.this.gtl = null;
                                GestureGuardLogicUI.this.tVK = null;
                                if (i2 == 0) {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c9k), 0).show();
                                    GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, 0, "open gesture ok");
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c92), 0).show();
                                    GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, -1, "open gesture failed");
                                }
                                AppMethodBeat.o(51608);
                                return 0;
                            }
                        });
                        AppMethodBeat.o(51624);
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra2)) {
                        a(this.gtl, this.tVK, new com.tencent.mm.ai.w.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                                AppMethodBeat.i(51609);
                                if (i2 == 0) {
                                    d.lK(SystemClock.elapsedRealtime());
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c9l), 0).show();
                                    GestureGuardLogicUI.e(GestureGuardLogicUI.this);
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c92), 0).show();
                                }
                                GestureGuardLogicUI.this.gtl = null;
                                GestureGuardLogicUI.this.tVK = null;
                                AppMethodBeat.o(51609);
                                return 0;
                            }
                        });
                        AppMethodBeat.o(51624);
                        return;
                    }
                    break;
                case 19:
                    aVar.tWe.setEnableInput(false);
                    aVar.tWe.setDisplayMode(PatternLockView.b.Wrong);
                    a(getResources().getString(R.string.c9b), new a() {
                        public final void onDone() {
                            AppMethodBeat.i(51611);
                            GestureGuardLogicUI.this.mHandler.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(51610);
                                    GestureGuardLogicUI.this.mHandler.removeCallbacks(this);
                                    aVar.tWe.cTT();
                                    GestureGuardLogicUI.this.mStatus = 16;
                                    GestureGuardLogicUI.g(GestureGuardLogicUI.this);
                                    GestureGuardLogicUI.h(GestureGuardLogicUI.this);
                                    AppMethodBeat.o(51610);
                                }
                            }, 500);
                            AppMethodBeat.o(51611);
                        }
                    });
                    AppMethodBeat.o(51624);
                    return;
                case 20:
                    setMMTitle(getString(R.string.c9f));
                    setMMTitle(getString(R.string.c9g));
                    if (this.tVw == 1) {
                        bjVar = new bj();
                        bjVar.cVT = 8;
                        bjVar.dcm = 1;
                        bjVar.ajK();
                    } else if (this.tVw == 2) {
                        bjVar = new bj();
                        bjVar.cVT = 10;
                        bjVar.dcm = 1;
                        bjVar.ajK();
                    }
                    this.tVM = true;
                    aVar.tWe.setEnableInput(false);
                    aVar.tWe.setOnPatternListener(null);
                    elapsedRealtime = (long) Math.ceil(((double) (600 - (d.cTB().tVE / 1000))) / 60.0d);
                    aVar.tWc.setText(String.format(getString(R.string.c99), new Object[]{Long.valueOf(elapsedRealtime)}));
                    aVar.tWc.setTextColor(getResources().getColor(R.color.r6));
                    AppMethodBeat.o(51624);
                    return;
                default:
                    break;
            }
        }
        AppMethodBeat.o(51624);
    }

    public final void a(final PatternLockView patternLockView, final List<f> list) {
        int i = 1;
        AppMethodBeat.i(51625);
        if (this.mStatus == 16) {
            if (list.size() < 4) {
                patternLockView.setEnableInput(false);
                patternLockView.setDisplayMode(PatternLockView.b.Wrong);
                a(String.format(getString(R.string.c96), new Object[]{Integer.valueOf(4)}), new a() {
                    public final void onDone() {
                        AppMethodBeat.i(51587);
                        patternLockView.cTT();
                        patternLockView.setEnableInput(true);
                        AppMethodBeat.o(51587);
                    }
                });
                AppMethodBeat.o(51625);
                return;
            }
            this.tVK = list;
            patternLockView.cTT();
            this.mStatus = 17;
            aq(2, true);
        } else if (this.mStatus == 0) {
            final AnonymousClass3 anonymousClass3 = new com.tencent.mm.ai.w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(51588);
                    if (i2 == 0) {
                        GestureGuardLogicUI.this.tVM = false;
                        GestureGuardLogicUI.this.tVN = 0;
                        d.cTI();
                        d.cTC();
                        d.cTE();
                        GestureGuardLogicUI.this.tVL = list;
                        GestureGuardLogicUI.this.mStatus = 1;
                        GestureGuardLogicUI.h(GestureGuardLogicUI.this);
                    } else if (i2 == -3) {
                        GestureGuardLogicUI.k(GestureGuardLogicUI.this);
                        GestureGuardLogicUI.this.mStatus = 2;
                        GestureGuardLogicUI.h(GestureGuardLogicUI.this);
                    } else {
                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.c93), 0).show();
                    }
                    AppMethodBeat.o(51588);
                    return 0;
                }
            };
            bim cTG = d.cTG();
            bil cTF = d.cTF();
            com.tencent.mm.plugin.report.service.h.pYm.e(11453, new Object[0]);
            c(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(51591);
                    GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWe.cTT();
                    if (!(GestureGuardLogicUI.this.tVP == null || GestureGuardLogicUI.this.tVP.bqV)) {
                        com.tencent.mm.kernel.g.Rg().c(GestureGuardLogicUI.this.tVP);
                    }
                    AppMethodBeat.o(51591);
                }
            });
            boolean z = e.b(cTF) ? e.b(cTG) ? cTF.version < cTG.wLR : false : true;
            ab.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[]{Boolean.valueOf(e.b(cTG)), Boolean.valueOf(e.b(cTF)), Boolean.valueOf(z)}));
            if (z) {
                com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                aVar.fsJ = new bfo();
                aVar.fsK = new bfp();
                aVar.fsI = 689;
                aVar.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                com.tencent.mm.ai.b acD = aVar.acD();
                bfo bfo = (bfo) acD.fsG.fsP;
                bfo.Cn = 2;
                bfo.wJu = new SKBuiltinBuffer_t().setBuffer(e.dX(list));
                w.a(acD, new com.tencent.mm.ai.w.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                        AppMethodBeat.i(51592);
                        ab.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                        if (i == 0 && i2 == 0) {
                            d.a(((bfp) bVar.fsH.fsP).wJw);
                            bj bjVar;
                            if (GestureGuardLogicUI.this.mStatus != 0) {
                                String stringExtra = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                                if ("next_action.modify_pattern".equals(stringExtra)) {
                                    bjVar = new bj();
                                    bjVar.cVT = 5;
                                    bjVar.dcm = 2;
                                    bjVar.ajK();
                                } else if ("next_action.switch_on_pattern".equals(stringExtra)) {
                                    bjVar = new bj();
                                    bjVar.cVT = 4;
                                    bjVar.dcm = 2;
                                    bjVar.ajK();
                                } else {
                                    bjVar = new bj();
                                    bjVar.cVT = 5;
                                    bjVar.dcm = 2;
                                    bjVar.ajK();
                                }
                            } else if (GestureGuardLogicUI.this.tVw == 1) {
                                bjVar = new bj();
                                bjVar.cVT = 8;
                                bjVar.dcm = 2;
                                bjVar.ajK();
                            } else if (GestureGuardLogicUI.this.tVw == 2) {
                                bjVar = new bj();
                                bjVar.cVT = 10;
                                bjVar.dcm = 2;
                                bjVar.ajK();
                            }
                        }
                        if (anonymousClass3 != null) {
                            int a = anonymousClass3.a(i, i2, str, bVar, mVar);
                            AppMethodBeat.o(51592);
                            return a;
                        }
                        AppMethodBeat.o(51592);
                        return 0;
                    }
                }, false);
                AppMethodBeat.o(51625);
                return;
            }
            aDw();
            bil cTF2 = d.cTF();
            if (cTF2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.RN();
                stringBuilder.append(new p(com.tencent.mm.kernel.a.QF()).longValue());
                stringBuilder.append('_');
                stringBuilder.append(new String(e.dX(list)));
                i = new String(cTF2.wLO.getBufferToBytes()).equals(com.tencent.mm.a.g.x(stringBuilder.toString().getBytes()));
            }
            if (i != 0) {
                anonymousClass3.a(3, 0, null, null, null);
                AppMethodBeat.o(51625);
                return;
            }
            anonymousClass3.a(3, -3, null, null, null);
            AppMethodBeat.o(51625);
            return;
        } else {
            if (this.mStatus == 17) {
                if (this.tVK.equals(list)) {
                    patternLockView.cTT();
                    this.tVM = false;
                    this.tVN = 0;
                    d.cTI();
                    d.cTC();
                    d.cTE();
                    d.cTq();
                    this.mStatus = 18;
                } else {
                    this.mStatus = 19;
                }
            }
            AppMethodBeat.o(51625);
        }
        cTK();
        AppMethodBeat.o(51625);
    }

    private void a(String str, List<f> list, final com.tencent.mm.ai.w.a aVar) {
        AppMethodBeat.i(51626);
        c(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(51589);
                GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWe.cTT();
                if (!(GestureGuardLogicUI.this.tVO == null || GestureGuardLogicUI.this.tVO.bqV)) {
                    com.tencent.mm.kernel.g.Rg().c(GestureGuardLogicUI.this.tVO);
                }
                AppMethodBeat.o(51589);
            }
        });
        if (str == null) {
            aDw();
            aVar.a(3, -6, getString(R.string.c94), null, null);
            AppMethodBeat.o(51626);
            return;
        }
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new bqz();
        aVar2.fsK = new bra();
        aVar2.fsI = 688;
        aVar2.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
        com.tencent.mm.ai.b acD = aVar2.acD();
        bqz bqz = (bqz) acD.fsG.fsP;
        bqz.wTq = new SKBuiltinBuffer_t().setBuffer(str.getBytes());
        bqz.wTr = new SKBuiltinBuffer_t().setBuffer(e.dX(list));
        w.a(acD, new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(51590);
                ab.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                if (i == 0 && i2 == 0) {
                    d.a(((bra) bVar.fsH.fsP).wJw);
                    GestureGuardLogicUI.cTQ();
                    ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.walletlock.a.b.class)).HB(1);
                }
                i.tXc.cUf();
                if (aVar != null) {
                    int a = aVar.a(i, i2, str, bVar, mVar);
                    AppMethodBeat.o(51590);
                    return a;
                }
                AppMethodBeat.o(51590);
                return 0;
            }
        }, false);
        AppMethodBeat.o(51626);
    }

    private void a(List<f> list, List<f> list2, final com.tencent.mm.ai.w.a aVar) {
        AppMethodBeat.i(51627);
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        c(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(51593);
                GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWe.cTT();
                if (!(GestureGuardLogicUI.this.tVP == null || GestureGuardLogicUI.this.tVP.bqV)) {
                    com.tencent.mm.kernel.g.Rg().c(GestureGuardLogicUI.this.tVP);
                }
                AppMethodBeat.o(51593);
            }
        });
        aVar2.fsJ = new bfo();
        aVar2.fsK = new bfp();
        aVar2.fsI = 689;
        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
        com.tencent.mm.ai.b acD = aVar2.acD();
        bfo bfo = (bfo) acD.fsG.fsP;
        bfo.Cn = 1;
        bfo.wJu = new SKBuiltinBuffer_t().setBuffer(e.dX(list));
        bfo.wJv = new SKBuiltinBuffer_t().setBuffer(e.dX(list2));
        w.a(acD, new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(51594);
                ab.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                if (i == 0 && i2 == 0) {
                    d.a(((bfp) bVar.fsH.fsP).wJw);
                    GestureGuardLogicUI.cTQ();
                    bj bjVar;
                    if (GestureGuardLogicUI.this.mStatus != 0) {
                        String stringExtra = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                        if ("next_action.modify_pattern".equals(stringExtra)) {
                            bjVar = new bj();
                            bjVar.cVT = 5;
                            bjVar.dcm = 2;
                            bjVar.ajK();
                        } else if ("next_action.switch_on_pattern".equals(stringExtra)) {
                            bjVar = new bj();
                            bjVar.cVT = 4;
                            bjVar.dcm = 2;
                            bjVar.ajK();
                        } else {
                            bjVar = new bj();
                            bjVar.cVT = 5;
                            bjVar.dcm = 2;
                            bjVar.ajK();
                        }
                    } else if (GestureGuardLogicUI.this.tVw == 1) {
                        bjVar = new bj();
                        bjVar.cVT = 8;
                        bjVar.dcm = 2;
                        bjVar.ajK();
                    } else if (GestureGuardLogicUI.this.tVw == 2) {
                        bjVar = new bj();
                        bjVar.cVT = 10;
                        bjVar.dcm = 2;
                        bjVar.ajK();
                    }
                }
                i.tXc.cUf();
                if (aVar != null) {
                    int a = aVar.a(i, i2, str, bVar, mVar);
                    AppMethodBeat.o(51594);
                    return a;
                }
                AppMethodBeat.o(51594);
                return 0;
            }
        }, false);
        AppMethodBeat.o(51627);
    }

    private void a(List<f> list, final com.tencent.mm.ai.w.a aVar) {
        AppMethodBeat.i(51628);
        c(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(51595);
                GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWe.cTT();
                if (!(GestureGuardLogicUI.this.tVP == null || GestureGuardLogicUI.this.tVP.bqV)) {
                    com.tencent.mm.kernel.g.Rg().c(GestureGuardLogicUI.this.tVP);
                }
                AppMethodBeat.o(51595);
            }
        });
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new bfo();
        aVar2.fsK = new bfp();
        aVar2.fsI = 689;
        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
        com.tencent.mm.ai.b acD = aVar2.acD();
        bfo bfo = (bfo) acD.fsG.fsP;
        bfo.Cn = 3;
        bfo.wJu = new SKBuiltinBuffer_t().setBuffer(e.dX(list));
        w.a(acD, new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(51596);
                ab.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                if (i == 0 && i2 == 0) {
                    d.a(((bfp) bVar.fsH.fsP).wJw);
                    com.tencent.mm.plugin.walletlock.c.g gVar = com.tencent.mm.plugin.walletlock.c.g.tWY;
                    com.tencent.mm.plugin.walletlock.c.g.nx(false);
                    GestureGuardLogicUI.this.tVM = false;
                    GestureGuardLogicUI.cTQ();
                }
                if (aVar != null) {
                    int a = aVar.a(i, i2, str, bVar, mVar);
                    AppMethodBeat.o(51596);
                    return a;
                }
                AppMethodBeat.o(51596);
                return 0;
            }
        }, false);
        AppMethodBeat.o(51628);
    }

    private void cTL() {
        AppMethodBeat.i(51629);
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            i.tXc.nB(true);
            i.tXc.nC(true);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            startActivity(intent);
        } else {
            ab.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
        }
        finish();
        AppMethodBeat.o(51629);
    }

    private void cTM() {
        AppMethodBeat.i(51630);
        String stringExtra = getIntent().getStringExtra("next_action");
        if (this.mStatus == 20 || "next_action.goto_protected_page".equals(stringExtra)) {
            i.tXc.cUg();
        }
        AppMethodBeat.o(51630);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(51631);
        a aVar = this.tVI[this.tVH];
        if (aVar.tWe != null) {
            PatternLockView patternLockView = aVar.tWe;
            boolean z2 = z && !this.tVM;
            patternLockView.setEnableInput(z2);
        }
        AppMethodBeat.at(this, z);
        AppMethodBeat.o(51631);
    }

    public final void a(PatternLockView patternLockView) {
        AppMethodBeat.i(51632);
        patternLockView.setDisplayMode(PatternLockView.b.Correct);
        AppMethodBeat.o(51632);
    }

    private void aq(int i, boolean z) {
        AppMethodBeat.i(51633);
        int i2 = i - this.tVH;
        if (i2 == 0) {
            AppMethodBeat.o(51633);
            return;
        }
        this.tVH = i;
        if (!z) {
            this.tVR.setInAnimation(null);
            this.tVR.setOutAnimation(null);
        } else if (i2 > 0) {
            this.tVR.setInAnimation(this, R.anim.df);
            this.tVR.setOutAnimation(this, R.anim.dc);
        } else {
            this.tVR.setInAnimation(this, R.anim.db);
            this.tVR.setOutAnimation(this, R.anim.dg);
        }
        if (i2 > 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                this.tVR.showNext();
            }
            AppMethodBeat.o(51633);
            return;
        }
        while (i2 < 0) {
            this.tVR.showPrevious();
            i2++;
        }
        AppMethodBeat.o(51633);
    }

    private void a(String str, final a aVar) {
        AppMethodBeat.i(51634);
        TextView textView = this.tVI[this.tVH].tWc;
        textView.getText().toString();
        textView.setText(str);
        textView.setTextColor(this.tVG);
        textView.startAnimation(this.tVJ);
        this.tVJ.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(51600);
                GestureGuardLogicUI.this.tVJ.setAnimationListener(null);
                if (aVar != null) {
                    aVar.onDone();
                }
                AppMethodBeat.o(51600);
            }
        });
        AppMethodBeat.o(51634);
    }

    private void cTN() {
        AppMethodBeat.i(51635);
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
        aVar.rc(false).asE(String.format(getString(R.string.c8y), new Object[]{Long.valueOf(10)}));
        aVar.Qc(R.string.c8u).a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(51601);
                dialogInterface.dismiss();
                GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWf);
                AppMethodBeat.o(51601);
            }
        });
        aVar.Qd(R.string.c8t).b(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(51602);
                dialogInterface.dismiss();
                GestureGuardLogicUI.t(GestureGuardLogicUI.this);
                GestureGuardLogicUI.this.finish();
                AppMethodBeat.o(51602);
            }
        });
        aVar.aMb().show();
        AppMethodBeat.o(51635);
    }

    private void cTO() {
        AppMethodBeat.i(51636);
        new com.tencent.mm.ui.widget.a.c.a(this).rc(true).PZ(R.string.c91).Qc(R.string.c8w).a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(51603);
                dialogInterface.dismiss();
                AppMethodBeat.o(51603);
            }
        }).aMb().show();
        AppMethodBeat.o(51636);
    }

    private void cTP() {
        AppMethodBeat.i(51637);
        String stringExtra = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) {
            stringExtra = getString(R.string.c8z);
        } else {
            stringExtra = getString(R.string.c90);
        }
        new com.tencent.mm.ui.widget.a.c.a(this).rc(false).asE(stringExtra).Qc(R.string.c8x).a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(51605);
                dialogInterface.dismiss();
                GestureGuardLogicUI.t(GestureGuardLogicUI.this);
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
                AppMethodBeat.o(51605);
            }
        }).Qd(R.string.c8v).b(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(51604);
                dialogInterface.dismiss();
                AppMethodBeat.o(51604);
            }
        }).aMb().show();
        AppMethodBeat.o(51637);
    }

    private void c(OnCancelListener onCancelListener) {
        AppMethodBeat.i(51638);
        if (this.tVS == null) {
            this.tVS = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.c97), false, onCancelListener);
            AppMethodBeat.o(51638);
            return;
        }
        this.tVS.show();
        AppMethodBeat.o(51638);
    }

    private void aDw() {
        AppMethodBeat.i(51639);
        if (this.tVS != null && this.tVS.isShowing()) {
            this.tVS.dismiss();
        }
        AppMethodBeat.o(51639);
    }

    public final int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void cTQ() {
        AppMethodBeat.i(51646);
        y.b(r.Yz(), 9, "PatternLockUpdate", "");
        com.tencent.mm.plugin.report.service.h.pYm.e(11473, new Object[0]);
        AppMethodBeat.o(51646);
    }
}
