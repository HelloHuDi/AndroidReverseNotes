package com.tencent.mm.ui.chatting.f;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.l.e;
import java.util.LinkedList;
import java.util.List;

public interface d {

    public enum a {
        ACTION_TOP,
        ACTION_BOTTOM,
        ACTION_UPDATE,
        ACTION_ENTER,
        ACTION_POSITION,
        ACTION_UN_KNOW;

        static {
            AppMethodBeat.o(32482);
        }
    }

    public interface b {
        void dY();
    }

    public interface c<T> {
        e b(d<T> dVar);

        void c(d<T> dVar);
    }

    public static class d<T> {
        public int enb;
        public int selection = -1;
        public a yYA;
        public List<T> yYB;
        public int yYC;
        public SparseArray<T> yYD;
        public Bundle yYz;

        d(a aVar) {
            AppMethodBeat.i(32483);
            this.yYA = aVar;
            this.yYB = new LinkedList();
            AppMethodBeat.o(32483);
        }

        public final String toString() {
            AppMethodBeat.i(32484);
            String str = "LoadedResult{sourceArgs=" + this.yYz + ", mode=" + this.yYA + ", selection=" + this.selection + ", count=" + this.yYC + ", totalCount=" + this.enb + '}';
            AppMethodBeat.o(32484);
            return str;
        }
    }

    void a(a aVar, boolean z, c cVar);

    void cancel();
}
