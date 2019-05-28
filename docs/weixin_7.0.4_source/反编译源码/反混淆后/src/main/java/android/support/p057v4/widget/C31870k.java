package android.support.p057v4.widget;

import android.graphics.Rect;
import java.util.Comparator;

/* renamed from: android.support.v4.widget.k */
final class C31870k {

    /* renamed from: android.support.v4.widget.k$c */
    static class C8419c<T> implements Comparator<T> {
        /* renamed from: QP */
        private final Rect f2401QP = new Rect();
        /* renamed from: QQ */
        private final Rect f2402QQ = new Rect();
        /* renamed from: QR */
        private final boolean f2403QR;
        /* renamed from: QS */
        private final C17468a<T> f2404QS;

        C8419c(boolean z, C17468a<T> c17468a) {
            this.f2403QR = z;
            this.f2404QS = c17468a;
        }

        public final int compare(T t, T t2) {
            Rect rect = this.f2401QP;
            Rect rect2 = this.f2402QQ;
            this.f2404QS.mo18385b(t, rect);
            this.f2404QS.mo18385b(t2, rect2);
            if (rect.top < rect2.top) {
                return -1;
            }
            if (rect.top > rect2.top) {
                return 1;
            }
            if (rect.left < rect2.left) {
                if (this.f2403QR) {
                    return 1;
                }
                return -1;
            } else if (rect.left > rect2.left) {
                if (this.f2403QR) {
                    return -1;
                }
                return 1;
            } else if (rect.bottom < rect2.bottom) {
                return -1;
            } else {
                if (rect.bottom > rect2.bottom) {
                    return 1;
                }
                if (rect.right < rect2.right) {
                    if (this.f2403QR) {
                        return 1;
                    }
                    return -1;
                } else if (rect.right <= rect2.right) {
                    return 0;
                } else {
                    if (this.f2403QR) {
                        return -1;
                    }
                    return 1;
                }
            }
        }
    }

    /* renamed from: android.support.v4.widget.k$a */
    public interface C17468a<T> {
        /* renamed from: b */
        void mo18385b(T t, Rect rect);
    }

    /* renamed from: android.support.v4.widget.k$b */
    public interface C31869b<T, V> {
        /* renamed from: L */
        int mo18386L(T t);

        V get(T t, int i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static <L, T> T m51641a(L l, C31869b<L, T> c31869b, C17468a<T> c17468a, T t, Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        switch (i) {
            case 17:
                rect2.offset(rect.width() + 1, 0);
                break;
            case 33:
                rect2.offset(0, rect.height() + 1);
                break;
            case 66:
                rect2.offset(-(rect.width() + 1), 0);
                break;
            case 130:
                rect2.offset(0, -(rect.height() + 1));
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        T t2 = null;
        int L = c31869b.mo18386L(l);
        Rect rect3 = new Rect();
        int i2 = 0;
        while (i2 < L) {
            T t3 = c31869b.get(l, i2);
            if (t3 != t) {
                Object obj;
                c17468a.mo18385b(t3, rect3);
                if (C31870k.m51644a(rect, rect3, i)) {
                    if (!C31870k.m51644a(rect, rect2, i)) {
                        obj = 1;
                    } else if (C31870k.m51643a(i, rect, rect3, rect2)) {
                        obj = 1;
                    } else if (!C31870k.m51643a(i, rect, rect2, rect3) && C31870k.m51640A(C31870k.m51646c(i, rect, rect3), C31870k.m51650g(i, rect, rect3)) < C31870k.m51640A(C31870k.m51646c(i, rect, rect2), C31870k.m51650g(i, rect, rect2))) {
                        obj = 1;
                    }
                    if (obj != null) {
                        rect2.set(rect3);
                        i2++;
                        t2 = t3;
                    }
                }
                obj = null;
                if (obj != null) {
                }
            }
            t3 = t2;
            i2++;
            t2 = t3;
        }
        return t2;
    }

    /* renamed from: a */
    private static boolean m51643a(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean a = C31870k.m51642a(i, rect, rect2);
        if (C31870k.m51642a(i, rect, rect3) || !a) {
            return false;
        }
        if (!C31870k.m51645b(i, rect, rect3) || i == 17 || i == 66 || C31870k.m51646c(i, rect, rect2) < C31870k.m51648e(i, rect, rect3)) {
            return true;
        }
        return false;
    }

    /* renamed from: A */
    private static int m51640A(int i, int i2) {
        return ((i * 13) * i) + (i2 * i2);
    }

    /* renamed from: a */
    private static boolean m51644a(Rect rect, Rect rect2, int i) {
        switch (i) {
            case 17:
                if ((rect.right > rect2.right || rect.left >= rect2.right) && rect.left > rect2.left) {
                    return true;
                }
                return false;
            case 33:
                if ((rect.bottom > rect2.bottom || rect.top >= rect2.bottom) && rect.top > rect2.top) {
                    return true;
                }
                return false;
            case 66:
                if ((rect.left < rect2.left || rect.right <= rect2.left) && rect.right < rect2.right) {
                    return true;
                }
                return false;
            case 130:
                return (rect.top < rect2.top || rect.bottom <= rect2.top) && rect.bottom < rect2.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    /* renamed from: a */
    private static boolean m51642a(int i, Rect rect, Rect rect2) {
        switch (i) {
            case 17:
            case 66:
                if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
                    return false;
                }
                return true;
            case 33:
            case 130:
                return rect2.right >= rect.left && rect2.left <= rect.right;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    /* renamed from: b */
    private static boolean m51645b(int i, Rect rect, Rect rect2) {
        switch (i) {
            case 17:
                if (rect.left >= rect2.right) {
                    return true;
                }
                return false;
            case 33:
                if (rect.top < rect2.bottom) {
                    return false;
                }
                return true;
            case 66:
                if (rect.right > rect2.left) {
                    return false;
                }
                return true;
            case 130:
                return rect.bottom <= rect2.top;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    /* renamed from: c */
    private static int m51646c(int i, Rect rect, Rect rect2) {
        return Math.max(0, C31870k.m51647d(i, rect, rect2));
    }

    /* renamed from: d */
    private static int m51647d(int i, Rect rect, Rect rect2) {
        switch (i) {
            case 17:
                return rect.left - rect2.right;
            case 33:
                return rect.top - rect2.bottom;
            case 66:
                return rect2.left - rect.right;
            case 130:
                return rect2.top - rect.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    /* renamed from: e */
    private static int m51648e(int i, Rect rect, Rect rect2) {
        return Math.max(1, C31870k.m51649f(i, rect, rect2));
    }

    /* renamed from: f */
    private static int m51649f(int i, Rect rect, Rect rect2) {
        switch (i) {
            case 17:
                return rect.left - rect2.left;
            case 33:
                return rect.top - rect2.top;
            case 66:
                return rect2.right - rect.right;
            case 130:
                return rect2.bottom - rect.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    /* renamed from: g */
    private static int m51650g(int i, Rect rect, Rect rect2) {
        switch (i) {
            case 17:
            case 66:
                return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
            case 33:
            case 130:
                return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }
}
