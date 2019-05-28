package android.support.p057v4.p063d;

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
import android.support.p057v4.content.p062a.C0372a;
import android.support.p057v4.content.p062a.C0378b.C0377a;
import android.support.p057v4.p058a.C0289d;
import android.support.p057v4.p058a.C0291i;
import android.support.p057v4.p063d.C0399c.C0398a;
import android.support.p057v4.p065f.C0408g;
import android.support.p057v4.p065f.C0416l;
import android.support.p057v4.p065f.C0417m;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
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

/* renamed from: android.support.v4.d.b */
public final class C0391b {
    /* renamed from: Hf */
    private static final C0408g<String, Typeface> f444Hf = new C0408g(16);
    /* renamed from: Kk */
    private static final C0399c f445Kk = new C0399c("fonts");
    /* renamed from: Kl */
    private static final C0417m<String, ArrayList<C0398a<C0390c>>> f446Kl = new C0417m();
    /* renamed from: Km */
    private static final Comparator<byte[]> f447Km = new C03874();
    private static final Object sLock = new Object();

    /* renamed from: android.support.v4.d.b$4 */
    static class C03874 implements Comparator<byte[]> {
        C03874() {
        }

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
    }

    /* renamed from: android.support.v4.d.b$a */
    public static class C0388a {
        /* renamed from: Kr */
        final C0389b[] f437Kr;
        final int mStatusCode;

        public C0388a(int i, C0389b[] c0389bArr) {
            this.mStatusCode = i;
            this.f437Kr = c0389bArr;
        }
    }

    /* renamed from: android.support.v4.d.b$b */
    public static class C0389b {
        /* renamed from: GO */
        public final int f438GO;
        /* renamed from: GP */
        public final boolean f439GP;
        /* renamed from: Kc */
        final int f440Kc;
        /* renamed from: Ks */
        public final int f441Ks;
        public final Uri mUri;

        public C0389b(Uri uri, int i, int i2, boolean z, int i3) {
            this.mUri = (Uri) C0416l.checkNotNull(uri);
            this.f441Ks = i;
            this.f438GO = i2;
            this.f439GP = z;
            this.f440Kc = i3;
        }
    }

    /* renamed from: android.support.v4.d.b$c */
    static final class C0390c {
        /* renamed from: Kt */
        final int f442Kt;
        /* renamed from: tj */
        final Typeface f443tj;

        C0390c(Typeface typeface, int i) {
            this.f443tj = typeface;
            this.f442Kt = i;
        }
    }

    /* renamed from: android.support.v4.d.b$2 */
    static class C03922 implements C0398a<C0390c> {
        /* renamed from: Kp */
        final /* synthetic */ C0377a f448Kp;
        /* renamed from: Kq */
        final /* synthetic */ Handler f449Kq = null;

        C03922(C0377a c0377a, Handler handler) {
            this.f448Kp = c0377a;
        }

        /* renamed from: D */
        public final /* synthetic */ void mo699D(Object obj) {
            C0390c c0390c = (C0390c) obj;
            if (c0390c == null) {
                this.f448Kp.mo662a(1, this.f449Kq);
            } else if (c0390c.f442Kt == 0) {
                this.f448Kp.mo663a(c0390c.f443tj, this.f449Kq);
            } else {
                this.f448Kp.mo662a(c0390c.f442Kt, this.f449Kq);
            }
        }
    }

    /* renamed from: a */
    private static C0390c m657a(Context context, C0385a c0385a, int i) {
        int i2 = -3;
        try {
            PackageManager packageManager = context.getPackageManager();
            Resources resources = context.getResources();
            String str = c0385a.f429Ke;
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (resolveContentProvider == null) {
                throw new NameNotFoundException("No package found for authority: ".concat(String.valueOf(str)));
            } else if (resolveContentProvider.packageName.equals(c0385a.f430Kf)) {
                List list;
                ProviderInfo providerInfo;
                C0388a c0388a;
                List a = C0391b.m658a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a, f447Km);
                if (c0385a.f432Kh != null) {
                    list = c0385a.f432Kh;
                } else {
                    list = C0372a.m624a(resources, c0385a.f433Ki);
                }
                for (int i3 = 0; i3 < list.size(); i3++) {
                    ArrayList arrayList = new ArrayList((Collection) list.get(i3));
                    Collections.sort(arrayList, f447Km);
                    if (C0391b.m663b(a, arrayList)) {
                        providerInfo = resolveContentProvider;
                        break;
                    }
                }
                providerInfo = null;
                if (providerInfo == null) {
                    c0388a = new C0388a(1, null);
                } else {
                    c0388a = new C0388a(0, C0391b.m660a(context, c0385a, providerInfo.authority));
                }
                if (c0388a.mStatusCode == 0) {
                    int i4;
                    Typeface a2 = C0289d.m498a(context, c0388a.f437Kr, i);
                    if (a2 != null) {
                        i4 = 0;
                    } else {
                        i4 = -3;
                    }
                    return new C0390c(a2, i4);
                }
                if (c0388a.mStatusCode == 1) {
                    i2 = -2;
                }
                return new C0390c(null, i2);
            } else {
                throw new NameNotFoundException("Found content provider " + str + ", but package was not " + c0385a.f430Kf);
            }
        } catch (NameNotFoundException e) {
            return new C0390c(null, -1);
        }
    }

    /* JADX WARNING: Missing block: B:38:0x0092, code skipped:
            r0 = f445Kk;
            r0.mo705f(new android.support.p057v4.p063d.C0399c.C03962(r0, r4, new android.os.Handler(), new android.support.p057v4.p063d.C0391b.C03933()));
     */
    /* JADX WARNING: Missing block: B:42:?, code skipped:
            return r2;
     */
    /* JADX WARNING: Missing block: B:43:?, code skipped:
            return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static Typeface m656a(final Context context, final C0385a c0385a, C0377a c0377a, boolean z, int i, final int i2) {
        Handler handler = null;
        final String str = c0385a.f434Kj + "-" + i2;
        Typeface typeface = (Typeface) f444Hf.get(str);
        if (typeface != null) {
            if (c0377a != null) {
                c0377a.mo664b(typeface);
            }
            return typeface;
        } else if (z && i == -1) {
            C0390c a = C0391b.m657a(context, c0385a, i2);
            if (c0377a != null) {
                if (a.f442Kt == 0) {
                    c0377a.mo663a(a.f443tj, handler);
                } else {
                    c0377a.mo662a(a.f442Kt, handler);
                }
            }
            return a.f443tj;
        } else {
            C03861 c03861 = new Callable<C0390c>() {
                public final /* synthetic */ Object call() {
                    C0390c b = C0391b.m657a(context, c0385a, i2);
                    if (b.f443tj != null) {
                        C0391b.f444Hf.put(str, b.f443tj);
                    }
                    return b;
                }
            };
            if (z) {
                try {
                    return ((C0390c) f445Kk.mo704a(c03861, i)).f443tj;
                } catch (InterruptedException e) {
                    return handler;
                }
            }
            Object obj;
            if (c0377a == null) {
                obj = handler;
            } else {
                C03922 obj2 = new C03922(c0377a, handler);
            }
            synchronized (sLock) {
                if (f446Kl.containsKey(str)) {
                    if (obj2 != null) {
                        ((ArrayList) f446Kl.get(str)).add(obj2);
                    }
                } else if (obj2 != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(obj2);
                    f446Kl.put(str, arrayList);
                }
            }
        }
    }

    /* renamed from: a */
    public static Map<Uri, ByteBuffer> m659a(Context context, C0389b[] c0389bArr) {
        HashMap hashMap = new HashMap();
        for (C0389b c0389b : c0389bArr) {
            if (c0389b.f440Kc == 0) {
                Uri uri = c0389b.mUri;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, C0291i.m507b(context, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: b */
    private static boolean m663b(List<byte[]> list, List<byte[]> list2) {
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

    /* renamed from: a */
    private static List<byte[]> m658a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature toByteArray : signatureArr) {
            arrayList.add(toByteArray.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static C0389b[] m660a(Context context, C0385a c0385a, String str) {
        Throwable th;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Uri build = new Builder().scheme(C8741b.CONTENT).authority(str).build();
        Uri build2 = new Builder().scheme(C8741b.CONTENT).authority(str).appendPath("file").build();
        try {
            Cursor query;
            ArrayList arrayList2;
            if (VERSION.SDK_INT > 16) {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{c0385a.f431Kg}, null, null);
            } else {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{c0385a.f431Kg}, null);
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
                            arrayList2.add(new C0389b(withAppendedId, i2, i3, z, i));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return (C0389b[]) arrayList2.toArray(new C0389b[0]);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                }
            }
            arrayList2 = arrayList;
            if (query != null) {
            }
            return (C0389b[]) arrayList2.toArray(new C0389b[0]);
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
