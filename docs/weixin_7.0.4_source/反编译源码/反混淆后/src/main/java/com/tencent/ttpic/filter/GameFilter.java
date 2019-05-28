package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameFilter {
    private static final String TAG = GameFilter.class.getSimpleName();
    private String dataPath;
    private String gameName;
    private GameParams gameParams;
    private int height;
    private boolean isFirstFrame = true;
    private List<StickerItem3D> itemList3D;
    private int[] m2DTexture = new int[1];
    private int mDepthBuffer;
    private BaseFilter mFlipFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mFlipFrame = new C41672h();
    private int mFramebuffer;
    private int maxFaceCount;
    private int orderMode;
    private int width;

    static {
        AppMethodBeat.m2504i(82569);
        AppMethodBeat.m2505o(82569);
    }

    public GameFilter(List<StickerItem3D> list, int i, int i2) {
        AppMethodBeat.m2504i(82557);
        this.itemList3D = list;
        this.orderMode = i;
        this.maxFaceCount = i2;
        AppMethodBeat.m2505o(82557);
    }

    public void init() {
    }

    public void setGameParams(GameParams gameParams, String str) {
        AppMethodBeat.m2504i(82558);
        this.gameParams = gameParams;
        this.dataPath = str + File.separator;
        AppMethodBeat.m2505o(82558);
    }

    public void applyGLSLFilter() {
        AppMethodBeat.m2504i(82559);
        this.mFlipFilter.ApplyGLSLFilter();
        GamePlaySDK.getInstance().init(VideoGlobalContext.getContext(), VideoGlobalContext.getContext().getAssets(), null, null, this.width, this.height);
        GamePlaySDK.getInstance().startGame(this.dataPath, this.gameParams, getNodeParameters());
        AppMethodBeat.m2505o(82559);
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public NodeParameter[] getNodeParameters() {
        AppMethodBeat.m2504i(82560);
        if (this.itemList3D != null) {
            ArrayList arrayList = new ArrayList();
            for (StickerItem3D stickerItem3D : this.itemList3D) {
                if (stickerItem3D.nodeParameter != null) {
                    arrayList.add(stickerItem3D.nodeParameter);
                }
            }
            if (arrayList.isEmpty()) {
                AppMethodBeat.m2505o(82560);
                return null;
            }
            NodeParameter[] nodeParameterArr = new NodeParameter[arrayList.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    nodeParameterArr[i2] = (NodeParameter) arrayList.get(i2);
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(82560);
                    return nodeParameterArr;
                }
            }
        }
        AppMethodBeat.m2505o(82560);
        return null;
    }

    public C41672h updateAndRender(C41672h c41672h, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.m2504i(82561);
        List faceStatusList = pTFaceAttr.getFaceStatusList();
        Map faceActionCounter = pTFaceAttr.getFaceActionCounter();
        Map handActionCounter = GestureDetector.getInstance().getHandActionCounter();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        int rotation = pTFaceAttr.getRotation();
        if (faceStatusList == null || faceStatusList.size() <= 0 || ((FaceStatus) faceStatusList.get(0)).denseFaceModel == null || ((FaceStatus) faceStatusList.get(0)).denseFaceModel[0] == 0.0f || ((FaceStatus) faceStatusList.get(0)).transform[15] < 1.0f) {
            AppMethodBeat.m2505o(82561);
        } else {
            if (GamePlaySDK.getInstance().isInited()) {
                updateActionTriggered(new Builder().faceActionCounter(faceActionCounter).handActionCounter(handActionCounter).triggeredExpression(triggeredExpression).faceDetector(pTFaceAttr.getFaceDetector()).faceDetector(pTFaceAttr.getFaceDetector()).build());
                if (this.itemList3D != null) {
                    for (StickerItem3D stickerItem3D : this.itemList3D) {
                        if (stickerItem3D.alignFacePoints != null && stickerItem3D.alignFacePoints.length > 0) {
                            GamePlaySDK.getInstance().setNodeAlignedHeadPointIndex(stickerItem3D.f18271id, stickerItem3D.alignFacePoints[0]);
                        }
                    }
                }
                this.mFlipFilter.nativeSetRotationAndFlip(rotation, 0, 1);
                int min = Math.min(this.maxFaceCount, faceStatusList.size());
                for (int i = 0; i < min; i++) {
                    FaceStatus faceStatus = (FaceStatus) faceStatusList.get(i);
                    if (faceStatus.denseFaceModel != null) {
                        GamePlaySDK.getInstance().updateHeadData(faceStatus.denseFaceModel, faceStatus.transform);
                        GamePlaySDK.getInstance().onDrawFrame();
                        this.mFlipFilter.nativeSetRotationAndFlip(-rotation, 0, 1);
                        if (!this.isFirstFrame) {
                            GlUtil.setBlendMode(true);
                            if (rotation == 90 || rotation == 270) {
                                if (((double) faceStatus.transform[11]) > 2.5d) {
                                    this.mFlipFilter.RenderProcess(GamePlaySDK.getInstance().getGameTexture(), this.height, this.width, -1, 0.0d, c41672h);
                                }
                            } else if (((double) faceStatus.transform[11]) > 2.5d) {
                                this.mFlipFilter.RenderProcess(GamePlaySDK.getInstance().getGameTexture(), this.width, this.height, -1, 0.0d, c41672h);
                            }
                            GlUtil.setBlendMode(false);
                        }
                    }
                }
            }
            this.isFirstFrame = false;
            AppMethodBeat.m2505o(82561);
        }
        return c41672h;
    }

    /* Access modifiers changed, original: protected */
    public void updateActionTriggered(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(82562);
        Map map = pTDetectInfo.faceActionCounter;
        Map map2 = pTDetectInfo.handActionCounter;
        Set set = pTDetectInfo.triggeredExpression;
        if (this.itemList3D != null) {
            long currentTimeMillis = System.currentTimeMillis();
            for (StickerItem3D stickerItem3D : this.itemList3D) {
                boolean z;
                if (stickerItem3D.activateTriggerTotalCount != 0) {
                    Map map3;
                    if (stickerItem3D.preTriggerType != PTExpression.ALWAYS.value) {
                        if (VideoMaterialUtil.isFaceTriggerType(stickerItem3D.preTriggerType)) {
                        }
                    }
                    boolean isFaceTriggerType = VideoMaterialUtil.isFaceTriggerType(stickerItem3D.countTriggerType);
                    if (isFaceTriggerType) {
                        map3 = map;
                    } else {
                        map3 = map2;
                    }
                    if (map3 != null) {
                        if ((isFaceTriggerType ? ((FaceActionCounter) map.get(Integer.valueOf(stickerItem3D.countTriggerType))).count : ((HandActionCounter) map2.get(Integer.valueOf(stickerItem3D.countTriggerType))).count) % stickerItem3D.activateTriggerTotalCount == stickerItem3D.activateTriggerCount) {
                            if (stickerItem3D.playCount == 0 || stickerItem3D.curPlayCount < stickerItem3D.playCount) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (stickerItem3D.curPlayCount < stickerItem3D.playCount) {
                                if (isFaceTriggerType) {
                                    pTDetectInfo.faceDetector.lockActionCounter();
                                } else {
                                    GestureDetector.getInstance().lockActionCounter();
                                }
                            } else if (stickerItem3D.playCount > 0) {
                                if (isFaceTriggerType) {
                                    pTDetectInfo.faceDetector.clearActionCounter();
                                } else {
                                    GestureDetector.getInstance().clearActionCounter();
                                }
                            }
                        }
                    }
                    z = false;
                } else if (VideoMaterialUtil.isFaceTriggerType(stickerItem3D.triggerType)) {
                    z = set.contains(Integer.valueOf(stickerItem3D.triggerType));
                } else {
                    z = GestureDetector.getInstance().isGestureTriggered(stickerItem3D.triggerType);
                }
                if (z) {
                    if (!stickerItem3D.triggered) {
                        stickerItem3D.frameStartTime = currentTimeMillis;
                    }
                    stickerItem3D.triggered = true;
                } else if (stickerItem3D.alwaysTriggered || stickerItem3D.curPlayCount >= stickerItem3D.playCount) {
                    stickerItem3D.triggered = false;
                }
                stickerItem3D.calFrameIndex(currentTimeMillis);
            }
        }
        if (this.itemList3D != null) {
            ArrayList arrayList = new ArrayList();
            for (StickerItem3D stickerItem3D2 : this.itemList3D) {
                if (stickerItem3D2.triggered) {
                    arrayList.add(stickerItem3D2);
                }
                LogUtils.m50202e(TAG, String.format("item.id  = %s, item.triggered = " + stickerItem3D2.triggered, new Object[]{stickerItem3D2.f18271id}));
            }
            StickerItem3D[] stickerItem3DArr = new StickerItem3D[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                stickerItem3DArr[i] = new StickerItem3D();
                stickerItem3DArr[i].f18271id = ((StickerItem3D) arrayList.get(i)).f18271id.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[0];
                stickerItem3DArr[i].curFrameImagePath = ((StickerItem3D) arrayList.get(i)).curFrameImagePath == null ? "" : ((StickerItem3D) arrayList.get(i)).curFrameImagePath;
            }
            GamePlaySDK.getInstance().updateTriggerInfo(stickerItem3DArr);
        }
        AppMethodBeat.m2505o(82562);
    }

    public void updateVideoSize(int i, int i2, int i3) {
        AppMethodBeat.m2504i(82563);
        if (i3 == 90 || i3 == 270) {
            this.width = i2;
            this.height = i;
        } else {
            this.width = i;
            this.height = i2;
        }
        GamePlaySDK.getInstance().onSurfaceChanged(this.width * 2, this.height * 2);
        AppMethodBeat.m2505o(82563);
    }

    public int getOrderMode() {
        return this.orderMode;
    }

    public int getGameRefTextureID() {
        AppMethodBeat.m2504i(82564);
        int gameRefTextureID = GamePlaySDK.getInstance().getGameRefTextureID();
        AppMethodBeat.m2505o(82564);
        return gameRefTextureID;
    }

    public int getGameRefTextureWidth() {
        AppMethodBeat.m2504i(82565);
        int gameRefTextureWidth = GamePlaySDK.getInstance().getGameRefTextureWidth();
        AppMethodBeat.m2505o(82565);
        return gameRefTextureWidth;
    }

    public int getGameRefTextureHeight() {
        AppMethodBeat.m2504i(82566);
        int gameRefTextureHeight = GamePlaySDK.getInstance().getGameRefTextureHeight();
        AppMethodBeat.m2505o(82566);
        return gameRefTextureHeight;
    }

    public void clear() {
        AppMethodBeat.m2504i(82567);
        this.mFlipFilter.ClearGLSL();
        this.mFlipFrame.clear();
        GamePlaySDK.getInstance().stopGame();
        AppMethodBeat.m2505o(82567);
    }

    private void initFrameBuffer(int i, int i2) {
        AppMethodBeat.m2504i(82568);
        int[] iArr = new int[1];
        GLES20.glGenTextures(this.m2DTexture.length, this.m2DTexture, 0);
        GlUtil.checkGlError("glGenTextures");
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.m2DTexture[0]);
        GlUtil.checkGlError("glBindTexture");
        GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i, i2, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        GLES20.glGenFramebuffers(1, iArr, 0);
        GlUtil.checkGlError("glGenFramebuffers");
        this.mFramebuffer = iArr[0];
        GLES20.glBindFramebuffer(36160, this.mFramebuffer);
        GlUtil.checkGlError("glBindTexture " + this.m2DTexture);
        GLES20.glGenRenderbuffers(1, iArr, 0);
        GlUtil.checkGlError("glGenRenderbuffers");
        this.mDepthBuffer = iArr[0];
        GLES20.glBindRenderbuffer(36161, this.mDepthBuffer);
        GlUtil.checkGlError("glBindRenderbuffer ");
        GLES20.glRenderbufferStorage(36161, 33189, i, i2);
        GlUtil.checkGlError("glRenderbufferStorage");
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mDepthBuffer);
        GlUtil.checkGlError("glFramebufferRenderbuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.m2DTexture[0], 0);
        GlUtil.checkGlError("glFramebufferTexture2D");
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            RuntimeException runtimeException = new RuntimeException("Framebuffer not complete, status=".concat(String.valueOf(glCheckFramebufferStatus)));
            AppMethodBeat.m2505o(82568);
            throw runtimeException;
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glActiveTexture(33984);
        AppMethodBeat.m2505o(82568);
    }
}
