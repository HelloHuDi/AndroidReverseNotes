package com.tencent.mm.plugin.bbom;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.os.Process;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsMpProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.e.c;
import com.tencent.mm.booter.v;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.k;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.mm.ui.d;
import com.tencent.mm.ui.d.a;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.database.SQLiteTrace.TraceInfo;
import java.util.List;
import java.util.Map;

public class PluginBigBallOfMud extends f implements ApplicationLifeCycleBucket {
    private static final String TAG = "MicroMsg.PluginBigBallOfMud";
    public Application app;
    private final MMAppMgr appMgr = new MMAppMgr();
    private e mProfileCompat;

    public PluginBigBallOfMud() {
        AppMethodBeat.i(18300);
        AppMethodBeat.o(18300);
    }

    public String toString() {
        return "plugin-big-ball-of-mud";
    }

    public void installed() {
    }

    public void dependency() {
        AppMethodBeat.i(18301);
        dependsOn(b.class);
        dependsOn(p.class);
        AppMethodBeat.o(18301);
    }

    public void configure(g gVar) {
        String str;
        e eVar;
        int i;
        AppMethodBeat.i(18302);
        d.a(new a() {
            public final void a(long j, String str, String str2) {
                AppMethodBeat.i(18278);
                com.tencent.mm.plugin.report.e.pXa.e(14976, Long.valueOf(j), str, str2);
                AppMethodBeat.o(18278);
            }
        });
        ToolsProcessReceiver.a(new com.tencent.mm.booter.e.d());
        ToolsMpProcessReceiver.a(new com.tencent.mm.booter.e.b());
        SandBoxProcessReceiver.a(new c());
        ExdeviceProcessReceiver.a(new com.tencent.mm.booter.e.a());
        com.tencent.mm.plugin.zero.a.d dVar = (com.tencent.mm.plugin.zero.a.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.zero.a.d.class);
        dVar.setILightPushDelegate(new j());
        dVar.addNotifyReceiverCallback(new o());
        dVar.addICoreServiceLifecycleCallback(new g());
        ab.i(TAG, "zero %s", dVar);
        this.app = gVar.cc;
        com.tencent.mm.modelstat.d.d(this.app);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.compatible.loader.f fVar = new com.tencent.mm.compatible.loader.f();
        Application application = this.app;
        String str2 = gVar.eHT;
        if (str2 == null || str2.length() <= 0) {
            HandlerThread anM = com.tencent.mm.sdk.g.d.anM("ProfileFactoryImp_handlerThread");
            anM.start();
            str2 = (String) new bj<String>() {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.i(93037);
                    String Mh = AnonymousClass1.Mh();
                    AppMethodBeat.o(93037);
                    return Mh;
                }

                private static String Mh() {
                    AppMethodBeat.i(93036);
                    while (true) {
                        String aw = bo.aw(ah.getContext(), Process.myPid());
                        if (aw == null) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                ab.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e, "", new Object[0]);
                            }
                        } else {
                            AppMethodBeat.o(93036);
                            return aw;
                        }
                    }
                }
            }.b(new ak(anM.getLooper()));
            anM.getLooper().quit();
            str = str2;
        } else {
            str = str2;
        }
        if (str == null) {
            ab.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
            eVar = null;
        } else {
            ah.ce(str);
            if (str.equals(ah.getPackageName())) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.WorkerProfile");
            } else if (str.equals(ah.getPackageName() + ":push")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.PusherProfile");
            } else if (str.startsWith(ah.getPackageName() + ":tools")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.ToolsProfile");
            } else if (str.equals(ah.getPackageName() + ":sandbox")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.SandBoxProfile");
            } else if (str.equals(ah.getPackageName() + ":exdevice")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.ExDeviceProfile");
            } else if (str.equals(ah.getPackageName() + ":TMAssistantDownloadSDKService")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.TMAssistantProfile");
            } else if (str.equals(ah.getPackageName() + ":nospace")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.NoSpaceProfile");
            } else if (str.equals(ah.getPackageName() + ":patch")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.PatchProfile");
            } else if (str.startsWith(ah.getPackageName() + ":appbrand")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.AppBrandProfile");
            } else if (str.startsWith(ah.getPackageName() + ":support")) {
                eVar = com.tencent.mm.compatible.loader.f.c(application, ".app.SupportProfile");
            } else {
                com.tencent.mm.sdk.a.b.A("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                eVar = null;
            }
            ab.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", str);
        }
        this.mProfileCompat = eVar;
        if (!(this.mProfileCompat == null || gVar.SG())) {
            ab.i(TAG, "before profile oncreate.");
            this.mProfileCompat.onCreate();
        }
        ab.i(TAG, "after profile oncreate.");
        com.tencent.mm.app.d.aT(this.app.getApplicationContext());
        ((h) gVar).mProfileCompat = this.mProfileCompat;
        SharedPreferences sharedPreferences = gVar.cc.getSharedPreferences("system_config_prefs", 0);
        if (sharedPreferences != null) {
            i = sharedPreferences.getInt("default_uin", 0);
        } else {
            i = 0;
        }
        ab.i(TAG, "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", gVar.eHT, Long.valueOf(bo.gb(com.tencent.mm.app.b.cdW)), Long.valueOf(bo.gb(currentTimeMillis)), Integer.valueOf(i), ac.eSj, com.tencent.mm.compatible.util.e.eSl);
        com.tencent.mm.l.a.a.a(new com.tencent.mm.l.a() {
            public final String F(String str, int i) {
                AppMethodBeat.i(18289);
                String rw;
                if (com.tencent.mm.aj.f.kq(str)) {
                    rw = com.tencent.mm.aj.a.e.rw(((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf((long) i).dqJ);
                    AppMethodBeat.o(18289);
                    return rw;
                }
                rw = bh.aaf();
                AppMethodBeat.o(18289);
                return rw;
            }

            public final boolean kq(String str) {
                AppMethodBeat.i(18291);
                boolean kq = com.tencent.mm.aj.f.kq(str);
                AppMethodBeat.o(18291);
                return kq;
            }

            public final void g(bi biVar) {
                AppMethodBeat.i(18288);
                if (com.tencent.mm.aj.f.kq(biVar.field_talker)) {
                    biVar.ix(com.tencent.mm.aj.a.e.aae());
                }
                AppMethodBeat.o(18288);
            }

            public final String h(bi biVar) {
                AppMethodBeat.i(18290);
                if (com.tencent.mm.aj.f.kq(biVar.field_talker)) {
                    String rw = com.tencent.mm.aj.a.e.rw(biVar.dqJ);
                    AppMethodBeat.o(18290);
                    return rw;
                }
                AppMethodBeat.o(18290);
                return null;
            }
        });
        com.tencent.mm.compatible.d.a.a(new com.tencent.mm.compatible.d.a.a() {
            public final void u(long j, long j2) {
                AppMethodBeat.i(18292);
                com.tencent.mm.plugin.report.service.h.pYm.a(j, j2, 1, false);
                AppMethodBeat.o(18292);
            }
        });
        if (gVar.SG()) {
            String string;
            com.tencent.mm.modelfriend.a.fBa = new com.tencent.mm.modelfriend.a.a() {
                public final String agu() {
                    AppMethodBeat.i(18293);
                    String string;
                    if (com.tencent.mm.sdk.platformtools.g.xyg) {
                        string = ah.getContext().getString(R.string.dw2);
                        AppMethodBeat.o(18293);
                        return string;
                    }
                    string = ah.getContext().getString(R.string.dw1);
                    AppMethodBeat.o(18293);
                    return string;
                }
            };
            com.tencent.mm.cd.f.a(new SQLiteTrace() {
                /* JADX WARNING: Missing block: B:21:0x004d, code skipped:
            if (r10 >= r1.fpm) goto L_0x004f;
     */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j) {
                    AppMethodBeat.i(18294);
                    try {
                        com.tencent.mm.model.d.b abr = com.tencent.mm.model.d.b.abr();
                        boolean isMainThread = al.isMainThread();
                        String path = sQLiteDatabase.getPath();
                        com.tencent.mrs.a.c.a(sQLiteDatabase, str, j);
                        if ((j > abr.fpl && isMainThread) || (j > abr.fpn && !isMainThread)) {
                            for (String str2 : com.tencent.mm.model.d.b.fpu) {
                                if (!isMainThread && path.contains(str2)) {
                                    break;
                                }
                            }
                            if (i == 2 && isMainThread) {
                            }
                            if (abr.foQ) {
                                ab.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                            } else {
                                String toUpperCase = str.trim().toUpperCase();
                                if (toUpperCase.startsWith("INSERT") || toUpperCase.startsWith("UPDATE") || toUpperCase.startsWith("DELETE") || toUpperCase.startsWith("COMMIT") || toUpperCase.startsWith("SELECT")) {
                                    if (toUpperCase.startsWith("INSERT")) {
                                        toUpperCase = toUpperCase.substring(0, toUpperCase.indexOf("(", 0));
                                    } else if (toUpperCase.startsWith("COMMIT")) {
                                        if (j > abr.fpo) {
                                            toUpperCase = toUpperCase + "task:" + bo.dpG();
                                        } else {
                                            toUpperCase = null;
                                        }
                                    }
                                    if (toUpperCase.length() > 512) {
                                        toUpperCase = toUpperCase.substring(0, 512) + "...";
                                    }
                                    if (!toUpperCase.trim().endsWith(";")) {
                                        toUpperCase = toUpperCase + ";";
                                    }
                                } else {
                                    toUpperCase = null;
                                }
                                if (!bo.isNullOrNil(toUpperCase)) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    com.tencent.mm.model.d.b.a("tid", String.valueOf(Thread.currentThread().getId()), stringBuilder);
                                    com.tencent.mm.model.d.b.a(SharePluginInfo.ISSUE_KEY_SQL, toUpperCase, stringBuilder);
                                    com.tencent.mm.model.d.b.a("lastTime", String.valueOf(j), stringBuilder);
                                    com.tencent.mm.model.d.b.a("foreground", com.tencent.mm.sdk.a.b.foreground ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, stringBuilder);
                                    com.tencent.mm.model.d.b.a("tname", Thread.currentThread().getName(), stringBuilder);
                                    toUpperCase = stringBuilder.toString();
                                    ab.d("MicroMsg.SQLTraceManager", "SQL Trace mark : ".concat(String.valueOf(toUpperCase)));
                                    aw.RS().aa(new com.tencent.mm.model.d.b.AnonymousClass3(toUpperCase));
                                }
                                AppMethodBeat.o(18294);
                                return;
                            }
                        }
                        AppMethodBeat.o(18294);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SQLiteTrace", e, "Failed to send trace.", new Object[0]);
                        AppMethodBeat.o(18294);
                    }
                }

                public final void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z) {
                }

                public final void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z, List<TraceInfo<String>> list, List<TraceInfo<StackTraceElement[]>> list2) {
                    int doL;
                    AppMethodBeat.i(18295);
                    boolean z2 = WXHardCoderJNI.hcDBEnable;
                    int i = WXHardCoderJNI.hcDBDelayWrite;
                    int i2 = WXHardCoderJNI.hcDBCPU;
                    int i3 = WXHardCoderJNI.hcDBIO;
                    if (WXHardCoderJNI.hcDBThr) {
                        doL = com.tencent.mm.kernel.g.RS().doL();
                    } else {
                        doL = 0;
                    }
                    WXHardCoderJNI.startPerformance(z2, i, i2, i3, doL, WXHardCoderJNI.hcDBTimeoutBusy, 501, WXHardCoderJNI.hcDBActionWrite, PluginBigBallOfMud.TAG);
                    AppMethodBeat.o(18295);
                }

                public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
                }
            });
            com.tencent.mm.storage.e.xHP = new l() {
                public final String N(bi biVar) {
                    String str;
                    AppMethodBeat.i(18296);
                    int i = (biVar.field_bizChatId == -1 || !com.tencent.mm.aj.f.kq(biVar.field_talker)) ? 0 : 1;
                    if (i != 0) {
                        str = biVar.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + biVar.field_bizChatId;
                        ab.d(PluginBigBallOfMud.TAG, "mapNotifyInfo key:%s", str);
                    } else {
                        str = biVar.field_talker;
                    }
                    AppMethodBeat.o(18296);
                    return str;
                }
            };
            u.a(new u.a() {
                public final boolean a(String str, String str2, PInt pInt) {
                    AppMethodBeat.i(18297);
                    if (t.mZ(str)) {
                        if (com.tencent.mm.aj.f.kq(str)) {
                            if (com.tencent.mm.aj.a.e.rs(str2)) {
                                pInt.value = 5;
                            } else {
                                pInt.value = 4;
                            }
                        } else if (com.tencent.mm.aj.f.rb(str)) {
                            pInt.value = 3;
                        } else if (com.tencent.mm.aj.f.rc(str)) {
                            pInt.value = 0;
                        } else if (com.tencent.mm.aj.f.qY(str)) {
                            pInt.value = 6;
                        } else {
                            pInt.value = 7;
                        }
                        AppMethodBeat.o(18297);
                        return true;
                    }
                    AppMethodBeat.o(18297);
                    return false;
                }
            });
            com.tencent.mm.plugin.messenger.foundation.a.u.b(new com.tencent.mm.ci.c<com.tencent.mm.plugin.messenger.foundation.a.t>() {
                public final /* synthetic */ Object get() {
                    AppMethodBeat.i(18298);
                    com.tencent.mm.plugin.notification.d dVar = new com.tencent.mm.plugin.notification.d();
                    AppMethodBeat.o(18298);
                    return dVar;
                }
            });
            com.tencent.mm.modelmulti.a aVar = new com.tencent.mm.modelmulti.a();
            r.a.a(69, aVar);
            r.a.a(68, aVar);
            r.a.a(22, aVar);
            r.a.a(13, aVar);
            r.a.a(15, aVar);
            r.a.a(23, aVar);
            r.a.a(25, aVar);
            r.a.a(24, aVar);
            r.a.a(33, aVar);
            r.a.a(35, aVar);
            r.a.a(44, aVar);
            r.a.a(999999, aVar);
            r.a.a(53, aVar);
            r.a.a(204, aVar);
            com.tencent.mm.ai.f cVar = new c();
            ((com.tencent.mm.plugin.messenger.foundation.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.d.class)).a(cVar);
            com.tencent.mm.kernel.g.Rg().a(681, cVar);
            com.tencent.mm.plugin.messenger.foundation.a.u.a(5, new l());
            com.tencent.mm.plugin.messenger.foundation.a.u.a(1, new r());
            com.tencent.mm.plugin.messenger.foundation.a.u.a(4, new h());
            ((b) com.tencent.mm.kernel.g.M(b.class)).addHandleAuthResponse(new a());
            com.tencent.mm.plugin.messenger.foundation.a.g mVar = new m();
            ((q) com.tencent.mm.kernel.g.K(q.class)).a((m) mVar);
            ((q) com.tencent.mm.kernel.g.K(q.class)).a(mVar);
            com.tencent.mm.model.e.a(new b());
            com.tencent.mm.permission.a aVar2 = new com.tencent.mm.permission.a();
            new q().dnU();
            com.tencent.mm.kernel.g.Rg().b(138, n.jEu);
            com.tencent.mm.kernel.g.Rg().b(39, n.jEu);
            com.tencent.mm.kernel.g.Rg().b(268369922, n.jEu);
            if (n.jEu == null) {
                n.jEu = new n();
            }
            com.tencent.mm.kernel.g.Rg().a(138, n.jEu);
            com.tencent.mm.kernel.g.Rg().a(39, n.jEu);
            com.tencent.mm.kernel.g.Rg().a(268369922, n.jEu);
            p.cR(this.app);
            com.tencent.mm.ay.a.a.a("delchatroommember", new com.tencent.mm.ay.a.a() {
                public final com.tencent.mm.ay.a a(Map<String, String> map, bi biVar) {
                    AppMethodBeat.i(5501);
                    com.tencent.mm.ay.e eVar = new com.tencent.mm.ay.e(map, biVar);
                    AppMethodBeat.o(5501);
                    return eVar;
                }
            });
            com.tencent.mm.ay.a.a.a("NewXmlChatRoomAccessVerifyApplication", new com.tencent.mm.ay.a.a() {
                public final com.tencent.mm.ay.a a(Map<String, String> map, bi biVar) {
                    AppMethodBeat.i(5502);
                    com.tencent.mm.ay.d dVar = new com.tencent.mm.ay.d(map, biVar);
                    AppMethodBeat.o(5502);
                    return dVar;
                }
            });
            com.tencent.mm.ay.a.a.a("NewXmlChatRoomAccessVerifyApproval", new com.tencent.mm.ay.a.a() {
                public final com.tencent.mm.ay.a a(Map<String, String> map, bi biVar) {
                    AppMethodBeat.i(5503);
                    com.tencent.mm.ay.b bVar = new com.tencent.mm.ay.b(map, biVar);
                    AppMethodBeat.o(5503);
                    return bVar;
                }
            });
            com.tencent.mm.ay.a.a.a("chatroommuteexpt", new com.tencent.mm.ay.a.a() {
                public final com.tencent.mm.ay.a a(Map<String, String> map, bi biVar) {
                    AppMethodBeat.i(5504);
                    com.tencent.mm.ay.c cVar = new com.tencent.mm.ay.c(map, biVar);
                    AppMethodBeat.o(5504);
                    return cVar;
                }
            });
            com.tencent.mm.ay.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", new com.tencent.mm.ay.a.a() {
                public final com.tencent.mm.ay.a a(Map<String, String> map, bi biVar) {
                    AppMethodBeat.i(5505);
                    com.tencent.mm.openim.c.a.b bVar = new com.tencent.mm.openim.c.a.b(map, biVar);
                    AppMethodBeat.o(5505);
                    return bVar;
                }
            });
            com.tencent.mm.ay.a.a.a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", new com.tencent.mm.ay.a.a() {
                public final com.tencent.mm.ay.a a(Map<String, String> map, bi biVar) {
                    AppMethodBeat.i(5506);
                    com.tencent.mm.openim.c.a.c cVar = new com.tencent.mm.openim.c.a.c(map, biVar);
                    AppMethodBeat.o(5506);
                    return cVar;
                }
            });
            ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("NewXmlDisableChatRoomAccessVerifyApplication", new n() {
                public final com.tencent.mm.ai.e.b a(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
                    AppMethodBeat.i(5507);
                    com.tencent.mm.ay.f fVar = new com.tencent.mm.ay.f();
                    if (map == null) {
                        try {
                            ab.e("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] values == null ");
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", e, "", new Object[0]);
                        }
                    } else {
                        String a = aa.a(aVar.eAB.vEB);
                        ab.i("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] type:%s, values size:%s", bo.nullAsNil(fVar.TYPE), Integer.valueOf(map.size()));
                        fVar.fLm = (String) map.get(".sysmsg.confirm_username");
                        fVar.fLn = bo.getLong((String) map.get(".sysmsg.newmsgid"), 0);
                        ab.i("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] mConfirmUsername:%s, mDisableMsgId:%s username:%s", fVar.fLm, Long.valueOf(fVar.fLn), a);
                        if (bo.isNullOrNil(a)) {
                            ab.e("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[handle] username is null!");
                        } else {
                            bi Q = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Q(a, fVar.fLn);
                            if (Q.field_msgId > 0 && !bo.isNullOrNil(Q.field_talker)) {
                                Q.dtQ();
                                ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().b(Q.field_msgSvrId, Q);
                            }
                        }
                    }
                    AppMethodBeat.o(5507);
                    return null;
                }
            });
            com.tencent.mm.ay.a.a.a("invokeMessage", new com.tencent.mm.ui.chatting.h.b.AnonymousClass1());
            com.tencent.mm.ay.a.a.a("NewXmlOpenIMFriReqAcceptedInWxWork", new com.tencent.mm.ui.chatting.h.b.AnonymousClass2());
            com.tencent.mm.model.bo.Yu();
            k.Yu();
            MMAppMgr mMAppMgr = this.appMgr;
            Application application2 = this.app;
            if (mMAppMgr.ymI == null) {
                mMAppMgr.ymI = new Receiver(mMAppMgr);
            }
            MMActivity.dxV();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mm.ui.ACTION_ACTIVE");
            intentFilter.addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            intentFilter.addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            intentFilter.addAction("MINIQB_OPEN_RET");
            application2.registerReceiver(mMAppMgr.ymI, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
            v vVar = new v(com.tencent.mm.booter.d.bo(this.app));
            vVar.jE("MM");
            ae.giF = bo.a(vVar.jF(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            ae.ghN = bo.a(vVar.jF(".com.tencent.mm.debug.test.display_errcode"), false);
            ae.ghO = bo.a(vVar.jF(".com.tencent.mm.debug.test.display_msgstate"), false);
            ae.ghP = bo.a(vVar.jF(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            ae.ghQ = bo.a(vVar.jF(".com.tencent.mm.debug.test.network.force_touch"), false);
            ae.ghR = bo.a(vVar.jF(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            ae.ghS = bo.a(vVar.jF(".com.tencent.mm.debug.test.crashIsExit"), false);
            ae.gir = bo.getInt(bo.bc(vVar.getString(".com.tencent.mm.debug.datatransfer.times"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            ae.gis = bo.getInt(bo.bc(vVar.getString(".com.tencent.mm.debug.datatransfer.duration"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            ae.ghU = bo.a(vVar.jF(".com.tencent.mm.debug.test.album_drop_table"), false);
            ae.ghV = bo.a(vVar.jF(".com.tencent.mm.debug.test.album_dle_file"), false);
            ae.ghW = bo.a(vVar.jF(".com.tencent.mm.debug.test.album_show_info"), false);
            ae.ghX = bo.a(vVar.jF(".com.tencent.mm.debug.test.location_help"), false);
            ae.gia = bo.a(vVar.jF(".com.tencent.mm.debug.test.force_soso"), false);
            ae.gib = bo.a(vVar.jF(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            ae.gic = bo.a(vVar.jF(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            ae.gid = bo.a(vVar.jF(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            ae.gig = bo.a(vVar.jF(".com.tencent.mm.debug.test.filterfpnp"), false);
            ae.gih = bo.a(vVar.jF(".com.tencent.mm.debug.test.testForPull"), false);
            int a = bo.a(vVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            ae.gie = a;
            if (a != 4 && ae.gie > 0) {
                com.tencent.mm.storage.ab.xIC = ae.gie;
                ab.e("MicroMsg.WorkerDebugger", "cdn thread num " + ae.gie);
            }
            ae.gif = bo.a(vVar.jF(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            ae.gii = bo.bc(vVar.getString(".com.tencent.mm.debug.server.host.http"), "");
            ae.gij = bo.bc(vVar.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (bo.a(vVar.jF(".com.tencent.mm.debug.test.show_full_version"), false)) {
                com.tencent.mm.sdk.platformtools.g.xyd = true;
            }
            try {
                a = Integer.decode(vVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
                com.tencent.mm.protocal.d.Lw(a);
                new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
            } catch (Exception e) {
                ab.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                string = vVar.getString(".com.tencent.mm.debug.log.setapilevel");
                if (!bo.isNullOrNil(string)) {
                    com.tencent.mm.protocal.d.eSg = "android-".concat(String.valueOf(string));
                    com.tencent.mm.protocal.d.vxk = "android-".concat(String.valueOf(string));
                    com.tencent.mm.protocal.d.vxm = String.valueOf(string);
                    com.tencent.mm.sdk.a.b.amf(string);
                    new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.eSg).append(" ").append(com.tencent.mm.sdk.a.b.dnP());
                }
            } catch (Exception e2) {
                ab.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                currentTimeMillis = Long.decode(vVar.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.vxn).append(" new: ").append(currentTimeMillis);
                com.tencent.mm.protocal.d.vxn = currentTimeMillis;
            } catch (Exception e3) {
                ab.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                vVar.ecL.ebO = Integer.decode(vVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            } catch (Exception e4) {
                ab.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                boolean a2 = bo.a(vVar.jF(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean a3 = bo.a(vVar.jF(".com.tencent.mm.debug.report.kvstat"), false);
                boolean a4 = bo.a(vVar.jF(".com.tencent.mm.debug.report.clientpref"), false);
                boolean a5 = bo.a(vVar.jF(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
                new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
            } catch (Exception e5) {
                ab.i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            ae.gim = bo.a(vVar.jF(".com.tencent.mm.debug.test.update_test"), false);
            ae.gin = bo.a(vVar.jF(".com.tencent.mm.debug.test.scan_save_image"), false);
            ae.gip = bo.a(vVar.jF(".com.tencent.mm.debug.test.shake_get_config_list"), false);
            ae.giq = bo.a(vVar.jF(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
            ae.giu = bo.bc(vVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
            ab.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + ae.giu);
            ae.giJ = bo.bc(vVar.getString(".com.tencent.mm.debug.cdn.front"), "");
            ae.giK = bo.bc(vVar.getString(".com.tencent.mm.debug.cdn.zone"), "");
            ae.giL = bo.bc(vVar.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
            ae.giM = bo.bc(vVar.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
            ae.giN = bo.bc(vVar.getString(".com.tencent.mm.debug.cdn.ptl"), "");
            ae.giO = bo.a(vVar.jF(".com.tencent.mm.debug.cdn.usestream"), false);
            ae.giP = bo.a(vVar.jF(".com.tencent.mm.debug.cdn.onlysendetl"), false);
            ae.giQ = bo.a(vVar.jF(".com.tencent.mm.debug.cdn.onlysendptl"), false);
            ae.giS = bo.a(vVar.jF(".com.tencent.mm.debug.cdn.enable_debug"), false);
            ae.giT = bo.a(vVar.jF(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
            ae.giU = bo.a(vVar.jF(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
            ae.gja = bo.a(vVar.jF(".com.tencent.mm.debug.bakmove_hardcode"), false);
            ab.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + ae.gja);
            ae.gjb = bo.bc(vVar.getString(".com.tencent.mm.debug.bakmove_ip"), "");
            ae.gjc = bo.getInt(bo.bc(vVar.getString(".com.tencent.mm.debug.bakmove_port"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            ae.giX = bo.a(vVar.jF(".com.tencent.mm.debug.cursormode_enabled"), true);
            ae.gjD = bo.a(vVar.jF(".com.tencent.mm.debug.disaster_ignore_interval"), false);
            ae.gjE = bo.a(vVar.jF(".com.tencent.mm.debug.disaster_ignore_expire"), false);
            ae.gjF = bo.a(vVar.jF(".com.tencent.mm.debug.disaster_ignore_remove"), false);
            ae.gjn = bo.a(vVar.jF(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
            ae.gjp = bo.bc(vVar.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
            ae.gjo = bo.a(vVar.jF(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
            ae.gjq = bo.bc(vVar.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
            ae.gjx = bo.a(vVar.jF(".com.tencent.mm.debug.netmock"), false);
            ComponentName gV = bo.gV(ah.getContext());
            if (gV != null && gV.getPackageName().equals(ah.getPackageName()) && gV.getClassName().equals(ah.doy())) {
                WorkerProfile.Ca().cfN = true;
                WorkerProfile.Ca().cfO = true;
                ab.i(TAG, "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", gV.getPackageName(), gV.getClassName());
            } else {
                if (gV != null) {
                    ab.i(TAG, "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", gV.getPackageName(), gV.getClassName());
                } else {
                    ab.i(TAG, "start time check onCreate appOnCreate currentActivity == null");
                }
                if (!(gV == null || gV.getPackageName().equals(ah.getPackageName()))) {
                    WorkerProfile.Ca().cfN = true;
                }
            }
            com.tencent.mm.model.d.b.abr();
            com.tencent.mm.model.d.b.setup();
            AppLogic.setCallBack(new AppCallBack(ah.getContext()));
            SmcLogic.setCallBack(new i());
            i.pYC = (WorkerProfile) this.mProfileCompat;
            com.tencent.mm.compatible.util.k.a(com.tencent.mm.sdk.a.xxo, getClass().getClassLoader());
            try {
                BaseEvent.onCreate();
            } catch (Throwable th) {
                BaseEvent.onCreate();
            }
            SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.pXd);
            string = TAG;
            str = "SmcLogic, class loader %s, %s";
            Object[] objArr = new Object[2];
            if (getClass().getClassLoader() == null) {
                i = -1;
            } else {
                i = getClass().getClassLoader().hashCode();
            }
            objArr[0] = Integer.valueOf(i);
            if (Thread.currentThread().getContextClassLoader() == null) {
                i = -1;
            } else {
                i = Thread.currentThread().getContextClassLoader().hashCode();
            }
            objArr[1] = Integer.valueOf(i);
            ab.i(string, str, objArr);
            try {
                if (com.tencent.mm.compatible.util.d.fP(20)) {
                    ab.i(TAG, "weird");
                    SmcLogic.setUin(0);
                }
            } catch (Throwable th2) {
                ab.printErrStackTrace(TAG, th2, "", new Object[0]);
            }
            p pVar = (p) com.tencent.mm.kernel.g.M(p.class);
            com.tencent.mm.plugin.zero.a.d dVar2 = (com.tencent.mm.plugin.zero.a.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.zero.a.d.class);
            new com.tencent.mm.plugin.e.d().after(pVar).before(this);
            new com.tencent.mm.plugin.e.f().after((com.tencent.mm.plugin.e.b) new com.tencent.mm.plugin.e.b().after(pVar).before(this)).before(this);
            new com.tencent.mm.plugin.e.c().after(pVar).before(this);
            new com.tencent.mm.plugin.e.a().after(dVar2);
            com.tencent.mm.bp.d.dlK();
        }
        com.tencent.mm.pluginsdk.g.a.a.n.a(new com.tencent.mm.pluginsdk.g.a.a.a.a() {
            public final boolean rO(int i) {
                AppMethodBeat.i(18299);
                if (i != 39 || com.tencent.mm.plugin.ipcall.d.bGW()) {
                    AppMethodBeat.o(18299);
                    return false;
                }
                AppMethodBeat.o(18299);
                return true;
            }
        });
        com.tencent.mm.af.j.c.a(new com.tencent.mm.ci.c<com.tencent.mm.af.c>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(18279);
                com.tencent.mm.af.c cVar = new com.tencent.mm.af.c();
                AppMethodBeat.o(18279);
                return cVar;
            }
        });
        com.tencent.mm.af.j.c.a(new com.tencent.mm.ci.c<com.tencent.mm.ui.chatting.viewitems.j.a>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(18280);
                com.tencent.mm.ui.chatting.viewitems.j.a aVar = new com.tencent.mm.ui.chatting.viewitems.j.a();
                AppMethodBeat.o(18280);
                return aVar;
            }
        });
        com.tencent.mm.af.j.c.a(new com.tencent.mm.ci.c<com.tencent.mm.af.b>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(18281);
                com.tencent.mm.af.b bVar = new com.tencent.mm.af.b();
                AppMethodBeat.o(18281);
                return bVar;
            }
        });
        com.tencent.mm.af.j.c.a(new com.tencent.mm.ci.c<com.tencent.mm.af.g>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(18282);
                com.tencent.mm.af.g gVar = new com.tencent.mm.af.g();
                AppMethodBeat.o(18282);
                return gVar;
            }
        });
        com.tencent.mm.af.j.c.a(new com.tencent.mm.ci.c<com.tencent.mm.af.a>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(18283);
                com.tencent.mm.af.a aVar = new com.tencent.mm.af.a();
                AppMethodBeat.o(18283);
                return aVar;
            }
        });
        com.tencent.mm.af.j.c.a(new com.tencent.mm.ci.c<com.tencent.mm.af.h>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(18284);
                com.tencent.mm.af.h hVar = new com.tencent.mm.af.h();
                AppMethodBeat.o(18284);
                return hVar;
            }
        });
        com.tencent.mm.af.j.c.a(new com.tencent.mm.ci.c<com.tencent.mm.af.i>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(18285);
                com.tencent.mm.af.i iVar = new com.tencent.mm.af.i();
                AppMethodBeat.o(18285);
                return iVar;
            }
        });
        com.tencent.mm.af.j.c.a(new com.tencent.mm.ci.c<com.tencent.mm.af.e>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(18286);
                com.tencent.mm.af.e eVar = new com.tencent.mm.af.e();
                AppMethodBeat.o(18286);
                return eVar;
            }
        });
        com.tencent.mm.af.j.c.a(new com.tencent.mm.ci.c<com.tencent.mm.af.d>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(18287);
                com.tencent.mm.af.d dVar = new com.tencent.mm.af.d();
                AppMethodBeat.o(18287);
                return dVar;
            }
        });
        AppMethodBeat.o(18302);
    }

    public void execute(g gVar) {
    }

    public void onTerminate() {
        AppMethodBeat.i(18303);
        ab.i(TAG, "onTerminate(%s)", ah.getProcessName());
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTerminate();
        }
        MMAppMgr mMAppMgr = this.appMgr;
        Application application = this.app;
        if (mMAppMgr.ymI != null) {
            application.unregisterReceiver(mMAppMgr.ymI);
        }
        AppMethodBeat.o(18303);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(18304);
        Resources resources = ah.getResources();
        if (resources instanceof com.tencent.mm.ca.b) {
            ((com.tencent.mm.ca.b) resources).onConfigurationChanged(configuration);
        }
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(18304);
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        AppMethodBeat.i(18305);
        ab.i(TAG, "onTrimMemory, level = %d, process = %s", Integer.valueOf(i), ah.getProcessName());
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTrimMemory(i);
        }
        com.tencent.mm.memory.a.a.b Xr = com.tencent.mm.memory.a.a.b.Xr();
        ab.i("MicroMsg.CacheInvoke", "CacheInvoke onTrimMemory");
        for (com.tencent.mm.memory.a.a.b.b Xs : Xr.fdN.values()) {
            Xs.Xs();
        }
        AppMethodBeat.o(18305);
    }

    public void onCreate() {
    }

    public void onBaseContextAttached(Context context) {
    }
}
