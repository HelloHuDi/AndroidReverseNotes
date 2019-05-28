package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.a.h;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bJF\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager;", "", "()V", "mixCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1;", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "mixTasks", "", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "kotlin.jvm.PlatformType", "", "stopServiceRunnable", "Lkotlin/Function0;", "", "addTask", "info", "scene", "", "timeEnter", "", "videoPath", "", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "hasSticker", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojicapture_release"})
public final class e {
    private static final d<h> liD = new d(new g(new com.tencent.mm.loader.g.a.a(20), new h(), "EmojiMix"));
    private static a.f.a.a<y> liE = b.liI;
    private static final List<d> liF = Collections.synchronizedList(new LinkedList());
    private static final a liG = new a();
    public static final e liH = new e();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
    public static final class a implements f<h> {
        a() {
        }

        public final /* synthetic */ void a(c cVar, com.tencent.mm.loader.g.h hVar) {
            e eVar;
            AppMethodBeat.i(2671);
            h hVar2 = (h) cVar;
            j.p(hVar2, "task");
            j.p(hVar, "status");
            d dVar = null;
            e eVar2 = e.liH;
            List bnF = e.liF;
            j.o(bnF, "mixTasks");
            Iterable<d> iterable = bnF;
            synchronized (iterable) {
                try {
                    for (d dVar2 : iterable) {
                        d dVar22;
                        if (dVar22.ezZ != hVar2.ezZ) {
                            dVar22 = dVar;
                        }
                        dVar = dVar22;
                    }
                    y yVar = y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.o(2671);
                }
            }
            if (dVar != null) {
                eVar2 = e.liH;
                e.liF.remove(dVar);
            }
            eVar2 = e.liH;
            if (e.liF.isEmpty()) {
                eVar = e.liH;
                com.tencent.mm.ab.b.a(1000, e.liE);
            }
            String Ow = f.TAG;
            StringBuilder append = new StringBuilder("onLoaderFin: ").append(hVar).append(", ");
            eVar = e.liH;
            ab.i(Ow, append.append(e.liF.size()).toString());
            AppMethodBeat.o(2671);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        public static final b liI = new b();

        static {
            AppMethodBeat.i(2673);
            AppMethodBeat.o(2673);
        }

        b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(2672);
            com.tencent.mm.bp.d.l(new Intent(ah.getContext(), EmojiCaptureService.class), "tools");
            y yVar = y.AUy;
            AppMethodBeat.o(2672);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(2675);
        liD.a((f) liG);
        AppMethodBeat.o(2675);
    }

    private e() {
    }

    public static d a(int i, long j, String str, a aVar, int i2, boolean z, boolean z2, EmojiInfo emojiInfo) {
        g gVar;
        AppMethodBeat.i(2674);
        j.p(str, "videoPath");
        j.p(aVar, "retriever");
        j.p(emojiInfo, "emojiInfo");
        com.tencent.mm.plugin.emojicapture.model.c.a aVar2 = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        String str2 = com.tencent.mm.plugin.emojicapture.model.c.a.bmO() + "temp_gif" + bo.anU();
        com.tencent.mm.plugin.emojicapture.model.c.a aVar3 = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        d dVar = new d(i, j, str, str2, aVar, i2, z, z2, !com.tencent.mm.plugin.emojicapture.model.c.lhr, emojiInfo);
        j.p(dVar, "info");
        liF.add(dVar);
        liD.a((c) new h(dVar));
        a.f.a.a aVar4 = liE;
        if (aVar4 != null) {
            gVar = new g(aVar4);
        } else {
            Object gVar2 = aVar4;
        }
        al.af(gVar2);
        com.tencent.mm.bp.d.j(new Intent(ah.getContext(), EmojiCaptureService.class), "tools");
        AppMethodBeat.o(2674);
        return dVar;
    }
}
