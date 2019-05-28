package com.tencent.mm.plugin.emojicapture.model.a;

import a.f.b.j;
import a.l;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.plugin.emojicapture.model.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerResListener;", "", "()V", "RES_TYPE", "", "TAG", "", "fileUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "getFileUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "broadcastResult", "", "subType", "result", "", "checkResUpdate", "version", "compareWithLocal", "destroy", "init", "plugin-emojicapture_release"})
public final class g {
    public static final String TAG = TAG;
    private static final c<bf> lij = new a();
    public static final g lik = new g();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerResListener$fileUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-emojicapture_release"})
    public static final class a extends c<bf> {
        a() {
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(2652);
            bf bfVar = (bf) bVar;
            j.p(bfVar, "event");
            g gVar = g.lik;
            ab.i(g.TAG, "fileUpdateListener: type: " + bfVar.cus.cut + ", " + bfVar.cus.cuu + ' ' + "filepath: " + bfVar.cus.filePath);
            if (bfVar.cus.cut == 59) {
                String str = bfVar.cus.filePath;
                e eVar = e.lii;
                bo.hU(str, e.bnA());
                if (bfVar.cus.cuu == 0) {
                    gVar = g.lik;
                    g.bnE();
                }
                gVar = g.lik;
                g.uz(bfVar.cus.cuu);
                AppMethodBeat.o(2652);
                return true;
            }
            AppMethodBeat.o(2652);
            return false;
        }
    }

    static {
        AppMethodBeat.i(2656);
        AppMethodBeat.o(2656);
    }

    private g() {
    }

    public static final /* synthetic */ void uz(int i) {
        AppMethodBeat.i(2658);
        uy(i);
        AppMethodBeat.o(2658);
    }

    public static void init() {
        AppMethodBeat.i(2653);
        lij.dnU();
        AppMethodBeat.o(2653);
    }

    public static void destroy() {
        AppMethodBeat.i(2654);
        lij.dead();
        AppMethodBeat.o(2654);
    }

    public static void uy(int i) {
        AppMethodBeat.i(2655);
        ab.i(TAG, "broadcastResult: " + i + ", true");
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.Emoji_Capture_Res");
        intent.putExtra("res_sub_type", i);
        intent.putExtra("res_result", true);
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(2655);
    }

    public static final /* synthetic */ void bnE() {
        AppMethodBeat.i(2657);
        com.tencent.mm.plugin.emojicapture.model.c.b bVar = new com.tencent.mm.plugin.emojicapture.model.c.b();
        com.tencent.mm.plugin.emojicapture.model.c.a.a aVar = com.tencent.mm.plugin.emojicapture.model.c.a.ljn;
        e eVar = e.lii;
        com.tencent.mm.plugin.emojicapture.model.c.a.a.a(e.bnB(), bVar);
        Iterable iterable = bVar.ewZ;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if ((!d.a((d) next) ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        for (d dVar : (List) arrayList) {
            ab.i(TAG, "compareWithLocal: invalid " + dVar.ljp);
        }
        AppMethodBeat.o(2657);
    }
}
