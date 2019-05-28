package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.q;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.vfs.e;

@a(19)
public class VideoAdPlayerUI extends MMActivity implements b.a, b.b {
    private String bssid;
    private String cHr = "";
    private String cMn;
    private String ePJ = "";
    private String fiJ = "";
    private String fiK = "";
    private String hnw = "";
    private d iaf;
    private boolean isPlaying = false;
    private boolean qFG = false;
    private String qWO = "";
    private VideoPlayView rEa;
    private com.tencent.mm.modelsns.b rEb = null;
    private String rEc = "";
    private int rEd = 0;
    private String rEe = "";
    public String rEf = "";
    public String rEg = "";
    private int rEh = 0;
    private int rEi = 0;
    private String rEj = "";
    private String rEk;
    private String rEl = "";
    private long rEm = 0;
    private int rEn = 0;
    private int rEo = 0;
    private boolean rEp = false;
    private boolean rEq = false;
    private bau rEr = null;
    private String rEs;
    private int rEt;
    private String[] rEu = null;
    private String[] rEv = null;
    private n ros;
    private h rwL = new h("VideoAdPlayerUI");
    private String ssid;
    private String thumbPath = "";
    private String thumbUrl = "";
    private String url = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoAdPlayerUI() {
        AppMethodBeat.i(39917);
        AppMethodBeat.o(39917);
    }

    public void onCreate(Bundle bundle) {
        String fZ;
        AppMethodBeat.i(39918);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (ae.hD(this.mController.ylL)) {
            this.mController.xE(getResources().getColor(R.color.dt));
        }
        this.rEu = new String[]{getString(R.string.ejf), getString(R.string.ejg), getString(R.string.eje)};
        this.rEv = new String[]{getString(R.string.ejf), getString(R.string.ejg)};
        this.ros = af.cnF().YS(i.Xq(getIntent().getStringExtra("KSta_SnSId")));
        this.iaf = new d();
        this.rEb = com.tencent.mm.modelsns.b.u(getIntent());
        this.ePJ = getIntent().getStringExtra("KFullVideoPath");
        this.rEc = getIntent().getStringExtra("KStremVideoUrl");
        this.thumbUrl = getIntent().getStringExtra("KThumUrl");
        this.cHr = getIntent().getStringExtra("KMediaId");
        this.qFG = getIntent().getBooleanExtra("IsAd", false);
        this.url = getIntent().getStringExtra("KUrl");
        this.rEe = bo.bc(getIntent().getStringExtra("KMediaTitle"), "");
        this.rEd = getIntent().getIntExtra("KMediaVideoTime", 0);
        this.rEp = getIntent().getBooleanExtra("KBlockFav", false);
        this.rEq = getIntent().getBooleanExtra("ForceLandscape", false);
        this.fiJ = getIntent().getStringExtra("StreamWording");
        this.fiK = getIntent().getStringExtra("StremWebUrl");
        this.qWO = getIntent().getStringExtra("KComponentCid");
        this.rEf = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
        this.rEg = getIntent().getStringExtra("KSta_StremVideoPublishId");
        this.rEh = getIntent().getIntExtra("KSta_SourceType", 0);
        this.rEi = getIntent().getIntExtra("KSta_Scene", 0);
        this.rEj = getIntent().getStringExtra("KSta_FromUserName");
        this.rEk = getIntent().getStringExtra("KSta_ChatName");
        this.rEl = getIntent().getStringExtra("KSta_SnSId");
        this.rEm = getIntent().getLongExtra("KSta_MsgId", 0);
        this.rEn = getIntent().getIntExtra("KSta_FavID", 0);
        this.rEo = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
        this.cMn = getIntent().getStringExtra("KSta_SnsStatExtStr");
        this.hnw = bo.bc(getIntent().getStringExtra("KViewId"), "");
        this.rEs = bo.bc(getIntent().getStringExtra("ReportArgs"), "");
        this.rEt = getIntent().getIntExtra("NeedReportData", 0);
        if (this.rEt != 0) {
            this.ssid = at.gE(ah.getContext());
            this.bssid = at.gF(ah.getContext());
        }
        this.rEr = new bau();
        this.rEr.wEH = this.thumbUrl;
        this.rEr.wEO = this.rEc;
        this.rEr.Id = this.cHr;
        this.rEr.Url = this.url;
        this.rEr.wEG = 1;
        this.rEr.rEd = this.rEd;
        this.rwL.qEm = bo.yz();
        ab.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.rEr.Id + " attachurl:" + this.rEr.wEO + " videoattachTotalTime:" + this.rEr.rEd + " streamvideowording: " + this.fiJ + " streamvideoweburl: " + this.fiK + " mediaTitle: " + this.rEe + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.rEf + " streamvideopublishid " + this.rEg);
        if (bo.isNullOrNil(this.ePJ)) {
            fZ = an.fZ(af.getAccSnsPath(), this.rEr.Id);
            this.ePJ = fZ + i.k(this.rEr);
        }
        if (bo.isNullOrNil(this.thumbPath) || !e.ct(this.thumbPath)) {
            fZ = "attach" + this.rEr.Id;
            this.thumbPath = an.fZ(af.getAccSnsPath(), fZ) + i.Xa(fZ);
        }
        if (!e.ct(this.thumbPath)) {
            try {
                bau bau = new bau();
                bau.parseFrom(this.rEr.toByteArray());
                bau.Id = "attach" + bau.Id;
                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(this.rEr);
                eVar.qFQ = 1;
                eVar.nQB = this.rEr.Id;
                af.cnA().a(bau, 7, eVar, az.xYU);
            } catch (Exception e) {
                ab.e("MicroMsg.VideoPlayerUI", "error for download thumb");
            }
            getWindow().addFlags(128);
        }
        this.rEa = (VideoPlayView) findViewById(R.id.f0t);
        VideoPlayView videoPlayView = this.rEa;
        AdVideoPlayerLoadingBar adVideoPlayerLoadingBar = new AdVideoPlayerLoadingBar(this.mController.ylL);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = videoPlayView.getContext().getResources().getDimensionPixelSize(R.dimen.lu);
        videoPlayView.qzc = adVideoPlayerLoadingBar;
        videoPlayView.klq.setPlayProgressCallback(true);
        videoPlayView.addView((View) videoPlayView.qzc, layoutParams);
        videoPlayView.qzc.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void aFw() {
                AppMethodBeat.i(70319);
                VideoPlayView.this.fbD.removeCallbacks(VideoPlayView.this.qzq);
                VideoPlayView.d(VideoPlayView.this);
                AppMethodBeat.o(70319);
            }

            public final void oA(int i) {
                AppMethodBeat.i(70320);
                ab.i("MicroMsg.VideoPlayView", "onSeek time ".concat(String.valueOf(i)));
                VideoPlayView.this.qzd = (double) i;
                VideoPlayView.this.klq.B((double) i);
                VideoPlayView.this.fbD.removeCallbacks(VideoPlayView.this.qzq);
                VideoPlayView.this.fbD.postDelayed(VideoPlayView.this.qzq, 3000);
                AppMethodBeat.o(70320);
            }
        });
        videoPlayView.qzc.setOnPlayButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(70321);
                VideoPlayView.this.fbD.removeCallbacks(VideoPlayView.this.qzq);
                VideoPlayView.this.fbD.postDelayed(VideoPlayView.this.qzq, 3000);
                if (VideoPlayView.this.klq.isPlaying()) {
                    VideoPlayView.o(VideoPlayView.this);
                    if (VideoPlayView.this.qzc != null) {
                        VideoPlayView.this.qzc.setIsPlay(false);
                        AppMethodBeat.o(70321);
                        return;
                    }
                }
                VideoPlayView.a(VideoPlayView.this, false);
                VideoPlayView.this.klq.B(VideoPlayView.this.qzd);
                if (VideoPlayView.this.qzc != null) {
                    VideoPlayView.this.qzc.setIsPlay(true);
                }
                AppMethodBeat.o(70321);
            }
        });
        videoPlayView.qzc.setIsPlay(videoPlayView.klq.isPlaying());
        if (videoPlayView.qzc != null) {
            ((View) videoPlayView.qzc).setVisibility(8);
        }
        adVideoPlayerLoadingBar.seek(0);
        this.rEa.setVideoPlayViewEvent(new VideoPlayView.a() {
            public final void kC(boolean z) {
                AppMethodBeat.i(39907);
                if (z) {
                    VideoAdPlayerUI.this.rwL.qEs.qFt = VideoAdPlayerUI.this.getResources().getConfiguration().orientation == 2 ? 2 : 1;
                    VideoAdPlayerUI.this.rwL.qEs.qFu = bo.yz();
                    VideoAdPlayerUI.this.rwL.qEs.qFs = 2;
                    VideoAdPlayerUI.this.rwL.qEs.qFq = 0;
                }
                if (!VideoAdPlayerUI.this.isPlaying && ((int) VideoAdPlayerUI.this.rEa.getLastProgresstime()) == 0) {
                    com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.this.rwL.qEs;
                    aVar.qFo++;
                }
                VideoAdPlayerUI.this.rwL.qEs.qFu = bo.yz();
                VideoAdPlayerUI.this.iaf.a(VideoAdPlayerUI.this.rEa);
                if (VideoAdPlayerUI.this.rEt != 0) {
                    m iVar = new com.tencent.mm.modelstat.i(13227, "1,1,0," + VideoAdPlayerUI.this.ssid + "," + VideoAdPlayerUI.this.bssid + "," + bo.anT() + "," + VideoAdPlayerUI.this.rEs + "," + VideoAdPlayerUI.this.rEd, (int) bo.anT());
                    g.RQ();
                    g.RO().eJo.a(iVar, 0);
                }
                VideoAdPlayerUI.this.isPlaying = true;
                AppMethodBeat.o(39907);
            }

            public final void clr() {
                AppMethodBeat.i(39908);
                VideoAdPlayerUI.this.iaf.cy(false);
                com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.this.rwL.qEs;
                aVar.qFq += (int) bo.az(VideoAdPlayerUI.this.rwL.qEs.qFu);
                VideoAdPlayerUI.this.isPlaying = false;
                AppMethodBeat.o(39908);
            }

            public final void cls() {
                AppMethodBeat.i(39909);
                ab.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
                com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.this.rwL.qEs;
                aVar.qFp++;
                VideoAdPlayerUI.this.isPlaying = false;
                if (VideoAdPlayerUI.this.rEt != 0) {
                    m iVar = new com.tencent.mm.modelstat.i(13227, "1,2," + VideoAdPlayerUI.this.rEd + "," + VideoAdPlayerUI.this.ssid + "," + VideoAdPlayerUI.this.bssid + "," + bo.anT() + "," + VideoAdPlayerUI.this.rEs + "," + VideoAdPlayerUI.this.rEd, (int) bo.anT());
                    g.RQ();
                    g.RO().eJo.a(iVar, 0);
                }
                AppMethodBeat.o(39909);
            }

            public final void clt() {
                AppMethodBeat.i(39910);
                ab.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
                VideoAdPlayerUI.this.isPlaying = false;
                VideoAdPlayerUI.this.rEa.clo();
                AppMethodBeat.o(39910);
            }

            public final void CG(int i) {
                AppMethodBeat.i(39911);
                if (VideoAdPlayerUI.this.rEd == 0) {
                    VideoAdPlayerUI.this.rEd = i;
                    VideoAdPlayerUI.this.rEr.rEd = i;
                }
                AppMethodBeat.o(39911);
            }
        });
        this.rEa.setVideoTotalTime(this.rEr.rEd);
        if (e.ct(this.ePJ)) {
            this.rwL.qEk = 1;
            this.rEa.setVideoPath(this.ePJ);
        } else {
            this.rEa.clo();
            this.rEa.setIsDownloading(true);
            af.cnA().a(this.rEr, 6, null, az.xYU);
        }
        this.rEa.setLeftButtonOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39912);
                VideoAdPlayerUI.this.finish();
                AppMethodBeat.o(39912);
            }
        });
        this.rEa.setRightButtonOnCliclListener(new OnClickListener() {
            public final void onClick(View view) {
                String[] l;
                AppMethodBeat.i(39914);
                Context context = VideoAdPlayerUI.this;
                if (VideoAdPlayerUI.this.rEp) {
                    l = VideoAdPlayerUI.this.rEv;
                } else {
                    l = VideoAdPlayerUI.this.rEu;
                }
                com.tencent.mm.ui.base.h.a(context, null, l, null, new c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(39913);
                        switch (i) {
                            case 0:
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("ad_video_title", VideoAdPlayerUI.this.rEe);
                                intent.putExtra("Retr_Msg_Type", 2);
                                com.tencent.mm.bp.d.b(VideoAdPlayerUI.this, ".ui.transmit.SelectConversationUI", intent, 4097);
                                AppMethodBeat.o(39913);
                                return;
                            case 1:
                                VideoAdPlayerUI.o(VideoAdPlayerUI.this);
                                AppMethodBeat.o(39913);
                                return;
                            case 2:
                                VideoAdPlayerUI.p(VideoAdPlayerUI.this);
                                break;
                        }
                        AppMethodBeat.o(39913);
                    }
                });
                AppMethodBeat.o(39914);
            }
        });
        VideoPlayView videoPlayView2 = this.rEa;
        String str = this.fiJ;
        AnonymousClass4 anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39916);
                if (VideoAdPlayerUI.this.rEi != 0) {
                    j.a(j.a.DetailInVideo, VideoAdPlayerUI.this.rEg, VideoAdPlayerUI.this.rEf, VideoAdPlayerUI.this.rEh, VideoAdPlayerUI.this.rEi, VideoAdPlayerUI.this.rEj, VideoAdPlayerUI.this.rEk, VideoAdPlayerUI.this.rEl, VideoAdPlayerUI.this.rEm, VideoAdPlayerUI.this.rEn, VideoAdPlayerUI.this.rEo);
                }
                if (VideoAdPlayerUI.this.rEt != 0) {
                    int i = VideoAdPlayerUI.this.rwL.qEs.qFq;
                    if (VideoAdPlayerUI.this.isPlaying && VideoAdPlayerUI.this.rwL.qEs.qFu != 0) {
                        i += (int) (bo.az(VideoAdPlayerUI.this.rwL.qEs.qFu) / 1000);
                    }
                    m iVar = new com.tencent.mm.modelstat.i(13228, "1,1," + i + "," + VideoAdPlayerUI.this.ssid + "," + VideoAdPlayerUI.this.bssid + "," + bo.anT() + "," + VideoAdPlayerUI.this.rEs + "," + VideoAdPlayerUI.this.rEd, (int) bo.anT());
                    g.RQ();
                    g.RO().eJo.a(iVar, 0);
                }
                VideoAdPlayerUI.this.finish();
                final Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key_snsad_statextstr", VideoAdPlayerUI.this.cMn);
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("rawUrl", VideoAdPlayerUI.this.fiK);
                intent.putExtra("useJs", true);
                if (VideoAdPlayerUI.this.qFG) {
                    i.a(new SnsAdClick(0, 6, VideoAdPlayerUI.this.ros.field_snsId, 18, 0));
                }
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(39915);
                        com.tencent.mm.plugin.sns.c.a.gkE.i(intent, VideoAdPlayerUI.this);
                        AppMethodBeat.o(39915);
                    }
                });
                AppMethodBeat.o(39916);
            }
        };
        videoPlayView2.qzf = str;
        videoPlayView2.qze.setText(str);
        videoPlayView2.qze.setOnClickListener(anonymousClass4);
        this.rEa.clq();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0) {
            videoPlayView2 = this.rEa;
            if (videoPlayView2.qzh != null) {
                videoPlayView2.qzi = false;
                videoPlayView2.qzh.setVisibility(8);
            }
        }
        AppMethodBeat.o(39918);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39919);
        ab.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", Integer.valueOf(i));
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : bo.P(stringExtra.split(","))) {
                    ab.i("MicroMsg.VideoPlayerUI", "send sight to %s", str);
                    com.tencent.mm.af.j.b bVar = new com.tencent.mm.af.j.b();
                    bVar.title = this.rEe;
                    bVar.type = 4;
                    if (bo.isNullOrNil(this.rEr.Url)) {
                        bVar.url = this.rEr.wEO;
                    } else {
                        bVar.url = this.rEr.Url;
                    }
                    if (bo.isNullOrNil(this.rEr.wER)) {
                        stringExtra = this.rEr.wEH;
                    } else {
                        stringExtra = this.rEr.wER;
                    }
                    bVar.thumburl = stringExtra;
                    bVar.fiG = this.rEr.wEO;
                    bVar.fiH = this.rEr.rEd;
                    bVar.fiI = this.rEe;
                    bVar.fiK = this.fiK;
                    bVar.fiJ = this.fiJ;
                    bVar.fiL = this.thumbUrl;
                    bVar.fiM = this.rEf;
                    bVar.fiN = this.rEg;
                    bVar.cMn = this.cMn;
                    byte[] e = e.e(this.thumbPath, 0, -1);
                    String str2 = "MicroMsg.VideoPlayerUI";
                    String str3 = "read buf size %d";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(e == null ? 0 : e.length);
                    ab.i(str2, str3, objArr);
                    if (q.a.XD() != null) {
                        q.a.XD().a(bVar, "", "", str, "", e);
                    }
                    if (this.rEt != 0) {
                        int i3 = this.rwL.qEs.qFq;
                        if (this.isPlaying && this.rwL.qEs.qFu != 0) {
                            i3 += (int) (bo.az(this.rwL.qEs.qFu) / 1000);
                        }
                        m iVar = new com.tencent.mm.modelstat.i(13228, "1,3," + i3 + "," + this.ssid + "," + this.bssid + "," + bo.anT() + "," + this.rEs + "," + this.rEd, (int) bo.anT());
                        g.RQ();
                        g.RO().eJo.a(iVar, 0);
                    }
                    com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra2, str);
                    if (this.qFG) {
                        i.a(new SnsAdClick(0, 6, this.ros.field_snsId, 12, 0));
                    }
                    if (this.rEi != 0) {
                        j.c cVar;
                        int mA;
                        boolean kH = t.kH(str);
                        if (kH) {
                            cVar = j.c.Chatroom;
                        } else {
                            cVar = j.c.Chat;
                        }
                        String str4 = this.rEg;
                        str2 = this.rEf;
                        int i4 = this.rEh;
                        int i5 = this.rEi;
                        String str5 = this.rEj;
                        String str6 = this.rEk;
                        String str7 = this.rEl;
                        long j = this.rEm;
                        int i6 = this.rEn;
                        int i7 = this.rEo;
                        if (kH) {
                            mA = com.tencent.mm.model.n.mA(str);
                        } else {
                            mA = 0;
                        }
                        j.a(cVar, str4, str2, i4, i5, str5, str6, str7, j, i6, i7, mA);
                    }
                }
                com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.cbn));
            } else if (this.qFG) {
                i.a(new SnsAdClick(0, 6, this.ros.field_snsId, 13, 0));
            }
        }
        if (4098 == i) {
            if (this.rEi != 0) {
                j.a(j.c.Sns, this.rEg, this.rEf, this.rEh, this.rEi, this.rEj, this.rEk, this.rEl, this.rEm, this.rEn, this.rEo, 0);
            }
            if (-1 == i2) {
                if (this.qFG) {
                    i.a(new SnsAdClick(0, 6, this.ros.field_snsId, 15, 0));
                }
            } else if (this.qFG) {
                i.a(new SnsAdClick(0, 6, this.ros.field_snsId, 16, 0));
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(39919);
    }

    public void onDestroy() {
        AppMethodBeat.i(39920);
        super.onDestroy();
        getWindow().clearFlags(128);
        if (this.rEi != 0) {
            j.a(j.a.LeaveCompleteVideo, this.rEg, this.rEf, this.rEh, this.rEi, this.rEj, this.rEk, this.rEl, this.rEm, this.rEn, this.rEo);
        }
        if (this.qFG) {
            int cre = this.ros == null ? 0 : this.ros.cre();
            if (this.ros != null) {
                String cmf = this.rwL.cmf();
                long j = ((long) this.rwL.qEl) - this.rwL.fQe;
                if (j < 0) {
                    ab.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", Integer.valueOf(this.rwL.qEl), Long.valueOf(this.rwL.fQe));
                    j = (long) this.rwL.qEl;
                }
                int i = (int) j;
                g.RQ();
                g.RO().eJo.a(new com.tencent.mm.plugin.sns.a.b.d(this.hnw, 6, 2, this.rwL.qEl, null, null, 2, cmf, -1, cre, i, i, 0, this.ros.crd().cqw(), this.ros.crd().cqx()), 0);
            }
        }
        if (this.rEt != 0) {
            int i2 = this.rwL.qEs.qFq;
            if (this.isPlaying && this.rwL.qEs.qFu != 0) {
                i2 += (int) (bo.az(this.rwL.qEs.qFu) / 1000);
            }
            m iVar = new com.tencent.mm.modelstat.i(13228, "1,2," + i2 + "," + this.ssid + "," + this.bssid + "," + bo.anT() + "," + this.rEs + "," + this.rEd, (int) bo.anT());
            g.RQ();
            g.RO().eJo.a(iVar, 0);
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", dyi()));
        AppMethodBeat.o(39920);
    }

    public void finish() {
        AppMethodBeat.i(39921);
        if (this.isPlaying) {
            this.rEa.pause();
        }
        if (!(this.rwL == null || this.qWO == null || this.qWO.length() <= 0)) {
            this.rwL.cmg();
            Intent intent = new Intent();
            intent.putExtra("KComponentCid", this.qWO);
            intent.putExtra("KStreamVideoPlayCount", this.rwL.qEo);
            intent.putExtra("KStreamVideoPlayCompleteCount", this.rwL.qEp);
            intent.putExtra("KStreamVideoTotalPlayTimeInMs", this.rwL.qEq);
            setResult(-1, intent);
        }
        super.finish();
        AppMethodBeat.o(39921);
    }

    public void onPause() {
        AppMethodBeat.i(39922);
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        ab.i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i)));
        Ef(i);
        if (this.rEa != null && this.rEa.isPlaying()) {
            this.rEa.pause();
        }
        if (this.rEa != null) {
            ab.i("MicroMsg.VideoPlayerUI", "onDetach");
            this.rEa.onDetach();
        }
        af.cnA().qHK.remove(this);
        af.cnA().b((b.b) this);
        if (this.rwL != null) {
            this.rwL.fQd = bo.yz();
        }
        AppMethodBeat.o(39922);
    }

    public void onResume() {
        AppMethodBeat.i(39923);
        super.onResume();
        af.cnA().qHK.add(this);
        af.cnA().a((b.b) this);
        if (this.rwL != null) {
            this.rwL.onResume();
        }
        AppMethodBeat.o(39923);
    }

    public final int getLayoutId() {
        return R.layout.b1f;
    }

    public final void fW(String str, String str2) {
        AppMethodBeat.i(39924);
        ab.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.rEa.isPlaying());
        if (this.rEa.isPlaying()) {
            AppMethodBeat.o(39924);
            return;
        }
        this.rEa.setLoop(false);
        if (str2.equals(this.rEa.getVideoPath())) {
            this.rEa.B(this.rEa.getLastProgresstime());
            this.rEa.start();
            ab.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + str + " path: " + str2);
            AppMethodBeat.o(39924);
            return;
        }
        this.rEa.setVideoPath(str2);
        this.rEa.B(this.rEa.getLastProgresstime());
        ab.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + str + " path: " + str2);
        AppMethodBeat.o(39924);
    }

    public final void Xw(String str) {
    }

    public final void bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    public final void bk(String str, boolean z) {
        AppMethodBeat.i(39925);
        ab.i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(str)));
        this.rEa.setIsDownloading(false);
        this.rEa.setVideoPath(this.ePJ);
        this.rEa.B(this.rEa.getLastProgresstime());
        this.rEa.setLoop(false);
        if (this.qFG && !bo.isNullOrNil(str) && this.rEr != null && str.equals(this.rEr.Id) && e.ct(this.ePJ)) {
            this.rwL.qEk = 1;
        }
        AppMethodBeat.o(39925);
    }

    public final int getForceOrientation() {
        if (this.rEq) {
            return 0;
        }
        return 4;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(39926);
        super.onConfigurationChanged(configuration);
        VideoPlayView videoPlayView = this.rEa;
        ab.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + configuration.orientation + " " + videoPlayView.qzr);
        if (videoPlayView.qzr != configuration.orientation) {
            if (configuration.orientation == 1) {
                videoPlayView.update(1);
            } else {
                videoPlayView.update(2);
            }
            videoPlayView.qzr = configuration.orientation;
            if (videoPlayView.qzr == 2) {
                videoPlayView.iVh.setVisibility(8);
            }
        }
        Ef(configuration.orientation);
        AppMethodBeat.o(39926);
    }

    private void Ef(int i) {
        AppMethodBeat.i(39927);
        if (this.qFG) {
            this.rwL.CI(this.rEa.getDuration());
            this.rwL.qEs.qFu = bo.yz();
            this.rwL.qEs.qFt = i == 2 ? 2 : 1;
            this.rwL.qEs.qFs = 2;
            ab.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.rwL.qEs.qFt);
            AppMethodBeat.o(39927);
            return;
        }
        AppMethodBeat.o(39927);
    }

    static /* synthetic */ void o(VideoAdPlayerUI videoAdPlayerUI) {
        AppMethodBeat.i(39928);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", videoAdPlayerUI.rEc);
        intent.putExtra("Ksnsupload_type", 11);
        intent.putExtra("Ksnsupload_title", videoAdPlayerUI.rEe);
        intent.putExtra("Ksnsupload_imgurl", videoAdPlayerUI.thumbUrl);
        intent.putExtra("KSnsStreamVideoTotalTime", videoAdPlayerUI.rEr.rEd);
        intent.putExtra("KSnsStreamVideoWroding", videoAdPlayerUI.fiJ);
        intent.putExtra("KSnsStreamVideoWebUrl", videoAdPlayerUI.fiK);
        intent.putExtra("KSnsStreamVideoAduxInfo", videoAdPlayerUI.rEf);
        intent.putExtra("KSnsStreamVideoPublishId", videoAdPlayerUI.rEg);
        intent.putExtra("need_result", true);
        intent.putExtra("key_snsad_statextstr", videoAdPlayerUI.cMn);
        String str = "sns_";
        if (videoAdPlayerUI.rEi == j.b.Sight.value || videoAdPlayerUI.rEi == j.b.AdUrl.value) {
            str = "sns_" + videoAdPlayerUI.rEl;
        } else if (videoAdPlayerUI.rEi == j.b.Chat.value || videoAdPlayerUI.rEi == j.b.TalkChat.value) {
            str = "msg_" + videoAdPlayerUI.rEm;
        } else if (videoAdPlayerUI.rEi == j.b.Fav.value) {
            str = "fav_" + r.Yz() + "_" + videoAdPlayerUI.rEn;
        }
        String nW = v.nW(str);
        v.Zp().y(nW, true).j("prePublishId", str);
        intent.putExtra("reportSessionId", nW);
        com.tencent.mm.bp.d.b((Context) videoAdPlayerUI, "sns", ".ui.SnsUploadUI", intent, 4098);
        if (videoAdPlayerUI.rEt != 0) {
            int i = videoAdPlayerUI.rwL.qEs.qFq;
            if (videoAdPlayerUI.isPlaying && videoAdPlayerUI.rwL.qEs.qFu != 0) {
                i += (int) (bo.az(videoAdPlayerUI.rwL.qEs.qFu) / 1000);
            }
            m iVar = new com.tencent.mm.modelstat.i(13228, "1,4," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + bo.anT() + "," + videoAdPlayerUI.rEs + "," + videoAdPlayerUI.rEd, (int) bo.anT());
            g.RQ();
            g.RO().eJo.a(iVar, 0);
        }
        AppMethodBeat.o(39928);
    }

    static /* synthetic */ void p(VideoAdPlayerUI videoAdPlayerUI) {
        AppMethodBeat.i(39929);
        cl clVar = new cl();
        ((ad) g.K(ad.class)).a(clVar, videoAdPlayerUI.rEr.rEd, videoAdPlayerUI.rEe, "", videoAdPlayerUI.rEr.wEO, videoAdPlayerUI.fiJ, videoAdPlayerUI.fiK, videoAdPlayerUI.thumbUrl, videoAdPlayerUI.thumbPath, videoAdPlayerUI.rEj, videoAdPlayerUI.rEf, videoAdPlayerUI.rEg, videoAdPlayerUI.cMn);
        clVar.cvA.activity = videoAdPlayerUI;
        clVar.cvA.cvH = 24;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        if (clVar.cvB.ret == 0 && videoAdPlayerUI.rEi != 0) {
            j.a(j.c.Fav, videoAdPlayerUI.rEg, videoAdPlayerUI.rEf, videoAdPlayerUI.rEh, videoAdPlayerUI.rEi, videoAdPlayerUI.rEj, videoAdPlayerUI.rEk, videoAdPlayerUI.rEl, videoAdPlayerUI.rEm, videoAdPlayerUI.rEn, videoAdPlayerUI.rEo, 0);
        }
        if (videoAdPlayerUI.qFG) {
            i.a(new SnsAdClick(0, 6, videoAdPlayerUI.ros.field_snsId, 11, 0));
        }
        if (videoAdPlayerUI.rEt != 0) {
            int i = videoAdPlayerUI.rwL.qEs.qFq;
            if (videoAdPlayerUI.isPlaying && videoAdPlayerUI.rwL.qEs.qFu != 0) {
                i += (int) (bo.az(videoAdPlayerUI.rwL.qEs.qFu) / 1000);
            }
            m iVar = new com.tencent.mm.modelstat.i(13228, "1,5," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + bo.anT() + "," + videoAdPlayerUI.rEs + "," + videoAdPlayerUI.rEd, (int) bo.anT());
            g.RQ();
            g.RO().eJo.a(iVar, 0);
        }
        AppMethodBeat.o(39929);
    }
}
