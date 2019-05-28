package com.tencent.p177mm.plugin.emojicapture.model.p950a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C20433d;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C38918b;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C42976i;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C45869a;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C45869a.C20432a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000eJ\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr;", "", "()V", "TAG", "", "callbacks", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr$StickerResCallback;", "Lkotlin/collections/HashSet;", "emptySticker", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "getEmptySticker", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "orderIndex", "", "requestSticker", "Ljava/util/LinkedList;", "scene", "stickerConfig", "Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensConfig;", "stickerList", "addCallback", "", "callback", "checkResUpdate", "subType", "destroy", "init", "onResUpdate", "parseFile", "removeCallback", "StickerResCallback", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.a.c */
public final class C45864c {
    private static final String TAG = TAG;
    private static final C42971b lhN = new C42971b();
    private static final LinkedList<C42971b> lhO = new LinkedList();
    private static C38918b lhP = new C38918b();
    private static final HashSet<C11609a> lhQ = new HashSet();
    private static final LinkedList<Integer> lhR = new LinkedList();
    public static final C45864c lhS = new C45864c();
    private static int scene;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr$StickerResCallback;", "", "notifyUpdate", "", "onItemChange", "position", "", "update", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.a.c$a */
    public interface C11609a {
        /* renamed from: S */
        void mo23357S(LinkedList<C42971b> linkedList);

        void bny();

        /* renamed from: uv */
        void mo23359uv(int i);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.a.c$b */
    static final class C11610b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ int lhT;

        C11610b(int i) {
            this.lhT = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            C42971b c42971b;
            int i;
            AppMethodBeat.m2504i(2640);
            C45865e c45865e = C45865e.lii;
            int i2 = this.lhT;
            C45865e.m84968dO(C45865e.lhY + C45865e.lic + i2, C45865e.lhX + C45865e.lic + i2);
            C45864c c45864c = C45864c.lhS;
            int i3 = 0;
            for (C42971b c42971b2 : C45864c.lhO) {
                if (c42971b2.cuu == this.lhT) {
                    i = i3;
                    break;
                }
                i3++;
            }
            i = -1;
            if (i >= 0) {
                c45864c = C45864c.lhS;
                if (i < C45864c.lhO.size()) {
                    Object obj;
                    c45864c = C45864c.lhS;
                    Object obj2 = C45864c.lhO.get(i);
                    C25052j.m39375o(obj2, "stickerList[position]");
                    c42971b2 = (C42971b) obj2;
                    C45864c c45864c2 = C45864c.lhS;
                    for (Object next : C45864c.lhP.ewZ) {
                        boolean z;
                        if (((C20433d) next).ljp == this.lhT) {
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
                    C20433d c20433d = (C20433d) obj;
                    if (c20433d != null) {
                        C45865e c45865e2 = C45865e.lii;
                        String uw = C45865e.m84969uw(c42971b2.cuu);
                        C42976i c42976i = new C42976i();
                        C20432a c20432a = C45869a.ljn;
                        C20432a.m31586a(uw, c42976i);
                        c42971b2.version = c42976i.ljI;
                        C45864c c45864c3 = C45864c.lhS;
                        C4990ab.m7416i(C45864c.TAG, "onResUpdate: " + this.lhT + ", " + c42971b2.version);
                        if (c42971b2.version >= c20433d.ljr) {
                            c42971b2.ajN = true;
                            C8902b.m16042a(new C31214a<C37091y>(this) {
                                final /* synthetic */ C11610b lhU;

                                public final /* synthetic */ Object invoke() {
                                    AppMethodBeat.m2504i(2639);
                                    C45864c c45864c = C45864c.lhS;
                                    C45864c.lhR.remove(Integer.valueOf(this.lhU.lhT));
                                    c45864c = C45864c.lhS;
                                    for (C11609a c11609a : C45864c.lhQ) {
                                        C45864c c45864c2 = C45864c.lhS;
                                        c11609a.mo23357S(C45864c.lhO);
                                        c11609a.mo23359uv(i);
                                    }
                                    C37091y c37091y = C37091y.AUy;
                                    AppMethodBeat.m2505o(2639);
                                    return c37091y;
                                }
                            });
                        }
                    }
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2640);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(2645);
        AppMethodBeat.m2505o(2645);
    }

    private C45864c() {
    }

    public static C42971b bns() {
        return lhN;
    }

    public static void init(int i) {
        AppMethodBeat.m2504i(2641);
        scene = i;
        C45865e c45865e = C45865e.lii;
        C45865e.bnC();
        AppMethodBeat.m2505o(2641);
    }

    public static void destroy() {
        AppMethodBeat.m2504i(2642);
        lhO.clear();
        lhQ.clear();
        lhR.clear();
        AppMethodBeat.m2505o(2642);
    }

    /* renamed from: a */
    public static void m84966a(C11609a c11609a) {
        AppMethodBeat.m2504i(2643);
        C25052j.m39376p(c11609a, "callback");
        lhQ.add(c11609a);
        c11609a.mo23357S(lhO);
        c11609a.bny();
        AppMethodBeat.m2505o(2643);
    }

    /* renamed from: uu */
    public static void m84967uu(int i) {
        AppMethodBeat.m2504i(2644);
        C8902b.m16044a("EmojiStickerMgr_onResUpdate", (C31214a) new C11610b(i));
        AppMethodBeat.m2505o(2644);
    }
}
