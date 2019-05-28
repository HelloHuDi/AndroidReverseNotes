package com.bumptech.glide.p086c.p092d.p093a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.bumptech.glide.c.d.a.p */
public final class C44996p {
    private static final Paint aFE = new Paint(6);
    private static final Paint aFF = new Paint(7);
    private static final Paint aFG;
    private static final Set<String> aFH;
    private static final Lock aFI;

    /* renamed from: com.bumptech.glide.c.d.a.p$a */
    static final class C37180a implements Lock {
        C37180a() {
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
            AppMethodBeat.m2504i(92265);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
            AppMethodBeat.m2505o(92265);
            throw unsupportedOperationException;
        }
    }

    static {
        AppMethodBeat.m2504i(92267);
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        aFH = hashSet;
        aFI = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new C37180a();
        Paint paint = new Paint(7);
        aFG = paint;
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        AppMethodBeat.m2505o(92267);
    }

    /* renamed from: nx */
    public static Lock m82399nx() {
        return aFI;
    }

    /* renamed from: di */
    public static int m82397di(int i) {
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

    /* renamed from: a */
    public static Bitmap m82396a(C31925e c31925e, Bitmap bitmap, int i) {
        AppMethodBeat.m2504i(92266);
        if (C44996p.m82398dj(i)) {
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
            Bitmap c = c31925e.mo2198c(round, round2, config);
            matrix.postTranslate(-rectF.left, -rectF.top);
            aFI.lock();
            try {
                Canvas canvas = new Canvas(c);
                canvas.drawBitmap(bitmap, matrix, aFE);
                canvas.setBitmap(null);
                return c;
            } finally {
                aFI.unlock();
                AppMethodBeat.m2505o(92266);
            }
        } else {
            AppMethodBeat.m2505o(92266);
            return bitmap;
        }
    }

    /* renamed from: dj */
    public static boolean m82398dj(int i) {
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
