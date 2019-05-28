package com.tencent.p177mm.p612ui.chatting.p617f;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.p622l.C30549e;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.f.d */
public interface C40748d {

    /* renamed from: com.tencent.mm.ui.chatting.f.d$a */
    public enum C40749a {
        ACTION_TOP,
        ACTION_BOTTOM,
        ACTION_UPDATE,
        ACTION_ENTER,
        ACTION_POSITION,
        ACTION_UN_KNOW;

        static {
            AppMethodBeat.m2505o(32482);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.f.d$b */
    public interface C40750b {
        /* renamed from: dY */
        void mo15847dY();
    }

    /* renamed from: com.tencent.mm.ui.chatting.f.d$c */
    public interface C40751c<T> {
        /* renamed from: b */
        C30549e mo31090b(C40752d<T> c40752d);

        /* renamed from: c */
        void mo31091c(C40752d<T> c40752d);
    }

    /* renamed from: com.tencent.mm.ui.chatting.f.d$d */
    public static class C40752d<T> {
        public int enb;
        public int selection = -1;
        public C40749a yYA;
        public List<T> yYB;
        public int yYC;
        public SparseArray<T> yYD;
        public Bundle yYz;

        C40752d(C40749a c40749a) {
            AppMethodBeat.m2504i(32483);
            this.yYA = c40749a;
            this.yYB = new LinkedList();
            AppMethodBeat.m2505o(32483);
        }

        public final String toString() {
            AppMethodBeat.m2504i(32484);
            String str = "LoadedResult{sourceArgs=" + this.yYz + ", mode=" + this.yYA + ", selection=" + this.selection + ", count=" + this.yYC + ", totalCount=" + this.enb + '}';
            AppMethodBeat.m2505o(32484);
            return str;
        }
    }

    /* renamed from: a */
    void mo57055a(C40749a c40749a, boolean z, C40751c c40751c);

    void cancel();
}
