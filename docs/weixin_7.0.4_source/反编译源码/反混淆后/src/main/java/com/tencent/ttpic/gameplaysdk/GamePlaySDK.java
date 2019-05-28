package com.tencent.ttpic.gameplaysdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLES20;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.manager.FeatureManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

public class GamePlaySDK {
    private static final int HEAD_MESH_UPDATE_FRAME_INTERVAL = 10;
    private static final String TAG = GamePlaySDK.class.getSimpleName();
    public static Context context;
    private static GamePlaySDK mInstance;
    private float fov = 60.0f;
    private long gameHandler;
    private int gameTextureId;
    private int headMeshUpdateFrameCount = 0;
    private boolean hideScreen;
    private boolean isSoLoaded = false;
    private int mHeight;
    private int mWidth;
    private ThreadLocal threadLocal = new ThreadLocal();

    class State {
        public boolean isInited;

        private State() {
            this.isInited = false;
        }

        /* synthetic */ State(GamePlaySDK gamePlaySDK, C411041 c411041) {
            this();
        }
    }

    public static native void nativeSetLogLevel(int i);

    public static native void native_clearItemImage();

    public static native void native_destroy(long j);

    public static native String native_getFinishAnimationNodeIds();

    public static native int native_getReflectTextureHeight(long j);

    public static native int native_getReflectTextureID(long j);

    public static native int native_getReflectTextureWidth(long j);

    public static native boolean native_getTipsPos(float[] fArr);

    public static native int native_hasGame(long j);

    public static native long native_init(Context context, AssetManager assetManager, String str, GameParams gameParams);

    public static native void native_loadItemImage(String str, String str2, boolean z);

    public static native void native_onContextDestroy(long j);

    public static native void native_onDrawFrame(long j);

    public static native long native_onOrientationChanged(int i);

    public static native void native_onSensorChanged(float f, float f2, float f3, long j, int i);

    public static native void native_onSurfaceChanged(long j, int i, int i2);

    public static native void native_onSurfaceCreated(long j, int i, int i2);

    public static native void native_onTouchBegin(int i, float f, float f2, int i2, long j, long j2);

    public static native void native_onTouchCancel(int[] iArr, float[] fArr, float[] fArr2, long j, long j2);

    public static native void native_onTouchEnd(int i, float f, float f2, int i2, long j, long j2);

    public static native void native_onTouchMove(int[] iArr, float[] fArr, float[] fArr2, long j, long j2);

    public static native void native_pause(long j);

    public static native void native_resume(long j);

    public static native void native_setFov(float f);

    public static native void native_setNodeAlignedHeadPointIndex(String str, int i);

    public static native void native_setOutputTexture(long j, int i);

    public static native void native_setSensorSupport(int i, boolean z);

    public static native void native_startGame(long j, String str, GameParams gameParams, NodeParameter[] nodeParameterArr);

    public static native void native_stopGame(long j);

    public static native void native_updateAccel(float f, float f2, float f3);

    public static native void native_updateAzimuth(long j, float f);

    public static native void native_updateCameraTex(int i, int i2, int i3);

    public static native void native_updateHeadData(float[] fArr);

    public static native void native_updateMatrix(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9);

    public static native void native_updatePitch(long j, float f);

    public static native void native_updateQuaternion(float f, float f2, float f3, float f4);

    public static native void native_updateRoll(long j, float f);

    public static native void native_updateSensor(long j, float f, float f2, float f3);

    public static native void native_updateTransformMatrix(float[] fArr);

    public static native void native_updateTriggerInfo(StickerItem3D[] stickerItem3DArr);

    static {
        AppMethodBeat.m2504i(83221);
        AppMethodBeat.m2505o(83221);
    }

    private void loadGamePlaySOForDebug() {
        AppMethodBeat.m2504i(83193);
        try {
            if (!this.isSoLoaded) {
                String str = "libgameplay.so";
                File file = new File(Environment.getExternalStorageDirectory() + File.separator + str);
                if (!file.exists()) {
                    new StringBuilder().append(file.getAbsolutePath()).append(" is not fond!");
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                File file2 = new File(context.getDir("libs", 0), str);
                new StringBuilder("### ").append(file2.getAbsolutePath()).append(" is not exists");
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
                fileOutputStream.close();
                fileInputStream.close();
                System.load(file2.getAbsolutePath());
                this.isSoLoaded = true;
            }
            AppMethodBeat.m2505o(83193);
        } catch (Exception e) {
            new StringBuilder("Exception   ").append(e.getMessage());
            AppMethodBeat.m2505o(83193);
        }
    }

    private void loadGamePlaySO() {
        AppMethodBeat.m2504i(83194);
        if (FeatureManager.isGameplayReady() && !this.isSoLoaded) {
            try {
                FeatureManager.loadLibrary("gameplay");
                LogUtils.m50202e(TAG, "loadLibrary arengine success.");
            } catch (Exception e) {
                LogUtils.m50202e(TAG, "loadLibrary arengine failed: " + e.getMessage());
            }
            this.isSoLoaded = true;
        }
        AppMethodBeat.m2505o(83194);
    }

    public static synchronized GamePlaySDK getInstance() {
        GamePlaySDK gamePlaySDK;
        synchronized (GamePlaySDK.class) {
            AppMethodBeat.m2504i(83195);
            if (mInstance == null) {
                mInstance = new GamePlaySDK();
            }
            gamePlaySDK = mInstance;
            AppMethodBeat.m2505o(83195);
        }
        return gamePlaySDK;
    }

    private GamePlaySDK() {
        AppMethodBeat.m2504i(83196);
        loadGamePlaySO();
        AppMethodBeat.m2505o(83196);
    }

    public void init(Context context, AssetManager assetManager, String str, GameParams gameParams, int i, int i2) {
        AppMethodBeat.m2504i(83197);
        if (!isInited() && this.isSoLoaded) {
            try {
                this.mWidth = i;
                this.mHeight = i2;
                this.gameHandler = native_init(context, assetManager, str, gameParams);
                initGameTexture();
                native_setOutputTexture(this.gameHandler, this.gameTextureId);
                native_onSurfaceCreated(this.gameHandler, i, i2);
                setIsInited(true);
                AppMethodBeat.m2505o(83197);
                return;
            } catch (UnsatisfiedLinkError e) {
            }
        }
        AppMethodBeat.m2505o(83197);
    }

    public void onSurfaceChanged(int i, int i2) {
        AppMethodBeat.m2504i(83198);
        if (isInited() && !(this.mWidth == i && this.mHeight == i2)) {
            this.mWidth = i;
            this.mHeight = i2;
            native_onSurfaceChanged(this.gameHandler, i, i2);
        }
        AppMethodBeat.m2505o(83198);
    }

    public boolean isInited() {
        AppMethodBeat.m2504i(83199);
        Object obj = this.threadLocal.get();
        if (obj == null || !(obj instanceof State)) {
            AppMethodBeat.m2505o(83199);
            return false;
        }
        boolean z = ((State) obj).isInited;
        AppMethodBeat.m2505o(83199);
        return z;
    }

    private void setIsInited(boolean z) {
        AppMethodBeat.m2504i(83200);
        Object obj = this.threadLocal.get();
        if (obj == null || !(obj instanceof State)) {
            State state = new State(this, null);
            state.isInited = z;
            this.threadLocal.set(state);
            AppMethodBeat.m2505o(83200);
            return;
        }
        ((State) obj).isInited = z;
        AppMethodBeat.m2505o(83200);
    }

    private void initGameTexture() {
        AppMethodBeat.m2504i(83201);
        if (this.gameTextureId <= 0) {
            this.gameTextureId = createTexture(3553);
        }
        AppMethodBeat.m2505o(83201);
    }

    private int createTexture(int i) {
        AppMethodBeat.m2504i(83202);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i, iArr[0]);
        GLES20.glTexParameterf(i, 10241, 9729.0f);
        GLES20.glTexParameterf(i, 10240, 9729.0f);
        GLES20.glTexParameteri(i, 10242, 33071);
        GLES20.glTexParameteri(i, 10243, 33071);
        int i2 = iArr[0];
        AppMethodBeat.m2505o(83202);
        return i2;
    }

    public int getGameTexture() {
        return this.gameTextureId;
    }

    public int getGameRefTextureID() {
        AppMethodBeat.m2504i(83203);
        int native_getReflectTextureID = native_getReflectTextureID(this.gameHandler);
        AppMethodBeat.m2505o(83203);
        return native_getReflectTextureID;
    }

    public int getGameRefTextureWidth() {
        AppMethodBeat.m2504i(83204);
        int native_getReflectTextureWidth = native_getReflectTextureWidth(this.gameHandler);
        AppMethodBeat.m2505o(83204);
        return native_getReflectTextureWidth;
    }

    public int getGameRefTextureHeight() {
        AppMethodBeat.m2504i(83205);
        int native_getReflectTextureHeight = native_getReflectTextureHeight(this.gameHandler);
        AppMethodBeat.m2505o(83205);
        return native_getReflectTextureHeight;
    }

    public void onDrawFrame() {
        AppMethodBeat.m2504i(83206);
        if (this.gameHandler != 0) {
            GLES20.glFlush();
            LogUtils.m50202e(TAG, "game play sdk onDrawFrame");
            native_onDrawFrame(this.gameHandler);
        }
        AppMethodBeat.m2505o(83206);
    }

    public void onPause() {
        AppMethodBeat.m2504i(83207);
        if (this.gameHandler != 0) {
            native_pause(this.gameHandler);
        }
        AppMethodBeat.m2505o(83207);
    }

    public void onResume() {
        AppMethodBeat.m2504i(83208);
        if (this.gameHandler != 0) {
            native_resume(this.gameHandler);
        }
        AppMethodBeat.m2505o(83208);
    }

    public void startGame(String str, GameParams gameParams, NodeParameter[] nodeParameterArr) {
        AppMethodBeat.m2504i(83209);
        if (this.isSoLoaded) {
            native_startGame(this.gameHandler, str, gameParams, nodeParameterArr);
            this.fov = gameParams.fov;
            AppMethodBeat.m2505o(83209);
            return;
        }
        AppMethodBeat.m2505o(83209);
    }

    public void stopGame() {
        AppMethodBeat.m2504i(83210);
        if (this.gameHandler != 0 && native_hasGame(this.gameHandler) > 0) {
            native_stopGame(this.gameHandler);
            this.headMeshUpdateFrameCount = 0;
        }
        AppMethodBeat.m2505o(83210);
    }

    public void destroyGame() {
        AppMethodBeat.m2504i(83211);
        if (this.gameHandler != 0) {
            native_destroy(this.gameHandler);
        }
        AppMethodBeat.m2505o(83211);
    }

    public void clear() {
        AppMethodBeat.m2504i(83212);
        if (isInited()) {
            destroyGame();
            GLES20.glDeleteTextures(1, new int[]{this.gameTextureId}, 0);
            this.gameTextureId = 0;
            this.gameHandler = 0;
            this.threadLocal.remove();
            this.headMeshUpdateFrameCount = 0;
        }
        AppMethodBeat.m2505o(83212);
    }

    public void updateHeadData(float[] fArr, float[] fArr2) {
        AppMethodBeat.m2504i(83213);
        if (isInited()) {
            int i = this.headMeshUpdateFrameCount;
            this.headMeshUpdateFrameCount = i + 1;
            if (i % 10 == 0) {
                native_updateHeadData(fArr);
            }
            native_updateTransformMatrix(fArr2);
        }
        AppMethodBeat.m2505o(83213);
    }

    public boolean hasGame() {
        AppMethodBeat.m2504i(83214);
        if (this.gameHandler == 0 || this.gameTextureId <= 0 || native_hasGame(this.gameHandler) <= 0) {
            AppMethodBeat.m2505o(83214);
            return false;
        }
        AppMethodBeat.m2505o(83214);
        return true;
    }

    public void updateTriggerInfo(StickerItem3D[] stickerItem3DArr) {
        AppMethodBeat.m2504i(83215);
        native_updateTriggerInfo(stickerItem3DArr);
        AppMethodBeat.m2505o(83215);
    }

    public Set<String> getFinishAnimationNodeIds() {
        AppMethodBeat.m2504i(83216);
        HashSet hashSet = new HashSet();
        String[] split = native_getFinishAnimationNodeIds().split("-");
        if (split != null) {
            for (Object add : split) {
                hashSet.add(add);
            }
        }
        AppMethodBeat.m2505o(83216);
        return hashSet;
    }

    public void toggleHideScreen() {
        this.hideScreen = !this.hideScreen;
    }

    public void setNodeAlignedHeadPointIndex(String str, int i) {
        AppMethodBeat.m2504i(83217);
        if (isInited()) {
            native_setNodeAlignedHeadPointIndex(str, i);
        }
        AppMethodBeat.m2505o(83217);
    }

    public float getFov() {
        return this.fov;
    }

    public void setFov(float f) {
        this.fov = f;
    }

    public void loadItemImage(String str, String str2) {
        AppMethodBeat.m2504i(83218);
        loadItemImage(str, str2, false);
        AppMethodBeat.m2505o(83218);
    }

    public void loadItemImage(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(83219);
        native_loadItemImage(str, str2, z);
        AppMethodBeat.m2505o(83219);
    }

    public void clearItemImage() {
        AppMethodBeat.m2504i(83220);
        native_clearItemImage();
        AppMethodBeat.m2505o(83220);
    }

    public boolean isHideScreen() {
        return this.hideScreen;
    }
}
