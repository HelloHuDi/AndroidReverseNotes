package com.tencent.d.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static List<com.tencent.d.a.a> iJ(Context context) {
        AppMethodBeat.i(114588);
        ArrayList arrayList = new ArrayList();
        try {
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(0)) {
                if (!(applicationInfo.packageName == null || applicationInfo.packageName.equals(packageName))) {
                    int i;
                    Object obj = (applicationInfo.flags & 1) != 0 ? 1 : null;
                    com.tencent.d.a.a cc = cc(context, applicationInfo.packageName);
                    cc.ArB = packageManager.getApplicationLabel(applicationInfo).toString();
                    if (cc.ArB == null) {
                        cc.ArB = "";
                    }
                    if (obj != null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    cc.egi = i;
                    cc.fileSize = new File(applicationInfo.sourceDir).length();
                    cc.ArD = applicationInfo.sourceDir;
                    arrayList.add(cc);
                    new StringBuilder("add app: ").append(applicationInfo.packageName);
                    h.dQI();
                }
            }
        } catch (Throwable th) {
            h.db("getAllAppInfos(), exception: ".concat(String.valueOf(th)));
        }
        AppMethodBeat.o(114588);
        return arrayList;
    }

    public static List<byte[]> cb(Context context, String str) {
        AppMethodBeat.i(114589);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                Signature[] signatureArr = packageInfo.signatures;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= signatureArr.length || i2 >= 5) {
                        break;
                    }
                    X509Certificate x509Certificate = (X509Certificate) a(CertificateFactory.getInstance("X.509"), signatureArr[i2]);
                    if (x509Certificate != null) {
                        arrayList.add(e.cn(x509Certificate.getEncoded()));
                    }
                    i = i2 + 1;
                }
            }
        } catch (CertificateEncodingException e) {
            h.dc("extractPkgCertMd5s(), CertificateEncodingException: ".concat(String.valueOf(e)));
        } catch (Throwable th) {
            h.dc("extractPkgCertMd5s(), Exception: ".concat(String.valueOf(th)));
        }
        AppMethodBeat.o(114589);
        return arrayList;
    }

    public static com.tencent.d.a.a cc(Context context, String str) {
        AppMethodBeat.i(114590);
        com.tencent.d.a.a aVar = new com.tencent.d.a.a();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            aVar.ceO = str;
            aVar.versionName = packageInfo.versionName;
            aVar.versionCode = packageInfo.versionCode;
            X509Certificate x509Certificate = (X509Certificate) a(CertificateFactory.getInstance("X.509"), packageInfo.signatures[0]);
            if (x509Certificate != null) {
                aVar.ArC = e.bytesToHexString(e.cn(x509Certificate.getEncoded()));
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(114590);
        return aVar;
    }

    private static Certificate a(CertificateFactory certificateFactory, Signature signature) {
        Certificate certificate;
        AppMethodBeat.i(114591);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        try {
            certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
            }
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (IOException e2) {
            }
            AppMethodBeat.o(114591);
        }
        AppMethodBeat.o(114591);
        return certificate;
    }
}
