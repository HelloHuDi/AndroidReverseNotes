package com.tencent.mm.plugin.radar.b;

import a.f.b.z;
import a.k.u;
import a.v;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012*\u0002\u000e\u0014\u0018\u0000 ?2\u00020\u0001:\u0005>?@ABB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u0012J\u0012\u0010!\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u0010\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J4\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0019H\u0002J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\"\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u001cH\u0002J\u0010\u00104\u001a\u00020\"2\u0006\u00103\u001a\u00020\u001cH\u0002J,\u00105\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0019H\u0002J\u0018\u00106\u001a\u00020)2\u0006\u00103\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0012H\u0002J\u0010\u00108\u001a\u00020)2\u0006\u00103\u001a\u00020\u001cH\u0002J\u0010\u00109\u001a\u00020)2\u0006\u00103\u001a\u00020\u001cH\u0002J\u0006\u0010:\u001a\u00020)J\u001a\u0010;\u001a\u00020)2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010<\u001a\u00020-H\u0002J\u000e\u0010=\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDelegate", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgListener", "com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1;", "needVerify", "Ljava/util/HashMap;", "", "onFMsgInfoNotify", "com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1;", "verifying", "Ljava/util/LinkedList;", "addContact", "", "username", "buildContact", "Lcom/tencent/mm/storage/Contact;", "verify", "Lcom/tencent/mm/storage/MsgInfo$VerifyContent;", "getStatus", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getVerifyMsg", "", "onAddContactReturn", "ret", "hasSendVerify", "errMsg", "timeStamp", "onCreate", "", "onDestroy", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onRecvFriendAdded", "contact", "onRecvFriendVerify", "onVerifyContactReturn", "putVerifyMsg", "msgContent", "removeVerifyMsg", "removeVerifying", "reset", "updateFMsgConversationState", "state", "verifyContact", "AddContactHelper", "Companion", "IOnAddContact", "IOnAddContactHelper", "Status", "plugin-radar_release"})
public final class c implements com.tencent.mm.sdk.e.n.b {
    public static final String TAG = TAG;
    public static final b pAR = new b();
    final Context context;
    private final ak handler = new ak();
    private final LinkedList<String> pAM = new LinkedList();
    public final HashMap<String, String> pAN = new HashMap();
    public final i pAO = new i(this);
    public final g pAP = new g(this);
    final c pAQ;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/radar/model/RadarAddContact$addContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
    public static final class f implements d {
        final /* synthetic */ String hBP;
        final /* synthetic */ c pAV;
        final /* synthetic */ long pBb;

        f(c cVar, String str, long j) {
            this.pAV = cVar;
            this.hBP = str;
            this.pBb = j;
        }

        public final void a(boolean z, boolean z2, String str, String str2) {
            AppMethodBeat.i(102876);
            if (z) {
                com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(str);
                a.f.b.j.o(aoO, "contact");
                if (aoO.Oh() > 0) {
                    t.q(aoO);
                }
                c.cS(str, 1);
                if (a.a.t.a((Iterable) this.pAV.pAM, (Object) str)) {
                    Collection a = this.pAV.pAM;
                    if (a == null) {
                        v vVar = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                        AppMethodBeat.o(102876);
                        throw vVar;
                    }
                    z.dp(a).remove(str);
                }
                ab.d(c.TAG, "addContact %s return ok", this.hBP);
            } else if (z2) {
                if (!(str == null || this.pAV.pAM.contains(str))) {
                    this.pAV.pAM.add(str);
                }
                c.cS(str, 2);
                ab.d(c.TAG, "addContact has sent verify to %s", this.hBP);
            } else {
                ab.d(c.TAG, "addContact return not ok, user canceled or error");
            }
            c.a(this.pAV, z, z2, str2, str, this.pBb);
            AppMethodBeat.o(102876);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "NODE_ENCRYPT_USERNAME", "", "NODE_TYPE", "NODE_USERNAME", "onRecieveMsg", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-radar_release"})
    public static final class g implements com.tencent.mm.model.bz.a {
        final /* synthetic */ c pAV;
        private final String pBc = ".sysmsg.addcontact.type";
        private final String pBd = ".sysmsg.addcontact.username";
        private final String pBe = ".sysmsg.addcontact.encryptusername";

        g(c cVar) {
            this.pAV = cVar;
        }

        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(102877);
            a.f.b.j.p(aVar, "addMsgInfo");
            Map z = br.z(aa.a(aVar.eAB.vED), "sysmsg");
            if (z == null) {
                AppMethodBeat.o(102877);
                return;
            }
            if (a.f.b.j.j((String) z.get(this.pBc), "1")) {
                int i;
                String str = (String) z.get(this.pBd);
                String str2 = (String) z.get(this.pBe);
                CharSequence charSequence = str;
                if (charSequence == null || u.ar(charSequence)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    charSequence = str2;
                    i = (charSequence == null || u.ar(charSequence)) ? 1 : 0;
                    if (i == 0) {
                        ad adVar = new ad();
                        adVar.setUsername(str);
                        adVar.iH(str2);
                        c.c(this.pAV, adVar);
                        ab.d(c.TAG, "receive contact added system message useranme %s, encypt %s", adVar.getUsername(), adVar.Hv());
                    }
                }
                ab.e(c.TAG, "error! server return incorrect content! : %s", r5);
                AppMethodBeat.o(102877);
                return;
            }
            AppMethodBeat.o(102877);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ String hBP;
        final /* synthetic */ String hwY;
        final /* synthetic */ c pAV;
        final /* synthetic */ long pBb;
        final /* synthetic */ boolean pBf;
        final /* synthetic */ boolean pBg;

        h(c cVar, boolean z, boolean z2, String str, String str2, long j) {
            this.pAV = cVar;
            this.pBf = z;
            this.pBg = z2;
            this.hwY = str;
            this.hBP = str2;
            this.pBb = j;
        }

        public final void run() {
            AppMethodBeat.i(102878);
            this.pAV.pAQ.a(this.pBf, this.pBg, this.hwY, this.hBP, this.pBb);
            AppMethodBeat.o(102878);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "", "(Ljava/lang/String;I)V", "Stranger", "Verifying", "Added", "NeedVerify", "plugin-radar_release"})
    public enum e {
        Stranger,
        Verifying,
        Added,
        NeedVerify;

        static {
            AppMethodBeat.o(102873);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RadarSayHiMsgEvent;", "callback", "", "event", "plugin-radar_release"})
    public static final class i extends com.tencent.mm.sdk.b.c<nb> {
        final /* synthetic */ c pAV;

        i(c cVar) {
            this.pAV = cVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(102879);
            nb nbVar = (nb) bVar;
            a.f.b.j.p(nbVar, "event");
            String str = nbVar.cJf.cJh;
            ad a = c.a(com.tencent.mm.storage.bi.d.apF(str));
            c.a(this.pAV, a);
            c cVar = this.pAV;
            a.f.b.j.o(str, "msgContent");
            c.a(cVar, a, str);
            com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
            bd XM = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM();
            if (!XM.aoQ(a.Hv())) {
                XM.Y(a);
            }
            ab.d(c.TAG, "receive verify mssage %s, encypt %s", a.getUsername(), a.Hv());
            c.b(this.pAV, a);
            AppMethodBeat.o(102879);
            return false;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class j implements Runnable {
        final /* synthetic */ c pAV;
        final /* synthetic */ ad pBh;

        j(c cVar, ad adVar) {
            this.pAV = cVar;
            this.pBh = adVar;
        }

        public final void run() {
            AppMethodBeat.i(102880);
            this.pAV.pAQ.Q(this.pBh);
            AppMethodBeat.o(102880);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ c pAV;
        final /* synthetic */ ad pBh;

        k(c cVar, ad adVar) {
            this.pAV = cVar;
            this.pBh = adVar;
        }

        public final void run() {
            AppMethodBeat.i(102881);
            this.pAV.pAQ.R(this.pBh);
            AppMethodBeat.o(102881);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/radar/model/RadarAddContact$verifyContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
    public static final class m implements d {
        final /* synthetic */ c pAV;
        final /* synthetic */ long pBb;
        final /* synthetic */ String pBi;

        public m(c cVar, String str, long j) {
            this.pAV = cVar;
            this.pBi = str;
            this.pBb = j;
        }

        public final void a(boolean z, boolean z2, String str, String str2) {
            boolean z3;
            AppMethodBeat.i(102883);
            if (z) {
                com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(str);
                if (aoO == null || aoO.Oh() == 0) {
                    ad a = c.a(com.tencent.mm.storage.bi.d.apF(this.pBi));
                    K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                    a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
                    if (!((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().Z(a)) {
                        ab.e(c.TAG, "canAddContact fail, insert fail");
                        z = false;
                    }
                    K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                    a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
                    aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(a.getUsername());
                }
                ab.d(c.TAG, "verifyContact return ok");
                t.q(aoO);
                c.cS(str, 1);
                z3 = z;
            } else {
                ab.d(c.TAG, "verifyContact return not ok");
                z3 = z;
            }
            c.a(this.pAV, z3, str2, str, this.pBb);
            AppMethodBeat.o(102883);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J,\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J \u0010\u001c\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$AddContactHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "callback", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;)V", "lstScene", "Ljava/util/LinkedList;", "", "lstUsername", "", "mUsername", "addContact", "", "username", "finish", "ok", "", "hasSentVerify", "respUsername", "errMsg", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "onStop", "sendVerifyRequest", "verifyOk", "verifyTicket", "plugin-radar_release"})
    public final class a implements com.tencent.mm.ai.f {
        String igi;
        final LinkedList<String> pAS = new LinkedList();
        LinkedList<Integer> pAT;
        private final d pAU;

        public a(d dVar) {
            AppMethodBeat.i(102872);
            this.pAU = dVar;
            AppMethodBeat.o(102872);
        }

        public final void onStart() {
            AppMethodBeat.i(102869);
            com.tencent.mm.kernel.g.Rg().a(30, (com.tencent.mm.ai.f) this);
            AppMethodBeat.o(102869);
        }

        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
            AppMethodBeat.i(102871);
            a.f.b.j.p(mVar, "scene");
            ab.d(c.TAG, "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (mVar.getType() != 30) {
                ab.w(c.TAG, "not expected scene,  type = " + mVar.getType());
                AppMethodBeat.o(102871);
                return;
            }
            if (((com.tencent.mm.pluginsdk.model.m) mVar).dhm() == 2) {
                if (i == 0 && i2 == 0) {
                    b(false, true, this.igi, "");
                    AppMethodBeat.o(102871);
                    return;
                } else if (i == 4 && i2 == -34) {
                    str = c.this.context.getString(R.string.bwe);
                } else if (i == 4 && i2 == -94) {
                    str = c.this.context.getString(R.string.bwh);
                } else if (i != 4 || (!(i2 == -24 || i2 == XWalkUpdater.ERROR_SET_VERNUM) || str == null)) {
                    str = c.this.context.getString(R.string.e3n);
                }
            } else if (i == 0 && i2 == 0) {
                b(true, false, this.igi, "");
                AppMethodBeat.o(102871);
                return;
            } else if (i2 == -44) {
                com.tencent.mm.kernel.g.Rg().d((com.tencent.mm.ai.m) new com.tencent.mm.pluginsdk.model.m(2, this.pAS, this.pAT, "", ""));
                AppMethodBeat.o(102871);
                return;
            } else if (i2 == -87) {
                b(false, false, this.igi, c.this.context.getString(R.string.aui));
                AppMethodBeat.o(102871);
                return;
            } else if (i2 == -24 && !bo.isNullOrNil(str)) {
                String str2 = this.igi;
                if (str == null) {
                    str = "";
                }
                b(false, false, str2, str);
                AppMethodBeat.o(102871);
                return;
            } else if (i == 4 && i2 == -22) {
                str = c.this.context.getString(R.string.da);
            } else {
                str = c.this.context.getString(R.string.d_);
            }
            b(false, false, this.igi, str);
            AppMethodBeat.o(102871);
        }

        private final void b(boolean z, boolean z2, String str, String str2) {
            AppMethodBeat.i(102870);
            com.tencent.mm.kernel.g.Rg().b(30, (com.tencent.mm.ai.f) this);
            d dVar = this.pAU;
            if (dVar != null) {
                dVar.a(z, z2, str, str2);
                AppMethodBeat.o(102870);
                return;
            }
            AppMethodBeat.o(102870);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J,\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "", "onAddContactReturn", "", "ok", "", "hasSentVerify", "errMsg", "", "username", "timeStamp", "", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onVerifyContactReturn", "plugin-radar_release"})
    public interface c {
        void Q(ad adVar);

        void R(ad adVar);

        void a(boolean z, String str, String str2, long j);

        void a(boolean z, boolean z2, String str, String str2, long j);
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class l implements Runnable {
        final /* synthetic */ String hBP;
        final /* synthetic */ String hwY;
        final /* synthetic */ c pAV;
        final /* synthetic */ long pBb;
        final /* synthetic */ boolean pBf;

        l(c cVar, boolean z, String str, String str2, long j) {
            this.pAV = cVar;
            this.pBf = z;
            this.hwY = str;
            this.hBP = str2;
            this.pBb = j;
        }

        public final void run() {
            AppMethodBeat.i(102882);
            this.pAV.pAQ.a(this.pBf, this.hwY, this.hBP, this.pBb);
            AppMethodBeat.o(102882);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
    public interface d {
        void a(boolean z, boolean z2, String str, String str2);
    }

    public c(c cVar, Context context) {
        a.f.b.j.p(cVar, "delegate");
        a.f.b.j.p(context, "context");
        AppMethodBeat.i(102890);
        this.pAQ = cVar;
        this.context = context;
        AppMethodBeat.o(102890);
    }

    public static final /* synthetic */ void a(c cVar, ad adVar) {
        AppMethodBeat.i(102896);
        cVar.O(adVar);
        AppMethodBeat.o(102896);
    }

    public static final /* synthetic */ void c(c cVar, ad adVar) {
        AppMethodBeat.i(102899);
        cVar.Q(adVar);
        AppMethodBeat.o(102899);
    }

    public final long Vw(String str) {
        AppMethodBeat.i(102884);
        a.f.b.j.p(str, "username");
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(new f(this, str, currentTimeMillis));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(48));
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        aVar.onStart();
        aVar.pAT = linkedList;
        aVar.igi = str;
        if (str != null) {
            aVar.pAS.add(str);
        }
        com.tencent.mm.kernel.g.Rg().d((com.tencent.mm.ai.m) new com.tencent.mm.pluginsdk.model.m(2, aVar.pAS, linkedList, "", ""));
        AppMethodBeat.o(102884);
        return currentTimeMillis;
    }

    public final e Vx(String str) {
        e eVar;
        AppMethodBeat.i(102885);
        a.f.b.j.p(str, "username");
        com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(str);
        if (aoO == null || aoO.Oh() == 0) {
            if (this.pAM.contains(str)) {
                eVar = e.Verifying;
            } else {
                eVar = e.Stranger;
            }
        } else if (aoO.NX()) {
            eVar = e.Added;
        } else if (this.pAN.containsKey(str)) {
            eVar = e.NeedVerify;
        } else if (this.pAM.contains(str)) {
            eVar = e.Verifying;
        } else {
            eVar = e.Stranger;
        }
        ab.d(TAG, "query username(%s) status %s", str, eVar);
        AppMethodBeat.o(102885);
        return eVar;
    }

    private final void O(ad adVar) {
        AppMethodBeat.i(102886);
        if (this.pAM.contains(adVar.getUsername())) {
            this.pAM.remove(adVar.getUsername());
        }
        if (this.pAM.contains(adVar.Hv())) {
            this.pAM.remove(adVar.Hv());
        }
        AppMethodBeat.o(102886);
    }

    private final void P(ad adVar) {
        AppMethodBeat.i(102887);
        this.pAN.remove(adVar.getUsername());
        this.pAN.remove(adVar.Hv());
        AppMethodBeat.o(102887);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(102888);
        a.f.b.j.p(nVar, "stg");
        ab.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
        if (obj == null || !(obj instanceof String)) {
            ab.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(102888);
            return;
        }
        String str = (String) obj;
        com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(str);
        if (aoO != null && aoO.NX()) {
            ab.d(TAG, "ContactStg onNotifyChange %s", str);
            Q(aoO);
        }
        AppMethodBeat.o(102888);
    }

    private final void Q(ad adVar) {
        AppMethodBeat.i(102889);
        O(adVar);
        P(adVar);
        this.handler.post(new j(this, adVar));
        AppMethodBeat.o(102889);
    }

    static {
        AppMethodBeat.i(102891);
        AppMethodBeat.o(102891);
    }

    public static final /* synthetic */ void cS(String str, int i) {
        AppMethodBeat.i(102892);
        fy fyVar = new fy();
        fyVar.cAb.cAd = 0;
        fyVar.cAb.talker = str;
        fyVar.cAb.state = i;
        com.tencent.mm.sdk.b.a.xxA.m(fyVar);
        AppMethodBeat.o(102892);
    }

    public static final /* synthetic */ boolean a(c cVar, boolean z, boolean z2, String str, String str2, long j) {
        AppMethodBeat.i(102893);
        boolean post = cVar.handler.post(new h(cVar, z, z2, str, str2, j));
        AppMethodBeat.o(102893);
        return post;
    }

    public static final /* synthetic */ boolean a(c cVar, boolean z, String str, String str2, long j) {
        AppMethodBeat.i(102895);
        boolean post = cVar.handler.post(new l(cVar, z, str, str2, j));
        AppMethodBeat.o(102895);
        return post;
    }

    public static final /* synthetic */ boolean b(c cVar, ad adVar) {
        AppMethodBeat.i(102898);
        boolean post = cVar.handler.post(new k(cVar, adVar));
        AppMethodBeat.o(102898);
        return post;
    }
}
