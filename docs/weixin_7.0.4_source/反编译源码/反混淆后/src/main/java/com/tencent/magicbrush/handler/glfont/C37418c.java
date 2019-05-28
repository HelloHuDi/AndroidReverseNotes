package com.tencent.magicbrush.handler.glfont;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.magicbrush.handler.glfont.c */
interface C37418c {

    /* renamed from: com.tencent.magicbrush.handler.glfont.c$c */
    public static class C25715c {
        public int height;
        public int width;
        /* renamed from: x */
        public int f5424x;
        /* renamed from: y */
        public int f5425y;

        public final String toString() {
            AppMethodBeat.m2504i(115910);
            String str = "[" + this.f5424x + ", " + this.f5425y + ", " + this.width + ", " + this.height + "]";
            AppMethodBeat.m2505o(115910);
            return str;
        }
    }

    /* renamed from: com.tencent.magicbrush.handler.glfont.c$a */
    public static class C37419a {
        public Queue<C37420b> aDb = new LinkedList();

        public C37419a() {
            AppMethodBeat.m2504i(115905);
            AppMethodBeat.m2505o(115905);
        }

        /* renamed from: yG */
        public final C37420b mo60258yG() {
            AppMethodBeat.m2504i(115906);
            C37420b c37420b = (C37420b) this.aDb.poll();
            if (c37420b == null) {
                c37420b = new C37420b();
                AppMethodBeat.m2505o(115906);
                return c37420b;
            }
            AppMethodBeat.m2505o(115906);
            return c37420b;
        }

        /* renamed from: a */
        public final void mo60256a(C37420b c37420b) {
            AppMethodBeat.m2504i(115907);
            this.aDb.offer(c37420b);
            AppMethodBeat.m2505o(115907);
        }

        /* renamed from: d */
        public final void mo60257d(ArrayList<C37420b> arrayList) {
            AppMethodBeat.m2504i(115908);
            if (arrayList == null || arrayList.isEmpty()) {
                AppMethodBeat.m2505o(115908);
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.aDb.offer((C37420b) it.next());
            }
            arrayList.clear();
            AppMethodBeat.m2505o(115908);
        }
    }

    /* renamed from: com.tencent.magicbrush.handler.glfont.c$b */
    public static class C37420b {
        /* renamed from: x */
        public int f16069x;
        /* renamed from: y */
        public int f16070y;
        /* renamed from: z */
        public int f16071z;

        /* renamed from: fT */
        public final C37420b mo60259fT(int i) {
            this.f16069x = 1;
            this.f16070y = 1;
            this.f16071z = i;
            return this;
        }

        public final String toString() {
            AppMethodBeat.m2504i(115909);
            String str = "[" + this.f16069x + ", " + this.f16070y + ", " + this.f16071z + "]";
            AppMethodBeat.m2505o(115909);
            return str;
        }
    }

    /* renamed from: a */
    void mo60253a(int i, int i2, Rect rect);

    void init(int i, int i2);

    void reset();
}
