package com.tencent.mm.plugin.emojicapture.b;

import a.f.b.j;
import a.l;
import a.v;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.b.b;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.ttpic.FilterEnum4Shaka;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0014J\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig;", "Lcom/tencent/mm/media/config/SimpleElementConfig;", "Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "()V", "CAPTURE_PREVIEW_SIZE_HIGH", "", "CAPTURE_PREVIEW_SIZE_LOW", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "highPerformance", "", "checkHighPerformance", "", "getIntDynamicConfig", "key", "defValue", "init", "initDefaultConfig", "loadConfig", "setPreviewConfig", "setServerUseCpuCrop", "CameraPreviewConfig", "plugin-emojicapture_release"})
public final class a extends b<a> {
    private static final String TAG = TAG;
    private static boolean lhb = true;
    public static final a lhc = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/config/EmojiCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "previewSize", "stickerSampleSize", "(IZII)V", "getPreviewSize", "()I", "setPreviewSize", "(I)V", "getResolution", "setResolution", "getStickerSampleSize", "setStickerSampleSize", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-emojicapture_release"})
    public static final class a {
        public boolean fau;
        public int lhd;
        public int lhe;
        public int lhf;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (!(this.lhd == aVar.lhd)) {
                    return false;
                }
                if (!(this.fau == aVar.fau)) {
                    return false;
                }
                if (!(this.lhe == aVar.lhe)) {
                    return false;
                }
                if (!(this.lhf == aVar.lhf)) {
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
            AppMethodBeat.i(2569);
            String str = "CameraPreviewConfig(resolution=" + this.lhd + ", useCpuCrop=" + this.fau + ", previewSize=" + this.lhe + ", stickerSampleSize=" + this.lhf + ")";
            AppMethodBeat.o(2569);
            return str;
        }

        private a() {
            this.lhd = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
            this.fau = false;
            this.lhe = 640;
            this.lhf = 1;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(2574);
        AppMethodBeat.o(2574);
    }

    private a() {
    }

    public final void Uv() {
        boolean z = true;
        AppMethodBeat.i(2572);
        ((a) Ut()).fau = false;
        if (bp.dpL()) {
            a aVar;
            if (ah.bqo()) {
                aVar = (a) Ut();
                z = e.OV();
            } else {
                aVar = (a) Ut();
                com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar2 = EmojiCaptureProxy.lkM;
                if (EmojiCaptureProxy.lkL.getInt(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SPRING_FESTIVAL_CROP_TYPE_INT, 1) != 0) {
                    z = false;
                }
            }
            aVar.fau = z;
        }
        if (((a) Ut()).fau) {
            ((a) Ut()).lhd = 720;
        } else {
            ((a) Ut()).lhd = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
        }
        ab.i(TAG, "config resolution:" + ((a) Ut()).lhd + ", useCpuCrop:" + ((a) Ut()).fau);
        AppMethodBeat.o(2572);
    }

    public final int L(String str, int i) {
        AppMethodBeat.i(2573);
        j.p(str, "key");
        int i2;
        if (ah.bqo()) {
            com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.zero.b.a.class);
            j.o(K, "MMKernel.service<IConfig…onfigService::class.java)");
            i2 = bo.getInt(((com.tencent.mm.plugin.zero.b.a) K).Nu().getValue(str), i);
            AppMethodBeat.o(2573);
            return i2;
        }
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar = EmojiCaptureProxy.lkM;
        i2 = bo.getInt(EmojiCaptureProxy.lkL.getDynamicConfig(str), i);
        AppMethodBeat.o(2573);
        return i2;
    }

    public final void init() {
        boolean z = true;
        AppMethodBeat.i(2570);
        aQ(new a());
        Object systemService = ah.getContext().getSystemService("activity");
        if (systemService == null) {
            v vVar = new v("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.o(2570);
            throw vVar;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        int largeMemoryClass = activityManager.getLargeMemoryClass();
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j = (memoryInfo.totalMem / 1024) / 1024;
        int a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_emoji_high_mem_class, 512);
        int a2 = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_emoji_high_total_mem, 2048);
        boolean z2 = d.iW(23) && largeMemoryClass >= a && j >= ((long) a2);
        lhb = z2;
        com.tencent.mm.plugin.emojicapture.model.d dVar;
        if (z2) {
            dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
            com.tencent.mm.plugin.emojicapture.model.d.bnl();
        } else {
            dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
            com.tencent.mm.plugin.emojicapture.model.d.bnm();
        }
        ab.i(TAG, "checkHighPerformance: device: " + largeMemoryClass + ", " + j + "; high: " + a + ", " + a2 + "; " + lhb);
        if (lhb) {
            ((a) Ut()).lhe = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_emoji_high_preview_size, 640);
            ((a) Ut()).lhf = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_emoji_high_sample_size, 1);
        } else {
            ((a) Ut()).lhe = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_emoji_low_preview_size, 480);
            ((a) Ut()).lhf = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_emoji_low_sample_size, 1);
        }
        largeMemoryClass = q.etj.etM;
        int i = q.etj.etN;
        if (largeMemoryClass != -1) {
            ab.i(TAG, "setPreviewConfig: use device preview ".concat(String.valueOf(largeMemoryClass)));
            ((a) Ut()).lhe = largeMemoryClass;
        }
        if (i != -1) {
            ab.i(TAG, "setPreviewConfig: use device sample size ".concat(String.valueOf(i)));
            ((a) Ut()).lhf = i;
        }
        ab.i(TAG, "setPreviewConfig: " + ((a) Ut()).lhe + ", " + ((a) Ut()).lhf);
        z2 = L("VideoRecordUseCpuCrop", 0) == 1;
        largeMemoryClass = q.etk.etK;
        ab.i(TAG, "setServerUseCpuCrop, serverConfigUseCpuCrop:" + z2 + ", deviceConfigUseCpuCrop:" + largeMemoryClass);
        if (z2) {
            ((a) Ut()).fau = true;
        }
        if (largeMemoryClass != -1) {
            a aVar = (a) Ut();
            if (largeMemoryClass != 1) {
                z = false;
            }
            aVar.fau = z;
        }
        ab.i(TAG, "final set useCpuCrop:" + ((a) Ut()).fau);
        AppMethodBeat.o(2570);
    }

    public final /* synthetic */ Object Uu() {
        AppMethodBeat.i(2571);
        a aVar = new a();
        AppMethodBeat.o(2571);
        return aVar;
    }
}
