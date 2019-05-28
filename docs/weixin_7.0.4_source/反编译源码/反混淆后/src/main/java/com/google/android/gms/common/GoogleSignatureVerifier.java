package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zzbv;
    private final Context mContext;

    private GoogleSignatureVerifier(Context context) {
        AppMethodBeat.m2504i(89419);
        this.mContext = context.getApplicationContext();
        AppMethodBeat.m2505o(89419);
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        AppMethodBeat.m2504i(89420);
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (zzbv == null) {
                    GoogleCertificates.init(context);
                    zzbv = new GoogleSignatureVerifier(context);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(89420);
            }
        }
        GoogleSignatureVerifier googleSignatureVerifier = zzbv;
        return googleSignatureVerifier;
    }

    @VisibleForTesting
    public static synchronized void resetForTests() {
        synchronized (GoogleSignatureVerifier.class) {
            zzbv = null;
        }
    }

    private static CertData zza(PackageInfo packageInfo, CertData... certDataArr) {
        int i = 0;
        AppMethodBeat.m2504i(89439);
        if (packageInfo.signatures == null) {
            AppMethodBeat.m2505o(89439);
            return null;
        } else if (packageInfo.signatures.length != 1) {
            AppMethodBeat.m2505o(89439);
            return null;
        } else {
            zzb zzb = new zzb(packageInfo.signatures[0].toByteArray());
            while (i < certDataArr.length) {
                if (certDataArr[i].equals(zzb)) {
                    CertData certData = certDataArr[i];
                    AppMethodBeat.m2505o(89439);
                    return certData;
                }
                i++;
            }
            AppMethodBeat.m2505o(89439);
            return null;
        }
    }

    private final zzg zza(PackageInfo packageInfo) {
        AppMethodBeat.m2504i(89438);
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
        zzg zze;
        if (packageInfo == null) {
            zze = zzg.zze("null pkg");
            AppMethodBeat.m2505o(89438);
            return zze;
        } else if (packageInfo.signatures.length != 1) {
            zze = zzg.zze("single cert required");
            AppMethodBeat.m2505o(89438);
            return zze;
        } else {
            zzb zzb = new zzb(packageInfo.signatures[0].toByteArray());
            String str = packageInfo.packageName;
            zze = GoogleCertificates.zza(str, zzb, honorsDebugCertificates);
            if (!zze.zzbl || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || (honorsDebugCertificates && !GoogleCertificates.zza(str, zzb, false).zzbl)) {
                AppMethodBeat.m2505o(89438);
                return zze;
            }
            zze = zzg.zze("debuggable release cert app rejected");
            AppMethodBeat.m2505o(89438);
            return zze;
        }
    }

    private final zzg zzb(int i) {
        AppMethodBeat.m2504i(89436);
        String[] packagesForUid = Wrappers.packageManager(this.mContext).getPackagesForUid(i);
        zzg zze;
        if (packagesForUid == null || packagesForUid.length == 0) {
            zze = zzg.zze("no pkgs");
            AppMethodBeat.m2505o(89436);
            return zze;
        }
        zze = null;
        for (String zzf : packagesForUid) {
            zze = zzf(zzf);
            if (zze.zzbl) {
                AppMethodBeat.m2505o(89436);
                return zze;
            }
        }
        AppMethodBeat.m2505o(89436);
        return zze;
    }

    private final zzg zzf(String str) {
        AppMethodBeat.m2504i(89437);
        zzg zza;
        try {
            zza = zza(Wrappers.packageManager(this.mContext).getPackageInfo(str, 64));
            AppMethodBeat.m2505o(89437);
            return zza;
        } catch (NameNotFoundException e) {
            String str2 = "no pkg ";
            String valueOf = String.valueOf(str);
            zza = zzg.zze(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            AppMethodBeat.m2505o(89437);
            return zza;
        }
    }

    @Deprecated
    public Set<byte[]> getAllGoogleSignatures(boolean z) {
        AppMethodBeat.m2504i(89431);
        Set<ICertData> zzd = z ? GoogleCertificates.zzd() : GoogleCertificates.zze();
        HashSet hashSet = new HashSet(zzd.size());
        try {
            for (ICertData bytesWrapped : zzd) {
                hashSet.add((byte[]) ObjectWrapper.unwrap(bytesWrapped.getBytesWrapped()));
            }
        } catch (RemoteException e) {
        }
        AppMethodBeat.m2505o(89431);
        return hashSet;
    }

    public boolean isChimeraSigned(PackageManager packageManager, PackageInfo packageInfo) {
        AppMethodBeat.m2504i(89435);
        String str = packageInfo.packageName;
        packageInfo.packageName = ProviderConstants.API_PROVIDER_NAME;
        boolean isPackageGoogleSigned = isPackageGoogleSigned(packageInfo);
        packageInfo.packageName = str;
        AppMethodBeat.m2505o(89435);
        return isPackageGoogleSigned;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        AppMethodBeat.m2504i(89434);
        if (packageInfo == null) {
            AppMethodBeat.m2505o(89434);
            return false;
        } else if (isGooglePublicSignedPackage(packageInfo, false)) {
            AppMethodBeat.m2505o(89434);
            return true;
        } else if (isGooglePublicSignedPackage(packageInfo, true) && GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext)) {
            AppMethodBeat.m2505o(89434);
            return true;
        } else {
            AppMethodBeat.m2505o(89434);
            return false;
        }
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo, boolean z) {
        AppMethodBeat.m2504i(89432);
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            CertData zza;
            if (z) {
                zza = zza(packageInfo, zzd.zzbg);
            } else {
                zza = zza(packageInfo, zzd.zzbg[0]);
            }
            if (zza != null) {
                AppMethodBeat.m2505o(89432);
                return true;
            }
        }
        AppMethodBeat.m2505o(89432);
        return false;
    }

    @Deprecated
    public boolean isGooglePublicSignedPackage(PackageManager packageManager, PackageInfo packageInfo) {
        AppMethodBeat.m2504i(89433);
        boolean isGooglePublicSignedPackage = isGooglePublicSignedPackage(packageInfo);
        AppMethodBeat.m2505o(89433);
        return isGooglePublicSignedPackage;
    }

    public boolean isPackageGoogleSigned(PackageInfo packageInfo) {
        AppMethodBeat.m2504i(89430);
        zzg zza = zza(packageInfo);
        zza.zzi();
        boolean z = zza.zzbl;
        AppMethodBeat.m2505o(89430);
        return z;
    }

    @Deprecated
    public boolean isPackageGoogleSigned(PackageManager packageManager, PackageInfo packageInfo) {
        AppMethodBeat.m2504i(89429);
        boolean isPackageGoogleSigned = isPackageGoogleSigned(packageInfo);
        AppMethodBeat.m2505o(89429);
        return isPackageGoogleSigned;
    }

    @Deprecated
    public boolean isPackageGoogleSigned(PackageManager packageManager, String str) {
        AppMethodBeat.m2504i(89427);
        boolean isPackageGoogleSigned = isPackageGoogleSigned(str);
        AppMethodBeat.m2505o(89427);
        return isPackageGoogleSigned;
    }

    public boolean isPackageGoogleSigned(String str) {
        AppMethodBeat.m2504i(89428);
        zzg zzf = zzf(str);
        zzf.zzi();
        boolean z = zzf.zzbl;
        AppMethodBeat.m2505o(89428);
        return z;
    }

    public boolean isUidGoogleSigned(int i) {
        AppMethodBeat.m2504i(89424);
        zzg zzb = zzb(i);
        zzb.zzi();
        boolean z = zzb.zzbl;
        AppMethodBeat.m2505o(89424);
        return z;
    }

    @Deprecated
    public boolean isUidGoogleSigned(PackageManager packageManager, int i) {
        AppMethodBeat.m2504i(89423);
        boolean isUidGoogleSigned = isUidGoogleSigned(i);
        AppMethodBeat.m2505o(89423);
        return isUidGoogleSigned;
    }

    @Deprecated
    public void verifyPackageIsGoogleSigned(PackageManager packageManager, String str) {
        AppMethodBeat.m2504i(89425);
        verifyPackageIsGoogleSigned(str);
        AppMethodBeat.m2505o(89425);
    }

    public void verifyPackageIsGoogleSigned(String str) {
        AppMethodBeat.m2504i(89426);
        zzf(str).zzh();
        AppMethodBeat.m2505o(89426);
    }

    public void verifyUidIsGoogleSigned(int i) {
        AppMethodBeat.m2504i(89422);
        zzb(i).zzh();
        AppMethodBeat.m2505o(89422);
    }

    @Deprecated
    public void verifyUidIsGoogleSigned(PackageManager packageManager, int i) {
        AppMethodBeat.m2504i(89421);
        verifyUidIsGoogleSigned(i);
        AppMethodBeat.m2505o(89421);
    }
}
