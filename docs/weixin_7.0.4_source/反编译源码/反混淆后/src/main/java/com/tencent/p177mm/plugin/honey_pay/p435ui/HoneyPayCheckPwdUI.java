package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.plugin.honey_pay.p434a.C12220d;
import com.tencent.p177mm.plugin.honey_pay.p434a.C28286c;
import com.tencent.p177mm.plugin.honey_pay.p434a.C3287n;
import com.tencent.p177mm.plugin.honey_pay.p434a.C39245g;
import com.tencent.p177mm.plugin.honey_pay.p434a.C46021h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35473w;
import com.tencent.p177mm.protocal.protobuf.chl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI */
public class HoneyPayCheckPwdUI extends HoneyPayBaseUI {
    private int gOW;
    private TextView iDT;
    private String igi;
    private TextView kEq;
    private EditHintPasswdView nrZ;
    private String nra;
    private chl nrb;
    private String nsa;
    private String nsb;
    private long nsc;
    private int nsd;

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$11 */
    class C1223011 implements C40929a {
        C1223011() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41844);
            if (HoneyPayCheckPwdUI.this.nrZ != null) {
                HoneyPayCheckPwdUI.this.nrZ.cey();
            }
            C7060h.pYm.mo15419k(875, 3, 1);
            AppMethodBeat.m2505o(41844);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$12 */
    class C1223112 implements C40929a {
        C1223112() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41845);
            if (HoneyPayCheckPwdUI.this.nrZ != null) {
                HoneyPayCheckPwdUI.this.nrZ.cey();
            }
            C7060h.pYm.mo15419k(875, 3, 1);
            AppMethodBeat.m2505o(41845);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$1 */
    class C122321 implements C30883a {
        C122321() {
        }

        /* renamed from: hY */
        public final void mo9438hY(boolean z) {
            AppMethodBeat.m2504i(41833);
            if (z) {
                if (HoneyPayCheckPwdUI.this.gOW == 1) {
                    HoneyPayCheckPwdUI.m85586b(HoneyPayCheckPwdUI.this);
                } else if (HoneyPayCheckPwdUI.this.gOW == 2) {
                    HoneyPayCheckPwdUI.m85587c(HoneyPayCheckPwdUI.this);
                } else if (HoneyPayCheckPwdUI.this.gOW == 3) {
                    HoneyPayCheckPwdUI.m85588d(HoneyPayCheckPwdUI.this);
                } else {
                    C4990ab.m7421w("MicroMsg.HoneyPayCheckPwdUI", "unknown scene: %s", Integer.valueOf(HoneyPayCheckPwdUI.this.gOW));
                }
                HoneyPayCheckPwdUI.this.aoB();
            }
            AppMethodBeat.m2505o(41833);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$14 */
    class C2106014 implements C40929a {
        C2106014() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41847);
            if (HoneyPayCheckPwdUI.this.nrZ != null) {
                HoneyPayCheckPwdUI.this.nrZ.cey();
            }
            C7060h.pYm.mo15419k(875, 9, 1);
            AppMethodBeat.m2505o(41847);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$8 */
    class C210628 implements C40929a {
        C210628() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41842);
            if (HoneyPayCheckPwdUI.this.nrZ != null) {
                HoneyPayCheckPwdUI.this.nrZ.cey();
            }
            C7060h.pYm.mo15419k(875, 7, 1);
            AppMethodBeat.m2505o(41842);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$10 */
    class C3434210 implements OnClickListener {
        C3434210() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$5 */
    class C343435 implements C40929a {
        C343435() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41839);
            if (HoneyPayCheckPwdUI.this.nrZ != null) {
                HoneyPayCheckPwdUI.this.nrZ.cey();
            }
            HoneyPayCheckPwdUI.this.bgk();
            AppMethodBeat.m2505o(41839);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$6 */
    class C343446 implements C40929a {
        C343446() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41840);
            HoneyPayCheckPwdUI.m85588d(HoneyPayCheckPwdUI.this);
            AppMethodBeat.m2505o(41840);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$9 */
    class C343459 implements C40929a {
        C343459() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41843);
            HoneyPayCheckPwdUI.this.setResult(-1);
            HoneyPayCheckPwdUI.this.finish();
            C7060h.pYm.mo15419k(875, 6, 1);
            AppMethodBeat.m2505o(41843);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$4 */
    class C412914 implements C40929a {
        C412914() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41838);
            if (HoneyPayCheckPwdUI.this.nrZ != null) {
                HoneyPayCheckPwdUI.this.nrZ.cey();
            }
            HoneyPayCheckPwdUI.this.bgk();
            AppMethodBeat.m2505o(41838);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$15 */
    class C4602315 implements C40929a {
        C4602315() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41848);
            if (HoneyPayCheckPwdUI.this.nrZ != null) {
                HoneyPayCheckPwdUI.this.nrZ.cey();
            }
            C7060h.pYm.mo15419k(875, 9, 1);
            AppMethodBeat.m2505o(41848);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$17 */
    class C4602417 implements C40929a {
        C4602417() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41850);
            if (HoneyPayCheckPwdUI.this.nrZ != null) {
                HoneyPayCheckPwdUI.this.nrZ.cey();
            }
            HoneyPayCheckPwdUI.this.bgk();
            AppMethodBeat.m2505o(41850);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$7 */
    class C460257 implements C40929a {
        C460257() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41841);
            if (HoneyPayCheckPwdUI.this.nrZ != null) {
                HoneyPayCheckPwdUI.this.nrZ.cey();
            }
            C7060h.pYm.mo15419k(875, 7, 1);
            AppMethodBeat.m2505o(41841);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41851);
        super.onCreate(bundle);
        this.igi = getIntent().getStringExtra("key_username");
        this.nsa = getIntent().getStringExtra("key_take_message");
        this.nsc = getIntent().getLongExtra("key_credit_line", 0);
        this.gOW = getIntent().getIntExtra("key_scene", 0);
        this.nra = getIntent().getStringExtra("key_card_no");
        this.nsb = getIntent().getStringExtra("key_wishing");
        if (this.gOW == 1) {
            this.nsd = getIntent().getIntExtra("key_cardtype", 0);
            if (this.nsd == 0) {
                C4990ab.m7421w("MicroMsg.HoneyPayCheckPwdUI", "error card type: %s", Integer.valueOf(this.nsd));
                finish();
            }
        }
        if (this.gOW == 3) {
            chl chl = new chl();
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_toke_mess");
                if (byteArrayExtra == null || byteArrayExtra.length == 0) {
                    C4990ab.m7420w("MicroMsg.HoneyPayCheckPwdUI", "toke mess is null when unbind !!!");
                    finish();
                }
                chl.parseFrom(byteArrayExtra);
                this.nrb = chl;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.HoneyPayCheckPwdUI", e, "", new Object[0]);
                finish();
            }
        }
        setMMTitle("");
        mo39992nf(2662);
        mo39992nf(2865);
        mo39992nf(2630);
        mo39992nf(2815);
        mo39992nf(2659);
        initView();
        AppMethodBeat.m2505o(41851);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41852);
        this.nrZ = (EditHintPasswdView) findViewById(2131824902);
        C30890a.m49291a(this.nrZ);
        this.nrZ.setOnInputValidListener(new C122321());
        mo39989e(this.nrZ, 0, false);
        this.iDT = (TextView) findViewById(2131824899);
        this.kEq = (TextView) findViewById(2131824900);
        if (this.gOW == 1) {
            this.iDT.setText(C25738R.string.cc5);
        } else if (this.gOW == 2) {
            this.iDT.setText(C25738R.string.cc6);
        } else {
            this.iDT.setText(C25738R.string.cc8);
        }
        this.kEq.setText(C25738R.string.cc7);
        AppMethodBeat.m2505o(41852);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41853);
        super.onDestroy();
        mo39993ng(2662);
        mo39993ng(2865);
        mo39993ng(2630);
        mo39993ng(2815);
        mo39993ng(2659);
        AppMethodBeat.m2505o(41853);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41854);
        C4990ab.m7411d("MicroMsg.HoneyPayCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m instanceof C35473w) {
            C35473w c35473w = (C35473w) c1207m;
            String str2;
            C1207m c46021h;
            if (i != 0 || i2 != 0) {
                if (this.nrZ != null) {
                    this.nrZ.cey();
                }
                bgk();
                if (!(c35473w.AfO || C5046bo.isNullOrNil(str))) {
                    C4990ab.m7416i("MicroMsg.HoneyPayCheckPwdUI", "show normal error msg");
                    C30379h.m48448a(this.mController.ylL, str, null, false, new C3434210());
                }
                AppMethodBeat.m2505o(41854);
                return true;
            } else if (this.gOW == 1) {
                String str3 = c35473w.tuu;
                C4990ab.m7416i("MicroMsg.HoneyPayCheckPwdUI", "do give card");
                dOG();
                C1207m c28286c = new C28286c(str3, this.nsc, this.igi, this.nsa, this.nsd, this.nsb);
                c28286c.mo70321o(this);
                mo39970a(c28286c, false, false);
            } else if (this.gOW == 2) {
                str2 = c35473w.tuu;
                C4990ab.m7416i("MicroMsg.HoneyPayCheckPwdUI", "do modify quota");
                dOG();
                c46021h = new C46021h(this.nsc, str2, this.nra);
                c46021h.mo70321o(this);
                mo39970a(c46021h, false, false);
            } else if (this.gOW == 3) {
                str2 = c35473w.tuu;
                C4990ab.m7417i("MicroMsg.HoneyPayCheckPwdUI", "do unbind: %s", this.nra);
                dOG();
                c46021h = new C3287n(this.nra, str2);
                c46021h.mo70321o(this);
                mo39970a(c46021h, false, false);
            }
        } else if (c1207m instanceof C28286c) {
            final C28286c c28286c2 = (C28286c) c1207m;
            bgk();
            c28286c2.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41846);
                    C4990ab.m7416i("MicroMsg.HoneyPayCheckPwdUI", "create success");
                    Intent intent = new Intent(HoneyPayCheckPwdUI.this.mController.ylL, HoneyPayMainUI.class);
                    intent.putExtra("key_create_succ", true);
                    if (c28286c2.nqz.wci != null) {
                        intent.putExtra("key_card_no", c28286c2.nqz.wci.wpp);
                        intent.putExtra("key_card_type", c28286c2.nqz.wci.kdf);
                    }
                    Toast.makeText(HoneyPayCheckPwdUI.this.mController.ylL, C25738R.string.cc9, 1).show();
                    HoneyPayCheckPwdUI.this.startActivity(intent);
                    C7060h.pYm.mo15419k(875, 2, 1);
                    AppMethodBeat.m2505o(41846);
                }
            }).mo70319b(new C1223112()).mo70320c(new C1223011());
        } else if (c1207m instanceof C46021h) {
            bgk();
            final C46021h c46021h2 = (C46021h) c1207m;
            c46021h2.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41849);
                    C4990ab.m7416i("MicroMsg.HoneyPayCheckPwdUI", "modify success");
                    Intent intent = new Intent();
                    intent.putExtra("key_modify_create_line_succ", true);
                    intent.putExtra("key_credit_line", c46021h2.nqF);
                    HoneyPayCheckPwdUI.this.setResult(-1, intent);
                    HoneyPayCheckPwdUI.this.finish();
                    C7060h.pYm.mo15419k(875, 8, 1);
                    AppMethodBeat.m2505o(41849);
                }
            }).mo70319b(new C4602315()).mo70320c(new C2106014());
        } else if (c1207m instanceof C12220d) {
            final C12220d c12220d = (C12220d) c1207m;
            c12220d.mo70318a(new C40929a() {

                /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$3$1 */
                class C210611 implements OnClickListener {
                    C210611() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(41836);
                        HoneyPayCheckPwdUI.m85588d(HoneyPayCheckPwdUI.this);
                        AppMethodBeat.m2505o(41836);
                    }
                }

                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41837);
                    HoneyPayCheckPwdUI.this.nrb = c12220d.nqA.woi;
                    if (c12220d.nqA.woj != null) {
                        C28289c.m44882a(HoneyPayCheckPwdUI.this, c12220d.nqA.woj, new C210611());
                        HoneyPayCheckPwdUI.this.bgk();
                        AppMethodBeat.m2505o(41837);
                        return;
                    }
                    HoneyPayCheckPwdUI.m85588d(HoneyPayCheckPwdUI.this);
                    AppMethodBeat.m2505o(41837);
                }
            }).mo70319b(new C40929a() {

                /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI$2$1 */
                class C283001 implements OnClickListener {
                    C283001() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(41834);
                        HoneyPayCheckPwdUI.m85588d(HoneyPayCheckPwdUI.this);
                        AppMethodBeat.m2505o(41834);
                    }
                }

                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41835);
                    if (c12220d.nqA.woj != null) {
                        C28289c.m44882a(HoneyPayCheckPwdUI.this, c12220d.nqA.woj, new C283001());
                    } else if (HoneyPayCheckPwdUI.this.nrZ != null) {
                        HoneyPayCheckPwdUI.this.nrZ.cey();
                    }
                    HoneyPayCheckPwdUI.this.bgk();
                    AppMethodBeat.m2505o(41835);
                }
            }).mo70320c(new C4602417());
        } else if (c1207m instanceof C39245g) {
            C39245g c39245g = (C39245g) c1207m;
            this.nrb = c39245g.nqD.woi;
            c39245g.mo70318a(new C343446()).mo70319b(new C343435()).mo70320c(new C412914());
        } else if (c1207m instanceof C3287n) {
            bgk();
            ((C3287n) c1207m).mo70318a(new C343459()).mo70319b(new C210628()).mo70320c(new C460257());
        }
        AppMethodBeat.m2505o(41854);
        return true;
    }

    /* renamed from: wU */
    public final void mo8137wU(int i) {
        AppMethodBeat.m2504i(41855);
        super.mo8137wU(i);
        if (this.nrZ != null) {
            this.nrZ.cey();
        }
        AppMethodBeat.m2505o(41855);
    }

    public final int getLayoutId() {
        return 2130969829;
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: b */
    static /* synthetic */ void m85586b(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        AppMethodBeat.m2504i(41856);
        C4990ab.m7416i("MicroMsg.HoneyPayCheckPwdUI", "do get create token sign");
        honeyPayCheckPwdUI.dOG();
        C1207m c12220d = new C12220d(honeyPayCheckPwdUI.nsa, honeyPayCheckPwdUI.nsc);
        c12220d.mo70321o(honeyPayCheckPwdUI);
        honeyPayCheckPwdUI.mo39970a(c12220d, false, false);
        AppMethodBeat.m2505o(41856);
    }

    /* renamed from: c */
    static /* synthetic */ void m85587c(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        AppMethodBeat.m2504i(41857);
        C4990ab.m7416i("MicroMsg.HoneyPayCheckPwdUI", "modify credit line token sign");
        honeyPayCheckPwdUI.dOG();
        C1207m c39245g = new C39245g(honeyPayCheckPwdUI.nra, honeyPayCheckPwdUI.nsc);
        c39245g.mo70321o(honeyPayCheckPwdUI);
        honeyPayCheckPwdUI.mo39970a(c39245g, false, false);
        AppMethodBeat.m2505o(41857);
    }

    /* renamed from: d */
    static /* synthetic */ void m85588d(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        boolean z = true;
        AppMethodBeat.m2504i(41858);
        String str = "MicroMsg.HoneyPayCheckPwdUI";
        String str2 = "do get pwd token: %s";
        Object[] objArr = new Object[1];
        if (honeyPayCheckPwdUI.nrb != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (honeyPayCheckPwdUI.nrb != null) {
            honeyPayCheckPwdUI.dOG();
            honeyPayCheckPwdUI.mo39970a(new C35473w(honeyPayCheckPwdUI.nrZ.getText(), honeyPayCheckPwdUI.nrb.xgi, honeyPayCheckPwdUI.nrb.xgh, honeyPayCheckPwdUI.nrb.sign, honeyPayCheckPwdUI.nrb.kmr, honeyPayCheckPwdUI.nrb.wmb), false, false);
        }
        AppMethodBeat.m2505o(41858);
    }
}
