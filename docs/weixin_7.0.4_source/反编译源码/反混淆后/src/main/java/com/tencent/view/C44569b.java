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
import com.tencent.util.C16371i;
import com.tencent.util.C36570e;
import com.tencent.util.C5989g;
import com.tencent.view.raw.FilterRawGet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.view.b */
public final class C44569b {
    public static Context AIC;
    private static FilterRawGet AID = new FilterRawGet();
    public static boolean AIE = false;
    public static boolean AIF = false;
    public static boolean AIG = true;
    public static int AIH = -1;
    public static boolean AII = false;
    public static boolean AIJ = false;

    static {
        AppMethodBeat.m2504i(86630);
        AppMethodBeat.m2505o(86630);
    }

    public static InputStream auA(String str) {
        AppMethodBeat.m2504i(86626);
        InputStream open;
        if (AIE) {
            try {
                open = AIC.getAssets().open(str);
            } catch (IOException e) {
                open = null;
            } finally {
                AppMethodBeat.m2505o(86626);
            }
            return open;
        }
        open = AID.getInpuStream(str);
        AppMethodBeat.m2505o(86626);
        return open;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: vt */
    public static Bitmap m80951vt(String str) {
        byte[] O;
        Throwable e;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(86627);
        try {
            InputStream auA = C44569b.auA(str);
            if (auA == null) {
                C16371i.m25188m("FilterDefault", "decodeBitmap  getStream " + str + " not exist");
            }
            O = C36570e.m60594O(auA);
            try {
                C5989g.closeQuietly(auA);
            } catch (Exception e2) {
                e = e2;
                C16371i.m25183a("FilterDefault", "decodeBitmap  getStream", e);
                if (O == null) {
                }
                return bitmap;
            }
        } catch (Exception e3) {
            e = e3;
            O = bitmap;
            C16371i.m25183a("FilterDefault", "decodeBitmap  getStream", e);
            if (O == null) {
            }
            return bitmap;
        }
        if (O == null) {
            AppMethodBeat.m2505o(86627);
        } else {
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            try {
                bitmap = BitmapFactory.decodeByteArray(O, 0, O.length, options);
            } catch (OutOfMemoryError e4) {
                C16371i.m25183a("FilterDefault", "decodeByteArray", e4);
            }
            AppMethodBeat.m2505o(86627);
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
        AppMethodBeat.m2504i(86628);
        try {
            InputStream fileInputStream = new FileInputStream(str);
            O = C36570e.m60594O(fileInputStream);
            try {
                C5989g.closeQuietly(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                C16371i.m25183a("FilterDefault", "decodeBitmap  getStream", e);
                if (O != null) {
                }
                return bitmap;
            }
        } catch (Exception e3) {
            e = e3;
            O = bitmap;
        }
        if (O != null) {
            AppMethodBeat.m2505o(86628);
        } else {
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            try {
                bitmap = BitmapFactory.decodeByteArray(O, 0, O.length, options);
            } catch (OutOfMemoryError e4) {
                C16371i.m25183a("FilterDefault", "decodeByteArray", e4);
            }
            AppMethodBeat.m2505o(86628);
        }
        return bitmap;
    }

    /* renamed from: a */
    public static Bitmap m80950a(String str, Config config, int i, int i2) {
        byte[] O;
        AppMethodBeat.m2504i(86629);
        try {
            InputStream auA = C44569b.auA(str);
            O = C36570e.m60594O(auA);
            try {
                C5989g.closeQuietly(auA);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            O = null;
        }
        if (O == null) {
            AppMethodBeat.m2505o(86629);
            return null;
        }
        Options options = new Options();
        options.inPreferredConfig = config;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(O, 0, O.length, options);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(decodeByteArray, new Rect(0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight()), new Rect(0, 0, i, i2), new Paint(6));
        decodeByteArray.recycle();
        AppMethodBeat.m2505o(86629);
        return createBitmap;
    }
}
