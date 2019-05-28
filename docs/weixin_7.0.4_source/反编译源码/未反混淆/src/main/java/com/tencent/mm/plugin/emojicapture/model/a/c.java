package com.tencent.mm.plugin.emojicapture.model.a;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.c.d;
import com.tencent.mm.plugin.emojicapture.model.c.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000eJ\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr;", "", "()V", "TAG", "", "callbacks", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr$StickerResCallback;", "Lkotlin/collections/HashSet;", "emptySticker", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "getEmptySticker", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "orderIndex", "", "requestSticker", "Ljava/util/LinkedList;", "scene", "stickerConfig", "Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensConfig;", "stickerList", "addCallback", "", "callback", "checkResUpdate", "subType", "destroy", "init", "onResUpdate", "parseFile", "removeCallback", "StickerResCallback", "plugin-emojicapture_release"})
public final class c {
    private static final String TAG = TAG;
    private static final b lhN = new b();
    private static final LinkedList<b> lhO = new LinkedList();
    private static com.tencent.mm.plugin.emojicapture.model.c.b lhP = new com.tencent.mm.plugin.emojicapture.model.c.b();
    private static final HashSet<a> lhQ = new HashSet();
    private static final LinkedList<Integer> lhR = new LinkedList();
    public static final c lhS = new c();
    private static int scene;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr$StickerResCallback;", "", "notifyUpdate", "", "onItemChange", "position", "", "update", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
    public interface a {
        void S(LinkedList<b> linkedList);

        void bny();

        void uv(int i);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ int lhT;

        b(int i) {
            this.lhT = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            b bVar;
            int i;
            AppMethodBeat.i(2640);
            e eVar = e.lii;
            int i2 = this.lhT;
            e.dO(e.lhY + e.lic + i2, e.lhX + e.lic + i2);
            c cVar = c.lhS;
            int i3 = 0;
            for (b bVar2 : c.lhO) {
                if (bVar2.cuu == this.lhT) {
                    i = i3;
                    break;
                }
                i3++;
            }
            i = -1;
            if (i >= 0) {
                cVar = c.lhS;
                if (i < c.lhO.size()) {
                    Object obj;
                    cVar = c.lhS;
                    Object obj2 = c.lhO.get(i);
                    j.o(obj2, "stickerList[position]");
                    bVar2 = (b) obj2;
                    c cVar2 = c.lhS;
                    for (Object next : c.lhP.ewZ) {
                        boolean z;
                        if (((d) next).ljp == this.lhT) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            obj = next;
                            break;
                        }
                    }
                    obj = null;
                    d dVar = (d) obj;
                    if (dVar != null) {
                        e eVar2 = e.lii;
                        String uw = e.uw(bVar2.cuu);
                        i iVar = new i();
                        com.tencent.mm.plugin.emojicapture.model.c.a.a aVar = com.tencent.mm.plugin.emojicapture.model.c.a.ljn;
                        com.tencent.mm.plugin.emojicapture.model.c.a.a.a(uw, iVar);
                        bVar2.version = iVar.ljI;
                        c cVar3 = c.lhS;
                        ab.i(c.TAG, "onResUpdate: " + this.lhT + ", " + bVar2.version);
                        if (bVar2.version >= dVar.ljr) {
                            bVar2.ajN = true;
                            com.tencent.mm.ab.b.a(new a.f.a.a<y>(this) {
                                final /* synthetic */ b lhU;

                                public final /* synthetic */ Object invoke() {
                                    AppMethodBeat.i(2639);
                                    c cVar = c.lhS;
                                    c.lhR.remove(Integer.valueOf(this.lhU.lhT));
                                    cVar = c.lhS;
                                    for (a aVar : c.lhQ) {
                                        c cVar2 = c.lhS;
                                        aVar.S(c.lhO);
                                        aVar.uv(i);
                                    }
                                    y yVar = y.AUy;
                                    AppMethodBeat.o(2639);
                                    return yVar;
                                }
                            });
                        }
                    }
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2640);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(2645);
        AppMethodBeat.o(2645);
    }

    private c() {
    }

    public static b bns() {
        return lhN;
    }

    public static void init(int i) {
        AppMethodBeat.i(2641);
        scene = i;
        e eVar = e.lii;
        e.bnC();
        AppMethodBeat.o(2641);
    }

    public static void destroy() {
        AppMethodBeat.i(2642);
        lhO.clear();
        lhQ.clear();
        lhR.clear();
        AppMethodBeat.o(2642);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(2643);
        j.p(aVar, "callback");
        lhQ.add(aVar);
        aVar.S(lhO);
        aVar.bny();
        AppMethodBeat.o(2643);
    }

    public static void uu(int i) {
        AppMethodBeat.i(2644);
        com.tencent.mm.ab.b.a("EmojiStickerMgr_onResUpdate", (a.f.a.a) new b(i));
        AppMethodBeat.o(2644);
    }
}
