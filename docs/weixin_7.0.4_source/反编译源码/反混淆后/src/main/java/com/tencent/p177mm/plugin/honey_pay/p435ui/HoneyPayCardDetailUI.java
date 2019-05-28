package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.plugin.honey_pay.p434a.C12222m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.asi;
import com.tencent.p177mm.protocal.protobuf.atk;
import com.tencent.p177mm.protocal.protobuf.bnn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI */
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

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI$2 */
    class C122272 implements C40929a {
        C122272() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI$4 */
    class C122284 implements OnClickListener {
        C122284() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41780);
            C4990ab.m7411d(HoneyPayCardDetailUI.this.TAG, "click oper btn: %s", HoneyPayCardDetailUI.this.nrp.url);
            if (!C5046bo.isNullOrNil(HoneyPayCardDetailUI.this.nrp.url)) {
                C36391e.m60016n(HoneyPayCardDetailUI.this.mController.ylL, HoneyPayCardDetailUI.this.nrp.url, false);
            }
            AppMethodBeat.m2505o(41780);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI$1 */
    class C282941 implements C40929a {
        C282941() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m85578a(HoneyPayCardDetailUI honeyPayCardDetailUI) {
        AppMethodBeat.m2504i(41787);
        honeyPayCardDetailUI.bFZ();
        AppMethodBeat.m2505o(41787);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41781);
        this.nqT = C25738R.color.f12095s3;
        super.onCreate(bundle);
        mo39992nf(2613);
        this.gOW = getIntent().getIntExtra("key_scene", 0);
        this.nra = getIntent().getStringExtra("key_card_no");
        initView();
        if (this.gOW == 0) {
            bGa();
            AppMethodBeat.m2505o(41781);
            return;
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_qry_response");
        try {
            this.nro = new bnn();
            this.nro.parseFrom(byteArrayExtra);
            bFZ();
            AppMethodBeat.m2505o(41781);
        } catch (IOException e) {
            C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            bGa();
            AppMethodBeat.m2505o(41781);
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(41782);
        this.kEn = (ImageView) findViewById(2131824852);
        this.nre = (TextView) findViewById(2131824853);
        this.nrf = (TextView) findViewById(2131824854);
        this.nri = (TextView) findViewById(2131824862);
        this.nrj = (TextView) findViewById(2131824865);
        this.nrg = (TextView) findViewById(2131824861);
        this.nrh = (TextView) findViewById(2131824864);
        this.nrk = (RelativeLayout) findViewById(2131824856);
        this.nrl = (CdnImageView) findViewById(2131824857);
        this.nrm = (TextView) findViewById(2131824858);
        this.nrn = (Button) findViewById(2131824859);
        this.nrf.setClickable(true);
        this.nrf.setOnTouchListener(new C30132m(this));
        AppMethodBeat.m2505o(41782);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41783);
        super.onDestroy();
        mo39993ng(2613);
        AppMethodBeat.m2505o(41783);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41784);
        if (c1207m instanceof C12222m) {
            final C12222m c12222m = (C12222m) c1207m;
            c12222m.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41779);
                    HoneyPayCardDetailUI.this.nro = c12222m.nqK;
                    HoneyPayCardDetailUI.m85578a(HoneyPayCardDetailUI.this);
                    AppMethodBeat.m2505o(41779);
                }
            }).mo70319b(new C122272()).mo70320c(new C282941());
        }
        AppMethodBeat.m2505o(41784);
        return true;
    }

    public final int getLayoutId() {
        return 2130969821;
    }

    private void bFZ() {
        AppMethodBeat.m2504i(41785);
        if (this.nro.wps == null) {
            AppMethodBeat.m2505o(41785);
            return;
        }
        atk atk = this.nro.wps;
        setMMTitle(atk.kdf);
        this.nre.setText(atk.wxw);
        int i = atk.state;
        if (i == 2) {
            this.kEn.setImageResource(C25738R.drawable.blu);
            if (!C5046bo.isNullOrNil(atk.wxs)) {
                atk.wxs = C28289c.m44886eG(atk.wxs, this.nro.wps.vAh);
                this.nrf.setText(C44089j.m79285a((Context) this, atk.wxs, (int) this.nrf.getTextSize(), null));
            }
            findViewById(2131824855).setVisibility(8);
            findViewById(2131824860).setVisibility(8);
            findViewById(2131824863).setVisibility(8);
            if (this.nrp != null) {
                this.nrk.setVisibility(0);
                this.nrl.setUrl(this.nrp.cIY);
                this.nrm.setText(this.nrp.wvV);
                this.nrn.setText(this.nrp.wvU);
                this.nrn.setOnClickListener(new C122284());
                AppMethodBeat.m2505o(41785);
                return;
            }
        } else if (i == 3) {
            this.kEn.setImageResource(C1318a.remittance_timed_out);
            if (!C5046bo.isNullOrNil(atk.wxs)) {
                this.nrf.setText(atk.wxs);
            }
            this.nrg.setText(C25738R.string.cd2);
            this.nrh.setText(C25738R.string.cd4);
            this.nri.setText(C28289c.m44888iS((long) this.nro.wps.vNm));
            this.nrj.setText(C28289c.m44888iS((long) this.nro.wps.kbK));
            AppMethodBeat.m2505o(41785);
            return;
        } else if (i == 4) {
            this.kEn.setImageResource(C1318a.remittance_timed_out);
            if (!C5046bo.isNullOrNil(atk.wxs)) {
                this.nrf.setText(C44089j.m79304e((Context) this, atk.wxs, (int) this.nrf.getTextSize()));
            }
            this.nrg.setText(C25738R.string.cd3);
            this.nri.setText(C28289c.m44888iS((long) this.nro.wps.wxu));
            findViewById(2131824863).setVisibility(8);
        }
        AppMethodBeat.m2505o(41785);
    }

    private void bGa() {
        AppMethodBeat.m2504i(41786);
        C1207m c12222m = new C12222m(this.nra);
        c12222m.mo70321o(this);
        mo39970a(c12222m, true, false);
        AppMethodBeat.m2505o(41786);
    }
}
