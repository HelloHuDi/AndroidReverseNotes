package com.tencent.p177mm.plugin.bbom;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.HandlerThread;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.p150mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mrs.C5769a.C5767c;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.C1244b;
import com.tencent.p177mm.app.C1245d;
import com.tencent.p177mm.app.WorkerProfile;
import com.tencent.p177mm.booter.C1326d;
import com.tencent.p177mm.booter.C32419e.C32420c;
import com.tencent.p177mm.booter.C32419e.C32421a;
import com.tencent.p177mm.booter.C32419e.C32422d;
import com.tencent.p177mm.booter.C32419e.C32423b;
import com.tencent.p177mm.booter.C41905v;
import com.tencent.p177mm.booter.MMReceivers.ExdeviceProcessReceiver;
import com.tencent.p177mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.p177mm.booter.MMReceivers.ToolsMpProcessReceiver;
import com.tencent.p177mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.p177mm.compatible.loader.C1439e;
import com.tencent.p177mm.compatible.loader.C26050f;
import com.tencent.p177mm.compatible.loader.C26050f.C260511;
import com.tencent.p177mm.compatible.p844d.C9238a;
import com.tencent.p177mm.compatible.p844d.C9238a.C9240a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.memory.p259a.p260a.C1803b;
import com.tencent.p177mm.memory.p259a.p260a.C1803b.C1802b;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26429k;
import com.tencent.p177mm.model.C32794m.C327956;
import com.tencent.p177mm.model.C32794m.C327965;
import com.tencent.p177mm.model.C32794m.C327977;
import com.tencent.p177mm.model.C32794m.C66751;
import com.tencent.p177mm.model.C32794m.C96712;
import com.tencent.p177mm.model.C32794m.C96723;
import com.tencent.p177mm.model.C32794m.C96734;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C32798u.C18639a;
import com.tencent.p177mm.model.C37904bo;
import com.tencent.p177mm.model.C42194e;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p263d.C31273b;
import com.tencent.p177mm.model.p263d.C31273b.C96583;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.modelfriend.C32815a.C26442a;
import com.tencent.p177mm.modelmulti.C42210a;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p1385l.C32722a;
import com.tencent.p177mm.p1385l.C32722a.C26350a;
import com.tencent.p177mm.p181af.C17872c;
import com.tencent.p177mm.p181af.C25746b;
import com.tencent.p177mm.p181af.C25747e;
import com.tencent.p177mm.p181af.C32221i;
import com.tencent.p177mm.p181af.C41205h;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C45138g;
import com.tencent.p177mm.p181af.C8908d;
import com.tencent.p177mm.p181af.C8909j.C8912c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p200ay.C1304a.C1302a;
import com.tencent.p177mm.p210ca.C18121b;
import com.tencent.p177mm.p213cd.C6395f;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.p612ui.C5493d;
import com.tencent.p177mm.p612ui.C5493d.C5491a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p612ui.MMAppMgr.Receiver;
import com.tencent.p177mm.p612ui.chatting.p618h.C40783b.C156841;
import com.tencent.p177mm.p612ui.chatting.p618h.C40783b.C156852;
import com.tencent.p177mm.p612ui.chatting.viewitems.C23850j.C23852a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.permission.C45473a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.auth.p1239a.C19934b;
import com.tencent.p177mm.plugin.ipcall.C21098d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12526d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12527m;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21279r.C21278a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21280t;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21281u;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3471l;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C39367q;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C46071g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.notification.C3559d;
import com.tencent.p177mm.plugin.p945e.C11545f;
import com.tencent.p177mm.plugin.p945e.C33941c;
import com.tencent.p177mm.plugin.p945e.C33942d;
import com.tencent.p177mm.plugin.p945e.C44733a;
import com.tencent.p177mm.plugin.p945e.C45841b;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.p498a.C3730c;
import com.tencent.p177mm.plugin.report.service.C34831i;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p591a.C44035d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C44047n;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.p1667a.C46487a;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.C15418a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C15430ab;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5142e;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.database.SQLiteTrace.TraceInfo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud */
public class PluginBigBallOfMud extends C7597f implements ApplicationLifeCycleBucket {
    private static final String TAG = "MicroMsg.PluginBigBallOfMud";
    public Application app;
    private final MMAppMgr appMgr = new MMAppMgr();
    private C1439e mProfileCompat;

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$13 */
    class C1117413 implements C26442a {
        C1117413() {
        }

        public final String agu() {
            AppMethodBeat.m2504i(18293);
            String string;
            if (C5059g.xyg) {
                string = C4996ah.getContext().getString(C25738R.string.dw2);
                AppMethodBeat.m2505o(18293);
                return string;
            }
            string = C4996ah.getContext().getString(C25738R.string.dw1);
            AppMethodBeat.m2505o(18293);
            return string;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$3 */
    class C111753 implements C32467c<C23852a> {
        C111753() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(18280);
            C23852a c23852a = new C23852a();
            AppMethodBeat.m2505o(18280);
            return c23852a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$11 */
    class C1999811 implements C32722a {
        C1999811() {
        }

        /* renamed from: F */
        public final String mo35237F(String str, int i) {
            AppMethodBeat.m2504i(18289);
            String rw;
            if (C17903f.m28103kq(str)) {
                rw = C25754e.m40909rw(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) i).dqJ);
                AppMethodBeat.m2505o(18289);
                return rw;
            }
            rw = C1831bh.aaf();
            AppMethodBeat.m2505o(18289);
            return rw;
        }

        /* renamed from: kq */
        public final boolean mo35240kq(String str) {
            AppMethodBeat.m2504i(18291);
            boolean kq = C17903f.m28103kq(str);
            AppMethodBeat.m2505o(18291);
            return kq;
        }

        /* renamed from: g */
        public final void mo35238g(C7620bi c7620bi) {
            AppMethodBeat.m2504i(18288);
            if (C17903f.m28103kq(c7620bi.field_talker)) {
                c7620bi.mo14791ix(C25754e.aae());
            }
            AppMethodBeat.m2505o(18288);
        }

        /* renamed from: h */
        public final String mo35239h(C7620bi c7620bi) {
            AppMethodBeat.m2504i(18290);
            if (C17903f.m28103kq(c7620bi.field_talker)) {
                String rw = C25754e.m40909rw(c7620bi.dqJ);
                AppMethodBeat.m2505o(18290);
                return rw;
            }
            AppMethodBeat.m2505o(18290);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$2 */
    class C199992 implements C32467c<C17872c> {
        C199992() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(18279);
            C17872c c17872c = new C17872c();
            AppMethodBeat.m2505o(18279);
            return c17872c;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$5 */
    class C200005 implements C32467c<C45138g> {
        C200005() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(18282);
            C45138g c45138g = new C45138g();
            AppMethodBeat.m2505o(18282);
            return c45138g;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$10 */
    class C2471410 implements C32467c<C8908d> {
        C2471410() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(18287);
            C8908d c8908d = new C8908d();
            AppMethodBeat.m2505o(18287);
            return c8908d;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$1 */
    class C247151 implements C5491a {
        C247151() {
        }

        /* renamed from: a */
        public final void mo11119a(long j, String str, String str2) {
            AppMethodBeat.m2504i(18278);
            C7053e.pXa.mo8381e(14976, Long.valueOf(j), str, str2);
            AppMethodBeat.m2505o(18278);
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$4 */
    class C247164 implements C32467c<C25746b> {
        C247164() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(18281);
            C25746b c25746b = new C25746b();
            AppMethodBeat.m2505o(18281);
            return c25746b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$12 */
    class C2471712 implements C9240a {
        C2471712() {
        }

        /* renamed from: u */
        public final void mo20660u(long j, long j2) {
            AppMethodBeat.m2504i(18292);
            C7060h.pYm.mo8378a(j, j2, 1, false);
            AppMethodBeat.m2505o(18292);
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$15 */
    class C2471815 implements C3471l {
        C2471815() {
        }

        /* renamed from: N */
        public final String mo7931N(C7620bi c7620bi) {
            String str;
            AppMethodBeat.m2504i(18296);
            int i = (c7620bi.field_bizChatId == -1 || !C17903f.m28103kq(c7620bi.field_talker)) ? 0 : 1;
            if (i != 0) {
                str = c7620bi.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c7620bi.field_bizChatId;
                C4990ab.m7411d(PluginBigBallOfMud.TAG, "mapNotifyInfo key:%s", str);
            } else {
                str = c7620bi.field_talker;
            }
            AppMethodBeat.m2505o(18296);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$18 */
    class C2471918 implements C46487a {
        C2471918() {
        }

        /* renamed from: rO */
        public final boolean mo41609rO(int i) {
            AppMethodBeat.m2504i(18299);
            if (i != 39 || C21098d.bGW()) {
                AppMethodBeat.m2505o(18299);
                return false;
            }
            AppMethodBeat.m2505o(18299);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$16 */
    class C2472016 implements C18639a {
        C2472016() {
        }

        /* renamed from: a */
        public final boolean mo33894a(String str, String str2, PInt pInt) {
            AppMethodBeat.m2504i(18297);
            if (C1855t.m3913mZ(str)) {
                if (C17903f.m28103kq(str)) {
                    if (C25754e.m40905rs(str2)) {
                        pInt.value = 5;
                    } else {
                        pInt.value = 4;
                    }
                } else if (C17903f.m28108rb(str)) {
                    pInt.value = 3;
                } else if (C17903f.m28109rc(str)) {
                    pInt.value = 0;
                } else if (C17903f.m28105qY(str)) {
                    pInt.value = 6;
                } else {
                    pInt.value = 7;
                }
                AppMethodBeat.m2505o(18297);
                return true;
            }
            AppMethodBeat.m2505o(18297);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$17 */
    class C2472117 implements C32467c<C21280t> {
        C2472117() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(18298);
            C3559d c3559d = new C3559d();
            AppMethodBeat.m2505o(18298);
            return c3559d;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$6 */
    class C247226 implements C32467c<C41728a> {
        C247226() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(18283);
            C41728a c41728a = new C41728a();
            AppMethodBeat.m2505o(18283);
            return c41728a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$7 */
    class C247237 implements C32467c<C41205h> {
        C247237() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(18284);
            C41205h c41205h = new C41205h();
            AppMethodBeat.m2505o(18284);
            return c41205h;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$8 */
    class C247248 implements C32467c<C32221i> {
        C247248() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(18285);
            C32221i c32221i = new C32221i();
            AppMethodBeat.m2505o(18285);
            return c32221i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$9 */
    class C247259 implements C32467c<C25747e> {
        C247259() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(18286);
            C25747e c25747e = new C25747e();
            AppMethodBeat.m2505o(18286);
            return c25747e;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMud$14 */
    class C2472614 implements SQLiteTrace {
        C2472614() {
        }

        /* JADX WARNING: Missing block: B:21:0x004d, code skipped:
            if (r10 >= r1.fpm) goto L_0x004f;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i, long j) {
            AppMethodBeat.m2504i(18294);
            try {
                C31273b abr = C31273b.abr();
                boolean isMainThread = C5004al.isMainThread();
                String path = sQLiteDatabase.getPath();
                C5767c.m8679a(sQLiteDatabase, str, j);
                if ((j > abr.fpl && isMainThread) || (j > abr.fpn && !isMainThread)) {
                    for (String str2 : C31273b.fpu) {
                        if (!isMainThread && path.contains(str2)) {
                            break;
                        }
                    }
                    if (i == 2 && isMainThread) {
                    }
                    if (abr.foQ) {
                        C4990ab.m7416i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                    } else {
                        String toUpperCase = str.trim().toUpperCase();
                        if (toUpperCase.startsWith("INSERT") || toUpperCase.startsWith("UPDATE") || toUpperCase.startsWith("DELETE") || toUpperCase.startsWith("COMMIT") || toUpperCase.startsWith("SELECT")) {
                            if (toUpperCase.startsWith("INSERT")) {
                                toUpperCase = toUpperCase.substring(0, toUpperCase.indexOf("(", 0));
                            } else if (toUpperCase.startsWith("COMMIT")) {
                                if (j > abr.fpo) {
                                    toUpperCase = toUpperCase + "task:" + C5046bo.dpG();
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
                        if (!C5046bo.isNullOrNil(toUpperCase)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            C31273b.m50471a("tid", String.valueOf(Thread.currentThread().getId()), stringBuilder);
                            C31273b.m50471a(SharePluginInfo.ISSUE_KEY_SQL, toUpperCase, stringBuilder);
                            C31273b.m50471a("lastTime", String.valueOf(j), stringBuilder);
                            C31273b.m50471a("foreground", C4872b.foreground ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, stringBuilder);
                            C31273b.m50471a("tname", Thread.currentThread().getName(), stringBuilder);
                            toUpperCase = stringBuilder.toString();
                            C4990ab.m7410d("MicroMsg.SQLTraceManager", "SQL Trace mark : ".concat(String.valueOf(toUpperCase)));
                            C9638aw.m17180RS().mo10302aa(new C96583(toUpperCase));
                        }
                        AppMethodBeat.m2505o(18294);
                        return;
                    }
                }
                AppMethodBeat.m2505o(18294);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SQLiteTrace", e, "Failed to send trace.", new Object[0]);
                AppMethodBeat.m2505o(18294);
            }
        }

        public final void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z) {
        }

        public final void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, long j, boolean z, List<TraceInfo<String>> list, List<TraceInfo<StackTraceElement[]>> list2) {
            int doL;
            AppMethodBeat.m2504i(18295);
            boolean z2 = WXHardCoderJNI.hcDBEnable;
            int i = WXHardCoderJNI.hcDBDelayWrite;
            int i2 = WXHardCoderJNI.hcDBCPU;
            int i3 = WXHardCoderJNI.hcDBIO;
            if (WXHardCoderJNI.hcDBThr) {
                doL = C1720g.m3539RS().doL();
            } else {
                doL = 0;
            }
            WXHardCoderJNI.startPerformance(z2, i, i2, i3, doL, WXHardCoderJNI.hcDBTimeoutBusy, 501, WXHardCoderJNI.hcDBActionWrite, PluginBigBallOfMud.TAG);
            AppMethodBeat.m2505o(18295);
        }

        public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
        }
    }

    public PluginBigBallOfMud() {
        AppMethodBeat.m2504i(18300);
        AppMethodBeat.m2505o(18300);
    }

    public String toString() {
        return "plugin-big-ball-of-mud";
    }

    public void installed() {
    }

    public void dependency() {
        AppMethodBeat.m2504i(18301);
        dependsOn(C19934b.class);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(18301);
    }

    public void configure(C1681g c1681g) {
        String str;
        C1439e c1439e;
        int i;
        AppMethodBeat.m2504i(18302);
        C5493d.m8285a(new C247151());
        ToolsProcessReceiver.m63506a(new C32422d());
        ToolsMpProcessReceiver.m63505a(new C32423b());
        SandBoxProcessReceiver.m73998a(new C32420c());
        ExdeviceProcessReceiver.m16682a(new C32421a());
        C44035d c44035d = (C44035d) C1720g.m3530M(C44035d.class);
        c44035d.setILightPushDelegate(new C33717j());
        c44035d.addNotifyReceiverCallback(new C44721o());
        c44035d.addICoreServiceLifecycleCallback(new C31341g());
        C4990ab.m7417i(TAG, "zero %s", c44035d);
        this.app = c1681g.f1233cc;
        C26483d.m42197d(this.app);
        long currentTimeMillis = System.currentTimeMillis();
        C26050f c26050f = new C26050f();
        Application application = this.app;
        String str2 = c1681g.eHT;
        if (str2 == null || str2.length() <= 0) {
            HandlerThread anM = C7305d.anM("ProfileFactoryImp_handlerThread");
            anM.start();
            str2 = (String) new C260511().mo10372b(new C7306ak(anM.getLooper()));
            anM.getLooper().quit();
            str = str2;
        } else {
            str = str2;
        }
        if (str == null) {
            C4990ab.m7412e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
            c1439e = null;
        } else {
            C4996ah.m7430ce(str);
            if (str.equals(C4996ah.getPackageName())) {
                c1439e = C26050f.m41593c(application, ".app.WorkerProfile");
            } else if (str.equals(C4996ah.getPackageName() + ":push")) {
                c1439e = C26050f.m41593c(application, ".app.PusherProfile");
            } else if (str.startsWith(C4996ah.getPackageName() + ":tools")) {
                c1439e = C26050f.m41593c(application, ".app.ToolsProfile");
            } else if (str.equals(C4996ah.getPackageName() + ":sandbox")) {
                c1439e = C26050f.m41593c(application, ".app.SandBoxProfile");
            } else if (str.equals(C4996ah.getPackageName() + ":exdevice")) {
                c1439e = C26050f.m41593c(application, ".app.ExDeviceProfile");
            } else if (str.equals(C4996ah.getPackageName() + ":TMAssistantDownloadSDKService")) {
                c1439e = C26050f.m41593c(application, ".app.TMAssistantProfile");
            } else if (str.equals(C4996ah.getPackageName() + ":nospace")) {
                c1439e = C26050f.m41593c(application, ".app.NoSpaceProfile");
            } else if (str.equals(C4996ah.getPackageName() + ":patch")) {
                c1439e = C26050f.m41593c(application, ".app.PatchProfile");
            } else if (str.startsWith(C4996ah.getPackageName() + ":appbrand")) {
                c1439e = C26050f.m41593c(application, ".app.AppBrandProfile");
            } else if (str.startsWith(C4996ah.getPackageName() + ":support")) {
                c1439e = C26050f.m41593c(application, ".app.SupportProfile");
            } else {
                C4872b.m7233A("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                c1439e = null;
            }
            C4990ab.m7421w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", str);
        }
        this.mProfileCompat = c1439e;
        if (!(this.mProfileCompat == null || c1681g.mo5181SG())) {
            C4990ab.m7416i(TAG, "before profile oncreate.");
            this.mProfileCompat.onCreate();
        }
        C4990ab.m7416i(TAG, "after profile oncreate.");
        C1245d.m2683aT(this.app.getApplicationContext());
        ((C6624h) c1681g).mProfileCompat = this.mProfileCompat;
        SharedPreferences sharedPreferences = c1681g.f1233cc.getSharedPreferences("system_config_prefs", 0);
        if (sharedPreferences != null) {
            i = sharedPreferences.getInt("default_uin", 0);
        } else {
            i = 0;
        }
        C4990ab.m7417i(TAG, "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", c1681g.eHT, Long.valueOf(C5046bo.m7566gb(C1244b.cdW)), Long.valueOf(C5046bo.m7566gb(currentTimeMillis)), Integer.valueOf(i), C5128ac.eSj, C6457e.eSl);
        C26350a.m41931a(new C1999811());
        C9238a.m16769a(new C2471712());
        if (c1681g.mo5181SG()) {
            String string;
            C32815a.fBa = new C1117413();
            C6395f.m10546a(new C2472614());
            C5142e.xHP = new C2471815();
            C32798u.m53581a(new C2472016());
            C21281u.m32654b(new C2472117());
            C42210a c42210a = new C42210a();
            C21278a.m32647a(69, c42210a);
            C21278a.m32647a(68, c42210a);
            C21278a.m32647a(22, c42210a);
            C21278a.m32647a(13, c42210a);
            C21278a.m32647a(15, c42210a);
            C21278a.m32647a(23, c42210a);
            C21278a.m32647a(25, c42210a);
            C21278a.m32647a(24, c42210a);
            C21278a.m32647a(33, c42210a);
            C21278a.m32647a(35, c42210a);
            C21278a.m32647a(44, c42210a);
            C21278a.m32647a(999999, c42210a);
            C21278a.m32647a(53, c42210a);
            C21278a.m32647a(204, c42210a);
            C1202f c45754c = new C45754c();
            ((C12526d) C1720g.m3528K(C12526d.class)).mo24448a(c45754c);
            C1720g.m3540Rg().mo14539a(681, c45754c);
            C21281u.m32651a(5, new C42783l());
            C21281u.m32651a(1, new C20013r());
            C21281u.m32651a(4, new C31342h());
            ((C19934b) C1720g.m3530M(C19934b.class)).addHandleAuthResponse(new C27499a());
            C46071g c42784m = new C42784m();
            ((C39367q) C1720g.m3528K(C39367q.class)).mo62263a((C12527m) c42784m);
            ((C39367q) C1720g.m3528K(C39367q.class)).mo62262a(c42784m);
            C42194e.m74429a(new C20003b());
            C45473a c45473a = new C45473a();
            new C20012q().dnU();
            C1720g.m3540Rg().mo14546b(138, C42785n.jEu);
            C1720g.m3540Rg().mo14546b(39, C42785n.jEu);
            C1720g.m3540Rg().mo14546b(268369922, C42785n.jEu);
            if (C42785n.jEu == null) {
                C42785n.jEu = new C42785n();
            }
            C1720g.m3540Rg().mo14539a(138, C42785n.jEu);
            C1720g.m3540Rg().mo14539a(39, C42785n.jEu);
            C1720g.m3540Rg().mo14539a(268369922, C42785n.jEu);
            C20010p.m30927cR(this.app);
            C1302a.m2777a("delchatroommember", new C66751());
            C1302a.m2777a("NewXmlChatRoomAccessVerifyApplication", new C96712());
            C1302a.m2777a("NewXmlChatRoomAccessVerifyApproval", new C96723());
            C1302a.m2777a("chatroommuteexpt", new C96734());
            C1302a.m2777a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", new C327965());
            C1302a.m2777a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", new C327956());
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14901a("NewXmlDisableChatRoomAccessVerifyApplication", new C327977());
            C1302a.m2777a("invokeMessage", new C156841());
            C1302a.m2777a("NewXmlOpenIMFriReqAcceptedInWxWork", new C156852());
            C37904bo.m64014Yu();
            C26429k.m42085Yu();
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
            C41905v c41905v = new C41905v(C1326d.m2839bo(this.app));
            c41905v.mo33553jE("MM");
            C1947ae.giF = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
            C1947ae.ghN = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.display_errcode"), false);
            C1947ae.ghO = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.display_msgstate"), false);
            C1947ae.ghP = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.network.simulate_fault"), false);
            C1947ae.ghQ = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.network.force_touch"), false);
            C1947ae.ghR = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
            C1947ae.ghS = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.crashIsExit"), false);
            C1947ae.gir = C5046bo.getInt(C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.datatransfer.times"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            C1947ae.gis = C5046bo.getInt(C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.datatransfer.duration"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            C1947ae.ghU = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.album_drop_table"), false);
            C1947ae.ghV = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.album_dle_file"), false);
            C1947ae.ghW = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.album_show_info"), false);
            C1947ae.ghX = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.location_help"), false);
            C1947ae.gia = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.force_soso"), false);
            C1947ae.gib = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.simulatePostServerError"), false);
            C1947ae.gic = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
            C1947ae.gid = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
            C1947ae.gig = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.filterfpnp"), false);
            C1947ae.gih = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.testForPull"), false);
            int a = C5046bo.m7512a(c41905v.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
            C1947ae.gie = a;
            if (a != 4 && C1947ae.gie > 0) {
                C15430ab.xIC = C1947ae.gie;
                C4990ab.m7412e("MicroMsg.WorkerDebugger", "cdn thread num " + C1947ae.gie);
            }
            C1947ae.gif = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
            C1947ae.gii = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.server.host.http"), "");
            C1947ae.gij = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.server.host.socket"), "");
            if (C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.show_full_version"), false)) {
                C5059g.xyd = true;
            }
            try {
                a = Integer.decode(c41905v.getString(".com.tencent.mm.debug.log.setversion")).intValue();
                C7243d.m12106Lw(a);
                new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
            } catch (Exception e) {
                C4990ab.m7416i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                string = c41905v.getString(".com.tencent.mm.debug.log.setapilevel");
                if (!C5046bo.isNullOrNil(string)) {
                    C7243d.eSg = "android-".concat(String.valueOf(string));
                    C7243d.vxk = "android-".concat(String.valueOf(string));
                    C7243d.vxm = String.valueOf(string);
                    C4872b.amf(string);
                    new StringBuilder("set up test protocal apilevel = ").append(C7243d.eSg).append(" ").append(C4872b.dnP());
                }
            } catch (Exception e2) {
                C4990ab.m7416i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                currentTimeMillis = Long.decode(c41905v.getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(C7243d.vxn).append(" new: ").append(currentTimeMillis);
                C7243d.vxn = currentTimeMillis;
            } catch (Exception e3) {
                C4990ab.m7416i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                c41905v.ecL.ebO = Integer.decode(c41905v.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            } catch (Exception e4) {
                C4990ab.m7416i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            try {
                boolean a2 = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean a3 = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.report.kvstat"), false);
                boolean a4 = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.report.clientpref"), false);
                boolean a5 = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.report.useraction"), false);
                C3730c.m6036a(a2, a3, a4, a5);
                new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
            } catch (Exception e5) {
                C4990ab.m7416i("MicroMsg.WorkerDebugger", "no debugger was got");
            }
            C1947ae.gim = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.update_test"), false);
            C1947ae.gin = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.scan_save_image"), false);
            C1947ae.gip = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.shake_get_config_list"), false);
            C1947ae.giq = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
            C1947ae.giu = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.jsapi.permission"), "");
            C4990ab.m7410d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + C1947ae.giu);
            C1947ae.giJ = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.cdn.front"), "");
            C1947ae.giK = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.cdn.zone"), "");
            C1947ae.giL = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
            C1947ae.giM = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
            C1947ae.giN = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.cdn.ptl"), "");
            C1947ae.giO = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.cdn.usestream"), false);
            C1947ae.giP = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.cdn.onlysendetl"), false);
            C1947ae.giQ = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.cdn.onlysendptl"), false);
            C1947ae.giS = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.cdn.enable_debug"), false);
            C1947ae.giT = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
            C1947ae.giU = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
            C1947ae.gja = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.bakmove_hardcode"), false);
            C4990ab.m7410d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + C1947ae.gja);
            C1947ae.gjb = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.bakmove_ip"), "");
            C1947ae.gjc = C5046bo.getInt(C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.bakmove_port"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            C1947ae.giX = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.cursormode_enabled"), true);
            C1947ae.gjD = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.disaster_ignore_interval"), false);
            C1947ae.gjE = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.disaster_ignore_expire"), false);
            C1947ae.gjF = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.disaster_ignore_remove"), false);
            C1947ae.gjn = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
            C1947ae.gjp = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
            C1947ae.gjo = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
            C1947ae.gjq = C5046bo.m7532bc(c41905v.getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
            C1947ae.gjx = C5046bo.m7517a(c41905v.mo33554jF(".com.tencent.mm.debug.netmock"), false);
            ComponentName gV = C5046bo.m7561gV(C4996ah.getContext());
            if (gV != null && gV.getPackageName().equals(C4996ah.getPackageName()) && gV.getClassName().equals(C4996ah.doy())) {
                WorkerProfile.m16161Ca().cfN = true;
                WorkerProfile.m16161Ca().cfO = true;
                C4990ab.m7417i(TAG, "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", gV.getPackageName(), gV.getClassName());
            } else {
                if (gV != null) {
                    C4990ab.m7417i(TAG, "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", gV.getPackageName(), gV.getClassName());
                } else {
                    C4990ab.m7416i(TAG, "start time check onCreate appOnCreate currentActivity == null");
                }
                if (!(gV == null || gV.getPackageName().equals(C4996ah.getPackageName()))) {
                    WorkerProfile.m16161Ca().cfN = true;
                }
            }
            C31273b.abr();
            C31273b.setup();
            AppLogic.setCallBack(new AppCallBack(C4996ah.getContext()));
            SmcLogic.setCallBack(new C34831i());
            C34831i.pYC = (WorkerProfile) this.mProfileCompat;
            C1449k.m3079a(C15418a.xxo, getClass().getClassLoader());
            try {
                BaseEvent.onCreate();
            } catch (Throwable th) {
                BaseEvent.onCreate();
            }
            SmcLogic.SetDebugFlag(C3730c.pXd);
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
            C4990ab.m7417i(string, str, objArr);
            try {
                if (C1443d.m3067fP(20)) {
                    C4990ab.m7416i(TAG, "weird");
                    SmcLogic.setUin(0);
                }
            } catch (Throwable th2) {
                C4990ab.printErrStackTrace(TAG, th2, "", new Object[0]);
            }
            C6983p c6983p = (C6983p) C1720g.m3530M(C6983p.class);
            C44035d c44035d2 = (C44035d) C1720g.m3530M(C44035d.class);
            new C33942d().after(c6983p).before(this);
            new C11545f().after((C45841b) new C45841b().after(c6983p).before(this)).before(this);
            new C33941c().after(c6983p).before(this);
            new C44733a().after(c44035d2);
            C25985d.dlK();
        }
        C44047n.m79171a(new C2471918());
        C8912c.m16075a(new C199992());
        C8912c.m16075a(new C111753());
        C8912c.m16075a(new C247164());
        C8912c.m16075a(new C200005());
        C8912c.m16075a(new C247226());
        C8912c.m16075a(new C247237());
        C8912c.m16075a(new C247248());
        C8912c.m16075a(new C247259());
        C8912c.m16075a(new C2471410());
        AppMethodBeat.m2505o(18302);
    }

    public void execute(C1681g c1681g) {
    }

    public void onTerminate() {
        AppMethodBeat.m2504i(18303);
        C4990ab.m7417i(TAG, "onTerminate(%s)", C4996ah.getProcessName());
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTerminate();
        }
        MMAppMgr mMAppMgr = this.appMgr;
        Application application = this.app;
        if (mMAppMgr.ymI != null) {
            application.unregisterReceiver(mMAppMgr.ymI);
        }
        AppMethodBeat.m2505o(18303);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(18304);
        Resources resources = C4996ah.getResources();
        if (resources instanceof C18121b) {
            ((C18121b) resources).onConfigurationChanged(configuration);
        }
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onConfigurationChanged(configuration);
        }
        AppMethodBeat.m2505o(18304);
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        AppMethodBeat.m2504i(18305);
        C4990ab.m7417i(TAG, "onTrimMemory, level = %d, process = %s", Integer.valueOf(i), C4996ah.getProcessName());
        if (this.mProfileCompat != null) {
            this.mProfileCompat.onTrimMemory(i);
        }
        C1803b Xr = C1803b.m3705Xr();
        C4990ab.m7416i("MicroMsg.CacheInvoke", "CacheInvoke onTrimMemory");
        for (C1802b Xs : Xr.fdN.values()) {
            Xs.mo5368Xs();
        }
        AppMethodBeat.m2505o(18305);
    }

    public void onCreate() {
    }

    public void onBaseContextAttached(Context context) {
    }
}
