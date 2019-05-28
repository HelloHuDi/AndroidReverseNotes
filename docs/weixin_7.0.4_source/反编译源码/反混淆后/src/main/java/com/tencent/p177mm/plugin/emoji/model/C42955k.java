package com.tencent.p177mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C26107cx;
import com.tencent.p177mm.p230g.p231a.C42075vh;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.emoji.p726f.C42949q;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.emoji.model.k */
public final class C42955k {
    Set<String> kVY;
    Set<String> kVZ;
    Set<String> kWa;
    C4884c kWb = new C277411();
    C4884c kWc = new C277422();

    /* renamed from: com.tencent.mm.plugin.emoji.model.k$1 */
    class C277411 extends C4884c<C42075vh> {
        C277411() {
            AppMethodBeat.m2504i(53078);
            this.xxI = C42075vh.class.getName().hashCode();
            AppMethodBeat.m2505o(53078);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53079);
            C42075vh c42075vh = (C42075vh) c4883b;
            switch (c42075vh.cSo.cuy) {
                case 1:
                    C42955k.this.kVY.addAll(C5046bo.m7508P(c42075vh.cSo.cSp));
                    C42955k.this.kVZ.addAll(C42955k.this.kVY);
                    C42955k.this.bkp();
                    break;
            }
            AppMethodBeat.m2505o(53079);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.k$2 */
    class C277422 extends C4884c<C26107cx> {
        C277422() {
            AppMethodBeat.m2504i(53080);
            this.xxI = C26107cx.class.getName().hashCode();
            AppMethodBeat.m2505o(53080);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53081);
            C26107cx c26107cx = (C26107cx) c4883b;
            if (C42955k.this.kVY.contains(c26107cx.cvY.cvZ)) {
                C42955k.this.kWa.remove(c26107cx.cvY.cvZ);
                if (c26107cx.cvY.success) {
                    C4990ab.m7417i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s success", c26107cx.cvY.cvZ);
                    C42952j.getEmojiStorageMgr().xYo.aqd(c26107cx.cvY.cvZ);
                    C1720g.m3535RO().eJo.mo14541a(new C42949q(c26107cx.cvY.cvZ, 2), 0);
                } else {
                    C4990ab.m7417i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s fail", c26107cx.cvY.cvZ);
                }
                C42955k.this.bkp();
            }
            AppMethodBeat.m2505o(53081);
            return false;
        }
    }

    public C42955k() {
        AppMethodBeat.m2504i(53082);
        C4879a.xxA.mo10052c(this.kWb);
        C4879a.xxA.mo10052c(this.kWc);
        this.kVY = Collections.synchronizedSet(new HashSet());
        this.kVZ = Collections.synchronizedSet(new HashSet());
        this.kWa = Collections.synchronizedSet(new HashSet());
        AppMethodBeat.m2505o(53082);
    }

    /* Access modifiers changed, original: final */
    public final void bkp() {
        AppMethodBeat.m2504i(53083);
        while (!this.kVZ.isEmpty()) {
            if (this.kWa.isEmpty()) {
                Iterator it = this.kVZ.iterator();
                if (it != null) {
                    String str = (String) it.next();
                    this.kVZ.remove(str);
                    EmojiGroupInfo bZ = C42952j.getEmojiStorageMgr().xYo.mo74770bZ(str, true);
                    if (bZ == null || (bZ.field_flag & 256) <= 0) {
                        C4990ab.m7417i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", str);
                        this.kWa.add(str);
                        C1720g.m3535RO().eJo.mo14541a(new C42945g(str, ""), 0);
                    } else {
                        C4990ab.m7417i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", str);
                    }
                }
                AppMethodBeat.m2505o(53083);
                return;
            }
            C4990ab.m7417i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", this.kWa.toString());
            AppMethodBeat.m2505o(53083);
            return;
        }
        C4990ab.m7416i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.m2505o(53083);
    }
}
