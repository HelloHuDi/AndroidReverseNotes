package com.tencent.mrs;

import android.app.Application;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.C1060a.C1023a;
import com.tencent.matrix.iocanary.C7463a;
import com.tencent.matrix.iocanary.p158a.C1075a;
import com.tencent.matrix.iocanary.p158a.C1075a.C1074a;
import com.tencent.matrix.mrs.core.IReportCallback;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.p155b.C6282a;
import com.tencent.matrix.p155b.C6283b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.p157d.C1070c.C1069a;
import com.tencent.matrix.resource.C7464b;
import com.tencent.matrix.resource.p163b.C1099a;
import com.tencent.matrix.resource.p163b.C1099a.C1098a;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.p170a.C1133a.C1132a;
import com.tencent.matrix.trace.p175f.C6293e;
import com.tencent.matrix.trace.p175f.C7468b;
import com.tencent.mrs.p656b.C7374c;
import com.tencent.mrs.p656b.C7585b;
import com.tencent.mrs.p656b.C7585b.C57751;
import com.tencent.mrs.util.MatrixReportBroadcast;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.sqlitelint.ISQLiteExecutionDelegate;
import com.tencent.sqlitelint.SQLiteLint.InstallEnv;
import com.tencent.sqlitelint.SQLiteLint.Options.Builder;
import com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import com.tencent.sqlitelint.config.SQLiteLintConfig.ConcernDb;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mrs.a */
public final class C5769a {
    private static C7585b AiV;
    private static C5772b AiW = new C5772b();

    /* renamed from: com.tencent.mrs.a$c */
    public static final class C5767c {
        private static Map<String, Boolean> AiX = new HashMap();
        private static SQLiteLintPlugin AiY;

        /* renamed from: a */
        public static void m8679a(SQLiteDatabase sQLiteDatabase, String str, long j) {
            if (C1060a.isInstalled()) {
                if (AiY == null) {
                    SQLiteLintPlugin sQLiteLintPlugin = (SQLiteLintPlugin) C1060a.m2339yK().mo4192F(SQLiteLintPlugin.class);
                    AiY = sQLiteLintPlugin;
                    if (sQLiteLintPlugin == null) {
                        return;
                    }
                }
                if (AiY.isPluginStarted()) {
                    C4990ab.m7419v("Matrix.Manager", "onSQLExecuted  String sql:%s,  timeCost:%d", str, Long.valueOf(j));
                    String path = sQLiteDatabase.getPath();
                    if (!AiX.containsKey(path)) {
                        InstallEnv installEnv = new InstallEnv(path, new C5771a(sQLiteDatabase));
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
                            concernDb.setWhiteListXml(C25738R.xml.f8502am);
                        } else if (concernedDbPath.endsWith("AppBrandComm.db")) {
                            concernDb.setWhiteListXml(C25738R.xml.f8469i);
                        } else if (concernedDbPath.endsWith("SnsMicroMsg.db")) {
                            concernDb.setWhiteListXml(C25738R.xml.f8567cf);
                        }
                        AiY.addConcernedDB(concernDb);
                        AiX.put(path, Boolean.TRUE);
                    }
                    AiY.notifySqlExecution(path, str, (int) j);
                }
            }
        }
    }

    /* renamed from: com.tencent.mrs.a$1 */
    static class C57701 implements C1069a {
        C57701() {
        }

        /* renamed from: v */
        public final void mo4208v(String str, String str2, Object... objArr) {
            C4990ab.m7419v(str, str2, objArr);
        }

        /* renamed from: i */
        public final void mo4206i(String str, String str2, Object... objArr) {
            C4990ab.m7417i(str, str2, objArr);
        }

        /* renamed from: w */
        public final void mo4209w(String str, String str2, Object... objArr) {
            C4990ab.m7421w(str, str2, objArr);
        }

        /* renamed from: d */
        public final void mo4204d(String str, String str2, Object... objArr) {
            C4990ab.m7411d(str, str2, objArr);
        }

        /* renamed from: e */
        public final void mo4205e(String str, String str2, Object... objArr) {
            C4990ab.m7413e(str, str2, objArr);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            C4990ab.printErrStackTrace(str, th, str2, objArr);
        }
    }

    /* renamed from: com.tencent.mrs.a$a */
    static final class C5771a implements ISQLiteExecutionDelegate {
        private final SQLiteDatabase mDb;

        C5771a(SQLiteDatabase sQLiteDatabase) {
            this.mDb = sQLiteDatabase;
        }

        public final Cursor rawQuery(String str, String... strArr) {
            if (this.mDb.isOpen()) {
                return this.mDb.rawQuery(str, strArr);
            }
            C4990ab.m7421w("Matrix.Manager", "rawQuery db close", new Object[0]);
            return null;
        }

        public final void execSQL(String str) {
            if (this.mDb.isOpen()) {
                this.mDb.execSQL(str);
            } else {
                C4990ab.m7421w("Matrix.Manager", "rawQuery db close", new Object[0]);
            }
        }
    }

    /* renamed from: com.tencent.mrs.a$b */
    static class C5772b implements IReportCallback {
        C5772b() {
        }

        public final void onStatusChanged(Map<String, Boolean> map) {
            String str = "Trace";
            for (String str2 : map.keySet()) {
                boolean booleanValue = ((Boolean) map.get(str2)).booleanValue();
                Iterator it = C1060a.m2339yK().bUC.iterator();
                while (it.hasNext()) {
                    C6283b c6283b = (C6283b) it.next();
                    if (c6283b == null) {
                        C4990ab.m7412e("Matrix.Manager", "plugin is null");
                    } else if (c6283b.getTag().equals(str) && str2.startsWith(str)) {
                        C7466a c7466a = (C7466a) c6283b;
                        if (c7466a == null) {
                            C4990ab.m7412e("Matrix.Manager", "change plugin to tracePlugin fail");
                        } else {
                            C6293e c6293e;
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
                                    c6293e = c7466a.bYw;
                                    break;
                                case 1:
                                    c6293e = c7466a.bYv;
                                    break;
                                case 2:
                                    c6293e = c7466a.bYx;
                                    break;
                                default:
                                    c6293e = null;
                                    break;
                            }
                            if (c6293e != null) {
                                if (booleanValue) {
                                    C4990ab.m7417i("Matrix.Manager", "%s#onStartTrace", str2);
                                    if (c6293e instanceof C7468b) {
                                        C7466a.m12838zv().onStart();
                                    }
                                    c6293e.mo14535zE();
                                } else {
                                    C4990ab.m7417i("Matrix.Manager", "%s#onCloseTrace", str2);
                                    c6293e.mo14536zF();
                                    if (c6293e instanceof C7468b) {
                                        C7466a.m12838zv().onStop();
                                    }
                                }
                            }
                        }
                    } else {
                        if (c6283b.getTag().equals(str2)) {
                            if (c6283b.isPluginStarted() && !booleanValue) {
                                C4990ab.m7417i("Matrix.Manager", "%sPlugin#onStop", r2);
                                c6283b.stop();
                            } else if (c6283b.isPluginStoped() && booleanValue) {
                                C4990ab.m7417i("Matrix.Manager", "%sPlugin#onStart", r2);
                                c6283b.start();
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean atG(String str) {
        return C5769a.isDebug() || C7243d.vxs || MatrixReport.with().isNeedReport(str);
    }

    private static SQLiteLintConfig dPb() {
        try {
            return new SQLiteLintConfig(SqlExecutionCallbackMode.CUSTOM_NOTIFY);
        } catch (Throwable th) {
            return new SQLiteLintConfig(SqlExecutionCallbackMode.CUSTOM_NOTIFY);
        }
    }

    private static boolean isDebug() {
        return C5047bp.dpL();
    }

    public static void dPc() {
        if (MatrixReport.isInstalled()) {
            C1070c.m2368i("Matrix.Manager", "matrix report set the uin", new Object[0]);
            MatrixReport with = MatrixReport.with();
            C1720g.m3534RN();
            with.setUin((long) C1668a.m3383QF());
            C7585b c7585b = AiV;
            Looper.getMainLooper();
            Looper.myQueue().addIdleHandler(new C57751());
            MatrixReportBroadcast.dPd();
            return;
        }
        C1070c.m2367e("Matrix.Manager", "setUin, matrix report is not installed, just return", new Object[0]);
    }

    public static void onDestroy() {
        if (MatrixReport.isInstalled()) {
            MatrixReport.with().onDestroy();
        } else {
            C1070c.m2367e("Matrix.Manager", "onDestroy, matrix report is not installed, just return", new Object[0]);
        }
    }

    public static void onForeground(boolean z) {
        if (MatrixReport.isInstalled()) {
            MatrixReport.with().onForeground(z);
            Iterator it = C1060a.m2339yK().bUC.iterator();
            while (it.hasNext()) {
                ((C6283b) it.next()).onForeground(z);
            }
            return;
        }
        C1070c.m2367e("Matrix.Manager", "onForeground, matrix report is not installed, just return", new Object[0]);
    }

    /* renamed from: j */
    public static void m8680j(Application application) {
        boolean z;
        C1060a.m2338a(new C57701());
        C7374c c7374c = new C7374c();
        C1070c.m2368i("Matrix.Manager", "Process:" + C4996ah.getProcessName() + ", IS_RC_VERSION:" + C7243d.vxp + ", isMonkeyEnv:" + C5047bp.dnM(), new Object[0]);
        C1070c.m2368i("Matrix.Manager", "BuildInfo.ENABLE_MATRIX:" + C5058f.ENABLE_MATRIX + ", ENABLE_MATRIX_TRACE:" + C5058f.ENABLE_MATRIX_TRACE + ", BuildInfo.ENABLE_FPS_ANALYSE:" + C5058f.ENABLE_FPS_ANALYSE, new Object[0]);
        boolean z2 = C5058f.ENABLE_MATRIX;
        boolean z3 = z2 && C5058f.ENABLE_MATRIX_TRACE;
        if (z2 && C5058f.ENABLE_FPS_ANALYSE) {
            z = true;
        } else {
            z = false;
        }
        C1070c.m2368i("Matrix.Manager", "matrixEnable:" + z2 + ", traceEnable:" + z3 + ", fpsEnable:" + z, new Object[0]);
        if (z2) {
            long j;
            C1070c.m2368i("Matrix.Manager", "try to init matrix report", new Object[0]);
            MatrixReport.Builder isReportProcess = new MatrixReport.Builder(C4996ah.getContext()).clientVersion((long) C7243d.vxo).isDebug(C5047bp.dnM()).revision(C5058f.REV).processName(C4996ah.getProcessName()).isReportProcess(C4996ah.bqo());
            if (C7243d.vxs) {
                j = 1;
            } else if (C7243d.vxr) {
                j = 2;
            } else if (C7243d.vxp) {
                j = 3;
            } else if (C7243d.vxq) {
                j = 4;
            } else {
                C1070c.m2367e("Matrix.Manager", "Error ClientVersion, ver:" + C7243d.vxo, new Object[0]);
                j = -1;
            }
            MatrixReport build = isReportProcess.publishType(j).build();
            MatrixReport.init(build, AiW);
            C1023a c1023a = new C1023a(application);
            if (z2 && build != null && C4996ah.bqo()) {
                C1132a c1132a = new C1132a();
                c1132a.bYH.bWX = c7374c;
                c1132a.bYH.bYA = C5769a.atG("Trace_FPS");
                c1132a.bYH.bYB = C5769a.atG("Trace_EvilMethod");
                c1132a.bYH.bYC = C5769a.atG("Trace_StartUp");
                c1132a.bYH.bYD = true;
                c1132a.bYH.bYF = "com.tencent.mm.app.WeChatSplashActivity;";
                c1132a.bYH.isDebug = true;
                c1132a.bYH.bYE = false;
                c1023a.mo4159a(new C7466a(c1132a.bYH));
            }
            if (z2) {
                C1098a c1098a = new C1098a();
                c1098a.bWX = c7374c;
                c1098a.bWV = C5047bp.dnM();
                c1023a.mo4159a(new C7464b(new C1099a(c1098a.bWX, c1098a.bWV, c1098a.bWW, (byte) 0)));
                C7464b.m12830a(application);
                C1074a c1074a = new C1074a();
                c1074a.bUG = c7374c;
                c1023a.mo4159a(new C7463a(new C1075a(c1074a.bUG, (byte) 0)));
                c1023a.mo4159a(new SQLiteLintPlugin(C5769a.dPb()));
            }
            AiV = new C7585b(application);
            c1023a.pluginListener = AiV;
            if (c1023a.pluginListener == null) {
                c1023a.pluginListener = new C6282a(c1023a.application);
            }
            C1060a.m2337a(new C1060a(c1023a.application, c1023a.pluginListener, c1023a.bUC, (byte) 0));
            Iterator it = C1060a.m2339yK().bUC.iterator();
            while (it.hasNext()) {
                ((C6283b) it.next()).start();
            }
        }
    }
}
