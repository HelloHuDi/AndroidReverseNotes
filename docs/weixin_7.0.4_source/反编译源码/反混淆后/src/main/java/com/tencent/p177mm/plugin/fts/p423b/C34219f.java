package com.tencent.p177mm.plugin.fts.p423b;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C6664ak;
import com.tencent.p177mm.plugin.fts.C45972d;
import com.tencent.p177mm.plugin.fts.PluginFTS;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.fts.b.f */
public final class C34219f implements C6664ak {
    /* renamed from: fk */
    public final void mo14893fk(long j) {
        AppMethodBeat.m2504i(136788);
        if (C1720g.m3531RK()) {
            try {
                C45972d fTSIndexDB = ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getFTSIndexDB();
                if (fTSIndexDB == null) {
                    C1720g.m3537RQ();
                    if (new File(C1720g.m3536RP().cachePath, "FTS5IndexMicroMsg_encrypt.db").exists()) {
                        C1720g.m3537RQ();
                        fTSIndexDB = new C45972d(C1720g.m3536RP().cachePath);
                        C45124d.m82929i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteSingleMsg by create new ftsIndexDB");
                    } else {
                        AppMethodBeat.m2505o(136788);
                        return;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                String str = "FTS5MetaMessage";
                String format = String.format("UPDATE %s SET status=? WHERE entity_id=?;", new Object[]{str});
                fTSIndexDB.mBd.execSQL(format, new String[]{"-1", String.valueOf(j)});
                fTSIndexDB.execSQL(String.format("DELETE FROM %s WHERE rowid IN (SELECT docid FROM %s WHERE entity_id=?);", new Object[]{"FTS5IndexMessage", str}), new String[]{String.valueOf(j)});
                fTSIndexDB.execSQL(String.format("DELETE FROM %s WHERE entity_id=?", new Object[]{str}), new String[]{String.valueOf(j)});
                C4990ab.m7417i("MicroMsg.FTS.FTSIndexDB", "deleteMsgById use time %d msgId %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(j));
                AppMethodBeat.m2505o(136788);
                return;
            } catch (Exception e) {
                C45124d.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", e, "syncDeleteSingleMsg", new Object[0]);
                AppMethodBeat.m2505o(136788);
                return;
            }
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(136788);
        throw c1819b;
    }

    /* renamed from: o */
    public final void mo14894o(String str, long j) {
        AppMethodBeat.m2504i(136789);
        C45124d.m82930i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete fts talker msg %s %s", str, C14835h.formatTime("yyyy-MM-dd HH:mm:ss", j / 1000));
        if (C1720g.m3531RK()) {
            try {
                C45972d fTSIndexDB = ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getFTSIndexDB();
                if (fTSIndexDB == null) {
                    C1720g.m3537RQ();
                    if (new File(C1720g.m3536RP().cachePath, "FTS5IndexMicroMsg_encrypt.db").exists()) {
                        C1720g.m3537RQ();
                        fTSIndexDB = new C45972d(C1720g.m3536RP().cachePath);
                        C45124d.m82929i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteTalkerMsg by create new ftsIndexDB");
                    } else {
                        AppMethodBeat.m2505o(136789);
                        return;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                String str2 = "FTS5MetaMessage";
                fTSIndexDB.execSQL(String.format("DELETE FROM %s WHERE rowid IN (SELECT docid FROM %s WHERE aux_index=? AND timestamp <= ?);", new Object[]{"FTS5IndexMessage", str2}), new String[]{str, String.valueOf(j)});
                fTSIndexDB.execSQL(String.format("DELETE FROM %s WHERE aux_index=? AND timestamp <= ?", new Object[]{str2}), new String[]{str, String.valueOf(j)});
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                C4990ab.m7417i("MicroMsg.FTS.FTSIndexDB", "deleteTalkerMsgByTimestamp use time %d talker %s timestamp %s", Long.valueOf(currentTimeMillis2), str, C14835h.formatTime("yyyy-MM-dd HH:mm:ss", j / 1000));
                C7053e.pXa.mo8378a(729, 10, 1, false);
                if (currentTimeMillis2 > 500) {
                    C7053e.pXa.mo8378a(79, 11, 1, false);
                    AppMethodBeat.m2505o(136789);
                    return;
                } else if (currentTimeMillis2 > 1000) {
                    C7053e.pXa.mo8378a(79, 12, 1, false);
                    AppMethodBeat.m2505o(136789);
                    return;
                } else {
                    if (currentTimeMillis2 > 10000) {
                        C7053e.pXa.mo8378a(79, 13, 1, false);
                    }
                    AppMethodBeat.m2505o(136789);
                    return;
                }
            } catch (Exception e) {
                C45124d.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", e, "syncDeleteTalkerMsg", new Object[0]);
                AppMethodBeat.m2505o(136789);
                return;
            }
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(136789);
        throw c1819b;
    }

    /* renamed from: oq */
    public final void mo14895oq(String str) {
        AppMethodBeat.m2504i(136790);
        C45124d.m82930i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete mark talker msg delete %s", str);
        if (C1720g.m3531RK()) {
            try {
                C45972d fTSIndexDB = ((PluginFTS) C1720g.m3530M(PluginFTS.class)).getFTSIndexDB();
                if (fTSIndexDB == null) {
                    C1720g.m3537RQ();
                    if (new File(C1720g.m3536RP().cachePath, "FTS5IndexMicroMsg_encrypt.db").exists()) {
                        C1720g.m3537RQ();
                        fTSIndexDB = new C45972d(C1720g.m3536RP().cachePath);
                        C45124d.m82929i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncMarkTalkerMsgDelete by create new ftsIndexDB");
                    } else {
                        AppMethodBeat.m2505o(136790);
                        return;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                String format = String.format("UPDATE %s SET status=? WHERE aux_index=?;", new Object[]{"FTS5MetaMessage"});
                fTSIndexDB.mBd.execSQL(format, new String[]{"-1", str});
                C4990ab.m7417i("MicroMsg.FTS.FTSIndexDB", "markStatusByTalker use time %d talker %s status %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), str, Integer.valueOf(-1));
                AppMethodBeat.m2505o(136790);
                return;
            } catch (Exception e) {
                C45124d.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", e, "syncDeleteTalkerMsg", new Object[0]);
                AppMethodBeat.m2505o(136790);
                return;
            }
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(136790);
        throw c1819b;
    }
}
