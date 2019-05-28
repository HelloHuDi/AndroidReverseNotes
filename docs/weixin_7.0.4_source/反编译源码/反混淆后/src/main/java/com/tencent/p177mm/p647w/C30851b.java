package com.tencent.p177mm.p647w;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18818b;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C24765b;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20844h;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39129m;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.ActUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.w.b */
public final class C30851b extends C24765b {
    C12028m eAX;
    C40925a eAY;
    private C4937b eAZ = new C308561();

    /* renamed from: com.tencent.mm.w.b$b */
    class C16074b extends C28106a {
        public boolean eBg;
        private HashSet<Long> eBh;
        private long eBi;
        private int eBj;
        private HashMap<int[], C30853e> eBk;

        private C16074b() {
            AppMethodBeat.m2504i(124476);
            this.eBg = false;
            this.eBh = null;
            this.eBi = Long.MIN_VALUE;
            this.eBj = -1;
            this.eBk = new HashMap();
            AppMethodBeat.m2505o(124476);
        }

        /* synthetic */ C16074b(C30851b c30851b, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(124477);
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
            this.eBg = C30851b.m49251Pr();
            if (this.eBj < 0) {
                this.eBj = 0;
            }
            C4990ab.m7411d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", Boolean.valueOf(this.eBg), Integer.valueOf(this.eBj));
            if (this.eBj == 0) {
                if (this.eBg) {
                    if (!this.eBk.containsKey(C34202c.mCm)) {
                        this.eBk.put(C34202c.mCm, new C30853e());
                    }
                    if (this.eBh == null) {
                        this.eBh = new HashSet();
                        Cursor a = C30851b.this.eAY.mo73838a(C34202c.mCm, false, true, false, false, false);
                        while (a.moveToNext()) {
                            this.eBh.add(Long.valueOf(a.getLong(0)));
                        }
                        a.close();
                    }
                    InterruptedException interruptedException;
                    if (Thread.interrupted()) {
                        interruptedException = new InterruptedException();
                        AppMethodBeat.m2505o(124477);
                        throw interruptedException;
                    }
                    int i;
                    C30853e c30853e;
                    Cursor i2 = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSMainDB().mo46037i("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[]{Long.toString(this.eBi)});
                    int i3 = 50;
                    while (i2.moveToNext()) {
                        if (Thread.interrupted()) {
                            i2.close();
                            C30851b.this.eAY.commit();
                            interruptedException = new InterruptedException();
                            AppMethodBeat.m2505o(124477);
                            throw interruptedException;
                        }
                        long j = i2.getLong(0);
                        this.eBi = j;
                        C30850a c30850a = new C30850a();
                        c30850a.f13771id = j;
                        c30850a.eBb = i2.getString(1);
                        c30850a.eBc = i2.getString(2);
                        c30850a.eBd = i2.getString(3);
                        c30850a.bCu = i2.getString(4);
                        c30850a.eBe = i2.getString(5);
                        c30850a.eBf = i2.getString(6);
                        c30850a.userName = i2.getString(7);
                        c30850a.status = i2.getInt(8);
                        c30850a.cFl = i2.getString(9);
                        c30850a.type = 0;
                        if (c30850a.status == 65536) {
                            c30850a.status = 0;
                        }
                        if (C30851b.m49253a(c30850a) && !this.eBh.remove(Long.valueOf(c30850a.f13771id))) {
                            if (i3 >= 50) {
                                C30851b.this.eAY.commit();
                                C30851b.this.eAY.beginTransaction();
                                i = 0;
                            } else {
                                i = i3;
                            }
                            try {
                                i += C30851b.m49252a(C30851b.this, c30850a);
                                c30853e = (C30853e) this.eBk.get(C34202c.mCm);
                                c30853e.eBn++;
                                i3 = i;
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", e, "Build mobile friend index failed with exception.", new Object[0]);
                                c30853e = (C30853e) this.eBk.get(C34202c.mCm);
                                c30853e.mFailedCount++;
                                i3 = i;
                            }
                        }
                    }
                    i2.close();
                    C30851b.this.eAY.commit();
                    Iterator it = this.eBh.iterator();
                    i3 = 50;
                    while (it.hasNext()) {
                        if (i3 >= 50) {
                            C30851b.this.eAY.commit();
                            C30851b.this.eAY.beginTransaction();
                            i = 0;
                        } else {
                            i = i3;
                        }
                        C30851b.this.eAY.mo73846c(C34202c.mCm, ((Long) it.next()).longValue());
                        i++;
                        c30853e = (C30853e) this.eBk.get(C34202c.mCm);
                        c30853e.eBo++;
                        it.remove();
                        i3 = i;
                    }
                    C30851b.this.eAY.commit();
                    this.eBh = null;
                    this.eBi = Long.MIN_VALUE;
                }
                this.eBj = -1;
            }
            AppMethodBeat.m2505o(124477);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(124478);
            String str;
            if (this.eBk.containsKey(C34202c.mCm)) {
                str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((C30853e) this.eBk.get(C34202c.mCm)).eBn + ", removed: " + ((C30853e) this.eBk.get(C34202c.mCm)).eBo + ", failed: " + ((C30853e) this.eBk.get(C34202c.mCm)).mFailedCount + "]";
                AppMethodBeat.m2505o(124478);
                return str;
            }
            str = "";
            AppMethodBeat.m2505o(124478);
            return str;
        }

        public final int getId() {
            return 2;
        }

        public final String getName() {
            return "BuildFriendIndexTask";
        }
    }

    /* renamed from: com.tencent.mm.w.b$c */
    class C24141c extends C28106a {
        private int eBl = 0;
        private int mCount = 0;

        public final boolean execute() {
            AppMethodBeat.m2504i(124479);
            C4990ab.m7411d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", Integer.valueOf(this.eBl));
            if (this.eBl == 0) {
                this.mCount = C30851b.this.eAY.mo73850g(C34202c.mCm, -1).size();
            }
            AppMethodBeat.m2505o(124479);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(124480);
            String str = "DeleteAllFriends [" + this.mCount + ", " + this.eBl + "]";
            AppMethodBeat.m2505o(124480);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.w.b$a */
    static class C30850a {
        String bCu;
        String cFl;
        String eBb;
        String eBc;
        String eBd;
        String eBe;
        String eBf;
        /* renamed from: id */
        long f13771id;
        int status;
        int type;
        String userName;

        C30850a() {
        }

        C30850a(C18817a c18817a) {
            AppMethodBeat.m2504i(124475);
            this.f13771id = (long) C18817a.m29385vR(c18817a.mo34067Aq());
            this.eBb = c18817a.apA();
            this.eBc = c18817a.apC();
            this.eBd = c18817a.apB();
            this.bCu = c18817a.apD();
            this.eBe = c18817a.apF();
            this.eBf = c18817a.apE();
            this.userName = c18817a.getUsername();
            this.cFl = c18817a.apG();
            this.type = c18817a.type;
            this.status = c18817a.status;
            AppMethodBeat.m2505o(124475);
        }
    }

    /* renamed from: com.tencent.mm.w.b$d */
    class C30852d extends C28106a {
        private int eBl = 0;
        private String eBm;

        public C30852d(String str) {
            this.eBm = str;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(124481);
            C4990ab.m7411d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", this.eBm, Integer.valueOf(this.eBl));
            if (this.eBl == 0) {
                C30851b.this.eAY.mo73846c(C34202c.mCm, (long) C18817a.m29385vR(this.eBm));
            }
            AppMethodBeat.m2505o(124481);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(124482);
            String str = "DeleteFriend(\"" + this.eBm + "\", " + this.eBl + ")";
            AppMethodBeat.m2505o(124482);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.w.b$e */
    static class C30853e {
        public int eBn;
        public int eBo;
        public int mFailedCount;

        private C30853e() {
            this.eBn = 0;
            this.eBo = 0;
            this.mFailedCount = 0;
        }

        /* synthetic */ C30853e(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.w.b$f */
    class C30854f extends C28106a {
        private int eBl;
        private String eBm;
        private boolean eBp = false;

        public C30854f(String str) {
            this.eBm = str;
            this.eBl = 0;
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(124483);
            C4990ab.m7411d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", this.eBm, Integer.valueOf(this.eBl));
            if (this.eBl == 0) {
                C18817a vW = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34092vW(this.eBm);
                if (vW == null) {
                    this.eBp = true;
                    AppMethodBeat.m2505o(124483);
                    return true;
                }
                C30850a c30850a = new C30850a(vW);
                if (C30851b.m49253a(c30850a)) {
                    C30851b.m49252a(C30851b.this, c30850a);
                } else {
                    this.eBp = true;
                }
            }
            AppMethodBeat.m2505o(124483);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(124484);
            String str = "InsertFriend(\"" + this.eBm + "\", " + this.eBl + ")" + (this.eBp ? " [skipped]" : "");
            AppMethodBeat.m2505o(124484);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.w.b$g */
    class C30855g extends C20844h {
        private int[] eBq;
        private int[] eBr;

        public C30855g(C20846i c20846i) {
            super(c20846i);
            this.eBq = c20846i.mEr;
            this.eBr = c20846i.mEs;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            AppMethodBeat.m2504i(124485);
            super.mo7437a(c28109j);
            C40925a c40925a = C30851b.this.eAY;
            String[] strArr = c28109j.mDz.mEa;
            int[] iArr = this.eBq;
            int[] iArr2 = this.eBr;
            String B = C3161d.m5398B(strArr);
            String format = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[]{c40925a.bAg(), Integer.valueOf(strArr.length)});
            String str = "";
            String str2 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + C3161d.m5418t(iArr2);
            String str3 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + C3161d.m5418t(iArr);
            Cursor MS = c40925a.mBT.mo54779MS(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + format + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str3 + str + " AND status >= 0" + str2 + ";", new Object[]{c40925a.bAf(), c40925a.bAf(), c40925a.bAg(), c40925a.bAf(), c40925a.bAg(), c40925a.bAg(), B}));
            HashMap hashMap = new HashMap();
            while (MS.moveToNext()) {
                C39129m k = new C39129m().mo62032k(MS);
                if (!this.mEl.mEu.contains(k.mDx)) {
                    C45966l c45966l = (C45966l) hashMap.get(Long.valueOf(k.mEB));
                    if (c45966l == null || C3161d.m5416f(C34202c.mCv, k.mDw, c45966l.mDw) < 0) {
                        k.bAo();
                        hashMap.put(Long.valueOf(k.mEB), k);
                    }
                }
            }
            MS.close();
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(124485);
                throw interruptedException;
            }
            c28109j.mEy = new ArrayList();
            c28109j.mEy.addAll(hashMap.values());
            if (this.mEl.mEv != null) {
                Collections.sort(c28109j.mEy, this.mEl.mEv);
            }
            AppMethodBeat.m2505o(124485);
        }

        public final String getName() {
            return "FTS5SearchFriendLogic.NormalSearchTask";
        }
    }

    /* renamed from: com.tencent.mm.w.b$1 */
    class C308561 implements C4937b {
        C308561() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(124474);
            if (C30851b.m49251Pr()) {
                String str = (obj == null || !(obj instanceof String)) ? null : (String) obj;
                switch (i) {
                    case 2:
                        if (str != null) {
                            C30851b.this.eAX.mo23853a(65636, new C30854f(str));
                            AppMethodBeat.m2505o(124474);
                            return;
                        }
                        break;
                    case 5:
                        if (str != null) {
                            C30851b.this.eAX.mo23853a(65636, new C30852d(str));
                            break;
                        }
                        C30851b.this.eAX.mo23853a(65636, new C24141c());
                        AppMethodBeat.m2505o(124474);
                        return;
                }
                AppMethodBeat.m2505o(124474);
                return;
            }
            AppMethodBeat.m2505o(124474);
        }
    }

    public C30851b() {
        AppMethodBeat.m2504i(124486);
        AppMethodBeat.m2505o(124486);
    }

    public final String getName() {
        return "FTS5SearchFriendLogic";
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(124487);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
            this.eAY = (C40925a) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(ActUtil.HEIGHT);
            this.eAX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon();
            this.eAX.mo23853a(131172, new C16074b(this, (byte) 0));
            ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg().mo10118a(this.eAZ);
            AppMethodBeat.m2505o(124487);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
        AppMethodBeat.m2505o(124487);
        return false;
    }

    /* renamed from: Pq */
    public final boolean mo23883Pq() {
        AppMethodBeat.m2504i(124488);
        ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg().mo10121b(this.eAZ);
        AppMethodBeat.m2505o(124488);
        return true;
    }

    /* renamed from: a */
    public final C28106a mo23884a(C20846i c20846i) {
        AppMethodBeat.m2504i(124489);
        C28106a a = this.eAX.mo23853a(-65536, new C30855g(c20846i));
        AppMethodBeat.m2505o(124489);
        return a;
    }

    /* renamed from: Pr */
    static /* synthetic */ boolean m49251Pr() {
        AppMethodBeat.m2504i(124490);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(124490);
            return false;
        }
        AppMethodBeat.m2505o(124490);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ int m49252a(C30851b c30851b, C30850a c30850a) {
        int i;
        String str;
        String str2;
        AppMethodBeat.m2504i(124491);
        long currentTimeMillis = System.currentTimeMillis();
        String nullAsNil = C5046bo.nullAsNil(c30850a.userName);
        int i2 = c30850a.status != 0 ? 131073 : 131074;
        if (c30850a.cFl == null || c30850a.cFl.length() <= 0) {
            i = 0;
        } else {
            c30851b.eAY.mo73839a(i2, 16, c30850a.f13771id, c30850a.userName, currentTimeMillis, c30850a.cFl);
            i = 1;
        }
        String str3 = c30850a.eBb;
        String str4 = c30850a.eBc;
        String str5 = c30850a.eBd;
        if (str3 != null && str3.length() > 0) {
            if (str3.equalsIgnoreCase(str4)) {
                str = null;
            } else {
                str = str4;
            }
            if (str == null || str.equalsIgnoreCase(str5)) {
                str2 = null;
            } else {
                str2 = str5;
            }
            c30851b.eAY.mo73839a(i2, 12, c30850a.f13771id, nullAsNil, currentTimeMillis, str3);
            i++;
            if (str != null) {
                c30851b.eAY.mo73839a(i2, 13, c30850a.f13771id, nullAsNil, currentTimeMillis, str);
                i++;
            }
            if (str2 != null) {
                c30851b.eAY.mo73839a(i2, 14, c30850a.f13771id, nullAsNil, currentTimeMillis, str2);
                i++;
            }
        }
        str3 = c30850a.bCu;
        str4 = c30850a.eBe;
        str5 = c30850a.eBf;
        if (str3 != null && str3.length() > 0) {
            if (str3.equalsIgnoreCase(str4)) {
                str = null;
            } else {
                str = str4;
            }
            if (str == null || str.equalsIgnoreCase(str5)) {
                str2 = null;
            } else {
                str2 = str5;
            }
            c30851b.eAY.mo73839a(i2, 5, c30850a.f13771id, nullAsNil, currentTimeMillis, str3);
            i++;
            if (str != null) {
                c30851b.eAY.mo73839a(i2, 6, c30850a.f13771id, nullAsNil, currentTimeMillis, str);
                i++;
            }
            if (str2 != null) {
                c30851b.eAY.mo73839a(i2, 7, c30850a.f13771id, nullAsNil, currentTimeMillis, str2);
                i++;
            }
        }
        AppMethodBeat.m2505o(124491);
        return i;
    }
}
