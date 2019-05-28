package com.tencent.p177mm.plugin.voip.widget;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.support.p057v4.app.C0363v.C0358c;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.model.C14058r;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p1417a.C40025b;
import com.tencent.p177mm.plugin.voip.p546ui.C14084a;
import com.tencent.p177mm.plugin.voip.p546ui.C14085b;
import com.tencent.p177mm.plugin.voip.p546ui.C46324c;
import com.tencent.p177mm.plugin.voip.p546ui.C46928e;
import com.tencent.p177mm.plugin.voip.p546ui.VideoActivity;
import com.tencent.p177mm.plugin.voip.video.CaptureView;
import com.tencent.p177mm.plugin.voip.video.p1045a.C29511d;
import com.tencent.p177mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.p177mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.C30091a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.voip.widget.b */
public final class C22480b implements ServiceConnection, C14085b {
    private byte[] buffer;
    private int mStatus = -1;
    private boolean oGw = false;
    private int sRO = 0;
    private CaptureView sRg;
    private C7616ad sRl;
    private boolean sRm;
    private boolean sRn;
    private int sRr = 1;
    private long sRs = -1;
    private boolean sTb = false;
    private int sXS;
    private C7564ap sZa;
    private C7564ap tcA;
    private C46324c tct;
    private BaseSmallView tcu;
    private C7564ap tcv;
    private WakeLock tcw;
    private long tcx = -1;
    private boolean tcy = false;
    private OnClickListener tcz = new C224781();
    private boolean umx = false;

    /* renamed from: com.tencent.mm.plugin.voip.widget.b$7 */
    class C140927 implements C29511d {
        C140927() {
        }

        /* renamed from: bu */
        public final void mo26429bu(byte[] bArr) {
            AppMethodBeat.m2504i(5179);
            if (bArr != null) {
                C22480b.this.buffer = bArr;
            }
            AppMethodBeat.m2505o(5179);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.widget.b$1 */
    class C224781 implements OnClickListener {
        C224781() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(5171);
            if (C22480b.this.tcu != null) {
                C22480b.this.tcu.setOnClickListener(null);
            }
            C22480b.m34167b(C22480b.this);
            Intent intent = new Intent(C4996ah.getContext(), VideoActivity.class);
            intent.setFlags(268435456);
            try {
                PendingIntent.getActivity(C4996ah.getContext(), 0, intent, 0).send();
                AppMethodBeat.m2505o(5171);
            } catch (CanceledException e) {
                C4990ab.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", e, "send pending intent error: %s", e.getMessage());
                AppMethodBeat.m2505o(5171);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.widget.b$2 */
    class C224792 implements C30091a {
        C224792() {
        }

        /* renamed from: a */
        public final void mo38035a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.m2504i(5172);
            requestFloatWindowPermissionDialog.finish();
            String string = C4996ah.getContext().getString(C25738R.string.f7b);
            C22480b.this.mo38038g(string, C1854s.m3866mJ(C22480b.this.sRl.field_username), string, false);
            if (C40025b.m68550GP(C22480b.this.mStatus) || C40025b.m68548GN(C22480b.this.mStatus)) {
                C22480b.m34170e(C22480b.this);
                AppMethodBeat.m2505o(5172);
                return;
            }
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
            C22480b.m34167b(C22480b.this);
            AppMethodBeat.m2505o(5172);
        }

        /* renamed from: b */
        public final void mo38036b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.m2504i(5173);
            requestFloatWindowPermissionDialog.finish();
            AppMethodBeat.m2505o(5173);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.widget.b$3 */
    class C224813 implements C5015a {
        C224813() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(5174);
            C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + C22480b.this.mStatus);
            if (C22480b.this.mStatus == 8 || C22480b.this.mStatus == C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM || !C29488d.cLx()) {
                ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
                C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking...CALLING_STATE_FINISH state..cancel notification..");
                if (!(C22480b.this.tcv == null || C22480b.this.tcv.doT())) {
                    C22480b.this.tcv.stopTimer();
                }
                AppMethodBeat.m2505o(5174);
                return false;
            }
            C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "show voice talking, first timer trigger..");
            String g = C22480b.m34172g(C22480b.this);
            C22480b.this.mo38038g(g, C1854s.m3866mJ(C22480b.this.sRl.field_username), g, false);
            AppMethodBeat.m2505o(5174);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.widget.b$4 */
    class C224824 implements C5015a {
        C224824() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(5175);
            C43727b.cIk().abZ(C22480b.this.cLW());
            AppMethodBeat.m2505o(5175);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.widget.b$5 */
    class C224835 implements C14084a {
        C224835() {
        }

        public final boolean bGV() {
            AppMethodBeat.m2504i(5176);
            if (C40025b.m68550GP(C22480b.this.mStatus) || C40025b.m68548GN(C22480b.this.mStatus)) {
                AppMethodBeat.m2505o(5176);
                return true;
            }
            AppMethodBeat.m2505o(5176);
            return false;
        }

        /* renamed from: a */
        public final void mo24609a(Intent intent, C46928e c46928e) {
            AppMethodBeat.m2504i(5177);
            if (intent.getBooleanExtra("Voip_Is_Talking", false)) {
                c46928e.abZ(C22480b.this.cLW());
                AppMethodBeat.m2505o(5177);
                return;
            }
            c46928e.abZ(C4996ah.getContext().getString(C25738R.string.f66));
            AppMethodBeat.m2505o(5177);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m34167b(C22480b c22480b) {
        AppMethodBeat.m2504i(5210);
        c22480b.m34175mF(false);
        AppMethodBeat.m2505o(5210);
    }

    /* renamed from: e */
    static /* synthetic */ void m34170e(C22480b c22480b) {
        AppMethodBeat.m2504i(5211);
        c22480b.cLU();
        AppMethodBeat.m2505o(5211);
    }

    public C22480b(C46324c c46324c, int i, C7616ad c7616ad, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(5180);
        C4990ab.m7417i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", C40025b.m68545GK(i), c7616ad.field_username, Boolean.valueOf(z));
        this.sRl = c7616ad;
        this.tct = c46324c;
        this.sRn = z;
        this.sRm = z2;
        this.sTb = z3;
        mo26399fY(0, i);
        this.tcw = ((PowerManager) C4996ah.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
        this.tcw.acquire();
        AppMethodBeat.m2505o(5180);
    }

    /* renamed from: GC */
    public final void mo26389GC(int i) {
    }

    public final void setMute(boolean z) {
    }

    /* renamed from: fY */
    public final void mo26399fY(int i, int i2) {
        AppMethodBeat.m2504i(5181);
        C4990ab.m7417i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", C40025b.m68545GK(i2));
        if (i2 == this.mStatus) {
            C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
            AppMethodBeat.m2505o(5181);
            return;
        }
        this.mStatus = i2;
        switch (i2) {
            case 0:
            case 2:
            case 4:
                cMa();
                AppMethodBeat.m2505o(5181);
                return;
            case 1:
            case 3:
            case 5:
            case C31128d.MIC_PTU_ZIPAI_TOKYO /*257*/:
            case C31128d.MIC_PTU_ZIPAI_MEDSEA /*259*/:
                cLV();
                AppMethodBeat.m2505o(5181);
                return;
            case 6:
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW /*260*/:
                cLh();
                AppMethodBeat.m2505o(5181);
                return;
            case 7:
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW /*261*/:
                m34164GU(i);
                break;
            case 8:
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                m34162GS(i);
                AppMethodBeat.m2505o(5181);
                return;
            case 256:
            case C31128d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                cLZ();
                AppMethodBeat.m2505o(5181);
                return;
        }
        AppMethodBeat.m2505o(5181);
    }

    /* renamed from: GS */
    private void m34162GS(int i) {
        int i2;
        AppMethodBeat.m2504i(5182);
        switch (i) {
            case 4099:
                if (!this.sRn) {
                    i2 = C25738R.string.f3t;
                    break;
                } else {
                    i2 = C25738R.string.f7a;
                    break;
                }
            case 4105:
                i2 = C25738R.string.f6e;
                break;
            case 4106:
                i2 = C25738R.string.f6z;
                break;
            default:
                m34175mF(true);
                AppMethodBeat.m2505o(5182);
        }
        C22480b.m34163GT(i2);
        m34175mF(true);
        AppMethodBeat.m2505o(5182);
    }

    /* renamed from: GT */
    private static void m34163GT(int i) {
        AppMethodBeat.m2504i(5183);
        Context context = C4996ah.getContext();
        Toast.makeText(context, context.getString(i), 1).show();
        AppMethodBeat.m2505o(5183);
    }

    private void cLh() {
        AppMethodBeat.m2504i(5184);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
        this.tcy = true;
        if (-1 == this.tcx) {
            this.tcx = System.currentTimeMillis();
        }
        if (this.tct != null) {
            this.tct.mo30879a(this, 2);
        }
        if (C37657b.m63684bF(C4996ah.getContext())) {
            cLU();
        } else {
            C4990ab.m7412e("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking, permission denied");
            RequestFloatWindowPermissionDialog.m58702a(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.f5n), new C224792());
            if (!C43727b.cIj().sSZ) {
                C43727b.cIj().sSZ = true;
                if (System.currentTimeMillis() - C1720g.m3536RP().mo5239Ry().mo16813Mm(327950) > 86400000) {
                    C22480b.m34176pg("have not permission to showing floating window\n");
                }
            }
        }
        String string = C4996ah.getContext().getString(C25738R.string.f7b);
        mo38038g(string, C1854s.m3866mJ(this.sRl.field_username), string, false);
        if (!(this.tcv == null || this.tcv.doT())) {
            this.tcv.stopTimer();
        }
        AppMethodBeat.m2505o(5184);
    }

    private void cLU() {
        AppMethodBeat.m2504i(5185);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "show mini..");
        m34175mF(false);
        Context context = C4996ah.getContext();
        C43727b.cIj();
        this.tcu = new C43742a(context, C14058r.m22231mw(false));
        this.tcu.setConnectSec(this.sRs);
        this.tcu.setVoipUIListener(this.tct);
        context = C4996ah.getContext();
        C43727b.cIj();
        int height = (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight() / 5) + C4977b.m7371b(context, 7.0f);
        int b = (int) (((float) C4977b.m7371b(context, 7.0f)) + (C14058r.m22231mw(true) * ((float) height)));
        this.tcu.mo69440dY(b, height);
        this.tcu.setOnClickListener(this.tcz);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
        m34173g(new Point(b, height));
        C4990ab.m7417i("MicroMsg.Voip.VoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", Integer.valueOf(this.sXS), Integer.valueOf(this.sRO));
        setHWDecMode(this.sXS);
        setVoipBeauty(this.sRO);
        AppMethodBeat.m2505o(5185);
    }

    private void cLV() {
        AppMethodBeat.m2504i(5186);
        if (2 == this.sRr) {
            C22480b.m34163GT(C25738R.string.f3u);
        }
        m34175mF(false);
        String string = C4996ah.getContext().getString(C25738R.string.f7j);
        mo38038g(string, C1854s.m3866mJ(this.sRl.field_username), string, true);
        cLX();
        if (this.tct != null) {
            this.tct.mo30879a(this, 2);
        }
        AppMethodBeat.m2505o(5186);
    }

    /* renamed from: GU */
    private void m34164GU(int i) {
        AppMethodBeat.m2504i(5187);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
        if (-1 == this.tcx) {
            this.tcx = System.currentTimeMillis();
        }
        if (2 == this.sRr) {
            C22480b.m34163GT(C25738R.string.f3u);
        }
        m34175mF(false);
        if (this.tct != null) {
            this.tct.mo30879a(this, 2);
        }
        this.tcv = new C7564ap(new C224813(), true);
        this.tcv.mo16770ae(5000, 5000);
        String cLY = cLY();
        mo38038g(cLY, C1854s.m3866mJ(this.sRl.field_username), cLY, false);
        cLX();
        if (4101 == i) {
            C22480b.m34163GT(C25738R.string.f74);
        }
        AppMethodBeat.m2505o(5187);
    }

    private void acc(String str) {
        AppMethodBeat.m2504i(5188);
        try {
            C4990ab.m7417i("MicroMsg.Voip.VoipSmallWindow", "bindSmallServiceIfNeed isBindSmallService:%s", Boolean.valueOf(this.oGw));
            if (C1443d.m3068iW(26) && !this.oGw) {
                this.oGw = true;
                Intent intent = new Intent();
                intent.putExtra("Voip_User", this.sRl.field_username);
                intent.putExtra("mTickerText", str);
                intent.setClass(C4996ah.getContext(), VoipForegroundService.class);
                C4996ah.getContext().startForegroundService(intent);
            }
            AppMethodBeat.m2505o(5188);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", e, "bindSmallServiceIfNeed error: %s", e.getMessage());
            AppMethodBeat.m2505o(5188);
        }
    }

    public final String cLW() {
        String format;
        AppMethodBeat.m2504i(5189);
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.sRs);
        if (this.sRs == -1) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 3600) {
            format = String.format(Locale.US, "%d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        } else {
            format = String.format(Locale.US, "%d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        if (C5046bo.isNullOrNil(format)) {
            format = "00:00";
        }
        AppMethodBeat.m2505o(5189);
        return format;
    }

    private void cLX() {
        AppMethodBeat.m2504i(5190);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "showMini");
        boolean z = false;
        if (this.mStatus == C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW || this.mStatus == 7) {
            this.tcA = new C7564ap(new C224824(), true);
            this.tcA.mo16770ae(1000, 1000);
            z = true;
        }
        Intent intent = new Intent();
        intent.setClass(C4996ah.getContext(), VideoActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("Voip_User", this.sRl.field_username);
        intent.putExtra("Voip_Outcall", this.sRm);
        intent.putExtra("Voip_VideoCall", this.sRn);
        intent.putExtra("Voip_Is_Talking", z);
        C43727b.cIk().mo63354a(intent, new C224835());
        AppMethodBeat.m2505o(5190);
    }

    private String cLY() {
        String str;
        AppMethodBeat.m2504i(5191);
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.sRs);
        if (this.sRs == -1) {
            currentTimeMillis = 0;
        }
        String string = C4996ah.getContext().getString(C25738R.string.f7j);
        if (currentTimeMillis >= 3600) {
            str = string + String.format(Locale.US, "    %d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        } else {
            str = string + String.format(Locale.US, "    %d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        AppMethodBeat.m2505o(5191);
        return str;
    }

    private void cLZ() {
        AppMethodBeat.m2504i(5192);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "showCalledVideoInviting");
        Integer num = this.tcu == null ? null : (Integer) this.tcu.getTag();
        if (num == null || !(256 == num.intValue() || C31128d.MIC_PTU_ZIPAI_SAPPORO == num.intValue())) {
            String string = C4996ah.getContext().getString(C25738R.string.f7b);
            if (C1854s.m3866mJ(this.sRl.field_username) != null) {
                mo38038g(string, string, C1854s.m3866mJ(this.sRl.field_username), true);
            } else {
                mo38038g(string, string, "", true);
            }
            if (this.tct != null) {
                this.tct.mo30879a(this, 2);
            }
            AppMethodBeat.m2505o(5192);
            return;
        }
        AppMethodBeat.m2505o(5192);
    }

    private void cMa() {
        AppMethodBeat.m2504i(5193);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "showVideoInviting");
        Integer num = this.tcu == null ? null : (Integer) this.tcu.getTag();
        if (num == null || !(num.intValue() == 0 || 2 == num.intValue() || 4 == num.intValue())) {
            String string = C4996ah.getContext().getString(C25738R.string.f7b);
            if (C1854s.m3866mJ(this.sRl.field_username) != null) {
                mo38038g(string, C1854s.m3866mJ(this.sRl.field_username), string, true);
            } else {
                mo38038g(string, string, "", true);
            }
            if (this.tct != null) {
                this.tct.mo30879a(this, 2);
            }
            AppMethodBeat.m2505o(5193);
            return;
        }
        AppMethodBeat.m2505o(5193);
    }

    /* renamed from: g */
    public final void mo38038g(final String str, final String str2, final String str3, boolean z) {
        AppMethodBeat.m2504i(5194);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + str + ",title:" + str2 + ",content:" + str3 + ",breathEffect:" + z);
        C4990ab.m7408b("MicroMsg.Voip.VoipSmallWindow", "breathEffect ".concat(String.valueOf(z)), new Object[0]);
        if (z) {
            this.tcv = new C7564ap(new C5015a() {
                private int mCount = 0;

                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(5178);
                    C4990ab.m7417i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is %s, isUninit:%s", Integer.valueOf(C22480b.this.mStatus), Boolean.valueOf(C22480b.this.umx));
                    this.mCount++;
                    if (C22480b.this.mStatus == 8 || C22480b.this.mStatus == C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM || !C29488d.cLx()) {
                        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "CALLING_STATE_FINISH state..cancel notification..");
                        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
                        if (!(C22480b.this.tcv == null || C22480b.this.tcv.doT())) {
                            C22480b.this.tcv.stopTimer();
                        }
                        AppMethodBeat.m2505o(5178);
                        return false;
                    } else if (C22480b.this.umx) {
                        if (!(C22480b.this.tcv == null || C22480b.this.tcv.doT())) {
                            C22480b.this.tcv.stopTimer();
                        }
                        AppMethodBeat.m2505o(5178);
                        return false;
                    } else {
                        C22480b.this.mo38038g(str + (this.mCount % 2 == 1 ? " " : ""), str2, str3, false);
                        AppMethodBeat.m2505o(5178);
                        return true;
                    }
                }
            }, true);
            this.tcv.mo16770ae(5000, 5000);
        }
        Intent intent = new Intent();
        intent.setClass(C4996ah.getContext(), VideoActivity.class);
        intent.putExtra("Voip_User", this.sRl.field_username);
        intent.putExtra("Voip_Outcall", this.sRm);
        intent.putExtra("Voip_VideoCall", this.sRn);
        PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 40, intent, 134217728);
        acc(str3);
        C0358c e = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(str).mo626j(System.currentTimeMillis()).mo621d(str2).mo623e(str3);
        e.f362EI = activity;
        C0358c as = e.mo616as(C22480b.bWV());
        as.mo627k(2, true);
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41574a(40, C29488d.m46800c(as), false);
        AppMethodBeat.m2505o(5194);
    }

    public static int bWV() {
        if (VERSION.SDK_INT < 19) {
            return C25738R.drawable.bdn;
        }
        return C25738R.drawable.bdo;
    }

    /* renamed from: g */
    private void m34173g(Point point) {
        AppMethodBeat.m2504i(5195);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
        if (C40025b.m68550GP(this.mStatus) || C40025b.m68548GN(this.mStatus)) {
            if (this.tcv != null) {
                this.tcv.stopTimer();
            }
            if (this.tcA != null) {
                this.tcA.stopTimer();
            }
            if (this.sZa != null) {
                this.sZa.stopTimer();
            }
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
            WindowManager windowManager = (WindowManager) C4996ah.getContext().getSystemService("window");
            LayoutParams layoutParams = new LayoutParams();
            if (C1443d.m3068iW(26)) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2002;
            }
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.gravity = 51;
            Context context = C4996ah.getContext();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.width = point.x;
            layoutParams.height = point.y;
            Point point2 = C43727b.cIj().sSY;
            if (point2 == null) {
                int i = C1720g.m3536RP().mo5239Ry().getInt(327947, 0);
                int b = C4977b.m7371b(context, 5.0f);
                layoutParams.x = (displayMetrics.widthPixels - layoutParams.width) - b;
                layoutParams.y = b + i;
            } else {
                layoutParams.x = point2.x;
                layoutParams.y = point2.y;
            }
            if (this.sRg != null) {
                if (this.sRg.getParent() != null && (this.sRg.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.sRg.getParent()).removeView(this.sRg);
                }
                this.tcu.setCaptureView(this.sRg);
            }
            this.tcu.setTag(Integer.valueOf(this.mStatus));
            try {
                windowManager.addView(this.tcu, layoutParams);
                AppMethodBeat.m2505o(5195);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager failed: %s", e.getMessage());
                AppMethodBeat.m2505o(5195);
                return;
            }
        }
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
        AppMethodBeat.m2505o(5195);
    }

    /* renamed from: mF */
    private void m34175mF(boolean z) {
        AppMethodBeat.m2504i(5196);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView");
        if (this.tcv != null) {
            this.tcv.stopTimer();
        }
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "remove small view..cancel notification first..");
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
        if (this.tcu != null) {
            LayoutParams layoutParams = (LayoutParams) this.tcu.getLayoutParams();
            C43727b.cIj().sSY = new Point(layoutParams.x, layoutParams.y);
            this.tcu.uninit();
            try {
                ((WindowManager) C4996ah.getContext().getSystemService("window")).removeView(this.tcu);
            } catch (IllegalArgumentException e) {
                C4990ab.m7413e("MicroMsg.Voip.VoipSmallWindow", "remove failed", e);
            }
            this.tcu = null;
        }
        if (z) {
            C43727b.cIk().abZ(C4996ah.getContext().getString(C25738R.string.f64));
        }
        if (this.tcA != null) {
            this.tcA.stopTimer();
        }
        C43727b.cIk().dismiss();
        AppMethodBeat.m2505o(5196);
    }

    /* renamed from: br */
    public final void mo26393br(int i, String str) {
        int i2;
        AppMethodBeat.m2504i(5197);
        if (i == C31128d.MIC_PTU_QINGCONG) {
            Toast.makeText(C4996ah.getContext(), str, 1).show();
        }
        C4990ab.m7410d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(i)));
        if (i == C31128d.MIC_PTU_AUTOLEVEL) {
            i2 = C25738R.string.f5i;
        } else if (i == C31128d.MIC_PTU_MEISHI) {
            C43727b.cIj().cKb();
            i2 = C25738R.string.f5h;
        } else if (i == C31128d.MIC_PTU_LENGMEIREN) {
            if (!C17950b.ahP() || this.sRn) {
                i2 = C25738R.string.f5j;
            } else {
                i2 = C25738R.string.f5l;
            }
        } else if (i == 236) {
            i2 = C25738R.string.f5w;
        } else if (i == 211) {
            i2 = C25738R.string.f5k;
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            C22480b.m34163GT(C25738R.string.f5g);
            AppMethodBeat.m2505o(5197);
            return;
        }
        C22480b.m34163GT(i2);
        AppMethodBeat.m2505o(5197);
    }

    public final void abY(String str) {
    }

    /* renamed from: c */
    public final void mo26394c(int i, int i2, int[] iArr) {
        AppMethodBeat.m2504i(5198);
        if (C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW == this.mStatus || 6 == this.mStatus) {
            if (this.tcu != null) {
                this.tcu.mo69436c(i, i2, iArr);
            }
            AppMethodBeat.m2505o(5198);
            return;
        }
        AppMethodBeat.m2505o(5198);
    }

    public final void cJD() {
        AppMethodBeat.m2504i(5199);
        if (this.tcu != null) {
            this.tcu.cJD();
        }
        AppMethodBeat.m2505o(5199);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.m2504i(5200);
        if (this.tcu != null) {
            this.tcu.setVoipBeauty(i);
        }
        this.sRO = i;
        AppMethodBeat.m2505o(5200);
    }

    public final void setHWDecMode(int i) {
        AppMethodBeat.m2504i(5201);
        if (this.tcu != null) {
            this.tcu.setHWDecMode(i);
        }
        this.sXS = i;
        AppMethodBeat.m2505o(5201);
    }

    public final void setScreenEnable(boolean z) {
    }

    /* renamed from: a */
    public final void mo26390a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(5202);
        if (C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW == this.mStatus || 6 == this.mStatus) {
            if (this.tcu != null) {
                this.tcu.mo69435a(bArr, j, i, i2, i3, i4, i5);
            }
            AppMethodBeat.m2505o(5202);
            return;
        }
        AppMethodBeat.m2505o(5202);
    }

    public final Context cKS() {
        return null;
    }

    public final void uninit() {
        int i = 3;
        AppMethodBeat.m2504i(5203);
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "uninit");
        if (-1 != this.tcx) {
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[3];
            if (this.tcy) {
                i = 2;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Long.valueOf((System.currentTimeMillis() - this.tcx) / 1000);
            objArr[2] = Integer.valueOf(this.sTb ? 1 : 2);
            c7060h.mo8381e(11620, objArr);
        }
        if (this.tcw != null && this.tcw.isHeld()) {
            C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "release waklock");
            this.tcw.release();
        }
        m34175mF(false);
        this.umx = true;
        if (this.tcv != null) {
            this.tcv.stopTimer();
        }
        if (this.tcA != null) {
            this.tcA.stopTimer();
        }
        C4990ab.m7416i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
        C4990ab.m7408b("MicroMsg.Voip.VoipSmallWindow", "unbindSmallServiceIfNeed, isBindSmallService:%s", Boolean.valueOf(this.oGw));
        try {
            if (C1443d.m3068iW(26) && this.oGw) {
                Intent intent = new Intent();
                intent.setClass(C4996ah.getContext(), VoipForegroundService.class);
                ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(40);
                C4996ah.getContext().stopService(intent);
                this.oGw = false;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", e, "unBind vidoeforeground error: %s", e.getMessage());
        }
        this.sRg = null;
        AppMethodBeat.m2505o(5203);
    }

    public final void setConnectSec(long j) {
        AppMethodBeat.m2504i(5204);
        this.sRs = j;
        if (this.tcu != null) {
            this.tcu.setConnectSec(j);
            AppMethodBeat.m2505o(5204);
            return;
        }
        if (C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW == this.mStatus || 7 == this.mStatus) {
            String cLY = cLY();
            mo38038g(cLY, C1854s.m3866mJ(this.sRl.field_username), cLY, false);
        }
        AppMethodBeat.m2505o(5204);
    }

    /* renamed from: my */
    public final void mo26400my(boolean z) {
        AppMethodBeat.m2504i(5205);
        if (z) {
            Toast.makeText(C4996ah.getContext(), C25738R.string.gaq, 1).show();
            AppMethodBeat.m2505o(5205);
            return;
        }
        Toast.makeText(C4996ah.getContext(), C25738R.string.gap, 1).show();
        AppMethodBeat.m2505o(5205);
    }

    public final void bIK() {
    }

    public final void setCaptureView(CaptureView captureView) {
        AppMethodBeat.m2504i(5206);
        this.sRg = captureView;
        if (!(this.tcu == null || this.sRg == null)) {
            if (this.sRg.getParent() != null && (this.sRg.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.sRg.getParent()).removeView(this.sRg);
            }
            this.tcu.setCaptureView(captureView);
        }
        AppMethodBeat.m2505o(5206);
    }

    public final void cKT() {
    }

    /* renamed from: pg */
    private static void m34176pg(String str) {
        AppMethodBeat.m2504i(5207);
        C1720g.m3536RP().mo5239Ry().setLong(327950, System.currentTimeMillis());
        C4990ab.m7410d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + str.length());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n#client.version=").append(C7243d.vxo).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("#accinfo.revision=").append(C5058f.REV).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("#accinfo.build=").append(C5058f.TIME).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(C5058f.HOSTNAME).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(C5059g.cdf).append(IOUtils.LINE_SEPARATOR_UNIX);
        Date date = new Date();
        stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("#accinfo.content:\n");
        Intent intent = new Intent();
        intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionWriteSdcard", false);
        intent.putExtra("exceptionPid", Process.myPid());
        intent.putExtra("userName", C22480b.m34161Bo());
        intent.putExtra("tag", "float_window_permission");
        intent.putExtra("exceptionMsg", Base64.encodeToString((stringBuilder.toString() + str).getBytes(), 2));
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(5207);
    }

    /* renamed from: Bo */
    private static String m34161Bo() {
        AppMethodBeat.m2504i(5208);
        String T = C6665av.fly.mo5292T("login_weixin_username", "");
        if (C5046bo.isNullOrNil(T)) {
            T = C6665av.fly.mo5292T("login_user_name", "never_login_crash");
        }
        AppMethodBeat.m2505o(5208);
        return T;
    }

    public final byte[] cKU() {
        AppMethodBeat.m2504i(5209);
        if (!(this.tcu == null || this.tcu.getFilterData() == null)) {
            this.tcu.getFilterData().mo63359a(new C140927());
        }
        byte[] bArr = this.buffer;
        AppMethodBeat.m2505o(5209);
        return bArr;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
