package com.tencent.p177mm.plugin.remittance.p497ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p230g.p231a.C45350oc;
import com.tencent.p177mm.p230g.p231a.C6528od;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C44383m;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.order.model.C43363h;
import com.tencent.p177mm.plugin.order.p1008c.C12784a;
import com.tencent.p177mm.plugin.order.p1008c.C12784a.C12783a;
import com.tencent.p177mm.plugin.remittance.model.C46177u;
import com.tencent.p177mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt.WalletLqtDetailUI;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.C29624e;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a.C43798a;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14224ae;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C30158b;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C16077f;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C46722e;
import com.tencent.rtmp.TXLiveConstants;

/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI */
public class RemittanceDetailUI extends WalletBaseUI {
    private int jLX;
    private int jLY;
    private C24088a jMO = null;
    private C5279d lCi = new C4346910();
    private OnTouchListener mlU = new C2165511();
    private OnLongClickListener mlV = new C2165613();
    protected TextView ocV = null;
    private int pRA;
    protected String pRG = null;
    private LinearLayout pRn;
    private String pRz = null;
    protected TextView pUA = null;
    protected TextView pUB = null;
    protected TextView pUC = null;
    protected Button pUD = null;
    protected LinearLayout pUE;
    private LinearLayout pUF;
    private LinearLayout pUG;
    private LinearLayout pUH;
    private TextView pUI;
    private TextView pUJ;
    private TextView pUK;
    private TextView pUL;
    private TextView pUM;
    protected RelativeLayout pUN;
    protected ImageView pUO;
    protected TextView pUP;
    protected TextView pUQ;
    protected ImageView pUR;
    protected Button pUS;
    protected TextView pUT;
    protected View pUU;
    protected View pUV;
    protected View pUW;
    protected Button pUX = null;
    protected TextView pUY = null;
    protected LinearLayout pUZ;
    protected ImageView pUy = null;
    protected TextView pUz = null;
    private LinearLayout pVa;
    private LinearLayout pVb;
    private LinearLayout pVc;
    private LinearLayout pVd;
    private TextView pVe;
    private TextView pVf;
    private TextView pVg;
    private TextView pVh;
    private TextView pVi;
    protected int pVj;
    protected int pVk;
    public String pVl = null;
    public String pVm = null;
    protected String pVn = null;
    protected int pVo = 3;
    protected boolean pVp = false;
    protected int pVq;
    private int pVr;
    private C46177u pVs;
    private C4884c<C6528od> pVt = new C288841();
    private C4884c<C45350oc> pVu = new C2888212();
    private int pVv = 0;
    private String pcA;
    private String pcH;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$11 */
    class C2165511 implements OnTouchListener {
        C2165511() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(45007);
            switch (motionEvent.getAction()) {
                case 0:
                    RemittanceDetailUI.this.jLX = (int) motionEvent.getRawX();
                    RemittanceDetailUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(45007);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$13 */
    class C2165613 implements OnLongClickListener {
        C2165613() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(45011);
            C4990ab.m7410d("MicroMsg.RemittanceDetailUI", "onLongClick");
            if (RemittanceDetailUI.this.jMO == null) {
                RemittanceDetailUI.this.jMO = new C24088a(RemittanceDetailUI.this.mController.ylL);
            }
            RemittanceDetailUI.this.jMO.mo39886a(view, RemittanceDetailUI.this, RemittanceDetailUI.this.lCi, RemittanceDetailUI.this.jLX, RemittanceDetailUI.this.jLY);
            RemittanceDetailUI.this.pVv = view.getId();
            AppMethodBeat.m2505o(45011);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$14 */
    class C2165714 implements OnMenuItemClickListener {
        C2165714() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45012);
            C36391e.m60016n(RemittanceDetailUI.this.mController.ylL, RemittanceDetailUI.this.pRz, false);
            AppMethodBeat.m2505o(45012);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$12 */
    class C2888212 extends C4884c<C45350oc> {

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$12$1 */
        class C288831 implements Runnable {
            C288831() {
            }

            public final void run() {
                AppMethodBeat.m2504i(45008);
                RemittanceDetailUI.this.finish();
                AppMethodBeat.m2505o(45008);
            }
        }

        C2888212() {
            AppMethodBeat.m2504i(45009);
            this.xxI = C45350oc.class.getName().hashCode();
            AppMethodBeat.m2505o(45009);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(45010);
            C4990ab.m7416i("MicroMsg.RemittanceDetailUI", "RemittanceDetailUIFinishEvent");
            C5004al.m7442n(new C288831(), 500);
            AppMethodBeat.m2505o(45010);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$1 */
    class C288841 extends C4884c<C6528od> {

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$1$2 */
        class C288812 implements OnClickListener {
            C288812() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C288841() {
            AppMethodBeat.m2504i(44993);
            this.xxI = C6528od.class.getName().hashCode();
            AppMethodBeat.m2505o(44993);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44994);
            final C6528od c6528od = (C6528od) c4883b;
            if (!(C5046bo.isNullOrNil(c6528od.cKt.cAa) || C5046bo.isNullOrNil(c6528od.cKt.cEa))) {
                C30379h.m48466d(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(C25738R.string.dok, new Object[]{RemittanceDetailUI.m77642bc(RemittanceDetailUI.this.pcH, false)}), RemittanceDetailUI.this.getString(C25738R.string.f9213t6), RemittanceDetailUI.this.getString(C25738R.string.dop), RemittanceDetailUI.this.getString(C25738R.string.f9076or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(44992);
                        C1207m c46177u = new C46177u(c6528od.cKt.cAa, c6528od.cKt.cEa, c6528od.cKt.cKu, "refuse", c6528od.cKt.cKv, c6528od.cKt.cKw);
                        c46177u.eHT = "RemittanceProcess";
                        RemittanceDetailUI.this.mo39970a(c46177u, true, true);
                        AppMethodBeat.m2505o(44992);
                    }
                }, new C288812());
            }
            AppMethodBeat.m2505o(44994);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$10 */
    class C4346910 implements C5279d {
        C4346910() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(45006);
            ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
            CharSequence charSequence = "";
            StringBuilder stringBuilder;
            String trim;
            if (C5046bo.m7563gW(RemittanceDetailUI.this.pVv, 2131827031)) {
                charSequence = RemittanceDetailUI.this.pUJ.getText().toString().trim();
            } else if (C5046bo.m7563gW(RemittanceDetailUI.this.pVv, 2131827034)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(RemittanceDetailUI.this.pUK.getText().toString().trim() + " ");
                trim = RemittanceDetailUI.this.pUM.getText().toString().trim();
                if (trim.endsWith(RemittanceDetailUI.this.getString(C25738R.string.f9032n6))) {
                    stringBuilder.append(trim.substring(0, trim.length() - 4));
                } else {
                    stringBuilder.append(trim);
                }
                charSequence = stringBuilder.toString();
            } else if (C5046bo.m7563gW(RemittanceDetailUI.this.pVv, 2131827049)) {
                charSequence = RemittanceDetailUI.this.pVf.getText().toString().trim();
            } else if (C5046bo.m7563gW(RemittanceDetailUI.this.pVv, 2131827052)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(RemittanceDetailUI.this.pVg.getText().toString().trim() + " ");
                trim = RemittanceDetailUI.this.pVi.getText().toString().trim();
                if (trim.endsWith(RemittanceDetailUI.this.getString(C25738R.string.f9032n6))) {
                    stringBuilder.append(trim.substring(0, trim.length() - 4));
                } else {
                    stringBuilder.append(trim);
                }
                charSequence = stringBuilder.toString();
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, charSequence));
            C30379h.m48465bQ(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(C25738R.string.f9083oz));
            AppMethodBeat.m2505o(45006);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$15 */
    class C4347015 implements OnClickListener {
        C4347015() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45013);
            C30379h.m48465bQ(RemittanceDetailUI.this.mController.ylL, RemittanceDetailUI.this.getString(C25738R.string.doe));
            AppMethodBeat.m2505o(45013);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$16 */
    class C4347816 implements C16077f {
        C4347816() {
        }

        public final void bMI() {
            AppMethodBeat.m2504i(45014);
            RemittanceDetailUI.m77637a(RemittanceDetailUI.this, RemittanceDetailUI.this.pVs);
            AppMethodBeat.m2505o(45014);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$18 */
    class C4347918 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$18$1 */
        class C216581 implements C43798a {
            C216581() {
            }

            /* renamed from: c */
            public final boolean mo24759c(int i, int i2, String str, boolean z) {
                AppMethodBeat.m2504i(45017);
                if (i == 2) {
                    RemittanceDetailUI.this.cfV();
                    AppMethodBeat.m2505o(45017);
                } else {
                    if (i == 0 && z) {
                        RemittanceDetailUI.this.cfV();
                    }
                    AppMethodBeat.m2505o(45017);
                }
                return true;
            }
        }

        C4347918() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45018);
            ((C30158b) C1720g.m3528K(C30158b.class)).mo48437eA(9, 4);
            C14241r.cPD();
            MMActivity mMActivity = RemittanceDetailUI.this;
            C46722e c = RemittanceDetailUI.this.Ahr;
            C216581 c216581 = new C216581();
            if (!C14241r.m22436a(mMActivity, c)) {
                RemittanceDetailUI.this.cfV();
            }
            AppMethodBeat.m2505o(45018);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$20 */
    class C4348020 implements C12783a {
        C4348020() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45021);
            C35899h.m58862ak(RemittanceDetailUI.this, 0);
            AppMethodBeat.m2505o(45021);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RemittanceDetailUI() {
        AppMethodBeat.m2504i(45027);
        AppMethodBeat.m2505o(45027);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45028);
        super.onCreate(bundle);
        this.pVj = getIntent().getIntExtra("invalid_time", 0);
        this.pVk = getIntent().getIntExtra("appmsg_type", 0);
        this.pVl = getIntent().getStringExtra(C8741b.TRANSACTION_ID);
        this.pVn = getIntent().getStringExtra("bill_id");
        this.pRG = getIntent().getStringExtra("transfer_id");
        this.pVm = getIntent().getStringExtra("sender_name");
        this.pVo = getIntent().getIntExtra("effective_date", 3);
        this.pVp = getIntent().getBooleanExtra("is_sender", false);
        this.pVq = getIntent().getIntExtra("total_fee", 0);
        initView();
        mo56269BK(0);
        getIntent();
        C4879a.xxA.mo10052c(this.pVt);
        this.pVu.dnU();
        AppMethodBeat.m2505o(45028);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45029);
        C4879a.xxA.mo10053d(this.pVt);
        if (this.pVu != null) {
            this.pVu.dead();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(45029);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45030);
        C4990ab.m7417i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            mo56269BK(0);
        }
        AppMethodBeat.m2505o(45030);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: BK */
    public void mo56269BK(int i) {
        AppMethodBeat.m2504i(45031);
        mo39970a(new NetSceneTenpayRemittanceQuery(i, this.pVl, this.pRG, this.pVj), true, false);
        AppMethodBeat.m2505o(45031);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45032);
        setMMTitle("");
        dyb();
        mo17446xE(getResources().getColor(C25738R.color.f11677d4));
        this.pUy = (ImageView) findViewById(2131827021);
        this.pUz = (TextView) findViewById(2131827022);
        this.pUA = (TextView) findViewById(2131827023);
        this.pUD = (Button) findViewById(2131827026);
        this.ocV = (TextView) findViewById(2131827027);
        this.pUE = (LinearLayout) findViewById(2131827025);
        this.pUF = (LinearLayout) findViewById(2131827028);
        this.pUG = (LinearLayout) findViewById(2131822843);
        this.pRn = (LinearLayout) findViewById(2131827032);
        this.pUH = (LinearLayout) findViewById(2131827034);
        this.pUI = (TextView) findViewById(2131827030);
        this.pUJ = (TextView) findViewById(2131827031);
        this.pUK = (TextView) findViewById(2131827035);
        this.pUL = (TextView) findViewById(2131827036);
        this.pUM = (TextView) findViewById(2131827037);
        this.pUN = (RelativeLayout) findViewById(2131827039);
        this.pUO = (ImageView) findViewById(2131827040);
        this.pUP = (TextView) findViewById(2131827041);
        this.pUQ = (TextView) findViewById(2131827042);
        this.pUR = (ImageView) findViewById(2131827043);
        this.pUS = (Button) findViewById(2131822846);
        this.pUT = (TextView) findViewById(2131827059);
        this.pUU = findViewById(2131827044);
        this.pUV = findViewById(2131827029);
        this.pUW = findViewById(2131827038);
        this.pUX = (Button) findViewById(2131827056);
        this.pUY = (TextView) findViewById(2131827057);
        this.pUZ = (LinearLayout) findViewById(2131827045);
        this.pVa = (LinearLayout) findViewById(2131827046);
        this.pVb = (LinearLayout) findViewById(2131827047);
        this.pVc = (LinearLayout) findViewById(2131827050);
        this.pVd = (LinearLayout) findViewById(2131827052);
        this.pVe = (TextView) findViewById(2131827048);
        this.pVf = (TextView) findViewById(2131827049);
        this.pVg = (TextView) findViewById(2131827053);
        this.pVh = (TextView) findViewById(2131827054);
        this.pVi = (TextView) findViewById(2131827055);
        this.pUB = (TextView) findViewById(2131827060);
        this.pUC = (TextView) findViewById(2131827061);
        AppMethodBeat.m2505o(45032);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: BL */
    public void mo56270BL(int i) {
        C1207m c43363h;
        AppMethodBeat.m2504i(45033);
        if (getIntent().getBooleanExtra("is_sender", false)) {
            c43363h = new C43363h(this.pVl, this.pVn, i);
        } else {
            c43363h = new C43363h(this.pRG, this.pVn, i);
        }
        c43363h.eHT = "RemittanceProcess";
        mo39970a(c43363h, true, true);
        AppMethodBeat.m2505o(45033);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: an */
    public void mo56271an(Intent intent) {
        AppMethodBeat.m2504i(45034);
        C25985d.m41467b((Context) this, "remittance", ".ui.RemittanceResendMsgUI", intent);
        AppMethodBeat.m2505o(45034);
    }

    /* Access modifiers changed, original: protected */
    public void cfV() {
        AppMethodBeat.m2504i(45035);
        C1207m c46177u = new C46177u(this.pVl, this.pRG, this.pVq, "confirm", this.pVm, this.pVj);
        c46177u.eHT = "RemittanceProcess";
        mo39970a(c46177u, true, true);
        AppMethodBeat.m2505o(45035);
    }

    /* Access modifiers changed, original: protected */
    public void cfW() {
        AppMethodBeat.m2504i(45036);
        C1207m c46177u = new C46177u(this.pVl, this.pRG, this.pVq, "refuse", this.pVm, this.pVj);
        c46177u.eHT = "RemittanceProcess";
        mo39970a(c46177u, true, true);
        AppMethodBeat.m2505o(45036);
    }

    /* renamed from: a */
    private void m77639a(boolean z, boolean z2, final NetSceneTenpayRemittanceQuery netSceneTenpayRemittanceQuery) {
        AppMethodBeat.m2504i(45037);
        if (z) {
            this.pUE.setVisibility(8);
            this.pUZ.setVisibility(0);
            if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQm.pQs)) {
                this.pVa.setVisibility(8);
            } else {
                this.pVa.setVisibility(0);
                if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.desc)) {
                    this.pVb.setVisibility(8);
                } else {
                    this.pVb.setVisibility(0);
                    this.pVf.setText(netSceneTenpayRemittanceQuery.desc);
                    this.pVf.setOnLongClickListener(this.mlV);
                    this.pVf.setOnTouchListener(this.mlU);
                }
                if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQm.pQs)) {
                    this.pVc.setVisibility(8);
                } else {
                    this.pVc.setVisibility(0);
                    this.pVg.setText(netSceneTenpayRemittanceQuery.pQm.pQs + "  " + netSceneTenpayRemittanceQuery.pQm.gyD);
                    this.pVe.post(new Runnable() {

                        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$23$2 */
                        class C348182 implements C12783a {
                            C348182() {
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(45025);
                                RemittanceDetailUI.this.pVh.setVisibility(0);
                                RemittanceDetailUI.this.pVi.setVisibility(8);
                                C44383m.m80242a(RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(2131820884), RemittanceDetailUI.this.findViewById(2131827020), RemittanceDetailUI.this.findViewById(2131827024), RemittanceDetailUI.this.findViewById(2131827058));
                                AppMethodBeat.m2505o(45025);
                            }
                        }

                        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$23$1 */
                        class C434741 implements C12783a {
                            C434741() {
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(45024);
                                RemittanceDetailUI.this.pVh.setVisibility(8);
                                RemittanceDetailUI.this.pVi.setVisibility(0);
                                C44383m.m80242a(RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(2131820884), RemittanceDetailUI.this.findViewById(2131827020), RemittanceDetailUI.this.findViewById(2131827024), RemittanceDetailUI.this.findViewById(2131827058));
                                AppMethodBeat.m2505o(45024);
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(45026);
                            int n = RemittanceResultNewUI.m33175n(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQm.fBg, RemittanceDetailUI.this.pVe.getWidth());
                            if (C5046bo.m7563gW(n, netSceneTenpayRemittanceQuery.pQm.fBg.length())) {
                                RemittanceDetailUI.this.pVh.setText(netSceneTenpayRemittanceQuery.pQm.fBg);
                                RemittanceDetailUI.this.pVi.setText(netSceneTenpayRemittanceQuery.pQm.fBg);
                            } else {
                                String string = RemittanceDetailUI.this.getString(C25738R.string.f9036n_);
                                String str = netSceneTenpayRemittanceQuery.pQm.fBg.substring(0, n) + "... ";
                                SpannableString spannableString = new SpannableString(str + string);
                                C12784a c12784a = new C12784a(RemittanceDetailUI.this);
                                c12784a.peT = new C434741();
                                spannableString.setSpan(c12784a, str.length(), str.length() + string.length(), 33);
                                RemittanceDetailUI.this.pVh.setOnTouchListener(C13108a.cfs());
                                RemittanceDetailUI.this.pVh.setText(spannableString);
                                str = RemittanceDetailUI.this.getString(C25738R.string.f9032n6);
                                string = netSceneTenpayRemittanceQuery.pQm.fBg + "  ";
                                spannableString = new SpannableString(string + str);
                                c12784a = new C12784a(RemittanceDetailUI.this);
                                c12784a.peT = new C348182();
                                spannableString.setSpan(c12784a, string.length(), str.length() + string.length(), 33);
                                RemittanceDetailUI.this.pVi.setOnTouchListener(C13108a.cfs());
                                RemittanceDetailUI.this.pVi.setText(spannableString);
                            }
                            RemittanceDetailUI.this.pVh.setVisibility(0);
                            RemittanceDetailUI.this.pVi.setVisibility(8);
                            RemittanceDetailUI.this.pVd.setOnLongClickListener(RemittanceDetailUI.this.mlV);
                            RemittanceDetailUI.this.pVd.setOnTouchListener(RemittanceDetailUI.this.mlU);
                            AppMethodBeat.m2505o(45026);
                        }
                    });
                }
            }
        } else {
            this.pUE.setVisibility(0);
            this.pUZ.setVisibility(8);
            if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQm.pQs)) {
                this.pUV.setVisibility(8);
                this.pUG.setVisibility(8);
                this.pRn.setVisibility(8);
                this.pUW.setVisibility(8);
                this.pUF.setVisibility(8);
            } else {
                this.pUF.setVisibility(0);
                if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.desc)) {
                    this.pUG.setVisibility(8);
                } else {
                    this.pUG.setVisibility(0);
                    this.pUJ.setText(netSceneTenpayRemittanceQuery.desc);
                    this.pUJ.setOnLongClickListener(this.mlV);
                    this.pUJ.setOnTouchListener(this.mlU);
                }
                if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQm.pQs)) {
                    this.pRn.setVisibility(8);
                } else {
                    this.pRn.setVisibility(0);
                    this.pUK.setText(netSceneTenpayRemittanceQuery.pQm.pQs + "  " + netSceneTenpayRemittanceQuery.pQm.gyD);
                    this.pUI.post(new Runnable() {

                        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$2$1 */
                        class C396131 implements C12783a {
                            C396131() {
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(44995);
                                RemittanceDetailUI.this.pUL.setVisibility(8);
                                RemittanceDetailUI.this.pUM.setVisibility(0);
                                C44383m.m80242a(RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(2131820884), RemittanceDetailUI.this.findViewById(2131827020), RemittanceDetailUI.this.findViewById(2131827024), RemittanceDetailUI.this.findViewById(2131827058));
                                AppMethodBeat.m2505o(44995);
                            }
                        }

                        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$2$2 */
                        class C396142 implements C12783a {
                            C396142() {
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(44996);
                                RemittanceDetailUI.this.pUL.setVisibility(0);
                                RemittanceDetailUI.this.pUM.setVisibility(8);
                                C44383m.m80242a(RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(2131820884), RemittanceDetailUI.this.findViewById(2131827020), RemittanceDetailUI.this.findViewById(2131827024), RemittanceDetailUI.this.findViewById(2131827058));
                                AppMethodBeat.m2505o(44996);
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(44997);
                            int n = RemittanceResultNewUI.m33175n(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQm.fBg, RemittanceDetailUI.this.pUI.getWidth());
                            if (C5046bo.m7563gW(n, netSceneTenpayRemittanceQuery.pQm.fBg.length())) {
                                RemittanceDetailUI.this.pUL.setText(netSceneTenpayRemittanceQuery.pQm.fBg);
                                RemittanceDetailUI.this.pUM.setText(netSceneTenpayRemittanceQuery.pQm.fBg);
                            } else {
                                String string = RemittanceDetailUI.this.getString(C25738R.string.f9036n_);
                                String str = netSceneTenpayRemittanceQuery.pQm.fBg.substring(0, n) + "... ";
                                SpannableString spannableString = new SpannableString(str + string);
                                C12784a c12784a = new C12784a(RemittanceDetailUI.this);
                                c12784a.peT = new C396131();
                                spannableString.setSpan(c12784a, str.length(), str.length() + string.length(), 33);
                                RemittanceDetailUI.this.pUL.setOnTouchListener(C13108a.cfs());
                                RemittanceDetailUI.this.pUL.setText(spannableString);
                                str = RemittanceDetailUI.this.getString(C25738R.string.f9032n6);
                                string = netSceneTenpayRemittanceQuery.pQm.fBg + "  ";
                                spannableString = new SpannableString(string + str);
                                c12784a = new C12784a(RemittanceDetailUI.this);
                                c12784a.peT = new C396142();
                                spannableString.setSpan(c12784a, string.length(), str.length() + string.length(), 33);
                                RemittanceDetailUI.this.pUM.setOnTouchListener(C13108a.cfs());
                                RemittanceDetailUI.this.pUM.setText(spannableString);
                            }
                            RemittanceDetailUI.this.pUL.setVisibility(0);
                            RemittanceDetailUI.this.pUM.setVisibility(8);
                            RemittanceDetailUI.this.pUH.setOnLongClickListener(RemittanceDetailUI.this.mlV);
                            RemittanceDetailUI.this.pUH.setOnTouchListener(RemittanceDetailUI.this.mlU);
                            AppMethodBeat.m2505o(44997);
                        }
                    });
                }
            }
        }
        if (!z2 || C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQn.cIY)) {
            this.pUW.setVisibility(8);
            this.pUN.setVisibility(8);
            this.pUU.setVisibility(8);
        } else {
            this.pUE.setVisibility(0);
            this.pUF.setVisibility(0);
            this.pUW.setVisibility(0);
            this.pUN.setVisibility(0);
            this.pUU.setVisibility(0);
            C25815a.ahv().mo43765a(netSceneTenpayRemittanceQuery.pQn.cIY, this.pUO);
            this.pUP.setText(netSceneTenpayRemittanceQuery.pQn.name);
            this.pUQ.setText(netSceneTenpayRemittanceQuery.pQn.cEh);
            if (netSceneTenpayRemittanceQuery.pQn.pQt > 0) {
                this.pUS.setText(netSceneTenpayRemittanceQuery.pQn.pQu);
                this.pUR.setVisibility(8);
                this.pUS.setVisibility(0);
                this.pUS.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(44998);
                        RemittanceDetailUI.m77636a(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQn.pQv, netSceneTenpayRemittanceQuery, 11);
                        AppMethodBeat.m2505o(44998);
                    }
                });
            } else {
                this.pUR.setVisibility(0);
                this.pUS.setVisibility(8);
                this.pUR.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(44999);
                        RemittanceDetailUI.m77636a(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQn.pQv, netSceneTenpayRemittanceQuery, 11);
                        AppMethodBeat.m2505o(44999);
                    }
                });
                this.pUN.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(45000);
                        RemittanceDetailUI.m77636a(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQn.pQv, netSceneTenpayRemittanceQuery, 11);
                        AppMethodBeat.m2505o(45000);
                    }
                });
            }
        }
        if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQo.cEh)) {
            this.pUT.setVisibility(8);
        } else {
            this.pUT.setText(netSceneTenpayRemittanceQuery.pQo.cEh);
            this.pUT.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(45001);
                    RemittanceDetailUI.m77636a(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQo.pQv, netSceneTenpayRemittanceQuery, 12);
                    AppMethodBeat.m2505o(45001);
                }
            });
            this.pUT.setVisibility(0);
        }
        C44383m.m80242a(this, (ScrollView) findViewById(2131820884), findViewById(2131827020), findViewById(2131827024), findViewById(2131827058));
        AppMethodBeat.m2505o(45037);
    }

    /* renamed from: a */
    private void m77633a(Dialog dialog) {
        AppMethodBeat.m2504i(45038);
        if (dialog != null) {
            dialog.dismiss();
        }
        Intent intent = new Intent(this, WalletLqtDetailUI.class);
        intent.putExtra("key_account_type", 0);
        startActivityForResult(intent, 2);
        AppMethodBeat.m2505o(45038);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(45039);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(C25738R.string.f9082oy));
        AppMethodBeat.m2505o(45039);
    }

    private void cfE() {
        AppMethodBeat.m2504i(45040);
        if (this.pVr == 0 || this.pRA != 1 || C5046bo.isNullOrNil(this.pRz)) {
            C4990ab.m7417i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", Integer.valueOf(this.pVr), Boolean.valueOf(C5046bo.isNullOrNil(this.pRz)));
            this.mController.removeAllOptionMenu();
            AppMethodBeat.m2505o(45040);
            return;
        }
        addIconOptionMenu(0, C25738R.drawable.bli, new C2165714());
        AppMethodBeat.m2505o(45040);
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x07c2  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0792  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45041);
        if (c1207m instanceof NetSceneTenpayRemittanceQuery) {
            final NetSceneTenpayRemittanceQuery netSceneTenpayRemittanceQuery = (NetSceneTenpayRemittanceQuery) c1207m;
            if (i == 0 && i2 == 0) {
                if (netSceneTenpayRemittanceQuery != null) {
                    if (netSceneTenpayRemittanceQuery.nsL) {
                        this.pcH = C1853r.m3846Yz();
                        this.pcA = this.pVm;
                    } else {
                        this.pcH = this.pVm;
                        this.pcA = C1853r.m3846Yz();
                    }
                    boolean equals = C1853r.m3846Yz().equals(this.pcA);
                    this.pUD.setVisibility(8);
                    this.pUA.setText(C36391e.m60006e(netSceneTenpayRemittanceQuery.kCJ, netSceneTenpayRemittanceQuery.pcl));
                    CharSequence charSequence = netSceneTenpayRemittanceQuery.pQj;
                    if (!C5046bo.isNullOrNil(charSequence) && charSequence.contains("%s")) {
                        charSequence = charSequence.trim().replace("%s", RemittanceDetailUI.m77642bc(this.pcA, true));
                    }
                    CharSequence charSequence2 = netSceneTenpayRemittanceQuery.pQk;
                    Object bundle = new Bundle();
                    bundle.putString(C8741b.TRANSACTION_ID, this.pVl);
                    bundle.putString("receiver_name", this.pcA);
                    bundle.putString("transfer_id", this.pRG);
                    bundle.putInt("total_fee", this.pVq);
                    bundle.putString("sender_name", this.pVm);
                    bundle.putInt("invalid_time", this.pVj);
                    bundle.putParcelable("resend_msg_info", netSceneTenpayRemittanceQuery.pQp);
                    this.ocV.setClickable(true);
                    this.pUz.setClickable(true);
                    this.pUY.setClickable(true);
                    int i3 = netSceneTenpayRemittanceQuery.status;
                    C4990ab.m7411d("MicroMsg.RemittanceDetailUI", "status: %d", Integer.valueOf(i3));
                    String string;
                    String string2;
                    switch (i3) {
                        case 2000:
                            SpannableString spannableString;
                            C12784a c12784a;
                            if (equals) {
                                this.pUy.setImageResource(C1318a.remittance_wait);
                                this.pUX.setVisibility(0);
                                this.pUX.setOnClickListener(new C4347918());
                                if (C5046bo.isNullOrNil(charSequence) || C5046bo.isNullOrNil(charSequence2)) {
                                    this.pUz.setText(C25738R.string.dow);
                                    if (netSceneTenpayRemittanceQuery.pQl == 0) {
                                        string = getString(C25738R.string.doz, new Object[]{Integer.valueOf(this.pVo)});
                                    } else if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQk)) {
                                        C4990ab.m7416i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
                                        string = netSceneTenpayRemittanceQuery.pQl == 1 ? "24" : "2";
                                        string = getString(C25738R.string.doy, new Object[]{string}) + getString(C25738R.string.doz, new Object[]{Integer.valueOf(this.pVo)});
                                    } else {
                                        string = netSceneTenpayRemittanceQuery.pQk;
                                    }
                                    string2 = getString(C25738R.string.doo);
                                    spannableString = new SpannableString(string + string2);
                                    c12784a = new C12784a(this);
                                    c12784a.peT = new C12783a() {

                                        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$19$1 */
                                        class C216591 implements OnClickListener {
                                            C216591() {
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.m2504i(45019);
                                                RemittanceDetailUI.this.cfW();
                                                AppMethodBeat.m2505o(45019);
                                            }
                                        }

                                        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$19$2 */
                                        class C348172 implements OnClickListener {
                                            C348172() {
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        }

                                        public final void onClick(View view) {
                                            AppMethodBeat.m2504i(45020);
                                            C30379h.m48466d(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(C25738R.string.dok, new Object[]{RemittanceDetailUI.m77642bc(netSceneTenpayRemittanceQuery.pQh, false)}), RemittanceDetailUI.this.getString(C25738R.string.f9213t6), RemittanceDetailUI.this.getString(C25738R.string.dop), RemittanceDetailUI.this.getString(C25738R.string.f9076or), new C216591(), new C348172());
                                            AppMethodBeat.m2505o(45020);
                                        }
                                    };
                                    spannableString.setSpan(c12784a, string.length(), string.length() + string2.length(), 33);
                                    this.pUY.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.pUY.setText(spannableString);
                                } else {
                                    this.pUz.setText(C44089j.m79285a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.pUY.setText(C44089j.m79285a((Context) this, charSequence2, (int) this.pUY.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new C30132m());
                                    this.pUY.setOnTouchListener(new C30132m());
                                }
                                m77639a(true, false, netSceneTenpayRemittanceQuery);
                            } else {
                                if (C5046bo.isNullOrNil(charSequence) || C5046bo.isNullOrNil(charSequence2)) {
                                    this.pUz.setText(C44089j.m79293b((Context) this, getString(C25738R.string.dox, new Object[]{RemittanceDetailUI.m77642bc(this.pcA, true)}), this.pUz.getTextSize()));
                                    string = getString(C25738R.string.dp3, new Object[]{Integer.valueOf(this.pVo)});
                                    string2 = getString(C25738R.string.g8r);
                                    spannableString = new SpannableString(string + string2);
                                    c12784a = new C12784a(this);
                                    c12784a.peT = new C12783a() {

                                        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI$17$1 */
                                        class C396091 implements C5662c {
                                            C396091() {
                                            }

                                            /* renamed from: d */
                                            public final void mo5699d(boolean z, String str) {
                                                AppMethodBeat.m2504i(45015);
                                                if (z) {
                                                    Intent intent = new Intent();
                                                    intent.putExtra(C8741b.TRANSACTION_ID, RemittanceDetailUI.this.pVl);
                                                    intent.putExtra("transfer_id", RemittanceDetailUI.this.pRG);
                                                    intent.putExtra("receiver_name", RemittanceDetailUI.this.pcA);
                                                    intent.putExtra("resend_msg_from_flag", 3);
                                                    RemittanceDetailUI.this.mo56271an(intent);
                                                }
                                                AppMethodBeat.m2505o(45015);
                                            }
                                        }

                                        public final void onClick(View view) {
                                            AppMethodBeat.m2504i(45016);
                                            new C46178d(RemittanceDetailUI.this).mo74162a(netSceneTenpayRemittanceQuery.pQp, new C396091());
                                            AppMethodBeat.m2505o(45016);
                                        }
                                    };
                                    spannableString.setSpan(c12784a, string.length(), string.length() + string2.length(), 33);
                                    this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.ocV.setText(spannableString);
                                } else {
                                    this.pUz.setText(C44089j.m79285a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.ocV.setText(C44089j.m79285a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new C30132m());
                                    this.ocV.setOnTouchListener(new C30132m());
                                }
                                m77639a(false, false, netSceneTenpayRemittanceQuery);
                            }
                            this.pUy.setImageResource(C1318a.remittance_wait);
                            this.pUB.setText(getString(C25738R.string.dp5, new Object[]{C36391e.m60014kC(netSceneTenpayRemittanceQuery.pQf)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setVisibility(8);
                            break;
                        case 2001:
                            this.pUy.setImageResource(C1318a.remittance_received);
                            if (!C5046bo.isNullOrNil(charSequence) && !C5046bo.isNullOrNil(charSequence2)) {
                                this.pUz.setText(C44089j.m79285a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                this.ocV.setText(C44089j.m79285a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                this.pUz.setOnTouchListener(new C30132m());
                                this.ocV.setOnTouchListener(new C30132m());
                            } else if (equals) {
                                this.pUz.setText(C25738R.string.dor);
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(C25738R.string.do9));
                                C12784a c12784a2 = new C12784a(this);
                                c12784a2.peT = new C4348020();
                                spannableStringBuilder.setSpan(c12784a2, 0, spannableStringBuilder.length(), 18);
                                this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ocV.setText(spannableStringBuilder);
                                this.ocV.setVisibility(0);
                            } else {
                                this.pUz.setText(C44089j.m79293b((Context) this, RemittanceDetailUI.m77642bc(this.pcA, true) + getString(C25738R.string.dor), this.pUz.getTextSize()));
                                this.ocV.setText(C25738R.string.dp2);
                                this.ocV.setVisibility(0);
                            }
                            if (equals) {
                                m77639a(false, true, netSceneTenpayRemittanceQuery);
                            } else {
                                m77639a(false, false, netSceneTenpayRemittanceQuery);
                            }
                            this.pUB.setText(getString(C25738R.string.dp5, new Object[]{C36391e.m60014kC(netSceneTenpayRemittanceQuery.pQf)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setText(getString(C25738R.string.dog, new Object[]{C36391e.m60014kC(netSceneTenpayRemittanceQuery.pQi)}));
                            this.pUC.setVisibility(0);
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.pUy.setImageResource(C1318a.remittance_refunded);
                                if (!C5046bo.isNullOrNil(charSequence)) {
                                    this.pUz.setText(C44089j.m79285a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new C30132m());
                                } else if (equals) {
                                    this.pUz.setText(C25738R.string.dot);
                                } else {
                                    this.pUz.setText(C44089j.m79293b((Context) this, RemittanceDetailUI.m77642bc(this.pcA, true) + getString(C25738R.string.dot), this.pUz.getTextSize()));
                                }
                            } else {
                                this.pUy.setImageResource(C1318a.remittance_timed_out);
                                if (C5046bo.isNullOrNil(charSequence)) {
                                    this.pUz.setText(C25738R.string.dov);
                                } else {
                                    this.pUz.setText(C44089j.m79285a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new C30132m());
                                }
                            }
                            if (equals) {
                                this.ocV.setVisibility(8);
                            } else {
                                if (!C5046bo.isNullOrNil(charSequence2)) {
                                    this.ocV.setText(C44089j.m79285a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                    this.ocV.setOnTouchListener(new C30132m());
                                } else if ("CFT".equals(netSceneTenpayRemittanceQuery.pcJ) || "LQT".equals(netSceneTenpayRemittanceQuery.pcJ)) {
                                    final boolean equals2 = "LQT".equals(netSceneTenpayRemittanceQuery.pcJ);
                                    string2 = equals2 ? getString(C25738R.string.don) : getString(C25738R.string.dol);
                                    if (equals2) {
                                        string = getString(C25738R.string.dob);
                                    } else {
                                        string = getString(C25738R.string.do9);
                                    }
                                    SpannableString spannableString2 = new SpannableString(string2 + string);
                                    C12784a c12784a3 = new C12784a(this);
                                    c12784a3.peT = new C12783a() {
                                        public final void onClick(View view) {
                                            AppMethodBeat.m2504i(45022);
                                            if (equals2) {
                                                C25985d.m41448H(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                                                AppMethodBeat.m2505o(45022);
                                                return;
                                            }
                                            C35899h.m58862ak(RemittanceDetailUI.this, 0);
                                            AppMethodBeat.m2505o(45022);
                                        }
                                    };
                                    spannableString2.setSpan(c12784a3, string2.length(), string.length() + string2.length(), 33);
                                    this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.ocV.setText(spannableString2);
                                } else {
                                    this.ocV.setText(C25738R.string.dom);
                                }
                                this.ocV.setVisibility(0);
                            }
                            m77639a(false, false, netSceneTenpayRemittanceQuery);
                            this.pUB.setText(getString(C25738R.string.dp5, new Object[]{C36391e.m60014kC(netSceneTenpayRemittanceQuery.pQf)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setText(getString(C25738R.string.doj, new Object[]{C36391e.m60014kC(netSceneTenpayRemittanceQuery.pQi)}));
                            this.pUC.setVisibility(0);
                            break;
                        case 2004:
                            if (equals) {
                                this.pUy.setImageResource(C1318a.remittance_wait);
                                if (C5046bo.isNullOrNil(charSequence) || C5046bo.isNullOrNil(charSequence2)) {
                                    if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQj)) {
                                        this.pUz.setText(C25738R.string.dos);
                                    } else {
                                        this.pUz.setText(netSceneTenpayRemittanceQuery.pQj);
                                    }
                                    if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQk)) {
                                        this.ocV.setText(C25738R.string.doi);
                                    } else {
                                        this.ocV.setText(netSceneTenpayRemittanceQuery.pQk);
                                    }
                                } else {
                                    this.pUz.setText(C44089j.m79285a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.ocV.setText(C44089j.m79285a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new C30132m());
                                    this.ocV.setOnTouchListener(new C30132m());
                                }
                            } else {
                                this.pUy.setImageResource(C1318a.remittance_wait);
                                if (C5046bo.isNullOrNil(charSequence) || C5046bo.isNullOrNil(charSequence2)) {
                                    if (!C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQj)) {
                                        try {
                                            this.pUz.setText(String.format(netSceneTenpayRemittanceQuery.pQj, new Object[]{RemittanceDetailUI.m77642bc(this.pcA, true)}));
                                        } catch (Exception e) {
                                            C4990ab.printErrStackTrace("MicroMsg.RemittanceDetailUI", e, "", new Object[0]);
                                        }
                                        if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQk)) {
                                            this.ocV.setText(netSceneTenpayRemittanceQuery.pQk);
                                        } else {
                                            this.ocV.setText("");
                                        }
                                    }
                                    this.pUz.setText(getString(C25738R.string.dou, new Object[]{RemittanceDetailUI.m77642bc(this.pcA, true)}));
                                    if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQk)) {
                                    }
                                } else {
                                    this.pUz.setText(C44089j.m79285a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.ocV.setText(C44089j.m79285a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new C30132m());
                                    this.ocV.setOnTouchListener(new C30132m());
                                }
                            }
                            m77639a(false, false, netSceneTenpayRemittanceQuery);
                            this.pUB.setText(getString(C25738R.string.dp5, new Object[]{C36391e.m60014kC(netSceneTenpayRemittanceQuery.pQf)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setText(getString(C25738R.string.dog, new Object[]{C36391e.m60014kC(netSceneTenpayRemittanceQuery.pQi)}));
                            this.pUC.setVisibility(0);
                            break;
                        case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                            this.pUy.setImageResource(C1318a.remittance_cancle);
                            if (C5046bo.isNullOrNil(charSequence) || C5046bo.isNullOrNil(charSequence2)) {
                                if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQj)) {
                                    this.pUz.setText(C25738R.string.doq);
                                } else {
                                    this.pUz.setText(netSceneTenpayRemittanceQuery.pQj);
                                }
                                if (C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQk)) {
                                    if (equals) {
                                        this.ocV.setText(C25738R.string.doh);
                                    } else {
                                        this.ocV.setText(C25738R.string.dp1);
                                    }
                                } else if ("CFT".equals(netSceneTenpayRemittanceQuery.pcJ) || "LQT".equals(netSceneTenpayRemittanceQuery.pcJ)) {
                                    equals = "LQT".equals(netSceneTenpayRemittanceQuery.pcJ);
                                    String str2 = netSceneTenpayRemittanceQuery.pQk;
                                    if (equals) {
                                        charSequence = getString(C25738R.string.dob);
                                    } else {
                                        charSequence = getString(C25738R.string.do9);
                                    }
                                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                                    spannableStringBuilder2.append(str2);
                                    spannableStringBuilder2.append(charSequence);
                                    C12784a c12784a4 = new C12784a(this);
                                    c12784a4.peT = new C12783a() {
                                        public final void onClick(View view) {
                                            AppMethodBeat.m2504i(45023);
                                            if (equals) {
                                                C25985d.m41448H(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                                                AppMethodBeat.m2505o(45023);
                                                return;
                                            }
                                            C35899h.m58862ak(RemittanceDetailUI.this, 0);
                                            AppMethodBeat.m2505o(45023);
                                        }
                                    };
                                    spannableStringBuilder2.setSpan(c12784a4, str2.length(), spannableStringBuilder2.length(), 18);
                                    this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.ocV.setText(spannableStringBuilder2);
                                } else {
                                    this.ocV.setText(netSceneTenpayRemittanceQuery.pQk);
                                }
                            } else {
                                this.pUz.setText(C44089j.m79285a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                this.ocV.setText(C44089j.m79285a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                this.pUz.setOnTouchListener(new C30132m());
                                this.ocV.setOnTouchListener(new C30132m());
                            }
                            m77639a(false, false, netSceneTenpayRemittanceQuery);
                            this.pUB.setText(getString(C25738R.string.dp5, new Object[]{C36391e.m60014kC(netSceneTenpayRemittanceQuery.pQf)}));
                            this.pUB.setVisibility(0);
                            if (netSceneTenpayRemittanceQuery.pQi <= 0) {
                                this.pUC.setVisibility(8);
                                break;
                            }
                            this.pUC.setText(getString(C25738R.string.do8, new Object[]{C36391e.m60014kC(netSceneTenpayRemittanceQuery.pQi)}));
                            this.pUC.setVisibility(0);
                            break;
                            break;
                        default:
                            finish();
                            break;
                    }
                    if (!C5046bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQq)) {
                        C36391e.m59985a((TextView) findViewById(2131821634), "7", netSceneTenpayRemittanceQuery.pQq, netSceneTenpayRemittanceQuery.pQr);
                    }
                }
                this.pVr = netSceneTenpayRemittanceQuery.pQl;
                C1720g.m3537RQ();
                this.pRz = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, (Object) "");
                C1720g.m3537RQ();
                this.pRA = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(0))).intValue();
                if (C5046bo.isNullOrNil(this.pRz)) {
                    C14224ae.m22423a(true, this.Ahr);
                } else {
                    C14224ae.m22423a(false, this.Ahr);
                }
                cfE();
                if (netSceneTenpayRemittanceQuery.pcT == 1) {
                    C1720g.m3537RQ();
                    if (((String) C1720g.m3536RP().mo5239Ry().get(327729, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        int i4;
                        Context context = this.mController.ylL;
                        if (C1853r.m3831YM()) {
                            i4 = C25738R.string.alf;
                        } else {
                            i4 = C25738R.string.frh;
                        }
                        C30379h.m48431a(context, i4, (int) C25738R.string.fri, new C4347015());
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(327729, (Object) "1");
                    } else if (this.pVr == 0) {
                        C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.doe));
                    }
                }
                AppMethodBeat.m2505o(45041);
                return true;
            }
        } else if (c1207m instanceof C46177u) {
            if (i == 0 && i2 == 0) {
                this.pVs = (C46177u) c1207m;
                if (this.pVs.bLD() && this.pVs.nYe.mo39946a((Activity) this, new C4347816())) {
                    AppMethodBeat.m2505o(45041);
                    return true;
                }
                m77634a(this.pVs);
                AppMethodBeat.m2505o(45041);
                return true;
            } else if (i2 == 416) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("realname_verify_process_jump_plugin", "remittance");
                bundle2.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
                boolean a = C43795a.m78490a((Activity) this, i2, c1207m, bundle2, 1008);
                AppMethodBeat.m2505o(45041);
                return a;
            } else {
                mo69033aZ(i2, str);
                AppMethodBeat.m2505o(45041);
                return true;
            }
        } else if (c1207m instanceof C14224ae) {
            if (i == 0 && i2 == 0) {
                this.pRz = ((C14224ae) c1207m).tuE;
                this.pRA = ((C14224ae) c1207m).tuF;
                cfE();
            } else {
                C4990ab.m7416i("MicroMsg.RemittanceDetailUI", "net error");
            }
            AppMethodBeat.m2505o(45041);
            return true;
        }
        if (c1207m instanceof C29624e) {
            AppMethodBeat.m2505o(45041);
            return true;
        }
        AppMethodBeat.m2505o(45041);
        return false;
    }

    /* renamed from: a */
    private void m77634a(C46177u c46177u) {
        AppMethodBeat.m2504i(45042);
        if ("confirm".equals(c46177u.pPk)) {
            mo56269BK(1);
            AppMethodBeat.m2505o(45042);
            return;
        }
        mo69033aZ(0, getResources().getString(C25738R.string.dof));
        AppMethodBeat.m2505o(45042);
    }

    public final int getLayoutId() {
        return 2130970510;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aZ */
    public final void mo69033aZ(int i, String str) {
        AppMethodBeat.m2504i(45043);
        Intent intent = new Intent();
        intent.putExtra("result_msg", str);
        setResult(i, intent);
        finish();
        AppMethodBeat.m2505o(45043);
    }

    public void finish() {
        AppMethodBeat.m2504i(45044);
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_plugin", "remittance");
        bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
        if (this.pVs == null || !C43795a.m78494a((Activity) this, this.pVs, bundle, true, 1008)) {
            super.finish();
            AppMethodBeat.m2505o(45044);
            return;
        }
        this.pVs = null;
        AppMethodBeat.m2505o(45044);
    }

    /* renamed from: bc */
    public static String m77642bc(String str, boolean z) {
        AppMethodBeat.m2504i(45045);
        String mJ = C36391e.m60015mJ(str);
        if (mJ == null) {
            mJ = "";
            AppMethodBeat.m2505o(45045);
            return mJ;
        }
        if (mJ.length() > 10 && z) {
            mJ = mJ.substring(0, 8) + "...";
        }
        AppMethodBeat.m2505o(45045);
        return mJ;
    }
}
