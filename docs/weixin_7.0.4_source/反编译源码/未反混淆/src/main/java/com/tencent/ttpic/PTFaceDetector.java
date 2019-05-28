package com.tencent.ttpic;

import android.graphics.PointF;
import android.opengl.EGL14;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.ApiHelper;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.thread.FaceGestureDetGLThread.OnFaceDetListener;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class PTFaceDetector {
    private static final String TAG = PTFaceDetector.class.getSimpleName();
    public static AtomicInteger activeRefCount = new AtomicInteger(0);
    private boolean firstDet;
    private volatile SegmentDataPipe mDetDataPipe;
    private FaceGestureDetGLThread mDetGLThread;
    private final Object mFaceDetLock = new Object();
    private VideoPreviewFaceOutlineDetector mFaceDetector;
    private h mLastInputFrame;
    private h mLastOriginLargeFrame;
    private BaseFilter mRotateFilter = new BaseFilter(GLSLRender.bJB);
    private h mRotateFrame = new h();

    public PTFaceDetector() {
        AppMethodBeat.i(81575);
        AppMethodBeat.o(81575);
    }

    static /* synthetic */ void access$000(PTFaceDetector pTFaceDetector, SegmentDataPipe segmentDataPipe) {
        AppMethodBeat.i(81586);
        pTFaceDetector.setDataPipe(segmentDataPipe);
        AppMethodBeat.o(81586);
    }

    static {
        AppMethodBeat.i(81587);
        AppMethodBeat.o(81587);
    }

    public VideoPreviewFaceOutlineDetector getFaceDetector() {
        return this.mFaceDetector;
    }

    public void init() {
        AppMethodBeat.i(81576);
        init(false);
        AppMethodBeat.o(81576);
    }

    public void init(boolean z) {
        AppMethodBeat.i(81577);
        if (ApiHelper.hasJellyBeanMR1() && this.mDetGLThread == null) {
            this.mDetGLThread = new FaceGestureDetGLThread(EGL14.eglGetCurrentContext());
            activeRefCount.getAndIncrement();
            this.mDetGLThread.setOnFaceDetListener(new OnFaceDetListener() {
                public void onDataReady(SegmentDataPipe segmentDataPipe) {
                    AppMethodBeat.i(81574);
                    PTFaceDetector.access$000(PTFaceDetector.this, segmentDataPipe);
                    AppMethodBeat.o(81574);
                }
            });
            this.mFaceDetector = this.mDetGLThread.getDetector();
            if (!z) {
                this.mFaceDetector.setDoTrackHandler(this.mDetGLThread.getHandler());
            }
        }
        this.mRotateFilter.ApplyGLSLFilter();
        this.firstDet = true;
        AppMethodBeat.o(81577);
    }

    private void setDataPipe(SegmentDataPipe segmentDataPipe) {
        AppMethodBeat.i(81578);
        synchronized (this.mFaceDetLock) {
            try {
                this.mDetDataPipe = segmentDataPipe;
                this.mFaceDetLock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(81578);
            }
        }
    }

    public void destroy() {
        AppMethodBeat.i(81579);
        if (this.mFaceDetector != null) {
            this.mDetGLThread.postFaceDetectorDestroy();
        }
        RetrieveDataManager.getInstance().clear();
        this.mRotateFilter.ClearGLSL();
        this.mRotateFrame.clear();
        if (this.mDetGLThread != null) {
            this.mDetGLThread.destroy();
            activeRefCount.getAndDecrement();
            this.mDetGLThread = null;
        }
        AppMethodBeat.o(81579);
    }

    public PTFaceAttr detectFrame(h hVar, h hVar2, int i, boolean z, boolean z2, boolean z3, double d) {
        AppMethodBeat.i(81580);
        PTFaceAttr detectFrame = detectFrame(hVar, hVar2, i, z, z2, z3, d, false, false);
        AppMethodBeat.o(81580);
        return detectFrame;
    }

    public PTFaceAttr detectFrame(h hVar, h hVar2, int i, boolean z, boolean z2, boolean z3, double d, boolean z4) {
        AppMethodBeat.i(81581);
        PTFaceAttr detectFrame = detectFrame(hVar, hVar2, i, z, z2, z3, d, z4, false);
        AppMethodBeat.o(81581);
        return detectFrame;
    }

    public PTFaceAttr detectFrame(h hVar, h hVar2, int i, boolean z, boolean z2, boolean z3, double d, boolean z4, boolean z5) {
        h hVar3;
        h hVar4;
        Set set;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        List list7;
        float[] fArr;
        AppMethodBeat.i(81582);
        h rotateCorrect = FrameUtil.rotateCorrect(hVar, hVar.width, hVar.height, i, this.mRotateFilter, this.mRotateFrame);
        int i2 = (int) (((double) rotateCorrect.width) * d);
        int i3 = (int) (((double) rotateCorrect.height) * d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        List arrayList6 = new ArrayList();
        float[] fArr2 = new float[3];
        fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        Set hashSet = new HashSet();
        hashSet.add(Integer.valueOf(1));
        ArrayList arrayList7 = new ArrayList();
        byte[] bArr = new byte[0];
        int[] iArr = null;
        Pair create = Pair.create(Integer.valueOf(255), null);
        Map hashMap = new HashMap();
        Object obj;
        if (this.mDetGLThread == null || !this.mDetGLThread.isInitReady()) {
            hVar3 = hVar2;
            hVar4 = hVar;
            obj = arrayList7;
            set = hashSet;
            list = arrayList6;
            Object list32 = arrayList5;
            Object list42 = arrayList4;
            Object list52 = arrayList3;
            Object list62 = arrayList2;
            Object list72 = arrayList;
        } else {
            SegmentDataPipe segmentDataPipe = null;
            if (z4) {
                this.firstDet = false;
                this.mDetGLThread.postFaceGestureDet(rotateCorrect, z, z2, z3, d, z5);
            }
            if (!this.firstDet) {
                synchronized (this.mFaceDetLock) {
                    while (this.mDetDataPipe == null) {
                        try {
                            this.mFaceDetLock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    try {
                        segmentDataPipe = this.mDetDataPipe;
                        this.mDetDataPipe = null;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(81582);
                        }
                    }
                }
            }
            this.firstDet = false;
            if (segmentDataPipe == null || segmentDataPipe.mTexFrame.width != rotateCorrect.width) {
                hVar3 = hVar2;
                hVar4 = hVar;
                obj = arrayList7;
            } else {
                arrayList = segmentDataPipe.allFacePoints;
                arrayList2 = segmentDataPipe.allIrisPoints;
                arrayList3 = segmentDataPipe.allFaceAngles;
                hashSet = segmentDataPipe.mTriggeredExpressionType;
                arrayList4 = segmentDataPipe.allHandPoints;
                arrayList5 = segmentDataPipe.allHandAngles;
                List list8 = segmentDataPipe.faceStatus;
                arrayList6 = segmentDataPipe.bodyDetectResults;
                bArr = segmentDataPipe.mData;
                iArr = segmentDataPipe.brightnessAdjustmentCurve;
                hashMap = segmentDataPipe.faceActionCounter;
                hVar4 = this.mLastInputFrame;
                hVar3 = this.mLastOriginLargeFrame;
                create = segmentDataPipe.histogram;
                list2 = list8;
            }
            if (!z4) {
                this.mDetGLThread.postFaceGestureDet(rotateCorrect, z, z2, z3, d, z5);
            }
            this.mLastInputFrame = hVar;
            this.mLastOriginLargeFrame = hVar2;
            set = hashSet;
            list = arrayList6;
            list32 = arrayList5;
            list42 = arrayList4;
            list52 = arrayList3;
            list62 = arrayList2;
            list72 = arrayList;
        }
        list72 = AlgoUtils.rotatePointsForList(list72, i2, i3, i);
        list62 = AlgoUtils.rotatePointsForList(list62, i2, i3, i);
        list52 = AlgoUtils.rotateAngles(list52, -i);
        list42 = AlgoUtils.rotatePoints(list42, i2, i3, i);
        list32 = AlgoUtils.rotateAngles(list32, -i);
        List rotateFaceStatusFor3D = AlgoUtils.rotateFaceStatusFor3D(list2, i2, i3, i);
        arrayList6 = rotateBodyDetectResults(list, i2, i3, i);
        if (list32 == null || list32.size() <= 0) {
            fArr = fArr2;
        } else {
            fArr = (float[]) list32.get(0);
        }
        PTFaceAttr genFaceAttr = PTFaceAttr.genFaceAttr(list72, list62, list52, set, list42, fArr, rotateFaceStatusFor3D, arrayList6, d, bArr, false, hVar4, hVar3, rotateCorrect, i, iArr, hashMap, create, this.mFaceDetector);
        AppMethodBeat.o(81582);
        return genFaceAttr;
    }

    public List<BodyDetectResult> rotateBodyDetectResults(List<BodyDetectResult> list, int i, int i2, int i3) {
        AppMethodBeat.i(81583);
        if (list == null || i3 != 180) {
            AppMethodBeat.o(81583);
        } else {
            for (int i4 = 0; i4 < list.size(); i4++) {
                ArrayList arrayList = new ArrayList();
                BodyDetectResult bodyDetectResult = (BodyDetectResult) list.get(i4);
                for (int i5 = 0; i5 < bodyDetectResult.bodyPoints.size(); i5++) {
                    arrayList.add(bodyDetectResult.bodyPoints.get(i5));
                }
                AlgoUtils.rotatePoints(arrayList, i, i2, i3);
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    ((PointF) bodyDetectResult.bodyPoints.get(i6)).x = ((PointF) arrayList.get(i6)).x;
                    ((PointF) bodyDetectResult.bodyPoints.get(i6)).y = ((PointF) arrayList.get(i6)).y;
                }
            }
            AppMethodBeat.o(81583);
        }
        return list;
    }

    public String getHistogramInfo() {
        AppMethodBeat.i(81584);
        String histogramInfo;
        if (this.mDetGLThread != null) {
            histogramInfo = this.mDetGLThread.getHistogramInfo();
            AppMethodBeat.o(81584);
            return histogramInfo;
        }
        histogramInfo = "";
        AppMethodBeat.o(81584);
        return histogramInfo;
    }

    public void resetBodyDetector() {
        AppMethodBeat.i(81585);
        if (this.mDetGLThread != null) {
            this.mDetGLThread.resetBodyDetector();
            if (this.mDetDataPipe != null) {
                this.mDetDataPipe.bodyDetectResults = new ArrayList();
            }
        }
        AppMethodBeat.o(81585);
    }
}
