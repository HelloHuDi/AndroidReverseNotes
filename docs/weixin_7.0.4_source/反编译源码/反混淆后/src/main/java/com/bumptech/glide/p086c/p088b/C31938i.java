package com.bumptech.glide.p086c.p088b;

import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C44994c;

/* renamed from: com.bumptech.glide.c.b.i */
public abstract class C31938i {
    public static final C31938i aBi = new C319391();
    public static final C31938i aBj = new C07552();
    public static final C31938i aBk = new C07563();
    public static final C31938i aBl = new C07574();
    public static final C31938i aBm = new C07585();

    /* renamed from: com.bumptech.glide.c.b.i$2 */
    class C07552 extends C31938i {
        C07552() {
        }

        /* renamed from: a */
        public final boolean mo2215a(C25405a c25405a) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo2216a(boolean z, C25405a c25405a, C44994c c44994c) {
            return false;
        }

        /* renamed from: mE */
        public final boolean mo2217mE() {
            return false;
        }

        /* renamed from: mF */
        public final boolean mo2218mF() {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.i$3 */
    class C07563 extends C31938i {
        C07563() {
        }

        /* renamed from: a */
        public final boolean mo2215a(C25405a c25405a) {
            return (c25405a == C25405a.DATA_DISK_CACHE || c25405a == C25405a.MEMORY_CACHE) ? false : true;
        }

        /* renamed from: a */
        public final boolean mo2216a(boolean z, C25405a c25405a, C44994c c44994c) {
            return false;
        }

        /* renamed from: mE */
        public final boolean mo2217mE() {
            return false;
        }

        /* renamed from: mF */
        public final boolean mo2218mF() {
            return true;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.i$4 */
    class C07574 extends C31938i {
        C07574() {
        }

        /* renamed from: a */
        public final boolean mo2215a(C25405a c25405a) {
            return false;
        }

        /* renamed from: a */
        public final boolean mo2216a(boolean z, C25405a c25405a, C44994c c44994c) {
            return (c25405a == C25405a.RESOURCE_DISK_CACHE || c25405a == C25405a.MEMORY_CACHE) ? false : true;
        }

        /* renamed from: mE */
        public final boolean mo2217mE() {
            return true;
        }

        /* renamed from: mF */
        public final boolean mo2218mF() {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.i$5 */
    class C07585 extends C31938i {
        C07585() {
        }

        /* renamed from: a */
        public final boolean mo2215a(C25405a c25405a) {
            return c25405a == C25405a.REMOTE;
        }

        /* renamed from: a */
        public final boolean mo2216a(boolean z, C25405a c25405a, C44994c c44994c) {
            return ((z && c25405a == C25405a.DATA_DISK_CACHE) || c25405a == C25405a.LOCAL) && c44994c == C44994c.TRANSFORMED;
        }

        /* renamed from: mE */
        public final boolean mo2217mE() {
            return true;
        }

        /* renamed from: mF */
        public final boolean mo2218mF() {
            return true;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.i$1 */
    class C319391 extends C31938i {
        C319391() {
        }

        /* renamed from: a */
        public final boolean mo2215a(C25405a c25405a) {
            return c25405a == C25405a.REMOTE;
        }

        /* renamed from: a */
        public final boolean mo2216a(boolean z, C25405a c25405a, C44994c c44994c) {
            return (c25405a == C25405a.RESOURCE_DISK_CACHE || c25405a == C25405a.MEMORY_CACHE) ? false : true;
        }

        /* renamed from: mE */
        public final boolean mo2217mE() {
            return true;
        }

        /* renamed from: mF */
        public final boolean mo2218mF() {
            return true;
        }
    }

    /* renamed from: a */
    public abstract boolean mo2215a(C25405a c25405a);

    /* renamed from: a */
    public abstract boolean mo2216a(boolean z, C25405a c25405a, C44994c c44994c);

    /* renamed from: mE */
    public abstract boolean mo2217mE();

    /* renamed from: mF */
    public abstract boolean mo2218mF();
}
