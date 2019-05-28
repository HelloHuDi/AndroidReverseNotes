package com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sight.decode.p512ui.C3855b;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.C46297h;
import com.tencent.p177mm.plugin.topstory.p539a.p1414b.C29428a;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13953c;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13963k;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C35305f;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C35305f.C13955a;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46304a;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C46927h;
import com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs.C22411f.C4238a;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C14419a;
import com.tencent.p177mm.plugin.websearch.api.p1062a.C29735b;
import com.tencent.p177mm.plugin.websearch.p1066ui.C14430a;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.protocal.protobuf.bzs;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.protocal.protobuf.chy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e */
public final class C29445e extends C35305f {
    private boolean isLoading;
    private C22411f sFK;
    private C13963k sFL;
    private OnClickListener sFM;
    private OnClickListener sFN;
    private OnClickListener sFO;
    private OnClickListener sFP;
    private OnClickListener sFQ;
    private OnClickListener sFR;
    private C23324b sFS = new C42363();
    public boolean sFT;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$1 */
    class C42351 implements OnClickListener {
        C42351() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1877);
            C29445e.this.getFSVideoUIComponent().cGf();
            AppMethodBeat.m2505o(1877);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$3 */
    class C42363 implements C23324b {

        /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$3$1 */
        class C42371 implements Runnable {
            C42371() {
            }

            public final void run() {
                AppMethodBeat.m2504i(1879);
                C29445e.this.mo56045O(true, true);
                AppMethodBeat.m2505o(1879);
            }
        }

        C42363() {
        }

        /* renamed from: c */
        public final void mo9209c(String str, String str2, String str3, int i, int i2) {
            int i3 = 0;
            AppMethodBeat.m2504i(1880);
            C4990ab.m7413e("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i), Integer.valueOf(i2));
            chw FL = C29445e.this.sDo.cGg().mo26218FL(C29445e.this.sDo.cFY());
            if (!(FL == null || FL.xhb == null)) {
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url, errno:%s, urlListSize:%s, curUrl:%s, curVt:%s", Integer.valueOf(i), Integer.valueOf(FL.xhb.size()), FL.videoUrl, Integer.valueOf(FL.xhg));
                int i4 = 0;
                while (i4 < FL.xhb.size()) {
                    if (!FL.videoUrl.equals(((chy) FL.xhb.get(i4)).url)) {
                        i4++;
                    } else if (i4 + 1 < FL.xhb.size()) {
                        chy chy = (chy) FL.xhb.get(i4 + 1);
                        if (!(chy == null || C5046bo.isNullOrNil(chy.url))) {
                            FL.xhg = chy.xhg;
                            FL.videoUrl = chy.url;
                            C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onError, change url succ, nextIndex:%s, nextUrl:%s, nextVt:%s", Integer.valueOf(i4), chy.url, Integer.valueOf(chy.xhg));
                            C29735b.m47142kT(C29735b.ubZ);
                            C29445e.this.postDelayed(new C42371(), 100);
                            AppMethodBeat.m2505o(1880);
                            return;
                        }
                    }
                }
            }
            C29445e.this.sDo.cGg().mo26220a(C29445e.this.sDo.cFT(), C29445e.this.sDo.cFY());
            C29445e.this.mo56052gE(C29445e.this.getContext().getString(C25738R.string.f13, new Object[]{i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2}), C29445e.this.getContext().getString(C25738R.string.f1r));
            C29445e.this.getFSVideoUIComponent().cFV().onError(str);
            C46297h.m86860Fz(i);
            C29428a c29428a = C29445e.this.getFSVideoUIComponent().cFR().sFp;
            if (c29428a != null && c29428a.sAE > 0) {
                i3 = ((int) (System.currentTimeMillis() - c29428a.sAE)) / 1000;
            }
            C46297h.m86865a(FL, i, str3, i3);
            AppMethodBeat.m2505o(1880);
        }

        /* renamed from: cp */
        public final void mo9210cp(String str, String str2) {
            AppMethodBeat.m2504i(1881);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onPrepared");
            C29445e.this.sFL.aFY();
            if (!C29445e.this.isLoading) {
                C29445e.this.cGp();
            }
            AppMethodBeat.m2505o(1881);
        }

        /* renamed from: cq */
        public final void mo9211cq(String str, String str2) {
            boolean z;
            AppMethodBeat.m2504i(1882);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoEnded");
            C29445e.this.getFSVideoUIComponent().cFV().abK(str);
            C29445e.this.getFSVideoUIComponent().cFR().sFo = 1;
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoContainer", "clicfg_topstory_v_video_play  %s", Integer.valueOf(C29445e.this.getFSVideoUIComponent().cGk()));
            if (C29445e.this.getFSVideoUIComponent().cGk() == 1 && C29445e.this.getFSVideoUIComponent().cGb() && (C29445e.this.sDG instanceof C39983j)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                ((C39983j) C29445e.this.sDG).mo47707mc(true);
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoContainer", "VVideoAutoPlay replay succ");
                z = true;
            } else {
                z = C29445e.this.getFSVideoUIComponent().mo9157FC(C29445e.this.sDG.cFP() + 1);
            }
            if (!z && (C29445e.this.sDG instanceof C46927h)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e2) {
                }
                ((C46927h) C29445e.this.sDG).mo47707mc(true);
            }
            C29445e.this.isLoading = false;
            AppMethodBeat.m2505o(1882);
        }

        /* renamed from: d */
        public final void mo9216d(String str, String str2, int i, int i2) {
            AppMethodBeat.m2504i(1883);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(1883);
        }

        /* renamed from: cr */
        public final void mo9212cr(String str, String str2) {
        }

        /* renamed from: cs */
        public final void mo9213cs(String str, String str2) {
        }

        /* renamed from: ct */
        public final void mo9214ct(String str, String str2) {
            AppMethodBeat.m2504i(1884);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaiting");
            C29445e.this.isLoading = true;
            AppMethodBeat.m2505o(1884);
        }

        /* renamed from: cu */
        public final void mo9215cu(String str, String str2) {
            AppMethodBeat.m2504i(1885);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onVideoWaitingEnd");
            C29445e.this.isLoading = false;
            C29445e.this.cGp();
            C29428a c29428a = C29445e.this.getFSVideoUIComponent().cFR().sFp;
            if (c29428a != null && c29428a.sAP == 0) {
                c29428a.sAP = System.currentTimeMillis() - c29428a.sAE;
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoContainer", "FirstLoadTime %d %d", Long.valueOf(c29428a.sAM), Long.valueOf(c29428a.sAP));
            }
            AppMethodBeat.m2505o(1885);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$11 */
    class C1396011 implements OnClickListener {
        C1396011() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1896);
            C4232b fSVideoUIComponent = C29445e.this.getFSVideoUIComponent();
            C29445e.this.sDG.cFP();
            fSVideoUIComponent.mo9160a((bzs) view.getTag());
            AppMethodBeat.m2505o(1896);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$13 */
    class C1396113 implements OnClickListener {
        C1396113() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1898);
            if (C29445e.this.sDI == C13955a.MOBILE_NET) {
                C29445e.this.getFSVideoUIComponent().cFQ().sEM = true;
                C29445e.this.sDo.mo9159FE(2);
            }
            if (C29445e.this.getFSVideoUIComponent().cFQ().isConnected()) {
                C29445e.this.sDI = C13955a.UNKNOWN;
                if (C29445e.this.getFSVideoUIComponent().cFV().sFw) {
                    C29445e.this.getFSVideoUIComponent().cFV().cEf();
                } else {
                    C29445e.this.mo56045O(true, false);
                }
                C14419a.m22633kT(19);
                AppMethodBeat.m2505o(1898);
                return;
            }
            C14419a.m22633kT(20);
            AppMethodBeat.m2505o(1898);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$9 */
    class C139629 implements OnClickListener {
        C139629() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1894);
            C29445e.this.getFSItemUIComponent().mo47701FN(C29445e.this.sDG.cFP());
            AppMethodBeat.m2505o(1894);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$2 */
    class C224102 implements OnClickListener {
        C224102() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1878);
            if (!(C29445e.this.getFSItemUIComponent() == null || C29445e.this.getFSItemUIComponent().cFP() == C29445e.this.getFSVideoUIComponent().cFY())) {
                C29445e.this.getFSVideoUIComponent().cFR().sFo = 2;
                C29445e.this.getFSVideoUIComponent().mo9157FC(C29445e.this.sDG.cFP());
                C29445e.this.getFSVideoUIComponent().cFR().mo74507f(C29445e.this.sAX);
                ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(C29445e.this.getFSVideoUIComponent().cFT(), C29445e.this.sAX, C29445e.this.sDG.cFP(), 2, "");
            }
            AppMethodBeat.m2505o(1878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$10 */
    class C2944310 implements OnClickListener {
        C2944310() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1895);
            C29445e.this.getFSVideoUIComponent().mo9161a(C29445e.this.sAX);
            C29445e.this.sFK.mo37955h(C29445e.this.sAX);
            AppMethodBeat.m2505o(1895);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$8 */
    class C294448 implements OnClickListener {
        C294448() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1893);
            C29445e.this.getFSVideoUIComponent().mo9164ad(view, C29445e.this.sDG.cFP());
            AppMethodBeat.m2505o(1893);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$12 */
    class C2944612 implements OnClickListener {
        C2944612() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1897);
            if (!(C29445e.this.sAX == null || C5046bo.isNullOrNil(C29445e.this.sAX.phw))) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", C29445e.this.sAX.phw);
                C25985d.m41467b(C29445e.this.getFSVideoUIComponent().bKU().getApplicationContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(1897);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$4 */
    class C294474 implements OnClickListener {
        C294474() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1886);
            C29445e.this.getFSVideoUIComponent().cFV().sFy = true;
            AppMethodBeat.m2505o(1886);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$5 */
    class C294485 implements C4238a {
        C294485() {
        }

        public final void update(int i, int i2) {
            int width;
            AppMethodBeat.m2504i(1887);
            if (i2 > 0) {
                width = (C29445e.this.sDF.getWidth() * i) / i2;
            } else {
                width = 0;
            }
            C29428a c29428a = C29445e.this.getFSVideoUIComponent().cFR().sFp;
            if (c29428a != null && c29428a.sAH < ((long) C29445e.this.getFSVideoUIComponent().cFV().getCurrPosMs())) {
                c29428a.sAH = (long) C29445e.this.getFSVideoUIComponent().cFV().getCurrPosMs();
            }
            LayoutParams layoutParams = (LayoutParams) C29445e.this.sDE.getLayoutParams();
            layoutParams.width = width;
            C29445e.this.sDE.setLayoutParams(layoutParams);
            C29445e.this.sDE.requestLayout();
            if (C29445e.this.sAX.xhf <= 0 && (C29445e.this.sAX.xhd & 256) <= 0 && C29445e.this.sDo.mo9189fS(i, i2)) {
                C29445e.this.sAX.xhf = 1;
            }
            AppMethodBeat.m2505o(1887);
        }

        public final void cHb() {
            AppMethodBeat.m2504i(1888);
            C29445e.this.sDD.setVisibility(8);
            AppMethodBeat.m2505o(1888);
        }

        public final void cHc() {
            AppMethodBeat.m2504i(1889);
            if (C29445e.this.getFSVideoUIComponent().cFV().sFw && (C29445e.this.getFSVideoUIComponent().cFV().cGZ() || C29445e.this.getFSVideoUIComponent().cFV().sFx)) {
                C29445e.this.sDD.setVisibility(0);
                AppMethodBeat.m2505o(1889);
                return;
            }
            C29445e.this.sDD.setVisibility(8);
            AppMethodBeat.m2505o(1889);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$7 */
    class C294497 implements OnClickListener {
        C294497() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1892);
            if (!C29445e.this.getFSVideoUIComponent().cFV().sFw) {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoContainer", "no video play now");
                AppMethodBeat.m2505o(1892);
            } else if ((C29445e.this.sFK instanceof C35306k) || C29445e.this.sFK.getVideoTotalTime() - C29445e.this.sFK.getmPosition() >= 2) {
                C29445e.this.getFSVideoUIComponent().cFR().mo74507f(C29445e.this.sAX);
                if (C29445e.this.getFSVideoUIComponent().cFV().cGZ()) {
                    C29445e.this.getFSVideoUIComponent().cFV().cpN();
                    C29445e.this.sFK.cHd();
                } else {
                    C29445e.this.getFSVideoUIComponent().cFV().cEf();
                    C29445e.this.sFK.aFE();
                }
                C29445e.this.cGp();
                AppMethodBeat.m2505o(1892);
            } else {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoContainer", "cannot change play status in last 2 seconds");
                AppMethodBeat.m2505o(1892);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$6 */
    class C294506 implements C3855b {
        C294506() {
        }

        public final void aFw() {
            AppMethodBeat.m2504i(1890);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
            C29445e.this.sFK.cHd();
            AppMethodBeat.m2505o(1890);
        }

        /* renamed from: oA */
        public final void mo8552oA(int i) {
            AppMethodBeat.m2504i(1891);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", Integer.valueOf(i));
            C29445e.this.seekTo(i);
            C29445e.this.sFK.aFE();
            C14419a.m22633kT(22);
            AppMethodBeat.m2505o(1891);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$14 */
    class C2945114 implements OnClickListener {
        C2945114() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1899);
            C29445e.this.getFSVideoUIComponent().cFR().sFo = 2;
            if (C29445e.this.getFSItemUIComponent() == null || C29445e.this.getFSItemUIComponent().cFP() != C29445e.this.getFSVideoUIComponent().cFY()) {
                C29445e.this.getFSVideoUIComponent().mo9157FC(C29445e.this.sDG.cFP());
                C29445e.this.getFSVideoUIComponent().cFR().mo74507f(C29445e.this.sAX);
                ((C13943b) C1720g.m3530M(C13943b.class)).getReporter().mo9124a(C29445e.this.getFSVideoUIComponent().cFT(), C29445e.this.sAX, C29445e.this.sDG.cFP(), 2, "");
                AppMethodBeat.m2505o(1899);
                return;
            }
            C29445e.this.mo56045O(!C29445e.this.getFSVideoUIComponent().cFQ().sEM, false);
            AppMethodBeat.m2505o(1899);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$15 */
    class C2945215 implements OnClickListener {
        C2945215() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1900);
            C29445e.this.cGv();
            C29445e.this.sFK.aFE();
            C29445e.this.getFSVideoUIComponent().cFR().sFo = 2;
            C29445e.this.getFSVideoUIComponent().cFV().mo63216a(C29445e.this.getFSVideoUIComponent(), C29445e.this.sAX, C29445e.this.cvF, C29445e.this.sDG.cFP());
            C29445e.this.cGp();
            AppMethodBeat.m2505o(1900);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.e$a */
    class C29453a implements C13953c {
        private float sFW;

        C29453a() {
            AppMethodBeat.m2504i(1901);
            this.sFW = (float) C1338a.m2869ge(C29445e.this.getContext());
            AppMethodBeat.m2505o(1901);
        }

        public final void aFi() {
            AppMethodBeat.m2504i(1902);
            C4990ab.m7410d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
            if (C29445e.m46739U(C29445e.this)) {
                Object obj;
                if (C29445e.this.sFK.getVisibility() == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    C29445e.this.sFK.setVisibility(8);
                    AppMethodBeat.m2505o(1902);
                    return;
                }
                C29445e.this.sFK.show();
                if (C29445e.this.getFSItemUIComponent() != null) {
                    C29445e.this.getFSItemUIComponent().cFO();
                    C29445e.this.getFSItemUIComponent().cFN();
                }
            }
            AppMethodBeat.m2505o(1902);
        }

        public final void aFj() {
            AppMethodBeat.m2504i(1903);
            C4990ab.m7410d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
            AppMethodBeat.m2505o(1903);
        }

        public final void aFk() {
            AppMethodBeat.m2504i(1904);
            C29445e.this.sDq.setVisibility(0);
            C29445e.this.sFK.cHe();
            AppMethodBeat.m2505o(1904);
        }

        /* renamed from: be */
        public final int mo26183be(float f) {
            AppMethodBeat.m2504i(1905);
            float f2 = f / this.sFW;
            int videoDurationSec = C29445e.this.getFSVideoUIComponent().cFV().getVideoDurationSec();
            int currentPosition = ((int) (f2 * ((float) videoDurationSec))) + getCurrentPosition();
            if (currentPosition < 0) {
                currentPosition = 0;
            } else if (currentPosition > videoDurationSec) {
                currentPosition = videoDurationSec;
            }
            C29445e.this.sDq.setText(C14430a.m22663fQ(((long) currentPosition) * 1000) + "/" + C14430a.m22663fQ(((long) videoDurationSec) * 1000));
            AppMethodBeat.m2505o(1905);
            return currentPosition;
        }

        /* renamed from: FF */
        public final void mo26179FF(int i) {
            AppMethodBeat.m2504i(1906);
            C29445e.this.sFK.cHf();
            C29445e.this.sDq.setVisibility(8);
            C29445e.this.seekTo(i);
            AppMethodBeat.m2505o(1906);
        }

        public final boolean cGl() {
            AppMethodBeat.m2504i(1907);
            if (C29445e.m46743Y(C29445e.this)) {
                AppMethodBeat.m2505o(1907);
                return false;
            }
            AppMethodBeat.m2505o(1907);
            return true;
        }

        public final int getCurrentPosition() {
            AppMethodBeat.m2504i(1908);
            int currPosSec = C29445e.this.getFSVideoUIComponent().cFV().getCurrPosSec();
            AppMethodBeat.m2505o(1908);
            return currPosSec;
        }
    }

    /* renamed from: Y */
    static /* synthetic */ boolean m46743Y(C29445e c29445e) {
        AppMethodBeat.m2504i(1924);
        boolean aFf = c29445e.aFf();
        AppMethodBeat.m2505o(1924);
        return aFf;
    }

    public C29445e(Context context, C4232b c4232b, C46304a c46304a) {
        super(context, c4232b, c46304a);
        AppMethodBeat.m2504i(1909);
        if (this.sDo.cGb()) {
            this.kuG.setScaleType(ScaleType.CENTER_CROP);
        }
        AppMethodBeat.m2505o(1909);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    public final int getLayoutId() {
        return 2130970941;
    }

    public final void init() {
        AppMethodBeat.m2504i(1910);
        super.init();
        this.sFM = new C42351();
        this.sFN = new C294448();
        this.sFO = new C139629();
        this.sFP = new C2944310();
        this.sFQ = new C1396011();
        this.sFR = new C2944612();
        this.sDv.setOnClickListener(new C1396113());
        this.sDt.setOnClickListener(new C2945114());
        this.sDu.setOnClickListener(new C2945215());
        this.sDz.setOnClickListener(new C224102());
        this.sFL = new C13963k(getContext(), this, new C29453a());
        if (getFSVideoUIComponent().cGb()) {
            this.sFK = new C35306k(getContext());
        } else {
            this.sFK = new C22411f(getContext());
        }
        this.sFK.setOnlyFS(this.sFT);
        this.sFK.setVisibility(8);
        this.sFK.setFullScreenBtnClickListener(this.sFM);
        this.sFK.setFeedbackBtnClickListener(this.sFN);
        this.sFK.setShareBtnClickListener(this.sFO);
        this.sFK.setWowBtnClickListener(this.sFP);
        this.sFK.setTagBtnClickListener(this.sFQ);
        this.sFK.setSourceItemClickListener(this.sFR);
        if (C39964g.cFm()) {
            this.sFK.setTitleClickListener(new C294474());
        }
        this.sFK.setOnUpdateProgressLenListener(new C294485());
        this.sFK.setIplaySeekCallback(new C294506());
        this.sFK.setOnPlayButtonClickListener(new C294497());
        AppMethodBeat.m2505o(1910);
    }

    public final void cGp() {
        AppMethodBeat.m2504i(1911);
        super.cGp();
        AppMethodBeat.m2505o(1911);
    }

    public final void cGn() {
        AppMethodBeat.m2504i(1912);
        C4990ab.m7410d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
        this.sDz.setVisibility(8);
        this.sDy.setVisibility(8);
        this.kuG.setVisibility(0);
        this.sDq.setVisibility(8);
        this.sDp.setVisibility(8);
        this.sDD.setVisibility(8);
        AppMethodBeat.m2505o(1912);
    }

    public final void cGo() {
        AppMethodBeat.m2504i(1913);
        C4990ab.m7410d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
        this.sDz.setVisibility(0);
        if (!getFSVideoUIComponent().cFQ().cGN() || C39964g.cFp()) {
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
        AppMethodBeat.m2505o(1913);
    }

    public final void cGt() {
        AppMethodBeat.m2504i(1914);
        C22411f c22411f = this.sFK;
        if (c22411f.sGn != null) {
            c22411f.sGn.stopTimer();
        }
        AppMethodBeat.m2505o(1914);
    }

    /* renamed from: cu */
    public final void mo47684cu() {
        AppMethodBeat.m2504i(1915);
        super.mo47684cu();
        if (this.sFK != null) {
            this.sFK.setVideoTotalTime(this.sAX.xgR);
            C22411f c22411f = this.sFK;
            chw chw = this.sAX;
            c22411f.sFY.setVisibility(0);
            c22411f.aFL();
            ViewGroup.LayoutParams layoutParams = c22411f.sGe.getLayoutParams();
            layoutParams.height = c22411f.getResources().getDimensionPixelSize(C25738R.dimen.a2d);
            c22411f.sGe.setLayoutParams(layoutParams);
            if (chw.wiH.size() > 0) {
                if (c22411f.sGf != null) {
                    c22411f.sGf.setVisibility(0);
                }
                c22411f.sGg.setVisibility(0);
                c22411f.sGh.setVisibility(8);
                bzs bzs = (bzs) chw.wiH.get(0);
                c22411f.sGi.setTag(bzs);
                c22411f.mLM.setText(bzs.cEh);
                c22411f.mLM.setVisibility(0);
                c22411f.sGi.setVisibility(0);
                c22411f.sGk.setVisibility(8);
                if (!C5046bo.isNullOrNil(bzs.cIY)) {
                    C32291o.ahp().mo43766a(bzs.cIY, c22411f.sGk, C4210c.sBn);
                    c22411f.sGk.setVisibility(0);
                }
                if (chw.wiH.size() > 1) {
                    bzs = (bzs) chw.wiH.get(1);
                    c22411f.sGj.setTag(bzs);
                    c22411f.mLN.setText(bzs.cEh);
                    c22411f.mLN.setVisibility(0);
                    c22411f.sGj.setVisibility(0);
                    c22411f.sGl.setVisibility(8);
                    if (!C5046bo.isNullOrNil(bzs.cIY)) {
                        C32291o.ahp().mo43766a(bzs.cIY, c22411f.sGl, C4210c.sBn);
                        c22411f.sGl.setVisibility(0);
                    }
                } else {
                    c22411f.sGj.setVisibility(8);
                    c22411f.mLN.setVisibility(8);
                }
            } else {
                if (c22411f.sGf != null) {
                    c22411f.sGf.setVisibility(8);
                }
                c22411f.sGg.setVisibility(8);
            }
            c22411f.mo37955h(chw);
            if (c22411f.sFT) {
                c22411f.sGg.setVisibility(8);
                c22411f.sFX.setVisibility(8);
            }
            if (!(c22411f.sGm == null || c22411f.qeX == null || c22411f.sDW == null)) {
                c22411f.sGm.setVisibility(8);
                c22411f.qeX.setVisibility(8);
                c22411f.sDW.setVisibility(8);
                if (!C5046bo.isNullOrNil(chw.source)) {
                    c22411f.qeX.setText(chw.source);
                    c22411f.qeX.setVisibility(0);
                    if (!C5046bo.isNullOrNil(chw.phw)) {
                        c22411f.sGm.setVisibility(0);
                    }
                    if (C5046bo.isNullOrNil(chw.xgY)) {
                        c22411f.sDW.setImageResource(C25738R.drawable.ad2);
                    } else {
                        C32291o.ahp().mo43766a(chw.xgY, c22411f.sDW, C4210c.sBm);
                    }
                    c22411f.sDW.setVisibility(0);
                }
            }
            if (c22411f.gne != null) {
                c22411f.gne.setText(chw.title);
            }
        }
        if (!(getFSItemUIComponent() == null || getFSItemUIComponent().cFP() == getFSVideoUIComponent().cFY())) {
            if (getFSVideoUIComponent().cFQ().isConnected()) {
                cGq();
            } else {
                mo56052gE(getNoNetTip(), getContext().getString(C25738R.string.f1r));
            }
        }
        if (this.gne != null) {
            this.gne.setText(this.sAX.title);
        }
        AppMethodBeat.m2505o(1915);
    }

    public final C35873d getScaleType() {
        AppMethodBeat.m2504i(1916);
        C35873d c35873d;
        if (this.sDo.cGb()) {
            c35873d = C35873d.COVER;
            AppMethodBeat.m2505o(1916);
            return c35873d;
        }
        c35873d = C35873d.CONTAIN;
        AppMethodBeat.m2505o(1916);
        return c35873d;
    }

    public final void cGs() {
        AppMethodBeat.m2504i(1917);
        if (this.sFK != null) {
            this.sFK.setVisibility(8);
        }
        AppMethodBeat.m2505o(1917);
    }

    public final void cGw() {
        AppMethodBeat.m2504i(1918);
        if (this.sFK != null) {
            this.sFK.show();
        }
        AppMethodBeat.m2505o(1918);
    }

    public final C23324b getVideoViewCallback() {
        return this.sFS;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(1919);
        if (this.sFL != null) {
            this.sFL.mo26196z(motionEvent);
        }
        AppMethodBeat.m2505o(1919);
        return true;
    }

    private boolean aFf() {
        AppMethodBeat.m2504i(1920);
        if (this.sDz.getVisibility() == 0) {
            AppMethodBeat.m2505o(1920);
            return true;
        }
        AppMethodBeat.m2505o(1920);
        return false;
    }

    public final C22411f getControlBar() {
        return this.sFK;
    }

    public final chw getVideoInfo() {
        return this.sAX;
    }

    public final C4232b getFSVideoUIComponent() {
        return this.sDo;
    }

    public final C43695a getFSItemUIComponent() {
        return (C43695a) this.sDG;
    }

    public final void setOnlyFS(boolean z) {
        AppMethodBeat.m2504i(1921);
        this.sFT = z;
        if (this.sFK != null) {
            this.sFK.setOnlyFS(z);
        }
        AppMethodBeat.m2505o(1921);
    }

    /* renamed from: U */
    static /* synthetic */ boolean m46739U(C29445e c29445e) {
        AppMethodBeat.m2504i(1923);
        if (c29445e.aFf()) {
            AppMethodBeat.m2505o(1923);
            return false;
        }
        AppMethodBeat.m2505o(1923);
        return true;
    }
}
