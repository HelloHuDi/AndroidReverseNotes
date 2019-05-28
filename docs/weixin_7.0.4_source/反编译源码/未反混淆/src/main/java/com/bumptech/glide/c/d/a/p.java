package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.bumptech.glide.c.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class p {
    private static final Paint aFE = new Paint(6);
    private static final Paint aFF = new Paint(7);
    private static final Paint aFG;
    private static final Set<String> aFH;
    private static final Lock aFI;

    static final class a implements Lock {
        a() {
        }

        public final void lock() {
        }

        public final void lockInterruptibly() {
        }

        public final boolean tryLock() {
            return true;
        }

        public final boolean tryLock(long j, TimeUnit timeUnit) {
            return true;
        }

        public final void unlock() {
        }

        public final Condition newCondition() {
            AppMethodBeat.i(92265);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
            AppMethodBeat.o(92265);
            throw unsupportedOperationException;
        }
    }

    static {
        AppMethodBeat.i(92267);
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        aFH = hashSet;
        aFI = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new a();
        Paint paint = new Paint(7);
        aFG = paint;
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        AppMethodBeat.o(92267);
    }

    public static Lock nx() {
        return aFI;
    }

    public static int di(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap a(e eVar, Bitmap bitmap, int i) {
        AppMethodBeat.i(92266);
        if (dj(i)) {
            Config config;
            Matrix matrix = new Matrix();
            switch (i) {
                case 2:
                    matrix.setScale(-1.0f, 1.0f);
                    break;
                case 3:
                    matrix.setRotate(180.0f);
                    break;
                case 4:
                    matrix.setRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 5:
                    matrix.setRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 6:
                    matrix.setRotate(90.0f);
                    break;
                case 7:
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 8:
                    matrix.setRotate(-90.0f);
                    break;
            }
            RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
            matrix.mapRect(rectF);
            int round = Math.round(rectF.width());
            int round2 = Math.round(rectF.height());
            if (bitmap.getConfig() != null) {
                config = bitmap.getConfig();
            } else {
                config = Config.ARGB_8888;
            }
            Bitmap c = eVar.c(round, round2, config);
            matrix.postTranslate(-rectF.left, -rectF.top);
            aFI.lock();
            try {
                Canvas canvas = new Canvas(c);
                canvas.drawBitmap(bitmap, matrix, aFE);
                canvas.setBitmap(null);
                return c;
            } finally {
                aFI.unlock();
                AppMethodBeat.o(92266);
            }
        } else {
            AppMethodBeat.o(92266);
            return bitmap;
        }
    }

    public static boolean dj(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }
}
