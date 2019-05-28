package com.tencent.ttpic.baseutils;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ApiHelper {
    public static final boolean CAN_START_PREVIEW_IN_JPEG_CALLBACK;
    public static final boolean HAS_AUTO_FOCUS_MOVE_CALLBACK;
    public static final boolean HAS_CAMERA_FOCUS_AREA;
    public static final boolean HAS_CAMERA_HDR;
    public static final boolean HAS_CAMERA_HDR_PLUS;
    public static final boolean HAS_CAMERA_METERING_AREA;
    public static final boolean HAS_DISPLAY_LISTENER;
    public static final boolean HAS_FACE_DETECTION;
    public static final boolean HAS_GET_CAMERA_DISABLED;
    public static final boolean HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT = (VERSION.SDK_INT >= 16);

    public static class VERSION_CODES {
        public static final int BASE = 1;
        public static final int BASE_1_1 = 2;
        public static final int CUPCAKE = 3;
        public static final int DONUT = 4;
        public static final int ECLAIR = 5;
        public static final int ECLAIR_0_1 = 6;
        public static final int ECLAIR_MR1 = 7;
        public static final int FROYO = 8;
        public static final int GINGERBREAD = 9;
        public static final int GINGERBREAD_MR1 = 10;
        public static final int HONEYCOMB = 11;
        public static final int HONEYCOMB_MR1 = 12;
        public static final int HONEYCOMB_MR2 = 13;
        public static final int ICE_CREAM_SANDWICH = 14;
        public static final int ICE_CREAM_SANDWICH_MR1 = 15;
        public static final int JELLY_BEAN = 16;
        public static final int JELLY_BEAN_MR1 = 17;
        public static final int JELLY_BEAN_MR2 = 18;
        public static final int KITKAT = 19;
        public static final int KITKAT_WATCH = 20;
        public static final int LOLLIPOP = 21;
        public static final int LOLLIPOP_MR1 = 22;
        public static final int NOUGAT = 24;
        public static final int O = 26;
        public static final int O_MR1 = 27;
    }

    public static boolean hasGingerbread() {
        return VERSION.SDK_INT >= 9;
    }

    public static boolean hasHoneycomb() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean hasHoneycombMR1() {
        return VERSION.SDK_INT >= 12;
    }

    public static boolean hasIceCreamSandwich() {
        return VERSION.SDK_INT >= 14;
    }

    public static boolean hasJellyBean() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean hasJellyBeanMR1() {
        return VERSION.SDK_INT >= 17;
    }

    public static boolean hasJellyBeanMR2() {
        return VERSION.SDK_INT >= 18;
    }

    public static boolean hasKitkat() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean isExactlyKitkat() {
        return VERSION.SDK_INT == 19;
    }

    public static boolean hasLollipop() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean hasNougat() {
        return VERSION.SDK_INT >= 24;
    }

    public static boolean isAndroid_8_1() {
        return VERSION.SDK_INT == 27;
    }

    static {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(49581);
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        HAS_AUTO_FOCUS_MOVE_CALLBACK = z;
        if (VERSION.SDK_INT >= 14) {
            z = true;
        } else {
            z = false;
        }
        HAS_CAMERA_FOCUS_AREA = z;
        if (VERSION.SDK_INT >= 14) {
            z = true;
        } else {
            z = false;
        }
        HAS_CAMERA_METERING_AREA = z;
        if (VERSION.SDK_INT >= 17) {
            z = true;
        } else {
            z = false;
        }
        HAS_CAMERA_HDR = z;
        if (VERSION.SDK_INT >= 19) {
            z = true;
        } else {
            z = false;
        }
        HAS_CAMERA_HDR_PLUS = z;
        if (VERSION.SDK_INT >= 17) {
            z = true;
        } else {
            z = false;
        }
        HAS_DISPLAY_LISTENER = z;
        if (VERSION.SDK_INT >= 14) {
            z = true;
        } else {
            z = false;
        }
        CAN_START_PREVIEW_IN_JPEG_CALLBACK = z;
        try {
            z = hasMethod(Camera.class, "setFaceDetectionListener", Class.forName("android.hardware.Camera$FaceDetectionListener")) && hasMethod(Camera.class, "startFaceDetection", new Class[0]) && hasMethod(Camera.class, "stopFaceDetection", new Class[0]) && hasMethod(Parameters.class, "getMaxNumDetectedFaces", new Class[0]);
        } catch (Throwable th) {
            z = false;
        }
        HAS_FACE_DETECTION = z;
        if (VERSION.SDK_INT >= 14) {
            z2 = hasMethod(DevicePolicyManager.class, "getCameraDisabled", ComponentName.class);
        }
        HAS_GET_CAMERA_DISABLED = z2;
        AppMethodBeat.o(49581);
    }

    public static int getIntFieldIfExists(Class<?> cls, String str, Class<?> cls2, int i) {
        AppMethodBeat.i(49577);
        try {
            i = cls.getDeclaredField(str).getInt(cls2);
            AppMethodBeat.o(49577);
        } catch (Exception e) {
            AppMethodBeat.o(49577);
        }
        return i;
    }

    private static boolean hasField(Class<?> cls, String str) {
        AppMethodBeat.i(49578);
        try {
            cls.getDeclaredField(str);
            AppMethodBeat.o(49578);
            return true;
        } catch (NoSuchFieldException e) {
            AppMethodBeat.o(49578);
            return false;
        }
    }

    private static boolean hasMethod(String str, String str2, Class<?>... clsArr) {
        AppMethodBeat.i(49579);
        try {
            Class.forName(str).getDeclaredMethod(str2, clsArr);
            AppMethodBeat.o(49579);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(49579);
            return false;
        }
    }

    private static boolean hasMethod(Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.i(49580);
        try {
            cls.getDeclaredMethod(str, clsArr);
            AppMethodBeat.o(49580);
            return true;
        } catch (NoSuchMethodException e) {
            AppMethodBeat.o(49580);
            return false;
        }
    }
}
