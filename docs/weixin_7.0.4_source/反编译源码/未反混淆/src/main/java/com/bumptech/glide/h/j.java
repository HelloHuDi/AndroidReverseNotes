package com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import com.bumptech.glide.c.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class j {
    private static final char[] aIg = "0123456789abcdef".toCharArray();
    private static final char[] aIh = new char[64];

    /* renamed from: com.bumptech.glide.h.j$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            AppMethodBeat.i(92601);
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_8888.ordinal()] = 5;
                AppMethodBeat.o(92601);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(92601);
            }
        }
    }

    static {
        AppMethodBeat.i(92615);
        AppMethodBeat.o(92615);
    }

    public static String i(byte[] bArr) {
        String str;
        AppMethodBeat.i(92602);
        synchronized (aIh) {
            try {
                char[] cArr = aIh;
                for (int i = 0; i < bArr.length; i++) {
                    int i2 = bArr[i] & 255;
                    cArr[i * 2] = aIg[i2 >>> 4];
                    cArr[(i * 2) + 1] = aIg[i2 & 15];
                }
                str = new String(cArr);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(92602);
            }
        }
        return str;
    }

    @TargetApi(19)
    public static int k(Bitmap bitmap) {
        AppMethodBeat.i(92603);
        if (bitmap.isRecycled()) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + VideoMaterialUtil.CRAZYFACE_X + bitmap.getHeight() + "] " + bitmap.getConfig());
            AppMethodBeat.o(92603);
            throw illegalStateException;
        }
        int allocationByteCount;
        if (VERSION.SDK_INT >= 19) {
            try {
                allocationByteCount = bitmap.getAllocationByteCount();
                AppMethodBeat.o(92603);
                return allocationByteCount;
            } catch (NullPointerException e) {
            }
        }
        allocationByteCount = bitmap.getHeight() * bitmap.getRowBytes();
        AppMethodBeat.o(92603);
        return allocationByteCount;
    }

    public static int j(int i, int i2, Config config) {
        int i3;
        AppMethodBeat.i(92604);
        int i4 = i * i2;
        if (config == null) {
            config = Config.ARGB_8888;
        }
        switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
            case 1:
                i3 = 1;
                break;
            case 2:
            case 3:
                i3 = 2;
                break;
            case 4:
                i3 = 8;
                break;
            default:
                i3 = 4;
                break;
        }
        i3 *= i4;
        AppMethodBeat.o(92604);
        return i3;
    }

    public static boolean aW(int i, int i2) {
        AppMethodBeat.i(92605);
        if (dm(i) && dm(i2)) {
            AppMethodBeat.o(92605);
            return true;
        }
        AppMethodBeat.o(92605);
        return false;
    }

    private static boolean dm(int i) {
        return i > 0 || i == android.support.v4.widget.j.INVALID_ID;
    }

    public static void om() {
        AppMethodBeat.i(92606);
        if (on()) {
            AppMethodBeat.o(92606);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must call this method on the main thread");
        AppMethodBeat.o(92606);
        throw illegalArgumentException;
    }

    public static boolean on() {
        AppMethodBeat.i(92607);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(92607);
            return true;
        }
        AppMethodBeat.o(92607);
        return false;
    }

    public static boolean oo() {
        AppMethodBeat.i(92608);
        if (on()) {
            AppMethodBeat.o(92608);
            return false;
        }
        AppMethodBeat.o(92608);
        return true;
    }

    public static <T> Queue<T> dn(int i) {
        AppMethodBeat.i(92609);
        ArrayDeque arrayDeque = new ArrayDeque(i);
        AppMethodBeat.o(92609);
        return arrayDeque;
    }

    public static <T> List<T> d(Collection<T> collection) {
        AppMethodBeat.i(92610);
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        AppMethodBeat.o(92610);
        return arrayList;
    }

    public static boolean h(Object obj, Object obj2) {
        AppMethodBeat.i(92611);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(92611);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.o(92611);
            return true;
        } else {
            AppMethodBeat.o(92611);
            return false;
        }
    }

    public static boolean i(Object obj, Object obj2) {
        AppMethodBeat.i(92612);
        boolean ni;
        if (obj == null) {
            if (obj2 == null) {
                AppMethodBeat.o(92612);
                return true;
            }
            AppMethodBeat.o(92612);
            return false;
        } else if (obj instanceof l) {
            ni = ((l) obj).ni();
            AppMethodBeat.o(92612);
            return ni;
        } else {
            ni = obj.equals(obj2);
            AppMethodBeat.o(92612);
            return ni;
        }
    }

    public static int hashCode(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static int b(Object obj, int i) {
        int i2;
        AppMethodBeat.i(92614);
        if (obj == null) {
            i2 = 0;
        } else {
            i2 = obj.hashCode();
        }
        i2 += i * 31;
        AppMethodBeat.o(92614);
        return i2;
    }

    public static int b(boolean z, int i) {
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        return i2 + (i * 31);
    }

    public static int hashCode(float f) {
        AppMethodBeat.i(92613);
        int floatToIntBits = Float.floatToIntBits(f) + JsApiGetABTestConfig.CTRL_INDEX;
        AppMethodBeat.o(92613);
        return floatToIntBits;
    }
}
