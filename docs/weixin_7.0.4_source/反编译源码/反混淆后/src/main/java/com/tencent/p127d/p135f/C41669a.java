package com.tencent.p127d.p135f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p1164a.C41659a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.d.f.a */
public final class C41669a {
    /* renamed from: iJ */
    public static List<C41659a> m73071iJ(Context context) {
        AppMethodBeat.m2504i(114588);
        ArrayList arrayList = new ArrayList();
        try {
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(0)) {
                if (!(applicationInfo.packageName == null || applicationInfo.packageName.equals(packageName))) {
                    int i;
                    Object obj = (applicationInfo.flags & 1) != 0 ? 1 : null;
                    C41659a cc = C41669a.m73070cc(context, applicationInfo.packageName);
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
                    C45085h.dQI();
                }
            }
        } catch (Throwable th) {
            C45085h.m82711db("getAllAppInfos(), exception: ".concat(String.valueOf(th)));
        }
        AppMethodBeat.m2505o(114588);
        return arrayList;
    }

    /* renamed from: cb */
    public static List<byte[]> m73069cb(Context context, String str) {
        AppMethodBeat.m2504i(114589);
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
                    X509Certificate x509Certificate = (X509Certificate) C41669a.m73068a(CertificateFactory.getInstance("X.509"), signatureArr[i2]);
                    if (x509Certificate != null) {
                        arrayList.add(C8769e.m15600cn(x509Certificate.getEncoded()));
                    }
                    i = i2 + 1;
                }
            }
        } catch (CertificateEncodingException e) {
            C45085h.m82712dc("extractPkgCertMd5s(), CertificateEncodingException: ".concat(String.valueOf(e)));
        } catch (Throwable th) {
            C45085h.m82712dc("extractPkgCertMd5s(), Exception: ".concat(String.valueOf(th)));
        }
        AppMethodBeat.m2505o(114589);
        return arrayList;
    }

    /* renamed from: cc */
    public static C41659a m73070cc(Context context, String str) {
        AppMethodBeat.m2504i(114590);
        C41659a c41659a = new C41659a();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            c41659a.ceO = str;
            c41659a.versionName = packageInfo.versionName;
            c41659a.versionCode = packageInfo.versionCode;
            X509Certificate x509Certificate = (X509Certificate) C41669a.m73068a(CertificateFactory.getInstance("X.509"), packageInfo.signatures[0]);
            if (x509Certificate != null) {
                c41659a.ArC = C8769e.bytesToHexString(C8769e.m15600cn(x509Certificate.getEncoded()));
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(114590);
        return c41659a;
    }

    /* renamed from: a */
    private static Certificate m73068a(CertificateFactory certificateFactory, Signature signature) {
        Certificate certificate;
        AppMethodBeat.m2504i(114591);
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
            AppMethodBeat.m2505o(114591);
        }
        AppMethodBeat.m2505o(114591);
        return certificate;
    }
}
