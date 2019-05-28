package com.tencent.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.e;
import com.tencent.util.g;
import com.tencent.util.i;
import com.tencent.view.raw.FilterRawGet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b {
    public static Context AIC;
    private static FilterRawGet AID = new FilterRawGet();
    public static boolean AIE = false;
    public static boolean AIF = false;
    public static boolean AIG = true;
    public static int AIH = -1;
    public static boolean AII = false;
    public static boolean AIJ = false;

    static {
        AppMethodBeat.i(86630);
        AppMethodBeat.o(86630);
    }

    public static InputStream auA(String str) {
        AppMethodBeat.i(86626);
        InputStream open;
        if (AIE) {
            try {
                open = AIC.getAssets().open(str);
            } catch (IOException e) {
                open = null;
            } finally {
                AppMethodBeat.o(86626);
            }
            return open;
        }
        open = AID.getInpuStream(str);
        AppMethodBeat.o(86626);
        return open;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap vt(String str) {
        byte[] O;
        Throwable e;
        Bitmap bitmap = null;
        AppMethodBeat.i(86627);
        try {
            InputStream auA = auA(str);
            if (auA == null) {
                i.m("FilterDefault", "decodeBitmap  getStream " + str + " not exist");
            }
            O = e.O(auA);
            try {
                g.closeQuietly(auA);
            } catch (Exception e2) {
                e = e2;
                i.a("FilterDefault", "decodeBitmap  getStream", e);
                if (O == null) {
                }
                return bitmap;
            }
        } catch (Exception e3) {
            e = e3;
            O = bitmap;
            i.a("FilterDefault", "decodeBitmap  getStream", e);
            if (O == null) {
            }
            return bitmap;
        }
        if (O == null) {
            AppMethodBeat.o(86627);
        } else {
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            try {
                bitmap = BitmapFactory.decodeByteArray(O, 0, O.length, options);
            } catch (OutOfMemoryError e4) {
                i.a("FilterDefault", "decodeByteArray", e4);
            }
            AppMethodBeat.o(86627);
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Bitmap auB(String str) {
        byte[] O;
        Throwable e;
        Bitmap bitmap = null;
        AppMethodBeat.i(86628);
        try {
            InputStream fileInputStream = new FileInputStream(str);
            O = e.O(fileInputStream);
            try {
                g.closeQuietly(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                i.a("FilterDefault", "decodeBitmap  getStream", e);
                if (O != null) {
                }
                return bitmap;
            }
        } catch (Exception e3) {
            e = e3;
            O = bitmap;
        }
        if (O != null) {
            AppMethodBeat.o(86628);
        } else {
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            try {
                bitmap = BitmapFactory.decodeByteArray(O, 0, O.length, options);
            } catch (OutOfMemoryError e4) {
                i.a("FilterDefault", "decodeByteArray", e4);
            }
            AppMethodBeat.o(86628);
        }
        return bitmap;
    }

    public static Bitmap a(String str, Config config, int i, int i2) {
        byte[] O;
        AppMethodBeat.i(86629);
        try {
            InputStream auA = auA(str);
            O = e.O(auA);
            try {
                g.closeQuietly(auA);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            O = null;
        }
        if (O == null) {
            AppMethodBeat.o(86629);
            return null;
        }
        Options options = new Options();
        options.inPreferredConfig = config;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(O, 0, O.length, options);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(decodeByteArray, new Rect(0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight()), new Rect(0, 0, i, i2), new Paint(6));
        decodeByteArray.recycle();
        AppMethodBeat.o(86629);
        return createBitmap;
    }
}
