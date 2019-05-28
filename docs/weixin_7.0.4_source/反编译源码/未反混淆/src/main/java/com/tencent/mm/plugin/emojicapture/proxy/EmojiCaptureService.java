package com.tencent.mm.plugin.emojicapture.proxy;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.service.MMService;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService;", "Lcom/tencent/mm/service/MMService;", "()V", "TAG", "", "onCreate", "", "onDestroy", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureService extends MMService {
    public static final a lkO = new a();
    private final String TAG = "MicroMsg.EmojiCaptureService";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureService$Companion;", "", "()V", "NOTIFY_ID", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b lkP = new b();

        static {
            AppMethodBeat.i(2839);
            AppMethodBeat.o(2839);
        }

        b() {
        }

        public final void run() {
        }
    }

    static {
        AppMethodBeat.i(2842);
        AppMethodBeat.o(2842);
    }

    public final void onCreate() {
        AppMethodBeat.i(2840);
        super.onCreate();
        ab.i(this.TAG, "onCreate: ");
        if (d.iW(26)) {
            startForeground(-2564, com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id").as(com.tencent.mm.bo.a.bWV()).e(ah.getContext().getString(R.string.g75)).build());
        }
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar = EmojiCaptureProxy.lkM;
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a.bnL();
        aVar = EmojiCaptureProxy.lkM;
        com.tencent.mm.remoteservice.d serverProxy = EmojiCaptureProxy.lkL.getServerProxy();
        if (serverProxy != null) {
            serverProxy.connect(b.lkP);
            AppMethodBeat.o(2840);
            return;
        }
        AppMethodBeat.o(2840);
    }

    public final void onDestroy() {
        AppMethodBeat.i(2841);
        super.onDestroy();
        ab.i(this.TAG, "onDestroy: ");
        dqz();
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar = EmojiCaptureProxy.lkM;
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a.bnM();
        AppMethodBeat.o(2841);
    }
}
