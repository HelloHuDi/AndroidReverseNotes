package com.tencent.mm.plugin.remittance.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bt.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.f;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import d.a.a.c;
import java.util.LinkedList;

@a(19)
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
    private b pSE;
    private boolean pSF = false;
    private String pSG;
    private BusiRemittanceResp pSH;
    private cz pSI = new cz();
    private int pSJ;
    private c pSK;
    private WalletSuccPageAwardWidget pSL;
    private ViewGroup pSM;
    private ViewGroup pSN;
    private ViewGroup pSO;
    private TextView pSP;
    private boolean pSQ = false;
    private com.tencent.mm.sdk.b.c<uv> pSR = new com.tencent.mm.sdk.b.c<uv>() {
        {
            AppMethodBeat.i(44868);
            this.xxI = uv.class.getName().hashCode();
            AppMethodBeat.o(44868);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(44869);
            uv uvVar = (uv) bVar;
            ab.i("MicroMsg.RemittanceBusiResultUI", "receive pay result event, do finish");
            if (uvVar.cRF.cRG == 1000 || uvVar.cRF.cRG == 1001) {
                RemittanceBusiResultUI.this.finish();
            }
            AppMethodBeat.o(44869);
            return false;
        }
    };
    private boolean pSS = true;
    private Runnable pST = new Runnable() {
        public final void run() {
            AppMethodBeat.i(44876);
            RemittanceBusiResultUI.f(RemittanceBusiResultUI.this);
            AppMethodBeat.o(44876);
        }
    };
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceBusiResultUI() {
        AppMethodBeat.i(44877);
        AppMethodBeat.o(44877);
    }

    static /* synthetic */ void f(RemittanceBusiResultUI remittanceBusiResultUI) {
        AppMethodBeat.i(44892);
        remittanceBusiResultUI.a(null);
        AppMethodBeat.o(44892);
    }

    public void finish() {
        AppMethodBeat.i(44878);
        ab.i("MicroMsg.RemittanceBusiResultUI", "finish this %s %s", this, bo.dpG());
        if (this.pSQ) {
            AppMethodBeat.o(44878);
            return;
        }
        super.finish();
        this.pSQ = true;
        AppMethodBeat.o(44878);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(44879);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(44879);
        return dispatchTouchEvent;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44880);
        super.onCreate(bundle);
        nf(1537);
        nf(1680);
        nf(2504);
        this.pSR.dnU();
        if (d.iW(21)) {
            if (d.iW(23)) {
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
            ab.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", e, "", new Object[0]);
        }
        this.pSJ = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.pOx = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.pOy = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.pSF = false;
        ab.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        a(new j(this.pSI, this.pSC), true, true);
        initView();
        AppMethodBeat.o(44880);
    }

    public final void initView() {
        AppMethodBeat.i(44881);
        this.iDT = (TextView) findViewById(R.id.dyr);
        this.pSi = (TextView) findViewById(R.id.dys);
        this.pSj = (TextView) findViewById(R.id.dz2);
        this.pSk = (TextView) findViewById(R.id.dz4);
        this.pSp = (LinearLayout) findViewById(R.id.dz1);
        this.pSq = (LinearLayout) findViewById(R.id.dz3);
        this.pSl = (CdnImageView) findViewById(R.id.dz9);
        this.pSm = (TextView) findViewById(R.id.dz_);
        this.pSn = (TextView) findViewById(R.id.dza);
        this.pSo = (Button) findViewById(R.id.dzb);
        this.pSr = (ViewGroup) findViewById(R.id.dz7);
        this.nsJ = (Button) findViewById(R.id.dzg);
        this.pSs = findViewById(R.id.dz0);
        this.pSt = (LinearLayout) findViewById(R.id.dyz);
        this.pSi.setText(e.F(this.pSx));
        cfQ();
        if (bo.isNullOrNil(this.pSu)) {
            this.pSp.setVisibility(8);
        } else {
            this.pSj.setText(this.pSu);
            this.pSp.setVisibility(0);
        }
        if (bo.isNullOrNil(this.pSv)) {
            this.pSq.setVisibility(8);
        } else {
            this.pSk.setText(this.pSv);
            this.pSq.setVisibility(0);
        }
        this.nsJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44870);
                RemittanceBusiResultUI.this.finish();
                AppMethodBeat.o(44870);
            }
        });
        this.pSL = (WalletSuccPageAwardWidget) findViewById(R.id.dze);
        this.pSM = (ViewGroup) findViewById(R.id.dyw);
        this.pSN = (ViewGroup) findViewById(R.id.dyx);
        this.pSO = (ViewGroup) findViewById(R.id.dz5);
        this.pSP = (TextView) findViewById(R.id.dz6);
        AppMethodBeat.o(44881);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(44882);
        if (mVar instanceof j) {
            j jVar = (j) mVar;
            if (i != 0 || i2 != 0) {
                ab.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", jVar);
            } else if (jVar.pOW.kdT == 0) {
                ab.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", jVar.pOW.tBw);
                this.pSK = jVar.pOW.tBw;
                if (WalletSuccPageAwardWidget.a(this.pSK)) {
                    ab.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", this.oXY);
                    this.pSL.a(this, this.pSK, this.oXY, true, (ImageView) findViewById(R.id.btd));
                    this.pSL.init();
                    this.pSL.setVisibility(0);
                    final ImageView imageView = (ImageView) findViewById(R.id.btd);
                    imageView.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(44871);
                            ViewGroup viewGroup = (ViewGroup) RemittanceBusiResultUI.this.findViewById(R.id.dyl);
                            LayoutParams layoutParams = imageView.getLayoutParams();
                            layoutParams.width = viewGroup.getWidth();
                            layoutParams.height = viewGroup.getHeight();
                            imageView.setLayoutParams(layoutParams);
                            AppMethodBeat.o(44871);
                        }
                    });
                    dv(this.pSL);
                } else {
                    this.pSL.setVisibility(8);
                }
                this.pSN.setVisibility(8);
                this.pSM.setVisibility(8);
                this.pSO.setVisibility(8);
                TextView textView = (TextView) findViewById(R.id.dyu);
                final View findViewById = findViewById(R.id.dyt);
                if (!(jVar == null || jVar.pOW == null || jVar.pOW.vPR.size() <= 0)) {
                    LinkedList linkedList = jVar.pOW.vPR;
                    String str2 = "MicroMsg.RemittanceBusiResultUI";
                    String str3 = "discountInfoList: %s, size: %s received_amount: %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = linkedList;
                    objArr[1] = Integer.valueOf(linkedList != null ? linkedList.size() : 0);
                    objArr[2] = Long.valueOf(jVar.pOW.vPQ);
                    ab.i(str2, str3, objArr);
                    str2 = "";
                    int size = linkedList.size();
                    if (linkedList != null && linkedList.size() > 0) {
                        String str4;
                        this.pSN.removeAllViews();
                        this.pSM.setOnClickListener(null);
                        if (size > 1) {
                            str4 = jVar.pOW.vPU;
                            this.pSS = true;
                            findViewById.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    boolean z = false;
                                    AppMethodBeat.i(44873);
                                    if (RemittanceBusiResultUI.this.pSS) {
                                        findViewById.setVisibility(8);
                                        RemittanceBusiResultUI.this.pSM.setVisibility(0);
                                        RemittanceBusiResultUI.a(RemittanceBusiResultUI.this, RemittanceBusiResultUI.this.pSN);
                                    } else {
                                        findViewById.setVisibility(0);
                                        RemittanceBusiResultUI.this.pSM.setVisibility(8);
                                        RemittanceBusiResultUI.a(RemittanceBusiResultUI.this, findViewById);
                                    }
                                    RemittanceBusiResultUI remittanceBusiResultUI = RemittanceBusiResultUI.this;
                                    if (!RemittanceBusiResultUI.this.pSS) {
                                        z = true;
                                    }
                                    remittanceBusiResultUI.pSS = z;
                                    AppMethodBeat.o(44873);
                                }
                            });
                            this.pSM.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    boolean z = false;
                                    AppMethodBeat.i(44874);
                                    if (RemittanceBusiResultUI.this.pSS) {
                                        findViewById.setVisibility(8);
                                        RemittanceBusiResultUI.this.pSM.setVisibility(0);
                                        RemittanceBusiResultUI.a(RemittanceBusiResultUI.this, RemittanceBusiResultUI.this.pSN);
                                    } else {
                                        findViewById.setVisibility(0);
                                        RemittanceBusiResultUI.this.pSM.setVisibility(8);
                                        RemittanceBusiResultUI.a(RemittanceBusiResultUI.this, findViewById);
                                    }
                                    RemittanceBusiResultUI remittanceBusiResultUI = RemittanceBusiResultUI.this;
                                    if (!RemittanceBusiResultUI.this.pSS) {
                                        z = true;
                                    }
                                    remittanceBusiResultUI.pSS = z;
                                    AppMethodBeat.o(44874);
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
                            layoutParams.bottomMargin = com.tencent.mm.bz.a.fromDPToPix(this, 6);
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
                        SpannableString spannableString = new SpannableString(bo.bc(str2, "") + " ");
                        if (size > 1) {
                            findViewById(R.id.dyv).setVisibility(0);
                        } else {
                            findViewById(R.id.dyv).setVisibility(8);
                        }
                        textView.setText(spannableString);
                        this.pSM.setVisibility(8);
                    }
                }
                al.af(this.pST);
                a(jVar);
            } else {
                ab.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s", Integer.valueOf(jVar.pOW.kdT), jVar.pOW.kdU);
            }
        } else if (mVar instanceof f) {
            f fVar = (f) mVar;
            if (i != 0 || i2 != 0) {
                ab.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", fVar);
            } else if (fVar.pOJ.kdT == 0) {
                final mr mrVar = fVar.pOJ.vPf;
                if (mrVar != null) {
                    this.pSl.setUrl(mrVar.cIY);
                    this.pSm.setText(mrVar.title);
                    this.pSn.setText(mrVar.tzT);
                    this.pSo.setText(mrVar.tID);
                    this.pSo.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(44872);
                            ab.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", Integer.valueOf(mrVar.type));
                            if (mrVar.type == 1) {
                                RemittanceBusiResultUI.this.pSF = true;
                                se seVar = new se();
                                seVar.cOf.userName = mrVar.vQG;
                                seVar.cOf.cOh = bo.bc(mrVar.vQH, "");
                                seVar.cOf.scene = 1034;
                                seVar.cOf.cOi = 0;
                                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                                AppMethodBeat.o(44872);
                                return;
                            }
                            if (mrVar.type == 2) {
                                RemittanceBusiResultUI.this.pSF = true;
                                e.n(RemittanceBusiResultUI.this.mController.ylL, mrVar.url, true);
                            }
                            AppMethodBeat.o(44872);
                        }
                    });
                    this.pSo.setBackgroundResource(R.drawable.yl);
                    this.pSo.setTextColor(getResources().getColor(R.color.a6b));
                    this.pSr.setVisibility(0);
                    dv(this.pSr);
                } else {
                    ab.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
                    this.pSr.setVisibility(8);
                }
            } else {
                ab.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", Integer.valueOf(fVar.pOJ.kdT), fVar.pOJ.kdU);
                Toast.makeText(this, fVar.pOJ.kdU, 1).show();
            }
        }
        boolean z = false;
        if (this.pSK != null) {
            z = this.pSL.c(i, i2, str, mVar);
        }
        if (du(this.pSp) && du(this.pSq) && du(this.pSO)) {
            this.pSs.setVisibility(8);
        } else {
            this.pSs.setVisibility(0);
        }
        AppMethodBeat.o(44882);
        return z;
    }

    private static boolean du(View view) {
        AppMethodBeat.i(44883);
        if (view == null || view.getVisibility() == 8) {
            AppMethodBeat.o(44883);
            return true;
        }
        AppMethodBeat.o(44883);
        return false;
    }

    public void onResume() {
        AppMethodBeat.i(44884);
        super.onResume();
        if (this.pSF) {
            ab.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
            a(new f(this.pSy, this.oXY, this.pRC, (int) Math.round(this.pSx * 100.0d), this.pSE, this.pSD), false, false);
            this.pSF = false;
        }
        if (this.pSK != null) {
            this.pSL.onResume();
        }
        AppMethodBeat.o(44884);
    }

    public void onDestroy() {
        AppMethodBeat.i(44885);
        super.onDestroy();
        ng(1537);
        ng(1680);
        ng(2504);
        this.pSR.dead();
        if (this.pSK != null) {
            this.pSL.onDestroy();
        }
        AppMethodBeat.o(44885);
    }

    public final int getLayoutId() {
        return R.layout.aod;
    }

    private void dv(View view) {
        AppMethodBeat.i(44887);
        findViewById(R.id.rm).setVisibility(8);
        view.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(44875);
                RemittanceBusiResultUI.e(RemittanceBusiResultUI.this);
                AppMethodBeat.o(44875);
            }
        });
        AppMethodBeat.o(44887);
    }

    private void cfQ() {
        AppMethodBeat.i(44888);
        al.n(this.pST, 500);
        AppMethodBeat.o(44888);
    }

    private void a(j jVar) {
        CharSequence string;
        AppMethodBeat.i(44889);
        this.pSt.removeAllViews();
        String eK;
        Object string2;
        if (bo.isNullOrNil(this.pQW)) {
            eK = e.eK(e.mJ(this.pSw), 6);
            if (!bo.isNullOrNil(this.pSG)) {
                string2 = getString(R.string.do0, new Object[]{eK, this.pSG});
            }
            string2 = eK;
        } else {
            eK = e.eK(this.pQW, 6);
            if (!bo.isNullOrNil(this.pSG)) {
                string2 = getString(R.string.do0, new Object[]{eK, this.pSG});
            }
            string2 = eK;
        }
        if (du(this.pSp) && du(this.pSq) && du(this.pSO) && du(this.pSr) && !WalletSuccPageAwardWidget.a(this.pSK) && du(findViewById(R.id.dyt)) && du(this.pSM)) {
            ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.x1, this.pSt, false);
            this.pSt.addView(viewGroup);
            CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(R.id.bld);
            TextView textView = (TextView) viewGroup.findViewById(R.id.ble);
            if (!bo.isNullOrNil(this.pOy)) {
                if (this.pSJ == 1) {
                    cdnImageView.setRoundCorner(true);
                }
                cdnImageView.setUrl(this.pOy);
            } else if (this.pSJ == 1) {
                com.tencent.mm.pluginsdk.ui.a.b.r(cdnImageView, this.pSw);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(cdnImageView, this.pSw);
            }
            textView.setText(string2);
        } else {
            this.pSt.addView((ViewGroup) getLayoutInflater().inflate(R.layout.aoc, this.pSt, false));
            CdnImageView cdnImageView2 = (CdnImageView) findViewById(R.id.bld);
            TextView textView2 = (TextView) findViewById(R.id.ble);
            View findViewById = findViewById(R.id.dyn);
            TextView textView3 = (TextView) findViewById(R.id.dyo);
            textView2.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, string2));
            cdnImageView2.setVisibility(0);
            if (!bo.isNullOrNil(this.pOy)) {
                if (this.pSJ == 1) {
                    cdnImageView2.setRoundCorner(true);
                }
                cdnImageView2.setUrl(this.pOy);
            } else if (this.pSJ == 1) {
                com.tencent.mm.pluginsdk.ui.a.b.r(cdnImageView2, this.pSw);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(cdnImageView2, this.pSw);
            }
            findViewById.setVisibility(8);
            textView3.setVisibility(8);
            if (jVar != null) {
                if (jVar.pOW.vPT == 1) {
                    findViewById.setVisibility(0);
                    textView3.setVisibility(0);
                    textView3.setText(e.G(((double) jVar.pOW.vPQ) / 100.0d));
                } else {
                    findViewById.setVisibility(8);
                    textView3.setVisibility(8);
                }
            }
        }
        dv(this.pSt);
        AppMethodBeat.o(44889);
    }

    public final void AM(int i) {
        AppMethodBeat.i(44886);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.o(44886);
    }

    static /* synthetic */ void e(RemittanceBusiResultUI remittanceBusiResultUI) {
        AppMethodBeat.i(44891);
        View findViewById = remittanceBusiResultUI.findViewById(R.id.rm);
        findViewById.setVisibility(0);
        if (findViewById != null) {
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(remittanceBusiResultUI, 25);
            int i = fromDPToPix * 2;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
            View findViewById2 = remittanceBusiResultUI.findViewById(R.id.dyp);
            View findViewById3 = remittanceBusiResultUI.findViewById(R.id.dzf);
            if (findViewById2.getMeasuredHeight() > 0) {
                findViewById2.getMeasuredHeight();
                int height = ((WindowManager) remittanceBusiResultUI.getSystemService("window")).getDefaultDisplay().getHeight() - ak.hF(remittanceBusiResultUI);
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
                AppMethodBeat.o(44891);
                return;
            }
            marginLayoutParams.topMargin = fromDPToPix;
            marginLayoutParams.bottomMargin = i;
            findViewById.setLayoutParams(marginLayoutParams);
            findViewById.setVisibility(0);
            findViewById.requestLayout();
        }
        AppMethodBeat.o(44891);
    }
}
