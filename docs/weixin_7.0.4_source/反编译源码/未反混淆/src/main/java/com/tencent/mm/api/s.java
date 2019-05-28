package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class s {
    public static b ccQ;
    protected a ccP;

    public enum c {
        VIDEO,
        PHOTO;

        static {
            AppMethodBeat.o(73805);
        }
    }

    public static class a {
        public c ccR;
        public boolean ccS;
        public boolean ccT;
        public String path;
        public Rect rect;

        public static class a {
            public c ccR;
            public boolean ccS;
            public boolean ccU = true;
            public Rect ccV;
            public String path;

            public final a AB() {
                AppMethodBeat.i(73802);
                a aVar = new a(this.path, this.ccR, this.ccS, this.ccU, this.ccV);
                AppMethodBeat.o(73802);
                return aVar;
            }
        }

        public a(String str, c cVar, boolean z, boolean z2, Rect rect) {
            this.ccR = cVar;
            this.path = str;
            this.ccS = z;
            this.ccT = z2;
            this.rect = rect;
        }
    }

    public interface b {
        s Ae();
    }

    public abstract boolean Ab();

    public abstract p Ac();

    public abstract void a(n nVar);

    public abstract c aQ(Context context);

    public abstract void onDestroy();

    public void a(a aVar) {
        this.ccP = aVar;
    }

    public void Ad() {
    }
}
