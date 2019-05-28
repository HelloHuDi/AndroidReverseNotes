package com.tencent.p177mm.plugin.story.p1032c.p1033a;

import android.app.ActivityManager;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.story.p1032c.C39870a.C39865b;
import com.tencent.p177mm.plugin.story.p1032c.C46271b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.FilterEnum4Shaka;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0006\u0010\u001e\u001a\u00020\u0019J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000¨\u0006#"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "()V", "CPU_CROP_AVAILABLE", "", "CPU_CROP_MMKV_KEY", "", "CPU_CROP_NOT_AVAILABLE", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "RESOLUTION", "StoryCropSizeWithCPU", "StoryCropSizeWithGPU", "TAG", "USECPUCROP", "USE_HIGHEST_RESOLUTION_MEMORYCLASS_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB_BUFFER", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadCropTypeConfig", "loadDeviceResolutionConfig", "", "loadResolutionConfig", "markCpuCropNotAvailable", "setServerUseCpuCrop", "tryUse1080Preview", "use720Preview", "CameraPreviewConfig", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.c.a.b */
public final class C13740b extends C46271b<C13739a> {
    public static final C13740b rRj = new C13740b();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "(IZ)V", "getResolution", "()I", "setResolution", "(I)V", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.c.a.b$a */
    public static final class C13739a {
        public boolean fau;
        public int lhd;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof C13739a)) {
                    return false;
                }
                C13739a c13739a = (C13739a) obj;
                if (!(this.lhd == c13739a.lhd)) {
                    return false;
                }
                if (!(this.fau == c13739a.fau)) {
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
            AppMethodBeat.m2504i(108953);
            String str = "CameraPreviewConfig(resolution=" + this.lhd + ", useCpuCrop=" + this.fau + ")";
            AppMethodBeat.m2505o(108953);
            return str;
        }

        private C13739a() {
            this.lhd = 720;
            this.fau = false;
        }

        public /* synthetic */ C13739a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(108956);
        AppMethodBeat.m2505o(108956);
    }

    private C13740b() {
    }

    /* renamed from: Uu */
    public final /* synthetic */ Object mo25944Uu() {
        AppMethodBeat.m2504i(108954);
        C13739a c13739a = new C13739a();
        AppMethodBeat.m2505o(108954);
        return c13739a;
    }

    /* renamed from: Uv */
    public final void mo25945Uv() {
        C13739a c13739a;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(108955);
        boolean z3 = mo45628L("VideoRecordUseCpuCrop", 0) == 1;
        int i = C1427q.etk.etK;
        C4990ab.m7416i("MicroMsg.StoryCameraElementConfig", "setServerUseCpuCrop, serverConfigUseCpuCrop:" + z3 + ", deviceConfigUseCpuCrop:" + i + ", localCpuCropConfig:" + C5018as.amF(C39865b.rQX.name()).getInt("use_cpu_crop", 0));
        if (z3) {
            ((C13739a) mo53287Ut()).fau = true;
        }
        if (i != -1) {
            c13739a = (C13739a) mo53287Ut();
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            c13739a.fau = z;
        }
        C4990ab.m7416i("MicroMsg.StoryCameraElementConfig", "final set useCpuCrop:" + ((C13739a) mo53287Ut()).fau);
        if (C5047bp.dpL()) {
            c13739a = (C13739a) mo53287Ut();
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            if (RP.mo5239Ry().getInt(C5127a.USERINFO_TOP_STORY_CROP_TYPE_INT, 2) == 1) {
                z = true;
            } else {
                z = false;
            }
            c13739a.fau = z;
            C4990ab.m7416i("MicroMsg.StoryCameraElementConfig", "cameraPreviewConfig.useCpuCrop debug : " + ((C13739a) mo53287Ut()).fau);
        }
        if (C1427q.etk.etG != -1) {
            c13739a = (C13739a) mo53287Ut();
            switch (C1427q.etk.etG) {
                case 2:
                case 4:
                case 5:
                case 6:
                    i = 720;
                    break;
                case 3:
                    if (!((C13739a) mo53287Ut()).fau) {
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
            c13739a.lhd = i;
            C4990ab.m7416i("MicroMsg.StoryCameraElementConfig", "loadDeviceResolutionConfig " + ((C13739a) mo53287Ut()).lhd + "  value " + C1427q.etk.etG);
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            Point bPg = C3475d.bPg();
            int L = mo45628L("Sight1080pRecordMinApiLevel", 19);
            C4990ab.m7416i("MicroMsg.StoryCameraElementConfig", "record1080pApiLevel: " + L + "  screenSize x " + bPg.x + " y " + bPg.y);
            Object systemService = C4996ah.getContext().getSystemService("activity");
            if (systemService == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.ActivityManager");
                AppMethodBeat.m2505o(108955);
                throw c44941v;
            }
            int largeMemoryClass = ((ActivityManager) systemService).getLargeMemoryClass();
            double ev = (double) C3475d.m5782ev(C4996ah.getContext());
            if ((C1427q.etk.etF == -1 || (C1427q.etk.etF & 1) != 0) && C1443d.m3068iW(L) && largeMemoryClass >= 512 && ev >= 1725.0d && Math.min(bPg.x, bPg.y) >= FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
                ((C13739a) mo53287Ut()).lhd = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
            } else {
                C4990ab.m7416i("MicroMsg.StoryCameraElementConfig", "currentRecorderCaptureResolution is :" + ((C13739a) mo53287Ut()) + ".resolution");
                z2 = false;
            }
            if (!z2) {
                ((C13739a) mo53287Ut()).lhd = 720;
            }
        }
        AppMethodBeat.m2505o(108955);
    }
}
