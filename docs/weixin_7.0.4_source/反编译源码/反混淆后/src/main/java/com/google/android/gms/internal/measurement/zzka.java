package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.view.C31128d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzka extends zzhh {
    private static final String[] zzard = new String[]{"firebase_", "google_", "ga_"};
    private SecureRandom zzare;
    private final AtomicLong zzarf = new AtomicLong(0);
    private int zzarg;
    private Integer zzarh = null;

    zzka(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.m2504i(69498);
        AppMethodBeat.m2505o(69498);
    }

    static MessageDigest getMessageDigest(String str) {
        AppMethodBeat.m2504i(69531);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                try {
                    MessageDigest instance = MessageDigest.getInstance(str);
                    if (instance != null) {
                        AppMethodBeat.m2505o(69531);
                        return instance;
                    }
                    i = i2 + 1;
                } catch (NoSuchAlgorithmException e) {
                }
            } else {
                AppMethodBeat.m2505o(69531);
                return null;
            }
        }
    }

    public static zzko zza(zzkn zzkn, String str) {
        AppMethodBeat.m2504i(69543);
        for (zzko zzko : zzkn.zzata) {
            if (zzko.name.equals(str)) {
                AppMethodBeat.m2505o(69543);
                return zzko;
            }
        }
        AppMethodBeat.m2505o(69543);
        return null;
    }

    private static Object zza(int i, Object obj, boolean z) {
        AppMethodBeat.m2504i(69514);
        Long valueOf;
        if (obj == null) {
            AppMethodBeat.m2505o(69514);
            return null;
        } else if ((obj instanceof Long) || (obj instanceof Double)) {
            AppMethodBeat.m2505o(69514);
            return obj;
        } else if (obj instanceof Integer) {
            valueOf = Long.valueOf((long) ((Integer) obj).intValue());
            AppMethodBeat.m2505o(69514);
            return valueOf;
        } else if (obj instanceof Byte) {
            valueOf = Long.valueOf((long) ((Byte) obj).byteValue());
            AppMethodBeat.m2505o(69514);
            return valueOf;
        } else if (obj instanceof Short) {
            valueOf = Long.valueOf((long) ((Short) obj).shortValue());
            AppMethodBeat.m2505o(69514);
            return valueOf;
        } else if (obj instanceof Boolean) {
            valueOf = Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
            AppMethodBeat.m2505o(69514);
            return valueOf;
        } else if (obj instanceof Float) {
            Double valueOf2 = Double.valueOf(((Float) obj).doubleValue());
            AppMethodBeat.m2505o(69514);
            return valueOf2;
        } else if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String zza = zza(String.valueOf(obj), i, z);
            AppMethodBeat.m2505o(69514);
            return zza;
        } else {
            AppMethodBeat.m2505o(69514);
            return null;
        }
    }

    public static String zza(String str, int i, boolean z) {
        AppMethodBeat.m2504i(69515);
        if (str.codePointCount(0, str.length()) <= i) {
            AppMethodBeat.m2505o(69515);
            return str;
        } else if (z) {
            str = String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
            AppMethodBeat.m2505o(69515);
            return str;
        } else {
            AppMethodBeat.m2505o(69515);
            return null;
        }
    }

    public static String zza(String str, String[] strArr, String[] strArr2) {
        AppMethodBeat.m2504i(69554);
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (zzs(str, strArr[i])) {
                String str2 = strArr2[i];
                AppMethodBeat.m2505o(69554);
                return str2;
            }
        }
        AppMethodBeat.m2505o(69554);
        return null;
    }

    private static void zza(Bundle bundle, Object obj) {
        AppMethodBeat.m2504i(69520);
        Preconditions.checkNotNull(bundle);
        if (obj != null && ((obj instanceof String) || (obj instanceof CharSequence))) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
        AppMethodBeat.m2505o(69520);
    }

    private static boolean zza(Bundle bundle, int i) {
        AppMethodBeat.m2504i(69519);
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", (long) i);
            AppMethodBeat.m2505o(69519);
            return true;
        }
        AppMethodBeat.m2505o(69519);
        return false;
    }

    private final boolean zza(String str, String str2, int i, Object obj, boolean z) {
        AppMethodBeat.m2504i(69512);
        int length;
        int i2;
        Object obj2;
        if (obj == null) {
            AppMethodBeat.m2505o(69512);
            return true;
        } else if ((obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            AppMethodBeat.m2505o(69512);
            return true;
        } else if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                zzge().zzip().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                AppMethodBeat.m2505o(69512);
                return false;
            }
            AppMethodBeat.m2505o(69512);
            return true;
        } else if ((obj instanceof Bundle) && z) {
            AppMethodBeat.m2505o(69512);
            return true;
        } else if ((obj instanceof Parcelable[]) && z) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            length = parcelableArr.length;
            i2 = 0;
            while (i2 < length) {
                obj2 = parcelableArr[i2];
                if (obj2 instanceof Bundle) {
                    i2++;
                } else {
                    zzge().zzip().zze("All Parcelable[] elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                    AppMethodBeat.m2505o(69512);
                    return false;
                }
            }
            AppMethodBeat.m2505o(69512);
            return true;
        } else if ((obj instanceof ArrayList) && z) {
            ArrayList arrayList = (ArrayList) obj;
            length = arrayList.size();
            i2 = 0;
            while (i2 < length) {
                obj2 = arrayList.get(i2);
                i2++;
                if (!(obj2 instanceof Bundle)) {
                    zzge().zzip().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                    AppMethodBeat.m2505o(69512);
                    return false;
                }
            }
            AppMethodBeat.m2505o(69512);
            return true;
        } else {
            AppMethodBeat.m2505o(69512);
            return false;
        }
    }

    public static boolean zza(long[] jArr, int i) {
        return i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    static byte[] zza(Parcelable parcelable) {
        AppMethodBeat.m2504i(69552);
        if (parcelable == null) {
            AppMethodBeat.m2505o(69552);
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            return marshall;
        } finally {
            obtain.recycle();
            AppMethodBeat.m2505o(69552);
        }
    }

    public static long[] zza(BitSet bitSet) {
        AppMethodBeat.m2504i(69539);
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i << 6) + i2 < bitSet.length()) {
                if (bitSet.get((i << 6) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        AppMethodBeat.m2505o(69539);
        return jArr;
    }

    static zzko[] zza(zzko[] zzkoArr, String str, Object obj) {
        AppMethodBeat.m2504i(69545);
        for (zzko zzko : zzkoArr) {
            if (str.equals(zzko.name)) {
                zzko.zzate = null;
                zzko.zzajf = null;
                zzko.zzarc = null;
                if (obj instanceof Long) {
                    zzko.zzate = (Long) obj;
                } else if (obj instanceof String) {
                    zzko.zzajf = (String) obj;
                } else if (obj instanceof Double) {
                    zzko.zzarc = (Double) obj;
                }
                AppMethodBeat.m2505o(69545);
                return zzkoArr;
            }
        }
        zzko[] zzkoArr2 = new zzko[(zzkoArr.length + 1)];
        System.arraycopy(zzkoArr, 0, zzkoArr2, 0, zzkoArr.length);
        zzko zzko2 = new zzko();
        zzko2.name = str;
        if (obj instanceof Long) {
            zzko2.zzate = (Long) obj;
        } else if (obj instanceof String) {
            zzko2.zzajf = (String) obj;
        } else if (obj instanceof Double) {
            zzko2.zzarc = (Double) obj;
        }
        zzkoArr2[zzkoArr.length] = zzko2;
        AppMethodBeat.m2505o(69545);
        return zzkoArr2;
    }

    public static Object zzb(zzkn zzkn, String str) {
        AppMethodBeat.m2504i(69544);
        zzko zza = zza(zzkn, str);
        if (zza != null) {
            if (zza.zzajf != null) {
                String str2 = zza.zzajf;
                AppMethodBeat.m2505o(69544);
                return str2;
            } else if (zza.zzate != null) {
                Long l = zza.zzate;
                AppMethodBeat.m2505o(69544);
                return l;
            } else if (zza.zzarc != null) {
                Double d = zza.zzarc;
                AppMethodBeat.m2505o(69544);
                return d;
            }
        }
        AppMethodBeat.m2505o(69544);
        return null;
    }

    @VisibleForTesting
    static long zzc(byte[] bArr) {
        long j = null;
        AppMethodBeat.m2504i(69532);
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        AppMethodBeat.m2505o(69532);
        return j2;
    }

    public static boolean zzc(Context context, String str) {
        AppMethodBeat.m2504i(69535);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                AppMethodBeat.m2505o(69535);
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                AppMethodBeat.m2505o(69535);
                return true;
            }
            AppMethodBeat.m2505o(69535);
            return false;
        } catch (NameNotFoundException e) {
        }
    }

    static boolean zzcc(String str) {
        AppMethodBeat.m2504i(69502);
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            AppMethodBeat.m2505o(69502);
            return true;
        }
        AppMethodBeat.m2505o(69502);
        return false;
    }

    private static int zzch(String str) {
        AppMethodBeat.m2504i(69521);
        if ("_ldl".equals(str)) {
            AppMethodBeat.m2505o(69521);
            return 2048;
        } else if ("_id".equals(str)) {
            AppMethodBeat.m2505o(69521);
            return 256;
        } else {
            AppMethodBeat.m2505o(69521);
            return 36;
        }
    }

    public static boolean zzci(String str) {
        AppMethodBeat.m2504i(69537);
        if (TextUtils.isEmpty(str) || !str.startsWith("_")) {
            AppMethodBeat.m2505o(69537);
            return false;
        }
        AppMethodBeat.m2505o(69537);
        return true;
    }

    static boolean zzck(String str) {
        AppMethodBeat.m2504i(69541);
        if (str == null || !str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") || str.length() > C31128d.MIC_PTU_DANNAI) {
            AppMethodBeat.m2505o(69541);
            return false;
        }
        AppMethodBeat.m2505o(69541);
        return true;
    }

    static boolean zzcl(String str) {
        AppMethodBeat.m2504i(69550);
        Preconditions.checkNotEmpty(str);
        boolean z = true;
        switch (str.hashCode()) {
            case 94660:
                if (str.equals("_in")) {
                    z = false;
                    break;
                }
                break;
            case 95025:
                if (str.equals("_ug")) {
                    z = true;
                    break;
                }
                break;
            case 95027:
                if (str.equals("_ui")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
                AppMethodBeat.m2505o(69550);
                return true;
            default:
                AppMethodBeat.m2505o(69550);
                return false;
        }
    }

    public static boolean zzd(Intent intent) {
        AppMethodBeat.m2504i(69504);
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) {
            AppMethodBeat.m2505o(69504);
            return true;
        }
        AppMethodBeat.m2505o(69504);
        return false;
    }

    static boolean zzd(zzeu zzeu, zzdz zzdz) {
        AppMethodBeat.m2504i(69549);
        Preconditions.checkNotNull(zzeu);
        Preconditions.checkNotNull(zzdz);
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.m2505o(69549);
            return false;
        }
        AppMethodBeat.m2505o(69549);
        return true;
    }

    @VisibleForTesting
    private final boolean zze(Context context, String str) {
        AppMethodBeat.m2504i(69548);
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                boolean equals = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
                AppMethodBeat.m2505o(69548);
                return equals;
            }
        } catch (CertificateException e) {
            zzge().zzim().zzg("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            zzge().zzim().zzg("Package name not found", e2);
        }
        AppMethodBeat.m2505o(69548);
        return true;
    }

    public static Bundle[] zze(Object obj) {
        AppMethodBeat.m2504i(69517);
        Bundle[] bundleArr;
        if (obj instanceof Bundle) {
            bundleArr = new Bundle[]{(Bundle) obj};
            AppMethodBeat.m2505o(69517);
            return bundleArr;
        } else if (obj instanceof Parcelable[]) {
            bundleArr = (Bundle[]) Arrays.copyOf((Parcelable[]) obj, ((Parcelable[]) obj).length, Bundle[].class);
            AppMethodBeat.m2505o(69517);
            return bundleArr;
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            bundleArr = (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
            AppMethodBeat.m2505o(69517);
            return bundleArr;
        } else {
            AppMethodBeat.m2505o(69517);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f A:{SYNTHETIC, Splitter:B:15:0x003f} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A:{Catch:{ IOException | ClassNotFoundException -> 0x004e }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Object zzf(Object obj) {
        Throwable th;
        AppMethodBeat.m2504i(69553);
        if (obj == null) {
            AppMethodBeat.m2505o(69553);
            return null;
        }
        ObjectOutputStream objectOutputStream;
        ObjectInputStream objectInputStream;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                try {
                    Object readObject = objectInputStream.readObject();
                    try {
                        objectOutputStream.close();
                        objectInputStream.close();
                        AppMethodBeat.m2505o(69553);
                        return readObject;
                    } catch (IOException | ClassNotFoundException e) {
                        AppMethodBeat.m2505o(69553);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                AppMethodBeat.m2505o(69553);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            objectOutputStream = null;
            if (objectOutputStream != null) {
            }
            if (objectInputStream != null) {
            }
            AppMethodBeat.m2505o(69553);
            throw th;
        }
    }

    private final boolean zzr(String str, String str2) {
        AppMethodBeat.m2504i(69506);
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            AppMethodBeat.m2505o(69506);
            return false;
        } else if (str2.length() == 0) {
            zzge().zzim().zzg("Name is required and can't be empty. Type", str);
            AppMethodBeat.m2505o(69506);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzge().zzim().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        AppMethodBeat.m2505o(69506);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(69506);
                return true;
            }
            zzge().zzim().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            AppMethodBeat.m2505o(69506);
            return false;
        }
    }

    public static boolean zzs(String str, String str2) {
        AppMethodBeat.m2504i(69538);
        if (str == null && str2 == null) {
            AppMethodBeat.m2505o(69538);
            return true;
        } else if (str == null) {
            AppMethodBeat.m2505o(69538);
            return false;
        } else {
            boolean equals = str.equals(str2);
            AppMethodBeat.m2505o(69538);
            return equals;
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(69566);
        Context context = super.getContext();
        AppMethodBeat.m2505o(69566);
        return context;
    }

    public final Bundle zza(Uri uri) {
        Bundle bundle = null;
        AppMethodBeat.m2504i(69503);
        if (uri == null) {
            AppMethodBeat.m2505o(69503);
        } else {
            try {
                CharSequence queryParameter;
                CharSequence queryParameter2;
                CharSequence queryParameter3;
                CharSequence queryParameter4;
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                } else {
                    queryParameter4 = null;
                    queryParameter3 = null;
                    queryParameter2 = null;
                    queryParameter = null;
                }
                if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                    AppMethodBeat.m2505o(69503);
                } else {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString(C8741b.CAMPAIGN, queryParameter);
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bundle.putString("source", queryParameter2);
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        bundle.putString(C8741b.MEDIUM, queryParameter3);
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("gclid", queryParameter4);
                    }
                    String queryParameter5 = uri.getQueryParameter("utm_term");
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        bundle.putString(C8741b.TERM, queryParameter5);
                    }
                    queryParameter5 = uri.getQueryParameter("utm_content");
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        bundle.putString(C8741b.CONTENT, queryParameter5);
                    }
                    queryParameter5 = uri.getQueryParameter(C8741b.ACLID);
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        bundle.putString(C8741b.ACLID, queryParameter5);
                    }
                    queryParameter5 = uri.getQueryParameter(C8741b.CP1);
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        bundle.putString(C8741b.CP1, queryParameter5);
                    }
                    queryParameter5 = uri.getQueryParameter("anid");
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        bundle.putString("anid", queryParameter5);
                    }
                    AppMethodBeat.m2505o(69503);
                }
            } catch (UnsupportedOperationException e) {
                zzge().zzip().zzg("Install referrer url isn't a hierarchical URI", e);
                AppMethodBeat.m2505o(69503);
            }
        }
        return bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Bundle zza(String str, Bundle bundle, List<String> list, boolean z, boolean z2) {
        AppMethodBeat.m2504i(69518);
        Bundle bundle2 = null;
        if (bundle != null) {
            Bundle bundle3 = new Bundle(bundle);
            int i = 0;
            for (String str2 : bundle.keySet()) {
                int i2 = 0;
                if (list == null || !list.contains(str2)) {
                    if (z) {
                        i2 = !zzq("event param", str2) ? 3 : !zza("event param", null, str2) ? 14 : !zza("event param", 40, str2) ? 3 : 0;
                    }
                    if (i2 == 0) {
                        i2 = !zzr("event param", str2) ? 3 : !zza("event param", null, str2) ? 14 : !zza("event param", 40, str2) ? 3 : 0;
                    }
                }
                if (i2 != 0) {
                    if (zza(bundle3, i2)) {
                        bundle3.putString("_ev", zza(str2, 40, true));
                        if (i2 == 3) {
                            zza(bundle3, (Object) str2);
                        }
                    }
                    bundle3.remove(str2);
                } else {
                    Object obj = bundle.get(str2);
                    zzab();
                    if (z2) {
                        Object obj2;
                        String str3 = "param";
                        if (obj instanceof Parcelable[]) {
                            i2 = ((Parcelable[]) obj).length;
                        } else if (obj instanceof ArrayList) {
                            i2 = ((ArrayList) obj).size();
                        } else {
                            obj2 = 1;
                            if (obj2 == null) {
                                i2 = 17;
                                if (i2 != 0 || "_ev".equals(str2)) {
                                    if (zzcc(str2)) {
                                        i2 = i;
                                    } else {
                                        i2 = i + 1;
                                        if (i2 > 25) {
                                            zzge().zzim().zze("Event can't contain more than 25 params", zzga().zzbj(str), zzga().zzb(bundle));
                                            zza(bundle3, 5);
                                            bundle3.remove(str2);
                                            i = i2;
                                        }
                                    }
                                    i = i2;
                                } else {
                                    if (zza(bundle3, i2)) {
                                        bundle3.putString("_ev", zza(str2, 40, true));
                                        zza(bundle3, bundle.get(str2));
                                    }
                                    bundle3.remove(str2);
                                }
                            }
                        }
                        if (i2 > 1000) {
                            zzge().zzip().zzd("Parameter array is too long; discarded. Value kind, name, array length", str3, str2, Integer.valueOf(i2));
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (obj2 == null) {
                        }
                    }
                    boolean zza = ((zzgg().zzaw(zzfv().zzah()) && zzci(str)) || zzci(str2)) ? zza("param", str2, 256, obj, z2) : zza("param", str2, 100, obj, z2);
                    i2 = zza ? 0 : 4;
                    if (i2 != 0) {
                    }
                    if (zzcc(str2)) {
                    }
                    i = i2;
                }
            }
            bundle2 = bundle3;
        }
        AppMethodBeat.m2505o(69518);
        return bundle2;
    }

    /* Access modifiers changed, original: final */
    public final <T extends Parcelable> T zza(byte[] bArr, Creator<T> creator) {
        AppMethodBeat.m2504i(69551);
        if (bArr == null) {
            AppMethodBeat.m2505o(69551);
            return null;
        }
        Parcel obtain = Parcel.obtain();
        T t;
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            t = (Parcelable) creator.createFromParcel(obtain);
            return t;
        } catch (ParseException e) {
            t = zzge().zzim();
            t.log("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
            AppMethodBeat.m2505o(69551);
        }
    }

    /* Access modifiers changed, original: final */
    public final zzeu zza(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        AppMethodBeat.m2504i(69546);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(69546);
            return null;
        } else if (zzcd(str) != 0) {
            zzge().zzim().zzg("Invalid conditional property event name", zzga().zzbl(str));
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(69546);
            throw illegalArgumentException;
        } else {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str2);
            zzeu zzeu = new zzeu(str, new zzer(zzd(zza(str, bundle2, CollectionUtils.listOf((Object) "_o"), false, false))), str2, j);
            AppMethodBeat.m2505o(69546);
            return zzeu;
        }
    }

    public final void zza(int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(69527);
        zza(null, i, str, str2, i2);
        AppMethodBeat.m2505o(69527);
    }

    public final void zza(Bundle bundle, String str, Object obj) {
        AppMethodBeat.m2504i(69526);
        if (bundle == null) {
            AppMethodBeat.m2505o(69526);
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            AppMethodBeat.m2505o(69526);
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            AppMethodBeat.m2505o(69526);
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            AppMethodBeat.m2505o(69526);
        } else {
            if (str != null) {
                zzge().zziq().zze("Not putting event parameter. Invalid value type. name, type", zzga().zzbk(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
            AppMethodBeat.m2505o(69526);
        }
    }

    public final void zza(zzko zzko, Object obj) {
        AppMethodBeat.m2504i(69525);
        Preconditions.checkNotNull(obj);
        zzko.zzajf = null;
        zzko.zzate = null;
        zzko.zzarc = null;
        if (obj instanceof String) {
            zzko.zzajf = (String) obj;
            AppMethodBeat.m2505o(69525);
        } else if (obj instanceof Long) {
            zzko.zzate = (Long) obj;
            AppMethodBeat.m2505o(69525);
        } else if (obj instanceof Double) {
            zzko.zzarc = (Double) obj;
            AppMethodBeat.m2505o(69525);
        } else {
            zzge().zzim().zzg("Ignoring invalid (type) event param value", obj);
            AppMethodBeat.m2505o(69525);
        }
    }

    public final void zza(zzks zzks, Object obj) {
        AppMethodBeat.m2504i(69524);
        Preconditions.checkNotNull(obj);
        zzks.zzajf = null;
        zzks.zzate = null;
        zzks.zzarc = null;
        if (obj instanceof String) {
            zzks.zzajf = (String) obj;
            AppMethodBeat.m2505o(69524);
        } else if (obj instanceof Long) {
            zzks.zzate = (Long) obj;
            AppMethodBeat.m2505o(69524);
        } else if (obj instanceof Double) {
            zzks.zzarc = (Double) obj;
            AppMethodBeat.m2505o(69524);
        } else {
            zzge().zzim().zzg("Ignoring invalid (type) user attribute value", obj);
            AppMethodBeat.m2505o(69524);
        }
    }

    public final void zza(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(69528);
        Bundle bundle = new Bundle();
        zza(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zzacw.zzfu().logEvent("auto", "_err", bundle);
        AppMethodBeat.m2505o(69528);
    }

    public final boolean zza(long j, long j2) {
        AppMethodBeat.m2504i(69534);
        if (j == 0 || j2 <= 0) {
            AppMethodBeat.m2505o(69534);
            return true;
        } else if (Math.abs(zzbt().currentTimeMillis() - j) > j2) {
            AppMethodBeat.m2505o(69534);
            return true;
        } else {
            AppMethodBeat.m2505o(69534);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean zza(String str, int i, String str2) {
        AppMethodBeat.m2504i(69508);
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            AppMethodBeat.m2505o(69508);
            return false;
        } else if (str2.codePointCount(0, str2.length()) > i) {
            zzge().zzim().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            AppMethodBeat.m2505o(69508);
            return false;
        } else {
            AppMethodBeat.m2505o(69508);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean zza(String str, String[] strArr, String str2) {
        AppMethodBeat.m2504i(69507);
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            AppMethodBeat.m2505o(69507);
            return false;
        }
        boolean z;
        Preconditions.checkNotNull(str2);
        for (String startsWith : zzard) {
            if (str2.startsWith(startsWith)) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            zzge().zzim().zze("Name starts with reserved prefix. Type, name", str, str2);
            AppMethodBeat.m2505o(69507);
            return false;
        }
        if (strArr != null) {
            Preconditions.checkNotNull(strArr);
            for (String startsWith2 : strArr) {
                if (zzs(str2, startsWith2)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                zzge().zzim().zze("Name is reserved. Type, name", str, str2);
                AppMethodBeat.m2505o(69507);
                return false;
            }
        }
        AppMethodBeat.m2505o(69507);
        return true;
    }

    public final byte[] zza(byte[] bArr) {
        AppMethodBeat.m2504i(69529);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.m2505o(69529);
            return toByteArray;
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to gzip content", e);
            AppMethodBeat.m2505o(69529);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.m2504i(69558);
        super.zzab();
        AppMethodBeat.m2505o(69558);
    }

    public final byte[] zzb(zzkp zzkp) {
        AppMethodBeat.m2504i(69533);
        try {
            byte[] bArr = new byte[zzkp.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkp.zza(zzb);
            zzb.zzve();
            AppMethodBeat.m2505o(69533);
            return bArr;
        } catch (IOException e) {
            zzge().zzim().zzg("Data loss. Failed to serialize batch", e);
            AppMethodBeat.m2505o(69533);
            return null;
        }
    }

    public final byte[] zzb(byte[] bArr) {
        AppMethodBeat.m2504i(69530);
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.m2505o(69530);
                    return toByteArray;
                }
            }
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to ungzip content", e);
            AppMethodBeat.m2505o(69530);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(69565);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(69565);
        return zzbt;
    }

    public final int zzcd(String str) {
        AppMethodBeat.m2504i(69509);
        if (!zzr("event", str)) {
            AppMethodBeat.m2505o(69509);
            return 2;
        } else if (!zza("event", Event.zzacx, str)) {
            AppMethodBeat.m2505o(69509);
            return 13;
        } else if (zza("event", 40, str)) {
            AppMethodBeat.m2505o(69509);
            return 0;
        } else {
            AppMethodBeat.m2505o(69509);
            return 2;
        }
    }

    public final int zzce(String str) {
        AppMethodBeat.m2504i(69510);
        if (!zzq("user property", str)) {
            AppMethodBeat.m2505o(69510);
            return 6;
        } else if (!zza("user property", UserProperty.zzadb, str)) {
            AppMethodBeat.m2505o(69510);
            return 15;
        } else if (zza("user property", 24, str)) {
            AppMethodBeat.m2505o(69510);
            return 0;
        } else {
            AppMethodBeat.m2505o(69510);
            return 6;
        }
    }

    public final int zzcf(String str) {
        AppMethodBeat.m2504i(69511);
        if (!zzr("user property", str)) {
            AppMethodBeat.m2505o(69511);
            return 6;
        } else if (!zza("user property", UserProperty.zzadb, str)) {
            AppMethodBeat.m2505o(69511);
            return 15;
        } else if (zza("user property", 24, str)) {
            AppMethodBeat.m2505o(69511);
            return 0;
        } else {
            AppMethodBeat.m2505o(69511);
            return 6;
        }
    }

    public final boolean zzcg(String str) {
        AppMethodBeat.m2504i(69513);
        if (TextUtils.isEmpty(str)) {
            zzge().zzim().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            AppMethodBeat.m2505o(69513);
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            AppMethodBeat.m2505o(69513);
            return true;
        }
        zzge().zzim().zzg("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        AppMethodBeat.m2505o(69513);
        return false;
    }

    public final boolean zzcj(String str) {
        AppMethodBeat.m2504i(69540);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(69540);
            return false;
        }
        boolean equals = zzgg().zzhj().equals(str);
        AppMethodBeat.m2505o(69540);
        return equals;
    }

    /* Access modifiers changed, original: final */
    public final long zzd(Context context, String str) {
        long j = -1;
        AppMethodBeat.m2504i(69547);
        zzab();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest messageDigest = getMessageDigest("MD5");
        if (messageDigest == null) {
            zzge().zzim().log("Could not get MD5 instance");
        } else {
            if (packageManager != null) {
                try {
                    if (!zze(context, str)) {
                        PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(getContext().getPackageName(), 64);
                        if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                            zzge().zzip().log("Could not get signatures");
                        } else {
                            j = zzc(messageDigest.digest(packageInfo.signatures[0].toByteArray()));
                        }
                    }
                } catch (NameNotFoundException e) {
                    zzge().zzim().zzg("Package name not found", e);
                }
            }
            j = 0;
        }
        AppMethodBeat.m2505o(69547);
        return j;
    }

    /* Access modifiers changed, original: final */
    public final Bundle zzd(Bundle bundle) {
        AppMethodBeat.m2504i(69542);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzh = zzh(str, bundle.get(str));
                if (zzh == null) {
                    zzge().zzip().zzg("Param value can't be null", zzga().zzbk(str));
                } else {
                    zza(bundle2, str, zzh);
                }
            }
        }
        AppMethodBeat.m2505o(69542);
        return bundle2;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(69556);
        super.zzfr();
        AppMethodBeat.m2505o(69556);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.m2504i(69557);
        super.zzfs();
        AppMethodBeat.m2505o(69557);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(69559);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(69559);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(69560);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(69560);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(69561);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(69561);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(69562);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(69562);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(69563);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(69563);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(69564);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(69564);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(69567);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(69567);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(69568);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(69568);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(69569);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(69569);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(69570);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(69570);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(69571);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(69571);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(69572);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(69572);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(69573);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(69573);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(69574);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(69574);
        return zzgg;
    }

    public final Object zzh(String str, Object obj) {
        int i = 256;
        AppMethodBeat.m2504i(69516);
        Object zza;
        if ("_ev".equals(str)) {
            zza = zza(256, obj, true);
            AppMethodBeat.m2505o(69516);
            return zza;
        }
        if (!zzci(str)) {
            i = 100;
        }
        zza = zza(i, obj, false);
        AppMethodBeat.m2505o(69516);
        return zza;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return true;
    }

    public final int zzi(String str, Object obj) {
        boolean zza;
        AppMethodBeat.m2504i(69522);
        if ("_ldl".equals(str)) {
            zza = zza("user property referrer", str, zzch(str), obj, false);
        } else {
            zza = zza("user property", str, zzch(str), obj, false);
        }
        if (zza) {
            AppMethodBeat.m2505o(69522);
            return 0;
        }
        AppMethodBeat.m2505o(69522);
        return 7;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzih() {
        AppMethodBeat.m2504i(69499);
        zzab();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzge().zzip().log("Utils falling back to Random for random id");
            }
        }
        this.zzarf.set(nextLong);
        AppMethodBeat.m2505o(69499);
    }

    public final Object zzj(String str, Object obj) {
        AppMethodBeat.m2504i(69523);
        Object zza;
        if ("_ldl".equals(str)) {
            zza = zza(zzch(str), obj, true);
            AppMethodBeat.m2505o(69523);
            return zza;
        }
        zza = zza(zzch(str), obj, false);
        AppMethodBeat.m2505o(69523);
        return zza;
    }

    public final long zzlb() {
        long nextLong;
        AppMethodBeat.m2504i(69500);
        if (this.zzarf.get() == 0) {
            synchronized (this.zzarf) {
                try {
                    nextLong = new Random(System.nanoTime() ^ zzbt().currentTimeMillis()).nextLong();
                    int i = this.zzarg + 1;
                    this.zzarg = i;
                    nextLong += (long) i;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(69500);
                }
            }
        } else {
            synchronized (this.zzarf) {
                try {
                    this.zzarf.compareAndSet(-1, 1);
                    nextLong = this.zzarf.getAndIncrement();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(69500);
                }
            }
        }
        return nextLong;
    }

    /* Access modifiers changed, original: final */
    public final SecureRandom zzlc() {
        AppMethodBeat.m2504i(69501);
        zzab();
        if (this.zzare == null) {
            this.zzare = new SecureRandom();
        }
        SecureRandom secureRandom = this.zzare;
        AppMethodBeat.m2505o(69501);
        return secureRandom;
    }

    public final int zzld() {
        AppMethodBeat.m2504i(69555);
        if (this.zzarh == null) {
            this.zzarh = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(getContext()) / 1000);
        }
        int intValue = this.zzarh.intValue();
        AppMethodBeat.m2505o(69555);
        return intValue;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzq(String str, String str2) {
        AppMethodBeat.m2504i(69505);
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            AppMethodBeat.m2505o(69505);
            return false;
        } else if (str2.length() == 0) {
            zzge().zzim().zzg("Name is required and can't be empty. Type", str);
            AppMethodBeat.m2505o(69505);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt)) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzge().zzim().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        AppMethodBeat.m2505o(69505);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(69505);
                return true;
            }
            zzge().zzim().zze("Name must start with a letter. Type, name", str, str2);
            AppMethodBeat.m2505o(69505);
            return false;
        }
    }

    public final boolean zzx(String str) {
        AppMethodBeat.m2504i(69536);
        zzab();
        if (Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0) {
            AppMethodBeat.m2505o(69536);
            return true;
        }
        zzge().zzis().zzg("Permission not granted", str);
        AppMethodBeat.m2505o(69536);
        return false;
    }
}
