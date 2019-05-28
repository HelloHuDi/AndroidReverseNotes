package com.tencent.youtu.ytposedetect.jni;

public class YTPoseDetectJNIInterface {
    public static native byte[] getBestImage();

    public static native byte[][] getFrameList();

    public static native int getFrameNum();

    public static native int initModel(String str);

    public static native boolean isRecordingDone();

    public static native int poseDetect(float[] fArr, int i, byte[] bArr, int i2, int i3, int i4, float f, float f2, float f3);

    public static native void releaseAll();

    public static native void setFrameNum(int i);
}
