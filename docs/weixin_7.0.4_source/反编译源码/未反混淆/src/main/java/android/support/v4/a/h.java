package android.support.v4.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v4.content.a.a.c;
import android.support.v4.d.b.b;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class h implements a {

    interface a<T> {
        boolean t(T t);

        int u(T t);
    }

    h() {
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
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
            int abs = Math.abs(aVar.u(t2) - i2) * 2;
            if (aVar.t(t2) == z) {
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
    public final b a(b[] bVarArr, int i) {
        return (b) a((Object[]) bVarArr, i, new a<b>() {
            public final /* bridge */ /* synthetic */ boolean t(Object obj) {
                return ((b) obj).GP;
            }

            public final /* bridge */ /* synthetic */ int u(Object obj) {
                return ((b) obj).GO;
            }
        });
    }

    protected static Typeface a(Context context, InputStream inputStream) {
        Typeface typeface = null;
        File T = i.T(context);
        if (T != null) {
            try {
                if (i.a(T, inputStream)) {
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

    public Typeface a(Context context, b[] bVarArr, int i) {
        Throwable th;
        Closeable closeable;
        Typeface typeface = null;
        if (bVarArr.length > 0) {
            Closeable openInputStream;
            try {
                openInputStream = context.getContentResolver().openInputStream(a(bVarArr, i).mUri);
                try {
                    typeface = a(context, (InputStream) openInputStream);
                    i.closeQuietly(openInputStream);
                } catch (IOException e) {
                    i.closeQuietly(openInputStream);
                    return typeface;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = openInputStream;
                    i.closeQuietly(closeable);
                    throw th;
                }
            } catch (IOException e2) {
                openInputStream = typeface;
            } catch (Throwable th3) {
                th = th3;
                closeable = typeface;
                i.closeQuietly(closeable);
                throw th;
            }
        }
        return typeface;
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typeface = null;
        File T = i.T(context);
        if (T != null) {
            try {
                if (i.a(T, resources, i)) {
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

    public Typeface a(Context context, android.support.v4.content.a.a.b bVar, Resources resources, int i) {
        c cVar = (c) a(bVar.GN, i, new a<c>() {
            public final /* bridge */ /* synthetic */ boolean t(Object obj) {
                return ((c) obj).GP;
            }

            public final /* bridge */ /* synthetic */ int u(Object obj) {
                return ((c) obj).GO;
            }
        });
        if (cVar == null) {
            return null;
        }
        return d.a(context, resources, cVar.GQ, cVar.mFileName, i);
    }
}
