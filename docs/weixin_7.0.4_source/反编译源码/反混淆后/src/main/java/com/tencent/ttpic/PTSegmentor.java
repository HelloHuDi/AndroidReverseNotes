package com.tencent.ttpic;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.ApiHelper;
import com.tencent.ttpic.device.DeviceInstance;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.fabby.FabbyUtil;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.thread.SegmentGLThread;
import com.tencent.ttpic.thread.SegmentGLThread.OnSegDataReadyListener;
import com.tencent.ttpic.util.FrameUtil;

public class PTSegmentor {
    private static final ThreadLocal<PTSegmentor> INSTANCE = new C468221();
    private static String[] NOT_SUPPORT_DEVICE = new String[]{"QIHOO_1503-A01"};
    private boolean firstSeg;
    private volatile SegmentDataPipe mDetDataPipe;
    private BaseFilter mRotateFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mRotateFrame = new C41672h();
    private SegmentGLThread mSegGLThread;
    private final Object mSegmentLock = new Object();

    /* renamed from: com.tencent.ttpic.PTSegmentor$2 */
    class C413602 implements OnSegDataReadyListener {
        C413602() {
        }

        public void onDataReady(SegmentDataPipe segmentDataPipe) {
            AppMethodBeat.m2504i(81599);
            PTSegmentor.access$000(PTSegmentor.this, segmentDataPipe);
            AppMethodBeat.m2505o(81599);
        }
    }

    /* renamed from: com.tencent.ttpic.PTSegmentor$1 */
    static class C468221 extends ThreadLocal<PTSegmentor> {
        C468221() {
        }

        /* Access modifiers changed, original: protected|final */
        public final PTSegmentor initialValue() {
            AppMethodBeat.m2504i(81597);
            PTSegmentor pTSegmentor = new PTSegmentor();
            AppMethodBeat.m2505o(81597);
            return pTSegmentor;
        }
    }

    public PTSegmentor() {
        AppMethodBeat.m2504i(81600);
        AppMethodBeat.m2505o(81600);
    }

    static /* synthetic */ void access$000(PTSegmentor pTSegmentor, SegmentDataPipe segmentDataPipe) {
        AppMethodBeat.m2504i(81608);
        pTSegmentor.setDataPipe(segmentDataPipe);
        AppMethodBeat.m2505o(81608);
    }

    static {
        AppMethodBeat.m2504i(81609);
        AppMethodBeat.m2505o(81609);
    }

    public static PTSegmentor getInstance() {
        AppMethodBeat.m2504i(81601);
        PTSegmentor pTSegmentor = (PTSegmentor) INSTANCE.get();
        AppMethodBeat.m2505o(81601);
        return pTSegmentor;
    }

    @TargetApi(17)
    public void init() {
        AppMethodBeat.m2504i(81602);
        if (ApiHelper.hasJellyBeanMR1() && this.mSegGLThread == null && !inBlackList(DeviceInstance.getInstance().getDeviceName())) {
            this.mSegGLThread = new SegmentGLThread(EGL14.eglGetCurrentContext());
            this.mSegGLThread.setOnDataReadyListener(new C413602());
        }
        this.mRotateFilter.ApplyGLSLFilter();
        this.firstSeg = true;
        AppMethodBeat.m2505o(81602);
    }

    private boolean inBlackList(String str) {
        AppMethodBeat.m2504i(81603);
        for (String equals : NOT_SUPPORT_DEVICE) {
            if (equals.equals(str)) {
                AppMethodBeat.m2505o(81603);
                return true;
            }
        }
        AppMethodBeat.m2505o(81603);
        return false;
    }

    private void setDataPipe(SegmentDataPipe segmentDataPipe) {
        AppMethodBeat.m2504i(81604);
        synchronized (this.mSegmentLock) {
            try {
                this.mDetDataPipe = segmentDataPipe;
                this.mSegmentLock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(81604);
            }
        }
    }

    public void destroy() {
        AppMethodBeat.m2504i(81605);
        this.mRotateFilter.ClearGLSL();
        this.mRotateFrame.clear();
        if (this.mSegGLThread != null) {
            this.mSegGLThread.destroy();
            this.mSegGLThread = null;
        }
        AppMethodBeat.m2505o(81605);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PTSegAttr detectFrame(C41672h c41672h, int i, boolean z) {
        C41672h c41672h2;
        PTSegAttr genSegAttr;
        AppMethodBeat.m2504i(81606);
        if (this.mSegGLThread != null && this.mSegGLThread.isInitReady() && z && FabbyManager.getInstance().IsInitSuccess() && FeatureManager.isSegmentationReady()) {
            SegmentDataPipe segmentDataPipe;
            if (this.firstSeg) {
                segmentDataPipe = null;
            } else {
                synchronized (this.mSegmentLock) {
                    while (this.mDetDataPipe == null) {
                        try {
                            this.mSegmentLock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    try {
                        segmentDataPipe = this.mDetDataPipe;
                        this.mDetDataPipe = null;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(81606);
                        }
                    }
                }
            }
            this.mSegGLThread.postSegJob(c41672h, FabbyUtil.isHorizon(i));
            this.firstSeg = false;
            if (segmentDataPipe != null && segmentDataPipe.mTexFrame.width == c41672h.width) {
                c41672h2 = segmentDataPipe.mMaskFrame;
                if (c41672h2 != null) {
                    c41672h2 = FrameUtil.rotateCorrect(c41672h2, c41672h2.width, c41672h2.height, -i, this.mRotateFilter, this.mRotateFrame);
                }
                genSegAttr = genSegAttr(c41672h2);
                AppMethodBeat.m2505o(81606);
                return genSegAttr;
            }
        }
        c41672h2 = null;
        if (c41672h2 != null) {
        }
        genSegAttr = genSegAttr(c41672h2);
        AppMethodBeat.m2505o(81606);
        return genSegAttr;
    }

    private PTSegAttr genSegAttr(C41672h c41672h) {
        AppMethodBeat.m2504i(81607);
        PTSegAttr pTSegAttr = new PTSegAttr();
        pTSegAttr.setMaskFrame(c41672h);
        AppMethodBeat.m2505o(81607);
        return pTSegAttr;
    }
}
