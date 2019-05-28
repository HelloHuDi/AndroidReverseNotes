package com.tencent.mm.emoji.sync;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\r\u0018\u0000 :2\u00020\u0001:\u0003:;<B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020'H\u0002J\u0006\u0010,\u001a\u00020'J\u0016\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001cJ\u0006\u00100\u001a\u00020'J\u0006\u00101\u001a\u00020'J\u000e\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u0011J\u000e\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020'2\u0006\u00106\u001a\u00020\u001cJ\b\u00107\u001a\u00020'H\u0002J\u0006\u00108\u001a\u00020'J\u000e\u00109\u001a\u00020'2\u0006\u00105\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR2\u0010\u000f\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00130\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00038F@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\u0004R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u001d@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\u0004¨\u0006="}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "", "customType", "", "(I)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/SyncCallback;", "connectivityReceiver", "Landroid/content/BroadcastReceiver;", "getCustomType", "()I", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1;", "downloadList", "", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "<set-?>", "remainSize", "getRemainSize", "setRemainSize", "startNonWifi", "", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncState", "getSyncState", "()Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "setSyncState", "(Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;)V", "totalSize", "getTotalSize", "setTotalSize", "addDownloadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkAutoStart", "checkBroken", "checkSync", "checkSyncEmoji", "start", "withBroken", "destroy", "init", "markBroken", "md5", "registerCallback", "callback", "force", "startInternal", "stop", "unregisterCallback", "Companion", "ConnectivityReceiver", "SyncState", "plugin-emojisdk_release"})
public final class EmojiSyncManager {
    public static final a ezA = new a();
    private static EmojiSyncManager ezy;
    private static EmojiSyncManager ezz;
    private BroadcastReceiver aGB;
    private final com.tencent.mm.loader.g.d<a> ezq = new com.tencent.mm.loader.g.d(new com.tencent.mm.loader.g.a.g(new com.tencent.mm.loader.g.a.a(BaseClientBuilder.API_PRIORITY_OTHER), new com.tencent.mm.loader.g.a.h(), "EmojiSync"));
    private final LinkedList<c> ezr = new LinkedList();
    public b ezs = b.Init;
    public final List<String> ezt = Collections.synchronizedList(new LinkedList());
    public int ezu;
    private boolean ezv;
    private final d ezw = new d(this);
    final int ezx;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends k implements a.f.a.a<y> {
        final /* synthetic */ EmojiSyncManager ezH;
        final /* synthetic */ boolean ezI;
        final /* synthetic */ boolean ezJ = true;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$c$1 */
        static final class AnonymousClass1 extends k implements a.f.a.a<y> {
            final /* synthetic */ c ezK;

            AnonymousClass1(c cVar) {
                this.ezK = cVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(63265);
                for (c a : this.ezK.ezH.ezr) {
                    a.a(this.ezK.ezH.ezs);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(63265);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$c$2 */
        static final class AnonymousClass2 extends k implements a.f.a.a<y> {
            final /* synthetic */ c ezK;

            AnonymousClass2(c cVar) {
                this.ezK = cVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(63266);
                for (c a : this.ezK.ezH.ezr) {
                    a.a(this.ezK.ezH.ezs);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(63266);
                return yVar;
            }
        }

        c(EmojiSyncManager emojiSyncManager, boolean z) {
            this.ezH = emojiSyncManager;
            this.ezI = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object bZ;
            AppMethodBeat.i(63267);
            if (this.ezI) {
                EmojiSyncManager.e(this.ezH);
            }
            this.ezH.ezt.clear();
            at dsZ = at.dsZ();
            j.o(dsZ, "EmojiStorageMgr.getInstance()");
            List MD = dsZ.aUp().MD(this.ezH.ezx);
            List f = this.ezH.ezt;
            j.o(MD, "needDownloadList");
            f.addAll(MD);
            ArrayList arrayList = new ArrayList();
            List f2 = this.ezH.ezt;
            j.o(f2, "downloadList");
            Iterable<String> iterable = f2;
            synchronized (iterable) {
                try {
                    for (String str : iterable) {
                        at dsZ2 = at.dsZ();
                        j.o(dsZ2, "EmojiStorageMgr.getInstance()");
                        EmojiInfo aqi = dsZ2.aUp().aqi(str);
                        if (aqi != null && bo.isNullOrNil(aqi.field_cdnUrl) && bo.isNullOrNil(aqi.field_encrypturl) && bo.isNullOrNil(aqi.field_externUrl)) {
                            arrayList.add(str);
                        }
                    }
                    y yVar = y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.o(63267);
                }
            }
            if (!((Collection) arrayList).isEmpty()) {
                com.tencent.mm.kernel.e RP;
                if (this.ezH.ezx == 1) {
                    RP = com.tencent.mm.kernel.g.RP();
                    j.o(RP, "MMKernel.storage()");
                    RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                } else {
                    RP = com.tencent.mm.kernel.g.RP();
                    j.o(RP, "MMKernel.storage()");
                    RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                }
            }
            if (this.ezH.ezx == 1) {
                bZ = com.tencent.mm.emoji.a.a.OB().bZ(false);
            } else {
                com.tencent.mm.emoji.a.a OB = com.tencent.mm.emoji.a.a.OB();
                j.o(OB, "EmojiStorageCache.getInstance()");
                bZ = OB.OC();
            }
            j.o(bZ, "customList");
            Collection arrayList2 = new ArrayList();
            for (Object next : (Iterable) bZ) {
                boolean z;
                EmojiInfo emojiInfo = (EmojiInfo) next;
                j.o(emojiInfo, "it");
                if (emojiInfo.getState() != EmojiInfo.zZc) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList2.add(next);
                }
            }
            this.ezH.ezu = MD.size() + ((List) arrayList2).size();
            ab.i(b.TAG, this.ezH.ezx + " checkSyncEmoji: total size " + this.ezH.ezu + ", need download size " + this.ezH.ezt.size());
            if (this.ezH.ezt.size() <= 0) {
                this.ezH.ezs = b.End;
                com.tencent.mm.ab.b.a(new AnonymousClass2(this));
            } else if (this.ezJ && EmojiSyncManager.g(this.ezH)) {
                EmojiSyncManager.h(this.ezH);
            } else {
                this.ezH.ezs = b.Wait;
                com.tencent.mm.ab.b.a(new AnonymousClass1(this));
            }
            y yVar2 = y.AUy;
            AppMethodBeat.o(63267);
            return yVar2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
    public static final class d implements com.tencent.mm.loader.g.f<a> {
        final /* synthetic */ EmojiSyncManager ezH;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends k implements a.f.a.a<y> {
            final /* synthetic */ d ezL;

            a(d dVar) {
                this.ezL = dVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(63268);
                for (c Pi : this.ezL.ezH.ezr) {
                    Pi.Pi();
                }
                y yVar = y.AUy;
                AppMethodBeat.o(63268);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class b extends k implements a.f.a.a<y> {
            final /* synthetic */ d ezL;

            b(d dVar) {
                this.ezL = dVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(63269);
                for (c a : this.ezL.ezH.ezr) {
                    a.a(this.ezL.ezH.ezs);
                }
                y yVar = y.AUy;
                AppMethodBeat.o(63269);
                return yVar;
            }
        }

        d(EmojiSyncManager emojiSyncManager) {
            this.ezH = emojiSyncManager;
        }

        public final /* synthetic */ void a(com.tencent.mm.loader.g.c cVar, com.tencent.mm.loader.g.h hVar) {
            AppMethodBeat.i(63270);
            a aVar = (a) cVar;
            j.p(aVar, "task");
            j.p(hVar, "status");
            ab.i(b.TAG, this.ezH.ezx + " onLoaderFin: " + aVar.exP.Aq() + ' ' + hVar);
            if (hVar == com.tencent.mm.loader.g.h.OK) {
                this.ezH.ezt.remove(aVar.exP.Aq());
            } else if (hVar == com.tencent.mm.loader.g.h.Fail) {
                this.ezH.ezt.remove(aVar.exP.Aq());
            }
            if (this.ezH.ezt.size() > 0) {
                com.tencent.mm.ab.b.a(new a(this));
                AppMethodBeat.o(63270);
                return;
            }
            this.ezH.ezs = b.End;
            this.ezH.ezv = false;
            com.tencent.mm.ab.b.a(new b(this));
            AppMethodBeat.o(63270);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ EmojiSyncManager ezH;
        final /* synthetic */ c ezM;

        public e(EmojiSyncManager emojiSyncManager, c cVar) {
            this.ezH = emojiSyncManager;
            this.ezM = cVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63271);
            this.ezH.ezr.add(this.ezM);
            y yVar = y.AUy;
            AppMethodBeat.o(63271);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class f extends k implements a.f.a.a<y> {
        final /* synthetic */ EmojiSyncManager ezH;

        f(EmojiSyncManager emojiSyncManager) {
            this.ezH = emojiSyncManager;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63272);
            for (c a : this.ezH.ezr) {
                a.a(this.ezH.ezs);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(63272);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojisdk_release"})
    public static final class ConnectivityReceiver extends BroadcastReceiver {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(63261);
            j.p(context, "context");
            j.p(intent, "intent");
            EmojiSyncManager Pe;
            if (!com.tencent.mm.sdk.platformtools.at.isConnected(context)) {
                Pe = EmojiSyncManager.ezy;
                if (Pe != null) {
                    Pe.stop();
                    AppMethodBeat.o(63261);
                    return;
                }
                AppMethodBeat.o(63261);
            } else if (com.tencent.mm.sdk.platformtools.at.isWifi(context)) {
                Pe = EmojiSyncManager.ezy;
                if (Pe != null) {
                    Pe.cg(false);
                    AppMethodBeat.o(63261);
                    return;
                }
                AppMethodBeat.o(63261);
            } else {
                Pe = EmojiSyncManager.ezy;
                if (Pe != null) {
                    if (!Pe.ezv) {
                        Pe = EmojiSyncManager.ezy;
                        if (Pe != null) {
                            Pe.stop();
                            AppMethodBeat.o(63261);
                            return;
                        }
                    }
                    AppMethodBeat.o(63261);
                    return;
                }
                AppMethodBeat.o(63261);
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class g extends k implements a.f.a.a<y> {
        final /* synthetic */ EmojiSyncManager ezH;

        g(EmojiSyncManager emojiSyncManager) {
            this.ezH = emojiSyncManager;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63273);
            for (c a : this.ezH.ezr) {
                a.a(this.ezH.ezs);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(63273);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$Companion;", "", "()V", "captureSyncMgr", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "customSyncMgr", "getCaptureSyncMgr", "getCustomSyncMgr", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static EmojiSyncManager Pg() {
            AppMethodBeat.i(63259);
            EmojiSyncManager Pe = EmojiSyncManager.ezy;
            if (Pe == null) {
                Pe = new EmojiSyncManager(0);
                EmojiSyncManager.ezy = Pe;
            }
            AppMethodBeat.o(63259);
            return Pe;
        }

        public static EmojiSyncManager Ph() {
            AppMethodBeat.i(63260);
            EmojiSyncManager Pf = EmojiSyncManager.ezz;
            if (Pf == null) {
                Pf = new EmojiSyncManager(1);
                EmojiSyncManager.ezz = Pf;
            }
            AppMethodBeat.o(63260);
            return Pf;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class h extends k implements a.f.a.a<y> {
        final /* synthetic */ EmojiSyncManager ezH;
        final /* synthetic */ c ezM;

        public h(EmojiSyncManager emojiSyncManager, c cVar) {
            this.ezH = emojiSyncManager;
            this.ezM = cVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63274);
            this.ezH.ezr.remove(this.ezM);
            y yVar = y.AUy;
            AppMethodBeat.o(63274);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Syncing", "Wait", "WaitOffline", "End", "plugin-emojisdk_release"})
    public enum b {
        Init,
        Syncing,
        Wait,
        WaitOffline,
        End;

        static {
            AppMethodBeat.o(63262);
        }
    }

    static {
        AppMethodBeat.i(63284);
        AppMethodBeat.o(63284);
    }

    public EmojiSyncManager(int i) {
        AppMethodBeat.i(63283);
        this.ezx = i;
        AppMethodBeat.o(63283);
    }

    public static final /* synthetic */ boolean g(EmojiSyncManager emojiSyncManager) {
        AppMethodBeat.i(63286);
        boolean Pd = emojiSyncManager.Pd();
        AppMethodBeat.o(63286);
        return Pd;
    }

    public static final /* synthetic */ void h(EmojiSyncManager emojiSyncManager) {
        AppMethodBeat.i(63287);
        emojiSyncManager.startInternal();
        AppMethodBeat.o(63287);
    }

    public final void init() {
        AppMethodBeat.i(63275);
        ab.i(b.TAG, "init customType: " + this.ezx);
        this.ezq.a((com.tencent.mm.loader.g.f) this.ezw);
        this.aGB = new ConnectivityReceiver();
        ah.getContext().registerReceiver(this.aGB, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        AppMethodBeat.o(63275);
    }

    public final void destroy() {
        AppMethodBeat.i(63276);
        ab.i(b.TAG, "destroy customType: " + this.ezx);
        this.ezq.b((com.tencent.mm.loader.g.f) this.ezw);
        this.ezq.clean();
        if (this.aGB != null) {
            ah.getContext().unregisterReceiver(this.aGB);
            this.aGB = null;
        }
        AppMethodBeat.o(63276);
    }

    public final void cg(boolean z) {
        AppMethodBeat.i(63277);
        this.ezv = z;
        if (this.ezs != b.Syncing) {
            List list = this.ezt;
            j.o(list, "downloadList");
            if ((!((Collection) list).isEmpty() ? 1 : null) != null && Pd()) {
                startInternal();
            }
        }
        AppMethodBeat.o(63277);
    }

    public final void stop() {
        AppMethodBeat.i(63278);
        ab.i(b.TAG, this.ezx + " stop: " + com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext()));
        this.ezv = false;
        this.ezq.clean();
        if (!this.ezt.isEmpty()) {
            this.ezs = b.Wait;
            com.tencent.mm.ab.b.a(new g(this));
        }
        AppMethodBeat.o(63278);
    }

    private void j(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63279);
        j.p(emojiInfo, "emojiInfo");
        ab.i(b.TAG, this.ezx + " addDownloadTask: " + emojiInfo.Aq());
        this.ezq.a((com.tencent.mm.loader.g.c) new a(emojiInfo));
        AppMethodBeat.o(63279);
    }

    public final void ch(boolean z) {
        AppMethodBeat.i(63280);
        ab.i(b.TAG, this.ezx + " checkSyncEmoji: true " + z);
        com.tencent.mm.ab.b.a("EmojiSyncManager_checkBrokenEmoji", (a.f.a.a) new c(this, z));
        AppMethodBeat.o(63280);
    }

    private final void startInternal() {
        AppMethodBeat.i(63281);
        ab.i(b.TAG, this.ezx + " startInternal: " + this.ezv + ' ' + com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext()) + ' ' + "size is " + this.ezt.size());
        List list = this.ezt;
        j.o(list, "downloadList");
        Iterable<String> iterable = list;
        synchronized (iterable) {
            try {
                for (String str : iterable) {
                    com.tencent.mm.kernel.b.a M = com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class);
                    j.o(M, "plugin(IPluginEmoji::class.java)");
                    EmojiInfo Je = ((com.tencent.mm.plugin.emoji.b.d) M).getProvider().Je(str);
                    if (Je != null) {
                        j(Je);
                    }
                }
                y yVar = y.AUy;
            } finally {
                AppMethodBeat.o(63281);
            }
        }
        this.ezs = b.Syncing;
        com.tencent.mm.ab.b.a(new f(this));
    }

    private final boolean Pd() {
        AppMethodBeat.i(63282);
        if (this.ezv || com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext())) {
            AppMethodBeat.o(63282);
            return true;
        }
        AppMethodBeat.o(63282);
        return false;
    }

    public static final /* synthetic */ void e(EmojiSyncManager emojiSyncManager) {
        AppMethodBeat.i(63285);
        ArrayList bZ;
        Collection arrayList;
        EmojiInfo emojiInfo;
        com.tencent.mm.kernel.b.a M;
        if (emojiSyncManager.ezx == 1) {
            bZ = com.tencent.mm.emoji.a.a.OB().bZ(false);
            j.o(bZ, "customList");
            arrayList = new ArrayList();
            for (Object next : bZ) {
                emojiInfo = (EmojiInfo) next;
                j.o(emojiInfo, "it");
                if (!emojiInfo.duP()) {
                    arrayList.add(next);
                }
            }
            for (EmojiInfo emojiInfo2 : (List) arrayList) {
                j.o(emojiInfo2, "it");
                emojiInfo2.setState(EmojiInfo.zZc);
                M = com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class);
                j.o(M, "plugin(IPluginEmoji::class.java)");
                ((com.tencent.mm.plugin.emoji.b.d) M).getProvider().updateEmojiInfo(emojiInfo2);
            }
            com.tencent.mm.emoji.a.a.OB().cd(true);
            AppMethodBeat.o(63285);
            return;
        }
        com.tencent.mm.emoji.a.a OB = com.tencent.mm.emoji.a.a.OB();
        j.o(OB, "EmojiStorageCache.getInstance()");
        bZ = OB.OC();
        j.o(bZ, "customList");
        arrayList = new ArrayList();
        for (Object next2 : bZ) {
            emojiInfo = (EmojiInfo) next2;
            j.o(emojiInfo, "it");
            if (!emojiInfo.duP()) {
                arrayList.add(next2);
            }
        }
        for (EmojiInfo emojiInfo22 : (List) arrayList) {
            j.o(emojiInfo22, "it");
            emojiInfo22.setState(EmojiInfo.zZc);
            M = com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class);
            j.o(M, "plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) M).getProvider().updateEmojiInfo(emojiInfo22);
        }
        com.tencent.mm.emoji.a.a.OB().cb(true);
        AppMethodBeat.o(63285);
    }
}
