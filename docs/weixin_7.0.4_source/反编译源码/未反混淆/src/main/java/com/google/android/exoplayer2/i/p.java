package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;

public final class p {
    public static final Comparator<a> brA = new Comparator<a>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar.value < aVar2.value) {
                return -1;
            }
            return aVar2.value < aVar.value ? 1 : 0;
        }
    };
    public static final Comparator<a> brz = new Comparator<a>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((a) obj).index - ((a) obj2).index;
        }
    };
    public final int brB = 2000;
    public final ArrayList<a> brC = new ArrayList();
    public final a[] brD = new a[5];
    public int brE = -1;
    public int brF;
    public int brG;
    public int brH;

    public static class a {
        public int index;
        public float value;
        public int weight;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(95933);
        AppMethodBeat.o(95933);
    }

    public p() {
        AppMethodBeat.i(95932);
        AppMethodBeat.o(95932);
    }
}
