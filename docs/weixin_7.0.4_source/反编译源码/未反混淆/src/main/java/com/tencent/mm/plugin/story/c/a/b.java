package com.tencent.mm.plugin.story.c.a;

import a.f.b.j;
import a.l;
import a.v;
import android.app.ActivityManager;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.ttpic.FilterEnum4Shaka;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0006\u0010\u001e\u001a\u00020\u0019J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000¨\u0006#"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "()V", "CPU_CROP_AVAILABLE", "", "CPU_CROP_MMKV_KEY", "", "CPU_CROP_NOT_AVAILABLE", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "RESOLUTION", "StoryCropSizeWithCPU", "StoryCropSizeWithGPU", "TAG", "USECPUCROP", "USE_HIGHEST_RESOLUTION_MEMORYCLASS_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB_BUFFER", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadCropTypeConfig", "loadDeviceResolutionConfig", "", "loadResolutionConfig", "markCpuCropNotAvailable", "setServerUseCpuCrop", "tryUse1080Preview", "use720Preview", "CameraPreviewConfig", "plugin-story_release"})
public final class b extends com.tencent.mm.plugin.story.c.b<a> {
    public static final b rRj = new b();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "(IZ)V", "getResolution", "()I", "setResolution", "(I)V", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-story_release"})
    public static final class a {
        public boolean fau;
        public int lhd;

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
            }
            return true;
        }

        public final int hashCode() {
            int i = this.lhd * 31;
            int i2 = this.fau;
            if (i2 != 0) {
                i2 = 1;
            }
            return i2 + i;
        }

        public final String toString() {
            AppMethodBeat.i(108953);
            String str = "CameraPreviewConfig(resolution=" + this.lhd + ", useCpuCrop=" + this.fau + ")";
            AppMethodBeat.o(108953);
            return str;
        }

        private a() {
            this.lhd = 720;
            this.fau = false;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(108956);
        AppMethodBeat.o(108956);
    }

    private b() {
    }

    public final /* synthetic */ Object Uu() {
        AppMethodBeat.i(108954);
        a aVar = new a();
        AppMethodBeat.o(108954);
        return aVar;
    }

    public final void Uv() {
        a aVar;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(108955);
        boolean z3 = L("VideoRecordUseCpuCrop", 0) == 1;
        int i = q.etk.etK;
        ab.i("MicroMsg.StoryCameraElementConfig", "setServerUseCpuCrop, serverConfigUseCpuCrop:" + z3 + ", deviceConfigUseCpuCrop:" + i + ", localCpuCropConfig:" + as.amF(com.tencent.mm.plugin.story.c.a.b.rQX.name()).getInt("use_cpu_crop", 0));
        if (z3) {
            ((a) Ut()).fau = true;
        }
        if (i != -1) {
            aVar = (a) Ut();
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            aVar.fau = z;
        }
        ab.i("MicroMsg.StoryCameraElementConfig", "final set useCpuCrop:" + ((a) Ut()).fau);
        if (bp.dpL()) {
            aVar = (a) Ut();
            e RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            if (RP.Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_TOP_STORY_CROP_TYPE_INT, 2) == 1) {
                z = true;
            } else {
                z = false;
            }
            aVar.fau = z;
            ab.i("MicroMsg.StoryCameraElementConfig", "cameraPreviewConfig.useCpuCrop debug : " + ((a) Ut()).fau);
        }
        if (q.etk.etG != -1) {
            aVar = (a) Ut();
            switch (q.etk.etG) {
                case 2:
                case 4:
                case 5:
                case 6:
                    i = 720;
                    break;
                case 3:
                    if (!((a) Ut()).fau) {
                        i = 720;
                        break;
                    } else {
                        i = 540;
                        break;
                    }
                default:
                    i = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                    break;
            }
            aVar.lhd = i;
            ab.i("MicroMsg.StoryCameraElementConfig", "loadDeviceResolutionConfig " + ((a) Ut()).lhd + "  value " + q.etk.etG);
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            Point bPg = d.bPg();
            int L = L("Sight1080pRecordMinApiLevel", 19);
            ab.i("MicroMsg.StoryCameraElementConfig", "record1080pApiLevel: " + L + "  screenSize x " + bPg.x + " y " + bPg.y);
            Object systemService = ah.getContext().getSystemService("activity");
            if (systemService == null) {
                v vVar = new v("null cannot be cast to non-null type android.app.ActivityManager");
                AppMethodBeat.o(108955);
                throw vVar;
            }
            int largeMemoryClass = ((ActivityManager) systemService).getLargeMemoryClass();
            double ev = (double) d.ev(ah.getContext());
            if ((q.etk.etF == -1 || (q.etk.etF & 1) != 0) && com.tencent.mm.compatible.util.d.iW(L) && largeMemoryClass >= 512 && ev >= 1725.0d && Math.min(bPg.x, bPg.y) >= FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
                ((a) Ut()).lhd = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
            } else {
                ab.i("MicroMsg.StoryCameraElementConfig", "currentRecorderCaptureResolution is :" + ((a) Ut()) + ".resolution");
                z2 = false;
            }
            if (!z2) {
                ((a) Ut()).lhd = 720;
            }
        }
        AppMethodBeat.o(108955);
    }
}
