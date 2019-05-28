package com.tencent.p177mm.plugin.fts.p423b;

import android.database.Cursor;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C32250j;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p1210a.C32875c;
import com.tencent.p177mm.openim.p1210a.C32875c.C18734a;
import com.tencent.p177mm.openim.p1210a.C32875c.C26514b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1184av.C45175b;
import com.tencent.p177mm.p230g.p231a.C26245tv;
import com.tencent.p177mm.p230g.p231a.C32645ts;
import com.tencent.p177mm.p230g.p711c.C6562ap;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p712j.p713a.p714a.C6592a;
import com.tencent.p177mm.p712j.p713a.p714a.C6593b;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.fts.PluginFTS;
import com.tencent.p177mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.p177mm.plugin.fts.p1265c.C20853a;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C24765b;
import com.tencent.p177mm.plugin.fts.p419a.C28113j;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.C34202c.C28110a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20844h;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39129m;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C43119b;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
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

/* renamed from: com.tencent.mm.plugin.fts.b.a */
public final class C28115a extends C24765b {
    private static Set<String> mFJ = new HashSet();
    private C12028m eAX;
    private Method mFA;
    private C4937b mFB = new C281321();
    private C4937b mFC = new C281262();
    private C4931a mFD = new C281183();
    private C4931a mFE = new C69194();
    private C4884c mFF = new C69205();
    private C4884c mFG = new C120326();
    private C7564ap mFH = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C69217(), true);
    private C7564ap mFI = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C281198(), false);
    private C20853a mFv;
    private HashSet<String> mFw;
    private HashMap<String, List<Long>> mFx;
    private HashMap<String, String[]> mFy;
    private HashMap<String, List<Long>> mFz;
    private C28113j mgD;

    /* renamed from: com.tencent.mm.plugin.fts.b.a$4 */
    class C69194 implements C4931a {
        C69194() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(136653);
            String[] split = str.split(" ");
            if (split == null || split.length == 0) {
                AppMethodBeat.m2505o(136653);
                return;
            }
            if (split[0].equals("update")) {
                for (int i = 1; i < split.length; i++) {
                    C28115a.this.eAX.mo23853a(65554, new C28131v(C5046bo.getLong(split[i], 0)));
                }
                C28115a.this.eAX.mo23853a(65556, new C28130u(C28115a.this, (byte) 0));
            }
            AppMethodBeat.m2505o(136653);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$5 */
    class C69205 extends C4884c<C26245tv> {
        C69205() {
            AppMethodBeat.m2504i(136654);
            this.xxI = C26245tv.class.getName().hashCode();
            AppMethodBeat.m2505o(136654);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136655);
            C26245tv c26245tv = (C26245tv) c4883b;
            if (c26245tv.cPX.cvc <= 0) {
                C28115a.this.eAX.mo23853a(131093, new C28130u(C28115a.this, (byte) 0));
            } else if (C28115a.this.mFI.doT()) {
                C7564ap h = C28115a.this.mFI;
                long j = c26245tv.cPX.cvc;
                h.mo16770ae(j, j);
                C4990ab.m7416i("MicroMsg.FTS.FTS5SearchContactLogic", "* Update contact at once triggered.");
            }
            AppMethodBeat.m2505o(136655);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$7 */
    class C69217 implements C5015a {
        private int mFL = 0;

        C69217() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(136658);
            PluginFTS pluginFTS = (PluginFTS) C1720g.m3530M(PluginFTS.class);
            byte b = (pluginFTS.isCharging() || !pluginFTS.isInBackground()) ? true : (byte) 0;
            if (b == (byte) 0) {
                int i = this.mFL + 1;
                this.mFL = i;
                if (i < 6) {
                    AppMethodBeat.m2505o(136658);
                    return true;
                }
            }
            C28115a.this.eAX.mo23853a(131093, new C28130u(C28115a.this, (byte) 0));
            this.mFL = 0;
            AppMethodBeat.m2505o(136658);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(136659);
            String str = super.toString() + "|delayIndexTimer";
            AppMethodBeat.m2505o(136659);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$6 */
    class C120326 extends C4884c<C32645ts> {
        C120326() {
            AppMethodBeat.m2504i(136656);
            this.xxI = C32645ts.class.getName().hashCode();
            AppMethodBeat.m2505o(136656);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(136657);
            C28115a.this.eAX.mo23853a(65556, new C28125g(C34202c.mCl));
            C28115a.this.eAX.mo23853a(131093, new C28130u(C28115a.this, (byte) 0));
            AppMethodBeat.m2505o(136657);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$b */
    class C12033b extends C28106a {
        private HashSet<String> mFM;
        private HashMap<String, C7616ad> mFN;
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

        /* renamed from: com.tencent.mm.plugin.fts.b.a$b$1 */
        class C120341 implements Comparator<String> {
            C120341() {
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.m2504i(136665);
                int stringCompareUtfBinary = FTSJNIUtils.stringCompareUtfBinary((String) obj, (String) obj2);
                AppMethodBeat.m2505o(136665);
                return stringCompareUtfBinary;
            }
        }

        private C12033b() {
            AppMethodBeat.m2504i(136666);
            this.mFN = new HashMap();
            this.mFO = -1;
            this.mFP = -1;
            this.mFQ = 0;
            this.mFR = 0;
            this.mFS = 0;
            this.mFT = 0;
            this.mFU = 0;
            AppMethodBeat.m2505o(136666);
        }

        /* synthetic */ C12033b(C28115a c28115a, byte b) {
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
            AppMethodBeat.m2504i(136667);
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building contact index.");
            mo46026Ng("start");
            if (this.mFM == null) {
                this.mFM = new HashSet();
                Cursor a2 = C28115a.this.mFv.mo73838a(C34202c.mCk, true, false, true, false, true);
                while (a2.moveToNext()) {
                    String string = a2.getString(1);
                    i = a2.getInt(2);
                    j = a2.getLong(0);
                    if (i == 1) {
                        list = (List) C28115a.this.mFx.get(string);
                        if (list == null) {
                            list = new ArrayList(16);
                            C28115a.this.mFx.put(string, list);
                        }
                        list.add(Long.valueOf(j));
                    } else {
                        this.mFM.add(string);
                        if (i == 2) {
                            C28115a.this.mFw.add(string);
                        }
                    }
                }
                a2.close();
                this.mFV = C28115a.this.mFx.size();
                this.mFW = C28115a.this.mFw.size();
                this.mFX = this.mFM.size();
                if (this.mFX < 5) {
                    this.mDq |= 1;
                }
            }
            mo46026Ng("getBuildContact");
            InterruptedException interruptedException;
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(136667);
                throw interruptedException;
            }
            if (C28115a.this.mFx.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (List list2 : C28115a.this.mFx.values()) {
                    arrayList.addAll(list2);
                }
                C28115a.this.mFx.clear();
                C28115a.this.mFv.mo73843bV(arrayList);
            }
            mo46026Ng("deleteDirtyContact");
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(136667);
                throw interruptedException;
            }
            String str;
            if (C28115a.this.mFw.size() > 0) {
                Iterator it = C28115a.this.mFw.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    C28115a.this.mFv.mo73834G(str, C28115a.this.mgD.mo46035MW(str));
                }
                C28115a.this.mFw.clear();
            }
            mo46026Ng("updateTimestampContact");
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(136667);
                throw interruptedException;
            }
            Cursor i2 = C28115a.this.mgD.mo46037i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[]{Long.toString(this.mFO)});
            i = 50;
            while (i2.moveToNext()) {
                if (Thread.interrupted()) {
                    i2.close();
                    C28115a.this.mFv.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(136667);
                    throw interruptedException;
                }
                j = i2.getLong(0);
                this.mFO = j;
                C7616ad c7616ad = new C7616ad();
                c7616ad.ewQ = j;
                c7616ad.setUsername(i2.getString(1));
                c7616ad.mo14728iy(i2.getString(2));
                c7616ad.mo14729iz(i2.getString(3));
                c7616ad.mo14703iB(i2.getString(4));
                c7616ad.mo14698hw(i2.getInt(5));
                c7616ad.setType(i2.getInt(6));
                c7616ad.mo14672H(i2.getBlob(7));
                c7616ad.mo14710iI(i2.getString(8));
                c7616ad.mo14700hy(0);
                this.mFN.put(c7616ad.field_username, c7616ad);
                if (!(C1855t.m3896kH(c7616ad.field_username) || !C28115a.this.mo46040H(c7616ad) || this.mFM.remove(c7616ad.field_username))) {
                    if (i >= 50) {
                        C28115a.this.mFv.commit();
                        C28115a.this.mFv.beginTransaction();
                        i = 0;
                    }
                    try {
                        if (!c7616ad.field_username.endsWith("@chatroom") && (c7616ad.field_verifyFlag & C7616ad.dsh()) == 0) {
                            C28115a.this.mo46039F(c7616ad);
                            c7616ad.dsk();
                        }
                        i += C28115a.this.mo46042J(c7616ad);
                        this.mFR++;
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e2, "Build contact index failed with exception.\n", new Object[0]);
                        this.mFT++;
                    }
                }
            }
            i2.close();
            C28115a.this.mFv.commit();
            mo46026Ng("buildWXContact");
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(136667);
                throw interruptedException;
            }
            Cursor i3 = C28115a.this.mgD.mo46037i("SELECT rowid, chatroomname, memberlist, roomdata FROM chatroom WHERE ROWID > ? ORDER BY ROWID;", new String[]{Long.toString(this.mFP)});
            i = 50;
            while (i3.moveToNext()) {
                if (Thread.interrupted()) {
                    i3.close();
                    C28115a.this.mFv.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(136667);
                    throw interruptedException;
                }
                this.mFP = i3.getLong(0);
                String string2 = i3.getString(1);
                if (!this.mFM.remove(string2)) {
                    C7616ad c7616ad2 = (C7616ad) this.mFN.get(string2);
                    if (c7616ad2 == null) {
                        this.mFU++;
                    } else {
                        String string3 = i3.getString(2);
                        byte[] blob = i3.getBlob(3);
                        try {
                            String[] split = C28110a.mCy.split(string3);
                            Arrays.sort(split, new C120341());
                            int j2 = i + C28115a.this.mo46044j(string2, split);
                            try {
                                a = j2 + C28115a.this.mo46043a(string2, c7616ad2, split, blob, this.mFN);
                            } catch (Exception e3) {
                                e = e3;
                                a = j2;
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
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
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                                this.mFU++;
                                i = a;
                                if (i < 50) {
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            a = i;
                            C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                            this.mFU++;
                            i = a;
                            if (i < 50) {
                            }
                        }
                        if (i < 50) {
                            C28115a.this.mFv.commit();
                            C28115a.this.mFv.beginTransaction();
                            i = 0;
                        }
                    }
                }
            }
            i3.close();
            C28115a.this.mFv.commit();
            mo46026Ng("buildChatroomContact");
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(136667);
                throw interruptedException;
            }
            this.mFS = this.mFM.size();
            Iterator it2 = this.mFM.iterator();
            while (it2.hasNext()) {
                str = (String) it2.next();
                C28115a.this.mFv.mo73840b(C34202c.mCk, str);
                ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getTopHitsLogic().mo73855d(C34202c.mCk, str);
            }
            this.mFM.clear();
            this.mFN.clear();
            mo46026Ng("deleteUnusedContact");
            ((PluginFTS) C1720g.m3530M(PluginFTS.class)).setFTSIndexReady(true);
            AppMethodBeat.m2505o(136667);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136668);
            String format = String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, failContact: %d, failChatroom}", new Object[]{Integer.valueOf(this.mFX), Integer.valueOf(this.mFR), Integer.valueOf(this.mFQ), Integer.valueOf(this.mFS), Integer.valueOf(this.mFV), Integer.valueOf(this.mFW), Integer.valueOf(this.mFT), Integer.valueOf(this.mFU)});
            AppMethodBeat.m2505o(136668);
            return format;
        }

        public final String getName() {
            return "BuildContactIndexTask";
        }

        public final int getId() {
            return 1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$i */
    class C12035i extends C28106a {
        private boolean mGf;
        private String username;

        public C12035i(String str) {
            this.username = str;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136680);
            if (C28115a.this.mFx.containsKey(this.username)) {
                this.mGf = true;
                AppMethodBeat.m2505o(136680);
            } else if (C28115a.this.mFw.add(this.username)) {
                C7616ad MU = C28115a.this.mgD.mo46033MU(this.username);
                if (MU == null || C28115a.this.mo46040H(MU)) {
                    C20853a a = C28115a.this.mFv;
                    String str = this.username;
                    a.mBZ.bindLong(1, 2);
                    a.mBZ.bindString(2, str);
                    a.mBZ.bindLong(3, 0);
                    a.mBZ.execute();
                    AppMethodBeat.m2505o(136680);
                } else {
                    this.mGf = true;
                    AppMethodBeat.m2505o(136680);
                }
            } else {
                this.mGf = true;
                AppMethodBeat.m2505o(136680);
            }
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136681);
            String format = String.format("{username: %s isSkipped: %b}", new Object[]{this.username, Boolean.valueOf(this.mGf)});
            AppMethodBeat.m2505o(136681);
            return format;
        }

        public final String getName() {
            return "MarkContactTimestampTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$k */
    class C24766k extends C20844h {
        public C24766k(C20846i c20846i) {
            super(c20846i);
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136683);
            super.mo7437a(c28109j);
            C20853a a = C28115a.this.mFv;
            String str = this.mEl.query;
            String format = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[]{a.bAf()});
            Cursor rawQuery = a.mBT.rawQuery(format, new String[]{str});
            c28109j.mEy = new ArrayList();
            while (rawQuery.moveToNext()) {
                C45966l c45966l = new C45966l();
                c45966l.mDx = rawQuery.getString(0);
                c28109j.mEy.add(c45966l);
            }
            rawQuery.close();
            c28109j.bFZ = 0;
            AppMethodBeat.m2505o(136683);
        }

        public final String getName() {
            return "SearchChatroomByMemberTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$p */
    public class C24767p extends C20844h {
        public C24767p(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchContactSmallerTimestampTask";
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136688);
            long longValue = Long.valueOf(this.mEl.query).longValue();
            Cursor rawQuery = r2.mBT.rawQuery(String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[]{C28115a.this.mFv.bAf(), Long.valueOf(longValue), Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)}), null);
            c28109j.mEy = new ArrayList();
            while (rawQuery.moveToNext()) {
                C45966l c45966l = new C45966l();
                c45966l.mDx = rawQuery.getString(0);
                c28109j.mEy.add(c45966l);
            }
            rawQuery.close();
            AppMethodBeat.m2505o(136688);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$q */
    class C24768q extends C20844h {
        public C24768q(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchContactTask";
        }

        public final int getId() {
            return 20;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136689);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            C20853a a = C28115a.this.mFv;
            C20840g c20840g = c28109j.mDz;
            int[] iArr = this.mEl.mEr;
            String bAl = c20840g.bAl();
            String str = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + C3161d.m5418t(iArr);
            long size = (long) c20840g.mEc.size();
            Cursor rawQuery = a.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str + " AND status >= 0 ORDER BY subtype;", new Object[]{a.bAf(), a.bAg(), Long.valueOf(size), a.bAf(), a.bAg(), a.bAf(), a.bAg(), a.bAg(), bAl}), null);
            ArrayList<C39129m> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mEl.mEu);
            int i = 0;
            while (rawQuery.moveToNext()) {
                if (hashSet.add(rawQuery.getString(3))) {
                    C39129m k = new C39129m().mo62032k(rawQuery);
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
                        AppMethodBeat.m2505o(136689);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            c28109j.mEy = new ArrayList();
            for (C39129m c39129m : arrayList) {
                c39129m.bAo();
                c39129m.mo62028a(c28109j.mDz);
                c28109j.mEy.add(c39129m);
            }
            if (this.mEl.mEv != null) {
                Collections.sort(c28109j.mEy, this.mEl.mEv);
            }
            AppMethodBeat.m2505o(136689);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$r */
    class C24769r extends C20844h {
        public C24769r(C20846i c20846i) {
            super(c20846i);
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            InterruptedException interruptedException;
            AppMethodBeat.m2504i(136690);
            mo46026Ng("start");
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            C20853a a = C28115a.this.mFv;
            C20840g c20840g = c28109j.mDz;
            String bAl = c20840g.bAl();
            long currentTimeMillis = System.currentTimeMillis() - 1209600000;
            long size = (long) c20840g.mEc.size();
            bAl = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[]{a.bAf(), a.bAg(), Long.valueOf(size), a.bAg(), Long.valueOf(currentTimeMillis), Long.valueOf(size), a.bAf(), a.bAg(), a.bAf(), a.bAg(), a.bAg(), bAl});
            Cursor rawQuery = a.mBT.rawQuery(bAl, new String[]{c20840g.mDZ});
            ArrayList<C39129m> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mEl.mEu);
            while (rawQuery.moveToNext()) {
                C39129m j = new C39129m().mo62031j(rawQuery);
                if (hashSet.add(j.mDx)) {
                    if (arrayList.size() > this.mEl.mEt) {
                        break;
                    }
                    arrayList.add(j);
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        interruptedException = new InterruptedException("Task is Cancel: " + this.mEl.query);
                        AppMethodBeat.m2505o(136690);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(136690);
                throw interruptedException;
            }
            mo46026Ng("orm");
            c28109j.mEy = new ArrayList(arrayList.size());
            for (C39129m c39129m : arrayList) {
                c39129m.bAo();
                c39129m.mo62028a(c28109j.mDz);
                c28109j.mEy.add(c39129m);
            }
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(136690);
                throw interruptedException;
            }
            if (this.mEl.mEv != null) {
                Collections.sort(c28109j.mEy, this.mEl.mEv);
            }
            mo46026Ng("calOffsets");
            if (c28109j.mDz.mEc.size() > 1 && C28115a.this.mFv.mo36134b(c28109j.mDz)) {
                C45966l c45966l = new C45966l();
                c45966l.mDx = "create_chatroom​";
                if (c28109j.mEy.size() > 3) {
                    c28109j.mEy.add(3, c45966l);
                } else {
                    c28109j.mEy.add(c45966l);
                }
            }
            mo46026Ng("checkChatroom");
            AppMethodBeat.m2505o(136690);
        }

        public final String getName() {
            return "SearchTopChatroomInnerRankTask";
        }

        public final int getId() {
            return 25;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$t */
    class C24770t extends C20844h {
        public C24770t(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchTopContactTask";
        }

        public final int getId() {
            return 22;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            int i = 0;
            AppMethodBeat.m2504i(136692);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            C20853a a = C28115a.this.mFv;
            C20840g c20840g = c28109j.mDz;
            String bAl = c20840g.bAl();
            long size = (long) c20840g.mEc.size();
            long currentTimeMillis = System.currentTimeMillis() - 1105032704;
            Cursor rawQuery = a.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[]{a.bAf(), a.bAg(), Long.valueOf(size), Long.valueOf(currentTimeMillis), a.bAf(), a.bAg(), a.bAf(), a.bAg(), a.bAg(), bAl}), null);
            ArrayList<C39129m> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mEl.mEu);
            while (rawQuery.moveToNext()) {
                C39129m k = new C39129m().mo62032k(rawQuery);
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
                        AppMethodBeat.m2505o(136692);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            c28109j.mEy = new ArrayList();
            for (C39129m c39129m : arrayList) {
                c39129m.bAo();
                c39129m.mo62028a(c28109j.mDz);
                c28109j.mEy.add(c39129m);
            }
            if (this.mEl.mEv != null) {
                Collections.sort(c28109j.mEy, this.mEl.mEv);
            }
            AppMethodBeat.m2505o(136692);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$a */
    class C28116a extends C28106a {
        private int mgK;
        private int mgL;

        private C28116a() {
            this.mgK = 0;
            this.mgL = 0;
        }

        /* synthetic */ C28116a(C28115a c28115a, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136663);
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
            HashSet hashSet = new HashSet();
            Cursor rawQuery = C28115a.this.mFv.mBT.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
            while (rawQuery.moveToNext()) {
                hashSet.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Cursor i = C28115a.this.mgD.mo46037i("SELECT chatroomname, memberlist FROM chatroom;", null);
            int i2 = 5;
            while (i.moveToNext()) {
                if (Thread.interrupted()) {
                    i.close();
                    C28115a.this.mFv.commit();
                    InterruptedException interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(136663);
                    throw interruptedException;
                }
                String string = i.getString(0);
                String[] split = C28110a.mCy.split(i.getString(1));
                C28115a.this.mFy.put(string, split);
                if (!hashSet.remove(string)) {
                    if (i2 >= 5) {
                        C28115a.this.mFv.commit();
                        C28115a.this.mFv.beginTransaction();
                        i2 = 0;
                    }
                    C28115a.this.mFv.mo36137k(string, split);
                    i2++;
                    this.mgK++;
                }
            }
            i.close();
            C28115a.this.mFv.commit();
            Iterator it = hashSet.iterator();
            int i3 = 5;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (i3 >= 5) {
                    C28115a.this.mFv.commit();
                    C28115a.this.mFv.beginTransaction();
                    i3 = 0;
                }
                C28115a.this.mFv.mo36131Nq(str);
                i2 = i3 + 1;
                this.mgL++;
                i3 = i2;
            }
            C28115a.this.mFv.commit();
            AppMethodBeat.m2505o(136663);
            return true;
        }

        public final String getName() {
            return "BuildChatroomIndexTask";
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136664);
            String format = String.format("{new: %d removed: %d}", new Object[]{Integer.valueOf(this.mgK), Integer.valueOf(this.mgL)});
            AppMethodBeat.m2505o(136664);
            return format;
        }

        public final int getId() {
            return 3;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$h */
    class C28117h extends C28106a {
        private boolean eBp = false;
        private String edV;
        private boolean mGe = false;

        public C28117h(String str) {
            this.edV = str;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136678);
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", this.edV);
            if (C28115a.this.mFx.containsKey(this.edV)) {
                this.mGe = true;
                AppMethodBeat.m2505o(136678);
            } else {
                C28115a.this.mFv.mo73836MY(this.edV);
                List c = C28115a.this.mFv.mo73845c(C34202c.mCk, this.edV);
                C28115a.this.mFx.put(this.edV, c);
                if (c.isEmpty()) {
                    this.eBp = true;
                    C28115a.this.eAX.mo23853a(65556, new C28134e(this.edV));
                    AppMethodBeat.m2505o(136678);
                } else {
                    Cursor Np = C28115a.this.mFv.mo36130Np(this.edV);
                    HashSet hashSet = new HashSet();
                    while (Np.moveToNext()) {
                        hashSet.add(Np.getString(0));
                    }
                    Np.close();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        C28115a.this.mFv.mo73836MY(str);
                        if (!C28115a.this.mFx.containsKey(str)) {
                            C28115a.this.mFx.put(str, C28115a.this.mFv.mo73845c(C34202c.mCk, str));
                        }
                    }
                    C28115a.this.mFw.remove(this.edV);
                    ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getTopHitsLogic().mo73854Nn(this.edV);
                    AppMethodBeat.m2505o(136678);
                }
            }
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136679);
            String format = String.format("{username: %s cached: %b isSkipped: %b}", new Object[]{this.edV, Boolean.valueOf(this.mGe), Boolean.valueOf(this.eBp)});
            AppMethodBeat.m2505o(136679);
            return format;
        }

        public final String getName() {
            return "MarkContactDirtyTask";
        }

        public final int getId() {
            return 17;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$3 */
    class C281183 implements C4931a {
        C281183() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(136652);
            if (str.equals("*") || str.equals("chatroomname")) {
                AppMethodBeat.m2505o(136652);
                return;
            }
            if (!C28115a.this.mFx.containsKey(str)) {
                C28115a.this.eAX.mo23853a(65556, new C28117h(str));
            }
            AppMethodBeat.m2505o(136652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$8 */
    class C281198 implements C5015a {
        C281198() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(136660);
            C28115a.this.eAX.mo23853a(131093, new C28130u(C28115a.this, (byte) 0));
            AppMethodBeat.m2505o(136660);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(136661);
            String str = super.toString() + "|atOnceIndexTimer";
            AppMethodBeat.m2505o(136661);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$j */
    class C28120j extends C20844h {
        public C28120j(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchContactLogic.SearchTask";
        }

        public final int getId() {
            return 11;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            InterruptedException interruptedException;
            AppMethodBeat.m2504i(136682);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            Cursor a = C28115a.this.mFv.mo73837a(c28109j.mDz, this.mEl.mEr, this.mEl.mEs, true, true);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (a.moveToNext()) {
                C39129m k = new C39129m().mo62032k(a);
                if (!this.mEl.mEu.contains(k.mDx)) {
                    C45966l c45966l;
                    if (C3161d.m5417h(C34202c.mCk, k.type)) {
                        c45966l = (C45966l) hashMap.get(k.mDx);
                        if (c45966l == null || C3161d.m5416f(C34202c.mCv, k.mDw, c45966l.mDw) < 0) {
                            hashMap.put(k.mDx, k);
                        }
                    } else if (C3161d.m5417h(C34202c.mCm, k.type)) {
                        c45966l = (C45966l) hashMap2.get(Long.valueOf(k.mEB));
                        if (c45966l == null || C3161d.m5416f(C34202c.mCv, k.mDw, c45966l.mDw) < 0) {
                            hashMap2.put(Long.valueOf(k.mEB), k);
                        }
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        interruptedException = new InterruptedException();
                        AppMethodBeat.m2505o(136682);
                        throw interruptedException;
                    }
                }
            }
            a.close();
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(136682);
                throw interruptedException;
            }
            c28109j.mEy = new ArrayList(hashMap.size());
            for (C39129m c39129m : hashMap.values()) {
                c39129m.bAo();
                c39129m.mo62028a(c28109j.mDz);
                c28109j.mEy.add(c39129m);
            }
            c28109j.mEy.addAll(hashMap2.values());
            if (Thread.interrupted()) {
                interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(136682);
                throw interruptedException;
            }
            if (this.mEl.mEv != null) {
                Collections.sort(c28109j.mEy, this.mEl.mEv);
            }
            AppMethodBeat.m2505o(136682);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$s */
    class C28121s extends C20844h {
        public C28121s(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchTopContactInnerRankTask";
        }

        public final int getId() {
            return 26;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136691);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            C20853a a = C28115a.this.mFv;
            C20840g c20840g = c28109j.mDz;
            int[] iArr = this.mEl.mEr;
            String bAl = c20840g.bAl();
            long currentTimeMillis = System.currentTimeMillis() - 1105032704;
            long size = (long) c20840g.mEc.size();
            String format = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + C3161d.m5418t(iArr) + " ORDER BY Rank ;", new Object[]{a.bAf(), a.bAg(), Long.valueOf(size), a.bAg(), Long.valueOf(currentTimeMillis), Long.valueOf(size), a.bAf(), a.bAg(), a.bAf(), a.bAg(), a.bAg(), bAl});
            Cursor rawQuery = a.mBT.rawQuery(format, new String[]{c20840g.mDZ});
            ArrayList<C39129m> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mEl.mEu);
            long j = 0;
            while (rawQuery.moveToNext()) {
                C39129m j2 = new C39129m().mo62031j(rawQuery);
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
                        AppMethodBeat.m2505o(136691);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            c28109j.mEy = new ArrayList();
            for (C39129m c39129m : arrayList) {
                c39129m.bAo();
                c39129m.mo62028a(c28109j.mDz);
                c28109j.mEy.add(c39129m);
            }
            if (this.mEl.mEv != null) {
                Collections.sort(c28109j.mEy, this.mEl.mEv);
            }
            AppMethodBeat.m2505o(136691);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$9 */
    class C281229 implements Comparator<String> {
        C281229() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(136662);
            int stringCompareUtfBinary = FTSJNIUtils.stringCompareUtfBinary((String) obj, (String) obj2);
            AppMethodBeat.m2505o(136662);
            return stringCompareUtfBinary;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$d */
    class C28123d extends C28106a {
        private String edV;
        private int mFZ = 0;

        public C28123d(String str) {
            this.edV = str;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136670);
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", this.edV);
            C28115a.this.mFv.mo73840b(C34202c.mCk, this.edV);
            ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getTopHitsLogic().mo73855d(C34202c.mCk, this.edV);
            Cursor Np = C28115a.this.mFv.mo36130Np(this.edV);
            HashSet hashSet = new HashSet();
            while (Np.moveToNext()) {
                hashSet.add(Np.getString(0));
            }
            Np.close();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!C28115a.this.mFx.containsKey(str)) {
                    C28115a.this.mFx.put(str, C28115a.this.mFv.mo73845c(C34202c.mCk, str));
                    ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getTopHitsLogic().mo73854Nn(str);
                    this.mFZ++;
                }
            }
            AppMethodBeat.m2505o(136670);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136671);
            String format = String.format("{username: %s mDirtyCount: %d}", new Object[]{this.edV, Integer.valueOf(this.mFZ)});
            AppMethodBeat.m2505o(136671);
            return format;
        }

        public final String getName() {
            return "DeleteContactTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$f */
    class C28124f extends C28106a {
        private int mGa;
        private int mGb;

        private C28124f() {
            this.mGa = 0;
            this.mGb = 0;
        }

        /* synthetic */ C28124f(C28115a c28115a, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136674);
            Cursor rawQuery = C28115a.this.mFv.mBT.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                long j = rawQuery.getLong(1);
                List list = (List) C28115a.this.mFz.get(string);
                if (list == null) {
                    list = new ArrayList(16);
                    C28115a.this.mFz.put(string, list);
                    this.mGa++;
                }
                list.add(Long.valueOf(j));
                this.mGb++;
            }
            rawQuery.close();
            AppMethodBeat.m2505o(136674);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136675);
            String format = String.format("{users: %d labels: %d}", new Object[]{Integer.valueOf(this.mGa), Integer.valueOf(this.mGb)});
            AppMethodBeat.m2505o(136675);
            return format;
        }

        public final String getName() {
            return "LoadLabelCacheTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$g */
    class C28125g extends C28106a {
        private int[] mGc;
        private int mGd = 0;
        private int moz = 0;

        public C28125g(int[] iArr) {
            this.mGc = iArr;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136676);
            List<C43119b> g = C28115a.this.mFv.mo73850g(this.mGc, 1);
            this.moz = g.size();
            HashMap hashMap = new HashMap();
            for (C43119b c43119b : g) {
                String str = c43119b.mDx;
                if (!C28115a.this.mFx.containsKey(str)) {
                    List list = (List) hashMap.get(str);
                    if (list == null) {
                        list = new ArrayList(16);
                        hashMap.put(str, list);
                    }
                    list.add(Long.valueOf(c43119b.mDv));
                }
            }
            C28115a.this.mFx.putAll(hashMap);
            this.mGd = hashMap.size();
            AppMethodBeat.m2505o(136676);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136677);
            String format = String.format("{touched: %d users: %d}", new Object[]{Integer.valueOf(this.moz), Integer.valueOf(this.mGd)});
            AppMethodBeat.m2505o(136677);
            return format;
        }

        public final String getName() {
            return "MarkAllContactDirtyTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$2 */
    class C281262 implements C4937b {
        C281262() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(136651);
            String str = (String) obj;
            if (C28115a.m44677Nk(str)) {
                C7616ad aoI = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoI(str);
                if (aoI == null || C28115a.m44676G(aoI)) {
                    switch (i) {
                        case 2:
                            C28115a.this.eAX.mo23853a(65556, new C28134e(str));
                            AppMethodBeat.m2505o(136651);
                            return;
                        case 3:
                        case 4:
                            if (!C28115a.this.mFx.containsKey(str)) {
                                C28115a.this.eAX.mo23853a(65556, new C28117h(str));
                                AppMethodBeat.m2505o(136651);
                                return;
                            }
                            break;
                        case 5:
                            C28115a.this.eAX.mo23853a(65556, new C28123d(str));
                            break;
                    }
                    AppMethodBeat.m2505o(136651);
                    return;
                }
                C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", str);
                AppMethodBeat.m2505o(136651);
                return;
            }
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", str);
            AppMethodBeat.m2505o(136651);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$m */
    class C28127m extends C20844h {
        public C28127m(C20846i c20846i) {
            super(c20846i);
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136685);
            super.mo7437a(c28109j);
            C20853a a = C28115a.this.mFv;
            String str = this.mEl.mEp;
            String bAl = c28109j.mDz.bAl();
            Cursor rawQuery = a.mBT.rawQuery(String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[]{a.bAg(), a.bAf(), a.bAg(), a.bAg(), bAl}), new String[]{str});
            HashSet hashSet = new HashSet();
            c28109j.mEy = new ArrayList();
            while (rawQuery.moveToNext()) {
                C45966l c45966l = new C45966l();
                c45966l.mDx = rawQuery.getString(0);
                if (hashSet.add(c45966l.mDx)) {
                    c28109j.mEy.add(c45966l);
                }
            }
            rawQuery.close();
            c28109j.bFZ = 0;
            AppMethodBeat.m2505o(136685);
        }

        public final String getName() {
            return "SearchChatroomInMemberTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$n */
    class C28128n extends C20844h {
        public C28128n(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchChatroomTask";
        }

        public final int getId() {
            return 19;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            C45966l c45966l;
            InterruptedException interruptedException;
            AppMethodBeat.m2504i(136686);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            Cursor a = C28115a.this.mFv.mo73837a(c28109j.mDz, new int[]{131075}, null, true, true);
            HashMap hashMap = new HashMap();
            while (a.moveToNext()) {
                C39129m k = new C39129m().mo62032k(a);
                if (!this.mEl.mEu.contains(k.mDx)) {
                    c45966l = (C45966l) hashMap.get(k.mDx);
                    if (c45966l == null || C3161d.m5416f(C34202c.mCv, k.mDw, c45966l.mDw) < 0) {
                        hashMap.put(k.mDx, k);
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        interruptedException = new InterruptedException();
                        AppMethodBeat.m2505o(136686);
                        throw interruptedException;
                    }
                }
            }
            a.close();
            ArrayList arrayList = new ArrayList(hashMap.size());
            for (C39129m c39129m : hashMap.values()) {
                c39129m.bAo();
                c39129m.mo62028a(c28109j.mDz);
                arrayList.add(c39129m);
                if (Thread.interrupted()) {
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(136686);
                    throw interruptedException;
                }
            }
            if (this.mEl.mEv != null) {
                Collections.sort(arrayList, this.mEl.mEv);
            }
            c28109j.mEy = new ArrayList(hashMap.size());
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < arrayList.size(); i++) {
                c45966l = (C45966l) arrayList.get(i);
                stringBuffer.append(c45966l.mDW);
                stringBuffer.append("|");
                stringBuffer.append(c45966l.timestamp);
                stringBuffer.append(" ");
                c28109j.mEy.add(c45966l);
                if (i >= this.mEl.mEt) {
                    break;
                }
            }
            if (c28109j.mDz.mEc.size() > 1 && C28115a.this.mFv.mo36134b(c28109j.mDz)) {
                c45966l = new C45966l();
                c45966l.mDx = "create_chatroom​";
                c28109j.mEy.add(0, c45966l);
                stringBuffer.append(" needCreateChatroom");
            }
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", stringBuffer.toString());
            AppMethodBeat.m2505o(136686);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$o */
    public class C28129o extends C20844h {
        public C28129o(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchCommonChatroomTask";
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(136687);
            ArrayList P = C5046bo.m7508P(this.mEl.query.split(","));
            C20853a a = C28115a.this.mFv;
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
                C45966l c45966l = new C45966l();
                c45966l.mDx = rawQuery.getString(1);
                c45966l.mEB = rawQuery.getLong(2);
                list.add(c45966l);
                hashMap.put(string, list);
            }
            rawQuery.close();
            c28109j.mEy = new ArrayList();
            C45966l c45966l2 = new C45966l();
            c45966l2.userData = hashMap;
            c28109j.mEy.add(c45966l2);
            AppMethodBeat.m2505o(136687);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$u */
    class C28130u extends C28106a {
        private int mGg;
        private int mGh;
        private int mGi;

        private C28130u() {
            this.mGg = 0;
            this.mGh = 0;
            this.mGi = 0;
        }

        /* synthetic */ C28130u(C28115a c28115a, byte b) {
            this();
        }

        public final boolean execute() {
            InterruptedException interruptedException;
            String str;
            int i;
            AppMethodBeat.m2504i(136693);
            mo46026Ng("start");
            Iterator it = C28115a.this.mFx.entrySet().iterator();
            int i2 = 50;
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    C28115a.this.mFv.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(136693);
                    throw interruptedException;
                }
                int i3;
                if (i2 >= 50) {
                    C28115a.this.mFv.commit();
                    C28115a.this.mFv.beginTransaction();
                    i3 = 0;
                } else {
                    i3 = i2;
                }
                Entry entry = (Entry) it.next();
                for (Long longValue : (List) entry.getValue()) {
                    C28115a.this.mFv.mo73851g(Long.valueOf(longValue.longValue()));
                    i3++;
                }
                str = (String) entry.getKey();
                C7616ad MU = C28115a.this.mgD.mo46033MU(str);
                if (MU != null && MU.field_username.length() > 0 && C28115a.this.mo46040H(MU)) {
                    i3 += C28115a.this.mo46041I(MU);
                }
                i = i3;
                it.remove();
                C28115a.this.mFw.remove(str);
                this.mGg++;
                i2 = i;
            }
            mo46026Ng("dirtyContact");
            Iterator it2 = C28115a.this.mFw.iterator();
            while (it2.hasNext()) {
                if (Thread.interrupted()) {
                    C28115a.this.mFv.commit();
                    interruptedException = new InterruptedException();
                    AppMethodBeat.m2505o(136693);
                    throw interruptedException;
                }
                if (i2 >= 50) {
                    C28115a.this.mFv.commit();
                    C28115a.this.mFv.beginTransaction();
                    i = 0;
                } else {
                    i = i2;
                }
                str = (String) it2.next();
                long MW = C28115a.this.mgD.mo46035MW(str);
                C7616ad MU2 = C28115a.this.mgD.mo46033MU(str);
                if (MU2 == null || MU2.field_username.length() <= 0 || !C28115a.this.mo46040H(MU2)) {
                    i2 = i;
                } else {
                    C28115a.this.mFv.mo73834G(str, MW);
                    i2 = i + 1;
                }
                it2.remove();
                this.mGh++;
            }
            C28115a.this.mFv.commit();
            mo46026Ng("timestampContact");
            C45971e topHitsLogic = ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.mGP.clear();
            this.mGi = topHitsLogic.mGO.bAJ();
            mo46026Ng("topHits");
            AppMethodBeat.m2505o(136693);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136694);
            String format = String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[]{Integer.valueOf(this.mGg), Integer.valueOf(this.mGh), Integer.valueOf(this.mGi)});
            AppMethodBeat.m2505o(136694);
            return format;
        }

        public final String getName() {
            return "UpdateDirtyAndTimestampContactTask";
        }

        public final int getId() {
            return 16;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$v */
    class C28131v extends C28106a {
        private long mGj;
        private int mGk = 0;

        public C28131v(long j) {
            this.mGj = j;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136695);
            ArrayList arrayList = new ArrayList(32);
            C20853a a = C28115a.this.mFv;
            long j = this.mGj;
            Cursor rawQuery = a.mBT.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[]{Long.toString(j)});
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!C28115a.this.mFx.containsKey(str)) {
                    C28115a.this.mFx.put(str, C28115a.this.mFv.mo73845c(C34202c.mCl, str));
                }
            }
            AppMethodBeat.m2505o(136695);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136696);
            String format = String.format("{mLabelId: %d mContactCount: %d}", new Object[]{Long.valueOf(this.mGj), Integer.valueOf(this.mGk)});
            AppMethodBeat.m2505o(136696);
            return format;
        }

        public final String getName() {
            return "UpdateLabelTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$1 */
    class C281321 implements C4937b {
        C281321() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(136650);
            String str = (String) obj;
            if (C28115a.m44677Nk(str)) {
                C7616ad aoI = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoI(str);
                if (aoI == null || (C28115a.m44676G(aoI) && !aoI.dsf())) {
                    switch (i) {
                        case 2:
                        case 5:
                            if (!C28115a.this.mFx.containsKey(str)) {
                                C28115a.this.eAX.mo23853a(65556, new C28117h(str));
                                AppMethodBeat.m2505o(136650);
                                return;
                            }
                            break;
                        case 3:
                            if (!(C28115a.this.mFw.contains(str) || C28115a.this.mFx.containsKey(str))) {
                                C28115a.this.eAX.mo23853a(65556, new C12035i(str));
                                break;
                            }
                    }
                    AppMethodBeat.m2505o(136650);
                    return;
                }
                C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", str);
                AppMethodBeat.m2505o(136650);
                return;
            }
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", str);
            AppMethodBeat.m2505o(136650);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$c */
    class C28133c extends C28106a {
        private C28133c() {
        }

        /* synthetic */ C28133c(C28115a c28115a, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136669);
            C28115a.this.mFv.mo73853s(C34202c.mCi);
            AppMethodBeat.m2505o(136669);
            return true;
        }

        public final String getName() {
            return "DeleteAllFriendTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$e */
    class C28134e extends C28106a {
        private boolean eBp = false;
        private String edV;

        public C28134e(String str) {
            this.edV = str;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136672);
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", this.edV);
            C7616ad MU = C28115a.this.mgD.mo46033MU(this.edV);
            if (MU == null || MU.field_username.length() <= 0 || !C28115a.this.mo46040H(MU)) {
                this.eBp = true;
            } else {
                C28115a.this.mo46041I(MU);
            }
            C28115a.this.mFx.remove(this.edV);
            C28115a.this.mFw.remove(this.edV);
            AppMethodBeat.m2505o(136672);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136673);
            String format = String.format("{username: %s isSkipped: %b}", new Object[]{this.edV, Boolean.valueOf(this.eBp)});
            AppMethodBeat.m2505o(136673);
            return format;
        }

        public final String getName() {
            return "InsertContactTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$l */
    class C28135l extends C20844h {
        public C28135l(C20846i c20846i) {
            super(c20846i);
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            int i = 0;
            AppMethodBeat.m2504i(136684);
            super.mo7437a(c28109j);
            C20853a a = C28115a.this.mFv;
            String str = this.mEl.query;
            String format = String.format("SELECT count(aux_index) FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075", new Object[]{a.bAf()});
            Cursor rawQuery = a.mBT.rawQuery(format, new String[]{str});
            if (rawQuery.moveToNext()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
            C45966l c45966l = new C45966l();
            c45966l.userData = Integer.valueOf(i);
            c28109j.mEy = new ArrayList();
            c28109j.mEy.add(c45966l);
            AppMethodBeat.m2505o(136684);
        }

        public final String getName() {
            return "SearchChatroomCountTask";
        }
    }

    /* renamed from: a */
    public final C28106a mo23884a(C20846i c20846i) {
        C28106a c28135l;
        AppMethodBeat.m2504i(136697);
        switch (c20846i.hbo) {
            case 5:
                c28135l = new C28135l(c20846i);
                break;
            case 6:
                c28135l = new C24766k(c20846i);
                break;
            case 7:
                c28135l = new C28127m(c20846i);
                break;
            case 8:
                c28135l = new C28129o(c20846i);
                break;
            case 9:
                c28135l = new C24767p(c20846i);
                break;
            case 16:
                c28135l = new C24768q(c20846i);
                break;
            case 32:
                c28135l = new C28128n(c20846i);
                break;
            case 48:
                c28135l = new C24770t(c20846i);
                break;
            case 64:
                c28135l = new C28121s(c20846i);
                break;
            case 96:
                c28135l = new C24769r(c20846i);
                break;
            default:
                c28135l = new C28120j(c20846i);
                break;
        }
        c28135l = this.eAX.mo23853a(-65536, c28135l);
        AppMethodBeat.m2505o(136697);
        return c28135l;
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(136698);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
            this.mFv = (C20853a) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(3);
            this.eAX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon();
            this.mgD = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSMainDB();
            this.mFw = new HashSet();
            this.mFx = new HashMap();
            this.mFy = new HashMap();
            this.mFz = new HashMap();
            try {
                this.mFA = C6562ap.class.getDeclaredMethod("Hw", new Class[0]);
                this.mFA.setAccessible(true);
                this.eAX.mo23853a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, new C28124f(this, (byte) 0));
                this.eAX.mo23853a(131082, new C28116a(this, (byte) 0));
                this.eAX.mo23853a(131092, new C12033b(this, (byte) 0));
                this.eAX.mo23853a(BaseClientBuilder.API_PRIORITY_OTHER, new C28133c(this, (byte) 0));
                ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10116c(this.mFD);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10118a(this.mFC);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo10118a(this.mFB);
                C4931a c4931a = this.mFE;
                if (C45175b.fHH != null) {
                    C45175b.fHH.mo33518a(c4931a);
                }
                this.mFH.mo16770ae(600000, 600000);
                this.mFF.dnU();
                this.mFG.dnU();
                AppMethodBeat.m2505o(136698);
                return true;
            } catch (NoSuchMethodException e) {
                AssertionFailedError assertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
                assertionFailedError.initCause(e);
                AppMethodBeat.m2505o(136698);
                throw assertionFailedError;
            }
        }
        C4990ab.m7416i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
        AppMethodBeat.m2505o(136698);
        return false;
    }

    /* renamed from: Pq */
    public final boolean mo23883Pq() {
        AppMethodBeat.m2504i(136699);
        this.mFF.dead();
        this.mFG.dead();
        this.mFI.stopTimer();
        this.mFH.stopTimer();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this.mFC);
        ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10117d(this.mFD);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo10121b(this.mFB);
        C4931a c4931a = this.mFE;
        if (C45175b.fHH != null) {
            C45175b.fHH.mo33519b(c4931a);
        }
        if (this.mFx != null) {
            this.mFx.clear();
        }
        if (this.mFw != null) {
            this.mFw.clear();
        }
        this.mFv = null;
        this.eAX = null;
        AppMethodBeat.m2505o(136699);
        return true;
    }

    public final String getName() {
        return "FTS5SearchContactLogic";
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int mo46043a(String str, C7616ad c7616ad, String[] strArr, byte[] bArr, HashMap<String, C7616ad> hashMap) {
        AppMethodBeat.m2504i(136700);
        int i = 0;
        String str2 = c7616ad.field_nickname;
        String aL = C3161d.m5410aL(str2, false);
        String aL2 = C3161d.m5410aL(str2, true);
        long j = 0;
        long MW = this.mgD.mo46035MW(str);
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            j = (long) strArr.length;
            HashMap hashMap2 = new HashMap();
            C6592a c6592a = new C6592a();
            try {
                c6592a.parseFrom(bArr);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "parse chatroom data", new Object[0]);
            }
            Iterator it = c6592a.eow.iterator();
            while (it.hasNext()) {
                C6593b c6593b = (C6593b) it.next();
                if (!C5046bo.isNullOrNil(c6593b.eoz)) {
                    hashMap2.put(c6593b.userName, c6593b.eoz);
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
                C7616ad c7616ad2 = (C7616ad) hashMap.get(str3);
                if (c7616ad2 != null) {
                    String str4 = c7616ad2.field_conRemark;
                    String str5 = c7616ad2.field_nickname;
                    String aL3 = C3161d.m5410aL(str4, false);
                    String aL4 = C3161d.m5410aL(str4, true);
                    stringBuffer.append(C5046bo.m7532bc(str4, " ")).append("‌");
                    stringBuffer.append(C5046bo.m7532bc(aL3, " ")).append("‌");
                    stringBuffer.append(C5046bo.m7532bc(aL4, " ")).append("‌");
                    str4 = C3161d.m5410aL(str5, false);
                    aL3 = C3161d.m5410aL(str5, true);
                    stringBuffer.append(C5046bo.m7532bc(str5, " ")).append("‌");
                    stringBuffer.append(C5046bo.m7532bc(str4, " ")).append("‌");
                    stringBuffer.append(C5046bo.m7532bc(aL3, " ")).append("‌");
                    stringBuffer.append(C5046bo.m7532bc((String) hashMap2.get(str3), " ")).append("‌");
                    mo46039F(c7616ad2);
                    stringBuffer.append(C5046bo.m7532bc(c7616ad2.dul, " ")).append("‌");
                    stringBuffer.append(C5046bo.m7532bc(C3161d.m5415eu(str3, c7616ad2.mo14673Hq()), " ")).append("‌");
                    stringBuffer.append("​");
                }
                i2 = i3 + 1;
            }
        }
        if (!C5046bo.isNullOrNil(str2)) {
            this.mFv.mo73839a(131075, 5, j, str, MW, str2);
            if (C5046bo.isNullOrNil(aL)) {
                i = 1;
            } else {
                this.mFv.mo73839a(131075, 6, j, str, MW, aL);
                i = 2;
            }
            if (!C5046bo.isNullOrNil(aL2)) {
                this.mFv.mo73839a(131075, 7, j, str, MW, aL2);
                i++;
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
            this.mFv.mo73839a(131075, 38, j, str, MW, stringBuffer.toString());
            i++;
        }
        AppMethodBeat.m2505o(136700);
        return i;
    }

    /* renamed from: j */
    public final int mo46044j(String str, String[] strArr) {
        int simpleQueryForLong;
        AppMethodBeat.m2504i(136701);
        String[] strArr2 = (String[]) this.mFy.get(str);
        this.mFv.beginTransaction();
        if (strArr2 == null) {
            this.mFv.mo36131Nq(str);
            simpleQueryForLong = ((int) this.mFv.mHg.simpleQueryForLong()) + 0;
            if (strArr != null) {
                this.mFv.mo36137k(str, strArr);
                this.mFy.put(str, strArr);
                simpleQueryForLong += strArr.length;
            }
        } else if (strArr == null) {
            this.mFv.mo36131Nq(str);
            simpleQueryForLong = ((int) this.mFv.mHg.simpleQueryForLong()) + 0;
            this.mFy.remove(str);
        } else {
            HashSet hashSet = new HashSet(Arrays.asList(strArr2));
            int i = 0;
            for (Object obj : strArr) {
                if (!hashSet.remove(obj)) {
                    C20853a c20853a = this.mFv;
                    c20853a.mHa.bindString(1, str);
                    c20853a.mHa.bindString(2, obj);
                    c20853a.mHa.execute();
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
                C20853a c20853a2 = this.mFv;
                c20853a2.mHb.bindString(1, str);
                c20853a2.mHb.bindString(2, str2);
                c20853a2.mHb.execute();
                i = simpleQueryForLong + 1;
            }
            this.mFy.put(str, strArr);
        }
        this.mFv.commit();
        AppMethodBeat.m2505o(136701);
        return simpleQueryForLong;
    }

    public C28115a() {
        AppMethodBeat.m2504i(136702);
        AppMethodBeat.m2505o(136702);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: F */
    public final void mo46039F(C7616ad c7616ad) {
        AppMethodBeat.m2504i(136703);
        try {
            this.mFA.invoke(c7616ad, new Object[0]);
            AppMethodBeat.m2505o(136703);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Failed parsing RContact LVBuffer.", new Object[0]);
            AppMethodBeat.m2505o(136703);
        }
    }

    /* renamed from: Nk */
    static boolean m44677Nk(String str) {
        AppMethodBeat.m2504i(136704);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(136704);
            return false;
        } else if (str.endsWith("@stranger")) {
            AppMethodBeat.m2505o(136704);
            return false;
        } else if (str.endsWith("@qqim")) {
            AppMethodBeat.m2505o(136704);
            return false;
        } else if (str.endsWith("@app")) {
            AppMethodBeat.m2505o(136704);
            return false;
        } else if (str.startsWith("fake_")) {
            AppMethodBeat.m2505o(136704);
            return false;
        } else {
            AppMethodBeat.m2505o(136704);
            return true;
        }
    }

    /* renamed from: G */
    static boolean m44676G(C7616ad c7616ad) {
        AppMethodBeat.m2504i(136705);
        if (c7616ad.isHidden() && !"notifymessage".equals(c7616ad.field_username)) {
            AppMethodBeat.m2505o(136705);
            return false;
        } else if (c7616ad.mo16698Oa()) {
            AppMethodBeat.m2505o(136705);
            return false;
        } else if (c7616ad.field_deleteFlag != 0) {
            AppMethodBeat.m2505o(136705);
            return false;
        } else {
            if (!C7486a.m12942jh(c7616ad.field_type)) {
                if (c7616ad.mo16695NZ()) {
                    AppMethodBeat.m2505o(136705);
                    return false;
                } else if (c7616ad.dsf()) {
                    AppMethodBeat.m2505o(136705);
                    return false;
                }
            }
            AppMethodBeat.m2505o(136705);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: J */
    public final int mo46042J(C7616ad c7616ad) {
        long j;
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AppMethodBeat.m2504i(136708);
        long j2 = c7616ad.ewQ;
        String str6 = c7616ad.field_username;
        String Hq = c7616ad.mo14673Hq();
        String str7 = c7616ad.field_nickname;
        String aL = C3161d.m5410aL(str7, false);
        String aL2 = C3161d.m5410aL(str7, true);
        String str8 = c7616ad.field_conRemark;
        String aL3 = C3161d.m5410aL(str8, false);
        String aL4 = C3161d.m5410aL(str8, true);
        String str9 = c7616ad.dul;
        String str10 = c7616ad.field_contactLabelIds;
        String str11 = c7616ad.dur;
        int i3 = c7616ad.field_verifyFlag;
        String str12 = "";
        long currentTimeMillis = System.currentTimeMillis();
        if ((i3 & C7616ad.dsh()) != 0) {
            str10 = C5046bo.m7536c(((C32250j) C1720g.m3528K(C32250j.class)).mo20994cK(str6), "​");
            i3 = 0;
            j = currentTimeMillis;
            i = 131076;
        } else if (C7616ad.aox(str6)) {
            i3 = 0;
            j = currentTimeMillis;
            str10 = str12;
            i = 131081;
        } else {
            currentTimeMillis = this.mgD.mo46035MW(str6);
            if (str10 == null || str10.length() <= 0) {
                i3 = 0;
                j = currentTimeMillis;
                str10 = str12;
                i = 131072;
            } else {
                i3 = m44678a(j2, str6, str10, currentTimeMillis) + 0;
                j = currentTimeMillis;
                str10 = str12;
                i = 131072;
            }
        }
        String eu = C3161d.m5415eu(str6, Hq);
        if (eu == null || eu.length() == 0) {
            i2 = i3;
        } else {
            this.mFv.mo73839a(i, 15, j2, str6, j, eu);
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
            this.mFv.mo73839a(i, 1, j2, str6, j, eu);
            if (!(aL4 == null || aL4.length() == 0)) {
                this.mFv.mo73839a(i, 2, j2, str6, j, aL4);
            }
            if (!(str3 == null || str3.length() == 0)) {
                this.mFv.mo73839a(i, 3, j2, str6, j, str3);
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
            this.mFv.mo73839a(i, 5, j2, str6, j, str5);
            if (!(str == null || str.length() == 0)) {
                this.mFv.mo73839a(i, 6, j2, str6, j, str);
            }
            if (!(str3 == null || str3.length() == 0)) {
                this.mFv.mo73839a(i, 7, j2, str6, j, str3);
            }
            i3 = i2 + 3;
        }
        if (str9 != null && str9.length() > 0) {
            this.mFv.mo73839a(i, 4, j2, str6, j, str9);
            i3++;
        }
        if (i == 131072) {
            if (C5046bo.isNullOrNil(str11)) {
                Cursor i4 = this.mgD.mo46037i("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[]{str6});
                if (i4.moveToFirst()) {
                    this.mFv.mo73839a(i, 16, j2, str6, j, i4.getString(0));
                    i3++;
                }
                i4.close();
            } else {
                this.mFv.mo73839a(i, 16, j2, str6, j, str11.replace(",", "​"));
                i3++;
            }
            eu = C28115a.m44689mL(c7616ad.getProvince());
            if (!(eu == null || eu.length() == 0)) {
                this.mFv.mo73839a(i, 18, j2, str6, j, eu);
                i3++;
            }
            eu = c7616ad.getCity();
            if (!(eu == null || eu.length() == 0)) {
                this.mFv.mo73839a(i, 17, j2, str6, j, eu);
                i3++;
            }
        }
        if (i == 131076 && !C5046bo.isNullOrNil(str10)) {
            this.mFv.mo73839a(i, 19, j2, str6, j, str10);
            i3++;
            eu = C3161d.m5410aL(str10, false);
            if (!C5046bo.isNullOrNil(eu)) {
                this.mFv.mo73839a(i, 20, j2, str6, j, eu);
                i3++;
            }
            eu = C3161d.m5410aL(str10, true);
            if (!C5046bo.isNullOrNil(eu)) {
                this.mFv.mo73839a(i, 21, j2, str6, j, eu);
                i3++;
            }
        }
        if (i == 131081) {
            i3 += m44679a(c7616ad, j);
        }
        AppMethodBeat.m2505o(136708);
        return i3;
    }

    /* renamed from: ev */
    private void m44685ev(String str, String str2) {
        AppMethodBeat.m2504i(136710);
        String[] split = C28110a.mCF.split(str2);
        List list;
        if (split.length != 0) {
            ArrayList arrayList = new ArrayList(split.length);
            for (String str3 : split) {
                arrayList.add(Long.valueOf(C5046bo.getLong(str3, 0)));
            }
            list = arrayList;
        } else {
            list = null;
        }
        List list2 = (List) this.mFz.get(str);
        if (list2 == null) {
            this.mFv.mo36129No(str);
            if (!(list == null || list.isEmpty())) {
                this.mFv.mo36136k(str, (List) list);
                this.mFz.put(str, list);
                AppMethodBeat.m2505o(136710);
                return;
            }
        } else if (list == null || list.isEmpty()) {
            this.mFv.mo36129No(str);
            this.mFz.remove(str);
            AppMethodBeat.m2505o(136710);
            return;
        } else {
            long longValue;
            C20853a c20853a;
            HashSet hashSet = new HashSet(list2);
            for (Long longValue2 : list) {
                longValue = longValue2.longValue();
                if (!hashSet.remove(Long.valueOf(longValue))) {
                    c20853a = this.mFv;
                    c20853a.mHd.bindString(1, str);
                    c20853a.mHd.bindLong(2, longValue);
                    c20853a.mHd.execute();
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                longValue = ((Long) it.next()).longValue();
                c20853a = this.mFv;
                c20853a.mHe.bindString(1, str);
                c20853a.mHe.bindLong(2, longValue);
                c20853a.mHe.execute();
            }
            this.mFz.put(str, list);
        }
        AppMethodBeat.m2505o(136710);
    }

    /* renamed from: a */
    private int m44678a(long j, String str, String str2, long j2) {
        AppMethodBeat.m2504i(136711);
        if (str2 != null) {
            if (str2.endsWith("\u0000")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            if (str2.length() == 0) {
                AppMethodBeat.m2505o(136711);
                return 0;
            }
            m44685ev(str, str2);
            List MX = this.mgD.mo46036MX(str2);
            if (MX.size() == 0) {
                AppMethodBeat.m2505o(136711);
                return 0;
            }
            this.mFv.mo73839a((int) WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 11, j, str, j2, C5046bo.m7536c(MX, "​"));
            AppMethodBeat.m2505o(136711);
            return 1;
        }
        AppMethodBeat.m2505o(136711);
        return 0;
    }

    static {
        AppMethodBeat.m2504i(136713);
        String[] split = C4996ah.getContext().getString(C25738R.string.b3c).split(";");
        if (split != null) {
            for (Object add : split) {
                mFJ.add(add);
            }
        }
        AppMethodBeat.m2505o(136713);
    }

    /* renamed from: mL */
    private static String m44689mL(String str) {
        AppMethodBeat.m2504i(136712);
        if (mFJ.contains(str)) {
            str = "";
            AppMethodBeat.m2505o(136712);
            return str;
        }
        AppMethodBeat.m2505o(136712);
        return str;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: H */
    public final boolean mo46040H(C7616ad c7616ad) {
        AppMethodBeat.m2504i(136706);
        String str = c7616ad.field_username;
        if (!C28115a.m44676G(c7616ad)) {
            AppMethodBeat.m2505o(136706);
            return false;
        } else if (!C28115a.m44677Nk(str)) {
            AppMethodBeat.m2505o(136706);
            return false;
        } else if (C7486a.m12942jh(c7616ad.field_type)) {
            AppMethodBeat.m2505o(136706);
            return true;
        } else if (c7616ad.mo16695NZ() || c7616ad.dsf()) {
            AppMethodBeat.m2505o(136706);
            return false;
        } else if (this.mgD.mo46034MV(str)) {
            AppMethodBeat.m2505o(136706);
            return true;
        } else {
            AppMethodBeat.m2505o(136706);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: I */
    public final int mo46041I(C7616ad c7616ad) {
        AppMethodBeat.m2504i(136707);
        int a;
        if (C1855t.m3896kH(c7616ad.field_username)) {
            String format = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[]{"chatroom"});
            Cursor i = this.mgD.mo46037i(format, new String[]{c7616ad.field_username});
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
                if (C5046bo.isNullOrNil(format) || blob == null) {
                    C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", c7616ad.field_username);
                    if (mo46044j(c7616ad.field_username, null) > 0) {
                        C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", c7616ad.field_username, Integer.valueOf(mo46044j(c7616ad.field_username, null)));
                    }
                    AppMethodBeat.m2505o(136707);
                    return 0;
                }
                String[] split = C28110a.mCy.split(format);
                Arrays.sort(split, new C281229());
                if (mo46044j(c7616ad.field_username, split) > 0) {
                    C4990ab.m7417i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", c7616ad.field_username, Integer.valueOf(mo46044j(c7616ad.field_username, split)));
                }
                HashMap hashMap = new HashMap();
                Cursor i2 = this.mgD.mo46037i("SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + C3161d.m5399C(split) + ";", null);
                while (i2.moveToNext()) {
                    try {
                        C7616ad c7616ad2 = new C7616ad();
                        c7616ad2.ewQ = i2.getLong(0);
                        c7616ad2.setUsername(i2.getString(1));
                        c7616ad2.mo14728iy(i2.getString(2));
                        c7616ad2.mo14729iz(i2.getString(3));
                        c7616ad2.mo14703iB(i2.getString(4));
                        c7616ad2.mo14672H(i2.getBlob(5));
                        hashMap.put(c7616ad2.field_username, c7616ad2);
                    } catch (Throwable th) {
                        if (i2 != null) {
                            i2.close();
                        }
                        AppMethodBeat.m2505o(136707);
                    }
                }
                if (i2 != null) {
                    i2.close();
                }
                a = mo46043a(c7616ad.field_username, c7616ad, split, blob, hashMap);
                AppMethodBeat.m2505o(136707);
                return a;
            } catch (Throwable th2) {
                if (i != null) {
                    i.close();
                }
                AppMethodBeat.m2505o(136707);
            }
        } else {
            a = mo46042J(c7616ad);
            AppMethodBeat.m2505o(136707);
            return a;
        }
    }

    /* renamed from: a */
    private int m44679a(C7616ad c7616ad, long j) {
        int i = 0;
        AppMethodBeat.m2504i(136709);
        String str = c7616ad.duw;
        if (!C5046bo.isNullOrNil(str)) {
            C32875c c32875c = new C32875c();
            c32875c.mo53440vj(str);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < c32875c.geU.size(); i2++) {
                for (C26514b vk : ((C18734a) c32875c.geU.get(i2)).geV) {
                    str = vk.mo44297vk(c7616ad.field_openImAppid);
                    if (!C5046bo.isNullOrNil(str)) {
                        stringBuffer.append(str);
                        stringBuffer.append("‌");
                    }
                }
                stringBuffer.append("​");
            }
            if (!C5046bo.isNullOrNil(stringBuffer.toString())) {
                this.mFv.mo73839a(131081, 51, c7616ad.ewQ, c7616ad.field_username, j, stringBuffer.toString());
                i = 1;
            }
        }
        AppMethodBeat.m2505o(136709);
        return i;
    }
}
