package com.tencent.p177mm.media.widget.p868a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006 "}, dWq = {"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.a.b */
public final class C32765b {
    private static int aIV;
    private static int aIW;
    private static int eYR;
    private static int faC;
    private static int faD;
    private static boolean faE;
    public static final C32765b faF = new C32765b();
    private static boolean isFrontCamera;

    static {
        AppMethodBeat.m2504i(13188);
        AppMethodBeat.m2505o(13188);
    }

    private C32765b() {
    }

    public static int getPreviewHeight() {
        return aIW;
    }

    /* renamed from: kd */
    public static void m53508kd(int i) {
        aIW = i;
    }

    public static int getPreviewWidth() {
        return aIV;
    }

    /* renamed from: ke */
    public static void m53509ke(int i) {
        aIV = i;
    }

    /* renamed from: Wi */
    public static int m53502Wi() {
        return eYR;
    }

    /* renamed from: kf */
    public static void m53510kf(int i) {
        eYR = i;
    }

    /* renamed from: Wj */
    public static int m53503Wj() {
        return faC;
    }

    /* renamed from: kg */
    public static void m53511kg(int i) {
        faC = i;
    }

    /* renamed from: Wk */
    public static int m53504Wk() {
        return faD;
    }

    /* renamed from: kh */
    public static void m53512kh(int i) {
        faD = i;
    }

    /* renamed from: Wl */
    public static boolean m53505Wl() {
        return isFrontCamera;
    }

    public static void setFrontCamera(boolean z) {
        isFrontCamera = z;
    }

    /* renamed from: cu */
    public static void m53507cu(boolean z) {
        faE = z;
    }

    public final String toString() {
        AppMethodBeat.m2504i(13186);
        String str = "previewHeight: " + aIW + " ,previewWidth:" + aIV + " ,rotateDegree: " + eYR + " ,isFrontCamera:" + isFrontCamera + ' ' + " encodeVideoBestSizeWidth : " + faC + " , encodeVideoBestSizeHeight : " + faD + ", isCpuCrop: " + faE + ' ';
        AppMethodBeat.m2505o(13186);
        return str;
    }

    /* renamed from: Wm */
    public static Point m53506Wm() {
        AppMethodBeat.m2504i(13187);
        Point point = new Point(aIV, aIW);
        AppMethodBeat.m2505o(13187);
        return point;
    }
}
