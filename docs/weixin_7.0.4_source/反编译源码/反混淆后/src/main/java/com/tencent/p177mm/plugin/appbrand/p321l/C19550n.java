package com.tencent.p177mm.plugin.appbrand.p321l;

import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p326n.C2402a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.tencent.mm.plugin.appbrand.l.n */
public final class C19550n implements X509TrustManager {
    private LinkedList<X509TrustManager> ipi = new LinkedList();
    private LinkedList<X509TrustManager> ipj = new LinkedList();
    private KeyStore ipk;
    private int ipl;
    private List<String> ipm = null;
    private KeyStore ipn = null;
    private X509Certificate[] ipo;

    public C19550n() {
        AppMethodBeat.m2504i(108252);
        try {
            this.ipk = KeyStore.getInstance(KeyStore.getDefaultType());
            this.ipk.load(null, null);
            AppMethodBeat.m2505o(108252);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e, "Exception: Local KeyStore init failed", new Object[0]);
            AppMethodBeat.m2505o(108252);
        }
    }

    public C19550n(int i) {
        AppMethodBeat.m2504i(108253);
        this.ipl = i;
        try {
            this.ipk = KeyStore.getInstance(KeyStore.getDefaultType());
            this.ipk.load(null, null);
            AppMethodBeat.m2505o(108253);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e, "Exception: Local KeyStore init failed", new Object[0]);
            AppMethodBeat.m2505o(108253);
        }
    }

    /* renamed from: B */
    public final void mo34744B(InputStream inputStream) {
        AppMethodBeat.m2504i(108254);
        if (this.ipk == null) {
            C4990ab.m7412e("MicroMsg.AppBrandX509TrustManager", "local keystore is null");
            AppMethodBeat.m2505o(108254);
            return;
        }
        try {
            Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
            inputStream.close();
            this.ipk.setCertificateEntry(((X509Certificate) generateCertificate).getSubjectDN(), generateCertificate);
            AppMethodBeat.m2505o(108254);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e, "Exception: initLocalSelfSignedCertificate", new Object[0]);
            AppMethodBeat.m2505o(108254);
        } catch (Throwable th) {
            inputStream.close();
            AppMethodBeat.m2505o(108254);
        }
    }

    public final void init() {
        AppMethodBeat.m2504i(108255);
        aIK();
        aIL();
        aIM();
        AppMethodBeat.m2505o(108255);
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        AppMethodBeat.m2504i(108256);
        CertificateException certificateException = new CertificateException("Client Certification not supported");
        AppMethodBeat.m2505o(108256);
        throw certificateException;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x0183=Splitter:B:43:0x0183, B:87:0x0348=Splitter:B:87:0x0348, B:81:0x02ea=Splitter:B:81:0x02ea, B:75:0x028c=Splitter:B:75:0x028c} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x040d A:{Splitter:B:52:0x01d3, ExcHandler: KeyStoreException (e java.security.KeyStoreException)} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0409 A:{Splitter:B:52:0x01d3, ExcHandler: NoSuchAlgorithmException (e java.security.NoSuchAlgorithmException)} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0405 A:{Splitter:B:52:0x01d3, ExcHandler: IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x03fe A:{Splitter:B:52:0x01d3, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:94:0x03a8, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(1011, 3, 1);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108257);
     */
    /* JADX WARNING: Missing block: B:95:0x03ca, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(1011, 10, 1);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108257);
     */
    /* JADX WARNING: Missing block: B:96:0x03ea, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:98:0x03fe, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:99:0x03ff, code skipped:
            r8 = r2;
     */
    /* JADX WARNING: Missing block: B:100:0x0401, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:101:0x0402, code skipped:
            r8 = r2;
     */
    /* JADX WARNING: Missing block: B:102:0x0405, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:103:0x0406, code skipped:
            r8 = r2;
     */
    /* JADX WARNING: Missing block: B:104:0x0409, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:105:0x040a, code skipped:
            r8 = r2;
     */
    /* JADX WARNING: Missing block: B:106:0x040d, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:107:0x040e, code skipped:
            r8 = r2;
     */
    /* JADX WARNING: Missing block: B:128:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        X509TrustManager x509TrustManager;
        CertificateException e;
        Throwable e2;
        AppMethodBeat.m2504i(108257);
        Object obj = null;
        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 0, 1);
        C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "trust manager size:" + this.ipi.size());
        Iterator it = this.ipi.iterator();
        while (it.hasNext()) {
            x509TrustManager = (X509TrustManager) it.next();
            try {
                C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "try system trust:" + x509TrustManager.toString());
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "system trust:" + x509TrustManager.toString());
                obj = 1;
                break;
            } catch (CertificateException e3) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e3, "CertificateException: SystemTrustManagers checkServerTrusted", new Object[0]);
                obj = null;
            }
        }
        if (obj != null) {
            C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted systemTrusted true");
            ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 1, 1);
            AppMethodBeat.m2505o(108257);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppBrandX509TrustManager", "try local trust size:%d", Integer.valueOf(this.ipj.size()));
        obj = null;
        it = this.ipj.iterator();
        while (it.hasNext()) {
            x509TrustManager = (X509TrustManager) it.next();
            try {
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "local trust:" + x509TrustManager.toString());
                obj = 1;
                break;
            } catch (CertificateException e32) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e32, "CertificateException: LocalTrustManagers checkServerTrusted", new Object[0]);
                obj = null;
            }
        }
        if (obj != null) {
            C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted localTrusted true");
            ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 2, 1);
            AppMethodBeat.m2505o(108257);
            return;
        }
        if (this.ipl == 1 || this.ipl == 2) {
            C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted debug type");
            Object obj2 = null;
            try {
                String str2;
                Object obj3;
                if (this.ipn == null) {
                    this.ipn = KeyStore.getInstance("AndroidCAStore");
                    this.ipn.load(null, null);
                }
                if (this.ipm == null) {
                    this.ipm = new ArrayList();
                    Enumeration aliases = this.ipn.aliases();
                    while (aliases.hasMoreElements()) {
                        str2 = (String) aliases.nextElement();
                        if (str2 != null && str2.startsWith("user:")) {
                            this.ipm.add(str2);
                        }
                    }
                }
                if (this.ipm.size() > 0) {
                    obj3 = null;
                    for (String str22 : this.ipm) {
                        int i;
                        int i2;
                        try {
                            X509Certificate x509Certificate = (X509Certificate) this.ipn.getCertificate(str22);
                            i = 0;
                            while (true) {
                                i2 = i;
                                if (i2 >= x509CertificateArr.length) {
                                    break;
                                }
                                x509CertificateArr[i2].verify(x509Certificate.getPublicKey());
                                obj3 = 1;
                                break;
                            }
                        } catch (Exception e4) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e4, "Exception: check user verify certificate", new Object[0]);
                            i = i2 + 1;
                        } catch (KeyStoreException e5) {
                        } catch (NoSuchAlgorithmException e6) {
                        } catch (IOException e7) {
                        } catch (Throwable th) {
                        }
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check aliasList null");
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 9, 1);
                    obj3 = null;
                }
                if (obj3 != null) {
                    C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 3, 1);
                    AppMethodBeat.m2505o(108257);
                    return;
                }
                C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 10, 1);
            } catch (KeyStoreException e8) {
                e2 = e8;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e2, "KeyStoreException: check user certificate", new Object[0]);
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 5, 1);
                    if (obj2 == null) {
                        C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 3, 1);
                        AppMethodBeat.m2505o(108257);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 10, 1);
                    e32 = new CertificateException("Server Certificate not trusted");
                    AppMethodBeat.m2505o(108257);
                    throw e32;
                } catch (Throwable th2) {
                    e2 = th2;
                    if (obj2 == null) {
                    }
                }
            } catch (NoSuchAlgorithmException e9) {
                e2 = e9;
                C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e2, "NoSuchAlgorithmException: check user certificate", new Object[0]);
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 6, 1);
                if (obj2 == null) {
                    C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 3, 1);
                    AppMethodBeat.m2505o(108257);
                    return;
                }
                C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 10, 1);
                e32 = new CertificateException("Server Certificate not trusted");
                AppMethodBeat.m2505o(108257);
                throw e32;
            } catch (IOException e10) {
                e2 = e10;
                C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e2, "IOException: check user certificate", new Object[0]);
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 7, 1);
                if (obj2 == null) {
                    C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 3, 1);
                    AppMethodBeat.m2505o(108257);
                    return;
                }
                C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 10, 1);
                e32 = new CertificateException("Server Certificate not trusted");
                AppMethodBeat.m2505o(108257);
                throw e32;
            } catch (Exception e11) {
                e2 = e11;
                C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e2, "Exception: check user certificate", new Object[0]);
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 8, 1);
                if (obj2 == null) {
                    C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 3, 1);
                    AppMethodBeat.m2505o(108257);
                    return;
                }
                C4990ab.m7416i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 10, 1);
                e32 = new CertificateException("Server Certificate not trusted");
                AppMethodBeat.m2505o(108257);
                throw e32;
            }
        }
        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(1011, 4, 1);
        e32 = new CertificateException("Server Certificate not trusted");
        AppMethodBeat.m2505o(108257);
        throw e32;
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.ipo;
    }

    private void aIK() {
        AppMethodBeat.m2504i(108258);
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            int i = 0;
            while (trustManagers != null && i < trustManagers.length) {
                this.ipi.add((X509TrustManager) trustManagers[i]);
                i++;
            }
            AppMethodBeat.m2505o(108258);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e, "Exception: init SystemTrustManager", new Object[0]);
            AppMethodBeat.m2505o(108258);
        }
    }

    private void aIL() {
        AppMethodBeat.m2504i(108259);
        if (this.ipk == null) {
            AppMethodBeat.m2505o(108259);
            return;
        }
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(this.ipk);
            TrustManager[] trustManagers = instance.getTrustManagers();
            int i = 0;
            while (trustManagers != null && i < trustManagers.length) {
                this.ipj.add((X509TrustManager) trustManagers[i]);
                i++;
            }
            AppMethodBeat.m2505o(108259);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e, "Exception: init LocalTrustManager", new Object[0]);
            AppMethodBeat.m2505o(108259);
        }
    }

    private void aIM() {
        X509Certificate[] acceptedIssuers;
        AppMethodBeat.m2504i(108260);
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = this.ipi.iterator();
        while (it.hasNext()) {
            acceptedIssuers = ((X509TrustManager) it.next()).getAcceptedIssuers();
            if (acceptedIssuers != null) {
                arrayList.addAll(Arrays.asList(acceptedIssuers));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Iterator it2 = this.ipj.iterator();
        while (it2.hasNext()) {
            acceptedIssuers = ((X509TrustManager) it2.next()).getAcceptedIssuers();
            if (acceptedIssuers != null) {
                arrayList.addAll(Arrays.asList(acceptedIssuers));
            }
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        this.ipo = new X509Certificate[arrayList.size()];
        this.ipo = (X509Certificate[]) arrayList.toArray(this.ipo);
        long currentTimeMillis4 = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.AppBrandX509TrustManager", "initAcceptedIssuers: %d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3));
        AppMethodBeat.m2505o(108260);
    }
}
