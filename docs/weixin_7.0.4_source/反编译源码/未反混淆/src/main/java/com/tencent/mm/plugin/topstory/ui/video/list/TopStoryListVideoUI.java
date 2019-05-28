package com.tencent.mm.plugin.topstory.ui.video.list;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.v;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.b;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.fs.d;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.c;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ae;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.xwalk.core.Log;

public class TopStoryListVideoUI extends TopStoryBaseVideoUI implements b {
    c sGA;
    View sGB;
    TopStoryCommentFloatDialog sGC;
    private boolean sGD;
    private ProgressDialog sGu;
    private View sGv;
    private View sGw;
    private View sGx;
    private Button sGy;
    View sGz;
    private View sHg;
    private TextView sHh;
    private e sHi;
    private d sHj;
    private View sHk;
    private View sHl;
    View sHm;
    c sHn;
    View sHo;
    private long sHp = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(2112);
        if (VERSION.SDK_INT >= 28) {
            this.ylm = true;
        }
        super.onCreate(bundle);
        ((com.tencent.mm.plugin.boots.a.c) g.K(com.tencent.mm.plugin.boots.a.c.class)).dC(b.jJr, 885);
        a.kT(13);
        AppMethodBeat.o(2112);
    }

    public final void Kh() {
        AppMethodBeat.i(2113);
        super.Kh();
        if (cFT().xgH != null) {
            this.sEo.d(cFT().xgH);
        }
        AppMethodBeat.o(2113);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(2115);
        p.sFq.a(this, i, i2, intent);
        if (i == 10001) {
            v f = d.f(this);
            if (f != null && (f instanceof h)) {
                ((h) f).mc(false);
            }
            if (!(intent == null || !intent.hasExtra("isMute") || this.sBa == null)) {
                me(intent.getBooleanExtra("isMute", this.sBa.eif));
            }
            if (!(intent == null || !intent.hasExtra("MOBILE_CHECK_FLAG") || this.sBa == null)) {
                FE(intent.getIntExtra("MOBILE_CHECK_FLAG", this.sBa.xgO));
            }
        }
        AppMethodBeat.o(2115);
    }

    public final void cGD() {
        AppMethodBeat.i(2117);
        super.cGD();
        this.sGx = findViewById(R.id.exn);
        this.sGy = (Button) findViewById(R.id.exo);
        this.sHg = findViewById(R.id.eyq);
        this.sHg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2097);
                if (TopStoryListVideoUI.this.sEn.sFw && TopStoryListVideoUI.this.sEn.sFu.getItemUIComponent() != null) {
                    TopStoryListVideoUI.this.sEn.sFu.getItemUIComponent().cFO();
                    TopStoryListVideoUI.this.sEn.sFu.getItemUIComponent().cFN();
                }
                AppMethodBeat.o(2097);
            }
        });
        overridePendingTransition(MMFragmentActivity.a.ync, MMFragmentActivity.a.ynd);
        if (cFT().xgI != null) {
            this.gnB.setVisibility(8);
        }
        this.sEl.sFo = 2;
        if (!cGI()) {
            this.sGw.setVisibility(4);
            this.sGv.setVisibility(4);
        } else if (this.sEk.isConnected()) {
            cHg();
            this.sGD = false;
            if (cFT().scene != 21 && cFT().xgI == null) {
                this.sGu = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.cn5), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG);
                        TopStoryListVideoUI.this.finish();
                        AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG);
                    }
                });
            }
        } else {
            Toast.makeText(this, R.string.dj3, 1).show();
            this.sGD = true;
        }
        this.sHi.sGI = true;
        if (cFT().xgJ) {
            this.sEk.sEM = true;
        }
        this.sDY.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL);
                TopStoryListVideoUI.this.sEl.cGS();
                AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL);
            }
        });
        new c(this).i(this.sDY);
        new com.tencent.mm.plugin.topstory.ui.video.fs.b().i(this.sEb);
        this.sGz = findViewById(R.id.exr);
        this.sGB = findViewById(R.id.exs);
        this.sGz.setVisibility(8);
        this.sHm = findViewById(R.id.eyr);
        this.sHo = findViewById(R.id.eys);
        this.sHm.setVisibility(8);
        this.sGz.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
                if (TopStoryListVideoUI.this.sGz.getVisibility() == 0) {
                    if (TopStoryListVideoUI.g(TopStoryListVideoUI.this.sGB, motionEvent.getX(), motionEvent.getY())) {
                        ab.i("MicroMsg.TopStory.TopStoryVideoUI", "touch in mContentViewNotFull");
                        AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
                        return false;
                    }
                    TopStoryListVideoUI.this.sGz.setVisibility(8);
                }
                AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
                return false;
            }
        });
        this.sHm.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(TXLiveConstants.PLAY_WARNING_FIRST_IDR_HW_DECODE_FAIL);
                if (TopStoryListVideoUI.this.sHm.getVisibility() == 0) {
                    if (TopStoryListVideoUI.g(TopStoryListVideoUI.this.sHo, motionEvent.getX(), motionEvent.getY())) {
                        ab.i("MicroMsg.TopStory.TopStoryVideoUI", "touch in mContentViewFull");
                        AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_FIRST_IDR_HW_DECODE_FAIL);
                        return false;
                    }
                    TopStoryListVideoUI.this.sHm.setVisibility(8);
                }
                AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_FIRST_IDR_HW_DECODE_FAIL);
                return false;
            }
        });
        this.sGC = (TopStoryCommentFloatDialog) findViewById(R.id.ext);
        this.sGC.setVisibility(8);
        this.sGC.k(this);
        AppMethodBeat.o(2117);
    }

    public final com.tencent.mm.plugin.topstory.ui.video.d cGE() {
        AppMethodBeat.i(2118);
        d dVar = new d();
        AppMethodBeat.o(2118);
        return dVar;
    }

    public final void fP(int i, int i2) {
        AppMethodBeat.i(2121);
        if ((i2 == 2 || i2 == 1) && this.sGD) {
            cHg();
        }
        super.fP(i, i2);
        AppMethodBeat.o(2121);
    }

    public final int getLayoutId() {
        return R.layout.b0j;
    }

    public final void cFO() {
        AppMethodBeat.i(2123);
        this.qpb.animate().cancel();
        this.qpb.setAlpha(1.0f);
        if (!(cFT().xgI == null || this.sHh == null)) {
            this.sHh.setAlpha(1.0f);
        }
        AppMethodBeat.o(2123);
    }

    public final void cGG() {
        AppMethodBeat.i(2124);
        super.cGG();
        if (!(this.sEt || this.sHg.getAlpha() == 0.0f)) {
            this.sHg.animate().cancel();
            this.sHg.setAlpha(0.0f);
        }
        AppMethodBeat.o(2124);
    }

    public final boolean FC(int i) {
        AppMethodBeat.i(2125);
        this.sGz.setVisibility(8);
        this.sHm.setVisibility(8);
        ab.i("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo %d", Integer.valueOf(i));
        try {
            if (this.sEt) {
                if (i < (this.sEd.getItemCount() - this.sEd.getFootersCount()) - this.sEd.getHeadersCount()) {
                    this.sEb.smoothScrollToPosition(i);
                    AppMethodBeat.o(2125);
                    return true;
                }
                ab.w("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", Integer.valueOf(i), Integer.valueOf(this.sEd.getItemCount()), Integer.valueOf(this.sEd.getFootersCount()), Integer.valueOf(this.sEd.getHeadersCount()));
                AppMethodBeat.o(2125);
                return false;
            } else if (i < (this.sHi.getItemCount() - this.sHi.getFootersCount()) - this.sHi.getHeadersCount()) {
                this.sEa.a(this, this.sHi.getHeadersCount() + i);
                AppMethodBeat.o(2125);
                return true;
            } else {
                ab.w("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", Integer.valueOf(i), Integer.valueOf(this.sHi.getItemCount()), Integer.valueOf(this.sHi.getFootersCount()), Integer.valueOf(this.sHi.getHeadersCount()));
                AppMethodBeat.o(2125);
                return false;
            }
        } catch (Exception e) {
            ab.w("MicroMsg.TopStory.TopStoryVideoUI", "tryToPlayPositionVideo Exception:%s", e.getMessage());
        }
    }

    public final void i(List<chw> list, boolean z) {
        AppMethodBeat.i(2126);
        super.i(list, z);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2109);
                if (TopStoryListVideoUI.this.sEt) {
                    TopStoryListVideoUI.this.sHl.setVisibility(4);
                    TopStoryListVideoUI.this.sHk.setVisibility(4);
                    TopStoryListVideoUI.this.sEb.a(0, 3, null);
                } else {
                    TopStoryListVideoUI.this.sGw.setVisibility(4);
                    TopStoryListVideoUI.this.sGv.setVisibility(4);
                }
                if (TopStoryListVideoUI.this.sGu != null) {
                    TopStoryListVideoUI.this.sGu.dismiss();
                    TopStoryListVideoUI.this.sGu = null;
                }
                AppMethodBeat.o(2109);
            }
        }, 50);
        AppMethodBeat.o(2126);
    }

    public final void abH(final String str) {
        AppMethodBeat.i(2127);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2110);
                if (TopStoryListVideoUI.this.sEt) {
                    TopStoryListVideoUI.this.sHl.setVisibility(4);
                    TopStoryListVideoUI.this.sHk.setVisibility(4);
                } else {
                    TopStoryListVideoUI.this.sGw.setVisibility(4);
                    TopStoryListVideoUI.this.sGv.setVisibility(4);
                }
                if (TopStoryListVideoUI.this.sGu != null) {
                    TopStoryListVideoUI.this.sGu.dismiss();
                    TopStoryListVideoUI.this.sGu = null;
                }
                TopStoryListVideoUI.a(TopStoryListVideoUI.this, str);
                AppMethodBeat.o(2110);
            }
        });
        AppMethodBeat.o(2127);
    }

    public final void FJ(int i) {
        AppMethodBeat.i(2128);
        ab.i("MicroMsg.TopStory.TopStoryVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", Integer.valueOf(i), Boolean.valueOf(System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1));
        if (System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {
            if (i == 90 || i == 270) {
                if (this.sEt) {
                    AppMethodBeat.o(2128);
                    return;
                }
                aFH();
                AppMethodBeat.o(2128);
                return;
            } else if (i == 180 || i == 0) {
                if (this.sEt) {
                    cGf();
                } else {
                    AppMethodBeat.o(2128);
                    return;
                }
            }
        }
        AppMethodBeat.o(2128);
    }

    public final e cGJ() {
        AppMethodBeat.i(2129);
        this.sHi = new e(this);
        e eVar = this.sHi;
        View inflate = LayoutInflater.from(this).inflate(R.layout.b0g, null);
        inflate.setClickable(false);
        inflate.setFocusableInTouchMode(false);
        inflate.setFocusable(false);
        View findViewById = inflate.findViewById(R.id.eyh);
        View findViewById2 = inflate.findViewById(R.id.eyi);
        if (cFT().xgI != null) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            this.sHh = (TextView) inflate.findViewById(R.id.eyj);
            this.sHh.setText(cFT().xgI.title);
            TextView textView = (TextView) inflate.findViewById(R.id.eyk);
            if (bo.isNullOrNil(cFT().xgI.jcF)) {
                textView.setVisibility(8);
            } else {
                textView.setText(cFT().xgI.jcF);
            }
        } else {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
        }
        inflate.setLayoutParams(new LayoutParams(-1, -2));
        eVar.addHeaderView(inflate);
        e eVar2 = this.sHi;
        View inflate2 = LayoutInflater.from(this).inflate(R.layout.b0i, null);
        inflate2.setPadding(0, 0, 0, ((com.tencent.mm.bz.a.ge(this.mController.ylL) * 2) / 5) - getResources().getDimensionPixelSize(R.dimen.a_t));
        inflate2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.sGw = inflate2.findViewById(R.id.eyo);
        this.sGv = inflate2.findViewById(R.id.byu);
        eVar2.ei(inflate2);
        eVar2 = this.sHi;
        AppMethodBeat.o(2129);
        return eVar2;
    }

    public final e cGK() {
        AppMethodBeat.i(2130);
        this.sHj = new d(this);
        d dVar = this.sHj;
        View inflate = LayoutInflater.from(this).inflate(R.layout.b0i, null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.sHl = inflate.findViewById(R.id.eyo);
        this.sHk = inflate.findViewById(R.id.byu);
        dVar.ei(inflate);
        dVar = this.sHj;
        AppMethodBeat.o(2130);
        return dVar;
    }

    public final void aFH() {
        AppMethodBeat.i(2131);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.sHp < 1000) {
            AppMethodBeat.o(2131);
            return;
        }
        this.sHp = currentTimeMillis;
        ab.d("MicroMsg.TopStory.TopStoryVideoUI", "enterFullScreen");
        if (this.sEn.sFu != null) {
            this.sBa.xgM = this.sEn.sFu.getControlBar().getmPosition();
            if (this.sEn.sFu.getControlBar().getVideoTotalTime() - this.sBa.xgM < 2) {
                AppMethodBeat.o(2131);
                return;
            }
        }
        md(false);
        this.sEt = true;
        this.sHm.setVisibility(8);
        this.sGz.setVisibility(8);
        if (!cGb()) {
            setRequestedOrientation(0);
        }
        if (this.sEq != null && this.sEq.isShowing()) {
            this.sEq.dismiss();
            this.sEq = null;
        }
        this.sHg.setVisibility(8);
        this.gnB.setVisibility(8);
        this.sDW.setVisibility(8);
        this.sDY.setVisibility(8);
        this.sEb.setVisibility(0);
        this.sHi.aop.notifyChanged();
        if (g.RP().Ry().getInt(ac.a.USERINFO_TOP_STORY_SHORT_VIDEO_FS_SCROLL_TIPS_INT, 0) == 0) {
            this.sEn.cpN();
            this.sGx.setVisibility(0);
            this.sGx.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            this.sGy.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(2111);
                    g.RP().Ry().set(ac.a.USERINFO_TOP_STORY_SHORT_VIDEO_FS_SCROLL_TIPS_INT, Integer.valueOf(1));
                    TopStoryListVideoUI.this.sEn.cEf();
                    TopStoryListVideoUI.this.sGx.setVisibility(8);
                    TopStoryListVideoUI.this.sEe.b(TopStoryListVideoUI.this);
                    AppMethodBeat.o(2111);
                }
            });
        } else {
            this.sGx.setVisibility(8);
        }
        this.sHj.sFI = true;
        this.sEc.ah(cFT().xgL, 0);
        getSwipeBackLayout().setEnableGesture(false);
        md(true);
        AppMethodBeat.o(2131);
    }

    public final void cGf() {
        AppMethodBeat.i(2132);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.sHp < 1000) {
            AppMethodBeat.o(2132);
            return;
        }
        this.sHp = currentTimeMillis;
        ab.d("MicroMsg.TopStory.TopStoryVideoUI", "exitFullScreen");
        if (this.sEn.sFu != null) {
            this.sBa.xgM = this.sEn.sFu.getControlBar().getmPosition();
            if (this.sEn.sFu.getControlBar().getVideoTotalTime() - this.sBa.xgM < 2) {
                AppMethodBeat.o(2132);
                return;
            }
        }
        md(false);
        this.sEt = false;
        this.sHm.setVisibility(8);
        this.sGz.setVisibility(8);
        if (!cGb()) {
            setRequestedOrientation(1);
        }
        if (this.sEq != null && this.sEq.isShowing()) {
            this.sEq.dismiss();
            this.sEq = null;
        }
        this.sHg.setVisibility(0);
        if (cFT().xgI == null) {
            this.gnB.setVisibility(0);
        }
        this.sDY.setVisibility(0);
        this.sEb.setVisibility(8);
        this.sHj.aop.notifyChanged();
        this.sGx.setVisibility(8);
        this.sHi.sGP = true;
        this.qYS.ah(cFT().xgL + this.sHi.getHeadersCount(), TopStoryBaseVideoUI.sDT);
        getSwipeBackLayout().setEnableGesture(true);
        md(true);
        AppMethodBeat.o(2132);
    }

    public final boolean fS(int i, int i2) {
        AppMethodBeat.i(2134);
        if (cFT().xgI != null) {
            AppMethodBeat.o(2134);
            return true;
        } else if (i <= 30 || ((float) i) / ((float) i2) <= 0.65f) {
            AppMethodBeat.o(2134);
            return false;
        } else {
            n nVar = this.sEo;
            chv chv = this.sBa;
            String str = this.sEo.FL(cFY()).xgS;
            int cGR = this.sEo.cGR();
            chv = com.tencent.mm.plugin.topstory.a.g.a(chv);
            chv.offset = cGR;
            m jVar = new j(chv, nVar.sDo.cFY(), str);
            g.Rg().a(jVar, 0);
            g.Rg().a(1943, new com.tencent.mm.plugin.topstory.ui.video.n.AnonymousClass1(jVar));
            AppMethodBeat.o(2134);
            return true;
        }
    }

    public final int cGk() {
        return 0;
    }

    public final com.tencent.mm.plugin.topstory.ui.video.d cGF() {
        AppMethodBeat.i(2135);
        com.tencent.mm.plugin.topstory.ui.video.fs.c cVar = new com.tencent.mm.plugin.topstory.ui.video.fs.c();
        AppMethodBeat.o(2135);
        return cVar;
    }

    public final void a(final chw chw, View view, boolean z) {
        AppMethodBeat.i(2136);
        ab.i("MicroMsg.TopStory.TopStoryVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", chw.xgS, Boolean.valueOf(z));
        if (z) {
            int i;
            String str = System.currentTimeMillis();
            String str2 = chw.ubA;
            String str3 = "";
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = chw.title;
            String str8 = cFT().hlm;
            int i2 = cFT().scene;
            if (cGb()) {
                i = 318;
            } else {
                i = com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX;
            }
            f fVar = new f(str, str2, str3, str4, str5, str6, str7, str8, i2, i, chw.xgS, chw.xhi);
            if (this.sEt) {
                this.sHm.setVisibility(0);
                this.sGz.setVisibility(8);
                this.sHn = new c(this.sHo, new c.a() {
                    public final void a(f fVar) {
                        AppMethodBeat.i(2100);
                        TopStoryListVideoUI.this.sGC.a(fVar, new TopStoryCommentFloatDialog.a() {
                            public final void onDismiss() {
                                AppMethodBeat.i(2098);
                                TopStoryListVideoUI.this.sEn.cEf();
                                AppMethodBeat.o(2098);
                            }

                            public final void cHi() {
                                AppMethodBeat.i(2099);
                                TopStoryListVideoUI.this.sHm.setVisibility(8);
                                TopStoryListVideoUI.this.sGz.setVisibility(8);
                                AppMethodBeat.o(2099);
                            }
                        }, (int) TopStoryListVideoUI.this.sBa.xgG, chw.xgW);
                        if (TopStoryListVideoUI.this.sEn.cGZ()) {
                            TopStoryListVideoUI.this.sEn.cpN();
                        }
                        AppMethodBeat.o(2100);
                    }
                }, fVar, chw.xgS);
                c cVar = this.sHn;
                Context context = view.getContext();
                View view2 = cVar.contentView;
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                view.getLocationInWindow(iArr2);
                view.getHeight();
                int width = view.getWidth();
                int i3 = ae.hy(context).x;
                view2.measure(0, 0);
                int measuredHeight = view2.getMeasuredHeight();
                int measuredWidth = view2.getMeasuredWidth();
                iArr[0] = ((width / 2) + iArr2[0]) - (measuredWidth / 2);
                iArr[1] = iArr2[1] - measuredHeight;
                Log.i("PopupUtil", "window pos x:" + iArr[0] + ", windowWidth:" + measuredWidth + ", screenWidth:" + i3);
                if (iArr[0] + measuredWidth > i3) {
                    iArr[0] = i3 - measuredWidth;
                }
                iArr[0] = iArr[0] + 0;
                iArr[1] = iArr[1] + 0;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.contentView.getLayoutParams();
                layoutParams.leftMargin = iArr[0];
                layoutParams.topMargin = iArr[1];
                cVar.contentView.setLayoutParams(layoutParams);
                this.sHm.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL);
                        if (TopStoryListVideoUI.this.sHm.getVisibility() == 0) {
                            TopStoryListVideoUI.this.sHm.setVisibility(8);
                        }
                        AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_VIDEO_DECODE_FAIL);
                    }
                }, 1800);
                AppMethodBeat.o(2136);
                return;
            }
            this.sHm.setVisibility(8);
            this.sGz.setVisibility(0);
            this.sGA = new c(this.sGB, new c.a() {
                public final void a(f fVar) {
                    AppMethodBeat.i(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG);
                    TopStoryListVideoUI.this.sGC.a(fVar, new TopStoryCommentFloatDialog.a() {
                        public final void onDismiss() {
                            AppMethodBeat.i(TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
                            TopStoryListVideoUI.this.sEn.cEf();
                            AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
                        }

                        public final void cHi() {
                            AppMethodBeat.i(TXLiveConstants.PLAY_WARNING_RECONNECT);
                            TopStoryListVideoUI.this.sHm.setVisibility(8);
                            TopStoryListVideoUI.this.sGz.setVisibility(8);
                            AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_RECONNECT);
                        }
                    }, (int) TopStoryListVideoUI.this.sBa.xgG, chw.xgW);
                    if (TopStoryListVideoUI.this.sEn.cGZ()) {
                        TopStoryListVideoUI.this.sEn.cpN();
                    }
                    AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG);
                }
            }, fVar, chw.xgS);
            this.sGA.a(view, false, 0 - com.tencent.mm.plugin.topstory.ui.widget.f.dip2px(this, 10.0f));
            AppMethodBeat.o(2136);
            return;
        }
        if (this.sHm.getVisibility() == 0) {
            if (!(this.sHn == null || this.sHn.fgd == null || !this.sHn.fgd.equals(chw.xgS))) {
                this.sHm.setVisibility(8);
                AppMethodBeat.o(2136);
                return;
            }
        } else if (this.sGz.getVisibility() == 0 && this.sGA != null && this.sGA.fgd != null && this.sGA.fgd.equals(chw.xgS)) {
            this.sGz.setVisibility(8);
        }
        AppMethodBeat.o(2136);
    }

    public void onPause() {
        AppMethodBeat.i(2137);
        super.onPause();
        this.sGC.onPause();
        AppMethodBeat.o(2137);
    }

    public void onResume() {
        AppMethodBeat.i(2138);
        super.onResume();
        this.sGC.onResume();
        AppMethodBeat.o(2138);
    }

    public void onDestroy() {
        AppMethodBeat.i(2139);
        super.onDestroy();
        this.sGC.sIl.close();
        AppMethodBeat.o(2139);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(2140);
        if (i == 4 && this.sGC.getVisibility() == 0) {
            this.sGC.hide();
            AppMethodBeat.o(2140);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(2140);
        return onKeyDown;
    }

    public final int getForceOrientation() {
        AppMethodBeat.i(2114);
        if (!this.sEt || cGb()) {
            AppMethodBeat.o(2114);
            return 1;
        }
        AppMethodBeat.o(2114);
        return 0;
    }

    public final void cGC() {
        AppMethodBeat.i(2116);
        if (this.sEt) {
            cGf();
            AppMethodBeat.o(2116);
            return;
        }
        if (this.sBa != null) {
            Intent intent = new Intent();
            intent.putExtra("isMute", this.sBa.eif);
            intent.putExtra("MOBILE_CHECK_FLAG", this.sBa.xgO);
            setResult(-1, intent);
        }
        finish();
        AppMethodBeat.o(2116);
    }

    public final void cGH() {
        AppMethodBeat.i(2119);
        if (this.sEt) {
            this.sHl.setVisibility(0);
            this.sHk.setVisibility(0);
        } else {
            this.sGw.setVisibility(0);
            this.sGv.setVisibility(0);
        }
        this.sEo.FM(this.sEo.cGR());
        AppMethodBeat.o(2119);
    }

    private void cHg() {
        AppMethodBeat.i(2120);
        if (this.sEt) {
            this.sHl.setVisibility(0);
            this.sHk.setVisibility(0);
        } else {
            this.sGw.setVisibility(0);
            this.sGv.setVisibility(0);
        }
        this.sEo.FM(0);
        AppMethodBeat.o(2120);
    }

    public final void cFN() {
        AppMethodBeat.i(2122);
        if (this.sEt) {
            this.sHm.setVisibility(8);
        } else {
            this.sHg.animate().alpha(1.0f).setDuration(200).setStartDelay(1800);
        }
        this.qpb.animate().alpha(0.1f).setDuration(200).setStartDelay(1800);
        if (!(cFT().xgI == null || this.sHh == null)) {
            this.sHh.animate().alpha(0.1f).setDuration(200).setStartDelay(1800);
        }
        AppMethodBeat.o(2122);
    }

    public final void a(bzs bzs) {
        tn tnVar;
        boolean z;
        AppMethodBeat.i(2133);
        if (this.sEt) {
            cGf();
        }
        this.sEk.sEM = true;
        this.sEn.stopPlay();
        chw FL = this.sEo.FL(cFY());
        chv a = com.tencent.mm.plugin.topstory.a.g.a(cFT());
        a.xgj = UUID.randomUUID().toString();
        a.xgC = FL.xgS;
        a.xgG = bzs.wYN;
        a.xgH = null;
        a.xgI = bzs;
        a.xgJ = this.sEk.sEM;
        Iterator it = a.tZG.iterator();
        while (it.hasNext()) {
            tnVar = (tn) it.next();
            if ("show_tag_list".equals(tnVar.key)) {
                tnVar.waE = bzs.id;
                z = true;
                break;
            }
        }
        z = false;
        if (!z) {
            tnVar = new tn();
            tnVar.key = "show_tag_list";
            tnVar.waE = bzs.id;
            a.tZG.add(tnVar);
        }
        aa.a((Activity) this, a);
        a.kT(28);
        ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(cFT(), FL, cFY(), 4, bzs.cEh + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bzs.id);
        AppMethodBeat.o(2133);
    }

    static /* synthetic */ boolean g(View view, float f, float f2) {
        AppMethodBeat.i(2141);
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int measuredWidth = view.getMeasuredWidth() + i;
            int measuredHeight = view.getMeasuredHeight() + i2;
            if (f2 >= ((float) i2) && f2 <= ((float) measuredHeight) && f >= ((float) i) && f <= ((float) measuredWidth)) {
                AppMethodBeat.o(2141);
                return true;
            }
        }
        AppMethodBeat.o(2141);
        return false;
    }

    static /* synthetic */ void a(TopStoryListVideoUI topStoryListVideoUI, String str) {
        AppMethodBeat.i(2142);
        if (!at.isNetworkConnected(topStoryListVideoUI)) {
            Toast.makeText(topStoryListVideoUI, topStoryListVideoUI.getString(R.string.dj1), 1).show();
            AppMethodBeat.o(2142);
        } else if (bo.isNullOrNil(str)) {
            Toast.makeText(topStoryListVideoUI, topStoryListVideoUI.getString(R.string.dj2), 1).show();
            AppMethodBeat.o(2142);
        } else {
            Toast.makeText(topStoryListVideoUI, str, 1).show();
            AppMethodBeat.o(2142);
        }
    }
}
