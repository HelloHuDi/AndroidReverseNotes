package com.tencent.mm.media.widget.a;

import a.l;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006 "}, dWq = {"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"})
public final class b {
    private static int aIV;
    private static int aIW;
    private static int eYR;
    private static int faC;
    private static int faD;
    private static boolean faE;
    public static final b faF = new b();
    private static boolean isFrontCamera;

    static {
        AppMethodBeat.i(13188);
        AppMethodBeat.o(13188);
    }

    private b() {
    }

    public static int getPreviewHeight() {
        return aIW;
    }

    public static void kd(int i) {
        aIW = i;
    }

    public static int getPreviewWidth() {
        return aIV;
    }

    public static void ke(int i) {
        aIV = i;
    }

    public static int Wi() {
        return eYR;
    }

    public static void kf(int i) {
        eYR = i;
    }

    public static int Wj() {
        return faC;
    }

    public static void kg(int i) {
        faC = i;
    }

    public static int Wk() {
        return faD;
    }

    public static void kh(int i) {
        faD = i;
    }

    public static boolean Wl() {
        return isFrontCamera;
    }

    public static void setFrontCamera(boolean z) {
        isFrontCamera = z;
    }

    public static void cu(boolean z) {
        faE = z;
    }

    public final String toString() {
        AppMethodBeat.i(13186);
        String str = "previewHeight: " + aIW + " ,previewWidth:" + aIV + " ,rotateDegree: " + eYR + " ,isFrontCamera:" + isFrontCamera + ' ' + " encodeVideoBestSizeWidth : " + faC + " , encodeVideoBestSizeHeight : " + faD + ", isCpuCrop: " + faE + ' ';
        AppMethodBeat.o(13186);
        return str;
    }

    public static Point Wm() {
        AppMethodBeat.i(13187);
        Point point = new Point(aIV, aIW);
        AppMethodBeat.o(13187);
        return point;
    }
}
