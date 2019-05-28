package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.n;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.e;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.plugin.messenger.foundation.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation extends f implements a, c, d, aj, p {
    private e flI = new e();
    private d oqr;
    private e oqs;
    private bz oqt = new bz();
    private com.tencent.mm.plugin.chatroom.a oqu = new com.tencent.mm.plugin.chatroom.a();
    private aj oqv;
    private b rWZ;

    public PluginMessengerFoundation() {
        AppMethodBeat.i(1050);
        AppMethodBeat.o(1050);
    }

    public void installed() {
        AppMethodBeat.i(1051);
        alias(p.class);
        AppMethodBeat.o(1051);
    }

    public void dependency() {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_SHAKA_ADD2_17);
        dependsOn(PluginZero.class);
        AppMethodBeat.o(FilterEnum4Shaka.MIC_SHAKA_ADD2_17);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_SHAKA_ADD2_18);
        ab.i("MicroMsg.TAG", "init thread pool[%s] current tid[%d] priority[%d] process[%s]", com.tencent.mm.sdk.g.d.xDG, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(Thread.currentThread().getPriority()), ((h) com.tencent.mm.kernel.g.RM().Rn()).eHT);
        com.tencent.mm.plugin.zero.c.vaf = new com.tencent.mm.ci.c<com.tencent.mm.plugin.zero.a.f>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(1046);
                f fVar = new f();
                AppMethodBeat.o(1046);
                return fVar;
            }
        };
        a aVar = new a();
        r.a.a(2, aVar);
        r.a.a(17, aVar);
        r.a.a(4, aVar);
        r.a.a(7, new b());
        c cVar = new c();
        r.a.a(5, cVar);
        r.a.a(8, cVar);
        r.a.a(9, cVar);
        r.a.a(1, new g());
        com.tencent.mm.kernel.g.RL().a(q.class, new com.tencent.mm.kernel.c.e(new m()));
        com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.zero.a.d.class);
        if (gVar.SG()) {
            new com.tencent.mm.plugin.zero.tasks.b().before(this);
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.foundation.a.d.class, new com.tencent.mm.plugin.messenger.foundation.a.d() {
                public final void a(bbv bbv, String str) {
                    AppMethodBeat.i(FilterEnum4Shaka.MIC_SHAKA_ADD2_12);
                    a.a(bbv, str, null, true, false);
                    AppMethodBeat.o(FilterEnum4Shaka.MIC_SHAKA_ADD2_12);
                }

                public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.c cVar) {
                    AppMethodBeat.i(1048);
                    com.tencent.mm.vending.b.b a = a.a(cVar);
                    AppMethodBeat.o(1048);
                    return a;
                }
            });
            com.tencent.mm.kernel.g.a(i.class, new i() {
                public final com.tencent.mm.ai.e.b a(com.tencent.mm.ai.e.a aVar, t tVar) {
                    AppMethodBeat.i(1049);
                    com.tencent.mm.ai.e.b a = c.a(aVar, tVar);
                    AppMethodBeat.o(1049);
                    return a;
                }
            });
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.chatroom.a.c.class, this.oqu);
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_SHAKA_ADD2_18);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(1054);
        if (gVar.SG()) {
            this.oqr = new d();
            com.tencent.mm.kernel.g.a(j.class, new com.tencent.mm.kernel.c.e(this.oqr));
            this.oqs = new e();
            com.tencent.mm.kernel.g.a(k.class, new com.tencent.mm.kernel.c.e(this.oqs));
        }
        AppMethodBeat.o(1054);
    }

    public String toString() {
        return "plugin-messenger-foundation";
    }

    public HashMap<Integer, com.tencent.mm.cd.h.d> collectDatabaseFactory() {
        AppMethodBeat.i(1055);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return bj.fnj;
            }
        });
        hashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return com.tencent.mm.storage.aj.fnj;
            }
        });
        hashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return com.tencent.mm.az.i.fnj;
            }
        });
        hashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return al.fnj;
            }
        });
        hashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return br.fnj;
            }
        });
        hashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return bw.fnj;
            }
        });
        hashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return ao.fnj;
            }
        });
        hashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return bg.fnj;
            }
        });
        hashMap.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return bu.fnj;
            }
        });
        hashMap.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return cb.fnj;
            }
        });
        hashMap.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return ay.fnj;
            }
        });
        hashMap.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return aw.fnj;
            }
        });
        hashMap.put(Integer.valueOf("CHATROOM_MSGSEQ_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return x.fnj;
            }
        });
        hashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return bc.fnj;
            }
        });
        AppMethodBeat.o(1055);
        return hashMap;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(1056);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK), this.flI);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(1), this.flI);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(10001), this.oqt);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(10002), this.oqt);
        AppMethodBeat.o(1056);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_SHAKA_ADD2_22);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK), this.flI);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(1), this.flI);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(10001), this.oqt);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(10002), this.oqt);
        AppMethodBeat.o(FilterEnum4Shaka.MIC_SHAKA_ADD2_22);
    }

    public void onDataBaseOpened(com.tencent.mm.cd.h hVar, com.tencent.mm.cd.h hVar2) {
        AppMethodBeat.i(1058);
        com.tencent.mm.model.q.Yx();
        d dVar = this.oqr;
        com.tencent.mm.cd.h hVar3 = com.tencent.mm.kernel.g.RP().eJN;
        com.tencent.mm.kernel.g.RP();
        dVar.oqf = new n(new com.tencent.mm.az.i(hVar3));
        dVar.oqg = new com.tencent.mm.az.a();
        dVar.oqb = new com.tencent.mm.storage.aj(hVar3);
        dVar.oqc = new bw(hVar3);
        dVar.oqe = new al(hVar3);
        dVar.oqd = new bj(hVar3, dVar.oqb, dVar.oqe);
        dVar.oqh = new br(hVar3);
        dVar.oqi = new ao(hVar3);
        dVar.oqj = new ay(hVar3);
        dVar.oqk = new aw(hVar3);
        dVar.oql = new bg(hVar3);
        dVar.oqm = new bu(hVar3);
        dVar.oqn = new cb(hVar3);
        dVar.oqo = new x(hVar3);
        dVar.oqp = new bc(hVar3);
        AppMethodBeat.o(1058);
    }

    public void onDataBaseClosed(com.tencent.mm.cd.h hVar, com.tencent.mm.cd.h hVar2) {
    }

    public bz getSysCmdMsgExtension() {
        return this.oqt;
    }

    public void setIDataTransferFactoryDelegate(aj ajVar) {
        this.oqv = ajVar;
    }

    public List<ai> getDataTransferList() {
        AppMethodBeat.i(1059);
        if (this.oqv != null) {
            List dataTransferList = this.oqv.getDataTransferList();
            if (dataTransferList.size() > 8) {
                Assert.assertTrue("Do not add more IDataTransfer from mIDataTransferFactoryDelegate!!!!!!!!!!!", false);
            }
            AppMethodBeat.o(1059);
            return dataTransferList;
        }
        List<ai> arrayList = new ArrayList();
        AppMethodBeat.o(1059);
        return arrayList;
    }

    public void setBizTimeLineCallback(b bVar) {
        this.rWZ = bVar;
    }

    public b getBizTimeLineCallback() {
        return this.rWZ;
    }
}
