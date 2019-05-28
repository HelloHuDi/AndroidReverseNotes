package com.tencent.p177mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C26366d;
import com.tencent.p177mm.loader.p864g.C42155f;
import com.tencent.p177mm.loader.p864g.C45423h;
import com.tencent.p177mm.loader.p864g.p1196a.C18536g;
import com.tencent.p177mm.loader.p864g.p1196a.C18537h;
import com.tencent.p177mm.loader.p864g.p1196a.C46886a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\r\u0018\u0000 :2\u00020\u0001:\u0003:;<B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020'H\u0002J\u0006\u0010,\u001a\u00020'J\u0016\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001cJ\u0006\u00100\u001a\u00020'J\u0006\u00101\u001a\u00020'J\u000e\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u0011J\u000e\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020'2\u0006\u00106\u001a\u00020\u001cJ\b\u00107\u001a\u00020'H\u0002J\u0006\u00108\u001a\u00020'J\u000e\u00109\u001a\u00020'2\u0006\u00105\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR2\u0010\u000f\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00130\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00038F@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\u0004R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u001d@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\u0004¨\u0006="}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "", "customType", "", "(I)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/SyncCallback;", "connectivityReceiver", "Landroid/content/BroadcastReceiver;", "getCustomType", "()I", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1;", "downloadList", "", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "<set-?>", "remainSize", "getRemainSize", "setRemainSize", "startNonWifi", "", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncState", "getSyncState", "()Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "setSyncState", "(Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;)V", "totalSize", "getTotalSize", "setTotalSize", "addDownloadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkAutoStart", "checkBroken", "checkSync", "checkSyncEmoji", "start", "withBroken", "destroy", "init", "markBroken", "md5", "registerCallback", "callback", "force", "startInternal", "stop", "unregisterCallback", "Companion", "ConnectivityReceiver", "SyncState", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager */
public final class EmojiSyncManager {
    public static final C9287a ezA = new C9287a();
    private static EmojiSyncManager ezy;
    private static EmojiSyncManager ezz;
    private BroadcastReceiver aGB;
    private final C26366d<C41961a> ezq = new C26366d(new C18536g(new C46886a(BaseClientBuilder.API_PRIORITY_OTHER), new C18537h(), "EmojiSync"));
    private final LinkedList<C26082c> ezr = new LinkedList();
    public C9289b ezs = C9289b.Init;
    public final List<String> ezt = Collections.synchronizedList(new LinkedList());
    public int ezu;
    private boolean ezv;
    private final C9281d ezw = new C9281d(this);
    final int ezx;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$c */
    static final class C9278c extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EmojiSyncManager ezH;
        final /* synthetic */ boolean ezI;
        final /* synthetic */ boolean ezJ = true;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$c$1 */
        static final class C92791 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C9278c ezK;

            C92791(C9278c c9278c) {
                this.ezK = c9278c;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(63265);
                for (C26082c a : this.ezK.ezH.ezr) {
                    a.mo43948a(this.ezK.ezH.ezs);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(63265);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$c$2 */
        static final class C92802 extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C9278c ezK;

            C92802(C9278c c9278c) {
                this.ezK = c9278c;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(63266);
                for (C26082c a : this.ezK.ezH.ezr) {
                    a.mo43948a(this.ezK.ezH.ezs);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(63266);
                return c37091y;
            }
        }

        C9278c(EmojiSyncManager emojiSyncManager, boolean z) {
            this.ezH = emojiSyncManager;
            this.ezI = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object bZ;
            AppMethodBeat.m2504i(63267);
            if (this.ezI) {
                EmojiSyncManager.m16841e(this.ezH);
            }
            this.ezH.ezt.clear();
            C23505at dsZ = C23505at.dsZ();
            C25052j.m39375o(dsZ, "EmojiStorageMgr.getInstance()");
            List MD = dsZ.aUp().mo48562MD(this.ezH.ezx);
            List f = this.ezH.ezt;
            C25052j.m39375o(MD, "needDownloadList");
            f.addAll(MD);
            ArrayList arrayList = new ArrayList();
            List f2 = this.ezH.ezt;
            C25052j.m39375o(f2, "downloadList");
            Iterable<String> iterable = f2;
            synchronized (iterable) {
                try {
                    for (String str : iterable) {
                        C23505at dsZ2 = C23505at.dsZ();
                        C25052j.m39375o(dsZ2, "EmojiStorageMgr.getInstance()");
                        EmojiInfo aqi = dsZ2.aUp().aqi(str);
                        if (aqi != null && C5046bo.isNullOrNil(aqi.field_cdnUrl) && C5046bo.isNullOrNil(aqi.field_encrypturl) && C5046bo.isNullOrNil(aqi.field_externUrl)) {
                            arrayList.add(str);
                        }
                    }
                    C37091y c37091y = C37091y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(63267);
                }
            }
            if (!((Collection) arrayList).isEmpty()) {
                C1706e RP;
                if (this.ezH.ezx == 1) {
                    RP = C1720g.m3536RP();
                    C25052j.m39375o(RP, "MMKernel.storage()");
                    RP.mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                } else {
                    RP = C1720g.m3536RP();
                    C25052j.m39375o(RP, "MMKernel.storage()");
                    RP.mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                }
            }
            if (this.ezH.ezx == 1) {
                bZ = C32497a.m53203OB().mo53137bZ(false);
            } else {
                C32497a OB = C32497a.m53203OB();
                C25052j.m39375o(OB, "EmojiStorageCache.getInstance()");
                bZ = OB.mo53134OC();
            }
            C25052j.m39375o(bZ, "customList");
            Collection arrayList2 = new ArrayList();
            for (Object next : (Iterable) bZ) {
                boolean z;
                EmojiInfo emojiInfo = (EmojiInfo) next;
                C25052j.m39375o(emojiInfo, "it");
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
            C4990ab.m7416i(C41962b.TAG, this.ezH.ezx + " checkSyncEmoji: total size " + this.ezH.ezu + ", need download size " + this.ezH.ezt.size());
            if (this.ezH.ezt.size() <= 0) {
                this.ezH.ezs = C9289b.End;
                C8902b.m16042a(new C92802(this));
            } else if (this.ezJ && EmojiSyncManager.m16843g(this.ezH)) {
                EmojiSyncManager.m16844h(this.ezH);
            } else {
                this.ezH.ezs = C9289b.Wait;
                C8902b.m16042a(new C92791(this));
            }
            C37091y c37091y2 = C37091y.AUy;
            AppMethodBeat.m2505o(63267);
            return c37091y2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$d */
    public static final class C9281d implements C42155f<C41961a> {
        final /* synthetic */ EmojiSyncManager ezH;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$d$a */
        static final class C9282a extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C9281d ezL;

            C9282a(C9281d c9281d) {
                this.ezL = c9281d;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(63268);
                for (C26082c Pi : this.ezL.ezH.ezr) {
                    Pi.mo43947Pi();
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(63268);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$d$b */
        static final class C9283b extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C9281d ezL;

            C9283b(C9281d c9281d) {
                this.ezL = c9281d;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(63269);
                for (C26082c a : this.ezL.ezH.ezr) {
                    a.mo43948a(this.ezL.ezH.ezs);
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(63269);
                return c37091y;
            }
        }

        C9281d(EmojiSyncManager emojiSyncManager) {
            this.ezH = emojiSyncManager;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo9004a(C26365c c26365c, C45423h c45423h) {
            AppMethodBeat.m2504i(63270);
            C41961a c41961a = (C41961a) c26365c;
            C25052j.m39376p(c41961a, "task");
            C25052j.m39376p(c45423h, "status");
            C4990ab.m7416i(C41962b.TAG, this.ezH.ezx + " onLoaderFin: " + c41961a.exP.mo20410Aq() + ' ' + c45423h);
            if (c45423h == C45423h.OK) {
                this.ezH.ezt.remove(c41961a.exP.mo20410Aq());
            } else if (c45423h == C45423h.Fail) {
                this.ezH.ezt.remove(c41961a.exP.mo20410Aq());
            }
            if (this.ezH.ezt.size() > 0) {
                C8902b.m16042a(new C9282a(this));
                AppMethodBeat.m2505o(63270);
                return;
            }
            this.ezH.ezs = C9289b.End;
            this.ezH.ezv = false;
            C8902b.m16042a(new C9283b(this));
            AppMethodBeat.m2505o(63270);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$e */
    public static final class C9284e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EmojiSyncManager ezH;
        final /* synthetic */ C26082c ezM;

        public C9284e(EmojiSyncManager emojiSyncManager, C26082c c26082c) {
            this.ezH = emojiSyncManager;
            this.ezM = c26082c;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63271);
            this.ezH.ezr.add(this.ezM);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63271);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$f */
    static final class C9285f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EmojiSyncManager ezH;

        C9285f(EmojiSyncManager emojiSyncManager) {
            this.ezH = emojiSyncManager;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63272);
            for (C26082c a : this.ezH.ezr) {
                a.mo43948a(this.ezH.ezs);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63272);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$ConnectivityReceiver */
    public static final class ConnectivityReceiver extends BroadcastReceiver {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(63261);
            C25052j.m39376p(context, "context");
            C25052j.m39376p(intent, "intent");
            EmojiSyncManager Pe;
            if (!C5023at.isConnected(context)) {
                Pe = EmojiSyncManager.ezy;
                if (Pe != null) {
                    Pe.stop();
                    AppMethodBeat.m2505o(63261);
                    return;
                }
                AppMethodBeat.m2505o(63261);
            } else if (C5023at.isWifi(context)) {
                Pe = EmojiSyncManager.ezy;
                if (Pe != null) {
                    Pe.mo20718cg(false);
                    AppMethodBeat.m2505o(63261);
                    return;
                }
                AppMethodBeat.m2505o(63261);
            } else {
                Pe = EmojiSyncManager.ezy;
                if (Pe != null) {
                    if (!Pe.ezv) {
                        Pe = EmojiSyncManager.ezy;
                        if (Pe != null) {
                            Pe.stop();
                            AppMethodBeat.m2505o(63261);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(63261);
                    return;
                }
                AppMethodBeat.m2505o(63261);
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$g */
    static final class C9286g extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EmojiSyncManager ezH;

        C9286g(EmojiSyncManager emojiSyncManager) {
            this.ezH = emojiSyncManager;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63273);
            for (C26082c a : this.ezH.ezr) {
                a.mo43948a(this.ezH.ezs);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63273);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$Companion;", "", "()V", "captureSyncMgr", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "customSyncMgr", "getCaptureSyncMgr", "getCustomSyncMgr", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$a */
    public static final class C9287a {
        private C9287a() {
        }

        public /* synthetic */ C9287a(byte b) {
            this();
        }

        /* renamed from: Pg */
        public static EmojiSyncManager m16849Pg() {
            AppMethodBeat.m2504i(63259);
            EmojiSyncManager Pe = EmojiSyncManager.ezy;
            if (Pe == null) {
                Pe = new EmojiSyncManager(0);
                EmojiSyncManager.ezy = Pe;
            }
            AppMethodBeat.m2505o(63259);
            return Pe;
        }

        /* renamed from: Ph */
        public static EmojiSyncManager m16850Ph() {
            AppMethodBeat.m2504i(63260);
            EmojiSyncManager Pf = EmojiSyncManager.ezz;
            if (Pf == null) {
                Pf = new EmojiSyncManager(1);
                EmojiSyncManager.ezz = Pf;
            }
            AppMethodBeat.m2505o(63260);
            return Pf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$h */
    public static final class C9288h extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EmojiSyncManager ezH;
        final /* synthetic */ C26082c ezM;

        public C9288h(EmojiSyncManager emojiSyncManager, C26082c c26082c) {
            this.ezH = emojiSyncManager;
            this.ezM = c26082c;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63274);
            this.ezH.ezr.remove(this.ezM);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63274);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Syncing", "Wait", "WaitOffline", "End", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.sync.EmojiSyncManager$b */
    public enum C9289b {
        Init,
        Syncing,
        Wait,
        WaitOffline,
        End;

        static {
            AppMethodBeat.m2505o(63262);
        }
    }

    static {
        AppMethodBeat.m2504i(63284);
        AppMethodBeat.m2505o(63284);
    }

    public EmojiSyncManager(int i) {
        AppMethodBeat.m2504i(63283);
        this.ezx = i;
        AppMethodBeat.m2505o(63283);
    }

    /* renamed from: g */
    public static final /* synthetic */ boolean m16843g(EmojiSyncManager emojiSyncManager) {
        AppMethodBeat.m2504i(63286);
        boolean Pd = emojiSyncManager.m16832Pd();
        AppMethodBeat.m2505o(63286);
        return Pd;
    }

    /* renamed from: h */
    public static final /* synthetic */ void m16844h(EmojiSyncManager emojiSyncManager) {
        AppMethodBeat.m2504i(63287);
        emojiSyncManager.startInternal();
        AppMethodBeat.m2505o(63287);
    }

    public final void init() {
        AppMethodBeat.m2504i(63275);
        C4990ab.m7416i(C41962b.TAG, "init customType: " + this.ezx);
        this.ezq.mo44160a((C42155f) this.ezw);
        this.aGB = new ConnectivityReceiver();
        C4996ah.getContext().registerReceiver(this.aGB, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        AppMethodBeat.m2505o(63275);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(63276);
        C4990ab.m7416i(C41962b.TAG, "destroy customType: " + this.ezx);
        this.ezq.mo44161b((C42155f) this.ezw);
        this.ezq.clean();
        if (this.aGB != null) {
            C4996ah.getContext().unregisterReceiver(this.aGB);
            this.aGB = null;
        }
        AppMethodBeat.m2505o(63276);
    }

    /* renamed from: cg */
    public final void mo20718cg(boolean z) {
        AppMethodBeat.m2504i(63277);
        this.ezv = z;
        if (this.ezs != C9289b.Syncing) {
            List list = this.ezt;
            C25052j.m39375o(list, "downloadList");
            if ((!((Collection) list).isEmpty() ? 1 : null) != null && m16832Pd()) {
                startInternal();
            }
        }
        AppMethodBeat.m2505o(63277);
    }

    public final void stop() {
        AppMethodBeat.m2504i(63278);
        C4990ab.m7416i(C41962b.TAG, this.ezx + " stop: " + C5023at.isWifi(C4996ah.getContext()));
        this.ezv = false;
        this.ezq.clean();
        if (!this.ezt.isEmpty()) {
            this.ezs = C9289b.Wait;
            C8902b.m16042a(new C9286g(this));
        }
        AppMethodBeat.m2505o(63278);
    }

    /* renamed from: j */
    private void m16846j(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63279);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C4990ab.m7416i(C41962b.TAG, this.ezx + " addDownloadTask: " + emojiInfo.mo20410Aq());
        this.ezq.mo44158a((C26365c) new C41961a(emojiInfo));
        AppMethodBeat.m2505o(63279);
    }

    /* renamed from: ch */
    public final void mo20719ch(boolean z) {
        AppMethodBeat.m2504i(63280);
        C4990ab.m7416i(C41962b.TAG, this.ezx + " checkSyncEmoji: true " + z);
        C8902b.m16044a("EmojiSyncManager_checkBrokenEmoji", (C31214a) new C9278c(this, z));
        AppMethodBeat.m2505o(63280);
    }

    private final void startInternal() {
        AppMethodBeat.m2504i(63281);
        C4990ab.m7416i(C41962b.TAG, this.ezx + " startInternal: " + this.ezv + ' ' + C5023at.isWifi(C4996ah.getContext()) + ' ' + "size is " + this.ezt.size());
        List list = this.ezt;
        C25052j.m39375o(list, "downloadList");
        Iterable<String> iterable = list;
        synchronized (iterable) {
            try {
                for (String str : iterable) {
                    C1677a M = C1720g.m3530M(C6835d.class);
                    C25052j.m39375o(M, "plugin(IPluginEmoji::class.java)");
                    EmojiInfo Je = ((C6835d) M).getProvider().mo35597Je(str);
                    if (Je != null) {
                        m16846j(Je);
                    }
                }
                C37091y c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(63281);
            }
        }
        this.ezs = C9289b.Syncing;
        C8902b.m16042a(new C9285f(this));
    }

    /* renamed from: Pd */
    private final boolean m16832Pd() {
        AppMethodBeat.m2504i(63282);
        if (this.ezv || C5023at.isWifi(C4996ah.getContext())) {
            AppMethodBeat.m2505o(63282);
            return true;
        }
        AppMethodBeat.m2505o(63282);
        return false;
    }

    /* renamed from: e */
    public static final /* synthetic */ void m16841e(EmojiSyncManager emojiSyncManager) {
        AppMethodBeat.m2504i(63285);
        ArrayList bZ;
        Collection arrayList;
        EmojiInfo emojiInfo;
        C1677a M;
        if (emojiSyncManager.ezx == 1) {
            bZ = C32497a.m53203OB().mo53137bZ(false);
            C25052j.m39375o(bZ, "customList");
            arrayList = new ArrayList();
            for (Object next : bZ) {
                emojiInfo = (EmojiInfo) next;
                C25052j.m39375o(emojiInfo, "it");
                if (!emojiInfo.duP()) {
                    arrayList.add(next);
                }
            }
            for (EmojiInfo emojiInfo2 : (List) arrayList) {
                C25052j.m39375o(emojiInfo2, "it");
                emojiInfo2.setState(EmojiInfo.zZc);
                M = C1720g.m3530M(C6835d.class);
                C25052j.m39375o(M, "plugin(IPluginEmoji::class.java)");
                ((C6835d) M).getProvider().updateEmojiInfo(emojiInfo2);
            }
            C32497a.m53203OB().mo53141cd(true);
            AppMethodBeat.m2505o(63285);
            return;
        }
        C32497a OB = C32497a.m53203OB();
        C25052j.m39375o(OB, "EmojiStorageCache.getInstance()");
        bZ = OB.mo53134OC();
        C25052j.m39375o(bZ, "customList");
        arrayList = new ArrayList();
        for (Object next2 : bZ) {
            emojiInfo = (EmojiInfo) next2;
            C25052j.m39375o(emojiInfo, "it");
            if (!emojiInfo.duP()) {
                arrayList.add(next2);
            }
        }
        for (EmojiInfo emojiInfo22 : (List) arrayList) {
            C25052j.m39375o(emojiInfo22, "it");
            emojiInfo22.setState(EmojiInfo.zZc);
            M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "plugin(IPluginEmoji::class.java)");
            ((C6835d) M).getProvider().updateEmojiInfo(emojiInfo22);
        }
        C32497a.m53203OB().mo53139cb(true);
        AppMethodBeat.m2505o(63285);
    }
}
