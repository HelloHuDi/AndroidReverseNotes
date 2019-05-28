package com.tencent.mm.plugin.appbrand.keepalive;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public static final a ifp = new a();
    ConcurrentHashMap<String, a> ifq = new ConcurrentHashMap();

    static final class a {
        ServiceConnection ifr;
        Class ifs;

        private a() {
            AppMethodBeat.i(131681);
            this.ifr = new ServiceConnection() {
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                }
            };
            AppMethodBeat.o(131681);
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(131682);
        AppMethodBeat.o(131682);
    }

    static {
        AppMethodBeat.i(131683);
        AppMethodBeat.o(131683);
    }
}
