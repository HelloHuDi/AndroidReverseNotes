package com.tencent.p177mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.emoji.p227a.C32498b;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p1177ao.C25779b;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emojicapture.api.C27791b;
import com.tencent.p177mm.plugin.emojicapture.api.C27791b.C27790a;
import com.tencent.p177mm.plugin.emojicapture.api.C42969a;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C11613g;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C45865e;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy.C20437a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C14034e;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.util.FilterUtils;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.ResourcePathMapper.MODE;
import com.tencent.view.C41106g;
import com.tencent.view.raw.FilterRawGet;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.File;
import java.io.InputStream;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001*B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0006H\u0016J\u0012\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010'\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0004\n\u0002\b\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "getExternalFilesDir", "Ljava/io/File;", "folder", "getRes", "Lcom/tencent/mm/plugin/emojicapture/api/IEmojiStickerRes;", "getVideoLutFileDir", "getYtDetectModelBackupFileDir", "getYtDetectModelFileDir", "initCheck", "initLibrary", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture */
public final class PluginEmojiCapture extends C7597f implements C1671c, C27791b {
    private static final int MIN_STORAGE_SIZE = 52428800;
    private static final String TAG = TAG;
    private static final String lhB = lhB;
    private static final String lhC = lhC;
    private static final String lhD = lhD;
    public static final C20427a lhE = new C20427a();
    private boolean bZi;
    private final String eZe = "MicroMsg.PluginEmojiCapture";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture$Companion;", "", "()V", "MIN_STORAGE_SIZE", "", "getMIN_STORAGE_SIZE", "()I", "TAG", "", "VIDEO_LUT_FILE_DIR", "getVIDEO_LUT_FILE_DIR", "()Ljava/lang/String;", "YT_MODEL_BACKUP_FILE_DIR", "getYT_MODEL_BACKUP_FILE_DIR", "YT_MODEL_FILE_DIR", "getYT_MODEL_FILE_DIR", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture$a */
    public static final class C20427a {
        private C20427a() {
        }

        public /* synthetic */ C20427a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture$d */
    static final class C38904d implements Runnable {
        final /* synthetic */ PluginEmojiCapture lhG;

        C38904d(PluginEmojiCapture pluginEmojiCapture) {
            this.lhG = pluginEmojiCapture;
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.m2504i(2619);
            C4990ab.m7416i(this.lhG.eZe, "initLibrary: on connect");
            C20437a c20437a = EmojiCaptureProxy.lkM;
            C1427q.m3050ku(EmojiCaptureProxy.lkL.getDeviceInfoConfig());
            if (C6163u.m9833I(Build.MODEL, "OPPO R9tm", true) || C1427q.etj.etO == 1 || C1443d.m3067fP(21)) {
                C4990ab.m7416i(this.lhG.eZe, "use small model");
                FabbyManager.USE_SMALL_MODEL = true;
                FabbyManager.USE_SMALL_IMAGE = true;
            }
            c20437a = EmojiCaptureProxy.lkM;
            int useGpuSegment = EmojiCaptureProxy.lkL.getUseGpuSegment();
            C20437a c20437a2 = EmojiCaptureProxy.lkM;
            if (EmojiCaptureProxy.lkL.getUseGpuSegment() > 0) {
                C4990ab.m7416i(this.lhG.eZe, "choose gpu segment. x ".concat(String.valueOf(useGpuSegment)));
                FabbyManager.sChooseGPU_Segment = useGpuSegment == 1;
            }
            useGpuSegment = C1427q.etj.etP;
            if (useGpuSegment != -1) {
                C4990ab.m7416i(this.lhG.eZe, "choose gpu segment ".concat(String.valueOf(useGpuSegment)));
                if (useGpuSegment != 1) {
                    z = false;
                }
                FabbyManager.sChooseGPU_Segment = z;
            }
            c20437a = EmojiCaptureProxy.lkM;
            C20437a.bnM();
            AppMethodBeat.m2505o(2619);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture$b */
    static final class C38905b implements OnDismissListener {
        final /* synthetic */ C27790a lhF;

        C38905b(C27790a c27790a) {
            this.lhF = c27790a;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(2617);
            this.lhF.mo35707gA(true);
            AppMethodBeat.m2505o(2617);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Ljava/io/InputStream;", "bitmapRes", "", "kotlin.jvm.PlatformType", "getInputStream"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture$c */
    static final class C38906c implements GetInputStream {
        final /* synthetic */ PluginEmojiCapture lhG;

        C38906c(PluginEmojiCapture pluginEmojiCapture) {
            this.lhG = pluginEmojiCapture;
        }

        public final InputStream getInputStream(String str) {
            InputStream open;
            AppMethodBeat.m2504i(2618);
            C4990ab.m7416i(this.lhG.eZe, "get res: ".concat(String.valueOf(str)));
            Context context = C4996ah.getContext();
            C25052j.m39375o(context, "MMApplicationContext.getContext()");
            try {
                open = context.getAssets().open("raw" + File.separator + str);
            } catch (Exception e) {
                C4990ab.m7412e(this.lhG.eZe, "cannot find res ".concat(String.valueOf(str)));
                open = null;
            } finally {
                AppMethodBeat.m2505o(2618);
            }
            return open;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture$e */
    static final class C38907e implements OnClickListener {
        final /* synthetic */ Context jWS;

        C38907e(Context context) {
            this.jWS = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(2620);
            Intent intent = new Intent();
            intent.putExtra("key_emoji_panel_type", 1);
            C25985d.m41467b(this.jWS, "emoji", ".ui.EmojiCustomUI", intent);
            AppMethodBeat.m2505o(2620);
        }
    }

    static {
        AppMethodBeat.m2504i(2634);
        AppMethodBeat.m2505o(2634);
    }

    public final boolean isInit() {
        return this.bZi;
    }

    public final void setInit(boolean z) {
        this.bZi = z;
    }

    public final String name() {
        return "plugin-emojicapture";
    }

    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(2621);
        C4990ab.m7416i(this.eZe, "Plugin EmojiCapture Execute");
        Boolean valueOf = c1681g != null ? Boolean.valueOf(c1681g.mo5183lQ(":tools")) : null;
        if (valueOf == null) {
            C25052j.dWJ();
        }
        if (valueOf.booleanValue()) {
            initCheck();
        }
        AppMethodBeat.m2505o(2621);
    }

    private final void initCheck() {
        AppMethodBeat.m2504i(2622);
        if (!this.bZi) {
            int i = -1;
            try {
                initLibrary();
                VideoModule.init(C4996ah.getContext(), getVideoLutFileDir(), getYtDetectModelFileDir(), getYtDetectModelBackupFileDir());
                ResourcePathMapper.init(MODE.LOCAL);
                FilterUtils.checkLibraryInit();
                i = YTCommonInterface.initAuth(C4996ah.getContext(), "rel_wechat.lic", 0, false);
                C4990ab.m7417i(this.eZe, "init VideoModule initAuth: %s", Integer.valueOf(i));
            } catch (UnsatisfiedLinkError e) {
                C4990ab.printErrStackTrace(this.eZe, e, "init error", new Object[0]);
            }
            if (i != 0) {
                EmojiCaptureReporter.m66038up(17);
                C34007d c34007d = C34007d.lhz;
                C34007d.bnk();
                this.bZi = false;
                AppMethodBeat.m2505o(2622);
                return;
            }
            FilterRawGet.setGetInputStream(new C38906c(this));
            try {
                int a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_emoji_sdk_enablelog, 1);
                C4990ab.m7416i(this.eZe, "enableLog:".concat(String.valueOf(a)));
                if (a == 0) {
                    C4990ab.m7416i(this.eZe, "disable renderUtils log");
                    C41106g.dSP();
                }
            } catch (Exception e2) {
                C4990ab.printErrStackTrace(this.eZe, e2, "get enable log error", new Object[0]);
            }
            this.bZi = true;
        }
        AppMethodBeat.m2505o(2622);
    }

    private final void initLibrary() {
        AppMethodBeat.m2504i(2623);
        C4990ab.m7416i(this.eZe, "init load pt library");
        C1449k.m3079a("image_filter_common", PluginEmojiCapture.class.getClassLoader());
        C1449k.m3079a("image_filter_gpu", PluginEmojiCapture.class.getClassLoader());
        C1449k.m3079a("format_convert", PluginEmojiCapture.class.getClassLoader());
        C1449k.m3079a("YTCommon", PluginEmojiCapture.class.getClassLoader());
        C1449k.m3079a("YTFaceTrackPro", PluginEmojiCapture.class.getClassLoader());
        C1449k.m3079a("algo_youtu_jni", PluginEmojiCapture.class.getClassLoader());
        C1449k.m3079a("pitu_tools", PluginEmojiCapture.class.getClassLoader());
        C20437a c20437a = EmojiCaptureProxy.lkM;
        C20437a.bnL();
        c20437a = EmojiCaptureProxy.lkM;
        C46607d serverProxy = EmojiCaptureProxy.lkL.getServerProxy();
        if (serverProxy != null) {
            serverProxy.connect(new C38904d(this));
            AppMethodBeat.m2505o(2623);
            return;
        }
        AppMethodBeat.m2505o(2623);
    }

    public final void preCheck(Context context, int i, C27790a c27790a) {
        AppMethodBeat.m2504i(2624);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c27790a, "onResult");
        C25779b.afY();
        C25779b.aga();
        if (!cameraCheck(context) || !overSizeCheck(context)) {
            c27790a.mo35707gA(false);
            AppMethodBeat.m2505o(2624);
        } else if (i != 2) {
            c27790a.mo35707gA(true);
            AppMethodBeat.m2505o(2624);
        } else {
            firstOpenCheck(context, c27790a);
            AppMethodBeat.m2505o(2624);
        }
    }

    public final C42969a getRes() {
        return C45865e.lii;
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(2625);
        C4990ab.m7416i(this.eZe, "onAccountInitialized: ");
        C44042b.m79163a(new C2961b(), "//emojicapture");
        C11613g c11613g = C11613g.lik;
        C11613g.init();
        AppMethodBeat.m2505o(2625);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(2626);
        C4990ab.m7416i(this.eZe, "onAccountRelease: ");
        C44042b.m79162N("//emojicapture");
        C11613g c11613g = C11613g.lik;
        C11613g.destroy();
        AppMethodBeat.m2505o(2626);
    }

    private final void firstOpenCheck(Context context, C27790a c27790a) {
        AppMethodBeat.m2504i(2627);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object i = RP.mo5239Ry().mo16822i(C5127a.USERINFO_EMOJI_CAPTURE_OPENED_BOOLEAN);
        if (i != null && (i instanceof Boolean) && ((Boolean) i).booleanValue()) {
            c27790a.mo35707gA(true);
            AppMethodBeat.m2505o(2627);
            return;
        }
        C25779b afY = C25779b.afY();
        C25052j.m39375o(afY, "FontResLogic.getInstance()");
        if (!afY.afZ()) {
            C7060h.pYm.mo15421z(933, 2);
        }
        new C5652a(context).mo11446PV(C25738R.string.b60).mo11459a(BitmapFactory.decodeResource(context.getResources(), C25738R.drawable.emoji_capture_first_open_notice), false, 0).mo11450PZ(C25738R.string.b5z).mo11453Qc(C25738R.string.b5x).mo11458a((OnDismissListener) new C38905b(c27790a)).aMb().show();
        RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_EMOJI_CAPTURE_OPENED_BOOLEAN, Boolean.TRUE);
        C4990ab.m7416i(this.eZe, "first open check false");
        AppMethodBeat.m2505o(2627);
    }

    private final boolean overSizeCheck(Context context) {
        AppMethodBeat.m2504i(2628);
        C32498b c32498b = C32498b.eyD;
        if (C32498b.m53214OF()) {
            new C5652a(context).mo11446PV(C25738R.string.b64).mo11450PZ(C25738R.string.b63).mo11453Qc(C25738R.string.b62).mo11457a((OnClickListener) new C38907e(context)).mo11454Qd(C25738R.string.b61).aMb().show();
            C4990ab.m7416i(this.eZe, "over size check false");
            AppMethodBeat.m2505o(2628);
            return false;
        }
        AppMethodBeat.m2505o(2628);
        return true;
    }

    private final boolean cameraCheck(Context context) {
        AppMethodBeat.m2504i(2629);
        if (C14034e.m22169bI(context) || C14034e.m22170bJ(context) || C17981e.m28296bH(context)) {
            C4990ab.m7416i(this.eZe, "camera check false");
            AppMethodBeat.m2505o(2629);
            return false;
        }
        AppMethodBeat.m2505o(2629);
        return true;
    }

    public final String getVideoLutFileDir() {
        AppMethodBeat.m2504i(2630);
        Context context = C4996ah.getContext();
        C25052j.m39375o(context, "MMApplicationContext.getContext()");
        String path = getExternalFilesDir(context, lhB).getPath();
        C25052j.m39375o(path, "getExternalFilesDir(MMAp… VIDEO_LUT_FILE_DIR).path");
        AppMethodBeat.m2505o(2630);
        return path;
    }

    public final String getYtDetectModelFileDir() {
        AppMethodBeat.m2504i(2631);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        C25052j.m39375o(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
        String path = externalStorageDirectory.getPath();
        File file = new File(path + File.separator + lhC);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        if (DeviceUtils.canWriteFile(file.getAbsolutePath())) {
            path = file.getAbsolutePath();
            C25052j.m39375o(path, "dir.absolutePath");
            AppMethodBeat.m2505o(2631);
            return path;
        }
        C25052j.m39375o(path, "root");
        AppMethodBeat.m2505o(2631);
        return path;
    }

    public final String getYtDetectModelBackupFileDir() {
        AppMethodBeat.m2504i(2632);
        Context context = C4996ah.getContext();
        C25052j.m39375o(context, "MMApplicationContext.getContext()");
        String path = getExternalFilesDir(context, lhD).getPath();
        C25052j.m39375o(path, "getExternalFilesDir(MMAp…DEL_BACKUP_FILE_DIR).path");
        AppMethodBeat.m2505o(2632);
        return path;
    }

    public final File getExternalFilesDir(Context context, String str) {
        String str2 = null;
        AppMethodBeat.m2504i(2633);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(str, "folder");
        if (DeviceUtils.isExternalStorageAvailable() && DeviceUtils.isExternalStorageSpaceEnough((long) MIN_STORAGE_SIZE)) {
            File externalFilesDir;
            String str3;
            try {
                externalFilesDir = context.getExternalFilesDir(null);
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.eZe, e, "", new Object[0]);
            }
            if (externalFilesDir == null) {
                str3 = "/Android/data/" + context.getPackageName() + "/files/";
            } else {
                str3 = externalFilesDir.getPath();
            }
            str2 = str3;
        }
        if (TextUtils.isEmpty(str2)) {
            File filesDir = context.getFilesDir();
            C25052j.m39375o(filesDir, "context.filesDir");
            str2 = filesDir.getPath();
        }
        File file = new File(str2 + File.separator + str);
        try {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            LogUtils.m50206e(e2);
        }
        AppMethodBeat.m2505o(2633);
        return file;
    }
}
