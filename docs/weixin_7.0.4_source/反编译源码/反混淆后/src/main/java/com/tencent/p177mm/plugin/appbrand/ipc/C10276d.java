package com.tencent.p177mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.d */
public final class C10276d {
    private static final HashMap<String, MMToClientEvent> hvD = new HashMap();

    static {
        AppMethodBeat.m2504i(86953);
        AppMethodBeat.m2505o(86953);
    }

    /* renamed from: b */
    public static void m17932b(MMToClientEvent mMToClientEvent) {
        AppMethodBeat.m2504i(86948);
        C4990ab.m7417i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", mMToClientEvent.appId, Integer.valueOf(mMToClientEvent.hashCode()));
        if (mMToClientEvent.appId == null) {
            C4990ab.m7412e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
            AppMethodBeat.m2505o(86948);
            return;
        }
        synchronized (hvD) {
            try {
                if (hvD.get(mMToClientEvent.appId) == null) {
                    hvD.put(mMToClientEvent.appId, mMToClientEvent);
                } else {
                    C4990ab.m7410d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
                    hvD.remove(mMToClientEvent.appId);
                    hvD.put(mMToClientEvent.appId, mMToClientEvent);
                }
            } finally {
                AppMethodBeat.m2505o(86948);
            }
        }
    }

    /* renamed from: c */
    public static void m17934c(MMToClientEvent mMToClientEvent) {
        AppMethodBeat.m2504i(86949);
        C4990ab.m7417i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", mMToClientEvent.appId);
        synchronized (hvD) {
            try {
                hvD.remove(mMToClientEvent.appId);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86949);
            }
        }
    }

    /* renamed from: j */
    public static void m17935j(String str, int i, String str2) {
        MMToClientEvent mMToClientEvent;
        AppMethodBeat.m2504i(86950);
        C4990ab.m7417i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", str, Integer.valueOf(i), str2);
        synchronized (hvD) {
            try {
                mMToClientEvent = (MMToClientEvent) hvD.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86950);
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
                        AppMethodBeat.m2505o(86950);
                    }
                }
            }
            return;
        }
        C4990ab.m7412e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
        AppMethodBeat.m2505o(86950);
    }

    /* renamed from: bf */
    public static void m17933bf(String str, int i) {
        MMToClientEvent mMToClientEvent;
        AppMethodBeat.m2504i(86951);
        C4990ab.m7417i("MicroMsg.MMToClientEventCenter", "notify unread:%d", Integer.valueOf(i));
        synchronized (hvD) {
            try {
                mMToClientEvent = (MMToClientEvent) hvD.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86951);
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
                        AppMethodBeat.m2505o(86951);
                    }
                }
            }
            return;
        }
        C4990ab.m7412e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
        AppMethodBeat.m2505o(86951);
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m17931a(String str, T t) {
        MMToClientEvent mMToClientEvent;
        AppMethodBeat.m2504i(86952);
        synchronized (hvD) {
            try {
                mMToClientEvent = (MMToClientEvent) hvD.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86952);
            }
        }
        if (mMToClientEvent == null || t == null || t == null) {
            AppMethodBeat.m2505o(86952);
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
                    AppMethodBeat.m2505o(86952);
                }
            }
        }
    }
}
