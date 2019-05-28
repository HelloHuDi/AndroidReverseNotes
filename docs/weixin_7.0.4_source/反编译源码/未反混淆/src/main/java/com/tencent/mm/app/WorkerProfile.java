package com.tencent.mm.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Message;
import android.os.Process;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.v;
import com.tencent.mm.ai.v.a;
import com.tencent.mm.at.o;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.d;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.console.Shell;
import com.tencent.mm.console.Shell.Receiver;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.am;
import com.tencent.mm.model.an;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import com.tencent.mm.ui.u;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public final class WorkerProfile extends e implements f, a, am, com.tencent.mm.model.f.a, IKVReportNotify {
    public static final String ceo = (ah.getPackageName());
    private static WorkerProfile cfI;
    private static int cfX = -1;
    private final int ID = 2130706432;
    private final Shell cfG = new Shell();
    private final com.tencent.mm.console.a cfH = new com.tencent.mm.console.a();
    private an cfJ;
    private b cfK;
    private ae cfL;
    public boolean cfM = false;
    @Deprecated
    public boolean cfN;
    public boolean cfO;
    private final int cfP = 0;
    private final int cfQ = 1;
    private int cfR;
    private StringBuilder cfS = new StringBuilder();
    private g cfT;
    private com.tencent.mm.h.b cfU;
    public final y cfV = new y();
    public final x cfW = new x();
    private boolean cfY = false;
    protected Locale locale;

    static /* synthetic */ int Cd() {
        int i = cfX;
        cfX = i + 1;
        return i;
    }

    static {
        AppMethodBeat.i(15558);
        AppMethodBeat.o(15558);
    }

    public WorkerProfile() {
        AppMethodBeat.i(15547);
        cfI = this;
        AppMethodBeat.o(15547);
    }

    public static WorkerProfile Ca() {
        return cfI;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x07af  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x062b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0701 A:{Splitter:B:10:0x00fa, ExcHandler: NameNotFoundException (e android.content.pm.PackageManager$NameNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0701 A:{Splitter:B:10:0x00fa, ExcHandler: NameNotFoundException (e android.content.pm.PackageManager$NameNotFoundException)} */
    /* JADX WARNING: Missing block: B:89:0x0702, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate() {
        AppMethodBeat.i(15548);
        long currentTimeMillis = System.currentTimeMillis();
        ab.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
        ab.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + ceo + Process.myPid());
        ab.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", Boolean.TRUE, Thread.currentThread().getName());
        long currentTimeMillis2 = System.currentTimeMillis();
        com.tencent.mm.model.d.a abl = com.tencent.mm.model.d.a.abl();
        com.tencent.mm.model.d.a.ceK = ceo;
        if (ah.xzd) {
            ab.i("MicroMsg.HandlerTraceManager", "trace setup delete old file ret: ".concat(String.valueOf(com.tencent.mm.a.e.deleteFile(com.tencent.mm.model.d.a.foO))));
        }
        abl.fpd = System.currentTimeMillis();
        ak.setLogCallback(new ak.b() {
            public final void a(Message message, Runnable runnable, Thread thread, long j, long j2, float f) {
                AppMethodBeat.i(16372);
                if (thread == null) {
                    AppMethodBeat.o(16372);
                    return;
                }
                long id = thread.getId();
                String str = null;
                if (j > a.this.foS) {
                    if (message != null) {
                        str = "|HMonitor dispatch|msg = " + message + "|handler = " + message.getTarget() + "|threadName = " + thread.getName() + "|threadId = " + thread.getId() + "|priority = " + thread.getPriority() + "|usedTime = " + j + "|cpuTime = " + j2;
                    } else if (runnable != null) {
                        str = "|HMonitor run task|" + ak.dump(runnable, true);
                    }
                } else if (j > a.this.foT && id == a.foR) {
                    if (message != null) {
                        str = "|HMonitor dispatch|msg = " + message + "|handler = " + message.getTarget() + "|threadName = " + thread.getName() + "|threadId = " + thread.getId() + "|priority = " + thread.getPriority() + "|usedTime = " + j + "|cpuTime = " + j2;
                    } else if (runnable != null) {
                        str = "|HMonitor run task|" + ak.dump(runnable, true);
                    }
                }
                if (aw.RS().oAl.getLooper() == null) {
                    ab.w("MicroMsg.HandlerTraceManager", "worker thread's looper is dead");
                    AppMethodBeat.o(16372);
                    return;
                }
                if (runnable != null && j > a.this.foY && id == a.this.fpe) {
                    a aVar = new a();
                    aVar.fpi = j;
                    aVar.info = ak.dump(runnable, false);
                    if (a.this.fpg.size() >= a.this.foZ) {
                        a.this.fpg.pop();
                    }
                    a.this.fpg.add(aVar);
                }
                if (runnable != null && id == a.this.fpe && f > 0.0f && f <= 100.0f) {
                    Long[] g;
                    if (f < 30.0f) {
                        g = a.this.fpc;
                        int i = (int) (f / 2.0f);
                        g[i] = Long.valueOf(g[i].longValue() + 1);
                    } else if (f < 40.0f) {
                        g = a.this.fpc;
                        g[15] = Long.valueOf(g[15].longValue() + 1);
                    } else if (f < 50.0f) {
                        g = a.this.fpc;
                        g[16] = Long.valueOf(g[16].longValue() + 1);
                    } else {
                        g = a.this.fpc;
                        g[17] = Long.valueOf(g[17].longValue() + 1);
                    }
                }
                if (System.currentTimeMillis() - a.this.fpd > ((long) a.this.fpb)) {
                    a.this.fpd = System.currentTimeMillis();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= 18) {
                            break;
                        }
                        if (a.this.fpc[i3].longValue() > 0) {
                            h.pYm.a(230, (long) i3, a.this.fpc[i3].longValue(), false);
                        }
                        i2 = i3 + 1;
                    }
                }
                if (str == null) {
                    AppMethodBeat.o(16372);
                    return;
                }
                if (!com.tencent.mm.sdk.a.b.foreground) {
                    ab.i("MicroMsg.HandlerTraceManager", str);
                }
                if (a.this.foQ) {
                    AppMethodBeat.o(16372);
                    return;
                }
                a.a(a.this, a.sDateFormat.format(new Date()) + str + IOUtils.LINE_SEPARATOR_UNIX);
                AppMethodBeat.o(16372);
            }
        });
        ao.a("NetsceneQueue forbid in ", new ao.b() {
            public final String abq() {
                AppMethodBeat.i(16373);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("worker thread id = " + aw.RS().oAl.getLooper().getThread().getId() + "[" + aw.RS().doL() + "]\n");
                stringBuilder.append("#cpu freq(KHz)[max=" + m.Lx() + ", min=" + m.Ly() + ", cur=" + m.Lz() + "]\n");
                LinkedList linkedList = new LinkedList(a.this.fpg);
                Iterator it = linkedList.iterator();
                stringBuilder.append("#done tasks size = " + linkedList.size() + 10);
                if (it != null) {
                    int i = 0;
                    while (it.hasNext() && i < a.this.fpa) {
                        stringBuilder.append("[index = " + i + " | taskinfo:" + ((a) it.next()).info + "]\n");
                        i++;
                    }
                }
                stringBuilder.append("\n#waiting" + aw.RS().doN().dump(false));
                String stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.o(16373);
                return stringBuilder2;
            }
        });
        aw.Rg().a(-1, (f) this);
        v.a(this);
        aw.ZN().fkz = this;
        aw.a(new n.a() {
            public final void gl(int i) {
                AppMethodBeat.i(15488);
                if (i != 4 && i != 6) {
                    AppMethodBeat.o(15488);
                } else if (aw.RK() && com.tencent.mm.kernel.g.RN().eJb && !aw.QT()) {
                    ab.i("MicroMsg.WorkerProfile", "dkmsg Network connected , try send msg.");
                    aw.Rg().a(new com.tencent.mm.modelmulti.h(), 0);
                    AppMethodBeat.o(15488);
                } else {
                    AppMethodBeat.o(15488);
                }
            }
        });
        aw.getSysCmdMsgExtension().a("getkvidkeystg", new bz.a() {
            public final void a(com.tencent.mm.ai.e.a aVar) {
                AppMethodBeat.i(15512);
                i.Wa(aa.a(aVar.eAB.vED));
                AppMethodBeat.o(15512);
            }
        }, true);
        Application application = this.app;
        com.tencent.mm.sdk.platformtools.g.gj(application);
        com.tencent.mm.sdk.platformtools.g.gk(application);
        try {
            com.tencent.mm.c.a aVar;
            String str = application.getPackageManager().getPackageInfo(application.getPackageName(), 0).applicationInfo.sourceDir;
            ab.i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", str);
            try {
                int cs = com.tencent.mm.a.e.cs(str);
                ab.i("MicroMsg.WorkerProfile", "checkApkExternal, fileSize = %s", Integer.valueOf(cs));
                if (cs >= 8) {
                    com.tencent.mm.c.a.a C = com.tencent.mm.c.a.a.C(com.tencent.mm.a.e.f(str, cs - 8, 8));
                    if (C == null) {
                        ab.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
                    } else if ((C.cde + 8) - 8 >= 0) {
                        com.tencent.mm.c.b bVar = new com.tencent.mm.c.b();
                        bVar.parseFrom(com.tencent.mm.a.e.f(str, (cs - ((C.cde + 8) - 8)) - 8, (C.cde + 8) - 8));
                        aVar = new com.tencent.mm.c.a(bVar);
                        ab.i("MicroMsg.WorkerProfile", "checkApkExternal, check ok");
                    } else {
                        ab.e("MicroMsg.WorkerProfile", "checkApkExternal header wrong");
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                ab.e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", e.getMessage());
            } catch (NameNotFoundException e2) {
            }
            aVar = com.tencent.mm.c.a.cL(str);
            d bo;
            Context applicationContext;
            int i;
            int i2;
            SharedPreferences sharedPreferences;
            int i3;
            int i4;
            Editor edit;
            c cVar;
            com.tencent.mm.h.b bVar2;
            AnonymousClass27 anonymousClass27;
            if (aVar == null || aVar.cdc == null) {
                str = "MicroMsg.WorkerProfile";
                String str2 = "initChannelUtil something null %s";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(aVar == null);
                ab.e(str, str2, objArr);
                d.Ba();
                bo = d.bo(this.app);
                if (!(bo == null || bo.ebO == -1)) {
                    com.tencent.mm.sdk.platformtools.g.cdf = bo.ebO;
                }
                applicationContext = this.app.getApplicationContext();
                i = com.tencent.mm.sdk.platformtools.g.cdf;
                i2 = com.tencent.mm.protocal.d.vxo;
                if (applicationContext != null && i >= 0 && i2 >= 637534208) {
                    try {
                        sharedPreferences = applicationContext.getSharedPreferences("crash_status_file", 4);
                        i3 = sharedPreferences.getInt("channel", -1);
                        i4 = sharedPreferences.getInt("version", 0);
                        if (!(i3 == i && i4 == i2)) {
                            edit = sharedPreferences.edit();
                            edit.putInt("channel", i);
                            edit.putInt("version", i2);
                            edit.commit();
                        }
                    } catch (Throwable th) {
                    }
                }
                if (com.tencent.mm.sdk.platformtools.g.xyb > 0) {
                    com.tencent.mm.sdk.platformtools.g.xyd = true;
                }
                com.tencent.mm.bp.d.dlL();
                com.tencent.mm.protocal.d.eSg = "android-" + (bo.isNullOrNil(com.tencent.mm.sdk.platformtools.g.cdg) ? Integer.valueOf(VERSION.SDK_INT) : com.tencent.mm.sdk.platformtools.g.cdg);
                if (!bo.isNullOrNil(com.tencent.mm.sdk.a.b.dnP())) {
                    com.tencent.mm.protocal.d.eSg = "android-" + com.tencent.mm.sdk.a.b.dnP();
                }
                ab.v("MicroMsg.WorkerProfile", "set device type :%s  %s", com.tencent.mm.protocal.d.eSg, com.tencent.mm.sdk.a.b.dnP());
                this.locale = MMActivity.initLanguage(this.app.getBaseContext());
                if (com.tencent.mm.sdk.a.b.dnO()) {
                    Shell shell = this.cfG;
                    Context context = ah.getContext();
                    if (shell.ewv == null) {
                        shell.ewv = new Receiver();
                        context.registerReceiver(shell.ewv, Shell.ewx);
                    }
                }
                com.tencent.mm.sdk.b.a.xxA.c(this.cfH);
                cVar = new c();
                ab.d("MicroMsg.AvatarDrawable", "setLoader".concat(String.valueOf(cVar)));
                com.tencent.mm.pluginsdk.ui.a.b.pqK = cVar;
                com.tencent.mm.pluginsdk.f.e.vdx = new com.tencent.mm.pluginsdk.f.e.a() {
                    public final void bd(Context context) {
                        AppMethodBeat.i(138593);
                        MMAppMgr.bd(context);
                        AppMethodBeat.o(138593);
                    }

                    public final boolean Ch() {
                        AppMethodBeat.i(138594);
                        boolean Ch = MMAppMgr.Ch();
                        AppMethodBeat.o(138594);
                        return Ch;
                    }

                    public final void k(Context context, boolean z) {
                        AppMethodBeat.i(138595);
                        MMAppMgr.k(context, z);
                        AppMethodBeat.o(138595);
                    }

                    public final void be(Context context) {
                        AppMethodBeat.i(138596);
                        MMAppMgr.be(context);
                        AppMethodBeat.o(138596);
                    }
                };
                com.tencent.mm.kernel.g.a(com.tencent.mm.ai.i.class, new com.tencent.mm.kernel.c.e(this.cfW));
                com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.h.class, new com.tencent.mm.kernel.c.e(this.cfW));
                com.tencent.mm.kernel.g.a(j.class, new com.tencent.mm.kernel.c.e(this.cfW));
                com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.brandservice.a.a.class, new com.tencent.mm.plugin.bbom.d());
                com.tencent.mm.kernel.g.a(q.class, new com.tencent.mm.app.plugin.d());
                com.tencent.mm.kernel.g.a(com.tencent.mm.choosemsgfile.compat.b.class, new com.tencent.mm.ui.chatting.b.a());
                com.tencent.mm.sdk.b.a.xxA.c(new com.tencent.mm.app.plugin.b.a.a());
                if (this.cfJ == null) {
                    this.cfJ = new com.tencent.mm.booter.notification.b(this.app);
                }
                this.cfU = new com.tencent.mm.h.b();
                bVar2 = this.cfU;
                ab.i("MicroMsg.BroadcastController", "summerdiz init");
                com.tencent.mm.sdk.b.a.xxA.c(bVar2.eeX);
                com.tencent.mm.sdk.b.a.xxA.c(new c<gn>() {
                    {
                        AppMethodBeat.i(105677);
                        this.xxI = gn.class.getName().hashCode();
                        AppMethodBeat.o(105677);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(105678);
                        for (String str : b.this.eML.keySet()) {
                            c cVar = (c) b.this.eML.get(str);
                            cVar.eNd.clear();
                            b.a(b.this, cVar);
                        }
                        AppMethodBeat.o(105678);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new com.tencent.mm.plugin.account.bind.ui.e());
                com.tencent.mm.sdk.b.a.xxA.c(new c<jl>() {
                    {
                        AppMethodBeat.i(15534);
                        this.xxI = jl.class.getName().hashCode();
                        AppMethodBeat.o(15534);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        boolean z = true;
                        AppMethodBeat.i(15535);
                        jl jlVar = (jl) bVar;
                        if (jlVar.cEK.boZ != 2 && jlVar.cEK.status == 0) {
                            com.tencent.mm.cj.c.atD("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE");
                        }
                        if (aw.RK()) {
                            boolean z2 = jlVar.cEK.boZ == 3;
                            if (jlVar.cEK.boZ != 1) {
                                z = false;
                            }
                            if (z2) {
                                av.fly.ak("login_user_name", "");
                                com.tencent.mm.kernel.a.QJ();
                            } else {
                                if (z) {
                                    com.tencent.mm.kernel.a.QJ();
                                }
                                av avVar = av.fly;
                                aw.ZK();
                                String str = (String) com.tencent.mm.model.c.Ry().get(6, null);
                                aw.ZK();
                                int intValue = ((Integer) com.tencent.mm.model.c.Ry().get(9, null)).intValue();
                                aw.ZK();
                                avVar.c(str, intValue, (String) com.tencent.mm.model.c.Ry().get(5, null));
                            }
                        }
                        AppMethodBeat.o(15535);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<tf>() {
                    {
                        AppMethodBeat.i(15536);
                        this.xxI = tf.class.getName().hashCode();
                        AppMethodBeat.o(15536);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15537);
                        tf tfVar = (tf) bVar;
                        if (tfVar.cPv.cPw == 3) {
                            NotifyReceiver.Im();
                        }
                        com.tencent.mm.cf.d.dvV().ev(tfVar.cPv.className, tfVar.cPv.cPw);
                        AppMethodBeat.o(15537);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<iu>() {
                    {
                        AppMethodBeat.i(15539);
                        this.xxI = iu.class.getName().hashCode();
                        AppMethodBeat.o(15539);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15540);
                        iu iuVar = (iu) bVar;
                        final String str = iuVar.cDU.imagePath;
                        final String str2 = iuVar.cDU.toUser;
                        final boolean booleanValue = iuVar.cDU.cDV.booleanValue();
                        final int i = iuVar.cDU.cDW;
                        if (iuVar.cDU.cDX.booleanValue()) {
                            aw.RS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(15538);
                                    if (com.tencent.mm.kernel.g.RN().QY()) {
                                        com.tencent.mm.at.n.ahb().a(0, i, str, str2, booleanValue);
                                        AppMethodBeat.o(15538);
                                        return;
                                    }
                                    ab.w("MicroMsg.WorkerProfile", "ImageSelectedOperationEvent: account not init.");
                                    AppMethodBeat.o(15538);
                                }
                            });
                        }
                        AppMethodBeat.o(15540);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<ub>() {
                    {
                        AppMethodBeat.i(15541);
                        this.xxI = ub.class.getName().hashCode();
                        AppMethodBeat.o(15541);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15542);
                        ab.i("MicroMsg.WorkerProfile", "upload sql file");
                        com.tencent.mm.model.d.b.abr().pg(com.tencent.mm.model.d.b.pe(com.tencent.mm.model.d.b.fpk + "MMSQL.trace"));
                        AppMethodBeat.o(15542);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<qb>() {
                    {
                        AppMethodBeat.i(15543);
                        this.xxI = qb.class.getName().hashCode();
                        AppMethodBeat.o(15543);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15544);
                        qb qbVar = (qb) bVar;
                        for (String hVar : bo.P(qbVar.cMq.cMr.split(","))) {
                            aw.Rg().a(new com.tencent.mm.modelmulti.h(hVar, qbVar.cMq.content, qbVar.cMq.type), 0);
                        }
                        AppMethodBeat.o(15544);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<py>() {
                    {
                        AppMethodBeat.i(15545);
                        this.xxI = py.class.getName().hashCode();
                        AppMethodBeat.o(15545);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15546);
                        py pyVar = (py) bVar;
                        for (String str : bo.P(pyVar.cMe.toUser.split(","))) {
                            if (bo.isNullOrNil(pyVar.cMe.cMi)) {
                                WXMediaMessage wXMediaMessage = pyVar.cMe.cEl;
                                String str2 = pyVar.cMe.appId;
                                String str3 = pyVar.cMe.appName;
                                int i = pyVar.cMe.cMf;
                                String str4 = pyVar.cMe.cMg;
                                String str5 = pyVar.cMe.cMh;
                                String str6 = pyVar.cMe.cMj;
                                String str7 = pyVar.cMe.cMk;
                                String str8 = pyVar.cMe.cMl;
                                String str9 = pyVar.cMe.cMm;
                                String str10 = pyVar.cMe.cvF;
                                String str11 = pyVar.cMe.cMn;
                                com.tencent.mm.pluginsdk.model.app.b bVar2 = null;
                                com.tencent.mm.af.j.b bVar3 = new com.tencent.mm.af.j.b();
                                com.tencent.mm.model.v.b y = com.tencent.mm.model.v.Zp().y(str10, true);
                                if (y.containsKey("_DATA_CENTER_ITEM_SHOW_TYPE")) {
                                    int i2 = y.getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
                                    if (i2 != -1) {
                                        com.tencent.mm.af.f eVar = new com.tencent.mm.af.e();
                                        eVar.ffZ = i2;
                                        if (i2 == 5) {
                                            eVar.fgd = y.getString("_DATA_CENTER_VID", "");
                                            eVar.fga = y.getInt("_DATA_CENTER_PUB_TIME", 0);
                                            eVar.duration = y.getInt("_DATA_CENTER__DULATION", 0);
                                            eVar.videoWidth = y.getInt("_DATA_CENTER_VIDEO_WIDTH", 0);
                                            eVar.videoHeight = y.getInt("_DATA_CENTER_VIDEO_HEIGHT", 0);
                                            eVar.fgc = y.getInt("_DATA_CENTER_FUNC_FLAG", 0);
                                        }
                                        bVar3.a(eVar);
                                    }
                                    bVar3.thumburl = y.getString("_DATA_CENTER_COVER_URL", "");
                                }
                                bVar3.appId = str2;
                                bVar3.appName = str3;
                                bVar3.fgr = i;
                                bVar3.cMg = str4;
                                bVar3.cMh = str5;
                                bVar3.cMj = str6;
                                bVar3.cMk = str7;
                                bVar3.cMl = str8;
                                bVar3.cMm = str9;
                                bVar3.cMn = str11;
                                str2 = l.b(bVar3, wXMediaMessage, null);
                                ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Mq() + " content url:" + bVar3.url + " lowUrl:" + bVar3.fgn + " attachlen:" + bVar3.fgo + " attachid:" + bVar3.csD + " attach file:" + str2);
                                String str12 = System.currentTimeMillis();
                                if (!bo.isNullOrNil(str2)) {
                                    bVar2 = l.a(str12, bVar3, str2);
                                    if (bVar2 == null) {
                                        com.tencent.mm.compatible.util.g.getLine();
                                    }
                                }
                                bi biVar = new bi();
                                if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                                    str2 = o.ahl().a(wXMediaMessage.thumbData, bVar3.type == 2, CompressFormat.PNG);
                                    ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Mq() + " thumbData MsgInfo path:" + str2);
                                    if (!bo.isNullOrNil(str2)) {
                                        biVar.jv(str2);
                                        ab.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path".concat(String.valueOf(str2)));
                                    }
                                }
                                if (bVar2 != null) {
                                    bVar3.csD = bVar2.xDa;
                                }
                                biVar.setContent(com.tencent.mm.af.j.b.a(bVar3, null, null));
                                biVar.setStatus(1);
                                biVar.ju(str);
                                biVar.eJ(bf.oC(str));
                                biVar.hO(1);
                                biVar.setType(l.d(bVar3));
                                if (com.tencent.mm.aj.f.kq(biVar.field_talker)) {
                                    biVar.ix(com.tencent.mm.aj.a.e.aae());
                                    ab.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", biVar.dqJ);
                                }
                                aw.ZK();
                                long Z = com.tencent.mm.model.c.XO().Z(biVar);
                                ab.d("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Mq() + " msginfo insert id: " + Z);
                                if (Z < 0) {
                                    ab.e("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.Mq() + "insert msg failed :" + Z);
                                    com.tencent.mm.compatible.util.g.getLine();
                                } else {
                                    ab.i("MicroMsg.AppMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + Z);
                                    biVar.setMsgId(Z);
                                    com.tencent.mm.af.j jVar = new com.tencent.mm.af.j();
                                    jVar.field_xml = biVar.field_content;
                                    jVar.field_title = wXMediaMessage.title;
                                    jVar.field_type = wXMediaMessage.mediaObject.type();
                                    jVar.field_description = wXMediaMessage.description;
                                    jVar.field_msgId = Z;
                                    jVar.field_source = str3;
                                    com.tencent.mm.pluginsdk.model.app.am.dhN().b((com.tencent.mm.sdk.e.c) jVar);
                                    if (bVar2 != null) {
                                        bVar2.field_msgInfoId = Z;
                                        bVar2.field_status = 101;
                                        com.tencent.mm.pluginsdk.model.app.am.aUq().a(bVar2, new String[0]);
                                        com.tencent.mm.pluginsdk.model.app.am.dhP().run();
                                    } else {
                                        com.tencent.mm.pluginsdk.model.app.am.dhP();
                                        al.a.A(Z, str10);
                                    }
                                }
                            } else {
                                l.a(pyVar.cMe.cEl, pyVar.cMe.appId, pyVar.cMe.appName, str, pyVar.cMe.cMf, pyVar.cMe.cMi);
                            }
                        }
                        AppMethodBeat.o(15546);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<qh>() {
                    {
                        AppMethodBeat.i(15465);
                        this.xxI = qh.class.getName().hashCode();
                        AppMethodBeat.o(15465);
                    }

                    public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15466);
                        qh qhVar = (qh) bVar;
                        com.tencent.mm.ui.contact.e.a(qhVar.cMw.intent, qhVar.cMw.username);
                        AppMethodBeat.o(15466);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<com.tencent.mm.g.a.c>() {
                    {
                        AppMethodBeat.i(15467);
                        this.xxI = com.tencent.mm.g.a.c.class.getName().hashCode();
                        AppMethodBeat.o(15467);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15468);
                        com.tencent.mm.g.a.c cVar = (com.tencent.mm.g.a.c) bVar;
                        MMActivity mMActivity = cVar.crO.crP;
                        u.a(mMActivity, cVar.crO.errType, cVar.crO.errCode, new Intent().setClass(mMActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), null);
                        AppMethodBeat.o(15468);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<ja>() {
                    {
                        AppMethodBeat.i(15469);
                        this.xxI = ja.class.getName().hashCode();
                        AppMethodBeat.o(15469);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15470);
                        ja jaVar = (ja) bVar;
                        String str = jaVar.cEg.cEh;
                        String str2 = jaVar.cEg.url;
                        ab.i("MicroMsg.WorkerProfile", "summertoken KickOffline callback wording[%s], url[%s]", str, str2);
                        h.pYm.a(322, 21, 1, true);
                        LauncherUI instance = LauncherUI.getInstance();
                        h hVar = h.pYm;
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(4021);
                        String str3 = "%s|%s|%b";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = str;
                        objArr2[1] = str2;
                        boolean z = instance == null || instance.isFinishing();
                        objArr2[2] = Boolean.valueOf(z);
                        objArr[1] = String.format(str3, objArr2);
                        hVar.e(11098, objArr);
                        if (instance == null || instance.isFinishing()) {
                            h.pYm.a(322, 22, 1, true);
                            hVar = h.pYm;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(4022);
                            str3 = "%s|%s|%b";
                            objArr2 = new Object[3];
                            objArr2[0] = str;
                            objArr2[1] = str2;
                            objArr2[2] = Boolean.valueOf(instance == null);
                            objArr[1] = String.format(str3, objArr2);
                            hVar.e(11098, objArr);
                            ab.w("MicroMsg.WorkerProfile", "summertoken KickOffline error LauncherUI is null launcherisFirst[%b], launcheruiOnTop[%b] return", Boolean.valueOf(WorkerProfile.this.cfN), Boolean.valueOf(WorkerProfile.this.cfO));
                        }
                        u.a(instance, str, str2, new Intent().setClass(instance, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864));
                        AppMethodBeat.o(15470);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<sj>() {
                    {
                        AppMethodBeat.i(15471);
                        this.xxI = sj.class.getName().hashCode();
                        AppMethodBeat.o(15471);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15472);
                        sj sjVar = (sj) bVar;
                        Context context = sjVar.cOF.context;
                        String str = sjVar.cOF.cOG;
                        if (context == null || bo.isNullOrNil(str)) {
                            AppMethodBeat.o(15472);
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                            AppMethodBeat.o(15472);
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<kz>() {
                    {
                        AppMethodBeat.i(15473);
                        this.xxI = kz.class.getName().hashCode();
                        AppMethodBeat.o(15473);
                    }

                    @TargetApi(16)
                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        Notification a;
                        AppMethodBeat.i(15474);
                        kz kzVar = (kz) bVar;
                        int dtd = com.tencent.mm.bi.d.akP().dtd();
                        int i = kzVar.cGR.type;
                        String str = kzVar.cGR.userName;
                        String anU = com.tencent.mm.cb.b.dqD().anU(kzVar.cGR.bCu);
                        if (WorkerProfile.this.cfT == null) {
                            WorkerProfile.this.cfT = new g(ah.getContext());
                        }
                        WorkerProfile.this.cfT;
                        int bWV = com.tencent.mm.bo.a.bWV();
                        Notification notification = new Notification();
                        notification.icon = R.drawable.icon;
                        notification.when = System.currentTimeMillis();
                        notification.flags = 16;
                        Intent intent = new Intent();
                        intent.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
                        intent.setFlags(335544320);
                        PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 0, intent, 134217728);
                        if (i == 1) {
                            String string = ah.getContext().getString(R.string.d9s);
                            Bitmap a2 = com.tencent.mm.ah.b.a(str, false, -1);
                            String str2 = anU + string;
                            String string2 = ah.getContext().getString(R.string.d95);
                            String string3 = ah.getContext().getString(R.string.bwi);
                            Intent intent2 = new Intent();
                            intent2.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                            intent2.putExtra("friend_message_transfer_username", str);
                            intent2.setAction("friend_message_ignore_".concat(String.valueOf(str)));
                            PendingIntent activity2 = PendingIntent.getActivity(ah.getContext(), 0, intent2, 134217728);
                            intent2 = new Intent();
                            intent2.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                            intent2.putExtra("friend_message_transfer_username", str);
                            intent2.setAction("friend_message_accept_".concat(String.valueOf(str)));
                            a = aw.getNotification().a(notification, bWV, activity, anU, string, str2, a2, string2, activity2, string3, PendingIntent.getActivity(ah.getContext(), 0, intent2, 134217728), str);
                        } else {
                            String str3;
                            String string4 = ah.getContext().getString(R.string.d9r);
                            if (dtd > 2) {
                                str3 = anU + ah.getContext().getString(R.string.d9o, new Object[]{Integer.valueOf(dtd)});
                            } else {
                                str3 = anU;
                            }
                            Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), bWV);
                            a = aw.getNotification().a(notification, bWV, 1, activity, str3, string4, str3 + string4, decodeResource, str);
                        }
                        if (VERSION.SDK_INT >= 16) {
                            a.priority = 2;
                        }
                        if (str != null) {
                            WorkerProfile.this.cfR = 2130706432 | (str.hashCode() & 16777215);
                        } else {
                            WorkerProfile.this.cfR = 2130706432;
                        }
                        aw.getNotification().a(WorkerProfile.this.cfR, a, false);
                        if (dtd == 0) {
                            com.tencent.mm.bi.d.eRI = 0;
                        } else {
                            WorkerProfile.this.cfS.append(WorkerProfile.this.cfR + ",");
                            ah.getContext().getSharedPreferences("notify_newfriend_prep", 0).edit().putString("notify_newfriend_prep", WorkerProfile.this.cfS.toString()).commit();
                        }
                        AppMethodBeat.o(15474);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<jc>() {
                    {
                        AppMethodBeat.i(15475);
                        this.xxI = jc.class.getName().hashCode();
                        AppMethodBeat.o(15475);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15476);
                        jc jcVar = (jc) bVar;
                        Context context = jcVar.cEj.context;
                        if (context == null) {
                            context = ah.getContext();
                        }
                        jcVar.cEk.cEn = com.tencent.mm.pluginsdk.model.app.g.a(context, jcVar.cEj.appId, jcVar.cEj.cEl, jcVar.cEj.showType, jcVar.cEj.cEm, jcVar.cEj.cvs);
                        AppMethodBeat.o(15476);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<fc>() {
                    {
                        AppMethodBeat.i(15477);
                        this.xxI = fc.class.getName().hashCode();
                        AppMethodBeat.o(15477);
                    }

                    private static boolean a(fc fcVar) {
                        AppMethodBeat.i(15478);
                        if (fcVar == null) {
                            ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is null.");
                            AppMethodBeat.o(15478);
                            return false;
                        } else if (!(fcVar instanceof fc)) {
                            ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is not a instance of ExtCallBizEvent.");
                            AppMethodBeat.o(15478);
                            return false;
                        } else if (fcVar.cyu == null) {
                            ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event.data is null.");
                            AppMethodBeat.o(15478);
                            return false;
                        } else {
                            Intent intent;
                            switch (fcVar.cyu.op) {
                                case 27:
                                    if (fcVar.cyu.selectionArgs == null || fcVar.cyu.selectionArgs.length < 2) {
                                        ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent selectionArgs error.");
                                        AppMethodBeat.o(15478);
                                        return true;
                                    }
                                    Object encode;
                                    String str = "";
                                    Object obj = fcVar.cyu.selectionArgs[0];
                                    String str2 = fcVar.cyu.selectionArgs[1];
                                    if (fcVar.cyu.selectionArgs.length >= 3) {
                                        Object nullAsNil = bo.nullAsNil(fcVar.cyu.selectionArgs[2]);
                                        try {
                                            encode = URLEncoder.encode(nullAsNil, "UTF-8");
                                        } catch (UnsupportedEncodingException e) {
                                            encode = nullAsNil;
                                        }
                                    } else {
                                        String encode2 = str;
                                    }
                                    if (obj == null || str2 == null) {
                                        ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent wrong args, %s, %s", obj, str2);
                                        AppMethodBeat.o(15478);
                                        return true;
                                    }
                                    int i;
                                    if (fcVar.cyu.selectionArgs.length >= 4) {
                                        str = fcVar.cyu.selectionArgs[3];
                                        if (!bo.isNullOrNil(str)) {
                                            i = bo.getInt(str, 0);
                                            ab.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
                                            str = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{str2, obj, encode2, Integer.valueOf(i), Integer.valueOf(0)});
                                            intent = new Intent(fcVar.cyu.context, WXCustomSchemeEntryActivity.class);
                                            intent.addFlags(268435456);
                                            intent.setData(Uri.parse(str));
                                            intent.putExtra("translate_link_scene", 1);
                                            fcVar.cyu.context.startActivity(intent);
                                            AppMethodBeat.o(15478);
                                            return true;
                                        }
                                    }
                                    i = 0;
                                    ab.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
                                    str = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{str2, obj, encode2, Integer.valueOf(i), Integer.valueOf(0)});
                                    intent = new Intent(fcVar.cyu.context, WXCustomSchemeEntryActivity.class);
                                    intent.addFlags(268435456);
                                    intent.setData(Uri.parse(str));
                                    intent.putExtra("translate_link_scene", 1);
                                    fcVar.cyu.context.startActivity(intent);
                                    AppMethodBeat.o(15478);
                                    return true;
                                case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                    ab.i("MicroMsg.WorkerProfile", "ExtCallBizEvent open exdevice rank list.");
                                    Context context = fcVar.cyu.context;
                                    intent = new Intent(context, WXBizEntryActivity.class);
                                    intent.addFlags(268435456);
                                    intent.putExtra("key_command_id", 11);
                                    context.startActivity(intent);
                                    AppMethodBeat.o(15478);
                                    return true;
                                default:
                                    boolean a = AnonymousClass8.a(fcVar.cyu.context, fcVar.cyu.selectionArgs, fcVar.cyu.crW, fcVar.cyu.cvd, fcVar.cyu.cyv);
                                    AppMethodBeat.o(15478);
                                    return a;
                            }
                        }
                    }

                    private static boolean a(Context context, String[] strArr, String[] strArr2, int i, String str) {
                        AppMethodBeat.i(15479);
                        if (context == null) {
                            ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:context is null.");
                            context = ah.getContext();
                        }
                        if (strArr == null || strArr.length < 2) {
                            ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:args error.");
                            AppMethodBeat.o(15479);
                            return false;
                        }
                        int i2;
                        int length = strArr.length;
                        for (i2 = 0; i2 < length; i2++) {
                            ab.i("MicroMsg.WorkerProfile", "arg : %s", strArr[i2]);
                        }
                        String str2 = strArr[0];
                        String str3 = strArr[1];
                        String str4 = null;
                        if (strArr.length > 2) {
                            str4 = strArr[2];
                        }
                        length = 0;
                        if (strArr.length > 3) {
                            length = bo.getInt(strArr[3], 0);
                        }
                        int i3 = 0;
                        if (strArr.length > 4) {
                            i3 = bo.getInt(strArr[4], 0);
                        }
                        ab.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source(%d)", Integer.valueOf(i));
                        switch (i) {
                            case 1:
                                if (strArr2 == null || strArr2.length == 0) {
                                    ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:packageNames is null or nil.");
                                    AppMethodBeat.o(15479);
                                    return false;
                                }
                            case 2:
                                if (bo.isNullOrNil(str)) {
                                    ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:fromURL(%s) is null or nil.", str);
                                    AppMethodBeat.o(15479);
                                    return false;
                                }
                                break;
                            default:
                                ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source is out of range.");
                                AppMethodBeat.o(15479);
                                return false;
                        }
                        ab.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener: appId(%s), toUserName(%s), extInfo(%s), fromURL(%s)", str2, str3, str4, str);
                        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
                            ab.e("MicroMsg.WorkerProfile", "appId or toUsername is null or nil.");
                            AppMethodBeat.o(15479);
                            return false;
                        }
                        int i4 = 0;
                        if (length == 1) {
                            i4 = 8;
                        } else if (length == 0) {
                            i4 = 7;
                        }
                        Intent intent = new Intent(context, WXBizEntryActivity.class);
                        intent.putExtra("key_command_id", i4);
                        intent.putExtra("appId", str2);
                        intent.putExtra("toUserName", str3);
                        intent.putExtra(IssueStorage.COLUMN_EXT_INFO, str4);
                        intent.putExtra("source", i);
                        intent.putExtra("scene", length);
                        intent.putExtra("jump_profile_type", i3);
                        intent.addFlags(268435456).addFlags(67108864);
                        if (strArr2 != null && strArr2.length > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (Object add : strArr2) {
                                arrayList.add(add);
                            }
                            intent.putStringArrayListExtra("androidPackNameList", arrayList);
                        }
                        context.startActivity(intent);
                        AppMethodBeat.o(15479);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<hm>() {
                    {
                        AppMethodBeat.i(15482);
                        this.xxI = hm.class.getName().hashCode();
                        AppMethodBeat.o(15482);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15483);
                        hm hmVar = (hm) bVar;
                        if (hmVar == null || hmVar.cCo == null) {
                            ab.w("MicroMsg.WorkerProfile", "summerdiz GetDisasterInfoEvent event null ret false");
                            AppMethodBeat.o(15483);
                        } else {
                            final int i = hmVar.cCo.cCp;
                            final boolean z = hmVar.cCo.cCq;
                            ab.i("MicroMsg.WorkerProfile", "summerdiz GetDisasterInfoEvent callback event noticeid[%d], manualauthSucc[%b]", Integer.valueOf(i), Boolean.valueOf(z));
                            aw.RS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(15481);
                                    aw.Rg().a(new k(i, z), 0);
                                    AppMethodBeat.o(15481);
                                }
                            });
                            AppMethodBeat.o(15483);
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<ov>() {
                    {
                        AppMethodBeat.i(15484);
                        this.xxI = ov.class.getName().hashCode();
                        AppMethodBeat.o(15484);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15485);
                        bi biVar = ((ov) bVar).cLh.csG;
                        if (biVar != null) {
                            ab.i("MicroMsg.WorkerProfile", "resend msg, type:%d", Integer.valueOf(biVar.getType()));
                            long oC;
                            if (biVar.drD()) {
                                com.tencent.mm.ui.chatting.ak.aQ(biVar);
                            } else if (biVar.drE()) {
                                com.tencent.mm.ui.chatting.ak.aR(biVar);
                            } else if (biVar.dtx()) {
                                com.tencent.mm.ui.chatting.ak.aS(biVar);
                            } else if (biVar.isText()) {
                                com.tencent.mm.ui.chatting.ak.aU(biVar);
                            } else if (biVar.bAC()) {
                                com.tencent.mm.ui.chatting.ak.aV(biVar);
                            } else if (biVar.dty()) {
                                com.tencent.mm.ui.chatting.ak.aT(biVar);
                            } else if (biVar.bAA()) {
                                ab.i("MicroMsg.ResendMsgLogic", "resendAppMsg, msgId:%d", Long.valueOf(biVar.field_msgId));
                                oC = bf.oC(biVar.field_talker);
                                if (oC == biVar.field_createTime) {
                                    oC++;
                                }
                                biVar.eJ(oC);
                                aw.ZK();
                                com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
                                String str = biVar.field_content;
                                int i = biVar.field_isSend;
                                String str2 = biVar.field_talker;
                                int i2 = (t.mT(str2) || com.tencent.mm.model.n.ms(str2)) ? 1 : 0;
                                if (!(i2 == 0 || str == null || i != 0)) {
                                    str = bf.oz(str);
                                }
                                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
                                if ((me == null || 19 != me.type) && (me == null || 24 != me.type)) {
                                    l.al(biVar);
                                } else {
                                    nt ntVar = new nt();
                                    ntVar.cJY.type = 4;
                                    ntVar.cJY.cKd = biVar;
                                    ntVar.cJY.toUser = biVar.field_talker;
                                    com.tencent.mm.sdk.b.a.xxA.m(ntVar);
                                }
                                bf.fm(biVar.field_msgId);
                            } else if (biVar.dtw()) {
                                com.tencent.mm.ui.chatting.ak.aW(biVar);
                            } else if (biVar.bws() || biVar.bwt()) {
                                oC = bf.oC(biVar.field_talker);
                                if (oC == biVar.field_createTime) {
                                    oC++;
                                }
                                biVar.eJ(oC);
                                aw.ZK();
                                com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
                                s uf = com.tencent.mm.modelvideo.o.all().uf(biVar.field_imgPath);
                                if (uf != null) {
                                    uf.createTime = biVar.field_createTime;
                                    uf.bJt = 128;
                                    com.tencent.mm.modelvideo.o.all().c(uf);
                                    ab.i("MicroMsg.ResendMsgLogic", "resendVideoMsg, msgId:%d, msgtime: %d, infotime:%d", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_createTime), Long.valueOf(uf.createTime));
                                }
                                aw.ZK();
                                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                    com.tencent.mm.modelvideo.u.us(biVar.field_imgPath);
                                } else {
                                    com.tencent.mm.ui.base.t.hO(ah.getContext());
                                }
                            } else {
                                biVar.setStatus(5);
                                aw.ZK();
                                com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
                                ab.e("MicroMsg.WorkerProfile", "resendMsg, unknown msg type");
                            }
                        }
                        AppMethodBeat.o(15485);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<com.tencent.mm.g.a.g>() {
                    {
                        AppMethodBeat.i(15486);
                        this.xxI = com.tencent.mm.g.a.g.class.getName().hashCode();
                        AppMethodBeat.o(15486);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        String str = null;
                        AppMethodBeat.i(15487);
                        com.tencent.mm.g.a.g gVar = (com.tencent.mm.g.a.g) bVar;
                        Context context = gVar.crV.context;
                        if (context == null) {
                            ab.e("MicroMsg.WorkerProfile", "add card to wx event, context is null");
                            AppMethodBeat.o(15487);
                            return false;
                        }
                        String str2;
                        String str3;
                        String str4;
                        String str5;
                        String[] strArr = gVar.crV.crW;
                        if (strArr == null || strArr.length <= 0) {
                            str2 = null;
                            str3 = null;
                        } else {
                            str3 = strArr[0];
                            str2 = com.tencent.mm.a.g.x(p.bx(gVar.crV.context, strArr[0])[0].toByteArray());
                        }
                        String[] strArr2 = gVar.crV.selectionArgs;
                        if (strArr2 == null || strArr2.length <= 1) {
                            str4 = null;
                            str5 = null;
                        } else {
                            str4 = strArr2[0];
                            str5 = strArr2[1];
                        }
                        if (strArr2 != null && strArr2.length > 2) {
                            str = strArr2[2];
                        }
                        ab.i("MicroMsg.WorkerProfile", "carlist = %s, appid = %s, transcation = %s", str5, str4, str);
                        Intent intent = new Intent(context, WXBizEntryActivity.class);
                        intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                        intent.putExtra("key_in_card_list", str5);
                        intent.putExtra("key_package_name", str3);
                        intent.putExtra("key_sign", str2);
                        intent.putExtra("key_from_scene", 8);
                        intent.putExtra("key_command_id", 9);
                        intent.putExtra("key_app_id", str4);
                        intent.putExtra("key_transaction", str);
                        context.startActivity(intent);
                        AppMethodBeat.o(15487);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<bl>() {
                    {
                        AppMethodBeat.i(15489);
                        this.xxI = bl.class.getName().hashCode();
                        AppMethodBeat.o(15489);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        int i = 0;
                        AppMethodBeat.i(15490);
                        bl blVar = (bl) bVar;
                        Context context = blVar.cuK.context;
                        if (context == null) {
                            ab.e("MicroMsg.WorkerProfile", "choose card from wx event, context is null");
                            AppMethodBeat.o(15490);
                            return false;
                        }
                        String[] strArr = blVar.cuK.crW;
                        String str = null;
                        if (strArr != null && strArr.length > 0) {
                            str = strArr[0];
                            com.tencent.mm.a.g.x(p.bx(blVar.cuK.context, strArr[0])[0].toByteArray());
                        }
                        String[] strArr2 = blVar.cuK.selectionArgs;
                        if (strArr2 == null || strArr2.length < 10) {
                            if (strArr2 != null) {
                                i = strArr2.length;
                            }
                            ab.e("MicroMsg.WorkerProfile", "ChooseCardFromWXEvent selectionArgs is null or length is < 10, the length is ".concat(String.valueOf(i)));
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i2 = 0; i2 < strArr2.length; i2++) {
                                stringBuilder.append(", selectionArgs[" + i2 + "]:" + strArr2[i2]);
                            }
                            ab.i("MicroMsg.WorkerProfile", "ChooseCardFromWXEvent selectionArgs:", strArr2.toString());
                            Intent intent = new Intent(context, WXBizEntryActivity.class);
                            intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                            intent.putExtra("app_id", strArr2[0]);
                            intent.putExtra("shop_id", bo.getInt(strArr2[1], 0));
                            intent.putExtra("sign_type", strArr2[2]);
                            intent.putExtra("card_sign", strArr2[3]);
                            intent.putExtra("time_stamp", bo.getInt(strArr2[4], 0));
                            intent.putExtra("nonce_str", strArr2[5]);
                            intent.putExtra("card_tp_id", strArr2[6]);
                            intent.putExtra("card_type", strArr2[7]);
                            intent.putExtra("can_multi_select", bo.getInt(strArr2[8], 0));
                            intent.putExtra("key_from_scene", 8);
                            intent.putExtra("key_command_id", 16);
                            intent.putExtra("key_app_id", strArr2[0]);
                            intent.putExtra("key_package_name", str);
                            intent.putExtra("key_transaction", strArr2[9]);
                            context.startActivity(intent);
                        }
                        AppMethodBeat.o(15490);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<pk>() {
                    {
                        AppMethodBeat.i(15491);
                        this.xxI = pk.class.getName().hashCode();
                        AppMethodBeat.o(15491);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15492);
                        pk pkVar = (pk) bVar;
                        Context context = pkVar.cLC.context;
                        if (context == null) {
                            ab.e("MicroMsg.WorkerProfile", "context is null");
                        } else {
                            String[] strArr = pkVar.cLC.crW;
                            String str = null;
                            String str2 = null;
                            if (strArr != null && strArr.length > 0) {
                                str = strArr[0];
                                str2 = com.tencent.mm.a.g.x(p.bx(pkVar.cLC.context, strArr[0])[0].toByteArray());
                            }
                            String[] strArr2 = pkVar.cLC.selectionArgs;
                            if (strArr2 == null || strArr2.length <= 0) {
                                ab.e("MicroMsg.WorkerProfile", "args is null");
                            } else {
                                ab.i("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle event, withType = %b", Boolean.valueOf(pkVar.cLC.cLD));
                                String str3;
                                String str4;
                                Intent intent;
                                com.tencent.mm.model.v.b y;
                                if (!pkVar.cLC.cLD) {
                                    str3 = null;
                                    str4 = null;
                                    if (strArr2 != null && strArr2.length > 1) {
                                        str3 = strArr2[0];
                                        str4 = strArr2[1];
                                    }
                                    ab.i("MicroMsg.WorkerProfile", "open webview, appid = %s, url = %s", str3, str4);
                                    if (!(bo.isNullOrNil(str3) || bo.isNullOrNil(str4))) {
                                        ab.i("MicroMsg.WorkerProfile", "url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&url=%s", new Object[]{str3, str4}));
                                        intent = new Intent(context, WXBizEntryActivity.class);
                                        intent.setData(Uri.parse(str4));
                                        intent.addFlags(268435456);
                                        intent.putExtra("key_package_name", str);
                                        intent.putExtra("translate_link_scene", 1);
                                        intent.putExtra("key_package_signature", str2);
                                        intent.putExtra("key_command_id", 12);
                                        y = com.tencent.mm.model.v.Zp().y("key_data_center_session_id", true);
                                        y.j("key_package_name", str);
                                        y.j("key_package_signature", str2);
                                        ab.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                                        context.startActivity(intent);
                                        AppMethodBeat.o(15492);
                                        return true;
                                    }
                                } else if (strArr2 == null || strArr2.length <= 0) {
                                    ab.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle fail, selectionArgs length invalid");
                                } else {
                                    str4 = strArr2[0];
                                    ab.i("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent, typeStr = %s, appid = %s", strArr2[1], str4);
                                    String str5;
                                    switch (bo.ank(str3)) {
                                        case 1:
                                            if (strArr2.length < 5) {
                                                ab.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle subscribe message, lenght = %d", Integer.valueOf(strArr2.length));
                                            }
                                            String str6 = strArr2[2];
                                            String str7 = strArr2[3];
                                            str5 = strArr2[4];
                                            ab.i("MicroMsg.WorkerProfile", "openwebviewwithtype, appid = %s, type = %s, scene = %s, templateID = %s, reserved = %s", str4, Integer.valueOf(r3), str6, str7, str5);
                                            if (bo.isNullOrNil(str4)) {
                                                ab.e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, appId is null");
                                                break;
                                            }
                                            str5 = Uri.encode(String.format("scene=%s&template_id=%s&reserved=%s", new Object[]{str6, str7, str5}));
                                            ab.i("MicroMsg.WorkerProfile", "openwebviewwithtype url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5}));
                                            intent = new Intent(context, WXBizEntryActivity.class);
                                            intent.setData(Uri.parse(str4));
                                            intent.addFlags(268435456);
                                            intent.putExtra("key_package_name", str);
                                            intent.putExtra("translate_link_scene", 1);
                                            intent.putExtra("key_package_signature", str2);
                                            intent.putExtra("key_command_id", 12);
                                            y = com.tencent.mm.model.v.Zp().y("key_data_center_session_id", true);
                                            y.j("key_package_name", str);
                                            y.j("key_package_signature", str2);
                                            ab.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                                            context.startActivity(intent);
                                            AppMethodBeat.o(15492);
                                            return true;
                                        case 5:
                                            if (strArr2.length < 5) {
                                                ab.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle subscribe message, lenght = %d", Integer.valueOf(strArr2.length));
                                            }
                                            ab.i("MicroMsg.WorkerProfile", "openwebviewwithtype, appid = %s, type = %s, miniProgramAppid = %s", str4, Integer.valueOf(r3), strArr2[2]);
                                            if (bo.isNullOrNil(str4)) {
                                                ab.e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, appId is null");
                                                break;
                                            } else if (bo.isNullOrNil(str5)) {
                                                ab.e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, miniProgramAppid is null");
                                                break;
                                            } else {
                                                str5 = Uri.encode(String.format("miniProgramAppid=%s", new Object[]{str5}));
                                                ab.i("MicroMsg.WorkerProfile", "openwebviewwithtype url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5}));
                                                intent = new Intent(context, WXBizEntryActivity.class);
                                                intent.setData(Uri.parse(str4));
                                                intent.addFlags(268435456);
                                                intent.putExtra("key_package_name", str);
                                                intent.putExtra("translate_link_scene", 1);
                                                intent.putExtra("key_package_signature", str2);
                                                intent.putExtra("key_command_id", 12);
                                                y = com.tencent.mm.model.v.Zp().y("key_data_center_session_id", true);
                                                y.j("key_package_name", str);
                                                y.j("key_package_signature", str2);
                                                ab.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                                                context.startActivity(intent);
                                                AppMethodBeat.o(15492);
                                                return true;
                                            }
                                        default:
                                            if (strArr2.length < 3) {
                                                ab.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent fail, unknown type = %d", Integer.valueOf(r3));
                                                break;
                                            }
                                            str5 = strArr2[2];
                                            ab.i("MicroMsg.WorkerProfile", "default url format = %s", String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5}));
                                            intent = new Intent(context, WXBizEntryActivity.class);
                                            intent.setData(Uri.parse(str4));
                                            intent.addFlags(268435456);
                                            intent.putExtra("key_package_name", str);
                                            intent.putExtra("translate_link_scene", 1);
                                            intent.putExtra("key_package_signature", str2);
                                            intent.putExtra("key_command_id", 12);
                                            y = com.tencent.mm.model.v.Zp().y("key_data_center_session_id", true);
                                            y.j("key_package_name", str);
                                            y.j("key_package_signature", str2);
                                            ab.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str, str2);
                                            context.startActivity(intent);
                                            AppMethodBeat.o(15492);
                                            return true;
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(15492);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<pj>() {
                    {
                        AppMethodBeat.i(15493);
                        this.xxI = pj.class.getName().hashCode();
                        AppMethodBeat.o(15493);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15494);
                        pj pjVar = (pj) bVar;
                        String[] strArr = pjVar.cLB.selectionArgs;
                        if (strArr == null || strArr.length == 0) {
                            ab.e("MicroMsg.WorkerProfile", "args is null");
                            AppMethodBeat.o(15494);
                        } else if (strArr.length <= 0) {
                            ab.e("MicroMsg.WorkerProfile", "args must contain appid");
                            AppMethodBeat.o(15494);
                        } else {
                            String str;
                            String str2;
                            String str3;
                            Context context = pjVar.cLB.context;
                            String str4 = strArr[0];
                            strArr = pjVar.cLB.crW;
                            if (strArr == null || strArr.length <= 0) {
                                str = null;
                                str2 = null;
                            } else {
                                str3 = strArr[0];
                                str = com.tencent.mm.a.g.x(p.bx(pjVar.cLB.context, strArr[0])[0].toByteArray());
                                str2 = str3;
                            }
                            ab.i("MicroMsg.WorkerProfile", "sdk open offlinePay, appid = %s, package = %s", str4, str2);
                            ab.i("MicroMsg.WorkerProfile", "url format = %s", String.format("weixin://dl/offlinepay/?appid=%s", new Object[]{str4}));
                            Intent intent = new Intent(context, WXBizEntryActivity.class);
                            intent.setData(Uri.parse(str3));
                            intent.addFlags(268435456);
                            intent.putExtra("key_app_id", str4);
                            intent.putExtra("key_package_name", str2);
                            intent.putExtra("translate_link_scene", 1);
                            intent.putExtra("key_package_signature", str);
                            intent.putExtra("key_command_id", 24);
                            com.tencent.mm.model.v.b y = com.tencent.mm.model.v.Zp().y("key_data_center_session_id", true);
                            y.j("key_package_name", str2);
                            y.j("key_package_signature", str);
                            ab.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", str2, str);
                            context.startActivity(intent);
                            AppMethodBeat.o(15494);
                        }
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<ph>() {
                    {
                        AppMethodBeat.i(15495);
                        this.xxI = ph.class.getName().hashCode();
                        AppMethodBeat.o(15495);
                    }

                    private static boolean a(ph phVar) {
                        AppMethodBeat.i(15496);
                        String[] strArr = phVar.cLz.selectionArgs;
                        if (strArr == null || strArr.length == 0) {
                            ab.e("MicroMsg.WorkerProfile", "args is null");
                            AppMethodBeat.o(15496);
                            return true;
                        } else if (strArr.length < 2) {
                            ab.e("MicroMsg.WorkerProfile", "args must contain appid and username");
                            AppMethodBeat.o(15496);
                            return true;
                        } else {
                            String str;
                            Context context = phVar.cLz.context;
                            String str2 = strArr[0];
                            String str3 = strArr[1];
                            String str4 = "";
                            int i = 0;
                            String str5 = "";
                            int i2 = 0;
                            String str6 = "";
                            String str7 = "";
                            String str8 = "";
                            if (strArr.length > 2) {
                                str4 = strArr[2];
                            }
                            if (strArr.length > 3) {
                                i = bo.getInt(strArr[3], 0);
                            }
                            if (strArr.length > 4) {
                                str = strArr[4];
                                if (str != null) {
                                    try {
                                        com.tencent.mm.aa.i iVar = new com.tencent.mm.aa.i(URLDecoder.decode(str, ProtocolPackage.ServerEncoding));
                                        str5 = URLEncoder.encode(iVar.optString("invokeData"), ProtocolPackage.ServerEncoding);
                                        i2 = bo.getInt(iVar.optString("pathType"), 0);
                                        str6 = iVar.optString("runtimeAppid");
                                        str7 = iVar.optString("runtimeTicket");
                                        str8 = iVar.optString("runtimeSessionId");
                                        ab.i("MicroMsg.WorkerProfile", "invokeData = %s, pathType:%d, runtimeAppid:%s, runtimeTicket:%s, runtimeSessionId:%s", str5, Integer.valueOf(i2), str6, str7, str8);
                                    } catch (com.tencent.mm.aa.g e) {
                                        ab.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                                    } catch (UnsupportedEncodingException e2) {
                                        ab.printErrStackTrace("MicroMsg.WorkerProfile", e2, "", new Object[0]);
                                    }
                                } else {
                                    ab.e("MicroMsg.WorkerProfile", "extdata is null");
                                }
                            }
                            if (!bo.isNullOrNil(str4)) {
                                try {
                                    str4 = URLEncoder.encode(str4);
                                } catch (Exception e3) {
                                    ab.e("MicroMsg.WorkerProfile", "encode path failed : %s", e3.getMessage());
                                    str4 = "";
                                }
                            }
                            String[] strArr2 = phVar.cLz.crW;
                            String str9 = null;
                            str = null;
                            if (strArr2 != null && strArr2.length > 0) {
                                str9 = strArr2[0];
                                Signature[] bx = p.bx(phVar.cLz.context, strArr2[0]);
                                if (bx != null && bx.length > 0) {
                                    str = com.tencent.mm.a.g.x(bx[0].toByteArray());
                                }
                            }
                            ab.i("MicroMsg.WorkerProfile", "sdk launch wxminiprogram, appid = %s, username = %s, path = %s, type = %d", str2, str3, str4, Integer.valueOf(i));
                            ab.i("MicroMsg.WorkerProfile", "sdk launch wxminiprogram, package name = %s, sig = %s", str9, str);
                            ab.i("MicroMsg.WorkerProfile", "url format = %s", String.format("weixin://dl/jumpWxa/?appid=%s&userName=%s@app&path=%s&invokeData=%s&pathType=%d&runtimeAppid=%s&runtimeTicket=%s&runtimeSessionId=%s", new Object[]{str2, str3, str4, str5, Integer.valueOf(i2), str6, str7, str8}));
                            Intent intent = new Intent(context, WXBizEntryActivity.class);
                            intent.setData(Uri.parse(str4));
                            intent.addFlags(268435456);
                            intent.putExtra("key_app_id", str2);
                            intent.putExtra("key_package_name", str9);
                            intent.putExtra("translate_link_scene", 1);
                            intent.putExtra("key_package_signature", str);
                            intent.putExtra("key_command_id", 19);
                            com.tencent.mm.model.v.b y = com.tencent.mm.model.v.Zp().y("key_data_center_session_id", true);
                            y.j("key_package_name", str9);
                            y.j("key_package_signature", str);
                            y.j("key_launch_miniprogram_type", Integer.valueOf(i));
                            ab.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s, type = %d", str9, str, Integer.valueOf(i));
                            context.startActivity(intent);
                            AppMethodBeat.o(15496);
                            return true;
                        }
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<il>() {
                    {
                        AppMethodBeat.i(15498);
                        this.xxI = il.class.getName().hashCode();
                        AppMethodBeat.o(15498);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15499);
                        il ilVar = (il) bVar;
                        Context context = ilVar.cDC.context;
                        if (context == null) {
                            ab.e("MicroMsg.WorkerProfile", "context is null");
                        } else {
                            String str;
                            String str2;
                            String[] strArr = ilVar.cDC.crW;
                            if (strArr == null || strArr.length <= 0) {
                                str = null;
                                str2 = null;
                            } else {
                                str2 = strArr[0];
                                str = com.tencent.mm.a.g.x(p.bx(ilVar.cDC.context, strArr[0])[0].toByteArray());
                            }
                            String[] strArr2 = ilVar.cDC.selectionArgs;
                            if (strArr2 == null || strArr2.length <= 0) {
                                ab.e("MicroMsg.WorkerProfile", "args is null");
                            } else {
                                String str3;
                                String str4;
                                if (strArr2 == null || strArr2.length <= 1) {
                                    str3 = null;
                                    str4 = null;
                                } else {
                                    str4 = strArr2[0];
                                    str3 = strArr2[1];
                                }
                                ab.i("MicroMsg.WorkerProfile", "handleScanResult, appid = %s, scanResult = %s", str4, str3);
                                if (!(bo.isNullOrNil(str4) || bo.isNullOrNil(str3))) {
                                    String format = String.format("weixin://dl/handleScanResult?appid=%s&result=%s", new Object[]{str4, str3});
                                    Intent intent = new Intent(context, WXBizEntryActivity.class);
                                    intent.setData(Uri.parse(format));
                                    intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                                    intent.putExtra("key_command_id", 17);
                                    intent.putExtra("key_package_name", str2);
                                    intent.putExtra("translate_link_scene", 1);
                                    intent.putExtra("key_package_signature", str);
                                    context.startActivity(intent);
                                    AppMethodBeat.o(15499);
                                    return true;
                                }
                            }
                        }
                        AppMethodBeat.o(15499);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<ce>() {
                    {
                        AppMethodBeat.i(15500);
                        this.xxI = ce.class.getName().hashCode();
                        AppMethodBeat.o(15500);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15501);
                        ce ceVar = (ce) bVar;
                        Context context = ceVar.cvl.context;
                        if (context == null) {
                            ab.e("MicroMsg.WorkerProfile", "CreateOrJoinChatroomEvent, context is null");
                            AppMethodBeat.o(15501);
                            return false;
                        }
                        String[] strArr = ceVar.cvl.selectionArgs;
                        if (strArr == null || strArr.length < 2) {
                            ab.e("MicroMsg.WorkerProfile", "CreateOrJoinChatroomEvent, invalid args");
                            AppMethodBeat.o(15501);
                            return false;
                        }
                        String str;
                        int i;
                        String[] strArr2 = ceVar.cvl.crW;
                        String str2 = "";
                        if (strArr2 != null && strArr2.length > 0) {
                            str2 = strArr2[0];
                        }
                        String str3 = strArr[0];
                        String str4 = strArr[1];
                        String str5 = strArr[2];
                        String str6 = "";
                        String str7 = "";
                        String str8 = "";
                        String str9 = "";
                        if (ceVar.cvl.action == 1) {
                            str = "action_create";
                            if (strArr.length >= 4) {
                                str6 = strArr[3];
                            }
                            if (strArr.length >= 5) {
                                str7 = strArr[4];
                            }
                            if (strArr.length >= 6) {
                                str8 = strArr[5];
                            }
                            if (strArr.length >= 7) {
                                str9 = strArr[6];
                            }
                            i = 14;
                        } else if (ceVar.cvl.action == 2) {
                            str = "action_join";
                            if (strArr.length >= 4) {
                                str7 = strArr[3];
                            }
                            if (strArr.length >= 5) {
                                str8 = strArr[4];
                            }
                            if (strArr.length >= 6) {
                                str9 = strArr[5];
                            }
                            i = 15;
                        } else {
                            AppMethodBeat.o(15501);
                            return false;
                        }
                        Intent intent = new Intent(context, WXBizEntryActivity.class);
                        intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                        intent.putExtra("key_app_id", str3);
                        intent.putExtra("key_transaction", str4);
                        intent.putExtra("key_command_id", i);
                        intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, str);
                        intent.putExtra("package_name", str2);
                        intent.putExtra(FirebaseAnalytics.b.GROUP_ID, str5);
                        intent.putExtra("chatroom_name", str6);
                        intent.putExtra("chatroom_nickname", str7);
                        intent.putExtra("ext_msg", str8);
                        intent.putExtra("open_id", str9);
                        context.startActivity(intent);
                        AppMethodBeat.o(15501);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<pi>() {
                    {
                        AppMethodBeat.i(15502);
                        this.xxI = pi.class.getName().hashCode();
                        AppMethodBeat.o(15502);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15503);
                        pi piVar = (pi) bVar;
                        Context context = piVar.cLA.context;
                        if (context == null) {
                            ab.e("MicroMsg.WorkerProfile", "add card to wx event, context is null");
                        } else {
                            String str;
                            String str2;
                            String[] strArr = piVar.cLA.crW;
                            if (strArr == null || strArr.length <= 0) {
                                str = null;
                                str2 = null;
                            } else {
                                String str3 = strArr[0];
                                str = com.tencent.mm.a.g.x(p.bx(piVar.cLA.context, strArr[0])[0].toByteArray());
                                str2 = str3;
                            }
                            String[] strArr2 = piVar.cLA.selectionArgs;
                            if (strArr2 != null && strArr2.length >= 6) {
                                Intent intent = new Intent(context, WXBizEntryActivity.class);
                                intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                                intent.putExtra("key_way", 4);
                                intent.putExtra("appId", strArr2[0]);
                                intent.putExtra("timeStamp", strArr2[1]);
                                intent.putExtra("nonceStr", strArr2[2]);
                                intent.putExtra("packageExt", strArr2[5]);
                                intent.putExtra("signtype", strArr2[3]);
                                intent.putExtra("paySignature", strArr2[4]);
                                intent.putExtra("key_wxapi_package_name", str2);
                                intent.putExtra("key_wxapi_sign", str);
                                intent.putExtra("key_command_id", 13);
                                context.startActivity(intent);
                            }
                        }
                        AppMethodBeat.o(15503);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<lk>() {
                    {
                        AppMethodBeat.i(15505);
                        this.xxI = lk.class.getName().hashCode();
                        AppMethodBeat.o(15505);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15507);
                        boolean Cf = Cf();
                        AppMethodBeat.o(15507);
                        return Cf;
                    }

                    private boolean Cf() {
                        AppMethodBeat.i(15506);
                        aw.Rg().a(1145, new f() {
                            public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                                AppMethodBeat.i(15504);
                                aw.Rg().b(1145, (f) this);
                                ab.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                if (i != 0 || i2 != 0) {
                                    AppMethodBeat.o(15504);
                                } else if (mVar.getType() != 1145) {
                                    AppMethodBeat.o(15504);
                                } else {
                                    com.tencent.mm.modelappbrand.p pVar = (com.tencent.mm.modelappbrand.p) mVar;
                                    if ((((any) pVar.fpJ.fsG.fsP).wsv & 1) == 0) {
                                        AppMethodBeat.o(15504);
                                        return;
                                    }
                                    boolean z = pVar.abG().vKO;
                                    aw.ZK();
                                    if (z != com.tencent.mm.model.c.Ry().getBoolean(ac.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                                        ab.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", Boolean.valueOf(z));
                                        aw.ZK();
                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(z));
                                        com.tencent.mm.sdk.b.a.xxA.m(new nx());
                                    }
                                    z = pVar.abG().wsw;
                                    aw.ZK();
                                    if (z != com.tencent.mm.model.c.Ry().getBoolean(ac.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                                        ab.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", Boolean.valueOf(z));
                                        aw.ZK();
                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(z));
                                        com.tencent.mm.sdk.b.a.xxA.m(new nx());
                                    }
                                    AppMethodBeat.o(15504);
                                }
                            }
                        });
                        aw.Rg().a(new com.tencent.mm.modelappbrand.p(5), 0);
                        AppMethodBeat.o(15506);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<qr>() {
                    {
                        AppMethodBeat.i(15508);
                        this.xxI = qr.class.getName().hashCode();
                        AppMethodBeat.o(15508);
                    }

                    public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15509);
                        qr qrVar = (qr) bVar;
                        com.tencent.mm.pluginsdk.ui.e.l.a(qrVar.cMP.context, qrVar.cMP.cMQ, qrVar.cMP.cMR, qrVar.cMP.cMS);
                        AppMethodBeat.o(15509);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new c<pa>() {
                    {
                        AppMethodBeat.i(15510);
                        this.xxI = pa.class.getName().hashCode();
                        AppMethodBeat.o(15510);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15511);
                        com.tencent.mm.booter.notification.d.in(0);
                        com.tencent.mm.booter.notification.d.bx(true);
                        AppMethodBeat.o(15511);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.xxA.c(new m(2, 12));
                com.tencent.mm.sdk.b.a.xxA.c(new c<pw>() {
                    {
                        AppMethodBeat.i(15514);
                        this.xxI = pw.class.getName().hashCode();
                        AppMethodBeat.o(15514);
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(15516);
                        boolean Cg = Cg();
                        AppMethodBeat.o(15516);
                        return Cg;
                    }

                    private boolean Cg() {
                        int i;
                        AppMethodBeat.i(15515);
                        if (com.tencent.mm.compatible.util.d.iW(23)) {
                            Context context = ah.getContext();
                            int a = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_if_show_ignore_battery_optimizations, 0);
                            i = as.amF("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
                            ab.i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", Integer.valueOf(i));
                            if (bo.gW(a, 1) && i < 3 && !com.tencent.mm.booter.c.bn(context)) {
                                ab.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations()");
                                Editor edit = as.amF("sdcard_usable_report").edit();
                                long currentTimeMillis = System.currentTimeMillis();
                                Object obj = null;
                                if (i == 0) {
                                    try {
                                        com.tencent.mm.booter.c.Ih();
                                    } catch (Exception e) {
                                        obj = 1;
                                        ab.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", e.getClass().toString(), e.getMessage());
                                    }
                                    if (obj == null) {
                                        edit.putLong("last_ignore_battery_dialog_time", currentTimeMillis);
                                        edit.putInt("ignore_battery_dialog_time", 1);
                                    }
                                } else {
                                    long j = currentTimeMillis - as.amF("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", currentTimeMillis);
                                    ab.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() last:%s diff:%s", Long.valueOf(as.amF("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", currentTimeMillis)), Long.valueOf(j));
                                    if (i == 1) {
                                        if (j >= 86400000) {
                                            try {
                                                com.tencent.mm.booter.c.Ih();
                                            } catch (Exception e2) {
                                                obj = 1;
                                                ab.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", e2.getClass().toString(), e2.getMessage());
                                            }
                                            if (obj == null) {
                                                edit.putLong("last_ignore_battery_dialog_time", currentTimeMillis);
                                                edit.putInt("ignore_battery_dialog_time", 2);
                                            }
                                        }
                                    } else if (i == 2 && j >= 604800000) {
                                        try {
                                            com.tencent.mm.booter.c.Ih();
                                        } catch (Exception e22) {
                                            obj = 1;
                                            ab.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", e22.getClass().toString(), e22.getMessage());
                                        }
                                        if (obj == null) {
                                            edit.putLong("last_ignore_battery_dialog_time", currentTimeMillis);
                                            edit.putInt("ignore_battery_dialog_time", 3);
                                        }
                                    }
                                }
                                edit.commit();
                            }
                        }
                        Editor edit2;
                        if (com.tencent.mm.pluginsdk.i.c.diH() || WorkerProfile.this.cfY) {
                            ab.i("MicroMsg.WorkerProfile", "SdcardUsableDetectionEvent pass tipCountAboutSdcarDisable=%s ifSdcardDialogShow=%s", Integer.valueOf(WorkerProfile.cfX), Boolean.valueOf(WorkerProfile.this.cfY));
                            WorkerProfile.cfX = -1;
                            if (WorkerProfile.this.cfY) {
                                AppMethodBeat.o(15515);
                                return false;
                            }
                            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("sdcard_usable_report", 4);
                            int i2 = sharedPreferences.getInt("mm_process_pid", -1);
                            i = Process.myPid();
                            ab.i("MicroMsg.WorkerProfile", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", Integer.valueOf(i2), Integer.valueOf(i));
                            if (bo.gW(i2, -1)) {
                                AppMethodBeat.o(15515);
                                return false;
                            }
                            if (bo.gW(i2, i)) {
                                h.pYm.k(951, 22, 1);
                            } else if (!bo.gW(i2, i)) {
                                h.pYm.k(951, 21, 1);
                            }
                            edit2 = sharedPreferences.edit();
                            edit2.putInt("mm_process_pid", -1);
                            edit2.commit();
                            AppMethodBeat.o(15515);
                            return false;
                        }
                        WorkerProfile.Cd();
                        ab.i("MicroMsg.WorkerProfile", "tipCountAboutSdcarDisable:%d", Integer.valueOf(WorkerProfile.cfX));
                        if (WorkerProfile.cfX <= 0) {
                            AppMethodBeat.o(15515);
                            return false;
                        }
                        WorkerProfile.this.cfY = true;
                        switch (WorkerProfile.cfX) {
                            case 1:
                                h.pYm.k(951, 0, 1);
                                edit2 = ah.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
                                edit2.putInt("mm_process_pid", Process.myPid());
                                edit2.commit();
                                break;
                            case 3:
                                h.pYm.k(951, 1, 1);
                                break;
                            case 5:
                                h.pYm.k(951, 2, 1);
                                break;
                            case 10:
                                h.pYm.k(951, 3, 1);
                                break;
                        }
                        new com.tencent.mm.ui.widget.a.e.a(ah.getContext()).asL(ah.getContext().getString(R.string.dz7)).al(ah.getContext().getString(R.string.tz)).re(false).b(new com.tencent.mm.ui.widget.a.e.c() {
                            public final void d(boolean z, String str) {
                                AppMethodBeat.i(15513);
                                MMAppMgr.ymL = false;
                                WorkerProfile.this.cfY = false;
                                AppMethodBeat.o(15513);
                            }
                        }).show();
                        AppMethodBeat.o(15515);
                        return false;
                    }
                });
                com.tencent.mm.plugin.messenger.a.g.opT = new com.tencent.mm.ui.transmit.d();
                r.a.vax = new com.tencent.mm.app.plugin.a();
                com.tencent.mm.pluginsdk.ui.e.b.a.vrC = com.tencent.mm.app.plugin.e.Cl();
                if (!aw.QT()) {
                    aw.ZK();
                }
                com.tencent.mm.sdk.b.a.xxA.m(new ck());
                this.cfM = true;
                Log.setLogImpl(new ILog() {
                    {
                        AppMethodBeat.i(15517);
                        AppMethodBeat.o(15517);
                    }

                    public final void v(String str, String str2) {
                        AppMethodBeat.i(138588);
                        ab.v(str, str2);
                        AppMethodBeat.o(138588);
                    }

                    public final void d(String str, String str2) {
                        AppMethodBeat.i(138589);
                        ab.d(str, str2);
                        AppMethodBeat.o(138589);
                    }

                    public final void i(String str, String str2) {
                        AppMethodBeat.i(138590);
                        ab.i(str, str2);
                        AppMethodBeat.o(138590);
                    }

                    public final void w(String str, String str2) {
                        AppMethodBeat.i(138591);
                        ab.w(str, str2);
                        AppMethodBeat.o(138591);
                    }

                    public final void e(String str, String str2) {
                        AppMethodBeat.i(138592);
                        ab.e(str, str2);
                        AppMethodBeat.o(138592);
                    }
                });
                ab.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - currentTimeMillis2));
                applicationContext = ah.getContext();
                anonymousClass27 = new com.tencent.mm.n.a.a() {
                    final Map<String, Integer> cgf = new HashMap();
                    final Map<String, Integer> map = new HashMap();

                    /* renamed from: do */
                    public final String m18do(String str) {
                        AppMethodBeat.i(138598);
                        if (this.map.containsKey(str)) {
                            String string = applicationContext.getString(((Integer) this.map.get(str)).intValue());
                            AppMethodBeat.o(138598);
                            return string;
                        }
                        AppMethodBeat.o(138598);
                        return null;
                    }

                    public final String dp(String str) {
                        AppMethodBeat.i(138599);
                        if (this.cgf.containsKey(str)) {
                            String string = applicationContext.getString(((Integer) this.cgf.get(str)).intValue());
                            AppMethodBeat.o(138599);
                            return string;
                        }
                        AppMethodBeat.o(138599);
                        return null;
                    }
                };
                anonymousClass27.map.put("qqmail", Integer.valueOf(R.string.cat));
                anonymousClass27.map.put("fmessage", Integer.valueOf(R.string.c_z));
                anonymousClass27.map.put("floatbottle", Integer.valueOf(R.string.c_k));
                anonymousClass27.map.put("lbsapp", Integer.valueOf(R.string.ca7));
                anonymousClass27.map.put("shakeapp", Integer.valueOf(R.string.cb5));
                anonymousClass27.map.put("medianote", Integer.valueOf(R.string.caf));
                anonymousClass27.map.put("qqfriend", Integer.valueOf(R.string.caq));
                anonymousClass27.map.put("newsapp", Integer.valueOf(R.string.cb1));
                anonymousClass27.map.put("facebookapp", Integer.valueOf(R.string.c_t));
                anonymousClass27.map.put("masssendapp", Integer.valueOf(R.string.cac));
                anonymousClass27.map.put("meishiapp", Integer.valueOf(R.string.cai));
                anonymousClass27.map.put("feedsapp", Integer.valueOf(R.string.c_w));
                anonymousClass27.map.put("voipapp", Integer.valueOf(R.string.cbe));
                anonymousClass27.map.put("weixin", Integer.valueOf(R.string.da5));
                anonymousClass27.map.put("filehelper", Integer.valueOf(R.string.c_g));
                anonymousClass27.map.put("cardpackage", Integer.valueOf(R.string.c_n));
                anonymousClass27.map.put("officialaccounts", Integer.valueOf(R.string.cam));
                anonymousClass27.map.put("voicevoipapp", Integer.valueOf(R.string.cbh));
                anonymousClass27.map.put("helper_entry", Integer.valueOf(R.string.ca4));
                anonymousClass27.map.put("voiceinputapp", Integer.valueOf(R.string.cbb));
                anonymousClass27.map.put("linkedinplugin", Integer.valueOf(R.string.ca_));
                anonymousClass27.map.put("notifymessage", Integer.valueOf(R.string.caj));
                anonymousClass27.map.put("gh_43f2581f6fd6", Integer.valueOf(R.string.cb8));
                anonymousClass27.map.put("appbrandcustomerservicemsg", Integer.valueOf(R.string.c_h));
                anonymousClass27.cgf.put("weixin", Integer.valueOf(R.string.da4));
                com.tencent.mm.n.a.a(anonymousClass27);
                ai.a(new ai.a() {
                    public final void v(String str, String str2) {
                        AppMethodBeat.i(15460);
                        ab.v(str, str2);
                        AppMethodBeat.o(15460);
                    }

                    public final void d(String str, String str2) {
                        AppMethodBeat.i(15461);
                        ab.d(str, str2);
                        AppMethodBeat.o(15461);
                    }

                    public final void i(String str, String str2) {
                        AppMethodBeat.i(15462);
                        ab.i(str, str2);
                        AppMethodBeat.o(15462);
                    }

                    public final void w(String str, String str2) {
                        AppMethodBeat.i(15463);
                        ab.w(str, str2);
                        AppMethodBeat.o(15463);
                    }

                    public final void e(String str, String str2) {
                        AppMethodBeat.i(15464);
                        ab.e(str, str2);
                        AppMethodBeat.o(15464);
                    }
                });
                if (!com.tencent.mm.compatible.util.f.Mn()) {
                    h.pYm.a(340, com.tencent.mm.compatible.util.d.iW(19) ? 5 : 6, 1, false);
                    h hVar = h.pYm;
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(com.tencent.mm.compatible.util.d.iW(19) ? ReaderCallback.HIDDEN_BAR : ReaderCallback.SHOW_BAR);
                    objArr2[1] = String.format("%s;%s;%s", new Object[]{com.tencent.mm.compatible.util.e.eSl, Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()});
                    hVar.e(11098, objArr2);
                }
                ab.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.cfN), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.cdf), Integer.valueOf(com.tencent.mm.protocal.d.vxo), bo.gW(ah.getContext()));
                AppMethodBeat.o(15548);
            }
            ab.i("MicroMsg.WorkerProfile", "apk external info not null");
            if (aVar.cdc.cdf != 0) {
                com.tencent.mm.sdk.platformtools.g.cdf = aVar.cdc.cdf;
                ab.i("MicroMsg.WorkerProfile", "read channelId from apk external");
            }
            if (aVar.cdc.cdh != 0) {
                com.tencent.mm.sdk.platformtools.g.cdh = aVar.cdc.cdh;
                ab.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", Integer.valueOf(com.tencent.mm.sdk.platformtools.g.cdh));
            }
            if (aVar.cdc.cdi != null) {
                com.tencent.mm.sdk.platformtools.g.xyb = bo.getInt(aVar.cdc.cdi, 0);
            }
            if (aVar.cdc.cdj != null) {
                com.tencent.mm.sdk.platformtools.g.xyc = aVar.cdc.cdj;
            }
            if (aVar.cdc.cdg != null) {
                com.tencent.mm.sdk.platformtools.g.cdg = aVar.cdc.cdg;
            }
            if (aVar.cdc.cdm) {
                com.tencent.mm.sdk.platformtools.g.xyg = aVar.cdc.cdm;
                ab.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", Boolean.valueOf(com.tencent.mm.sdk.platformtools.g.xyg));
            }
            if (aVar.cdc.cdl != 0) {
                com.tencent.mm.sdk.platformtools.g.cdl = aVar.cdc.cdl;
                ab.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", Integer.valueOf(com.tencent.mm.sdk.platformtools.g.cdl));
            }
            if (aVar.cdc.cdk) {
                com.tencent.mm.sdk.platformtools.g.xyf = aVar.cdc.cdk;
                ab.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", Boolean.valueOf(com.tencent.mm.sdk.platformtools.g.xyf));
            }
            d.Ba();
            bo = d.bo(this.app);
            com.tencent.mm.sdk.platformtools.g.cdf = bo.ebO;
            applicationContext = this.app.getApplicationContext();
            i = com.tencent.mm.sdk.platformtools.g.cdf;
            i2 = com.tencent.mm.protocal.d.vxo;
            sharedPreferences = applicationContext.getSharedPreferences("crash_status_file", 4);
            i3 = sharedPreferences.getInt("channel", -1);
            i4 = sharedPreferences.getInt("version", 0);
            edit = sharedPreferences.edit();
            edit.putInt("channel", i);
            edit.putInt("version", i2);
            edit.commit();
            if (com.tencent.mm.sdk.platformtools.g.xyb > 0) {
            }
            com.tencent.mm.bp.d.dlL();
            if (bo.isNullOrNil(com.tencent.mm.sdk.platformtools.g.cdg)) {
            }
            com.tencent.mm.protocal.d.eSg = "android-" + (bo.isNullOrNil(com.tencent.mm.sdk.platformtools.g.cdg) ? Integer.valueOf(VERSION.SDK_INT) : com.tencent.mm.sdk.platformtools.g.cdg);
            if (bo.isNullOrNil(com.tencent.mm.sdk.a.b.dnP())) {
            }
            ab.v("MicroMsg.WorkerProfile", "set device type :%s  %s", com.tencent.mm.protocal.d.eSg, com.tencent.mm.sdk.a.b.dnP());
            this.locale = MMActivity.initLanguage(this.app.getBaseContext());
            if (com.tencent.mm.sdk.a.b.dnO()) {
            }
            com.tencent.mm.sdk.b.a.xxA.c(this.cfH);
            cVar = new c();
            ab.d("MicroMsg.AvatarDrawable", "setLoader".concat(String.valueOf(cVar)));
            com.tencent.mm.pluginsdk.ui.a.b.pqK = cVar;
            com.tencent.mm.pluginsdk.f.e.vdx = /* anonymous class already generated */;
            com.tencent.mm.kernel.g.a(com.tencent.mm.ai.i.class, new com.tencent.mm.kernel.c.e(this.cfW));
            com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.h.class, new com.tencent.mm.kernel.c.e(this.cfW));
            com.tencent.mm.kernel.g.a(j.class, new com.tencent.mm.kernel.c.e(this.cfW));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.brandservice.a.a.class, new com.tencent.mm.plugin.bbom.d());
            com.tencent.mm.kernel.g.a(q.class, new com.tencent.mm.app.plugin.d());
            com.tencent.mm.kernel.g.a(com.tencent.mm.choosemsgfile.compat.b.class, new com.tencent.mm.ui.chatting.b.a());
            com.tencent.mm.sdk.b.a.xxA.c(new com.tencent.mm.app.plugin.b.a.a());
            if (this.cfJ == null) {
            }
            this.cfU = new com.tencent.mm.h.b();
            bVar2 = this.cfU;
            ab.i("MicroMsg.BroadcastController", "summerdiz init");
            com.tencent.mm.sdk.b.a.xxA.c(bVar2.eeX);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(new com.tencent.mm.plugin.account.bind.ui.e());
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.xxA.c(new m(2, 12));
            com.tencent.mm.sdk.b.a.xxA.c(/* anonymous class already generated */);
            com.tencent.mm.plugin.messenger.a.g.opT = new com.tencent.mm.ui.transmit.d();
            r.a.vax = new com.tencent.mm.app.plugin.a();
            com.tencent.mm.pluginsdk.ui.e.b.a.vrC = com.tencent.mm.app.plugin.e.Cl();
            if (aw.QT()) {
            }
            com.tencent.mm.sdk.b.a.xxA.m(new ck());
            this.cfM = true;
            Log.setLogImpl(/* anonymous class already generated */);
            ab.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - currentTimeMillis2));
            applicationContext = ah.getContext();
            anonymousClass27 = /* anonymous class already generated */;
            anonymousClass27.map.put("qqmail", Integer.valueOf(R.string.cat));
            anonymousClass27.map.put("fmessage", Integer.valueOf(R.string.c_z));
            anonymousClass27.map.put("floatbottle", Integer.valueOf(R.string.c_k));
            anonymousClass27.map.put("lbsapp", Integer.valueOf(R.string.ca7));
            anonymousClass27.map.put("shakeapp", Integer.valueOf(R.string.cb5));
            anonymousClass27.map.put("medianote", Integer.valueOf(R.string.caf));
            anonymousClass27.map.put("qqfriend", Integer.valueOf(R.string.caq));
            anonymousClass27.map.put("newsapp", Integer.valueOf(R.string.cb1));
            anonymousClass27.map.put("facebookapp", Integer.valueOf(R.string.c_t));
            anonymousClass27.map.put("masssendapp", Integer.valueOf(R.string.cac));
            anonymousClass27.map.put("meishiapp", Integer.valueOf(R.string.cai));
            anonymousClass27.map.put("feedsapp", Integer.valueOf(R.string.c_w));
            anonymousClass27.map.put("voipapp", Integer.valueOf(R.string.cbe));
            anonymousClass27.map.put("weixin", Integer.valueOf(R.string.da5));
            anonymousClass27.map.put("filehelper", Integer.valueOf(R.string.c_g));
            anonymousClass27.map.put("cardpackage", Integer.valueOf(R.string.c_n));
            anonymousClass27.map.put("officialaccounts", Integer.valueOf(R.string.cam));
            anonymousClass27.map.put("voicevoipapp", Integer.valueOf(R.string.cbh));
            anonymousClass27.map.put("helper_entry", Integer.valueOf(R.string.ca4));
            anonymousClass27.map.put("voiceinputapp", Integer.valueOf(R.string.cbb));
            anonymousClass27.map.put("linkedinplugin", Integer.valueOf(R.string.ca_));
            anonymousClass27.map.put("notifymessage", Integer.valueOf(R.string.caj));
            anonymousClass27.map.put("gh_43f2581f6fd6", Integer.valueOf(R.string.cb8));
            anonymousClass27.map.put("appbrandcustomerservicemsg", Integer.valueOf(R.string.c_h));
            anonymousClass27.cgf.put("weixin", Integer.valueOf(R.string.da4));
            com.tencent.mm.n.a.a(anonymousClass27);
            ai.a(/* anonymous class already generated */);
            if (com.tencent.mm.compatible.util.f.Mn()) {
            }
            ab.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.cfN), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.cdf), Integer.valueOf(com.tencent.mm.protocal.d.vxo), bo.gW(ah.getContext()));
            AppMethodBeat.o(15548);
        } catch (NameNotFoundException e22) {
        } catch (Exception e3) {
            ab.e("MicroMsg.WorkerProfile", "Exception in initChannel, %s", e3.getMessage());
        }
    }

    public final void onTerminate() {
        AppMethodBeat.i(15549);
        super.onTerminate();
        com.tencent.mm.h.b bVar = this.cfU;
        ab.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", bVar.eeU, Integer.valueOf(bVar.eeW.size()));
        com.tencent.mm.sdk.b.a.xxA.d(bVar.eeX);
        bVar.eeU = null;
        bVar.eeV.clear();
        bVar.eeW.clear();
        this.cfU = null;
        AppMethodBeat.o(15549);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(15550);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
        ah.getContext();
        if ("language_default".equals(com.tencent.mm.sdk.platformtools.aa.h(sharedPreferences))) {
            ab.i("MicroMsg.WorkerProfile", "config locale %s", com.tencent.mm.sdk.platformtools.aa.c(configuration.locale));
            Locale bM = MMActivity.bM(this.app.getBaseContext(), com.tencent.mm.sdk.platformtools.aa.c(configuration.locale));
            ab.i("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s", this.locale, bM);
            if (!(bM == null || this.locale == null || bM.equals(this.locale))) {
                if (aw.RK()) {
                    try {
                        com.tencent.mm.network.e eVar = aw.Rg().ftA;
                        if (eVar != null) {
                            com.tencent.mm.network.c adg = eVar.adg();
                            if (adg != null) {
                                byte[] bArr = new byte[0];
                                byte[] bArr2 = new byte[0];
                                byte[] bArr3 = new byte[0];
                                aw.ZK();
                                adg.a(bArr, bArr2, bArr3, com.tencent.mm.model.c.QF());
                            }
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                        ab.printErrStackTrace("MicroMsg.WorkerProfile", e, "what the f$!k", new Object[0]);
                    }
                }
                ab.w("MicroMsg.WorkerProfile", "language changed, restart process");
                com.tencent.mm.bs.a.jB(ah.getContext());
                System.exit(-1);
            }
        }
        AppMethodBeat.o(15550);
    }

    public final String toString() {
        return ceo;
    }

    public final an getNotification() {
        AppMethodBeat.i(15551);
        if (this.cfJ == null) {
            this.cfJ = new com.tencent.mm.booter.notification.b(this.app);
        }
        an anVar = this.cfJ;
        AppMethodBeat.o(15551);
        return anVar;
    }

    public final b Cb() {
        AppMethodBeat.i(15552);
        if (this.cfK == null) {
            this.cfK = new b() {
                public final void a(bi biVar, PString pString, PString pString2, PInt pInt, boolean z) {
                    AppMethodBeat.i(138600);
                    com.tencent.mm.booter.notification.a.h.b(biVar, pString, pString2, pInt, z);
                    AppMethodBeat.o(138600);
                }

                public final String a(int i, String str, String str2, int i2, Context context) {
                    AppMethodBeat.i(138601);
                    String a = com.tencent.mm.booter.notification.a.h.a(i, str, str2, i2, context);
                    AppMethodBeat.o(138601);
                    return a;
                }
            };
        }
        b bVar = this.cfK;
        AppMethodBeat.o(15552);
        return bVar;
    }

    public final ae Cc() {
        AppMethodBeat.i(15553);
        if (this.cfL == null) {
            this.cfL = com.tencent.mm.booter.a.Ib();
        }
        ae aeVar = this.cfL;
        AppMethodBeat.o(15553);
        return aeVar;
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(15554);
        ab.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 3 && i2 == -1) {
            ab.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", bo.dpG(), Long.valueOf(Thread.currentThread().getId()));
        }
        Intent intent;
        if (i == 4 && i2 == -3002) {
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
                AppMethodBeat.o(15554);
                return;
            }
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            ab.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", str);
            com.tencent.mm.g.a.ak akVar = new com.tencent.mm.g.a.ak();
            akVar.cto.type = 4;
            akVar.cto.ctq = str;
            com.tencent.mm.sdk.b.a.xxA.m(akVar);
            AppMethodBeat.o(15554);
        } else if (!aw.RK() || i != 4 || ((i2 != -6 && i2 != -310 && i2 != -311) || str == null || !str.startsWith("autoauth_errmsg_"))) {
            if (mVar.getType() == 701 || mVar.getType() == 702 || mVar.getType() == 126 || mVar.getType() == 252 || mVar.getType() == 763 || mVar.getType() == 138) {
                jl jlVar;
                if (i == 4 && i2 == -213) {
                    jlVar = new jl();
                    jlVar.cEK.status = 0;
                    jlVar.cEK.boZ = 3;
                    com.tencent.mm.sdk.b.a.xxA.m(jlVar);
                    if (AccountDeletedAlphaAlertUI.dJp() != null) {
                        AppMethodBeat.o(15554);
                        return;
                    }
                    intent = new Intent();
                    intent.setClass(ah.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
                    intent.putExtra("errmsg", str);
                    ah.getContext().startActivity(intent);
                    AppMethodBeat.o(15554);
                    return;
                } else if (i == 4 && i2 == -100) {
                    jlVar = new jl();
                    jlVar.cEK.status = 0;
                    jlVar.cEK.boZ = 1;
                    com.tencent.mm.sdk.b.a.xxA.m(jlVar);
                }
            }
            AppMethodBeat.o(15554);
        } else if (NewTaskUI.dJR() != null) {
            AppMethodBeat.o(15554);
        } else {
            intent = new Intent();
            intent.setClass(ah.getContext(), NewTaskUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(15554);
        }
    }

    public final void onReportKVDataReady(byte[] bArr, final byte[] bArr2, final int i) {
        AppMethodBeat.i(15555);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(138602);
                if (aw.ZD()) {
                    AppMethodBeat.o(138602);
                    return;
                }
                ab.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + i);
                aw.Rg().a(new com.tencent.mm.plugin.report.b.e(bArr2, i), 0);
                AppMethodBeat.o(138602);
            }
        });
        AppMethodBeat.o(15555);
    }

    public final void dm(String str) {
        AppMethodBeat.i(15556);
        ab.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", str);
        com.tencent.mm.g.a.ak akVar = new com.tencent.mm.g.a.ak();
        akVar.cto.type = 4;
        akVar.cto.ctq = str;
        com.tencent.mm.sdk.b.a.xxA.m(akVar);
        AppMethodBeat.o(15556);
    }

    public final void dn(String str) {
        AppMethodBeat.i(15557);
        ab.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", str);
        com.tencent.mm.g.a.ak akVar = new com.tencent.mm.g.a.ak();
        akVar.cto.type = 1;
        akVar.cto.ctq = str;
        com.tencent.mm.sdk.b.a.xxA.m(akVar);
        AppMethodBeat.o(15557);
    }
}
