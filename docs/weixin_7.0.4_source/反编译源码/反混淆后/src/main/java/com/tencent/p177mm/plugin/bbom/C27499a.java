package com.tencent.p177mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C18668n;
import com.tencent.p177mm.modelsimple.C26467c;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p230g.p231a.C18395su;
import com.tencent.p177mm.p230g.p231a.C26114dk;
import com.tencent.p177mm.p230g.p231a.C37726hi;
import com.tencent.p177mm.p230g.p231a.C9411lk;
import com.tencent.p177mm.plugin.auth.p1239a.C19933a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C7251ar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.bbom.a */
public final class C27499a implements C19933a {

    /* renamed from: com.tencent.mm.plugin.bbom.a$1 */
    class C200011 implements Runnable {
        C200011() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18227);
            C1831bh.m3771oG("ver" + C7243d.vxo);
            C14877am.bYL().addAll(C34832a.bYJ().dhD());
            C4879a c4879a = C4879a.xxA;
            if (c4879a == null) {
                C4990ab.m7412e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
                AppMethodBeat.m2505o(18227);
                return;
            }
            C37726hi c37726hi = new C37726hi();
            c37726hi.cCe.cCf = true;
            c4879a.mo10055m(c37726hi);
            C18395su c18395su = new C18395su();
            c18395su.cOT.cOU = true;
            c4879a.mo10055m(c18395su);
            c4879a.mo10055m(new C26114dk());
            c4879a.mo10055m(new C9411lk());
            C26467c.m42174cQ(true);
            C18668n.ahW().mo44216lN(3);
            C4990ab.m7416i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
            AppMethodBeat.m2505o(18227);
        }

        public final String toString() {
            AppMethodBeat.m2504i(18228);
            String str = super.toString() + "|onGYNetEnd2";
            AppMethodBeat.m2505o(18228);
            return str;
        }
    }

    /* renamed from: a */
    public final void mo5415a(C4825f c4825f, C4826g c4826g, boolean z) {
        AppMethodBeat.m2504i(18229);
        if ((c4826g.vxV.xic & 2) != 0) {
            C7251ar c7251ar = c4826g.vxV.xie;
            if (!z) {
                C9638aw.m17190ZK();
                C18628c.m29105iy(c7251ar.vCi);
            }
            C6665av.fly.mo14899ou(C41730b.m73505pX(C1853r.m3846Yz()));
            if (c7251ar.vCf != 0) {
                C9638aw.m17190ZK();
                C18628c.m29086XU().mo15359cE(c7251ar.vCf + "@qqim", 3);
            }
            C41730b.m73494d((long) c7251ar.vCf, 3);
        } else {
            C4990ab.m7420w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
        }
        C18698o.m29229mg(1);
        if (z) {
            C37726hi c37726hi = new C37726hi();
            c37726hi.cCe.cCf = false;
            C4879a.xxA.mo10055m(c37726hi);
            C18395su c18395su = new C18395su();
            c18395su.cOT.cOU = true;
            C4879a.xxA.mo10055m(c18395su);
            AppMethodBeat.m2505o(18229);
            return;
        }
        C9638aw.m17180RS().mo10302aa(new C200011());
        AppMethodBeat.m2505o(18229);
    }

    /* renamed from: a */
    public final void mo5416a(C4844b c4844b, String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(18230);
        C6665av.fly.mo14899ou(C41730b.m73505pX(C1853r.m3846Yz()));
        C41730b.m73494d((long) i, 3);
        C9638aw.m17190ZK();
        C18628c.m29086XU().mo15359cE(c4844b.vyJ.wIh, 2);
        if (i != 0) {
            C9638aw.m17190ZK();
            C18628c.m29086XU().mo15359cE(i + "@qqim", 3);
        }
        AppMethodBeat.m2505o(18230);
    }
}
