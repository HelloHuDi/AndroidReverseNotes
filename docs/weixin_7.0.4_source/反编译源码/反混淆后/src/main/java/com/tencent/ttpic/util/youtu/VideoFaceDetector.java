package com.tencent.ttpic.util.youtu;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VError;
import com.tencent.ttpic.facedetect.FaceStatus;
import java.nio.ByteBuffer;

public class VideoFaceDetector {
    private static final String TAG = VideoFaceDetector.class.getSimpleName();
    private long mNativeObjPtr;

    private native boolean nativeConstructor();

    private native void nativeDestructor();

    private native void nativeFaceDetect(byte[] bArr, int i, int i2);

    private native void nativeFaceDetect3D(byte[] bArr, int i, int i2);

    private native void nativeFaceDetectByY(byte[] bArr, int i, int i2);

    public native FaceStatus[] nativeDoTrack(byte[] bArr, int i, int i2);

    public native FaceStatus[] nativeDoTrack3D(byte[] bArr, int i, int i2, float f);

    static {
        AppMethodBeat.m2504i(84379);
        AppMethodBeat.m2505o(84379);
    }

    public int init() {
        AppMethodBeat.m2504i(84372);
        int initFaceTrack = YTFaceDetectorBase.getInstance().initFaceTrack();
        if (initFaceTrack != 0) {
            AppMethodBeat.m2505o(84372);
            return initFaceTrack;
        } else if (nativeConstructor()) {
            AppMethodBeat.m2505o(84372);
            return 0;
        } else {
            AppMethodBeat.m2505o(84372);
            return VError.ERROR_DETECTOR_INSTANCE_INIT;
        }
    }

    public void destroy() {
        AppMethodBeat.m2504i(84373);
        nativeDestructor();
        AppMethodBeat.m2505o(84373);
    }

    public FaceStatus[] doTrack3D(byte[] bArr, int i, int i2, float f) {
        AppMethodBeat.m2504i(84374);
        FaceStatus[] nativeDoTrack3D = nativeDoTrack3D(bArr, i, i2, f);
        AppMethodBeat.m2505o(84374);
        return nativeDoTrack3D;
    }

    public FaceStatus[] doTrack(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(84375);
        FaceStatus[] nativeDoTrack = nativeDoTrack(bArr, i, i2);
        AppMethodBeat.m2505o(84375);
        return nativeDoTrack;
    }

    public static Bitmap getBitmap(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(84376);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        AppMethodBeat.m2505o(84376);
        return createBitmap;
    }

    public void doFaceDetect(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(84377);
        nativeFaceDetect(bArr, i, i2);
        AppMethodBeat.m2505o(84377);
    }

    public void doFaceDetectByY(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(84378);
        nativeFaceDetectByY(bArr, i, i2);
        AppMethodBeat.m2505o(84378);
    }
}
