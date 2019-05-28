package com.tencent.mm.plugin.emojicapture.model;

import a.f.b.j;
import a.k.u;
import a.l;
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
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.util.FilterUtils;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.ResourcePathMapper.MODE;
import com.tencent.view.raw.FilterRawGet;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.File;
import java.io.InputStream;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001*B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0006H\u0016J\u0012\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010'\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0004\n\u0002\b\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "getExternalFilesDir", "Ljava/io/File;", "folder", "getRes", "Lcom/tencent/mm/plugin/emojicapture/api/IEmojiStickerRes;", "getVideoLutFileDir", "getYtDetectModelBackupFileDir", "getYtDetectModelFileDir", "initCheck", "initLibrary", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "Companion", "plugin-emojicapture_release"})
public final class PluginEmojiCapture extends f implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emojicapture.api.b {
    private static final int MIN_STORAGE_SIZE = 52428800;
    private static final String TAG = TAG;
    private static final String lhB = lhB;
    private static final String lhC = lhC;
    private static final String lhD = lhD;
    public static final a lhE = new a();
    private boolean bZi;
    private final String eZe = "MicroMsg.PluginEmojiCapture";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture$Companion;", "", "()V", "MIN_STORAGE_SIZE", "", "getMIN_STORAGE_SIZE", "()I", "TAG", "", "VIDEO_LUT_FILE_DIR", "getVIDEO_LUT_FILE_DIR", "()Ljava/lang/String;", "YT_MODEL_BACKUP_FILE_DIR", "getYT_MODEL_BACKUP_FILE_DIR", "YT_MODEL_FILE_DIR", "getYT_MODEL_FILE_DIR", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ PluginEmojiCapture lhG;

        d(PluginEmojiCapture pluginEmojiCapture) {
            this.lhG = pluginEmojiCapture;
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.i(2619);
            ab.i(this.lhG.eZe, "initLibrary: on connect");
            com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar = EmojiCaptureProxy.lkM;
            q.ku(EmojiCaptureProxy.lkL.getDeviceInfoConfig());
            if (u.I(Build.MODEL, "OPPO R9tm", true) || q.etj.etO == 1 || com.tencent.mm.compatible.util.d.fP(21)) {
                ab.i(this.lhG.eZe, "use small model");
                FabbyManager.USE_SMALL_MODEL = true;
                FabbyManager.USE_SMALL_IMAGE = true;
            }
            aVar = EmojiCaptureProxy.lkM;
            int useGpuSegment = EmojiCaptureProxy.lkL.getUseGpuSegment();
            com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar2 = EmojiCaptureProxy.lkM;
            if (EmojiCaptureProxy.lkL.getUseGpuSegment() > 0) {
                ab.i(this.lhG.eZe, "choose gpu segment. x ".concat(String.valueOf(useGpuSegment)));
                FabbyManager.sChooseGPU_Segment = useGpuSegment == 1;
            }
            useGpuSegment = q.etj.etP;
            if (useGpuSegment != -1) {
                ab.i(this.lhG.eZe, "choose gpu segment ".concat(String.valueOf(useGpuSegment)));
                if (useGpuSegment != 1) {
                    z = false;
                }
                FabbyManager.sChooseGPU_Segment = z;
            }
            aVar = EmojiCaptureProxy.lkM;
            com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a.bnM();
            AppMethodBeat.o(2619);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class b implements OnDismissListener {
        final /* synthetic */ com.tencent.mm.plugin.emojicapture.api.b.a lhF;

        b(com.tencent.mm.plugin.emojicapture.api.b.a aVar) {
            this.lhF = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(2617);
            this.lhF.gA(true);
            AppMethodBeat.o(2617);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Ljava/io/InputStream;", "bitmapRes", "", "kotlin.jvm.PlatformType", "getInputStream"})
    static final class c implements GetInputStream {
        final /* synthetic */ PluginEmojiCapture lhG;

        c(PluginEmojiCapture pluginEmojiCapture) {
            this.lhG = pluginEmojiCapture;
        }

        public final InputStream getInputStream(String str) {
            InputStream open;
            AppMethodBeat.i(2618);
            ab.i(this.lhG.eZe, "get res: ".concat(String.valueOf(str)));
            Context context = ah.getContext();
            j.o(context, "MMApplicationContext.getContext()");
            try {
                open = context.getAssets().open("raw" + File.separator + str);
            } catch (Exception e) {
                ab.e(this.lhG.eZe, "cannot find res ".concat(String.valueOf(str)));
                open = null;
            } finally {
                AppMethodBeat.o(2618);
            }
            return open;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class e implements OnClickListener {
        final /* synthetic */ Context jWS;

        e(Context context) {
            this.jWS = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(2620);
            Intent intent = new Intent();
            intent.putExtra("key_emoji_panel_type", 1);
            com.tencent.mm.bp.d.b(this.jWS, "emoji", ".ui.EmojiCustomUI", intent);
            AppMethodBeat.o(2620);
        }
    }

    static {
        AppMethodBeat.i(2634);
        AppMethodBeat.o(2634);
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

    public final void execute(g gVar) {
        AppMethodBeat.i(2621);
        ab.i(this.eZe, "Plugin EmojiCapture Execute");
        Boolean valueOf = gVar != null ? Boolean.valueOf(gVar.lQ(":tools")) : null;
        if (valueOf == null) {
            j.dWJ();
        }
        if (valueOf.booleanValue()) {
            initCheck();
        }
        AppMethodBeat.o(2621);
    }

    private final void initCheck() {
        AppMethodBeat.i(2622);
        if (!this.bZi) {
            int i = -1;
            try {
                initLibrary();
                VideoModule.init(ah.getContext(), getVideoLutFileDir(), getYtDetectModelFileDir(), getYtDetectModelBackupFileDir());
                ResourcePathMapper.init(MODE.LOCAL);
                FilterUtils.checkLibraryInit();
                i = YTCommonInterface.initAuth(ah.getContext(), "rel_wechat.lic", 0, false);
                ab.i(this.eZe, "init VideoModule initAuth: %s", Integer.valueOf(i));
            } catch (UnsatisfiedLinkError e) {
                ab.printErrStackTrace(this.eZe, e, "init error", new Object[0]);
            }
            if (i != 0) {
                EmojiCaptureReporter.up(17);
                d dVar = d.lhz;
                d.bnk();
                this.bZi = false;
                AppMethodBeat.o(2622);
                return;
            }
            FilterRawGet.setGetInputStream(new c(this));
            try {
                int a = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_emoji_sdk_enablelog, 1);
                ab.i(this.eZe, "enableLog:".concat(String.valueOf(a)));
                if (a == 0) {
                    ab.i(this.eZe, "disable renderUtils log");
                    com.tencent.view.g.dSP();
                }
            } catch (Exception e2) {
                ab.printErrStackTrace(this.eZe, e2, "get enable log error", new Object[0]);
            }
            this.bZi = true;
        }
        AppMethodBeat.o(2622);
    }

    private final void initLibrary() {
        AppMethodBeat.i(2623);
        ab.i(this.eZe, "init load pt library");
        k.a("image_filter_common", PluginEmojiCapture.class.getClassLoader());
        k.a("image_filter_gpu", PluginEmojiCapture.class.getClassLoader());
        k.a("format_convert", PluginEmojiCapture.class.getClassLoader());
        k.a("YTCommon", PluginEmojiCapture.class.getClassLoader());
        k.a("YTFaceTrackPro", PluginEmojiCapture.class.getClassLoader());
        k.a("algo_youtu_jni", PluginEmojiCapture.class.getClassLoader());
        k.a("pitu_tools", PluginEmojiCapture.class.getClassLoader());
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar = EmojiCaptureProxy.lkM;
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a.bnL();
        aVar = EmojiCaptureProxy.lkM;
        com.tencent.mm.remoteservice.d serverProxy = EmojiCaptureProxy.lkL.getServerProxy();
        if (serverProxy != null) {
            serverProxy.connect(new d(this));
            AppMethodBeat.o(2623);
            return;
        }
        AppMethodBeat.o(2623);
    }

    public final void preCheck(Context context, int i, com.tencent.mm.plugin.emojicapture.api.b.a aVar) {
        AppMethodBeat.i(2624);
        j.p(context, "context");
        j.p(aVar, "onResult");
        com.tencent.mm.ao.b.afY();
        com.tencent.mm.ao.b.aga();
        if (!cameraCheck(context) || !overSizeCheck(context)) {
            aVar.gA(false);
            AppMethodBeat.o(2624);
        } else if (i != 2) {
            aVar.gA(true);
            AppMethodBeat.o(2624);
        } else {
            firstOpenCheck(context, aVar);
            AppMethodBeat.o(2624);
        }
    }

    public final com.tencent.mm.plugin.emojicapture.api.a getRes() {
        return com.tencent.mm.plugin.emojicapture.model.a.e.lii;
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(2625);
        ab.i(this.eZe, "onAccountInitialized: ");
        com.tencent.mm.pluginsdk.cmd.b.a(new b(), "//emojicapture");
        com.tencent.mm.plugin.emojicapture.model.a.g gVar = com.tencent.mm.plugin.emojicapture.model.a.g.lik;
        com.tencent.mm.plugin.emojicapture.model.a.g.init();
        AppMethodBeat.o(2625);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(2626);
        ab.i(this.eZe, "onAccountRelease: ");
        com.tencent.mm.pluginsdk.cmd.b.N("//emojicapture");
        com.tencent.mm.plugin.emojicapture.model.a.g gVar = com.tencent.mm.plugin.emojicapture.model.a.g.lik;
        com.tencent.mm.plugin.emojicapture.model.a.g.destroy();
        AppMethodBeat.o(2626);
    }

    private final void firstOpenCheck(Context context, com.tencent.mm.plugin.emojicapture.api.b.a aVar) {
        AppMethodBeat.i(2627);
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        j.o(RP, "MMKernel.storage()");
        Object i = RP.Ry().i(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_OPENED_BOOLEAN);
        if (i != null && (i instanceof Boolean) && ((Boolean) i).booleanValue()) {
            aVar.gA(true);
            AppMethodBeat.o(2627);
            return;
        }
        com.tencent.mm.ao.b afY = com.tencent.mm.ao.b.afY();
        j.o(afY, "FontResLogic.getInstance()");
        if (!afY.afZ()) {
            h.pYm.z(933, 2);
        }
        new com.tencent.mm.ui.widget.a.c.a(context).PV(R.string.b60).a(BitmapFactory.decodeResource(context.getResources(), R.drawable.emoji_capture_first_open_notice), false, 0).PZ(R.string.b5z).Qc(R.string.b5x).a((OnDismissListener) new b(aVar)).aMb().show();
        RP = com.tencent.mm.kernel.g.RP();
        j.o(RP, "MMKernel.storage()");
        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_OPENED_BOOLEAN, Boolean.TRUE);
        ab.i(this.eZe, "first open check false");
        AppMethodBeat.o(2627);
    }

    private final boolean overSizeCheck(Context context) {
        AppMethodBeat.i(2628);
        com.tencent.mm.emoji.a.b bVar = com.tencent.mm.emoji.a.b.eyD;
        if (com.tencent.mm.emoji.a.b.OF()) {
            new com.tencent.mm.ui.widget.a.c.a(context).PV(R.string.b64).PZ(R.string.b63).Qc(R.string.b62).a((OnClickListener) new e(context)).Qd(R.string.b61).aMb().show();
            ab.i(this.eZe, "over size check false");
            AppMethodBeat.o(2628);
            return false;
        }
        AppMethodBeat.o(2628);
        return true;
    }

    private final boolean cameraCheck(Context context) {
        AppMethodBeat.i(2629);
        if (com.tencent.mm.plugin.voip.e.bI(context) || com.tencent.mm.plugin.voip.e.bJ(context) || com.tencent.mm.bg.e.bH(context)) {
            ab.i(this.eZe, "camera check false");
            AppMethodBeat.o(2629);
            return false;
        }
        AppMethodBeat.o(2629);
        return true;
    }

    public final String getVideoLutFileDir() {
        AppMethodBeat.i(2630);
        Context context = ah.getContext();
        j.o(context, "MMApplicationContext.getContext()");
        String path = getExternalFilesDir(context, lhB).getPath();
        j.o(path, "getExternalFilesDir(MMAp… VIDEO_LUT_FILE_DIR).path");
        AppMethodBeat.o(2630);
        return path;
    }

    public final String getYtDetectModelFileDir() {
        AppMethodBeat.i(2631);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        j.o(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
        String path = externalStorageDirectory.getPath();
        File file = new File(path + File.separator + lhC);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        if (DeviceUtils.canWriteFile(file.getAbsolutePath())) {
            path = file.getAbsolutePath();
            j.o(path, "dir.absolutePath");
            AppMethodBeat.o(2631);
            return path;
        }
        j.o(path, "root");
        AppMethodBeat.o(2631);
        return path;
    }

    public final String getYtDetectModelBackupFileDir() {
        AppMethodBeat.i(2632);
        Context context = ah.getContext();
        j.o(context, "MMApplicationContext.getContext()");
        String path = getExternalFilesDir(context, lhD).getPath();
        j.o(path, "getExternalFilesDir(MMAp…DEL_BACKUP_FILE_DIR).path");
        AppMethodBeat.o(2632);
        return path;
    }

    public final File getExternalFilesDir(Context context, String str) {
        String str2 = null;
        AppMethodBeat.i(2633);
        j.p(context, "context");
        j.p(str, "folder");
        if (DeviceUtils.isExternalStorageAvailable() && DeviceUtils.isExternalStorageSpaceEnough((long) MIN_STORAGE_SIZE)) {
            File externalFilesDir;
            String str3;
            try {
                externalFilesDir = context.getExternalFilesDir(null);
            } catch (Exception e) {
                ab.printErrStackTrace(this.eZe, e, "", new Object[0]);
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
            j.o(filesDir, "context.filesDir");
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
            LogUtils.e(e2);
        }
        AppMethodBeat.o(2633);
        return file;
    }
}
