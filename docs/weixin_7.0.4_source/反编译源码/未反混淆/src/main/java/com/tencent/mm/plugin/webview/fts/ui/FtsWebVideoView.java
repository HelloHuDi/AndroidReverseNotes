package com.tencent.mm.plugin.webview.fts.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

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
    private b ugO = b.AUTO;
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
    private a ugZ;
    private a uha;
    private int uhb;
    private d uhc;
    private com.tencent.mm.plugin.webview.fts.c.b.a uhd;
    private int uhe;
    private boolean uhf;
    private long uhg;
    private View uhh;
    private View uhi;
    private c uhj = c.UNKNOWN;
    public BroadcastReceiver uhk = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(5835);
            if (FtsWebVideoView.this.ugP.isPlaying()) {
                FtsWebVideoView.a(FtsWebVideoView.this, context);
            }
            AppMethodBeat.o(5835);
        }
    };
    private String url;

    public interface a {
        void aDF();

        boolean isFullScreen();

        void nI(boolean z);
    }

    enum b {
        AUTO,
        LANDSCAPE,
        PORTRAIT;

        static {
            AppMethodBeat.o(5859);
        }
    }

    enum c {
        UNKNOWN,
        MOBILE_NET,
        NO_NET;

        static {
            AppMethodBeat.o(5862);
        }
    }

    static /* synthetic */ void a(FtsWebVideoView ftsWebVideoView, String str, String str2) {
        AppMethodBeat.i(5908);
        ftsWebVideoView.gZ(str, str2);
        AppMethodBeat.o(5908);
    }

    static /* synthetic */ void b(FtsWebVideoView ftsWebVideoView, Context context) {
        AppMethodBeat.i(5905);
        ftsWebVideoView.fp(context);
        AppMethodBeat.o(5905);
    }

    static /* synthetic */ boolean e(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.i(5906);
        boolean cWw = ftsWebVideoView.cWw();
        AppMethodBeat.o(5906);
        return cWw;
    }

    static /* synthetic */ boolean i(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.i(5907);
        boolean cWx = ftsWebVideoView.cWx();
        AppMethodBeat.o(5907);
        return cWx;
    }

    static /* synthetic */ boolean t(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.i(5910);
        boolean isLive = ftsWebVideoView.isLive();
        AppMethodBeat.o(5910);
        return isLive;
    }

    public FtsWebVideoView(Context context, boolean z) {
        super(context);
        AppMethodBeat.i(5863);
        setAutoPlay(z);
        init(context);
        AppMethodBeat.o(5863);
    }

    public FtsWebVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(5864);
        init(context);
        AppMethodBeat.o(5864);
    }

    public FtsWebVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(5865);
        init(context);
        AppMethodBeat.o(5865);
    }

    private void init(Context context) {
        AppMethodBeat.i(5866);
        LayoutInflater.from(context).inflate(R.layout.a20, this);
        this.ugP = (FtsVideoWrapper) findViewById(R.id.wh);
        this.hYN = (TextView) findViewById(R.id.vm);
        this.ugR = findViewById(R.id.bzx);
        this.ugS = findViewById(R.id.c00);
        this.hYT = (LinearLayout) findViewById(R.id.wo);
        this.ugT = (WebSearchDotPercentIndicator) findViewById(R.id.wr);
        this.hYV = (TextView) findViewById(R.id.wq);
        this.hYW = (ImageView) findViewById(R.id.wp);
        this.hYX = (ImageView) findViewById(R.id.wj);
        this.uhh = findViewById(R.id.a9d);
        this.uhi = findViewById(R.id.c01);
        this.ugT.setDotsNum(8);
        this.sDt = (ImageView) findViewById(R.id.bzz);
        this.ugU = findViewById(R.id.bzy);
        this.ugW = (TextView) findViewById(R.id.c04);
        this.ugV = (Button) findViewById(R.id.c03);
        this.ugX = (TextView) findViewById(R.id.c02);
        this.uco = (ImageView) findViewById(R.id.wx);
        this.ugW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(5823);
                FtsWebVideoView.this.pause();
                AppMethodBeat.o(5823);
            }
        });
        this.uco.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(5832);
                FtsWebVideoView.this.nH(!FtsWebVideoView.this.aFb());
                AppMethodBeat.o(5832);
            }
        });
        this.ugV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(5833);
                if (FtsWebVideoView.this.uhj == c.MOBILE_NET) {
                    FtsWebVideoView.this.uhf = true;
                }
                FtsWebVideoView.this.cg(true);
                AppMethodBeat.o(5833);
            }
        });
        this.ugU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(5834);
                FtsWebVideoView.this.cg(true);
                FtsWebVideoView.this.ugQ.aFE();
                AppMethodBeat.o(5834);
            }
        });
        aEY();
        aFa();
        aZb();
        context.registerReceiver(this.uhk, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        cWv();
        AppMethodBeat.o(5866);
    }

    private boolean fo(final Context context) {
        AppMethodBeat.i(5867);
        c cVar = this.uhj;
        if (!at.isConnected(context)) {
            if (cVar == c.NO_NET) {
                this.uhh.setVisibility(0);
                this.uhi.setVisibility(8);
                this.ugR.setVisibility(0);
                postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(5836);
                        FtsWebVideoView.b(FtsWebVideoView.this, context);
                        AppMethodBeat.o(5836);
                    }
                }, 200);
            } else {
                fp(context);
            }
            AppMethodBeat.o(5867);
            return false;
        } else if (this.uhf || at.isWifi(context)) {
            AppMethodBeat.o(5867);
            return true;
        } else {
            pause();
            this.uhj = c.MOBILE_NET;
            this.ugQ.setVisibility(8);
            String netUnavailableTip = getNetUnavailableTip();
            String string = context.getString(R.string.f10);
            context.getString(R.string.f0x);
            gZ(netUnavailableTip, string);
            AppMethodBeat.o(5867);
            return false;
        }
    }

    private void fp(Context context) {
        AppMethodBeat.i(5868);
        this.uhj = c.NO_NET;
        pause();
        gZ(context.getString(R.string.f1e), context.getString(R.string.f1r));
        AppMethodBeat.o(5868);
    }

    private String getNetUnavailableTip() {
        AppMethodBeat.i(5869);
        String string;
        if (this.uhe == 0) {
            string = getContext().getString(R.string.f1g);
            AppMethodBeat.o(5869);
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
        string = context.getString(R.string.f1f, objArr);
        AppMethodBeat.o(5869);
        return string;
    }

    private void gZ(String str, String str2) {
        AppMethodBeat.i(5870);
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
        AppMethodBeat.o(5870);
    }

    private void cWu() {
        AppMethodBeat.i(5871);
        if (aFb()) {
            this.uco.setVisibility(0);
            AppMethodBeat.o(5871);
            return;
        }
        this.uco.setVisibility(8);
        AppMethodBeat.o(5871);
    }

    public void setAppId(String str) {
        AppMethodBeat.i(5872);
        ab.i("MicroMsg.FtsWebVideoView", "setAppId appid=%s", str);
        this.mAppId = str;
        AppMethodBeat.o(5872);
    }

    public void setVideoPlayerId(int i) {
        this.hZc = i;
    }

    public int getmVideoPlayerId() {
        return this.hZc;
    }

    public void setAutoPlay(boolean z) {
        AppMethodBeat.i(5873);
        ab.i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", Boolean.valueOf(z));
        this.mAutoPlay = z;
        AppMethodBeat.o(5873);
    }

    public void setDuration(int i) {
        AppMethodBeat.i(5874);
        if (i <= 0) {
            ab.i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", Integer.valueOf(i));
            AppMethodBeat.o(5874);
            return;
        }
        AppMethodBeat.o(5874);
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(5875);
        ab.i("MicroMsg.FtsWebVideoView", "setLoop loop=%b", Boolean.valueOf(z));
        this.hZl = z;
        AppMethodBeat.o(5875);
    }

    public final void cg(boolean z) {
        AppMethodBeat.i(5876);
        ab.i("MicroMsg.FtsWebVideoView", "start");
        cWv();
        if (!z || fo(getContext())) {
            this.uhj = c.UNKNOWN;
            if (this.ugP.isPlaying()) {
                AppMethodBeat.o(5876);
                return;
            }
            if (this.hZe) {
                WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = this.ugQ;
                if (webSearchWebVideoViewControlBar.hZL == null) {
                    webSearchWebVideoViewControlBar.hZL = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                        public final boolean BI() {
                            AppMethodBeat.i(73837);
                            if (WebSearchWebVideoViewControlBar.b(WebSearchWebVideoViewControlBar.this)) {
                                AppMethodBeat.o(73837);
                                return true;
                            }
                            AppMethodBeat.o(73837);
                            return false;
                        }
                    }, true);
                }
                webSearchWebVideoViewControlBar.aFP();
                webSearchWebVideoViewControlBar.hZL.stopTimer();
                webSearchWebVideoViewControlBar.hZL.ae(500, 500);
            }
            this.ugP.start();
            if (this.uhg == 0) {
                this.uhg = System.currentTimeMillis();
                AppMethodBeat.o(5876);
                return;
            }
            this.uhg = Long.MAX_VALUE;
            AppMethodBeat.o(5876);
            return;
        }
        ab.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
        AppMethodBeat.o(5876);
    }

    private void cWv() {
        AppMethodBeat.i(5877);
        this.ugR.setVisibility(8);
        AppMethodBeat.o(5877);
    }

    public final void pause() {
        AppMethodBeat.i(5878);
        ab.i("MicroMsg.FtsWebVideoView", "pause");
        cWv();
        if (this.ugP.isPlaying()) {
            this.ugP.pause();
            AppMethodBeat.o(5878);
            return;
        }
        AppMethodBeat.o(5878);
    }

    public final void stop() {
        AppMethodBeat.i(5879);
        ab.i("MicroMsg.FtsWebVideoView", "stop");
        if (this.ugP.isPlaying()) {
            this.ugP.stop();
            WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = this.ugQ;
            if (webSearchWebVideoViewControlBar.hZL != null) {
                webSearchWebVideoViewControlBar.hZL.stopTimer();
            }
            AppMethodBeat.o(5879);
            return;
        }
        AppMethodBeat.o(5879);
    }

    public final void bL(String str, int i) {
        AppMethodBeat.i(5880);
        ab.i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", str, Boolean.FALSE);
        this.url = str;
        if (bo.isNullOrNil(str)) {
            ab.v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
            AppMethodBeat.o(5880);
            return;
        }
        stop();
        this.hZk = false;
        this.ugP.c(false, str, i);
        if (this.ugQ != null) {
            this.ugQ.setVideoTotalTime(i);
        }
        if (this.uhb > 0) {
            this.ugP.s((double) this.uhb);
        }
        if (this.mAutoPlay) {
            ab.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
            cg(false);
        }
        if (str.startsWith("wxfile://")) {
            setCover(str);
        }
        AppMethodBeat.o(5880);
    }

    public final void ar(int i, boolean z) {
        AppMethodBeat.i(5881);
        int currPosSec = this.ugP.getCurrPosSec();
        ab.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", Integer.valueOf(i), Integer.valueOf(currPosSec), Boolean.valueOf(this.hZk));
        if (isLive()) {
            AppMethodBeat.o(5881);
        } else if (z) {
            this.ugP.e((double) i, z);
            AppMethodBeat.o(5881);
        } else {
            this.ugP.s((double) i);
            AppMethodBeat.o(5881);
        }
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(5882);
        ab.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", Boolean.valueOf(z));
        this.hZe = z;
        AppMethodBeat.o(5882);
    }

    public final void setCover$16da05f7(String str) {
        AppMethodBeat.i(5883);
        ab.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(5883);
            return;
        }
        this.hZn = str;
        com.tencent.mm.modelappbrand.a.b.abR().a(this.hYX, str, null, null);
        AppMethodBeat.o(5883);
    }

    private void setCover(String str) {
        AppMethodBeat.i(5884);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(5884);
        } else if (bo.isNullOrNil(this.hZn)) {
            AppMethodBeat.o(5884);
        } else {
            ab.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
            AppMethodBeat.o(5884);
        }
    }

    public void setObjectFit(String str) {
        AppMethodBeat.i(5885);
        ab.i("MicroMsg.FtsWebVideoView", "setObjectFit objectFit=%s", str);
        if ("fill".equalsIgnoreCase(str)) {
            this.ugP.setScaleType(h.d.FILL);
            this.hYX.setScaleType(ScaleType.FIT_XY);
            AppMethodBeat.o(5885);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.ugP.setScaleType(h.d.COVER);
            this.hYX.setScaleType(ScaleType.CENTER_CROP);
            AppMethodBeat.o(5885);
        } else {
            this.ugP.setScaleType(h.d.CONTAIN);
            this.hYX.setScaleType(ScaleType.FIT_CENTER);
            AppMethodBeat.o(5885);
        }
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(5886);
        ab.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", Boolean.valueOf(z));
        this.eif = z;
        this.ugP.setMute(z);
        if (z) {
            this.ugQ.NO();
            AppMethodBeat.o(5886);
            return;
        }
        this.ugQ.cVM();
        AppMethodBeat.o(5886);
    }

    public void setCookieData(String str) {
        this.hZb = str;
    }

    public String getCookieData() {
        return this.hZb;
    }

    public int getCurrPosSec() {
        AppMethodBeat.i(5887);
        int currPosSec = this.ugP.getCurrPosSec();
        AppMethodBeat.o(5887);
        return currPosSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.i(5888);
        int currPosMs = this.ugP.getCurrPosMs();
        AppMethodBeat.o(5888);
        return currPosMs;
    }

    public void setFullScreenDirection(String str) {
        AppMethodBeat.i(5889);
        ab.i("MicroMsg.FtsWebVideoView", "setFullScreenDirection %s", str);
        if (MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL.equalsIgnoreCase(str)) {
            this.ugO = b.LANDSCAPE;
            AppMethodBeat.o(5889);
        } else if ("vertical".equalsIgnoreCase(str)) {
            this.ugO = b.PORTRAIT;
            AppMethodBeat.o(5889);
        } else {
            this.ugO = b.AUTO;
            AppMethodBeat.o(5889);
        }
    }

    public void setDisableScroll(boolean z) {
        AppMethodBeat.i(5890);
        ab.i("MicroMsg.FtsWebVideoView", "setDisableScroll isDisableScroll=%b", Boolean.valueOf(z));
        this.ugY = z;
        AppMethodBeat.o(5890);
    }

    public void setPageGesture(boolean z) {
        AppMethodBeat.i(5891);
        ab.i("MicroMsg.FtsWebVideoView", "setPageGesture pageGesture=%b", Boolean.valueOf(z));
        this.hZg = z;
        AppMethodBeat.o(5891);
    }

    public void setInitialTime(int i) {
        AppMethodBeat.i(5892);
        ab.i("MicroMsg.FtsWebVideoView", "setInitialTime initialTime=%d", Integer.valueOf(i));
        this.uhb = i;
        AppMethodBeat.o(5892);
    }

    public void setCallback(d dVar) {
        this.uhc = dVar;
    }

    public void setFullScreenDelegate(a aVar) {
        this.uha = aVar;
    }

    public d getCallback() {
        return this.uhc;
    }

    private void aEY() {
        AppMethodBeat.i(5893);
        this.ugZ = new a(getContext(), this, new com.tencent.mm.plugin.webview.fts.ui.a.b() {
            public final void aFi() {
                AppMethodBeat.i(5837);
                ab.d("MicroMsg.FtsWebVideoView", "onSingleTap");
                if (FtsWebVideoView.e(FtsWebVideoView.this)) {
                    FtsWebVideoView.this.ugQ.nG(FtsWebVideoView.this.isLoading);
                }
                AppMethodBeat.o(5837);
            }

            public final void aFj() {
                AppMethodBeat.i(5838);
                ab.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
                AppMethodBeat.o(5838);
            }

            public final void aFk() {
                AppMethodBeat.i(5839);
                if (FtsWebVideoView.this.ugP.isLive()) {
                    ab.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
                    AppMethodBeat.o(5839);
                    return;
                }
                FtsWebVideoView.this.hYN.setVisibility(0);
                FtsWebVideoView.this.ugQ.cHe();
                AppMethodBeat.o(5839);
            }

            public final int i(int i, float f) {
                int i2 = 0;
                AppMethodBeat.i(5840);
                if (FtsWebVideoView.this.ugP.isLive()) {
                    ab.i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
                    AppMethodBeat.o(5840);
                } else {
                    ab.i("MicroMsg.FtsWebVideoView", "onDragProgress:" + i + "/" + f);
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
                    FtsWebVideoView.this.hYN.setText(com.tencent.mm.plugin.webview.fts.c.c.fQ(((long) i2) * 1000) + "/" + com.tencent.mm.plugin.webview.fts.c.c.fQ(((long) videoDurationSec) * 1000));
                    AppMethodBeat.o(5840);
                }
                return i2;
            }

            public final void j(int i, float f) {
                AppMethodBeat.i(5841);
                FtsWebVideoView.this.ugQ.cHf();
                FtsWebVideoView.this.hYN.setVisibility(8);
                int currPosSec = FtsWebVideoView.this.ugP.getCurrPosSec();
                ab.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i), Integer.valueOf(currPosSec), Float.valueOf(f));
                if (FtsWebVideoView.this.ugP.isLive()) {
                    ab.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
                    AppMethodBeat.o(5841);
                    return;
                }
                FtsWebVideoView.this.ar(i, false);
                FtsWebVideoView.this.ugQ.cHf();
                if (FtsWebVideoView.this.uhc != null) {
                    FtsWebVideoView.this.uhc.cWB();
                }
                AppMethodBeat.o(5841);
            }

            public final boolean cGl() {
                AppMethodBeat.i(5842);
                if (FtsWebVideoView.i(FtsWebVideoView.this)) {
                    AppMethodBeat.o(5842);
                    return false;
                }
                AppMethodBeat.o(5842);
                return true;
            }

            public final int getCurrentPosition() {
                AppMethodBeat.i(5843);
                int currPosSec = FtsWebVideoView.this.ugP.getCurrPosSec();
                AppMethodBeat.o(5843);
                return currPosSec;
            }

            public final void aq(float f) {
                AppMethodBeat.i(5844);
                ab.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(f)));
                FtsWebVideoView.this.ugT.setPercent(f);
                FtsWebVideoView.this.hYV.setText(R.string.c2z);
                FtsWebVideoView.this.hYW.setImageResource(R.raw.fts_web_video_volume_icon);
                FtsWebVideoView.this.hYT.setVisibility(0);
                AppMethodBeat.o(5844);
            }

            public final void ar(float f) {
                AppMethodBeat.i(5845);
                ab.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(f)));
                FtsWebVideoView.this.ugT.setPercent(f);
                FtsWebVideoView.this.hYV.setText(R.string.c2w);
                FtsWebVideoView.this.hYW.setImageResource(R.raw.fts_web_video_brightness_icon);
                FtsWebVideoView.this.hYT.setVisibility(0);
                AppMethodBeat.o(5845);
            }

            public final void aFl() {
                AppMethodBeat.i(5846);
                FtsWebVideoView.this.hYT.setVisibility(8);
                AppMethodBeat.o(5846);
            }

            public final void aFm() {
                AppMethodBeat.i(5847);
                FtsWebVideoView.this.hYT.setVisibility(8);
                AppMethodBeat.o(5847);
            }
        });
        AppMethodBeat.o(5893);
    }

    private void aFa() {
        AppMethodBeat.i(5894);
        this.ugP.setIMMVideoViewCallback(new com.tencent.mm.pluginsdk.ui.h.b() {
            public final void c(String str, String str2, String str3, int i, int i2) {
                AppMethodBeat.i(5848);
                ab.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i), Integer.valueOf(i2));
                com.tencent.mm.plugin.report.service.h.pYm.e(14911, Integer.valueOf(i), Integer.valueOf(i2), FtsWebVideoView.this.url, at.gB(FtsWebVideoView.this.getContext()));
                if (FtsWebVideoView.this.uhc != null) {
                    d h = FtsWebVideoView.this.uhc;
                    ab.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", Integer.valueOf(i), Integer.valueOf(i2));
                    h.clean();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errCode", i);
                        jSONObject.put("errMsg", String.valueOf(i2));
                        h.aM(h.a(7, jSONObject));
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
                    }
                }
                FtsWebVideoView.this.pause();
                FtsWebVideoView.a(FtsWebVideoView.this, FtsWebVideoView.this.getContext().getString(R.string.f13, new Object[]{i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2}), FtsWebVideoView.this.getContext().getString(R.string.f1r));
                AppMethodBeat.o(5848);
            }

            public final void cp(String str, String str2) {
                AppMethodBeat.i(5849);
                ab.i("MicroMsg.FtsWebVideoView", "onPrepared");
                a o = FtsWebVideoView.this.ugZ;
                o.iaB = -1;
                o.iaC = 0;
                o.iaA = 0.0f;
                FtsWebVideoView.this.ugQ.nG(FtsWebVideoView.this.isLoading);
                AppMethodBeat.o(5849);
            }

            public final void cq(String str, String str2) {
                AppMethodBeat.i(5850);
                ab.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
                if (FtsWebVideoView.this.uhc != null) {
                    d h = FtsWebVideoView.this.uhc;
                    ab.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", h.toString());
                    h.aFW();
                    try {
                        h.aM(h.a(3, null));
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
                    }
                }
                if (FtsWebVideoView.this.hZl) {
                    FtsWebVideoView.this.ar(0, true);
                    AppMethodBeat.o(5850);
                    return;
                }
                FtsWebVideoView.this.ar(0, false);
                FtsWebVideoView.this.pause();
                FtsWebVideoView.q(FtsWebVideoView.this);
                FtsWebVideoView.this.sDt.setImageResource(R.drawable.b6l);
                FtsWebVideoView.this.ugQ.setVisibility(8);
                AppMethodBeat.o(5850);
            }

            public final void d(String str, String str2, int i, int i2) {
                AppMethodBeat.i(5851);
                ab.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (FtsWebVideoView.this.ugO == b.AUTO) {
                    FtsWebVideoView.this.ugO = i < i2 ? b.PORTRAIT : b.LANDSCAPE;
                    ab.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", FtsWebVideoView.this.ugO);
                }
                AppMethodBeat.o(5851);
            }

            public final void cr(String str, String str2) {
                AppMethodBeat.i(5852);
                ab.i("MicroMsg.FtsWebVideoView", "onVideoPause");
                if (!(FtsWebVideoView.this.uhc == null || FtsWebVideoView.this.uhc == null)) {
                    d h = FtsWebVideoView.this.uhc;
                    ab.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", h.toString());
                    h.aFW();
                    try {
                        h.aM(h.a(2, null));
                        AppMethodBeat.o(5852);
                        return;
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
                    }
                }
                AppMethodBeat.o(5852);
            }

            public final void cs(String str, String str2) {
                AppMethodBeat.i(5853);
                ab.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", Boolean.valueOf(FtsWebVideoView.t(FtsWebVideoView.this)));
                if (FtsWebVideoView.this.uhc != null) {
                    d h = FtsWebVideoView.this.uhc;
                    ab.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", h.toString());
                    h.iat = 0;
                    if (h.ias == null) {
                        h.ias = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                            public final boolean BI() {
                                AppMethodBeat.i(5951);
                                try {
                                    int currPosMs = d.this.uhG.getCurrPosMs();
                                    if (Math.abs(currPosMs - d.this.iat) < 250) {
                                        AppMethodBeat.o(5951);
                                        return true;
                                    }
                                    d.this.iat = currPosMs;
                                    d dVar = d.this;
                                    d dVar2 = d.this;
                                    d dVar3 = d.this;
                                    JSONObject aFV = dVar3.aFV();
                                    aFV.put("currentTime", dVar3.uhG.getCurrPosSec());
                                    dVar.aM(dVar2.a(4, aFV));
                                    AppMethodBeat.o(5951);
                                    return true;
                                } catch (JSONException e) {
                                    ab.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", e);
                                }
                            }
                        }, true);
                    }
                    h.ias.ae(250, 250);
                    try {
                        h.aM(h.a(1, null));
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
                    }
                }
                if (FtsWebVideoView.this.uhg > 0 && FtsWebVideoView.this.uhg != Long.MAX_VALUE) {
                    long currentTimeMillis = System.currentTimeMillis() - FtsWebVideoView.this.uhg;
                    com.tencent.mm.plugin.report.service.h.pYm.e(14909, Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis()), Long.valueOf(currentTimeMillis), at.gB(FtsWebVideoView.this.getContext()), FtsWebVideoView.this.url);
                }
                AppMethodBeat.o(5853);
            }

            public final void ct(String str, String str2) {
                AppMethodBeat.i(5854);
                ab.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
                FtsWebVideoView.this.ugQ.cHe();
                FtsWebVideoView.this.isLoading = true;
                AppMethodBeat.o(5854);
            }

            public final void cu(String str, String str2) {
                AppMethodBeat.i(5855);
                ab.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
                FtsWebVideoView.this.isLoading = false;
                FtsWebVideoView.this.ugQ.cHf();
                FtsWebVideoView.this.ugQ.aFE();
                AppMethodBeat.o(5855);
            }
        });
        AppMethodBeat.o(5894);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(5895);
        if (this.hZg || aFb()) {
            if (this.ugZ != null) {
                a aVar = this.ugZ;
                if (aVar.ugH.cGl()) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 0) {
                        aVar.iaA = motionEvent.getRawX();
                        aVar.JB = ((AudioManager) aVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                        aVar.hXK = com.tencent.mm.plugin.webview.fts.c.c.cN(aVar.mContext);
                    }
                    aVar.iay.onTouchEvent(motionEvent);
                    if (actionMasked == 1 || actionMasked == 3) {
                        if (aVar.ugG == a.FastBackwardOrForward) {
                            aVar.ugH.j(aVar.iaC, motionEvent.getRawX() - aVar.iaA);
                            aVar.iaB = -1;
                            aVar.iaC = 0;
                            aVar.iaA = 0.0f;
                        } else if (aVar.ugG == a.Volume) {
                            ((AudioManager) aVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                            aVar.ugH.aFl();
                        } else if (aVar.ugG == a.Brightness) {
                            aVar.ugH.aFm();
                        }
                    }
                }
                aVar.ugG = a.None;
            }
            AppMethodBeat.o(5895);
            return true;
        }
        if (motionEvent.getAction() == 0 && cWw()) {
            this.ugQ.nG(this.isLoading);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(5895);
        return onTouchEvent;
    }

    public int getSystemVolume() {
        AppMethodBeat.i(5896);
        int streamVolume = ((AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
        AppMethodBeat.o(5896);
        return streamVolume;
    }

    private boolean cWw() {
        AppMethodBeat.i(5897);
        if (!this.hZe || cWx()) {
            AppMethodBeat.o(5897);
            return false;
        }
        AppMethodBeat.o(5897);
        return true;
    }

    private boolean cWx() {
        AppMethodBeat.i(5898);
        if (this.ugR.getVisibility() == 0) {
            AppMethodBeat.o(5898);
            return true;
        }
        AppMethodBeat.o(5898);
        return false;
    }

    public final void nH(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(5899);
        ab.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", Boolean.valueOf(z));
        if (this.uha == null) {
            ab.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
            AppMethodBeat.o(5899);
        } else if (z == aFb()) {
            ab.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
            AppMethodBeat.o(5899);
        } else if (z) {
            a aVar = this.uha;
            if (this.ugO != b.PORTRAIT) {
                z2 = true;
            }
            aVar.nI(z2);
            WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar = this.ugQ;
            webSearchWebVideoViewControlBar.hZM = true;
            webSearchWebVideoViewControlBar.aFJ();
            er(true);
            AppMethodBeat.o(5899);
        } else {
            this.uha.aDF();
            this.ugQ.aDF();
            AppMethodBeat.o(5899);
        }
    }

    public void setAllowMobileNetPlay(boolean z) {
        this.uhf = z;
    }

    public final boolean aFb() {
        AppMethodBeat.i(5900);
        if (this.uha == null) {
            ab.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
            AppMethodBeat.o(5900);
            return false;
        }
        boolean isFullScreen = this.uha.isFullScreen();
        AppMethodBeat.o(5900);
        return isFullScreen;
    }

    private void aZb() {
        AppMethodBeat.i(5901);
        this.ugQ = new WebSearchWebVideoViewControlBar(getContext());
        this.ugQ.setVisibility(8);
        this.ugQ.setEnterFullScreenBtnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(5856);
                FtsWebVideoView.this.nH(!FtsWebVideoView.this.aFb());
                AppMethodBeat.o(5856);
            }
        });
        this.ugQ.setExitFullScreenBtnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(5824);
                FtsWebVideoView.this.nH(!FtsWebVideoView.this.aFb());
                AppMethodBeat.o(5824);
            }
        });
        this.ugQ.setMuteBtnOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(5825);
                FtsWebVideoView.v(FtsWebVideoView.this);
                FtsWebVideoView.this.ugQ.aFE();
                AppMethodBeat.o(5825);
            }
        });
        this.ugQ.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void aFw() {
                AppMethodBeat.i(5826);
                ab.i("MicroMsg.FtsWebVideoView", "onSeekPre");
                FtsWebVideoView.this.ugQ.cHd();
                AppMethodBeat.o(5826);
            }

            public final void oA(int i) {
                AppMethodBeat.i(5827);
                ab.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", Integer.valueOf(i));
                FtsWebVideoView.this.ar(i, false);
                FtsWebVideoView.this.ugQ.aFE();
                if (FtsWebVideoView.this.uhc != null) {
                    FtsWebVideoView.this.uhc.cWB();
                }
                AppMethodBeat.o(5827);
            }
        });
        this.ugQ.setOnPlayButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(5828);
                if (FtsWebVideoView.this.ugP.isPlaying()) {
                    FtsWebVideoView.this.ugQ.cHd();
                    FtsWebVideoView.this.pause();
                    AppMethodBeat.o(5828);
                    return;
                }
                FtsWebVideoView.this.ugQ.aFE();
                FtsWebVideoView.this.cg(true);
                AppMethodBeat.o(5828);
            }
        });
        this.ugQ.setStatePorter(new com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.a() {
            public final int aFg() {
                AppMethodBeat.i(5829);
                int cacheTimeSec = FtsWebVideoView.this.ugP.getCacheTimeSec();
                AppMethodBeat.o(5829);
                return cacheTimeSec;
            }

            public final int aFh() {
                AppMethodBeat.i(5830);
                int videoDurationSec = FtsWebVideoView.this.ugP.getVideoDurationSec();
                AppMethodBeat.o(5830);
                return videoDurationSec;
            }

            public final int cVN() {
                AppMethodBeat.i(5831);
                int currPosMs = FtsWebVideoView.this.ugP.getCurrPosMs();
                AppMethodBeat.o(5831);
                return currPosMs;
            }
        });
        this.ugP.setVideoFooterView(this.ugQ);
        AppMethodBeat.o(5901);
    }

    public final void er(boolean z) {
        AppMethodBeat.i(5902);
        if (this.uhc == null) {
            AppMethodBeat.o(5902);
            return;
        }
        this.uhc.b(this.hZc, z, this.ugO == b.PORTRAIT ? "vertical" : MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL);
        cWu();
        AppMethodBeat.o(5902);
    }

    private boolean isLive() {
        AppMethodBeat.i(5903);
        ab.i("MicroMsg.FtsWebVideoView", "isLive %b %b", Boolean.valueOf(this.hZk), Boolean.valueOf(this.ugP.isLive()));
        if (this.hZk || this.ugP.isLive()) {
            AppMethodBeat.o(5903);
            return true;
        }
        AppMethodBeat.o(5903);
        return false;
    }

    public com.tencent.mm.plugin.webview.fts.c.b.a getUiLifecycleListener() {
        return this.uhd;
    }

    public void setUiLifecycleListener(com.tencent.mm.plugin.webview.fts.c.b.a aVar) {
        this.uhd = aVar;
    }

    public int getVideoSizeByte() {
        return this.uhe;
    }

    public void setVideoSizeByte(int i) {
        this.uhe = i;
    }

    static /* synthetic */ void q(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.i(5909);
        ftsWebVideoView.ugR.setVisibility(0);
        ftsWebVideoView.ugS.setVisibility(8);
        ftsWebVideoView.ugU.setVisibility(0);
        ftsWebVideoView.cWu();
        AppMethodBeat.o(5909);
    }

    static /* synthetic */ void v(FtsWebVideoView ftsWebVideoView) {
        AppMethodBeat.i(5911);
        ftsWebVideoView.eif = !ftsWebVideoView.eif;
        ftsWebVideoView.ugP.setMute(ftsWebVideoView.eif);
        if (ftsWebVideoView.eif) {
            ftsWebVideoView.ugQ.NO();
            AppMethodBeat.o(5911);
            return;
        }
        ftsWebVideoView.ugQ.cVM();
        AppMethodBeat.o(5911);
    }
}
