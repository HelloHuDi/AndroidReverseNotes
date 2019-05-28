package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;

public final class a extends com.tencent.mm.plugin.fts.a.b {
    private static Set<String> mFJ = new HashSet();
    private com.tencent.mm.plugin.fts.a.m eAX;
    private Method mFA;
    private com.tencent.mm.sdk.e.n.b mFB = new com.tencent.mm.sdk.e.n.b() {
        public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
            AppMethodBeat.i(136650);
            String str = (String) obj;
            if (a.Nk(str)) {
                ad aoI = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoI(str);
                if (aoI == null || (a.G(aoI) && !aoI.dsf())) {
                    switch (i) {
                        case 2:
                        case 5:
                            if (!a.this.mFx.containsKey(str)) {
                                a.this.eAX.a(65556, new h(str));
                                AppMethodBeat.o(136650);
                                return;
                            }
                            break;
                        case 3:
                            if (!(a.this.mFw.contains(str) || a.this.mFx.containsKey(str))) {
                                a.this.eAX.a(65556, new i(str));
                                break;
                            }
                    }
                    AppMethodBeat.o(136650);
                    return;
                }
                ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", str);
                AppMethodBeat.o(136650);
                return;
            }
            ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", str);
            AppMethodBeat.o(136650);
        }
    };
    private com.tencent.mm.sdk.e.n.b mFC = new com.tencent.mm.sdk.e.n.b() {
        public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
            AppMethodBeat.i(136651);
            String str = (String) obj;
            if (a.Nk(str)) {
                ad aoI = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoI(str);
                if (aoI == null || a.G(aoI)) {
                    switch (i) {
                        case 2:
                            a.this.eAX.a(65556, new e(str));
                            AppMethodBeat.o(136651);
                            return;
                        case 3:
                        case 4:
                            if (!a.this.mFx.containsKey(str)) {
                                a.this.eAX.a(65556, new h(str));
                                AppMethodBeat.o(136651);
                                return;
                            }
                            break;
                        case 5:
                            a.this.eAX.a(65556, new d(str));
                            break;
                    }
                    AppMethodBeat.o(136651);
                    return;
                }
                ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", str);
                AppMethodBeat.o(136651);
                return;
            }
            ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", str);
            AppMethodBeat.o(136651);
        }
    };
    private com.tencent.mm.sdk.e.k.a mFD = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(136652);
            if (str.equals("*") || str.equals("chatroomname")) {
                AppMethodBeat.o(136652);
                return;
            }
            if (!a.this.mFx.containsKey(str)) {
                a.this.eAX.a(65556, new h(str));
            }
            AppMethodBeat.o(136652);
        }
    };
    private com.tencent.mm.sdk.e.k.a mFE = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(136653);
            String[] split = str.split(" ");
            if (split == null || split.length == 0) {
                AppMethodBeat.o(136653);
                return;
            }
            if (split[0].equals("update")) {
                for (int i = 1; i < split.length; i++) {
                    a.this.eAX.a(65554, new v(bo.getLong(split[i], 0)));
                }
                a.this.eAX.a(65556, new u(a.this, (byte) 0));
            }
            AppMethodBeat.o(136653);
        }
    };
    private com.tencent.mm.sdk.b.c mFF = new com.tencent.mm.sdk.b.c<tv>() {
        {
            AppMethodBeat.i(136654);
            this.xxI = tv.class.getName().hashCode();
            AppMethodBeat.o(136654);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136655);
            tv tvVar = (tv) bVar;
            if (tvVar.cPX.cvc <= 0) {
                a.this.eAX.a(131093, new u(a.this, (byte) 0));
            } else if (a.this.mFI.doT()) {
                ap h = a.this.mFI;
                long j = tvVar.cPX.cvc;
                h.ae(j, j);
                ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "* Update contact at once triggered.");
            }
            AppMethodBeat.o(136655);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mFG = new com.tencent.mm.sdk.b.c<ts>() {
        {
            AppMethodBeat.i(136656);
            this.xxI = ts.class.getName().hashCode();
            AppMethodBeat.o(136656);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136657);
            a.this.eAX.a(65556, new g(com.tencent.mm.plugin.fts.a.c.mCl));
            a.this.eAX.a(131093, new u(a.this, (byte) 0));
            AppMethodBeat.o(136657);
            return false;
        }
    };
    private ap mFH = new ap(com.tencent.mm.kernel.g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        private int mFL = 0;

        public final boolean BI() {
            AppMethodBeat.i(136658);
            PluginFTS pluginFTS = (PluginFTS) com.tencent.mm.kernel.g.M(PluginFTS.class);
            byte b = (pluginFTS.isCharging() || !pluginFTS.isInBackground()) ? true : (byte) 0;
            if (b == (byte) 0) {
                int i = this.mFL + 1;
                this.mFL = i;
                if (i < 6) {
                    AppMethodBeat.o(136658);
                    return true;
                }
            }
            a.this.eAX.a(131093, new u(a.this, (byte) 0));
            this.mFL = 0;
            AppMethodBeat.o(136658);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(136659);
            String str = super.toString() + "|delayIndexTimer";
            AppMethodBeat.o(136659);
            return str;
        }
    }, true);
    private ap mFI = new ap(com.tencent.mm.kernel.g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(136660);
            a.this.eAX.a(131093, new u(a.this, (byte) 0));
            AppMethodBeat.o(136660);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(136661);
            String str = super.toString() + "|atOnceIndexTimer";
            AppMethodBeat.o(136661);
            return str;
        }
    }, false);
    private com.tencent.mm.plugin.fts.c.a mFv;
    private HashSet<String> mFw;
    private HashMap<String, List<Long>> mFx;
    private HashMap<String, String[]> mFy;
    private HashMap<String, List<Long>> mFz;
    private com.tencent.mm.plugin.fts.a.j mgD;

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private HashSet<String> mFM;
        private HashMap<String, ad> mFN;
        private long mFO;
        private long mFP;
        private int mFQ;
        private int mFR;
        private int mFS;
        private int mFT;
        private int mFU;
        private int mFV;
        private int mFW;
        private int mFX;

        private b() {
            AppMethodBeat.i(136666);
            this.mFN = new HashMap();
            this.mFO = -1;
            this.mFP = -1;
            this.mFQ = 0;
            this.mFR = 0;
            this.mFS = 0;
            this.mFT = 0;
            this.mFU = 0;
            AppMethodBeat.o(136666);
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:133:0x02a3 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0319  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0319  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x02a3 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x02a3 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0319  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean execute() {
            int i;
            long j;
            List list;
            int a;
            Throwable e;
            AppMethodBeat.i(136667);
            ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building contact index.");
            Ng("start");
            if (this.mFM == null) {
                this.mFM = new HashSet();
                Cursor a2 = a.this.mFv.a(com.tencent.mm.plugin.fts.a.c.mCk, true, false, true, false, true);
                while (a2.moveToNext()) {
                    String string = a2.getString(1);
                    i = a2.getInt(2);
                    j = a2.getLong(0);
                    if (i == 1) {
                        list = (List) a.this.mFx.get(string);
                        if (list == null) {
                            list = new ArrayList(16);
                            a.this.mFx.put(string, list);
                        }
                        list.add(Long.valueOf(j));
                    } else {
                        this.mFM.add(string);
                        if (i == 2) {
                            a.this.mFw.add(string);
                        }
                    }
                }
                a2.close();
                this.mFV = a.this.mFx.size();
                this.mFW = a.this.mFw.size();
                this.mFX = this.mFM.size();
                if (this.mFX < 5) {
                    this.mDq |= 1;
                }
            }
            Ng("getBuildContact");
            InterruptedException interruptedException;
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(136667);
                throw interruptedException;
            }
            if (a.this.mFx.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (List list2 : a.this.mFx.values()) {
                    arrayList.addAll(list2);
                }
                a.this.mFx.clear();
                a.this.mFv.bV(arrayList);
            }
            Ng("deleteDirtyContact");
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(136667);
                throw interruptedException;
            }
            String str;
            if (a.this.mFw.size() > 0) {
                Iterator it = a.this.mFw.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    a.this.mFv.G(str, a.this.mgD.MW(str));
                }
                a.this.mFw.clear();
            }
            Ng("updateTimestampContact");
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(136667);
                throw interruptedException;
            }
            Cursor i2 = a.this.mgD.i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[]{Long.toString(this.mFO)});
            i = 50;
            while (i2.moveToNext()) {
                if (Thread.interrupted()) {
                    i2.close();
                    a.this.mFv.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(136667);
                    throw interruptedException;
                }
                j = i2.getLong(0);
                this.mFO = j;
                ad adVar = new ad();
                adVar.ewQ = j;
                adVar.setUsername(i2.getString(1));
                adVar.iy(i2.getString(2));
                adVar.iz(i2.getString(3));
                adVar.iB(i2.getString(4));
                adVar.hw(i2.getInt(5));
                adVar.setType(i2.getInt(6));
                adVar.H(i2.getBlob(7));
                adVar.iI(i2.getString(8));
                adVar.hy(0);
                this.mFN.put(adVar.field_username, adVar);
                if (!(com.tencent.mm.model.t.kH(adVar.field_username) || !a.this.H(adVar) || this.mFM.remove(adVar.field_username))) {
                    if (i >= 50) {
                        a.this.mFv.commit();
                        a.this.mFv.beginTransaction();
                        i = 0;
                    }
                    try {
                        if (!adVar.field_username.endsWith("@chatroom") && (adVar.field_verifyFlag & ad.dsh()) == 0) {
                            a.this.F(adVar);
                            adVar.dsk();
                        }
                        i += a.this.J(adVar);
                        this.mFR++;
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e2, "Build contact index failed with exception.\n", new Object[0]);
                        this.mFT++;
                    }
                }
            }
            i2.close();
            a.this.mFv.commit();
            Ng("buildWXContact");
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(136667);
                throw interruptedException;
            }
            Cursor i3 = a.this.mgD.i("SELECT rowid, chatroomname, memberlist, roomdata FROM chatroom WHERE ROWID > ? ORDER BY ROWID;", new String[]{Long.toString(this.mFP)});
            i = 50;
            while (i3.moveToNext()) {
                if (Thread.interrupted()) {
                    i3.close();
                    a.this.mFv.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(136667);
                    throw interruptedException;
                }
                this.mFP = i3.getLong(0);
                String string2 = i3.getString(1);
                if (!this.mFM.remove(string2)) {
                    ad adVar2 = (ad) this.mFN.get(string2);
                    if (adVar2 == null) {
                        this.mFU++;
                    } else {
                        String string3 = i3.getString(2);
                        byte[] blob = i3.getBlob(3);
                        try {
                            String[] split = com.tencent.mm.plugin.fts.a.c.a.mCy.split(string3);
                            Arrays.sort(split, new Comparator<String>() {
                                public final /* synthetic */ int compare(Object obj, Object obj2) {
                                    AppMethodBeat.i(136665);
                                    int stringCompareUtfBinary = FTSJNIUtils.stringCompareUtfBinary((String) obj, (String) obj2);
                                    AppMethodBeat.o(136665);
                                    return stringCompareUtfBinary;
                                }
                            });
                            int j2 = i + a.this.j(string2, split);
                            try {
                                a = j2 + a.this.a(string2, adVar2, split, blob, this.mFN);
                            } catch (Exception e3) {
                                e = e3;
                                a = j2;
                                ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                                this.mFU++;
                                i = a;
                                if (i < 50) {
                                }
                            }
                            try {
                                this.mFQ++;
                                i = a;
                            } catch (Exception e32) {
                                e = e32;
                                ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                                this.mFU++;
                                i = a;
                                if (i < 50) {
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            a = i;
                            ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                            this.mFU++;
                            i = a;
                            if (i < 50) {
                            }
                        }
                        if (i < 50) {
                            a.this.mFv.commit();
                            a.this.mFv.beginTransaction();
                            i = 0;
                        }
                    }
                }
            }
            i3.close();
            a.this.mFv.commit();
            Ng("buildChatroomContact");
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(136667);
                throw interruptedException;
            }
            this.mFS = this.mFM.size();
            Iterator it2 = this.mFM.iterator();
            while (it2.hasNext()) {
                str = (String) it2.next();
                a.this.mFv.b(com.tencent.mm.plugin.fts.a.c.mCk, str);
                ((PluginFTS) com.tencent.mm.kernel.g.M(PluginFTS.class)).getTopHitsLogic().d(com.tencent.mm.plugin.fts.a.c.mCk, str);
            }
            this.mFM.clear();
            this.mFN.clear();
            Ng("deleteUnusedContact");
            ((PluginFTS) com.tencent.mm.kernel.g.M(PluginFTS.class)).setFTSIndexReady(true);
            AppMethodBeat.o(136667);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136668);
            String format = String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, failContact: %d, failChatroom}", new Object[]{Integer.valueOf(this.mFX), Integer.valueOf(this.mFR), Integer.valueOf(this.mFQ), Integer.valueOf(this.mFS), Integer.valueOf(this.mFV), Integer.valueOf(this.mFW), Integer.valueOf(this.mFT), Integer.valueOf(this.mFU)});
            AppMethodBeat.o(136668);
            return format;
        }

        public final String getName() {
            return "BuildContactIndexTask";
        }

        public final int getId() {
            return 1;
        }
    }

    class i extends com.tencent.mm.plugin.fts.a.a.a {
        private boolean mGf;
        private String username;

        public i(String str) {
            this.username = str;
        }

        public final boolean execute() {
            AppMethodBeat.i(136680);
            if (a.this.mFx.containsKey(this.username)) {
                this.mGf = true;
                AppMethodBeat.o(136680);
            } else if (a.this.mFw.add(this.username)) {
                ad MU = a.this.mgD.MU(this.username);
                if (MU == null || a.this.H(MU)) {
                    com.tencent.mm.plugin.fts.c.a a = a.this.mFv;
                    String str = this.username;
                    a.mBZ.bindLong(1, 2);
                    a.mBZ.bindString(2, str);
                    a.mBZ.bindLong(3, 0);
                    a.mBZ.execute();
                    AppMethodBeat.o(136680);
                } else {
                    this.mGf = true;
                    AppMethodBeat.o(136680);
                }
            } else {
                this.mGf = true;
                AppMethodBeat.o(136680);
            }
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136681);
            String format = String.format("{username: %s isSkipped: %b}", new Object[]{this.username, Boolean.valueOf(this.mGf)});
            AppMethodBeat.o(136681);
            return format;
        }

        public final String getName() {
            return "MarkContactTimestampTask";
        }
    }

    class k extends com.tencent.mm.plugin.fts.a.a.h {
        public k(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136683);
            super.a(jVar);
            com.tencent.mm.plugin.fts.c.a a = a.this.mFv;
            String str = this.mEl.query;
            String format = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[]{a.bAf()});
            Cursor rawQuery = a.mBT.rawQuery(format, new String[]{str});
            jVar.mEy = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
                lVar.mDx = rawQuery.getString(0);
                jVar.mEy.add(lVar);
            }
            rawQuery.close();
            jVar.bFZ = 0;
            AppMethodBeat.o(136683);
        }

        public final String getName() {
            return "SearchChatroomByMemberTask";
        }
    }

    public class p extends com.tencent.mm.plugin.fts.a.a.h {
        public p(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchContactSmallerTimestampTask";
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136688);
            long longValue = Long.valueOf(this.mEl.query).longValue();
            Cursor rawQuery = r2.mBT.rawQuery(String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[]{a.this.mFv.bAf(), Long.valueOf(longValue), Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)}), null);
            jVar.mEy = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
                lVar.mDx = rawQuery.getString(0);
                jVar.mEy.add(lVar);
            }
            rawQuery.close();
            AppMethodBeat.o(136688);
        }
    }

    class q extends com.tencent.mm.plugin.fts.a.a.h {
        public q(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchContactTask";
        }

        public final int getId() {
            return 20;
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136689);
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.aO(this.mEl.query, true);
            com.tencent.mm.plugin.fts.c.a a = a.this.mFv;
            com.tencent.mm.plugin.fts.a.a.g gVar = jVar.mDz;
            int[] iArr = this.mEl.mEr;
            String bAl = gVar.bAl();
            String str = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + com.tencent.mm.plugin.fts.a.d.t(iArr);
            long size = (long) gVar.mEc.size();
            Cursor rawQuery = a.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str + " AND status >= 0 ORDER BY subtype;", new Object[]{a.bAf(), a.bAg(), Long.valueOf(size), a.bAf(), a.bAg(), a.bAf(), a.bAg(), a.bAg(), bAl}), null);
            ArrayList<com.tencent.mm.plugin.fts.a.a.m> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mEl.mEu);
            int i = 0;
            while (rawQuery.moveToNext()) {
                if (hashSet.add(rawQuery.getString(3))) {
                    com.tencent.mm.plugin.fts.a.a.m k = new com.tencent.mm.plugin.fts.a.a.m().k(rawQuery);
                    if (i < k.mDw) {
                        if (arrayList.size() > this.mEl.mEt) {
                            break;
                        }
                        i = k.mDw;
                        arrayList.add(k);
                    } else {
                        arrayList.add(k);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        InterruptedException interruptedException = new InterruptedException("Task is Cancel: " + this.mEl.query);
                        AppMethodBeat.o(136689);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            jVar.mEy = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.m mVar : arrayList) {
                mVar.bAo();
                mVar.a(jVar.mDz);
                jVar.mEy.add(mVar);
            }
            if (this.mEl.mEv != null) {
                Collections.sort(jVar.mEy, this.mEl.mEv);
            }
            AppMethodBeat.o(136689);
        }
    }

    class r extends com.tencent.mm.plugin.fts.a.a.h {
        public r(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            InterruptedException interruptedException;
            AppMethodBeat.i(136690);
            Ng("start");
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.aO(this.mEl.query, true);
            com.tencent.mm.plugin.fts.c.a a = a.this.mFv;
            com.tencent.mm.plugin.fts.a.a.g gVar = jVar.mDz;
            String bAl = gVar.bAl();
            long currentTimeMillis = System.currentTimeMillis() - 1209600000;
            long size = (long) gVar.mEc.size();
            bAl = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[]{a.bAf(), a.bAg(), Long.valueOf(size), a.bAg(), Long.valueOf(currentTimeMillis), Long.valueOf(size), a.bAf(), a.bAg(), a.bAf(), a.bAg(), a.bAg(), bAl});
            Cursor rawQuery = a.mBT.rawQuery(bAl, new String[]{gVar.mDZ});
            ArrayList<com.tencent.mm.plugin.fts.a.a.m> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mEl.mEu);
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m j = new com.tencent.mm.plugin.fts.a.a.m().j(rawQuery);
                if (hashSet.add(j.mDx)) {
                    if (arrayList.size() > this.mEl.mEt) {
                        break;
                    }
                    arrayList.add(j);
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        interruptedException = new InterruptedException("Task is Cancel: " + this.mEl.query);
                        AppMethodBeat.o(136690);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(136690);
                throw interruptedException;
            }
            Ng("orm");
            jVar.mEy = new ArrayList(arrayList.size());
            for (com.tencent.mm.plugin.fts.a.a.m mVar : arrayList) {
                mVar.bAo();
                mVar.a(jVar.mDz);
                jVar.mEy.add(mVar);
            }
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(136690);
                throw interruptedException;
            }
            if (this.mEl.mEv != null) {
                Collections.sort(jVar.mEy, this.mEl.mEv);
            }
            Ng("calOffsets");
            if (jVar.mDz.mEc.size() > 1 && a.this.mFv.b(jVar.mDz)) {
                com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
                lVar.mDx = "create_chatroom​";
                if (jVar.mEy.size() > 3) {
                    jVar.mEy.add(3, lVar);
                } else {
                    jVar.mEy.add(lVar);
                }
            }
            Ng("checkChatroom");
            AppMethodBeat.o(136690);
        }

        public final String getName() {
            return "SearchTopChatroomInnerRankTask";
        }

        public final int getId() {
            return 25;
        }
    }

    class t extends com.tencent.mm.plugin.fts.a.a.h {
        public t(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchTopContactTask";
        }

        public final int getId() {
            return 22;
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            int i = 0;
            AppMethodBeat.i(136692);
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.aO(this.mEl.query, true);
            com.tencent.mm.plugin.fts.c.a a = a.this.mFv;
            com.tencent.mm.plugin.fts.a.a.g gVar = jVar.mDz;
            String bAl = gVar.bAl();
            long size = (long) gVar.mEc.size();
            long currentTimeMillis = System.currentTimeMillis() - 1105032704;
            Cursor rawQuery = a.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[]{a.bAf(), a.bAg(), Long.valueOf(size), Long.valueOf(currentTimeMillis), a.bAf(), a.bAg(), a.bAf(), a.bAg(), a.bAg(), bAl}), null);
            ArrayList<com.tencent.mm.plugin.fts.a.a.m> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mEl.mEu);
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m k = new com.tencent.mm.plugin.fts.a.a.m().k(rawQuery);
                if (hashSet.add(k.mDx)) {
                    if (i < k.mDw) {
                        if (arrayList.size() > this.mEl.mEt) {
                            break;
                        }
                        i = k.mDw;
                        arrayList.add(k);
                    } else {
                        arrayList.add(k);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        InterruptedException interruptedException = new InterruptedException("Task is Cancel: " + this.mEl.query);
                        AppMethodBeat.o(136692);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            jVar.mEy = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.m mVar : arrayList) {
                mVar.bAo();
                mVar.a(jVar.mDz);
                jVar.mEy.add(mVar);
            }
            if (this.mEl.mEv != null) {
                Collections.sort(jVar.mEy, this.mEl.mEv);
            }
            AppMethodBeat.o(136692);
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int mgK;
        private int mgL;

        private a() {
            this.mgK = 0;
            this.mgL = 0;
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136663);
            ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
            HashSet hashSet = new HashSet();
            Cursor rawQuery = a.this.mFv.mBT.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
            while (rawQuery.moveToNext()) {
                hashSet.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Cursor i = a.this.mgD.i("SELECT chatroomname, memberlist FROM chatroom;", null);
            int i2 = 5;
            while (i.moveToNext()) {
                if (Thread.interrupted()) {
                    i.close();
                    a.this.mFv.commit();
                    InterruptedException interruptedException = new InterruptedException();
                    AppMethodBeat.o(136663);
                    throw interruptedException;
                }
                String string = i.getString(0);
                String[] split = com.tencent.mm.plugin.fts.a.c.a.mCy.split(i.getString(1));
                a.this.mFy.put(string, split);
                if (!hashSet.remove(string)) {
                    if (i2 >= 5) {
                        a.this.mFv.commit();
                        a.this.mFv.beginTransaction();
                        i2 = 0;
                    }
                    a.this.mFv.k(string, split);
                    i2++;
                    this.mgK++;
                }
            }
            i.close();
            a.this.mFv.commit();
            Iterator it = hashSet.iterator();
            int i3 = 5;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (i3 >= 5) {
                    a.this.mFv.commit();
                    a.this.mFv.beginTransaction();
                    i3 = 0;
                }
                a.this.mFv.Nq(str);
                i2 = i3 + 1;
                this.mgL++;
                i3 = i2;
            }
            a.this.mFv.commit();
            AppMethodBeat.o(136663);
            return true;
        }

        public final String getName() {
            return "BuildChatroomIndexTask";
        }

        public final String aAo() {
            AppMethodBeat.i(136664);
            String format = String.format("{new: %d removed: %d}", new Object[]{Integer.valueOf(this.mgK), Integer.valueOf(this.mgL)});
            AppMethodBeat.o(136664);
            return format;
        }

        public final int getId() {
            return 3;
        }
    }

    class h extends com.tencent.mm.plugin.fts.a.a.a {
        private boolean eBp = false;
        private String edV;
        private boolean mGe = false;

        public h(String str) {
            this.edV = str;
        }

        public final boolean execute() {
            AppMethodBeat.i(136678);
            ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", this.edV);
            if (a.this.mFx.containsKey(this.edV)) {
                this.mGe = true;
                AppMethodBeat.o(136678);
            } else {
                a.this.mFv.MY(this.edV);
                List c = a.this.mFv.c(com.tencent.mm.plugin.fts.a.c.mCk, this.edV);
                a.this.mFx.put(this.edV, c);
                if (c.isEmpty()) {
                    this.eBp = true;
                    a.this.eAX.a(65556, new e(this.edV));
                    AppMethodBeat.o(136678);
                } else {
                    Cursor Np = a.this.mFv.Np(this.edV);
                    HashSet hashSet = new HashSet();
                    while (Np.moveToNext()) {
                        hashSet.add(Np.getString(0));
                    }
                    Np.close();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        a.this.mFv.MY(str);
                        if (!a.this.mFx.containsKey(str)) {
                            a.this.mFx.put(str, a.this.mFv.c(com.tencent.mm.plugin.fts.a.c.mCk, str));
                        }
                    }
                    a.this.mFw.remove(this.edV);
                    ((PluginFTS) com.tencent.mm.kernel.g.M(PluginFTS.class)).getTopHitsLogic().Nn(this.edV);
                    AppMethodBeat.o(136678);
                }
            }
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136679);
            String format = String.format("{username: %s cached: %b isSkipped: %b}", new Object[]{this.edV, Boolean.valueOf(this.mGe), Boolean.valueOf(this.eBp)});
            AppMethodBeat.o(136679);
            return format;
        }

        public final String getName() {
            return "MarkContactDirtyTask";
        }

        public final int getId() {
            return 17;
        }
    }

    class j extends com.tencent.mm.plugin.fts.a.a.h {
        public j(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchContactLogic.SearchTask";
        }

        public final int getId() {
            return 11;
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            InterruptedException interruptedException;
            AppMethodBeat.i(136682);
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.aO(this.mEl.query, true);
            Cursor a = a.this.mFv.a(jVar.mDz, this.mEl.mEr, this.mEl.mEs, true, true);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m k = new com.tencent.mm.plugin.fts.a.a.m().k(a);
                if (!this.mEl.mEu.contains(k.mDx)) {
                    com.tencent.mm.plugin.fts.a.a.l lVar;
                    if (com.tencent.mm.plugin.fts.a.d.h(com.tencent.mm.plugin.fts.a.c.mCk, k.type)) {
                        lVar = (com.tencent.mm.plugin.fts.a.a.l) hashMap.get(k.mDx);
                        if (lVar == null || com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.mCv, k.mDw, lVar.mDw) < 0) {
                            hashMap.put(k.mDx, k);
                        }
                    } else if (com.tencent.mm.plugin.fts.a.d.h(com.tencent.mm.plugin.fts.a.c.mCm, k.type)) {
                        lVar = (com.tencent.mm.plugin.fts.a.a.l) hashMap2.get(Long.valueOf(k.mEB));
                        if (lVar == null || com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.mCv, k.mDw, lVar.mDw) < 0) {
                            hashMap2.put(Long.valueOf(k.mEB), k);
                        }
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        interruptedException = new InterruptedException();
                        AppMethodBeat.o(136682);
                        throw interruptedException;
                    }
                }
            }
            a.close();
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(136682);
                throw interruptedException;
            }
            jVar.mEy = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.m mVar : hashMap.values()) {
                mVar.bAo();
                mVar.a(jVar.mDz);
                jVar.mEy.add(mVar);
            }
            jVar.mEy.addAll(hashMap2.values());
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(136682);
                throw interruptedException;
            }
            if (this.mEl.mEv != null) {
                Collections.sort(jVar.mEy, this.mEl.mEv);
            }
            AppMethodBeat.o(136682);
        }
    }

    class s extends com.tencent.mm.plugin.fts.a.a.h {
        public s(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchTopContactInnerRankTask";
        }

        public final int getId() {
            return 26;
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136691);
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.aO(this.mEl.query, true);
            com.tencent.mm.plugin.fts.c.a a = a.this.mFv;
            com.tencent.mm.plugin.fts.a.a.g gVar = jVar.mDz;
            int[] iArr = this.mEl.mEr;
            String bAl = gVar.bAl();
            long currentTimeMillis = System.currentTimeMillis() - 1105032704;
            long size = (long) gVar.mEc.size();
            String format = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + com.tencent.mm.plugin.fts.a.d.t(iArr) + " ORDER BY Rank ;", new Object[]{a.bAf(), a.bAg(), Long.valueOf(size), a.bAg(), Long.valueOf(currentTimeMillis), Long.valueOf(size), a.bAf(), a.bAg(), a.bAf(), a.bAg(), a.bAg(), bAl});
            Cursor rawQuery = a.mBT.rawQuery(format, new String[]{gVar.mDZ});
            ArrayList<com.tencent.mm.plugin.fts.a.a.m> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mEl.mEu);
            long j = 0;
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m j2 = new com.tencent.mm.plugin.fts.a.a.m().j(rawQuery);
                if (hashSet.add(j2.mDx)) {
                    if (j < j2.mEJ) {
                        if (arrayList.size() > this.mEl.mEt) {
                            break;
                        }
                        j = j2.mEJ;
                        arrayList.add(j2);
                    } else {
                        arrayList.add(j2);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        InterruptedException interruptedException = new InterruptedException("Task is Cancel: " + this.mEl.query);
                        AppMethodBeat.o(136691);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            jVar.mEy = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.m mVar : arrayList) {
                mVar.bAo();
                mVar.a(jVar.mDz);
                jVar.mEy.add(mVar);
            }
            if (this.mEl.mEv != null) {
                Collections.sort(jVar.mEy, this.mEl.mEv);
            }
            AppMethodBeat.o(136691);
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private String edV;
        private int mFZ = 0;

        public d(String str) {
            this.edV = str;
        }

        public final boolean execute() {
            AppMethodBeat.i(136670);
            ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", this.edV);
            a.this.mFv.b(com.tencent.mm.plugin.fts.a.c.mCk, this.edV);
            ((PluginFTS) com.tencent.mm.kernel.g.M(PluginFTS.class)).getTopHitsLogic().d(com.tencent.mm.plugin.fts.a.c.mCk, this.edV);
            Cursor Np = a.this.mFv.Np(this.edV);
            HashSet hashSet = new HashSet();
            while (Np.moveToNext()) {
                hashSet.add(Np.getString(0));
            }
            Np.close();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!a.this.mFx.containsKey(str)) {
                    a.this.mFx.put(str, a.this.mFv.c(com.tencent.mm.plugin.fts.a.c.mCk, str));
                    ((PluginFTS) com.tencent.mm.kernel.g.M(PluginFTS.class)).getTopHitsLogic().Nn(str);
                    this.mFZ++;
                }
            }
            AppMethodBeat.o(136670);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136671);
            String format = String.format("{username: %s mDirtyCount: %d}", new Object[]{this.edV, Integer.valueOf(this.mFZ)});
            AppMethodBeat.o(136671);
            return format;
        }

        public final String getName() {
            return "DeleteContactTask";
        }
    }

    class f extends com.tencent.mm.plugin.fts.a.a.a {
        private int mGa;
        private int mGb;

        private f() {
            this.mGa = 0;
            this.mGb = 0;
        }

        /* synthetic */ f(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136674);
            Cursor rawQuery = a.this.mFv.mBT.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                long j = rawQuery.getLong(1);
                List list = (List) a.this.mFz.get(string);
                if (list == null) {
                    list = new ArrayList(16);
                    a.this.mFz.put(string, list);
                    this.mGa++;
                }
                list.add(Long.valueOf(j));
                this.mGb++;
            }
            rawQuery.close();
            AppMethodBeat.o(136674);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136675);
            String format = String.format("{users: %d labels: %d}", new Object[]{Integer.valueOf(this.mGa), Integer.valueOf(this.mGb)});
            AppMethodBeat.o(136675);
            return format;
        }

        public final String getName() {
            return "LoadLabelCacheTask";
        }
    }

    class g extends com.tencent.mm.plugin.fts.a.a.a {
        private int[] mGc;
        private int mGd = 0;
        private int moz = 0;

        public g(int[] iArr) {
            this.mGc = iArr;
        }

        public final boolean execute() {
            AppMethodBeat.i(136676);
            List<com.tencent.mm.plugin.fts.a.a.b> g = a.this.mFv.g(this.mGc, 1);
            this.moz = g.size();
            HashMap hashMap = new HashMap();
            for (com.tencent.mm.plugin.fts.a.a.b bVar : g) {
                String str = bVar.mDx;
                if (!a.this.mFx.containsKey(str)) {
                    List list = (List) hashMap.get(str);
                    if (list == null) {
                        list = new ArrayList(16);
                        hashMap.put(str, list);
                    }
                    list.add(Long.valueOf(bVar.mDv));
                }
            }
            a.this.mFx.putAll(hashMap);
            this.mGd = hashMap.size();
            AppMethodBeat.o(136676);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136677);
            String format = String.format("{touched: %d users: %d}", new Object[]{Integer.valueOf(this.moz), Integer.valueOf(this.mGd)});
            AppMethodBeat.o(136677);
            return format;
        }

        public final String getName() {
            return "MarkAllContactDirtyTask";
        }
    }

    class m extends com.tencent.mm.plugin.fts.a.a.h {
        public m(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136685);
            super.a(jVar);
            com.tencent.mm.plugin.fts.c.a a = a.this.mFv;
            String str = this.mEl.mEp;
            String bAl = jVar.mDz.bAl();
            Cursor rawQuery = a.mBT.rawQuery(String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[]{a.bAg(), a.bAf(), a.bAg(), a.bAg(), bAl}), new String[]{str});
            HashSet hashSet = new HashSet();
            jVar.mEy = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
                lVar.mDx = rawQuery.getString(0);
                if (hashSet.add(lVar.mDx)) {
                    jVar.mEy.add(lVar);
                }
            }
            rawQuery.close();
            jVar.bFZ = 0;
            AppMethodBeat.o(136685);
        }

        public final String getName() {
            return "SearchChatroomInMemberTask";
        }
    }

    class n extends com.tencent.mm.plugin.fts.a.a.h {
        public n(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchChatroomTask";
        }

        public final int getId() {
            return 19;
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            com.tencent.mm.plugin.fts.a.a.l lVar;
            InterruptedException interruptedException;
            AppMethodBeat.i(136686);
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.aO(this.mEl.query, true);
            Cursor a = a.this.mFv.a(jVar.mDz, new int[]{131075}, null, true, true);
            HashMap hashMap = new HashMap();
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m k = new com.tencent.mm.plugin.fts.a.a.m().k(a);
                if (!this.mEl.mEu.contains(k.mDx)) {
                    lVar = (com.tencent.mm.plugin.fts.a.a.l) hashMap.get(k.mDx);
                    if (lVar == null || com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.mCv, k.mDw, lVar.mDw) < 0) {
                        hashMap.put(k.mDx, k);
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        interruptedException = new InterruptedException();
                        AppMethodBeat.o(136686);
                        throw interruptedException;
                    }
                }
            }
            a.close();
            ArrayList arrayList = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.m mVar : hashMap.values()) {
                mVar.bAo();
                mVar.a(jVar.mDz);
                arrayList.add(mVar);
                if (Thread.interrupted()) {
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(136686);
                    throw interruptedException;
                }
            }
            if (this.mEl.mEv != null) {
                Collections.sort(arrayList, this.mEl.mEv);
            }
            jVar.mEy = new ArrayList(hashMap.size());
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < arrayList.size(); i++) {
                lVar = (com.tencent.mm.plugin.fts.a.a.l) arrayList.get(i);
                stringBuffer.append(lVar.mDW);
                stringBuffer.append("|");
                stringBuffer.append(lVar.timestamp);
                stringBuffer.append(" ");
                jVar.mEy.add(lVar);
                if (i >= this.mEl.mEt) {
                    break;
                }
            }
            if (jVar.mDz.mEc.size() > 1 && a.this.mFv.b(jVar.mDz)) {
                lVar = new com.tencent.mm.plugin.fts.a.a.l();
                lVar.mDx = "create_chatroom​";
                jVar.mEy.add(0, lVar);
                stringBuffer.append(" needCreateChatroom");
            }
            ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", stringBuffer.toString());
            AppMethodBeat.o(136686);
        }
    }

    public class o extends com.tencent.mm.plugin.fts.a.a.h {
        public o(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final String getName() {
            return "SearchCommonChatroomTask";
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136687);
            ArrayList P = bo.P(this.mEl.query.split(","));
            com.tencent.mm.plugin.fts.c.a a = a.this.mFv;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("member IN (");
            for (int i = 0; i < P.size(); i++) {
                stringBuffer.append("'");
                stringBuffer.append((String) P.get(i));
                stringBuffer.append("'");
                if (i != P.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append(")");
            Cursor rawQuery = a.mBT.rawQuery(String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[]{a.bAf(), stringBuffer.toString()}), null);
            HashMap hashMap = new HashMap();
            while (rawQuery.moveToNext()) {
                List list;
                String string = rawQuery.getString(0);
                if (hashMap.containsKey(string)) {
                    list = (List) hashMap.get(string);
                } else {
                    list = new ArrayList();
                }
                com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
                lVar.mDx = rawQuery.getString(1);
                lVar.mEB = rawQuery.getLong(2);
                list.add(lVar);
                hashMap.put(string, list);
            }
            rawQuery.close();
            jVar.mEy = new ArrayList();
            com.tencent.mm.plugin.fts.a.a.l lVar2 = new com.tencent.mm.plugin.fts.a.a.l();
            lVar2.userData = hashMap;
            jVar.mEy.add(lVar2);
            AppMethodBeat.o(136687);
        }
    }

    class u extends com.tencent.mm.plugin.fts.a.a.a {
        private int mGg;
        private int mGh;
        private int mGi;

        private u() {
            this.mGg = 0;
            this.mGh = 0;
            this.mGi = 0;
        }

        /* synthetic */ u(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            InterruptedException interruptedException;
            String str;
            int i;
            AppMethodBeat.i(136693);
            Ng("start");
            Iterator it = a.this.mFx.entrySet().iterator();
            int i2 = 50;
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    a.this.mFv.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(136693);
                    throw interruptedException;
                }
                int i3;
                if (i2 >= 50) {
                    a.this.mFv.commit();
                    a.this.mFv.beginTransaction();
                    i3 = 0;
                } else {
                    i3 = i2;
                }
                Entry entry = (Entry) it.next();
                for (Long longValue : (List) entry.getValue()) {
                    a.this.mFv.g(Long.valueOf(longValue.longValue()));
                    i3++;
                }
                str = (String) entry.getKey();
                ad MU = a.this.mgD.MU(str);
                if (MU != null && MU.field_username.length() > 0 && a.this.H(MU)) {
                    i3 += a.this.I(MU);
                }
                i = i3;
                it.remove();
                a.this.mFw.remove(str);
                this.mGg++;
                i2 = i;
            }
            Ng("dirtyContact");
            Iterator it2 = a.this.mFw.iterator();
            while (it2.hasNext()) {
                if (Thread.interrupted()) {
                    a.this.mFv.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(136693);
                    throw interruptedException;
                }
                if (i2 >= 50) {
                    a.this.mFv.commit();
                    a.this.mFv.beginTransaction();
                    i = 0;
                } else {
                    i = i2;
                }
                str = (String) it2.next();
                long MW = a.this.mgD.MW(str);
                ad MU2 = a.this.mgD.MU(str);
                if (MU2 == null || MU2.field_username.length() <= 0 || !a.this.H(MU2)) {
                    i2 = i;
                } else {
                    a.this.mFv.G(str, MW);
                    i2 = i + 1;
                }
                it2.remove();
                this.mGh++;
            }
            a.this.mFv.commit();
            Ng("timestampContact");
            e topHitsLogic = ((PluginFTS) com.tencent.mm.kernel.g.M(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.mGP.clear();
            this.mGi = topHitsLogic.mGO.bAJ();
            Ng("topHits");
            AppMethodBeat.o(136693);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136694);
            String format = String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[]{Integer.valueOf(this.mGg), Integer.valueOf(this.mGh), Integer.valueOf(this.mGi)});
            AppMethodBeat.o(136694);
            return format;
        }

        public final String getName() {
            return "UpdateDirtyAndTimestampContactTask";
        }

        public final int getId() {
            return 16;
        }
    }

    class v extends com.tencent.mm.plugin.fts.a.a.a {
        private long mGj;
        private int mGk = 0;

        public v(long j) {
            this.mGj = j;
        }

        public final boolean execute() {
            AppMethodBeat.i(136695);
            ArrayList arrayList = new ArrayList(32);
            com.tencent.mm.plugin.fts.c.a a = a.this.mFv;
            long j = this.mGj;
            Cursor rawQuery = a.mBT.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[]{Long.toString(j)});
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!a.this.mFx.containsKey(str)) {
                    a.this.mFx.put(str, a.this.mFv.c(com.tencent.mm.plugin.fts.a.c.mCl, str));
                }
            }
            AppMethodBeat.o(136695);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136696);
            String format = String.format("{mLabelId: %d mContactCount: %d}", new Object[]{Long.valueOf(this.mGj), Integer.valueOf(this.mGk)});
            AppMethodBeat.o(136696);
            return format;
        }

        public final String getName() {
            return "UpdateLabelTask";
        }
    }

    class c extends com.tencent.mm.plugin.fts.a.a.a {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(136669);
            a.this.mFv.s(com.tencent.mm.plugin.fts.a.c.mCi);
            AppMethodBeat.o(136669);
            return true;
        }

        public final String getName() {
            return "DeleteAllFriendTask";
        }
    }

    class e extends com.tencent.mm.plugin.fts.a.a.a {
        private boolean eBp = false;
        private String edV;

        public e(String str) {
            this.edV = str;
        }

        public final boolean execute() {
            AppMethodBeat.i(136672);
            ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", this.edV);
            ad MU = a.this.mgD.MU(this.edV);
            if (MU == null || MU.field_username.length() <= 0 || !a.this.H(MU)) {
                this.eBp = true;
            } else {
                a.this.I(MU);
            }
            a.this.mFx.remove(this.edV);
            a.this.mFw.remove(this.edV);
            AppMethodBeat.o(136672);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136673);
            String format = String.format("{username: %s isSkipped: %b}", new Object[]{this.edV, Boolean.valueOf(this.eBp)});
            AppMethodBeat.o(136673);
            return format;
        }

        public final String getName() {
            return "InsertContactTask";
        }
    }

    class l extends com.tencent.mm.plugin.fts.a.a.h {
        public l(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            int i = 0;
            AppMethodBeat.i(136684);
            super.a(jVar);
            com.tencent.mm.plugin.fts.c.a a = a.this.mFv;
            String str = this.mEl.query;
            String format = String.format("SELECT count(aux_index) FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075", new Object[]{a.bAf()});
            Cursor rawQuery = a.mBT.rawQuery(format, new String[]{str});
            if (rawQuery.moveToNext()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
            com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
            lVar.userData = Integer.valueOf(i);
            jVar.mEy = new ArrayList();
            jVar.mEy.add(lVar);
            AppMethodBeat.o(136684);
        }

        public final String getName() {
            return "SearchChatroomCountTask";
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.i iVar) {
        com.tencent.mm.plugin.fts.a.a.a lVar;
        AppMethodBeat.i(136697);
        switch (iVar.hbo) {
            case 5:
                lVar = new l(iVar);
                break;
            case 6:
                lVar = new k(iVar);
                break;
            case 7:
                lVar = new m(iVar);
                break;
            case 8:
                lVar = new o(iVar);
                break;
            case 9:
                lVar = new p(iVar);
                break;
            case 16:
                lVar = new q(iVar);
                break;
            case 32:
                lVar = new n(iVar);
                break;
            case 48:
                lVar = new t(iVar);
                break;
            case 64:
                lVar = new s(iVar);
                break;
            case 96:
                lVar = new r(iVar);
                break;
            default:
                lVar = new j(iVar);
                break;
        }
        lVar = this.eAX.a(-65536, lVar);
        AppMethodBeat.o(136697);
        return lVar;
    }

    public final boolean onCreate() {
        AppMethodBeat.i(136698);
        if (((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady()) {
            ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
            this.mFv = (com.tencent.mm.plugin.fts.c.a) ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3);
            this.eAX = ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
            this.mgD = ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
            this.mFw = new HashSet();
            this.mFx = new HashMap();
            this.mFy = new HashMap();
            this.mFz = new HashMap();
            try {
                this.mFA = com.tencent.mm.g.c.ap.class.getDeclaredMethod("Hw", new Class[0]);
                this.mFA.setAccessible(true);
                this.eAX.a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, new f(this, (byte) 0));
                this.eAX.a(131082, new a(this, (byte) 0));
                this.eAX.a(131092, new b(this, (byte) 0));
                this.eAX.a(BaseClientBuilder.API_PRIORITY_OTHER, new c(this, (byte) 0));
                ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().c(this.mFD);
                ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().a(this.mFC);
                ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().a(this.mFB);
                com.tencent.mm.sdk.e.k.a aVar = this.mFE;
                if (com.tencent.mm.av.b.fHH != null) {
                    com.tencent.mm.av.b.fHH.a(aVar);
                }
                this.mFH.ae(600000, 600000);
                this.mFF.dnU();
                this.mFG.dnU();
                AppMethodBeat.o(136698);
                return true;
            } catch (NoSuchMethodException e) {
                AssertionFailedError assertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
                assertionFailedError.initCause(e);
                AppMethodBeat.o(136698);
                throw assertionFailedError;
            }
        }
        ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
        AppMethodBeat.o(136698);
        return false;
    }

    public final boolean Pq() {
        AppMethodBeat.i(136699);
        this.mFF.dead();
        this.mFG.dead();
        this.mFI.stopTimer();
        this.mFH.stopTimer();
        ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().b(this.mFC);
        ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().d(this.mFD);
        ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().b(this.mFB);
        com.tencent.mm.sdk.e.k.a aVar = this.mFE;
        if (com.tencent.mm.av.b.fHH != null) {
            com.tencent.mm.av.b.fHH.b(aVar);
        }
        if (this.mFx != null) {
            this.mFx.clear();
        }
        if (this.mFw != null) {
            this.mFw.clear();
        }
        this.mFv = null;
        this.eAX = null;
        AppMethodBeat.o(136699);
        return true;
    }

    public final String getName() {
        return "FTS5SearchContactLogic";
    }

    /* Access modifiers changed, original: final */
    public final int a(String str, ad adVar, String[] strArr, byte[] bArr, HashMap<String, ad> hashMap) {
        AppMethodBeat.i(136700);
        int i = 0;
        String str2 = adVar.field_nickname;
        String aL = com.tencent.mm.plugin.fts.a.d.aL(str2, false);
        String aL2 = com.tencent.mm.plugin.fts.a.d.aL(str2, true);
        long j = 0;
        long MW = this.mgD.MW(str);
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            j = (long) strArr.length;
            HashMap hashMap2 = new HashMap();
            com.tencent.mm.j.a.a.a aVar = new com.tencent.mm.j.a.a.a();
            try {
                aVar.parseFrom(bArr);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "parse chatroom data", new Object[0]);
            }
            Iterator it = aVar.eow.iterator();
            while (it.hasNext()) {
                com.tencent.mm.j.a.a.b bVar = (com.tencent.mm.j.a.a.b) it.next();
                if (!bo.isNullOrNil(bVar.eoz)) {
                    hashMap2.put(bVar.userName, bVar.eoz);
                }
            }
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                String str3 = strArr[i3];
                ad adVar2 = (ad) hashMap.get(str3);
                if (adVar2 != null) {
                    String str4 = adVar2.field_conRemark;
                    String str5 = adVar2.field_nickname;
                    String aL3 = com.tencent.mm.plugin.fts.a.d.aL(str4, false);
                    String aL4 = com.tencent.mm.plugin.fts.a.d.aL(str4, true);
                    stringBuffer.append(bo.bc(str4, " ")).append("‌");
                    stringBuffer.append(bo.bc(aL3, " ")).append("‌");
                    stringBuffer.append(bo.bc(aL4, " ")).append("‌");
                    str4 = com.tencent.mm.plugin.fts.a.d.aL(str5, false);
                    aL3 = com.tencent.mm.plugin.fts.a.d.aL(str5, true);
                    stringBuffer.append(bo.bc(str5, " ")).append("‌");
                    stringBuffer.append(bo.bc(str4, " ")).append("‌");
                    stringBuffer.append(bo.bc(aL3, " ")).append("‌");
                    stringBuffer.append(bo.bc((String) hashMap2.get(str3), " ")).append("‌");
                    F(adVar2);
                    stringBuffer.append(bo.bc(adVar2.dul, " ")).append("‌");
                    stringBuffer.append(bo.bc(com.tencent.mm.plugin.fts.a.d.eu(str3, adVar2.Hq()), " ")).append("‌");
                    stringBuffer.append("​");
                }
                i2 = i3 + 1;
            }
        }
        if (!bo.isNullOrNil(str2)) {
            this.mFv.a(131075, 5, j, str, MW, str2);
            if (bo.isNullOrNil(aL)) {
                i = 1;
            } else {
                this.mFv.a(131075, 6, j, str, MW, aL);
                i = 2;
            }
            if (!bo.isNullOrNil(aL2)) {
                this.mFv.a(131075, 7, j, str, MW, aL2);
                i++;
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
            this.mFv.a(131075, 38, j, str, MW, stringBuffer.toString());
            i++;
        }
        AppMethodBeat.o(136700);
        return i;
    }

    public final int j(String str, String[] strArr) {
        int simpleQueryForLong;
        AppMethodBeat.i(136701);
        String[] strArr2 = (String[]) this.mFy.get(str);
        this.mFv.beginTransaction();
        if (strArr2 == null) {
            this.mFv.Nq(str);
            simpleQueryForLong = ((int) this.mFv.mHg.simpleQueryForLong()) + 0;
            if (strArr != null) {
                this.mFv.k(str, strArr);
                this.mFy.put(str, strArr);
                simpleQueryForLong += strArr.length;
            }
        } else if (strArr == null) {
            this.mFv.Nq(str);
            simpleQueryForLong = ((int) this.mFv.mHg.simpleQueryForLong()) + 0;
            this.mFy.remove(str);
        } else {
            HashSet hashSet = new HashSet(Arrays.asList(strArr2));
            int i = 0;
            for (Object obj : strArr) {
                if (!hashSet.remove(obj)) {
                    com.tencent.mm.plugin.fts.c.a aVar = this.mFv;
                    aVar.mHa.bindString(1, str);
                    aVar.mHa.bindString(2, obj);
                    aVar.mHa.execute();
                    i++;
                }
            }
            Iterator it = hashSet.iterator();
            while (true) {
                simpleQueryForLong = i;
                if (!it.hasNext()) {
                    break;
                }
                String str2 = (String) it.next();
                com.tencent.mm.plugin.fts.c.a aVar2 = this.mFv;
                aVar2.mHb.bindString(1, str);
                aVar2.mHb.bindString(2, str2);
                aVar2.mHb.execute();
                i = simpleQueryForLong + 1;
            }
            this.mFy.put(str, strArr);
        }
        this.mFv.commit();
        AppMethodBeat.o(136701);
        return simpleQueryForLong;
    }

    public a() {
        AppMethodBeat.i(136702);
        AppMethodBeat.o(136702);
    }

    /* Access modifiers changed, original: final */
    public final void F(ad adVar) {
        AppMethodBeat.i(136703);
        try {
            this.mFA.invoke(adVar, new Object[0]);
            AppMethodBeat.o(136703);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Failed parsing RContact LVBuffer.", new Object[0]);
            AppMethodBeat.o(136703);
        }
    }

    static boolean Nk(String str) {
        AppMethodBeat.i(136704);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(136704);
            return false;
        } else if (str.endsWith("@stranger")) {
            AppMethodBeat.o(136704);
            return false;
        } else if (str.endsWith("@qqim")) {
            AppMethodBeat.o(136704);
            return false;
        } else if (str.endsWith("@app")) {
            AppMethodBeat.o(136704);
            return false;
        } else if (str.startsWith("fake_")) {
            AppMethodBeat.o(136704);
            return false;
        } else {
            AppMethodBeat.o(136704);
            return true;
        }
    }

    static boolean G(ad adVar) {
        AppMethodBeat.i(136705);
        if (adVar.isHidden() && !"notifymessage".equals(adVar.field_username)) {
            AppMethodBeat.o(136705);
            return false;
        } else if (adVar.Oa()) {
            AppMethodBeat.o(136705);
            return false;
        } else if (adVar.field_deleteFlag != 0) {
            AppMethodBeat.o(136705);
            return false;
        } else {
            if (!com.tencent.mm.n.a.jh(adVar.field_type)) {
                if (adVar.NZ()) {
                    AppMethodBeat.o(136705);
                    return false;
                } else if (adVar.dsf()) {
                    AppMethodBeat.o(136705);
                    return false;
                }
            }
            AppMethodBeat.o(136705);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final int J(ad adVar) {
        long j;
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AppMethodBeat.i(136708);
        long j2 = adVar.ewQ;
        String str6 = adVar.field_username;
        String Hq = adVar.Hq();
        String str7 = adVar.field_nickname;
        String aL = com.tencent.mm.plugin.fts.a.d.aL(str7, false);
        String aL2 = com.tencent.mm.plugin.fts.a.d.aL(str7, true);
        String str8 = adVar.field_conRemark;
        String aL3 = com.tencent.mm.plugin.fts.a.d.aL(str8, false);
        String aL4 = com.tencent.mm.plugin.fts.a.d.aL(str8, true);
        String str9 = adVar.dul;
        String str10 = adVar.field_contactLabelIds;
        String str11 = adVar.dur;
        int i3 = adVar.field_verifyFlag;
        String str12 = "";
        long currentTimeMillis = System.currentTimeMillis();
        if ((i3 & ad.dsh()) != 0) {
            str10 = bo.c(((com.tencent.mm.api.j) com.tencent.mm.kernel.g.K(com.tencent.mm.api.j.class)).cK(str6), "​");
            i3 = 0;
            j = currentTimeMillis;
            i = 131076;
        } else if (ad.aox(str6)) {
            i3 = 0;
            j = currentTimeMillis;
            str10 = str12;
            i = 131081;
        } else {
            currentTimeMillis = this.mgD.MW(str6);
            if (str10 == null || str10.length() <= 0) {
                i3 = 0;
                j = currentTimeMillis;
                str10 = str12;
                i = 131072;
            } else {
                i3 = a(j2, str6, str10, currentTimeMillis) + 0;
                j = currentTimeMillis;
                str10 = str12;
                i = 131072;
            }
        }
        String eu = com.tencent.mm.plugin.fts.a.d.eu(str6, Hq);
        if (eu == null || eu.length() == 0) {
            i2 = i3;
        } else {
            this.mFv.a(i, 15, j2, str6, j, eu);
            i2 = i3 + 1;
        }
        if (str8 == null || str8.length() == 0) {
            str = null;
            str2 = null;
            str3 = aL2;
            str4 = aL;
            eu = str7;
            str5 = null;
        } else {
            str3 = aL4;
            str4 = aL3;
            eu = str8;
            str2 = aL2;
            str = aL;
            str5 = str7;
        }
        if (!(eu == null || eu.length() == 0)) {
            if (eu.equalsIgnoreCase(str4)) {
                aL4 = null;
            } else {
                aL4 = str4;
            }
            if (aL4 == null || aL4.length() == 0 || aL4.equalsIgnoreCase(r2)) {
                str3 = null;
            }
            this.mFv.a(i, 1, j2, str6, j, eu);
            if (!(aL4 == null || aL4.length() == 0)) {
                this.mFv.a(i, 2, j2, str6, j, aL4);
            }
            if (!(str3 == null || str3.length() == 0)) {
                this.mFv.a(i, 3, j2, str6, j, str3);
            }
            i2 += 3;
        }
        if (str5 == null || str5.length() == 0) {
            i3 = i2;
        } else {
            if (str5.equalsIgnoreCase(str)) {
                str = null;
            }
            if (str == null || str.length() == 0 || str.equalsIgnoreCase(str2)) {
                str3 = null;
            } else {
                str3 = str2;
            }
            this.mFv.a(i, 5, j2, str6, j, str5);
            if (!(str == null || str.length() == 0)) {
                this.mFv.a(i, 6, j2, str6, j, str);
            }
            if (!(str3 == null || str3.length() == 0)) {
                this.mFv.a(i, 7, j2, str6, j, str3);
            }
            i3 = i2 + 3;
        }
        if (str9 != null && str9.length() > 0) {
            this.mFv.a(i, 4, j2, str6, j, str9);
            i3++;
        }
        if (i == 131072) {
            if (bo.isNullOrNil(str11)) {
                Cursor i4 = this.mgD.i("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[]{str6});
                if (i4.moveToFirst()) {
                    this.mFv.a(i, 16, j2, str6, j, i4.getString(0));
                    i3++;
                }
                i4.close();
            } else {
                this.mFv.a(i, 16, j2, str6, j, str11.replace(",", "​"));
                i3++;
            }
            eu = mL(adVar.getProvince());
            if (!(eu == null || eu.length() == 0)) {
                this.mFv.a(i, 18, j2, str6, j, eu);
                i3++;
            }
            eu = adVar.getCity();
            if (!(eu == null || eu.length() == 0)) {
                this.mFv.a(i, 17, j2, str6, j, eu);
                i3++;
            }
        }
        if (i == 131076 && !bo.isNullOrNil(str10)) {
            this.mFv.a(i, 19, j2, str6, j, str10);
            i3++;
            eu = com.tencent.mm.plugin.fts.a.d.aL(str10, false);
            if (!bo.isNullOrNil(eu)) {
                this.mFv.a(i, 20, j2, str6, j, eu);
                i3++;
            }
            eu = com.tencent.mm.plugin.fts.a.d.aL(str10, true);
            if (!bo.isNullOrNil(eu)) {
                this.mFv.a(i, 21, j2, str6, j, eu);
                i3++;
            }
        }
        if (i == 131081) {
            i3 += a(adVar, j);
        }
        AppMethodBeat.o(136708);
        return i3;
    }

    private void ev(String str, String str2) {
        AppMethodBeat.i(136710);
        String[] split = com.tencent.mm.plugin.fts.a.c.a.mCF.split(str2);
        List list;
        if (split.length != 0) {
            ArrayList arrayList = new ArrayList(split.length);
            for (String str3 : split) {
                arrayList.add(Long.valueOf(bo.getLong(str3, 0)));
            }
            list = arrayList;
        } else {
            list = null;
        }
        List list2 = (List) this.mFz.get(str);
        if (list2 == null) {
            this.mFv.No(str);
            if (!(list == null || list.isEmpty())) {
                this.mFv.k(str, (List) list);
                this.mFz.put(str, list);
                AppMethodBeat.o(136710);
                return;
            }
        } else if (list == null || list.isEmpty()) {
            this.mFv.No(str);
            this.mFz.remove(str);
            AppMethodBeat.o(136710);
            return;
        } else {
            long longValue;
            com.tencent.mm.plugin.fts.c.a aVar;
            HashSet hashSet = new HashSet(list2);
            for (Long longValue2 : list) {
                longValue = longValue2.longValue();
                if (!hashSet.remove(Long.valueOf(longValue))) {
                    aVar = this.mFv;
                    aVar.mHd.bindString(1, str);
                    aVar.mHd.bindLong(2, longValue);
                    aVar.mHd.execute();
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                longValue = ((Long) it.next()).longValue();
                aVar = this.mFv;
                aVar.mHe.bindString(1, str);
                aVar.mHe.bindLong(2, longValue);
                aVar.mHe.execute();
            }
            this.mFz.put(str, list);
        }
        AppMethodBeat.o(136710);
    }

    private int a(long j, String str, String str2, long j2) {
        AppMethodBeat.i(136711);
        if (str2 != null) {
            if (str2.endsWith("\u0000")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            if (str2.length() == 0) {
                AppMethodBeat.o(136711);
                return 0;
            }
            ev(str, str2);
            List MX = this.mgD.MX(str2);
            if (MX.size() == 0) {
                AppMethodBeat.o(136711);
                return 0;
            }
            this.mFv.a((int) WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 11, j, str, j2, bo.c(MX, "​"));
            AppMethodBeat.o(136711);
            return 1;
        }
        AppMethodBeat.o(136711);
        return 0;
    }

    static {
        AppMethodBeat.i(136713);
        String[] split = ah.getContext().getString(R.string.b3c).split(";");
        if (split != null) {
            for (Object add : split) {
                mFJ.add(add);
            }
        }
        AppMethodBeat.o(136713);
    }

    private static String mL(String str) {
        AppMethodBeat.i(136712);
        if (mFJ.contains(str)) {
            str = "";
            AppMethodBeat.o(136712);
            return str;
        }
        AppMethodBeat.o(136712);
        return str;
    }

    /* Access modifiers changed, original: final */
    public final boolean H(ad adVar) {
        AppMethodBeat.i(136706);
        String str = adVar.field_username;
        if (!G(adVar)) {
            AppMethodBeat.o(136706);
            return false;
        } else if (!Nk(str)) {
            AppMethodBeat.o(136706);
            return false;
        } else if (com.tencent.mm.n.a.jh(adVar.field_type)) {
            AppMethodBeat.o(136706);
            return true;
        } else if (adVar.NZ() || adVar.dsf()) {
            AppMethodBeat.o(136706);
            return false;
        } else if (this.mgD.MV(str)) {
            AppMethodBeat.o(136706);
            return true;
        } else {
            AppMethodBeat.o(136706);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final int I(ad adVar) {
        AppMethodBeat.i(136707);
        int a;
        if (com.tencent.mm.model.t.kH(adVar.field_username)) {
            String format = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[]{"chatroom"});
            Cursor i = this.mgD.i(format, new String[]{adVar.field_username});
            try {
                byte[] blob;
                if (i.moveToNext()) {
                    format = i.getString(0);
                    blob = i.getBlob(1);
                } else {
                    blob = null;
                    format = null;
                }
                if (i != null) {
                    i.close();
                }
                if (bo.isNullOrNil(format) || blob == null) {
                    ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", adVar.field_username);
                    if (j(adVar.field_username, null) > 0) {
                        ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", adVar.field_username, Integer.valueOf(j(adVar.field_username, null)));
                    }
                    AppMethodBeat.o(136707);
                    return 0;
                }
                String[] split = com.tencent.mm.plugin.fts.a.c.a.mCy.split(format);
                Arrays.sort(split, new Comparator<String>() {
                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        AppMethodBeat.i(136662);
                        int stringCompareUtfBinary = FTSJNIUtils.stringCompareUtfBinary((String) obj, (String) obj2);
                        AppMethodBeat.o(136662);
                        return stringCompareUtfBinary;
                    }
                });
                if (j(adVar.field_username, split) > 0) {
                    ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", adVar.field_username, Integer.valueOf(j(adVar.field_username, split)));
                }
                HashMap hashMap = new HashMap();
                Cursor i2 = this.mgD.i("SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + com.tencent.mm.plugin.fts.a.d.C(split) + ";", null);
                while (i2.moveToNext()) {
                    try {
                        ad adVar2 = new ad();
                        adVar2.ewQ = i2.getLong(0);
                        adVar2.setUsername(i2.getString(1));
                        adVar2.iy(i2.getString(2));
                        adVar2.iz(i2.getString(3));
                        adVar2.iB(i2.getString(4));
                        adVar2.H(i2.getBlob(5));
                        hashMap.put(adVar2.field_username, adVar2);
                    } catch (Throwable th) {
                        if (i2 != null) {
                            i2.close();
                        }
                        AppMethodBeat.o(136707);
                    }
                }
                if (i2 != null) {
                    i2.close();
                }
                a = a(adVar.field_username, adVar, split, blob, hashMap);
                AppMethodBeat.o(136707);
                return a;
            } catch (Throwable th2) {
                if (i != null) {
                    i.close();
                }
                AppMethodBeat.o(136707);
            }
        } else {
            a = J(adVar);
            AppMethodBeat.o(136707);
            return a;
        }
    }

    private int a(ad adVar, long j) {
        int i = 0;
        AppMethodBeat.i(136709);
        String str = adVar.duw;
        if (!bo.isNullOrNil(str)) {
            com.tencent.mm.openim.a.c cVar = new com.tencent.mm.openim.a.c();
            cVar.vj(str);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < cVar.geU.size(); i2++) {
                for (com.tencent.mm.openim.a.c.b vk : ((com.tencent.mm.openim.a.c.a) cVar.geU.get(i2)).geV) {
                    str = vk.vk(adVar.field_openImAppid);
                    if (!bo.isNullOrNil(str)) {
                        stringBuffer.append(str);
                        stringBuffer.append("‌");
                    }
                }
                stringBuffer.append("​");
            }
            if (!bo.isNullOrNil(stringBuffer.toString())) {
                this.mFv.a(131081, 51, adVar.ewQ, adVar.field_username, j, stringBuffer.toString());
                i = 1;
            }
        }
        AppMethodBeat.o(136709);
        return i;
    }
}
