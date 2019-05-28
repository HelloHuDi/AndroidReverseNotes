package com.tencent.p177mm.api;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.api.s */
public abstract class C25784s {
    public static C25786b ccQ;
    protected C25785a ccP;

    /* renamed from: com.tencent.mm.api.s$c */
    public enum C8957c {
        VIDEO,
        PHOTO;

        static {
            AppMethodBeat.m2505o(73805);
        }
    }

    /* renamed from: com.tencent.mm.api.s$a */
    public static class C25785a {
        public C8957c ccR;
        public boolean ccS;
        public boolean ccT;
        public String path;
        public Rect rect;

        /* renamed from: com.tencent.mm.api.s$a$a */
        public static class C17916a {
            public C8957c ccR;
            public boolean ccS;
            public boolean ccU = true;
            public Rect ccV;
            public String path;

            /* renamed from: AB */
            public final C25785a mo33430AB() {
                AppMethodBeat.m2504i(73802);
                C25785a c25785a = new C25785a(this.path, this.ccR, this.ccS, this.ccU, this.ccV);
                AppMethodBeat.m2505o(73802);
                return c25785a;
            }
        }

        public C25785a(String str, C8957c c8957c, boolean z, boolean z2, Rect rect) {
            this.ccR = c8957c;
            this.path = str;
            this.ccS = z;
            this.ccT = z2;
            this.rect = rect;
        }
    }

    /* renamed from: com.tencent.mm.api.s$b */
    public interface C25786b {
        /* renamed from: Ae */
        C25784s mo33296Ae();
    }

    /* renamed from: Ab */
    public abstract boolean mo33289Ab();

    /* renamed from: Ac */
    public abstract C37465p mo33290Ac();

    /* renamed from: a */
    public abstract void mo33292a(C37464n c37464n);

    /* renamed from: aQ */
    public abstract C1241c mo33294aQ(Context context);

    public abstract void onDestroy();

    /* renamed from: a */
    public void mo33293a(C25785a c25785a) {
        this.ccP = c25785a;
    }

    /* renamed from: Ad */
    public void mo33291Ad() {
    }
}
