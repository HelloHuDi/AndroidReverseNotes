package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.b.a.bh;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.plugin.remittance.model.k;
import com.tencent.mm.plugin.remittance.model.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RemittanceBusiUI extends WalletBaseUI {
    private String cEW;
    private int cKs = 0;
    private ScrollView nsk;
    private String oXY;
    private int obL;
    private String pQW;
    private int pQY;
    private String pRC;
    private boolean pRH = false;
    private bh pRJ;
    private boolean pRM;
    private boolean pRP;
    private c pRR = new c<fw>() {
        {
            AppMethodBeat.i(44909);
            this.xxI = fw.class.getName().hashCode();
            AppMethodBeat.o(44909);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(44910);
            fw fwVar = (fw) bVar;
            if (fwVar.czT.czW == 1) {
                h.pYm.e(15386, Integer.valueOf(4), Integer.valueOf(2));
            } else {
                h.pYm.e(15386, Integer.valueOf(5), Integer.valueOf(2));
            }
            RemittanceBusiUI.a(RemittanceBusiUI.this, fwVar.czT.czU, fwVar);
            AppMethodBeat.o(44910);
            return false;
        }
    };
    private LinearLayout pRm;
    private String pSD;
    private BusiRemittanceResp pSH;
    private TextView pSY;
    private TextView pSZ;
    private String pSy;
    private String pSz;
    private int pTA;
    private String pTB;
    private chl pTC;
    private String pTD;
    private int pTE = 0;
    private int pTF = 0;
    private int pTG = 0;
    private int pTH = 0;
    private String pTI;
    private b pTJ = new b();
    private String pTK = "";
    private String pTL = "";
    boolean pTM = false;
    private double pTN = -1.0d;
    private boolean pTO = false;
    g pTP = null;
    private a pTQ;
    private a pTR;
    private Map<String, cz> pTS = new HashMap();
    private Runnable pTT = new Runnable() {
        public final void run() {
            AppMethodBeat.i(44901);
            RemittanceBusiUI.C(RemittanceBusiUI.this);
            AppMethodBeat.o(44901);
        }
    };
    private com.tencent.mm.wallet_core.d.c<l> pTU = new com.tencent.mm.wallet_core.d.c<l>() {
        public final /* bridge */ /* synthetic */ boolean a(int i, int i2, d dVar) {
            AppMethodBeat.i(44905);
            boolean a = RemittanceBusiUI.a(RemittanceBusiUI.this, i, i2, (l) dVar);
            AppMethodBeat.o(44905);
            return a;
        }

        public final void a(d dVar) {
            AppMethodBeat.i(44904);
            if (dVar instanceof l) {
                RemittanceBusiUI.b(RemittanceBusiUI.this, ((l) dVar).czZ);
            }
            AppMethodBeat.o(44904);
        }
    };
    private b pTV = new b();
    private boolean pTW = true;
    private double pTX = 0.0d;
    private String pTY;
    private String pTZ = "";
    private TextView pTa;
    private TextView pTb;
    private TextView pTc;
    private TextView pTd;
    private TextView pTe;
    private View pTf;
    private CdnImageView pTg;
    private WalletFormView pTh;
    private Button pTi;
    private LinearLayout pTj;
    private LinearLayout pTk;
    private TextView pTl;
    private View pTm;
    private TextView pTn;
    private String pTo;
    private double pTp;
    private String pTq;
    private String pTr;
    private String pTs;
    private String pTt;
    private String pTu;
    private int pTv;
    private String pTw;
    private boolean pTx;
    private String pTy;
    private int pTz;
    private c pUa = new c<ob>() {
        {
            AppMethodBeat.i(44911);
            this.xxI = ob.class.getName().hashCode();
            AppMethodBeat.o(44911);
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(44912);
            ob obVar = (ob) bVar;
            if (!(obVar == null || obVar.cKr == null)) {
                RemittanceBusiUI.a(RemittanceBusiUI.this, obVar.cKr.cwB, obVar.cKr.cKs);
            }
            AppMethodBeat.o(44912);
            return false;
        }
    };
    private c pUb = new c<fv>() {
        {
            AppMethodBeat.i(44913);
            this.xxI = fv.class.getName().hashCode();
            AppMethodBeat.o(44913);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(44914);
            RemittanceBusiUI.E(RemittanceBusiUI.this);
            AppMethodBeat.o(44914);
            return false;
        }
    };
    private c pUc = new c<vc>() {
        {
            AppMethodBeat.i(44915);
            this.xxI = vc.class.getName().hashCode();
            AppMethodBeat.o(44915);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(44916);
            vc vcVar = (vc) bVar;
            com.tencent.mm.sdk.b.a.xxA.d(RemittanceBusiUI.this.pUc);
            if (vcVar.cRZ.result == -1) {
                RemittanceBusiUI.this.pTi.performClick();
            }
            AppMethodBeat.o(44916);
            return false;
        }
    };

    class b implements Runnable {
        public d pUr;

        b() {
        }

        public final void run() {
            AppMethodBeat.i(44932);
            RemittanceBusiUI.this.pTU.b(this.pUr);
            AppMethodBeat.o(44932);
        }
    }

    class a {
        private View jAp;
        private float pUl;
        private float pUm;
        private float pUn;
        private TenpaySecureEditText pUo;
        private TextView pUp;
        private View pUq;

        a(int i, int i2, float f) {
            AppMethodBeat.i(44930);
            this.pUl = (float) i;
            this.pUm = (float) i2;
            this.pUn = f;
            AppMethodBeat.o(44930);
        }

        /* Access modifiers changed, original: final */
        public final void update() {
            AppMethodBeat.i(44931);
            RemittanceBusiUI.this.pTb.setTextSize(1, RemittanceBusiUI.this.pTQ.pUm);
            RemittanceBusiUI.this.pTl.setTextSize(1, RemittanceBusiUI.this.pTQ.pUl);
            if (this.pUp == null) {
                this.pUp = (TextView) RemittanceBusiUI.this.pTh.findViewById(R.id.dc);
            }
            if (this.pUp != null) {
                this.pUp.setTextSize(this.pUl);
            }
            if (this.pUo == null) {
                this.pUo = (TenpaySecureEditText) RemittanceBusiUI.this.pTh.findViewById(R.id.d6);
            }
            if (this.pUo != null) {
                this.pUo.setTextSize(this.pUm);
            }
            if (this.jAp == null) {
                this.jAp = this.pUo.findViewById(R.id.fgr);
            }
            if (this.jAp != null) {
                this.jAp.setMinimumHeight(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(RemittanceBusiUI.this, RemittanceBusiUI.this.pTQ.pUm));
            }
            if (this.pUq == null) {
                this.pUq = RemittanceBusiUI.this.findViewById(R.id.dzl);
            }
            if (this.pUq != null) {
                ((LayoutParams) this.pUq.getLayoutParams()).topMargin = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(RemittanceBusiUI.this, this.pUn);
            }
            AppMethodBeat.o(44931);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceBusiUI() {
        AppMethodBeat.i(44933);
        AppMethodBeat.o(44933);
    }

    static /* synthetic */ boolean B(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(44971);
        boolean cfS = remittanceBusiUI.cfS();
        AppMethodBeat.o(44971);
        return cfS;
    }

    static /* synthetic */ void E(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(44978);
        remittanceBusiUI.cfT();
        AppMethodBeat.o(44978);
    }

    static /* synthetic */ boolean f(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(44961);
        boolean cNR = remittanceBusiUI.cNR();
        AppMethodBeat.o(44961);
        return cNR;
    }

    static /* synthetic */ void g(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(44962);
        remittanceBusiUI.cbv();
        AppMethodBeat.o(44962);
    }

    static /* synthetic */ void j(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(44964);
        remittanceBusiUI.cfI();
        AppMethodBeat.o(44964);
    }

    static /* synthetic */ double n(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(44966);
        double cfR = remittanceBusiUI.cfR();
        AppMethodBeat.o(44966);
        return cfR;
    }

    private double cfR() {
        AppMethodBeat.i(44934);
        double d;
        if (this.pTx || this.pQY == 33) {
            d = this.pTp;
            AppMethodBeat.o(44934);
            return d;
        }
        this.pTp = bo.getDouble(this.pTh.getText(), 0.0d);
        d = this.pTp;
        AppMethodBeat.o(44934);
        return d;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44935);
        super.onCreate(bundle);
        h.pYm.e(15235, Integer.valueOf(1));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.y3)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(R.color.h4));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(R.color.y3));
        }
        if (com.tencent.mm.compatible.util.d.iW(21)) {
            if (com.tencent.mm.compatible.util.d.iW(23)) {
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44903);
                if (RemittanceBusiUI.f(RemittanceBusiUI.this)) {
                    RemittanceBusiUI.this.aqX();
                    RemittanceBusiUI.this.showDialog(1000);
                } else {
                    RemittanceBusiUI.this.finish();
                }
                AppMethodBeat.o(44903);
                return true;
            }
        }, R.raw.actionbar_icon_dark_back);
        nf(1633);
        nf(1241);
        nf(2677);
        nf(2504);
        nf(2702);
        nf(2682);
        com.tencent.mm.wallet_core.d.c cVar = this.pTU;
        i iVar = this.Ahr;
        cVar.rtType = 2682;
        cVar.Agk = iVar;
        iVar.Agq.put(Integer.valueOf(2682), cVar);
        setMMTitle((int) R.string.dnw);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44893);
                RemittanceBusiUI.e(RemittanceBusiUI.this);
                RemittanceBusiUI.this.finish();
                AppMethodBeat.o(44893);
                return false;
            }
        });
        this.cEW = UUID.randomUUID().toString();
        com.tencent.mm.plugin.wallet.pay.a.b.acq(this.cEW);
        this.pQY = getIntent().getIntExtra("pay_scene", 31);
        this.pTo = getIntent().getStringExtra("scan_remittance_id");
        this.pTp = getIntent().getDoubleExtra("fee", 0.0d);
        this.pTq = getIntent().getStringExtra("receiver_name");
        this.pTr = getIntent().getStringExtra("receiver_true_name");
        this.pTs = getIntent().getStringExtra("receiver_true_name_busi");
        this.obL = getIntent().getIntExtra("pay_channel", 0);
        this.pTt = getIntent().getStringExtra("desc");
        this.pTv = getIntent().getIntExtra("busi_type", 0);
        this.pQW = getIntent().getStringExtra("mch_name");
        this.pTy = getIntent().getStringExtra("mch_type");
        this.pTA = getIntent().getIntExtra("mch_time", 0);
        this.pTw = getIntent().getStringExtra("mch_info");
        this.pTz = getIntent().getIntExtra("get_pay_wifi", 0);
        this.pRC = getIntent().getStringExtra("rcvr_open_id");
        this.pTu = getIntent().getStringExtra("rcvr_ticket");
        this.pTI = getIntent().getStringExtra("receiver_tips");
        this.pSH = (BusiRemittanceResp) getIntent().getParcelableExtra("BusiRemittanceResp");
        if (this.pSH != null) {
            boolean z = this.pQY == 32 && (this.pSH.pOF == 1 || (this.pSH != null && this.pSH.pOD.size() > 0));
            this.pTM = z;
        }
        if (this.pTp > 0.0d) {
            this.pTx = true;
        } else {
            this.pTx = false;
        }
        if (this.pTv == 0) {
            ab.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
            finish();
        }
        h.pYm.e(15386, Integer.valueOf(1), Integer.valueOf(2));
        this.pTQ = new a(28, 28, 2.0f);
        this.pTR = new a(50, 50, 8.0f);
        initView();
        cbv();
        AppMethodBeat.o(44935);
    }

    public void onResume() {
        AppMethodBeat.i(44936);
        super.onResume();
        e.cfP().eL(this);
        AppMethodBeat.o(44936);
    }

    public final void initView() {
        AppMethodBeat.i(44937);
        this.nsk = (ScrollView) findViewById(R.id.ih);
        this.pSY = (TextView) findViewById(R.id.dzh);
        this.pSZ = (TextView) findViewById(R.id.dzi);
        this.pTa = (TextView) findViewById(R.id.dzn);
        this.pTb = (TextView) findViewById(R.id.dzp);
        this.pTc = (TextView) findViewById(R.id.e00);
        this.pTd = (TextView) findViewById(R.id.e01);
        this.pTg = (CdnImageView) findViewById(R.id.bld);
        this.pTh = (WalletFormView) findViewById(R.id.dzk);
        this.pTi = (Button) findViewById(R.id.dzy);
        this.pTj = (LinearLayout) findViewById(R.id.dzm);
        this.pRm = (LinearLayout) findViewById(R.id.dzj);
        this.pTk = (LinearLayout) findViewById(R.id.dzz);
        this.pTe = (TextView) findViewById(R.id.dzt);
        this.pTf = findViewById(R.id.dzq);
        this.pTl = (TextView) findViewById(R.id.dzo);
        this.pTm = findViewById(R.id.dzv);
        this.pTn = (TextView) findViewById(R.id.dzx);
        if (this.pTx) {
            if (!bo.isNullOrNil(this.pTt)) {
                this.pTa.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, this.pTt, this.pTa.getTextSize()));
            }
            this.pTb.setText(e.F(this.pTp));
            this.pTj.setVisibility(0);
            this.pRm.setVisibility(8);
        } else {
            boolean z;
            if (this.pSH != null) {
                boolean z2;
                if (this.pSH.pOD.size() > 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                z = (this.pSH.pOE == null || this.pSH.pOE.vPg.size() <= 0) ? z2 : false;
            } else {
                z = true;
            }
            a(this.pTh, 2, false, z, true);
            this.pTh.a(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(44917);
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 2) {
                        editable.delete(indexOf + 3, length);
                    }
                    RemittanceBusiUI.g(RemittanceBusiUI.this);
                    if (RemittanceBusiUI.this.pQY == 32) {
                        RemittanceBusiUI.a(RemittanceBusiUI.this, null, RemittanceBusiUI.this.pSH == null ? 400 : RemittanceBusiUI.this.pSH.pOH);
                    }
                    AppMethodBeat.o(44917);
                }
            });
            this.pTj.setVisibility(8);
            this.pRm.setVisibility(0);
        }
        if (com.tencent.mm.kernel.g.RK()) {
            com.tencent.mm.kernel.g.RQ();
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(this.pTq);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                com.tencent.mm.model.ao.a.flu.a(this.pTq, "", new com.tencent.mm.model.ao.b.a() {
                    public final void o(String str, boolean z) {
                        AppMethodBeat.i(44919);
                        ab.i("MicroMsg.RemittanceBusiUI", "getContact %s", Boolean.valueOf(z));
                        RemittanceBusiUI.j(RemittanceBusiUI.this);
                        AppMethodBeat.o(44919);
                    }
                });
            }
        }
        cfI();
        this.pTk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44923);
                if (!RemittanceBusiUI.this.pTx) {
                    RemittanceBusiUI.this.aoB();
                }
                h.pYm.e(15235, Integer.valueOf(6));
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBusiUI.this, RemittanceBusiUI.this.getString(R.string.dnl), RemittanceBusiUI.this.pSz, RemittanceBusiUI.this.getString(R.string.dnn), 20, new com.tencent.mm.ui.base.h.b() {
                    public final boolean s(CharSequence charSequence) {
                        AppMethodBeat.i(44920);
                        RemittanceBusiUI.this.pSz = charSequence.toString();
                        RemittanceBusiUI.m(RemittanceBusiUI.this);
                        AppMethodBeat.o(44920);
                        return true;
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(44922);
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(44921);
                                RemittanceBusiUI.this.aqX();
                                AppMethodBeat.o(44921);
                            }
                        }, 500);
                        AppMethodBeat.o(44922);
                    }
                });
                AppMethodBeat.o(44923);
            }
        });
        this.pTi.setOnClickListener(new s() {
            public final void bgW() {
                AppMethodBeat.i(44926);
                h.pYm.e(15235, Integer.valueOf(5));
                if (!RemittanceBusiUI.this.pTx) {
                    RemittanceBusiUI.this.pTp = RemittanceBusiUI.n(RemittanceBusiUI.this);
                }
                if (RemittanceBusiUI.this.pTp <= 0.0d) {
                    t.makeText(RemittanceBusiUI.this.mController.ylL, R.string.f9y, 0).show();
                    AppMethodBeat.o(44926);
                    return;
                }
                String str;
                String str2 = "MicroMsg.RemittanceBusiUI";
                String str3 = "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s";
                Object[] objArr = new Object[3];
                objArr[0] = RemittanceBusiUI.this.pTP;
                if (RemittanceBusiUI.this.pTP == null) {
                    str = "";
                } else {
                    str = RemittanceBusiUI.this.pTP.pOO;
                }
                objArr[1] = str;
                objArr[2] = Boolean.valueOf(RemittanceBusiUI.this.pTM);
                ab.i(str2, str3, objArr);
                if (RemittanceBusiUI.this.pQY == 32) {
                    if (!RemittanceBusiUI.this.pTM) {
                        RemittanceBusiUI.p(RemittanceBusiUI.this);
                        AppMethodBeat.o(44926);
                        return;
                    } else if (RemittanceBusiUI.this.pTP == null || RemittanceBusiUI.this.pTP.pOR != ((int) (RemittanceBusiUI.this.pTp * 100.0d))) {
                        RemittanceBusiUI.a(RemittanceBusiUI.this, new com.tencent.mm.plugin.remittance.model.c() {
                            public final void cR(List<abw> list) {
                                AppMethodBeat.i(44925);
                                RemittanceBusiUI.p(RemittanceBusiUI.this);
                                AppMethodBeat.o(44925);
                            }
                        }, 0);
                        AppMethodBeat.o(44926);
                        return;
                    } else if (RemittanceBusiUI.this.pTP == null || !RemittanceBusiUI.this.pTP.pOO) {
                        if (RemittanceBusiUI.this.pTP != null) {
                            RemittanceBusiUI.this.pTP.pOM = new com.tencent.mm.plugin.remittance.model.c() {
                                public final void cR(List<abw> list) {
                                    AppMethodBeat.i(44924);
                                    RemittanceBusiUI.p(RemittanceBusiUI.this);
                                    AppMethodBeat.o(44924);
                                }
                            };
                            AppMethodBeat.o(44926);
                            return;
                        }
                        AppMethodBeat.o(44926);
                    }
                }
                RemittanceBusiUI.p(RemittanceBusiUI.this);
                AppMethodBeat.o(44926);
            }
        });
        this.nsk.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(44927);
                if (RemittanceBusiUI.this.pTO) {
                    RemittanceBusiUI.this.aoB();
                }
                AppMethodBeat.o(44927);
                return false;
            }
        });
        this.obM = new com.tencent.mm.wallet_core.ui.a() {
            public final void ic(boolean z) {
                AppMethodBeat.i(44928);
                RemittanceBusiUI.this.pTO = z;
                if (z) {
                    RemittanceBusiUI.a(RemittanceBusiUI.this, RemittanceBusiUI.this.nsk, RemittanceBusiUI.this.pTi);
                    AppMethodBeat.o(44928);
                    return;
                }
                RemittanceBusiUI.this.nsk.scrollTo(0, 0);
                if (RemittanceBusiUI.this.pTh != null && RemittanceBusiUI.this.pTh.getVisibility() == 0) {
                    RemittanceBusiUI.this.pTh.setFocusable(false);
                    RemittanceBusiUI.this.pTh.setFocusable(true);
                }
                AppMethodBeat.o(44928);
            }
        };
        if (!(this.pSH == null || this.pSH.pOE == null)) {
            this.pTJ.pQH = this.pSH.pOE;
            this.pTJ.VR(this.pSH.pOE.vPi);
        }
        if (cfS()) {
            h.pYm.e(15235, Integer.valueOf(2));
        }
        AppMethodBeat.o(44937);
    }

    private void cfI() {
        AppMethodBeat.i(44938);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(44929);
                RemittanceBusiUI.this.pSY.setText(RemittanceBusiUI.this.pTI);
                CharSequence eK = e.eK(e.mJ(RemittanceBusiUI.this.pTq), 10);
                if (!bo.isNullOrNil(RemittanceBusiUI.this.pTr)) {
                    eK = RemittanceBusiUI.this.getString(R.string.do0, new Object[]{eK, RemittanceBusiUI.this.pTr});
                }
                RemittanceBusiUI.this.pSZ.setText(com.tencent.mm.pluginsdk.ui.e.j.b(RemittanceBusiUI.this, eK, RemittanceBusiUI.this.pSZ.getTextSize()));
                if (RemittanceBusiUI.this.pSH != null) {
                    if (RemittanceBusiUI.this.pSH.pOx != 1) {
                        RemittanceBusiUI.this.pTg.setVisibility(8);
                        AppMethodBeat.o(44929);
                        return;
                    } else if (!bo.isNullOrNil(RemittanceBusiUI.this.pSH.pOy)) {
                        if (RemittanceBusiUI.this.pSH.pOG == 1) {
                            RemittanceBusiUI.this.pTg.setRoundCorner(true);
                        } else {
                            RemittanceBusiUI.this.pTg.setRoundCorner(false);
                        }
                        int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(RemittanceBusiUI.this, 36.0f);
                        RemittanceBusiUI.this.pTg.n(RemittanceBusiUI.this.pSH.pOy, b, b, -1);
                        AppMethodBeat.o(44929);
                        return;
                    } else if (!bo.isNullOrNil(RemittanceBusiUI.this.pTq)) {
                        if (RemittanceBusiUI.this.pSH.pOG == 1) {
                            com.tencent.mm.pluginsdk.ui.a.b.r(RemittanceBusiUI.this.pTg, RemittanceBusiUI.this.pTq);
                            AppMethodBeat.o(44929);
                            return;
                        }
                        com.tencent.mm.pluginsdk.ui.a.b.b(RemittanceBusiUI.this.pTg, RemittanceBusiUI.this.pTq);
                        AppMethodBeat.o(44929);
                        return;
                    }
                }
                RemittanceBusiUI.this.pTg.setVisibility(8);
                AppMethodBeat.o(44929);
            }
        });
        AppMethodBeat.o(44938);
    }

    private boolean cfS() {
        AppMethodBeat.i(44939);
        if (this.pTf == null) {
            AppMethodBeat.o(44939);
            return false;
        } else if (this.pSH != null) {
            boolean z;
            ab.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
            if (this.pSH.pOE == null || this.pSH.pOE.vPh.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (this.pSH.pOD.size() > 0) {
                z = true;
            }
            if (this.pTJ.cfu().size() > 0) {
                z = true;
            }
            if (z) {
                this.pTm.setVisibility(0);
                this.pTQ.update();
                this.pTf.setVisibility(0);
                this.pTe.setText(this.pSH.pOz);
                this.pTe.setTextColor(-7829368);
                this.pTn.setText(e.F(cfR()));
                abv abv = this.pTJ.pQG;
                if (abv != null) {
                    this.pTe.setTextColor(-30434);
                    this.pTe.setText(abv.pOz);
                    this.pTn.setText(e.F(((double) abv.wjf) / 100.0d));
                } else {
                    String cfv = this.pTJ.cfv();
                    if (!bo.isNullOrNil(cfv)) {
                        this.pTe.setTextColor(-7829368);
                        this.pTe.setText(cfv);
                    }
                }
                findViewById(R.id.dzs).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(44894);
                        h.pYm.e(15235, Integer.valueOf(3));
                        RemittanceBusiUI.z(RemittanceBusiUI.this);
                        AppMethodBeat.o(44894);
                    }
                });
                AppMethodBeat.o(44939);
                return true;
            }
            this.pTf.setVisibility(8);
            this.pTR.update();
            this.pTm.setVisibility(8);
            AppMethodBeat.o(44939);
            return false;
        } else {
            AppMethodBeat.o(44939);
            return false;
        }
    }

    private void cS(final List<abw> list) {
        AppMethodBeat.i(44940);
        final com.tencent.mm.ui.widget.picker.d dVar = new com.tencent.mm.ui.widget.picker.d(this);
        ArrayList arrayList = new ArrayList();
        abv abv = this.pTJ.pQG;
        HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        if (this.pTJ.cfx() && abv != null) {
            Iterator it = abv.vPg.iterator();
            while (it.hasNext()) {
                hashSet.add(Long.valueOf(((abw) it.next()).wjm));
            }
        }
        int i = 0;
        for (abw abw : list) {
            if (hashSet.contains(Long.valueOf(abw.wjm))) {
                arrayList.add(Integer.valueOf(i));
            }
            i++;
        }
        String string = getString(R.string.dp8);
        if (string != null && string.length() > 0) {
            dVar.zSw.setVisibility(0);
            dVar.rMl.setText(string);
        }
        dVar.zSx = arrayList;
        dVar.rBl = new n.c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(44898);
                int i = 0;
                RemittanceBusiUI.this.pTp = RemittanceBusiUI.n(RemittanceBusiUI.this);
                if (!RemittanceBusiUI.this.pTJ.cfx() || RemittanceBusiUI.this.pTp <= 0.0d) {
                    for (abw abw : list) {
                        lVar.a(i, abw.wjn, abw.wjp, null, true);
                        hashSet2.add(Integer.valueOf(i));
                        i++;
                    }
                    AppMethodBeat.o(44898);
                    return;
                }
                for (abw abw2 : list) {
                    if (abw2.wjv == 1) {
                        lVar.a(i, abw2.wjn, abw2.wjp, null, true);
                        hashSet2.add(Integer.valueOf(i));
                    } else {
                        lVar.a(i, abw2.wjn, abw2.wjp);
                    }
                    i++;
                }
                AppMethodBeat.o(44898);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                int i2 = 1;
                int i3 = 0;
                AppMethodBeat.i(44899);
                if (hashSet2.contains(Integer.valueOf(i))) {
                    AppMethodBeat.o(44899);
                    return;
                }
                if (i < list.size()) {
                    h.pYm.e(15235, Integer.valueOf(4));
                    abw abw = (abw) list.get(i);
                    com.tencent.mm.ui.widget.picker.d dVar = dVar;
                    List dLn;
                    if (dVar.zSy != null) {
                        dLn = dVar.zSy.dLn();
                    } else {
                        dLn = new ArrayList();
                    }
                    boolean contains = dLn.contains(Integer.valueOf(i));
                    if (contains) {
                        i2 = 0;
                    }
                    List linkedList = new LinkedList();
                    for (Integer intValue : dLn) {
                        int intValue2 = intValue.intValue();
                        if (intValue2 < list.size() && !(i2 == 0 && i == intValue2)) {
                            linkedList.add((abw) list.get(intValue2));
                        }
                    }
                    if (i2 != 0) {
                        linkedList.add(abw);
                    }
                    b A = RemittanceBusiUI.this.pTJ;
                    if (i2 == 0) {
                        abw = null;
                    }
                    A.a(linkedList, abw);
                    abv abv = RemittanceBusiUI.this.pTJ.pQG;
                    HashSet hashSet = new HashSet();
                    if (abv != null) {
                        Iterator it = abv.vPg.iterator();
                        while (it.hasNext()) {
                            hashSet.add(Long.valueOf(((abw) it.next()).wjm));
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (abw abw2 : list) {
                        if (hashSet.contains(Long.valueOf(abw2.wjm))) {
                            hashMap.put(Integer.valueOf(i3), Boolean.TRUE);
                        } else {
                            hashMap.put(Integer.valueOf(i3), Boolean.FALSE);
                        }
                        if (i3 == i) {
                            hashMap.put(Integer.valueOf(i3), Boolean.valueOf(contains));
                        }
                        i3++;
                    }
                    com.tencent.mm.ui.widget.picker.d dVar2 = dVar;
                    if (dVar2.zSy != null) {
                        dVar2.zSy.zSB = hashMap;
                        dVar2.zSy.notifyDataSetChanged();
                    }
                }
                AppMethodBeat.o(44899);
            }
        };
        dVar.zSz = new com.tencent.mm.ui.widget.picker.d.b() {
            public final void kg(boolean z) {
                AppMethodBeat.i(44900);
                if (z) {
                    abv abv = RemittanceBusiUI.this.pTJ.pQG;
                    String str = "MicroMsg.RemittanceBusiUI";
                    String str2 = "onFavorSelected %s ";
                    Object[] objArr = new Object[1];
                    objArr[0] = abv == null ? "" : com.tencent.mm.plugin.remittance.model.a.a(abv);
                    ab.i(str, str2, objArr);
                    RemittanceBusiUI.B(RemittanceBusiUI.this);
                }
                AppMethodBeat.o(44900);
            }
        };
        if (dVar.rBl != null) {
            dVar.rBl.a(dVar.rBn);
        }
        dVar.zSy = new com.tencent.mm.ui.widget.picker.d.a(dVar.mContext);
        dVar.zSy.dLm();
        dVar.zSv.setAdapter(dVar.zSy);
        dVar.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112840);
                d dVar = d.this;
                d.this.zSy.dLn();
                d.a(dVar, true);
                d.this.hide();
                AppMethodBeat.o(112840);
            }
        });
        dVar.jAH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112841);
                d.a(d.this, false);
                d.this.hide();
                AppMethodBeat.o(112841);
            }
        });
        if (dVar.zaW != null) {
            if (dVar.rBn != null && dVar.rBn.size() > 3) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dVar.iym.getLayoutParams();
                layoutParams.height = dVar.zaX;
                dVar.iym.setLayoutParams(layoutParams);
            }
            dVar.zaW.show();
        }
        AppMethodBeat.o(44940);
    }

    private void a(com.tencent.mm.plugin.remittance.model.c cVar, com.tencent.mm.plugin.remittance.model.d dVar, int i) {
        AppMethodBeat.i(44941);
        if (this.pTM) {
            this.pTn.setText(e.F(cfR()));
            al.af(this.pTT);
            this.pTp = cfR();
            long round = Math.round(this.pTp * 100.0d);
            if (round <= 0) {
                this.pTJ.cft();
                this.pTe.setTextColor(-7829368);
                this.pTe.setText(this.pSH.pOz);
                if (this.pTP != null) {
                    this.pTP.pOQ = true;
                }
                AppMethodBeat.o(44941);
                return;
            }
            this.pTP = new g((int) round, this.obL, this.pSH.pOA, this.pTt, this.pQW, this.pSH.pOB, this.pRC, this.pTq, this.pSH.pOC, cVar == null ? 0 : 1, cVar, dVar);
            al.n(this.pTT, (long) i);
        }
        AppMethodBeat.o(44941);
    }

    public void onDestroy() {
        AppMethodBeat.i(44942);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.pRR);
        com.tencent.mm.sdk.b.a.xxA.d(this.pUc);
        com.tencent.mm.sdk.b.a.xxA.d(this.pUa);
        this.pUb.dead();
        ng(1633);
        ng(1241);
        ng(2677);
        ng(2504);
        ng(2702);
        ng(2682);
        com.tencent.mm.plugin.wallet.pay.a.b.acr(this.cEW);
        AppMethodBeat.o(44942);
    }

    public final boolean c(int i, int i2, String str, final m mVar) {
        AppMethodBeat.i(44943);
        if (mVar instanceof com.tencent.mm.plugin.remittance.model.i) {
            com.tencent.mm.plugin.remittance.model.i iVar = (com.tencent.mm.plugin.remittance.model.i) mVar;
            if (i != 0 || i2 != 0) {
                ab.e("MicroMsg.RemittanceBusiUI", "net error: %s", mVar);
            } else if (iVar.pOT.kdT == 0) {
                boolean z;
                this.pSy = iVar.pOT.vFb;
                this.oXY = iVar.pOT.vFc;
                this.pSD = iVar.pOT.vFd;
                this.pTK = iVar.pOT.vPD;
                this.pTL = iVar.pOT.vPC;
                this.pTB = iVar.pOT.vPI;
                this.pTC = iVar.pOT.vPH;
                this.pTE = iVar.pOT.vPL;
                this.pTF = iVar.pOT.vPJ;
                this.pTG = iVar.pOT.vPK;
                ab.i("MicroMsg.RemittanceBusiUI", "touch_challenge %s need_change_auth_key %s", iVar.pOT.vPM, Integer.valueOf(iVar.pOT.vPN));
                if (iVar.pOT.vPM != null) {
                    v.tCn.msn = iVar.pOT.vPM.dlY();
                }
                v vVar = v.tCn;
                if (iVar.pOT.vPN == 1) {
                    z = true;
                } else {
                    z = false;
                }
                vVar.mso = z;
                if (!a(iVar)) {
                    d(iVar);
                }
            } else {
                ab.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", Integer.valueOf(iVar.pOT.kdT), iVar.pOT.kdU);
                if (iVar.pOT.vPB == null || bo.isNullOrNil(iVar.pOT.vPB.nZb)) {
                    e cfP = e.cfP();
                    DialogInterface.OnClickListener anonymousClass10 = new DialogInterface.OnClickListener() {
                        /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(44902);
                            if (bo.gW(((com.tencent.mm.plugin.remittance.model.i) mVar).pOT.vPP, 1)) {
                                int i2;
                                e cfP = e.cfP();
                                ab.i("MicroMsg.RemittanceBusiDialogMgr", "finishRemittanceF2fDynamicCodeUI()");
                                Context context = (Context) cfP.bSI.get();
                                if (context == null) {
                                    ab.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
                                } else if (context instanceof RemittanceF2fDynamicCodeUI) {
                                    ab.w("MicroMsg.RemittanceBusiDialogMgr", "check() is RemittanceF2fDynamicCodeUI");
                                    ((Activity) context).finish();
                                    i2 = 1;
                                    if (i2 != 0) {
                                        ab.w("MicroMsg.RemittanceBusiUI", "finish RemittanceF2fDynamicCodeUI");
                                    }
                                    RemittanceBusiUI.this.finish();
                                }
                                i2 = 0;
                                if (i2 != 0) {
                                }
                                RemittanceBusiUI.this.finish();
                            }
                            AppMethodBeat.o(44902);
                        }
                    };
                    ab.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert3() msg:%s, title:%s", bo.nullAsNil(iVar.pOT.kdU), bo.nullAsNil(""));
                    Context context = (Context) cfP.bSI.get();
                    if (context == null) {
                        ab.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
                    } else {
                        com.tencent.mm.ui.base.h.a(context, r2, r3, anonymousClass10);
                    }
                } else {
                    a(iVar);
                }
                if (iVar.pOT.vPE == 1) {
                    a(null, null, 0);
                }
            }
        } else if (mVar instanceof com.tencent.mm.plugin.remittance.model.h) {
            ab.i("MicroMsg.RemittanceBusiUI", "pay check callback");
            AppMethodBeat.o(44943);
            return true;
        } else if (mVar instanceof g) {
            ab.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", mVar, Integer.valueOf(i), Integer.valueOf(i2));
            g gVar = (g) mVar;
            if (!gVar.pOP.equals(this.pTP.pOP) || gVar.pOQ) {
                gVar.pOO = true;
                ab.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", Boolean.valueOf(gVar.pOQ));
                AppMethodBeat.o(44943);
                return true;
            }
            com.tencent.mm.plugin.remittance.model.d dVar;
            if (i != 0 || i2 != 0) {
                this.pTJ.cft();
                if (!(this.pSH == null || bo.isNullOrNil(this.pSH.pOz))) {
                    this.pTe.setText(this.pSH.pOz);
                }
                this.pTe.setTextColor(-7829368);
                this.pTe.setText(getString(R.string.dnq));
                dVar = gVar.pON;
                if (dVar != null) {
                    dVar.a(i, i2, gVar);
                }
            } else if (gVar.pOL.kdT == 0) {
                this.pTJ.pQH = gVar.pOL.pOE;
                this.pTJ.VR(gVar.pOL.pOE.vPi);
                cfS();
                com.tencent.mm.plugin.remittance.model.c cVar = gVar.pOM;
                ab.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", cVar);
                if (cVar != null) {
                    cVar.cR(this.pTJ.cfu());
                }
            } else {
                this.pTJ.cft();
                this.pTe.setTextColor(-7829368);
                this.pTe.setText(gVar.pOL.kdU);
                dVar = gVar.pON;
                if (dVar != null) {
                    dVar.a(i, i2, gVar);
                }
            }
            gVar.pOO = true;
            AppMethodBeat.o(44943);
            return true;
        } else if (mVar instanceof l) {
            l lVar = (l) mVar;
            ab.i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", Boolean.valueOf(lVar.pOZ));
            if (i != 0 || i2 != 0) {
                e.cfP().a(getString(R.string.fu2), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (lVar.pOY.kdT == 0) {
                cfU();
            } else {
                cfT();
                e.cfP().a(lVar.pOY.kdU, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
        AppMethodBeat.o(44943);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(44944);
        ab.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
        if (i == 3) {
            if (i2 != -1) {
                z = false;
            }
            a(z, intent);
        } else if (i == 1) {
            if (i2 != -1) {
                z = false;
            }
            a(z, intent);
        } else if (i == 2) {
            if (i2 == -1) {
                this.pTD = intent.getStringExtra("INTENT_RESULT_TOKEN");
                this.pTN = 0.0d;
                ab.i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", r2);
                p(false, intent.getStringExtra("INTENT_REQKEY"));
            } else {
                cfT();
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(44944);
    }

    private void a(boolean z, Intent intent) {
        AppMethodBeat.i(44945);
        if (z) {
            String stringExtra = intent.getStringExtra("key_trans_id");
            double doubleExtra = intent.getDoubleExtra("key_total_fee", -1.0d);
            String stringExtra2 = intent.getStringExtra("key_reqKey");
            ab.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", stringExtra, Double.valueOf(doubleExtra));
            if (bo.isNullOrNil(this.oXY)) {
                this.oXY = stringExtra;
            }
            if (doubleExtra >= 0.0d) {
                this.pTN = doubleExtra;
            }
            if (this.pRH) {
                h.pYm.e(15386, Integer.valueOf(3), Integer.valueOf(2));
            }
            cfU();
            VU(stringExtra2);
        } else if (com.tencent.mm.plugin.wallet_core.utils.c.aw(intent)) {
            finish();
            AppMethodBeat.o(44945);
            return;
        } else if (com.tencent.mm.plugin.wallet_core.utils.c.ax(intent)) {
            AppMethodBeat.o(44945);
            return;
        } else {
            ab.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
            cfT();
        }
        c(z, intent);
        AppMethodBeat.o(44945);
    }

    private void c(boolean z, Intent intent) {
        AppMethodBeat.i(44946);
        this.pTW = false;
        if (z) {
            ab.i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
            this.cKs = 1;
        } else if (intent == null) {
            AppMethodBeat.o(44946);
            return;
        } else {
            this.cKs = intent.getIntExtra("key_pay_reslut_type", 3);
            this.pTX = this.pTp;
            this.pTY = this.pSz;
            this.pTZ = this.pSy;
        }
        ab.i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", Double.valueOf(this.pTX), Double.valueOf(this.pTX), this.pTY, this.pTZ);
        AppMethodBeat.o(44946);
    }

    private void p(boolean z, String str) {
        AppMethodBeat.i(44947);
        ab.i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", Boolean.valueOf(z));
        cz czVar = (cz) this.pTS.get(str);
        if (czVar == null) {
            AppMethodBeat.o(44947);
            return;
        }
        int i;
        chl chl = this.pTC;
        String str2 = this.pTB;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        m lVar = new l(chl, czVar, str2, i, this.pTD, str);
        if (z) {
            lVar.pOZ = true;
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(lVar, 0);
            AppMethodBeat.o(44947);
            return;
        }
        this.pTH = 0;
        a(lVar, true, false);
        AppMethodBeat.o(44947);
    }

    private void cfT() {
        AppMethodBeat.i(44948);
        ab.i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
        abv abv = this.pTJ.pQG;
        if (abv == null) {
            ab.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
            AppMethodBeat.o(44948);
            return;
        }
        int round = (int) Math.round(this.pTp * 100.0d);
        cz czVar = new cz();
        czVar.cIb = this.obL;
        czVar.vFb = this.pSy;
        czVar.vFc = this.oXY;
        czVar.pOA = this.pSH.pOA;
        czVar.scene = this.pQY;
        czVar.vFd = this.pSD;
        czVar.vFe = abv;
        czVar.vFf = this.pTq;
        czVar.pPZ = this.pRC;
        czVar.vFg = round;
        a(new k(czVar, this.pTK), false, false);
        AppMethodBeat.o(44948);
    }

    public final int getLayoutId() {
        return R.layout.aoe;
    }

    private void a(int i, lp lpVar, boolean z, fw fwVar, String str, String str2) {
        String str3;
        AppMethodBeat.i(44949);
        int i2 = 0;
        if (!this.pTW) {
            boolean C = bo.C(Double.valueOf(this.pTX), Double.valueOf(this.pTp));
            boolean isEqual = bo.isEqual(this.pTY, this.pSz);
            if (!C) {
                i2 = 1;
            }
            if (!isEqual) {
                i2 |= 2;
            }
        }
        String str4 = this.pRC;
        String str5 = this.pTo;
        int i3 = this.pQY;
        String str6 = this.pTt;
        String str7 = this.pSz;
        int i4 = this.obL;
        String str8 = this.pTu;
        String str9 = this.pTy;
        int i5 = this.pTA;
        int i6 = this.pTz;
        String str10 = this.pTq;
        abv abv = this.pTJ.pQG;
        if (lpVar == null) {
            str3 = "";
        } else {
            str3 = lpVar.vPj;
        }
        m iVar = new com.tencent.mm.plugin.remittance.model.i(str4, str5, i3, str6, str7, i, i4, str8, str9, i5, i6, str10, abv, str3, this.pSH.pOA, str, this.pQW, str2, this.pTr, this.pTZ, this.cKs, i2);
        if (z) {
            int i7;
            iVar.pOV = fwVar;
            lu luVar = (lu) iVar.gme.fsG.fsP;
            if (fwVar.czT.czW == 1) {
                i7 = 1;
            } else {
                i7 = 0;
            }
            luVar.vPw = i7;
        }
        a(iVar, true, false);
        AppMethodBeat.o(44949);
    }

    private void cfU() {
        AppMethodBeat.i(44950);
        ab.i("MicroMsg.RemittanceBusiUI", "goto busi result");
        Intent intent = new Intent(this, RemittanceBusiResultUI.class);
        intent.putExtra("key_pay_desc", this.pSz);
        intent.putExtra("key_rcv_desc", this.pTt);
        if (this.pSH != null) {
            intent.putExtra("BusiRemittanceResp", this.pSH);
        }
        intent.putExtra("key_mch_name", this.pQW);
        intent.putExtra("key_rcver_name", this.pTq);
        intent.putExtra("key_rcver_true_name", this.pTr);
        if (this.pTN >= 0.0d) {
            intent.putExtra("key_money", this.pTN);
        } else {
            intent.putExtra("key_money", this.pTp);
        }
        intent.putExtra("key_f2f_id", this.pSy);
        intent.putExtra("key_trans_id", this.oXY);
        intent.putExtra("key_check_sign", this.pSD);
        intent.putExtra("key_rcvr_open_id", this.pRC);
        intent.putExtra("key_channel", this.obL);
        if (this.pSH != null) {
            intent.putExtra("key_succ_show_avatar_type", this.pSH.pOG);
            intent.putExtra("key_succ_show_avatar_show", this.pSH.pOx);
            intent.putExtra("key_succ_show_avatar_url", this.pSH.pOy);
        }
        if (this.pSH != null) {
            intent.putExtra("key_scan_sceen", this.pSH.pOA);
        }
        intent.putExtra("key_succ_page_extend", this.pTL);
        abv abv = this.pTJ.pQG;
        int round = (int) Math.round(this.pTp * 100.0d);
        cz czVar = new cz();
        czVar.cIb = this.obL;
        czVar.vFb = this.pSy;
        czVar.vFc = this.oXY;
        czVar.pOA = this.pSH.pOA;
        czVar.scene = this.pQY;
        czVar.vFd = this.pSD;
        czVar.vFe = abv;
        czVar.vFf = this.pTq;
        czVar.pPZ = this.pRC;
        czVar.vFg = round;
        try {
            intent.putExtra("AfterPlaceOrderCommReq", czVar.toByteArray());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.RemittanceBusiUI", e, "", new Object[0]);
        }
        startActivity(intent);
        finish();
        AppMethodBeat.o(44950);
    }

    private boolean a(com.tencent.mm.plugin.remittance.model.i iVar) {
        AppMethodBeat.i(44951);
        boolean z = false;
        if (!this.pRM) {
            z = b(iVar);
        }
        if (!z) {
            z = c(iVar);
        }
        AppMethodBeat.o(44951);
        return z;
    }

    private boolean b(final com.tencent.mm.plugin.remittance.model.i iVar) {
        AppMethodBeat.i(44952);
        if (bo.isNullOrNil(iVar.pOT.vPA)) {
            AppMethodBeat.o(44952);
            return false;
        }
        this.pRM = true;
        aY(1, iVar.pOT.vFb);
        e.cfP().a(iVar.pOT.vPA, getString(R.string.t6), getString(R.string.dnm), getString(R.string.or), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(44906);
                RemittanceBusiUI.a(RemittanceBusiUI.this, 3, iVar.pOT.vFb);
                if (RemittanceBusiUI.a(RemittanceBusiUI.this, iVar)) {
                    RemittanceBusiUI.E(RemittanceBusiUI.this);
                    AppMethodBeat.o(44906);
                    return;
                }
                RemittanceBusiUI.b(RemittanceBusiUI.this, iVar);
                AppMethodBeat.o(44906);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(44907);
                RemittanceBusiUI.E(RemittanceBusiUI.this);
                RemittanceBusiUI.a(RemittanceBusiUI.this, 2, iVar.pOT.vFb);
                AppMethodBeat.o(44907);
            }
        });
        AppMethodBeat.o(44952);
        return true;
    }

    private void aY(int i, String str) {
        AppMethodBeat.i(138551);
        this.pRJ = new bh();
        this.pRJ.cVR = 1;
        this.pRJ.cVS = (long) i;
        this.pRJ.gd(str);
        this.pRJ.ajK();
        AppMethodBeat.o(138551);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(44954);
        ab.v("MicroMsg.RemittanceBusiUI", "onNewIntent");
        AppMethodBeat.o(44954);
    }

    private boolean c(final com.tencent.mm.plugin.remittance.model.i iVar) {
        AppMethodBeat.i(44955);
        if (iVar.pOT.vPB != null) {
            this.pRP = true;
            e.cfP().a(iVar.pOT.kdU, "", iVar.pOT.vPB.nZc, iVar.pOT.vPB.nZb, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(44908);
                    ab.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", iVar.pOT.vPB.kCs);
                    e.n(RemittanceBusiUI.this.mController.ylL, iVar.pOT.vPB.kCs, false);
                    AppMethodBeat.o(44908);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(44955);
            return true;
        }
        AppMethodBeat.o(44955);
        return false;
    }

    private void d(com.tencent.mm.plugin.remittance.model.i iVar) {
        AppMethodBeat.i(44956);
        ab.i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", Integer.valueOf(iVar.pOT.vPF));
        int round = (int) Math.round(this.pTp * 100.0d);
        cz czVar = new cz();
        czVar.cIb = this.obL;
        czVar.vFb = this.pSy;
        czVar.vFc = this.oXY;
        czVar.pOA = this.pSH.pOA;
        czVar.scene = this.pQY;
        czVar.vFd = this.pSD;
        czVar.vFe = this.pTJ.pQG;
        czVar.vFf = this.pTq;
        czVar.pPZ = this.pRC;
        czVar.vFg = round;
        this.pTS.put(iVar.pOT.cBT, czVar);
        if (iVar.pOT.vPF == 1) {
            a(iVar.pOT);
            AppMethodBeat.o(44956);
            return;
        }
        PayInfo payInfo = new PayInfo();
        payInfo.czZ = iVar.pOT.cBT;
        payInfo.cIf = this.pQY;
        if (this.obL > 0) {
            payInfo.cIb = this.obL;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", this.pTq);
        bundle.putString("extinfo_key_2", this.pTr);
        bundle.putString("extinfo_key_3", this.pTt);
        bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
        bundle.putString("extinfo_key_7", this.pSz);
        bundle.putString("extinfo_key_19", iVar.pOT.pPJ);
        payInfo.vwh = bundle;
        payInfo.pPV = 1;
        Intent intent = new Intent();
        if (iVar.pOT.pPG == 1) {
            bundle.putInt("extinfo_key_15", iVar.pOT.vPO);
            bundle.putString("extinfo_key_17", iVar.pOT.pPH);
            bundle.putString("extinfo_key_18", iVar.pOT.pPI);
            intent.putExtra("key_pay_info", payInfo);
            intent.putExtra("from_patch_ui", true);
            intent.putExtra("key_rcvr_open_id", this.pRC);
            intent.putExtra("key_mch_info", this.pTw);
            intent.putExtra("key_mch_photo", this.pSH.pOy);
            intent.putExtra("key_transfer_qrcode_id", this.pTo);
            intent.putExtra("get_dynamic_code_sign", iVar.pOT.pPH);
            intent.putExtra("get_dynamic_code_extend", iVar.pOT.pPI);
            intent.putExtra("dynamic_code_spam_wording", iVar.pOT.pPK);
            intent.putExtra("dynamic_code_amount", iVar.pOT.vPO);
            intent.putExtra("show_paying_wording", iVar.pOT.pPJ);
            intent.putExtra("show_avatar_type", this.pSH.pOG == 1);
            h.pYm.e(15386, Integer.valueOf(2), Integer.valueOf(2));
            this.pRR.dnU();
            this.pUa.dnU();
            this.pUb.dnU();
            com.tencent.mm.bp.d.b((Context) this, "remittance", ".ui.RemittanceF2fDynamicCodeUI", intent, 3);
            AppMethodBeat.o(44956);
            return;
        }
        if (bo.isNullOrNil(iVar.pOU)) {
            this.pRH = false;
        } else {
            this.pRH = true;
        }
        payInfo.vwp = this.cEW;
        payInfo.aPn = this.pRH;
        if (iVar.pOV == null || iVar.pOV.czT.czX == null) {
            com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", payInfo, this.pTr, intent, 1);
            AppMethodBeat.o(44956);
            return;
        }
        com.tencent.mm.pluginsdk.wallet.h.a(iVar.pOV.czT.czX, false, "", payInfo, this.pTr, intent, iVar.pOV.czT.czV);
        AppMethodBeat.o(44956);
    }

    private void a(lv lvVar) {
        AppMethodBeat.i(44957);
        ab.i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", Integer.valueOf(lvVar.vPG));
        if (lvVar.vPG == 1) {
            Bundle bundle = new Bundle();
            com.tencent.mm.sdk.b.a.xxA.c(this.pUc);
            bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
            bundle.putString("realname_verify_process_jump_plugin", "remittance");
            bundle.putInt("real_name_verify_mode", 0);
            bundle.putInt("entry_scene", this.pQY);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
            AppMethodBeat.o(44957);
            return;
        }
        String str;
        Intent intent = new Intent();
        String str2 = "";
        if (bo.isNullOrNil(this.pTI)) {
            String string = getString(R.string.fq3);
            if (bo.isNullOrNil(this.pTq)) {
                ab.e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                str = str2;
            } else {
                com.tencent.mm.kernel.g.RQ();
                ad aoM = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(this.pTq);
                if (aoM != null) {
                    Object[] objArr = new Object[1];
                    objArr[0] = e.atA(aoM.Oj()) + (bo.isNullOrNil(this.pTr) ? "" : "(" + this.pTr + ")");
                    str = bo.t(string, objArr);
                } else {
                    ab.e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.pTq);
                    str = str2;
                }
            }
        } else {
            str = this.pTI;
        }
        intent.putExtra("INTENT_TITLE", str);
        intent.putExtra("INTENT_CAN_TOUCH", this.pTE);
        intent.putExtra("INTENT_PAYFEE", e.F(0.0d));
        intent.putExtra("INTENT_REQKEY", lvVar.cBT);
        try {
            intent.putExtra("INTENT_TOKENMESS", lvVar.vPH.toByteArray());
            com.tencent.mm.bp.d.b(this.mController.ylL, "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", intent, 2);
            AppMethodBeat.o(44957);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.RemittanceBusiUI", e, "", new Object[0]);
            AppMethodBeat.o(44957);
        }
    }

    private void VU(String str) {
        AppMethodBeat.i(44958);
        ab.i("MicroMsg.RemittanceBusiUI", "do pay check: %s", str);
        cz czVar = (cz) this.pTS.get(str);
        if (czVar == null) {
            AppMethodBeat.o(44958);
            return;
        }
        if (!bo.isNullOrNil(this.oXY)) {
            czVar.vFc = this.oXY;
        }
        a(new com.tencent.mm.plugin.remittance.model.h(czVar, this.pTK), false, false);
        AppMethodBeat.o(44958);
    }

    private void cbv() {
        AppMethodBeat.i(44959);
        this.pTp = cfR();
        if (this.pTp <= 0.0d) {
            findViewById(R.id.dzs).setClickable(false);
            findViewById(R.id.dzs).setEnabled(false);
            findViewById(R.id.dzs).setOnClickListener(null);
            this.pTi.setClickable(false);
            this.pTi.setEnabled(false);
            this.pTe.setTextColor(getResources().getColor(R.color.w0));
            AppMethodBeat.o(44959);
            return;
        }
        this.pTe.setTextColor(-7829368);
        findViewById(R.id.dzs).setEnabled(true);
        findViewById(R.id.dzs).setClickable(true);
        this.pTi.setClickable(true);
        this.pTi.setEnabled(true);
        findViewById(R.id.dzs).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44918);
                h.pYm.e(15235, Integer.valueOf(3));
                RemittanceBusiUI.z(RemittanceBusiUI.this);
                AppMethodBeat.o(44918);
            }
        });
        AppMethodBeat.o(44959);
    }

    static /* synthetic */ void e(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(44960);
        ab.i("MicroMsg.RemittanceBusiUI", "do cancel pay");
        remittanceBusiUI.a(new com.tencent.mm.plugin.remittance.model.t(remittanceBusiUI.pTq, remittanceBusiUI.pTo, remittanceBusiUI.pTu, remittanceBusiUI.pRC), false, false);
        AppMethodBeat.o(44960);
    }

    static /* synthetic */ void m(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(44965);
        if (bo.isNullOrNil(remittanceBusiUI.pSz)) {
            remittanceBusiUI.pTc.setText("");
            remittanceBusiUI.pTd.setText(R.string.dnl);
            AppMethodBeat.o(44965);
            return;
        }
        remittanceBusiUI.pTc.setText(remittanceBusiUI.getString(R.string.dny, new Object[]{remittanceBusiUI.pSz}));
        remittanceBusiUI.pTd.setText(R.string.dp6);
        AppMethodBeat.o(44965);
    }

    static /* synthetic */ void p(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(44967);
        ab.i("MicroMsg.RemittanceBusiUI", "do place order");
        if (remittanceBusiUI.pSH == null) {
            ab.e("MicroMsg.RemittanceBusiUI", "doPlaceOrder busi_resp is null");
            AppMethodBeat.o(44967);
            return;
        }
        if (!remittanceBusiUI.pTx) {
            remittanceBusiUI.aoB();
        }
        remittanceBusiUI.a((int) Math.round(remittanceBusiUI.pTp * 100.0d), remittanceBusiUI.pTJ.pQH, false, null, "", "");
        AppMethodBeat.o(44967);
    }

    static /* synthetic */ void z(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.i(44969);
        List list = null;
        if (remittanceBusiUI.pQY == 33) {
            if (remittanceBusiUI.pSH.pOE != null) {
                list = remittanceBusiUI.pSH.pOE.vPg;
            }
        } else if (remittanceBusiUI.pTJ.cfw()) {
            list = remittanceBusiUI.pTJ.cfu();
            if (list.size() == 0) {
                ab.i("MicroMsg.RemittanceBusiUI", "can not find favor %s", Integer.valueOf(list.size()));
                AppMethodBeat.o(44969);
                return;
            }
        } else {
            list = remittanceBusiUI.pSH.pOD;
        }
        remittanceBusiUI.pTp = remittanceBusiUI.cfR();
        if (((int) Math.round(remittanceBusiUI.pTp * 100.0d)) <= 0) {
            remittanceBusiUI.cS(list);
            AppMethodBeat.o(44969);
        } else if (!remittanceBusiUI.pTJ.cfw()) {
            remittanceBusiUI.a(new com.tencent.mm.plugin.remittance.model.c() {
                public final void cR(List<abw> list) {
                    AppMethodBeat.i(44896);
                    if (list.size() > 0) {
                        RemittanceBusiUI.a(RemittanceBusiUI.this, (List) list);
                    }
                    AppMethodBeat.o(44896);
                }
            }, new com.tencent.mm.plugin.remittance.model.d() {
                public final void a(int i, int i2, g gVar) {
                    AppMethodBeat.i(44897);
                    if (i != 0 || i2 != 0) {
                        t.makeText(RemittanceBusiUI.this.mController.ylL, RemittanceBusiUI.this.getString(R.string.fdx), 0).show();
                    } else if (gVar.pOL.kdT != 0) {
                        t.makeText(RemittanceBusiUI.this.mController.ylL, gVar.pOL.kdU, 0).show();
                        AppMethodBeat.o(44897);
                        return;
                    }
                    AppMethodBeat.o(44897);
                }
            }, 0);
            AppMethodBeat.o(44969);
        } else if (remittanceBusiUI.pTP == null) {
            remittanceBusiUI.cS(list);
            AppMethodBeat.o(44969);
        } else if (remittanceBusiUI.pTP.pOO) {
            remittanceBusiUI.cS(list);
            AppMethodBeat.o(44969);
        } else {
            remittanceBusiUI.pTP.pOM = new com.tencent.mm.plugin.remittance.model.c() {
                public final void cR(List<abw> list) {
                    AppMethodBeat.i(44895);
                    RemittanceBusiUI.a(RemittanceBusiUI.this, (List) list);
                    AppMethodBeat.o(44895);
                }
            };
            AppMethodBeat.o(44969);
        }
    }

    static /* synthetic */ void C(RemittanceBusiUI remittanceBusiUI) {
        boolean z = true;
        AppMethodBeat.i(44972);
        if (remittanceBusiUI.pSH == null) {
            ab.e("MicroMsg.RemittanceBusiUI", "busi_resp is null");
            if (remittanceBusiUI.pTP != null) {
                remittanceBusiUI.pTP.pOQ = true;
            }
            AppMethodBeat.o(44972);
            return;
        }
        remittanceBusiUI.pTp = remittanceBusiUI.cfR();
        ab.i("MicroMsg.RemittanceBusiUI", "update updateBilling %s", Integer.valueOf((int) Math.round(remittanceBusiUI.pTp * 100.0d)));
        if (((int) Math.round(remittanceBusiUI.pTp * 100.0d)) <= 0) {
            remittanceBusiUI.pTP.pOQ = true;
            remittanceBusiUI.pTJ.cft();
            remittanceBusiUI.pTe.setTextColor(-7829368);
            remittanceBusiUI.pTe.setText(remittanceBusiUI.pSH.pOz);
            if (remittanceBusiUI.pTP != null) {
                remittanceBusiUI.pTP.pOQ = true;
            }
            AppMethodBeat.o(44972);
            return;
        }
        remittanceBusiUI.pTe.setText(R.string.dnr);
        m mVar = remittanceBusiUI.pTP;
        if (remittanceBusiUI.pTP.pOM == null) {
            z = false;
        }
        remittanceBusiUI.a(mVar, z, false);
        AppMethodBeat.o(44972);
    }

    static /* synthetic */ boolean a(RemittanceBusiUI remittanceBusiUI, int i, int i2, l lVar) {
        long j = 0;
        AppMethodBeat.i(44973);
        if (remittanceBusiUI.pTF == 0) {
            AppMethodBeat.o(44973);
            return false;
        } else if (remittanceBusiUI.pTH >= remittanceBusiUI.pTF) {
            ab.i("MicroMsg.RemittanceBusiUI", "mZero_start_time %s >= mZero_try_time %s say bye bye", Integer.valueOf(remittanceBusiUI.pTH), Integer.valueOf(remittanceBusiUI.pTF));
            AppMethodBeat.o(44973);
            return false;
        } else {
            remittanceBusiUI.pTV.pUr = lVar;
            b bVar;
            if (i != 0 || i2 != 0) {
                remittanceBusiUI.pTH++;
                ab.i("MicroMsg.RemittanceBusiUI", "mZero_try_interval_ms  mZero_start_time %s mZero_try_interval_ms %s", Integer.valueOf(remittanceBusiUI.pTH), Integer.valueOf(remittanceBusiUI.pTG));
                al.af(remittanceBusiUI.pTV);
                bVar = remittanceBusiUI.pTV;
                if (remittanceBusiUI.pTG >= 0) {
                    j = (long) remittanceBusiUI.pTG;
                }
                al.n(bVar, j);
                AppMethodBeat.o(44973);
                return true;
            } else if (lVar.pOY.kdT == 0) {
                AppMethodBeat.o(44973);
                return false;
            } else if (lVar.pOY.kdT == 0 || !lVar.lSR) {
                AppMethodBeat.o(44973);
                return false;
            } else {
                remittanceBusiUI.pTH++;
                ab.i("MicroMsg.RemittanceBusiUI", "mZero_try_interval_ms  mZero_start_time %s mZero_try_interval_ms %s", Integer.valueOf(remittanceBusiUI.pTH), Integer.valueOf(remittanceBusiUI.pTG));
                al.af(remittanceBusiUI.pTV);
                bVar = remittanceBusiUI.pTV;
                if (remittanceBusiUI.pTG >= 0) {
                    j = (long) remittanceBusiUI.pTG;
                }
                al.n(bVar, j);
                AppMethodBeat.o(44973);
                return true;
            }
        }
    }
}
