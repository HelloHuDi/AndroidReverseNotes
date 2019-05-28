package com.tencent.p177mm.sdk.platformtools;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.p178a.C1170b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.sdk.platformtools.d */
public final class C5056d {
    private static DisplayMetrics ghw = null;

    /* renamed from: H */
    private static Options m7609H(InputStream inputStream) {
        AppMethodBeat.m2504i(93317);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        if (inputStream == null) {
            C4990ab.m7412e("MicroMsg.BitmapUtil", "getImageOptions decode stream is null!!");
            AppMethodBeat.m2505o(93317);
        } else {
            try {
                Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
                if (decodeStream != null) {
                    C4990ab.m7417i("MicroMsg.BitmapUtil", "getImageOptions bitmap recycle. %s", decodeStream);
                    decodeStream.recycle();
                }
            } catch (OutOfMemoryError e) {
                C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "Decode bitmap failed.", new Object[0]);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", e2, "hy: stream close failed ", new Object[0]);
                }
                AppMethodBeat.m2505o(93317);
            }
        }
        return options;
    }

    public static Options amj(String str) {
        AppMethodBeat.m2504i(93318);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.BitmapUtil", "getImageOptions invalid path");
            AppMethodBeat.m2505o(93318);
            return null;
        }
        Options H;
        try {
            H = C5056d.m7609H(C5730e.openRead(str));
            AppMethodBeat.m2505o(93318);
            return H;
        } catch (FileNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "Decode bitmap failed.", new Object[0]);
            H = new Options();
            AppMethodBeat.m2505o(93318);
            return H;
        }
    }

    /* renamed from: au */
    public static Bitmap m7644au(int i, int i2, int i3) {
        AppMethodBeat.m2504i(93319);
        try {
            Bitmap createBitmap = C5056d.createBitmap(i2, i3, Config.ARGB_8888, false);
            new Canvas(createBitmap).drawColor(i);
            createBitmap = C5053c.m7602ag(createBitmap);
            AppMethodBeat.m2505o(93319);
            return createBitmap;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(93319);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m7628a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        AppMethodBeat.m2504i(93321);
        boolean b = C5056d.m7650b(str, i, i2, compressFormat, i3, str2);
        AppMethodBeat.m2505o(93321);
        return b;
    }

    /* renamed from: av */
    public static int m7645av(int i, int i2, int i3) {
        AppMethodBeat.m2504i(93322);
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
        AppMethodBeat.m2505o(93322);
        return i4;
    }

    public static Point amk(String str) {
        AppMethodBeat.m2504i(93323);
        Options amj = C5056d.amj(str);
        if (amj != null) {
            Point point = new Point(amj.outWidth, amj.outHeight);
            AppMethodBeat.m2505o(93323);
            return point;
        }
        AppMethodBeat.m2505o(93323);
        return null;
    }

    /* renamed from: b */
    private static boolean m7650b(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        AppMethodBeat.m2504i(93324);
        boolean a = C5056d.m7630a(str, i, i2, compressFormat, i3, str2, false, new PInt(), new PInt());
        AppMethodBeat.m2505o(93324);
        return a;
    }

    /* renamed from: c */
    public static boolean m7656c(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        AppMethodBeat.m2504i(93325);
        boolean a = C5056d.m7630a(str, i, i2, compressFormat, i3, str2, true, new PInt(), new PInt());
        AppMethodBeat.m2505o(93325);
        return a;
    }

    /* renamed from: a */
    private static boolean m7630a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, boolean z, PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(93326);
        boolean a = C5056d.m7631a(str, i, i2, compressFormat, i3, str2, z, pInt, pInt2, false);
        AppMethodBeat.m2505o(93326);
        return a;
    }

    /* renamed from: a */
    public static boolean m7632a(String str, int i, int i2, CompressFormat compressFormat, String str2, PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(93327);
        boolean a = C5056d.m7631a(str, i, i2, compressFormat, 80, str2, true, pInt, pInt2, true);
        AppMethodBeat.m2505o(93327);
        return a;
    }

    /* renamed from: a */
    private static boolean m7631a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, boolean z, PInt pInt, PInt pInt2, boolean z2) {
        AppMethodBeat.m2504i(93328);
        Bitmap d = C5056d.m7659d(str, i, i2, z2);
        if (d == null) {
            AppMethodBeat.m2505o(93328);
            return false;
        }
        if (z) {
            d = C5056d.m7648b(d, (float) Exif.fromFile(str).getOrientationInDegree());
        }
        try {
            pInt.value = d.getWidth();
            pInt2.value = d.getHeight();
            C5056d.m7625a(d, i3, compressFormat, str2, true);
            AppMethodBeat.m2505o(93328);
            return true;
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
            AppMethodBeat.m2505o(93328);
            return false;
        }
    }

    /* renamed from: a */
    public static int m7611a(boolean z, String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, C1170b c1170b) {
        AppMethodBeat.m2504i(93329);
        Bitmap d = C5056d.m7659d(str, i, i2, false);
        if (d == null) {
            AppMethodBeat.m2505o(93329);
            return -1;
        }
        d = C5056d.m7648b(d, (float) Exif.fromFile(str).getOrientationInDegree());
        if (c1170b != null) {
            c1170b.getFile();
        }
        if (z) {
            try {
                C4990ab.m7417i("MicroMsg.BitmapUtil", "dkimgopt compressByQualityOptim ret:%d  [%d,%d,%d] path:%s", Integer.valueOf(C5062q.m7676b(d, i3, str2)), Integer.valueOf(i3), Integer.valueOf(d.getWidth()), Integer.valueOf(d.getHeight()), str2);
                AppMethodBeat.m2505o(93329);
                return r0;
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
                AppMethodBeat.m2505o(93329);
                return -2;
            }
        }
        C5056d.m7625a(d, i3, compressFormat, str2, true);
        AppMethodBeat.m2505o(93329);
        return 1;
    }

    /* renamed from: ao */
    public static Bitmap m7641ao(String str, int i, int i2) {
        AppMethodBeat.m2504i(93330);
        Bitmap d = C5056d.m7659d(str, i, i2, false);
        if (d == null) {
            AppMethodBeat.m2505o(93330);
            return null;
        }
        C4990ab.m7411d("MicroMsg.BitmapUtil", "degress:%d", Integer.valueOf(Exif.fromFile(str).getOrientationInDegree()));
        d = C5056d.m7648b(d, (float) r1);
        AppMethodBeat.m2505o(93330);
        return d;
    }

    /* renamed from: b */
    public static boolean m7651b(String str, int i, int i2, CompressFormat compressFormat, String str2, PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(93331);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.BitmapUtil", "file path is null.");
            AppMethodBeat.m2505o(93331);
            return false;
        } else if (C5730e.m8628ct(str)) {
            Bitmap b;
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            C4990ab.m7411d("MicroMsg.BitmapUtil", "degress:%d", Integer.valueOf(orientationInDegree));
            if (orientationInDegree == 90 || orientationInDegree == 270) {
                b = C5056d.m7648b(C5056d.m7659d(str, i2, i, true), (float) orientationInDegree);
            } else {
                b = C5056d.m7648b(C5056d.m7659d(str, i, i2, true), (float) orientationInDegree);
            }
            if (b == null) {
                AppMethodBeat.m2505o(93331);
                return false;
            }
            try {
                pInt.value = b.getWidth();
                pInt2.value = b.getHeight();
                C5056d.m7625a(b, 80, compressFormat, str2, true);
                AppMethodBeat.m2505o(93331);
                return true;
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
                AppMethodBeat.m2505o(93331);
                return false;
            }
        } else {
            C4990ab.m7420w("MicroMsg.BitmapUtil", "file did not exists.");
            AppMethodBeat.m2505o(93331);
            return false;
        }
    }

    /* renamed from: ah */
    public static Bitmap m7635ah(Bitmap bitmap) {
        int width;
        float f = 2.5f;
        AppMethodBeat.m2504i(93332);
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
        C4990ab.m7410d("MicroMsg.BitmapUtil", "bitmap decoded size=" + bitmap.getWidth() + VideoMaterialUtil.CRAZYFACE_X + bitmap.getHeight());
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, i, true);
        if (!(createScaledBitmap == null || bitmap == createScaledBitmap)) {
            C4990ab.m7417i("MicroMsg.BitmapUtil", "extractThumeNail bitmap recycle. %s", bitmap);
            bitmap.recycle();
            bitmap = createScaledBitmap;
        }
        AppMethodBeat.m2505o(93332);
        return bitmap;
    }

    public static Bitmap aml(String str) {
        AppMethodBeat.m2504i(93333);
        Bitmap a = C5056d.m7622a(str, 0, 0, 0.0f);
        AppMethodBeat.m2505o(93333);
        return a;
    }

    /* renamed from: LV */
    public static Bitmap m7610LV(int i) {
        AppMethodBeat.m2504i(93334);
        Bitmap a = C5056d.m7612a(i, null, null, null, false, 0.0f, 0, 0);
        AppMethodBeat.m2505o(93334);
        return a;
    }

    /* renamed from: o */
    public static Bitmap m7665o(int i, float f) {
        AppMethodBeat.m2504i(93335);
        Bitmap a = C5056d.m7612a(i, null, null, null, false, f, 0, 0);
        AppMethodBeat.m2505o(93335);
        return a;
    }

    /* renamed from: aw */
    public static Bitmap m7646aw(int i, int i2, int i3) {
        AppMethodBeat.m2504i(93336);
        Bitmap a = C5056d.m7612a(i, null, null, null, false, 0.0f, i2, i3);
        AppMethodBeat.m2505o(93336);
        return a;
    }

    /* renamed from: j */
    public static Bitmap m7664j(String str, float f) {
        AppMethodBeat.m2504i(93337);
        Bitmap a = C5056d.m7622a(str, 0, 0, f);
        AppMethodBeat.m2505o(93337);
        return a;
    }

    /* renamed from: ap */
    public static Bitmap m7642ap(String str, int i, int i2) {
        AppMethodBeat.m2504i(93338);
        Bitmap a = C5056d.m7622a(str, i, i2, 0.0f);
        AppMethodBeat.m2505o(93338);
        return a;
    }

    /* renamed from: a */
    public static Bitmap m7622a(String str, int i, int i2, float f) {
        AppMethodBeat.m2504i(93339);
        Bitmap a = C5056d.m7612a(0, str, null, null, false, f, i, i2);
        AppMethodBeat.m2505o(93339);
        return a;
    }

    private static Bitmap createBitmap(int i, int i2, Config config, boolean z) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(93341);
        try {
            bitmap = Bitmap.createBitmap(i, i2, config);
        } catch (Throwable th) {
        }
        C5056d.m7640am(bitmap);
        bitmap = C5053c.m7602ag(bitmap);
        AppMethodBeat.m2505o(93341);
        return bitmap;
    }

    public static Bitmap createBitmap(int i, int i2, Config config) {
        AppMethodBeat.m2504i(139049);
        Bitmap createBitmap = C5056d.createBitmap(i, i2, config, false);
        AppMethodBeat.m2505o(139049);
        return createBitmap;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(93343);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7420w("MicroMsg.BitmapUtil", "error input: data is null");
            AppMethodBeat.m2505o(93343);
            return null;
        } else if (i < 0 || i2 < 0) {
            C4990ab.m7421w("MicroMsg.BitmapUtil", "error input: targetWidth %d, targetHeight %d", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(93343);
            return null;
        } else {
            Bitmap a = C5056d.m7612a(0, null, bArr, null, false, 0.0f, i, i2);
            AppMethodBeat.m2505o(93343);
            return a;
        }
    }

    /* renamed from: bQ */
    public static Bitmap m7652bQ(byte[] bArr) {
        AppMethodBeat.m2504i(93344);
        Bitmap decodeByteArray = C5056d.decodeByteArray(bArr, 0, 0);
        AppMethodBeat.m2505o(93344);
        return decodeByteArray;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045 A:{SYNTHETIC, Splitter:B:24:0x0045} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap decodeFile(String str, Options options) {
        IOException e;
        Throwable th;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(93345);
        if (options == null) {
            options = new Options();
        }
        InputStream openRead;
        try {
            openRead = C5730e.openRead(str);
            try {
                bitmap = MMBitmapFactory.decodeStream(openRead, null, options);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.m2505o(93345);
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e = e4;
            openRead = bitmap;
            try {
                C4990ab.m7413e("MicroMsg.BitmapUtil", "Cannot decode file '%s': %s", str, e.getMessage());
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.m2505o(93345);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.m2505o(93345);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            openRead = bitmap;
            if (openRead != null) {
            }
            AppMethodBeat.m2505o(93345);
            throw th;
        }
        return bitmap;
    }

    /* renamed from: a */
    public static Bitmap m7620a(InputStream inputStream, float f, int i, int i2) {
        Bitmap decodeStream;
        AppMethodBeat.m2504i(93346);
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
                inputStream = new C5061l((FileInputStream) inputStream);
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
                C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "Failed seeking InputStream.", new Object[0]);
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
                C4990ab.m7412e("MicroMsg.BitmapUtil", "decodeStream OutOfMemoryError return null");
                decodeStream = null;
            }
        }
        AppMethodBeat.m2505o(93346);
        return decodeStream;
    }

    /* renamed from: a */
    public static Bitmap m7619a(InputStream inputStream, float f) {
        AppMethodBeat.m2504i(93347);
        Bitmap a = C5056d.m7620a(inputStream, f, 0, 0);
        AppMethodBeat.m2505o(93347);
        return a;
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        AppMethodBeat.m2504i(93348);
        Bitmap a = C5056d.m7620a(inputStream, 0.0f, 0, 0);
        AppMethodBeat.m2505o(93348);
        return a;
    }

    public static DisplayMetrics anS() {
        AppMethodBeat.m2504i(93349);
        if (ghw == null) {
            ghw = C4996ah.getContext().getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = ghw;
        AppMethodBeat.m2505o(93349);
        return displayMetrics;
    }

    /* renamed from: a */
    private static Bitmap m7612a(int i, String str, byte[] bArr, Uri uri, boolean z, float f, int i2, int i3) {
        AppMethodBeat.m2504i(93350);
        Bitmap b = C5056d.m7647b(i, str, bArr, uri, z, f, i2, i3);
        AppMethodBeat.m2505o(93350);
        return b;
    }

    /* renamed from: b */
    private static Bitmap m7647b(int i, String str, byte[] bArr, Uri uri, boolean z, float f, int i2, int i3) {
        Object obj;
        AppMethodBeat.m2504i(93351);
        if (i2 == 0 && i3 == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (i2 < 0 || i3 < 0) {
            AppMethodBeat.m2505o(93351);
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
                C5056d.m7618a(options, bArr, str, uri, z, i);
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
            a = C5056d.m7618a(options, bArr, str, uri, z, i);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", th, "", new Object[0]);
            a = null;
        }
        C5056d.m7640am(a);
        a = C5053c.m7602ag(a);
        AppMethodBeat.m2505o(93351);
        return a;
    }

    /* renamed from: a */
    private static Bitmap m7618a(Options options, byte[] bArr, String str, Uri uri, boolean z, int i) {
        Object obj = null;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(93352);
        try {
            InputStream open;
            Throwable th;
            if (C5046bo.m7540cb(bArr) && C5046bo.isNullOrNil(str) && uri == null && i <= 0) {
                return bitmap;
            }
            if (!C5046bo.m7540cb(bArr)) {
                obj = 1;
            }
            if (obj != null) {
                bitmap = MMBitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            } else if (i > 0) {
                bitmap = C1434a.decodeResource(C4996ah.getContext().getResources(), i, options);
            } else {
                if (z) {
                    try {
                        if (C5046bo.isNullOrNil(str)) {
                            C5056d.m7640am(bitmap);
                            AppMethodBeat.m2505o(93352);
                            return bitmap;
                        }
                        open = C4996ah.getContext().getAssets().open(str);
                    } catch (Throwable th2) {
                        th = th2;
                        open = bitmap;
                    }
                } else if (uri != null) {
                    open = C4996ah.getContext().getContentResolver().openInputStream(uri);
                } else {
                    open = C5730e.openRead(str);
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
            C5056d.m7640am(bitmap);
            bitmap = C5053c.m7602ag(bitmap);
            AppMethodBeat.m2505o(93352);
            return bitmap;
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.m2505o(93352);
            throw th;
            AppMethodBeat.m2505o(93352);
            throw th;
        } finally {
            C5056d.m7640am(bitmap);
            AppMethodBeat.m2505o(93352);
        }
    }

    public static void dnX() {
    }

    @TargetApi(11)
    /* renamed from: a */
    private static Bitmap m7621a(InputStream inputStream, int i, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.m2504i(138277);
        if (i3 <= 0 || i4 <= 0) {
            C4990ab.m7412e("MicroMsg.BitmapUtil", "extractThumbNail height:" + i4 + " width:" + i3);
            AppMethodBeat.m2505o(138277);
            return null;
        } else if (i <= 0 || i2 <= 0) {
            C4990ab.m7413e("MicroMsg.BitmapUtil", "decode[%s] error, outHeight[%d] outWidth[%d]", inputStream, Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(138277);
            return null;
        } else {
            try {
                int ceil;
                int i5;
                Options options = new Options();
                C4990ab.m7416i("MicroMsg.BitmapUtil", "extractThumbNail: round=" + i3 + VideoMaterialUtil.CRAZYFACE_X + i4 + ", crop=" + z);
                double d = (((double) i2) * 1.0d) / ((double) i4);
                double d2 = (((double) i) * 1.0d) / ((double) i3);
                C4990ab.m7410d("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d2 + ", beY = " + d);
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
                C4990ab.m7416i("MicroMsg.BitmapUtil", "bitmap required size=" + ceil + VideoMaterialUtil.CRAZYFACE_X + i6 + ", orig=" + i + VideoMaterialUtil.CRAZYFACE_X + i2 + ", sample=" + options.inSampleSize);
                Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options);
                if (decodeStream == null) {
                    C4990ab.m7412e("MicroMsg.BitmapUtil", "bitmap decode failed");
                    AppMethodBeat.m2505o(138277);
                    return null;
                }
                C4990ab.m7410d("MicroMsg.BitmapUtil", "bitmap decoded size=" + decodeStream.getWidth() + VideoMaterialUtil.CRAZYFACE_X + decodeStream.getHeight());
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, ceil, i6, true);
                if (decodeStream == createScaledBitmap || createScaledBitmap == null) {
                    createScaledBitmap = decodeStream;
                } else {
                    C4990ab.m7417i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfad. %s", decodeStream);
                    decodeStream.recycle();
                }
                if (z) {
                    if (createScaledBitmap.getWidth() < i3) {
                        C4990ab.m7413e("MicroMsg.BitmapUtil", "bmw < width %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(i3));
                        i3 = createScaledBitmap.getWidth();
                    }
                    if (createScaledBitmap.getHeight() < i4) {
                        C4990ab.m7413e("MicroMsg.BitmapUtil", "bmh < height %d %d", Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i4));
                        i4 = createScaledBitmap.getHeight();
                    }
                    i6 = (createScaledBitmap.getWidth() - i3) >> 1;
                    i5 = (createScaledBitmap.getHeight() - i4) >> 1;
                    if (i6 < 0 || i5 < 0) {
                        C4990ab.m7413e("MicroMsg.BitmapUtil", "fix crop image error %d %d %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i3), Integer.valueOf(i4));
                        if (i6 < 0) {
                            i6 = 0;
                        }
                        if (i5 < 0) {
                            i5 = 0;
                        }
                    }
                    decodeStream = Bitmap.createBitmap(createScaledBitmap, i6, i5, i3, i4);
                    if (decodeStream == null) {
                        AppMethodBeat.m2505o(138277);
                        return createScaledBitmap;
                    }
                    if (decodeStream != createScaledBitmap) {
                        C4990ab.m7417i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfaasdfad. %s", createScaledBitmap);
                        createScaledBitmap.recycle();
                        createScaledBitmap = decodeStream;
                    }
                    C4990ab.m7410d("MicroMsg.BitmapUtil", "bitmap croped size=" + createScaledBitmap.getWidth() + VideoMaterialUtil.CRAZYFACE_X + createScaledBitmap.getHeight());
                }
                C5056d.m7640am(createScaledBitmap);
                decodeStream = C5053c.m7602ag(createScaledBitmap);
                AppMethodBeat.m2505o(138277);
                return decodeStream;
            } catch (OutOfMemoryError e) {
                C4990ab.m7412e("MicroMsg.BitmapUtil", "decode bitmap failed: " + e.getMessage());
                AppMethodBeat.m2505o(138277);
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A:{SYNTHETIC, Splitter:B:22:0x0056} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A:{SYNTHETIC, Splitter:B:22:0x0056} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public static Bitmap m7659d(String str, int i, int i2, boolean z) {
        Throwable e;
        InputStream inputStream;
        AppMethodBeat.m2504i(93354);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.BitmapUtil", "extractThumbNail path null or nil");
            AppMethodBeat.m2505o(93354);
            return null;
        }
        try {
            Options amj = C5056d.amj(str);
            InputStream openRead = C5730e.openRead(str);
            try {
                Bitmap a = C5056d.m7621a(openRead, amj.outWidth, amj.outHeight, i2, i, z);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.m2505o(93354);
                return a;
            } catch (FileNotFoundException e3) {
                e = e3;
                inputStream = openRead;
            } catch (Throwable th) {
                e = th;
                inputStream = openRead;
                if (inputStream != null) {
                }
                AppMethodBeat.m2505o(93354);
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
            AppMethodBeat.m2505o(93354);
            throw e;
        }
        try {
            C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "Failed decode bitmap.", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.m2505o(93354);
            return null;
        } catch (Throwable e422) {
            e = e422;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(93354);
            throw e;
        }
        AppMethodBeat.m2505o(93354);
        return null;
    }

    /* renamed from: a */
    public static Bitmap m7615a(Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
        Throwable th;
        AppMethodBeat.m2504i(93355);
        if (bitmap == null) {
            C4990ab.m7412e("MicroMsg.BitmapUtil", "extractThumbNail bitmap is null.");
            AppMethodBeat.m2505o(93355);
            return null;
        } else if (i <= 0 || i2 <= 0) {
            try {
                C4990ab.m7412e("MicroMsg.BitmapUtil", "extractThumbNail height:" + i + " width:" + i2);
                C5056d.m7640am(bitmap);
                AppMethodBeat.m2505o(93355);
                return null;
            } catch (Throwable th2) {
                th = th2;
                C5056d.m7640am(bitmap);
                AppMethodBeat.m2505o(93355);
                throw th;
            }
        } else {
            int ceil;
            int i3;
            Bitmap createBitmap;
            Options options = new Options();
            options.outHeight = bitmap.getHeight();
            options.outWidth = bitmap.getWidth();
            C4990ab.m7416i("MicroMsg.BitmapUtil", "extractThumbNail: round=" + i2 + VideoMaterialUtil.CRAZYFACE_X + i + ", crop=" + z + ", recycle=" + z2);
            double d = (((double) options.outHeight) * 1.0d) / ((double) i);
            double d2 = (((double) options.outWidth) * 1.0d) / ((double) i2);
            C4990ab.m7410d("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d2 + ", beY = " + d);
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
            C4990ab.m7416i("MicroMsg.BitmapUtil", "bitmap required size=" + i3 + VideoMaterialUtil.CRAZYFACE_X + ceil + ", orig=" + options.outWidth + VideoMaterialUtil.CRAZYFACE_X + options.outHeight + ", sample=" + options.inSampleSize);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, ceil, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = bitmap;
            } else if (z2 && bitmap != createScaledBitmap) {
                C4990ab.m7417i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle asdfjasjdfja asdfasd. %s", bitmap);
                bitmap.recycle();
            }
            if (z) {
                try {
                    if (createScaledBitmap.getWidth() < i2) {
                        C4990ab.m7413e("MicroMsg.BitmapUtil", "bmw < width %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(i2));
                        i2 = createScaledBitmap.getWidth();
                    }
                    if (createScaledBitmap.getHeight() < i) {
                        C4990ab.m7413e("MicroMsg.BitmapUtil", "bmh < height %d %d", Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i));
                        i = createScaledBitmap.getHeight();
                    }
                    createBitmap = Bitmap.createBitmap(createScaledBitmap, (createScaledBitmap.getWidth() - i2) >> 1, (createScaledBitmap.getHeight() - i) >> 1, i2, i);
                    if (createBitmap == null) {
                        C5056d.m7640am(createScaledBitmap);
                        AppMethodBeat.m2505o(93355);
                        return createScaledBitmap;
                    }
                    if (z2 && createScaledBitmap != createBitmap) {
                        C4990ab.m7417i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle ajdfjajsdfjdsajjfsad. %s", createScaledBitmap);
                        createScaledBitmap.recycle();
                    }
                    try {
                        C4990ab.m7410d("MicroMsg.BitmapUtil", "bitmap croped size=" + createBitmap.getWidth() + VideoMaterialUtil.CRAZYFACE_X + createBitmap.getHeight());
                    } catch (Throwable th3) {
                        th = th3;
                        bitmap = createBitmap;
                        C5056d.m7640am(bitmap);
                        AppMethodBeat.m2505o(93355);
                        throw th;
                    }
                } catch (Throwable th22) {
                    th = th22;
                    bitmap = createScaledBitmap;
                    C5056d.m7640am(bitmap);
                    AppMethodBeat.m2505o(93355);
                    throw th;
                }
            }
            createBitmap = createScaledBitmap;
            C5056d.m7640am(createBitmap);
            AppMethodBeat.m2505o(93355);
            return createBitmap;
        }
    }

    /* renamed from: aq */
    public static Bitmap m7643aq(String str, int i, int i2) {
        AppMethodBeat.m2504i(93356);
        Bitmap a = C5056d.m7612a(0, str, null, null, true, 0.0f, i, i2);
        AppMethodBeat.m2505o(93356);
        return a;
    }

    /* renamed from: a */
    public static Bitmap m7613a(Bitmap bitmap, float f, float f2) {
        AppMethodBeat.m2504i(93357);
        if (bitmap == null) {
            AppMethodBeat.m2505o(93357);
            return null;
        } else if (((double) f) <= 0.999d || ((double) f) >= 1.001d || ((double) f2) <= 0.999d || ((double) f2) >= 1.001d) {
            Matrix matrix = new Matrix();
            matrix.reset();
            if (((double) f) < 0.999d || ((double) f) > 1.001d || ((double) f2) < 0.999d || ((double) f2) > 1.001d) {
                matrix.postScale(f, f2);
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            C5056d.m7640am(createBitmap);
            C4990ab.m7410d("MicroMsg.BitmapUtil", "resultBmp is null: " + (createBitmap == null) + "  degree:0.0");
            if (bitmap != createBitmap) {
                C4990ab.m7417i("MicroMsg.BitmapUtil", "rotateAndScale bitmap recycle asdfasdjfjasdfjsadfjdsa. %s", bitmap);
                bitmap.recycle();
            }
            bitmap = C5053c.m7602ag(createBitmap);
            AppMethodBeat.m2505o(93357);
            return bitmap;
        } else {
            AppMethodBeat.m2505o(93357);
            return bitmap;
        }
    }

    /* renamed from: b */
    public static Bitmap m7648b(Bitmap bitmap, float f) {
        Throwable th;
        AppMethodBeat.m2504i(93358);
        if (f % 360.0f == 0.0f) {
            AppMethodBeat.m2505o(93358);
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            try {
                boolean z;
                C5056d.m7640am(createBitmap);
                String str = "MicroMsg.BitmapUtil";
                StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
                if (createBitmap == null) {
                    z = true;
                } else {
                    z = false;
                }
                C4990ab.m7410d(str, stringBuilder.append(z).append("  degree:").append(f).toString());
                if (bitmap != createBitmap) {
                    C4990ab.m7417i("MicroMsg.BitmapUtil", "rotate bitmap recycle ajsdfasdf adsf. %s", bitmap);
                    bitmap.recycle();
                }
                bitmap = C5053c.m7602ag(createBitmap);
                AppMethodBeat.m2505o(93358);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                bitmap = createBitmap;
                C4990ab.m7411d("MicroMsg.BitmapUtil", "createBitmap failed : %s ", C5046bo.m7574l(th));
                AppMethodBeat.m2505o(93358);
                return bitmap;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    public static boolean m7634a(String str, int i, CompressFormat compressFormat, String str2, String str3) {
        AppMethodBeat.m2504i(93360);
        boolean a = C5056d.m7633a(str, i, compressFormat, 90, str2 + str3);
        AppMethodBeat.m2505o(93360);
        return a;
    }

    /* renamed from: a */
    public static void m7624a(Bitmap bitmap, int i, CompressFormat compressFormat, OutputStream outputStream, boolean z) {
        AppMethodBeat.m2504i(93361);
        C5056d.m7627a(bitmap, compressFormat, i, outputStream);
        if (z) {
            C4990ab.m7417i("MicroMsg.BitmapUtil", "saveBitmapToStream bitmap recycle. %s", bitmap);
            bitmap.recycle();
        }
        AppMethodBeat.m2505o(93361);
    }

    /* renamed from: a */
    public static void m7625a(Bitmap bitmap, int i, CompressFormat compressFormat, String str, boolean z) {
        AppMethodBeat.m2504i(93362);
        if (C5046bo.isNullOrNil(str)) {
            IOException iOException = new IOException("saveBitmapToImage pathName null or nil");
            AppMethodBeat.m2505o(93362);
            throw iOException;
        }
        C4990ab.m7410d("MicroMsg.BitmapUtil", "saving to ".concat(String.valueOf(str)));
        OutputStream outputStream = null;
        C5730e.m8643tf(C5730e.atb(str));
        try {
            outputStream = C5730e.m8617L(str, false);
            C5056d.m7624a(bitmap, i, compressFormat, outputStream, z);
            if (z) {
                C4990ab.m7417i("MicroMsg.BitmapUtil", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                    AppMethodBeat.m2505o(93362);
                    return;
                } catch (IOException e) {
                    AppMethodBeat.m2505o(93362);
                    return;
                }
            }
            AppMethodBeat.m2505o(93362);
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", e2, "saveBitmapToImage failed: %s", str);
            IOException iOException2 = new IOException(e2);
            AppMethodBeat.m2505o(93362);
            throw iOException2;
        } catch (Throwable th) {
            if (z) {
                C4990ab.m7417i("MicroMsg.BitmapUtil", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.m2505o(93362);
        }
    }

    /* renamed from: b */
    public static Bitmap m7649b(Bitmap bitmap, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(93363);
        if (bitmap == null) {
            AppMethodBeat.m2505o(93363);
            return null;
        }
        Bitmap createBitmap;
        C5056d.m7640am(bitmap);
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
            C4990ab.m7420w("MicroMsg.BitmapUtil", "get center crop bitmap, config is null");
            config = Config.ARGB_8888;
        }
        try {
            createBitmap = Bitmap.createBitmap(i, i2, config);
        } catch (Throwable th) {
            C4990ab.m7412e("MicroMsg.BitmapUtil", "BitmapUtil decode getCenterCropBitmap fail");
            AppMethodBeat.m2505o(93363);
            return bitmap;
        }
        new Canvas(createBitmap).drawBitmap(bitmap, null, rectF, null);
        if (z) {
            C4990ab.m7417i("MicroMsg.BitmapUtil", "getCenterCropBitmap bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        C5056d.m7640am(createBitmap);
        bitmap = C5053c.m7602ag(createBitmap);
        AppMethodBeat.m2505o(93363);
        return bitmap;
    }

    /* renamed from: a */
    public static Bitmap m7617a(Bitmap bitmap, boolean z, float f, boolean z2) {
        AppMethodBeat.m2504i(93364);
        if (bitmap == null || bitmap.isRecycled()) {
            C4990ab.m7412e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap in bitmap is null");
            AppMethodBeat.m2505o(93364);
            return null;
        }
        C5056d.m7640am(bitmap);
        Bitmap createBitmap = C5056d.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888, z2);
        if (createBitmap == null) {
            AppMethodBeat.m2505o(93364);
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
            C4990ab.m7417i("MicroMsg.BitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        C5056d.m7640am(createBitmap);
        Bitmap ag = C5053c.m7602ag(createBitmap);
        AppMethodBeat.m2505o(93364);
        return ag;
    }

    /* renamed from: a */
    public static Bitmap m7616a(Bitmap bitmap, boolean z, float f) {
        AppMethodBeat.m2504i(93365);
        Bitmap a = C5056d.m7617a(bitmap, z, f, false);
        AppMethodBeat.m2505o(93365);
        return a;
    }

    /* renamed from: v */
    public static Bitmap m7668v(Drawable drawable) {
        AppMethodBeat.m2504i(93366);
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            AppMethodBeat.m2505o(93366);
            return bitmap;
        }
        bitmap = C5056d.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888, false);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        C5056d.m7640am(bitmap);
        bitmap = C5053c.m7602ag(bitmap);
        AppMethodBeat.m2505o(93366);
        return bitmap;
    }

    /* renamed from: ai */
    public static byte[] m7636ai(Bitmap bitmap) {
        AppMethodBeat.m2504i(93367);
        byte[] c = C5056d.m7657c(bitmap, 100);
        AppMethodBeat.m2505o(93367);
        return c;
    }

    /* renamed from: c */
    public static byte[] m7657c(Bitmap bitmap, int i) {
        AppMethodBeat.m2504i(93368);
        byte[] bArr;
        if (bitmap == null || bitmap.isRecycled()) {
            bArr = new byte[0];
            AppMethodBeat.m2505o(93368);
            return bArr;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C5056d.m7627a(bitmap, CompressFormat.JPEG, i, byteArrayOutputStream);
        bArr = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(93368);
        return bArr;
    }

    /* renamed from: aj */
    public static byte[] m7637aj(Bitmap bitmap) {
        AppMethodBeat.m2504i(93369);
        byte[] bArr;
        if (bitmap == null || bitmap.isRecycled()) {
            bArr = new byte[0];
            AppMethodBeat.m2505o(93369);
            return bArr;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C5056d.m7627a(bitmap, CompressFormat.PNG, 100, byteArrayOutputStream);
        bArr = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(93369);
        return bArr;
    }

    /* renamed from: c */
    public static void m7655c(String str, PInt pInt, PInt pInt2) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(93370);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            bitmap = MMBitmapFactory.decodeStream(C5730e.openRead(str), null, options);
        } catch (FileNotFoundException e) {
        }
        if (bitmap != null) {
            C4990ab.m7417i("MicroMsg.BitmapUtil", "getRent bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        pInt.value = options.outWidth;
        pInt2.value = options.outHeight;
        AppMethodBeat.m2505o(93370);
    }

    /* renamed from: eA */
    public static Bitmap m7661eA(View view) {
        AppMethodBeat.m2504i(93371);
        if (view == null) {
            AppMethodBeat.m2505o(93371);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        }
        view.draw(canvas);
        C5056d.m7640am(createBitmap);
        createBitmap = C5053c.m7602ag(createBitmap);
        AppMethodBeat.m2505o(93371);
        return createBitmap;
    }

    /* renamed from: eB */
    public static Bitmap m7662eB(View view) {
        AppMethodBeat.m2504i(93372);
        if (view == null) {
            AppMethodBeat.m2505o(93372);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        }
        C5056d.m7626a(canvas, view);
        C5056d.m7640am(createBitmap);
        createBitmap = C5053c.m7602ag(createBitmap);
        AppMethodBeat.m2505o(93372);
        return createBitmap;
    }

    /* renamed from: a */
    public static void m7626a(Canvas canvas, View view) {
        AppMethodBeat.m2504i(93373);
        view.draw(canvas);
        List<C5067v> v = C5056d.m7669v(view, (int) view.getX(), (int) view.getY());
        if (v.size() > 0) {
            for (C5067v c5067v : v) {
                if (!(c5067v == null || c5067v.xyt == null)) {
                    TextureView textureView = c5067v.xyt;
                    Bitmap bitmap = textureView.getBitmap(textureView.getWidth(), textureView.getHeight());
                    if (bitmap == null || bitmap.isRecycled()) {
                        C4990ab.m7412e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
                    } else {
                        canvas.drawBitmap(bitmap, (float) c5067v.left, (float) c5067v.top, null);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(93373);
    }

    /* renamed from: v */
    private static List<C5067v> m7669v(View view, int i, int i2) {
        AppMethodBeat.m2504i(93374);
        ArrayList arrayList = new ArrayList();
        if (view instanceof TextureView) {
            C5067v c5067v = new C5067v();
            c5067v.xyt = (TextureView) view;
            c5067v.left = i;
            c5067v.top = i2;
            arrayList.add(c5067v);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                arrayList.addAll(C5056d.m7669v(viewGroup.getChildAt(i3), (int) (viewGroup.getX() + ((float) i)), (int) (viewGroup.getY() + ((float) i2))));
            }
        }
        AppMethodBeat.m2505o(93374);
        return arrayList;
    }

    /* renamed from: d */
    public static Bitmap m7658d(Bitmap bitmap, int i) {
        AppMethodBeat.m2504i(93375);
        C4990ab.m7410d("MicroMsg.BitmapUtil", "begin createChattingImage");
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap == null) {
            C4990ab.m7420w("MicroMsg.BitmapUtil", "sourceBitmap is null .");
            AppMethodBeat.m2505o(93375);
            return null;
        }
        C5056d.m7640am(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            C4990ab.m7420w("MicroMsg.BitmapUtil", "sourceBitmap width or height is 0.");
            AppMethodBeat.m2505o(93375);
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            Bitmap createBitmap = C5056d.createBitmap(width, height, Config.ARGB_8888, false);
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) C4996ah.getContext().getResources().getDrawable(i);
            ninePatchDrawable.setBounds(0, 0, width, height);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            C4990ab.m7410d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis2));
            if (createBitmap == null) {
                C4990ab.m7412e("MicroMsg.BitmapUtil", "[createChattingImage] maskBitmap is null.");
                AppMethodBeat.m2505o(93375);
                return null;
            }
            int width2 = createBitmap.getWidth();
            int height2 = createBitmap.getHeight();
            if (width2 <= 0 || height2 <= 0) {
                C4990ab.m7420w("MicroMsg.BitmapUtil", "maskBitmap width or height is 0.");
                AppMethodBeat.m2505o(93375);
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
                        C4990ab.m7412e("MicroMsg.BitmapUtil", e.toString());
                    }
                }
                C4990ab.m7410d("MicroMsg.BitmapUtil", "meger pixels  " + (System.currentTimeMillis() - currentTimeMillis2));
                long currentTimeMillis3 = System.currentTimeMillis();
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                C4990ab.m7410d("MicroMsg.BitmapUtil", "setPixels " + (System.currentTimeMillis() - currentTimeMillis3));
                C4990ab.m7410d("MicroMsg.BitmapUtil", "createTime" + (System.currentTimeMillis() - currentTimeMillis));
                C5056d.m7640am(createBitmap);
                Bitmap ag = C5053c.m7602ag(createBitmap);
                AppMethodBeat.m2505o(93375);
                return ag;
            } else {
                C4990ab.m7412e("MicroMsg.BitmapUtil", "maskHeiht maskWidth != height width.");
                AppMethodBeat.m2505o(93375);
                return null;
            }
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.BitmapUtil", "[createChattingImage] create nine pathc bitmap faild.");
            AppMethodBeat.m2505o(93375);
            return null;
        }
    }

    /* renamed from: gU */
    public static Bitmap m7663gU(int i, int i2) {
        AppMethodBeat.m2504i(93376);
        if (i < 0 || i2 < 0) {
            C4990ab.m7420w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
            AppMethodBeat.m2505o(93376);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap ag = C5053c.m7602ag(C5056d.createBitmap(i, i2, Config.ARGB_8888, false));
        C5056d.m7640am(ag);
        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) C4996ah.getContext().getResources().getDrawable(C25738R.drawable.ahf);
        ninePatchDrawable.setBounds(0, 0, i, i2);
        ninePatchDrawable.draw(new Canvas(ag));
        C4990ab.m7410d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        Bitmap d = C5056d.m7658d(ag, C25738R.drawable.bbi);
        AppMethodBeat.m2505o(93376);
        return d;
    }

    /* renamed from: o */
    public static Bitmap m7666o(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(93377);
        if (str == null || str.equals("") || i < 0 || i2 < 0 || i3 < 0) {
            C4990ab.m7420w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
            AppMethodBeat.m2505o(93377);
            return null;
        }
        Bitmap f = C5053c.m7603f(C5056d.decodeByteArray(C5730e.m8632e(str, 0, -1), 0, 0), str);
        if (f == null || f.isRecycled()) {
            AppMethodBeat.m2505o(93377);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap ag = C5053c.m7602ag(C5056d.createBitmap(i2, i3, Config.ARGB_8888, false));
        C5056d.m7640am(ag);
        Canvas canvas = new Canvas(ag);
        C4990ab.m7411d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", Integer.valueOf(f.getWidth()), Integer.valueOf(f.getHeight()), Integer.valueOf(i2), Integer.valueOf(i3));
        canvas.drawBitmap(f, null, new Rect(0, 0, i2, i3), new Paint());
        C4990ab.m7410d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        f = C5056d.m7658d(ag, i);
        AppMethodBeat.m2505o(93377);
        return f;
    }

    /* renamed from: a */
    public static Bitmap m7614a(Bitmap bitmap, int i, int i2, int i3) {
        AppMethodBeat.m2504i(93378);
        if (bitmap == null || i < 0 || i2 < 0 || i3 < 0) {
            AppMethodBeat.m2505o(93378);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap ag = C5053c.m7602ag(C5056d.createBitmap(i2, i3, Config.ARGB_8888, false));
        Canvas canvas = new Canvas(ag);
        C4990ab.m7411d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i2), Integer.valueOf(i3));
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, i2, i3), new Paint());
        C4990ab.m7410d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        Bitmap d = C5056d.m7658d(ag, i);
        AppMethodBeat.m2505o(93378);
        return d;
    }

    /* renamed from: e */
    public static Bitmap m7660e(Bitmap bitmap, int i) {
        AppMethodBeat.m2504i(93380);
        if (bitmap == null) {
            C4990ab.m7420w("MicroMsg.BitmapUtil", "fastblur: but sentBitmap is null");
            AppMethodBeat.m2505o(93380);
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (i <= 0) {
            AppMethodBeat.m2505o(93380);
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
        C4990ab.m7412e("pix", width + " " + height + " " + iArr.length);
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
        C4990ab.m7412e("pix", width + " " + height + " " + i18);
        copy.setPixels(iArr, 0, width, 0, 0, width, height);
        C5056d.m7640am(copy);
        copy = C5053c.m7602ag(copy);
        AppMethodBeat.m2505o(93380);
        return copy;
    }

    /* renamed from: c */
    public static Bitmap m7654c(Bitmap bitmap, float f) {
        AppMethodBeat.m2504i(93381);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAlpha((int) (255.0f * f));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        C5056d.m7640am(createBitmap);
        createBitmap = C5053c.m7602ag(createBitmap);
        AppMethodBeat.m2505o(93381);
        return createBitmap;
    }

    /* renamed from: ak */
    public static Bitmap m7638ak(Bitmap bitmap) {
        AppMethodBeat.m2504i(93382);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        C5056d.m7640am(createBitmap);
        createBitmap = C5053c.m7602ag(createBitmap);
        AppMethodBeat.m2505o(93382);
        return createBitmap;
    }

    /* renamed from: al */
    public static Bitmap m7639al(Bitmap bitmap) {
        AppMethodBeat.m2504i(93383);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        C5056d.m7640am(createBitmap);
        createBitmap = C5053c.m7602ag(createBitmap);
        AppMethodBeat.m2505o(93383);
        return createBitmap;
    }

    /* renamed from: bR */
    public static String m7653bR(byte[] bArr) {
        AppMethodBeat.m2504i(93384);
        for (int i = 0; i < bArr.length - 1; i++) {
            if ((bArr[i] & 255) == 255) {
                byte b = bArr[i + 1];
                if ((b & 255) >= C33250az.CTRL_INDEX && (b & 255) <= 207) {
                    C4990ab.m7410d("MicroMsg.BitmapUtil", "match 0xff-" + Integer.toHexString(b & 255) + "  at:" + i);
                    if ((i + 1) + 17 >= bArr.length) {
                        C4990ab.m7410d("MicroMsg.BitmapUtil", "not engouht len at ".concat(String.valueOf(i)));
                        break;
                    }
                    int i2 = i + 2;
                    if (bArr[i2 + 7] != (byte) 3) {
                        C4990ab.m7410d("MicroMsg.BitmapUtil", "num != 3 at ".concat(String.valueOf(i)));
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
                                    AppMethodBeat.m2505o(93384);
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
                                        AppMethodBeat.m2505o(93384);
                                        return str;
                                    } else if (i4 == i6 && i4 == i2) {
                                        str = "YUV422";
                                        AppMethodBeat.m2505o(93384);
                                        return str;
                                    }
                                }
                            }
                        }
                        C4990ab.m7410d("MicroMsg.BitmapUtil", "Y/Cb/Cr Tag is not right at ".concat(String.valueOf(i)));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(93384);
        return null;
    }

    /* renamed from: a */
    public static boolean m7627a(Bitmap bitmap, CompressFormat compressFormat, int i, OutputStream outputStream) {
        AppMethodBeat.m2504i(93385);
        if (bitmap == null) {
            C4990ab.m7413e("MicroMsg.BitmapUtil", "bitmap error %s", bitmap);
            AppMethodBeat.m2505o(93385);
            return false;
        }
        boolean compress = bitmap.compress(compressFormat, i, outputStream);
        if (!compress) {
            C4990ab.m7413e("MicroMsg.BitmapUtil", "compress error %s", C5046bo.dpG().toString());
        }
        AppMethodBeat.m2505o(93385);
        return compress;
    }

    /* renamed from: am */
    private static void m7640am(Bitmap bitmap) {
        AppMethodBeat.m2504i(93386);
        if (bitmap != null) {
            bitmap.setDensity(C4996ah.getContext().getResources().getDisplayMetrics().densityDpi);
            try {
                Method declaredMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[]{Integer.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[]{Integer.valueOf(C4996ah.getContext().getResources().getDisplayMetrics().densityDpi)});
                AppMethodBeat.m2505o(93386);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BitmapUtil", "Exception:%s", e);
            }
        }
        AppMethodBeat.m2505o(93386);
    }

    /* renamed from: a */
    public static boolean m7629a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, String str3) {
        AppMethodBeat.m2504i(93320);
        boolean b = C5056d.m7650b(str, i, i2, compressFormat, i3, str2 + str3);
        AppMethodBeat.m2505o(93320);
        return b;
    }

    /* renamed from: u */
    public static Bitmap m7667u(Uri uri) {
        AppMethodBeat.m2504i(93340);
        Bitmap a = C5056d.m7612a(0, null, null, uri, false, 0.0f, 0, 0);
        AppMethodBeat.m2505o(93340);
        return a;
    }

    /* renamed from: a */
    public static boolean m7633a(String str, int i, CompressFormat compressFormat, int i2, String str2) {
        AppMethodBeat.m2504i(93359);
        Bitmap a = C5056d.m7622a(str, 0, 0, 0.0f);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.BitmapUtil", "rotate: create bitmap fialed");
            AppMethodBeat.m2505o(93359);
            return false;
        }
        float width = (float) a.getWidth();
        float height = (float) a.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, width / 2.0f, height / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(a, 0, 0, (int) width, (int) height, matrix, true);
        if (a != createBitmap) {
            C4990ab.m7417i("MicroMsg.BitmapUtil", "rotate bitmap recycle adjfjads fadsj fsadjf dsa. %s", a.toString());
            a.recycle();
        }
        try {
            C5056d.m7625a(createBitmap, i2, compressFormat, str2, true);
            AppMethodBeat.m2505o(93359);
            return true;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.BitmapUtil", e, "create thumbnail from orig failed: ".concat(String.valueOf(str2)), new Object[0]);
            AppMethodBeat.m2505o(93359);
            return false;
        }
    }

    /* renamed from: a */
    public static Bitmap m7623a(int[] iArr, int i, int i2, Config config) {
        AppMethodBeat.m2504i(93379);
        Bitmap createBitmap = C5056d.createBitmap(i, i2, config, false);
        if (createBitmap != null) {
            if (i == createBitmap.getWidth() && i2 == createBitmap.getHeight()) {
                createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            } else {
                AppMethodBeat.m2505o(93379);
                return null;
            }
        }
        C5056d.m7640am(createBitmap);
        createBitmap = C5053c.m7602ag(createBitmap);
        AppMethodBeat.m2505o(93379);
        return createBitmap;
    }
}
