package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37776ob;
import com.tencent.p177mm.p230g.p231a.C37776ob.C37777a;
import com.tencent.p177mm.p230g.p231a.C45325fv;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.C16001d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.collect.model.C33854b;
import com.tencent.p177mm.plugin.remittance.model.C39601m;
import com.tencent.p177mm.plugin.wallet_core.utils.C46374c;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C30254zr;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI */
public class RemittanceF2fDynamicCodeUI extends WalletBaseUI {
    private static int pWe = 60000;
    private String czU;
    private String kGW;
    private C18765a kHg = new C130961();
    private int nUf;
    private String nickname;
    private String pPJ;
    private Button pTi;
    private PayInfo pVL;
    private String pVM;
    private String pVN;
    private String pVO;
    private String pVP;
    private String pVQ;
    private String pVR;
    private String pVS;
    private List<C30254zr> pVT = new ArrayList();
    private boolean pVU = false;
    private TextView pVV;
    private TextView pVW;
    private LinearLayout pVX;
    private ImageView pVY;
    private LinearLayout pVZ;
    private WalletTextView pWa;
    private boolean pWb = false;
    private long pWc = 0;
    private long pWd = 0;
    private C7564ap pWf = new C7564ap(new C39617a(this, (byte) 0), true);
    private String pcI;
    private String username;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$7 */
    class C70437 implements C5279d {
        C70437() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(45057);
            if (i == 0) {
                RemittanceF2fDynamicCodeUI.m67721a(RemittanceF2fDynamicCodeUI.this, 1);
            }
            AppMethodBeat.m2505o(45057);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$1 */
    class C130961 implements C18765a {

        /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$1$1 */
        class C130971 implements Runnable {
            C130971() {
            }

            public final void run() {
                AppMethodBeat.m2504i(45050);
                RemittanceF2fDynamicCodeUI.m67723b(RemittanceF2fDynamicCodeUI.this);
                AppMethodBeat.m2505o(45050);
            }
        }

        C130961() {
        }

        /* renamed from: m */
        public final void mo8136m(String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(45051);
            if (str == null || RemittanceF2fDynamicCodeUI.this.kGW == null) {
                AppMethodBeat.m2505o(45051);
                return;
            }
            if (str.equals(RemittanceF2fDynamicCodeUI.this.kGW)) {
                C4990ab.m7417i("MicroMsg.RemittanceF2fDynamicCodeUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", RemittanceF2fDynamicCodeUI.this.kGW, str);
                RemittanceF2fDynamicCodeUI.this.runOnUiThread(new C130971());
            }
            AppMethodBeat.m2505o(45051);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$9 */
    class C130989 implements C40929a {
        C130989() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$8 */
    class C168458 implements C15994a {
        C168458() {
        }

        public final void onDismiss() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$6 */
    class C368046 implements C36073c {
        C368046() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(45056);
            c44273l.clear();
            c44273l.mo70072hi(0, C25738R.string.dqa);
            AppMethodBeat.m2505o(45056);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$3 */
    class C396153 implements OnMenuItemClickListener {
        C396153() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45053);
            if (RemittanceF2fDynamicCodeUI.m67724c(RemittanceF2fDynamicCodeUI.this)) {
                RemittanceF2fDynamicCodeUI.this.aqX();
                RemittanceF2fDynamicCodeUI.this.showDialog(1000);
            } else {
                RemittanceF2fDynamicCodeUI.this.setResult(0, new Intent().putExtra("key_pay_reslut_type", 4));
                RemittanceF2fDynamicCodeUI.this.finish();
            }
            AppMethodBeat.m2505o(45053);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$5 */
    class C396165 implements OnLongClickListener {
        C396165() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(45055);
            RemittanceF2fDynamicCodeUI.m67725d(RemittanceF2fDynamicCodeUI.this);
            AppMethodBeat.m2505o(45055);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$a */
    class C39617a implements C5015a {
        private C39617a() {
        }

        /* synthetic */ C39617a(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI, byte b) {
            this();
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(45058);
            C4990ab.m7410d("MicroMsg.RemittanceF2fDynamicCodeUI", "timer expired");
            if (RemittanceF2fDynamicCodeUI.this.pWb) {
                AppMethodBeat.m2505o(45058);
            } else {
                RemittanceF2fDynamicCodeUI.this.pWc = System.currentTimeMillis();
                RemittanceF2fDynamicCodeUI.m67727f(RemittanceF2fDynamicCodeUI.this);
                AppMethodBeat.m2505o(45058);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$10 */
    class C3961810 implements C40929a {
        C3961810() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI$4 */
    class C396194 extends C24019s {
        C396194() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(45054);
            RemittanceF2fDynamicCodeUI.m67721a(RemittanceF2fDynamicCodeUI.this, 2);
            AppMethodBeat.m2505o(45054);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RemittanceF2fDynamicCodeUI() {
        AppMethodBeat.m2504i(45059);
        AppMethodBeat.m2505o(45059);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m67724c(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.m2504i(45069);
        boolean cNR = remittanceF2fDynamicCodeUI.cNR();
        AppMethodBeat.m2505o(45069);
        return cNR;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45060);
        super.onCreate(bundle);
        if (cfX()) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.f12269y3)));
                View customView = getSupportActionBar().getCustomView();
                if (customView != null) {
                    View findViewById = customView.findViewById(2131821128);
                    if (findViewById != null) {
                        findViewById.setBackgroundColor(getResources().getColor(C25738R.color.f12085rt));
                    }
                    customView = customView.findViewById(16908308);
                    if (customView != null && (customView instanceof TextView)) {
                        ((TextView) customView).setTextColor(getResources().getColor(C25738R.color.f11782h4));
                    }
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
            setBackBtn(new C396153(), C1318a.back_icon_normal_black);
            mo39992nf(2736);
            setMMTitle((int) C25738R.string.dnw);
            this.pVL = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
            if (this.pVL == null) {
                C4990ab.m7412e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
                finish();
            }
            mo9439AM(4);
            this.nUf = this.pVL.vwh.getInt("extinfo_key_15");
            this.username = this.pVL.vwh.getString("extinfo_key_1");
            this.pcI = this.pVL.vwh.getString("extinfo_key_2");
            this.pVO = this.pVL.vwh.getString("extinfo_key_17");
            this.pVP = this.pVL.vwh.getString("extinfo_key_18");
            this.pVM = getIntent().getStringExtra("key_rcvr_open_id");
            this.pVQ = getIntent().getStringExtra("key_mch_info");
            this.pVN = getIntent().getStringExtra("key_transfer_qrcode_id");
            this.kGW = getIntent().getStringExtra("key_mch_photo");
            this.pPJ = getIntent().getStringExtra("show_paying_wording");
            this.pVR = getIntent().getStringExtra("dynamic_code_spam_wording");
            this.pVU = getIntent().getBooleanExtra("show_avatar_type", false);
            this.nickname = C36391e.m60015mJ(this.username);
            initView();
        }
        AppMethodBeat.m2505o(45060);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45061);
        if (cfX()) {
            this.pVV = (TextView) findViewById(2131827067);
            this.pVW = (TextView) findViewById(2131827072);
            this.pTi = (Button) findViewById(2131827073);
            this.pVY = (ImageView) findViewById(2131827069);
            this.pVX = (LinearLayout) findViewById(2131827070);
            this.pVZ = (LinearLayout) findViewById(2131827071);
            this.pWa = (WalletTextView) findViewById(2131827068);
            this.pWa.setText(getString(C25738R.string.dqb, new Object[]{C36391e.m59972G(((double) this.nUf) / 100.0d)}));
            this.pTi.setOnClickListener(new C396194());
            this.pVY.setOnLongClickListener(new C396165());
        }
        AppMethodBeat.m2505o(45061);
    }

    public void onResume() {
        AppMethodBeat.m2504i(45062);
        super.onResume();
        C39621e.cfP().mo62576eL(this);
        if (cfX()) {
            this.pWd = this.pWc <= 0 ? 0 : ((long) pWe) - (System.currentTimeMillis() - this.pWc);
            C4990ab.m7417i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", Long.valueOf(this.pWc), Long.valueOf(this.pWd));
            if (this.pWd < 0) {
                this.pWd = 0;
            }
            this.pWf.mo16770ae(this.pWd, (long) pWe);
            C4990ab.m7410d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
        }
        AppMethodBeat.m2505o(45062);
    }

    public void onPause() {
        AppMethodBeat.m2504i(45063);
        super.onPause();
        if (cfX()) {
            this.pWf.stopTimer();
            C4990ab.m7410d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
        }
        AppMethodBeat.m2505o(45063);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45064);
        if (cfX()) {
            mo39993ng(2736);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(45064);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        AppMethodBeat.m2504i(45065);
        super.onActivityResult(i, i2, intent);
        if (cfX()) {
            C4990ab.m7417i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
            if (i == 1) {
                C37776ob c37776ob = new C37776ob();
                C37777a c37777a = c37776ob.cKr;
                if (i2 != -1) {
                    z = false;
                }
                c37777a.cwB = z;
                if (intent != null) {
                    c37776ob.cKr.cKs = intent.getIntExtra("key_pay_reslut_type", 3);
                } else {
                    c37776ob.cKr.cKs = 3;
                }
                C4879a.xxA.mo10055m(c37776ob);
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    AppMethodBeat.m2505o(45065);
                    return;
                } else if (C46374c.m87176aw(intent)) {
                    setResult(0, intent);
                    finish();
                    AppMethodBeat.m2505o(45065);
                    return;
                } else if (C46374c.m87177ax(intent)) {
                    AppMethodBeat.m2505o(45065);
                    return;
                } else {
                    C45325fv c45325fv = new C45325fv();
                    c45325fv.czR.czS = false;
                    C4879a.xxA.mo10055m(c45325fv);
                }
            }
        }
        AppMethodBeat.m2505o(45065);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45066);
        if (cfX() && (c1207m instanceof C39601m)) {
            this.pWb = false;
            final C39601m c39601m = (C39601m) c1207m;
            mo9439AM(0);
            c39601m.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45052);
                    RemittanceF2fDynamicCodeUI.this.czU = c39601m.pPb.kCn;
                    RemittanceF2fDynamicCodeUI.this.pVS = c39601m.pPb.vVU;
                    RemittanceF2fDynamicCodeUI.this.pVT = c39601m.pPb.vVV;
                    RemittanceF2fDynamicCodeUI.m67723b(RemittanceF2fDynamicCodeUI.this);
                    AppMethodBeat.m2505o(45052);
                }
            }).mo70319b(new C3961810()).mo70320c(new C130989());
        }
        AppMethodBeat.m2505o(45066);
        return true;
    }

    public final int getLayoutId() {
        return 2130970512;
    }

    private boolean cfX() {
        AppMethodBeat.m2504i(45067);
        boolean booleanExtra = getIntent().getBooleanExtra("from_patch_ui", false);
        AppMethodBeat.m2505o(45067);
        return booleanExtra;
    }

    /* renamed from: b */
    static /* synthetic */ void m67723b(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.m2504i(45068);
        remittanceF2fDynamicCodeUI.pVY.setImageBitmap(C33854b.m55399a(remittanceF2fDynamicCodeUI, remittanceF2fDynamicCodeUI.czU, remittanceF2fDynamicCodeUI.username, remittanceF2fDynamicCodeUI.pVL.pPV, remittanceF2fDynamicCodeUI.kGW, remittanceF2fDynamicCodeUI.kHg, remittanceF2fDynamicCodeUI.pVU));
        if (!C5046bo.isNullOrNil(remittanceF2fDynamicCodeUI.pVS)) {
            remittanceF2fDynamicCodeUI.pVV.setText(remittanceF2fDynamicCodeUI.pVS);
        }
        if (C5046bo.isNullOrNil(remittanceF2fDynamicCodeUI.pVR)) {
            remittanceF2fDynamicCodeUI.pVZ.setVisibility(8);
        } else {
            remittanceF2fDynamicCodeUI.pVW.setText(remittanceF2fDynamicCodeUI.pVR);
            remittanceF2fDynamicCodeUI.pVZ.setVisibility(0);
        }
        remittanceF2fDynamicCodeUI.pVX.removeAllViews();
        if (!remittanceF2fDynamicCodeUI.pVT.isEmpty()) {
            for (C30254zr c30254zr : remittanceF2fDynamicCodeUI.pVT) {
                F2fDynamicCodeItemLayout f2fDynamicCodeItemLayout = new F2fDynamicCodeItemLayout(remittanceF2fDynamicCodeUI);
                String str = c30254zr.key;
                String str2 = c30254zr.value;
                f2fDynamicCodeItemLayout.pQF.setText(str);
                f2fDynamicCodeItemLayout.kRK.setText(str2);
                remittanceF2fDynamicCodeUI.pVX.addView(f2fDynamicCodeItemLayout, new LayoutParams(-1, -2));
            }
        }
        remittanceF2fDynamicCodeUI.pVX.requestLayout();
        AppMethodBeat.m2505o(45068);
    }

    /* renamed from: d */
    static /* synthetic */ void m67725d(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.m2504i(45071);
        C16001d c16001d = new C16001d(remittanceF2fDynamicCodeUI.mController.ylL, 1, false);
        c16001d.rBl = new C368046();
        c16001d.rBm = new C70437();
        c16001d.cpD();
        c16001d.zQf = new C168458();
        AppMethodBeat.m2505o(45071);
    }

    /* renamed from: f */
    static /* synthetic */ void m67727f(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.m2504i(45072);
        C4990ab.m7417i("MicroMsg.RemittanceF2fDynamicCodeUI", "do get dynamic code %s", remittanceF2fDynamicCodeUI.pVQ);
        remittanceF2fDynamicCodeUI.pWb = true;
        remittanceF2fDynamicCodeUI.mo39970a(new C39601m(remittanceF2fDynamicCodeUI.nUf, remittanceF2fDynamicCodeUI.username, remittanceF2fDynamicCodeUI.pVM, remittanceF2fDynamicCodeUI.pVN, remittanceF2fDynamicCodeUI.pVO, remittanceF2fDynamicCodeUI.pVP, remittanceF2fDynamicCodeUI.pVQ, remittanceF2fDynamicCodeUI.nickname, remittanceF2fDynamicCodeUI.pcI), false, false);
        AppMethodBeat.m2505o(45072);
    }
}
