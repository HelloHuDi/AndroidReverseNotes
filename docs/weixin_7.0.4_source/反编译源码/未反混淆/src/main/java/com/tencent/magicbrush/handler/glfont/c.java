package com.tencent.magicbrush.handler.glfont;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

interface c {

    public static class c {
        public int height;
        public int width;
        public int x;
        public int y;

        public final String toString() {
            AppMethodBeat.i(115910);
            String str = "[" + this.x + ", " + this.y + ", " + this.width + ", " + this.height + "]";
            AppMethodBeat.o(115910);
            return str;
        }
    }

    public static class a {
        public Queue<b> aDb = new LinkedList();

        public a() {
            AppMethodBeat.i(115905);
            AppMethodBeat.o(115905);
        }

        public final b yG() {
            AppMethodBeat.i(115906);
            b bVar = (b) this.aDb.poll();
            if (bVar == null) {
                bVar = new b();
                AppMethodBeat.o(115906);
                return bVar;
            }
            AppMethodBeat.o(115906);
            return bVar;
        }

        public final void a(b bVar) {
            AppMethodBeat.i(115907);
            this.aDb.offer(bVar);
            AppMethodBeat.o(115907);
        }

        public final void d(ArrayList<b> arrayList) {
            AppMethodBeat.i(115908);
            if (arrayList == null || arrayList.isEmpty()) {
                AppMethodBeat.o(115908);
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.aDb.offer((b) it.next());
            }
            arrayList.clear();
            AppMethodBeat.o(115908);
        }
    }

    public static class b {
        public int x;
        public int y;
        public int z;

        public final b fT(int i) {
            this.x = 1;
            this.y = 1;
            this.z = i;
            return this;
        }

        public final String toString() {
            AppMethodBeat.i(115909);
            String str = "[" + this.x + ", " + this.y + ", " + this.z + "]";
            AppMethodBeat.o(115909);
            return str;
        }
    }

    void a(int i, int i2, Rect rect);

    void init(int i, int i2);

    void reset();
}
