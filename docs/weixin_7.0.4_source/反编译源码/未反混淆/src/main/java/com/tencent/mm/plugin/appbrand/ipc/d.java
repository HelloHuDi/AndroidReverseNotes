package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class d {
    private static final HashMap<String, MMToClientEvent> hvD = new HashMap();

    static {
        AppMethodBeat.i(86953);
        AppMethodBeat.o(86953);
    }

    public static void b(MMToClientEvent mMToClientEvent) {
        AppMethodBeat.i(86948);
        ab.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", mMToClientEvent.appId, Integer.valueOf(mMToClientEvent.hashCode()));
        if (mMToClientEvent.appId == null) {
            ab.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
            AppMethodBeat.o(86948);
            return;
        }
        synchronized (hvD) {
            try {
                if (hvD.get(mMToClientEvent.appId) == null) {
                    hvD.put(mMToClientEvent.appId, mMToClientEvent);
                } else {
                    ab.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
                    hvD.remove(mMToClientEvent.appId);
                    hvD.put(mMToClientEvent.appId, mMToClientEvent);
                }
            } finally {
                AppMethodBeat.o(86948);
            }
        }
    }

    public static void c(MMToClientEvent mMToClientEvent) {
        AppMethodBeat.i(86949);
        ab.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", mMToClientEvent.appId);
        synchronized (hvD) {
            try {
                hvD.remove(mMToClientEvent.appId);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86949);
            }
        }
    }

    public static void j(String str, int i, String str2) {
        MMToClientEvent mMToClientEvent;
        AppMethodBeat.i(86950);
        ab.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", str, Integer.valueOf(i), str2);
        synchronized (hvD) {
            try {
                mMToClientEvent = (MMToClientEvent) hvD.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86950);
            }
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                try {
                    mMToClientEvent.hvv = 3;
                    mMToClientEvent.appId = str;
                    mMToClientEvent.type = i;
                    mMToClientEvent.czy = str2;
                    mMToClientEvent.aCb();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(86950);
                    }
                }
            }
            return;
        }
        ab.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
        AppMethodBeat.o(86950);
    }

    public static void bf(String str, int i) {
        MMToClientEvent mMToClientEvent;
        AppMethodBeat.i(86951);
        ab.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", Integer.valueOf(i));
        synchronized (hvD) {
            try {
                mMToClientEvent = (MMToClientEvent) hvD.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86951);
            }
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                try {
                    mMToClientEvent.hvv = 4;
                    mMToClientEvent.csm = i;
                    mMToClientEvent.aCb();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(86951);
                    }
                }
            }
            return;
        }
        ab.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
        AppMethodBeat.o(86951);
    }

    public static <T extends Parcelable> void a(String str, T t) {
        MMToClientEvent mMToClientEvent;
        AppMethodBeat.i(86952);
        synchronized (hvD) {
            try {
                mMToClientEvent = (MMToClientEvent) hvD.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86952);
            }
        }
        if (mMToClientEvent == null || t == null || t == null) {
            AppMethodBeat.o(86952);
            return;
        }
        synchronized (mMToClientEvent) {
            try {
                mMToClientEvent.hvv = 5;
                mMToClientEvent.hvx = t.getClass().getName();
                mMToClientEvent.hvy = t;
                mMToClientEvent.aCb();
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(86952);
                }
            }
        }
    }
}
