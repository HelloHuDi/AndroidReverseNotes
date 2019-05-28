package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.p177mm.plugin.remittance.model.C21646j;
import com.tencent.p177mm.plugin.remittance.model.C43455f;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.WalletSuccPageAwardWidget;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C40546mr;
import com.tencent.p177mm.protocal.protobuf.C46532cz;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.LinkedList;
import p1121d.p1122a.p1123a.C31176c;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI */
public class RemittanceBusiResultUI extends WalletBaseUI {
    private TextView iDT;
    private Button nsJ;
    private String oXY;
    private int obL;
    private int pOx;
    private String pOy;
    private String pQW;
    private String pRC;
    private String pSA;
    private int pSB;
    private String pSC;
    private String pSD;
    private C1332b pSE;
    private boolean pSF = false;
    private String pSG;
    private BusiRemittanceResp pSH;
    private C46532cz pSI = new C46532cz();
    private int pSJ;
    private C31176c pSK;
    private WalletSuccPageAwardWidget pSL;
    private ViewGroup pSM;
    private ViewGroup pSN;
    private ViewGroup pSO;
    private TextView pSP;
    private boolean pSQ = false;
    private C4884c<C32652uv> pSR = new C434671();
    private boolean pSS = true;
    private Runnable pST = new C434688();
    private TextView pSi;
    private TextView pSj;
    private TextView pSk;
    private CdnImageView pSl;
    private TextView pSm;
    private TextView pSn;
    private Button pSo;
    private ViewGroup pSp;
    private ViewGroup pSq;
    private ViewGroup pSr;
    private View pSs;
    private LinearLayout pSt;
    private String pSu;
    private String pSv;
    private String pSw;
    private double pSx;
    private String pSy;
    private String pSz;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI$2 */
    class C396082 implements OnClickListener {
        C396082() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44870);
            RemittanceBusiResultUI.this.finish();
            AppMethodBeat.m2505o(44870);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI$7 */
    class C434667 implements Runnable {
        C434667() {
        }

        public final void run() {
            AppMethodBeat.m2504i(44875);
            RemittanceBusiResultUI.m77625e(RemittanceBusiResultUI.this);
            AppMethodBeat.m2505o(44875);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI$1 */
    class C434671 extends C4884c<C32652uv> {
        C434671() {
            AppMethodBeat.m2504i(44868);
            this.xxI = C32652uv.class.getName().hashCode();
            AppMethodBeat.m2505o(44868);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44869);
            C32652uv c32652uv = (C32652uv) c4883b;
            C4990ab.m7416i("MicroMsg.RemittanceBusiResultUI", "receive pay result event, do finish");
            if (c32652uv.cRF.cRG == 1000 || c32652uv.cRF.cRG == 1001) {
                RemittanceBusiResultUI.this.finish();
            }
            AppMethodBeat.m2505o(44869);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI$8 */
    class C434688 implements Runnable {
        C434688() {
        }

        public final void run() {
            AppMethodBeat.m2504i(44876);
            RemittanceBusiResultUI.m77626f(RemittanceBusiResultUI.this);
            AppMethodBeat.m2505o(44876);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RemittanceBusiResultUI() {
        AppMethodBeat.m2504i(44877);
        AppMethodBeat.m2505o(44877);
    }

    /* renamed from: f */
    static /* synthetic */ void m77626f(RemittanceBusiResultUI remittanceBusiResultUI) {
        AppMethodBeat.m2504i(44892);
        remittanceBusiResultUI.m77616a(null);
        AppMethodBeat.m2505o(44892);
    }

    public void finish() {
        AppMethodBeat.m2504i(44878);
        C4990ab.m7417i("MicroMsg.RemittanceBusiResultUI", "finish this %s %s", this, C5046bo.dpG());
        if (this.pSQ) {
            AppMethodBeat.m2505o(44878);
            return;
        }
        super.finish();
        this.pSQ = true;
        AppMethodBeat.m2505o(44878);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(44879);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(44879);
        return dispatchTouchEvent;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44880);
        super.onCreate(bundle);
        mo39992nf(1537);
        mo39992nf(1680);
        mo39992nf(2504);
        this.pSR.dnU();
        if (C1443d.m3068iW(21)) {
            if (C1443d.m3068iW(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.pQW = getIntent().getStringExtra("key_mch_name");
        this.pSH = (BusiRemittanceResp) getIntent().getParcelableExtra("BusiRemittanceResp");
        this.pSx = getIntent().getDoubleExtra("key_money", 0.0d);
        this.pSw = getIntent().getStringExtra("key_rcver_name");
        this.pSG = getIntent().getStringExtra("key_rcver_true_name");
        this.pSu = getIntent().getStringExtra("key_rcv_desc");
        this.pSv = getIntent().getStringExtra("key_pay_desc");
        this.pSy = getIntent().getStringExtra("key_f2f_id");
        this.oXY = getIntent().getStringExtra("key_trans_id");
        this.pRC = getIntent().getStringExtra("key_rcvr_open_id");
        this.pSD = getIntent().getStringExtra("key_check_sign");
        this.pSz = getIntent().getStringExtra("key_pay_desc");
        this.pSA = getIntent().getStringExtra("key_rcv_desc");
        this.pSB = getIntent().getIntExtra("key_scan_sceen", 0);
        this.obL = getIntent().getIntExtra("key_channel", 0);
        this.pSC = getIntent().getStringExtra("key_succ_page_extend");
        try {
            this.pSI.parseFrom(getIntent().getByteArrayExtra("AfterPlaceOrderCommReq"));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", e, "", new Object[0]);
        }
        this.pSJ = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.pOx = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.pOy = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.pSF = false;
        C4990ab.m7416i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        mo39970a(new C21646j(this.pSI, this.pSC), true, true);
        initView();
        AppMethodBeat.m2505o(44880);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44881);
        this.iDT = (TextView) findViewById(2131826972);
        this.pSi = (TextView) findViewById(2131826973);
        this.pSj = (TextView) findViewById(2131826983);
        this.pSk = (TextView) findViewById(2131826985);
        this.pSp = (LinearLayout) findViewById(2131826982);
        this.pSq = (LinearLayout) findViewById(2131826984);
        this.pSl = (CdnImageView) findViewById(2131826990);
        this.pSm = (TextView) findViewById(2131826991);
        this.pSn = (TextView) findViewById(2131826992);
        this.pSo = (Button) findViewById(2131826993);
        this.pSr = (ViewGroup) findViewById(2131826988);
        this.nsJ = (Button) findViewById(2131826998);
        this.pSs = findViewById(2131826981);
        this.pSt = (LinearLayout) findViewById(2131826980);
        this.pSi.setText(C36391e.m59971F(this.pSx));
        cfQ();
        if (C5046bo.isNullOrNil(this.pSu)) {
            this.pSp.setVisibility(8);
        } else {
            this.pSj.setText(this.pSu);
            this.pSp.setVisibility(0);
        }
        if (C5046bo.isNullOrNil(this.pSv)) {
            this.pSq.setVisibility(8);
        } else {
            this.pSk.setText(this.pSv);
            this.pSq.setVisibility(0);
        }
        this.nsJ.setOnClickListener(new C396082());
        this.pSL = (WalletSuccPageAwardWidget) findViewById(2131826996);
        this.pSM = (ViewGroup) findViewById(2131826977);
        this.pSN = (ViewGroup) findViewById(2131826978);
        this.pSO = (ViewGroup) findViewById(2131826986);
        this.pSP = (TextView) findViewById(2131826987);
        AppMethodBeat.m2505o(44881);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44882);
        if (c1207m instanceof C21646j) {
            C21646j c21646j = (C21646j) c1207m;
            if (i != 0 || i2 != 0) {
                C4990ab.m7413e("MicroMsg.RemittanceBusiResultUI", "net error: %s", c21646j);
            } else if (c21646j.pOW.kdT == 0) {
                C4990ab.m7417i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", c21646j.pOW.tBw);
                this.pSK = c21646j.pOW.tBw;
                if (WalletSuccPageAwardWidget.m34320a(this.pSK)) {
                    C4990ab.m7417i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", this.oXY);
                    this.pSL.mo38237a(this, this.pSK, this.oXY, true, (ImageView) findViewById(2131824036));
                    this.pSL.init();
                    this.pSL.setVisibility(0);
                    final ImageView imageView = (ImageView) findViewById(2131824036);
                    imageView.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(44871);
                            ViewGroup viewGroup = (ViewGroup) RemittanceBusiResultUI.this.findViewById(2131826966);
                            LayoutParams layoutParams = imageView.getLayoutParams();
                            layoutParams.width = viewGroup.getWidth();
                            layoutParams.height = viewGroup.getHeight();
                            imageView.setLayoutParams(layoutParams);
                            AppMethodBeat.m2505o(44871);
                        }
                    });
                    m77624dv(this.pSL);
                } else {
                    this.pSL.setVisibility(8);
                }
                this.pSN.setVisibility(8);
                this.pSM.setVisibility(8);
                this.pSO.setVisibility(8);
                TextView textView = (TextView) findViewById(2131826975);
                final View findViewById = findViewById(2131826974);
                if (!(c21646j == null || c21646j.pOW == null || c21646j.pOW.vPR.size() <= 0)) {
                    LinkedList linkedList = c21646j.pOW.vPR;
                    String str2 = "MicroMsg.RemittanceBusiResultUI";
                    String str3 = "discountInfoList: %s, size: %s received_amount: %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = linkedList;
                    objArr[1] = Integer.valueOf(linkedList != null ? linkedList.size() : 0);
                    objArr[2] = Long.valueOf(c21646j.pOW.vPQ);
                    C4990ab.m7417i(str2, str3, objArr);
                    str2 = "";
                    int size = linkedList.size();
                    if (linkedList != null && linkedList.size() > 0) {
                        String str4;
                        this.pSN.removeAllViews();
                        this.pSM.setOnClickListener(null);
                        if (size > 1) {
                            str4 = c21646j.pOW.vPU;
                            this.pSS = true;
                            findViewById.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    boolean z = false;
                                    AppMethodBeat.m2504i(44873);
                                    if (RemittanceBusiResultUI.this.pSS) {
                                        findViewById.setVisibility(8);
                                        RemittanceBusiResultUI.this.pSM.setVisibility(0);
                                        RemittanceBusiResultUI.m77617a(RemittanceBusiResultUI.this, RemittanceBusiResultUI.this.pSN);
                                    } else {
                                        findViewById.setVisibility(0);
                                        RemittanceBusiResultUI.this.pSM.setVisibility(8);
                                        RemittanceBusiResultUI.m77617a(RemittanceBusiResultUI.this, findViewById);
                                    }
                                    RemittanceBusiResultUI remittanceBusiResultUI = RemittanceBusiResultUI.this;
                                    if (!RemittanceBusiResultUI.this.pSS) {
                                        z = true;
                                    }
                                    remittanceBusiResultUI.pSS = z;
                                    AppMethodBeat.m2505o(44873);
                                }
                            });
                            this.pSM.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    boolean z = false;
                                    AppMethodBeat.m2504i(44874);
                                    if (RemittanceBusiResultUI.this.pSS) {
                                        findViewById.setVisibility(8);
                                        RemittanceBusiResultUI.this.pSM.setVisibility(0);
                                        RemittanceBusiResultUI.m77617a(RemittanceBusiResultUI.this, RemittanceBusiResultUI.this.pSN);
                                    } else {
                                        findViewById.setVisibility(0);
                                        RemittanceBusiResultUI.this.pSM.setVisibility(8);
                                        RemittanceBusiResultUI.m77617a(RemittanceBusiResultUI.this, findViewById);
                                    }
                                    RemittanceBusiResultUI remittanceBusiResultUI = RemittanceBusiResultUI.this;
                                    if (!RemittanceBusiResultUI.this.pSS) {
                                        z = true;
                                    }
                                    remittanceBusiResultUI.pSS = z;
                                    AppMethodBeat.m2505o(44874);
                                }
                            });
                        } else {
                            str4 = str2;
                        }
                        if (size != 1 || linkedList.get(0) == null) {
                            str2 = str4;
                        } else {
                            str2 = (String) linkedList.get(0);
                        }
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= linkedList.size()) {
                                break;
                            }
                            str4 = (String) linkedList.get(i4);
                            TextView textView2 = new TextView(this.mController.ylL);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.bottomMargin = C1338a.fromDPToPix(this, 6);
                            textView2.setLayoutParams(layoutParams);
                            textView2.setTextSize(1, 12.0f);
                            textView2.setTextColor(Color.parseColor("#FA962A"));
                            textView2.setText(str4);
                            this.pSN.addView(textView2);
                            i3 = i4 + 1;
                        }
                        this.pSN.setVisibility(0);
                        this.pSM.setVisibility(0);
                    }
                    if (this.pSS) {
                        findViewById.setVisibility(0);
                        SpannableString spannableString = new SpannableString(C5046bo.m7532bc(str2, "") + " ");
                        if (size > 1) {
                            findViewById(2131826976).setVisibility(0);
                        } else {
                            findViewById(2131826976).setVisibility(8);
                        }
                        textView.setText(spannableString);
                        this.pSM.setVisibility(8);
                    }
                }
                C5004al.m7439af(this.pST);
                m77616a(c21646j);
            } else {
                C4990ab.m7413e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s", Integer.valueOf(c21646j.pOW.kdT), c21646j.pOW.kdU);
            }
        } else if (c1207m instanceof C43455f) {
            C43455f c43455f = (C43455f) c1207m;
            if (i != 0 || i2 != 0) {
                C4990ab.m7413e("MicroMsg.RemittanceBusiResultUI", "net error: %s", c43455f);
            } else if (c43455f.pOJ.kdT == 0) {
                final C40546mr c40546mr = c43455f.pOJ.vPf;
                if (c40546mr != null) {
                    this.pSl.setUrl(c40546mr.cIY);
                    this.pSm.setText(c40546mr.title);
                    this.pSn.setText(c40546mr.tzT);
                    this.pSo.setText(c40546mr.tID);
                    this.pSo.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(44872);
                            C4990ab.m7417i("MicroMsg.RemittanceBusiResultUI", "app type: %s", Integer.valueOf(c40546mr.type));
                            if (c40546mr.type == 1) {
                                RemittanceBusiResultUI.this.pSF = true;
                                C32628se c32628se = new C32628se();
                                c32628se.cOf.userName = c40546mr.vQG;
                                c32628se.cOf.cOh = C5046bo.m7532bc(c40546mr.vQH, "");
                                c32628se.cOf.scene = 1034;
                                c32628se.cOf.cOi = 0;
                                C4879a.xxA.mo10055m(c32628se);
                                AppMethodBeat.m2505o(44872);
                                return;
                            }
                            if (c40546mr.type == 2) {
                                RemittanceBusiResultUI.this.pSF = true;
                                C36391e.m60016n(RemittanceBusiResultUI.this.mController.ylL, c40546mr.url, true);
                            }
                            AppMethodBeat.m2505o(44872);
                        }
                    });
                    this.pSo.setBackgroundResource(C25738R.drawable.f7015yl);
                    this.pSo.setTextColor(getResources().getColor(C25738R.color.a6b));
                    this.pSr.setVisibility(0);
                    m77624dv(this.pSr);
                } else {
                    C4990ab.m7416i("MicroMsg.RemittanceBusiResultUI", "app info is null");
                    this.pSr.setVisibility(8);
                }
            } else {
                C4990ab.m7413e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", Integer.valueOf(c43455f.pOJ.kdT), c43455f.pOJ.kdU);
                Toast.makeText(this, c43455f.pOJ.kdU, 1).show();
            }
        }
        boolean z = false;
        if (this.pSK != null) {
            z = this.pSL.mo38238c(i, i2, str, c1207m);
        }
        if (RemittanceBusiResultUI.m77623du(this.pSp) && RemittanceBusiResultUI.m77623du(this.pSq) && RemittanceBusiResultUI.m77623du(this.pSO)) {
            this.pSs.setVisibility(8);
        } else {
            this.pSs.setVisibility(0);
        }
        AppMethodBeat.m2505o(44882);
        return z;
    }

    /* renamed from: du */
    private static boolean m77623du(View view) {
        AppMethodBeat.m2504i(44883);
        if (view == null || view.getVisibility() == 8) {
            AppMethodBeat.m2505o(44883);
            return true;
        }
        AppMethodBeat.m2505o(44883);
        return false;
    }

    public void onResume() {
        AppMethodBeat.m2504i(44884);
        super.onResume();
        if (this.pSF) {
            C4990ab.m7416i("MicroMsg.RemittanceBusiResultUI", "do act qry");
            mo39970a(new C43455f(this.pSy, this.oXY, this.pRC, (int) Math.round(this.pSx * 100.0d), this.pSE, this.pSD), false, false);
            this.pSF = false;
        }
        if (this.pSK != null) {
            this.pSL.onResume();
        }
        AppMethodBeat.m2505o(44884);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44885);
        super.onDestroy();
        mo39993ng(1537);
        mo39993ng(1680);
        mo39993ng(2504);
        this.pSR.dead();
        if (this.pSK != null) {
            this.pSL.onDestroy();
        }
        AppMethodBeat.m2505o(44885);
    }

    public final int getLayoutId() {
        return 2130970508;
    }

    /* renamed from: dv */
    private void m77624dv(View view) {
        AppMethodBeat.m2504i(44887);
        findViewById(2131821222).setVisibility(8);
        view.post(new C434667());
        AppMethodBeat.m2505o(44887);
    }

    private void cfQ() {
        AppMethodBeat.m2504i(44888);
        C5004al.m7442n(this.pST, 500);
        AppMethodBeat.m2505o(44888);
    }

    /* renamed from: a */
    private void m77616a(C21646j c21646j) {
        CharSequence string;
        AppMethodBeat.m2504i(44889);
        this.pSt.removeAllViews();
        String eK;
        Object string2;
        if (C5046bo.isNullOrNil(this.pQW)) {
            eK = C36391e.m60007eK(C36391e.m60015mJ(this.pSw), 6);
            if (!C5046bo.isNullOrNil(this.pSG)) {
                string2 = getString(C25738R.string.do0, new Object[]{eK, this.pSG});
            }
            string2 = eK;
        } else {
            eK = C36391e.m60007eK(this.pQW, 6);
            if (!C5046bo.isNullOrNil(this.pSG)) {
                string2 = getString(C25738R.string.do0, new Object[]{eK, this.pSG});
            }
            string2 = eK;
        }
        if (RemittanceBusiResultUI.m77623du(this.pSp) && RemittanceBusiResultUI.m77623du(this.pSq) && RemittanceBusiResultUI.m77623du(this.pSO) && RemittanceBusiResultUI.m77623du(this.pSr) && !WalletSuccPageAwardWidget.m34320a(this.pSK) && RemittanceBusiResultUI.m77623du(findViewById(2131826974)) && RemittanceBusiResultUI.m77623du(this.pSM)) {
            ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(2130969456, this.pSt, false);
            this.pSt.addView(viewGroup);
            CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(2131823740);
            TextView textView = (TextView) viewGroup.findViewById(2131823741);
            if (!C5046bo.isNullOrNil(this.pOy)) {
                if (this.pSJ == 1) {
                    cdnImageView.setRoundCorner(true);
                }
                cdnImageView.setUrl(this.pOy);
            } else if (this.pSJ == 1) {
                C40460b.m69437r(cdnImageView, this.pSw);
            } else {
                C40460b.m69434b(cdnImageView, this.pSw);
            }
            textView.setText(string2);
        } else {
            this.pSt.addView((ViewGroup) getLayoutInflater().inflate(2130970507, this.pSt, false));
            CdnImageView cdnImageView2 = (CdnImageView) findViewById(2131823740);
            TextView textView2 = (TextView) findViewById(2131823741);
            View findViewById = findViewById(2131826968);
            TextView textView3 = (TextView) findViewById(2131826969);
            textView2.setText(C44089j.m79292b((Context) this, string2));
            cdnImageView2.setVisibility(0);
            if (!C5046bo.isNullOrNil(this.pOy)) {
                if (this.pSJ == 1) {
                    cdnImageView2.setRoundCorner(true);
                }
                cdnImageView2.setUrl(this.pOy);
            } else if (this.pSJ == 1) {
                C40460b.m69437r(cdnImageView2, this.pSw);
            } else {
                C40460b.m69434b(cdnImageView2, this.pSw);
            }
            findViewById.setVisibility(8);
            textView3.setVisibility(8);
            if (c21646j != null) {
                if (c21646j.pOW.vPT == 1) {
                    findViewById.setVisibility(0);
                    textView3.setVisibility(0);
                    textView3.setText(C36391e.m59972G(((double) c21646j.pOW.vPQ) / 100.0d));
                } else {
                    findViewById.setVisibility(8);
                    textView3.setVisibility(8);
                }
            }
        }
        m77624dv(this.pSt);
        AppMethodBeat.m2505o(44889);
    }

    /* renamed from: AM */
    public final void mo9439AM(int i) {
        AppMethodBeat.m2504i(44886);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.m2505o(44886);
    }

    /* renamed from: e */
    static /* synthetic */ void m77625e(RemittanceBusiResultUI remittanceBusiResultUI) {
        AppMethodBeat.m2504i(44891);
        View findViewById = remittanceBusiResultUI.findViewById(2131821222);
        findViewById.setVisibility(0);
        if (findViewById != null) {
            int fromDPToPix = C1338a.fromDPToPix(remittanceBusiResultUI, 25);
            int i = fromDPToPix * 2;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
            View findViewById2 = remittanceBusiResultUI.findViewById(2131826970);
            View findViewById3 = remittanceBusiResultUI.findViewById(2131826997);
            if (findViewById2.getMeasuredHeight() > 0) {
                findViewById2.getMeasuredHeight();
                int height = ((WindowManager) remittanceBusiResultUI.getSystemService("window")).getDefaultDisplay().getHeight() - C5230ak.m7989hF(remittanceBusiResultUI);
                if (height > findViewById3.getBottom()) {
                    marginLayoutParams.topMargin = ((height - i) - findViewById3.getBottom()) - findViewById.getMeasuredHeight();
                    if (marginLayoutParams.topMargin < fromDPToPix) {
                        marginLayoutParams.topMargin = fromDPToPix;
                    }
                }
                marginLayoutParams.bottomMargin = i;
                findViewById.setLayoutParams(marginLayoutParams);
                findViewById.setVisibility(0);
                findViewById.requestLayout();
                AppMethodBeat.m2505o(44891);
                return;
            }
            marginLayoutParams.topMargin = fromDPToPix;
            marginLayoutParams.bottomMargin = i;
            findViewById.setLayoutParams(marginLayoutParams);
            findViewById.setVisibility(0);
            findViewById.requestLayout();
        }
        AppMethodBeat.m2505o(44891);
    }
}
