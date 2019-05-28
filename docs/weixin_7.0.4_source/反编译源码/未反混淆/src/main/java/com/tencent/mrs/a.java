package com.tencent.mrs;

import android.app.Application;
import android.database.Cursor;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.d.c;
import com.tencent.matrix.mrs.core.IReportCallback;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.trace.f.e;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mrs.util.MatrixReportBroadcast;
import com.tencent.sqlitelint.ISQLiteExecutionDelegate;
import com.tencent.sqlitelint.SQLiteLint.InstallEnv;
import com.tencent.sqlitelint.SQLiteLint.Options.Builder;
import com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import com.tencent.sqlitelint.config.SQLiteLintConfig.ConcernDb;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a {
    private static com.tencent.mrs.b.b AiV;
    private static b AiW = new b();

    public static final class c {
        private static Map<String, Boolean> AiX = new HashMap();
        private static SQLiteLintPlugin AiY;

        public static void a(SQLiteDatabase sQLiteDatabase, String str, long j) {
            if (com.tencent.matrix.a.isInstalled()) {
                if (AiY == null) {
                    SQLiteLintPlugin sQLiteLintPlugin = (SQLiteLintPlugin) com.tencent.matrix.a.yK().F(SQLiteLintPlugin.class);
                    AiY = sQLiteLintPlugin;
                    if (sQLiteLintPlugin == null) {
                        return;
                    }
                }
                if (AiY.isPluginStarted()) {
                    ab.v("Matrix.Manager", "onSQLExecuted  String sql:%s,  timeCost:%d", str, Long.valueOf(j));
                    String path = sQLiteDatabase.getPath();
                    if (!AiX.containsKey(path)) {
                        InstallEnv installEnv = new InstallEnv(path, new a(sQLiteDatabase));
                        Builder builder = new Builder();
                        builder.setReportBehaviour(true);
                        builder.setAlertBehaviour(false);
                        ConcernDb concernDb = new ConcernDb(installEnv, builder.build());
                        concernDb.enableAvoidAutoIncrementChecker();
                        concernDb.enableAvoidSelectAllChecker();
                        concernDb.enableExplainQueryPlanChecker();
                        concernDb.enableRedundantIndexChecker();
                        concernDb.enableWithoutRowIdBetterChecker();
                        concernDb.enablePreparedStatementBetterChecker();
                        String concernedDbPath = concernDb.getInstallEnv().getConcernedDbPath();
                        if (concernedDbPath.endsWith("EnMicroMsg.db")) {
                            concernDb.setWhiteListXml(R.xml.am);
                        } else if (concernedDbPath.endsWith("AppBrandComm.db")) {
                            concernDb.setWhiteListXml(R.xml.i);
                        } else if (concernedDbPath.endsWith("SnsMicroMsg.db")) {
                            concernDb.setWhiteListXml(R.xml.cf);
                        }
                        AiY.addConcernedDB(concernDb);
                        AiX.put(path, Boolean.TRUE);
                    }
                    AiY.notifySqlExecution(path, str, (int) j);
                }
            }
        }
    }

    static final class a implements ISQLiteExecutionDelegate {
        private final SQLiteDatabase mDb;

        a(SQLiteDatabase sQLiteDatabase) {
            this.mDb = sQLiteDatabase;
        }

        public final Cursor rawQuery(String str, String... strArr) {
            if (this.mDb.isOpen()) {
                return this.mDb.rawQuery(str, strArr);
            }
            ab.w("Matrix.Manager", "rawQuery db close", new Object[0]);
            return null;
        }

        public final void execSQL(String str) {
            if (this.mDb.isOpen()) {
                this.mDb.execSQL(str);
            } else {
                ab.w("Matrix.Manager", "rawQuery db close", new Object[0]);
            }
        }
    }

    static class b implements IReportCallback {
        b() {
        }

        public final void onStatusChanged(Map<String, Boolean> map) {
            String str = "Trace";
            for (String str2 : map.keySet()) {
                boolean booleanValue = ((Boolean) map.get(str2)).booleanValue();
                Iterator it = com.tencent.matrix.a.yK().bUC.iterator();
                while (it.hasNext()) {
                    com.tencent.matrix.b.b bVar = (com.tencent.matrix.b.b) it.next();
                    if (bVar == null) {
                        ab.e("Matrix.Manager", "plugin is null");
                    } else if (bVar.getTag().equals(str) && str2.startsWith(str)) {
                        com.tencent.matrix.trace.a aVar = (com.tencent.matrix.trace.a) bVar;
                        if (aVar == null) {
                            ab.e("Matrix.Manager", "change plugin to tracePlugin fail");
                        } else {
                            e eVar;
                            int i = -1;
                            switch (str2.hashCode()) {
                                case -1864660637:
                                    if (str2.equals("Trace_StartUp")) {
                                        i = 0;
                                        break;
                                    }
                                    break;
                                case -1566431569:
                                    if (str2.equals("Trace_FPS")) {
                                        i = 2;
                                        break;
                                    }
                                    break;
                                case -935762161:
                                    if (str2.equals("Trace_EvilMethod")) {
                                        i = 1;
                                        break;
                                    }
                                    break;
                            }
                            switch (i) {
                                case 0:
                                    eVar = aVar.bYw;
                                    break;
                                case 1:
                                    eVar = aVar.bYv;
                                    break;
                                case 2:
                                    eVar = aVar.bYx;
                                    break;
                                default:
                                    eVar = null;
                                    break;
                            }
                            if (eVar != null) {
                                if (booleanValue) {
                                    ab.i("Matrix.Manager", "%s#onStartTrace", str2);
                                    if (eVar instanceof com.tencent.matrix.trace.f.b) {
                                        com.tencent.matrix.trace.a.zv().onStart();
                                    }
                                    eVar.zE();
                                } else {
                                    ab.i("Matrix.Manager", "%s#onCloseTrace", str2);
                                    eVar.zF();
                                    if (eVar instanceof com.tencent.matrix.trace.f.b) {
                                        com.tencent.matrix.trace.a.zv().onStop();
                                    }
                                }
                            }
                        }
                    } else {
                        if (bVar.getTag().equals(str2)) {
                            if (bVar.isPluginStarted() && !booleanValue) {
                                ab.i("Matrix.Manager", "%sPlugin#onStop", r2);
                                bVar.stop();
                            } else if (bVar.isPluginStoped() && booleanValue) {
                                ab.i("Matrix.Manager", "%sPlugin#onStart", r2);
                                bVar.start();
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean atG(String str) {
        return isDebug() || d.vxs || MatrixReport.with().isNeedReport(str);
    }

    private static SQLiteLintConfig dPb() {
        try {
            return new SQLiteLintConfig(SqlExecutionCallbackMode.CUSTOM_NOTIFY);
        } catch (Throwable th) {
            return new SQLiteLintConfig(SqlExecutionCallbackMode.CUSTOM_NOTIFY);
        }
    }

    private static boolean isDebug() {
        return bp.dpL();
    }

    public static void dPc() {
        if (MatrixReport.isInstalled()) {
            com.tencent.matrix.d.c.i("Matrix.Manager", "matrix report set the uin", new Object[0]);
            MatrixReport with = MatrixReport.with();
            g.RN();
            with.setUin((long) com.tencent.mm.kernel.a.QF());
            com.tencent.mrs.b.b bVar = AiV;
            Looper.getMainLooper();
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    for (String str : b.this.AjR.keySet()) {
                        c.i("Matrix.PluginListener", "matrix report pending issues tag:%s, size:%d", str, Integer.valueOf(((ArrayList) b.this.AjR.get((String) r2.next())).size()));
                        Iterator it = r1.iterator();
                        while (it.hasNext()) {
                            com.tencent.matrix.c.b bVar = (com.tencent.matrix.c.b) it.next();
                            MatrixReport.with().report(bVar.tag, bVar.bWv);
                        }
                    }
                    b.this.AjR.clear();
                    return false;
                }
            });
            MatrixReportBroadcast.dPd();
            return;
        }
        com.tencent.matrix.d.c.e("Matrix.Manager", "setUin, matrix report is not installed, just return", new Object[0]);
    }

    public static void onDestroy() {
        if (MatrixReport.isInstalled()) {
            MatrixReport.with().onDestroy();
        } else {
            com.tencent.matrix.d.c.e("Matrix.Manager", "onDestroy, matrix report is not installed, just return", new Object[0]);
        }
    }

    public static void onForeground(boolean z) {
        if (MatrixReport.isInstalled()) {
            MatrixReport.with().onForeground(z);
            Iterator it = com.tencent.matrix.a.yK().bUC.iterator();
            while (it.hasNext()) {
                ((com.tencent.matrix.b.b) it.next()).onForeground(z);
            }
            return;
        }
        com.tencent.matrix.d.c.e("Matrix.Manager", "onForeground, matrix report is not installed, just return", new Object[0]);
    }

    public static void j(Application application) {
        boolean z;
        com.tencent.matrix.a.a(new com.tencent.matrix.d.c.a() {
            public final void v(String str, String str2, Object... objArr) {
                ab.v(str, str2, objArr);
            }

            public final void i(String str, String str2, Object... objArr) {
                ab.i(str, str2, objArr);
            }

            public final void w(String str, String str2, Object... objArr) {
                ab.w(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                ab.d(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                ab.e(str, str2, objArr);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                ab.printErrStackTrace(str, th, str2, objArr);
            }
        });
        com.tencent.mrs.b.c cVar = new com.tencent.mrs.b.c();
        com.tencent.matrix.d.c.i("Matrix.Manager", "Process:" + ah.getProcessName() + ", IS_RC_VERSION:" + d.vxp + ", isMonkeyEnv:" + bp.dnM(), new Object[0]);
        com.tencent.matrix.d.c.i("Matrix.Manager", "BuildInfo.ENABLE_MATRIX:" + f.ENABLE_MATRIX + ", ENABLE_MATRIX_TRACE:" + f.ENABLE_MATRIX_TRACE + ", BuildInfo.ENABLE_FPS_ANALYSE:" + f.ENABLE_FPS_ANALYSE, new Object[0]);
        boolean z2 = f.ENABLE_MATRIX;
        boolean z3 = z2 && f.ENABLE_MATRIX_TRACE;
        if (z2 && f.ENABLE_FPS_ANALYSE) {
            z = true;
        } else {
            z = false;
        }
        com.tencent.matrix.d.c.i("Matrix.Manager", "matrixEnable:" + z2 + ", traceEnable:" + z3 + ", fpsEnable:" + z, new Object[0]);
        if (z2) {
            long j;
            com.tencent.matrix.d.c.i("Matrix.Manager", "try to init matrix report", new Object[0]);
            MatrixReport.Builder isReportProcess = new MatrixReport.Builder(ah.getContext()).clientVersion((long) d.vxo).isDebug(bp.dnM()).revision(f.REV).processName(ah.getProcessName()).isReportProcess(ah.bqo());
            if (d.vxs) {
                j = 1;
            } else if (d.vxr) {
                j = 2;
            } else if (d.vxp) {
                j = 3;
            } else if (d.vxq) {
                j = 4;
            } else {
                com.tencent.matrix.d.c.e("Matrix.Manager", "Error ClientVersion, ver:" + d.vxo, new Object[0]);
                j = -1;
            }
            MatrixReport build = isReportProcess.publishType(j).build();
            MatrixReport.init(build, AiW);
            com.tencent.matrix.a.a aVar = new com.tencent.matrix.a.a(application);
            if (z2 && build != null && ah.bqo()) {
                com.tencent.matrix.trace.a.a.a aVar2 = new com.tencent.matrix.trace.a.a.a();
                aVar2.bYH.bWX = cVar;
                aVar2.bYH.bYA = atG("Trace_FPS");
                aVar2.bYH.bYB = atG("Trace_EvilMethod");
                aVar2.bYH.bYC = atG("Trace_StartUp");
                aVar2.bYH.bYD = true;
                aVar2.bYH.bYF = "com.tencent.mm.app.WeChatSplashActivity;";
                aVar2.bYH.isDebug = true;
                aVar2.bYH.bYE = false;
                aVar.a(new com.tencent.matrix.trace.a(aVar2.bYH));
            }
            if (z2) {
                com.tencent.matrix.resource.b.a.a aVar3 = new com.tencent.matrix.resource.b.a.a();
                aVar3.bWX = cVar;
                aVar3.bWV = bp.dnM();
                aVar.a(new com.tencent.matrix.resource.b(new com.tencent.matrix.resource.b.a(aVar3.bWX, aVar3.bWV, aVar3.bWW, (byte) 0)));
                com.tencent.matrix.resource.b.a(application);
                com.tencent.matrix.iocanary.a.a.a aVar4 = new com.tencent.matrix.iocanary.a.a.a();
                aVar4.bUG = cVar;
                aVar.a(new com.tencent.matrix.iocanary.a(new com.tencent.matrix.iocanary.a.a(aVar4.bUG, (byte) 0)));
                aVar.a(new SQLiteLintPlugin(dPb()));
            }
            AiV = new com.tencent.mrs.b.b(application);
            aVar.pluginListener = AiV;
            if (aVar.pluginListener == null) {
                aVar.pluginListener = new com.tencent.matrix.b.a(aVar.application);
            }
            com.tencent.matrix.a.a(new com.tencent.matrix.a(aVar.application, aVar.pluginListener, aVar.bUC, (byte) 0));
            Iterator it = com.tencent.matrix.a.yK().bUC.iterator();
            while (it.hasNext()) {
                ((com.tencent.matrix.b.b) it.next()).start();
            }
        }
    }
}
