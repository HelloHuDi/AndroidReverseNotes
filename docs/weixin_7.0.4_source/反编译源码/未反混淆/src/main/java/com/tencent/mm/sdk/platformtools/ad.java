package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class ad {
    public static boolean cI(int i, int i2) {
        return ((double) i2) > ((double) i) * 2.0d;
    }

    public static boolean cJ(int i, int i2) {
        return ((double) i) > ((double) i2) * 2.0d;
    }

    public static int amy(String str) {
        Bitmap bitmap = null;
        AppMethodBeat.i(93400);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            InputStream openRead = e.openRead(str);
            bitmap = MMBitmapFactory.decodeStream(openRead, null, options);
            openRead.close();
        } catch (FileNotFoundException | IOException e) {
        }
        if (bitmap != null) {
            ab.i("MicroMsg.LongBitmapHandler", "isLongPicture bitmap recycle. %s", bitmap);
            bitmap.recycle();
        }
        float f = ((float) options.outWidth) / ((float) options.outHeight);
        float f2 = ((float) options.outHeight) / ((float) options.outWidth);
        if (f >= 2.0f) {
            AppMethodBeat.o(93400);
            return 1;
        } else if (f2 >= 2.0f) {
            AppMethodBeat.o(93400);
            return 2;
        } else {
            AppMethodBeat.o(93400);
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x01da A:{SYNTHETIC, Splitter:B:68:0x01da} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01da A:{SYNTHETIC, Splitter:B:68:0x01da} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap ar(String str, int i, int i2) {
        Throwable e;
        InputStream inputStream;
        AppMethodBeat.i(93401);
        ab.i("MicroMsg.LongBitmapHandler", "hy: createLongPictureBitmap: path: %s, minShorter: %d, maxLonger: %d, type: %d, rotateDegree: %d", str, Integer.valueOf(56), Integer.valueOf(144), Integer.valueOf(i), Integer.valueOf(i2));
        a aVar = a.epB;
        a.eT(0);
        if (bo.isNullOrNil(str) || !(i == 2 || i == 1)) {
            ab.w("MicroMsg.LongBitmapHandler", "hy: createLongPictureBitmap precheck failed!");
            aVar = a.epB;
            a.eT(1);
            AppMethodBeat.o(93401);
            return null;
        }
        Point amk = d.amk(str);
        if (amk == null || amk.x <= 0 || amk.y <= 0) {
            ab.w("MicroMsg.LongBitmapHandler", "hy: can not retrieve original picture size!");
            aVar = a.epB;
            a.eT(3);
            AppMethodBeat.o(93401);
            return null;
        }
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f;
        Bitmap a;
        int i9 = amk.x;
        int i10 = amk.y;
        boolean z = i == 1 ? ((double) i9) / ((double) i10) > 2.5d : ((double) i10) / ((double) i9) > 2.5d;
        int i11;
        if (!z) {
            int i12;
            i11 = i == 1 ? i9 : i10;
            if (i == 1) {
                i12 = i10;
            } else {
                i12 = i9;
            }
            i3 = 0;
            i4 = 0;
            i5 = i10;
            i6 = i12;
            i7 = i11;
            i8 = i9;
        } else if (i == 1) {
            i11 = (int) (((double) i10) * 2.5d);
            i3 = (int) ((((double) i9) - (((double) i10) * 2.5d)) / 2.0d);
            i5 = i10;
            i6 = i10;
            i7 = i11;
            i4 = 0;
            i8 = i11;
        } else {
            i11 = (int) (((double) i9) * 2.5d);
            i3 = 0;
            i5 = i11;
            i6 = i9;
            i7 = i11;
            i4 = (int) ((((double) i10) - (((double) i9) * 2.5d)) / 2.0d);
            i8 = i9;
        }
        ab.d("MicroMsg.LongBitmapHandler", "hy: need crop: %b, croppedWidth: %d, croppedHeight: %d, rectStartX: %d, rectStartY: %d", Boolean.valueOf(z), Integer.valueOf(i8), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4));
        i9 = 1;
        float f2 = 1.0f;
        if (i7 > 144) {
            i9 = d.av(i6, i7, i6);
            ab.d("MicroMsg.LongBitmapHandler", "hy: need sample. use sampleSize: %d, need post scale: %f", Integer.valueOf(i9), Float.valueOf(144.0f / ((float) (i7 / i9))));
            f = f2;
        } else {
            if (i6 < 56) {
                f2 = 56.0f / ((float) i6);
                ab.d("MicroMsg.LongBitmapHandler", "hy: need scale larger. scale times: %f", Float.valueOf(f2));
            }
            f = f2;
        }
        Options options = new Options();
        options.inSampleSize = i9;
        if (z) {
            InputStream inputStream2 = null;
            try {
                inputStream2 = e.openRead(str);
                try {
                    a = com.tencent.mm.graphics.a.a(inputStream2, new Rect(i3, i4, i3 + i8, i5 + i4), options);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    inputStream = inputStream2;
                } catch (Throwable th) {
                    e = th;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                    }
                    AppMethodBeat.o(93401);
                    throw e;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                inputStream = inputStream2;
            } catch (Throwable th2) {
                e = th2;
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.o(93401);
                throw e;
            }
        }
        a = MMBitmapFactory.decodeFile(str, options);
        if (a == null) {
            ab.e("MicroMsg.LongBitmapHandler", "hy: can not decode non matrixed bitmap!!");
            aVar = a.epB;
            a.eT(5);
            AppMethodBeat.o(93401);
            return null;
        }
        a aVar2 = a.epB;
        a.eT(6);
        if (f == 1.0f && i2 == 0) {
            ab.d("MicroMsg.LongBitmapHandler", "hy: not need to post handle. return directly");
            AppMethodBeat.o(93401);
            return a;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        matrix.postRotate((float) i2);
        Bitmap createBitmap = Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true);
        if (createBitmap != a) {
            ab.i("MicroMsg.LongBitmapHandler", "bitmap recycle %s", a.toString());
            a.recycle();
        }
        if (createBitmap != null) {
            ab.d("MicroMsg.LongBitmapHandler", "hy: created bitmap is %d * %d", Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
        }
        AppMethodBeat.o(93401);
        return createBitmap;
        try {
            ab.printErrStackTrace("MicroMsg.LongBitmapHandler", e, "hy: file not found when decode region", new Object[0]);
            aVar = a.epB;
            a.eT(4);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(93401);
            return null;
        } catch (Throwable th3) {
            e = th3;
            if (inputStream != null) {
            }
            AppMethodBeat.o(93401);
            throw e;
        }
        AppMethodBeat.o(93401);
        return null;
    }

    public static boolean a(String str, CompressFormat compressFormat, String str2, int i) {
        AppMethodBeat.i(93403);
        boolean a = a(str, compressFormat, str2, i, new PInt(), new PInt());
        AppMethodBeat.o(93403);
        return a;
    }

    private static boolean a(String str, CompressFormat compressFormat, String str2, int i, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(93402);
        Bitmap ar = ar(str, i, 0);
        try {
            pInt.value = ar.getWidth();
            pInt2.value = ar.getHeight();
            d.a(ar, 90, compressFormat, str2, true);
            AppMethodBeat.o(93402);
            return true;
        } catch (IOException e) {
            ab.e("MicroMsg.LongBitmapHandler", "create thumbnail from orig failed: ".concat(String.valueOf(str2)));
            AppMethodBeat.o(93402);
            return false;
        }
    }
}
