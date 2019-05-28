package com.tencent.mm.plugin.topstory.ui.video;

import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.am;
import android.support.v7.widget.y;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.im;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.plugin.topstory.ui.video.fs.g;
import com.tencent.mm.plugin.topstory.ui.video.list.h;
import com.tencent.mm.plugin.topstory.ui.widget.b;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.t;
import com.tencent.ttpic.util.ActUtil;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TopStoryBaseVideoUI extends MMActivity implements c, b {
    public static final int sDT = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 56);
    protected m eja = new m() {
        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(1719);
            if (TopStoryBaseVideoUI.this.sEf) {
                switch (i) {
                    case 0:
                        if (!TopStoryBaseVideoUI.this.sEt) {
                            TopStoryBaseVideoUI.this.sEa.b(TopStoryBaseVideoUI.this);
                            break;
                        }
                        TopStoryBaseVideoUI.this.sEe.b(TopStoryBaseVideoUI.this);
                        AppMethodBeat.o(1719);
                        return;
                }
                AppMethodBeat.o(1719);
                return;
            }
            AppMethodBeat.o(1719);
        }

        public final void a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.i(1720);
            if (!TopStoryBaseVideoUI.this.sEf || i2 == 0) {
                AppMethodBeat.o(1720);
                return;
            }
            TopStoryBaseVideoUI.this.cGG();
            AppMethodBeat.o(1720);
        }
    };
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
    protected i sDX;
    protected RecyclerView sDY;
    protected e sDZ;
    protected d sEa;
    public RecyclerView sEb;
    protected LinearLayoutManager sEc;
    protected e sEd;
    public d sEe;
    public boolean sEf = true;
    protected int sEg = 0;
    protected long sEh = -1;
    protected long sEi = -1;
    private com.tencent.mm.plugin.topstory.ui.video.i.a sEj = new com.tencent.mm.plugin.topstory.ui.video.i.a() {
        public final void yR(int i) {
            AppMethodBeat.i(1721);
            TopStoryBaseVideoUI.this.FJ(i);
            AppMethodBeat.o(1721);
        }
    };
    protected l sEk;
    public o sEl;
    private m sEm;
    public r sEn;
    protected n sEo;
    private boolean sEp;
    protected b sEq;
    private am sEr;
    private am sEs;
    public boolean sEt;
    private f sEu = new f() {
        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
            AppMethodBeat.i(1726);
            final i iVar = (i) mVar;
            chr chr = (chr) iVar.ehh.fsG.fsP;
            if (i == 0 && i2 == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("docId", chr.wUo);
                    jSONObject.put("opType", "LIKE");
                    jSONObject.put("isLike", chr.nbk == 4);
                } catch (JSONException e) {
                }
                if (iVar.sAX != null) {
                    boolean z;
                    chw chw = iVar.sAX;
                    if (chr.nbk == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    chw.xhh = z;
                }
                ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb:" + iVar.sAX.xhh);
                if (chr.nbk == 4) {
                    View view;
                    h b = TopStoryBaseVideoUI.this.cGa().b(iVar.sAX);
                    if (TopStoryBaseVideoUI.this.sEn.sFv == null || TopStoryBaseVideoUI.this.sEn.sFv.xgS == null || !TopStoryBaseVideoUI.this.sEn.sFv.xgS.equals(iVar.sAX.xgS) || !((b instanceof h) || (b instanceof g))) {
                        view = null;
                    } else {
                        view = b.getWowView();
                    }
                    if (view != null) {
                        TopStoryBaseVideoUI.this.a(iVar.sAX, view, true);
                        if (b instanceof g) {
                            b.cGA().getControlBar().show();
                        }
                    }
                } else {
                    if (iVar.cFw().xgy) {
                        com.tencent.mm.ui.base.h.b(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.getString(R.string.exf), "", true);
                    } else {
                        t.makeText(TopStoryBaseVideoUI.this.mController.ylL, R.string.gab, 0).show();
                    }
                    TopStoryBaseVideoUI.this.a(iVar.sAX, null, false);
                }
                im imVar = new im();
                imVar.cDD.cDE = jSONObject.toString();
                imVar.cDD.cDF = "";
                com.tencent.mm.sdk.b.a.xxA.m(imVar);
            } else {
                ab.w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                t.makeText(TopStoryBaseVideoUI.this.mController.ylL, TopStoryBaseVideoUI.this.getString(R.string.ex8), 0).show();
                if (iVar.sAX != null) {
                    iVar.sAX.xhh = !iVar.sAX.xhh;
                    ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + iVar.sAX.xhh);
                }
            }
            TopStoryBaseVideoUI.this.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(1725);
                    h b = TopStoryBaseVideoUI.this.cGa().b(iVar.sAX);
                    if (b != null) {
                        if (b instanceof h) {
                            b.cGz();
                            AppMethodBeat.o(1725);
                            return;
                        } else if (b instanceof g) {
                            ((com.tencent.mm.plugin.topstory.ui.video.fs.f) b.cGA().getControlBar()).h(iVar.sAX);
                        }
                    }
                    AppMethodBeat.o(1725);
                }
            });
            AppMethodBeat.o(1726);
        }
    };
    private int videoHeight;

    class a extends y {
        private a() {
        }

        /* synthetic */ a(TopStoryBaseVideoUI topStoryBaseVideoUI, byte b) {
            this();
        }

        public final void E(v vVar) {
            AppMethodBeat.i(1729);
            super.E(vVar);
            TopStoryBaseVideoUI.this.cGG();
            TopStoryBaseVideoUI.this.sEa.b(TopStoryBaseVideoUI.this);
            ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", Integer.valueOf(vVar.kj()));
            AppMethodBeat.o(1729);
        }
    }

    public abstract void a(chw chw, View view, boolean z);

    public abstract d cGE();

    public abstract d cGF();

    public abstract e cGJ();

    public abstract e cGK();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Kh();
        cGD();
        com.tencent.mm.kernel.g.Rg().a(2802, this.sEu);
    }

    /* Access modifiers changed, original: protected */
    public void Kh() {
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_context");
        this.sBa = new chv();
        try {
            this.sBa.parseFrom(byteArrayExtra);
        } catch (IOException e) {
            finish();
        }
        this.sEo = new n();
        this.sEo.sDo = this;
        this.sEm = new m();
        this.sEm.d(this);
        this.sEl = new o();
        this.sEl.d(this);
        this.sEn = new r();
        this.sEn.d(this);
        this.sEk = new l();
        this.sEa = cGE();
        this.sEe = cGF();
    }

    private void cGB() {
        getWindow().setFlags(201327616, 201327616);
        View decorView = getWindow().getDecorView();
        if (d.fP(19)) {
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
            getWindow().setStatusBarColor(getResources().getColor(R.color.pi));
        }
        cGB();
        this.qpb = findViewById(R.id.eoj);
        this.gnB = (TextView) findViewById(R.id.qm);
        this.sDW = (ImageView) findViewById(R.id.ewr);
        this.sDU = findViewById(R.id.exp);
        this.sDV = (ImageView) findViewById(R.id.exq);
        this.oOO = (ImageButton) findViewById(R.id.dfp);
        this.oOO.getDrawable().setColorFilter(getResources().getColor(R.color.a69), Mode.SRC_ATOP);
        this.oOO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1717);
                TopStoryBaseVideoUI.this.cGC();
                AppMethodBeat.o(1717);
            }
        });
        this.sDU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1718);
                TopStoryBaseVideoUI topStoryBaseVideoUI = TopStoryBaseVideoUI.this;
                topStoryBaseVideoUI.me(!topStoryBaseVideoUI.sBa.eif);
                topStoryBaseVideoUI.cFO();
                topStoryBaseVideoUI.cFN();
                AppMethodBeat.o(1718);
            }
        });
        this.sDY = (RecyclerView) findViewById(R.id.exm);
        this.sDY.a(this.eja);
        this.sDY.setItemAnimator(new a(this, (byte) 0));
        this.qYS = new LinearLayoutManager();
        this.sDY.setLayoutManager(this.qYS);
        this.sEr = am.e(this.qYS);
        this.sDZ = cGJ();
        this.sDY.setAdapter(this.sDZ);
        this.sEb = (RecyclerView) findViewById(R.id.eyp);
        this.sEb.a(this.eja);
        this.sEb.setItemAnimator(new a(this, (byte) 0));
        this.sEc = new LinearLayoutManager();
        this.sEb.setLayoutManager(this.sEc);
        this.sEs = am.e(this.sEc);
        this.sEd = cGK();
        this.sEb.setAdapter(this.sEd);
        this.sEb.setVisibility(8);
        if (!(this.hVI || cGb())) {
            this.sDX = new i(this);
            this.sDX.enable();
            this.sDX.sEB = this.sEj;
            this.hVI = true;
        }
        if (this.sBa.eif) {
            me(this.sBa.eif);
        }
        this.sEk.sEN = this;
    }

    public final void md(boolean z) {
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", Boolean.valueOf(z));
        this.sEf = z;
    }

    /* Access modifiers changed, original: protected */
    public void cGG() {
        Object obj = null;
        if (this.sEt) {
            this.sEe.a(this);
        } else {
            this.sEa.a(this);
        }
        this.sEg = ((LinearLayoutManager) getLayoutManager()).iS();
        int itemCount = getLayoutManager().getItemCount();
        if (this.sEh <= 0 || bo.az(this.sEh) >= 50) {
            Object obj2;
            this.sEh = bo.yz();
            if (this.sEo.sEZ != 1) {
                if (this.sEg >= itemCount - 1 && !this.sEo.sEY && bo.az(this.sEi) >= 50) {
                    obj2 = 1;
                }
                obj2 = null;
            } else {
                if (itemCount - this.sEg <= 2 && !this.sEo.sEY && bo.az(this.sEi) >= 50) {
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
        this.sEi = bo.yz();
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
        ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
        this.sEn.akW();
        this.sEk.sEO = l.cGO();
        com.tencent.mm.plugin.websearch.api.a.a.kT(14);
    }

    public void onPause() {
        super.onPause();
        try {
            this.sEn.akV();
            ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
        } catch (Exception e) {
        }
        com.tencent.mm.plugin.websearch.api.a.a.kT(15);
    }

    /* Access modifiers changed, original: protected */
    public void FJ(int i) {
    }

    public void onDestroy() {
        com.tencent.mm.plugin.topstory.a.h.a(this.sBa, dyi(), this.sEo.FL(this.sBa.xgL));
        if (this.hVI) {
            this.sDX.disable();
            this.sDX.sEB = null;
            this.sDX = null;
        }
        com.tencent.mm.kernel.g.Rg().b(2802, this.sEu);
        this.sEo.aEX();
        ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.sBa);
        this.sEn.aEX();
        this.sEk.aEX();
        this.sEl.aEX();
        this.sEm.aEX();
        com.tencent.mm.plugin.websearch.api.a.a.kT(16);
        super.onDestroy();
    }

    public void cFN() {
    }

    public void cFO() {
    }

    public final l cFQ() {
        return this.sEk;
    }

    public final o cFR() {
        return this.sEl;
    }

    public final String cFS() {
        return com.tencent.mm.plugin.topstory.a.g.abz(this.sBa.xgj);
    }

    public final chv cFT() {
        return this.sBa;
    }

    public final m cFU() {
        return this.sEm;
    }

    public final r cFV() {
        return this.sEn;
    }

    public final n cGg() {
        return this.sEo;
    }

    public final void me(boolean z) {
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
            this.sDV.setBackgroundResource(R.raw.top_story_volume_off);
        } else {
            this.sDV.setBackgroundResource(R.raw.top_story_volume_on);
        }
        if (this.sEn.sFw) {
            this.sEn.setMute(this.sBa.eif);
        }
    }

    public final boolean DX() {
        return this.sBa.eif;
    }

    public final int cFY() {
        return this.sBa.xgL;
    }

    public final void FD(int i) {
        this.sBa.xgL = i;
    }

    public final void ad(View view, final int i) {
        if (this.sEn.cGZ()) {
            this.sEn.cpN();
            this.sEp = true;
        }
        final chw FL = this.sEo.FL(i);
        this.sEq = new b(this.mController.ylL, FL.xhc, new com.tencent.mm.plugin.topstory.ui.widget.b.a() {
            public final void j(Set<abz> set) {
                AppMethodBeat.i(1722);
                ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
                t.makeText(TopStoryBaseVideoUI.this.mController.ylL, R.string.ex4, 0).show();
                com.tencent.mm.plugin.topstory.a.h.a(TopStoryBaseVideoUI.this.cFT(), FL, (Set) set, TopStoryBaseVideoUI.this.sEo.cGR());
                TopStoryBaseVideoUI.this.sEn.stopPlay();
                TopStoryBaseVideoUI.this.sEo.FK(i);
                if (TopStoryBaseVideoUI.this.sEt) {
                    TopStoryBaseVideoUI.this.sEd.ci(i + TopStoryBaseVideoUI.this.sEd.getHeadersCount());
                    TopStoryBaseVideoUI.this.sDZ.aop.notifyChanged();
                    TopStoryBaseVideoUI.this.sEb.a(0, 3, null);
                    AppMethodBeat.o(1722);
                    return;
                }
                TopStoryBaseVideoUI.this.sDZ.ci(i + TopStoryBaseVideoUI.this.sDZ.getHeadersCount());
                TopStoryBaseVideoUI.this.sEd.aop.notifyChanged();
                AppMethodBeat.o(1722);
            }

            public final void onDismiss() {
                AppMethodBeat.i(1723);
                ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
                if (TopStoryBaseVideoUI.this.sEp) {
                    TopStoryBaseVideoUI.this.sEn.cEf();
                    TopStoryBaseVideoUI.this.sEp = false;
                    if (TopStoryBaseVideoUI.this.sEt) {
                        try {
                            ((com.tencent.mm.plugin.topstory.ui.video.fs.f) TopStoryBaseVideoUI.this.sEn.sFu.getControlBar()).aFE();
                            AppMethodBeat.o(1723);
                            return;
                        } catch (Exception e) {
                        }
                    }
                }
                AppMethodBeat.o(1723);
            }
        });
        if (this.sEt) {
            this.sEq.a(view, true, 0 - com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 40), com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 16));
            try {
                ((com.tencent.mm.plugin.topstory.ui.video.fs.f) this.sEn.sFu.getControlBar()).cHd();
                return;
            } catch (Exception e) {
                return;
            }
        }
        this.sEq.a(view, false, 0, 0 - com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 10));
    }

    public final boolean cFZ() {
        if (this.sBa.scene == 36) {
            return false;
        }
        return true;
    }

    public void i(final List<chw> list, final boolean z) {
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1724);
                if (TopStoryBaseVideoUI.this.sEt) {
                    TopStoryBaseVideoUI.this.sEd.j(list, z);
                    TopStoryBaseVideoUI.this.sDZ.aop.notifyChanged();
                    AppMethodBeat.o(1724);
                    return;
                }
                TopStoryBaseVideoUI.this.sDZ.j(list, z);
                TopStoryBaseVideoUI.this.sEd.aop.notifyChanged();
                AppMethodBeat.o(1724);
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
                ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", Integer.valueOf(this.videoHeight), Integer.valueOf(i));
            } else {
                this.videoHeight = (getVideoWidth() * com.tencent.view.d.MIC_PTU_TRANS_XINXIAN) / com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX;
            }
        }
        return this.videoHeight;
    }

    public final int getVideoWidth() {
        return Math.min(cFW().x, cFW().y);
    }

    public final Point cFW() {
        if (this.qLw == null) {
            this.qLw = ae.hy(this);
        }
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", Integer.valueOf(this.qLw.x), Integer.valueOf(this.qLw.y));
        return this.qLw;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 25 && keyEvent.getAction() == 0) {
            ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", Integer.valueOf(getSystemVolume()));
            chv chv = this.sBa;
            if (getSystemVolume() > 1) {
                z = false;
            }
            chv.eif = z;
            cGL();
        } else if (i == 24 && keyEvent.getAction() == 0) {
            ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", Integer.valueOf(getSystemVolume()));
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

    public final void FE(int i) {
        this.sBa.xgO = i;
    }

    public final void a(chw chw) {
        if (chw == null) {
            return;
        }
        if (at.isConnected(this)) {
            boolean z;
            com.tencent.mm.kernel.g.Rg().a(new i(chw, chw.ubA, chw.xhh ? 5 : 4, System.currentTimeMillis(), this.sBa.scene, this.sBa.hlm, cGb() ? 318 : com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX, chw.xgS, chw.xhi), 0);
            if (chw.xhh) {
                z = false;
            } else {
                z = true;
            }
            chw.xhh = z;
            ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + chw.xhh);
            return;
        }
        Toast.makeText(this.mController.ylL, getString(R.string.ex8), 0).show();
    }

    public final void cGj() {
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1727);
                AnonymousClass8.a(TopStoryBaseVideoUI.this.sDZ);
                AnonymousClass8.a(TopStoryBaseVideoUI.this.sEd);
                AppMethodBeat.o(1727);
            }

            private static void a(e eVar) {
                AppMethodBeat.i(1728);
                int footersCount = eVar.getFootersCount();
                int itemCount = eVar.getItemCount();
                eVar.cGm();
                eVar.au(itemCount - footersCount, footersCount);
                AppMethodBeat.o(1728);
            }
        });
    }

    public void fP(int i, int i2) {
        this.sEn.fT(i, i2);
    }

    public final RecyclerView getRecyclerView() {
        if (this.sEt) {
            return this.sEb;
        }
        return this.sDY;
    }

    public final e cGa() {
        if (this.sEt) {
            return this.sEd;
        }
        return this.sDZ;
    }

    public final am cFX() {
        if (this.sEt) {
            return this.sEs;
        }
        return this.sEr;
    }

    public final RecyclerView.i getLayoutManager() {
        if (this.sEt) {
            return this.sEc;
        }
        return this.qYS;
    }

    private int getSystemVolume() {
        return ((AudioManager) this.mController.ylL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
    }

    private void cGM() {
        com.tencent.mm.compatible.b.a.b((AudioManager) this.mController.ylL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE), 3, 1);
    }

    public final void cGe() {
        if (!this.sEt) {
            this.gnB.setText(R.string.dj7);
            this.sDW.setVisibility(8);
        }
    }
}
