package com.tencent.p177mm.plugin.hardcoder;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.HardCoderJNI.SystemEventCallback;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.C1651a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p230g.p231a.C42008in;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.plugin.report.C7051c;
import com.tencent.p177mm.plugin.zero.p591a.C44035d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.hardcoder.PluginHardcoder */
public class PluginHardcoder extends C7597f implements C9562c, C12218b {
    private C4931a foI = new C69432();
    private C4884c nqj = new C343303();
    private Runnable nqk = new C32834();

    /* renamed from: com.tencent.mm.plugin.hardcoder.PluginHardcoder$1 */
    class C32811 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.hardcoder.PluginHardcoder$1$1 */
        class C32821 implements SystemEventCallback {
            C32821() {
            }

            public final void onEvent(int i) {
                AppMethodBeat.m2504i(60248);
                C4990ab.m7417i("MicroMsg.PluginHardcoder", "configure SystemEventCallback onEvent eventCode[%d]", Integer.valueOf(i));
                C42008in c42008in = new C42008in();
                c42008in.cDG.keycode = i;
                C4879a.xxA.mo10055m(c42008in);
                AppMethodBeat.m2505o(60248);
            }
        }

        C32811() {
        }

        public final void run() {
            AppMethodBeat.m2504i(60249);
            Thread currentThread = Thread.currentThread();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            WXHardCoderJNI.initHardCoder(C34331a.bFR(), C34331a.bFR());
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            C4990ab.m7417i("MicroMsg.PluginHardcoder", "configure initHardCoder[%d %d %d %d] take[%d]ms tid[%s, %s]", Long.valueOf(C1651a.eKP), Long.valueOf(C1651a.eKQ), Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2), Long.valueOf(elapsedRealtime2 - C1651a.eKP), currentThread.getName(), Long.valueOf(currentThread.getId()));
            if (C4996ah.bqo()) {
                WXHardCoderJNI.registerSystemEventCallback(new C32821());
            }
            AppMethodBeat.m2505o(60249);
        }
    }

    /* renamed from: com.tencent.mm.plugin.hardcoder.PluginHardcoder$4 */
    class C32834 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.hardcoder.PluginHardcoder$4$1 */
        class C32841 implements Runnable {
            C32841() {
            }

            public final void run() {
                AppMethodBeat.m2504i(60254);
                String str = "MicroMsg.PluginHardcoder";
                String str2 = "reportHardCoder tid[%d, %s], running[%b]";
                Object[] objArr = new Object[3];
                objArr[0] = Long.valueOf(Thread.currentThread().getId());
                objArr[1] = Thread.currentThread().getName();
                boolean z = WXHardCoderJNI.isCheckEnv() && WXHardCoderJNI.isRunning() > 0;
                objArr[2] = Boolean.valueOf(z);
                C4990ab.m7417i(str, str2, objArr);
                WXHardCoderJNI.reportIDKey(true, 0, 1, false);
                WXHardCoderJNI.readServerAddr(true);
                int i = (!WXHardCoderJNI.isCheckEnv() || WXHardCoderJNI.isRunning() <= 0) ? 5 : 4;
                WXHardCoderJNI.reportIDKey(true, i, 1, false);
                WXHardCoderJNI.reportIDKey(true, WXHardCoderJNI.isHCEnable() ? 6 : 7, 1, false);
                AppMethodBeat.m2505o(60254);
            }
        }

        C32834() {
        }

        public final void run() {
            AppMethodBeat.m2504i(60255);
            C4990ab.m7416i("MicroMsg.PluginHardcoder", "reportHardcoderRunnable start to run");
            C1720g.m3537RQ();
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_REPORT_HARDCODER_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_REPORT_HARDCODER_TIME_LONG, Long.valueOf(currentTimeMillis));
                C7305d.post(new C32841(), "reportHardCoder");
            }
            AppMethodBeat.m2505o(60255);
        }
    }

    /* renamed from: com.tencent.mm.plugin.hardcoder.PluginHardcoder$2 */
    class C69432 implements C4931a {

        /* renamed from: com.tencent.mm.plugin.hardcoder.PluginHardcoder$2$1 */
        class C69441 implements Runnable {
            C69441() {
            }

            public final void run() {
                AppMethodBeat.m2504i(60250);
                PluginHardcoder.access$000(PluginHardcoder.this);
                AppMethodBeat.m2505o(60250);
            }
        }

        C69432() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(60251);
            C4990ab.m7417i("MicroMsg.PluginHardcoder", "abTestListener onNotifyChange stack[%s]", C5046bo.dpG());
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                C1720g.m3539RS().mo10310m(new C69441(), 100);
            }
            AppMethodBeat.m2505o(60251);
        }
    }

    /* renamed from: com.tencent.mm.plugin.hardcoder.PluginHardcoder$3 */
    class C343303 extends C4884c<C6523mp> {
        C343303() {
            AppMethodBeat.m2504i(60252);
            this.xxI = C6523mp.class.getName().hashCode();
            AppMethodBeat.m2505o(60252);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(60253);
            C1720g.m3539RS();
            C5004al.m7439af(PluginHardcoder.this.nqk);
            C1720g.m3539RS().mo10310m(PluginHardcoder.this.nqk, 3000);
            AppMethodBeat.m2505o(60253);
            return false;
        }
    }

    public PluginHardcoder() {
        AppMethodBeat.m2504i(60256);
        AppMethodBeat.m2505o(60256);
    }

    static /* synthetic */ void access$000(PluginHardcoder pluginHardcoder) {
        AppMethodBeat.m2504i(60263);
        pluginHardcoder.reloadHardcoderConfig();
        AppMethodBeat.m2505o(60263);
    }

    public void installed() {
        AppMethodBeat.m2504i(60257);
        alias(C12218b.class);
        AppMethodBeat.m2505o(60257);
    }

    public void dependency() {
        AppMethodBeat.m2504i(60258);
        dependsOn(C44035d.class);
        dependsOn(C7051c.class);
        AppMethodBeat.m2505o(60258);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(60259);
        C7305d.post(new C32811(), "initHardCoder");
        AppMethodBeat.m2505o(60259);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(60260);
        if (C4996ah.bqo()) {
            C4879a.xxA.mo10051b(this.nqj);
            C18624c.abi().mo10116c(this.foI);
            C4990ab.m7417i("MicroMsg.PluginHardcoder", "onAccountInitialized abTestListener[%s]", this.foI);
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(WXHardCoderJNI.SETTING_SP_FILE, 0);
            C1720g.m3537RQ();
            C1720g.m3534RN();
            if (C1668a.m3383QF() != 0) {
                C1720g.m3537RQ();
                C1720g.m3534RN();
                int bL = C1179i.m2593bL(C1668a.m3383QF(), 100);
                if (bL != sharedPreferences.getInt(WXHardCoderJNI.KEY_HC_UIN_HASH, 0)) {
                    C4990ab.m7417i("MicroMsg.PluginHardcoder", "onAccountInitialized hardcoder uinHash[%d] reloadSPConfig", Integer.valueOf(bL));
                    sharedPreferences.edit().putInt(WXHardCoderJNI.KEY_HC_UIN_HASH, bL).apply();
                    WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_POST_RESET);
                }
            }
        }
        AppMethodBeat.m2505o(60260);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(60261);
        if (C4996ah.bqo()) {
            C18624c.abi().mo10117d(this.foI);
            C4879a.xxA.mo10053d(this.nqj);
        }
        AppMethodBeat.m2505o(60261);
    }

    public void execute(C1681g c1681g) {
    }

    private void reloadHardcoderConfig() {
        AppMethodBeat.m2504i(60262);
        C5141c ll = C18624c.abi().mo17131ll("100282");
        C4990ab.m7417i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest[%s][%b][%s]", ll, Boolean.valueOf(ll.isValid()), ll.dru());
        if (ll.isValid()) {
            boolean z;
            C4990ab.m7416i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest valid!");
            Editor edit = C4996ah.getContext().getSharedPreferences(WXHardCoderJNI.SETTING_SP_FILE, 0).edit();
            Map dru = ll.dru();
            boolean z2 = C5046bo.getInt((String) dru.get("enable"), WXHardCoderJNI.getEnable() ? 1 : 0) > 0;
            boolean z3 = z2 && !WXHardCoderJNI.getEnable();
            edit.putBoolean(WXHardCoderJNI.KEY_HC_ENABLE, z2);
            edit.putBoolean(WXHardCoderJNI.KEY_HC_BG_ENABLE, C5046bo.getInt((String) dru.get("bgenable"), WXHardCoderJNI.hcBgEnable ? 1 : 0) > 0);
            if (C5046bo.getInt((String) dru.get("debug"), WXHardCoderJNI.getDebug() ? 1 : 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            edit.putBoolean(WXHardCoderJNI.KEY_HC_DEBUG, z);
            edit.putInt(WXHardCoderJNI.KEY_HC_KV_PER, C5046bo.getInt((String) dru.get("kvper"), WXHardCoderJNI.hcUinHash));
            edit.putInt(WXHardCoderJNI.KEY_HC_KV_FT, C5046bo.getInt((String) dru.get("kvft"), WXHardCoderJNI.hcUinHash));
            C1720g.m3537RQ();
            C1720g.m3534RN();
            edit.putInt(WXHardCoderJNI.KEY_HC_UIN_HASH, C1179i.m2593bL(C1668a.m3383QF(), 100));
            long j = C5046bo.getLong((String) dru.get("scene"), -1);
            for (Entry entry : WXHardCoderJNI.flagKeyMap.entrySet()) {
                String str = (String) entry.getValue();
                if ((((Long) entry.getKey()).longValue() & j) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                edit.putBoolean(str, z);
            }
            edit.putInt(WXHardCoderJNI.KEY_HC_TIMEOUT_MARGIN, C5046bo.getInt((String) dru.get("margin"), WXHardCoderJNI.hcTimeoutMargin));
            edit.putInt(WXHardCoderJNI.KEY_HC_RETRY_INTERVAL, C5046bo.getInt((String) dru.get("retryitv"), WXHardCoderJNI.hcRetryInterval));
            String bc = C5046bo.m7532bc((String) dru.get("model"), "");
            String str2 = Build.MODEL;
            String bc2 = C5046bo.m7532bc((String) dru.get("manufacturer"), "");
            String str3 = Build.MANUFACTURER;
            if (bc2.length() > 0 || bc.length() > 0) {
                z = bc2.contains(str3);
                if (z) {
                    z2 = z;
                } else {
                    z2 = bc.contains(str2);
                }
                WXHardCoderJNI.reportIDKey(true, z2 ? 10 : 11, 1, true);
                edit.putBoolean(WXHardCoderJNI.KEY_HC_ENABLE, z2);
                z = z2 && !WXHardCoderJNI.getEnable();
                C4990ab.m7417i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig check manufacturer[%s] manufacturerlist[%s] model[%s] modellist[%s] enable[%b] init[%b]", str3, bc2, str2, bc, Boolean.valueOf(z2), Boolean.valueOf(z));
                z3 = z;
            } else {
                WXHardCoderJNI.reportIDKey(true, 12, 1, true);
            }
            edit.apply();
            WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_ABTEST);
            C4990ab.m7417i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig enable[%b] init[%b] bgEnable[%b] debug[%b] uinHash[%d] kv[%b, %b] sceneFlag[%d] margin[%d] retryInterval[%d] model[%s]", Boolean.valueOf(WXHardCoderJNI.getEnable()), Boolean.valueOf(z3), Boolean.valueOf(WXHardCoderJNI.hcBgEnable), Boolean.valueOf(WXHardCoderJNI.getDebug()), Integer.valueOf(r5), Boolean.valueOf(WXHardCoderJNI.hcKVPerReport), Boolean.valueOf(WXHardCoderJNI.hcKVFtReport), Long.valueOf(j), Integer.valueOf(r8), Integer.valueOf(r9), bc);
            if (z3) {
                WXHardCoderJNI.initHardCoder(C34331a.bFR(), C34331a.bFR());
            }
        }
        AppMethodBeat.m2505o(60262);
    }
}
