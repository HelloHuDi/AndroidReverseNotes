package com.tencent.util;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/* renamed from: com.tencent.util.f */
public class C36572f {
    private static boolean AHY = false;
    private static boolean AHZ = false;
    private static boolean AIa = false;
    private static C36572f AIb;
    private int AIc = 0;
    private Map<Long, Map<C36571a, Queue<Integer>>> AId = new HashMap();
    private Map<Long, Map<Integer, C36571a>> AIe = new HashMap();
    private Map<Long, Set<Integer>> AIf = new HashMap();
    private long AIg;
    private final String TAG = C36572f.class.getSimpleName();

    /* renamed from: com.tencent.util.f$a */
    public class C36571a {
        public int height;
        public int width;

        C36571a(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(86592);
            if (this == obj) {
                AppMethodBeat.m2505o(86592);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.m2505o(86592);
                return false;
            } else {
                C36571a c36571a = (C36571a) obj;
                if (this.width != c36571a.width) {
                    AppMethodBeat.m2505o(86592);
                    return false;
                } else if (this.height == c36571a.height) {
                    AppMethodBeat.m2505o(86592);
                    return true;
                } else {
                    AppMethodBeat.m2505o(86592);
                    return false;
                }
            }
        }

        public final int hashCode() {
            return (this.width * 31) + this.height;
        }
    }

    public C36572f() {
        AppMethodBeat.m2504i(86593);
        AppMethodBeat.m2505o(86593);
    }

    public static C36572f dSJ() {
        AppMethodBeat.m2504i(86594);
        if (AIb == null) {
            synchronized (C36572f.class) {
                try {
                    if (AIb == null) {
                        AIb = new C36572f();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(86594);
                    }
                }
            }
        }
        C36572f c36572f = AIb;
        AppMethodBeat.m2505o(86594);
        return c36572f;
    }

    /* renamed from: rt */
    private synchronized int m60602rt(boolean z) {
        int A;
        AppMethodBeat.m2504i(86595);
        A = m60598A(-1, -1, z);
        AppMethodBeat.m2505o(86595);
        return A;
    }

    /* renamed from: F */
    public final synchronized void mo58338F(int[] iArr) {
        AppMethodBeat.m2504i(86596);
        mo58343c(iArr, false);
        AppMethodBeat.m2505o(86596);
    }

    /* renamed from: c */
    public final synchronized void mo58343c(int[] iArr, boolean z) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(86597);
            if (iArr == null) {
                AppMethodBeat.m2505o(86597);
            } else {
                while (i < iArr.length && i + 0 <= 0) {
                    iArr[0] = m60602rt(z);
                    i++;
                }
                AppMethodBeat.m2505o(86597);
            }
        }
    }

    /* renamed from: if */
    public final synchronized int mo58344if(int i, int i2) {
        int A;
        AppMethodBeat.m2504i(86598);
        A = m60598A(i, i2, false);
        AppMethodBeat.m2505o(86598);
        return A;
    }

    /* renamed from: A */
    private synchronized int m60598A(int i, int i2, boolean z) {
        int intValue;
        AppMethodBeat.m2504i(86599);
        long id = Thread.currentThread().getId();
        String.format("genTexture(), GLThread id = %d, requestNew = " + z + ", width = %d, height = %d, called from: %s", new Object[]{Long.valueOf(id), Integer.valueOf(i), Integer.valueOf(i2), C36572f.dSK()});
        if (AHY && !z) {
            Map map = (Map) this.AId.get(Long.valueOf(id));
            if (!(map == null || map.isEmpty())) {
                Queue queue = (Queue) map.get(new C36571a(i, i2));
                if (queue == null || queue.isEmpty()) {
                    for (Entry value : map.entrySet()) {
                        Queue queue2 = (Queue) value.getValue();
                        if (!queue2.isEmpty()) {
                            String.format("genTexture(), GLThread id = %d, can't find texture width = %d and height = %d in cache, return another size", new Object[]{Long.valueOf(id), Integer.valueOf(i), Integer.valueOf(i2)});
                            dSL();
                            intValue = ((Integer) queue2.poll()).intValue();
                            AppMethodBeat.m2505o(86599);
                            break;
                        }
                    }
                }
                String.format("genTexture(), GLThread id = %d, found texture width = %d and height = %d in cache", new Object[]{Long.valueOf(id), Integer.valueOf(i), Integer.valueOf(i2)});
                dSL();
                intValue = ((Integer) queue.poll()).intValue();
                AppMethodBeat.m2505o(86599);
            }
        }
        String.format("genTexture(), GLThread id = %d, width = %d and height = %d, cache is empty, alloc a new texture", new Object[]{Long.valueOf(id), Integer.valueOf(i), Integer.valueOf(i2)});
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (!this.AIf.containsKey(Long.valueOf(id))) {
            this.AIf.put(Long.valueOf(id), new HashSet());
        }
        ((Set) this.AIf.get(Long.valueOf(id))).add(Integer.valueOf(iArr[0]));
        this.AIc++;
        dSL();
        intValue = iArr[0];
        AppMethodBeat.m2505o(86599);
        return intValue;
    }

    /* renamed from: G */
    public final synchronized void mo58339G(int[] iArr) {
        AppMethodBeat.m2504i(86600);
        m60599H(iArr);
        AppMethodBeat.m2505o(86600);
    }

    /* renamed from: H */
    private synchronized void m60599H(int[] iArr) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(86601);
            if (iArr == null) {
                AppMethodBeat.m2505o(86601);
            } else {
                while (i < iArr.length && i + 0 <= 0) {
                    m60600Si(iArr[0]);
                    i++;
                }
                AppMethodBeat.m2505o(86601);
            }
        }
    }

    /* renamed from: Sh */
    public final synchronized void mo58340Sh(int i) {
        AppMethodBeat.m2504i(86602);
        m60600Si(i);
        AppMethodBeat.m2505o(86602);
    }

    /* renamed from: Si */
    private synchronized void m60600Si(int i) {
        AppMethodBeat.m2504i(86603);
        long id = Thread.currentThread().getId();
        String.format("deleteTexture(), GLThread id = %d, textureId = %d, requestDelete = false, called from: %s", new Object[]{Long.valueOf(id), Integer.valueOf(i), C36572f.dSK()});
        if (i == 0) {
            String.format("deleteTexture(), GLThread id = %d, textureId == 0, return", new Object[]{Long.valueOf(id)});
            AppMethodBeat.m2505o(86603);
        } else {
            Map map;
            if (AHY) {
                if (!this.AId.containsKey(Long.valueOf(id))) {
                    this.AId.put(Long.valueOf(id), new HashMap());
                }
                map = (Map) this.AId.get(Long.valueOf(id));
                Object Sj = m60601Sj(i);
                if (Sj == null) {
                    Sj = new C36571a(-1, -1);
                }
                if (!map.containsKey(Sj)) {
                    map.put(Sj, new LinkedList());
                }
                ((Queue) map.get(Sj)).offer(Integer.valueOf(i));
                String.format("deleteTexture(), GLThread id = %d, recycle texture width = %d, height = %d into cache, getCallFrom = %s", new Object[]{Long.valueOf(id), Integer.valueOf(Sj.width), Integer.valueOf(Sj.height), C36572f.dSK()});
            } else {
                String.format("deleteTexture(), GLThread id = %d, delete texture id = %d, getCallFrom = %s", new Object[]{Long.valueOf(id), Integer.valueOf(i), C36572f.dSK()});
                GLES20.glDeleteTextures(1, new int[]{i}, 0);
                Set set = (Set) this.AIf.get(Long.valueOf(id));
                if (set != null) {
                    set.remove(Integer.valueOf(i));
                }
                this.AIc--;
                if (AHY) {
                    map = (Map) this.AIe.get(Long.valueOf(id));
                    if (map != null) {
                        map.remove(Integer.valueOf(i));
                    }
                }
            }
            dSL();
            AppMethodBeat.m2505o(86603);
        }
    }

    /* renamed from: aI */
    public final synchronized boolean mo58341aI(int i, int i2, int i3) {
        boolean z;
        AppMethodBeat.m2504i(86604);
        if (AHY) {
            long id = Thread.currentThread().getId();
            if (this.AIe.containsKey(Long.valueOf(id))) {
                C36571a c36571a = (C36571a) ((Map) this.AIe.get(Long.valueOf(id))).get(Integer.valueOf(i));
                if (c36571a != null && c36571a.width == i2 && c36571a.height == i3) {
                    z = true;
                    AppMethodBeat.m2505o(86604);
                } else {
                    AppMethodBeat.m2505o(86604);
                    z = false;
                }
            }
        }
        AppMethodBeat.m2505o(86604);
        z = false;
        return z;
    }

    /* renamed from: aJ */
    public final synchronized void mo58342aJ(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86605);
        if (AHY) {
            long id = Thread.currentThread().getId();
            String.format("updateTextureSize(), GLThread id = %d, textureId = %d, width = %d, height = %d, called from: %s", new Object[]{Long.valueOf(id), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), C36572f.dSK()});
            if (!this.AIe.containsKey(Long.valueOf(id))) {
                this.AIe.put(Long.valueOf(id), new HashMap());
            }
            ((Map) this.AIe.get(Long.valueOf(id))).put(Integer.valueOf(i), new C36571a(i2, i3));
        }
        AppMethodBeat.m2505o(86605);
    }

    /* renamed from: Sj */
    private synchronized C36571a m60601Sj(int i) {
        C36571a c36571a;
        AppMethodBeat.m2504i(86606);
        if (AHY) {
            Map map = (Map) this.AIe.get(Long.valueOf(Thread.currentThread().getId()));
            if (map != null) {
                c36571a = (C36571a) map.get(Integer.valueOf(i));
                AppMethodBeat.m2505o(86606);
            }
        }
        c36571a = null;
        AppMethodBeat.m2505o(86606);
        return c36571a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String dSK() {
        String str;
        AppMethodBeat.m2504i(86607);
        if (AIa) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null || stackTrace.length == 0) {
                str = "unknown";
                AppMethodBeat.m2505o(86607);
                return str;
            }
            int i = 0;
            while (i < stackTrace.length) {
                if (stackTrace[i].getMethodName().equals("getCallFrom")) {
                    while (i < stackTrace.length && stackTrace[i].getClassName().contains("GLMemoryManager")) {
                        i++;
                    }
                    if (i < stackTrace.length) {
                        StackTraceElement stackTraceElement = stackTrace[i];
                        str = stackTraceElement.getClassName() + " - " + stackTraceElement.getMethodName() + "()";
                        AppMethodBeat.m2505o(86607);
                        return str;
                    }
                }
                i++;
            }
            if (i < stackTrace.length) {
            }
        }
        str = "unknown";
        AppMethodBeat.m2505o(86607);
        return str;
    }

    private void dSL() {
        AppMethodBeat.m2504i(86608);
        if (AHZ) {
            String.format("texture reference count = %d", new Object[]{Integer.valueOf(this.AIc)});
        }
        AppMethodBeat.m2505o(86608);
    }

    /* renamed from: ig */
    public final synchronized void mo58345ig(int i, int i2) {
        this.AIg += (long) ((i * i2) * 4);
    }

    /* renamed from: ih */
    public final synchronized void mo58346ih(int i, int i2) {
        this.AIg -= (long) ((i * i2) * 4);
    }
}
