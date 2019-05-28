package com.tencent.mm.bw.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qbar.QbarNative;
import com.tencent.smtt.sdk.WebView;
import java.util.Arrays;

public final class a {
    public static Bitmap a(Context context, Bitmap bitmap, byte[] bArr, int[] iArr) {
        int i;
        int i2;
        int i3;
        AppMethodBeat.i(108283);
        int width = bitmap.getWidth();
        int b = b.b(context, 197.0f);
        if (b < width) {
            b = width;
        }
        int i4 = (int) (((double) iArr[0]) * 0.1d);
        b /= iArr[0] + (i4 * 2);
        if (b == 0) {
            i = 1;
        } else {
            i = b;
        }
        int i5 = i4 * i;
        int i6 = i * (iArr[0] + (i4 * 2));
        int i7 = (iArr[1] * i) + (i4 * (i * 2));
        if (i6 < width) {
            i6 = width;
        }
        if (i7 < width) {
            i7 = width;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Config.ARGB_8888);
        int[] iArr2 = new int[(i6 * i7)];
        int i8 = (i6 - width) / 2;
        int i9 = 0;
        for (int i10 = i8; i10 < i6 - i8 && i9 < width; i10++) {
            i2 = 0;
            i3 = i8;
            while (i3 < i7 - i8 && i2 < width) {
                iArr2[(i10 * i6) + i3] = bitmap.getPixel(i2, i9);
                i3++;
                i2++;
            }
            i9++;
        }
        for (width = 0; width < iArr[1]; width++) {
            for (i2 = 0; i2 < iArr[0]; i2++) {
                if (bArr[(iArr[0] * width) + i2] == (byte) 1) {
                    for (i8 = 0; i8 < i; i8++) {
                        for (i3 = 0; i3 < i; i3++) {
                            if (iArr2[((((((width * i) + i5) + i8) * i6) + (i2 * i)) + i5) + i3] == 0) {
                                iArr2[((((((width * i) + i5) + i8) * i6) + (i2 * i)) + i5) + i3] = WebView.NIGHT_MODE_COLOR;
                            }
                        }
                    }
                } else {
                    for (i8 = 0; i8 < i; i8++) {
                        for (i3 = 0; i3 < i; i3++) {
                            if (iArr2[((((((width * i) + i5) + i8) * i6) + (i2 * i)) + i5) + i3] == 0) {
                                iArr2[((((((width * i) + i5) + i8) * i6) + (i2 * i)) + i5) + i3] = -1;
                            }
                        }
                    }
                }
            }
        }
        createBitmap.setPixels(iArr2, 0, i6, 0, 0, i6, i7);
        AppMethodBeat.o(108283);
        return createBitmap;
    }

    public static Bitmap b(Context context, String str, int i, int i2) {
        AppMethodBeat.i(108284);
        byte[] bArr = new byte[40000];
        int[] iArr = new int[2];
        int a = QbarNative.a(bArr, iArr, str, i, i2, "UTF-8");
        QbarNative.nativeRelease();
        if (a == 0) {
            Bitmap a2 = a(context, bArr, iArr, i);
            if (a2 == null) {
                ab.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", Integer.valueOf(a), bo.dpG().toString());
            } else {
                ab.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", a2);
            }
            AppMethodBeat.o(108284);
            return a2;
        }
        ab.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", Integer.valueOf(a), bo.dpG().toString());
        AppMethodBeat.o(108284);
        return null;
    }

    private static Bitmap a(Context context, byte[] bArr, int[] iArr, int i) {
        int i2;
        AppMethodBeat.i(108285);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        if (i3 >= i4) {
            i3 = i4;
        }
        int i5 = (int) (((double) i3) * 0.8d);
        int i6 = (int) (((double) iArr[0]) * 0.1d);
        if (i == 12) {
            i3 = i5 / (iArr[0] + (i6 * 2));
            if (i3 == 0) {
                i3 = 1;
            }
            i5 = i3;
            i2 = i3;
        } else if (i == 5) {
            i3 = i5 / (iArr[0] + (i6 * 2));
            if (i3 == 0) {
                i3 = 1;
            }
            i5 = (iArr[0] * i3) / iArr[1];
            i2 = i3;
        } else {
            i5 = 0;
            i2 = 0;
        }
        int i7 = i6 * i2;
        int i8 = i2 * (iArr[0] + (i6 * 2));
        int i9 = (iArr[1] * i5) + ((i2 * 2) * i6);
        Bitmap createBitmap = Bitmap.createBitmap(i8, i9, Config.ARGB_8888);
        int[] iArr2 = new int[(i8 * i9)];
        Arrays.fill(iArr2, -1);
        for (i6 = 0; i6 < iArr[1]; i6++) {
            for (int i10 = 0; i10 < iArr[0]; i10++) {
                int i11;
                int i12;
                if (bArr[(iArr[0] * i6) + i10] == (byte) 1) {
                    for (i11 = 0; i11 < i5; i11++) {
                        for (i12 = 0; i12 < i2; i12++) {
                            iArr2[((((((i6 * i5) + i7) + i11) * i8) + (i10 * i2)) + i7) + i12] = WebView.NIGHT_MODE_COLOR;
                        }
                    }
                } else {
                    for (i11 = 0; i11 < i5; i11++) {
                        for (i12 = 0; i12 < i2; i12++) {
                            iArr2[((((((i6 * i5) + i7) + i11) * i8) + (i10 * i2)) + i7) + i12] = -1;
                        }
                    }
                }
            }
        }
        createBitmap.setPixels(iArr2, 0, i8, 0, 0, i8, i9);
        AppMethodBeat.o(108285);
        return createBitmap;
    }

    public static Bitmap bF(Context context, String str) {
        AppMethodBeat.i(108286);
        byte[] bArr = new byte[40000];
        int[] iArr = new int[2];
        int a = QbarNative.a(bArr, iArr, str, 12, 1, "UTF-8");
        QbarNative.nativeRelease();
        if (a == 0) {
            Bitmap a2 = a(context, bArr, iArr);
            if (a2 == null) {
                ab.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", Integer.valueOf(a), bo.dpG().toString());
            } else {
                ab.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", a2);
            }
            AppMethodBeat.o(108286);
            return a2;
        }
        ab.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", Integer.valueOf(a), bo.dpG().toString());
        AppMethodBeat.o(108286);
        return null;
    }

    private static Bitmap a(Context context, byte[] bArr, int[] iArr) {
        int i;
        AppMethodBeat.i(108287);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        if (i2 >= i3) {
            i2 = i3;
        }
        int i4 = (int) (((double) iArr[0]) * 0.1d);
        i2 = ((int) (((double) i2) * 0.8d)) / (iArr[0] + (i4 * 2));
        if (i2 == 0) {
            i = 1;
        } else {
            i = i2;
        }
        int i5 = i4 * i;
        int i6 = i * (iArr[0] + (i4 * 2));
        int i7 = (iArr[1] * i) + ((i * 2) * i4);
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Config.ARGB_8888);
        int[] iArr2 = new int[(i6 * i7)];
        int i8 = (i * 2) + (i / 2);
        int i9 = (i * 3) + (i / 2);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Arrays.fill(iArr2, -1);
        int[] iArr3 = new int[]{(i * 3) + (i / 2), (i * 3) + (i / 2), (((iArr[0] - 1) - 3) * i) + (i / 2), (i * 3) + (i / 2), (i * 3) + (i / 2), (((iArr[1] - 1) - 3) * i) + (i / 2)};
        int i10 = 0;
        while (i10 < iArr[1]) {
            int i11 = 0;
            while (i11 < iArr[0]) {
                if (bArr[(iArr[0] * i10) + i11] == (byte) 1) {
                    int i12;
                    int i13;
                    if ((i10 >= 0 && i10 <= 6 && i11 >= 0 && i11 <= 6) || ((i10 >= 0 && i10 <= 6 && i11 >= iArr[0] - 7 && i11 <= iArr[0] - 1) || (i10 >= iArr[1] - 7 && i10 <= iArr[1] - 1 && i11 >= 0 && i11 <= 6))) {
                        for (i12 = 0; i12 < i; i12++) {
                            for (i13 = 0; i13 < i; i13++) {
                                iArr2[((((((i10 * i) + i5) + i12) * i6) + (i11 * i)) + i5) + i13] = -1;
                            }
                        }
                    } else if (dmD()) {
                        for (i12 = 0; i12 < i; i12++) {
                            for (i13 = 0; i13 < i; i13++) {
                                iArr2[((((((i10 * i) + i5) + i12) * i6) + (i11 * i)) + i5) + i13] = -3041484;
                            }
                        }
                    } else {
                        for (i12 = 0; i12 < i; i12++) {
                            for (i13 = 0; i13 < i; i13++) {
                                iArr2[((((((i10 * i) + i5) + i12) * i6) + (i11 * i)) + i5) + i13] = -2598591;
                            }
                        }
                    }
                }
                i11++;
            }
            i10++;
        }
        createBitmap.setPixels(iArr2, 0, i6, 0, 0, i6, i7);
        for (i3 = 0; i3 < 3; i3++) {
            paint.setColor(-2598591);
            paint.setStyle(Style.FILL);
            canvas.drawCircle((float) ((i * i4) + iArr3[i3 * 2]), (float) ((i * i4) + iArr3[(i3 * 2) + 1]), (float) i9, paint);
            paint.setColor(-1);
            canvas.drawCircle((float) ((i * i4) + iArr3[i3 * 2]), (float) ((i * i4) + iArr3[(i3 * 2) + 1]), (float) i8, paint);
        }
        i3 = 0;
        while (true) {
            i7 = i3;
            if (i7 >= 3) {
                break;
            }
            paint.setColor(-3041484);
            paint.setStyle(Style.FILL);
            Canvas canvas2 = canvas;
            canvas2.drawRect((float) ((((i * i4) + iArr3[i7 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i4) + iArr3[(i7 * 2) + 1]) - i) - ((i * 1) / 4)), (float) (((i * 1) / 4) + (((i * i4) + iArr3[i7 * 2]) + i)), (float) (((i * 1) / 4) + (((i * i4) + iArr3[(i7 * 2) + 1]) + i)), paint);
            i3 = i7 + 1;
        }
        for (i3 = 0; i3 < 3; i3++) {
            paint.setColor(-1);
            paint.setStyle(Style.FILL_AND_STROKE);
            Path path = new Path();
            path.moveTo((float) ((((i * i4) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
            path.quadTo((float) ((i * i4) + iArr3[i3 * 2]), (float) (((i * i4) + iArr3[(i3 * 2) + 1]) - i), (float) ((((i * i4) + iArr3[i3 * 2]) + i) + (i / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
            path.lineTo((float) ((((i * i4) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
            path.close();
            canvas.drawPath(path, paint);
            path.moveTo((float) ((((i * i4) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
            path.quadTo((float) (((i * i4) + iArr3[i3 * 2]) - i), (float) ((i * i4) + iArr3[(i3 * 2) + 1]), (float) ((((i * i4) + iArr3[i3 * 2]) - i) - (i / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
            path.lineTo((float) ((((i * i4) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
            path.close();
            canvas.drawPath(path, paint);
            path.moveTo((float) ((((i * i4) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
            path.quadTo((float) ((i * i4) + iArr3[i3 * 2]), (float) (((i * i4) + iArr3[(i3 * 2) + 1]) + i), (float) ((((i * i4) + iArr3[i3 * 2]) - i) - (i / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
            path.lineTo((float) ((((i * i4) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
            path.close();
            canvas.drawPath(path, paint);
            path.moveTo((float) ((((i * i4) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
            path.quadTo((float) (((i * i4) + iArr3[i3 * 2]) + i), (float) ((i * i4) + iArr3[(i3 * 2) + 1]), (float) ((((i * i4) + iArr3[i3 * 2]) + i) + (i / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
            path.lineTo((float) ((((i * i4) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i4) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
            path.close();
            canvas.drawPath(path, paint);
        }
        AppMethodBeat.o(108287);
        return createBitmap;
    }

    private static boolean dmD() {
        AppMethodBeat.i(108288);
        boolean[] zArr = new boolean[10];
        zArr[5] = true;
        boolean z = zArr[(int) (Math.random() * 10.0d)];
        AppMethodBeat.o(108288);
        return z;
    }
}
