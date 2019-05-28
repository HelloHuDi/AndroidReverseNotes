package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.io.File;

public class FavVideoView extends RelativeLayout implements com.tencent.mm.pluginsdk.ui.tools.e.a {
    private String ePJ;
    private ak kkp;
    public e klq;
    private ImageView mmB;
    private boolean mmE;
    public LinearLayout mmZ;
    private String mnd;
    private TextView mqf;
    private boolean mqg;
    private boolean mqh;
    private int mqi;
    private ProgressBar mqj;
    private MMPinProgressBtn mqk;
    private int mql;
    private a mqm;

    class a implements p, d {
        private a() {
        }

        /* synthetic */ a(FavVideoView favVideoView, byte b) {
            this();
        }

        public final void d(c cVar) {
            AppMethodBeat.i(74721);
            if (cVar == null) {
                AppMethodBeat.o(74721);
            } else if (bo.isNullOrNil(cVar.field_dataId) || !cVar.field_dataId.equals(FavVideoView.this.mnd)) {
                AppMethodBeat.o(74721);
            } else {
                a(cVar.field_status, cVar.field_path, cVar.field_offset, cVar.field_totalLen);
                AppMethodBeat.o(74721);
            }
        }

        public final void a(int i, i iVar) {
            AppMethodBeat.i(74722);
            if (iVar == null) {
                AppMethodBeat.o(74722);
            } else if (iVar.field_dataId.equals(FavVideoView.this.mnd)) {
                a(iVar.field_status, iVar.field_path, iVar.field_offset, iVar.field_totalLen);
                AppMethodBeat.o(74722);
            } else {
                AppMethodBeat.o(74722);
            }
        }

        private void a(int i, String str, int i2, int i3) {
            AppMethodBeat.i(74723);
            ab.d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
            if ((i == 3 || i == 2) && com.tencent.mm.vfs.e.ct(str)) {
                FavVideoView.this.klq.stop();
                FavVideoView.g(FavVideoView.this);
                FavVideoView.this.ePJ = str;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74720);
                        if (FavVideoView.this.klq != null) {
                            FavVideoView.this.Mj(FavVideoView.this.ePJ);
                        }
                        AppMethodBeat.o(74720);
                    }
                });
                AppMethodBeat.o(74723);
                return;
            }
            FavVideoView.a(FavVideoView.this, i2, i3);
            AppMethodBeat.o(74723);
        }
    }

    public FavVideoView(Context context) {
        this(context, null);
    }

    public FavVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FavVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(74724);
        this.kkp = new ak(Looper.getMainLooper());
        this.mqg = false;
        this.mqh = false;
        this.mqi = 0;
        this.mmE = false;
        this.mnd = "";
        this.mql = 0;
        this.mqm = new a(this, (byte) 0);
        ab.i("MicroMsg.FavVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(context).inflate(R.layout.z5, this);
        this.mmB = (ImageView) findViewById(R.id.aex);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.bl);
        ((TextView) findViewById(R.id.aez)).setVisibility(8);
        this.mqk = (MMPinProgressBtn) findViewById(R.id.af0);
        this.mqj = (ProgressBar) findViewById(R.id.a9d);
        this.mmZ = (LinearLayout) findViewById(R.id.bp_);
        this.mqf = (TextView) findViewById(R.id.af2);
        if (com.tencent.mm.modelcontrol.d.afO()) {
            this.mqh = true;
            this.klq = new VideoPlayerTextureView(context);
        } else {
            this.mqh = false;
            this.klq = new VideoTextureView(context);
        }
        this.klq.setVideoCallback(this);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(13);
        relativeLayout.addView((View) this.klq, layoutParams);
        ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.mqm);
        ((ae) g.M(ae.class)).getFavCdnStorage().a(this.mqm);
        AppMethodBeat.o(74724);
    }

    public void setVideoData(String str) {
        this.ePJ = str;
    }

    public final void a(String str, boolean z, String str2) {
        AppMethodBeat.i(74725);
        this.ePJ = str;
        if (z) {
            aNt();
            this.mnd = str2;
        }
        AppMethodBeat.o(74725);
    }

    public void setThumbView(String str) {
        AppMethodBeat.i(74726);
        this.mmB.setImageBitmap(b.i(str, 1.0f));
        AppMethodBeat.o(74726);
    }

    public final void onResume() {
        AppMethodBeat.i(74727);
        ab.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
        if (!this.mqg) {
            bwD();
        }
        AppMethodBeat.o(74727);
    }

    public final void onDestroy() {
        AppMethodBeat.i(74728);
        ab.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
        try {
            ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.mqm);
            ((ae) g.M(ae.class)).getFavCdnStorage().b(this.mqm);
            this.klq.stop();
            AppMethodBeat.o(74728);
        } catch (Throwable th) {
            AppMethodBeat.o(74728);
        }
    }

    private void ho(final boolean z) {
        AppMethodBeat.i(74729);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74714);
                ab.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", Boolean.valueOf(z));
                View view = (View) FavVideoView.this.klq;
                if (z) {
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                    FavVideoView.this.mmB.setVisibility(8);
                    AppMethodBeat.o(74714);
                    return;
                }
                view.setVisibility(8);
                FavVideoView.this.mmB.setVisibility(0);
                AppMethodBeat.o(74714);
            }
        });
        AppMethodBeat.o(74729);
    }

    private void bwD() {
        AppMethodBeat.i(74730);
        if (bo.isNullOrNil(this.ePJ) || !com.tencent.mm.vfs.e.ct(this.ePJ)) {
            ab.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
            ho(false);
            AppMethodBeat.o(74730);
            return;
        }
        ab.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
        Mj(this.ePJ);
        AppMethodBeat.o(74730);
    }

    private static boolean bwE() {
        AppMethodBeat.i(74731);
        boolean z = g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
        AppMethodBeat.o(74731);
        return z;
    }

    public final void Mj(String str) {
        AppMethodBeat.i(74732);
        ab.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.o(74732);
            return;
        }
        if (this.klq != null) {
            if (this.klq instanceof VideoPlayerTextureView) {
                ((VideoPlayerTextureView) this.klq).setNeedResetExtractor(bwE());
            }
            ((View) this.klq).setVisibility(0);
            ((View) this.klq).setAlpha(0.0f);
            this.mmB.setVisibility(0);
            this.klq.setVideoPath(str);
        }
        if (((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
            this.mqf.setText(com.tencent.mm.plugin.sight.base.d.RK(str));
            this.mqf.setVisibility(0);
        }
        AppMethodBeat.o(74732);
    }

    public final int dG(int i, int i2) {
        return 0;
    }

    public final void dH(int i, int i2) {
    }

    public final void pL() {
        AppMethodBeat.i(74733);
        this.mqi = 0;
        ho(true);
        this.mmE = this.klq.start();
        ab.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", Integer.valueOf(this.klq.getDuration() / 1000));
        AppMethodBeat.o(74733);
    }

    public final void EA() {
        AppMethodBeat.i(74734);
        ab.i("MicroMsg.FavVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (com.tencent.mm.compatible.util.d.iX(18) || !this.mqh) {
            ab.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", Integer.valueOf(0));
            this.klq.B(0.0d);
            AppMethodBeat.o(74734);
            return;
        }
        if (this.klq != null) {
            this.klq.stop();
        }
        AppMethodBeat.o(74734);
    }

    public final void onError(int i, int i2) {
        AppMethodBeat.i(74735);
        ab.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.mqh));
        if (this.mmE) {
            EA();
            AppMethodBeat.o(74735);
            return;
        }
        this.mqi = i2;
        final String videoPath = this.klq.getVideoPath();
        this.klq.stop();
        this.mqg = true;
        ho(false);
        if (this.mqi == -1) {
            this.mql++;
            if (this.mql <= 3) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74715);
                        if (FavVideoView.this.klq != null) {
                            FavVideoView.this.Mj(FavVideoView.this.ePJ);
                        }
                        AppMethodBeat.o(74715);
                    }
                });
                AppMethodBeat.o(74735);
                return;
            }
        }
        if (!bo.isNullOrNil(videoPath) && com.tencent.mm.vfs.e.ct(videoPath)) {
            ab.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
            this.kkp.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74716);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    k.a(FavVideoView.this.getContext(), intent, new File(videoPath), "video/*");
                    try {
                        FavVideoView.this.getContext().startActivity(intent);
                        AppMethodBeat.o(74716);
                    } catch (Exception e) {
                        ab.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
                        h.g(FavVideoView.this.getContext(), R.string.bpq, R.string.bpr);
                        AppMethodBeat.o(74716);
                    }
                }
            });
        }
        AppMethodBeat.o(74735);
    }

    private void aNt() {
        AppMethodBeat.i(74736);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74718);
                if (!(FavVideoView.this.mqj == null || FavVideoView.this.mqj.getVisibility() == 0)) {
                    FavVideoView.this.mqj.setVisibility(0);
                }
                if (!(FavVideoView.this.mqk == null || FavVideoView.this.mqk.getVisibility() == 8)) {
                    FavVideoView.this.mqk.setVisibility(8);
                }
                AppMethodBeat.o(74718);
            }
        });
        AppMethodBeat.o(74736);
    }

    static /* synthetic */ void g(FavVideoView favVideoView) {
        AppMethodBeat.i(74737);
        favVideoView.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74719);
                if (!(FavVideoView.this.mqj == null || FavVideoView.this.mqj.getVisibility() == 8)) {
                    FavVideoView.this.mqj.setVisibility(8);
                }
                if (!(FavVideoView.this.mqk == null || FavVideoView.this.mqk.getVisibility() == 8)) {
                    FavVideoView.this.mqk.setVisibility(8);
                }
                AppMethodBeat.o(74719);
            }
        });
        AppMethodBeat.o(74737);
    }
}
