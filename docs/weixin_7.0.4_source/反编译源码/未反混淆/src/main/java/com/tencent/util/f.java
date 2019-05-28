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

public class f {
    private static boolean AHY = false;
    private static boolean AHZ = false;
    private static boolean AIa = false;
    private static f AIb;
    private int AIc = 0;
    private Map<Long, Map<a, Queue<Integer>>> AId = new HashMap();
    private Map<Long, Map<Integer, a>> AIe = new HashMap();
    private Map<Long, Set<Integer>> AIf = new HashMap();
    private long AIg;
    private final String TAG = f.class.getSimpleName();

    public class a {
        public int height;
        public int width;

        a(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(86592);
            if (this == obj) {
                AppMethodBeat.o(86592);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(86592);
                return false;
            } else {
                a aVar = (a) obj;
                if (this.width != aVar.width) {
                    AppMethodBeat.o(86592);
                    return false;
                } else if (this.height == aVar.height) {
                    AppMethodBeat.o(86592);
                    return true;
                } else {
                    AppMethodBeat.o(86592);
                    return false;
                }
            }
        }

        public final int hashCode() {
            return (this.width * 31) + this.height;
        }
    }

    public f() {
        AppMethodBeat.i(86593);
        AppMethodBeat.o(86593);
    }

    public static f dSJ() {
        AppMethodBeat.i(86594);
        if (AIb == null) {
            synchronized (f.class) {
                try {
                    if (AIb == null) {
                        AIb = new f();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(86594);
                    }
                }
            }
        }
        f fVar = AIb;
        AppMethodBeat.o(86594);
        return fVar;
    }

    private synchronized int rt(boolean z) {
        int A;
        AppMethodBeat.i(86595);
        A = A(-1, -1, z);
        AppMethodBeat.o(86595);
        return A;
    }

    public final synchronized void F(int[] iArr) {
        AppMethodBeat.i(86596);
        c(iArr, false);
        AppMethodBeat.o(86596);
    }

    public final synchronized void c(int[] iArr, boolean z) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(86597);
            if (iArr == null) {
                AppMethodBeat.o(86597);
            } else {
                while (i < iArr.length && i + 0 <= 0) {
                    iArr[0] = rt(z);
                    i++;
                }
                AppMethodBeat.o(86597);
            }
        }
    }

    /* renamed from: if */
    public final synchronized int m17if(int i, int i2) {
        int A;
        AppMethodBeat.i(86598);
        A = A(i, i2, false);
        AppMethodBeat.o(86598);
        return A;
    }

    private synchronized int A(int i, int i2, boolean z) {
        int intValue;
        AppMethodBeat.i(86599);
        long id = Thread.currentThread().getId();
        String.format("genTexture(), GLThread id = %d, requestNew = " + z + ", width = %d, height = %d, called from: %s", new Object[]{Long.valueOf(id), Integer.valueOf(i), Integer.valueOf(i2), dSK()});
        if (AHY && !z) {
            Map map = (Map) this.AId.get(Long.valueOf(id));
            if (!(map == null || map.isEmpty())) {
                Queue queue = (Queue) map.get(new a(i, i2));
                if (queue == null || queue.isEmpty()) {
                    for (Entry value : map.entrySet()) {
                        Queue queue2 = (Queue) value.getValue();
                        if (!queue2.isEmpty()) {
                            String.format("genTexture(), GLThread id = %d, can't find texture width = %d and height = %d in cache, return another size", new Object[]{Long.valueOf(id), Integer.valueOf(i), Integer.valueOf(i2)});
                            dSL();
                            intValue = ((Integer) queue2.poll()).intValue();
                            AppMethodBeat.o(86599);
                            break;
                        }
                    }
                }
                String.format("genTexture(), GLThread id = %d, found texture width = %d and height = %d in cache", new Object[]{Long.valueOf(id), Integer.valueOf(i), Integer.valueOf(i2)});
                dSL();
                intValue = ((Integer) queue.poll()).intValue();
                AppMethodBeat.o(86599);
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
        AppMethodBeat.o(86599);
        return intValue;
    }

    public final synchronized void G(int[] iArr) {
        AppMethodBeat.i(86600);
        H(iArr);
        AppMethodBeat.o(86600);
    }

    private synchronized void H(int[] iArr) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(86601);
            if (iArr == null) {
                AppMethodBeat.o(86601);
            } else {
                while (i < iArr.length && i + 0 <= 0) {
                    Si(iArr[0]);
                    i++;
                }
                AppMethodBeat.o(86601);
            }
        }
    }

    public final synchronized void Sh(int i) {
        AppMethodBeat.i(86602);
        Si(i);
        AppMethodBeat.o(86602);
    }

    private synchronized void Si(int i) {
        AppMethodBeat.i(86603);
        long id = Thread.currentThread().getId();
        String.format("deleteTexture(), GLThread id = %d, textureId = %d, requestDelete = false, called from: %s", new Object[]{Long.valueOf(id), Integer.valueOf(i), dSK()});
        if (i == 0) {
            String.format("deleteTexture(), GLThread id = %d, textureId == 0, return", new Object[]{Long.valueOf(id)});
            AppMethodBeat.o(86603);
        } else {
            Map map;
            if (AHY) {
                if (!this.AId.containsKey(Long.valueOf(id))) {
                    this.AId.put(Long.valueOf(id), new HashMap());
                }
                map = (Map) this.AId.get(Long.valueOf(id));
                Object Sj = Sj(i);
                if (Sj == null) {
                    Sj = new a(-1, -1);
                }
                if (!map.containsKey(Sj)) {
                    map.put(Sj, new LinkedList());
                }
                ((Queue) map.get(Sj)).offer(Integer.valueOf(i));
                String.format("deleteTexture(), GLThread id = %d, recycle texture width = %d, height = %d into cache, getCallFrom = %s", new Object[]{Long.valueOf(id), Integer.valueOf(Sj.width), Integer.valueOf(Sj.height), dSK()});
            } else {
                String.format("deleteTexture(), GLThread id = %d, delete texture id = %d, getCallFrom = %s", new Object[]{Long.valueOf(id), Integer.valueOf(i), dSK()});
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
            AppMethodBeat.o(86603);
        }
    }

    public final synchronized boolean aI(int i, int i2, int i3) {
        boolean z;
        AppMethodBeat.i(86604);
        if (AHY) {
            long id = Thread.currentThread().getId();
            if (this.AIe.containsKey(Long.valueOf(id))) {
                a aVar = (a) ((Map) this.AIe.get(Long.valueOf(id))).get(Integer.valueOf(i));
                if (aVar != null && aVar.width == i2 && aVar.height == i3) {
                    z = true;
                    AppMethodBeat.o(86604);
                } else {
                    AppMethodBeat.o(86604);
                    z = false;
                }
            }
        }
        AppMethodBeat.o(86604);
        z = false;
        return z;
    }

    public final synchronized void aJ(int i, int i2, int i3) {
        AppMethodBeat.i(86605);
        if (AHY) {
            long id = Thread.currentThread().getId();
            String.format("updateTextureSize(), GLThread id = %d, textureId = %d, width = %d, height = %d, called from: %s", new Object[]{Long.valueOf(id), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), dSK()});
            if (!this.AIe.containsKey(Long.valueOf(id))) {
                this.AIe.put(Long.valueOf(id), new HashMap());
            }
            ((Map) this.AIe.get(Long.valueOf(id))).put(Integer.valueOf(i), new a(i2, i3));
        }
        AppMethodBeat.o(86605);
    }

    private synchronized a Sj(int i) {
        a aVar;
        AppMethodBeat.i(86606);
        if (AHY) {
            Map map = (Map) this.AIe.get(Long.valueOf(Thread.currentThread().getId()));
            if (map != null) {
                aVar = (a) map.get(Integer.valueOf(i));
                AppMethodBeat.o(86606);
            }
        }
        aVar = null;
        AppMethodBeat.o(86606);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String dSK() {
        String str;
        AppMethodBeat.i(86607);
        if (AIa) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null || stackTrace.length == 0) {
                str = "unknown";
                AppMethodBeat.o(86607);
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
                        AppMethodBeat.o(86607);
                        return str;
                    }
                }
                i++;
            }
            if (i < stackTrace.length) {
            }
        }
        str = "unknown";
        AppMethodBeat.o(86607);
        return str;
    }

    private void dSL() {
        AppMethodBeat.i(86608);
        if (AHZ) {
            String.format("texture reference count = %d", new Object[]{Integer.valueOf(this.AIc)});
        }
        AppMethodBeat.o(86608);
    }

    public final synchronized void ig(int i, int i2) {
        this.AIg += (long) ((i * i2) * 4);
    }

    public final synchronized void ih(int i, int i2) {
        this.AIg -= (long) ((i * i2) * 4);
    }
}
