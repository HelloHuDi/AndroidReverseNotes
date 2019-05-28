package com.tencent.ttpic.p683ar.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C25626j;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.oscarcamera.particlesystem.FrameParticleData;
import com.tencent.oscarcamera.particlesystem.ParticleSystemEx;
import com.tencent.oscarcamera.particlesystem.Sprite;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.Point3D;
import com.tencent.ttpic.p683ar.util.ARMatrixUtil;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.ttpic.ar.filter.ARParticleFilter */
public class ARParticleFilter extends VideoFilterBase {
    private static final String FRAGMENT_SHADER_COMMON = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ARParticleFragmentShader.dat");
    private static final String VERTEX_SHADER_COMMON = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ARParticleVertexShader.dat");
    private String TAG = ARParticleFilter.class.getSimpleName();
    private float far = 2000.0f;
    private FrameData[] frameDataBufferQueue = new FrameData[2];
    private int frameDataBufferQueueIndex = 0;
    private float mCanvasHeight;
    private float mCanvasWidth;
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mCopyFrame = new C41672h();
    private FrameData mLastFrameData;
    private ParticleCalculationHandler mParticleCalculationHandler;
    private List<String> mParticleDirList;
    private ParticleSystemEx mParticleSystem = new ParticleSystemEx(VideoGlobalContext.getContext());
    private Map<String, Integer> mPathToBitmapIndexMapping = new HashMap();
    private Map<String, Player> mPlayerMapping = new HashMap();
    private List<Sprite> mSpriteList;
    private List<ArrayList<TexCoord>> mTexCoords = new ArrayList();
    private Bitmap[] mTextureBitmaps;
    private Size[] mTextureSizes;
    private int[] mTextures;
    private float mViewDistance;
    private float near = 100.0f;

    /* renamed from: com.tencent.ttpic.ar.filter.ARParticleFilter$ParticleCalculationHandler */
    class ParticleCalculationHandler extends Handler {
        public boolean isStopped = false;

        public ParticleCalculationHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            AppMethodBeat.m2504i(81653);
            if (this.isStopped) {
                AppMethodBeat.m2505o(81653);
                return;
            }
            int i = message.what;
            FrameData frameData = new FrameData();
            List advance = ARParticleFilter.this.mParticleSystem.advance();
            if (advance == null) {
                AppMethodBeat.m2505o(81653);
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= advance.size() || i3 >= ARParticleFilter.this.mSpriteList.size() || i3 >= ARParticleFilter.this.mParticleDirList.size()) {
                    ARParticleFilter.this.frameDataBufferQueue[i] = frameData;
                    ARParticleFilter.this.frameDataBufferQueue[i].ready = true;
                    AppMethodBeat.m2505o(81653);
                } else {
                    FrameParticleData frameParticleData = (FrameParticleData) advance.get(i3);
                    Sprite sprite = (Sprite) ARParticleFilter.this.mSpriteList.get(i3);
                    FrameParticleData frameParticleData2 = new FrameParticleData();
                    frameParticleData2.blendMode = frameParticleData.blendMode;
                    frameParticleData2.particleCount = frameParticleData.particleCount;
                    frameParticleData2.tex = sprite.path;
                    frameParticleData2.positionIndex = frameParticleData.positionIndex;
                    frameParticleData2.particleCenter = frameParticleData.particleCenter;
                    frameParticleData2.particleSize = frameParticleData.particleSize;
                    frameParticleData2.texCoords = frameParticleData.texCoords;
                    frameParticleData2.particleColor = frameParticleData.particleColor;
                    frameParticleData2.audioPath = ARParticleFilter.this.dataPath + File.separator + ((String) ARParticleFilter.this.mParticleDirList.get(i3)) + File.separator + sprite.audioPath;
                    if (!(frameData.needPlayMusic || TextUtils.isEmpty(frameParticleData.audioPath))) {
                        frameData.needPlayMusic = frameParticleData.playAudio;
                    }
                    frameData.frameParticleData.add(frameParticleData2);
                    i2 = i3 + 1;
                }
            }
            ARParticleFilter.this.frameDataBufferQueue[i] = frameData;
            ARParticleFilter.this.frameDataBufferQueue[i].ready = true;
            AppMethodBeat.m2505o(81653);
        }
    }

    /* renamed from: com.tencent.ttpic.ar.filter.ARParticleFilter$TexCoord */
    class TexCoord {
        float[] texCoord = new float[12];

        TexCoord() {
            AppMethodBeat.m2504i(81654);
            AppMethodBeat.m2505o(81654);
        }
    }

    /* renamed from: com.tencent.ttpic.ar.filter.ARParticleFilter$BitmapDecodeTask */
    class BitmapDecodeTask extends AsyncTask<Void, Void, Void> {
        BitmapDecodeTask() {
        }

        private void preCalTexCoords(int i, int i2, int i3, int i4, int i5) {
            AppMethodBeat.m2504i(81649);
            int i6 = i3 / i5;
            int i7 = i2 / i4;
            float f = (((float) i4) * 1.0f) / ((float) i2);
            float f2 = (((float) i5) * 1.0f) / ((float) i3);
            ARParticleFilter.this.mTexCoords.add(i, new ArrayList());
            for (int i8 = 0; i8 < i6; i8++) {
                for (int i9 = 0; i9 < i7; i9++) {
                    PointF pointF = new PointF(((float) i9) * f, ((float) i8) * f2);
                    PointF pointF2 = new PointF(pointF.x, pointF.y + f2);
                    PointF pointF3 = new PointF(pointF.x + f, pointF.y);
                    PointF pointF4 = new PointF(pointF3.x, pointF.y + f2);
                    TexCoord texCoord = new TexCoord();
                    texCoord.texCoord[0] = pointF3.x;
                    texCoord.texCoord[1] = pointF3.y;
                    texCoord.texCoord[2] = pointF4.x;
                    texCoord.texCoord[3] = pointF4.y;
                    texCoord.texCoord[4] = pointF2.x;
                    texCoord.texCoord[5] = pointF2.y;
                    texCoord.texCoord[6] = pointF3.x;
                    texCoord.texCoord[7] = pointF3.y;
                    texCoord.texCoord[8] = pointF2.x;
                    texCoord.texCoord[9] = pointF2.y;
                    texCoord.texCoord[10] = pointF.x;
                    texCoord.texCoord[11] = pointF.y;
                    ((ArrayList) ARParticleFilter.this.mTexCoords.get(i)).add(texCoord);
                }
            }
            AppMethodBeat.m2505o(81649);
        }

        /* Access modifiers changed, original: protected|varargs */
        public Void doInBackground(Void... voidArr) {
            AppMethodBeat.m2504i(81650);
            if (!(ARParticleFilter.this.mSpriteList == null || ARParticleFilter.this.mParticleDirList == null)) {
                int i = 0;
                while (i < ARParticleFilter.this.mSpriteList.size() && i < ARParticleFilter.this.mParticleDirList.size()) {
                    Bitmap decodeSampledBitmapFromAssets;
                    Sprite sprite = (Sprite) ARParticleFilter.this.mSpriteList.get(i);
                    String str = ARParticleFilter.this.dataPath + File.separator + ((String) ARParticleFilter.this.mParticleDirList.get(i)) + File.separator + sprite.path;
                    if (str.startsWith("assets://")) {
                        decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(str), BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
                    } else {
                        decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromFile(str, BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
                    }
                    if (ARParticleFilter.access$400(ARParticleFilter.this, decodeSampledBitmapFromAssets)) {
                        preCalTexCoords(i, decodeSampledBitmapFromAssets.getWidth(), decodeSampledBitmapFromAssets.getHeight(), sprite.width, sprite.height);
                        ARParticleFilter.this.mTextureBitmaps[i] = decodeSampledBitmapFromAssets;
                    }
                    i++;
                }
            }
            AppMethodBeat.m2505o(81650);
            return null;
        }
    }

    /* renamed from: com.tencent.ttpic.ar.filter.ARParticleFilter$FrameData */
    class FrameData {
        public List<FrameParticleData> frameParticleData = new ArrayList();
        public boolean needPlayMusic;
        public boolean ready;

        FrameData() {
            AppMethodBeat.m2504i(81652);
            AppMethodBeat.m2505o(81652);
        }
    }

    /* renamed from: com.tencent.ttpic.ar.filter.ARParticleFilter$FrameParticleData */
    class FrameParticleData {
        public String audioPath;
        public int blendMode;
        public float[] particleCenter;
        public float[] particleColor;
        public int particleCount;
        public float[] particleSize;
        public float[] positionIndex;
        public String tex;
        public float[] texCoords;

        FrameParticleData() {
        }
    }

    /* renamed from: com.tencent.ttpic.ar.filter.ARParticleFilter$Size */
    class Size {
        public int height;
        public int width;

        Size() {
        }

        Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public boolean isValid() {
            return (this.width == 0 || this.height == 0) ? false : true;
        }
    }

    static /* synthetic */ boolean access$400(ARParticleFilter aRParticleFilter, Bitmap bitmap) {
        AppMethodBeat.m2504i(81675);
        boolean isBitmapLegal = aRParticleFilter.isBitmapLegal(bitmap);
        AppMethodBeat.m2505o(81675);
        return isBitmapLegal;
    }

    static {
        AppMethodBeat.m2504i(81676);
        AppMethodBeat.m2505o(81676);
    }

    public ARParticleFilter(List<String> list, String str) {
        super(VERTEX_SHADER_COMMON, FRAGMENT_SHADER_COMMON);
        AppMethodBeat.m2504i(81655);
        this.dataPath = str;
        setDrawMode(DRAW_MODE.TRIANGLES);
        initParticle(list);
        AppMethodBeat.m2505o(81655);
    }

    private void initParticle(List<String> list) {
        AppMethodBeat.m2504i(81656);
        if (list != null) {
            this.mParticleDirList = new ArrayList();
            ArrayList arrayList = new ArrayList(list);
            for (int i = 0; i < arrayList.size(); i++) {
                this.mParticleDirList.add(((String) arrayList.get(i)).substring(0, ((String) arrayList.get(i)).lastIndexOf("/")));
                arrayList.set(i, FileUtils.getRealPath(this.dataPath + File.separator + ((String) arrayList.get(i))));
            }
            this.mParticleSystem.loadParticleData(arrayList);
            this.mSpriteList = this.mParticleSystem.getSprites();
            this.mTextureBitmaps = new Bitmap[this.mSpriteList.size()];
            this.mTextures = new int[this.mSpriteList.size()];
            this.mTextureSizes = new Size[this.mSpriteList.size()];
            int i2 = 0;
            while (i2 < this.mSpriteList.size() && i2 < this.mParticleDirList.size()) {
                this.mPathToBitmapIndexMapping.put(((String) this.mParticleDirList.get(i2)) + File.separator + ((Sprite) this.mSpriteList.get(i2)).path, Integer.valueOf(i2));
                this.mTexCoords.add(new ArrayList());
                i2++;
            }
            new BitmapDecodeTask().execute(new Void[0]);
        }
        HandlerThread handlerThread = new HandlerThread("ParticleCalculationThread", -16);
        handlerThread.start();
        this.mParticleCalculationHandler = new ParticleCalculationHandler(handlerThread.getLooper());
        this.mParticleCalculationHandler.sendEmptyMessage(0);
        AppMethodBeat.m2505o(81656);
    }

    public void initParams() {
        AppMethodBeat.m2504i(81657);
        this.mViewDistance = this.near + ((this.far - this.near) * 0.5f);
        addParam(new C25626j("u_MVPMatrix", ARMatrixUtil.getMovedMVPMatrix(this.near, this.far)));
        addParam(new C0935i("blendMode", 0));
        addParam(new C0933f("canvasWidth", 1.0f));
        addParam(new C0933f("canvasHeight", 1.0f));
        addParam(new C0935i("isFrontCamera", 0));
        ARMatrixUtil.startOrientationSensor();
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.m2505o(81657);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(81658);
        super.updateVideoSize(i, i2, d);
        this.mCanvasWidth = (float) i;
        this.mCanvasHeight = (float) i2;
        ARMatrixUtil.updateRenderSize(i, i2);
        AppMethodBeat.m2505o(81658);
    }

    private void vectorNormalization(float[] fArr) {
        AppMethodBeat.m2504i(81659);
        if (fArr == null || fArr.length < 3) {
            AppMethodBeat.m2505o(81659);
            return;
        }
        float sqrt = (float) Math.sqrt((double) ((pow2(fArr[0]) + pow2(fArr[1])) + pow2(fArr[2])));
        if (sqrt > 0.0f) {
            fArr[0] = fArr[0] / sqrt;
            fArr[1] = fArr[1] / sqrt;
            fArr[2] = fArr[2] / sqrt;
        }
        AppMethodBeat.m2505o(81659);
    }

    private float pow2(float f) {
        return f * f;
    }

    public void render(C41672h c41672h) {
        FrameData frameData;
        AppMethodBeat.m2504i(81660);
        FrameData frameData2 = this.frameDataBufferQueue[this.frameDataBufferQueueIndex];
        if (frameData2 != null && frameData2.ready) {
            frameData = frameData2;
        } else if (this.mLastFrameData != null) {
            frameData = this.mLastFrameData;
        } else {
            AppMethodBeat.m2505o(81660);
            return;
        }
        this.mLastFrameData = frameData;
        frameData.ready = false;
        this.frameDataBufferQueueIndex = (this.frameDataBufferQueueIndex + 1) % 2;
        this.mParticleCalculationHandler.sendEmptyMessage(this.frameDataBufferQueueIndex);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= frameData.frameParticleData.size() || i2 >= this.mParticleDirList.size()) {
                playMusicIfNeeded(frameData);
                AppMethodBeat.m2505o(81660);
            } else {
                int i3 = c41672h.texture[0];
                FrameParticleData frameParticleData = (FrameParticleData) frameData.frameParticleData.get(i2);
                if (needCopyTex(frameParticleData.blendMode)) {
                    this.mCopyFilter.RenderProcess(c41672h.texture[0], this.width, this.height, -1, 0.0d, this.mCopyFrame);
                    int i4 = this.mCopyFrame.texture[0];
                    c41672h.mo67189a(-1, c41672h.width, c41672h.height, 0.0d);
                    i3 = i4;
                }
                if (changeTexture(((String) this.mParticleDirList.get(i2)) + File.separator + frameParticleData.tex)) {
                    setPositionIndex(frameParticleData.positionIndex);
                    setParticleCenter(frameParticleData.particleCenter);
                    setParticleSize(frameParticleData.particleSize);
                    setParticleColor(frameParticleData.particleColor);
                    setCoordNum(frameParticleData.particleCount * 6);
                    setTexCords(frameParticleData.texCoords);
                    addParam(new C0935i("blendMode", frameParticleData.blendMode));
                    addParam(new C25626j("u_MVPMatrix", ARMatrixUtil.getMovedMVPMatrix(this.near, this.far)));
                    addParam(new C0933f("canvasWidth", this.mCanvasWidth));
                    addParam(new C0933f("canvasHeight", this.mCanvasHeight));
                    addParam(new C0935i("isFrontCamera", ARMatrixUtil.isFrontCamera ? 1 : 0));
                    OnDrawFrameGLSL();
                    super.renderTexture(i3, this.width, this.height);
                }
                i = i2 + 1;
            }
        }
        playMusicIfNeeded(frameData);
        AppMethodBeat.m2505o(81660);
    }

    private void playMusicIfNeeded(FrameData frameData) {
        AppMethodBeat.m2504i(81661);
        if (frameData.needPlayMusic) {
            for (FrameParticleData frameParticleData : frameData.frameParticleData) {
                if (!TextUtils.isEmpty(frameParticleData.audioPath)) {
                    String str = frameParticleData.audioPath;
                    if (!this.mPlayerMapping.containsKey(str)) {
                        Object createPlayerFromAssets;
                        if (str.startsWith("assets://")) {
                            createPlayerFromAssets = PlayerUtil.createPlayerFromAssets(VideoGlobalContext.getContext(), str.replace("assets://", ""), false);
                        } else {
                            createPlayerFromAssets = PlayerUtil.createPlayerFromUri(VideoGlobalContext.getContext(), str, false);
                        }
                        this.mPlayerMapping.put(str, createPlayerFromAssets);
                    }
                    Player player = (Player) this.mPlayerMapping.get(str);
                    if (player != null) {
                        PlayerUtil.startPlayer(player, true);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(81661);
    }

    public boolean setPositionIndex(float[] fArr) {
        AppMethodBeat.m2504i(81662);
        addAttribParam(new AttributeParam("positionIndex", fArr, 1));
        AppMethodBeat.m2505o(81662);
        return true;
    }

    public boolean setParticleCenter(float[] fArr) {
        AppMethodBeat.m2504i(81663);
        addAttribParam(new AttributeParam("particleCenter", fArr, 3));
        AppMethodBeat.m2505o(81663);
        return true;
    }

    public boolean setParticleSize(float[] fArr) {
        AppMethodBeat.m2504i(81664);
        addAttribParam(new AttributeParam("particleSize", fArr, 2));
        AppMethodBeat.m2505o(81664);
        return true;
    }

    public boolean setParticleColor(float[] fArr) {
        AppMethodBeat.m2504i(81665);
        addAttribParam(new AttributeParam("particleColor", fArr, 4));
        AppMethodBeat.m2505o(81665);
        return true;
    }

    private boolean changeTexture(String str) {
        AppMethodBeat.m2504i(81666);
        if (this.mPathToBitmapIndexMapping.containsKey(str)) {
            int intValue = ((Integer) this.mPathToBitmapIndexMapping.get(str)).intValue();
            if (this.mTextures[intValue] == 0) {
                Bitmap bitmap = this.mTextureBitmaps[intValue];
                if (isBitmapLegal(bitmap)) {
                    this.mTextureSizes[intValue] = new Size(bitmap.getWidth(), bitmap.getHeight());
                    GLES20.glGenTextures(1, this.mTextures, intValue);
                    GLES20.glBindTexture(3553, this.mTextures[intValue]);
                    GLES20.glTexParameteri(3553, 10240, 9729);
                    GLES20.glTexParameteri(3553, 10241, 9729);
                    GLES20.glTexParameteri(3553, 10242, 33071);
                    GLES20.glTexParameteri(3553, 10243, 33071);
                    try {
                        GLUtils.texImage2D(3553, 0, bitmap, 0);
                        bitmap.recycle();
                    } catch (OutOfMemoryError e) {
                        AppMethodBeat.m2505o(81666);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(81666);
                return false;
            }
            C25627n c25627n = new C25627n("inputImageTexture2", this.mTextures[intValue], 33986);
            c25627n.initialParams(getProgramIds());
            addParam(c25627n);
            if (this.mTextureSizes[intValue] == null || !this.mTextureSizes[intValue].isValid()) {
                AppMethodBeat.m2505o(81666);
                return false;
            }
            AppMethodBeat.m2505o(81666);
            return true;
        }
        AppMethodBeat.m2505o(81666);
        return false;
    }

    private boolean isBitmapLegal(Bitmap bitmap) {
        AppMethodBeat.m2504i(81667);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(81667);
            return false;
        }
        AppMethodBeat.m2505o(81667);
        return true;
    }

    private void calTexCoordList(int i, int i2, int i3, float[] fArr) {
        AppMethodBeat.m2504i(81668);
        if (i < this.mTexCoords.size()) {
            ArrayList arrayList = (ArrayList) this.mTexCoords.get(i);
            if (i2 < 0 || i2 >= arrayList.size()) {
                i2 = 0;
            }
            if (i2 < arrayList.size()) {
                TexCoord texCoord = (TexCoord) arrayList.get(i2);
                int i4 = i3 * 12;
                int i5 = 0;
                while (i5 < 12 && i4 < fArr.length) {
                    fArr[i4] = texCoord.texCoord[i5];
                    i5++;
                    i4++;
                }
            }
        }
        AppMethodBeat.m2505o(81668);
    }

    public void addTouchPoint(PointF pointF) {
        AppMethodBeat.m2504i(81669);
        float f = ARMatrixUtil.nearRectHeight / ARMatrixUtil.nearRectWidth;
        float f2 = ARMatrixUtil.nearRectWidth * (this.mViewDistance / ARMatrixUtil.near);
        float f3 = ARMatrixUtil.nearRectHeight * (this.mViewDistance / ARMatrixUtil.near);
        Point3D point3D = new Point3D();
        point3D.f16562x = this.mViewDistance * ARMatrixUtil.cameraX;
        point3D.f16563y = this.mViewDistance * ARMatrixUtil.cameraY;
        point3D.f16564z = this.mViewDistance * ARMatrixUtil.cameraZ;
        float[] fArr = new float[]{(ARMatrixUtil.cameraUpX * f) + ARMatrixUtil.cameraRightX, (ARMatrixUtil.cameraUpY * f) + ARMatrixUtil.cameraRightY, (ARMatrixUtil.cameraUpZ * f) + ARMatrixUtil.cameraRightZ};
        vectorNormalization(fArr);
        f2 = ((float) Math.sqrt((double) (pow2(f2) + pow2(f3)))) / 2.0f;
        Point3D point3D2 = new Point3D();
        point3D2.f16562x = point3D.f16562x - (fArr[0] * f2);
        point3D2.f16563y = point3D.f16563y - (fArr[1] * f2);
        point3D2.f16564z = point3D.f16564z - (fArr[2] * f2);
        fArr = new float[]{(ARMatrixUtil.cameraUpX * f) - ARMatrixUtil.cameraRightX, (ARMatrixUtil.cameraUpY * f) - ARMatrixUtil.cameraRightY, (f * ARMatrixUtil.cameraUpZ) - ARMatrixUtil.cameraRightZ};
        vectorNormalization(fArr);
        Point3D point3D3 = new Point3D();
        point3D3.f16562x = point3D.f16562x + (fArr[0] * f2);
        point3D3.f16563y = point3D.f16563y + (fArr[1] * f2);
        point3D3.f16564z = point3D.f16564z + (fArr[2] * f2);
        Point3D point3D4 = new Point3D();
        point3D4.f16562x = point3D.f16562x - (fArr[0] * f2);
        point3D4.f16563y = point3D.f16563y - (fArr[1] * f2);
        point3D4.f16564z = point3D.f16564z - (f2 * fArr[2]);
        f = pointF.x / ((float) this.width);
        if (ARMatrixUtil.isFrontCamera) {
            f = 1.0f - f;
        }
        float[] fArr2 = new float[]{(point3D4.f16562x - point3D2.f16562x) * f, (point3D4.f16563y - point3D2.f16563y) * f, f * (point3D4.f16564z - point3D2.f16564z)};
        f = 1.0f - (pointF.y / ((float) this.height));
        float[] fArr3 = new float[]{(point3D3.f16562x - point3D2.f16562x) * f, (point3D3.f16563y - point3D2.f16563y) * f, f * (point3D3.f16564z - point3D2.f16564z)};
        Point3D point3D5 = new Point3D();
        point3D5.f16562x = (point3D2.f16562x + fArr2[0]) + fArr3[0];
        point3D5.f16563y = (point3D2.f16563y + fArr2[1]) + fArr3[1];
        point3D5.f16564z = (fArr2[2] + point3D2.f16564z) + fArr3[2];
        this.mParticleSystem.emitImmediately(point3D5.f16562x, point3D5.f16563y, point3D5.f16564z);
        AppMethodBeat.m2505o(81669);
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(81670);
        setTexCords(new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f});
        setCoordNum(4);
        addAttribParam(new AttributeParam("positionIndex", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 1));
        addAttribParam(new AttributeParam("particleCenter", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 3));
        addAttribParam(new AttributeParam("particleSize", new float[]{0.0f, 0.0f}, 2));
        addAttribParam(new AttributeParam("particleColor", new float[]{0.0f, 0.0f, 0.0f, 0.0f}, 4));
        initParams();
        AppMethodBeat.m2505o(81670);
    }

    public boolean needCopyTex(int i) {
        return i >= 2 && i <= 12;
    }

    public boolean needCopyTex() {
        AppMethodBeat.m2504i(81671);
        if (this.mSpriteList != null) {
            for (Sprite sprite : this.mSpriteList) {
                if (sprite.blendMode >= 2 && sprite.blendMode <= 12) {
                    AppMethodBeat.m2505o(81671);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(81671);
        return false;
    }

    public void updateAndRender(C41672h c41672h) {
        AppMethodBeat.m2504i(81672);
        ARMatrixUtil.updateOrientation();
        render(c41672h);
        AppMethodBeat.m2505o(81672);
    }

    public void clear() {
        AppMethodBeat.m2504i(81673);
        super.clearGLSLSelf();
        ARMatrixUtil.stopOrientationSensor();
        for (Bitmap bitmap : this.mTextureBitmaps) {
            if (isBitmapLegal(bitmap)) {
                bitmap.recycle();
            }
        }
        GLES20.glDeleteTextures(this.mTextures.length, this.mTextures, 0);
        this.mCopyFilter.ClearGLSL();
        this.mCopyFrame.clear();
        destroyAudioPlayer();
        if (this.mParticleCalculationHandler != null) {
            this.mParticleCalculationHandler.isStopped = true;
            this.mParticleCalculationHandler.getLooper().quit();
        }
        this.mParticleSystem.release();
        System.gc();
        AppMethodBeat.m2505o(81673);
    }

    public void destroyAudioPlayer() {
        AppMethodBeat.m2504i(81674);
        for (Player destroyPlayer : this.mPlayerMapping.values()) {
            PlayerUtil.destroyPlayer(destroyPlayer);
        }
        this.mPlayerMapping.clear();
        AppMethodBeat.m2505o(81674);
    }
}
