package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.WxaLuckyMoneyBaseUI;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p988a.C43250i;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.protocal.protobuf.ash;
import com.tencent.p177mm.protocal.protobuf.bhk;
import com.tencent.p177mm.protocal.protobuf.bon;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI */
public class WxaLuckyMoneyDetailUI extends WxaLuckyMoneyBaseUI implements C21190b {
    private View abB;
    private TextView kEq;
    private TextView kGq;
    private TextView nSD;
    private final C28396a nSJ = new C31372d();
    private Intent nSK = null;
    private ListView nSL;
    private ImageView nSM;
    private TextView nSN;
    private ImageView nSO;
    private View nSP;
    private View nSQ;
    private C28397c nSR;
    private OnScrollListener nSS = new C247881();
    private TextView nsq;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI$2 */
    class C211892 implements OnMenuItemClickListener {
        C211892() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42025);
            if (WxaLuckyMoneyDetailUI.this.nSK != null) {
                WxaLuckyMoneyDetailUI.this.setResult(0, WxaLuckyMoneyDetailUI.this.nSK);
            } else {
                WxaLuckyMoneyDetailUI.this.setResult(-1, null);
            }
            WxaLuckyMoneyDetailUI.this.finish();
            AppMethodBeat.m2505o(42025);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI$1 */
    class C247881 implements OnScrollListener {
        private boolean nST = false;
        private boolean nSU;

        C247881() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(42023);
            if (absListView.getCount() == 0) {
                AppMethodBeat.m2505o(42023);
                return;
            }
            switch (i) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        WxaLuckyMoneyDetailUI.this.nSJ.mo46378xI(absListView.getCount());
                    }
                    this.nST = false;
                    AppMethodBeat.m2505o(42023);
                    return;
                case 1:
                    this.nST = true;
                    break;
            }
            AppMethodBeat.m2505o(42023);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            AppMethodBeat.m2504i(42024);
            if (i3 == 0 || !this.nST) {
                AppMethodBeat.m2505o(42024);
                return;
            }
            if (i <= 0) {
                int top;
                View childAt = absListView.getChildAt(i);
                if (childAt != null) {
                    top = 0 - childAt.getTop();
                } else {
                    top = 0;
                }
                if (top <= 100) {
                    z = false;
                }
            }
            if (this.nSU != z) {
                if (z) {
                    WxaLuckyMoneyDetailUI.m38716a(WxaLuckyMoneyDetailUI.this, WxaLuckyMoneyDetailUI.this.getResources().getDrawable(C25738R.drawable.b8e));
                } else {
                    WxaLuckyMoneyDetailUI.m38717b(WxaLuckyMoneyDetailUI.this);
                }
                this.nSU = z;
            }
            AppMethodBeat.m2505o(42024);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI$3 */
    class C247893 implements OnCancelListener {
        C247893() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42026);
            WxaLuckyMoneyDetailUI.this.bKV();
            if (WxaLuckyMoneyDetailUI.this.mController.contentView.getVisibility() == 8 || WxaLuckyMoneyDetailUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
                WxaLuckyMoneyDetailUI.this.mo73980c(-1, null);
            }
            AppMethodBeat.m2505o(42026);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WxaLuckyMoneyDetailUI() {
        AppMethodBeat.m2504i(42027);
        AppMethodBeat.m2505o(42027);
    }

    /* renamed from: a */
    static /* synthetic */ void m38716a(WxaLuckyMoneyDetailUI wxaLuckyMoneyDetailUI, Drawable drawable) {
        AppMethodBeat.m2504i(42039);
        wxaLuckyMoneyDetailUI.mo73981t(drawable);
        AppMethodBeat.m2505o(42039);
    }

    /* renamed from: b */
    static /* synthetic */ void m38717b(WxaLuckyMoneyDetailUI wxaLuckyMoneyDetailUI) {
        AppMethodBeat.m2504i(42040);
        wxaLuckyMoneyDetailUI.mo73981t(null);
        AppMethodBeat.m2505o(42040);
    }

    public final MMActivity bKU() {
        return this;
    }

    public final void bKV() {
        AppMethodBeat.m2504i(42029);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.m2505o(42029);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42030);
        super.onCreate(bundle);
        initView();
        this.nSJ.mo24262a(this, getIntent());
        AppMethodBeat.m2505o(42030);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        AppMethodBeat.m2504i(42031);
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        TextView textView = (TextView) findViewById(2131820958);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(C25738R.color.f12140tt));
        }
        AppMethodBeat.m2505o(42031);
        return onCreatePanelMenu;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(42032);
        if (this.nSK != null) {
            setResult(0, this.nSK);
        } else {
            setResult(-1, null);
        }
        finish();
        AppMethodBeat.m2505o(42032);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42033);
        setMMTitle((int) C25738R.string.cqg);
        setBackBtn(new C211892());
        this.nSL = (ListView) findViewById(2131825494);
        this.nSR = new C28397c(this.mController.ylL);
        this.abB = LayoutInflater.from(this).inflate(2130969974, null);
        this.nSL.addHeaderView(this.abB);
        this.nSL.setAdapter(this.nSR);
        this.nSR.nSz = false;
        this.nSL.setOnScrollListener(this.nSS);
        this.nSM = (ImageView) this.abB.findViewById(2131825442);
        this.nSN = (TextView) this.abB.findViewById(2131825444);
        this.nSO = (ImageView) this.abB.findViewById(2131825445);
        this.nsq = (TextView) this.abB.findViewById(2131825446);
        this.nSP = this.abB.findViewById(2131825447);
        this.nSD = (TextView) this.abB.findViewById(2131825448);
        this.nSQ = this.abB.findViewById(2131825450);
        this.kGq = (TextView) this.abB.findViewById(2131825452);
        this.kEq = (TextView) this.abB.findViewById(2131825464);
        this.tipDialog = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.cn5), true, new C247893());
        this.tipDialog.show();
        AppMethodBeat.m2505o(42033);
    }

    /* renamed from: cj */
    public final void mo36565cj(List<ash> list) {
        AppMethodBeat.m2504i(42036);
        this.nSR.mo46379ck(list);
        AppMethodBeat.m2505o(42036);
    }

    /* renamed from: ae */
    public final void mo36564ae(Intent intent) {
        this.nSK = intent;
    }

    public final int getLayoutId() {
        return 2130969977;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42038);
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.m2505o(42038);
    }

    /* renamed from: Qf */
    public final void mo24264Qf(String str) {
        AppMethodBeat.m2504i(42028);
        C30379h.m48465bQ(this, str);
        AppMethodBeat.m2505o(42028);
    }

    /* renamed from: a */
    public final void mo36562a(bhk bhk) {
        C43250i c43250i;
        AppMethodBeat.m2504i(42034);
        if (bhk == null) {
            c43250i = null;
        } else {
            C43250i c43250i2 = new C43250i();
            c43250i2.username = bhk.wKE;
            c43250i2.nSa = bhk.wKG;
            c43250i2.nickname = bhk.wKF;
            c43250i2.cSh = bhk.cSh;
            c43250i2.nSe = bhk.nSe;
            c43250i2.nSf = bhk.nSf;
            c43250i2.nSg = bhk.wKI != 0;
            c43250i2.nSc = bhk.nSc;
            c43250i2.nSb = bhk.nSb;
            c43250i2.nSd = bhk.nSd;
            c43250i = c43250i2;
        }
        m38715a(c43250i);
        mo36565cj(bhk.wKD);
        AppMethodBeat.m2505o(42034);
    }

    /* renamed from: a */
    public final void mo36563a(bon bon) {
        C43250i c43250i;
        AppMethodBeat.m2504i(42035);
        if (bon == null) {
            c43250i = null;
        } else {
            C43250i c43250i2 = new C43250i();
            c43250i2.username = bon.wKE;
            c43250i2.nSa = bon.wKG;
            c43250i2.nickname = bon.wKF;
            c43250i2.cSh = bon.cSh;
            c43250i2.nSe = bon.nSe;
            c43250i2.nSf = bon.nSf;
            c43250i2.nSg = bon.wKI != 0;
            c43250i2.nSc = bon.nSc;
            c43250i2.nSb = bon.nSb;
            c43250i2.nSd = bon.nSd;
            c43250i = c43250i2;
        }
        m38715a(c43250i);
        mo36565cj(bon.wKD);
        AppMethodBeat.m2505o(42035);
    }

    /* renamed from: a */
    private void m38715a(C43250i c43250i) {
        AppMethodBeat.m2504i(42037);
        Context context = this.mController.ylL;
        C46063x.m85811b(this.nSM, c43250i.nSa, c43250i.username);
        C46063x.m85800a(context, this.nSN, c43250i.nickname);
        C46063x.m85800a(context, this.nsq, c43250i.nSd);
        if (c43250i.nSc == 1) {
            this.nSO.setVisibility(0);
            this.nSO.setImageResource(C25738R.drawable.b9r);
        } else {
            this.nSO.setVisibility(8);
        }
        if (c43250i.nSb == 2) {
            this.nSD.setText(C36391e.m59971F(((double) c43250i.cSh) / 100.0d));
            this.nSR.nSz = false;
            this.nSP.setVisibility(0);
        } else {
            this.nSP.setVisibility(8);
        }
        if (C5046bo.isNullOrNil(c43250i.nSe)) {
            this.nSQ.setVisibility(8);
        } else {
            this.nSQ.setVisibility(0);
            this.kGq.setText(c43250i.nSe);
            this.kGq.setTextColor(getResources().getColor(C25738R.color.f12159ud));
        }
        if (C5046bo.isNullOrNil(c43250i.nSf)) {
            this.kEq.setText(null);
            AppMethodBeat.m2505o(42037);
            return;
        }
        this.kEq.setText(c43250i.nSf);
        AppMethodBeat.m2505o(42037);
    }
}
