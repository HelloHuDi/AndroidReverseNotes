package com.tencent.mm.plugin.voip.model;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.plugin.voip.video.g;
import com.tencent.mm.plugin.voip.video.k;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class VoipMgr implements com.tencent.mm.compatible.b.g.a, com.tencent.mm.plugin.voip.model.p.a, u, c, g, com.tencent.mm.plugin.voip.video.k.a, com.tencent.mm.sdk.platformtools.SensorController.a {
    static int idk = 0;
    static int[] sSf = new int[2];
    b cqx;
    String edV;
    ak iGP;
    private boolean mIsMute = false;
    private int mUIType;
    SensorController mfW;
    private long mui = 0;
    TelephonyManager nva;
    PhoneStateListener nvb = new PhoneStateListener() {
        public final void onCallStateChanged(int i, String str) {
            int i2 = true;
            AppMethodBeat.i(4461);
            super.onCallStateChanged(i, str);
            ab.i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", Integer.valueOf(i), Boolean.valueOf(VoipMgr.this.sRG), Integer.valueOf(VoipMgr.this.sRW));
            if (VoipMgr.this.sRG) {
                if ((VoipMgr.this.sRW == 0 && i == 1) || (VoipMgr.this.sRW == 0 && i == 2)) {
                    VoipMgr.this.sRT = VoipMgr.this.sRT + 1;
                }
                if (i == 1) {
                    VoipMgr.this.sRI = true;
                    if (VoipMgr.this.sRW == 0) {
                        VoipMgr.this.sQP = System.currentTimeMillis();
                    }
                    VoipMgr.this.sRW = 1;
                    com.tencent.mm.plugin.voip.b.cIj().Gj(1);
                    VoipMgr.this.sSi = true;
                    AppMethodBeat.o(4461);
                    return;
                } else if (i == 2) {
                    String string;
                    VoipMgr.this.sRI = false;
                    if (VoipMgr.this.sRW == 1) {
                        VoipMgr.this.sQQ = System.currentTimeMillis();
                    }
                    VoipMgr.this.sRW = 2;
                    ab.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
                    if (VoipMgr.this.sRm && !com.tencent.mm.plugin.voip.a.b.GN(VoipMgr.this.sRc.mState)) {
                        s sVar = com.tencent.mm.plugin.voip.b.cIj().sSP;
                        ab.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + sVar.sNl.sPp.nwu);
                        if (sVar.sNl.sPp.nwu != 0) {
                            sVar.sNl.sPp.sVH.sQe = 102;
                            sVar.sNl.sPp.sVH.sQq = 6;
                            if (com.tencent.mm.plugin.voip.b.cIj().sSQ != null) {
                                sVar.sNl.sPp.sVH.sQR = com.tencent.mm.plugin.voip.b.cIj().sSQ.sRT;
                                sVar.sNl.sPp.sVH.sQP = com.tencent.mm.plugin.voip.b.cIj().sSQ.sQP / 1000;
                                sVar.sNl.sPp.sVH.sQQ = com.tencent.mm.plugin.voip.b.cIj().sSQ.sQQ / 1000;
                            }
                            h.pYm.a(11521, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIK()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
                            sVar.cKk();
                        }
                    }
                    if (com.tencent.mm.plugin.voip.a.b.GN(VoipMgr.this.sRc.mState)) {
                        string = ah.getContext().getString(R.string.f47, new Object[]{VoipMgr.lH(bo.fp(VoipMgr.this.sRs))});
                    } else {
                        string = ah.getContext().getString(R.string.f43);
                    }
                    s sVar2 = com.tencent.mm.plugin.voip.b.cIj().sSP;
                    ab.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
                    if (sVar2.sNl.sPp.nwu == 0) {
                        sVar2.sNl.sPr.cIY();
                        sVar2.reset();
                    } else {
                        sVar2.sNl.sPp.sVH.sQe = 109;
                        sVar2.sNl.sPp.sVH.sQw = 4;
                        sVar2.cKn();
                    }
                    String str2 = VoipMgr.this.sRl.field_username;
                    String str3 = VoipMgr.this.sRn ? bi.xZc : bi.xZb;
                    if (!VoipMgr.this.sRm) {
                        i2 = 0;
                    }
                    q.a(str2, str3, i2, 6, string);
                    VoipMgr.f(VoipMgr.this, 4107);
                    VoipMgr.B(VoipMgr.this);
                    bi biVar = new bi();
                    biVar.setType(Downloads.MIN_WAIT_FOR_NETWORK);
                    biVar.eJ(System.currentTimeMillis());
                    biVar.setStatus(6);
                    biVar.setContent(ah.getContext().getString(R.string.f45) + ", <a href=\"weixin://voip/callagain/?username=" + VoipMgr.this.edV + "&isvideocall=" + VoipMgr.this.sRn + "\">" + ah.getContext().getString(R.string.f40) + "</a>");
                    if (!(VoipMgr.this.edV == null || VoipMgr.this.edV.equals(""))) {
                        biVar.ju(VoipMgr.this.edV);
                        ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Z(biVar);
                    }
                    com.tencent.mm.plugin.voip.b.cIj().Gj(2);
                    VoipMgr.this.sSi = false;
                    AppMethodBeat.o(4461);
                    return;
                } else {
                    if (i == 0) {
                        if (VoipMgr.this.sRW == 1 || VoipMgr.this.sRW == 2) {
                            VoipMgr.this.sQQ = System.currentTimeMillis();
                        }
                        VoipMgr.this.sRW = 0;
                        com.tencent.mm.plugin.voip.b.cIj().Gj(2);
                        if (1 == VoipMgr.this.sRr && com.tencent.mm.plugin.voip.a.b.GN(VoipMgr.this.sRc.mState) && VoipMgr.this.sRI) {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(4460);
                                    VoipMgr.b(VoipMgr.this, true);
                                    AppMethodBeat.o(4460);
                                }
                            });
                        }
                        VoipMgr.this.sRI = false;
                        if (com.tencent.mm.compatible.b.g.KK() != null && com.tencent.mm.compatible.b.g.KK().eoY.isBluetoothScoOn()) {
                            ab.i("MicroMsg.Voip.VoipMgr", "is bluetooth can use and start bluetooth");
                            com.tencent.mm.compatible.b.g.KK().KM();
                        }
                        VoipMgr.this.sSi = false;
                    }
                    AppMethodBeat.o(4461);
                    return;
                }
            }
            AppMethodBeat.o(4461);
        }
    };
    com.tencent.mm.sdk.b.c nvc = new com.tencent.mm.sdk.b.c<uh>() {
        {
            AppMethodBeat.i(4471);
            this.xxI = uh.class.getName().hashCode();
            AppMethodBeat.o(4471);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(4472);
            uh uhVar = (uh) bVar;
            if (uhVar instanceof uh) {
                uhVar.cQt.cQu = com.tencent.mm.plugin.voip.a.b.GO(VoipMgr.this.sRc.mState);
                uhVar.cQt.cQv = VoipMgr.this.sRf != null;
                uhVar.cQt.cQw = true;
                uhVar.cQt.talker = VoipMgr.this.edV;
                AppMethodBeat.o(4472);
            } else {
                AppMethodBeat.o(4472);
            }
            return false;
        }
    };
    private long nxl = 0;
    private boolean oue = false;
    long sQP = 0;
    long sQQ = 0;
    private ap sRA = null;
    private al sRB;
    private boolean sRC = false;
    private boolean sRD = false;
    private int sRE = 0;
    private boolean sRF = false;
    boolean sRG = false;
    private com.tencent.mm.plugin.voip.widget.b sRH;
    private boolean sRI = false;
    private boolean sRJ = false;
    public String sRK = null;
    boolean sRL = false;
    public e sRM = null;
    public int sRN = -1;
    public int sRO = 0;
    private long sRP = -1;
    private boolean sRQ = false;
    private long sRR = 0;
    private long sRS = -1;
    int sRT = 0;
    boolean sRU = false;
    boolean sRV = false;
    private int sRW = 0;
    private byte[] sRX = null;
    private boolean sRY = true;
    int sRZ = 0;
    com.tencent.mm.plugin.voip.a.c sRc;
    HeadsetPlugReceiver sRd;
    volatile com.tencent.mm.plugin.voip.ui.b sRe;
    private com.tencent.mm.plugin.voip.video.a sRf;
    private CaptureView sRg;
    private a sRh = null;
    private boolean sRi = false;
    private boolean sRj = false;
    private Object sRk = new Object();
    ad sRl;
    boolean sRm;
    boolean sRn;
    boolean sRo = false;
    private int sRp = 4096;
    private boolean sRq = false;
    int sRr = 1;
    private long sRs = -1;
    private boolean sRt = false;
    boolean sRu = false;
    private boolean sRv = false;
    private boolean sRw = false;
    private int sRx = 0;
    private int sRy = 0;
    k sRz = new k();
    boolean sSa = false;
    NetChangedBroadcastReceiver sSb;
    PhoneStateListener sSc;
    al sSd = new al("getSignalStrength");
    ak sSe = new ak(this.sSd.oAl.getLooper());
    TelephonyManager sSg = null;
    private long sSh = 0;
    private boolean sSi = false;
    BroadcastReceiver sSj = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(4457);
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) ah.getContext().getSystemService("power");
            if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
                VoipMgr.this.sRw = false;
                AppMethodBeat.o(4457);
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                VoipMgr.this.sRw = false;
                AppMethodBeat.o(4457);
            } else {
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    VoipMgr.this.sRw = true;
                    if (!(com.tencent.mm.plugin.voip.a.b.GN(VoipMgr.this.sRc.mState) || VoipMgr.this.sRm)) {
                        com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
                    }
                }
                AppMethodBeat.o(4457);
            }
        }
    };
    com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a sSk = new com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a() {
        public final void fS(boolean z) {
            AppMethodBeat.i(4477);
            boolean KP = com.tencent.mm.compatible.b.g.KK().KP();
            ab.i("MicroMsg.Voip.VoipMgr", "onHeadsetState, on:%b, bluetooth: %s", Boolean.valueOf(z), Boolean.valueOf(KP));
            if (!(z && 3 == VoipMgr.this.sRr) && (z || 3 == VoipMgr.this.sRr)) {
                if (com.tencent.mm.plugin.voip.a.b.GO(VoipMgr.this.sRc.mState)) {
                    if (z || KP) {
                        VoipMgr.b(VoipMgr.this, false);
                        if (z) {
                            VoipMgr.this.sRr = 3;
                        } else {
                            VoipMgr.this.sRr = 4;
                        }
                    } else if (com.tencent.mm.plugin.voip.b.cIj().sSP.cKq()) {
                        Toast.makeText(VoipMgr.g(VoipMgr.this), VoipMgr.g(VoipMgr.this).getString(R.string.f7g), 0).show();
                        VoipMgr.b(VoipMgr.this, true);
                        VoipMgr.this.sRr = 1;
                    } else {
                        VoipMgr.b(VoipMgr.this, false);
                        VoipMgr.this.sRr = 2;
                    }
                } else if (z || KP) {
                    if (1 == VoipMgr.this.sRr) {
                        VoipMgr.b(VoipMgr.this, false);
                        VoipMgr.this.sRt = true;
                    } else {
                        VoipMgr.this.sRt = false;
                    }
                    if (z) {
                        VoipMgr.this.sRr = 3;
                    } else {
                        VoipMgr.this.sRr = 4;
                    }
                } else if (com.tencent.mm.plugin.voip.b.cIj().sSP.cKq()) {
                    if (VoipMgr.this.sRt || 2 == VoipMgr.this.mUIType) {
                        Toast.makeText(VoipMgr.g(VoipMgr.this), VoipMgr.g(VoipMgr.this).getString(R.string.f7g), 0).show();
                        VoipMgr.b(VoipMgr.this, true);
                        VoipMgr.this.sRr = 1;
                    } else {
                        Toast.makeText(VoipMgr.g(VoipMgr.this), VoipMgr.g(VoipMgr.this).getString(R.string.f7f), 0).show();
                        VoipMgr.this.sRr = 2;
                    }
                    VoipMgr.this.sRt = false;
                } else {
                    VoipMgr.b(VoipMgr.this, false);
                    VoipMgr.this.sRr = 2;
                }
                com.tencent.mm.plugin.voip.b.cIj().jj(z);
                VoipMgr.b(VoipMgr.this, VoipMgr.this.sRr);
                AppMethodBeat.o(4477);
                return;
            }
            ab.i("MicroMsg.Voip.VoipMgr", "same status, no changed");
            AppMethodBeat.o(4477);
        }
    };
    int sSl = 0;
    com.tencent.mm.sdk.b.c sSm = new com.tencent.mm.sdk.b.c<vj>() {
        {
            AppMethodBeat.i(4474);
            this.xxI = vj.class.getName().hashCode();
            AppMethodBeat.o(4474);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(4475);
            final vj vjVar = (vj) bVar;
            if (vjVar instanceof vj) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4473);
                        switch (vjVar.cSr.cuy) {
                            case 1:
                                if (com.tencent.mm.plugin.voip.a.b.GO(VoipMgr.this.sRc.mState)) {
                                    VoipMgr.this.cJn();
                                    AppMethodBeat.o(4473);
                                    return;
                                }
                                VoipMgr.this.cJq();
                                AppMethodBeat.o(4473);
                                return;
                            case 2:
                                if (com.tencent.mm.plugin.voip.a.b.GO(VoipMgr.this.sRc.mState)) {
                                    VoipMgr.this.cJm();
                                    AppMethodBeat.o(4473);
                                    return;
                                }
                                VoipMgr.this.cJp();
                                AppMethodBeat.o(4473);
                                return;
                            case 3:
                                VoipMgr.this.cJk();
                                break;
                        }
                        AppMethodBeat.o(4473);
                    }
                });
            }
            AppMethodBeat.o(4475);
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.voip.model.VoipMgr$14 */
    class AnonymousClass14 implements OnClickListener {
        final /* synthetic */ Context sSy;

        AnonymousClass14(Context context) {
            this.sSy = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(4476);
            ab.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
            com.tencent.mm.compatible.f.b.bE(this.sSy);
            if (VoipMgr.this.sRm) {
                if (VoipMgr.this.sRn) {
                    VoipMgr.this.cJr();
                    AppMethodBeat.o(4476);
                    return;
                }
                VoipMgr.this.cJs();
                AppMethodBeat.o(4476);
            } else if (VoipMgr.this.sRn) {
                VoipMgr.this.cJm();
                AppMethodBeat.o(4476);
            } else {
                VoipMgr.this.cJp();
                AppMethodBeat.o(4476);
            }
        }
    }

    public class NetChangedBroadcastReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            int i = 0;
            AppMethodBeat.i(4484);
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                int i2;
                int aSQ;
                int i3;
                switch (com.tencent.mm.plugin.voip.a.a.getNetType(context)) {
                    case 4:
                        if (VoipMgr.this.sRZ != 4) {
                            i2 = VoipMgr.sSf[0];
                            if (VoipMgr.this.sSl == 0) {
                                VoipMgr.c(VoipMgr.this, 5);
                            }
                            aSQ = VoipMgr.idk / VoipMgr.this.sSl;
                            VoipMgr.c(VoipMgr.this, 4);
                            i3 = VoipMgr.sSf[1];
                            ab.i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.this.mui);
                            if (!VoipMgr.this.sRm) {
                                i = 1;
                            }
                            com.tencent.mm.plugin.voip.a.a.a(i, System.currentTimeMillis(), VoipMgr.this.sRZ, 4, i2, i3, aSQ);
                            VoipMgr.this.sSa = true;
                            VoipMgr.this.sRZ = 4;
                            VoipMgr.idk = 0;
                            VoipMgr.this.sSl = 0;
                            break;
                        }
                        break;
                    case 5:
                        if (VoipMgr.this.sRZ != 5) {
                            i2 = VoipMgr.sSf[1];
                            if (VoipMgr.this.sSl == 0) {
                                VoipMgr.c(VoipMgr.this, 4);
                            }
                            aSQ = VoipMgr.idk / VoipMgr.this.sSl;
                            VoipMgr.c(VoipMgr.this, 5);
                            i3 = VoipMgr.sSf[0];
                            ab.i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.this.mui);
                            if (!VoipMgr.this.sRm) {
                                i = 1;
                            }
                            com.tencent.mm.plugin.voip.a.a.a(i, System.currentTimeMillis(), VoipMgr.this.sRZ, 5, i2, i3, aSQ);
                            VoipMgr.this.sSa = true;
                            VoipMgr.this.sRZ = 5;
                            VoipMgr.idk = 0;
                            VoipMgr.this.sSl = 0;
                            AppMethodBeat.o(4484);
                            return;
                        }
                        break;
                }
                AppMethodBeat.o(4484);
            } else if (intent.getAction().equals("android.net.wifi.STATE_CHANGE") && VoipMgr.this.sSh == 0) {
                VoipMgr.this.sSh = System.currentTimeMillis();
                AppMethodBeat.o(4484);
            } else {
                if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED") && VoipMgr.this.sSh != 0) {
                    VoipMgr.this.mui = System.currentTimeMillis() - VoipMgr.this.sSh;
                    VoipMgr.this.sSh = 0;
                }
                AppMethodBeat.o(4484);
            }
        }
    }

    class a implements Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(4483);
            VoipMgr.u(VoipMgr.this);
            VoipMgr.this.sRh = null;
            AppMethodBeat.o(4483);
        }
    }

    public VoipMgr() {
        AppMethodBeat.i(4485);
        AppMethodBeat.o(4485);
    }

    static /* synthetic */ void B(VoipMgr voipMgr) {
        AppMethodBeat.i(4562);
        voipMgr.cJz();
        AppMethodBeat.o(4562);
    }

    static /* synthetic */ void G(VoipMgr voipMgr) {
        AppMethodBeat.i(4565);
        voipMgr.mu(true);
        AppMethodBeat.o(4565);
    }

    static /* synthetic */ Context g(VoipMgr voipMgr) {
        AppMethodBeat.i(4554);
        Context context = voipMgr.getContext();
        AppMethodBeat.o(4554);
        return context;
    }

    static /* synthetic */ String lH(long j) {
        AppMethodBeat.i(4560);
        String fQ = fQ(j);
        AppMethodBeat.o(4560);
        return fQ;
    }

    static /* synthetic */ void t(VoipMgr voipMgr) {
        AppMethodBeat.i(4558);
        voipMgr.cJF();
        AppMethodBeat.o(4558);
    }

    static /* synthetic */ void u(VoipMgr voipMgr) {
        AppMethodBeat.i(4559);
        voipMgr.cJH();
        AppMethodBeat.o(4559);
    }

    public final void he(boolean z) {
        AppMethodBeat.i(4486);
        ab.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", Boolean.valueOf(z), Boolean.valueOf(this.sRQ), Long.valueOf(this.sRP));
        if (this.sRc == null) {
            ab.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
            AppMethodBeat.o(4486);
        } else if (Math.abs(bo.yz() - this.sRS) >= 500 || this.sRS == -1) {
            if (com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState) && (this.sRQ != z || this.sRP == -1)) {
                if (!(this.sRQ || !z || com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState) || this.mUIType == 2 || this.sRP == -1)) {
                    ab.i("MicroMsg.Voip.VoipMgr", "accumulate near screen time: %s", Long.valueOf(bo.az(this.sRP)));
                    this.sRR = r0 + this.sRR;
                }
                this.sRP = bo.yz();
                this.sRQ = z;
            }
            if (this.sRe == null) {
                ab.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, voipUI is null, ignore");
                AppMethodBeat.o(4486);
                return;
            }
            if (!((!this.sRm && !com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState)) || com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState) || this.mUIType == 2)) {
                ab.d("MicroMsg.Voip.VoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(z)));
                this.sRe.setScreenEnable(z);
                this.sRS = bo.yz();
            }
            AppMethodBeat.o(4486);
        } else {
            ab.d("MicroMsg.Voip.VoipMgr", "onSensorEvent time interval too small");
            AppMethodBeat.o(4486);
        }
    }

    public final void gE(int i) {
        AppMethodBeat.i(4487);
        ab.i("MicroMsg.Voip.VoipMgr", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b, isHeadsetPlugged: %s", Integer.valueOf(i), Boolean.valueOf(this.sRu), Boolean.valueOf(com.tencent.mm.compatible.b.g.KK().KV()));
        switch (i) {
            case 1:
                if (!com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState)) {
                    this.sRu = 1 == this.sRr;
                }
                com.tencent.mm.compatible.b.g.KK().b(false, com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIt(), false);
                com.tencent.mm.plugin.voip.b.cIj().mj(false);
                com.tencent.mm.plugin.voip.b.cIj().mp(false);
                Go(4);
                this.sRL = false;
                com.tencent.mm.plugin.voip.b.cIj().jj(true);
                AppMethodBeat.o(4487);
                return;
            case 2:
                if (!this.sSi) {
                    com.tencent.mm.compatible.b.g.KK().KN();
                    cJj();
                    this.sRU = true;
                    AppMethodBeat.o(4487);
                    return;
                }
                break;
            case 3:
                com.tencent.mm.compatible.b.g.KK().KM();
                this.sRL = false;
                AppMethodBeat.o(4487);
                return;
            case 4:
                com.tencent.mm.compatible.b.g.KK().KN();
                com.tencent.mm.compatible.b.g.KK().KL();
                cJj();
                AppMethodBeat.o(4487);
                return;
            case 5:
                com.tencent.mm.compatible.b.g.KK().KM();
                break;
        }
        AppMethodBeat.o(4487);
    }

    private void cJj() {
        AppMethodBeat.i(4488);
        boolean KV = com.tencent.mm.compatible.b.g.KK().KV();
        String str = "MicroMsg.Voip.VoipMgr";
        String str2 = "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s";
        Object[] objArr = new Object[6];
        objArr[0] = Boolean.valueOf(this.sRL);
        objArr[1] = Boolean.valueOf(com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState));
        objArr[2] = Boolean.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.cKq());
        objArr[3] = Boolean.valueOf(this.sRu);
        objArr[4] = Boolean.valueOf(2 == this.mUIType);
        objArr[5] = Boolean.valueOf(KV);
        ab.i(str, str2, objArr);
        if (!this.sRL) {
            if (com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState)) {
                if (!com.tencent.mm.plugin.voip.b.cIj().sSP.cKq()) {
                    mr(false);
                    this.sRr = 2;
                } else if (KV) {
                    mr(false);
                    this.sRr = 2;
                } else {
                    P(true, true);
                    this.sRr = 1;
                }
            } else if (com.tencent.mm.plugin.voip.b.cIj().sSP.cKq()) {
                if ((this.sRu || 2 == this.mUIType) && !KV) {
                    P(true, true);
                    this.sRr = 1;
                } else if (KV) {
                    this.sRr = 3;
                } else {
                    this.sRr = 2;
                }
                this.sRu = false;
            } else {
                mr(false);
                this.sRr = 2;
            }
            Go(this.sRr);
            this.sRL = true;
            com.tencent.mm.plugin.voip.b.cIj().jj(false);
        }
        AppMethodBeat.o(4488);
    }

    private void Go(int i) {
        AppMethodBeat.i(4489);
        this.sRr = i;
        if (this.sRe != null) {
            this.sRe.GC(this.sRr);
        }
        AppMethodBeat.o(4489);
    }

    private void mr(boolean z) {
        AppMethodBeat.i(4490);
        P(z, this.sRU);
        AppMethodBeat.o(4490);
    }

    private void P(boolean z, boolean z2) {
        AppMethodBeat.i(4491);
        ab.b("MicroMsg.Voip.VoipMgr", "enableSpeaker: %s, ignoreBluetooth: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        this.sRt = z;
        this.sRu = z;
        ab.d("MicroMsg.Voip.VoipMgr", "MMCore.getAudioManager() " + com.tencent.mm.compatible.b.g.KK().KT());
        if (!z2 && com.tencent.mm.compatible.b.g.KK().KP()) {
            z = false;
        }
        if (q.etd.epG) {
            q.etd.dump();
            if (q.etd.epH > 0) {
                com.tencent.mm.plugin.voip.b.cIj().mj(z);
            }
        }
        if (q.etd.eqj >= 0 || q.etd.eqk >= 0) {
            com.tencent.mm.plugin.voip.b.cIj().mj(z);
        }
        com.tencent.mm.compatible.b.g.KK().b(z, com.tencent.mm.plugin.voip.b.cIj().sSP.cIt(), z2);
        com.tencent.mm.plugin.voip.b.cIj().mp(z);
        this.sRv = z;
        AppMethodBeat.o(4491);
    }

    public final void ms(boolean z) {
        int i;
        AppMethodBeat.i(4492);
        ab.d("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", Boolean.valueOf(z));
        if (com.tencent.mm.plugin.voip.b.cIj().sSP.cKq()) {
            mr(z);
        } else {
            s sVar = com.tencent.mm.plugin.voip.b.cIj().sSP;
            if (sVar.sTj != null) {
                sVar.sTj.mE(z);
            }
        }
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        Go(i);
        h hVar = h.pYm;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(0);
        hVar.e(11080, objArr);
        AppMethodBeat.o(4492);
    }

    public final void jg(boolean z) {
        int i = 1;
        AppMethodBeat.i(4493);
        m mVar;
        if (z) {
            mVar = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPr;
            if (mVar.kzb != null) {
                mVar.kzb.bs(true);
            }
            com.tencent.mm.plugin.voip.b.cIj().Gh(9);
            com.tencent.mm.plugin.voip.b.cIj().mo(true);
        } else {
            mVar = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPr;
            if (mVar.kzb != null) {
                mVar.kzb.bs(false);
            }
            com.tencent.mm.plugin.voip.b.cIj().Gh(8);
            com.tencent.mm.plugin.voip.b.cIj().mo(false);
        }
        this.mIsMute = z;
        h hVar = h.pYm;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(0);
        if (z) {
            i = 2;
        }
        objArr[2] = Integer.valueOf(i);
        hVar.e(11080, objArr);
        AppMethodBeat.o(4493);
    }

    public final boolean cJk() {
        AppMethodBeat.i(4494);
        if (this.sRc.GQ(4103)) {
            Gq(4103);
            com.tencent.mm.plugin.voip.b.cIj().cKe();
            AppMethodBeat.o(4494);
            return true;
        }
        AppMethodBeat.o(4494);
        return false;
    }

    public final boolean cJl() {
        AppMethodBeat.i(4495);
        if (this.sRc.GQ(4101)) {
            com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
            com.tencent.mm.plugin.voip.b.cIj().Gh(1);
            com.tencent.mm.plugin.voip.b.cIj().R(true, this.sRn);
            h hVar = h.pYm;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv);
            objArr[2] = Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(this.sRm ? 1 : 0);
            hVar.e(11046, objArr);
            h.pYm.e(11080, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0));
            oE(4111);
            oE(4101);
            oE(4100);
            AppMethodBeat.o(4495);
            return true;
        }
        AppMethodBeat.o(4495);
        return false;
    }

    public final boolean cJm() {
        int i = 0;
        AppMethodBeat.i(4496);
        if (this.sRc.GQ(4099)) {
            String str = this.sRl.field_username;
            String str2 = this.sRn ? bi.xZc : bi.xZb;
            if (this.sRm) {
                i = 1;
            }
            q.a(str, str2, i, 6, ah.getContext().getString(R.string.f4_));
            com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
            com.tencent.mm.plugin.voip.b.cIj().sSP.cKl();
            oE(4099);
            cJz();
            AppMethodBeat.o(4496);
            return true;
        }
        AppMethodBeat.o(4496);
        return false;
    }

    public final boolean cJn() {
        AppMethodBeat.i(4497);
        if (this.sRc.GQ(4100)) {
            if (q.etc.eqU == 1 && this.sRn) {
                mt(true);
            }
            if ((!this.sRY || q.etc.eqU == 1 || q.etc.eqV == 1) && this.sRn) {
                boolean z = this.sRf == null || this.sRf.cLE();
                mt(z);
                this.sRY = true;
            }
            ab.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
            com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
            com.tencent.mm.plugin.voip.b.cIj().R(false, this.sRn);
            oE(4100);
            AppMethodBeat.o(4497);
            return true;
        }
        AppMethodBeat.o(4497);
        return false;
    }

    public final void cJo() {
        this.sRY = false;
    }

    public final boolean cJp() {
        int i = 0;
        AppMethodBeat.i(4498);
        if (this.sRc.GQ(4099)) {
            ab.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
            String str = this.sRl.field_username;
            String str2 = this.sRn ? bi.xZc : bi.xZb;
            if (this.sRm) {
                i = 1;
            }
            q.a(str, str2, i, 6, ah.getContext().getString(R.string.f4_));
            com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
            com.tencent.mm.plugin.voip.b.cIj().sSP.cKl();
            oE(4099);
            cJz();
            AppMethodBeat.o(4498);
            return true;
        }
        AppMethodBeat.o(4498);
        return false;
    }

    public final boolean cJq() {
        AppMethodBeat.i(4499);
        if (this.sRc.GQ(4100)) {
            ab.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
            com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
            com.tencent.mm.plugin.voip.b.cIj().R(true, this.sRn);
            oE(4111);
            oE(4100);
            AppMethodBeat.o(4499);
            return true;
        }
        AppMethodBeat.o(4499);
        return false;
    }

    public final boolean cJr() {
        AppMethodBeat.i(4500);
        if (this.sRc.GQ(4098)) {
            ab.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
            Gq(4098);
            com.tencent.mm.plugin.voip.b.cIj().cKe();
            AppMethodBeat.o(4500);
            return true;
        }
        AppMethodBeat.o(4500);
        return false;
    }

    public final boolean cJs() {
        AppMethodBeat.i(4501);
        if (this.sRc.GQ(4098)) {
            ab.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
            Gq(4098);
            com.tencent.mm.plugin.voip.b.cIj().cKe();
            AppMethodBeat.o(4501);
            return true;
        }
        AppMethodBeat.o(4501);
        return false;
    }

    public final void a(com.tencent.mm.plugin.voip.ui.b bVar, int i) {
        AppMethodBeat.i(4502);
        ab.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s", Integer.valueOf(i), this.sRf);
        if (1 == i && this.sRe != null) {
            this.sRe.uninit();
        }
        this.sRe = bVar;
        this.mUIType = i;
        if (this.sRf == null && com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState)) {
            this.sRg = new CaptureView(ah.getContext());
        }
        if (this.sRn) {
            this.sRe.setCaptureView(this.sRg);
            if (q.etc.eqU == 0) {
                boolean z = this.sRf == null || this.sRf.cLE();
                mt(z);
            }
        }
        this.sRe.fY(-1, this.sRc.mState);
        this.sRe.setConnectSec(this.sRs);
        this.sRe.GC(this.sRr);
        this.sRe.setMute(this.mIsMute);
        ab.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", Integer.valueOf(this.sRN), Integer.valueOf(this.sRO));
        if (this.sRN != -1) {
            this.sRe.setHWDecMode(this.sRN);
            ab.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", Integer.valueOf(this.sRN));
        }
        this.sRe.setVoipBeauty(this.sRO);
        AppMethodBeat.o(4502);
    }

    /* Access modifiers changed, original: final */
    public final void Gp(int i) {
        AppMethodBeat.i(4503);
        if (i == 5) {
            idk += sSf[0];
            this.sSl++;
            ab.i("MicroMsg.Voip.VoipMgr", "mSignalStrength 4G" + sSf[0] + " and index is " + this.sSl);
            AppMethodBeat.o(4503);
            return;
        }
        if (i == 4) {
            WifiManager wifiManager = (WifiManager) ah.getContext().getApplicationContext().getSystemService("wifi");
            idk += wifiManager.getConnectionInfo().getRssi();
            sSf[1] = wifiManager.getConnectionInfo().getRssi();
            this.sSl++;
            ab.i("MicroMsg.Voip.VoipMgr", "mSignalStrength WIFI " + wifiManager.getConnectionInfo().getRssi() + " and index is " + this.sSl);
        }
        AppMethodBeat.o(4503);
    }

    public final void cJt() {
        AppMethodBeat.i(4504);
        ab.i("MicroMsg.Voip.VoipMgr", "it is init voip report");
        this.sSb = new NetChangedBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ah.getContext().registerReceiver(this.sSb, intentFilter);
        this.sSg = (TelephonyManager) ah.getContext().getSystemService("phone");
        this.sRZ = com.tencent.mm.plugin.voip.a.a.getNetType(getContext());
        this.sSc = new PhoneStateListener() {
            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                AppMethodBeat.i(4478);
                super.onSignalStrengthsChanged(signalStrength);
                super.onSignalStrengthsChanged(signalStrength);
                String[] split = signalStrength.toString().split(" ");
                try {
                    if (VoipMgr.this.sSg.getNetworkType() == 13 && split.length > 9) {
                        VoipMgr.sSf[0] = bo.ank(split[9]);
                    }
                    AppMethodBeat.o(4478);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Voip.VoipMgr", e, "", new Object[0]);
                    AppMethodBeat.o(4478);
                }
            }
        };
        this.sSg.listen(this.sSc, 256);
        AppMethodBeat.o(4504);
    }

    private void mt(boolean z) {
        AppMethodBeat.i(4505);
        if (this.sRn) {
            ab.i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", Boolean.valueOf(z));
            int i = 320;
            int i2 = 240;
            if (v2protocal.sTV) {
                ab.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
                i = 640;
                i2 = 480;
            }
            if (this.sRf == null) {
                this.sRf = new com.tencent.mm.plugin.voip.video.a(i, i2);
            }
            this.sRY = this.sRf.a((g) this, z) == 1;
            if (this.sRY && this.sRg != null) {
                this.sRf.a(this.sRg);
                com.tencent.mm.plugin.voip.b.cIj().Gw(this.sRf.cLG());
                if (this.iGP != null) {
                    this.iGP.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(4479);
                            ab.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + VoipMgr.this.sRf);
                            if (VoipMgr.this.sRf != null) {
                                VoipMgr.this.sRf.cLC();
                            }
                            AppMethodBeat.o(4479);
                        }
                    }, 50);
                }
            }
        }
        AppMethodBeat.o(4505);
    }

    public final void a(com.tencent.mm.plugin.voip.ui.b bVar) {
        AppMethodBeat.i(4506);
        ab.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
        if (this.sRe == bVar) {
            ab.d("MicroMsg.Voip.VoipMgr", "same VoipUI, clear it");
            this.sRe = null;
        }
        if (this.iGP != null) {
            this.iGP = null;
        }
        AppMethodBeat.o(4506);
    }

    public final void cJu() {
        AppMethodBeat.i(4507);
        ab.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
        if (this.sRf != null) {
            this.sRf.cLB();
        }
        h.pYm.e(11079, Integer.valueOf(1));
        AppMethodBeat.o(4507);
    }

    public final void cJv() {
        AppMethodBeat.i(4508);
        if (true != this.sRf.cLE()) {
            cJu();
        }
        AppMethodBeat.o(4508);
    }

    private void Gq(int i) {
        String string;
        int i2 = 0;
        AppMethodBeat.i(4509);
        ab.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
        if (true == cJJ()) {
            this.sRp = i;
        }
        Context context = ah.getContext();
        if (com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState)) {
            string = context.getString(R.string.f47, new Object[]{fQ(bo.fp(this.sRs))});
        } else if (this.sRm) {
            string = context.getString(R.string.f42);
        } else {
            string = context.getString(R.string.f41);
        }
        String str = this.sRl.field_username;
        String str2 = this.sRn ? bi.xZc : bi.xZb;
        if (this.sRm) {
            i2 = 1;
        }
        q.a(str, str2, i2, 6, string);
        if (!this.sRm || com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState)) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4480);
                    com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
                    if (VoipMgr.this.sRn) {
                        com.tencent.mm.plugin.voip.b.cIj().Gx(0);
                        AppMethodBeat.o(4480);
                        return;
                    }
                    com.tencent.mm.plugin.voip.b.cIj().Gx(1);
                    AppMethodBeat.o(4480);
                }
            }, "VoipMgr_play_end_sound");
            this.sRi = true;
            this.sRj = true;
            com.tencent.mm.plugin.voip.b.cIj().sSP.cKm();
            if (4096 == this.sRp) {
                oE(i);
                cJz();
            }
        } else {
            com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
            if (this.sRm && !com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState)) {
                ab.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
                com.tencent.mm.plugin.voip.b.cIj().sSP.cKj();
            }
            ab.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
            com.tencent.mm.plugin.voip.b.cIj().sSP.cKm();
            if (4096 == this.sRp) {
                oE(i);
                cJz();
                AppMethodBeat.o(4509);
                return;
            }
        }
        AppMethodBeat.o(4509);
    }

    public final void b(MMTextureView mMTextureView) {
        AppMethodBeat.i(4510);
        if (this.sRM != null) {
            e eVar = this.sRM;
            ab.i("DecodeTextureView", "steve: init hwview, recreateView: ".concat(String.valueOf(mMTextureView)));
            eVar.mdt = mMTextureView;
            eVar.mdt.setSurfaceTextureListener(eVar);
            if (!(eVar.sZW == null || eVar.sZW == mMTextureView.getSurfaceTexture())) {
                ab.i("DecodeTextureView", "using saved st=" + eVar.sZW);
                mMTextureView.setSurfaceTexture(eVar.sZW);
            }
        }
        AppMethodBeat.o(4510);
    }

    public final boolean cJw() {
        AppMethodBeat.i(4511);
        if (com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu == 0) {
            this.sRq = true;
            AppMethodBeat.o(4511);
            return true;
        }
        boolean cJx = cJx();
        AppMethodBeat.o(4511);
        return cJx;
    }

    private boolean cJx() {
        AppMethodBeat.i(4512);
        if (this.sRc.GQ(4101)) {
            Object[] objArr;
            h hVar;
            int i;
            int i2;
            Object[] objArr2;
            int i3;
            oE(4101);
            Object[] objArr3;
            if (com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW == this.sRc.mState || 7 == this.sRc.mState) {
                com.tencent.mm.plugin.voip.b.cIj().Gh(1);
                h hVar2 = h.pYm;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(2);
                objArr[1] = Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv);
                objArr[2] = Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = Integer.valueOf(this.sRm ? 1 : 0);
                hVar2.e(11046, objArr);
                hVar = h.pYm;
                i = 11080;
                objArr3 = new Object[3];
                objArr3[0] = Integer.valueOf(2);
                objArr3[1] = Integer.valueOf(0);
                i2 = 2;
                objArr2 = objArr3;
                objArr = objArr3;
            } else {
                if (1 == this.sRc.mState || 3 == this.sRc.mState) {
                    com.tencent.mm.plugin.voip.b.cIj().Gh(1);
                    hVar = h.pYm;
                    i = 11046;
                    objArr3 = new Object[5];
                    objArr3[0] = Integer.valueOf(1);
                    objArr3[1] = Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv);
                    objArr3[2] = Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu);
                    objArr3[3] = Integer.valueOf(0);
                    i2 = 4;
                    if (this.sRm) {
                        i3 = 1;
                        objArr2 = objArr3;
                        objArr = objArr3;
                        objArr2[i2] = Integer.valueOf(i3);
                        hVar.e(i, objArr);
                    } else {
                        objArr2 = objArr3;
                        objArr = objArr3;
                    }
                }
                com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIP();
                com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIQ();
                this.sRn = false;
                AppMethodBeat.o(4512);
                return true;
            }
            i3 = 0;
            objArr2[i2] = Integer.valueOf(i3);
            hVar.e(i, objArr);
            com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIP();
            com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIQ();
            this.sRn = false;
            AppMethodBeat.o(4512);
            return true;
        }
        AppMethodBeat.o(4512);
        return false;
    }

    public final void cJy() {
        AppMethodBeat.i(4513);
        ab.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
        if (this.sRq && com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu != 0) {
            this.sRq = false;
            cJx();
        }
        if (this.sRm) {
            oE(4097);
        }
        AppMethodBeat.o(4513);
    }

    private void oE(final int i) {
        AppMethodBeat.i(4514);
        ab.b("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", com.tencent.mm.plugin.voip.a.b.GK(i), com.tencent.mm.plugin.voip.a.b.GK(this.sRc.mState));
        if (4101 == i && com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState)) {
            cJI();
            this.sRn = false;
        }
        if (Gr(i) && 1 == this.mUIType && 1 == this.sRr) {
            this.sRJ = true;
            mr(false);
            Go(2);
        }
        this.sRc.GR(i);
        if (this.iGP != null) {
            this.iGP.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4481);
                    if (VoipMgr.this.sRe != null) {
                        VoipMgr.this.sRe.fY(i, VoipMgr.this.sRc.mState);
                    }
                    AppMethodBeat.o(4481);
                }
            });
        }
        switch (this.sRc.mState) {
            case com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
            case com.tencent.view.d.MIC_PTU_ZIPAI_MEDSEA /*259*/:
                Gs(5);
                AppMethodBeat.o(4514);
                return;
            case com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                Gs(6);
                break;
        }
        AppMethodBeat.o(4514);
    }

    private boolean Gr(int i) {
        AppMethodBeat.i(4515);
        if (4111 == i) {
            AppMethodBeat.o(4515);
            return true;
        } else if (4101 == i && (com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState) || this.sRm)) {
            AppMethodBeat.o(4515);
            return true;
        } else {
            AppMethodBeat.o(4515);
            return false;
        }
    }

    private static void Gs(int i) {
        AppMethodBeat.i(4516);
        vj vjVar = new vj();
        vjVar.cSr.cuy = i;
        com.tencent.mm.sdk.b.a.xxA.m(vjVar);
        AppMethodBeat.o(4516);
    }

    public final void onError(int i, String str) {
        String string;
        AppMethodBeat.i(4517);
        if (this.sRn) {
            com.tencent.mm.plugin.voip.b.cIj().Gx(0);
        } else {
            com.tencent.mm.plugin.voip.b.cIj().Gx(1);
        }
        if (i == com.tencent.view.d.MIC_PTU_QINGCONG && bo.isNullOrNil(str)) {
            str = getContext().getString(R.string.f6k);
        }
        if (this.sRe != null) {
            this.sRe.br(i, str);
        }
        oE(4109);
        ab.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu));
        Context context = ah.getContext();
        ab.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(i)));
        if (i == com.tencent.view.d.MIC_PTU_AUTOLEVEL) {
            string = context.getString(R.string.f4b);
        } else if (i == com.tencent.view.d.MIC_PTU_MEISHI) {
            string = context.getString(R.string.f44);
        } else if (i == com.tencent.view.d.MIC_PTU_LENGMEIREN) {
            string = context.getString(R.string.f4b);
        } else if (i == 236) {
            string = context.getString(R.string.f44);
        } else if (i == 211) {
            string = context.getString(R.string.f4a);
        } else {
            string = context.getString(R.string.f43);
        }
        String str2;
        String str3;
        int i2;
        if (com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu != 0 && com.tencent.mm.plugin.voip.b.cIj().sSU.get(Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu)) == null) {
            str2 = this.sRl.field_username;
            if (this.sRn) {
                str3 = bi.xZc;
            } else {
                str3 = bi.xZb;
            }
            if (this.sRm) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState)) {
                string = ah.getContext().getString(R.string.f48, new Object[]{fQ(bo.fp(this.sRs))});
            }
            com.tencent.mm.plugin.voip.b.cIj().sSU.put(Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(q.a(str2, str3, i2, 6, string, true)));
        } else if (com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu == 0) {
            str2 = this.sRl.field_username;
            if (this.sRn) {
                str3 = bi.xZc;
            } else {
                str3 = bi.xZb;
            }
            if (this.sRm) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState)) {
                string = ah.getContext().getString(R.string.f48, new Object[]{fQ(bo.fp(this.sRs))});
            }
            q.a(str2, str3, i2, 6, string, true);
        }
        com.tencent.mm.plugin.voip.b.cIj().cKe();
        cJz();
        AppMethodBeat.o(4517);
    }

    public final void bGL() {
        AppMethodBeat.i(4518);
        ab.i("MicroMsg.Voip.VoipMgr", "on accept");
        com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
        oE(4100);
        AppMethodBeat.o(4518);
    }

    public final void onReject() {
        AppMethodBeat.i(4519);
        ab.i("MicroMsg.Voip.VoipMgr", "onReject");
        oE(4099);
        q.a(this.sRl.field_username, this.sRn ? bi.xZc : bi.xZb, this.sRm ? 1 : 0, 6, ah.getContext().getString(R.string.f4d));
        cJz();
        AppMethodBeat.o(4519);
    }

    private void cJz() {
        AppMethodBeat.i(4520);
        ab.d("MicroMsg.Voip.VoipMgr", "delayFinish");
        this.sRK = null;
        if (this.iGP != null) {
            this.iGP.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4482);
                    VoipMgr voipMgr = VoipMgr.this;
                    ab.i("MicroMsg.Voip.VoipMgr", "it is uninit voip report");
                    voipMgr.sSe.removeCallbacksAndMessages(null);
                    voipMgr.sSd = null;
                    if (!voipMgr.sSa) {
                        if (voipMgr.sSl == 0) {
                            voipMgr.Gp(voipMgr.sRZ);
                        }
                        if (voipMgr.sSl != 0) {
                            voipMgr.sSa = true;
                            com.tencent.mm.plugin.voip.a.a.a(voipMgr.sRm ? 0 : 1, System.currentTimeMillis(), voipMgr.sRZ, voipMgr.sRZ, 0, 0, VoipMgr.idk / voipMgr.sSl);
                        }
                    }
                    VoipMgr.idk = 0;
                    VoipMgr.sSf[0] = 0;
                    VoipMgr.sSf[1] = 0;
                    voipMgr.sSl = 0;
                    if (voipMgr.sSg != null) {
                        voipMgr.sSg.listen(voipMgr.sSc, 0);
                    }
                    if (voipMgr.sSb != null) {
                        ah.getContext().unregisterReceiver(voipMgr.sSb);
                        voipMgr.sSb = null;
                    }
                    VoipMgr.r(VoipMgr.this);
                    AppMethodBeat.o(4482);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(4520);
    }

    /* Access modifiers changed, original: final */
    public final void mu(boolean z) {
        r cIj;
        AppMethodBeat.i(4521);
        ab.i("MicroMsg.Voip.VoipMgr", "finish");
        this.sRG = false;
        this.sRI = false;
        if (this.sRx != -1) {
            h.pYm.e(11700, Integer.valueOf(this.sRx), Long.valueOf(bo.fp(this.sRs)));
            this.sRx = -1;
        }
        try {
            ah.getContext().unregisterReceiver(this.sSj);
        } catch (Exception e) {
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.nvc);
        com.tencent.mm.sdk.b.a.xxA.d(this.sSm);
        if (this.sRe != null) {
            this.sRe.uninit();
            this.sRe = null;
        }
        this.sRg = null;
        this.sRM = null;
        com.tencent.mm.compatible.b.g.KK().b((com.tencent.mm.compatible.b.g.a) this);
        com.tencent.mm.compatible.b.g.KK().KN();
        if (com.tencent.mm.plugin.voip.b.cIj() != null) {
            com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
            if (z) {
                com.tencent.mm.plugin.voip.b.cIj().sSP.cKo();
            } else {
                com.tencent.mm.plugin.voip.b.cIj().sSP.cKm();
            }
            if (this.sRn) {
                com.tencent.mm.plugin.voip.b.cIj().b(false, true, this.edV);
            } else {
                com.tencent.mm.plugin.voip.b.cIj().b(false, false, this.edV);
            }
            cIj = com.tencent.mm.plugin.voip.b.cIj();
            Context context = ah.getContext();
            s sVar = cIj.sSP;
            if (context == sVar.sNl.jiq && this == sVar.sNl.sPq) {
                sVar.sNl.jiq = null;
                sVar.sNl.sPq = u.sTD;
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
                com.tencent.mm.plugin.voip.a.a.flushLogFile();
            } else {
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
            }
        }
        cIj = com.tencent.mm.plugin.voip.b.cIj();
        cIj.sSQ = null;
        cIj.sSY = null;
        cIj.sSZ = false;
        cIj.sTe = false;
        if (this.sRi) {
            this.sRh = new a();
            d.post(this.sRh, "VoipMgr_clean");
        } else {
            cJH();
        }
        if (!(this.nva == null || this.nvb == null)) {
            this.nva.listen(this.nvb, 0);
            this.nvb = null;
        }
        if (this.sRd != null) {
            this.sRd.fa(ah.getContext());
        }
        this.nva = null;
        com.tencent.mm.booter.a.Ib().Ic();
        p.cJR().cJT();
        p.cJR().a(null);
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        if (this.mfW != null) {
            ab.d("MicroMsg.Voip.VoipMgr", "removeSensorCallBack");
            this.mfW.dps();
            this.mfW = null;
            this.sRQ = false;
            this.sRR = 0;
            this.sRP = -1;
        }
        this.sRS = -1;
        com.tencent.mm.plugin.voip.b.cIj().cKe();
        ab.i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", Boolean.valueOf(this.sRj));
        if (this.sRj) {
            Object obj;
            VoipScoreState voipScoreState = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPB;
            com.tencent.mm.kernel.g.RQ();
            long longValue = ((Long) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_VOIP_LAST_SCORE_TIME_LONG, Long.valueOf(-1))).longValue();
            voipScoreState.sSO = longValue > 0 ? longValue : 0;
            ab.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", Long.valueOf(bf.aaa()), Long.valueOf(longValue), Integer.valueOf(voipScoreState.sSN));
            if (bo.isNullOrNil(voipScoreState.sSM) || voipScoreState.sSN <= 0 || (longValue > 0 && r0 - longValue <= ((long) voipScoreState.sSN) * 86400000)) {
                obj = null;
            } else {
                ab.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
                obj = 1;
            }
            if (obj != null) {
                com.tencent.mm.plugin.voip.b.cIj();
                VoipScoreState.cJX();
                Intent intent = new Intent(getContext(), VoipScoreDialog.class);
                intent.putExtra("key_score_state", com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPB);
                if (!(getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                getContext().startActivity(intent);
            }
        }
        com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPB = new VoipScoreState();
        ui uiVar = new ui();
        uiVar.cQx.cAd = 11;
        com.tencent.mm.sdk.b.a.xxA.m(uiVar);
        if (!this.sRV) {
            com.tencent.mm.plugin.voip.a.a.c(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu, com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv, this.sRm ? 0 : 1, 4);
            this.sRV = true;
        }
        this.sRX = null;
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        AppMethodBeat.o(4521);
    }

    public final void cJA() {
        AppMethodBeat.i(4522);
        ab.i("MicroMsg.Voip.VoipMgr", "onNoResp");
        oE(4105);
        q.a(this.sRl.field_username, this.sRn ? bi.xZc : bi.xZb, this.sRm ? 1 : 0, 4, ah.getContext().getString(R.string.f4c));
        h.pYm.a(11518, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv), Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIK()), Integer.valueOf(6), Integer.valueOf(at.getNetWorkType(getContext())));
        cJz();
        AppMethodBeat.o(4522);
    }

    public final void onConnected() {
        AppMethodBeat.i(4523);
        oE(4102);
        this.sRs = bo.anT();
        if (this.sRe != null) {
            this.sRe.setConnectSec(this.sRs);
        }
        boolean cIM = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIM();
        boolean cIL = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIL();
        if (this.sRn && this.sRm && !cIL && !cIM) {
            com.tencent.mm.plugin.voip.b.cIj().Gh(1);
        }
        if (!com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState)) {
            h.pYm.e(11080, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
        }
        bo.z(ah.getContext(), true);
        r cIj = com.tencent.mm.plugin.voip.b.cIj();
        int i = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.sUk;
        s sVar = cIj.sSP;
        sVar.bJj = null;
        sVar.sTq = null;
        sVar.sTo = 0;
        if (i > 0) {
            s.sTm = i;
        }
        sVar.bJj = (WifiManager) ah.getContext().getApplicationContext().getSystemService("wifi");
        sVar.sTp = new Timer();
        sVar.sTp.schedule(new TimerTask() {
            public final void run() {
                int i = 10;
                AppMethodBeat.i(4648);
                if (s.this.bJj != null) {
                    s.this.sTq = s.this.bJj.getConnectionInfo();
                }
                if (s.this.sTq == null || s.this.sTq.getBSSID() == null || s.this.bJj == null) {
                    s.hGc = -1;
                } else {
                    s.this.bJj;
                    s.hGc = WifiManager.calculateSignalLevel(s.this.sTq.getRssi(), 10);
                    if (s.hGc <= 10) {
                        i = s.hGc;
                    }
                    s.hGc = i;
                    s.hGc = s.hGc < 0 ? 0 : s.hGc;
                    s.hGc = s.hGc * 10;
                }
                if (s.hGc == -1) {
                    if (s.this.sTo <= 1) {
                        s.sTl = -1;
                    }
                    s.this.setNetSignalValue(1, s.sTl);
                    AppMethodBeat.o(4648);
                    return;
                }
                s.this.setNetSignalValue(2, s.hGc);
                AppMethodBeat.o(4648);
            }
        }, 0, (long) (s.sTm * 1000));
        TelephonyManager telephonyManager = (TelephonyManager) ah.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(new com.tencent.mm.plugin.voip.model.s.AnonymousClass5(telephonyManager), 256);
        }
        p.cJR().cJS();
        p.cJR().a(this);
        AppMethodBeat.o(4523);
    }

    public final void cJB() {
        int i = 0;
        AppMethodBeat.i(4524);
        h hVar = h.pYm;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu);
        objArr[1] = Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv);
        objArr[2] = Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIK());
        objArr[3] = Integer.valueOf(this.sRm ? 0 : 1);
        objArr[4] = Integer.valueOf(1);
        hVar.a(11522, true, true, objArr);
        int i2 = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu;
        long j = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv;
        if (!this.sRm) {
            i = 1;
        }
        com.tencent.mm.plugin.voip.a.a.c(i2, j, i, 3);
        this.sSe.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4458);
                VoipMgr.c(VoipMgr.this, VoipMgr.this.sRZ);
                VoipMgr.this.sSe.postDelayed(this, 5000);
                AppMethodBeat.o(4458);
            }
        });
        AppMethodBeat.o(4524);
    }

    public final void cJC() {
        String string;
        int i = 0;
        AppMethodBeat.i(4525);
        ab.i("MicroMsg.Voip.VoipMgr", "onShutDown");
        if (com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState)) {
            string = ah.getContext().getString(R.string.f47, new Object[]{fQ(bo.fp(this.sRs))});
        } else {
            string = ah.getContext().getString(R.string.f43);
        }
        if (this.sRm || com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState)) {
            q.a(this.sRl.field_username, this.sRn ? bi.xZc : bi.xZb, this.sRm ? 1 : 0, 6, string);
        }
        if (this.sRn) {
            com.tencent.mm.plugin.voip.b.cIj().Gx(0);
        } else {
            com.tencent.mm.plugin.voip.b.cIj().Gx(1);
        }
        this.sRj = com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState);
        if (cJJ()) {
            this.sRp = 4106;
        } else {
            oE(4106);
            cJz();
        }
        com.tencent.mm.plugin.voip.b.cIj().cKe();
        if (!this.sRV) {
            int i2 = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu;
            long j = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv;
            if (!this.sRm) {
                i = 1;
            }
            com.tencent.mm.plugin.voip.a.a.c(i2, j, i, 4);
            this.sRV = true;
        }
        AppMethodBeat.o(4525);
    }

    public final void Gt(int i) {
        AppMethodBeat.i(4526);
        ab.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", Integer.valueOf(i));
        if (1 == i || 3 == i || 5 == i || 6 == i || 7 == i) {
            oE(4101);
            com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIP();
            com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.cIQ();
        }
        AppMethodBeat.o(4526);
    }

    public final void b(int i, int i2, int[] iArr) {
        AppMethodBeat.i(4527);
        if (this.sRe != null) {
            this.sRe.c(i, i2, iArr);
        }
        AppMethodBeat.o(4527);
    }

    public final void cJD() {
        AppMethodBeat.i(4528);
        if (this.sRe != null) {
            this.sRe.cJD();
        }
        AppMethodBeat.o(4528);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.i(4529);
        ab.i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + i + "，mVoipUI: " + this.sRe);
        if (this.sRe != null) {
            this.sRe.setVoipBeauty(i);
        }
        if (!(i == 0 || this.sRO == i)) {
            h.pYm.k(914, 20, 1);
        }
        this.sRO = i;
        AppMethodBeat.o(4529);
    }

    public final void setHWDecMode(int i) {
        AppMethodBeat.i(4530);
        this.sRN = i;
        if (this.sRe != null) {
            this.sRe.setHWDecMode(i);
        }
        AppMethodBeat.o(4530);
    }

    public final void Gu(int i) {
        boolean z = false;
        AppMethodBeat.i(4531);
        ab.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(i)));
        if (this.sRc.GQ(4110)) {
            r cIj = com.tencent.mm.plugin.voip.b.cIj();
            boolean z2 = i == 1;
            if (i == 1) {
                z = true;
            }
            cIj.R(z2, z);
            com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
            if (i == 1 && com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState)) {
                oE(4101);
            }
            oE(4110);
            AppMethodBeat.o(4531);
            return;
        }
        AppMethodBeat.o(4531);
    }

    public final void cJE() {
        boolean z = false;
        AppMethodBeat.i(4532);
        ab.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
        if (com.tencent.mm.compatible.b.g.KK().KV() || com.tencent.mm.compatible.b.g.KK().KP()) {
            mr(false);
        } else {
            boolean z2;
            if (1 == this.sRr) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!this.sRJ) {
                if (this.sRn) {
                    z = true;
                } else {
                    z = z2;
                }
            }
            mr(z);
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4459);
                    VoipMgr.t(VoipMgr.this);
                    AppMethodBeat.o(4459);
                }
            });
            AppMethodBeat.o(4532);
            return;
        }
        cJF();
        AppMethodBeat.o(4532);
    }

    private void cJF() {
        AppMethodBeat.i(4533);
        if (!(!com.tencent.mm.compatible.util.d.iW(28) || !this.sRn || this.sRf == null || this.sRf.bPu() || this.sRe == null)) {
            ab.i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", Integer.valueOf(VERSION.SDK_INT));
            this.sRf.cLD();
            this.sRe.cKT();
            int i = 320;
            int i2 = 240;
            if (this.sRf == null && com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState)) {
                this.sRg = new CaptureView(ah.getContext());
                if (v2protocal.sTV) {
                    ab.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
                    i = 640;
                    i2 = 480;
                }
            }
            this.sRf = new com.tencent.mm.plugin.voip.video.a(i, i2);
            this.sRf.a((g) this, true);
            this.sRf.a(this.sRg);
            this.sRf.cLC();
        }
        AppMethodBeat.o(4533);
    }

    public final long cJG() {
        AppMethodBeat.i(4534);
        ab.c("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", Long.valueOf(this.sRR));
        long j = this.sRR / 1000;
        AppMethodBeat.o(4534);
        return j;
    }

    private static String fQ(long j) {
        AppMethodBeat.i(4535);
        String format = String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
        AppMethodBeat.o(4535);
        return format;
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(4536);
        if (this.sRw) {
            AppMethodBeat.o(4536);
        } else if (this.sRf == null) {
            ab.e("MicroMsg.Voip.VoipMgr", "onFrameDataReady, captureRender is null!");
            AppMethodBeat.o(4536);
        } else {
            int i5;
            int i6 = this.sRf.cLE() ? OpenGlRender.FLAG_Mirror : 0;
            if (this.sRf.cLF()) {
                i5 = OpenGlRender.FLAG_Angle270;
            } else {
                i5 = OpenGlRender.FLAG_Angle90;
            }
            if (this.sRe != null) {
                int i7 = i3 + i4;
                byte[] bArr2 = null;
                if (this.sRf.cLE()) {
                    if (OpenGlRender.getGLVersion() != 1 && this.sRe.cKU() != null && this.sRe.cKU().length == (i * i2) * 4) {
                        bArr2 = this.sRe.cKU();
                        i7 = 4;
                        this.sRX = bArr2;
                    } else if (OpenGlRender.getGLVersion() != 2 || this.sRX == null || this.sRO == 0) {
                        i7 = i3 + i4;
                        bArr2 = bArr;
                    } else {
                        bArr2 = this.sRX;
                        i7 = 4;
                    }
                }
                if (bArr2 == null) {
                    i7 = i3 + i4;
                    bArr2 = bArr;
                }
                this.sRe.a(bArr, j, i, i2, i3 + i4, i6, i5, com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPr.b(bArr2, bArr2.length, i7, i, i2));
            }
            this.sRD = i6 == OpenGlRender.FLAG_Mirror;
            this.sRE = i5 == OpenGlRender.FLAG_Angle270 ? 270 : 90;
            k kVar = this.sRz;
            kVar.tbA = i2;
            kVar.tbz = i;
            AppMethodBeat.o(4536);
        }
    }

    private void cJH() {
        AppMethodBeat.i(4537);
        synchronized (this.sRk) {
            try {
                com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
                cJI();
                com.tencent.mm.compatible.b.g.KK().setMode(0);
                if (this.cqx != null) {
                    this.cqx.Mm();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(4537);
            }
        }
    }

    private void cJI() {
        AppMethodBeat.i(4538);
        ab.b("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
        if (this.sRf != null) {
            cJO();
            try {
                this.sRf.cLD();
            } catch (Exception e) {
                ab.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + e.toString());
            }
            this.sRf = null;
        }
        AppMethodBeat.o(4538);
    }

    public final void ig(boolean z) {
        int i = 2;
        AppMethodBeat.i(4539);
        ab.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
        if (this.sRe != null) {
            this.sRe.my(z);
        }
        if (!(com.tencent.mm.plugin.voip.a.b.GO(this.sRc.mState) || this.sRv)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.nxl > 30000) {
                this.nxl = currentTimeMillis;
                com.tencent.mm.plugin.voip.b.cIj().sSP.cKp();
            }
        }
        ab.i("MicroMsg.Voip.VoipMgr", "report the bad net toast room key is " + com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv + "and in the side" + (z ? 1 : 2));
        h hVar = h.pYm;
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwv);
        if (z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        hVar.a(17151, true, true, objArr);
        AppMethodBeat.o(4539);
    }

    public final void bGR() {
        AppMethodBeat.i(4540);
        ab.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
        if (this.sRe != null) {
            this.sRe.bIK();
        }
        AppMethodBeat.o(4540);
    }

    private boolean cJJ() {
        AppMethodBeat.i(4541);
        if (com.tencent.mm.plugin.voip.a.b.GN(this.sRc.mState)) {
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
            if (!sharedPreferences.getBoolean("voip_shortcut_has_added", false)) {
                boolean e = e(sharedPreferences);
                AppMethodBeat.o(4541);
                return e;
            }
        }
        AppMethodBeat.o(4541);
        return false;
    }

    private boolean e(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(4542);
        String value = com.tencent.mm.m.g.Nu().getValue("VOIPShortcutAutoadd");
        ab.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", value);
        if (value != null && value.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && bo.fp(this.sRs) > 30) {
            int i = sharedPreferences.getInt("voip_shortcut_prompt_times", 0);
            boolean z = sharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
            if (i < 3 && !z) {
                cJK();
                sharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
                AppMethodBeat.o(4542);
                return true;
            }
        } else if (value != null && value.equals("1") && bo.fp(this.sRs) > 15) {
            f(sharedPreferences);
            AppMethodBeat.o(4542);
            return false;
        }
        AppMethodBeat.o(4542);
        return false;
    }

    private void f(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(4543);
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent2.addFlags(67108864);
        if (1 == bo.getInt(com.tencent.mm.m.g.Nu().getValue("VOIPCallType"), 0)) {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(R.string.qh));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), R.drawable.aa3));
            intent.putExtra("shortcut_icon_resource_id", R.drawable.aa3);
        } else {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(R.string.qj));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), R.drawable.aa4));
            intent.putExtra("shortcut_icon_resource_id", R.drawable.aa4);
        }
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        com.tencent.mm.plugin.base.model.b.r(getContext(), intent);
        sharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
        AppMethodBeat.o(4543);
    }

    /* Access modifiers changed, original: final */
    public final Context getContext() {
        AppMethodBeat.i(4544);
        Context context = null;
        if (this.sRe != null) {
            context = this.sRe.cKS();
        }
        if (context == null) {
            context = ah.getContext();
        }
        AppMethodBeat.o(4544);
        return context;
    }

    private void cJK() {
        AppMethodBeat.i(4545);
        Context context = getContext();
        View inflate = View.inflate(context, R.layout.ad4, null);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.d8o);
        checkBox.setChecked(false);
        TextView textView = (TextView) inflate.findViewById(R.id.d8n);
        if (1 == bo.getInt(com.tencent.mm.m.g.Nu().getValue("VOIPCallType"), 0)) {
            textView.setText(R.string.f3q);
        } else {
            textView.setText(R.string.f3r);
        }
        com.tencent.mm.ui.base.h.a(context, false, context.getString(R.string.tz), inflate, context.getString(R.string.up), context.getString(R.string.s2), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(4463);
                VoipMgr.a(VoipMgr.this, VoipMgr.g(VoipMgr.this).getSharedPreferences("voip_plugin_prefs", 0));
                if (4096 != VoipMgr.this.sRp) {
                    VoipMgr.f(VoipMgr.this, VoipMgr.this.sRp);
                    VoipMgr.this.sRp = 4096;
                }
                if (VoipMgr.this.iGP != null) {
                    VoipMgr.this.iGP.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(4462);
                            VoipMgr.r(VoipMgr.this);
                            AppMethodBeat.o(4462);
                        }
                    });
                }
                AppMethodBeat.o(4463);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(4465);
                if (checkBox != null) {
                    VoipMgr.g(VoipMgr.this).getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", checkBox.isChecked()).commit();
                }
                if (4096 != VoipMgr.this.sRp) {
                    VoipMgr.f(VoipMgr.this, VoipMgr.this.sRp);
                    VoipMgr.this.sRp = 4096;
                }
                if (VoipMgr.this.iGP != null) {
                    VoipMgr.this.iGP.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(4464);
                            VoipMgr.r(VoipMgr.this);
                            AppMethodBeat.o(4464);
                        }
                    });
                }
                AppMethodBeat.o(4465);
            }
        });
        AppMethodBeat.o(4545);
    }

    public final boolean mv(final boolean z) {
        AppMethodBeat.i(4546);
        if (!this.sRI || z) {
            ab.b("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", Boolean.valueOf(z));
            ab.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
            if (this.sRe != null) {
                this.sRe.uninit();
                this.sRe = null;
            }
            if (this.iGP != null) {
                this.iGP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(4466);
                        VoipMgr.f(VoipMgr.this, z);
                        AppMethodBeat.o(4466);
                    }
                });
            }
            AppMethodBeat.o(4546);
            return true;
        }
        ab.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
        AppMethodBeat.o(4546);
        return false;
    }

    public final void cJL() {
        AppMethodBeat.i(4547);
        if (256 != this.sRc.mState && com.tencent.view.d.MIC_PTU_ZIPAI_TOKYO != this.sRc.mState) {
            AppMethodBeat.o(4547);
        } else if (com.tencent.mm.kernel.g.RP().Ry().getInt(327945, 0) != 0 || this.sRe.cKS() == null) {
            com.tencent.mm.plugin.voip.a.d.fh(ah.getContext());
            cJN();
            AppMethodBeat.o(4547);
        } else {
            com.tencent.mm.kernel.g.RP().Ry().setInt(327945, 1);
            com.tencent.mm.ui.widget.a.c a = com.tencent.mm.ui.base.h.a(this.sRe.cKS(), (int) R.string.f5u, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(4467);
                    VoipMgr.this.cJN();
                    AppMethodBeat.o(4467);
                }
            });
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
            AppMethodBeat.o(4547);
        }
    }

    public final void cJM() {
        AppMethodBeat.i(4548);
        this.sRC = !this.sRC;
        if (this.sRC) {
            this.sRA.stopTimer();
            AppMethodBeat.o(4548);
            return;
        }
        if (this.sRA == null) {
            this.sRB = new al("faceDetect");
            this.sRA = new ap(this.sRB.oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(4469);
                    VoipMgr.H(VoipMgr.this);
                    AppMethodBeat.o(4469);
                    return true;
                }
            }, true);
        }
        this.sRA.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        this.sRC = false;
        AppMethodBeat.o(4548);
    }

    public final void cJN() {
        AppMethodBeat.i(4549);
        com.tencent.mm.plugin.voip.b.cIj().sSV = com.tencent.mm.plugin.voip.b.cIj().sSP.sNl.sPp.nwu;
        q.a(this.sRl.field_username, this.sRn ? bi.xZc : bi.xZb, this.sRm ? 1 : 0, 6, ah.getContext().getString(R.string.f49));
        com.tencent.mm.plugin.voip.b.cIj().sSP.stopRing();
        oE(4108);
        if (this.iGP != null) {
            this.iGP.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4468);
                    VoipMgr.G(VoipMgr.this);
                    AppMethodBeat.o(4468);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(4549);
    }

    public final void bSo() {
        AppMethodBeat.i(4550);
        if (true == this.oue || this.sRe == null || this.sRe.cKS() == null) {
            ab.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
            AppMethodBeat.o(4550);
        } else if (this.sRf.bPu()) {
            AppMethodBeat.o(4550);
        } else if (Build.MANUFACTURER.equalsIgnoreCase("meizu") && !com.tencent.mm.compatible.f.b.Mj()) {
            ab.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
            AppMethodBeat.o(4550);
        } else if (com.tencent.mm.compatible.util.d.iW(28) && ((KeyguardManager) ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            ab.i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.o(4550);
        } else {
            ab.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
            h hVar = h.pYm;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.sRn ? 0 : 1);
            objArr[1] = Integer.valueOf(0);
            hVar.e(11306, objArr);
            com.tencent.mm.ui.widget.a.c g = com.tencent.mm.ui.base.h.g(this.sRe.cKS(), R.string.f6d, R.string.tz);
            if (g == null) {
                ab.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
                AppMethodBeat.o(4550);
                return;
            }
            g.setCancelable(false);
            g.setCanceledOnTouchOutside(false);
            g.show();
            this.oue = true;
            AppMethodBeat.o(4550);
        }
    }

    private void cJO() {
        AppMethodBeat.i(4551);
        if (this.sRz != null) {
            this.sRz.a(this);
        }
        if (this.sRA != null) {
            ab.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
            this.sRA.stopTimer();
        }
        if (!(this.sRB == null || this.sRB.oAl.getLooper() == null)) {
            ab.d("MicroMsg.Voip.VoipMgr", "quit face detect thread");
            this.sRB.oAl.getLooper().quit();
        }
        AppMethodBeat.o(4551);
    }

    public final void a(final int[] iArr, final boolean z, final int i) {
        AppMethodBeat.i(4552);
        if (!this.sRY && this.sRn) {
            mt(true);
            this.sRY = true;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(4470);
                if (VoipMgr.this.sRf != null) {
                    VoipMgr.this.sRf.y(iArr);
                }
                if (VoipMgr.this.sRe != null) {
                    VoipMgr.this.sRe;
                }
                AppMethodBeat.o(4470);
            }
        });
        AppMethodBeat.o(4552);
    }

    static /* synthetic */ void r(VoipMgr voipMgr) {
        AppMethodBeat.i(4557);
        voipMgr.mu(false);
        AppMethodBeat.o(4557);
    }

    static /* synthetic */ void H(VoipMgr voipMgr) {
        AppMethodBeat.i(4566);
        if (com.tencent.mm.plugin.voip.a.b.GN(voipMgr.sRc.mState)) {
            voipMgr.sRz.tby = voipMgr.sRD;
            voipMgr.sRz.mRotateAngle = voipMgr.sRE;
            k kVar = voipMgr.sRz;
            int[] iArr = new int[2];
            if (voipMgr.sRF) {
                iArr[0] = 1;
                iArr[1] = 0;
            } else {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.asIntBuffer().put(iArr);
            byte[] array = allocate.array();
            if (kVar.sSz.setAppCmd(13, array, array.length) >= 0) {
                int length = (array.length % 4 == 0 ? 0 : 1) + (array.length / 4);
                ByteBuffer allocate2 = ByteBuffer.allocate(length * 4);
                allocate2.put(array);
                allocate2.order(ByteOrder.nativeOrder());
                allocate2.rewind();
                int[] iArr2 = new int[length];
                allocate2.asIntBuffer().get(iArr2);
                int i = iArr2[0];
                length = iArr2[1];
                if (i + length != 0) {
                    k.b bVar = new k.b();
                    bVar = new k.b();
                    bVar.tbB = i & CdnLogic.kBizGeneric;
                    bVar.tbC = (i >> 16) & CdnLogic.kBizGeneric;
                    bVar.tbD = length & CdnLogic.kBizGeneric;
                    bVar.tbE = (length >> 16) & CdnLogic.kBizGeneric;
                    ab.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", bVar);
                    Iterator it = kVar.jFO.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.plugin.voip.video.k.a) it.next()).a(new int[]{bVar.tbB, bVar.tbC, bVar.tbD, bVar.tbE}, kVar.tby, kVar.mRotateAngle);
                    }
                    AppMethodBeat.o(4566);
                    return;
                }
                Iterator it2 = kVar.jFO.iterator();
                while (it2.hasNext()) {
                    ((com.tencent.mm.plugin.voip.video.k.a) it2.next()).a(null, kVar.tby, kVar.mRotateAngle);
                }
            }
        }
        AppMethodBeat.o(4566);
    }
}
