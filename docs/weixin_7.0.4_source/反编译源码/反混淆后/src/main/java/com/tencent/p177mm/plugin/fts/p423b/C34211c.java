package com.tencent.p177mm.plugin.fts.p423b;

import android.database.Cursor;
import android.util.Pair;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.p230g.p231a.C37781pe;
import com.tencent.p177mm.p230g.p231a.C37786qo;
import com.tencent.p177mm.p230g.p231a.C45357pf;
import com.tencent.p177mm.plugin.fts.PluginFTS;
import com.tencent.p177mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.p177mm.plugin.fts.p1265c.C20853a;
import com.tencent.p177mm.plugin.fts.p1265c.C46910c;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C24765b;
import com.tencent.p177mm.plugin.fts.p419a.C28113j;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.C34202c.C28110a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g.C20843a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20844h;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39129m;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3457a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5136b;
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

/* renamed from: com.tencent.mm.plugin.fts.b.c */
public final class C34211c extends C24765b implements C3457a {
    C12028m eAX;
    C46910c mGp;
    boolean mGq = false;
    private C4884c mGr = new C281361();
    private C4884c mGs = new C120432();
    private C4884c mGt = new C342083();
    C4884c mGu = new C342124();
    C7564ap mGv = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C342155(), false);
    C20843a mGw = new C342136();
    C28113j mgD;

    /* renamed from: com.tencent.mm.plugin.fts.b.c$e */
    class C3166e extends C20844h {
        public C3166e(C20846i c20846i) {
            super(c20846i);
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136755);
            mo46026Ng("start");
            c28109j.mDz = C20840g.m32050a(this.mEl.query, false, C34211c.this.mGw);
            C20840g aO = C20840g.m32052aO(this.mEl.mEq, true);
            HashMap hashMap = new HashMap();
            Cursor a = ((C20853a) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(3)).mo36133a(aO, this.mEl.talker, C34202c.mCl, C34202c.mCp);
            while (a.moveToNext()) {
                C39129m c39129m = new C39129m();
                c39129m.mDx = a.getString(0);
                c39129m.type = a.getInt(1);
                c39129m.mDw = a.getInt(2);
                c39129m.mDz = aO;
                if (!hashMap.containsKey(c39129m.mDx)) {
                    hashMap.put(c39129m.mDx, c39129m);
                }
                if (hashMap.size() > 100) {
                    break;
                }
            }
            a.close();
            mo46026Ng("findHitContact");
            Cursor a2 = C34211c.this.mGp.mo76113a(c28109j.mDz, this.mEl.mEp, hashMap.keySet());
            HashMap hashMap2 = new HashMap();
            while (a2.moveToNext()) {
                List list;
                C39129m i = new C39129m().mo62030i(a2);
                i.mDz = c28109j.mDz;
                if (hashMap2.containsKey(i.talker)) {
                    list = (List) hashMap2.get(i.talker);
                } else {
                    list = new ArrayList();
                }
                list.add(i);
                hashMap2.put(i.talker, list);
            }
            a2.close();
            c28109j.mEy = new ArrayList();
            for (Entry entry : hashMap2.entrySet()) {
                C45966l c45966l = (C45966l) hashMap.get(entry.getKey());
                if (c45966l != null) {
                    Collections.sort((List) entry.getValue(), this.mEl.mEv);
                    c45966l.userData = entry.getValue();
                    c45966l.timestamp = ((C45966l) ((List) entry.getValue()).get(0)).timestamp;
                    c28109j.mEy.add(c45966l);
                }
            }
            Collections.sort(c28109j.mEy, this.mEl.mEv);
            mo46026Ng("findHitMessage");
            AppMethodBeat.m2505o(136755);
        }

        public final String getName() {
            return "SearchConvTalkerMessageTask";
        }

        public final int getId() {
            return 29;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$2 */
    class C120432 extends C4884c<C37781pe> {
        C120432() {
            AppMethodBeat.m2504i(136735);
            this.xxI = C37781pe.class.getName().hashCode();
            AppMethodBeat.m2505o(136735);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136736);
            C37781pe c37781pe = (C37781pe) c4883b;
            if (c37781pe instanceof C37781pe) {
                C34211c.this.eAX.mo23853a(65576, new C34214b(c37781pe.cLt.cvx));
            }
            AppMethodBeat.m2505o(136736);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$f */
    class C12044f extends C20844h {
        C12044f(C20846i c20846i) {
            super(c20846i);
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136756);
            mo46026Ng("start");
            c28109j.mDz = C20840g.m32050a(this.mEl.query, false, C34211c.this.mGw);
            C46910c c46910c = C34211c.this.mGp;
            C20840g c20840g = c28109j.mDz;
            String str = this.mEl.mEp;
            String bAl = c20840g.bAl();
            bAl = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[]{c46910c.bAf(), c46910c.bAf(), c46910c.bAg(), c46910c.bAf(), c46910c.bAg(), c46910c.bAg(), bAl});
            Cursor rawQuery = c46910c.mBT.rawQuery(bAl, new String[]{str});
            c28109j.mEy = new ArrayList();
            while (rawQuery.moveToNext()) {
                c28109j.mEy.add(new C39129m().mo62030i(rawQuery));
            }
            rawQuery.close();
            mo46026Ng("findConversationMessage");
            if (c28109j.mDz.mEb.length > 1 && !this.mEl.mEu.contains("create_talker_message​")) {
                rawQuery = ((C20853a) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(3)).mo36133a(C20840g.m32052aO(c28109j.mDz.mEb[0], true), null, C34202c.mCl, C34202c.mCp);
                if (rawQuery.moveToNext()) {
                    C45966l c45966l = new C45966l();
                    c45966l.mDx = "create_talker_message​";
                    c28109j.mEy.add(0, c45966l);
                }
                rawQuery.close();
                mo46026Ng("findTalkerConversation");
            }
            AppMethodBeat.m2505o(136756);
        }

        public final String getName() {
            return "SearchConversationMessageTask";
        }

        public final int getId() {
            return 14;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$g */
    class C12046g extends C20844h {

        /* renamed from: com.tencent.mm.plugin.fts.b.c$g$a */
        class C12045a {
            int mDw;
            String mDx;
            long mEB;
            long timestamp;
            int type;

            private C12045a() {
            }

            /* synthetic */ C12045a(C12046g c12046g, byte b) {
                this();
            }
        }

        public C12046g(C20846i c20846i) {
            super(c20846i);
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136757);
            mo46026Ng("start");
            c28109j.mDz = C20840g.m32050a(this.mEl.query, false, C34211c.this.mGw);
            C46910c c46910c = C34211c.this.mGp;
            String bAl = c28109j.mDz.bAl();
            Cursor rawQuery = c46910c.mBT.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[]{c46910c.bAf(), c46910c.bAg(), c46910c.bAf(), c46910c.bAg(), c46910c.bAg(), bAl}), null);
            ArrayList<C12045a> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(3);
                if (hashSet.add(string)) {
                    C12045a c12045a = new C12045a(this, (byte) 0);
                    c12045a.type = rawQuery.getInt(0);
                    c12045a.mDw = rawQuery.getInt(1);
                    c12045a.mEB = rawQuery.getLong(2);
                    c12045a.mDx = rawQuery.getString(3);
                    c12045a.timestamp = rawQuery.getLong(4);
                    arrayList.add(c12045a);
                    arrayList2.add(string);
                }
                if (arrayList.size() > this.mEl.mEt) {
                    break;
                }
            }
            rawQuery.close();
            c28109j.mEy = new LinkedList();
            mo46026Ng("findUsername");
            if (arrayList2.size() > 0) {
                Cursor a = C34211c.this.mGp.mo76114a(c28109j.mDz, arrayList2);
                HashMap hashMap = new HashMap();
                if (a.moveToNext()) {
                    String[] split = a.getString(0).split(" ");
                    for (int i = 0; i < split.length; i += 2) {
                        hashMap.put(split[i], Integer.valueOf(split[i + 1]));
                    }
                }
                a.close();
                for (C12045a c12045a2 : arrayList) {
                    C45966l c45966l = new C45966l();
                    c45966l.type = c12045a2.type;
                    c45966l.mDw = c12045a2.mDw;
                    c45966l.mEB = c12045a2.mEB;
                    c45966l.mDx = c12045a2.mDx;
                    c45966l.timestamp = c12045a2.timestamp;
                    if (hashMap.containsKey(c45966l.mDx)) {
                        c45966l.userData = hashMap.get(c45966l.mDx);
                    } else {
                        c45966l.userData = Integer.valueOf(1);
                    }
                    c28109j.mEy.add(c45966l);
                }
                mo46026Ng("findCount");
            }
            if (c28109j.mDz.mEb.length > 1 && c28109j.mEy.size() <= 3) {
                rawQuery = ((C20853a) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(3)).mo36133a(C20840g.m32052aO(c28109j.mDz.mEb[0], true), null, C34202c.mCl, C34202c.mCp);
                if (rawQuery.moveToNext()) {
                    C45966l c45966l2 = new C45966l();
                    c45966l2.mDx = "create_talker_message​";
                    c28109j.mEy.add(c45966l2);
                }
                rawQuery.close();
                mo46026Ng("findTalkerConversation");
            }
            AppMethodBeat.m2505o(136757);
        }

        public final String getName() {
            return "SearchLimitGroupMessage";
        }

        public final int getId() {
            return 24;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$d */
    class C20850d {
        String content;
        long createTime;
        long cvx;
        int mGE;
        int mGF;
        String mGG;
        String mGH;
        int msgType;
        String talker;

        private C20850d() {
        }

        /* synthetic */ C20850d(C34211c c34211c, byte b) {
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
            AppMethodBeat.m2504i(136753);
            if (bAB()) {
                this.mGE = 41;
                if (C1855t.m3896kH(this.talker)) {
                    this.mGG = C1829bf.m3763oz(this.content);
                } else {
                    this.mGG = this.content;
                }
            } else if (bAA()) {
                C8910b me = C8910b.m16064me(this.content);
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
                            this.mGG = C5046bo.m7532bc(me.getTitle(), "");
                            this.mGE = 43;
                            break;
                        case 6:
                            this.mGG = C5046bo.m7532bc(me.getTitle(), "");
                            this.mGE = 42;
                            break;
                        case 19:
                            this.mGG = C5046bo.m7532bc(me.getDescription(), "");
                            if (this.mGG != null) {
                                this.mGG = this.mGG.replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "​");
                            }
                            this.mGE = 44;
                            break;
                        case 24:
                            this.mGG = C5046bo.m7532bc(me.getDescription(), "");
                            if (this.mGG != null) {
                                this.mGG = this.mGG.replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "​");
                            }
                            this.mGE = 49;
                            break;
                        case 33:
                            this.mGG = C5046bo.m7532bc(me.getTitle(), "");
                            this.mGE = 48;
                            break;
                        case 2000:
                            this.mGG = C5046bo.m7532bc(me.title, "") + "​" + C5046bo.m7532bc(me.description, "");
                            this.mGE = 45;
                            break;
                        case 2001:
                            if (!"1001".equals(me.fhY)) {
                                if ("1002".equals(me.fhY)) {
                                    this.mGE = 46;
                                    if (this.mGF != 1) {
                                        this.mGG = C5046bo.m7532bc(me.fhW, "") + "​" + C5046bo.m7532bc(me.fhS, "");
                                        break;
                                    } else {
                                        this.mGG = C5046bo.m7532bc(me.fhW, "") + "​" + C5046bo.m7532bc(me.fhT, "");
                                        break;
                                    }
                                }
                            }
                            this.mGE = 47;
                            if (this.mGF != 1) {
                                this.mGG = C5046bo.m7532bc(me.fhW, "") + "​" + C5046bo.m7532bc(me.fhS, "");
                                break;
                            } else {
                                this.mGG = C5046bo.m7532bc(me.fhW, "") + "​" + C5046bo.m7532bc(me.fhT, "");
                                break;
                            }
                            break;
                    }
                }
            } else if (bAC()) {
                String oz;
                this.mGE = 50;
                if (C1855t.m3896kH(this.talker)) {
                    oz = C1829bf.m3763oz(this.content);
                } else {
                    oz = this.content;
                }
                C5136b Ro = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15261Ro(oz);
                if (Ro.dua()) {
                    this.mGG = Ro.eUu + "​" + Ro.label;
                } else {
                    this.mGG = Ro.label;
                }
            }
            if (!C5046bo.isNullOrNil(this.mGG)) {
                this.mGG = C3161d.m5403Na(this.mGG);
            }
            if (this.mGF == 1) {
                this.mGH = C1853r.m3846Yz();
                AppMethodBeat.m2505o(136753);
            } else if (C1855t.m3896kH(this.talker)) {
                this.mGH = C5046bo.m7532bc(C1829bf.m3762oy(this.content), this.talker);
                AppMethodBeat.m2505o(136753);
            } else {
                this.mGH = this.talker;
                AppMethodBeat.m2505o(136753);
            }
        }

        public final boolean isAvailable() {
            AppMethodBeat.m2504i(136754);
            if (C5046bo.isNullOrNil(this.mGG)) {
                AppMethodBeat.m2505o(136754);
                return false;
            }
            AppMethodBeat.m2505o(136754);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$1 */
    class C281361 extends C4884c<C45357pf> {
        C281361() {
            AppMethodBeat.m2504i(136733);
            this.xxI = C45357pf.class.getName().hashCode();
            AppMethodBeat.m2505o(136733);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136734);
            C45357pf c45357pf = (C45357pf) c4883b;
            if (c45357pf instanceof C45357pf) {
                C34211c.this.eAX.mo23853a(65576, new C34214b(c45357pf.cLx.cvx));
            }
            AppMethodBeat.m2505o(136734);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$3 */
    class C342083 extends C4884c<C37786qo> {

        /* renamed from: com.tencent.mm.plugin.fts.b.c$3$1 */
        class C208491 extends C28106a {
            C208491() {
            }

            public final boolean execute() {
                AppMethodBeat.m2504i(136737);
                C34211c.this.mGp.mo73835K(-200, Long.MAX_VALUE);
                AppMethodBeat.m2505o(136737);
                return true;
            }

            public final String toString() {
                return "ResetMessageCreateTimeCursor";
            }
        }

        C342083() {
            AppMethodBeat.m2504i(136738);
            this.xxI = C37786qo.class.getName().hashCode();
            AppMethodBeat.m2505o(136738);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136739);
            C34211c.this.eAX.mo23853a(65574, new C208491());
            AppMethodBeat.m2505o(136739);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$h */
    class C34209h extends C20844h {
        public C34209h(C20846i c20846i) {
            super(c20846i);
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            C45966l c45966l;
            AppMethodBeat.m2504i(136758);
            mo46026Ng("start");
            c28109j.mDz = C20840g.m32050a(this.mEl.query, false, C34211c.this.mGw);
            C20840g aO = C20840g.m32052aO(this.mEl.mEq, true);
            HashMap hashMap = new HashMap();
            Cursor a = ((C20853a) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(3)).mo36133a(aO, null, C34202c.mCl, C34202c.mCp);
            while (a.moveToNext()) {
                C39129m c39129m = new C39129m();
                c39129m.mDx = a.getString(0);
                c39129m.type = a.getInt(1);
                c39129m.mDw = a.getInt(2);
                c39129m.mDz = aO;
                if (!hashMap.containsKey(c39129m.mDx)) {
                    hashMap.put(c39129m.mDx, c39129m);
                }
                if (hashMap.size() > 100) {
                    break;
                }
            }
            a.close();
            mo46026Ng("findHitContact");
            Cursor a2 = C34211c.this.mGp.mo76113a(c28109j.mDz, null, hashMap.keySet());
            HashMap hashMap2 = new HashMap();
            while (a2.moveToNext()) {
                HashMap hashMap3;
                C39129m i = new C39129m().mo62030i(a2);
                i.mDz = c28109j.mDz;
                i.userData = Integer.valueOf(1);
                if (hashMap2.containsKey(i.talker)) {
                    hashMap3 = (HashMap) hashMap2.get(i.talker);
                } else {
                    hashMap3 = new HashMap();
                }
                if (hashMap3.containsKey(i.mDx)) {
                    c45966l = (C45966l) hashMap3.get(i.mDx);
                    int intValue = ((Integer) c45966l.userData).intValue() + 1;
                    if (c45966l.timestamp < i.timestamp) {
                        i.userData = Integer.valueOf(intValue);
                        hashMap3.put(i.mDx, i);
                    } else {
                        c45966l.userData = Integer.valueOf(intValue);
                        hashMap3.put(c45966l.mDx, c45966l);
                    }
                } else {
                    hashMap3.put(i.mDx, i);
                }
                hashMap2.put(i.talker, hashMap3);
            }
            a2.close();
            c28109j.mEy = new ArrayList();
            for (C45966l c45966l2 : hashMap.values()) {
                if (hashMap2.containsKey(c45966l2.mDx)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(((HashMap) hashMap2.get(c45966l2.mDx)).values());
                    Collections.sort(arrayList, this.mEl.mEv);
                    c45966l2.userData = arrayList;
                    c45966l2.timestamp = ((C45966l) arrayList.get(0)).timestamp;
                    c28109j.mEy.add(c45966l2);
                }
            }
            Collections.sort(c28109j.mEy, this.mEl.mEv);
            mo46026Ng("findHitMessage");
            AppMethodBeat.m2505o(136758);
        }

        public final String getName() {
            return "SearchTalkerMessageTask";
        }

        public final int getId() {
            return 28;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$i */
    class C34210i extends C20844h {
        private int mGJ = 0;
        private int mGK = 0;

        public C34210i(C20846i c20846i) {
            super(c20846i);
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136759);
            mo46026Ng("start");
            c28109j.mDz = C20840g.m32050a(this.mEl.query, false, C34211c.this.mGw);
            C46910c c46910c = C34211c.this.mGp;
            C20840g c20840g = c28109j.mDz;
            int i = this.mEl.mEt;
            String bAl = c20840g.bAl();
            Cursor rawQuery = c46910c.mBT.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (i != BaseClientBuilder.API_PRIORITY_OTHER ? " LIMIT " + (i + 1) : "") + ";", new Object[]{c46910c.bAf(), c46910c.bAg(), c46910c.bAf(), c46910c.bAg(), c46910c.bAg(), bAl}), null);
            c28109j.mEy = new LinkedList();
            while (rawQuery.moveToNext()) {
                C45966l c45966l = new C45966l();
                c45966l.type = rawQuery.getInt(0);
                c45966l.mDw = rawQuery.getInt(1);
                c45966l.mEB = rawQuery.getLong(2);
                c45966l.mDx = rawQuery.getString(3);
                c45966l.timestamp = rawQuery.getLong(4);
                c45966l.userData = Integer.valueOf(rawQuery.getInt(5));
                c28109j.mEy.add(c45966l);
                this.mGJ = ((Integer) c45966l.userData).intValue() + this.mGJ;
                this.mGK++;
            }
            rawQuery.close();
            mo46026Ng("groupMessage");
            if (c28109j.mDz.mEb.length > 1) {
                Cursor a = ((C20853a) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(3)).mo36133a(C20840g.m32052aO(c28109j.mDz.mEb[0], true), null, C34202c.mCl, C34202c.mCp);
                if (a.moveToNext()) {
                    C45966l c45966l2 = new C45966l();
                    c45966l2.mDx = "create_talker_message​";
                    c28109j.mEy.add(0, c45966l2);
                }
                a.close();
                mo46026Ng("findTalkerConversation");
            }
            AppMethodBeat.m2505o(136759);
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136760);
            String format = String.format("{totalMsgCount: %d conversationCount: %d}", new Object[]{Integer.valueOf(this.mGJ), Integer.valueOf(this.mGK)});
            AppMethodBeat.m2505o(136760);
            return format;
        }

        public final String getName() {
            return "SearchTopGroupMessageTask";
        }

        public final int getId() {
            return 15;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$4 */
    class C342124 extends C4884c<C26111d> {
        C342124() {
            AppMethodBeat.m2504i(136740);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(136740);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136741);
            if (((C26111d) c4883b).crQ.crR) {
                C34211c.this.mGv.stopTimer();
            } else {
                C34211c.this.mGv.mo16770ae(60000, 60000);
            }
            AppMethodBeat.m2505o(136741);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$6 */
    class C342136 implements C20843a {
        C342136() {
        }

        public final String[] split(String str) {
            AppMethodBeat.m2504i(136744);
            String[] ej;
            if (((PluginFTS) C1720g.m3530M(PluginFTS.class)).getFTSIndexDB().mBc) {
                ej = C5046bo.m7547ej(C34211c.m56109Nm(str));
                AppMethodBeat.m2505o(136744);
                return ej;
            }
            ej = C28110a.mCE.split(str);
            AppMethodBeat.m2505o(136744);
            return ej;
        }

        /* renamed from: Nh */
        public final String[] mo7410Nh(String str) {
            AppMethodBeat.m2504i(136745);
            String[] split = C28110a.mCE.split(str, 2);
            AppMethodBeat.m2505o(136745);
            return split;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$b */
    class C34214b extends C28106a {
        private long edW;

        public C34214b(long j) {
            this.edW = j;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136748);
            C34211c.this.mGp.mo73846c(C34202c.mCc, this.edW);
            AppMethodBeat.m2505o(136748);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136749);
            String format = String.format("{MsgId: %d}", new Object[]{Long.valueOf(this.edW)});
            AppMethodBeat.m2505o(136749);
            return format;
        }

        public final String getName() {
            return "DeleteMessageTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$5 */
    class C342155 implements C5015a {
        C342155() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(136742);
            if (!C34211c.this.mGq) {
                C34211c.this.mGq = true;
                C34211c.this.eAX.mo23853a(131112, new C34216a(C34211c.this, (byte) 0));
            }
            C4879a.xxA.mo10053d(C34211c.this.mGu);
            AppMethodBeat.m2505o(136742);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(136743);
            String str = super.toString() + "|mBackgroundTimer";
            AppMethodBeat.m2505o(136743);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$a */
    class C34216a extends C28106a {
        private long hjw;
        private int mFailedCount;
        private ArrayList<Long> mGA;
        private int mGB;
        private HashSet<Pair<Long, Long>> mGz;
        private int mgK;
        private int mgL;

        private C34216a() {
            this.mGz = null;
            this.mGA = null;
            this.hjw = Long.MAX_VALUE;
            this.mGB = 0;
            this.mgK = 0;
            this.mgL = 0;
            this.mFailedCount = 0;
        }

        /* synthetic */ C34216a(C34211c c34211c, byte b) {
            this();
        }

        public final boolean execute() {
            long j;
            AppMethodBeat.m2504i(136746);
            this.hjw = C34211c.this.mGp.mBT.mo54777J(-200, Long.MAX_VALUE);
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: " + this.hjw);
            if (this.mGz == null) {
                this.mGz = new HashSet();
                this.mGA = new ArrayList();
                Cursor a = C34211c.this.mGp.mo73838a(C34202c.mCc, true, true, false, true, true);
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
                AppMethodBeat.m2505o(136746);
                throw interruptedException;
            }
            int i;
            int size;
            int i2 = BaseClientBuilder.API_PRIORITY_OTHER;
            String[] strArr = new String[2];
            ArrayList<C20850d> arrayList = new ArrayList();
            while (i2 >= 50) {
                i = 0;
                strArr[0] = Long.toString(this.hjw);
                strArr[1] = Integer.toString(this.mGB);
                Cursor rawQuery = C34211c.this.mgD.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime!=0 AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", strArr);
                while (true) {
                    i2 = i;
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                    C20850d c20850d = new C20850d(C34211c.this, (byte) 0);
                    c20850d.cvx = rawQuery.getLong(0);
                    c20850d.talker = rawQuery.getString(1);
                    c20850d.createTime = rawQuery.getLong(2);
                    c20850d.content = rawQuery.getString(3);
                    c20850d.msgType = rawQuery.getInt(4);
                    c20850d.mGF = rawQuery.getInt(5);
                    c20850d.mGE = 41;
                    if (C34211c.m56110a(c20850d)) {
                        c20850d.bAD();
                        if (c20850d.isAvailable()) {
                            arrayList.add(c20850d);
                        }
                    }
                    i = i2 + 1;
                }
                rawQuery.close();
                if (Thread.interrupted()) {
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(136746);
                    throw interruptedException;
                }
                size = arrayList.size();
                if (size == 0) {
                    C4990ab.m7417i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d", Integer.valueOf(size));
                } else {
                    C4990ab.m7417i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d FROM %d to %d", Integer.valueOf(size), Long.valueOf(((C20850d) arrayList.get(0)).cvx), Long.valueOf(((C20850d) arrayList.get(size - 1)).cvx));
                }
                if (size > 0) {
                    C34211c.this.mGp.beginTransaction();
                    for (C20850d c20850d2 : arrayList) {
                        j = c20850d2.cvx;
                        long j4 = c20850d2.createTime;
                        if (j4 == this.hjw) {
                            this.mGB++;
                        } else {
                            this.hjw = j4;
                            this.mGB = 0;
                        }
                        if (!this.mGz.remove(new Pair(Long.valueOf(j), Long.valueOf(j4)))) {
                            try {
                                C34211c.this.mGp.mo76115a(c20850d2.mGE, j, c20850d2.talker, j4, c20850d2.mGG, c20850d2.mGH);
                                this.mgK++;
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", e, "Build message index failed with exception. \n%s", c20850d2.mGG);
                                this.mFailedCount++;
                            }
                        }
                    }
                    C34211c.this.mGp.commit();
                    C34211c.this.mGp.mo73835K(-200, this.hjw);
                }
                arrayList.clear();
                if (Thread.interrupted()) {
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(136746);
                    throw interruptedException;
                }
            }
            i = 50;
            Iterator it = this.mGz.iterator();
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    C34211c.this.mGp.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(136746);
                    throw interruptedException;
                }
                if (i >= 50) {
                    C34211c.this.mGp.commit();
                    C34211c.this.mGp.beginTransaction();
                    i = 0;
                }
                int i3 = i;
                Pair pair = (Pair) it.next();
                C34211c.this.mGp.mo76116a(C34202c.mCc, ((Long) pair.first).longValue(), ((Long) pair.second).longValue());
                i = i3 + 1;
                this.mgL++;
                it.remove();
            }
            C34211c.this.mGp.commit();
            i = 50;
            ListIterator listIterator = this.mGA.listIterator(this.mGA.size());
            while (listIterator.hasPrevious()) {
                if (Thread.interrupted()) {
                    C34211c.this.mGp.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(136746);
                    throw interruptedException;
                }
                if (i >= 50) {
                    C34211c.this.mGp.commit();
                    C34211c.this.mGp.beginTransaction();
                    i = 0;
                }
                size = i;
                C34211c.this.mGp.mo73851g(Long.valueOf(((Long) listIterator.previous()).longValue()));
                i = size + 1;
                this.mgL++;
                listIterator.remove();
            }
            C34211c.this.mGp.mo73835K(-200, this.hjw - 1);
            C34211c.this.mGp.commit();
            C34211c.this.mGq = false;
            AppMethodBeat.m2505o(136746);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136747);
            String format = String.format("{new: %d removed: %d failed: %d}", new Object[]{Integer.valueOf(this.mgK), Integer.valueOf(this.mgL), Integer.valueOf(this.mFailedCount)});
            AppMethodBeat.m2505o(136747);
            return format;
        }

        public final int getId() {
            return 4;
        }

        public final String getName() {
            return "BuildMessageIndexTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$c */
    class C34217c extends C28106a {
        private List<C7620bi> mGC = new ArrayList();
        private StringBuffer mGD;

        public C34217c(List<C7620bi> list) {
            AppMethodBeat.m2504i(136750);
            this.mGC.addAll(list);
            this.mGD = new StringBuffer();
            AppMethodBeat.m2505o(136750);
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136751);
            ArrayList<C20850d> arrayList = new ArrayList();
            for (C7620bi c7620bi : this.mGC) {
                C20850d c20850d = new C20850d(C34211c.this, (byte) 0);
                c20850d.cvx = c7620bi.field_msgId;
                c20850d.talker = c7620bi.field_talker;
                c20850d.createTime = c7620bi.field_createTime;
                c20850d.content = c7620bi.field_content;
                c20850d.msgType = c7620bi.getType();
                c20850d.mGF = c7620bi.field_isSend;
                if (C34211c.m56110a(c20850d)) {
                    c20850d.bAD();
                    if (c20850d.isAvailable()) {
                        arrayList.add(c20850d);
                    }
                }
            }
            this.mGD.append("{MsgId: ");
            for (C20850d c20850d2 : arrayList) {
                this.mGD.append(c20850d2.cvx);
                this.mGD.append(",");
                this.mGD.append(c20850d2.talker);
                this.mGD.append(",");
                this.mGD.append(c20850d2.createTime);
                this.mGD.append(" ");
            }
            this.mGD.append("count: ");
            this.mGD.append(arrayList.size());
            this.mGD.append("}");
            if (arrayList.size() > 0) {
                C34211c.this.mGp.beginTransaction();
                for (C20850d c20850d3 : arrayList) {
                    C34211c.this.mGp.mo76115a(c20850d3.mGE, c20850d3.cvx, c20850d3.talker, c20850d3.createTime, c20850d3.mGG, c20850d3.mGH);
                }
                C34211c.this.mGp.commit();
            }
            AppMethodBeat.m2505o(136751);
            return true;
        }

        public final String getName() {
            return "InsertMessageTask";
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136752);
            String stringBuffer = this.mGD.toString();
            AppMethodBeat.m2505o(136752);
            return stringBuffer;
        }
    }

    public C34211c() {
        AppMethodBeat.m2504i(136761);
        AppMethodBeat.m2505o(136761);
    }

    /* renamed from: a */
    public final C28106a mo23884a(C20846i c20846i) {
        C28106a c34210i;
        AppMethodBeat.m2504i(136762);
        switch (c20846i.hbo) {
            case 1:
                C4990ab.m7417i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", Long.valueOf(C3163e.mCL.mCQ));
                if (C3163e.mCL.mCQ < 1000000) {
                    c34210i = new C34210i(c20846i);
                    break;
                }
                c34210i = new C12046g(c20846i);
                break;
            case 3:
                c34210i = new C12044f(c20846i);
                break;
            case 10:
                c34210i = new C34209h(c20846i);
                break;
            case 11:
                c34210i = new C3166e(c20846i);
                break;
            default:
                c34210i = new C34210i(c20846i);
                break;
        }
        c34210i = this.eAX.mo23853a(-65536, c34210i);
        AppMethodBeat.m2505o(136762);
        return c34210i;
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(136763);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
            this.mGp = (C46910c) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(4);
            this.eAX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon();
            this.mgD = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSMainDB();
            this.mGu.dnU();
            this.mGt.dnU();
            this.mGs.dnU();
            this.mGr.dnU();
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15287a((C3457a) this, null);
            AppMethodBeat.m2505o(136763);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
        AppMethodBeat.m2505o(136763);
        return false;
    }

    /* renamed from: Pq */
    public final boolean mo23883Pq() {
        AppMethodBeat.m2504i(136764);
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15286a((C3457a) this);
        this.mGu.dead();
        this.mGt.dead();
        this.mGs.dead();
        this.mGr.dead();
        this.mGp = null;
        this.eAX = null;
        AppMethodBeat.m2505o(136764);
        return true;
    }

    public final String getName() {
        return "FTS5SearchMessageLogic";
    }

    /* renamed from: a */
    public final void mo7913a(C6977h c6977h, C3460c c3460c) {
        AppMethodBeat.m2504i(136765);
        if (c3460c.oqJ.equals("insert")) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < c3460c.oqK.size(); i++) {
                Object obj;
                C7620bi c7620bi = (C7620bi) c3460c.oqK.get(i);
                if (c7620bi == null || C5046bo.isNullOrNil(c7620bi.field_talker) || C5046bo.isNullOrNil(c7620bi.field_content)) {
                    obj = null;
                } else if (c7620bi.field_talker.endsWith("@app")) {
                    obj = null;
                } else if (c7620bi.field_talker.contains("@bottle")) {
                    obj = null;
                } else if (c7620bi.getType() == 1 || c7620bi.bAA() || c7620bi.bAC()) {
                    int obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    arrayList.add(c7620bi);
                }
            }
            if (arrayList.size() > 0) {
                this.eAX.mo23853a(65576, new C34217c(arrayList));
            }
        }
        AppMethodBeat.m2505o(136765);
    }

    /* renamed from: Nm */
    public static List<String> m56109Nm(String str) {
        AppMethodBeat.m2504i(136766);
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
        C4990ab.m7417i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", arrayList, r5);
        AppMethodBeat.m2505o(136766);
        return arrayList;
    }
}
