package com.tencent.p177mm.plugin.forcenotify.p1263b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p230g.p231a.C37748jt;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C20772b;
import com.tencent.p177mm.plugin.forcenotify.p1613c.C45946a;
import com.tencent.p177mm.plugin.forcenotify.p1648d.C45947a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21281u;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u000e\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH&J0\u0010 \u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0017J$\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0018\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u001cH&J\b\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyService;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "lastCheckExpireForceNotifyTime", "", "mainExecutor", "manualAuthEventIListener", "com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1;", "notifyList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "afterSyncDoCmd", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "beforeSyncDoCmd", "p0", "getNotifyShowList", "getXmlKey", "p", "isNeedCheckExpire", "", "onModify", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "onNewXmlReceived", "map", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "username", "", "onReceive", "userName", "isNeedNotify", "release", "start", "plugin-force-notify_release"})
/* renamed from: com.tencent.mm.plugin.forcenotify.b.a */
public abstract class C24760a implements C20772b, C4937b {
    final String TAG = "MicroMsg.ForceNotifyService";
    private long msQ;
    private final C7306ak msR = new C7306ak(this.TAG);
    private final C7306ak msS = new C7306ak(Looper.getMainLooper());
    public final ConcurrentLinkedQueue<String> msT = new ConcurrentLinkedQueue();
    private final C24763b msU = new C24763b(this);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.b.a$c */
    static final class C20773c implements Runnable {
        public static final C20773c mta = new C20773c();

        static {
            AppMethodBeat.m2504i(51030);
            AppMethodBeat.m2505o(51030);
        }

        C20773c() {
        }

        public final void run() {
            AppMethodBeat.m2504i(51029);
            C45947a c45947a = C45947a.mth;
            C45947a.bya();
            AppMethodBeat.m2505o(51029);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.b.a$a */
    static final class C24761a implements Runnable {
        final /* synthetic */ C24760a msV;
        final /* synthetic */ C7254cm msW;

        C24761a(C24760a c24760a, C7254cm c7254cm) {
            this.msV = c24760a;
            this.msW = c7254cm;
        }

        public final void run() {
            C45947a c45947a;
            String str;
            String str2 = null;
            AppMethodBeat.m2504i(51025);
            if (C24760a.m38648a(this.msV)) {
                c45947a = C45947a.mth;
                C45947a.bya();
            }
            C7254cm c7254cm = this.msW;
            Map z = C5049br.m7595z(c7254cm != null ? c7254cm.vEG : null, "ForcePushId");
            if (z != null) {
                str = (String) z.get(".ForcePushId");
            } else {
                str = null;
            }
            if (str == null) {
                C4990ab.m7416i(this.msV.TAG, "not a forcePush msg");
                AppMethodBeat.m2505o(51025);
                return;
            }
            String str3 = this.msV.TAG;
            String str4 = "%s %s %s";
            Object[] objArr = new Object[3];
            C7254cm c7254cm2 = this.msW;
            if (c7254cm2 != null) {
                str2 = c7254cm2.vEG;
            }
            objArr[0] = str2;
            objArr[1] = this.msW.vEB;
            objArr[2] = str;
            C4990ab.m7417i(str3, str4, objArr);
            str2 = C1946aa.m4148a(this.msW.vEB);
            if (!((C25052j.m39373j(C1853r.m3846Yz(), str2) ^ 1) == 0 || this.msV.msT.contains(str2))) {
                c45947a = C45947a.mth;
                C25052j.m39375o(str2, "fromUser");
                if (C45947a.m85333Mp(str2)) {
                    this.msV.msT.add(str2);
                    this.msV.msS.post(new Runnable(this) {
                        final /* synthetic */ C24761a msX;

                        public final void run() {
                            boolean z = true;
                            AppMethodBeat.m2504i(51024);
                            C24760a c24760a = this.msX.msV;
                            String str = str2;
                            C25052j.m39375o(str, "fromUser");
                            if (this.msX.msV.msT.size() != 1) {
                                z = false;
                            }
                            c24760a.mo41624aJ(str, z);
                            AppMethodBeat.m2505o(51024);
                        }
                    });
                }
            }
            AppMethodBeat.m2505o(51025);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService$manualAuthEventIListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ManualAuthEvent;", "callback", "", "event", "plugin-force-notify_release"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.b.a$b */
    public static final class C24763b extends C4884c<C37748jt> {
        final /* synthetic */ C24760a msV;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.b.a$b$a */
        static final class C24764a implements Runnable {
            public static final C24764a msZ = new C24764a();

            static {
                AppMethodBeat.m2504i(51027);
                AppMethodBeat.m2505o(51027);
            }

            C24764a() {
            }

            public final void run() {
                AppMethodBeat.m2504i(51026);
                new C45946a().acy();
                AppMethodBeat.m2505o(51026);
            }
        }

        C24763b(C24760a c24760a) {
            this.msV = c24760a;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(51028);
            C25052j.m39376p((C37748jt) c4883b, "event");
            C4990ab.m7417i(this.msV.TAG, "[callback] event:%s", r7);
            this.msV.msR.post(C24764a.msZ);
            AppMethodBeat.m2505o(51028);
            return true;
        }
    }

    /* renamed from: aJ */
    public abstract void mo41624aJ(String str, boolean z);

    /* renamed from: e */
    public final /* synthetic */ void mo35243e(C1331a c1331a) {
        C7254cm c7254cm = (C7254cm) c1331a;
        C25052j.m39376p(c7254cm, "addMsg");
        this.msR.post(new C24761a(this, c7254cm));
    }

    /* renamed from: f */
    public final /* bridge */ /* synthetic */ void mo35244f(C1331a c1331a) {
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        if (obj != null && (obj instanceof String)) {
            if (i == 5 || i == 4) {
                C1694a K = C1720g.m3528K(C6982j.class);
                C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                C7616ad aoO = ((C6982j) K).mo15369XM().aoO(C5046bo.m7532bc((String) obj, ""));
                if (aoO != null) {
                    if (!aoO.mo16693NX() || aoO.mo16698Oa()) {
                        C45947a c45947a = C45947a.mth;
                        String username = aoO.getUsername();
                        C25052j.m39375o(username, "contact.username");
                        C4990ab.m7417i(this.TAG, "[onNotifyChange] Delete contact[%s]  %s", obj, Boolean.valueOf(C45947a.m85334Mq(username)));
                        if (!C45947a.m85334Mq(username)) {
                            return;
                        }
                        if (aoO.mo16698Oa()) {
                            mo36069am((String) obj, 9);
                        } else {
                            mo36069am((String) obj, 7);
                        }
                    }
                }
            }
        }
    }

    public void start() {
        C21281u.m32651a(5, this);
        C1677a M = C1720g.m3530M(C6983p.class);
        C25052j.m39375o(M, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((C6983p) M).getSysCmdMsgExtension().mo14902a("NewXmlAddForcePushApplication", (C3473o) this);
        this.msU.dnU();
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
        ((C6982j) K).mo15369XM().mo10118a(this);
        this.msR.post(C20773c.mta);
    }

    public void release() {
        this.msU.dead();
        C21281u.m32652a(this);
        C1677a M = C1720g.m3530M(C6983p.class);
        C25052j.m39375o(M, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((C6983p) M).getSysCmdMsgExtension().mo14905b("NewXmlAddForcePushApplication", (C3473o) this);
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
        ((C6982j) K).mo15369XM().mo10121b(this);
    }

    public void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
        C25052j.m39376p(map, "map");
    }

    /* renamed from: a */
    public static final /* synthetic */ boolean m38648a(C24760a c24760a) {
        boolean z = C1839cb.aaE() - c24760a.msQ > 1800000;
        if (z) {
            c24760a.msQ = C1839cb.aaE();
        }
        return z;
    }
}
