package com.tencent.mm.emoji.loader;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "load", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "loadRemote", "md5", "", "Companion", "plugin-emojisdk_release"})
public final class EmojiLoaderProxy extends com.tencent.mm.remoteservice.a {
    private static EmojiLoaderProxy exu = new EmojiLoaderProxy(new d(ah.getContext()));
    private static int exv;
    private static boolean exw = true;
    public static final a exx = new a();
    private final d ext;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "getInstance", "()Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "setInstance", "(Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;)V", "needCreate", "", "requestCount", "", "requestConnect", "", "tryRelease", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public EmojiLoaderProxy(d dVar) {
        super(dVar);
        this.ext = dVar;
    }

    public final d getServerProxy() {
        return this.ext;
    }

    static {
        AppMethodBeat.i(63164);
        AppMethodBeat.o(63164);
    }

    public final void load(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63162);
        j.p(emojiInfo, "emojiInfo");
        ab.i("MicroMsg.EmojiLoaderProxy", "load: " + emojiInfo.Aq());
        REMOTE_CALL("loadRemote", emojiInfo.Aq());
        AppMethodBeat.o(63162);
    }

    @f
    public final void loadRemote(String str) {
        AppMethodBeat.i(63163);
        j.p(str, "md5");
        ab.i("MicroMsg.EmojiLoaderProxy", "loadRemote: ".concat(String.valueOf(str)));
        at dsZ = at.dsZ();
        j.o(dsZ, "EmojiStorageMgr.getInstance()");
        EmojiInfo aqi = dsZ.aUp().aqi(str);
        if (aqi == null) {
            AppMethodBeat.o(63163);
            return;
        }
        a aVar = a.exs;
        a.c(aqi);
        AppMethodBeat.o(63163);
    }
}
