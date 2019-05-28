package com.tencent.p177mm.plugin.wallet_core.p561ui.cashier;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18316lv.C18317b;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.p613a.C5218c;
import com.tencent.p177mm.plugin.fingerprint.faceid.auth.C11932a;
import com.tencent.p177mm.plugin.fingerprint.p413b.C11927i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet.p748a.C40049b;
import com.tencent.p177mm.plugin.wallet.p748a.C46330j;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22584ac;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22621b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22621b.C22622a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C29666c;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C29674l;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C29674l.C22625b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C40124c.C40125b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4423a.C44255;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4423a.C44266;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4423a.C44277;
import com.tencent.p177mm.plugin.wallet_core.p561ui.cashier.C4423a.C4428a;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e;
import com.tencent.p177mm.plugin.wallet_core.utils.C40141a;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.cgd;
import com.tencent.p177mm.protocal.protobuf.cgv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.svg.p610a.C5147a;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView;
import com.tencent.p177mm.wallet_core.p650ui.formview.EditHintPasswdView.C30883a;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b */
public final class C4432b extends C15532i {
    public static final int tLO = C1338a.fromDPToPix(C4996ah.getContext(), 30);
    public static final int tLP = C1338a.fromDPToPix(C4996ah.getContext(), 32);
    public static final int tLQ = C1338a.fromDPToPix(C4996ah.getContext(), 36);
    public static final int tLR = C1338a.fromDPToPix(C4996ah.getContext(), 23);
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
    public C4438a tMA;
    List<C4449b> tMB = new ArrayList();
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
    private C40124c tMk;
    private C4423a tMl;
    private C29674l tMm;
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
    private C40141a tln;
    public FavorPayInfo toH;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$11 */
    class C443311 implements OnClickListener {
        C443311() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47776);
            if (!C4432b.this.tMf.isShown()) {
                C4432b.this.tMf.setVisibility(0);
            }
            AppMethodBeat.m2505o(47776);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$12 */
    class C443412 implements OnClickListener {
        C443412() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47777);
            if (C4432b.this.tMf.isShown()) {
                C4432b.this.tMf.setVisibility(8);
            }
            AppMethodBeat.m2505o(47777);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$14 */
    class C443514 implements OnClickListener {
        C443514() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47779);
            C4990ab.m7410d("MicroMsg.WcPayCashierDialog", "click pay way btn");
            C4432b.m6804l(C4432b.this);
            AppMethodBeat.m2505o(47779);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$6 */
    class C44376 implements C11932a {
        C44376() {
        }

        /* renamed from: ef */
        public final void mo9481ef(int i, int i2) {
            AppMethodBeat.m2504i(47767);
            C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "face id auth success");
            if (C4432b.this.tMr) {
                AppMethodBeat.m2505o(47767);
                return;
            }
            C4432b.this.pVL.tKd = 1;
            C4432b.this.pVL.cBU = "";
            C4432b.this.pVL.cBV = "";
            try {
                JSONObject jSONObject = new JSONObject(((C30052l) C1720g.m3528K(C30052l.class)).bxi());
                jSONObject.put("soter_type", C14241r.cPI().cQm());
                C4432b.this.pVL.cHI = jSONObject.toString();
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WcPayCashierDialog", e, "", new Object[0]);
            }
            C4432b.this.pVL.cBS = i;
            C4432b.this.pVL.tKe = i2;
            C4432b.m6789a(C4432b.this, "", C4432b.this.toH);
            AppMethodBeat.m2505o(47767);
        }

        /* renamed from: vJ */
        public final void mo9482vJ(int i) {
            AppMethodBeat.m2504i(47768);
            C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "face id auth fail: %s, %s", Integer.valueOf(i), Integer.valueOf(C4432b.this.pVL.tKe));
            C4432b.this.tMr = true;
            C4432b.this.ius.setVisibility(0);
            C4432b.m6803k(C4432b.this);
            C4432b.this.tMa.setText(C25738R.string.fey);
            C4432b.this.tMa.setVisibility(0);
            PayInfo payInfo = C4432b.this.pVL;
            payInfo.tKe++;
            AppMethodBeat.m2505o(47768);
        }

        public final void bwO() {
            AppMethodBeat.m2504i(47769);
            C4432b.this.tMr = true;
            C4432b.this.ius.setVisibility(0);
            AppMethodBeat.m2505o(47769);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$a */
    public interface C4438a {
        /* renamed from: a */
        void mo9483a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard);

        void cMN();

        void onCancel();
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$13 */
    class C443913 extends C24019s {
        C443913() {
        }

        public final void bgW() {
            int i = 0;
            AppMethodBeat.m2504i(47778);
            C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "click pay btn: %s", Integer.valueOf(C4432b.this.tMo));
            if (C4432b.this.pVL != null) {
                i = C4432b.this.pVL.cIf;
            }
            C44422ad.m80306e(i, C4432b.this.pVL == null ? "" : C4432b.this.pVL.czZ, 20, "");
            C4432b.m6799h(C4432b.this);
            if (C4432b.this.tMo == 1) {
                C4432b.m6800i(C4432b.this);
                C36391e.m59978QS(9);
                AppMethodBeat.m2505o(47778);
            } else if (C4432b.this.tMo == 2) {
                C4432b.m6801j(C4432b.this);
                AppMethodBeat.m2505o(47778);
            } else {
                C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "wrong mode, switch pwd");
                C4432b.m6803k(C4432b.this);
                AppMethodBeat.m2505o(47778);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$3 */
    class C44403 implements OnClickListener {
        C44403() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47761);
            C4990ab.m7410d("MicroMsg.WcPayCashierDialog", "click bankcard item");
            C4432b.m6812s(C4432b.this);
            AppMethodBeat.m2505o(47761);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$5 */
    class C44415 implements C40125b {
        C44415() {
        }

        /* renamed from: a */
        public final void mo9487a(C18317b c18317b) {
            AppMethodBeat.m2504i(47763);
            C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "verify succeeded: %s", Boolean.valueOf(C4432b.this.tMr));
            if (C4432b.this.tMr) {
                AppMethodBeat.m2505o(47763);
                return;
            }
            C44422ad.m80306e(C4432b.this.pVL == null ? 0 : C4432b.this.pVL.cIf, C4432b.this.pVL == null ? "" : C4432b.this.pVL.czZ, 22, "");
            C4432b.this.pVL.tKd = 1;
            C4432b.this.pVL.cBU = c18317b.cBU;
            C4432b.this.pVL.cBV = c18317b.cBV;
            try {
                JSONObject jSONObject = new JSONObject(((C30052l) C1720g.m3528K(C30052l.class)).bxi());
                jSONObject.put("soter_type", C14241r.cPI().cQm());
                C4432b.this.pVL.cHI = jSONObject.toString();
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WcPayCashierDialog", e, "", new Object[0]);
            }
            C4432b.this.pVL.cBS = c18317b.cBS;
            C4432b.this.pVL.tKe = C4432b.this.tMk.cSu();
            C4432b.this.ius.setVisibility(0);
            C4432b.this.tMk = null;
            C4432b.m6789a(C4432b.this, "", C4432b.this.toH);
            AppMethodBeat.m2505o(47763);
        }

        public final void cSr() {
            int i = 0;
            AppMethodBeat.m2504i(47764);
            C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "verify failed");
            C4432b.m6803k(C4432b.this);
            C4432b.this.tMa.setText(C25738R.string.fey);
            C4432b.this.tMa.setVisibility(0);
            C4432b.this.pVL.tKd = 0;
            C4432b.this.pVL.tKe = C4432b.this.tMk.cSu();
            C4432b.this.ius.setVisibility(0);
            C4432b.this.tMk = null;
            C44422ad.m80306e(C4432b.this.pVL == null ? 0 : C4432b.this.pVL.cIf, C4432b.this.pVL == null ? "" : C4432b.this.pVL.czZ, 23, "");
            if (C4432b.this.pVL != null) {
                i = C4432b.this.pVL.cIf;
            }
            C44422ad.m80306e(i, C4432b.this.pVL == null ? "" : C4432b.this.pVL.czZ, 25, "");
            AppMethodBeat.m2505o(47764);
        }

        public final void cSs() {
            int i = 0;
            AppMethodBeat.m2504i(47765);
            C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "verify canceled");
            C4432b.this.tMr = true;
            C4432b.this.ius.setVisibility(0);
            C4432b.this.tMk = null;
            if (C4432b.this.pVL != null) {
                i = C4432b.this.pVL.cIf;
            }
            C44422ad.m80306e(i, C4432b.this.pVL == null ? "" : C4432b.this.pVL.czZ, 24, "");
            AppMethodBeat.m2505o(47765);
        }

        public final void cSt() {
            AppMethodBeat.m2504i(47766);
            C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "switch pay way");
            C4432b.this.tMr = true;
            C4432b.this.ius.setVisibility(0);
            C4432b.this.tMk = null;
            C4432b.m6804l(C4432b.this);
            AppMethodBeat.m2505o(47766);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$10 */
    class C444210 implements C30883a {
        C444210() {
        }

        /* renamed from: hY */
        public final void mo9438hY(boolean z) {
            AppMethodBeat.m2504i(47775);
            if (z) {
                C4432b.m6789a(C4432b.this, C4432b.this.tLX.getText(), C4432b.this.toH);
                C7060h.pYm.mo8381e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            }
            AppMethodBeat.m2505o(47775);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$1 */
    class C44431 implements OnCancelListener {
        C44431() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(47757);
            C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "on canceled");
            C4432b.this.tMz = true;
            if (C4432b.this.tMA != null) {
                C4432b.this.tMA.onCancel();
            }
            AppMethodBeat.m2505o(47757);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$2 */
    class C44442 extends C24019s {

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$2$1 */
        class C44451 implements C22625b {
            C44451() {
            }

            /* renamed from: a */
            public final void mo9492a(FavorPayInfo favorPayInfo) {
                int i = 0;
                AppMethodBeat.m2504i(47758);
                C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "on select favor: %s", favorPayInfo.tzb);
                C4432b.this.tMm = null;
                C4432b.this.toH = favorPayInfo;
                if (C4432b.this.pVL != null) {
                    i = C4432b.this.pVL.cIf;
                }
                C44422ad.m80306e(i, C4432b.this.pVL == null ? "" : C4432b.this.pVL.czZ, 15, C4432b.this.toH.tzb);
                List bt = C22621b.m34308bt(C4432b.this.toH.tzc, C4432b.this.toH.tzd);
                C4432b.this.toH.tzf = "";
                if (C22621b.m34307a(C4432b.this.toH, C4432b.this.tMq)) {
                    if (bt.size() == 0) {
                        C4432b.this.toH.tzf = C4432b.this.getContext().getString(C25738R.string.fet);
                    } else {
                        C4432b.this.toH.tzf = C4432b.this.getContext().getString(C25738R.string.feu);
                    }
                    C4432b.m6808o(C4432b.this);
                } else {
                    C4432b.this.show();
                }
                C4432b.m6809p(C4432b.this);
                C4432b.m6810q(C4432b.this);
                C4432b.m6788a(C4432b.this, C4432b.this.tMi.kRK);
                AppMethodBeat.m2505o(47758);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$2$2 */
        class C44462 implements OnCancelListener {
            C44462() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(47759);
                C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "on cancel");
                C4432b.this.tMm = null;
                C4432b.this.show();
                AppMethodBeat.m2505o(47759);
            }
        }

        C44442() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(138092);
            C44422ad.m80306e(C4432b.this.pVL == null ? 0 : C4432b.this.pVL.cIf, C4432b.this.pVL == null ? "" : C4432b.this.pVL.czZ, 12, "");
            C4432b.this.hide();
            if (C4432b.this.tMm != null) {
                C4432b.this.tMm.dismiss();
                C4432b.this.tMm = null;
                AppMethodBeat.m2505o(138092);
                return;
            }
            C4432b.this.tMm = C29674l.m47060a(C4432b.this.getContext(), C4432b.this.pWy, C4432b.this.toH.tzb, new C44451(), new C44462());
            AppMethodBeat.m2505o(138092);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$8 */
    class C44478 implements OnDismissListener {
        C44478() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(47773);
            C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "on dismissed");
            C4432b.this.tMz = true;
            C4432b.m6795d(C4432b.this);
            AppMethodBeat.m2505o(47773);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$9 */
    class C44489 implements OnClickListener {
        C44489() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47774);
            C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "click close icon");
            C4432b.this.cancel();
            AppMethodBeat.m2505o(47774);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$b */
    public interface C4449b {
        void cSa();
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.b$15 */
    class C445015 implements OnShowListener {
        C445015() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(47780);
            C4432b.m6805m(C4432b.this);
            C4432b.this.setOnShowListener(null);
            AppMethodBeat.m2505o(47780);
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m6799h(C4432b c4432b) {
        AppMethodBeat.m2504i(47808);
        c4432b.cSo();
        AppMethodBeat.m2505o(47808);
    }

    /* renamed from: m */
    static /* synthetic */ void m6805m(C4432b c4432b) {
        AppMethodBeat.m2504i(138563);
        c4432b.m6794c(false, 0, true);
        AppMethodBeat.m2505o(138563);
    }

    /* renamed from: p */
    static /* synthetic */ void m6809p(C4432b c4432b) {
        AppMethodBeat.m2504i(138095);
        c4432b.cSm();
        AppMethodBeat.m2505o(138095);
    }

    /* renamed from: q */
    static /* synthetic */ void m6810q(C4432b c4432b) {
        AppMethodBeat.m2504i(138565);
        c4432b.cSg();
        AppMethodBeat.m2505o(138565);
    }

    /* renamed from: u */
    static /* synthetic */ void m6814u(C4432b c4432b) {
        AppMethodBeat.m2504i(47820);
        c4432b.cSc();
        AppMethodBeat.m2505o(47820);
    }

    /* renamed from: v */
    static /* synthetic */ void m6815v(C4432b c4432b) {
        AppMethodBeat.m2504i(138098);
        c4432b.cSe();
        AppMethodBeat.m2505o(138098);
    }

    /* renamed from: w */
    static /* synthetic */ void m6816w(C4432b c4432b) {
        AppMethodBeat.m2504i(138567);
        c4432b.cSh();
        AppMethodBeat.m2505o(138567);
    }

    /* renamed from: x */
    static /* synthetic */ void m6817x(C4432b c4432b) {
        AppMethodBeat.m2504i(138568);
        c4432b.m6785HA(8);
        AppMethodBeat.m2505o(138568);
    }

    static {
        AppMethodBeat.m2504i(47823);
        AppMethodBeat.m2505o(47823);
    }

    public C4432b(Context context) {
        super(context, C25738R.style.f11415zt);
        AppMethodBeat.m2504i(47781);
        this.mContext = context;
        this.ius = (ViewGroup) View.inflate(getContext(), 2130971195, null);
        this.tLy = (ImageView) this.ius.findViewById(2131829110);
        this.tLS = (TextView) this.ius.findViewById(2131829109);
        this.tLT = (TextView) this.ius.findViewById(2131829111);
        this.tLU = (TextView) this.ius.findViewById(2131829112);
        this.tJL = (TextView) this.ius.findViewById(2131829114);
        this.tLV = (WalletTextView) this.ius.findViewById(2131829113);
        this.tLW = (ViewGroup) this.ius.findViewById(2131829116);
        this.tLX = (EditHintPasswdView) this.ius.findViewById(2131829123);
        this.tLY = (ViewGroup) this.ius.findViewById(2131829122);
        this.tMh = (WcPayCashierDetailItemLayout) this.ius.findViewById(2131829117);
        this.tLZ = (Button) this.ius.findViewById(2131829125);
        this.tMa = (TextView) this.ius.findViewById(2131829124);
        this.tMb = (ViewGroup) this.ius.findViewById(2131829118);
        this.tMc = (CdnImageView) this.ius.findViewById(2131829119);
        this.tMd = (TextView) this.ius.findViewById(2131829120);
        this.tMe = (Button) this.ius.findViewById(2131829121);
        this.mKeyboard = (MyKeyboardWindow) this.ius.findViewById(2131822357);
        this.tMf = (ViewGroup) this.ius.findViewById(2131822356);
        this.lBD = this.ius.findViewById(2131829115);
        ImageView imageView = this.tLy;
        int i = tLO;
        int i2 = tLO;
        C5046bo.m7582n(imageView, i, i, i2, i2);
        this.tLy.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.actionbar_icon_dark_close, getContext().getResources().getColor(C25738R.color.f11783h5)));
        this.tLy.setOnClickListener(new C44489());
        C30890a.m49291a(this.tLX);
        this.tLX.setOnInputValidListener(new C444210());
        EditText editText = (EditText) this.ius.findViewById(2131820687);
        C36391e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            C5218c c5218c = new C5218c();
            this.mKeyboard.setSecureAccessibility(c5218c);
            editText.setAccessibilityDelegate(c5218c);
        }
        editText.setOnClickListener(new C443311());
        this.ius.findViewById(2131822358).setOnClickListener(new C443412());
        this.tLZ.setOnClickListener(new C443913());
        this.tLT.setOnClickListener(new C443514());
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new C44431());
        setOnDismissListener(new C44478());
        this.tln = new C40141a();
        AppMethodBeat.m2505o(47781);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47782);
        super.onCreate(bundle);
        setContentView(this.ius);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        window.addFlags(67108864);
        C1443d.m3068iW(21);
        AppMethodBeat.m2505o(47782);
    }

    /* renamed from: aq */
    public final void mo9473aq(String str, String str2, String str3) {
        AppMethodBeat.m2504i(47783);
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
        AppMethodBeat.m2505o(47783);
    }

    /* renamed from: a */
    public final void mo9472a(PayInfo payInfo, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, boolean z, boolean z2) {
        AppMethodBeat.m2504i(47784);
        m6790a(payInfo, orders, favorPayInfo, "", bankcard, z, z2);
        AppMethodBeat.m2505o(47784);
    }

    /* renamed from: a */
    private void m6790a(PayInfo payInfo, Orders orders, FavorPayInfo favorPayInfo, String str, Bankcard bankcard, boolean z, boolean z2) {
        AppMethodBeat.m2504i(47785);
        C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "set view data: %s, %s, %s", Boolean.valueOf(z), Boolean.valueOf(z2), bankcard);
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
            setOnShowListener(new C445015());
        }
        AppMethodBeat.m2505o(47785);
    }

    private void cSb() {
        AppMethodBeat.m2504i(47786);
        if (!(this.pWy.field_infos == null || this.pWy.field_infos.isEmpty())) {
            Iterator it = this.pWy.field_infos.iterator();
            while (it.hasNext()) {
                cgd cgd = (cgd) it.next();
                WcPayCashierDetailItemLayout wcPayCashierDetailItemLayout = new WcPayCashierDetailItemLayout(getContext());
                wcPayCashierDetailItemLayout.tLM.setVisibility(8);
                if (cgd.xfg != null && cgd.xfg.size() > 0) {
                    C35520e.m58294a(wcPayCashierDetailItemLayout.pQF, (cgv) cgd.xfg.get(0), null);
                }
                if (cgd.xfh != null && cgd.xfh.size() > 0) {
                    C35520e.m58294a(wcPayCashierDetailItemLayout.kRK, (cgv) cgd.xfh.get(0), null);
                }
                if (cgd.xfi != null) {
                    C35520e.m58296a(wcPayCashierDetailItemLayout.tLN, cgd.xfi, C1318a.arrow_right, C1338a.fromDPToPix(C4996ah.getContext(), 5), C1338a.fromDPToPix(C4996ah.getContext(), 9), true);
                    wcPayCashierDetailItemLayout.tLN.setVisibility(0);
                } else {
                    wcPayCashierDetailItemLayout.tLN.setVisibility(8);
                }
                this.tLW.addView(wcPayCashierDetailItemLayout);
            }
        }
        AppMethodBeat.m2505o(47786);
    }

    private void cSc() {
        AppMethodBeat.m2504i(47787);
        C22621b a = C29666c.tDU.mo47919a(this.pWy);
        if (a == null) {
            C4990ab.m7410d("MicroMsg.WcPayCashierDialog", "getFavorLogicHelper null");
        } else if (this.toH != null && this.tMq != null) {
            boolean z;
            if (this.tMq.field_bankcardType.equalsIgnoreCase("CFT")) {
                z = true;
            } else {
                z = false;
            }
            C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "selectedFavorCompId %s isFilterNotSupportCft %s", this.toH.tzb, Boolean.valueOf(z));
            String bC = a.mo38205bC(this.toH.tzb, z);
            C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "nonBankSelectedFaovrCompId %s", bC);
            C22622a c22622a = (C22622a) a.acS(bC).get(this.tMq.field_bindSerial);
            C22622a c22622a2 = (C22622a) a.mo38204bB(bC, true).get(this.tMq.field_bankcardType);
            C46330j bA = a.mo38203bA(bC, z);
            String str = "MicroMsg.WcPayCashierDialog";
            String str2 = "defaultComposeInfo %s wrapperSerial %s wrapper %s";
            Object[] objArr = new Object[3];
            objArr[0] = bA == null ? "" : bA.tnk;
            objArr[1] = c22622a == null ? "" : c22622a.toString();
            objArr[2] = c22622a2 == null ? "" : c22622a2.toString();
            C4990ab.m7417i(str, str2, objArr);
            if (c22622a != null && c22622a.tDR != null && !C5046bo.isNullOrNil(c22622a.tDR.tnk)) {
                this.toH.tzb = c22622a.tDR.tnk;
                AppMethodBeat.m2505o(47787);
                return;
            } else if (c22622a2 != null && c22622a2.tDR != null && !C5046bo.isNullOrNil(c22622a2.tDR.tnk)) {
                this.toH.tzb = c22622a2.tDR.tnk;
                AppMethodBeat.m2505o(47787);
                return;
            } else if (bA != null) {
                this.toH.tzb = bA.tnk;
                AppMethodBeat.m2505o(47787);
                return;
            } else {
                this.toH.tzb = bC;
                AppMethodBeat.m2505o(47787);
                return;
            }
        } else if (this.pWy.tAr != null) {
            this.toH = a.acX(a.acY(this.pWy.tAr.tmU));
            AppMethodBeat.m2505o(47787);
            return;
        }
        AppMethodBeat.m2505o(47787);
    }

    private void cSd() {
        AppMethodBeat.m2504i(47788);
        if (this.tMu) {
            C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "don't show foreign currency");
            if (this.tMj != null) {
                this.tLW.removeView(this.tMj);
                this.tMj = null;
            }
            AppMethodBeat.m2505o(47788);
            return;
        }
        if (!(C5046bo.isNullOrNil(this.pWy.tAI) || C5046bo.isNullOrNil(this.pWy.tAJ))) {
            this.tMj = new WcPayCashierDetailItemLayout(getContext());
            this.tLW.addView(this.tMj, 0);
            this.tMj.tLM.setVisibility(8);
            this.tMj.tLN.setVisibility(8);
            this.tMj.pQF.setText(C25738R.string.gax);
            StringBuilder stringBuilder;
            if (!this.pWy.tAI.equals("CNY") || C5046bo.isNullOrNil(this.pWy.tAH)) {
                stringBuilder = new StringBuilder(this.pWy.tAJ);
                stringBuilder.append(this.pWy.tAH);
                this.tMj.kRK.setText(stringBuilder);
            } else {
                stringBuilder = new StringBuilder(this.pWy.tAJ);
                stringBuilder.append(this.pWy.tAH);
                if (!(C5046bo.isNullOrNil(this.pWy.tAL) || C5046bo.isNullOrNil(this.pWy.tAM))) {
                    stringBuilder.append(String.format("(%s%s)", new Object[]{this.pWy.tAM, this.pWy.tAK}));
                }
                this.tMj.kRK.setText(stringBuilder);
                AppMethodBeat.m2505o(47788);
                return;
            }
        }
        AppMethodBeat.m2505o(47788);
    }

    private void cSe() {
        AppMethodBeat.m2504i(47789);
        C22621b a = C29666c.tDU.mo47919a(this.pWy);
        if (this.toH == null || !(a == null || a.cRi())) {
            this.tLW.removeView(this.tMi);
            this.tMi = null;
            AppMethodBeat.m2505o(47789);
            return;
        }
        if (this.tMi == null) {
            this.tMi = new WcPayCashierDetailItemLayout(getContext());
            this.tLW.addView(this.tMi);
            this.tMi.pQF.setText(C25738R.string.gaw);
            this.tMi.tLM.setVisibility(8);
            this.tMi.tLN.setVisibility(0);
            this.tMi.kRK.setTextColor(getContext().getResources().getColor(C25738R.color.f11664c4));
            this.tMi.setOnClickListener(new C44442());
        }
        m6802k(this.tMi.kRK);
        AppMethodBeat.m2505o(47789);
    }

    public final void show() {
        AppMethodBeat.m2504i(138093);
        super.show();
        AppMethodBeat.m2505o(138093);
    }

    /* renamed from: k */
    private void m6802k(TextView textView) {
        int i;
        AppMethodBeat.m2504i(47790);
        C22621b a = C29666c.tDU.mo47919a(this.pWy);
        C46330j acU = a.acU(this.toH.tzb);
        List cRl = a.cRl();
        StringBuilder stringBuilder = new StringBuilder();
        String str = "";
        if (acU != null && acU.tnb > 0.0d) {
            stringBuilder.append(acU.tnd);
            i = 1;
        } else if (cRl.size() > 0) {
            C46330j cRk = a.cRk();
            if (acU == null && a.cRj() == 1 && cRk != null && cRk.tnc == 0 && this.tMt && this.pWy.tAr.tnh != null && this.pWy.tAr.tnh.tmD == 1) {
                str = getContext().getString(C25738R.string.gat);
                i = 0;
            } else {
                str = getContext().getString(C25738R.string.fq0);
                i = 1;
            }
        } else {
            i = 1;
        }
        if (!(acU == null || acU.tnc == 0 || C5046bo.m7519ac(stringBuilder))) {
            stringBuilder.append(",");
            stringBuilder.append(acU.tne);
        }
        if (!C5046bo.m7519ac(stringBuilder) && !C5046bo.isNullOrNil(str)) {
            stringBuilder.append(",");
            stringBuilder.append(str);
        } else if (!C5046bo.isNullOrNil(str)) {
            stringBuilder.append(str);
        }
        C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "favor text: %s", stringBuilder.toString());
        if (i != 0) {
            textView.setTextColor(getContext().getResources().getColor(C25738R.color.f11664c4));
        } else {
            textView.setTextColor(getContext().getResources().getColor(C25738R.color.f12084rr));
        }
        textView.setText(str);
        AppMethodBeat.m2505o(47790);
    }

    private void cSf() {
        AppMethodBeat.m2504i(47791);
        if (this.tLW.getChildCount() == 0 && this.tMh.getVisibility() == 8) {
            C4990ab.m7410d("MicroMsg.WcPayCashierDialog", "invisible divider");
            this.lBD.setVisibility(8);
            AppMethodBeat.m2505o(47791);
            return;
        }
        this.lBD.setVisibility(0);
        AppMethodBeat.m2505o(47791);
    }

    private void cSg() {
        AppMethodBeat.m2504i(47792);
        if (this.tMu) {
            CharSequence format;
            if (this.tMg == null) {
                this.tMg = new WcPayCashierDetailItemLayout(getContext());
                this.tLW.addView(this.tMg, 0);
                this.tMg.pQF.setText(C25738R.string.gay);
                this.tMg.tLM.setVisibility(8);
                this.tMg.tLN.setVisibility(8);
                this.tMg.kRK.setTypeface(Typeface.createFromAsset(getContext().getAssets(), C36391e.m59976QQ(7)));
                this.tMg.kRK.getPaint().setFlags(16);
            }
            double b = C36391e.m59996b(this.pWy.tAH, "100", RoundingMode.HALF_UP);
            String str = "";
            if (b > 0.0d) {
                str = String.format("%s%s", new Object[]{this.pWy.tAJ, C36391e.m59971F(b)});
            }
            String e = C36391e.m60006e(this.pWy.pTN, this.pWy.pcl);
            if (C5046bo.isNullOrNil(str)) {
                Object format2 = e;
            } else {
                format2 = String.format("%s(%s)", new Object[]{e, str});
            }
            this.tMg.kRK.setText(format2);
            AppMethodBeat.m2505o(47792);
            return;
        }
        if (this.tMg != null) {
            this.tLW.removeView(this.tMg);
            this.tMg = null;
        }
        AppMethodBeat.m2505o(47792);
    }

    private void cSh() {
        AppMethodBeat.m2504i(47793);
        if (this.tMs) {
            this.tMh.setVisibility(0);
            this.tMh.pQF.setText(C25738R.string.gaz);
            this.tMh.tLM.setVisibility(0);
            this.tMh.tLN.setVisibility(0);
            this.tMh.setOnClickListener(new C44403());
            this.tMh.tLM.setImageBitmap(null);
            m6787a(this.tMq, this.tMh.tLM);
            CharSequence charSequence = this.tMq == null ? "" : this.tMq.field_desc;
            if (this.tMq != null && this.tMq.cPg()) {
                charSequence = C44089j.m79292b(this.mContext, charSequence);
            }
            this.tMh.kRK.setText(charSequence);
            AppMethodBeat.m2505o(47793);
            return;
        }
        C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "can not change pay way");
        this.tMh.setVisibility(8);
        AppMethodBeat.m2505o(47793);
    }

    /* renamed from: a */
    private void m6787a(Bankcard bankcard, CdnImageView cdnImageView) {
        AppMethodBeat.m2504i(47794);
        if (bankcard == null) {
            C4990ab.m7412e("MicroMsg.WcPayCashierDialog", "setBankcardText bankcard == null");
            AppMethodBeat.m2505o(47794);
        } else if (bankcard.cPc()) {
            cdnImageView.setImageResource(C25738R.drawable.bki);
            AppMethodBeat.m2505o(47794);
        } else if (bankcard.cPd()) {
            this.tln.mo63493a(bankcard, (ImageView) cdnImageView);
            AppMethodBeat.m2505o(47794);
        } else {
            if (bankcard.cPg()) {
                cdnImageView.setImageDrawable(C5147a.m7837f(getContext().getResources(), C1318a.honey_pay_bank_logo));
                if (!C5046bo.isNullOrNil(bankcard.txk)) {
                    cdnImageView.setUseSdcardCache(true);
                    cdnImageView.setImgSavedPath(C46362b.cRb());
                    cdnImageView.mo38952eb(bankcard.txk, C1318a.honey_pay_bank_logo);
                    AppMethodBeat.m2505o(47794);
                    return;
                }
            }
            this.tln.mo63491a(getContext(), bankcard, cdnImageView);
            AppMethodBeat.m2505o(47794);
        }
    }

    private void cSi() {
        AppMethodBeat.m2504i(47795);
        cSj();
        cSm();
        AppMethodBeat.m2505o(47795);
    }

    private void cSj() {
        CharSequence charSequence;
        AppMethodBeat.m2504i(47796);
        String str = "";
        if (this.tMy) {
            charSequence = this.tMw;
        } else {
            String string;
            String string2 = this.pVL.vwh == null ? "" : this.pVL.vwh.getString("extinfo_key_19", "");
            C7616ad aoM;
            Object[] objArr;
            Context context;
            if (!C5046bo.isNullOrNil(string2)) {
                str = string2;
            } else if (this.pVL.cIf == 32 || this.pVL.cIf == 33) {
                string2 = this.pVL.vwh.getString("extinfo_key_5", "");
                String string3 = this.pVL.vwh.getString("extinfo_key_1", "");
                string = getContext().getString(C25738R.string.fq3);
                if (!C5046bo.isNullOrNil(string2)) {
                    string = string2;
                    str = string2;
                }
                if (C5046bo.isNullOrNil(string3)) {
                    C4990ab.m7412e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(string3);
                    if (aoM != null) {
                        objArr = new Object[1];
                        objArr[0] = C36391e.atA(aoM.mo16707Oj()) + (C5046bo.isNullOrNil(this.pVL.pPw) ? "" : "(" + this.pVL.pPw + ")");
                        str = C5046bo.m7584t(string, objArr);
                    } else {
                        C4990ab.m7412e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(string3)));
                    }
                }
            } else if (this.pVL.cIf == 31) {
                string = this.pVL.vwh.getString("extinfo_key_1", "");
                if (C5046bo.isNullOrNil(string)) {
                    C4990ab.m7412e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(string);
                    if (aoM != null) {
                        string2 = aoM.mo16706Oi();
                        context = getContext();
                        objArr = new Object[1];
                        objArr[0] = string2 + (C5046bo.isNullOrNil(this.pVL.pPw) ? "" : "(" + this.pVL.pPw + ")");
                        str = context.getString(C25738R.string.fq3, objArr);
                    } else {
                        C4990ab.m7412e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(string)));
                    }
                }
            } else if (this.pVL.cIf == 42) {
                string = this.pVL.vwh.getString("extinfo_key_1", "");
                if (C5046bo.isNullOrNil(string)) {
                    C4990ab.m7412e("MicroMsg.WcPayCashierDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    C1720g.m3537RQ();
                    aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(string);
                    if (aoM != null) {
                        string2 = aoM.mo16706Oi();
                        context = getContext();
                        Object[] objArr2 = new Object[1];
                        objArr2[0] = string2 + (C5046bo.isNullOrNil(this.pVL.pPw) ? "" : "(" + this.pVL.pPw + ")");
                        str = context.getString(C25738R.string.fpx, objArr2);
                    } else {
                        C4990ab.m7412e("MicroMsg.WcPayCashierDialog", "can not found contact for user::".concat(String.valueOf(string)));
                    }
                }
            } else if (this.pVL.cIf == 48) {
                str = getContext().getString(C25738R.string.dfl);
            } else if (this.pVL.cIf == 49) {
                if (C5046bo.isNullOrNil(this.pVL.vwh.getString("extinfo_key_1", ""))) {
                    C4990ab.m7413e("MicroMsg.WcPayCashierDialog", "userName is null, scene is %s", Integer.valueOf(this.pVL.cIf));
                } else {
                    str = getContext().getString(C25738R.string.fq3, new Object[]{this.pVL.vwh.getString("extinfo_key_1", "")});
                }
            }
            if (!C5046bo.isNullOrNil(str) || this.pWy == null || this.pWy.tAq == null) {
                C4990ab.m7420w("MicroMsg.WcPayCashierDialog", "orders null?:" + (this.pWy == null));
            } else {
                Commodity commodity = (Commodity) this.pWy.tAq.get(0);
                if (commodity != null) {
                    charSequence = commodity.pca;
                    if (C4432b.m6791a(this.pVL)) {
                        if (!C5046bo.isNullOrNil(charSequence)) {
                            string = charSequence + IOUtils.LINE_SEPARATOR_UNIX;
                        }
                        charSequence = string + commodity.desc;
                    }
                    if (C5046bo.isNullOrNil(charSequence)) {
                        charSequence = commodity.desc;
                    }
                }
            }
            Object charSequence2 = str;
        }
        this.tLU.setText(charSequence2);
        AppMethodBeat.m2505o(47796);
    }

    private void cSk() {
        AppMethodBeat.m2504i(47797);
        if (C5046bo.isNullOrNil(this.tMv)) {
            this.tJL.setVisibility(8);
            AppMethodBeat.m2505o(47797);
            return;
        }
        this.tJL.setText(this.tMv);
        this.tJL.setVisibility(0);
        AppMethodBeat.m2505o(47797);
    }

    private void cSl() {
        AppMethodBeat.m2504i(47798);
        if (this.tMt && this.pWy.tAr.tnh != null && this.pWy.tAr.tnh.tmD == 1) {
            final C40049b c40049b = this.pWy.tAr.tnh;
            this.tMc.setUrl(c40049b.tmK);
            this.tMd.setText(c40049b.tmF);
            if (!C5046bo.isNullOrNil(c40049b.tmG)) {
                this.tMd.setTextColor(Color.parseColor(c40049b.tmG));
            }
            this.tMe.setText(c40049b.tmH);
            if (!C5046bo.isNullOrNil(c40049b.tmI)) {
                this.tMe.setTextColor(Color.parseColor(c40049b.tmI));
            }
            this.tMe.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(47762);
                    C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "click bank favor btn");
                    C4432b.this.tMt = false;
                    C4432b.this.tMq = C14241r.cPI().mo38170h(c40049b.tmC.pbo, false, false);
                    FavorPayInfo acX = C29666c.tDU.mo47919a(C4432b.this.pWy).acX(c40049b.tmE);
                    C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "set favor info: %s", acX.tzb);
                    if (acX.tzb.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        C4432b.m6814u(C4432b.this);
                    } else {
                        C4432b.this.toH = acX;
                    }
                    C4432b.m6809p(C4432b.this);
                    C4432b.m6810q(C4432b.this);
                    C4432b.m6815v(C4432b.this);
                    C4432b.m6816w(C4432b.this);
                    C4432b.m6817x(C4432b.this);
                    AppMethodBeat.m2505o(47762);
                }
            });
            m6785HA(0);
            AppMethodBeat.m2505o(47798);
            return;
        }
        m6785HA(8);
        AppMethodBeat.m2505o(47798);
    }

    /* renamed from: HA */
    private void m6785HA(int i) {
        AppMethodBeat.m2504i(47799);
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
        AppMethodBeat.m2505o(47799);
    }

    private void cSm() {
        CharSequence charSequence;
        AppMethodBeat.m2504i(47800);
        if (this.tMy) {
            charSequence = this.tMx;
        } else {
            C22621b a = C29666c.tDU.mo47919a(this.pWy);
            charSequence = C36391e.m60006e(this.pWy.pTN, this.pWy.pcl);
            this.tMu = false;
            if (a != null) {
                C46330j acU = a.acU(this.toH.tzb);
                List cRl = a.cRl();
                if (acU != null && acU.tnb > 0.0d) {
                    this.tMu = true;
                    charSequence = C36391e.m60006e(acU.tna, this.pWy.pcl);
                } else if (acU == null || cRl.size() <= 0) {
                    charSequence = C36391e.m60006e(this.pWy.pTN, this.pWy.pcl);
                } else {
                    charSequence = C36391e.m60006e(acU.tna, this.pWy.pcl);
                }
            }
        }
        this.tLV.setText(charSequence);
        AppMethodBeat.m2505o(47800);
    }

    /* renamed from: a */
    private static boolean m6791a(PayInfo payInfo) {
        if (payInfo == null || (payInfo.cIf != 31 && payInfo.cIf != 32 && payInfo.cIf != 33)) {
            return false;
        }
        return true;
    }

    private void cSn() {
        AppMethodBeat.m2504i(47801);
        cSo();
        C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "use touch pay: %s", Integer.valueOf(this.pWy.tAo));
        if (this.tMn == 0) {
            boolean z;
            if (this.tMo > 0) {
                z = false;
            } else if (this.tMp == 1 || this.tMp == 3) {
                this.tMa.setVisibility(8);
                z = true;
            } else {
                if (this.pVL.vwi == 100102) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, Boolean.TRUE);
                    C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
                    c30052l.mo48312hq(false);
                    c30052l.mo48313hr(false);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.FALSE);
                    this.tMa.setText(C25738R.string.ff5);
                } else {
                    this.tMa.setText(C25738R.string.fey);
                }
                this.tMa.setTextColor(getContext().getResources().getColor(C25738R.color.a53));
                this.tMa.setVisibility(0);
                z = true;
            }
            m6807nr(z);
            AppMethodBeat.m2505o(47801);
        } else if (this.tMn == 1) {
            cSp();
            AppMethodBeat.m2505o(47801);
        } else {
            if (this.tMn == 2) {
                cSq();
            }
            AppMethodBeat.m2505o(47801);
        }
    }

    private void cSo() {
        AppMethodBeat.m2504i(138559);
        C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "update verify way");
        if (this.pWy.tAo == 1) {
            boolean z;
            C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
            if (c30052l.bxn() && c30052l.bxo() && !c30052l.bxf() && c30052l.bxe()) {
                this.tMo = 1;
            } else if (c30052l.bxA() && c30052l.bxB() && !c30052l.bxg() && c30052l.bxh()) {
                this.tMo = 2;
            } else {
                this.tMo = 0;
                this.tMp = 2;
            }
            if (C14241r.cPI() == null || this.tMo <= 0) {
                z = true;
            } else {
                z = c30052l.bxz();
            }
            if (!z) {
                this.tMo = 0;
                this.tMp = 3;
            } else if (this.pVL.vwi == 100000 || this.pVL.vwi == 100102) {
                this.tMo = 0;
                this.tMp = 4;
            }
            this.tMn = this.tMo;
            C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "keystatus: %s, errcode: %s, payway: %s", Boolean.valueOf(z), Integer.valueOf(this.pVL.vwi), Integer.valueOf(this.tMn));
            AppMethodBeat.m2505o(138559);
            return;
        }
        this.tMn = 0;
        this.tMo = 0;
        this.tMp = 1;
        AppMethodBeat.m2505o(138559);
    }

    /* renamed from: nr */
    private void m6807nr(boolean z) {
        AppMethodBeat.m2504i(47802);
        C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "switch to pwd: %s", Boolean.valueOf(z));
        this.tMn = 0;
        this.tLY.setVisibility(0);
        this.tLZ.setVisibility(8);
        this.tMf.setVisibility(0);
        this.tLS.setVisibility(0);
        if (z) {
            this.tLT.setVisibility(8);
            AppMethodBeat.m2505o(47802);
            return;
        }
        this.tLT.setVisibility(0);
        AppMethodBeat.m2505o(47802);
    }

    private void cSp() {
        AppMethodBeat.m2504i(47803);
        this.tMn = 1;
        this.tLY.setVisibility(8);
        this.tLZ.setVisibility(0);
        this.tMf.setVisibility(8);
        this.tLS.setVisibility(8);
        this.tLT.setText(C25738R.string.fq6);
        AppMethodBeat.m2505o(47803);
    }

    private void cSq() {
        AppMethodBeat.m2504i(47804);
        this.tMn = 2;
        this.tLY.setVisibility(8);
        this.tLZ.setVisibility(0);
        this.tMf.setVisibility(8);
        this.tLS.setVisibility(8);
        this.tLT.setText(C25738R.string.fq6);
        AppMethodBeat.m2505o(47804);
    }

    /* renamed from: c */
    private void m6794c(boolean z, int i, final boolean z2) {
        int i2;
        String str;
        List ne;
        Object ne2;
        Bankcard bankcard;
        LinkedList g;
        AppMethodBeat.m2504i(47805);
        C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "go to bankcard dialog");
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
        C44422ad.m80306e(i2, str, 11, "");
        this.tMl = new C4423a(this.mContext);
        C4423a c4423a = this.tMl;
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
        C4990ab.m7417i(str2, str3, objArr);
        c4423a.pVL = payInfo;
        c4423a.pWy = orders;
        c4423a.toH = favorPayInfo;
        c4423a.f1287try = bankcard2;
        c4423a.tLC = orders.tuo;
        c4423a.tLD = z;
        c4423a.tLE = i;
        if (c4423a.tLD) {
            c4423a.tLF = false;
        }
        if (c4423a.pVL.cIf == 8) {
            ne2 = C22584ac.m34277ne(true);
        } else {
            ne2 = C22584ac.m34277ne(false);
        }
        if (c4423a.toH != null) {
            Object obj;
            if (c4423a.toH.tzc != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && c4423a.tLD) {
                String str4 = c4423a.toH.tzd;
                ArrayList arrayList = new ArrayList();
                i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= ne2.size()) {
                        break;
                    }
                    bankcard = (Bankcard) ne2.get(i3);
                    if (C5046bo.isNullOrNil(str4)) {
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
            WcPayCashierBankcardItemLayout wcPayCashierBankcardItemLayout = new WcPayCashierBankcardItemLayout(c4423a.getContext());
            c4423a.tLB.add(wcPayCashierBankcardItemLayout);
            c4423a.tLz.addView(wcPayCashierBankcardItemLayout);
            if (bankcard3.cPc()) {
                C40141a.m68840j(wcPayCashierBankcardItemLayout.kqn);
            } else if (bankcard3.cPd()) {
                c4423a.tln.mo63493a(bankcard3, wcPayCashierBankcardItemLayout.kqn);
            } else if (bankcard3.cPg()) {
                wcPayCashierBankcardItemLayout.kqn.setImageDrawable(C5147a.m7837f(c4423a.getContext().getResources(), C1318a.honey_pay_bank_logo));
                if (!C5046bo.isNullOrNil(bankcard3.txk)) {
                    wcPayCashierBankcardItemLayout.kqn.setUseSdcardCache(true);
                    wcPayCashierBankcardItemLayout.kqn.setImgSavedPath(C46362b.cRb());
                    wcPayCashierBankcardItemLayout.kqn.mo38952eb(bankcard3.txk, C1318a.honey_pay_bank_logo);
                }
            } else {
                c4423a.tln.mo63491a(c4423a.getContext(), bankcard3, wcPayCashierBankcardItemLayout.kqn);
            }
            Bankcard bankcard4;
            if (bankcard3.cPc()) {
                bankcard4 = C14241r.cPI().thy;
                if (!C5046bo.isNullOrNil(bankcard4.twT)) {
                    wcPayCashierBankcardItemLayout.tLJ.setText(bankcard4.twT);
                } else if (bankcard4.twS >= 0.0d) {
                    TextView textView = wcPayCashierBankcardItemLayout.tLJ;
                    Context context = c4423a.getContext();
                    c4423a.getContext();
                    textView.setText(context.getString(C44423ae.dOh(), new Object[]{C36391e.m59972G(bankcard4.twS)}));
                } else {
                    wcPayCashierBankcardItemLayout.tLJ.setText("");
                }
            } else if (bankcard3.cPd()) {
                bankcard4 = C14241r.cPI().tCZ;
                if (!C5046bo.isNullOrNil(bankcard4.twT)) {
                    wcPayCashierBankcardItemLayout.tLJ.setText(bankcard4.twT);
                } else if (bankcard4.twS >= 0.0d) {
                    wcPayCashierBankcardItemLayout.tLJ.setText(c4423a.getContext().getString(C25738R.string.fhz, new Object[]{C36391e.m59972G(bankcard4.twS)}));
                } else {
                    wcPayCashierBankcardItemLayout.tLJ.setText("");
                }
            } else if (bankcard3.cPg()) {
                wcPayCashierBankcardItemLayout.tLJ.setText(C44089j.m79293b(c4423a.getContext(), bankcard3.field_desc, wcPayCashierBankcardItemLayout.tLJ.getTextSize()));
            } else {
                wcPayCashierBankcardItemLayout.tLJ.setText(bankcard3.field_desc);
            }
            CharSequence charSequence = "";
            switch (bankcard3.mo69481a(c4423a.tLC, c4423a.pWy)) {
                case 1:
                    charSequence = c4423a.getContext().getString(C25738R.string.fnz);
                    break;
                case 2:
                    charSequence = c4423a.getContext().getString(C25738R.string.fo5);
                    break;
                case 3:
                    charSequence = c4423a.getContext().getString(C25738R.string.fo_);
                    break;
                case 4:
                    charSequence = c4423a.getContext().getString(C25738R.string.fo1);
                    break;
                case 5:
                    charSequence = c4423a.getContext().getString(C25738R.string.fnx);
                    break;
                case 6:
                    charSequence = c4423a.getContext().getString(C25738R.string.fo3);
                    break;
                case 7:
                    charSequence = c4423a.getContext().getString(C25738R.string.fo8);
                    break;
                case 8:
                    charSequence = bankcard3.field_forbidWord;
                    break;
                default:
                    if (!C5046bo.isNullOrNil(bankcard3.field_tips)) {
                        charSequence = bankcard3.field_tips;
                        break;
                    }
                    break;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            if (!(C5046bo.isNullOrNil(bankcard3.field_forbid_title) || C5046bo.isNullOrNil(bankcard3.field_forbid_url))) {
                spannableStringBuilder.append("  ");
                spannableStringBuilder.append(bankcard3.field_forbid_title);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(c4423a.getContext().getResources().getColor(C25738R.color.a4f)), charSequence.length() + 2, spannableStringBuilder.length(), 34);
                wcPayCashierBankcardItemLayout.tLK.setOnClickListener(new C44255(bankcard3));
            }
            if (!C5046bo.m7519ac(spannableStringBuilder)) {
                wcPayCashierBankcardItemLayout.tLK.setVisibility(0);
                wcPayCashierBankcardItemLayout.tLK.setText(spannableStringBuilder);
            }
            if (c4423a.tLF && C5046bo.m7519ac(spannableStringBuilder)) {
                g = c4423a.mo9460g(bankcard3);
                if (g.size() > 0) {
                    wcPayCashierBankcardItemLayout.tGP.setVisibility(0);
                    wcPayCashierBankcardItemLayout.tLK.setVisibility(8);
                    wcPayCashierBankcardItemLayout.tGP.setWording(g);
                }
            }
            if (c4423a.f1287try != null && bankcard3.field_bindSerial.equals(c4423a.f1287try.field_bindSerial)) {
                wcPayCashierBankcardItemLayout.tLL.setChecked(true);
            }
            if (bankcard3.mo69481a(c4423a.tLC, c4423a.pWy) != 0) {
                wcPayCashierBankcardItemLayout.tLL.setChecked(false);
                wcPayCashierBankcardItemLayout.tLJ.setTextColor(c4423a.getContext().getResources().getColor(C25738R.color.f12084rr));
                wcPayCashierBankcardItemLayout.setEnabled(false);
            } else {
                wcPayCashierBankcardItemLayout.tLJ.setTextColor(c4423a.getContext().getResources().getColor(C25738R.color.f11782h4));
                wcPayCashierBankcardItemLayout.setEnabled(true);
            }
            wcPayCashierBankcardItemLayout.setOnClickListener(new C44266(bankcard3));
        }
        WcPayCashierBankcardItemLayout wcPayCashierBankcardItemLayout2 = new WcPayCashierBankcardItemLayout(c4423a.getContext());
        wcPayCashierBankcardItemLayout2.kqn.setVisibility(4);
        wcPayCashierBankcardItemLayout2.tLJ.setText(C25738R.string.fnt);
        wcPayCashierBankcardItemLayout2.tLJ.setTextColor(c4423a.getContext().getResources().getColor(C25738R.color.f12123t7));
        wcPayCashierBankcardItemLayout2.tLL.setVisibility(8);
        g = c4423a.cRZ();
        if (c4423a.tLF && g.size() > 0) {
            wcPayCashierBankcardItemLayout2.tGP.setVisibility(0);
            wcPayCashierBankcardItemLayout2.tLK.setVisibility(8);
            wcPayCashierBankcardItemLayout2.tGP.setWording(g);
        }
        wcPayCashierBankcardItemLayout2.setOnClickListener(new C44277());
        c4423a.tLz.addView(wcPayCashierBankcardItemLayout2);
        CharSequence charSequence2 = "";
        if (!(c4423a.pWy == null || c4423a.pWy.tAq == null || c4423a.pWy.tAq.size() <= 0)) {
            charSequence2 = c4423a.getContext().getString(C25738R.string.fcy, new Object[]{C36391e.m60006e(c4423a.pWy.pTN, c4423a.pWy.pcl), ((Commodity) c4423a.pWy.tAq.get(0)).desc});
        }
        if (c4423a.toH != null && !C5046bo.isNullOrNil(c4423a.toH.tzf)) {
            c4423a.tLA.setVisibility(0);
            c4423a.tLA.setText(c4423a.toH.tzf);
            c4423a.toH.tzf = "";
        } else if (c4423a.tLE != 0) {
            c4423a.tLA.setVisibility(0);
            c4423a.tLA.setText(charSequence2);
        } else {
            c4423a.tLA.setVisibility(8);
        }
        this.tMB.add(this.tMl.tLH);
        this.tMl.tLG = new C4428a() {
            /* renamed from: i */
            public final void mo9467i(Bankcard bankcard) {
                int i = 0;
                AppMethodBeat.m2504i(47770);
                if (bankcard == null) {
                    AppMethodBeat.m2505o(47770);
                    return;
                }
                C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "on select bankcard: %s, %s", bankcard.field_bankName, bankcard.field_bindSerial);
                if (C4432b.this.tMq == null || !bankcard.field_bindSerial.equals(C4432b.this.tMq.field_bindSerial)) {
                    if (C4432b.this.pVL != null) {
                        i = C4432b.this.pVL.cIf;
                    }
                    C44422ad.m80306e(i, C4432b.this.pVL == null ? "" : C4432b.this.pVL.czZ, 13, bankcard.field_bindSerial);
                    C4432b.this.tMq = bankcard;
                    C4432b.m6814u(C4432b.this);
                    C4432b.m6809p(C4432b.this);
                    C4432b.m6810q(C4432b.this);
                    C4432b.m6815v(C4432b.this);
                    C4432b.m6816w(C4432b.this);
                    C4432b.m6782E(C4432b.this);
                }
                C4432b.this.tMl.mo9458a(C4432b.this);
                C4432b.this.tMl = null;
                C4432b.this.show();
                AppMethodBeat.m2505o(47770);
            }

            public final void cMN() {
                AppMethodBeat.m2504i(47771);
                C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
                C4432b.this.tMl.mo9458a(C4432b.this);
                C4432b.this.tMl = null;
                if (C4432b.this.tMA != null) {
                    C4432b.this.tMA.cMN();
                }
                AppMethodBeat.m2505o(47771);
            }

            public final void onCancel() {
                AppMethodBeat.m2504i(47772);
                C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "on bankcard dialog cancel");
                C4432b.this.tMl.mo9458a(C4432b.this);
                C4432b.this.tMl = null;
                if (z2) {
                    C4432b.this.cancel();
                    AppMethodBeat.m2505o(47772);
                    return;
                }
                C4432b.this.show();
                AppMethodBeat.m2505o(47772);
            }
        };
        this.tMl.show();
        AppMethodBeat.m2505o(47805);
    }

    /* renamed from: d */
    static /* synthetic */ void m6795d(C4432b c4432b) {
        AppMethodBeat.m2504i(47806);
        for (C4449b cSa : c4432b.tMB) {
            cSa.cSa();
        }
        AppMethodBeat.m2505o(47806);
    }

    /* renamed from: a */
    static /* synthetic */ void m6789a(C4432b c4432b, String str, FavorPayInfo favorPayInfo) {
        AppMethodBeat.m2504i(47807);
        if (!(c4432b.tMz || c4432b.tMA == null)) {
            c4432b.tMA.mo9483a(str, favorPayInfo, c4432b.tMq);
        }
        c4432b.dismiss();
        AppMethodBeat.m2505o(47807);
    }

    /* renamed from: i */
    static /* synthetic */ void m6800i(C4432b c4432b) {
        AppMethodBeat.m2504i(47809);
        C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "go to verify fingerprint");
        if (c4432b.tMk != null) {
            c4432b.tMk.dismiss();
        }
        C46261a.cvP();
        c4432b.tMr = false;
        c4432b.tMk = new C40124c(c4432b.getContext());
        C40124c c40124c = c4432b.tMk;
        C4990ab.m7417i("MicroMsg.WcPayCashierFingerprintDialog", "set view data: %s", c4432b.pVL.czZ);
        c40124c.tMK.czZ = r1;
        c4432b.tMk.tML = new C44415();
        ((MMActivity) c4432b.mContext).getLifecycle().addObserver(c4432b.tMk);
        c4432b.tMk.show();
        c4432b.ius.setVisibility(8);
        AppMethodBeat.m2505o(47809);
    }

    /* renamed from: j */
    static /* synthetic */ void m6801j(C4432b c4432b) {
        AppMethodBeat.m2504i(138560);
        C4990ab.m7416i("MicroMsg.WcPayCashierDialog", "go to verify faceid");
        C7060h.pYm.mo8381e(15817, Integer.valueOf(3));
        c4432b.tMr = false;
        C46261a.cvP();
        C11927i c11927i = (C11927i) C1720g.m3528K(C11927i.class);
        Bundle bundle = new Bundle();
        bundle.putInt("face_auth_scene", 1);
        c11927i.mo7361a((MMActivity) c4432b.mContext, new C44376(), bundle);
        c4432b.ius.setVisibility(8);
        AppMethodBeat.m2505o(138560);
    }

    /* renamed from: l */
    static /* synthetic */ void m6804l(C4432b c4432b) {
        int i = 0;
        AppMethodBeat.m2504i(138562);
        C4990ab.m7417i("MicroMsg.WcPayCashierDialog", "trigger switch mVerifyWay: %s", Integer.valueOf(c4432b.tMn));
        if (c4432b.tMn == 0) {
            if (c4432b.tMo == 1) {
                if (c4432b.pVL != null) {
                    i = c4432b.pVL.cIf;
                }
                C44422ad.m80306e(i, c4432b.pVL == null ? "" : c4432b.pVL.czZ, 21, "");
                c4432b.cSp();
                AppMethodBeat.m2505o(138562);
                return;
            } else if (c4432b.tMo == 2) {
                c4432b.cSq();
                AppMethodBeat.m2505o(138562);
                return;
            }
        } else if (c4432b.tMn == 1) {
            c4432b.m6807nr(false);
            c4432b.tLT.setText(C25738R.string.fez);
            C36391e.m59978QS(29);
            if (c4432b.pVL != null) {
                i = c4432b.pVL.cIf;
            }
            C44422ad.m80306e(i, c4432b.pVL == null ? "" : c4432b.pVL.czZ, 19, "");
            AppMethodBeat.m2505o(138562);
            return;
        } else if (c4432b.tMn == 2) {
            c4432b.m6807nr(false);
            c4432b.tLT.setText(C25738R.string.fer);
            C7060h.pYm.mo8381e(15817, Integer.valueOf(4));
        }
        AppMethodBeat.m2505o(138562);
    }

    /* renamed from: o */
    static /* synthetic */ void m6808o(C4432b c4432b) {
        AppMethodBeat.m2504i(138564);
        c4432b.m6794c(true, -100, false);
        AppMethodBeat.m2505o(138564);
    }

    /* renamed from: s */
    static /* synthetic */ void m6812s(C4432b c4432b) {
        AppMethodBeat.m2504i(47818);
        c4432b.m6794c(false, 0, false);
        AppMethodBeat.m2505o(47818);
    }

    /* renamed from: E */
    static /* synthetic */ void m6782E(C4432b c4432b) {
        AppMethodBeat.m2504i(138569);
        if (c4432b.tMt && c4432b.pWy.tAr.tnh != null && c4432b.pWy.tAr.tnh.tmD == 1 && c4432b.pWy.tAr.tnh.tmC != null) {
            FavorPayInfo acX = C29666c.tDU.mo47919a(c4432b.pWy).acX(c4432b.pWy.tAr.tnh.tmE);
            if (c4432b.tMq == null || acX.tzb.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || !acX.tzg.contains(c4432b.tMq.field_bindSerial)) {
                c4432b.m6785HA(0);
                AppMethodBeat.m2505o(138569);
                return;
            }
        }
        c4432b.m6785HA(8);
        AppMethodBeat.m2505o(138569);
    }
}
