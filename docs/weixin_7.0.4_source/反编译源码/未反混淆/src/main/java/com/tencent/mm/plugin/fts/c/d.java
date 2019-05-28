package com.tencent.mm.plugin.fts.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d implements i {
    private boolean aGx;
    private boolean bZq;
    public h mBT;
    public SQLiteStatement mBU;
    public SQLiteStatement mBV;
    public SQLiteStatement mHl;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return 0;
    }

    public d() {
        AppMethodBeat.i(136835);
        ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", "FTS5SOSHistoryStorage");
        AppMethodBeat.o(136835);
    }

    public final void create() {
        AppMethodBeat.i(136836);
        ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", "FTS5SOSHistoryStorage", Boolean.valueOf(this.bZq));
        if (!this.bZq) {
            int i;
            if (((n) g.M(n.class)).isFTSContextReady()) {
                this.mBT = ((n) g.M(n.class)).getFTSIndexDB();
                ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
                if (this.mBT.MT("FTS5IndexSOSHistory") && this.mBT.MT("FTS5MetaSOSHistory")) {
                    ab.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
                } else {
                    ab.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
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
                ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
                i = 0;
            }
            if (i != 0) {
                ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
                this.bZq = true;
            }
        }
        AppMethodBeat.o(136836);
    }

    public final void destroy() {
        AppMethodBeat.i(136837);
        ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", "FTS5SOSHistoryStorage", Boolean.valueOf(this.aGx), Boolean.valueOf(this.bZq));
        if (!this.aGx && this.bZq) {
            this.mBU.close();
            this.mHl.close();
            this.mBV.close();
            ab.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
            this.aGx = true;
        }
        AppMethodBeat.o(136837);
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

    public final String ck(String str, int i) {
        return null;
    }
}
