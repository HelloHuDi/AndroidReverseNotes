package com.tencent.magicbrush.handler;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.magicbrush.p149c.C1006b;
import com.tencent.magicbrush.p821d.C37415c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public class MBCanvasHandler {
    public final MBRuntime bSv;
    public final long mNativeInst;

    /* renamed from: com.tencent.magicbrush.handler.MBCanvasHandler$3 */
    public class C10083 implements Callable<Bitmap> {
        final /* synthetic */ int bSN;

        public C10083(int i) {
            this.bSN = i;
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.m2504i(115892);
            if (MBCanvasHandler.this.bSv.isDestroyedUnlock()) {
                AppMethodBeat.m2505o(115892);
                return null;
            }
            Object a = MBCanvasHandler.m2275a(MBCanvasHandler.this, MBCanvasHandler.this.mNativeInst, this.bSN);
            AppMethodBeat.m2505o(115892);
            return a;
        }
    }

    public native Bitmap nativeCaptureCanvas(long j, int i);

    /* renamed from: a */
    static /* synthetic */ Bitmap m2275a(MBCanvasHandler mBCanvasHandler, long j, int i) {
        AppMethodBeat.m2504i(115895);
        Bitmap nativeCaptureCanvas = mBCanvasHandler.nativeCaptureCanvas(j, i);
        AppMethodBeat.m2505o(115895);
        return nativeCaptureCanvas;
    }

    public MBCanvasHandler(MBRuntime mBRuntime, long j) {
        this.bSv = mBRuntime;
        this.mNativeInst = j;
    }

    /* renamed from: a */
    public final Bitmap mo4006a(final Bitmap bitmap, boolean z) {
        AppMethodBeat.m2504i(115893);
        final C1006b mBRuntimeView = this.bSv.getMBRuntimeView();
        if (mBRuntimeView == null) {
            C17837c.m27916i("MicroMsg.MBCanvasHandler", "MBRuntimeView is null.", new Object[0]);
            AppMethodBeat.m2505o(115893);
            return null;
        }
        final int[] u = m2278u(this.bSv.getScreenCanvasId(), z);
        Bitmap bitmap2 = (Bitmap) C37415c.m63044b(new Callable<Bitmap>() {
            public final /* synthetic */ Object call() {
                AppMethodBeat.m2504i(115890);
                if (MBCanvasHandler.this.bSv.isDestroyedUnlock() || !mBRuntimeView.isAvailable()) {
                    AppMethodBeat.m2505o(115890);
                    return null;
                } else if (u == null || u[0] <= 0 || u[1] <= 0) {
                    AppMethodBeat.m2505o(115890);
                    return null;
                } else {
                    Bitmap bitmap = bitmap;
                    if (!(bitmap != null && bitmap.getWidth() == u[0] && bitmap.getHeight() == u[1])) {
                        bitmap = Bitmap.createBitmap(u[0], u[1], Config.ARGB_8888);
                    }
                    Object bitmap2 = mBRuntimeView.getBitmap(bitmap);
                    AppMethodBeat.m2505o(115890);
                    return bitmap2;
                }
            }
        });
        AppMethodBeat.m2505o(115893);
        return bitmap2;
    }

    /* renamed from: u */
    private int[] m2278u(final int i, boolean z) {
        AppMethodBeat.m2504i(115894);
        int[] canvasSize;
        if (z) {
            canvasSize = this.bSv.getCanvasSize(i);
            AppMethodBeat.m2505o(115894);
            return canvasSize;
        }
        MBJsThreadHandler jsThreadHandler = this.bSv.getJsThreadHandler();
        if (jsThreadHandler == null) {
            AppMethodBeat.m2505o(115894);
            return null;
        }
        canvasSize = (int[]) jsThreadHandler.mo41497a(new Callable<int[]>() {
            public final /* synthetic */ Object call() {
                AppMethodBeat.m2504i(115891);
                int[] canvasSize = MBCanvasHandler.this.bSv.getCanvasSize(i);
                AppMethodBeat.m2505o(115891);
                return canvasSize;
            }
        });
        AppMethodBeat.m2505o(115894);
        return canvasSize;
    }
}
