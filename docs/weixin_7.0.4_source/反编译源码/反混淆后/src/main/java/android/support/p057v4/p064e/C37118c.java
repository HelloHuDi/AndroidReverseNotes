package android.support.p057v4.p064e;

import java.util.Locale;

/* renamed from: android.support.v4.e.c */
public final class C37118c {
    /* renamed from: KH */
    public static final C31858b f15768KH = new C6195e(null, false);
    /* renamed from: KI */
    public static final C31858b f15769KI = new C6195e(null, true);
    /* renamed from: KJ */
    public static final C31858b f15770KJ = new C6195e(C8386b.f2347KQ, false);
    /* renamed from: KK */
    public static final C31858b f15771KK = new C6195e(C8386b.f2347KQ, true);
    /* renamed from: KL */
    public static final C31858b f15772KL = new C6195e(C31859a.f14624KO, false);
    /* renamed from: KM */
    public static final C31858b f15773KM = C37119f.f15774KT;

    /* renamed from: android.support.v4.e.c$c */
    interface C0400c {
        /* renamed from: b */
        int mo706b(CharSequence charSequence, int i);
    }

    /* renamed from: android.support.v4.e.c$d */
    static abstract class C0401d implements C31858b {
        /* renamed from: KR */
        private final C0400c f463KR;

        /* renamed from: ef */
        public abstract boolean mo708ef();

        C0401d(C0400c c0400c) {
            this.f463KR = c0400c;
        }

        /* renamed from: a */
        public final boolean mo707a(CharSequence charSequence, int i) {
            if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
                throw new IllegalArgumentException();
            } else if (this.f463KR == null) {
                return mo708ef();
            } else {
                switch (this.f463KR.mo706b(charSequence, i)) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                    default:
                        return mo708ef();
                }
            }
        }
    }

    /* renamed from: android.support.v4.e.c$e */
    static class C6195e extends C0401d {
        /* renamed from: KS */
        private final boolean f1788KS;

        C6195e(C0400c c0400c, boolean z) {
            super(c0400c);
            this.f1788KS = z;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: ef */
        public final boolean mo708ef() {
            return this.f1788KS;
        }
    }

    /* renamed from: android.support.v4.e.c$b */
    static class C8386b implements C0400c {
        /* renamed from: KQ */
        static final C8386b f2347KQ = new C8386b();

        /* renamed from: b */
        public final int mo706b(CharSequence charSequence, int i) {
            int i2 = i + 0;
            int i3 = 2;
            for (int i4 = 0; i4 < i2 && i3 == 2; i4++) {
                i3 = C37118c.m62130aB(Character.getDirectionality(charSequence.charAt(i4)));
            }
            return i3;
        }

        private C8386b() {
        }
    }

    /* renamed from: android.support.v4.e.c$a */
    static class C31859a implements C0400c {
        /* renamed from: KO */
        static final C31859a f14624KO = new C31859a(true);
        /* renamed from: KP */
        static final C31859a f14625KP = new C31859a(false);
        /* renamed from: KN */
        private final boolean f14626KN;

        /* renamed from: b */
        public final int mo706b(CharSequence charSequence, int i) {
            int i2 = i + 0;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                switch (C37118c.m62129aA(Character.getDirectionality(charSequence.charAt(i4)))) {
                    case 0:
                        if (!this.f14626KN) {
                            i3 = 1;
                            break;
                        }
                        return 0;
                    case 1:
                        if (this.f14626KN) {
                            i3 = 1;
                            break;
                        }
                        return 1;
                    default:
                        break;
                }
            }
            if (i3 == 0) {
                return 2;
            }
            if (this.f14626KN) {
                return 1;
            }
            return 0;
        }

        private C31859a(boolean z) {
            this.f14626KN = z;
        }
    }

    /* renamed from: android.support.v4.e.c$f */
    static class C37119f extends C0401d {
        /* renamed from: KT */
        static final C37119f f15774KT = new C37119f();

        C37119f() {
            super(null);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: ef */
        public final boolean mo708ef() {
            if (C37120d.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: aA */
    static int m62129aA(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* renamed from: aB */
    static int m62130aB(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }
}
