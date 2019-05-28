package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MMToClientEvent extends MainProcessTask {
    public static final Creator<MMToClientEvent> CREATOR = new Creator<MMToClientEvent>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MMToClientEvent[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(86937);
            MMToClientEvent mMToClientEvent = new MMToClientEvent(parcel, (byte) 0);
            AppMethodBeat.o(86937);
            return mMToClientEvent;
        }
    };
    private static final HashMap<String, Set<c>> hvA = new HashMap();
    private static final HashMap<String, MMToClientEvent> hvz = new HashMap();
    public String appId;
    int csm;
    String czy;
    public int hvv;
    private com.tencent.mm.plugin.appbrand.jsapi.c hvw;
    String hvx;
    Object hvy;
    public int type;

    public static class a extends p {
        private static final int CTRL_INDEX = 109;
        private static final String NAME = "onAppConfig";
    }

    public static class b extends p {
        private static final int CTRL_INDEX = 152;
        private static final String NAME = "onContactMessageCountChange";
    }

    public interface c {
        void bk(Object obj);
    }

    /* synthetic */ MMToClientEvent(Parcel parcel, byte b) {
        this(parcel);
    }

    private MMToClientEvent() {
    }

    private MMToClientEvent(Parcel parcel) {
        AppMethodBeat.i(86938);
        g(parcel);
        AppMethodBeat.o(86938);
    }

    public final void asP() {
        AppMethodBeat.i(86939);
        switch (this.hvv) {
            case 1:
                d.b(this);
                AppMethodBeat.o(86939);
                return;
            case 2:
                d.c(this);
                break;
        }
        AppMethodBeat.o(86939);
    }

    static {
        AppMethodBeat.i(86947);
        AppMethodBeat.o(86947);
    }

    public static void e(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        AppMethodBeat.i(86940);
        if (cVar == null) {
            AppMethodBeat.o(86940);
            return;
        }
        MainProcessTask mMToClientEvent = new MMToClientEvent();
        hvz.put(cVar.getAppId(), mMToClientEvent);
        mMToClientEvent.hvv = 1;
        mMToClientEvent.appId = cVar.getAppId();
        mMToClientEvent.hvw = cVar;
        AppBrandMainProcessService.a(mMToClientEvent);
        AppMethodBeat.o(86940);
    }

    public static void f(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        AppMethodBeat.i(86941);
        if (cVar == null) {
            AppMethodBeat.o(86941);
            return;
        }
        MainProcessTask mainProcessTask = (MMToClientEvent) hvz.remove(cVar.getAppId());
        if (mainProcessTask == null) {
            AppMethodBeat.o(86941);
            return;
        }
        synchronized (hvA) {
            try {
                hvA.remove(cVar.getAppId());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86941);
            }
        }
        mainProcessTask.hvv = 2;
        mainProcessTask.appId = cVar.getAppId();
        mainProcessTask.hvw = null;
        AppBrandMainProcessService.b(mainProcessTask);
    }

    public static void a(String str, c cVar) {
        AppMethodBeat.i(86942);
        if (cVar != null) {
            synchronized (hvA) {
                try {
                    if (!hvA.containsKey(str)) {
                        hvA.put(str, new HashSet());
                    }
                    ((Set) hvA.get(str)).add(cVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(86942);
                }
            }
            return;
        }
        AppMethodBeat.o(86942);
    }

    public static void b(String str, c cVar) {
        AppMethodBeat.i(86943);
        if (cVar != null) {
            synchronized (hvA) {
                try {
                    if (hvA.containsKey(str)) {
                        ((Set) hvA.get(str)).remove(cVar);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(86943);
                }
            }
            return;
        }
        AppMethodBeat.o(86943);
    }

    public final void asQ() {
        AppMethodBeat.i(86944);
        HashMap hashMap;
        switch (this.hvv) {
            case 3:
                a aVar = new a();
                hashMap = new HashMap();
                hashMap.put("type", Integer.valueOf(this.type));
                hashMap.put("data", this.czy);
                aVar.i(this.hvw).t(hashMap).aCj();
                AppMethodBeat.o(86944);
                return;
            case 4:
                b bVar = new b();
                hashMap = new HashMap();
                hashMap.put("count", Integer.valueOf(this.csm));
                hashMap.put("data", this.czy);
                bVar.i(this.hvw).t(hashMap).aCj();
                AppMethodBeat.o(86944);
                return;
            case 5:
                if (this.appId != null && this.hvy != null) {
                    if (hvA.get(this.appId) != null) {
                        final LinkedList linkedList = new LinkedList();
                        synchronized (hvA) {
                            try {
                                linkedList.addAll((Collection) hvA.get(this.appId));
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.o(86944);
                                    break;
                                }
                            }
                        }
                        e.aNS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(86936);
                                for (c bk : linkedList) {
                                    bk.bk(MMToClientEvent.this.hvy);
                                }
                                AppMethodBeat.o(86936);
                            }
                        });
                        break;
                    }
                }
                AppMethodBeat.o(86944);
                return;
                break;
        }
        AppMethodBeat.o(86944);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(86945);
        this.hvv = parcel.readInt();
        this.appId = parcel.readString();
        this.type = parcel.readInt();
        this.czy = parcel.readString();
        this.csm = parcel.readInt();
        try {
            this.hvx = parcel.readString();
            if (!bo.isNullOrNil(this.hvx)) {
                Class cls = Class.forName(this.hvx);
                if (cls != null) {
                    this.hvy = parcel.readParcelable(cls.getClassLoader());
                }
            }
            AppMethodBeat.o(86945);
        } catch (Exception e) {
            ab.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", e);
            AppMethodBeat.o(86945);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(86946);
        parcel.writeInt(this.hvv);
        parcel.writeString(this.appId);
        parcel.writeInt(this.type);
        parcel.writeString(this.czy);
        parcel.writeInt(this.csm);
        if (!(bo.isNullOrNil(this.hvx) || this.hvy == null)) {
            parcel.writeString(this.hvx);
            parcel.writeParcelable((Parcelable) this.hvy, i);
        }
        AppMethodBeat.o(86946);
    }
}
