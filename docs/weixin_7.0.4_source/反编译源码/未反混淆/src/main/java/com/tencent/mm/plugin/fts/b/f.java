package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

public final class f implements ak {
    public final void fk(long j) {
        AppMethodBeat.i(136788);
        if (g.RK()) {
            try {
                d fTSIndexDB = ((PluginFTS) g.M(PluginFTS.class)).getFTSIndexDB();
                if (fTSIndexDB == null) {
                    g.RQ();
                    if (new File(g.RP().cachePath, "FTS5IndexMicroMsg_encrypt.db").exists()) {
                        g.RQ();
                        fTSIndexDB = new d(g.RP().cachePath);
                        com.tencent.luggage.g.d.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteSingleMsg by create new ftsIndexDB");
                    } else {
                        AppMethodBeat.o(136788);
                        return;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                String str = "FTS5MetaMessage";
                String format = String.format("UPDATE %s SET status=? WHERE entity_id=?;", new Object[]{str});
                fTSIndexDB.mBd.execSQL(format, new String[]{"-1", String.valueOf(j)});
                fTSIndexDB.execSQL(String.format("DELETE FROM %s WHERE rowid IN (SELECT docid FROM %s WHERE entity_id=?);", new Object[]{"FTS5IndexMessage", str}), new String[]{String.valueOf(j)});
                fTSIndexDB.execSQL(String.format("DELETE FROM %s WHERE entity_id=?", new Object[]{str}), new String[]{String.valueOf(j)});
                ab.i("MicroMsg.FTS.FTSIndexDB", "deleteMsgById use time %d msgId %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(j));
                AppMethodBeat.o(136788);
                return;
            } catch (Exception e) {
                com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", e, "syncDeleteSingleMsg", new Object[0]);
                AppMethodBeat.o(136788);
                return;
            }
        }
        b bVar = new b();
        AppMethodBeat.o(136788);
        throw bVar;
    }

    public final void o(String str, long j) {
        AppMethodBeat.i(136789);
        com.tencent.luggage.g.d.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete fts talker msg %s %s", str, h.formatTime("yyyy-MM-dd HH:mm:ss", j / 1000));
        if (g.RK()) {
            try {
                d fTSIndexDB = ((PluginFTS) g.M(PluginFTS.class)).getFTSIndexDB();
                if (fTSIndexDB == null) {
                    g.RQ();
                    if (new File(g.RP().cachePath, "FTS5IndexMicroMsg_encrypt.db").exists()) {
                        g.RQ();
                        fTSIndexDB = new d(g.RP().cachePath);
                        com.tencent.luggage.g.d.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteTalkerMsg by create new ftsIndexDB");
                    } else {
                        AppMethodBeat.o(136789);
                        return;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                String str2 = "FTS5MetaMessage";
                fTSIndexDB.execSQL(String.format("DELETE FROM %s WHERE rowid IN (SELECT docid FROM %s WHERE aux_index=? AND timestamp <= ?);", new Object[]{"FTS5IndexMessage", str2}), new String[]{str, String.valueOf(j)});
                fTSIndexDB.execSQL(String.format("DELETE FROM %s WHERE aux_index=? AND timestamp <= ?", new Object[]{str2}), new String[]{str, String.valueOf(j)});
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                ab.i("MicroMsg.FTS.FTSIndexDB", "deleteTalkerMsgByTimestamp use time %d talker %s timestamp %s", Long.valueOf(currentTimeMillis2), str, h.formatTime("yyyy-MM-dd HH:mm:ss", j / 1000));
                e.pXa.a(729, 10, 1, false);
                if (currentTimeMillis2 > 500) {
                    e.pXa.a(79, 11, 1, false);
                    AppMethodBeat.o(136789);
                    return;
                } else if (currentTimeMillis2 > 1000) {
                    e.pXa.a(79, 12, 1, false);
                    AppMethodBeat.o(136789);
                    return;
                } else {
                    if (currentTimeMillis2 > 10000) {
                        e.pXa.a(79, 13, 1, false);
                    }
                    AppMethodBeat.o(136789);
                    return;
                }
            } catch (Exception e) {
                com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", e, "syncDeleteTalkerMsg", new Object[0]);
                AppMethodBeat.o(136789);
                return;
            }
        }
        b bVar = new b();
        AppMethodBeat.o(136789);
        throw bVar;
    }

    public final void oq(String str) {
        AppMethodBeat.i(136790);
        com.tencent.luggage.g.d.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete mark talker msg delete %s", str);
        if (g.RK()) {
            try {
                d fTSIndexDB = ((PluginFTS) g.M(PluginFTS.class)).getFTSIndexDB();
                if (fTSIndexDB == null) {
                    g.RQ();
                    if (new File(g.RP().cachePath, "FTS5IndexMicroMsg_encrypt.db").exists()) {
                        g.RQ();
                        fTSIndexDB = new d(g.RP().cachePath);
                        com.tencent.luggage.g.d.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncMarkTalkerMsgDelete by create new ftsIndexDB");
                    } else {
                        AppMethodBeat.o(136790);
                        return;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                String format = String.format("UPDATE %s SET status=? WHERE aux_index=?;", new Object[]{"FTS5MetaMessage"});
                fTSIndexDB.mBd.execSQL(format, new String[]{"-1", str});
                ab.i("MicroMsg.FTS.FTSIndexDB", "markStatusByTalker use time %d talker %s status %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), str, Integer.valueOf(-1));
                AppMethodBeat.o(136790);
                return;
            } catch (Exception e) {
                com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", e, "syncDeleteTalkerMsg", new Object[0]);
                AppMethodBeat.o(136790);
                return;
            }
        }
        b bVar = new b();
        AppMethodBeat.o(136790);
        throw bVar;
    }
}
