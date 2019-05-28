package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.b.a.bh;
import com.tencent.mm.g.b.a.bl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceBaseUI extends WalletBaseUI implements com.tencent.mm.ah.d.a {
    private String cEW;
    protected int cKs = 0;
    protected String edV;
    protected String eeO;
    protected Button gHn;
    protected int gOW;
    private final int gnS = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 270);
    protected WalletFormView kGa;
    protected String kux;
    protected String mName;
    protected ScrollView nsk;
    private int obL;
    private double pPt;
    protected com.tencent.mm.plugin.wallet.a pQU = null;
    protected double pQV;
    protected String pQW;
    protected String pQX;
    protected int pQY;
    private int pQZ = -1;
    protected int pRA;
    private int pRB;
    protected String pRC;
    protected String pRD;
    protected String pRE;
    private Map<String, a> pRF = new HashMap();
    private String pRG;
    protected boolean pRH = false;
    private v pRI;
    private bh pRJ;
    private boolean pRK = false;
    private c pRL = new c<un>() {
        {
            AppMethodBeat.i(44830);
            this.xxI = un.class.getName().hashCode();
            AppMethodBeat.o(44830);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(44831);
            if (bo.isEqual(RemittanceBaseUI.this.pRI.getUri(), ((un) bVar).cQI.uri) && bo.gW(RemittanceBaseUI.this.pRI.nZf, 1)) {
                RemittanceBaseUI.this.finish();
            }
            AppMethodBeat.o(44831);
            return false;
        }
    };
    private boolean pRM = false;
    private boolean pRN = false;
    private boolean pRO = false;
    private boolean pRP = false;
    private rn pRQ = null;
    private c pRR = new c<fw>() {
        {
            AppMethodBeat.i(44854);
            this.xxI = fw.class.getName().hashCode();
            AppMethodBeat.o(44854);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(44855);
            fw fwVar = (fw) bVar;
            if (fwVar.czT.czW == 1) {
                h.pYm.e(15386, Integer.valueOf(4), Integer.valueOf(1));
            } else {
                h.pYm.e(15386, Integer.valueOf(5), Integer.valueOf(1));
            }
            String str = fwVar.czT.czU;
            ab.i("MicroMsg.RemittanceBaseUI", "receive dynamic req: %s, %s", Integer.valueOf(fwVar.czT.czW), str);
            if (RemittanceBaseUI.this.pQY == 33) {
                RemittanceBaseUI.this.a(RemittanceBaseUI.this.eeO, RemittanceBaseUI.this.pQZ, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.pdC, RemittanceBaseUI.this.pRs, RemittanceBaseUI.this.pRu, str, fwVar);
            } else {
                RemittanceBaseUI.this.a(RemittanceBaseUI.this.eeO, RemittanceBaseUI.this.pQZ, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.pdC, RemittanceBaseUI.this.pRs, null, str, fwVar);
            }
            AppMethodBeat.o(44855);
            return false;
        }
    };
    protected double pRS = 0.0d;
    protected String pRT = "";
    protected String pRU = "";
    protected String pRV = "";
    private c<fx> pRW = new c<fx>() {
        {
            AppMethodBeat.i(44857);
            this.xxI = fx.class.getName().hashCode();
            AppMethodBeat.o(44857);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(44858);
            fx fxVar = (fx) bVar;
            RemittanceBaseUI.a(RemittanceBaseUI.this, fxVar.czY.czZ, fxVar.czY.cAa);
            AppMethodBeat.o(44858);
            return false;
        }
    };
    protected boolean pRa = false;
    protected String pRb;
    protected ImageView pRc;
    protected TextView pRd;
    protected TextView pRe;
    protected TextView pRf;
    protected TextView pRg;
    protected TextView pRh;
    private TextView pRi;
    private TextView pRj;
    protected TextView pRk;
    private LinearLayout pRl;
    private LinearLayout pRm;
    private LinearLayout pRn;
    private TextView pRo;
    private TextView pRp;
    private LinearLayout pRq;
    private LinearLayout pRr;
    protected String pRs;
    protected boolean pRt = true;
    protected String pRu;
    private String pRv;
    private String pRw;
    protected String pRx;
    protected String pRy = null;
    protected String pRz = null;
    protected String pdC;

    static class a {
        String cAa;
        String cEa;
        String kBE;
        String kDV;
        int nUf;
        String pPC;
        String pPx;
        String pPy;
        long pSg;

        a(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, long j) {
            this.pPx = str;
            this.kBE = str2;
            this.kDV = str3;
            this.pPy = str4;
            this.nUf = i;
            this.cEa = str5;
            this.cAa = str6;
            this.pPC = str7;
            this.pSg = j;
        }
    }

    public abstract void a(String str, int i, String str2, String str3, String str4, String str5, String str6, fw fwVar);

    public abstract void cfC();

    public abstract void cfG();

    public abstract void cfz();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void cfO() {
    }

    public int getLayoutId() {
        if (this.pQY == 33 || this.pQY == 32) {
            return R.layout.aok;
        }
        if (!bo.gW(this.pQZ, 0)) {
            return R.layout.aoj;
        }
        dyb();
        return R.layout.aol;
    }

    public void onCreate(Bundle bundle) {
        this.gOW = getIntent().getIntExtra("scene", 0);
        this.pQY = getIntent().getIntExtra("pay_scene", 31);
        if (!cfK()) {
            this.cEW = UUID.randomUUID().toString();
            com.tencent.mm.plugin.wallet.pay.a.b.acq(this.cEW);
        }
        if (this instanceof RemittanceUI) {
            this.pQZ = 0;
        } else if (this instanceof RemittanceHKUI) {
            this.pQZ = 1;
        } else if (this instanceof RemittanceOSUI) {
            this.pQZ = 2;
        }
        super.onCreate(bundle);
        this.pQU = com.tencent.mm.plugin.wallet.a.at(getIntent());
        this.pRb = getIntent().getStringExtra("scan_remittance_id");
        this.pQV = getIntent().getDoubleExtra("fee", 0.0d);
        this.edV = getIntent().getStringExtra("receiver_name");
        this.kux = getIntent().getStringExtra("receiver_nick_name");
        this.pRx = getIntent().getStringExtra("receiver_true_name");
        this.pQW = getIntent().getStringExtra("mch_name");
        this.pQX = getIntent().getStringExtra("mch_info");
        this.obL = getIntent().getIntExtra("pay_channel", 0);
        this.pRC = bo.bc(getIntent().getStringExtra("rcvr_open_id"), "");
        ab.i("MicroMsg.RemittanceBaseUI", "mUserName %s", this.edV);
        g.RQ();
        long longValue = ((Long) g.RP().Ry().get(147457, Long.valueOf(0))).longValue();
        if ((16 & longValue) != 0) {
            this.pRB = 1;
        } else if ((longValue & 32) != 0) {
            this.pRB = 2;
        } else {
            this.pRB = 0;
        }
        cfz();
        o.acd().a((com.tencent.mm.ah.d.a) this);
        initView();
        this.pRW.dnU();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.pRL);
        o.acd().b(this);
        this.pRW.dead();
        this.pRR.dead();
        com.tencent.mm.plugin.wallet.pay.a.b.acr(this.cEW);
    }

    public void cfA() {
        m tVar = new t(this.edV, this.pRb);
        tVar.eHT = "RemittanceProcess";
        a(tVar, true, true);
    }

    public void cfB() {
    }

    public final void initView() {
        if (this.pQY == 33 || this.pQY == 32) {
            setMMTitle((int) R.string.dnw);
        } else {
            setMMTitle((int) R.string.dqi);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44825);
                if (RemittanceBaseUI.this.gOW == 1 || RemittanceBaseUI.this.gOW == 6) {
                    RemittanceBaseUI.this.cfA();
                    RemittanceBaseUI.this.finish();
                } else if (RemittanceBaseUI.this.gOW == 2 || RemittanceBaseUI.this.gOW == 5) {
                    RemittanceBaseUI.this.finish();
                } else {
                    RemittanceBaseUI.this.cfM();
                }
                RemittanceBaseUI.this.cfB();
                AppMethodBeat.o(44825);
                return true;
            }
        });
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.akz);
        this.nTi = findViewById(R.id.aky);
        this.nsk = (ScrollView) findViewById(R.id.ih);
        this.pRc = (ImageView) findViewById(R.id.e1t);
        this.pRd = (TextView) findViewById(R.id.e1u);
        this.pRe = (TextView) findViewById(R.id.e1v);
        this.pRe.setVisibility(8);
        this.pRm = (LinearLayout) findViewById(R.id.e1w);
        this.pRl = (LinearLayout) findViewById(R.id.e1x);
        this.pRj = (TextView) findViewById(R.id.e20);
        this.pRk = (TextView) findViewById(R.id.e1z);
        this.pRi = (TextView) findViewById(R.id.e1y);
        if (bo.gW(this.pQZ, 0)) {
            this.pRn = (LinearLayout) findViewById(R.id.e0d);
            this.pRo = (TextView) findViewById(R.id.e0g);
            this.pRp = (TextView) findViewById(R.id.e0h);
        }
        cfH();
        cfJ();
        this.gHn = (Button) findViewById(R.id.ay8);
        this.gHn.setOnClickListener(new s() {
            public final void bgW() {
                AppMethodBeat.i(44836);
                if (RemittanceBaseUI.this.pQY == 33) {
                    RemittanceBaseUI.this.a(RemittanceBaseUI.this.eeO, RemittanceBaseUI.this.pQZ, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.pdC, RemittanceBaseUI.this.pRs, RemittanceBaseUI.this.pRu, "", null);
                } else {
                    RemittanceBaseUI.this.pQV = bo.getDouble(RemittanceBaseUI.this.kGa.getText(), 0.0d);
                    if (!RemittanceBaseUI.this.kGa.asa()) {
                        com.tencent.mm.ui.base.t.makeText(RemittanceBaseUI.this.mController.ylL, R.string.f9y, 0).show();
                    } else if (RemittanceBaseUI.this.pQV < 0.01d) {
                        RemittanceBaseUI.this.cfC();
                    } else {
                        RemittanceBaseUI.this.aoB();
                        RemittanceBaseUI.cfO();
                        RemittanceBaseUI.this.a(RemittanceBaseUI.this.eeO, RemittanceBaseUI.this.pQZ, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.pdC, RemittanceBaseUI.this.pRs, null, "", null);
                    }
                }
                if (RemittanceBaseUI.this.pPt == 0.0d) {
                    if (RemittanceBaseUI.this.gOW == 1) {
                        h.pYm.e(12689, Integer.valueOf(15), Integer.valueOf(1));
                    } else {
                        h.pYm.e(12689, Integer.valueOf(6), Integer.valueOf(1));
                    }
                }
                if (RemittanceBaseUI.this.gOW == 1 && !bo.isNullOrNil(RemittanceBaseUI.this.eeO)) {
                    h.pYm.e(14074, Integer.valueOf(2));
                }
                AppMethodBeat.o(44836);
            }
        });
        this.pRg = (TextView) findViewById(R.id.ay6);
        this.pRh = (TextView) findViewById(R.id.e21);
        if (this.gOW == 1 || this.gOW == 6) {
            this.pRh.setText(R.string.dni);
        } else {
            this.pRh.setText(R.string.dnh);
        }
        if (!r.YM()) {
            findViewById(R.id.ay5).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    String string;
                    String string2;
                    AppMethodBeat.i(44853);
                    RemittanceBaseUI.this.aoB();
                    RemittanceBaseUI.cfO();
                    h.pYm.e(12689, Integer.valueOf(9), Integer.valueOf(1));
                    if (RemittanceBaseUI.this.gOW == 1 || RemittanceBaseUI.this.gOW == 6) {
                        string = RemittanceBaseUI.this.getString(R.string.dni);
                        string2 = RemittanceBaseUI.this.getString(R.string.do7);
                        h.pYm.e(14074, Integer.valueOf(1));
                    } else {
                        string = RemittanceBaseUI.this.getString(R.string.dnh);
                        string2 = RemittanceBaseUI.this.getString(R.string.dnn);
                        if (bo.gW(RemittanceBaseUI.this.pQZ, 0) && RemittanceBaseUI.this.pRa) {
                            com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, string, RemittanceBaseUI.this.eeO, string2, RemittanceBaseUI.this.pRt, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.pdC, RemittanceBaseUI.this.pRs, new com.tencent.mm.plugin.wallet_core.ui.view.a.a() {
                                public final boolean a(boolean z, String str, String str2, String str3, String str4) {
                                    AppMethodBeat.i(44847);
                                    RemittanceBaseUI.this.pRt = z;
                                    if (bo.isNullOrNil(str)) {
                                        RemittanceBaseUI.this.eeO = null;
                                    } else {
                                        RemittanceBaseUI.this.eeO = str;
                                    }
                                    if (RemittanceBaseUI.this.pRt) {
                                        RemittanceBaseUI.this.mName = null;
                                        RemittanceBaseUI.this.pdC = null;
                                        RemittanceBaseUI.this.pRs = null;
                                    } else {
                                        if (bo.isNullOrNil(str2)) {
                                            RemittanceBaseUI.this.mName = null;
                                        } else {
                                            RemittanceBaseUI.this.mName = str2;
                                        }
                                        if (bo.isNullOrNil(str3)) {
                                            RemittanceBaseUI.this.pdC = null;
                                        } else {
                                            RemittanceBaseUI.this.pdC = str3;
                                        }
                                        if (bo.isNullOrNil(str4)) {
                                            RemittanceBaseUI.this.pRs = null;
                                        } else {
                                            RemittanceBaseUI.this.pRs = str4;
                                        }
                                    }
                                    RemittanceBaseUI.c(RemittanceBaseUI.this);
                                    RemittanceBaseUI.d(RemittanceBaseUI.this);
                                    AppMethodBeat.o(44847);
                                    return true;
                                }
                            }, new e.c() {
                                public final void d(boolean z, String str) {
                                    AppMethodBeat.i(44849);
                                    al.n(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(44848);
                                            RemittanceBaseUI.this.aqX();
                                            AppMethodBeat.o(44848);
                                        }
                                    }, 500);
                                    AppMethodBeat.o(44849);
                                }
                            });
                            AppMethodBeat.o(44853);
                            return;
                        }
                    }
                    com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, string, RemittanceBaseUI.this.eeO, string2, 20, new com.tencent.mm.ui.base.h.b() {
                        public final boolean s(CharSequence charSequence) {
                            AppMethodBeat.i(44850);
                            if (bo.isNullOrNil(charSequence.toString())) {
                                RemittanceBaseUI.this.eeO = null;
                                RemittanceBaseUI.d(RemittanceBaseUI.this);
                            } else {
                                RemittanceBaseUI.this.eeO = charSequence.toString();
                                RemittanceBaseUI.d(RemittanceBaseUI.this);
                            }
                            AppMethodBeat.o(44850);
                            return true;
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(44852);
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(44851);
                                    RemittanceBaseUI.this.aqX();
                                    AppMethodBeat.o(44851);
                                }
                            }, 500);
                            AppMethodBeat.o(44852);
                        }
                    });
                    AppMethodBeat.o(44853);
                }
            });
        }
        if (this.gOW == 1) {
            g.RQ();
            if (((String) g.RP().Ry().get(327732, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.dpb, (int) R.string.dpc, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                g.RQ();
                g.RP().Ry().set(327732, (Object) "1");
                g.RQ();
                g.RP().Ry().dsb();
            }
        }
        this.pRf = (TextView) findViewById(R.id.e22);
        this.pRq = (LinearLayout) findViewById(R.id.e25);
        this.pRr = (LinearLayout) findViewById(R.id.ay3);
        cfF();
        cfG();
        cfE();
        if (this.pQY != 33 && this.pQY != 32) {
            cfD();
        }
    }

    private void cfD() {
        if (bo.gW(this.pQZ, 0)) {
            this.pRq.setVisibility(4);
            this.nTi.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    int[] iArr;
                    int measuredHeight;
                    AppMethodBeat.i(44859);
                    int height = ((WindowManager) RemittanceBaseUI.this.getSystemService("window")).getDefaultDisplay().getHeight();
                    int[] iArr2 = new int[2];
                    if (RemittanceBaseUI.this.pRr.getTag(RemittanceBaseUI.this.pRr.getId()) == null) {
                        RemittanceBaseUI.this.pRr.getLocationOnScreen(iArr2);
                        RemittanceBaseUI.this.pRr.setTag(RemittanceBaseUI.this.pRr.getId(), iArr2);
                        iArr = iArr2;
                    } else {
                        iArr = (int[]) RemittanceBaseUI.this.pRr.getTag(RemittanceBaseUI.this.pRr.getId());
                    }
                    int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(RemittanceBaseUI.this, 40) + (iArr[1] + RemittanceBaseUI.this.pRr.getMeasuredHeight());
                    if (RemittanceBaseUI.this.nTi.getVisibility() == 0) {
                        measuredHeight = RemittanceBaseUI.this.nTi.getMeasuredHeight();
                    } else {
                        measuredHeight = 0;
                    }
                    int fromDPToPix2 = com.tencent.mm.bz.a.fromDPToPix(RemittanceBaseUI.this, 96) + measuredHeight;
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) RemittanceBaseUI.this.pRq.getLayoutParams();
                    if (height - fromDPToPix >= RemittanceBaseUI.this.pRq.getMeasuredHeight() + fromDPToPix2) {
                        marginLayoutParams.topMargin = (((height - fromDPToPix2) - RemittanceBaseUI.this.pRq.getMeasuredHeight()) - iArr[1]) - RemittanceBaseUI.this.pRr.getMeasuredHeight();
                    } else {
                        marginLayoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(RemittanceBaseUI.this, 40);
                    }
                    marginLayoutParams.bottomMargin = com.tencent.mm.bz.a.fromDPToPix(RemittanceBaseUI.this, 96);
                    RemittanceBaseUI.this.pRq.setLayoutParams(marginLayoutParams);
                    RemittanceBaseUI.this.pRq.setVisibility(0);
                    RemittanceBaseUI.this.pRq.requestLayout();
                    AppMethodBeat.o(44859);
                }
            });
        }
    }

    private void cfE() {
        if (!cfK() || bo.isNullOrNil(this.pRz) || this.pRB == 0 || this.pRA != 1) {
            this.mController.removeAllOptionMenu();
        } else {
            addIconOptionMenu(0, R.drawable.bli, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(44860);
                    com.tencent.mm.wallet_core.ui.e.n(RemittanceBaseUI.this.mController.ylL, RemittanceBaseUI.this.pRz, false);
                    AppMethodBeat.o(44860);
                    return false;
                }
            });
        }
    }

    private void cfF() {
        if (bo.isNullOrNil(this.pRy) || this.pRB == 0) {
            this.pRf.setText("");
            this.pRf.setVisibility(8);
            return;
        }
        int i;
        if (this.pRB == 1) {
            i = 2;
        } else {
            i = 24;
        }
        try {
            this.pRf.setText(String.format(this.pRy, new Object[]{Integer.valueOf(i)}));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.RemittanceBaseUI", e, "", new Object[0]);
            this.pRf.setText(getString(R.string.dph, new Object[]{Integer.valueOf(i)}));
        }
        this.pRf.setVisibility(0);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cfH() {
        int i;
        CharSequence eK = com.tencent.mm.wallet_core.ui.e.eK(com.tencent.mm.wallet_core.ui.e.mJ(this.edV), 10);
        if (!bo.isNullOrNil(this.pRx)) {
            eK = getString(R.string.do0, new Object[]{eK, this.pRx});
        }
        String stringExtra;
        if (this.gOW == 1) {
            stringExtra = getIntent().getStringExtra("receiver_tips");
            this.pRd.setTextColor(getResources().getColor(R.color.h4));
            this.pRe.setVisibility(0);
            if (bo.isNullOrNil(this.edV)) {
                eK = getString(R.string.do3, new Object[]{this.pRx});
            } else {
                eK = getString(R.string.do2, new Object[]{com.tencent.mm.wallet_core.ui.e.eK(com.tencent.mm.wallet_core.ui.e.mJ(this.edV), 10), this.pRx});
            }
            this.pRe.setText(j.b((Context) this, eK, this.pRe.getTextSize()));
            eK = stringExtra;
        } else if (this.gOW == 6) {
            stringExtra = getIntent().getStringExtra("receiver_tips");
            if (bo.isNullOrNil(stringExtra)) {
                eK = getString(R.string.do1, new Object[]{eK});
            } else {
                eK = bo.t(stringExtra, eK);
            }
        }
        this.pRd.setText(j.b((Context) this, eK, this.pRd.getTextSize()));
        if (g.RK()) {
            i act = o.act();
            if (!(act == null || bo.isNullOrNil(this.edV))) {
                com.tencent.mm.ah.h qo = act.qo(this.edV);
                if (qo == null || bo.isNullOrNil(qo.acl())) {
                    final long anU = bo.anU();
                    com.tencent.mm.model.ao.a.flu.a(this.edV, "", new com.tencent.mm.model.ao.b.a() {
                        public final void o(String str, boolean z) {
                            AppMethodBeat.i(44861);
                            if (z) {
                                ab.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bo.anU() - anU) + " ms");
                                com.tencent.mm.ah.b.U(str, 3);
                            } else {
                                ab.w("MicroMsg.RemittanceBaseUI", "getContact failed");
                            }
                            RemittanceBaseUI.this.cfI();
                            AppMethodBeat.o(44861);
                        }
                    });
                    i = 1;
                    if (i != 0) {
                        cfI();
                        return;
                    }
                    return;
                }
            }
        }
        i = 0;
        if (i != 0) {
        }
    }

    private void cfI() {
        final AnonymousClass31 anonymousClass31 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(44862);
                Bitmap a = com.tencent.mm.ah.b.a(RemittanceBaseUI.this.edV, false, -1);
                if (a == null) {
                    RemittanceBaseUI.this.pRc.setImageResource(R.drawable.ad2);
                    AppMethodBeat.o(44862);
                    return;
                }
                RemittanceBaseUI.this.pRc.setImageBitmap(a);
                AppMethodBeat.o(44862);
            }
        };
        if (al.isMainThread()) {
            anonymousClass31.run();
        } else {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(44863);
                    anonymousClass31.run();
                    AppMethodBeat.o(44863);
                }
            });
        }
    }

    private void cfJ() {
        this.kGa = (WalletFormView) findViewById(R.id.ay4);
        if (this.pQY == 33) {
            this.pRj.setText(com.tencent.mm.wallet_core.ui.e.F(this.pQV));
            this.pRk.setText(ae.dOd());
            this.pRu = getIntent().getStringExtra("desc");
            if (bo.isNullOrNil(this.pRu)) {
                this.pRi.setVisibility(8);
            } else {
                this.pRi.setText(j.b(this.mController.ylL, this.pRu, this.pRi.getTextSize()));
                this.pRi.setVisibility(0);
            }
            this.pRl.setVisibility(0);
            this.pRm.setVisibility(8);
            return;
        }
        this.kGa.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44826);
                RemittanceBaseUI.this.aoB();
                RemittanceBaseUI.cfO();
                AppMethodBeat.o(44826);
            }
        });
        this.kGa.getTitleTv().setText(String.format(getString(R.string.dp9), new Object[]{"¥"}));
        this.kGa.a(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(44827);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                AppMethodBeat.o(44827);
            }
        });
        e(this.kGa, 2, false);
        findViewById(R.id.e22);
        findViewById(R.id.ay3).setVisibility(0);
        this.pRl.setVisibility(8);
        this.pRm.setVisibility(0);
        this.obM = new com.tencent.mm.wallet_core.ui.a() {
            public final void ic(boolean z) {
                AppMethodBeat.i(44828);
                if (z) {
                    RemittanceBaseUI.this.b(RemittanceBaseUI.this.nsk, RemittanceBaseUI.this.gHn, 30);
                    AppMethodBeat.o(44828);
                    return;
                }
                RemittanceBaseUI.this.nsk.scrollTo(0, 0);
                AppMethodBeat.o(44828);
            }
        };
    }

    public boolean c(int i, int i2, String str, m mVar) {
        this.pRE = "";
        if (i == 0 && i2 == 0) {
            if (mVar instanceof v) {
                v vVar = (v) mVar;
                ad.o(this.pQY, vVar.cBT, i2);
                this.pRw = vVar.pPo;
                if (!bo.isNullOrNil(vVar.pPw)) {
                    this.pRx = vVar.pPw;
                }
                if (this.pQY == 32 || this.pQY == 33) {
                    this.pRG = vVar.kBE;
                } else {
                    this.pRG = vVar.cEa;
                }
                if (this.pQU != null) {
                    this.pQU.i(Downloads.MIN_WAIT_FOR_NETWORK, Integer.valueOf(this.pQY), this.edV, Double.valueOf(vVar.pPz));
                }
                String str2 = vVar.pPM == null ? "" : bo.isNullOrNil(vVar.pPM.pRD) ? this.pRD : vVar.pPM.pRD;
                this.pRD = str2;
                if (!a(vVar)) {
                    a(vVar.cBT, this.edV, this.pRx, vVar);
                }
                this.pRF.put(vVar.cBT, new a(vVar.pPx, vVar.kBE, vVar.kDV, vVar.pPy, vVar.nUf, vVar.cEa, vVar.cAa, vVar.pPC, bo.getLong(vVar.pPA, 0)));
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.ad) {
                com.tencent.mm.plugin.wallet_core.c.ad adVar = (com.tencent.mm.plugin.wallet_core.c.ad) mVar;
                if (!bo.isNullOrNil(adVar.tuy)) {
                    ((TextView) findViewById(R.id.e24)).setText(adVar.tuy);
                    View findViewById = findViewById(R.id.e23);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(44829);
                            f.a(RemittanceBaseUI.this, RemittanceBaseUI.this.gOW, RemittanceBaseUI.this.pRv, RemittanceBaseUI.this.pPt);
                            if (RemittanceBaseUI.this.gOW == 1) {
                                h.pYm.e(12689, Integer.valueOf(13), Integer.valueOf(1));
                                AppMethodBeat.o(44829);
                                return;
                            }
                            h.pYm.e(12689, Integer.valueOf(4), Integer.valueOf(1));
                            AppMethodBeat.o(44829);
                        }
                    });
                }
                this.pRv = adVar.pRv;
                this.pPt = adVar.pPt;
                if (this.pPt == 0.0d) {
                    if (this.gOW == 1) {
                        h.pYm.e(12689, Integer.valueOf(14), Integer.valueOf(1));
                    } else {
                        h.pYm.e(12689, Integer.valueOf(5), Integer.valueOf(1));
                    }
                }
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.ae) {
                this.pRy = ((com.tencent.mm.plugin.wallet_core.c.ae) mVar).tuA;
                this.pRz = ((com.tencent.mm.plugin.wallet_core.c.ae) mVar).tuE;
                this.pRA = ((com.tencent.mm.plugin.wallet_core.c.ae) mVar).tuF;
                cfF();
                cfE();
            }
            return true;
        }
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.ae) {
            ab.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
            this.pRf.setText("");
            this.pRf.setVisibility(8);
        } else if (mVar instanceof v) {
            this.pRI = (v) mVar;
            com.tencent.mm.sdk.b.a.xxA.b(this.pRL);
            ad.o(this.pQY, "", i2);
            if (c((v) mVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(v vVar) {
        boolean z;
        if (this.pRM) {
            z = false;
        } else {
            z = d(vVar);
        }
        if (!(z || this.pRN)) {
            z = e(vVar);
        }
        if (!(z || this.pRO)) {
            z = f(vVar);
        }
        if (!(z || this.pRP)) {
            z = c(vVar);
        }
        if (z || bo.isNullOrNil(vVar.pPA) || bo.isNullOrNil(vVar.pPB)) {
            return z;
        }
        String eK = com.tencent.mm.wallet_core.ui.e.eK(com.tencent.mm.wallet_core.ui.e.mJ(this.edV), 10);
        if (!bo.isNullOrNil(this.pRx)) {
            eK = getString(R.string.do0, new Object[]{eK, this.pRx});
        }
        return a(vVar.cBT, vVar.pPB, eK, vVar.pPA, vVar);
    }

    private static boolean b(v vVar) {
        if (vVar.pPL == 1 && vVar.pPM != null) {
            return true;
        }
        if (vVar.pPM == null || vVar.pPM.vYN <= 0) {
            return false;
        }
        return true;
    }

    private boolean c(final v vVar) {
        if (vVar.cMO == null || !vVar.cMO.cPa()) {
            return false;
        }
        this.pRP = true;
        com.tencent.mm.ui.base.h.d(this, vVar.cMO.cEh, "", vVar.cMO.nZc, vVar.cMO.nZb, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(44832);
                ab.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", vVar.cMO.kCs);
                com.tencent.mm.wallet_core.ui.e.n(RemittanceBaseUI.this.mController.ylL, vVar.cMO.kCs, false);
                AppMethodBeat.o(44832);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return true;
    }

    private boolean d(final v vVar) {
        if (bo.isNullOrNil(vVar.pPn)) {
            return false;
        }
        this.pRM = true;
        aY(1, vVar.cEa);
        com.tencent.mm.ui.base.h.d(this, vVar.pPn, getString(R.string.t6), getString(R.string.do6), getString(R.string.or), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(44833);
                RemittanceBaseUI.this.aY(3, vVar.cEa);
                if (!RemittanceBaseUI.this.a(vVar)) {
                    RemittanceBaseUI.this.a(vVar.cBT, RemittanceBaseUI.this.edV, RemittanceBaseUI.this.pRx, vVar);
                }
                AppMethodBeat.o(44833);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(44834);
                RemittanceBaseUI.this.aY(2, vVar.cEa);
                AppMethodBeat.o(44834);
            }
        });
        return true;
    }

    private void aY(int i, String str) {
        this.pRJ = new bh();
        this.pRJ.cVR = 2;
        this.pRJ.cVS = (long) i;
        this.pRJ.gd(str);
        this.pRJ.ajK();
    }

    private boolean e(final v vVar) {
        if (vVar.pPl <= 0) {
            return false;
        }
        this.pRN = true;
        if (vVar.pPm != null) {
            String string;
            String string2;
            if (bo.isNullOrNil(vVar.pPm.cEh)) {
                string = getString(R.string.dq1, new Object[]{Integer.valueOf(vVar.pPl)});
            } else {
                string = vVar.pPm.cEh;
            }
            String str = "";
            String string3 = getString(R.string.do6);
            if (bo.isNullOrNil(vVar.pPm.pPN)) {
                string2 = getString(R.string.dpq);
            } else {
                string2 = vVar.pPm.pPN;
            }
            a(this, string, str, string3, string2, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(44835);
                    if (!RemittanceBaseUI.this.a(vVar)) {
                        RemittanceBaseUI.this.a(vVar.cBT, RemittanceBaseUI.this.edV, RemittanceBaseUI.this.pRx, vVar);
                    }
                    AppMethodBeat.o(44835);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(44837);
                    if (bo.isNullOrNil(vVar.pPm.pPO)) {
                        com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
                        AppMethodBeat.o(44837);
                        return;
                    }
                    com.tencent.mm.plugin.account.a.b.a.b(RemittanceBaseUI.this, vVar.pPm.pPO, 5, true);
                    AppMethodBeat.o(44837);
                }
            });
        } else {
            ab.i("MicroMsg.RemittanceBaseUI", "scene.zaituMessage == null");
            a(this, getString(R.string.dq1, new Object[]{Integer.valueOf(vVar.pPl)}), getString(R.string.t6), getString(R.string.do6), getString(R.string.dpq), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(44838);
                    if (!RemittanceBaseUI.this.a(vVar)) {
                        RemittanceBaseUI.this.a(vVar.cBT, RemittanceBaseUI.this.edV, RemittanceBaseUI.this.pRx, vVar);
                    }
                    AppMethodBeat.o(44838);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(44839);
                    com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
                    AppMethodBeat.o(44839);
                }
            });
        }
        return true;
    }

    private static void a(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
        aVar.asD(str2);
        aVar.asE(str);
        aVar.asJ(str3).a(onClickListener);
        aVar.asK(str4).b(onClickListener2);
        aVar.rc(false);
        aVar.rd(true);
        com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
        aMb.show();
        com.tencent.mm.ui.base.h.a(context, aMb);
    }

    private boolean f(final v vVar) {
        if (!vVar.pPs) {
            return false;
        }
        this.pRO = true;
        f.a(this, this.gOW, vVar.pPv / 100.0d, vVar.pPu / 100.0d, vVar.pPp / 100.0d, vVar.pPr, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44840);
                RemittanceBaseUI.this.a(vVar.cBT, RemittanceBaseUI.this.edV, RemittanceBaseUI.this.pRx, vVar);
                if (RemittanceBaseUI.this.gOW == 1) {
                    h.pYm.e(12689, Integer.valueOf(12), Integer.valueOf(1));
                    AppMethodBeat.o(44840);
                    return;
                }
                h.pYm.e(12689, Integer.valueOf(3), Integer.valueOf(1));
                AppMethodBeat.o(44840);
            }
        });
        return true;
    }

    private static void VT(String str) {
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
            return;
        }
        String decode = URLDecoder.decode(str);
        ab.i("MicroMsg.RemittanceBaseUI", "helios:".concat(String.valueOf(decode)));
        String str2 = (String) br.z(decode, "msg").get(".msg.appmsg.wcpayinfo.transferid");
        if (TextUtils.isEmpty(str2)) {
            ab.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
            return;
        }
        aa ceZ = com.tencent.mm.plugin.remittance.a.c.ceW().ceZ();
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(decode)) {
            ab.e(aa.TAG, "saveMsgContent param error");
        } else {
            ceZ.pQD.put(str2, decode);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cfK() {
        return this.gOW == 0 || this.gOW == 2;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        boolean z2 = false;
        ab.i("MicroMsg.RemittanceBaseUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.edV);
        switch (i) {
            case 1:
                if (i2 != -1) {
                    z = false;
                }
                a(z, intent);
                break;
            case 2:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bo.isNullOrNil(stringExtra)) {
                        this.edV = stringExtra;
                        cfH();
                        break;
                    }
                    finish();
                    break;
                }
                finish();
                break;
                break;
            case 5:
                if (i2 == -1) {
                    z2 = true;
                }
                a(z2, intent);
                break;
            case 6:
                if (i2 == -1 && intent != null) {
                    aoB();
                    String string = getString(R.string.a4w);
                    String string2 = getString(R.string.do7);
                    String stringExtra2 = intent.getStringExtra("userName");
                    String stringExtra3 = intent.getStringExtra("telNumber");
                    String str = intent.getStringExtra("proviceFirstStageName") + intent.getStringExtra("addressCitySecondStageName") + intent.getStringExtra("addressCountiesThirdStageName") + intent.getStringExtra("addressDetailInfo");
                    com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, string, this.eeO, string2, false, stringExtra2, stringExtra3, str, new com.tencent.mm.plugin.wallet_core.ui.view.a.a() {
                        public final boolean a(boolean z, String str, String str2, String str3, String str4) {
                            AppMethodBeat.i(44841);
                            RemittanceBaseUI.this.pRt = z;
                            if (bo.isNullOrNil(str)) {
                                RemittanceBaseUI.this.eeO = null;
                            } else {
                                RemittanceBaseUI.this.eeO = str;
                            }
                            if (!RemittanceBaseUI.this.pRt) {
                                if (bo.isNullOrNil(str2)) {
                                    RemittanceBaseUI.this.mName = null;
                                } else {
                                    RemittanceBaseUI.this.mName = str2;
                                }
                                if (bo.isNullOrNil(str3)) {
                                    RemittanceBaseUI.this.pdC = null;
                                } else {
                                    RemittanceBaseUI.this.pdC = str3;
                                }
                                if (bo.isNullOrNil(str4)) {
                                    RemittanceBaseUI.this.pRs = null;
                                } else {
                                    RemittanceBaseUI.this.pRs = str4;
                                }
                            }
                            RemittanceBaseUI.c(RemittanceBaseUI.this);
                            RemittanceBaseUI.d(RemittanceBaseUI.this);
                            AppMethodBeat.o(44841);
                            return true;
                        }
                    }, new e.c() {
                        public final void d(boolean z, String str) {
                            AppMethodBeat.i(44843);
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(44842);
                                    RemittanceBaseUI.this.aqX();
                                    AppMethodBeat.o(44842);
                                }
                            }, 500);
                            AppMethodBeat.o(44843);
                        }
                    });
                    break;
                }
        }
        super.onActivityResult(i, i2, intent);
    }

    private void a(boolean z, Intent intent) {
        if (z) {
            if (this.pRH) {
                h.pYm.e(15386, Integer.valueOf(3), Integer.valueOf(1));
            }
            String stringExtra = intent.getStringExtra("key_trans_id");
            if (bo.isNullOrNil(this.pRG)) {
                this.pRG = stringExtra;
            }
            if (!(this.pQY == 33 || this.pQY == 32)) {
                com.tencent.mm.plugin.remittance.model.ab.VQ(this.edV);
            }
            if (this.pPt == 0.0d) {
                if (this.gOW == 1) {
                    h.pYm.e(12689, Integer.valueOf(17), Integer.valueOf(1));
                } else {
                    h.pYm.e(12689, Integer.valueOf(8), Integer.valueOf(1));
                }
            }
            finish();
        } else if (com.tencent.mm.plugin.wallet_core.utils.c.aw(intent)) {
            finish();
            return;
        } else if (!com.tencent.mm.plugin.wallet_core.utils.c.ax(intent)) {
            if (this.gOW == 1) {
                h.pYm.e(12689, Integer.valueOf(16), Integer.valueOf(1));
            } else {
                h.pYm.e(12689, Integer.valueOf(7), Integer.valueOf(1));
            }
        } else {
            return;
        }
        if (bo.gW(this.pQZ, 0)) {
            b(z, intent);
        }
    }

    private void a(v vVar, rn rnVar) {
        this.pRK = true;
        c cVar = new c(this);
        cVar.pQJ = new com.tencent.mm.plugin.remittance.ui.c.a() {
            public final void VS(String str) {
                AppMethodBeat.i(44844);
                ab.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", str);
                RemittanceBaseUI.this.pRE = str;
                RemittanceBaseUI.this.cfL();
                AppMethodBeat.o(44844);
            }

            public final void onCancel() {
                RemittanceBaseUI.this.pRE = "";
            }
        };
        cVar.pPM = rnVar;
        View inflate = View.inflate(cVar.mContext, R.layout.an8, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dw3);
        EditText editText = (EditText) inflate.findViewById(R.id.dw2);
        ((MMNeat7extView) inflate.findViewById(R.id.m5)).ah(cVar.pPM.cEh);
        textView.setText(rnVar.pcw);
        com.tencent.mm.ui.widget.a.e.a aVar = new com.tencent.mm.ui.widget.a.e.a(cVar.mContext);
        aVar.al(cVar.pPM.title).fo(inflate);
        com.tencent.mm.ui.tools.b.c d = com.tencent.mm.ui.tools.b.c.d(editText);
        d.jeZ = com.tencent.mm.ui.tools.f.a.MODE_CHINESE_AS_1;
        d = d.hz(1, 1);
        d.zIx = false;
        d.a(null);
        al.n(new com.tencent.mm.plugin.remittance.ui.c.AnonymousClass1(editText), 200);
        bl blVar = new bl();
        blVar.dcq = (long) vVar.nUf;
        blVar = blVar.ge(vVar.username);
        blVar.dck = 1;
        blVar.ajK();
        aVar.c(new com.tencent.mm.plugin.remittance.ui.c.AnonymousClass2(vVar, editText)).show();
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(String str, String str2, String str3, v vVar) {
        bl blVar;
        if (!b(vVar)) {
            if (this.pRK) {
                blVar = new bl();
                blVar.dcq = (long) vVar.nUf;
                blVar = blVar.ge(vVar.username);
                blVar.dck = 5;
                blVar.ajK();
            }
            this.pRK = false;
            if (this.pQY == 31) {
                VT(this.pRw);
            }
            PayInfo payInfo = new PayInfo();
            payInfo.czZ = str;
            payInfo.cIf = this.pQY;
            if (this.obL > 0) {
                payInfo.cIb = this.obL;
            }
            boolean z = false;
            if (this.gOW == 2 || this.gOW == 5) {
                z = true;
            }
            Bundle bundle = new Bundle();
            bundle.putString("extinfo_key_1", str2);
            bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
            bundle.putString("extinfo_key_3", this.pRu);
            bundle.putBoolean("extinfo_key_4", z);
            bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
            bundle.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
            bundle.putString("extinfo_key_7", this.eeO);
            bundle.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
            bundle.putString("extinfo_key_16", this.pRG);
            if (vVar != null) {
                bundle.putString("extinfo_key_19", vVar.pPJ);
            }
            int i = 0;
            if (this.gOW == 1 && vVar != null) {
                bundle.putString("extinfo_key_11", vVar.pPx);
                bundle.putInt("extinfo_key_12", vVar.pPD);
                bundle.putString("extinfo_key_13", vVar.pPE);
                bundle.putString("extinfo_key_14", vVar.pPF);
                bundle.putString("extinfo_key_17", vVar.pPH);
                bundle.putString("extinfo_key_18", vVar.pPI);
                i = vVar.pPG;
            }
            if (vVar != null) {
                bundle.putInt("extinfo_key_15", vVar.nUf);
            }
            if (this.pRa) {
                bundle.putBoolean("extinfo_key_23", this.pRa);
                bundle.putString("extinfo_key_24", this.mName);
                bundle.putString("extinfo_key_25", this.pdC);
                bundle.putString("extinfo_key_26", this.pRs);
            }
            payInfo.vwh = bundle;
            Intent intent = new Intent();
            ab.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", Integer.valueOf(i));
            if (i == 1) {
                intent.setClass(this, RemittanceF2fDynamicCodeUI.class);
                intent.putExtra("key_pay_info", payInfo);
                intent.putExtra("key_rcvr_open_id", this.pRC);
                intent.putExtra("key_mch_info", this.pQX);
                intent.putExtra("from_patch_ui", true);
                intent.putExtra("get_dynamic_code_sign", vVar.pPH);
                intent.putExtra("get_dynamic_code_extend", vVar.pPI);
                intent.putExtra("dynamic_code_spam_wording", vVar.pPK);
                intent.putExtra("show_paying_wording", vVar.pPJ);
                intent.putExtra("key_transfer_qrcode_id", this.pRb);
                h.pYm.e(15386, Integer.valueOf(2), Integer.valueOf(1));
                this.pRR.dnU();
                startActivityForResult(intent, 5);
                return;
            }
            com.tencent.mm.plugin.wallet.a.a(this.pQU, intent);
            payInfo.vwp = this.cEW;
            payInfo.aPn = this.pRH;
            if (vVar.pOV == null || vVar.pOV.czT.czX == null) {
                com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", payInfo, str3, intent, 1);
                return;
            }
            com.tencent.mm.pluginsdk.wallet.h.a(vVar.pOV.czT.czX, false, "", payInfo, str3, intent, vVar.pOV.czT.czV);
        } else if (vVar.pPM.vYN == 0) {
            this.pRQ = vVar.pPM;
            a(vVar, vVar.pPM);
        } else if (vVar.pPM.vYN == 1) {
            blVar = new bl();
            blVar.dcq = (long) ((int) vVar.pPz);
            blVar = blVar.ge(vVar.username);
            blVar.dck = 4;
            blVar.ajK();
            String str4 = vVar.pPM.cEh;
            String str5 = vVar.pPM.title;
            String string = getResources().getString(R.string.dqm);
            String string2 = getResources().getString(R.string.dql);
            final v vVar2 = vVar;
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            AnonymousClass20 anonymousClass20 = new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(44845);
                    ab.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", RemittanceBaseUI.this.pRQ);
                    bl blVar = new bl();
                    blVar.dcq = (long) ((int) vVar2.pPz);
                    blVar = blVar.ge(vVar2.username);
                    blVar.dck = 9;
                    blVar.ajK();
                    vVar2.pPM = null;
                    RemittanceBaseUI.this.a(str6, str7, str8, vVar2);
                    AppMethodBeat.o(44845);
                }
            };
            final v vVar3 = vVar;
            com.tencent.mm.ui.base.h.a((Context) this, str4, str5, string, string2, (DialogInterface.OnClickListener) anonymousClass20, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(44846);
                    ab.i("MicroMsg.RemittanceBaseUI", "onClick1");
                    bl blVar = new bl();
                    blVar.dcq = (long) ((int) vVar3.pPz);
                    blVar = blVar.ge(vVar3.username);
                    blVar.dck = 8;
                    blVar.ajK();
                    AppMethodBeat.o(44846);
                }
            }, (int) R.color.xd);
        } else if (vVar.pPM.vYN == 2) {
            com.tencent.mm.ui.base.h.a((Context) this, vVar.pPM.cEh, vVar.pPM.title, getResources().getString(R.string.g0z), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cfL() {
        if (this.pQY == 33) {
            a(this.eeO, this.pQZ, this.mName, this.pdC, this.pRs, this.pRu, "", null);
            return;
        }
        a(this.eeO, this.pQZ, this.mName, this.pdC, this.pRs, null, "", null);
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    public void cfM() {
        Intent intent = new Intent();
        intent.putExtra("recent_remittance_contact_list", com.tencent.mm.plugin.remittance.model.ab.cfr());
        intent.setClass(this.mController.ylL, SelectRemittanceContactUI.class);
        startActivityForResult(intent, 2);
    }

    public void qj(String str) {
        ab.i("MicroMsg.RemittanceBaseUI", "onGet");
        if (bo.nullAsNil(str).length() <= 0) {
            ab.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = ".concat(String.valueOf(str)));
        } else if (str.equals(this.edV)) {
            cfI();
        }
    }

    public final boolean cfN() {
        if (this.pQY == 33 || this.pQY == 32) {
            return true;
        }
        return false;
    }

    private boolean a(final String str, String str2, String str3, String str4, final v vVar) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.aoo, null);
        TextView textView = (TextView) inflate.findViewById(R.id.e33);
        TextView textView2 = (TextView) inflate.findViewById(R.id.e34);
        ((TextView) inflate.findViewById(R.id.e32)).setText(str2);
        textView.setText(j.b((Context) this, (CharSequence) str3, textView.getTextSize()));
        Double valueOf = Double.valueOf(bo.getDouble(str4, 0.0d));
        textView2.setText(String.format("%s%.2f", new Object[]{ae.dOd(), Double.valueOf(valueOf.doubleValue() / 100.0d)}));
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
        aVar.rc(false);
        aVar.PV(R.string.dqd);
        aVar.fn(inflate);
        aVar.Qc(R.string.do6);
        aVar.Qd(R.string.abn);
        aVar.a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(44856);
                RemittanceBaseUI.this.a(str, RemittanceBaseUI.this.edV, RemittanceBaseUI.this.pRx, vVar);
                AppMethodBeat.o(44856);
            }
        });
        aVar.aMb().show();
        return true;
    }

    private void b(boolean z, Intent intent) {
        if (z) {
            this.cKs = 1;
        } else if (intent != null) {
            this.cKs = intent.getIntExtra("key_pay_reslut_type", 3);
            this.pRS = this.pQV;
            this.pRT = this.eeO;
            this.pRU = this.pRs;
            this.pRV = this.pRG;
        } else {
            return;
        }
        ab.i("MicroMsg.RemittanceBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", Integer.valueOf(this.cKs), Double.valueOf(this.pRS), this.pRT, this.pRU, this.pRV);
    }
}
