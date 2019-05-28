package com.tencent.p177mm.p612ui.base;

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
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@TargetApi(16)
/* renamed from: com.tencent.mm.ui.base.r */
final class C23637r extends SurfaceTexture {
    public SurfaceTexture mSurfaceTexture = null;

    public C23637r() {
        super(0);
    }

    public final void setOnFrameAvailableListener(OnFrameAvailableListener onFrameAvailableListener) {
        AppMethodBeat.m2504i(106797);
        C4990ab.m7416i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
        this.mSurfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
        AppMethodBeat.m2505o(106797);
    }

    public final void setDefaultBufferSize(int i, int i2) {
        AppMethodBeat.m2504i(106798);
        C4990ab.m7416i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
        this.mSurfaceTexture.setDefaultBufferSize(i, i2);
        AppMethodBeat.m2505o(106798);
    }

    public final void updateTexImage() {
        AppMethodBeat.m2504i(106799);
        C4990ab.m7416i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
        this.mSurfaceTexture.updateTexImage();
        AppMethodBeat.m2505o(106799);
    }

    public final void detachFromGLContext() {
        boolean z;
        String str;
        AppMethodBeat.m2504i(106800);
        C4990ab.m7416i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
        try {
            this.mSurfaceTexture.detachFromGLContext();
            z = false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e, "%s", "detect texture problem, RuntimeException detachFromGLContext");
            z = true;
        }
        if (z) {
            String str2;
            try {
                Method declaredMethod = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = C23637r.abm() + " detect texture problem error code = " + ((Integer) declaredMethod.invoke(this.mSurfaceTexture, new Object[0])).intValue() + ", detach = true, and error = " + z;
                C4872b.m7233A(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                C4990ab.m7420w("MicroMsg.MMSurfaceTextureWrap", str2);
                C4990ab.m7417i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(r0), Boolean.TRUE, Boolean.valueOf(z));
                AppMethodBeat.m2505o(106800);
            } catch (IllegalArgumentException e2) {
                C4990ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e2, "%s", "detect texture problem, IllegalArgumentException");
                str = C23637r.abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                C4872b.m7233A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                C4990ab.m7420w("MicroMsg.MMSurfaceTextureWrap", str);
                C4990ab.m7417i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.m2505o(106800);
            } catch (IllegalAccessException e3) {
                C4990ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e3, "%s", "detect texture problem, IllegalAccessException");
                str = C23637r.abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                C4872b.m7233A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                C4990ab.m7420w("MicroMsg.MMSurfaceTextureWrap", str);
                C4990ab.m7417i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.m2505o(106800);
            } catch (InvocationTargetException e4) {
                C4990ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e4, "%s", "detect texture problem, InvocationTargetException");
                str = C23637r.abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                C4872b.m7233A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                C4990ab.m7420w("MicroMsg.MMSurfaceTextureWrap", str);
                C4990ab.m7417i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.m2505o(106800);
            } catch (NoSuchMethodException e5) {
                C4990ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e5, "%s", "detect texture problem, NoSuchMethodException");
                str = C23637r.abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                C4872b.m7233A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                C4990ab.m7420w("MicroMsg.MMSurfaceTextureWrap", str);
                C4990ab.m7417i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.m2505o(106800);
            } catch (Exception e6) {
                C4990ab.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e6, "%s", "detect texture problem, Exception");
                str = C23637r.abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                C4872b.m7233A(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                C4990ab.m7420w("MicroMsg.MMSurfaceTextureWrap", str);
                C4990ab.m7417i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.m2505o(106800);
            } catch (Throwable th) {
                str2 = C23637r.abm() + " detect texture problem error code = 0, detach = false, and error = " + z;
                C4872b.m7233A(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                C4990ab.m7420w("MicroMsg.MMSurfaceTextureWrap", str2);
                C4990ab.m7417i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.m2505o(106800);
            }
        } else {
            AppMethodBeat.m2505o(106800);
        }
    }

    private static String abm() {
        Object format;
        String format2;
        AppMethodBeat.m2504i(106801);
        StringBuilder stringBuilder = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = C4996ah.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + C5058f.REV);
        stringBuilderPrinter.println("#accinfo.build=" + C5058f.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C5058f.HOSTNAME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C5059g.cdf);
        stringBuilderPrinter.println("#accinfo.env=" + (C4872b.foreground ? "f" : "b") + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Thread.currentThread().getName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C4872b.xxv);
        String str = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(C6457e.eSl);
            format2 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), C6457e.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", e.getMessage());
            format2 = str;
        }
        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(format2)));
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        format2 = stringBuilder.toString();
        AppMethodBeat.m2505o(106801);
        return format2;
    }

    public final void attachToGLContext(int i) {
        AppMethodBeat.m2504i(106802);
        C4990ab.m7416i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
        this.mSurfaceTexture.attachToGLContext(i);
        AppMethodBeat.m2505o(106802);
    }

    public final void getTransformMatrix(float[] fArr) {
        AppMethodBeat.m2504i(106803);
        C4990ab.m7416i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
        this.mSurfaceTexture.getTransformMatrix(fArr);
        AppMethodBeat.m2505o(106803);
    }

    public final long getTimestamp() {
        AppMethodBeat.m2504i(106804);
        C4990ab.m7416i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
        long timestamp = this.mSurfaceTexture.getTimestamp();
        AppMethodBeat.m2505o(106804);
        return timestamp;
    }

    public final void release() {
        AppMethodBeat.m2504i(106805);
        super.release();
        C4990ab.m7416i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
        this.mSurfaceTexture.release();
        AppMethodBeat.m2505o(106805);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(106806);
        boolean equals = this.mSurfaceTexture.equals(obj);
        AppMethodBeat.m2505o(106806);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(106807);
        int hashCode = this.mSurfaceTexture.hashCode();
        AppMethodBeat.m2505o(106807);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(106808);
        String obj = this.mSurfaceTexture.toString();
        AppMethodBeat.m2505o(106808);
        return obj;
    }

    @TargetApi(19)
    public final void releaseTexImage() {
        AppMethodBeat.m2504i(106809);
        C4990ab.m7416i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
        this.mSurfaceTexture.releaseTexImage();
        AppMethodBeat.m2505o(106809);
    }
}
