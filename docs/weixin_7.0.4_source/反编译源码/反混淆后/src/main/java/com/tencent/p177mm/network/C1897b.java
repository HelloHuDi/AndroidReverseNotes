package com.tencent.p177mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* renamed from: com.tencent.mm.network.b */
public final class C1897b {
    static C1895a gcH;

    /* renamed from: com.tencent.mm.network.b$a */
    public interface C1895a {
        /* renamed from: Rk */
        C1902e mo5191Rk();
    }

    /* renamed from: com.tencent.mm.network.b$b */
    public static class C1896b {
        public int gcI = 0;
        private ArrayList<String> gcJ = new ArrayList();
        public String gcK;
        public boolean gcL = false;
        private boolean gcM = false;
        public String host = null;
        /* renamed from: ip */
        public String f1239ip = "";
        public URL url = null;

        public C1896b(String str) {
            AppMethodBeat.m2504i(58450);
            this.gcK = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                ArrayList arrayList = new ArrayList();
                if (C1897b.gcH == null || C1897b.gcH.mo5191Rk() == null) {
                    String str2 = "MicroMsg.GprsSetting";
                    String str3 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    objArr[0] = C1897b.gcH == null ? "-1" : C1897b.gcH.mo5191Rk();
                    objArr[1] = C5046bo.dpG();
                    C4990ab.m7413e(str2, str3, objArr);
                    AppMethodBeat.m2505o(58450);
                    return;
                }
                this.gcI = C1897b.gcH.mo5191Rk().getHostByName(this.host, arrayList);
                C4990ab.m7411d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", Integer.valueOf(this.gcI), this.host, str);
                if (arrayList.size() <= 0) {
                    this.gcI = 0;
                    AppMethodBeat.m2505o(58450);
                } else if (1 != this.gcI) {
                    AppMethodBeat.m2505o(58450);
                } else {
                    String str4 = (String) arrayList.get((int) (C5046bo.anU() % ((long) arrayList.size())));
                    this.f1239ip = str4;
                    this.url = new URL(str.replaceFirst(this.host, str4));
                    AppMethodBeat.m2505o(58450);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GprsSetting", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(58450);
            }
        }

        public C1896b(String str, boolean z) {
            AppMethodBeat.m2504i(58451);
            this.gcL = z;
            this.gcK = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                if (C1897b.gcH == null || C1897b.gcH.mo5191Rk() == null) {
                    String str2 = "MicroMsg.GprsSetting";
                    String str3 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    objArr[0] = C1897b.gcH == null ? "-1" : C1897b.gcH.mo5191Rk();
                    objArr[1] = C5046bo.dpG();
                    C4990ab.m7413e(str2, str3, objArr);
                    AppMethodBeat.m2505o(58451);
                    return;
                }
                this.gcI = C1897b.gcH.mo5191Rk().mo5519a(this.host, z, this.gcJ);
                Random random = new Random();
                random.setSeed(C5046bo.anU());
                Collections.shuffle(this.gcJ, random);
                C4990ab.m7411d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", Integer.valueOf(this.gcI), this.host, str, this.gcJ);
                if (this.gcJ.size() <= 0) {
                    this.gcI = 0;
                    AppMethodBeat.m2505o(58451);
                } else if (1 != this.gcI) {
                    AppMethodBeat.m2505o(58451);
                } else {
                    this.f1239ip = (String) this.gcJ.remove(0);
                    this.url = new URL(str.replaceFirst(this.host, this.f1239ip));
                    AppMethodBeat.m2505o(58451);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GprsSetting", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(58451);
            }
        }
    }

    /* renamed from: a */
    public static void m4021a(C1895a c1895a) {
        AppMethodBeat.m2504i(58452);
        C4990ab.m7417i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", Boolean.FALSE, C5046bo.dpG());
        gcH = c1895a;
        AppMethodBeat.m2505o(58452);
    }

    /* renamed from: a */
    public static int m4019a(boolean z, List<String> list, String str) {
        int i = -1;
        AppMethodBeat.m2504i(58453);
        if (gcH == null) {
            AppMethodBeat.m2505o(58453);
        } else {
            try {
                i = gcH.mo5191Rk().mo5519a(str, z, list);
                AppMethodBeat.m2505o(58453);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GprsSetting", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(58453);
            }
        }
        return i;
    }

    /* renamed from: a */
    public static int m4018a(String str, boolean z, List<String> list) {
        AppMethodBeat.m2504i(58454);
        if (gcH == null || gcH.mo5191Rk() == null) {
            AppMethodBeat.m2505o(58454);
            return -1;
        }
        int a = gcH.mo5191Rk().mo5519a(str, z, list);
        AppMethodBeat.m2505o(58454);
        return a;
    }

    public static void reportFailIp(String str) {
        AppMethodBeat.m2504i(58455);
        if (!(gcH == null || gcH.mo5191Rk() == null)) {
            gcH.mo5191Rk().reportFailIp(str);
        }
        AppMethodBeat.m2505o(58455);
    }

    /* renamed from: a */
    public static C1936u m4020a(String str, C1896b c1896b) {
        AppMethodBeat.m2504i(58457);
        if (c1896b == null) {
            c1896b = new C1896b(str);
        }
        C4990ab.m7417i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", c1896b.host, c1896b.url, c1896b.f1239ip, Integer.valueOf(c1896b.gcI));
        C1936u c1936u = new C1936u(c1896b.url, c1896b.gcI);
        c1936u.gdF = c1896b.f1239ip;
        if (1 == c1896b.gcI) {
            c1936u.setRequestProperty("Host", c1896b.host);
            c1936u.setRequestProperty("X-Online-Host", c1896b.host);
        }
        AppMethodBeat.m2505o(58457);
        return c1936u;
    }

    /* renamed from: a */
    public static int m4017a(C1936u c1936u) {
        AppMethodBeat.m2504i(58458);
        try {
            if (c1936u.getResponseCode() != 200) {
                AppMethodBeat.m2505o(58458);
                return -1;
            }
            AppMethodBeat.m2505o(58458);
            return 0;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.GprsSetting", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58458);
            return -3;
        }
    }

    /* renamed from: vb */
    public static C1937v m4023vb(String str) {
        AppMethodBeat.m2504i(58459);
        C1937v c1937v = new C1937v(str);
        AppMethodBeat.m2505o(58459);
        return c1937v;
    }

    /* renamed from: p */
    public static InputStream m4022p(String str, int i, int i2) {
        AppMethodBeat.m2504i(58456);
        C1936u a = C1897b.m4020a(str, null);
        a.setConnectTimeout(i);
        a.setReadTimeout(i2);
        a.setRequestMethod("GET");
        if (C1897b.m4017a(a) != 0) {
            AppMethodBeat.m2505o(58456);
            return null;
        }
        InputStream inputStream = a.getInputStream();
        AppMethodBeat.m2505o(58456);
        return inputStream;
    }
}
