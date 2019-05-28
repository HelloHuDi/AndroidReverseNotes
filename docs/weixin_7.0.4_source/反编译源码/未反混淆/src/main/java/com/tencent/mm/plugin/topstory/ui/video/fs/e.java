package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class e extends f {
    private boolean isLoading;
    private f sFK;
    private k sFL;
    private OnClickListener sFM;
    private OnClickListener sFN;
    private OnClickListener sFO;
    private OnClickListener sFP;
    private OnClickListener sFQ;
    private OnClickListener sFR;
    private b sFS = new b() {
        public final void c(String str, String str2, String str3, int i, int i2) {
            int i3 = 0;
            AppMethodBeat.i(1880);
            ab.e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i), Integer.valueOf(i2));
            chw FL = e.this.sDo.cGg().FL(e.this.sDo.cFY());
            if (!(FL == null || FL.xhb == null)) {
                ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", Integer.valueOf(i), Integer.valueOf(FL.xhb.size()), FL.videoUrl, Integer.valueOf(FL.xhg));
                int i4 = 0;
                while (i4 < FL.xhb.size()) {
                    if (!FL.videoUrl.equals(((chy) FL.xhb.get(i4)).url)) {
                        i4++;
                    } else if (i4 + 1 < FL.xhb.size()) {
                        chy chy = (chy) FL.xhb.get(i4 + 1);
                        if (!(chy == null || bo.isNullOrNil(chy.url))) {
                            FL.xhg = chy.xhg;
                            FL.videoUrl = chy.url;
                            ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", Integer.valueOf(i4), chy.url, Integer.valueOf(chy.xhg));
                            com.tencent.mm.plugin.websearch.api.a.b.kT(com.tencent.mm.plugin.websearch.api.a.b.ubZ);
                            e.this.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(1879);
                                    e.this.O(true, true);
                                    AppMethodBeat.o(1879);
                                }
                            }, 100);
                            AppMethodBeat.o(1880);
                            return;
                        }
                    }
                }
            }
            e.this.sDo.cGg().a(e.this.sDo.cFT(), e.this.sDo.cFY());
            e.this.gE(e.this.getContext().getString(R.string.f13, new Object[]{i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2}), e.this.getContext().getString(R.string.f1r));
            e.this.getFSVideoUIComponent().cFV().onError(str);
            h.Fz(i);
            com.tencent.mm.plugin.topstory.a.b.a aVar = e.this.getFSVideoUIComponent().cFR().sFp;
            if (aVar != null && aVar.sAE > 0) {
                i3 = ((int) (System.currentTimeMillis() - aVar.sAE)) / 1000;
            }
            h.a(FL, i, str3, i3);
            AppMethodBeat.o(1880);
        }

        public final void cp(String str, String str2) {
            AppMethodBeat.i(1881);
            ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
            e.this.sFL.aFY();
            if (!e.this.isLoading) {
                e.this.cGp();
            }
            AppMethodBeat.o(1881);
        }

        public final void cq(String str, String str2) {
            boolean z;
            AppMethodBeat.i(1882);
            ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
            e.this.getFSVideoUIComponent().cFV().abK(str);
            e.this.getFSVideoUIComponent().cFR().sFo = 1;
            ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", Integer.valueOf(e.this.getFSVideoUIComponent().cGk()));
            if (e.this.getFSVideoUIComponent().cGk() == 1 && e.this.getFSVideoUIComponent().cGb() && (e.this.sDG instanceof j)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                ((j) e.this.sDG).mc(true);
                ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "VVideoAutoPlay replay succ");
                z = true;
            } else {
                z = e.this.getFSVideoUIComponent().FC(e.this.sDG.cFP() + 1);
            }
            if (!z && (e.this.sDG instanceof com.tencent.mm.plugin.topstory.ui.video.h)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e2) {
                }
                ((com.tencent.mm.plugin.topstory.ui.video.h) e.this.sDG).mc(true);
            }
            e.this.isLoading = false;
            AppMethodBeat.o(1882);
        }

        public final void d(String str, String str2, int i, int i2) {
            AppMethodBeat.i(1883);
            ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(1883);
        }

        public final void cr(String str, String str2) {
        }

        public final void cs(String str, String str2) {
        }

        public final void ct(String str, String str2) {
            AppMethodBeat.i(1884);
            ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
            e.this.isLoading = true;
            AppMethodBeat.o(1884);
        }

        public final void cu(String str, String str2) {
            AppMethodBeat.i(1885);
            ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
            e.this.isLoading = false;
            e.this.cGp();
            com.tencent.mm.plugin.topstory.a.b.a aVar = e.this.getFSVideoUIComponent().cFR().sFp;
            if (aVar != null && aVar.sAP == 0) {
                aVar.sAP = System.currentTimeMillis() - aVar.sAE;
                ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", Long.valueOf(aVar.sAM), Long.valueOf(aVar.sAP));
            }
            AppMethodBeat.o(1885);
        }
    };
    public boolean sFT;

    class a implements c {
        private float sFW;

        a() {
            AppMethodBeat.i(1901);
            this.sFW = (float) com.tencent.mm.bz.a.ge(e.this.getContext());
            AppMethodBeat.o(1901);
        }

        public final void aFi() {
            AppMethodBeat.i(1902);
            ab.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
            if (e.U(e.this)) {
                Object obj;
                if (e.this.sFK.getVisibility() == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    e.this.sFK.setVisibility(8);
                    AppMethodBeat.o(1902);
                    return;
                }
                e.this.sFK.show();
                if (e.this.getFSItemUIComponent() != null) {
                    e.this.getFSItemUIComponent().cFO();
                    e.this.getFSItemUIComponent().cFN();
                }
            }
            AppMethodBeat.o(1902);
        }

        public final void aFj() {
            AppMethodBeat.i(1903);
            ab.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
            AppMethodBeat.o(1903);
        }

        public final void aFk() {
            AppMethodBeat.i(1904);
            e.this.sDq.setVisibility(0);
            e.this.sFK.cHe();
            AppMethodBeat.o(1904);
        }

        public final int be(float f) {
            AppMethodBeat.i(1905);
            float f2 = f / this.sFW;
            int videoDurationSec = e.this.getFSVideoUIComponent().cFV().getVideoDurationSec();
            int currentPosition = ((int) (f2 * ((float) videoDurationSec))) + getCurrentPosition();
            if (currentPosition < 0) {
                currentPosition = 0;
            } else if (currentPosition > videoDurationSec) {
                currentPosition = videoDurationSec;
            }
            e.this.sDq.setText(com.tencent.mm.plugin.websearch.ui.a.fQ(((long) currentPosition) * 1000) + "/" + com.tencent.mm.plugin.websearch.ui.a.fQ(((long) videoDurationSec) * 1000));
            AppMethodBeat.o(1905);
            return currentPosition;
        }

        public final void FF(int i) {
            AppMethodBeat.i(1906);
            e.this.sFK.cHf();
            e.this.sDq.setVisibility(8);
            e.this.seekTo(i);
            AppMethodBeat.o(1906);
        }

        public final boolean cGl() {
            AppMethodBeat.i(1907);
            if (e.Y(e.this)) {
                AppMethodBeat.o(1907);
                return false;
            }
            AppMethodBeat.o(1907);
            return true;
        }

        public final int getCurrentPosition() {
            AppMethodBeat.i(1908);
            int currPosSec = e.this.getFSVideoUIComponent().cFV().getCurrPosSec();
            AppMethodBeat.o(1908);
            return currPosSec;
        }
    }

    static /* synthetic */ boolean Y(e eVar) {
        AppMethodBeat.i(1924);
        boolean aFf = eVar.aFf();
        AppMethodBeat.o(1924);
        return aFf;
    }

    public e(Context context, com.tencent.mm.plugin.topstory.ui.video.b bVar, com.tencent.mm.plugin.topstory.ui.video.a aVar) {
        super(context, bVar, aVar);
        AppMethodBeat.i(1909);
        if (this.sDo.cGb()) {
            this.kuG.setScaleType(ScaleType.CENTER_CROP);
        }
        AppMethodBeat.o(1909);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    public final int getLayoutId() {
        return R.layout.b02;
    }

    public final void init() {
        AppMethodBeat.i(1910);
        super.init();
        this.sFM = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1877);
                e.this.getFSVideoUIComponent().cGf();
                AppMethodBeat.o(1877);
            }
        };
        this.sFN = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1893);
                e.this.getFSVideoUIComponent().ad(view, e.this.sDG.cFP());
                AppMethodBeat.o(1893);
            }
        };
        this.sFO = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1894);
                e.this.getFSItemUIComponent().FN(e.this.sDG.cFP());
                AppMethodBeat.o(1894);
            }
        };
        this.sFP = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1895);
                e.this.getFSVideoUIComponent().a(e.this.sAX);
                e.this.sFK.h(e.this.sAX);
                AppMethodBeat.o(1895);
            }
        };
        this.sFQ = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1896);
                com.tencent.mm.plugin.topstory.ui.video.b fSVideoUIComponent = e.this.getFSVideoUIComponent();
                e.this.sDG.cFP();
                fSVideoUIComponent.a((bzs) view.getTag());
                AppMethodBeat.o(1896);
            }
        };
        this.sFR = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1897);
                if (!(e.this.sAX == null || bo.isNullOrNil(e.this.sAX.phw))) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", e.this.sAX.phw);
                    d.b(e.this.getFSVideoUIComponent().bKU().getApplicationContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(1897);
            }
        };
        this.sDv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1898);
                if (e.this.sDI == com.tencent.mm.plugin.topstory.ui.video.f.a.MOBILE_NET) {
                    e.this.getFSVideoUIComponent().cFQ().sEM = true;
                    e.this.sDo.FE(2);
                }
                if (e.this.getFSVideoUIComponent().cFQ().isConnected()) {
                    e.this.sDI = com.tencent.mm.plugin.topstory.ui.video.f.a.UNKNOWN;
                    if (e.this.getFSVideoUIComponent().cFV().sFw) {
                        e.this.getFSVideoUIComponent().cFV().cEf();
                    } else {
                        e.this.O(true, false);
                    }
                    com.tencent.mm.plugin.websearch.api.a.a.kT(19);
                    AppMethodBeat.o(1898);
                    return;
                }
                com.tencent.mm.plugin.websearch.api.a.a.kT(20);
                AppMethodBeat.o(1898);
            }
        });
        this.sDt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1899);
                e.this.getFSVideoUIComponent().cFR().sFo = 2;
                if (e.this.getFSItemUIComponent() == null || e.this.getFSItemUIComponent().cFP() != e.this.getFSVideoUIComponent().cFY()) {
                    e.this.getFSVideoUIComponent().FC(e.this.sDG.cFP());
                    e.this.getFSVideoUIComponent().cFR().f(e.this.sAX);
                    ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().cFT(), e.this.sAX, e.this.sDG.cFP(), 2, "");
                    AppMethodBeat.o(1899);
                    return;
                }
                e.this.O(!e.this.getFSVideoUIComponent().cFQ().sEM, false);
                AppMethodBeat.o(1899);
            }
        });
        this.sDu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1900);
                e.this.cGv();
                e.this.sFK.aFE();
                e.this.getFSVideoUIComponent().cFR().sFo = 2;
                e.this.getFSVideoUIComponent().cFV().a(e.this.getFSVideoUIComponent(), e.this.sAX, e.this.cvF, e.this.sDG.cFP());
                e.this.cGp();
                AppMethodBeat.o(1900);
            }
        });
        this.sDz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1878);
                if (!(e.this.getFSItemUIComponent() == null || e.this.getFSItemUIComponent().cFP() == e.this.getFSVideoUIComponent().cFY())) {
                    e.this.getFSVideoUIComponent().cFR().sFo = 2;
                    e.this.getFSVideoUIComponent().FC(e.this.sDG.cFP());
                    e.this.getFSVideoUIComponent().cFR().f(e.this.sAX);
                    ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(e.this.getFSVideoUIComponent().cFT(), e.this.sAX, e.this.sDG.cFP(), 2, "");
                }
                AppMethodBeat.o(1878);
            }
        });
        this.sFL = new k(getContext(), this, new a());
        if (getFSVideoUIComponent().cGb()) {
            this.sFK = new k(getContext());
        } else {
            this.sFK = new f(getContext());
        }
        this.sFK.setOnlyFS(this.sFT);
        this.sFK.setVisibility(8);
        this.sFK.setFullScreenBtnClickListener(this.sFM);
        this.sFK.setFeedbackBtnClickListener(this.sFN);
        this.sFK.setShareBtnClickListener(this.sFO);
        this.sFK.setWowBtnClickListener(this.sFP);
        this.sFK.setTagBtnClickListener(this.sFQ);
        this.sFK.setSourceItemClickListener(this.sFR);
        if (com.tencent.mm.plugin.topstory.a.g.cFm()) {
            this.sFK.setTitleClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(1886);
                    e.this.getFSVideoUIComponent().cFV().sFy = true;
                    AppMethodBeat.o(1886);
                }
            });
        }
        this.sFK.setOnUpdateProgressLenListener(new com.tencent.mm.plugin.topstory.ui.video.fs.f.a() {
            public final void update(int i, int i2) {
                int width;
                AppMethodBeat.i(1887);
                if (i2 > 0) {
                    width = (e.this.sDF.getWidth() * i) / i2;
                } else {
                    width = 0;
                }
                com.tencent.mm.plugin.topstory.a.b.a aVar = e.this.getFSVideoUIComponent().cFR().sFp;
                if (aVar != null && aVar.sAH < ((long) e.this.getFSVideoUIComponent().cFV().getCurrPosMs())) {
                    aVar.sAH = (long) e.this.getFSVideoUIComponent().cFV().getCurrPosMs();
                }
                LayoutParams layoutParams = (LayoutParams) e.this.sDE.getLayoutParams();
                layoutParams.width = width;
                e.this.sDE.setLayoutParams(layoutParams);
                e.this.sDE.requestLayout();
                if (e.this.sAX.xhf <= 0 && (e.this.sAX.xhd & 256) <= 0 && e.this.sDo.fS(i, i2)) {
                    e.this.sAX.xhf = 1;
                }
                AppMethodBeat.o(1887);
            }

            public final void cHb() {
                AppMethodBeat.i(1888);
                e.this.sDD.setVisibility(8);
                AppMethodBeat.o(1888);
            }

            public final void cHc() {
                AppMethodBeat.i(1889);
                if (e.this.getFSVideoUIComponent().cFV().sFw && (e.this.getFSVideoUIComponent().cFV().cGZ() || e.this.getFSVideoUIComponent().cFV().sFx)) {
                    e.this.sDD.setVisibility(0);
                    AppMethodBeat.o(1889);
                    return;
                }
                e.this.sDD.setVisibility(8);
                AppMethodBeat.o(1889);
            }
        });
        this.sFK.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void aFw() {
                AppMethodBeat.i(1890);
                ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
                e.this.sFK.cHd();
                AppMethodBeat.o(1890);
            }

            public final void oA(int i) {
                AppMethodBeat.i(1891);
                ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", Integer.valueOf(i));
                e.this.seekTo(i);
                e.this.sFK.aFE();
                com.tencent.mm.plugin.websearch.api.a.a.kT(22);
                AppMethodBeat.o(1891);
            }
        });
        this.sFK.setOnPlayButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1892);
                if (!e.this.getFSVideoUIComponent().cFV().sFw) {
                    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
                    AppMethodBeat.o(1892);
                } else if ((e.this.sFK instanceof k) || e.this.sFK.getVideoTotalTime() - e.this.sFK.getmPosition() >= 2) {
                    e.this.getFSVideoUIComponent().cFR().f(e.this.sAX);
                    if (e.this.getFSVideoUIComponent().cFV().cGZ()) {
                        e.this.getFSVideoUIComponent().cFV().cpN();
                        e.this.sFK.cHd();
                    } else {
                        e.this.getFSVideoUIComponent().cFV().cEf();
                        e.this.sFK.aFE();
                    }
                    e.this.cGp();
                    AppMethodBeat.o(1892);
                } else {
                    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
                    AppMethodBeat.o(1892);
                }
            }
        });
        AppMethodBeat.o(1910);
    }

    public final void cGp() {
        AppMethodBeat.i(1911);
        super.cGp();
        AppMethodBeat.o(1911);
    }

    public final void cGn() {
        AppMethodBeat.i(1912);
        ab.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
        this.sDz.setVisibility(8);
        this.sDy.setVisibility(8);
        this.kuG.setVisibility(0);
        this.sDq.setVisibility(8);
        this.sDp.setVisibility(8);
        this.sDD.setVisibility(8);
        AppMethodBeat.o(1912);
    }

    public final void cGo() {
        AppMethodBeat.i(1913);
        ab.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
        this.sDz.setVisibility(0);
        if (!getFSVideoUIComponent().cFQ().cGN() || com.tencent.mm.plugin.topstory.a.g.cFp()) {
            this.sDy.setVisibility(8);
        } else {
            this.sDy.setVisibility(0);
        }
        this.kuG.setVisibility(0);
        this.sDq.setVisibility(8);
        this.sDp.setVisibility(8);
        this.sDD.setVisibility(8);
        this.sDB.setVisibility(0);
        this.sDA.setVisibility(8);
        this.sDt.setVisibility(0);
        this.sDu.setVisibility(8);
        this.sDx.setVisibility(8);
        AppMethodBeat.o(1913);
    }

    public final void cGt() {
        AppMethodBeat.i(1914);
        f fVar = this.sFK;
        if (fVar.sGn != null) {
            fVar.sGn.stopTimer();
        }
        AppMethodBeat.o(1914);
    }

    public final void cu() {
        AppMethodBeat.i(1915);
        super.cu();
        if (this.sFK != null) {
            this.sFK.setVideoTotalTime(this.sAX.xgR);
            f fVar = this.sFK;
            chw chw = this.sAX;
            fVar.sFY.setVisibility(0);
            fVar.aFL();
            ViewGroup.LayoutParams layoutParams = fVar.sGe.getLayoutParams();
            layoutParams.height = fVar.getResources().getDimensionPixelSize(R.dimen.a2d);
            fVar.sGe.setLayoutParams(layoutParams);
            if (chw.wiH.size() > 0) {
                if (fVar.sGf != null) {
                    fVar.sGf.setVisibility(0);
                }
                fVar.sGg.setVisibility(0);
                fVar.sGh.setVisibility(8);
                bzs bzs = (bzs) chw.wiH.get(0);
                fVar.sGi.setTag(bzs);
                fVar.mLM.setText(bzs.cEh);
                fVar.mLM.setVisibility(0);
                fVar.sGi.setVisibility(0);
                fVar.sGk.setVisibility(8);
                if (!bo.isNullOrNil(bzs.cIY)) {
                    o.ahp().a(bzs.cIY, fVar.sGk, com.tencent.mm.plugin.topstory.ui.c.sBn);
                    fVar.sGk.setVisibility(0);
                }
                if (chw.wiH.size() > 1) {
                    bzs = (bzs) chw.wiH.get(1);
                    fVar.sGj.setTag(bzs);
                    fVar.mLN.setText(bzs.cEh);
                    fVar.mLN.setVisibility(0);
                    fVar.sGj.setVisibility(0);
                    fVar.sGl.setVisibility(8);
                    if (!bo.isNullOrNil(bzs.cIY)) {
                        o.ahp().a(bzs.cIY, fVar.sGl, com.tencent.mm.plugin.topstory.ui.c.sBn);
                        fVar.sGl.setVisibility(0);
                    }
                } else {
                    fVar.sGj.setVisibility(8);
                    fVar.mLN.setVisibility(8);
                }
            } else {
                if (fVar.sGf != null) {
                    fVar.sGf.setVisibility(8);
                }
                fVar.sGg.setVisibility(8);
            }
            fVar.h(chw);
            if (fVar.sFT) {
                fVar.sGg.setVisibility(8);
                fVar.sFX.setVisibility(8);
            }
            if (!(fVar.sGm == null || fVar.qeX == null || fVar.sDW == null)) {
                fVar.sGm.setVisibility(8);
                fVar.qeX.setVisibility(8);
                fVar.sDW.setVisibility(8);
                if (!bo.isNullOrNil(chw.source)) {
                    fVar.qeX.setText(chw.source);
                    fVar.qeX.setVisibility(0);
                    if (!bo.isNullOrNil(chw.phw)) {
                        fVar.sGm.setVisibility(0);
                    }
                    if (bo.isNullOrNil(chw.xgY)) {
                        fVar.sDW.setImageResource(R.drawable.ad2);
                    } else {
                        o.ahp().a(chw.xgY, fVar.sDW, com.tencent.mm.plugin.topstory.ui.c.sBm);
                    }
                    fVar.sDW.setVisibility(0);
                }
            }
            if (fVar.gne != null) {
                fVar.gne.setText(chw.title);
            }
        }
        if (!(getFSItemUIComponent() == null || getFSItemUIComponent().cFP() == getFSVideoUIComponent().cFY())) {
            if (getFSVideoUIComponent().cFQ().isConnected()) {
                cGq();
            } else {
                gE(getNoNetTip(), getContext().getString(R.string.f1r));
            }
        }
        if (this.gne != null) {
            this.gne.setText(this.sAX.title);
        }
        AppMethodBeat.o(1915);
    }

    public final com.tencent.mm.pluginsdk.ui.h.d getScaleType() {
        AppMethodBeat.i(1916);
        com.tencent.mm.pluginsdk.ui.h.d dVar;
        if (this.sDo.cGb()) {
            dVar = com.tencent.mm.pluginsdk.ui.h.d.COVER;
            AppMethodBeat.o(1916);
            return dVar;
        }
        dVar = com.tencent.mm.pluginsdk.ui.h.d.CONTAIN;
        AppMethodBeat.o(1916);
        return dVar;
    }

    public final void cGs() {
        AppMethodBeat.i(1917);
        if (this.sFK != null) {
            this.sFK.setVisibility(8);
        }
        AppMethodBeat.o(1917);
    }

    public final void cGw() {
        AppMethodBeat.i(1918);
        if (this.sFK != null) {
            this.sFK.show();
        }
        AppMethodBeat.o(1918);
    }

    public final b getVideoViewCallback() {
        return this.sFS;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(1919);
        if (this.sFL != null) {
            this.sFL.z(motionEvent);
        }
        AppMethodBeat.o(1919);
        return true;
    }

    private boolean aFf() {
        AppMethodBeat.i(1920);
        if (this.sDz.getVisibility() == 0) {
            AppMethodBeat.o(1920);
            return true;
        }
        AppMethodBeat.o(1920);
        return false;
    }

    public final f getControlBar() {
        return this.sFK;
    }

    public final chw getVideoInfo() {
        return this.sAX;
    }

    public final com.tencent.mm.plugin.topstory.ui.video.b getFSVideoUIComponent() {
        return this.sDo;
    }

    public final a getFSItemUIComponent() {
        return (a) this.sDG;
    }

    public final void setOnlyFS(boolean z) {
        AppMethodBeat.i(1921);
        this.sFT = z;
        if (this.sFK != null) {
            this.sFK.setOnlyFS(z);
        }
        AppMethodBeat.o(1921);
    }

    static /* synthetic */ boolean U(e eVar) {
        AppMethodBeat.i(1923);
        if (eVar.aFf()) {
            AppMethodBeat.o(1923);
            return false;
        }
        AppMethodBeat.o(1923);
        return true;
    }
}
