package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C10560h;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C19519a;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C27131b;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C33403m;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C334051;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C33406c;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C33408d;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C33410f;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C334112;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33404k.C33412g;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33414l.C33416b;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C10555f;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C19512d;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C27129e;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C27130g;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C38399a;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C38400h;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C42593b;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C42594c;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.danmu.C19514b;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.danmu.C19515c;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.danmu.C24704a;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.danmu.DanmuView.C195135;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.danmu.DanmuView.C333993;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.danmu.DanmuView.C334004;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView */
public class AppBrandVideoView extends RelativeLayout {
    private static C19507b hYK;
    /* renamed from: Yp */
    private int f4352Yp = -1;
    private boolean hLW;
    private boolean hLX;
    private int hLe;
    private RelativeLayout hYL;
    C45630d hYM;
    private TextView hYN;
    private DanmuView hYO;
    C38399a hYP;
    private View hYQ;
    private View hYR;
    private TextView hYS;
    private LinearLayout hYT;
    private AppBrandDotPercentIndicator hYU;
    private TextView hYV;
    private ImageView hYW;
    private ImageView hYX;
    private ImageView hYY;
    private ImageView hYZ;
    private FrameLayout hZa;
    private String hZb;
    private int hZc;
    private C2241c hZd;
    private boolean hZe;
    C33404k hZf;
    private boolean hZg;
    private boolean hZh;
    private C33414l hZi;
    private C19501a hZj;
    private boolean hZk;
    private boolean hZl;
    private double hZm;
    private String hZn;
    private boolean hZo;
    private boolean hZp;
    private boolean hZq;
    private boolean hZr;
    private int hZs;
    private String hZt;
    private boolean hZu;
    private boolean hZv;
    private boolean hZw = false;
    private String mAppId;
    private boolean mAutoPlay;
    private int mDuration;
    private boolean mIsMute;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$13 */
    class C1054813 implements OnClickListener {
        C1054813() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126474);
            boolean z = !AppBrandVideoView.this.aFb();
            AppBrandVideoView appBrandVideoView = AppBrandVideoView.this;
            appBrandVideoView.mo34634j(z, appBrandVideoView.f4352Yp);
            AppMethodBeat.m2505o(126474);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$14 */
    class C1054914 implements C42594c {
        C1054914() {
        }

        public final void aFw() {
            AppMethodBeat.m2504i(126475);
            C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onSeekPre");
            AppMethodBeat.m2505o(126475);
        }

        /* renamed from: oA */
        public final void mo22044oA(int i) {
            AppMethodBeat.m2504i(126476);
            AppBrandVideoView.this.mo34624d((double) i, false);
            AppMethodBeat.m2505o(126476);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$2 */
    class C105502 implements OnClickListener {
        C105502() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126442);
            if (AppBrandVideoView.this.hYM.isPlaying()) {
                AppBrandVideoView.this.pause();
                AppMethodBeat.m2505o(126442);
                return;
            }
            AppBrandVideoView.this.start();
            AppMethodBeat.m2505o(126442);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$4 */
    class C105514 implements OnClickListener {
        C105514() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126445);
            AppBrandVideoView.this.setMute(!AppBrandVideoView.this.mIsMute);
            AppMethodBeat.m2505o(126445);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$5 */
    class C105525 implements OnClickListener {
        C105525() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126446);
            AppBrandVideoView.this.mo34634j(false, AppBrandVideoView.this.f4352Yp);
            AppMethodBeat.m2505o(126446);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$3 */
    class C195003 implements C38400h {
        C195003() {
        }

        public final int aFg() {
            AppMethodBeat.m2504i(126443);
            int cacheTimeSec = AppBrandVideoView.this.hYM.getCacheTimeSec();
            AppMethodBeat.m2505o(126443);
            return cacheTimeSec;
        }

        public final int aFh() {
            AppMethodBeat.m2504i(126444);
            int videoDurationSec = AppBrandVideoView.this.hYM.getVideoDurationSec();
            AppMethodBeat.m2505o(126444);
            return videoDurationSec;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$a */
    public interface C19501a {
        void aDF();

        boolean isFullScreen();

        /* renamed from: on */
        void mo22052on(int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$12 */
    class C1950212 implements C19515c {
        C1950212() {
        }

        public final int afA() {
            AppMethodBeat.m2504i(126473);
            int currPosSec = AppBrandVideoView.this.hYM.getCurrPosSec();
            AppMethodBeat.m2505o(126473);
            return currPosSec;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$6 */
    class C195036 implements C27129e {
        C195036() {
        }

        public final void onVisibilityChanged(boolean z) {
            AppMethodBeat.m2504i(126447);
            AppBrandVideoView.m30179C(AppBrandVideoView.this);
            AppMethodBeat.m2505o(126447);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$7 */
    class C195047 implements C19512d {
        C195047() {
        }

        /* renamed from: dd */
        public final void mo34676dd(int i, int i2) {
            AppMethodBeat.m2504i(126448);
            if (i2 <= 0) {
                AppMethodBeat.m2505o(126448);
                return;
            }
            int i3;
            if (i < 0) {
                i3 = 0;
            } else {
                i3 = i;
            }
            if (i3 > i2) {
                i3 = i2;
            }
            int width = (i3 * AppBrandVideoView.this.hYZ.getWidth()) / i2;
            LayoutParams layoutParams = (LayoutParams) AppBrandVideoView.this.hYY.getLayoutParams();
            layoutParams.width = width;
            AppBrandVideoView.this.hYY.setLayoutParams(layoutParams);
            AppBrandVideoView.this.hYY.requestLayout();
            AppMethodBeat.m2505o(126448);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$11 */
    class C1950511 implements C42593b {
        C1950511() {
        }

        /* renamed from: H */
        public final void mo34677H(String str, int i, int i2) {
            AppMethodBeat.m2504i(126465);
            C4990ab.m7417i("MicroMsg.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", str, Integer.valueOf(i), Integer.valueOf(i2));
            if (AppBrandVideoView.this.hZf != null) {
                C33404k d = AppBrandVideoView.this.hZf;
                d.clean();
                try {
                    JSONObject aFV = d.aFV();
                    aFV.put("errMsg", str);
                    d.mo53894a(new C33408d(), aFV);
                    AppMethodBeat.m2505o(126465);
                    return;
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "onError e=%s", e);
                }
            }
            AppMethodBeat.m2505o(126465);
        }

        public final void aFq() {
            AppMethodBeat.m2504i(126466);
            C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onPrepared");
            AppBrandVideoView.this.hZi.aFY();
            AppMethodBeat.m2505o(126466);
        }

        public final void aFr() {
            AppMethodBeat.m2504i(126467);
            C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onVideoEnded");
            AppBrandVideoView.this.hYN.setVisibility(8);
            AppBrandVideoView.this.hYQ.setVisibility(0);
            if (AppBrandVideoView.this.hYP.aFF()) {
                AppBrandVideoView.this.hYP.hide();
            }
            if (AppBrandVideoView.this.hZa.getVisibility() == 0) {
                AppBrandVideoView.this.hZa.setVisibility(8);
            }
            if (AppBrandVideoView.m30210v(AppBrandVideoView.this) || !AppBrandVideoView.this.hZr) {
                AppBrandVideoView.this.hYR.setVisibility(8);
            } else {
                if (AppBrandVideoView.this.mDuration <= 0) {
                    AppBrandVideoView.this.hYS.setText(AppBrandVideoView.m30203oz(AppBrandVideoView.this.hYM.getVideoDurationSec()));
                }
                AppBrandVideoView.this.hYR.setVisibility(0);
            }
            if (AppBrandVideoView.this.hZf != null) {
                C33404k d = AppBrandVideoView.this.hZf;
                try {
                    d.mo53894a(new C33406c(), d.aFV());
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "OnVideoEnded e=%s", e);
                }
                d.aFW();
                d.aFX();
            }
            if (AppBrandVideoView.this.hZl) {
                AppBrandVideoView.this.mo34624d(0.0d, true);
            }
            AppMethodBeat.m2505o(126467);
        }

        /* renamed from: de */
        public final void mo34684de(int i, int i2) {
            AppMethodBeat.m2504i(126468);
            C4990ab.m7417i("MicroMsg.AppBrandVideoView", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (AppBrandVideoView.this.f4352Yp == -1) {
                AppBrandVideoView.this.f4352Yp = i < i2 ? 0 : 90;
                C4990ab.m7417i("MicroMsg.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", Integer.valueOf(AppBrandVideoView.this.f4352Yp));
            }
            if (AppBrandVideoView.this.hZf != null) {
                C33404k d = AppBrandVideoView.this.hZf;
                try {
                    C4990ab.m7417i("MicroMsg.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(AppBrandVideoView.this.getDuration()));
                    JSONObject aFV = d.aFV();
                    aFV.put("width", i);
                    aFV.put("height", i2);
                    aFV.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, (((double) r2) * 1.0d) / 1000.0d);
                    d.mo53894a(new C33410f(), aFV);
                    AppMethodBeat.m2505o(126468);
                    return;
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", e);
                }
            }
            AppMethodBeat.m2505o(126468);
        }

        public final void aFs() {
            AppMethodBeat.m2504i(126469);
            C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onVideoPause");
            if (AppBrandVideoView.this.hZf != null) {
                C33404k d = AppBrandVideoView.this.hZf;
                try {
                    d.mo53894a(new C33412g(), d.aFV());
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "OnVideoPause e=%s", e);
                }
                d.aFW();
            }
            AppMethodBeat.m2505o(126469);
        }

        public final void aFt() {
            AppMethodBeat.m2504i(126470);
            C4990ab.m7417i("MicroMsg.AppBrandVideoView", "onVideoPlay, isLive:%b", Boolean.valueOf(AppBrandVideoView.m30210v(AppBrandVideoView.this)));
            if (AppBrandVideoView.this.mDuration <= 0 && !AppBrandVideoView.m30210v(AppBrandVideoView.this)) {
                AppBrandVideoView.this.hYS.setText(AppBrandVideoView.m30203oz(AppBrandVideoView.this.hYM.getVideoDurationSec()));
            }
            AppBrandVideoView.m30185a(AppBrandVideoView.this, AppBrandVideoView.m30210v(AppBrandVideoView.this));
            if (AppBrandVideoView.this.hZe) {
                AppBrandVideoView.m30179C(AppBrandVideoView.this);
            }
            if (AppBrandVideoView.this.hZf != null) {
                C33404k d = AppBrandVideoView.this.hZf;
                try {
                    d.iat = 0;
                    JSONObject aFV = d.aFV();
                    aFV.put("timeStamp", System.currentTimeMillis());
                    d.mo53894a(new C10560h(), aFV);
                    if (d.ias == null) {
                        d.ias = new C7564ap(new C334051(), true);
                    }
                    d.ias.mo16770ae(250, 250);
                    if (d.hZL == null) {
                        d.hZL = new C7564ap(new C334112(), true);
                    }
                    d.hZL.mo16770ae(500, 500);
                    AppMethodBeat.m2505o(126470);
                    return;
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "OnVideoPlay e=%s", e);
                }
            }
            AppMethodBeat.m2505o(126470);
        }

        public final void aFu() {
            AppMethodBeat.m2504i(126471);
            C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onVideoWaiting");
            if (AppBrandVideoView.this.hZf != null) {
                C33404k d = AppBrandVideoView.this.hZf;
                try {
                    JSONObject aFV = d.aFV();
                    aFV.put("timeStamp", System.currentTimeMillis());
                    d.mo53894a(new C33403m(), aFV);
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "onVideoWaiting e=%s", e);
                }
            }
            AppBrandVideoView.this.hZu = true;
            AppBrandVideoView.m30195j(AppBrandVideoView.this);
            AppMethodBeat.m2505o(126471);
        }

        public final void aFv() {
            AppMethodBeat.m2504i(126472);
            AppBrandVideoView.this.hZu = false;
            AppBrandVideoView.m30199n(AppBrandVideoView.this);
            AppMethodBeat.m2505o(126472);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$9 */
    class C195069 implements C10555f {
        C195069() {
        }

        /* renamed from: es */
        public final void mo22049es(boolean z) {
            AppMethodBeat.m2504i(126451);
            if (!z) {
                AppBrandVideoView.this.hYO.hide();
            } else if (AppBrandVideoView.this.hYM.isPlaying()) {
                AppBrandVideoView.this.hYO.show();
            } else {
                AppBrandVideoView.this.hYO.pause();
            }
            if (AppBrandVideoView.this.hZf != null) {
                C33404k d = AppBrandVideoView.this.hZf;
                int e = AppBrandVideoView.this.hZc;
                try {
                    C4990ab.m7417i("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", Boolean.valueOf(z));
                    JSONObject aFV = d.aFV();
                    aFV.put("showDanmu", z);
                    aFV.put("videoPlayerId", e);
                    d.mo53894a(new C27131b(), aFV);
                    AppMethodBeat.m2505o(126451);
                    return;
                } catch (JSONException e2) {
                    C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", e2);
                }
            }
            AppMethodBeat.m2505o(126451);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$b */
    public interface C19507b {
        /* renamed from: cM */
        AppBrandVideoView mo34685cM(Context context);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$1 */
    class C195081 implements OnClickListener {
        C195081() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126441);
            AppBrandVideoView.this.start();
            AppMethodBeat.m2505o(126441);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView$10 */
    class C1951010 implements C33416b {
        C1951010() {
        }

        public final void aFi() {
            AppMethodBeat.m2504i(126452);
            C4990ab.m7410d("MicroMsg.AppBrandVideoView", "onSingleTap");
            if (AppBrandVideoView.this.hZe && AppBrandVideoView.this.hYQ.getVisibility() != 0) {
                AppBrandVideoView.this.hYP.aFG();
                if (AppBrandVideoView.this.hZu) {
                    AppBrandVideoView.m30195j(AppBrandVideoView.this);
                }
            }
            AppMethodBeat.m2505o(126452);
        }

        public final void aFj() {
            AppMethodBeat.m2504i(126453);
            C4990ab.m7410d("MicroMsg.AppBrandVideoView", "onDoubleTap");
            if (AppBrandVideoView.this.hZv) {
                if (AppBrandVideoView.this.hYM.isPlaying()) {
                    AppBrandVideoView.this.pause();
                    AppMethodBeat.m2505o(126453);
                    return;
                }
                AppBrandVideoView.this.start();
            }
            AppMethodBeat.m2505o(126453);
        }

        public final void aFk() {
            AppMethodBeat.m2504i(126454);
            if (AppBrandVideoView.m30197l(AppBrandVideoView.this)) {
                AppBrandVideoView.this.hYN.setVisibility(0);
                AppBrandVideoView.m30195j(AppBrandVideoView.this);
                AppMethodBeat.m2505o(126454);
                return;
            }
            AppMethodBeat.m2505o(126454);
        }

        /* renamed from: i */
        public final int mo34699i(int i, float f) {
            AppMethodBeat.m2504i(126455);
            if (AppBrandVideoView.m30197l(AppBrandVideoView.this)) {
                C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onDragProgress:" + i + "/" + f);
                int videoDurationSec = AppBrandVideoView.this.hYM.getVideoDurationSec();
                int c = C27128b.m43113c(f, (float) AppBrandVideoView.this.getMeasuredWidth(), getCurrentPosition(), videoDurationSec);
                AppBrandVideoView.this.hYN.setText(C33417m.m54609fQ(((long) c) * 1000) + "/" + C33417m.m54609fQ(((long) videoDurationSec) * 1000));
                AppBrandVideoView.this.hYP.seek(c);
                if (AppBrandVideoView.this.hYP.aFF()) {
                    AppBrandVideoView.this.hYP.aFE();
                }
                AppMethodBeat.m2505o(126455);
                return c;
            }
            AppMethodBeat.m2505o(126455);
            return 0;
        }

        /* renamed from: j */
        public final void mo34700j(int i, float f) {
            AppMethodBeat.m2504i(126456);
            if (AppBrandVideoView.m30197l(AppBrandVideoView.this)) {
                AppBrandVideoView.this.hYN.setVisibility(8);
                AppBrandVideoView.m30199n(AppBrandVideoView.this);
                int currPosSec = AppBrandVideoView.this.hYM.getCurrPosSec();
                C4990ab.m7417i("MicroMsg.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i), Integer.valueOf(currPosSec), Float.valueOf(f));
                AppBrandVideoView.this.mo34624d((double) i, false);
                AppMethodBeat.m2505o(126456);
                return;
            }
            AppMethodBeat.m2505o(126456);
        }

        public final int getCurrentPosition() {
            AppMethodBeat.m2504i(126457);
            int currPosSec = AppBrandVideoView.this.hYM.getCurrPosSec();
            AppMethodBeat.m2505o(126457);
            return currPosSec;
        }

        public final boolean aFn() {
            AppMethodBeat.m2504i(139051);
            boolean s = AppBrandVideoView.m30207s(AppBrandVideoView.this);
            AppMethodBeat.m2505o(139051);
            return s;
        }

        public final boolean aFo() {
            AppMethodBeat.m2504i(139052);
            boolean s = AppBrandVideoView.m30207s(AppBrandVideoView.this);
            AppMethodBeat.m2505o(139052);
            return s;
        }

        public final boolean aFp() {
            AppMethodBeat.m2504i(126464);
            boolean l = AppBrandVideoView.m30197l(AppBrandVideoView.this);
            AppMethodBeat.m2505o(126464);
            return l;
        }

        /* renamed from: aq */
        public final void mo34696aq(float f) {
            AppMethodBeat.m2504i(126458);
            if (AppBrandVideoView.m30207s(AppBrandVideoView.this)) {
                C4990ab.m7410d("MicroMsg.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(f)));
                AppBrandVideoView.this.hYU.setPercent(f);
                AppBrandVideoView.this.hYV.setText(C25738R.string.cu9);
                AppBrandVideoView.this.hYW.setImageResource(C25738R.drawable.asi);
                AppBrandVideoView.this.hYT.setVisibility(0);
                AppBrandVideoView.m30195j(AppBrandVideoView.this);
                AppMethodBeat.m2505o(126458);
                return;
            }
            AppMethodBeat.m2505o(126458);
        }

        /* renamed from: ar */
        public final void mo34697ar(float f) {
            AppMethodBeat.m2504i(126459);
            if (AppBrandVideoView.m30207s(AppBrandVideoView.this)) {
                C4990ab.m7410d("MicroMsg.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(f)));
                AppBrandVideoView.this.hYU.setPercent(f);
                AppBrandVideoView.this.hYV.setText(C25738R.string.cu8);
                AppBrandVideoView.this.hYW.setImageResource(C25738R.drawable.asg);
                AppBrandVideoView.this.hYT.setVisibility(0);
                AppBrandVideoView.m30195j(AppBrandVideoView.this);
                AppMethodBeat.m2505o(126459);
                return;
            }
            AppMethodBeat.m2505o(126459);
        }

        public final void aFl() {
            AppMethodBeat.m2504i(126460);
            if (AppBrandVideoView.m30207s(AppBrandVideoView.this)) {
                AppBrandVideoView.this.hYT.setVisibility(8);
                AppBrandVideoView.m30199n(AppBrandVideoView.this);
                AppMethodBeat.m2505o(126460);
                return;
            }
            AppMethodBeat.m2505o(126460);
        }

        public final void aFm() {
            AppMethodBeat.m2504i(126461);
            if (AppBrandVideoView.m30207s(AppBrandVideoView.this)) {
                AppBrandVideoView.this.hYT.setVisibility(8);
                AppBrandVideoView.m30199n(AppBrandVideoView.this);
                AppMethodBeat.m2505o(126461);
                return;
            }
            AppMethodBeat.m2505o(126461);
        }
    }

    /* renamed from: j */
    static /* synthetic */ void m30195j(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.m2504i(126538);
        appBrandVideoView.aEZ();
        AppMethodBeat.m2505o(126538);
    }

    /* renamed from: l */
    static /* synthetic */ boolean m30197l(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.m2504i(126539);
        boolean aFd = appBrandVideoView.aFd();
        AppMethodBeat.m2505o(126539);
        return aFd;
    }

    /* renamed from: oz */
    static /* synthetic */ String m30203oz(int i) {
        AppMethodBeat.m2504i(126543);
        String ox = AppBrandVideoView.m30201ox(i);
        AppMethodBeat.m2505o(126543);
        return ox;
    }

    /* renamed from: s */
    static /* synthetic */ boolean m30207s(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.m2504i(126541);
        boolean aFe = appBrandVideoView.aFe();
        AppMethodBeat.m2505o(126541);
        return aFe;
    }

    /* renamed from: v */
    static /* synthetic */ boolean m30210v(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.m2504i(126542);
        boolean isLive = appBrandVideoView.isLive();
        AppMethodBeat.m2505o(126542);
        return isLive;
    }

    public static void setProxy(C19507b c19507b) {
        hYK = c19507b;
    }

    public static C19507b aEW() {
        return hYK;
    }

    public <T extends View & C45630d> AppBrandVideoView(Context context, T t) {
        super(context);
        AppMethodBeat.m2504i(126477);
        this.hYM = (C45630d) t;
        init(context);
        this.hYL.addView(t);
        AppMethodBeat.m2505o(126477);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(126478);
        init(context);
        AppMethodBeat.m2505o(126478);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(126479);
        init(context);
        AppMethodBeat.m2505o(126479);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(126480);
        LayoutInflater.from(context).inflate(2130968743, this);
        this.hYL = (RelativeLayout) findViewById(2131821402);
        this.hYN = (TextView) findViewById(2131821370);
        this.hYQ = findViewById(2131821403);
        this.hYR = findViewById(2131821405);
        this.hYS = (TextView) findViewById(2131821407);
        this.hYT = (LinearLayout) findViewById(2131821409);
        this.hYU = (AppBrandDotPercentIndicator) findViewById(2131821412);
        this.hYV = (TextView) findViewById(2131821411);
        this.hYW = (ImageView) findViewById(2131821410);
        this.hYX = (ImageView) findViewById(2131821404);
        this.hYY = (ImageView) findViewById(2131821415);
        this.hYZ = (ImageView) findViewById(2131821414);
        this.hZa = (FrameLayout) findViewById(2131821413);
        this.hYU.setDotsNum(8);
        ((ImageView) findViewById(2131821406)).setOnClickListener(new C195081());
        aEY();
        aFa();
        AppMethodBeat.m2505o(126480);
    }

    public void setComponent(C2241c c2241c) {
        AppMethodBeat.m2504i(126481);
        this.hZd = c2241c;
        this.mAppId = c2241c.getAppId();
        AppMethodBeat.m2505o(126481);
    }

    public void setConsumeTouchEvent(boolean z) {
        AppMethodBeat.m2504i(126482);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setConsumeTouchEvent game=%s", Boolean.valueOf(z));
        this.hZo = z;
        AppMethodBeat.m2505o(126482);
    }

    public void setVideoPlayerId(int i) {
        this.hZc = i;
    }

    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.m2504i(126483);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "showMuteBtn %b", Boolean.valueOf(z));
        this.hYP.setShowMuteBtn(z);
        AppMethodBeat.m2505o(126483);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(126484);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setTitle %s", str);
        this.hYP.setTitle(str);
        AppMethodBeat.m2505o(126484);
    }

    public void setShowControlProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(126485);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setShowControlProgress %b", Boolean.valueOf(z));
        C38399a c38399a = this.hYP;
        if (!z || isLive()) {
            z2 = false;
        }
        c38399a.setShowControlProgress(z2);
        AppMethodBeat.m2505o(126485);
    }

    public void setPlayBtnPosition(String str) {
        AppMethodBeat.m2504i(126486);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setPlayBtnPosition: %s", str);
        if (C5046bo.isNullOrNil(str) || !str.equalsIgnoreCase("center")) {
            this.hYP.setPlayBtnInCenterPosition(false);
            AppMethodBeat.m2505o(126486);
            return;
        }
        this.hYP.setPlayBtnInCenterPosition(true);
        AppMethodBeat.m2505o(126486);
    }

    public void setEnablePlayGesture(boolean z) {
        AppMethodBeat.m2504i(126487);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setEnablePlayGesture: %b", Boolean.valueOf(z));
        this.hZv = z;
        AppMethodBeat.m2505o(126487);
    }

    public void setAutoPlay(boolean z) {
        AppMethodBeat.m2504i(126488);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setAutoPlay =%b", Boolean.valueOf(z));
        this.mAutoPlay = z;
        AppMethodBeat.m2505o(126488);
    }

    public void setVideoSource(int i) {
        AppMethodBeat.m2504i(126489);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setVideoSource =%d", Integer.valueOf(i));
        this.hZs = i;
        AppMethodBeat.m2505o(126489);
    }

    public void setDuration(int i) {
        AppMethodBeat.m2504i(126490);
        if (i <= 0) {
            C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setDuration error duration=%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(126490);
            return;
        }
        this.hYS.setText(AppBrandVideoView.m30201ox(i));
        this.mDuration = i;
        AppMethodBeat.m2505o(126490);
    }

    public int getDuration() {
        AppMethodBeat.m2504i(126491);
        int i;
        if (this.mDuration > 0) {
            i = this.mDuration;
            AppMethodBeat.m2505o(126491);
            return i;
        }
        i = this.hYM.getVideoDurationSec();
        AppMethodBeat.m2505o(126491);
        return i;
    }

    public void setLoop(boolean z) {
        AppMethodBeat.m2504i(126492);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setLoop loop=%b", Boolean.valueOf(z));
        this.hZl = z;
        AppMethodBeat.m2505o(126492);
    }

    public void setAutoPauseIfNavigate(boolean z) {
        this.hLW = z;
    }

    public void setAutoPauseIfOpenNative(boolean z) {
        this.hLX = z;
    }

    public final void start() {
        AppMethodBeat.m2504i(126493);
        C4990ab.m7416i("MicroMsg.AppBrandVideoView", "start");
        if (this.hYM.isPlaying()) {
            AppMethodBeat.m2505o(126493);
            return;
        }
        if (this.hZe) {
            this.hYP.aFN();
        }
        this.hYQ.setVisibility(8);
        this.hYM.start();
        if (this.hYO != null && this.hYP.aFA()) {
            this.hYO.show();
        }
        ((C38401e) C37384e.m62985B(C38401e.class)).report(this.hZt);
        AppMethodBeat.m2505o(126493);
    }

    public final void pause() {
        AppMethodBeat.m2504i(126494);
        C4990ab.m7416i("MicroMsg.AppBrandVideoView", "pause");
        if (this.hYM.isPlaying()) {
            this.hYM.pause();
            if (this.hYO != null && this.hYP.aFA()) {
                this.hYO.pause();
            }
            AppMethodBeat.m2505o(126494);
            return;
        }
        AppMethodBeat.m2505o(126494);
    }

    public final void stop() {
        AppMethodBeat.m2504i(126495);
        C4990ab.m7416i("MicroMsg.AppBrandVideoView", "stop");
        if (this.hYM.isPlaying()) {
            this.hYM.stop();
            this.hYP.aFO();
            if (this.hYO != null) {
                this.hYO.hide();
            }
            AppMethodBeat.m2505o(126495);
            return;
        }
        AppMethodBeat.m2505o(126495);
    }

    public final void akW() {
        AppMethodBeat.m2504i(126496);
        C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onUIResume");
        if (this.hZw) {
            C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onUIResume, should skip ui resume");
            this.hZw = false;
            AppMethodBeat.m2505o(126496);
            return;
        }
        this.hYM.akW();
        AppMethodBeat.m2505o(126496);
    }

    /* renamed from: ow */
    public final void mo34636ow(int i) {
        AppMethodBeat.m2504i(126497);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "onUIPause, type:%d", Integer.valueOf(i));
        if ((i != 2 || this.hLX) && (i != 1 || this.hLW)) {
            this.hYM.akV();
            AppMethodBeat.m2505o(126497);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onUIPause, should skip ui pause");
        this.hZw = true;
        AppMethodBeat.m2505o(126497);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(126498);
        C4990ab.m7416i("MicroMsg.AppBrandVideoView", "onUIDestroy");
        clean();
        AppMethodBeat.m2505o(126498);
    }

    public final void clean() {
        AppMethodBeat.m2504i(126499);
        C4990ab.m7416i("MicroMsg.AppBrandVideoView", "clean");
        stop();
        this.hYM.aEX();
        if (this.hYO != null) {
            this.hYO.clear();
        }
        this.hYP.onDestroy();
        AppMethodBeat.m2505o(126499);
    }

    /* renamed from: e */
    public final void mo34625e(String str, boolean z, int i) {
        AppMethodBeat.m2504i(126500);
        if (!(this.hZd == null || this.hZd.asE() == null || !this.hZd.asE().mo5845ca(str))) {
            File yg = this.hZd.asE().mo34314yg(str);
            str = yg == null ? null : "file://" + yg.getAbsolutePath();
        }
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setVideoPath path=%s isLive=%s", str, Boolean.valueOf(z));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7418v("MicroMsg.AppBrandVideoView", "setVideoPath videoPath empty");
            AppMethodBeat.m2505o(126500);
            return;
        }
        stop();
        this.hZk = z;
        this.hZt = str;
        this.hYM.setVideoSource(this.hZs);
        this.hYM.mo61580c(z, str, i);
        if (this.hZm > 0.0d) {
            this.hYM.mo61581e(this.hZm, this.mAutoPlay);
        }
        if (this.hZs == 1) {
            String BR = ((C38401e) C37384e.m62985B(C38401e.class)).mo61109BR(this.hZt);
            if (BR != null) {
                C4990ab.m7416i("MicroMsg.AppBrandVideoView", "setVideoPath localVideoPath");
                String str2 = this.hZt;
                C4990ab.m7417i("MicroMsg.AppBrandVideoView", "leonlad setPreLoadVidePath videoPath=%s", BR);
                if (!this.hYM.isPlaying() && this.hZt.equalsIgnoreCase(str2)) {
                    this.hZt = str2;
                    this.hYM.mo61580c(this.hZk, BR, 0);
                    if (this.mAutoPlay) {
                        C4990ab.m7416i("MicroMsg.AppBrandVideoView", "setPreLoadVidePath autoPlay");
                        start();
                    }
                }
                if (this.hZf != null) {
                    C33404k c33404k = this.hZf;
                    try {
                        JSONObject aFV = c33404k.aFV();
                        aFV.put("timeStamp", System.currentTimeMillis());
                        aFV.put("url", str2);
                        c33404k.mo53894a(new C19519a(), aFV);
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "onVideoCanPlay e=%s", e);
                    }
                }
            }
        }
        if (this.mAutoPlay) {
            C4990ab.m7416i("MicroMsg.AppBrandVideoView", "setVideoPath autoPlay");
            start();
        }
        setCover(str);
        AppMethodBeat.m2505o(126500);
    }

    /* renamed from: d */
    public final void mo34624d(double d, boolean z) {
        AppMethodBeat.m2504i(126501);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", Double.valueOf(d), Integer.valueOf(this.hYM.getCurrPosSec()), Boolean.valueOf(this.hZk));
        if (isLive()) {
            AppMethodBeat.m2505o(126501);
            return;
        }
        this.hYQ.setVisibility(8);
        if (z) {
            this.hYM.mo61581e(d, z);
        } else {
            this.hYM.mo61590s(d);
        }
        if (this.hYO != null && ((double) r0) > d) {
            DanmuView danmuView = this.hYO;
            C4990ab.m7417i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", Integer.valueOf((int) d));
            danmuView.aGh();
            danmuView.aGj();
            danmuView.prepare();
            C7305d.post(new C195135(r1), "DanmuView-seekToPlayTime");
        }
        AppMethodBeat.m2505o(126501);
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.m2504i(126502);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setIsShowBasicControls isShowBasicControls=%b", Boolean.valueOf(z));
        this.hZe = z;
        if (this.hYP != null) {
            if (this.hZe) {
                this.hYP.aFD();
                AppMethodBeat.m2505o(126502);
                return;
            }
            this.hYP.hide();
        }
        AppMethodBeat.m2505o(126502);
    }

    public final void setCover$16da05f7(String str) {
        AppMethodBeat.m2504i(126503);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setCover coverUrl=%s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(126503);
            return;
        }
        this.hZn = str;
        C37926b.abR().mo60683a(this.hYX, str, null, null);
        AppMethodBeat.m2505o(126503);
    }

    private void setCover(final String str) {
        AppMethodBeat.m2504i(126504);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(126504);
        } else if (C5046bo.isNullOrNil(this.hZn)) {
            C45673m.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(126450);
                    final Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(126449);
                            if (!(createVideoThumbnail == null || createVideoThumbnail.isRecycled())) {
                                AppBrandVideoView.this.hYX.setImageBitmap(createVideoThumbnail);
                            }
                            AppMethodBeat.m2505o(126449);
                        }
                    });
                    AppMethodBeat.m2505o(126450);
                }
            });
            AppMethodBeat.m2505o(126504);
        } else {
            C4990ab.m7416i("MicroMsg.AppBrandVideoView", "setCover mCoverUrl not null");
            AppMethodBeat.m2505o(126504);
        }
    }

    public void setShowProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(126505);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setShowProgress %b", Boolean.valueOf(z));
        this.hZq = z;
        C38399a c38399a = this.hYP;
        if (!z || isLive()) {
            z2 = false;
        }
        c38399a.setShowProgress(z2);
        AppMethodBeat.m2505o(126505);
    }

    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.m2504i(126506);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setShowFullScreenBtn %b", Boolean.valueOf(z));
        this.hYP.setShowFullScreenBtn(z);
        AppMethodBeat.m2505o(126506);
    }

    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.m2504i(126507);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setShowPlayBtn %b", Boolean.valueOf(z));
        this.hYP.setShowPlayBtn(z);
        AppMethodBeat.m2505o(126507);
    }

    /* renamed from: eq */
    public final void mo34626eq(boolean z) {
        AppMethodBeat.m2504i(126508);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "enableProgressGesture %b", Boolean.valueOf(z));
        this.hZp = z;
        AppMethodBeat.m2505o(126508);
    }

    public void setShowCenterPlayBtn(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(126509);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setPlayBtnInCenterPosition %b", Boolean.valueOf(z));
        this.hZr = z;
        this.hYQ.setVisibility(z ? 0 : 8);
        View view = this.hYR;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        if (this.hZr && this.hYP != null) {
            this.hYP.hide();
        }
        AppMethodBeat.m2505o(126509);
    }

    public void setDanmakuEnable(boolean z) {
        AppMethodBeat.m2504i(126510);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setDanmakuEnable isEnable=%b", Boolean.valueOf(z));
        this.hYP.setDanmakuBtnOpen(z);
        AppMethodBeat.m2505o(126510);
    }

    public void setShowDanmakuBtn(boolean z) {
        AppMethodBeat.m2504i(126511);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setShowDanmakuBtn showDanmakuBtn=%b", Boolean.valueOf(z));
        if (z) {
            if (this.hYO == null) {
                aFc();
            }
            this.hYP.setDanmakuBtnOnClickListener(new C195069());
        }
        this.hYP.setShowDanmakuBtn(z);
        AppMethodBeat.m2505o(126511);
    }

    public void setObjectFit(String str) {
        AppMethodBeat.m2504i(126512);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setObjectFit objectFit=%s", str);
        if ("fill".equalsIgnoreCase(str)) {
            this.hYM.setScaleType(C27130g.FILL);
            this.hYX.setScaleType(ScaleType.FIT_XY);
            AppMethodBeat.m2505o(126512);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.hYM.setScaleType(C27130g.COVER);
            this.hYX.setScaleType(ScaleType.CENTER_CROP);
            AppMethodBeat.m2505o(126512);
        } else {
            this.hYM.setScaleType(C27130g.CONTAIN);
            this.hYX.setScaleType(ScaleType.FIT_CENTER);
            AppMethodBeat.m2505o(126512);
        }
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(126513);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setMute isMute=%b", Boolean.valueOf(z));
        this.mIsMute = z;
        this.hYM.setMute(z);
        this.hYP.setMuteBtnState(z);
        AppMethodBeat.m2505o(126513);
    }

    public void setCookieData(String str) {
        this.hZb = str;
    }

    public String getCookieData() {
        return this.hZb;
    }

    public int getCurrPosSec() {
        AppMethodBeat.m2504i(126514);
        int currPosSec = this.hYM.getCurrPosSec();
        AppMethodBeat.m2505o(126514);
        return currPosSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.m2504i(126515);
        int currPosMs = this.hYM.getCurrPosMs();
        AppMethodBeat.m2505o(126515);
        return currPosMs;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.m2504i(126516);
        if (this.hYM != null) {
            int cacheTimeSec = this.hYM.getCacheTimeSec();
            AppMethodBeat.m2505o(126516);
            return cacheTimeSec;
        }
        AppMethodBeat.m2505o(126516);
        return 0;
    }

    public void setFullScreenDirection(int i) {
        AppMethodBeat.m2504i(126517);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setFullScreenDirection %d", Integer.valueOf(i));
        this.f4352Yp = i;
        AppMethodBeat.m2505o(126517);
    }

    public void setPageGesture(boolean z) {
        AppMethodBeat.m2504i(126518);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setPageGesture pageGesture=%b", Boolean.valueOf(z));
        this.hZg = z;
        AppMethodBeat.m2505o(126518);
    }

    public void setPageGestureInFullscreen(boolean z) {
        AppMethodBeat.m2504i(126519);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setPageGestureInFullscreen pageGestureInFullscreen=%b", Boolean.valueOf(z));
        this.hZh = z;
        AppMethodBeat.m2505o(126519);
    }

    public void setInitialTime(double d) {
        AppMethodBeat.m2504i(126520);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "setInitialTime initialTime=%s", Double.valueOf(d));
        this.hZm = d;
        AppMethodBeat.m2505o(126520);
    }

    public void setCallback(C33404k c33404k) {
        this.hZf = c33404k;
    }

    public void setDanmakuItemList(JSONArray jSONArray) {
        AppMethodBeat.m2504i(126521);
        if (jSONArray == null) {
            AppMethodBeat.m2505o(126521);
            return;
        }
        String str = "MicroMsg.AppBrandVideoView";
        String str2 = "setDanmakuItemList length=%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(jSONArray != null ? jSONArray.length() : 0);
        C4990ab.m7417i(str, str2, objArr);
        if (this.hYO == null) {
            C4990ab.m7420w("MicroMsg.AppBrandVideoView", " setDanmakuItemList mDanmakuView null");
            aFc();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj;
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                obj = null;
            } else {
                int optInt = optJSONObject.optInt("time", 0);
                String optString = optJSONObject.optString("text", "");
                int Ee = C42668g.m75551Ee(optJSONObject.optString("color", ""));
                if (Ee == 0) {
                    Ee = -1;
                }
                C24704a obj2 = new C24704a(getContext(), new SpannableString(optString), Ee, optInt);
            }
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        DanmuView danmuView = this.hYO;
        danmuView.aGh();
        danmuView.aGj();
        danmuView.ibg.clear();
        danmuView.prepare();
        if (arrayList.isEmpty()) {
            danmuView.aGi();
            AppMethodBeat.m2505o(126521);
            return;
        }
        new C334004(arrayList).start();
        danmuView.aGi();
        AppMethodBeat.m2505o(126521);
    }

    /* renamed from: co */
    public final boolean mo34623co(String str, String str2) {
        AppMethodBeat.m2504i(126522);
        if (this.hYO == null) {
            C4990ab.m7420w("MicroMsg.AppBrandVideoView", " addDanmaku mDanmakuView null");
            aFc();
        }
        int Ee = C42668g.m75551Ee(str2);
        if (Ee == 0) {
            Ee = -1;
        }
        C24704a c24704a = new C24704a(getContext(), new SpannableString(str), Ee, this.hYM.getCurrPosSec());
        DanmuView danmuView = this.hYO;
        synchronized (danmuView.ibf) {
            try {
                danmuView.ibf.offerFirst(c24704a);
                C7305d.post(new C333993(c24704a), "DanmuView-addItemToWaitingHead");
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(126522);
            }
        }
        return true;
    }

    public void setFullScreenDelegate(C19501a c19501a) {
        this.hZj = c19501a;
    }

    public C33404k getCallback() {
        return this.hZf;
    }

    private void aEY() {
        AppMethodBeat.m2504i(126523);
        this.hZi = new C33414l(getContext(), this, new C1951010());
        AppMethodBeat.m2505o(126523);
    }

    private void aEZ() {
        AppMethodBeat.m2504i(126524);
        this.hYP.aEZ();
        AppMethodBeat.m2505o(126524);
    }

    private void aFa() {
        AppMethodBeat.m2504i(126525);
        this.hYM.setIMMVideoViewCallback(new C1950511());
        AppMethodBeat.m2505o(126525);
    }

    /* renamed from: j */
    public final void mo34634j(boolean z, int i) {
        AppMethodBeat.m2504i(126527);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.hZj == null) {
            C4990ab.m7420w("MicroMsg.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
            AppMethodBeat.m2505o(126527);
        } else if (z == aFb()) {
            C4990ab.m7416i("MicroMsg.AppBrandVideoView", "operateFullScreen current same");
            AppMethodBeat.m2505o(126527);
        } else {
            int i2;
            if (i == -1) {
                i2 = this.f4352Yp == -1 ? 90 : this.f4352Yp;
                C4990ab.m7417i("MicroMsg.AppBrandVideoView", "operateFullScreen target direction:%d", Integer.valueOf(i2));
            } else {
                i2 = i;
            }
            if (z) {
                this.hLe = i2;
                this.hZj.mo22052on(i2);
                this.hYP.aFH();
                mo34627er(true);
                AppMethodBeat.m2505o(126527);
                return;
            }
            this.hZj.aDF();
            this.hYP.aDF();
            AppMethodBeat.m2505o(126527);
        }
    }

    public final boolean aFb() {
        AppMethodBeat.m2504i(126528);
        if (this.hZj == null) {
            C4990ab.m7420w("MicroMsg.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
            AppMethodBeat.m2505o(126528);
            return false;
        }
        boolean isFullScreen = this.hZj.isFullScreen();
        AppMethodBeat.m2505o(126528);
        return isFullScreen;
    }

    private void aFc() {
        AppMethodBeat.m2504i(126529);
        this.hYO = (DanmuView) findViewById(2131821408);
        this.hYO.setDanmuViewCallBack(new C1950212());
        this.hYO.aGm();
        this.hYO.setMaxRunningPerRow(5);
        this.hYO.setPickItemInterval(200);
        this.hYO.hide();
        if (this.hYM != null && ((View) this.hYM).getHeight() > 0) {
            int height = (int) (((float) ((View) this.hYM).getHeight()) * this.hYO.getYOffset());
            this.hYO.setMaxRow((int) (((float) height) / C19514b.m30236cO(getContext())));
        }
        AppMethodBeat.m2505o(126529);
    }

    /* renamed from: a */
    public final void mo34618a(C38399a c38399a) {
        AppMethodBeat.m2504i(126530);
        this.hYP = c38399a;
        this.hYP.hide();
        this.hYP.setFullScreenBtnOnClickListener(new C1054813());
        this.hYP.setIplaySeekCallback(new C1054914());
        this.hYP.setOnPlayButtonClickListener(new C105502());
        this.hYP.setStatePorter(new C195003());
        this.hYP.setMuteBtnOnClickListener(new C105514());
        this.hYP.setExitFullScreenBtnOnClickListener(new C105525());
        this.hYP.setOnVisibilityChangedListener(new C195036());
        this.hYP.setOnUpdateProgressLenListener(new C195047());
        this.hYM.setControlBar(c38399a);
        AppMethodBeat.m2505o(126530);
    }

    /* renamed from: ox */
    private static String m30201ox(int i) {
        AppMethodBeat.m2504i(126531);
        String str = AppBrandVideoView.m30202oy(i / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AppBrandVideoView.m30202oy(i % 60);
        AppMethodBeat.m2505o(126531);
        return str;
    }

    /* renamed from: oy */
    private static String m30202oy(int i) {
        AppMethodBeat.m2504i(126532);
        String concat;
        if (i < 10) {
            concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i));
            AppMethodBeat.m2505o(126532);
            return concat;
        }
        concat = String.valueOf(i);
        AppMethodBeat.m2505o(126532);
        return concat;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: er */
    public final void mo34627er(boolean z) {
        AppMethodBeat.m2504i(126533);
        if (this.hZf == null) {
            AppMethodBeat.m2505o(126533);
            return;
        }
        this.hZf.mo53898c(this.hZc, z, this.hLe);
        AppMethodBeat.m2505o(126533);
    }

    private boolean isLive() {
        AppMethodBeat.m2504i(126534);
        C4990ab.m7417i("MicroMsg.AppBrandVideoView", "isLive %b %b", Boolean.valueOf(this.hZk), Boolean.valueOf(this.hYM.isLive()));
        if (this.hZk || this.hYM.isLive()) {
            AppMethodBeat.m2505o(126534);
            return true;
        }
        AppMethodBeat.m2505o(126534);
        return false;
    }

    private boolean aFd() {
        AppMethodBeat.m2504i(126535);
        if (!this.hZp || this.hYM.isLive() || aFf()) {
            AppMethodBeat.m2505o(126535);
            return false;
        }
        AppMethodBeat.m2505o(126535);
        return true;
    }

    private boolean aFe() {
        AppMethodBeat.m2504i(126536);
        if (aFf() || ((aFb() || !this.hZg) && !(aFb() && this.hZh))) {
            AppMethodBeat.m2505o(126536);
            return false;
        }
        AppMethodBeat.m2505o(126536);
        return true;
    }

    private boolean aFf() {
        AppMethodBeat.m2504i(126537);
        if (this.hYQ.getVisibility() == 0) {
            AppMethodBeat.m2505o(126537);
            return true;
        }
        AppMethodBeat.m2505o(126537);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.m2504i(126526);
        if (this.hZv) {
            z = true;
        } else {
            z = aFd();
            if (!aFe()) {
                z = false;
            }
        }
        if (z) {
            if (this.hZi != null) {
                this.hZi.mo53904z(motionEvent);
            }
            AppMethodBeat.m2505o(126526);
            return true;
        }
        if (motionEvent.getAction() == 0 && this.hZe && this.hYQ.getVisibility() != 0) {
            this.hYP.aFG();
            if (this.hZu) {
                aEZ();
            }
        }
        if (this.hZo) {
            AppMethodBeat.m2505o(126526);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(126526);
        return onTouchEvent;
    }

    /* renamed from: n */
    static /* synthetic */ void m30199n(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.m2504i(126540);
        appBrandVideoView.hYP.aFy();
        AppMethodBeat.m2505o(126540);
    }

    /* renamed from: C */
    static /* synthetic */ void m30179C(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.m2504i(126545);
        boolean aFR = appBrandVideoView.hYP.aFR();
        if (!appBrandVideoView.hZe || !appBrandVideoView.hZq || aFR || appBrandVideoView.isLive() || appBrandVideoView.aFf()) {
            appBrandVideoView.hZa.setVisibility(8);
            AppMethodBeat.m2505o(126545);
            return;
        }
        appBrandVideoView.hZa.setVisibility(0);
        AppMethodBeat.m2505o(126545);
    }
}
