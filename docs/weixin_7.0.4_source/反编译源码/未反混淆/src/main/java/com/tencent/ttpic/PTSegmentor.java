package com.tencent.ttpic;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
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
    private static final ThreadLocal<PTSegmentor> INSTANCE = new ThreadLocal<PTSegmentor>() {
        /* Access modifiers changed, original: protected|final */
        public final PTSegmentor initialValue() {
            AppMethodBeat.i(81597);
            PTSegmentor pTSegmentor = new PTSegmentor();
            AppMethodBeat.o(81597);
            return pTSegmentor;
        }
    };
    private static String[] NOT_SUPPORT_DEVICE = new String[]{"QIHOO_1503-A01"};
    private boolean firstSeg;
    private volatile SegmentDataPipe mDetDataPipe;
    private BaseFilter mRotateFilter = new BaseFilter(GLSLRender.bJB);
    private h mRotateFrame = new h();
    private SegmentGLThread mSegGLThread;
    private final Object mSegmentLock = new Object();

    public PTSegmentor() {
        AppMethodBeat.i(81600);
        AppMethodBeat.o(81600);
    }

    static /* synthetic */ void access$000(PTSegmentor pTSegmentor, SegmentDataPipe segmentDataPipe) {
        AppMethodBeat.i(81608);
        pTSegmentor.setDataPipe(segmentDataPipe);
        AppMethodBeat.o(81608);
    }

    static {
        AppMethodBeat.i(81609);
        AppMethodBeat.o(81609);
    }

    public static PTSegmentor getInstance() {
        AppMethodBeat.i(81601);
        PTSegmentor pTSegmentor = (PTSegmentor) INSTANCE.get();
        AppMethodBeat.o(81601);
        return pTSegmentor;
    }

    @TargetApi(17)
    public void init() {
        AppMethodBeat.i(81602);
        if (ApiHelper.hasJellyBeanMR1() && this.mSegGLThread == null && !inBlackList(DeviceInstance.getInstance().getDeviceName())) {
            this.mSegGLThread = new SegmentGLThread(EGL14.eglGetCurrentContext());
            this.mSegGLThread.setOnDataReadyListener(new OnSegDataReadyListener() {
                public void onDataReady(SegmentDataPipe segmentDataPipe) {
                    AppMethodBeat.i(81599);
                    PTSegmentor.access$000(PTSegmentor.this, segmentDataPipe);
                    AppMethodBeat.o(81599);
                }
            });
        }
        this.mRotateFilter.ApplyGLSLFilter();
        this.firstSeg = true;
        AppMethodBeat.o(81602);
    }

    private boolean inBlackList(String str) {
        AppMethodBeat.i(81603);
        for (String equals : NOT_SUPPORT_DEVICE) {
            if (equals.equals(str)) {
                AppMethodBeat.o(81603);
                return true;
            }
        }
        AppMethodBeat.o(81603);
        return false;
    }

    private void setDataPipe(SegmentDataPipe segmentDataPipe) {
        AppMethodBeat.i(81604);
        synchronized (this.mSegmentLock) {
            try {
                this.mDetDataPipe = segmentDataPipe;
                this.mSegmentLock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(81604);
            }
        }
    }

    public void destroy() {
        AppMethodBeat.i(81605);
        this.mRotateFilter.ClearGLSL();
        this.mRotateFrame.clear();
        if (this.mSegGLThread != null) {
            this.mSegGLThread.destroy();
            this.mSegGLThread = null;
        }
        AppMethodBeat.o(81605);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PTSegAttr detectFrame(h hVar, int i, boolean z) {
        h hVar2;
        PTSegAttr genSegAttr;
        AppMethodBeat.i(81606);
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
                            AppMethodBeat.o(81606);
                        }
                    }
                }
            }
            this.mSegGLThread.postSegJob(hVar, FabbyUtil.isHorizon(i));
            this.firstSeg = false;
            if (segmentDataPipe != null && segmentDataPipe.mTexFrame.width == hVar.width) {
                hVar2 = segmentDataPipe.mMaskFrame;
                if (hVar2 != null) {
                    hVar2 = FrameUtil.rotateCorrect(hVar2, hVar2.width, hVar2.height, -i, this.mRotateFilter, this.mRotateFrame);
                }
                genSegAttr = genSegAttr(hVar2);
                AppMethodBeat.o(81606);
                return genSegAttr;
            }
        }
        hVar2 = null;
        if (hVar2 != null) {
        }
        genSegAttr = genSegAttr(hVar2);
        AppMethodBeat.o(81606);
        return genSegAttr;
    }

    private PTSegAttr genSegAttr(h hVar) {
        AppMethodBeat.i(81607);
        PTSegAttr pTSegAttr = new PTSegAttr();
        pTSegAttr.setMaskFrame(hVar);
        AppMethodBeat.o(81607);
        return pTSegAttr;
    }
}
