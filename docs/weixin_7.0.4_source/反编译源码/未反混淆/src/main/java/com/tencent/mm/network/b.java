package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class b {
    static a gcH;

    public interface a {
        e Rk();
    }

    public static class b {
        public int gcI = 0;
        private ArrayList<String> gcJ = new ArrayList();
        public String gcK;
        public boolean gcL = false;
        private boolean gcM = false;
        public String host = null;
        public String ip = "";
        public URL url = null;

        public b(String str) {
            AppMethodBeat.i(58450);
            this.gcK = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                ArrayList arrayList = new ArrayList();
                if (b.gcH == null || b.gcH.Rk() == null) {
                    String str2 = "MicroMsg.GprsSetting";
                    String str3 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    objArr[0] = b.gcH == null ? "-1" : b.gcH.Rk();
                    objArr[1] = bo.dpG();
                    ab.e(str2, str3, objArr);
                    AppMethodBeat.o(58450);
                    return;
                }
                this.gcI = b.gcH.Rk().getHostByName(this.host, arrayList);
                ab.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", Integer.valueOf(this.gcI), this.host, str);
                if (arrayList.size() <= 0) {
                    this.gcI = 0;
                    AppMethodBeat.o(58450);
                } else if (1 != this.gcI) {
                    AppMethodBeat.o(58450);
                } else {
                    String str4 = (String) arrayList.get((int) (bo.anU() % ((long) arrayList.size())));
                    this.ip = str4;
                    this.url = new URL(str.replaceFirst(this.host, str4));
                    AppMethodBeat.o(58450);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.GprsSetting", "exception:%s", bo.l(e));
                AppMethodBeat.o(58450);
            }
        }

        public b(String str, boolean z) {
            AppMethodBeat.i(58451);
            this.gcL = z;
            this.gcK = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                if (b.gcH == null || b.gcH.Rk() == null) {
                    String str2 = "MicroMsg.GprsSetting";
                    String str3 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    objArr[0] = b.gcH == null ? "-1" : b.gcH.Rk();
                    objArr[1] = bo.dpG();
                    ab.e(str2, str3, objArr);
                    AppMethodBeat.o(58451);
                    return;
                }
                this.gcI = b.gcH.Rk().a(this.host, z, this.gcJ);
                Random random = new Random();
                random.setSeed(bo.anU());
                Collections.shuffle(this.gcJ, random);
                ab.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", Integer.valueOf(this.gcI), this.host, str, this.gcJ);
                if (this.gcJ.size() <= 0) {
                    this.gcI = 0;
                    AppMethodBeat.o(58451);
                } else if (1 != this.gcI) {
                    AppMethodBeat.o(58451);
                } else {
                    this.ip = (String) this.gcJ.remove(0);
                    this.url = new URL(str.replaceFirst(this.host, this.ip));
                    AppMethodBeat.o(58451);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.GprsSetting", "exception:%s", bo.l(e));
                AppMethodBeat.o(58451);
            }
        }
    }

    public static void a(a aVar) {
        AppMethodBeat.i(58452);
        ab.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", Boolean.FALSE, bo.dpG());
        gcH = aVar;
        AppMethodBeat.o(58452);
    }

    public static int a(boolean z, List<String> list, String str) {
        int i = -1;
        AppMethodBeat.i(58453);
        if (gcH == null) {
            AppMethodBeat.o(58453);
        } else {
            try {
                i = gcH.Rk().a(str, z, list);
                AppMethodBeat.o(58453);
            } catch (Exception e) {
                ab.e("MicroMsg.GprsSetting", "exception:%s", bo.l(e));
                AppMethodBeat.o(58453);
            }
        }
        return i;
    }

    public static int a(String str, boolean z, List<String> list) {
        AppMethodBeat.i(58454);
        if (gcH == null || gcH.Rk() == null) {
            AppMethodBeat.o(58454);
            return -1;
        }
        int a = gcH.Rk().a(str, z, list);
        AppMethodBeat.o(58454);
        return a;
    }

    public static void reportFailIp(String str) {
        AppMethodBeat.i(58455);
        if (!(gcH == null || gcH.Rk() == null)) {
            gcH.Rk().reportFailIp(str);
        }
        AppMethodBeat.o(58455);
    }

    public static u a(String str, b bVar) {
        AppMethodBeat.i(58457);
        if (bVar == null) {
            bVar = new b(str);
        }
        ab.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", bVar.host, bVar.url, bVar.ip, Integer.valueOf(bVar.gcI));
        u uVar = new u(bVar.url, bVar.gcI);
        uVar.gdF = bVar.ip;
        if (1 == bVar.gcI) {
            uVar.setRequestProperty("Host", bVar.host);
            uVar.setRequestProperty("X-Online-Host", bVar.host);
        }
        AppMethodBeat.o(58457);
        return uVar;
    }

    public static int a(u uVar) {
        AppMethodBeat.i(58458);
        try {
            if (uVar.getResponseCode() != 200) {
                AppMethodBeat.o(58458);
                return -1;
            }
            AppMethodBeat.o(58458);
            return 0;
        } catch (Exception e) {
            ab.e("MicroMsg.GprsSetting", "exception:%s", bo.l(e));
            AppMethodBeat.o(58458);
            return -3;
        }
    }

    public static v vb(String str) {
        AppMethodBeat.i(58459);
        v vVar = new v(str);
        AppMethodBeat.o(58459);
        return vVar;
    }

    public static InputStream p(String str, int i, int i2) {
        AppMethodBeat.i(58456);
        u a = a(str, null);
        a.setConnectTimeout(i);
        a.setReadTimeout(i2);
        a.setRequestMethod("GET");
        if (a(a) != 0) {
            AppMethodBeat.o(58456);
            return null;
        }
        InputStream inputStream = a.getInputStream();
        AppMethodBeat.o(58456);
        return inputStream;
    }
}
