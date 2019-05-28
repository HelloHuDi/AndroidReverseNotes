package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.support.v4.content.d;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vfs.e;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class z extends y implements b, h.b {
    private Context context;
    private ak fbD;
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
    private ac rbi = null;
    private OnClickListener rbj = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(37308);
            ab.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", Boolean.valueOf(z.this.raL.isPlaying()));
            if (z.this.raL.isPlaying()) {
                z.this.cpN();
                z.this.rbd = 4;
            } else {
                if (z.this.raV) {
                    z.this.coY();
                } else {
                    z.this.cpe();
                    z.this.cpd();
                }
                z.b(z.this);
                z.this.rbd = 3;
            }
            if (z.this.qVK) {
                z zVar = z.this;
                zVar.rbg++;
            }
            AppMethodBeat.o(37308);
        }
    };
    private OnClickListener rbk = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(37309);
            z zVar = z.this;
            zVar.rbh++;
            if (z.this.raV) {
                z.this.cpe();
                z.this.cpd();
            } else {
                z.this.coY();
            }
            z.this.raS = true;
            AppMethodBeat.o(37309);
        }
    };
    private OnClickListener rbl = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(37311);
            z.b(z.this);
            z.this.raW = false;
            z.this.raT = true;
            z.this.rbd = 3;
            z.this.cpd();
            z.this.la(true);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(37310);
                    if (z.this.raU) {
                        AppMethodBeat.o(37310);
                        return;
                    }
                    z.this.la(false);
                    AppMethodBeat.o(37310);
                }
            }, 10000);
            AppMethodBeat.o(37311);
        }
    };
    private OnClickListener rbm = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(37312);
            if (!z.this.raU) {
                z.this.raU = true;
                z.this.la(true);
            }
            AppMethodBeat.o(37312);
        }
    };

    static /* synthetic */ void b(z zVar) {
        AppMethodBeat.i(37332);
        zVar.bgC();
        AppMethodBeat.o(37332);
    }

    public z(final Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z zVar, ViewGroup viewGroup) {
        super(context, zVar, viewGroup);
        AppMethodBeat.i(37314);
        this.context = context;
        this.fbD = new ak(Looper.getMainLooper());
        this.raR = new Runnable() {
            public final void run() {
                AppMethodBeat.i(37302);
                z.this.la(false);
                AppMethodBeat.o(37302);
            }
        };
        this.rbi = new ac() {
            public final void lb(boolean z) {
                AppMethodBeat.i(37305);
                Intent intent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
                intent.putExtra("show", z ? 1 : 0);
                d.S(context).c(intent);
                AppMethodBeat.o(37305);
            }
        };
        AppMethodBeat.o(37314);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.au_;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cpk() {
        String gj;
        LayoutParams layoutParams;
        AppMethodBeat.i(37315);
        View findViewById = this.contentView.findViewById(R.id.um);
        findViewById.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        int i = this.ieu;
        int i2 = this.iev;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qXw == 1) {
            if (((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).width) > 0) {
                i2 = (i * ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).height)) / ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).width);
            }
            findViewById.setLayoutParams(new LayoutParams(i, i2));
            findViewById.setMinimumHeight(i2);
            this.raL = (AdLandingVideoWrapper) findViewById.findViewById(R.id.wh);
            this.raL.setIMMVideoViewCallback(this);
            this.raL.setOnClickListener(this.rbm);
            this.raL.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qWH, 0);
            this.raL.setIsShowBasicControls(true);
            this.gtI = (ProgressBar) findViewById.findViewById(R.id.rj);
            this.mOX = (ImageView) findViewById.findViewById(R.id.z4);
            gj = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.gj("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qXv);
            if (!e.ct(gj)) {
                this.rbb = false;
            }
            if (this.rbb) {
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qXv, false, 1000000001, new a() {
                    public final void cpu() {
                    }

                    public final void cmD() {
                    }

                    public final void YJ(String str) {
                        AppMethodBeat.i(37306);
                        if (z.this.mOX.getVisibility() == 0) {
                            z.this.mOX.setImageBitmap(MMBitmapFactory.decodeFile(str));
                        }
                        AppMethodBeat.o(37306);
                    }
                });
            } else {
                this.mOX.setImageBitmap(MMBitmapFactory.decodeFile(gj));
            }
            this.raQ = (TextView) findViewById.findViewById(R.id.edz);
            this.raQ.setText(this.context.getString(R.string.b6p));
            this.iVh = findViewById.findViewById(R.id.efp);
            this.iVh.setVisibility(4);
            this.raM = new VideoPlayerSeekBar(this.context);
            this.raM.setVisibility(4);
            if (this.rbi != null) {
                this.rbi.lb(this.raM.getVisibility() == 0);
            }
            this.raM.setIplaySeekCallback(this);
            this.raM.setOnPlayButtonClickListener(this.rbj);
            layoutParams = new LayoutParams(i - com.tencent.mm.bz.a.fromDPToPix(this.context, 30), -2);
            layoutParams.addRule(12);
            this.raM.setLayoutParams(layoutParams);
            this.raL.setVideoFooterView(this.raM);
            this.raN = (ImageView) findViewById.findViewById(R.id.efq);
            this.raN.setVisibility(4);
            this.raN.setOnClickListener(this.rbk);
            this.raN.setPadding(0, 0, com.tencent.mm.bz.a.fromDPToPix(this.context, 8), 0);
            this.raP = (ImageView) findViewById.findViewById(R.id.l4);
            this.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.shortvideo_play_btn));
            this.raP.setVisibility(8);
            this.raP.setOnClickListener(this.rbl);
            ((ViewGroup) this.raM.getParent()).removeView(this.raM);
            layoutParams.bottomMargin = 0;
            ((ViewGroup) findViewById).addView(this.raM, layoutParams);
            this.raL.setVideoPlayCallback(new AdLandingVideoWrapper.a() {
                public final void Dq(int i) {
                    AppMethodBeat.i(37307);
                    if (!(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) z.this.qZo).qWM == null || i * 1000 < ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) z.this.qZo).qWM.qXt || z.this.raO)) {
                        z.this.raO = true;
                        ma maVar = new ma();
                        maVar.cHQ.cHR = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) z.this.qZo).qWM.cHR;
                        com.tencent.mm.sdk.b.a.xxA.m(maVar);
                    }
                    AppMethodBeat.o(37307);
                }
            });
            AppMethodBeat.o(37315);
        }
        findViewById.setPadding((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qWS, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qWQ, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qWT, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qWR);
        findViewById.setLayoutParams(new LayoutParams(i, i2));
        findViewById.setMinimumHeight(i2);
        this.raL = (AdLandingVideoWrapper) findViewById.findViewById(R.id.wh);
        this.raL.setIMMVideoViewCallback(this);
        this.raL.setOnClickListener(this.rbm);
        this.raL.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qWH, 0);
        this.raL.setIsShowBasicControls(true);
        this.gtI = (ProgressBar) findViewById.findViewById(R.id.rj);
        this.mOX = (ImageView) findViewById.findViewById(R.id.z4);
        gj = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.gj("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qXv);
        if (e.ct(gj)) {
        }
        if (this.rbb) {
        }
        this.raQ = (TextView) findViewById.findViewById(R.id.edz);
        this.raQ.setText(this.context.getString(R.string.b6p));
        this.iVh = findViewById.findViewById(R.id.efp);
        this.iVh.setVisibility(4);
        this.raM = new VideoPlayerSeekBar(this.context);
        this.raM.setVisibility(4);
        if (this.rbi != null) {
        }
        this.raM.setIplaySeekCallback(this);
        this.raM.setOnPlayButtonClickListener(this.rbj);
        layoutParams = new LayoutParams(i - com.tencent.mm.bz.a.fromDPToPix(this.context, 30), -2);
        layoutParams.addRule(12);
        this.raM.setLayoutParams(layoutParams);
        this.raL.setVideoFooterView(this.raM);
        this.raN = (ImageView) findViewById.findViewById(R.id.efq);
        this.raN.setVisibility(4);
        this.raN.setOnClickListener(this.rbk);
        this.raN.setPadding(0, 0, com.tencent.mm.bz.a.fromDPToPix(this.context, 8), 0);
        this.raP = (ImageView) findViewById.findViewById(R.id.l4);
        this.raP.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.shortvideo_play_btn));
        this.raP.setVisibility(8);
        this.raP.setOnClickListener(this.rbl);
        ((ViewGroup) this.raM.getParent()).removeView(this.raM);
        layoutParams.bottomMargin = 0;
        ((ViewGroup) findViewById).addView(this.raM, layoutParams);
        this.raL.setVideoPlayCallback(/* anonymous class already generated */);
        AppMethodBeat.o(37315);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
    }

    private void bgC() {
        AppMethodBeat.i(37316);
        ab.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play");
        if (this.rba) {
            ab.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
            this.raL.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qWH, 0);
            Dp(0);
            this.raL.cpT();
            AppMethodBeat.o(37316);
            return;
        }
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(37313);
                if (!z.this.raL.isPlaying()) {
                    if (z.this.raL.getCurrPosSec() == z.this.raL.getVideoDurationSec()) {
                        z.this.Dp(0);
                    } else {
                        z.this.Dp(z.this.raL.getCurrPosSec());
                    }
                    z.this.raL.cpT();
                }
                AppMethodBeat.o(37313);
            }
        });
        this.oKj = System.currentTimeMillis();
        this.playCount++;
        AppMethodBeat.o(37316);
    }

    /* Access modifiers changed, original: final */
    public final void cpN() {
        AppMethodBeat.i(37317);
        ab.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(37303);
                z.this.raL.pause();
                AppMethodBeat.o(37303);
            }
        });
        if (this.oKj != 0) {
            this.rbe = (int) (((long) this.rbe) + (System.currentTimeMillis() - this.oKj));
            this.oKj = 0;
        }
        AppMethodBeat.o(37317);
    }

    /* Access modifiers changed, original: final */
    public final void la(boolean z) {
        AppMethodBeat.i(37318);
        if (z) {
            this.raM.setVisibility(0);
            this.raN.setVisibility(0);
            this.iVh.setVisibility(0);
            if (this.rbi != null) {
                this.rbi.lb(true);
            }
            this.fbD.postDelayed(this.raR, 5000);
            AppMethodBeat.o(37318);
            return;
        }
        this.raU = false;
        this.raM.setVisibility(4);
        this.raN.setVisibility(8);
        this.iVh.setVisibility(4);
        if (this.rbi != null) {
            this.rbi.lb(false);
        }
        this.fbD.removeCallbacks(this.raR);
        AppMethodBeat.o(37318);
    }

    /* Access modifiers changed, original: final */
    public final void Dp(int i) {
        AppMethodBeat.i(37319);
        if (this.raL != null) {
            this.raP.setVisibility(8);
            if (this.mOX.getVisibility() == 0) {
                this.gtI.setVisibility(0);
            }
            this.raL.e((double) i, true);
        }
        AppMethodBeat.o(37319);
    }

    public final void coY() {
        AppMethodBeat.i(37320);
        super.coY();
        this.raN.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.drawable.b7m));
        this.raL.setMute(true);
        this.raV = true;
        AppMethodBeat.o(37320);
    }

    public final void cpd() {
        AppMethodBeat.i(37321);
        super.cpd();
        this.raN.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.drawable.b7n));
        this.raL.setMute(false);
        this.raV = false;
        AppMethodBeat.o(37321);
    }

    public final void cpa() {
        AppMethodBeat.i(37322);
        super.cpa();
        AppMethodBeat.o(37322);
    }

    public final void cpb() {
        AppMethodBeat.i(37323);
        super.cpb();
        cpN();
        if (this.raX || this.raY) {
            this.raY = false;
            this.raX = false;
            if (this.rbd == 1) {
                this.rbd = 2;
            }
            AppMethodBeat.o(37323);
            return;
        }
        AppMethodBeat.o(37323);
    }

    public final void coZ() {
        AppMethodBeat.i(37324);
        super.coZ();
        this.raL.aEX();
        AppMethodBeat.o(37324);
    }

    public final void cpc() {
        AppMethodBeat.i(37325);
        super.cpc();
        int cpw = cpw();
        int height = getView().getHeight();
        ab.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", Integer.valueOf(cpw), Integer.valueOf(height));
        if (cpw == 0 || height == 0) {
            AppMethodBeat.o(37325);
        } else if (cpw < 0) {
            AppMethodBeat.o(37325);
        } else if (((float) cpw) < ((float) height) * 0.5f) {
            this.raY = false;
            this.raX = false;
            cpN();
            if (this.rbd == 1) {
                this.rbd = 2;
            }
            AppMethodBeat.o(37325);
        } else if (!this.raX || this.raY) {
            this.raY = false;
            this.raX = true;
            this.mOX.setVisibility(0);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!this.raW || (this.raW && activeNetworkInfo != null && activeNetworkInfo.getType() == 1)) {
                la(true);
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37304);
                        if (z.this.raU) {
                            AppMethodBeat.o(37304);
                            return;
                        }
                        z.this.la(false);
                        AppMethodBeat.o(37304);
                    }
                }, 3000);
            }
            if (this.raW) {
                if (activeNetworkInfo == null || !(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                    this.raP.setVisibility(0);
                    this.raZ = false;
                    this.raW = false;
                    AppMethodBeat.o(37325);
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
                AppMethodBeat.o(37325);
            } else if (this.rbd == 2) {
                if (this.raV) {
                    coY();
                } else {
                    cpd();
                }
                bgC();
                this.rbd = 1;
                AppMethodBeat.o(37325);
                return;
            } else {
                if (this.rbd == 3) {
                    if (this.raV) {
                        coY();
                    } else {
                        cpd();
                    }
                }
                AppMethodBeat.o(37325);
            }
            bgC();
            AppMethodBeat.o(37325);
        } else {
            AppMethodBeat.o(37325);
        }
    }

    public final boolean al(JSONObject jSONObject) {
        AppMethodBeat.i(37326);
        if (super.al(jSONObject)) {
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
                    ck = ag.ck(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qXv);
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("thumbUrlInfo", jSONObject2);
                }
                if (!this.rbc) {
                    ck = ag.ck(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qWH);
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("streamVideoUrlInfo", jSONObject2);
                }
                AppMethodBeat.o(37326);
                return true;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", e, "", new Object[0]);
                AppMethodBeat.o(37326);
                return false;
            }
        }
        AppMethodBeat.o(37326);
        return false;
    }

    public final void aFw() {
        this.raU = true;
    }

    public final void oA(int i) {
        AppMethodBeat.i(37327);
        ab.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(i)));
        if (this.raV) {
            coY();
        } else {
            cpe();
            cpd();
        }
        Dp(i);
        AppMethodBeat.o(37327);
    }

    public final void cp(String str, String str2) {
        this.rba = false;
    }

    public final void cq(String str, String str2) {
        AppMethodBeat.i(37328);
        this.rbf++;
        la(true);
        this.raL.rcg.stopTimer();
        if (this.oKj != 0) {
            this.rbe = (int) (((long) this.rbe) + (System.currentTimeMillis() - this.oKj));
            this.oKj = 0;
        }
        this.rbd = 5;
        this.raL.akV();
        AppMethodBeat.o(37328);
    }

    public final void cr(String str, String str2) {
    }

    public final void cs(String str, String str2) {
        AppMethodBeat.i(37329);
        this.mOX.setVisibility(8);
        this.gtI.setVisibility(8);
        AppMethodBeat.o(37329);
    }

    public final void d(String str, String str2, int i, int i2) {
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(37330);
        ab.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "online play error, %s", str3);
        this.rba = true;
        AppMethodBeat.o(37330);
    }

    public final void ct(String str, String str2) {
    }

    public final void cu(String str, String str2) {
    }

    public final void cpA() {
        AppMethodBeat.i(37331);
        super.cpA();
        cpN();
        String gj = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.gj("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z) this.qZo).qXv);
        if (e.ct(gj)) {
            this.mOX.setImageBitmap(MMBitmapFactory.decodeFile(gj));
            this.mOX.setVisibility(0);
        }
        AppMethodBeat.o(37331);
    }
}
