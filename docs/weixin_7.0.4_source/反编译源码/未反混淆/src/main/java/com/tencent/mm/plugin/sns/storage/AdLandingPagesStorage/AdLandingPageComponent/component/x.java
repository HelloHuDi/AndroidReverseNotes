package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class x extends a {
    public static int rbL = 999;
    private Context context;
    private boolean eCM;
    private ak fbD;
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

    static /* synthetic */ boolean k(x xVar) {
        AppMethodBeat.i(37301);
        boolean cpR = xVar.cpR();
        AppMethodBeat.o(37301);
        return cpR;
    }

    public x(Context context, o oVar, ViewGroup viewGroup) {
        super(context, oVar, viewGroup);
        AppMethodBeat.i(37285);
        this.context = context;
        this.fbD = new ak(Looper.getMainLooper());
        AppMethodBeat.o(37285);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.auc;
    }

    public final void cpk() {
        ViewParent parent;
        boolean z;
        AppMethodBeat.i(37286);
        if (!e.ct(h.gj("adId", ((o) this.qZo).qWG))) {
            this.rbb = false;
        }
        if (!e.ct(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + ag.ck(((o) this.qZo).qWF))) {
            this.rbc = false;
        }
        View findViewById = this.contentView.findViewById(R.id.efu);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(R.id.efv);
        this.rbF = new OfflineVideoView(this.context);
        viewGroup.addView(this.rbF, new LayoutParams(-1, -1));
        int i;
        RelativeLayout.LayoutParams layoutParams;
        if (((o) this.qZo).qWL == 0) {
            if (((int) ((o) this.qZo).width) > 0) {
                i = this.ieu;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, (int) ((((float) i) * ((o) this.qZo).height) / ((o) this.qZo).width));
                viewGroup.setLayoutParams(layoutParams2);
                findViewById.setLayoutParams(layoutParams2);
            } else {
                viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(this.ieu, this.iev));
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.ieu, this.iev));
            }
        } else if (((o) this.qZo).qWL == 1) {
            int i2;
            int i3;
            if (((o) this.qZo).width / ((float) this.ieu) > ((o) this.qZo).height / ((float) this.iev)) {
                i = this.ieu;
                i2 = ((int) ((((float) i) * ((o) this.qZo).height) / ((o) this.qZo).width)) + 1;
                i3 = i;
            } else {
                i = this.iev;
                i3 = ((int) ((((float) i) * ((o) this.qZo).width) / ((o) this.qZo).height)) + 1;
                i2 = i;
            }
            layoutParams = new RelativeLayout.LayoutParams(i3, i2);
            layoutParams.leftMargin = (this.ieu - i3) / 2;
            layoutParams.rightMargin = layoutParams.leftMargin;
            layoutParams.topMargin = (this.iev - i2) / 2;
            layoutParams.bottomMargin = layoutParams.topMargin;
            viewGroup.setLayoutParams(layoutParams);
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.ieu, this.iev));
        } else if (((o) this.qZo).qWL == 2) {
            layoutParams = new RelativeLayout.LayoutParams((int) ((o) this.qZo).width, (int) ((o) this.qZo).height);
            viewGroup.setLayoutParams(layoutParams);
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams));
        }
        String gj = h.gj("adId", ((o) this.qZo).qWG);
        if (e.ct(gj)) {
            this.rbF.Zz(gj);
        } else {
            h.c("adId", ((o) this.qZo).qWG, false, 1000000001, new f.a() {
                public final void cpu() {
                }

                public final void cmD() {
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(37272);
                    x.this.rbF.Zz(str);
                    AppMethodBeat.o(37272);
                }
            });
        }
        this.raQ = (TextView) findViewById.findViewById(R.id.edz);
        this.raQ.setText(this.context.getString(R.string.b6p));
        this.iVh = findViewById.findViewById(R.id.efp);
        if (this.iVh != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            parent = this.iVh.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.iVh);
            }
            ((ViewGroup) findViewById).addView(this.iVh, layoutParams3);
        }
        this.raN = (ImageView) findViewById.findViewById(R.id.efq);
        this.raN.setVisibility(0);
        this.raN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(37273);
                x xVar = x.this;
                xVar.rbh++;
                if (x.this.raV) {
                    x.this.cpe();
                    x.this.cpd();
                    AppMethodBeat.o(37273);
                    return;
                }
                x.this.coY();
                AppMethodBeat.o(37273);
            }
        });
        this.raN.setPadding(0, 0, com.tencent.mm.bz.a.fromDPToPix(this.context, 8), com.tencent.mm.bz.a.fromDPToPix(this.context, 13));
        parent = this.raN.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.raN);
        }
        ((ViewGroup) findViewById).addView(this.raN);
        this.rbF.setVideoCallback(new OfflineVideoView.a() {
            public final boolean a(PString pString) {
                AppMethodBeat.i(37277);
                String str = "adId";
                String str2 = ((o) x.this.qZo).qWF;
                String gk = h.gk(str, str2);
                if (e.ct(gk)) {
                    pString.value = gk;
                    x.this.rbK = true;
                    AppMethodBeat.o(37277);
                    return true;
                }
                h.d(str, str2, false, 62, new f.a() {
                    public final void cpu() {
                    }

                    public final void cmD() {
                        AppMethodBeat.i(37274);
                        ab.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video download fail");
                        x.this.rba = true;
                        AppMethodBeat.o(37274);
                    }

                    public final void YJ(String str) {
                        AppMethodBeat.i(37275);
                        ab.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video view height " + x.this.contentView.getHeight() + ", player height " + x.this.rbF.getHeight());
                        x.this.rba = false;
                        x.this.hGF = str;
                        x.this.rbF.Mj(str);
                        x.this.rbK = true;
                        AppMethodBeat.o(37275);
                    }
                });
                AppMethodBeat.o(37277);
                return false;
            }

            public final void EA() {
                AppMethodBeat.i(37278);
                x.this.rbf = x.this.rbf + 1;
                x.e(x.this);
                AppMethodBeat.o(37278);
            }

            public final void onStart(int i) {
                AppMethodBeat.i(37279);
                x.this.eCM = true;
                x.this.rbG = i;
                x.this.raN.setVisibility(0);
                AppMethodBeat.o(37279);
            }

            public final void Dq(final int i) {
                AppMethodBeat.i(37280);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37276);
                        ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + i + " video time " + x.this.rbG);
                        if (!(((o) x.this.qZo).qWM == null || i * 1000 < ((o) x.this.qZo).qWM.qXt || x.this.raO)) {
                            x.this.raO = true;
                            ma maVar = new ma();
                            maVar.cHQ.cHR = ((o) x.this.qZo).qWM.cHR;
                            com.tencent.mm.sdk.b.a.xxA.m(maVar);
                        }
                        AppMethodBeat.o(37276);
                    }
                });
                AppMethodBeat.o(37280);
            }
        });
        this.raN.setVisibility(8);
        this.rbF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(37281);
                if (x.this.eCM) {
                    x xVar = x.this;
                    xVar.rbI++;
                    if (x.k(x.this)) {
                        AppMethodBeat.o(37281);
                        return;
                    }
                }
                AppMethodBeat.o(37281);
            }
        });
        o oVar = (o) this.qZo;
        if (oVar.cuu != 1 || oVar.qWI.length() <= 0 || oVar.qWH.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            findViewById = this.contentView.findViewById(R.id.efw);
            findViewById.setVisibility(0);
            Button button = (Button) findViewById.findViewById(R.id.efx);
            button.setTextColor(((o) this.qZo).qWJ);
            button.setText(((o) this.qZo).qWI);
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(37282);
                    x.this.cpQ();
                    AppMethodBeat.o(37282);
                }
            });
            findViewById.findViewById(R.id.efy).setBackgroundColor(((o) this.qZo).qWK);
        }
        AppMethodBeat.o(37286);
    }

    private void bgC() {
        AppMethodBeat.i(37289);
        if (this.rba) {
            ab.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
            this.rbF.bwD();
            AppMethodBeat.o(37289);
            return;
        }
        ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
        if (!(this.rbK || TextUtils.isEmpty(this.hGF))) {
            this.rbF.Mj(this.hGF);
            this.rbK = true;
        }
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(37283);
                OfflineVideoView a = x.this.rbF;
                ab.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", Integer.valueOf(a.hashCode()), Boolean.valueOf(a.rkY), Integer.valueOf(a.klq.getCurrentPosition()), Integer.valueOf(a.klq.getDuration()), Integer.valueOf(a.rla));
                a.rkZ = true;
                if (!a.rkY) {
                    a.onResume();
                } else if (bo.isNullOrNil(a.klq.getVideoPath())) {
                    a.onResume();
                } else if (a.klq.getCurrentPosition() >= a.klq.getDuration()) {
                    a.klq.d(0.0d, true);
                    if (a.rkX != null) {
                        a.rkX.onStart(a.duration);
                    }
                } else {
                    a.klq.start();
                }
                a.startTimer();
                AppMethodBeat.o(37283);
            }
        });
        this.oKj = System.currentTimeMillis();
        this.playCount++;
        AppMethodBeat.o(37289);
    }

    private void cpN() {
        AppMethodBeat.i(37290);
        ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(37284);
                OfflineVideoView a = x.this.rbF;
                ab.i("MicroMsg.OfflineVideoView", "%d pause", Integer.valueOf(a.hashCode()));
                ab.d("MicroMsg.OfflineVideoView", "%d on pause %s ", Integer.valueOf(a.hashCode()), bo.dpG());
                a.rkZ = false;
                if (a.klq.isPlaying()) {
                    a.rla = a.klq.getCurrentPosition();
                    ab.i("MicroMsg.OfflineVideoView", "%d pause play", Integer.valueOf(a.hashCode()));
                    a.klq.pause();
                }
                a.bJc();
                a.klw.stopTimer();
                AppMethodBeat.o(37284);
            }
        });
        if (this.oKj != 0) {
            this.rbe = (int) (((long) this.rbe) + (System.currentTimeMillis() - this.oKj));
            this.oKj = 0;
        }
        AppMethodBeat.o(37290);
    }

    public final void coY() {
        AppMethodBeat.i(37291);
        super.coY();
        this.raN.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.icon_volume_off));
        this.rbF.setMute(true);
        this.raV = true;
        AppMethodBeat.o(37291);
    }

    public final void cpd() {
        AppMethodBeat.i(37292);
        super.cpd();
        this.raN.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.icon_volume_on));
        this.rbF.setMute(false);
        this.raV = false;
        AppMethodBeat.o(37292);
    }

    public final void cpa() {
        AppMethodBeat.i(37293);
        super.cpa();
        AppMethodBeat.o(37293);
    }

    public final void cpb() {
        AppMethodBeat.i(37294);
        super.cpb();
        cpN();
        if (this.raX || this.raY) {
            this.raY = false;
            this.raX = false;
            if (this.rbd == 1) {
                this.rbd = 2;
            }
            ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", Integer.valueOf(this.rbd));
            AppMethodBeat.o(37294);
            return;
        }
        AppMethodBeat.o(37294);
    }

    public final void coZ() {
        AppMethodBeat.i(37295);
        super.coZ();
        OfflineVideoView offlineVideoView = this.rbF;
        ab.d("MicroMsg.OfflineVideoView", "%d on destroy %s", Integer.valueOf(offlineVideoView.hashCode()), bo.dpG());
        ab.i("MicroMsg.OfflineVideoView", "%d logic unInit", Integer.valueOf(offlineVideoView.hashCode()));
        offlineVideoView.kkp.removeCallbacksAndMessages(null);
        offlineVideoView.klw.stopTimer();
        if (offlineVideoView.klq != null) {
            offlineVideoView.klq.stop();
        }
        AppMethodBeat.o(37295);
    }

    public final void cpc() {
        AppMethodBeat.i(37296);
        super.cpc();
        int cpw = cpw();
        int height = getView().getHeight();
        ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", Integer.valueOf(cpw), Integer.valueOf(height));
        if (cpw == 0 || height == 0) {
            AppMethodBeat.o(37296);
            return;
        }
        this.rbJ = cpw;
        this.iZo = height;
        if (cpw < 0) {
            AppMethodBeat.o(37296);
            return;
        }
        ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", Integer.valueOf(this.rbd));
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
                AppMethodBeat.o(37296);
                return;
            } else if (this.rbd == 2) {
                if (this.raV) {
                    coY();
                } else {
                    cpd();
                }
                bgC();
                this.rbd = 1;
                AppMethodBeat.o(37296);
                return;
            } else if (this.rbd == 3) {
                if (this.raV) {
                    coY();
                } else {
                    cpd();
                }
                bgC();
                AppMethodBeat.o(37296);
                return;
            }
        } else {
            AppMethodBeat.o(37296);
            return;
        }
        AppMethodBeat.o(37296);
    }

    public final boolean al(JSONObject jSONObject) {
        AppMethodBeat.i(37297);
        if (super.al(jSONObject)) {
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
                if (((o) this.qZo).type == 61) {
                    jSONObject.put("clickSightCount", this.rbI);
                }
                if (!this.rbc) {
                    ck = ag.ck(((o) this.qZo).qWF);
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("sightUrlInfo", jSONObject2);
                }
                if (!this.rbb) {
                    ck = ag.ck(((o) this.qZo).qWG);
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("thumbUrlInfo", jSONObject2);
                }
                jSONObject.put("streamVideoEnterCount", this.rbH);
                jSONObject.put("streamVideoPlayCount", this.qEo);
                jSONObject.put("streamVideoPlayCompleteCount", this.qEp);
                jSONObject.put("streamVideoTotalPlayTimeInMs", this.qEq);
                AppMethodBeat.o(37297);
                return true;
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", e, "", new Object[0]);
                AppMethodBeat.o(37297);
                return false;
            }
        }
        AppMethodBeat.o(37297);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37298);
        ab.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
        AppMethodBeat.o(37298);
    }

    public final void cpA() {
        AppMethodBeat.i(37299);
        super.cpA();
        String gj = h.gj("adId", ((o) this.qZo).qWG);
        cpN();
        if (e.ct(gj)) {
            this.rbF.Zz(gj);
            this.rbF.a(false, 0.0f);
        }
        AppMethodBeat.o(37299);
    }

    public final void cpQ() {
        AppMethodBeat.i(37287);
        o oVar = (o) this.qZo;
        if (bo.isNullOrNil(oVar.qWH)) {
            ab.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
            AppMethodBeat.o(37287);
        } else if (this.context instanceof Activity) {
            ab.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", oVar.qWH);
            Intent intent = new Intent();
            intent.setClass(this.context, VideoAdPlayerUI.class);
            intent.putExtra("IsAd", true);
            intent.putExtra("KMediaId", ag.ck(oVar.qWH));
            intent.putExtra("KThumUrl", oVar.qWG);
            intent.putExtra("KStremVideoUrl", oVar.qWH);
            intent.putExtra("ForceLandscape", true);
            intent.putExtra("ShareBtnHidden", 1);
            intent.putExtra("KComponentCid", cpy());
            ((Activity) this.context).startActivityForResult(intent, rbL);
            this.rbH++;
            AppMethodBeat.o(37287);
        } else {
            ab.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
            AppMethodBeat.o(37287);
        }
    }

    private boolean cpR() {
        AppMethodBeat.i(37288);
        if (bo.isNullOrNil(((o) this.qZo).qWf)) {
            AppMethodBeat.o(37288);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", cpC().qXp);
        intent.putExtra("sns_landing_pages_ux_info", cpC().qPj);
        intent.putExtra("sns_landing_pages_xml", "");
        intent.putExtra("sns_landing_pages_canvasid", ((o) this.qZo).qWf);
        intent.putExtra("sns_landing_pages_canvas_ext", ((o) this.qZo).qWg);
        intent.putExtra("sns_landing_pages_no_store", ((o) this.qZo).qWh);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        if ((this.context instanceof Activity) && cpC().qXr == 2) {
            String stringExtra = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
            String stringExtra2 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!bo.isNullOrNil(stringExtra)) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", valueOf);
                    jSONObject.put("cid", ((o) this.qZo).qWO);
                    jSONObject.put("adBuffer", !bo.isNullOrNil(stringExtra2) ? stringExtra2 : "");
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
        d.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        AppMethodBeat.o(37288);
        return true;
    }

    static /* synthetic */ void e(x xVar) {
        AppMethodBeat.i(37300);
        xVar.rbF.ae(0, true);
        AppMethodBeat.o(37300);
    }
}
