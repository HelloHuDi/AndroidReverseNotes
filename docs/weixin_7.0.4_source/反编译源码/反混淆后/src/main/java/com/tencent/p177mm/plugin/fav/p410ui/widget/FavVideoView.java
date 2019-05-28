package com.tencent.p177mm.plugin.fav.p410ui.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.plugin.fav.p407a.C11855p;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;
import com.tencent.p177mm.plugin.record.p1016a.C34792i;
import com.tencent.p177mm.plugin.record.p1016a.C43427d;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoTextureView;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavVideoView */
public class FavVideoView extends RelativeLayout implements C14981a {
    private String ePJ;
    private C7306ak kkp;
    public C14979e klq;
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
    private C20751a mqm;

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavVideoView$6 */
    class C207506 implements Runnable {
        C207506() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74719);
            if (!(FavVideoView.this.mqj == null || FavVideoView.this.mqj.getVisibility() == 8)) {
                FavVideoView.this.mqj.setVisibility(8);
            }
            if (!(FavVideoView.this.mqk == null || FavVideoView.this.mqk.getVisibility() == 8)) {
                FavVideoView.this.mqk.setVisibility(8);
            }
            AppMethodBeat.m2505o(74719);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavVideoView$a */
    class C20751a implements C11855p, C43427d {

        /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavVideoView$a$1 */
        class C207521 implements Runnable {
            C207521() {
            }

            public final void run() {
                AppMethodBeat.m2504i(74720);
                if (FavVideoView.this.klq != null) {
                    FavVideoView.this.mo73796Mj(FavVideoView.this.ePJ);
                }
                AppMethodBeat.m2505o(74720);
            }
        }

        private C20751a() {
        }

        /* synthetic */ C20751a(FavVideoView favVideoView, byte b) {
            this();
        }

        /* renamed from: d */
        public final void mo23673d(C45925c c45925c) {
            AppMethodBeat.m2504i(74721);
            if (c45925c == null) {
                AppMethodBeat.m2505o(74721);
            } else if (C5046bo.isNullOrNil(c45925c.field_dataId) || !c45925c.field_dataId.equals(FavVideoView.this.mnd)) {
                AppMethodBeat.m2505o(74721);
            } else {
                m31980a(c45925c.field_status, c45925c.field_path, c45925c.field_offset, c45925c.field_totalLen);
                AppMethodBeat.m2505o(74721);
            }
        }

        /* renamed from: a */
        public final void mo25051a(int i, C34792i c34792i) {
            AppMethodBeat.m2504i(74722);
            if (c34792i == null) {
                AppMethodBeat.m2505o(74722);
            } else if (c34792i.field_dataId.equals(FavVideoView.this.mnd)) {
                m31980a(c34792i.field_status, c34792i.field_path, c34792i.field_offset, c34792i.field_totalLen);
                AppMethodBeat.m2505o(74722);
            } else {
                AppMethodBeat.m2505o(74722);
            }
        }

        /* renamed from: a */
        private void m31980a(int i, String str, int i2, int i3) {
            AppMethodBeat.m2504i(74723);
            C4990ab.m7411d("MicroMsg.FavVideoView", "onCdnStatusChanged status:%s, offset:%s, totalLength:%s, path:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
            if ((i == 3 || i == 2) && C5730e.m8628ct(str)) {
                FavVideoView.this.klq.stop();
                FavVideoView.m85308g(FavVideoView.this);
                FavVideoView.this.ePJ = str;
                C5004al.m7441d(new C207521());
                AppMethodBeat.m2505o(74723);
                return;
            }
            FavVideoView.m85302a(FavVideoView.this, i2, i3);
            AppMethodBeat.m2505o(74723);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavVideoView$2 */
    class C430842 implements Runnable {
        C430842() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74715);
            if (FavVideoView.this.klq != null) {
                FavVideoView.this.mo73796Mj(FavVideoView.this.ePJ);
            }
            AppMethodBeat.m2505o(74715);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavVideoView$5 */
    class C430865 implements Runnable {
        C430865() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74718);
            if (!(FavVideoView.this.mqj == null || FavVideoView.this.mqj.getVisibility() == 0)) {
                FavVideoView.this.mqj.setVisibility(0);
            }
            if (!(FavVideoView.this.mqk == null || FavVideoView.this.mqk.getVisibility() == 8)) {
                FavVideoView.this.mqk.setVisibility(8);
            }
            AppMethodBeat.m2505o(74718);
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
        AppMethodBeat.m2504i(74724);
        this.kkp = new C7306ak(Looper.getMainLooper());
        this.mqg = false;
        this.mqh = false;
        this.mqi = 0;
        this.mmE = false;
        this.mnd = "";
        this.mql = 0;
        this.mqm = new C20751a(this, (byte) 0);
        C4990ab.m7417i("MicroMsg.FavVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(context).inflate(2130969534, this);
        this.mmB = (ImageView) findViewById(2131822133);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131820629);
        ((TextView) findViewById(2131822135)).setVisibility(8);
        this.mqk = (MMPinProgressBtn) findViewById(2131822136);
        this.mqj = (ProgressBar) findViewById(2131821891);
        this.mmZ = (LinearLayout) findViewById(2131823884);
        this.mqf = (TextView) findViewById(2131822138);
        if (C42204d.afO()) {
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
        ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37080a(this.mqm);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15157a(this.mqm);
        AppMethodBeat.m2505o(74724);
    }

    public void setVideoData(String str) {
        this.ePJ = str;
    }

    /* renamed from: a */
    public final void mo73797a(String str, boolean z, String str2) {
        AppMethodBeat.m2504i(74725);
        this.ePJ = str;
        if (z) {
            aNt();
            this.mnd = str2;
        }
        AppMethodBeat.m2505o(74725);
    }

    public void setThumbView(String str) {
        AppMethodBeat.m2504i(74726);
        this.mmB.setImageBitmap(C4977b.m7374i(str, 1.0f));
        AppMethodBeat.m2505o(74726);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(74727);
        C4990ab.m7416i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
        if (!this.mqg) {
            bwD();
        }
        AppMethodBeat.m2505o(74727);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(74728);
        C4990ab.m7416i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
        try {
            ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37083b(this.mqm);
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15159b(this.mqm);
            this.klq.stop();
            AppMethodBeat.m2505o(74728);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(74728);
        }
    }

    /* renamed from: ho */
    private void m85309ho(final boolean z) {
        AppMethodBeat.m2504i(74729);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74714);
                C4990ab.m7417i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", Boolean.valueOf(z));
                View view = (View) FavVideoView.this.klq;
                if (z) {
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                    FavVideoView.this.mmB.setVisibility(8);
                    AppMethodBeat.m2505o(74714);
                    return;
                }
                view.setVisibility(8);
                FavVideoView.this.mmB.setVisibility(0);
                AppMethodBeat.m2505o(74714);
            }
        });
        AppMethodBeat.m2505o(74729);
    }

    private void bwD() {
        AppMethodBeat.m2504i(74730);
        if (C5046bo.isNullOrNil(this.ePJ) || !C5730e.m8628ct(this.ePJ)) {
            C4990ab.m7416i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
            m85309ho(false);
            AppMethodBeat.m2505o(74730);
            return;
        }
        C4990ab.m7416i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
        mo73796Mj(this.ePJ);
        AppMethodBeat.m2505o(74730);
    }

    private static boolean bwE() {
        AppMethodBeat.m2504i(74731);
        boolean z = C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
        AppMethodBeat.m2505o(74731);
        return z;
    }

    /* renamed from: Mj */
    public final void mo73796Mj(String str) {
        AppMethodBeat.m2504i(74732);
        C4990ab.m7416i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            AppMethodBeat.m2505o(74732);
            return;
        }
        if (this.klq != null) {
            if (this.klq instanceof VideoPlayerTextureView) {
                ((VideoPlayerTextureView) this.klq).setNeedResetExtractor(FavVideoView.bwE());
            }
            ((View) this.klq).setVisibility(0);
            ((View) this.klq).setAlpha(0.0f);
            this.mmB.setVisibility(0);
            this.klq.setVideoPath(str);
        }
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
            this.mqf.setText(C21846d.m33384RK(str));
            this.mqf.setVisibility(0);
        }
        AppMethodBeat.m2505o(74732);
    }

    /* renamed from: dG */
    public final int mo8554dG(int i, int i2) {
        return 0;
    }

    /* renamed from: dH */
    public final void mo8555dH(int i, int i2) {
    }

    /* renamed from: pL */
    public final void mo8557pL() {
        AppMethodBeat.m2504i(74733);
        this.mqi = 0;
        m85309ho(true);
        this.mmE = this.klq.start();
        C4990ab.m7417i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", Integer.valueOf(this.klq.getDuration() / 1000));
        AppMethodBeat.m2505o(74733);
    }

    /* renamed from: EA */
    public final void mo8553EA() {
        AppMethodBeat.m2504i(74734);
        C4990ab.m7417i("MicroMsg.FavVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (C1443d.m3069iX(18) || !this.mqh) {
            C4990ab.m7417i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", Integer.valueOf(0));
            this.klq.mo9052B(0.0d);
            AppMethodBeat.m2505o(74734);
            return;
        }
        if (this.klq != null) {
            this.klq.stop();
        }
        AppMethodBeat.m2505o(74734);
    }

    public final void onError(int i, int i2) {
        AppMethodBeat.m2504i(74735);
        C4990ab.m7413e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.mqh));
        if (this.mmE) {
            mo8553EA();
            AppMethodBeat.m2505o(74735);
            return;
        }
        this.mqi = i2;
        final String videoPath = this.klq.getVideoPath();
        this.klq.stop();
        this.mqg = true;
        m85309ho(false);
        if (this.mqi == -1) {
            this.mql++;
            if (this.mql <= 3) {
                C5004al.m7441d(new C430842());
                AppMethodBeat.m2505o(74735);
                return;
            }
        }
        if (!C5046bo.isNullOrNil(videoPath) && C5730e.m8628ct(videoPath)) {
            C4990ab.m7412e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
            this.kkp.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74716);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    C15429k.m23713a(FavVideoView.this.getContext(), intent, new File(videoPath), "video/*");
                    try {
                        FavVideoView.this.getContext().startActivity(intent);
                        AppMethodBeat.m2505o(74716);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
                        C30379h.m48467g(FavVideoView.this.getContext(), C25738R.string.bpq, C25738R.string.bpr);
                        AppMethodBeat.m2505o(74716);
                    }
                }
            });
        }
        AppMethodBeat.m2505o(74735);
    }

    private void aNt() {
        AppMethodBeat.m2504i(74736);
        this.kkp.post(new C430865());
        AppMethodBeat.m2505o(74736);
    }

    /* renamed from: g */
    static /* synthetic */ void m85308g(FavVideoView favVideoView) {
        AppMethodBeat.m2504i(74737);
        favVideoView.kkp.post(new C207506());
        AppMethodBeat.m2505o(74737);
    }
}
