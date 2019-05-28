package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.util.Pair;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;

public final class c extends com.tencent.mm.plugin.fts.a.b implements com.tencent.mm.plugin.messenger.foundation.a.a.h.a {
    m eAX;
    com.tencent.mm.plugin.fts.c.c mGp;
    boolean mGq = false;
    private com.tencent.mm.sdk.b.c mGr = new com.tencent.mm.sdk.b.c<pf>() {
        {
            AppMethodBeat.i(136733);
            this.xxI = pf.class.getName().hashCode();
            AppMethodBeat.o(136733);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136734);
            pf pfVar = (pf) bVar;
            if (pfVar instanceof pf) {
                c.this.eAX.a(65576, new b(pfVar.cLx.cvx));
            }
            AppMethodBeat.o(136734);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mGs = new com.tencent.mm.sdk.b.c<pe>() {
        {
            AppMethodBeat.i(136735);
            this.xxI = pe.class.getName().hashCode();
            AppMethodBeat.o(136735);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136736);
            pe peVar = (pe) bVar;
            if (peVar instanceof pe) {
                c.this.eAX.a(65576, new b(peVar.cLt.cvx));
            }
            AppMethodBeat.o(136736);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mGt = new com.tencent.mm.sdk.b.c<qo>() {
        {
            AppMethodBeat.i(136738);
            this.xxI = qo.class.getName().hashCode();
            AppMethodBeat.o(136738);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136739);
            c.this.eAX.a(65574, new com.tencent.mm.plugin.fts.a.a.a() {
                public final boolean execute() {
                    AppMethodBeat.i(136737);
                    c.this.mGp.K(-200, Long.MAX_VALUE);
                    AppMethodBeat.o(136737);
                    return true;
                }

                public final String toString() {
                    return "ResetMessageCreateTimeCursor";
                }
            });
            AppMethodBeat.o(136739);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c mGu = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d>() {
        {
            AppMethodBeat.i(136740);
            this.xxI = com.tencent.mm.g.a.d.class.getName().hashCode();
            AppMethodBeat.o(136740);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(136741);
            if (((com.tencent.mm.g.a.d) bVar).crQ.crR) {
                c.this.mGv.stopTimer();
            } else {
                c.this.mGv.ae(60000, 60000);
            }
            AppMethodBeat.o(136741);
            return false;
        }
    };
    ap mGv = new ap(com.tencent.mm.kernel.g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(136742);
            if (!c.this.mGq) {
                c.this.mGq = true;
                c.this.eAX.a(131112, new a(c.this, (byte) 0));
            }
            com.tencent.mm.sdk.b.a.xxA.d(c.this.mGu);
            AppMethodBeat.o(136742);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(136743);
            String str = super.toString() + "|mBackgroundTimer";
            AppMethodBeat.o(136743);
            return str;
        }
    }, false);
    com.tencent.mm.plugin.fts.a.a.g.a mGw = new com.tencent.mm.plugin.fts.a.a.g.a() {
        public final String[] split(String str) {
            AppMethodBeat.i(136744);
            String[] ej;
            if (((PluginFTS) com.tencent.mm.kernel.g.M(PluginFTS.class)).getFTSIndexDB().mBc) {
                ej = bo.ej(c.Nm(str));
                AppMethodBeat.o(136744);
                return ej;
            }
            ej = com.tencent.mm.plugin.fts.a.c.a.mCE.split(str);
            AppMethodBeat.o(136744);
            return ej;
        }

        public final String[] Nh(String str) {
            AppMethodBeat.i(136745);
            String[] split = com.tencent.mm.plugin.fts.a.c.a.mCE.split(str, 2);
            AppMethodBeat.o(136745);
            return split;
        }
    };
    j mgD;

    class e extends com.tencent.mm.plugin.fts.a.a.h {
        public e(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136755);
            Ng("start");
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.a(this.mEl.query, false, c.this.mGw);
            com.tencent.mm.plugin.fts.a.a.g aO = com.tencent.mm.plugin.fts.a.a.g.aO(this.mEl.mEq, true);
            HashMap hashMap = new HashMap();
            Cursor a = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(3)).a(aO, this.mEl.talker, com.tencent.mm.plugin.fts.a.c.mCl, com.tencent.mm.plugin.fts.a.c.mCp);
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.mDx = a.getString(0);
                mVar.type = a.getInt(1);
                mVar.mDw = a.getInt(2);
                mVar.mDz = aO;
                if (!hashMap.containsKey(mVar.mDx)) {
                    hashMap.put(mVar.mDx, mVar);
                }
                if (hashMap.size() > 100) {
                    break;
                }
            }
            a.close();
            Ng("findHitContact");
            Cursor a2 = c.this.mGp.a(jVar.mDz, this.mEl.mEp, hashMap.keySet());
            HashMap hashMap2 = new HashMap();
            while (a2.moveToNext()) {
                List list;
                com.tencent.mm.plugin.fts.a.a.m i = new com.tencent.mm.plugin.fts.a.a.m().i(a2);
                i.mDz = jVar.mDz;
                if (hashMap2.containsKey(i.talker)) {
                    list = (List) hashMap2.get(i.talker);
                } else {
                    list = new ArrayList();
                }
                list.add(i);
                hashMap2.put(i.talker, list);
            }
            a2.close();
            jVar.mEy = new ArrayList();
            for (Entry entry : hashMap2.entrySet()) {
                l lVar = (l) hashMap.get(entry.getKey());
                if (lVar != null) {
                    Collections.sort((List) entry.getValue(), this.mEl.mEv);
                    lVar.userData = entry.getValue();
                    lVar.timestamp = ((l) ((List) entry.getValue()).get(0)).timestamp;
                    jVar.mEy.add(lVar);
                }
            }
            Collections.sort(jVar.mEy, this.mEl.mEv);
            Ng("findHitMessage");
            AppMethodBeat.o(136755);
        }

        public final String getName() {
            return "SearchConvTalkerMessageTask";
        }

        public final int getId() {
            return 29;
        }
    }

    class f extends com.tencent.mm.plugin.fts.a.a.h {
        f(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136756);
            Ng("start");
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.a(this.mEl.query, false, c.this.mGw);
            com.tencent.mm.plugin.fts.c.c cVar = c.this.mGp;
            com.tencent.mm.plugin.fts.a.a.g gVar = jVar.mDz;
            String str = this.mEl.mEp;
            String bAl = gVar.bAl();
            bAl = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[]{cVar.bAf(), cVar.bAf(), cVar.bAg(), cVar.bAf(), cVar.bAg(), cVar.bAg(), bAl});
            Cursor rawQuery = cVar.mBT.rawQuery(bAl, new String[]{str});
            jVar.mEy = new ArrayList();
            while (rawQuery.moveToNext()) {
                jVar.mEy.add(new com.tencent.mm.plugin.fts.a.a.m().i(rawQuery));
            }
            rawQuery.close();
            Ng("findConversationMessage");
            if (jVar.mDz.mEb.length > 1 && !this.mEl.mEu.contains("create_talker_message​")) {
                rawQuery = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(3)).a(com.tencent.mm.plugin.fts.a.a.g.aO(jVar.mDz.mEb[0], true), null, com.tencent.mm.plugin.fts.a.c.mCl, com.tencent.mm.plugin.fts.a.c.mCp);
                if (rawQuery.moveToNext()) {
                    l lVar = new l();
                    lVar.mDx = "create_talker_message​";
                    jVar.mEy.add(0, lVar);
                }
                rawQuery.close();
                Ng("findTalkerConversation");
            }
            AppMethodBeat.o(136756);
        }

        public final String getName() {
            return "SearchConversationMessageTask";
        }

        public final int getId() {
            return 14;
        }
    }

    class g extends com.tencent.mm.plugin.fts.a.a.h {

        class a {
            int mDw;
            String mDx;
            long mEB;
            long timestamp;
            int type;

            private a() {
            }

            /* synthetic */ a(g gVar, byte b) {
                this();
            }
        }

        public g(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136757);
            Ng("start");
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.a(this.mEl.query, false, c.this.mGw);
            com.tencent.mm.plugin.fts.c.c cVar = c.this.mGp;
            String bAl = jVar.mDz.bAl();
            Cursor rawQuery = cVar.mBT.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[]{cVar.bAf(), cVar.bAg(), cVar.bAf(), cVar.bAg(), cVar.bAg(), bAl}), null);
            ArrayList<a> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(3);
                if (hashSet.add(string)) {
                    a aVar = new a(this, (byte) 0);
                    aVar.type = rawQuery.getInt(0);
                    aVar.mDw = rawQuery.getInt(1);
                    aVar.mEB = rawQuery.getLong(2);
                    aVar.mDx = rawQuery.getString(3);
                    aVar.timestamp = rawQuery.getLong(4);
                    arrayList.add(aVar);
                    arrayList2.add(string);
                }
                if (arrayList.size() > this.mEl.mEt) {
                    break;
                }
            }
            rawQuery.close();
            jVar.mEy = new LinkedList();
            Ng("findUsername");
            if (arrayList2.size() > 0) {
                Cursor a = c.this.mGp.a(jVar.mDz, arrayList2);
                HashMap hashMap = new HashMap();
                if (a.moveToNext()) {
                    String[] split = a.getString(0).split(" ");
                    for (int i = 0; i < split.length; i += 2) {
                        hashMap.put(split[i], Integer.valueOf(split[i + 1]));
                    }
                }
                a.close();
                for (a aVar2 : arrayList) {
                    l lVar = new l();
                    lVar.type = aVar2.type;
                    lVar.mDw = aVar2.mDw;
                    lVar.mEB = aVar2.mEB;
                    lVar.mDx = aVar2.mDx;
                    lVar.timestamp = aVar2.timestamp;
                    if (hashMap.containsKey(lVar.mDx)) {
                        lVar.userData = hashMap.get(lVar.mDx);
                    } else {
                        lVar.userData = Integer.valueOf(1);
                    }
                    jVar.mEy.add(lVar);
                }
                Ng("findCount");
            }
            if (jVar.mDz.mEb.length > 1 && jVar.mEy.size() <= 3) {
                rawQuery = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(3)).a(com.tencent.mm.plugin.fts.a.a.g.aO(jVar.mDz.mEb[0], true), null, com.tencent.mm.plugin.fts.a.c.mCl, com.tencent.mm.plugin.fts.a.c.mCp);
                if (rawQuery.moveToNext()) {
                    l lVar2 = new l();
                    lVar2.mDx = "create_talker_message​";
                    jVar.mEy.add(lVar2);
                }
                rawQuery.close();
                Ng("findTalkerConversation");
            }
            AppMethodBeat.o(136757);
        }

        public final String getName() {
            return "SearchLimitGroupMessage";
        }

        public final int getId() {
            return 24;
        }
    }

    class d {
        String content;
        long createTime;
        long cvx;
        int mGE;
        int mGF;
        String mGG;
        String mGH;
        int msgType;
        String talker;

        private d() {
        }

        /* synthetic */ d(c cVar, byte b) {
            this();
        }

        public final boolean bAA() {
            return (this.msgType & CdnLogic.kBizGeneric) == 49;
        }

        public final boolean bAB() {
            return this.msgType == 1;
        }

        public final boolean bAC() {
            return this.msgType == 48;
        }

        public final void bAD() {
            AppMethodBeat.i(136753);
            if (bAB()) {
                this.mGE = 41;
                if (t.kH(this.talker)) {
                    this.mGG = bf.oz(this.content);
                } else {
                    this.mGG = this.content;
                }
            } else if (bAA()) {
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(this.content);
                if (me != null) {
                    switch (me.type) {
                        case 3:
                        case 4:
                        case 5:
                        case 8:
                        case 10:
                        case 13:
                        case 15:
                        case 16:
                        case 20:
                        case 25:
                            this.mGG = bo.bc(me.getTitle(), "");
                            this.mGE = 43;
                            break;
                        case 6:
                            this.mGG = bo.bc(me.getTitle(), "");
                            this.mGE = 42;
                            break;
                        case 19:
                            this.mGG = bo.bc(me.getDescription(), "");
                            if (this.mGG != null) {
                                this.mGG = this.mGG.replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "​");
                            }
                            this.mGE = 44;
                            break;
                        case 24:
                            this.mGG = bo.bc(me.getDescription(), "");
                            if (this.mGG != null) {
                                this.mGG = this.mGG.replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "​");
                            }
                            this.mGE = 49;
                            break;
                        case 33:
                            this.mGG = bo.bc(me.getTitle(), "");
                            this.mGE = 48;
                            break;
                        case 2000:
                            this.mGG = bo.bc(me.title, "") + "​" + bo.bc(me.description, "");
                            this.mGE = 45;
                            break;
                        case 2001:
                            if (!"1001".equals(me.fhY)) {
                                if ("1002".equals(me.fhY)) {
                                    this.mGE = 46;
                                    if (this.mGF != 1) {
                                        this.mGG = bo.bc(me.fhW, "") + "​" + bo.bc(me.fhS, "");
                                        break;
                                    } else {
                                        this.mGG = bo.bc(me.fhW, "") + "​" + bo.bc(me.fhT, "");
                                        break;
                                    }
                                }
                            }
                            this.mGE = 47;
                            if (this.mGF != 1) {
                                this.mGG = bo.bc(me.fhW, "") + "​" + bo.bc(me.fhS, "");
                                break;
                            } else {
                                this.mGG = bo.bc(me.fhW, "") + "​" + bo.bc(me.fhT, "");
                                break;
                            }
                            break;
                    }
                }
            } else if (bAC()) {
                String oz;
                this.mGE = 50;
                if (t.kH(this.talker)) {
                    oz = bf.oz(this.content);
                } else {
                    oz = this.content;
                }
                com.tencent.mm.storage.bi.b Ro = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Ro(oz);
                if (Ro.dua()) {
                    this.mGG = Ro.eUu + "​" + Ro.label;
                } else {
                    this.mGG = Ro.label;
                }
            }
            if (!bo.isNullOrNil(this.mGG)) {
                this.mGG = com.tencent.mm.plugin.fts.a.d.Na(this.mGG);
            }
            if (this.mGF == 1) {
                this.mGH = r.Yz();
                AppMethodBeat.o(136753);
            } else if (t.kH(this.talker)) {
                this.mGH = bo.bc(bf.oy(this.content), this.talker);
                AppMethodBeat.o(136753);
            } else {
                this.mGH = this.talker;
                AppMethodBeat.o(136753);
            }
        }

        public final boolean isAvailable() {
            AppMethodBeat.i(136754);
            if (bo.isNullOrNil(this.mGG)) {
                AppMethodBeat.o(136754);
                return false;
            }
            AppMethodBeat.o(136754);
            return true;
        }
    }

    class h extends com.tencent.mm.plugin.fts.a.a.h {
        public h(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            l lVar;
            AppMethodBeat.i(136758);
            Ng("start");
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.a(this.mEl.query, false, c.this.mGw);
            com.tencent.mm.plugin.fts.a.a.g aO = com.tencent.mm.plugin.fts.a.a.g.aO(this.mEl.mEq, true);
            HashMap hashMap = new HashMap();
            Cursor a = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(3)).a(aO, null, com.tencent.mm.plugin.fts.a.c.mCl, com.tencent.mm.plugin.fts.a.c.mCp);
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.mDx = a.getString(0);
                mVar.type = a.getInt(1);
                mVar.mDw = a.getInt(2);
                mVar.mDz = aO;
                if (!hashMap.containsKey(mVar.mDx)) {
                    hashMap.put(mVar.mDx, mVar);
                }
                if (hashMap.size() > 100) {
                    break;
                }
            }
            a.close();
            Ng("findHitContact");
            Cursor a2 = c.this.mGp.a(jVar.mDz, null, hashMap.keySet());
            HashMap hashMap2 = new HashMap();
            while (a2.moveToNext()) {
                HashMap hashMap3;
                com.tencent.mm.plugin.fts.a.a.m i = new com.tencent.mm.plugin.fts.a.a.m().i(a2);
                i.mDz = jVar.mDz;
                i.userData = Integer.valueOf(1);
                if (hashMap2.containsKey(i.talker)) {
                    hashMap3 = (HashMap) hashMap2.get(i.talker);
                } else {
                    hashMap3 = new HashMap();
                }
                if (hashMap3.containsKey(i.mDx)) {
                    lVar = (l) hashMap3.get(i.mDx);
                    int intValue = ((Integer) lVar.userData).intValue() + 1;
                    if (lVar.timestamp < i.timestamp) {
                        i.userData = Integer.valueOf(intValue);
                        hashMap3.put(i.mDx, i);
                    } else {
                        lVar.userData = Integer.valueOf(intValue);
                        hashMap3.put(lVar.mDx, lVar);
                    }
                } else {
                    hashMap3.put(i.mDx, i);
                }
                hashMap2.put(i.talker, hashMap3);
            }
            a2.close();
            jVar.mEy = new ArrayList();
            for (l lVar2 : hashMap.values()) {
                if (hashMap2.containsKey(lVar2.mDx)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(((HashMap) hashMap2.get(lVar2.mDx)).values());
                    Collections.sort(arrayList, this.mEl.mEv);
                    lVar2.userData = arrayList;
                    lVar2.timestamp = ((l) arrayList.get(0)).timestamp;
                    jVar.mEy.add(lVar2);
                }
            }
            Collections.sort(jVar.mEy, this.mEl.mEv);
            Ng("findHitMessage");
            AppMethodBeat.o(136758);
        }

        public final String getName() {
            return "SearchTalkerMessageTask";
        }

        public final int getId() {
            return 28;
        }
    }

    class i extends com.tencent.mm.plugin.fts.a.a.h {
        private int mGJ = 0;
        private int mGK = 0;

        public i(com.tencent.mm.plugin.fts.a.a.i iVar) {
            super(iVar);
        }

        public final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            AppMethodBeat.i(136759);
            Ng("start");
            jVar.mDz = com.tencent.mm.plugin.fts.a.a.g.a(this.mEl.query, false, c.this.mGw);
            com.tencent.mm.plugin.fts.c.c cVar = c.this.mGp;
            com.tencent.mm.plugin.fts.a.a.g gVar = jVar.mDz;
            int i = this.mEl.mEt;
            String bAl = gVar.bAl();
            Cursor rawQuery = cVar.mBT.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (i != BaseClientBuilder.API_PRIORITY_OTHER ? " LIMIT " + (i + 1) : "") + ";", new Object[]{cVar.bAf(), cVar.bAg(), cVar.bAf(), cVar.bAg(), cVar.bAg(), bAl}), null);
            jVar.mEy = new LinkedList();
            while (rawQuery.moveToNext()) {
                l lVar = new l();
                lVar.type = rawQuery.getInt(0);
                lVar.mDw = rawQuery.getInt(1);
                lVar.mEB = rawQuery.getLong(2);
                lVar.mDx = rawQuery.getString(3);
                lVar.timestamp = rawQuery.getLong(4);
                lVar.userData = Integer.valueOf(rawQuery.getInt(5));
                jVar.mEy.add(lVar);
                this.mGJ = ((Integer) lVar.userData).intValue() + this.mGJ;
                this.mGK++;
            }
            rawQuery.close();
            Ng("groupMessage");
            if (jVar.mDz.mEb.length > 1) {
                Cursor a = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(3)).a(com.tencent.mm.plugin.fts.a.a.g.aO(jVar.mDz.mEb[0], true), null, com.tencent.mm.plugin.fts.a.c.mCl, com.tencent.mm.plugin.fts.a.c.mCp);
                if (a.moveToNext()) {
                    l lVar2 = new l();
                    lVar2.mDx = "create_talker_message​";
                    jVar.mEy.add(0, lVar2);
                }
                a.close();
                Ng("findTalkerConversation");
            }
            AppMethodBeat.o(136759);
        }

        public final String aAo() {
            AppMethodBeat.i(136760);
            String format = String.format("{totalMsgCount: %d conversationCount: %d}", new Object[]{Integer.valueOf(this.mGJ), Integer.valueOf(this.mGK)});
            AppMethodBeat.o(136760);
            return format;
        }

        public final String getName() {
            return "SearchTopGroupMessageTask";
        }

        public final int getId() {
            return 15;
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private long edW;

        public b(long j) {
            this.edW = j;
        }

        public final boolean execute() {
            AppMethodBeat.i(136748);
            c.this.mGp.c(com.tencent.mm.plugin.fts.a.c.mCc, this.edW);
            AppMethodBeat.o(136748);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136749);
            String format = String.format("{MsgId: %d}", new Object[]{Long.valueOf(this.edW)});
            AppMethodBeat.o(136749);
            return format;
        }

        public final String getName() {
            return "DeleteMessageTask";
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private long hjw;
        private int mFailedCount;
        private ArrayList<Long> mGA;
        private int mGB;
        private HashSet<Pair<Long, Long>> mGz;
        private int mgK;
        private int mgL;

        private a() {
            this.mGz = null;
            this.mGA = null;
            this.hjw = Long.MAX_VALUE;
            this.mGB = 0;
            this.mgK = 0;
            this.mgL = 0;
            this.mFailedCount = 0;
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        public final boolean execute() {
            long j;
            AppMethodBeat.i(136746);
            this.hjw = c.this.mGp.mBT.J(-200, Long.MAX_VALUE);
            ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: " + this.hjw);
            if (this.mGz == null) {
                this.mGz = new HashSet();
                this.mGA = new ArrayList();
                Cursor a = c.this.mGp.a(com.tencent.mm.plugin.fts.a.c.mCc, true, true, false, true, true);
                while (a.moveToNext()) {
                    j = a.getLong(0);
                    long j2 = a.getLong(1);
                    long j3 = a.getLong(2);
                    if (a.getInt(3) == -1) {
                        this.mGA.add(Long.valueOf(j));
                    } else if (j3 <= this.hjw) {
                        this.mGz.add(new Pair(Long.valueOf(j2), Long.valueOf(j3)));
                    }
                }
                a.close();
            }
            InterruptedException interruptedException;
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.o(136746);
                throw interruptedException;
            }
            int i;
            int size;
            int i2 = BaseClientBuilder.API_PRIORITY_OTHER;
            String[] strArr = new String[2];
            ArrayList<d> arrayList = new ArrayList();
            while (i2 >= 50) {
                i = 0;
                strArr[0] = Long.toString(this.hjw);
                strArr[1] = Integer.toString(this.mGB);
                Cursor rawQuery = c.this.mgD.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime!=0 AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", strArr);
                while (true) {
                    i2 = i;
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                    d dVar = new d(c.this, (byte) 0);
                    dVar.cvx = rawQuery.getLong(0);
                    dVar.talker = rawQuery.getString(1);
                    dVar.createTime = rawQuery.getLong(2);
                    dVar.content = rawQuery.getString(3);
                    dVar.msgType = rawQuery.getInt(4);
                    dVar.mGF = rawQuery.getInt(5);
                    dVar.mGE = 41;
                    if (c.a(dVar)) {
                        dVar.bAD();
                        if (dVar.isAvailable()) {
                            arrayList.add(dVar);
                        }
                    }
                    i = i2 + 1;
                }
                rawQuery.close();
                if (Thread.interrupted()) {
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(136746);
                    throw interruptedException;
                }
                size = arrayList.size();
                if (size == 0) {
                    ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d", Integer.valueOf(size));
                } else {
                    ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d FROM %d to %d", Integer.valueOf(size), Long.valueOf(((d) arrayList.get(0)).cvx), Long.valueOf(((d) arrayList.get(size - 1)).cvx));
                }
                if (size > 0) {
                    c.this.mGp.beginTransaction();
                    for (d dVar2 : arrayList) {
                        j = dVar2.cvx;
                        long j4 = dVar2.createTime;
                        if (j4 == this.hjw) {
                            this.mGB++;
                        } else {
                            this.hjw = j4;
                            this.mGB = 0;
                        }
                        if (!this.mGz.remove(new Pair(Long.valueOf(j), Long.valueOf(j4)))) {
                            try {
                                c.this.mGp.a(dVar2.mGE, j, dVar2.talker, j4, dVar2.mGG, dVar2.mGH);
                                this.mgK++;
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", e, "Build message index failed with exception. \n%s", dVar2.mGG);
                                this.mFailedCount++;
                            }
                        }
                    }
                    c.this.mGp.commit();
                    c.this.mGp.K(-200, this.hjw);
                }
                arrayList.clear();
                if (Thread.interrupted()) {
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(136746);
                    throw interruptedException;
                }
            }
            i = 50;
            Iterator it = this.mGz.iterator();
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    c.this.mGp.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(136746);
                    throw interruptedException;
                }
                if (i >= 50) {
                    c.this.mGp.commit();
                    c.this.mGp.beginTransaction();
                    i = 0;
                }
                int i3 = i;
                Pair pair = (Pair) it.next();
                c.this.mGp.a(com.tencent.mm.plugin.fts.a.c.mCc, ((Long) pair.first).longValue(), ((Long) pair.second).longValue());
                i = i3 + 1;
                this.mgL++;
                it.remove();
            }
            c.this.mGp.commit();
            i = 50;
            ListIterator listIterator = this.mGA.listIterator(this.mGA.size());
            while (listIterator.hasPrevious()) {
                if (Thread.interrupted()) {
                    c.this.mGp.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.o(136746);
                    throw interruptedException;
                }
                if (i >= 50) {
                    c.this.mGp.commit();
                    c.this.mGp.beginTransaction();
                    i = 0;
                }
                size = i;
                c.this.mGp.g(Long.valueOf(((Long) listIterator.previous()).longValue()));
                i = size + 1;
                this.mgL++;
                listIterator.remove();
            }
            c.this.mGp.K(-200, this.hjw - 1);
            c.this.mGp.commit();
            c.this.mGq = false;
            AppMethodBeat.o(136746);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.i(136747);
            String format = String.format("{new: %d removed: %d failed: %d}", new Object[]{Integer.valueOf(this.mgK), Integer.valueOf(this.mgL), Integer.valueOf(this.mFailedCount)});
            AppMethodBeat.o(136747);
            return format;
        }

        public final int getId() {
            return 4;
        }

        public final String getName() {
            return "BuildMessageIndexTask";
        }
    }

    class c extends com.tencent.mm.plugin.fts.a.a.a {
        private List<bi> mGC = new ArrayList();
        private StringBuffer mGD;

        public c(List<bi> list) {
            AppMethodBeat.i(136750);
            this.mGC.addAll(list);
            this.mGD = new StringBuffer();
            AppMethodBeat.o(136750);
        }

        public final boolean execute() {
            AppMethodBeat.i(136751);
            ArrayList<d> arrayList = new ArrayList();
            for (bi biVar : this.mGC) {
                d dVar = new d(c.this, (byte) 0);
                dVar.cvx = biVar.field_msgId;
                dVar.talker = biVar.field_talker;
                dVar.createTime = biVar.field_createTime;
                dVar.content = biVar.field_content;
                dVar.msgType = biVar.getType();
                dVar.mGF = biVar.field_isSend;
                if (c.a(dVar)) {
                    dVar.bAD();
                    if (dVar.isAvailable()) {
                        arrayList.add(dVar);
                    }
                }
            }
            this.mGD.append("{MsgId: ");
            for (d dVar2 : arrayList) {
                this.mGD.append(dVar2.cvx);
                this.mGD.append(",");
                this.mGD.append(dVar2.talker);
                this.mGD.append(",");
                this.mGD.append(dVar2.createTime);
                this.mGD.append(" ");
            }
            this.mGD.append("count: ");
            this.mGD.append(arrayList.size());
            this.mGD.append("}");
            if (arrayList.size() > 0) {
                c.this.mGp.beginTransaction();
                for (d dVar3 : arrayList) {
                    c.this.mGp.a(dVar3.mGE, dVar3.cvx, dVar3.talker, dVar3.createTime, dVar3.mGG, dVar3.mGH);
                }
                c.this.mGp.commit();
            }
            AppMethodBeat.o(136751);
            return true;
        }

        public final String getName() {
            return "InsertMessageTask";
        }

        public final String aAo() {
            AppMethodBeat.i(136752);
            String stringBuffer = this.mGD.toString();
            AppMethodBeat.o(136752);
            return stringBuffer;
        }
    }

    public c() {
        AppMethodBeat.i(136761);
        AppMethodBeat.o(136761);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.i iVar) {
        com.tencent.mm.plugin.fts.a.a.a iVar2;
        AppMethodBeat.i(136762);
        switch (iVar.hbo) {
            case 1:
                ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", Long.valueOf(com.tencent.mm.plugin.fts.a.e.mCL.mCQ));
                if (com.tencent.mm.plugin.fts.a.e.mCL.mCQ < 1000000) {
                    iVar2 = new i(iVar);
                    break;
                }
                iVar2 = new g(iVar);
                break;
            case 3:
                iVar2 = new f(iVar);
                break;
            case 10:
                iVar2 = new h(iVar);
                break;
            case 11:
                iVar2 = new e(iVar);
                break;
            default:
                iVar2 = new i(iVar);
                break;
        }
        iVar2 = this.eAX.a(-65536, iVar2);
        AppMethodBeat.o(136762);
        return iVar2;
    }

    public final boolean onCreate() {
        AppMethodBeat.i(136763);
        if (((n) com.tencent.mm.kernel.g.M(n.class)).isFTSContextReady()) {
            ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
            this.mGp = (com.tencent.mm.plugin.fts.c.c) ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSIndexStorage(4);
            this.eAX = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSTaskDaemon();
            this.mgD = ((n) com.tencent.mm.kernel.g.M(n.class)).getFTSMainDB();
            this.mGu.dnU();
            this.mGt.dnU();
            this.mGs.dnU();
            this.mGr.dnU();
            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a((com.tencent.mm.plugin.messenger.foundation.a.a.h.a) this, null);
            AppMethodBeat.o(136763);
            return true;
        }
        ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
        AppMethodBeat.o(136763);
        return false;
    }

    public final boolean Pq() {
        AppMethodBeat.i(136764);
        ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a((com.tencent.mm.plugin.messenger.foundation.a.a.h.a) this);
        this.mGu.dead();
        this.mGt.dead();
        this.mGs.dead();
        this.mGr.dead();
        this.mGp = null;
        this.eAX = null;
        AppMethodBeat.o(136764);
        return true;
    }

    public final String getName() {
        return "FTS5SearchMessageLogic";
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h hVar, com.tencent.mm.plugin.messenger.foundation.a.a.h.c cVar) {
        AppMethodBeat.i(136765);
        if (cVar.oqJ.equals("insert")) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < cVar.oqK.size(); i++) {
                Object obj;
                bi biVar = (bi) cVar.oqK.get(i);
                if (biVar == null || bo.isNullOrNil(biVar.field_talker) || bo.isNullOrNil(biVar.field_content)) {
                    obj = null;
                } else if (biVar.field_talker.endsWith("@app")) {
                    obj = null;
                } else if (biVar.field_talker.contains("@bottle")) {
                    obj = null;
                } else if (biVar.getType() == 1 || biVar.bAA() || biVar.bAC()) {
                    int obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    arrayList.add(biVar);
                }
            }
            if (arrayList.size() > 0) {
                this.eAX.a(65576, new c(arrayList));
            }
        }
        AppMethodBeat.o(136765);
    }

    public static List<String> Nm(String str) {
        AppMethodBeat.i(136766);
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        ArrayList arrayList = new ArrayList();
        String[] split = FTSJNIUtils.icuTokenizer(str).split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < split.length) {
            try {
                int intValue = Integer.valueOf(split[i]).intValue();
                int intValue2 = Integer.valueOf(split[i + 1]).intValue();
                int i2 = intValue2 - intValue;
                int intValue3 = Integer.valueOf(split[i + 2]).intValue();
                String substring = str.substring(intValue, intValue2);
                if (intValue3 < 400 || intValue3 >= 500) {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                    }
                    if (!(substring.equals("*") || substring.equals(" "))) {
                        arrayList.add(substring);
                    }
                    i += 3;
                } else {
                    if (i2 == 1) {
                        stringBuffer.append(substring);
                    } else {
                        if (stringBuffer.length() > 0) {
                            arrayList.add(stringBuffer.toString());
                            stringBuffer = new StringBuffer();
                        }
                        arrayList.add(substring);
                    }
                    i += 3;
                }
            } catch (Exception e) {
            }
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(stringBuffer.toString());
        }
        ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", arrayList, r5);
        AppMethodBeat.o(136766);
        return arrayList;
    }
}
