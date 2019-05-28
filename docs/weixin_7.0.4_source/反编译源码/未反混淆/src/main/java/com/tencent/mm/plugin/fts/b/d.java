package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class d extends com.tencent.mm.plugin.fts.a.b {
    private m eAX;
    com.tencent.mm.plugin.fts.c.d mGL;

    public class b extends com.tencent.mm.plugin.fts.a.a.a {
        public final boolean execute() {
            AppMethodBeat.i(136769);
            d.this.mGL.mBT.execSQL(String.format("DELETE FROM %s ;", new Object[]{"FTS5MetaSOSHistory"}));
            AppMethodBeat.o(136769);
            return true;
        }

        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    public class d extends h {
        public d(i iVar) {
            super(iVar);
        }

        public final void a(j jVar) {
            Cursor rawQuery;
            AppMethodBeat.i(136771);
            super.a(jVar);
            jVar.mEy = new ArrayList();
            com.tencent.mm.plugin.fts.c.d dVar = d.this.mGL;
            String str = this.mEl.query;
            int i = this.mEl.mEt;
            if (str.trim().length() > 0) {
                str = com.tencent.mm.plugin.fts.a.d.B(new String[]{str});
                rawQuery = dVar.mBT.rawQuery(String.format("SELECT history FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY timestamp desc LIMIT ".concat(String.valueOf(i)), new Object[]{"FTS5MetaSOSHistory", "FTS5IndexSOSHistory", "FTS5MetaSOSHistory", "FTS5IndexSOSHistory", "FTS5IndexSOSHistory", str}), null);
            } else {
                rawQuery = dVar.mBT.rawQuery(String.format("SELECT history FROM %s ORDER BY timestamp desc LIMIT ".concat(String.valueOf(i)), new Object[]{"FTS5MetaSOSHistory"}), null);
            }
            while (rawQuery.moveToNext()) {
                str = rawQuery.getString(0);
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.content = str;
                jVar.mEy.add(mVar);
            }
            rawQuery.close();
            AppMethodBeat.o(136771);
        }

        public final String getName() {
            return "SearchSOSHistoryTask";
        }
    }

    public class c extends com.tencent.mm.plugin.fts.a.a.a {
        public String mGM;

        public final boolean execute() {
            AppMethodBeat.i(136770);
            com.tencent.mm.plugin.fts.c.d dVar = d.this.mGL;
            String str = this.mGM;
            dVar.mBT.execSQL(String.format("DELETE FROM %s WHERE history = ?;", new Object[]{"FTS5MetaSOSHistory"}), new String[]{str});
            AppMethodBeat.o(136770);
            return true;
        }

        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    public class a extends com.tencent.mm.plugin.fts.a.a.a {
        public String mGM;

        public final boolean execute() {
            AppMethodBeat.i(136768);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.mGM);
            stringBuffer.append("​");
            stringBuffer.append(com.tencent.mm.plugin.fts.a.d.aL(this.mGM, false));
            stringBuffer.append("​");
            stringBuffer.append(com.tencent.mm.plugin.fts.a.d.aL(this.mGM, true));
            com.tencent.mm.plugin.fts.c.d dVar = d.this.mGL;
            String str = this.mGM;
            String stringBuffer2 = stringBuffer.toString();
            Cursor rawQuery = dVar.mBT.rawQuery(String.format("SELECT docid FROM %s WHERE history = ?", new Object[]{"FTS5MetaSOSHistory"}), new String[]{str});
            long j = -1;
            if (rawQuery.moveToNext()) {
                j = rawQuery.getLong(0);
            }
            rawQuery.close();
            if (j >= 0) {
                dVar.mHl.bindLong(1, System.currentTimeMillis());
                dVar.mHl.bindLong(2, j);
                dVar.mHl.execute();
            } else {
                if (!dVar.mBT.inTransaction()) {
                    dVar.mBT.beginTransaction();
                }
                dVar.mBU.bindString(1, stringBuffer2);
                dVar.mBU.execute();
                dVar.mBV.bindString(1, str);
                dVar.mBV.bindLong(2, System.currentTimeMillis());
                dVar.mBV.execute();
                if (dVar.mBT.inTransaction()) {
                    dVar.mBT.commit();
                }
            }
            AppMethodBeat.o(136768);
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
        AppMethodBeat.i(136772);
        if (((n) g.M(n.class)).isFTSContextReady()) {
            ab.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
            this.mGL = (com.tencent.mm.plugin.fts.c.d) ((n) g.M(n.class)).getFTSIndexStorage(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.eAX = ((n) g.M(n.class)).getFTSTaskDaemon();
            AppMethodBeat.o(136772);
            return true;
        }
        ab.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
        AppMethodBeat.o(136772);
        return false;
    }

    public final void addSOSHistory(String str) {
        AppMethodBeat.i(136773);
        a aVar = new a();
        aVar.mGM = str;
        this.eAX.a(132072, aVar);
        AppMethodBeat.o(136773);
    }

    public final void deleteSOSHistory() {
        AppMethodBeat.i(136774);
        this.eAX.a(132072, new b());
        AppMethodBeat.o(136774);
    }

    public final void deleteSOSHistory(String str) {
        AppMethodBeat.i(136775);
        c cVar = new c();
        cVar.mGM = str;
        this.eAX.a(132072, cVar);
        AppMethodBeat.o(136775);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        AppMethodBeat.i(136776);
        d dVar = new d(iVar);
        this.eAX.a(-65536, dVar);
        AppMethodBeat.o(136776);
        return dVar;
    }

    public final boolean Pq() {
        this.mGL = null;
        this.eAX = null;
        return true;
    }
}
