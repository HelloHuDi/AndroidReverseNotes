package com.tencent.p177mm.plugin.luckymoney.p449ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26157hq;
import com.tencent.p177mm.p612ui.KeyboardLinearLayout.C44246a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5620a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.luckymoney.model.C12425af;
import com.tencent.p177mm.plugin.luckymoney.model.C12428k;
import com.tencent.p177mm.plugin.luckymoney.model.C21198ar;
import com.tencent.p177mm.plugin.luckymoney.model.C36785am;
import com.tencent.p177mm.plugin.luckymoney.model.C39323w;
import com.tencent.p177mm.plugin.luckymoney.model.C43255as;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C21249h.C21253c;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C21256i.C21257a;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C43285k.C28461a;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyWishFooter.C12468b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI */
public class LuckyMoneyBusiDetailUI extends LuckyMoneyBaseUI {
    /* renamed from: Lp */
    private int f15057Lp = 0;
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
    OnScrollListener nSS = new C344661();
    private List<C39323w> nSx = new LinkedList();
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
    private C21256i ocO;
    private String ocP = "";
    private boolean ocQ = false;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$10 */
    class C1243710 implements C12468b {
        C1243710() {
        }

        /* renamed from: Qm */
        public final void mo24307Qm(String str) {
            AppMethodBeat.m2504i(42592);
            if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(LuckyMoneyBusiDetailUI.this.ocJ))) {
                LuckyMoneyBusiDetailUI.this.mo24304n(new C36785am(LuckyMoneyBusiDetailUI.this.ocI, str, LuckyMoneyBusiDetailUI.this.ocJ, "v1.0"));
                LuckyMoneyBusiDetailUI.m56493e(LuckyMoneyBusiDetailUI.this);
            }
            AppMethodBeat.m2505o(42592);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$7 */
    class C212187 implements OnClickListener {
        C212187() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42589);
            LuckyMoneyBusiDetailUI.m56493e(LuckyMoneyBusiDetailUI.this);
            AppMethodBeat.m2505o(42589);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$8 */
    class C212198 implements OnItemClickListener {
        C212198() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(42590);
            LuckyMoneyBusiDetailUI.m56493e(LuckyMoneyBusiDetailUI.this);
            AppMethodBeat.m2505o(42590);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$12 */
    class C3446412 implements C44246a {
        C3446412() {
        }

        /* renamed from: sD */
        public final void mo7486sD(int i) {
            AppMethodBeat.m2504i(42594);
            if (i == -2 && LuckyMoneyBusiDetailUI.this.ocC.oil) {
                LuckyMoneyBusiDetailUI.this.ocC.setModeClick(false);
            }
            AppMethodBeat.m2505o(42594);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$14 */
    class C3446514 implements OnClickListener {
        C3446514() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42596);
            LuckyMoneyBusiDetailUI.this.finish();
            AppMethodBeat.m2505o(42596);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$1 */
    class C344661 implements OnScrollListener {
        private boolean nST = false;
        private boolean nSU;

        C344661() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(42582);
            if (absListView.getCount() == 0) {
                AppMethodBeat.m2505o(42582);
                return;
            }
            switch (i) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        if (!LuckyMoneyBusiDetailUI.this.ocz.bLA()) {
                            LuckyMoneyBusiDetailUI.this.hZu = false;
                        }
                        if (LuckyMoneyBusiDetailUI.this.ocG && !LuckyMoneyBusiDetailUI.this.hZu) {
                            LuckyMoneyBusiDetailUI.m56492d(LuckyMoneyBusiDetailUI.this);
                        }
                    }
                    this.nST = false;
                    AppMethodBeat.m2505o(42582);
                    return;
                case 1:
                    this.nST = true;
                    break;
            }
            AppMethodBeat.m2505o(42582);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            AppMethodBeat.m2504i(42583);
            if (i3 == 0 || !this.nST) {
                AppMethodBeat.m2505o(42583);
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
                    LuckyMoneyBusiDetailUI.this.getResources().getDrawable(C25738R.drawable.b8e);
                }
                this.nSU = z;
            }
            AppMethodBeat.m2505o(42583);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$2 */
    class C344672 implements DialogInterface.OnClickListener {
        C344672() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42584);
            C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
            AppMethodBeat.m2505o(42584);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$9 */
    class C344699 implements C5620a {
        C344699() {
        }

        public final void bMu() {
            AppMethodBeat.m2504i(42591);
            if (LuckyMoneyBusiDetailUI.this.ocC.getVisibility() == 0) {
                LuckyMoneyBusiDetailUI.this.ocC.setVisibility(8);
                AppMethodBeat.m2505o(42591);
                return;
            }
            LuckyMoneyBusiDetailUI.this.mController.ylL.finish();
            AppMethodBeat.m2505o(42591);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$11 */
    class C3447011 implements Runnable {
        C3447011() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42593);
            C18175j.m28619r(LuckyMoneyBusiDetailUI.this);
            AppMethodBeat.m2505o(42593);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$13 */
    class C3447113 implements OnClickListener {
        C3447113() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42595);
            LuckyMoneyBusiDetailUI.this.ocC.setVisibility(0);
            AppMethodBeat.m2505o(42595);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LuckyMoneyBusiDetailUI() {
        AppMethodBeat.m2504i(42597);
        AppMethodBeat.m2505o(42597);
    }

    /* renamed from: e */
    static /* synthetic */ void m56493e(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        AppMethodBeat.m2504i(42614);
        luckyMoneyBusiDetailUI.bMt();
        AppMethodBeat.m2505o(42614);
    }

    /* renamed from: xX */
    static /* synthetic */ int m56500xX(int i) {
        AppMethodBeat.m2504i(42615);
        int xW = LuckyMoneyBusiDetailUI.m56499xW(i);
        AppMethodBeat.m2505o(42615);
        return xW;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42598);
        super.onCreate(bundle);
        this.nSL = (ListView) findViewById(2131825416);
        this.ocO = new C21256i(this.mController.ylL);
        this.abB = LayoutInflater.from(this).inflate(2130969969, null);
        this.nSL.addHeaderView(this.abB);
        this.nSL.setAdapter(this.ocO);
        this.abB.setOnClickListener(new C212187());
        this.nSL.setOnScrollListener(this.nSS);
        this.nSL.setOnItemClickListener(new C212198());
        this.kZq = LayoutInflater.from(this).inflate(2130969968, null);
        this.nSM = (ImageView) this.abB.findViewById(2131825397);
        this.nSN = (TextView) this.abB.findViewById(2131825398);
        this.nsq = (TextView) this.abB.findViewById(2131825399);
        this.nSP = this.abB.findViewById(2131825400);
        this.nSD = (TextView) this.abB.findViewById(2131825401);
        this.nSQ = this.abB.findViewById(2131825402);
        this.kGq = (TextView) this.abB.findViewById(2131825404);
        this.ocD = (ImageView) this.abB.findViewById(2131825403);
        this.kEq = (TextView) this.abB.findViewById(2131825414);
        this.ocE = this.abB.findViewById(2131825405);
        this.ocF = (ImageView) this.abB.findViewById(2131825396);
        ImageView imageView = (ImageView) findViewById(2131825415);
        this.ocC = (LuckyMoneyWishFooter) findViewById(2131825418);
        this.ocC.mo24331a(new C344699());
        this.ocC.setOnWishSendImp(new C1243710());
        this.ocC.post(new C3447011());
        this.ocC.setOnkbdStateListener(new C3446412());
        this.ocO.ohU = new C3447113();
        C21256i c21256i = this.ocO;
        c21256i.ohV = new C21257a();
        this.ocC.setMaxLength(25);
        imageView.setOnClickListener(new C3446514());
        LuckyMoneyBusiDetailUI.fixBackgroundRepeat(findViewById(2131825417));
        this.ocI = getIntent().getStringExtra("key_sendid");
        this.ocK = getIntent().getStringExtra("key_native_url");
        this.ocH = getIntent().getIntExtra("key_jump_from", 2);
        this.ocM = getIntent().getIntExtra("key_static_from_scene", 0);
        C4990ab.m7417i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", this.ocI, this.ocK, Integer.valueOf(this.ocH));
        if (this.ocH == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (byteArrayExtra != null) {
                    C12428k c12428k = (C12428k) new C12428k().parseFrom(byteArrayExtra);
                    if (c12428k != null) {
                        m56485a(c12428k);
                        if (getIntent().getBooleanExtra("play_sound", false)) {
                            C43285k.m77151a(this, C28461a.NOTSET);
                        }
                        AppMethodBeat.m2505o(42598);
                    }
                }
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (C5046bo.isNullOrNil(this.ocI) && !C5046bo.isNullOrNil(this.ocK)) {
            try {
                this.ocI = Uri.parse(this.ocK).getQueryParameter("sendid");
            } catch (Exception e2) {
                C4990ab.m7420w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + e2.getLocalizedMessage());
            }
        }
        if (C5046bo.isNullOrNil(this.ocI)) {
            C4990ab.m7420w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
        } else {
            bMr();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
        }
        AppMethodBeat.m2505o(42598);
    }

    public static void fixBackgroundRepeat(View view) {
        AppMethodBeat.m2504i(42599);
        if (view == null) {
            AppMethodBeat.m2505o(42599);
            return;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            AppMethodBeat.m2505o(42599);
        } else if (background instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
            bitmapDrawable.mutate();
            bitmapDrawable.setTileModeX(TileMode.REPEAT);
            AppMethodBeat.m2505o(42599);
        } else {
            AppMethodBeat.m2505o(42599);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(42600);
        if (keyEvent.getKeyCode() == 4 && this.ocC.getVisibility() == 0) {
            this.ocC.setVisibility(8);
            AppMethodBeat.m2505o(42600);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(42600);
        return dispatchKeyEvent;
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        boolean z = false;
        AppMethodBeat.m2504i(42601);
        if (c1207m instanceof C12425af) {
            if (i == 0 && i2 == 0) {
                C12425af c12425af = (C12425af) c1207m;
                C12428k c12428k = c12425af.nYn;
                this.ocP = c12425af.nYz;
                m56485a(c12428k);
                AppMethodBeat.m2505o(42601);
                return true;
            }
            C30379h.m48465bQ(this, str);
            AppMethodBeat.m2505o(42601);
            return true;
        } else if (c1207m instanceof C36785am) {
            if (i == 0 && i2 == 0) {
                C30379h.m48465bQ(this, getString(C25738R.string.cbn));
                this.ocO.nSz = false;
                bMt();
                C36785am c36785am = (C36785am) c1207m;
                if (this.nSx != null) {
                    while (true) {
                        boolean z2 = z;
                        if (z2 >= this.nSx.size()) {
                            break;
                        }
                        C39323w c39323w = (C39323w) this.nSx.get(z2);
                        if (c39323w.nWX.equalsIgnoreCase(c36785am.nWX)) {
                            c39323w.nYb = c36785am.nSd;
                            this.ocO.notifyDataSetChanged();
                            break;
                        }
                        z = z2 + 1;
                    }
                }
                AppMethodBeat.m2505o(42601);
                return true;
            }
            C30379h.m48465bQ(this, str);
            AppMethodBeat.m2505o(42601);
            return true;
        } else if (!(c1207m instanceof C21198ar)) {
            AppMethodBeat.m2505o(42601);
            return false;
        } else if (i == 0 && i2 == 0) {
            C30379h.m48465bQ(this, getString(C25738R.string.cbn));
            AppMethodBeat.m2505o(42601);
            return true;
        } else {
            C30379h.m48465bQ(this, str);
            AppMethodBeat.m2505o(42601);
            return true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(42602);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        if (this.ocL != null && this.ocL.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            mo24304n(new C21198ar(stringExtra.replaceAll(",", "|"), this.ocI, "v1.0"));
                            break;
                        }
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(42602);
    }

    public void finish() {
        AppMethodBeat.m2504i(42603);
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiDetailUI");
            boolean b = realnameGuideHelper.mo74574b(this, bundle, new C344672());
            getIntent().removeExtra("key_realname_guide_helper");
            if (!b) {
                super.finish();
            }
            AppMethodBeat.m2505o(42603);
            return;
        }
        super.finish();
        AppMethodBeat.m2505o(42603);
    }

    public final int getLayoutId() {
        return 2130969970;
    }

    private void bMr() {
        AppMethodBeat.m2504i(42604);
        this.hZu = true;
        if (this.f15057Lp <= 0 || this.nSx.size() <= 0 || this.nSx.get(this.nSx.size() - 1) == null) {
            this.ocP = "";
            mo24304n(new C12425af(this.ocI, 11, this.f15057Lp, this.ocK, "v1.0", this.ocP));
            AppMethodBeat.m2505o(42604);
            return;
        }
        mo24304n(new C12425af(this.ocI, this.f15057Lp, this.ocK, C5046bo.getLong(((C39323w) this.nSx.get(this.nSx.size() - 1)).nXN, 0), "v1.0", this.ocP));
        AppMethodBeat.m2505o(42604);
    }

    /* renamed from: a */
    private void m56485a(C12428k c12428k) {
        AppMethodBeat.m2504i(42605);
        if (c12428k == null) {
            AppMethodBeat.m2505o(42605);
            return;
        }
        this.ocG = c12428k.nXa == 1;
        if (this.f15057Lp == 0) {
            this.ocJ = c12428k.nWX;
            this.ocO.nSy = this.ocJ;
            this.ocO.nSA = c12428k.nXi;
            m56487b(c12428k);
            m56491d(c12428k);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(LuckyMoneyBusiDetailUI.m56499xW(c12428k.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        }
        m56489c(c12428k);
        LinkedList linkedList = c12428k.nXj;
        if (linkedList != null) {
            for (int i = 0; i < linkedList.size(); i++) {
                C39323w c39323w = (C39323w) linkedList.get(i);
                if (!this.ocN.containsKey(c39323w.nWX)) {
                    this.nSx.add(linkedList.get(i));
                    this.ocN.put(c39323w.nWX, Integer.valueOf(1));
                }
            }
            this.f15057Lp += linkedList.size();
            this.hZu = false;
            this.ocO.mo36628ck(this.nSx);
        }
        m56494eW(c12428k.nXh, c12428k.nXk);
        C7060h.pYm.mo8381e(13051, Integer.valueOf(this.ocM), Integer.valueOf(1), c12428k.nXh, C46063x.m85813cl(c12428k.nXe), "", "", "", "", c12428k.nWQ, Integer.valueOf(c12428k.resourceId));
        AppMethodBeat.m2505o(42605);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARNING: Missing block: B:29:0x00da, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r11.nWR) == false) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m56487b(final C12428k c12428k) {
        AppMethodBeat.m2504i(42606);
        if (c12428k != null) {
            Context context = this.mController.ylL;
            if (c12428k.nXi == 2) {
                this.nSM.setImageResource(C25738R.drawable.b8q);
                if (c12428k.resourceId != 0) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + c12428k.resourceId);
                    final C4883b c26157hq = new C26157hq();
                    c26157hq.cCx.cCz = c12428k.resourceId;
                    c26157hq.callback = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(42585);
                            if (c26157hq.cCy.cCA) {
                                C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + c26157hq.cCy.cCB);
                                C46063x.m85823m(LuckyMoneyBusiDetailUI.this.nSM, c26157hq.cCy.cCB);
                                AppMethodBeat.m2505o(42585);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                            if (!C5046bo.isNullOrNil(c12428k.nWR)) {
                                C46063x.m85811b(LuckyMoneyBusiDetailUI.this.nSM, c12428k.nWR, c12428k.nXl);
                            }
                            AppMethodBeat.m2505o(42585);
                        }
                    };
                    C4879a.xxA.mo10048a(c26157hq, Looper.myLooper());
                }
                C46063x.m85800a(context, this.nSN, c12428k.nWQ);
                C46063x.m85800a(context, this.nsq, c12428k.nSd);
                if (c12428k.cRV == 2 || this.ocH == 3) {
                    this.nSP.setVisibility(8);
                } else {
                    this.nSD.setText(C36391e.m59971F(((double) c12428k.cSh) / 100.0d));
                    if (c12428k.nWY != 1) {
                        this.ocO.nSz = true;
                    } else {
                        this.ocO.nSz = false;
                    }
                    this.nSP.setVisibility(0);
                }
                if (C5046bo.isNullOrNil(c12428k.nUj)) {
                    this.nSQ.setVisibility(0);
                    this.kGq.setText(c12428k.nUj);
                    if (c12428k.nUh == 1) {
                        if (TextUtils.isEmpty(c12428k.nUi) || c12428k.nUi.startsWith("weixin://wxpay")) {
                            this.ocD.setVisibility(8);
                        } else {
                            this.ocD.setVisibility(0);
                        }
                        this.kGq.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(42586);
                                if (TextUtils.isEmpty(c12428k.nUi)) {
                                    C36391e.m59978QS(12);
                                    C35899h.m58862ak(LuckyMoneyBusiDetailUI.this.mController.ylL, 1);
                                    C4990ab.m7412e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
                                    AppMethodBeat.m2505o(42586);
                                    return;
                                }
                                C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + c12428k.nUi);
                                if (c12428k.nUi.startsWith("weixin://wxpay")) {
                                    C36391e.m59978QS(12);
                                    C35899h.m58862ak(LuckyMoneyBusiDetailUI.this.mController.ylL, 1);
                                    AppMethodBeat.m2505o(42586);
                                    return;
                                }
                                C36391e.m59978QS(7);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", c12428k.nUi);
                                C25985d.m41467b(LuckyMoneyBusiDetailUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.m2505o(42586);
                            }
                        });
                    } else {
                        C4990ab.m7412e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                        this.kGq.setTextColor(getResources().getColor(C25738R.color.f12159ud));
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                    this.nSQ.setVisibility(8);
                }
                if (C5046bo.isNullOrNil(c12428k.nXb)) {
                    this.kEq.setText(c12428k.nXb);
                    AppMethodBeat.m2505o(42606);
                    return;
                }
                this.kEq.setText(null);
            }
            C46063x.m85811b(this.nSM, c12428k.nWR, c12428k.nXl);
            C46063x.m85800a(context, this.nSN, c12428k.nWQ);
            C46063x.m85800a(context, this.nsq, c12428k.nSd);
            if (c12428k.cRV == 2) {
            }
            this.nSP.setVisibility(8);
            if (C5046bo.isNullOrNil(c12428k.nUj)) {
            }
            if (C5046bo.isNullOrNil(c12428k.nXb)) {
            }
        }
        AppMethodBeat.m2505o(42606);
    }

    /* renamed from: eW */
    private void m56494eW(String str, String str2) {
        AppMethodBeat.m2504i(42607);
        this.ocF.setImageResource(C25738R.drawable.b8p);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
            this.ocF.setVisibility(8);
            AppMethodBeat.m2505o(42607);
            return;
        }
        bMs();
        C46063x.m85802a(this.ocF, str, str2);
        this.ocF.setVisibility(0);
        AppMethodBeat.m2505o(42607);
    }

    private void bMs() {
        AppMethodBeat.m2504i(42608);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = C4996ah.getContext().getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            AppMethodBeat.m2505o(42608);
            return;
        }
        int dimensionPixelSize = (int) (((float) ((displayMetrics.widthPixels - (getResources().getDimensionPixelSize(C25738R.dimen.a48) * 2)) - (getResources().getDimensionPixelSize(C25738R.dimen.a47) * 2))) * 0.75f);
        LayoutParams layoutParams = this.ocF.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        this.ocF.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(42608);
    }

    /* renamed from: c */
    private void m56489c(final C12428k c12428k) {
        AppMethodBeat.m2504i(42609);
        if (c12428k == null) {
            AppMethodBeat.m2505o(42609);
            return;
        }
        int i;
        int i2 = ((c12428k.cRU == 3 || c12428k.cRU == 2) && c12428k.nWZ == 1 && !this.ocG && c12428k.nXc == 1) ? 1 : 0;
        if (c12428k.nXd == null || c12428k.nXd.erD != 1 || C5046bo.isNullOrNil(c12428k.nXd.nWy)) {
            i = 0;
        } else {
            i = 1;
        }
        TextView textView = (TextView) this.kZq.findViewById(2131825392);
        if (i2 == 0 && i == 0) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(42587);
                    C7060h.pYm.mo8381e(11701, Integer.valueOf(LuckyMoneyBusiDetailUI.m56500xX(c12428k.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                    C46063x.m85805a(LuckyMoneyBusiDetailUI.this, 1, false);
                    AppMethodBeat.m2505o(42587);
                }
            });
            if (i != 0) {
                this.ocL = c12428k.nXd.nWy;
                textView.setText(c12428k.nXd.nWz);
            }
            C7060h.pYm.mo8381e(11701, Integer.valueOf(LuckyMoneyBusiDetailUI.m56499xW(c12428k.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) this.kZq.findViewById(2131825393);
        if (this.ocH == 1 || this.ocH == 3 || textView.getVisibility() == 0) {
            textView2.setVisibility(8);
        } else {
            textView2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(42588);
                    C7060h.pYm.mo8381e(11701, Integer.valueOf(LuckyMoneyBusiDetailUI.m56500xX(c12428k.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                    Intent intent = new Intent();
                    intent.setClass(LuckyMoneyBusiDetailUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
                    intent.putExtra("key_type", 2);
                    LuckyMoneyBusiDetailUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(42588);
                }
            });
            textView2.setVisibility(0);
        }
        if (!this.ocQ) {
            this.nSL.addFooterView(this.kZq);
            this.ocQ = true;
        }
        AppMethodBeat.m2505o(42609);
    }

    /* renamed from: d */
    private void m56491d(C12428k c12428k) {
        AppMethodBeat.m2504i(42610);
        if (c12428k != null) {
            ViewGroup viewGroup;
            LinkedList linkedList = c12428k.nXe;
            if (linkedList != null && linkedList.size() > 0) {
                View findViewById = this.abB.findViewById(2131825406);
                View findViewById2 = this.abB.findViewById(2131825409);
                View findViewById3 = this.abB.findViewById(2131825412);
                viewGroup = (ViewGroup) this.abB.findViewById(2131825407);
                ViewGroup viewGroup2 = (ViewGroup) this.abB.findViewById(2131825410);
                ViewGroup viewGroup3 = (ViewGroup) this.abB.findViewById(2131825413);
                View findViewById4 = this.abB.findViewById(2131825408);
                View findViewById5 = this.abB.findViewById(2131825411);
                C21253c c21253c = new C21253c();
                c21253c.textColor = getResources().getColor(C25738R.color.f12139tr);
                c21253c.ogL = true;
                c21253c.resourceId = c12428k.resourceId;
                c21253c.ogM = this.ocM;
                if (linkedList.size() > 0) {
                    C21249h.m32619a(this, viewGroup, (C43255as) linkedList.get(0), c21253c);
                    findViewById.setVisibility(0);
                }
                if (linkedList.size() > 1) {
                    C21249h.m32619a(this, viewGroup2, (C43255as) linkedList.get(1), c21253c);
                    findViewById2.setVisibility(0);
                }
                if (linkedList.size() > 2) {
                    C21249h.m32619a(this, viewGroup3, (C43255as) linkedList.get(2), c21253c);
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
            viewGroup = (ViewGroup) this.kZq.findViewById(2131825394);
            C21253c c21253c2 = new C21253c();
            c21253c2.textColor = getResources().getColor(C25738R.color.f12139tr);
            c21253c2.textSize = getResources().getDimensionPixelSize(C25738R.dimen.f10016ni);
            C21249h.m32619a(this, viewGroup, c12428k.nXf, c21253c2);
        }
        AppMethodBeat.m2505o(42610);
    }

    private void bMt() {
        AppMethodBeat.m2504i(42611);
        if (!(this.ocC == null || this.ocC.getVisibility() == 8)) {
            this.ocC.setVisibility(8);
        }
        AppMethodBeat.m2505o(42611);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42612);
        super.onDestroy();
        if (this.ocC != null) {
            this.ocC.bMO();
        }
        AppMethodBeat.m2505o(42612);
    }

    /* renamed from: xW */
    private static int m56499xW(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
