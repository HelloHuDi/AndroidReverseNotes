package com.tencent.p177mm.plugin.topstory.p541ui.video.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sight.decode.p512ui.C3855b;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C46297h;
import com.tencent.p177mm.plugin.topstory.p539a.p1414b.C29428a;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13953c;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13963k;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C35305f;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C35305f.C13955a;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46304a;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46927h;
import com.tencent.p177mm.plugin.topstory.p541ui.video.list.C39989g.C39990a;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C29735b;
import com.tencent.p177mm.plugin.websearch.p1066ui.C14430a;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.protocal.protobuf.chy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f */
public final class C46310f extends C35305f {
    private boolean isLoading;
    private C13963k sFL;
    private OnClickListener sFM;
    private C23324b sFS = new C399876();
    private C39989g sGU;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$8 */
    class C139768 implements C3855b {
        C139768() {
        }

        public final void aFw() {
            AppMethodBeat.m2504i(2050);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
            C46310f.this.sGU.cHd();
            AppMethodBeat.m2505o(2050);
        }

        /* renamed from: oA */
        public final void mo8552oA(int i) {
            AppMethodBeat.m2504i(2051);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", Integer.valueOf(i));
            C46310f.this.seekTo(i);
            C46310f.this.sGU.aFE();
            C14419a.m22633kT(22);
            AppMethodBeat.m2505o(2051);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$9 */
    class C139779 implements OnClickListener {
        C139779() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2052);
            if (!C46310f.this.getListVideoUIComponent().cFV().sFw) {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryListVideoContainer", "no video play now");
                AppMethodBeat.m2505o(2052);
            } else if (C46310f.this.sGU.getVideoTotalTime() - C46310f.this.sGU.getmPosition() < 2) {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryListVideoContainer", "cannot change play status in last 2 seconds");
                AppMethodBeat.m2505o(2052);
            } else {
                C46310f.this.getListVideoUIComponent().cFR().mo74507f(C46310f.this.sAX);
                if (C46310f.this.getListVideoUIComponent().cFV().cGZ()) {
                    C46310f.this.getListVideoUIComponent().cFV().cpN();
                    C46310f.this.sGU.cHd();
                } else {
                    C46310f.this.getListVideoUIComponent().cFV().cEf();
                    C46310f.this.sGU.aFE();
                }
                C46310f.this.cGp();
                AppMethodBeat.m2505o(2052);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$2 */
    class C224202 implements OnClickListener {
        C224202() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2036);
            if (C46310f.this.sDI == C13955a.MOBILE_NET) {
                C46310f.this.getListVideoUIComponent().cFQ().sEM = true;
                C46310f.this.sDo.mo9159FE(2);
            }
            if (C46310f.this.getListVideoUIComponent().cFQ().isConnected()) {
                C46310f.this.sDI = C13955a.UNKNOWN;
                if (C46310f.this.getListVideoUIComponent().cFV().sFw) {
                    C46310f.this.getListVideoUIComponent().cFV().cEf();
                    C46310f.this.cGp();
                } else {
                    C46310f.this.mo56045O(true, false);
                }
                C14419a.m22633kT(19);
                AppMethodBeat.m2505o(2036);
                return;
            }
            C14419a.m22633kT(20);
            AppMethodBeat.m2505o(2036);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$1 */
    class C294571 implements OnClickListener {
        C294571() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2035);
            C46310f.this.getListVideoUIComponent().aFH();
            AppMethodBeat.m2505o(2035);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$3 */
    class C294583 implements OnClickListener {
        C294583() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2037);
            C46310f.this.getListVideoUIComponent().cFR().sFo = 2;
            if (C46310f.this.getListItemUIComponent() == null || C46310f.this.getListItemUIComponent().cFP() != C46310f.this.getListVideoUIComponent().cFY()) {
                C46310f.this.getListVideoUIComponent().mo9157FC(C46310f.this.sDG.cFP());
                C46310f.this.getListVideoUIComponent().cFR().mo74507f(C46310f.this.sAX);
                ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(C46310f.this.getListVideoUIComponent().cFT(), C46310f.this.sAX, C46310f.this.sDG.cFP(), 2, "");
                AppMethodBeat.m2505o(2037);
                return;
            }
            C46310f.this.mo56045O(!C46310f.this.getListVideoUIComponent().cFQ().sEM, false);
            AppMethodBeat.m2505o(2037);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$4 */
    class C399864 implements OnClickListener {
        C399864() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2038);
            C46310f.this.cGv();
            C46310f.this.sGU.aFE();
            C46310f.this.getListVideoUIComponent().cFR().sFo = 2;
            C46310f.this.getListVideoUIComponent().cFV().mo63216a(C46310f.this.getListVideoUIComponent(), C46310f.this.sAX, C46310f.this.cvF, C46310f.this.sDG.cFP());
            C46310f.this.cGp();
            AppMethodBeat.m2505o(2038);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$6 */
    class C399876 implements C23324b {

        /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$6$1 */
        class C139751 implements Runnable {
            C139751() {
            }

            public final void run() {
                AppMethodBeat.m2504i(2040);
                C46310f.this.mo56045O(true, true);
                AppMethodBeat.m2505o(2040);
            }
        }

        C399876() {
        }

        /* renamed from: c */
        public final void mo9209c(String str, String str2, String str3, int i, int i2) {
            int i3 = 0;
            AppMethodBeat.m2504i(2041);
            C4990ab.m7413e("MicroMsg.TopStory.TopStoryListVideoContainer", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i), Integer.valueOf(i2));
            if (i != 0) {
                chw FL = C46310f.this.sDo.cGg().mo26218FL(C46310f.this.sDo.cFY());
                if (!(FL == null || FL.xhb == null)) {
                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", Integer.valueOf(i), Integer.valueOf(FL.xhb.size()), FL.videoUrl, Integer.valueOf(FL.xhg));
                    int i4 = 0;
                    while (i4 < FL.xhb.size()) {
                        if (!FL.videoUrl.equals(((chy) FL.xhb.get(i4)).url)) {
                            i4++;
                        } else if (i4 + 1 < FL.xhb.size()) {
                            chy chy = (chy) FL.xhb.get(i4 + 1);
                            if (!(chy == null || C5046bo.isNullOrNil(chy.url))) {
                                FL.xhg = chy.xhg;
                                FL.videoUrl = chy.url;
                                C4990ab.m7417i("MicroMsg.TopStory.TopStoryListVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", Integer.valueOf(i4), chy.url, Integer.valueOf(chy.xhg));
                                C29735b.m47142kT(C29735b.ubZ);
                                C46310f.this.postDelayed(new C139751(), 100);
                                AppMethodBeat.m2505o(2041);
                                return;
                            }
                        }
                    }
                }
            }
            C46310f.this.sDo.cGg().mo26220a(C46310f.this.sDo.cFT(), C46310f.this.sDo.cFY());
            C46310f.this.mo56052gE(C46310f.this.getContext().getString(C25738R.string.f13, new Object[]{i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2}), C46310f.this.getContext().getString(C25738R.string.f1r));
            C46310f.this.getListVideoUIComponent().cFV().onError(str);
            C46297h.m86860Fz(i);
            C29428a c29428a = C46310f.this.getListVideoUIComponent().cFR().sFp;
            if (c29428a != null && c29428a.sAE > 0) {
                i3 = ((int) (System.currentTimeMillis() - c29428a.sAE)) / 1000;
            }
            C46297h.m86865a(C46310f.this.sAX, i, str3, i3);
            AppMethodBeat.m2505o(2041);
        }

        /* renamed from: cp */
        public final void mo9210cp(String str, String str2) {
            AppMethodBeat.m2504i(2042);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryListVideoContainer", "onPrepared");
            C46310f.this.sFL.aFY();
            if (!C46310f.this.isLoading) {
                C46310f.this.cGp();
            }
            AppMethodBeat.m2505o(2042);
        }

        /* renamed from: cq */
        public final void mo9211cq(String str, String str2) {
            AppMethodBeat.m2504i(2043);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoEnded, pos:%s, listpos:%s", Integer.valueOf(C46310f.this.sDG.cFP()), Integer.valueOf(C46310f.this.sDG.cFP()));
            C46310f.this.getListVideoUIComponent().cFV().abK(str);
            C46310f.this.getListVideoUIComponent().cFR().sFo = 1;
            if (!C46310f.this.getListVideoUIComponent().mo9157FC(C46310f.this.sDG.cFP() + 1) && (C46310f.this.sDG instanceof C46927h)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                ((C46927h) C46310f.this.sDG).mo47707mc(true);
            }
            C46310f.this.sGU.setVisibility(8);
            C46310f.this.isLoading = false;
            AppMethodBeat.m2505o(2043);
        }

        /* renamed from: d */
        public final void mo9216d(String str, String str2, int i, int i2) {
            AppMethodBeat.m2504i(2044);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryListVideoContainer", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(2044);
        }

        /* renamed from: cr */
        public final void mo9212cr(String str, String str2) {
        }

        /* renamed from: cs */
        public final void mo9213cs(String str, String str2) {
        }

        /* renamed from: ct */
        public final void mo9214ct(String str, String str2) {
            AppMethodBeat.m2504i(2045);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaiting");
            C46310f.this.isLoading = true;
            AppMethodBeat.m2505o(2045);
        }

        /* renamed from: cu */
        public final void mo9215cu(String str, String str2) {
            AppMethodBeat.m2504i(2046);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryListVideoContainer", "onVideoWaitingEnd");
            C46310f.this.isLoading = false;
            C46310f.this.sGU.setVisibility(8);
            C46310f.this.cGp();
            C29428a c29428a = C46310f.this.getListVideoUIComponent().cFR().sFp;
            if (c29428a != null && c29428a.sAP == 0) {
                c29428a.sAP = System.currentTimeMillis() - c29428a.sAE;
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryListVideoContainer", "FirstLoadTime %d %d", Long.valueOf(c29428a.sAM), Long.valueOf(c29428a.sAP));
            }
            AppMethodBeat.m2505o(2046);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$a */
    class C39988a implements C13953c {
        private float sFW;

        C39988a() {
            AppMethodBeat.m2504i(2053);
            this.sFW = (float) C1338a.m2869ge(C46310f.this.getContext());
            AppMethodBeat.m2505o(2053);
        }

        public final void aFi() {
            AppMethodBeat.m2504i(2054);
            C4990ab.m7410d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
            if (C46310f.m86929N(C46310f.this)) {
                Object obj;
                if (C46310f.this.sGU.getVisibility() == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    C46310f.this.sGU.setVisibility(8);
                    AppMethodBeat.m2505o(2054);
                    return;
                }
                C46310f.this.sGU.show();
                if (C46310f.this.getListItemUIComponent() != null) {
                    C46310f.this.getListItemUIComponent().cFO();
                    C46310f.this.getListItemUIComponent().cFN();
                }
            }
            AppMethodBeat.m2505o(2054);
        }

        public final void aFj() {
            AppMethodBeat.m2504i(2055);
            C4990ab.m7410d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
            AppMethodBeat.m2505o(2055);
        }

        public final void aFk() {
            AppMethodBeat.m2504i(2056);
            C46310f.this.sDq.setVisibility(0);
            C46310f.this.sGU.cHe();
            AppMethodBeat.m2505o(2056);
        }

        /* renamed from: be */
        public final int mo26183be(float f) {
            AppMethodBeat.m2504i(2057);
            float f2 = f / this.sFW;
            int videoDurationSec = C46310f.this.getListVideoUIComponent().cFV().getVideoDurationSec();
            int currentPosition = ((int) (f2 * ((float) videoDurationSec))) + getCurrentPosition();
            if (currentPosition < 0) {
                currentPosition = 0;
            } else if (currentPosition > videoDurationSec) {
                currentPosition = videoDurationSec;
            }
            C46310f.this.sDq.setText(C14430a.m22663fQ(((long) currentPosition) * 1000) + "/" + C14430a.m22663fQ(((long) videoDurationSec) * 1000));
            AppMethodBeat.m2505o(2057);
            return currentPosition;
        }

        /* renamed from: FF */
        public final void mo26179FF(int i) {
            AppMethodBeat.m2504i(2058);
            C46310f.this.sGU.cHf();
            C46310f.this.sDq.setVisibility(8);
            C46310f.this.seekTo(i);
            AppMethodBeat.m2505o(2058);
        }

        public final boolean cGl() {
            AppMethodBeat.m2504i(2059);
            if (C46310f.m86933R(C46310f.this)) {
                AppMethodBeat.m2505o(2059);
                return false;
            }
            AppMethodBeat.m2505o(2059);
            return true;
        }

        public final int getCurrentPosition() {
            AppMethodBeat.m2504i(2060);
            int currPosSec = C46310f.this.getListVideoUIComponent().cFV().getCurrPosSec();
            AppMethodBeat.m2505o(2060);
            return currPosSec;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$5 */
    class C463085 implements OnClickListener {
        C463085() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2039);
            if (!(C46310f.this.getListItemUIComponent() == null || C46310f.this.getListItemUIComponent().cFP() == C46310f.this.getListVideoUIComponent().cFY())) {
                C46310f.this.getListVideoUIComponent().cFR().sFo = 2;
                C46310f.this.getListVideoUIComponent().mo9157FC(C46310f.this.sDG.cFP());
                C46310f.this.getListVideoUIComponent().cFR().mo74507f(C46310f.this.sAX);
                ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(C46310f.this.getListVideoUIComponent().cFT(), C46310f.this.sAX, C46310f.this.sDG.cFP(), 2, "");
            }
            AppMethodBeat.m2505o(2039);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.f$7 */
    class C463097 implements C39990a {
        C463097() {
        }

        public final void update(int i, int i2) {
            int width;
            AppMethodBeat.m2504i(2047);
            if (i2 > 0) {
                width = (C46310f.this.sDF.getWidth() * i) / i2;
            } else {
                width = 0;
            }
            C29428a c29428a = C46310f.this.getListVideoUIComponent().cFR().sFp;
            if (c29428a != null && c29428a.sAH < ((long) C46310f.this.getListVideoUIComponent().cFV().getCurrPosMs())) {
                c29428a.sAH = (long) C46310f.this.getListVideoUIComponent().cFV().getCurrPosMs();
            }
            LayoutParams layoutParams = (LayoutParams) C46310f.this.sDE.getLayoutParams();
            layoutParams.width = width;
            C46310f.this.sDE.setLayoutParams(layoutParams);
            C46310f.this.sDE.requestLayout();
            if (C46310f.this.sAX.xhf <= 0 && (C46310f.this.sAX.xhd & 256) <= 0 && C46310f.this.sDo.mo9189fS(i, i2)) {
                C46310f.this.sAX.xhf = 1;
            }
            AppMethodBeat.m2505o(2047);
        }

        public final void cHb() {
            AppMethodBeat.m2504i(2048);
            C46310f.this.sDD.setVisibility(8);
            AppMethodBeat.m2505o(2048);
        }

        public final void cHc() {
            AppMethodBeat.m2504i(2049);
            if (C46310f.this.getListVideoUIComponent().cFV().sFw && (C46310f.this.getListVideoUIComponent().cFV().cGZ() || C46310f.this.getListVideoUIComponent().cFV().sFx)) {
                C46310f.this.sDD.setVisibility(0);
                AppMethodBeat.m2505o(2049);
                return;
            }
            C46310f.this.sDD.setVisibility(8);
            AppMethodBeat.m2505o(2049);
        }
    }

    /* renamed from: R */
    static /* synthetic */ boolean m86933R(C46310f c46310f) {
        AppMethodBeat.m2504i(2074);
        boolean aFf = c46310f.aFf();
        AppMethodBeat.m2505o(2074);
        return aFf;
    }

    public C46310f(Context context, C4232b c4232b, C46304a c46304a) {
        super(context, c4232b, c46304a);
        AppMethodBeat.m2504i(2061);
        AppMethodBeat.m2505o(2061);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    public final int getLayoutId() {
        return 2130970954;
    }

    public final void init() {
        AppMethodBeat.m2504i(2062);
        super.init();
        this.sFM = new C294571();
        this.sDv.setOnClickListener(new C224202());
        this.sDt.setOnClickListener(new C294583());
        this.sDu.setOnClickListener(new C399864());
        this.sDz.setOnClickListener(new C463085());
        this.sFL = new C13963k(getContext(), this, new C39988a());
        this.sGU = new C39989g(getContext());
        this.sGU.setVisibility(8);
        this.sGU.setFullScreenBtnClickListener(this.sFM);
        this.sGU.setOnUpdateProgressLenListener(new C463097());
        this.sGU.setIplaySeekCallback(new C139768());
        this.sGU.setOnPlayButtonClickListener(new C139779());
        AppMethodBeat.m2505o(2062);
    }

    public final void cGp() {
        AppMethodBeat.m2504i(2063);
        super.cGp();
        AppMethodBeat.m2505o(2063);
    }

    public final void cGn() {
        AppMethodBeat.m2504i(2064);
        C4990ab.m7410d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
        this.sDz.setVisibility(8);
        this.kuG.setVisibility(0);
        this.sDq.setVisibility(8);
        this.sDp.setVisibility(8);
        this.sDD.setVisibility(8);
        AppMethodBeat.m2505o(2064);
    }

    public final void cGo() {
        AppMethodBeat.m2504i(2065);
        C4990ab.m7410d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
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
        AppMethodBeat.m2505o(2065);
    }

    /* renamed from: O */
    public final boolean mo56045O(boolean z, boolean z2) {
        AppMethodBeat.m2504i(2066);
        boolean O = super.mo56045O(z, z2);
        getListVideoUIComponent().cFV().setMute(getListVideoUIComponent().mo9156DX());
        AppMethodBeat.m2505o(2066);
        return O;
    }

    public final void cGt() {
        AppMethodBeat.m2504i(2067);
        C39989g c39989g = this.sGU;
        if (c39989g.sGn != null) {
            c39989g.sGn.stopTimer();
        }
        AppMethodBeat.m2505o(2067);
    }

    /* renamed from: cu */
    public final void mo47684cu() {
        AppMethodBeat.m2504i(2068);
        super.mo47684cu();
        if (this.sGU != null) {
            this.sGU.setVideoTotalTime(this.sAX.xgR);
        }
        if (!(getListItemUIComponent() == null || getListItemUIComponent().cFP() == getListVideoUIComponent().cFY())) {
            if (getListVideoUIComponent().cFQ().isConnected()) {
                cGq();
                AppMethodBeat.m2505o(2068);
                return;
            }
            mo56052gE(getNoNetTip(), getContext().getString(C25738R.string.f1r));
        }
        AppMethodBeat.m2505o(2068);
    }

    public final C35873d getScaleType() {
        return C35873d.CONTAIN;
    }

    public final void cGs() {
        AppMethodBeat.m2504i(2069);
        if (this.sGU != null) {
            this.sGU.setVisibility(8);
        }
        AppMethodBeat.m2505o(2069);
    }

    public final C23324b getVideoViewCallback() {
        return this.sFS;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(2070);
        if (this.sFL != null) {
            this.sFL.mo26196z(motionEvent);
        }
        AppMethodBeat.m2505o(2070);
        return true;
    }

    private boolean aFf() {
        AppMethodBeat.m2504i(2071);
        if (this.sDz.getVisibility() == 0) {
            AppMethodBeat.m2505o(2071);
            return true;
        }
        AppMethodBeat.m2505o(2071);
        return false;
    }

    public final C39989g getControlBar() {
        return this.sGU;
    }

    public final chw getVideoInfo() {
        return this.sAX;
    }

    public final C13969b getListVideoUIComponent() {
        return (C13969b) this.sDo;
    }

    public final C29455a getListItemUIComponent() {
        return (C29455a) this.sDG;
    }

    /* renamed from: N */
    static /* synthetic */ boolean m86929N(C46310f c46310f) {
        AppMethodBeat.m2504i(2073);
        if (c46310f.aFf()) {
            AppMethodBeat.m2505o(2073);
            return false;
        }
        AppMethodBeat.m2505o(2073);
        return true;
    }
}
