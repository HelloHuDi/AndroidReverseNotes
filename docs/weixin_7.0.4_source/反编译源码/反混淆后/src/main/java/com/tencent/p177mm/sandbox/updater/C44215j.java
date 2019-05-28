package com.tencent.p177mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.p057v4.app.C0363v.C0358c;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.modelcontrol.C45448b;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p209c.C41914i;
import com.tencent.p177mm.p209c.C41914i.C32431a;
import com.tencent.p177mm.p209c.C45275c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1079f.C30035i;
import com.tencent.p177mm.pluginsdk.permission.PermissionActivity;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sandbox.C35974b.C30268a;
import com.tencent.p177mm.sandbox.monitor.C15412c;
import com.tencent.p177mm.sandbox.updater.C23488f.C154173;
import com.tencent.p177mm.sandbox.updater.C23488f.C234902;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.sandbox.updater.j */
public final class C44215j implements C40606a, C30281g {
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
    C15412c xwO;
    ArrayList<C30281g> xwP;
    public String[] xwQ;
    public String xwR;
    public C41914i xwS;
    public C32431a xwT;
    public boolean xwU;
    public boolean xwV;
    public boolean xwW;
    public String xwX;
    public boolean xwY;
    boolean xwZ;
    long xxa;
    C23488f xxb;
    private long xxc;
    private C30268a xxd;

    /* renamed from: com.tencent.mm.sandbox.updater.j$a */
    static final class C23491a {
        public static final C44215j xxg = new C44215j();

        static {
            AppMethodBeat.m2504i(28956);
            AppMethodBeat.m2505o(28956);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.j$2 */
    class C442142 implements C30268a {
        C442142() {
        }

        /* renamed from: dN */
        public final void mo27463dN(int i, int i2) {
            AppMethodBeat.m2504i(28952);
            C4990ab.m7417i("MicroMsg.UpdaterManager", "total=%d, offset=%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (C44215j.this.rlf != 2) {
                C44215j.m79797a(C44215j.this, i2, i);
            }
            C44215j.this.mo10019dN(i, i2);
            AppMethodBeat.m2505o(28952);
        }

        /* renamed from: b */
        public final void mo27462b(int i, int i2, btd btd) {
            AppMethodBeat.m2504i(28953);
            C44215j.this.xwZ = false;
            C44215j.this.xxb.stop();
            C44215j.this.xxa = System.currentTimeMillis();
            if (C44215j.this.xwO == null) {
                C44215j.this.mo69850aB(2, true);
                AppMethodBeat.m2505o(28953);
            } else if (i == 200 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
                if (C44215j.this.rlf != 2) {
                    C44215j.m79797a(C44215j.this, 100, 100);
                }
                if (C44215j.this.xwU) {
                    C44212i.m79787ap(C44215j.this.mContext, 0);
                } else {
                    C44212i.m79787ap(C44215j.this.mContext, 9);
                }
                SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "yyb_pkg_sig_prefs", C1448h.m3078Mu());
                C44215j.this.xwR = sharedPreferences.getString(C4996ah.getPackageName(), "");
                C4990ab.m7417i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", C44215j.this.xwR, C44215j.this.xwO.dne());
                if (C5046bo.isNullOrNil(C44215j.this.xwR)) {
                    C7060h.pYm.mo8378a(322, 8, 1, false);
                    C7060h.pYm.mo8381e(11098, Integer.valueOf(WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED));
                } else {
                    try {
                        C45275c.m83482c(new File(C44215j.this.xwO.dne()), C44215j.this.xwR);
                        C4990ab.m7416i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
                        C7060h.pYm.mo8378a(322, 6, 1, false);
                        C7060h.pYm.mo8381e(11098, Integer.valueOf(WearableStatusCodes.DUPLICATE_CAPABILITY), C44215j.this.xwR);
                    } catch (Exception e) {
                        C4990ab.m7420w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + e.getMessage());
                        C7060h.pYm.mo8378a(322, 7, 1, false);
                        C7060h.pYm.mo8381e(11098, Integer.valueOf(WearableStatusCodes.UNKNOWN_CAPABILITY), e.getMessage());
                    }
                }
                if (C44215j.this.rlf == 1) {
                    C44212i.m79788aq(C44215j.this.mContext, 8);
                    C44215j.m79796a(C44215j.this);
                    C44215j.this.mo10016YJ(C44215j.this.xwO.dne());
                    if (C44215j.this.xwY) {
                        C7060h.pYm.mo8378a(614, 58, 1, false);
                        C4990ab.m7410d("MicroMsg.UpdaterManager", "boots download success.");
                    }
                } else if (C44215j.this.rlf == 0) {
                    C44215j.this.mo10016YJ(C44215j.this.xwO.dne());
                } else if (C44215j.this.rlf == 2) {
                    C44212i.m79788aq(C44215j.this.mContext, 1);
                    C44215j.m79796a(C44215j.this);
                }
                C44212i.dnA();
                AppMethodBeat.m2505o(28953);
            } else if (i2 == -13) {
                C4990ab.m7412e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
                UpdaterService.m48156ev();
                AppUpdaterUI.dni();
                C44212i.dnz();
                AppMethodBeat.m2505o(28953);
            } else {
                if (!(C44215j.this.xwO instanceof C40609c) || C44215j.this.xvw == 4) {
                    C4990ab.m7412e("MicroMsg.UpdaterManager", "update failed");
                    C44212i.m79787ap(C44215j.this.mContext, 10);
                    if (C44215j.this.rlf == 1) {
                        C44215j.m79801e(C44215j.this);
                    } else if (C44215j.this.rlf == 0) {
                        C44215j.this.mo69850aB(1, true);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.UpdaterManager", "download package from cdn error.");
                    if (C44215j.this.xwU) {
                        if (i == 3 || i == 4 || i == 2 || i == 1 || i == 13) {
                            C44212i.m79787ap(C44215j.this.mContext, i);
                        }
                        C44215j.this.xwU = false;
                        if (C44215j.this.rlf == 1) {
                            if (C44215j.this.xwY) {
                                C4990ab.m7411d("MicroMsg.UpdaterManager", "boots download failed. %d", Integer.valueOf(i));
                                switch (i) {
                                    case 1:
                                        C7060h.pYm.mo8378a(614, 51, 1, false);
                                        break;
                                    case 2:
                                        C7060h.pYm.mo8378a(614, 54, 1, false);
                                        break;
                                    case 3:
                                        C7060h.pYm.mo8378a(614, 52, 1, false);
                                        break;
                                    case 4:
                                        C7060h.pYm.mo8378a(614, 53, 1, false);
                                        break;
                                    case 13:
                                        C7060h.pYm.mo8378a(614, 55, 1, false);
                                        break;
                                }
                            }
                            C44215j.m79798b(C44215j.this);
                        } else if (C44215j.this.rlf == 0) {
                            C44215j.this.mo69850aB(1, true);
                        } else if (C44215j.this.rlf == 2) {
                            C44215j.m79799c(C44215j.this);
                        }
                    } else {
                        boolean z;
                        C44215j c44215j = C44215j.this;
                        int i3 = C44215j.this.size;
                        String str = C44215j.this.cvZ;
                        int i4 = C44215j.this.xvw;
                        int i5 = C44215j.this.uin;
                        byte[] bArr = C44215j.this.gcA;
                        byte[] bArr2 = C44215j.this.cPB;
                        String[] strArr = C44215j.this.xwQ;
                        if (C44215j.this.rlf == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c44215j.xwO = new C46611b(i3, str, i4, i5, bArr, bArr2, strArr, z);
                        C44215j.m79800d(C44215j.this);
                    }
                }
                C44215j.this.mo10017a(C44215j.this.xwO);
                AppMethodBeat.m2505o(28953);
            }
        }

        /* renamed from: mm */
        public final void mo27453mm(long j) {
            AppMethodBeat.m2504i(28954);
            C23488f c23488f = C44215j.this.xxb;
            c23488f.che.post(new C234902(j));
            AppMethodBeat.m2505o(28954);
        }

        /* renamed from: mn */
        public final void mo27454mn(long j) {
            AppMethodBeat.m2504i(28955);
            C23488f c23488f = C44215j.this.xxb;
            c23488f.che.post(new C154173(j));
            AppMethodBeat.m2505o(28955);
        }
    }

    /* synthetic */ C44215j(byte b) {
        this();
    }

    /* renamed from: c */
    static /* synthetic */ void m79799c(C44215j c44215j) {
        AppMethodBeat.m2504i(28981);
        c44215j.dnG();
        AppMethodBeat.m2505o(28981);
    }

    /* renamed from: d */
    static /* synthetic */ void m79800d(C44215j c44215j) {
        AppMethodBeat.m2504i(28982);
        c44215j.dnF();
        AppMethodBeat.m2505o(28982);
    }

    private C44215j() {
        AppMethodBeat.m2504i(28957);
        this.xwO = null;
        this.xwP = new ArrayList(1);
        this.cDq = C7243d.vxo;
        this.xwU = false;
        this.xwV = false;
        this.xwW = false;
        this.xwY = false;
        this.xwZ = false;
        this.intent = null;
        this.oHJ = null;
        this.mContext = null;
        this.xxb = new C23488f(this);
        this.xxc = -1;
        this.xxd = new C442142();
        this.mContext = C4996ah.getContext();
        AppMethodBeat.m2505o(28957);
    }

    /* renamed from: pc */
    public final void mo48469pc(boolean z) {
        AppMethodBeat.m2504i(28958);
        C4990ab.m7417i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", Boolean.valueOf(z));
        C23488f c23488f = this.xxb;
        if (c23488f.mgU != z) {
            c23488f.mo39145pd(true);
            c23488f.mgU = z;
        }
        if (this.rlf != 2 || this.xwZ) {
            C4990ab.m7417i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", Integer.valueOf(this.rlf), Boolean.valueOf(this.xwZ));
            AppMethodBeat.m2505o(28958);
            return;
        }
        if (z) {
            if (mo69851aK(this.intent)) {
                m79802pe(true);
                AppMethodBeat.m2505o(28958);
                return;
            }
        } else if (this.xwZ) {
            cancel();
        }
        AppMethodBeat.m2505o(28958);
    }

    /* renamed from: aJ */
    public final boolean mo48466aJ(Intent intent) {
        AppMethodBeat.m2504i(28959);
        boolean aK = mo69851aK(intent);
        C4990ab.m7417i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", Boolean.valueOf(aK));
        if (aK) {
            m79802pe(false);
        }
        AppMethodBeat.m2505o(28959);
        return aK;
    }

    /* renamed from: aK */
    public final boolean mo69851aK(Intent intent) {
        AppMethodBeat.m2504i(28960);
        C4990ab.m7416i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
        if (intent == null) {
            C4990ab.m7416i("MicroMsg.UpdaterManager", "intent == null");
            AppMethodBeat.m2505o(28960);
            return false;
        }
        int intExtra = intent.getIntExtra("intent_update_type", 3);
        int intExtra2 = intent.getIntExtra("intent_extra_download_mode", 1);
        String stringExtra = intent.getStringExtra("intent_extra_md5");
        if (this.xwZ && !stringExtra.equalsIgnoreCase(this.cvZ) && this.rlf == 2) {
            cancel();
        } else if (this.xwZ) {
            C4990ab.m7416i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
            AppMethodBeat.m2505o(28960);
            return true;
        }
        C44212i.dnA();
        reset();
        this.intent = intent;
        this.cdh = intent.getIntExtra("intent_extra_updateMode", 0);
        this.cdj = intent.getStringExtra("intent_extra_marketUrl");
        this.xwQ = intent.getStringArrayExtra("intent_short_ips");
        this.cDq = intent.getIntExtra("intent_client_version", C7243d.vxo);
        C7243d.vxo = this.cDq;
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
            C4990ab.m7416i("MicroMsg.UpdaterManager", "patchXml != null");
            this.xwS = C41914i.m74023cO(stringExtra2);
        }
        stringExtra2 = intent.getStringExtra("intent_extra_extinfo");
        C4990ab.m7411d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", stringExtra2);
        if (!C5046bo.isNullOrNil(stringExtra2)) {
            this.xwX = (String) C5049br.m7595z(stringExtra2, Constants.EXTINFO).get(".extinfo.notautodownloadrange");
            C4990ab.m7417i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", this.xwX);
        }
        C4990ab.m7417i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", Integer.valueOf(intExtra2), Boolean.valueOf(this.xwZ));
        if (intExtra != 999 || this.xvX == null || this.xvX.length <= 0) {
            if (this.xvX != null) {
                for (Object valueOf : this.xvX) {
                    C4990ab.m7416i("MicroMsg.UpdaterManager", "download url : ".concat(String.valueOf(valueOf)));
                }
            }
            C4990ab.m7417i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", stringExtra, Integer.valueOf(this.size));
            if (stringExtra == null || this.size == 0) {
                AppMethodBeat.m2505o(28960);
                return false;
            }
            if (intExtra == 2) {
                C4990ab.m7417i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", Boolean.valueOf(C45448b.m83719rR(this.xwX)));
                if (C45448b.m83719rR(this.xwX)) {
                    C7060h.pYm.mo8378a(405, 78, 1, true);
                    AppMethodBeat.m2505o(28960);
                    return false;
                }
            }
            if (this.xwS != null) {
                C4990ab.m7416i("MicroMsg.UpdaterManager", "patchInfo != null");
                stringExtra2 = C30035i.m47538fN(this.mContext);
                this.xwT = this.xwS.mo67558cN(stringExtra2);
                C4990ab.m7416i("MicroMsg.UpdaterManager", "increase apkMD5 = " + stringExtra2 + " : " + (this.xwT == null ? "not match" : "match"));
            }
            C4990ab.m7417i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", Boolean.valueOf(this.xwW));
            this.xwY = intent.getBooleanExtra("intent_extra_tinker_patch", false);
            if ((this.xwT == null || C15412c.alZ(stringExtra)) && !this.xwY) {
                C4990ab.m7416i("MicroMsg.UpdaterManager", "had try to download full pack.");
            } else {
                C4990ab.m7416i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
                this.xwU = true;
            }
            stringExtra2 = C44212i.dhU();
            if (!(C5046bo.isNullOrNil(stringExtra2) || stringExtra2.equals(stringExtra))) {
                C44212i.dnB();
            }
            AppMethodBeat.m2505o(28960);
            return true;
        }
        if (intExtra2 == 2) {
            C4990ab.m7412e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
        }
        AppMethodBeat.m2505o(28960);
        return true;
    }

    public final void dnC() {
        AppMethodBeat.m2504i(139024);
        m79802pe(false);
        AppMethodBeat.m2505o(139024);
    }

    /* renamed from: pe */
    private void m79802pe(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(28962);
        C4990ab.m7417i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", Boolean.valueOf(z));
        C4990ab.m7417i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", Integer.valueOf(this.rlf), Boolean.valueOf(this.xwZ));
        if (this.intent == null) {
            C4990ab.m7412e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
            AppMethodBeat.m2505o(28962);
        } else if (this.xwZ) {
            C4990ab.m7416i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
            AppMethodBeat.m2505o(28962);
        } else if (C1448h.getExternalStorageState().equals("mounted")) {
            if (this.rlf == 2 && !z) {
                C44212i.m79788aq(this.mContext, 0);
            }
            String RP = C15412c.m23693RP(this.cvZ);
            C4990ab.m7416i("MicroMsg.UpdaterManager", RP);
            if (RP != null) {
                C4990ab.m7416i("MicroMsg.UpdaterManager", "update package already exist.");
                mo69850aB(1, true);
                mo10016YJ(RP);
                if (this.rlf == 2 && !C44212i.amc(this.cvZ)) {
                    C44212i.m79786a(this.cvZ, this.xwR, this.desc, this.size, this.rlf, this.xvw, this.xwX);
                }
                AppMethodBeat.m2505o(28962);
                return;
            }
            if (this.xwW) {
                if (this.xwO != null) {
                    this.xwO.deleteTempFile();
                }
                C44212i.m79787ap(this.mContext, 11);
            }
            if (!this.xwW && this.xwU && this.xwS != null && this.xwT != null) {
                C4990ab.m7416i("MicroMsg.UpdaterManager", "Incresment Update");
                C44212i.m79787ap(this.mContext, 5);
                if (C1445f.m3072eW((long) (this.size + this.xwT.size))) {
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
                    this.xwO = new C40609c(i, str, i2, str2, str3, str4, z2);
                    dnF();
                    AppMethodBeat.m2505o(28962);
                    return;
                }
                dnE();
                AppMethodBeat.m2505o(28962);
            } else if (C1445f.m3072eW((long) this.size)) {
                dnG();
                AppMethodBeat.m2505o(28962);
            } else {
                C4990ab.m7412e("MicroMsg.UpdaterManager", "SDCard is full");
                dnE();
                AppMethodBeat.m2505o(28962);
            }
        } else {
            C4990ab.m7412e("MicroMsg.UpdaterManager", "no sdcard.");
            dnD();
            AppMethodBeat.m2505o(28962);
        }
    }

    /* renamed from: aB */
    public final void mo69850aB(final int i, boolean z) {
        AppMethodBeat.m2504i(28963);
        this.xwV = z;
        new C7306ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(28951);
                ((NotificationManager) C44215j.this.mContext.getSystemService("notification")).cancel(99);
                C4990ab.m7410d("MicroMsg.UpdaterManager", "finishType == " + i);
                if (i == 2 && C44215j.this.xvw == 1) {
                    Intent intent = new Intent();
                    intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
                    C44215j.this.mContext.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
                }
                AppMethodBeat.m2505o(28951);
            }
        }, 300);
        AppMethodBeat.m2505o(28963);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(28964);
        if (this.xwO != null) {
            this.xwZ = false;
            this.xwO.cancel();
            this.xwO = null;
            this.xxa = System.currentTimeMillis();
            this.xxb.stop();
        }
        AppMethodBeat.m2505o(28964);
    }

    private void reset() {
        AppMethodBeat.m2504i(28965);
        cancel();
        this.cdh = 0;
        this.cdj = null;
        this.xwQ = null;
        this.cDq = C7243d.vxo;
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
        AppMethodBeat.m2505o(28965);
    }

    private void dnD() {
        AppMethodBeat.m2504i(28966);
        MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", C5046bo.anT() - TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC).commit();
        mo69850aB(2, true);
        dnk();
        AppMethodBeat.m2505o(28966);
    }

    private void dnE() {
        AppMethodBeat.m2504i(28967);
        MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", C5046bo.anT() - TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC).commit();
        mo69850aB(2, true);
        dnl();
        AppMethodBeat.m2505o(28967);
    }

    private void dnF() {
        AppMethodBeat.m2504i(28968);
        if (this.rlf == 2 && !C5023at.isWifi(this.mContext)) {
            C44212i.dny();
            C4990ab.m7416i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
            AppMethodBeat.m2505o(28968);
        } else if (this.rlf == 2 && C23488f.amb(this.cvZ)) {
            C4990ab.m7412e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
            this.xxb.stop();
            AppMethodBeat.m2505o(28968);
        } else {
            this.xxb.mo39144ee(this.cvZ, this.size);
            if (this.xwO != null) {
                mo69850aB(1, false);
                this.xwZ = true;
                this.xwO.mo56706a(this.xxd);
                cpu();
                if (this.rlf == 2) {
                    C44212i.dny();
                }
            }
            AppMethodBeat.m2505o(28968);
        }
    }

    private void dnG() {
        AppMethodBeat.m2504i(28969);
        cancel();
        C4990ab.m7416i("MicroMsg.UpdaterManager", "downloadFullPack");
        C44212i.m79787ap(this.mContext, 7);
        if (this.xvX == null || this.xvX.length <= 0) {
            this.xwO = new C46611b(this.size, this.cvZ, this.xvw, this.uin, this.gcA, this.cPB, this.xwQ, this.rlf == 2);
            C7060h.pYm.mo8378a(405, 77, 1, true);
        } else {
            this.xwO = new C40609c(this.size, this.cvZ, this.xvw, this.xvX, this.rlf == 2);
            C7060h.pYm.mo8378a(405, 76, 1, true);
        }
        dnF();
        AppMethodBeat.m2505o(28969);
    }

    /* renamed from: dN */
    public final void mo10019dN(int i, int i2) {
        AppMethodBeat.m2504i(28970);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((C30281g) it.next()).mo10019dN(i, i2);
        }
        AppMethodBeat.m2505o(28970);
    }

    public final void cpu() {
        AppMethodBeat.m2504i(28971);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((C30281g) it.next()).cpu();
        }
        AppMethodBeat.m2505o(28971);
    }

    /* renamed from: YJ */
    public final void mo10016YJ(String str) {
        AppMethodBeat.m2504i(28972);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((C30281g) it.next()).mo10016YJ(str);
        }
        AppMethodBeat.m2505o(28972);
    }

    /* renamed from: a */
    public final void mo10017a(C15412c c15412c) {
        AppMethodBeat.m2504i(28973);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((C30281g) it.next()).mo10017a(c15412c);
        }
        AppMethodBeat.m2505o(28973);
    }

    public final void dnk() {
        AppMethodBeat.m2504i(28974);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((C30281g) it.next()).dnk();
        }
        AppMethodBeat.m2505o(28974);
    }

    public final void dnl() {
        AppMethodBeat.m2504i(28975);
        Iterator it = this.xwP.iterator();
        while (it.hasNext()) {
            ((C30281g) it.next()).dnl();
        }
        AppMethodBeat.m2505o(28975);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(28977);
        C4990ab.m7416i("MicroMsg.UpdaterManager", "onDestroy");
        if (!this.xwZ) {
            reset();
            mo69850aB(1, true);
        }
        AppMethodBeat.m2505o(28977);
    }

    public final boolean isBusy() {
        AppMethodBeat.m2504i(28976);
        if (this.xwZ || System.currentTimeMillis() - this.xxa <= UpdaterService.xxj) {
            C4990ab.m7417i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", Boolean.valueOf(this.xwZ), Long.valueOf(this.xxa), Long.valueOf(System.currentTimeMillis() - this.xxa));
            AppMethodBeat.m2505o(28976);
            return true;
        }
        C4990ab.m7416i("MicroMsg.UpdaterManager", "not busy");
        AppMethodBeat.m2505o(28976);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m79797a(C44215j c44215j, int i, int i2) {
        AppMethodBeat.m2504i(28978);
        String string = c44215j.mContext.getString(C25738R.string.f9095pc);
        if (i < i2) {
            long j = (((long) i) * 100) / ((long) i2);
            if (j - c44215j.xxc >= 1) {
                c44215j.xxc = j;
                String str = c44215j.mContext.getString(C25738R.string.f9098pf) + String.valueOf(c44215j.xxc) + "%";
                Intent intent = new Intent(c44215j.intent);
                intent.setClass(c44215j.mContext, AppUpdaterUI.class);
                intent.addFlags(536870912);
                PendingIntent activity = PendingIntent.getActivity(c44215j.mContext, 0, intent, 134217728);
                C0358c e = C45186a.m83262bt(c44215j.mContext, "reminder_channel_id").mo625g(null).mo626j(System.currentTimeMillis()).mo621d(string).mo623e(str);
                e.f362EI = activity;
                e.f365EL = BitmapFactory.decodeResource(c44215j.mContext.getResources(), C25738R.drawable.aq9);
                e.mo616as(C45186a.bWV());
                c44215j.oHJ = e.build();
                c44215j.oHJ.icon = C25738R.drawable.aq9;
            }
            AppMethodBeat.m2505o(28978);
        } else if (!c44215j.xwY || C1173e.m2561ct(c44215j.xwO.dne())) {
            PendingIntent activity2;
            String string2 = c44215j.mContext.getString(C25738R.string.f9094pa);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            C15429k.m23713a(c44215j.mContext, intent2, new File(c44215j.xwO.dne()), "application/vnd.android.package-archive");
            intent2.addFlags(536870912);
            if (VERSION.SDK_INT >= 26) {
                Intent intent3 = new Intent(C4996ah.getContext(), PermissionActivity.class);
                intent3.putExtra("scene", 3);
                intent3.setSelector(intent2);
                activity2 = PendingIntent.getActivity(c44215j.mContext, 0, intent3, 134217728);
            } else {
                activity2 = PendingIntent.getActivity(c44215j.mContext, 0, intent2, 134217728);
            }
            C0358c e2 = C45186a.m83262bt(c44215j.mContext, "reminder_channel_id").mo625g(null).mo626j(System.currentTimeMillis()).mo621d(string).mo623e(string2);
            e2.f362EI = activity2;
            e2.f365EL = BitmapFactory.decodeResource(c44215j.mContext.getResources(), C25738R.drawable.aq9);
            e2.mo616as(C45186a.bWV());
            c44215j.oHJ = e2.build();
            c44215j.oHJ.icon = C25738R.drawable.aq9;
            Notification notification = c44215j.oHJ;
            notification.flags |= 16;
        } else {
            C4990ab.m7416i("MicroMsg.UpdaterManager", "do noting. wait for merge apk.");
        }
        if (!c44215j.xwV) {
            ((NotificationManager) c44215j.mContext.getSystemService("notification")).notify(99, c44215j.oHJ);
        }
        AppMethodBeat.m2505o(28978);
    }

    /* renamed from: b */
    static /* synthetic */ void m79798b(C44215j c44215j) {
        AppMethodBeat.m2504i(28980);
        C4990ab.m7416i("MicroMsg.UpdaterManager", "showDownloadFullPackNotification()");
        String string = c44215j.mContext.getString(C25738R.string.f9097pe, new Object[]{C5046bo.m7565ga((long) c44215j.size)});
        Intent intent = c44215j.intent;
        intent.putExtra("intent_extra_force_download_full", true);
        PendingIntent service = PendingIntent.getService(c44215j.mContext, 0, intent, 134217728);
        C0358c e = C45186a.m83262bt(c44215j.mContext, "reminder_channel_id").mo625g(null).mo626j(System.currentTimeMillis()).mo621d(string).mo623e(null);
        e.f362EI = service;
        c44215j.oHJ = e.build();
        c44215j.oHJ.icon = C25738R.drawable.aq9;
        Notification notification = c44215j.oHJ;
        notification.flags |= 16;
        ((NotificationManager) c44215j.mContext.getSystemService("notification")).notify(99, c44215j.oHJ);
        AppMethodBeat.m2505o(28980);
    }

    /* renamed from: e */
    static /* synthetic */ void m79801e(C44215j c44215j) {
        AppMethodBeat.m2504i(28983);
        String string = c44215j.mContext.getString(C25738R.string.f9096pd);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
        intent.addFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(c44215j.mContext, 0, intent, 134217728);
        C0358c e = C45186a.m83262bt(c44215j.mContext, "reminder_channel_id").mo625g(null).mo626j(System.currentTimeMillis()).mo621d(string).mo623e(null);
        e.f362EI = activity;
        c44215j.oHJ = e.build();
        c44215j.oHJ.icon = C25738R.drawable.aq9;
        Notification notification = c44215j.oHJ;
        notification.flags |= 16;
        ((NotificationManager) c44215j.mContext.getSystemService("notification")).notify(99, c44215j.oHJ);
        AppMethodBeat.m2505o(28983);
    }
}
