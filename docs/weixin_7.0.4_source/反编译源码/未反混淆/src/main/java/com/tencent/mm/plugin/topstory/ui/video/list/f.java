package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class f extends com.tencent.mm.plugin.topstory.ui.video.f {
    private boolean isLoading;
    private k sFL;
    private OnClickListener sFM;
    private b sFS = new b() {
        public final void c(String str, String str2, String str3, int i, int i2) {
            int i3 = 0;
            AppMethodBeat.i(2041);
            ab.e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i), Integer.valueOf(i2));
            if (i != 0) {
                chw FL = f.this.sDo.cGg().FL(f.this.sDo.cFY());
                if (!(FL == null || FL.xhb == null)) {
                    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", Integer.valueOf(i), Integer.valueOf(FL.xhb.size()), FL.videoUrl, Integer.valueOf(FL.xhg));
                    int i4 = 0;
                    while (i4 < FL.xhb.size()) {
                        if (!FL.videoUrl.equals(((chy) FL.xhb.get(i4)).url)) {
                            i4++;
                        } else if (i4 + 1 < FL.xhb.size()) {
                            chy chy = (chy) FL.xhb.get(i4 + 1);
                            if (!(chy == null || bo.isNullOrNil(chy.url))) {
                                FL.xhg = chy.xhg;
                                FL.videoUrl = chy.url;
                                ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", Integer.valueOf(i4), chy.url, Integer.valueOf(chy.xhg));
                                com.tencent.mm.plugin.websearch.api.a.b.kT(com.tencent.mm.plugin.websearch.api.a.b.ubZ);
                                f.this.postDelayed(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(2040);
                                        f.this.O(true, true);
                                        AppMethodBeat.o(2040);
                                    }
                                }, 100);
                                AppMethodBeat.o(2041);
                                return;
                            }
                        }
                    }
                }
            }
            f.this.sDo.cGg().a(f.this.sDo.cFT(), f.this.sDo.cFY());
            f.this.gE(f.this.getContext().getString(R.string.f13, new Object[]{i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2}), f.this.getContext().getString(R.string.f1r));
            f.this.getListVideoUIComponent().cFV().onError(str);
            h.Fz(i);
            com.tencent.mm.plugin.topstory.a.b.a aVar = f.this.getListVideoUIComponent().cFR().sFp;
            if (aVar != null && aVar.sAE > 0) {
                i3 = ((int) (System.currentTimeMillis() - aVar.sAE)) / 1000;
            }
            h.a(f.this.sAX, i, str3, i3);
            AppMethodBeat.o(2041);
        }

        public final void cp(String str, String str2) {
            AppMethodBeat.i(2042);
            ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
            f.this.sFL.aFY();
            if (!f.this.isLoading) {
                f.this.cGp();
            }
            AppMethodBeat.o(2042);
        }

        public final void cq(String str, String str2) {
            AppMethodBeat.i(2043);
            ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", Integer.valueOf(f.this.sDG.cFP()), Integer.valueOf(f.this.sDG.cFP()));
            f.this.getListVideoUIComponent().cFV().abK(str);
            f.this.getListVideoUIComponent().cFR().sFo = 1;
            if (!f.this.getListVideoUIComponent().FC(f.this.sDG.cFP() + 1) && (f.this.sDG instanceof com.tencent.mm.plugin.topstory.ui.video.h)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                ((com.tencent.mm.plugin.topstory.ui.video.h) f.this.sDG).mc(true);
            }
            f.this.sGU.setVisibility(8);
            f.this.isLoading = false;
            AppMethodBeat.o(2043);
        }

        public final void d(String str, String str2, int i, int i2) {
            AppMethodBeat.i(2044);
            ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(2044);
        }

        public final void cr(String str, String str2) {
        }

        public final void cs(String str, String str2) {
        }

        public final void ct(String str, String str2) {
            AppMethodBeat.i(2045);
            ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
            f.this.isLoading = true;
            AppMethodBeat.o(2045);
        }

        public final void cu(String str, String str2) {
            AppMethodBeat.i(2046);
            ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
            f.this.isLoading = false;
            f.this.sGU.setVisibility(8);
            f.this.cGp();
            com.tencent.mm.plugin.topstory.a.b.a aVar = f.this.getListVideoUIComponent().cFR().sFp;
            if (aVar != null && aVar.sAP == 0) {
                aVar.sAP = System.currentTimeMillis() - aVar.sAE;
                ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", Long.valueOf(aVar.sAM), Long.valueOf(aVar.sAP));
            }
            AppMethodBeat.o(2046);
        }
    };
    private g sGU;

    class a implements c {
        private float sFW;

        a() {
            AppMethodBeat.i(2053);
            this.sFW = (float) com.tencent.mm.bz.a.ge(f.this.getContext());
            AppMethodBeat.o(2053);
        }

        public final void aFi() {
            AppMethodBeat.i(2054);
            ab.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
            if (f.N(f.this)) {
                Object obj;
                if (f.this.sGU.getVisibility() == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    f.this.sGU.setVisibility(8);
                    AppMethodBeat.o(2054);
                    return;
                }
                f.this.sGU.show();
                if (f.this.getListItemUIComponent() != null) {
                    f.this.getListItemUIComponent().cFO();
                    f.this.getListItemUIComponent().cFN();
                }
            }
            AppMethodBeat.o(2054);
        }

        public final void aFj() {
            AppMethodBeat.i(2055);
            ab.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
            AppMethodBeat.o(2055);
        }

        public final void aFk() {
            AppMethodBeat.i(2056);
            f.this.sDq.setVisibility(0);
            f.this.sGU.cHe();
            AppMethodBeat.o(2056);
        }

        public final int be(float f) {
            AppMethodBeat.i(2057);
            float f2 = f / this.sFW;
            int videoDurationSec = f.this.getListVideoUIComponent().cFV().getVideoDurationSec();
            int currentPosition = ((int) (f2 * ((float) videoDurationSec))) + getCurrentPosition();
            if (currentPosition < 0) {
                currentPosition = 0;
            } else if (currentPosition > videoDurationSec) {
                currentPosition = videoDurationSec;
            }
            f.this.sDq.setText(com.tencent.mm.plugin.websearch.ui.a.fQ(((long) currentPosition) * 1000) + "/" + com.tencent.mm.plugin.websearch.ui.a.fQ(((long) videoDurationSec) * 1000));
            AppMethodBeat.o(2057);
            return currentPosition;
        }

        public final void FF(int i) {
            AppMethodBeat.i(2058);
            f.this.sGU.cHf();
            f.this.sDq.setVisibility(8);
            f.this.seekTo(i);
            AppMethodBeat.o(2058);
        }

        public final boolean cGl() {
            AppMethodBeat.i(2059);
            if (f.R(f.this)) {
                AppMethodBeat.o(2059);
                return false;
            }
            AppMethodBeat.o(2059);
            return true;
        }

        public final int getCurrentPosition() {
            AppMethodBeat.i(2060);
            int currPosSec = f.this.getListVideoUIComponent().cFV().getCurrPosSec();
            AppMethodBeat.o(2060);
            return currPosSec;
        }
    }

    static /* synthetic */ boolean R(f fVar) {
        AppMethodBeat.i(2074);
        boolean aFf = fVar.aFf();
        AppMethodBeat.o(2074);
        return aFf;
    }

    public f(Context context, com.tencent.mm.plugin.topstory.ui.video.b bVar, com.tencent.mm.plugin.topstory.ui.video.a aVar) {
        super(context, bVar, aVar);
        AppMethodBeat.i(2061);
        AppMethodBeat.o(2061);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    public final int getLayoutId() {
        return R.layout.b0e;
    }

    public final void init() {
        AppMethodBeat.i(2062);
        super.init();
        this.sFM = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2035);
                f.this.getListVideoUIComponent().aFH();
                AppMethodBeat.o(2035);
            }
        };
        this.sDv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2036);
                if (f.this.sDI == com.tencent.mm.plugin.topstory.ui.video.f.a.MOBILE_NET) {
                    f.this.getListVideoUIComponent().cFQ().sEM = true;
                    f.this.sDo.FE(2);
                }
                if (f.this.getListVideoUIComponent().cFQ().isConnected()) {
                    f.this.sDI = com.tencent.mm.plugin.topstory.ui.video.f.a.UNKNOWN;
                    if (f.this.getListVideoUIComponent().cFV().sFw) {
                        f.this.getListVideoUIComponent().cFV().cEf();
                        f.this.cGp();
                    } else {
                        f.this.O(true, false);
                    }
                    com.tencent.mm.plugin.websearch.api.a.a.kT(19);
                    AppMethodBeat.o(2036);
                    return;
                }
                com.tencent.mm.plugin.websearch.api.a.a.kT(20);
                AppMethodBeat.o(2036);
            }
        });
        this.sDt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2037);
                f.this.getListVideoUIComponent().cFR().sFo = 2;
                if (f.this.getListItemUIComponent() == null || f.this.getListItemUIComponent().cFP() != f.this.getListVideoUIComponent().cFY()) {
                    f.this.getListVideoUIComponent().FC(f.this.sDG.cFP());
                    f.this.getListVideoUIComponent().cFR().f(f.this.sAX);
                    ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().cFT(), f.this.sAX, f.this.sDG.cFP(), 2, "");
                    AppMethodBeat.o(2037);
                    return;
                }
                f.this.O(!f.this.getListVideoUIComponent().cFQ().sEM, false);
                AppMethodBeat.o(2037);
            }
        });
        this.sDu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2038);
                f.this.cGv();
                f.this.sGU.aFE();
                f.this.getListVideoUIComponent().cFR().sFo = 2;
                f.this.getListVideoUIComponent().cFV().a(f.this.getListVideoUIComponent(), f.this.sAX, f.this.cvF, f.this.sDG.cFP());
                f.this.cGp();
                AppMethodBeat.o(2038);
            }
        });
        this.sDz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2039);
                if (!(f.this.getListItemUIComponent() == null || f.this.getListItemUIComponent().cFP() == f.this.getListVideoUIComponent().cFY())) {
                    f.this.getListVideoUIComponent().cFR().sFo = 2;
                    f.this.getListVideoUIComponent().FC(f.this.sDG.cFP());
                    f.this.getListVideoUIComponent().cFR().f(f.this.sAX);
                    ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().cFT(), f.this.sAX, f.this.sDG.cFP(), 2, "");
                }
                AppMethodBeat.o(2039);
            }
        });
        this.sFL = new k(getContext(), this, new a());
        this.sGU = new g(getContext());
        this.sGU.setVisibility(8);
        this.sGU.setFullScreenBtnClickListener(this.sFM);
        this.sGU.setOnUpdateProgressLenListener(new com.tencent.mm.plugin.topstory.ui.video.list.g.a() {
            public final void update(int i, int i2) {
                int width;
                AppMethodBeat.i(2047);
                if (i2 > 0) {
                    width = (f.this.sDF.getWidth() * i) / i2;
                } else {
                    width = 0;
                }
                com.tencent.mm.plugin.topstory.a.b.a aVar = f.this.getListVideoUIComponent().cFR().sFp;
                if (aVar != null && aVar.sAH < ((long) f.this.getListVideoUIComponent().cFV().getCurrPosMs())) {
                    aVar.sAH = (long) f.this.getListVideoUIComponent().cFV().getCurrPosMs();
                }
                LayoutParams layoutParams = (LayoutParams) f.this.sDE.getLayoutParams();
                layoutParams.width = width;
                f.this.sDE.setLayoutParams(layoutParams);
                f.this.sDE.requestLayout();
                if (f.this.sAX.xhf <= 0 && (f.this.sAX.xhd & 256) <= 0 && f.this.sDo.fS(i, i2)) {
                    f.this.sAX.xhf = 1;
                }
                AppMethodBeat.o(2047);
            }

            public final void cHb() {
                AppMethodBeat.i(2048);
                f.this.sDD.setVisibility(8);
                AppMethodBeat.o(2048);
            }

            public final void cHc() {
                AppMethodBeat.i(2049);
                if (f.this.getListVideoUIComponent().cFV().sFw && (f.this.getListVideoUIComponent().cFV().cGZ() || f.this.getListVideoUIComponent().cFV().sFx)) {
                    f.this.sDD.setVisibility(0);
                    AppMethodBeat.o(2049);
                    return;
                }
                f.this.sDD.setVisibility(8);
                AppMethodBeat.o(2049);
            }
        });
        this.sGU.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void aFw() {
                AppMethodBeat.i(2050);
                ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
                f.this.sGU.cHd();
                AppMethodBeat.o(2050);
            }

            public final void oA(int i) {
                AppMethodBeat.i(2051);
                ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", Integer.valueOf(i));
                f.this.seekTo(i);
                f.this.sGU.aFE();
                com.tencent.mm.plugin.websearch.api.a.a.kT(22);
                AppMethodBeat.o(2051);
            }
        });
        this.sGU.setOnPlayButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2052);
                if (!f.this.getListVideoUIComponent().cFV().sFw) {
                    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
                    AppMethodBeat.o(2052);
                } else if (f.this.sGU.getVideoTotalTime() - f.this.sGU.getmPosition() < 2) {
                    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
                    AppMethodBeat.o(2052);
                } else {
                    f.this.getListVideoUIComponent().cFR().f(f.this.sAX);
                    if (f.this.getListVideoUIComponent().cFV().cGZ()) {
                        f.this.getListVideoUIComponent().cFV().cpN();
                        f.this.sGU.cHd();
                    } else {
                        f.this.getListVideoUIComponent().cFV().cEf();
                        f.this.sGU.aFE();
                    }
                    f.this.cGp();
                    AppMethodBeat.o(2052);
                }
            }
        });
        AppMethodBeat.o(2062);
    }

    public final void cGp() {
        AppMethodBeat.i(2063);
        super.cGp();
        AppMethodBeat.o(2063);
    }

    public final void cGn() {
        AppMethodBeat.i(2064);
        ab.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
        this.sDz.setVisibility(8);
        this.kuG.setVisibility(0);
        this.sDq.setVisibility(8);
        this.sDp.setVisibility(8);
        this.sDD.setVisibility(8);
        AppMethodBeat.o(2064);
    }

    public final void cGo() {
        AppMethodBeat.i(2065);
        ab.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
        this.sDz.setVisibility(0);
        this.kuG.setVisibility(0);
        this.sDq.setVisibility(8);
        this.sDp.setVisibility(8);
        this.sDD.setVisibility(8);
        this.sDB.setVisibility(0);
        this.sDA.setVisibility(8);
        this.sDt.setVisibility(0);
        this.sDu.setVisibility(8);
        this.sDx.setVisibility(8);
        AppMethodBeat.o(2065);
    }

    public final boolean O(boolean z, boolean z2) {
        AppMethodBeat.i(2066);
        boolean O = super.O(z, z2);
        getListVideoUIComponent().cFV().setMute(getListVideoUIComponent().DX());
        AppMethodBeat.o(2066);
        return O;
    }

    public final void cGt() {
        AppMethodBeat.i(2067);
        g gVar = this.sGU;
        if (gVar.sGn != null) {
            gVar.sGn.stopTimer();
        }
        AppMethodBeat.o(2067);
    }

    public final void cu() {
        AppMethodBeat.i(2068);
        super.cu();
        if (this.sGU != null) {
            this.sGU.setVideoTotalTime(this.sAX.xgR);
        }
        if (!(getListItemUIComponent() == null || getListItemUIComponent().cFP() == getListVideoUIComponent().cFY())) {
            if (getListVideoUIComponent().cFQ().isConnected()) {
                cGq();
                AppMethodBeat.o(2068);
                return;
            }
            gE(getNoNetTip(), getContext().getString(R.string.f1r));
        }
        AppMethodBeat.o(2068);
    }

    public final d getScaleType() {
        return d.CONTAIN;
    }

    public final void cGs() {
        AppMethodBeat.i(2069);
        if (this.sGU != null) {
            this.sGU.setVisibility(8);
        }
        AppMethodBeat.o(2069);
    }

    public final b getVideoViewCallback() {
        return this.sFS;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(2070);
        if (this.sFL != null) {
            this.sFL.z(motionEvent);
        }
        AppMethodBeat.o(2070);
        return true;
    }

    private boolean aFf() {
        AppMethodBeat.i(2071);
        if (this.sDz.getVisibility() == 0) {
            AppMethodBeat.o(2071);
            return true;
        }
        AppMethodBeat.o(2071);
        return false;
    }

    public final g getControlBar() {
        return this.sGU;
    }

    public final chw getVideoInfo() {
        return this.sAX;
    }

    public final b getListVideoUIComponent() {
        return (b) this.sDo;
    }

    public final a getListItemUIComponent() {
        return (a) this.sDG;
    }

    static /* synthetic */ boolean N(f fVar) {
        AppMethodBeat.i(2073);
        if (fVar.aFf()) {
            AppMethodBeat.o(2073);
            return false;
        }
        AppMethodBeat.o(2073);
        return true;
    }
}
