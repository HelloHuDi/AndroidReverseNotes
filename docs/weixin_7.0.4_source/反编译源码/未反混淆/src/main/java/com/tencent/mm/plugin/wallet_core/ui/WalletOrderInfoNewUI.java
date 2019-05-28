package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.us;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.g.b.a.bg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import d.a.a.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoNewUI extends WalletOrderInfoUI {
    private String igi = null;
    private String mAppId = "";
    private String oXY;
    private c pSK;
    private WalletSuccPageAwardWidget pSL;
    private ViewGroup pSM;
    private ViewGroup pSN;
    private ViewGroup pSO;
    private TextView pSP;
    private boolean pSQ = false;
    private com.tencent.mm.sdk.b.c<uv> pSR = new com.tencent.mm.sdk.b.c<uv>() {
        {
            AppMethodBeat.i(47439);
            this.xxI = uv.class.getName().hashCode();
            AppMethodBeat.o(47439);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(47440);
            uv uvVar = (uv) bVar;
            ab.i("MicroMsg.WalletOrderInfoNewUI", "receive pay result event, do finish");
            if ((uvVar.cRF.cRG == 1000 || uvVar.cRF.cRG == 1001) && WalletOrderInfoNewUI.this.pVL != null && WalletOrderInfoNewUI.this.pVL.cIf == 46) {
                if (WalletOrderInfoNewUI.this.tEX != null) {
                    WalletOrderInfoNewUI.this.tEX.aF(WalletOrderInfoNewUI.this.mController.ylL);
                }
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(47438);
                        WalletOrderInfoNewUI.this.finish();
                        AppMethodBeat.o(47438);
                    }
                }, 100);
            }
            AppMethodBeat.o(47440);
            return false;
        }
    };
    private PayInfo pVL;
    private String pVl;
    private TextView pWB;
    private com.tencent.mm.sdk.b.c pap = new com.tencent.mm.sdk.b.c<us>() {
        {
            AppMethodBeat.i(47425);
            this.xxI = us.class.getName().hashCode();
            AppMethodBeat.o(47425);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(47426);
            us usVar = (us) bVar;
            if (usVar instanceof us) {
                if (!usVar.cRy.cRz.oZd) {
                    ab.i("MicroMsg.WalletOrderInfoNewUI", "block pass");
                    AppMethodBeat.o(47426);
                    return true;
                } else if ("1".equals(usVar.cRy.cRz.cRb) || "2".equals(usVar.cRy.cRz.cRb)) {
                    RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                    realnameGuideHelper.a(usVar.cRy.cRz.cRb, usVar.cRy.cRz.cRc, usVar.cRy.cRz.cRd, usVar.cRy.cRz.cRe, usVar.cRy.cRz.cRf, WalletOrderInfoNewUI.this.pVL == null ? 0 : WalletOrderInfoNewUI.this.pVL.cIf);
                    ab.i("MicroMsg.WalletOrderInfoNewUI", "receive guide");
                    WalletOrderInfoNewUI.this.mBundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            AppMethodBeat.o(47426);
            return false;
        }
    };
    private String pdC = null;
    private boolean tEC = false;
    private String tED;
    private String tEE;
    private b tEG;
    private HashMap<String, a> tEH = new HashMap();
    private String tEI;
    private String tEK = "-1";
    private Button tEL;
    private ImageView tEM;
    private ViewGroup tEN;
    private CdnImageView tEO;
    private TextView tEP;
    private TextView tEQ;
    private View tER;
    private Button tES;
    private ViewGroup tET;
    private boolean tEU = false;
    private boolean tEV = false;
    private boolean tEW = false;
    private com.tencent.mm.wallet_core.c tEX;
    protected Set<String> tIc = null;
    private List<Commodity> tId = null;
    private RecommendTinyAppInfo tIe;
    private String tIf;
    private Promotions tIg = null;
    private TextView tIh;
    private TextView tIi;
    private WalletTextView tIj;
    private ViewGroup tIk;
    private ViewGroup tIl;
    private ViewGroup tIm;
    private ViewGroup tIn;
    private ViewGroup tIo;
    private ViewGroup tIp;
    private TextView tIq;
    private CheckBox tIr;
    private ViewGroup tIs;
    private CdnImageView tIt;
    private TextView tIu;
    private TextView tIv;
    private Button tIw;
    private boolean tIx = false;
    private com.tencent.mm.sdk.b.c tIy = new com.tencent.mm.sdk.b.c<aq>() {
        {
            AppMethodBeat.i(47434);
            this.xxI = aq.class.getName().hashCode();
            AppMethodBeat.o(47434);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(47435);
            aq aqVar = (aq) bVar;
            String str = aqVar.ctH.ctJ;
            boolean z = aqVar.ctH.ctK;
            ab.i("MicroMsg.WalletOrderInfoNewUI", "ChangePayActivityViewEvent callback, mActivityBtnTitle: %s, isButtonEnable: %s, isButtonHidden: %s, isActivityViewHidden: %s", str, Boolean.valueOf(z), Boolean.valueOf(aqVar.ctH.ctL), Boolean.valueOf(aqVar.ctH.ctM));
            if (aqVar.ctH.ctM && !bo.isNullOrNil(WalletOrderInfoNewUI.this.tEI)) {
                WalletOrderInfoNewUI.this.tIs.setVisibility(8);
            }
            if (!bo.isNullOrNil(WalletOrderInfoNewUI.this.tEI)) {
                WalletOrderInfoNewUI.this.tIw.setClickable(z);
                WalletOrderInfoNewUI.this.tIw.setEnabled(z);
                WalletOrderInfoNewUI.this.tIw.setOnClickListener(null);
                if (r2) {
                    WalletOrderInfoNewUI.this.tIw.setVisibility(8);
                }
            }
            aqVar.ctI.csN = true;
            AppMethodBeat.o(47435);
            return false;
        }
    };
    private Orders tog;
    private int tzY;

    static class a {
        public String cEh;
        public String cIY;
        public String tID;
        public int tIE;
        public String title;
        public String ttf;
        public String ttg;
        public String tzU;
        public String tzV;
        public String tzW;
        public String tzX;
        public String url;

        public a(JSONObject jSONObject) {
            AppMethodBeat.i(47447);
            if (jSONObject == null) {
                AppMethodBeat.o(47447);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
            if (optJSONObject != null) {
                this.url = optJSONObject.optString("url");
                this.cEh = optJSONObject.optString("wording");
                this.cIY = optJSONObject.optString("icon");
                this.tID = optJSONObject.optString("btn_text");
                this.title = optJSONObject.optString("title");
                this.ttf = optJSONObject.optString("tinyapp_name");
                this.tzU = optJSONObject.optString("tinyapp_logo");
                this.tzV = optJSONObject.optString("tinyapp_desc");
                this.tzW = optJSONObject.optString("tinyapp_username");
                this.ttg = optJSONObject.optString("tinyapp_path");
                this.tzX = optJSONObject.optString("activity_tinyapp_btn_text");
            }
            AppMethodBeat.o(47447);
        }

        public a(bnu bnu) {
            AppMethodBeat.i(47448);
            if (!(bnu == null || bnu.wQV == null)) {
                bc bcVar = bnu.wQV;
                this.url = bcVar.url;
                this.cEh = bcVar.cEh;
                this.cIY = bcVar.cIY;
                this.tID = bcVar.tID;
                this.title = bcVar.title;
                this.tzW = bcVar.tzW;
                this.ttg = bcVar.ttg;
                this.tIE = bcVar.tIE;
                this.ttf = this.title;
                this.tzU = this.cIY;
                this.tzV = this.cEh;
                this.tzX = this.tID;
            }
            AppMethodBeat.o(47448);
        }

        public final String toString() {
            AppMethodBeat.i(47449);
            String str = this.url + " , " + this.cEh + " , " + this.cIY + " , " + this.tID + " , " + this.title;
            AppMethodBeat.o(47449);
            return str;
        }
    }

    static class b {
        public String cBT;
        public String pQe;
        public long tBC;
        public String tIF;
        public String tIG;
        public String tIH;
        public long tII;
        public String tIJ;
        public String tuv;

        public b(String str, String str2, String str3, String str4, String str5, String str6, long j, String str7) {
            this.tuv = str;
            this.tIF = str2;
            this.tIG = str3;
            this.tIH = str4;
            this.cBT = str5;
            this.pQe = str6;
            this.tBC = j;
            this.tIJ = str7;
        }

        public b(String str, String str2, String str3, String str4, String str5, String str6, long j, long j2) {
            this.tuv = str;
            this.tIF = str2;
            this.tIG = str3;
            this.tIH = str4;
            this.cBT = str5;
            this.pQe = str6;
            this.tBC = j;
            this.tII = j2;
            this.tIJ = null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOrderInfoNewUI() {
        AppMethodBeat.i(47450);
        AppMethodBeat.o(47450);
    }

    public void finish() {
        AppMethodBeat.i(47451);
        ab.i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", this, bo.dpG());
        if (this.pSQ) {
            AppMethodBeat.o(47451);
            return;
        }
        super.finish();
        this.pSQ = true;
        AppMethodBeat.o(47451);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47452);
        super.onCreate(bundle);
        if (d.iW(21)) {
            if (d.iW(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        AM(4);
        this.tIc = new HashSet();
        com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(this);
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.oXY = this.mBundle.getString("key_trans_id");
        this.mBundle.getInt("key_pay_type", -1);
        ab.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", this.oXY);
        this.tog = cRD();
        if (this.tog != null) {
            AM(0);
            c(this.tog);
            if (!(aE == null || this.tog == null || this.pVL == null)) {
                int i;
                this.mAppId = this.pVL.appId;
                boolean dNG = aE.dNG();
                com.tencent.mm.plugin.wallet_core.utils.d.a(this, this.mBundle, 7);
                int i2 = this.mBundle.getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                h hVar = h.pYm;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.pVL.cIf);
                objArr[1] = Boolean.valueOf(this.pVL.cIf == 3);
                if (dNG) {
                    i = 1;
                } else {
                    i = 2;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(z.dNX());
                objArr[4] = Integer.valueOf((int) (this.tog.pTN * 100.0d));
                objArr[5] = this.tog.pcl;
                objArr[6] = Integer.valueOf(i2);
                hVar.e(10691, objArr);
            }
            if (!((r.cPI().cQg() || aE == null || !aE.dNG()) && com.tencent.mm.model.r.YI())) {
                com.tencent.mm.model.r.YJ();
            }
            if (this.tog == null || this.tog.tAq == null || this.tog.tAq.size() <= 0) {
                ab.c("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.fkw, 0, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(47444);
                        WalletOrderInfoNewUI.this.done();
                        AppMethodBeat.o(47444);
                    }
                });
            } else {
                this.tId = this.tog.tAq;
                ab.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", Integer.valueOf(this.tId.size()));
                this.oXY = ((Commodity) this.tId.get(0)).cAa;
                this.pVl = ((Commodity) this.tId.get(0)).cAa;
                if (!(this.pVL == null || aE == null || (!aE.dNF() && !aE.dNG()))) {
                    a(new y(cNH(), 21), true, true);
                }
            }
            ((i) g.K(i.class)).g(this);
        } else {
            ab.c("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
            com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.fkw, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(47445);
                    WalletOrderInfoNewUI.this.finish();
                    AppMethodBeat.o(47445);
                }
            });
        }
        initView();
        this.tEX = dOD();
        cRo();
        if (this.pVL != null && this.pVL.cIf == 46) {
            ab.i("MicroMsg.WalletOrderInfoNewUI", "early send result");
            uv uvVar = new uv();
            Intent intent = new Intent();
            intent.putExtras(this.mBundle);
            if (this.tog != null) {
                intent.putExtra("key_total_fee", this.tog.pTN);
            }
            if (this.tEX != null) {
                intent.putExtra("key_is_clear_failure", this.tEX.mqu.getInt("key_is_clear_failure", -1));
            }
            uvVar.cRF.intent = intent;
            uvVar.cRF.cRH = 1;
            uvVar.cRF.czZ = cNH();
            uvVar.cRF.result = intent.getBooleanExtra("intent_pay_end", false) ? -1 : 0;
            com.tencent.mm.sdk.b.a.xxA.m(uvVar);
        }
        if (this.tog == null || this.tog.tAO == null || this.tog.tAO.tBL != 1) {
            nf(1979);
            nf(2948);
            nf(2710);
            com.tencent.mm.sdk.b.a.xxA.c(this.tIy);
            com.tencent.mm.sdk.b.a.xxA.c(this.pap);
            this.pSR.dnU();
            this.tEW = true;
            ad.e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 16, "");
            AppMethodBeat.o(47452);
            return;
        }
        ab.i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
        cRH();
        AppMethodBeat.o(47452);
    }

    public void onResume() {
        AppMethodBeat.i(47453);
        super.onResume();
        ab.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", Boolean.valueOf(this.tEW), this.tIg, Boolean.valueOf(this.tEU), Boolean.valueOf(this.tEV), this.tIe, this.pSK);
        if (WalletSuccPageAwardWidget.a(this.pSK)) {
            this.pSL.onResume();
            AppMethodBeat.o(47453);
        } else if (this.tEW) {
            this.tEW = false;
            AppMethodBeat.o(47453);
        } else if (this.tIg == null || !this.tEV) {
            if (this.tEU && this.tIe != null) {
                a(new aa(this.tIe.tBx, this.tIe.tBz, this.tIe.tBA, this.tIe.tBB, cNH(), this.pVl, this.tIe.tBC), true, true);
            }
            AppMethodBeat.o(47453);
        } else {
            ab.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", Boolean.valueOf(bo.isNullOrNil(this.tIg.uZT)), this.tIg.uZT, Boolean.valueOf(this.tIx));
            if (this.tIx) {
                AppMethodBeat.o(47453);
                return;
            }
            this.tIx = true;
            if (bo.isNullOrNil(this.tIg.uZT)) {
                a(new aa(this.tIg.ttW, this.tIg.uZN, this.tIg.tzP, this.tIg.tzQ, cNH(), this.pVl, this.tIg.tzR), true, true);
                AppMethodBeat.o(47453);
                return;
            }
            a(new k(this.tIg.uZT, this.tIg.ttW), true, true);
            AppMethodBeat.o(47453);
        }
    }

    public final void initView() {
        Commodity commodity;
        Commodity commodity2;
        AppMethodBeat.i(47454);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.tEM = (ImageView) findViewById(R.id.f8k);
        this.pWB = (TextView) findViewById(R.id.f8l);
        this.tIh = (TextView) findViewById(R.id.fea);
        this.tIi = (TextView) findViewById(R.id.fec);
        this.tIj = (WalletTextView) findViewById(R.id.fed);
        this.pSP = (TextView) findViewById(R.id.dz6);
        this.tEL = (Button) findViewById(R.id.f8o);
        showHomeBtn(false);
        enableBackMenu(false);
        CharSequence string = getString(R.string.qt);
        if (this.pVL == null || this.pVL.cIf != 2) {
            if (!(this.tog == null || bo.isNullOrNil(this.tog.tAB))) {
                string = this.tog.tAB;
            }
        } else if (this.tog != null && !bo.isNullOrNil(this.tog.tAB)) {
            string = this.tog.tAB;
        } else if (!bo.isNullOrNil(this.pVL.tRb)) {
            string = getString(R.string.g1) + this.pVL.tRb;
        } else if (!(bo.isNullOrNil(this.pVL.appId) || bo.isNullOrNil(com.tencent.mm.pluginsdk.model.app.g.t(this, this.pVL.appId)))) {
            string = getString(R.string.g1) + com.tencent.mm.pluginsdk.model.app.g.t(this, this.pVL.appId);
        }
        this.tEL.setText(string);
        this.tEL.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47441);
                WalletOrderInfoNewUI.this.done();
                AppMethodBeat.o(47441);
            }
        });
        this.tIk = (ViewGroup) findViewById(R.id.fee);
        this.pSN = (ViewGroup) findViewById(R.id.dyx);
        this.tET = (ViewGroup) findViewById(R.id.f8n);
        this.pSM = (ViewGroup) findViewById(R.id.dyw);
        this.pSO = (ViewGroup) findViewById(R.id.dz5);
        this.tIl = (ViewGroup) findViewById(R.id.feg);
        this.tIm = (ViewGroup) findViewById(R.id.fei);
        this.tIo = (ViewGroup) findViewById(R.id.fef);
        this.tIn = (ViewGroup) findViewById(R.id.fek);
        this.tEN = (ViewGroup) findViewById(R.id.e2i);
        this.tEO = (CdnImageView) findViewById(R.id.e2j);
        this.tEO.setUseSdcardCache(true);
        this.tEP = (TextView) findViewById(R.id.e2l);
        this.tEQ = (TextView) findViewById(R.id.e2k);
        this.tES = (Button) findViewById(R.id.e2m);
        this.tER = findViewById(R.id.dzd);
        this.tIp = (ViewGroup) findViewById(R.id.fen);
        this.tIq = (TextView) findViewById(R.id.fep);
        this.tIr = (CheckBox) findViewById(R.id.feo);
        this.tIs = (ViewGroup) findViewById(R.id.feq);
        this.tIt = (CdnImageView) findViewById(R.id.fer);
        this.tIt.setUseSdcardCache(true);
        this.tIv = (TextView) findViewById(R.id.fet);
        this.tIu = (TextView) findViewById(R.id.fes);
        this.tIw = (Button) findViewById(R.id.feu);
        this.tET.setVisibility(4);
        this.pSL = (WalletSuccPageAwardWidget) findViewById(R.id.dze);
        cRo();
        if (!(this.tog == null || this.tId == null || this.tId.size() <= 0)) {
            commodity = (Commodity) this.tId.get(0);
            this.tIh.setText(commodity.pca);
            this.tIi.setText(e.atq(commodity.pcl));
            this.tIj.setText(String.format("%.2f", new Object[]{Double.valueOf(commodity.kCJ)}));
        }
        String str = "MicroMsg.WalletOrderInfoNewUI";
        String str2 = "is_use_show_info: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.tog == null ? 0 : this.tog.tAC);
        ab.i(str, str2, objArr);
        if (this.tog == null || this.tog.tAC != 1) {
            cRE();
            if (!(this.tog == null || this.tId == null || this.tId.size() <= 0)) {
                commodity = (Commodity) this.tId.get(0);
                if (commodity.tAZ != null) {
                    TextView textView = (TextView) this.tIn.findViewById(R.id.fem);
                    ((TextView) this.tIn.findViewById(R.id.fel)).setText(commodity.tAZ.tBD);
                    textView.setText(commodity.tAZ.tBE);
                    this.tIn.setVisibility(0);
                    this.tIk.setVisibility(0);
                }
            }
            this.tIm.setVisibility(8);
            this.tIl.setVisibility(8);
            if (!(this.tog == null || this.tId == null || this.tId.size() <= 0)) {
                commodity = (Commodity) this.tId.get(0);
                if (!bo.isNullOrNil(commodity.tAX)) {
                    ((TextView) findViewById(R.id.feh)).setText(commodity.tAX);
                    this.tIl.setVisibility(0);
                    this.tIk.setVisibility(0);
                }
                if (!bo.isNullOrNil(commodity.tAV)) {
                    ((TextView) findViewById(R.id.fej)).setText(commodity.tAV);
                    this.tIm.setVisibility(0);
                    this.tIk.setVisibility(0);
                }
            }
        } else {
            this.tIl.setVisibility(8);
            this.tIm.setVisibility(8);
            this.pSO.setVisibility(8);
            this.pSM.setVisibility(8);
            this.tIn.setVisibility(8);
            cRG();
        }
        cRF();
        if (this.tId == null || this.tId.size() <= 0) {
            commodity2 = null;
        } else {
            commodity = (Commodity) this.tId.get(0);
            if (!(commodity == null || commodity.tBa == null || commodity.tBa.size() <= 0)) {
                for (Promotions promotions : commodity.tBa) {
                    if (promotions.tBw != null && promotions.uZM == 5) {
                        this.pSK = promotions.tBw;
                        ab.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", this.pSK, Integer.valueOf(promotions.uZM));
                        commodity2 = commodity;
                        break;
                    }
                }
            }
            commodity2 = commodity;
        }
        if (WalletSuccPageAwardWidget.a(this.pSK)) {
            if (commodity2 != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.pSL.getLayoutParams();
                List list = commodity2.tAU;
                if ((commodity2.tAR < 0.0d || commodity2.kCJ >= commodity2.tAR) && (list == null || list.size() <= 0)) {
                    marginLayoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(this, 50);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
                this.pSL.setLayoutParams(marginLayoutParams);
            }
            this.pSL.a(this, this.pSK, this.oXY, false, (ImageView) findViewById(R.id.btd));
            this.pSL.init();
            this.pSL.setVisibility(0);
            final ImageView imageView = (ImageView) findViewById(R.id.btd);
            imageView.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(47442);
                    ViewGroup viewGroup = (ViewGroup) WalletOrderInfoNewUI.this.findViewById(R.id.d3v);
                    LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = viewGroup.getWidth();
                    layoutParams.height = viewGroup.getHeight();
                    imageView.setLayoutParams(layoutParams);
                    AppMethodBeat.o(47442);
                }
            });
        } else {
            nk(true);
            this.pSL.setVisibility(8);
        }
        cRn();
        AppMethodBeat.o(47454);
    }

    private void cRn() {
        int i;
        AppMethodBeat.i(47455);
        int i2 = 0;
        if (this.tEN.getVisibility() == 0) {
            i2 = 1;
        }
        if (this.tIk.getVisibility() == 0) {
            i2++;
        }
        if (this.tIp.getVisibility() == 0) {
            i2++;
        }
        if (this.tIs.getVisibility() == 0) {
            i = i2 + 1;
        } else {
            i = i2;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.tEM.getLayoutParams();
        MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) this.tIh.getLayoutParams();
        if (i >= 3) {
            i = com.tencent.mm.bz.a.fromDPToPix(this, 40);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        } else {
            i = com.tencent.mm.bz.a.fromDPToPix(this, 70);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        }
        this.tEM.setLayoutParams(marginLayoutParams);
        this.tIh.setLayoutParams(marginLayoutParams2);
        this.tET.post(new Runnable() {
            public final void run() {
                int i;
                int i2;
                AppMethodBeat.i(47443);
                int height = WalletOrderInfoNewUI.this.tET.getHeight();
                int height2 = WalletOrderInfoNewUI.this.findViewById(R.id.d3v).getHeight();
                int i3 = WalletOrderInfoNewUI.this.tEN.getVisibility() == 0 ? 1 : 0;
                if (WalletOrderInfoNewUI.this.tIk.getVisibility() == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (WalletOrderInfoNewUI.this.pSL.getVisibility() == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i != 0) {
                    i = WalletOrderInfoNewUI.this.tIk.getBottom();
                } else {
                    i = -1;
                }
                if (i3 != 0) {
                    i3 = WalletOrderInfoNewUI.this.tEN.getBottom();
                } else {
                    i3 = i;
                }
                if (i2 != 0) {
                    i3 = WalletOrderInfoNewUI.this.pSL.getBottom();
                }
                if (i3 <= 0) {
                    i3 = WalletOrderInfoNewUI.this.findViewById(R.id.f8j).getBottom();
                }
                if (WalletOrderInfoNewUI.this.tIp.getVisibility() == 0 || WalletOrderInfoNewUI.this.tIs.getVisibility() == 0) {
                    i = height;
                } else {
                    i = com.tencent.mm.bz.a.fromDPToPix(WalletOrderInfoNewUI.this, 70) + height;
                }
                height = (height2 - i3) - i;
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(WalletOrderInfoNewUI.this, 50);
                ab.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(height2), Integer.valueOf(height), Integer.valueOf(fromDPToPix));
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) WalletOrderInfoNewUI.this.tET.getLayoutParams();
                if (height > fromDPToPix) {
                    marginLayoutParams.topMargin = height;
                } else {
                    marginLayoutParams.topMargin = fromDPToPix;
                }
                WalletOrderInfoNewUI.this.tET.setLayoutParams(marginLayoutParams);
                WalletOrderInfoNewUI.this.tET.setVisibility(0);
                AppMethodBeat.o(47443);
            }
        });
        AppMethodBeat.o(47455);
    }

    private void cRo() {
        AppMethodBeat.i(47456);
        if (!(this.tog == null || this.tId == null || this.tId.size() <= 0)) {
            int i;
            for (Commodity commodity : this.tId) {
                if ("1".equals(commodity.pce)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.pWB.setVisibility(0);
            if (i == 0) {
                this.pWB.setText(R.string.flg);
            } else if (!bo.isNullOrNil(this.tog.tAj) && !bo.isNullOrNil(this.tog.tAj.trim())) {
                this.pWB.setText(this.tog.tAj);
                AppMethodBeat.o(47456);
                return;
            } else if (this.tog.tuo != 1) {
                this.pWB.setText(R.string.flf);
                AppMethodBeat.o(47456);
                return;
            } else {
                this.pWB.setText(R.string.fle);
                AppMethodBeat.o(47456);
                return;
            }
        }
        AppMethodBeat.o(47456);
    }

    private void cRE() {
        AppMethodBeat.i(47457);
        this.tIk.setVisibility(8);
        this.pSN.setVisibility(8);
        this.pSM.setVisibility(8);
        this.pSO.setVisibility(8);
        if (!(this.tog == null || this.tId == null || this.tId.size() <= 0)) {
            Commodity commodity = (Commodity) this.tId.get(0);
            List list = commodity.tAU;
            String str = "MicroMsg.WalletOrderInfoNewUI";
            String str2 = "discountInfoList: %s, size: %s";
            Object[] objArr = new Object[2];
            objArr[0] = list;
            objArr[1] = Integer.valueOf(list != null ? list.size() : 0);
            ab.i(str, str2, objArr);
            if (list != null && list.size() > 0) {
                this.pSN.removeAllViews();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    DiscountInfo discountInfo = (DiscountInfo) list.get(i2);
                    TextView textView = new TextView(this.mController.ylL);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    textView.setTextSize(1, 14.0f);
                    textView.setTextColor(Color.parseColor("#FA962A"));
                    if (discountInfo.tBm > 0.0d) {
                        textView.setText(discountInfo.pOz + e.e(discountInfo.tBm / 100.0d, this.tog.pcl));
                    } else {
                        textView.setText(discountInfo.pOz);
                    }
                    this.pSN.addView(textView);
                    i = i2 + 1;
                }
                this.pSN.setVisibility(0);
                this.tIk.setVisibility(0);
                this.pSM.setVisibility(0);
            }
            if (commodity.tAR >= 0.0d && commodity.kCJ < commodity.tAR) {
                this.pSP.setText(e.e(commodity.tAR, commodity.pcl));
                this.pSP.getPaint().setFlags(16);
                this.pSO.setVisibility(0);
                this.tIk.setVisibility(0);
            }
        }
        AppMethodBeat.o(47457);
    }

    private void cRF() {
        AppMethodBeat.i(47458);
        this.tIp.setVisibility(8);
        if (this.tog != null) {
            c(this.tog);
            if (this.tId != null && this.tId.size() > 0) {
                Commodity commodity = (Commodity) this.tId.get(0);
                ab.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", Boolean.valueOf(commodity.tBb));
                if (commodity.tBb && commodity.tBa != null && commodity.tBa.size() > 0) {
                    for (Promotions promotions : commodity.tBa) {
                        if (promotions.type == Orders.tAP) {
                            break;
                        }
                    }
                    Promotions promotions2 = null;
                    ab.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", promotions2);
                    if (!(promotions2 == null || bo.isNullOrNil(promotions2.pcm))) {
                        this.pVl = commodity.cAa;
                        h.pYm.e(13033, Integer.valueOf(1), promotions2.pcm, promotions2.url, promotions2.name, this.pVl);
                        this.tIq.setText(getString(R.string.flm, new Object[]{promotions2.name}));
                        this.tIf = promotions2.pcm;
                        this.tIr.setVisibility(0);
                        if (this.tIc.contains(promotions2.pcm)) {
                            this.tIr.setChecked(true);
                        } else {
                            this.tIr.setChecked(false);
                        }
                        this.tIp.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(47446);
                                if (!bo.isNullOrNil(WalletOrderInfoNewUI.this.tIf)) {
                                    if (WalletOrderInfoNewUI.this.tIc.contains(WalletOrderInfoNewUI.this.tIf)) {
                                        WalletOrderInfoNewUI.this.tIc.remove(WalletOrderInfoNewUI.this.tIf);
                                        WalletOrderInfoNewUI.this.tIr.setChecked(false);
                                        AppMethodBeat.o(47446);
                                        return;
                                    }
                                    WalletOrderInfoNewUI.this.tIc.add(WalletOrderInfoNewUI.this.tIf);
                                    WalletOrderInfoNewUI.this.tIr.setChecked(true);
                                }
                                AppMethodBeat.o(47446);
                            }
                        });
                        this.tIp.setVisibility(0);
                    }
                }
            }
        }
        AppMethodBeat.o(47458);
    }

    private void cRG() {
        AppMethodBeat.i(47459);
        this.tIo.setVisibility(8);
        this.tIo.removeAllViews();
        if (this.tog != null && this.tog.tAC == 1 && this.tog.tAE != null && this.tog.tAE.size() > 0) {
            ab.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", this.tog.tAE, Integer.valueOf(this.tog.tAE.size()));
            Iterator it = this.tog.tAE.iterator();
            while (it.hasNext()) {
                final ShowInfo showInfo = (ShowInfo) it.next();
                ab.i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", showInfo);
                LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.b5g, this.tIo, false);
                TextView textView = (TextView) linearLayout.findViewById(R.id.bbp);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.fe_);
                if (!bo.isNullOrNil(showInfo.name)) {
                    textView.setText(showInfo.name);
                }
                if (!bo.isNullOrNil(showInfo.mVA)) {
                    try {
                        textView.setTextColor(Color.parseColor(showInfo.mVA));
                    } catch (Exception e) {
                    }
                }
                if (!bo.isNullOrNil(showInfo.value)) {
                    textView2.setText(showInfo.value);
                }
                if (showInfo.tBK == 1) {
                    textView2.getPaint().setFlags(16);
                }
                if (!bo.isNullOrNil(showInfo.tBF)) {
                    try {
                        textView2.setTextColor(Color.parseColor(showInfo.tBF));
                    } catch (Exception e2) {
                    }
                }
                if (showInfo.tBG == 1) {
                    if (!bo.isNullOrNil(showInfo.tBJ)) {
                        linearLayout.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(47427);
                                ab.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", showInfo.tBJ);
                                WalletOrderInfoNewUI.this.acZ(showInfo.tBJ);
                                AppMethodBeat.o(47427);
                            }
                        });
                    }
                } else if (showInfo.tBG == 2 && !bo.isNullOrNil(showInfo.tBH)) {
                    linearLayout.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(47428);
                            ab.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", showInfo.tBH, showInfo.tBI);
                            se seVar = new se();
                            seVar.cOf.userName = showInfo.tBH;
                            seVar.cOf.cOh = bo.bc(showInfo.tBI, "");
                            seVar.cOf.scene = 1060;
                            seVar.cOf.cst = WalletOrderInfoNewUI.this.oXY;
                            seVar.cOf.cOi = 0;
                            seVar.cOf.context = WalletOrderInfoNewUI.this;
                            com.tencent.mm.sdk.b.a.xxA.m(seVar);
                            AppMethodBeat.o(47428);
                        }
                    });
                }
                this.tIo.addView(linearLayout);
            }
            this.tIk.setVisibility(0);
            this.tIo.setVisibility(0);
        }
        AppMethodBeat.o(47459);
    }

    private void nk(boolean z) {
        AppMethodBeat.i(47460);
        this.tEN.setVisibility(8);
        this.tEV = false;
        this.tEU = false;
        if (this.tog != null) {
            if (this.tId != null && this.tId.size() > 0) {
                final Commodity commodity = (Commodity) this.tId.get(0);
                if (commodity != null) {
                    Promotions promotions;
                    ab.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", Boolean.valueOf(commodity.tBb));
                    if (commodity.tBa != null && commodity.tBa.size() > 0) {
                        for (Promotions promotions2 : commodity.tBa) {
                            if (promotions2.type == Orders.tAQ) {
                                promotions = promotions2;
                                break;
                            }
                        }
                    }
                    promotions = null;
                    ab.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", promotions);
                    a aVar;
                    MarginLayoutParams marginLayoutParams;
                    List list;
                    if (promotions != null && promotions.ttW > 0 && !bo.isNullOrNil(promotions.tzS)) {
                        this.tIg = promotions;
                        this.tER.setVisibility(8);
                        this.tEO.setRoundCorner(true);
                        this.tES.setEnabled(true);
                        this.tES.setBackgroundResource(R.drawable.fp);
                        this.tEQ.setCompoundDrawables(null, null, null, null);
                        aVar = (a) this.tEH.get(promotions.ttW);
                        if (aVar != null) {
                            if (!bo.isNullOrNil(aVar.cIY)) {
                                this.tEO.setUrl(aVar.cIY);
                            }
                            if (!bo.isNullOrNil(aVar.cEh)) {
                                this.tEP.setText(aVar.cEh);
                            }
                            if (!bo.isNullOrNil(aVar.tID)) {
                                this.tES.setText(aVar.tID);
                                this.tES.setBackgroundResource(R.drawable.a65);
                            }
                            if (!bo.isNullOrNil(aVar.tzW)) {
                                this.tIg.uZP = aVar.tzW;
                            }
                            if (!bo.isNullOrNil(aVar.ttg)) {
                                this.tIg.uZQ = aVar.ttg;
                            }
                            if (aVar.tIE > 0) {
                                this.tIg.uZR = aVar.tIE;
                            }
                        } else {
                            this.tEO.setUrl(promotions.pia);
                            this.tEP.setText(promotions.name);
                            this.tES.setText(promotions.tzS);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.tEQ.getLayoutParams();
                        if (aVar != null && !bo.isNullOrNil(aVar.title)) {
                            this.tEQ.setText(aVar.title);
                            layoutParams.addRule(15, 0);
                        } else if (bo.isNullOrNil(promotions.title)) {
                            this.tEQ.setVisibility(8);
                            layoutParams.addRule(15, -1);
                        } else {
                            this.tEQ.setText(promotions.title);
                            layoutParams.addRule(15, 0);
                        }
                        this.tEQ.setLayoutParams(layoutParams);
                        this.tES.setVisibility(0);
                        this.tES.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(47429);
                                ab.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
                                WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this);
                                AppMethodBeat.o(47429);
                            }
                        });
                        if (promotions.uZM != 1) {
                            this.tEN.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(47430);
                                    ab.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
                                    WalletOrderInfoNewUI.q(WalletOrderInfoNewUI.this);
                                    AppMethodBeat.o(47430);
                                }
                            });
                        }
                        String str = this.tEK;
                        boolean z2 = true;
                        switch (str.hashCode()) {
                            case 48:
                                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                    z2 = false;
                                    break;
                                }
                                break;
                            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                                if (str.equals("1")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 50:
                                if (str.equals("2")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 51:
                                if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 52:
                                if (str.equals("4")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 1444:
                                if (str.equals("-1")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                        }
                        switch (z2) {
                            case false:
                                this.tES.setEnabled(false);
                                break;
                        }
                        marginLayoutParams = (MarginLayoutParams) this.tEN.getLayoutParams();
                        list = commodity.tAU;
                        if ((commodity.tAR < 0.0d || commodity.kCJ >= commodity.tAR) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.tEN.setLayoutParams(marginLayoutParams);
                        this.tEN.setVisibility(0);
                        if (z) {
                            h hVar = h.pYm;
                            Object[] objArr = new Object[6];
                            objArr[0] = this.pVl;
                            objArr[1] = Integer.valueOf(1);
                            objArr[2] = Integer.valueOf(promotions.uZM);
                            objArr[3] = this.tEK.equals("-1") ? Integer.valueOf(5) : this.tEK;
                            objArr[4] = Long.valueOf(promotions.ttW);
                            objArr[5] = Long.valueOf(promotions.tzR);
                            hVar.e(13471, objArr);
                        }
                    } else if (!(commodity.tAY == null || bo.isNullOrNil(commodity.tAY.tzW))) {
                        this.tED = commodity.tAY.tzW;
                        this.tEE = commodity.tAY.ttg;
                        this.tzY = commodity.tAY.tzY;
                        this.tIe = commodity.tAY;
                        this.tEO.setUrl(commodity.tAY.tzU);
                        this.tEP.setText(commodity.tAY.tzV);
                        this.tEQ.setText(getString(R.string.f8_));
                        this.tEQ.setVisibility(0);
                        this.tEO.setRoundCorner(true);
                        this.tES.setEnabled(true);
                        this.tES.setBackgroundResource(R.drawable.fp);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.tEQ.getLayoutParams();
                        layoutParams2.addRule(15, 0);
                        this.tEQ.setLayoutParams(layoutParams2);
                        if (commodity.tAY.tBx > 0) {
                            if (!bo.isNullOrNil(commodity.tAY.tzX)) {
                                this.tES.setVisibility(0);
                                this.tES.setText(commodity.tAY.tzX);
                                this.tER.setVisibility(8);
                            }
                            aVar = (a) this.tEH.get(commodity.tAY.tBx);
                            if (aVar != null) {
                                if (!bo.isNullOrNil(aVar.tzU)) {
                                    this.tEO.setUrl(aVar.tzU);
                                }
                                if (!bo.isNullOrNil(aVar.tzV)) {
                                    this.tEP.setText(aVar.tzV);
                                }
                                if (!bo.isNullOrNil(aVar.tzX)) {
                                    this.tES.setText(aVar.tzX);
                                    this.tES.setBackgroundResource(R.drawable.a65);
                                }
                                if (!bo.isNullOrNil(aVar.tzW)) {
                                    this.tED = aVar.tzW;
                                }
                                if (!bo.isNullOrNil(aVar.ttg)) {
                                    this.tEE = aVar.ttg;
                                }
                                if (aVar.tIE > 0) {
                                    this.tzY = aVar.tIE;
                                }
                            }
                        } else {
                            this.tES.setVisibility(8);
                            this.tER.setVisibility(8);
                        }
                        AnonymousClass6 anonymousClass6 = new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(47431);
                                ab.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", WalletOrderInfoNewUI.this.tED, WalletOrderInfoNewUI.this.tEE, Integer.valueOf(WalletOrderInfoNewUI.this.tzY));
                                se seVar = new se();
                                seVar.cOf.userName = WalletOrderInfoNewUI.this.tED;
                                seVar.cOf.cOh = bo.bc(WalletOrderInfoNewUI.this.tEE, "");
                                seVar.cOf.scene = 1034;
                                seVar.cOf.cOi = 0;
                                if (WalletOrderInfoNewUI.this.tzY > 0) {
                                    seVar.cOf.axy = WalletOrderInfoNewUI.this.tzY;
                                }
                                seVar.cOf.context = WalletOrderInfoNewUI.this;
                                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                                WalletOrderInfoNewUI walletOrderInfoNewUI = WalletOrderInfoNewUI.this;
                                boolean z = !bo.isNullOrNil(commodity.tAY.tzX) && commodity.tAY.tBx > 0;
                                walletOrderInfoNewUI.tEU = z;
                                if (WalletOrderInfoNewUI.this.tEU) {
                                    h.pYm.e(14118, WalletOrderInfoNewUI.this.oXY, WalletOrderInfoNewUI.this.cNH(), Integer.valueOf(3));
                                    AppMethodBeat.o(47431);
                                    return;
                                }
                                h.pYm.e(14118, WalletOrderInfoNewUI.this.oXY, WalletOrderInfoNewUI.this.cNH(), Integer.valueOf(1));
                                AppMethodBeat.o(47431);
                            }
                        };
                        this.tEN.setOnClickListener(anonymousClass6);
                        this.tES.setOnClickListener(anonymousClass6);
                        marginLayoutParams = (MarginLayoutParams) this.tEN.getLayoutParams();
                        list = commodity.tAU;
                        if ((commodity.tAR < 0.0d || commodity.kCJ >= commodity.tAR) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.tEN.setLayoutParams(marginLayoutParams);
                        this.tEN.setVisibility(0);
                    }
                }
            }
            if (this.tEP.getVisibility() == 0) {
                this.tEP.setSingleLine();
                this.tEP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(47432);
                        try {
                            if (WalletOrderInfoNewUI.this.tES.getVisibility() == 0 && WalletOrderInfoNewUI.this.tEP.getRight() > 0 && WalletOrderInfoNewUI.this.tES.getLeft() > 0 && WalletOrderInfoNewUI.this.tEP.getRight() >= WalletOrderInfoNewUI.this.tES.getLeft() && !bo.ac(WalletOrderInfoNewUI.this.tEP.getText())) {
                                float textSize = WalletOrderInfoNewUI.this.tEP.getTextSize();
                                ab.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", Integer.valueOf(WalletOrderInfoNewUI.this.tEP.getRight()), Integer.valueOf(WalletOrderInfoNewUI.this.tES.getLeft()));
                                Paint paint = new Paint();
                                paint.setTextSize(textSize);
                                String charSequence = WalletOrderInfoNewUI.this.tEP.getText().toString();
                                float left = (float) (WalletOrderInfoNewUI.this.tES.getLeft() - WalletOrderInfoNewUI.this.tEP.getLeft());
                                int i = 1;
                                while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > left && i <= charSequence.length() - 1) {
                                    i++;
                                }
                                ab.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i), Integer.valueOf(charSequence.length()));
                                CharSequence substring = charSequence.substring(0, (charSequence.length() - i) - 1);
                                if (charSequence.length() > 9 && substring.length() < 9) {
                                    substring = charSequence.substring(0, 9);
                                }
                                WalletOrderInfoNewUI.this.tEP.setText(substring);
                                WalletOrderInfoNewUI.this.tEP.append("...");
                            }
                            AppMethodBeat.o(47432);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", e, "calc tinyapp name error: %s", e.getMessage());
                            AppMethodBeat.o(47432);
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(47460);
    }

    /* Access modifiers changed, original: protected|final */
    public final void acZ(String str) {
        AppMethodBeat.i(47461);
        ab.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", str);
        cRq();
        e.n(this, str, true);
        AppMethodBeat.o(47461);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(47462);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            ab.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", Boolean.valueOf(bo.isNullOrNil(this.tEG.tIJ)), Boolean.valueOf(this.tIx));
            if (this.tIx) {
                AppMethodBeat.o(47462);
                return;
            }
            this.tIx = true;
            if (bo.isNullOrNil(this.tEG.tIJ)) {
                a(new aa(this.tEG.tuv, this.tEG.tIF, this.tEG.tIG, this.tEG.tIH, this.tEG.cBT, this.tEG.pQe, this.tEG.tBC), true, true);
                AppMethodBeat.o(47462);
                return;
            }
            a(new k(this.tEG.tIJ, this.tEG.tuv), true, true);
        }
        AppMethodBeat.o(47462);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgg() {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b5h;
    }

    private void c(Orders orders) {
        AppMethodBeat.i(47464);
        this.tIc.clear();
        if (orders == null || orders.tAq == null) {
            ab.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
            AppMethodBeat.o(47464);
            return;
        }
        for (Commodity commodity : orders.tAq) {
            if (commodity.tAh == 2 && !bo.isNullOrNil(commodity.tAS)) {
                ab.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
                this.tIc.add(commodity.tAS);
            }
        }
        AppMethodBeat.o(47464);
    }

    public final void cRH() {
        String string;
        AppMethodBeat.i(47466);
        cRq();
        ap apVar = new ap();
        apVar.ctF.ctG = true;
        com.tencent.mm.sdk.b.a.xxA.m(apVar);
        gq gqVar = new gq();
        gqVar.cBo.cBp = "ok";
        com.tencent.mm.sdk.b.a.xxA.m(gqVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.mBundle.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.mBundle.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.mBundle.getBoolean("intent_pay_end"));
        ab.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + this.mBundle.getInt("intent_pay_end_errcode"));
        for (String string2 : this.tIc) {
            if (!bo.isNullOrNil(string2)) {
                ab.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", string2);
                if (this.tog == null || this.pVL == null) {
                    g.RO().eJo.a(new com.tencent.mm.wallet_core.c.r(string2), 0);
                } else {
                    String str;
                    p pVar = g.RO().eJo;
                    String str2 = this.tog.czZ;
                    if (this.tog.tAq.size() > 0) {
                        str = ((Commodity) this.tog.tAq.get(0)).cAa;
                    } else {
                        str = "";
                    }
                    pVar.a(new com.tencent.mm.wallet_core.c.r(string2, str2, str, this.pVL.cIf, this.pVL.cIb, this.tog.tAh), 0);
                }
            }
            h.pYm.e(13033, Integer.valueOf(2), string2, "", "", "");
        }
        if (this.tEX != null) {
            this.tEX.a((Activity) this, 0, bundle);
            this.tEX = null;
        } else {
            ab.i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
            finish();
        }
        if (this.pVL != null && (this.pVL.cIf == 46 || this.pVL.cIf == 3)) {
            bg bgVar = new bg();
            if (this.pVL.cIf == 46) {
                bgVar.dcc = 2;
            } else if (this.pVL.cIf == 3) {
                bgVar.dcc = 1;
            }
            if (this.tog != null && this.tog.tAD == 0) {
                bgVar.dcd = 1;
            } else if (this.tog != null && this.tog.tAD == 1) {
                bgVar.dcd = 2;
            } else if (!(this.tog == null || this.tog.tAD != 0 || bo.isNullOrNil(this.tog.tAG) || bo.isNullOrNil(this.tog.tAF))) {
                bgVar.dcd = 3;
            }
            if (!(this.pVL == null || this.pVL.vwh == null)) {
                string2 = this.pVL.vwh.getString("extinfo_key_20", "");
                if (!bo.isNullOrNil(string2)) {
                    bgVar.fY(string2);
                }
                string2 = this.pVL.vwh.getString("extinfo_key_21", "");
                if (!bo.isNullOrNil(string2)) {
                    bgVar.ga(string2);
                }
                string2 = this.pVL.vwh.getString("extinfo_key_22", "");
                if (!bo.isNullOrNil(string2)) {
                    bgVar.fZ(string2);
                }
            }
            if (!(this.tog == null || this.tog.tAD != 0 || bo.isNullOrNil(this.tog.tAG) || bo.isNullOrNil(this.tog.tAF))) {
                bgVar.gc(this.tog.tAG);
                bgVar.gb(this.tog.tAF);
            }
            bgVar.ajK();
            if (!(this.tog == null || this.tog.tAD != 0 || bo.isNullOrNil(this.tog.tAG) || bo.isNullOrNil(this.tog.tAF))) {
                se seVar = new se();
                seVar.cOf.userName = this.tog.tAF;
                seVar.cOf.cOh = this.tog.tAG;
                seVar.cOf.scene = 1060;
                seVar.cOf.cst = this.oXY;
                seVar.cOf.cOi = 0;
                seVar.cOf.context = this;
                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                AppMethodBeat.o(47466);
                return;
            }
        }
        if (!(this.tog == null || bo.isNullOrNil(this.tog.lvz))) {
            String d = WalletOrderInfoUI.d(this.tog.lvz, this.tog.czZ, this.tog.tAq.size() > 0 ? ((Commodity) this.tog.tAq.get(0)).cAa : "", this.pVL.kck, this.pVL.hHV);
            ab.d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(d)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", com.tencent.mm.model.r.Yz());
            intent.putExtra("stastic_scene", 8);
            com.tencent.mm.bp.d.b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(47466);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(47467);
        if (i == 4) {
            done();
            AppMethodBeat.o(47467);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(47467);
        return onKeyUp;
    }

    public void onDestroy() {
        AppMethodBeat.i(47468);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.tIy);
        com.tencent.mm.sdk.b.a.xxA.d(this.pap);
        ng(1979);
        ng(2948);
        ng(2710);
        this.pSR.dead();
        if (WalletSuccPageAwardWidget.a(this.pSK)) {
            this.pSL.onDestroy();
        }
        AppMethodBeat.o(47468);
    }

    /* Access modifiers changed, original: protected */
    public void cRq() {
        int i = 0;
        AppMethodBeat.i(47469);
        if (!this.tEC) {
            iy iyVar = new iy();
            iyVar.cEc.requestCode = 4;
            com.tencent.mm.g.a.iy.a aVar = iyVar.cEc;
            if (this.mBundle.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.bFZ = i;
            iyVar.cEc.cEd = new Intent();
            if (this.tog != null) {
                iyVar.cEc.cEd.putExtra("key_jsapi_close_page_after_pay", this.tog.tAD);
            }
            if (!(this.tog == null || this.tog.tAD != 0 || bo.isNullOrNil(this.tog.tAG) || bo.isNullOrNil(this.tog.tAF))) {
                iyVar.cEc.cEd.putExtra("key_jsapi_close_page_after_pay", 1);
            }
            if (this.tEX != null) {
                iyVar.cEc.cEd.putExtra("key_is_clear_failure", this.tEX.mqu.getInt("key_is_clear_failure", -1));
            }
            com.tencent.mm.sdk.b.a.xxA.m(iyVar);
            this.tEC = true;
        }
        AppMethodBeat.o(47469);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47470);
        ab.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), mVar);
        if (WalletSuccPageAwardWidget.a(this.pSK) && this.pSL.c(i, i2, str, mVar)) {
            AppMethodBeat.o(47470);
            return true;
        }
        CharSequence string;
        if (mVar instanceof aa) {
            if (i == 0 && i2 == 0) {
                aa aaVar = (aa) mVar;
                a aVar = new a(aaVar.hwh);
                if (this.tEG != null) {
                    this.tEH.put(aaVar.tuv, aVar);
                    nk(false);
                    cRn();
                } else if (this.tEU) {
                    this.tEH.put(aaVar.tuv, aVar);
                    nk(false);
                    cRn();
                }
            }
            this.tIx = false;
        } else if (mVar instanceof k) {
            if (i == 0 && i2 == 0) {
                k kVar = (k) mVar;
                bnu bnu = kVar.tuc;
                if (bnu.kdT == 0) {
                    a aVar2 = new a(bnu);
                    if (this.tEG != null) {
                        this.tEH.put(kVar.ssr, aVar2);
                        nk(false);
                        cRn();
                    } else if (this.tEU) {
                        this.tEH.put(kVar.ssr, aVar2);
                        nk(false);
                        cRn();
                    }
                }
            }
            this.tIx = false;
        } else if (mVar instanceof n) {
            if (i == 0 && i2 == 0) {
                n nVar = (n) mVar;
                String str2 = nVar.tud;
                if (this.tIg != null && this.tIg.ttW == nVar.tug.ttW) {
                    ab.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", this.tIg);
                    this.tEK = str2;
                    ab.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", nVar.tug.tzS);
                    nk(false);
                    cRn();
                    if (!(bo.isNullOrNil(nVar.ehr) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2))) {
                        this.tES.setText(nVar.ehr);
                    }
                }
                if (!"-1".equals(str2) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2) && !bo.isNullOrNil(nVar.tue)) {
                    com.tencent.mm.ui.base.h.b((Context) this, nVar.tue, "", true);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2)) {
                    if (bo.isNullOrNil(nVar.tue)) {
                        string = getString(R.string.fns);
                    } else {
                        string = nVar.tue;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                AppMethodBeat.o(47470);
                return true;
            }
            if (bo.isNullOrNil(str)) {
                str = getString(R.string.fu2);
            }
            com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(47470);
            return true;
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.h) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.c.h hVar = (com.tencent.mm.plugin.wallet_core.c.h) mVar;
                aeq aeq = hVar.ttV;
                if (aeq.kdT == 0) {
                    String str3 = aeq.wms;
                    if (this.tIg != null && this.tIg.ttW == hVar.ttW) {
                        ab.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", this.tIg);
                        this.tEK = str3;
                        ab.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", aeq.wmu);
                        nk(false);
                        cRn();
                        if (!(bo.isNullOrNil(aeq.wmu) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str3))) {
                            this.tES.setText(aeq.wmu);
                        }
                    }
                    if (!"-1".equals(str3) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str3) && !bo.isNullOrNil(aeq.wmt)) {
                        com.tencent.mm.ui.base.h.b((Context) this, aeq.wmt, "", true);
                    } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str3)) {
                        if (bo.isNullOrNil(aeq.wmt)) {
                            string = getString(R.string.fns);
                        } else {
                            string = aeq.wmt;
                        }
                        Toast.makeText(this, string, 0).show();
                    }
                }
                AppMethodBeat.o(47470);
                return true;
            }
            if (bo.isNullOrNil(str)) {
                str = getString(R.string.fu2);
            }
            com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(47470);
            return true;
        }
        AppMethodBeat.o(47470);
        return false;
    }

    @Deprecated
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.i(47463);
        Dialog a = com.tencent.mm.ui.base.h.a(this.mController.ylL, getString(R.string.fla), getResources().getStringArray(R.array.au), "", new com.tencent.mm.ui.base.h.c() {
            public final void iE(int i) {
                AppMethodBeat.i(47433);
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletOrderInfoNewUI.this.pdC).toString()));
                        intent.addFlags(268435456);
                        WalletOrderInfoNewUI.this.startActivity(intent);
                        break;
                }
                AppMethodBeat.o(47433);
            }
        });
        AppMethodBeat.o(47463);
        return a;
    }

    public void done() {
        AppMethodBeat.i(47465);
        if (this.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoNewUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b = realnameGuideHelper.b(this, bundle, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(47436);
                        WalletOrderInfoNewUI.this.cRH();
                        AppMethodBeat.o(47436);
                    }
                });
                boolean a = realnameGuideHelper.a(this, bundle, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(47437);
                        WalletOrderInfoNewUI.this.cRH();
                        AppMethodBeat.o(47437);
                    }
                });
                this.mBundle.remove("key_realname_guide_helper");
                if (!(b || a)) {
                    cRH();
                }
            }
            AppMethodBeat.o(47465);
            return;
        }
        cRH();
        AppMethodBeat.o(47465);
    }

    public final void AM(int i) {
        AppMethodBeat.i(47471);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.o(47471);
    }

    static /* synthetic */ void q(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        AppMethodBeat.i(47472);
        String str = "MicroMsg.WalletOrderInfoNewUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletOrderInfoNewUI.tIg != null ? walletOrderInfoNewUI.tIg.ttW : 0);
        ab.i(str, str2, objArr);
        if (walletOrderInfoNewUI.tIg != null && walletOrderInfoNewUI.tIg.ttW > 0) {
            walletOrderInfoNewUI.tEV = true;
            if (walletOrderInfoNewUI.tEK.equals("-1") || walletOrderInfoNewUI.tEK.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                h.pYm.e(13472, walletOrderInfoNewUI.pVl, Integer.valueOf(walletOrderInfoNewUI.tIg.uZM), Integer.valueOf(1), Long.valueOf(walletOrderInfoNewUI.tIg.ttW), Long.valueOf(walletOrderInfoNewUI.tIg.tzR));
                h.pYm.e(13033, Integer.valueOf(2), "", walletOrderInfoNewUI.tIg.url, walletOrderInfoNewUI.tIg.name, "");
                if (!bo.isNullOrNil(walletOrderInfoNewUI.tIg.uZP) && !bo.isNullOrNil(walletOrderInfoNewUI.tIg.uZQ)) {
                    ab.i("MicroMsg.WalletOrderInfoNewUI", "promotion jump tiny app, username: %s, path: %s, version: %s", walletOrderInfoNewUI.tIg.uZP, walletOrderInfoNewUI.tIg.uZQ, Integer.valueOf(walletOrderInfoNewUI.tIg.uZR));
                    walletOrderInfoNewUI.tEG = new b(walletOrderInfoNewUI.tIg.ttW, walletOrderInfoNewUI.tIg.uZN, walletOrderInfoNewUI.tIg.tzP, walletOrderInfoNewUI.tIg.tzQ, walletOrderInfoNewUI.cNH(), walletOrderInfoNewUI.pVl, walletOrderInfoNewUI.tIg.tzR, walletOrderInfoNewUI.tIg.uZT);
                    se seVar = new se();
                    seVar.cOf.userName = walletOrderInfoNewUI.tIg.uZP;
                    seVar.cOf.cOh = bo.bc(walletOrderInfoNewUI.tIg.uZQ, "");
                    seVar.cOf.scene = 1060;
                    seVar.cOf.cst = walletOrderInfoNewUI.oXY;
                    seVar.cOf.cOi = 0;
                    if (walletOrderInfoNewUI.tIg.uZR > 0) {
                        seVar.cOf.axy = walletOrderInfoNewUI.tIg.uZR;
                    }
                    seVar.cOf.context = walletOrderInfoNewUI;
                    com.tencent.mm.sdk.b.a.xxA.m(seVar);
                    h.pYm.e(14118, walletOrderInfoNewUI.oXY, walletOrderInfoNewUI.cNH(), Integer.valueOf(2));
                    AppMethodBeat.o(47472);
                    return;
                } else if (walletOrderInfoNewUI.tIg.uZM == 1) {
                    Promotions promotions = walletOrderInfoNewUI.tIg;
                    ab.i("MicroMsg.WalletOrderInfoNewUI", "doSceneSendPayAward, getAwardParams==null: %s, %s", Boolean.valueOf(bo.isNullOrNil(promotions.uZS)), promotions.uZS);
                    if (bo.isNullOrNil(promotions.uZS)) {
                        walletOrderInfoNewUI.a(new n(promotions, walletOrderInfoNewUI.cNH(), walletOrderInfoNewUI.oXY, promotions.tzR), true, false);
                        AppMethodBeat.o(47472);
                        return;
                    }
                    walletOrderInfoNewUI.a(new com.tencent.mm.plugin.wallet_core.c.h(promotions.uZS, promotions.ttW), true, false);
                    AppMethodBeat.o(47472);
                    return;
                } else if (walletOrderInfoNewUI.tIg.uZM != 2 || bo.isNullOrNil(walletOrderInfoNewUI.tIg.url)) {
                    ab.e("MicroMsg.WalletOrderInfoNewUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                } else if (walletOrderInfoNewUI.tEH.containsKey(walletOrderInfoNewUI.tIg.ttW)) {
                    a aVar = (a) walletOrderInfoNewUI.tEH.get(walletOrderInfoNewUI.tIg.ttW);
                    ab.i("MicroMsg.WalletOrderInfoNewUI", "go to new url %s", aVar.url);
                    if (bo.isNullOrNil(aVar.url)) {
                        walletOrderInfoNewUI.acZ(walletOrderInfoNewUI.tIg.url);
                        AppMethodBeat.o(47472);
                        return;
                    }
                    walletOrderInfoNewUI.acZ(aVar.url);
                    AppMethodBeat.o(47472);
                    return;
                } else {
                    walletOrderInfoNewUI.tEI = walletOrderInfoNewUI.tIg.url;
                    String str3 = walletOrderInfoNewUI.tIg.url;
                    b bVar = new b(walletOrderInfoNewUI.tIg.ttW, walletOrderInfoNewUI.tIg.uZN, walletOrderInfoNewUI.tIg.tzP, walletOrderInfoNewUI.tIg.tzQ, walletOrderInfoNewUI.cNH(), walletOrderInfoNewUI.pVl, walletOrderInfoNewUI.tIg.tzR, walletOrderInfoNewUI.tIg.uZT);
                    ab.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", str3);
                    walletOrderInfoNewUI.cRq();
                    walletOrderInfoNewUI.tEG = bVar;
                    e.a((Context) walletOrderInfoNewUI, str3, false, 1);
                    AppMethodBeat.o(47472);
                    return;
                }
            }
        }
        AppMethodBeat.o(47472);
    }
}
