package com.tencent.mm.ui.chatting.gallery;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.graphics.a.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.c.b;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.io.File;
import java.util.HashMap;

public final class k {
    String cEV = "";
    long createTime;
    String fileId;
    public int mPosition;
    public View mRR;
    public TextView mlK;
    int rbG = 0;
    public c yUe;
    public ImageView yXA;
    public MultiTouchImageView yXB;
    public WxImageView yXC;
    public MultiTouchImageView yXD;
    public boolean yXE;
    int yXF = 0;
    int yXG = 0;
    public b yXe;
    public HashMap<String, Boolean> yXf = new HashMap();
    public RelativeLayout yXg;
    public e yXh;
    public ImageView yXi;
    public ImageView yXj;
    public MMPinProgressBtn yXk;
    public View yXl;
    public RelativeLayout yXm;
    public ImageView yXn;
    public ImageView yXo;
    public e yXp;
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
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] yTX = new int[b.values().length];

        static {
            AppMethodBeat.i(32391);
            try {
                yTX[b.image.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                yTX[b.video.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                yTX[b.sight.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                yTX[b.unkown.ordinal()] = 4;
                AppMethodBeat.o(32391);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(32391);
            }
        }
    }

    @TargetApi(11)
    public k(c cVar, View view) {
        AppMethodBeat.i(32392);
        this.mRR = view;
        this.yUe = cVar;
        this.yXB = (MultiTouchImageView) view.findViewById(R.id.bl);
        this.yXC = (WxImageView) view.findViewById(R.id.chw);
        this.yXD = (MultiTouchImageView) view.findViewById(R.id.chx);
        this.yXx = (ProgressBar) view.findViewById(R.id.ci0);
        if (this.yXC != null) {
            this.yXC.setForceTileFlag(c.Tile);
        }
        if (d.iW(11) && view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
        AppMethodBeat.o(32392);
    }

    public static void am(View view, int i) {
        AppMethodBeat.i(32393);
        if (view != null) {
            view.setVisibility(i);
        }
        AppMethodBeat.o(32393);
    }

    public final k dGE() {
        AppMethodBeat.i(32394);
        if (this.yXs == null) {
            this.yXs = (LinearLayout) ((ViewStub) this.mRR.findViewById(R.id.chy)).inflate();
            this.yXw = (ProgressBar) this.yXs.findViewById(R.id.as0);
            this.yXt = (TextView) this.yXs.findViewById(R.id.bq0);
            this.yXu = (TextView) this.yXs.findViewById(R.id.ci2);
            this.yXv = (ImageView) this.yXs.findViewById(R.id.ci1);
        }
        AppMethodBeat.o(32394);
        return this;
    }

    public final k dGF() {
        AppMethodBeat.i(32395);
        if (this.yXy == null) {
            this.yXy = (LinearLayout) ((ViewStub) this.mRR.findViewById(R.id.chz)).inflate();
            this.yXA = (ImageView) this.yXy.findViewById(R.id.ci3);
            this.yXz = (TextView) this.yXy.findViewById(R.id.baw);
        }
        AppMethodBeat.o(32395);
        return this;
    }

    public final k dGG() {
        AppMethodBeat.i(32396);
        if (this.yXg == null) {
            this.yXg = (RelativeLayout) ((ViewStub) this.mRR.findViewById(R.id.chv)).inflate();
            this.yXh = q.fT(this.mRR.getContext());
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.yXg.addView((View) this.yXh, layoutParams);
            ((View) this.yXh).setVisibility(8);
            this.yXl = this.yXg.findViewById(R.id.bn0);
            this.yXl.setVisibility(8);
            this.mlK = (TextView) this.yXg.findViewById(R.id.ee0);
            this.yXk = (MMPinProgressBtn) this.yXg.findViewById(R.id.eda);
            this.yXk.setVisibility(8);
            this.yXi = (ImageView) this.yXg.findViewById(R.id.ed_);
            this.yXj = (ImageView) this.yXg.findViewById(R.id.edb);
            this.yXh.setVideoCallback(new a() {
                public final void pL() {
                }

                public final void onError(int i, int i2) {
                    AppMethodBeat.i(32380);
                    k.this.yXh.stop();
                    final String str = (String) ((View) k.this.yXh).getTag();
                    com.tencent.mm.sdk.a.b.A(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.ckW() + "[ImageGallery] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + bo.bc(str, "")).getBytes(), 2), "FullScreenPlaySight");
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(32378);
                            if (bo.isNullOrNil(str)) {
                                h.g(k.this.yUe.yTI, R.string.f1a, R.string.ank);
                                AppMethodBeat.o(32378);
                                return;
                            }
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            com.tencent.mm.sdk.platformtools.k.a(k.this.yUe.yTI, intent, new File(str), "video/*");
                            try {
                                k.this.yUe.yTI.startActivity(Intent.createChooser(intent, k.this.yUe.yTI.mController.ylL.getString(R.string.bs9)));
                                AppMethodBeat.o(32378);
                            } catch (Exception e) {
                                ab.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                                h.g(k.this.yUe.yTI, R.string.bpq, R.string.bpr);
                                AppMethodBeat.o(32378);
                            }
                        }
                    });
                    k.this.yXf.put(str, Boolean.TRUE);
                    AppMethodBeat.o(32380);
                }

                public final void EA() {
                    AppMethodBeat.i(32381);
                    k.this.yXh.start();
                    k.this.yXl.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(32379);
                            if (k.this.yXl == null || k.this.yXl.getVisibility() == 0) {
                                AppMethodBeat.o(32379);
                                return;
                            }
                            if (k.this.yXl.getTag() != null && (k.this.yXl.getTag() instanceof s)) {
                                s sVar = (s) k.this.yXl.getTag();
                                if (sVar.fXm != null && !bo.isNullOrNil(sVar.fXm.fiG)) {
                                    k.this.yXl.setVisibility(8);
                                    AppMethodBeat.o(32379);
                                    return;
                                } else if (!(sVar.fXm == null || bo.isNullOrNil(sVar.fXm.fiJ) || bo.isNullOrNil(sVar.fXm.fiK))) {
                                    k.this.yXl.setVisibility(8);
                                    AppMethodBeat.o(32379);
                                    return;
                                }
                            }
                            k.this.yXl.setVisibility(0);
                            k.this.yXl.startAnimation(AnimationUtils.loadAnimation(k.this.yXl.getContext(), R.anim.b5));
                            AppMethodBeat.o(32379);
                        }
                    });
                    AppMethodBeat.o(32381);
                }

                public final int dG(int i, int i2) {
                    return 0;
                }

                public final void dH(int i, int i2) {
                }
            });
            this.mlK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(32383);
                    if (view.getTag() != null && (view.getTag() instanceof bi)) {
                        bi biVar = (bi) view.getTag();
                        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.EnterCompleteVideo, biVar);
                        s ut = u.ut(biVar.field_imgPath);
                        cfh cfh = ut.fXm;
                        if (cfh != null && !ah.isNullOrNil(cfh.fiG)) {
                            int i;
                            o.all();
                            String ui = t.ui(biVar.field_imgPath);
                            Intent intent = new Intent();
                            intent.putExtra("IsAd", false);
                            intent.putExtra("KStremVideoUrl", cfh.fiG);
                            intent.putExtra("KThumUrl", cfh.fiL);
                            intent.putExtra("KThumbPath", ui);
                            intent.putExtra("KMediaId", "fakeid_" + biVar.field_msgId);
                            intent.putExtra("KMediaVideoTime", cfh.wid);
                            intent.putExtra("KMediaTitle", cfh.fiI);
                            intent.putExtra("StreamWording", cfh.fiJ);
                            intent.putExtra("StremWebUrl", cfh.fiK);
                            String str = biVar.field_talker;
                            boolean kH = com.tencent.mm.model.t.kH(str);
                            ui = kH ? bf.oy(biVar.field_content) : str;
                            intent.putExtra("KSta_StremVideoAduxInfo", cfh.fiM);
                            intent.putExtra("KSta_StremVideoPublishId", cfh.fiN);
                            intent.putExtra("KSta_SourceType", 1);
                            String str2 = "KSta_Scene";
                            if (kH) {
                                i = com.tencent.mm.ui.chatting.a.b.TalkChat.value;
                            } else {
                                i = com.tencent.mm.ui.chatting.a.b.Chat.value;
                            }
                            intent.putExtra(str2, i);
                            intent.putExtra("KSta_FromUserName", ui);
                            intent.putExtra("KSta_ChatName", str);
                            intent.putExtra("KSta_MsgId", biVar.field_msgSvrId);
                            intent.putExtra("KSta_SnsStatExtStr", ut.cMn);
                            if (kH) {
                                intent.putExtra("KSta_ChatroomMembercount", n.mA(str));
                            }
                            com.tencent.mm.bp.d.b(k.this.yUe.yTI.mController.ylL, "sns", ".ui.VideoAdPlayerUI", intent);
                            AppMethodBeat.o(32383);
                            return;
                        } else if (!(cfh == null || bo.isNullOrNil(cfh.fiJ) || bo.isNullOrNil(cfh.fiK))) {
                            ab.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + cfh.fiK);
                            final Intent intent2 = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", ut.cMn);
                            intent2.putExtra("jsapiargs", bundle);
                            intent2.putExtra("rawUrl", cfh.fiK);
                            intent2.putExtra("useJs", true);
                            new ak(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(32382);
                                    com.tencent.mm.bp.d.b(k.this.yUe.yTI.mController.ylL, "webview", ".ui.tools.WebViewUI", intent2);
                                    AppMethodBeat.o(32382);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(32383);
                }
            });
        }
        AppMethodBeat.o(32396);
        return this;
    }

    public final k dGH() {
        AppMethodBeat.i(32397);
        if (this.yXm == null) {
            if (this.yXC != null) {
                this.yXC.setVisibility(8);
            }
            if (this.yXB != null) {
                this.yXB.setVisibility(8);
            }
            this.yXm = (RelativeLayout) ((ViewStub) this.mRR.findViewById(R.id.aey)).inflate();
            this.yXn = (ImageView) this.yXm.findViewById(R.id.ci5);
            this.yXo = (ImageView) this.yXm.findViewById(R.id.ci6);
            this.yXo.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(32384);
                    if (k.this.yUe != null) {
                        ab.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", Integer.valueOf(k.this.hashCode()), Integer.valueOf(k.this.mPosition));
                        k.this.yUe.OP(k.this.mPosition);
                    }
                    AppMethodBeat.o(32384);
                }
            });
            com.tencent.mm.modelcontrol.d.afF();
            if (com.tencent.mm.modelcontrol.d.afO()) {
                this.yXp = new VideoPlayerTextureView(this.mRR.getContext());
                com.tencent.mm.plugin.report.service.h.pYm.a(354, 150, 1, false);
            } else {
                this.yXp = new VideoTextureView(this.mRR.getContext());
                com.tencent.mm.plugin.report.service.h.pYm.a(354, 151, 1, false);
            }
            this.yXr = (TextView) this.mRR.findViewById(R.id.chu);
            this.yXp.setPlayProgressCallback(true);
            this.yXm.addView((View) this.yXp, 2, new LayoutParams(-1, -1));
            this.yXq = (MMPinProgressBtn) this.yXm.findViewById(R.id.ci7);
            this.yXq.setVisibility(8);
            ((View) this.yXp).setVisibility(8);
            this.yXp.setVideoCallback(new a() {
                public final void pL() {
                    AppMethodBeat.i(32387);
                    if (k.this.yUe != null) {
                        k.this.yUe.yTO.dGz();
                    }
                    AppMethodBeat.o(32387);
                }

                public final void onError(int i, int i2) {
                    AppMethodBeat.i(32388);
                    ab.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + i + " extra: " + i2);
                    if (k.this.yUe != null) {
                        k.this.yUe.yTO.hp(i, i2);
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(12084, Integer.valueOf(k.this.yXF), Integer.valueOf(k.this.rbG * 1000), Integer.valueOf(0), Integer.valueOf(4), k.this.cEV, Integer.valueOf(k.this.yXG), k.this.fileId, Long.valueOf(k.this.createTime));
                    AppMethodBeat.o(32388);
                }

                public final void EA() {
                    AppMethodBeat.i(32389);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(32385);
                            k.this.yUe.yTI.qx(true);
                            c cVar = k.this.yUe;
                            cVar.yTO.Pf(k.this.mPosition);
                            k.this.yUe.yTO.dGA();
                            AppMethodBeat.o(32385);
                        }
                    });
                    AppMethodBeat.o(32389);
                }

                public final int dG(final int i, final int i2) {
                    AppMethodBeat.i(32390);
                    ab.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", Integer.valueOf(i), Integer.valueOf(k.this.rbG), Integer.valueOf(i2), Integer.valueOf(k.this.yXF), Integer.valueOf(k.this.yXG), k.this.cEV);
                    aw.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(32386);
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                            Object[] objArr = new Object[8];
                            objArr[0] = Integer.valueOf(k.this.yXF);
                            objArr[1] = Integer.valueOf(i2 <= 0 ? k.this.rbG * 1000 : i2);
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Integer.valueOf(1);
                            objArr[4] = k.this.cEV;
                            objArr[5] = Integer.valueOf(k.this.yXG);
                            objArr[6] = k.this.fileId;
                            objArr[7] = Long.valueOf(k.this.createTime);
                            hVar.e(12084, objArr);
                            AppMethodBeat.o(32386);
                        }
                    });
                    AppMethodBeat.o(32390);
                    return 0;
                }

                public final void dH(int i, int i2) {
                }
            });
        }
        AppMethodBeat.o(32397);
        return this;
    }

    public final void a(int i, int i2, int i3, String str, String str2, long j) {
        this.rbG = i;
        this.yXF = i2;
        this.yXG = i3;
        this.cEV = str;
        this.fileId = str2;
        this.createTime = j;
    }

    public final void a(boolean z, float f) {
        AppMethodBeat.i(32398);
        ab.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Float.valueOf(f));
        if (z) {
            View view = (View) dGH().yXp;
            view.setAlpha(f);
            am(view, 0);
            if (((double) f) >= 1.0d) {
                am(dGH().yXn, 8);
                am(dGH().yXo, 8);
            }
            AppMethodBeat.o(32398);
            return;
        }
        am((View) dGH().yXp, 8);
        am(dGH().yXn, 0);
        am(dGH().yXo, 0);
        AppMethodBeat.o(32398);
    }
}
