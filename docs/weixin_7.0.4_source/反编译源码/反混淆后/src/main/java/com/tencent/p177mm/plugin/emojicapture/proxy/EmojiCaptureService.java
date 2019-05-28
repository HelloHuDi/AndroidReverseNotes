package com.tencent.p177mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy.C20437a;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.service.MMService;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService;", "Lcom/tencent/mm/service/MMService;", "()V", "TAG", "", "onCreate", "", "onDestroy", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService */
public final class EmojiCaptureService extends MMService {
    public static final C20438a lkO = new C20438a();
    private final String TAG = "MicroMsg.EmojiCaptureService";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService$Companion;", "", "()V", "NOTIFY_ID", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService$a */
    public static final class C20438a {
        private C20438a() {
        }

        public /* synthetic */ C20438a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService$b */
    static final class C20439b implements Runnable {
        public static final C20439b lkP = new C20439b();

        static {
            AppMethodBeat.m2504i(2839);
            AppMethodBeat.m2505o(2839);
        }

        C20439b() {
        }

        public final void run() {
        }
    }

    static {
        AppMethodBeat.m2504i(2842);
        AppMethodBeat.m2505o(2842);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(2840);
        super.onCreate();
        C4990ab.m7416i(this.TAG, "onCreate: ");
        if (C1443d.m3068iW(26)) {
            startForeground(-2564, C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo616as(C45186a.bWV()).mo623e(C4996ah.getContext().getString(C25738R.string.g75)).build());
        }
        C20437a c20437a = EmojiCaptureProxy.lkM;
        C20437a.bnL();
        c20437a = EmojiCaptureProxy.lkM;
        C46607d serverProxy = EmojiCaptureProxy.lkL.getServerProxy();
        if (serverProxy != null) {
            serverProxy.connect(C20439b.lkP);
            AppMethodBeat.m2505o(2840);
            return;
        }
        AppMethodBeat.m2505o(2840);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(2841);
        super.onDestroy();
        C4990ab.m7416i(this.TAG, "onDestroy: ");
        dqz();
        C20437a c20437a = EmojiCaptureProxy.lkM;
        C20437a.bnM();
        AppMethodBeat.m2505o(2841);
    }
}
