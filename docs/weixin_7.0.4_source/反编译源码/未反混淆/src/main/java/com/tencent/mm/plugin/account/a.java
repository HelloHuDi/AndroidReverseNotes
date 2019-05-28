package com.tencent.mm.plugin.account;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;

public class a implements at {
    private static HashMap<Integer, d> eaA;
    private b gpP;
    private h gpQ;
    private k gpR;
    private an gpS;
    private ap gpT;
    private q gpU;
    private o gpV;
    private com.tencent.mm.plugin.account.friend.a.d gpW = new com.tencent.mm.plugin.account.friend.a.d();
    private LinkedList<aym> gpX = null;
    private c gpY = new c();
    private e gpZ = new e();
    private f gqa = new f();
    private com.tencent.mm.sdk.b.c gqb = new com.tencent.mm.sdk.b.c<aw>() {
        {
            AppMethodBeat.i(124621);
            this.xxI = aw.class.getName().hashCode();
            AppMethodBeat.o(124621);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(124622);
            aw awVar = (aw) bVar;
            if (awVar instanceof aw) {
                awVar.ctZ.csN = l.apV();
            }
            AppMethodBeat.o(124622);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c gqc = new com.tencent.mm.sdk.b.c<hw>() {
        {
            AppMethodBeat.i(124626);
            this.xxI = hw.class.getName().hashCode();
            AppMethodBeat.o(124626);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(124627);
            hw hwVar = (hw) bVar;
            if (hwVar instanceof hw) {
                int i = hwVar.cCP.scene;
                m abVar = new ab();
                ((akp) abVar.ehh.fsG.fsP).Scene = i;
                g.Rg().a(abVar, 0);
            }
            AppMethodBeat.o(124627);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c gqd = new com.tencent.mm.sdk.b.c<hl>() {
        {
            AppMethodBeat.i(124628);
            this.xxI = hl.class.getName().hashCode();
            AppMethodBeat.o(124628);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(124629);
            hl hlVar = (hl) bVar;
            if (hlVar instanceof hl) {
                String str = hlVar.cCl.cCn;
                if (bo.isNullOrNil(str)) {
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreFriend", "hy: mobile number is null");
                } else {
                    Cursor a = a.getAddrUploadStg().fni.a("select addr_upload2.username from addr_upload2 where addr_upload2.moblie = ".concat(String.valueOf(str)), null, 2);
                    LinkedList linkedList = new LinkedList();
                    while (a.moveToNext()) {
                        linkedList.add(a.getString(0));
                    }
                    a.close();
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SubCoreFriend", "hy: username: %s", linkedList.size() == 0 ? "" : (String) linkedList.get(0));
                    hlVar.cCm.userName = str;
                }
            }
            AppMethodBeat.o(124629);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c gqe = new com.tencent.mm.sdk.b.c<qh>() {
        {
            AppMethodBeat.i(124623);
            this.xxI = qh.class.getName().hashCode();
            AppMethodBeat.o(124623);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(124624);
            qh qhVar = (qh) bVar;
            Intent intent = qhVar.cMw.intent;
            String str = qhVar.cMw.username;
            if (intent == null || str == null || str.length() == 0) {
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AccountSyncUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            } else {
                ao wj = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).wj(str);
                if (wj != null) {
                    intent.putExtra("Contact_Uin", wj.gwC);
                    intent.putExtra("Contact_QQNick", wj.getDisplayName());
                }
                com.tencent.mm.plugin.account.friend.a.a vT = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vT(str);
                if (vT != null) {
                    intent.putExtra("Contact_Mobile_MD5", vT.Aq());
                }
            }
            AppMethodBeat.o(124624);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(124630);
        AppMethodBeat.o(124630);
    }

    private static synchronized a aoO() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(124631);
            aVar = (a) com.tencent.mm.model.q.Y(a.class);
            AppMethodBeat.o(124631);
        }
        return aVar;
    }

    public static b getAddrUploadStg() {
        AppMethodBeat.i(124632);
        g.RN().QU();
        if (aoO().gpP == null) {
            aoO().gpP = new b(g.RP().eJN);
        }
        b bVar = aoO().gpP;
        AppMethodBeat.o(124632);
        return bVar;
    }

    public static h getFacebookFrdStg() {
        AppMethodBeat.i(124633);
        g.RN().QU();
        if (aoO().gpQ == null) {
            aoO().gpQ = new h(g.RP().eJN);
        }
        h hVar = aoO().gpQ;
        AppMethodBeat.o(124633);
        return hVar;
    }

    public static k getFrdExtStg() {
        AppMethodBeat.i(124634);
        g.RN().QU();
        if (aoO().gpR == null) {
            aoO().gpR = new k(g.RP().eJN);
        }
        k kVar = aoO().gpR;
        AppMethodBeat.o(124634);
        return kVar;
    }

    public static an getQQGroupStg() {
        AppMethodBeat.i(124635);
        g.RN().QU();
        if (aoO().gpS == null) {
            aoO().gpS = new an(g.RP().eJN);
        }
        an anVar = aoO().gpS;
        AppMethodBeat.o(124635);
        return anVar;
    }

    public static q getInviteFriendOpenStg() {
        AppMethodBeat.i(124636);
        g.RN().QU();
        if (aoO().gpU == null) {
            aoO().gpU = new q(g.RP().eJN);
        }
        q qVar = aoO().gpU;
        AppMethodBeat.o(124636);
        return qVar;
    }

    public static ap getQQListStg() {
        AppMethodBeat.i(124637);
        g.RN().QU();
        if (aoO().gpT == null) {
            aoO().gpT = new ap(g.RP().eJN);
        }
        ap apVar = aoO().gpT;
        AppMethodBeat.o(124637);
        return apVar;
    }

    public static void setFriendData(LinkedList<aym> linkedList) {
        AppMethodBeat.i(124638);
        g.RN().QU();
        aoO().gpX = linkedList;
        AppMethodBeat.o(124638);
    }

    public static LinkedList<aym> getFriendData() {
        AppMethodBeat.i(124639);
        g.RN().QU();
        LinkedList linkedList = aoO().gpX;
        AppMethodBeat.o(124639);
        return linkedList;
    }

    public static void clearFriendData() {
        AppMethodBeat.i(124640);
        g.RN().QU();
        aoO().gpX = null;
        AppMethodBeat.o(124640);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(124641);
        com.tencent.mm.sdk.b.a.xxA.d(this.gqe);
        com.tencent.mm.sdk.b.a.xxA.d(this.gqd);
        com.tencent.mm.sdk.b.a.xxA.d(this.gpY);
        com.tencent.mm.sdk.b.a.xxA.d(this.gpZ);
        com.tencent.mm.sdk.b.a.xxA.d(this.gqa);
        com.tencent.mm.sdk.b.a.xxA.d(this.gqb);
        com.tencent.mm.sdk.b.a.xxA.d(this.gqc);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(42), this.gpW);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(66), this.gpW);
        this.gpX = null;
        AppMethodBeat.o(124641);
    }

    public final void iy(int i) {
    }

    static {
        AppMethodBeat.i(124644);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        eaA.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return h.fnj;
            }
        });
        eaA.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return k.fnj;
            }
        });
        eaA.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return an.fnj;
            }
        });
        eaA.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return ap.fnj;
            }
        });
        eaA.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return q.fnj;
            }
        });
        eaA.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return o.fnj;
            }
        });
        AppMethodBeat.o(124644);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(124642);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(42), this.gpW);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(66), this.gpW);
        com.tencent.mm.sdk.b.a.xxA.c(this.gqe);
        com.tencent.mm.sdk.b.a.xxA.c(this.gqd);
        com.tencent.mm.sdk.b.a.xxA.c(this.gpY);
        com.tencent.mm.sdk.b.a.xxA.c(this.gpZ);
        com.tencent.mm.sdk.b.a.xxA.c(this.gqa);
        com.tencent.mm.sdk.b.a.xxA.c(this.gqb);
        com.tencent.mm.sdk.b.a.xxA.c(this.gqc);
        ((n) g.M(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                AppMethodBeat.i(124625);
                com.tencent.mm.w.a aVar = new com.tencent.mm.w.a();
                ((n) g.M(n.class)).registerIndexStorage(aVar);
                aVar.create();
                com.tencent.mm.w.b bVar = new com.tencent.mm.w.b();
                ((n) g.M(n.class)).registerNativeLogic(9, bVar);
                bVar.create();
                ((n) g.M(n.class)).registerFTSUILogic(new com.tencent.mm.w.a.a());
                AppMethodBeat.o(124625);
                return true;
            }

            public final String getName() {
                return "InitFTSFriendPluginTask";
            }
        });
        AppMethodBeat.o(124642);
    }

    public final void bA(boolean z) {
    }

    public static o getGoogleFriendStorage() {
        AppMethodBeat.i(124643);
        g.RN().QU();
        if (aoO().gpV == null) {
            aoO().gpV = new o(g.RP().eJN);
        }
        o oVar = aoO().gpV;
        AppMethodBeat.o(124643);
        return oVar;
    }
}
