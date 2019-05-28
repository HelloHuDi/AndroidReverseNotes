package com.tencent.p177mm.plugin.radar.p489ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p230g.p231a.C37801tb;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.radar.p488b.C39550e;
import com.tencent.p177mm.plugin.radar.p488b.C39550e.C39549e;
import com.tencent.p177mm.plugin.radar.p488b.C43413c;
import com.tencent.p177mm.plugin.radar.p488b.C43416d;
import com.tencent.p177mm.plugin.radar.p489ui.C46153i.C46152a;
import com.tencent.p177mm.plugin.radar.p489ui.C46915b.C34778a;
import com.tencent.p177mm.plugin.radar.p489ui.RadarTipsView.C28792c;
import com.tencent.p177mm.plugin.radar.p489ui.RadarViewController.C12939c;
import com.tencent.p177mm.plugin.radar.p489ui.RadarViewController.C36800h;
import com.tencent.p177mm.plugin.radar.p489ui.RadarViewController.C7035e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ugc.TXRecordCommon;
import java.util.Arrays;
import p000a.C0219k;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p005f.p007b.C8001y;
import p000a.p010i.C31815k;

@C5271a(19)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0002J\"\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J+\u0010\"\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100$2\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\u0012H\u0002J\b\u0010*\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "REQUEST_CODE_GDPR_LOCATION_USE_SCENE", "", "mRadarViewController", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "getMRadarViewController", "()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "mRadarViewController$delegate", "Lkotlin/Lazy;", "shouldCheckPermission", "", "getSystemService", "", "name", "", "hideTalkRoomeStatusBar", "", "isHide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeAfterMPermissionGranted", "radarUsagePlusOne", "Companion", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.RadarSearchUI */
public final class RadarSearchUI extends MMBaseActivity {
    private static final String TAG = TAG;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarSearchUI.class), "mRadarViewController", "getMRadarViewController()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;"))};
    public static final C28791a pCF = new C28791a();
    private boolean gwZ = true;
    private final C44856f pCD = C17344i.m26853a(C0219k.NONE, new C46152a(this));
    private final int pCE = 30764;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarSearchUI$b */
    static final class C21560b implements OnClickListener {
        final /* synthetic */ RadarSearchUI pCG;

        C21560b(RadarSearchUI radarSearchUI) {
            this.pCG = radarSearchUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(102989);
            this.pCG.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            this.pCG.gwZ = true;
            this.pCG.finish();
            AppMethodBeat.m2505o(102989);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarSearchUI$a */
    public static final class C28791a {
        private C28791a() {
        }

        public /* synthetic */ C28791a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarSearchUI$c */
    static final class C39558c implements OnClickListener {
        final /* synthetic */ RadarSearchUI pCG;

        C39558c(RadarSearchUI radarSearchUI) {
            this.pCG = radarSearchUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(102990);
            this.pCG.gwZ = true;
            this.pCG.finish();
            AppMethodBeat.m2505o(102990);
        }
    }

    private final RadarViewController cdI() {
        AppMethodBeat.m2504i(102992);
        RadarViewController radarViewController = (RadarViewController) this.pCD.getValue();
        AppMethodBeat.m2505o(102992);
        return radarViewController;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RadarSearchUI() {
        AppMethodBeat.m2504i(103003);
        C25052j.m39376p(this, "receiver$0");
        AppMethodBeat.m2505o(103003);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(102993);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        requestWindowFeature(1);
        setContentView(2130970441);
        RadarViewController cdI = cdI();
        View findViewById = cdI.findViewById(2131826805);
        C25052j.m39375o(findViewById, "findViewById(R.id.radar_main_layer)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        LayoutParams layoutParams = relativeLayout.getLayoutParams();
        C44941v c44941v;
        if (layoutParams == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.m2505o(102993);
            throw c44941v;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = cdI.getContext();
        if (context == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.m2505o(102993);
            throw c44941v;
        }
        WindowManager windowManager = ((Activity) context).getWindowManager();
        C25052j.m39375o(windowManager, "(context as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams2.width = displayMetrics.widthPixels;
        relativeLayout.setLayoutParams(layoutParams2);
        RadarTipsView radarTips = cdI.getRadarTips();
        radarTips.getNoviceEducationTips().setOnClickListener(new C28792c(radarTips));
        RadarTipsView radarTips2 = cdI.getRadarTips();
        radarTips2.pDB = RadarTipsView.pDE;
        C34779d c34779d = C34779d.pCC;
        int cdH = C34779d.cdH();
        radarTips2.pDt.sendEmptyMessageDelayed(radarTips2.pDq, (long) cdH);
        radarTips2.pDt.sendEmptyMessageDelayed(radarTips2.pDp, (long) (cdH + TXRecordCommon.AUDIO_SAMPLERATE_8000));
        cdI.getRadarTips().setPressingDown(true);
        cdI.getQuitBtn().setOnClickListener(cdI.pDY);
        LayoutParams layoutParams3 = cdI.getQuitBtn().getLayoutParams();
        if (layoutParams3 == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.m2505o(102993);
            throw c44941v;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        cdH = layoutParams4.topMargin;
        if (C5222ae.m7950hD(cdI.getContext())) {
            cdH += C5222ae.m7949hC(cdI.getContext());
        }
        layoutParams4.setMargins(layoutParams4.leftMargin, cdH, layoutParams4.rightMargin, layoutParams4.bottomMargin);
        cdI.getQuitBtn().setLayoutParams(layoutParams4);
        RadarWaveView waveView = cdI.getWaveView();
        waveView.pEA = waveView.findViewById(2131826804);
        waveView.pEB = AnimationUtils.loadAnimation(waveView.getContext(), C25738R.anim.f8385cq);
        Animation animation = waveView.pEB;
        if (animation == null) {
            C25052j.dWJ();
        }
        animation.setInterpolator(new LinearInterpolator());
        C34778a c34778a = C34778a.pCd;
        findViewById = cdI.findViewById(2131826809);
        C25052j.m39375o(findViewById, "findViewById(R.id.self_round_avatar)");
        ImageView imageView = (ImageView) findViewById;
        String Yz = C1853r.m3846Yz();
        C25052j.m39375o(Yz, "ConfigStorageLogic.getUsernameFromUserInfo()");
        C34778a.m57122b(imageView, Yz);
        cdI.getMemberDetailView().setListener(new C7035e(cdI));
        RadarSpecialGridView grid = cdI.getGrid();
        context = cdI.getContext();
        C25052j.m39375o(context, "context");
        cdI.pDV = new C12939c(cdI, grid, context);
        cdI.getGrid().setOnItemClickListener(new C36800h(cdI));
        RadarViewController cdI2 = cdI();
        C43413c c43413c = cdI2.pDU;
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
        ((C6982j) K).mo15369XM().mo10118a(c43413c);
        C4879a.xxA.mo10052c(c43413c.pAO);
        C1677a M = C1720g.m3530M(C6983p.class);
        C25052j.m39375o(M, "plugin(IPluginMessengerFoundation::class.java)");
        ((C6983p) M).getSysCmdMsgExtension().mo14900a("addcontact", (C1837a) c43413c.pAP, true);
        C39550e c39550e = cdI2.pDT;
        if (c39550e == null) {
            C25052j.avw("radarManager");
        }
        C1720g.m3540Rg().mo14539a(425, (C1202f) c39550e);
        C1720g.m3540Rg().mo14539a(602, (C1202f) c39550e);
        Object obj = C1720g.m3536RP().mo5239Ry().get(229377, Integer.valueOf(0));
        if (obj == null) {
            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.m2505o(102993);
            throw c44941v;
        }
        C1720g.m3536RP().mo5239Ry().set(229377, Integer.valueOf(((Integer) obj).intValue() + 1));
        AppMethodBeat.m2505o(102993);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(102994);
        super.onResume();
        if (this.gwZ) {
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            Object obj = RP.mo5239Ry().get(274436);
            if (!(obj instanceof String)) {
                obj = null;
            }
            if (!C17950b.m28216sO((String) obj)) {
                C4990ab.m7417i(TAG, "summerper checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
                if (!C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    AppMethodBeat.m2505o(102994);
                    return;
                }
            } else if (!C35805b.m58714o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
                RP = C1720g.m3536RP();
                C25052j.m39375o(RP, "MMKernel.storage()");
                obj = RP.mo5239Ry().get(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE);
                if (obj == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Boolean");
                    AppMethodBeat.m2505o(102994);
                    throw c44941v;
                } else if (((Boolean) obj).booleanValue()) {
                    C35805b.m58709b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    AppMethodBeat.m2505o(102994);
                    return;
                } else {
                    C32921a.m53856b(this, getString(C25738R.string.g7p, new Object[]{C4988aa.dor()}), this.pCE, true);
                    AppMethodBeat.m2505o(102994);
                    return;
                }
            }
            cdJ();
        }
        AppMethodBeat.m2505o(102994);
    }

    private final void cdJ() {
        AppMethodBeat.m2504i(102995);
        RadarSearchUI.m77500kb(true);
        C43416d c43416d = C43416d.pBq;
        C43416d.cdx();
        c43416d = C43416d.pBq;
        C43416d.cdy();
        if (cdI().getRadarStatus() == C39549e.SEARCHING || cdI().getRadarStatus() == C39549e.SEARCH_RETRUN) {
            cdI().onResume();
            cdI().cdA();
            cdI().getWaveView().cdU();
        }
        AppMethodBeat.m2505o(102995);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(102996);
        C25052j.m39376p(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        C25052j.m39376p(iArr, "grantResults");
        Object[] objArr;
        Thread currentThread;
        if (iArr.length <= 0) {
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            currentThread = Thread.currentThread();
            C25052j.m39375o(currentThread, "Thread.currentThread()");
            objArr[1] = Long.valueOf(currentThread.getId());
            C4990ab.m7417i(TAG, "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", objArr);
            AppMethodBeat.m2505o(102996);
            return;
        }
        objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iArr[0]);
        currentThread = Thread.currentThread();
        C25052j.m39375o(currentThread, "Thread.currentThread()");
        objArr[2] = Long.valueOf(currentThread.getId());
        C4990ab.m7417i(TAG, "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", objArr);
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    this.gwZ = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.dbt), false, (OnClickListener) new C21560b(this), (OnClickListener) new C39558c(this));
                    break;
                }
                cdJ();
                AppMethodBeat.m2505o(102996);
                return;
        }
        AppMethodBeat.m2505o(102996);
    }

    public final void onPause() {
        long cdz;
        int i;
        String format;
        AppMethodBeat.m2504i(102997);
        super.onPause();
        RadarSearchUI.m77500kb(false);
        C43416d c43416d = C43416d.pBq;
        if (C43416d.pBm != 0) {
            cdz = C43416d.cdz() - C43416d.pBm;
            C34779d c34779d = C34779d.pCC;
            if (C34779d.m57123jz(cdz)) {
                boolean i2 = false;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                i2 = C43416d.cEX;
                C4990ab.m7411d(C43416d.TAG, "FoundFriendsCnt %d", Integer.valueOf(i2));
                C7060h c7060h = C7060h.pYm;
                C8001y c8001y = C8001y.AVH;
                format = String.format("%d", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
                C25052j.m39375o(format, "java.lang.String.format(format, *args)");
                c7060h.mo8374X(10679, format);
                C43416d.pBj++;
                C43416d.pBk = cdz + C43416d.pBk;
                C43416d.pBm = 0;
            }
        }
        c43416d = C43416d.pBq;
        if (C43416d.pBl != 0) {
            cdz = System.currentTimeMillis() - C43416d.pBl;
            i2 = C43416d.pBj;
            float f = (((float) C43416d.pBk) * 1.0f) / 1000.0f;
            int i3 = C43416d.pBn;
            float f2 = (((float) cdz) * 1.0f) / 1000.0f;
            C4990ab.m7411d(C43416d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Float.valueOf(f2));
            C7060h c7060h2 = C7060h.pYm;
            C8001y c8001y2 = C8001y.AVH;
            format = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[]{Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Float.valueOf(f2)}, 5));
            C25052j.m39375o(format, "java.lang.String.format(format, *args)");
            c7060h2.mo8374X(10676, format);
        }
        if (cdI().getRadarStatus() == C39549e.SEARCHING || cdI().getRadarStatus() == C39549e.SEARCH_RETRUN) {
            C39550e c39550e = cdI().pDT;
            if (c39550e == null) {
                C25052j.avw("radarManager");
            }
            c39550e.cdB();
            c39550e = cdI().pDT;
            if (c39550e == null) {
                C25052j.avw("radarManager");
            }
            C26443d c26443d = c39550e.fwu;
            if (c26443d != null) {
                c26443d.mo44208c(c39550e.ecy);
            }
            cdI().getWaveView().cdV();
        }
        AppMethodBeat.m2505o(102997);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(102998);
        RadarViewController cdI = cdI();
        C43413c c43413c = cdI.pDU;
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
        ((C6982j) K).mo15369XM().mo10121b(c43413c);
        C4879a.xxA.mo10053d(c43413c.pAO);
        C1677a M = C1720g.m3530M(C6983p.class);
        C25052j.m39375o(M, "plugin(IPluginMessengerFoundation::class.java)");
        ((C6983p) M).getSysCmdMsgExtension().mo14903b("addcontact", c43413c.pAP, true);
        C39550e c39550e = cdI.pDT;
        if (c39550e == null) {
            C25052j.avw("radarManager");
        }
        C1720g.m3540Rg().mo14546b(425, (C1202f) c39550e);
        C1720g.m3540Rg().mo14546b(602, (C1202f) c39550e);
        c39550e.stop();
        C26443d c26443d = c39550e.fwu;
        if (c26443d != null) {
            c26443d.mo44208c(c39550e.ecy);
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
            C4990ab.printErrStackTrace(RadarWaveView.TAG, e, "", new Object[0]);
            C4990ab.m7412e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
            waveView.pEz = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(102998);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(102999);
        super.onActivityResult(i, i2, intent);
        if (i == this.pCE) {
            if (intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra == null || !bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                    this.gwZ = true;
                    finish();
                    AppMethodBeat.m2505o(102999);
                    return;
                }
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                C35805b.m58709b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                this.gwZ = false;
                AppMethodBeat.m2505o(102999);
                return;
            }
            this.gwZ = true;
            finish();
        }
        AppMethodBeat.m2505o(102999);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(103000);
        C25052j.m39376p(keyEvent, "event");
        boolean onKeyDown = cdI().onKeyDown(i, keyEvent);
        if (onKeyDown) {
            AppMethodBeat.m2505o(103000);
            return onKeyDown;
        }
        onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(103000);
        return onKeyDown;
    }

    /* renamed from: kb */
    private static void m77500kb(boolean z) {
        AppMethodBeat.m2504i(103001);
        C37801tb c37801tb = new C37801tb();
        c37801tb.cPn.cPo = z;
        C4879a.xxA.mo10055m(c37801tb);
        AppMethodBeat.m2505o(103001);
    }

    public final Object getSystemService(String str) {
        AppMethodBeat.m2504i(103002);
        C25052j.m39376p(str, "name");
        Object systemService = super.getSystemService(str);
        if (systemService == null || !C25052j.m39373j("layout_inflater", str)) {
            AppMethodBeat.m2505o(103002);
            return systemService;
        }
        LayoutInflater a = C5616v.m8408a((LayoutInflater) systemService);
        AppMethodBeat.m2505o(103002);
        return a;
    }

    static {
        AppMethodBeat.m2504i(102991);
        AppMethodBeat.m2505o(102991);
    }
}
