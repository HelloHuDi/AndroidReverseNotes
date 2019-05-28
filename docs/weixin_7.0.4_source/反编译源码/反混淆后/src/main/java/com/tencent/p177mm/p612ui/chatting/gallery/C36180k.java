package com.tencent.p177mm.p612ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.graphics.p1191a.C18491c;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.base.WxImageView;
import com.tencent.p177mm.p612ui.chatting.C40707a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40705a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40708b;
import com.tencent.p177mm.p612ui.chatting.gallery.C40775c.C40774b;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C46510q;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoTextureView;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ui.chatting.gallery.k */
public final class C36180k {
    String cEV = "";
    long createTime;
    String fileId;
    public int mPosition;
    public View mRR;
    public TextView mlK;
    int rbG = 0;
    public C40775c yUe;
    public ImageView yXA;
    public MultiTouchImageView yXB;
    public WxImageView yXC;
    public MultiTouchImageView yXD;
    public boolean yXE;
    int yXF = 0;
    int yXG = 0;
    public C40774b yXe;
    public HashMap<String, Boolean> yXf = new HashMap();
    public RelativeLayout yXg;
    public C14979e yXh;
    public ImageView yXi;
    public ImageView yXj;
    public MMPinProgressBtn yXk;
    public View yXl;
    public RelativeLayout yXm;
    public ImageView yXn;
    public ImageView yXo;
    public C14979e yXp;
    public MMPinProgressBtn yXq;
    public TextView yXr;
    public LinearLayout yXs;
    public TextView yXt;
    public TextView yXu;
    public ImageView yXv;
    public ProgressBar yXw;
    public ProgressBar yXx;
    public LinearLayout yXy;
    public TextView yXz;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.k$5 */
    static /* synthetic */ class C237815 {
        static final /* synthetic */ int[] yTX = new int[C40774b.values().length];

        static {
            AppMethodBeat.m2504i(32391);
            try {
                yTX[C40774b.image.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                yTX[C40774b.video.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                yTX[C40774b.sight.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                yTX[C40774b.unkown.ordinal()] = 4;
                AppMethodBeat.m2505o(32391);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.m2505o(32391);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.k$2 */
    class C361812 implements OnClickListener {
        C361812() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(32383);
            if (view.getTag() != null && (view.getTag() instanceof C7620bi)) {
                C7620bi c7620bi = (C7620bi) view.getTag();
                C40707a.m70378a(C40705a.EnterCompleteVideo, c7620bi);
                C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
                cfh cfh = ut.fXm;
                if (cfh != null && !C42252ah.isNullOrNil(cfh.fiG)) {
                    int i;
                    C37961o.all();
                    String ui = C9720t.m17304ui(c7620bi.field_imgPath);
                    Intent intent = new Intent();
                    intent.putExtra("IsAd", false);
                    intent.putExtra("KStremVideoUrl", cfh.fiG);
                    intent.putExtra("KThumUrl", cfh.fiL);
                    intent.putExtra("KThumbPath", ui);
                    intent.putExtra("KMediaId", "fakeid_" + c7620bi.field_msgId);
                    intent.putExtra("KMediaVideoTime", cfh.wid);
                    intent.putExtra("KMediaTitle", cfh.fiI);
                    intent.putExtra("StreamWording", cfh.fiJ);
                    intent.putExtra("StremWebUrl", cfh.fiK);
                    String str = c7620bi.field_talker;
                    boolean kH = C1855t.m3896kH(str);
                    ui = kH ? C1829bf.m3762oy(c7620bi.field_content) : str;
                    intent.putExtra("KSta_StremVideoAduxInfo", cfh.fiM);
                    intent.putExtra("KSta_StremVideoPublishId", cfh.fiN);
                    intent.putExtra("KSta_SourceType", 1);
                    String str2 = "KSta_Scene";
                    if (kH) {
                        i = C40708b.TalkChat.value;
                    } else {
                        i = C40708b.Chat.value;
                    }
                    intent.putExtra(str2, i);
                    intent.putExtra("KSta_FromUserName", ui);
                    intent.putExtra("KSta_ChatName", str);
                    intent.putExtra("KSta_MsgId", c7620bi.field_msgSvrId);
                    intent.putExtra("KSta_SnsStatExtStr", ut.cMn);
                    if (kH) {
                        intent.putExtra("KSta_ChatroomMembercount", C37921n.m64060mA(str));
                    }
                    C25985d.m41467b(C36180k.this.yUe.yTI.mController.ylL, "sns", ".ui.VideoAdPlayerUI", intent);
                    AppMethodBeat.m2505o(32383);
                    return;
                } else if (!(cfh == null || C5046bo.isNullOrNil(cfh.fiJ) || C5046bo.isNullOrNil(cfh.fiK))) {
                    C4990ab.m7416i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + cfh.fiK);
                    final Intent intent2 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("key_snsad_statextstr", ut.cMn);
                    intent2.putExtra("jsapiargs", bundle);
                    intent2.putExtra("rawUrl", cfh.fiK);
                    intent2.putExtra("useJs", true);
                    new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(32382);
                            C25985d.m41467b(C36180k.this.yUe.yTI.mController.ylL, "webview", ".ui.tools.WebViewUI", intent2);
                            AppMethodBeat.m2505o(32382);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(32383);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.k$4 */
    class C361834 implements C14981a {

        /* renamed from: com.tencent.mm.ui.chatting.gallery.k$4$1 */
        class C156831 implements Runnable {
            C156831() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32385);
                C36180k.this.yUe.yTI.mo64299qx(true);
                C40775c c40775c = C36180k.this.yUe;
                c40775c.yTO.mo27896Pf(C36180k.this.mPosition);
                C36180k.this.yUe.yTO.dGA();
                AppMethodBeat.m2505o(32385);
            }
        }

        C361834() {
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(32387);
            if (C36180k.this.yUe != null) {
                C36180k.this.yUe.yTO.dGz();
            }
            AppMethodBeat.m2505o(32387);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(32388);
            C4990ab.m7420w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + i + " extra: " + i2);
            if (C36180k.this.yUe != null) {
                C36180k.this.yUe.yTO.mo27910hp(i, i2);
            }
            C7060h.pYm.mo8381e(12084, Integer.valueOf(C36180k.this.yXF), Integer.valueOf(C36180k.this.rbG * 1000), Integer.valueOf(0), Integer.valueOf(4), C36180k.this.cEV, Integer.valueOf(C36180k.this.yXG), C36180k.this.fileId, Long.valueOf(C36180k.this.createTime));
            AppMethodBeat.m2505o(32388);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(32389);
            C5004al.m7441d(new C156831());
            AppMethodBeat.m2505o(32389);
        }

        /* renamed from: dG */
        public final int mo8554dG(final int i, final int i2) {
            AppMethodBeat.m2504i(32390);
            C4990ab.m7417i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", Integer.valueOf(i), Integer.valueOf(C36180k.this.rbG), Integer.valueOf(i2), Integer.valueOf(C36180k.this.yXF), Integer.valueOf(C36180k.this.yXG), C36180k.this.cEV);
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(32386);
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[8];
                    objArr[0] = Integer.valueOf(C36180k.this.yXF);
                    objArr[1] = Integer.valueOf(i2 <= 0 ? C36180k.this.rbG * 1000 : i2);
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(1);
                    objArr[4] = C36180k.this.cEV;
                    objArr[5] = Integer.valueOf(C36180k.this.yXG);
                    objArr[6] = C36180k.this.fileId;
                    objArr[7] = Long.valueOf(C36180k.this.createTime);
                    c7060h.mo8381e(12084, objArr);
                    AppMethodBeat.m2505o(32386);
                }
            });
            AppMethodBeat.m2505o(32390);
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.k$1 */
    class C361851 implements C14981a {

        /* renamed from: com.tencent.mm.ui.chatting.gallery.k$1$2 */
        class C361872 implements Runnable {
            C361872() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32379);
                if (C36180k.this.yXl == null || C36180k.this.yXl.getVisibility() == 0) {
                    AppMethodBeat.m2505o(32379);
                    return;
                }
                if (C36180k.this.yXl.getTag() != null && (C36180k.this.yXl.getTag() instanceof C26493s)) {
                    C26493s c26493s = (C26493s) C36180k.this.yXl.getTag();
                    if (c26493s.fXm != null && !C5046bo.isNullOrNil(c26493s.fXm.fiG)) {
                        C36180k.this.yXl.setVisibility(8);
                        AppMethodBeat.m2505o(32379);
                        return;
                    } else if (!(c26493s.fXm == null || C5046bo.isNullOrNil(c26493s.fXm.fiJ) || C5046bo.isNullOrNil(c26493s.fXm.fiK))) {
                        C36180k.this.yXl.setVisibility(8);
                        AppMethodBeat.m2505o(32379);
                        return;
                    }
                }
                C36180k.this.yXl.setVisibility(0);
                C36180k.this.yXl.startAnimation(AnimationUtils.loadAnimation(C36180k.this.yXl.getContext(), C25738R.anim.f8332b5));
                AppMethodBeat.m2505o(32379);
            }
        }

        C361851() {
        }

        /* renamed from: pL */
        public final void mo8557pL() {
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(32380);
            C36180k.this.yXh.stop();
            final String str = (String) ((View) C36180k.this.yXh).getTag();
            C4872b.m7233A(Base64.encodeToString((C21846d.ckW() + "[ImageGallery] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + C5046bo.m7532bc(str, "")).getBytes(), 2), "FullScreenPlaySight");
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(32378);
                    if (C5046bo.isNullOrNil(str)) {
                        C30379h.m48467g(C36180k.this.yUe.yTI, C25738R.string.f1a, C25738R.string.ank);
                        AppMethodBeat.m2505o(32378);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    C15429k.m23713a(C36180k.this.yUe.yTI, intent, new File(str), "video/*");
                    try {
                        C36180k.this.yUe.yTI.startActivity(Intent.createChooser(intent, C36180k.this.yUe.yTI.mController.ylL.getString(C25738R.string.bs9)));
                        AppMethodBeat.m2505o(32378);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                        C30379h.m48467g(C36180k.this.yUe.yTI, C25738R.string.bpq, C25738R.string.bpr);
                        AppMethodBeat.m2505o(32378);
                    }
                }
            });
            C36180k.this.yXf.put(str, Boolean.TRUE);
            AppMethodBeat.m2505o(32380);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(32381);
            C36180k.this.yXh.start();
            C36180k.this.yXl.post(new C361872());
            AppMethodBeat.m2505o(32381);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.k$3 */
    class C361883 implements OnClickListener {
        C361883() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(32384);
            if (C36180k.this.yUe != null) {
                C4990ab.m7417i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", Integer.valueOf(C36180k.this.hashCode()), Integer.valueOf(C36180k.this.mPosition));
                C36180k.this.yUe.mo64307OP(C36180k.this.mPosition);
            }
            AppMethodBeat.m2505o(32384);
        }
    }

    @TargetApi(11)
    public C36180k(C40775c c40775c, View view) {
        AppMethodBeat.m2504i(32392);
        this.mRR = view;
        this.yUe = c40775c;
        this.yXB = (MultiTouchImageView) view.findViewById(2131820629);
        this.yXC = (WxImageView) view.findViewById(2131824980);
        this.yXD = (MultiTouchImageView) view.findViewById(2131824981);
        this.yXx = (ProgressBar) view.findViewById(2131824984);
        if (this.yXC != null) {
            this.yXC.setForceTileFlag(C18491c.Tile);
        }
        if (C1443d.m3068iW(11) && view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
        AppMethodBeat.m2505o(32392);
    }

    /* renamed from: am */
    public static void m59559am(View view, int i) {
        AppMethodBeat.m2504i(32393);
        if (view != null) {
            view.setVisibility(i);
        }
        AppMethodBeat.m2505o(32393);
    }

    public final C36180k dGE() {
        AppMethodBeat.m2504i(32394);
        if (this.yXs == null) {
            this.yXs = (LinearLayout) ((ViewStub) this.mRR.findViewById(2131824982)).inflate();
            this.yXw = (ProgressBar) this.yXs.findViewById(2131822617);
            this.yXt = (TextView) this.yXs.findViewById(2131823911);
            this.yXu = (TextView) this.yXs.findViewById(2131824986);
            this.yXv = (ImageView) this.yXs.findViewById(2131824985);
        }
        AppMethodBeat.m2505o(32394);
        return this;
    }

    public final C36180k dGF() {
        AppMethodBeat.m2504i(32395);
        if (this.yXy == null) {
            this.yXy = (LinearLayout) ((ViewStub) this.mRR.findViewById(2131824983)).inflate();
            this.yXA = (ImageView) this.yXy.findViewById(2131824987);
            this.yXz = (TextView) this.yXy.findViewById(2131823352);
        }
        AppMethodBeat.m2505o(32395);
        return this;
    }

    public final C36180k dGG() {
        AppMethodBeat.m2504i(32396);
        if (this.yXg == null) {
            this.yXg = (RelativeLayout) ((ViewStub) this.mRR.findViewById(2131824979)).inflate();
            this.yXh = C46510q.m87801fT(this.mRR.getContext());
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.yXg.addView((View) this.yXh, layoutParams);
            ((View) this.yXh).setVisibility(8);
            this.yXl = this.yXg.findViewById(2131823800);
            this.yXl.setVisibility(8);
            this.mlK = (TextView) this.yXg.findViewById(2131827573);
            this.yXk = (MMPinProgressBtn) this.yXg.findViewById(2131827547);
            this.yXk.setVisibility(8);
            this.yXi = (ImageView) this.yXg.findViewById(2131827546);
            this.yXj = (ImageView) this.yXg.findViewById(2131827548);
            this.yXh.setVideoCallback(new C361851());
            this.mlK.setOnClickListener(new C361812());
        }
        AppMethodBeat.m2505o(32396);
        return this;
    }

    public final C36180k dGH() {
        AppMethodBeat.m2504i(32397);
        if (this.yXm == null) {
            if (this.yXC != null) {
                this.yXC.setVisibility(8);
            }
            if (this.yXB != null) {
                this.yXB.setVisibility(8);
            }
            this.yXm = (RelativeLayout) ((ViewStub) this.mRR.findViewById(2131822134)).inflate();
            this.yXn = (ImageView) this.yXm.findViewById(2131824989);
            this.yXo = (ImageView) this.yXm.findViewById(2131824990);
            this.yXo.setOnClickListener(new C361883());
            C42204d.afF();
            if (C42204d.afO()) {
                this.yXp = new VideoPlayerTextureView(this.mRR.getContext());
                C7060h.pYm.mo8378a(354, 150, 1, false);
            } else {
                this.yXp = new VideoTextureView(this.mRR.getContext());
                C7060h.pYm.mo8378a(354, 151, 1, false);
            }
            this.yXr = (TextView) this.mRR.findViewById(2131824978);
            this.yXp.setPlayProgressCallback(true);
            this.yXm.addView((View) this.yXp, 2, new LayoutParams(-1, -1));
            this.yXq = (MMPinProgressBtn) this.yXm.findViewById(2131824991);
            this.yXq.setVisibility(8);
            ((View) this.yXp).setVisibility(8);
            this.yXp.setVideoCallback(new C361834());
        }
        AppMethodBeat.m2505o(32397);
        return this;
    }

    /* renamed from: a */
    public final void mo57070a(int i, int i2, int i3, String str, String str2, long j) {
        this.rbG = i;
        this.yXF = i2;
        this.yXG = i3;
        this.cEV = str;
        this.fileId = str2;
        this.createTime = j;
    }

    /* renamed from: a */
    public final void mo57071a(boolean z, float f) {
        AppMethodBeat.m2504i(32398);
        C4990ab.m7417i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Float.valueOf(f));
        if (z) {
            View view = (View) dGH().yXp;
            view.setAlpha(f);
            C36180k.m59559am(view, 0);
            if (((double) f) >= 1.0d) {
                C36180k.m59559am(dGH().yXn, 8);
                C36180k.m59559am(dGH().yXo, 8);
            }
            AppMethodBeat.m2505o(32398);
            return;
        }
        C36180k.m59559am((View) dGH().yXp, 8);
        C36180k.m59559am(dGH().yXn, 0);
        C36180k.m59559am(dGH().yXo, 0);
        AppMethodBeat.m2505o(32398);
    }
}
