package com.tencent.ttpic.fabby;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.youtu.android.segmenter.SegmenterLib;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FabbyManager {
    private static final String RAPID_MODE = "RPNSegmenter_m5.rapidnetmodel";
    private static final String RAPID_MODE_SMALL = "RPNSegmenter_m6.rapidnetmodel";
    private static final String RAPID_PROTO = "deploy_m5_512_512_bin.rapidnetproto";
    private static final String RAPID_PROTO_SMALL = "deploy_m6.rapidnetproto";
    public static boolean USE_SMALL_IMAGE = false;
    public static boolean USE_SMALL_MODEL = false;
    private static FabbyManager instance = null;
    public static boolean sChooseGPU_Segment = false;
    private boolean INIT_SEGMENT_LIB = false;
    private boolean gpuSupportOpenCL;
    public SegmenterLib lib;
    private boolean mIsModelCopySuccess = true;
    private boolean mIsProtoCopySuccess = true;
    private int mModelCopyType = 0;
    private String mModelPath = "";
    private String mProtoPath = "";

    private FabbyManager() {
        AppMethodBeat.i(81862);
        copyCLFile();
        initSegmentLib();
        AppMethodBeat.o(81862);
    }

    public static void init() {
        AppMethodBeat.i(81863);
        getInstance();
        AppMethodBeat.o(81863);
    }

    public static FabbyManager getInstance() {
        AppMethodBeat.i(81864);
        if (instance == null) {
            synchronized (FabbyManager.class) {
                try {
                    if (instance == null) {
                        instance = new FabbyManager();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(81864);
                    }
                }
            }
        }
        if (!instance.getInitSegmentLib()) {
            instance.initSegmentLib();
        }
        FabbyManager fabbyManager = instance;
        AppMethodBeat.o(81864);
        return fabbyManager;
    }

    private void initSegmentLib() {
        AppMethodBeat.i(81865);
        if (FeatureManager.isSegmentationReady()) {
            File filesDir = VideoGlobalContext.getContext().getFilesDir();
            File file = new File(filesDir, USE_SMALL_MODEL ? RAPID_MODE_SMALL : RAPID_MODE);
            File file2 = new File(filesDir, USE_SMALL_MODEL ? RAPID_PROTO_SMALL : RAPID_PROTO);
            String modelResPath = ResourcePathMapper.getModelResPath(USE_SMALL_MODEL ? RAPID_MODE_SMALL : RAPID_MODE);
            if (modelResPath == null || modelResPath.startsWith("assets://")) {
                this.mIsModelCopySuccess = FileUtils.copyAssets(VideoGlobalContext.getContext(), USE_SMALL_MODEL ? RAPID_MODE_SMALL : RAPID_MODE, file.getAbsolutePath());
                this.mModelCopyType = 1;
            } else {
                this.mIsModelCopySuccess = FileUtils.copyFile(modelResPath + (USE_SMALL_MODEL ? RAPID_MODE_SMALL : RAPID_MODE), file.getAbsolutePath());
                this.mModelCopyType = 2;
            }
            this.mIsProtoCopySuccess = FileUtils.copyAssets(VideoGlobalContext.getContext(), USE_SMALL_MODEL ? RAPID_PROTO_SMALL : RAPID_PROTO, file2.getAbsolutePath());
            this.mModelPath = file.getAbsolutePath();
            this.mProtoPath = file2.getAbsolutePath();
            this.lib = new SegmenterLib(file2.getAbsolutePath(), file.getAbsolutePath());
            this.lib.setNativePtr(this.lib.getNativePtr());
            this.gpuSupportOpenCL = this.lib.isGPUSupportOpenCL();
            compileKernel();
            this.INIT_SEGMENT_LIB = true;
            AppMethodBeat.o(81865);
            return;
        }
        AppMethodBeat.o(81865);
    }

    private void copyCLFile() {
        AppMethodBeat.i(81866);
        Context context = VideoGlobalContext.getContext();
        String str = "fabbysdk.cl";
        try {
            InputStream open = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getDir("execdir", 0), str));
            byte[] bArr = new byte[CdnLogic.kBizGeneric];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    fileOutputStream.close();
                    AppMethodBeat.o(81866);
                    return;
                }
            }
        } catch (IOException e) {
            AppMethodBeat.o(81866);
        }
    }

    public boolean getInitSegmentLib() {
        return this.INIT_SEGMENT_LIB;
    }

    public int compileKernel() {
        AppMethodBeat.i(81867);
        int compileKernel = this.lib.compileKernel();
        AppMethodBeat.o(81867);
        return compileKernel;
    }

    public Bitmap segment(Bitmap bitmap) {
        AppMethodBeat.i(81868);
        Bitmap segment = this.lib.segment(bitmap);
        AppMethodBeat.o(81868);
        return segment;
    }

    public boolean isGPUSupportOpenCL() {
        AppMethodBeat.i(81869);
        boolean z = VideoPrefsUtil.getDefaultPrefs().getBoolean(VideoPrefsUtil.PREFS_KEY_SEGMENT_ON_CPU, false);
        if (!this.gpuSupportOpenCL || z) {
            AppMethodBeat.o(81869);
            return false;
        }
        AppMethodBeat.o(81869);
        return true;
    }

    public int segmentOnTexture(int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        AppMethodBeat.i(81870);
        int segmentOnTexture = this.lib.segmentOnTexture(i, i2, i3, i4, z, i5, i6);
        AppMethodBeat.o(81870);
        return segmentOnTexture;
    }

    public void segmentOnBitmap(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(81871);
        this.lib.segmentOnBitmap(bitmap, bitmap2, i, i2, i3, i4);
        AppMethodBeat.o(81871);
    }

    public int copyTextureToBuffer(int i, int i2, int i3) {
        AppMethodBeat.i(81872);
        int copyTextureToBuffer = this.lib.copyTextureToBuffer(i, i2, i3);
        AppMethodBeat.o(81872);
        return copyTextureToBuffer;
    }

    public int segmentOnTextureV2(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(81873);
        int segmentOnTextureV2 = this.lib.segmentOnTextureV2(i, i2, i3, i4);
        AppMethodBeat.o(81873);
        return segmentOnTextureV2;
    }

    public int copyBufferToTexture(int i, int i2, int i3) {
        AppMethodBeat.i(81874);
        int copyBufferToTexture = this.lib.copyBufferToTexture(i, i2, i3);
        AppMethodBeat.o(81874);
        return copyBufferToTexture;
    }

    public void clearSegmentBuffer() {
        AppMethodBeat.i(81875);
        if (this.lib != null) {
            this.lib.clearSegmentBuffer();
        }
        AppMethodBeat.o(81875);
    }

    public boolean IsInitSuccess() {
        AppMethodBeat.i(81876);
        if (this.lib != null) {
            boolean isInitSuccess = this.lib.isInitSuccess();
            AppMethodBeat.o(81876);
            return isInitSuccess;
        }
        AppMethodBeat.o(81876);
        return false;
    }

    public String getModelPath() {
        return this.mModelPath;
    }

    public String getProtoPath() {
        return this.mProtoPath;
    }

    public boolean getIsModelCopySuccess() {
        return this.mIsModelCopySuccess;
    }

    public boolean getIsProtoCopySuccess() {
        return this.mIsProtoCopySuccess;
    }

    public int getModelCopyType() {
        return this.mModelCopyType;
    }

    public int getErrorCode() {
        AppMethodBeat.i(81877);
        if (this.lib != null) {
            int errorCode = this.lib.getErrorCode();
            AppMethodBeat.o(81877);
            return errorCode;
        }
        AppMethodBeat.o(81877);
        return 0;
    }

    public int getErrorType() {
        AppMethodBeat.i(81878);
        if (this.lib != null) {
            int errorType = this.lib.getErrorType();
            AppMethodBeat.o(81878);
            return errorType;
        }
        AppMethodBeat.o(81878);
        return 0;
    }
}
