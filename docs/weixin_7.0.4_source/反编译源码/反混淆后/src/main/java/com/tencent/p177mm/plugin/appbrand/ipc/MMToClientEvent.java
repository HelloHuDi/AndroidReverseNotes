package com.tencent.p177mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent */
public class MMToClientEvent extends MainProcessTask {
    public static final Creator<MMToClientEvent> CREATOR = new C424552();
    private static final HashMap<String, Set<C38244c>> hvA = new HashMap();
    private static final HashMap<String, MMToClientEvent> hvz = new HashMap();
    public String appId;
    int csm;
    String czy;
    public int hvv;
    private C2241c hvw;
    String hvx;
    Object hvy;
    public int type;

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent$a */
    public static class C19249a extends C38369p {
        private static final int CTRL_INDEX = 109;
        private static final String NAME = "onAppConfig";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent$b */
    public static class C19250b extends C38369p {
        private static final int CTRL_INDEX = 152;
        private static final String NAME = "onContactMessageCountChange";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent$c */
    public interface C38244c {
        /* renamed from: bk */
        void mo22088bk(Object obj);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent$2 */
    static class C424552 implements Creator<MMToClientEvent> {
        C424552() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MMToClientEvent[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(86937);
            MMToClientEvent mMToClientEvent = new MMToClientEvent(parcel, (byte) 0);
            AppMethodBeat.m2505o(86937);
            return mMToClientEvent;
        }
    }

    /* synthetic */ MMToClientEvent(Parcel parcel, byte b) {
        this(parcel);
    }

    private MMToClientEvent() {
    }

    private MMToClientEvent(Parcel parcel) {
        AppMethodBeat.m2504i(86938);
        mo6032g(parcel);
        AppMethodBeat.m2505o(86938);
    }

    public final void asP() {
        AppMethodBeat.m2504i(86939);
        switch (this.hvv) {
            case 1:
                C10276d.m17932b(this);
                AppMethodBeat.m2505o(86939);
                return;
            case 2:
                C10276d.m17934c(this);
                break;
        }
        AppMethodBeat.m2505o(86939);
    }

    static {
        AppMethodBeat.m2504i(86947);
        AppMethodBeat.m2505o(86947);
    }

    /* renamed from: e */
    public static void m75201e(C2241c c2241c) {
        AppMethodBeat.m2504i(86940);
        if (c2241c == null) {
            AppMethodBeat.m2505o(86940);
            return;
        }
        MainProcessTask mMToClientEvent = new MMToClientEvent();
        hvz.put(c2241c.getAppId(), mMToClientEvent);
        mMToClientEvent.hvv = 1;
        mMToClientEvent.appId = c2241c.getAppId();
        mMToClientEvent.hvw = c2241c;
        AppBrandMainProcessService.m54349a(mMToClientEvent);
        AppMethodBeat.m2505o(86940);
    }

    /* renamed from: f */
    public static void m75202f(C2241c c2241c) {
        AppMethodBeat.m2504i(86941);
        if (c2241c == null) {
            AppMethodBeat.m2505o(86941);
            return;
        }
        MainProcessTask mainProcessTask = (MMToClientEvent) hvz.remove(c2241c.getAppId());
        if (mainProcessTask == null) {
            AppMethodBeat.m2505o(86941);
            return;
        }
        synchronized (hvA) {
            try {
                hvA.remove(c2241c.getAppId());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86941);
            }
        }
        mainProcessTask.hvv = 2;
        mainProcessTask.appId = c2241c.getAppId();
        mainProcessTask.hvw = null;
        AppBrandMainProcessService.m54355b(mainProcessTask);
    }

    /* renamed from: a */
    public static void m75199a(String str, C38244c c38244c) {
        AppMethodBeat.m2504i(86942);
        if (c38244c != null) {
            synchronized (hvA) {
                try {
                    if (!hvA.containsKey(str)) {
                        hvA.put(str, new HashSet());
                    }
                    ((Set) hvA.get(str)).add(c38244c);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(86942);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(86942);
    }

    /* renamed from: b */
    public static void m75200b(String str, C38244c c38244c) {
        AppMethodBeat.m2504i(86943);
        if (c38244c != null) {
            synchronized (hvA) {
                try {
                    if (hvA.containsKey(str)) {
                        ((Set) hvA.get(str)).remove(c38244c);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(86943);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(86943);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(86944);
        HashMap hashMap;
        switch (this.hvv) {
            case 3:
                C19249a c19249a = new C19249a();
                hashMap = new HashMap();
                hashMap.put("type", Integer.valueOf(this.type));
                hashMap.put("data", this.czy);
                c19249a.mo61031i(this.hvw).mo34958t(hashMap).aCj();
                AppMethodBeat.m2505o(86944);
                return;
            case 4:
                C19250b c19250b = new C19250b();
                hashMap = new HashMap();
                hashMap.put("count", Integer.valueOf(this.csm));
                hashMap.put("data", this.czy);
                c19250b.mo61031i(this.hvw).mo34958t(hashMap).aCj();
                AppMethodBeat.m2505o(86944);
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
                                    AppMethodBeat.m2505o(86944);
                                    break;
                                }
                            }
                        }
                        C42677e.aNS().mo10302aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(86936);
                                for (C38244c bk : linkedList) {
                                    bk.mo22088bk(MMToClientEvent.this.hvy);
                                }
                                AppMethodBeat.m2505o(86936);
                            }
                        });
                        break;
                    }
                }
                AppMethodBeat.m2505o(86944);
                return;
                break;
        }
        AppMethodBeat.m2505o(86944);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(86945);
        this.hvv = parcel.readInt();
        this.appId = parcel.readString();
        this.type = parcel.readInt();
        this.czy = parcel.readString();
        this.csm = parcel.readInt();
        try {
            this.hvx = parcel.readString();
            if (!C5046bo.isNullOrNil(this.hvx)) {
                Class cls = Class.forName(this.hvx);
                if (cls != null) {
                    this.hvy = parcel.readParcelable(cls.getClassLoader());
                }
            }
            AppMethodBeat.m2505o(86945);
        } catch (Exception e) {
            C4990ab.m7419v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", e);
            AppMethodBeat.m2505o(86945);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(86946);
        parcel.writeInt(this.hvv);
        parcel.writeString(this.appId);
        parcel.writeInt(this.type);
        parcel.writeString(this.czy);
        parcel.writeInt(this.csm);
        if (!(C5046bo.isNullOrNil(this.hvx) || this.hvy == null)) {
            parcel.writeString(this.hvx);
            parcel.writeParcelable((Parcelable) this.hvy, i);
        }
        AppMethodBeat.m2505o(86946);
    }
}
