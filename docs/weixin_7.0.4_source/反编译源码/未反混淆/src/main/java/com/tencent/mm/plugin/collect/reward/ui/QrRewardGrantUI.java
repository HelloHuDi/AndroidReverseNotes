package com.tencent.mm.plugin.collect.reward.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.ttpic.baseutils.IOUtils;

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
    private c<fx> kEc = new c<fx>() {
        {
            AppMethodBeat.i(41070);
            this.xxI = fx.class.getName().hashCode();
            AppMethodBeat.o(41070);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(41071);
            fx fxVar = (fx) bVar;
            QrRewardGrantUI.a(QrRewardGrantUI.this, fxVar.czY.czZ, fxVar.czY.cAa);
            AppMethodBeat.o(41071);
            return false;
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QrRewardGrantUI() {
        AppMethodBeat.i(41072);
        AppMethodBeat.o(41072);
    }

    static /* synthetic */ void a(QrRewardGrantUI qrRewardGrantUI, String str, String str2) {
        AppMethodBeat.i(41082);
        qrRewardGrantUI.dA(str, str2);
        AppMethodBeat.o(41082);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41073);
        super.onCreate(bundle);
        nf(1336);
        this.kEc.dnU();
        setMMTitle((int) R.string.dfo);
        this.kDQ = getIntent().getIntExtra("key_money_amt", i.sHCENCODEVIDEOTIMEOUT);
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
        this.kEb = getIntent().getIntExtra("key_max_amt", i.sHCENCODEVIDEOTIMEOUT);
        ab.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", Integer.valueOf(this.kDR), Integer.valueOf(this.cIb), Integer.valueOf(this.kEb));
        initView();
        AppMethodBeat.o(41073);
    }

    public final void initView() {
        AppMethodBeat.i(41074);
        this.kDI = (ImageView) findViewById(R.id.ds8);
        this.kDJ = (TextView) findViewById(R.id.ds9);
        this.kDL = (WalletTextView) findViewById(R.id.dsa);
        this.kDM = (LinearLayout) findViewById(R.id.ds_);
        this.kDN = (WalletFormView) findViewById(R.id.dsb);
        this.kDO = (MMEditText) findViewById(R.id.dsc);
        this.kDP = (Button) findViewById(R.id.dsf);
        this.kDK = (TextView) findViewById(R.id.dsg);
        this.aaX = (RadioButton) findViewById(R.id.dse);
        this.aaX.setChecked(true);
        this.kDK.setText(getString(R.string.dg3, new Object[]{Math.round(((float) this.kEb) / 100.0f)}));
        a.b.a(this.kDI, this.kDW, 0.03f, false);
        String eK = e.eK(e.mJ(this.kDW), 10);
        this.kDJ.setText(j.b((Context) this, getString(R.string.dfp, new Object[]{eK})));
        if (this.kDR == 2) {
            ab.i("MicroMsg.QrRewardGrantUI", "edit layout");
            e(this.kDN, 2, false);
            this.kDN.a(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(41063);
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
                    length = (int) Math.round(bo.getDouble(editable.toString(), 0.0d) * 100.0d);
                    QrRewardGrantUI.a(QrRewardGrantUI.this, length);
                    QrRewardGrantUI.this.kDQ = length;
                    AppMethodBeat.o(41063);
                }
            });
            this.kDN.setVisibility(0);
            this.kDM.setVisibility(8);
            this.kDN.dOS();
            this.kDP.setEnabled(false);
        } else {
            this.kDL.setText(e.F(((double) this.kDQ) / 100.0d));
            this.kDN.setVisibility(8);
            this.kDM.setVisibility(0);
        }
        this.kDP.setOnClickListener(new s() {
            public final void bgW() {
                AppMethodBeat.i(41064);
                if (QrRewardGrantUI.a(QrRewardGrantUI.this, (int) Math.round(bo.getDouble(QrRewardGrantUI.this.kDN.getText(), 0.0d) * 100.0d))) {
                    QrRewardGrantUI.b(QrRewardGrantUI.this);
                }
                AppMethodBeat.o(41064);
            }
        });
        findViewById(R.id.dsd).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41065);
                QrRewardGrantUI.this.aaX.setChecked(!QrRewardGrantUI.this.aaX.isChecked());
                AppMethodBeat.o(41065);
            }
        });
        this.aaX.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            }
        });
        AppMethodBeat.o(41074);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41075);
        if (mVar instanceof com.tencent.mm.plugin.collect.reward.a.e) {
            final com.tencent.mm.plugin.collect.reward.a.e eVar = (com.tencent.mm.plugin.collect.reward.a.e) mVar;
            eVar.a(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41069);
                    QrRewardGrantUI.this.czZ = eVar.kDy.cBT;
                    QrRewardGrantUI.this.kDT = eVar.kDy.vWI;
                    QrRewardGrantUI.this.kBE = eVar.kDy.vFc;
                    QrRewardGrantUI.this.kDU = eVar.kDy.vWG;
                    QrRewardGrantUI.this.kDV = eVar.kDy.vWF;
                    ab.i("MicroMsg.QrRewardGrantUI", "remind str: %s", eVar.kDy.vWR);
                    if (bo.isNullOrNil(eVar.kDy.vWR)) {
                        QrRewardGrantUI.d(QrRewardGrantUI.this);
                        AppMethodBeat.o(41069);
                        return;
                    }
                    h.d(QrRewardGrantUI.this.mController.ylL, eVar.kDy.vWR, "", QrRewardGrantUI.this.getString(R.string.do6), QrRewardGrantUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(41068);
                            QrRewardGrantUI.d(QrRewardGrantUI.this);
                            AppMethodBeat.o(41068);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(41069);
                }
            }).b(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41067);
                    ab.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", Integer.valueOf(eVar.kDy.kCl), eVar.kDy.kCm);
                    if (!bo.isNullOrNil(eVar.kDy.kCm)) {
                        Toast.makeText(QrRewardGrantUI.this, eVar.kDy.kCm, 0).show();
                    }
                    AppMethodBeat.o(41067);
                }
            }).c(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41066);
                    ab.e("MicroMsg.QrRewardGrantUI", "net error: %s", mVar);
                    AppMethodBeat.o(41066);
                }
            });
        }
        AppMethodBeat.o(41075);
        return true;
    }

    public void onDestroy() {
        AppMethodBeat.i(41076);
        super.onDestroy();
        ng(1336);
        this.kEc.dead();
        AppMethodBeat.o(41076);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41077);
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            setResult(-1);
            if (intent != null) {
                dA(intent.getStringExtra("key_reqKey"), intent.getStringExtra("key_trans_id"));
            }
            finish();
            AppMethodBeat.o(41077);
            return;
        }
        AppMethodBeat.o(41077);
    }

    public final int getLayoutId() {
        return R.layout.am_;
    }

    private void dA(String str, String str2) {
        AppMethodBeat.i(41078);
        ab.i("MicroMsg.QrRewardGrantUI", "do pay check");
        if (bo.isNullOrNil(this.czZ)) {
            this.czZ = str;
        }
        if (bo.isNullOrNil(this.kBE)) {
            this.kBE = str2;
        }
        a(new d(this.czZ, this.kDT, this.kBE, this.kDQ, this.kDU, this.kDV), false, false);
        AppMethodBeat.o(41078);
    }

    static /* synthetic */ void b(QrRewardGrantUI qrRewardGrantUI) {
        AppMethodBeat.i(41080);
        ab.i("MicroMsg.QrRewardGrantUI", "do place order, amt: %s, amtType: %s, payer desc: %s showPayInfo %s", Integer.valueOf(qrRewardGrantUI.kDQ), Integer.valueOf(qrRewardGrantUI.kDR), qrRewardGrantUI.kDO.getText().toString().replace(IOUtils.LINE_SEPARATOR_UNIX, ""), Integer.valueOf(qrRewardGrantUI.aaX.isChecked() ? 1 : 0));
        m eVar = new com.tencent.mm.plugin.collect.reward.a.e(qrRewardGrantUI.kDQ, qrRewardGrantUI.kDR, qrRewardGrantUI.kDW, qrRewardGrantUI.kDS, r5, qrRewardGrantUI.cIb, qrRewardGrantUI.kDY, qrRewardGrantUI.kDU, qrRewardGrantUI.hAh, qrRewardGrantUI.kDZ, qrRewardGrantUI.kEa, r12);
        eVar.z(qrRewardGrantUI);
        qrRewardGrantUI.a(eVar, true, true);
        AppMethodBeat.o(41080);
    }

    static /* synthetic */ void d(QrRewardGrantUI qrRewardGrantUI) {
        AppMethodBeat.i(41081);
        ab.i("MicroMsg.QrRewardGrantUI", "start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.czZ = qrRewardGrantUI.czZ;
        payInfo.cIf = 48;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", qrRewardGrantUI.kDW);
        bundle.putString("extinfo_key_2", qrRewardGrantUI.kDX);
        bundle.putString("extinfo_key_3", qrRewardGrantUI.kDS);
        bundle.putString("extinfo_key_7", qrRewardGrantUI.kDO.getText().toString().replace(IOUtils.LINE_SEPARATOR_UNIX, ""));
        payInfo.vwh = bundle;
        com.tencent.mm.pluginsdk.wallet.h.a(qrRewardGrantUI, payInfo, 1);
        AppMethodBeat.o(41081);
    }
}
