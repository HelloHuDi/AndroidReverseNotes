package com.tencent.matrix.trace.p176g;

import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.p173d.C1151a;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.tencent.matrix.trace.g.a */
public final class C1166a {

    /* renamed from: com.tencent.matrix.trace.g.a$1 */
    static class C11641 implements Comparator<C1151a> {
        C11641() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C1151a c1151a = (C1151a) obj;
            C1151a c1151a2 = (C1151a) obj2;
            return Long.compare((long) ((c1151a2.bna + 1) * c1151a2.bZu), (long) ((c1151a.bna + 1) * c1151a.bZu));
        }
    }

    /* renamed from: com.tencent.matrix.trace.g.a$a */
    public interface C1165a {
        /* renamed from: c */
        boolean mo4391c(long j, int i);

        /* renamed from: e */
        void mo4392e(List<C1151a> list, int i);
    }

    /* renamed from: a */
    public static void m2541a(long[] jArr, LinkedList<C1151a> linkedList, boolean z, long j) {
        long j2 = 0;
        int i = 0;
        LinkedList linkedList2 = new LinkedList();
        Object obj = !z ? 1 : null;
        for (long j3 : jArr) {
            Object obj2;
            long j4;
            if (0 != j3) {
                if (z) {
                    if (C1166a.m2542aE(j3) && AppMethodBeat.METHOD_ID_DISPATCH == C1166a.m2543aF(j3)) {
                        obj = 1;
                    }
                    if (obj == null) {
                        C1070c.m2366d("Matrix.TraceDataUtils", "never begin! pass this method[%s]", Integer.valueOf(C1166a.m2543aF(j3)));
                        obj2 = obj;
                        j4 = j2;
                    }
                }
                obj2 = obj;
                int i2;
                if (C1166a.m2542aE(j3)) {
                    j4 = (long) C1166a.m2543aF(j3);
                    if (j4 == 1048574) {
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    linkedList2.push(Long.valueOf(j3));
                } else {
                    int aF = C1166a.m2543aF(j3);
                    if (linkedList2.isEmpty()) {
                        C1070c.m2370w("Matrix.TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", Integer.valueOf(aF));
                        j4 = j2;
                    } else {
                        int i3;
                        i2 = i - 1;
                        long longValue = ((Long) linkedList2.pop()).longValue();
                        while (true) {
                            i3 = i2;
                            if (C1166a.m2543aF(longValue) != aF && !linkedList2.isEmpty()) {
                                C1070c.m2370w("Matrix.TraceDataUtils", "[structuredDataToStack] method[%s] not match in! pop[%s] to continue find!", Long.valueOf(longValue), Integer.valueOf(aF));
                                longValue = ((Long) linkedList2.pop()).longValue();
                                i2 = i3 - 1;
                            }
                        }
                        if (j2 == ((long) aF) && aF == 1048574) {
                            i = i3;
                            j4 = j2;
                        } else {
                            longValue = (8796093022207L & j3) - (longValue & 8796093022207L);
                            if (longValue < 0) {
                                C1070c.m2367e("Matrix.TraceDataUtils", "[structuredDataToStack] trace during invalid:%d", Long.valueOf(longValue));
                                linkedList2.clear();
                                linkedList.clear();
                                return;
                            }
                            C1166a.m2537a((LinkedList) linkedList, new C1151a(aF, (int) longValue, i3));
                            i = i3;
                            j4 = j2;
                        }
                    }
                }
            } else {
                obj2 = obj;
                j4 = j2;
            }
            obj = obj2;
            j2 = j4;
        }
        while (!linkedList2.isEmpty() && z) {
            long longValue2 = ((Long) linkedList2.pop()).longValue();
            i = C1166a.m2543aF(longValue2);
            boolean aE = C1166a.m2542aE(longValue2);
            longValue2 = (longValue2 & 8796093022207L) + AppMethodBeat.getDiffTime();
            C1070c.m2370w("Matrix.TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, rawData size:%s", Integer.valueOf(i), Boolean.valueOf(aE), Integer.valueOf(linkedList2.size()));
            if (aE) {
                C1166a.m2537a((LinkedList) linkedList, new C1151a(i, (int) (j - longValue2), linkedList2.size()));
            } else {
                C1070c.m2367e("Matrix.TraceDataUtils", "[structuredDataToStack] why has out Method[%s]? is wrong! ", Integer.valueOf(i));
            }
        }
        LinkedList linkedList3 = new LinkedList();
        C1151a c1151a = null;
        Iterator it = linkedList.iterator();
        while (true) {
            C1151a c1151a2 = c1151a;
            if (it.hasNext()) {
                c1151a = (C1151a) it.next();
                if (c1151a2 != null) {
                    int indexOf = linkedList3.indexOf(c1151a2);
                    if (c1151a2.bna == c1151a.bna) {
                        linkedList3.add(indexOf, c1151a);
                    } else {
                        linkedList3.add(indexOf + 1, c1151a);
                    }
                } else {
                    linkedList3.add(c1151a);
                }
            } else {
                linkedList.clear();
                linkedList.addAll(linkedList3);
                return;
            }
        }
    }

    /* renamed from: aE */
    private static boolean m2542aE(long j) {
        return ((j >> 63) & 1) == 1;
    }

    /* renamed from: aF */
    private static int m2543aF(long j) {
        return (int) ((j >> 43) & 1048575);
    }

    /* renamed from: a */
    private static int m2537a(LinkedList<C1151a> linkedList, C1151a c1151a) {
        C1151a c1151a2;
        if (linkedList.isEmpty()) {
            c1151a2 = null;
        } else {
            c1151a2 = (C1151a) linkedList.peek();
        }
        if (c1151a2 == null || c1151a2.bZt != c1151a.bZt || c1151a2.bna != c1151a.bna || c1151a.bna == 0) {
            linkedList.push(c1151a);
            return c1151a.bZu;
        }
        c1151a.bZu = c1151a.bZu == 5000 ? c1151a2.bZu : c1151a.bZu;
        c1151a2.mo4383aD((long) c1151a.bZu);
        return c1151a2.bZu;
    }

    /* renamed from: a */
    public static long m2538a(LinkedList<C1151a> linkedList, StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        stringBuilder2.append("|*   TraceStack:\n");
        stringBuilder2.append("|*        [id count cost]\n");
        Iterator it = linkedList.iterator();
        long j = 0;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            C1151a c1151a = (C1151a) it.next();
            stringBuilder.append(c1151a.toString()).append(10);
            StringBuilder append = stringBuilder2.append("|*        ");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < c1151a.bna; i++) {
                stringBuffer.append('.');
            }
            append.append(stringBuffer.toString() + c1151a.bZt + " " + c1151a.count + " " + c1151a.bZu).append(10);
            if (j2 < ((long) c1151a.bZu)) {
                j = (long) c1151a.bZu;
            } else {
                j = j2;
            }
        }
    }

    /* JADX WARNING: Missing block: B:11:0x0033, code skipped:
            r0 = r7.size();
            r1 = r2 + 1;
     */
    /* JADX WARNING: Missing block: B:12:0x003b, code skipped:
            if (60 >= r1) goto L_0x0047;
     */
    /* JADX WARNING: Missing block: B:16:0x0047, code skipped:
            r2 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m2540a(List<C1151a> list, C1165a c1165a) {
        int size = list.size();
        int i = 1;
        while (size > 30) {
            ListIterator listIterator = list.listIterator(list.size());
            while (true) {
                int i2 = size;
                if (!listIterator.hasPrevious()) {
                    break;
                } else if (c1165a.mo4391c((long) ((C1151a) listIterator.previous()).bZu, i)) {
                    listIterator.remove();
                    size = i2 - 1;
                    if (size <= 30) {
                        return;
                    }
                } else {
                    size = i2;
                }
            }
        }
        size = list.size();
        if (size > 30) {
            c1165a.mo4392e(list, size);
        }
    }

    /* renamed from: a */
    public static String m2539a(List<C1151a> list, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        long j2 = (long) (((float) j) * 0.3f);
        LinkedList linkedList = new LinkedList();
        for (C1151a c1151a : list) {
            if (((long) c1151a.bZu) >= j2) {
                linkedList.add(c1151a);
            }
        }
        Collections.sort(linkedList, new C11641());
        List list2;
        if (linkedList.isEmpty() && !list.isEmpty()) {
            linkedList.add(list.get(0));
            list2 = linkedList;
        } else if (linkedList.isEmpty()) {
            Object list22 = linkedList;
        } else {
            list22 = linkedList.subList(0, 1);
        }
        for (C1151a c1151a2 : list22) {
            stringBuilder.append(c1151a2.bZt + "|");
        }
        return stringBuilder.toString();
    }
}
