package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends i {
    public static final int tLO = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 30);
    public static final int tLP = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 32);
    public static final int tLQ = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 36);
    public static final int tLR = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 23);
    private ViewGroup ius;
    private View lBD;
    private Context mContext;
    private MyKeyboardWindow mKeyboard;
    public PayInfo pVL = new PayInfo();
    public Orders pWy = new Orders();
    private TextView tJL;
    private TextView tLS;
    private TextView tLT;
    private TextView tLU;
    private WalletTextView tLV;
    private ViewGroup tLW;
    private EditHintPasswdView tLX;
    private ViewGroup tLY;
    private Button tLZ;
    private ImageView tLy;
    public a tMA;
    List<b> tMB = new ArrayList();
    private TextView tMa;
    private ViewGroup tMb;
    private CdnImageView tMc;
    private TextView tMd;
    private Button tMe;
    private ViewGroup tMf;
    private WcPayCashierDetailItemLayout tMg;
    private WcPayCashierDetailItemLayout tMh;
    private WcPayCashierDetailItemLayout tMi;
    private WcPayCashierDetailItemLayout tMj;
    private c tMk;
    private a tMl;
    private l tMm;
    private int tMn = 0;
    private int tMo = 0;
    private int tMp = 0;
    public Bankcard tMq;
    private boolean tMr = false;
    private boolean tMs;
    private boolean tMt = true;
    private boolean tMu;
    private String tMv;
    private String tMw;
    private String tMx;
    private boolean tMy;
    private boolean tMz;
    private com.tencent.mm.plugin.wallet_core.utils.a tln;
    public FavorPayInfo toH;

    public interface a {
        void a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard);

        void cMN();

        void onCancel();
    }

    public interface b {
        void cSa();
    }

    static /* synthetic */ void h(b bVar) {
        AppMethodBeat.i(47808);
        bVar.cSo();
        AppMethodBeat.o(47808);
    }

    static /* synthetic */ void m(b bVar) {
        AppMethodBeat.i(138563);
        bVar.c(false, 0, true);
        AppMethodBeat.o(138563);
    }

    static /* synthetic */ void p(b bVar) {
        AppMethodBeat.i(138095);
        bVar.cSm();
        AppMethodBeat.o(138095);
    }

    static /* synthetic */ void q(b bVar) {
        AppMethodBeat.i(138565);
        bVar.cSg();
        AppMethodBeat.o(138565);
    }

    static /* synthetic */ void u(b bVar) {
        AppMethodBeat.i(47820);
        bVar.cSc();
        AppMethodBeat.o(47820);
    }

    static /* synthetic */ void v(b bVar) {
        AppMethodBeat.i(138098);
        bVar.cSe();
        AppMethodBeat.o(138098);
    }

    static /* synthetic */ void w(b bVar) {
        AppMethodBeat.i(138567);
        bVar.cSh();
        AppMethodBeat.o(138567);
    }

    static /* synthetic */ void x(b bVar) {
        AppMethodBeat.i(138568);
        bVar.HA(8);
        AppMethodBeat.o(138568);
    }

    static {
        AppMethodBeat.i(47823);
        AppMethodBeat.o(47823);
    }

    public b(Context context) {
        super(context, R.style.zt);
        AppMethodBeat.i(47781);
        this.mContext = context;
        this.ius = (ViewGroup) View.inflate(getContext(), R.layout.b6v, null);
        this.tLy = (ImageView) this.ius.findViewById(R.id.fij);
        this.tLS = (TextView) this.ius.findViewById(R.id.fii);
        this.tLT = (TextView) this.ius.findViewById(R.id.fik);
        this.tLU = (TextView) this.ius.findViewById(R.id.fil);
        this.tJL = (TextView) this.ius.findViewById(R.id.fin);
        this.tLV = (WalletTextView) this.ius.findViewById(R.id.fim);
        this.tLW = (ViewGroup) this.ius.findViewById(R.id.fip);
        this.tLX = (EditHintPasswdView) this.ius.findViewById(R.id.fiw);
        this.tLY = (ViewGroup) this.ius.findViewById(R.id.fiv);
        this.tMh = (WcPayCashierDetailItemLayout) this.ius.findViewById(R.id.fiq);
        this.tLZ = (Button) this.ius.findViewById(R.id.fiy);
        this.tMa = (TextView) this.ius.findViewById(R.id.fix);
        this.tMb = (ViewGroup) this.ius.findViewById(R.id.fir);
        this.tMc = (CdnImageView) this.ius.findViewById(R.id.fis);
        this.tMd = (TextView) this.ius.findViewById(R.id.fit);
        this.tMe = (Button) this.ius.findViewById(R.id.fiu);
        this.mKeyboard = (MyKeyboardWindow) this.ius.findViewById(R.id.akz);
        this.tMf = (ViewGroup) this.ius.findViewById(R.id.aky);
        this.lBD = this.ius.findViewById(R.id.fio);
        ImageView imageView = this.tLy;
        int i = tLO;
        int i2 = tLO;
        bo.n(imageView, i, i, i2, i2);
        this.tLy.setImageDrawable(com.tencent.mm.ui.ah.f(getContext(), R.raw.actionbar_icon_dark_close, getContext().getResources().getColor(R.color.h5)));
        this.tLy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47774);
                ab.i("MicroMsg.WcPayCashierDialog", "click close icon");
                b.this.cancel();
                AppMethodBeat.o(47774);
            }
        });
        com.tencent.mm.wallet_core.ui.formview.a.a(this.tLX);
        this.tLX.setOnInputValidListener(new com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(47775);
                if (z) {
                    b.a(b.this, b.this.tLX.getText(), b.this.toH);
                    h.pYm.e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                }
                AppMethodBeat.o(47775);
            }
        });
        EditText editText = (EditText) this.ius.findViewById(R.id.d6);
        e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            c cVar = new c();
            this.mKeyboard.setSecureAccessibility(cVar);
            editText.setAccessibilityDelegate(cVar);
        }
        editText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47776);
                if (!b.this.tMf.isShown()) {
                    b.this.tMf.setVisibility(0);
                }
                AppMethodBeat.o(47776);
            }
        });
        this.ius.findViewById(R.id.al0).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47777);
                if (b.this.tMf.isShown()) {
                    b.this.tMf.setVisibility(8);
                }
                AppMethodBeat.o(47777);
            }
        });
        this.tLZ.setOnClickListener(new s() {
            public final void bgW() {
                int i = 0;
                AppMethodBeat.i(47778);
                ab.i("MicroMsg.WcPayCashierDialog", "click pay btn: %s", Integer.valueOf(b.this.tMo));
                if (b.this.pVL != null) {
                    i = b.this.pVL.cIf;
                }
                ad.e(i, b.this.pVL == null ? "" : b.this.pVL.czZ, 20, "");
                b.h(b.this);
                if (b.this.tMo == 1) {
                    b.i(b.this);
                    e.QS(9);
                    AppMethodBeat.o(47778);
                } else if (b.this.tMo == 2) {
                    b.j(b.this);
                    AppMethodBeat.o(47778);
                } else {
                    ab.i("MicroMsg.WcPayCashierDialog", "wrong mode, switch pwd");
                    b.k(b.this);
                    AppMethodBeat.o(47778);
                }
            }
        });
        this.tLT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47779);
                ab.d("MicroMsg.WcPayCashierDialog", "click pay way btn");
                b.l(b.this);
                AppMethodBeat.o(47779);
            }
        });
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(47757);
                ab.i("MicroMsg.WcPayCashierDialog", "on canceled");
                b.this.tMz = true;
                if (b.this.tMA != null) {
                    b.this.tMA.onCancel();
                }
                AppMethodBeat.o(47757);
            }
        });
        setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(47773);
                ab.i("MicroMsg.WcPayCashierDialog", "on dismissed");
                b.this.tMz = true;
                b.d(b.this);
                AppMethodBeat.o(47773);
            }
        });
        this.tln = new com.tencent.mm.plugin.wallet_core.utils.a();
        AppMethodBeat.o(47781);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(47782);
        super.onCreate(bundle);
        setContentView(this.ius);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        window.addFlags(67108864);
        d.iW(21);
        AppMethodBeat.o(47782);
    }

    public final void aq(String str, String str2, String str3) {
        AppMethodBeat.i(47783);
        this.tMw = str;
        this.tMx = str2;
        this.tMv = str3;
        this.tMy = true;
        this.tMs = false;
        cSn();
        cSi();
        cSk();
        cSh();
        cSf();
        AppMethodBeat.o(47783);
    }

    public final void a(PayInfo payInfo, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, boolean z, boolean z2) {
        AppMethodBeat.i(47784);
        a(payInfo, orders, favorPayInfo, "", bankcard, z, z2);
        AppMethodBeat.o(47784);
    }

    private void a(PayInfo payInfo, Orders orders, FavorPayInfo favorPayInfo, String str, Bankcard bankcard, boolean z, boolean z2) {
        AppMethodBeat.i(47785);
        ab.i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", Boolean.valueOf(z), Boolean.valueOf(z2), bankcard);
        this.pVL = payInfo;
        this.pWy = orders;
        this.toH = favorPayInfo;
        this.tMq = bankcard;
        this.tMs = z;
        this.tMv = str;
        cSc();
        cSn();
        cSi();
        cSl();
        cSk();
        cSg();
        cSd();
        cSb();
        cSe();
        cSh();
        cSf();
        if (z2) {
            setOnShowListener(new OnShowListener() {
                public final void onShow(DialogInterface dialogInterface) {
                    AppMethodBeat.i(47780);
                    b.m(b.this);
                    b.this.setOnShowListener(null);
                    AppMethodBeat.o(47780);
                }
            });
        }
        AppMethodBeat.o(47785);
    }

    private void cSb() {
        AppMethodBeat.i(47786);
        if (!(this.pWy.field_infos == null || this.pWy.field_infos.isEmpty())) {
            Iterator it = this.pWy.field_infos.iterator();
            while (it.hasNext()) {
                cgd cgd = (cgd) it.next();
                WcPayCashierDetailItemLayout wcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
                wcPayCashierDetailItemLayout.tLM.setVisibility(8);
                if (cgd.xfg != null && cgd.xfg.size() > 0) {
                    com.tencent.mm.plugin.wallet_core.utils.e.a(wcPayCashierDetailItemLayout.pQF, (cgv) cgd.xfg.get(0), null);
                }
                if (cgd.xfh != null && cgd.xfh.size() > 0) {
                    com.tencent.mm.plugin.wallet_core.utils.e.a(wcPayCashierDetailItemLayout.kRK, (cgv) cgd.xfh.get(0), null);
                }
                if (cgd.xfi != null) {
                    com.tencent.mm.plugin.wallet_core.utils.e.a(wcPayCashierDetailItemLayout.tLN, cgd.xfi, R.raw.arrow_right, com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 5), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 9), true);
                    wcPayCashierDetailItemLayout.tLN.setVisibility(0);
                } else {
                    wcPayCashierDetailItemLayout.tLN.setVisibility(8);
                }
                this.tLW.addView(wcPayCashierDetailItemLayout);
            }
        }
        AppMethodBeat.o(47786);
    }

    private void cSc() {
        AppMethodBeat.i(47787);
        com.tencent.mm.plugin.wallet_core.ui.b a = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(this.pWy);
        if (a == null) {
            ab.d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
        } else if (this.toH != null && this.tMq != null) {
            boolean z;
            if (this.tMq.field_bankcardType.equalsIgnoreCase("CFT")) {
                z = true;
            } else {
                z = false;
            }
            ab.i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", this.toH.tzb, Boolean.valueOf(z));
            String bC = a.bC(this.toH.tzb, z);
            ab.i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", bC);
            com.tencent.mm.plugin.wallet_core.ui.b.a aVar = (com.tencent.mm.plugin.wallet_core.ui.b.a) a.acS(bC).get(this.tMq.field_bindSerial);
            com.tencent.mm.plugin.wallet_core.ui.b.a aVar2 = (com.tencent.mm.plugin.wallet_core.ui.b.a) a.bB(bC, true).get(this.tMq.field_bankcardType);
            j bA = a.bA(bC, z);
            String str = "MicroMsg.WcPayCashierDialog";
            String str2 = "defaultComposeInfo %s wrapperSerial %s wrapper %s";
            Object[] objArr = new Object[3];
            objArr[0] = bA == null ? "" : bA.tnk;
            objArr[1] = aVar == null ? "" : aVar.toString();
            objArr[2] = aVar2 == null ? "" : aVar2.toString();
            ab.i(str, str2, objArr);
            if (aVar != null && aVar.tDR != null && !bo.isNullOrNil(aVar.tDR.tnk)) {
                this.toH.tzb = aVar.tDR.tnk;
                AppMethodBeat.o(47787);
                return;
            } else if (aVar2 != null && aVar2.tDR != null && !bo.isNullOrNil(aVar2.tDR.tnk)) {
                this.toH.tzb = aVar2.tDR.tnk;
                AppMethodBeat.o(47787);
                return;
            } else if (bA != null) {
                this.toH.tzb = bA.tnk;
                AppMethodBeat.o(47787);
                return;
            } else {
                this.toH.tzb = bC;
                AppMethodBeat.o(47787);
                return;
            }
        } else if (this.pWy.tAr != null) {
            this.toH = a.acX(a.acY(this.pWy.tAr.tmU));
            AppMethodBeat.o(47787);
            return;
        }
        AppMethodBeat.o(47787);
    }

    private void cSd() {
        AppMethodBeat.i(47788);
        if (this.tMu) {
            ab.i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
            if (this.tMj != null) {
                this.tLW.removeView(this.tMj);
                this.tMj = null;
            }
            AppMethodBeat.o(47788);
            return;
        }
        if (!(bo.isNullOrNil(this.pWy.tAI) || bo.isNullOrNil(this.pWy.tAJ))) {
            this.tMj = new WcPayCashierDetailItemLayout(getContext());
            this.tLW.addView(this.tMj, 0);
            this.tMj.tLM.setVisibility(8);
            this.tMj.tLN.setVisibility(8);
            this.tMj.pQF.setText(R.string.gax);
            StringBuilder stringBuilder;
            if (!this.pWy.tAI.equals("CNY") || bo.isNullOrNil(this.pWy.tAH)) {
                stringBuilder = new StringBuilder(this.pWy.tAJ);
                stringBuilder.append(this.pWy.tAH);
                this.tMj.kRK.setText(stringBuilder);
            } else {
                stringBuilder = new StringBuilder(this.pWy.tAJ);
                stringBuilder.append(this.pWy.tAH);
                if (!(bo.isNullOrNil(this.pWy.tAL) || bo.isNullOrNil(this.pWy.tAM))) {
                    stringBuilder.append(String.format("(%s%s)", new Object[]{this.pWy.tAM, this.pWy.tAK}));
                }
                this.tMj.kRK.setText(stringBuilder);
                AppMethodBeat.o(47788);
                return;
            }
        }
        AppMethodBeat.o(47788);
    }

    private void cSe() {
        AppMethodBeat.i(47789);
        com.tencent.mm.plugin.wallet_core.ui.b a = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(this.pWy);
        if (this.toH == null || !(a == null || a.cRi())) {
            this.tLW.removeView(this.tMi);
            this.tMi = null;
            AppMethodBeat.o(47789);
            return;
        }
        if (this.tMi == null) {
            this.tMi = new WcPayCashierDetailItemLayout(getContext());
            this.tLW.addView(this.tMi);
            this.tMi.pQF.setText(R.string.gaw);
            this.tMi.tLM.setVisibility(8);
            this.tMi.tLN.setVisibility(0);
            this.tMi.kRK.setTextColor(getContext().getResources().getColor(R.color.c4));
            this.tMi.setOnClickListener(new s() {
                public final void bgW() {
                    AppMethodBeat.i(138092);
                    ad.e(b.this.pVL == null ? 0 : b.this.pVL.cIf, b.this.pVL == null ? "" : b.this.pVL.czZ, 12, "");
                    b.this.hide();
                    if (b.this.tMm != null) {
                        b.this.tMm.dismiss();
                        b.this.tMm = null;
                        AppMethodBeat.o(138092);
                        return;
                    }
                    b.this.tMm = l.a(b.this.getContext(), b.this.pWy, b.this.toH.tzb, new com.tencent.mm.plugin.wallet_core.ui.l.b() {
                        public final void a(FavorPayInfo favorPayInfo) {
                            int i = 0;
                            AppMethodBeat.i(47758);
                            ab.i("MicroMsg.WcPayCashierDialog", "on select favor: %s", favorPayInfo.tzb);
                            b.this.tMm = null;
                            b.this.toH = favorPayInfo;
                            if (b.this.pVL != null) {
                                i = b.this.pVL.cIf;
                            }
                            ad.e(i, b.this.pVL == null ? "" : b.this.pVL.czZ, 15, b.this.toH.tzb);
                            List bt = com.tencent.mm.plugin.wallet_core.ui.b.bt(b.this.toH.tzc, b.this.toH.tzd);
                            b.this.toH.tzf = "";
                            if (com.tencent.mm.plugin.wallet_core.ui.b.a(b.this.toH, b.this.tMq)) {
                                if (bt.size() == 0) {
                                    b.this.toH.tzf = b.this.getContext().getString(R.string.fet);
                                } else {
                                    b.this.toH.tzf = b.this.getContext().getString(R.string.feu);
                                }
                                b.o(b.this);
                            } else {
                                b.this.show();
                            }
                            b.p(b.this);
                            b.q(b.this);
                            b.a(b.this, b.this.tMi.kRK);
                            AppMethodBeat.o(47758);
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(47759);
                            ab.i("MicroMsg.WcPayCashierDialog", "on cancel");
                            b.this.tMm = null;
                            b.this.show();
                            AppMethodBeat.o(47759);
                        }
                    });
                    AppMethodBeat.o(138092);
                }
            });
        }
        k(this.tMi.kRK);
        AppMethodBeat.o(47789);
    }

    public final void show() {
        AppMethodBeat.i(138093);
        super.show();
        AppMethodBeat.o(138093);
    }

    private void k(TextView textView) {
        int i;
        AppMethodBeat.i(47790);
        com.tencent.mm.plugin.wallet_core.ui.b a = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(this.pWy);
        j acU = a.acU(this.toH.tzb);
        List cRl = a.cRl();
        StringBuilder stringBuilder = new StringBuilder();
        String str = "";
        if (acU != null && acU.tnb > 0.0d) {
            stringBuilder.append(acU.tnd);
            i = 1;
        } else if (cRl.size() > 0) {
            j cRk = a.cRk();
            if (acU == null && a.cRj() == 1 && cRk != null && cRk.tnc == 0 && this.tMt && this.pWy.tAr.tnh != null && this.pWy.tAr.tnh.tmD == 1) {
                str = getContext().getString(R.string.gat);
                i = 0;
            } else {
                str = getContext().getString(R.string.fq0);
                i = 1;
            }
        } else {
            i = 1;
        }
        if (!(acU == null || acU.tnc == 0 || bo.ac(stringBuilder))) {
            stringBuilder.append(",");
            stringBuilder.append(acU.tne);
        }
        if (!bo.ac(stringBuilder) && !bo.isNullOrNil(str)) {
            stringBuilder.append(",");
            stringBuilder.append(str);
        } else if (!bo.isNullOrNil(str)) {
            stringBuilder.append(str);
        }
        ab.i("MicroMsg.WcPayCashierDialog", "favor text: %s", stringBuilder.toString());
        if (i != 0) {
            textView.setTextColor(getContext().getResources().getColor(R.color.c4));
        } else {
            textView.setTextColor(getContext().getResources().getColor(R.color.rr));
        }
        textView.setText(str);
        AppMethodBeat.o(47790);
    }

    private void cSf() {
        AppMethodBeat.i(47791);
        if (this.tLW.getChildCount() == 0 && this.tMh.getVisibility() == 8) {
            ab.d("MicroMsg.WcPayCashierDialog", "invisible divider");
            this.lBD.setVisibility(8);
            AppMethodBeat.o(47791);
            return;
        }
        this.lBD.setVisibility(0);
        AppMethodBeat.o(47791);
    }

    private void cSg() {
        AppMethodBeat.i(47792);
        if (this.tMu) {
            CharSequence format;
            if (this.tMg == null) {
                this.tMg = new WcPayCashierDetailItemLayout(getContext());
                this.tLW.addView(this.tMg, 0);
                this.tMg.pQF.setText(R.string.gay);
                this.tMg.tLM.setVisibility(8);
                this.tMg.tLN.setVisibility(8);
                this.tMg.kRK.setTypeface(Typeface.createFromAsset(getContext().getAssets(), e.QQ(7)));
                this.tMg.kRK.getPaint().setFlags(16);
            }
            double b = e.b(this.pWy.tAH, "100", RoundingMode.HALF_UP);
            String str = "";
            if (b > 0.0d) {
                str = String.format("%s%s", new Object[]{this.pWy.tAJ, e.F(b)});
            }
            String e = e.e(this.pWy.pTN, this.pWy.pcl);
            if (bo.isNullOrNil(str)) {
                Object format2 = e;
            } else {
                format2 = String.format("%s(%s)", new Object[]{e, str});
            }
            this.tMg.kRK.setText(format2);
            AppMethodBeat.o(47792);
            return;
        }
        if (this.tMg != null) {
            this.tLW.removeView(this.tMg);
            this.tMg = null;
        }
        AppMethodBeat.o(47792);
    }

    private void cSh() {
        AppMethodBeat.i(47793);
        if (this.tMs) {
            this.tMh.setVisibility(0);
            this.tMh.pQF.setText(R.string.gaz);
            this.tMh.tLM.setVisibility(0);
            this.tMh.tLN.setVisibility(0);
            this.tMh.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47761);
                    ab.d("MicroMsg.WcPayCashierDialog", "click bankcard item");
                    b.s(b.this);
                    AppMethodBeat.o(47761);
                }
            });
            this.tMh.tLM.setImageBitmap(null);
            a(this.tMq, this.tMh.tLM);
            CharSequence charSequence = this.tMq == null ? "" : this.tMq.field_desc;
            if (this.tMq != null && this.tMq.cPg()) {
                charSequence = com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, charSequence);
            }
            this.tMh.kRK.setText(charSequence);
            AppMethodBeat.o(47793);
            return;
        }
        ab.i("MicroMsg.WcPayCashierDialog", "can not change pay way");
        this.tMh.setVisibility(8);
        AppMethodBeat.o(47793);
    }

    private void a(Bankcard bankcard, CdnImageView cdnImageView) {
        AppMethodBeat.i(47794);
        if (bankcard == null) {
            ab.e("MicroMsg.WcPayCashierDialog", "setBankcardText bankcard == null");
            AppMethodBeat.o(47794);
        } else if (bankcard.cPc()) {
            cdnImageView.setImageResource(R.drawable.bki);
            AppMethodBeat.o(47794);
        } else if (bankcard.cPd()) {
            this.tln.a(bankcard, (ImageView) cdnImageView);
            AppMethodBeat.o(47794);
        } else {
            if (bankcard.cPg()) {
                cdnImageView.setImageDrawable(com.tencent.mm.svg.a.a.f(getContext().getResources(), R.raw.honey_pay_bank_logo));
                if (!bo.isNullOrNil(bankcard.txk)) {
                    cdnImageView.setUseSdcardCache(true);
                    cdnImageView.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.cRb());
                    cdnImageView.eb(bankcard.txk, R.raw.honey_pay_bank_logo);
                    AppMethodBeat.o(47794);
                    return;
                }
            }
            this.tln.a(getContext(), bankcard, cdnImageView);
            AppMethodBeat.o(47794);
        }
    }

    private void cSi() {
        AppMethodBeat.i(47795);
        cSj();
        cSm();
        AppMethodBeat.o(47795);
    }

    private void cSj() {
        CharSequence charSequence;
        AppMethodBeat.i(47796);
        String str = "";
        if (this.tMy) {
            charSequence = this.tMw;
        } else {
            String string;
            String string2 = this.pVL.vwh == null ? "" : this.pVL.vwh.getString("extinfo_key_19", "");
            com.tencent.mm.storage.ad aoM;
            Object[] objArr;
            Context context;
            if (!bo.isNullOrNil(string2)) {
                str = string2;
            } else if (this.pVL.cIf == 32 || this.pVL.cIf == 33) {
                string2 = this.pVL.vwh.getString("extinfo_key_5", "");
                String string3 = this.pVL.vwh.getString("extinfo_key_1", "");
                string = getContext().getString(R.string.fq3);
                if (!bo.isNullOrNil(string2)) {
                    string = string2;
                    str = string2;
                }
                if (bo.isNullOrNil(string3)) {
                    ab.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    aoM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(string3);
                    if (aoM != null) {
                        objArr = new Object[1];
                        objArr[0] = e.atA(aoM.Oj()) + (bo.isNullOrNil(this.pVL.pPw) ? "" : "(" + this.pVL.pPw + ")");
                        str = bo.t(string, objArr);
                    } else {
                        ab.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(string3)));
                    }
                }
            } else if (this.pVL.cIf == 31) {
                string = this.pVL.vwh.getString("extinfo_key_1", "");
                if (bo.isNullOrNil(string)) {
                    ab.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    aoM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(string);
                    if (aoM != null) {
                        string2 = aoM.Oi();
                        context = getContext();
                        objArr = new Object[1];
                        objArr[0] = string2 + (bo.isNullOrNil(this.pVL.pPw) ? "" : "(" + this.pVL.pPw + ")");
                        str = context.getString(R.string.fq3, objArr);
                    } else {
                        ab.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(string)));
                    }
                }
            } else if (this.pVL.cIf == 42) {
                string = this.pVL.vwh.getString("extinfo_key_1", "");
                if (bo.isNullOrNil(string)) {
                    ab.e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    g.RQ();
                    aoM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(string);
                    if (aoM != null) {
                        string2 = aoM.Oi();
                        context = getContext();
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = string2 + (bo.isNullOrNil(this.pVL.pPw) ? "" : "(" + this.pVL.pPw + ")");
                        str = context.getString(R.string.fpx, objArr2);
                    } else {
                        ab.e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(string)));
                    }
                }
            } else if (this.pVL.cIf == 48) {
                str = getContext().getString(R.string.dfl);
            } else if (this.pVL.cIf == 49) {
                if (bo.isNullOrNil(this.pVL.vwh.getString("extinfo_key_1", ""))) {
                    ab.e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", Integer.valueOf(this.pVL.cIf));
                } else {
                    str = getContext().getString(R.string.fq3, new Object[]{this.pVL.vwh.getString("extinfo_key_1", "")});
                }
            }
            if (!bo.isNullOrNil(str) || this.pWy == null || this.pWy.tAq == null) {
                ab.w("MicroMsg.WcPayCashierDialog", "orders null?:" + (this.pWy == null));
            } else {
                Commodity commodity = (Commodity) this.pWy.tAq.get(0);
                if (commodity != null) {
                    charSequence = commodity.pca;
                    if (a(this.pVL)) {
                        if (!bo.isNullOrNil(charSequence)) {
                            string = charSequence + IOUtils.LINE_SEPARATOR_UNIX;
                        }
                        charSequence = string + commodity.desc;
                    }
                    if (bo.isNullOrNil(charSequence)) {
                        charSequence = commodity.desc;
                    }
                }
            }
            Object charSequence2 = str;
        }
        this.tLU.setText(charSequence2);
        AppMethodBeat.o(47796);
    }

    private void cSk() {
        AppMethodBeat.i(47797);
        if (bo.isNullOrNil(this.tMv)) {
            this.tJL.setVisibility(8);
            AppMethodBeat.o(47797);
            return;
        }
        this.tJL.setText(this.tMv);
        this.tJL.setVisibility(0);
        AppMethodBeat.o(47797);
    }

    private void cSl() {
        AppMethodBeat.i(47798);
        if (this.tMt && this.pWy.tAr.tnh != null && this.pWy.tAr.tnh.tmD == 1) {
            final com.tencent.mm.plugin.wallet.a.b bVar = this.pWy.tAr.tnh;
            this.tMc.setUrl(bVar.tmK);
            this.tMd.setText(bVar.tmF);
            if (!bo.isNullOrNil(bVar.tmG)) {
                this.tMd.setTextColor(Color.parseColor(bVar.tmG));
            }
            this.tMe.setText(bVar.tmH);
            if (!bo.isNullOrNil(bVar.tmI)) {
                this.tMe.setTextColor(Color.parseColor(bVar.tmI));
            }
            this.tMe.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47762);
                    ab.i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
                    b.this.tMt = false;
                    b.this.tMq = r.cPI().h(bVar.tmC.pbo, false, false);
                    FavorPayInfo acX = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(b.this.pWy).acX(bVar.tmE);
                    ab.i("MicroMsg.WcPayCashierDialog", "set favor info: %s", acX.tzb);
                    if (acX.tzb.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        b.u(b.this);
                    } else {
                        b.this.toH = acX;
                    }
                    b.p(b.this);
                    b.q(b.this);
                    b.v(b.this);
                    b.w(b.this);
                    b.x(b.this);
                    AppMethodBeat.o(47762);
                }
            });
            HA(0);
            AppMethodBeat.o(47798);
            return;
        }
        HA(8);
        AppMethodBeat.o(47798);
    }

    private void HA(int i) {
        AppMethodBeat.i(47799);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.tLY.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.tLZ.getLayoutParams();
        if (i == 0) {
            layoutParams.topMargin = tLR;
            layoutParams2.topMargin = tLR;
        } else {
            layoutParams.topMargin = tLP;
            layoutParams2.topMargin = tLQ;
        }
        this.tLY.setLayoutParams(layoutParams);
        this.tLZ.setLayoutParams(layoutParams2);
        this.tMb.setVisibility(i);
        AppMethodBeat.o(47799);
    }

    private void cSm() {
        CharSequence charSequence;
        AppMethodBeat.i(47800);
        if (this.tMy) {
            charSequence = this.tMx;
        } else {
            com.tencent.mm.plugin.wallet_core.ui.b a = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(this.pWy);
            charSequence = e.e(this.pWy.pTN, this.pWy.pcl);
            this.tMu = false;
            if (a != null) {
                j acU = a.acU(this.toH.tzb);
                List cRl = a.cRl();
                if (acU != null && acU.tnb > 0.0d) {
                    this.tMu = true;
                    charSequence = e.e(acU.tna, this.pWy.pcl);
                } else if (acU == null || cRl.size() <= 0) {
                    charSequence = e.e(this.pWy.pTN, this.pWy.pcl);
                } else {
                    charSequence = e.e(acU.tna, this.pWy.pcl);
                }
            }
        }
        this.tLV.setText(charSequence);
        AppMethodBeat.o(47800);
    }

    private static boolean a(PayInfo payInfo) {
        if (payInfo == null || (payInfo.cIf != 31 && payInfo.cIf != 32 && payInfo.cIf != 33)) {
            return false;
        }
        return true;
    }

    private void cSn() {
        AppMethodBeat.i(47801);
        cSo();
        ab.i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", Integer.valueOf(this.pWy.tAo));
        if (this.tMn == 0) {
            boolean z;
            if (this.tMo > 0) {
                z = false;
            } else if (this.tMp == 1 || this.tMp == 3) {
                this.tMa.setVisibility(8);
                z = true;
            } else {
                if (this.pVL.vwi == 100102) {
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, Boolean.TRUE);
                    com.tencent.mm.pluginsdk.l lVar = (com.tencent.mm.pluginsdk.l) g.K(com.tencent.mm.pluginsdk.l.class);
                    lVar.hq(false);
                    lVar.hr(false);
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.FALSE);
                    this.tMa.setText(R.string.ff5);
                } else {
                    this.tMa.setText(R.string.fey);
                }
                this.tMa.setTextColor(getContext().getResources().getColor(R.color.a53));
                this.tMa.setVisibility(0);
                z = true;
            }
            nr(z);
            AppMethodBeat.o(47801);
        } else if (this.tMn == 1) {
            cSp();
            AppMethodBeat.o(47801);
        } else {
            if (this.tMn == 2) {
                cSq();
            }
            AppMethodBeat.o(47801);
        }
    }

    private void cSo() {
        AppMethodBeat.i(138559);
        ab.i("MicroMsg.WcPayCashierDialog", "update verify way");
        if (this.pWy.tAo == 1) {
            boolean z;
            com.tencent.mm.pluginsdk.l lVar = (com.tencent.mm.pluginsdk.l) g.K(com.tencent.mm.pluginsdk.l.class);
            if (lVar.bxn() && lVar.bxo() && !lVar.bxf() && lVar.bxe()) {
                this.tMo = 1;
            } else if (lVar.bxA() && lVar.bxB() && !lVar.bxg() && lVar.bxh()) {
                this.tMo = 2;
            } else {
                this.tMo = 0;
                this.tMp = 2;
            }
            if (r.cPI() == null || this.tMo <= 0) {
                z = true;
            } else {
                z = lVar.bxz();
            }
            if (!z) {
                this.tMo = 0;
                this.tMp = 3;
            } else if (this.pVL.vwi == 100000 || this.pVL.vwi == 100102) {
                this.tMo = 0;
                this.tMp = 4;
            }
            this.tMn = this.tMo;
            ab.i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s", Boolean.valueOf(z), Integer.valueOf(this.pVL.vwi), Integer.valueOf(this.tMn));
            AppMethodBeat.o(138559);
            return;
        }
        this.tMn = 0;
        this.tMo = 0;
        this.tMp = 1;
        AppMethodBeat.o(138559);
    }

    private void nr(boolean z) {
        AppMethodBeat.i(47802);
        ab.i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", Boolean.valueOf(z));
        this.tMn = 0;
        this.tLY.setVisibility(0);
        this.tLZ.setVisibility(8);
        this.tMf.setVisibility(0);
        this.tLS.setVisibility(0);
        if (z) {
            this.tLT.setVisibility(8);
            AppMethodBeat.o(47802);
            return;
        }
        this.tLT.setVisibility(0);
        AppMethodBeat.o(47802);
    }

    private void cSp() {
        AppMethodBeat.i(47803);
        this.tMn = 1;
        this.tLY.setVisibility(8);
        this.tLZ.setVisibility(0);
        this.tMf.setVisibility(8);
        this.tLS.setVisibility(8);
        this.tLT.setText(R.string.fq6);
        AppMethodBeat.o(47803);
    }

    private void cSq() {
        AppMethodBeat.i(47804);
        this.tMn = 2;
        this.tLY.setVisibility(8);
        this.tLZ.setVisibility(0);
        this.tMf.setVisibility(8);
        this.tLS.setVisibility(8);
        this.tLT.setText(R.string.fq6);
        AppMethodBeat.o(47804);
    }

    private void c(boolean z, int i, final boolean z2) {
        int i2;
        String str;
        List ne;
        Object ne2;
        Bankcard bankcard;
        LinkedList g;
        AppMethodBeat.i(47805);
        ab.i("MicroMsg.WcPayCashierDialog", "go to bankcard dialog");
        if (this.tMl != null) {
            this.tMl.dismiss();
        }
        hide();
        this.tLX.cey();
        if (this.pVL == null) {
            i2 = 0;
        } else {
            i2 = this.pVL.cIf;
        }
        if (this.pVL == null) {
            str = "";
        } else {
            str = this.pVL.czZ;
        }
        ad.e(i2, str, 11, "");
        this.tMl = new a(this.mContext);
        a aVar = this.tMl;
        PayInfo payInfo = this.pVL;
        Orders orders = this.pWy;
        FavorPayInfo favorPayInfo = this.toH;
        Bankcard bankcard2 = this.tMq;
        String str2 = "MicroMsg.WcPayCashierBankcardDialog";
        String str3 = "set view data: %s, %s, %s";
        Object[] objArr = new Object[3];
        objArr[0] = bankcard2 == null ? "" : bankcard2.field_desc;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        ab.i(str2, str3, objArr);
        aVar.pVL = payInfo;
        aVar.pWy = orders;
        aVar.toH = favorPayInfo;
        aVar.f0try = bankcard2;
        aVar.tLC = orders.tuo;
        aVar.tLD = z;
        aVar.tLE = i;
        if (aVar.tLD) {
            aVar.tLF = false;
        }
        if (aVar.pVL.cIf == 8) {
            ne2 = ac.ne(true);
        } else {
            ne2 = ac.ne(false);
        }
        if (aVar.toH != null) {
            Object obj;
            if (aVar.toH.tzc != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && aVar.tLD) {
                String str4 = aVar.toH.tzd;
                ArrayList arrayList = new ArrayList();
                i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ne2.size()) {
                        break;
                    }
                    bankcard = (Bankcard) ne2.get(i3);
                    if (bo.isNullOrNil(str4)) {
                        if (!bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                            arrayList.add(bankcard);
                        }
                    } else if (bankcard.field_bankcardType.equals(str4)) {
                        arrayList.add(bankcard);
                    }
                    i2 = i3 + 1;
                }
                ne2 = arrayList;
            }
        }
        for (Bankcard bankcard3 : r1) {
            WcPayCashierBankcardItemLayout wcPayCashierBankcardItemLayout = new WcPayCashierBankcardItemLayout(aVar.getContext());
            aVar.tLB.add(wcPayCashierBankcardItemLayout);
            aVar.tLz.addView(wcPayCashierBankcardItemLayout);
            if (bankcard3.cPc()) {
                com.tencent.mm.plugin.wallet_core.utils.a.j(wcPayCashierBankcardItemLayout.kqn);
            } else if (bankcard3.cPd()) {
                aVar.tln.a(bankcard3, wcPayCashierBankcardItemLayout.kqn);
            } else if (bankcard3.cPg()) {
                wcPayCashierBankcardItemLayout.kqn.setImageDrawable(com.tencent.mm.svg.a.a.f(aVar.getContext().getResources(), R.raw.honey_pay_bank_logo));
                if (!bo.isNullOrNil(bankcard3.txk)) {
                    wcPayCashierBankcardItemLayout.kqn.setUseSdcardCache(true);
                    wcPayCashierBankcardItemLayout.kqn.setImgSavedPath(com.tencent.mm.plugin.wallet_core.d.b.cRb());
                    wcPayCashierBankcardItemLayout.kqn.eb(bankcard3.txk, R.raw.honey_pay_bank_logo);
                }
            } else {
                aVar.tln.a(aVar.getContext(), bankcard3, wcPayCashierBankcardItemLayout.kqn);
            }
            Bankcard bankcard4;
            if (bankcard3.cPc()) {
                bankcard4 = r.cPI().thy;
                if (!bo.isNullOrNil(bankcard4.twT)) {
                    wcPayCashierBankcardItemLayout.tLJ.setText(bankcard4.twT);
                } else if (bankcard4.twS >= 0.0d) {
                    TextView textView = wcPayCashierBankcardItemLayout.tLJ;
                    Context context = aVar.getContext();
                    aVar.getContext();
                    textView.setText(context.getString(ae.dOh(), new Object[]{e.G(bankcard4.twS)}));
                } else {
                    wcPayCashierBankcardItemLayout.tLJ.setText("");
                }
            } else if (bankcard3.cPd()) {
                bankcard4 = r.cPI().tCZ;
                if (!bo.isNullOrNil(bankcard4.twT)) {
                    wcPayCashierBankcardItemLayout.tLJ.setText(bankcard4.twT);
                } else if (bankcard4.twS >= 0.0d) {
                    wcPayCashierBankcardItemLayout.tLJ.setText(aVar.getContext().getString(R.string.fhz, new Object[]{e.G(bankcard4.twS)}));
                } else {
                    wcPayCashierBankcardItemLayout.tLJ.setText("");
                }
            } else if (bankcard3.cPg()) {
                wcPayCashierBankcardItemLayout.tLJ.setText(com.tencent.mm.pluginsdk.ui.e.j.b(aVar.getContext(), bankcard3.field_desc, wcPayCashierBankcardItemLayout.tLJ.getTextSize()));
            } else {
                wcPayCashierBankcardItemLayout.tLJ.setText(bankcard3.field_desc);
            }
            CharSequence charSequence = "";
            switch (bankcard3.a(aVar.tLC, aVar.pWy)) {
                case 1:
                    charSequence = aVar.getContext().getString(R.string.fnz);
                    break;
                case 2:
                    charSequence = aVar.getContext().getString(R.string.fo5);
                    break;
                case 3:
                    charSequence = aVar.getContext().getString(R.string.fo_);
                    break;
                case 4:
                    charSequence = aVar.getContext().getString(R.string.fo1);
                    break;
                case 5:
                    charSequence = aVar.getContext().getString(R.string.fnx);
                    break;
                case 6:
                    charSequence = aVar.getContext().getString(R.string.fo3);
                    break;
                case 7:
                    charSequence = aVar.getContext().getString(R.string.fo8);
                    break;
                case 8:
                    charSequence = bankcard3.field_forbidWord;
                    break;
                default:
                    if (!bo.isNullOrNil(bankcard3.field_tips)) {
                        charSequence = bankcard3.field_tips;
                        break;
                    }
                    break;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            if (!(bo.isNullOrNil(bankcard3.field_forbid_title) || bo.isNullOrNil(bankcard3.field_forbid_url))) {
                spannableStringBuilder.append("  ");
                spannableStringBuilder.append(bankcard3.field_forbid_title);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(aVar.getContext().getResources().getColor(R.color.a4f)), charSequence.length() + 2, spannableStringBuilder.length(), 34);
                wcPayCashierBankcardItemLayout.tLK.setOnClickListener(new com.tencent.mm.plugin.wallet_core.ui.cashier.a.AnonymousClass5(bankcard3));
            }
            if (!bo.ac(spannableStringBuilder)) {
                wcPayCashierBankcardItemLayout.tLK.setVisibility(0);
                wcPayCashierBankcardItemLayout.tLK.setText(spannableStringBuilder);
            }
            if (aVar.tLF && bo.ac(spannableStringBuilder)) {
                g = aVar.g(bankcard3);
                if (g.size() > 0) {
                    wcPayCashierBankcardItemLayout.tGP.setVisibility(0);
                    wcPayCashierBankcardItemLayout.tLK.setVisibility(8);
                    wcPayCashierBankcardItemLayout.tGP.setWording(g);
                }
            }
            if (aVar.f0try != null && bankcard3.field_bindSerial.equals(aVar.f0try.field_bindSerial)) {
                wcPayCashierBankcardItemLayout.tLL.setChecked(true);
            }
            if (bankcard3.a(aVar.tLC, aVar.pWy) != 0) {
                wcPayCashierBankcardItemLayout.tLL.setChecked(false);
                wcPayCashierBankcardItemLayout.tLJ.setTextColor(aVar.getContext().getResources().getColor(R.color.rr));
                wcPayCashierBankcardItemLayout.setEnabled(false);
            } else {
                wcPayCashierBankcardItemLayout.tLJ.setTextColor(aVar.getContext().getResources().getColor(R.color.h4));
                wcPayCashierBankcardItemLayout.setEnabled(true);
            }
            wcPayCashierBankcardItemLayout.setOnClickListener(new com.tencent.mm.plugin.wallet_core.ui.cashier.a.AnonymousClass6(bankcard3));
        }
        WcPayCashierBankcardItemLayout wcPayCashierBankcardItemLayout2 = new WcPayCashierBankcardItemLayout(aVar.getContext());
        wcPayCashierBankcardItemLayout2.kqn.setVisibility(4);
        wcPayCashierBankcardItemLayout2.tLJ.setText(R.string.fnt);
        wcPayCashierBankcardItemLayout2.tLJ.setTextColor(aVar.getContext().getResources().getColor(R.color.t7));
        wcPayCashierBankcardItemLayout2.tLL.setVisibility(8);
        g = aVar.cRZ();
        if (aVar.tLF && g.size() > 0) {
            wcPayCashierBankcardItemLayout2.tGP.setVisibility(0);
            wcPayCashierBankcardItemLayout2.tLK.setVisibility(8);
            wcPayCashierBankcardItemLayout2.tGP.setWording(g);
        }
        wcPayCashierBankcardItemLayout2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47742);
                ab.d("MicroMsg.WcPayCashierBankcardDialog", "click bind new card");
                a.this.dismiss();
                if (a.this.tLG != null) {
                    a.this.tLG.cMN();
                }
                AppMethodBeat.o(47742);
            }
        });
        aVar.tLz.addView(wcPayCashierBankcardItemLayout2);
        CharSequence charSequence2 = "";
        if (!(aVar.pWy == null || aVar.pWy.tAq == null || aVar.pWy.tAq.size() <= 0)) {
            charSequence2 = aVar.getContext().getString(R.string.fcy, new Object[]{e.e(aVar.pWy.pTN, aVar.pWy.pcl), ((Commodity) aVar.pWy.tAq.get(0)).desc});
        }
        if (aVar.toH != null && !bo.isNullOrNil(aVar.toH.tzf)) {
            aVar.tLA.setVisibility(0);
            aVar.tLA.setText(aVar.toH.tzf);
            aVar.toH.tzf = "";
        } else if (aVar.tLE != 0) {
            aVar.tLA.setVisibility(0);
            aVar.tLA.setText(charSequence2);
        } else {
            aVar.tLA.setVisibility(8);
        }
        this.tMB.add(this.tMl.tLH);
        this.tMl.tLG = new com.tencent.mm.plugin.wallet_core.ui.cashier.a.a() {
            public final void i(Bankcard bankcard) {
                int i = 0;
                AppMethodBeat.i(47770);
                if (bankcard == null) {
                    AppMethodBeat.o(47770);
                    return;
                }
                ab.i("MicroMsg.WcPayCashierDialog", "on select bankcard: %s, %s", bankcard.field_bankName, bankcard.field_bindSerial);
                if (b.this.tMq == null || !bankcard.field_bindSerial.equals(b.this.tMq.field_bindSerial)) {
                    if (b.this.pVL != null) {
                        i = b.this.pVL.cIf;
                    }
                    ad.e(i, b.this.pVL == null ? "" : b.this.pVL.czZ, 13, bankcard.field_bindSerial);
                    b.this.tMq = bankcard;
                    b.u(b.this);
                    b.p(b.this);
                    b.q(b.this);
                    b.v(b.this);
                    b.w(b.this);
                    b.E(b.this);
                }
                b.this.tMl.a(b.this);
                b.this.tMl = null;
                b.this.show();
                AppMethodBeat.o(47770);
            }

            public final void cMN() {
                AppMethodBeat.i(47771);
                ab.i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
                b.this.tMl.a(b.this);
                b.this.tMl = null;
                if (b.this.tMA != null) {
                    b.this.tMA.cMN();
                }
                AppMethodBeat.o(47771);
            }

            public final void onCancel() {
                AppMethodBeat.i(47772);
                ab.i("MicroMsg.WcPayCashierDialog", "on bankcard dialog cancel");
                b.this.tMl.a(b.this);
                b.this.tMl = null;
                if (z2) {
                    b.this.cancel();
                    AppMethodBeat.o(47772);
                    return;
                }
                b.this.show();
                AppMethodBeat.o(47772);
            }
        };
        this.tMl.show();
        AppMethodBeat.o(47805);
    }

    static /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(47806);
        for (b cSa : bVar.tMB) {
            cSa.cSa();
        }
        AppMethodBeat.o(47806);
    }

    static /* synthetic */ void a(b bVar, String str, FavorPayInfo favorPayInfo) {
        AppMethodBeat.i(47807);
        if (!(bVar.tMz || bVar.tMA == null)) {
            bVar.tMA.a(str, favorPayInfo, bVar.tMq);
        }
        bVar.dismiss();
        AppMethodBeat.o(47807);
    }

    static /* synthetic */ void i(b bVar) {
        AppMethodBeat.i(47809);
        ab.i("MicroMsg.WcPayCashierDialog", "go to verify fingerprint");
        if (bVar.tMk != null) {
            bVar.tMk.dismiss();
        }
        com.tencent.mm.plugin.soter.d.a.cvP();
        bVar.tMr = false;
        bVar.tMk = new c(bVar.getContext());
        c cVar = bVar.tMk;
        ab.i("MicroMsg.WcPayCashierFingerprintDialog", "set view data: %s", bVar.pVL.czZ);
        cVar.tMK.czZ = r1;
        bVar.tMk.tML = new com.tencent.mm.plugin.wallet_core.ui.cashier.c.b() {
            public final void a(com.tencent.mm.g.a.lv.b bVar) {
                AppMethodBeat.i(47763);
                ab.i("MicroMsg.WcPayCashierDialog", "verify succeeded: %s", Boolean.valueOf(b.this.tMr));
                if (b.this.tMr) {
                    AppMethodBeat.o(47763);
                    return;
                }
                ad.e(b.this.pVL == null ? 0 : b.this.pVL.cIf, b.this.pVL == null ? "" : b.this.pVL.czZ, 22, "");
                b.this.pVL.tKd = 1;
                b.this.pVL.cBU = bVar.cBU;
                b.this.pVL.cBV = bVar.cBV;
                try {
                    JSONObject jSONObject = new JSONObject(((com.tencent.mm.pluginsdk.l) g.K(com.tencent.mm.pluginsdk.l.class)).bxi());
                    jSONObject.put("soter_type", r.cPI().cQm());
                    b.this.pVL.cHI = jSONObject.toString();
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.WcPayCashierDialog", e, "", new Object[0]);
                }
                b.this.pVL.cBS = bVar.cBS;
                b.this.pVL.tKe = b.this.tMk.cSu();
                b.this.ius.setVisibility(0);
                b.this.tMk = null;
                b.a(b.this, "", b.this.toH);
                AppMethodBeat.o(47763);
            }

            public final void cSr() {
                int i = 0;
                AppMethodBeat.i(47764);
                ab.i("MicroMsg.WcPayCashierDialog", "verify failed");
                b.k(b.this);
                b.this.tMa.setText(R.string.fey);
                b.this.tMa.setVisibility(0);
                b.this.pVL.tKd = 0;
                b.this.pVL.tKe = b.this.tMk.cSu();
                b.this.ius.setVisibility(0);
                b.this.tMk = null;
                ad.e(b.this.pVL == null ? 0 : b.this.pVL.cIf, b.this.pVL == null ? "" : b.this.pVL.czZ, 23, "");
                if (b.this.pVL != null) {
                    i = b.this.pVL.cIf;
                }
                ad.e(i, b.this.pVL == null ? "" : b.this.pVL.czZ, 25, "");
                AppMethodBeat.o(47764);
            }

            public final void cSs() {
                int i = 0;
                AppMethodBeat.i(47765);
                ab.i("MicroMsg.WcPayCashierDialog", "verify canceled");
                b.this.tMr = true;
                b.this.ius.setVisibility(0);
                b.this.tMk = null;
                if (b.this.pVL != null) {
                    i = b.this.pVL.cIf;
                }
                ad.e(i, b.this.pVL == null ? "" : b.this.pVL.czZ, 24, "");
                AppMethodBeat.o(47765);
            }

            public final void cSt() {
                AppMethodBeat.i(47766);
                ab.i("MicroMsg.WcPayCashierDialog", "switch pay way");
                b.this.tMr = true;
                b.this.ius.setVisibility(0);
                b.this.tMk = null;
                b.l(b.this);
                AppMethodBeat.o(47766);
            }
        };
        ((MMActivity) bVar.mContext).getLifecycle().addObserver(bVar.tMk);
        bVar.tMk.show();
        bVar.ius.setVisibility(8);
        AppMethodBeat.o(47809);
    }

    static /* synthetic */ void j(b bVar) {
        AppMethodBeat.i(138560);
        ab.i("MicroMsg.WcPayCashierDialog", "go to verify faceid");
        h.pYm.e(15817, Integer.valueOf(3));
        bVar.tMr = false;
        com.tencent.mm.plugin.soter.d.a.cvP();
        com.tencent.mm.plugin.fingerprint.b.i iVar = (com.tencent.mm.plugin.fingerprint.b.i) g.K(com.tencent.mm.plugin.fingerprint.b.i.class);
        Bundle bundle = new Bundle();
        bundle.putInt("face_auth_scene", 1);
        iVar.a((MMActivity) bVar.mContext, new com.tencent.mm.plugin.fingerprint.faceid.auth.a() {
            public final void ef(int i, int i2) {
                AppMethodBeat.i(47767);
                ab.i("MicroMsg.WcPayCashierDialog", "face id auth success");
                if (b.this.tMr) {
                    AppMethodBeat.o(47767);
                    return;
                }
                b.this.pVL.tKd = 1;
                b.this.pVL.cBU = "";
                b.this.pVL.cBV = "";
                try {
                    JSONObject jSONObject = new JSONObject(((com.tencent.mm.pluginsdk.l) g.K(com.tencent.mm.pluginsdk.l.class)).bxi());
                    jSONObject.put("soter_type", r.cPI().cQm());
                    b.this.pVL.cHI = jSONObject.toString();
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.WcPayCashierDialog", e, "", new Object[0]);
                }
                b.this.pVL.cBS = i;
                b.this.pVL.tKe = i2;
                b.a(b.this, "", b.this.toH);
                AppMethodBeat.o(47767);
            }

            public final void vJ(int i) {
                AppMethodBeat.i(47768);
                ab.i("MicroMsg.WcPayCashierDialog", "face id auth fail: %s, %s", Integer.valueOf(i), Integer.valueOf(b.this.pVL.tKe));
                b.this.tMr = true;
                b.this.ius.setVisibility(0);
                b.k(b.this);
                b.this.tMa.setText(R.string.fey);
                b.this.tMa.setVisibility(0);
                PayInfo payInfo = b.this.pVL;
                payInfo.tKe++;
                AppMethodBeat.o(47768);
            }

            public final void bwO() {
                AppMethodBeat.i(47769);
                b.this.tMr = true;
                b.this.ius.setVisibility(0);
                AppMethodBeat.o(47769);
            }
        }, bundle);
        bVar.ius.setVisibility(8);
        AppMethodBeat.o(138560);
    }

    static /* synthetic */ void l(b bVar) {
        int i = 0;
        AppMethodBeat.i(138562);
        ab.i("MicroMsg.WcPayCashierDialog", "trigger switch mVerifyWay: %s", Integer.valueOf(bVar.tMn));
        if (bVar.tMn == 0) {
            if (bVar.tMo == 1) {
                if (bVar.pVL != null) {
                    i = bVar.pVL.cIf;
                }
                ad.e(i, bVar.pVL == null ? "" : bVar.pVL.czZ, 21, "");
                bVar.cSp();
                AppMethodBeat.o(138562);
                return;
            } else if (bVar.tMo == 2) {
                bVar.cSq();
                AppMethodBeat.o(138562);
                return;
            }
        } else if (bVar.tMn == 1) {
            bVar.nr(false);
            bVar.tLT.setText(R.string.fez);
            e.QS(29);
            if (bVar.pVL != null) {
                i = bVar.pVL.cIf;
            }
            ad.e(i, bVar.pVL == null ? "" : bVar.pVL.czZ, 19, "");
            AppMethodBeat.o(138562);
            return;
        } else if (bVar.tMn == 2) {
            bVar.nr(false);
            bVar.tLT.setText(R.string.fer);
            h.pYm.e(15817, Integer.valueOf(4));
        }
        AppMethodBeat.o(138562);
    }

    static /* synthetic */ void o(b bVar) {
        AppMethodBeat.i(138564);
        bVar.c(true, -100, false);
        AppMethodBeat.o(138564);
    }

    static /* synthetic */ void s(b bVar) {
        AppMethodBeat.i(47818);
        bVar.c(false, 0, false);
        AppMethodBeat.o(47818);
    }

    static /* synthetic */ void E(b bVar) {
        AppMethodBeat.i(138569);
        if (bVar.tMt && bVar.pWy.tAr.tnh != null && bVar.pWy.tAr.tnh.tmD == 1 && bVar.pWy.tAr.tnh.tmC != null) {
            FavorPayInfo acX = com.tencent.mm.plugin.wallet_core.ui.c.tDU.a(bVar.pWy).acX(bVar.pWy.tAr.tnh.tmE);
            if (bVar.tMq == null || acX.tzb.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || !acX.tzg.contains(bVar.tMq.field_bindSerial)) {
                bVar.HA(0);
                AppMethodBeat.o(138569);
                return;
            }
        }
        bVar.HA(8);
        AppMethodBeat.o(138569);
    }
}
