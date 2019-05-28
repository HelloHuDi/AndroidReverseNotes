package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.us;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

@a(3)
public class WalletBindCardResultUI extends WalletBaseUI {
    private PayInfo pVL;
    private String pVl;
    private TextView pWB;
    private c pap = new c<us>() {
        {
            AppMethodBeat.i(47185);
            this.xxI = us.class.getName().hashCode();
            AppMethodBeat.o(47185);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(47186);
            us usVar = (us) bVar;
            if (usVar instanceof us) {
                if (!usVar.cRy.cRz.oZd) {
                    ab.i("MicroMsg.WalletBindCardResultUI", "block pass");
                    AppMethodBeat.o(47186);
                    return true;
                } else if ("1".equals(usVar.cRy.cRz.cRb) || "2".equals(usVar.cRy.cRz.cRb)) {
                    RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                    realnameGuideHelper.a(usVar.cRy.cRz.cRb, usVar.cRy.cRz.cRc, usVar.cRy.cRz.cRd, usVar.cRy.cRz.cRe, usVar.cRy.cRz.cRf, WalletBindCardResultUI.this.pVL == null ? 0 : WalletBindCardResultUI.this.pVL.cIf);
                    ab.i("MicroMsg.WalletBindCardResultUI", "receive guide");
                    WalletBindCardResultUI.this.mBundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            AppMethodBeat.o(47186);
            return false;
        }
    };
    private String pdC = null;
    private BindCardOrder tEB;
    private boolean tEC = false;
    private String tED;
    private String tEE;
    private q.b tEF;
    private b tEG;
    private HashMap<String, a> tEH = new HashMap();
    private String tEI;
    private BindCardOrder tEJ = null;
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
    private int tzY;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBindCardResultUI() {
        AppMethodBeat.i(47193);
        AppMethodBeat.o(47193);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47194);
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
        com.tencent.mm.wallet_core.a.aE(this);
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.mBundle.getInt("key_pay_type", -1);
        BindCardOrder bindCardOrder = (BindCardOrder) this.mBundle.getParcelable("key_bindcard_value_result");
        if (bindCardOrder == null) {
            bindCardOrder = new BindCardOrder();
        }
        this.tEB = bindCardOrder;
        AM(0);
        initView();
        this.tEX = dOD();
        cRo();
        jX(1);
        nf(1979);
        com.tencent.mm.sdk.b.a.xxA.c(this.pap);
        this.tEW = true;
        AppMethodBeat.o(47194);
    }

    public void onResume() {
        AppMethodBeat.i(47195);
        super.onResume();
        ab.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", Boolean.valueOf(this.tEW), this.tEJ, Boolean.valueOf(this.tEU), Boolean.valueOf(this.tEV), this.tEF);
        if (this.tEW) {
            this.tEW = false;
            AppMethodBeat.o(47195);
        } else if (this.tEJ == null || !this.tEV) {
            if (this.tEU && this.tEF != null) {
                a(new x(this.tEB.txN.ttW, this.tEB.txN.tzO, this.tEB.txN.tzP, this.tEB.txN.tzQ, this.tEB.txN.tzR, this.tEB.txN.tzN, this.tEB.pbn, this.tEB.txK, this.tEB.txL, this.tEB.txL), true, true);
            }
            AppMethodBeat.o(47195);
        } else {
            a(new x(this.tEJ.txN.ttW, this.tEJ.txN.tzO, this.tEJ.txN.tzP, this.tEJ.txN.tzQ, this.tEJ.txN.tzN, this.tEJ.txN.tzR, this.tEB.pbn, this.tEB.txK, this.tEB.txL, this.tEB.txL), true, true);
            AppMethodBeat.o(47195);
        }
    }

    public final void initView() {
        AppMethodBeat.i(47196);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.tEM = (ImageView) findViewById(R.id.f8k);
        this.pWB = (TextView) findViewById(R.id.f8l);
        this.tEL = (Button) findViewById(R.id.f8o);
        showHomeBtn(false);
        enableBackMenu(false);
        String string = getString(R.string.qt);
        if (this.tEB == null || bo.isNullOrNil(this.tEB.txG)) {
            this.tEL.setText(string);
        } else {
            this.tEL.setText(this.tEB.txG);
        }
        this.tEL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47187);
                WalletBindCardResultUI.this.done();
                AppMethodBeat.o(47187);
            }
        });
        this.tET = (ViewGroup) findViewById(R.id.f8n);
        this.tEN = (ViewGroup) findViewById(R.id.e2i);
        this.tEO = (CdnImageView) findViewById(R.id.e2j);
        this.tEO.setUseSdcardCache(true);
        this.tEP = (TextView) findViewById(R.id.e2l);
        this.tEQ = (TextView) findViewById(R.id.e2k);
        this.tES = (Button) findViewById(R.id.e2m);
        this.tER = findViewById(R.id.dzd);
        this.tET.setVisibility(4);
        cRo();
        cRp();
        cRn();
        if (!(bo.isNullOrNil(this.tEB.txI) || bo.isNullOrNil(this.tEB.txJ))) {
            ((TextView) findViewById(R.id.f8m)).setText(getString(R.string.f_s, new Object[]{this.tEB.txI, this.tEB.txJ}));
        }
        AppMethodBeat.o(47196);
    }

    private void cRn() {
        AppMethodBeat.i(47197);
        this.tET.setVisibility(0);
        AppMethodBeat.o(47197);
    }

    private void cRo() {
        AppMethodBeat.i(47198);
        this.pWB.setText(this.tEB.txH);
        AppMethodBeat.o(47198);
    }

    private void cRp() {
        MarginLayoutParams marginLayoutParams;
        AppMethodBeat.i(47199);
        this.tEN.setVisibility(4);
        this.tEV = false;
        this.tEU = false;
        if (this.tEB != null) {
            if (this.tEB.txN != null) {
                ab.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", this.tEJ);
                a aVar;
                CharSequence text;
                if (this.tEB != null && ((this.tEB.cPi() || this.tEB.cPk()) && this.tEB.txN.ttW > 0 && !bo.isNullOrNil(this.tEB.txO.tzS))) {
                    this.tEJ = this.tEB;
                    this.tER.setVisibility(8);
                    this.tEO.setRoundCorner(true);
                    this.tES.setEnabled(true);
                    this.tES.setBackgroundResource(R.drawable.fp);
                    this.tEQ.setCompoundDrawables(null, null, null, null);
                    aVar = (a) this.tEH.get(this.tEJ.txN.ttW);
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
                    } else {
                        this.tEO.setUrl(this.tEB.txO.pia);
                        this.tEP.setText(this.tEB.txO.name);
                        this.tES.setText(this.tEB.txO.tzS);
                    }
                    LayoutParams layoutParams = (LayoutParams) this.tEQ.getLayoutParams();
                    if (aVar != null && !bo.isNullOrNil(aVar.title)) {
                        this.tEQ.setText(aVar.title);
                        layoutParams.addRule(15, 0);
                    } else if (bo.isNullOrNil(this.tEB.txO.title)) {
                        this.tEQ.setVisibility(8);
                        layoutParams.addRule(15, -1);
                    } else {
                        this.tEQ.setText(this.tEB.txO.title);
                        layoutParams.addRule(15, 0);
                    }
                    this.tEQ.setLayoutParams(layoutParams);
                    this.tES.setVisibility(0);
                    this.tES.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(47188);
                            ab.i("MicroMsg.WalletBindCardResultUI", "click activity button");
                            WalletBindCardResultUI.b(WalletBindCardResultUI.this);
                            AppMethodBeat.o(47188);
                        }
                    });
                    if (this.tEJ.txN.tzN != 1) {
                        this.tEN.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(47189);
                                ab.i("MicroMsg.WalletBindCardResultUI", "click activity layout");
                                WalletBindCardResultUI.b(WalletBindCardResultUI.this);
                                AppMethodBeat.o(47189);
                            }
                        });
                    }
                    String str = this.tEK;
                    boolean z = true;
                    switch (str.hashCode()) {
                        case 48:
                            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                z = false;
                                break;
                            }
                            break;
                        case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                            if (str.equals("1")) {
                                z = true;
                                break;
                            }
                            break;
                        case 50:
                            if (str.equals("2")) {
                                z = true;
                                break;
                            }
                            break;
                        case 51:
                            if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                z = true;
                                break;
                            }
                            break;
                        case 52:
                            if (str.equals("4")) {
                                z = true;
                                break;
                            }
                            break;
                        case 1444:
                            if (str.equals("-1")) {
                                z = true;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                            this.tES.setEnabled(false);
                            break;
                    }
                    text = this.tEP.getText();
                    if (!bo.ac(text) && text.length() > 9) {
                        this.tEP.setText(text.subSequence(0, 9));
                        this.tEP.append("...");
                    }
                    marginLayoutParams = (MarginLayoutParams) this.tEN.getLayoutParams();
                    marginLayoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(this, 50);
                    this.tEN.setLayoutParams(marginLayoutParams);
                } else if (!(this.tEB.txP == null || bo.isNullOrNil(this.tEB.txP.tzW) || !this.tEB.cPj())) {
                    this.tED = this.tEB.txP.tzW;
                    this.tEE = this.tEB.txP.ttg;
                    this.tzY = this.tEB.txP.tzY;
                    this.tEF = this.tEB.txP;
                    this.tEO.setUrl(this.tEB.txP.tzU);
                    this.tEP.setText(this.tEB.txP.tzV);
                    this.tEQ.setText(getString(R.string.f8_));
                    this.tEQ.setVisibility(0);
                    this.tEO.setRoundCorner(true);
                    this.tES.setEnabled(true);
                    this.tES.setBackgroundResource(R.drawable.fp);
                    LayoutParams layoutParams2 = (LayoutParams) this.tEQ.getLayoutParams();
                    layoutParams2.addRule(15, 0);
                    this.tEQ.setLayoutParams(layoutParams2);
                    if (this.tEB.txN.ttW > 0) {
                        if (!bo.isNullOrNil(this.tEB.txP.tzX)) {
                            this.tES.setVisibility(0);
                            this.tES.setText(this.tEB.txP.tzX);
                            this.tER.setVisibility(8);
                        }
                        aVar = (a) this.tEH.get(this.tEB.txN.ttW);
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
                        }
                    } else {
                        this.tES.setVisibility(8);
                        this.tER.setVisibility(8);
                    }
                    AnonymousClass5 anonymousClass5 = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(47190);
                            ab.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", WalletBindCardResultUI.this.tED, WalletBindCardResultUI.this.tEE, Integer.valueOf(WalletBindCardResultUI.this.tzY));
                            WalletBindCardResultUI.this.jX(2);
                            se seVar = new se();
                            seVar.cOf.userName = WalletBindCardResultUI.this.tED;
                            seVar.cOf.cOh = bo.bc(WalletBindCardResultUI.this.tEE, "");
                            seVar.cOf.scene = 1034;
                            seVar.cOf.cOi = 0;
                            if (WalletBindCardResultUI.this.tzY > 0) {
                                seVar.cOf.axy = WalletBindCardResultUI.this.tzY;
                            }
                            com.tencent.mm.sdk.b.a.xxA.m(seVar);
                            if (bo.isNullOrNil(WalletBindCardResultUI.this.tEB.txP.tzX) || WalletBindCardResultUI.this.tEB.txN.ttW <= 0) {
                                WalletBindCardResultUI.this.tEU = false;
                                AppMethodBeat.o(47190);
                                return;
                            }
                            WalletBindCardResultUI.this.tEU = true;
                            AppMethodBeat.o(47190);
                        }
                    };
                    this.tEN.setOnClickListener(anonymousClass5);
                    this.tES.setOnClickListener(anonymousClass5);
                    text = this.tEP.getText();
                    if (!bo.ac(text) && text.length() > 9) {
                        this.tEP.setText(text.subSequence(0, 9));
                        this.tEP.append("...");
                    }
                }
                this.tEN.setVisibility(0);
            }
            if (this.tEP.getVisibility() == 0) {
                this.tEP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(47191);
                        if (WalletBindCardResultUI.this.tES.getVisibility() == 0 && WalletBindCardResultUI.this.tEP.getRight() >= WalletBindCardResultUI.this.tES.getLeft() && !bo.ac(WalletBindCardResultUI.this.tEP.getText())) {
                            float textSize = WalletBindCardResultUI.this.tEP.getTextSize();
                            ab.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", Integer.valueOf(WalletBindCardResultUI.this.tEP.getRight()), Integer.valueOf(WalletBindCardResultUI.this.tES.getLeft()));
                            Paint paint = new Paint();
                            paint.setTextSize(textSize);
                            String charSequence = WalletBindCardResultUI.this.tEP.getText().toString();
                            float measureText = paint.measureText(charSequence) - ((float) (WalletBindCardResultUI.this.tEP.getRight() - WalletBindCardResultUI.this.tES.getLeft()));
                            int i = 1;
                            while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > measureText && i <= charSequence.length() - 1) {
                                i++;
                            }
                            ab.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i), Integer.valueOf(charSequence.length()));
                            WalletBindCardResultUI.this.tEP.setText(charSequence.substring(0, (charSequence.length() - i) - 1));
                            WalletBindCardResultUI.this.tEP.append("...");
                        }
                        AppMethodBeat.o(47191);
                    }
                });
            }
        }
        if (this.tEN.getVisibility() == 8) {
            marginLayoutParams = (MarginLayoutParams) this.tEM.getLayoutParams();
            marginLayoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(this, 91);
            this.tEM.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(47199);
    }

    private void acZ(String str) {
        AppMethodBeat.i(47200);
        cRq();
        e.n(this, str, false);
        AppMethodBeat.o(47200);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(47201);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            ab.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
            a(new x(this.tEG.tuv, this.tEG.tIF, this.tEG.tIG, this.tEG.tIH, this.tEG.tBC, this.tEG.tII, this.tEB.pbn, this.tEB.txK, this.tEB.txL, this.tEB.txL), true, true);
        }
        AppMethodBeat.o(47201);
    }

    public final int getLayoutId() {
        return R.layout.b3k;
    }

    public final void done() {
        AppMethodBeat.i(47203);
        Bundle bundle = new Bundle();
        if (this.tEX != null) {
            this.tEX.a((Activity) this, 0, bundle);
            AppMethodBeat.o(47203);
            return;
        }
        finish();
        AppMethodBeat.o(47203);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(47204);
        if (i == 4) {
            done();
            AppMethodBeat.o(47204);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(47204);
        return onKeyUp;
    }

    public void onDestroy() {
        AppMethodBeat.i(47205);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.pap);
        ng(1979);
        AppMethodBeat.o(47205);
    }

    private void cRq() {
        int i = 0;
        AppMethodBeat.i(47206);
        if (!this.tEC) {
            iy iyVar = new iy();
            iyVar.cEc.requestCode = 4;
            iy.a aVar = iyVar.cEc;
            if (this.mBundle.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.bFZ = i;
            com.tencent.mm.sdk.b.a.xxA.m(iyVar);
            this.tEC = true;
        }
        AppMethodBeat.o(47206);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47207);
        if (mVar instanceof x) {
            if (i == 0 && i2 == 0) {
                x xVar = (x) mVar;
                a aVar = new a(xVar.hwh);
                if (this.tEG != null) {
                    this.tEH.put(xVar.tuv, aVar);
                    cRp();
                    cRn();
                } else if (this.tEU) {
                    this.tEH.put(xVar.tuv, aVar);
                    cRp();
                    cRn();
                }
            }
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.m) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.c.m mVar2 = (com.tencent.mm.plugin.wallet_core.c.m) mVar;
                String str2 = mVar2.tud;
                if (this.tEJ != null && this.tEJ.txN.ttW == mVar2.tuf.txN.ttW) {
                    ab.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", this.tEJ);
                    this.tEK = str2;
                    cRp();
                    cRn();
                    if (!(bo.isNullOrNil(mVar2.ehr) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2))) {
                        this.tES.setText(mVar2.ehr);
                    }
                }
                if (!"-1".equals(str2) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2) && !bo.isNullOrNil(mVar2.tue)) {
                    h.b((Context) this, mVar2.tue, "", true);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2)) {
                    CharSequence string;
                    if (bo.isNullOrNil(mVar2.tue)) {
                        string = getString(R.string.fns);
                    } else {
                        string = mVar2.tue;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                AppMethodBeat.o(47207);
                return true;
            }
            if (bo.isNullOrNil(str)) {
                str = getString(R.string.fu2);
            }
            h.a((Context) this, str, null, false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(47207);
            return true;
        }
        AppMethodBeat.o(47207);
        return false;
    }

    public final void jX(int i) {
        AppMethodBeat.i(47209);
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
        Object[] objArr = new Object[4];
        objArr[0] = this.tEB.txN == null ? "" : bo.bc(this.tEB.txN.ttW, "");
        objArr[1] = this.tEB.txK;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = this.tEB.pbn;
        hVar.e(14877, objArr);
        AppMethodBeat.o(47209);
    }

    @Deprecated
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.i(47202);
        Dialog a = h.a(this.mController.ylL, getString(R.string.fla), getResources().getStringArray(R.array.au), "", new h.c() {
            public final void iE(int i) {
                AppMethodBeat.i(47192);
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletBindCardResultUI.this.pdC).toString()));
                        intent.addFlags(268435456);
                        WalletBindCardResultUI.this.startActivity(intent);
                        break;
                }
                AppMethodBeat.o(47192);
            }
        });
        AppMethodBeat.o(47202);
        return a;
    }

    public final void AM(int i) {
        AppMethodBeat.i(47208);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.o(47208);
    }

    static /* synthetic */ void b(WalletBindCardResultUI walletBindCardResultUI) {
        AppMethodBeat.i(47210);
        String str = "MicroMsg.WalletBindCardResultUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletBindCardResultUI.tEJ != null ? walletBindCardResultUI.tEJ.txN.ttW : 0);
        ab.i(str, str2, objArr);
        if (walletBindCardResultUI.tEJ != null && walletBindCardResultUI.tEJ.txN.ttW > 0) {
            walletBindCardResultUI.jX(2);
            walletBindCardResultUI.tEV = true;
            if (walletBindCardResultUI.tEK.equals("-1") || walletBindCardResultUI.tEK.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                if (walletBindCardResultUI.tEB.cPk()) {
                    BindCardOrder bindCardOrder = walletBindCardResultUI.tEJ;
                    walletBindCardResultUI.a(new com.tencent.mm.plugin.wallet_core.c.m(bindCardOrder, bindCardOrder.txN.ttW, bindCardOrder.txN.tzO, bindCardOrder.txN.tzP, bindCardOrder.txN.tzQ, bindCardOrder.txN.tzR, bindCardOrder.txN.tzN, walletBindCardResultUI.tEB.pbn, walletBindCardResultUI.tEB.txK, walletBindCardResultUI.tEB.txL, walletBindCardResultUI.tEB.txM), true, false);
                    AppMethodBeat.o(47210);
                    return;
                } else if (!walletBindCardResultUI.tEB.cPi() || bo.isNullOrNil(walletBindCardResultUI.tEJ.txO.url)) {
                    ab.e("MicroMsg.WalletBindCardResultUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                } else if (walletBindCardResultUI.tEH.containsKey(walletBindCardResultUI.tEJ.txN.ttW)) {
                    a aVar = (a) walletBindCardResultUI.tEH.get(walletBindCardResultUI.tEJ.txN.ttW);
                    ab.i("MicroMsg.WalletBindCardResultUI", "go to new url %s", aVar.url);
                    if (bo.isNullOrNil(aVar.url)) {
                        walletBindCardResultUI.acZ(walletBindCardResultUI.tEJ.txO.url);
                        AppMethodBeat.o(47210);
                        return;
                    }
                    walletBindCardResultUI.acZ(aVar.url);
                    AppMethodBeat.o(47210);
                    return;
                } else {
                    walletBindCardResultUI.tEI = walletBindCardResultUI.tEJ.txO.url;
                    String str3 = walletBindCardResultUI.tEJ.txO.url;
                    b bVar = new b(walletBindCardResultUI.tEJ.txN.ttW, walletBindCardResultUI.tEJ.txN.tzO, walletBindCardResultUI.tEJ.txN.tzP, walletBindCardResultUI.tEJ.txN.tzQ, walletBindCardResultUI.cNH(), walletBindCardResultUI.pVl, walletBindCardResultUI.tEJ.txN.tzR, walletBindCardResultUI.tEJ.txN.tzN);
                    walletBindCardResultUI.cRq();
                    walletBindCardResultUI.tEG = bVar;
                    e.a((Context) walletBindCardResultUI, str3, false, 1);
                    AppMethodBeat.o(47210);
                    return;
                }
            }
        }
        AppMethodBeat.o(47210);
    }
}
