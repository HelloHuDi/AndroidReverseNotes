package com.tencent.p177mm.plugin.fts.p423b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.fts.p1265c.C39137d;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C24765b;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20844h;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39129m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.fts.b.d */
public final class C39134d extends C24765b {
    private C12028m eAX;
    C39137d mGL;

    /* renamed from: com.tencent.mm.plugin.fts.b.d$b */
    public class C12047b extends C28106a {
        public final boolean execute() {
            AppMethodBeat.m2504i(136769);
            C39134d.this.mGL.mBT.execSQL(String.format("DELETE FROM %s ;", new Object[]{"FTS5MetaSOSHistory"}));
            AppMethodBeat.m2505o(136769);
            return true;
        }

        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.d$d */
    public class C12048d extends C20844h {
        public C12048d(C20846i c20846i) {
            super(c20846i);
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            Cursor rawQuery;
            AppMethodBeat.m2504i(136771);
            super.mo7437a(c28109j);
            c28109j.mEy = new ArrayList();
            C39137d c39137d = C39134d.this.mGL;
            String str = this.mEl.query;
            int i = this.mEl.mEt;
            if (str.trim().length() > 0) {
                str = C3161d.m5398B(new String[]{str});
                rawQuery = c39137d.mBT.rawQuery(String.format("SELECT history FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY timestamp desc LIMIT ".concat(String.valueOf(i)), new Object[]{"FTS5MetaSOSHistory", "FTS5IndexSOSHistory", "FTS5MetaSOSHistory", "FTS5IndexSOSHistory", "FTS5IndexSOSHistory", str}), null);
            } else {
                rawQuery = c39137d.mBT.rawQuery(String.format("SELECT history FROM %s ORDER BY timestamp desc LIMIT ".concat(String.valueOf(i)), new Object[]{"FTS5MetaSOSHistory"}), null);
            }
            while (rawQuery.moveToNext()) {
                str = rawQuery.getString(0);
                C39129m c39129m = new C39129m();
                c39129m.content = str;
                c28109j.mEy.add(c39129m);
            }
            rawQuery.close();
            AppMethodBeat.m2505o(136771);
        }

        public final String getName() {
            return "SearchSOSHistoryTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.d$c */
    public class C34218c extends C28106a {
        public String mGM;

        public final boolean execute() {
            AppMethodBeat.m2504i(136770);
            C39137d c39137d = C39134d.this.mGL;
            String str = this.mGM;
            c39137d.mBT.execSQL(String.format("DELETE FROM %s WHERE history = ?;", new Object[]{"FTS5MetaSOSHistory"}), new String[]{str});
            AppMethodBeat.m2505o(136770);
            return true;
        }

        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.d$a */
    public class C39135a extends C28106a {
        public String mGM;

        public final boolean execute() {
            AppMethodBeat.m2504i(136768);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.mGM);
            stringBuffer.append("​");
            stringBuffer.append(C3161d.m5410aL(this.mGM, false));
            stringBuffer.append("​");
            stringBuffer.append(C3161d.m5410aL(this.mGM, true));
            C39137d c39137d = C39134d.this.mGL;
            String str = this.mGM;
            String stringBuffer2 = stringBuffer.toString();
            Cursor rawQuery = c39137d.mBT.rawQuery(String.format("SELECT docid FROM %s WHERE history = ?", new Object[]{"FTS5MetaSOSHistory"}), new String[]{str});
            long j = -1;
            if (rawQuery.moveToNext()) {
                j = rawQuery.getLong(0);
            }
            rawQuery.close();
            if (j >= 0) {
                c39137d.mHl.bindLong(1, System.currentTimeMillis());
                c39137d.mHl.bindLong(2, j);
                c39137d.mHl.execute();
            } else {
                if (!c39137d.mBT.inTransaction()) {
                    c39137d.mBT.beginTransaction();
                }
                c39137d.mBU.bindString(1, stringBuffer2);
                c39137d.mBU.execute();
                c39137d.mBV.bindString(1, str);
                c39137d.mBV.bindLong(2, System.currentTimeMillis());
                c39137d.mBV.execute();
                if (c39137d.mBT.inTransaction()) {
                    c39137d.mBT.commit();
                }
            }
            AppMethodBeat.m2505o(136768);
            return true;
        }

        public final String getName() {
            return "AddSOSHistoryTask";
        }
    }

    public final String getName() {
        return "FTS5SearchSOSHistoryLogic";
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(136772);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
            this.mGL = (C39137d) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.eAX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon();
            AppMethodBeat.m2505o(136772);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
        AppMethodBeat.m2505o(136772);
        return false;
    }

    public final void addSOSHistory(String str) {
        AppMethodBeat.m2504i(136773);
        C39135a c39135a = new C39135a();
        c39135a.mGM = str;
        this.eAX.mo23853a(132072, c39135a);
        AppMethodBeat.m2505o(136773);
    }

    public final void deleteSOSHistory() {
        AppMethodBeat.m2504i(136774);
        this.eAX.mo23853a(132072, new C12047b());
        AppMethodBeat.m2505o(136774);
    }

    public final void deleteSOSHistory(String str) {
        AppMethodBeat.m2504i(136775);
        C34218c c34218c = new C34218c();
        c34218c.mGM = str;
        this.eAX.mo23853a(132072, c34218c);
        AppMethodBeat.m2505o(136775);
    }

    /* renamed from: a */
    public final C28106a mo23884a(C20846i c20846i) {
        AppMethodBeat.m2504i(136776);
        C12048d c12048d = new C12048d(c20846i);
        this.eAX.mo23853a(-65536, c12048d);
        AppMethodBeat.m2505o(136776);
        return c12048d;
    }

    /* renamed from: Pq */
    public final boolean mo23883Pq() {
        this.mGL = null;
        this.eAX = null;
        return true;
    }
}
