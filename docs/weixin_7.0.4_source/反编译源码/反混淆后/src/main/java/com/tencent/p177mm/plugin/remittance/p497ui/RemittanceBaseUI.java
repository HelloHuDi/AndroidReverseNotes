package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17881i;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18267fx;
import com.tencent.p177mm.p230g.p231a.C37719fw;
import com.tencent.p177mm.p230g.p231a.C42071un;
import com.tencent.p177mm.p230g.p232b.p233a.C37823bh;
import com.tencent.p177mm.p230g.p232b.p233a.C46881bl;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.C5584f.C5583a;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.remittance.model.C13047ab;
import com.tencent.p177mm.plugin.remittance.model.C34808aa;
import com.tencent.p177mm.plugin.remittance.model.C39602t;
import com.tencent.p177mm.plugin.remittance.model.C39603v;
import com.tencent.p177mm.plugin.remittance.p1017a.C28850c;
import com.tencent.p177mm.plugin.remittance.p497ui.C13109c.C131102;
import com.tencent.p177mm.plugin.remittance.p497ui.C13109c.C131111;
import com.tencent.p177mm.plugin.remittance.p497ui.C13109c.C13112a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.C40052a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C46349b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C22657a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C22657a.C22665a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14223ad;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14224ae;
import com.tencent.p177mm.plugin.wallet_core.utils.C46374c;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C7282rn;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@C5271a(2)
/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI */
public abstract class RemittanceBaseUI extends WalletBaseUI implements C8915a {
    private String cEW;
    protected int cKs = 0;
    protected String edV;
    protected String eeO;
    protected Button gHn;
    protected int gOW;
    private final int gnS = C1338a.fromDPToPix(C4996ah.getContext(), 270);
    protected WalletFormView kGa;
    protected String kux;
    protected String mName;
    protected ScrollView nsk;
    private int obL;
    private double pPt;
    protected C40052a pQU = null;
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
    private Map<String, C43463a> pRF = new HashMap();
    private String pRG;
    protected boolean pRH = false;
    private C39603v pRI;
    private C37823bh pRJ;
    private boolean pRK = false;
    private C4884c pRL = new C434656();
    private boolean pRM = false;
    private boolean pRN = false;
    private boolean pRO = false;
    private boolean pRP = false;
    private C7282rn pRQ = null;
    private C4884c pRR = new C2165124();
    protected double pRS = 0.0d;
    protected String pRT = "";
    protected String pRU = "";
    protected String pRV = "";
    private C4884c<C18267fx> pRW = new C3960626();
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

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$17 */
    class C372417 implements C22665a {
        C372417() {
        }

        /* renamed from: a */
        public final boolean mo8358a(boolean z, String str, String str2, String str3, String str4) {
            AppMethodBeat.m2504i(44841);
            RemittanceBaseUI.this.pRt = z;
            if (C5046bo.isNullOrNil(str)) {
                RemittanceBaseUI.this.eeO = null;
            } else {
                RemittanceBaseUI.this.eeO = str;
            }
            if (!RemittanceBaseUI.this.pRt) {
                if (C5046bo.isNullOrNil(str2)) {
                    RemittanceBaseUI.this.mName = null;
                } else {
                    RemittanceBaseUI.this.mName = str2;
                }
                if (C5046bo.isNullOrNil(str3)) {
                    RemittanceBaseUI.this.pdC = null;
                } else {
                    RemittanceBaseUI.this.pdC = str3;
                }
                if (C5046bo.isNullOrNil(str4)) {
                    RemittanceBaseUI.this.pRs = null;
                } else {
                    RemittanceBaseUI.this.pRs = str4;
                }
            }
            RemittanceBaseUI.m77597c(RemittanceBaseUI.this);
            RemittanceBaseUI.m77599d(RemittanceBaseUI.this);
            AppMethodBeat.m2505o(44841);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$19 */
    class C372519 implements C13112a {
        C372519() {
        }

        /* renamed from: VS */
        public final void mo8359VS(String str) {
            AppMethodBeat.m2504i(44844);
            C4990ab.m7417i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", str);
            RemittanceBaseUI.this.pRE = str;
            RemittanceBaseUI.this.cfL();
            AppMethodBeat.m2505o(44844);
        }

        public final void onCancel() {
            RemittanceBaseUI.this.pRE = "";
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$18 */
    class C704118 implements C5662c {

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$18$1 */
        class C70421 implements Runnable {
            C70421() {
            }

            public final void run() {
                AppMethodBeat.m2504i(44842);
                RemittanceBaseUI.this.aqX();
                AppMethodBeat.m2505o(44842);
            }
        }

        C704118() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            AppMethodBeat.m2504i(44843);
            C5004al.m7442n(new C70421(), 500);
            AppMethodBeat.m2505o(44843);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$22 */
    class C1305522 implements OnClickListener {
        C1305522() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$5 */
    class C130565 implements View.OnClickListener {
        C130565() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44829);
            C46179f.m86308a(RemittanceBaseUI.this, RemittanceBaseUI.this.gOW, RemittanceBaseUI.this.pRv, RemittanceBaseUI.this.pPt);
            if (RemittanceBaseUI.this.gOW == 1) {
                C7060h.pYm.mo8381e(12689, Integer.valueOf(13), Integer.valueOf(1));
                AppMethodBeat.m2505o(44829);
                return;
            }
            C7060h.pYm.mo8381e(12689, Integer.valueOf(4), Integer.valueOf(1));
            AppMethodBeat.m2505o(44829);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$24 */
    class C2165124 extends C4884c<C37719fw> {
        C2165124() {
            AppMethodBeat.m2504i(44854);
            this.xxI = C37719fw.class.getName().hashCode();
            AppMethodBeat.m2505o(44854);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44855);
            C37719fw c37719fw = (C37719fw) c4883b;
            if (c37719fw.czT.czW == 1) {
                C7060h.pYm.mo8381e(15386, Integer.valueOf(4), Integer.valueOf(1));
            } else {
                C7060h.pYm.mo8381e(15386, Integer.valueOf(5), Integer.valueOf(1));
            }
            String str = c37719fw.czT.czU;
            C4990ab.m7417i("MicroMsg.RemittanceBaseUI", "receive dynamic req: %s, %s", Integer.valueOf(c37719fw.czT.czW), str);
            if (RemittanceBaseUI.this.pQY == 33) {
                RemittanceBaseUI.this.mo37144a(RemittanceBaseUI.this.eeO, RemittanceBaseUI.this.pQZ, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.pdC, RemittanceBaseUI.this.pRs, RemittanceBaseUI.this.pRu, str, c37719fw);
            } else {
                RemittanceBaseUI.this.mo37144a(RemittanceBaseUI.this.eeO, RemittanceBaseUI.this.pQZ, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.pdC, RemittanceBaseUI.this.pRs, null, str, c37719fw);
            }
            AppMethodBeat.m2505o(44855);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$3 */
    class C216533 implements TextWatcher {
        C216533() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(44827);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 2) {
                editable.delete(indexOf + 3, length);
            }
            AppMethodBeat.m2505o(44827);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$12 */
    class C2887212 extends C24019s {
        C2887212() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(44836);
            if (RemittanceBaseUI.this.pQY == 33) {
                RemittanceBaseUI.this.mo37144a(RemittanceBaseUI.this.eeO, RemittanceBaseUI.this.pQZ, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.pdC, RemittanceBaseUI.this.pRs, RemittanceBaseUI.this.pRu, "", null);
            } else {
                RemittanceBaseUI.this.pQV = C5046bo.getDouble(RemittanceBaseUI.this.kGa.getText(), 0.0d);
                if (!RemittanceBaseUI.this.kGa.asa()) {
                    C23639t.makeText(RemittanceBaseUI.this.mController.ylL, C25738R.string.f9y, 0).show();
                } else if (RemittanceBaseUI.this.pQV < 0.01d) {
                    RemittanceBaseUI.this.cfC();
                } else {
                    RemittanceBaseUI.this.aoB();
                    RemittanceBaseUI.cfO();
                    RemittanceBaseUI.this.mo37144a(RemittanceBaseUI.this.eeO, RemittanceBaseUI.this.pQZ, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.pdC, RemittanceBaseUI.this.pRs, null, "", null);
                }
            }
            if (RemittanceBaseUI.this.pPt == 0.0d) {
                if (RemittanceBaseUI.this.gOW == 1) {
                    C7060h.pYm.mo8381e(12689, Integer.valueOf(15), Integer.valueOf(1));
                } else {
                    C7060h.pYm.mo8381e(12689, Integer.valueOf(6), Integer.valueOf(1));
                }
            }
            if (RemittanceBaseUI.this.gOW == 1 && !C5046bo.isNullOrNil(RemittanceBaseUI.this.eeO)) {
                C7060h.pYm.mo8381e(14074, Integer.valueOf(2));
            }
            AppMethodBeat.m2505o(44836);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$23 */
    class C2887423 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$23$1 */
        class C216471 implements C22665a {
            C216471() {
            }

            /* renamed from: a */
            public final boolean mo8358a(boolean z, String str, String str2, String str3, String str4) {
                AppMethodBeat.m2504i(44847);
                RemittanceBaseUI.this.pRt = z;
                if (C5046bo.isNullOrNil(str)) {
                    RemittanceBaseUI.this.eeO = null;
                } else {
                    RemittanceBaseUI.this.eeO = str;
                }
                if (RemittanceBaseUI.this.pRt) {
                    RemittanceBaseUI.this.mName = null;
                    RemittanceBaseUI.this.pdC = null;
                    RemittanceBaseUI.this.pRs = null;
                } else {
                    if (C5046bo.isNullOrNil(str2)) {
                        RemittanceBaseUI.this.mName = null;
                    } else {
                        RemittanceBaseUI.this.mName = str2;
                    }
                    if (C5046bo.isNullOrNil(str3)) {
                        RemittanceBaseUI.this.pdC = null;
                    } else {
                        RemittanceBaseUI.this.pdC = str3;
                    }
                    if (C5046bo.isNullOrNil(str4)) {
                        RemittanceBaseUI.this.pRs = null;
                    } else {
                        RemittanceBaseUI.this.pRs = str4;
                    }
                }
                RemittanceBaseUI.m77597c(RemittanceBaseUI.this);
                RemittanceBaseUI.m77599d(RemittanceBaseUI.this);
                AppMethodBeat.m2505o(44847);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$23$2 */
        class C216482 implements C5662c {

            /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$23$2$1 */
            class C216491 implements Runnable {
                C216491() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(44848);
                    RemittanceBaseUI.this.aqX();
                    AppMethodBeat.m2505o(44848);
                }
            }

            C216482() {
            }

            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
                AppMethodBeat.m2504i(44849);
                C5004al.m7442n(new C216491(), 500);
                AppMethodBeat.m2505o(44849);
            }
        }

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$23$3 */
        class C288733 implements C30387b {
            C288733() {
            }

            /* renamed from: s */
            public final boolean mo4760s(CharSequence charSequence) {
                AppMethodBeat.m2504i(44850);
                if (C5046bo.isNullOrNil(charSequence.toString())) {
                    RemittanceBaseUI.this.eeO = null;
                    RemittanceBaseUI.m77599d(RemittanceBaseUI.this);
                } else {
                    RemittanceBaseUI.this.eeO = charSequence.toString();
                    RemittanceBaseUI.m77599d(RemittanceBaseUI.this);
                }
                AppMethodBeat.m2505o(44850);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$23$4 */
        class C288754 implements OnClickListener {

            /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$23$4$1 */
            class C216501 implements Runnable {
                C216501() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(44851);
                    RemittanceBaseUI.this.aqX();
                    AppMethodBeat.m2505o(44851);
                }
            }

            C288754() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(44852);
                C5004al.m7442n(new C216501(), 500);
                AppMethodBeat.m2505o(44852);
            }
        }

        C2887423() {
        }

        public final void onClick(View view) {
            String string;
            String string2;
            AppMethodBeat.m2504i(44853);
            RemittanceBaseUI.this.aoB();
            RemittanceBaseUI.cfO();
            C7060h.pYm.mo8381e(12689, Integer.valueOf(9), Integer.valueOf(1));
            if (RemittanceBaseUI.this.gOW == 1 || RemittanceBaseUI.this.gOW == 6) {
                string = RemittanceBaseUI.this.getString(C25738R.string.dni);
                string2 = RemittanceBaseUI.this.getString(C25738R.string.do7);
                C7060h.pYm.mo8381e(14074, Integer.valueOf(1));
            } else {
                string = RemittanceBaseUI.this.getString(C25738R.string.dnh);
                string2 = RemittanceBaseUI.this.getString(C25738R.string.dnn);
                if (C5046bo.m7563gW(RemittanceBaseUI.this.pQZ, 0) && RemittanceBaseUI.this.pRa) {
                    C22657a.m34349a(RemittanceBaseUI.this, string, RemittanceBaseUI.this.eeO, string2, RemittanceBaseUI.this.pRt, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.pdC, RemittanceBaseUI.this.pRs, new C216471(), new C216482());
                    AppMethodBeat.m2505o(44853);
                    return;
                }
            }
            C22657a.m34348a(RemittanceBaseUI.this, string, RemittanceBaseUI.this.eeO, string2, 20, new C288733(), new C288754());
            AppMethodBeat.m2505o(44853);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$2 */
    class C288772 implements View.OnClickListener {
        C288772() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44826);
            RemittanceBaseUI.this.aoB();
            RemittanceBaseUI.cfO();
            AppMethodBeat.m2505o(44826);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$15 */
    class C3481115 implements OnClickListener {
        C3481115() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(44839);
            C24143a.m37114b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
            AppMethodBeat.m2505o(44839);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$1 */
    class C348131 implements OnMenuItemClickListener {
        C348131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44825);
            if (RemittanceBaseUI.this.gOW == 1 || RemittanceBaseUI.this.gOW == 6) {
                RemittanceBaseUI.this.cfA();
                RemittanceBaseUI.this.finish();
            } else if (RemittanceBaseUI.this.gOW == 2 || RemittanceBaseUI.this.gOW == 5) {
                RemittanceBaseUI.this.finish();
            } else {
                RemittanceBaseUI.this.cfM();
            }
            RemittanceBaseUI.this.cfB();
            AppMethodBeat.m2505o(44825);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$28 */
    class C3481428 implements OnGlobalLayoutListener {
        C3481428() {
        }

        public final void onGlobalLayout() {
            int[] iArr;
            int measuredHeight;
            AppMethodBeat.m2504i(44859);
            int height = ((WindowManager) RemittanceBaseUI.this.getSystemService("window")).getDefaultDisplay().getHeight();
            int[] iArr2 = new int[2];
            if (RemittanceBaseUI.this.pRr.getTag(RemittanceBaseUI.this.pRr.getId()) == null) {
                RemittanceBaseUI.this.pRr.getLocationOnScreen(iArr2);
                RemittanceBaseUI.this.pRr.setTag(RemittanceBaseUI.this.pRr.getId(), iArr2);
                iArr = iArr2;
            } else {
                iArr = (int[]) RemittanceBaseUI.this.pRr.getTag(RemittanceBaseUI.this.pRr.getId());
            }
            int fromDPToPix = C1338a.fromDPToPix(RemittanceBaseUI.this, 40) + (iArr[1] + RemittanceBaseUI.this.pRr.getMeasuredHeight());
            if (RemittanceBaseUI.this.nTi.getVisibility() == 0) {
                measuredHeight = RemittanceBaseUI.this.nTi.getMeasuredHeight();
            } else {
                measuredHeight = 0;
            }
            int fromDPToPix2 = C1338a.fromDPToPix(RemittanceBaseUI.this, 96) + measuredHeight;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) RemittanceBaseUI.this.pRq.getLayoutParams();
            if (height - fromDPToPix >= RemittanceBaseUI.this.pRq.getMeasuredHeight() + fromDPToPix2) {
                marginLayoutParams.topMargin = (((height - fromDPToPix2) - RemittanceBaseUI.this.pRq.getMeasuredHeight()) - iArr[1]) - RemittanceBaseUI.this.pRr.getMeasuredHeight();
            } else {
                marginLayoutParams.topMargin = C1338a.fromDPToPix(RemittanceBaseUI.this, 40);
            }
            marginLayoutParams.bottomMargin = C1338a.fromDPToPix(RemittanceBaseUI.this, 96);
            RemittanceBaseUI.this.pRq.setLayoutParams(marginLayoutParams);
            RemittanceBaseUI.this.pRq.setVisibility(0);
            RemittanceBaseUI.this.pRq.requestLayout();
            AppMethodBeat.m2505o(44859);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$29 */
    class C3481529 implements OnMenuItemClickListener {
        C3481529() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44860);
            C36391e.m60016n(RemittanceBaseUI.this.mController.ylL, RemittanceBaseUI.this.pRz, false);
            AppMethodBeat.m2505o(44860);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$4 */
    class C348164 implements C40947a {
        C348164() {
        }

        /* renamed from: ic */
        public final void mo9448ic(boolean z) {
            AppMethodBeat.m2504i(44828);
            if (z) {
                RemittanceBaseUI.this.mo39974b(RemittanceBaseUI.this.nsk, RemittanceBaseUI.this.gHn, 30);
                AppMethodBeat.m2505o(44828);
                return;
            }
            RemittanceBaseUI.this.nsk.scrollTo(0, 0);
            AppMethodBeat.m2505o(44828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$26 */
    class C3960626 extends C4884c<C18267fx> {
        C3960626() {
            AppMethodBeat.m2504i(44857);
            this.xxI = C18267fx.class.getName().hashCode();
            AppMethodBeat.m2505o(44857);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44858);
            C18267fx c18267fx = (C18267fx) c4883b;
            RemittanceBaseUI.m77588a(RemittanceBaseUI.this, c18267fx.czY.czZ, c18267fx.czY.cAa);
            AppMethodBeat.m2505o(44858);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$31 */
    class C4345931 implements Runnable {
        C4345931() {
        }

        public final void run() {
            AppMethodBeat.m2504i(44862);
            Bitmap a = C41730b.m73490a(RemittanceBaseUI.this.edV, false, -1);
            if (a == null) {
                RemittanceBaseUI.this.pRc.setImageResource(C25738R.drawable.ad2);
                AppMethodBeat.m2505o(44862);
                return;
            }
            RemittanceBaseUI.this.pRc.setImageBitmap(a);
            AppMethodBeat.m2505o(44862);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$8 */
    class C434618 implements OnClickListener {
        C434618() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$a */
    static class C43463a {
        String cAa;
        String cEa;
        String kBE;
        String kDV;
        int nUf;
        String pPC;
        String pPx;
        String pPy;
        long pSg;

        C43463a(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, long j) {
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

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$27 */
    class C4346427 implements OnClickListener {
        C4346427() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI$6 */
    class C434656 extends C4884c<C42071un> {
        C434656() {
            AppMethodBeat.m2504i(44830);
            this.xxI = C42071un.class.getName().hashCode();
            AppMethodBeat.m2505o(44830);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44831);
            if (C5046bo.isEqual(RemittanceBaseUI.this.pRI.getUri(), ((C42071un) c4883b).cQI.uri) && C5046bo.m7563gW(RemittanceBaseUI.this.pRI.nZf, 1)) {
                RemittanceBaseUI.this.finish();
            }
            AppMethodBeat.m2505o(44831);
            return false;
        }
    }

    /* renamed from: a */
    public abstract void mo37144a(String str, int i, String str2, String str3, String str4, String str5, String str6, C37719fw c37719fw);

    public abstract void cfC();

    public abstract void cfG();

    public abstract void cfz();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static /* synthetic */ void cfO() {
    }

    public int getLayoutId() {
        if (this.pQY == 33 || this.pQY == 32) {
            return 2130970515;
        }
        if (!C5046bo.m7563gW(this.pQZ, 0)) {
            return 2130970514;
        }
        dyb();
        return 2130970516;
    }

    public void onCreate(Bundle bundle) {
        this.gOW = getIntent().getIntExtra("scene", 0);
        this.pQY = getIntent().getIntExtra("pay_scene", 31);
        if (!cfK()) {
            this.cEW = UUID.randomUUID().toString();
            C46349b.acq(this.cEW);
        }
        if (this instanceof RemittanceUI) {
            this.pQZ = 0;
        } else if (this instanceof RemittanceHKUI) {
            this.pQZ = 1;
        } else if (this instanceof RemittanceOSUI) {
            this.pQZ = 2;
        }
        super.onCreate(bundle);
        this.pQU = C40052a.m68624at(getIntent());
        this.pRb = getIntent().getStringExtra("scan_remittance_id");
        this.pQV = getIntent().getDoubleExtra("fee", 0.0d);
        this.edV = getIntent().getStringExtra("receiver_name");
        this.kux = getIntent().getStringExtra("receiver_nick_name");
        this.pRx = getIntent().getStringExtra("receiver_true_name");
        this.pQW = getIntent().getStringExtra("mch_name");
        this.pQX = getIntent().getStringExtra("mch_info");
        this.obL = getIntent().getIntExtra("pay_channel", 0);
        this.pRC = C5046bo.m7532bc(getIntent().getStringExtra("rcvr_open_id"), "");
        C4990ab.m7417i("MicroMsg.RemittanceBaseUI", "mUserName %s", this.edV);
        C1720g.m3537RQ();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(147457, Long.valueOf(0))).longValue();
        if ((16 & longValue) != 0) {
            this.pRB = 1;
        } else if ((longValue & 32) != 0) {
            this.pRB = 2;
        } else {
            this.pRB = 0;
        }
        cfz();
        C17884o.acd().mo67498a((C8915a) this);
        initView();
        this.pRW.dnU();
    }

    public void onDestroy() {
        super.onDestroy();
        C4879a.xxA.mo10053d(this.pRL);
        C17884o.acd().mo67500b(this);
        this.pRW.dead();
        this.pRR.dead();
        C46349b.acr(this.cEW);
    }

    public void cfA() {
        C1207m c39602t = new C39602t(this.edV, this.pRb);
        c39602t.eHT = "RemittanceProcess";
        mo39970a(c39602t, true, true);
    }

    public void cfB() {
    }

    public final void initView() {
        if (this.pQY == 33 || this.pQY == 32) {
            setMMTitle((int) C25738R.string.dnw);
        } else {
            setMMTitle((int) C25738R.string.dqi);
        }
        setBackBtn(new C348131());
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
        this.nTi = findViewById(2131822356);
        this.nsk = (ScrollView) findViewById(2131820884);
        this.pRc = (ImageView) findViewById(2131827085);
        this.pRd = (TextView) findViewById(2131827086);
        this.pRe = (TextView) findViewById(2131827087);
        this.pRe.setVisibility(8);
        this.pRm = (LinearLayout) findViewById(2131827088);
        this.pRl = (LinearLayout) findViewById(2131827089);
        this.pRj = (TextView) findViewById(2131827092);
        this.pRk = (TextView) findViewById(2131827091);
        this.pRi = (TextView) findViewById(2131827090);
        if (C5046bo.m7563gW(this.pQZ, 0)) {
            this.pRn = (LinearLayout) findViewById(2131827032);
            this.pRo = (TextView) findViewById(2131827035);
            this.pRp = (TextView) findViewById(2131827036);
        }
        cfH();
        cfJ();
        this.gHn = (Button) findViewById(2131822846);
        this.gHn.setOnClickListener(new C2887212());
        this.pRg = (TextView) findViewById(2131822844);
        this.pRh = (TextView) findViewById(2131827093);
        if (this.gOW == 1 || this.gOW == 6) {
            this.pRh.setText(C25738R.string.dni);
        } else {
            this.pRh.setText(C25738R.string.dnh);
        }
        if (!C1853r.m3831YM()) {
            findViewById(2131822843).setOnClickListener(new C2887423());
        }
        if (this.gOW == 1) {
            C1720g.m3537RQ();
            if (((String) C1720g.m3536RP().mo5239Ry().get(327732, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                C30379h.m48431a(this.mController.ylL, (int) C25738R.string.dpb, (int) C25738R.string.dpc, new C4346427());
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(327732, (Object) "1");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().dsb();
            }
        }
        this.pRf = (TextView) findViewById(2131827094);
        this.pRq = (LinearLayout) findViewById(2131827097);
        this.pRr = (LinearLayout) findViewById(2131822841);
        cfF();
        cfG();
        cfE();
        if (this.pQY != 33 && this.pQY != 32) {
            cfD();
        }
    }

    private void cfD() {
        if (C5046bo.m7563gW(this.pQZ, 0)) {
            this.pRq.setVisibility(4);
            this.nTi.getViewTreeObserver().addOnGlobalLayoutListener(new C3481428());
        }
    }

    private void cfE() {
        if (!cfK() || C5046bo.isNullOrNil(this.pRz) || this.pRB == 0 || this.pRA != 1) {
            this.mController.removeAllOptionMenu();
        } else {
            addIconOptionMenu(0, C25738R.drawable.bli, new C3481529());
        }
    }

    private void cfF() {
        if (C5046bo.isNullOrNil(this.pRy) || this.pRB == 0) {
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
            C4990ab.printErrStackTrace("MicroMsg.RemittanceBaseUI", e, "", new Object[0]);
            this.pRf.setText(getString(C25738R.string.dph, new Object[]{Integer.valueOf(i)}));
        }
        this.pRf.setVisibility(0);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cfH() {
        int i;
        CharSequence eK = C36391e.m60007eK(C36391e.m60015mJ(this.edV), 10);
        if (!C5046bo.isNullOrNil(this.pRx)) {
            eK = getString(C25738R.string.do0, new Object[]{eK, this.pRx});
        }
        String stringExtra;
        if (this.gOW == 1) {
            stringExtra = getIntent().getStringExtra("receiver_tips");
            this.pRd.setTextColor(getResources().getColor(C25738R.color.f11782h4));
            this.pRe.setVisibility(0);
            if (C5046bo.isNullOrNil(this.edV)) {
                eK = getString(C25738R.string.do3, new Object[]{this.pRx});
            } else {
                eK = getString(C25738R.string.do2, new Object[]{C36391e.m60007eK(C36391e.m60015mJ(this.edV), 10), this.pRx});
            }
            this.pRe.setText(C44089j.m79293b((Context) this, eK, this.pRe.getTextSize()));
            eK = stringExtra;
        } else if (this.gOW == 6) {
            stringExtra = getIntent().getStringExtra("receiver_tips");
            if (C5046bo.isNullOrNil(stringExtra)) {
                eK = getString(C25738R.string.do1, new Object[]{eK});
            } else {
                eK = C5046bo.m7584t(stringExtra, eK);
            }
        }
        this.pRd.setText(C44089j.m79293b((Context) this, eK, this.pRd.getTextSize()));
        if (C1720g.m3531RK()) {
            C17881i act = C17884o.act();
            if (!(act == null || C5046bo.isNullOrNil(this.edV))) {
                C17880h qo = act.mo33392qo(this.edV);
                if (qo == null || C5046bo.isNullOrNil(qo.acl())) {
                    final long anU = C5046bo.anU();
                    C26417a.flu.mo20966a(this.edV, "", new C9636a() {
                        /* renamed from: o */
                        public final void mo6218o(String str, boolean z) {
                            AppMethodBeat.m2504i(44861);
                            if (z) {
                                C4990ab.m7418v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (C5046bo.anU() - anU) + " ms");
                                C41730b.m73489U(str, 3);
                            } else {
                                C4990ab.m7420w("MicroMsg.RemittanceBaseUI", "getContact failed");
                            }
                            RemittanceBaseUI.this.cfI();
                            AppMethodBeat.m2505o(44861);
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
        final C4345931 c4345931 = new C4345931();
        if (C5004al.isMainThread()) {
            c4345931.run();
        } else {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(44863);
                    c4345931.run();
                    AppMethodBeat.m2505o(44863);
                }
            });
        }
    }

    private void cfJ() {
        this.kGa = (WalletFormView) findViewById(2131822842);
        if (this.pQY == 33) {
            this.pRj.setText(C36391e.m59971F(this.pQV));
            this.pRk.setText(C44423ae.dOd());
            this.pRu = getIntent().getStringExtra("desc");
            if (C5046bo.isNullOrNil(this.pRu)) {
                this.pRi.setVisibility(8);
            } else {
                this.pRi.setText(C44089j.m79293b(this.mController.ylL, this.pRu, this.pRi.getTextSize()));
                this.pRi.setVisibility(0);
            }
            this.pRl.setVisibility(0);
            this.pRm.setVisibility(8);
            return;
        }
        this.kGa.setOnClickListener(new C288772());
        this.kGa.getTitleTv().setText(String.format(getString(C25738R.string.dp9), new Object[]{"¥"}));
        this.kGa.mo64594a(new C216533());
        mo39989e(this.kGa, 2, false);
        findViewById(2131827094);
        findViewById(2131822841).setVisibility(0);
        this.pRl.setVisibility(8);
        this.pRm.setVisibility(0);
        this.obM = new C348164();
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        this.pRE = "";
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C39603v) {
                C39603v c39603v = (C39603v) c1207m;
                C44422ad.m80307o(this.pQY, c39603v.cBT, i2);
                this.pRw = c39603v.pPo;
                if (!C5046bo.isNullOrNil(c39603v.pPw)) {
                    this.pRx = c39603v.pPw;
                }
                if (this.pQY == 32 || this.pQY == 33) {
                    this.pRG = c39603v.kBE;
                } else {
                    this.pRG = c39603v.cEa;
                }
                if (this.pQU != null) {
                    this.pQU.mo63380i(Downloads.MIN_WAIT_FOR_NETWORK, Integer.valueOf(this.pQY), this.edV, Double.valueOf(c39603v.pPz));
                }
                String str2 = c39603v.pPM == null ? "" : C5046bo.isNullOrNil(c39603v.pPM.pRD) ? this.pRD : c39603v.pPM.pRD;
                this.pRD = str2;
                if (!m77590a(c39603v)) {
                    mo69018a(c39603v.cBT, this.edV, this.pRx, c39603v);
                }
                this.pRF.put(c39603v.cBT, new C43463a(c39603v.pPx, c39603v.kBE, c39603v.kDV, c39603v.pPy, c39603v.nUf, c39603v.cEa, c39603v.cAa, c39603v.pPC, C5046bo.getLong(c39603v.pPA, 0)));
            } else if (c1207m instanceof C14223ad) {
                C14223ad c14223ad = (C14223ad) c1207m;
                if (!C5046bo.isNullOrNil(c14223ad.tuy)) {
                    ((TextView) findViewById(2131827096)).setText(c14223ad.tuy);
                    View findViewById = findViewById(2131827095);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new C130565());
                }
                this.pRv = c14223ad.pRv;
                this.pPt = c14223ad.pPt;
                if (this.pPt == 0.0d) {
                    if (this.gOW == 1) {
                        C7060h.pYm.mo8381e(12689, Integer.valueOf(14), Integer.valueOf(1));
                    } else {
                        C7060h.pYm.mo8381e(12689, Integer.valueOf(5), Integer.valueOf(1));
                    }
                }
            } else if (c1207m instanceof C14224ae) {
                this.pRy = ((C14224ae) c1207m).tuA;
                this.pRz = ((C14224ae) c1207m).tuE;
                this.pRA = ((C14224ae) c1207m).tuF;
                cfF();
                cfE();
            }
            return true;
        }
        if (c1207m instanceof C14224ae) {
            C4990ab.m7416i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
            this.pRf.setText("");
            this.pRf.setVisibility(8);
        } else if (c1207m instanceof C39603v) {
            this.pRI = (C39603v) c1207m;
            C4879a.xxA.mo10051b(this.pRL);
            C44422ad.m80307o(this.pQY, "", i2);
            if (m77598c((C39603v) c1207m)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m77590a(C39603v c39603v) {
        boolean z;
        if (this.pRM) {
            z = false;
        } else {
            z = m77600d(c39603v);
        }
        if (!(z || this.pRN)) {
            z = m77602e(c39603v);
        }
        if (!(z || this.pRO)) {
            z = m77604f(c39603v);
        }
        if (!(z || this.pRP)) {
            z = m77598c(c39603v);
        }
        if (z || C5046bo.isNullOrNil(c39603v.pPA) || C5046bo.isNullOrNil(c39603v.pPB)) {
            return z;
        }
        String eK = C36391e.m60007eK(C36391e.m60015mJ(this.edV), 10);
        if (!C5046bo.isNullOrNil(this.pRx)) {
            eK = getString(C25738R.string.do0, new Object[]{eK, this.pRx});
        }
        return m77592a(c39603v.cBT, c39603v.pPB, eK, c39603v.pPA, c39603v);
    }

    /* renamed from: b */
    private static boolean m77596b(C39603v c39603v) {
        if (c39603v.pPL == 1 && c39603v.pPM != null) {
            return true;
        }
        if (c39603v.pPM == null || c39603v.pPM.vYN <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m77598c(final C39603v c39603v) {
        if (c39603v.cMO == null || !c39603v.cMO.cPa()) {
            return false;
        }
        this.pRP = true;
        C30379h.m48466d(this, c39603v.cMO.cEh, "", c39603v.cMO.nZc, c39603v.cMO.nZb, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(44832);
                C4990ab.m7417i("MicroMsg.RemittanceBaseUI", "goto h5: %s", c39603v.cMO.kCs);
                C36391e.m60016n(RemittanceBaseUI.this.mController.ylL, c39603v.cMO.kCs, false);
                AppMethodBeat.m2505o(44832);
            }
        }, new C434618());
        return true;
    }

    /* renamed from: d */
    private boolean m77600d(final C39603v c39603v) {
        if (C5046bo.isNullOrNil(c39603v.pPn)) {
            return false;
        }
        this.pRM = true;
        m77593aY(1, c39603v.cEa);
        C30379h.m48466d(this, c39603v.pPn, getString(C25738R.string.f9213t6), getString(C25738R.string.do6), getString(C25738R.string.f9076or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(44833);
                RemittanceBaseUI.this.m77593aY(3, c39603v.cEa);
                if (!RemittanceBaseUI.this.m77590a(c39603v)) {
                    RemittanceBaseUI.this.mo69018a(c39603v.cBT, RemittanceBaseUI.this.edV, RemittanceBaseUI.this.pRx, c39603v);
                }
                AppMethodBeat.m2505o(44833);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(44834);
                RemittanceBaseUI.this.m77593aY(2, c39603v.cEa);
                AppMethodBeat.m2505o(44834);
            }
        });
        return true;
    }

    /* renamed from: aY */
    private void m77593aY(int i, String str) {
        this.pRJ = new C37823bh();
        this.pRJ.cVR = 2;
        this.pRJ.cVS = (long) i;
        this.pRJ.mo60528gd(str);
        this.pRJ.ajK();
    }

    /* renamed from: e */
    private boolean m77602e(final C39603v c39603v) {
        if (c39603v.pPl <= 0) {
            return false;
        }
        this.pRN = true;
        if (c39603v.pPm != null) {
            String string;
            String string2;
            if (C5046bo.isNullOrNil(c39603v.pPm.cEh)) {
                string = getString(C25738R.string.dq1, new Object[]{Integer.valueOf(c39603v.pPl)});
            } else {
                string = c39603v.pPm.cEh;
            }
            String str = "";
            String string3 = getString(C25738R.string.do6);
            if (C5046bo.isNullOrNil(c39603v.pPm.pPN)) {
                string2 = getString(C25738R.string.dpq);
            } else {
                string2 = c39603v.pPm.pPN;
            }
            RemittanceBaseUI.m77584a(this, string, str, string3, string2, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(44835);
                    if (!RemittanceBaseUI.this.m77590a(c39603v)) {
                        RemittanceBaseUI.this.mo69018a(c39603v.cBT, RemittanceBaseUI.this.edV, RemittanceBaseUI.this.pRx, c39603v);
                    }
                    AppMethodBeat.m2505o(44835);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(44837);
                    if (C5046bo.isNullOrNil(c39603v.pPm.pPO)) {
                        C24143a.m37114b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
                        AppMethodBeat.m2505o(44837);
                        return;
                    }
                    C32921a.m53856b(RemittanceBaseUI.this, c39603v.pPm.pPO, 5, true);
                    AppMethodBeat.m2505o(44837);
                }
            });
        } else {
            C4990ab.m7416i("MicroMsg.RemittanceBaseUI", "scene.zaituMessage == null");
            RemittanceBaseUI.m77584a(this, getString(C25738R.string.dq1, new Object[]{Integer.valueOf(c39603v.pPl)}), getString(C25738R.string.f9213t6), getString(C25738R.string.do6), getString(C25738R.string.dpq), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(44838);
                    if (!RemittanceBaseUI.this.m77590a(c39603v)) {
                        RemittanceBaseUI.this.mo69018a(c39603v.cBT, RemittanceBaseUI.this.edV, RemittanceBaseUI.this.pRx, c39603v);
                    }
                    AppMethodBeat.m2505o(44838);
                }
            }, new C3481115());
        }
        return true;
    }

    /* renamed from: a */
    private static void m77584a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        C5652a c5652a = new C5652a(context);
        c5652a.asD(str2);
        c5652a.asE(str);
        c5652a.asJ(str3).mo11457a(onClickListener);
        c5652a.asK(str4).mo11476b(onClickListener2);
        c5652a.mo11482rc(false);
        c5652a.mo11483rd(true);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        C30379h.m48455a(context, aMb);
    }

    /* renamed from: f */
    private boolean m77604f(final C39603v c39603v) {
        if (!c39603v.pPs) {
            return false;
        }
        this.pRO = true;
        C46179f.m86307a(this, this.gOW, c39603v.pPv / 100.0d, c39603v.pPu / 100.0d, c39603v.pPp / 100.0d, c39603v.pPr, new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(44840);
                RemittanceBaseUI.this.mo69018a(c39603v.cBT, RemittanceBaseUI.this.edV, RemittanceBaseUI.this.pRx, c39603v);
                if (RemittanceBaseUI.this.gOW == 1) {
                    C7060h.pYm.mo8381e(12689, Integer.valueOf(12), Integer.valueOf(1));
                    AppMethodBeat.m2505o(44840);
                    return;
                }
                C7060h.pYm.mo8381e(12689, Integer.valueOf(3), Integer.valueOf(1));
                AppMethodBeat.m2505o(44840);
            }
        });
        return true;
    }

    /* renamed from: VT */
    private static void m77582VT(String str) {
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.RemittanceBaseUI", "msgxml is null");
            return;
        }
        String decode = URLDecoder.decode(str);
        C4990ab.m7416i("MicroMsg.RemittanceBaseUI", "helios:".concat(String.valueOf(decode)));
        String str2 = (String) C5049br.m7595z(decode, "msg").get(".msg.appmsg.wcpayinfo.transferid");
        if (TextUtils.isEmpty(str2)) {
            C4990ab.m7412e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
            return;
        }
        C34808aa ceZ = C28850c.ceW().ceZ();
        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(decode)) {
            C4990ab.m7412e(C34808aa.TAG, "saveMsgContent param error");
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
        C4990ab.m7416i("MicroMsg.RemittanceBaseUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.edV);
        switch (i) {
            case 1:
                if (i2 != -1) {
                    z = false;
                }
                m77589a(z, intent);
                break;
            case 2:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
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
                m77589a(z2, intent);
                break;
            case 6:
                if (i2 == -1 && intent != null) {
                    aoB();
                    String string = getString(C25738R.string.a4w);
                    String string2 = getString(C25738R.string.do7);
                    String stringExtra2 = intent.getStringExtra("userName");
                    String stringExtra3 = intent.getStringExtra("telNumber");
                    String str = intent.getStringExtra("proviceFirstStageName") + intent.getStringExtra("addressCitySecondStageName") + intent.getStringExtra("addressCountiesThirdStageName") + intent.getStringExtra("addressDetailInfo");
                    C22657a.m34349a(this, string, this.eeO, string2, false, stringExtra2, stringExtra3, str, new C372417(), new C704118());
                    break;
                }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* renamed from: a */
    private void m77589a(boolean z, Intent intent) {
        if (z) {
            if (this.pRH) {
                C7060h.pYm.mo8381e(15386, Integer.valueOf(3), Integer.valueOf(1));
            }
            String stringExtra = intent.getStringExtra("key_trans_id");
            if (C5046bo.isNullOrNil(this.pRG)) {
                this.pRG = stringExtra;
            }
            if (!(this.pQY == 33 || this.pQY == 32)) {
                C13047ab.m21032VQ(this.edV);
            }
            if (this.pPt == 0.0d) {
                if (this.gOW == 1) {
                    C7060h.pYm.mo8381e(12689, Integer.valueOf(17), Integer.valueOf(1));
                } else {
                    C7060h.pYm.mo8381e(12689, Integer.valueOf(8), Integer.valueOf(1));
                }
            }
            finish();
        } else if (C46374c.m87176aw(intent)) {
            finish();
            return;
        } else if (!C46374c.m87177ax(intent)) {
            if (this.gOW == 1) {
                C7060h.pYm.mo8381e(12689, Integer.valueOf(16), Integer.valueOf(1));
            } else {
                C7060h.pYm.mo8381e(12689, Integer.valueOf(7), Integer.valueOf(1));
            }
        } else {
            return;
        }
        if (C5046bo.m7563gW(this.pQZ, 0)) {
            m77595b(z, intent);
        }
    }

    /* renamed from: a */
    private void m77585a(C39603v c39603v, C7282rn c7282rn) {
        this.pRK = true;
        C13109c c13109c = new C13109c(this);
        c13109c.pQJ = new C372519();
        c13109c.pPM = c7282rn;
        View inflate = View.inflate(c13109c.mContext, 2130970465, null);
        TextView textView = (TextView) inflate.findViewById(2131826873);
        EditText editText = (EditText) inflate.findViewById(2131826872);
        ((MMNeat7extView) inflate.findViewById(2131821019)).mo15921ah(c13109c.pPM.cEh);
        textView.setText(c7282rn.pcw);
        C5659a c5659a = new C5659a(c13109c.mContext);
        c5659a.mo11514al(c13109c.pPM.title).mo11524fo(inflate);
        C7357c d = C7357c.m12555d(editText);
        d.jeZ = C5583a.MODE_CHINESE_AS_1;
        d = d.mo15880hz(1, 1);
        d.zIx = false;
        d.mo15879a(null);
        C5004al.m7442n(new C131111(editText), 200);
        C46881bl c46881bl = new C46881bl();
        c46881bl.dcq = (long) c39603v.nUf;
        c46881bl = c46881bl.mo76060ge(c39603v.username);
        c46881bl.dck = 1;
        c46881bl.ajK();
        c5659a.mo11523c(new C131102(c39603v, editText)).show();
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo69018a(String str, String str2, String str3, C39603v c39603v) {
        C46881bl c46881bl;
        if (!RemittanceBaseUI.m77596b(c39603v)) {
            if (this.pRK) {
                c46881bl = new C46881bl();
                c46881bl.dcq = (long) c39603v.nUf;
                c46881bl = c46881bl.mo76060ge(c39603v.username);
                c46881bl.dck = 5;
                c46881bl.ajK();
            }
            this.pRK = false;
            if (this.pQY == 31) {
                RemittanceBaseUI.m77582VT(this.pRw);
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
            if (c39603v != null) {
                bundle.putString("extinfo_key_19", c39603v.pPJ);
            }
            int i = 0;
            if (this.gOW == 1 && c39603v != null) {
                bundle.putString("extinfo_key_11", c39603v.pPx);
                bundle.putInt("extinfo_key_12", c39603v.pPD);
                bundle.putString("extinfo_key_13", c39603v.pPE);
                bundle.putString("extinfo_key_14", c39603v.pPF);
                bundle.putString("extinfo_key_17", c39603v.pPH);
                bundle.putString("extinfo_key_18", c39603v.pPI);
                i = c39603v.pPG;
            }
            if (c39603v != null) {
                bundle.putInt("extinfo_key_15", c39603v.nUf);
            }
            if (this.pRa) {
                bundle.putBoolean("extinfo_key_23", this.pRa);
                bundle.putString("extinfo_key_24", this.mName);
                bundle.putString("extinfo_key_25", this.pdC);
                bundle.putString("extinfo_key_26", this.pRs);
            }
            payInfo.vwh = bundle;
            Intent intent = new Intent();
            C4990ab.m7417i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", Integer.valueOf(i));
            if (i == 1) {
                intent.setClass(this, RemittanceF2fDynamicCodeUI.class);
                intent.putExtra("key_pay_info", payInfo);
                intent.putExtra("key_rcvr_open_id", this.pRC);
                intent.putExtra("key_mch_info", this.pQX);
                intent.putExtra("from_patch_ui", true);
                intent.putExtra("get_dynamic_code_sign", c39603v.pPH);
                intent.putExtra("get_dynamic_code_extend", c39603v.pPI);
                intent.putExtra("dynamic_code_spam_wording", c39603v.pPK);
                intent.putExtra("show_paying_wording", c39603v.pPJ);
                intent.putExtra("key_transfer_qrcode_id", this.pRb);
                C7060h.pYm.mo8381e(15386, Integer.valueOf(2), Integer.valueOf(1));
                this.pRR.dnU();
                startActivityForResult(intent, 5);
                return;
            }
            C40052a.m68623a(this.pQU, intent);
            payInfo.vwp = this.cEW;
            payInfo.aPn = this.pRH;
            if (c39603v.pOV == null || c39603v.pOV.czT.czX == null) {
                C35899h.m58857a(this, false, "", payInfo, str3, intent, 1);
                return;
            }
            C35899h.m58857a(c39603v.pOV.czT.czX, false, "", payInfo, str3, intent, c39603v.pOV.czT.czV);
        } else if (c39603v.pPM.vYN == 0) {
            this.pRQ = c39603v.pPM;
            m77585a(c39603v, c39603v.pPM);
        } else if (c39603v.pPM.vYN == 1) {
            c46881bl = new C46881bl();
            c46881bl.dcq = (long) ((int) c39603v.pPz);
            c46881bl = c46881bl.mo76060ge(c39603v.username);
            c46881bl.dck = 4;
            c46881bl.ajK();
            String str4 = c39603v.pPM.cEh;
            String str5 = c39603v.pPM.title;
            String string = getResources().getString(C25738R.string.dqm);
            String string2 = getResources().getString(C25738R.string.dql);
            final C39603v c39603v2 = c39603v;
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            C4345720 c4345720 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(44845);
                    C4990ab.m7417i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", RemittanceBaseUI.this.pRQ);
                    C46881bl c46881bl = new C46881bl();
                    c46881bl.dcq = (long) ((int) c39603v2.pPz);
                    c46881bl = c46881bl.mo76060ge(c39603v2.username);
                    c46881bl.dck = 9;
                    c46881bl.ajK();
                    c39603v2.pPM = null;
                    RemittanceBaseUI.this.mo69018a(str6, str7, str8, c39603v2);
                    AppMethodBeat.m2505o(44845);
                }
            };
            final C39603v c39603v3 = c39603v;
            C30379h.m48444a((Context) this, str4, str5, string, string2, (OnClickListener) c4345720, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(44846);
                    C4990ab.m7416i("MicroMsg.RemittanceBaseUI", "onClick1");
                    C46881bl c46881bl = new C46881bl();
                    c46881bl.dcq = (long) ((int) c39603v3.pPz);
                    c46881bl = c46881bl.mo76060ge(c39603v3.username);
                    c46881bl.dck = 8;
                    c46881bl.ajK();
                    AppMethodBeat.m2505o(44846);
                }
            }, (int) C25738R.color.f12246xd);
        } else if (c39603v.pPM.vYN == 2) {
            C30379h.m48443a((Context) this, c39603v.pPM.cEh, c39603v.pPM.title, getResources().getString(C25738R.string.g0z), new C1305522());
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cfL() {
        if (this.pQY == 33) {
            mo37144a(this.eeO, this.pQZ, this.mName, this.pdC, this.pRs, this.pRu, "", null);
            return;
        }
        mo37144a(this.eeO, this.pQZ, this.mName, this.pdC, this.pRs, null, "", null);
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    public void cfM() {
        Intent intent = new Intent();
        intent.putExtra("recent_remittance_contact_list", C13047ab.cfr());
        intent.setClass(this.mController.ylL, SelectRemittanceContactUI.class);
        startActivityForResult(intent, 2);
    }

    /* renamed from: qj */
    public void mo20342qj(String str) {
        C4990ab.m7416i("MicroMsg.RemittanceBaseUI", "onGet");
        if (C5046bo.nullAsNil(str).length() <= 0) {
            C4990ab.m7412e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = ".concat(String.valueOf(str)));
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

    /* renamed from: a */
    private boolean m77592a(final String str, String str2, String str3, String str4, final C39603v c39603v) {
        View inflate = LayoutInflater.from(this).inflate(2130970519, null);
        TextView textView = (TextView) inflate.findViewById(2131827132);
        TextView textView2 = (TextView) inflate.findViewById(2131827133);
        ((TextView) inflate.findViewById(2131827131)).setText(str2);
        textView.setText(C44089j.m79293b((Context) this, (CharSequence) str3, textView.getTextSize()));
        Double valueOf = Double.valueOf(C5046bo.getDouble(str4, 0.0d));
        textView2.setText(String.format("%s%.2f", new Object[]{C44423ae.dOd(), Double.valueOf(valueOf.doubleValue() / 100.0d)}));
        C5652a c5652a = new C5652a(this);
        c5652a.mo11482rc(false);
        c5652a.mo11446PV(C25738R.string.dqd);
        c5652a.mo11479fn(inflate);
        c5652a.mo11453Qc(C25738R.string.do6);
        c5652a.mo11454Qd(C25738R.string.abn);
        c5652a.mo11457a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(44856);
                RemittanceBaseUI.this.mo69018a(str, RemittanceBaseUI.this.edV, RemittanceBaseUI.this.pRx, c39603v);
                AppMethodBeat.m2505o(44856);
            }
        });
        c5652a.aMb().show();
        return true;
    }

    /* renamed from: b */
    private void m77595b(boolean z, Intent intent) {
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
        C4990ab.m7417i("MicroMsg.RemittanceBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", Integer.valueOf(this.cKs), Double.valueOf(this.pRS), this.pRT, this.pRU, this.pRV);
    }
}
