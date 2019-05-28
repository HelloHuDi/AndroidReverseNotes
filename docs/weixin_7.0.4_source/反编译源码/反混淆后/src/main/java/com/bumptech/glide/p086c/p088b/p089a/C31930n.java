package com.bumptech.glide.p086c.p088b.p089a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.bumptech.glide.c.b.a.n */
public final class C31930n implements C0751l {
    private static final Config[] aCQ;
    private static final Config[] aCR;
    private static final Config[] aCS = new Config[]{Config.RGB_565};
    private static final Config[] aCT = new Config[]{Config.ARGB_4444};
    private static final Config[] aCU = new Config[]{Config.ALPHA_8};
    private final Map<Config, NavigableMap<Integer, Integer>> aCC = new HashMap();
    private final C8517b aCV = new C8517b();
    private final C44982h<C8516a, Bitmap> aCr = new C44982h();

    /* renamed from: com.bumptech.glide.c.b.a.n$a */
    static final class C8516a implements C31928m {
        private final C8517b aCW;
        private Config aCt;
        int size;

        public C8516a(C8517b c8517b) {
            this.aCW = c8517b;
        }

        /* renamed from: b */
        public final void mo18613b(int i, Config config) {
            this.size = i;
            this.aCt = config;
        }

        /* renamed from: mQ */
        public final void mo18616mQ() {
            AppMethodBeat.m2504i(91957);
            this.aCW.mo59239a(this);
            AppMethodBeat.m2505o(91957);
        }

        public final String toString() {
            AppMethodBeat.m2504i(91958);
            String a = C31930n.m51867a(this.size, this.aCt);
            AppMethodBeat.m2505o(91958);
            return a;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(91959);
            if (obj instanceof C8516a) {
                C8516a c8516a = (C8516a) obj;
                if (this.size == c8516a.size && C45002j.m82421h(this.aCt, c8516a.aCt)) {
                    AppMethodBeat.m2505o(91959);
                    return true;
                }
                AppMethodBeat.m2505o(91959);
                return false;
            }
            AppMethodBeat.m2505o(91959);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(91960);
            int hashCode = (this.aCt != null ? this.aCt.hashCode() : 0) + (this.size * 31);
            AppMethodBeat.m2505o(91960);
            return hashCode;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.a.n$b */
    static class C8517b extends C37164d<C8516a> {
        C8517b() {
        }

        /* renamed from: c */
        public final C8516a mo18618c(int i, Config config) {
            AppMethodBeat.m2504i(91961);
            C8516a c8516a = (C8516a) mo59240mS();
            c8516a.mo18613b(i, config);
            AppMethodBeat.m2505o(91961);
            return c8516a;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        /* renamed from: mR */
        public final /* synthetic */ C31928m mo18619mR() {
            AppMethodBeat.m2504i(91962);
            C8516a c8516a = new C8516a(this);
            AppMethodBeat.m2505o(91962);
            return c8516a;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.a.n$1 */
    static /* synthetic */ class C319291 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            AppMethodBeat.m2504i(91956);
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
                AppMethodBeat.m2505o(91956);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.m2505o(91956);
            }
        }
    }

    public C31930n() {
        AppMethodBeat.m2504i(91963);
        AppMethodBeat.m2505o(91963);
    }

    static {
        AppMethodBeat.m2504i(91974);
        Config[] configArr = new Config[]{Config.ARGB_8888, null};
        if (VERSION.SDK_INT >= 26) {
            configArr = (Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Config.RGBA_F16;
        }
        aCQ = configArr;
        aCR = configArr;
        AppMethodBeat.m2505o(91974);
    }

    /* renamed from: g */
    public final void mo2205g(Bitmap bitmap) {
        AppMethodBeat.m2504i(91964);
        C8516a c = this.aCV.mo18618c(C45002j.m82425k(bitmap), bitmap.getConfig());
        this.aCr.mo72259a(c, bitmap);
        NavigableMap b = m51869b(bitmap.getConfig());
        Integer num = (Integer) b.get(Integer.valueOf(c.size));
        b.put(Integer.valueOf(c.size), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
        AppMethodBeat.m2505o(91964);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public final Bitmap mo2203c(int i, int i2, Config config) {
        Config[] configArr;
        C31928m c;
        Bitmap bitmap;
        Object c2;
        int i3 = 0;
        AppMethodBeat.m2504i(91965);
        int j = C45002j.m82424j(i, i2, config);
        C8516a c3 = this.aCV.mo18618c(j, config);
        if (VERSION.SDK_INT < 26 || !Config.RGBA_F16.equals(config)) {
            switch (C319291.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
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
            Integer num = (Integer) m51869b(config2).ceilingKey(Integer.valueOf(j));
            if (num == null || num.intValue() > j * 8) {
                i3++;
            } else {
                if (num.intValue() != j || (config2 != null ? !config2.equals(config) : config != null)) {
                    this.aCV.mo59239a(c3);
                    c2 = this.aCV.mo18618c(num.intValue(), config2);
                    bitmap = (Bitmap) this.aCr.mo72260b(c2);
                    if (bitmap != null) {
                        m51868a(Integer.valueOf(c2.size), bitmap);
                        bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
                    }
                    AppMethodBeat.m2505o(91965);
                    return bitmap;
                }
                c2 = c3;
                bitmap = (Bitmap) this.aCr.mo72260b(c2);
                if (bitmap != null) {
                }
                AppMethodBeat.m2505o(91965);
                return bitmap;
            }
        }
        c2 = c3;
        bitmap = (Bitmap) this.aCr.mo72260b(c2);
        if (bitmap != null) {
        }
        AppMethodBeat.m2505o(91965);
        return bitmap;
    }

    /* renamed from: mP */
    public final Bitmap mo2208mP() {
        AppMethodBeat.m2504i(91966);
        Bitmap bitmap = (Bitmap) this.aCr.removeLast();
        if (bitmap != null) {
            m51868a(Integer.valueOf(C45002j.m82425k(bitmap)), bitmap);
        }
        AppMethodBeat.m2505o(91966);
        return bitmap;
    }

    /* renamed from: a */
    private void m51868a(Integer num, Bitmap bitmap) {
        AppMethodBeat.m2504i(91967);
        NavigableMap b = m51869b(bitmap.getConfig());
        Integer num2 = (Integer) b.get(num);
        if (num2 == null) {
            NullPointerException nullPointerException = new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + mo2206h(bitmap) + ", this: " + this);
            AppMethodBeat.m2505o(91967);
            throw nullPointerException;
        } else if (num2.intValue() == 1) {
            b.remove(num);
            AppMethodBeat.m2505o(91967);
        } else {
            b.put(num, Integer.valueOf(num2.intValue() - 1));
            AppMethodBeat.m2505o(91967);
        }
    }

    /* renamed from: b */
    private NavigableMap<Integer, Integer> m51869b(Config config) {
        AppMethodBeat.m2504i(91968);
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.aCC.get(config);
        if (navigableMap == null) {
            navigableMap = new TreeMap();
            this.aCC.put(config, navigableMap);
        }
        AppMethodBeat.m2505o(91968);
        return navigableMap;
    }

    /* renamed from: h */
    public final String mo2206h(Bitmap bitmap) {
        AppMethodBeat.m2504i(91969);
        String a = C31930n.m51867a(C45002j.m82425k(bitmap), bitmap.getConfig());
        AppMethodBeat.m2505o(91969);
        return a;
    }

    /* renamed from: d */
    public final String mo2204d(int i, int i2, Config config) {
        AppMethodBeat.m2504i(91970);
        String a = C31930n.m51867a(C45002j.m82424j(i, i2, config), config);
        AppMethodBeat.m2505o(91970);
        return a;
    }

    /* renamed from: i */
    public final int mo2207i(Bitmap bitmap) {
        AppMethodBeat.m2504i(91971);
        int k = C45002j.m82425k(bitmap);
        AppMethodBeat.m2505o(91971);
        return k;
    }

    public final String toString() {
        AppMethodBeat.m2504i(91972);
        StringBuilder append = new StringBuilder("SizeConfigStrategy{groupedMap=").append(this.aCr).append(", sortedSizes=(");
        for (Entry entry : this.aCC.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.aCC.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        String stringBuilder = append.append(")}").toString();
        AppMethodBeat.m2505o(91972);
        return stringBuilder;
    }

    /* renamed from: a */
    static String m51867a(int i, Config config) {
        AppMethodBeat.m2504i(91973);
        String str = "[" + i + "](" + config + ")";
        AppMethodBeat.m2505o(91973);
        return str;
    }
}
