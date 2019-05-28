package android.support.v4.widget;

import android.graphics.Rect;
import java.util.Comparator;

final class k {

    static class c<T> implements Comparator<T> {
        private final Rect QP = new Rect();
        private final Rect QQ = new Rect();
        private final boolean QR;
        private final a<T> QS;

        c(boolean z, a<T> aVar) {
            this.QR = z;
            this.QS = aVar;
        }

        public final int compare(T t, T t2) {
            Rect rect = this.QP;
            Rect rect2 = this.QQ;
            this.QS.b(t, rect);
            this.QS.b(t2, rect2);
            if (rect.top < rect2.top) {
                return -1;
            }
            if (rect.top > rect2.top) {
                return 1;
            }
            if (rect.left < rect2.left) {
                if (this.QR) {
                    return 1;
                }
                return -1;
            } else if (rect.left > rect2.left) {
                if (this.QR) {
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
                    if (this.QR) {
                        return 1;
                    }
                    return -1;
                } else if (rect.right <= rect2.right) {
                    return 0;
                } else {
                    if (this.QR) {
                        return -1;
                    }
                    return 1;
                }
            }
        }
    }

    public interface a<T> {
        void b(T t, Rect rect);
    }

    public interface b<T, V> {
        int L(T t);

        V get(T t, int i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <L, T> T a(L l, b<L, T> bVar, a<T> aVar, T t, Rect rect, int i) {
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
        int L = bVar.L(l);
        Rect rect3 = new Rect();
        int i2 = 0;
        while (i2 < L) {
            T t3 = bVar.get(l, i2);
            if (t3 != t) {
                Object obj;
                aVar.b(t3, rect3);
                if (a(rect, rect3, i)) {
                    if (!a(rect, rect2, i)) {
                        obj = 1;
                    } else if (a(i, rect, rect3, rect2)) {
                        obj = 1;
                    } else if (!a(i, rect, rect2, rect3) && A(c(i, rect, rect3), g(i, rect, rect3)) < A(c(i, rect, rect2), g(i, rect, rect2))) {
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

    private static boolean a(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean a = a(i, rect, rect2);
        if (a(i, rect, rect3) || !a) {
            return false;
        }
        if (!b(i, rect, rect3) || i == 17 || i == 66 || c(i, rect, rect2) < e(i, rect, rect3)) {
            return true;
        }
        return false;
    }

    private static int A(int i, int i2) {
        return ((i * 13) * i) + (i2 * i2);
    }

    private static boolean a(Rect rect, Rect rect2, int i) {
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

    private static boolean a(int i, Rect rect, Rect rect2) {
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

    private static boolean b(int i, Rect rect, Rect rect2) {
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

    private static int c(int i, Rect rect, Rect rect2) {
        return Math.max(0, d(i, rect, rect2));
    }

    private static int d(int i, Rect rect, Rect rect2) {
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

    private static int e(int i, Rect rect, Rect rect2) {
        return Math.max(1, f(i, rect, rect2));
    }

    private static int f(int i, Rect rect, Rect rect2) {
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

    private static int g(int i, Rect rect, Rect rect2) {
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
