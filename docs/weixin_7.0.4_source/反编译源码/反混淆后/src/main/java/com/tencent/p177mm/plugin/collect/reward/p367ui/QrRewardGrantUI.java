package com.tencent.p177mm.plugin.collect.reward.p367ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18267fx;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.collect.reward.p366a.C2834d;
import com.tencent.p177mm.plugin.collect.reward.p366a.C2835e;
import com.tencent.p177mm.plugin.collect.reward.p366a.C33863a.C33864a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI */
public class QrRewardGrantUI extends QrRewardBaseUI {
    private RadioButton aaX;
    private int cIb;
    private String czZ;
    private String hAh;
    private String kBE;
    private ImageView kDI;
    private TextView kDJ;
    private TextView kDK;
    private WalletTextView kDL;
    private LinearLayout kDM;
    private WalletFormView kDN;
    private MMEditText kDO;
    private Button kDP;
    private int kDQ;
    private int kDR;
    private String kDS;
    private String kDT;
    private String kDU;
    private String kDV;
    private String kDW;
    private String kDX;
    private String kDY;
    private String kDZ;
    private String kEa;
    private int kEb;
    private C4884c<C18267fx> kEc = new C114378();

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI$1 */
    class C114351 implements TextWatcher {
        C114351() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(41063);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 3) {
                editable.delete(indexOf + 3, length);
            } else if (indexOf > 6) {
                editable.delete(6, indexOf);
            } else if (indexOf == -1 && length > 6) {
                editable.delete(6, length);
            }
            length = (int) Math.round(C5046bo.getDouble(editable.toString(), 0.0d) * 100.0d);
            QrRewardGrantUI.m19191a(QrRewardGrantUI.this, length);
            QrRewardGrantUI.this.kDQ = length;
            AppMethodBeat.m2505o(41063);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI$8 */
    class C114378 extends C4884c<C18267fx> {
        C114378() {
            AppMethodBeat.m2504i(41070);
            this.xxI = C18267fx.class.getName().hashCode();
            AppMethodBeat.m2505o(41070);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(41071);
            C18267fx c18267fx = (C18267fx) c4883b;
            QrRewardGrantUI.m19190a(QrRewardGrantUI.this, c18267fx.czY.czZ, c18267fx.czY.cAa);
            AppMethodBeat.m2505o(41071);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI$2 */
    class C114412 extends C24019s {
        C114412() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(41064);
            if (QrRewardGrantUI.m19191a(QrRewardGrantUI.this, (int) Math.round(C5046bo.getDouble(QrRewardGrantUI.this.kDN.getText(), 0.0d) * 100.0d))) {
                QrRewardGrantUI.m19194b(QrRewardGrantUI.this);
            }
            AppMethodBeat.m2505o(41064);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI$3 */
    class C114423 implements OnClickListener {
        C114423() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41065);
            QrRewardGrantUI.this.aaX.setChecked(!QrRewardGrantUI.this.aaX.isChecked());
            AppMethodBeat.m2505o(41065);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI$4 */
    class C114434 implements OnCheckedChangeListener {
        C114434() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI$5 */
    class C114445 implements C33864a {
        C114445() {
        }

        /* renamed from: j */
        public final void mo6956j(C1207m c1207m) {
            AppMethodBeat.m2504i(41066);
            C4990ab.m7413e("MicroMsg.QrRewardGrantUI", "net error: %s", c1207m);
            AppMethodBeat.m2505o(41066);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public QrRewardGrantUI() {
        AppMethodBeat.m2504i(41072);
        AppMethodBeat.m2505o(41072);
    }

    /* renamed from: a */
    static /* synthetic */ void m19190a(QrRewardGrantUI qrRewardGrantUI, String str, String str2) {
        AppMethodBeat.m2504i(41082);
        qrRewardGrantUI.m19199dA(str, str2);
        AppMethodBeat.m2505o(41082);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41073);
        super.onCreate(bundle);
        mo39992nf(1336);
        this.kEc.dnU();
        setMMTitle((int) C25738R.string.dfo);
        this.kDQ = getIntent().getIntExtra("key_money_amt", C1625i.sHCENCODEVIDEOTIMEOUT);
        this.kDR = getIntent().getIntExtra("key_amt_type", 0);
        this.kDS = getIntent().getStringExtra("key_qrcode_desc");
        this.cIb = getIntent().getIntExtra("key_channel", 0);
        this.kDU = getIntent().getStringExtra("key_rcvr_open_id");
        this.kDW = getIntent().getStringExtra("key_rcvr_name");
        this.kDX = getIntent().getStringExtra("key_rcvr_true_name");
        this.kDY = getIntent().getStringExtra("key_scan_id");
        this.hAh = getIntent().getStringExtra("key_web_url");
        this.kDZ = getIntent().getStringExtra("key_sxtend_1");
        this.kEa = getIntent().getStringExtra("key_sxtend_2");
        this.kEb = getIntent().getIntExtra("key_max_amt", C1625i.sHCENCODEVIDEOTIMEOUT);
        C4990ab.m7417i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", Integer.valueOf(this.kDR), Integer.valueOf(this.cIb), Integer.valueOf(this.kEb));
        initView();
        AppMethodBeat.m2505o(41073);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41074);
        this.kDI = (ImageView) findViewById(2131826730);
        this.kDJ = (TextView) findViewById(2131826731);
        this.kDL = (WalletTextView) findViewById(2131826733);
        this.kDM = (LinearLayout) findViewById(2131826732);
        this.kDN = (WalletFormView) findViewById(2131826734);
        this.kDO = (MMEditText) findViewById(2131826735);
        this.kDP = (Button) findViewById(2131826738);
        this.kDK = (TextView) findViewById(2131826739);
        this.aaX = (RadioButton) findViewById(2131826737);
        this.aaX.setChecked(true);
        this.kDK.setText(getString(C25738R.string.dg3, new Object[]{Math.round(((float) this.kEb) / 100.0f)}));
        C40460b.m69433a(this.kDI, this.kDW, 0.03f, false);
        String eK = C36391e.m60007eK(C36391e.m60015mJ(this.kDW), 10);
        this.kDJ.setText(C44089j.m79292b((Context) this, getString(C25738R.string.dfp, new Object[]{eK})));
        if (this.kDR == 2) {
            C4990ab.m7416i("MicroMsg.QrRewardGrantUI", "edit layout");
            mo39989e(this.kDN, 2, false);
            this.kDN.mo64594a(new C114351());
            this.kDN.setVisibility(0);
            this.kDM.setVisibility(8);
            this.kDN.dOS();
            this.kDP.setEnabled(false);
        } else {
            this.kDL.setText(C36391e.m59971F(((double) this.kDQ) / 100.0d));
            this.kDN.setVisibility(8);
            this.kDM.setVisibility(0);
        }
        this.kDP.setOnClickListener(new C114412());
        findViewById(2131826736).setOnClickListener(new C114423());
        this.aaX.setOnCheckedChangeListener(new C114434());
        AppMethodBeat.m2505o(41074);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41075);
        if (c1207m instanceof C2835e) {
            final C2835e c2835e = (C2835e) c1207m;
            c2835e.mo54407a(new C33864a() {

                /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI$7$1 */
                class C114391 implements DialogInterface.OnClickListener {
                    C114391() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(41068);
                        QrRewardGrantUI.m19198d(QrRewardGrantUI.this);
                        AppMethodBeat.m2505o(41068);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI$7$2 */
                class C114402 implements DialogInterface.OnClickListener {
                    C114402() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }

                /* renamed from: j */
                public final void mo6956j(C1207m c1207m) {
                    AppMethodBeat.m2504i(41069);
                    QrRewardGrantUI.this.czZ = c2835e.kDy.cBT;
                    QrRewardGrantUI.this.kDT = c2835e.kDy.vWI;
                    QrRewardGrantUI.this.kBE = c2835e.kDy.vFc;
                    QrRewardGrantUI.this.kDU = c2835e.kDy.vWG;
                    QrRewardGrantUI.this.kDV = c2835e.kDy.vWF;
                    C4990ab.m7417i("MicroMsg.QrRewardGrantUI", "remind str: %s", c2835e.kDy.vWR);
                    if (C5046bo.isNullOrNil(c2835e.kDy.vWR)) {
                        QrRewardGrantUI.m19198d(QrRewardGrantUI.this);
                        AppMethodBeat.m2505o(41069);
                        return;
                    }
                    C30379h.m48466d(QrRewardGrantUI.this.mController.ylL, c2835e.kDy.vWR, "", QrRewardGrantUI.this.getString(C25738R.string.do6), QrRewardGrantUI.this.getString(C25738R.string.f9076or), new C114391(), new C114402());
                    AppMethodBeat.m2505o(41069);
                }
            }).mo54408b(new C33864a() {
                /* renamed from: j */
                public final void mo6956j(C1207m c1207m) {
                    AppMethodBeat.m2504i(41067);
                    C4990ab.m7413e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", Integer.valueOf(c2835e.kDy.kCl), c2835e.kDy.kCm);
                    if (!C5046bo.isNullOrNil(c2835e.kDy.kCm)) {
                        Toast.makeText(QrRewardGrantUI.this, c2835e.kDy.kCm, 0).show();
                    }
                    AppMethodBeat.m2505o(41067);
                }
            }).mo54410c(new C114445());
        }
        AppMethodBeat.m2505o(41075);
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41076);
        super.onDestroy();
        mo39993ng(1336);
        this.kEc.dead();
        AppMethodBeat.m2505o(41076);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41077);
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            setResult(-1);
            if (intent != null) {
                m19199dA(intent.getStringExtra("key_reqKey"), intent.getStringExtra("key_trans_id"));
            }
            finish();
            AppMethodBeat.m2505o(41077);
            return;
        }
        AppMethodBeat.m2505o(41077);
    }

    public final int getLayoutId() {
        return 2130970430;
    }

    /* renamed from: dA */
    private void m19199dA(String str, String str2) {
        AppMethodBeat.m2504i(41078);
        C4990ab.m7416i("MicroMsg.QrRewardGrantUI", "do pay check");
        if (C5046bo.isNullOrNil(this.czZ)) {
            this.czZ = str;
        }
        if (C5046bo.isNullOrNil(this.kBE)) {
            this.kBE = str2;
        }
        mo39970a(new C2834d(this.czZ, this.kDT, this.kBE, this.kDQ, this.kDU, this.kDV), false, false);
        AppMethodBeat.m2505o(41078);
    }

    /* renamed from: b */
    static /* synthetic */ void m19194b(QrRewardGrantUI qrRewardGrantUI) {
        AppMethodBeat.m2504i(41080);
        C4990ab.m7417i("MicroMsg.QrRewardGrantUI", "do place order, amt: %s, amtType: %s, payer desc: %s showPayInfo %s", Integer.valueOf(qrRewardGrantUI.kDQ), Integer.valueOf(qrRewardGrantUI.kDR), qrRewardGrantUI.kDO.getText().toString().replace(IOUtils.LINE_SEPARATOR_UNIX, ""), Integer.valueOf(qrRewardGrantUI.aaX.isChecked() ? 1 : 0));
        C1207m c2835e = new C2835e(qrRewardGrantUI.kDQ, qrRewardGrantUI.kDR, qrRewardGrantUI.kDW, qrRewardGrantUI.kDS, r5, qrRewardGrantUI.cIb, qrRewardGrantUI.kDY, qrRewardGrantUI.kDU, qrRewardGrantUI.hAh, qrRewardGrantUI.kDZ, qrRewardGrantUI.kEa, r12);
        c2835e.mo54411z(qrRewardGrantUI);
        qrRewardGrantUI.mo39970a(c2835e, true, true);
        AppMethodBeat.m2505o(41080);
    }

    /* renamed from: d */
    static /* synthetic */ void m19198d(QrRewardGrantUI qrRewardGrantUI) {
        AppMethodBeat.m2504i(41081);
        C4990ab.m7416i("MicroMsg.QrRewardGrantUI", "start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.czZ = qrRewardGrantUI.czZ;
        payInfo.cIf = 48;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", qrRewardGrantUI.kDW);
        bundle.putString("extinfo_key_2", qrRewardGrantUI.kDX);
        bundle.putString("extinfo_key_3", qrRewardGrantUI.kDS);
        bundle.putString("extinfo_key_7", qrRewardGrantUI.kDO.getText().toString().replace(IOUtils.LINE_SEPARATOR_UNIX, ""));
        payInfo.vwh = bundle;
        C35899h.m58853a(qrRewardGrantUI, payInfo, 1);
        AppMethodBeat.m2505o(41081);
    }
}
