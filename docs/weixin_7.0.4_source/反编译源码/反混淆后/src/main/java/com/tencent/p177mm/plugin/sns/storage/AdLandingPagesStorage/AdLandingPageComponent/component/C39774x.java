package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C45344ma;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.p520ui.OfflineVideoView;
import com.tencent.p177mm.plugin.sns.p520ui.OfflineVideoView.C41311a;
import com.tencent.p177mm.plugin.sns.p520ui.VideoAdPlayerUI;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29060a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46233o;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x */
public final class C39774x extends C29060a {
    public static int rbL = 999;
    private Context context;
    private boolean eCM;
    private C7306ak fbD;
    private String hGF;
    private View iVh;
    int iZo = 0;
    private long oKj = 0;
    private int playCount = 0;
    public int qEo = 0;
    public int qEp = 0;
    public int qEq = 0;
    ImageView raN;
    private boolean raO;
    private TextView raQ;
    boolean raV = true;
    private boolean raX = false;
    private boolean raY = true;
    private boolean raZ = false;
    private OfflineVideoView rbF;
    private int rbG;
    private int rbH = 0;
    int rbI = 0;
    int rbJ = 0;
    private boolean rbK;
    private boolean rba = false;
    boolean rbb = true;
    boolean rbc = true;
    private int rbd = 0;
    private int rbe = 0;
    private int rbf = 0;
    int rbh = 0;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x$5 */
    class C219645 implements OnClickListener {
        C219645() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37282);
            C39774x.this.cpQ();
            AppMethodBeat.m2505o(37282);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x$6 */
    class C219656 implements Runnable {
        C219656() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37283);
            OfflineVideoView a = C39774x.this.rbF;
            C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", Integer.valueOf(a.hashCode()), Boolean.valueOf(a.rkY), Integer.valueOf(a.klq.getCurrentPosition()), Integer.valueOf(a.klq.getDuration()), Integer.valueOf(a.rla));
            a.rkZ = true;
            if (!a.rkY) {
                a.onResume();
            } else if (C5046bo.isNullOrNil(a.klq.getVideoPath())) {
                a.onResume();
            } else if (a.klq.getCurrentPosition() >= a.klq.getDuration()) {
                a.klq.mo27356d(0.0d, true);
                if (a.rkX != null) {
                    a.rkX.onStart(a.duration);
                }
            } else {
                a.klq.start();
            }
            a.startTimer();
            AppMethodBeat.m2505o(37283);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x$7 */
    class C219667 implements Runnable {
        C219667() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37284);
            OfflineVideoView a = C39774x.this.rbF;
            C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d pause", Integer.valueOf(a.hashCode()));
            C4990ab.m7411d("MicroMsg.OfflineVideoView", "%d on pause %s ", Integer.valueOf(a.hashCode()), C5046bo.dpG());
            a.rkZ = false;
            if (a.klq.isPlaying()) {
                a.rla = a.klq.getCurrentPosition();
                C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d pause play", Integer.valueOf(a.hashCode()));
                a.klq.pause();
            }
            a.bJc();
            a.klw.stopTimer();
            AppMethodBeat.m2505o(37284);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x$2 */
    class C397752 implements OnClickListener {
        C397752() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37273);
            C39774x c39774x = C39774x.this;
            c39774x.rbh++;
            if (C39774x.this.raV) {
                C39774x.this.cpe();
                C39774x.this.cpd();
                AppMethodBeat.m2505o(37273);
                return;
            }
            C39774x.this.coY();
            AppMethodBeat.m2505o(37273);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x$3 */
    class C397763 implements C41311a {

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x$3$1 */
        class C397721 implements C3951a {
            C397721() {
            }

            public final void cpu() {
            }

            public final void cmD() {
                AppMethodBeat.m2504i(37274);
                C4990ab.m7412e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video download fail");
                C39774x.this.rba = true;
                AppMethodBeat.m2505o(37274);
            }

            /* renamed from: YJ */
            public final void mo8627YJ(String str) {
                AppMethodBeat.m2504i(37275);
                C4990ab.m7418v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video view height " + C39774x.this.contentView.getHeight() + ", player height " + C39774x.this.rbF.getHeight());
                C39774x.this.rba = false;
                C39774x.this.hGF = str;
                C39774x.this.rbF.mo65975Mj(str);
                C39774x.this.rbK = true;
                AppMethodBeat.m2505o(37275);
            }
        }

        C397763() {
        }

        /* renamed from: a */
        public final boolean mo62898a(PString pString) {
            AppMethodBeat.m2504i(37277);
            String str = "adId";
            String str2 = ((C46233o) C39774x.this.qZo).qWF;
            String gk = C13473h.m21626gk(str, str2);
            if (C5730e.m8628ct(gk)) {
                pString.value = gk;
                C39774x.this.rbK = true;
                AppMethodBeat.m2505o(37277);
                return true;
            }
            C13473h.m21624d(str, str2, false, 62, new C397721());
            AppMethodBeat.m2505o(37277);
            return false;
        }

        /* renamed from: EA */
        public final void mo62897EA() {
            AppMethodBeat.m2504i(37278);
            C39774x.this.rbf = C39774x.this.rbf + 1;
            C39774x.m68049e(C39774x.this);
            AppMethodBeat.m2505o(37278);
        }

        public final void onStart(int i) {
            AppMethodBeat.m2504i(37279);
            C39774x.this.eCM = true;
            C39774x.this.rbG = i;
            C39774x.this.raN.setVisibility(0);
            AppMethodBeat.m2505o(37279);
        }

        /* renamed from: Dq */
        public final void mo62896Dq(final int i) {
            AppMethodBeat.m2504i(37280);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(37276);
                    C4990ab.m7410d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + i + " video time " + C39774x.this.rbG);
                    if (!(((C46233o) C39774x.this.qZo).qWM == null || i * 1000 < ((C46233o) C39774x.this.qZo).qWM.qXt || C39774x.this.raO)) {
                        C39774x.this.raO = true;
                        C45344ma c45344ma = new C45344ma();
                        c45344ma.cHQ.cHR = ((C46233o) C39774x.this.qZo).qWM.cHR;
                        C4879a.xxA.mo10055m(c45344ma);
                    }
                    AppMethodBeat.m2505o(37276);
                }
            });
            AppMethodBeat.m2505o(37280);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x$4 */
    class C397774 implements OnClickListener {
        C397774() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37281);
            if (C39774x.this.eCM) {
                C39774x c39774x = C39774x.this;
                c39774x.rbI++;
                if (C39774x.m68055k(C39774x.this)) {
                    AppMethodBeat.m2505o(37281);
                    return;
                }
            }
            AppMethodBeat.m2505o(37281);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x$1 */
    class C397781 implements C3951a {
        C397781() {
        }

        public final void cpu() {
        }

        public final void cmD() {
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37272);
            C39774x.this.rbF.mo65976Zz(str);
            AppMethodBeat.m2505o(37272);
        }
    }

    /* renamed from: k */
    static /* synthetic */ boolean m68055k(C39774x c39774x) {
        AppMethodBeat.m2504i(37301);
        boolean cpR = c39774x.cpR();
        AppMethodBeat.m2505o(37301);
        return cpR;
    }

    public C39774x(Context context, C46233o c46233o, ViewGroup viewGroup) {
        super(context, c46233o, viewGroup);
        AppMethodBeat.m2504i(37285);
        this.context = context;
        this.fbD = new C7306ak(Looper.getMainLooper());
        AppMethodBeat.m2505o(37285);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970729;
    }

    public final void cpk() {
        ViewParent parent;
        boolean z;
        AppMethodBeat.m2504i(37286);
        if (!C5730e.m8628ct(C13473h.m21625gj("adId", ((C46233o) this.qZo).qWG))) {
            this.rbb = false;
        }
        if (!C5730e.m8628ct(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + C4995ag.m7428ck(((C46233o) this.qZo).qWF))) {
            this.rbc = false;
        }
        View findViewById = this.contentView.findViewById(2131827641);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(2131827642);
        this.rbF = new OfflineVideoView(this.context);
        viewGroup.addView(this.rbF, new LayoutParams(-1, -1));
        int i;
        RelativeLayout.LayoutParams layoutParams;
        if (((C46233o) this.qZo).qWL == 0) {
            if (((int) ((C46233o) this.qZo).width) > 0) {
                i = this.ieu;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, (int) ((((float) i) * ((C46233o) this.qZo).height) / ((C46233o) this.qZo).width));
                viewGroup.setLayoutParams(layoutParams2);
                findViewById.setLayoutParams(layoutParams2);
            } else {
                viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(this.ieu, this.iev));
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.ieu, this.iev));
            }
        } else if (((C46233o) this.qZo).qWL == 1) {
            int i2;
            int i3;
            if (((C46233o) this.qZo).width / ((float) this.ieu) > ((C46233o) this.qZo).height / ((float) this.iev)) {
                i = this.ieu;
                i2 = ((int) ((((float) i) * ((C46233o) this.qZo).height) / ((C46233o) this.qZo).width)) + 1;
                i3 = i;
            } else {
                i = this.iev;
                i3 = ((int) ((((float) i) * ((C46233o) this.qZo).width) / ((C46233o) this.qZo).height)) + 1;
                i2 = i;
            }
            layoutParams = new RelativeLayout.LayoutParams(i3, i2);
            layoutParams.leftMargin = (this.ieu - i3) / 2;
            layoutParams.rightMargin = layoutParams.leftMargin;
            layoutParams.topMargin = (this.iev - i2) / 2;
            layoutParams.bottomMargin = layoutParams.topMargin;
            viewGroup.setLayoutParams(layoutParams);
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.ieu, this.iev));
        } else if (((C46233o) this.qZo).qWL == 2) {
            layoutParams = new RelativeLayout.LayoutParams((int) ((C46233o) this.qZo).width, (int) ((C46233o) this.qZo).height);
            viewGroup.setLayoutParams(layoutParams);
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams));
        }
        String gj = C13473h.m21625gj("adId", ((C46233o) this.qZo).qWG);
        if (C5730e.m8628ct(gj)) {
            this.rbF.mo65976Zz(gj);
        } else {
            C13473h.m21623c("adId", ((C46233o) this.qZo).qWG, false, 1000000001, new C397781());
        }
        this.raQ = (TextView) findViewById.findViewById(2131827572);
        this.raQ.setText(this.context.getString(C25738R.string.b6p));
        this.iVh = findViewById.findViewById(2131827636);
        if (this.iVh != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            parent = this.iVh.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.iVh);
            }
            ((ViewGroup) findViewById).addView(this.iVh, layoutParams3);
        }
        this.raN = (ImageView) findViewById.findViewById(2131827637);
        this.raN.setVisibility(0);
        this.raN.setOnClickListener(new C397752());
        this.raN.setPadding(0, 0, C1338a.fromDPToPix(this.context, 8), C1338a.fromDPToPix(this.context, 13));
        parent = this.raN.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.raN);
        }
        ((ViewGroup) findViewById).addView(this.raN);
        this.rbF.setVideoCallback(new C397763());
        this.raN.setVisibility(8);
        this.rbF.setOnClickListener(new C397774());
        C46233o c46233o = (C46233o) this.qZo;
        if (c46233o.cuu != 1 || c46233o.qWI.length() <= 0 || c46233o.qWH.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            findViewById = this.contentView.findViewById(2131827643);
            findViewById.setVisibility(0);
            Button button = (Button) findViewById.findViewById(2131827644);
            button.setTextColor(((C46233o) this.qZo).qWJ);
            button.setText(((C46233o) this.qZo).qWI);
            button.setOnClickListener(new C219645());
            findViewById.findViewById(2131827645).setBackgroundColor(((C46233o) this.qZo).qWK);
        }
        AppMethodBeat.m2505o(37286);
    }

    private void bgC() {
        AppMethodBeat.m2504i(37289);
        if (this.rba) {
            C4990ab.m7416i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
            this.rbF.bwD();
            AppMethodBeat.m2505o(37289);
            return;
        }
        C4990ab.m7410d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
        if (!(this.rbK || TextUtils.isEmpty(this.hGF))) {
            this.rbF.mo65975Mj(this.hGF);
            this.rbK = true;
        }
        this.fbD.post(new C219656());
        this.oKj = System.currentTimeMillis();
        this.playCount++;
        AppMethodBeat.m2505o(37289);
    }

    private void cpN() {
        AppMethodBeat.m2504i(37290);
        C4990ab.m7410d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
        this.fbD.post(new C219667());
        if (this.oKj != 0) {
            this.rbe = (int) (((long) this.rbe) + (System.currentTimeMillis() - this.oKj));
            this.oKj = 0;
        }
        AppMethodBeat.m2505o(37290);
    }

    public final void coY() {
        AppMethodBeat.m2504i(37291);
        super.coY();
        this.raN.setImageDrawable(C1338a.m2864g(this.context, C1318a.icon_volume_off));
        this.rbF.setMute(true);
        this.raV = true;
        AppMethodBeat.m2505o(37291);
    }

    public final void cpd() {
        AppMethodBeat.m2504i(37292);
        super.cpd();
        this.raN.setImageDrawable(C1338a.m2864g(this.context, C1318a.icon_volume_on));
        this.rbF.setMute(false);
        this.raV = false;
        AppMethodBeat.m2505o(37292);
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37293);
        super.cpa();
        AppMethodBeat.m2505o(37293);
    }

    public final void cpb() {
        AppMethodBeat.m2504i(37294);
        super.cpb();
        cpN();
        if (this.raX || this.raY) {
            this.raY = false;
            this.raX = false;
            if (this.rbd == 1) {
                this.rbd = 2;
            }
            C4990ab.m7411d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", Integer.valueOf(this.rbd));
            AppMethodBeat.m2505o(37294);
            return;
        }
        AppMethodBeat.m2505o(37294);
    }

    public final void coZ() {
        AppMethodBeat.m2504i(37295);
        super.coZ();
        OfflineVideoView offlineVideoView = this.rbF;
        C4990ab.m7411d("MicroMsg.OfflineVideoView", "%d on destroy %s", Integer.valueOf(offlineVideoView.hashCode()), C5046bo.dpG());
        C4990ab.m7417i("MicroMsg.OfflineVideoView", "%d logic unInit", Integer.valueOf(offlineVideoView.hashCode()));
        offlineVideoView.kkp.removeCallbacksAndMessages(null);
        offlineVideoView.klw.stopTimer();
        if (offlineVideoView.klq != null) {
            offlineVideoView.klq.stop();
        }
        AppMethodBeat.m2505o(37295);
    }

    public final void cpc() {
        AppMethodBeat.m2504i(37296);
        super.cpc();
        int cpw = cpw();
        int height = getView().getHeight();
        C4990ab.m7411d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", Integer.valueOf(cpw), Integer.valueOf(height));
        if (cpw == 0 || height == 0) {
            AppMethodBeat.m2505o(37296);
            return;
        }
        this.rbJ = cpw;
        this.iZo = height;
        if (cpw < 0) {
            AppMethodBeat.m2505o(37296);
            return;
        }
        C4990ab.m7411d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", Integer.valueOf(this.rbd));
        if (((float) cpw) < ((float) height) * 0.5f) {
            this.raY = false;
            this.raX = false;
            cpN();
            if (this.rbd == 1) {
                this.rbd = 2;
            }
        } else if (!this.raX || this.raY) {
            this.raY = false;
            this.raX = true;
            if (this.rbd == 0) {
                if (this.raV) {
                    coY();
                } else {
                    cpd();
                }
                this.rbd = 1;
                bgC();
                AppMethodBeat.m2505o(37296);
                return;
            } else if (this.rbd == 2) {
                if (this.raV) {
                    coY();
                } else {
                    cpd();
                }
                bgC();
                this.rbd = 1;
                AppMethodBeat.m2505o(37296);
                return;
            } else if (this.rbd == 3) {
                if (this.raV) {
                    coY();
                } else {
                    cpd();
                }
                bgC();
                AppMethodBeat.m2505o(37296);
                return;
            }
        } else {
            AppMethodBeat.m2505o(37296);
            return;
        }
        AppMethodBeat.m2505o(37296);
    }

    /* renamed from: al */
    public final boolean mo15456al(JSONObject jSONObject) {
        AppMethodBeat.m2504i(37297);
        if (super.mo15456al(jSONObject)) {
            try {
                Object obj;
                String ck;
                JSONObject jSONObject2;
                jSONObject.put("sightDuration", this.rbG * 1000);
                jSONObject.put("playTimeInterval", this.rbe);
                jSONObject.put("playCount", this.playCount);
                jSONObject.put("playCompletedCount", this.rbf);
                jSONObject.put("clickVoiceControlCount", this.rbh);
                String str = "isAutoPlay";
                if (this.raZ) {
                    obj = "1";
                } else {
                    obj = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                jSONObject.put(str, obj);
                if (((C46233o) this.qZo).type == 61) {
                    jSONObject.put("clickSightCount", this.rbI);
                }
                if (!this.rbc) {
                    ck = C4995ag.m7428ck(((C46233o) this.qZo).qWF);
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("sightUrlInfo", jSONObject2);
                }
                if (!this.rbb) {
                    ck = C4995ag.m7428ck(((C46233o) this.qZo).qWG);
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("thumbUrlInfo", jSONObject2);
                }
                jSONObject.put("streamVideoEnterCount", this.rbH);
                jSONObject.put("streamVideoPlayCount", this.qEo);
                jSONObject.put("streamVideoPlayCompleteCount", this.qEp);
                jSONObject.put("streamVideoTotalPlayTimeInMs", this.qEq);
                AppMethodBeat.m2505o(37297);
                return true;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", e, "", new Object[0]);
                AppMethodBeat.m2505o(37297);
                return false;
            }
        }
        AppMethodBeat.m2505o(37297);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37298);
        C4990ab.m7416i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
        AppMethodBeat.m2505o(37298);
    }

    public final void cpA() {
        AppMethodBeat.m2504i(37299);
        super.cpA();
        String gj = C13473h.m21625gj("adId", ((C46233o) this.qZo).qWG);
        cpN();
        if (C5730e.m8628ct(gj)) {
            this.rbF.mo65976Zz(gj);
            this.rbF.mo65977a(false, 0.0f);
        }
        AppMethodBeat.m2505o(37299);
    }

    public final void cpQ() {
        AppMethodBeat.m2504i(37287);
        C46233o c46233o = (C46233o) this.qZo;
        if (C5046bo.isNullOrNil(c46233o.qWH)) {
            C4990ab.m7412e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
            AppMethodBeat.m2505o(37287);
        } else if (this.context instanceof Activity) {
            C4990ab.m7419v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", c46233o.qWH);
            Intent intent = new Intent();
            intent.setClass(this.context, VideoAdPlayerUI.class);
            intent.putExtra("IsAd", true);
            intent.putExtra("KMediaId", C4995ag.m7428ck(c46233o.qWH));
            intent.putExtra("KThumUrl", c46233o.qWG);
            intent.putExtra("KStremVideoUrl", c46233o.qWH);
            intent.putExtra("ForceLandscape", true);
            intent.putExtra("ShareBtnHidden", 1);
            intent.putExtra("KComponentCid", cpy());
            ((Activity) this.context).startActivityForResult(intent, rbL);
            this.rbH++;
            AppMethodBeat.m2505o(37287);
        } else {
            C4990ab.m7412e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
            AppMethodBeat.m2505o(37287);
        }
    }

    private boolean cpR() {
        AppMethodBeat.m2504i(37288);
        if (C5046bo.isNullOrNil(((C46233o) this.qZo).qWf)) {
            AppMethodBeat.m2505o(37288);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", cpC().qXp);
        intent.putExtra("sns_landing_pages_ux_info", cpC().qPj);
        intent.putExtra("sns_landing_pages_xml", "");
        intent.putExtra("sns_landing_pages_canvasid", ((C46233o) this.qZo).qWf);
        intent.putExtra("sns_landing_pages_canvas_ext", ((C46233o) this.qZo).qWg);
        intent.putExtra("sns_landing_pages_no_store", ((C46233o) this.qZo).qWh);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        if ((this.context instanceof Activity) && cpC().qXr == 2) {
            String stringExtra = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
            String stringExtra2 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!C5046bo.isNullOrNil(stringExtra)) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", valueOf);
                    jSONObject.put("cid", ((C46233o) this.qZo).qWO);
                    jSONObject.put("adBuffer", !C5046bo.isNullOrNil(stringExtra2) ? stringExtra2 : "");
                    jSONObject.put("preSessionId", stringExtra);
                } catch (Exception e) {
                }
                intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
                intent.putExtra("sns_landing_pages_sessionId", valueOf);
                intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
            }
        }
        int[] iArr = new int[2];
        this.rbF.getLocationOnScreen(iArr);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_width", this.rbF.getWidth());
        intent.putExtra("img_gallery_height", this.rbF.getHeight());
        C25985d.m41467b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        AppMethodBeat.m2505o(37288);
        return true;
    }

    /* renamed from: e */
    static /* synthetic */ void m68049e(C39774x c39774x) {
        AppMethodBeat.m2504i(37300);
        c39774x.rbF.mo65978ae(0, true);
        AppMethodBeat.m2505o(37300);
    }
}
