package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.e;
import com.tencent.mm.plugin.wallet_core.ui.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletPayDeductUI extends MMPreference implements OnClickListener, f {
    protected Button gHn;
    private Dialog gII = null;
    protected com.tencent.mm.ui.base.preference.f iFE;
    private String kdE;
    private LinearLayout nrC;
    protected MMSwitchBtn omp;
    protected Orders pWy;
    protected ArrayList<Preference> tpd;
    protected TextView tpe;
    private TextView tpf;
    private TextView tpg;
    private String tph;
    private String tpi;
    private Bankcard tpj;
    protected boolean tpk = false;
    private int tpl = 0;
    private String tpm;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(WalletPayDeductUI walletPayDeductUI) {
        AppMethodBeat.i(46033);
        walletPayDeductUI.cNU();
        AppMethodBeat.o(46033);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46022);
        super.onCreate(bundle);
        this.iFE = this.yCw;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.a69)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.id.p3);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.a3p));
            }
            customView = customView.findViewById(16908309);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(R.color.a69));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(j.INVALID_ID);
            if (d.iW(23)) {
                window.setStatusBarColor(getResources().getColor(R.color.a4d));
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        Intent intent = getIntent();
        if (intent == null) {
            ab.e("MicroMsg.WalletPayDeductUI", "intent is null");
            finish();
            AppMethodBeat.o(46022);
            return;
        }
        this.pWy = (Orders) intent.getParcelableExtra("orders");
        if (this.pWy == null || this.pWy.tAv == null) {
            ab.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.pWy);
            finish();
        }
        dP(this.pWy.tAv.tBe);
        setResult(0);
        setBackBtn(new t() {
            public final void Kp() {
                AppMethodBeat.i(46017);
                WalletPayDeductUI.this.setResult(0);
                WalletPayDeductUI.this.finish();
                AppMethodBeat.o(46017);
            }
        }, R.raw.actionbar_icon_dark_back);
        g.RQ();
        g.RO().eJo.a(385, (f) this);
        initView();
        AppMethodBeat.o(46022);
    }

    public void onResume() {
        AppMethodBeat.i(46023);
        super.onResume();
        AppMethodBeat.o(46023);
    }

    public void onDestroy() {
        AppMethodBeat.i(46024);
        super.onDestroy();
        g.RQ();
        g.RO().eJo.b(385, (f) this);
        AppMethodBeat.o(46024);
    }

    public final int JC() {
        return -1;
    }

    private void cNU() {
        AppMethodBeat.i(46026);
        s.cNC();
        ak cND = s.cND();
        if (this.tpj == null) {
            this.tpj = cND.a(null, null, true, true, true);
        }
        if (this.tpj == null) {
            ab.i("MicroMsg.WalletPayDeductUI", "no bank card!");
            finish();
            AppMethodBeat.o(46026);
            return;
        }
        SpannableString spannableString = new SpannableString(this.tpj.field_desc);
        com.tencent.mm.plugin.wallet_core.ui.j jVar = new com.tencent.mm.plugin.wallet_core.ui.j(this.mController.ylL);
        final List cPS = ac.cPS();
        jVar.tHw = new a() {
            public final void onClick(View view) {
                AppMethodBeat.i(46020);
                Context context = WalletPayDeductUI.this.mController.ylL;
                List<Bankcard> list = cPS;
                String a = WalletPayDeductUI.this.tph;
                Bankcard b = WalletPayDeductUI.this.tpj;
                h.a anonymousClass1 = new h.a() {
                    public final void BB(int i) {
                        AppMethodBeat.i(46019);
                        WalletPayDeductUI.this.tpj = (Bankcard) cPS.get(i);
                        WalletPayDeductUI.c(WalletPayDeductUI.this);
                        AppMethodBeat.o(46019);
                    }
                };
                List linkedList = new LinkedList();
                if ((list == null || list.size() == 0) && bo.isNullOrNil(null)) {
                    ab.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
                    AppMethodBeat.o(46020);
                    return;
                }
                int i;
                if (list == null || list.size() == 0) {
                    ab.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
                    linkedList.add(null);
                    i = 0;
                } else {
                    int i2 = 0;
                    i = 0;
                    for (Bankcard bankcard : list) {
                        linkedList.add(bankcard.field_desc);
                        if (b != null && b.equals(bankcard)) {
                            i = i2;
                        }
                        i2++;
                    }
                    if (!bo.isNullOrNil(null)) {
                        linkedList.add(null);
                        if (b == null) {
                            i = i2;
                        }
                    }
                }
                h.a(context, a, linkedList, i, anonymousClass1);
                AppMethodBeat.o(46020);
            }
        };
        spannableString.setSpan(jVar, 0, spannableString.length(), 18);
        this.tpf.setText(spannableString);
        this.tpf.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(46026);
    }

    /* Access modifiers changed, original: protected|final */
    public final void mX(boolean z) {
        AppMethodBeat.i(46027);
        if (z) {
            findViewById(16908298).setVisibility(0);
            if (this.pWy.tAv.tBf == 1) {
                this.nrC.setVisibility(0);
            } else {
                this.nrC.setVisibility(8);
            }
            cNV();
            if (r.cPI().cQg()) {
                this.tpe.setVisibility(8);
                this.gHn.setText(R.string.fe4);
            } else {
                this.tpe.setVisibility(0);
                this.tpe.setText(R.string.fe3);
                this.gHn.setText(R.string.fe1);
            }
        } else {
            if (this.tpd != null && this.tpd.size() > 0) {
                int size = this.tpd.size();
                for (int i = 0; i < size; i++) {
                    this.iFE.ce(((Preference) this.tpd.get(i)).mKey, true);
                }
            }
            findViewById(16908298).setVisibility(8);
            this.nrC.setVisibility(8);
            this.tpe.setVisibility(8);
            this.gHn.setText(R.string.fe2);
        }
        ab.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.omp.zMU);
        AppMethodBeat.o(46027);
    }

    private void cNV() {
        AppMethodBeat.i(46028);
        if (this.tpd == null || this.tpd.size() <= 0) {
            AppMethodBeat.o(46028);
            return;
        }
        int size = this.tpd.size();
        for (int i = 0; i < size; i++) {
            this.iFE.ce(((Preference) this.tpd.get(i)).mKey, false);
        }
        this.iFE.notifyDataSetChanged();
        AppMethodBeat.o(46028);
    }

    private void dP(List<DeductShowInfo> list) {
        AppMethodBeat.i(46029);
        if (list == null || list.size() == 0) {
            ab.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
            AppMethodBeat.o(46029);
            return;
        }
        if (this.tpd == null) {
            int size = list.size();
            this.tpd = new ArrayList();
            for (int i = 0; i < size; i++) {
                final DeductShowInfo deductShowInfo = (DeductShowInfo) list.get(i);
                if (!(deductShowInfo == null || bo.isNullOrNil(deductShowInfo.name))) {
                    e eVar = new e(this);
                    eVar.setTitle((CharSequence) deductShowInfo.name);
                    if (deductShowInfo.tBi > 0) {
                        eVar.peA = getResources().getColor(R.color.t7);
                        String str = deductShowInfo.value;
                        AnonymousClass4 anonymousClass4 = new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(46021);
                                ab.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", Integer.valueOf(deductShowInfo.tBi));
                                if (deductShowInfo.tBi == 1) {
                                    if (!bo.isNullOrNil(deductShowInfo.tBl)) {
                                        Intent intent = new Intent();
                                        intent.putExtra("rawUrl", deductShowInfo.tBl);
                                        intent.putExtra("showShare", false);
                                        com.tencent.mm.bp.d.b(WalletPayDeductUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                        AppMethodBeat.o(46021);
                                        return;
                                    }
                                } else if (deductShowInfo.tBi == 2) {
                                    se seVar = new se();
                                    seVar.cOf.userName = deductShowInfo.tBj;
                                    seVar.cOf.cOh = bo.bc(deductShowInfo.tBk, "");
                                    seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI;
                                    seVar.cOf.cOi = 0;
                                    com.tencent.mm.sdk.b.a.xxA.m(seVar);
                                }
                                AppMethodBeat.o(46021);
                            }
                        };
                        eVar.mXp = str;
                        eVar.mXt = true;
                        eVar.lDG = anonymousClass4;
                    } else {
                        eVar.mXp = deductShowInfo.value;
                        eVar.mXt = false;
                    }
                    eVar.setKey("deduct_info_".concat(String.valueOf(i)));
                    this.tpd.add(eVar);
                    this.iFE.b(eVar);
                    this.iFE.ce(eVar.mKey, true);
                }
            }
        }
        AppMethodBeat.o(46029);
    }

    public final int getLayoutId() {
        return R.layout.b5i;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        return false;
    }

    public void onClick(View view) {
        AppMethodBeat.i(46030);
        int id = view.getId();
        if (id == R.id.ay8) {
            Intent intent = new Intent();
            if (this.tpl == 0) {
                intent.putExtra("auto_deduct_flag", this.omp.zMU ? 1 : 0);
            } else {
                intent.putExtra("auto_deduct_flag", this.pWy.tAv.tpY);
            }
            if (this.tpj != null) {
                intent.putExtra("deduct_bank_type", this.tpj.field_bankcardType);
                intent.putExtra("deduct_bind_serial", this.tpj.field_bindSerial);
                ab.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", this.tpj.field_bankcardType);
            }
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(46030);
            return;
        }
        if (id == R.id.d9f && !bo.isNullOrNil(this.pWy.tAv.tBd)) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", this.pWy.tAv.tBd);
            intent2.putExtra("showShare", false);
            com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
        }
        AppMethodBeat.o(46030);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(46031);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(46031);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46032);
        ab.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (!(mVar instanceof com.tencent.mm.plugin.wallet.pwd.a.j)) {
            ab.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
        } else if (i == 0 && i2 == 0) {
            g.RQ();
            this.tpi = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING, getString(R.string.fod));
            g.RQ();
            this.tph = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING, getString(R.string.fog));
            this.tpg.setText(this.tpi);
            cNU();
        }
        if (this.gII != null) {
            this.gII.dismiss();
        }
        AppMethodBeat.o(46032);
    }

    public final void initView() {
        boolean z;
        AppMethodBeat.i(46025);
        this.tpe = (TextView) this.mController.contentView.findViewById(R.id.ff3);
        this.gHn = (Button) this.mController.contentView.findViewById(R.id.ay8);
        this.nrC = (LinearLayout) findViewById(R.id.fez);
        ((TextView) findViewById(R.id.fex)).setText(this.pWy.tAv.title);
        ((TextView) findViewById(R.id.cx)).setText(((Commodity) this.pWy.tAq.get(0)).desc);
        WalletTextView walletTextView = (WalletTextView) findViewById(R.id.fev);
        walletTextView.setTypeface(0);
        walletTextView.setText(com.tencent.mm.wallet_core.ui.e.atr(this.pWy.pcl));
        ((TextView) findViewById(R.id.dlh)).setText(((Commodity) this.pWy.tAq.get(0)).kCJ);
        TextView textView = (TextView) findViewById(R.id.d9f);
        TextView textView2 = (TextView) findViewById(R.id.fey);
        if (bo.isNullOrNil(this.pWy.tAv.tBg)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.pWy.tAv.tBg);
            if (!bo.isNullOrNil(this.pWy.tAv.tBh)) {
                textView2.setTextColor(Color.parseColor(this.pWy.tAv.tBh));
            }
        }
        this.tpf = (TextView) findViewById(R.id.ff0);
        this.tpg = (TextView) findViewById(R.id.ff1);
        if (this.pWy.tAv.tpY == 1) {
            z = true;
        } else {
            z = false;
        }
        this.tpk = z;
        this.tpl = this.pWy.tAv.tpl;
        this.kdE = this.pWy.tAv.kdE;
        this.tpm = this.pWy.tAv.tpm;
        ab.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", Boolean.valueOf(this.tpk), Integer.valueOf(this.tpl));
        if (this.tpl == 0) {
            this.omp = (MMSwitchBtn) findViewById(R.id.js);
            this.omp.setCheck(this.tpk);
            this.omp.setSwitchListener(new MMSwitchBtn.a() {
                public final void di(boolean z) {
                    int i = 2;
                    AppMethodBeat.i(46018);
                    WalletPayDeductUI.this.mX(z);
                    if (WalletPayDeductUI.this.pWy != null) {
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        Object[] objArr = new Object[2];
                        if (z) {
                            i = 1;
                        }
                        objArr[0] = Integer.valueOf(i);
                        objArr[1] = WalletPayDeductUI.this.pWy.czZ;
                        hVar.e(15379, objArr);
                    }
                    AppMethodBeat.o(46018);
                }
            });
            mX(this.tpk);
        } else {
            if (!bo.isNullOrNil(this.kdE)) {
                this.gHn.setText(this.kdE);
            }
            if (!bo.isNullOrNil(this.tpm)) {
                this.tpe.setText(this.tpm);
                this.tpe.setVisibility(0);
            }
            findViewById(R.id.few).setVisibility(8);
            cNV();
        }
        ab.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", Integer.valueOf(this.pWy.tAv.tBf));
        if (this.pWy.tAv.tBf == 1) {
            g.RQ();
            this.tpi = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING, (Object) "");
            g.RQ();
            this.tph = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING, (Object) "");
            if (bo.isNullOrNil(this.tph) || bo.isNullOrNil(this.tph)) {
                ab.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
                this.gII = com.tencent.mm.wallet_core.ui.g.a(this.mController.ylL, false, null);
                m jVar = new com.tencent.mm.plugin.wallet.pwd.a.j();
                g.RQ();
                g.RO().eJo.a(jVar, 0);
            } else {
                this.tpg.setText(this.tpi);
                cNU();
            }
        } else {
            this.nrC.setVisibility(8);
        }
        if (bo.isNullOrNil(this.pWy.tAv.tBd)) {
            textView.setVisibility(8);
        } else {
            String string = getString(R.string.fdz);
            SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, getString(R.string.fdy, new Object[]{string, getString(R.string.fe0)}));
            com.tencent.mm.plugin.wallet_core.ui.j jVar2 = new com.tencent.mm.plugin.wallet_core.ui.j(this.mController.ylL);
            SpannableString spannableString = new SpannableString(b);
            spannableString.setSpan(jVar2, b.length() - r4.length(), b.length(), 33);
            textView.setTextColor(getResources().getColor(R.color.s0));
            textView.setText(spannableString);
            textView.setOnClickListener(this);
            textView.setVisibility(0);
        }
        this.gHn.setOnClickListener(this);
        AppMethodBeat.o(46025);
    }
}
