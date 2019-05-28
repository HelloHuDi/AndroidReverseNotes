package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.ICertData.Stub;
import com.google.android.gms.common.internal.IGoogleCertificatesApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.GuardedBy;

@CheckReturnValue
final class GoogleCertificates {
    private static volatile IGoogleCertificatesApi zzax;
    private static final Object zzay = new Object();
    private static Context zzaz;
    @GuardedBy("GoogleCertificates.class")
    private static Set<ICertData> zzba;
    @GuardedBy("GoogleCertificates.class")
    private static Set<ICertData> zzbb;

    static abstract class CertData extends Stub {
        private int zzbc;

        protected CertData(byte[] bArr) {
            Preconditions.checkArgument(bArr.length == 25);
            this.zzbc = Arrays.hashCode(bArr);
        }

        protected static byte[] zzd(String str) {
            try {
                return str.getBytes("ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof ICertData)) {
                return false;
            }
            try {
                ICertData iCertData = (ICertData) obj;
                if (iCertData.getHashCode() != hashCode()) {
                    return false;
                }
                IObjectWrapper bytesWrapped = iCertData.getBytesWrapped();
                if (bytesWrapped == null) {
                    return false;
                }
                return Arrays.equals(getBytes(), (byte[]) ObjectWrapper.unwrap(bytesWrapped));
            } catch (RemoteException e) {
                return false;
            }
        }

        public abstract byte[] getBytes();

        public IObjectWrapper getBytesWrapped() {
            return ObjectWrapper.wrap(getBytes());
        }

        public int getHashCode() {
            return hashCode();
        }

        public int hashCode() {
            return this.zzbc;
        }
    }

    static {
        AppMethodBeat.m2504i(89384);
        AppMethodBeat.m2505o(89384);
    }

    static synchronized void init(Context context) {
        synchronized (GoogleCertificates.class) {
            AppMethodBeat.m2504i(89378);
            if (zzaz != null || context == null) {
                AppMethodBeat.m2505o(89378);
            } else {
                zzaz = context.getApplicationContext();
                AppMethodBeat.m2505o(89378);
            }
        }
    }

    static zzg zza(String str, CertData certData, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(89383);
        zzg zzg;
        try {
            zzc();
            Preconditions.checkNotNull(zzaz);
            try {
                if (zzax.isGoogleOrPlatformSigned(new GoogleCertificatesQuery(str, certData, z), ObjectWrapper.wrap(zzaz.getPackageManager()))) {
                    zzg = zzg.zzg();
                    AppMethodBeat.m2505o(89383);
                    return zzg;
                }
                if (z || !zza(str, certData, true).zzbl) {
                    z2 = false;
                }
                zzg = zzg.zza(str, certData, z, z2);
                AppMethodBeat.m2505o(89383);
                return zzg;
            } catch (RemoteException e) {
                zzg = zzg.zza("module call", e);
                AppMethodBeat.m2505o(89383);
                return zzg;
            }
        } catch (LoadingException e2) {
            zzg = zzg.zza("module init", e2);
            AppMethodBeat.m2505o(89383);
            return zzg;
        }
    }

    private static Set<ICertData> zza(IBinder[] iBinderArr) {
        AppMethodBeat.m2504i(89380);
        HashSet hashSet = new HashSet(r1);
        for (IBinder asInterface : iBinderArr) {
            ICertData asInterface2 = Stub.asInterface(asInterface);
            if (asInterface2 != null) {
                hashSet.add(asInterface2);
            }
        }
        AppMethodBeat.m2505o(89380);
        return hashSet;
    }

    private static void zzc() {
        AppMethodBeat.m2504i(89379);
        if (zzax != null) {
            AppMethodBeat.m2505o(89379);
            return;
        }
        Preconditions.checkNotNull(zzaz);
        synchronized (zzay) {
            try {
                if (zzax == null) {
                    zzax = IGoogleCertificatesApi.Stub.asInterface(DynamiteModule.load(zzaz, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(89379);
            }
        }
    }

    static synchronized Set<ICertData> zzd() {
        Set<ICertData> set;
        synchronized (GoogleCertificates.class) {
            AppMethodBeat.m2504i(89381);
            if (zzba != null) {
                set = zzba;
                AppMethodBeat.m2505o(89381);
            } else {
                try {
                    zzc();
                    try {
                        IObjectWrapper googleCertificates = zzax.getGoogleCertificates();
                        if (googleCertificates == null) {
                            set = Collections.emptySet();
                            AppMethodBeat.m2505o(89381);
                        } else {
                            zzba = zza((IBinder[]) ObjectWrapper.unwrap(googleCertificates));
                            set = zzba;
                            AppMethodBeat.m2505o(89381);
                        }
                    } catch (RemoteException e) {
                        set = Collections.emptySet();
                        AppMethodBeat.m2505o(89381);
                    }
                } catch (LoadingException e2) {
                    set = Collections.emptySet();
                    AppMethodBeat.m2505o(89381);
                }
            }
        }
        return set;
    }

    static synchronized Set<ICertData> zze() {
        Set<ICertData> set;
        synchronized (GoogleCertificates.class) {
            AppMethodBeat.m2504i(89382);
            if (zzbb != null) {
                set = zzbb;
                AppMethodBeat.m2505o(89382);
            } else {
                try {
                    zzc();
                    try {
                        IObjectWrapper googleReleaseCertificates = zzax.getGoogleReleaseCertificates();
                        if (googleReleaseCertificates == null) {
                            set = Collections.emptySet();
                            AppMethodBeat.m2505o(89382);
                        } else {
                            zzbb = zza((IBinder[]) ObjectWrapper.unwrap(googleReleaseCertificates));
                            set = zzbb;
                            AppMethodBeat.m2505o(89382);
                        }
                    } catch (RemoteException e) {
                        set = Collections.emptySet();
                        AppMethodBeat.m2505o(89382);
                    }
                } catch (LoadingException e2) {
                    set = Collections.emptySet();
                    AppMethodBeat.m2505o(89382);
                }
            }
        }
        return set;
    }
}
