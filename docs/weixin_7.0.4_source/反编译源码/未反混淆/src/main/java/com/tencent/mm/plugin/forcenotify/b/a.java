package com.tencent.mm.plugin.forcenotify.b;

import a.f.b.j;
import a.l;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(dWo = {1, 1, 13}, dWp = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u000e\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH&J0\u0010 \u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0017J$\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0018\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u001cH&J\b\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "onModify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "username", "", "onReceive", "userName", "isNeedNotify", "release", "start", "plugin-force-notify_release"})
public abstract class a implements com.tencent.mm.plugin.forcenotify.a.b, com.tencent.mm.sdk.e.n.b {
    final String TAG = "MicroMsg.ForceNotifyService";
    private long msQ;
    private final ak msR = new ak(this.TAG);
    private final ak msS = new ak(Looper.getMainLooper());
    public final ConcurrentLinkedQueue<String> msT = new ConcurrentLinkedQueue();
    private final b msU = new b(this);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        public static final c mta = new c();

        static {
            AppMethodBeat.i(51030);
            AppMethodBeat.o(51030);
        }

        c() {
        }

        public final void run() {
            AppMethodBeat.i(51029);
            com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.mth;
            com.tencent.mm.plugin.forcenotify.d.a.bya();
            AppMethodBeat.o(51029);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ a msV;
        final /* synthetic */ cm msW;

        a(a aVar, cm cmVar) {
            this.msV = aVar;
            this.msW = cmVar;
        }

        public final void run() {
            com.tencent.mm.plugin.forcenotify.d.a aVar;
            String str;
            String str2 = null;
            AppMethodBeat.i(51025);
            if (a.a(this.msV)) {
                aVar = com.tencent.mm.plugin.forcenotify.d.a.mth;
                com.tencent.mm.plugin.forcenotify.d.a.bya();
            }
            cm cmVar = this.msW;
            Map z = br.z(cmVar != null ? cmVar.vEG : null, "ForcePushId");
            if (z != null) {
                str = (String) z.get(".ForcePushId");
            } else {
                str = null;
            }
            if (str == null) {
                ab.i(this.msV.TAG, "not a forcePush msg");
                AppMethodBeat.o(51025);
                return;
            }
            String str3 = this.msV.TAG;
            String str4 = "%s %s %s";
            Object[] objArr = new Object[3];
            cm cmVar2 = this.msW;
            if (cmVar2 != null) {
                str2 = cmVar2.vEG;
            }
            objArr[0] = str2;
            objArr[1] = this.msW.vEB;
            objArr[2] = str;
            ab.i(str3, str4, objArr);
            str2 = aa.a(this.msW.vEB);
            if (!((j.j(r.Yz(), str2) ^ 1) == 0 || this.msV.msT.contains(str2))) {
                aVar = com.tencent.mm.plugin.forcenotify.d.a.mth;
                j.o(str2, "fromUser");
                if (com.tencent.mm.plugin.forcenotify.d.a.Mp(str2)) {
                    this.msV.msT.add(str2);
                    this.msV.msS.post(new Runnable(this) {
                        final /* synthetic */ a msX;

                        public final void run() {
                            boolean z = true;
                            AppMethodBeat.i(51024);
                            a aVar = this.msX.msV;
                            String str = str2;
                            j.o(str, "fromUser");
                            if (this.msX.msV.msT.size() != 1) {
                                z = false;
                            }
                            aVar.aJ(str, z);
                            AppMethodBeat.o(51024);
                        }
                    });
                }
            }
            AppMethodBeat.o(51025);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ManualAuthEvent;", "callback", "", "event", "plugin-force-notify_release"})
    public static final class b extends com.tencent.mm.sdk.b.c<jt> {
        final /* synthetic */ a msV;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            public static final a msZ = new a();

            static {
                AppMethodBeat.i(51027);
                AppMethodBeat.o(51027);
            }

            a() {
            }

            public final void run() {
                AppMethodBeat.i(51026);
                new com.tencent.mm.plugin.forcenotify.c.a().acy();
                AppMethodBeat.o(51026);
            }
        }

        b(a aVar) {
            this.msV = aVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(51028);
            j.p((jt) bVar, "event");
            ab.i(this.msV.TAG, "[callback] event:%s", r7);
            this.msV.msR.post(a.msZ);
            AppMethodBeat.o(51028);
            return true;
        }
    }

    public abstract void aJ(String str, boolean z);

    public final /* synthetic */ void e(com.tencent.mm.bt.a aVar) {
        cm cmVar = (cm) aVar;
        j.p(cmVar, "addMsg");
        this.msR.post(new a(this, cmVar));
    }

    public final /* bridge */ /* synthetic */ void f(com.tencent.mm.bt.a aVar) {
    }

    public final void a(int i, n nVar, Object obj) {
        if (obj != null && (obj instanceof String)) {
            if (i == 5 || i == 4) {
                com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(bo.bc((String) obj, ""));
                if (aoO != null) {
                    if (!aoO.NX() || aoO.Oa()) {
                        com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.mth;
                        String username = aoO.getUsername();
                        j.o(username, "contact.username");
                        ab.i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", obj, Boolean.valueOf(com.tencent.mm.plugin.forcenotify.d.a.Mq(username)));
                        if (!com.tencent.mm.plugin.forcenotify.d.a.Mq(username)) {
                            return;
                        }
                        if (aoO.Oa()) {
                            am((String) obj, 9);
                        } else {
                            am((String) obj, 7);
                        }
                    }
                }
            }
        }
    }

    public void start() {
        u.a(5, this);
        com.tencent.mm.kernel.b.a M = g.M(p.class);
        j.o(M, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((p) M).getSysCmdMsgExtension().a("NewXmlAddForcePushApplication", (o) this);
        this.msU.dnU();
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().a(this);
        this.msR.post(c.mta);
    }

    public void release() {
        this.msU.dead();
        u.a(this);
        com.tencent.mm.kernel.b.a M = g.M(p.class);
        j.o(M, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((p) M).getSysCmdMsgExtension().b("NewXmlAddForcePushApplication", (o) this);
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().b(this);
    }

    public void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
        j.p(map, "map");
    }

    public static final /* synthetic */ boolean a(a aVar) {
        boolean z = cb.aaE() - aVar.msQ > 1800000;
        if (z) {
            aVar.msQ = cb.aaE();
        }
        return z;
    }
}
