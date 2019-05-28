package com.tencent.p177mm.plugin.card.sharecard.p354ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.base.C42838d;
import com.tencent.p177mm.plugin.card.base.CardBaseUI;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p355ui.CardDetailUI;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.sharecard.model.C20152b;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.C42862b.C2761a;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.view.C31128d;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI */
public class ShareCardListUI extends CardBaseUI implements C42838d, C4931a {
    private long jOE = 0;
    private final long jOF = 500;
    private boolean jOG = false;
    private String kcM = null;
    private C2761a kfs = null;
    private boolean khA = false;
    private C42856b kha;
    private C27598f khj;
    private C11298e khk;
    private C45791i khl;
    private boolean khm = false;
    private boolean khn = true;
    private boolean kho = false;
    private boolean khp = true;
    private boolean khq = true;
    private boolean khr = false;
    private String khs = "";
    private boolean kht = false;
    private boolean khu = false;
    private boolean khv = false;
    private int khw = 0;
    private boolean khx = false;
    private long khy = 0;
    boolean khz = false;
    private long mStartTime = 0;

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI$3 */
    class C112973 implements OnClickListener {
        C112973() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88167);
            ShareCardListUI.this.kha;
            if (C42856b.bbw()) {
                ShareCardListUI.this.kha;
                if (C42856b.bbv()) {
                    ShareCardListUI.this.khw = 2;
                    C7060h.pYm.mo8381e(11582, "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "");
                    C42852am.bbb().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.this.khw));
                    ShareCardListUI.m43839e(ShareCardListUI.this);
                    ShareCardListUI.this.khk.mo22994cu();
                    ShareCardListUI.this.kha;
                    C42856b.kft = true;
                    AppMethodBeat.m2505o(88167);
                }
            }
            ShareCardListUI.this.kha;
            if (C42856b.bbv()) {
                ShareCardListUI.this.khw = 3;
            }
            C7060h.pYm.mo8381e(11582, "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "");
            C42852am.bbb().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.this.khw));
            ShareCardListUI.m43839e(ShareCardListUI.this);
            ShareCardListUI.this.khk.mo22994cu();
            ShareCardListUI.this.kha;
            C42856b.kft = true;
            AppMethodBeat.m2505o(88167);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI$2 */
    class C275942 implements C2761a {
        C275942() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI$4 */
    class C275954 implements OnScrollListener {
        C275954() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(88168);
            if (!(absListView.getLastVisiblePosition() != absListView.getCount() - 1 || ShareCardListUI.this.khq || ShareCardListUI.this.khw == 4)) {
                C4990ab.m7410d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
                ShareCardListUI.m43843h(ShareCardListUI.this);
            }
            AppMethodBeat.m2505o(88168);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI$5 */
    class C275965 implements Runnable {
        C275965() {
        }

        public final void run() {
            AppMethodBeat.m2504i(88169);
            ShareCardListUI.this.jOG = false;
            if (ShareCardListUI.this.isFinishing()) {
                C4990ab.m7420w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
                AppMethodBeat.m2505o(88169);
                return;
            }
            ShareCardListUI.m43845j(ShareCardListUI.this);
            AppMethodBeat.m2505o(88169);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI$1 */
    class C275971 implements Runnable {
        C275971() {
        }

        public final void run() {
            AppMethodBeat.m2504i(88166);
            ShareCardListUI.m43834a(ShareCardListUI.this);
            ShareCardListUI.m43835b(ShareCardListUI.this);
            ShareCardListUI.this.khz = true;
            C4990ab.m7410d("MicroMsg.ShareCardListUI", "initLocation end");
            AppMethodBeat.m2505o(88166);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m43835b(ShareCardListUI shareCardListUI) {
        AppMethodBeat.m2504i(88201);
        shareCardListUI.aZt();
        AppMethodBeat.m2505o(88201);
    }

    /* renamed from: e */
    static /* synthetic */ void m43839e(ShareCardListUI shareCardListUI) {
        AppMethodBeat.m2504i(88202);
        shareCardListUI.bbS();
        AppMethodBeat.m2505o(88202);
    }

    /* renamed from: h */
    static /* synthetic */ void m43843h(ShareCardListUI shareCardListUI) {
        AppMethodBeat.m2504i(88203);
        shareCardListUI.bbU();
        AppMethodBeat.m2505o(88203);
    }

    /* renamed from: j */
    static /* synthetic */ void m43845j(ShareCardListUI shareCardListUI) {
        AppMethodBeat.m2504i(88204);
        shareCardListUI.bbO();
        AppMethodBeat.m2505o(88204);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88170);
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.khy = currentTimeMillis;
        initView();
        C1720g.m3535RO().eJo.mo14539a(1164, (C1202f) this);
        C42852am.bbd().mo68358a((C42838d) this);
        bbW();
        C42852am.bbe().mo10116c(this);
        AppMethodBeat.m2505o(88170);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88171);
        if (this.khx) {
            aZv();
        }
        this.khj.kha = null;
        this.khk.kha = null;
        this.kha.kfs = null;
        C1720g.m3535RO().eJo.mo14546b(1164, (C1202f) this);
        C42852am.bbd().mo68361b(this);
        C42856b.bbx();
        C42852am.bbe().mo10117d(this);
        long currentTimeMillis = System.currentTimeMillis() - this.khy;
        if (TextUtils.isEmpty(this.kcM)) {
            C7060h.pYm.mo8381e(13219, "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(currentTimeMillis));
        } else {
            C7060h.pYm.mo8381e(13219, "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(currentTimeMillis));
        }
        super.onDestroy();
        AppMethodBeat.m2505o(88171);
    }

    public void onResume() {
        AppMethodBeat.m2504i(88172);
        m43841fG(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey.SetKey(56);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey2.SetKey(57);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            C7060h.pYm.mo8379b(arrayList, true);
            this.mStartTime = 0;
        }
        super.onResume();
        AppMethodBeat.m2505o(88172);
    }

    /* renamed from: fG */
    private void m43841fG(boolean z) {
        AppMethodBeat.m2504i(88173);
        C4990ab.m7417i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", Boolean.valueOf(this.khn), Boolean.valueOf(z));
        if (this.khn) {
            this.khn = false;
            this.kht = false;
            this.khp = true;
            this.khs = "";
            C4990ab.m7410d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
            if (!z) {
                bbU();
            } else if (this.khx && this.khz) {
                aZu();
            }
        }
        bbO();
        AppMethodBeat.m2505o(88173);
    }

    public void onPause() {
        AppMethodBeat.m2504i(88174);
        super.onPause();
        this.khn = false;
        this.kho = true;
        AppMethodBeat.m2505o(88174);
    }

    /* renamed from: Kw */
    public final BaseAdapter mo35412Kw() {
        AppMethodBeat.m2504i(88175);
        C20161c c20161c = new C20161c(this.mController.ylL);
        AppMethodBeat.m2505o(88175);
        return c20161c;
    }

    public final void initView() {
        AppMethodBeat.m2504i(88176);
        super.initView();
        C4990ab.m7417i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.khx = r0;
        if (this.khx) {
            bbN();
            AppMethodBeat.m2505o(88176);
            return;
        }
        C4990ab.m7412e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
        bbT();
        AppMethodBeat.m2505o(88176);
    }

    private void bbN() {
        AppMethodBeat.m2504i(88177);
        C4990ab.m7410d("MicroMsg.ShareCardListUI", "initLocation");
        C7305d.xDH.mo10140a(new C275971(), "MicroMsg.ShareCardListUI");
        AppMethodBeat.m2505o(88177);
    }

    public final void aZy() {
        AppMethodBeat.m2504i(88178);
        C4990ab.m7416i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.khx);
        if (!this.khx) {
            this.khx = true;
            bbN();
        }
        AppMethodBeat.m2505o(88178);
    }

    public final void aZp() {
        AppMethodBeat.m2504i(88179);
        setMMTitle((int) C25738R.string.ah5);
        this.kha = new C42856b(this);
        this.kfs = new C275942();
        this.kha.kfs = this.kfs;
        this.kha.init();
        this.khw = C42856b.bbu();
        if (this.khl == null) {
            this.khl = new C45791i(this, this.mController.contentView);
            C45791i c45791i = this.khl;
            c45791i.khC = View.inflate(c45791i.jiE, 2130968976, null);
            c45791i.khD = (TextView) c45791i.khC.findViewById(2131822293);
            c45791i.khE = (TextView) c45791i.khC.findViewById(2131822294);
            c45791i.mo73587cu();
        }
        if (this.khj == null) {
            this.khj = new C27598f(this, this.mController.contentView);
            C27598f c27598f = this.khj;
            c27598f.khe = (ImageView) c27598f.jcl.findViewById(2131822187);
            c27598f.khg = (TextView) c27598f.jcl.findViewById(2131821927);
            c27598f.khf = (TextView) c27598f.jcl.findViewById(2131822189);
            this.khj.kha = this.kha;
        }
        if (this.khk == null) {
            this.khk = new C11298e(this);
            this.khk.kha = this.kha;
            this.khk.bbH();
            C11298e c11298e = this.khk;
            C112973 c112973 = new C112973();
            if (c11298e.kgZ != null) {
                c11298e.kgZ.setOnClickListener(c112973);
            }
        }
        if (this.kap != null) {
            this.kap.addView(this.khl.khC);
        }
        if (this.kaq != null) {
            this.kaq.addView(this.khk.kgZ);
        }
        this.kam.setVisibility(0);
        this.kam.setOnScrollListener(new C275954());
        Integer num;
        if (getIntent() == null || !getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)) {
            num = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, Integer.valueOf(0));
            if (!(num == null || num.intValue() == 1)) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, Integer.valueOf(1));
            }
        } else {
            num = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, Integer.valueOf(0));
            if (num == null || num.intValue() != 1) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, Integer.valueOf(1));
                C42840d.m76038c(this, 2130968983, C25738R.string.ahe, "");
            }
        }
        this.kcM = getIntent().getStringExtra("KEY_CARD_TP_ID");
        this.khs = getIntent().getStringExtra("key_layout_buff");
        if (!C5046bo.isNullOrNil(this.khs)) {
            this.khn = false;
        }
        if (!C5046bo.isNullOrNil(this.kcM)) {
            this.khm = true;
            this.kho = true;
        }
        AppMethodBeat.m2505o(88179);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(88180);
        super.onNewIntent(intent);
        setIntent(intent);
        bbW();
        if (intent != null) {
            this.kcM = intent.getStringExtra("KEY_CARD_TP_ID");
            if (!C5046bo.isNullOrNil(this.kcM)) {
                this.khm = true;
                this.kho = true;
            }
        }
        AppMethodBeat.m2505o(88180);
    }

    private void bbO() {
        AppMethodBeat.m2504i(88181);
        long currentTimeMillis = System.currentTimeMillis() - this.jOE;
        if (!this.jOG || currentTimeMillis >= 1000) {
            C4990ab.m7411d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", Boolean.valueOf(this.jOG), Long.valueOf(currentTimeMillis));
            this.jOG = true;
            if (currentTimeMillis < 500) {
                C5004al.m7442n(new C275965(), 500);
                AppMethodBeat.m2505o(88181);
                return;
            }
            m43837cu();
            this.jOE = System.currentTimeMillis();
            this.jOG = false;
            AppMethodBeat.m2505o(88181);
            return;
        }
        C4990ab.m7410d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
        AppMethodBeat.m2505o(88181);
    }

    /* renamed from: cu */
    private void m43837cu() {
        AppMethodBeat.m2504i(88182);
        bbV();
        C4990ab.m7417i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", Integer.valueOf(this.khw), Boolean.valueOf(C42856b.bbw()), Boolean.valueOf(C42856b.bbv()));
        this.khj.mo45442cu();
        if (C42856b.bbw() || C42856b.bbv()) {
            this.khk.mo22994cu();
            this.khl.mo73587cu();
            if (this.khw == 4) {
                bbR();
            }
        } else {
            this.khk.bbM();
            this.khl.bbX();
            bbP();
        }
        bbS();
        AppMethodBeat.m2505o(88182);
    }

    private void bbP() {
        AppMethodBeat.m2504i(88183);
        if (this.kam.getEmptyView() != this.kao) {
            this.kam.setEmptyView(this.kao);
            this.kam.invalidate();
        }
        AppMethodBeat.m2505o(88183);
    }

    private void bbQ() {
        AppMethodBeat.m2504i(88184);
        if (!(C42856b.bbw() || C42856b.bbv())) {
            this.khk.bbJ();
            this.kam.setEmptyView(null);
            this.kam.invalidate();
            this.khA = true;
        }
        AppMethodBeat.m2505o(88184);
    }

    private void bbR() {
        AppMethodBeat.m2504i(88185);
        if (this.kam.getEmptyView() != null) {
            this.kam.setEmptyView(null);
            this.kam.invalidate();
        }
        AppMethodBeat.m2505o(88185);
    }

    private void bbS() {
        AppMethodBeat.m2504i(88186);
        if (this.kan instanceof C20161c) {
            ((C20161c) this.kan).mo35406sX(this.khw);
        }
        AppMethodBeat.m2505o(88186);
    }

    public final void aZw() {
        AppMethodBeat.m2504i(88187);
        this.khv = true;
        if (this.kht) {
            C4990ab.m7412e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.khx) {
                aZv();
            }
            AppMethodBeat.m2505o(88187);
            return;
        }
        C4990ab.m7410d("MicroMsg.ShareCardListUI", "onLocationFinish()");
        this.kht = true;
        bbT();
        aZv();
        AppMethodBeat.m2505o(88187);
    }

    public final void aZx() {
        AppMethodBeat.m2504i(88188);
        if (this.khu || this.kht) {
            aZv();
            AppMethodBeat.m2505o(88188);
            return;
        }
        this.khu = true;
        C4990ab.m7416i("MicroMsg.ShareCardListUI", "onLocationFail()");
        bbT();
        AppMethodBeat.m2505o(88188);
    }

    private void bbT() {
        AppMethodBeat.m2504i(88189);
        if (C42856b.bby() && C42856b.bbz()) {
            C4990ab.m7416i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
            this.khq = true;
            AppMethodBeat.m2505o(88189);
            return;
        }
        if (!(C42856b.bby() && C42856b.bbz())) {
            this.khp = false;
        }
        C4990ab.m7416i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        bbU();
        C42852am.bbc().mo15082s("", "", 4);
        AppMethodBeat.m2505o(88189);
    }

    private void bbU() {
        AppMethodBeat.m2504i(88190);
        if (this.khr) {
            C4990ab.m7412e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
            AppMethodBeat.m2505o(88190);
            return;
        }
        if (!(!C5046bo.isNullOrNil(this.khs) || C42856b.bbw() || C42856b.bbv())) {
            bbQ();
        }
        if (this.khp && !C5046bo.isNullOrNil(this.khs)) {
            this.khs = "";
        }
        this.khr = true;
        C1720g.m3535RO().eJo.mo14541a(new C20152b((double) C42852am.bbc().ecs, (double) C42852am.bbc().ect, this.khs), 0);
        AppMethodBeat.m2505o(88190);
    }

    public final boolean aZr() {
        AppMethodBeat.m2504i(88191);
        boolean aZr = super.aZr();
        AppMethodBeat.m2505o(88191);
        return aZr;
    }

    public final boolean aZs() {
        return false;
    }

    /* renamed from: b */
    public final void mo45440b(C42837b c42837b, int i) {
        AppMethodBeat.m2504i(88192);
        if (c42837b != null) {
            C42856b.m76071GA(c42837b.baa());
        }
        super.mo45440b(c42837b, i);
        AppMethodBeat.m2505o(88192);
    }

    /* renamed from: a */
    public final void mo45433a(C42837b c42837b) {
        AppMethodBeat.m2504i(88193);
        super.mo45433a(c42837b);
        AppMethodBeat.m2505o(88193);
    }

    /* renamed from: a */
    public final void mo45434a(C42837b c42837b, int i) {
        AppMethodBeat.m2504i(88194);
        Intent intent = new Intent(this, CardDetailUI.class);
        C4990ab.m7416i("MicroMsg.ShareCardListUI", "card tp id:" + c42837b.baa());
        C4990ab.m7416i("MicroMsg.ShareCardListUI", "card id:" + c42837b.aZZ());
        intent.putExtra("key_card_id", C42852am.bbe().mo35395GI(c42837b.baa()));
        intent.putExtra("key_card_tp_id", c42837b.baa());
        intent.putExtra("key_is_share_card", true);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        C42856b.m76076GF(c42837b.baa());
        AppMethodBeat.m2505o(88194);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = true;
        AppMethodBeat.m2504i(88195);
        super.onSceneEnd(i, i2, str, c1207m);
        if (i != 0 || i2 != 0) {
            if (c1207m instanceof C20152b) {
                if (this.khA) {
                    this.khA = false;
                    this.khk.bbK();
                    this.kam.setEmptyView(this.kao);
                    this.kam.invalidate();
                }
                this.khr = false;
                this.khq = true;
            }
            C4990ab.m7417i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        } else if (c1207m instanceof C20152b) {
            C20152b c20152b = (C20152b) c1207m;
            this.khr = false;
            this.khs = c20152b.kfA;
            this.kha.mo68364at(c20152b.kdS, this.khp);
            if (!(C42856b.bby() && C42856b.bbz())) {
                this.khp = false;
            }
            if (!(C42856b.bby() && C42856b.bbz())) {
                z = false;
            }
            this.khq = z;
            C4990ab.m7416i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
            bbO();
            AppMethodBeat.m2505o(88195);
            return;
        }
        AppMethodBeat.m2505o(88195);
    }

    private void bbV() {
        AppMethodBeat.m2504i(88196);
        if (this.khw == 0 || this.khw == 4 || ((this.khw == 2 && !(C42856b.bbw() && C42856b.bbv())) || ((this.khw == 1 && (!C42856b.bbw() || C42856b.bbv())) || (this.khw == 3 && (!C42856b.bbv() || C42856b.bbw()))))) {
            this.khw = C42856b.bbu();
        }
        C42852am.bbb().putValue("key_share_card_show_type", Integer.valueOf(this.khw));
        AppMethodBeat.m2505o(88196);
    }

    public final void bag() {
        AppMethodBeat.m2504i(88197);
        C42856b.bbt();
        this.khn = true;
        C4990ab.m7417i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", Boolean.valueOf(this.kho), Boolean.valueOf(this.kas), Boolean.valueOf(this.khv));
        if (this.kho && this.kas && this.khv) {
            m43841fG(false);
        } else {
            bbO();
        }
        this.kho = false;
        AppMethodBeat.m2505o(88197);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(88198);
        C4990ab.m7410d("MicroMsg.ShareCardListUI", "onNotifyChange");
        this.khn = true;
        AppMethodBeat.m2505o(88198);
    }

    private void bbW() {
        AppMethodBeat.m2504i(88199);
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean bX = C16112c.m24429PK().mo28551bX(262152, 266256);
        boolean bY = C16112c.m24429PK().mo28552bY(262152, 266256);
        boolean a = C16112c.m24429PK().mo28546a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a2 = C16112c.m24429PK().mo28546a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, null));
        if (bX) {
            C7060h.pYm.mo8381e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88199);
        } else if (bY) {
            C7060h.pYm.mo8381e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88199);
        } else if (a && !a2) {
            C7060h.pYm.mo8381e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88199);
        } else if (a && a2) {
            C7060h.pYm.mo8381e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88199);
        } else if (a2) {
            C7060h.pYm.mo8381e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88199);
        } else {
            C7060h.pYm.mo8381e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88199);
        }
    }
}
