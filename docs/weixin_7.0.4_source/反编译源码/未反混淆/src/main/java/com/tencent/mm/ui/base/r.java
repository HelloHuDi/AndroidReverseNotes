package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@TargetApi(16)
final class r extends SurfaceTexture {
    public SurfaceTexture mSurfaceTexture = null;

    public r() {
        super(0);
    }

    public final void setOnFrameAvailableListener(OnFrameAvailableListener onFrameAvailableListener) {
        AppMethodBeat.i(106797);
        ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
        this.mSurfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
        AppMethodBeat.o(106797);
    }

    public final void setDefaultBufferSize(int i, int i2) {
        AppMethodBeat.i(106798);
        ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
        this.mSurfaceTexture.setDefaultBufferSize(i, i2);
        AppMethodBeat.o(106798);
    }

    public final void updateTexImage() {
        AppMethodBeat.i(106799);
        ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
        this.mSurfaceTexture.updateTexImage();
        AppMethodBeat.o(106799);
    }

    public final void detachFromGLContext() {
        boolean z;
        String str;
        AppMethodBeat.i(106800);
        ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
        try {
            this.mSurfaceTexture.detachFromGLContext();
            z = false;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e, "%s", "detect texture problem, RuntimeException detachFromGLContext");
            z = true;
        }
        if (z) {
            String str2;
            try {
                Method declaredMethod = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = abm() + " detect texture problem error code = " + ((Integer) declaredMethod.invoke(this.mSurfaceTexture, new Object[0])).intValue() + ", detach = true, and error = " + z;
                b.A(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                ab.w("MicroMsg.MMSurfaceTextureWrap", str2);
                ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(r0), Boolean.TRUE, Boolean.valueOf(z));
                AppMethodBeat.o(106800);
            } catch (IllegalArgumentException e2) {
                ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e2, "%s", "detect texture problem, IllegalArgumentException");
                str = abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                ab.w("MicroMsg.MMSurfaceTextureWrap", str);
                ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(106800);
            } catch (IllegalAccessException e3) {
                ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e3, "%s", "detect texture problem, IllegalAccessException");
                str = abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                ab.w("MicroMsg.MMSurfaceTextureWrap", str);
                ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(106800);
            } catch (InvocationTargetException e4) {
                ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e4, "%s", "detect texture problem, InvocationTargetException");
                str = abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                ab.w("MicroMsg.MMSurfaceTextureWrap", str);
                ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(106800);
            } catch (NoSuchMethodException e5) {
                ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e5, "%s", "detect texture problem, NoSuchMethodException");
                str = abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                ab.w("MicroMsg.MMSurfaceTextureWrap", str);
                ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(106800);
            } catch (Exception e6) {
                ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e6, "%s", "detect texture problem, Exception");
                str = abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                ab.w("MicroMsg.MMSurfaceTextureWrap", str);
                ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(106800);
            } catch (Throwable th) {
                str2 = abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                b.A(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                ab.w("MicroMsg.MMSurfaceTextureWrap", str2);
                ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(106800);
            }
        } else {
            AppMethodBeat.o(106800);
        }
    }

    private static String abm() {
        Object format;
        String format2;
        AppMethodBeat.i(106801);
        StringBuilder stringBuilder = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ah.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + f.REV);
        stringBuilderPrinter.println("#accinfo.build=" + f.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + f.HOSTNAME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + g.cdf);
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Thread.currentThread().getName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + b.xxv);
        String str = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.eSl);
            format2 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), e.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            ab.e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", e.getMessage());
            format2 = str;
        }
        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(format2)));
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        format2 = stringBuilder.toString();
        AppMethodBeat.o(106801);
        return format2;
    }

    public final void attachToGLContext(int i) {
        AppMethodBeat.i(106802);
        ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
        this.mSurfaceTexture.attachToGLContext(i);
        AppMethodBeat.o(106802);
    }

    public final void getTransformMatrix(float[] fArr) {
        AppMethodBeat.i(106803);
        ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
        this.mSurfaceTexture.getTransformMatrix(fArr);
        AppMethodBeat.o(106803);
    }

    public final long getTimestamp() {
        AppMethodBeat.i(106804);
        ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
        long timestamp = this.mSurfaceTexture.getTimestamp();
        AppMethodBeat.o(106804);
        return timestamp;
    }

    public final void release() {
        AppMethodBeat.i(106805);
        super.release();
        ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
        this.mSurfaceTexture.release();
        AppMethodBeat.o(106805);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(106806);
        boolean equals = this.mSurfaceTexture.equals(obj);
        AppMethodBeat.o(106806);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.i(106807);
        int hashCode = this.mSurfaceTexture.hashCode();
        AppMethodBeat.o(106807);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(106808);
        String obj = this.mSurfaceTexture.toString();
        AppMethodBeat.o(106808);
        return obj;
    }

    @TargetApi(19)
    public final void releaseTexImage() {
        AppMethodBeat.i(106809);
        ab.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
        this.mSurfaceTexture.releaseTexImage();
        AppMethodBeat.o(106809);
    }
}
