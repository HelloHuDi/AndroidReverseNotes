package com.bumptech.glide.c.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class n implements l {
    private static final Config[] aCQ;
    private static final Config[] aCR;
    private static final Config[] aCS = new Config[]{Config.RGB_565};
    private static final Config[] aCT = new Config[]{Config.ARGB_4444};
    private static final Config[] aCU = new Config[]{Config.ALPHA_8};
    private final Map<Config, NavigableMap<Integer, Integer>> aCC = new HashMap();
    private final b aCV = new b();
    private final h<a, Bitmap> aCr = new h();

    static final class a implements m {
        private final b aCW;
        private Config aCt;
        int size;

        public a(b bVar) {
            this.aCW = bVar;
        }

        public final void b(int i, Config config) {
            this.size = i;
            this.aCt = config;
        }

        public final void mQ() {
            AppMethodBeat.i(91957);
            this.aCW.a(this);
            AppMethodBeat.o(91957);
        }

        public final String toString() {
            AppMethodBeat.i(91958);
            String a = n.a(this.size, this.aCt);
            AppMethodBeat.o(91958);
            return a;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(91959);
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.size == aVar.size && j.h(this.aCt, aVar.aCt)) {
                    AppMethodBeat.o(91959);
                    return true;
                }
                AppMethodBeat.o(91959);
                return false;
            }
            AppMethodBeat.o(91959);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(91960);
            int hashCode = (this.aCt != null ? this.aCt.hashCode() : 0) + (this.size * 31);
            AppMethodBeat.o(91960);
            return hashCode;
        }
    }

    static class b extends d<a> {
        b() {
        }

        public final a c(int i, Config config) {
            AppMethodBeat.i(91961);
            a aVar = (a) mS();
            aVar.b(i, config);
            AppMethodBeat.o(91961);
            return aVar;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ m mR() {
            AppMethodBeat.i(91962);
            a aVar = new a(this);
            AppMethodBeat.o(91962);
            return aVar;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.a.n$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            AppMethodBeat.i(91956);
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_8888.ordinal()] = 1;
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
                $SwitchMap$android$graphics$Bitmap$Config[Config.ALPHA_8.ordinal()] = 4;
                AppMethodBeat.o(91956);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(91956);
            }
        }
    }

    public n() {
        AppMethodBeat.i(91963);
        AppMethodBeat.o(91963);
    }

    static {
        AppMethodBeat.i(91974);
        Config[] configArr = new Config[]{Config.ARGB_8888, null};
        if (VERSION.SDK_INT >= 26) {
            configArr = (Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Config.RGBA_F16;
        }
        aCQ = configArr;
        aCR = configArr;
        AppMethodBeat.o(91974);
    }

    public final void g(Bitmap bitmap) {
        AppMethodBeat.i(91964);
        a c = this.aCV.c(j.k(bitmap), bitmap.getConfig());
        this.aCr.a(c, bitmap);
        NavigableMap b = b(bitmap.getConfig());
        Integer num = (Integer) b.get(Integer.valueOf(c.size));
        b.put(Integer.valueOf(c.size), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
        AppMethodBeat.o(91964);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Bitmap c(int i, int i2, Config config) {
        Config[] configArr;
        m c;
        Bitmap bitmap;
        Object c2;
        int i3 = 0;
        AppMethodBeat.i(91965);
        int j = j.j(i, i2, config);
        a c3 = this.aCV.c(j, config);
        if (VERSION.SDK_INT < 26 || !Config.RGBA_F16.equals(config)) {
            switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
                case 1:
                    configArr = aCQ;
                    break;
                case 2:
                    configArr = aCS;
                    break;
                case 3:
                    configArr = aCT;
                    break;
                case 4:
                    configArr = aCU;
                    break;
                default:
                    configArr = new Config[]{config};
                    break;
            }
        }
        configArr = aCR;
        int length = configArr.length;
        while (i3 < length) {
            Config config2 = configArr[i3];
            Integer num = (Integer) b(config2).ceilingKey(Integer.valueOf(j));
            if (num == null || num.intValue() > j * 8) {
                i3++;
            } else {
                if (num.intValue() != j || (config2 != null ? !config2.equals(config) : config != null)) {
                    this.aCV.a(c3);
                    c2 = this.aCV.c(num.intValue(), config2);
                    bitmap = (Bitmap) this.aCr.b(c2);
                    if (bitmap != null) {
                        a(Integer.valueOf(c2.size), bitmap);
                        bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
                    }
                    AppMethodBeat.o(91965);
                    return bitmap;
                }
                c2 = c3;
                bitmap = (Bitmap) this.aCr.b(c2);
                if (bitmap != null) {
                }
                AppMethodBeat.o(91965);
                return bitmap;
            }
        }
        c2 = c3;
        bitmap = (Bitmap) this.aCr.b(c2);
        if (bitmap != null) {
        }
        AppMethodBeat.o(91965);
        return bitmap;
    }

    public final Bitmap mP() {
        AppMethodBeat.i(91966);
        Bitmap bitmap = (Bitmap) this.aCr.removeLast();
        if (bitmap != null) {
            a(Integer.valueOf(j.k(bitmap)), bitmap);
        }
        AppMethodBeat.o(91966);
        return bitmap;
    }

    private void a(Integer num, Bitmap bitmap) {
        AppMethodBeat.i(91967);
        NavigableMap b = b(bitmap.getConfig());
        Integer num2 = (Integer) b.get(num);
        if (num2 == null) {
            NullPointerException nullPointerException = new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + h(bitmap) + ", this: " + this);
            AppMethodBeat.o(91967);
            throw nullPointerException;
        } else if (num2.intValue() == 1) {
            b.remove(num);
            AppMethodBeat.o(91967);
        } else {
            b.put(num, Integer.valueOf(num2.intValue() - 1));
            AppMethodBeat.o(91967);
        }
    }

    private NavigableMap<Integer, Integer> b(Config config) {
        AppMethodBeat.i(91968);
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.aCC.get(config);
        if (navigableMap == null) {
            navigableMap = new TreeMap();
            this.aCC.put(config, navigableMap);
        }
        AppMethodBeat.o(91968);
        return navigableMap;
    }

    public final String h(Bitmap bitmap) {
        AppMethodBeat.i(91969);
        String a = a(j.k(bitmap), bitmap.getConfig());
        AppMethodBeat.o(91969);
        return a;
    }

    public final String d(int i, int i2, Config config) {
        AppMethodBeat.i(91970);
        String a = a(j.j(i, i2, config), config);
        AppMethodBeat.o(91970);
        return a;
    }

    public final int i(Bitmap bitmap) {
        AppMethodBeat.i(91971);
        int k = j.k(bitmap);
        AppMethodBeat.o(91971);
        return k;
    }

    public final String toString() {
        AppMethodBeat.i(91972);
        StringBuilder append = new StringBuilder("SizeConfigStrategy{groupedMap=").append(this.aCr).append(", sortedSizes=(");
        for (Entry entry : this.aCC.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.aCC.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        String stringBuilder = append.append(")}").toString();
        AppMethodBeat.o(91972);
        return stringBuilder;
    }

    static String a(int i, Config config) {
        AppMethodBeat.i(91973);
        String str = "[" + i + "](" + config + ")";
        AppMethodBeat.o(91973);
        return str;
    }
}
