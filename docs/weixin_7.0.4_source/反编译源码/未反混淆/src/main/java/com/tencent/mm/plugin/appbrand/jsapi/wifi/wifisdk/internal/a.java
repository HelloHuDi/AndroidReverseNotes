package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a {
    public boolean idA = false;
    public boolean ide = false;
    public BroadcastReceiver idf = null;
    public String idi;
    public String idj;
    private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a ids;
    public Context idt;
    a idu = null;
    b idv = null;
    public WifiConfiguration idw = null;
    ConnectivityManager idx;
    private int idy = 0;
    private final int idz = 13000;
    public Handler mHandler = null;

    class a implements InvocationHandler {
        a() {
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(94390);
            if (method.getName().compareTo("onSuccess") == 0) {
                AppMethodBeat.o(94390);
            } else {
                if (method.getName().compareTo("onFailure") == 0) {
                    final int intValue = (objArr == null || !(objArr[0] instanceof Integer)) ? -1 : ((Integer) objArr[0]).intValue();
                    a.this.mHandler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(94389);
                            a.this.i(false, "fail to connect wifi:actionListener" + intValue);
                            ab.i("MicroMsg.wifi_event", "ActionListener onFailure FAIL.");
                            AppMethodBeat.o(94389);
                        }
                    });
                }
                AppMethodBeat.o(94390);
            }
            return null;
        }
    }

    class b implements InvocationHandler {
        b() {
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(94391);
            ab.i("MicroMsg.WiFiConnector", "Method:" + method + " getName:" + method.getName() + " ,Args:" + objArr);
            AppMethodBeat.o(94391);
            return null;
        }
    }

    private static Object a(a aVar, String str) {
        AppMethodBeat.i(94392);
        Object newProxyInstance = Proxy.newProxyInstance(Class.forName(str).getClassLoader(), new Class[]{r0}, aVar);
        AppMethodBeat.o(94392);
        return newProxyInstance;
    }

    public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a aVar, Context context) {
        AppMethodBeat.i(94393);
        this.ids = aVar;
        this.idt = context;
        try {
            this.idx = (ConnectivityManager) this.idt.getSystemService("connectivity");
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WiFiConnector", e, "can not retrieve ConnectivityManager", new Object[0]);
        }
        this.mHandler = new Handler(context.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(94387);
                if (message == null) {
                    AppMethodBeat.o(94387);
                    return;
                }
                switch (message.what) {
                    case 1:
                        ab.i("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
                        if (!a.this.aGB()) {
                            a.this.Cb("fail to connect wifi:time out");
                            ab.i("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(94387);
            }
        };
        AppMethodBeat.o(94393);
    }

    private void aGA() {
        AppMethodBeat.i(94394);
        if (this.ide) {
            this.idt.unregisterReceiver(this.idf);
            this.ide = false;
            ab.i("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
        }
        AppMethodBeat.o(94394);
    }

    public final boolean a(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.i(94395);
        if (wifiConfiguration == null || wifiConfiguration.networkId == d.idD || this.idx == null) {
            AppMethodBeat.o(94395);
            return false;
        }
        try {
            Class cls = Class.forName("android.net.wifi.WifiManager");
            String str;
            Object a;
            Class cls2;
            if (VERSION.SDK_INT < 16) {
                cls.getMethod("asyncConnect", new Class[]{Context.class, Handler.class}).invoke(c.bCU, new Object[]{this.idt, this.mHandler});
                cls.getMethod("connectNetwork", new Class[]{Integer.TYPE}).invoke(c.bCU, new Object[]{Integer.valueOf(wifiConfiguration.networkId)});
                AppMethodBeat.o(94395);
                return true;
            } else if (VERSION.SDK_INT == 16) {
                str = "android.net.wifi.WifiManager$ChannelListener";
                if (this.idv == null) {
                    this.idv = new b();
                }
                a = a(this.idu, str);
                cls2 = Class.forName(str);
                Object invoke = cls.getMethod("initialize", new Class[]{Context.class, Looper.class, cls2}).invoke(c.bCU, new Object[]{this.idt, this.idt.getMainLooper(), a});
                String str2 = "android.net.wifi.WifiManager$ActionListener";
                if (this.idu == null) {
                    this.idu = new a();
                }
                Object a2 = a(this.idu, str2);
                Class cls3 = Class.forName(str2);
                cls.getMethod("connect", new Class[]{Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, cls3}).invoke(c.bCU, new Object[]{invoke, Integer.valueOf(wifiConfiguration.networkId), a2});
                AppMethodBeat.o(94395);
                return true;
            } else {
                if (this.idu == null) {
                    this.idu = new a();
                }
                str = "android.net.wifi.WifiManager$ActionListener";
                a = a(this.idu, str);
                cls2 = Class.forName(str);
                cls.getMethod("connect", new Class[]{Integer.TYPE, cls2}).invoke(c.bCU, new Object[]{Integer.valueOf(wifiConfiguration.networkId), a});
                AppMethodBeat.o(94395);
                return true;
            }
        } catch (Exception e) {
            boolean oH = c.oH(wifiConfiguration.networkId);
            AppMethodBeat.o(94395);
            return oH;
        }
    }

    public final boolean aGB() {
        return this.idy == 3 || this.idy == 2;
    }

    public final void Cb(String str) {
        AppMethodBeat.i(94396);
        if (this.idw != null) {
            b.oG(this.idw.networkId);
            i(false, str);
            ab.i("MicroMsg.wifi_event", "cancelConnect, " + d.Cc(this.idw.SSID) + " networkId:" + this.idw.networkId);
            ab.i("MicroMsg.WiFiConnector", "cancelConnect");
        }
        AppMethodBeat.o(94396);
    }

    public final void oE(int i) {
        AppMethodBeat.i(94397);
        if (this.idy != i) {
            this.idy = i;
            ab.i("MicroMsg.WiFiConnector", "switchState:" + oF(this.idy));
        }
        AppMethodBeat.o(94397);
    }

    public final void i(boolean z, String str) {
        AppMethodBeat.i(94398);
        ab.i("MicroMsg.WiFiConnector", "finishConnectTask success:".concat(String.valueOf(z)));
        if (!aGB()) {
            if (this.ids != null) {
                com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a aVar = this.ids;
                if (z) {
                    str = "ok";
                }
                aVar.Ca(str);
            }
            this.mHandler.removeMessages(1);
            aGA();
            oE(z ? 2 : 3);
            if (!(z || this.idw == null)) {
                b.oG(this.idw.networkId);
            }
        }
        AppMethodBeat.o(94398);
    }

    private static String oF(int i) {
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
