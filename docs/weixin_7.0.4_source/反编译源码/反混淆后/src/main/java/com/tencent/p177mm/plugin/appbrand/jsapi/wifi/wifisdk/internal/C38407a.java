package com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.C10565a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a */
public final class C38407a {
    public boolean idA = false;
    public boolean ide = false;
    public BroadcastReceiver idf = null;
    public String idi;
    public String idj;
    private C10565a ids;
    public Context idt;
    C19529a idu = null;
    C38408b idv = null;
    public WifiConfiguration idw = null;
    ConnectivityManager idx;
    private int idy = 0;
    private final int idz = 13000;
    public Handler mHandler = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a$a */
    class C19529a implements InvocationHandler {
        C19529a() {
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.m2504i(94390);
            if (method.getName().compareTo("onSuccess") == 0) {
                AppMethodBeat.m2505o(94390);
            } else {
                if (method.getName().compareTo("onFailure") == 0) {
                    final int intValue = (objArr == null || !(objArr[0] instanceof Integer)) ? -1 : ((Integer) objArr[0]).intValue();
                    C38407a.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(94389);
                            C38407a.this.mo61116i(false, "fail to connect wifi:actionListener" + intValue);
                            C4990ab.m7416i("MicroMsg.wifi_event", "ActionListener onFailure FAIL.");
                            AppMethodBeat.m2505o(94389);
                        }
                    });
                }
                AppMethodBeat.m2505o(94390);
            }
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a$b */
    class C38408b implements InvocationHandler {
        C38408b() {
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.m2504i(94391);
            C4990ab.m7416i("MicroMsg.WiFiConnector", "Method:" + method + " getName:" + method.getName() + " ,Args:" + objArr);
            AppMethodBeat.m2505o(94391);
            return null;
        }
    }

    /* renamed from: a */
    private static Object m64988a(C19529a c19529a, String str) {
        AppMethodBeat.m2504i(94392);
        Object newProxyInstance = Proxy.newProxyInstance(Class.forName(str).getClassLoader(), new Class[]{r0}, c19529a);
        AppMethodBeat.m2505o(94392);
        return newProxyInstance;
    }

    public C38407a(C10565a c10565a, Context context) {
        AppMethodBeat.m2504i(94393);
        this.ids = c10565a;
        this.idt = context;
        try {
            this.idx = (ConnectivityManager) this.idt.getSystemService("connectivity");
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WiFiConnector", e, "can not retrieve ConnectivityManager", new Object[0]);
        }
        this.mHandler = new Handler(context.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(94387);
                if (message == null) {
                    AppMethodBeat.m2505o(94387);
                    return;
                }
                switch (message.what) {
                    case 1:
                        C4990ab.m7416i("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
                        if (!C38407a.this.aGB()) {
                            C38407a.this.mo61113Cb("fail to connect wifi:time out");
                            C4990ab.m7416i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(94387);
            }
        };
        AppMethodBeat.m2505o(94393);
    }

    private void aGA() {
        AppMethodBeat.m2504i(94394);
        if (this.ide) {
            this.idt.unregisterReceiver(this.idf);
            this.ide = false;
            C4990ab.m7416i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
        }
        AppMethodBeat.m2505o(94394);
    }

    /* renamed from: a */
    public final boolean mo61114a(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.m2504i(94395);
        if (wifiConfiguration == null || wifiConfiguration.networkId == C19531d.idD || this.idx == null) {
            AppMethodBeat.m2505o(94395);
            return false;
        }
        try {
            Class cls = Class.forName("android.net.wifi.WifiManager");
            String str;
            Object a;
            Class cls2;
            if (VERSION.SDK_INT < 16) {
                cls.getMethod("asyncConnect", new Class[]{Context.class, Handler.class}).invoke(C27140c.bCU, new Object[]{this.idt, this.mHandler});
                cls.getMethod("connectNetwork", new Class[]{Integer.TYPE}).invoke(C27140c.bCU, new Object[]{Integer.valueOf(wifiConfiguration.networkId)});
                AppMethodBeat.m2505o(94395);
                return true;
            } else if (VERSION.SDK_INT == 16) {
                str = "android.net.wifi.WifiManager$ChannelListener";
                if (this.idv == null) {
                    this.idv = new C38408b();
                }
                a = C38407a.m64988a(this.idu, str);
                cls2 = Class.forName(str);
                Object invoke = cls.getMethod("initialize", new Class[]{Context.class, Looper.class, cls2}).invoke(C27140c.bCU, new Object[]{this.idt, this.idt.getMainLooper(), a});
                String str2 = "android.net.wifi.WifiManager$ActionListener";
                if (this.idu == null) {
                    this.idu = new C19529a();
                }
                Object a2 = C38407a.m64988a(this.idu, str2);
                Class cls3 = Class.forName(str2);
                cls.getMethod("connect", new Class[]{Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, cls3}).invoke(C27140c.bCU, new Object[]{invoke, Integer.valueOf(wifiConfiguration.networkId), a2});
                AppMethodBeat.m2505o(94395);
                return true;
            } else {
                if (this.idu == null) {
                    this.idu = new C19529a();
                }
                str = "android.net.wifi.WifiManager$ActionListener";
                a = C38407a.m64988a(this.idu, str);
                cls2 = Class.forName(str);
                cls.getMethod("connect", new Class[]{Integer.TYPE, cls2}).invoke(C27140c.bCU, new Object[]{Integer.valueOf(wifiConfiguration.networkId), a});
                AppMethodBeat.m2505o(94395);
                return true;
            }
        } catch (Exception e) {
            boolean oH = C27140c.m43135oH(wifiConfiguration.networkId);
            AppMethodBeat.m2505o(94395);
            return oH;
        }
    }

    public final boolean aGB() {
        return this.idy == 3 || this.idy == 2;
    }

    /* renamed from: Cb */
    public final void mo61113Cb(String str) {
        AppMethodBeat.m2504i(94396);
        if (this.idw != null) {
            C27139b.m43134oG(this.idw.networkId);
            mo61116i(false, str);
            C4990ab.m7416i("MicroMsg.wifi_event", "cancelConnect, " + C19531d.m30248Cc(this.idw.SSID) + " networkId:" + this.idw.networkId);
            C4990ab.m7416i("MicroMsg.WiFiConnector", "cancelConnect");
        }
        AppMethodBeat.m2505o(94396);
    }

    /* renamed from: oE */
    public final void mo61117oE(int i) {
        AppMethodBeat.m2504i(94397);
        if (this.idy != i) {
            this.idy = i;
            C4990ab.m7416i("MicroMsg.WiFiConnector", "switchState:" + C38407a.m64989oF(this.idy));
        }
        AppMethodBeat.m2505o(94397);
    }

    /* renamed from: i */
    public final void mo61116i(boolean z, String str) {
        AppMethodBeat.m2504i(94398);
        C4990ab.m7416i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(z)));
        if (!aGB()) {
            if (this.ids != null) {
                C10565a c10565a = this.ids;
                if (z) {
                    str = "ok";
                }
                c10565a.mo22072Ca(str);
            }
            this.mHandler.removeMessages(1);
            aGA();
            mo61117oE(z ? 2 : 3);
            if (!(z || this.idw == null)) {
                C27139b.m43134oG(this.idw.networkId);
            }
        }
        AppMethodBeat.m2505o(94398);
    }

    /* renamed from: oF */
    private static String m64989oF(int i) {
        switch (i) {
            case 0:
                return "STATE_NONE";
            case 1:
                return "STATE_CONNECTING";
            case 2:
                return "STATE_CONNECTED";
            case 3:
                return "STATE_FAIL";
            default:
                return "UnknowState";
        }
    }
}
