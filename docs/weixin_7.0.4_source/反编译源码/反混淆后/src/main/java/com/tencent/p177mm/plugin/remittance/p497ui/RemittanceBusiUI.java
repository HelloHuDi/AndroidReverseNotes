package com.tencent.p177mm.plugin.remittance.p497ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26260vc;
import com.tencent.p177mm.p230g.p231a.C37719fw;
import com.tencent.p177mm.p230g.p231a.C37776ob;
import com.tencent.p177mm.p230g.p231a.C45325fv;
import com.tencent.p177mm.p230g.p232b.p233a.C37823bh;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.picker.C44403d;
import com.tencent.p177mm.p612ui.widget.picker.C44403d.C24103b;
import com.tencent.p177mm.p612ui.widget.picker.C44403d.C443992;
import com.tencent.p177mm.p612ui.widget.picker.C44403d.C444003;
import com.tencent.p177mm.p612ui.widget.picker.C44403d.C44401a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.p177mm.plugin.remittance.model.C21644g;
import com.tencent.p177mm.plugin.remittance.model.C21645h;
import com.tencent.p177mm.plugin.remittance.model.C28868a;
import com.tencent.p177mm.plugin.remittance.model.C28869i;
import com.tencent.p177mm.plugin.remittance.model.C39602t;
import com.tencent.p177mm.plugin.remittance.model.C43453c;
import com.tencent.p177mm.plugin.remittance.model.C43454d;
import com.tencent.p177mm.plugin.remittance.model.C43456k;
import com.tencent.p177mm.plugin.remittance.model.C46175l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C46349b;
import com.tencent.p177mm.plugin.wallet_core.id_verify.C40105a;
import com.tencent.p177mm.plugin.wallet_core.model.C35481v;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C22657a;
import com.tencent.p177mm.plugin.wallet_core.utils.C46374c;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C30202lu;
import com.tencent.p177mm.protocal.protobuf.C44141lp;
import com.tencent.p177mm.protocal.protobuf.C44143lv;
import com.tencent.p177mm.protocal.protobuf.C46532cz;
import com.tencent.p177mm.protocal.protobuf.abv;
import com.tencent.p177mm.protocal.protobuf.abw;
import com.tencent.p177mm.protocal.protobuf.chl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p760d.C24157d;
import com.tencent.p177mm.wallet_core.p760d.C30863c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI */
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
    private C37823bh pRJ;
    private boolean pRM;
    private boolean pRP;
    private C4884c pRR = new C1306719();
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
    private C3728b pTJ = new C3728b();
    private String pTK = "";
    private String pTL = "";
    boolean pTM = false;
    private double pTN = -1.0d;
    private boolean pTO = false;
    C21644g pTP = null;
    private C13073a pTQ;
    private C13073a pTR;
    private Map<String, C46532cz> pTS = new HashMap();
    private Runnable pTT = new C130809();
    private C30863c<C46175l> pTU = new C1308414();
    private C13062b pTV = new C13062b();
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
    private C4884c pUa = new C1307120();
    private C4884c pUb = new C1305821();
    private C4884c pUc = new C1305922();

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$21 */
    class C1305821 extends C4884c<C45325fv> {
        C1305821() {
            AppMethodBeat.m2504i(44913);
            this.xxI = C45325fv.class.getName().hashCode();
            AppMethodBeat.m2505o(44913);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44914);
            RemittanceBusiUI.m21047E(RemittanceBusiUI.this);
            AppMethodBeat.m2505o(44914);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$22 */
    class C1305922 extends C4884c<C26260vc> {
        C1305922() {
            AppMethodBeat.m2504i(44915);
            this.xxI = C26260vc.class.getName().hashCode();
            AppMethodBeat.m2505o(44915);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44916);
            C26260vc c26260vc = (C26260vc) c4883b;
            C4879a.xxA.mo10053d(RemittanceBusiUI.this.pUc);
            if (c26260vc.cRZ.result == -1) {
                RemittanceBusiUI.this.pTi.performClick();
            }
            AppMethodBeat.m2505o(44916);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$24 */
    class C1306024 implements OnClickListener {
        C1306024() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44918);
            C7060h.pYm.mo8381e(15235, Integer.valueOf(3));
            RemittanceBusiUI.m21100z(RemittanceBusiUI.this);
            AppMethodBeat.m2505o(44918);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$b */
    class C13062b implements Runnable {
        public C24157d pUr;

        C13062b() {
        }

        public final void run() {
            AppMethodBeat.m2504i(44932);
            RemittanceBusiUI.this.pTU.mo49361b(this.pUr);
            AppMethodBeat.m2505o(44932);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$18 */
    class C1306618 implements DialogInterface.OnClickListener {
        C1306618() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$19 */
    class C1306719 extends C4884c<C37719fw> {
        C1306719() {
            AppMethodBeat.m2504i(44909);
            this.xxI = C37719fw.class.getName().hashCode();
            AppMethodBeat.m2505o(44909);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44910);
            C37719fw c37719fw = (C37719fw) c4883b;
            if (c37719fw.czT.czW == 1) {
                C7060h.pYm.mo8381e(15386, Integer.valueOf(4), Integer.valueOf(2));
            } else {
                C7060h.pYm.mo8381e(15386, Integer.valueOf(5), Integer.valueOf(2));
            }
            RemittanceBusiUI.m21058a(RemittanceBusiUI.this, c37719fw.czT.czU, c37719fw);
            AppMethodBeat.m2505o(44910);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$29 */
    class C1306829 implements C40947a {
        C1306829() {
        }

        /* renamed from: ic */
        public final void mo9448ic(boolean z) {
            AppMethodBeat.m2504i(44928);
            RemittanceBusiUI.this.pTO = z;
            if (z) {
                RemittanceBusiUI.m21056a(RemittanceBusiUI.this, RemittanceBusiUI.this.nsk, RemittanceBusiUI.this.pTi);
                AppMethodBeat.m2505o(44928);
                return;
            }
            RemittanceBusiUI.this.nsk.scrollTo(0, 0);
            if (RemittanceBusiUI.this.pTh != null && RemittanceBusiUI.this.pTh.getVisibility() == 0) {
                RemittanceBusiUI.this.pTh.setFocusable(false);
                RemittanceBusiUI.this.pTh.setFocusable(true);
            }
            AppMethodBeat.m2505o(44928);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$5 */
    class C130695 implements C43454d {
        C130695() {
        }

        /* renamed from: a */
        public final void mo25102a(int i, int i2, C21644g c21644g) {
            AppMethodBeat.m2504i(44897);
            if (i != 0 || i2 != 0) {
                C23639t.makeText(RemittanceBusiUI.this.mController.ylL, RemittanceBusiUI.this.getString(C25738R.string.fdx), 0).show();
            } else if (c21644g.pOL.kdT != 0) {
                C23639t.makeText(RemittanceBusiUI.this.mController.ylL, c21644g.pOL.kdU, 0).show();
                AppMethodBeat.m2505o(44897);
                return;
            }
            AppMethodBeat.m2505o(44897);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$20 */
    class C1307120 extends C4884c<C37776ob> {
        C1307120() {
            AppMethodBeat.m2504i(44911);
            this.xxI = C37776ob.class.getName().hashCode();
            AppMethodBeat.m2505o(44911);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44912);
            C37776ob c37776ob = (C37776ob) c4883b;
            if (!(c37776ob == null || c37776ob.cKr == null)) {
                RemittanceBusiUI.m21060a(RemittanceBusiUI.this, c37776ob.cKr.cwB, c37776ob.cKr.cKs);
            }
            AppMethodBeat.m2505o(44912);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$23 */
    class C1307223 implements TextWatcher {
        C1307223() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(44917);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 2) {
                editable.delete(indexOf + 3, length);
            }
            RemittanceBusiUI.m21080g(RemittanceBusiUI.this);
            if (RemittanceBusiUI.this.pQY == 32) {
                RemittanceBusiUI.m21057a(RemittanceBusiUI.this, null, RemittanceBusiUI.this.pSH == null ? 400 : RemittanceBusiUI.this.pSH.pOH);
            }
            AppMethodBeat.m2505o(44917);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$a */
    class C13073a {
        private View jAp;
        private float pUl;
        private float pUm;
        private float pUn;
        private TenpaySecureEditText pUo;
        private TextView pUp;
        private View pUq;

        C13073a(int i, int i2, float f) {
            AppMethodBeat.m2504i(44930);
            this.pUl = (float) i;
            this.pUm = (float) i2;
            this.pUn = f;
            AppMethodBeat.m2505o(44930);
        }

        /* Access modifiers changed, original: final */
        public final void update() {
            AppMethodBeat.m2504i(44931);
            RemittanceBusiUI.this.pTb.setTextSize(1, RemittanceBusiUI.this.pTQ.pUm);
            RemittanceBusiUI.this.pTl.setTextSize(1, RemittanceBusiUI.this.pTQ.pUl);
            if (this.pUp == null) {
                this.pUp = (TextView) RemittanceBusiUI.this.pTh.findViewById(2131820694);
            }
            if (this.pUp != null) {
                this.pUp.setTextSize(this.pUl);
            }
            if (this.pUo == null) {
                this.pUo = (TenpaySecureEditText) RemittanceBusiUI.this.pTh.findViewById(2131820687);
            }
            if (this.pUo != null) {
                this.pUo.setTextSize(this.pUm);
            }
            if (this.jAp == null) {
                this.jAp = this.pUo.findViewById(2131829044);
            }
            if (this.jAp != null) {
                this.jAp.setMinimumHeight(C4977b.m7371b(RemittanceBusiUI.this, RemittanceBusiUI.this.pTQ.pUm));
            }
            if (this.pUq == null) {
                this.pUq = RemittanceBusiUI.this.findViewById(2131827003);
            }
            if (this.pUq != null) {
                ((LayoutParams) this.pUq.getLayoutParams()).topMargin = C4977b.m7371b(RemittanceBusiUI.this, this.pUn);
            }
            AppMethodBeat.m2505o(44931);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$30 */
    class C1307430 implements Runnable {
        C1307430() {
        }

        public final void run() {
            AppMethodBeat.m2504i(44929);
            RemittanceBusiUI.this.pSY.setText(RemittanceBusiUI.this.pTI);
            CharSequence eK = C36391e.m60007eK(C36391e.m60015mJ(RemittanceBusiUI.this.pTq), 10);
            if (!C5046bo.isNullOrNil(RemittanceBusiUI.this.pTr)) {
                eK = RemittanceBusiUI.this.getString(C25738R.string.do0, new Object[]{eK, RemittanceBusiUI.this.pTr});
            }
            RemittanceBusiUI.this.pSZ.setText(C44089j.m79293b(RemittanceBusiUI.this, eK, RemittanceBusiUI.this.pSZ.getTextSize()));
            if (RemittanceBusiUI.this.pSH != null) {
                if (RemittanceBusiUI.this.pSH.pOx != 1) {
                    RemittanceBusiUI.this.pTg.setVisibility(8);
                    AppMethodBeat.m2505o(44929);
                    return;
                } else if (!C5046bo.isNullOrNil(RemittanceBusiUI.this.pSH.pOy)) {
                    if (RemittanceBusiUI.this.pSH.pOG == 1) {
                        RemittanceBusiUI.this.pTg.setRoundCorner(true);
                    } else {
                        RemittanceBusiUI.this.pTg.setRoundCorner(false);
                    }
                    int b = C4977b.m7371b(RemittanceBusiUI.this, 36.0f);
                    RemittanceBusiUI.this.pTg.mo38954n(RemittanceBusiUI.this.pSH.pOy, b, b, -1);
                    AppMethodBeat.m2505o(44929);
                    return;
                } else if (!C5046bo.isNullOrNil(RemittanceBusiUI.this.pTq)) {
                    if (RemittanceBusiUI.this.pSH.pOG == 1) {
                        C40460b.m69437r(RemittanceBusiUI.this.pTg, RemittanceBusiUI.this.pTq);
                        AppMethodBeat.m2505o(44929);
                        return;
                    }
                    C40460b.m69434b(RemittanceBusiUI.this.pTg, RemittanceBusiUI.this.pTq);
                    AppMethodBeat.m2505o(44929);
                    return;
                }
            }
            RemittanceBusiUI.this.pTg.setVisibility(8);
            AppMethodBeat.m2505o(44929);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$8 */
    class C130758 implements C24103b {
        C130758() {
        }

        /* renamed from: kg */
        public final void mo25108kg(boolean z) {
            AppMethodBeat.m2504i(44900);
            if (z) {
                abv abv = RemittanceBusiUI.this.pTJ.pQG;
                String str = "MicroMsg.RemittanceBusiUI";
                String str2 = "onFavorSelected %s ";
                Object[] objArr = new Object[1];
                objArr[0] = abv == null ? "" : C28868a.m45884a(abv);
                C4990ab.m7417i(str, str2, objArr);
                RemittanceBusiUI.m21044B(RemittanceBusiUI.this);
            }
            AppMethodBeat.m2505o(44900);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$26 */
    class C1307626 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$26$2 */
        class C130772 implements DialogInterface.OnClickListener {

            /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$26$2$1 */
            class C130781 implements Runnable {
                C130781() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(44921);
                    RemittanceBusiUI.this.aqX();
                    AppMethodBeat.m2505o(44921);
                }
            }

            C130772() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(44922);
                C5004al.m7442n(new C130781(), 500);
                AppMethodBeat.m2505o(44922);
            }
        }

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$26$1 */
        class C130791 implements C30387b {
            C130791() {
            }

            /* renamed from: s */
            public final boolean mo4760s(CharSequence charSequence) {
                AppMethodBeat.m2504i(44920);
                RemittanceBusiUI.this.pSz = charSequence.toString();
                RemittanceBusiUI.m21086m(RemittanceBusiUI.this);
                AppMethodBeat.m2505o(44920);
                return true;
            }
        }

        C1307626() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44923);
            if (!RemittanceBusiUI.this.pTx) {
                RemittanceBusiUI.this.aoB();
            }
            C7060h.pYm.mo8381e(15235, Integer.valueOf(6));
            C22657a.m34348a(RemittanceBusiUI.this, RemittanceBusiUI.this.getString(C25738R.string.dnl), RemittanceBusiUI.this.pSz, RemittanceBusiUI.this.getString(C25738R.string.dnn), 20, new C130791(), new C130772());
            AppMethodBeat.m2505o(44923);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$9 */
    class C130809 implements Runnable {
        C130809() {
        }

        public final void run() {
            AppMethodBeat.m2504i(44901);
            RemittanceBusiUI.m21045C(RemittanceBusiUI.this);
            AppMethodBeat.m2505o(44901);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$11 */
    class C1308111 implements DialogInterface.OnClickListener {
        C1308111() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$12 */
    class C1308212 implements OnMenuItemClickListener {
        C1308212() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44903);
            if (RemittanceBusiUI.m21079f(RemittanceBusiUI.this)) {
                RemittanceBusiUI.this.aqX();
                RemittanceBusiUI.this.showDialog(1000);
            } else {
                RemittanceBusiUI.this.finish();
            }
            AppMethodBeat.m2505o(44903);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$13 */
    class C1308313 implements DialogInterface.OnClickListener {
        C1308313() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$14 */
    class C1308414 extends C30863c<C46175l> {
        C1308414() {
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo25117a(int i, int i2, C24157d c24157d) {
            AppMethodBeat.m2504i(44905);
            boolean a = RemittanceBusiUI.m21064a(RemittanceBusiUI.this, i, i2, (C46175l) c24157d);
            AppMethodBeat.m2505o(44905);
            return a;
        }

        /* renamed from: a */
        public final void mo25116a(C24157d c24157d) {
            AppMethodBeat.m2504i(44904);
            if (c24157d instanceof C46175l) {
                RemittanceBusiUI.m21070b(RemittanceBusiUI.this, ((C46175l) c24157d).czZ);
            }
            AppMethodBeat.m2505o(44904);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$1 */
    class C130861 implements OnMenuItemClickListener {
        C130861() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44893);
            RemittanceBusiUI.m21078e(RemittanceBusiUI.this);
            RemittanceBusiUI.this.finish();
            AppMethodBeat.m2505o(44893);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$28 */
    class C1308728 implements OnTouchListener {
        C1308728() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(44927);
            if (RemittanceBusiUI.this.pTO) {
                RemittanceBusiUI.this.aoB();
            }
            AppMethodBeat.m2505o(44927);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$2 */
    class C130882 implements OnClickListener {
        C130882() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44894);
            C7060h.pYm.mo8381e(15235, Integer.valueOf(3));
            RemittanceBusiUI.m21100z(RemittanceBusiUI.this);
            AppMethodBeat.m2505o(44894);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$3 */
    class C130893 implements C43453c {
        C130893() {
        }

        /* renamed from: cR */
        public final void mo25122cR(List<abw> list) {
            AppMethodBeat.m2504i(44895);
            RemittanceBusiUI.m21059a(RemittanceBusiUI.this, (List) list);
            AppMethodBeat.m2505o(44895);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$4 */
    class C130904 implements C43453c {
        C130904() {
        }

        /* renamed from: cR */
        public final void mo25122cR(List<abw> list) {
            AppMethodBeat.m2504i(44896);
            if (list.size() > 0) {
                RemittanceBusiUI.m21059a(RemittanceBusiUI.this, (List) list);
            }
            AppMethodBeat.m2505o(44896);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$25 */
    class C1309125 implements C9636a {
        C1309125() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(44919);
            C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "getContact %s", Boolean.valueOf(z));
            RemittanceBusiUI.m21083j(RemittanceBusiUI.this);
            AppMethodBeat.m2505o(44919);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$27 */
    class C1309227 extends C24019s {

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$27$2 */
        class C130932 implements C43453c {
            C130932() {
            }

            /* renamed from: cR */
            public final void mo25122cR(List<abw> list) {
                AppMethodBeat.m2504i(44925);
                RemittanceBusiUI.m21089p(RemittanceBusiUI.this);
                AppMethodBeat.m2505o(44925);
            }
        }

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI$27$1 */
        class C130941 implements C43453c {
            C130941() {
            }

            /* renamed from: cR */
            public final void mo25122cR(List<abw> list) {
                AppMethodBeat.m2504i(44924);
                RemittanceBusiUI.m21089p(RemittanceBusiUI.this);
                AppMethodBeat.m2505o(44924);
            }
        }

        C1309227() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(44926);
            C7060h.pYm.mo8381e(15235, Integer.valueOf(5));
            if (!RemittanceBusiUI.this.pTx) {
                RemittanceBusiUI.this.pTp = RemittanceBusiUI.m21087n(RemittanceBusiUI.this);
            }
            if (RemittanceBusiUI.this.pTp <= 0.0d) {
                C23639t.makeText(RemittanceBusiUI.this.mController.ylL, C25738R.string.f9y, 0).show();
                AppMethodBeat.m2505o(44926);
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
            C4990ab.m7417i(str2, str3, objArr);
            if (RemittanceBusiUI.this.pQY == 32) {
                if (!RemittanceBusiUI.this.pTM) {
                    RemittanceBusiUI.m21089p(RemittanceBusiUI.this);
                    AppMethodBeat.m2505o(44926);
                    return;
                } else if (RemittanceBusiUI.this.pTP == null || RemittanceBusiUI.this.pTP.pOR != ((int) (RemittanceBusiUI.this.pTp * 100.0d))) {
                    RemittanceBusiUI.m21057a(RemittanceBusiUI.this, new C130932(), 0);
                    AppMethodBeat.m2505o(44926);
                    return;
                } else if (RemittanceBusiUI.this.pTP == null || !RemittanceBusiUI.this.pTP.pOO) {
                    if (RemittanceBusiUI.this.pTP != null) {
                        RemittanceBusiUI.this.pTP.pOM = new C130941();
                        AppMethodBeat.m2505o(44926);
                        return;
                    }
                    AppMethodBeat.m2505o(44926);
                }
            }
            RemittanceBusiUI.m21089p(RemittanceBusiUI.this);
            AppMethodBeat.m2505o(44926);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RemittanceBusiUI() {
        AppMethodBeat.m2504i(44933);
        AppMethodBeat.m2505o(44933);
    }

    /* renamed from: B */
    static /* synthetic */ boolean m21044B(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.m2504i(44971);
        boolean cfS = remittanceBusiUI.cfS();
        AppMethodBeat.m2505o(44971);
        return cfS;
    }

    /* renamed from: E */
    static /* synthetic */ void m21047E(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.m2504i(44978);
        remittanceBusiUI.cfT();
        AppMethodBeat.m2505o(44978);
    }

    /* renamed from: f */
    static /* synthetic */ boolean m21079f(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.m2504i(44961);
        boolean cNR = remittanceBusiUI.cNR();
        AppMethodBeat.m2505o(44961);
        return cNR;
    }

    /* renamed from: g */
    static /* synthetic */ void m21080g(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.m2504i(44962);
        remittanceBusiUI.cbv();
        AppMethodBeat.m2505o(44962);
    }

    /* renamed from: j */
    static /* synthetic */ void m21083j(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.m2504i(44964);
        remittanceBusiUI.cfI();
        AppMethodBeat.m2505o(44964);
    }

    /* renamed from: n */
    static /* synthetic */ double m21087n(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.m2504i(44966);
        double cfR = remittanceBusiUI.cfR();
        AppMethodBeat.m2505o(44966);
        return cfR;
    }

    private double cfR() {
        AppMethodBeat.m2504i(44934);
        double d;
        if (this.pTx || this.pQY == 33) {
            d = this.pTp;
            AppMethodBeat.m2505o(44934);
            return d;
        }
        this.pTp = C5046bo.getDouble(this.pTh.getText(), 0.0d);
        d = this.pTp;
        AppMethodBeat.m2505o(44934);
        return d;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44935);
        super.onCreate(bundle);
        C7060h.pYm.mo8381e(15235, Integer.valueOf(1));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.f12269y3)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(C25738R.color.f11782h4));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.f12269y3));
        }
        if (C1443d.m3068iW(21)) {
            if (C1443d.m3068iW(23)) {
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        setBackBtn(new C1308212(), C1318a.actionbar_icon_dark_back);
        mo39992nf(1633);
        mo39992nf(1241);
        mo39992nf(2677);
        mo39992nf(2504);
        mo39992nf(2702);
        mo39992nf(2682);
        C30863c c30863c = this.pTU;
        C30868i c30868i = this.Ahr;
        c30863c.rtType = 2682;
        c30863c.Agk = c30868i;
        c30868i.Agq.put(Integer.valueOf(2682), c30863c);
        setMMTitle((int) C25738R.string.dnw);
        setBackBtn(new C130861());
        this.cEW = UUID.randomUUID().toString();
        C46349b.acq(this.cEW);
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
            C4990ab.m7420w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
            finish();
        }
        C7060h.pYm.mo8381e(15386, Integer.valueOf(1), Integer.valueOf(2));
        this.pTQ = new C13073a(28, 28, 2.0f);
        this.pTR = new C13073a(50, 50, 8.0f);
        initView();
        cbv();
        AppMethodBeat.m2505o(44935);
    }

    public void onResume() {
        AppMethodBeat.m2504i(44936);
        super.onResume();
        C39621e.cfP().mo62576eL(this);
        AppMethodBeat.m2505o(44936);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44937);
        this.nsk = (ScrollView) findViewById(2131820884);
        this.pSY = (TextView) findViewById(2131826999);
        this.pSZ = (TextView) findViewById(2131827000);
        this.pTa = (TextView) findViewById(2131827005);
        this.pTb = (TextView) findViewById(2131827007);
        this.pTc = (TextView) findViewById(2131827018);
        this.pTd = (TextView) findViewById(2131827019);
        this.pTg = (CdnImageView) findViewById(2131823740);
        this.pTh = (WalletFormView) findViewById(2131827002);
        this.pTi = (Button) findViewById(2131827016);
        this.pTj = (LinearLayout) findViewById(2131827004);
        this.pRm = (LinearLayout) findViewById(2131827001);
        this.pTk = (LinearLayout) findViewById(2131827017);
        this.pTe = (TextView) findViewById(2131827011);
        this.pTf = findViewById(2131827008);
        this.pTl = (TextView) findViewById(2131827006);
        this.pTm = findViewById(2131827013);
        this.pTn = (TextView) findViewById(2131827015);
        if (this.pTx) {
            if (!C5046bo.isNullOrNil(this.pTt)) {
                this.pTa.setText(C44089j.m79293b((Context) this, this.pTt, this.pTa.getTextSize()));
            }
            this.pTb.setText(C36391e.m59971F(this.pTp));
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
            mo39968a(this.pTh, 2, false, z, true);
            this.pTh.mo64594a(new C1307223());
            this.pTj.setVisibility(8);
            this.pRm.setVisibility(0);
        }
        if (C1720g.m3531RK()) {
            C1720g.m3537RQ();
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.pTq);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                C26417a.flu.mo20966a(this.pTq, "", new C1309125());
            }
        }
        cfI();
        this.pTk.setOnClickListener(new C1307626());
        this.pTi.setOnClickListener(new C1309227());
        this.nsk.setOnTouchListener(new C1308728());
        this.obM = new C1306829();
        if (!(this.pSH == null || this.pSH.pOE == null)) {
            this.pTJ.pQH = this.pSH.pOE;
            this.pTJ.mo8364VR(this.pSH.pOE.vPi);
        }
        if (cfS()) {
            C7060h.pYm.mo8381e(15235, Integer.valueOf(2));
        }
        AppMethodBeat.m2505o(44937);
    }

    private void cfI() {
        AppMethodBeat.m2504i(44938);
        C5004al.m7441d(new C1307430());
        AppMethodBeat.m2505o(44938);
    }

    private boolean cfS() {
        AppMethodBeat.m2504i(44939);
        if (this.pTf == null) {
            AppMethodBeat.m2505o(44939);
            return false;
        } else if (this.pSH != null) {
            boolean z;
            C4990ab.m7416i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
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
                this.pTn.setText(C36391e.m59971F(cfR()));
                abv abv = this.pTJ.pQG;
                if (abv != null) {
                    this.pTe.setTextColor(-30434);
                    this.pTe.setText(abv.pOz);
                    this.pTn.setText(C36391e.m59971F(((double) abv.wjf) / 100.0d));
                } else {
                    String cfv = this.pTJ.cfv();
                    if (!C5046bo.isNullOrNil(cfv)) {
                        this.pTe.setTextColor(-7829368);
                        this.pTe.setText(cfv);
                    }
                }
                findViewById(2131827010).setOnClickListener(new C130882());
                AppMethodBeat.m2505o(44939);
                return true;
            }
            this.pTf.setVisibility(8);
            this.pTR.update();
            this.pTm.setVisibility(8);
            AppMethodBeat.m2505o(44939);
            return false;
        } else {
            AppMethodBeat.m2505o(44939);
            return false;
        }
    }

    /* renamed from: cS */
    private void m21075cS(final List<abw> list) {
        AppMethodBeat.m2504i(44940);
        final C44403d c44403d = new C44403d(this);
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
        String string = getString(C25738R.string.dp8);
        if (string != null && string.length() > 0) {
            c44403d.zSw.setVisibility(0);
            c44403d.rMl.setText(string);
        }
        c44403d.zSx = arrayList;
        c44403d.rBl = new C36073c() {
            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(44898);
                int i = 0;
                RemittanceBusiUI.this.pTp = RemittanceBusiUI.m21087n(RemittanceBusiUI.this);
                if (!RemittanceBusiUI.this.pTJ.cfx() || RemittanceBusiUI.this.pTp <= 0.0d) {
                    for (abw abw : list) {
                        c44273l.mo70053a(i, abw.wjn, abw.wjp, null, true);
                        hashSet2.add(Integer.valueOf(i));
                        i++;
                    }
                    AppMethodBeat.m2505o(44898);
                    return;
                }
                for (abw abw2 : list) {
                    if (abw2.wjv == 1) {
                        c44273l.mo70053a(i, abw2.wjn, abw2.wjp, null, true);
                        hashSet2.add(Integer.valueOf(i));
                    } else {
                        c44273l.mo70052a(i, abw2.wjn, abw2.wjp);
                    }
                    i++;
                }
                AppMethodBeat.m2505o(44898);
            }
        };
        c44403d.rBm = new C5279d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                int i2 = 1;
                int i3 = 0;
                AppMethodBeat.m2504i(44899);
                if (hashSet2.contains(Integer.valueOf(i))) {
                    AppMethodBeat.m2505o(44899);
                    return;
                }
                if (i < list.size()) {
                    C7060h.pYm.mo8381e(15235, Integer.valueOf(4));
                    abw abw = (abw) list.get(i);
                    C44403d c44403d = c44403d;
                    List dLn;
                    if (c44403d.zSy != null) {
                        dLn = c44403d.zSy.dLn();
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
                    C3728b A = RemittanceBusiUI.this.pTJ;
                    if (i2 == 0) {
                        abw = null;
                    }
                    A.mo8365a(linkedList, abw);
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
                    C44403d c44403d2 = c44403d;
                    if (c44403d2.zSy != null) {
                        c44403d2.zSy.zSB = hashMap;
                        c44403d2.zSy.notifyDataSetChanged();
                    }
                }
                AppMethodBeat.m2505o(44899);
            }
        };
        c44403d.zSz = new C130758();
        if (c44403d.rBl != null) {
            c44403d.rBl.mo5746a(c44403d.rBn);
        }
        c44403d.zSy = new C44401a(c44403d.mContext);
        c44403d.zSy.dLm();
        c44403d.zSv.setAdapter(c44403d.zSy);
        c44403d.grC.setOnClickListener(new C443992());
        c44403d.jAH.setOnClickListener(new C444003());
        if (c44403d.zaW != null) {
            if (c44403d.rBn != null && c44403d.rBn.size() > 3) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c44403d.iym.getLayoutParams();
                layoutParams.height = c44403d.zaX;
                c44403d.iym.setLayoutParams(layoutParams);
            }
            c44403d.zaW.show();
        }
        AppMethodBeat.m2505o(44940);
    }

    /* renamed from: a */
    private void m21054a(C43453c c43453c, C43454d c43454d, int i) {
        AppMethodBeat.m2504i(44941);
        if (this.pTM) {
            this.pTn.setText(C36391e.m59971F(cfR()));
            C5004al.m7439af(this.pTT);
            this.pTp = cfR();
            long round = Math.round(this.pTp * 100.0d);
            if (round <= 0) {
                this.pTJ.cft();
                this.pTe.setTextColor(-7829368);
                this.pTe.setText(this.pSH.pOz);
                if (this.pTP != null) {
                    this.pTP.pOQ = true;
                }
                AppMethodBeat.m2505o(44941);
                return;
            }
            this.pTP = new C21644g((int) round, this.obL, this.pSH.pOA, this.pTt, this.pQW, this.pSH.pOB, this.pRC, this.pTq, this.pSH.pOC, c43453c == null ? 0 : 1, c43453c, c43454d);
            C5004al.m7442n(this.pTT, (long) i);
        }
        AppMethodBeat.m2505o(44941);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44942);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.pRR);
        C4879a.xxA.mo10053d(this.pUc);
        C4879a.xxA.mo10053d(this.pUa);
        this.pUb.dead();
        mo39993ng(1633);
        mo39993ng(1241);
        mo39993ng(2677);
        mo39993ng(2504);
        mo39993ng(2702);
        mo39993ng(2682);
        C46349b.acr(this.cEW);
        AppMethodBeat.m2505o(44942);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(44943);
        if (c1207m instanceof C28869i) {
            C28869i c28869i = (C28869i) c1207m;
            if (i != 0 || i2 != 0) {
                C4990ab.m7413e("MicroMsg.RemittanceBusiUI", "net error: %s", c1207m);
            } else if (c28869i.pOT.kdT == 0) {
                boolean z;
                this.pSy = c28869i.pOT.vFb;
                this.oXY = c28869i.pOT.vFc;
                this.pSD = c28869i.pOT.vFd;
                this.pTK = c28869i.pOT.vPD;
                this.pTL = c28869i.pOT.vPC;
                this.pTB = c28869i.pOT.vPI;
                this.pTC = c28869i.pOT.vPH;
                this.pTE = c28869i.pOT.vPL;
                this.pTF = c28869i.pOT.vPJ;
                this.pTG = c28869i.pOT.vPK;
                C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "touch_challenge %s need_change_auth_key %s", c28869i.pOT.vPM, Integer.valueOf(c28869i.pOT.vPN));
                if (c28869i.pOT.vPM != null) {
                    C35481v.tCn.msn = c28869i.pOT.vPM.dlY();
                }
                C35481v c35481v = C35481v.tCn;
                if (c28869i.pOT.vPN == 1) {
                    z = true;
                } else {
                    z = false;
                }
                c35481v.mso = z;
                if (!m21063a(c28869i)) {
                    m21077d(c28869i);
                }
            } else {
                C4990ab.m7413e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", Integer.valueOf(c28869i.pOT.kdT), c28869i.pOT.kdU);
                if (c28869i.pOT.vPB == null || C5046bo.isNullOrNil(c28869i.pOT.vPB.nZb)) {
                    C39621e cfP = C39621e.cfP();
                    DialogInterface.OnClickListener c1306310 = new DialogInterface.OnClickListener() {
                        /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(44902);
                            if (C5046bo.m7563gW(((C28869i) c1207m).pOT.vPP, 1)) {
                                int i2;
                                C39621e cfP = C39621e.cfP();
                                C4990ab.m7416i("MicroMsg.RemittanceBusiDialogMgr", "finishRemittanceF2fDynamicCodeUI()");
                                Context context = (Context) cfP.bSI.get();
                                if (context == null) {
                                    C4990ab.m7416i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
                                } else if (context instanceof RemittanceF2fDynamicCodeUI) {
                                    C4990ab.m7420w("MicroMsg.RemittanceBusiDialogMgr", "check() is RemittanceF2fDynamicCodeUI");
                                    ((Activity) context).finish();
                                    i2 = 1;
                                    if (i2 != 0) {
                                        C4990ab.m7420w("MicroMsg.RemittanceBusiUI", "finish RemittanceF2fDynamicCodeUI");
                                    }
                                    RemittanceBusiUI.this.finish();
                                }
                                i2 = 0;
                                if (i2 != 0) {
                                }
                                RemittanceBusiUI.this.finish();
                            }
                            AppMethodBeat.m2505o(44902);
                        }
                    };
                    C4990ab.m7421w("MicroMsg.RemittanceBusiDialogMgr", "showAlert3() msg:%s, title:%s", C5046bo.nullAsNil(c28869i.pOT.kdU), C5046bo.nullAsNil(""));
                    Context context = (Context) cfP.bSI.get();
                    if (context == null) {
                        C4990ab.m7416i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
                    } else {
                        C30379h.m48438a(context, r2, r3, c1306310);
                    }
                } else {
                    m21063a(c28869i);
                }
                if (c28869i.pOT.vPE == 1) {
                    m21054a(null, null, 0);
                }
            }
        } else if (c1207m instanceof C21645h) {
            C4990ab.m7416i("MicroMsg.RemittanceBusiUI", "pay check callback");
            AppMethodBeat.m2505o(44943);
            return true;
        } else if (c1207m instanceof C21644g) {
            C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", c1207m, Integer.valueOf(i), Integer.valueOf(i2));
            C21644g c21644g = (C21644g) c1207m;
            if (!c21644g.pOP.equals(this.pTP.pOP) || c21644g.pOQ) {
                c21644g.pOO = true;
                C4990ab.m7413e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", Boolean.valueOf(c21644g.pOQ));
                AppMethodBeat.m2505o(44943);
                return true;
            }
            C43454d c43454d;
            if (i != 0 || i2 != 0) {
                this.pTJ.cft();
                if (!(this.pSH == null || C5046bo.isNullOrNil(this.pSH.pOz))) {
                    this.pTe.setText(this.pSH.pOz);
                }
                this.pTe.setTextColor(-7829368);
                this.pTe.setText(getString(C25738R.string.dnq));
                c43454d = c21644g.pON;
                if (c43454d != null) {
                    c43454d.mo25102a(i, i2, c21644g);
                }
            } else if (c21644g.pOL.kdT == 0) {
                this.pTJ.pQH = c21644g.pOL.pOE;
                this.pTJ.mo8364VR(c21644g.pOL.pOE.vPi);
                cfS();
                C43453c c43453c = c21644g.pOM;
                C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", c43453c);
                if (c43453c != null) {
                    c43453c.mo25122cR(this.pTJ.cfu());
                }
            } else {
                this.pTJ.cft();
                this.pTe.setTextColor(-7829368);
                this.pTe.setText(c21644g.pOL.kdU);
                c43454d = c21644g.pON;
                if (c43454d != null) {
                    c43454d.mo25102a(i, i2, c21644g);
                }
            }
            c21644g.pOO = true;
            AppMethodBeat.m2505o(44943);
            return true;
        } else if (c1207m instanceof C46175l) {
            C46175l c46175l = (C46175l) c1207m;
            C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "NetSceneBusiF2fZeroCallback getHasRetried %s", Boolean.valueOf(c46175l.pOZ));
            if (i != 0 || i2 != 0) {
                C39621e.cfP().mo62574a(getString(C25738R.string.fu2), new C1308313());
            } else if (c46175l.pOY.kdT == 0) {
                cfU();
            } else {
                cfT();
                C39621e.cfP().mo62574a(c46175l.pOY.kdU, new C1308111());
            }
        }
        AppMethodBeat.m2505o(44943);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        AppMethodBeat.m2504i(44944);
        C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
        if (i == 3) {
            if (i2 != -1) {
                z = false;
            }
            m21062a(z, intent);
        } else if (i == 1) {
            if (i2 != -1) {
                z = false;
            }
            m21062a(z, intent);
        } else if (i == 2) {
            if (i2 == -1) {
                this.pTD = intent.getStringExtra("INTENT_RESULT_TOKEN");
                this.pTN = 0.0d;
                C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "onActivityResult _result_token: %s", r2);
                m21090p(false, intent.getStringExtra("INTENT_REQKEY"));
            } else {
                cfT();
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(44944);
    }

    /* renamed from: a */
    private void m21062a(boolean z, Intent intent) {
        AppMethodBeat.m2504i(44945);
        if (z) {
            String stringExtra = intent.getStringExtra("key_trans_id");
            double doubleExtra = intent.getDoubleExtra("key_total_fee", -1.0d);
            String stringExtra2 = intent.getStringExtra("key_reqKey");
            C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", stringExtra, Double.valueOf(doubleExtra));
            if (C5046bo.isNullOrNil(this.oXY)) {
                this.oXY = stringExtra;
            }
            if (doubleExtra >= 0.0d) {
                this.pTN = doubleExtra;
            }
            if (this.pRH) {
                C7060h.pYm.mo8381e(15386, Integer.valueOf(3), Integer.valueOf(2));
            }
            cfU();
            m21049VU(stringExtra2);
        } else if (C46374c.m87176aw(intent)) {
            finish();
            AppMethodBeat.m2505o(44945);
            return;
        } else if (C46374c.m87177ax(intent)) {
            AppMethodBeat.m2505o(44945);
            return;
        } else {
            C4990ab.m7416i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
            cfT();
        }
        m21073c(z, intent);
        AppMethodBeat.m2505o(44945);
    }

    /* renamed from: c */
    private void m21073c(boolean z, Intent intent) {
        AppMethodBeat.m2504i(44946);
        this.pTW = false;
        if (z) {
            C4990ab.m7416i("MicroMsg.RemittanceBusiUI", "savePayInfo isOk = true");
            this.cKs = 1;
        } else if (intent == null) {
            AppMethodBeat.m2505o(44946);
            return;
        } else {
            this.cKs = intent.getIntExtra("key_pay_reslut_type", 3);
            this.pTX = this.pTp;
            this.pTY = this.pSz;
            this.pTZ = this.pSy;
        }
        C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "savePayInfo() mLastPayResult:%s mLastTotalAmt:%s mLastPayerDesc:%s mLastF2fId:%s", Double.valueOf(this.pTX), Double.valueOf(this.pTX), this.pTY, this.pTZ);
        AppMethodBeat.m2505o(44946);
    }

    /* renamed from: p */
    private void m21090p(boolean z, String str) {
        AppMethodBeat.m2504i(44947);
        C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "doBusiZeroCallback %s", Boolean.valueOf(z));
        C46532cz c46532cz = (C46532cz) this.pTS.get(str);
        if (c46532cz == null) {
            AppMethodBeat.m2505o(44947);
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
        C1207m c46175l = new C46175l(chl, c46532cz, str2, i, this.pTD, str);
        if (z) {
            c46175l.pOZ = true;
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c46175l, 0);
            AppMethodBeat.m2505o(44947);
            return;
        }
        this.pTH = 0;
        mo39970a(c46175l, true, false);
        AppMethodBeat.m2505o(44947);
    }

    private void cfT() {
        AppMethodBeat.m2504i(44948);
        C4990ab.m7416i("MicroMsg.RemittanceBusiUI", "unLockFavorimp");
        abv abv = this.pTJ.pQG;
        if (abv == null) {
            C4990ab.m7416i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
            AppMethodBeat.m2505o(44948);
            return;
        }
        int round = (int) Math.round(this.pTp * 100.0d);
        C46532cz c46532cz = new C46532cz();
        c46532cz.cIb = this.obL;
        c46532cz.vFb = this.pSy;
        c46532cz.vFc = this.oXY;
        c46532cz.pOA = this.pSH.pOA;
        c46532cz.scene = this.pQY;
        c46532cz.vFd = this.pSD;
        c46532cz.vFe = abv;
        c46532cz.vFf = this.pTq;
        c46532cz.pPZ = this.pRC;
        c46532cz.vFg = round;
        mo39970a(new C43456k(c46532cz, this.pTK), false, false);
        AppMethodBeat.m2505o(44948);
    }

    public final int getLayoutId() {
        return 2130970509;
    }

    /* renamed from: a */
    private void m21053a(int i, C44141lp c44141lp, boolean z, C37719fw c37719fw, String str, String str2) {
        String str3;
        AppMethodBeat.m2504i(44949);
        int i2 = 0;
        if (!this.pTW) {
            boolean C = C5046bo.m7500C(Double.valueOf(this.pTX), Double.valueOf(this.pTp));
            boolean isEqual = C5046bo.isEqual(this.pTY, this.pSz);
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
        if (c44141lp == null) {
            str3 = "";
        } else {
            str3 = c44141lp.vPj;
        }
        C1207m c28869i = new C28869i(str4, str5, i3, str6, str7, i, i4, str8, str9, i5, i6, str10, abv, str3, this.pSH.pOA, str, this.pQW, str2, this.pTr, this.pTZ, this.cKs, i2);
        if (z) {
            int i7;
            c28869i.pOV = c37719fw;
            C30202lu c30202lu = (C30202lu) c28869i.gme.fsG.fsP;
            if (c37719fw.czT.czW == 1) {
                i7 = 1;
            } else {
                i7 = 0;
            }
            c30202lu.vPw = i7;
        }
        mo39970a(c28869i, true, false);
        AppMethodBeat.m2505o(44949);
    }

    private void cfU() {
        AppMethodBeat.m2504i(44950);
        C4990ab.m7416i("MicroMsg.RemittanceBusiUI", "goto busi result");
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
        C46532cz c46532cz = new C46532cz();
        c46532cz.cIb = this.obL;
        c46532cz.vFb = this.pSy;
        c46532cz.vFc = this.oXY;
        c46532cz.pOA = this.pSH.pOA;
        c46532cz.scene = this.pQY;
        c46532cz.vFd = this.pSD;
        c46532cz.vFe = abv;
        c46532cz.vFf = this.pTq;
        c46532cz.pPZ = this.pRC;
        c46532cz.vFg = round;
        try {
            intent.putExtra("AfterPlaceOrderCommReq", c46532cz.toByteArray());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.RemittanceBusiUI", e, "", new Object[0]);
        }
        startActivity(intent);
        finish();
        AppMethodBeat.m2505o(44950);
    }

    /* renamed from: a */
    private boolean m21063a(C28869i c28869i) {
        AppMethodBeat.m2504i(44951);
        boolean z = false;
        if (!this.pRM) {
            z = m21071b(c28869i);
        }
        if (!z) {
            z = m21074c(c28869i);
        }
        AppMethodBeat.m2505o(44951);
        return z;
    }

    /* renamed from: b */
    private boolean m21071b(final C28869i c28869i) {
        AppMethodBeat.m2504i(44952);
        if (C5046bo.isNullOrNil(c28869i.pOT.vPA)) {
            AppMethodBeat.m2505o(44952);
            return false;
        }
        this.pRM = true;
        m21067aY(1, c28869i.pOT.vFb);
        C39621e.cfP().mo62575a(c28869i.pOT.vPA, getString(C25738R.string.f9213t6), getString(C25738R.string.dnm), getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(44906);
                RemittanceBusiUI.m21055a(RemittanceBusiUI.this, 3, c28869i.pOT.vFb);
                if (RemittanceBusiUI.m21065a(RemittanceBusiUI.this, c28869i)) {
                    RemittanceBusiUI.m21047E(RemittanceBusiUI.this);
                    AppMethodBeat.m2505o(44906);
                    return;
                }
                RemittanceBusiUI.m21069b(RemittanceBusiUI.this, c28869i);
                AppMethodBeat.m2505o(44906);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(44907);
                RemittanceBusiUI.m21047E(RemittanceBusiUI.this);
                RemittanceBusiUI.m21055a(RemittanceBusiUI.this, 2, c28869i.pOT.vFb);
                AppMethodBeat.m2505o(44907);
            }
        });
        AppMethodBeat.m2505o(44952);
        return true;
    }

    /* renamed from: aY */
    private void m21067aY(int i, String str) {
        AppMethodBeat.m2504i(138551);
        this.pRJ = new C37823bh();
        this.pRJ.cVR = 1;
        this.pRJ.cVS = (long) i;
        this.pRJ.mo60528gd(str);
        this.pRJ.ajK();
        AppMethodBeat.m2505o(138551);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(44954);
        C4990ab.m7418v("MicroMsg.RemittanceBusiUI", "onNewIntent");
        AppMethodBeat.m2505o(44954);
    }

    /* renamed from: c */
    private boolean m21074c(final C28869i c28869i) {
        AppMethodBeat.m2504i(44955);
        if (c28869i.pOT.vPB != null) {
            this.pRP = true;
            C39621e.cfP().mo62575a(c28869i.pOT.kdU, "", c28869i.pOT.vPB.nZc, c28869i.pOT.vPB.nZb, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(44908);
                    C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "goto h5: %s", c28869i.pOT.vPB.kCs);
                    C36391e.m60016n(RemittanceBusiUI.this.mController.ylL, c28869i.pOT.vPB.kCs, false);
                    AppMethodBeat.m2505o(44908);
                }
            }, new C1306618());
            AppMethodBeat.m2505o(44955);
            return true;
        }
        AppMethodBeat.m2505o(44955);
        return false;
    }

    /* renamed from: d */
    private void m21077d(C28869i c28869i) {
        AppMethodBeat.m2504i(44956);
        C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "do start pay zero_pay_flag: %s", Integer.valueOf(c28869i.pOT.vPF));
        int round = (int) Math.round(this.pTp * 100.0d);
        C46532cz c46532cz = new C46532cz();
        c46532cz.cIb = this.obL;
        c46532cz.vFb = this.pSy;
        c46532cz.vFc = this.oXY;
        c46532cz.pOA = this.pSH.pOA;
        c46532cz.scene = this.pQY;
        c46532cz.vFd = this.pSD;
        c46532cz.vFe = this.pTJ.pQG;
        c46532cz.vFf = this.pTq;
        c46532cz.pPZ = this.pRC;
        c46532cz.vFg = round;
        this.pTS.put(c28869i.pOT.cBT, c46532cz);
        if (c28869i.pOT.vPF == 1) {
            m21061a(c28869i.pOT);
            AppMethodBeat.m2505o(44956);
            return;
        }
        PayInfo payInfo = new PayInfo();
        payInfo.czZ = c28869i.pOT.cBT;
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
        bundle.putString("extinfo_key_19", c28869i.pOT.pPJ);
        payInfo.vwh = bundle;
        payInfo.pPV = 1;
        Intent intent = new Intent();
        if (c28869i.pOT.pPG == 1) {
            bundle.putInt("extinfo_key_15", c28869i.pOT.vPO);
            bundle.putString("extinfo_key_17", c28869i.pOT.pPH);
            bundle.putString("extinfo_key_18", c28869i.pOT.pPI);
            intent.putExtra("key_pay_info", payInfo);
            intent.putExtra("from_patch_ui", true);
            intent.putExtra("key_rcvr_open_id", this.pRC);
            intent.putExtra("key_mch_info", this.pTw);
            intent.putExtra("key_mch_photo", this.pSH.pOy);
            intent.putExtra("key_transfer_qrcode_id", this.pTo);
            intent.putExtra("get_dynamic_code_sign", c28869i.pOT.pPH);
            intent.putExtra("get_dynamic_code_extend", c28869i.pOT.pPI);
            intent.putExtra("dynamic_code_spam_wording", c28869i.pOT.pPK);
            intent.putExtra("dynamic_code_amount", c28869i.pOT.vPO);
            intent.putExtra("show_paying_wording", c28869i.pOT.pPJ);
            intent.putExtra("show_avatar_type", this.pSH.pOG == 1);
            C7060h.pYm.mo8381e(15386, Integer.valueOf(2), Integer.valueOf(2));
            this.pRR.dnU();
            this.pUa.dnU();
            this.pUb.dnU();
            C25985d.m41468b((Context) this, "remittance", ".ui.RemittanceF2fDynamicCodeUI", intent, 3);
            AppMethodBeat.m2505o(44956);
            return;
        }
        if (C5046bo.isNullOrNil(c28869i.pOU)) {
            this.pRH = false;
        } else {
            this.pRH = true;
        }
        payInfo.vwp = this.cEW;
        payInfo.aPn = this.pRH;
        if (c28869i.pOV == null || c28869i.pOV.czT.czX == null) {
            C35899h.m58857a(this, false, "", payInfo, this.pTr, intent, 1);
            AppMethodBeat.m2505o(44956);
            return;
        }
        C35899h.m58857a(c28869i.pOV.czT.czX, false, "", payInfo, this.pTr, intent, c28869i.pOV.czT.czV);
        AppMethodBeat.m2505o(44956);
    }

    /* renamed from: a */
    private void m21061a(C44143lv c44143lv) {
        AppMethodBeat.m2504i(44957);
        C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "resp.payer_need_auth_flag %s", Integer.valueOf(c44143lv.vPG));
        if (c44143lv.vPG == 1) {
            Bundle bundle = new Bundle();
            C4879a.xxA.mo10052c(this.pUc);
            bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceBusiUI");
            bundle.putString("realname_verify_process_jump_plugin", "remittance");
            bundle.putInt("real_name_verify_mode", 0);
            bundle.putInt("entry_scene", this.pQY);
            C24143a.m37105a(this, C40105a.class, bundle);
            AppMethodBeat.m2505o(44957);
            return;
        }
        String str;
        Intent intent = new Intent();
        String str2 = "";
        if (C5046bo.isNullOrNil(this.pTI)) {
            String string = getString(C25738R.string.fq3);
            if (C5046bo.isNullOrNil(this.pTq)) {
                C4990ab.m7412e("MicroMsg.RemittanceBusiUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                str = str2;
            } else {
                C1720g.m3537RQ();
                C7616ad aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(this.pTq);
                if (aoM != null) {
                    Object[] objArr = new Object[1];
                    objArr[0] = C36391e.atA(aoM.mo16707Oj()) + (C5046bo.isNullOrNil(this.pTr) ? "" : "(" + this.pTr + ")");
                    str = C5046bo.m7584t(string, objArr);
                } else {
                    C4990ab.m7412e("MicroMsg.RemittanceBusiUI", "can not found contact for user::" + this.pTq);
                    str = str2;
                }
            }
        } else {
            str = this.pTI;
        }
        intent.putExtra("INTENT_TITLE", str);
        intent.putExtra("INTENT_CAN_TOUCH", this.pTE);
        intent.putExtra("INTENT_PAYFEE", C36391e.m59971F(0.0d));
        intent.putExtra("INTENT_REQKEY", c44143lv.cBT);
        try {
            intent.putExtra("INTENT_TOKENMESS", c44143lv.vPH.toByteArray());
            C25985d.m41468b(this.mController.ylL, "wallet", "com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI", intent, 2);
            AppMethodBeat.m2505o(44957);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.RemittanceBusiUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(44957);
        }
    }

    /* renamed from: VU */
    private void m21049VU(String str) {
        AppMethodBeat.m2504i(44958);
        C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "do pay check: %s", str);
        C46532cz c46532cz = (C46532cz) this.pTS.get(str);
        if (c46532cz == null) {
            AppMethodBeat.m2505o(44958);
            return;
        }
        if (!C5046bo.isNullOrNil(this.oXY)) {
            c46532cz.vFc = this.oXY;
        }
        mo39970a(new C21645h(c46532cz, this.pTK), false, false);
        AppMethodBeat.m2505o(44958);
    }

    private void cbv() {
        AppMethodBeat.m2504i(44959);
        this.pTp = cfR();
        if (this.pTp <= 0.0d) {
            findViewById(2131827010).setClickable(false);
            findViewById(2131827010).setEnabled(false);
            findViewById(2131827010).setOnClickListener(null);
            this.pTi.setClickable(false);
            this.pTi.setEnabled(false);
            this.pTe.setTextColor(getResources().getColor(C25738R.color.f12208w0));
            AppMethodBeat.m2505o(44959);
            return;
        }
        this.pTe.setTextColor(-7829368);
        findViewById(2131827010).setEnabled(true);
        findViewById(2131827010).setClickable(true);
        this.pTi.setClickable(true);
        this.pTi.setEnabled(true);
        findViewById(2131827010).setOnClickListener(new C1306024());
        AppMethodBeat.m2505o(44959);
    }

    /* renamed from: e */
    static /* synthetic */ void m21078e(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.m2504i(44960);
        C4990ab.m7416i("MicroMsg.RemittanceBusiUI", "do cancel pay");
        remittanceBusiUI.mo39970a(new C39602t(remittanceBusiUI.pTq, remittanceBusiUI.pTo, remittanceBusiUI.pTu, remittanceBusiUI.pRC), false, false);
        AppMethodBeat.m2505o(44960);
    }

    /* renamed from: m */
    static /* synthetic */ void m21086m(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.m2504i(44965);
        if (C5046bo.isNullOrNil(remittanceBusiUI.pSz)) {
            remittanceBusiUI.pTc.setText("");
            remittanceBusiUI.pTd.setText(C25738R.string.dnl);
            AppMethodBeat.m2505o(44965);
            return;
        }
        remittanceBusiUI.pTc.setText(remittanceBusiUI.getString(C25738R.string.dny, new Object[]{remittanceBusiUI.pSz}));
        remittanceBusiUI.pTd.setText(C25738R.string.dp6);
        AppMethodBeat.m2505o(44965);
    }

    /* renamed from: p */
    static /* synthetic */ void m21089p(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.m2504i(44967);
        C4990ab.m7416i("MicroMsg.RemittanceBusiUI", "do place order");
        if (remittanceBusiUI.pSH == null) {
            C4990ab.m7412e("MicroMsg.RemittanceBusiUI", "doPlaceOrder busi_resp is null");
            AppMethodBeat.m2505o(44967);
            return;
        }
        if (!remittanceBusiUI.pTx) {
            remittanceBusiUI.aoB();
        }
        remittanceBusiUI.m21053a((int) Math.round(remittanceBusiUI.pTp * 100.0d), remittanceBusiUI.pTJ.pQH, false, null, "", "");
        AppMethodBeat.m2505o(44967);
    }

    /* renamed from: z */
    static /* synthetic */ void m21100z(RemittanceBusiUI remittanceBusiUI) {
        AppMethodBeat.m2504i(44969);
        List list = null;
        if (remittanceBusiUI.pQY == 33) {
            if (remittanceBusiUI.pSH.pOE != null) {
                list = remittanceBusiUI.pSH.pOE.vPg;
            }
        } else if (remittanceBusiUI.pTJ.cfw()) {
            list = remittanceBusiUI.pTJ.cfu();
            if (list.size() == 0) {
                C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "can not find favor %s", Integer.valueOf(list.size()));
                AppMethodBeat.m2505o(44969);
                return;
            }
        } else {
            list = remittanceBusiUI.pSH.pOD;
        }
        remittanceBusiUI.pTp = remittanceBusiUI.cfR();
        if (((int) Math.round(remittanceBusiUI.pTp * 100.0d)) <= 0) {
            remittanceBusiUI.m21075cS(list);
            AppMethodBeat.m2505o(44969);
        } else if (!remittanceBusiUI.pTJ.cfw()) {
            remittanceBusiUI.m21054a(new C130904(), new C130695(), 0);
            AppMethodBeat.m2505o(44969);
        } else if (remittanceBusiUI.pTP == null) {
            remittanceBusiUI.m21075cS(list);
            AppMethodBeat.m2505o(44969);
        } else if (remittanceBusiUI.pTP.pOO) {
            remittanceBusiUI.m21075cS(list);
            AppMethodBeat.m2505o(44969);
        } else {
            remittanceBusiUI.pTP.pOM = new C130893();
            AppMethodBeat.m2505o(44969);
        }
    }

    /* renamed from: C */
    static /* synthetic */ void m21045C(RemittanceBusiUI remittanceBusiUI) {
        boolean z = true;
        AppMethodBeat.m2504i(44972);
        if (remittanceBusiUI.pSH == null) {
            C4990ab.m7412e("MicroMsg.RemittanceBusiUI", "busi_resp is null");
            if (remittanceBusiUI.pTP != null) {
                remittanceBusiUI.pTP.pOQ = true;
            }
            AppMethodBeat.m2505o(44972);
            return;
        }
        remittanceBusiUI.pTp = remittanceBusiUI.cfR();
        C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "update updateBilling %s", Integer.valueOf((int) Math.round(remittanceBusiUI.pTp * 100.0d)));
        if (((int) Math.round(remittanceBusiUI.pTp * 100.0d)) <= 0) {
            remittanceBusiUI.pTP.pOQ = true;
            remittanceBusiUI.pTJ.cft();
            remittanceBusiUI.pTe.setTextColor(-7829368);
            remittanceBusiUI.pTe.setText(remittanceBusiUI.pSH.pOz);
            if (remittanceBusiUI.pTP != null) {
                remittanceBusiUI.pTP.pOQ = true;
            }
            AppMethodBeat.m2505o(44972);
            return;
        }
        remittanceBusiUI.pTe.setText(C25738R.string.dnr);
        C1207m c1207m = remittanceBusiUI.pTP;
        if (remittanceBusiUI.pTP.pOM == null) {
            z = false;
        }
        remittanceBusiUI.mo39970a(c1207m, z, false);
        AppMethodBeat.m2505o(44972);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m21064a(RemittanceBusiUI remittanceBusiUI, int i, int i2, C46175l c46175l) {
        long j = 0;
        AppMethodBeat.m2504i(44973);
        if (remittanceBusiUI.pTF == 0) {
            AppMethodBeat.m2505o(44973);
            return false;
        } else if (remittanceBusiUI.pTH >= remittanceBusiUI.pTF) {
            C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "mZero_start_time %s >= mZero_try_time %s say bye bye", Integer.valueOf(remittanceBusiUI.pTH), Integer.valueOf(remittanceBusiUI.pTF));
            AppMethodBeat.m2505o(44973);
            return false;
        } else {
            remittanceBusiUI.pTV.pUr = c46175l;
            C13062b c13062b;
            if (i != 0 || i2 != 0) {
                remittanceBusiUI.pTH++;
                C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "mZero_try_interval_ms  mZero_start_time %s mZero_try_interval_ms %s", Integer.valueOf(remittanceBusiUI.pTH), Integer.valueOf(remittanceBusiUI.pTG));
                C5004al.m7439af(remittanceBusiUI.pTV);
                c13062b = remittanceBusiUI.pTV;
                if (remittanceBusiUI.pTG >= 0) {
                    j = (long) remittanceBusiUI.pTG;
                }
                C5004al.m7442n(c13062b, j);
                AppMethodBeat.m2505o(44973);
                return true;
            } else if (c46175l.pOY.kdT == 0) {
                AppMethodBeat.m2505o(44973);
                return false;
            } else if (c46175l.pOY.kdT == 0 || !c46175l.lSR) {
                AppMethodBeat.m2505o(44973);
                return false;
            } else {
                remittanceBusiUI.pTH++;
                C4990ab.m7417i("MicroMsg.RemittanceBusiUI", "mZero_try_interval_ms  mZero_start_time %s mZero_try_interval_ms %s", Integer.valueOf(remittanceBusiUI.pTH), Integer.valueOf(remittanceBusiUI.pTG));
                C5004al.m7439af(remittanceBusiUI.pTV);
                c13062b = remittanceBusiUI.pTV;
                if (remittanceBusiUI.pTG >= 0) {
                    j = (long) remittanceBusiUI.pTG;
                }
                C5004al.m7442n(c13062b, j);
                AppMethodBeat.m2505o(44973);
                return true;
            }
        }
    }
}
