package com.google.android.exoplayer2.p111i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.i.p */
public final class C8687p {
    public static final Comparator<C8688a> brA = new C86892();
    public static final Comparator<C8688a> brz = new C86901();
    public final int brB = 2000;
    public final ArrayList<C8688a> brC = new ArrayList();
    public final C8688a[] brD = new C8688a[5];
    public int brE = -1;
    public int brF;
    public int brG;
    public int brH;

    /* renamed from: com.google.android.exoplayer2.i.p$a */
    public static class C8688a {
        public int index;
        public float value;
        public int weight;

        private C8688a() {
        }

        public /* synthetic */ C8688a(byte b) {
            this();
        }
    }

    /* renamed from: com.google.android.exoplayer2.i.p$2 */
    static class C86892 implements Comparator<C8688a> {
        C86892() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C8688a c8688a = (C8688a) obj;
            C8688a c8688a2 = (C8688a) obj2;
            if (c8688a.value < c8688a2.value) {
                return -1;
            }
            return c8688a2.value < c8688a.value ? 1 : 0;
        }
    }

    /* renamed from: com.google.android.exoplayer2.i.p$1 */
    static class C86901 implements Comparator<C8688a> {
        C86901() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C8688a) obj).index - ((C8688a) obj2).index;
        }
    }

    static {
        AppMethodBeat.m2504i(95933);
        AppMethodBeat.m2505o(95933);
    }

    public C8687p() {
        AppMethodBeat.m2504i(95932);
        AppMethodBeat.m2505o(95932);
    }
}
