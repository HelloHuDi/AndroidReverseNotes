package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.plugin.honey_pay.p434a.C12222m;
import com.tencent.p177mm.plugin.honey_pay.p434a.C28287e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44086g;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.atk;
import com.tencent.p177mm.protocal.protobuf.bnn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI */
public class HoneyPayReceiveCardUI extends HoneyPayBaseUI {
    private int gOW;
    private String nra;
    private ImageView nsP;
    private TextView nsQ;
    private TextView nsR;
    private TextView nsS;
    private TextView nsT;
    private TextView nsU;
    private TextView nsV;
    private TextView nsW;
    private TextView nsX;
    private TextView nsY;
    private LinearLayout nsZ;
    private CdnImageView nta;
    private C44086g ntb = new C343581();

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI$4 */
    class C283114 implements C40929a {
        C283114() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI$6 */
    class C283126 implements C40929a {
        C283126() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41938);
            C7060h.pYm.mo15419k(875, 5, 1);
            AppMethodBeat.m2505o(41938);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI$1 */
    class C343581 implements C44086g {
        C343581() {
        }

        /* renamed from: a */
        public final Object mo27726a(C14932m c14932m) {
            return null;
        }

        /* renamed from: b */
        public final Object mo27727b(C14932m c14932m) {
            AppMethodBeat.m2504i(41935);
            if (c14932m.type == 1) {
                Object obj = c14932m.data;
                if (obj != null && (obj instanceof Bundle) && ((Bundle) obj).getBoolean("click_help", false)) {
                    C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                }
            }
            AppMethodBeat.m2505o(41935);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI$3 */
    class C392473 implements C40929a {
        C392473() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI$2 */
    class C392502 implements OnClickListener {
        C392502() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41936);
            HoneyPayReceiveCardUI.m66886a(HoneyPayReceiveCardUI.this);
            AppMethodBeat.m2505o(41936);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public HoneyPayReceiveCardUI() {
        AppMethodBeat.m2504i(41942);
        AppMethodBeat.m2505o(41942);
    }

    /* renamed from: a */
    static /* synthetic */ void m66887a(HoneyPayReceiveCardUI honeyPayReceiveCardUI, bnn bnn) {
        AppMethodBeat.m2504i(41950);
        honeyPayReceiveCardUI.m66888a(bnn);
        AppMethodBeat.m2505o(41950);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41943);
        this.nqT = C25738R.color.f12095s3;
        super.onCreate(bundle);
        C44089j.m79291a(this.ntb);
        mo39992nf(2613);
        mo39992nf(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        this.nra = getIntent().getStringExtra("key_card_no");
        this.gOW = getIntent().getIntExtra("key_scene", 0);
        initView();
        if (this.gOW == 1) {
            bnn bnn = new bnn();
            try {
                bnn.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
                m66888a(bnn);
                if (bnn.wps != null) {
                    setMMTitle(bnn.wps.kdf);
                }
                AppMethodBeat.m2505o(41943);
                return;
            } catch (IOException e) {
                C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                bGa();
                AppMethodBeat.m2505o(41943);
                return;
            }
        }
        bGa();
        AppMethodBeat.m2505o(41943);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41944);
        this.nsP = (ImageView) findViewById(2131824935);
        this.nsQ = (TextView) findViewById(2131824934);
        this.nsV = (TextView) findViewById(2131824930);
        this.nsR = (TextView) findViewById(2131824938);
        this.nsY = (TextView) findViewById(2131824939);
        this.nsS = (TextView) findViewById(2131824933);
        this.nsT = (TextView) findViewById(2131824940);
        this.nsU = (TextView) findViewById(2131824941);
        this.nsZ = (LinearLayout) findViewById(2131824937);
        this.nsW = (TextView) findViewById(2131824931);
        this.nsX = (TextView) findViewById(2131824932);
        this.nta = (CdnImageView) findViewById(2131824936);
        this.nsT.setOnClickListener(new C392502());
        AppMethodBeat.m2505o(41944);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41945);
        super.onDestroy();
        C44089j.m79297b(this.ntb);
        mo39993ng(2613);
        mo39993ng(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        AppMethodBeat.m2505o(41945);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41946);
        if (c1207m instanceof C12222m) {
            final C12222m c12222m = (C12222m) c1207m;
            c12222m.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41937);
                    HoneyPayReceiveCardUI.m66887a(HoneyPayReceiveCardUI.this, c12222m.nqK);
                    AppMethodBeat.m2505o(41937);
                }
            }).mo70319b(new C283114()).mo70320c(new C392473());
        } else if (c1207m instanceof C28287e) {
            final C28287e c28287e = (C28287e) c1207m;
            c28287e.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41940);
                    if (c28287e.nqB.vYe != null) {
                        C4990ab.m7416i(HoneyPayReceiveCardUI.this.TAG, "do real name");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
                        C28289c.m44883a(HoneyPayReceiveCardUI.this, bundle, c28287e.nqB.vYe, false);
                    } else {
                        HoneyPayReceiveCardUI.m66889b(HoneyPayReceiveCardUI.this);
                        C28289c.m44878OC(HoneyPayReceiveCardUI.this.nra);
                        HoneyPayReceiveCardUI.this.finish();
                    }
                    C7060h.pYm.mo15419k(875, 4, 1);
                    AppMethodBeat.m2505o(41940);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41939);
                    if (c28287e.nqB.vYe != null) {
                        C4990ab.m7416i(HoneyPayReceiveCardUI.this.TAG, "do real name");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
                        C28289c.m44883a(HoneyPayReceiveCardUI.this, bundle, c28287e.nqB.vYe, false);
                    }
                    C7060h.pYm.mo15419k(875, 5, 1);
                    AppMethodBeat.m2505o(41939);
                }
            }).mo70320c(new C283126());
        }
        AppMethodBeat.m2505o(41946);
        return true;
    }

    public final int getLayoutId() {
        return 2130969835;
    }

    /* renamed from: a */
    private void m66888a(final bnn bnn) {
        AppMethodBeat.m2504i(41947);
        if (bnn.wps == null) {
            AppMethodBeat.m2505o(41947);
            return;
        }
        atk atk = bnn.wps;
        this.nsU.setText(atk.wxs);
        this.nsW.setText(C44089j.m79293b(this.mController.ylL, atk.nSd, this.nsW.getTextSize()));
        Object bundle = new Bundle();
        bundle.putBoolean("click_help", true);
        this.nsX.setText(C44089j.m79285a(this.mController.ylL, atk.pMg, (int) this.nsX.getTextSize(), bundle));
        this.nsX.setClickable(true);
        this.nsX.setOnTouchListener(new C30132m(this));
        if (C5046bo.isNullOrNil(bnn.wNr)) {
            C4990ab.m7410d(this.TAG, "no help url");
            this.nsS.setVisibility(8);
        } else {
            C35503o c35503o = new C35503o(new C35502a() {
                /* renamed from: df */
                public final void mo9537df(View view) {
                    AppMethodBeat.m2504i(41941);
                    if (!C5046bo.isNullOrNil(bnn.wNs)) {
                        C36391e.m60016n(HoneyPayReceiveCardUI.this.mController.ylL, bnn.wNs, false);
                    }
                    C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.m2505o(41941);
                }
            });
            SpannableString spannableString = new SpannableString(bnn.wNr);
            spannableString.setSpan(c35503o, 0, spannableString.length(), 18);
            this.nsS.setText(spannableString);
            this.nsS.setOnTouchListener(new C30132m(this));
            this.nsS.setClickable(true);
        }
        this.nsR.setText(atk.kdf);
        C40460b.m69433a(this.nsP, atk.vAh, 0.06f, false);
        C36391e.m60004d(this.nsQ, atk.vAh);
        C36391e.m60004d(this.nsY, atk.vAh);
        if (atk.iAd == 1) {
            this.nsV.setText(C25738R.string.cca);
        } else if (atk.iAd == 2) {
            this.nsV.setText(C25738R.string.ccx);
        } else {
            this.nsV.setText(C44089j.m79293b((Context) this, C36391e.m60007eK(C1853r.m3820YB(), 16), this.nsV.getTextSize()));
        }
        if (C5046bo.isNullOrNil(atk.kKZ)) {
            this.nta.setImageResource(C28289c.bFX());
            AppMethodBeat.m2505o(41947);
            return;
        }
        this.nta.mo38952eb(atk.kKZ, C28289c.bFX());
        AppMethodBeat.m2505o(41947);
    }

    private void bGa() {
        AppMethodBeat.m2504i(41948);
        C4990ab.m7416i(this.TAG, "qry user detail");
        C1207m c12222m = new C12222m(this.nra);
        c12222m.mo70321o(this);
        mo39970a(c12222m, true, false);
        AppMethodBeat.m2505o(41948);
    }

    /* renamed from: b */
    static /* synthetic */ void m66889b(HoneyPayReceiveCardUI honeyPayReceiveCardUI) {
        AppMethodBeat.m2504i(41951);
        C4990ab.m7416i(honeyPayReceiveCardUI.TAG, "go to honey pay card detail");
        Intent intent = new Intent(honeyPayReceiveCardUI, HoneyPayCardDetailUI.class);
        intent.putExtra("key_scene", 0);
        intent.putExtra("key_card_no", honeyPayReceiveCardUI.nra);
        honeyPayReceiveCardUI.startActivity(intent);
        AppMethodBeat.m2505o(41951);
    }
}
