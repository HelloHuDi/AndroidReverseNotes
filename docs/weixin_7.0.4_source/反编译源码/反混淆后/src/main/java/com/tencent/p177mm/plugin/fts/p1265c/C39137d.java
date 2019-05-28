package com.tencent.p177mm.plugin.fts.p1265c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C34206h;
import com.tencent.p177mm.plugin.fts.p419a.C34207i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wcdb.database.SQLiteStatement;

/* renamed from: com.tencent.mm.plugin.fts.c.d */
public final class C39137d implements C34207i {
    private boolean aGx;
    private boolean bZq;
    public C34206h mBT;
    public SQLiteStatement mBU;
    public SQLiteStatement mBV;
    public SQLiteStatement mHl;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return 0;
    }

    public C39137d() {
        AppMethodBeat.m2504i(136835);
        C4990ab.m7417i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", "FTS5SOSHistoryStorage");
        AppMethodBeat.m2505o(136835);
    }

    public final void create() {
        AppMethodBeat.m2504i(136836);
        C4990ab.m7417i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", "FTS5SOSHistoryStorage", Boolean.valueOf(this.bZq));
        if (!this.bZq) {
            int i;
            if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
                this.mBT = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexDB();
                C4990ab.m7416i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
                if (this.mBT.mo54780MT("FTS5IndexSOSHistory") && this.mBT.mo54780MT("FTS5MetaSOSHistory")) {
                    C4990ab.m7410d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
                } else {
                    C4990ab.m7410d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", new Object[]{"FTS5IndexSOSHistory"});
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", new Object[]{"FTS5MetaSOSHistory"});
                    this.mBT.execSQL(format);
                    this.mBT.execSQL(format2);
                    this.mBT.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[]{"FTS5IndexSOSHistory"}));
                    this.mBT.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, history TEXT, timestamp INTEGER);", new Object[]{"FTS5MetaSOSHistory"}));
                    this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_history ON %s(history);", new Object[]{"FTS5MetaSOSHistory"}));
                    this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[]{"FTS5MetaSOSHistory"}));
                }
                this.mBU = this.mBT.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{"FTS5IndexSOSHistory"}));
                this.mBV = this.mBT.compileStatement(String.format("INSERT INTO %s (docid, history, timestamp) VALUES (last_insert_rowid(), ?, ?);", new Object[]{"FTS5MetaSOSHistory"}));
                this.mHl = this.mBT.compileStatement(String.format("UPDATE %s SET timestamp=? WHERE docid = ?", new Object[]{"FTS5MetaSOSHistory"}));
                i = 1;
            } else {
                C4990ab.m7416i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
                i = 0;
            }
            if (i != 0) {
                C4990ab.m7416i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
                this.bZq = true;
            }
        }
        AppMethodBeat.m2505o(136836);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(136837);
        C4990ab.m7417i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", "FTS5SOSHistoryStorage", Boolean.valueOf(this.aGx), Boolean.valueOf(this.bZq));
        if (!this.aGx && this.bZq) {
            this.mBU.close();
            this.mHl.close();
            this.mBV.close();
            C4990ab.m7416i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
            this.aGx = true;
        }
        AppMethodBeat.m2505o(136837);
    }

    public final String getName() {
        return "FTS5SOSHistoryStorage";
    }

    public final int getType() {
        return WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    public final int getPriority() {
        return WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    /* renamed from: ck */
    public final String mo54789ck(String str, int i) {
        return null;
    }
}
