package com.bumptech.glide.p095h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.p057v4.widget.C8415j;
import com.bumptech.glide.p086c.p090c.C0767l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* renamed from: com.bumptech.glide.h.j */
public final class C45002j {
    private static final char[] aIg = "0123456789abcdef".toCharArray();
    private static final char[] aIh = new char[64];

    /* renamed from: com.bumptech.glide.h.j$1 */
    static /* synthetic */ class C175621 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            AppMethodBeat.m2504i(92601);
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
                AppMethodBeat.m2505o(92601);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.m2505o(92601);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(92615);
        AppMethodBeat.m2505o(92615);
    }

    /* renamed from: i */
    public static String m82422i(byte[] bArr) {
        String str;
        AppMethodBeat.m2504i(92602);
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
                AppMethodBeat.m2505o(92602);
            }
        }
        return str;
    }

    @TargetApi(19)
    /* renamed from: k */
    public static int m82425k(Bitmap bitmap) {
        AppMethodBeat.m2504i(92603);
        if (bitmap.isRecycled()) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + VideoMaterialUtil.CRAZYFACE_X + bitmap.getHeight() + "] " + bitmap.getConfig());
            AppMethodBeat.m2505o(92603);
            throw illegalStateException;
        }
        int allocationByteCount;
        if (VERSION.SDK_INT >= 19) {
            try {
                allocationByteCount = bitmap.getAllocationByteCount();
                AppMethodBeat.m2505o(92603);
                return allocationByteCount;
            } catch (NullPointerException e) {
            }
        }
        allocationByteCount = bitmap.getHeight() * bitmap.getRowBytes();
        AppMethodBeat.m2505o(92603);
        return allocationByteCount;
    }

    /* renamed from: j */
    public static int m82424j(int i, int i2, Config config) {
        int i3;
        AppMethodBeat.m2504i(92604);
        int i4 = i * i2;
        if (config == null) {
            config = Config.ARGB_8888;
        }
        switch (C175621.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
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
        AppMethodBeat.m2505o(92604);
        return i3;
    }

    /* renamed from: aW */
    public static boolean m82415aW(int i, int i2) {
        AppMethodBeat.m2504i(92605);
        if (C45002j.m82419dm(i) && C45002j.m82419dm(i2)) {
            AppMethodBeat.m2505o(92605);
            return true;
        }
        AppMethodBeat.m2505o(92605);
        return false;
    }

    /* renamed from: dm */
    private static boolean m82419dm(int i) {
        return i > 0 || i == C8415j.INVALID_ID;
    }

    /* renamed from: om */
    public static void m82426om() {
        AppMethodBeat.m2504i(92606);
        if (C45002j.m82427on()) {
            AppMethodBeat.m2505o(92606);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must call this method on the main thread");
        AppMethodBeat.m2505o(92606);
        throw illegalArgumentException;
    }

    /* renamed from: on */
    public static boolean m82427on() {
        AppMethodBeat.m2504i(92607);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.m2505o(92607);
            return true;
        }
        AppMethodBeat.m2505o(92607);
        return false;
    }

    /* renamed from: oo */
    public static boolean m82428oo() {
        AppMethodBeat.m2504i(92608);
        if (C45002j.m82427on()) {
            AppMethodBeat.m2505o(92608);
            return false;
        }
        AppMethodBeat.m2505o(92608);
        return true;
    }

    /* renamed from: dn */
    public static <T> Queue<T> m82420dn(int i) {
        AppMethodBeat.m2504i(92609);
        ArrayDeque arrayDeque = new ArrayDeque(i);
        AppMethodBeat.m2505o(92609);
        return arrayDeque;
    }

    /* renamed from: d */
    public static <T> List<T> m82418d(Collection<T> collection) {
        AppMethodBeat.m2504i(92610);
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        AppMethodBeat.m2505o(92610);
        return arrayList;
    }

    /* renamed from: h */
    public static boolean m82421h(Object obj, Object obj2) {
        AppMethodBeat.m2504i(92611);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.m2505o(92611);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.m2505o(92611);
            return true;
        } else {
            AppMethodBeat.m2505o(92611);
            return false;
        }
    }

    /* renamed from: i */
    public static boolean m82423i(Object obj, Object obj2) {
        AppMethodBeat.m2504i(92612);
        boolean ni;
        if (obj == null) {
            if (obj2 == null) {
                AppMethodBeat.m2505o(92612);
                return true;
            }
            AppMethodBeat.m2505o(92612);
            return false;
        } else if (obj instanceof C0767l) {
            ni = ((C0767l) obj).mo2226ni();
            AppMethodBeat.m2505o(92612);
            return ni;
        } else {
            ni = obj.equals(obj2);
            AppMethodBeat.m2505o(92612);
            return ni;
        }
    }

    public static int hashCode(int i, int i2) {
        return (i2 * 31) + i;
    }

    /* renamed from: b */
    public static int m82416b(Object obj, int i) {
        int i2;
        AppMethodBeat.m2504i(92614);
        if (obj == null) {
            i2 = 0;
        } else {
            i2 = obj.hashCode();
        }
        i2 += i * 31;
        AppMethodBeat.m2505o(92614);
        return i2;
    }

    /* renamed from: b */
    public static int m82417b(boolean z, int i) {
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        return i2 + (i * 31);
    }

    public static int hashCode(float f) {
        AppMethodBeat.m2504i(92613);
        int floatToIntBits = Float.floatToIntBits(f) + JsApiGetABTestConfig.CTRL_INDEX;
        AppMethodBeat.m2505o(92613);
        return floatToIntBits;
    }
}
