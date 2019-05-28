package com.tencent.mm.plugin.appbrand.l;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.DiscoveryListener;
import android.net.nsd.NsdManager.ResolveListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public enum p {
    ;
    
    public final Map<b, DiscoveryListener> ipq;

    /* renamed from: com.tencent.mm.plugin.appbrand.l.p$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ c ipu;
        final /* synthetic */ a ipv;

        public AnonymousClass2(c cVar, a aVar) {
            this.ipu = cVar;
            this.ipv = aVar;
        }

        public final void run() {
            AppMethodBeat.i(108269);
            ab.i("MicroMsg.LocalServiceMgr", "start reslove " + this.ipu.ipz);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceName(this.ipu.ipz);
            nsdServiceInfo.setServiceType(this.ipu.ipA);
            p.aIO().resolveService(nsdServiceInfo, new ResolveListener() {
                public final void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i) {
                    AppMethodBeat.i(108267);
                    AnonymousClass2.this.ipv.c(new c(nsdServiceInfo));
                    countDownLatch.countDown();
                    AppMethodBeat.o(108267);
                }

                public final void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
                    AppMethodBeat.i(108268);
                    AnonymousClass2.this.ipv.d(new c(nsdServiceInfo));
                    countDownLatch.countDown();
                    AppMethodBeat.o(108268);
                }
            });
            try {
                countDownLatch.await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                ab.printErrStackTrace("LocalServiceMgr", e, "", new Object[0]);
            }
            ab.i("MicroMsg.LocalServiceMgr", "finish reslove " + this.ipu.ipz + " trhead id=" + Thread.currentThread().getId());
            AppMethodBeat.o(108269);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.l.p$1 */
    public class AnonymousClass1 implements DiscoveryListener {
        final /* synthetic */ b ips;

        public AnonymousClass1(b bVar) {
            this.ips = bVar;
        }

        public final void onStartDiscoveryFailed(String str, int i) {
            AppMethodBeat.i(108261);
            this.ips.aEp();
            ab.i("MicroMsg.LocalServiceMgr", "onStartDiscoveryFailed ".concat(String.valueOf(str)));
            AppMethodBeat.o(108261);
        }

        public final void onStopDiscoveryFailed(String str, int i) {
            AppMethodBeat.i(108262);
            this.ips.aEq();
            ab.i("MicroMsg.LocalServiceMgr", "onStopDiscoveryFailed ".concat(String.valueOf(str)));
            AppMethodBeat.o(108262);
        }

        public final void onDiscoveryStarted(String str) {
            AppMethodBeat.i(108263);
            this.ips.aEr();
            ab.i("MicroMsg.LocalServiceMgr", "onDiscoveryStarted ".concat(String.valueOf(str)));
            AppMethodBeat.o(108263);
        }

        public final void onDiscoveryStopped(String str) {
            AppMethodBeat.i(108264);
            this.ips.aEs();
            ab.i("MicroMsg.LocalServiceMgr", "onDiscoveryStopped ".concat(String.valueOf(str)));
            AppMethodBeat.o(108264);
        }

        public final void onServiceFound(NsdServiceInfo nsdServiceInfo) {
            AppMethodBeat.i(108265);
            this.ips.a(new c(nsdServiceInfo));
            ab.i("MicroMsg.LocalServiceMgr", "onServicesFound " + nsdServiceInfo.getServiceType());
            AppMethodBeat.o(108265);
        }

        public final void onServiceLost(NsdServiceInfo nsdServiceInfo) {
            AppMethodBeat.i(108266);
            this.ips.b(new c(nsdServiceInfo));
            ab.i("MicroMsg.LocalServiceMgr", "onServiceLost " + nsdServiceInfo.getServiceType());
            AppMethodBeat.o(108266);
        }
    }

    public interface b {
        void a(c cVar);

        void aEp();

        void aEq();

        void aEr();

        void aEs();

        void b(c cVar);
    }

    public interface a {
        void c(c cVar);

        void d(c cVar);
    }

    public static class c {
        public String ip;
        public String ipA;
        public Map<String, String> ipy;
        public String ipz;
        public int port;

        c(NsdServiceInfo nsdServiceInfo) {
            Map attributes;
            AppMethodBeat.i(108270);
            this.ipy = new HashMap();
            InetAddress host = nsdServiceInfo.getHost();
            if (host != null) {
                this.ip = host.getHostAddress();
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
            AppMethodBeat.o(108270);
        }

        public c() {
            AppMethodBeat.i(108271);
            this.ipy = new HashMap();
            AppMethodBeat.o(108271);
        }
    }

    private p(String str) {
        AppMethodBeat.i(108274);
        this.ipq = new ConcurrentHashMap();
        AppMethodBeat.o(108274);
    }

    static {
        AppMethodBeat.o(108278);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(108275);
        synchronized (this.ipq) {
            try {
                if (this.ipq.containsKey(bVar)) {
                    aIN().stopServiceDiscovery((DiscoveryListener) this.ipq.get(bVar));
                    this.ipq.remove(bVar);
                    AppMethodBeat.o(108275);
                    return;
                }
                AppMethodBeat.o(108275);
            } catch (Throwable th) {
                AppMethodBeat.o(108275);
            }
        }
    }

    public static NsdManager aIN() {
        AppMethodBeat.i(108276);
        NsdManager nsdManager = (NsdManager) ah.getContext().getSystemService("servicediscovery");
        AppMethodBeat.o(108276);
        return nsdManager;
    }
}
