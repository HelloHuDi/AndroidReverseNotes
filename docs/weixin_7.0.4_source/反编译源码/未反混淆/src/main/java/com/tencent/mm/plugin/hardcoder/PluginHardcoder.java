package com.tencent.mm.plugin.hardcoder;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.hardcoder.HardCoderJNI.SystemEventCallback;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.Map;
import java.util.Map.Entry;

public class PluginHardcoder extends f implements c, b {
    private a foI = new a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(60251);
            ab.i("MicroMsg.PluginHardcoder", "abTestListener onNotifyChange stack[%s]", bo.dpG());
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                g.RS().m(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(60250);
                        PluginHardcoder.access$000(PluginHardcoder.this);
                        AppMethodBeat.o(60250);
                    }
                }, 100);
            }
            AppMethodBeat.o(60251);
        }
    };
    private com.tencent.mm.sdk.b.c nqj = new com.tencent.mm.sdk.b.c<mp>() {
        {
            AppMethodBeat.i(60252);
            this.xxI = mp.class.getName().hashCode();
            AppMethodBeat.o(60252);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(60253);
            g.RS();
            al.af(PluginHardcoder.this.nqk);
            g.RS().m(PluginHardcoder.this.nqk, 3000);
            AppMethodBeat.o(60253);
            return false;
        }
    };
    private Runnable nqk = new Runnable() {
        public final void run() {
            AppMethodBeat.i(60255);
            ab.i("MicroMsg.PluginHardcoder", "reportHardcoderRunnable start to run");
            g.RQ();
            long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_REPORT_HARDCODER_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
                g.RQ();
                g.RP().Ry().set(ac.a.USERINFO_REPORT_HARDCODER_TIME_LONG, Long.valueOf(currentTimeMillis));
                d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(60254);
                        String str = "MicroMsg.PluginHardcoder";
                        String str2 = "reportHardCoder tid[%d, %s], running[%b]";
                        Object[] objArr = new Object[3];
                        objArr[0] = Long.valueOf(Thread.currentThread().getId());
                        objArr[1] = Thread.currentThread().getName();
                        boolean z = WXHardCoderJNI.isCheckEnv() && WXHardCoderJNI.isRunning() > 0;
                        objArr[2] = Boolean.valueOf(z);
                        ab.i(str, str2, objArr);
                        WXHardCoderJNI.reportIDKey(true, 0, 1, false);
                        WXHardCoderJNI.readServerAddr(true);
                        int i = (!WXHardCoderJNI.isCheckEnv() || WXHardCoderJNI.isRunning() <= 0) ? 5 : 4;
                        WXHardCoderJNI.reportIDKey(true, i, 1, false);
                        WXHardCoderJNI.reportIDKey(true, WXHardCoderJNI.isHCEnable() ? 6 : 7, 1, false);
                        AppMethodBeat.o(60254);
                    }
                }, "reportHardCoder");
            }
            AppMethodBeat.o(60255);
        }
    };

    public PluginHardcoder() {
        AppMethodBeat.i(60256);
        AppMethodBeat.o(60256);
    }

    static /* synthetic */ void access$000(PluginHardcoder pluginHardcoder) {
        AppMethodBeat.i(60263);
        pluginHardcoder.reloadHardcoderConfig();
        AppMethodBeat.o(60263);
    }

    public void installed() {
        AppMethodBeat.i(60257);
        alias(b.class);
        AppMethodBeat.o(60257);
    }

    public void dependency() {
        AppMethodBeat.i(60258);
        dependsOn(com.tencent.mm.plugin.zero.a.d.class);
        dependsOn(com.tencent.mm.plugin.report.c.class);
        AppMethodBeat.o(60258);
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(60259);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(60249);
                Thread currentThread = Thread.currentThread();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                WXHardCoderJNI.initHardCoder(a.bFR(), a.bFR());
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                ab.i("MicroMsg.PluginHardcoder", "configure initHardCoder[%d %d %d %d] take[%d]ms tid[%s, %s]", Long.valueOf(com.tencent.mm.kernel.a.a.eKP), Long.valueOf(com.tencent.mm.kernel.a.a.eKQ), Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2), Long.valueOf(elapsedRealtime2 - com.tencent.mm.kernel.a.a.eKP), currentThread.getName(), Long.valueOf(currentThread.getId()));
                if (ah.bqo()) {
                    WXHardCoderJNI.registerSystemEventCallback(new SystemEventCallback() {
                        public final void onEvent(int i) {
                            AppMethodBeat.i(60248);
                            ab.i("MicroMsg.PluginHardcoder", "configure SystemEventCallback onEvent eventCode[%d]", Integer.valueOf(i));
                            in inVar = new in();
                            inVar.cDG.keycode = i;
                            com.tencent.mm.sdk.b.a.xxA.m(inVar);
                            AppMethodBeat.o(60248);
                        }
                    });
                }
                AppMethodBeat.o(60249);
            }
        }, "initHardCoder");
        AppMethodBeat.o(60259);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(60260);
        if (ah.bqo()) {
            com.tencent.mm.sdk.b.a.xxA.b(this.nqj);
            com.tencent.mm.model.c.c.abi().c(this.foI);
            ab.i("MicroMsg.PluginHardcoder", "onAccountInitialized abTestListener[%s]", this.foI);
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(WXHardCoderJNI.SETTING_SP_FILE, 0);
            g.RQ();
            g.RN();
            if (com.tencent.mm.kernel.a.QF() != 0) {
                g.RQ();
                g.RN();
                int bL = i.bL(com.tencent.mm.kernel.a.QF(), 100);
                if (bL != sharedPreferences.getInt(WXHardCoderJNI.KEY_HC_UIN_HASH, 0)) {
                    ab.i("MicroMsg.PluginHardcoder", "onAccountInitialized hardcoder uinHash[%d] reloadSPConfig", Integer.valueOf(bL));
                    sharedPreferences.edit().putInt(WXHardCoderJNI.KEY_HC_UIN_HASH, bL).apply();
                    WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_POST_RESET);
                }
            }
        }
        AppMethodBeat.o(60260);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(60261);
        if (ah.bqo()) {
            com.tencent.mm.model.c.c.abi().d(this.foI);
            com.tencent.mm.sdk.b.a.xxA.d(this.nqj);
        }
        AppMethodBeat.o(60261);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    private void reloadHardcoderConfig() {
        AppMethodBeat.i(60262);
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100282");
        ab.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest[%s][%b][%s]", ll, Boolean.valueOf(ll.isValid()), ll.dru());
        if (ll.isValid()) {
            boolean z;
            ab.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest valid!");
            Editor edit = ah.getContext().getSharedPreferences(WXHardCoderJNI.SETTING_SP_FILE, 0).edit();
            Map dru = ll.dru();
            boolean z2 = bo.getInt((String) dru.get("enable"), WXHardCoderJNI.getEnable() ? 1 : 0) > 0;
            boolean z3 = z2 && !WXHardCoderJNI.getEnable();
            edit.putBoolean(WXHardCoderJNI.KEY_HC_ENABLE, z2);
            edit.putBoolean(WXHardCoderJNI.KEY_HC_BG_ENABLE, bo.getInt((String) dru.get("bgenable"), WXHardCoderJNI.hcBgEnable ? 1 : 0) > 0);
            if (bo.getInt((String) dru.get("debug"), WXHardCoderJNI.getDebug() ? 1 : 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            edit.putBoolean(WXHardCoderJNI.KEY_HC_DEBUG, z);
            edit.putInt(WXHardCoderJNI.KEY_HC_KV_PER, bo.getInt((String) dru.get("kvper"), WXHardCoderJNI.hcUinHash));
            edit.putInt(WXHardCoderJNI.KEY_HC_KV_FT, bo.getInt((String) dru.get("kvft"), WXHardCoderJNI.hcUinHash));
            g.RQ();
            g.RN();
            edit.putInt(WXHardCoderJNI.KEY_HC_UIN_HASH, i.bL(com.tencent.mm.kernel.a.QF(), 100));
            long j = bo.getLong((String) dru.get("scene"), -1);
            for (Entry entry : WXHardCoderJNI.flagKeyMap.entrySet()) {
                String str = (String) entry.getValue();
                if ((((Long) entry.getKey()).longValue() & j) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                edit.putBoolean(str, z);
            }
            edit.putInt(WXHardCoderJNI.KEY_HC_TIMEOUT_MARGIN, bo.getInt((String) dru.get("margin"), WXHardCoderJNI.hcTimeoutMargin));
            edit.putInt(WXHardCoderJNI.KEY_HC_RETRY_INTERVAL, bo.getInt((String) dru.get("retryitv"), WXHardCoderJNI.hcRetryInterval));
            String bc = bo.bc((String) dru.get("model"), "");
            String str2 = Build.MODEL;
            String bc2 = bo.bc((String) dru.get("manufacturer"), "");
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
                ab.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig check manufacturer[%s] manufacturerlist[%s] model[%s] modellist[%s] enable[%b] init[%b]", str3, bc2, str2, bc, Boolean.valueOf(z2), Boolean.valueOf(z));
                z3 = z;
            } else {
                WXHardCoderJNI.reportIDKey(true, 12, 1, true);
            }
            edit.apply();
            WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_ABTEST);
            ab.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig enable[%b] init[%b] bgEnable[%b] debug[%b] uinHash[%d] kv[%b, %b] sceneFlag[%d] margin[%d] retryInterval[%d] model[%s]", Boolean.valueOf(WXHardCoderJNI.getEnable()), Boolean.valueOf(z3), Boolean.valueOf(WXHardCoderJNI.hcBgEnable), Boolean.valueOf(WXHardCoderJNI.getDebug()), Integer.valueOf(r5), Boolean.valueOf(WXHardCoderJNI.hcKVPerReport), Boolean.valueOf(WXHardCoderJNI.hcKVFtReport), Long.valueOf(j), Integer.valueOf(r8), Integer.valueOf(r9), bc);
            if (z3) {
                WXHardCoderJNI.initHardCoder(a.bFR(), a.bFR());
            }
        }
        AppMethodBeat.o(60262);
    }
}
