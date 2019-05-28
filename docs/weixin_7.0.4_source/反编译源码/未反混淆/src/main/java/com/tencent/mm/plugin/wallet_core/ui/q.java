package com.tencent.mm.plugin.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.soter.a.g.f;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public class q extends i implements d {
    private static HashMap<String, Boolean> tKp = new HashMap();
    protected OnCancelListener Ue;
    protected boolean gHY;
    public ImageView gvq;
    private boolean isPaused = false;
    public View jcl;
    private Context mContext;
    protected MyKeyboardWindow mKeyboard;
    private Animation msx;
    private int msy = 0;
    protected View nTi;
    public ImageView oft;
    protected PayInfo pGr;
    public TextView pUA;
    public TextView qcc;
    public ImageView tGW;
    public TextView tJA;
    public TextView tJB;
    public FavourLayout tJC;
    public CdnImageView tJD;
    public TextView tJE;
    public EditHintPasswdView tJF;
    public View tJH;
    public View tJI;
    public TextView tJJ;
    public ImageView tJK;
    public TextView tJL;
    public TextView tJM;
    public View tJN;
    public TextView tJO;
    protected OnClickListener tJQ;
    protected boolean tJR = false;
    protected boolean tJS = true;
    public Bankcard tJT = null;
    public TextView tJU;
    public View tJV;
    public TextView tJW;
    protected int tJX = 0;
    protected boolean tJY = false;
    private int tJZ = 0;
    private Animation tKa = null;
    private String tKb = "";
    private long tKc = -1;
    boolean tKf = false;
    public c tKk;
    public Button tKl;
    protected a tKm;
    protected int tKn = -1;
    private byte[] tKo = new byte[0];
    protected com.tencent.mm.plugin.wallet_core.utils.a tln = new com.tencent.mm.plugin.wallet_core.utils.a();
    protected FavorPayInfo toH = new FavorPayInfo();
    public TextView tpG;
    protected b tpu = null;

    static class b implements OnCancelListener {
        private OnCancelListener tKx;

        /* synthetic */ b(OnCancelListener onCancelListener, byte b) {
            this(onCancelListener);
        }

        private b(OnCancelListener onCancelListener) {
            this.tKx = null;
            this.tKx = onCancelListener;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(47604);
            q.np(false);
            if (this.tKx != null) {
                this.tKx.onCancel(dialogInterface);
            }
            AppMethodBeat.o(47604);
        }
    }

    public interface c {
        void a(String str, FavorPayInfo favorPayInfo, boolean z);
    }

    public interface a {
        void bXx();
    }

    static /* synthetic */ void cRS() {
        AppMethodBeat.i(47646);
        cRz();
        AppMethodBeat.o(47646);
    }

    static /* synthetic */ void d(q qVar) {
        AppMethodBeat.i(47645);
        qVar.cRN();
        AppMethodBeat.o(47645);
    }

    static /* synthetic */ void f(q qVar) {
        AppMethodBeat.i(47648);
        qVar.cRy();
        AppMethodBeat.o(47648);
    }

    static /* synthetic */ void np(boolean z) {
        AppMethodBeat.i(47650);
        nl(z);
        AppMethodBeat.o(47650);
    }

    public q(Context context) {
        super(context, R.style.zx);
        AppMethodBeat.i(47605);
        cA(context);
        AppMethodBeat.o(47605);
    }

    /* Access modifiers changed, original: protected */
    public void cA(Context context) {
        AppMethodBeat.i(47606);
        ab.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
        this.mContext = context;
        fl(context);
        fm(context);
        AppMethodBeat.o(47606);
    }

    /* Access modifiers changed, original: protected|final */
    public final void fl(Context context) {
        AppMethodBeat.i(47607);
        this.jcl = View.inflate(context, btU(), null);
        this.oft = (ImageView) this.jcl.findViewById(R.id.dlg);
        this.mKeyboard = (MyKeyboardWindow) this.jcl.findViewById(R.id.akz);
        this.nTi = this.jcl.findViewById(R.id.aky);
        this.qcc = (TextView) this.jcl.findViewById(R.id.m5);
        this.tJA = (TextView) this.jcl.findViewById(R.id.fg3);
        this.pUA = (TextView) this.jcl.findViewById(R.id.dlh);
        this.tpG = (TextView) this.jcl.findViewById(R.id.dli);
        this.tpG.getPaint().setFlags(16);
        this.tJB = (TextView) this.jcl.findViewById(R.id.d3s);
        this.tJC = (FavourLayout) this.jcl.findViewById(R.id.f9r);
        this.tJD = (CdnImageView) this.jcl.findViewById(R.id.fg_);
        this.tJH = this.jcl.findViewById(R.id.fg6);
        this.tJE = (TextView) this.jcl.findViewById(R.id.dll);
        this.gvq = (ImageView) this.jcl.findViewById(R.id.dle);
        this.tJI = this.jcl.findViewById(R.id.dlj);
        this.tJJ = (TextView) this.jcl.findViewById(R.id.fg9);
        com.tencent.mm.pluginsdk.ui.a.b.b(this.gvq, e.getUsername());
        this.tJF = (EditHintPasswdView) this.jcl.findViewById(R.id.cfs);
        this.tJK = (ImageView) this.jcl.findViewById(R.id.dlk);
        this.tJU = (TextView) this.jcl.findViewById(R.id.fg4);
        this.tJV = this.jcl.findViewById(R.id.f9y);
        this.tJW = (TextView) this.jcl.findViewById(R.id.f_0);
        this.tGW = (ImageView) this.jcl.findViewById(R.id.f9z);
        this.tJL = (TextView) this.jcl.findViewById(R.id.e2t);
        this.tJM = (TextView) this.jcl.findViewById(R.id.fg8);
        this.tJN = this.jcl.findViewById(R.id.fg5);
        this.tJO = (TextView) this.jcl.findViewById(R.id.fg7);
        this.tKl = (Button) this.jcl.findViewById(R.id.fgb);
        this.tJC.setVisibility(8);
        AppMethodBeat.o(47607);
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(14)
    public void fm(Context context) {
        AppMethodBeat.i(47608);
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.tJF);
        this.tJF.setOnInputValidListener(new com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(47587);
                if (z) {
                    q.this.cRO();
                    h.pYm.e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                }
                AppMethodBeat.o(47587);
            }
        });
        this.tJF.requestFocus();
        TextView textView = (TextView) this.jcl.findViewById(R.id.fg3);
        if (textView != null) {
            textView.setText(ae.ir(context));
        }
        EditText editText = (EditText) this.jcl.findViewById(R.id.d6);
        e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            com.tencent.mm.ui.a.c cVar = new com.tencent.mm.ui.a.c();
            this.mKeyboard.setSecureAccessibility(cVar);
            editText.setAccessibilityDelegate(cVar);
        }
        editText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47589);
                if (!q.this.nTi.isShown()) {
                    q.this.nTi.setVisibility(0);
                }
                AppMethodBeat.o(47589);
            }
        });
        this.jcl.findViewById(R.id.al0).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47590);
                if (q.this.nTi.isShown()) {
                    q.this.nTi.setVisibility(8);
                }
                AppMethodBeat.o(47590);
            }
        });
        this.tKl.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47591);
                q.a(q.this);
                AppMethodBeat.o(47591);
            }
        });
        AppMethodBeat.o(47608);
    }

    private void cRN() {
        AppMethodBeat.i(47609);
        if (this.tJX == 1) {
            this.tJU.setText(R.string.fez);
        } else {
            this.tJU.setText(R.string.fer);
        }
        this.tJX = 0;
        this.tKc = bo.yz();
        this.tJV.setVisibility(8);
        this.tKl.setVisibility(8);
        this.tJF.setVisibility(0);
        if (!this.nTi.isShown()) {
            this.nTi.setVisibility(0);
        }
        this.tJA.setText(R.string.fq4);
        nl(true);
        this.pGr.tKd = 0;
        h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        e.QS(29);
        cRz();
        AppMethodBeat.o(47609);
    }

    private void cRy() {
        AppMethodBeat.i(47610);
        com.tencent.mm.plugin.soter.d.a.cvP();
        final lv lvVar = new lv();
        lvVar.cHD.cBT = this.pGr.czZ;
        lvVar.cHD.cHF = 1;
        lvVar.cHD.cHH = new Runnable() {
            public final void run() {
                AppMethodBeat.i(47600);
                ab.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
                com.tencent.mm.g.a.lv.b bVar = lvVar.cHE;
                if (bVar == null) {
                    q.this.pGr.tKd = 0;
                    ab.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
                    AppMethodBeat.o(47600);
                    return;
                }
                int i = bVar.errCode;
                ab.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), bVar.aIm);
                PayInfo payInfo;
                if (i == 0) {
                    ab.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", bVar.cHI);
                    ad.e(q.this.pGr == null ? 0 : q.this.pGr.cIf, q.this.pGr == null ? "" : q.this.pGr.czZ, 22, "");
                    q.this.pGr.tKd = 1;
                    q.this.pGr.cBU = bVar.cBU;
                    q.this.pGr.cBV = bVar.cBV;
                    try {
                        JSONObject jSONObject = new JSONObject(((l) g.K(l.class)).bxi());
                        jSONObject.put("soter_type", r.cPI().cQm());
                        q.this.pGr.cHI = jSONObject.toString();
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.WalletPwdDialog", e, "", new Object[0]);
                    }
                    q.this.pGr.cBS = bVar.cBS;
                    payInfo = q.this.pGr;
                    payInfo.tKe++;
                    q.this.tJW.setText("");
                    q.this.cRO();
                    h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
                    com.tencent.mm.plugin.soter.d.a.EC(0);
                    AppMethodBeat.o(47600);
                    return;
                }
                int i2;
                String str;
                boolean z;
                ab.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                if (q.this.pGr == null) {
                    i2 = 0;
                } else {
                    i2 = q.this.pGr.cIf;
                }
                if (q.this.pGr == null) {
                    str = "";
                } else {
                    str = q.this.pGr.czZ;
                }
                ad.e(i2, str, 23, "");
                q.this.pGr.tKd = 0;
                q.this.tJV.setVisibility(0);
                q.this.tJW.setTextColor(q.this.getContext().getResources().getColor(R.color.xy));
                q.this.tJW.setText(R.string.fex);
                i2 = (int) (System.currentTimeMillis() / 1000);
                int g = i2 - q.this.msy;
                if (g > 1) {
                    q.this.msy = i2;
                    q.this.tJZ = q.this.tJZ + 1;
                    payInfo = q.this.pGr;
                    payInfo.tKe++;
                }
                h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
                boolean z2 = i == 2 || i == 10308;
                if (bVar.cHJ == 2) {
                    z = true;
                } else {
                    z = false;
                }
                ab.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(q.this.tJZ), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (q.this.tJZ < 3 && g > 1)) && !z2) {
                    ab.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
                    if (q.this.tKa == null) {
                        q.this.tKa = com.tencent.mm.ui.c.a.eS(q.this.getContext());
                    }
                    q.this.tGW.setVisibility(8);
                    q.this.tJW.setVisibility(4);
                    q.this.tKa.reset();
                    q.this.tKa.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.i(47598);
                            ab.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(47596);
                                    q.this.tJW.setVisibility(0);
                                    AppMethodBeat.o(47596);
                                }
                            });
                            AppMethodBeat.o(47598);
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(47599);
                            ab.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(47597);
                                    q.this.tJW.setVisibility(8);
                                    q.this.tGW.setVisibility(0);
                                    AppMethodBeat.o(47597);
                                }
                            });
                            AppMethodBeat.o(47599);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    q.this.tJW.startAnimation(q.this.tKa);
                    com.tencent.mm.plugin.soter.d.a.EC(1);
                    AppMethodBeat.o(47600);
                    return;
                }
                if (q.this.tJZ >= 3 || z2) {
                    ab.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
                    q.cRS();
                    q.this.tJX = 0;
                    q.k(q.this);
                    q.this.tJU.setVisibility(8);
                    q.this.tJV.setVisibility(8);
                    q.this.tJW.setVisibility(0);
                    q.this.tJW.setText(R.string.fey);
                    q.this.tJW.setTextColor(q.this.getContext().getResources().getColor(R.color.a53));
                    q.this.tJA.setText(R.string.fq4);
                    q.this.tJF.setVisibility(0);
                    if (!q.this.nTi.isShown()) {
                        q.this.nTi.setVisibility(0);
                    }
                    com.tencent.mm.plugin.soter.d.a.EC(2);
                    q.np(true);
                }
                AppMethodBeat.o(47600);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(lvVar);
        AppMethodBeat.o(47610);
    }

    private static void cRz() {
        AppMethodBeat.i(47611);
        ab.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
        ((l) g.K(l.class)).bxk();
        AppMethodBeat.o(47611);
    }

    public int btU() {
        return R.layout.b4h;
    }

    private void nm(boolean z) {
        AppMethodBeat.i(47612);
        View findViewById = this.jcl.findViewById(R.id.fga);
        if (findViewById != null) {
            if (z) {
                findViewById.setVisibility(0);
                this.tKf = true;
                AppMethodBeat.o(47612);
                return;
            }
            findViewById.setVisibility(8);
            this.tKf = false;
        }
        AppMethodBeat.o(47612);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(47613);
        if (i == 4) {
            if (this.Ue != null) {
                this.Ue.onCancel(this);
            }
            if (this.tKm != null) {
                this.tKm.bXx();
            }
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(47613);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47614);
        super.onCreate(bundle);
        setContentView(this.jcl);
        f.dRn().dRo();
        AppMethodBeat.o(47614);
    }

    public void setCancelable(boolean z) {
        AppMethodBeat.i(47615);
        super.setCancelable(z);
        this.gHY = z;
        setCanceledOnTouchOutside(this.gHY);
        AppMethodBeat.o(47615);
    }

    public void dismiss() {
        AppMethodBeat.i(47616);
        try {
            super.dismiss();
        } catch (Exception e) {
            ab.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + e.getMessage());
        }
        cRz();
        this.tln.destory();
        if (this.msx != null) {
            this.msx.cancel();
        }
        AppMethodBeat.o(47616);
    }

    public final void adc(String str) {
        AppMethodBeat.i(47617);
        this.qcc.setText(str);
        AppMethodBeat.o(47617);
    }

    public final void f(String str, double d) {
        AppMethodBeat.i(47618);
        if (TextUtils.isEmpty(str)) {
            this.pUA.setVisibility(8);
            this.tJS = true;
            nn(this.tJS);
            AppMethodBeat.o(47618);
            return;
        }
        this.pUA.setVisibility(0);
        this.pUA.setText(str);
        if (d == 0.0d) {
            this.tJS = false;
            nn(this.tJS);
            AppMethodBeat.o(47618);
            return;
        }
        nn(this.tJS);
        AppMethodBeat.o(47618);
    }

    private void add(String str) {
        AppMethodBeat.i(47619);
        if (TextUtils.isEmpty(str)) {
            ab.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
            this.tJL.setVisibility(8);
            AppMethodBeat.o(47619);
            return;
        }
        this.tJL.setVisibility(0);
        this.tJL.setText(str);
        AppMethodBeat.o(47619);
    }

    public final void gN(String str, String str2) {
        AppMethodBeat.i(47620);
        if (TextUtils.isEmpty(str2)) {
            this.tJE.setVisibility(8);
        } else {
            this.tJE.setVisibility(0);
            this.tJE.setText(str2);
        }
        if (TextUtils.isEmpty(str)) {
            this.tJO.setVisibility(8);
            AppMethodBeat.o(47620);
            return;
        }
        this.tJO.setText(str);
        this.tJO.setVisibility(0);
        AppMethodBeat.o(47620);
    }

    public final void ade(String str) {
        AppMethodBeat.i(47621);
        if (TextUtils.isEmpty(str)) {
            this.tpG.setVisibility(8);
            AppMethodBeat.o(47621);
            return;
        }
        this.tpG.setVisibility(0);
        this.tpG.setText(str);
        AppMethodBeat.o(47621);
    }

    private void a(PayInfo payInfo, boolean z) {
        AppMethodBeat.i(47622);
        this.pGr = payInfo;
        this.tJY = z;
        if (com.tencent.mm.model.r.YM()) {
            AppMethodBeat.o(47622);
            return;
        }
        boolean z2;
        ab.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
        synchronized (this.tKo) {
            try {
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(47622);
                }
            }
        }
        l lVar = (l) g.K(l.class);
        if (lVar.bxn() && lVar.bxo() && !lVar.bxf() && lVar.bxe()) {
            this.tKn = 0;
        } else if (lVar.bxA() && lVar.bxB() && !lVar.bxg() && lVar.bxh()) {
            this.tKn = 1;
        }
        ab.i("MicroMsg.WalletPwdDialog", "bio mode: %s", Integer.valueOf(this.tKn));
        this.tJZ = 0;
        this.tJU.setVisibility(8);
        this.tJV.setVisibility(8);
        this.tKc = bo.yz();
        if (r.cPI() == null || this.tKn < 0) {
            z2 = true;
        } else {
            z2 = lVar.bxz();
        }
        ab.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", Boolean.valueOf(z2));
        if ((this.pGr == null || !(this.pGr.vwi == 100000 || this.pGr.vwi == 100102)) && z2) {
            if (this.pGr != null && this.pGr.vwi == 100001) {
                this.pGr.tKd = 1;
            }
            if (this.tKn >= 0 && this.tJY && !cRP()) {
                this.tJU.setVisibility(0);
                this.tJU.setText(getContext().getString(R.string.fq6));
                this.tJF.setVisibility(8);
                this.nTi.setVisibility(8);
                if (this.pGr != null) {
                    this.pGr.tKd = 1;
                }
                if (this.tKn == 0) {
                    this.tJX = 1;
                    this.tJV.setVisibility(0);
                    this.tGW.setVisibility(0);
                    this.tJA.setText(R.string.fpz);
                    cRy();
                    h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                } else if (this.tKn == 1) {
                    this.tJX = 2;
                    this.tKl.setVisibility(0);
                    this.tJA.setText(R.string.fpy);
                }
            } else if (this.tKn >= 0 && this.tJY && cRP()) {
                if (this.tKn == 0) {
                    this.tJU.setText(getContext().getString(R.string.fez));
                } else {
                    this.tJU.setText(getContext().getString(R.string.fer));
                }
                this.tJU.setVisibility(0);
                this.tJX = 0;
                this.tJV.setVisibility(8);
                this.tKl.setVisibility(8);
                this.tJF.setVisibility(0);
                if (!this.nTi.isShown()) {
                    this.nTi.setVisibility(0);
                }
                this.tJA.setText(R.string.fq4);
                if (this.pGr != null) {
                    this.pGr.tKd = 0;
                }
                h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                e.QS(8);
            } else {
                if (this.pGr != null) {
                    this.pGr.tKd = 0;
                }
                this.tJU.setVisibility(8);
                h.pYm.e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            }
            ab.i("MicroMsg.WalletPwdDialog", "canUseBioMode: %s, use_pay_touch: %s, forcePwdMode：%s", Integer.valueOf(this.tKn), Boolean.valueOf(this.tJY), Boolean.valueOf(cRP()));
            this.tJU.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    int i = 0;
                    AppMethodBeat.i(47592);
                    if (q.this.tJX == 0) {
                        if (q.this.tKn == 0) {
                            q.b(q.this);
                        } else {
                            q.c(q.this);
                        }
                    } else if (q.this.tJX == 1) {
                        if (q.this.pGr != null) {
                            i = q.this.pGr.cIf;
                        }
                        ad.e(i, q.this.pGr == null ? "" : q.this.pGr.czZ, 19, "");
                        q.d(q.this);
                    } else if (q.this.tJX == 2) {
                        q.d(q.this);
                        h.pYm.e(15817, Integer.valueOf(4));
                    }
                    if (q.this.tJX == 1) {
                        q.cRS();
                        if (q.e(q.this)) {
                            q.f(q.this);
                        }
                    }
                    AppMethodBeat.o(47592);
                }
            });
            AppMethodBeat.o(47622);
            return;
        }
        ab.i("MicroMsg.WalletPwdDialog", "errCode: %s", Integer.valueOf(this.pGr.vwi));
        if (!this.nTi.isShown()) {
            this.nTi.setVisibility(0);
        }
        if (this.pGr != null) {
            this.pGr.tKd = 0;
            this.pGr.cBU = "";
            this.pGr.cBV = "";
        }
        this.tJV.setVisibility(0);
        this.tJW.setVisibility(0);
        TextView textView = this.tJW;
        int i = (this.pGr == null || this.pGr.vwi != 100102) ? R.string.fey : R.string.ff5;
        textView.setText(i);
        this.tJW.setTextColor(getContext().getResources().getColor(R.color.a53));
        if (z2) {
            this.tJI.setVisibility(8);
            this.tJJ.setVisibility(8);
        } else {
            this.tJI.setVisibility(0);
            this.tJJ.setVisibility(0);
        }
        if (this.pGr != null && this.pGr.vwi == 100102) {
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, Boolean.TRUE);
            lVar.hq(false);
            lVar.hr(false);
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.FALSE);
        }
        h.pYm.e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.o(47622);
    }

    private void h(Bankcard bankcard) {
        AppMethodBeat.i(47623);
        if (bankcard == null) {
            ab.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
            AppMethodBeat.o(47623);
        } else if (bankcard.cPc()) {
            this.tJD.setImageResource(R.drawable.bki);
            AppMethodBeat.o(47623);
        } else if (bankcard.cPd()) {
            this.tln.a(bankcard, this.tJD);
            AppMethodBeat.o(47623);
        } else {
            if (bankcard.cPg()) {
                this.tJD.setImageDrawable(com.tencent.mm.svg.a.a.f(getContext().getResources(), R.raw.honey_pay_bank_logo));
                if (!bo.isNullOrNil(bankcard.txk)) {
                    this.tJD.setUseSdcardCache(true);
                    this.tJD.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.cRb());
                    this.tJD.eb(bankcard.txk, R.raw.honey_pay_bank_logo);
                    AppMethodBeat.o(47623);
                    return;
                }
            }
            this.tln.a(getContext(), bankcard, this.tJD);
            AppMethodBeat.o(47623);
        }
    }

    public final void a(CharSequence charSequence, View.OnClickListener onClickListener, boolean z) {
        AppMethodBeat.i(47624);
        if (TextUtils.isEmpty(charSequence)) {
            this.tJI.setVisibility(8);
            this.tJJ.setVisibility(8);
            AppMethodBeat.o(47624);
            return;
        }
        this.tJI.setOnClickListener(onClickListener);
        this.tJB.setText(charSequence);
        nn(this.tJS);
        if (z) {
            this.tJH.setVisibility(0);
            AppMethodBeat.o(47624);
            return;
        }
        this.tJH.setVisibility(8);
        AppMethodBeat.o(47624);
    }

    private void nn(boolean z) {
        AppMethodBeat.i(47625);
        if (z) {
            this.tJI.setVisibility(0);
            this.tJJ.setVisibility(0);
            AppMethodBeat.o(47625);
            return;
        }
        this.tJI.setVisibility(8);
        this.tJJ.setVisibility(8);
        AppMethodBeat.o(47625);
    }

    public final void a(final Context context, final Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard) {
        AppMethodBeat.i(47626);
        this.tpu = c.tDU.a(orders);
        if (orders == null || orders.tAr == null || orders.tAr.tmV == null || orders.tAr.tmV.size() <= 0 || this.tpu == null) {
            this.tJE.setVisibility(8);
            AppMethodBeat.o(47626);
            return;
        }
        if (favorPayInfo == null) {
            this.toH = this.tpu.acX(orders.tAr.tmU);
        } else {
            this.toH = favorPayInfo;
        }
        this.tJE.setVisibility(0);
        if (this.tJI != null) {
            this.tJI.setTag(this.toH);
        }
        this.tJT = bankcard;
        this.tJN.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47602);
                q.this.tJK.setVisibility(8);
                ad.e(q.this.pGr == null ? 0 : q.this.pGr.cIf, q.this.pGr == null ? "" : q.this.pGr.czZ, 12, "");
                l.a(context, orders, q.this.toH.tzb, new com.tencent.mm.plugin.wallet_core.ui.l.b() {
                    public final void a(FavorPayInfo favorPayInfo) {
                        int i;
                        String str;
                        double d;
                        String G;
                        String string;
                        String str2;
                        String str3;
                        String str4 = null;
                        AppMethodBeat.i(47601);
                        q.this.toH = favorPayInfo;
                        if (q.this.pGr == null) {
                            i = 0;
                        } else {
                            i = q.this.pGr.cIf;
                        }
                        if (q.this.pGr == null) {
                            str = "";
                        } else {
                            str = q.this.pGr.czZ;
                        }
                        ad.e(i, str, 15, q.this.toH.tzb);
                        q.this.tJR = false;
                        List bt = b.bt(q.this.toH.tzc, q.this.toH.tzd);
                        q.this.toH.tzf = "";
                        if (b.a(q.this.toH, q.this.tJT)) {
                            q.this.tJR = true;
                            if (bt.size() == 0) {
                                q.this.toH.tzf = context.getString(R.string.fet);
                            } else {
                                q.this.toH.tzf = context.getString(R.string.feu);
                            }
                            q.this.dismiss();
                            if (q.this.tKk != null) {
                                q.this.tKk.a(q.this.tJF.getText(), q.this.toH, q.this.tJR);
                                AppMethodBeat.o(47601);
                                return;
                            }
                        }
                        if (q.this.tJI != null) {
                            q.this.tJI.setTag(q.this.toH);
                        }
                        j acU = q.this.tpu.acU(q.this.toH.tzb);
                        if (acU == null || acU.tnb <= 0.0d) {
                            d = orders.tAr.tmR;
                            G = e.G(orders.tAr.tmR);
                            string = context.getString(R.string.fq0);
                            str = G;
                            str2 = null;
                            str3 = null;
                        } else {
                            d = acU.tmT;
                            G = e.G(acU.tna);
                            str3 = e.G(orders.tAr.tmR);
                            str2 = acU.tnd;
                            str = G;
                            string = null;
                        }
                        if (acU == null || acU.tnc == 0) {
                            G = null;
                        } else {
                            G = acU.tne;
                            if (!bo.isNullOrNil(str2)) {
                                G = ",".concat(String.valueOf(G));
                            }
                        }
                        if (bo.isNullOrNil(str2) && bo.isNullOrNil(G)) {
                            str4 = string;
                        } else if (!bo.isNullOrNil(string)) {
                            str4 = ",".concat(String.valueOf(string));
                        }
                        q.this.f(str, d);
                        q.this.ade(str3);
                        q.this.gN(str2, str4);
                        q.this.adf(G);
                        AppMethodBeat.o(47601);
                    }
                }, null);
                AppMethodBeat.o(47602);
            }
        });
        Assert.assertNotNull(this.tpu);
        this.tJK.setVisibility(8);
        AppMethodBeat.o(47626);
    }

    /* Access modifiers changed, original: protected */
    public void cRO() {
        AppMethodBeat.i(47627);
        nl(false);
        if (this.tJQ != null) {
            this.tJQ.onClick(this, 0);
        }
        dismiss();
        if (this.tKk != null) {
            this.tKk.a(this.tJF.getText(), this.toH, this.tJR);
        }
        if (this.tKc < 0) {
            ab.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
            AppMethodBeat.o(47627);
        } else if (this.tJX == 0) {
            h.pYm.a(686, 0, 1, false);
            h.pYm.a(686, 1, bo.az(this.tKc), false);
            AppMethodBeat.o(47627);
        } else {
            if (this.tJX == 1) {
                h.pYm.a(686, 2, 1, false);
                h.pYm.a(686, 3, bo.az(this.tKc), false);
            }
            AppMethodBeat.o(47627);
        }
    }

    public final void b(final OnCancelListener onCancelListener) {
        AppMethodBeat.i(47628);
        if (this.oft == null) {
            AppMethodBeat.o(47628);
            return;
        }
        this.Ue = onCancelListener;
        this.oft.setVisibility(0);
        this.oft.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47603);
                if (onCancelListener != null) {
                    onCancelListener.onCancel(null);
                }
                if (q.this.tKm != null) {
                    q.this.tKm.bXx();
                }
                q.this.cancel();
                if (q.this.tJU.isShown()) {
                    h.pYm.e(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.o(47603);
                    return;
                }
                h.pYm.e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                AppMethodBeat.o(47603);
            }
        });
        AppMethodBeat.o(47628);
    }

    public final void no(boolean z) {
        AppMethodBeat.i(47629);
        if (z) {
            this.tJI.setVisibility(0);
            AppMethodBeat.o(47629);
            return;
        }
        this.tJI.setVisibility(8);
        AppMethodBeat.o(47629);
    }

    private void aw(LinkedList<String> linkedList) {
        AppMethodBeat.i(47630);
        if (this.tJC != null) {
            if (linkedList == null || linkedList.size() <= 0) {
                this.tJC.setVisibility(8);
            } else {
                this.tJC.setWording(linkedList);
                this.tJC.setVisibility(0);
                AppMethodBeat.o(47630);
                return;
            }
        }
        AppMethodBeat.o(47630);
    }

    public final void adf(String str) {
        AppMethodBeat.i(47631);
        if (bo.isNullOrNil(str)) {
            this.tJM.setVisibility(8);
            AppMethodBeat.o(47631);
            return;
        }
        this.tJM.setText(str);
        this.tJM.setVisibility(0);
        AppMethodBeat.o(47631);
    }

    public final void a(a aVar) {
        this.tKm = aVar;
    }

    private static boolean a(PayInfo payInfo) {
        if (payInfo == null || (payInfo.cIf != 31 && payInfo.cIf != 32 && payInfo.cIf != 33)) {
            return false;
        }
        return true;
    }

    public static q a(Context context, boolean z, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, String str, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        AppMethodBeat.i(47633);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(47633);
            return null;
        } else if (orders == null || orders.tAq == null || orders.tAq.size() <= 0) {
            AppMethodBeat.o(47633);
            return null;
        } else {
            String str2;
            String bC;
            String str3;
            List cRl;
            String string;
            CharSequence charSequence;
            b a = c.tDU.a(orders);
            String str4 = "MicroMsg.WalletPwdDialog";
            String str5 = "showAlert with favInfo %s bindSerial %s  bankcardType %s";
            Object[] objArr = new Object[3];
            objArr[0] = favorPayInfo == null ? "" : favorPayInfo.toString();
            if (bankcard == null) {
                str2 = "";
            } else {
                str2 = bankcard.field_bindSerial;
            }
            objArr[1] = str2;
            if (bankcard == null) {
                str2 = "";
            } else {
                str2 = bankcard.field_bankcardType;
            }
            objArr[2] = str2;
            ab.i(str4, str5, objArr);
            if (a != null) {
                if (favorPayInfo != null && bankcard != null) {
                    boolean z2;
                    if (bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ab.i("MicroMsg.WalletPwdDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", favorPayInfo.tzb, Boolean.valueOf(z2));
                    bC = a.bC(favorPayInfo.tzb, z2);
                    ab.i("MicroMsg.WalletPwdDialog", "nonBankSelectedFaovrCompId %s", bC);
                    com.tencent.mm.plugin.wallet_core.ui.b.a aVar = (com.tencent.mm.plugin.wallet_core.ui.b.a) a.acS(bC).get(bankcard.field_bindSerial);
                    com.tencent.mm.plugin.wallet_core.ui.b.a aVar2 = (com.tencent.mm.plugin.wallet_core.ui.b.a) a.bB(bC, true).get(bankcard.field_bankcardType);
                    j bA = a.bA(bC, z2);
                    String str6 = "MicroMsg.WalletPwdDialog";
                    str3 = "defaultComposeInfo %s wrapperSerial %s wrapper %s";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = bA == null ? "" : bA.tnk;
                    objArr2[1] = aVar == null ? "" : aVar.toString();
                    objArr2[2] = aVar2 == null ? "" : aVar2.toString();
                    ab.i(str6, str3, objArr2);
                    if (aVar != null && aVar.tDR != null && !bo.isNullOrNil(aVar.tDR.tnk)) {
                        favorPayInfo.tzb = aVar.tDR.tnk;
                    } else if (aVar2 != null && aVar2.tDR != null && !bo.isNullOrNil(aVar2.tDR.tnk)) {
                        favorPayInfo.tzb = aVar2.tDR.tnk;
                    } else if (bA != null) {
                        favorPayInfo.tzb = bA.tnk;
                    } else {
                        favorPayInfo.tzb = bC;
                    }
                } else if (orders.tAr != null) {
                    favorPayInfo = a.acX(a.acY(orders.tAr.tmU));
                }
                cRl = a.cRl();
            } else {
                ab.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
                cRl = null;
            }
            bC = "";
            str2 = payInfo.vwh == null ? "" : payInfo.vwh.getString("extinfo_key_19", "");
            com.tencent.mm.storage.ad aoM;
            if (!bo.isNullOrNil(str2)) {
                bC = str2;
            } else if (payInfo.cIf == 32 || payInfo.cIf == 33) {
                str2 = payInfo.vwh.getString("extinfo_key_5", "");
                String string2 = payInfo.vwh.getString("extinfo_key_1", "");
                str5 = context.getString(R.string.fq3);
                if (!bo.isNullOrNil(str2)) {
                    str5 = str2;
                    bC = str2;
                }
                if (bo.isNullOrNil(string2)) {
                    ab.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    g.RQ();
                    aoM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(string2);
                    if (aoM != null) {
                        objArr = new Object[1];
                        objArr[0] = e.atA(aoM.Oj()) + (bo.isNullOrNil(str) ? "" : "(" + str + ")");
                        bC = bo.t(str5, objArr);
                    } else {
                        ab.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(string2)));
                    }
                }
            } else if (payInfo.cIf == 31) {
                str5 = payInfo.vwh.getString("extinfo_key_1", "");
                if (bo.isNullOrNil(str5)) {
                    ab.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    g.RQ();
                    aoM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(str5);
                    if (aoM != null) {
                        objArr = new Object[1];
                        objArr[0] = aoM.Oi() + (bo.isNullOrNil(str) ? "" : "(" + str + ")");
                        bC = context.getString(R.string.fq3, objArr);
                    } else {
                        ab.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(str5)));
                    }
                }
            } else if (payInfo.cIf == 42) {
                str5 = payInfo.vwh.getString("extinfo_key_1", "");
                if (bo.isNullOrNil(str5)) {
                    ab.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    g.RQ();
                    aoM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(str5);
                    if (aoM != null) {
                        objArr = new Object[1];
                        objArr[0] = aoM.Oi() + (bo.isNullOrNil(str) ? "" : "(" + str + ")");
                        bC = context.getString(R.string.fpx, objArr);
                    } else {
                        ab.e("MicroMsg.WalletPwdDialog", "can not found contact for user::".concat(String.valueOf(str5)));
                    }
                }
            } else if (payInfo.cIf == 48) {
                bC = context.getString(R.string.dfl);
            } else if (payInfo.cIf == 49) {
                if (bo.isNullOrNil(payInfo.vwh.getString("extinfo_key_1", ""))) {
                    ab.e("MicroMsg.WalletPwdDialog", "userName is null, scene is %s", Integer.valueOf(payInfo.cIf));
                } else {
                    bC = context.getString(R.string.fq3, new Object[]{payInfo.vwh.getString("extinfo_key_1", "")});
                }
            }
            if (!bo.isNullOrNil(bC) || orders == null || orders.tAq == null) {
                ab.w("MicroMsg.WalletPwdDialog", "orders null?:" + (orders == null));
                str5 = bC;
            } else {
                Commodity commodity = (Commodity) orders.tAq.get(0);
                if (commodity != null) {
                    str5 = commodity.pca;
                    if (a(payInfo)) {
                        if (!bo.isNullOrNil(str5)) {
                            str5 = str5 + IOUtils.LINE_SEPARATOR_UNIX;
                        }
                        str5 = str5 + commodity.desc;
                    }
                    if (bo.isNullOrNil(str5)) {
                        str5 = commodity.desc;
                    }
                }
                str5 = bC;
            }
            String str7 = null;
            String str8 = null;
            str3 = null;
            str2 = null;
            double d = orders.pTN;
            boolean z3 = false;
            if (a == null || favorPayInfo == null) {
                str4 = null;
            } else {
                j acU = a.acU(favorPayInfo.tzb);
                if (acU != null && acU.tnb > 0.0d) {
                    z3 = true;
                    str8 = e.e(orders.pTN, orders.pcl);
                    str7 = e.e(acU.tna, orders.pcl);
                    d = acU.tmT;
                    str3 = acU.tnd;
                    if (tKp.containsKey(payInfo.czZ)) {
                        str4 = null;
                    } else {
                        h.pYm.e(14530, Integer.valueOf(3));
                        str4 = null;
                    }
                } else if (cRl == null || cRl.size() <= 0) {
                    str7 = e.e(orders.pTN, orders.pcl);
                    str4 = null;
                } else {
                    str7 = e.e(acU.tna, orders.pcl);
                    z3 = true;
                    str4 = context.getString(R.string.fq0);
                }
                if (!(acU == null || acU.tnc == 0)) {
                    str2 = acU.tne;
                    if (!bo.isNullOrNil(str3)) {
                        str2 = ",".concat(String.valueOf(str2));
                    }
                }
                if (!(bo.isNullOrNil(str3) && bo.isNullOrNil(r4))) {
                    if (bo.isNullOrNil(str4)) {
                        str4 = null;
                    } else {
                        str4 = ",".concat(String.valueOf(str4));
                    }
                }
            }
            if (orders.pPp > 0.0d) {
                Resources resources = context.getResources();
                Object[] objArr3 = new Object[1];
                objArr3[0] = e.e(orders.pPp, orders.pcl);
                string = resources.getString(R.string.fcz, objArr3);
            } else {
                string = null;
            }
            if (bankcard == null) {
                charSequence = "";
            } else {
                charSequence = bankcard.field_desc;
            }
            if (bankcard != null && bankcard.cPg()) {
                charSequence = com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence);
            }
            final q qVar = new q(context);
            qVar.a(context, orders, favorPayInfo, bankcard);
            qVar.no(z);
            qVar.tJS = z;
            qVar.b((OnCancelListener) new b(onCancelListener, (byte) 0));
            qVar.setOnCancelListener(new b(onCancelListener, (byte) 0));
            qVar.setCancelable(true);
            qVar.adc(str5);
            qVar.f(str7, d);
            qVar.ade(str8);
            final PayInfo payInfo2 = payInfo;
            final View.OnClickListener onClickListener2 = onClickListener;
            qVar.a(charSequence, new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47588);
                    q.tKp.put(payInfo2.czZ, Boolean.TRUE);
                    onClickListener2.onClick(view);
                    if (qVar.tKf) {
                        h.pYm.e(14530, Integer.valueOf(2));
                    }
                    AppMethodBeat.o(47588);
                }
            }, z3);
            qVar.h(bankcard);
            qVar.a(payInfo, orders.tAo == 1);
            qVar.gN(str3, str4);
            qVar.adf(str2);
            qVar.add(string);
            qVar.tKk = cVar;
            qVar.aw(a(bankcard, orders));
            if (a(bankcard, orders, payInfo.czZ)) {
                qVar.nm(true);
                h.pYm.e(14530, Integer.valueOf(1));
            } else {
                qVar.nm(false);
            }
            qVar.show();
            com.tencent.mm.ui.ae.a(qVar.getWindow());
            com.tencent.mm.ui.base.h.a(context, qVar);
            AppMethodBeat.o(47633);
            return qVar;
        }
    }

    private static LinkedList<String> a(Bankcard bankcard, Orders orders) {
        AppMethodBeat.i(47634);
        LinkedList<String> linkedList = new LinkedList();
        if (!(orders == null || orders.tAr == null || orders.tAr.tnf == null)) {
            Iterator it = orders.tAr.tnf.tmA.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wallet.a.c cVar = (com.tencent.mm.plugin.wallet.a.c) it.next();
                if (cVar.pbo.equals(bankcard.field_bindSerial)) {
                    it = cVar.tmL.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        if (dVar.tmM != 0) {
                            linkedList.add(dVar.pOz);
                        }
                    }
                    AppMethodBeat.o(47634);
                    return linkedList;
                }
            }
        }
        AppMethodBeat.o(47634);
        return linkedList;
    }

    static {
        AppMethodBeat.i(47651);
        AppMethodBeat.o(47651);
    }

    private static boolean a(Bankcard bankcard, Orders orders, String str) {
        AppMethodBeat.i(47635);
        if (bankcard == null) {
            AppMethodBeat.o(47635);
            return false;
        } else if (tKp.containsKey(str)) {
            AppMethodBeat.o(47635);
            return false;
        } else {
            if (!(orders.tAr == null || orders.tAr.tnf == null)) {
                boolean z;
                if (orders.tAr.tnf.tmA.size() > 0) {
                    Iterator it = orders.tAr.tnf.tmA.iterator();
                    z = false;
                    while (it.hasNext()) {
                        boolean z2;
                        com.tencent.mm.plugin.wallet.a.c cVar = (com.tencent.mm.plugin.wallet.a.c) it.next();
                        if (cVar.pbo == null || !cVar.pbo.equals(bankcard.field_bindSerial)) {
                            z2 = z;
                        } else {
                            z2 = true;
                        }
                        z = z2;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(47635);
                    return false;
                } else if (orders.tAr.tnf.tmA.size() > 0) {
                    AppMethodBeat.o(47635);
                    return true;
                } else if (orders.tAr.tnf.tmB != null && orders.tAr.tnf.tmB.tns.size() > 0) {
                    AppMethodBeat.o(47635);
                    return true;
                }
            }
            AppMethodBeat.o(47635);
            return false;
        }
    }

    public static q a(Context context, String str, String str2, c cVar, OnCancelListener onCancelListener, a aVar) {
        AppMethodBeat.i(47636);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(47636);
            return null;
        }
        String str3 = "";
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(47636);
            return null;
        }
        q qVar = new q(context);
        qVar.b(onCancelListener);
        qVar.setOnCancelListener(onCancelListener);
        qVar.setCancelable(true);
        qVar.adc(str);
        if (TextUtils.isEmpty(str2)) {
            qVar.pUA.setVisibility(8);
        } else {
            qVar.pUA.setVisibility(0);
            qVar.pUA.setText(str2);
        }
        qVar.tJS = true;
        qVar.nn(qVar.tJS);
        qVar.no(false);
        qVar.tJS = false;
        qVar.tKm = aVar;
        qVar.add(str3);
        qVar.tKk = cVar;
        qVar.show();
        com.tencent.mm.ui.base.h.a(context, qVar);
        AppMethodBeat.o(47636);
        return qVar;
    }

    public static q a(Context context, String str, double d, String str2, Bankcard bankcard, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        boolean z = true;
        AppMethodBeat.i(47637);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.o(47637);
            return null;
        }
        q qVar = new q(context);
        qVar.b(onCancelListener);
        qVar.setOnCancelListener(onCancelListener);
        qVar.setCancelable(true);
        qVar.adc(str);
        qVar.f(e.e(d, str2), d);
        qVar.tJS = true;
        CharSequence charSequence = bankcard == null ? "" : bankcard.field_desc;
        qVar.h(bankcard);
        if (TextUtils.isEmpty(charSequence)) {
            z = false;
        }
        qVar.no(z);
        if (bankcard != null) {
            qVar.a(charSequence, onClickListener, false);
        }
        qVar.tKk = cVar;
        qVar.show();
        com.tencent.mm.ui.base.h.a(context, qVar);
        AppMethodBeat.o(47637);
        return qVar;
    }

    public final void cRm() {
        AppMethodBeat.i(47638);
        this.isPaused = false;
        if (com.tencent.mm.model.r.YM()) {
            AppMethodBeat.o(47638);
        } else {
            AppMethodBeat.o(47638);
        }
    }

    public final void onActivityPause() {
        AppMethodBeat.i(47639);
        this.isPaused = true;
        if (com.tencent.mm.model.r.YM()) {
            AppMethodBeat.o(47639);
            return;
        }
        if (this.tJX == 1) {
            cRN();
        }
        AppMethodBeat.o(47639);
    }

    private static void nl(boolean z) {
        AppMethodBeat.i(47640);
        g.RQ();
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(47640);
    }

    private static boolean cRP() {
        boolean booleanValue;
        AppMethodBeat.i(47641);
        g.RQ();
        Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        AppMethodBeat.o(47641);
        return booleanValue;
    }

    public static q a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        AppMethodBeat.i(47632);
        q a = a(context, true, orders, favorPayInfo, bankcard, payInfo, null, cVar, onClickListener, onCancelListener);
        AppMethodBeat.o(47632);
        return a;
    }

    static /* synthetic */ void c(q qVar) {
        AppMethodBeat.i(47644);
        qVar.tJU.setText(qVar.getContext().getString(R.string.fq6));
        qVar.tJX = 2;
        qVar.tKc = bo.yz();
        qVar.tKl.setVisibility(0);
        qVar.tJF.setVisibility(8);
        qVar.nTi.setVisibility(8);
        qVar.tJA.setText(R.string.fpy);
        nl(false);
        qVar.pGr.tKd = 1;
        AppMethodBeat.o(47644);
    }

    static /* synthetic */ boolean e(q qVar) {
        boolean z;
        AppMethodBeat.i(47647);
        String str = "MicroMsg.WalletPwdDialog";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        if (qVar.isPaused) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (qVar.isPaused) {
            AppMethodBeat.o(47647);
            return false;
        }
        AppMethodBeat.o(47647);
        return true;
    }

    static /* synthetic */ void k(q qVar) {
        AppMethodBeat.i(47649);
        qVar.tKc = bo.yz();
        AppMethodBeat.o(47649);
    }
}
