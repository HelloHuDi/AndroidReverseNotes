package com.tencent.p177mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.segment.C12575c.C12576a;
import com.tencent.p177mm.plugin.mmsight.segment.C12575c.C12577b;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C21307a;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C28510b;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C39398c;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C39399d;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C41297c;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C41297c.C41298a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.FileSystem.C5712a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI */
public class VideoSegmentUI extends MMActivity {
    private CountDownLatch bXQ = new CountDownLatch(2);
    private ProgressDialog ehJ = null;
    private C46607d ext = new C46607d(this);
    private int fPW;
    private String lis = "";
    private Surface mSurface;
    private RelativeLayout mmW;
    private VideoTransPara ouc;
    private String ozB = null;
    private C39400f ozC;
    private C41297c ozD;
    private boolean ozE = false;
    private C12575c ozF;
    private int ozG = Downloads.MIN_WAIT_FOR_NETWORK;
    private boolean ozH = false;
    private boolean ozI = false;
    private boolean ozJ = false;
    private C12577b ozK = new C78072();
    private C41298a ozL = new C78133();
    private C39399d ozM = new C77954();
    private String thumbPath;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$b */
    class C3489b implements SurfaceTextureListener {
        private C3489b() {
        }

        /* synthetic */ C3489b(VideoSegmentUI videoSegmentUI, byte b) {
            this();
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.m2504i(55047);
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(VideoSegmentUI.this.ozH);
            objArr[1] = Boolean.valueOf(VideoSegmentUI.this.ozD == null);
            C4990ab.m7417i(str, str2, objArr);
            VideoSegmentUI.this.mSurface = new Surface(surfaceTexture);
            if (VideoSegmentUI.this.ozD == null && VideoSegmentUI.this.ozH) {
                C4990ab.m7416i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
                try {
                    VideoSegmentUI.m13833a(VideoSegmentUI.this, VideoSegmentUI.this.mSurface);
                    if (!(VideoSegmentUI.this.ozF == null || VideoSegmentUI.this.ozD == null)) {
                        VideoSegmentUI.this.ozD.setLoop((int) (((float) VideoSegmentUI.this.fPW) * VideoSegmentUI.this.ozF.bQa()), (int) (((float) VideoSegmentUI.this.fPW) * VideoSegmentUI.this.ozF.bQb()));
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "ResumeMediaPlayer error %s", e.getMessage());
                }
                VideoSegmentUI.this.ozH = false;
            }
            VideoSegmentUI.this.bXQ.countDown();
            AppMethodBeat.m2505o(55047);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.m2504i(55048);
            C4990ab.m7417i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", C5046bo.dpG());
            try {
                if (VideoSegmentUI.this.ozD != null) {
                    C4990ab.m7416i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
                    VideoSegmentUI.this.ozD.release();
                    VideoSegmentUI.this.ozD = null;
                    VideoSegmentUI.this.ozH = true;
                }
                VideoSegmentUI.this.mSurface = null;
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(55048);
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$4 */
    class C77954 implements C39399d {
        C77954() {
        }

        /* renamed from: aa */
        public final void mo17622aa(int i, int i2, int i3) {
            AppMethodBeat.m2504i(55033);
            if (i <= 0 || i2 <= 0) {
                C4990ab.m7413e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoSegmentUI.this.ozJ));
                AppMethodBeat.m2505o(55033);
            } else if (VideoSegmentUI.this.ozJ) {
                C4990ab.m7412e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
                AppMethodBeat.m2505o(55033);
            } else {
                C4990ab.m7417i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", Integer.valueOf(i), Integer.valueOf(i2));
                VideoSegmentUI.this.ozJ = true;
                if (i2 <= 0 || i <= 0) {
                    C4990ab.m7413e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", Integer.valueOf(i), Integer.valueOf(i2));
                    VideoSegmentUI.this.ozI = true;
                    VideoSegmentUI.this.finish();
                    VideoSegmentUI.m13838b(VideoSegmentUI.this);
                    AppMethodBeat.m2505o(55033);
                    return;
                }
                C7800a c7800a = new C7800a(VideoSegmentUI.this, VideoSegmentUI.this.mmW, i2, i, i3, new C3489b(VideoSegmentUI.this, (byte) 0), (byte) 0);
                if (VideoSegmentUI.this.mmW.getWidth() <= 0 || VideoSegmentUI.this.mmW.getHeight() <= 0) {
                    C4990ab.m7416i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
                    VideoSegmentUI.this.mmW.post(c7800a);
                    AppMethodBeat.m2505o(55033);
                    return;
                }
                c7800a.run();
                AppMethodBeat.m2505o(55033);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$6 */
    class C77966 implements OnMenuItemClickListener {
        C77966() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55035);
            VideoSegmentUI.m13839c(VideoSegmentUI.this);
            AppMethodBeat.m2505o(55035);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$7 */
    class C77977 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$7$1 */
        class C77981 implements Runnable {
            C77981() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55036);
                if (VideoSegmentUI.this.ehJ != null) {
                    VideoSegmentUI.this.ehJ.dismiss();
                }
                if (VideoSegmentUI.this.ozF != null) {
                    VideoSegmentUI.this.ozF.mo24506iX(false);
                }
                Toast.makeText(VideoSegmentUI.this, C25738R.string.d01, 1).show();
                AppMethodBeat.m2505o(55036);
            }
        }

        C77977() {
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.m2504i(55038);
            String str = null;
            try {
                VideoSegmentUI.this.ozD.stop();
                int e = VideoSegmentUI.this.fPW;
                long yz = C5046bo.m7588yz();
                VideoSegmentUI.this.ozC.mo7956b(VideoSegmentUI.this.ozB, VideoSegmentUI.this.lis, VideoSegmentUI.this.ouc);
                if (VideoSegmentUI.this.ozC.mo7953O((long) (VideoSegmentUI.this.ozF.bQa() * ((float) e)), (long) (((float) e) * VideoSegmentUI.this.ozF.bQb())) < 0) {
                    C4990ab.m7417i("MicroMsg.VideoSegmentUI", "clip failed! %s", Integer.valueOf(VideoSegmentUI.this.ozC.mo7953O((long) (VideoSegmentUI.this.ozF.bQa() * ((float) e)), (long) (((float) e) * VideoSegmentUI.this.ozF.bQb()))));
                    C5004al.m7441d(new C77981());
                    AppMethodBeat.m2505o(55038);
                    return;
                }
                Bitmap tv = C3475d.m5784tv(VideoSegmentUI.this.lis);
                if (tv != null) {
                    PInt pInt = new PInt();
                    PInt pInt2 = new PInt();
                    if (C3475d.m5770a(tv.getWidth(), tv.getHeight(), VideoSegmentUI.this.ouc.fAf, pInt, pInt2)) {
                        tv = Bitmap.createScaledBitmap(tv, pInt.value, pInt2.value, true);
                    }
                    C4990ab.m7417i("MicroMsg.VideoSegmentUI", "getBitmap size = [%d, %d]", Integer.valueOf(tv.getWidth()), Integer.valueOf(tv.getHeight()));
                    C5056d.m7625a(tv, 80, CompressFormat.JPEG, VideoSegmentUI.this.thumbPath, true);
                    C4990ab.m7417i("MicroMsg.VideoSegmentUI", "create video thumb. use %dms", Long.valueOf(C5046bo.m7525az(yz)));
                } else {
                    C4990ab.m7412e("MicroMsg.VideoSegmentUI", "getVideoThumb failed!");
                }
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(55037);
                        if (VideoSegmentUI.this.ehJ != null) {
                            VideoSegmentUI.this.ehJ.dismiss();
                        }
                        if (VideoSegmentUI.this.ozF != null) {
                            VideoSegmentUI.this.ozF.mo24506iX(false);
                        }
                        VideoSegmentUI.m13834a(VideoSegmentUI.this, z, str);
                        AppMethodBeat.m2505o(55037);
                    }
                });
                AppMethodBeat.m2505o(55038);
            } catch (Exception e2) {
                Exception exception = e2;
                str = exception.getMessage();
                C4990ab.printErrStackTrace("MicroMsg.VideoSegmentUI", exception, "UnexpectedException when clip : [%s]", exception.getMessage());
                z = false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$a */
    class C7800a implements Runnable {
        private Context context;
        private ViewGroup lYe;
        private int ozU;
        private int ozV;
        private int ozW;
        private C3489b ozX;

        /* synthetic */ C7800a(VideoSegmentUI videoSegmentUI, ViewGroup viewGroup, int i, int i2, int i3, C3489b c3489b, byte b) {
            this(viewGroup, i, i2, i3, c3489b);
        }

        private C7800a(ViewGroup viewGroup, int i, int i2, int i3, C3489b c3489b) {
            AppMethodBeat.m2504i(55045);
            this.ozU = i;
            this.ozV = i2;
            this.ozW = i3;
            this.context = viewGroup.getContext();
            this.lYe = viewGroup;
            this.ozX = c3489b;
            AppMethodBeat.m2505o(55045);
        }

        public final void run() {
            AppMethodBeat.m2504i(55046);
            if (VideoSegmentUI.this.isFinishing()) {
                AppMethodBeat.m2505o(55046);
                return;
            }
            float f;
            C78011 c78011 = new MMTextureView(this.context) {
                /* Access modifiers changed, original: protected|final */
                public final void onMeasure(int i, int i2) {
                    AppMethodBeat.m2504i(55044);
                    C4990ab.m7411d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", Integer.valueOf(C7800a.this.ozV), Integer.valueOf(C7800a.this.ozU), Integer.valueOf(C7800a.this.ozW), Integer.valueOf(View.getDefaultSize(1, i)), Integer.valueOf(View.getDefaultSize(1, i2)));
                    if (C7800a.this.ozW == 90 || C7800a.this.ozW == 270) {
                        Matrix matrix = new Matrix();
                        matrix.set(getMatrix());
                        int defaultSize = View.getDefaultSize(1, i);
                        int defaultSize2 = View.getDefaultSize(1, i2);
                        float f = ((float) defaultSize) / 2.0f;
                        float f2 = ((float) defaultSize2) / 2.0f;
                        float f3 = ((float) defaultSize2) / ((float) defaultSize);
                        matrix.postRotate((float) C7800a.this.ozW, f, f2);
                        matrix.postScale(1.0f / f3, f3, f, f2);
                        setTransform(matrix);
                        C4990ab.m7417i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", Integer.valueOf(C7800a.this.ozW), Integer.valueOf(defaultSize), Integer.valueOf(defaultSize2));
                    }
                    super.onMeasure(i, i2);
                    AppMethodBeat.m2505o(55044);
                }
            };
            int width = this.lYe.getWidth();
            int al = C1338a.m2856al(this.context, C25738R.dimen.aa2);
            int top = ((View) VideoSegmentUI.this.ozF).getTop() - (al * 2);
            int i = this.ozV;
            int i2 = this.ozU;
            Point point = new Point();
            if (((float) i2) / ((float) i) > ((float) top) / ((float) width)) {
                f = ((float) top) / ((float) i2);
            } else {
                f = ((float) width) / ((float) i);
            }
            point.x = (int) (((float) i) * f);
            point.y = (int) (f * ((float) i2));
            C4990ab.m7417i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", Integer.valueOf(this.ozV), Integer.valueOf(this.ozU), Integer.valueOf(this.ozW), Integer.valueOf(al), Integer.valueOf(width), Integer.valueOf(top), point.toString());
            if (point.x <= 0 || point.y <= 0) {
                C4990ab.m7413e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", Integer.valueOf(this.ozV), Integer.valueOf(this.ozU), Integer.valueOf(al), Integer.valueOf(width), Integer.valueOf(top), point.toString());
                if (this.ozX != null) {
                    C3489b c3489b = this.ozX;
                    C4990ab.m7412e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
                    VideoSegmentUI.this.ozI = true;
                    VideoSegmentUI.this.finish();
                    VideoSegmentUI.m13838b(VideoSegmentUI.this);
                }
                AppMethodBeat.m2505o(55046);
                return;
            }
            LayoutParams layoutParams = new LayoutParams(point.x, point.y);
            al += (int) (((float) (top - point.y)) / 2.0f);
            layoutParams.topMargin = al;
            layoutParams.bottomMargin = al;
            width = (int) (((float) (width - point.x)) / 2.0f);
            layoutParams.leftMargin = width;
            layoutParams.rightMargin = width;
            c78011.setSurfaceTextureListener(this.ozX);
            this.lYe.addView(c78011, 0, layoutParams);
            AppMethodBeat.m2505o(55046);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$5 */
    class C78025 implements OnMenuItemClickListener {
        C78025() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55034);
            VideoSegmentUI.this.finish();
            VideoSegmentUI.m13838b(VideoSegmentUI.this);
            AppMethodBeat.m2505o(55034);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$c */
    static class C7803c implements Runnable {
        private WeakReference<C12575c> aIp;
        private int fPW;
        private int ozZ;

        public C7803c(C12575c c12575c, int i, int i2) {
            AppMethodBeat.m2504i(55049);
            this.aIp = new WeakReference(c12575c);
            this.ozZ = i;
            this.fPW = i2;
            AppMethodBeat.m2505o(55049);
        }

        public final void run() {
            AppMethodBeat.m2504i(55050);
            C12575c c12575c = (C12575c) this.aIp.get();
            if (c12575c == null) {
                AppMethodBeat.m2505o(55050);
                return;
            }
            c12575c.setCurrentCursorPosition(((float) this.ozZ) / ((float) this.fPW));
            AppMethodBeat.m2505o(55050);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$10 */
    class C780410 implements C28510b {
        C780410() {
        }

        /* renamed from: ce */
        public final void mo17631ce(Object obj) {
            AppMethodBeat.m2504i(55041);
            C4990ab.m7417i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", obj);
            try {
                if (VideoSegmentUI.this.ozD != null) {
                    VideoSegmentUI.this.ozE = true;
                    VideoSegmentUI.this.ozD.start();
                }
                AppMethodBeat.m2505o(55041);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "hy: exception when onPrepared waiting for starting", new Object[0]);
                AppMethodBeat.m2505o(55041);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$9 */
    class C78059 implements C21307a {
        C78059() {
        }

        /* renamed from: ey */
        public final boolean mo17632ey(int i, int i2) {
            AppMethodBeat.m2504i(55040);
            C4990ab.m7413e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", Integer.valueOf(i), Integer.valueOf(i2));
            VideoSegmentUI.this.ozI = true;
            VideoSegmentUI.this.finish();
            VideoSegmentUI.m13838b(VideoSegmentUI.this);
            AppMethodBeat.m2505o(55040);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$11 */
    class C780611 implements C39398c {
        C780611() {
        }

        /* renamed from: cf */
        public final void mo7952cf(Object obj) {
            AppMethodBeat.m2504i(55042);
            try {
                if (VideoSegmentUI.this.ozD != null) {
                    VideoSegmentUI.this.ozD.start();
                }
                AppMethodBeat.m2505o(55042);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
                AppMethodBeat.m2505o(55042);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$2 */
    class C78072 implements C12577b {
        C78072() {
        }

        /* renamed from: U */
        public final void mo17633U(float f, float f2) {
            AppMethodBeat.m2504i(55028);
            if (VideoSegmentUI.this.ozD == null) {
                AppMethodBeat.m2505o(55028);
                return;
            }
            int e = VideoSegmentUI.this.fPW;
            VideoSegmentUI.this.ozD.setLoop((int) (((float) e) * f), (int) (((float) e) * f2));
            VideoSegmentUI.this.ozD.seekTo((int) (((float) e) * f));
            AppMethodBeat.m2505o(55028);
        }

        public final void bQc() {
            AppMethodBeat.m2504i(55029);
            if (VideoSegmentUI.this.ozD == null) {
                AppMethodBeat.m2505o(55029);
                return;
            }
            VideoSegmentUI.this.ozD.pause();
            AppMethodBeat.m2505o(55029);
        }

        /* renamed from: V */
        public final void mo17634V(float f, float f2) {
            AppMethodBeat.m2504i(55030);
            if (VideoSegmentUI.this.ozD == null) {
                AppMethodBeat.m2505o(55030);
                return;
            }
            int e = (int) (((float) VideoSegmentUI.this.fPW) * f);
            VideoSegmentUI.this.ozD.setLoop(e, (int) (((float) VideoSegmentUI.this.fPW) * f2));
            VideoSegmentUI.this.ozD.seekTo(e);
            AppMethodBeat.m2505o(55030);
        }

        /* renamed from: W */
        public final void mo17635W(float f, float f2) {
            AppMethodBeat.m2504i(55031);
            if ((f2 - f) * ((float) VideoSegmentUI.this.fPW) <= ((float) VideoSegmentUI.this.ozG)) {
                VideoSegmentUI.this.enableOptionMenu(true);
                AppMethodBeat.m2505o(55031);
                return;
            }
            VideoSegmentUI.this.enableOptionMenu(false);
            AppMethodBeat.m2505o(55031);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$d */
    class C7809d implements Runnable {

        /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$d$1 */
        class C78101 implements Runnable {
            C78101() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55051);
                if (VideoSegmentUI.this.ozI || VideoSegmentUI.this.isFinishing() || VideoSegmentUI.this.ozF == null || VideoSegmentUI.this.ozD == null) {
                    C4990ab.m7416i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
                    AppMethodBeat.m2505o(55051);
                    return;
                }
                ((View) VideoSegmentUI.this.ozF).setAlpha(0.0f);
                ((View) VideoSegmentUI.this.ozF).setVisibility(0);
                ((View) VideoSegmentUI.this.ozF).animate().setDuration(300).setStartDelay(200).alpha(1.0f);
                float bQa = VideoSegmentUI.this.ozF.bQa();
                float bQb = VideoSegmentUI.this.ozF.bQb();
                if ((bQb - bQa) * ((float) VideoSegmentUI.this.fPW) <= ((float) VideoSegmentUI.this.ozG)) {
                    VideoSegmentUI.this.enableOptionMenu(true);
                }
                VideoSegmentUI.this.ozD.setLoop((int) (bQa * ((float) VideoSegmentUI.this.fPW)), (int) (bQb * ((float) VideoSegmentUI.this.fPW)));
                AppMethodBeat.m2505o(55051);
            }
        }

        private C7809d() {
        }

        /* synthetic */ C7809d(VideoSegmentUI videoSegmentUI, byte b) {
            this();
        }

        public final void run() {
            boolean await;
            AppMethodBeat.m2504i(55052);
            try {
                await = VideoSegmentUI.this.bXQ.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                C4990ab.m7413e("MicroMsg.VideoSegmentUI", "count down latch error %s", e);
                await = false;
            }
            if (await) {
                try {
                    if (!(VideoSegmentUI.this.ozI || VideoSegmentUI.this.isFinishing() || VideoSegmentUI.this.mSurface == null || !VideoSegmentUI.this.mSurface.isValid())) {
                        if (VideoSegmentUI.this.ozD != null) {
                            VideoSegmentUI.this.ozD.mo46476a(null);
                            VideoSegmentUI.this.ozD.mo46479a(null);
                            VideoSegmentUI.this.ozD.release();
                            VideoSegmentUI.this.ozD = null;
                        }
                        try {
                            VideoSegmentUI.m13833a(VideoSegmentUI.this, VideoSegmentUI.this.mSurface);
                            VideoSegmentUI.this.ozD.setSurface(VideoSegmentUI.this.mSurface);
                            C5004al.m7441d(new C78101());
                            AppMethodBeat.m2505o(55052);
                            return;
                        } catch (IOException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "init segmentPlayer second time %s", e2.getMessage());
                            VideoSegmentUI.this.finish();
                            AppMethodBeat.m2505o(55052);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e3, "Finished when init", new Object[0]);
                    VideoSegmentUI.this.finish();
                    AppMethodBeat.m2505o(55052);
                    return;
                }
            }
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(await);
            objArr[1] = Boolean.valueOf(VideoSegmentUI.this.ozI);
            objArr[2] = Boolean.valueOf(VideoSegmentUI.this.isFinishing());
            objArr[3] = Boolean.valueOf(VideoSegmentUI.this.mSurface == null);
            C4990ab.m7421w(str, str2, objArr);
            VideoSegmentUI.this.finish();
            AppMethodBeat.m2505o(55052);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$12 */
    class C781112 implements C12576a {
        C781112() {
        }

        /* renamed from: iY */
        public final void mo17640iY(boolean z) {
            AppMethodBeat.m2504i(55043);
            if (z) {
                Toast.makeText(VideoSegmentUI.this, C25738R.string.d01, 1).show();
                C4990ab.m7412e("MicroMsg.VideoSegmentUI", "Not Supported init SegmentSeekBar failed.");
                VideoSegmentUI.this.ozI = true;
                VideoSegmentUI.this.finish();
                VideoSegmentUI.m13838b(VideoSegmentUI.this);
                AppMethodBeat.m2505o(55043);
                return;
            }
            if (!(VideoSegmentUI.this.isFinishing() || VideoSegmentUI.this.ozF == null)) {
                VideoSegmentUI.this.fPW = VideoSegmentUI.this.ozF.getDurationMs();
                C4990ab.m7417i("MicroMsg.VideoSegmentUI", "SeekBar.onPrepared success %d", Integer.valueOf(VideoSegmentUI.this.fPW));
                try {
                    if (VideoSegmentUI.this.ozD != null) {
                        VideoSegmentUI.this.ozD.setLoop((int) (((float) VideoSegmentUI.this.fPW) * VideoSegmentUI.this.ozF.bQa()), (int) (((float) VideoSegmentUI.this.fPW) * VideoSegmentUI.this.ozF.bQb()));
                    }
                } catch (Exception e) {
                }
            }
            VideoSegmentUI.this.bXQ.countDown();
            AppMethodBeat.m2505o(55043);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$1 */
    class C78121 implements Runnable {
        C78121() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55027);
            C4990ab.m7416i("MicroMsg.VideoSegmentUI", "has connect");
            if (CaptureMMProxy.getInstance() != null) {
                C1427q.m3050ku(CaptureMMProxy.getInstance().getDeviceInfoConfig());
            }
            VideoSegmentUI.m13832a(VideoSegmentUI.this);
            AppMethodBeat.m2505o(55027);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI$3 */
    class C78133 implements C41298a {
        private Runnable ozO;

        C78133() {
        }

        /* renamed from: yY */
        public final void mo17642yY(int i) {
            AppMethodBeat.m2504i(55032);
            if (VideoSegmentUI.this.ozF == null) {
                AppMethodBeat.m2505o(55032);
                return;
            }
            if (this.ozO != null) {
                ((View) VideoSegmentUI.this.ozF).removeCallbacks(this.ozO);
            }
            this.ozO = new C7803c(VideoSegmentUI.this.ozF, i, VideoSegmentUI.this.fPW);
            ((View) VideoSegmentUI.this.ozF).post(this.ozO);
            AppMethodBeat.m2505o(55032);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VideoSegmentUI() {
        AppMethodBeat.m2504i(55053);
        AppMethodBeat.m2505o(55053);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(55054);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        this.ext.connect(new C78121());
        AppMethodBeat.m2505o(55054);
    }

    public final void initView() {
        AppMethodBeat.m2504i(55055);
        this.ozF = (C12575c) findViewById(2131828431);
        this.mmW = (RelativeLayout) findViewById(2131820987);
        AppMethodBeat.m2505o(55055);
    }

    /* renamed from: a */
    private void m13835a(boolean z, Surface surface) {
        AppMethodBeat.m2504i(55056);
        if (this.ozD != null) {
            C4990ab.m7412e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
            AppMethodBeat.m2505o(55056);
            return;
        }
        this.ozD = new C41297c();
        this.ozE = false;
        this.ozD.setDataSource(this.ozB);
        this.ozD.mo46476a(new C78059());
        if (z) {
            this.ozD.mo46479a(this.ozM);
        }
        this.ozD.setAudioStreamType(3);
        this.ozD.setLooping(true);
        if (surface != null) {
            this.ozD.setSurface(surface);
        }
        this.ozD.ozL = this.ozL;
        this.ozD.mo46477a(new C780410());
        this.ozD.prepareAsync();
        this.ozD.mo46478a(new C780611());
        AppMethodBeat.m2505o(55056);
    }

    public void onResume() {
        AppMethodBeat.m2504i(55057);
        if (this.ozD != null && this.ozE) {
            C4990ab.m7416i("MicroMsg.VideoSegmentUI", "onResume start player");
            this.ozD.start();
        }
        super.onResume();
        AppMethodBeat.m2505o(55057);
    }

    public void onPause() {
        AppMethodBeat.m2504i(55058);
        if (this.ozD != null) {
            C4990ab.m7416i("MicroMsg.VideoSegmentUI", "onPause pause player");
            this.ozD.pause();
        }
        super.onPause();
        AppMethodBeat.m2505o(55058);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(55059);
        C4990ab.m7416i("MicroMsg.VideoSegmentUI", "onDestroy");
        super.onDestroy();
        getWindow().clearFlags(128);
        this.ext.release();
        if (this.ozF != null) {
            this.ozF.release();
        }
        if (this.ozD != null) {
            this.ozD.release();
        }
        if (this.mSurface != null) {
            this.mSurface.release();
        }
        if (this.ozC != null) {
            this.ozC.release();
        }
        C43305j.owk.mo45830WY();
        AppMethodBeat.m2505o(55059);
    }

    public final int getLayoutId() {
        return 2130970998;
    }

    /* renamed from: a */
    static /* synthetic */ void m13832a(VideoSegmentUI videoSegmentUI) {
        boolean z = false;
        AppMethodBeat.m2504i(55060);
        videoSegmentUI.setBackBtn(new C78025());
        videoSegmentUI.setMMTitle((int) C25738R.string.b8i);
        videoSegmentUI.mo17379a(0, C1338a.m2858an(videoSegmentUI.mController.ylL, C25738R.string.f9142qt), (OnMenuItemClickListener) new C77966(), C5535b.GREEN);
        videoSegmentUI.enableOptionMenu(false);
        Intent intent = videoSegmentUI.getIntent();
        if (intent == null || C5046bo.isNullOrNil(intent.getStringExtra("key_video_path"))) {
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "is Intent null ? %b, is path null ? %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent == null);
            if (intent == null || intent.getStringExtra("key_video_path") == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7413e(str, str2, objArr);
            videoSegmentUI.finish();
            AppMethodBeat.m2505o(55060);
            return;
        }
        videoSegmentUI.ozB = intent.getStringExtra("key_video_path");
        C4990ab.m7417i("MicroMsg.VideoSegmentUI", "selectVideoPath: %s", videoSegmentUI.ozB);
        if (videoSegmentUI.ozB == null || videoSegmentUI.ozB.length() == 0) {
            C4990ab.m7412e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            AppMethodBeat.m2505o(55060);
            return;
        }
        videoSegmentUI.initView();
        try {
            videoSegmentUI.m13835a(true, null);
            videoSegmentUI.ozF.setOnPreparedListener(new C781112());
            videoSegmentUI.ozF.setThumbBarSeekListener(videoSegmentUI.ozK);
            videoSegmentUI.ozF.mo24502RO(videoSegmentUI.ozB);
            videoSegmentUI.ozC = new C43315q();
            C7305d.m12299g(new C7809d(videoSegmentUI, (byte) 0), "waiting_for_component_prepared.");
            AppMethodBeat.m2505o(55060);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "MediaPlayer set data source error : [%s]", e.getMessage());
            videoSegmentUI.finish();
            AppMethodBeat.m2505o(55060);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m13838b(VideoSegmentUI videoSegmentUI) {
        AppMethodBeat.m2504i(55061);
        int i = 0;
        while (true) {
            try {
                if (((long) i) < videoSegmentUI.bXQ.getCount()) {
                    videoSegmentUI.bXQ.countDown();
                    i++;
                } else {
                    AppMethodBeat.m2505o(55061);
                    return;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.VideoSegmentUI", "ensureNotWaiting e : %s", e);
                AppMethodBeat.m2505o(55061);
                return;
            }
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m13839c(VideoSegmentUI videoSegmentUI) {
        AppMethodBeat.m2504i(55062);
        String accVideoPath = CaptureMMProxy.getInstance().getAccVideoPath();
        long currentTimeMillis = System.currentTimeMillis();
        final String str = "vsg_output_" + currentTimeMillis + VideoMaterialUtil.MP4_SUFFIX;
        final String str2 = "vsg_thumb_" + currentTimeMillis + FileUtils.PIC_POSTFIX_JPEG;
        videoSegmentUI.lis = accVideoPath + str;
        videoSegmentUI.thumbPath = accVideoPath + str2;
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(55039);
                List<C5712a> cl = C5730e.m8627cl(CaptureMMProxy.getInstance().getAccVideoPath(), false);
                if (cl == null) {
                    AppMethodBeat.m2505o(55039);
                    return;
                }
                for (C5712a c5712a : cl) {
                    if (c5712a.name != null && ((c5712a.name.startsWith("vsg_output_") && !c5712a.name.equals(str)) || (c5712a.name.startsWith("vsg_thumb_") && !c5712a.name.equals(str2)))) {
                        c5712a.delete();
                    }
                }
                AppMethodBeat.m2505o(55039);
            }
        }, "delete_old_temp_video_file");
        if (C5046bo.isNullOrNil(videoSegmentUI.lis) || C5046bo.isNullOrNil(videoSegmentUI.thumbPath)) {
            C4990ab.m7412e("MicroMsg.VideoSegmentUI", "Create output file failed.");
            AppMethodBeat.m2505o(55062);
            return;
        }
        videoSegmentUI.ouc = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        if (videoSegmentUI.ouc == null) {
            C4990ab.m7412e("MicroMsg.VideoSegmentUI", "VideoTransPara not provided.");
            AppMethodBeat.m2505o(55062);
        } else if (videoSegmentUI.ozB == null) {
            C4990ab.m7412e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            AppMethodBeat.m2505o(55062);
        } else if (videoSegmentUI.bXQ.getCount() != 0) {
            C4990ab.m7412e("MicroMsg.VideoSegmentUI", "Not prepared right now, please try again.");
            AppMethodBeat.m2505o(55062);
        } else {
            C4990ab.m7416i("MicroMsg.VideoSegmentUI", "Start to process video");
            videoSegmentUI.getString(C25738R.string.f9238tz);
            videoSegmentUI.ehJ = C30379h.m48458b((Context) videoSegmentUI, videoSegmentUI.getString(C25738R.string.f9260un), false, null);
            videoSegmentUI.ozF.mo24506iX(true);
            C7305d.post(new C77977(), "clip_video");
            AppMethodBeat.m2505o(55062);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m13834a(VideoSegmentUI videoSegmentUI, boolean z, String str) {
        AppMethodBeat.m2504i(55063);
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("K_SEGMENTVIDEOPATH", videoSegmentUI.lis);
            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", videoSegmentUI.thumbPath);
            videoSegmentUI.setResult(-1, intent);
            videoSegmentUI.finish();
            AppMethodBeat.m2505o(55063);
            return;
        }
        C4990ab.m7413e("MicroMsg.VideoSegmentUI", "Clip not success. %s", str);
        AppMethodBeat.m2505o(55063);
    }
}
