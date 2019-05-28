package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.appbrand.a.i;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class WxaLuckyMoneyDetailUI extends WxaLuckyMoneyBaseUI implements b {
    private View abB;
    private TextView kEq;
    private TextView kGq;
    private TextView nSD;
    private final a nSJ = new d();
    private Intent nSK = null;
    private ListView nSL;
    private ImageView nSM;
    private TextView nSN;
    private ImageView nSO;
    private View nSP;
    private View nSQ;
    private c nSR;
    private OnScrollListener nSS = new OnScrollListener() {
        private boolean nST = false;
        private boolean nSU;

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(42023);
            if (absListView.getCount() == 0) {
                AppMethodBeat.o(42023);
                return;
            }
            switch (i) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        WxaLuckyMoneyDetailUI.this.nSJ.xI(absListView.getCount());
                    }
                    this.nST = false;
                    AppMethodBeat.o(42023);
                    return;
                case 1:
                    this.nST = true;
                    break;
            }
            AppMethodBeat.o(42023);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            AppMethodBeat.i(42024);
            if (i3 == 0 || !this.nST) {
                AppMethodBeat.o(42024);
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
                    WxaLuckyMoneyDetailUI.a(WxaLuckyMoneyDetailUI.this, WxaLuckyMoneyDetailUI.this.getResources().getDrawable(R.drawable.b8e));
                } else {
                    WxaLuckyMoneyDetailUI.b(WxaLuckyMoneyDetailUI.this);
                }
                this.nSU = z;
            }
            AppMethodBeat.o(42024);
        }
    };
    private TextView nsq;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WxaLuckyMoneyDetailUI() {
        AppMethodBeat.i(42027);
        AppMethodBeat.o(42027);
    }

    static /* synthetic */ void a(WxaLuckyMoneyDetailUI wxaLuckyMoneyDetailUI, Drawable drawable) {
        AppMethodBeat.i(42039);
        wxaLuckyMoneyDetailUI.t(drawable);
        AppMethodBeat.o(42039);
    }

    static /* synthetic */ void b(WxaLuckyMoneyDetailUI wxaLuckyMoneyDetailUI) {
        AppMethodBeat.i(42040);
        wxaLuckyMoneyDetailUI.t(null);
        AppMethodBeat.o(42040);
    }

    public final MMActivity bKU() {
        return this;
    }

    public final void bKV() {
        AppMethodBeat.i(42029);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(42029);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42030);
        super.onCreate(bundle);
        initView();
        this.nSJ.a(this, getIntent());
        AppMethodBeat.o(42030);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        AppMethodBeat.i(42031);
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        TextView textView = (TextView) findViewById(R.id.kh);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.tt));
        }
        AppMethodBeat.o(42031);
        return onCreatePanelMenu;
    }

    public void onBackPressed() {
        AppMethodBeat.i(42032);
        if (this.nSK != null) {
            setResult(0, this.nSK);
        } else {
            setResult(-1, null);
        }
        finish();
        AppMethodBeat.o(42032);
    }

    public final void initView() {
        AppMethodBeat.i(42033);
        setMMTitle((int) R.string.cqg);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42025);
                if (WxaLuckyMoneyDetailUI.this.nSK != null) {
                    WxaLuckyMoneyDetailUI.this.setResult(0, WxaLuckyMoneyDetailUI.this.nSK);
                } else {
                    WxaLuckyMoneyDetailUI.this.setResult(-1, null);
                }
                WxaLuckyMoneyDetailUI.this.finish();
                AppMethodBeat.o(42025);
                return true;
            }
        });
        this.nSL = (ListView) findViewById(R.id.cvt);
        this.nSR = new c(this.mController.ylL);
        this.abB = LayoutInflater.from(this).inflate(R.layout.a_z, null);
        this.nSL.addHeaderView(this.abB);
        this.nSL.setAdapter(this.nSR);
        this.nSR.nSz = false;
        this.nSL.setOnScrollListener(this.nSS);
        this.nSM = (ImageView) this.abB.findViewById(R.id.cue);
        this.nSN = (TextView) this.abB.findViewById(R.id.cug);
        this.nSO = (ImageView) this.abB.findViewById(R.id.cuh);
        this.nsq = (TextView) this.abB.findViewById(R.id.cui);
        this.nSP = this.abB.findViewById(R.id.cuj);
        this.nSD = (TextView) this.abB.findViewById(R.id.cuk);
        this.nSQ = this.abB.findViewById(R.id.cum);
        this.kGq = (TextView) this.abB.findViewById(R.id.cuo);
        this.kEq = (TextView) this.abB.findViewById(R.id.cv0);
        this.tipDialog = h.b(this.mController.ylL, getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(42026);
                WxaLuckyMoneyDetailUI.this.bKV();
                if (WxaLuckyMoneyDetailUI.this.mController.contentView.getVisibility() == 8 || WxaLuckyMoneyDetailUI.this.mController.contentView.getVisibility() == 4) {
                    ab.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
                    WxaLuckyMoneyDetailUI.this.c(-1, null);
                }
                AppMethodBeat.o(42026);
            }
        });
        this.tipDialog.show();
        AppMethodBeat.o(42033);
    }

    public final void cj(List<ash> list) {
        AppMethodBeat.i(42036);
        this.nSR.ck(list);
        AppMethodBeat.o(42036);
    }

    public final void ae(Intent intent) {
        this.nSK = intent;
    }

    public final int getLayoutId() {
        return R.layout.aa2;
    }

    public void onDestroy() {
        AppMethodBeat.i(42038);
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(42038);
    }

    public final void Qf(String str) {
        AppMethodBeat.i(42028);
        h.bQ(this, str);
        AppMethodBeat.o(42028);
    }

    public final void a(bhk bhk) {
        i iVar;
        AppMethodBeat.i(42034);
        if (bhk == null) {
            iVar = null;
        } else {
            i iVar2 = new i();
            iVar2.username = bhk.wKE;
            iVar2.nSa = bhk.wKG;
            iVar2.nickname = bhk.wKF;
            iVar2.cSh = bhk.cSh;
            iVar2.nSe = bhk.nSe;
            iVar2.nSf = bhk.nSf;
            iVar2.nSg = bhk.wKI != 0;
            iVar2.nSc = bhk.nSc;
            iVar2.nSb = bhk.nSb;
            iVar2.nSd = bhk.nSd;
            iVar = iVar2;
        }
        a(iVar);
        cj(bhk.wKD);
        AppMethodBeat.o(42034);
    }

    public final void a(bon bon) {
        i iVar;
        AppMethodBeat.i(42035);
        if (bon == null) {
            iVar = null;
        } else {
            i iVar2 = new i();
            iVar2.username = bon.wKE;
            iVar2.nSa = bon.wKG;
            iVar2.nickname = bon.wKF;
            iVar2.cSh = bon.cSh;
            iVar2.nSe = bon.nSe;
            iVar2.nSf = bon.nSf;
            iVar2.nSg = bon.wKI != 0;
            iVar2.nSc = bon.nSc;
            iVar2.nSb = bon.nSb;
            iVar2.nSd = bon.nSd;
            iVar = iVar2;
        }
        a(iVar);
        cj(bon.wKD);
        AppMethodBeat.o(42035);
    }

    private void a(i iVar) {
        AppMethodBeat.i(42037);
        Context context = this.mController.ylL;
        x.b(this.nSM, iVar.nSa, iVar.username);
        x.a(context, this.nSN, iVar.nickname);
        x.a(context, this.nsq, iVar.nSd);
        if (iVar.nSc == 1) {
            this.nSO.setVisibility(0);
            this.nSO.setImageResource(R.drawable.b9r);
        } else {
            this.nSO.setVisibility(8);
        }
        if (iVar.nSb == 2) {
            this.nSD.setText(e.F(((double) iVar.cSh) / 100.0d));
            this.nSR.nSz = false;
            this.nSP.setVisibility(0);
        } else {
            this.nSP.setVisibility(8);
        }
        if (bo.isNullOrNil(iVar.nSe)) {
            this.nSQ.setVisibility(8);
        } else {
            this.nSQ.setVisibility(0);
            this.kGq.setText(iVar.nSe);
            this.kGq.setTextColor(getResources().getColor(R.color.ud));
        }
        if (bo.isNullOrNil(iVar.nSf)) {
            this.kEq.setText(null);
            AppMethodBeat.o(42037);
            return;
        }
        this.kEq.setText(iVar.nSf);
        AppMethodBeat.o(42037);
    }
}
