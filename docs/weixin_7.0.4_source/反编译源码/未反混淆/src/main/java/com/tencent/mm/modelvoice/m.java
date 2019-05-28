package com.tencent.mm.modelvoice;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.audio.b.i;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.cd;
import java.util.HashMap;
import junit.framework.Assert;

public class m implements at {
    private static HashMap<Integer, d> eaA;
    private u fZZ;
    private cd gaa;
    private i gab;
    private r gac = new r();
    private c gad = new c<oy>() {
        {
            AppMethodBeat.i(116594);
            this.xxI = oy.class.getName().hashCode();
            AppMethodBeat.o(116594);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(116595);
            q.mu((int) ((oy) bVar).cLn.csG.field_msgId);
            AppMethodBeat.o(116595);
            return false;
        }
    };

    static class a implements com.tencent.mm.pluginsdk.cmd.a {
        a() {
        }

        public final boolean a(Context context, String[] strArr, String str) {
            AppMethodBeat.i(116596);
            String str2 = strArr[0];
            int i = -1;
            switch (str2.hashCode()) {
                case -1560895490:
                    if (str2.equals("//voicetrymore")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    if (strArr.length > 1 && strArr[1] != null) {
                        boolean z;
                        if (bo.getInt(strArr[1], 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        i.cqY = z;
                        ab.i("MicroMsg.SubCoreVoice", "summervoicetrymore enable[%d]", Integer.valueOf(r3));
                        AppMethodBeat.o(116596);
                        return true;
                    }
            }
            AppMethodBeat.o(116596);
            return false;
        }
    }

    public m() {
        AppMethodBeat.i(116597);
        AppMethodBeat.o(116597);
    }

    private static m alZ() {
        AppMethodBeat.i(116598);
        m mVar = (m) q.Y(m.class);
        AppMethodBeat.o(116598);
        return mVar;
    }

    public static u ama() {
        AppMethodBeat.i(116599);
        g.RN().QU();
        if (alZ().fZZ == null) {
            Assert.assertTrue("dataDB is null ", g.RP().eJN != null);
            alZ().fZZ = new u(g.RP().eJN);
        }
        u uVar = alZ().fZZ;
        AppMethodBeat.o(116599);
        return uVar;
    }

    public static cd amb() {
        AppMethodBeat.i(116600);
        g.RN().QU();
        if (alZ().gaa == null) {
            Assert.assertTrue("dataDB is null ", g.RP().eJN != null);
            alZ().gaa = new cd(g.RP().eJN);
        }
        cd cdVar = alZ().gaa;
        AppMethodBeat.o(116600);
        return cdVar;
    }

    public static i amc() {
        AppMethodBeat.i(116601);
        g.RN().QU();
        if (alZ().gab == null) {
            alZ().gab = new i();
        }
        i iVar = alZ().gab;
        AppMethodBeat.o(116601);
        return iVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(116602);
        if (alZ().gab != null) {
            alZ().gab.cqV = 0;
        }
        e.d.b(Integer.valueOf(34), this.gac);
        com.tencent.mm.sdk.b.a.xxA.d(this.gad);
        com.tencent.mm.pluginsdk.cmd.b.N("//voicetrymore");
        AppMethodBeat.o(116602);
    }

    static {
        AppMethodBeat.i(116604);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return u.fnj;
            }
        });
        eaA.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return cd.fnj;
            }
        });
        AppMethodBeat.o(116604);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(116603);
        e.d.a(Integer.valueOf(34), this.gac);
        com.tencent.mm.sdk.b.a.xxA.c(this.gad);
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), "//voicetrymore");
        AppMethodBeat.o(116603);
    }

    public final void bA(boolean z) {
    }
}
