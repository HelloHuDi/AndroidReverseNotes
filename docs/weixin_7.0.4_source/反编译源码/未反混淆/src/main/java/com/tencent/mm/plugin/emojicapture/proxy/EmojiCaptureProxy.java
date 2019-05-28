package com.tencent.mm.plugin.emojicapture.proxy;

import a.f.b.j;
import a.k.u;
import a.l;
import a.v;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.a.e.c;
import com.tencent.mm.vfs.e;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

@l(dWo = {1, 1, 13}, dWp = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0010\u0018\u0000 B2\u00020\u0001:\u0001BB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0006J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0006H\u0007J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001fH\u0007J\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\b\u0010#\u001a\u00020\u0006H\u0007J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006J\u0012\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020\u0006H\u0007J\u0006\u0010'\u001a\u00020\u0010J\b\u0010(\u001a\u00020\u0010H\u0007J\b\u0010)\u001a\u0004\u0018\u00010\u0006J\u0016\u0010*\u001a\u00020\f2\u0006\u0010%\u001a\u00020+2\u0006\u0010,\u001a\u00020\fJ\u0006\u0010-\u001a\u00020\fJ\b\u0010.\u001a\u00020\fH\u0007J\u0006\u0010/\u001a\u00020\u0010J\b\u00100\u001a\u00020\u0010H\u0007J!\u00101\u001a\u00020\u00162\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f03\"\u00020\u001fH\u0014¢\u0006\u0002\u00104J \u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0010H\u0016J\u0016\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u0018\u0010<\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0007J\u0006\u0010=\u001a\u00020\nJ\b\u0010>\u001a\u00020\nH\u0007J\u000e\u0010?\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010@\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0006\u0010A\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006C"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "RESULT_KEY", "", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "checkResUpdate", "", "subType", "", "version", "checkResUpdateRemote", "checkUseCPUCrop", "", "createEmojiInfo", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "createEmojiInfoRemote", "bundle", "Landroid/os/Bundle;", "deleteEmojiInfoByEnterTime", "timeEnter", "", "deleteEmojiInfoByEnterTimeRemote", "deleteEmojiInfoByMd5", "md5", "deleteEmojiInfoByMd5Remote", "getConfigStorage", "", "_key", "defval", "getDeviceInfoConfig", "getDeviceInfoConfigRemote", "getDynamicConfig", "key", "getDynamicConfigInMM", "getEnableAutoRotate", "getEnableAutoRotateRemote", "getForbidLensId", "getInt", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getUseGpuSegment", "getUseGpuSegmentRemote", "isSpringFestivalEnable", "isSpringFestivalEnableRemote", "objectsToBundle", "params", "", "([Ljava/lang/Object;)Landroid/os/Bundle;", "onCallback", "methodName", "data", "clientCall", "postUploadTask", "filePath", "mixingMd5", "postUploadTaskRemote", "showImitateDialog", "showImitateDialogRemote", "updateEmojiInfo", "updateEmojiInfoRemote", "useCPUCrop", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureProxy extends com.tencent.mm.remoteservice.a {
    private static int exv;
    private static boolean exw = true;
    private static EmojiCaptureProxy lkL = new EmojiCaptureProxy(new d(ah.getContext()));
    public static final a lkM = new a();
    private final String RESULT_KEY = "result_key";
    private final d ext;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class b implements c {
        public static final b lkN = new b();

        static {
            AppMethodBeat.i(2806);
            AppMethodBeat.o(2806);
        }

        b() {
        }

        public final void d(boolean z, String str) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;)V", "needCreate", "", "requestCount", "", "requestConnect", "", "tryRelease", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private static void a(EmojiCaptureProxy emojiCaptureProxy) {
            AppMethodBeat.i(2803);
            j.p(emojiCaptureProxy, "<set-?>");
            EmojiCaptureProxy.lkL = emojiCaptureProxy;
            AppMethodBeat.o(2803);
        }

        public static void bnL() {
            AppMethodBeat.i(2804);
            EmojiCaptureProxy.exv = EmojiCaptureProxy.exv + 1;
            if (EmojiCaptureProxy.exw) {
                EmojiCaptureProxy.exw = false;
                a(new EmojiCaptureProxy(new d(ah.getContext())));
            }
            AppMethodBeat.o(2804);
        }

        public static void bnM() {
            AppMethodBeat.i(2805);
            EmojiCaptureProxy.exv = EmojiCaptureProxy.exv - 1;
            if (EmojiCaptureProxy.exv <= 0) {
                EmojiCaptureProxy.exw = true;
                d serverProxy = EmojiCaptureProxy.lkL.getServerProxy();
                if (serverProxy != null) {
                    serverProxy.release();
                    AppMethodBeat.o(2805);
                    return;
                }
            }
            AppMethodBeat.o(2805);
        }
    }

    public EmojiCaptureProxy(d dVar) {
        super(dVar);
        this.ext = dVar;
    }

    public final d getServerProxy() {
        return this.ext;
    }

    static {
        AppMethodBeat.i(2837);
        AppMethodBeat.o(2837);
    }

    public final void createEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(2807);
        j.p(emojiInfo, "emojiInfo");
        ab.i("MicroMsg.EmojiCaptureProxy", "createEmojiInfo: " + emojiInfo.Aq());
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        REMOTE_CALL("createEmojiInfoRemote", bundle);
        AppMethodBeat.o(2807);
    }

    public final String getDynamicConfig(String str) {
        AppMethodBeat.i(2808);
        j.p(str, "key");
        Object REMOTE_CALL = REMOTE_CALL("getDynamicConfigInMM", str);
        ab.i("MicroMsg.EmojiCaptureProxy", "getDynamicConfig, key: %s, value: %s", str, REMOTE_CALL);
        String str2;
        if (REMOTE_CALL == null) {
            str2 = "";
            AppMethodBeat.o(2808);
            return str2;
        }
        str2 = (String) REMOTE_CALL;
        AppMethodBeat.o(2808);
        return str2;
    }

    public final boolean getEnableAutoRotate() {
        AppMethodBeat.i(2809);
        boolean j = j.j(REMOTE_CALL("getEnableAutoRotateRemote", new Object[0]), Boolean.TRUE);
        AppMethodBeat.o(2809);
        return j;
    }

    public final int getInt(com.tencent.mm.storage.ac.a aVar, int i) {
        AppMethodBeat.i(2810);
        j.p(aVar, "key");
        ab.i("MicroMsg.EmojiCaptureProxy", "getInt %s %s", aVar, Integer.valueOf(i));
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, Integer.valueOf(i));
        ab.i("MicroMsg.EmojiCaptureProxy", "getInt %s %s and get val %s", aVar, Integer.valueOf(i), REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(2810);
            return i;
        }
        i = bo.getInt(REMOTE_CALL.toString(), i);
        AppMethodBeat.o(2810);
        return i;
    }

    public final String getForbidLensId() {
        AppMethodBeat.i(2811);
        Object REMOTE_CALL = REMOTE_CALL("getDynamicConfigInMM", "EmotionSpringFestivalPendantBlockedIdList");
        if (REMOTE_CALL instanceof String) {
            String str = (String) REMOTE_CALL;
            AppMethodBeat.o(2811);
            return str;
        }
        AppMethodBeat.o(2811);
        return null;
    }

    public final boolean isSpringFestivalEnable() {
        AppMethodBeat.i(2812);
        boolean j = j.j(REMOTE_CALL("isSpringFestivalEnableRemote", new Object[0]), Boolean.TRUE);
        AppMethodBeat.o(2812);
        return j;
    }

    public final String getDeviceInfoConfig() {
        AppMethodBeat.i(2813);
        Object REMOTE_CALL = REMOTE_CALL("getDeviceInfoConfigRemote", new Object[0]);
        if (REMOTE_CALL instanceof String) {
            String str = (String) REMOTE_CALL;
            AppMethodBeat.o(2813);
            return str;
        }
        AppMethodBeat.o(2813);
        return null;
    }

    public final int getUseGpuSegment() {
        AppMethodBeat.i(2814);
        Object REMOTE_CALL = REMOTE_CALL("getUseGpuSegmentRemote", new Object[0]);
        if (REMOTE_CALL instanceof Integer) {
            int intValue = ((Number) REMOTE_CALL).intValue();
            AppMethodBeat.o(2814);
            return intValue;
        }
        AppMethodBeat.o(2814);
        return 0;
    }

    @f
    public final void createEmojiInfoRemote(Bundle bundle) {
        AppMethodBeat.i(2815);
        j.p(bundle, "bundle");
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
        ab.i("MicroMsg.EmojiCaptureProxy", "createEmojiInfoRemote: " + (emojiInfo != null ? emojiInfo.Aq() : null));
        if (emojiInfo != null) {
            com.tencent.mm.kernel.b.a M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiMgr().j(emojiInfo.Aq(), 0, EmojiInfo.zYS, emojiInfo.field_size);
            M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiMgr().updateEmojiInfo(emojiInfo);
            M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiMgr().q(emojiInfo);
            AppMethodBeat.o(2815);
            return;
        }
        EmojiCaptureReporter.up(31);
        com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
        com.tencent.mm.plugin.emojicapture.model.d.bnn();
        AppMethodBeat.o(2815);
    }

    public final void deleteEmojiInfoByMd5(String str) {
        AppMethodBeat.i(2816);
        j.p(str, "md5");
        ab.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfo: ".concat(String.valueOf(str)));
        REMOTE_CALL("deleteEmojiInfoByMd5Remote", str);
        AppMethodBeat.o(2816);
    }

    @f
    public final void deleteEmojiInfoByMd5Remote(String str) {
        AppMethodBeat.i(2817);
        j.p(str, "md5");
        ab.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByMd5Remote: ".concat(String.valueOf(str)));
        com.tencent.mm.kernel.b.a M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
        j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        at emojiStorageMgr = ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiStorageMgr();
        j.o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        emojiStorageMgr.aUp().aqj(str);
        AppMethodBeat.o(2817);
    }

    public final void deleteEmojiInfoByEnterTime(long j) {
        AppMethodBeat.i(2818);
        ab.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTime: ".concat(String.valueOf(j)));
        REMOTE_CALL("deleteEmojiInfoByEnterTimeRemote", Long.valueOf(j));
        AppMethodBeat.o(2818);
    }

    @f
    public final void deleteEmojiInfoByEnterTimeRemote(long j) {
        AppMethodBeat.i(2819);
        ab.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTimeRemote: ".concat(String.valueOf(j)));
        com.tencent.mm.kernel.b.a M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
        j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        at emojiStorageMgr = ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiStorageMgr();
        j.o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        emojiStorageMgr.aUp().mV(j);
        AppMethodBeat.o(2819);
    }

    public final void updateEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(2820);
        j.p(emojiInfo, "emojiInfo");
        ab.i("MicroMsg.EmojiCaptureProxy", "updateEmojiInfo: " + emojiInfo.Aq());
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        REMOTE_CALL("updateEmojiInfoRemote", bundle);
        AppMethodBeat.o(2820);
    }

    @f
    public final void updateEmojiInfoRemote(Bundle bundle) {
        AppMethodBeat.i(2821);
        j.p(bundle, "bundle");
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
        ab.i("MicroMsg.EmojiCaptureProxy", "updateEmojiInfoRemote: " + (emojiInfo != null ? emojiInfo.Aq() : null));
        if (emojiInfo != null) {
            com.tencent.mm.kernel.b.a M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiMgr().updateEmojiInfo(emojiInfo);
            AppMethodBeat.o(2821);
            return;
        }
        EmojiCaptureReporter.up(31);
        com.tencent.mm.plugin.emojicapture.model.d dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
        com.tencent.mm.plugin.emojicapture.model.d.bnn();
        AppMethodBeat.o(2821);
    }

    public final void postUploadTask(String str, String str2) {
        AppMethodBeat.i(2822);
        j.p(str, "filePath");
        j.p(str2, "mixingMd5");
        ab.i("MicroMsg.EmojiCaptureProxy", "postUploadTask: " + str + ", " + str2);
        REMOTE_CALL("postUploadTaskRemote", str, str2);
        AppMethodBeat.o(2822);
    }

    @f
    public final void postUploadTaskRemote(String str, String str2) {
        AppMethodBeat.i(2823);
        j.p(str, "filePath");
        j.p(str2, "mixingMd5");
        ab.i("MicroMsg.EmojiCaptureProxy", "postUploadTaskRemote: " + str + ", " + str2);
        int asZ = (int) e.asZ(str);
        com.tencent.mm.kernel.b.a M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
        j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiMgr().Jd(str2);
        if (Jd == null) {
            AppMethodBeat.o(2823);
        } else if (asZ <= 0) {
            Jd.a(com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_MIX_OUTPUT_EMPTY);
            Jd.a(com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_MIX_FAIL);
            M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiMgr().updateEmojiInfo(Jd);
            EmojiCaptureReporter.h(Jd.field_captureEnterTime, 4, Jd.field_captureScene);
            AppMethodBeat.o(2823);
        } else {
            String atg = e.atg(str);
            String str3 = EmojiInfo.dvg() + atg;
            e.aQ(str, str3);
            ab.i("MicroMsg.EmojiCaptureProxy", "upload file " + str3 + " length is " + asZ);
            M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            at emojiStorageMgr = ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiStorageMgr();
            j.o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr.aUp().aqj(Jd.Aq());
            Jd.vS(atg);
            Jd.a(com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_UPLOADING);
            Jd.setSize((int) e.asZ(str3));
            if (r.amp(str3)) {
                Jd.field_wxamMd5 = atg;
            }
            M = g.M(com.tencent.mm.plugin.emoji.b.d.class);
            j.o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            emojiStorageMgr = ((com.tencent.mm.plugin.emoji.b.d) M).getEmojiStorageMgr();
            j.o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr.aUp().E(Jd);
            com.tencent.mm.emoji.d.d dVar = com.tencent.mm.emoji.d.d.eAh;
            com.tencent.mm.emoji.d.d.k(Jd);
            AppMethodBeat.o(2823);
        }
    }

    public final boolean useCPUCrop() {
        AppMethodBeat.i(2824);
        ab.c("MicroMsg.EmojiCaptureProxy", "useCPUCrop", new Object[0]);
        Object REMOTE_CALL = REMOTE_CALL("checkUseCPUCrop", new Object[0]);
        if (REMOTE_CALL == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(2824);
            throw vVar;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.o(2824);
        return booleanValue;
    }

    @f
    public final boolean checkUseCPUCrop() {
        AppMethodBeat.i(2825);
        ab.c("MicroMsg.EmojiCaptureProxy", "checkUseCPUCrop", new Object[0]);
        boolean z = ((com.tencent.mm.plugin.emojicapture.b.a.a) com.tencent.mm.plugin.emojicapture.b.a.lhc.Uw()).fau;
        AppMethodBeat.o(2825);
        return z;
    }

    public final void checkResUpdate(int i, int i2) {
        AppMethodBeat.i(2826);
        REMOTE_CALL("checkResUpdateRemote", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(2826);
    }

    @f
    public final void checkResUpdateRemote(int i, int i2) {
        AppMethodBeat.i(2827);
        com.tencent.mm.plugin.emojicapture.model.a.g gVar = com.tencent.mm.plugin.emojicapture.model.a.g.lik;
        ab.i(com.tencent.mm.plugin.emojicapture.model.a.g.TAG, "checkResUpdate: ".concat(String.valueOf(i)));
        com.tencent.mm.pluginsdk.g.a.a.b.did();
        String gM = com.tencent.mm.pluginsdk.g.a.a.b.gM(59, i);
        if (e.ct(gM)) {
            com.tencent.mm.plugin.emojicapture.model.a.e eVar = com.tencent.mm.plugin.emojicapture.model.a.e.lii;
            bo.hU(gM, com.tencent.mm.plugin.emojicapture.model.a.e.bnA());
            com.tencent.mm.plugin.emojicapture.model.a.e eVar2 = com.tencent.mm.plugin.emojicapture.model.a.e.lii;
            if (com.tencent.mm.plugin.emojicapture.model.a.e.ux(i).ljI > i2) {
                com.tencent.mm.plugin.emojicapture.model.a.g.uy(i);
                AppMethodBeat.o(2827);
                return;
            }
            com.tencent.mm.pluginsdk.g.a.a.b.did();
            com.tencent.mm.pluginsdk.g.a.a.b.Ky(59);
            AppMethodBeat.o(2827);
            return;
        }
        com.tencent.mm.pluginsdk.g.a.a.b.did();
        com.tencent.mm.pluginsdk.g.a.a.b.Ky(59);
        AppMethodBeat.o(2827);
    }

    public final void showImitateDialog() {
        AppMethodBeat.i(2828);
        REMOTE_CALL("showImitateDialogRemote", new Object[0]);
        AppMethodBeat.o(2828);
    }

    @f
    public final void showImitateDialogRemote() {
        AppMethodBeat.i(2829);
        Context context = ah.getContext();
        j.o(context, "MMApplicationContext.getContext()");
        new com.tencent.mm.ui.widget.a.e.a(ah.getContext()).asL(context.getResources().getString(R.string.b5y)).Qg(R.string.b5x).b((c) b.lkN).show();
        AppMethodBeat.o(2829);
    }

    @f
    public final String getDynamicConfigInMM(String str) {
        AppMethodBeat.i(2830);
        j.p(str, "key");
        String value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue(str);
        AppMethodBeat.o(2830);
        return value;
    }

    @f
    public final boolean isSpringFestivalEnableRemote() {
        AppMethodBeat.i(2831);
        boolean isSpringFestivalEnable = com.tencent.mm.emoji.a.e.isSpringFestivalEnable();
        AppMethodBeat.o(2831);
        return isSpringFestivalEnable;
    }

    @f
    public final boolean getEnableAutoRotateRemote() {
        return q.etc.erC;
    }

    @f
    public final String getDeviceInfoConfigRemote() {
        AppMethodBeat.i(2832);
        String dur = g.RP().Rz().dur();
        j.o(dur, "storage().getServerCfgIn…RINFO_SERVER_CONFIG_INFO)");
        AppMethodBeat.o(2832);
        return dur;
    }

    @f
    public final Object getConfigStorage(int i, Object obj) {
        AppMethodBeat.i(2833);
        j.p(obj, "defval");
        ab.i("MicroMsg.EmojiCaptureProxy", "getConfigStorage, %s %s", ((com.tencent.mm.storage.ac.a[]) com.tencent.mm.storage.ac.a.class.getEnumConstants())[i], obj);
        Object obj2 = g.RP().Ry().get(r0, obj);
        AppMethodBeat.o(2833);
        return obj2;
    }

    @f
    public final int getUseGpuSegmentRemote() {
        int a;
        AppMethodBeat.i(2834);
        try {
            a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_emoji_segment_gpu, 1);
        } catch (Exception e) {
            a = 1;
        }
        AppMethodBeat.o(2834);
        return a;
    }

    public final Bundle objectsToBundle(Object... objArr) {
        AppMethodBeat.i(2835);
        j.p(objArr, "params");
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            String valueOf;
            Object obj;
            v vVar;
            if (objArr[i] instanceof Bundle) {
                valueOf = String.valueOf(i);
                obj = objArr[i];
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type android.os.Bundle");
                    AppMethodBeat.o(2835);
                    throw vVar;
                }
                bundle.putBundle(valueOf, (Bundle) obj);
            } else if (objArr[i] instanceof Parcelable) {
                valueOf = String.valueOf(i);
                obj = objArr[i];
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type android.os.Parcelable");
                    AppMethodBeat.o(2835);
                    throw vVar;
                }
                bundle.putParcelable(valueOf, (Parcelable) obj);
            } else if (objArr[i] instanceof com.tencent.mm.storage.ac.a) {
                valueOf = "MicroMsg.EmojiCaptureProxy";
                String str = "objectsToBundle: %s";
                Object[] objArr2 = new Object[1];
                obj = objArr[i];
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
                    AppMethodBeat.o(2835);
                    throw vVar;
                }
                objArr2[0] = Integer.valueOf(((com.tencent.mm.storage.ac.a) obj).ordinal());
                ab.i(valueOf, str, objArr2);
                valueOf = String.valueOf(i);
                obj = objArr[i];
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
                    AppMethodBeat.o(2835);
                    throw vVar;
                }
                bundle.putInt(valueOf, ((com.tencent.mm.storage.ac.a) obj).ordinal());
            } else {
                valueOf = String.valueOf(i);
                obj = objArr[i];
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type java.io.Serializable");
                    AppMethodBeat.o(2835);
                    throw vVar;
                }
                bundle.putSerializable(valueOf, (Serializable) obj);
            }
        }
        AppMethodBeat.o(2835);
        return bundle;
    }

    public final void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(2836);
        j.p(str, "methodName");
        j.p(bundle, "data");
        ab.i("MicroMsg.EmojiCaptureProxy", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                j.o(method2, "mth");
                if (u.I(method2.getName(), str, true)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? com.tencent.mm.remoteservice.e.class : f.class)) {
                    Object[] args = getArgs(bundle);
                    Object invoke = method.invoke(this, Arrays.copyOf(args, args.length));
                    if ((j.j(method.getReturnType(), Void.TYPE) ^ 1) != 0) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable(this.RESULT_KEY, (Parcelable) invoke);
                            AppMethodBeat.o(2836);
                            return;
                        }
                        if (j.j("getConfigStorage", str)) {
                            ab.i("MicroMsg.EmojiCaptureProxy", "put result as Serializable: %s", (Serializable) invoke);
                        }
                        bundle.putSerializable(this.RESULT_KEY, (Serializable) invoke);
                        AppMethodBeat.o(2836);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.EmojiCaptureProxy", "exception:%s", bo.l(e));
        }
        AppMethodBeat.o(2836);
    }
}
