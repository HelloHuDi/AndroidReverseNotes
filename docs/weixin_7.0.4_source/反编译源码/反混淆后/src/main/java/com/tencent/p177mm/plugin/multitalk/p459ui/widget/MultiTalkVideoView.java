package com.tencent.p177mm.plugin.multitalk.p459ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.multitalk.model.C34572p;
import com.tencent.p177mm.plugin.multitalk.model.C3516m.C3517a;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView */
public class MultiTalkVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] oJj = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private SurfaceTexture bsb;
    private int fcn;
    private int fco;
    private int index;
    private Paint oJk;
    private C3521a oJl = C3521a.None;
    private int position;
    private String username;

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView$a */
    public enum C3521a {
        Avatar,
        Video,
        None;

        static {
            AppMethodBeat.m2505o(54227);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView$1 */
    class C247991 implements Runnable {
        C247991() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54223);
            MultiTalkVideoView.this.refreshView();
            AppMethodBeat.m2505o(54223);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView$2 */
    class C248002 implements Runnable {
        C248002() {
        }

        public final void run() {
            AppMethodBeat.m2504i(54224);
            MultiTalkVideoView.this.refreshView();
            AppMethodBeat.m2505o(54224);
        }
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(54228);
        initView();
        AppMethodBeat.m2505o(54228);
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(54229);
        initView();
        AppMethodBeat.m2505o(54229);
    }

    private void initView() {
        AppMethodBeat.m2504i(54230);
        this.oJk = new Paint();
        this.oJk.setColor(WebView.NIGHT_MODE_COLOR);
        this.oJk.setFilterBitmap(false);
        this.oJk.setTextSize(40.0f);
        setSurfaceTextureListener(this);
        AppMethodBeat.m2505o(54230);
    }

    public String getUsername() {
        return this.username;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getPosition() {
        return this.position;
    }

    /* renamed from: b */
    public final synchronized void mo41659b(int[] iArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(54231);
        if (bSw()) {
            C34572p.bSg().mo8003a(this, iArr, i, i2, i3);
            AppMethodBeat.m2505o(54231);
        } else {
            AppMethodBeat.m2505o(54231);
        }
    }

    /* renamed from: d */
    public final synchronized void mo41665d(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(54232);
        if (bitmap == null || bitmap.isRecycled()) {
            C4990ab.m7412e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
            AppMethodBeat.m2505o(54232);
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (this.bsb == null || this.fcn == 0 || this.fco == 0) {
                AppMethodBeat.m2505o(54232);
            } else {
                Canvas lockCanvas = lockCanvas(null);
                if (lockCanvas == null) {
                    C4990ab.m7413e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", this.username);
                    AppMethodBeat.m2505o(54232);
                } else {
                    Matrix matrix = new Matrix();
                    if (i == OpenGlRender.FLAG_Angle270) {
                        matrix.setRotate(270.0f, (float) (width / 2), (float) (height / 2));
                    } else if (i == OpenGlRender.FLAG_Angle90) {
                        matrix.setRotate(90.0f, (float) (width / 2), (float) (height / 2));
                    }
                    if (i2 == OpenGlRender.FLAG_Mirror) {
                        matrix.postScale(-1.0f, 1.0f);
                        matrix.postTranslate((float) width, 0.0f);
                    }
                    matrix.postScale(((float) lockCanvas.getWidth()) / ((float) height), ((float) lockCanvas.getHeight()) / ((float) width));
                    lockCanvas.drawColor(0, Mode.CLEAR);
                    if (!bitmap.isRecycled()) {
                        lockCanvas.drawBitmap(bitmap, matrix, this.oJk);
                    }
                    try {
                        unlockCanvasAndPost(lockCanvas);
                        AppMethodBeat.m2505o(54232);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                        AppMethodBeat.m2505o(54232);
                    }
                }
            }
        }
    }

    public final void bSq() {
        AppMethodBeat.m2504i(54233);
        if (bSv()) {
            C34572p.bSg().mo8002a(this, true);
        }
        AppMethodBeat.m2505o(54233);
    }

    public final void bSr() {
        AppMethodBeat.m2504i(54234);
        if (C5046bo.isNullOrNil(getUsername())) {
            AppMethodBeat.m2505o(54234);
            return;
        }
        C4990ab.m7417i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", getUsername(), this.oJl.name());
        this.oJl = C3521a.Avatar;
        bSq();
        AppMethodBeat.m2505o(54234);
    }

    public final void bSs() {
        AppMethodBeat.m2504i(54235);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", getUsername(), this.oJl.name());
        this.oJl = C3521a.Video;
        AppMethodBeat.m2505o(54235);
    }

    public final void bSt() {
        AppMethodBeat.m2504i(54236);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", getUsername(), this.oJl.name());
        this.oJl = C3521a.None;
        this.username = null;
        bSu();
        AppMethodBeat.m2505o(54236);
    }

    private void bSu() {
        AppMethodBeat.m2504i(54237);
        if (this.bsb == null || this.fcn == 0 || this.fco == 0) {
            AppMethodBeat.m2505o(54237);
            return;
        }
        Canvas lockCanvas = lockCanvas(null);
        if (lockCanvas == null) {
            C4990ab.m7412e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
            AppMethodBeat.m2505o(54237);
            return;
        }
        lockCanvas.drawColor(0, Mode.CLEAR);
        lockCanvas.drawColor(-14737113);
        lockCanvas.drawColor(oJj[this.index]);
        try {
            unlockCanvasAndPost(lockCanvas);
            AppMethodBeat.m2505o(54237);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawNone unlockCanvasAndPost crash", new Object[0]);
            AppMethodBeat.m2505o(54237);
        }
    }

    /* renamed from: Sr */
    public final void mo41658Sr(String str) {
        AppMethodBeat.m2504i(54238);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", this.username, str);
        this.username = str;
        AppMethodBeat.m2505o(54238);
    }

    public final void refreshView() {
        AppMethodBeat.m2504i(54239);
        if (bSv()) {
            C34572p.bSg().mo8002a(this, false);
            AppMethodBeat.m2505o(54239);
        } else if (bSw()) {
            C3517a c3517a = (C3517a) C34572p.bSg().oHq.get(getUsername());
            Bitmap bitmap = c3517a != null ? c3517a.oHs : null;
            if (bitmap != null) {
                mo41665d(bitmap, c3517a.angle, c3517a.oHb);
            }
            AppMethodBeat.m2505o(54239);
        } else {
            bSu();
            AppMethodBeat.m2505o(54239);
        }
    }

    private boolean bSv() {
        return this.oJl == C3521a.Avatar;
    }

    public final boolean bSw() {
        return this.oJl == C3521a.Video;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        AppMethodBeat.m2504i(54240);
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureAvailable %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        C4990ab.m7417i(str, str2, objArr);
        this.bsb = surfaceTexture;
        this.fcn = i;
        this.fco = i2;
        dAh();
        C7305d.post(new C247991(), "onSurfaceTextureAvailable_refreshView");
        AppMethodBeat.m2505o(54240);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        AppMethodBeat.m2504i(54241);
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureSizeChanged %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        C4990ab.m7417i(str, str2, objArr);
        this.fcn = i;
        this.fco = i2;
        C7305d.post(new C248002(), "onSurfaceTextureSizeChanged_refreshView");
        AppMethodBeat.m2505o(54241);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z;
        AppMethodBeat.m2504i(54242);
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureDestroyed %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        this.bsb = null;
        this.fco = 0;
        this.fcn = 0;
        AppMethodBeat.m2505o(54242);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = false;
        AppMethodBeat.m2504i(54243);
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureUpdated %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        C4990ab.m7419v(str, str2, objArr);
        AppMethodBeat.m2505o(54243);
    }
}
