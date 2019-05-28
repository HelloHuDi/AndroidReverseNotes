package com.tencent.mm.plugin.radar.ui;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.f.b.y;
import a.i;
import a.i.k;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.radar.b.d;
import com.tencent.mm.plugin.radar.ui.RadarViewController.e;
import com.tencent.mm.plugin.radar.ui.RadarViewController.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ae;
import com.tencent.ugc.TXRecordCommon;
import java.util.Arrays;

@com.tencent.mm.ui.base.a(19)
@l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0002J\"\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J+\u0010\"\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100$2\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\u0012H\u0002J\b\u0010*\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "REQUEST_CODE_GDPR_LOCATION_USE_SCENE", "", "mRadarViewController", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "getMRadarViewController", "()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "mRadarViewController$delegate", "Lkotlin/Lazy;", "shouldCheckPermission", "", "getSystemService", "", "name", "", "hideTalkRoomeStatusBar", "", "isHide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeAfterMPermissionGranted", "radarUsagePlusOne", "Companion", "plugin-radar_release"})
public final class RadarSearchUI extends MMBaseActivity {
    private static final String TAG = TAG;
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(RadarSearchUI.class), "mRadarViewController", "getMRadarViewController()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;"))};
    public static final a pCF = new a();
    private boolean gwZ = true;
    private final f pCD = i.a(a.k.NONE, new a(this));
    private final int pCE = 30764;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class b implements OnClickListener {
        final /* synthetic */ RadarSearchUI pCG;

        b(RadarSearchUI radarSearchUI) {
            this.pCG = radarSearchUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(102989);
            this.pCG.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            this.pCG.gwZ = true;
            this.pCG.finish();
            AppMethodBeat.o(102989);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class c implements OnClickListener {
        final /* synthetic */ RadarSearchUI pCG;

        c(RadarSearchUI radarSearchUI) {
            this.pCG = radarSearchUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(102990);
            this.pCG.gwZ = true;
            this.pCG.finish();
            AppMethodBeat.o(102990);
        }
    }

    private final RadarViewController cdI() {
        AppMethodBeat.i(102992);
        RadarViewController radarViewController = (RadarViewController) this.pCD.getValue();
        AppMethodBeat.o(102992);
        return radarViewController;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RadarSearchUI() {
        AppMethodBeat.i(103003);
        j.p(this, "receiver$0");
        AppMethodBeat.o(103003);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(102993);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        requestWindowFeature(1);
        setContentView(R.layout.amk);
        RadarViewController cdI = cdI();
        View findViewById = cdI.findViewById(R.id.du9);
        j.o(findViewById, "findViewById(R.id.radar_main_layer)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        LayoutParams layoutParams = relativeLayout.getLayoutParams();
        a.v vVar;
        if (layoutParams == null) {
            vVar = new a.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(102993);
            throw vVar;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = cdI.getContext();
        if (context == null) {
            vVar = new a.v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(102993);
            throw vVar;
        }
        WindowManager windowManager = ((Activity) context).getWindowManager();
        j.o(windowManager, "(context as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams2.width = displayMetrics.widthPixels;
        relativeLayout.setLayoutParams(layoutParams2);
        RadarTipsView radarTips = cdI.getRadarTips();
        radarTips.getNoviceEducationTips().setOnClickListener(new c(radarTips));
        RadarTipsView radarTips2 = cdI.getRadarTips();
        radarTips2.pDB = RadarTipsView.pDE;
        d dVar = d.pCC;
        int cdH = d.cdH();
        radarTips2.pDt.sendEmptyMessageDelayed(radarTips2.pDq, (long) cdH);
        radarTips2.pDt.sendEmptyMessageDelayed(radarTips2.pDp, (long) (cdH + TXRecordCommon.AUDIO_SAMPLERATE_8000));
        cdI.getRadarTips().setPressingDown(true);
        cdI.getQuitBtn().setOnClickListener(cdI.pDY);
        LayoutParams layoutParams3 = cdI.getQuitBtn().getLayoutParams();
        if (layoutParams3 == null) {
            vVar = new a.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(102993);
            throw vVar;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        cdH = layoutParams4.topMargin;
        if (ae.hD(cdI.getContext())) {
            cdH += ae.hC(cdI.getContext());
        }
        layoutParams4.setMargins(layoutParams4.leftMargin, cdH, layoutParams4.rightMargin, layoutParams4.bottomMargin);
        cdI.getQuitBtn().setLayoutParams(layoutParams4);
        RadarWaveView waveView = cdI.getWaveView();
        waveView.pEA = waveView.findViewById(R.id.du8);
        waveView.pEB = AnimationUtils.loadAnimation(waveView.getContext(), R.anim.cq);
        Animation animation = waveView.pEB;
        if (animation == null) {
            j.dWJ();
        }
        animation.setInterpolator(new LinearInterpolator());
        com.tencent.mm.plugin.radar.ui.b.a aVar = com.tencent.mm.plugin.radar.ui.b.a.pCd;
        findViewById = cdI.findViewById(R.id.duc);
        j.o(findViewById, "findViewById(R.id.self_round_avatar)");
        ImageView imageView = (ImageView) findViewById;
        String Yz = r.Yz();
        j.o(Yz, "ConfigStorageLogic.getUsernameFromUserInfo()");
        com.tencent.mm.plugin.radar.ui.b.a.b(imageView, Yz);
        cdI.getMemberDetailView().setListener(new e(cdI));
        RadarSpecialGridView grid = cdI.getGrid();
        context = cdI.getContext();
        j.o(context, "context");
        cdI.pDV = new com.tencent.mm.plugin.radar.ui.RadarViewController.c(cdI, grid, context);
        cdI.getGrid().setOnItemClickListener(new h(cdI));
        RadarViewController cdI2 = cdI();
        com.tencent.mm.plugin.radar.b.c cVar = cdI2.pDU;
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        j.o(K, "service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().a(cVar);
        com.tencent.mm.sdk.b.a.xxA.c(cVar.pAO);
        com.tencent.mm.kernel.b.a M = g.M(p.class);
        j.o(M, "plugin(IPluginMessengerFoundation::class.java)");
        ((p) M).getSysCmdMsgExtension().a("addcontact", (com.tencent.mm.model.bz.a) cVar.pAP, true);
        com.tencent.mm.plugin.radar.b.e eVar = cdI2.pDT;
        if (eVar == null) {
            j.avw("radarManager");
        }
        g.Rg().a(425, (com.tencent.mm.ai.f) eVar);
        g.Rg().a(602, (com.tencent.mm.ai.f) eVar);
        Object obj = g.RP().Ry().get(229377, Integer.valueOf(0));
        if (obj == null) {
            vVar = new a.v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(102993);
            throw vVar;
        }
        g.RP().Ry().set(229377, Integer.valueOf(((Integer) obj).intValue() + 1));
        AppMethodBeat.o(102993);
    }

    public final void onResume() {
        AppMethodBeat.i(102994);
        super.onResume();
        if (this.gwZ) {
            com.tencent.mm.kernel.e RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            Object obj = RP.Ry().get(274436);
            if (!(obj instanceof String)) {
                obj = null;
            }
            if (!com.tencent.mm.au.b.sO((String) obj)) {
                ab.i(TAG, "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
                if (!com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    AppMethodBeat.o(102994);
                    return;
                }
            } else if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
                RP = g.RP();
                j.o(RP, "MMKernel.storage()");
                obj = RP.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE);
                if (obj == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type kotlin.Boolean");
                    AppMethodBeat.o(102994);
                    throw vVar;
                } else if (((Boolean) obj).booleanValue()) {
                    com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    AppMethodBeat.o(102994);
                    return;
                } else {
                    com.tencent.mm.plugin.account.a.b.a.b(this, getString(R.string.g7p, new Object[]{aa.dor()}), this.pCE, true);
                    AppMethodBeat.o(102994);
                    return;
                }
            }
            cdJ();
        }
        AppMethodBeat.o(102994);
    }

    private final void cdJ() {
        AppMethodBeat.i(102995);
        kb(true);
        d dVar = d.pBq;
        d.cdx();
        dVar = d.pBq;
        d.cdy();
        if (cdI().getRadarStatus() == com.tencent.mm.plugin.radar.b.e.e.SEARCHING || cdI().getRadarStatus() == com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN) {
            cdI().onResume();
            cdI().cdA();
            cdI().getWaveView().cdU();
        }
        AppMethodBeat.o(102995);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(102996);
        j.p(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        j.p(iArr, "grantResults");
        Object[] objArr;
        Thread currentThread;
        if (iArr.length <= 0) {
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            currentThread = Thread.currentThread();
            j.o(currentThread, "Thread.currentThread()");
            objArr[1] = Long.valueOf(currentThread.getId());
            ab.i(TAG, "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", objArr);
            AppMethodBeat.o(102996);
            return;
        }
        objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iArr[0]);
        currentThread = Thread.currentThread();
        j.o(currentThread, "Thread.currentThread()");
        objArr[2] = Long.valueOf(currentThread.getId());
        ab.i(TAG, "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", objArr);
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    this.gwZ = false;
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.dbt), false, (OnClickListener) new b(this), (OnClickListener) new c(this));
                    break;
                }
                cdJ();
                AppMethodBeat.o(102996);
                return;
        }
        AppMethodBeat.o(102996);
    }

    public final void onPause() {
        long cdz;
        int i;
        String format;
        AppMethodBeat.i(102997);
        super.onPause();
        kb(false);
        d dVar = d.pBq;
        if (d.pBm != 0) {
            cdz = d.cdz() - d.pBm;
            d dVar2 = d.pCC;
            if (d.jz(cdz)) {
                boolean i2 = false;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                i2 = d.cEX;
                ab.d(d.TAG, "FoundFriendsCnt %d", Integer.valueOf(i2));
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                y yVar = y.AVH;
                format = String.format("%d", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
                j.o(format, "java.lang.String.format(format, *args)");
                hVar.X(10679, format);
                d.pBj++;
                d.pBk = cdz + d.pBk;
                d.pBm = 0;
            }
        }
        dVar = d.pBq;
        if (d.pBl != 0) {
            cdz = System.currentTimeMillis() - d.pBl;
            i2 = d.pBj;
            float f = (((float) d.pBk) * 1.0f) / 1000.0f;
            int i3 = d.pBn;
            float f2 = (((float) cdz) * 1.0f) / 1000.0f;
            ab.d(d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Float.valueOf(f2));
            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.pYm;
            y yVar2 = y.AVH;
            format = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[]{Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Float.valueOf(f2)}, 5));
            j.o(format, "java.lang.String.format(format, *args)");
            hVar2.X(10676, format);
        }
        if (cdI().getRadarStatus() == com.tencent.mm.plugin.radar.b.e.e.SEARCHING || cdI().getRadarStatus() == com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN) {
            com.tencent.mm.plugin.radar.b.e eVar = cdI().pDT;
            if (eVar == null) {
                j.avw("radarManager");
            }
            eVar.cdB();
            eVar = cdI().pDT;
            if (eVar == null) {
                j.avw("radarManager");
            }
            com.tencent.mm.modelgeo.d dVar3 = eVar.fwu;
            if (dVar3 != null) {
                dVar3.c(eVar.ecy);
            }
            cdI().getWaveView().cdV();
        }
        AppMethodBeat.o(102997);
    }

    public final void onDestroy() {
        AppMethodBeat.i(102998);
        RadarViewController cdI = cdI();
        com.tencent.mm.plugin.radar.b.c cVar = cdI.pDU;
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        j.o(K, "service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().b(cVar);
        com.tencent.mm.sdk.b.a.xxA.d(cVar.pAO);
        com.tencent.mm.kernel.b.a M = g.M(p.class);
        j.o(M, "plugin(IPluginMessengerFoundation::class.java)");
        ((p) M).getSysCmdMsgExtension().b("addcontact", cVar.pAP, true);
        com.tencent.mm.plugin.radar.b.e eVar = cdI.pDT;
        if (eVar == null) {
            j.avw("radarManager");
        }
        g.Rg().b(425, (com.tencent.mm.ai.f) eVar);
        g.Rg().b(602, (com.tencent.mm.ai.f) eVar);
        eVar.stop();
        com.tencent.mm.modelgeo.d dVar = eVar.fwu;
        if (dVar != null) {
            dVar.c(eVar.ecy);
        }
        RadarWaveView waveView = cdI.getWaveView();
        try {
            MediaPlayer mediaPlayer = waveView.pEz;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            waveView.pEz = null;
        } catch (Exception e) {
            ab.printErrStackTrace(RadarWaveView.TAG, e, "", new Object[0]);
            ab.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
            waveView.pEz = null;
        }
        super.onDestroy();
        AppMethodBeat.o(102998);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(102999);
        super.onActivityResult(i, i2, intent);
        if (i == this.pCE) {
            if (intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra == null || !bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                    this.gwZ = true;
                    finish();
                    AppMethodBeat.o(102999);
                    return;
                }
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                this.gwZ = false;
                AppMethodBeat.o(102999);
                return;
            }
            this.gwZ = true;
            finish();
        }
        AppMethodBeat.o(102999);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(103000);
        j.p(keyEvent, "event");
        boolean onKeyDown = cdI().onKeyDown(i, keyEvent);
        if (onKeyDown) {
            AppMethodBeat.o(103000);
            return onKeyDown;
        }
        onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(103000);
        return onKeyDown;
    }

    private static void kb(boolean z) {
        AppMethodBeat.i(103001);
        tb tbVar = new tb();
        tbVar.cPn.cPo = z;
        com.tencent.mm.sdk.b.a.xxA.m(tbVar);
        AppMethodBeat.o(103001);
    }

    public final Object getSystemService(String str) {
        AppMethodBeat.i(103002);
        j.p(str, "name");
        Object systemService = super.getSystemService(str);
        if (systemService == null || !j.j("layout_inflater", str)) {
            AppMethodBeat.o(103002);
            return systemService;
        }
        LayoutInflater a = com.tencent.mm.ui.v.a((LayoutInflater) systemService);
        AppMethodBeat.o(103002);
        return a;
    }

    static {
        AppMethodBeat.i(102991);
        AppMethodBeat.o(102991);
    }
}
