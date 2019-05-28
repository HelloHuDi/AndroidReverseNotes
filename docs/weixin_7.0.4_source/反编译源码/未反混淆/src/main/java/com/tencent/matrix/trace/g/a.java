package com.tencent.matrix.trace.g;

import com.tencent.matrix.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class a {

    public interface a {
        boolean c(long j, int i);

        void e(List<com.tencent.matrix.trace.d.a> list, int i);
    }

    public static void a(long[] jArr, LinkedList<com.tencent.matrix.trace.d.a> linkedList, boolean z, long j) {
        long j2 = 0;
        int i = 0;
        LinkedList linkedList2 = new LinkedList();
        Object obj = !z ? 1 : null;
        for (long j3 : jArr) {
            Object obj2;
            long j4;
            if (0 != j3) {
                if (z) {
                    if (aE(j3) && AppMethodBeat.METHOD_ID_DISPATCH == aF(j3)) {
                        obj = 1;
                    }
                    if (obj == null) {
                        c.d("Matrix.TraceDataUtils", "never begin! pass this method[%s]", Integer.valueOf(aF(j3)));
                        obj2 = obj;
                        j4 = j2;
                    }
                }
                obj2 = obj;
                int i2;
                if (aE(j3)) {
                    j4 = (long) aF(j3);
                    if (j4 == 1048574) {
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    linkedList2.push(Long.valueOf(j3));
                } else {
                    int aF = aF(j3);
                    if (linkedList2.isEmpty()) {
                        c.w("Matrix.TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", Integer.valueOf(aF));
                        j4 = j2;
                    } else {
                        int i3;
                        i2 = i - 1;
                        long longValue = ((Long) linkedList2.pop()).longValue();
                        while (true) {
                            i3 = i2;
                            if (aF(longValue) != aF && !linkedList2.isEmpty()) {
                                c.w("Matrix.TraceDataUtils", "[structuredDataToStack] method[%s] not match in! pop[%s] to continue find!", Long.valueOf(longValue), Integer.valueOf(aF));
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
                                c.e("Matrix.TraceDataUtils", "[structuredDataToStack] trace during invalid:%d", Long.valueOf(longValue));
                                linkedList2.clear();
                                linkedList.clear();
                                return;
                            }
                            a((LinkedList) linkedList, new com.tencent.matrix.trace.d.a(aF, (int) longValue, i3));
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
            i = aF(longValue2);
            boolean aE = aE(longValue2);
            longValue2 = (longValue2 & 8796093022207L) + AppMethodBeat.getDiffTime();
            c.w("Matrix.TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, rawData size:%s", Integer.valueOf(i), Boolean.valueOf(aE), Integer.valueOf(linkedList2.size()));
            if (aE) {
                a((LinkedList) linkedList, new com.tencent.matrix.trace.d.a(i, (int) (j - longValue2), linkedList2.size()));
            } else {
                c.e("Matrix.TraceDataUtils", "[structuredDataToStack] why has out Method[%s]? is wrong! ", Integer.valueOf(i));
            }
        }
        LinkedList linkedList3 = new LinkedList();
        com.tencent.matrix.trace.d.a aVar = null;
        Iterator it = linkedList.iterator();
        while (true) {
            com.tencent.matrix.trace.d.a aVar2 = aVar;
            if (it.hasNext()) {
                aVar = (com.tencent.matrix.trace.d.a) it.next();
                if (aVar2 != null) {
                    int indexOf = linkedList3.indexOf(aVar2);
                    if (aVar2.bna == aVar.bna) {
                        linkedList3.add(indexOf, aVar);
                    } else {
                        linkedList3.add(indexOf + 1, aVar);
                    }
                } else {
                    linkedList3.add(aVar);
                }
            } else {
                linkedList.clear();
                linkedList.addAll(linkedList3);
                return;
            }
        }
    }

    private static boolean aE(long j) {
        return ((j >> 63) & 1) == 1;
    }

    private static int aF(long j) {
        return (int) ((j >> 43) & 1048575);
    }

    private static int a(LinkedList<com.tencent.matrix.trace.d.a> linkedList, com.tencent.matrix.trace.d.a aVar) {
        com.tencent.matrix.trace.d.a aVar2;
        if (linkedList.isEmpty()) {
            aVar2 = null;
        } else {
            aVar2 = (com.tencent.matrix.trace.d.a) linkedList.peek();
        }
        if (aVar2 == null || aVar2.bZt != aVar.bZt || aVar2.bna != aVar.bna || aVar.bna == 0) {
            linkedList.push(aVar);
            return aVar.bZu;
        }
        aVar.bZu = aVar.bZu == 5000 ? aVar2.bZu : aVar.bZu;
        aVar2.aD((long) aVar.bZu);
        return aVar2.bZu;
    }

    public static long a(LinkedList<com.tencent.matrix.trace.d.a> linkedList, StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        stringBuilder2.append("|*   TraceStack:\n");
        stringBuilder2.append("|*        [id count cost]\n");
        Iterator it = linkedList.iterator();
        long j = 0;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            com.tencent.matrix.trace.d.a aVar = (com.tencent.matrix.trace.d.a) it.next();
            stringBuilder.append(aVar.toString()).append(10);
            StringBuilder append = stringBuilder2.append("|*        ");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < aVar.bna; i++) {
                stringBuffer.append('.');
            }
            append.append(stringBuffer.toString() + aVar.bZt + " " + aVar.count + " " + aVar.bZu).append(10);
            if (j2 < ((long) aVar.bZu)) {
                j = (long) aVar.bZu;
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
    public static void a(List<com.tencent.matrix.trace.d.a> list, a aVar) {
        int size = list.size();
        int i = 1;
        while (size > 30) {
            ListIterator listIterator = list.listIterator(list.size());
            while (true) {
                int i2 = size;
                if (!listIterator.hasPrevious()) {
                    break;
                } else if (aVar.c((long) ((com.tencent.matrix.trace.d.a) listIterator.previous()).bZu, i)) {
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
            aVar.e(list, size);
        }
    }

    public static String a(List<com.tencent.matrix.trace.d.a> list, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        long j2 = (long) (((float) j) * 0.3f);
        LinkedList linkedList = new LinkedList();
        for (com.tencent.matrix.trace.d.a aVar : list) {
            if (((long) aVar.bZu) >= j2) {
                linkedList.add(aVar);
            }
        }
        Collections.sort(linkedList, new Comparator<com.tencent.matrix.trace.d.a>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                com.tencent.matrix.trace.d.a aVar = (com.tencent.matrix.trace.d.a) obj;
                com.tencent.matrix.trace.d.a aVar2 = (com.tencent.matrix.trace.d.a) obj2;
                return Long.compare((long) ((aVar2.bna + 1) * aVar2.bZu), (long) ((aVar.bna + 1) * aVar.bZu));
            }
        });
        List list2;
        if (linkedList.isEmpty() && !list.isEmpty()) {
            linkedList.add(list.get(0));
            list2 = linkedList;
        } else if (linkedList.isEmpty()) {
            Object list22 = linkedList;
        } else {
            list22 = linkedList.subList(0, 1);
        }
        for (com.tencent.matrix.trace.d.a aVar2 : list22) {
            stringBuilder.append(aVar2.bZt + "|");
        }
        return stringBuilder.toString();
    }
}
