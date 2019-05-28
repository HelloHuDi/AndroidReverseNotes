package android.support.v4.e;

import java.util.Locale;

public final class c {
    public static final b KH = new e(null, false);
    public static final b KI = new e(null, true);
    public static final b KJ = new e(b.KQ, false);
    public static final b KK = new e(b.KQ, true);
    public static final b KL = new e(a.KO, false);
    public static final b KM = f.KT;

    interface c {
        int b(CharSequence charSequence, int i);
    }

    static abstract class d implements b {
        private final c KR;

        public abstract boolean ef();

        d(c cVar) {
            this.KR = cVar;
        }

        public final boolean a(CharSequence charSequence, int i) {
            if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
                throw new IllegalArgumentException();
            } else if (this.KR == null) {
                return ef();
            } else {
                switch (this.KR.b(charSequence, i)) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                    default:
                        return ef();
                }
            }
        }
    }

    static class e extends d {
        private final boolean KS;

        e(c cVar, boolean z) {
            super(cVar);
            this.KS = z;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean ef() {
            return this.KS;
        }
    }

    static class b implements c {
        static final b KQ = new b();

        public final int b(CharSequence charSequence, int i) {
            int i2 = i + 0;
            int i3 = 2;
            for (int i4 = 0; i4 < i2 && i3 == 2; i4++) {
                i3 = c.aB(Character.getDirectionality(charSequence.charAt(i4)));
            }
            return i3;
        }

        private b() {
        }
    }

    static class a implements c {
        static final a KO = new a(true);
        static final a KP = new a(false);
        private final boolean KN;

        public final int b(CharSequence charSequence, int i) {
            int i2 = i + 0;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                switch (c.aA(Character.getDirectionality(charSequence.charAt(i4)))) {
                    case 0:
                        if (!this.KN) {
                            i3 = 1;
                            break;
                        }
                        return 0;
                    case 1:
                        if (this.KN) {
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
            if (this.KN) {
                return 1;
            }
            return 0;
        }

        private a(boolean z) {
            this.KN = z;
        }
    }

    static class f extends d {
        static final f KT = new f();

        f() {
            super(null);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean ef() {
            if (d.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static int aA(int i) {
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

    static int aB(int i) {
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
