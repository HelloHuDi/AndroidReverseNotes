package com.tencent.magicbrush.handler;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public class MBCanvasHandler {
    public final MBRuntime bSv;
    public final long mNativeInst;

    /* renamed from: com.tencent.magicbrush.handler.MBCanvasHandler$3 */
    public class AnonymousClass3 implements Callable<Bitmap> {
        final /* synthetic */ int bSN;

        public AnonymousClass3(int i) {
            this.bSN = i;
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.i(115892);
            if (MBCanvasHandler.this.bSv.isDestroyedUnlock()) {
                AppMethodBeat.o(115892);
                return null;
            }
            Object a = MBCanvasHandler.a(MBCanvasHandler.this, MBCanvasHandler.this.mNativeInst, this.bSN);
            AppMethodBeat.o(115892);
            return a;
        }
    }

    public native Bitmap nativeCaptureCanvas(long j, int i);

    static /* synthetic */ Bitmap a(MBCanvasHandler mBCanvasHandler, long j, int i) {
        AppMethodBeat.i(115895);
        Bitmap nativeCaptureCanvas = mBCanvasHandler.nativeCaptureCanvas(j, i);
        AppMethodBeat.o(115895);
        return nativeCaptureCanvas;
    }

    public MBCanvasHandler(MBRuntime mBRuntime, long j) {
        this.bSv = mBRuntime;
        this.mNativeInst = j;
    }

    public final Bitmap a(final Bitmap bitmap, boolean z) {
        AppMethodBeat.i(115893);
        final b mBRuntimeView = this.bSv.getMBRuntimeView();
        if (mBRuntimeView == null) {
            c.i("MicroMsg.MBCanvasHandler", "MBRuntimeView is null.", new Object[0]);
            AppMethodBeat.o(115893);
            return null;
        }
        final int[] u = u(this.bSv.getScreenCanvasId(), z);
        Bitmap bitmap2 = (Bitmap) com.tencent.magicbrush.d.c.b(new Callable<Bitmap>() {
            public final /* synthetic */ Object call() {
                AppMethodBeat.i(115890);
                if (MBCanvasHandler.this.bSv.isDestroyedUnlock() || !mBRuntimeView.isAvailable()) {
                    AppMethodBeat.o(115890);
                    return null;
                } else if (u == null || u[0] <= 0 || u[1] <= 0) {
                    AppMethodBeat.o(115890);
                    return null;
                } else {
                    Bitmap bitmap = bitmap;
                    if (!(bitmap != null && bitmap.getWidth() == u[0] && bitmap.getHeight() == u[1])) {
                        bitmap = Bitmap.createBitmap(u[0], u[1], Config.ARGB_8888);
                    }
                    Object bitmap2 = mBRuntimeView.getBitmap(bitmap);
                    AppMethodBeat.o(115890);
                    return bitmap2;
                }
            }
        });
        AppMethodBeat.o(115893);
        return bitmap2;
    }

    private int[] u(final int i, boolean z) {
        AppMethodBeat.i(115894);
        int[] canvasSize;
        if (z) {
            canvasSize = this.bSv.getCanvasSize(i);
            AppMethodBeat.o(115894);
            return canvasSize;
        }
        MBJsThreadHandler jsThreadHandler = this.bSv.getJsThreadHandler();
        if (jsThreadHandler == null) {
            AppMethodBeat.o(115894);
            return null;
        }
        canvasSize = (int[]) jsThreadHandler.a(new Callable<int[]>() {
            public final /* synthetic */ Object call() {
                AppMethodBeat.i(115891);
                int[] canvasSize = MBCanvasHandler.this.bSv.getCanvasSize(i);
                AppMethodBeat.o(115891);
                return canvasSize;
            }
        });
        AppMethodBeat.o(115894);
        return canvasSize;
    }
}
