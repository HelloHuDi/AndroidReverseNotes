package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AndroidUtilsLight {
    public static final String DIGEST_ALGORITHM_SHA1 = "SHA1";
    public static final String DIGEST_ALGORITHM_SHA512 = "SHA-512";

    public static MessageDigest getMessageDigest(String str) {
        AppMethodBeat.i(89994);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                try {
                    MessageDigest instance = MessageDigest.getInstance(str);
                    if (instance != null) {
                        AppMethodBeat.o(89994);
                        return instance;
                    }
                    i = i2 + 1;
                } catch (NoSuchAlgorithmException e) {
                }
            } else {
                AppMethodBeat.o(89994);
                return null;
            }
        }
    }

    public static byte[] getPackageCertificateHashBytes(Context context, String str) {
        AppMethodBeat.i(89993);
        byte[] packageCertificateHashBytes = getPackageCertificateHashBytes(context, str, DIGEST_ALGORITHM_SHA1);
        AppMethodBeat.o(89993);
        return packageCertificateHashBytes;
    }

    public static byte[] getPackageCertificateHashBytes(Context context, String str, String str2) {
        AppMethodBeat.i(89992);
        PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
        if (packageInfo.signatures != null && packageInfo.signatures.length == 1) {
            MessageDigest messageDigest = getMessageDigest(str2);
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(packageInfo.signatures[0].toByteArray());
                AppMethodBeat.o(89992);
                return digest;
            }
        }
        AppMethodBeat.o(89992);
        return null;
    }
}
