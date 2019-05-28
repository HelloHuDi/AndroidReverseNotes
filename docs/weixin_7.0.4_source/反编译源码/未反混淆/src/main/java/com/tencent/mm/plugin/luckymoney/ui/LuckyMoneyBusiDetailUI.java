package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.am;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.b;
import com.tencent.mm.plugin.luckymoney.ui.h.c;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(3)
public class LuckyMoneyBusiDetailUI extends LuckyMoneyBaseUI {
    private int Lp = 0;
    private View abB;
    private boolean hZu = false;
    private TextView kEq;
    private TextView kGq;
    private View kZq;
    private TextView nSD;
    private ListView nSL;
    private ImageView nSM;
    private TextView nSN;
    private View nSP;
    private View nSQ;
    OnScrollListener nSS = new OnScrollListener() {
        private boolean nST = false;
        private boolean nSU;

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(42582);
            if (absListView.getCount() == 0) {
                AppMethodBeat.o(42582);
                return;
            }
            switch (i) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        if (!LuckyMoneyBusiDetailUI.this.ocz.bLA()) {
                            LuckyMoneyBusiDetailUI.this.hZu = false;
                        }
                        if (LuckyMoneyBusiDetailUI.this.ocG && !LuckyMoneyBusiDetailUI.this.hZu) {
                            LuckyMoneyBusiDetailUI.d(LuckyMoneyBusiDetailUI.this);
                        }
                    }
                    this.nST = false;
                    AppMethodBeat.o(42582);
                    return;
                case 1:
                    this.nST = true;
                    break;
            }
            AppMethodBeat.o(42582);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            AppMethodBeat.i(42583);
            if (i3 == 0 || !this.nST) {
                AppMethodBeat.o(42583);
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
                    LuckyMoneyBusiDetailUI.this.getResources().getDrawable(R.drawable.b8e);
                }
                this.nSU = z;
            }
            AppMethodBeat.o(42583);
        }
    };
    private List<w> nSx = new LinkedList();
    private TextView nsq;
    private LuckyMoneyWishFooter ocC;
    private ImageView ocD;
    private View ocE;
    private ImageView ocF;
    private boolean ocG = true;
    private int ocH;
    private String ocI;
    private String ocJ;
    private String ocK;
    private String ocL;
    private int ocM = 0;
    private Map<String, Integer> ocN = new HashMap();
    private i ocO;
    private String ocP = "";
    private boolean ocQ = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyBusiDetailUI() {
        AppMethodBeat.i(42597);
        AppMethodBeat.o(42597);
    }

    static /* synthetic */ void e(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        AppMethodBeat.i(42614);
        luckyMoneyBusiDetailUI.bMt();
        AppMethodBeat.o(42614);
    }

    static /* synthetic */ int xX(int i) {
        AppMethodBeat.i(42615);
        int xW = xW(i);
        AppMethodBeat.o(42615);
        return xW;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42598);
        super.onCreate(bundle);
        this.nSL = (ListView) findViewById(R.id.ctp);
        this.ocO = new i(this.mController.ylL);
        this.abB = LayoutInflater.from(this).inflate(R.layout.a_u, null);
        this.nSL.addHeaderView(this.abB);
        this.nSL.setAdapter(this.ocO);
        this.abB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42589);
                LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
                AppMethodBeat.o(42589);
            }
        });
        this.nSL.setOnScrollListener(this.nSS);
        this.nSL.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(42590);
                LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
                AppMethodBeat.o(42590);
            }
        });
        this.kZq = LayoutInflater.from(this).inflate(R.layout.a_t, null);
        this.nSM = (ImageView) this.abB.findViewById(R.id.ct7);
        this.nSN = (TextView) this.abB.findViewById(R.id.ct8);
        this.nsq = (TextView) this.abB.findViewById(R.id.ct9);
        this.nSP = this.abB.findViewById(R.id.ct_);
        this.nSD = (TextView) this.abB.findViewById(R.id.cta);
        this.nSQ = this.abB.findViewById(R.id.ctb);
        this.kGq = (TextView) this.abB.findViewById(R.id.ctd);
        this.ocD = (ImageView) this.abB.findViewById(R.id.ctc);
        this.kEq = (TextView) this.abB.findViewById(R.id.ctn);
        this.ocE = this.abB.findViewById(R.id.cte);
        this.ocF = (ImageView) this.abB.findViewById(R.id.ct6);
        ImageView imageView = (ImageView) findViewById(R.id.cto);
        this.ocC = (LuckyMoneyWishFooter) findViewById(R.id.ctr);
        this.ocC.a(new MMEditText.a() {
            public final void bMu() {
                AppMethodBeat.i(42591);
                if (LuckyMoneyBusiDetailUI.this.ocC.getVisibility() == 0) {
                    LuckyMoneyBusiDetailUI.this.ocC.setVisibility(8);
                    AppMethodBeat.o(42591);
                    return;
                }
                LuckyMoneyBusiDetailUI.this.mController.ylL.finish();
                AppMethodBeat.o(42591);
            }
        });
        this.ocC.setOnWishSendImp(new b() {
            public final void Qm(String str) {
                AppMethodBeat.i(42592);
                if (!(bo.isNullOrNil(str) || bo.isNullOrNil(LuckyMoneyBusiDetailUI.this.ocJ))) {
                    LuckyMoneyBusiDetailUI.this.n(new am(LuckyMoneyBusiDetailUI.this.ocI, str, LuckyMoneyBusiDetailUI.this.ocJ, "v1.0"));
                    LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
                }
                AppMethodBeat.o(42592);
            }
        });
        this.ocC.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(42593);
                j.r(LuckyMoneyBusiDetailUI.this);
                AppMethodBeat.o(42593);
            }
        });
        this.ocC.setOnkbdStateListener(new KeyboardLinearLayout.a() {
            public final void sD(int i) {
                AppMethodBeat.i(42594);
                if (i == -2 && LuckyMoneyBusiDetailUI.this.ocC.oil) {
                    LuckyMoneyBusiDetailUI.this.ocC.setModeClick(false);
                }
                AppMethodBeat.o(42594);
            }
        });
        this.ocO.ohU = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42595);
                LuckyMoneyBusiDetailUI.this.ocC.setVisibility(0);
                AppMethodBeat.o(42595);
            }
        };
        i iVar = this.ocO;
        iVar.ohV = new a();
        this.ocC.setMaxLength(25);
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42596);
                LuckyMoneyBusiDetailUI.this.finish();
                AppMethodBeat.o(42596);
            }
        });
        fixBackgroundRepeat(findViewById(R.id.ctq));
        this.ocI = getIntent().getStringExtra("key_sendid");
        this.ocK = getIntent().getStringExtra("key_native_url");
        this.ocH = getIntent().getIntExtra("key_jump_from", 2);
        this.ocM = getIntent().getIntExtra("key_static_from_scene", 0);
        ab.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", this.ocI, this.ocK, Integer.valueOf(this.ocH));
        if (this.ocH == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (byteArrayExtra != null) {
                    k kVar = (k) new k().parseFrom(byteArrayExtra);
                    if (kVar != null) {
                        a(kVar);
                        if (getIntent().getBooleanExtra("play_sound", false)) {
                            k.a(this, a.NOTSET);
                        }
                        AppMethodBeat.o(42598);
                    }
                }
            } catch (Exception e) {
                ab.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (bo.isNullOrNil(this.ocI) && !bo.isNullOrNil(this.ocK)) {
            try {
                this.ocI = Uri.parse(this.ocK).getQueryParameter("sendid");
            } catch (Exception e2) {
                ab.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + e2.getLocalizedMessage());
            }
        }
        if (bo.isNullOrNil(this.ocI)) {
            ab.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
        } else {
            bMr();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
        }
        AppMethodBeat.o(42598);
    }

    public static void fixBackgroundRepeat(View view) {
        AppMethodBeat.i(42599);
        if (view == null) {
            AppMethodBeat.o(42599);
            return;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            AppMethodBeat.o(42599);
        } else if (background instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
            bitmapDrawable.mutate();
            bitmapDrawable.setTileModeX(TileMode.REPEAT);
            AppMethodBeat.o(42599);
        } else {
            AppMethodBeat.o(42599);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(42600);
        if (keyEvent.getKeyCode() == 4 && this.ocC.getVisibility() == 0) {
            this.ocC.setVisibility(8);
            AppMethodBeat.o(42600);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(42600);
        return dispatchKeyEvent;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        boolean z = false;
        AppMethodBeat.i(42601);
        if (mVar instanceof af) {
            if (i == 0 && i2 == 0) {
                af afVar = (af) mVar;
                k kVar = afVar.nYn;
                this.ocP = afVar.nYz;
                a(kVar);
                AppMethodBeat.o(42601);
                return true;
            }
            h.bQ(this, str);
            AppMethodBeat.o(42601);
            return true;
        } else if (mVar instanceof am) {
            if (i == 0 && i2 == 0) {
                h.bQ(this, getString(R.string.cbn));
                this.ocO.nSz = false;
                bMt();
                am amVar = (am) mVar;
                if (this.nSx != null) {
                    while (true) {
                        boolean z2 = z;
                        if (z2 >= this.nSx.size()) {
                            break;
                        }
                        w wVar = (w) this.nSx.get(z2);
                        if (wVar.nWX.equalsIgnoreCase(amVar.nWX)) {
                            wVar.nYb = amVar.nSd;
                            this.ocO.notifyDataSetChanged();
                            break;
                        }
                        z = z2 + 1;
                    }
                }
                AppMethodBeat.o(42601);
                return true;
            }
            h.bQ(this, str);
            AppMethodBeat.o(42601);
            return true;
        } else if (!(mVar instanceof ar)) {
            AppMethodBeat.o(42601);
            return false;
        } else if (i == 0 && i2 == 0) {
            h.bQ(this, getString(R.string.cbn));
            AppMethodBeat.o(42601);
            return true;
        } else {
            h.bQ(this, str);
            AppMethodBeat.o(42601);
            return true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(42602);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bo.isNullOrNil(stringExtra)) {
                        if (this.ocL != null && this.ocL.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            ab.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            n(new ar(stringExtra.replaceAll(",", "|"), this.ocI, "v1.0"));
                            break;
                        }
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(42602);
    }

    public void finish() {
        AppMethodBeat.i(42603);
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiDetailUI");
            boolean b = realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(42584);
                    ab.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
                    AppMethodBeat.o(42584);
                }
            });
            getIntent().removeExtra("key_realname_guide_helper");
            if (!b) {
                super.finish();
            }
            AppMethodBeat.o(42603);
            return;
        }
        super.finish();
        AppMethodBeat.o(42603);
    }

    public final int getLayoutId() {
        return R.layout.a_v;
    }

    private void bMr() {
        AppMethodBeat.i(42604);
        this.hZu = true;
        if (this.Lp <= 0 || this.nSx.size() <= 0 || this.nSx.get(this.nSx.size() - 1) == null) {
            this.ocP = "";
            n(new af(this.ocI, 11, this.Lp, this.ocK, "v1.0", this.ocP));
            AppMethodBeat.o(42604);
            return;
        }
        n(new af(this.ocI, this.Lp, this.ocK, bo.getLong(((w) this.nSx.get(this.nSx.size() - 1)).nXN, 0), "v1.0", this.ocP));
        AppMethodBeat.o(42604);
    }

    private void a(k kVar) {
        AppMethodBeat.i(42605);
        if (kVar == null) {
            AppMethodBeat.o(42605);
            return;
        }
        this.ocG = kVar.nXa == 1;
        if (this.Lp == 0) {
            this.ocJ = kVar.nWX;
            this.ocO.nSy = this.ocJ;
            this.ocO.nSA = kVar.nXi;
            b(kVar);
            d(kVar);
            com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(xW(kVar.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        }
        c(kVar);
        LinkedList linkedList = kVar.nXj;
        if (linkedList != null) {
            for (int i = 0; i < linkedList.size(); i++) {
                w wVar = (w) linkedList.get(i);
                if (!this.ocN.containsKey(wVar.nWX)) {
                    this.nSx.add(linkedList.get(i));
                    this.ocN.put(wVar.nWX, Integer.valueOf(1));
                }
            }
            this.Lp += linkedList.size();
            this.hZu = false;
            this.ocO.ck(this.nSx);
        }
        eW(kVar.nXh, kVar.nXk);
        com.tencent.mm.plugin.report.service.h.pYm.e(13051, Integer.valueOf(this.ocM), Integer.valueOf(1), kVar.nXh, x.cl(kVar.nXe), "", "", "", "", kVar.nWQ, Integer.valueOf(kVar.resourceId));
        AppMethodBeat.o(42605);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARNING: Missing block: B:29:0x00da, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r11.nWR) == false) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(final k kVar) {
        AppMethodBeat.i(42606);
        if (kVar != null) {
            Context context = this.mController.ylL;
            if (kVar.nXi == 2) {
                this.nSM.setImageResource(R.drawable.b8q);
                if (kVar.resourceId != 0) {
                    ab.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + kVar.resourceId);
                    final com.tencent.mm.sdk.b.b hqVar = new hq();
                    hqVar.cCx.cCz = kVar.resourceId;
                    hqVar.callback = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42585);
                            if (hqVar.cCy.cCA) {
                                ab.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + hqVar.cCy.cCB);
                                x.m(LuckyMoneyBusiDetailUI.this.nSM, hqVar.cCy.cCB);
                                AppMethodBeat.o(42585);
                                return;
                            }
                            ab.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                            if (!bo.isNullOrNil(kVar.nWR)) {
                                x.b(LuckyMoneyBusiDetailUI.this.nSM, kVar.nWR, kVar.nXl);
                            }
                            AppMethodBeat.o(42585);
                        }
                    };
                    com.tencent.mm.sdk.b.a.xxA.a(hqVar, Looper.myLooper());
                }
                x.a(context, this.nSN, kVar.nWQ);
                x.a(context, this.nsq, kVar.nSd);
                if (kVar.cRV == 2 || this.ocH == 3) {
                    this.nSP.setVisibility(8);
                } else {
                    this.nSD.setText(e.F(((double) kVar.cSh) / 100.0d));
                    if (kVar.nWY != 1) {
                        this.ocO.nSz = true;
                    } else {
                        this.ocO.nSz = false;
                    }
                    this.nSP.setVisibility(0);
                }
                if (bo.isNullOrNil(kVar.nUj)) {
                    this.nSQ.setVisibility(0);
                    this.kGq.setText(kVar.nUj);
                    if (kVar.nUh == 1) {
                        if (TextUtils.isEmpty(kVar.nUi) || kVar.nUi.startsWith("weixin://wxpay")) {
                            this.ocD.setVisibility(8);
                        } else {
                            this.ocD.setVisibility(0);
                        }
                        this.kGq.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(42586);
                                if (TextUtils.isEmpty(kVar.nUi)) {
                                    e.QS(12);
                                    com.tencent.mm.pluginsdk.wallet.h.ak(LuckyMoneyBusiDetailUI.this.mController.ylL, 1);
                                    ab.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
                                    AppMethodBeat.o(42586);
                                    return;
                                }
                                ab.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + kVar.nUi);
                                if (kVar.nUi.startsWith("weixin://wxpay")) {
                                    e.QS(12);
                                    com.tencent.mm.pluginsdk.wallet.h.ak(LuckyMoneyBusiDetailUI.this.mController.ylL, 1);
                                    AppMethodBeat.o(42586);
                                    return;
                                }
                                e.QS(7);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", kVar.nUi);
                                d.b(LuckyMoneyBusiDetailUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.o(42586);
                            }
                        });
                    } else {
                        ab.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                        this.kGq.setTextColor(getResources().getColor(R.color.ud));
                    }
                } else {
                    ab.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                    this.nSQ.setVisibility(8);
                }
                if (bo.isNullOrNil(kVar.nXb)) {
                    this.kEq.setText(kVar.nXb);
                    AppMethodBeat.o(42606);
                    return;
                }
                this.kEq.setText(null);
            }
            x.b(this.nSM, kVar.nWR, kVar.nXl);
            x.a(context, this.nSN, kVar.nWQ);
            x.a(context, this.nsq, kVar.nSd);
            if (kVar.cRV == 2) {
            }
            this.nSP.setVisibility(8);
            if (bo.isNullOrNil(kVar.nUj)) {
            }
            if (bo.isNullOrNil(kVar.nXb)) {
            }
        }
        AppMethodBeat.o(42606);
    }

    private void eW(String str, String str2) {
        AppMethodBeat.i(42607);
        this.ocF.setImageResource(R.drawable.b8p);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
            this.ocF.setVisibility(8);
            AppMethodBeat.o(42607);
            return;
        }
        bMs();
        x.a(this.ocF, str, str2);
        this.ocF.setVisibility(0);
        AppMethodBeat.o(42607);
    }

    private void bMs() {
        AppMethodBeat.i(42608);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = ah.getContext().getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            AppMethodBeat.o(42608);
            return;
        }
        int dimensionPixelSize = (int) (((float) ((displayMetrics.widthPixels - (getResources().getDimensionPixelSize(R.dimen.a48) * 2)) - (getResources().getDimensionPixelSize(R.dimen.a47) * 2))) * 0.75f);
        LayoutParams layoutParams = this.ocF.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        this.ocF.setLayoutParams(layoutParams);
        AppMethodBeat.o(42608);
    }

    private void c(final k kVar) {
        AppMethodBeat.i(42609);
        if (kVar == null) {
            AppMethodBeat.o(42609);
            return;
        }
        int i;
        int i2 = ((kVar.cRU == 3 || kVar.cRU == 2) && kVar.nWZ == 1 && !this.ocG && kVar.nXc == 1) ? 1 : 0;
        if (kVar.nXd == null || kVar.nXd.erD != 1 || bo.isNullOrNil(kVar.nXd.nWy)) {
            i = 0;
        } else {
            i = 1;
        }
        TextView textView = (TextView) this.kZq.findViewById(R.id.ct2);
        if (i2 == 0 && i == 0) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42587);
                    com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(LuckyMoneyBusiDetailUI.xX(kVar.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                    x.a(LuckyMoneyBusiDetailUI.this, 1, false);
                    AppMethodBeat.o(42587);
                }
            });
            if (i != 0) {
                this.ocL = kVar.nXd.nWy;
                textView.setText(kVar.nXd.nWz);
            }
            com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(xW(kVar.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) this.kZq.findViewById(R.id.ct3);
        if (this.ocH == 1 || this.ocH == 3 || textView.getVisibility() == 0) {
            textView2.setVisibility(8);
        } else {
            textView2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42588);
                    com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(LuckyMoneyBusiDetailUI.xX(kVar.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                    Intent intent = new Intent();
                    intent.setClass(LuckyMoneyBusiDetailUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
                    intent.putExtra("key_type", 2);
                    LuckyMoneyBusiDetailUI.this.startActivity(intent);
                    AppMethodBeat.o(42588);
                }
            });
            textView2.setVisibility(0);
        }
        if (!this.ocQ) {
            this.nSL.addFooterView(this.kZq);
            this.ocQ = true;
        }
        AppMethodBeat.o(42609);
    }

    private void d(k kVar) {
        AppMethodBeat.i(42610);
        if (kVar != null) {
            ViewGroup viewGroup;
            LinkedList linkedList = kVar.nXe;
            if (linkedList != null && linkedList.size() > 0) {
                View findViewById = this.abB.findViewById(R.id.ctf);
                View findViewById2 = this.abB.findViewById(R.id.cti);
                View findViewById3 = this.abB.findViewById(R.id.ctl);
                viewGroup = (ViewGroup) this.abB.findViewById(R.id.ctg);
                ViewGroup viewGroup2 = (ViewGroup) this.abB.findViewById(R.id.ctj);
                ViewGroup viewGroup3 = (ViewGroup) this.abB.findViewById(R.id.ctm);
                View findViewById4 = this.abB.findViewById(R.id.cth);
                View findViewById5 = this.abB.findViewById(R.id.ctk);
                c cVar = new c();
                cVar.textColor = getResources().getColor(R.color.tr);
                cVar.ogL = true;
                cVar.resourceId = kVar.resourceId;
                cVar.ogM = this.ocM;
                if (linkedList.size() > 0) {
                    h.a(this, viewGroup, (as) linkedList.get(0), cVar);
                    findViewById.setVisibility(0);
                }
                if (linkedList.size() > 1) {
                    h.a(this, viewGroup2, (as) linkedList.get(1), cVar);
                    findViewById2.setVisibility(0);
                }
                if (linkedList.size() > 2) {
                    h.a(this, viewGroup3, (as) linkedList.get(2), cVar);
                    findViewById3.setVisibility(0);
                }
                if (findViewById.getVisibility() == 0 && (findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0)) {
                    findViewById4.setVisibility(0);
                }
                if (findViewById2.getVisibility() == 0 && findViewById3.getVisibility() == 0) {
                    findViewById5.setVisibility(0);
                }
                if (findViewById.getVisibility() == 0 || findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0) {
                    this.ocE.requestLayout();
                    this.ocE.setVisibility(0);
                }
            }
            viewGroup = (ViewGroup) this.kZq.findViewById(R.id.ct4);
            c cVar2 = new c();
            cVar2.textColor = getResources().getColor(R.color.tr);
            cVar2.textSize = getResources().getDimensionPixelSize(R.dimen.ni);
            h.a(this, viewGroup, kVar.nXf, cVar2);
        }
        AppMethodBeat.o(42610);
    }

    private void bMt() {
        AppMethodBeat.i(42611);
        if (!(this.ocC == null || this.ocC.getVisibility() == 8)) {
            this.ocC.setVisibility(8);
        }
        AppMethodBeat.o(42611);
    }

    public void onDestroy() {
        AppMethodBeat.i(42612);
        super.onDestroy();
        if (this.ocC != null) {
            this.ocC.bMO();
        }
        AppMethodBeat.o(42612);
    }

    private static int xW(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
