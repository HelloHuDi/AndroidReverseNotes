package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.p329s.C10732w;
import com.tencent.p177mm.plugin.fingerprint.p413b.C11927i;
import com.tencent.p177mm.plugin.remittance.p1017a.C28850c;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.WalletSuccPageAwardWidget;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C7549ow;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import p1121d.p1122a.p1123a.C31176c;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI */
public class RemittanceResultNewUI extends RemittanceResultUI {
    private static int[] pWN = null;
    private int jLX;
    private int jLY;
    private C24088a jMO = null;
    private C5279d lCi = new C130993();
    private OnTouchListener mlU = new C216634();
    private OnLongClickListener mlV = new C131005();
    private PayInfo pGr;
    private int pQY;
    private LinearLayout pRn;
    private C31176c pSK;
    private WalletSuccPageAwardWidget pSL;
    private boolean pSQ = false;
    private C4884c<C32652uv> pSR = new C216651();
    private LinearLayout pUF;
    private LinearLayout pUG;
    private LinearLayout pUH;
    private TextView pUI;
    private TextView pUJ;
    private TextView pUK;
    private TextView pUL;
    private TextView pUM;
    private int pVv = 0;
    private boolean pWA;
    private TextView pWB;
    private ViewGroup pWC;
    private TextView pWD;
    private WalletTextView pWE;
    private ViewGroup pWF;
    private ViewGroup pWG;
    private ViewGroup pWH;
    private TextView pWI;
    private TextView pWJ;
    private WalletTextView pWK;
    private C7549ow pWL;
    private Button pWM;
    private Orders pWy;
    private String pWz;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI$3 */
    class C130993 implements C5279d {
        C130993() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(45117);
            ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
            CharSequence charSequence = "";
            if (C5046bo.m7563gW(RemittanceResultNewUI.this.pVv, 2131827031)) {
                charSequence = RemittanceResultNewUI.this.pUJ.getText().toString().trim();
            } else if (C5046bo.m7563gW(RemittanceResultNewUI.this.pVv, 2131827109)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(RemittanceResultNewUI.this.pUK.getText().toString().trim() + " ");
                String trim = RemittanceResultNewUI.this.pUM.getText().toString().trim();
                if (trim.endsWith(RemittanceResultNewUI.this.getString(C25738R.string.f9032n6))) {
                    stringBuilder.append(trim.substring(0, trim.length() - 4));
                } else {
                    stringBuilder.append(trim);
                }
                charSequence = stringBuilder.toString();
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, charSequence));
            C30379h.m48465bQ(RemittanceResultNewUI.this, RemittanceResultNewUI.this.getString(C25738R.string.f9083oz));
            AppMethodBeat.m2505o(45117);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI$5 */
    class C131005 implements OnLongClickListener {
        C131005() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(45119);
            C4990ab.m7410d("MicroMsg.RemittanceResultNewUI", "onLongClick");
            if (RemittanceResultNewUI.this.jMO == null) {
                RemittanceResultNewUI.this.jMO = new C24088a(RemittanceResultNewUI.this.mController.ylL);
            }
            RemittanceResultNewUI.this.jMO.mo39886a(view, RemittanceResultNewUI.this, RemittanceResultNewUI.this.lCi, RemittanceResultNewUI.this.jLX, RemittanceResultNewUI.this.jLY);
            RemittanceResultNewUI.this.pVv = view.getId();
            AppMethodBeat.m2505o(45119);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI$6 */
    class C131016 implements OnClickListener {
        C131016() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45120);
            RemittanceResultNewUI.m33171j(RemittanceResultNewUI.this);
            AppMethodBeat.m2505o(45120);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI$4 */
    class C216634 implements OnTouchListener {
        C216634() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(45118);
            switch (motionEvent.getAction()) {
                case 0:
                    RemittanceResultNewUI.this.jLX = (int) motionEvent.getRawX();
                    RemittanceResultNewUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(45118);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI$7 */
    class C216647 implements OnClickListener {
        C216647() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45121);
            RemittanceResultNewUI.m33171j(RemittanceResultNewUI.this);
            AppMethodBeat.m2505o(45121);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI$1 */
    class C216651 extends C4884c<C32652uv> {

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI$1$1 */
        class C216661 implements Runnable {
            C216661() {
            }

            public final void run() {
                AppMethodBeat.m2504i(45113);
                RemittanceResultNewUI.this.finish();
                AppMethodBeat.m2505o(45113);
            }
        }

        C216651() {
            AppMethodBeat.m2504i(45114);
            this.xxI = C32652uv.class.getName().hashCode();
            AppMethodBeat.m2505o(45114);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(45115);
            C32652uv c32652uv = (C32652uv) c4883b;
            C4990ab.m7416i("MicroMsg.RemittanceResultNewUI", "receive pay result event, do finish");
            if (c32652uv.cRF.cRG == 1000 || c32652uv.cRF.cRG == 1001) {
                C4990ab.m7416i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
                C40931c dOD = RemittanceResultNewUI.this.dOD();
                if (dOD != null) {
                    dOD.mo64569aF(RemittanceResultNewUI.this);
                }
                new C7306ak().postDelayed(new C216661(), 100);
            }
            AppMethodBeat.m2505o(45115);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI$8 */
    class C216678 implements Runnable {
        C216678() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45122);
            if (RemittanceResultNewUI.this.pQY == 33 || RemittanceResultNewUI.this.pQY == 32 || RemittanceResultNewUI.this.pQY == 48) {
                RemittanceResultNewUI.this.finish();
                AppMethodBeat.m2505o(45122);
            } else if (C5046bo.isNullOrNil(RemittanceResultNewUI.this.pWz) || RemittanceResultNewUI.this.pWA) {
                RemittanceResultNewUI.this.finish();
                AppMethodBeat.m2505o(45122);
            } else {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", RemittanceResultNewUI.this.pWz);
                intent.putExtra("finish_direct", false);
                C25985d.m41473f(RemittanceResultNewUI.this, ".ui.chatting.ChattingUI", intent);
                AppMethodBeat.m2505o(45122);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI$2 */
    class C216682 implements View.OnClickListener {
        C216682() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45116);
            RemittanceResultNewUI.m33159a(RemittanceResultNewUI.this);
            AppMethodBeat.m2505o(45116);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RemittanceResultNewUI() {
        AppMethodBeat.m2504i(45123);
        AppMethodBeat.m2505o(45123);
    }

    /* renamed from: a */
    static /* synthetic */ void m33159a(RemittanceResultNewUI remittanceResultNewUI) {
        AppMethodBeat.m2504i(45143);
        remittanceResultNewUI.cgd();
        AppMethodBeat.m2505o(45143);
    }

    /* renamed from: j */
    static /* synthetic */ void m33171j(RemittanceResultNewUI remittanceResultNewUI) {
        AppMethodBeat.m2504i(45144);
        remittanceResultNewUI.cge();
        AppMethodBeat.m2505o(45144);
    }

    public void finish() {
        AppMethodBeat.m2504i(45124);
        C4990ab.m7417i("MicroMsg.RemittanceResultNewUI", "finish this %s %s", this, C5046bo.dpG());
        if (this.pSQ) {
            AppMethodBeat.m2505o(45124);
            return;
        }
        super.finish();
        this.pSQ = true;
        AppMethodBeat.m2505o(45124);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45125);
        super.onCreate(bundle);
        if (C1443d.m3068iW(21)) {
            if (C1443d.m3068iW(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.pSR.dnU();
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        this.pGr = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        if (this.pGr == null) {
            C4990ab.m7412e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
            finish();
            AppMethodBeat.m2505o(45125);
            return;
        }
        String str = "";
        String str2 = "";
        if (this.pGr.vwh != null) {
            this.pWA = this.pGr.vwh.getBoolean("extinfo_key_4");
            str = this.pGr.vwh.getString("extinfo_key_1");
            str2 = this.pGr.vwh.getString("extinfo_key_16");
        }
        this.pQY = this.pGr.cIf;
        this.pWz = str;
        C4990ab.m7417i("MicroMsg.RemittanceResultNewUI", "payScene: %s", Integer.valueOf(r2));
        initView();
        if (this.pQY == 31) {
            C4990ab.m7417i("MicroMsg.RemittanceResultNewUI", "transId: %s", str2);
            C28850c.ceW().ceZ().mo55425fN(str2, this.pWz);
        }
        AppMethodBeat.m2505o(45125);
    }

    public final int getLayoutId() {
        return 2130970517;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(45126);
        if (i == 4) {
            cgd();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(45126);
        return onKeyUp;
    }

    public final void initView() {
        AppMethodBeat.m2504i(45127);
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.pWB = (TextView) findViewById(2131826971);
        this.pWC = (ViewGroup) findViewById(2131827101);
        this.pWD = (TextView) findViewById(2131827102);
        this.pWE = (WalletTextView) findViewById(2131827103);
        this.pWF = (ViewGroup) findViewById(2131827110);
        this.pWG = (ViewGroup) findViewById(2131826979);
        this.pWH = (ViewGroup) findViewById(2131827104);
        this.pWI = (TextView) findViewById(2131827105);
        this.pWJ = (TextView) findViewById(2131827106);
        this.pWK = (WalletTextView) findViewById(2131827107);
        this.pWM = (Button) findViewById(2131827116);
        this.pWM.setOnClickListener(new C216682());
        this.pSL = (WalletSuccPageAwardWidget) findViewById(2131826996);
        this.pUF = (LinearLayout) findViewById(2131827028);
        this.pUG = (LinearLayout) findViewById(2131822843);
        this.pRn = (LinearLayout) findViewById(2131827032);
        this.pUH = (LinearLayout) findViewById(2131827109);
        this.pUI = (TextView) findViewById(2131827030);
        this.pUJ = (TextView) findViewById(2131827031);
        this.pUK = (TextView) findViewById(2131827035);
        this.pUL = (TextView) findViewById(2131827036);
        this.pUM = (TextView) findViewById(2131827037);
        cfY();
        cgf();
        AppMethodBeat.m2505o(45127);
    }

    private void cfY() {
        AppMethodBeat.m2504i(45128);
        String mJ = C36391e.m60015mJ(this.pWz);
        if (this.pQY == 31 || this.pQY == 5) {
            this.pWJ.setText(C36391e.atq(this.pWy.pcl));
            this.pWK.setText(C36391e.m59971F(this.pWy.pTN));
            if (this.pQY == 31) {
                CharSequence string = getString(C25738R.string.dq9, new Object[]{mJ});
                if (C5046bo.isNullOrNil(string)) {
                    this.pWI.setVisibility(8);
                } else {
                    this.pWI.setText(C44089j.m79293b((Context) this, string, this.pWI.getTextSize()));
                }
            } else {
                boolean z;
                if (this.pGr.vwh == null || !this.pGr.vwh.getBoolean("extinfo_key_10")) {
                    z = false;
                } else {
                    z = true;
                }
                C4990ab.m7417i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", Boolean.valueOf(z));
                if (z) {
                    this.pWI.setText(getString(C25738R.string.dp7));
                } else if (!(this.pWy.tAq == null || this.pWy.tAq.get(0) == null || TextUtils.isEmpty(((Commodity) this.pWy.tAq.get(0)).pca))) {
                    this.pWI.setText(((Commodity) this.pWy.tAq.get(0)).pca);
                }
            }
            this.pWH.setVisibility(0);
            if (this.pWy.pPp > 0.0d) {
                cgc();
                ((MarginLayoutParams) this.pWF.getLayoutParams()).topMargin = C1338a.fromDPToPix(this, 20);
                this.pWF.setVisibility(0);
                this.pWG.setVisibility(0);
            }
            AppMethodBeat.m2505o(45128);
            return;
        }
        byte[] byteArray = this.mBundle.getByteArray("key_succpage_resp");
        if (byteArray != null) {
            this.pWL = new C7549ow();
            try {
                this.pWL.parseFrom(byteArray);
                this.pSK = this.pWL.tBw;
            } catch (Exception e) {
                this.pWL = null;
                this.pSK = null;
                C4990ab.printErrStackTrace("MicroMsg.RemittanceResultNewUI", e, "parse f2FPaySucPageResp error: %s", e.getMessage());
            }
        }
        cfZ();
        AppMethodBeat.m2505o(45128);
    }

    /* renamed from: n */
    public static int m33175n(Context context, String str, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(45129);
        int fromDPToPix = C1338a.fromDPToPix(context, 16);
        if (pWN == null) {
            pWN = C10732w.m18404db(context);
        }
        fromDPToPix = ((pWN[0] - C1338a.fromDPToPix(context, 88)) - i) / fromDPToPix;
        int length = str.length();
        int i3 = length / fromDPToPix;
        if (i3 <= 2 && (i3 != 2 || length % fromDPToPix <= 0)) {
            i2 = 0;
        }
        if (i2 != 0) {
            i2 = (fromDPToPix * 2) - 5;
            AppMethodBeat.m2505o(45129);
            return i2;
        }
        i2 = str.length();
        AppMethodBeat.m2505o(45129);
        return i2;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(45130);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(C25738R.string.f9082oy));
        AppMethodBeat.m2505o(45130);
    }

    private void cfZ() {
        AppMethodBeat.m2504i(45131);
        String mJ = C36391e.m60015mJ(this.pWz);
        this.pWD.setText(C36391e.atq(this.pWy.pcl));
        this.pWE.setText(C36391e.m59971F(this.pWy.pTN));
        this.pWG.removeAllViews();
        if (this.pQY == 32 || this.pQY == 33 || this.pQY == 48) {
            String str;
            boolean z;
            String str2 = "";
            if (this.pGr.vwh != null) {
                str2 = this.pGr.vwh.getString("extinfo_key_2");
            }
            if (mJ != null && mJ.length() > 10) {
                mJ = mJ.substring(0, 10) + "...";
            }
            if (C5046bo.isNullOrNil(str2)) {
                str = mJ;
            } else if (C5046bo.isNullOrNil(mJ)) {
                str = str2;
            } else {
                str = mJ + "(" + C36391e.att(str2) + ")";
            }
            View cga = cga();
            View cgb = cgb();
            View cgc = cgc();
            if (cga == null && cgb == null && cgc == null) {
                z = true;
            } else {
                z = false;
            }
            this.pWF.setVisibility(0);
            this.pWG.setVisibility(0);
            if (WalletSuccPageAwardWidget.m34320a(this.pSK)) {
                String str3 = "";
                if (this.pWy.tAq.size() > 0) {
                    str3 = ((Commodity) this.pWy.tAq.get(0)).cAa;
                }
                C4990ab.m7417i("MicroMsg.RemittanceResultNewUI", "transId: %s", str3);
                this.pSL.mo38237a(this, this.pSK, str3, true, (ImageView) findViewById(2131824036));
                this.pSL.init();
                this.pSL.setVisibility(0);
                m33162bd(str, false);
            } else {
                this.pSL.setVisibility(8);
                m33162bd(str, z);
            }
            if (cga != null) {
                this.pWG.addView(cga);
            }
            if (cgb != null) {
                this.pWG.addView(cgb);
            }
            if (cgc != null) {
                this.pWG.addView(cgc);
            }
        }
        this.pWC.setVisibility(0);
        AppMethodBeat.m2505o(45131);
    }

    /* renamed from: bd */
    private ViewGroup m33162bd(String str, boolean z) {
        AppMethodBeat.m2504i(45132);
        C4990ab.m7416i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
        ViewGroup viewGroup;
        TextView textView;
        if (z) {
            viewGroup = (ViewGroup) getLayoutInflater().inflate(2130969456, this.pWG, false);
            textView = (TextView) viewGroup.findViewById(2131823741);
            C40460b.m69433a((ImageView) viewGroup.findViewById(2131823740), this.pWz, 0.06f, false);
            textView.setText(str);
            this.pWG.addView(viewGroup);
            AppMethodBeat.m2505o(45132);
            return viewGroup;
        }
        viewGroup = (ViewGroup) getLayoutInflater().inflate(2130969455, this.pWG, false);
        textView = (TextView) viewGroup.findViewById(2131823741);
        C40460b.m69433a((ImageView) viewGroup.findViewById(2131823740), this.pWz, 0.06f, false);
        textView.setText(str);
        this.pWG.addView(viewGroup);
        AppMethodBeat.m2505o(45132);
        return viewGroup;
    }

    private View cga() {
        AppMethodBeat.m2504i(45133);
        C4990ab.m7416i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
        String string = this.pGr.vwh.getString("extinfo_key_3");
        String string2 = this.pGr.vwh.getString("extinfo_key_8");
        if (C5046bo.isNullOrNil(string)) {
            AppMethodBeat.m2505o(45133);
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(2130969454, this.pWG, false);
        TextView textView = (TextView) viewGroup.findViewById(2131821185);
        TextView textView2 = (TextView) viewGroup.findViewById(2131820991);
        if (C5046bo.isNullOrNil(string2)) {
            textView.setText(getString(C25738R.string.arp));
        } else {
            textView.setText(string2);
        }
        textView2.setText(string);
        AppMethodBeat.m2505o(45133);
        return viewGroup;
    }

    private View cgb() {
        AppMethodBeat.m2504i(45134);
        C4990ab.m7416i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
        String string = this.pGr.vwh.getString("extinfo_key_6");
        String string2 = this.pGr.vwh.getString("extinfo_key_7");
        if (C5046bo.isNullOrNil(string2)) {
            AppMethodBeat.m2505o(45134);
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(2130969454, this.pWG, false);
        TextView textView = (TextView) viewGroup.findViewById(2131821185);
        TextView textView2 = (TextView) viewGroup.findViewById(2131820991);
        if (C5046bo.isNullOrNil(string)) {
            textView.setText(getString(C25738R.string.aro));
        } else {
            textView.setText(string);
        }
        textView2.setText(string2);
        AppMethodBeat.m2505o(45134);
        return viewGroup;
    }

    private View cgc() {
        boolean z = true;
        AppMethodBeat.m2504i(45135);
        if (this.pWy != null) {
            String str = "MicroMsg.RemittanceResultNewUI";
            String str2 = "need set charge fee: %s";
            Object[] objArr = new Object[1];
            if (this.pWy.pPp <= 0.0d) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            if (this.pWy.pPp > 0.0d) {
                String string = getString(C25738R.string.dq6);
                String e = C36391e.m60006e(this.pWy.pPp, this.pWy.pcl);
                ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(2130969453, this.pWG, false);
                ImageView imageView = (ImageView) viewGroup.findViewById(2131821183);
                TextView textView = (TextView) viewGroup.findViewById(2131820991);
                ((TextView) viewGroup.findViewById(2131821185)).setText(string);
                imageView.setVisibility(8);
                textView.setText(e);
                this.pWG.addView(viewGroup);
                AppMethodBeat.m2505o(45135);
                return viewGroup;
            }
        }
        AppMethodBeat.m2505o(45135);
        return null;
    }

    private void cgd() {
        AppMethodBeat.m2504i(45136);
        C4990ab.m7416i("MicroMsg.RemittanceResultNewUI", "endRemittance");
        if (this.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.mo74574b(this, bundle, new C131016());
                realnameGuideHelper.mo74572a(this, bundle, new C216647());
                this.mBundle.remove("key_realname_guide_helper");
            }
            AppMethodBeat.m2505o(45136);
            return;
        }
        cge();
        AppMethodBeat.m2505o(45136);
    }

    private void cge() {
        AppMethodBeat.m2504i(45137);
        C4990ab.m7416i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
        dOD().mo8125b(this, this.mBundle);
        new C7306ak().postDelayed(new C216678(), 100);
        AppMethodBeat.m2505o(45137);
    }

    private void cgf() {
        AppMethodBeat.m2504i(45138);
        ((C11927i) C1720g.m3528K(C11927i.class)).mo7362g(this);
        AppMethodBeat.m2505o(45138);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45139);
        boolean c;
        if (WalletSuccPageAwardWidget.m34320a(this.pSK)) {
            c = this.pSL.mo38238c(i, i2, str, c1207m);
            AppMethodBeat.m2505o(45139);
            return c;
        }
        c = super.mo7885c(i, i2, str, c1207m);
        AppMethodBeat.m2505o(45139);
        return c;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgg() {
        return false;
    }

    public void onResume() {
        AppMethodBeat.m2504i(45141);
        super.onResume();
        if (WalletSuccPageAwardWidget.m34320a(this.pSK)) {
            this.pSL.onResume();
        }
        AppMethodBeat.m2505o(45141);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45142);
        super.onDestroy();
        this.pSR.dead();
        if (WalletSuccPageAwardWidget.m34320a(this.pSK)) {
            this.pSL.onDestroy();
        }
        AppMethodBeat.m2505o(45142);
    }

    /* renamed from: AM */
    public final void mo9439AM(int i) {
        AppMethodBeat.m2504i(45140);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.m2505o(45140);
    }
}
