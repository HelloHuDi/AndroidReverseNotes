package com.tencent.youtu.ytcommon.tools;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class YTUtils {
    private static final String TAG = "ToolUtils";
    private static Map<String, String> mLoadedLibrary = new HashMap();

    static {
        AppMethodBeat.i(118118);
        AppMethodBeat.o(118118);
    }

    public static void prepareMatrix(Matrix matrix, boolean z, int i, int i2, int i3) {
        float f;
        AppMethodBeat.i(118112);
        YTLogger.e(TAG, "prepareMatrix viewWidth=" + i2 + ",viewHeight=" + i3 + ",displayOrientation=" + i);
        if (z) {
            f = -1.0f;
        } else {
            f = 1.0f;
        }
        matrix.setScale(f, 1.0f);
        matrix.postRotate((float) i);
        matrix.postScale(((float) i2) / 2000.0f, ((float) i3) / 2000.0f);
        matrix.postTranslate(((float) i2) / 2.0f, ((float) i3) / 2.0f);
        AppMethodBeat.o(118112);
    }

    public static int dip2px(Context context, float f) {
        AppMethodBeat.i(118113);
        int i = (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
        AppMethodBeat.o(118113);
        return i;
    }

    public static Rect trans2ScreenRect(Context context, int i, int i2, Rect rect) {
        int i3;
        int i4;
        float f;
        AppMethodBeat.i(118114);
        long currentTimeMillis = System.currentTimeMillis();
        YTLogger.e(TAG, "trans2ScreenRect srcRect=" + rect.toString());
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        YTLogger.e(TAG, "trans2ScreenRect dm.widthPixels=" + displayMetrics.widthPixels);
        YTLogger.e(TAG, "trans2ScreenRect dm.heightPixels=" + displayMetrics.heightPixels);
        YTLogger.e(TAG, "trans2ScreenRect previewWidth=".concat(String.valueOf(i)));
        YTLogger.e(TAG, "trans2ScreenRect previewHeight=".concat(String.valueOf(i2)));
        int i5 = displayMetrics.widthPixels;
        int i6 = displayMetrics.heightPixels;
        double d = (double) ((((float) i) * 1.0f) / ((float) i2));
        boolean z = i5 > i6;
        if (z) {
            i3 = i5;
        } else {
            i3 = i6;
        }
        if (!z) {
            i6 = i5;
        }
        if (((double) i3) < ((double) i6) * d) {
            i3 = (int) (((double) i6) * d);
        } else {
            i6 = (int) (((double) i3) / d);
        }
        if (z) {
            i5 = i6;
            i4 = i3;
        } else {
            i5 = i3;
            i4 = i6;
        }
        YTLogger.d(TAG, "trans2ScreenRect aspectRatio=".concat(String.valueOf(d)));
        YTLogger.d(TAG, "trans2ScreenRect widthLonger=".concat(String.valueOf(z)));
        YTLogger.e(TAG, "trans2ScreenRect screenWidth=".concat(String.valueOf(i4)));
        YTLogger.e(TAG, "trans2ScreenRect screenHeight=".concat(String.valueOf(i5)));
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (i2 * i5 > i4 * i) {
            f = (((float) i5) * 1.0f) / ((float) i);
            f2 = (((float) i4) - (((float) i2) * f)) * 0.5f;
        } else {
            f = (((float) i4) * 1.0f) / ((float) i2);
            f3 = (((float) i5) - (((float) i) * f)) * 0.5f;
        }
        Rect rect2 = new Rect();
        rect2.set((int) ((((float) rect.left) * f) - f2), (int) ((((float) rect.top) * f) - f3), (int) (((float) rect.right) * f), (int) (((float) rect.bottom) * f));
        YTLogger.d(TAG, "scale=".concat(String.valueOf(f)));
        YTLogger.d(TAG, "dx=".concat(String.valueOf(f2)));
        YTLogger.d(TAG, "dy=".concat(String.valueOf(f3)));
        YTLogger.d(TAG, "screenWidth=".concat(String.valueOf(i4)));
        YTLogger.d(TAG, "screenHeight=".concat(String.valueOf(i5)));
        YTLogger.d(TAG, "dWidth=".concat(String.valueOf(i2)));
        YTLogger.d(TAG, "dHeight=".concat(String.valueOf(i)));
        YTLogger.d(TAG, "dst=" + rect2.toString());
        i3 = (i4 - displayMetrics.widthPixels) / 2;
        i5 = (i5 - displayMetrics.heightPixels) / 2;
        rect.set((int) ((((float) rect.left) * f) - ((float) i3)), (int) ((((float) rect.top) * f) - ((float) i5)), (int) ((((float) rect.right) * f) - ((float) i3)), (int) ((f * ((float) rect.bottom)) - ((float) i5)));
        YTLogger.d(TAG, "target=" + rect.toString() + ",time=" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(118114);
        return rect;
    }

    public static Rect trans2ScreenRectForYT(Context context, int i, int i2, Rect rect) {
        AppMethodBeat.i(118115);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        YTLogger.e(TAG, "trans2ScreenRectForYT dm.widthPixels=" + displayMetrics.widthPixels);
        YTLogger.e(TAG, "trans2ScreenRectForYT dm.heightPixels=" + displayMetrics.heightPixels);
        YTLogger.e(TAG, "trans2ScreenRectForYT previewHeight=".concat(String.valueOf(i2)));
        float f = (((float) displayMetrics.widthPixels) * 1.0f) / ((float) i2);
        rect.set((int) (((float) rect.left) * f), (int) (((float) rect.top) * f), (int) (((float) (rect.left + rect.width())) * f), (int) (f * ((float) (rect.top + rect.height()))));
        AppMethodBeat.o(118115);
        return rect;
    }

    public static Rect translateToMeteringAreaCoordinate(int i, int i2, Rect rect) {
        AppMethodBeat.i(118116);
        Rect rect2 = new Rect();
        Matrix matrix = new Matrix();
        prepareMatrix(matrix, true, 90, i, i2);
        matrix.postRotate(0.0f);
        RectF rectF = new RectF(((float) rect.left) * 1.0f, ((float) rect.top) * 1.0f, ((float) rect.right) * 1.0f, ((float) rect.bottom) * 1.0f);
        YTLogger.e(TAG, "translationToMeteringAreaCoordinate old rectF.left=" + rectF.left + ",rectF.top=" + rectF.top + ",rectF.right=" + rectF.right + ",rectF.bottom=" + rectF.bottom);
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        matrix2.mapRect(rectF);
        YTLogger.e(TAG, "translationToMeteringAreaCoordinate new rectF.left=" + rectF.left + ",rectF.top=" + rectF.top + ",rectF.right=" + rectF.right + ",rectF.bottom=" + rectF.bottom);
        rect2.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        AppMethodBeat.o(118116);
        return rect2;
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(118117);
        if (mLoadedLibrary.get(str) == null) {
            YTLogger.i(TAG, "[YTUtils.loadLibrary] " + System.getProperty("java.library.path"));
            System.loadLibrary(str);
            mLoadedLibrary.put(str, "loaded");
        }
        AppMethodBeat.o(118117);
    }
}
