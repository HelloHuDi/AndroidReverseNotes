package com.tencent.p177mm.plugin.emojicapture.model.p388b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C26366d;
import com.tencent.p177mm.loader.p864g.C42155f;
import com.tencent.p177mm.loader.p864g.C45423h;
import com.tencent.p177mm.loader.p864g.p1196a.C18536g;
import com.tencent.p177mm.loader.p864g.p1196a.C18537h;
import com.tencent.p177mm.loader.p864g.p1196a.C46886a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureService;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bJF\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager;", "", "()V", "mixCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1;", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "mixTasks", "", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "kotlin.jvm.PlatformType", "", "stopServiceRunnable", "Lkotlin/Function0;", "", "addTask", "info", "scene", "", "timeEnter", "", "videoPath", "", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "hasSticker", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.b.e */
public final class C20429e {
    private static final C26366d<C31353h> liD = new C26366d(new C18536g(new C46886a(20), new C18537h(), "EmojiMix"));
    private static C31214a<C37091y> liE = C20431b.liI;
    private static final List<C11615d> liF = Collections.synchronizedList(new LinkedList());
    private static final C20430a liG = new C20430a();
    public static final C20429e liH = new C20429e();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.e$a */
    public static final class C20430a implements C42155f<C31353h> {
        C20430a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo9004a(C26365c c26365c, C45423h c45423h) {
            C20429e c20429e;
            AppMethodBeat.m2504i(2671);
            C31353h c31353h = (C31353h) c26365c;
            C25052j.m39376p(c31353h, "task");
            C25052j.m39376p(c45423h, "status");
            C11615d c11615d = null;
            C20429e c20429e2 = C20429e.liH;
            List bnF = C20429e.liF;
            C25052j.m39375o(bnF, "mixTasks");
            Iterable<C11615d> iterable = bnF;
            synchronized (iterable) {
                try {
                    for (C11615d c11615d2 : iterable) {
                        C11615d c11615d22;
                        if (c11615d22.ezZ != c31353h.ezZ) {
                            c11615d22 = c11615d;
                        }
                        c11615d = c11615d22;
                    }
                    C37091y c37091y = C37091y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(2671);
                }
            }
            if (c11615d != null) {
                c20429e2 = C20429e.liH;
                C20429e.liF.remove(c11615d);
            }
            c20429e2 = C20429e.liH;
            if (C20429e.liF.isEmpty()) {
                c20429e = C20429e.liH;
                C8902b.m16041a(1000, C20429e.liE);
            }
            String Ow = C27801f.TAG;
            StringBuilder append = new StringBuilder("onLoaderFin: ").append(c45423h).append(", ");
            c20429e = C20429e.liH;
            C4990ab.m7416i(Ow, append.append(C20429e.liF.size()).toString());
            AppMethodBeat.m2505o(2671);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.e$b */
    static final class C20431b extends C25053k implements C31214a<C37091y> {
        public static final C20431b liI = new C20431b();

        static {
            AppMethodBeat.m2504i(2673);
            AppMethodBeat.m2505o(2673);
        }

        C20431b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(2672);
            C25985d.m41479l(new Intent(C4996ah.getContext(), EmojiCaptureService.class), "tools");
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2672);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(2675);
        liD.mo44160a((C42155f) liG);
        AppMethodBeat.m2505o(2675);
    }

    private C20429e() {
    }

    /* renamed from: a */
    public static C11615d m31584a(int i, long j, String str, C42972a c42972a, int i2, boolean z, boolean z2, EmojiInfo emojiInfo) {
        C27802g c27802g;
        AppMethodBeat.m2504i(2674);
        C25052j.m39376p(str, "videoPath");
        C25052j.m39376p(c42972a, "retriever");
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C11617a c11617a = C34006c.lhw;
        String str2 = C11617a.bmO() + "temp_gif" + C5046bo.anU();
        C11617a c11617a2 = C34006c.lhw;
        C11615d c11615d = new C11615d(i, j, str, str2, c42972a, i2, z, z2, !C34006c.lhr, emojiInfo);
        C25052j.m39376p(c11615d, "info");
        liF.add(c11615d);
        liD.mo44158a((C26365c) new C31353h(c11615d));
        C31214a c31214a = liE;
        if (c31214a != null) {
            c27802g = new C27802g(c31214a);
        } else {
            Object c27802g2 = c31214a;
        }
        C5004al.m7439af(c27802g2);
        C25985d.m41477j(new Intent(C4996ah.getContext(), EmojiCaptureService.class), "tools");
        AppMethodBeat.m2505o(2674);
        return c11615d;
    }
}
