package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.am;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.im;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.t;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.ActUtil;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class TopStoryFSVideoUI extends MMActivity implements c, b {
    private static long sGE = 0;
    protected m eja = new m() {
        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(1968);
            switch (i) {
                case 0:
                    TopStoryFSVideoUI.this.sGt.b(TopStoryFSVideoUI.this);
                    break;
            }
            AppMethodBeat.o(1968);
        }

        public final void a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.i(1969);
            if (i2 == 0) {
                AppMethodBeat.o(1969);
                return;
            }
            TopStoryFSVideoUI.this.cGG();
            AppMethodBeat.o(1969);
        }
    };
    protected ImageButton oOO;
    private Point qLw;
    protected LinearLayoutManager qYS;
    protected View qpb;
    protected chv sBa;
    protected View sDU;
    protected ImageView sDV;
    protected RecyclerView sDY;
    protected int sEg = 0;
    protected long sEh = -1;
    protected long sEi = -1;
    private l sEk;
    private o sEl;
    private com.tencent.mm.plugin.topstory.ui.video.m sEm;
    r sEn;
    n sEo;
    private boolean sEp;
    protected com.tencent.mm.plugin.topstory.ui.widget.b sEq;
    private am sEr;
    private f sEu = new f() {
        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
            AppMethodBeat.i(1957);
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
                ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb:" + iVar.sAX.xhh);
                if (chr.nbk == 4) {
                    View view;
                    h b = TopStoryFSVideoUI.this.cGa().b(iVar.sAX);
                    if (TopStoryFSVideoUI.this.sEn.sFv == null || TopStoryFSVideoUI.this.sEn.sFv.xgS == null || !TopStoryFSVideoUI.this.sEn.sFv.xgS.equals(iVar.sAX.xgS) || !(b instanceof g)) {
                        view = null;
                    } else {
                        view = b.getWowView();
                    }
                    if (view != null) {
                        TopStoryFSVideoUI.this.a(iVar.sAX, view, true);
                        if (b instanceof g) {
                            b.cGA().getControlBar().show();
                        }
                    }
                } else {
                    if (iVar.cFw().xgy) {
                        com.tencent.mm.ui.base.h.b(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(R.string.exf), "", true);
                    } else {
                        t.makeText(TopStoryFSVideoUI.this.mController.ylL, R.string.gab, 0).show();
                    }
                    TopStoryFSVideoUI.this.a(iVar.sAX, null, false);
                }
                im imVar = new im();
                imVar.cDD.cDE = jSONObject.toString();
                imVar.cDD.cDF = "";
                a.xxA.m(imVar);
            } else {
                ab.w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                t.makeText(TopStoryFSVideoUI.this.mController.ylL, TopStoryFSVideoUI.this.getString(R.string.ex8), 0).show();
                if (iVar.sAX != null) {
                    iVar.sAX.xhh = !iVar.sAX.xhh;
                    ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + iVar.sAX.xhh);
                }
            }
            TopStoryFSVideoUI.this.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(1956);
                    h b = TopStoryFSVideoUI.this.cGa().b(iVar.sAX);
                    if (b != null && (b instanceof g)) {
                        ((f) b.cGA().getControlBar()).h(iVar.sAX);
                    }
                    AppMethodBeat.o(1956);
                }
            });
            AppMethodBeat.o(1957);
        }
    };
    com.tencent.mm.plugin.topstory.ui.widget.c sGA;
    View sGB;
    TopStoryCommentFloatDialog sGC;
    private boolean sGD;
    protected i sGs;
    protected h sGt;
    private ProgressDialog sGu;
    private View sGv;
    private View sGw;
    private View sGx;
    private Button sGy;
    View sGz;
    private int videoHeight;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TopStoryFSVideoUI() {
        AppMethodBeat.i(1970);
        AppMethodBeat.o(1970);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(1971);
        if (VERSION.SDK_INT >= 28) {
            this.ylm = true;
        }
        super.onCreate(bundle);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_context");
        this.sBa = new chv();
        try {
            this.sBa.parseFrom(byteArrayExtra);
        } catch (IOException e) {
            finish();
        }
        this.sEo = new n();
        this.sEo.sDo = this;
        this.sEm = new com.tencent.mm.plugin.topstory.ui.video.m();
        this.sEm.d(this);
        this.sEl = new o();
        this.sEl.d(this);
        this.sEn = new r();
        this.sEn.d(this);
        this.sEk = new l();
        this.sGt = new h();
        if (this.sBa.xgH != null) {
            this.sEo.d(this.sBa.xgH);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
            getSupportActionBar().hide();
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pi));
        }
        if (this.sBa.xgJ) {
            this.sEk.sEM = true;
        }
        cGB();
        this.qpb = findViewById(R.id.eoj);
        this.sDU = findViewById(R.id.exp);
        this.sDV = (ImageView) findViewById(R.id.exq);
        this.oOO = (ImageButton) findViewById(R.id.dfp);
        this.oOO.getDrawable().setColorFilter(getResources().getColor(R.color.a69), Mode.SRC_ATOP);
        this.oOO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1951);
                TopStoryFSVideoUI.a(TopStoryFSVideoUI.this);
                AppMethodBeat.o(1951);
            }
        });
        this.sDU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1963);
                TopStoryFSVideoUI.this.cHh();
                AppMethodBeat.o(1963);
            }
        });
        this.sGx = findViewById(R.id.exn);
        this.sGy = (Button) findViewById(R.id.exo);
        this.sDY = (RecyclerView) findViewById(R.id.exm);
        this.sDY.a(this.eja);
        this.qYS = new LinearLayoutManager();
        this.sDY.setLayoutManager(this.qYS);
        this.sEr = am.e(this.qYS);
        this.sGs = new i(this);
        i iVar = this.sGs;
        View inflate = LayoutInflater.from(this).inflate(R.layout.b0i, null);
        inflate.setLayoutParams(new LayoutParams(-1, -1));
        this.sGw = inflate.findViewById(R.id.eyo);
        this.sGv = inflate.findViewById(R.id.byu);
        iVar.ei(inflate);
        this.sDY.setAdapter(this.sGs);
        this.oOO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1964);
                TopStoryFSVideoUI.this.finish();
                AppMethodBeat.o(1964);
            }
        });
        new b().i(this.sDY);
        if (!cGI()) {
            this.sGw.setVisibility(4);
            this.sGv.setVisibility(4);
        } else if (this.sEk.isConnected()) {
            cHg();
            this.sGD = false;
            if (this.sBa.scene != 21 && this.sBa.xgI == null) {
                this.sGu = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.cn5), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(1965);
                        TopStoryFSVideoUI.this.finish();
                        AppMethodBeat.o(1965);
                    }
                });
            }
        } else {
            Toast.makeText(this, R.string.dj3, 1).show();
            this.sGD = true;
        }
        this.sGs.sGI = true;
        this.sGx.setVisibility(8);
        if (this.sEk.cGN() && g.cFp() && System.currentTimeMillis() - sGE > 86400000) {
            Toast.makeText(this, R.string.exc, 0).show();
            sGE = System.currentTimeMillis();
        }
        this.sGz = findViewById(R.id.exr);
        this.sGB = findViewById(R.id.exs);
        this.sGz.setVisibility(8);
        this.sGz.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(1966);
                if (TopStoryFSVideoUI.this.sGz.getVisibility() == 0) {
                    if (TopStoryFSVideoUI.f(TopStoryFSVideoUI.this.sGB, motionEvent.getX(), motionEvent.getY())) {
                        ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "touch in mContentViewNotFull");
                        AppMethodBeat.o(1966);
                        return false;
                    }
                    TopStoryFSVideoUI.this.sGz.setVisibility(8);
                }
                AppMethodBeat.o(1966);
                return false;
            }
        });
        this.sGC = (TopStoryCommentFloatDialog) findViewById(R.id.ext);
        this.sGC.setVisibility(8);
        this.sGC.k(this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
            public final void onSystemUiVisibilityChange(int i) {
                AppMethodBeat.i(1967);
                TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
                AppMethodBeat.o(1967);
            }
        });
        com.tencent.mm.kernel.g.Rg().a(2802, this.sEu);
        AppMethodBeat.o(1971);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cGG() {
        int i = 1;
        AppMethodBeat.i(1972);
        this.sGt.a(this);
        this.sEg = this.qYS.iS();
        int itemCount = this.qYS.getItemCount();
        if (this.sEh <= 0 || bo.az(this.sEh) >= 50) {
            this.sEh = bo.yz();
            if (this.sEo.sEZ == 1 ? itemCount - this.sEg > 2 || this.sEo.sEY || bo.az(this.sEi) < 50 : this.sEg < itemCount - 1 || this.sEo.sEY || bo.az(this.sEi) < 50) {
                i = 0;
            }
            if (!cGI()) {
                i = 0;
            }
            if (i != 0) {
                this.sGw.setVisibility(0);
                this.sGv.setVisibility(0);
                this.sEo.FM(this.sEo.cGR());
            }
        }
        AppMethodBeat.o(1972);
    }

    private boolean cGI() {
        if (this.sBa.scene == 36 || this.sBa.xgP) {
            return false;
        }
        return true;
    }

    private void cGB() {
        AppMethodBeat.i(1973);
        getWindow().setFlags(201327616, 201327616);
        View decorView = getWindow().getDecorView();
        if (d.fP(19)) {
            decorView.setSystemUiVisibility(2);
        } else {
            decorView.setSystemUiVisibility(4102);
        }
        getWindow().addFlags(128);
        AppMethodBeat.o(1973);
    }

    public final void cFN() {
        AppMethodBeat.i(1974);
        this.qpb.animate().alpha(0.0f).setDuration(200).setStartDelay(1800);
        this.sGz.setVisibility(8);
        AppMethodBeat.o(1974);
    }

    public final void cFO() {
        AppMethodBeat.i(1975);
        this.qpb.animate().cancel();
        this.qpb.setAlpha(1.0f);
        AppMethodBeat.o(1975);
    }

    public final boolean FC(int i) {
        AppMethodBeat.i(1976);
        this.sGz.setVisibility(8);
        ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", Integer.valueOf(i));
        try {
            if (i >= (this.sGs.getItemCount() - this.sGs.getFootersCount()) - this.sGs.getHeadersCount()) {
                AppMethodBeat.o(1976);
                return false;
            }
            this.sDY.smoothScrollToPosition(this.sGs.getHeadersCount() + i);
            AppMethodBeat.o(1976);
            return true;
        } catch (Exception e) {
            ab.w("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo Exception:%s", e.getMessage());
            AppMethodBeat.o(1976);
            return false;
        }
    }

    public final int getLayoutId() {
        return R.layout.b07;
    }

    public final void cGe() {
    }

    public final void cGf() {
    }

    public final void a(bzs bzs) {
    }

    public final boolean fS(int i, int i2) {
        return true;
    }

    public final int getForceOrientation() {
        AppMethodBeat.i(1977);
        if (cGb()) {
            AppMethodBeat.o(1977);
            return 1;
        }
        AppMethodBeat.o(1977);
        return 0;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(1978);
        p.sFq.a(this, i, i2, intent);
        if (i == 10001 && (this.sEk.bkJ() || g.cFp())) {
            h c = com.tencent.mm.plugin.topstory.ui.video.d.c(this);
            if (c != null) {
                c.mc(false);
            }
        }
        AppMethodBeat.o(1978);
    }

    private void cHg() {
        AppMethodBeat.i(1979);
        this.sGw.setVisibility(0);
        this.sGv.setVisibility(0);
        this.sEo.FM(0);
        AppMethodBeat.o(1979);
    }

    public final l cFQ() {
        return this.sEk;
    }

    public final o cFR() {
        return this.sEl;
    }

    public final String cFS() {
        AppMethodBeat.i(1980);
        String abz = g.abz(this.sBa.xgj);
        AppMethodBeat.o(1980);
        return abz;
    }

    public final chv cFT() {
        return this.sBa;
    }

    public final com.tencent.mm.plugin.topstory.ui.video.m cFU() {
        return this.sEm;
    }

    public final r cFV() {
        return this.sEn;
    }

    public final n cGg() {
        return this.sEo;
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

    public final boolean cGb() {
        return this.sBa.xgG == 100203;
    }

    public final int getVideoHeight() {
        int i;
        AppMethodBeat.i(1981);
        if (this.videoHeight == 0) {
            if (cGb()) {
                this.videoHeight = ActUtil.HEIGHT;
                i = (cFW().y * 3) / 5;
                if (this.videoHeight > i) {
                    this.videoHeight = i;
                }
                ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", Integer.valueOf(this.videoHeight), Integer.valueOf(i));
            } else {
                this.videoHeight = (getVideoWidth() * com.tencent.view.d.MIC_PTU_TRANS_XINXIAN) / com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX;
            }
        }
        i = this.videoHeight;
        AppMethodBeat.o(1981);
        return i;
    }

    public final int getVideoWidth() {
        AppMethodBeat.i(Exif.PARSE_EXIF_ERROR_NO_JPEG);
        int min = Math.min(cFW().x, cFW().y);
        AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_NO_JPEG);
        return min;
    }

    public final Point cFW() {
        AppMethodBeat.i(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        if (this.qLw == null) {
            this.qLw = ae.hy(this);
        }
        Point point = this.qLw;
        AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        return point;
    }

    public final am cFX() {
        return this.sEr;
    }

    public final RecyclerView.i getLayoutManager() {
        return this.qYS;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        AppMethodBeat.i(Exif.PARSE_EXIF_ERROR_CORRUPT);
        if (i == 4 && this.sGC.getVisibility() == 0) {
            this.sGC.hide();
            AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_CORRUPT);
            return true;
        }
        if (i == 25 && keyEvent.getAction() == 0) {
            ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", Integer.valueOf(getSystemVolume()));
            chv chv = this.sBa;
            if (getSystemVolume() > 1) {
                z = false;
            }
            chv.eif = z;
            cGL();
        } else if (i == 24 && keyEvent.getAction() == 0) {
            ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", Integer.valueOf(getSystemVolume()));
            this.sBa.eif = false;
            cGL();
        }
        z = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_CORRUPT);
        return z;
    }

    @SuppressLint({"ResourceType"})
    private void cGL() {
        AppMethodBeat.i(1987);
        if (this.sBa.eif) {
            this.sDV.setBackgroundResource(R.raw.top_story_volume_off);
        } else {
            this.sDV.setBackgroundResource(R.raw.top_story_volume_on);
        }
        if (this.sEn.sFw) {
            this.sEn.setMute(this.sBa.eif);
        }
        AppMethodBeat.o(1987);
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

    public final boolean cFZ() {
        if (this.sBa.scene == 36) {
            return false;
        }
        return true;
    }

    public final e cGa() {
        return this.sGs;
    }

    public final void i(List<chw> list, boolean z) {
        AppMethodBeat.i(1989);
        this.sGs.j(list, z);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1954);
                TopStoryFSVideoUI.this.sGw.setVisibility(4);
                TopStoryFSVideoUI.this.sGv.setVisibility(4);
                TopStoryFSVideoUI.this.sDY.a(0, 3, null);
                if (TopStoryFSVideoUI.this.sGu != null) {
                    TopStoryFSVideoUI.this.sGu.dismiss();
                    TopStoryFSVideoUI.this.sGu = null;
                }
                AppMethodBeat.o(1954);
            }
        }, 50);
        AppMethodBeat.o(1989);
    }

    public final void abH(final String str) {
        AppMethodBeat.i(1990);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1955);
                TopStoryFSVideoUI.this.sGw.setVisibility(4);
                TopStoryFSVideoUI.this.sGv.setVisibility(4);
                if (TopStoryFSVideoUI.this.sGu != null) {
                    TopStoryFSVideoUI.this.sGu.dismiss();
                    TopStoryFSVideoUI.this.sGu = null;
                }
                TopStoryFSVideoUI.a(TopStoryFSVideoUI.this, str);
                AppMethodBeat.o(1955);
            }
        });
        AppMethodBeat.o(1990);
    }

    public final boolean isFullscreenMode() {
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.i(1991);
        com.tencent.mm.plugin.topstory.a.h.a(this.sBa, dyi(), this.sEo.FL(this.sBa.xgL));
        com.tencent.mm.kernel.g.Rg().b(2802, this.sEu);
        this.sEo.aEX();
        ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.sBa);
        this.sEn.aEX();
        this.sEk.aEX();
        this.sEl.aEX();
        this.sEm.aEX();
        this.sGC.sIl.close();
        com.tencent.mm.plugin.websearch.api.a.a.kT(16);
        super.onDestroy();
        AppMethodBeat.o(1991);
    }

    public void onResume() {
        AppMethodBeat.i(1992);
        super.onResume();
        cGB();
        cGL();
        ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
        this.sEn.akW();
        this.sEk.sEO = l.cGO();
        this.sGC.onResume();
        com.tencent.mm.plugin.websearch.api.a.a.kT(14);
        AppMethodBeat.o(1992);
    }

    public void onPause() {
        AppMethodBeat.i(1993);
        super.onPause();
        this.sEn.akV();
        ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
        this.sGC.onPause();
        com.tencent.mm.plugin.websearch.api.a.a.kT(15);
        AppMethodBeat.o(1993);
    }

    public final RecyclerView getRecyclerView() {
        return this.sDY;
    }

    public final void fP(int i, int i2) {
        AppMethodBeat.i(1994);
        if ((i2 == 2 || i2 == 1) && this.sGD) {
            cHg();
        }
        this.sEn.fT(i, i2);
        AppMethodBeat.o(1994);
    }

    public final MMActivity bKU() {
        return this;
    }

    public final void cGc() {
        AppMethodBeat.i(1995);
        cGB();
        AppMethodBeat.o(1995);
    }

    public final int cGd() {
        return 0;
    }

    public final void a(chw chw) {
        AppMethodBeat.i(1996);
        if (chw != null) {
            if (at.isConnected(this)) {
                boolean z;
                com.tencent.mm.kernel.g.Rg().a(new i(chw, chw.ubA, chw.xhh ? 5 : 4, System.currentTimeMillis(), this.sBa.scene, this.sBa.hlm, cGb() ? 318 : com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX, chw.xgS, chw.xhi), 0);
                if (chw.xhh) {
                    z = false;
                } else {
                    z = true;
                }
                chw.xhh = z;
                ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + chw.xhh);
            } else {
                Toast.makeText(this.mController.ylL, getString(R.string.ex8), 0).show();
                AppMethodBeat.o(1996);
                return;
            }
        }
        AppMethodBeat.o(1996);
    }

    public final void cGj() {
        AppMethodBeat.i(1997);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1958);
                i iVar = TopStoryFSVideoUI.this.sGs;
                int footersCount = iVar.getFootersCount();
                int itemCount = iVar.getItemCount();
                iVar.cGm();
                iVar.au(itemCount - footersCount, footersCount);
                AppMethodBeat.o(1958);
            }
        });
        AppMethodBeat.o(1997);
    }

    public final int cGk() {
        AppMethodBeat.i(1998);
        int a = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_topstory_v_video_play, 0);
        AppMethodBeat.o(1998);
        return a;
    }

    public final void a(final chw chw, View view, boolean z) {
        AppMethodBeat.i(1999);
        ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", chw.xgS, Boolean.valueOf(z));
        if (z) {
            com.tencent.mm.plugin.topstory.a.c.f fVar = new com.tencent.mm.plugin.topstory.a.c.f(System.currentTimeMillis(), chw.ubA, "", "", "", "", chw.title, this.sBa.hlm, this.sBa.scene, cGb() ? 318 : com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX, chw.xgS, chw.xhi);
            this.sGz.setVisibility(0);
            this.sGA = new com.tencent.mm.plugin.topstory.ui.widget.c(this.sGB, new com.tencent.mm.plugin.topstory.ui.widget.c.a() {
                public final void a(com.tencent.mm.plugin.topstory.a.c.f fVar) {
                    AppMethodBeat.i(1961);
                    TopStoryFSVideoUI.this.sGC.a(fVar, new TopStoryCommentFloatDialog.a() {
                        public final void onDismiss() {
                            AppMethodBeat.i(1959);
                            TopStoryFSVideoUI.this.sEn.cEf();
                            TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
                            AppMethodBeat.o(1959);
                        }

                        public final void cHi() {
                            AppMethodBeat.i(1960);
                            TopStoryFSVideoUI.this.sGz.setVisibility(8);
                            AppMethodBeat.o(1960);
                        }
                    }, (int) TopStoryFSVideoUI.this.sBa.xgG, chw.xgW);
                    if (TopStoryFSVideoUI.this.sEn.cGZ()) {
                        TopStoryFSVideoUI.this.sEn.cpN();
                    }
                    AppMethodBeat.o(1961);
                }
            }, fVar, chw.xgS);
            this.sGz.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(1962);
                    if (TopStoryFSVideoUI.this.sGz.getVisibility() == 0) {
                        TopStoryFSVideoUI.this.sGz.setVisibility(8);
                    }
                    AppMethodBeat.o(1962);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            this.sGA.a(view, true, com.tencent.mm.plugin.topstory.ui.widget.f.dip2px(this, 10.0f));
            AppMethodBeat.o(1999);
            return;
        }
        if (this.sGz.getVisibility() == 0 && this.sGA != null && this.sGA.fgd != null && this.sGA.fgd.equals(chw.xgS)) {
            this.sGz.setVisibility(8);
        }
        AppMethodBeat.o(1999);
    }

    private int getSystemVolume() {
        AppMethodBeat.i(Exif.PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN);
        int streamVolume = ((AudioManager) this.mController.ylL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
        AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN);
        return streamVolume;
    }

    public final void cHh() {
        AppMethodBeat.i(1986);
        if (this.sBa.eif) {
            this.sBa.eif = false;
            if (getSystemVolume() == 0) {
                com.tencent.mm.compatible.b.a.b((AudioManager) this.mController.ylL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE), 3, 1);
            }
        } else {
            this.sBa.eif = true;
        }
        cGL();
        cFO();
        cFN();
        AppMethodBeat.o(1986);
    }

    public final void ad(View view, final int i) {
        AppMethodBeat.i(1988);
        if (this.sEn.cGZ()) {
            this.sEn.cpN();
            this.sEp = true;
        }
        final chw FL = this.sEo.FL(i);
        this.sEq = new com.tencent.mm.plugin.topstory.ui.widget.b(this.mController.ylL, FL.xhc, new com.tencent.mm.plugin.topstory.ui.widget.b.a() {
            public final void j(Set<abz> set) {
                AppMethodBeat.i(1952);
                ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
                t.makeText(TopStoryFSVideoUI.this.mController.ylL, R.string.ex4, 0).show();
                com.tencent.mm.plugin.topstory.a.h.a(TopStoryFSVideoUI.this.cFT(), FL, (Set) set, TopStoryFSVideoUI.this.sEo.cGR());
                TopStoryFSVideoUI.this.sEn.stopPlay();
                TopStoryFSVideoUI.this.sEo.FK(i);
                TopStoryFSVideoUI.this.sGs.ci(i + TopStoryFSVideoUI.this.sGs.getHeadersCount());
                TopStoryFSVideoUI.this.sDY.a(0, 3, null);
                AppMethodBeat.o(1952);
            }

            public final void onDismiss() {
                AppMethodBeat.i(1953);
                ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
                if (TopStoryFSVideoUI.this.sEp) {
                    TopStoryFSVideoUI.this.sEn.cEf();
                    TopStoryFSVideoUI.this.sEp = false;
                    try {
                        ((f) TopStoryFSVideoUI.this.sEn.sFu.getControlBar()).aFE();
                        AppMethodBeat.o(1953);
                        return;
                    } catch (Exception e) {
                    }
                }
                AppMethodBeat.o(1953);
            }
        });
        this.sEq.a(view, true, 0, com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 16));
        try {
            ((f) this.sEn.sFu.getControlBar()).cHd();
            AppMethodBeat.o(1988);
        } catch (Exception e) {
            AppMethodBeat.o(1988);
        }
    }

    static /* synthetic */ boolean f(View view, float f, float f2) {
        AppMethodBeat.i(2001);
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int measuredWidth = view.getMeasuredWidth() + i;
            int measuredHeight = view.getMeasuredHeight() + i2;
            if (f2 >= ((float) i2) && f2 <= ((float) measuredHeight) && f >= ((float) i) && f <= ((float) measuredWidth)) {
                AppMethodBeat.o(2001);
                return true;
            }
        }
        AppMethodBeat.o(2001);
        return false;
    }

    static /* synthetic */ void b(TopStoryFSVideoUI topStoryFSVideoUI) {
        AppMethodBeat.i(2002);
        View decorView = topStoryFSVideoUI.getWindow().getDecorView();
        decorView.setSystemUiVisibility(((decorView.getSystemUiVisibility() | 2) | 4096) | 4);
        AppMethodBeat.o(2002);
    }

    static /* synthetic */ void a(TopStoryFSVideoUI topStoryFSVideoUI, String str) {
        AppMethodBeat.i(2003);
        if (!at.isNetworkConnected(topStoryFSVideoUI)) {
            Toast.makeText(topStoryFSVideoUI, topStoryFSVideoUI.getString(R.string.dj1), 1).show();
            AppMethodBeat.o(2003);
        } else if (bo.isNullOrNil(str)) {
            Toast.makeText(topStoryFSVideoUI, topStoryFSVideoUI.getString(R.string.dj2), 1).show();
            AppMethodBeat.o(2003);
        } else {
            Toast.makeText(topStoryFSVideoUI, str, 1).show();
            AppMethodBeat.o(2003);
        }
    }
}
