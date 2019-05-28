package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.support.p057v4.content.C37116d;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C45344ma;
import com.tencent.p177mm.plugin.sight.decode.p512ui.C3855b;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C3947z;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.C29078a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerSeekBar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z */
public final class C13459z extends C31415y implements C3855b, C23324b {
    private Context context;
    private C7306ak fbD;
    private ProgressBar gtI;
    private View iVh;
    ImageView mOX;
    private long oKj = 0;
    private int playCount = 0;
    AdLandingVideoWrapper raL;
    private VideoPlayerSeekBar raM;
    private ImageView raN;
    boolean raO;
    private ImageView raP;
    private TextView raQ;
    private Runnable raR;
    boolean raS = false;
    boolean raT = false;
    boolean raU = false;
    boolean raV = true;
    boolean raW = true;
    private boolean raX = false;
    private boolean raY = true;
    private boolean raZ = false;
    private boolean rba = false;
    private boolean rbb = false;
    private boolean rbc = false;
    int rbd = 0;
    private int rbe = 0;
    private int rbf = 0;
    int rbg = 0;
    int rbh = 0;
    private C21945ac rbi = null;
    private OnClickListener rbj = new C134627();
    private OnClickListener rbk = new C134688();
    private OnClickListener rbl = new C134639();
    private OnClickListener rbm = new C1346510();

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$2 */
    class C134562 implements Runnable {
        C134562() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37303);
            C13459z.this.raL.pause();
            AppMethodBeat.m2505o(37303);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$5 */
    class C134585 implements C3951a {
        C134585() {
        }

        public final void cpu() {
        }

        public final void cmD() {
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37306);
            if (C13459z.this.mOX.getVisibility() == 0) {
                C13459z.this.mOX.setImageBitmap(MMBitmapFactory.decodeFile(str));
            }
            AppMethodBeat.m2505o(37306);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$1 */
    class C134601 implements Runnable {
        C134601() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37302);
            C13459z.this.mo25618la(false);
            AppMethodBeat.m2505o(37302);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$3 */
    class C134613 implements Runnable {
        C134613() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37304);
            if (C13459z.this.raU) {
                AppMethodBeat.m2505o(37304);
                return;
            }
            C13459z.this.mo25618la(false);
            AppMethodBeat.m2505o(37304);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$7 */
    class C134627 implements OnClickListener {
        C134627() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37308);
            C4990ab.m7417i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", Boolean.valueOf(C13459z.this.raL.isPlaying()));
            if (C13459z.this.raL.isPlaying()) {
                C13459z.this.cpN();
                C13459z.this.rbd = 4;
            } else {
                if (C13459z.this.raV) {
                    C13459z.this.coY();
                } else {
                    C13459z.this.cpe();
                    C13459z.this.cpd();
                }
                C13459z.m21605b(C13459z.this);
                C13459z.this.rbd = 3;
            }
            if (C13459z.this.qVK) {
                C13459z c13459z = C13459z.this;
                c13459z.rbg++;
            }
            AppMethodBeat.m2505o(37308);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$9 */
    class C134639 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$9$1 */
        class C134641 implements Runnable {
            C134641() {
            }

            public final void run() {
                AppMethodBeat.m2504i(37310);
                if (C13459z.this.raU) {
                    AppMethodBeat.m2505o(37310);
                    return;
                }
                C13459z.this.mo25618la(false);
                AppMethodBeat.m2505o(37310);
            }
        }

        C134639() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37311);
            C13459z.m21605b(C13459z.this);
            C13459z.this.raW = false;
            C13459z.this.raT = true;
            C13459z.this.rbd = 3;
            C13459z.this.cpd();
            C13459z.this.mo25618la(true);
            C5004al.m7442n(new C134641(), 10000);
            AppMethodBeat.m2505o(37311);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$10 */
    class C1346510 implements OnClickListener {
        C1346510() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37312);
            if (!C13459z.this.raU) {
                C13459z.this.raU = true;
                C13459z.this.mo25618la(true);
            }
            AppMethodBeat.m2505o(37312);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$11 */
    class C1346611 implements Runnable {
        C1346611() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37313);
            if (!C13459z.this.raL.isPlaying()) {
                if (C13459z.this.raL.getCurrPosSec() == C13459z.this.raL.getVideoDurationSec()) {
                    C13459z.this.mo25616Dp(0);
                } else {
                    C13459z.this.mo25616Dp(C13459z.this.raL.getCurrPosSec());
                }
                C13459z.this.raL.cpT();
            }
            AppMethodBeat.m2505o(37313);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$6 */
    class C134676 implements C29078a {
        C134676() {
        }

        /* renamed from: Dq */
        public final void mo15472Dq(int i) {
            AppMethodBeat.m2504i(37307);
            if (!(((C3947z) C13459z.this.qZo).qWM == null || i * 1000 < ((C3947z) C13459z.this.qZo).qWM.qXt || C13459z.this.raO)) {
                C13459z.this.raO = true;
                C45344ma c45344ma = new C45344ma();
                c45344ma.cHQ.cHR = ((C3947z) C13459z.this.qZo).qWM.cHR;
                C4879a.xxA.mo10055m(c45344ma);
            }
            AppMethodBeat.m2505o(37307);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z$8 */
    class C134688 implements OnClickListener {
        C134688() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37309);
            C13459z c13459z = C13459z.this;
            c13459z.rbh++;
            if (C13459z.this.raV) {
                C13459z.this.cpe();
                C13459z.this.cpd();
            } else {
                C13459z.this.coY();
            }
            C13459z.this.raS = true;
            AppMethodBeat.m2505o(37309);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m21605b(C13459z c13459z) {
        AppMethodBeat.m2504i(37332);
        c13459z.bgC();
        AppMethodBeat.m2505o(37332);
    }

    public C13459z(final Context context, C3947z c3947z, ViewGroup viewGroup) {
        super(context, c3947z, viewGroup);
        AppMethodBeat.m2504i(37314);
        this.context = context;
        this.fbD = new C7306ak(Looper.getMainLooper());
        this.raR = new C134601();
        this.rbi = new C21945ac() {
            /* renamed from: lb */
            public final void mo15469lb(boolean z) {
                AppMethodBeat.m2504i(37305);
                Intent intent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
                intent.putExtra("show", z ? 1 : 0);
                C37116d.m62125S(context).mo59172c(intent);
                AppMethodBeat.m2505o(37305);
            }
        };
        AppMethodBeat.m2505o(37314);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970726;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cpk() {
        String gj;
        LayoutParams layoutParams;
        AppMethodBeat.m2504i(37315);
        View findViewById = this.contentView.findViewById(2131821333);
        findViewById.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        int i = this.ieu;
        int i2 = this.iev;
        if (((C3947z) this.qZo).qXw == 1) {
            if (((int) ((C3947z) this.qZo).width) > 0) {
                i2 = (i * ((int) ((C3947z) this.qZo).height)) / ((int) ((C3947z) this.qZo).width);
            }
            findViewById.setLayoutParams(new LayoutParams(i, i2));
            findViewById.setMinimumHeight(i2);
            this.raL = (AdLandingVideoWrapper) findViewById.findViewById(2131821402);
            this.raL.setIMMVideoViewCallback(this);
            this.raL.setOnClickListener(this.rbm);
            this.raL.mo9063c(false, ((C3947z) this.qZo).qWH, 0);
            this.raL.setIsShowBasicControls(true);
            this.gtI = (ProgressBar) findViewById.findViewById(2131821219);
            this.mOX = (ImageView) findViewById.findViewById(2131821511);
            gj = C13473h.m21625gj("adId", ((C3947z) this.qZo).qXv);
            if (!C5730e.m8628ct(gj)) {
                this.rbb = false;
            }
            if (this.rbb) {
                C13473h.m21623c("adId", ((C3947z) this.qZo).qXv, false, 1000000001, new C134585());
            } else {
                this.mOX.setImageBitmap(MMBitmapFactory.decodeFile(gj));
            }
            this.raQ = (TextView) findViewById.findViewById(2131827572);
            this.raQ.setText(this.context.getString(C25738R.string.b6p));
            this.iVh = findViewById.findViewById(2131827636);
            this.iVh.setVisibility(4);
            this.raM = new VideoPlayerSeekBar(this.context);
            this.raM.setVisibility(4);
            if (this.rbi != null) {
                this.rbi.mo15469lb(this.raM.getVisibility() == 0);
            }
            this.raM.setIplaySeekCallback(this);
            this.raM.setOnPlayButtonClickListener(this.rbj);
            layoutParams = new LayoutParams(i - C1338a.fromDPToPix(this.context, 30), -2);
            layoutParams.addRule(12);
            this.raM.setLayoutParams(layoutParams);
            this.raL.setVideoFooterView(this.raM);
            this.raN = (ImageView) findViewById.findViewById(2131827637);
            this.raN.setVisibility(4);
            this.raN.setOnClickListener(this.rbk);
            this.raN.setPadding(0, 0, C1338a.fromDPToPix(this.context, 8), 0);
            this.raP = (ImageView) findViewById.findViewById(2131820981);
            this.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
            this.raP.setVisibility(8);
            this.raP.setOnClickListener(this.rbl);
            ((ViewGroup) this.raM.getParent()).removeView(this.raM);
            layoutParams.bottomMargin = 0;
            ((ViewGroup) findViewById).addView(this.raM, layoutParams);
            this.raL.setVideoPlayCallback(new C134676());
            AppMethodBeat.m2505o(37315);
        }
        findViewById.setPadding((int) ((C3947z) this.qZo).qWS, (int) ((C3947z) this.qZo).qWQ, (int) ((C3947z) this.qZo).qWT, (int) ((C3947z) this.qZo).qWR);
        findViewById.setLayoutParams(new LayoutParams(i, i2));
        findViewById.setMinimumHeight(i2);
        this.raL = (AdLandingVideoWrapper) findViewById.findViewById(2131821402);
        this.raL.setIMMVideoViewCallback(this);
        this.raL.setOnClickListener(this.rbm);
        this.raL.mo9063c(false, ((C3947z) this.qZo).qWH, 0);
        this.raL.setIsShowBasicControls(true);
        this.gtI = (ProgressBar) findViewById.findViewById(2131821219);
        this.mOX = (ImageView) findViewById.findViewById(2131821511);
        gj = C13473h.m21625gj("adId", ((C3947z) this.qZo).qXv);
        if (C5730e.m8628ct(gj)) {
        }
        if (this.rbb) {
        }
        this.raQ = (TextView) findViewById.findViewById(2131827572);
        this.raQ.setText(this.context.getString(C25738R.string.b6p));
        this.iVh = findViewById.findViewById(2131827636);
        this.iVh.setVisibility(4);
        this.raM = new VideoPlayerSeekBar(this.context);
        this.raM.setVisibility(4);
        if (this.rbi != null) {
        }
        this.raM.setIplaySeekCallback(this);
        this.raM.setOnPlayButtonClickListener(this.rbj);
        layoutParams = new LayoutParams(i - C1338a.fromDPToPix(this.context, 30), -2);
        layoutParams.addRule(12);
        this.raM.setLayoutParams(layoutParams);
        this.raL.setVideoFooterView(this.raM);
        this.raN = (ImageView) findViewById.findViewById(2131827637);
        this.raN.setVisibility(4);
        this.raN.setOnClickListener(this.rbk);
        this.raN.setPadding(0, 0, C1338a.fromDPToPix(this.context, 8), 0);
        this.raP = (ImageView) findViewById.findViewById(2131820981);
        this.raP.setImageDrawable(C1338a.m2864g(this.context, C1318a.shortvideo_play_btn));
        this.raP.setVisibility(8);
        this.raP.setOnClickListener(this.rbl);
        ((ViewGroup) this.raM.getParent()).removeView(this.raM);
        layoutParams.bottomMargin = 0;
        ((ViewGroup) findViewById).addView(this.raM, layoutParams);
        this.raL.setVideoPlayCallback(new C134676());
        AppMethodBeat.m2505o(37315);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
    }

    private void bgC() {
        AppMethodBeat.m2504i(37316);
        C4990ab.m7410d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play");
        if (this.rba) {
            C4990ab.m7416i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
            this.raL.mo9063c(false, ((C3947z) this.qZo).qWH, 0);
            mo25616Dp(0);
            this.raL.cpT();
            AppMethodBeat.m2505o(37316);
            return;
        }
        this.fbD.post(new C1346611());
        this.oKj = System.currentTimeMillis();
        this.playCount++;
        AppMethodBeat.m2505o(37316);
    }

    /* Access modifiers changed, original: final */
    public final void cpN() {
        AppMethodBeat.m2504i(37317);
        C4990ab.m7410d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
        this.fbD.post(new C134562());
        if (this.oKj != 0) {
            this.rbe = (int) (((long) this.rbe) + (System.currentTimeMillis() - this.oKj));
            this.oKj = 0;
        }
        AppMethodBeat.m2505o(37317);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: la */
    public final void mo25618la(boolean z) {
        AppMethodBeat.m2504i(37318);
        if (z) {
            this.raM.setVisibility(0);
            this.raN.setVisibility(0);
            this.iVh.setVisibility(0);
            if (this.rbi != null) {
                this.rbi.mo15469lb(true);
            }
            this.fbD.postDelayed(this.raR, 5000);
            AppMethodBeat.m2505o(37318);
            return;
        }
        this.raU = false;
        this.raM.setVisibility(4);
        this.raN.setVisibility(8);
        this.iVh.setVisibility(4);
        if (this.rbi != null) {
            this.rbi.mo15469lb(false);
        }
        this.fbD.removeCallbacks(this.raR);
        AppMethodBeat.m2505o(37318);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Dp */
    public final void mo25616Dp(int i) {
        AppMethodBeat.m2504i(37319);
        if (this.raL != null) {
            this.raP.setVisibility(8);
            if (this.mOX.getVisibility() == 0) {
                this.gtI.setVisibility(0);
            }
            this.raL.mo26912e((double) i, true);
        }
        AppMethodBeat.m2505o(37319);
    }

    public final void coY() {
        AppMethodBeat.m2504i(37320);
        super.coY();
        this.raN.setImageDrawable(C1338a.m2864g(this.context, C25738R.drawable.b7m));
        this.raL.setMute(true);
        this.raV = true;
        AppMethodBeat.m2505o(37320);
    }

    public final void cpd() {
        AppMethodBeat.m2504i(37321);
        super.cpd();
        this.raN.setImageDrawable(C1338a.m2864g(this.context, C25738R.drawable.b7n));
        this.raL.setMute(false);
        this.raV = false;
        AppMethodBeat.m2505o(37321);
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37322);
        super.cpa();
        AppMethodBeat.m2505o(37322);
    }

    public final void cpb() {
        AppMethodBeat.m2504i(37323);
        super.cpb();
        cpN();
        if (this.raX || this.raY) {
            this.raY = false;
            this.raX = false;
            if (this.rbd == 1) {
                this.rbd = 2;
            }
            AppMethodBeat.m2505o(37323);
            return;
        }
        AppMethodBeat.m2505o(37323);
    }

    public final void coZ() {
        AppMethodBeat.m2504i(37324);
        super.coZ();
        this.raL.aEX();
        AppMethodBeat.m2505o(37324);
    }

    public final void cpc() {
        AppMethodBeat.m2504i(37325);
        super.cpc();
        int cpw = cpw();
        int height = getView().getHeight();
        C4990ab.m7411d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", Integer.valueOf(cpw), Integer.valueOf(height));
        if (cpw == 0 || height == 0) {
            AppMethodBeat.m2505o(37325);
        } else if (cpw < 0) {
            AppMethodBeat.m2505o(37325);
        } else if (((float) cpw) < ((float) height) * 0.5f) {
            this.raY = false;
            this.raX = false;
            cpN();
            if (this.rbd == 1) {
                this.rbd = 2;
            }
            AppMethodBeat.m2505o(37325);
        } else if (!this.raX || this.raY) {
            this.raY = false;
            this.raX = true;
            this.mOX.setVisibility(0);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!this.raW || (this.raW && activeNetworkInfo != null && activeNetworkInfo.getType() == 1)) {
                mo25618la(true);
                C5004al.m7442n(new C134613(), 3000);
            }
            if (this.raW) {
                if (activeNetworkInfo == null || !(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                    this.raP.setVisibility(0);
                    this.raZ = false;
                    this.raW = false;
                    AppMethodBeat.m2505o(37325);
                    return;
                }
                this.raZ = true;
                this.raW = false;
            }
            if (this.rbd == 0) {
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                    if (this.raV) {
                        coY();
                    } else {
                        cpd();
                    }
                    this.rbd = 1;
                }
                AppMethodBeat.m2505o(37325);
            } else if (this.rbd == 2) {
                if (this.raV) {
                    coY();
                } else {
                    cpd();
                }
                bgC();
                this.rbd = 1;
                AppMethodBeat.m2505o(37325);
                return;
            } else {
                if (this.rbd == 3) {
                    if (this.raV) {
                        coY();
                    } else {
                        cpd();
                    }
                }
                AppMethodBeat.m2505o(37325);
            }
            bgC();
            AppMethodBeat.m2505o(37325);
        } else {
            AppMethodBeat.m2505o(37325);
        }
    }

    /* renamed from: al */
    public final boolean mo15456al(JSONObject jSONObject) {
        AppMethodBeat.m2504i(37326);
        if (super.mo15456al(jSONObject)) {
            try {
                String ck;
                JSONObject jSONObject2;
                jSONObject.put("streamVideoDuraion", this.raL.getVideoDurationSec() * 1000);
                jSONObject.put("playTimeInterval", this.rbe);
                jSONObject.put("playCount", this.playCount);
                jSONObject.put("playCompletedCount", this.rbf);
                jSONObject.put("clickPlayControlCount", this.rbg);
                jSONObject.put("clickVoiceControlCount", this.rbh);
                jSONObject.put("isAutoPlay", this.raZ ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                if (!this.rbb) {
                    ck = C4995ag.m7428ck(((C3947z) this.qZo).qXv);
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("thumbUrlInfo", jSONObject2);
                }
                if (!this.rbc) {
                    ck = C4995ag.m7428ck(((C3947z) this.qZo).qWH);
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("streamVideoUrlInfo", jSONObject2);
                }
                AppMethodBeat.m2505o(37326);
                return true;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", e, "", new Object[0]);
                AppMethodBeat.m2505o(37326);
                return false;
            }
        }
        AppMethodBeat.m2505o(37326);
        return false;
    }

    public final void aFw() {
        this.raU = true;
    }

    /* renamed from: oA */
    public final void mo8552oA(int i) {
        AppMethodBeat.m2504i(37327);
        C4990ab.m7416i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(i)));
        if (this.raV) {
            coY();
        } else {
            cpe();
            cpd();
        }
        mo25616Dp(i);
        AppMethodBeat.m2505o(37327);
    }

    /* renamed from: cp */
    public final void mo9210cp(String str, String str2) {
        this.rba = false;
    }

    /* renamed from: cq */
    public final void mo9211cq(String str, String str2) {
        AppMethodBeat.m2504i(37328);
        this.rbf++;
        mo25618la(true);
        this.raL.rcg.stopTimer();
        if (this.oKj != 0) {
            this.rbe = (int) (((long) this.rbe) + (System.currentTimeMillis() - this.oKj));
            this.oKj = 0;
        }
        this.rbd = 5;
        this.raL.akV();
        AppMethodBeat.m2505o(37328);
    }

    /* renamed from: cr */
    public final void mo9212cr(String str, String str2) {
    }

    /* renamed from: cs */
    public final void mo9213cs(String str, String str2) {
        AppMethodBeat.m2504i(37329);
        this.mOX.setVisibility(8);
        this.gtI.setVisibility(8);
        AppMethodBeat.m2505o(37329);
    }

    /* renamed from: d */
    public final void mo9216d(String str, String str2, int i, int i2) {
    }

    /* renamed from: c */
    public final void mo9209c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(37330);
        C4990ab.m7413e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "online play error, %s", str3);
        this.rba = true;
        AppMethodBeat.m2505o(37330);
    }

    /* renamed from: ct */
    public final void mo9214ct(String str, String str2) {
    }

    /* renamed from: cu */
    public final void mo9215cu(String str, String str2) {
    }

    public final void cpA() {
        AppMethodBeat.m2504i(37331);
        super.cpA();
        cpN();
        String gj = C13473h.m21625gj("adId", ((C3947z) this.qZo).qXv);
        if (C5730e.m8628ct(gj)) {
            this.mOX.setImageBitmap(MMBitmapFactory.decodeFile(gj));
            this.mOX.setVisibility(0);
        }
        AppMethodBeat.m2505o(37331);
    }
}
