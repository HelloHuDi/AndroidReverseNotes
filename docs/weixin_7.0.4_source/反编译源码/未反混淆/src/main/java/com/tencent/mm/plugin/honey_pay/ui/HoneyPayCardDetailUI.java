package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

public class HoneyPayCardDetailUI extends HoneyPayBaseUI {
    private int gOW;
    private ImageView kEn;
    private String nra;
    private TextView nre;
    private TextView nrf;
    private TextView nrg;
    private TextView nrh;
    private TextView nri;
    private TextView nrj;
    private RelativeLayout nrk;
    private CdnImageView nrl;
    private TextView nrm;
    private Button nrn;
    private bnn nro;
    private asi nrp;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(HoneyPayCardDetailUI honeyPayCardDetailUI) {
        AppMethodBeat.i(41787);
        honeyPayCardDetailUI.bFZ();
        AppMethodBeat.o(41787);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41781);
        this.nqT = R.color.s3;
        super.onCreate(bundle);
        nf(2613);
        this.gOW = getIntent().getIntExtra("key_scene", 0);
        this.nra = getIntent().getStringExtra("key_card_no");
        initView();
        if (this.gOW == 0) {
            bGa();
            AppMethodBeat.o(41781);
            return;
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_qry_response");
        try {
            this.nro = new bnn();
            this.nro.parseFrom(byteArrayExtra);
            bFZ();
            AppMethodBeat.o(41781);
        } catch (IOException e) {
            ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            bGa();
            AppMethodBeat.o(41781);
        }
    }

    public final void initView() {
        AppMethodBeat.i(41782);
        this.kEn = (ImageView) findViewById(R.id.cef);
        this.nre = (TextView) findViewById(R.id.ceg);
        this.nrf = (TextView) findViewById(R.id.ceh);
        this.nri = (TextView) findViewById(R.id.cep);
        this.nrj = (TextView) findViewById(R.id.ces);
        this.nrg = (TextView) findViewById(R.id.ceo);
        this.nrh = (TextView) findViewById(R.id.cer);
        this.nrk = (RelativeLayout) findViewById(R.id.cej);
        this.nrl = (CdnImageView) findViewById(R.id.cek);
        this.nrm = (TextView) findViewById(R.id.cel);
        this.nrn = (Button) findViewById(R.id.cem);
        this.nrf.setClickable(true);
        this.nrf.setOnTouchListener(new m(this));
        AppMethodBeat.o(41782);
    }

    public void onDestroy() {
        AppMethodBeat.i(41783);
        super.onDestroy();
        ng(2613);
        AppMethodBeat.o(41783);
    }

    public final boolean c(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(41784);
        if (mVar instanceof com.tencent.mm.plugin.honey_pay.a.m) {
            final com.tencent.mm.plugin.honey_pay.a.m mVar2 = (com.tencent.mm.plugin.honey_pay.a.m) mVar;
            mVar2.a(new a() {
                public final void e(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(41779);
                    HoneyPayCardDetailUI.this.nro = mVar2.nqK;
                    HoneyPayCardDetailUI.a(HoneyPayCardDetailUI.this);
                    AppMethodBeat.o(41779);
                }
            }).b(new a() {
                public final void e(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                }
            }).c(new a() {
                public final void e(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                }
            });
        }
        AppMethodBeat.o(41784);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.a6u;
    }

    private void bFZ() {
        AppMethodBeat.i(41785);
        if (this.nro.wps == null) {
            AppMethodBeat.o(41785);
            return;
        }
        atk atk = this.nro.wps;
        setMMTitle(atk.kdf);
        this.nre.setText(atk.wxw);
        int i = atk.state;
        if (i == 2) {
            this.kEn.setImageResource(R.drawable.blu);
            if (!bo.isNullOrNil(atk.wxs)) {
                atk.wxs = c.eG(atk.wxs, this.nro.wps.vAh);
                this.nrf.setText(j.a((Context) this, atk.wxs, (int) this.nrf.getTextSize(), null));
            }
            findViewById(R.id.cei).setVisibility(8);
            findViewById(R.id.cen).setVisibility(8);
            findViewById(R.id.ceq).setVisibility(8);
            if (this.nrp != null) {
                this.nrk.setVisibility(0);
                this.nrl.setUrl(this.nrp.cIY);
                this.nrm.setText(this.nrp.wvV);
                this.nrn.setText(this.nrp.wvU);
                this.nrn.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(41780);
                        ab.d(HoneyPayCardDetailUI.this.TAG, "click oper btn: %s", HoneyPayCardDetailUI.this.nrp.url);
                        if (!bo.isNullOrNil(HoneyPayCardDetailUI.this.nrp.url)) {
                            e.n(HoneyPayCardDetailUI.this.mController.ylL, HoneyPayCardDetailUI.this.nrp.url, false);
                        }
                        AppMethodBeat.o(41780);
                    }
                });
                AppMethodBeat.o(41785);
                return;
            }
        } else if (i == 3) {
            this.kEn.setImageResource(R.raw.remittance_timed_out);
            if (!bo.isNullOrNil(atk.wxs)) {
                this.nrf.setText(atk.wxs);
            }
            this.nrg.setText(R.string.cd2);
            this.nrh.setText(R.string.cd4);
            this.nri.setText(c.iS((long) this.nro.wps.vNm));
            this.nrj.setText(c.iS((long) this.nro.wps.kbK));
            AppMethodBeat.o(41785);
            return;
        } else if (i == 4) {
            this.kEn.setImageResource(R.raw.remittance_timed_out);
            if (!bo.isNullOrNil(atk.wxs)) {
                this.nrf.setText(j.e((Context) this, atk.wxs, (int) this.nrf.getTextSize()));
            }
            this.nrg.setText(R.string.cd3);
            this.nri.setText(c.iS((long) this.nro.wps.wxu));
            findViewById(R.id.ceq).setVisibility(8);
        }
        AppMethodBeat.o(41785);
    }

    private void bGa() {
        AppMethodBeat.i(41786);
        com.tencent.mm.ai.m mVar = new com.tencent.mm.plugin.honey_pay.a.m(this.nra);
        mVar.o(this);
        a(mVar, true, false);
        AppMethodBeat.o(41786);
    }
}
