package com.tencent.p177mm.plugin.radar.p488b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18269fy;
import com.tencent.p177mm.p230g.p231a.C6524nb;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C0014z;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012*\u0002\u000e\u0014\u0018\u0000 ?2\u00020\u0001:\u0005>?@ABB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u0012J\u0012\u0010!\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u0010\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J4\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0019H\u0002J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\"\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u001cH\u0002J\u0010\u00104\u001a\u00020\"2\u0006\u00103\u001a\u00020\u001cH\u0002J,\u00105\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0019H\u0002J\u0018\u00106\u001a\u00020)2\u0006\u00103\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0012H\u0002J\u0010\u00108\u001a\u00020)2\u0006\u00103\u001a\u00020\u001cH\u0002J\u0010\u00109\u001a\u00020)2\u0006\u00103\u001a\u00020\u001cH\u0002J\u0006\u0010:\u001a\u00020)J\u001a\u0010;\u001a\u00020)2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010<\u001a\u00020-H\u0002J\u000e\u0010=\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getDelegate", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgListener", "com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1;", "needVerify", "Ljava/util/HashMap;", "", "onFMsgInfoNotify", "com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1;", "verifying", "Ljava/util/LinkedList;", "addContact", "", "username", "buildContact", "Lcom/tencent/mm/storage/Contact;", "verify", "Lcom/tencent/mm/storage/MsgInfo$VerifyContent;", "getStatus", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getVerifyMsg", "", "onAddContactReturn", "ret", "hasSendVerify", "errMsg", "timeStamp", "onCreate", "", "onDestroy", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onRecvFriendAdded", "contact", "onRecvFriendVerify", "onVerifyContactReturn", "putVerifyMsg", "msgContent", "removeVerifyMsg", "removeVerifying", "reset", "updateFMsgConversationState", "state", "verifyContact", "AddContactHelper", "Companion", "IOnAddContact", "IOnAddContactHelper", "Status", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.b.c */
public final class C43413c implements C4937b {
    public static final String TAG = TAG;
    public static final C43414b pAR = new C43414b();
    final Context context;
    private final C7306ak handler = new C7306ak();
    private final LinkedList<String> pAM = new LinkedList();
    public final HashMap<String, String> pAN = new HashMap();
    public final C34761i pAO = new C34761i(this);
    public final C12929g pAP = new C12929g(this);
    final C39548c pAQ;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/radar/model/RadarAddContact$addContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$f */
    public static final class C3673f implements C43415d {
        final /* synthetic */ String hBP;
        final /* synthetic */ C43413c pAV;
        final /* synthetic */ long pBb;

        C3673f(C43413c c43413c, String str, long j) {
            this.pAV = c43413c;
            this.hBP = str;
            this.pBb = j;
        }

        /* renamed from: a */
        public final void mo8282a(boolean z, boolean z2, String str, String str2) {
            AppMethodBeat.m2504i(102876);
            if (z) {
                C1694a K = C1720g.m3528K(C6982j.class);
                C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
                C25052j.m39375o(aoO, "contact");
                if (aoO.mo16705Oh() > 0) {
                    C1855t.m3960q(aoO);
                }
                C43413c.m77494cS(str, 1);
                if (C25035t.m39327a((Iterable) this.pAV.pAM, (Object) str)) {
                    Collection a = this.pAV.pAM;
                    if (a == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                        AppMethodBeat.m2505o(102876);
                        throw c44941v;
                    }
                    C0014z.m4dp(a).remove(str);
                }
                C4990ab.m7411d(C43413c.TAG, "addContact %s return ok", this.hBP);
            } else if (z2) {
                if (!(str == null || this.pAV.pAM.contains(str))) {
                    this.pAV.pAM.add(str);
                }
                C43413c.m77494cS(str, 2);
                C4990ab.m7411d(C43413c.TAG, "addContact has sent verify to %s", this.hBP);
            } else {
                C4990ab.m7410d(C43413c.TAG, "addContact return not ok, user canceled or error");
            }
            C43413c.m77491a(this.pAV, z, z2, str2, str, this.pBb);
            AppMethodBeat.m2505o(102876);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/radar/model/RadarAddContact$msgListener$1", "Lcom/tencent/mm/model/SysCmdMsgExtension$ISysCmdMsgListener;", "NODE_ENCRYPT_USERNAME", "", "NODE_TYPE", "NODE_USERNAME", "onRecieveMsg", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$g */
    public static final class C12929g implements C1837a {
        final /* synthetic */ C43413c pAV;
        private final String pBc = ".sysmsg.addcontact.type";
        private final String pBd = ".sysmsg.addcontact.username";
        private final String pBe = ".sysmsg.addcontact.encryptusername";

        C12929g(C43413c c43413c) {
            this.pAV = c43413c;
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(102877);
            C25052j.m39376p(c1197a, "addMsgInfo");
            Map z = C5049br.m7595z(C1946aa.m4148a(c1197a.eAB.vED), "sysmsg");
            if (z == null) {
                AppMethodBeat.m2505o(102877);
                return;
            }
            if (C25052j.m39373j((String) z.get(this.pBc), "1")) {
                int i;
                String str = (String) z.get(this.pBd);
                String str2 = (String) z.get(this.pBe);
                CharSequence charSequence = str;
                if (charSequence == null || C6163u.m9837ar(charSequence)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    charSequence = str2;
                    i = (charSequence == null || C6163u.m9837ar(charSequence)) ? 1 : 0;
                    if (i == 0) {
                        C7616ad c7616ad = new C7616ad();
                        c7616ad.setUsername(str);
                        c7616ad.mo14709iH(str2);
                        C43413c.m77493c(this.pAV, c7616ad);
                        C4990ab.m7411d(C43413c.TAG, "receive contact added system message useranme %s, encypt %s", c7616ad.getUsername(), c7616ad.mo14678Hv());
                    }
                }
                C4990ab.m7413e(C43413c.TAG, "error! server return incorrect content! : %s", r5);
                AppMethodBeat.m2505o(102877);
                return;
            }
            AppMethodBeat.m2505o(102877);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$h */
    static final class C12930h implements Runnable {
        final /* synthetic */ String hBP;
        final /* synthetic */ String hwY;
        final /* synthetic */ C43413c pAV;
        final /* synthetic */ long pBb;
        final /* synthetic */ boolean pBf;
        final /* synthetic */ boolean pBg;

        C12930h(C43413c c43413c, boolean z, boolean z2, String str, String str2, long j) {
            this.pAV = c43413c;
            this.pBf = z;
            this.pBg = z2;
            this.hwY = str;
            this.hBP = str2;
            this.pBb = j;
        }

        public final void run() {
            AppMethodBeat.m2504i(102878);
            this.pAV.pAQ.mo58658a(this.pBf, this.pBg, this.hwY, this.hBP, this.pBb);
            AppMethodBeat.m2505o(102878);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "", "(Ljava/lang/String;I)V", "Stranger", "Verifying", "Added", "NeedVerify", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$e */
    public enum C21556e {
        Stranger,
        Verifying,
        Added,
        NeedVerify;

        static {
            AppMethodBeat.m2505o(102873);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/model/RadarAddContact$onFMsgInfoNotify$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RadarSayHiMsgEvent;", "callback", "", "event", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$i */
    public static final class C34761i extends C4884c<C6524nb> {
        final /* synthetic */ C43413c pAV;

        C34761i(C43413c c43413c) {
            this.pAV = c43413c;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(102879);
            C6524nb c6524nb = (C6524nb) c4883b;
            C25052j.m39376p(c6524nb, "event");
            String str = c6524nb.cJf.cJh;
            C7616ad a = C43413c.m77486a(C5138d.apF(str));
            C43413c.m77488a(this.pAV, a);
            C43413c c43413c = this.pAV;
            C25052j.m39375o(str, "msgContent");
            C43413c.m77489a(c43413c, a, str);
            C1694a K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
            C7309bd XM = ((C6982j) K).mo15369XM();
            if (!XM.aoQ(a.mo14678Hv())) {
                XM.mo15701Y(a);
            }
            C4990ab.m7411d(C43413c.TAG, "receive verify mssage %s, encypt %s", a.getUsername(), a.mo14678Hv());
            C43413c.m77492b(this.pAV, a);
            AppMethodBeat.m2505o(102879);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$j */
    static final class C34762j implements Runnable {
        final /* synthetic */ C43413c pAV;
        final /* synthetic */ C7616ad pBh;

        C34762j(C43413c c43413c, C7616ad c7616ad) {
            this.pAV = c43413c;
            this.pBh = c7616ad;
        }

        public final void run() {
            AppMethodBeat.m2504i(102880);
            this.pAV.pAQ.mo58655Q(this.pBh);
            AppMethodBeat.m2505o(102880);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$k */
    static final class C34763k implements Runnable {
        final /* synthetic */ C43413c pAV;
        final /* synthetic */ C7616ad pBh;

        C34763k(C43413c c43413c, C7616ad c7616ad) {
            this.pAV = c43413c;
            this.pBh = c7616ad;
        }

        public final void run() {
            AppMethodBeat.m2504i(102881);
            this.pAV.pAQ.mo58656R(this.pBh);
            AppMethodBeat.m2505o(102881);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/radar/model/RadarAddContact$verifyContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$m */
    public static final class C34764m implements C43415d {
        final /* synthetic */ C43413c pAV;
        final /* synthetic */ long pBb;
        final /* synthetic */ String pBi;

        public C34764m(C43413c c43413c, String str, long j) {
            this.pAV = c43413c;
            this.pBi = str;
            this.pBb = j;
        }

        /* renamed from: a */
        public final void mo8282a(boolean z, boolean z2, String str, String str2) {
            boolean z3;
            AppMethodBeat.m2504i(102883);
            if (z) {
                C1694a K = C1720g.m3528K(C6982j.class);
                C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
                if (aoO == null || aoO.mo16705Oh() == 0) {
                    C7616ad a = C43413c.m77486a(C5138d.apF(this.pBi));
                    K = C1720g.m3528K(C6982j.class);
                    C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                    if (!((C6982j) K).mo15369XM().mo15702Z(a)) {
                        C4990ab.m7412e(C43413c.TAG, "canAddContact fail, insert fail");
                        z = false;
                    }
                    K = C1720g.m3528K(C6982j.class);
                    C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                    aoO = ((C6982j) K).mo15369XM().aoO(a.getUsername());
                }
                C4990ab.m7410d(C43413c.TAG, "verifyContact return ok");
                C1855t.m3960q(aoO);
                C43413c.m77494cS(str, 1);
                z3 = z;
            } else {
                C4990ab.m7410d(C43413c.TAG, "verifyContact return not ok");
                z3 = z;
            }
            C43413c.m77490a(this.pAV, z3, str2, str, this.pBb);
            AppMethodBeat.m2505o(102883);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J,\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J \u0010\u001c\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$AddContactHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "callback", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;)V", "lstScene", "Ljava/util/LinkedList;", "", "lstUsername", "", "mUsername", "addContact", "", "username", "finish", "ok", "", "hasSentVerify", "respUsername", "errMsg", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "onStop", "sendVerifyRequest", "verifyOk", "verifyTicket", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$a */
    public final class C39547a implements C1202f {
        String igi;
        final LinkedList<String> pAS = new LinkedList();
        LinkedList<Integer> pAT;
        private final C43415d pAU;

        public C39547a(C43415d c43415d) {
            AppMethodBeat.m2504i(102872);
            this.pAU = c43415d;
            AppMethodBeat.m2505o(102872);
        }

        public final void onStart() {
            AppMethodBeat.m2504i(102869);
            C1720g.m3540Rg().mo14539a(30, (C1202f) this);
            AppMethodBeat.m2505o(102869);
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(102871);
            C25052j.m39376p(c1207m, "scene");
            C4990ab.m7410d(C43413c.TAG, "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (c1207m.getType() != 30) {
                C4990ab.m7420w(C43413c.TAG, "not expected scene,  type = " + c1207m.getType());
                AppMethodBeat.m2505o(102871);
                return;
            }
            if (((C46498m) c1207m).dhm() == 2) {
                if (i == 0 && i2 == 0) {
                    m67575b(false, true, this.igi, "");
                    AppMethodBeat.m2505o(102871);
                    return;
                } else if (i == 4 && i2 == -34) {
                    str = C43413c.this.context.getString(C25738R.string.bwe);
                } else if (i == 4 && i2 == -94) {
                    str = C43413c.this.context.getString(C25738R.string.bwh);
                } else if (i != 4 || (!(i2 == -24 || i2 == XWalkUpdater.ERROR_SET_VERNUM) || str == null)) {
                    str = C43413c.this.context.getString(C25738R.string.e3n);
                }
            } else if (i == 0 && i2 == 0) {
                m67575b(true, false, this.igi, "");
                AppMethodBeat.m2505o(102871);
                return;
            } else if (i2 == -44) {
                C1720g.m3540Rg().mo14552d((C1207m) new C46498m(2, this.pAS, this.pAT, "", ""));
                AppMethodBeat.m2505o(102871);
                return;
            } else if (i2 == -87) {
                m67575b(false, false, this.igi, C43413c.this.context.getString(C25738R.string.aui));
                AppMethodBeat.m2505o(102871);
                return;
            } else if (i2 == -24 && !C5046bo.isNullOrNil(str)) {
                String str2 = this.igi;
                if (str == null) {
                    str = "";
                }
                m67575b(false, false, str2, str);
                AppMethodBeat.m2505o(102871);
                return;
            } else if (i == 4 && i2 == -22) {
                str = C43413c.this.context.getString(C25738R.string.f8727da);
            } else {
                str = C43413c.this.context.getString(C25738R.string.f8726d_);
            }
            m67575b(false, false, this.igi, str);
            AppMethodBeat.m2505o(102871);
        }

        /* renamed from: b */
        private final void m67575b(boolean z, boolean z2, String str, String str2) {
            AppMethodBeat.m2504i(102870);
            C1720g.m3540Rg().mo14546b(30, (C1202f) this);
            C43415d c43415d = this.pAU;
            if (c43415d != null) {
                c43415d.mo8282a(z, z2, str, str2);
                AppMethodBeat.m2505o(102870);
                return;
            }
            AppMethodBeat.m2505o(102870);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J,\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "", "onAddContactReturn", "", "ok", "", "hasSentVerify", "errMsg", "", "username", "timeStamp", "", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onVerifyContactReturn", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$c */
    public interface C39548c {
        /* renamed from: Q */
        void mo58655Q(C7616ad c7616ad);

        /* renamed from: R */
        void mo58656R(C7616ad c7616ad);

        /* renamed from: a */
        void mo58657a(boolean z, String str, String str2, long j);

        /* renamed from: a */
        void mo58658a(boolean z, boolean z2, String str, String str2, long j);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$l */
    static final class C43412l implements Runnable {
        final /* synthetic */ String hBP;
        final /* synthetic */ String hwY;
        final /* synthetic */ C43413c pAV;
        final /* synthetic */ long pBb;
        final /* synthetic */ boolean pBf;

        C43412l(C43413c c43413c, boolean z, String str, String str2, long j) {
            this.pAV = c43413c;
            this.pBf = z;
            this.hwY = str;
            this.hBP = str2;
            this.pBb = j;
        }

        public final void run() {
            AppMethodBeat.m2504i(102882);
            this.pAV.pAQ.mo58657a(this.pBf, this.hwY, this.hBP, this.pBb);
            AppMethodBeat.m2505o(102882);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$b */
    public static final class C43414b {
        private C43414b() {
        }

        public /* synthetic */ C43414b(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.c$d */
    public interface C43415d {
        /* renamed from: a */
        void mo8282a(boolean z, boolean z2, String str, String str2);
    }

    public C43413c(C39548c c39548c, Context context) {
        C25052j.m39376p(c39548c, "delegate");
        C25052j.m39376p(context, "context");
        AppMethodBeat.m2504i(102890);
        this.pAQ = c39548c;
        this.context = context;
        AppMethodBeat.m2505o(102890);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m77488a(C43413c c43413c, C7616ad c7616ad) {
        AppMethodBeat.m2504i(102896);
        c43413c.m77483O(c7616ad);
        AppMethodBeat.m2505o(102896);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m77493c(C43413c c43413c, C7616ad c7616ad) {
        AppMethodBeat.m2504i(102899);
        c43413c.m77485Q(c7616ad);
        AppMethodBeat.m2505o(102899);
    }

    /* renamed from: Vw */
    public final long mo68962Vw(String str) {
        AppMethodBeat.m2504i(102884);
        C25052j.m39376p(str, "username");
        long currentTimeMillis = System.currentTimeMillis();
        C39547a c39547a = new C39547a(new C3673f(this, str, currentTimeMillis));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(48));
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        c39547a.onStart();
        c39547a.pAT = linkedList;
        c39547a.igi = str;
        if (str != null) {
            c39547a.pAS.add(str);
        }
        C1720g.m3540Rg().mo14552d((C1207m) new C46498m(2, c39547a.pAS, linkedList, "", ""));
        AppMethodBeat.m2505o(102884);
        return currentTimeMillis;
    }

    /* renamed from: Vx */
    public final C21556e mo68963Vx(String str) {
        C21556e c21556e;
        AppMethodBeat.m2504i(102885);
        C25052j.m39376p(str, "username");
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
        C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
        if (aoO == null || aoO.mo16705Oh() == 0) {
            if (this.pAM.contains(str)) {
                c21556e = C21556e.Verifying;
            } else {
                c21556e = C21556e.Stranger;
            }
        } else if (aoO.mo16693NX()) {
            c21556e = C21556e.Added;
        } else if (this.pAN.containsKey(str)) {
            c21556e = C21556e.NeedVerify;
        } else if (this.pAM.contains(str)) {
            c21556e = C21556e.Verifying;
        } else {
            c21556e = C21556e.Stranger;
        }
        C4990ab.m7411d(TAG, "query username(%s) status %s", str, c21556e);
        AppMethodBeat.m2505o(102885);
        return c21556e;
    }

    /* renamed from: O */
    private final void m77483O(C7616ad c7616ad) {
        AppMethodBeat.m2504i(102886);
        if (this.pAM.contains(c7616ad.getUsername())) {
            this.pAM.remove(c7616ad.getUsername());
        }
        if (this.pAM.contains(c7616ad.mo14678Hv())) {
            this.pAM.remove(c7616ad.mo14678Hv());
        }
        AppMethodBeat.m2505o(102886);
    }

    /* renamed from: P */
    private final void m77484P(C7616ad c7616ad) {
        AppMethodBeat.m2504i(102887);
        this.pAN.remove(c7616ad.getUsername());
        this.pAN.remove(c7616ad.mo14678Hv());
        AppMethodBeat.m2505o(102887);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(102888);
        C25052j.m39376p(c7298n, "stg");
        C4990ab.m7411d(TAG, "onNotifyChange event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7413e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(102888);
            return;
        }
        String str = (String) obj;
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
        C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
        if (aoO != null && aoO.mo16693NX()) {
            C4990ab.m7411d(TAG, "ContactStg onNotifyChange %s", str);
            m77485Q(aoO);
        }
        AppMethodBeat.m2505o(102888);
    }

    /* renamed from: Q */
    private final void m77485Q(C7616ad c7616ad) {
        AppMethodBeat.m2504i(102889);
        m77483O(c7616ad);
        m77484P(c7616ad);
        this.handler.post(new C34762j(this, c7616ad));
        AppMethodBeat.m2505o(102889);
    }

    static {
        AppMethodBeat.m2504i(102891);
        AppMethodBeat.m2505o(102891);
    }

    /* renamed from: cS */
    public static final /* synthetic */ void m77494cS(String str, int i) {
        AppMethodBeat.m2504i(102892);
        C18269fy c18269fy = new C18269fy();
        c18269fy.cAb.cAd = 0;
        c18269fy.cAb.talker = str;
        c18269fy.cAb.state = i;
        C4879a.xxA.mo10055m(c18269fy);
        AppMethodBeat.m2505o(102892);
    }

    /* renamed from: a */
    public static final /* synthetic */ boolean m77491a(C43413c c43413c, boolean z, boolean z2, String str, String str2, long j) {
        AppMethodBeat.m2504i(102893);
        boolean post = c43413c.handler.post(new C12930h(c43413c, z, z2, str, str2, j));
        AppMethodBeat.m2505o(102893);
        return post;
    }

    /* renamed from: a */
    public static final /* synthetic */ boolean m77490a(C43413c c43413c, boolean z, String str, String str2, long j) {
        AppMethodBeat.m2504i(102895);
        boolean post = c43413c.handler.post(new C43412l(c43413c, z, str, str2, j));
        AppMethodBeat.m2505o(102895);
        return post;
    }

    /* renamed from: b */
    public static final /* synthetic */ boolean m77492b(C43413c c43413c, C7616ad c7616ad) {
        AppMethodBeat.m2504i(102898);
        boolean post = c43413c.handler.post(new C34763k(c43413c, c7616ad));
        AppMethodBeat.m2505o(102898);
        return post;
    }
}
