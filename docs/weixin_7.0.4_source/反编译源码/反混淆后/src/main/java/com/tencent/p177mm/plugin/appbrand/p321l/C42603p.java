package com.tencent.p177mm.plugin.appbrand.p321l;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.DiscoveryListener;
import android.net.nsd.NsdManager.ResolveListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.l.p */
public enum C42603p {
    ;
    
    public final Map<C38415b, DiscoveryListener> ipq;

    /* renamed from: com.tencent.mm.plugin.appbrand.l.p$2 */
    public class C195512 implements Runnable {
        final /* synthetic */ C42605c ipu;
        final /* synthetic */ C42604a ipv;

        public C195512(C42605c c42605c, C42604a c42604a) {
            this.ipu = c42605c;
            this.ipv = c42604a;
        }

        public final void run() {
            AppMethodBeat.m2504i(108269);
            C4990ab.m7416i("MicroMsg.LocalServiceMgr", "start reslove " + this.ipu.ipz);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceName(this.ipu.ipz);
            nsdServiceInfo.setServiceType(this.ipu.ipA);
            C42603p.aIO().resolveService(nsdServiceInfo, new ResolveListener() {
                public final void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i) {
                    AppMethodBeat.m2504i(108267);
                    C195512.this.ipv.mo44703c(new C42605c(nsdServiceInfo));
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(108267);
                }

                public final void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
                    AppMethodBeat.m2504i(108268);
                    C195512.this.ipv.mo44704d(new C42605c(nsdServiceInfo));
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(108268);
                }
            });
            try {
                countDownLatch.await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("LocalServiceMgr", e, "", new Object[0]);
            }
            C4990ab.m7416i("MicroMsg.LocalServiceMgr", "finish reslove " + this.ipu.ipz + " trhead id=" + Thread.currentThread().getId());
            AppMethodBeat.m2505o(108269);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.l.p$1 */
    public class C334251 implements DiscoveryListener {
        final /* synthetic */ C38415b ips;

        public C334251(C38415b c38415b) {
            this.ips = c38415b;
        }

        public final void onStartDiscoveryFailed(String str, int i) {
            AppMethodBeat.m2504i(108261);
            this.ips.aEp();
            C4990ab.m7416i("MicroMsg.LocalServiceMgr", "onStartDiscoveryFailed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(108261);
        }

        public final void onStopDiscoveryFailed(String str, int i) {
            AppMethodBeat.m2504i(108262);
            this.ips.aEq();
            C4990ab.m7416i("MicroMsg.LocalServiceMgr", "onStopDiscoveryFailed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(108262);
        }

        public final void onDiscoveryStarted(String str) {
            AppMethodBeat.m2504i(108263);
            this.ips.aEr();
            C4990ab.m7416i("MicroMsg.LocalServiceMgr", "onDiscoveryStarted ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(108263);
        }

        public final void onDiscoveryStopped(String str) {
            AppMethodBeat.m2504i(108264);
            this.ips.aEs();
            C4990ab.m7416i("MicroMsg.LocalServiceMgr", "onDiscoveryStopped ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(108264);
        }

        public final void onServiceFound(NsdServiceInfo nsdServiceInfo) {
            AppMethodBeat.m2504i(108265);
            this.ips.mo44697a(new C42605c(nsdServiceInfo));
            C4990ab.m7416i("MicroMsg.LocalServiceMgr", "onServicesFound " + nsdServiceInfo.getServiceType());
            AppMethodBeat.m2505o(108265);
        }

        public final void onServiceLost(NsdServiceInfo nsdServiceInfo) {
            AppMethodBeat.m2504i(108266);
            this.ips.mo44702b(new C42605c(nsdServiceInfo));
            C4990ab.m7416i("MicroMsg.LocalServiceMgr", "onServiceLost " + nsdServiceInfo.getServiceType());
            AppMethodBeat.m2505o(108266);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.l.p$b */
    public interface C38415b {
        /* renamed from: a */
        void mo44697a(C42605c c42605c);

        void aEp();

        void aEq();

        void aEr();

        void aEs();

        /* renamed from: b */
        void mo44702b(C42605c c42605c);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.l.p$a */
    public interface C42604a {
        /* renamed from: c */
        void mo44703c(C42605c c42605c);

        /* renamed from: d */
        void mo44704d(C42605c c42605c);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.l.p$c */
    public static class C42605c {
        /* renamed from: ip */
        public String f17184ip;
        public String ipA;
        public Map<String, String> ipy;
        public String ipz;
        public int port;

        C42605c(NsdServiceInfo nsdServiceInfo) {
            Map attributes;
            AppMethodBeat.m2504i(108270);
            this.ipy = new HashMap();
            InetAddress host = nsdServiceInfo.getHost();
            if (host != null) {
                this.f17184ip = host.getHostAddress();
            }
            this.port = nsdServiceInfo.getPort();
            this.ipz = nsdServiceInfo.getServiceName();
            this.ipA = nsdServiceInfo.getServiceType();
            if (VERSION.SDK_INT >= 21) {
                attributes = nsdServiceInfo.getAttributes();
            } else {
                attributes = null;
            }
            if (attributes != null) {
                for (String str : attributes.keySet()) {
                    byte[] bArr = (byte[]) attributes.get(str);
                    if (bArr != null) {
                        this.ipy.put(str, new String(Base64.encode(bArr, 2)));
                    }
                }
            }
            AppMethodBeat.m2505o(108270);
        }

        public C42605c() {
            AppMethodBeat.m2504i(108271);
            this.ipy = new HashMap();
            AppMethodBeat.m2505o(108271);
        }
    }

    private C42603p(String str) {
        AppMethodBeat.m2504i(108274);
        this.ipq = new ConcurrentHashMap();
        AppMethodBeat.m2505o(108274);
    }

    static {
        AppMethodBeat.m2505o(108278);
    }

    /* renamed from: a */
    public final void mo68039a(C38415b c38415b) {
        AppMethodBeat.m2504i(108275);
        synchronized (this.ipq) {
            try {
                if (this.ipq.containsKey(c38415b)) {
                    C42603p.aIN().stopServiceDiscovery((DiscoveryListener) this.ipq.get(c38415b));
                    this.ipq.remove(c38415b);
                    AppMethodBeat.m2505o(108275);
                    return;
                }
                AppMethodBeat.m2505o(108275);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(108275);
            }
        }
    }

    public static NsdManager aIN() {
        AppMethodBeat.m2504i(108276);
        NsdManager nsdManager = (NsdManager) C4996ah.getContext().getSystemService("servicediscovery");
        AppMethodBeat.m2505o(108276);
        return nsdManager;
    }
}
