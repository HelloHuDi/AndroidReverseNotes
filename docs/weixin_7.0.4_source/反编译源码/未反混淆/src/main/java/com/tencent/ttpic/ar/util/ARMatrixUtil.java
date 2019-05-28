package com.tencent.ttpic.ar.util;

import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.ar.sensor.orientationProvider.ImprovedOrientationSensor2Provider;
import com.tencent.ttpic.ar.sensor.orientationProvider.OrientationProvider;
import com.tencent.ttpic.ar.sensor.orientationProvider.SimpleOrientationSensorProvider;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.HashSet;

public class ARMatrixUtil {
    private static String[] blackList = new String[]{"XIAOMI_Redmi_Note_2"};
    private static HashSet<String> blackSet = new HashSet();
    public static float cameraRightX;
    public static float cameraRightY;
    public static float cameraRightZ;
    public static float cameraUpX;
    public static float cameraUpY;
    public static float cameraUpZ;
    public static float cameraX;
    public static float cameraY;
    public static float cameraZ;
    private static boolean canUseImprovedSensorProvider = true;
    public static float far;
    public static boolean isFrontCamera;
    private static boolean isInBlackList = false;
    private static boolean isProjectionMatInitialized;
    private static float[] mMVPMatrix = new float[16];
    private static float[] mProjectionMatrix = new float[16];
    private static float[] mViewMatrix = new float[16];
    public static float near;
    public static float nearRectHeight;
    public static float nearRectWidth;
    public static OrientationProvider orientationProvider;
    private static int renderHeight;
    private static int renderWidth;

    static {
        AppMethodBeat.i(81763);
        AppMethodBeat.o(81763);
    }

    public static void setOrientationVector(float f, float f2, float f3, float f4, float f5, float f6) {
        AppMethodBeat.i(81748);
        if (isFrontCamera) {
            f = -f;
        }
        cameraRightX = f;
        if (isFrontCamera) {
            f2 = -f2;
        }
        cameraRightY = f2;
        if (isFrontCamera) {
            f3 = -f3;
        }
        cameraRightZ = f3;
        if (isFrontCamera) {
            f4 = -f4;
        }
        cameraX = f4;
        if (isFrontCamera) {
            f5 = -f5;
        }
        cameraY = f5;
        if (isFrontCamera) {
            f6 = -f6;
        }
        cameraZ = f6;
        float[] vectorNormalization = vectorNormalization(vectorCrossProduct(new float[]{cameraRightX, cameraRightY, cameraRightZ}, new float[]{cameraX, cameraY, cameraZ}));
        cameraUpX = vectorNormalization[0];
        cameraUpY = vectorNormalization[1];
        cameraUpZ = vectorNormalization[2];
        AppMethodBeat.o(81748);
    }

    public static float[] getMovedMVPMatrix(float f, float f2) {
        AppMethodBeat.i(81749);
        calProjectionMatrix(f, f2);
        calViewMatrix();
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
        float[] fArr = mMVPMatrix;
        AppMethodBeat.o(81749);
        return fArr;
    }

    public static float[] calProjectionMatrix(float f, float f2) {
        AppMethodBeat.i(81750);
        if (!isProjectionMatInitialized) {
            nearRectWidth = 56.25f;
            float f3 = (((float) renderHeight) * 1.0f) / ((float) renderWidth);
            float f4 = (-nearRectWidth) / 2.0f;
            float f5 = nearRectWidth / 2.0f;
            float f6 = ((-nearRectWidth) / 2.0f) * f3;
            float f7 = (nearRectWidth / 2.0f) * f3;
            nearRectHeight = f7 - f6;
            near = f;
            far = f2;
            Matrix.frustumM(mProjectionMatrix, 0, f4, f5, f6, f7, near, far);
            isProjectionMatInitialized = true;
        }
        float[] fArr = mProjectionMatrix;
        AppMethodBeat.o(81750);
        return fArr;
    }

    public static float[] calViewMatrix() {
        AppMethodBeat.i(81751);
        Matrix.setLookAtM(mViewMatrix, 0, 0.0f, 0.0f, 0.0f, cameraX, cameraY, cameraZ, cameraUpX, cameraUpY, cameraUpZ);
        float[] fArr = mViewMatrix;
        AppMethodBeat.o(81751);
        return fArr;
    }

    public static void startOrientationSensor() {
        AppMethodBeat.i(81752);
        if (orientationProvider == null) {
            OrientationProvider improvedOrientationSensor2Provider;
            boolean z = hasGyroscope() && !isInBlackList;
            canUseImprovedSensorProvider = z;
            if (z) {
                improvedOrientationSensor2Provider = new ImprovedOrientationSensor2Provider((SensorManager) VideoGlobalContext.getContext().getSystemService("sensor"));
            } else {
                improvedOrientationSensor2Provider = new SimpleOrientationSensorProvider((SensorManager) VideoGlobalContext.getContext().getSystemService("sensor"));
            }
            orientationProvider = improvedOrientationSensor2Provider;
        }
        orientationProvider.start();
        AppMethodBeat.o(81752);
    }

    public static void stopOrientationSensor() {
        AppMethodBeat.i(81753);
        if (orientationProvider != null) {
            orientationProvider.stop();
        }
        AppMethodBeat.o(81753);
    }

    public static void updateOrientation() {
        AppMethodBeat.i(81754);
        float[] fArr = new float[3];
        orientationProvider.getEulerAngles(fArr);
        if (canUseImprovedSensorProvider && isSensorDataNaN(fArr)) {
            changeToSimpleOrientationProvider();
            canUseImprovedSensorProvider = false;
            AppMethodBeat.o(81754);
            return;
        }
        float[] fArr2 = new float[16];
        getRotation44(fArr, fArr2);
        fArr = new float[16];
        Matrix.multiplyMM(fArr, 0, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0, fArr2, 0);
        setOrientationVector(fArr[4], fArr[6], fArr[5], -fArr[8], -fArr[10], -fArr[9]);
        AppMethodBeat.o(81754);
    }

    private static boolean isSensorDataNaN(float[] fArr) {
        AppMethodBeat.i(81755);
        if (Float.isNaN(fArr[0]) || Float.isNaN(fArr[1]) || Float.isNaN(fArr[2])) {
            AppMethodBeat.o(81755);
            return true;
        }
        AppMethodBeat.o(81755);
        return false;
    }

    private static void changeToSimpleOrientationProvider() {
        AppMethodBeat.i(81756);
        orientationProvider.stop();
        SimpleOrientationSensorProvider simpleOrientationSensorProvider = new SimpleOrientationSensorProvider((SensorManager) VideoGlobalContext.getContext().getSystemService("sensor"));
        orientationProvider = simpleOrientationSensorProvider;
        simpleOrientationSensorProvider.start();
        AppMethodBeat.o(81756);
    }

    private static void getRotation44(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(81757);
        float[] fArr3 = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr3[i] = fArr[i] * 0.017453292f;
        }
        fArr2[0] = (cos(fArr3[0]) * cos(fArr3[1])) * 1.0f;
        fArr2[1] = (sin(fArr3[0]) * cos(fArr3[1])) * 1.0f;
        fArr2[2] = -1.0f * sin(fArr3[1]);
        fArr2[4] = (((cos(fArr3[0]) * sin(fArr3[1])) * sin(fArr3[2])) - (sin(fArr3[0]) * cos(fArr3[2]))) * 1.0f;
        fArr2[5] = (((sin(fArr3[0]) * sin(fArr3[1])) * sin(fArr3[2])) + (cos(fArr3[0]) * cos(fArr3[2]))) * 1.0f;
        fArr2[6] = (cos(fArr3[1]) * sin(fArr3[2])) * 1.0f;
        fArr2[8] = (((cos(fArr3[0]) * sin(fArr3[1])) * cos(fArr3[2])) + (sin(fArr3[0]) * sin(fArr3[2]))) * 1.0f;
        fArr2[9] = (((sin(fArr3[0]) * sin(fArr3[1])) * cos(fArr3[2])) - (cos(fArr3[0]) * sin(fArr3[2]))) * 1.0f;
        fArr2[10] = (cos(fArr3[1]) * cos(fArr3[2])) * 1.0f;
        fArr2[15] = 1.0f;
        AppMethodBeat.o(81757);
    }

    private static float sin(float f) {
        AppMethodBeat.i(81758);
        float sin = (float) Math.sin((double) f);
        AppMethodBeat.o(81758);
        return sin;
    }

    private static float cos(float f) {
        AppMethodBeat.i(81759);
        float cos = (float) Math.cos((double) f);
        AppMethodBeat.o(81759);
        return cos;
    }

    private static boolean hasGyroscope() {
        AppMethodBeat.i(81760);
        boolean hasSystemFeature = VideoGlobalContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.gyroscope");
        AppMethodBeat.o(81760);
        return hasSystemFeature;
    }

    private static float[] vectorCrossProduct(float[] fArr, float[] fArr2) {
        return new float[]{(fArr[1] * fArr2[2]) - (fArr[2] * fArr2[1]), (fArr[2] * fArr2[0]) - (fArr[0] * fArr2[2]), (fArr[0] * fArr2[1]) - (fArr[1] * fArr2[0])};
    }

    private static float[] vectorNormalization(float[] fArr) {
        AppMethodBeat.i(81761);
        float[] fArr2 = new float[3];
        float sqrt = (float) Math.sqrt((double) (((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])) + (fArr[2] * fArr[2])));
        if (((double) sqrt) > 0.0d) {
            fArr2[0] = fArr[0] / sqrt;
            fArr2[1] = fArr[1] / sqrt;
            fArr2[2] = fArr[2] / sqrt;
        }
        AppMethodBeat.o(81761);
        return fArr2;
    }

    public static void updateRenderSize(int i, int i2) {
        isProjectionMatInitialized = false;
        renderWidth = i;
        renderHeight = i2;
    }

    public static void setIsInBlackList(String str) {
        boolean z = false;
        AppMethodBeat.i(81762);
        for (Object add : blackList) {
            blackSet.add(add);
        }
        if (!TextUtils.isEmpty(str) && blackSet.contains(str)) {
            z = true;
        }
        isInBlackList = z;
        AppMethodBeat.o(81762);
    }
}
