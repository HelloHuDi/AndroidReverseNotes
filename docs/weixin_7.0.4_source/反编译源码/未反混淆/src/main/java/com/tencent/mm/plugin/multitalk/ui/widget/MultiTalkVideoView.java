package com.tencent.mm.plugin.multitalk.ui.widget;

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
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;

public class MultiTalkVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] oJj = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private SurfaceTexture bsb;
    private int fcn;
    private int fco;
    private int index;
    private Paint oJk;
    private a oJl = a.None;
    private int position;
    private String username;

    public enum a {
        Avatar,
        Video,
        None;

        static {
            AppMethodBeat.o(54227);
        }
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(54228);
        initView();
        AppMethodBeat.o(54228);
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(54229);
        initView();
        AppMethodBeat.o(54229);
    }

    private void initView() {
        AppMethodBeat.i(54230);
        this.oJk = new Paint();
        this.oJk.setColor(WebView.NIGHT_MODE_COLOR);
        this.oJk.setFilterBitmap(false);
        this.oJk.setTextSize(40.0f);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(54230);
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

    public final synchronized void b(int[] iArr, int i, int i2, int i3) {
        AppMethodBeat.i(54231);
        if (bSw()) {
            p.bSg().a(this, iArr, i, i2, i3);
            AppMethodBeat.o(54231);
        } else {
            AppMethodBeat.o(54231);
        }
    }

    public final synchronized void d(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.i(54232);
        if (bitmap == null || bitmap.isRecycled()) {
            ab.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
            AppMethodBeat.o(54232);
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (this.bsb == null || this.fcn == 0 || this.fco == 0) {
                AppMethodBeat.o(54232);
            } else {
                Canvas lockCanvas = lockCanvas(null);
                if (lockCanvas == null) {
                    ab.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", this.username);
                    AppMethodBeat.o(54232);
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
                        AppMethodBeat.o(54232);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                        AppMethodBeat.o(54232);
                    }
                }
            }
        }
    }

    public final void bSq() {
        AppMethodBeat.i(54233);
        if (bSv()) {
            p.bSg().a(this, true);
        }
        AppMethodBeat.o(54233);
    }

    public final void bSr() {
        AppMethodBeat.i(54234);
        if (bo.isNullOrNil(getUsername())) {
            AppMethodBeat.o(54234);
            return;
        }
        ab.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", getUsername(), this.oJl.name());
        this.oJl = a.Avatar;
        bSq();
        AppMethodBeat.o(54234);
    }

    public final void bSs() {
        AppMethodBeat.i(54235);
        ab.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", getUsername(), this.oJl.name());
        this.oJl = a.Video;
        AppMethodBeat.o(54235);
    }

    public final void bSt() {
        AppMethodBeat.i(54236);
        ab.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", getUsername(), this.oJl.name());
        this.oJl = a.None;
        this.username = null;
        bSu();
        AppMethodBeat.o(54236);
    }

    private void bSu() {
        AppMethodBeat.i(54237);
        if (this.bsb == null || this.fcn == 0 || this.fco == 0) {
            AppMethodBeat.o(54237);
            return;
        }
        Canvas lockCanvas = lockCanvas(null);
        if (lockCanvas == null) {
            ab.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
            AppMethodBeat.o(54237);
            return;
        }
        lockCanvas.drawColor(0, Mode.CLEAR);
        lockCanvas.drawColor(-14737113);
        lockCanvas.drawColor(oJj[this.index]);
        try {
            unlockCanvasAndPost(lockCanvas);
            AppMethodBeat.o(54237);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawNone unlockCanvasAndPost crash", new Object[0]);
            AppMethodBeat.o(54237);
        }
    }

    public final void Sr(String str) {
        AppMethodBeat.i(54238);
        ab.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", this.username, str);
        this.username = str;
        AppMethodBeat.o(54238);
    }

    public final void refreshView() {
        AppMethodBeat.i(54239);
        if (bSv()) {
            p.bSg().a(this, false);
            AppMethodBeat.o(54239);
        } else if (bSw()) {
            com.tencent.mm.plugin.multitalk.model.m.a aVar = (com.tencent.mm.plugin.multitalk.model.m.a) p.bSg().oHq.get(getUsername());
            Bitmap bitmap = aVar != null ? aVar.oHs : null;
            if (bitmap != null) {
                d(bitmap, aVar.angle, aVar.oHb);
            }
            AppMethodBeat.o(54239);
        } else {
            bSu();
            AppMethodBeat.o(54239);
        }
    }

    private boolean bSv() {
        return this.oJl == a.Avatar;
    }

    public final boolean bSw() {
        return this.oJl == a.Video;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        AppMethodBeat.i(54240);
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
        ab.i(str, str2, objArr);
        this.bsb = surfaceTexture;
        this.fcn = i;
        this.fco = i2;
        dAh();
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54223);
                MultiTalkVideoView.this.refreshView();
                AppMethodBeat.o(54223);
            }
        }, "onSurfaceTextureAvailable_refreshView");
        AppMethodBeat.o(54240);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        AppMethodBeat.i(54241);
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
        ab.i(str, str2, objArr);
        this.fcn = i;
        this.fco = i2;
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(54224);
                MultiTalkVideoView.this.refreshView();
                AppMethodBeat.o(54224);
            }
        }, "onSurfaceTextureSizeChanged_refreshView");
        AppMethodBeat.o(54241);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z;
        AppMethodBeat.i(54242);
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
        ab.i(str, str2, objArr);
        this.bsb = null;
        this.fco = 0;
        this.fcn = 0;
        AppMethodBeat.o(54242);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = false;
        AppMethodBeat.i(54243);
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureUpdated %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        ab.v(str, str2, objArr);
        AppMethodBeat.o(54243);
    }
}
