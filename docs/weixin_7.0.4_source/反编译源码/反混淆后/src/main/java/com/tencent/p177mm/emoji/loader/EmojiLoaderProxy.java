package com.tencent.p177mm.emoji.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "load", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "loadRemote", "md5", "", "Companion", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.EmojiLoaderProxy */
public final class EmojiLoaderProxy extends C31577a {
    private static EmojiLoaderProxy exu = new EmojiLoaderProxy(new C46607d(C4996ah.getContext()));
    private static int exv;
    private static boolean exw = true;
    public static final C1518a exx = new C1518a();
    private final C46607d ext;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "getInstance", "()Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "setInstance", "(Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;)V", "needCreate", "", "requestCount", "", "requestConnect", "", "tryRelease", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.loader.EmojiLoaderProxy$a */
    public static final class C1518a {
        private C1518a() {
        }

        public /* synthetic */ C1518a(byte b) {
            this();
        }
    }

    public EmojiLoaderProxy(C46607d c46607d) {
        super(c46607d);
        this.ext = c46607d;
    }

    public final C46607d getServerProxy() {
        return this.ext;
    }

    static {
        AppMethodBeat.m2504i(63164);
        AppMethodBeat.m2505o(63164);
    }

    public final void load(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63162);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C4990ab.m7416i("MicroMsg.EmojiLoaderProxy", "load: " + emojiInfo.mo20410Aq());
        REMOTE_CALL("loadRemote", emojiInfo.mo20410Aq());
        AppMethodBeat.m2505o(63162);
    }

    @C46608f
    public final void loadRemote(String str) {
        AppMethodBeat.m2504i(63163);
        C25052j.m39376p(str, "md5");
        C4990ab.m7416i("MicroMsg.EmojiLoaderProxy", "loadRemote: ".concat(String.valueOf(str)));
        C23505at dsZ = C23505at.dsZ();
        C25052j.m39375o(dsZ, "EmojiStorageMgr.getInstance()");
        EmojiInfo aqi = dsZ.aUp().aqi(str);
        if (aqi == null) {
            AppMethodBeat.m2505o(63163);
            return;
        }
        C37682a c37682a = C37682a.exs;
        C37682a.m63727c(aqi);
        AppMethodBeat.m2505o(63163);
    }
}
