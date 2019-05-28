package com.tencent.p177mm.plugin.wallet.pay.p557ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p612ui.C24020t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30381a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C22539j;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22584ac;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C29667e;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI */
public class WalletPayDeductUI extends MMPreference implements OnClickListener, C1202f {
    protected Button gHn;
    private Dialog gII = null;
    protected C15541f iFE;
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

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI$1 */
    class C354471 extends C24020t {
        C354471() {
        }

        /* renamed from: Kp */
        public final void mo39830Kp() {
            AppMethodBeat.m2504i(46017);
            WalletPayDeductUI.this.setResult(0);
            WalletPayDeductUI.this.finish();
            AppMethodBeat.m2505o(46017);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI$2 */
    class C354482 implements C30795a {
        C354482() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            int i = 2;
            AppMethodBeat.m2504i(46018);
            WalletPayDeductUI.this.mo71871mX(z);
            if (WalletPayDeductUI.this.pWy != null) {
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[2];
                if (z) {
                    i = 1;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = WalletPayDeductUI.this.pWy.czZ;
                c7060h.mo8381e(15379, objArr);
            }
            AppMethodBeat.m2505o(46018);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    static /* synthetic */ void m81725c(WalletPayDeductUI walletPayDeductUI) {
        AppMethodBeat.m2504i(46033);
        walletPayDeductUI.cNU();
        AppMethodBeat.m2505o(46033);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46022);
        super.onCreate(bundle);
        this.iFE = this.yCw;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.a69)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(2131821128);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(C25738R.color.a3p));
            }
            customView = customView.findViewById(16908309);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(C25738R.color.a69));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            if (C1443d.m3068iW(23)) {
                window.setStatusBarColor(getResources().getColor(C25738R.color.a4d));
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        Intent intent = getIntent();
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.WalletPayDeductUI", "intent is null");
            finish();
            AppMethodBeat.m2505o(46022);
            return;
        }
        this.pWy = (Orders) intent.getParcelableExtra("orders");
        if (this.pWy == null || this.pWy.tAv == null) {
            C4990ab.m7412e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.pWy);
            finish();
        }
        m81726dP(this.pWy.tAv.tBe);
        setResult(0);
        setBackBtn(new C354471(), C1318a.actionbar_icon_dark_back);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(46022);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46023);
        super.onResume();
        AppMethodBeat.m2505o(46023);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46024);
        super.onDestroy();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
        AppMethodBeat.m2505o(46024);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    private void cNU() {
        AppMethodBeat.m2504i(46026);
        C46332s.cNC();
        C22587ak cND = C46332s.cND();
        if (this.tpj == null) {
            this.tpj = cND.mo38131a(null, null, true, true, true);
        }
        if (this.tpj == null) {
            C4990ab.m7416i("MicroMsg.WalletPayDeductUI", "no bank card!");
            finish();
            AppMethodBeat.m2505o(46026);
            return;
        }
        SpannableString spannableString = new SpannableString(this.tpj.field_desc);
        C46373j c46373j = new C46373j(this.mController.ylL);
        final List cPS = C22584ac.cPS();
        c46373j.tHw = new C29672a() {

            /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI$3$1 */
            class C141871 implements C30381a {
                C141871() {
                }

                /* renamed from: BB */
                public final void mo26479BB(int i) {
                    AppMethodBeat.m2504i(46019);
                    WalletPayDeductUI.this.tpj = (Bankcard) cPS.get(i);
                    WalletPayDeductUI.m81725c(WalletPayDeductUI.this);
                    AppMethodBeat.m2505o(46019);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(46020);
                Context context = WalletPayDeductUI.this.mController.ylL;
                List<Bankcard> list = cPS;
                String a = WalletPayDeductUI.this.tph;
                Bankcard b = WalletPayDeductUI.this.tpj;
                C30381a c141871 = new C141871();
                List linkedList = new LinkedList();
                if ((list == null || list.size() == 0) && C5046bo.isNullOrNil(null)) {
                    C4990ab.m7420w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
                    AppMethodBeat.m2505o(46020);
                    return;
                }
                int i;
                if (list == null || list.size() == 0) {
                    C4990ab.m7416i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
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
                    if (!C5046bo.isNullOrNil(null)) {
                        linkedList.add(null);
                        if (b == null) {
                            i = i2;
                        }
                    }
                }
                C30379h.m48450a(context, a, linkedList, i, c141871);
                AppMethodBeat.m2505o(46020);
            }
        };
        spannableString.setSpan(c46373j, 0, spannableString.length(), 18);
        this.tpf.setText(spannableString);
        this.tpf.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.m2505o(46026);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mX */
    public final void mo71871mX(boolean z) {
        AppMethodBeat.m2504i(46027);
        if (z) {
            findViewById(16908298).setVisibility(0);
            if (this.pWy.tAv.tBf == 1) {
                this.nrC.setVisibility(0);
            } else {
                this.nrC.setVisibility(8);
            }
            cNV();
            if (C14241r.cPI().cQg()) {
                this.tpe.setVisibility(8);
                this.gHn.setText(C25738R.string.fe4);
            } else {
                this.tpe.setVisibility(0);
                this.tpe.setText(C25738R.string.fe3);
                this.gHn.setText(C25738R.string.fe1);
            }
        } else {
            if (this.tpd != null && this.tpd.size() > 0) {
                int size = this.tpd.size();
                for (int i = 0; i < size; i++) {
                    this.iFE.mo27715ce(((Preference) this.tpd.get(i)).mKey, true);
                }
            }
            findViewById(16908298).setVisibility(8);
            this.nrC.setVisibility(8);
            this.tpe.setVisibility(8);
            this.gHn.setText(C25738R.string.fe2);
        }
        C4990ab.m7416i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.omp.zMU);
        AppMethodBeat.m2505o(46027);
    }

    private void cNV() {
        AppMethodBeat.m2504i(46028);
        if (this.tpd == null || this.tpd.size() <= 0) {
            AppMethodBeat.m2505o(46028);
            return;
        }
        int size = this.tpd.size();
        for (int i = 0; i < size; i++) {
            this.iFE.mo27715ce(((Preference) this.tpd.get(i)).mKey, false);
        }
        this.iFE.notifyDataSetChanged();
        AppMethodBeat.m2505o(46028);
    }

    /* renamed from: dP */
    private void m81726dP(List<DeductShowInfo> list) {
        AppMethodBeat.m2504i(46029);
        if (list == null || list.size() == 0) {
            C4990ab.m7412e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
            AppMethodBeat.m2505o(46029);
            return;
        }
        if (this.tpd == null) {
            int size = list.size();
            this.tpd = new ArrayList();
            for (int i = 0; i < size; i++) {
                final DeductShowInfo deductShowInfo = (DeductShowInfo) list.get(i);
                if (!(deductShowInfo == null || C5046bo.isNullOrNil(deductShowInfo.name))) {
                    C29667e c29667e = new C29667e(this);
                    c29667e.setTitle((CharSequence) deductShowInfo.name);
                    if (deductShowInfo.tBi > 0) {
                        c29667e.peA = getResources().getColor(C25738R.color.f12123t7);
                        String str = deductShowInfo.value;
                        C43714 c43714 = new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(46021);
                                C4990ab.m7417i("MicroMsg.WalletPayDeductUI", "click link_type: %s", Integer.valueOf(deductShowInfo.tBi));
                                if (deductShowInfo.tBi == 1) {
                                    if (!C5046bo.isNullOrNil(deductShowInfo.tBl)) {
                                        Intent intent = new Intent();
                                        intent.putExtra("rawUrl", deductShowInfo.tBl);
                                        intent.putExtra("showShare", false);
                                        C25985d.m41467b(WalletPayDeductUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                        AppMethodBeat.m2505o(46021);
                                        return;
                                    }
                                } else if (deductShowInfo.tBi == 2) {
                                    C32628se c32628se = new C32628se();
                                    c32628se.cOf.userName = deductShowInfo.tBj;
                                    c32628se.cOf.cOh = C5046bo.m7532bc(deductShowInfo.tBk, "");
                                    c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI;
                                    c32628se.cOf.cOi = 0;
                                    C4879a.xxA.mo10055m(c32628se);
                                }
                                AppMethodBeat.m2505o(46021);
                            }
                        };
                        c29667e.mXp = str;
                        c29667e.mXt = true;
                        c29667e.lDG = c43714;
                    } else {
                        c29667e.mXp = deductShowInfo.value;
                        c29667e.mXt = false;
                    }
                    c29667e.setKey("deduct_info_".concat(String.valueOf(i)));
                    this.tpd.add(c29667e);
                    this.iFE.mo27713b(c29667e);
                    this.iFE.mo27715ce(c29667e.mKey, true);
                }
            }
        }
        AppMethodBeat.m2505o(46029);
    }

    public final int getLayoutId() {
        return 2130971145;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        return false;
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(46030);
        int id = view.getId();
        if (id == 2131822846) {
            Intent intent = new Intent();
            if (this.tpl == 0) {
                intent.putExtra("auto_deduct_flag", this.omp.zMU ? 1 : 0);
            } else {
                intent.putExtra("auto_deduct_flag", this.pWy.tAv.tpY);
            }
            if (this.tpj != null) {
                intent.putExtra("deduct_bank_type", this.tpj.field_bankcardType);
                intent.putExtra("deduct_bind_serial", this.tpj.field_bindSerial);
                C4990ab.m7417i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", this.tpj.field_bankcardType);
            }
            setResult(-1, intent);
            finish();
            AppMethodBeat.m2505o(46030);
            return;
        }
        if (id == 2131825998 && !C5046bo.isNullOrNil(this.pWy.tAv.tBd)) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", this.pWy.tAv.tBd);
            intent2.putExtra("showShare", false);
            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
        }
        AppMethodBeat.m2505o(46030);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(46031);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(46031);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46032);
        C4990ab.m7417i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (!(c1207m instanceof C22539j)) {
            C4990ab.m7410d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
        } else if (i == 0 && i2 == 0) {
            C1720g.m3537RQ();
            this.tpi = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING, getString(C25738R.string.fod));
            C1720g.m3537RQ();
            this.tph = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING, getString(C25738R.string.fog));
            this.tpg.setText(this.tpi);
            cNU();
        }
        if (this.gII != null) {
            this.gII.dismiss();
        }
        AppMethodBeat.m2505o(46032);
    }

    public final void initView() {
        boolean z;
        AppMethodBeat.m2504i(46025);
        this.tpe = (TextView) this.mController.contentView.findViewById(2131828982);
        this.gHn = (Button) this.mController.contentView.findViewById(2131822846);
        this.nrC = (LinearLayout) findViewById(2131828978);
        ((TextView) findViewById(2131828976)).setText(this.pWy.tAv.title);
        ((TextView) findViewById(2131820678)).setText(((Commodity) this.pWy.tAq.get(0)).desc);
        WalletTextView walletTextView = (WalletTextView) findViewById(2131828974);
        walletTextView.setTypeface(0);
        walletTextView.setText(C36391e.atr(this.pWy.pcl));
        ((TextView) findViewById(2131826481)).setText(((Commodity) this.pWy.tAq.get(0)).kCJ);
        TextView textView = (TextView) findViewById(2131825998);
        TextView textView2 = (TextView) findViewById(2131828977);
        if (C5046bo.isNullOrNil(this.pWy.tAv.tBg)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.pWy.tAv.tBg);
            if (!C5046bo.isNullOrNil(this.pWy.tAv.tBh)) {
                textView2.setTextColor(Color.parseColor(this.pWy.tAv.tBh));
            }
        }
        this.tpf = (TextView) findViewById(2131828979);
        this.tpg = (TextView) findViewById(2131828980);
        if (this.pWy.tAv.tpY == 1) {
            z = true;
        } else {
            z = false;
        }
        this.tpk = z;
        this.tpl = this.pWy.tAv.tpl;
        this.kdE = this.pWy.tAv.kdE;
        this.tpm = this.pWy.tAv.tpm;
        C4990ab.m7417i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", Boolean.valueOf(this.tpk), Integer.valueOf(this.tpl));
        if (this.tpl == 0) {
            this.omp = (MMSwitchBtn) findViewById(2131820932);
            this.omp.setCheck(this.tpk);
            this.omp.setSwitchListener(new C354482());
            mo71871mX(this.tpk);
        } else {
            if (!C5046bo.isNullOrNil(this.kdE)) {
                this.gHn.setText(this.kdE);
            }
            if (!C5046bo.isNullOrNil(this.tpm)) {
                this.tpe.setText(this.tpm);
                this.tpe.setVisibility(0);
            }
            findViewById(2131828975).setVisibility(8);
            cNV();
        }
        C4990ab.m7411d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", Integer.valueOf(this.pWy.tAv.tBf));
        if (this.pWy.tAv.tBf == 1) {
            C1720g.m3537RQ();
            this.tpi = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING, (Object) "");
            C1720g.m3537RQ();
            this.tph = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING, (Object) "");
            if (C5046bo.isNullOrNil(this.tph) || C5046bo.isNullOrNil(this.tph)) {
                C4990ab.m7416i("MicroMsg.WalletPayDeductUI", "need do pay manager");
                this.gII = C30901g.m49317a(this.mController.ylL, false, null);
                C1207m c22539j = new C22539j();
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c22539j, 0);
            } else {
                this.tpg.setText(this.tpi);
                cNU();
            }
        } else {
            this.nrC.setVisibility(8);
        }
        if (C5046bo.isNullOrNil(this.pWy.tAv.tBd)) {
            textView.setVisibility(8);
        } else {
            String string = getString(C25738R.string.fdz);
            SpannableString b = C44089j.m79292b((Context) this, getString(C25738R.string.fdy, new Object[]{string, getString(C25738R.string.fe0)}));
            C46373j c46373j = new C46373j(this.mController.ylL);
            SpannableString spannableString = new SpannableString(b);
            spannableString.setSpan(c46373j, b.length() - r4.length(), b.length(), 33);
            textView.setTextColor(getResources().getColor(C25738R.color.f12092s0));
            textView.setText(spannableString);
            textView.setOnClickListener(this);
            textView.setVisibility(0);
        }
        this.gHn.setOnClickListener(this);
        AppMethodBeat.m2505o(46025);
    }
}
