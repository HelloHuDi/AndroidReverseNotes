package com.tencent.p177mm.plugin.webview.fts.p1069ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.decode.p512ui.C3855b;
import com.tencent.p177mm.plugin.websearch.p1066ui.WebSearchDotPercentIndicator;
import com.tencent.p177mm.plugin.websearch.p1066ui.WebSearchWebVideoViewControlBar;
import com.tencent.p177mm.plugin.websearch.p1066ui.WebSearchWebVideoViewControlBar.C227642;
import com.tencent.p177mm.plugin.websearch.p1066ui.WebSearchWebVideoViewControlBar.C40199a;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.C29770a.C22808a;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.C29770a.C22809b;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43872b.C22790a;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43875c;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43876d;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43876d.C72011;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView */
public class FtsWebVideoView extends RelativeLayout {
    public boolean eif;
    private TextView hYN;
    private LinearLayout hYT;
    private TextView hYV;
    private ImageView hYW;
    private ImageView hYX;
    private String hZb;
    private int hZc;
    private boolean hZe;
    private boolean hZg;
    private boolean hZk;
    private boolean hZl;
    private String hZn;
    private boolean isLoading;
    private String mAppId;
    private boolean mAutoPlay;
    private ImageView sDt;
    private ImageView uco;
    private C29769b ugO = C29769b.AUTO;
    public FtsVideoWrapper ugP;
    public WebSearchWebVideoViewControlBar ugQ;
    private View ugR;
    private View ugS;
    private WebSearchDotPercentIndicator ugT;
    private View ugU;
    private Button ugV;
    private TextView ugW;
    private TextView ugX;
    private boolean ugY;
    private C29770a ugZ;
    private C14458a uha;
    private int uhb;
    private C43876d uhc;
    private C22790a uhd;
    private int uhe;
    private boolean uhf;
    private long uhg;
    private View uhh;
    private View uhi;
    private C40221c uhj = C40221c.UNKNOWN;
    public BroadcastReceiver uhk = new C4021910();
    private String url;

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$5 */
    class C144575 implements OnClickListener {
        C144575() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(5828);
            if (FtsWebVideoView.this.ugP.isPlaying()) {
                FtsWebVideoView.this.ugQ.cHd();
                FtsWebVideoView.this.pause();
                AppMethodBeat.m2505o(5828);
                return;
            }
            FtsWebVideoView.this.ugQ.aFE();
            FtsWebVideoView.this.mo74599cg(true);
            AppMethodBeat.m2505o(5828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$a */
    public interface C14458a {
        void aDF();

        boolean isFullScreen();

        /* renamed from: nI */
        void mo26706nI(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$14 */
    class C2280514 implements OnClickListener {
        C2280514() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(5856);
            FtsWebVideoView.this.mo74609nH(!FtsWebVideoView.this.aFb());
            AppMethodBeat.m2505o(5856);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$3 */
    class C228063 implements OnClickListener {
        C228063() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(5825);
            FtsWebVideoView.m87402v(FtsWebVideoView.this);
            FtsWebVideoView.this.ugQ.aFE();
            AppMethodBeat.m2505o(5825);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$7 */
    class C228077 implements OnClickListener {
        C228077() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(5832);
            FtsWebVideoView.this.mo74609nH(!FtsWebVideoView.this.aFb());
            AppMethodBeat.m2505o(5832);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$6 */
    class C297686 implements C40199a {
        C297686() {
        }

        public final int aFg() {
            AppMethodBeat.m2504i(5829);
            int cacheTimeSec = FtsWebVideoView.this.ugP.getCacheTimeSec();
            AppMethodBeat.m2505o(5829);
            return cacheTimeSec;
        }

        public final int aFh() {
            AppMethodBeat.m2504i(5830);
            int videoDurationSec = FtsWebVideoView.this.ugP.getVideoDurationSec();
            AppMethodBeat.m2505o(5830);
            return videoDurationSec;
        }

        public final int cVN() {
            AppMethodBeat.m2504i(5831);
            int currPosMs = FtsWebVideoView.this.ugP.getCurrPosMs();
            AppMethodBeat.m2505o(5831);
            return currPosMs;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$b */
    enum C29769b {
        AUTO,
        LANDSCAPE,
        PORTRAIT;

        static {
            AppMethodBeat.m2505o(5859);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$4 */
    class C355874 implements C3855b {
        C355874() {
        }

        public final void aFw() {
            AppMethodBeat.m2504i(5826);
            C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onSeekPre");
            FtsWebVideoView.this.ugQ.cHd();
            AppMethodBeat.m2505o(5826);
        }

        /* renamed from: oA */
        public final void mo8552oA(int i) {
            AppMethodBeat.m2504i(5827);
            C4990ab.m7417i("MicroMsg.FtsWebVideoView", "onSeekTo %d", Integer.valueOf(i));
            FtsWebVideoView.this.mo74597ar(i, false);
            FtsWebVideoView.this.ugQ.aFE();
            if (FtsWebVideoView.this.uhc != null) {
                FtsWebVideoView.this.uhc.cWB();
            }
            AppMethodBeat.m2505o(5827);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$10 */
    class C4021910 extends BroadcastReceiver {
        C4021910() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(5835);
            if (FtsWebVideoView.this.ugP.isPlaying()) {
                FtsWebVideoView.m87376a(FtsWebVideoView.this, context);
            }
            AppMethodBeat.m2505o(5835);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$12 */
    class C4022012 implements C22809b {
        C4022012() {
        }

        public final void aFi() {
            AppMethodBeat.m2504i(5837);
            C4990ab.m7410d("MicroMsg.FtsWebVideoView", "onSingleTap");
            if (FtsWebVideoView.m87382e(FtsWebVideoView.this)) {
                FtsWebVideoView.this.ugQ.mo63549nG(FtsWebVideoView.this.isLoading);
            }
            AppMethodBeat.m2505o(5837);
        }

        public final void aFj() {
            AppMethodBeat.m2504i(5838);
            C4990ab.m7410d("MicroMsg.FtsWebVideoView", "onDoubleTap");
            AppMethodBeat.m2505o(5838);
        }

        public final void aFk() {
            AppMethodBeat.m2504i(5839);
            if (FtsWebVideoView.this.ugP.isLive()) {
                C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
                AppMethodBeat.m2505o(5839);
                return;
            }
            FtsWebVideoView.this.hYN.setVisibility(0);
            FtsWebVideoView.this.ugQ.cHe();
            AppMethodBeat.m2505o(5839);
        }

        /* renamed from: i */
        public final int mo38415i(int i, float f) {
            int i2 = 0;
            AppMethodBeat.m2504i(5840);
            if (FtsWebVideoView.this.ugP.isLive()) {
                C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
                AppMethodBeat.m2505o(5840);
            } else {
                C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onDragProgress:" + i + "/" + f);
                float measuredWidth = f / ((float) FtsWebVideoView.this.getMeasuredWidth());
                int videoDurationSec = FtsWebVideoView.this.ugP.getVideoDurationSec();
                int currentPosition = ((int) (measuredWidth * ((float) videoDurationSec))) + getCurrentPosition();
                if (currentPosition >= 0) {
                    if (currentPosition > videoDurationSec) {
                        i2 = videoDurationSec;
                    } else {
                        i2 = currentPosition;
                    }
                }
                FtsWebVideoView.this.hYN.setText(C43875c.m78695fQ(((long) i2) * 1000) + "/" + C43875c.m78695fQ(((long) videoDurationSec) * 1000));
                AppMethodBeat.m2505o(5840);
            }
            return i2;
        }

        /* renamed from: j */
        public final void mo38416j(int i, float f) {
            AppMethodBeat.m2504i(5841);
            FtsWebVideoView.this.ugQ.cHf();
            FtsWebVideoView.this.hYN.setVisibility(8);
            int currPosSec = FtsWebVideoView.this.ugP.getCurrPosSec();
            C4990ab.m7417i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i), Integer.valueOf(currPosSec), Float.valueOf(f));
            if (FtsWebVideoView.this.ugP.isLive()) {
                C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
                AppMethodBeat.m2505o(5841);
                return;
            }
            FtsWebVideoView.this.mo74597ar(i, false);
            FtsWebVideoView.this.ugQ.cHf();
            if (FtsWebVideoView.this.uhc != null) {
                FtsWebVideoView.this.uhc.cWB();
            }
            AppMethodBeat.m2505o(5841);
        }

        public final boolean cGl() {
            AppMethodBeat.m2504i(5842);
            if (FtsWebVideoView.m87389i(FtsWebVideoView.this)) {
                AppMethodBeat.m2505o(5842);
                return false;
            }
            AppMethodBeat.m2505o(5842);
            return true;
        }

        public final int getCurrentPosition() {
            AppMethodBeat.m2504i(5843);
            int currPosSec = FtsWebVideoView.this.ugP.getCurrPosSec();
            AppMethodBeat.m2505o(5843);
            return currPosSec;
        }

        /* renamed from: aq */
        public final void mo38411aq(float f) {
            AppMethodBeat.m2504i(5844);
            C4990ab.m7410d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(f)));
            FtsWebVideoView.this.ugT.setPercent(f);
            FtsWebVideoView.this.hYV.setText(C25738R.string.c2z);
            FtsWebVideoView.this.hYW.setImageResource(C1318a.fts_web_video_volume_icon);
            FtsWebVideoView.this.hYT.setVisibility(0);
            AppMethodBeat.m2505o(5844);
        }

        /* renamed from: ar */
        public final void mo38412ar(float f) {
            AppMethodBeat.m2504i(5845);
            C4990ab.m7410d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(f)));
            FtsWebVideoView.this.ugT.setPercent(f);
            FtsWebVideoView.this.hYV.setText(C25738R.string.c2w);
            FtsWebVideoView.this.hYW.setImageResource(C1318a.fts_web_video_brightness_icon);
            FtsWebVideoView.this.hYT.setVisibility(0);
            AppMethodBeat.m2505o(5845);
        }

        public final void aFl() {
            AppMethodBeat.m2504i(5846);
            FtsWebVideoView.this.hYT.setVisibility(8);
            AppMethodBeat.m2505o(5846);
        }

        public final void aFm() {
            AppMethodBeat.m2504i(5847);
            FtsWebVideoView.this.hYT.setVisibility(8);
            AppMethodBeat.m2505o(5847);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$c */
    enum C40221c {
        UNKNOWN,
        MOBILE_NET,
        NO_NET;

        static {
            AppMethodBeat.m2505o(5862);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$1 */
    class C438791 implements OnClickListener {
        C438791() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(5823);
            FtsWebVideoView.this.pause();
            AppMethodBeat.m2505o(5823);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$2 */
    class C438802 implements OnClickListener {
        C438802() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(5824);
            FtsWebVideoView.this.mo74609nH(!FtsWebVideoView.this.aFb());
            AppMethodBeat.m2505o(5824);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$8 */
    class C438818 implements OnClickListener {
        C438818() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(5833);
            if (FtsWebVideoView.this.uhj == C40221c.MOBILE_NET) {
                FtsWebVideoView.this.uhf = true;
            }
            FtsWebVideoView.this.mo74599cg(true);
            AppMethodBeat.m2505o(5833);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$13 */
    class C4641313 implements C23324b {
        C4641313() {
        }

        /* renamed from: c */
        public final void mo9209c(String str, String str2, String str3, int i, int i2) {
            AppMethodBeat.m2504i(5848);
            C4990ab.m7417i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i), Integer.valueOf(i2));
            C7060h.pYm.mo8381e(14911, Integer.valueOf(i), Integer.valueOf(i2), FtsWebVideoView.this.url, C5023at.m7471gB(FtsWebVideoView.this.getContext()));
            if (FtsWebVideoView.this.uhc != null) {
                C43876d h = FtsWebVideoView.this.uhc;
                C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", Integer.valueOf(i), Integer.valueOf(i2));
                h.clean();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errCode", i);
                    jSONObject.put("errMsg", String.valueOf(i2));
                    h.mo69569aM(h.mo69566a(7, jSONObject));
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
                }
            }
            FtsWebVideoView.this.pause();
            FtsWebVideoView.m87375a(FtsWebVideoView.this, FtsWebVideoView.this.getContext().getString(C25738R.string.f13, new Object[]{i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2}), FtsWebVideoView.this.getContext().getString(C25738R.string.f1r));
            AppMethodBeat.m2505o(5848);
        }

        /* renamed from: cp */
        public final void mo9210cp(String str, String str2) {
            AppMethodBeat.m2504i(5849);
            C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onPrepared");
            C29770a o = FtsWebVideoView.this.ugZ;
            o.iaB = -1;
            o.iaC = 0;
            o.iaA = 0.0f;
            FtsWebVideoView.this.ugQ.mo63549nG(FtsWebVideoView.this.isLoading);
            AppMethodBeat.m2505o(5849);
        }

        /* renamed from: cq */
        public final void mo9211cq(String str, String str2) {
            AppMethodBeat.m2504i(5850);
            C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onVideoEnded");
            if (FtsWebVideoView.this.uhc != null) {
                C43876d h = FtsWebVideoView.this.uhc;
                C4990ab.m7411d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", h.toString());
                h.aFW();
                try {
                    h.mo69569aM(h.mo69566a(3, null));
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
                }
            }
            if (FtsWebVideoView.this.hZl) {
                FtsWebVideoView.this.mo74597ar(0, true);
                AppMethodBeat.m2505o(5850);
                return;
            }
            FtsWebVideoView.this.mo74597ar(0, false);
            FtsWebVideoView.this.pause();
            FtsWebVideoView.m87397q(FtsWebVideoView.this);
            FtsWebVideoView.this.sDt.setImageResource(C25738R.drawable.b6l);
            FtsWebVideoView.this.ugQ.setVisibility(8);
            AppMethodBeat.m2505o(5850);
        }

        /* renamed from: d */
        public final void mo9216d(String str, String str2, int i, int i2) {
            AppMethodBeat.m2504i(5851);
            C4990ab.m7417i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (FtsWebVideoView.this.ugO == C29769b.AUTO) {
                FtsWebVideoView.this.ugO = i < i2 ? C29769b.PORTRAIT : C29769b.LANDSCAPE;
                C4990ab.m7417i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", FtsWebVideoView.this.ugO);
            }
            AppMethodBeat.m2505o(5851);
        }

        /* renamed from: cr */
        public final void mo9212cr(String str, String str2) {
            AppMethodBeat.m2504i(5852);
            C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onVideoPause");
            if (!(FtsWebVideoView.this.uhc == null || FtsWebVideoView.this.uhc == null)) {
                C43876d h = FtsWebVideoView.this.uhc;
                C4990ab.m7411d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", h.toString());
                h.aFW();
                try {
                    h.mo69569aM(h.mo69566a(2, null));
                    AppMethodBeat.m2505o(5852);
                    return;
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
                }
            }
            AppMethodBeat.m2505o(5852);
        }

        /* renamed from: cs */
        public final void mo9213cs(String str, String str2) {
            AppMethodBeat.m2504i(5853);
            C4990ab.m7417i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", Boolean.valueOf(FtsWebVideoView.m87400t(FtsWebVideoView.this)));
            if (FtsWebVideoView.this.uhc != null) {
                C43876d h = FtsWebVideoView.this.uhc;
                C4990ab.m7411d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", h.toString());
                h.iat = 0;
                if (h.ias == null) {
                    h.ias = new C7564ap(new C72011(), true);
                }
                h.ias.mo16770ae(250, 250);
                try {
                    h.mo69569aM(h.mo69566a(1, null));
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
                }
            }
            if (FtsWebVideoView.this.uhg > 0 && FtsWebVideoView.this.uhg != Long.MAX_VALUE) {
                long currentTimeMillis = System.currentTimeMillis() - FtsWebVideoView.this.uhg;
                C7060h.pYm.mo8381e(14909, Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis()), Long.valueOf(currentTimeMillis), C5023at.m7471gB(FtsWebVideoView.this.getContext()), FtsWebVideoView.this.url);
            }
            AppMethodBeat.m2505o(5853);
        }

        /* renamed from: ct */
        public final void mo9214ct(String str, String str2) {
            AppMethodBeat.m2504i(5854);
            C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
            FtsWebVideoView.this.ugQ.cHe();
            FtsWebVideoView.this.isLoading = true;
            AppMethodBeat.m2505o(5854);
        }

        /* renamed from: cu */
        public final void mo9215cu(String str, String str2) {
            AppMethodBeat.m2504i(5855);
            C4990ab.m7416i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
            FtsWebVideoView.this.isLoading = false;
            FtsWebVideoView.this.ugQ.cHf();
            FtsWebVideoView.this.ugQ.aFE();
            AppMethodBeat.m2505o(5855);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView$9 */
    class C464149 implements OnClickListener {
        C464149() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(5834);
            FtsWebVideoView.this.mo74599cg(true);
            FtsWebVideoView.this.ugQ.aFE();
            AppMethodBeat.m2505o(5834);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m87375a(FtsWebVideoView ftsWebVideoView, String str, String str2) {
        AppMethodBeat.m2504i(5908);
        ftsWebVideoView.m87387gZ(str, str2);
        AppMethodBeat.m2505o(5908);
    }

    /* renamed from: b */
    static /* synthetic */ void m87378b(FtsWebVideoView ftsWebVideoView, Context context) {
        AppMethodBeat.m2504i(5905);
        ftsWebVideoView.m87385fp(context);
        AppMethodBeat.m2505o(5905);
    }

    /* renamed from: e */
    static /* synthetic */ boolean m87382e(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.m2504i(5906);
        boolean cWw = ftsWebVideoView.cWw();
        AppMethodBeat.m2505o(5906);
        return cWw;
    }

    /* renamed from: i */
    static /* synthetic */ boolean m87389i(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.m2504i(5907);
        boolean cWx = ftsWebVideoView.cWx();
        AppMethodBeat.m2505o(5907);
        return cWx;
    }

    /* renamed from: t */
    static /* synthetic */ boolean m87400t(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.m2504i(5910);
        boolean isLive = ftsWebVideoView.isLive();
        AppMethodBeat.m2505o(5910);
        return isLive;
    }

    public FtsWebVideoView(Context context, boolean z) {
        super(context);
        AppMethodBeat.m2504i(5863);
        setAutoPlay(z);
        init(context);
        AppMethodBeat.m2505o(5863);
    }

    public FtsWebVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(5864);
        init(context);
        AppMethodBeat.m2505o(5864);
    }

    public FtsWebVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(5865);
        init(context);
        AppMethodBeat.m2505o(5865);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(5866);
        LayoutInflater.from(context).inflate(2130969642, this);
        this.ugP = (FtsVideoWrapper) findViewById(2131821402);
        this.hYN = (TextView) findViewById(2131821370);
        this.ugR = findViewById(2131824278);
        this.ugS = findViewById(2131824281);
        this.hYT = (LinearLayout) findViewById(2131821409);
        this.ugT = (WebSearchDotPercentIndicator) findViewById(2131821412);
        this.hYV = (TextView) findViewById(2131821411);
        this.hYW = (ImageView) findViewById(2131821410);
        this.hYX = (ImageView) findViewById(2131821404);
        this.uhh = findViewById(2131821891);
        this.uhi = findViewById(2131824282);
        this.ugT.setDotsNum(8);
        this.sDt = (ImageView) findViewById(2131824280);
        this.ugU = findViewById(2131824279);
        this.ugW = (TextView) findViewById(2131824285);
        this.ugV = (Button) findViewById(2131824284);
        this.ugX = (TextView) findViewById(2131824283);
        this.uco = (ImageView) findViewById(2131821418);
        this.ugW.setOnClickListener(new C438791());
        this.uco.setOnClickListener(new C228077());
        this.ugV.setOnClickListener(new C438818());
        this.ugU.setOnClickListener(new C464149());
        aEY();
        aFa();
        aZb();
        context.registerReceiver(this.uhk, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        cWv();
        AppMethodBeat.m2505o(5866);
    }

    /* renamed from: fo */
    private boolean m87384fo(final Context context) {
        AppMethodBeat.m2504i(5867);
        C40221c c40221c = this.uhj;
        if (!C5023at.isConnected(context)) {
            if (c40221c == C40221c.NO_NET) {
                this.uhh.setVisibility(0);
                this.uhi.setVisibility(8);
                this.ugR.setVisibility(0);
                postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(5836);
                        FtsWebVideoView.m87378b(FtsWebVideoView.this, context);
                        AppMethodBeat.m2505o(5836);
                    }
                }, 200);
            } else {
                m87385fp(context);
            }
            AppMethodBeat.m2505o(5867);
            return false;
        } else if (this.uhf || C5023at.isWifi(context)) {
            AppMethodBeat.m2505o(5867);
            return true;
        } else {
            pause();
            this.uhj = C40221c.MOBILE_NET;
            this.ugQ.setVisibility(8);
            String netUnavailableTip = getNetUnavailableTip();
            String string = context.getString(C25738R.string.f10);
            context.getString(C25738R.string.f0x);
            m87387gZ(netUnavailableTip, string);
            AppMethodBeat.m2505o(5867);
            return false;
        }
    }

    /* renamed from: fp */
    private void m87385fp(Context context) {
        AppMethodBeat.m2504i(5868);
        this.uhj = C40221c.NO_NET;
        pause();
        m87387gZ(context.getString(C25738R.string.f1e), context.getString(C25738R.string.f1r));
        AppMethodBeat.m2505o(5868);
    }

    private String getNetUnavailableTip() {
        AppMethodBeat.m2504i(5869);
        String string;
        if (this.uhe == 0) {
            string = getContext().getString(C25738R.string.f1g);
            AppMethodBeat.m2505o(5869);
            return string;
        }
        Context context = getContext();
        Object[] objArr = new Object[1];
        long j = (long) this.uhe;
        if (j < 0) {
            string = "";
        } else {
            BigDecimal bigDecimal = new BigDecimal(j);
            float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
            if (floatValue > 1.0f) {
                string = ((int) floatValue) + "M";
            } else {
                string = ((int) bigDecimal.divide(new BigDecimal(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 2, 0).floatValue()) + "K";
            }
        }
        objArr[0] = string;
        string = context.getString(C25738R.string.f1f, objArr);
        AppMethodBeat.m2505o(5869);
        return string;
    }

    /* renamed from: gZ */
    private void m87387gZ(String str, String str2) {
        AppMethodBeat.m2504i(5870);
        cWv();
        this.uhh.setVisibility(8);
        this.uhi.setVisibility(0);
        this.ugQ.setVisibility(8);
        this.ugR.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.ugX.setVisibility(8);
        } else {
            this.ugX.setText(str);
            this.ugX.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.ugV.setVisibility(8);
        } else {
            this.ugV.setText(str2);
            this.ugV.setVisibility(0);
        }
        this.ugS.setVisibility(0);
        this.ugU.setVisibility(8);
        this.ugW.setVisibility(8);
        cWu();
        AppMethodBeat.m2505o(5870);
    }

    private void cWu() {
        AppMethodBeat.m2504i(5871);
        if (aFb()) {
            this.uco.setVisibility(0);
            AppMethodBeat.m2505o(5871);
            return;
        }
        this.uco.setVisibility(8);
        AppMethodBeat.m2505o(5871);
    }

    public void setAppId(String str) {
        AppMethodBeat.m2504i(5872);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setAppId appid=%s", str);
        this.mAppId = str;
        AppMethodBeat.m2505o(5872);
    }

    public void setVideoPlayerId(int i) {
        this.hZc = i;
    }

    public int getmVideoPlayerId() {
        return this.hZc;
    }

    public void setAutoPlay(boolean z) {
        AppMethodBeat.m2504i(5873);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", Boolean.valueOf(z));
        this.mAutoPlay = z;
        AppMethodBeat.m2505o(5873);
    }

    public void setDuration(int i) {
        AppMethodBeat.m2504i(5874);
        if (i <= 0) {
            C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(5874);
            return;
        }
        AppMethodBeat.m2505o(5874);
    }

    public void setLoop(boolean z) {
        AppMethodBeat.m2504i(5875);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", Boolean.valueOf(z));
        this.hZl = z;
        AppMethodBeat.m2505o(5875);
    }

    /* renamed from: cg */
    public final void mo74599cg(boolean z) {
        AppMethodBeat.m2504i(5876);
        C4990ab.m7416i("MicroMsg.FtsWebVideoView", "start");
        cWv();
        if (!z || m87384fo(getContext())) {
            this.uhj = C40221c.UNKNOWN;
            if (this.ugP.isPlaying()) {
                AppMethodBeat.m2505o(5876);
                return;
            }
            if (this.hZe) {
                WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = this.ugQ;
                if (webSearchWebVideoViewControlBar.hZL == null) {
                    webSearchWebVideoViewControlBar.hZL = new C7564ap(new C227642(), true);
                }
                webSearchWebVideoViewControlBar.aFP();
                webSearchWebVideoViewControlBar.hZL.stopTimer();
                webSearchWebVideoViewControlBar.hZL.mo16770ae(500, 500);
            }
            this.ugP.start();
            if (this.uhg == 0) {
                this.uhg = System.currentTimeMillis();
                AppMethodBeat.m2505o(5876);
                return;
            }
            this.uhg = Long.MAX_VALUE;
            AppMethodBeat.m2505o(5876);
            return;
        }
        C4990ab.m7416i("MicroMsg.FtsWebVideoView", "start network is not wifi");
        AppMethodBeat.m2505o(5876);
    }

    private void cWv() {
        AppMethodBeat.m2504i(5877);
        this.ugR.setVisibility(8);
        AppMethodBeat.m2505o(5877);
    }

    public final void pause() {
        AppMethodBeat.m2504i(5878);
        C4990ab.m7416i("MicroMsg.FtsWebVideoView", "pause");
        cWv();
        if (this.ugP.isPlaying()) {
            this.ugP.pause();
            AppMethodBeat.m2505o(5878);
            return;
        }
        AppMethodBeat.m2505o(5878);
    }

    public final void stop() {
        AppMethodBeat.m2504i(5879);
        C4990ab.m7416i("MicroMsg.FtsWebVideoView", "stop");
        if (this.ugP.isPlaying()) {
            this.ugP.stop();
            WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = this.ugQ;
            if (webSearchWebVideoViewControlBar.hZL != null) {
                webSearchWebVideoViewControlBar.hZL.stopTimer();
            }
            AppMethodBeat.m2505o(5879);
            return;
        }
        AppMethodBeat.m2505o(5879);
    }

    /* renamed from: bL */
    public final void mo74598bL(String str, int i) {
        AppMethodBeat.m2504i(5880);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", str, Boolean.FALSE);
        this.url = str;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7418v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
            AppMethodBeat.m2505o(5880);
            return;
        }
        stop();
        this.hZk = false;
        this.ugP.mo9063c(false, str, i);
        if (this.ugQ != null) {
            this.ugQ.setVideoTotalTime(i);
        }
        if (this.uhb > 0) {
            this.ugP.mo26920s((double) this.uhb);
        }
        if (this.mAutoPlay) {
            C4990ab.m7416i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
            mo74599cg(false);
        }
        if (str.startsWith("wxfile://")) {
            setCover(str);
        }
        AppMethodBeat.m2505o(5880);
    }

    /* renamed from: ar */
    public final void mo74597ar(int i, boolean z) {
        AppMethodBeat.m2504i(5881);
        int currPosSec = this.ugP.getCurrPosSec();
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", Integer.valueOf(i), Integer.valueOf(currPosSec), Boolean.valueOf(this.hZk));
        if (isLive()) {
            AppMethodBeat.m2505o(5881);
        } else if (z) {
            this.ugP.mo26912e((double) i, z);
            AppMethodBeat.m2505o(5881);
        } else {
            this.ugP.mo26920s((double) i);
            AppMethodBeat.m2505o(5881);
        }
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.m2504i(5882);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", Boolean.valueOf(z));
        this.hZe = z;
        AppMethodBeat.m2505o(5882);
    }

    public final void setCover$16da05f7(String str) {
        AppMethodBeat.m2504i(5883);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(5883);
            return;
        }
        this.hZn = str;
        C37926b.abR().mo60683a(this.hYX, str, null, null);
        AppMethodBeat.m2505o(5883);
    }

    private void setCover(String str) {
        AppMethodBeat.m2504i(5884);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(5884);
        } else if (C5046bo.isNullOrNil(this.hZn)) {
            AppMethodBeat.m2505o(5884);
        } else {
            C4990ab.m7416i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
            AppMethodBeat.m2505o(5884);
        }
    }

    public void setObjectFit(String str) {
        AppMethodBeat.m2504i(5885);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", str);
        if ("fill".equalsIgnoreCase(str)) {
            this.ugP.setScaleType(C35873d.FILL);
            this.hYX.setScaleType(ScaleType.FIT_XY);
            AppMethodBeat.m2505o(5885);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.ugP.setScaleType(C35873d.COVER);
            this.hYX.setScaleType(ScaleType.CENTER_CROP);
            AppMethodBeat.m2505o(5885);
        } else {
            this.ugP.setScaleType(C35873d.CONTAIN);
            this.hYX.setScaleType(ScaleType.FIT_CENTER);
            AppMethodBeat.m2505o(5885);
        }
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(5886);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", Boolean.valueOf(z));
        this.eif = z;
        this.ugP.setMute(z);
        if (z) {
            this.ugQ.mo63539NO();
            AppMethodBeat.m2505o(5886);
            return;
        }
        this.ugQ.cVM();
        AppMethodBeat.m2505o(5886);
    }

    public void setCookieData(String str) {
        this.hZb = str;
    }

    public String getCookieData() {
        return this.hZb;
    }

    public int getCurrPosSec() {
        AppMethodBeat.m2504i(5887);
        int currPosSec = this.ugP.getCurrPosSec();
        AppMethodBeat.m2505o(5887);
        return currPosSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.m2504i(5888);
        int currPosMs = this.ugP.getCurrPosMs();
        AppMethodBeat.m2505o(5888);
        return currPosMs;
    }

    public void setFullScreenDirection(String str) {
        AppMethodBeat.m2504i(5889);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", str);
        if (MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL.equalsIgnoreCase(str)) {
            this.ugO = C29769b.LANDSCAPE;
            AppMethodBeat.m2505o(5889);
        } else if ("vertical".equalsIgnoreCase(str)) {
            this.ugO = C29769b.PORTRAIT;
            AppMethodBeat.m2505o(5889);
        } else {
            this.ugO = C29769b.AUTO;
            AppMethodBeat.m2505o(5889);
        }
    }

    public void setDisableScroll(boolean z) {
        AppMethodBeat.m2504i(5890);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", Boolean.valueOf(z));
        this.ugY = z;
        AppMethodBeat.m2505o(5890);
    }

    public void setPageGesture(boolean z) {
        AppMethodBeat.m2504i(5891);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", Boolean.valueOf(z));
        this.hZg = z;
        AppMethodBeat.m2505o(5891);
    }

    public void setInitialTime(int i) {
        AppMethodBeat.m2504i(5892);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", Integer.valueOf(i));
        this.uhb = i;
        AppMethodBeat.m2505o(5892);
    }

    public void setCallback(C43876d c43876d) {
        this.uhc = c43876d;
    }

    public void setFullScreenDelegate(C14458a c14458a) {
        this.uha = c14458a;
    }

    public C43876d getCallback() {
        return this.uhc;
    }

    private void aEY() {
        AppMethodBeat.m2504i(5893);
        this.ugZ = new C29770a(getContext(), this, new C4022012());
        AppMethodBeat.m2505o(5893);
    }

    private void aFa() {
        AppMethodBeat.m2504i(5894);
        this.ugP.setIMMVideoViewCallback(new C4641313());
        AppMethodBeat.m2505o(5894);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(5895);
        if (this.hZg || aFb()) {
            if (this.ugZ != null) {
                C29770a c29770a = this.ugZ;
                if (c29770a.ugH.cGl()) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 0) {
                        c29770a.iaA = motionEvent.getRawX();
                        c29770a.f13721JB = ((AudioManager) c29770a.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                        c29770a.hXK = C43875c.m78694cN(c29770a.mContext);
                    }
                    c29770a.iay.onTouchEvent(motionEvent);
                    if (actionMasked == 1 || actionMasked == 3) {
                        if (c29770a.ugG == C22808a.FastBackwardOrForward) {
                            c29770a.ugH.mo38416j(c29770a.iaC, motionEvent.getRawX() - c29770a.iaA);
                            c29770a.iaB = -1;
                            c29770a.iaC = 0;
                            c29770a.iaA = 0.0f;
                        } else if (c29770a.ugG == C22808a.Volume) {
                            ((AudioManager) c29770a.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                            c29770a.ugH.aFl();
                        } else if (c29770a.ugG == C22808a.Brightness) {
                            c29770a.ugH.aFm();
                        }
                    }
                }
                c29770a.ugG = C22808a.None;
            }
            AppMethodBeat.m2505o(5895);
            return true;
        }
        if (motionEvent.getAction() == 0 && cWw()) {
            this.ugQ.mo63549nG(this.isLoading);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(5895);
        return onTouchEvent;
    }

    public int getSystemVolume() {
        AppMethodBeat.m2504i(5896);
        int streamVolume = ((AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
        AppMethodBeat.m2505o(5896);
        return streamVolume;
    }

    private boolean cWw() {
        AppMethodBeat.m2504i(5897);
        if (!this.hZe || cWx()) {
            AppMethodBeat.m2505o(5897);
            return false;
        }
        AppMethodBeat.m2505o(5897);
        return true;
    }

    private boolean cWx() {
        AppMethodBeat.m2504i(5898);
        if (this.ugR.getVisibility() == 0) {
            AppMethodBeat.m2505o(5898);
            return true;
        }
        AppMethodBeat.m2505o(5898);
        return false;
    }

    /* renamed from: nH */
    public final void mo74609nH(boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(5899);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", Boolean.valueOf(z));
        if (this.uha == null) {
            C4990ab.m7420w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
            AppMethodBeat.m2505o(5899);
        } else if (z == aFb()) {
            C4990ab.m7416i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
            AppMethodBeat.m2505o(5899);
        } else if (z) {
            C14458a c14458a = this.uha;
            if (this.ugO != C29769b.PORTRAIT) {
                z2 = true;
            }
            c14458a.mo26706nI(z2);
            WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = this.ugQ;
            webSearchWebVideoViewControlBar.hZM = true;
            webSearchWebVideoViewControlBar.aFJ();
            mo74600er(true);
            AppMethodBeat.m2505o(5899);
        } else {
            this.uha.aDF();
            this.ugQ.aDF();
            AppMethodBeat.m2505o(5899);
        }
    }

    public void setAllowMobileNetPlay(boolean z) {
        this.uhf = z;
    }

    public final boolean aFb() {
        AppMethodBeat.m2504i(5900);
        if (this.uha == null) {
            C4990ab.m7420w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
            AppMethodBeat.m2505o(5900);
            return false;
        }
        boolean isFullScreen = this.uha.isFullScreen();
        AppMethodBeat.m2505o(5900);
        return isFullScreen;
    }

    private void aZb() {
        AppMethodBeat.m2504i(5901);
        this.ugQ = new WebSearchWebVideoViewControlBar(getContext());
        this.ugQ.setVisibility(8);
        this.ugQ.setEnterFullScreenBtnClickListener(new C2280514());
        this.ugQ.setExitFullScreenBtnClickListener(new C438802());
        this.ugQ.setMuteBtnOnClickListener(new C228063());
        this.ugQ.setIplaySeekCallback(new C355874());
        this.ugQ.setOnPlayButtonClickListener(new C144575());
        this.ugQ.setStatePorter(new C297686());
        this.ugP.setVideoFooterView(this.ugQ);
        AppMethodBeat.m2505o(5901);
    }

    /* renamed from: er */
    public final void mo74600er(boolean z) {
        AppMethodBeat.m2504i(5902);
        if (this.uhc == null) {
            AppMethodBeat.m2505o(5902);
            return;
        }
        this.uhc.mo69570b(this.hZc, z, this.ugO == C29769b.PORTRAIT ? "vertical" : MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL);
        cWu();
        AppMethodBeat.m2505o(5902);
    }

    private boolean isLive() {
        AppMethodBeat.m2504i(5903);
        C4990ab.m7417i("MicroMsg.FtsWebVideoView", "isLive %b %b", Boolean.valueOf(this.hZk), Boolean.valueOf(this.ugP.isLive()));
        if (this.hZk || this.ugP.isLive()) {
            AppMethodBeat.m2505o(5903);
            return true;
        }
        AppMethodBeat.m2505o(5903);
        return false;
    }

    public C22790a getUiLifecycleListener() {
        return this.uhd;
    }

    public void setUiLifecycleListener(C22790a c22790a) {
        this.uhd = c22790a;
    }

    public int getVideoSizeByte() {
        return this.uhe;
    }

    public void setVideoSizeByte(int i) {
        this.uhe = i;
    }

    /* renamed from: q */
    static /* synthetic */ void m87397q(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.m2504i(5909);
        ftsWebVideoView.ugR.setVisibility(0);
        ftsWebVideoView.ugS.setVisibility(8);
        ftsWebVideoView.ugU.setVisibility(0);
        ftsWebVideoView.cWu();
        AppMethodBeat.m2505o(5909);
    }

    /* renamed from: v */
    static /* synthetic */ void m87402v(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.m2504i(5911);
        ftsWebVideoView.eif = !ftsWebVideoView.eif;
        ftsWebVideoView.ugP.setMute(ftsWebVideoView.eif);
        if (ftsWebVideoView.eif) {
            ftsWebVideoView.ugQ.mo63539NO();
            AppMethodBeat.m2505o(5911);
            return;
        }
        ftsWebVideoView.ugQ.cVM();
        AppMethodBeat.m2505o(5911);
    }
}
