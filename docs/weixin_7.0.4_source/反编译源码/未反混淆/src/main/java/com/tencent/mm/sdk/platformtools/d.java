package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.b;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private static DisplayMetrics ghw = null;

    private static Options H(InputStream inputStream) {
        AppMethodBeat.i(93317);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        if (inputStream == null) {
            ab.e("MicroMsg.BitmapUtil", "getImageOptions decode stream is null!!");
            AppMethodBeat.o(93317);
        } else {
            try {
                Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
                if (decodeStream != null) {
                    ab.i("MicroMsg.BitmapUtil", "getImageOptions bitmap recycle. %s", decodeStream);
                    decodeStream.recycle();
                }
            } catch (OutOfMemoryError e) {
                ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "Decode bitmap failed.", new Object[0]);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.BitmapUtil", e2, "hy: stream close failed ", new Object[0]);
                }
                AppMethodBeat.o(93317);
            }
        }
        return options;
    }

    public static Options amj(String str) {
        AppMethodBeat.i(93318);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.BitmapUtil", "getImageOptions invalid path");
            AppMethodBeat.o(93318);
            return null;
        }
        Options H;
        try {
            H = H(e.openRead(str));
            AppMethodBeat.o(93318);
            return H;
        } catch (FileNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "Decode bitmap failed.", new Object[0]);
            H = new Options();
            AppMethodBeat.o(93318);
            return H;
        }
    }

    public static Bitmap au(int i, int i2, int i3) {
        AppMethodBeat.i(93319);
        try {
            Bitmap createBitmap = createBitmap(i2, i3, Config.ARGB_8888, false);
            new Canvas(createBitmap).drawColor(i);
            createBitmap = c.ag(createBitmap);
            AppMethodBeat.o(93319);
            return createBitmap;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "", new Object[0]);
            AppMethodBeat.o(93319);
            return null;
        }
    }

    public static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        AppMethodBeat.i(93321);
        boolean b = b(str, i, i2, compressFormat, i3, str2);
        AppMethodBeat.o(93321);
        return b;
    }

    public static int av(int i, int i2, int i3) {
        AppMethodBeat.i(93322);
        int i4 = 1;
        if (i > 144 || i2 > i3) {
            if (i2 > i) {
                i4 = Math.round((((float) i) / 144.0f) + 0.5f);
            } else {
                i4 = Math.round((((float) i2) / ((float) i3)) + 0.5f);
            }
            while (((float) (i2 * i)) / ((float) (i4 * i4)) > ((float) ((i3 * 144) * 2))) {
                i4++;
            }
        }
        AppMethodBeat.o(93322);
        return i4;
    }

    public static Point amk(String str) {
        AppMethodBeat.i(93323);
        Options amj = amj(str);
        if (amj != null) {
            Point point = new Point(amj.outWidth, amj.outHeight);
            AppMethodBeat.o(93323);
            return point;
        }
        AppMethodBeat.o(93323);
        return null;
    }

    private static boolean b(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        AppMethodBeat.i(93324);
        boolean a = a(str, i, i2, compressFormat, i3, str2, false, new PInt(), new PInt());
        AppMethodBeat.o(93324);
        return a;
    }

    public static boolean c(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        AppMethodBeat.i(93325);
        boolean a = a(str, i, i2, compressFormat, i3, str2, true, new PInt(), new PInt());
        AppMethodBeat.o(93325);
        return a;
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, boolean z, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(93326);
        boolean a = a(str, i, i2, compressFormat, i3, str2, z, pInt, pInt2, false);
        AppMethodBeat.o(93326);
        return a;
    }

    public static boolean a(String str, int i, int i2, CompressFormat compressFormat, String str2, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(93327);
        boolean a = a(str, i, i2, compressFormat, 80, str2, true, pInt, pInt2, true);
        AppMethodBeat.o(93327);
        return a;
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, boolean z, PInt pInt, PInt pInt2, boolean z2) {
        AppMethodBeat.i(93328);
        Bitmap d = d(str, i, i2, z2);
        if (d == null) {
            AppMethodBeat.o(93328);
            return false;
        }
        if (z) {
            d = b(d, (float) Exif.fromFile(str).getOrientationInDegree());
        }
        try {
            pInt.value = d.getWidth();
            pInt2.value = d.getHeight();
            a(d, i3, compressFormat, str2, true);
            AppMethodBeat.o(93328);
            return true;
        } catch (IOException e) {
            ab.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
            AppMethodBeat.o(93328);
            return false;
        }
    }

    public static int a(boolean z, String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, b bVar) {
        AppMethodBeat.i(93329);
        Bitmap d = d(str, i, i2, false);
        if (d == null) {
            AppMethodBeat.o(93329);
            return -1;
        }
        d = b(d, (float) Exif.fromFile(str).getOrientationInDegree());
        if (bVar != null) {
            bVar.getFile();
        }
        if (z) {
            try {
                ab.i("MicroMsg.BitmapUtil", "dkimgopt compressByQualityOptim ret:%d  [%d,%d,%d] path:%s", Integer.valueOf(q.b(d, i3, str2)), Integer.valueOf(i3), Integer.valueOf(d.getWidth()), Integer.valueOf(d.getHeight()), str2);
                AppMethodBeat.o(93329);
                return r0;
            } catch (IOException e) {
                ab.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
                AppMethodBeat.o(93329);
                return -2;
            }
        }
        a(d, i3, compressFormat, str2, true);
        AppMethodBeat.o(93329);
        return 1;
    }

    public static Bitmap ao(String str, int i, int i2) {
        AppMethodBeat.i(93330);
        Bitmap d = d(str, i, i2, false);
        if (d == null) {
            AppMethodBeat.o(93330);
            return null;
        }
        ab.d("MicroMsg.BitmapUtil", "degress:%d", Integer.valueOf(Exif.fromFile(str).getOrientationInDegree()));
        d = b(d, (float) r1);
        AppMethodBeat.o(93330);
        return d;
    }

    public static boolean b(String str, int i, int i2, CompressFormat compressFormat, String str2, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(93331);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.BitmapUtil", "file path is null.");
            AppMethodBeat.o(93331);
            return false;
        } else if (e.ct(str)) {
            Bitmap b;
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            ab.d("MicroMsg.BitmapUtil", "degress:%d", Integer.valueOf(orientationInDegree));
            if (orientationInDegree == 90 || orientationInDegree == 270) {
                b = b(d(str, i2, i, true), (float) orientationInDegree);
            } else {
                b = b(d(str, i, i2, true), (float) orientationInDegree);
            }
            if (b == null) {
                AppMethodBeat.o(93331);
                return false;
            }
            try {
                pInt.value = b.getWidth();
                pInt2.value = b.getHeight();
                a(b, 80, compressFormat, str2, true);
                AppMethodBeat.o(93331);
                return true;
            } catch (IOException e) {
                ab.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
                AppMethodBeat.o(93331);
                return false;
            }
        } else {
            ab.w("MicroMsg.BitmapUtil", "file did not exists.");
            AppMethodBeat.o(93331);
            return false;
        }
    }

    public static Bitmap ah(Bitmap bitmap) {
        int width;
        float f = 2.5f;
        AppMethodBeat.i(93332);
        int i = 120;
        float height;
        if (bitmap.getHeight() >= bitmap.getWidth()) {
            height = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            if (height <= 2.0f) {
                width = (int) ((((double) bitmap.getWidth()) * 120.0d) / ((double) bitmap.getHeight()));
            } else {
                if (((double) height) > 2.5d) {
                    bitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - ((int) (((float) bitmap.getWidth()) * 2.5f))) / 2, bitmap.getWidth(), (int) (((float) bitmap.getWidth()) * 2.5f));
                } else {
                    f = height;
                }
                int i2 = (int) (f * 56.0f);
                width = 56;
                i = i2;
            }
        } else {
            height = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            if (height <= 2.0f) {
                width = 120;
                i = (int) ((((double) bitmap.getHeight()) * 120.0d) / ((double) bitmap.getWidth()));
            } else {
                if (((double) height) > 2.5d) {
                    bitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - ((int) (((float) bitmap.getHeight()) * 2.5f))) / 2, 0, (int) (((float) bitmap.getHeight()) * 2.5f), bitmap.getHeight());
                } else {
                    f = height;
                }
                width = (int) (f * 56.0f);
                i = 56;
            }
        }
        ab.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + bitmap.getWidth() + VideoMaterialUtil.CRAZYFACE_X + bitmap.getHeight());
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, i, true);
        if (!(createScaledBitmap == null || bitmap == createScaledBitmap)) {
            ab.i("MicroMsg.BitmapUtil", "extractThumeNail bitmap recycle. %s", bitmap);
            bitmap.recycle();
            bitmap = createScaledBitmap;
        }
        AppMethodBeat.o(93332);
        return bitmap;
    }

    public static Bitmap aml(String str) {
        AppMethodBeat.i(93333);
        Bitmap a = a(str, 0, 0, 0.0f);
        AppMethodBeat.o(93333);
        return a;
    }

    public static Bitmap LV(int i) {
        AppMethodBeat.i(93334);
        Bitmap a = a(i, null, null, null, false, 0.0f, 0, 0);
        AppMethodBeat.o(93334);
        return a;
    }

    public static Bitmap o(int i, float f) {
        AppMethodBeat.i(93335);
        Bitmap a = a(i, null, null, null, false, f, 0, 0);
        AppMethodBeat.o(93335);
        return a;
    }

    public static Bitmap aw(int i, int i2, int i3) {
        AppMethodBeat.i(93336);
        Bitmap a = a(i, null, null, null, false, 0.0f, i2, i3);
        AppMethodBeat.o(93336);
        return a;
    }

    public static Bitmap j(String str, float f) {
        AppMethodBeat.i(93337);
        Bitmap a = a(str, 0, 0, f);
        AppMethodBeat.o(93337);
        return a;
    }

    public static Bitmap ap(String str, int i, int i2) {
        AppMethodBeat.i(93338);
        Bitmap a = a(str, i, i2, 0.0f);
        AppMethodBeat.o(93338);
        return a;
    }

    public static Bitmap a(String str, int i, int i2, float f) {
        AppMethodBeat.i(93339);
        Bitmap a = a(0, str, null, null, false, f, i, i2);
        AppMethodBeat.o(93339);
        return a;
    }

    private static Bitmap createBitmap(int i, int i2, Config config, boolean z) {
        Bitmap bitmap = null;
        AppMethodBeat.i(93341);
        try {
            bitmap = Bitmap.createBitmap(i, i2, config);
        } catch (Throwable th) {
        }
        am(bitmap);
        bitmap = c.ag(bitmap);
        AppMethodBeat.o(93341);
        return bitmap;
    }

    public static Bitmap createBitmap(int i, int i2, Config config) {
        AppMethodBeat.i(139049);
        Bitmap createBitmap = createBitmap(i, i2, config, false);
        AppMethodBeat.o(139049);
        return createBitmap;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(93343);
        if (bo.cb(bArr)) {
            ab.w("MicroMsg.BitmapUtil", "error input: data is null");
            AppMethodBeat.o(93343);
            return null;
        } else if (i < 0 || i2 < 0) {
            ab.w("MicroMsg.BitmapUtil", "error input: targetWidth %d, targetHeight %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(93343);
            return null;
        } else {
            Bitmap a = a(0, null, bArr, null, false, 0.0f, i, i2);
            AppMethodBeat.o(93343);
            return a;
        }
    }

    public static Bitmap bQ(byte[] bArr) {
        AppMethodBeat.i(93344);
        Bitmap decodeByteArray = decodeByteArray(bArr, 0, 0);
        AppMethodBeat.o(93344);
        return decodeByteArray;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045 A:{SYNTHETIC, Splitter:B:24:0x0045} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap decodeFile(String str, Options options) {
        IOException e;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.i(93345);
        if (options == null) {
            options = new Options();
        }
        InputStream openRead;
        try {
            openRead = e.openRead(str);
            try {
                bitmap = MMBitmapFactory.decodeStream(openRead, null, options);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(93345);
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e = e4;
            openRead = bitmap;
            try {
                ab.e("MicroMsg.BitmapUtil", "Cannot decode file '%s': %s", str, e.getMessage());
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.o(93345);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.o(93345);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            openRead = bitmap;
            if (openRead != null) {
            }
            AppMethodBeat.o(93345);
            throw th;
        }
        return bitmap;
    }

    public static Bitmap a(InputStream inputStream, float f, int i, int i2) {
        Bitmap decodeStream;
        AppMethodBeat.i(93346);
        Options options = new Options();
        if (f != 0.0f) {
            options.inDensity = (int) (160.0f * f);
        }
        if (!(i == 0 && i2 == 0)) {
            int i3;
            int i4;
            if (i == 0) {
                i = BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (i2 == 0) {
                i2 = BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (inputStream instanceof FileInputStream) {
                inputStream = new l((FileInputStream) inputStream);
            } else if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream, 65536);
            }
            inputStream.mark(25165824);
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(inputStream, null, options);
            int i5 = options.outWidth;
            int i6 = options.outHeight;
            if ((i <= i2 || i5 >= i6) && (i >= i2 || i5 <= i6)) {
                i3 = i6;
                i4 = i5;
            } else {
                i3 = i5;
                i4 = i6;
            }
            if (i4 > i || i3 > i2) {
                options.inSampleSize = (int) Math.max(((float) i4) / ((float) i), ((float) i3) / ((float) i2));
            }
            options.inJustDecodeBounds = false;
            try {
                inputStream.reset();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "Failed seeking InputStream.", new Object[0]);
            }
        }
        options.inPreferredConfig = Config.ARGB_8888;
        try {
            decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
        } catch (OutOfMemoryError e2) {
            options.inPreferredConfig = Config.RGB_565;
            try {
                decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
            } catch (OutOfMemoryError e3) {
                ab.e("MicroMsg.BitmapUtil", "decodeStream OutOfMemoryError return null");
                decodeStream = null;
            }
        }
        AppMethodBeat.o(93346);
        return decodeStream;
    }

    public static Bitmap a(InputStream inputStream, float f) {
        AppMethodBeat.i(93347);
        Bitmap a = a(inputStream, f, 0, 0);
        AppMethodBeat.o(93347);
        return a;
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        AppMethodBeat.i(93348);
        Bitmap a = a(inputStream, 0.0f, 0, 0);
        AppMethodBeat.o(93348);
        return a;
    }

    public static DisplayMetrics anS() {
        AppMethodBeat.i(93349);
        if (ghw == null) {
            ghw = ah.getContext().getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = ghw;
        AppMethodBeat.o(93349);
        return displayMetrics;
    }

    private static Bitmap a(int i, String str, byte[] bArr, Uri uri, boolean z, float f, int i2, int i3) {
        AppMethodBeat.i(93350);
        Bitmap b = b(i, str, bArr, uri, z, f, i2, i3);
        AppMethodBeat.o(93350);
        return b;
    }

    private static Bitmap b(int i, String str, byte[] bArr, Uri uri, boolean z, float f, int i2, int i3) {
        Object obj;
        AppMethodBeat.i(93351);
        if (i2 == 0 && i3 == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (i2 < 0 || i3 < 0) {
            AppMethodBeat.o(93351);
            return null;
        }
        Bitmap a;
        Options options;
        int i4;
        try {
            options = new Options();
            if (f != 0.0f) {
                options.inDensity = (int) (160.0f * f);
            }
            if (obj == null) {
                int i5;
                options.inJustDecodeBounds = true;
                a(options, bArr, str, uri, z, i);
                int i6 = options.outWidth;
                int i7 = options.outHeight;
                options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                if ((i2 <= i3 || i6 >= i7) && (i2 >= i3 || i6 <= i7)) {
                    i4 = i7;
                    i5 = i6;
                } else {
                    i4 = i6;
                    i5 = i7;
                }
                if (i5 > i2 || i4 > i3) {
                    options.inSampleSize = (int) Math.max(((float) i5) / ((float) i2), ((float) i4) / ((float) i3));
                    int i8 = options.inSampleSize;
                }
            }
            a = a(options, bArr, str, uri, z, i);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.BitmapUtil", th, "", new Object[0]);
            a = null;
        }
        am(a);
        a = c.ag(a);
        AppMethodBeat.o(93351);
        return a;
    }

    private static Bitmap a(Options options, byte[] bArr, String str, Uri uri, boolean z, int i) {
        Object obj = null;
        Bitmap bitmap = null;
        AppMethodBeat.i(93352);
        try {
            InputStream open;
            Throwable th;
            if (bo.cb(bArr) && bo.isNullOrNil(str) && uri == null && i <= 0) {
                return bitmap;
            }
            if (!bo.cb(bArr)) {
                obj = 1;
            }
            if (obj != null) {
                bitmap = MMBitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            } else if (i > 0) {
                bitmap = a.decodeResource(ah.getContext().getResources(), i, options);
            } else {
                if (z) {
                    try {
                        if (bo.isNullOrNil(str)) {
                            am(bitmap);
                            AppMethodBeat.o(93352);
                            return bitmap;
                        }
                        open = ah.getContext().getAssets().open(str);
                    } catch (Throwable th2) {
                        th = th2;
                        open = bitmap;
                    }
                } else if (uri != null) {
                    open = ah.getContext().getContentResolver().openInputStream(uri);
                } else {
                    open = e.openRead(str);
                }
                try {
                    bitmap = MMBitmapFactory.decodeStream(open, null, options);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            am(bitmap);
            bitmap = c.ag(bitmap);
            AppMethodBeat.o(93352);
            return bitmap;
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(93352);
            throw th;
            AppMethodBeat.o(93352);
            throw th;
        } finally {
            am(bitmap);
            AppMethodBeat.o(93352);
        }
    }

    public static void dnX() {
    }

    @TargetApi(11)
    private static Bitmap a(InputStream inputStream, int i, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(138277);
        if (i3 <= 0 || i4 <= 0) {
            ab.e("MicroMsg.BitmapUtil", "extractThumbNail height:" + i4 + " width:" + i3);
            AppMethodBeat.o(138277);
            return null;
        } else if (i <= 0 || i2 <= 0) {
            ab.e("MicroMsg.BitmapUtil", "decode[%s] error, outHeight[%d] outWidth[%d]", inputStream, Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(138277);
            return null;
        } else {
            try {
                int ceil;
                int i5;
                Options options = new Options();
                ab.i("MicroMsg.BitmapUtil", "extractThumbNail: round=" + i3 + VideoMaterialUtil.CRAZYFACE_X + i4 + ", crop=" + z);
                double d = (((double) i2) * 1.0d) / ((double) i4);
                double d2 = (((double) i) * 1.0d) / ((double) i3);
                ab.d("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d2 + ", beY = " + d);
                double d3 = z ? d > d2 ? d2 : d : d < d2 ? d2 : d;
                options.inSampleSize = (int) d3;
                if (options.inSampleSize <= 1) {
                    options.inSampleSize = 1;
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                if (z) {
                    if (d > d2) {
                        ceil = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i2)) / ((double) i));
                        i5 = i3;
                    } else {
                        i5 = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i)) / ((double) i2));
                        ceil = i4;
                    }
                } else if (d < d2) {
                    ceil = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i2)) / ((double) i));
                    i5 = i3;
                } else {
                    i5 = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i)) / ((double) i2));
                    ceil = i4;
                }
                int i6 = ceil > 0 ? ceil : 1;
                if (i5 > 0) {
                    ceil = i5;
                } else {
                    ceil = 1;
                }
                if (VERSION.SDK_INT >= 11) {
                    options.inMutable = true;
                }
                ab.i("MicroMsg.BitmapUtil", "bitmap required size=" + ceil + VideoMaterialUtil.CRAZYFACE_X + i6 + ", orig=" + i + VideoMaterialUtil.CRAZYFACE_X + i2 + ", sample=" + options.inSampleSize);
                Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
                if (decodeStream == null) {
                    ab.e("MicroMsg.BitmapUtil", "bitmap decode failed");
                    AppMethodBeat.o(138277);
                    return null;
                }
                ab.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + decodeStream.getWidth() + VideoMaterialUtil.CRAZYFACE_X + decodeStream.getHeight());
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, ceil, i6, true);
                if (decodeStream == createScaledBitmap || createScaledBitmap == null) {
                    createScaledBitmap = decodeStream;
                } else {
                    ab.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfad. %s", decodeStream);
                    decodeStream.recycle();
                }
                if (z) {
                    if (createScaledBitmap.getWidth() < i3) {
                        ab.e("MicroMsg.BitmapUtil", "bmw < width %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(i3));
                        i3 = createScaledBitmap.getWidth();
                    }
                    if (createScaledBitmap.getHeight() < i4) {
                        ab.e("MicroMsg.BitmapUtil", "bmh < height %d %d", Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i4));
                        i4 = createScaledBitmap.getHeight();
                    }
                    i6 = (createScaledBitmap.getWidth() - i3) >> 1;
                    i5 = (createScaledBitmap.getHeight() - i4) >> 1;
                    if (i6 < 0 || i5 < 0) {
                        ab.e("MicroMsg.BitmapUtil", "fix crop image error %d %d %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i3), Integer.valueOf(i4));
                        if (i6 < 0) {
                            i6 = 0;
                        }
                        if (i5 < 0) {
                            i5 = 0;
                        }
                    }
                    decodeStream = Bitmap.createBitmap(createScaledBitmap, i6, i5, i3, i4);
                    if (decodeStream == null) {
                        AppMethodBeat.o(138277);
                        return createScaledBitmap;
                    }
                    if (decodeStream != createScaledBitmap) {
                        ab.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfaasdfad. %s", createScaledBitmap);
                        createScaledBitmap.recycle();
                        createScaledBitmap = decodeStream;
                    }
                    ab.d("MicroMsg.BitmapUtil", "bitmap croped size=" + createScaledBitmap.getWidth() + VideoMaterialUtil.CRAZYFACE_X + createScaledBitmap.getHeight());
                }
                am(createScaledBitmap);
                decodeStream = c.ag(createScaledBitmap);
                AppMethodBeat.o(138277);
                return decodeStream;
            } catch (OutOfMemoryError e) {
                ab.e("MicroMsg.BitmapUtil", "decode bitmap failed: " + e.getMessage());
                AppMethodBeat.o(138277);
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A:{SYNTHETIC, Splitter:B:22:0x0056} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A:{SYNTHETIC, Splitter:B:22:0x0056} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap d(String str, int i, int i2, boolean z) {
        Throwable e;
        InputStream inputStream;
        AppMethodBeat.i(93354);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.BitmapUtil", "extractThumbNail path null or nil");
            AppMethodBeat.o(93354);
            return null;
        }
        try {
            Options amj = amj(str);
            InputStream openRead = e.openRead(str);
            try {
                Bitmap a = a(openRead, amj.outWidth, amj.outHeight, i2, i, z);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(93354);
                return a;
            } catch (FileNotFoundException e3) {
                e = e3;
                inputStream = openRead;
            } catch (Throwable th) {
                e = th;
                inputStream = openRead;
                if (inputStream != null) {
                }
                AppMethodBeat.o(93354);
                throw e;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            inputStream = null;
        } catch (Throwable e42) {
            e = e42;
            inputStream = null;
            if (inputStream != null) {
            }
            AppMethodBeat.o(93354);
            throw e;
        }
        try {
            ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "Failed decode bitmap.", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(93354);
            return null;
        } catch (Throwable e422) {
            e = e422;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(93354);
            throw e;
        }
        AppMethodBeat.o(93354);
        return null;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
        Throwable th;
        AppMethodBeat.i(93355);
        if (bitmap == null) {
            ab.e("MicroMsg.BitmapUtil", "extractThumbNail bitmap is null.");
            AppMethodBeat.o(93355);
            return null;
        } else if (i <= 0 || i2 <= 0) {
            try {
                ab.e("MicroMsg.BitmapUtil", "extractThumbNail height:" + i + " width:" + i2);
                am(bitmap);
                AppMethodBeat.o(93355);
                return null;
            } catch (Throwable th2) {
                th = th2;
                am(bitmap);
                AppMethodBeat.o(93355);
                throw th;
            }
        } else {
            int ceil;
            int i3;
            Bitmap createBitmap;
            Options options = new Options();
            options.outHeight = bitmap.getHeight();
            options.outWidth = bitmap.getWidth();
            ab.i("MicroMsg.BitmapUtil", "extractThumbNail: round=" + i2 + VideoMaterialUtil.CRAZYFACE_X + i + ", crop=" + z + ", recycle=" + z2);
            double d = (((double) options.outHeight) * 1.0d) / ((double) i);
            double d2 = (((double) options.outWidth) * 1.0d) / ((double) i2);
            ab.d("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d2 + ", beY = " + d);
            double d3 = z ? d > d2 ? d2 : d : d < d2 ? d2 : d;
            options.inSampleSize = (int) d3;
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                options.inSampleSize++;
            }
            if (z) {
                if (d > d2) {
                    ceil = (int) Math.ceil(((((double) i2) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                    i3 = i2;
                } else {
                    i3 = (int) Math.ceil(((((double) i) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                    ceil = i;
                }
            } else if (d < d2) {
                ceil = (int) Math.ceil(((((double) i2) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                i3 = i2;
            } else {
                i3 = (int) Math.ceil(((((double) i) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                ceil = i;
            }
            options.inJustDecodeBounds = false;
            ab.i("MicroMsg.BitmapUtil", "bitmap required size=" + i3 + VideoMaterialUtil.CRAZYFACE_X + ceil + ", orig=" + options.outWidth + VideoMaterialUtil.CRAZYFACE_X + options.outHeight + ", sample=" + options.inSampleSize);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, ceil, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = bitmap;
            } else if (z2 && bitmap != createScaledBitmap) {
                ab.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle asdfjasjdfja asdfasd. %s", bitmap);
                bitmap.recycle();
            }
            if (z) {
                try {
                    if (createScaledBitmap.getWidth() < i2) {
                        ab.e("MicroMsg.BitmapUtil", "bmw < width %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(i2));
                        i2 = createScaledBitmap.getWidth();
                    }
                    if (createScaledBitmap.getHeight() < i) {
                        ab.e("MicroMsg.BitmapUtil", "bmh < height %d %d", Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i));
                        i = createScaledBitmap.getHeight();
                    }
                    createBitmap = Bitmap.createBitmap(createScaledBitmap, (createScaledBitmap.getWidth() - i2) >> 1, (createScaledBitmap.getHeight() - i) >> 1, i2, i);
                    if (createBitmap == null) {
                        am(createScaledBitmap);
                        AppMethodBeat.o(93355);
                        return createScaledBitmap;
                    }
                    if (z2 && createScaledBitmap != createBitmap) {
                        ab.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle ajdfjajsdfjdsajjfsad. %s", createScaledBitmap);
                        createScaledBitmap.recycle();
                    }
                    try {
                        ab.d("MicroMsg.BitmapUtil", "bitmap croped size=" + createBitmap.getWidth() + VideoMaterialUtil.CRAZYFACE_X + createBitmap.getHeight());
                    } catch (Throwable th3) {
                        th = th3;
                        bitmap = createBitmap;
                        am(bitmap);
                        AppMethodBeat.o(93355);
                        throw th;
                    }
                } catch (Throwable th22) {
                    th = th22;
                    bitmap = createScaledBitmap;
                    am(bitmap);
                    AppMethodBeat.o(93355);
                    throw th;
                }
            }
            createBitmap = createScaledBitmap;
            am(createBitmap);
            AppMethodBeat.o(93355);
            return createBitmap;
        }
    }

    public static Bitmap aq(String str, int i, int i2) {
        AppMethodBeat.i(93356);
        Bitmap a = a(0, str, null, null, true, 0.0f, i, i2);
        AppMethodBeat.o(93356);
        return a;
    }

    public static Bitmap a(Bitmap bitmap, float f, float f2) {
        AppMethodBeat.i(93357);
        if (bitmap == null) {
            AppMethodBeat.o(93357);
            return null;
        } else if (((double) f) <= 0.999d || ((double) f) >= 1.001d || ((double) f2) <= 0.999d || ((double) f2) >= 1.001d) {
            Matrix matrix = new Matrix();
            matrix.reset();
            if (((double) f) < 0.999d || ((double) f) > 1.001d || ((double) f2) < 0.999d || ((double) f2) > 1.001d) {
                matrix.postScale(f, f2);
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            am(createBitmap);
            ab.d("MicroMsg.BitmapUtil", "resultBmp is null: " + (createBitmap == null) + "  degree:0.0");
            if (bitmap != createBitmap) {
                ab.i("MicroMsg.BitmapUtil", "rotateAndScale bitmap recycle asdfasdjfjasdfjsadfjdsa. %s", bitmap);
                bitmap.recycle();
            }
            bitmap = c.ag(createBitmap);
            AppMethodBeat.o(93357);
            return bitmap;
        } else {
            AppMethodBeat.o(93357);
            return bitmap;
        }
    }

    public static Bitmap b(Bitmap bitmap, float f) {
        Throwable th;
        AppMethodBeat.i(93358);
        if (f % 360.0f == 0.0f) {
            AppMethodBeat.o(93358);
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            try {
                boolean z;
                am(createBitmap);
                String str = "MicroMsg.BitmapUtil";
                StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
                if (createBitmap == null) {
                    z = true;
                } else {
                    z = false;
                }
                ab.d(str, stringBuilder.append(z).append("  degree:").append(f).toString());
                if (bitmap != createBitmap) {
                    ab.i("MicroMsg.BitmapUtil", "rotate bitmap recycle ajsdfasdf adsf. %s", bitmap);
                    bitmap.recycle();
                }
                bitmap = c.ag(createBitmap);
                AppMethodBeat.o(93358);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                bitmap = createBitmap;
                ab.d("MicroMsg.BitmapUtil", "createBitmap failed : %s ", bo.l(th));
                AppMethodBeat.o(93358);
                return bitmap;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(String str, int i, CompressFormat compressFormat, String str2, String str3) {
        AppMethodBeat.i(93360);
        boolean a = a(str, i, compressFormat, 90, str2 + str3);
        AppMethodBeat.o(93360);
        return a;
    }

    public static void a(Bitmap bitmap, int i, CompressFormat compressFormat, OutputStream outputStream, boolean z) {
        AppMethodBeat.i(93361);
        a(bitmap, compressFormat, i, outputStream);
        if (z) {
            ab.i("MicroMsg.BitmapUtil", "saveBitmapToStream bitmap recycle. %s", bitmap);
            bitmap.recycle();
        }
        AppMethodBeat.o(93361);
    }

    public static void a(Bitmap bitmap, int i, CompressFormat compressFormat, String str, boolean z) {
        AppMethodBeat.i(93362);
        if (bo.isNullOrNil(str)) {
            IOException iOException = new IOException("saveBitmapToImage pathName null or nil");
            AppMethodBeat.o(93362);
            throw iOException;
        }
        ab.d("MicroMsg.BitmapUtil", "saving to ".concat(String.valueOf(str)));
        OutputStream outputStream = null;
        e.tf(e.atb(str));
        try {
            outputStream = e.L(str, false);
            a(bitmap, i, compressFormat, outputStream, z);
            if (z) {
                ab.i("MicroMsg.BitmapUtil", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                    AppMethodBeat.o(93362);
                    return;
                } catch (IOException e) {
                    AppMethodBeat.o(93362);
                    return;
                }
            }
            AppMethodBeat.o(93362);
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.BitmapUtil", e2, "saveBitmapToImage failed: %s", str);
            IOException iOException2 = new IOException(e2);
            AppMethodBeat.o(93362);
            throw iOException2;
        } catch (Throwable th) {
            if (z) {
                ab.i("MicroMsg.BitmapUtil", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(93362);
        }
    }

    public static Bitmap b(Bitmap bitmap, int i, int i2, boolean z) {
        AppMethodBeat.i(93363);
        if (bitmap == null) {
            AppMethodBeat.o(93363);
            return null;
        }
        Bitmap createBitmap;
        am(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float max = Math.max(((float) i) / ((float) width), ((float) i2) / ((float) height));
        float f = ((float) width) * max;
        float f2 = ((float) height) * max;
        max = (((float) i) - f) / 2.0f;
        float f3 = (((float) i2) - f2) / 2.0f;
        RectF rectF = new RectF(max, f3, f + max, f2 + f3);
        Config config = bitmap.getConfig();
        if (config == null) {
            ab.w("MicroMsg.BitmapUtil", "get center crop bitmap, config is null");
            config = Config.ARGB_8888;
        }
        try {
            createBitmap = Bitmap.createBitmap(i, i2, config);
        } catch (Throwable th) {
            ab.e("MicroMsg.BitmapUtil", "BitmapUtil decode getCenterCropBitmap fail");
            AppMethodBeat.o(93363);
            return bitmap;
        }
        new Canvas(createBitmap).drawBitmap(bitmap, null, rectF, null);
        if (z) {
            ab.i("MicroMsg.BitmapUtil", "getCenterCropBitmap bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        am(createBitmap);
        bitmap = c.ag(createBitmap);
        AppMethodBeat.o(93363);
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, boolean z, float f, boolean z2) {
        AppMethodBeat.i(93364);
        if (bitmap == null || bitmap.isRecycled()) {
            ab.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap in bitmap is null");
            AppMethodBeat.o(93364);
            return null;
        }
        am(bitmap);
        Bitmap createBitmap = createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888, z2);
        if (createBitmap == null) {
            AppMethodBeat.o(93364);
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-4144960);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z) {
            ab.i("MicroMsg.BitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        am(createBitmap);
        Bitmap ag = c.ag(createBitmap);
        AppMethodBeat.o(93364);
        return ag;
    }

    public static Bitmap a(Bitmap bitmap, boolean z, float f) {
        AppMethodBeat.i(93365);
        Bitmap a = a(bitmap, z, f, false);
        AppMethodBeat.o(93365);
        return a;
    }

    public static Bitmap v(Drawable drawable) {
        AppMethodBeat.i(93366);
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            AppMethodBeat.o(93366);
            return bitmap;
        }
        bitmap = createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888, false);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        am(bitmap);
        bitmap = c.ag(bitmap);
        AppMethodBeat.o(93366);
        return bitmap;
    }

    public static byte[] ai(Bitmap bitmap) {
        AppMethodBeat.i(93367);
        byte[] c = c(bitmap, 100);
        AppMethodBeat.o(93367);
        return c;
    }

    public static byte[] c(Bitmap bitmap, int i) {
        AppMethodBeat.i(93368);
        byte[] bArr;
        if (bitmap == null || bitmap.isRecycled()) {
            bArr = new byte[0];
            AppMethodBeat.o(93368);
            return bArr;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(bitmap, CompressFormat.JPEG, i, byteArrayOutputStream);
        bArr = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "", new Object[0]);
        }
        AppMethodBeat.o(93368);
        return bArr;
    }

    public static byte[] aj(Bitmap bitmap) {
        AppMethodBeat.i(93369);
        byte[] bArr;
        if (bitmap == null || bitmap.isRecycled()) {
            bArr = new byte[0];
            AppMethodBeat.o(93369);
            return bArr;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(bitmap, CompressFormat.PNG, 100, byteArrayOutputStream);
        bArr = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "", new Object[0]);
        }
        AppMethodBeat.o(93369);
        return bArr;
    }

    public static void c(String str, PInt pInt, PInt pInt2) {
        Bitmap bitmap = null;
        AppMethodBeat.i(93370);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            bitmap = MMBitmapFactory.decodeStream(e.openRead(str), null, options);
        } catch (FileNotFoundException e) {
        }
        if (bitmap != null) {
            ab.i("MicroMsg.BitmapUtil", "getRent bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        pInt.value = options.outWidth;
        pInt2.value = options.outHeight;
        AppMethodBeat.o(93370);
    }

    public static Bitmap eA(View view) {
        AppMethodBeat.i(93371);
        if (view == null) {
            AppMethodBeat.o(93371);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        }
        view.draw(canvas);
        am(createBitmap);
        createBitmap = c.ag(createBitmap);
        AppMethodBeat.o(93371);
        return createBitmap;
    }

    public static Bitmap eB(View view) {
        AppMethodBeat.i(93372);
        if (view == null) {
            AppMethodBeat.o(93372);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        }
        a(canvas, view);
        am(createBitmap);
        createBitmap = c.ag(createBitmap);
        AppMethodBeat.o(93372);
        return createBitmap;
    }

    public static void a(Canvas canvas, View view) {
        AppMethodBeat.i(93373);
        view.draw(canvas);
        List<v> v = v(view, (int) view.getX(), (int) view.getY());
        if (v.size() > 0) {
            for (v vVar : v) {
                if (!(vVar == null || vVar.xyt == null)) {
                    TextureView textureView = vVar.xyt;
                    Bitmap bitmap = textureView.getBitmap(textureView.getWidth(), textureView.getHeight());
                    if (bitmap == null || bitmap.isRecycled()) {
                        ab.e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
                    } else {
                        canvas.drawBitmap(bitmap, (float) vVar.left, (float) vVar.top, null);
                    }
                }
            }
        }
        AppMethodBeat.o(93373);
    }

    private static List<v> v(View view, int i, int i2) {
        AppMethodBeat.i(93374);
        ArrayList arrayList = new ArrayList();
        if (view instanceof TextureView) {
            v vVar = new v();
            vVar.xyt = (TextureView) view;
            vVar.left = i;
            vVar.top = i2;
            arrayList.add(vVar);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                arrayList.addAll(v(viewGroup.getChildAt(i3), (int) (viewGroup.getX() + ((float) i)), (int) (viewGroup.getY() + ((float) i2))));
            }
        }
        AppMethodBeat.o(93374);
        return arrayList;
    }

    public static Bitmap d(Bitmap bitmap, int i) {
        AppMethodBeat.i(93375);
        ab.d("MicroMsg.BitmapUtil", "begin createChattingImage");
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap == null) {
            ab.w("MicroMsg.BitmapUtil", "sourceBitmap is null .");
            AppMethodBeat.o(93375);
            return null;
        }
        am(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            ab.w("MicroMsg.BitmapUtil", "sourceBitmap width or height is 0.");
            AppMethodBeat.o(93375);
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            Bitmap createBitmap = createBitmap(width, height, Config.ARGB_8888, false);
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) ah.getContext().getResources().getDrawable(i);
            ninePatchDrawable.setBounds(0, 0, width, height);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            ab.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis2));
            if (createBitmap == null) {
                ab.e("MicroMsg.BitmapUtil", "[createChattingImage] maskBitmap is null.");
                AppMethodBeat.o(93375);
                return null;
            }
            int width2 = createBitmap.getWidth();
            int height2 = createBitmap.getHeight();
            if (width2 <= 0 || height2 <= 0) {
                ab.w("MicroMsg.BitmapUtil", "maskBitmap width or height is 0.");
                AppMethodBeat.o(93375);
                return null;
            } else if (height2 == height && width2 == width) {
                int[] iArr = new int[(width * height)];
                int[] iArr2 = new int[(width2 * height2)];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                createBitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
                currentTimeMillis2 = System.currentTimeMillis();
                width2 = 0;
                while (width2 < iArr2.length) {
                    try {
                        if (iArr2[width2] != -16777216) {
                            if (iArr2[width2] == 0) {
                                iArr[width2] = 0;
                            } else if (iArr2[width2] != -1) {
                                iArr[width2] = iArr[width2] & iArr2[width2];
                            }
                        }
                        width2++;
                    } catch (Exception e) {
                        ab.e("MicroMsg.BitmapUtil", e.toString());
                    }
                }
                ab.d("MicroMsg.BitmapUtil", "meger pixels  " + (System.currentTimeMillis() - currentTimeMillis2));
                long currentTimeMillis3 = System.currentTimeMillis();
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                ab.d("MicroMsg.BitmapUtil", "setPixels " + (System.currentTimeMillis() - currentTimeMillis3));
                ab.d("MicroMsg.BitmapUtil", "createTime" + (System.currentTimeMillis() - currentTimeMillis));
                am(createBitmap);
                Bitmap ag = c.ag(createBitmap);
                AppMethodBeat.o(93375);
                return ag;
            } else {
                ab.e("MicroMsg.BitmapUtil", "maskHeiht maskWidth != height width.");
                AppMethodBeat.o(93375);
                return null;
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.BitmapUtil", "[createChattingImage] create nine pathc bitmap faild.");
            AppMethodBeat.o(93375);
            return null;
        }
    }

    public static Bitmap gU(int i, int i2) {
        AppMethodBeat.i(93376);
        if (i < 0 || i2 < 0) {
            ab.w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
            AppMethodBeat.o(93376);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap ag = c.ag(createBitmap(i, i2, Config.ARGB_8888, false));
        am(ag);
        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) ah.getContext().getResources().getDrawable(R.drawable.ahf);
        ninePatchDrawable.setBounds(0, 0, i, i2);
        ninePatchDrawable.draw(new Canvas(ag));
        ab.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        Bitmap d = d(ag, R.drawable.bbi);
        AppMethodBeat.o(93376);
        return d;
    }

    public static Bitmap o(String str, int i, int i2, int i3) {
        AppMethodBeat.i(93377);
        if (str == null || str.equals("") || i < 0 || i2 < 0 || i3 < 0) {
            ab.w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
            AppMethodBeat.o(93377);
            return null;
        }
        Bitmap f = c.f(decodeByteArray(e.e(str, 0, -1), 0, 0), str);
        if (f == null || f.isRecycled()) {
            AppMethodBeat.o(93377);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap ag = c.ag(createBitmap(i2, i3, Config.ARGB_8888, false));
        am(ag);
        Canvas canvas = new Canvas(ag);
        ab.d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", Integer.valueOf(f.getWidth()), Integer.valueOf(f.getHeight()), Integer.valueOf(i2), Integer.valueOf(i3));
        canvas.drawBitmap(f, null, new Rect(0, 0, i2, i3), new Paint());
        ab.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        f = d(ag, i);
        AppMethodBeat.o(93377);
        return f;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        AppMethodBeat.i(93378);
        if (bitmap == null || i < 0 || i2 < 0 || i3 < 0) {
            AppMethodBeat.o(93378);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap ag = c.ag(createBitmap(i2, i3, Config.ARGB_8888, false));
        Canvas canvas = new Canvas(ag);
        ab.d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i2), Integer.valueOf(i3));
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, i2, i3), new Paint());
        ab.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        Bitmap d = d(ag, i);
        AppMethodBeat.o(93378);
        return d;
    }

    public static Bitmap e(Bitmap bitmap, int i) {
        AppMethodBeat.i(93380);
        if (bitmap == null) {
            ab.w("MicroMsg.BitmapUtil", "fastblur: but sentBitmap is null");
            AppMethodBeat.o(93380);
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (i <= 0) {
            AppMethodBeat.o(93380);
            return null;
        }
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int width = copy.getWidth();
        int height = copy.getHeight();
        int[] iArr = new int[(width * height)];
        ab.e("pix", width + " " + height + " " + iArr.length);
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i16 = width - 1;
        int i17 = height - 1;
        int i18 = width * height;
        int i19 = (i + i) + 1;
        int[] iArr2 = new int[i18];
        int[] iArr3 = new int[i18];
        int[] iArr4 = new int[i18];
        int[] iArr5 = new int[Math.max(width, height)];
        int i20 = (i19 + 1) >> 1;
        int i21 = i20 * i20;
        int[] iArr6 = new int[(i21 * 256)];
        for (i20 = 0; i20 < i21 * 256; i20++) {
            iArr6[i20] = i20 / i21;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i19, 3});
        int i22 = i + 1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < height) {
            i21 = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            int i26 = 0;
            for (i9 = -i; i9 <= i; i9++) {
                i10 = iArr[Math.min(i16, Math.max(i9, 0)) + i25];
                int[] iArr8 = iArr7[i9 + i];
                iArr8[0] = (16711680 & i10) >> 16;
                iArr8[1] = (65280 & i10) >> 8;
                iArr8[2] = i10 & 255;
                i10 = i22 - Math.abs(i9);
                i26 += iArr8[0] * i10;
                i7 += iArr8[1] * i10;
                i8 += i10 * iArr8[2];
                if (i9 > 0) {
                    i21 += iArr8[0];
                    i2 += iArr8[1];
                    i3 += iArr8[2];
                } else {
                    i4 += iArr8[0];
                    i5 += iArr8[1];
                    i6 += iArr8[2];
                }
            }
            i10 = 0;
            i9 = i21;
            i11 = i2;
            i12 = i3;
            i13 = i4;
            i14 = i5;
            i15 = i6;
            int i27 = i;
            while (i10 < width) {
                iArr2[i25] = iArr6[i26];
                iArr3[i25] = iArr6[i7];
                iArr4[i25] = iArr6[i8];
                i21 = i26 - i13;
                i2 = i7 - i14;
                i3 = i8 - i15;
                int[] iArr9 = iArr7[((i27 - i) + i19) % i19];
                i5 = i13 - iArr9[0];
                i6 = i14 - iArr9[1];
                i13 = i15 - iArr9[2];
                if (i23 == 0) {
                    iArr5[i10] = Math.min((i10 + i) + 1, i16);
                }
                i14 = iArr[iArr5[i10] + i24];
                iArr9[0] = (16711680 & i14) >> 16;
                iArr9[1] = (65280 & i14) >> 8;
                iArr9[2] = i14 & 255;
                i9 += iArr9[0];
                i11 += iArr9[1];
                i4 = iArr9[2] + i12;
                i26 = i21 + i9;
                i7 = i2 + i11;
                i8 = i3 + i4;
                i27 = (i27 + 1) % i19;
                int[] iArr10 = iArr7[i27 % i19];
                i15 = i13 + iArr10[2];
                i25++;
                i10++;
                i9 -= iArr10[0];
                i11 -= iArr10[1];
                i12 = i4 - iArr10[2];
                i13 = i5 + iArr10[0];
                i14 = i6 + iArr10[1];
            }
            i23++;
            i24 += width;
        }
        for (i14 = 0; i14 < width; i14++) {
            i21 = (-i) * width;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i10 = 0;
            i9 = 0;
            i11 = 0;
            i7 = 0;
            for (i13 = -i; i13 <= i; i13++) {
                i12 = Math.max(0, i21) + i14;
                int[] iArr11 = iArr7[i13 + i];
                iArr11[0] = iArr2[i12];
                iArr11[1] = iArr3[i12];
                iArr11[2] = iArr4[i12];
                i8 = i22 - Math.abs(i13);
                i7 += iArr2[i12] * i8;
                i9 += iArr3[i12] * i8;
                i11 += iArr4[i12] * i8;
                if (i13 > 0) {
                    i2 += iArr11[0];
                    i3 += iArr11[1];
                    i4 += iArr11[2];
                } else {
                    i5 += iArr11[0];
                    i6 += iArr11[1];
                    i10 += iArr11[2];
                }
                if (i13 < i17) {
                    i21 += width;
                }
            }
            i12 = 0;
            i21 = i2;
            i13 = i14;
            i15 = i;
            while (i12 < height) {
                iArr[i13] = (((WebView.NIGHT_MODE_COLOR & iArr[i13]) | (iArr6[i7] << 16)) | (iArr6[i9] << 8)) | iArr6[i11];
                i2 = i7 - i5;
                i9 -= i6;
                i11 -= i10;
                int[] iArr12 = iArr7[((i15 - i) + i19) % i19];
                i5 -= iArr12[0];
                i6 -= iArr12[1];
                i10 -= iArr12[2];
                if (i14 == 0) {
                    iArr5[i12] = Math.min(i12 + i22, i17) * width;
                }
                i8 = iArr5[i12] + i14;
                iArr12[0] = iArr2[i8];
                iArr12[1] = iArr3[i8];
                iArr12[2] = iArr4[i8];
                i21 += iArr12[0];
                i3 += iArr12[1];
                i4 += iArr12[2];
                i7 = i2 + i21;
                i9 += i3;
                i11 += i4;
                i15 = (i15 + 1) % i19;
                int[] iArr13 = iArr7[i15];
                i5 += iArr13[0];
                i6 += iArr13[1];
                i10 += iArr13[2];
                i21 -= iArr13[0];
                i4 -= iArr13[2];
                i13 += width;
                i12++;
                i3 -= iArr13[1];
            }
        }
        ab.e("pix", width + " " + height + " " + i18);
        copy.setPixels(iArr, 0, width, 0, 0, width, height);
        am(copy);
        copy = c.ag(copy);
        AppMethodBeat.o(93380);
        return copy;
    }

    public static Bitmap c(Bitmap bitmap, float f) {
        AppMethodBeat.i(93381);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAlpha((int) (255.0f * f));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        am(createBitmap);
        createBitmap = c.ag(createBitmap);
        AppMethodBeat.o(93381);
        return createBitmap;
    }

    public static Bitmap ak(Bitmap bitmap) {
        AppMethodBeat.i(93382);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        am(createBitmap);
        createBitmap = c.ag(createBitmap);
        AppMethodBeat.o(93382);
        return createBitmap;
    }

    public static Bitmap al(Bitmap bitmap) {
        AppMethodBeat.i(93383);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        am(createBitmap);
        createBitmap = c.ag(createBitmap);
        AppMethodBeat.o(93383);
        return createBitmap;
    }

    public static String bR(byte[] bArr) {
        AppMethodBeat.i(93384);
        for (int i = 0; i < bArr.length - 1; i++) {
            if ((bArr[i] & 255) == 255) {
                byte b = bArr[i + 1];
                if ((b & 255) >= az.CTRL_INDEX && (b & 255) <= 207) {
                    ab.d("MicroMsg.BitmapUtil", "match 0xff-" + Integer.toHexString(b & 255) + "  at:" + i);
                    if ((i + 1) + 17 >= bArr.length) {
                        ab.d("MicroMsg.BitmapUtil", "not engouht len at ".concat(String.valueOf(i)));
                        break;
                    }
                    int i2 = i + 2;
                    if (bArr[i2 + 7] != (byte) 3) {
                        ab.d("MicroMsg.BitmapUtil", "num != 3 at ".concat(String.valueOf(i)));
                    } else {
                        byte b2 = bArr[i2 + 8];
                        byte b3 = bArr[i2 + 11];
                        byte b4 = bArr[i2 + 14];
                        if (b2 == (byte) 1 || b3 == (byte) 2 || b4 == (byte) 3) {
                            b2 = bArr[i2 + 9];
                            b3 = bArr[i2 + 12];
                            b = bArr[i2 + 15];
                            if (!(b2 == (byte) 0 || b3 == (byte) 0 || b == (byte) 0)) {
                                String str;
                                if (b2 == b3 && b2 == b) {
                                    str = "YUV444";
                                    AppMethodBeat.o(93384);
                                    return str;
                                }
                                int i3 = ((b2 & 255) >> 4) & 15;
                                int i4 = b2 & 15;
                                int i5 = ((b3 & 255) >> 4) & 15;
                                int i6 = b3 & 15;
                                int i7 = ((b & 255) >> 4) & 15;
                                i2 = b & 15;
                                if (!(i5 == 0 || i7 == 0 || i6 == 0 || i2 == 0 || i3 / i5 != 2 || i3 / i7 != 2)) {
                                    if (i4 / i6 == 2 && i4 / i2 == 2) {
                                        str = "YUV420";
                                        AppMethodBeat.o(93384);
                                        return str;
                                    } else if (i4 == i6 && i4 == i2) {
                                        str = "YUV422";
                                        AppMethodBeat.o(93384);
                                        return str;
                                    }
                                }
                            }
                        }
                        ab.d("MicroMsg.BitmapUtil", "Y/Cb/Cr Tag is not right at ".concat(String.valueOf(i)));
                    }
                }
            }
        }
        AppMethodBeat.o(93384);
        return null;
    }

    public static boolean a(Bitmap bitmap, CompressFormat compressFormat, int i, OutputStream outputStream) {
        AppMethodBeat.i(93385);
        if (bitmap == null) {
            ab.e("MicroMsg.BitmapUtil", "bitmap error %s", bitmap);
            AppMethodBeat.o(93385);
            return false;
        }
        boolean compress = bitmap.compress(compressFormat, i, outputStream);
        if (!compress) {
            ab.e("MicroMsg.BitmapUtil", "compress error %s", bo.dpG().toString());
        }
        AppMethodBeat.o(93385);
        return compress;
    }

    private static void am(Bitmap bitmap) {
        AppMethodBeat.i(93386);
        if (bitmap != null) {
            bitmap.setDensity(ah.getContext().getResources().getDisplayMetrics().densityDpi);
            try {
                Method declaredMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[]{Integer.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[]{Integer.valueOf(ah.getContext().getResources().getDisplayMetrics().densityDpi)});
                AppMethodBeat.o(93386);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.BitmapUtil", "Exception:%s", e);
            }
        }
        AppMethodBeat.o(93386);
    }

    public static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, String str3) {
        AppMethodBeat.i(93320);
        boolean b = b(str, i, i2, compressFormat, i3, str2 + str3);
        AppMethodBeat.o(93320);
        return b;
    }

    public static Bitmap u(Uri uri) {
        AppMethodBeat.i(93340);
        Bitmap a = a(0, null, null, uri, false, 0.0f, 0, 0);
        AppMethodBeat.o(93340);
        return a;
    }

    public static boolean a(String str, int i, CompressFormat compressFormat, int i2, String str2) {
        AppMethodBeat.i(93359);
        Bitmap a = a(str, 0, 0, 0.0f);
        if (a == null) {
            ab.e("MicroMsg.BitmapUtil", "rotate: create bitmap fialed");
            AppMethodBeat.o(93359);
            return false;
        }
        float width = (float) a.getWidth();
        float height = (float) a.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, width / 2.0f, height / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(a, 0, 0, (int) width, (int) height, matrix, true);
        if (a != createBitmap) {
            ab.i("MicroMsg.BitmapUtil", "rotate bitmap recycle adjfjads fadsj fsadjf dsa. %s", a.toString());
            a.recycle();
        }
        try {
            a(createBitmap, i2, compressFormat, str2, true);
            AppMethodBeat.o(93359);
            return true;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "create thumbnail from orig failed: ".concat(String.valueOf(str2)), new Object[0]);
            AppMethodBeat.o(93359);
            return false;
        }
    }

    public static Bitmap a(int[] iArr, int i, int i2, Config config) {
        AppMethodBeat.i(93379);
        Bitmap createBitmap = createBitmap(i, i2, config, false);
        if (createBitmap != null) {
            if (i == createBitmap.getWidth() && i2 == createBitmap.getHeight()) {
                createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            } else {
                AppMethodBeat.o(93379);
                return null;
            }
        }
        am(createBitmap);
        createBitmap = c.ag(createBitmap);
        AppMethodBeat.o(93379);
        return createBitmap;
    }
}
