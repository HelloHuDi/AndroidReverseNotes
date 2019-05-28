package android.support.v4.d;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.a.d;
import android.support.v4.a.i;
import android.support.v4.f.g;
import android.support.v4.f.l;
import android.support.v4.f.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class b {
    private static final g<String, Typeface> Hf = new g(16);
    private static final c Kk = new c("fonts");
    private static final m<String, ArrayList<android.support.v4.d.c.a<c>>> Kl = new m();
    private static final Comparator<byte[]> Km = new Comparator<byte[]>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = (byte[]) obj2;
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };
    private static final Object sLock = new Object();

    public static class a {
        final b[] Kr;
        final int mStatusCode;

        public a(int i, b[] bVarArr) {
            this.mStatusCode = i;
            this.Kr = bVarArr;
        }
    }

    public static class b {
        public final int GO;
        public final boolean GP;
        final int Kc;
        public final int Ks;
        public final Uri mUri;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            this.mUri = (Uri) l.checkNotNull(uri);
            this.Ks = i;
            this.GO = i2;
            this.GP = z;
            this.Kc = i3;
        }
    }

    static final class c {
        final int Kt;
        final Typeface tj;

        c(Typeface typeface, int i) {
            this.tj = typeface;
            this.Kt = i;
        }
    }

    /* renamed from: android.support.v4.d.b$2 */
    static class AnonymousClass2 implements android.support.v4.d.c.a<c> {
        final /* synthetic */ android.support.v4.content.a.b.a Kp;
        final /* synthetic */ Handler Kq = null;

        AnonymousClass2(android.support.v4.content.a.b.a aVar, Handler handler) {
            this.Kp = aVar;
        }

        public final /* synthetic */ void D(Object obj) {
            c cVar = (c) obj;
            if (cVar == null) {
                this.Kp.a(1, this.Kq);
            } else if (cVar.Kt == 0) {
                this.Kp.a(cVar.tj, this.Kq);
            } else {
                this.Kp.a(cVar.Kt, this.Kq);
            }
        }
    }

    private static c a(Context context, a aVar, int i) {
        int i2 = -3;
        try {
            PackageManager packageManager = context.getPackageManager();
            Resources resources = context.getResources();
            String str = aVar.Ke;
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (resolveContentProvider == null) {
                throw new NameNotFoundException("No package found for authority: ".concat(String.valueOf(str)));
            } else if (resolveContentProvider.packageName.equals(aVar.Kf)) {
                List list;
                ProviderInfo providerInfo;
                a aVar2;
                List a = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a, Km);
                if (aVar.Kh != null) {
                    list = aVar.Kh;
                } else {
                    list = android.support.v4.content.a.a.a(resources, aVar.Ki);
                }
                for (int i3 = 0; i3 < list.size(); i3++) {
                    ArrayList arrayList = new ArrayList((Collection) list.get(i3));
                    Collections.sort(arrayList, Km);
                    if (b(a, arrayList)) {
                        providerInfo = resolveContentProvider;
                        break;
                    }
                }
                providerInfo = null;
                if (providerInfo == null) {
                    aVar2 = new a(1, null);
                } else {
                    aVar2 = new a(0, a(context, aVar, providerInfo.authority));
                }
                if (aVar2.mStatusCode == 0) {
                    int i4;
                    Typeface a2 = d.a(context, aVar2.Kr, i);
                    if (a2 != null) {
                        i4 = 0;
                    } else {
                        i4 = -3;
                    }
                    return new c(a2, i4);
                }
                if (aVar2.mStatusCode == 1) {
                    i2 = -2;
                }
                return new c(null, i2);
            } else {
                throw new NameNotFoundException("Found content provider " + str + ", but package was not " + aVar.Kf);
            }
        } catch (NameNotFoundException e) {
            return new c(null, -1);
        }
    }

    /* JADX WARNING: Missing block: B:38:0x0092, code skipped:
            r0 = Kk;
            r0.f(new android.support.v4.d.c.AnonymousClass2(r0, r4, new android.os.Handler(), new android.support.v4.d.b.AnonymousClass3()));
     */
    /* JADX WARNING: Missing block: B:42:?, code skipped:
            return r2;
     */
    /* JADX WARNING: Missing block: B:43:?, code skipped:
            return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Typeface a(final Context context, final a aVar, android.support.v4.content.a.b.a aVar2, boolean z, int i, final int i2) {
        Handler handler = null;
        final String str = aVar.Kj + "-" + i2;
        Typeface typeface = (Typeface) Hf.get(str);
        if (typeface != null) {
            if (aVar2 != null) {
                aVar2.b(typeface);
            }
            return typeface;
        } else if (z && i == -1) {
            c a = a(context, aVar, i2);
            if (aVar2 != null) {
                if (a.Kt == 0) {
                    aVar2.a(a.tj, handler);
                } else {
                    aVar2.a(a.Kt, handler);
                }
            }
            return a.tj;
        } else {
            AnonymousClass1 anonymousClass1 = new Callable<c>() {
                public final /* synthetic */ Object call() {
                    c b = b.a(context, aVar, i2);
                    if (b.tj != null) {
                        b.Hf.put(str, b.tj);
                    }
                    return b;
                }
            };
            if (z) {
                try {
                    return ((c) Kk.a(anonymousClass1, i)).tj;
                } catch (InterruptedException e) {
                    return handler;
                }
            }
            Object obj;
            if (aVar2 == null) {
                obj = handler;
            } else {
                AnonymousClass2 obj2 = new AnonymousClass2(aVar2, handler);
            }
            synchronized (sLock) {
                if (Kl.containsKey(str)) {
                    if (obj2 != null) {
                        ((ArrayList) Kl.get(str)).add(obj2);
                    }
                } else if (obj2 != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(obj2);
                    Kl.put(str, arrayList);
                }
            }
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, b[] bVarArr) {
        HashMap hashMap = new HashMap();
        for (b bVar : bVarArr) {
            if (bVar.Kc == 0) {
                Uri uri = bVar.mUri;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, i.b(context, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature toByteArray : signatureArr) {
            arrayList.add(toByteArray.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static b[] a(Context context, a aVar, String str) {
        Throwable th;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Uri build = new Builder().scheme(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT).authority(str).build();
        Uri build2 = new Builder().scheme(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT).authority(str).appendPath("file").build();
        try {
            Cursor query;
            ArrayList arrayList2;
            if (VERSION.SDK_INT > 16) {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.Kg}, null, null);
            } else {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.Kg}, null);
            }
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndex = query.getColumnIndex("result_code");
                        arrayList2 = new ArrayList();
                        int columnIndex2 = query.getColumnIndex("_id");
                        int columnIndex3 = query.getColumnIndex("file_id");
                        int columnIndex4 = query.getColumnIndex("font_ttc_index");
                        int columnIndex5 = query.getColumnIndex("font_weight");
                        int columnIndex6 = query.getColumnIndex("font_italic");
                        while (query.moveToNext()) {
                            Uri withAppendedId;
                            int i = columnIndex != -1 ? query.getInt(columnIndex) : 0;
                            int i2 = columnIndex4 != -1 ? query.getInt(columnIndex4) : 0;
                            if (columnIndex3 == -1) {
                                withAppendedId = ContentUris.withAppendedId(build, query.getLong(columnIndex2));
                            } else {
                                withAppendedId = ContentUris.withAppendedId(build2, query.getLong(columnIndex3));
                            }
                            int i3 = columnIndex5 != -1 ? query.getInt(columnIndex5) : 400;
                            boolean z = columnIndex6 != -1 && query.getInt(columnIndex6) == 1;
                            arrayList2.add(new b(withAppendedId, i2, i3, z, i));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return (b[]) arrayList2.toArray(new b[0]);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                }
            }
            arrayList2 = arrayList;
            if (query != null) {
            }
            return (b[]) arrayList2.toArray(new b[0]);
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }
}
