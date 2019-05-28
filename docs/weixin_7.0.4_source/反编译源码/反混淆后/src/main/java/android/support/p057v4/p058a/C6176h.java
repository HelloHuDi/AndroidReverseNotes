package android.support.p057v4.p058a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.p057v4.content.p062a.C0372a.C0371c;
import android.support.p057v4.content.p062a.C0372a.C0373b;
import android.support.p057v4.p058a.C0289d.C0288a;
import android.support.p057v4.p063d.C0391b.C0389b;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: android.support.v4.a.h */
class C6176h implements C0288a {

    /* renamed from: android.support.v4.a.h$a */
    interface C0290a<T> {
        /* renamed from: t */
        boolean mo468t(T t);

        /* renamed from: u */
        int mo469u(T t);
    }

    /* renamed from: android.support.v4.a.h$1 */
    class C61741 implements C0290a<C0389b> {
        C61741() {
        }

        /* renamed from: t */
        public final /* bridge */ /* synthetic */ boolean mo468t(Object obj) {
            return ((C0389b) obj).f439GP;
        }

        /* renamed from: u */
        public final /* bridge */ /* synthetic */ int mo469u(Object obj) {
            return ((C0389b) obj).f438GO;
        }
    }

    /* renamed from: android.support.v4.a.h$2 */
    class C61752 implements C0290a<C0371c> {
        C61752() {
        }

        /* renamed from: t */
        public final /* bridge */ /* synthetic */ boolean mo468t(Object obj) {
            return ((C0371c) obj).f418GP;
        }

        /* renamed from: u */
        public final /* bridge */ /* synthetic */ int mo469u(Object obj) {
            return ((C0371c) obj).f417GO;
        }
    }

    C6176h() {
    }

    /* renamed from: a */
    private static <T> T m9868a(T[] tArr, int i, C0290a<T> c0290a) {
        boolean z;
        int i2 = (i & 1) == 0 ? 400 : 700;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        T t = null;
        int i3 = BaseClientBuilder.API_PRIORITY_OTHER;
        for (T t2 : tArr) {
            int i4;
            int abs = Math.abs(c0290a.mo469u(t2) - i2) * 2;
            if (c0290a.mo468t(t2) == z) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            i4 += abs;
            if (t == null || i3 > i4) {
                i3 = i4;
                t = t2;
            }
        }
        return t;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C0389b mo13752a(C0389b[] c0389bArr, int i) {
        return (C0389b) C6176h.m9868a((Object[]) c0389bArr, i, new C61741());
    }

    /* renamed from: a */
    protected static Typeface m9867a(Context context, InputStream inputStream) {
        Typeface typeface = null;
        File T = C0291i.m503T(context);
        if (T != null) {
            try {
                if (C0291i.m506a(T, inputStream)) {
                    typeface = Typeface.createFromFile(T.getPath());
                    T.delete();
                }
            } catch (RuntimeException e) {
            } finally {
                T.delete();
            }
        }
        return typeface;
    }

    /* renamed from: a */
    public Typeface mo467a(Context context, C0389b[] c0389bArr, int i) {
        Throwable th;
        Closeable closeable;
        Typeface typeface = null;
        if (c0389bArr.length > 0) {
            Closeable openInputStream;
            try {
                openInputStream = context.getContentResolver().openInputStream(mo13752a(c0389bArr, i).mUri);
                try {
                    typeface = C6176h.m9867a(context, (InputStream) openInputStream);
                    C0291i.closeQuietly(openInputStream);
                } catch (IOException e) {
                    C0291i.closeQuietly(openInputStream);
                    return typeface;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = openInputStream;
                    C0291i.closeQuietly(closeable);
                    throw th;
                }
            } catch (IOException e2) {
                openInputStream = typeface;
            } catch (Throwable th3) {
                th = th3;
                closeable = typeface;
                C0291i.closeQuietly(closeable);
                throw th;
            }
        }
        return typeface;
    }

    /* renamed from: a */
    public Typeface mo465a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typeface = null;
        File T = C0291i.m503T(context);
        if (T != null) {
            try {
                if (C0291i.m505a(T, resources, i)) {
                    typeface = Typeface.createFromFile(T.getPath());
                    T.delete();
                }
            } catch (RuntimeException e) {
            } finally {
                T.delete();
            }
        }
        return typeface;
    }

    /* renamed from: a */
    public Typeface mo466a(Context context, C0373b c0373b, Resources resources, int i) {
        C0371c c0371c = (C0371c) C6176h.m9868a(c0373b.f420GN, i, new C61752());
        if (c0371c == null) {
            return null;
        }
        return C0289d.m496a(context, resources, c0371c.f419GQ, c0371c.mFileName, i);
    }
}
