package com.tencent.ttpic.baseutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.p056d.C0252a;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

@SuppressLint({"NewApi"})
public class BitmapUtils {
    public static final int JPEG_QUALITY = 99;
    public static final String RES_PREFIX_ASSETS = "assets://";
    public static final String RES_PREFIX_HTTP = "http://";
    public static final String RES_PREFIX_HTTPS = "https://";
    public static final String RES_PREFIX_STORAGE = "/";
    private static final String TAG = BitmapUtils.class.getSimpleName();

    public static class Size {
        public int height;
        public int width;

        public Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public String toString() {
            AppMethodBeat.m2504i(49598);
            String str = "Size{width=" + this.width + ", height=" + this.height + '}';
            AppMethodBeat.m2505o(49598);
            return str;
        }
    }

    public enum SAVE_STATUS {
        SAVE_SUCCESS,
        SAVE_FAILED,
        SAVE_OOM,
        SAVE_NULL,
        SAVE_CHANGE_DIR;

        static {
            AppMethodBeat.m2505o(49597);
        }
    }

    static {
        AppMethodBeat.m2504i(49652);
        AppMethodBeat.m2505o(49652);
    }

    public static String getRealPath(String str) {
        AppMethodBeat.m2504i(49599);
        if (TextUtils.isEmpty(str) || !str.startsWith("assets://")) {
            AppMethodBeat.m2505o(49599);
            return str;
        }
        str = str.substring(9);
        AppMethodBeat.m2505o(49599);
        return str;
    }

    public static boolean bmpIsExists(String str) {
        AppMethodBeat.m2504i(49600);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49600);
            return false;
        } else if (str.startsWith("assets://") || new File(str).exists()) {
            AppMethodBeat.m2505o(49600);
            return true;
        } else {
            AppMethodBeat.m2505o(49600);
            return false;
        }
    }

    public static boolean isLegal(Bitmap bitmap) {
        AppMethodBeat.m2504i(49601);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(49601);
            return false;
        }
        AppMethodBeat.m2505o(49601);
        return true;
    }

    public static boolean recycle(Bitmap bitmap) {
        AppMethodBeat.m2504i(49602);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(49602);
            return false;
        }
        bitmap.recycle();
        AppMethodBeat.m2505o(49602);
        return true;
    }

    public static Bitmap copy(Bitmap bitmap, boolean z) {
        AppMethodBeat.m2504i(49603);
        Bitmap bitmap2 = null;
        try {
            if (isLegal(bitmap)) {
                bitmap2 = bitmap.copy(bitmap.getConfig(), z);
            }
        } catch (OutOfMemoryError e) {
            LogUtils.m50202e(TAG, "bitmap copy OOM!");
        }
        AppMethodBeat.m2505o(49603);
        return bitmap2;
    }

    public static Bitmap convertToSRGB(Bitmap bitmap) {
        AppMethodBeat.m2504i(49604);
        if (bitmap == null) {
            AppMethodBeat.m2505o(49604);
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
            bitmap.recycle();
            AppMethodBeat.m2505o(49604);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(49604);
            return bitmap;
        }
    }

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        AppMethodBeat.m2504i(49605);
        if (isLegal(bitmap)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 80, byteArrayOutputStream);
            if (z) {
                bitmap.recycle();
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Exception e) {
                LogUtils.m50206e(e);
            }
            AppMethodBeat.m2505o(49605);
            return toByteArray;
        }
        AppMethodBeat.m2505o(49605);
        return null;
    }

    public static void fixBgRepeatY(View view) {
        AppMethodBeat.m2504i(49606);
        Drawable background = view.getBackground();
        if (background != null && (background instanceof BitmapDrawable)) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
            bitmapDrawable.mutate();
            bitmapDrawable.setTileModeY(TileMode.REPEAT);
        }
        AppMethodBeat.m2505o(49606);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A:{SYNTHETIC, Splitter:B:24:0x004f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String getBase64FromBitmap(Bitmap bitmap, int i) {
        AppMethodBeat.m2504i(49607);
        String str;
        if (bitmap == null) {
            LogUtils.m50199d(TAG, "[getBase64FromBitmap] bitmap is null!");
            str = "";
            AppMethodBeat.m2505o(49607);
            return str;
        }
        str = "";
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), i);
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    LogUtils.m50206e(e);
                }
                AppMethodBeat.m2505o(49607);
                return str;
            } catch (Exception e2) {
            } catch (Throwable th) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        LogUtils.m50206e(e3);
                    }
                }
                AppMethodBeat.m2505o(49607);
                return str;
            }
        } catch (Exception e4) {
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e32) {
                    LogUtils.m50206e(e32);
                }
            }
            AppMethodBeat.m2505o(49607);
            return str;
        } catch (Throwable th2) {
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            AppMethodBeat.m2505o(49607);
            return str;
        }
    }

    @SuppressLint({"NewApi"})
    public static int getBitmapSizeInBytes(Bitmap bitmap) {
        AppMethodBeat.m2504i(49608);
        if (bitmap == null) {
            AppMethodBeat.m2505o(49608);
            return 0;
        }
        int allocationByteCount;
        if (VERSION.SDK_INT > 19) {
            try {
                allocationByteCount = bitmap.getAllocationByteCount();
                AppMethodBeat.m2505o(49608);
                return allocationByteCount;
            } catch (NullPointerException e) {
            }
        }
        if (VERSION.SDK_INT >= 12) {
            allocationByteCount = bitmap.getByteCount();
            AppMethodBeat.m2505o(49608);
            return allocationByteCount;
        }
        allocationByteCount = bitmap.getWidth() * bitmap.getRowBytes();
        AppMethodBeat.m2505o(49608);
        return allocationByteCount;
    }

    public static Point getBitmapSize(Context context, String str) {
        AppMethodBeat.m2504i(49609);
        Point bitmapSizeFromAssets;
        if (str.startsWith("assets://")) {
            bitmapSizeFromAssets = getBitmapSizeFromAssets(context, getRealPath(str));
            AppMethodBeat.m2505o(49609);
            return bitmapSizeFromAssets;
        }
        bitmapSizeFromAssets = getBitmapSizeFromFile(str);
        AppMethodBeat.m2505o(49609);
        return bitmapSizeFromAssets;
    }

    private static Point getBitmapSizeFromFile(String str) {
        AppMethodBeat.m2504i(49610);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        Point point = new Point(options.outWidth, options.outHeight);
        AppMethodBeat.m2505o(49610);
        return point;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c A:{SYNTHETIC, Splitter:B:20:0x004c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Point getBitmapSizeFromAssets(Context context, String str) {
        Throwable th;
        InputStream inputStream = null;
        AppMethodBeat.m2504i(49611);
        Point point = new Point(0, 0);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49611);
            return point;
        }
        InputStream open;
        try {
            open = context.getAssets().open(str);
            try {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(open, null, options);
                Point point2 = new Point(options.outWidth, options.outHeight);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.m2505o(49611);
                return point2;
            } catch (IOException e2) {
                inputStream = open;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.m2505o(49611);
                return point;
            } catch (Throwable th2) {
                th = th2;
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.m2505o(49611);
                throw th;
            }
        } catch (IOException e5) {
        } catch (Throwable th3) {
            th = th3;
            open = null;
            if (open != null) {
            }
            AppMethodBeat.m2505o(49611);
            throw th;
        }
    }

    public static int[] getImageSize(String str, int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(49612);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i4 = 1;
        while (Math.pow(2.0d, (double) i4) < ((double) calculateInSampleSize(options, i, i2, true))) {
            i4++;
        }
        i4 = (int) Math.pow(2.0d, (double) (i4 - 1));
        int i5 = options.outWidth / i4;
        int i6 = options.outHeight / i4;
        i4 = getDegreeByExif(str);
        if (i4 == 90 || i4 == 270) {
            i4 = i6;
            i3 = i5;
        } else {
            i4 = i5;
            i3 = i6;
        }
        int[] iArr = new int[]{i4, i3};
        AppMethodBeat.m2505o(49612);
        return iArr;
    }

    public static Options getBitmapOptionsFromFile(String str) {
        AppMethodBeat.m2504i(49613);
        if (str == null) {
            AppMethodBeat.m2505o(49613);
            return null;
        } else if (new File(str).exists()) {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            AppMethodBeat.m2505o(49613);
            return options;
        } else {
            AppMethodBeat.m2505o(49613);
            return null;
        }
    }

    public static Options getBitmapOptionsFromResource(Resources resources, int i) {
        AppMethodBeat.m2504i(49614);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        AppMethodBeat.m2505o(49614);
        return options;
    }

    public static Options getBitmapOptionsFromAssets(Context context, String str) {
        InputStream open;
        AppMethodBeat.m2504i(49615);
        AssetManager assets = context.getAssets();
        try {
            open = assets.open(str);
        } catch (IOException e) {
            try {
                open = assets.open(str.substring(0, str.lastIndexOf(46) + 1) + "webp");
            } catch (IOException e2) {
                LogUtils.m50205e(TAG, e2);
                AppMethodBeat.m2505o(49615);
                return null;
            }
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(open, null, options);
        try {
            open.reset();
            if (open != null) {
                IOUtils.closeQuietly(open);
            }
        } catch (IOException e3) {
            LogUtils.m50205e(TAG, e3);
            if (open != null) {
                IOUtils.closeQuietly(open);
            }
        } catch (Throwable th) {
            if (open != null) {
                IOUtils.closeQuietly(open);
            }
            AppMethodBeat.m2505o(49615);
        }
        AppMethodBeat.m2505o(49615);
        return options;
    }

    public static Options getBitmapOptionsFromUri(Context context, Uri uri) {
        String scheme;
        AppMethodBeat.m2504i(49616);
        if (uri != null) {
            scheme = uri.getScheme();
        } else {
            scheme = null;
        }
        String substring;
        Options bitmapOptionsFromFile;
        if (scheme != null && scheme.toLowerCase().startsWith("file")) {
            substring = Uri.decode(uri.toString()).substring(7);
            LogUtils.m50210v(TAG, "[getBitmapOptionsFromUri] file = ".concat(String.valueOf(substring)));
            bitmapOptionsFromFile = getBitmapOptionsFromFile(substring);
            AppMethodBeat.m2505o(49616);
            return bitmapOptionsFromFile;
        } else if (uri == null) {
            AppMethodBeat.m2505o(49616);
            return null;
        } else {
            substring = Uri.decode(uri.toString());
            LogUtils.m50210v(TAG, "[getBitmapOptionsFromUri] in else , file = ".concat(String.valueOf(substring)));
            bitmapOptionsFromFile = getBitmapOptionsFromFile(substring);
            AppMethodBeat.m2505o(49616);
            return bitmapOptionsFromFile;
        }
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, Matrix matrix) {
        Paint paint = null;
        AppMethodBeat.m2504i(49617);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(49617);
            return null;
        }
        Bitmap createBitmap;
        Canvas canvas = new Canvas();
        if (matrix == null || matrix.isIdentity()) {
            try {
                createBitmap = Bitmap.createBitmap(i3, i4, bitmap.getConfig());
            } catch (OutOfMemoryError e) {
                LogUtils.m50206e(e);
                AppMethodBeat.m2505o(49617);
                return null;
            } catch (NullPointerException e2) {
                LogUtils.m50206e(e2);
                AppMethodBeat.m2505o(49617);
                return null;
            }
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) i3, (float) i4);
        matrix.mapRect(rectF);
        try {
            createBitmap = Bitmap.createBitmap(Math.round(rectF.width()), Math.round(rectF.height()), bitmap.getConfig());
            canvas.translate(-rectF.left, -rectF.top);
            canvas.concat(matrix);
            paint = new Paint(2);
            if (!matrix.rectStaysRect()) {
                paint.setAntiAlias(true);
            }
        } catch (OutOfMemoryError e3) {
            LogUtils.m50206e(e3);
            AppMethodBeat.m2505o(49617);
            return null;
        }
        createBitmap.setDensity(bitmap.getDensity());
        canvas.setBitmap(createBitmap);
        canvas.drawBitmap(bitmap, new Rect(i, i2, i + i3, i2 + i4), new RectF(0.0f, 0.0f, (float) i3, (float) i4), paint);
        AppMethodBeat.m2505o(49617);
        return createBitmap;
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, float f, boolean z) {
        AppMethodBeat.m2504i(49618);
        if (isLegal(bitmap)) {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (createBitmap != bitmap && z) {
                    recycle(bitmap);
                }
                bitmap = createBitmap;
            } catch (OutOfMemoryError e) {
            }
        } else {
            bitmap = null;
        }
        AppMethodBeat.m2505o(49618);
        return bitmap;
    }

    public static void scaleBitmap(Bitmap bitmap, Canvas canvas, int i, int i2, double d, double d2, Point point, Paint paint) {
        AppMethodBeat.m2504i(49619);
        if (isLegal(bitmap)) {
            Matrix matrix = new Matrix();
            int i3 = (int) (((double) i) - (((double) point.x) * d2));
            int i4 = (int) (((double) i2) - (((double) point.y) * d2));
            matrix.postScale((float) d2, (float) d2);
            if (!(i3 == 0 && i4 == 0)) {
                matrix.postTranslate((float) i3, (float) i4);
            }
            if (d != 0.0d) {
                matrix.postRotate((float) d, (float) i, (float) i2);
            }
            if (paint == null) {
                AppMethodBeat.m2505o(49619);
                return;
            }
            canvas.drawBitmap(bitmap, matrix, paint);
            AppMethodBeat.m2505o(49619);
            return;
        }
        AppMethodBeat.m2505o(49619);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        AppMethodBeat.m2504i(49620);
        if (bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                    bitmap = createBitmap;
                }
            } catch (OutOfMemoryError e) {
            }
        }
        AppMethodBeat.m2505o(49620);
        return bitmap;
    }

    public static Bitmap flipBitmap(Bitmap bitmap, boolean z) {
        AppMethodBeat.m2504i(49621);
        if (bitmap != null) {
            Matrix matrix = new Matrix();
            if (z) {
                matrix.setScale(1.0f, -1.0f);
            } else {
                matrix.setScale(-1.0f, 1.0f);
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                    bitmap = createBitmap;
                }
            } catch (OutOfMemoryError e) {
                LogUtils.m50202e(TAG, "OutOfMemoryError. ".concat(String.valueOf(e)));
            }
        }
        AppMethodBeat.m2505o(49621);
        return bitmap;
    }

    public static Bitmap roundRectBitmap(Bitmap bitmap, int i) {
        AppMethodBeat.m2504i(49622);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) height);
        Rect rect = new Rect(0, 0, width, height);
        Canvas canvas = new Canvas(bitmap);
        paint.setXfermode(null);
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rectF, paint);
        AppMethodBeat.m2505o(49622);
        return bitmap;
    }

    public static Bitmap decodeSampleBitmap(Context context, String str, int i, int i2) {
        AppMethodBeat.m2504i(49623);
        Bitmap decodeSampledBitmapFromAssets;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49623);
            return null;
        } else if (str.startsWith("assets://")) {
            decodeSampledBitmapFromAssets = decodeSampledBitmapFromAssets(context, getRealPath(str), i, i2);
            AppMethodBeat.m2505o(49623);
            return decodeSampledBitmapFromAssets;
        } else if (bmpIsExists(str)) {
            decodeSampledBitmapFromAssets = decodeSampledBitmapFromFile(str, i, i2);
            AppMethodBeat.m2505o(49623);
            return decodeSampledBitmapFromAssets;
        } else {
            AppMethodBeat.m2505o(49623);
            return null;
        }
    }

    public static Bitmap decodeSampleBitmap(Context context, String str, int i) {
        AppMethodBeat.m2504i(49624);
        Bitmap decodeSampleBitmapFromAssets;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49624);
            return null;
        } else if (str.startsWith("assets://")) {
            decodeSampleBitmapFromAssets = decodeSampleBitmapFromAssets(context, getRealPath(str), i);
            AppMethodBeat.m2505o(49624);
            return decodeSampleBitmapFromAssets;
        } else if (bmpIsExists(str)) {
            decodeSampleBitmapFromAssets = decodeSampledBitmapFromFile(str, i);
            AppMethodBeat.m2505o(49624);
            return decodeSampleBitmapFromAssets;
        } else {
            AppMethodBeat.m2505o(49624);
            return null;
        }
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, int i, int i2) {
        AppMethodBeat.m2504i(49625);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSizeNew(options, i, i2, true);
        options.inJustDecodeBounds = false;
        ApiHelper.hasHoneycomb();
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            options.inSampleSize <<= 1;
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e2) {
                LogUtils.m50206e(e2);
            }
        }
        AppMethodBeat.m2505o(49625);
        return bitmap;
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, int i) {
        AppMethodBeat.m2504i(49626);
        Options options = new Options();
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            options.inSampleSize <<= 1;
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e2) {
            }
        }
        AppMethodBeat.m2505o(49626);
        return bitmap;
    }

    public static Bitmap decodeSampledBitmapFromFileCheckExif(String str, int i, int i2) {
        AppMethodBeat.m2504i(49627);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSizeNew(options, i, i2, true);
        options.inJustDecodeBounds = false;
        int degreeByExif = getDegreeByExif(str) % v2helper.VOIP_ENC_HEIGHT_LV1;
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeFile(str, options);
            if (degreeByExif != 0) {
                bitmap = rotateBitmap(bitmap, degreeByExif);
            }
        } catch (OutOfMemoryError e) {
            options.inSampleSize <<= 1;
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
                if (degreeByExif != 0) {
                    bitmap = rotateBitmap(bitmap, degreeByExif);
                }
            } catch (OutOfMemoryError e2) {
                LogUtils.m50206e(e2);
            }
        }
        AppMethodBeat.m2505o(49627);
        return bitmap;
    }

    public static int getDegreeByExif(String str) {
        int i = 0;
        AppMethodBeat.m2504i(49628);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49628);
        } else {
            try {
                i = getDegreeByOrientation(new ExifInterface(str).getAttributeInt(C0252a.TAG_ORIENTATION, 0));
                AppMethodBeat.m2505o(49628);
            } catch (Exception e) {
                AppMethodBeat.m2505o(49628);
            }
        }
        return i;
    }

    public static int getDegreeByOrientation(int i) {
        switch (i) {
            case 3:
                return 180;
            case 6:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i, int i2, int i3) {
        AppMethodBeat.m2504i(49629);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = calculateInSampleSizeNew(options, i2, i3, true);
        options.inJustDecodeBounds = false;
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeResource(resources, i, options);
        } catch (Exception e) {
            LogUtils.m50206e(e);
        } catch (OutOfMemoryError e2) {
            LogUtils.m50206e(e2);
            try {
                options.inSampleSize *= 2;
                bitmap = BitmapFactory.decodeResource(resources, i, options);
            } catch (OutOfMemoryError e3) {
            }
        }
        AppMethodBeat.m2505o(49629);
        return bitmap;
    }

    public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor fileDescriptor, int i, int i2, boolean z) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(49630);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, bitmap, options);
        options.inSampleSize = calculateInSampleSizeNew(options, i, i2, true);
        options.inJustDecodeBounds = false;
        try {
            bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        } catch (OutOfMemoryError e) {
            options.inSampleSize <<= 1;
            try {
                bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            } catch (OutOfMemoryError e2) {
                LogUtils.m50206e(e);
            }
        } catch (Exception e3) {
        }
        AppMethodBeat.m2505o(49630);
        return bitmap;
    }

    public static Bitmap decodeSampledBitmapFromAssets(Context context, String str, int i, int i2) {
        AppMethodBeat.m2504i(49631);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49631);
            return null;
        }
        InputStream open;
        Bitmap decodeStream;
        AssetManager assets = context.getAssets();
        try {
            open = assets.open(str);
        } catch (IOException e) {
            try {
                open = assets.open(str.substring(0, str.lastIndexOf(46) + 1) + "webp");
            } catch (IOException e2) {
                LogUtils.m50205e(TAG, e2);
                AppMethodBeat.m2505o(49631);
                return null;
            }
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(open, null, options);
        options.inSampleSize = calculateInSampleSizeNew(options, i, i2, true);
        options.inJustDecodeBounds = false;
        try {
            open.reset();
            decodeStream = BitmapFactory.decodeStream(open, null, options);
        } catch (IOException e3) {
            LogUtils.m50205e(TAG, e3);
            decodeStream = null;
        } catch (OutOfMemoryError e4) {
            options.inSampleSize <<= 1;
            try {
                open.reset();
                decodeStream = BitmapFactory.decodeStream(open, null, options);
            } catch (IOException | OutOfMemoryError e32) {
                LogUtils.m50205e(TAG, e32);
                decodeStream = null;
            }
        }
        IOUtils.closeQuietly(open);
        AppMethodBeat.m2505o(49631);
        return decodeStream;
    }

    public static Bitmap decodeSampleBitmapFromAssets(Context context, String str, int i) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(49632);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49632);
        } else {
            try {
                InputStream open = context.getAssets().open(str);
                Options options = new Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                try {
                    bitmap = BitmapFactory.decodeStream(open, null, options);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (OutOfMemoryError e4) {
                    options.inSampleSize <<= 1;
                    try {
                        open.reset();
                        bitmap = BitmapFactory.decodeStream(open, null, options);
                    } catch (IOException | OutOfMemoryError e5) {
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (Throwable th) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e7) {
                        }
                    }
                    AppMethodBeat.m2505o(49632);
                }
                AppMethodBeat.m2505o(49632);
            } catch (IOException e8) {
                AppMethodBeat.m2505o(49632);
            }
        }
        return bitmap;
    }

    public static Bitmap decodeSampledBitmapFromUri(Uri uri, int i, int i2) {
        String scheme;
        Throwable e;
        Bitmap bitmap;
        AppMethodBeat.m2504i(49633);
        if (uri != null) {
            try {
                scheme = uri.getScheme();
            } catch (Exception e2) {
                e = e2;
                bitmap = null;
            }
        } else {
            scheme = null;
        }
        if (scheme != null && scheme.toLowerCase().startsWith("file")) {
            scheme = Uri.decode(uri.toString()).substring(7);
            LogUtils.m50210v(TAG, "decodeSampledBitmapFromUri(), file = ".concat(String.valueOf(scheme)));
            bitmap = decodeSampledBitmapFromFileCheckExif(scheme, i, i2);
        } else if (uri != null) {
            scheme = Uri.decode(uri.toString());
            LogUtils.m50210v(TAG, "decodeSampledBitmapFromUri() in else , file = ".concat(String.valueOf(scheme)));
            bitmap = decodeSampledBitmapFromFileCheckExif(scheme, i, i2);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            try {
                LogUtils.m50210v(TAG, "decodeSampledBitmapFromUri(), width = " + bitmap.getWidth() + ", height = " + bitmap.getHeight());
            } catch (Exception e3) {
                e = e3;
                try {
                    LogUtils.m50206e(e);
                    IOUtils.closeQuietly(null);
                    IOUtils.closeQuietly(null);
                    AppMethodBeat.m2505o(49633);
                    return bitmap;
                } catch (Throwable th) {
                    IOUtils.closeQuietly(null);
                    IOUtils.closeQuietly(null);
                    AppMethodBeat.m2505o(49633);
                }
            }
        }
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
        AppMethodBeat.m2505o(49633);
        return bitmap;
    }

    public static Bitmap getBitmapFromURL(String str) {
        AppMethodBeat.m2504i(49634);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            AppMethodBeat.m2505o(49634);
            return decodeStream;
        } catch (IOException e) {
            AppMethodBeat.m2505o(49634);
            return null;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x004a=Splitter:B:18:0x004a, B:14:0x003d=Splitter:B:14:0x003d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static SAVE_STATUS saveBitmap(Bitmap bitmap, String str) {
        Throwable e;
        SAVE_STATUS save_status;
        AppMethodBeat.m2504i(49635);
        OutputStream outputStream = null;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream fileOutputStream = new FileOutputStream(str);
            if (bitmap != null) {
                try {
                    bitmap.compress(CompressFormat.JPEG, 99, fileOutputStream);
                    fileOutputStream.flush();
                } catch (Exception e2) {
                    e = e2;
                    outputStream = fileOutputStream;
                    try {
                        LogUtils.m50206e(e);
                        save_status = SAVE_STATUS.SAVE_FAILED;
                        IOUtils.closeQuietly(outputStream);
                        AppMethodBeat.m2505o(49635);
                        return save_status;
                    } catch (Throwable th) {
                        e = th;
                        IOUtils.closeQuietly(outputStream);
                        AppMethodBeat.m2505o(49635);
                        throw e;
                    }
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    outputStream = fileOutputStream;
                    LogUtils.m50206e(e);
                    save_status = SAVE_STATUS.SAVE_OOM;
                    IOUtils.closeQuietly(outputStream);
                    AppMethodBeat.m2505o(49635);
                    return save_status;
                } catch (Throwable th2) {
                    e = th2;
                    outputStream = fileOutputStream;
                    IOUtils.closeQuietly(outputStream);
                    AppMethodBeat.m2505o(49635);
                    throw e;
                }
            }
            IOUtils.closeQuietly(fileOutputStream);
            save_status = SAVE_STATUS.SAVE_SUCCESS;
            AppMethodBeat.m2505o(49635);
            return save_status;
        } catch (Exception e4) {
            e = e4;
            LogUtils.m50206e(e);
            save_status = SAVE_STATUS.SAVE_FAILED;
            IOUtils.closeQuietly(outputStream);
            AppMethodBeat.m2505o(49635);
            return save_status;
        } catch (OutOfMemoryError e5) {
            e = e5;
            LogUtils.m50206e(e);
            save_status = SAVE_STATUS.SAVE_OOM;
            IOUtils.closeQuietly(outputStream);
            AppMethodBeat.m2505o(49635);
            return save_status;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b A:{Splitter:B:7:0x0016, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:31:0x0080, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:32:0x0081, code skipped:
            r3 = null;
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:36:0x008b, code skipped:
            r0 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static File saveBitmap(Context context, Bitmap bitmap, String str, String str2, CompressFormat compressFormat, String str3) {
        File file;
        Throwable e;
        OutputStream outputStream = null;
        AppMethodBeat.m2504i(49636);
        File file2;
        if (str != null) {
            file2 = new File(str);
            if (!(file2.isDirectory() || file2.mkdirs())) {
                AppMethodBeat.m2505o(49636);
                return null;
            }
        } else if (context != null) {
            file2 = context.getCacheDir();
            if (file2 != null) {
                str = file2.getAbsolutePath();
            }
        }
        boolean z = false;
        OutputStream fileOutputStream;
        try {
            String str4;
            if (compressFormat == CompressFormat.PNG) {
                str4 = str2 + ".png";
            } else {
                str4 = str2 + FileUtils.PIC_POSTFIX_JPEG;
            }
            File file3 = new File(str, str4);
            fileOutputStream = new FileOutputStream(file3);
            try {
                if (compressFormat != CompressFormat.JPEG || str3 == null || str3.length() <= 0) {
                    z = bitmap.compress(compressFormat, 99, fileOutputStream);
                }
                IOUtils.closeQuietly(fileOutputStream);
                file = file3;
            } catch (Exception e2) {
                e = e2;
                try {
                    LogUtils.m50206e(e);
                    IOUtils.closeQuietly(fileOutputStream);
                    file = file3;
                    if (z) {
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    outputStream = fileOutputStream;
                    IOUtils.closeQuietly(outputStream);
                    AppMethodBeat.m2505o(49636);
                    throw th2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th3) {
        }
        if (z) {
            AppMethodBeat.m2505o(49636);
            return file;
        }
        AppMethodBeat.m2505o(49636);
        return null;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x004a=Splitter:B:18:0x004a, B:14:0x003d=Splitter:B:14:0x003d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static SAVE_STATUS saveBitmap2PNG(Bitmap bitmap, String str) {
        Throwable e;
        SAVE_STATUS save_status;
        AppMethodBeat.m2504i(49637);
        OutputStream outputStream = null;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream fileOutputStream = new FileOutputStream(str);
            if (bitmap != null) {
                try {
                    bitmap.compress(CompressFormat.PNG, 99, fileOutputStream);
                    fileOutputStream.flush();
                } catch (Exception e2) {
                    e = e2;
                    outputStream = fileOutputStream;
                    try {
                        LogUtils.m50206e(e);
                        save_status = SAVE_STATUS.SAVE_FAILED;
                        IOUtils.closeQuietly(outputStream);
                        AppMethodBeat.m2505o(49637);
                        return save_status;
                    } catch (Throwable th) {
                        e = th;
                        IOUtils.closeQuietly(outputStream);
                        AppMethodBeat.m2505o(49637);
                        throw e;
                    }
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    outputStream = fileOutputStream;
                    LogUtils.m50206e(e);
                    save_status = SAVE_STATUS.SAVE_OOM;
                    IOUtils.closeQuietly(outputStream);
                    AppMethodBeat.m2505o(49637);
                    return save_status;
                } catch (Throwable th2) {
                    e = th2;
                    outputStream = fileOutputStream;
                    IOUtils.closeQuietly(outputStream);
                    AppMethodBeat.m2505o(49637);
                    throw e;
                }
            }
            IOUtils.closeQuietly(fileOutputStream);
            save_status = SAVE_STATUS.SAVE_SUCCESS;
            AppMethodBeat.m2505o(49637);
            return save_status;
        } catch (Exception e4) {
            e = e4;
            LogUtils.m50206e(e);
            save_status = SAVE_STATUS.SAVE_FAILED;
            IOUtils.closeQuietly(outputStream);
            AppMethodBeat.m2505o(49637);
            return save_status;
        } catch (OutOfMemoryError e5) {
            e = e5;
            LogUtils.m50206e(e);
            save_status = SAVE_STATUS.SAVE_OOM;
            IOUtils.closeQuietly(outputStream);
            AppMethodBeat.m2505o(49637);
            return save_status;
        }
    }

    public static Bitmap correctImageToFitIn(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(49638);
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= i && height <= i2) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, width, height, true);
            } else if ((((double) i2) * 1.0d) / ((double) height) > (((double) i) * 1.0d) / ((double) width)) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, i, (int) (((double) height) * ((((double) i) * 1.0d) / ((double) width))), true);
            } else {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (((double) width) * ((((double) i2) * 1.0d) / ((double) height))), i2, true);
            }
        }
        AppMethodBeat.m2505o(49638);
        return bitmap2;
    }

    public static Bitmap scaleBitmapUnderLimit(Bitmap bitmap, int i) {
        Object obj = null;
        AppMethodBeat.m2504i(49639);
        float f = 1.0f;
        Bitmap bitmap2 = bitmap;
        while (obj == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap2 = scaleBitmap(bitmap2, f, false);
                bitmap2.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                if (byteArrayOutputStream.toByteArray().length <= i) {
                    obj = 1;
                }
                f *= 0.7f;
            } catch (OutOfMemoryError e) {
                if (bitmap2.getHeight() < 10 || bitmap2.getWidth() < 10) {
                    obj = 1;
                }
                f *= 0.7f;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(49639);
            }
        }
        AppMethodBeat.m2505o(49639);
        return bitmap2;
    }

    public static Bitmap decodeBitmapFromFileForShare(String str, int i, int i2, int[] iArr) {
        Bitmap bitmap = null;
        int i3 = 1;
        AppMethodBeat.m2504i(49640);
        LogUtils.m50201d(TAG, "decodeBitmapFromFileForShare(%s, %d, %d, %s)", str, Integer.valueOf(i), Integer.valueOf(i2), iArr);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49640);
        } else if (new File(str).exists()) {
            int degreeByExif = getDegreeByExif(str);
            try {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                Size size = new Size(options.outWidth, options.outHeight);
                LogUtils.m50210v(TAG, "decodeBitmapFromFileForShare(), outer width = " + options.outWidth + ", height = " + options.outHeight);
                if (iArr != null && iArr.length == 2) {
                    iArr[0] = options.outWidth;
                    iArr[1] = options.outHeight;
                }
                boolean shouldResize = shouldResize(size, i, i2);
                if (shouldResize) {
                    size = calcNewSize(size, i, i2);
                }
                options.inJustDecodeBounds = false;
                if (shouldResize) {
                    i3 = calculateInSampleSizeNew(options, size.width, size.height, true);
                }
                LogUtils.m50210v(TAG, "decodeBitmapFromFileForShare(), inSampleSize = ".concat(String.valueOf(i3)));
                options.inSampleSize = i3;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (degreeByExif != 0) {
                    decodeFile = rotateBitmap(decodeFile, degreeByExif);
                }
                if (decodeFile != null) {
                    bitmap = getFinalBitmap(decodeFile, i, i2);
                    AppMethodBeat.m2505o(49640);
                } else {
                    AppMethodBeat.m2505o(49640);
                }
            } catch (Exception e) {
                LogUtils.m50206e(e);
                AppMethodBeat.m2505o(49640);
            } catch (OutOfMemoryError e2) {
                LogUtils.m50206e(e2);
                AppMethodBeat.m2505o(49640);
            }
        } else {
            AppMethodBeat.m2505o(49640);
        }
        return bitmap;
    }

    public static Bitmap decodeBitmapFromFileExtForShare(String str, int i, int i2, int i3) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(49641);
        LogUtils.m50201d(TAG, "decodeBitmapFromFileExtForShare(%s, %d, %d, %d)", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49641);
            return null;
        } else if (new File(str).exists()) {
            Bitmap bitmap2;
            int degreeByExif = getDegreeByExif(str);
            int i4;
            int i5;
            if (i < i2) {
                i4 = i;
                i5 = i2;
            } else {
                i4 = i2;
                i5 = i;
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i6 = options.outWidth > options.outHeight ? options.outWidth : options.outHeight;
            int i7 = options.outWidth < options.outHeight ? options.outWidth : options.outHeight;
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            do {
                try {
                    bitmap = BitmapFactory.decodeFile(str, options);
                } catch (OutOfMemoryError e) {
                    options.inSampleSize *= 2;
                    LogUtils.m50213w(TAG, "[decodeBitmapFromFileExtForShare] " + e.getMessage());
                }
                if (bitmap != null || (i6 / options.inSampleSize < i5 && i7 / options.inSampleSize < i4)) {
                    if (bitmap != null || degreeByExif == 0) {
                        bitmap2 = bitmap;
                    } else {
                        bitmap2 = rotateBitmap(bitmap, degreeByExif);
                    }
                }
            } while (options.inSampleSize <= i3);
            if (bitmap != null) {
            }
            bitmap2 = bitmap;
            AppMethodBeat.m2505o(49641);
            return bitmap2;
        } else {
            AppMethodBeat.m2505o(49641);
            return null;
        }
    }

    public static String compressImage(String str, Options options, int i, int i2) {
        AppMethodBeat.m2504i(49642);
        try {
            String compressImageFile = compressImageFile(str, getScaledOpt(options, i, i2), new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "Pitu"));
            AppMethodBeat.m2505o(49642);
            return compressImageFile;
        } catch (Exception e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(49642);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2 A:{SYNTHETIC, Splitter:B:40:0x00b2} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7 A:{SYNTHETIC, Splitter:B:34:0x00a7} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String compressImageFile(String str, Options options, File file) {
        Throwable e;
        AppMethodBeat.m2504i(49643);
        LogUtils.m50201d(TAG, "compressImageFile(%s, %s, %s)", str, options, file.getAbsolutePath());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = file.getAbsolutePath() + File.separator + "topic_thumb_temp_" + new Date().getTime();
        File file2 = new File(str2);
        OutputStream fileOutputStream;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file2);
            try {
                if (!IsSupportImgType(options.outMimeType)) {
                    Bitmap decodeFile;
                    options.inPreferredConfig = Config.RGB_565;
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    try {
                        decodeFile = BitmapFactory.decodeFile(str, options);
                    } catch (OutOfMemoryError e2) {
                        LogUtils.m50206e(e2);
                        decodeFile = null;
                    }
                    if (decodeFile != null) {
                        decodeFile.compress(CompressFormat.JPEG, 90, fileOutputStream);
                        decodeFile.recycle();
                    } else {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                        AppMethodBeat.m2505o(49643);
                        return null;
                    }
                }
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                }
                AppMethodBeat.m2505o(49643);
                return str2;
            } catch (Exception e5) {
                e = e5;
                try {
                    LogUtils.m50206e(e);
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(49643);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    AppMethodBeat.m2505o(49643);
                    throw e;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
            LogUtils.m50206e(e);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                }
            }
            AppMethodBeat.m2505o(49643);
            return null;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            AppMethodBeat.m2505o(49643);
            throw e;
        }
    }

    private static Options getScaledOpt(Options options, int i, int i2) {
        AppMethodBeat.m2504i(49644);
        Options options2 = new Options();
        options2.inSampleSize = calculateInSampleSizeNew(options, i, i2, false);
        options2.inJustDecodeBounds = false;
        AppMethodBeat.m2505o(49644);
        return options2;
    }

    private static boolean IsSupportImgType(String str) {
        AppMethodBeat.m2504i(49645);
        boolean z = false;
        if (str != null && (str.equalsIgnoreCase("image/jpeg") || str.equalsIgnoreCase("image/png") || str.equalsIgnoreCase("image/gif"))) {
            z = true;
        }
        AppMethodBeat.m2505o(49645);
        return z;
    }

    private static boolean shouldResize(Size size, int i, int i2) {
        int i3;
        int i4;
        if (((double) (((float) size.height) / ((float) size.width))) >= 1.0d) {
            i4 = size.height;
            i3 = size.width;
        } else {
            i4 = size.width;
            i3 = size.height;
        }
        if (i3 >= i || i4 >= i2) {
            return true;
        }
        return false;
    }

    private static Size calcNewSize(Size size, int i, int i2) {
        int i3;
        int i4;
        AppMethodBeat.m2504i(49646);
        if (((double) (((float) size.height) / ((float) size.width))) >= 1.0d) {
            i3 = size.height;
            i4 = size.width;
        } else {
            i3 = size.width;
            i4 = size.height;
        }
        Size newSize = getNewSize(i4, i3, i, i2);
        AppMethodBeat.m2505o(49646);
        return newSize;
    }

    private static Size getNewSize(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(49647);
        float min = Math.min(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        Size size;
        if (((double) min) < 1.0d) {
            size = new Size((int) (((float) i) * min), (int) (min * ((float) i2)));
            AppMethodBeat.m2505o(49647);
            return size;
        }
        size = new Size(i, i2);
        AppMethodBeat.m2505o(49647);
        return size;
    }

    private static Bitmap getFinalBitmap(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.m2504i(49648);
        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        if (max > i2 || min > i) {
            float min2 = Math.min(((float) i2) / ((float) max), ((float) i) / ((float) min));
            Matrix matrix = new Matrix();
            matrix.setScale(min2, min2);
            Bitmap createBitmap = Bitmap.createBitmap((int) (((float) bitmap.getWidth()) * min2), (int) (min2 * ((float) bitmap.getHeight())), Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, paint);
            recycle(bitmap);
            AppMethodBeat.m2505o(49648);
            return createBitmap;
        }
        AppMethodBeat.m2505o(49648);
        return bitmap;
    }

    public static void drawRepeatBitmap(Bitmap bitmap, Rect rect, Rect rect2, Canvas canvas, float f, Paint paint) {
        AppMethodBeat.m2504i(49649);
        int i = rect2.top;
        int i2 = rect2.bottom;
        int i3 = rect2.left;
        int i4 = rect2.right;
        int width = (int) (((((float) rect2.width()) / f) / ((float) rect.width())) + 1.0f);
        int height = (int) (((((float) rect2.height()) / f) / ((float) rect.height())) + 1.0f);
        canvas.save();
        canvas.clipRect(rect2);
        for (int i5 = 0; i5 < height; i5++) {
            for (int i6 = 0; i6 < width; i6++) {
                rect2.set((int) (((float) i3) + (((float) (rect.width() * i6)) * f)), (int) (((float) i) + (((float) (rect.height() * i5)) * f)), (int) ((((float) i3) + (((float) (rect.width() * i6)) * f)) + (((float) rect.width()) * f)), (int) ((((float) i) + (((float) (rect.height() * i5)) * f)) + (((float) rect.height()) * f)));
                canvas.drawBitmap(bitmap, rect, rect2, paint);
            }
        }
        canvas.restore();
        rect2.set(i3, i, i4, i2);
        AppMethodBeat.m2505o(49649);
    }

    public static int calculateInSampleSize(Options options, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(49650);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if ((i2 > 0 && i3 > i2) || (i > 0 && i4 > i)) {
            i5 = Math.round(((float) i3) / ((float) i2));
            int round = Math.round(((float) i4) / ((float) i));
            if (!z) {
                if (i5 >= round) {
                    round = i5;
                }
                i5 = round;
            } else if (i5 >= round) {
                i5 = round;
            }
            float f = (float) (i4 * i3);
            float f2 = (float) ((i * i2) * 2);
            if (ApiHelper.hasNougat()) {
                while (f / ((float) (i5 * i5)) >= f2) {
                    i5++;
                }
                if (z && (((double) (i4 / i5)) > ((double) i) * 1.5d || ((double) (i3 / i5)) > ((double) i2) * 1.5d)) {
                    i5 = i4 / i;
                    round = i3 / i2;
                    if (i5 <= round) {
                        i5 = round;
                    }
                }
            } else {
                while (f / ((float) (i5 * i5)) > f2) {
                    i5++;
                }
                if (isPowerOf2(i5)) {
                    round = i5;
                } else {
                    round = i5;
                    while (round > 2 && !isPowerOf2(round)) {
                        round--;
                    }
                }
                if (z && (((double) (i4 / round)) > ((double) i) * 1.5d || ((double) (i3 / round)) > ((double) i2) * 1.5d)) {
                    i5 = round * 2;
                }
            }
        }
        LogUtils.m50199d(TAG, "[calculateInSampleSize] source size = " + i4 + " * " + i3 + ", request size = " + i + " * " + i2 + ", inSampleSize = " + i5 + ", preferLarge = " + z);
        AppMethodBeat.m2505o(49650);
        return i5;
    }

    public static int calculateInSampleSizeNew(Options options, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(49651);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        float max = (float) Math.max(i4, i3);
        float min = (float) Math.min(i4, i3);
        float max2 = (float) Math.max(i, i2);
        if (((float) Math.min(i, i2)) <= 0.0f || max <= max2) {
            AppMethodBeat.m2505o(49651);
            return 1;
        }
        if (max / min > 2.0f) {
            float f = (float) (i3 * i4);
            max = (float) (i * i2);
            if (ApiHelper.hasNougat()) {
                i3 = 1;
                while (f / ((float) (i3 * i3)) >= max) {
                    i3++;
                }
                if (z && i3 > 1) {
                    i3--;
                }
            } else {
                i3 = 1;
                while (f / ((float) (i3 * i3)) >= max) {
                    i3 *= 2;
                }
                if (z && i3 > 1) {
                    i3 /= 2;
                }
            }
        } else if (ApiHelper.hasNougat()) {
            i3 = 1;
            while (max / ((float) i3) >= max2) {
                i3++;
            }
            if (z && i3 > 1) {
                i3--;
            }
        } else {
            i3 = 1;
            while (max / ((float) i3) >= max2) {
                i3 *= 2;
            }
            if (z && i3 > 1) {
                i3 /= 2;
            }
        }
        AppMethodBeat.m2505o(49651);
        return i3;
    }

    private static boolean isPowerOf2(int i) {
        return ((i + -1) & i) == 0;
    }
}
