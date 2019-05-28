package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.c.e;
import com.tencent.mm.plugin.wallet.pay.a.c.f;
import com.tencent.mm.plugin.wallet.pay.a.c.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.d;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.ae;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUI extends WalletBaseUI implements com.tencent.mm.plugin.wallet.pay.ui.a.a {
    private static boolean tpr = false;
    private static List<b> tps = new ArrayList();
    public String TAG = "MicroMsg.WalletPayUI";
    public String gHr = null;
    protected int mCount = 0;
    protected com.tencent.mm.plugin.wallet.a pQU = null;
    private String pRx;
    protected Button pTi;
    private c pUc = new c<vd>() {
        {
            AppMethodBeat.i(46047);
            this.xxI = vd.class.getName().hashCode();
            AppMethodBeat.o(46047);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(46048);
            ab.i(WalletPayUI.this.TAG, "WalletRealNameResultNotifyMoreEvent %s", Integer.valueOf(((vd) bVar).cSa.result));
            if (((vd) bVar).cSa.result == -1) {
                WalletPayUI.this.tqc = true;
                WalletPayUI.this.tqd = true;
                WalletPayUI.this.cNX();
            }
            AppMethodBeat.o(46048);
            return false;
        }
    };
    protected PayInfo pVL = null;
    protected Orders pWy = null;
    protected ArrayList<Bankcard> tgB = null;
    protected Bankcard tgC = null;
    public FavorPayInfo toH = null;
    private a toI;
    d toJ;
    private boolean toK = false;
    private com.tencent.mm.plugin.wallet.pay.a.d tou = null;
    protected String tpA = "";
    protected boolean tpB = false;
    public Bundle tpC = null;
    protected boolean tpD = false;
    protected TextView tpE;
    protected TextView tpF;
    private TextView tpG;
    protected TextView tpH;
    protected TextView tpI;
    protected TextView tpJ;
    protected ImageView tpK;
    private TextView tpL;
    private TextView tpM;
    protected LinearLayout tpN;
    protected a tpO;
    public Dialog tpP;
    private long tpQ = 0;
    private TextView tpR;
    private LinearLayout tpS;
    private boolean tpT = true;
    private boolean tpU = false;
    private boolean tpV = false;
    private boolean tpW = false;
    private boolean tpX = false;
    private int tpY = -1;
    private boolean tpZ = false;
    private f tpt = null;
    protected com.tencent.mm.plugin.wallet_core.ui.b tpu = null;
    private boolean tpv = false;
    private boolean tpw = false;
    protected boolean tpx = false;
    private com.tencent.mm.wallet_core.c.a tpy;
    protected boolean tpz = false;
    private boolean tqa = false;
    private f tqb;
    private boolean tqc = false;
    private boolean tqd = false;
    private int tqe = 0;
    private Runnable tqf = new Runnable() {
        public final void run() {
            AppMethodBeat.i(46034);
            ab.i(WalletPayUI.this.TAG, "auto reset create flag");
            WalletPayUI.tpr = false;
            AppMethodBeat.o(46034);
        }
    };
    private b tqg;
    private long tqh = 0;
    private boolean tqi;

    protected class a {
        protected a() {
        }

        public final void notifyDataSetChanged() {
            int i;
            AppMethodBeat.i(46075);
            WalletPayUI.this.tpN.removeAllViews();
            if (WalletPayUI.this.mCount == 0) {
                i = 0;
            } else if (WalletPayUI.this.tpB) {
                i = WalletPayUI.this.mCount;
            } else {
                i = 1;
            }
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            for (int i2 = 0; i2 < i; i2++) {
                View inflate = ((LayoutInflater) WalletPayUI.this.getSystemService("layout_inflater")).inflate(R.layout.b5j, null);
                TextView textView = (TextView) inflate.findViewById(R.id.fdo);
                TextView textView2 = (TextView) inflate.findViewById(R.id.fdh);
                Commodity commodity = (Commodity) WalletPayUI.this.pWy.tAq.get(i2);
                String str = "";
                if (WalletPayUI.this.pVL != null && (WalletPayUI.this.pVL.cIf == 32 || WalletPayUI.this.pVL.cIf == 33 || WalletPayUI.this.pVL.cIf == 31 || WalletPayUI.this.pVL.cIf == 48)) {
                    String string = WalletPayUI.this.pVL.vwh.getString("extinfo_key_1", "");
                    if (bo.isNullOrNil(string)) {
                        ab.e(WalletPayUI.this.TAG, "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                    } else {
                        g.RQ();
                        ad aoM = ((j) g.K(j.class)).XM().aoM(string);
                        if (aoM != null) {
                            str = aoM.Oj();
                        } else {
                            ab.e(WalletPayUI.this.TAG, "can not found contact for user::".concat(String.valueOf(string)));
                        }
                    }
                }
                if (commodity != null) {
                    if (!bo.isNullOrNil(str)) {
                        textView2.setText(str);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(R.id.ff4)).setVisibility(0);
                    } else if (bo.isNullOrNil(commodity.pca)) {
                        ((TextView) inflate.findViewById(R.id.ff4)).setVisibility(8);
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(commodity.pca);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(R.id.ff4)).setVisibility(0);
                    }
                    if (bo.isNullOrNil(commodity.desc)) {
                        ((TextView) inflate.findViewById(R.id.fdn)).setVisibility(8);
                        textView.setVisibility(8);
                    } else {
                        textView.setText(commodity.desc);
                        textView.setVisibility(8);
                        ((TextView) inflate.findViewById(R.id.fdn)).setVisibility(8);
                    }
                    if (bo.isNullOrNil(str) && bo.isNullOrNil(commodity.pca)) {
                        inflate.setVisibility(8);
                    } else {
                        inflate.setVisibility(0);
                    }
                }
                inflate.setLayoutParams(layoutParams);
                inflate.measure(-2, -2);
                WalletPayUI.this.tpN.addView(inflate);
            }
            AppMethodBeat.o(46075);
        }
    }

    class b {
        int aBR;
        long timestamp;
        WeakReference<WalletPayUI> tqs;

        private b() {
        }

        /* synthetic */ b(WalletPayUI walletPayUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletPayUI() {
        AppMethodBeat.i(46076);
        AppMethodBeat.o(46076);
    }

    static /* synthetic */ void e(WalletPayUI walletPayUI) {
        AppMethodBeat.i(46122);
        walletPayUI.cNZ();
        AppMethodBeat.o(46122);
    }

    static /* synthetic */ void g(WalletPayUI walletPayUI) {
        AppMethodBeat.i(46124);
        walletPayUI.cOe();
        AppMethodBeat.o(46124);
    }

    static /* synthetic */ boolean l(WalletPayUI walletPayUI) {
        AppMethodBeat.i(138088);
        boolean cNG = walletPayUI.cNG();
        AppMethodBeat.o(138088);
        return cNG;
    }

    static {
        AppMethodBeat.i(46126);
        AppMethodBeat.o(46126);
    }

    private void Hg(int i) {
        AppMethodBeat.i(46077);
        this.tqe = i;
        ab.i(this.TAG, "markForceFinish errorType %s %s", Integer.valueOf(i), bo.dpG().toString());
        AppMethodBeat.o(46077);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46078);
        super.onCreate(bundle);
        this.TAG = "MicroMsg.WalletPayUI@" + hashCode();
        if (tpr) {
            ab.w(this.TAG, "has Undestory WalletPayUI!");
            h.pYm.k(965, 1, 1);
            Hg(2);
            finish();
            AppMethodBeat.o(46078);
            return;
        }
        tpr = true;
        long currentTimeMillis = System.currentTimeMillis();
        int intExtra = getIntent().getIntExtra("key_context_hashcode", -1);
        b[] bVarArr = new b[tps.size()];
        ab.i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", Integer.valueOf(tps.size()), Integer.valueOf(hashCode()), Integer.valueOf(intExtra));
        for (b bVar : (b[]) tps.toArray(bVarArr)) {
            WalletPayUI walletPayUI = (WalletPayUI) bVar.tqs.get();
            if (walletPayUI != null) {
                ab.w(this.TAG, "has old payui, both finish %s", Integer.valueOf(walletPayUI.hashCode()));
                if (intExtra != bVar.aBR || intExtra == -1) {
                    walletPayUI.Hg(1);
                    h.pYm.k(965, 40, 1);
                } else {
                    walletPayUI.Hg(2);
                    h.pYm.k(965, 41, 1);
                }
                tps.remove(bVar);
                walletPayUI.finish();
            }
        }
        this.tqg = new b(this, (byte) 0);
        this.tqg.timestamp = currentTimeMillis;
        this.tqg.aBR = intExtra;
        this.tqg.tqs = new WeakReference(this);
        tps.add(this.tqg);
        if (g.RK()) {
            getWindow().getDecorView().postDelayed(this.tqf, 5000);
            this.tqh = bo.anU();
            com.tencent.mm.sdk.b.a.xxA.c(this.pUc);
            k.Hp(5);
            this.pQU = com.tencent.mm.plugin.wallet.a.at(getIntent());
            setMMTitle((int) R.string.fp2);
            this.pVL = cOl();
            this.tpz = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
            this.tpA = bo.bc(getIntent().getStringExtra("key_force_use_bind_serail"), "");
            this.pRx = getIntent().getStringExtra("key_receiver_true_name");
            if (this.pVL == null || this.pVL.vwj == 0) {
                this.tpQ = System.currentTimeMillis();
            } else {
                this.tpQ = this.pVL.vwj;
            }
            s.cNC();
            if (!s.cND().cQg()) {
                com.tencent.mm.wallet_core.c.ad.e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 1, "");
            }
            if (cNW()) {
                ab.i(this.TAG, "hy: pay end on create. finish");
                finish();
            } else {
                ab.d(this.TAG, "PayInfo = " + this.pVL);
                if (this.pVL == null || bo.isNullOrNil(this.pVL.czZ)) {
                    String string;
                    if (this.pVL == null || bo.isNullOrNil(this.pVL.aIm)) {
                        string = getString(R.string.fov);
                    } else {
                        string = this.pVL.aIm;
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, string, null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(46061);
                            WalletPayUI.this.finish();
                            AppMethodBeat.o(46061);
                        }
                    });
                } else {
                    cNX();
                }
                initView();
            }
            if (this.pVL != null) {
                com.tencent.mm.plugin.wallet.pay.a.b.acn(this.pVL.vwp);
            }
            AppMethodBeat.o(46078);
            return;
        }
        ab.e(this.TAG, "hy: account not ready. finish now");
        finish();
        AppMethodBeat.o(46078);
    }

    private boolean cNW() {
        AppMethodBeat.i(46079);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("intent_pay_end")) {
            ab.i(this.TAG, "hy: pay end. finish the activity");
            if (extras.getBoolean("intent_pay_end", false)) {
                ab.d(this.TAG, "pay done... errCode:" + extras.getInt("intent_pay_end_errcode"));
                ab.d(this.TAG, "pay done INTENT_PAY_APP_URL:" + extras.getString("intent_pay_app_url"));
                ab.d(this.TAG, "pay done INTENT_PAY_END:" + extras.getBoolean("intent_pay_end", false));
                h(-1, getIntent());
                this.tpw = true;
            } else {
                ab.d(this.TAG, "pay cancel");
                h(0, getIntent());
                this.tpw = false;
            }
            AppMethodBeat.o(46079);
            return true;
        } else if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            ab.i(this.TAG, "hy: pay not end");
            AppMethodBeat.o(46079);
            return false;
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    AppMethodBeat.o(46079);
                    return true;
                default:
                    AppMethodBeat.o(46079);
                    return false;
            }
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(46080);
        if (this.toI != null) {
            this.toI.cNM();
            this.toI.release();
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.pUc);
        this.toJ = null;
        getWindow().getDecorView().removeCallbacks(this.tqf);
        tps.remove(this.tqg);
        tpr = false;
        long currentTimeMillis = System.currentTimeMillis();
        for (b bVar : (b[]) tps.toArray(new b[tps.size()])) {
            WalletPayUI walletPayUI = (WalletPayUI) bVar.tqs.get();
            if (walletPayUI != null && currentTimeMillis - bVar.timestamp > 600000) {
                ab.w(this.TAG, "has old payui, both finish");
                h.pYm.k(965, 2, 1);
                tps.remove(bVar);
                walletPayUI.Hg(1);
                walletPayUI.finish();
            }
        }
        if (this.pVL != null) {
            com.tencent.mm.plugin.wallet.pay.a.b.aco(this.pVL.vwp);
        }
        super.onDestroy();
        AppMethodBeat.o(46080);
    }

    /* Access modifiers changed, original: protected */
    public void cNX() {
        u uVar;
        int i = 2;
        AppMethodBeat.i(46081);
        h.pYm.e(11850, Integer.valueOf(2), Integer.valueOf(this.pVL.cIf));
        if (this.pVL.cIf == 11) {
            i = 3;
        }
        PayInfo payInfo = this.pVL;
        if (payInfo == null || bo.isNullOrNil(payInfo.czZ)) {
            ab.i("MicroMsg.CgiManager", "no payInfo or reqKey");
            uVar = null;
        } else {
            String str = payInfo.czZ;
            ab.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", str);
            ab.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
            if (str.startsWith("sns_aa_")) {
                uVar = new com.tencent.mm.plugin.wallet.pay.a.c.a(payInfo, i);
            } else if (str.startsWith("sns_tf_")) {
                uVar = new com.tencent.mm.plugin.wallet.pay.a.c.j(payInfo, i);
            } else if (str.startsWith("sns_ff_")) {
                uVar = new com.tencent.mm.plugin.wallet.pay.a.c.c(payInfo, i);
            } else if (str.startsWith("ts_")) {
                uVar = new com.tencent.mm.plugin.wallet.pay.a.c.d(payInfo, i);
            } else if (str.startsWith("sns_")) {
                uVar = new com.tencent.mm.plugin.wallet.pay.a.c.h(payInfo, i);
            } else if (str.startsWith("offline_")) {
                uVar = new e(payInfo, i);
            } else if (str.startsWith("up_")) {
                uVar = new com.tencent.mm.plugin.wallet.pay.a.c.k(payInfo, i);
            } else if (str.startsWith("seb_ff_")) {
                uVar = new com.tencent.mm.plugin.wallet.pay.a.c.g(payInfo, i);
            } else if (str.startsWith("tax_")) {
                uVar = new i(payInfo, i);
            } else if (str.startsWith("dc_")) {
                uVar = new com.tencent.mm.plugin.wallet.pay.a.c.b(payInfo, i);
            } else {
                uVar = new f(payInfo, i);
            }
        }
        if (uVar != null) {
            uVar.eHT = "PayProcess";
            uVar.hbj = this.tpQ;
            if (this.pVL.cIf == 6 && this.pVL.vwe == 100) {
                uVar.gOW = 100;
            } else {
                uVar.gOW = this.pVL.cIf;
            }
            a((m) uVar, true, this.pVL.vwf);
        }
        AppMethodBeat.o(46081);
    }

    public void onResume() {
        AppMethodBeat.i(46082);
        ab.i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", Boolean.valueOf(this.tqc));
        if (!this.Ahr.bLA()) {
            if (!bo.isNullOrNil(this.tpA)) {
                this.tgC = cOh();
            } else if (this.tgC == null) {
                s.cNC();
                this.tgC = s.cND().a(null, null, cOk(), false);
            } else {
                s.cNC();
                this.tgC = s.cND().a(null, this.tgC.field_bindSerial, cOk(), false);
            }
        }
        if (this.tqd) {
            ab.i(this.TAG, "onResume isResumePassFinish");
            this.tqd = false;
        } else if (this.tpx && this.mController.contentView.getVisibility() != 0 && (this.tpP == null || !this.tpP.isShowing())) {
            ab.i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
            finish();
        } else if (this.toJ != null) {
            this.toJ.cRm();
        }
        super.onResume();
        AppMethodBeat.o(46082);
    }

    public final int getLayoutId() {
        return R.layout.b5n;
    }

    public void finish() {
        AppMethodBeat.i(46083);
        ab.i(this.TAG, "finish %s %s mPayResultType:%s", Integer.valueOf(hashCode()), bo.dpG().toString(), Integer.valueOf(this.Ahw));
        dOy();
        if (!(this.pWy == null || this.pWy.tAq.isEmpty())) {
            getIntent().putExtra("key_trans_id", ((Commodity) this.pWy.tAq.get(0)).cAa);
        }
        if (this.pVL != null) {
            getIntent().putExtra("key_reqKey", this.pVL.czZ);
        }
        if (this.tpw) {
            if (this.pWy != null) {
                getIntent().putExtra("key_total_fee", this.pWy.pTN);
            }
            getIntent().putExtra("key_pay_reslut_type", 1);
            h(-1, getIntent());
            setResult(-1, getIntent());
        } else {
            if (!(this.pVL == null || this.pVL.cIf != 8 || this.pWy == null)) {
                this.pVL.vwn = 0;
                a(com.tencent.mm.plugin.wallet.pay.a.a.a(cOb(), this.pWy, true), false, false);
                if (this.pVL.vwh != null) {
                    long j = this.pVL.vwh.getLong("extinfo_key_9");
                    h.pYm.e(13956, Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - j));
                }
            }
            h(0, getIntent());
            getIntent().putExtra("key_pay_reslut_type", this.Ahw);
            if (this.tqe == 1) {
                getIntent().putExtra("key_pay_reslut_type", 1000);
            } else if (this.tqe == 2) {
                getIntent().putExtra("key_pay_reslut_type", 1001);
            }
            setResult(0, getIntent());
            s.cNC();
            if (s.cND().cQi()) {
                com.tencent.mm.wallet_core.c.ad.e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 18, "");
            } else {
                s.cNC();
                if (s.cND().cQh()) {
                    com.tencent.mm.wallet_core.c.ad.e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 4, "");
                } else {
                    com.tencent.mm.wallet_core.c.ad.e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 7, "");
                }
            }
            for (com.tencent.mm.wallet_core.c cVar : com.tencent.mm.wallet_core.a.atm("PayProcess")) {
                cVar.F("specEndProcessWithoutFinish");
                if (cVar.mqu != null) {
                    cVar.mqu.clear();
                }
                com.tencent.mm.wallet_core.a.remove(cVar.getClass().hashCode());
                cVar.cNF();
            }
        }
        com.tencent.mm.wallet_core.c dOD = dOD();
        if (dOD != null && this == ((Context) dOD.AeT.get())) {
            ab.i(this.TAG, "remove process end callback to prevent ui leak");
            dOD.dND();
        }
        super.finish();
        AppMethodBeat.o(46083);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(46084);
        if (i != 4) {
            boolean onKeyUp = super.onKeyUp(i, keyEvent);
            AppMethodBeat.o(46084);
            return onKeyUp;
        } else if (this.tqi) {
            ab.w(this.TAG, "block when authening");
            AppMethodBeat.o(46084);
            return true;
        } else {
            if (this.tpP == null || this.pVL == null || !this.pVL.mXg || this.Ahr.bLA()) {
                aqX();
                showDialog(1000);
            } else {
                finish();
            }
            AppMethodBeat.o(46084);
            return true;
        }
    }

    public void onNewIntent(Intent intent) {
        boolean z = true;
        AppMethodBeat.i(46085);
        ab.i(this.TAG, "onNewIntent");
        setIntent(intent);
        if (!cNW()) {
            ab.w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
            if (intent.getBooleanExtra("send_cancel_event", true)) {
                h(0, getIntent());
            }
            this.tpw = false;
        }
        if (intent.getBooleanExtra("direc_change_bankcard", false)) {
            mZ(true);
            AppMethodBeat.o(46085);
            return;
        }
        boolean z2;
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            z2 = false;
        } else {
            this.tpU = true;
            z2 = true;
        }
        if (z2) {
            ab.i(this.TAG, "isFromBindCard is true");
            cNX();
            AppMethodBeat.o(46085);
            return;
        }
        if (intent == null || !intent.getBooleanExtra("key_is_realname_verify_process", false)) {
            z = false;
        } else {
            this.tpV = true;
        }
        if (z) {
            ab.i(this.TAG, "isFromRealNameVerify is true");
            finish();
        } else {
            ab.e(this.TAG, "isFromBindCard is false,isFromRealNameVerify is false");
        }
        finish();
        AppMethodBeat.o(46085);
    }

    private void h(int i, Intent intent) {
        AppMethodBeat.i(46086);
        if (!(this.pVL == null || this.pVL.cIf != 46 || this.pWy == null)) {
            intent.putExtra("key_total_fee", this.pWy.pTN);
            ab.i(this.TAG, "sentCancelEvent set fee:%s", Double.valueOf(this.pWy.pTN));
        }
        uv uvVar = new uv();
        uvVar.cRF.intent = intent;
        if (this.tqe == 1) {
            uvVar.cRF.cRG = 1000;
        } else if (this.tqe == 2) {
            uvVar.cRF.cRG = 1001;
        }
        uvVar.cRF.result = i;
        uvVar.cRF.czZ = this.pVL == null ? "" : this.pVL.czZ;
        uvVar.cRF.cRH = 1;
        if (this.pVL != null && i == 0) {
            com.tencent.mm.plugin.wallet.pay.a.b.b.ak(this.pVL.czZ, this.pVL.cIf, this.pVL.cIb);
        }
        com.tencent.mm.sdk.b.a.xxA.m(uvVar);
        AppMethodBeat.o(46086);
    }

    public final void initView() {
        AppMethodBeat.i(46087);
        ae.a(getWindow());
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.id.bb_);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.pTi = (Button) findViewById(R.id.ffu);
        this.pTi.setClickable(false);
        this.pTi.setEnabled(false);
        this.tpE = (TextView) findViewById(R.id.fdj);
        this.tpF = (TextView) findViewById(R.id.ff_);
        this.tpH = (TextView) findViewById(R.id.ffa);
        this.tpM = (TextView) findViewById(R.id.fff);
        this.tpG = (TextView) findViewById(R.id.ffb);
        this.tpL = (TextView) findViewById(R.id.fft);
        this.tpG.getPaint().setFlags(16);
        this.tpI = (TextView) findViewById(R.id.ffw);
        this.tpJ = (TextView) findViewById(R.id.ffv);
        this.tpJ.setOnClickListener(new com.tencent.mm.ui.s() {
            public final void bgW() {
                AppMethodBeat.i(46065);
                WalletPayUI.this.b(false, 0, "");
                AppMethodBeat.o(46065);
            }
        });
        this.tpK = (ImageView) findViewById(R.id.ffg);
        this.tpK.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46066);
                if (WalletPayUI.this.tpB) {
                    WalletPayUI.this.tpK.setImageResource(R.drawable.wn);
                    WalletPayUI.this.tpB = false;
                } else {
                    WalletPayUI.this.tpK.setImageResource(R.drawable.wo);
                    WalletPayUI.this.tpB = true;
                }
                WalletPayUI.this.tpO.notifyDataSetChanged();
                AppMethodBeat.o(46066);
            }
        });
        this.tpN = (LinearLayout) findViewById(R.id.ffc);
        this.tpO = new a();
        this.pTi.setOnClickListener(new com.tencent.mm.ui.s() {
            public final void bgW() {
                AppMethodBeat.i(46067);
                s.cNC();
                if (!s.cND().cQh()) {
                    com.tencent.mm.wallet_core.c.ad.e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 6, "");
                }
                WalletPayUI.this.cOd();
                AppMethodBeat.o(46067);
            }
        });
        this.pTi.setText(R.string.fnr);
        this.tpR = (TextView) findViewById(R.id.ffh);
        this.tpS = (LinearLayout) findViewById(R.id.ffi);
        cu();
        AppMethodBeat.o(46087);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cu() {
        int i;
        LinearLayout linearLayout;
        AppMethodBeat.i(46088);
        if (!(this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0)) {
            this.tpE.setText(com.tencent.mm.wallet_core.ui.e.F(this.pWy.pTN));
            this.tpH.setText(com.tencent.mm.wallet_core.ui.e.atr(this.pWy.pcl));
            this.tpO.notifyDataSetChanged();
            if (this.pWy.tAq.size() > 1) {
                this.tpK.setVisibility(0);
                this.tpF.setText(getString(R.string.fp3, new Object[]{((Commodity) this.pWy.tAq.get(0)).desc, this.pWy.tAq.size()}));
            } else {
                this.tpF.setText(((Commodity) this.pWy.tAq.get(0)).desc);
                this.tpK.setVisibility(8);
            }
            this.tpB = false;
        }
        if (this.pVL != null && this.pVL.cIf == 48) {
            this.tpF.setText(R.string.dfl);
        }
        this.tpI.setVisibility(8);
        this.tpJ.setVisibility(8);
        this.tpR.setVisibility(8);
        this.tpS.setVisibility(8);
        this.pTi.setText(R.string.fnr);
        if (this.tgC == null || !this.tgC.cPc()) {
            s.cNC();
            if (s.cND().cQi()) {
                cNY();
            }
        } else if (bo.isNullOrNil(this.tgC.field_forbidWord)) {
            s.cNC();
            if (s.cND().cQh()) {
                cNY();
            }
        } else {
            this.tpI.setText(this.tgC.field_forbidWord);
            this.tpI.setVisibility(4);
            this.tpJ.setVisibility(8);
            s.cNC();
            if (s.cND().cQh()) {
                cNY();
            }
        }
        s.cNC();
        if (!s.cND().cQh()) {
            s.cNC();
            if (!s.cND().cQi()) {
                i = 0;
                linearLayout = (LinearLayout) findViewById(R.id.ffd);
                if (i != 0 || this.toH == null || this.tpu == null || !this.tpv || this.pWy == null) {
                    linearLayout.setVisibility(8);
                } else {
                    cOa();
                    this.tpM.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(46072);
                            com.tencent.mm.wallet_core.c.ad.e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 12, "");
                            l.a(WalletPayUI.this.mController.ylL, WalletPayUI.this.pWy, WalletPayUI.this.toH.tzb, new com.tencent.mm.plugin.wallet_core.ui.l.b() {
                                /* JADX WARNING: Removed duplicated region for block: B:24:0x00f9  */
                                /* JADX WARNING: Removed duplicated region for block: B:26:0x011b  */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void a(FavorPayInfo favorPayInfo) {
                                    int i = 1;
                                    AppMethodBeat.i(46071);
                                    WalletPayUI.this.toH = favorPayInfo;
                                    String str = WalletPayUI.this.TAG;
                                    String str2 = "WalletFavorDialog onSelectionDone %s";
                                    Object[] objArr = new Object[1];
                                    objArr[0] = favorPayInfo == null ? "" : favorPayInfo.toString();
                                    ab.i(str, str2, objArr);
                                    if (WalletPayUI.this.toH != null) {
                                        int i2;
                                        boolean z;
                                        if (WalletPayUI.this.pVL == null) {
                                            i2 = 0;
                                        } else {
                                            i2 = WalletPayUI.this.pVL.cIf;
                                        }
                                        if (WalletPayUI.this.pVL == null) {
                                            str = "";
                                        } else {
                                            str = WalletPayUI.this.pVL.czZ;
                                        }
                                        com.tencent.mm.wallet_core.c.ad.e(i2, str, 15, WalletPayUI.this.toH.tzb);
                                        if (WalletPayUI.this.tgC == null || com.tencent.mm.plugin.wallet_core.ui.b.a(WalletPayUI.this.toH, WalletPayUI.this.tgC)) {
                                            WalletPayUI.this.tpJ.setVisibility(8);
                                            WalletPayUI.this.pTi.setOnClickListener(new View.OnClickListener() {
                                                public final void onClick(View view) {
                                                    AppMethodBeat.i(46068);
                                                    ab.i(WalletPayUI.this.TAG, "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                                                    WalletPayUI.this.b(false, 0, "");
                                                    AppMethodBeat.o(46068);
                                                }
                                            });
                                            z = true;
                                        } else {
                                            com.tencent.mm.plugin.wallet.a.j acU = WalletPayUI.this.tpu.acU(WalletPayUI.this.toH.tzb);
                                            if (acU != null && WalletPayUI.this.tgC.cPc()) {
                                                s.cNC();
                                                Bankcard bankcard = s.cND().thy;
                                                double d = acU.tmT;
                                                if (bankcard != null && bankcard.twS < d) {
                                                    ab.i(WalletPayUI.this.TAG, "balance not meet");
                                                    WalletPayUI.this.tpJ.setVisibility(8);
                                                    WalletPayUI.this.pTi.setOnClickListener(new View.OnClickListener() {
                                                        public final void onClick(View view) {
                                                            AppMethodBeat.i(46069);
                                                            ab.i(WalletPayUI.this.TAG, "Balance amount not meet, after favor selection! payWithNewBankcard");
                                                            WalletPayUI.this.b(false, 0, "");
                                                            AppMethodBeat.o(46069);
                                                        }
                                                    });
                                                    z = true;
                                                }
                                            }
                                            z = false;
                                        }
                                        ab.i(WalletPayUI.this.TAG, "needBindBankCard %s", Boolean.valueOf(z));
                                        WalletPayUI.this.tpS.setVisibility(0);
                                        WalletPayUI.this.tpR.setVisibility(0);
                                        if (WalletPayUI.this.toH != null) {
                                            WalletPayUI.this.tpu = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(WalletPayUI.this.pWy);
                                            com.tencent.mm.plugin.wallet.a.j acU2 = WalletPayUI.this.tpu.acU(WalletPayUI.this.toH.tzb);
                                            if (acU2 != null && acU2.tmT == 0.0d) {
                                                WalletPayUI.this.tpS.setVisibility(8);
                                                WalletPayUI.this.tpR.setVisibility(8);
                                                z = false;
                                                if (!z) {
                                                    WalletPayUI.this.tpI.setVisibility(8);
                                                    WalletPayUI.this.tpJ.setVisibility(0);
                                                    WalletPayUI.this.pTi.setOnClickListener(new View.OnClickListener() {
                                                        public final void onClick(View view) {
                                                            AppMethodBeat.i(46070);
                                                            WalletPayUI.this.cOd();
                                                            AppMethodBeat.o(46070);
                                                        }
                                                    });
                                                }
                                                if (i != 0) {
                                                    WalletPayUI.this.tpJ.setVisibility(8);
                                                }
                                                WalletPayUI.this.cOa();
                                            }
                                        }
                                        i = 0;
                                        if (z) {
                                        }
                                        if (i != 0) {
                                        }
                                        WalletPayUI.this.cOa();
                                    }
                                    AppMethodBeat.o(46071);
                                }
                            }, null);
                            AppMethodBeat.o(46072);
                        }
                    });
                    linearLayout.setVisibility(0);
                }
                if (this.pWy != null || this.tgB == null || this.pVL == null) {
                    this.pTi.setClickable(false);
                    this.pTi.setEnabled(false);
                } else {
                    this.pTi.setClickable(true);
                    this.pTi.setEnabled(true);
                }
                if (this.pWy == null) {
                    this.tpJ.setVisibility(8);
                }
                AppMethodBeat.o(46088);
            }
        }
        i = 1;
        linearLayout = (LinearLayout) findViewById(R.id.ffd);
        if (i != 0) {
        }
        linearLayout.setVisibility(8);
        if (this.pWy != null) {
        }
        this.pTi.setClickable(false);
        this.pTi.setEnabled(false);
        if (this.pWy == null) {
        }
        AppMethodBeat.o(46088);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cNY() {
        AppMethodBeat.i(46089);
        if (this.pWy == null) {
            ab.e(this.TAG, "updatePaymentMethodForFavor mOrders is null");
            AppMethodBeat.o(46089);
            return;
        }
        boolean z;
        this.tpJ.setVisibility(8);
        this.tpI.setVisibility(8);
        this.pTi.setText(R.string.fnr);
        this.tpR.setVisibility(0);
        this.tpS.setVisibility(0);
        View findViewById = this.tpS.findViewById(R.id.ffj);
        View findViewById2 = this.tpS.findViewById(R.id.ffn);
        if ("CFT".equals(this.pWy.tAm)) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
        }
        final CheckedTextView checkedTextView = (CheckedTextView) this.tpS.findViewById(R.id.ffm);
        final CheckedTextView checkedTextView2 = (CheckedTextView) this.tpS.findViewById(R.id.ffs);
        findViewById.setEnabled(true);
        boolean z2;
        if (this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0) {
            z2 = false;
        } else if (this.pWy.tAb == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.tgC == null) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(46073);
                    checkedTextView.setChecked(true);
                    checkedTextView2.setChecked(false);
                    WalletPayUI.this.tpT = false;
                    WalletPayUI.e(WalletPayUI.this);
                    AppMethodBeat.o(46073);
                }
            });
        }
        findViewById2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46074);
                checkedTextView.setChecked(false);
                checkedTextView2.setChecked(true);
                WalletPayUI.this.tpT = true;
                WalletPayUI.e(WalletPayUI.this);
                AppMethodBeat.o(46074);
            }
        });
        this.tpR.setVisibility(0);
        this.tpS.setVisibility(0);
        if (this.toH != null) {
            this.tpu = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(this.pWy);
            com.tencent.mm.plugin.wallet.a.j acU = this.tpu.acU(this.toH.tzb);
            if (acU != null && acU.tmT == 0.0d) {
                this.tpS.setVisibility(8);
                this.tpR.setVisibility(8);
                z = true;
                this.tpT = true;
                if (z) {
                    this.tpT = false;
                }
                checkedTextView.setChecked(false);
                checkedTextView2.setChecked(true);
                ab.i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.pWy.tAs);
                if (this.pWy.tAs != 1) {
                    this.tpS.findViewById(R.id.ffp).setVisibility(0);
                    ((TextView) this.tpS.findViewById(R.id.ffq)).setText(this.pWy.tAt);
                    if (TextUtils.isEmpty(this.pWy.tAu)) {
                        ((TextView) this.tpS.findViewById(R.id.ffr)).setText("");
                    } else {
                        ((TextView) this.tpS.findViewById(R.id.ffr)).setText(" (" + this.pWy.tAu + ")");
                    }
                    if (!(this.tgC == null || !this.tgC.cPc() || TextUtils.isEmpty(this.tgC.field_forbidWord))) {
                        findViewById.setEnabled(false);
                        checkedTextView.setVisibility(8);
                        ((TextView) this.tpS.findViewById(R.id.ffl)).setText(this.tgC.field_forbidWord);
                    }
                } else {
                    this.tpS.findViewById(R.id.ffp).setVisibility(8);
                    if (this.tgC != null && this.tgC.cPc() && !TextUtils.isEmpty(this.tgC.field_forbidWord)) {
                        findViewById.setEnabled(false);
                        checkedTextView.setVisibility(8);
                        ((TextView) this.tpS.findViewById(R.id.ffl)).setText(this.tgC.field_forbidWord);
                    } else if (this.tgC != null && this.tgC.cPc() && TextUtils.isEmpty(this.tgC.field_forbidWord) && !z2) {
                        checkedTextView.setChecked(true);
                        checkedTextView2.setChecked(false);
                        this.tpT = false;
                    }
                }
                cNZ();
                AppMethodBeat.o(46089);
            }
        }
        z = false;
        this.tpT = true;
        if (z) {
        }
        checkedTextView.setChecked(false);
        checkedTextView2.setChecked(true);
        ab.i(this.TAG, "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.pWy.tAs);
        if (this.pWy.tAs != 1) {
        }
        cNZ();
        AppMethodBeat.o(46089);
    }

    private void cNZ() {
        AppMethodBeat.i(46090);
        if (this.tpT) {
            this.pTi.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    int i = 0;
                    AppMethodBeat.i(46035);
                    s.cNC();
                    if (s.cND().cQh()) {
                        com.tencent.mm.wallet_core.c.ad.e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 6, "");
                    }
                    if (WalletPayUI.this.pWy.tAs == 1) {
                        s.cNC();
                        if (s.cND().cQh()) {
                            if (WalletPayUI.this.pVL != null) {
                                i = WalletPayUI.this.pVL.cIf;
                            }
                            com.tencent.mm.wallet_core.c.ad.e(i, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 5, "");
                        }
                        WalletPayUI.f(WalletPayUI.this);
                        AppMethodBeat.o(46035);
                        return;
                    }
                    ab.i(WalletPayUI.this.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
                    s.cNC();
                    if (s.cND().cQh()) {
                        com.tencent.mm.wallet_core.c.ad.e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 5, "");
                    }
                    WalletPayUI.this.b(false, 0, "");
                    AppMethodBeat.o(46035);
                }
            });
            AppMethodBeat.o(46090);
            return;
        }
        this.pTi.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46036);
                WalletPayUI.this.cOd();
                AppMethodBeat.o(46036);
            }
        });
        AppMethodBeat.o(46090);
    }

    public final void cOa() {
        double d;
        int i;
        AppMethodBeat.i(46091);
        com.tencent.mm.plugin.wallet.a.j acU = this.tpu.acU(this.toH.tzb);
        List cRl = this.tpu.cRl();
        com.tencent.mm.plugin.wallet.a.h hVar = this.tpu.tDO;
        String str = "";
        if (acU != null) {
            d = acU.tnb;
            if (d > 0.0d) {
                str = acU.tnd;
                i = 1;
                if (!bo.isNullOrNil(acU.tne)) {
                    str = str + "," + acU.tne;
                }
            } else {
                i = 0;
            }
        } else {
            i = 0;
            d = 0.0d;
        }
        if (i == 0 && cRl.size() > 0) {
            str = str + this.mController.ylL.getString(R.string.fq0);
        }
        if (d <= 0.0d || hVar == null || hVar.tmX != 0) {
            this.tpE.setText(com.tencent.mm.wallet_core.ui.e.F(this.pWy.pTN));
            this.tpH.setText(com.tencent.mm.wallet_core.ui.e.atr(this.pWy.pcl));
            this.tpG.setVisibility(8);
        } else {
            if (acU != null) {
                this.tpE.setText(com.tencent.mm.wallet_core.ui.e.F(acU.tna));
            }
            this.tpH.setText(com.tencent.mm.wallet_core.ui.e.atr(this.pWy.pcl));
            this.tpG.setText(com.tencent.mm.wallet_core.ui.e.e(this.pWy.pTN, this.pWy.pcl));
            this.tpG.setVisibility(0);
        }
        if (!bo.isNullOrNil(str)) {
            this.tpM.setText(str);
        }
        AppMethodBeat.o(46091);
    }

    /* Access modifiers changed, original: protected|final */
    public final Authen cOb() {
        AppMethodBeat.i(46092);
        Authen authen = new Authen();
        if (cOc()) {
            authen.bJt = 3;
        } else {
            authen.bJt = 6;
        }
        if (!bo.isNullOrNil(this.gHr)) {
            authen.twc = this.gHr;
        }
        if (this.tgC != null) {
            authen.pbo = this.tgC.field_bindSerial;
            authen.pbn = this.tgC.field_bankcardType;
        }
        if (!(this.toH == null || this.tpu == null || !this.tpu.cRi())) {
            authen.two = this.toH.tzb;
            authen.twn = this.toH.tze;
        }
        authen.pGr = this.pVL;
        AppMethodBeat.o(46092);
        return authen;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cOc() {
        AppMethodBeat.i(46093);
        if (this.tgC == null || this.pWy == null || this.pWy.tuo != 3) {
            if (this.pWy == null || Bankcard.Ho(this.pWy.tuo)) {
                AppMethodBeat.o(46093);
                return false;
            }
            AppMethodBeat.o(46093);
            return true;
        } else if (this.tgC.cPf()) {
            AppMethodBeat.o(46093);
            return true;
        } else {
            AppMethodBeat.o(46093);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cOd() {
        AppMethodBeat.i(46094);
        mY(true);
        AppMethodBeat.o(46094);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mY(boolean z) {
        AppMethodBeat.i(46095);
        if (!z || cOj()) {
            int i;
            if (this.toH != null) {
                this.tpu = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(this.pWy);
                com.tencent.mm.plugin.wallet.a.j acU = this.tpu.acU(this.toH.tzb);
                if (acU != null && acU.tmT == 0.0d) {
                    i = 1;
                    if (this.tqb != null) {
                        if (this.tqb.tot == 0) {
                            ab.i(this.TAG, "need real name,stop");
                            b(this.tqb);
                            AppMethodBeat.o(46095);
                            return;
                        } else if (this.tqb.tot == 1 && i != 0) {
                            ab.i(this.TAG, "need real name, zero stop");
                            b(this.tqb);
                        }
                    }
                    if (this.tou != null) {
                        if (this.tou.tob == 1 && !bo.isNullOrNil(this.tou.nZb) && !bo.isNullOrNil(this.tou.nZc) && !bo.isNullOrNil(this.tou.toc)) {
                            if (!(this.pVL == null || this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0)) {
                                if (this.pVL.cIf == 8) {
                                    h.pYm.e(15368, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1), ((Commodity) this.pWy.tAq.get(0)).cAa);
                                } else {
                                    h.pYm.e(15368, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), ((Commodity) this.pWy.tAq.get(0)).cAa);
                                }
                            }
                            com.tencent.mm.ui.base.h.a(this.mController.ylL, this.tou.toc, "", this.tou.nZc, this.tou.nZb, false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(46037);
                                    ab.i(WalletPayUI.this.TAG, "click continue pay");
                                    if (!(WalletPayUI.this.pVL == null || WalletPayUI.this.pWy == null || WalletPayUI.this.pWy.tAq == null || WalletPayUI.this.pWy.tAq.size() <= 0)) {
                                        if (WalletPayUI.this.pVL.cIf == 8) {
                                            h.pYm.e(15368, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(3), ((Commodity) WalletPayUI.this.pWy.tAq.get(0)).cAa);
                                        } else {
                                            h.pYm.e(15368, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), ((Commodity) WalletPayUI.this.pWy.tAq.get(0)).cAa);
                                        }
                                    }
                                    WalletPayUI.g(WalletPayUI.this);
                                    AppMethodBeat.o(46037);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(46038);
                                    ab.i(WalletPayUI.this.TAG, "click cancel pay");
                                    if (!(WalletPayUI.this.pVL == null || WalletPayUI.this.pWy == null || WalletPayUI.this.pWy.tAq == null || WalletPayUI.this.pWy.tAq.size() <= 0)) {
                                        if (WalletPayUI.this.pVL.cIf == 8) {
                                            h.pYm.e(15368, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), ((Commodity) WalletPayUI.this.pWy.tAq.get(0)).cAa);
                                        } else {
                                            h.pYm.e(15368, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2), ((Commodity) WalletPayUI.this.pWy.tAq.get(0)).cAa);
                                        }
                                    }
                                    WalletPayUI.this.finish();
                                    AppMethodBeat.o(46038);
                                }
                            });
                            AppMethodBeat.o(46095);
                            return;
                        } else if (!(this.tou.tob != 2 || bo.isNullOrNil(this.tou.toc) || bo.isNullOrNil(this.tou.tod))) {
                            ab.i(this.TAG, "pay has been blocked");
                            if (!(this.pVL == null || this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0)) {
                                if (this.pVL.cIf == 8) {
                                    h.pYm.e(15368, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), ((Commodity) this.pWy.tAq.get(0)).cAa);
                                } else {
                                    h.pYm.e(15368, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), ((Commodity) this.pWy.tAq.get(0)).cAa);
                                }
                            }
                            com.tencent.mm.ui.base.h.a(this.mController.ylL, this.tou.toc, "", this.tou.tod, false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(46039);
                                    WalletPayUI.this.finish();
                                    AppMethodBeat.o(46039);
                                }
                            });
                            AppMethodBeat.o(46095);
                            return;
                        }
                    }
                    cOe();
                    AppMethodBeat.o(46095);
                    return;
                }
            }
            i = 0;
            if (this.tqb != null) {
            }
            if (this.tou != null) {
            }
            cOe();
            AppMethodBeat.o(46095);
            return;
        }
        AppMethodBeat.o(46095);
    }

    /* JADX WARNING: Missing block: B:12:0x0080, code skipped:
            if (r2.tmT == 0.0d) goto L_0x0082;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cOe() {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.i(46096);
        h.pYm.e(13958, Integer.valueOf(1));
        if (this.pVL != null && 8 == this.pVL.cIf) {
            h.pYm.e(13955, Integer.valueOf(2));
            if (this.pVL.vwh != null) {
                long j = this.pVL.vwh.getLong("extinfo_key_9");
                h.pYm.e(13956, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - j));
            }
        }
        if (this.toH != null) {
            this.tpu = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(this.pWy);
            com.tencent.mm.plugin.wallet.a.j acU = this.tpu.acU(this.toH.tzb);
            if (acU != null) {
            }
        }
        i = 0;
        if (i != 0) {
            s.cNC();
            if (s.cND().cQh()) {
                ab.i(this.TAG, "payWithoutPassword zeroPay");
                if (this.pVL != null) {
                    i2 = this.pVL.cIf;
                }
                com.tencent.mm.wallet_core.c.ad.e(i2, this.pVL == null ? "" : this.pVL.czZ, 3, "");
                cOf();
                AppMethodBeat.o(46096);
                return;
            }
            ab.i(this.TAG, "has useful bankcard ! payWithOldBankcard zeroPay");
            cNQ();
            AppMethodBeat.o(46096);
        } else if (this.tpz) {
            ab.i(this.TAG, "hy: start do pay with force use given bankcard");
            if (bo.isNullOrNil(this.tpA)) {
                s.cNC();
                if (s.cND().cQi()) {
                    com.tencent.mm.wallet_core.c.ad.e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 17, "");
                } else {
                    s.cNC();
                    if (s.cND().cQh()) {
                        com.tencent.mm.wallet_core.c.ad.e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 5, "");
                    }
                }
                b(false, 0, "");
                AppMethodBeat.o(46096);
                return;
            }
            this.tgC = cOh();
            cNQ();
            AppMethodBeat.o(46096);
        } else {
            String bc = bo.bc(getIntent().getStringExtra("key_is_use_default_card"), "");
            if (!bo.isNullOrNil(bc)) {
                this.tgC = acu(bc);
            }
            if (this.tgC != null) {
                i = this.tgC.a(this.pWy.tuo, this.pWy);
                if (this.pQU != null) {
                    this.pQU.bs(10002, "");
                }
                if (i != 0) {
                    ab.i(this.TAG, "main bankcard(" + i + ") is useless! jump to select bankcard!");
                    c(false, i, "");
                    AppMethodBeat.o(46096);
                    return;
                }
                s.cNC();
                if (s.cND().cQh()) {
                    ab.i(this.TAG, "payWithoutPassword");
                    if (this.pVL != null) {
                        i2 = this.pVL.cIf;
                    }
                    com.tencent.mm.wallet_core.c.ad.e(i2, this.pVL == null ? "" : this.pVL.czZ, 3, "");
                    cOf();
                    AppMethodBeat.o(46096);
                    return;
                }
                ab.i(this.TAG, "has useful bankcard ! payWithOldBankcard");
                cNQ();
                AppMethodBeat.o(46096);
            } else if (this.tgB == null || this.tgB.size() <= 0) {
                ab.i(this.TAG, "default bankcard not found! payWithNewBankcard");
                s.cNC();
                if (s.cND().cQi()) {
                    com.tencent.mm.wallet_core.c.ad.e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 17, "");
                } else {
                    s.cNC();
                    if (s.cND().cQh()) {
                        com.tencent.mm.wallet_core.c.ad.e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 5, "");
                    }
                }
                b(false, 0, "");
                AppMethodBeat.o(46096);
            } else {
                ab.i(this.TAG, " no last pay bankcard ! jump to select bankcard!");
                c(false, 8, "");
                AppMethodBeat.o(46096);
            }
        }
    }

    private void cOf() {
        AppMethodBeat.i(46097);
        na(true);
        com.tencent.mm.plugin.wallet_core.utils.d.cSP();
        AppMethodBeat.o(46097);
    }

    private boolean cNG() {
        AppMethodBeat.i(138087);
        int intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_FORCE_USE_NEW_CASHIER_INT_SYNC, Integer.valueOf(0))).intValue();
        if (com.tencent.mm.sdk.a.b.dnO() || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_PURPLE) {
            intValue = 1;
        }
        if (intValue == 1 || (this.pWy != null && this.pWy.tAN == 1)) {
            AppMethodBeat.o(138087);
            return true;
        }
        AppMethodBeat.o(138087);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void cNQ() {
        AppMethodBeat.i(46098);
        mZ(false);
        AppMethodBeat.o(46098);
    }

    /* Access modifiers changed, original: protected|final */
    public final void mZ(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(46099);
        if (arW()) {
            int i;
            String str;
            this.toK = false;
            ab.i(this.TAG, "pay with old bankcard! from statck %s", bo.dpG().toString());
            if (this.pVL == null) {
                i = 0;
            } else {
                i = this.pVL.cIf;
            }
            if (this.pVL == null) {
                str = "";
            } else {
                str = this.pVL.czZ;
            }
            com.tencent.mm.wallet_core.c.ad.e(i, str, 8, "");
            if (this.tpP != null) {
                ab.w(this.TAG, "close previous cashier dialog");
                this.tpP.dismiss();
            }
            this.toK = false;
            if (cNG()) {
                this.tpP = new com.tencent.mm.plugin.wallet_core.ui.cashier.b(this.mController.ylL);
                com.tencent.mm.plugin.wallet_core.ui.cashier.b bVar = (com.tencent.mm.plugin.wallet_core.ui.cashier.b) this.tpP;
                PayInfo payInfo = this.pVL;
                Orders orders = this.pWy;
                FavorPayInfo favorPayInfo = this.toH;
                Bankcard bankcard = this.tgC;
                if (!this.tpz) {
                    z2 = true;
                }
                bVar.a(payInfo, orders, favorPayInfo, bankcard, z2, z);
                bVar.tMA = new com.tencent.mm.plugin.wallet_core.ui.cashier.b.a() {
                    public final void a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard) {
                        AppMethodBeat.i(46040);
                        if (WalletPayUI.this.toK) {
                            ab.w(WalletPayUI.this.TAG, "has received canceled");
                            h.pYm.k(965, 3, 1);
                            AppMethodBeat.o(46040);
                            return;
                        }
                        WalletPayUI.this.tqi = true;
                        WalletPayUI.this.aqX();
                        WalletPayUI.this.toH = favorPayInfo;
                        WalletPayUI.this.tgC = bankcard;
                        String str2 = WalletPayUI.this.TAG;
                        String str3 = "WalletPwdDialog showAlert with favinfo %s";
                        Object[] objArr = new Object[1];
                        objArr[0] = WalletPayUI.this.toH == null ? "" : WalletPayUI.this.toH.toString();
                        ab.i(str2, str3, objArr);
                        if (!bo.isNullOrNil(str)) {
                            com.tencent.mm.wallet_core.c.ad.e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 9, "");
                        }
                        WalletPayUI.this.gHr = str;
                        WalletPayUI.this.na(false);
                        com.tencent.mm.plugin.wallet_core.utils.d.cSP();
                        AppMethodBeat.o(46040);
                    }

                    public final void onCancel() {
                        AppMethodBeat.i(46041);
                        ab.i(WalletPayUI.this.TAG, "cashier dialog canceled");
                        WalletPayUI.this.toK = true;
                        com.tencent.mm.wallet_core.c.ad.e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 10, "");
                        if (WalletPayUI.this.bwP()) {
                            WalletPayUI.this.finish();
                        }
                        AppMethodBeat.o(46041);
                    }

                    public final void cMN() {
                        AppMethodBeat.i(46042);
                        ab.i(WalletPayUI.this.TAG, "click add new bankcard");
                        com.tencent.mm.plugin.wallet_core.model.g cPl = com.tencent.mm.plugin.wallet_core.model.g.cPl();
                        if (cPl.aFF()) {
                            com.tencent.mm.ui.base.h.b(WalletPayUI.this.mController.ylL, cPl.pbp, WalletPayUI.this.getString(R.string.tz), true);
                            AppMethodBeat.o(46042);
                            return;
                        }
                        com.tencent.mm.wallet_core.c.ad.e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 14, "");
                        WalletPayUI.this.cOg();
                        AppMethodBeat.o(46042);
                    }
                };
                bVar.show();
                addDialog(bVar);
                AppMethodBeat.o(46099);
                return;
            }
            boolean z3;
            if (this.tpz) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.tpP = q.a(this, z3, this.pWy, this.toH, this.tgC, this.pVL, this.pRx, new q.c() {
                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    AppMethodBeat.i(46043);
                    if (WalletPayUI.this.toK) {
                        ab.w(WalletPayUI.this.TAG, "has received canceled");
                        h.pYm.k(965, 3, 1);
                        AppMethodBeat.o(46043);
                        return;
                    }
                    WalletPayUI.this.tqi = true;
                    WalletPayUI.this.aqX();
                    WalletPayUI.this.toH = favorPayInfo;
                    String str2 = WalletPayUI.this.TAG;
                    String str3 = "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = WalletPayUI.this.toH == null ? "" : WalletPayUI.this.toH.toString();
                    objArr[1] = Boolean.valueOf(z);
                    ab.i(str2, str3, objArr);
                    if (WalletPayUI.this.toH != null && z) {
                        WalletPayUI.this.ap(-100, true);
                    }
                    if (!bo.isNullOrNil(str)) {
                        com.tencent.mm.wallet_core.c.ad.e(WalletPayUI.this.pVL == null ? 0 : WalletPayUI.this.pVL.cIf, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 9, "");
                    }
                    WalletPayUI.this.gHr = str;
                    WalletPayUI.this.na(false);
                    com.tencent.mm.plugin.wallet_core.utils.d.cSP();
                    WalletPayUI.this.toJ = null;
                    AppMethodBeat.o(46043);
                }
            }, new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(46044);
                    ab.i(WalletPayUI.this.TAG, "WalletPwdDialog event1 %s", bo.dpG().toString());
                    WalletPayUI.this.toH = (FavorPayInfo) view.getTag();
                    if (WalletPayUI.this.toH != null) {
                        WalletPayUI.this.toH.tzf = "";
                    }
                    WalletPayUI.this.c(false, 0, "");
                    WalletPayUI.this.tpP.dismiss();
                    WalletPayUI.this.gHr = null;
                    WalletPayUI.this.tpP = null;
                    WalletPayUI.this.toJ = null;
                    AppMethodBeat.o(46044);
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    int i = 0;
                    AppMethodBeat.i(46045);
                    ab.i(WalletPayUI.this.TAG, "WalletPwdDialog event2 %s", bo.dpG().toString());
                    WalletPayUI.this.Ahw = 4;
                    WalletPayUI.this.toK = true;
                    if (WalletPayUI.this.pVL != null) {
                        i = WalletPayUI.this.pVL.cIf;
                    }
                    com.tencent.mm.wallet_core.c.ad.e(i, WalletPayUI.this.pVL == null ? "" : WalletPayUI.this.pVL.czZ, 10, "");
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    WalletPayUI.this.gHr = null;
                    WalletPayUI.this.tpP = null;
                    if (WalletPayUI.this.bwP()) {
                        WalletPayUI.this.finish();
                    }
                    WalletPayUI.this.toJ = null;
                    AppMethodBeat.o(46045);
                }
            });
            this.toJ = (d) this.tpP;
            AppMethodBeat.o(46099);
            return;
        }
        AppMethodBeat.o(46099);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(boolean z, int i, String str) {
        AppMethodBeat.i(46100);
        String str2 = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
        s.cNC();
        ab.d(str2, stringBuilder.append(s.cND().cQg()).append(", need confirm ? ").append(z).toString());
        if (z) {
            String Y;
            if (bo.isNullOrNil(str)) {
                Y = Bankcard.Y(this, i);
            } else {
                Y = str;
            }
            com.tencent.mm.ui.base.h.d(this, Y, "", getString(R.string.fnt), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(46046);
                    WalletPayUI.this.cOg();
                    AppMethodBeat.o(46046);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(46049);
                    if (WalletPayUI.this.bwP()) {
                        WalletPayUI.this.finish();
                    }
                    AppMethodBeat.o(46049);
                }
            });
            AppMethodBeat.o(46100);
            return;
        }
        cOg();
        AppMethodBeat.o(46100);
    }

    public final void c(boolean z, final int i, String str) {
        AppMethodBeat.i(46101);
        ab.d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(z)));
        if (z) {
            String Y;
            if (bo.isNullOrNil(str)) {
                Y = Bankcard.Y(this, i);
            } else {
                Y = str;
            }
            com.tencent.mm.ui.base.h.d(this, Y, "", getString(R.string.fob), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(46050);
                    if (WalletPayUI.l(WalletPayUI.this)) {
                        WalletPayUI.this.mZ(true);
                        AppMethodBeat.o(46050);
                        return;
                    }
                    WalletPayUI.this.ap(i, false);
                    AppMethodBeat.o(46050);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(46051);
                    if (WalletPayUI.this.bwP()) {
                        WalletPayUI.this.finish();
                    }
                    AppMethodBeat.o(46051);
                }
            });
            AppMethodBeat.o(46101);
        } else if (cNG()) {
            mZ(true);
            AppMethodBeat.o(46101);
        } else {
            ap(i, false);
            AppMethodBeat.o(46101);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cOg() {
        AppMethodBeat.i(46102);
        Bundle extras = getIntent().getExtras();
        String str = "key_pay_flag";
        s.cNC();
        extras.putInt(str, s.cND().cQg() ? 2 : 1);
        extras.putParcelable("key_orders", this.pWy);
        extras.putParcelable("key_pay_info", this.pVL);
        extras.putParcelable("key_favor_pay_info", this.toH);
        Q(extras);
        AppMethodBeat.o(46102);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ap(int i, boolean z) {
        String str;
        int i2 = 0;
        AppMethodBeat.i(46103);
        h.pYm.e(13958, Integer.valueOf(2));
        h.pYm.e(13955, Integer.valueOf(4));
        if (this.pVL != null) {
            i2 = this.pVL.cIf;
        }
        if (this.pVL == null) {
            str = "";
        } else {
            str = this.pVL.czZ;
        }
        com.tencent.mm.wallet_core.c.ad.e(i2, str, 11, "");
        Bundle bundle = this.mBundle;
        bundle.putInt("key_main_bankcard_state", i);
        bundle.putParcelable("key_orders", this.pWy);
        bundle.putParcelable("key_pay_info", this.pVL);
        bundle.putParcelable("key_authen", cOb());
        bundle.putString("key_pwd1", this.gHr);
        bundle.putInt("key_pay_flag", 3);
        bundle.putInt("key_err_code", -1004);
        bundle.putParcelable("key_favor_pay_info", this.toH);
        bundle.putBoolean("key_is_filter_bank_type", z);
        if (this.tgC != null) {
            bundle.putString("key_is_cur_bankcard_bind_serial", this.tgC.field_bindSerial);
        }
        Q(bundle);
        AppMethodBeat.o(46103);
    }

    private void a(f fVar) {
        h hVar;
        Object[] objArr;
        AppMethodBeat.i(46104);
        ab.i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", fVar.cRb, Integer.valueOf(fVar.tot));
        if ("1".equals(fVar.cRb) || "2".equals(fVar.cRb)) {
            this.tqb = fVar;
        } else {
            this.tqb = null;
        }
        this.tou = fVar.tou;
        this.tpZ = true;
        this.pWy = fVar.pWy;
        this.mCount = this.pWy != null ? this.pWy.tAq.size() : 0;
        ab.d(this.TAG, "get mOrders! bankcardTag : " + (this.pWy != null ? Integer.valueOf(this.pWy.tuo) : ""));
        arW();
        if (!(this.pWy == null || this.pWy.tAr == null)) {
            this.tpu = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(this.pWy);
            if (this.tpu != null) {
                if (this.tpu.cRl().size() > 0) {
                    this.tpv = true;
                }
                this.toH = this.tpu.acX(this.pWy.tAr.tmU);
                this.toH.tzb = this.tpu.acY(this.toH.tzb);
                ab.i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", this.pWy.tAr.tmU, this.toH.tzb, this.toH.tzb, this.toH.toString());
            }
        }
        if (!(this.pWy == null || this.tgB == null || this.pVL == null)) {
            com.tencent.mm.plugin.wallet_core.utils.d.a(this.pVL, this.pWy);
            hVar = h.pYm;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(this.pVL.cIf);
            objArr[1] = Integer.valueOf(0);
            s.cNC();
            objArr[2] = Integer.valueOf(s.cND().cQg() ? 2 : 1);
            objArr[3] = Integer.valueOf((int) (this.pWy.pTN * 100.0d));
            objArr[4] = this.pWy.pcl;
            hVar.e(10690, objArr);
        }
        if (!(this.pWy == null || this.pWy.tAq == null)) {
            LinkedList linkedList = new LinkedList();
            for (Commodity commodity : this.pWy.tAq) {
                linkedList.add(commodity.cAa);
            }
            if (linkedList.size() > 0) {
                uu uuVar = new uu();
                uuVar.cRC.cRE = linkedList;
                com.tencent.mm.sdk.b.a.xxA.m(uuVar);
                if (this.pQU != null) {
                    this.pQU.bs(10001, (String) linkedList.get(0));
                }
            }
        }
        if (!(this.pWy == null || this.pWy.tAO == null || this.pWy.tAO.tBL != 1 || bo.isNullOrNil(this.pWy.tAO.pbo))) {
            this.tpz = true;
            this.tpA = this.pWy.tAO.pbo;
        }
        s.cNC();
        this.tgB = s.cND().ng(cOk());
        if (bo.isNullOrNil(this.tpA)) {
            s.cNC();
            this.tgC = s.cND().a(null, null, cOk(), false);
        } else {
            this.tgC = cOh();
        }
        String bc = bo.bc(getIntent().getStringExtra("key_is_use_default_card"), "");
        if (!bo.isNullOrNil(bc)) {
            this.tgC = acu(bc);
        }
        this.pTi.setClickable(true);
        if (bo.isNullOrNil(r.cPI().tDg)) {
            this.tpL.setVisibility(8);
            this.tpL.setText("");
        } else {
            this.tpL.setVisibility(0);
            this.tpL.setText(r.cPI().tDg);
        }
        if (!(this.pWy == null || this.tgB == null || this.pVL == null)) {
            com.tencent.mm.plugin.wallet_core.utils.d.a(this.pVL, this.pWy);
            hVar = h.pYm;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(this.pVL.cIf);
            objArr[1] = Integer.valueOf(0);
            s.cNC();
            objArr[2] = Integer.valueOf(s.cND().cQg() ? 2 : 1);
            objArr[3] = Integer.valueOf((int) (this.pWy.pTN * 100.0d));
            objArr[4] = this.pWy.pcl;
            hVar.e(10690, objArr);
        }
        if (this.tpU) {
            ap(0, false);
        }
        long j = cOl().vwh == null ? 0 : cOl().vwh.getLong("wallet_pay_key_check_time");
        if (j > 0) {
            h.pYm.a(641, 4, 1, true);
            h.pYm.a(641, 5, bo.gb(j), true);
        }
        if (this.tqh > 0) {
            h.pYm.a(641, 7, 1, true);
            h.pYm.a(641, 8, bo.gb(this.tqh), true);
        }
        AppMethodBeat.o(46104);
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46105);
        ab.i(this.TAG, "errorType %s errCode %s, errmsg %s, scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        com.tencent.mm.plugin.wallet.pay.a.a.b bVar;
        Bundle bundle;
        Bundle bundle2;
        boolean z;
        if (i == 0 && i2 == 0) {
            if (mVar instanceof f) {
                this.Ahw = 1;
                this.tpt = (f) mVar;
                final f fVar = (f) mVar;
                if (fVar.bLD()) {
                    final com.tencent.mm.wallet_core.c.k kVar = fVar.nYe;
                    kVar.a((Activity) this, new com.tencent.mm.wallet_core.c.e() {
                        public final void onCancel() {
                            AppMethodBeat.i(46052);
                            if (kVar.dNM()) {
                                WalletPayUI.a(WalletPayUI.this, fVar);
                                AppMethodBeat.o(46052);
                                return;
                            }
                            WalletPayUI.this.finish();
                            AppMethodBeat.o(46052);
                        }

                        public final void cMX() {
                            AppMethodBeat.i(46053);
                            if (kVar.dNM()) {
                                WalletPayUI.a(WalletPayUI.this, fVar);
                                AppMethodBeat.o(46053);
                                return;
                            }
                            WalletPayUI.this.cNX();
                            AppMethodBeat.o(46053);
                        }

                        public final void cMY() {
                            AppMethodBeat.i(46054);
                            if (kVar.dNM()) {
                                WalletPayUI.a(WalletPayUI.this, fVar);
                                AppMethodBeat.o(46054);
                                return;
                            }
                            WalletPayUI.this.finish();
                            AppMethodBeat.o(46054);
                        }
                    });
                    AppMethodBeat.o(46105);
                    return true;
                }
                a(fVar);
            } else if (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                this.Ahw = 1;
                bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) mVar;
                this.tqi = false;
                bundle = this.mBundle;
                bundle.putParcelable("key_pay_info", this.pVL);
                bundle.putParcelable("key_bankcard", this.tgC);
                bundle.putString("key_bank_type", this.tgC.field_bankcardType);
                if (!bo.isNullOrNil(this.gHr)) {
                    bundle.putString("key_pwd1", this.gHr);
                }
                bundle.putString("kreq_token", bVar.token);
                bundle.putParcelable("key_authen", bVar.toh);
                bundle.putBoolean("key_need_verify_sms", !bVar.tof);
                bundle.putInt("key_can_verify_tail", bVar.tol);
                bundle.putString("key_verify_tail_wording", bVar.tom);
                bundle2 = this.mBundle;
                String str2 = "key_block_bind_new_card";
                if (bVar.ton == 1) {
                    z = true;
                } else {
                    z = false;
                }
                bundle2.putBoolean(str2, z);
                if (bo.isNullOrNil(bVar.toi)) {
                    bundle.putString("key_mobile", this.tgC.field_mobile);
                } else {
                    bundle.putString("key_mobile", bVar.toi);
                }
                bundle.putString("key_QADNA_URL", bVar.toj);
                if (bVar.tpw) {
                    if (this.pQU != null) {
                        this.pQU.bs(10003, "");
                        com.tencent.mm.plugin.wallet.a aVar = this.pQU;
                        h.pYm.e(13455, aVar.teR, Long.valueOf(System.currentTimeMillis()), aVar.teS);
                    }
                    bundle.putParcelable("key_orders", bVar.tog);
                    if (this.pVL != null) {
                        ab.i(this.TAG, "payscene %d", Integer.valueOf(this.pVL.cIf));
                        if (8 == this.pVL.cIf) {
                            g.RQ();
                            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                    }
                } else {
                    bundle.putParcelable("key_orders", this.pWy);
                }
                Bundle bundle3 = new Bundle();
                bundle3.putString("pwd", this.gHr);
                com.tencent.mm.pluginsdk.l lVar = (com.tencent.mm.pluginsdk.l) g.K(com.tencent.mm.pluginsdk.l.class);
                int i3 = 0;
                if (lVar.bxe()) {
                    i3 = 1;
                } else if (lVar.bxh()) {
                    i3 = 2;
                }
                bundle3.putInt("key_open_biometric_type", i3);
                lVar.a(bVar.cNJ(), true, bundle3);
                bundle.putInt("key_pay_flag", 3);
                RealnameGuideHelper realnameGuideHelper = bVar.oYc;
                if (realnameGuideHelper != null) {
                    bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                Q(bundle);
                AppMethodBeat.o(46105);
                return true;
            }
            cu();
            AppMethodBeat.o(46105);
            return true;
        }
        if (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
            this.tqi = false;
            bundle = new Bundle();
            bundle.putString("pwd", this.gHr);
            ((com.tencent.mm.pluginsdk.l) g.K(com.tencent.mm.pluginsdk.l.class)).a(this.pVL.tKd == 1, false, bundle);
            if (i2 == -1 || i2 == -500) {
                this.Ahw = 3;
            } else {
                this.Ahw = 2;
            }
            switch (i2) {
                case 402:
                case 403:
                case 408:
                    String string;
                    bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) mVar;
                    this.tpC = this.mBundle;
                    this.tpC.putParcelable("key_pay_info", this.pVL);
                    this.tpC.putParcelable("key_bankcard", this.tgC);
                    if (!bo.isNullOrNil(this.gHr)) {
                        this.tpC.putString("key_pwd1", this.gHr);
                    }
                    this.tpC.putString("kreq_token", bVar.token);
                    this.tpC.putParcelable("key_authen", bVar.toh);
                    this.tpC.putBoolean("key_need_verify_sms", !bVar.tof);
                    this.tpC.putString("key_mobile", this.tgC.field_mobile);
                    this.tpC.putInt("key_err_code", i2);
                    this.tpC.putParcelable("key_orders", this.pWy);
                    if (bo.isNullOrNil(str)) {
                        string = getString(R.string.fp0, new Object[]{this.tgC.field_desc, this.tgC.field_mobile});
                    } else {
                        string = str;
                    }
                    com.tencent.mm.ui.base.h.d(this, string, "", getString(R.string.foz), getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(46055);
                            WalletPayUI.this.tpC.putInt("key_pay_flag", 3);
                            WalletPayUI.this.Q(WalletPayUI.this.tpC);
                            AppMethodBeat.o(46055);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(46056);
                            if (WalletPayUI.this.bwP()) {
                                WalletPayUI.this.finish();
                            }
                            AppMethodBeat.o(46056);
                        }
                    });
                    AppMethodBeat.o(46105);
                    return true;
                case 404:
                    if (!(this.tgC == null || this.pWy == null)) {
                        this.tgC.twR = this.pWy.czZ;
                        if (this.tgB == null || this.tgB.size() <= 1) {
                            b(true, 4, str);
                        } else {
                            c(true, 4, str);
                        }
                        AppMethodBeat.o(46105);
                        return true;
                    }
                    break;
                case 100000:
                case 100001:
                case 100102:
                    this.pVL.vwi = i2;
                    cNQ();
                    AppMethodBeat.o(46105);
                    return true;
                case 100100:
                case 100101:
                    this.pVL.vwi = i2;
                    z = false;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.toI == null) {
                        this.toI = new a(this, this);
                    }
                    this.toI.a(z, this.pVL.cBS, this.pVL.czZ);
                    ab.i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(z)));
                    AppMethodBeat.o(46105);
                    return true;
            }
        } else if (mVar instanceof f) {
            this.tpZ = true;
            cOi();
            if (i2 == 416) {
                ab.e(this.TAG, "errCode is 416 need real name verify!");
                this.Ahw = 2;
                this.tpW = true;
                bundle2 = new Bundle();
                bundle2.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle2.putString("realname_verify_process_jump_plugin", "wallet");
                z = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, i2, mVar, bundle2, this.pVL != null ? this.pVL.cIf : 0);
                AppMethodBeat.o(46105);
                return z;
            }
            this.Ahw = 3;
            ab.i(this.TAG, "errCode is %d , not need real name verify!", Integer.valueOf(i2));
        }
        AppMethodBeat.o(46105);
        return false;
    }

    public final boolean bNf() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean arW() {
        AppMethodBeat.i(46106);
        String string;
        if (this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0) {
            ab.w(this.TAG, "mOrders info is Illegal!");
            if (this.tpt == null || !this.tpt.bLD()) {
                string = getString(R.string.fkw);
                if (!(this.tpt == null || bo.isNullOrNil(this.tpt.aIm))) {
                    string = this.tpt.aIm;
                }
                ab.i(this.TAG, "checkInfo() errMsg:%s", string);
                com.tencent.mm.ui.base.h.a(this.mController.ylL, string, "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(46057);
                        WalletPayUI.this.finish();
                        AppMethodBeat.o(46057);
                    }
                });
                AppMethodBeat.o(46106);
                return false;
            }
            AppMethodBeat.o(46106);
            return false;
        } else if (!this.tpz || bo.isNullOrNil(this.tpA) || cOh() != null) {
            AppMethodBeat.o(46106);
            return true;
        } else if (this.tpt == null || !this.tpt.bLD()) {
            ab.w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
            string = getString(R.string.fkw);
            if (!(this.tpt == null || bo.isNullOrNil(this.tpt.aIm))) {
                string = this.tpt.aIm;
            }
            ab.i(this.TAG, "checkInfo() errMsg:%s", string);
            com.tencent.mm.ui.base.h.a(this.mController.ylL, string, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(46058);
                    WalletPayUI.this.finish();
                    AppMethodBeat.o(46058);
                }
            });
            AppMethodBeat.o(46106);
            return false;
        } else {
            AppMethodBeat.o(46106);
            return false;
        }
    }

    private Bankcard cOh() {
        AppMethodBeat.i(46107);
        s.cNC();
        ArrayList nf = s.cND().nf(true);
        if (nf.size() != 0) {
            Iterator it = nf.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bo.nullAsNil(this.tpA).equals(bankcard.field_bindSerial)) {
                    ab.i(this.TAG, "hy: get given bankcard");
                    AppMethodBeat.o(46107);
                    return bankcard;
                }
            }
        }
        AppMethodBeat.o(46107);
        return null;
    }

    private Bankcard acu(String str) {
        AppMethodBeat.i(46108);
        s.cNC();
        ArrayList nf = s.cND().nf(true);
        if (nf.size() != 0) {
            Iterator it = nf.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bo.nullAsNil(str).equals(bankcard.field_bindSerial)) {
                    ab.i(this.TAG, "hy: get given bankcard");
                    AppMethodBeat.o(46108);
                    return bankcard;
                }
            }
        }
        AppMethodBeat.o(46108);
        return null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(46109);
        ab.i(this.TAG, "onAcvityResult requestCode:" + i + ", resultCode:" + i2);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    if (intent != null) {
                        this.tpY = intent.getIntExtra("auto_deduct_flag", -1);
                        this.pWy.tAv.tpY = this.tpY;
                        cOl().vwk = this.tpY;
                        if (this.tpY == 1) {
                            cOl().vwl = intent.getStringExtra("deduct_bank_type");
                            cOl().vwm = intent.getStringExtra("deduct_bind_serial");
                        }
                    }
                    this.tpX = true;
                    bwQ();
                } else {
                    finish();
                }
                h.pYm.e(13958, Integer.valueOf(3));
                AppMethodBeat.o(46109);
                return;
            case 1:
                this.tpP.dismiss();
                this.tpD = false;
                cNX();
                break;
        }
        AppMethodBeat.o(46109);
    }

    public final boolean bwQ() {
        int i;
        boolean z = false;
        AppMethodBeat.i(46110);
        ab.i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", Boolean.valueOf(this.tqc));
        com.tencent.mm.sdk.b.a.xxA.m(new ul());
        if (this.pWy == null || this.pWy.tAv == null || this.tpX) {
            boolean i2 = false;
        } else {
            i2 = 1;
        }
        if (i2 == 0 && !cOi()) {
            com.tencent.mm.wallet_core.c.ad.e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 2, "");
        }
        if (this.tqc) {
            mY(true);
            z = true;
        } else if (this.tpW) {
            z = true;
        } else if (i2 != 0) {
            Intent intent = new Intent(this, WalletPayDeductUI.class);
            intent.putExtra("orders", this.pWy);
            startActivityForResult(intent, 0);
            z = true;
        } else if (this.mController.contentView.getVisibility() != 0) {
            if (!this.tpD && arW()) {
                mY(true);
                this.tpD = true;
            }
            z = true;
        } else if (!(this.mController.contentView.getVisibility() != 0 || this.pWy == null || this.pWy.tAv == null || !this.pTi.isEnabled() || this.tqa)) {
            this.pTi.performClick();
            this.tqa = true;
        }
        AppMethodBeat.o(46110);
        return z;
    }

    public final boolean bwP() {
        AppMethodBeat.i(46111);
        if (this.tpZ) {
            String str = this.TAG;
            String str2 = "case 1 %s,  stack %s";
            Object[] objArr = new Object[2];
            boolean z = cOl() == null || !cOl().mXg;
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = bo.dpG().toString();
            ab.i(str, str2, objArr);
            str = this.TAG;
            str2 = "case 2 %s,";
            objArr = new Object[1];
            s.cNC();
            if (s.cND().cQg()) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.d(str, str2, objArr);
            str = this.TAG;
            str2 = "case 3 mBankcardList %s, mDefaultBankcard %s";
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.tgB == null ? 0 : this.tgB.size());
            objArr[1] = this.tgC == null ? "" : this.tgC.field_forbidWord;
            ab.d(str, str2, objArr);
            if (cOl() == null || !cOl().mXg) {
                ab.i(this.TAG, "get isTransparent1");
                AppMethodBeat.o(46111);
                return false;
            }
            s.cNC();
            if (!s.cND().cQg()) {
                ab.i(this.TAG, "get isTransparent2");
                AppMethodBeat.o(46111);
                return false;
            } else if (this.tgB == null || (this.tgB.size() != 0 && (this.tgC == null || bo.isNullOrNil(this.tgC.field_forbidWord)))) {
                ab.i(this.TAG, "get isTransparent4");
                AppMethodBeat.o(46111);
                return true;
            } else {
                str = this.TAG;
                str2 = "get isTransparent3 1 %s 2 %s";
                objArr = new Object[2];
                if (this.tgB == null || this.tgB.size() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[0] = Boolean.valueOf(z);
                z = (this.tgC == null || bo.isNullOrNil(this.tgC.field_forbidWord)) ? false : true;
                objArr[1] = Boolean.valueOf(z);
                ab.i(str, str2, objArr);
                AppMethodBeat.o(46111);
                return false;
            }
        }
        ab.i(this.TAG, "get isTransparent5");
        AppMethodBeat.o(46111);
        return true;
    }

    private boolean cOi() {
        AppMethodBeat.i(46112);
        if (bwP()) {
            AM(4);
            ae.m(this, 0);
            AppMethodBeat.o(46112);
            return false;
        }
        AM(0);
        ae.m(this, this.mController.dyj());
        AppMethodBeat.o(46112);
        return true;
    }

    public final boolean cNR() {
        return true;
    }

    public final void wU(int i) {
        AppMethodBeat.i(46113);
        if (i == 0) {
            if (bwP()) {
                finish();
                AppMethodBeat.o(46113);
                return;
            }
        } else if (i == 1) {
            cNQ();
        }
        AppMethodBeat.o(46113);
    }

    /* Access modifiers changed, original: protected */
    public void na(boolean z) {
        AppMethodBeat.i(46114);
        m a = com.tencent.mm.plugin.wallet.pay.a.a.a(cOb(), this.pWy, z);
        if (this.pWy != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_reqKey", this.pWy.czZ);
            if (this.pWy.tAq != null && this.pWy.tAq.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.pWy.tAq.get(0)).cAa);
            }
            bundle.putLong("key_SessionId", this.tpQ);
            a.eHT = "PayProcess";
            a.mBundle = bundle;
        }
        if (this.pVL != null) {
            if (this.pVL.cIf == 6 && this.pVL.vwe == 100) {
                a.gOW = 100;
            } else {
                a.gOW = this.pVL.cIf;
            }
        }
        a(a, true, true);
        if (!(this.pVL == null || 8 != this.pVL.cIf || this.pVL.vwh == null)) {
            long j = this.pVL.vwh.getLong("extinfo_key_9");
            h.pYm.e(13956, Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - j));
        }
        AppMethodBeat.o(46114);
    }

    private boolean cOj() {
        AppMethodBeat.i(46115);
        if (this.pWy != null && this.pWy.tAi) {
            g.RQ();
            if (((Boolean) g.RP().Ry().get(196614, Boolean.TRUE)).booleanValue()) {
                View inflate = getLayoutInflater().inflate(R.layout.b5m, null);
                final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ff8);
                en(inflate);
                ((TextView) inflate.findViewById(R.id.bn0)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(46059);
                        checkBox.setChecked(!checkBox.isChecked());
                        AppMethodBeat.o(46059);
                    }
                });
                final com.tencent.mm.ui.widget.a.c a = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.foy), inflate, getString(R.string.fcv), getString(R.string.frg), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(46060);
                        if (checkBox.isChecked()) {
                            g.RQ();
                            g.RP().Ry().set(196614, Boolean.FALSE);
                        }
                        WalletPayUI.this.mY(false);
                        AppMethodBeat.o(46060);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(46062);
                        WalletPayUI.this.finish();
                        AppMethodBeat.o(46062);
                    }
                });
                a.setCancelable(false);
                checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        AppMethodBeat.i(46063);
                        Button button = a.getButton(-2);
                        if (z) {
                            button.setEnabled(false);
                            AppMethodBeat.o(46063);
                            return;
                        }
                        button.setEnabled(true);
                        AppMethodBeat.o(46063);
                    }
                });
                AppMethodBeat.o(46115);
                return false;
            }
        }
        AppMethodBeat.o(46115);
        return true;
    }

    private void en(View view) {
        AppMethodBeat.i(46116);
        TextView textView = (TextView) view.findViewById(R.id.dhn);
        textView.setText(Html.fromHtml(String.format(getResources().getString(R.string.fow), new Object[]{getResources().getString(R.string.f87)})));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(46116);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cOk() {
        return (this.pVL == null || this.pVL.cIf == 11) ? false : true;
    }

    /* Access modifiers changed, original: protected|final */
    public final PayInfo cOl() {
        AppMethodBeat.i(46117);
        if (this.pVL == null) {
            this.pVL = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        PayInfo payInfo = this.pVL;
        AppMethodBeat.o(46117);
        return payInfo;
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    public void Q(Bundle bundle) {
        AppMethodBeat.i(46118);
        this.tpx = true;
        if (this.pWy != null) {
            bundle.putInt("key_support_bankcard", this.pWy.tuo);
            bundle.putString("key_reqKey", this.pWy.czZ);
            if (this.pWy.tAq != null && this.pWy.tAq.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.pWy.tAq.get(0)).cAa);
            }
            bundle.putLong("key_SessionId", this.tpQ);
        }
        if (this.pVL != null) {
            bundle.putInt("key_scene", this.pVL.cIf);
        }
        bundle.putBoolean("key_is_oversea", !cOc());
        bundle.putInt("is_deduct_open", this.tpY);
        this.tpy = new com.tencent.mm.wallet_core.c.a() {
            public final Intent n(int i, Bundle bundle) {
                AppMethodBeat.i(46064);
                ab.i(WalletPayUI.this.TAG, "pay process end");
                WalletPayUI.this.tpx = false;
                Intent intent = new Intent();
                AppMethodBeat.o(46064);
                return intent;
            }
        };
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.pay.b.class, bundle, this.tpy);
        AppMethodBeat.o(46118);
    }

    public final void c(boolean z, String str, String str2) {
        AppMethodBeat.i(46119);
        ab.i(this.TAG, "onGenFinish callback");
        if (z) {
            ab.i(this.TAG, "onGenFinish callback, result.isSuccess is true");
            this.pVL.cBU = str;
            this.pVL.cBV = str2;
            na(false);
            com.tencent.mm.plugin.wallet_core.utils.d.cSP();
            AppMethodBeat.o(46119);
            return;
        }
        ab.e(this.TAG, "onGenFinish callback, result.isSuccess is false");
        na(false);
        com.tencent.mm.plugin.wallet_core.utils.d.cSP();
        AppMethodBeat.o(46119);
    }

    public void onPause() {
        AppMethodBeat.i(46120);
        super.onPause();
        if (this.toJ != null) {
            this.toJ.onActivityPause();
        }
        AppMethodBeat.o(46120);
    }

    private boolean b(f fVar) {
        int i = 0;
        AppMethodBeat.i(46121);
        boolean a;
        if ("1".equals(fVar.cRb)) {
            ab.i(this.TAG, "need realname verify");
            this.tpW = true;
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
            bundle.putString("realname_verify_process_jump_plugin", "wallet");
            bwP();
            if (this.pVL != null) {
                i = this.pVL.cIf;
            }
            a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, null, i);
            AppMethodBeat.o(46121);
            return a;
        } else if ("2".equals(fVar.cRb)) {
            ab.i(this.TAG, "need upload credit");
            a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, fVar.cRc, fVar.cRf, fVar.cRd, fVar.cRe, bwP(), null);
            AppMethodBeat.o(46121);
            return a;
        } else {
            ab.i(this.TAG, "realnameGuideFlag =  " + fVar.cRb);
            AppMethodBeat.o(46121);
            return false;
        }
    }

    static /* synthetic */ void f(WalletPayUI walletPayUI) {
        boolean z;
        AppMethodBeat.i(46123);
        Bundle bundle = new Bundle();
        if (walletPayUI.pWy != null) {
            bundle.putString("key_reqKey", walletPayUI.pWy.czZ);
            if (walletPayUI.pWy.tAq != null && walletPayUI.pWy.tAq.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) walletPayUI.pWy.tAq.get(0)).cAa);
            }
            bundle.putLong("key_SessionId", walletPayUI.tpQ);
        }
        if (walletPayUI.pVL != null) {
            bundle.putInt("key_scene", walletPayUI.pVL.cIf);
        }
        if (walletPayUI.pVL == null || walletPayUI.pVL.cIf != 11) {
            bundle.putInt("key_bind_scene", 0);
        } else {
            bundle.putInt("key_bind_scene", 13);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        String str = "key_is_oversea";
        if (walletPayUI.cOc()) {
            z = false;
        } else {
            z = true;
        }
        bundle.putBoolean(str, z);
        com.tencent.mm.wallet_core.a.a((Activity) walletPayUI, com.tencent.mm.plugin.wallet.pay.a.class, bundle, null);
        AppMethodBeat.o(46123);
    }
}
