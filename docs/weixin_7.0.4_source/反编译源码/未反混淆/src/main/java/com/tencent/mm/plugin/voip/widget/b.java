package com.tencent.mm.plugin.voip.widget;

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
import android.support.v4.app.v;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ad;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b {
    private byte[] buffer;
    private int mStatus = -1;
    private boolean oGw = false;
    private int sRO = 0;
    private CaptureView sRg;
    private ad sRl;
    private boolean sRm;
    private boolean sRn;
    private int sRr = 1;
    private long sRs = -1;
    private boolean sTb = false;
    private int sXS;
    private ap sZa;
    private ap tcA;
    private c tct;
    private BaseSmallView tcu;
    private ap tcv;
    private WakeLock tcw;
    private long tcx = -1;
    private boolean tcy = false;
    private OnClickListener tcz = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(5171);
            if (b.this.tcu != null) {
                b.this.tcu.setOnClickListener(null);
            }
            b.b(b.this);
            Intent intent = new Intent(ah.getContext(), VideoActivity.class);
            intent.setFlags(268435456);
            try {
                PendingIntent.getActivity(ah.getContext(), 0, intent, 0).send();
                AppMethodBeat.o(5171);
            } catch (CanceledException e) {
                ab.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", e, "send pending intent error: %s", e.getMessage());
                AppMethodBeat.o(5171);
            }
        }
    };
    private boolean umx = false;

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(5210);
        bVar.mF(false);
        AppMethodBeat.o(5210);
    }

    static /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(5211);
        bVar.cLU();
        AppMethodBeat.o(5211);
    }

    public b(c cVar, int i, ad adVar, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(5180);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", com.tencent.mm.plugin.voip.a.b.GK(i), adVar.field_username, Boolean.valueOf(z));
        this.sRl = adVar;
        this.tct = cVar;
        this.sRn = z;
        this.sRm = z2;
        this.sTb = z3;
        fY(0, i);
        this.tcw = ((PowerManager) ah.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
        this.tcw.acquire();
        AppMethodBeat.o(5180);
    }

    public final void GC(int i) {
    }

    public final void setMute(boolean z) {
    }

    public final void fY(int i, int i2) {
        AppMethodBeat.i(5181);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", com.tencent.mm.plugin.voip.a.b.GK(i2));
        if (i2 == this.mStatus) {
            ab.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
            AppMethodBeat.o(5181);
            return;
        }
        this.mStatus = i2;
        switch (i2) {
            case 0:
            case 2:
            case 4:
                cMa();
                AppMethodBeat.o(5181);
                return;
            case 1:
            case 3:
            case 5:
            case d.MIC_PTU_ZIPAI_TOKYO /*257*/:
            case d.MIC_PTU_ZIPAI_MEDSEA /*259*/:
                cLV();
                AppMethodBeat.o(5181);
                return;
            case 6:
            case d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW /*260*/:
                cLh();
                AppMethodBeat.o(5181);
                return;
            case 7:
            case d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW /*261*/:
                GU(i);
                break;
            case 8:
            case d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                GS(i);
                AppMethodBeat.o(5181);
                return;
            case 256:
            case d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                cLZ();
                AppMethodBeat.o(5181);
                return;
        }
        AppMethodBeat.o(5181);
    }

    private void GS(int i) {
        int i2;
        AppMethodBeat.i(5182);
        switch (i) {
            case 4099:
                if (!this.sRn) {
                    i2 = R.string.f3t;
                    break;
                } else {
                    i2 = R.string.f7a;
                    break;
                }
            case 4105:
                i2 = R.string.f6e;
                break;
            case 4106:
                i2 = R.string.f6z;
                break;
            default:
                mF(true);
                AppMethodBeat.o(5182);
        }
        GT(i2);
        mF(true);
        AppMethodBeat.o(5182);
    }

    private static void GT(int i) {
        AppMethodBeat.i(5183);
        Context context = ah.getContext();
        Toast.makeText(context, context.getString(i), 1).show();
        AppMethodBeat.o(5183);
    }

    private void cLh() {
        AppMethodBeat.i(5184);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
        this.tcy = true;
        if (-1 == this.tcx) {
            this.tcx = System.currentTimeMillis();
        }
        if (this.tct != null) {
            this.tct.a(this, 2);
        }
        if (com.tencent.mm.compatible.f.b.bF(ah.getContext())) {
            cLU();
        } else {
            ab.e("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking, permission denied");
            RequestFloatWindowPermissionDialog.a(ah.getContext(), ah.getContext().getString(R.string.f5n), new a() {
                public final void a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                    AppMethodBeat.i(5172);
                    requestFloatWindowPermissionDialog.finish();
                    String string = ah.getContext().getString(R.string.f7b);
                    b.this.g(string, s.mJ(b.this.sRl.field_username), string, false);
                    if (com.tencent.mm.plugin.voip.a.b.GP(b.this.mStatus) || com.tencent.mm.plugin.voip.a.b.GN(b.this.mStatus)) {
                        b.e(b.this);
                        AppMethodBeat.o(5172);
                        return;
                    }
                    ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
                    b.b(b.this);
                    AppMethodBeat.o(5172);
                }

                public final void b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                    AppMethodBeat.i(5173);
                    requestFloatWindowPermissionDialog.finish();
                    AppMethodBeat.o(5173);
                }
            });
            if (!com.tencent.mm.plugin.voip.b.cIj().sSZ) {
                com.tencent.mm.plugin.voip.b.cIj().sSZ = true;
                if (System.currentTimeMillis() - g.RP().Ry().Mm(327950) > 86400000) {
                    pg("have not permission to showing floating window\n");
                }
            }
        }
        String string = ah.getContext().getString(R.string.f7b);
        g(string, s.mJ(this.sRl.field_username), string, false);
        if (!(this.tcv == null || this.tcv.doT())) {
            this.tcv.stopTimer();
        }
        AppMethodBeat.o(5184);
    }

    private void cLU() {
        AppMethodBeat.i(5185);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "show mini..");
        mF(false);
        Context context = ah.getContext();
        com.tencent.mm.plugin.voip.b.cIj();
        this.tcu = new a(context, r.mw(false));
        this.tcu.setConnectSec(this.sRs);
        this.tcu.setVoipUIListener(this.tct);
        context = ah.getContext();
        com.tencent.mm.plugin.voip.b.cIj();
        int height = (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight() / 5) + com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 7.0f);
        int b = (int) (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 7.0f)) + (r.mw(true) * ((float) height)));
        this.tcu.dY(b, height);
        this.tcu.setOnClickListener(this.tcz);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
        g(new Point(b, height));
        ab.i("MicroMsg.Voip.VoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", Integer.valueOf(this.sXS), Integer.valueOf(this.sRO));
        setHWDecMode(this.sXS);
        setVoipBeauty(this.sRO);
        AppMethodBeat.o(5185);
    }

    private void cLV() {
        AppMethodBeat.i(5186);
        if (2 == this.sRr) {
            GT(R.string.f3u);
        }
        mF(false);
        String string = ah.getContext().getString(R.string.f7j);
        g(string, s.mJ(this.sRl.field_username), string, true);
        cLX();
        if (this.tct != null) {
            this.tct.a(this, 2);
        }
        AppMethodBeat.o(5186);
    }

    private void GU(int i) {
        AppMethodBeat.i(5187);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
        if (-1 == this.tcx) {
            this.tcx = System.currentTimeMillis();
        }
        if (2 == this.sRr) {
            GT(R.string.f3u);
        }
        mF(false);
        if (this.tct != null) {
            this.tct.a(this, 2);
        }
        this.tcv = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(5174);
                ab.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + b.this.mStatus);
                if (b.this.mStatus == 8 || b.this.mStatus == d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM || !com.tencent.mm.plugin.voip.a.d.cLx()) {
                    ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
                    ab.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking...CALLING_STATE_FINISH state..cancel notification..");
                    if (!(b.this.tcv == null || b.this.tcv.doT())) {
                        b.this.tcv.stopTimer();
                    }
                    AppMethodBeat.o(5174);
                    return false;
                }
                ab.i("MicroMsg.Voip.VoipSmallWindow", "show voice talking, first timer trigger..");
                String g = b.g(b.this);
                b.this.g(g, s.mJ(b.this.sRl.field_username), g, false);
                AppMethodBeat.o(5174);
                return true;
            }
        }, true);
        this.tcv.ae(5000, 5000);
        String cLY = cLY();
        g(cLY, s.mJ(this.sRl.field_username), cLY, false);
        cLX();
        if (4101 == i) {
            GT(R.string.f74);
        }
        AppMethodBeat.o(5187);
    }

    private void acc(String str) {
        AppMethodBeat.i(5188);
        try {
            ab.i("MicroMsg.Voip.VoipSmallWindow", "bindSmallServiceIfNeed isBindSmallService:%s", Boolean.valueOf(this.oGw));
            if (com.tencent.mm.compatible.util.d.iW(26) && !this.oGw) {
                this.oGw = true;
                Intent intent = new Intent();
                intent.putExtra("Voip_User", this.sRl.field_username);
                intent.putExtra("mTickerText", str);
                intent.setClass(ah.getContext(), VoipForegroundService.class);
                ah.getContext().startForegroundService(intent);
            }
            AppMethodBeat.o(5188);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", e, "bindSmallServiceIfNeed error: %s", e.getMessage());
            AppMethodBeat.o(5188);
        }
    }

    public final String cLW() {
        String format;
        AppMethodBeat.i(5189);
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.sRs);
        if (this.sRs == -1) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 3600) {
            format = String.format(Locale.US, "%d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        } else {
            format = String.format(Locale.US, "%d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        if (bo.isNullOrNil(format)) {
            format = "00:00";
        }
        AppMethodBeat.o(5189);
        return format;
    }

    private void cLX() {
        AppMethodBeat.i(5190);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
        boolean z = false;
        if (this.mStatus == d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW || this.mStatus == 7) {
            this.tcA = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(5175);
                    com.tencent.mm.plugin.voip.b.cIk().abZ(b.this.cLW());
                    AppMethodBeat.o(5175);
                    return true;
                }
            }, true);
            this.tcA.ae(1000, 1000);
            z = true;
        }
        Intent intent = new Intent();
        intent.setClass(ah.getContext(), VideoActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("Voip_User", this.sRl.field_username);
        intent.putExtra("Voip_Outcall", this.sRm);
        intent.putExtra("Voip_VideoCall", this.sRn);
        intent.putExtra("Voip_Is_Talking", z);
        com.tencent.mm.plugin.voip.b.cIk().a(intent, new com.tencent.mm.plugin.voip.ui.a() {
            public final boolean bGV() {
                AppMethodBeat.i(5176);
                if (com.tencent.mm.plugin.voip.a.b.GP(b.this.mStatus) || com.tencent.mm.plugin.voip.a.b.GN(b.this.mStatus)) {
                    AppMethodBeat.o(5176);
                    return true;
                }
                AppMethodBeat.o(5176);
                return false;
            }

            public final void a(Intent intent, e eVar) {
                AppMethodBeat.i(5177);
                if (intent.getBooleanExtra("Voip_Is_Talking", false)) {
                    eVar.abZ(b.this.cLW());
                    AppMethodBeat.o(5177);
                    return;
                }
                eVar.abZ(ah.getContext().getString(R.string.f66));
                AppMethodBeat.o(5177);
            }
        });
        AppMethodBeat.o(5190);
    }

    private String cLY() {
        String str;
        AppMethodBeat.i(5191);
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.sRs);
        if (this.sRs == -1) {
            currentTimeMillis = 0;
        }
        String string = ah.getContext().getString(R.string.f7j);
        if (currentTimeMillis >= 3600) {
            str = string + String.format(Locale.US, "    %d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        } else {
            str = string + String.format(Locale.US, "    %d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        AppMethodBeat.o(5191);
        return str;
    }

    private void cLZ() {
        AppMethodBeat.i(5192);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "showCalledVideoInviting");
        Integer num = this.tcu == null ? null : (Integer) this.tcu.getTag();
        if (num == null || !(256 == num.intValue() || d.MIC_PTU_ZIPAI_SAPPORO == num.intValue())) {
            String string = ah.getContext().getString(R.string.f7b);
            if (s.mJ(this.sRl.field_username) != null) {
                g(string, string, s.mJ(this.sRl.field_username), true);
            } else {
                g(string, string, "", true);
            }
            if (this.tct != null) {
                this.tct.a(this, 2);
            }
            AppMethodBeat.o(5192);
            return;
        }
        AppMethodBeat.o(5192);
    }

    private void cMa() {
        AppMethodBeat.i(5193);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "showVideoInviting");
        Integer num = this.tcu == null ? null : (Integer) this.tcu.getTag();
        if (num == null || !(num.intValue() == 0 || 2 == num.intValue() || 4 == num.intValue())) {
            String string = ah.getContext().getString(R.string.f7b);
            if (s.mJ(this.sRl.field_username) != null) {
                g(string, s.mJ(this.sRl.field_username), string, true);
            } else {
                g(string, string, "", true);
            }
            if (this.tct != null) {
                this.tct.a(this, 2);
            }
            AppMethodBeat.o(5193);
            return;
        }
        AppMethodBeat.o(5193);
    }

    public final void g(final String str, final String str2, final String str3, boolean z) {
        AppMethodBeat.i(5194);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + str + ",title:" + str2 + ",content:" + str3 + ",breathEffect:" + z);
        ab.b("MicroMsg.Voip.VoipSmallWindow", "breathEffect ".concat(String.valueOf(z)), new Object[0]);
        if (z) {
            this.tcv = new ap(new ap.a() {
                private int mCount = 0;

                public final boolean BI() {
                    AppMethodBeat.i(5178);
                    ab.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is %s, isUninit:%s", Integer.valueOf(b.this.mStatus), Boolean.valueOf(b.this.umx));
                    this.mCount++;
                    if (b.this.mStatus == 8 || b.this.mStatus == d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM || !com.tencent.mm.plugin.voip.a.d.cLx()) {
                        ab.i("MicroMsg.Voip.VoipSmallWindow", "CALLING_STATE_FINISH state..cancel notification..");
                        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
                        if (!(b.this.tcv == null || b.this.tcv.doT())) {
                            b.this.tcv.stopTimer();
                        }
                        AppMethodBeat.o(5178);
                        return false;
                    } else if (b.this.umx) {
                        if (!(b.this.tcv == null || b.this.tcv.doT())) {
                            b.this.tcv.stopTimer();
                        }
                        AppMethodBeat.o(5178);
                        return false;
                    } else {
                        b.this.g(str + (this.mCount % 2 == 1 ? " " : ""), str2, str3, false);
                        AppMethodBeat.o(5178);
                        return true;
                    }
                }
            }, true);
            this.tcv.ae(5000, 5000);
        }
        Intent intent = new Intent();
        intent.setClass(ah.getContext(), VideoActivity.class);
        intent.putExtra("Voip_User", this.sRl.field_username);
        intent.putExtra("Voip_Outcall", this.sRm);
        intent.putExtra("Voip_VideoCall", this.sRn);
        PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 40, intent, 134217728);
        acc(str3);
        v.c e = com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id").g(str).j(System.currentTimeMillis()).d(str2).e(str3);
        e.EI = activity;
        v.c as = e.as(bWV());
        as.k(2, true);
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, com.tencent.mm.plugin.voip.a.d.c(as), false);
        AppMethodBeat.o(5194);
    }

    public static int bWV() {
        if (VERSION.SDK_INT < 19) {
            return R.drawable.bdn;
        }
        return R.drawable.bdo;
    }

    private void g(Point point) {
        AppMethodBeat.i(5195);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
        if (com.tencent.mm.plugin.voip.a.b.GP(this.mStatus) || com.tencent.mm.plugin.voip.a.b.GN(this.mStatus)) {
            if (this.tcv != null) {
                this.tcv.stopTimer();
            }
            if (this.tcA != null) {
                this.tcA.stopTimer();
            }
            if (this.sZa != null) {
                this.sZa.stopTimer();
            }
            ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
            WindowManager windowManager = (WindowManager) ah.getContext().getSystemService("window");
            LayoutParams layoutParams = new LayoutParams();
            if (com.tencent.mm.compatible.util.d.iW(26)) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2002;
            }
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.gravity = 51;
            Context context = ah.getContext();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.width = point.x;
            layoutParams.height = point.y;
            Point point2 = com.tencent.mm.plugin.voip.b.cIj().sSY;
            if (point2 == null) {
                int i = g.RP().Ry().getInt(327947, 0);
                int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 5.0f);
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
                AppMethodBeat.o(5195);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager failed: %s", e.getMessage());
                AppMethodBeat.o(5195);
                return;
            }
        }
        ab.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
        AppMethodBeat.o(5195);
    }

    private void mF(boolean z) {
        AppMethodBeat.i(5196);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView");
        if (this.tcv != null) {
            this.tcv.stopTimer();
        }
        ab.i("MicroMsg.Voip.VoipSmallWindow", "remove small view..cancel notification first..");
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        if (this.tcu != null) {
            LayoutParams layoutParams = (LayoutParams) this.tcu.getLayoutParams();
            com.tencent.mm.plugin.voip.b.cIj().sSY = new Point(layoutParams.x, layoutParams.y);
            this.tcu.uninit();
            try {
                ((WindowManager) ah.getContext().getSystemService("window")).removeView(this.tcu);
            } catch (IllegalArgumentException e) {
                ab.e("MicroMsg.Voip.VoipSmallWindow", "remove failed", e);
            }
            this.tcu = null;
        }
        if (z) {
            com.tencent.mm.plugin.voip.b.cIk().abZ(ah.getContext().getString(R.string.f64));
        }
        if (this.tcA != null) {
            this.tcA.stopTimer();
        }
        com.tencent.mm.plugin.voip.b.cIk().dismiss();
        AppMethodBeat.o(5196);
    }

    public final void br(int i, String str) {
        int i2;
        AppMethodBeat.i(5197);
        if (i == d.MIC_PTU_QINGCONG) {
            Toast.makeText(ah.getContext(), str, 1).show();
        }
        ab.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(i)));
        if (i == d.MIC_PTU_AUTOLEVEL) {
            i2 = R.string.f5i;
        } else if (i == d.MIC_PTU_MEISHI) {
            com.tencent.mm.plugin.voip.b.cIj().cKb();
            i2 = R.string.f5h;
        } else if (i == d.MIC_PTU_LENGMEIREN) {
            if (!com.tencent.mm.au.b.ahP() || this.sRn) {
                i2 = R.string.f5j;
            } else {
                i2 = R.string.f5l;
            }
        } else if (i == 236) {
            i2 = R.string.f5w;
        } else if (i == 211) {
            i2 = R.string.f5k;
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            GT(R.string.f5g);
            AppMethodBeat.o(5197);
            return;
        }
        GT(i2);
        AppMethodBeat.o(5197);
    }

    public final void abY(String str) {
    }

    public final void c(int i, int i2, int[] iArr) {
        AppMethodBeat.i(5198);
        if (d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW == this.mStatus || 6 == this.mStatus) {
            if (this.tcu != null) {
                this.tcu.c(i, i2, iArr);
            }
            AppMethodBeat.o(5198);
            return;
        }
        AppMethodBeat.o(5198);
    }

    public final void cJD() {
        AppMethodBeat.i(5199);
        if (this.tcu != null) {
            this.tcu.cJD();
        }
        AppMethodBeat.o(5199);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.i(5200);
        if (this.tcu != null) {
            this.tcu.setVoipBeauty(i);
        }
        this.sRO = i;
        AppMethodBeat.o(5200);
    }

    public final void setHWDecMode(int i) {
        AppMethodBeat.i(5201);
        if (this.tcu != null) {
            this.tcu.setHWDecMode(i);
        }
        this.sXS = i;
        AppMethodBeat.o(5201);
    }

    public final void setScreenEnable(boolean z) {
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(5202);
        if (d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW == this.mStatus || 6 == this.mStatus) {
            if (this.tcu != null) {
                this.tcu.a(bArr, j, i, i2, i3, i4, i5);
            }
            AppMethodBeat.o(5202);
            return;
        }
        AppMethodBeat.o(5202);
    }

    public final Context cKS() {
        return null;
    }

    public final void uninit() {
        int i = 3;
        AppMethodBeat.i(5203);
        ab.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
        if (-1 != this.tcx) {
            h hVar = h.pYm;
            Object[] objArr = new Object[3];
            if (this.tcy) {
                i = 2;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Long.valueOf((System.currentTimeMillis() - this.tcx) / 1000);
            objArr[2] = Integer.valueOf(this.sTb ? 1 : 2);
            hVar.e(11620, objArr);
        }
        if (this.tcw != null && this.tcw.isHeld()) {
            ab.i("MicroMsg.Voip.VoipSmallWindow", "release waklock");
            this.tcw.release();
        }
        mF(false);
        this.umx = true;
        if (this.tcv != null) {
            this.tcv.stopTimer();
        }
        if (this.tcA != null) {
            this.tcA.stopTimer();
        }
        ab.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
        ab.b("MicroMsg.Voip.VoipSmallWindow", "unbindSmallServiceIfNeed, isBindSmallService:%s", Boolean.valueOf(this.oGw));
        try {
            if (com.tencent.mm.compatible.util.d.iW(26) && this.oGw) {
                Intent intent = new Intent();
                intent.setClass(ah.getContext(), VoipForegroundService.class);
                ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
                ah.getContext().stopService(intent);
                this.oGw = false;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", e, "unBind vidoeforeground error: %s", e.getMessage());
        }
        this.sRg = null;
        AppMethodBeat.o(5203);
    }

    public final void setConnectSec(long j) {
        AppMethodBeat.i(5204);
        this.sRs = j;
        if (this.tcu != null) {
            this.tcu.setConnectSec(j);
            AppMethodBeat.o(5204);
            return;
        }
        if (d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW == this.mStatus || 7 == this.mStatus) {
            String cLY = cLY();
            g(cLY, s.mJ(this.sRl.field_username), cLY, false);
        }
        AppMethodBeat.o(5204);
    }

    public final void my(boolean z) {
        AppMethodBeat.i(5205);
        if (z) {
            Toast.makeText(ah.getContext(), R.string.gaq, 1).show();
            AppMethodBeat.o(5205);
            return;
        }
        Toast.makeText(ah.getContext(), R.string.gap, 1).show();
        AppMethodBeat.o(5205);
    }

    public final void bIK() {
    }

    public final void setCaptureView(CaptureView captureView) {
        AppMethodBeat.i(5206);
        this.sRg = captureView;
        if (!(this.tcu == null || this.sRg == null)) {
            if (this.sRg.getParent() != null && (this.sRg.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.sRg.getParent()).removeView(this.sRg);
            }
            this.tcu.setCaptureView(captureView);
        }
        AppMethodBeat.o(5206);
    }

    public final void cKT() {
    }

    private static void pg(String str) {
        AppMethodBeat.i(5207);
        g.RP().Ry().setLong(327950, System.currentTimeMillis());
        ab.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + str.length());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.vxo).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("#accinfo.revision=").append(f.REV).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("#accinfo.build=").append(f.TIME).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(f.HOSTNAME).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(com.tencent.mm.sdk.platformtools.g.cdf).append(IOUtils.LINE_SEPARATOR_UNIX);
        Date date = new Date();
        stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("#accinfo.content:\n");
        Intent intent = new Intent();
        intent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionWriteSdcard", false);
        intent.putExtra("exceptionPid", Process.myPid());
        intent.putExtra("userName", Bo());
        intent.putExtra("tag", "float_window_permission");
        intent.putExtra("exceptionMsg", Base64.encodeToString((stringBuilder.toString() + str).getBytes(), 2));
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(5207);
    }

    private static String Bo() {
        AppMethodBeat.i(5208);
        String T = av.fly.T("login_weixin_username", "");
        if (bo.isNullOrNil(T)) {
            T = av.fly.T("login_user_name", "never_login_crash");
        }
        AppMethodBeat.o(5208);
        return T;
    }

    public final byte[] cKU() {
        AppMethodBeat.i(5209);
        if (!(this.tcu == null || this.tcu.getFilterData() == null)) {
            this.tcu.getFilterData().a(new com.tencent.mm.plugin.voip.video.a.d() {
                public final void bu(byte[] bArr) {
                    AppMethodBeat.i(5179);
                    if (bArr != null) {
                        b.this.buffer = bArr;
                    }
                    AppMethodBeat.o(5179);
                }
            });
        }
        byte[] bArr = this.buffer;
        AppMethodBeat.o(5209);
        return bArr;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
