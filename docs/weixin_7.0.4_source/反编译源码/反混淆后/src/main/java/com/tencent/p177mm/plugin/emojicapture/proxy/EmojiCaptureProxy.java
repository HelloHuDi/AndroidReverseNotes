package com.tencent.p177mm.plugin.emojicapture.proxy;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.emoji.p228d.C37677d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C11613g;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C45865e;
import com.tencent.p177mm.plugin.emojicapture.p1253b.C27792a;
import com.tencent.p177mm.plugin.emojicapture.p1253b.C27792a.C20425a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C40602e;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30301b;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30302a;
import com.tencent.p177mm.vfs.C5730e;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0010\u0018\u0000 B2\u00020\u0001:\u0001BB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0006J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0006H\u0007J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001fH\u0007J\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\b\u0010#\u001a\u00020\u0006H\u0007J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006J\u0012\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020\u0006H\u0007J\u0006\u0010'\u001a\u00020\u0010J\b\u0010(\u001a\u00020\u0010H\u0007J\b\u0010)\u001a\u0004\u0018\u00010\u0006J\u0016\u0010*\u001a\u00020\f2\u0006\u0010%\u001a\u00020+2\u0006\u0010,\u001a\u00020\fJ\u0006\u0010-\u001a\u00020\fJ\b\u0010.\u001a\u00020\fH\u0007J\u0006\u0010/\u001a\u00020\u0010J\b\u00100\u001a\u00020\u0010H\u0007J!\u00101\u001a\u00020\u00162\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f03\"\u00020\u001fH\u0014¢\u0006\u0002\u00104J \u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0010H\u0016J\u0016\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u0018\u0010<\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0007J\u0006\u0010=\u001a\u00020\nJ\b\u0010>\u001a\u00020\nH\u0007J\u000e\u0010?\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010@\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0006\u0010A\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006C"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "RESULT_KEY", "", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "checkResUpdate", "", "subType", "", "version", "checkResUpdateRemote", "checkUseCPUCrop", "", "createEmojiInfo", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "createEmojiInfoRemote", "bundle", "Landroid/os/Bundle;", "deleteEmojiInfoByEnterTime", "timeEnter", "", "deleteEmojiInfoByEnterTimeRemote", "deleteEmojiInfoByMd5", "md5", "deleteEmojiInfoByMd5Remote", "getConfigStorage", "", "_key", "defval", "getDeviceInfoConfig", "getDeviceInfoConfigRemote", "getDynamicConfig", "key", "getDynamicConfigInMM", "getEnableAutoRotate", "getEnableAutoRotateRemote", "getForbidLensId", "getInt", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getUseGpuSegment", "getUseGpuSegmentRemote", "isSpringFestivalEnable", "isSpringFestivalEnableRemote", "objectsToBundle", "params", "", "([Ljava/lang/Object;)Landroid/os/Bundle;", "onCallback", "methodName", "data", "clientCall", "postUploadTask", "filePath", "mixingMd5", "postUploadTaskRemote", "showImitateDialog", "showImitateDialogRemote", "updateEmojiInfo", "updateEmojiInfoRemote", "useCPUCrop", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy */
public final class EmojiCaptureProxy extends C31577a {
    private static int exv;
    private static boolean exw = true;
    private static EmojiCaptureProxy lkL = new EmojiCaptureProxy(new C46607d(C4996ah.getContext()));
    public static final C20437a lkM = new C20437a();
    private final String RESULT_KEY = "result_key";
    private final C46607d ext;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy$b */
    static final class C6848b implements C5662c {
        public static final C6848b lkN = new C6848b();

        static {
            AppMethodBeat.m2504i(2806);
            AppMethodBeat.m2505o(2806);
        }

        C6848b() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;)V", "needCreate", "", "requestCount", "", "requestConnect", "", "tryRelease", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy$a */
    public static final class C20437a {
        private C20437a() {
        }

        public /* synthetic */ C20437a(byte b) {
            this();
        }

        /* renamed from: a */
        private static void m31590a(EmojiCaptureProxy emojiCaptureProxy) {
            AppMethodBeat.m2504i(2803);
            C25052j.m39376p(emojiCaptureProxy, "<set-?>");
            EmojiCaptureProxy.lkL = emojiCaptureProxy;
            AppMethodBeat.m2505o(2803);
        }

        public static void bnL() {
            AppMethodBeat.m2504i(2804);
            EmojiCaptureProxy.exv = EmojiCaptureProxy.exv + 1;
            if (EmojiCaptureProxy.exw) {
                EmojiCaptureProxy.exw = false;
                C20437a.m31590a(new EmojiCaptureProxy(new C46607d(C4996ah.getContext())));
            }
            AppMethodBeat.m2505o(2804);
        }

        public static void bnM() {
            AppMethodBeat.m2504i(2805);
            EmojiCaptureProxy.exv = EmojiCaptureProxy.exv - 1;
            if (EmojiCaptureProxy.exv <= 0) {
                EmojiCaptureProxy.exw = true;
                C46607d serverProxy = EmojiCaptureProxy.lkL.getServerProxy();
                if (serverProxy != null) {
                    serverProxy.release();
                    AppMethodBeat.m2505o(2805);
                    return;
                }
            }
            AppMethodBeat.m2505o(2805);
        }
    }

    public EmojiCaptureProxy(C46607d c46607d) {
        super(c46607d);
        this.ext = c46607d;
    }

    public final C46607d getServerProxy() {
        return this.ext;
    }

    static {
        AppMethodBeat.m2504i(2837);
        AppMethodBeat.m2505o(2837);
    }

    public final void createEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(2807);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "createEmojiInfo: " + emojiInfo.mo20410Aq());
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        REMOTE_CALL("createEmojiInfoRemote", bundle);
        AppMethodBeat.m2505o(2807);
    }

    public final String getDynamicConfig(String str) {
        AppMethodBeat.m2504i(2808);
        C25052j.m39376p(str, "key");
        Object REMOTE_CALL = REMOTE_CALL("getDynamicConfigInMM", str);
        C4990ab.m7417i("MicroMsg.EmojiCaptureProxy", "getDynamicConfig, key: %s, value: %s", str, REMOTE_CALL);
        String str2;
        if (REMOTE_CALL == null) {
            str2 = "";
            AppMethodBeat.m2505o(2808);
            return str2;
        }
        str2 = (String) REMOTE_CALL;
        AppMethodBeat.m2505o(2808);
        return str2;
    }

    public final boolean getEnableAutoRotate() {
        AppMethodBeat.m2504i(2809);
        boolean j = C25052j.m39373j(REMOTE_CALL("getEnableAutoRotateRemote", new Object[0]), Boolean.TRUE);
        AppMethodBeat.m2505o(2809);
        return j;
    }

    public final int getInt(C5127a c5127a, int i) {
        AppMethodBeat.m2504i(2810);
        C25052j.m39376p(c5127a, "key");
        C4990ab.m7417i("MicroMsg.EmojiCaptureProxy", "getInt %s %s", c5127a, Integer.valueOf(i));
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", c5127a, Integer.valueOf(i));
        C4990ab.m7417i("MicroMsg.EmojiCaptureProxy", "getInt %s %s and get val %s", c5127a, Integer.valueOf(i), REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(2810);
            return i;
        }
        i = C5046bo.getInt(REMOTE_CALL.toString(), i);
        AppMethodBeat.m2505o(2810);
        return i;
    }

    public final String getForbidLensId() {
        AppMethodBeat.m2504i(2811);
        Object REMOTE_CALL = REMOTE_CALL("getDynamicConfigInMM", "EmotionSpringFestivalPendantBlockedIdList");
        if (REMOTE_CALL instanceof String) {
            String str = (String) REMOTE_CALL;
            AppMethodBeat.m2505o(2811);
            return str;
        }
        AppMethodBeat.m2505o(2811);
        return null;
    }

    public final boolean isSpringFestivalEnable() {
        AppMethodBeat.m2504i(2812);
        boolean j = C25052j.m39373j(REMOTE_CALL("isSpringFestivalEnableRemote", new Object[0]), Boolean.TRUE);
        AppMethodBeat.m2505o(2812);
        return j;
    }

    public final String getDeviceInfoConfig() {
        AppMethodBeat.m2504i(2813);
        Object REMOTE_CALL = REMOTE_CALL("getDeviceInfoConfigRemote", new Object[0]);
        if (REMOTE_CALL instanceof String) {
            String str = (String) REMOTE_CALL;
            AppMethodBeat.m2505o(2813);
            return str;
        }
        AppMethodBeat.m2505o(2813);
        return null;
    }

    public final int getUseGpuSegment() {
        AppMethodBeat.m2504i(2814);
        Object REMOTE_CALL = REMOTE_CALL("getUseGpuSegmentRemote", new Object[0]);
        if (REMOTE_CALL instanceof Integer) {
            int intValue = ((Number) REMOTE_CALL).intValue();
            AppMethodBeat.m2505o(2814);
            return intValue;
        }
        AppMethodBeat.m2505o(2814);
        return 0;
    }

    @C46608f
    public final void createEmojiInfoRemote(Bundle bundle) {
        AppMethodBeat.m2504i(2815);
        C25052j.m39376p(bundle, "bundle");
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
        C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "createEmojiInfoRemote: " + (emojiInfo != null ? emojiInfo.mo20410Aq() : null));
        if (emojiInfo != null) {
            C1677a M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((C6835d) M).getEmojiMgr().mo35651j(emojiInfo.mo20410Aq(), 0, EmojiInfo.zYS, emojiInfo.field_size);
            M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((C6835d) M).getEmojiMgr().updateEmojiInfo(emojiInfo);
            M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((C6835d) M).getEmojiMgr().mo35661q(emojiInfo);
            AppMethodBeat.m2505o(2815);
            return;
        }
        EmojiCaptureReporter.m66038up(31);
        C34007d c34007d = C34007d.lhz;
        C34007d.bnn();
        AppMethodBeat.m2505o(2815);
    }

    public final void deleteEmojiInfoByMd5(String str) {
        AppMethodBeat.m2504i(2816);
        C25052j.m39376p(str, "md5");
        C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfo: ".concat(String.valueOf(str)));
        REMOTE_CALL("deleteEmojiInfoByMd5Remote", str);
        AppMethodBeat.m2505o(2816);
    }

    @C46608f
    public final void deleteEmojiInfoByMd5Remote(String str) {
        AppMethodBeat.m2504i(2817);
        C25052j.m39376p(str, "md5");
        C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByMd5Remote: ".concat(String.valueOf(str)));
        C1677a M = C1720g.m3530M(C6835d.class);
        C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        C23505at emojiStorageMgr = ((C6835d) M).getEmojiStorageMgr();
        C25052j.m39375o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        emojiStorageMgr.aUp().aqj(str);
        AppMethodBeat.m2505o(2817);
    }

    public final void deleteEmojiInfoByEnterTime(long j) {
        AppMethodBeat.m2504i(2818);
        C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTime: ".concat(String.valueOf(j)));
        REMOTE_CALL("deleteEmojiInfoByEnterTimeRemote", Long.valueOf(j));
        AppMethodBeat.m2505o(2818);
    }

    @C46608f
    public final void deleteEmojiInfoByEnterTimeRemote(long j) {
        AppMethodBeat.m2504i(2819);
        C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTimeRemote: ".concat(String.valueOf(j)));
        C1677a M = C1720g.m3530M(C6835d.class);
        C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        C23505at emojiStorageMgr = ((C6835d) M).getEmojiStorageMgr();
        C25052j.m39375o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        emojiStorageMgr.aUp().mo48588mV(j);
        AppMethodBeat.m2505o(2819);
    }

    public final void updateEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(2820);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "updateEmojiInfo: " + emojiInfo.mo20410Aq());
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        REMOTE_CALL("updateEmojiInfoRemote", bundle);
        AppMethodBeat.m2505o(2820);
    }

    @C46608f
    public final void updateEmojiInfoRemote(Bundle bundle) {
        AppMethodBeat.m2504i(2821);
        C25052j.m39376p(bundle, "bundle");
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
        C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "updateEmojiInfoRemote: " + (emojiInfo != null ? emojiInfo.mo20410Aq() : null));
        if (emojiInfo != null) {
            C1677a M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((C6835d) M).getEmojiMgr().updateEmojiInfo(emojiInfo);
            AppMethodBeat.m2505o(2821);
            return;
        }
        EmojiCaptureReporter.m66038up(31);
        C34007d c34007d = C34007d.lhz;
        C34007d.bnn();
        AppMethodBeat.m2505o(2821);
    }

    public final void postUploadTask(String str, String str2) {
        AppMethodBeat.m2504i(2822);
        C25052j.m39376p(str, "filePath");
        C25052j.m39376p(str2, "mixingMd5");
        C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "postUploadTask: " + str + ", " + str2);
        REMOTE_CALL("postUploadTaskRemote", str, str2);
        AppMethodBeat.m2505o(2822);
    }

    @C46608f
    public final void postUploadTaskRemote(String str, String str2) {
        AppMethodBeat.m2504i(2823);
        C25052j.m39376p(str, "filePath");
        C25052j.m39376p(str2, "mixingMd5");
        C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "postUploadTaskRemote: " + str + ", " + str2);
        int asZ = (int) C5730e.asZ(str);
        C1677a M = C1720g.m3530M(C6835d.class);
        C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
        EmojiInfo Jd = ((C6835d) M).getEmojiMgr().mo35596Jd(str2);
        if (Jd == null) {
            AppMethodBeat.m2505o(2823);
        } else if (asZ <= 0) {
            Jd.mo48511a(C30301b.ERR_MIX_OUTPUT_EMPTY);
            Jd.mo48510a(C30302a.STATUS_MIX_FAIL);
            M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((C6835d) M).getEmojiMgr().updateEmojiInfo(Jd);
            EmojiCaptureReporter.m66037h(Jd.field_captureEnterTime, 4, Jd.field_captureScene);
            AppMethodBeat.m2505o(2823);
        } else {
            String atg = C5730e.atg(str);
            String str3 = EmojiInfo.dvg() + atg;
            C5730e.m8623aQ(str, str3);
            C4990ab.m7416i("MicroMsg.EmojiCaptureProxy", "upload file " + str3 + " length is " + asZ);
            M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            C23505at emojiStorageMgr = ((C6835d) M).getEmojiStorageMgr();
            C25052j.m39375o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr.aUp().aqj(Jd.mo20410Aq());
            Jd.mo48550vS(atg);
            Jd.mo48510a(C30302a.STATUS_UPLOADING);
            Jd.setSize((int) C5730e.asZ(str3));
            if (C5063r.amp(str3)) {
                Jd.field_wxamMd5 = atg;
            }
            M = C1720g.m3530M(C6835d.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginEmoji::class.java)");
            emojiStorageMgr = ((C6835d) M).getEmojiStorageMgr();
            C25052j.m39375o(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
            emojiStorageMgr.aUp().mo48553E(Jd);
            C37677d c37677d = C37677d.eAh;
            C37677d.m63711k(Jd);
            AppMethodBeat.m2505o(2823);
        }
    }

    public final boolean useCPUCrop() {
        AppMethodBeat.m2504i(2824);
        C4990ab.m7409c("MicroMsg.EmojiCaptureProxy", "useCPUCrop", new Object[0]);
        Object REMOTE_CALL = REMOTE_CALL("checkUseCPUCrop", new Object[0]);
        if (REMOTE_CALL == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.m2505o(2824);
            throw c44941v;
        }
        boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
        AppMethodBeat.m2505o(2824);
        return booleanValue;
    }

    @C46608f
    public final boolean checkUseCPUCrop() {
        AppMethodBeat.m2504i(2825);
        C4990ab.m7409c("MicroMsg.EmojiCaptureProxy", "checkUseCPUCrop", new Object[0]);
        boolean z = ((C20425a) C27792a.lhc.mo53288Uw()).fau;
        AppMethodBeat.m2505o(2825);
        return z;
    }

    public final void checkResUpdate(int i, int i2) {
        AppMethodBeat.m2504i(2826);
        REMOTE_CALL("checkResUpdateRemote", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(2826);
    }

    @C46608f
    public final void checkResUpdateRemote(int i, int i2) {
        AppMethodBeat.m2504i(2827);
        C11613g c11613g = C11613g.lik;
        C4990ab.m7416i(C11613g.TAG, "checkResUpdate: ".concat(String.valueOf(i)));
        C14839b.did();
        String gM = C14839b.m23097gM(59, i);
        if (C5730e.m8628ct(gM)) {
            C45865e c45865e = C45865e.lii;
            C5046bo.m7570hU(gM, C45865e.bnA());
            C45865e c45865e2 = C45865e.lii;
            if (C45865e.m84970ux(i).ljI > i2) {
                C11613g.m19433uy(i);
                AppMethodBeat.m2505o(2827);
                return;
            }
            C14839b.did();
            C14839b.m23095Ky(59);
            AppMethodBeat.m2505o(2827);
            return;
        }
        C14839b.did();
        C14839b.m23095Ky(59);
        AppMethodBeat.m2505o(2827);
    }

    public final void showImitateDialog() {
        AppMethodBeat.m2504i(2828);
        REMOTE_CALL("showImitateDialogRemote", new Object[0]);
        AppMethodBeat.m2505o(2828);
    }

    @C46608f
    public final void showImitateDialogRemote() {
        AppMethodBeat.m2504i(2829);
        Context context = C4996ah.getContext();
        C25052j.m39375o(context, "MMApplicationContext.getContext()");
        new C5659a(C4996ah.getContext()).asL(context.getResources().getString(C25738R.string.b5y)).mo11509Qg(C25738R.string.b5x).mo11522b((C5662c) C6848b.lkN).show();
        AppMethodBeat.m2505o(2829);
    }

    @C46608f
    public final String getDynamicConfigInMM(String str) {
        AppMethodBeat.m2504i(2830);
        C25052j.m39376p(str, "key");
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue(str);
        AppMethodBeat.m2505o(2830);
        return value;
    }

    @C46608f
    public final boolean isSpringFestivalEnableRemote() {
        AppMethodBeat.m2504i(2831);
        boolean isSpringFestivalEnable = C26072e.isSpringFestivalEnable();
        AppMethodBeat.m2505o(2831);
        return isSpringFestivalEnable;
    }

    @C46608f
    public final boolean getEnableAutoRotateRemote() {
        return C1427q.etc.erC;
    }

    @C46608f
    public final String getDeviceInfoConfigRemote() {
        AppMethodBeat.m2504i(2832);
        String dur = C1720g.m3536RP().mo5240Rz().dur();
        C25052j.m39375o(dur, "storage().getServerCfgIn…RINFO_SERVER_CONFIG_INFO)");
        AppMethodBeat.m2505o(2832);
        return dur;
    }

    @C46608f
    public final Object getConfigStorage(int i, Object obj) {
        AppMethodBeat.m2504i(2833);
        C25052j.m39376p(obj, "defval");
        C4990ab.m7417i("MicroMsg.EmojiCaptureProxy", "getConfigStorage, %s %s", ((C5127a[]) C5127a.class.getEnumConstants())[i], obj);
        Object obj2 = C1720g.m3536RP().mo5239Ry().get(r0, obj);
        AppMethodBeat.m2505o(2833);
        return obj2;
    }

    @C46608f
    public final int getUseGpuSegmentRemote() {
        int a;
        AppMethodBeat.m2504i(2834);
        try {
            a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_emoji_segment_gpu, 1);
        } catch (Exception e) {
            a = 1;
        }
        AppMethodBeat.m2505o(2834);
        return a;
    }

    public final Bundle objectsToBundle(Object... objArr) {
        AppMethodBeat.m2504i(2835);
        C25052j.m39376p(objArr, "params");
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            String valueOf;
            Object obj;
            C44941v c44941v;
            if (objArr[i] instanceof Bundle) {
                valueOf = String.valueOf(i);
                obj = objArr[i];
                if (obj == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type android.os.Bundle");
                    AppMethodBeat.m2505o(2835);
                    throw c44941v;
                }
                bundle.putBundle(valueOf, (Bundle) obj);
            } else if (objArr[i] instanceof Parcelable) {
                valueOf = String.valueOf(i);
                obj = objArr[i];
                if (obj == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type android.os.Parcelable");
                    AppMethodBeat.m2505o(2835);
                    throw c44941v;
                }
                bundle.putParcelable(valueOf, (Parcelable) obj);
            } else if (objArr[i] instanceof C5127a) {
                valueOf = "MicroMsg.EmojiCaptureProxy";
                String str = "objectsToBundle: %s";
                Object[] objArr2 = new Object[1];
                obj = objArr[i];
                if (obj == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
                    AppMethodBeat.m2505o(2835);
                    throw c44941v;
                }
                objArr2[0] = Integer.valueOf(((C5127a) obj).ordinal());
                C4990ab.m7417i(valueOf, str, objArr2);
                valueOf = String.valueOf(i);
                obj = objArr[i];
                if (obj == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
                    AppMethodBeat.m2505o(2835);
                    throw c44941v;
                }
                bundle.putInt(valueOf, ((C5127a) obj).ordinal());
            } else {
                valueOf = String.valueOf(i);
                obj = objArr[i];
                if (obj == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type java.io.Serializable");
                    AppMethodBeat.m2505o(2835);
                    throw c44941v;
                }
                bundle.putSerializable(valueOf, (Serializable) obj);
            }
        }
        AppMethodBeat.m2505o(2835);
        return bundle;
    }

    public final void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(2836);
        C25052j.m39376p(str, "methodName");
        C25052j.m39376p(bundle, "data");
        C4990ab.m7417i("MicroMsg.EmojiCaptureProxy", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                C25052j.m39375o(method2, "mth");
                if (C6163u.m9833I(method2.getName(), str, true)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? C40602e.class : C46608f.class)) {
                    Object[] args = getArgs(bundle);
                    Object invoke = method.invoke(this, Arrays.copyOf(args, args.length));
                    if ((C25052j.m39373j(method.getReturnType(), Void.TYPE) ^ 1) != 0) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable(this.RESULT_KEY, (Parcelable) invoke);
                            AppMethodBeat.m2505o(2836);
                            return;
                        }
                        if (C25052j.m39373j("getConfigStorage", str)) {
                            C4990ab.m7417i("MicroMsg.EmojiCaptureProxy", "put result as Serializable: %s", (Serializable) invoke);
                        }
                        bundle.putSerializable(this.RESULT_KEY, (Serializable) invoke);
                        AppMethodBeat.m2505o(2836);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.EmojiCaptureProxy", "exception:%s", C5046bo.m7574l(e));
        }
        AppMethodBeat.m2505o(2836);
    }
}
