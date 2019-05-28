package com.tencent.mm.plugin.card.sharecard.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.x.c;
import java.util.ArrayList;

public class ShareCardListUI extends CardBaseUI implements d, a {
    private long jOE = 0;
    private final long jOF = 500;
    private boolean jOG = false;
    private String kcM = null;
    private b.a kfs = null;
    private boolean khA = false;
    private b kha;
    private f khj;
    private e khk;
    private i khl;
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(ShareCardListUI shareCardListUI) {
        AppMethodBeat.i(88201);
        shareCardListUI.aZt();
        AppMethodBeat.o(88201);
    }

    static /* synthetic */ void e(ShareCardListUI shareCardListUI) {
        AppMethodBeat.i(88202);
        shareCardListUI.bbS();
        AppMethodBeat.o(88202);
    }

    static /* synthetic */ void h(ShareCardListUI shareCardListUI) {
        AppMethodBeat.i(88203);
        shareCardListUI.bbU();
        AppMethodBeat.o(88203);
    }

    static /* synthetic */ void j(ShareCardListUI shareCardListUI) {
        AppMethodBeat.i(88204);
        shareCardListUI.bbO();
        AppMethodBeat.o(88204);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88170);
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.khy = currentTimeMillis;
        initView();
        g.RO().eJo.a(1164, (f) this);
        am.bbd().a((d) this);
        bbW();
        am.bbe().c(this);
        AppMethodBeat.o(88170);
    }

    public void onDestroy() {
        AppMethodBeat.i(88171);
        if (this.khx) {
            aZv();
        }
        this.khj.kha = null;
        this.khk.kha = null;
        this.kha.kfs = null;
        g.RO().eJo.b(1164, (f) this);
        am.bbd().b(this);
        b.bbx();
        am.bbe().d(this);
        long currentTimeMillis = System.currentTimeMillis() - this.khy;
        if (TextUtils.isEmpty(this.kcM)) {
            h.pYm.e(13219, "ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(currentTimeMillis));
        } else {
            h.pYm.e(13219, "ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(currentTimeMillis));
        }
        super.onDestroy();
        AppMethodBeat.o(88171);
    }

    public void onResume() {
        AppMethodBeat.i(88172);
        fG(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG);
            iDKey.SetKey(56);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG);
            iDKey2.SetKey(57);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.pYm.b(arrayList, true);
            this.mStartTime = 0;
        }
        super.onResume();
        AppMethodBeat.o(88172);
    }

    private void fG(boolean z) {
        AppMethodBeat.i(88173);
        ab.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", Boolean.valueOf(this.khn), Boolean.valueOf(z));
        if (this.khn) {
            this.khn = false;
            this.kht = false;
            this.khp = true;
            this.khs = "";
            ab.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
            if (!z) {
                bbU();
            } else if (this.khx && this.khz) {
                aZu();
            }
        }
        bbO();
        AppMethodBeat.o(88173);
    }

    public void onPause() {
        AppMethodBeat.i(88174);
        super.onPause();
        this.khn = false;
        this.kho = true;
        AppMethodBeat.o(88174);
    }

    public final BaseAdapter Kw() {
        AppMethodBeat.i(88175);
        c cVar = new c(this.mController.ylL);
        AppMethodBeat.o(88175);
        return cVar;
    }

    public final void initView() {
        AppMethodBeat.i(88176);
        super.initView();
        ab.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.khx = r0;
        if (this.khx) {
            bbN();
            AppMethodBeat.o(88176);
            return;
        }
        ab.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
        bbT();
        AppMethodBeat.o(88176);
    }

    private void bbN() {
        AppMethodBeat.i(88177);
        ab.d("MicroMsg.ShareCardListUI", "initLocation");
        com.tencent.mm.sdk.g.d.xDH.a(new Runnable() {
            public final void run() {
                AppMethodBeat.i(88166);
                ShareCardListUI.a(ShareCardListUI.this);
                ShareCardListUI.b(ShareCardListUI.this);
                ShareCardListUI.this.khz = true;
                ab.d("MicroMsg.ShareCardListUI", "initLocation end");
                AppMethodBeat.o(88166);
            }
        }, "MicroMsg.ShareCardListUI");
        AppMethodBeat.o(88177);
    }

    public final void aZy() {
        AppMethodBeat.i(88178);
        ab.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.khx);
        if (!this.khx) {
            this.khx = true;
            bbN();
        }
        AppMethodBeat.o(88178);
    }

    public final void aZp() {
        AppMethodBeat.i(88179);
        setMMTitle((int) R.string.ah5);
        this.kha = new b(this);
        this.kfs = new b.a() {
        };
        this.kha.kfs = this.kfs;
        this.kha.init();
        this.khw = b.bbu();
        if (this.khl == null) {
            this.khl = new i(this, this.mController.contentView);
            i iVar = this.khl;
            iVar.khC = View.inflate(iVar.jiE, R.layout.k4, null);
            iVar.khD = (TextView) iVar.khC.findViewById(R.id.aj9);
            iVar.khE = (TextView) iVar.khC.findViewById(R.id.aj_);
            iVar.cu();
        }
        if (this.khj == null) {
            this.khj = new f(this, this.mController.contentView);
            f fVar = this.khj;
            fVar.khe = (ImageView) fVar.jcl.findViewById(R.id.agd);
            fVar.khg = (TextView) fVar.jcl.findViewById(R.id.a_c);
            fVar.khf = (TextView) fVar.jcl.findViewById(R.id.agf);
            this.khj.kha = this.kha;
        }
        if (this.khk == null) {
            this.khk = new e(this);
            this.khk.kha = this.kha;
            this.khk.bbH();
            e eVar = this.khk;
            AnonymousClass3 anonymousClass3 = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(88167);
                    ShareCardListUI.this.kha;
                    if (b.bbw()) {
                        ShareCardListUI.this.kha;
                        if (b.bbv()) {
                            ShareCardListUI.this.khw = 2;
                            h.pYm.e(11582, "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "");
                            am.bbb().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.this.khw));
                            ShareCardListUI.e(ShareCardListUI.this);
                            ShareCardListUI.this.khk.cu();
                            ShareCardListUI.this.kha;
                            b.kft = true;
                            AppMethodBeat.o(88167);
                        }
                    }
                    ShareCardListUI.this.kha;
                    if (b.bbv()) {
                        ShareCardListUI.this.khw = 3;
                    }
                    h.pYm.e(11582, "OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", "");
                    am.bbb().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.this.khw));
                    ShareCardListUI.e(ShareCardListUI.this);
                    ShareCardListUI.this.khk.cu();
                    ShareCardListUI.this.kha;
                    b.kft = true;
                    AppMethodBeat.o(88167);
                }
            };
            if (eVar.kgZ != null) {
                eVar.kgZ.setOnClickListener(anonymousClass3);
            }
        }
        if (this.kap != null) {
            this.kap.addView(this.khl.khC);
        }
        if (this.kaq != null) {
            this.kaq.addView(this.khk.kgZ);
        }
        this.kam.setVisibility(0);
        this.kam.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(88168);
                if (!(absListView.getLastVisiblePosition() != absListView.getCount() - 1 || ShareCardListUI.this.khq || ShareCardListUI.this.khw == 4)) {
                    ab.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
                    ShareCardListUI.h(ShareCardListUI.this);
                }
                AppMethodBeat.o(88168);
            }
        });
        Integer num;
        if (getIntent() == null || !getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)) {
            num = (Integer) g.RP().Ry().get(ac.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, Integer.valueOf(0));
            if (!(num == null || num.intValue() == 1)) {
                g.RP().Ry().set(ac.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, Integer.valueOf(1));
            }
        } else {
            num = (Integer) g.RP().Ry().get(ac.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, Integer.valueOf(0));
            if (num == null || num.intValue() != 1) {
                g.RP().Ry().set(ac.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, Integer.valueOf(1));
                com.tencent.mm.plugin.card.d.d.c(this, R.layout.ka, R.string.ahe, "");
            }
        }
        this.kcM = getIntent().getStringExtra("KEY_CARD_TP_ID");
        this.khs = getIntent().getStringExtra("key_layout_buff");
        if (!bo.isNullOrNil(this.khs)) {
            this.khn = false;
        }
        if (!bo.isNullOrNil(this.kcM)) {
            this.khm = true;
            this.kho = true;
        }
        AppMethodBeat.o(88179);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(88180);
        super.onNewIntent(intent);
        setIntent(intent);
        bbW();
        if (intent != null) {
            this.kcM = intent.getStringExtra("KEY_CARD_TP_ID");
            if (!bo.isNullOrNil(this.kcM)) {
                this.khm = true;
                this.kho = true;
            }
        }
        AppMethodBeat.o(88180);
    }

    private void bbO() {
        AppMethodBeat.i(88181);
        long currentTimeMillis = System.currentTimeMillis() - this.jOE;
        if (!this.jOG || currentTimeMillis >= 1000) {
            ab.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", Boolean.valueOf(this.jOG), Long.valueOf(currentTimeMillis));
            this.jOG = true;
            if (currentTimeMillis < 500) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(88169);
                        ShareCardListUI.this.jOG = false;
                        if (ShareCardListUI.this.isFinishing()) {
                            ab.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
                            AppMethodBeat.o(88169);
                            return;
                        }
                        ShareCardListUI.j(ShareCardListUI.this);
                        AppMethodBeat.o(88169);
                    }
                }, 500);
                AppMethodBeat.o(88181);
                return;
            }
            cu();
            this.jOE = System.currentTimeMillis();
            this.jOG = false;
            AppMethodBeat.o(88181);
            return;
        }
        ab.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
        AppMethodBeat.o(88181);
    }

    private void cu() {
        AppMethodBeat.i(88182);
        bbV();
        ab.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", Integer.valueOf(this.khw), Boolean.valueOf(b.bbw()), Boolean.valueOf(b.bbv()));
        this.khj.cu();
        if (b.bbw() || b.bbv()) {
            this.khk.cu();
            this.khl.cu();
            if (this.khw == 4) {
                bbR();
            }
        } else {
            this.khk.bbM();
            this.khl.bbX();
            bbP();
        }
        bbS();
        AppMethodBeat.o(88182);
    }

    private void bbP() {
        AppMethodBeat.i(88183);
        if (this.kam.getEmptyView() != this.kao) {
            this.kam.setEmptyView(this.kao);
            this.kam.invalidate();
        }
        AppMethodBeat.o(88183);
    }

    private void bbQ() {
        AppMethodBeat.i(88184);
        if (!(b.bbw() || b.bbv())) {
            this.khk.bbJ();
            this.kam.setEmptyView(null);
            this.kam.invalidate();
            this.khA = true;
        }
        AppMethodBeat.o(88184);
    }

    private void bbR() {
        AppMethodBeat.i(88185);
        if (this.kam.getEmptyView() != null) {
            this.kam.setEmptyView(null);
            this.kam.invalidate();
        }
        AppMethodBeat.o(88185);
    }

    private void bbS() {
        AppMethodBeat.i(88186);
        if (this.kan instanceof c) {
            ((c) this.kan).sX(this.khw);
        }
        AppMethodBeat.o(88186);
    }

    public final void aZw() {
        AppMethodBeat.i(88187);
        this.khv = true;
        if (this.kht) {
            ab.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.khx) {
                aZv();
            }
            AppMethodBeat.o(88187);
            return;
        }
        ab.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
        this.kht = true;
        bbT();
        aZv();
        AppMethodBeat.o(88187);
    }

    public final void aZx() {
        AppMethodBeat.i(88188);
        if (this.khu || this.kht) {
            aZv();
            AppMethodBeat.o(88188);
            return;
        }
        this.khu = true;
        ab.i("MicroMsg.ShareCardListUI", "onLocationFail()");
        bbT();
        AppMethodBeat.o(88188);
    }

    private void bbT() {
        AppMethodBeat.i(88189);
        if (b.bby() && b.bbz()) {
            ab.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
            this.khq = true;
            AppMethodBeat.o(88189);
            return;
        }
        if (!(b.bby() && b.bbz())) {
            this.khp = false;
        }
        ab.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        bbU();
        am.bbc().s("", "", 4);
        AppMethodBeat.o(88189);
    }

    private void bbU() {
        AppMethodBeat.i(88190);
        if (this.khr) {
            ab.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
            AppMethodBeat.o(88190);
            return;
        }
        if (!(!bo.isNullOrNil(this.khs) || b.bbw() || b.bbv())) {
            bbQ();
        }
        if (this.khp && !bo.isNullOrNil(this.khs)) {
            this.khs = "";
        }
        this.khr = true;
        g.RO().eJo.a(new com.tencent.mm.plugin.card.sharecard.model.b((double) am.bbc().ecs, (double) am.bbc().ect, this.khs), 0);
        AppMethodBeat.o(88190);
    }

    public final boolean aZr() {
        AppMethodBeat.i(88191);
        boolean aZr = super.aZr();
        AppMethodBeat.o(88191);
        return aZr;
    }

    public final boolean aZs() {
        return false;
    }

    public final void b(com.tencent.mm.plugin.card.base.b bVar, int i) {
        AppMethodBeat.i(88192);
        if (bVar != null) {
            b.GA(bVar.baa());
        }
        super.b(bVar, i);
        AppMethodBeat.o(88192);
    }

    public final void a(com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(88193);
        super.a(bVar);
        AppMethodBeat.o(88193);
    }

    public final void a(com.tencent.mm.plugin.card.base.b bVar, int i) {
        AppMethodBeat.i(88194);
        Intent intent = new Intent(this, CardDetailUI.class);
        ab.i("MicroMsg.ShareCardListUI", "card tp id:" + bVar.baa());
        ab.i("MicroMsg.ShareCardListUI", "card id:" + bVar.aZZ());
        intent.putExtra("key_card_id", am.bbe().GI(bVar.baa()));
        intent.putExtra("key_card_tp_id", bVar.baa());
        intent.putExtra("key_is_share_card", true);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        b.GF(bVar.baa());
        AppMethodBeat.o(88194);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = true;
        AppMethodBeat.i(88195);
        super.onSceneEnd(i, i2, str, mVar);
        if (i != 0 || i2 != 0) {
            if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                if (this.khA) {
                    this.khA = false;
                    this.khk.bbK();
                    this.kam.setEmptyView(this.kao);
                    this.kam.invalidate();
                }
                this.khr = false;
                this.khq = true;
            }
            ab.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        } else if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) mVar;
            this.khr = false;
            this.khs = bVar.kfA;
            this.kha.at(bVar.kdS, this.khp);
            if (!(b.bby() && b.bbz())) {
                this.khp = false;
            }
            if (!(b.bby() && b.bbz())) {
                z = false;
            }
            this.khq = z;
            ab.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
            bbO();
            AppMethodBeat.o(88195);
            return;
        }
        AppMethodBeat.o(88195);
    }

    private void bbV() {
        AppMethodBeat.i(88196);
        if (this.khw == 0 || this.khw == 4 || ((this.khw == 2 && !(b.bbw() && b.bbv())) || ((this.khw == 1 && (!b.bbw() || b.bbv())) || (this.khw == 3 && (!b.bbv() || b.bbw()))))) {
            this.khw = b.bbu();
        }
        am.bbb().putValue("key_share_card_show_type", Integer.valueOf(this.khw));
        AppMethodBeat.o(88196);
    }

    public final void bag() {
        AppMethodBeat.i(88197);
        b.bbt();
        this.khn = true;
        ab.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", Boolean.valueOf(this.kho), Boolean.valueOf(this.kas), Boolean.valueOf(this.khv));
        if (this.kho && this.kas && this.khv) {
            fG(false);
        } else {
            bbO();
        }
        this.kho = false;
        AppMethodBeat.o(88197);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(88198);
        ab.d("MicroMsg.ShareCardListUI", "onNotifyChange");
        this.khn = true;
        AppMethodBeat.o(88198);
    }

    private void bbW() {
        AppMethodBeat.i(88199);
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean bX = c.PK().bX(262152, 266256);
        boolean bY = c.PK().bY(262152, 266256);
        boolean a = c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, ac.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a2 = c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, ac.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        String nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(ac.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, null));
        if (bX) {
            h.pYm.e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88199);
        } else if (bY) {
            h.pYm.e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88199);
        } else if (a && !a2) {
            h.pYm.e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88199);
        } else if (a && a2) {
            h.pYm.e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88199);
        } else if (a2) {
            h.pYm.e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88199);
        } else {
            h.pYm.e(11324, "ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88199);
        }
    }
}
