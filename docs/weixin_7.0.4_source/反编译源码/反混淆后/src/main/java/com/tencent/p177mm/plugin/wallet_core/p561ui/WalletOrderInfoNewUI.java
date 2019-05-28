package com.tencent.p177mm.plugin.wallet_core.p561ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18216ap;
import com.tencent.p177mm.p230g.p231a.C18218aq;
import com.tencent.p177mm.p230g.p231a.C32565gq;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p230g.p231a.C45334iy;
import com.tencent.p177mm.p230g.p231a.C45334iy.C26168a;
import com.tencent.p177mm.p230g.p231a.C9489us;
import com.tencent.p177mm.p230g.p232b.p233a.C26276bg;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fingerprint.p413b.C11927i;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.WalletSuccPageAwardWidget;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22561h;
import com.tencent.p177mm.plugin.wallet_core.p749c.C29618k;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.p749c.C40093aa;
import com.tencent.p177mm.plugin.wallet_core.p749c.C46360n;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C23372bc;
import com.tencent.p177mm.protocal.protobuf.aeq;
import com.tencent.p177mm.protocal.protobuf.bnu;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.p649c.C44431r;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;
import p1121d.p1122a.p1123a.C31176c;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI */
public class WalletOrderInfoNewUI extends WalletOrderInfoUI {
    private String igi = null;
    private String mAppId = "";
    private String oXY;
    private C31176c pSK;
    private WalletSuccPageAwardWidget pSL;
    private ViewGroup pSM;
    private ViewGroup pSN;
    private ViewGroup pSO;
    private TextView pSP;
    private boolean pSQ = false;
    private C4884c<C32652uv> pSR = new C1429614();
    private PayInfo pVL;
    private String pVl;
    private TextView pWB;
    private C4884c pap = new C142911();
    private String pdC = null;
    private boolean tEC = false;
    private String tED;
    private String tEE;
    private C14289b tEG;
    private HashMap<String, C14282a> tEH = new HashMap();
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
    private C40931c tEX;
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
    private C4884c tIy = new C142989();
    private Orders tog;
    private int tzY;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$18 */
    class C1427718 implements OnClickListener {
        C1427718() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47444);
            WalletOrderInfoNewUI.this.done();
            AppMethodBeat.m2505o(47444);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$5 */
    class C142785 implements View.OnClickListener {
        C142785() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47430);
            C4990ab.m7416i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
            WalletOrderInfoNewUI.m22480q(WalletOrderInfoNewUI.this);
            AppMethodBeat.m2505o(47430);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$8 */
    class C142808 implements C30391c {
        C142808() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(47433);
            switch (i) {
                case 0:
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletOrderInfoNewUI.this.pdC).toString()));
                    intent.addFlags(268435456);
                    WalletOrderInfoNewUI.this.startActivity(intent);
                    break;
            }
            AppMethodBeat.m2505o(47433);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$10 */
    class C1428110 implements OnClickListener {
        C1428110() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47436);
            WalletOrderInfoNewUI.this.cRH();
            AppMethodBeat.m2505o(47436);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$a */
    static class C14282a {
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

        public C14282a(JSONObject jSONObject) {
            AppMethodBeat.m2504i(47447);
            if (jSONObject == null) {
                AppMethodBeat.m2505o(47447);
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
            AppMethodBeat.m2505o(47447);
        }

        public C14282a(bnu bnu) {
            AppMethodBeat.m2504i(47448);
            if (!(bnu == null || bnu.wQV == null)) {
                C23372bc c23372bc = bnu.wQV;
                this.url = c23372bc.url;
                this.cEh = c23372bc.cEh;
                this.cIY = c23372bc.cIY;
                this.tID = c23372bc.tID;
                this.title = c23372bc.title;
                this.tzW = c23372bc.tzW;
                this.ttg = c23372bc.ttg;
                this.tIE = c23372bc.tIE;
                this.ttf = this.title;
                this.tzU = this.cIY;
                this.tzV = this.cEh;
                this.tzX = this.tID;
            }
            AppMethodBeat.m2505o(47448);
        }

        public final String toString() {
            AppMethodBeat.m2504i(47449);
            String str = this.url + " , " + this.cEh + " , " + this.cIY + " , " + this.tID + " , " + this.title;
            AppMethodBeat.m2505o(47449);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$17 */
    class C1428417 implements Runnable {
        C1428417() {
        }

        public final void run() {
            int i;
            int i2;
            AppMethodBeat.m2504i(47443);
            int height = WalletOrderInfoNewUI.this.tET.getHeight();
            int height2 = WalletOrderInfoNewUI.this.findViewById(2131825792).getHeight();
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
                i3 = WalletOrderInfoNewUI.this.findViewById(2131828703).getBottom();
            }
            if (WalletOrderInfoNewUI.this.tIp.getVisibility() == 0 || WalletOrderInfoNewUI.this.tIs.getVisibility() == 0) {
                i = height;
            } else {
                i = C1338a.fromDPToPix(WalletOrderInfoNewUI.this, 70) + height;
            }
            height = (height2 - i3) - i;
            int fromDPToPix = C1338a.fromDPToPix(WalletOrderInfoNewUI.this, 50);
            C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(height2), Integer.valueOf(height), Integer.valueOf(fromDPToPix));
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) WalletOrderInfoNewUI.this.tET.getLayoutParams();
            if (height > fromDPToPix) {
                marginLayoutParams.topMargin = height;
            } else {
                marginLayoutParams.topMargin = fromDPToPix;
            }
            WalletOrderInfoNewUI.this.tET.setLayoutParams(marginLayoutParams);
            WalletOrderInfoNewUI.this.tET.setVisibility(0);
            AppMethodBeat.m2505o(47443);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$19 */
    class C1428519 implements OnClickListener {
        C1428519() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47445);
            WalletOrderInfoNewUI.this.finish();
            AppMethodBeat.m2505o(47445);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$20 */
    class C1428620 implements View.OnClickListener {
        C1428620() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47446);
            if (!C5046bo.isNullOrNil(WalletOrderInfoNewUI.this.tIf)) {
                if (WalletOrderInfoNewUI.this.tIc.contains(WalletOrderInfoNewUI.this.tIf)) {
                    WalletOrderInfoNewUI.this.tIc.remove(WalletOrderInfoNewUI.this.tIf);
                    WalletOrderInfoNewUI.this.tIr.setChecked(false);
                    AppMethodBeat.m2505o(47446);
                    return;
                }
                WalletOrderInfoNewUI.this.tIc.add(WalletOrderInfoNewUI.this.tIf);
                WalletOrderInfoNewUI.this.tIr.setChecked(true);
            }
            AppMethodBeat.m2505o(47446);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$4 */
    class C142874 implements View.OnClickListener {
        C142874() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47429);
            C4990ab.m7416i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
            WalletOrderInfoNewUI.m22480q(WalletOrderInfoNewUI.this);
            AppMethodBeat.m2505o(47429);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$7 */
    class C142887 implements Runnable {
        C142887() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47432);
            try {
                if (WalletOrderInfoNewUI.this.tES.getVisibility() == 0 && WalletOrderInfoNewUI.this.tEP.getRight() > 0 && WalletOrderInfoNewUI.this.tES.getLeft() > 0 && WalletOrderInfoNewUI.this.tEP.getRight() >= WalletOrderInfoNewUI.this.tES.getLeft() && !C5046bo.m7519ac(WalletOrderInfoNewUI.this.tEP.getText())) {
                    float textSize = WalletOrderInfoNewUI.this.tEP.getTextSize();
                    C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", Integer.valueOf(WalletOrderInfoNewUI.this.tEP.getRight()), Integer.valueOf(WalletOrderInfoNewUI.this.tES.getLeft()));
                    Paint paint = new Paint();
                    paint.setTextSize(textSize);
                    String charSequence = WalletOrderInfoNewUI.this.tEP.getText().toString();
                    float left = (float) (WalletOrderInfoNewUI.this.tES.getLeft() - WalletOrderInfoNewUI.this.tEP.getLeft());
                    int i = 1;
                    while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > left && i <= charSequence.length() - 1) {
                        i++;
                    }
                    C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i), Integer.valueOf(charSequence.length()));
                    CharSequence substring = charSequence.substring(0, (charSequence.length() - i) - 1);
                    if (charSequence.length() > 9 && substring.length() < 9) {
                        substring = charSequence.substring(0, 9);
                    }
                    WalletOrderInfoNewUI.this.tEP.setText(substring);
                    WalletOrderInfoNewUI.this.tEP.append("...");
                }
                AppMethodBeat.m2505o(47432);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", e, "calc tinyapp name error: %s", e.getMessage());
                AppMethodBeat.m2505o(47432);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$b */
    static class C14289b {
        public String cBT;
        public String pQe;
        public long tBC;
        public String tIF;
        public String tIG;
        public String tIH;
        public long tII;
        public String tIJ;
        public String tuv;

        public C14289b(String str, String str2, String str3, String str4, String str5, String str6, long j, String str7) {
            this.tuv = str;
            this.tIF = str2;
            this.tIG = str3;
            this.tIH = str4;
            this.cBT = str5;
            this.pQe = str6;
            this.tBC = j;
            this.tIJ = str7;
        }

        public C14289b(String str, String str2, String str3, String str4, String str5, String str6, long j, long j2) {
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

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$13 */
    class C1429013 implements OnClickListener {
        C1429013() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$1 */
    class C142911 extends C4884c<C9489us> {
        C142911() {
            AppMethodBeat.m2504i(47425);
            this.xxI = C9489us.class.getName().hashCode();
            AppMethodBeat.m2505o(47425);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47426);
            C9489us c9489us = (C9489us) c4883b;
            if (c9489us instanceof C9489us) {
                if (!c9489us.cRy.cRz.oZd) {
                    C4990ab.m7416i("MicroMsg.WalletOrderInfoNewUI", "block pass");
                    AppMethodBeat.m2505o(47426);
                    return true;
                } else if ("1".equals(c9489us.cRy.cRz.cRb) || "2".equals(c9489us.cRy.cRz.cRb)) {
                    RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                    realnameGuideHelper.mo74571a(c9489us.cRy.cRz.cRb, c9489us.cRy.cRz.cRc, c9489us.cRy.cRz.cRd, c9489us.cRy.cRz.cRe, c9489us.cRy.cRz.cRf, WalletOrderInfoNewUI.this.pVL == null ? 0 : WalletOrderInfoNewUI.this.pVL.cIf);
                    C4990ab.m7416i("MicroMsg.WalletOrderInfoNewUI", "receive guide");
                    WalletOrderInfoNewUI.this.mBundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            AppMethodBeat.m2505o(47426);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$11 */
    class C1429311 implements OnClickListener {
        C1429311() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47437);
            WalletOrderInfoNewUI.this.cRH();
            AppMethodBeat.m2505o(47437);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$15 */
    class C1429415 implements View.OnClickListener {
        C1429415() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47441);
            WalletOrderInfoNewUI.this.done();
            AppMethodBeat.m2505o(47441);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$12 */
    class C1429512 implements OnClickListener {
        C1429512() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$14 */
    class C1429614 extends C4884c<C32652uv> {

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$14$1 */
        class C142761 implements Runnable {
            C142761() {
            }

            public final void run() {
                AppMethodBeat.m2504i(47438);
                WalletOrderInfoNewUI.this.finish();
                AppMethodBeat.m2505o(47438);
            }
        }

        C1429614() {
            AppMethodBeat.m2504i(47439);
            this.xxI = C32652uv.class.getName().hashCode();
            AppMethodBeat.m2505o(47439);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47440);
            C32652uv c32652uv = (C32652uv) c4883b;
            C4990ab.m7416i("MicroMsg.WalletOrderInfoNewUI", "receive pay result event, do finish");
            if ((c32652uv.cRF.cRG == 1000 || c32652uv.cRF.cRG == 1001) && WalletOrderInfoNewUI.this.pVL != null && WalletOrderInfoNewUI.this.pVL.cIf == 46) {
                if (WalletOrderInfoNewUI.this.tEX != null) {
                    WalletOrderInfoNewUI.this.tEX.mo64569aF(WalletOrderInfoNewUI.this.mController.ylL);
                }
                C5004al.m7442n(new C142761(), 100);
            }
            AppMethodBeat.m2505o(47440);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI$9 */
    class C142989 extends C4884c<C18218aq> {
        C142989() {
            AppMethodBeat.m2504i(47434);
            this.xxI = C18218aq.class.getName().hashCode();
            AppMethodBeat.m2505o(47434);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47435);
            C18218aq c18218aq = (C18218aq) c4883b;
            String str = c18218aq.ctH.ctJ;
            boolean z = c18218aq.ctH.ctK;
            C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "ChangePayActivityViewEvent callback, mActivityBtnTitle: %s, isButtonEnable: %s, isButtonHidden: %s, isActivityViewHidden: %s", str, Boolean.valueOf(z), Boolean.valueOf(c18218aq.ctH.ctL), Boolean.valueOf(c18218aq.ctH.ctM));
            if (c18218aq.ctH.ctM && !C5046bo.isNullOrNil(WalletOrderInfoNewUI.this.tEI)) {
                WalletOrderInfoNewUI.this.tIs.setVisibility(8);
            }
            if (!C5046bo.isNullOrNil(WalletOrderInfoNewUI.this.tEI)) {
                WalletOrderInfoNewUI.this.tIw.setClickable(z);
                WalletOrderInfoNewUI.this.tIw.setEnabled(z);
                WalletOrderInfoNewUI.this.tIw.setOnClickListener(null);
                if (r2) {
                    WalletOrderInfoNewUI.this.tIw.setVisibility(8);
                }
            }
            c18218aq.ctI.csN = true;
            AppMethodBeat.m2505o(47435);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletOrderInfoNewUI() {
        AppMethodBeat.m2504i(47450);
        AppMethodBeat.m2505o(47450);
    }

    public void finish() {
        AppMethodBeat.m2504i(47451);
        C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", this, C5046bo.dpG());
        if (this.pSQ) {
            AppMethodBeat.m2505o(47451);
            return;
        }
        super.finish();
        this.pSQ = true;
        AppMethodBeat.m2505o(47451);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47452);
        super.onCreate(bundle);
        if (C1443d.m3068iW(21)) {
            if (C1443d.m3068iW(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        mo9439AM(4);
        this.tIc = new HashSet();
        C40931c aE = C24143a.m37112aE(this);
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.oXY = this.mBundle.getString("key_trans_id");
        this.mBundle.getInt("key_pay_type", -1);
        C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", this.oXY);
        this.tog = cRD();
        if (this.tog != null) {
            mo9439AM(0);
            m22465c(this.tog);
            if (!(aE == null || this.tog == null || this.pVL == null)) {
                int i;
                this.mAppId = this.pVL.appId;
                boolean dNG = aE.dNG();
                C40148d.m68847a(this, this.mBundle, 7);
                int i2 = this.mBundle.getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.pVL.cIf);
                objArr[1] = Boolean.valueOf(this.pVL.cIf == 3);
                if (dNG) {
                    i = 1;
                } else {
                    i = 2;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(C36381z.dNX());
                objArr[4] = Integer.valueOf((int) (this.tog.pTN * 100.0d));
                objArr[5] = this.tog.pcl;
                objArr[6] = Integer.valueOf(i2);
                c7060h.mo8381e(10691, objArr);
            }
            if (!((C14241r.cPI().cQg() || aE == null || !aE.dNG()) && C1853r.m3827YI())) {
                C1853r.m3828YJ();
            }
            if (this.tog == null || this.tog.tAq == null || this.tog.tAq.size() <= 0) {
                C4990ab.m7409c("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
                C30379h.m48431a(this.mController.ylL, (int) C25738R.string.fkw, 0, new C1427718());
            } else {
                this.tId = this.tog.tAq;
                C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", Integer.valueOf(this.tId.size()));
                this.oXY = ((Commodity) this.tId.get(0)).cAa;
                this.pVl = ((Commodity) this.tId.get(0)).cAa;
                if (!(this.pVL == null || aE == null || (!aE.dNF() && !aE.dNG()))) {
                    mo39970a(new C35475y(cNH(), 21), true, true);
                }
            }
            ((C11927i) C1720g.m3528K(C11927i.class)).mo7362g(this);
        } else {
            C4990ab.m7409c("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
            C30379h.m48431a(this.mController.ylL, (int) C25738R.string.fkw, 0, new C1428519());
        }
        initView();
        this.tEX = dOD();
        cRo();
        if (this.pVL != null && this.pVL.cIf == 46) {
            C4990ab.m7416i("MicroMsg.WalletOrderInfoNewUI", "early send result");
            C32652uv c32652uv = new C32652uv();
            Intent intent = new Intent();
            intent.putExtras(this.mBundle);
            if (this.tog != null) {
                intent.putExtra("key_total_fee", this.tog.pTN);
            }
            if (this.tEX != null) {
                intent.putExtra("key_is_clear_failure", this.tEX.mqu.getInt("key_is_clear_failure", -1));
            }
            c32652uv.cRF.intent = intent;
            c32652uv.cRF.cRH = 1;
            c32652uv.cRF.czZ = cNH();
            c32652uv.cRF.result = intent.getBooleanExtra("intent_pay_end", false) ? -1 : 0;
            C4879a.xxA.mo10055m(c32652uv);
        }
        if (this.tog == null || this.tog.tAO == null || this.tog.tAO.tBL != 1) {
            mo39992nf(1979);
            mo39992nf(2948);
            mo39992nf(2710);
            C4879a.xxA.mo10052c(this.tIy);
            C4879a.xxA.mo10052c(this.pap);
            this.pSR.dnU();
            this.tEW = true;
            C44422ad.m80306e(this.pVL == null ? 0 : this.pVL.cIf, this.pVL == null ? "" : this.pVL.czZ, 16, "");
            AppMethodBeat.m2505o(47452);
            return;
        }
        C4990ab.m7416i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
        cRH();
        AppMethodBeat.m2505o(47452);
    }

    public void onResume() {
        AppMethodBeat.m2504i(47453);
        super.onResume();
        C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", Boolean.valueOf(this.tEW), this.tIg, Boolean.valueOf(this.tEU), Boolean.valueOf(this.tEV), this.tIe, this.pSK);
        if (WalletSuccPageAwardWidget.m34320a(this.pSK)) {
            this.pSL.onResume();
            AppMethodBeat.m2505o(47453);
        } else if (this.tEW) {
            this.tEW = false;
            AppMethodBeat.m2505o(47453);
        } else if (this.tIg == null || !this.tEV) {
            if (this.tEU && this.tIe != null) {
                mo39970a(new C40093aa(this.tIe.tBx, this.tIe.tBz, this.tIe.tBA, this.tIe.tBB, cNH(), this.pVl, this.tIe.tBC), true, true);
            }
            AppMethodBeat.m2505o(47453);
        } else {
            C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", Boolean.valueOf(C5046bo.isNullOrNil(this.tIg.uZT)), this.tIg.uZT, Boolean.valueOf(this.tIx));
            if (this.tIx) {
                AppMethodBeat.m2505o(47453);
                return;
            }
            this.tIx = true;
            if (C5046bo.isNullOrNil(this.tIg.uZT)) {
                mo39970a(new C40093aa(this.tIg.ttW, this.tIg.uZN, this.tIg.tzP, this.tIg.tzQ, cNH(), this.pVl, this.tIg.tzR), true, true);
                AppMethodBeat.m2505o(47453);
                return;
            }
            mo39970a(new C29618k(this.tIg.uZT, this.tIg.ttW), true, true);
            AppMethodBeat.m2505o(47453);
        }
    }

    public final void initView() {
        Commodity commodity;
        Commodity commodity2;
        AppMethodBeat.m2504i(47454);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.tEM = (ImageView) findViewById(2131828704);
        this.pWB = (TextView) findViewById(2131828705);
        this.tIh = (TextView) findViewById(2131828953);
        this.tIi = (TextView) findViewById(2131828955);
        this.tIj = (WalletTextView) findViewById(2131828956);
        this.pSP = (TextView) findViewById(2131826987);
        this.tEL = (Button) findViewById(2131828708);
        showHomeBtn(false);
        enableBackMenu(false);
        CharSequence string = getString(C25738R.string.f9142qt);
        if (this.pVL == null || this.pVL.cIf != 2) {
            if (!(this.tog == null || C5046bo.isNullOrNil(this.tog.tAB))) {
                string = this.tog.tAB;
            }
        } else if (this.tog != null && !C5046bo.isNullOrNil(this.tog.tAB)) {
            string = this.tog.tAB;
        } else if (!C5046bo.isNullOrNil(this.pVL.tRb)) {
            string = getString(C25738R.string.f8823g1) + this.pVL.tRb;
        } else if (!(C5046bo.isNullOrNil(this.pVL.appId) || C5046bo.isNullOrNil(C46494g.m87756t(this, this.pVL.appId)))) {
            string = getString(C25738R.string.f8823g1) + C46494g.m87756t(this, this.pVL.appId);
        }
        this.tEL.setText(string);
        this.tEL.setOnClickListener(new C1429415());
        this.tIk = (ViewGroup) findViewById(2131828957);
        this.pSN = (ViewGroup) findViewById(2131826978);
        this.tET = (ViewGroup) findViewById(2131828707);
        this.pSM = (ViewGroup) findViewById(2131826977);
        this.pSO = (ViewGroup) findViewById(2131826986);
        this.tIl = (ViewGroup) findViewById(2131828959);
        this.tIm = (ViewGroup) findViewById(2131828961);
        this.tIo = (ViewGroup) findViewById(2131828958);
        this.tIn = (ViewGroup) findViewById(2131828963);
        this.tEN = (ViewGroup) findViewById(2131827111);
        this.tEO = (CdnImageView) findViewById(2131827112);
        this.tEO.setUseSdcardCache(true);
        this.tEP = (TextView) findViewById(2131827114);
        this.tEQ = (TextView) findViewById(2131827113);
        this.tES = (Button) findViewById(2131827115);
        this.tER = findViewById(2131826995);
        this.tIp = (ViewGroup) findViewById(2131828966);
        this.tIq = (TextView) findViewById(2131828968);
        this.tIr = (CheckBox) findViewById(2131828967);
        this.tIs = (ViewGroup) findViewById(2131828969);
        this.tIt = (CdnImageView) findViewById(2131828970);
        this.tIt.setUseSdcardCache(true);
        this.tIv = (TextView) findViewById(2131828972);
        this.tIu = (TextView) findViewById(2131828971);
        this.tIw = (Button) findViewById(2131828973);
        this.tET.setVisibility(4);
        this.pSL = (WalletSuccPageAwardWidget) findViewById(2131826996);
        cRo();
        if (!(this.tog == null || this.tId == null || this.tId.size() <= 0)) {
            commodity = (Commodity) this.tId.get(0);
            this.tIh.setText(commodity.pca);
            this.tIi.setText(C36391e.atq(commodity.pcl));
            this.tIj.setText(String.format("%.2f", new Object[]{Double.valueOf(commodity.kCJ)}));
        }
        String str = "MicroMsg.WalletOrderInfoNewUI";
        String str2 = "is_use_show_info: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.tog == null ? 0 : this.tog.tAC);
        C4990ab.m7417i(str, str2, objArr);
        if (this.tog == null || this.tog.tAC != 1) {
            cRE();
            if (!(this.tog == null || this.tId == null || this.tId.size() <= 0)) {
                commodity = (Commodity) this.tId.get(0);
                if (commodity.tAZ != null) {
                    TextView textView = (TextView) this.tIn.findViewById(2131828965);
                    ((TextView) this.tIn.findViewById(2131828964)).setText(commodity.tAZ.tBD);
                    textView.setText(commodity.tAZ.tBE);
                    this.tIn.setVisibility(0);
                    this.tIk.setVisibility(0);
                }
            }
            this.tIm.setVisibility(8);
            this.tIl.setVisibility(8);
            if (!(this.tog == null || this.tId == null || this.tId.size() <= 0)) {
                commodity = (Commodity) this.tId.get(0);
                if (!C5046bo.isNullOrNil(commodity.tAX)) {
                    ((TextView) findViewById(2131828960)).setText(commodity.tAX);
                    this.tIl.setVisibility(0);
                    this.tIk.setVisibility(0);
                }
                if (!C5046bo.isNullOrNil(commodity.tAV)) {
                    ((TextView) findViewById(2131828962)).setText(commodity.tAV);
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
                        C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", this.pSK, Integer.valueOf(promotions.uZM));
                        commodity2 = commodity;
                        break;
                    }
                }
            }
            commodity2 = commodity;
        }
        if (WalletSuccPageAwardWidget.m34320a(this.pSK)) {
            if (commodity2 != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.pSL.getLayoutParams();
                List list = commodity2.tAU;
                if ((commodity2.tAR < 0.0d || commodity2.kCJ >= commodity2.tAR) && (list == null || list.size() <= 0)) {
                    marginLayoutParams.topMargin = C1338a.fromDPToPix(this, 50);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
                this.pSL.setLayoutParams(marginLayoutParams);
            }
            this.pSL.mo38237a(this, this.pSK, this.oXY, false, (ImageView) findViewById(2131824036));
            this.pSL.init();
            this.pSL.setVisibility(0);
            final ImageView imageView = (ImageView) findViewById(2131824036);
            imageView.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(47442);
                    ViewGroup viewGroup = (ViewGroup) WalletOrderInfoNewUI.this.findViewById(2131825792);
                    LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = viewGroup.getWidth();
                    layoutParams.height = viewGroup.getHeight();
                    imageView.setLayoutParams(layoutParams);
                    AppMethodBeat.m2505o(47442);
                }
            });
        } else {
            m22477nk(true);
            this.pSL.setVisibility(8);
        }
        cRn();
        AppMethodBeat.m2505o(47454);
    }

    private void cRn() {
        int i;
        AppMethodBeat.m2504i(47455);
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
            i = C1338a.fromDPToPix(this, 40);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        } else {
            i = C1338a.fromDPToPix(this, 70);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        }
        this.tEM.setLayoutParams(marginLayoutParams);
        this.tIh.setLayoutParams(marginLayoutParams2);
        this.tET.post(new C1428417());
        AppMethodBeat.m2505o(47455);
    }

    private void cRo() {
        AppMethodBeat.m2504i(47456);
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
                this.pWB.setText(C25738R.string.flg);
            } else if (!C5046bo.isNullOrNil(this.tog.tAj) && !C5046bo.isNullOrNil(this.tog.tAj.trim())) {
                this.pWB.setText(this.tog.tAj);
                AppMethodBeat.m2505o(47456);
                return;
            } else if (this.tog.tuo != 1) {
                this.pWB.setText(C25738R.string.flf);
                AppMethodBeat.m2505o(47456);
                return;
            } else {
                this.pWB.setText(C25738R.string.fle);
                AppMethodBeat.m2505o(47456);
                return;
            }
        }
        AppMethodBeat.m2505o(47456);
    }

    private void cRE() {
        AppMethodBeat.m2504i(47457);
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
            C4990ab.m7417i(str, str2, objArr);
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
                        textView.setText(discountInfo.pOz + C36391e.m60006e(discountInfo.tBm / 100.0d, this.tog.pcl));
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
                this.pSP.setText(C36391e.m60006e(commodity.tAR, commodity.pcl));
                this.pSP.getPaint().setFlags(16);
                this.pSO.setVisibility(0);
                this.tIk.setVisibility(0);
            }
        }
        AppMethodBeat.m2505o(47457);
    }

    private void cRF() {
        AppMethodBeat.m2504i(47458);
        this.tIp.setVisibility(8);
        if (this.tog != null) {
            m22465c(this.tog);
            if (this.tId != null && this.tId.size() > 0) {
                Commodity commodity = (Commodity) this.tId.get(0);
                C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", Boolean.valueOf(commodity.tBb));
                if (commodity.tBb && commodity.tBa != null && commodity.tBa.size() > 0) {
                    for (Promotions promotions : commodity.tBa) {
                        if (promotions.type == Orders.tAP) {
                            break;
                        }
                    }
                    Promotions promotions2 = null;
                    C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", promotions2);
                    if (!(promotions2 == null || C5046bo.isNullOrNil(promotions2.pcm))) {
                        this.pVl = commodity.cAa;
                        C7060h.pYm.mo8381e(13033, Integer.valueOf(1), promotions2.pcm, promotions2.url, promotions2.name, this.pVl);
                        this.tIq.setText(getString(C25738R.string.flm, new Object[]{promotions2.name}));
                        this.tIf = promotions2.pcm;
                        this.tIr.setVisibility(0);
                        if (this.tIc.contains(promotions2.pcm)) {
                            this.tIr.setChecked(true);
                        } else {
                            this.tIr.setChecked(false);
                        }
                        this.tIp.setOnClickListener(new C1428620());
                        this.tIp.setVisibility(0);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(47458);
    }

    private void cRG() {
        AppMethodBeat.m2504i(47459);
        this.tIo.setVisibility(8);
        this.tIo.removeAllViews();
        if (this.tog != null && this.tog.tAC == 1 && this.tog.tAE != null && this.tog.tAE.size() > 0) {
            C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", this.tog.tAE, Integer.valueOf(this.tog.tAE.size()));
            Iterator it = this.tog.tAE.iterator();
            while (it.hasNext()) {
                final ShowInfo showInfo = (ShowInfo) it.next();
                C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", showInfo);
                LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(2130971143, this.tIo, false);
                TextView textView = (TextView) linearLayout.findViewById(2131823382);
                TextView textView2 = (TextView) linearLayout.findViewById(2131828952);
                if (!C5046bo.isNullOrNil(showInfo.name)) {
                    textView.setText(showInfo.name);
                }
                if (!C5046bo.isNullOrNil(showInfo.mVA)) {
                    try {
                        textView.setTextColor(Color.parseColor(showInfo.mVA));
                    } catch (Exception e) {
                    }
                }
                if (!C5046bo.isNullOrNil(showInfo.value)) {
                    textView2.setText(showInfo.value);
                }
                if (showInfo.tBK == 1) {
                    textView2.getPaint().setFlags(16);
                }
                if (!C5046bo.isNullOrNil(showInfo.tBF)) {
                    try {
                        textView2.setTextColor(Color.parseColor(showInfo.tBF));
                    } catch (Exception e2) {
                    }
                }
                if (showInfo.tBG == 1) {
                    if (!C5046bo.isNullOrNil(showInfo.tBJ)) {
                        linearLayout.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(47427);
                                C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", showInfo.tBJ);
                                WalletOrderInfoNewUI.this.acZ(showInfo.tBJ);
                                AppMethodBeat.m2505o(47427);
                            }
                        });
                    }
                } else if (showInfo.tBG == 2 && !C5046bo.isNullOrNil(showInfo.tBH)) {
                    linearLayout.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(47428);
                            C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", showInfo.tBH, showInfo.tBI);
                            C32628se c32628se = new C32628se();
                            c32628se.cOf.userName = showInfo.tBH;
                            c32628se.cOf.cOh = C5046bo.m7532bc(showInfo.tBI, "");
                            c32628se.cOf.scene = 1060;
                            c32628se.cOf.cst = WalletOrderInfoNewUI.this.oXY;
                            c32628se.cOf.cOi = 0;
                            c32628se.cOf.context = WalletOrderInfoNewUI.this;
                            C4879a.xxA.mo10055m(c32628se);
                            AppMethodBeat.m2505o(47428);
                        }
                    });
                }
                this.tIo.addView(linearLayout);
            }
            this.tIk.setVisibility(0);
            this.tIo.setVisibility(0);
        }
        AppMethodBeat.m2505o(47459);
    }

    /* renamed from: nk */
    private void m22477nk(boolean z) {
        AppMethodBeat.m2504i(47460);
        this.tEN.setVisibility(8);
        this.tEV = false;
        this.tEU = false;
        if (this.tog != null) {
            if (this.tId != null && this.tId.size() > 0) {
                final Commodity commodity = (Commodity) this.tId.get(0);
                if (commodity != null) {
                    Promotions promotions;
                    C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", Boolean.valueOf(commodity.tBb));
                    if (commodity.tBa != null && commodity.tBa.size() > 0) {
                        for (Promotions promotions2 : commodity.tBa) {
                            if (promotions2.type == Orders.tAQ) {
                                promotions = promotions2;
                                break;
                            }
                        }
                    }
                    promotions = null;
                    C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", promotions);
                    C14282a c14282a;
                    MarginLayoutParams marginLayoutParams;
                    List list;
                    if (promotions != null && promotions.ttW > 0 && !C5046bo.isNullOrNil(promotions.tzS)) {
                        this.tIg = promotions;
                        this.tER.setVisibility(8);
                        this.tEO.setRoundCorner(true);
                        this.tES.setEnabled(true);
                        this.tES.setBackgroundResource(C25738R.drawable.f6484fp);
                        this.tEQ.setCompoundDrawables(null, null, null, null);
                        c14282a = (C14282a) this.tEH.get(promotions.ttW);
                        if (c14282a != null) {
                            if (!C5046bo.isNullOrNil(c14282a.cIY)) {
                                this.tEO.setUrl(c14282a.cIY);
                            }
                            if (!C5046bo.isNullOrNil(c14282a.cEh)) {
                                this.tEP.setText(c14282a.cEh);
                            }
                            if (!C5046bo.isNullOrNil(c14282a.tID)) {
                                this.tES.setText(c14282a.tID);
                                this.tES.setBackgroundResource(C25738R.drawable.a65);
                            }
                            if (!C5046bo.isNullOrNil(c14282a.tzW)) {
                                this.tIg.uZP = c14282a.tzW;
                            }
                            if (!C5046bo.isNullOrNil(c14282a.ttg)) {
                                this.tIg.uZQ = c14282a.ttg;
                            }
                            if (c14282a.tIE > 0) {
                                this.tIg.uZR = c14282a.tIE;
                            }
                        } else {
                            this.tEO.setUrl(promotions.pia);
                            this.tEP.setText(promotions.name);
                            this.tES.setText(promotions.tzS);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.tEQ.getLayoutParams();
                        if (c14282a != null && !C5046bo.isNullOrNil(c14282a.title)) {
                            this.tEQ.setText(c14282a.title);
                            layoutParams.addRule(15, 0);
                        } else if (C5046bo.isNullOrNil(promotions.title)) {
                            this.tEQ.setVisibility(8);
                            layoutParams.addRule(15, -1);
                        } else {
                            this.tEQ.setText(promotions.title);
                            layoutParams.addRule(15, 0);
                        }
                        this.tEQ.setLayoutParams(layoutParams);
                        this.tES.setVisibility(0);
                        this.tES.setOnClickListener(new C142874());
                        if (promotions.uZM != 1) {
                            this.tEN.setOnClickListener(new C142785());
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
                            marginLayoutParams.topMargin = C1338a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.tEN.setLayoutParams(marginLayoutParams);
                        this.tEN.setVisibility(0);
                        if (z) {
                            C7060h c7060h = C7060h.pYm;
                            Object[] objArr = new Object[6];
                            objArr[0] = this.pVl;
                            objArr[1] = Integer.valueOf(1);
                            objArr[2] = Integer.valueOf(promotions.uZM);
                            objArr[3] = this.tEK.equals("-1") ? Integer.valueOf(5) : this.tEK;
                            objArr[4] = Long.valueOf(promotions.ttW);
                            objArr[5] = Long.valueOf(promotions.tzR);
                            c7060h.mo8381e(13471, objArr);
                        }
                    } else if (!(commodity.tAY == null || C5046bo.isNullOrNil(commodity.tAY.tzW))) {
                        this.tED = commodity.tAY.tzW;
                        this.tEE = commodity.tAY.ttg;
                        this.tzY = commodity.tAY.tzY;
                        this.tIe = commodity.tAY;
                        this.tEO.setUrl(commodity.tAY.tzU);
                        this.tEP.setText(commodity.tAY.tzV);
                        this.tEQ.setText(getString(C25738R.string.f8_));
                        this.tEQ.setVisibility(0);
                        this.tEO.setRoundCorner(true);
                        this.tES.setEnabled(true);
                        this.tES.setBackgroundResource(C25738R.drawable.f6484fp);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.tEQ.getLayoutParams();
                        layoutParams2.addRule(15, 0);
                        this.tEQ.setLayoutParams(layoutParams2);
                        if (commodity.tAY.tBx > 0) {
                            if (!C5046bo.isNullOrNil(commodity.tAY.tzX)) {
                                this.tES.setVisibility(0);
                                this.tES.setText(commodity.tAY.tzX);
                                this.tER.setVisibility(8);
                            }
                            c14282a = (C14282a) this.tEH.get(commodity.tAY.tBx);
                            if (c14282a != null) {
                                if (!C5046bo.isNullOrNil(c14282a.tzU)) {
                                    this.tEO.setUrl(c14282a.tzU);
                                }
                                if (!C5046bo.isNullOrNil(c14282a.tzV)) {
                                    this.tEP.setText(c14282a.tzV);
                                }
                                if (!C5046bo.isNullOrNil(c14282a.tzX)) {
                                    this.tES.setText(c14282a.tzX);
                                    this.tES.setBackgroundResource(C25738R.drawable.a65);
                                }
                                if (!C5046bo.isNullOrNil(c14282a.tzW)) {
                                    this.tED = c14282a.tzW;
                                }
                                if (!C5046bo.isNullOrNil(c14282a.ttg)) {
                                    this.tEE = c14282a.ttg;
                                }
                                if (c14282a.tIE > 0) {
                                    this.tzY = c14282a.tIE;
                                }
                            }
                        } else {
                            this.tES.setVisibility(8);
                            this.tER.setVisibility(8);
                        }
                        C142796 c142796 = new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(47431);
                                C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", WalletOrderInfoNewUI.this.tED, WalletOrderInfoNewUI.this.tEE, Integer.valueOf(WalletOrderInfoNewUI.this.tzY));
                                C32628se c32628se = new C32628se();
                                c32628se.cOf.userName = WalletOrderInfoNewUI.this.tED;
                                c32628se.cOf.cOh = C5046bo.m7532bc(WalletOrderInfoNewUI.this.tEE, "");
                                c32628se.cOf.scene = 1034;
                                c32628se.cOf.cOi = 0;
                                if (WalletOrderInfoNewUI.this.tzY > 0) {
                                    c32628se.cOf.axy = WalletOrderInfoNewUI.this.tzY;
                                }
                                c32628se.cOf.context = WalletOrderInfoNewUI.this;
                                C4879a.xxA.mo10055m(c32628se);
                                WalletOrderInfoNewUI walletOrderInfoNewUI = WalletOrderInfoNewUI.this;
                                boolean z = !C5046bo.isNullOrNil(commodity.tAY.tzX) && commodity.tAY.tBx > 0;
                                walletOrderInfoNewUI.tEU = z;
                                if (WalletOrderInfoNewUI.this.tEU) {
                                    C7060h.pYm.mo8381e(14118, WalletOrderInfoNewUI.this.oXY, WalletOrderInfoNewUI.this.cNH(), Integer.valueOf(3));
                                    AppMethodBeat.m2505o(47431);
                                    return;
                                }
                                C7060h.pYm.mo8381e(14118, WalletOrderInfoNewUI.this.oXY, WalletOrderInfoNewUI.this.cNH(), Integer.valueOf(1));
                                AppMethodBeat.m2505o(47431);
                            }
                        };
                        this.tEN.setOnClickListener(c142796);
                        this.tES.setOnClickListener(c142796);
                        marginLayoutParams = (MarginLayoutParams) this.tEN.getLayoutParams();
                        list = commodity.tAU;
                        if ((commodity.tAR < 0.0d || commodity.kCJ >= commodity.tAR) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = C1338a.fromDPToPix(this, 50);
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
                this.tEP.post(new C142887());
            }
        }
        AppMethodBeat.m2505o(47460);
    }

    /* Access modifiers changed, original: protected|final */
    public final void acZ(String str) {
        AppMethodBeat.m2504i(47461);
        C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", str);
        cRq();
        C36391e.m60016n(this, str, true);
        AppMethodBeat.m2505o(47461);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(47462);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", Boolean.valueOf(C5046bo.isNullOrNil(this.tEG.tIJ)), Boolean.valueOf(this.tIx));
            if (this.tIx) {
                AppMethodBeat.m2505o(47462);
                return;
            }
            this.tIx = true;
            if (C5046bo.isNullOrNil(this.tEG.tIJ)) {
                mo39970a(new C40093aa(this.tEG.tuv, this.tEG.tIF, this.tEG.tIG, this.tEG.tIH, this.tEG.cBT, this.tEG.pQe, this.tEG.tBC), true, true);
                AppMethodBeat.m2505o(47462);
                return;
            }
            mo39970a(new C29618k(this.tEG.tIJ, this.tEG.tuv), true, true);
        }
        AppMethodBeat.m2505o(47462);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgg() {
        return false;
    }

    public final int getLayoutId() {
        return 2130971144;
    }

    /* renamed from: c */
    private void m22465c(Orders orders) {
        AppMethodBeat.m2504i(47464);
        this.tIc.clear();
        if (orders == null || orders.tAq == null) {
            C4990ab.m7420w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
            AppMethodBeat.m2505o(47464);
            return;
        }
        for (Commodity commodity : orders.tAq) {
            if (commodity.tAh == 2 && !C5046bo.isNullOrNil(commodity.tAS)) {
                C4990ab.m7416i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
                this.tIc.add(commodity.tAS);
            }
        }
        AppMethodBeat.m2505o(47464);
    }

    public final void cRH() {
        String string;
        AppMethodBeat.m2504i(47466);
        cRq();
        C18216ap c18216ap = new C18216ap();
        c18216ap.ctF.ctG = true;
        C4879a.xxA.mo10055m(c18216ap);
        C32565gq c32565gq = new C32565gq();
        c32565gq.cBo.cBp = "ok";
        C4879a.xxA.mo10055m(c32565gq);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.mBundle.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.mBundle.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.mBundle.getBoolean("intent_pay_end"));
        C4990ab.m7416i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + this.mBundle.getInt("intent_pay_end_errcode"));
        for (String string2 : this.tIc) {
            if (!C5046bo.isNullOrNil(string2)) {
                C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", string2);
                if (this.tog == null || this.pVL == null) {
                    C1720g.m3535RO().eJo.mo14541a(new C44431r(string2), 0);
                } else {
                    String str;
                    C6300p c6300p = C1720g.m3535RO().eJo;
                    String str2 = this.tog.czZ;
                    if (this.tog.tAq.size() > 0) {
                        str = ((Commodity) this.tog.tAq.get(0)).cAa;
                    } else {
                        str = "";
                    }
                    c6300p.mo14541a(new C44431r(string2, str2, str, this.pVL.cIf, this.pVL.cIb, this.tog.tAh), 0);
                }
            }
            C7060h.pYm.mo8381e(13033, Integer.valueOf(2), string2, "", "", "");
        }
        if (this.tEX != null) {
            this.tEX.mo8124a((Activity) this, 0, bundle);
            this.tEX = null;
        } else {
            C4990ab.m7416i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
            finish();
        }
        if (this.pVL != null && (this.pVL.cIf == 46 || this.pVL.cIf == 3)) {
            C26276bg c26276bg = new C26276bg();
            if (this.pVL.cIf == 46) {
                c26276bg.dcc = 2;
            } else if (this.pVL.cIf == 3) {
                c26276bg.dcc = 1;
            }
            if (this.tog != null && this.tog.tAD == 0) {
                c26276bg.dcd = 1;
            } else if (this.tog != null && this.tog.tAD == 1) {
                c26276bg.dcd = 2;
            } else if (!(this.tog == null || this.tog.tAD != 0 || C5046bo.isNullOrNil(this.tog.tAG) || C5046bo.isNullOrNil(this.tog.tAF))) {
                c26276bg.dcd = 3;
            }
            if (!(this.pVL == null || this.pVL.vwh == null)) {
                string2 = this.pVL.vwh.getString("extinfo_key_20", "");
                if (!C5046bo.isNullOrNil(string2)) {
                    c26276bg.mo44019fY(string2);
                }
                string2 = this.pVL.vwh.getString("extinfo_key_21", "");
                if (!C5046bo.isNullOrNil(string2)) {
                    c26276bg.mo44021ga(string2);
                }
                string2 = this.pVL.vwh.getString("extinfo_key_22", "");
                if (!C5046bo.isNullOrNil(string2)) {
                    c26276bg.mo44020fZ(string2);
                }
            }
            if (!(this.tog == null || this.tog.tAD != 0 || C5046bo.isNullOrNil(this.tog.tAG) || C5046bo.isNullOrNil(this.tog.tAF))) {
                c26276bg.mo44023gc(this.tog.tAG);
                c26276bg.mo44022gb(this.tog.tAF);
            }
            c26276bg.ajK();
            if (!(this.tog == null || this.tog.tAD != 0 || C5046bo.isNullOrNil(this.tog.tAG) || C5046bo.isNullOrNil(this.tog.tAF))) {
                C32628se c32628se = new C32628se();
                c32628se.cOf.userName = this.tog.tAF;
                c32628se.cOf.cOh = this.tog.tAG;
                c32628se.cOf.scene = 1060;
                c32628se.cOf.cst = this.oXY;
                c32628se.cOf.cOi = 0;
                c32628se.cOf.context = this;
                C4879a.xxA.mo10055m(c32628se);
                AppMethodBeat.m2505o(47466);
                return;
            }
        }
        if (!(this.tog == null || C5046bo.isNullOrNil(this.tog.lvz))) {
            String d = WalletOrderInfoUI.m47042d(this.tog.lvz, this.tog.czZ, this.tog.tAq.size() > 0 ? ((Commodity) this.tog.tAq.get(0)).cAa : "", this.pVL.kck, this.pVL.hHV);
            C4990ab.m7410d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(d)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            intent.putExtra("stastic_scene", 8);
            C25985d.m41467b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.m2505o(47466);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(47467);
        if (i == 4) {
            done();
            AppMethodBeat.m2505o(47467);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(47467);
        return onKeyUp;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47468);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.tIy);
        C4879a.xxA.mo10053d(this.pap);
        mo39993ng(1979);
        mo39993ng(2948);
        mo39993ng(2710);
        this.pSR.dead();
        if (WalletSuccPageAwardWidget.m34320a(this.pSK)) {
            this.pSL.onDestroy();
        }
        AppMethodBeat.m2505o(47468);
    }

    /* Access modifiers changed, original: protected */
    public void cRq() {
        int i = 0;
        AppMethodBeat.m2504i(47469);
        if (!this.tEC) {
            C45334iy c45334iy = new C45334iy();
            c45334iy.cEc.requestCode = 4;
            C26168a c26168a = c45334iy.cEc;
            if (this.mBundle.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            c26168a.bFZ = i;
            c45334iy.cEc.cEd = new Intent();
            if (this.tog != null) {
                c45334iy.cEc.cEd.putExtra("key_jsapi_close_page_after_pay", this.tog.tAD);
            }
            if (!(this.tog == null || this.tog.tAD != 0 || C5046bo.isNullOrNil(this.tog.tAG) || C5046bo.isNullOrNil(this.tog.tAF))) {
                c45334iy.cEc.cEd.putExtra("key_jsapi_close_page_after_pay", 1);
            }
            if (this.tEX != null) {
                c45334iy.cEc.cEd.putExtra("key_is_clear_failure", this.tEX.mqu.getInt("key_is_clear_failure", -1));
            }
            C4879a.xxA.mo10055m(c45334iy);
            this.tEC = true;
        }
        AppMethodBeat.m2505o(47469);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47470);
        C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), c1207m);
        if (WalletSuccPageAwardWidget.m34320a(this.pSK) && this.pSL.mo38238c(i, i2, str, c1207m)) {
            AppMethodBeat.m2505o(47470);
            return true;
        }
        CharSequence string;
        if (c1207m instanceof C40093aa) {
            if (i == 0 && i2 == 0) {
                C40093aa c40093aa = (C40093aa) c1207m;
                C14282a c14282a = new C14282a(c40093aa.hwh);
                if (this.tEG != null) {
                    this.tEH.put(c40093aa.tuv, c14282a);
                    m22477nk(false);
                    cRn();
                } else if (this.tEU) {
                    this.tEH.put(c40093aa.tuv, c14282a);
                    m22477nk(false);
                    cRn();
                }
            }
            this.tIx = false;
        } else if (c1207m instanceof C29618k) {
            if (i == 0 && i2 == 0) {
                C29618k c29618k = (C29618k) c1207m;
                bnu bnu = c29618k.tuc;
                if (bnu.kdT == 0) {
                    C14282a c14282a2 = new C14282a(bnu);
                    if (this.tEG != null) {
                        this.tEH.put(c29618k.ssr, c14282a2);
                        m22477nk(false);
                        cRn();
                    } else if (this.tEU) {
                        this.tEH.put(c29618k.ssr, c14282a2);
                        m22477nk(false);
                        cRn();
                    }
                }
            }
            this.tIx = false;
        } else if (c1207m instanceof C46360n) {
            if (i == 0 && i2 == 0) {
                C46360n c46360n = (C46360n) c1207m;
                String str2 = c46360n.tud;
                if (this.tIg != null && this.tIg.ttW == c46360n.tug.ttW) {
                    C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", this.tIg);
                    this.tEK = str2;
                    C4990ab.m7411d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", c46360n.tug.tzS);
                    m22477nk(false);
                    cRn();
                    if (!(C5046bo.isNullOrNil(c46360n.ehr) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2))) {
                        this.tES.setText(c46360n.ehr);
                    }
                }
                if (!"-1".equals(str2) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2) && !C5046bo.isNullOrNil(c46360n.tue)) {
                    C30379h.m48461b((Context) this, c46360n.tue, "", true);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2)) {
                    if (C5046bo.isNullOrNil(c46360n.tue)) {
                        string = getString(C25738R.string.fns);
                    } else {
                        string = c46360n.tue;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                AppMethodBeat.m2505o(47470);
                return true;
            }
            if (C5046bo.isNullOrNil(str)) {
                str = getString(C25738R.string.fu2);
            }
            C30379h.m48448a((Context) this, str, null, false, new C1429512());
            AppMethodBeat.m2505o(47470);
            return true;
        } else if (c1207m instanceof C22561h) {
            if (i == 0 && i2 == 0) {
                C22561h c22561h = (C22561h) c1207m;
                aeq aeq = c22561h.ttV;
                if (aeq.kdT == 0) {
                    String str3 = aeq.wms;
                    if (this.tIg != null && this.tIg.ttW == c22561h.ttW) {
                        C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", this.tIg);
                        this.tEK = str3;
                        C4990ab.m7411d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", aeq.wmu);
                        m22477nk(false);
                        cRn();
                        if (!(C5046bo.isNullOrNil(aeq.wmu) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str3))) {
                            this.tES.setText(aeq.wmu);
                        }
                    }
                    if (!"-1".equals(str3) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str3) && !C5046bo.isNullOrNil(aeq.wmt)) {
                        C30379h.m48461b((Context) this, aeq.wmt, "", true);
                    } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str3)) {
                        if (C5046bo.isNullOrNil(aeq.wmt)) {
                            string = getString(C25738R.string.fns);
                        } else {
                            string = aeq.wmt;
                        }
                        Toast.makeText(this, string, 0).show();
                    }
                }
                AppMethodBeat.m2505o(47470);
                return true;
            }
            if (C5046bo.isNullOrNil(str)) {
                str = getString(C25738R.string.fu2);
            }
            C30379h.m48448a((Context) this, str, null, false, new C1429013());
            AppMethodBeat.m2505o(47470);
            return true;
        }
        AppMethodBeat.m2505o(47470);
        return false;
    }

    @Deprecated
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(47463);
        Dialog a = C30379h.m48422a(this.mController.ylL, getString(C25738R.string.fla), getResources().getStringArray(C25738R.array.f12640au), "", new C142808());
        AppMethodBeat.m2505o(47463);
        return a;
    }

    public void done() {
        AppMethodBeat.m2504i(47465);
        if (this.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoNewUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b = realnameGuideHelper.mo74574b(this, bundle, new C1428110());
                boolean a = realnameGuideHelper.mo74572a(this, bundle, new C1429311());
                this.mBundle.remove("key_realname_guide_helper");
                if (!(b || a)) {
                    cRH();
                }
            }
            AppMethodBeat.m2505o(47465);
            return;
        }
        cRH();
        AppMethodBeat.m2505o(47465);
    }

    /* renamed from: AM */
    public final void mo9439AM(int i) {
        AppMethodBeat.m2504i(47471);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.m2505o(47471);
    }

    /* renamed from: q */
    static /* synthetic */ void m22480q(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        AppMethodBeat.m2504i(47472);
        String str = "MicroMsg.WalletOrderInfoNewUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletOrderInfoNewUI.tIg != null ? walletOrderInfoNewUI.tIg.ttW : 0);
        C4990ab.m7417i(str, str2, objArr);
        if (walletOrderInfoNewUI.tIg != null && walletOrderInfoNewUI.tIg.ttW > 0) {
            walletOrderInfoNewUI.tEV = true;
            if (walletOrderInfoNewUI.tEK.equals("-1") || walletOrderInfoNewUI.tEK.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                C7060h.pYm.mo8381e(13472, walletOrderInfoNewUI.pVl, Integer.valueOf(walletOrderInfoNewUI.tIg.uZM), Integer.valueOf(1), Long.valueOf(walletOrderInfoNewUI.tIg.ttW), Long.valueOf(walletOrderInfoNewUI.tIg.tzR));
                C7060h.pYm.mo8381e(13033, Integer.valueOf(2), "", walletOrderInfoNewUI.tIg.url, walletOrderInfoNewUI.tIg.name, "");
                if (!C5046bo.isNullOrNil(walletOrderInfoNewUI.tIg.uZP) && !C5046bo.isNullOrNil(walletOrderInfoNewUI.tIg.uZQ)) {
                    C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "promotion jump tiny app, username: %s, path: %s, version: %s", walletOrderInfoNewUI.tIg.uZP, walletOrderInfoNewUI.tIg.uZQ, Integer.valueOf(walletOrderInfoNewUI.tIg.uZR));
                    walletOrderInfoNewUI.tEG = new C14289b(walletOrderInfoNewUI.tIg.ttW, walletOrderInfoNewUI.tIg.uZN, walletOrderInfoNewUI.tIg.tzP, walletOrderInfoNewUI.tIg.tzQ, walletOrderInfoNewUI.cNH(), walletOrderInfoNewUI.pVl, walletOrderInfoNewUI.tIg.tzR, walletOrderInfoNewUI.tIg.uZT);
                    C32628se c32628se = new C32628se();
                    c32628se.cOf.userName = walletOrderInfoNewUI.tIg.uZP;
                    c32628se.cOf.cOh = C5046bo.m7532bc(walletOrderInfoNewUI.tIg.uZQ, "");
                    c32628se.cOf.scene = 1060;
                    c32628se.cOf.cst = walletOrderInfoNewUI.oXY;
                    c32628se.cOf.cOi = 0;
                    if (walletOrderInfoNewUI.tIg.uZR > 0) {
                        c32628se.cOf.axy = walletOrderInfoNewUI.tIg.uZR;
                    }
                    c32628se.cOf.context = walletOrderInfoNewUI;
                    C4879a.xxA.mo10055m(c32628se);
                    C7060h.pYm.mo8381e(14118, walletOrderInfoNewUI.oXY, walletOrderInfoNewUI.cNH(), Integer.valueOf(2));
                    AppMethodBeat.m2505o(47472);
                    return;
                } else if (walletOrderInfoNewUI.tIg.uZM == 1) {
                    Promotions promotions = walletOrderInfoNewUI.tIg;
                    C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "doSceneSendPayAward, getAwardParams==null: %s, %s", Boolean.valueOf(C5046bo.isNullOrNil(promotions.uZS)), promotions.uZS);
                    if (C5046bo.isNullOrNil(promotions.uZS)) {
                        walletOrderInfoNewUI.mo39970a(new C46360n(promotions, walletOrderInfoNewUI.cNH(), walletOrderInfoNewUI.oXY, promotions.tzR), true, false);
                        AppMethodBeat.m2505o(47472);
                        return;
                    }
                    walletOrderInfoNewUI.mo39970a(new C22561h(promotions.uZS, promotions.ttW), true, false);
                    AppMethodBeat.m2505o(47472);
                    return;
                } else if (walletOrderInfoNewUI.tIg.uZM != 2 || C5046bo.isNullOrNil(walletOrderInfoNewUI.tIg.url)) {
                    C4990ab.m7412e("MicroMsg.WalletOrderInfoNewUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                } else if (walletOrderInfoNewUI.tEH.containsKey(walletOrderInfoNewUI.tIg.ttW)) {
                    C14282a c14282a = (C14282a) walletOrderInfoNewUI.tEH.get(walletOrderInfoNewUI.tIg.ttW);
                    C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "go to new url %s", c14282a.url);
                    if (C5046bo.isNullOrNil(c14282a.url)) {
                        walletOrderInfoNewUI.acZ(walletOrderInfoNewUI.tIg.url);
                        AppMethodBeat.m2505o(47472);
                        return;
                    }
                    walletOrderInfoNewUI.acZ(c14282a.url);
                    AppMethodBeat.m2505o(47472);
                    return;
                } else {
                    walletOrderInfoNewUI.tEI = walletOrderInfoNewUI.tIg.url;
                    String str3 = walletOrderInfoNewUI.tIg.url;
                    C14289b c14289b = new C14289b(walletOrderInfoNewUI.tIg.ttW, walletOrderInfoNewUI.tIg.uZN, walletOrderInfoNewUI.tIg.tzP, walletOrderInfoNewUI.tIg.tzQ, walletOrderInfoNewUI.cNH(), walletOrderInfoNewUI.pVl, walletOrderInfoNewUI.tIg.tzR, walletOrderInfoNewUI.tIg.uZT);
                    C4990ab.m7417i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", str3);
                    walletOrderInfoNewUI.cRq();
                    walletOrderInfoNewUI.tEG = c14289b;
                    C36391e.m59984a((Context) walletOrderInfoNewUI, str3, false, 1);
                    AppMethodBeat.m2505o(47472);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(47472);
    }
}
