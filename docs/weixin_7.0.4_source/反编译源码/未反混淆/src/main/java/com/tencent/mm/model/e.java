package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class e implements com.tencent.mm.ai.e {
    private static final a fks = new a();

    static final class a extends com.tencent.mm.ci.a<com.tencent.mm.plugin.messenger.foundation.a.a> implements com.tencent.mm.plugin.messenger.foundation.a.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(com.tencent.mm.ai.e.a aVar, bi biVar, String str, String str2, boolean z) {
            AppMethodBeat.i(59716);
            final com.tencent.mm.ai.e.a aVar2 = aVar;
            final bi biVar2 = biVar;
            final String str3 = str;
            final String str4 = str2;
            final boolean z2 = z;
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.plugin.messenger.foundation.a.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(59714);
                    ((com.tencent.mm.plugin.messenger.foundation.a.a) obj).a(aVar2, biVar2, str3, str4, z2);
                    AppMethodBeat.o(59714);
                }
            });
            AppMethodBeat.o(59716);
        }

        public final void b(com.tencent.mm.ai.e.a aVar, bi biVar, String str, String str2, boolean z) {
            AppMethodBeat.i(59717);
            final com.tencent.mm.ai.e.a aVar2 = aVar;
            final bi biVar2 = biVar;
            final String str3 = str;
            final String str4 = str2;
            final boolean z2 = z;
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.plugin.messenger.foundation.a.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(59715);
                    ((com.tencent.mm.plugin.messenger.foundation.a.a) obj).b(aVar2, biVar2, str3, str4, z2);
                    AppMethodBeat.o(59715);
                }
            });
            AppMethodBeat.o(59717);
        }
    }

    static {
        AppMethodBeat.i(59721);
        AppMethodBeat.o(59721);
    }

    public static void a(com.tencent.mm.plugin.messenger.foundation.a.a aVar) {
        AppMethodBeat.i(59718);
        fks.aD(aVar);
        AppMethodBeat.o(59718);
    }

    public b b(com.tencent.mm.ai.e.a aVar) {
        b bVar = null;
        AppMethodBeat.i(59719);
        cm cmVar = aVar.eAB;
        String str = (String) g.RP().Ry().get(2, (Object) "");
        if (str.length() <= 0) {
            AppMethodBeat.o(59719);
        } else {
            String a = aa.a(cmVar.vEB);
            String a2 = aa.a(cmVar.vEC);
            if (bo.nullAsNil(a).length() <= 0 || bo.nullAsNil(a2).length() <= 0) {
                ab.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
                AppMethodBeat.o(59719);
            } else {
                bi a3 = a(cmVar, a, a2, str);
                if (a3 == null) {
                    AppMethodBeat.o(59719);
                } else {
                    int i;
                    bi biVar;
                    boolean z = ((j) g.K(j.class)).XU().has(a) || str.equals(a);
                    if (z) {
                        a3.hO(1);
                        a3.ju(a2);
                        i = cmVar.jBT;
                        biVar = a3;
                    } else {
                        a3.hO(0);
                        a3.ju(a);
                        if (cmVar.jBT > 3) {
                            i = cmVar.jBT;
                            biVar = a3;
                        } else {
                            i = 3;
                            biVar = a3;
                        }
                    }
                    biVar.setStatus(i);
                    if (cmVar.nao == Downloads.MIN_WAIT_FOR_NETWORK) {
                        a3.setStatus(4);
                    }
                    a3.ix(cmVar.vEG);
                    if (a3.apB(r.Yz())) {
                        ak aoZ = ((j) g.K(j.class)).XR().aoZ(a3.field_talker);
                        if (aoZ != null) {
                            aoZ.jk(16777216);
                            ((j) g.K(j.class)).XR().a(aoZ, a3.field_talker);
                        }
                    }
                    fks.a(aVar, a3, a, a2, z);
                    if (a3.field_msgId == 0) {
                        a3.hY(2);
                        bf.a(a3, aVar);
                        a3.setMsgId(bf.l(a3));
                        bVar = new b(a3, true);
                    } else {
                        ((j) g.K(j.class)).bOr().b(cmVar.ptF, a3);
                        bVar = new b(a3, false);
                    }
                    fks.b(aVar, a3, a, a2, z);
                    AppMethodBeat.o(59719);
                }
            }
        }
        return bVar;
    }

    /* Access modifiers changed, original: protected */
    public bi a(cm cmVar, String str, String str2, String str3) {
        AppMethodBeat.i(59720);
        String str4 = str3.equals(str) ? str2 : str;
        bi Q = ((j) g.K(j.class)).bOr().Q(str4, cmVar.ptF);
        ab.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", Long.valueOf(cmVar.ptF), Long.valueOf(Q.field_msgId), str, str2, str4);
        if (Q.field_msgId != 0 && Q.field_createTime + 604800000 < bf.q(str4, (long) cmVar.pcX)) {
            ab.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(cmVar.ptF), Long.valueOf(Q.field_msgId));
            bf.fm(Q.field_msgId);
            Q.setMsgId(0);
        }
        if (Q.field_msgId == 0) {
            Q = new bi();
            Q.eI(cmVar.ptF);
            Q.eJ(bf.q(str4, (long) cmVar.pcX));
            Q.setType(cmVar.nao);
            Q.setContent(bo.anA(bo.nullAsNil(aa.a(cmVar.vED))));
        }
        AppMethodBeat.o(59720);
        return Q;
    }

    public void a(c cVar) {
    }
}
