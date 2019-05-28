package com.tencent.mm.plugin.facedetectaction.b;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceDetectResult;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;

public final class a {
    public int hGq;
    public Camera mCamera;
    public Context mContext;
    public int mDesiredPreviewHeight;
    public int mDesiredPreviewWidth;
    public int mbW;
    public String mbX;
    public FaceActionUI mbY;
    public TextView mbZ;
    public a mca;
    public Rect mcb;
    public Rect mcc;
    int mcd;
    int mce;
    float mcf;
    float mcg;
    public FaceTraceingNotice mch;
    public FaceDetectResult mci;

    public interface a {
        void a(FaceStatus faceStatus, byte[] bArr);
    }

    public static class b {
        private static a mcl = new a();

        static {
            AppMethodBeat.i(681);
            AppMethodBeat.o(681);
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
    }
}
