package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.widget.C17487am;
import android.support.p069v7.widget.C31895y;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p219b.C1397a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C42007im;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19486m;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C16681c;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C29431c;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.C46297h;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C35292i;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C35308i.C35309a;
import com.tencent.p177mm.plugin.topstory.p541ui.video.list.C46950h;
import com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs.C22411f;
import com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs.C29454g;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C46312b;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.C46312b.C35321a;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.protocal.protobuf.abz;
import com.tencent.p177mm.protocal.protobuf.chr;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI */
public abstract class TopStoryBaseVideoUI extends MMActivity implements C29431c, C4232b {
    public static final int sDT = C1338a.fromDPToPix(C4996ah.getContext(), 56);
    protected C41530m eja = new C353043();
    protected TextView gnB;
    private boolean hVI = false;
    protected ImageButton oOO;
    private Point qLw;
    protected LinearLayoutManager qYS;
    protected View qpb;
    public chv sBa;
    protected View sDU;
    protected ImageView sDV;
    protected ImageView sDW;
    protected C35308i sDX;
    protected RecyclerView sDY;
    protected C4233e sDZ;
    protected C13954d sEa;
    public RecyclerView sEb;
    protected LinearLayoutManager sEc;
    protected C4233e sEd;
    public C13954d sEe;
    public boolean sEf = true;
    protected int sEg = 0;
    protected long sEh = -1;
    protected long sEi = -1;
    private C35309a sEj = new C42294();
    protected C4239l sEk;
    public C46311o sEl;
    private C13979m sEm;
    public C39996r sEn;
    protected C13986n sEo;
    private boolean sEp;
    protected C46312b sEq;
    private C17487am sEr;
    private C17487am sEs;
    public boolean sEt;
    private C1202f sEu = new C224047();
    private int videoHeight;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI$4 */
    class C42294 implements C35309a {
        C42294() {
        }

        /* renamed from: yR */
        public final void mo9152yR(int i) {
            AppMethodBeat.m2504i(1721);
            TopStoryBaseVideoUI.this.mo74477FJ(i);
            AppMethodBeat.m2505o(1721);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI$a */
    class C4231a extends C31895y {
        private C4231a() {
        }

        /* synthetic */ C4231a(TopStoryBaseVideoUI topStoryBaseVideoUI, byte b) {
            this();
        }

        /* renamed from: E */
        public final void mo9155E(C41531v c41531v) {
            AppMethodBeat.m2504i(1729);
            super.mo9155E(c41531v);
            TopStoryBaseVideoUI.this.cGG();
            TopStoryBaseVideoUI.this.sEa.mo26188b(TopStoryBaseVideoUI.this);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", Integer.valueOf(c41531v.mo66454kj()));
            AppMethodBeat.m2505o(1729);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI$7 */
    class C224047 implements C1202f {
        C224047() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(1726);
            final C35292i c35292i = (C35292i) c1207m;
            chr chr = (chr) c35292i.ehh.fsG.fsP;
            if (i == 0 && i2 == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("docId", chr.wUo);
                    jSONObject.put("opType", "LIKE");
                    jSONObject.put("isLike", chr.nbk == 4);
                } catch (JSONException e) {
                }
                if (c35292i.sAX != null) {
                    boolean z;
                    chw chw = c35292i.sAX;
                    if (chr.nbk == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    chw.xhh = z;
                }
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb:" + c35292i.sAX.xhh);
                if (chr.nbk == 4) {
                    View view;
                    C46927h b = TopStoryBaseVideoUI.this.cGa().mo9200b(c35292i.sAX);
                    if (TopStoryBaseVideoUI.this.sEn.sFv == null || TopStoryBaseVideoUI.this.sEn.sFv.xgS == null || !TopStoryBaseVideoUI.this.sEn.sFv.xgS.equals(c35292i.sAX.xgS) || !((b instanceof C46950h) || (b instanceof C29454g))) {
                        view = null;
                    } else {
                        view = b.getWowView();
                    }
                    if (view != null) {
                        TopStoryBaseVideoUI.this.mo74479a(c35292i.sAX, view, true);
                        if (b instanceof C29454g) {
                            b.cGA().getControlBar().show();
                        }
                    }
                } else {
                    if (c35292i.cFw().xgy) {
                        C30379h.m48461b(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.getString(C25738R.string.exf), "", true);
                    } else {
                        C23639t.makeText(TopStoryBaseVideoUI.this.mController.ylL, C25738R.string.gab, 0).show();
                    }
                    TopStoryBaseVideoUI.this.mo74479a(c35292i.sAX, null, false);
                }
                C42007im c42007im = new C42007im();
                c42007im.cDD.cDE = jSONObject.toString();
                c42007im.cDD.cDF = "";
                C4879a.xxA.mo10055m(c42007im);
            } else {
                C4990ab.m7421w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C23639t.makeText(TopStoryBaseVideoUI.this.mController.ylL, TopStoryBaseVideoUI.this.getString(C25738R.string.ex8), 0).show();
                if (c35292i.sAX != null) {
                    c35292i.sAX.xhh = !c35292i.sAX.xhh;
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + c35292i.sAX.xhh);
                }
            }
            TopStoryBaseVideoUI.this.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(1725);
                    C46927h b = TopStoryBaseVideoUI.this.cGa().mo9200b(c35292i.sAX);
                    if (b != null) {
                        if (b instanceof C46950h) {
                            b.cGz();
                            AppMethodBeat.m2505o(1725);
                            return;
                        } else if (b instanceof C29454g) {
                            ((C22411f) b.cGA().getControlBar()).mo37955h(c35292i.sAX);
                        }
                    }
                    AppMethodBeat.m2505o(1725);
                }
            });
            AppMethodBeat.m2505o(1726);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI$1 */
    class C353031 implements OnClickListener {
        C353031() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1717);
            TopStoryBaseVideoUI.this.cGC();
            AppMethodBeat.m2505o(1717);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI$3 */
    class C353043 extends C41530m {
        C353043() {
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(1719);
            if (TopStoryBaseVideoUI.this.sEf) {
                switch (i) {
                    case 0:
                        if (!TopStoryBaseVideoUI.this.sEt) {
                            TopStoryBaseVideoUI.this.sEa.mo26188b(TopStoryBaseVideoUI.this);
                            break;
                        }
                        TopStoryBaseVideoUI.this.sEe.mo26188b(TopStoryBaseVideoUI.this);
                        AppMethodBeat.m2505o(1719);
                        return;
                }
                AppMethodBeat.m2505o(1719);
                return;
            }
            AppMethodBeat.m2505o(1719);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(1720);
            if (!TopStoryBaseVideoUI.this.sEf || i2 == 0) {
                AppMethodBeat.m2505o(1720);
                return;
            }
            TopStoryBaseVideoUI.this.cGG();
            AppMethodBeat.m2505o(1720);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI$2 */
    class C399732 implements OnClickListener {
        C399732() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1718);
            TopStoryBaseVideoUI topStoryBaseVideoUI = TopStoryBaseVideoUI.this;
            topStoryBaseVideoUI.mo74490me(!topStoryBaseVideoUI.sBa.eif);
            topStoryBaseVideoUI.cFO();
            topStoryBaseVideoUI.cFN();
            AppMethodBeat.m2505o(1718);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI$8 */
    class C463038 implements Runnable {
        C463038() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1727);
            C463038.m86896a(TopStoryBaseVideoUI.this.sDZ);
            C463038.m86896a(TopStoryBaseVideoUI.this.sEd);
            AppMethodBeat.m2505o(1727);
        }

        /* renamed from: a */
        private static void m86896a(C4233e c4233e) {
            AppMethodBeat.m2504i(1728);
            int footersCount = c4233e.getFootersCount();
            int itemCount = c4233e.getItemCount();
            c4233e.cGm();
            c4233e.mo66311au(itemCount - footersCount, footersCount);
            AppMethodBeat.m2505o(1728);
        }
    }

    /* renamed from: a */
    public abstract void mo74479a(chw chw, View view, boolean z);

    public abstract C13954d cGE();

    public abstract C13954d cGF();

    public abstract C4233e cGJ();

    public abstract C4233e cGK();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo74478Kh();
        cGD();
        C1720g.m3540Rg().mo14539a(2802, this.sEu);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Kh */
    public void mo74478Kh() {
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_context");
        this.sBa = new chv();
        try {
            this.sBa.parseFrom(byteArrayExtra);
        } catch (IOException e) {
            finish();
        }
        this.sEo = new C13986n();
        this.sEo.sDo = this;
        this.sEm = new C13979m();
        this.sEm.mo26212d(this);
        this.sEl = new C46311o();
        this.sEl.mo74505d(this);
        this.sEn = new C39996r();
        this.sEn.mo63225d(this);
        this.sEk = new C4239l();
        this.sEa = cGE();
        this.sEe = cGF();
    }

    private void cGB() {
        getWindow().setFlags(201327616, 201327616);
        View decorView = getWindow().getDecorView();
        if (C1443d.m3067fP(19)) {
            decorView.setSystemUiVisibility(2);
        } else {
            decorView.setSystemUiVisibility(4098);
        }
        getWindow().addFlags(128);
    }

    public void onBackPressed() {
        cGC();
    }

    /* Access modifiers changed, original: protected */
    public void cGC() {
    }

    /* Access modifiers changed, original: protected */
    public void cGD() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
            getSupportActionBar().hide();
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(C25738R.color.f12015pi));
        }
        cGB();
        this.qpb = findViewById(2131827963);
        this.gnB = (TextView) findViewById(2131821185);
        this.sDW = (ImageView) findViewById(2131828267);
        this.sDU = findViewById(2131828302);
        this.sDV = (ImageView) findViewById(2131828303);
        this.oOO = (ImageButton) findViewById(2131826267);
        this.oOO.getDrawable().setColorFilter(getResources().getColor(C25738R.color.a69), Mode.SRC_ATOP);
        this.oOO.setOnClickListener(new C353031());
        this.sDU.setOnClickListener(new C399732());
        this.sDY = (RecyclerView) findViewById(2131828299);
        this.sDY.mo66332a(this.eja);
        this.sDY.setItemAnimator(new C4231a(this, (byte) 0));
        this.qYS = new LinearLayoutManager();
        this.sDY.setLayoutManager(this.qYS);
        this.sEr = C17487am.m27242e(this.qYS);
        this.sDZ = cGJ();
        this.sDY.setAdapter(this.sDZ);
        this.sEb = (RecyclerView) findViewById(2131828339);
        this.sEb.mo66332a(this.eja);
        this.sEb.setItemAnimator(new C4231a(this, (byte) 0));
        this.sEc = new LinearLayoutManager();
        this.sEb.setLayoutManager(this.sEc);
        this.sEs = C17487am.m27242e(this.sEc);
        this.sEd = cGK();
        this.sEb.setAdapter(this.sEd);
        this.sEb.setVisibility(8);
        if (!(this.hVI || cGb())) {
            this.sDX = new C35308i(this);
            this.sDX.enable();
            this.sDX.sEB = this.sEj;
            this.hVI = true;
        }
        if (this.sBa.eif) {
            mo74490me(this.sBa.eif);
        }
        this.sEk.sEN = this;
    }

    /* renamed from: md */
    public final void mo74489md(boolean z) {
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", Boolean.valueOf(z));
        this.sEf = z;
    }

    /* Access modifiers changed, original: protected */
    public void cGG() {
        Object obj = null;
        if (this.sEt) {
            this.sEe.mo26186a(this);
        } else {
            this.sEa.mo26186a(this);
        }
        this.sEg = ((LinearLayoutManager) getLayoutManager()).mo1782iS();
        int itemCount = getLayoutManager().getItemCount();
        if (this.sEh <= 0 || C5046bo.m7525az(this.sEh) >= 50) {
            Object obj2;
            this.sEh = C5046bo.m7588yz();
            if (this.sEo.sEZ != 1) {
                if (this.sEg >= itemCount - 1 && !this.sEo.sEY && C5046bo.m7525az(this.sEi) >= 50) {
                    obj2 = 1;
                }
                obj2 = null;
            } else {
                if (itemCount - this.sEg <= 2 && !this.sEo.sEY && C5046bo.m7525az(this.sEi) >= 50) {
                    itemCount = 1;
                }
                obj2 = null;
            }
            if (cGI()) {
                obj = obj2;
            }
            if (obj != null) {
                cGH();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void cGH() {
        this.sEi = C5046bo.m7588yz();
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cGI() {
        if (this.sBa.scene == 36 || this.sBa.xgP) {
            return false;
        }
        return true;
    }

    public final MMActivity bKU() {
        return this;
    }

    public void onResume() {
        super.onResume();
        cGB();
        cGL();
        ((C13943b) C1720g.m3530M(C13943b.class)).onVideoListUIResume();
        this.sEn.akW();
        this.sEk.sEO = C4239l.cGO();
        C14419a.m22633kT(14);
    }

    public void onPause() {
        super.onPause();
        try {
            this.sEn.akV();
            ((C13943b) C1720g.m3530M(C13943b.class)).onVideoListUIPause();
        } catch (Exception e) {
        }
        C14419a.m22633kT(15);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: FJ */
    public void mo74477FJ(int i) {
    }

    public void onDestroy() {
        C46297h.m86862a(this.sBa, dyi(), this.sEo.mo26218FL(this.sBa.xgL));
        if (this.hVI) {
            this.sDX.disable();
            this.sDX.sEB = null;
            this.sDX = null;
        }
        C1720g.m3540Rg().mo14546b(2802, this.sEu);
        this.sEo.aEX();
        ((C13943b) C1720g.m3530M(C13943b.class)).onVideoListUIDestroy(this.sBa);
        this.sEn.aEX();
        this.sEk.aEX();
        this.sEl.aEX();
        this.sEm.aEX();
        C14419a.m22633kT(16);
        super.onDestroy();
    }

    public void cFN() {
    }

    public void cFO() {
    }

    public final C4239l cFQ() {
        return this.sEk;
    }

    public final C46311o cFR() {
        return this.sEl;
    }

    public final String cFS() {
        return C39964g.abz(this.sBa.xgj);
    }

    public final chv cFT() {
        return this.sBa;
    }

    public final C13979m cFU() {
        return this.sEm;
    }

    public final C39996r cFV() {
        return this.sEn;
    }

    public final C13986n cGg() {
        return this.sEo;
    }

    /* renamed from: me */
    public final void mo74490me(boolean z) {
        if (z) {
            this.sBa.eif = true;
        } else {
            this.sBa.eif = false;
            if (getSystemVolume() == 0) {
                cGM();
            }
        }
        cGL();
    }

    private void cGL() {
        if (this.sBa.eif) {
            this.sDV.setBackgroundResource(C1318a.top_story_volume_off);
        } else {
            this.sDV.setBackgroundResource(C1318a.top_story_volume_on);
        }
        if (this.sEn.sFw) {
            this.sEn.setMute(this.sBa.eif);
        }
    }

    /* renamed from: DX */
    public final boolean mo9156DX() {
        return this.sBa.eif;
    }

    public final int cFY() {
        return this.sBa.xgL;
    }

    /* renamed from: FD */
    public final void mo9158FD(int i) {
        this.sBa.xgL = i;
    }

    /* renamed from: ad */
    public final void mo9164ad(View view, final int i) {
        if (this.sEn.cGZ()) {
            this.sEn.cpN();
            this.sEp = true;
        }
        final chw FL = this.sEo.mo26218FL(i);
        this.sEq = new C46312b(this.mController.ylL, FL.xhc, new C35321a() {
            /* renamed from: j */
            public final void mo9153j(Set<abz> set) {
                AppMethodBeat.m2504i(1722);
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
                C23639t.makeText(TopStoryBaseVideoUI.this.mController.ylL, C25738R.string.ex4, 0).show();
                C46297h.m86864a(TopStoryBaseVideoUI.this.cFT(), FL, (Set) set, TopStoryBaseVideoUI.this.sEo.cGR());
                TopStoryBaseVideoUI.this.sEn.stopPlay();
                TopStoryBaseVideoUI.this.sEo.mo26217FK(i);
                if (TopStoryBaseVideoUI.this.sEt) {
                    TopStoryBaseVideoUI.this.sEd.mo66318ci(i + TopStoryBaseVideoUI.this.sEd.getHeadersCount());
                    TopStoryBaseVideoUI.this.sDZ.aop.notifyChanged();
                    TopStoryBaseVideoUI.this.sEb.mo66329a(0, 3, null);
                    AppMethodBeat.m2505o(1722);
                    return;
                }
                TopStoryBaseVideoUI.this.sDZ.mo66318ci(i + TopStoryBaseVideoUI.this.sDZ.getHeadersCount());
                TopStoryBaseVideoUI.this.sEd.aop.notifyChanged();
                AppMethodBeat.m2505o(1722);
            }

            public final void onDismiss() {
                AppMethodBeat.m2504i(1723);
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
                if (TopStoryBaseVideoUI.this.sEp) {
                    TopStoryBaseVideoUI.this.sEn.cEf();
                    TopStoryBaseVideoUI.this.sEp = false;
                    if (TopStoryBaseVideoUI.this.sEt) {
                        try {
                            ((C22411f) TopStoryBaseVideoUI.this.sEn.sFu.getControlBar()).aFE();
                            AppMethodBeat.m2505o(1723);
                            return;
                        } catch (Exception e) {
                        }
                    }
                }
                AppMethodBeat.m2505o(1723);
            }
        });
        if (this.sEt) {
            this.sEq.mo74508a(view, true, 0 - C1338a.fromDPToPix(this.mController.ylL, 40), C1338a.fromDPToPix(this.mController.ylL, 16));
            try {
                ((C22411f) this.sEn.sFu.getControlBar()).cHd();
                return;
            } catch (Exception e) {
                return;
            }
        }
        this.sEq.mo74508a(view, false, 0, 0 - C1338a.fromDPToPix(this.mController.ylL, 10));
    }

    public final boolean cFZ() {
        if (this.sBa.scene == 36) {
            return false;
        }
        return true;
    }

    /* renamed from: i */
    public void mo9194i(final List<chw> list, final boolean z) {
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(1724);
                if (TopStoryBaseVideoUI.this.sEt) {
                    TopStoryBaseVideoUI.this.sEd.mo9205j(list, z);
                    TopStoryBaseVideoUI.this.sDZ.aop.notifyChanged();
                    AppMethodBeat.m2505o(1724);
                    return;
                }
                TopStoryBaseVideoUI.this.sDZ.mo9205j(list, z);
                TopStoryBaseVideoUI.this.sEd.aop.notifyChanged();
                AppMethodBeat.m2505o(1724);
            }
        });
    }

    public void abH(String str) {
    }

    public final boolean cGb() {
        return this.sBa.xgG == 100203;
    }

    public final int getVideoHeight() {
        if (this.videoHeight == 0) {
            if (cGb()) {
                this.videoHeight = ActUtil.HEIGHT;
                int i = (cFW().y * 3) / 5;
                if (this.videoHeight > i) {
                    this.videoHeight = i;
                }
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", Integer.valueOf(this.videoHeight), Integer.valueOf(i));
            } else {
                this.videoHeight = (getVideoWidth() * C31128d.MIC_PTU_TRANS_XINXIAN) / C19486m.CTRL_INDEX;
            }
        }
        return this.videoHeight;
    }

    public final int getVideoWidth() {
        return Math.min(cFW().x, cFW().y);
    }

    public final Point cFW() {
        if (this.qLw == null) {
            this.qLw = C5222ae.m7953hy(this);
        }
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", Integer.valueOf(this.qLw.x), Integer.valueOf(this.qLw.y));
        return this.qLw;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 25 && keyEvent.getAction() == 0) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", Integer.valueOf(getSystemVolume()));
            chv chv = this.sBa;
            if (getSystemVolume() > 1) {
                z = false;
            }
            chv.eif = z;
            cGL();
        } else if (i == 24 && keyEvent.getAction() == 0) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", Integer.valueOf(getSystemVolume()));
            this.sBa.eif = false;
            cGL();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void cGc() {
        cGB();
    }

    public final int cGd() {
        return sDT;
    }

    public final boolean isFullscreenMode() {
        return this.sEt;
    }

    public final String cGh() {
        return this.sBa.xgN == null ? "" : this.sBa.xgN;
    }

    public final void abI(String str) {
        this.sBa.xgN = str;
    }

    public final int cGi() {
        return this.sBa.xgO;
    }

    /* renamed from: FE */
    public final void mo9159FE(int i) {
        this.sBa.xgO = i;
    }

    /* renamed from: a */
    public final void mo9161a(chw chw) {
        if (chw == null) {
            return;
        }
        if (C5023at.isConnected(this)) {
            boolean z;
            C1720g.m3540Rg().mo14541a(new C35292i(chw, chw.ubA, chw.xhh ? 5 : 4, System.currentTimeMillis(), this.sBa.scene, this.sBa.hlm, cGb() ? 318 : C16681c.CTRL_INDEX, chw.xgS, chw.xhi), 0);
            if (chw.xhh) {
                z = false;
            } else {
                z = true;
            }
            chw.xhh = z;
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + chw.xhh);
            return;
        }
        Toast.makeText(this.mController.ylL, getString(C25738R.string.ex8), 0).show();
    }

    public final void cGj() {
        runOnUiThread(new C463038());
    }

    /* renamed from: fP */
    public void mo47665fP(int i, int i2) {
        this.sEn.mo63226fT(i, i2);
    }

    public final RecyclerView getRecyclerView() {
        if (this.sEt) {
            return this.sEb;
        }
        return this.sDY;
    }

    public final C4233e cGa() {
        if (this.sEt) {
            return this.sEd;
        }
        return this.sDZ;
    }

    public final C17487am cFX() {
        if (this.sEt) {
            return this.sEs;
        }
        return this.sEr;
    }

    public final C17480i getLayoutManager() {
        if (this.sEt) {
            return this.sEc;
        }
        return this.qYS;
    }

    private int getSystemVolume() {
        return ((AudioManager) this.mController.ylL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
    }

    private void cGM() {
        C1397a.m2944b((AudioManager) this.mController.ylL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE), 3, 1);
    }

    public final void cGe() {
        if (!this.sEt) {
            this.gnB.setText(C25738R.string.dj7);
            this.sDW.setVisibility(8);
        }
    }
}
