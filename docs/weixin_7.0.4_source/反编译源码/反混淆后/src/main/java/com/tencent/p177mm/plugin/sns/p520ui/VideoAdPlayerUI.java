package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.modelstat.C42221i;
import com.tencent.p177mm.p181af.C32225q.C25748a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C6893ad;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.sight.decode.p512ui.AdVideoPlayerLoadingBar;
import com.tencent.p177mm.plugin.sight.decode.p512ui.VideoPlayView;
import com.tencent.p177mm.plugin.sight.decode.p512ui.VideoPlayView.C13332a;
import com.tencent.p177mm.plugin.sight.decode.p512ui.VideoPlayView.C218475;
import com.tencent.p177mm.plugin.sight.decode.p512ui.VideoPlayView.C290186;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C39731e;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.C43558b.C13424a;
import com.tencent.p177mm.plugin.sns.model.C43558b.C43559b;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C13354a;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34928c;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j.C34930b;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C3863h;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C39726d;
import com.tencent.p177mm.plugin.sns.p514a.p515b.p1501a.C34926a;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI */
public class VideoAdPlayerUI extends MMActivity implements C13424a, C43559b {
    private String bssid;
    private String cHr = "";
    private String cMn;
    private String ePJ = "";
    private String fiJ = "";
    private String fiK = "";
    private String hnw = "";
    private C42192d iaf;
    private boolean isPlaying = false;
    private boolean qFG = false;
    private String qWO = "";
    private VideoPlayView rEa;
    private C37952b rEb = null;
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
    private C46236n ros;
    private C3863h rwL = new C3863h("VideoAdPlayerUI");
    private String ssid;
    private String thumbPath = "";
    private String thumbUrl = "";
    private String url = "";

    /* renamed from: com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI$4 */
    class C78874 implements OnClickListener {
        C78874() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39916);
            if (VideoAdPlayerUI.this.rEi != 0) {
                C34927j.m57340a(C13354a.DetailInVideo, VideoAdPlayerUI.this.rEg, VideoAdPlayerUI.this.rEf, VideoAdPlayerUI.this.rEh, VideoAdPlayerUI.this.rEi, VideoAdPlayerUI.this.rEj, VideoAdPlayerUI.this.rEk, VideoAdPlayerUI.this.rEl, VideoAdPlayerUI.this.rEm, VideoAdPlayerUI.this.rEn, VideoAdPlayerUI.this.rEo);
            }
            if (VideoAdPlayerUI.this.rEt != 0) {
                int i = VideoAdPlayerUI.this.rwL.qEs.qFq;
                if (VideoAdPlayerUI.this.isPlaying && VideoAdPlayerUI.this.rwL.qEs.qFu != 0) {
                    i += (int) (C5046bo.m7525az(VideoAdPlayerUI.this.rwL.qEs.qFu) / 1000);
                }
                C1207m c42221i = new C42221i(13228, "1,1," + i + "," + VideoAdPlayerUI.this.ssid + "," + VideoAdPlayerUI.this.bssid + "," + C5046bo.anT() + "," + VideoAdPlayerUI.this.rEs + "," + VideoAdPlayerUI.this.rEd, (int) C5046bo.anT());
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c42221i, 0);
            }
            VideoAdPlayerUI.this.finish();
            final Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("key_snsad_statextstr", VideoAdPlayerUI.this.cMn);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", VideoAdPlayerUI.this.fiK);
            intent.putExtra("useJs", true);
            if (VideoAdPlayerUI.this.qFG) {
                C29036i.m46098a(new SnsAdClick(0, 6, VideoAdPlayerUI.this.ros.field_snsId, 18, 0));
            }
            new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(39915);
                    C24826a.gkE.mo38924i(intent, VideoAdPlayerUI.this);
                    AppMethodBeat.m2505o(39915);
                }
            });
            AppMethodBeat.m2505o(39916);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI$2 */
    class C78892 implements OnClickListener {
        C78892() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39912);
            VideoAdPlayerUI.this.finish();
            AppMethodBeat.m2505o(39912);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI$1 */
    class C78901 implements C13332a {
        C78901() {
        }

        /* renamed from: kC */
        public final void mo17720kC(boolean z) {
            AppMethodBeat.m2504i(39907);
            if (z) {
                VideoAdPlayerUI.this.rwL.qEs.qFt = VideoAdPlayerUI.this.getResources().getConfiguration().orientation == 2 ? 2 : 1;
                VideoAdPlayerUI.this.rwL.qEs.qFu = C5046bo.m7588yz();
                VideoAdPlayerUI.this.rwL.qEs.qFs = 2;
                VideoAdPlayerUI.this.rwL.qEs.qFq = 0;
            }
            if (!VideoAdPlayerUI.this.isPlaying && ((int) VideoAdPlayerUI.this.rEa.getLastProgresstime()) == 0) {
                C34926a c34926a = VideoAdPlayerUI.this.rwL.qEs;
                c34926a.qFo++;
            }
            VideoAdPlayerUI.this.rwL.qEs.qFu = C5046bo.m7588yz();
            VideoAdPlayerUI.this.iaf.mo67732a(VideoAdPlayerUI.this.rEa);
            if (VideoAdPlayerUI.this.rEt != 0) {
                C1207m c42221i = new C42221i(13227, "1,1,0," + VideoAdPlayerUI.this.ssid + "," + VideoAdPlayerUI.this.bssid + "," + C5046bo.anT() + "," + VideoAdPlayerUI.this.rEs + "," + VideoAdPlayerUI.this.rEd, (int) C5046bo.anT());
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c42221i, 0);
            }
            VideoAdPlayerUI.this.isPlaying = true;
            AppMethodBeat.m2505o(39907);
        }

        public final void clr() {
            AppMethodBeat.m2504i(39908);
            VideoAdPlayerUI.this.iaf.mo67733cy(false);
            C34926a c34926a = VideoAdPlayerUI.this.rwL.qEs;
            c34926a.qFq += (int) C5046bo.m7525az(VideoAdPlayerUI.this.rwL.qEs.qFu);
            VideoAdPlayerUI.this.isPlaying = false;
            AppMethodBeat.m2505o(39908);
        }

        public final void cls() {
            AppMethodBeat.m2504i(39909);
            C4990ab.m7416i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
            C34926a c34926a = VideoAdPlayerUI.this.rwL.qEs;
            c34926a.qFp++;
            VideoAdPlayerUI.this.isPlaying = false;
            if (VideoAdPlayerUI.this.rEt != 0) {
                C1207m c42221i = new C42221i(13227, "1,2," + VideoAdPlayerUI.this.rEd + "," + VideoAdPlayerUI.this.ssid + "," + VideoAdPlayerUI.this.bssid + "," + C5046bo.anT() + "," + VideoAdPlayerUI.this.rEs + "," + VideoAdPlayerUI.this.rEd, (int) C5046bo.anT());
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c42221i, 0);
            }
            AppMethodBeat.m2505o(39909);
        }

        public final void clt() {
            AppMethodBeat.m2504i(39910);
            C4990ab.m7416i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
            VideoAdPlayerUI.this.isPlaying = false;
            VideoAdPlayerUI.this.rEa.clo();
            AppMethodBeat.m2505o(39910);
        }

        /* renamed from: CG */
        public final void mo17716CG(int i) {
            AppMethodBeat.m2504i(39911);
            if (VideoAdPlayerUI.this.rEd == 0) {
                VideoAdPlayerUI.this.rEd = i;
                VideoAdPlayerUI.this.rEr.rEd = i;
            }
            AppMethodBeat.m2505o(39911);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI$3 */
    class C78913 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI$3$1 */
        class C78921 implements C30391c {
            C78921() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(39913);
                switch (i) {
                    case 0:
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("select_is_ret", true);
                        intent.putExtra("mutil_select_is_ret", true);
                        intent.putExtra("ad_video_title", VideoAdPlayerUI.this.rEe);
                        intent.putExtra("Retr_Msg_Type", 2);
                        C25985d.m41466b(VideoAdPlayerUI.this, ".ui.transmit.SelectConversationUI", intent, 4097);
                        AppMethodBeat.m2505o(39913);
                        return;
                    case 1:
                        VideoAdPlayerUI.m14022o(VideoAdPlayerUI.this);
                        AppMethodBeat.m2505o(39913);
                        return;
                    case 2:
                        VideoAdPlayerUI.m14023p(VideoAdPlayerUI.this);
                        break;
                }
                AppMethodBeat.m2505o(39913);
            }
        }

        C78913() {
        }

        public final void onClick(View view) {
            String[] l;
            AppMethodBeat.m2504i(39914);
            Context context = VideoAdPlayerUI.this;
            if (VideoAdPlayerUI.this.rEp) {
                l = VideoAdPlayerUI.this.rEv;
            } else {
                l = VideoAdPlayerUI.this.rEu;
            }
            C30379h.m48422a(context, null, l, null, new C78921());
            AppMethodBeat.m2505o(39914);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VideoAdPlayerUI() {
        AppMethodBeat.m2504i(39917);
        AppMethodBeat.m2505o(39917);
    }

    public void onCreate(Bundle bundle) {
        String fZ;
        AppMethodBeat.m2504i(39918);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (C5222ae.m7950hD(this.mController.ylL)) {
            this.mController.mo11249xE(getResources().getColor(C25738R.color.f11695dt));
        }
        this.rEu = new String[]{getString(C25738R.string.ejf), getString(C25738R.string.ejg), getString(C25738R.string.eje)};
        this.rEv = new String[]{getString(C25738R.string.ejf), getString(C25738R.string.ejg)};
        this.ros = C13373af.cnF().mo62917YS(C29036i.m46094Xq(getIntent().getStringExtra("KSta_SnSId")));
        this.iaf = new C42192d();
        this.rEb = C37952b.m64173u(getIntent());
        this.ePJ = getIntent().getStringExtra("KFullVideoPath");
        this.rEc = getIntent().getStringExtra("KStremVideoUrl");
        this.thumbUrl = getIntent().getStringExtra("KThumUrl");
        this.cHr = getIntent().getStringExtra("KMediaId");
        this.qFG = getIntent().getBooleanExtra("IsAd", false);
        this.url = getIntent().getStringExtra("KUrl");
        this.rEe = C5046bo.m7532bc(getIntent().getStringExtra("KMediaTitle"), "");
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
        this.hnw = C5046bo.m7532bc(getIntent().getStringExtra("KViewId"), "");
        this.rEs = C5046bo.m7532bc(getIntent().getStringExtra("ReportArgs"), "");
        this.rEt = getIntent().getIntExtra("NeedReportData", 0);
        if (this.rEt != 0) {
            this.ssid = C5023at.m7474gE(C4996ah.getContext());
            this.bssid = C5023at.m7475gF(C4996ah.getContext());
        }
        this.rEr = new bau();
        this.rEr.wEH = this.thumbUrl;
        this.rEr.wEO = this.rEc;
        this.rEr.f17915Id = this.cHr;
        this.rEr.Url = this.url;
        this.rEr.wEG = 1;
        this.rEr.rEd = this.rEd;
        this.rwL.qEm = C5046bo.m7588yz();
        C4990ab.m7416i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.rEr.f17915Id + " attachurl:" + this.rEr.wEO + " videoattachTotalTime:" + this.rEr.rEd + " streamvideowording: " + this.fiJ + " streamvideoweburl: " + this.fiK + " mediaTitle: " + this.rEe + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.rEf + " streamvideopublishid " + this.rEg);
        if (C5046bo.isNullOrNil(this.ePJ)) {
            fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), this.rEr.f17915Id);
            this.ePJ = fZ + C29036i.m46119k(this.rEr);
        }
        if (C5046bo.isNullOrNil(this.thumbPath) || !C5730e.m8628ct(this.thumbPath)) {
            fZ = "attach" + this.rEr.f17915Id;
            this.thumbPath = C3892an.m6198fZ(C13373af.getAccSnsPath(), fZ) + C29036i.m46078Xa(fZ);
        }
        if (!C5730e.m8628ct(this.thumbPath)) {
            try {
                bau bau = new bau();
                bau.parseFrom(this.rEr.toByteArray());
                bau.f17915Id = "attach" + bau.f17915Id;
                C39731e c39731e = new C39731e(this.rEr);
                c39731e.qFQ = 1;
                c39731e.nQB = this.rEr.f17915Id;
                C13373af.cnA().mo69138a(bau, 7, c39731e, C44222az.xYU);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.VideoPlayerUI", "error for download thumb");
            }
            getWindow().addFlags(128);
        }
        this.rEa = (VideoPlayView) findViewById(2131828417);
        VideoPlayView videoPlayView = this.rEa;
        AdVideoPlayerLoadingBar adVideoPlayerLoadingBar = new AdVideoPlayerLoadingBar(this.mController.ylL);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = videoPlayView.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9970lu);
        videoPlayView.qzc = adVideoPlayerLoadingBar;
        videoPlayView.klq.setPlayProgressCallback(true);
        videoPlayView.addView((View) videoPlayView.qzc, layoutParams);
        videoPlayView.qzc.setIplaySeekCallback(new C218475());
        videoPlayView.qzc.setOnPlayButtonClickListener(new C290186());
        videoPlayView.qzc.setIsPlay(videoPlayView.klq.isPlaying());
        if (videoPlayView.qzc != null) {
            ((View) videoPlayView.qzc).setVisibility(8);
        }
        adVideoPlayerLoadingBar.seek(0);
        this.rEa.setVideoPlayViewEvent(new C78901());
        this.rEa.setVideoTotalTime(this.rEr.rEd);
        if (C5730e.m8628ct(this.ePJ)) {
            this.rwL.qEk = 1;
            this.rEa.setVideoPath(this.ePJ);
        } else {
            this.rEa.clo();
            this.rEa.setIsDownloading(true);
            C13373af.cnA().mo69138a(this.rEr, 6, null, C44222az.xYU);
        }
        this.rEa.setLeftButtonOnClickListener(new C78892());
        this.rEa.setRightButtonOnCliclListener(new C78913());
        VideoPlayView videoPlayView2 = this.rEa;
        String str = this.fiJ;
        C78874 c78874 = new C78874();
        videoPlayView2.qzf = str;
        videoPlayView2.qze.setText(str);
        videoPlayView2.qze.setOnClickListener(c78874);
        this.rEa.clq();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0) {
            videoPlayView2 = this.rEa;
            if (videoPlayView2.qzh != null) {
                videoPlayView2.qzi = false;
                videoPlayView2.qzh.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(39918);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(39919);
        C4990ab.m7417i("MicroMsg.VideoPlayerUI", "onActivityResult %d", Integer.valueOf(i));
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : C5046bo.m7508P(stringExtra.split(","))) {
                    C4990ab.m7417i("MicroMsg.VideoPlayerUI", "send sight to %s", str);
                    C8910b c8910b = new C8910b();
                    c8910b.title = this.rEe;
                    c8910b.type = 4;
                    if (C5046bo.isNullOrNil(this.rEr.Url)) {
                        c8910b.url = this.rEr.wEO;
                    } else {
                        c8910b.url = this.rEr.Url;
                    }
                    if (C5046bo.isNullOrNil(this.rEr.wER)) {
                        stringExtra = this.rEr.wEH;
                    } else {
                        stringExtra = this.rEr.wER;
                    }
                    c8910b.thumburl = stringExtra;
                    c8910b.fiG = this.rEr.wEO;
                    c8910b.fiH = this.rEr.rEd;
                    c8910b.fiI = this.rEe;
                    c8910b.fiK = this.fiK;
                    c8910b.fiJ = this.fiJ;
                    c8910b.fiL = this.thumbUrl;
                    c8910b.fiM = this.rEf;
                    c8910b.fiN = this.rEg;
                    c8910b.cMn = this.cMn;
                    byte[] e = C5730e.m8632e(this.thumbPath, 0, -1);
                    String str2 = "MicroMsg.VideoPlayerUI";
                    String str3 = "read buf size %d";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(e == null ? 0 : e.length);
                    C4990ab.m7417i(str2, str3, objArr);
                    if (C25748a.m40880XD() != null) {
                        C25748a.m40880XD().mo30686a(c8910b, "", "", str, "", e);
                    }
                    if (this.rEt != 0) {
                        int i3 = this.rwL.qEs.qFq;
                        if (this.isPlaying && this.rwL.qEs.qFu != 0) {
                            i3 += (int) (C5046bo.m7525az(this.rwL.qEs.qFu) / 1000);
                        }
                        C1207m c42221i = new C42221i(13228, "1,3," + i3 + "," + this.ssid + "," + this.bssid + "," + C5046bo.anT() + "," + this.rEs + "," + this.rEd, (int) C5046bo.anT());
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(c42221i, 0);
                    }
                    C12519g.bOk().mo46461eZ(stringExtra2, str);
                    if (this.qFG) {
                        C29036i.m46098a(new SnsAdClick(0, 6, this.ros.field_snsId, 12, 0));
                    }
                    if (this.rEi != 0) {
                        C34928c c34928c;
                        int mA;
                        boolean kH = C1855t.m3896kH(str);
                        if (kH) {
                            c34928c = C34928c.Chatroom;
                        } else {
                            c34928c = C34928c.Chat;
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
                            mA = C37921n.m64060mA(str);
                        } else {
                            mA = 0;
                        }
                        C34927j.m57342a(c34928c, str4, str2, i4, i5, str5, str6, str7, j, i6, i7, mA);
                    }
                }
                C5670b.m8523i(this, getString(C25738R.string.cbn));
            } else if (this.qFG) {
                C29036i.m46098a(new SnsAdClick(0, 6, this.ros.field_snsId, 13, 0));
            }
        }
        if (4098 == i) {
            if (this.rEi != 0) {
                C34927j.m57342a(C34928c.Sns, this.rEg, this.rEf, this.rEh, this.rEi, this.rEj, this.rEk, this.rEl, this.rEm, this.rEn, this.rEo, 0);
            }
            if (-1 == i2) {
                if (this.qFG) {
                    C29036i.m46098a(new SnsAdClick(0, 6, this.ros.field_snsId, 15, 0));
                }
            } else if (this.qFG) {
                C29036i.m46098a(new SnsAdClick(0, 6, this.ros.field_snsId, 16, 0));
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(39919);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(39920);
        super.onDestroy();
        getWindow().clearFlags(128);
        if (this.rEi != 0) {
            C34927j.m57340a(C13354a.LeaveCompleteVideo, this.rEg, this.rEf, this.rEh, this.rEi, this.rEj, this.rEk, this.rEl, this.rEm, this.rEn, this.rEo);
        }
        if (this.qFG) {
            int cre = this.ros == null ? 0 : this.ros.cre();
            if (this.ros != null) {
                String cmf = this.rwL.cmf();
                long j = ((long) this.rwL.qEl) - this.rwL.fQe;
                if (j < 0) {
                    C4990ab.m7413e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", Integer.valueOf(this.rwL.qEl), Long.valueOf(this.rwL.fQe));
                    j = (long) this.rwL.qEl;
                }
                int i = (int) j;
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C39726d(this.hnw, 6, 2, this.rwL.qEl, null, null, 2, cmf, -1, cre, i, i, 0, this.ros.crd().cqw(), this.ros.crd().cqx()), 0);
            }
        }
        if (this.rEt != 0) {
            int i2 = this.rwL.qEs.qFq;
            if (this.isPlaying && this.rwL.qEs.qFu != 0) {
                i2 += (int) (C5046bo.m7525az(this.rwL.qEs.qFu) / 1000);
            }
            C1207m c42221i = new C42221i(13228, "1,2," + i2 + "," + this.ssid + "," + this.bssid + "," + C5046bo.anT() + "," + this.rEs + "," + this.rEd, (int) C5046bo.anT());
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c42221i, 0);
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", dyi()));
        AppMethodBeat.m2505o(39920);
    }

    public void finish() {
        AppMethodBeat.m2504i(39921);
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
        AppMethodBeat.m2505o(39921);
    }

    public void onPause() {
        AppMethodBeat.m2504i(39922);
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        C4990ab.m7416i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i)));
        m14005Ef(i);
        if (this.rEa != null && this.rEa.isPlaying()) {
            this.rEa.pause();
        }
        if (this.rEa != null) {
            C4990ab.m7416i("MicroMsg.VideoPlayerUI", "onDetach");
            this.rEa.onDetach();
        }
        C13373af.cnA().qHK.remove(this);
        C13373af.cnA().mo69142b((C43559b) this);
        if (this.rwL != null) {
            this.rwL.fQd = C5046bo.m7588yz();
        }
        AppMethodBeat.m2505o(39922);
    }

    public void onResume() {
        AppMethodBeat.m2504i(39923);
        super.onResume();
        C13373af.cnA().qHK.add(this);
        C13373af.cnA().mo69136a((C43559b) this);
        if (this.rwL != null) {
            this.rwL.onResume();
        }
        AppMethodBeat.m2505o(39923);
    }

    public final int getLayoutId() {
        return 2130970992;
    }

    /* renamed from: fW */
    public final void mo17712fW(String str, String str2) {
        AppMethodBeat.m2504i(39924);
        C4990ab.m7416i("MicroMsg.VideoPlayerUI", "isPlaying " + this.rEa.isPlaying());
        if (this.rEa.isPlaying()) {
            AppMethodBeat.m2505o(39924);
            return;
        }
        this.rEa.setLoop(false);
        if (str2.equals(this.rEa.getVideoPath())) {
            this.rEa.mo9052B(this.rEa.getLastProgresstime());
            this.rEa.start();
            C4990ab.m7416i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + str + " path: " + str2);
            AppMethodBeat.m2505o(39924);
            return;
        }
        this.rEa.setVideoPath(str2);
        this.rEa.mo9052B(this.rEa.getLastProgresstime());
        C4990ab.m7416i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + str + " path: " + str2);
        AppMethodBeat.m2505o(39924);
    }

    /* renamed from: Xw */
    public final void mo17655Xw(String str) {
    }

    /* renamed from: bj */
    public final void mo8771bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    /* renamed from: bk */
    public final void mo8772bk(String str, boolean z) {
        AppMethodBeat.m2504i(39925);
        C4990ab.m7416i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(str)));
        this.rEa.setIsDownloading(false);
        this.rEa.setVideoPath(this.ePJ);
        this.rEa.mo9052B(this.rEa.getLastProgresstime());
        this.rEa.setLoop(false);
        if (this.qFG && !C5046bo.isNullOrNil(str) && this.rEr != null && str.equals(this.rEr.f17915Id) && C5730e.m8628ct(this.ePJ)) {
            this.rwL.qEk = 1;
        }
        AppMethodBeat.m2505o(39925);
    }

    public final int getForceOrientation() {
        if (this.rEq) {
            return 0;
        }
        return 4;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(39926);
        super.onConfigurationChanged(configuration);
        VideoPlayView videoPlayView = this.rEa;
        C4990ab.m7416i("MicroMsg.VideoPlayView", "onConfigurationChanged " + configuration.orientation + " " + videoPlayView.qzr);
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
        m14005Ef(configuration.orientation);
        AppMethodBeat.m2505o(39926);
    }

    /* renamed from: Ef */
    private void m14005Ef(int i) {
        AppMethodBeat.m2504i(39927);
        if (this.qFG) {
            this.rwL.mo8566CI(this.rEa.getDuration());
            this.rwL.qEs.qFu = C5046bo.m7588yz();
            this.rwL.qEs.qFt = i == 2 ? 2 : 1;
            this.rwL.qEs.qFs = 2;
            C4990ab.m7416i("MicroMsg.VideoPlayerUI", "duration  orient " + this.rwL.qEs.qFt);
            AppMethodBeat.m2505o(39927);
            return;
        }
        AppMethodBeat.m2505o(39927);
    }

    /* renamed from: o */
    static /* synthetic */ void m14022o(VideoAdPlayerUI videoAdPlayerUI) {
        AppMethodBeat.m2504i(39928);
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
        if (videoAdPlayerUI.rEi == C34930b.Sight.value || videoAdPlayerUI.rEi == C34930b.AdUrl.value) {
            str = "sns_" + videoAdPlayerUI.rEl;
        } else if (videoAdPlayerUI.rEi == C34930b.Chat.value || videoAdPlayerUI.rEi == C34930b.TalkChat.value) {
            str = "msg_" + videoAdPlayerUI.rEm;
        } else if (videoAdPlayerUI.rEi == C34930b.Fav.value) {
            str = "fav_" + C1853r.m3846Yz() + "_" + videoAdPlayerUI.rEn;
        }
        String nW = C37922v.m64078nW(str);
        C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", str);
        intent.putExtra("reportSessionId", nW);
        C25985d.m41468b((Context) videoAdPlayerUI, "sns", ".ui.SnsUploadUI", intent, 4098);
        if (videoAdPlayerUI.rEt != 0) {
            int i = videoAdPlayerUI.rwL.qEs.qFq;
            if (videoAdPlayerUI.isPlaying && videoAdPlayerUI.rwL.qEs.qFu != 0) {
                i += (int) (C5046bo.m7525az(videoAdPlayerUI.rwL.qEs.qFu) / 1000);
            }
            C1207m c42221i = new C42221i(13228, "1,4," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + C5046bo.anT() + "," + videoAdPlayerUI.rEs + "," + videoAdPlayerUI.rEd, (int) C5046bo.anT());
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c42221i, 0);
        }
        AppMethodBeat.m2505o(39928);
    }

    /* renamed from: p */
    static /* synthetic */ void m14023p(VideoAdPlayerUI videoAdPlayerUI) {
        AppMethodBeat.m2504i(39929);
        C45316cl c45316cl = new C45316cl();
        ((C6893ad) C1720g.m3528K(C6893ad.class)).mo15152a(c45316cl, videoAdPlayerUI.rEr.rEd, videoAdPlayerUI.rEe, "", videoAdPlayerUI.rEr.wEO, videoAdPlayerUI.fiJ, videoAdPlayerUI.fiK, videoAdPlayerUI.thumbUrl, videoAdPlayerUI.thumbPath, videoAdPlayerUI.rEj, videoAdPlayerUI.rEf, videoAdPlayerUI.rEg, videoAdPlayerUI.cMn);
        c45316cl.cvA.activity = videoAdPlayerUI;
        c45316cl.cvA.cvH = 24;
        C4879a.xxA.mo10055m(c45316cl);
        if (c45316cl.cvB.ret == 0 && videoAdPlayerUI.rEi != 0) {
            C34927j.m57342a(C34928c.Fav, videoAdPlayerUI.rEg, videoAdPlayerUI.rEf, videoAdPlayerUI.rEh, videoAdPlayerUI.rEi, videoAdPlayerUI.rEj, videoAdPlayerUI.rEk, videoAdPlayerUI.rEl, videoAdPlayerUI.rEm, videoAdPlayerUI.rEn, videoAdPlayerUI.rEo, 0);
        }
        if (videoAdPlayerUI.qFG) {
            C29036i.m46098a(new SnsAdClick(0, 6, videoAdPlayerUI.ros.field_snsId, 11, 0));
        }
        if (videoAdPlayerUI.rEt != 0) {
            int i = videoAdPlayerUI.rwL.qEs.qFq;
            if (videoAdPlayerUI.isPlaying && videoAdPlayerUI.rwL.qEs.qFu != 0) {
                i += (int) (C5046bo.m7525az(videoAdPlayerUI.rwL.qEs.qFu) / 1000);
            }
            C1207m c42221i = new C42221i(13228, "1,5," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + C5046bo.anT() + "," + videoAdPlayerUI.rEs + "," + videoAdPlayerUI.rEd, (int) C5046bo.anT());
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c42221i, 0);
        }
        AppMethodBeat.m2505o(39929);
    }
}
