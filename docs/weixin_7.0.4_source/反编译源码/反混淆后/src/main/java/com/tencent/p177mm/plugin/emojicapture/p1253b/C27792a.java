package com.tencent.p177mm.plugin.emojicapture.p1253b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.media.p251b.C32741b;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy.C20437a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.FilterEnum4Shaka;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0014J\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig;", "Lcom/tencent/mm/media/config/SimpleElementConfig;", "Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "()V", "CAPTURE_PREVIEW_SIZE_HIGH", "", "CAPTURE_PREVIEW_SIZE_LOW", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "highPerformance", "", "checkHighPerformance", "", "getIntDynamicConfig", "key", "defValue", "init", "initDefaultConfig", "loadConfig", "setPreviewConfig", "setServerUseCpuCrop", "CameraPreviewConfig", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.b.a */
public final class C27792a extends C32741b<C20425a> {
    private static final String TAG = TAG;
    private static boolean lhb = true;
    public static final C27792a lhc = new C27792a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "previewSize", "stickerSampleSize", "(IZII)V", "getPreviewSize", "()I", "setPreviewSize", "(I)V", "getResolution", "setResolution", "getStickerSampleSize", "setStickerSampleSize", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.b.a$a */
    public static final class C20425a {
        public boolean fau;
        public int lhd;
        public int lhe;
        public int lhf;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof C20425a)) {
                    return false;
                }
                C20425a c20425a = (C20425a) obj;
                if (!(this.lhd == c20425a.lhd)) {
                    return false;
                }
                if (!(this.fau == c20425a.fau)) {
                    return false;
                }
                if (!(this.lhe == c20425a.lhe)) {
                    return false;
                }
                if (!(this.lhf == c20425a.lhf)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int i = this.lhd * 31;
            int i2 = this.fau;
            if (i2 != 0) {
                i2 = 1;
            }
            return ((((i2 + i) * 31) + this.lhe) * 31) + this.lhf;
        }

        public final String toString() {
            AppMethodBeat.m2504i(2569);
            String str = "CameraPreviewConfig(resolution=" + this.lhd + ", useCpuCrop=" + this.fau + ", previewSize=" + this.lhe + ", stickerSampleSize=" + this.lhf + ")";
            AppMethodBeat.m2505o(2569);
            return str;
        }

        private C20425a() {
            this.lhd = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
            this.fau = false;
            this.lhe = 640;
            this.lhf = 1;
        }

        public /* synthetic */ C20425a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(2574);
        AppMethodBeat.m2505o(2574);
    }

    private C27792a() {
    }

    /* renamed from: Uv */
    public final void mo25945Uv() {
        boolean z = true;
        AppMethodBeat.m2504i(2572);
        ((C20425a) mo53287Ut()).fau = false;
        if (C5047bp.dpL()) {
            C20425a c20425a;
            if (C4996ah.bqo()) {
                c20425a = (C20425a) mo53287Ut();
                z = C26072e.m41627OV();
            } else {
                c20425a = (C20425a) mo53287Ut();
                C20437a c20437a = EmojiCaptureProxy.lkM;
                if (EmojiCaptureProxy.lkL.getInt(C5127a.USERINFO_EMOJI_SPRING_FESTIVAL_CROP_TYPE_INT, 1) != 0) {
                    z = false;
                }
            }
            c20425a.fau = z;
        }
        if (((C20425a) mo53287Ut()).fau) {
            ((C20425a) mo53287Ut()).lhd = 720;
        } else {
            ((C20425a) mo53287Ut()).lhd = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        }
        C4990ab.m7416i(TAG, "config resolution:" + ((C20425a) mo53287Ut()).lhd + ", useCpuCrop:" + ((C20425a) mo53287Ut()).fau);
        AppMethodBeat.m2505o(2572);
    }

    /* renamed from: L */
    public final int mo45628L(String str, int i) {
        AppMethodBeat.m2504i(2573);
        C25052j.m39376p(str, "key");
        int i2;
        if (C4996ah.bqo()) {
            C1694a K = C1720g.m3528K(C7234a.class);
            C25052j.m39375o(K, "MMKernel.service<IConfig…onfigService::class.java)");
            i2 = C5046bo.getInt(((C7234a) K).mo15608Nu().getValue(str), i);
            AppMethodBeat.m2505o(2573);
            return i2;
        }
        C20437a c20437a = EmojiCaptureProxy.lkM;
        i2 = C5046bo.getInt(EmojiCaptureProxy.lkL.getDynamicConfig(str), i);
        AppMethodBeat.m2505o(2573);
        return i2;
    }

    public final void init() {
        boolean z = true;
        AppMethodBeat.m2504i(2570);
        mo53289aQ(new C20425a());
        Object systemService = C4996ah.getContext().getSystemService("activity");
        if (systemService == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.m2505o(2570);
            throw c44941v;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        int largeMemoryClass = activityManager.getLargeMemoryClass();
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j = (memoryInfo.totalMem / 1024) / 1024;
        int a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_emoji_high_mem_class, 512);
        int a2 = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_emoji_high_total_mem, 2048);
        boolean z2 = C1443d.m3068iW(23) && largeMemoryClass >= a && j >= ((long) a2);
        lhb = z2;
        C34007d c34007d;
        if (z2) {
            c34007d = C34007d.lhz;
            C34007d.bnl();
        } else {
            c34007d = C34007d.lhz;
            C34007d.bnm();
        }
        C4990ab.m7416i(TAG, "checkHighPerformance: device: " + largeMemoryClass + ", " + j + "; high: " + a + ", " + a2 + "; " + lhb);
        if (lhb) {
            ((C20425a) mo53287Ut()).lhe = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_emoji_high_preview_size, 640);
            ((C20425a) mo53287Ut()).lhf = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_emoji_high_sample_size, 1);
        } else {
            ((C20425a) mo53287Ut()).lhe = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_emoji_low_preview_size, 480);
            ((C20425a) mo53287Ut()).lhf = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_emoji_low_sample_size, 1);
        }
        largeMemoryClass = C1427q.etj.etM;
        int i = C1427q.etj.etN;
        if (largeMemoryClass != -1) {
            C4990ab.m7416i(TAG, "setPreviewConfig: use device preview ".concat(String.valueOf(largeMemoryClass)));
            ((C20425a) mo53287Ut()).lhe = largeMemoryClass;
        }
        if (i != -1) {
            C4990ab.m7416i(TAG, "setPreviewConfig: use device sample size ".concat(String.valueOf(i)));
            ((C20425a) mo53287Ut()).lhf = i;
        }
        C4990ab.m7416i(TAG, "setPreviewConfig: " + ((C20425a) mo53287Ut()).lhe + ", " + ((C20425a) mo53287Ut()).lhf);
        z2 = mo45628L("VideoRecordUseCpuCrop", 0) == 1;
        largeMemoryClass = C1427q.etk.etK;
        C4990ab.m7416i(TAG, "setServerUseCpuCrop, serverConfigUseCpuCrop:" + z2 + ", deviceConfigUseCpuCrop:" + largeMemoryClass);
        if (z2) {
            ((C20425a) mo53287Ut()).fau = true;
        }
        if (largeMemoryClass != -1) {
            C20425a c20425a = (C20425a) mo53287Ut();
            if (largeMemoryClass != 1) {
                z = false;
            }
            c20425a.fau = z;
        }
        C4990ab.m7416i(TAG, "final set useCpuCrop:" + ((C20425a) mo53287Ut()).fau);
        AppMethodBeat.m2505o(2570);
    }

    /* renamed from: Uu */
    public final /* synthetic */ Object mo25944Uu() {
        AppMethodBeat.m2504i(2571);
        C20425a c20425a = new C20425a();
        AppMethodBeat.m2505o(2571);
        return c20425a;
    }
}
