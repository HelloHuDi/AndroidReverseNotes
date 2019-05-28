package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.v;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.c.i;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.pluginsdk.permission.PermissionActivity;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.f.AnonymousClass3;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class j implements a, g {
    public int cDq;
    public byte[] cPB;
    public int cdh;
    public String cdj;
    public String cvZ;
    public String desc;
    public byte[] gcA;
    public byte[] gcE;
    private Intent intent;
    protected Context mContext;
    private Notification oHJ;
    public int rlf;
    public int size;
    public int uin;
    public String[] xvX;
    public int xvw;
    c xwO;
    ArrayList<g> xwP;
    public String[] xwQ;
    public String xwR;
    public i xwS;
    public com.tencent.mm.c.i.a xwT;
    public boolean xwU;
    public boolean xwV;
    public boolean xwW;
    public String xwX;
    public boolean xwY;
    boolean xwZ;
    long xxa;
    f xxb;
    private long xxc;
    private com.tencent.mm.sandbox.b.a xxd;

    static final class a {
        public static final j xxg = new j();

        static {
            AppMethodBeat.i(28956);
            AppMethodBeat.o(28956);
        }
    }

    /* synthetic */ j(byte b) {
        this();
    }

    static /* synthetic */ void c(j jVar) {
        AppMethodBeat.i(28981);
        jVar.dnG();
        AppMethodBeat.o(28981);
    }

    static /* synthetic */ void d(j jVar) {
        AppMethodBeat.i(28982);
        jVar.dnF();
        AppMethodBeat.o(28982);
    }

    private j() {
        AppMethodBeat.i(28957);
        this.xwO = null;
        this.xwP = new ArrayList(1);
        this.cDq = d.vxo;
        this.xwU = false;
        this.xwV = false;
        this.xwW = false;
        this.xwY = false;
        this.xwZ = false;
        this.intent = null;
        this.oHJ = null;
        this.mContext = null;
        this.xxb = new f(this);
        this.xxc = -1;
        this.xxd = new com.tencent.mm.sandbox.b.a() {
            public final void dN(int i, int i2) {
                AppMethodBeat.i(28952);
                ab.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (j.this.rlf != 2) {
                    j.a(j.this, i2, i);
                }
                j.this.dN(i, i2);
                AppMethodBeat.o(28952);
            }

            public final void b(int i, int i2, btd btd) {
                AppMethodBeat.i(28953);
                j.this.xwZ = false;
                j.this.xxb.stop();
                j.this.xxa = System.currentTimeMillis();
                if (j.this.xwO == null) {
                    j.this.aB(2, true);
                    AppMethodBeat.o(28953);
                } else if (i == 200 && i2 == 0) {
                    ab.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
                    if (j.this.rlf != 2) {
                        j.a(j.this, 100, 100);
                    }
                    if (j.this.xwU) {
                        i.ap(j.this.mContext, 0);
                    } else {
                        i.ap(j.this.mContext, 9);
                    }
                    SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "yyb_pkg_sig_prefs", h.Mu());
                    j.this.xwR = sharedPreferences.getString(ah.getPackageName(), "");
                    ab.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", j.this.xwR, j.this.xwO.dne());
                    if (bo.isNullOrNil(j.this.xwR)) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(322, 8, 1, false);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11098, Integer.valueOf(WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED));
                    } else {
                        try {
                            com.tencent.mm.c.c.c(new File(j.this.xwO.dne()), j.this.xwR);
                            ab.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
                            com.tencent.mm.plugin.report.service.h.pYm.a(322, 6, 1, false);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11098, Integer.valueOf(WearableStatusCodes.DUPLICATE_CAPABILITY), j.this.xwR);
                        } catch (Exception e) {
                            ab.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + e.getMessage());
                            com.tencent.mm.plugin.report.service.h.pYm.a(322, 7, 1, false);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11098, Integer.valueOf(WearableStatusCodes.UNKNOWN_CAPABILITY), e.getMessage());
                        }
                    }
                    if (j.this.rlf == 1) {
                        i.aq(j.this.mContext, 8);
                        j.a(j.this);
                        j.this.YJ(j.this.xwO.dne());
                        if (j.this.xwY) {
                            com.tencent.mm.plugin.report.service.h.pYm.a(614, 58, 1, false);
                            ab.d("MicroMsg.UpdaterManager", "boots download success.");
                        }
                    } else if (j.this.rlf == 0) {
                        j.this.YJ(j.this.xwO.dne());
                    } else if (j.this.rlf == 2) {
                        i.aq(j.this.mContext, 1);
                        j.a(j.this);
                    }
                    i.dnA();
                    AppMethodBeat.o(28953);
                } else if (i2 == -13) {
                    ab.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
                    UpdaterService.ev();
                    AppUpdaterUI.dni();
                    i.dnz();
                    AppMethodBeat.o(28953);
                } else {
                    if (!(j.this.xwO instanceof c) || j.this.xvw == 4) {
                        ab.e("MicroMsg.UpdaterManager", "update failed");
                        i.ap(j.this.mContext, 10);
                        if (j.this.rlf == 1) {
                            j.e(j.this);
                        } else if (j.this.rlf == 0) {
                            j.this.aB(1, true);
                        }
                    } else {
                        ab.e("MicroMsg.UpdaterManager", "download package from cdn error.");
                        if (j.this.xwU) {
                            if (i == 3 || i == 4 || i == 2 || i == 1 || i == 13) {
                                i.ap(j.this.mContext, i);
                            }
                            j.this.xwU = false;
                            if (j.this.rlf == 1) {
                                if (j.this.xwY) {
                                    ab.d("MicroMsg.UpdaterManager", "boots download failed. %d", Integer.valueOf(i));
                                    switch (i) {
                                        case 1:
                                            com.tencent.mm.plugin.report.service.h.pYm.a(614, 51, 1, false);
                                            break;
                                        case 2:
                                            com.tencent.mm.plugin.report.service.h.pYm.a(614, 54, 1, false);
                                            break;
                                        case 3:
                                            com.tencent.mm.plugin.report.service.h.pYm.a(614, 52, 1, false);
                                            break;
                                        case 4:
                                            com.tencent.mm.plugin.report.service.h.pYm.a(614, 53, 1, false);
                                            break;
                                        case 13:
                                            com.tencent.mm.plugin.report.service.h.pYm.a(614, 55, 1, false);
                                            break;
                                    }
                                }
                                j.b(j.this);
                            } else if (j.this.rlf == 0) {
                                j.this.aB(1, true);
                            } else if (j.this.rlf == 2) {
                                j.c(j.this);
                            }
                        } else {
                            boolean z;
                            j jVar = j.this;
                            int i3 = j.this.size;
                            String str = j.this.cvZ;
                            int i4 = j.this.xvw;
                            int i5 = j.this.uin;
                            byte[] bArr = j.this.gcA;
                            byte[] bArr2 = j.this.cPB;
                            String[] strArr = j.this.xwQ;
                            if (j.this.rlf == 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            jVar.xwO = new b(i3, str, i4, i5, bArr, bArr2, strArr, z);
                            j.d(j.this);
                        }
                    }
                    j.this.a(j.this.xwO);
                    AppMethodBeat.o(28953);
                }
            }

            public final void mm(long j) {
                AppMethodBeat.i(28954);
                f fVar = j.this.xxb;
                fVar.che.post(new com.tencent.mm.sandbox.updater.f.AnonymousClass2(j));
                AppMethodBeat.o(28954);
            }

            public final void mn(long j) {
                AppMethodBeat.i(28955);
                f fVar = j.this.xxb;
                fVar.che.post(new AnonymousClass3(j));
                AppMethodBeat.o(28955);
            }
        };
        this.mContext = ah.getContext();
        AppMethodBeat.o(28957);
    }

    public final void pc(boolean z) {
        AppMethodBeat.i(28958);
        ab.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", Boolean.valueOf(z));
        f fVar = this.xxb;
        if (fVar.mgU != z) {
            fVar.pd(true);
            fVar.mgU = z;
        }
        if (this.rlf != 2 || this.xwZ) {
            ab.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", Integer.valueOf(this.rlf), Boolean.valueOf(this.xwZ));
            AppMethodBeat.o(28958);
            return;
        }
        if (z) {
            if (aK(this.intent)) {
                pe(true);
                AppMethodBeat.o(28958);
                return;
            }
        } else if (this.xwZ) {
            cancel();
        }
        AppMethodBeat.o(28958);
    }

    public final boolean aJ(Intent intent) {
        AppMethodBeat.i(28959);
        boolean aK = aK(intent);
        ab.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", Boolean.valueOf(aK));
        if (aK) {
            pe(false);
        }
        AppMethodBeat.o(28959);
        return aK;
    }

    public final boolean aK(Intent intent) {
        AppMethodBeat.i(28960);
        ab.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
        if (intent == null) {
            ab.i("MicroMsg.UpdaterManager", "intent == null");
            AppMethodBeat.o(28960);
            return false;
        }
        int intExtra = intent.getIntExtra("intent_update_type", 3);
        int intExtra2 = intent.getIntExtra("intent_extra_download_mode", 1);
        String stringExtra = intent.getStringExtra("intent_extra_md5");
        if (this.xwZ && !stringExtra.equalsIgnoreCase(this.cvZ) && this.rlf == 2) {
            cancel();
        } else if (this.xwZ) {
            ab.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
            AppMethodBeat.o(28960);
            return true;
        }
        i.dnA();
        reset();
        this.intent = intent;
        this.cdh = intent.getIntExtra("intent_extra_updateMode", 0);
        this.cdj = intent.getStringExtra("intent_extra_marketUrl");
        this.xwQ = intent.getStringArrayExtra("intent_short_ips");
        this.cDq = intent.getIntExtra("intent_client_version", d.vxo);
        d.vxo = this.cDq;
        this.xvw = intExtra;
        this.gcA = intent.getByteArrayExtra("intent_extra_session");
        this.cPB = intent.getByteArrayExtra("intent_extra_cookie");
        this.gcE = intent.getByteArrayExtra("intent_extra_ecdhkey");
        this.uin = intent.getIntExtra("intent_extra_uin", 0);
        this.cvZ = stringExtra;
        this.desc = intent.getStringExtra("intent_extra_desc");
        this.size = intent.getIntExtra("intent_extra_size", 0);
        this.xvX = intent.getStringArrayExtra("intent_extra_download_url");
        this.rlf = intExtra2;
        this.xwW = intent.getBooleanExtra("intent_extra_force_download_full", false);
        String stringExtra2 = intent.getStringExtra("intent_extra_patchInfo");
        if (stringExtra2 != null) {
            ab.i("MicroMsg.UpdaterManager", "patchXml != null");
            this.xwS = i.cO(stringExtra2);
        }
        stringExtra2 = intent.getStringExtra("intent_extra_extinfo");
        ab.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", stringExtra2);
        if (!bo.isNullOrNil(stringExtra2)) {
            this.xwX = (String) br.z(stringExtra2, Constants.EXTINFO).get(".extinfo.notautodownloadrange");
            ab.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", this.xwX);
        }
        ab.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", Integer.valueOf(intExtra2), Boolean.valueOf(this.xwZ));
        if (intExtra != 999 || this.xvX == null || this.xvX.length <= 0) {
            if (this.xvX != null) {
                for (Object valueOf : this.xvX) {
                    ab.i("MicroMsg.UpdaterManager", "download url : ".concat(String.valueOf(valueOf)));
                }
            }
            ab.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", stringExtra, Integer.valueOf(this.size));
            if (stringExtra == null || this.size == 0) {
                AppMethodBeat.o(28960);
                return false;
            }
            if (intExtra == 2) {
                ab.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", Boolean.valueOf(b.rR(this.xwX)));
                if (b.rR(this.xwX)) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(405, 78, 1, true);
                    AppMethodBeat.o(28960);
                    return false;
                }
            }
            if (this.xwS != null) {
                ab.i("MicroMsg.UpdaterManager", "patchInfo != null");
                stringExtra2 = com.tencent.mm.pluginsdk.f.i.fN(this.mContext);
                this.xwT = this.xwS.cN(stringExtra2);
                ab.i("MicroMsg.UpdaterManager", "increase apkMD5 = " + stringExtra2 + " : " + (this.xwT == null ? "not match" : "match"));
            }
            ab.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", Boolean.valueOf(this.xwW));
            this.xwY = intent.getBooleanExtra("intent_extra_tinker_patch", false);
            if ((this.xwT == null || c.alZ(stringExtra)) && !this.xwY) {
                ab.i("MicroMsg.UpdaterManager", "had try to download full pack.");
            } else {
                ab.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
                this.xwU = true;
            }
            stringExtra2 = i.dhU();
            if (!(bo.isNullOrNil(stringExtra2) || stringExtra2.equals(stringExtra))) {
                i.dnB();
            }
            AppMethodBeat.o(28960);
            return true;
        }
        if (intExtra2 == 2) {
            ab.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
        }
        AppMethodBeat.o(28960);
        return true;
    }

    public final void dnC() {
        AppMethodBeat.i(139024);
        pe(false);
        AppMethodBeat.o(139024);
    }

    private void pe(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(28962);
        ab.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", Boolean.valueOf(z));
        ab.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", Integer.valueOf(this.rlf), Boolean.valueOf(this.xwZ));
        if (this.intent == null) {
            ab.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
            AppMethodBeat.o(28962);
        } else if (this.xwZ) {
            ab.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
            AppMethodBeat.o(28962);
        } else if (h.getExternalStorageState().equals("mounted")) {
            if (this.rlf == 2 && !z) {
                i.aq(this.mContext, 0);
            }
            String RP = c.RP(this.cvZ);
            ab.i("MicroMsg.UpdaterManager", RP);
            if (RP != null) {
                ab.i("MicroMsg.UpdaterManager", "update package already exist.");
                aB(1, true);
                YJ(RP);
                if (this.rlf == 2 && !i.amc(this.cvZ)) {
                    i.a(this.cvZ, this.xwR, this.desc, this.size, this.rlf, this.xvw, this.xwX);
                }
                AppMethodBeat.o(28962);
                return;
            }
            if (this.xwW) {
                if (this.xwO != null) {
                    this.xwO.deleteTempFile();
                }
                i.ap(this.mContext, 11);
            }
            if (!this.xwW && this.xwU && this.xwS != null && this.xwT != null) {
                ab.i("MicroMsg.UpdaterManager", "Incresment Update");
                i.ap(this.mContext, 5);
                if (f.eW((long) (this.size + this.xwT.size))) {
                    cancel();
                    int i = this.xwT.size;
                    String str = this.cvZ;
                    int i2 = this.xvw;
                    String str2 = this.xwS.cdu + this.xwT.url;
                    String str3 = this.xwT.cdy;
                    String str4 = this.xwT.cdx;
                    if (this.rlf != 2) {
                        z2 = false;
                    }
                    this.xwO = new c(i, str, i2, str2, str3, str4, z2);
                    dnF();
                    AppMethodBeat.o(28962);
                    return;
                }
                dnE();
                AppMethodBeat.o(28962);
            } else if (f.eW((long) this.size)) {
                dnG();
                AppMethodBeat.o(28962);
            } else {
                ab.e("MicroMsg.UpdaterManager", "SDCard is full");
                dnE();
                AppMethodBeat.o(28962);
            }
        } else {
            ab.e("MicroMsg.UpdaterManager", "no sdcard.");
            dnD();
            AppMethodBeat.o(28962);
        }
    }

    public final void aB(final int i, boolean z) {
        AppMethodBeat.i(28963);
        this.xwV = z;
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(28951);
                ((NotificationManager) j.this.mContext.getSystemService("notification")).cancel(99);
                ab.d("MicroMsg.UpdaterManager", "finishType == " + i);
                if (i == 2 && j.this.xvw == 1) {
                    Intent intent = new Intent();
                    intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
                    j.this.mContext.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
                }
                AppMethodBeat.o(28951);
            }
        }, 300);
        AppMethodBeat.o(28963);
    }

    public final void cancel() {
        AppMethodBeat.i(28964);
        if (this.xwO != null) {
            this.xwZ = false;
            this.xwO.cancel();
            this.xwO = null;
            this.xxa = System.currentTimeMillis();
            this.xxb.stop();
        }
        AppMethodBeat.o(28964);
    }

    private void reset() {
        AppMethodBeat.i(28965);
        cancel();
        this.cdh = 0;
        this.cdj = null;
        this.xwQ = null;
        this.cDq = d.vxo;
        this.xvw = 0;
        this.gcA = null;
        this.cPB = null;
        this.gcE = null;
        this.uin = 0;
        this.cvZ = null;
        this.size = 0;
        this.desc = null;
        this.xvX = null;
        this.xwS = null;
        this.xwT = null;
        this.xwU = false;
        this.xwV = false;
        this.rlf = 0;
        this.xwW = false;
        this.intent = null;
        this.xwZ = false;
        this.oHJ = null;
        this.xxc = 0;
        AppMethodBeat.o(28965);
    }

    private void dnD() {
        AppMethodBeat.i(28966);
        MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.anT() - TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC).commit();
        aB(2, true);
        dnk();
        AppMethodBeat.o(28966);
    }

    private void dnE() {
        AppMethodBeat.i(28967);
        MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.anT() - TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC).commit();
        aB(2, true);
        dnl();
        AppMethodBeat.o(28967);
    }

    private void dnF() {
        AppMethodBeat.i(28968);
        if (this.rlf == 2 && !at.isWifi(this.mContext)) {
            i.dny();
            ab.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
            AppMethodBeat.o(28968);
        } else if (this.rlf == 2 && f.amb(this.cvZ)) {
            ab.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
            this.xxb.stop();
            AppMethodBeat.o(28968);
        } else {
            this.xxb.ee(this.cvZ, this.size);
            if (this.xwO != null) {
                aB(1, false);
                this.xwZ = true;
                this.xwO.a(this.xxd);
                cpu();
                if (this.rlf == 2) {
                    i.dny();
                }
            }
            AppMethodBeat.o(28968);
        }
    }

    private void dnG() {
        AppMethodBeat.i(28969);
        cancel();
        ab.i("MicroMsg.UpdaterManager", "downloadFullPack");
        i.ap(this.mContext, 7);
        if (this.xvX == null || this.xvX.length <= 0) {
            this.xwO = new b(this.size, this.cvZ, this.xvw, this.uin, this.gcA, this.cPB, this.xwQ, this.rlf == 2);
            com.tencent.mm.plugin.report.service.h.pYm.a(405, 77, 1, true);
        } else {
            this.xwO = new c(this.size, this.cvZ, this.xvw, this.xvX, this.rlf == 2);
            com.tencent.mm.plugin.report.service.h.pYm.a(405, 76, 1, true);
        }
        dnF();
        AppMethodBeat.o(28969);
    }

    public final void dN(int i, int i2) {
        AppMethodBeat.i(28970);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((g) it.next()).dN(i, i2);
        }
        AppMethodBeat.o(28970);
    }

    public final void cpu() {
        AppMethodBeat.i(28971);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((g) it.next()).cpu();
        }
        AppMethodBeat.o(28971);
    }

    public final void YJ(String str) {
        AppMethodBeat.i(28972);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((g) it.next()).YJ(str);
        }
        AppMethodBeat.o(28972);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(28973);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(cVar);
        }
        AppMethodBeat.o(28973);
    }

    public final void dnk() {
        AppMethodBeat.i(28974);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((g) it.next()).dnk();
        }
        AppMethodBeat.o(28974);
    }

    public final void dnl() {
        AppMethodBeat.i(28975);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((g) it.next()).dnl();
        }
        AppMethodBeat.o(28975);
    }

    public final void onDestroy() {
        AppMethodBeat.i(28977);
        ab.i("MicroMsg.UpdaterManager", "onDestroy");
        if (!this.xwZ) {
            reset();
            aB(1, true);
        }
        AppMethodBeat.o(28977);
    }

    public final boolean isBusy() {
        AppMethodBeat.i(28976);
        if (this.xwZ || System.currentTimeMillis() - this.xxa <= UpdaterService.xxj) {
            ab.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", Boolean.valueOf(this.xwZ), Long.valueOf(this.xxa), Long.valueOf(System.currentTimeMillis() - this.xxa));
            AppMethodBeat.o(28976);
            return true;
        }
        ab.i("MicroMsg.UpdaterManager", "not busy");
        AppMethodBeat.o(28976);
        return false;
    }

    static /* synthetic */ void a(j jVar, int i, int i2) {
        AppMethodBeat.i(28978);
        String string = jVar.mContext.getString(R.string.pc);
        if (i < i2) {
            long j = (((long) i) * 100) / ((long) i2);
            if (j - jVar.xxc >= 1) {
                jVar.xxc = j;
                String str = jVar.mContext.getString(R.string.pf) + String.valueOf(jVar.xxc) + "%";
                Intent intent = new Intent(jVar.intent);
                intent.setClass(jVar.mContext, AppUpdaterUI.class);
                intent.addFlags(536870912);
                PendingIntent activity = PendingIntent.getActivity(jVar.mContext, 0, intent, 134217728);
                v.c e = com.tencent.mm.bo.a.bt(jVar.mContext, "reminder_channel_id").g(null).j(System.currentTimeMillis()).d(string).e(str);
                e.EI = activity;
                e.EL = BitmapFactory.decodeResource(jVar.mContext.getResources(), R.drawable.aq9);
                e.as(com.tencent.mm.bo.a.bWV());
                jVar.oHJ = e.build();
                jVar.oHJ.icon = R.drawable.aq9;
            }
            AppMethodBeat.o(28978);
        } else if (!jVar.xwY || e.ct(jVar.xwO.dne())) {
            PendingIntent activity2;
            String string2 = jVar.mContext.getString(R.string.pa);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            k.a(jVar.mContext, intent2, new File(jVar.xwO.dne()), "application/vnd.android.package-archive");
            intent2.addFlags(536870912);
            if (VERSION.SDK_INT >= 26) {
                Intent intent3 = new Intent(ah.getContext(), PermissionActivity.class);
                intent3.putExtra("scene", 3);
                intent3.setSelector(intent2);
                activity2 = PendingIntent.getActivity(jVar.mContext, 0, intent3, 134217728);
            } else {
                activity2 = PendingIntent.getActivity(jVar.mContext, 0, intent2, 134217728);
            }
            v.c e2 = com.tencent.mm.bo.a.bt(jVar.mContext, "reminder_channel_id").g(null).j(System.currentTimeMillis()).d(string).e(string2);
            e2.EI = activity2;
            e2.EL = BitmapFactory.decodeResource(jVar.mContext.getResources(), R.drawable.aq9);
            e2.as(com.tencent.mm.bo.a.bWV());
            jVar.oHJ = e2.build();
            jVar.oHJ.icon = R.drawable.aq9;
            Notification notification = jVar.oHJ;
            notification.flags |= 16;
        } else {
            ab.i("MicroMsg.UpdaterManager", "do noting. wait for merge apk.");
        }
        if (!jVar.xwV) {
            ((NotificationManager) jVar.mContext.getSystemService("notification")).notify(99, jVar.oHJ);
        }
        AppMethodBeat.o(28978);
    }

    static /* synthetic */ void b(j jVar) {
        AppMethodBeat.i(28980);
        ab.i("MicroMsg.UpdaterManager", "showDownloadFullPackNotification()");
        String string = jVar.mContext.getString(R.string.pe, new Object[]{bo.ga((long) jVar.size)});
        Intent intent = jVar.intent;
        intent.putExtra("intent_extra_force_download_full", true);
        PendingIntent service = PendingIntent.getService(jVar.mContext, 0, intent, 134217728);
        v.c e = com.tencent.mm.bo.a.bt(jVar.mContext, "reminder_channel_id").g(null).j(System.currentTimeMillis()).d(string).e(null);
        e.EI = service;
        jVar.oHJ = e.build();
        jVar.oHJ.icon = R.drawable.aq9;
        Notification notification = jVar.oHJ;
        notification.flags |= 16;
        ((NotificationManager) jVar.mContext.getSystemService("notification")).notify(99, jVar.oHJ);
        AppMethodBeat.o(28980);
    }

    static /* synthetic */ void e(j jVar) {
        AppMethodBeat.i(28983);
        String string = jVar.mContext.getString(R.string.pd);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
        intent.addFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(jVar.mContext, 0, intent, 134217728);
        v.c e = com.tencent.mm.bo.a.bt(jVar.mContext, "reminder_channel_id").g(null).j(System.currentTimeMillis()).d(string).e(null);
        e.EI = activity;
        jVar.oHJ = e.build();
        jVar.oHJ.icon = R.drawable.aq9;
        Notification notification = jVar.oHJ;
        notification.flags |= 16;
        ((NotificationManager) jVar.mContext.getSystemService("notification")).notify(99, jVar.oHJ);
        AppMethodBeat.o(28983);
    }
}
