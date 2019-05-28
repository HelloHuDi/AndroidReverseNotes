package com.tencent.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.HardCoderJNI;
import com.tencent.util.C16371i;
import com.tencent.util.C36572f;
import com.tencent.view.C36573f;
import com.tencent.view.C41106g;
import com.tencent.view.C44569b;
import java.util.HashMap;
import java.util.Map;

public class BaseFilter {
    private String TAG = BaseFilter.class.getSimpleName();
    String defaultLensShader = "mee188x1701998624x1769171299x1746955887x1885890409x1869375008x171668577x1981811232x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x537541477x1853169674x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x537541477x1870012426x1830839401x678324577x2065697321x538976266x1818697760x1634879071x1819231079x1025536623x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x694514785x2099251771x";
    private long glFilterId = 0;
    protected int glsl_programID = -1;
    String glsl_programShader = null;
    String glsl_vertextShader = "mee390x1667592816x1869181801x1768431726x544237671x1634692198x1628257140x1769108596x1702131042x1667593760x1869619252x1769236851x221998703x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980578661x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x1963801445x1868982638x1830841714x540308577x1785688656x1769235301x221998703x1718185589x544043631x880042349x1685015840x1769368677x540768101x1768846605x1836216166x1952541984x1702109236x1920300152x1952533861x1963794491x1868982638x1830841714x540308577x1952533876x1870007611x1830839401x678324577x1684631414x226168105x1348430951x1953067887x544108393x1917853757x1667590767x1852795252x1293953568x1818584175x2003134838x1869621792x1769236851x221998703x878929270x1886221344x1948269856x712270157x878929270x1886284072x1700033653x1920300152x1869562725x1852400754x778400865x1852386424x1416918384x1970567269x1866687858x1768190575x1702125934x808220974x824979502x992555054x2019914765x1701999988x1919905603x1634625892x1025533300x1886221344x997816366x32013x";
    int glsl_vertextshaderID = GLSLRender.bMm;
    boolean mIsGPU = true;
    protected boolean mIsPreviewFilter;
    BaseFilter mNextFilter;
    Map<String, C25624m> mParamList = new HashMap();
    private int mProgramIds;
    int[] mTextureIndexMap;
    public boolean needFlipBlend = false;
    public boolean needReleaseFrmae = false;
    public float outPutScaleFact = 1.0f;
    public float scaleFact = 1.0f;
    protected int srcTextureIndex = -1;

    public static native String nativeDecrypt(String str);

    private native String nativeGetFilterShader(int i, int i2);

    private static native int nativeGetVersion();

    private native long nativeInitialWithString(long j, int i, String str, String str2);

    private native boolean nativeSetPositions(long j, float[] fArr);

    private native boolean nativeSetRenderMode(long j, int i);

    private native boolean nativeSetTexCords(long j, float[] fArr);

    public native int nativeApplyFilter(long j, long j2);

    public native boolean nativeClear(long j);

    public native boolean nativeRenderTexture(long j, int i, int i2, int i3);

    public native boolean nativeSetGlobalTextureMatrix(long j, float[] fArr);

    public native boolean nativeSetRotationAndFlip(long j, int i, int i2, int i3);

    public native boolean nativeUpdateMatrix(long j, float[] fArr);

    public native boolean nativeUpdateModelMatrix(long j, float[] fArr);

    public boolean IsFilterInvalute() {
        return this.mProgramIds > 0;
    }

    public BaseFilter(int i) {
        AppMethodBeat.m2504i(86313);
        this.glsl_programID = i;
        AppMethodBeat.m2505o(86313);
    }

    public BaseFilter(int i, String str) {
        AppMethodBeat.m2504i(86314);
        this.glsl_programID = i;
        addParam(new C0936o("inputImageTexture2", str, 33986));
        AppMethodBeat.m2505o(86314);
    }

    public BaseFilter(int i, int i2) {
        AppMethodBeat.m2504i(86315);
        this.glsl_vertextshaderID = i;
        this.glsl_programID = i2;
        AppMethodBeat.m2505o(86315);
    }

    public BaseFilter(String str, String str2) {
        AppMethodBeat.m2504i(86316);
        this.glsl_vertextShader = str;
        this.glsl_programShader = str2;
        AppMethodBeat.m2505o(86316);
    }

    public BaseFilter(String str) {
        AppMethodBeat.m2504i(86317);
        this.glsl_programShader = str;
        AppMethodBeat.m2505o(86317);
    }

    public boolean isGPUProcess() {
        return this.mIsGPU;
    }

    public boolean isSupportForGloableRender() {
        return true;
    }

    public void updateFilterShader(String str, String str2) {
        this.glsl_vertextShader = str;
        this.glsl_programShader = str2;
    }

    public void updateFragmentShader(String str) {
        this.glsl_programShader = str;
    }

    public BaseFilter getLastFilter() {
        while (this.mNextFilter != null) {
            this = this.mNextFilter;
        }
        return this;
    }

    public boolean isNormal() {
        if (this.glsl_programID == GLSLRender.bJB && this.mNextFilter == null) {
            return true;
        }
        return false;
    }

    public void setTextureParam(int i, int i2) {
        AppMethodBeat.m2504i(86318);
        int i3 = i2 + 2;
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramIds, "inputImageTexture".concat(String.valueOf(i3)));
        if (glGetUniformLocation >= 0) {
            GLES20.glActiveTexture(33984 + i3);
            GLES20.glBindTexture(3553, i);
            GLES20.glTexParameterf(3553, 10240, 9728.0f);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(glGetUniformLocation, i3);
        }
        AppMethodBeat.m2505o(86318);
    }

    public void setParameterDic(Map<String, Object> map) {
    }

    public boolean isAdjustFilter() {
        return false;
    }

    public void setAdjustParam(float f) {
    }

    public void setEffectIndex(int i) {
    }

    public float getScaleFact() {
        return this.scaleFact;
    }

    public void setScaleFact(float f) {
        this.scaleFact = f;
    }

    public BaseFilter addParam(C25624m c25624m) {
        AppMethodBeat.m2504i(86319);
        if (c25624m == null) {
            AppMethodBeat.m2505o(86319);
        } else {
            C25624m c25624m2 = (C25624m) this.mParamList.get(c25624m.name);
            if (c25624m2 == null) {
                this.mParamList.put(c25624m.name, c25624m);
            } else {
                c25624m.handle = c25624m2.handle;
                this.mParamList.put(c25624m.name, c25624m);
            }
            AppMethodBeat.m2505o(86319);
        }
        return this;
    }

    public C25624m getParam(String str) {
        AppMethodBeat.m2504i(86320);
        C25624m c25624m = (C25624m) this.mParamList.get(str);
        AppMethodBeat.m2505o(86320);
        return c25624m;
    }

    public void setNextFilter(BaseFilter baseFilter, int[] iArr) {
        this.mNextFilter = baseFilter;
        if (baseFilter != null) {
            baseFilter.mTextureIndexMap = iArr;
        }
    }

    public void setSrcFilterIndex(int i) {
        this.srcTextureIndex = i;
    }

    public int getSrcFilterInddex() {
        return this.srcTextureIndex;
    }

    public void removeTheFilter(BaseFilter baseFilter) {
        if (baseFilter != null) {
            while (this != null && this.mNextFilter != baseFilter) {
                this = this.mNextFilter;
            }
            if (this != null && this.mNextFilter == baseFilter) {
                this.mNextFilter = null;
            }
        }
    }

    public int getTheFilterIndex(BaseFilter baseFilter) {
        int i = 0;
        while (this != null && this != baseFilter) {
            i++;
            this = this.mNextFilter;
        }
        return this == baseFilter ? i : -1;
    }

    public int getLastFilterID() {
        AppMethodBeat.m2504i(86321);
        int theFilterIndex = getTheFilterIndex(getLastFilter());
        AppMethodBeat.m2505o(86321);
        return theFilterIndex;
    }

    public void clearGLSLSelf() {
        AppMethodBeat.m2504i(86322);
        for (C25624m clear : this.mParamList.values()) {
            clear.clear();
        }
        nativeClear(this.glFilterId);
        this.glFilterId = 0;
        this.mProgramIds = 0;
        AppMethodBeat.m2505o(86322);
    }

    public QImage ApplyFilter(QImage qImage) {
        return null;
    }

    public void ClearGLSL() {
        AppMethodBeat.m2504i(86323);
        clearGLSLSelf();
        if (this.mNextFilter != null) {
            this.mNextFilter.ClearGLSL();
        }
        AppMethodBeat.m2505o(86323);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86324);
        this.mIsPreviewFilter = z;
        if (!IsFilterInvalute()) {
            ApplyGLSLFilter();
        }
        if (this.mNextFilter != null) {
            this.mNextFilter.ApplyGLSLFilter(z, f, f2);
        }
        AppMethodBeat.m2505o(86324);
    }

    /* Access modifiers changed, original: protected */
    public void initFilterShader(int i) {
        AppMethodBeat.m2504i(86325);
        if (this.glsl_programShader == null || this.glsl_vertextShader == null) {
            try {
                String nativeGetFilterShader = nativeGetFilterShader(0, this.glsl_programID);
                String str = this.glsl_vertextShader;
                if (this.glsl_vertextshaderID != 0) {
                    str = nativeGetFilterShader(1, this.glsl_vertextshaderID);
                }
                this.glFilterId = nativeInitialWithString(this.glFilterId, i, str, nativeGetFilterShader);
                AppMethodBeat.m2505o(86325);
                return;
            } catch (UnsatisfiedLinkError e) {
                this.glFilterId = nativeInitialWithString(this.glFilterId, i, this.glsl_vertextShader, this.defaultLensShader);
                AppMethodBeat.m2505o(86325);
                return;
            }
        }
        this.glFilterId = nativeInitialWithString(this.glFilterId, i, this.glsl_vertextShader, this.glsl_programShader);
        AppMethodBeat.m2505o(86325);
    }

    public boolean isClass(String str) {
        AppMethodBeat.m2504i(86326);
        try {
            Class.forName(str);
            AppMethodBeat.m2505o(86326);
            return true;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.m2505o(86326);
            return false;
        }
    }

    public boolean checkApplyGLSLFilterResult() {
        if (this.glFilterId == 0) {
            return false;
        }
        return true;
    }

    public void ApplyGLSLFilter(int i) {
        AppMethodBeat.m2504i(86327);
        initFilterShader(i);
        if (C44569b.AII) {
            setRenderMode(1);
        }
        this.mProgramIds = nativeApplyFilter(this.glFilterId, 0);
        for (C25624m initialParams : this.mParamList.values()) {
            initialParams.initialParams(this.mProgramIds);
        }
        AppMethodBeat.m2505o(86327);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(86328);
        ApplyGLSLFilter(0);
        AppMethodBeat.m2505o(86328);
    }

    /* Access modifiers changed, original: protected */
    public void setGlobalTextureMatrix(float[] fArr) {
        AppMethodBeat.m2504i(86329);
        nativeSetGlobalTextureMatrix(this.glFilterId, fArr);
        if (this.mNextFilter != null) {
            this.mNextFilter.setGlobalTextureMatrix(fArr);
        }
        AppMethodBeat.m2505o(86329);
    }

    public void OnDrawFrameGLSL() {
        AppMethodBeat.m2504i(86330);
        GLES20.glUseProgram(this.mProgramIds);
        C41106g.checkGlError("glUseProgram:" + this.mProgramIds);
        for (C25624m params : this.mParamList.values()) {
            params.setParams(this.mProgramIds);
        }
        AppMethodBeat.m2505o(86330);
    }

    public void RenderProcess(int i, int i2, int i3, int i4, int i5, int i6, double d, C41672h c41672h) {
        AppMethodBeat.m2504i(86331);
        if (c41672h == null) {
            AppMethodBeat.m2505o(86331);
            return;
        }
        C41672h c41672h2 = c41672h;
        C41672h c41672h3 = c41672h;
        BaseFilter baseFilter = this;
        while (baseFilter != null) {
            int i7;
            C41672h findFrame;
            if (baseFilter == this) {
                baseFilter.beforeRender(i, i2, i3);
            } else {
                baseFilter.beforeRender(c41672h2.texture[0], c41672h2.width, c41672h2.height);
            }
            c41672h3.needReleaseFrmae = baseFilter.needReleaseFrmae;
            if (baseFilter.mNextFilter == null) {
                c41672h3.mo67189a(i6, (int) ((((float) i4) * baseFilter.scaleFact) * this.outPutScaleFact), (int) ((((float) i5) * baseFilter.scaleFact) * this.outPutScaleFact), d);
            } else {
                c41672h3.mo67189a(-1, (int) (((float) i4) * baseFilter.scaleFact), (int) (((float) i5) * baseFilter.scaleFact), d);
            }
            C41106g.checkGlError("before OnDrawFrameGLSL");
            baseFilter.OnDrawFrameGLSL();
            if (baseFilter.mTextureIndexMap != null && baseFilter.mTextureIndexMap.length > 0) {
                for (i7 = 0; i7 < baseFilter.mTextureIndexMap.length; i7++) {
                    if (baseFilter.mTextureIndexMap[i7] < 0) {
                        baseFilter.setTextureParam(i, i7);
                    } else {
                        findFrame = findFrame(c41672h, baseFilter.mTextureIndexMap[i7]);
                        if (findFrame != null) {
                            baseFilter.setTextureParam(findFrame.texture[0], i7);
                        } else {
                            C16371i.m25188m(this.TAG, "frame not found!");
                        }
                    }
                }
            }
            C41106g.checkGlError("before nativeRenderTexture");
            if (baseFilter == this) {
                baseFilter.renderTexture(i, i2, i3);
                i7 = i;
                findFrame = c41672h2;
            } else {
                i7 = c41672h2.texture[0];
                baseFilter.renderTexture(c41672h2.texture[0], c41672h2.width, c41672h2.height);
                if (c41672h2.needReleaseFrmae) {
                    c41672h2.mo67193wF();
                }
                findFrame = c41672h3;
            }
            if (i6 != 0) {
                checkInputOutputValid(baseFilter, c41672h3, i7);
            }
            C41106g.checkGlError("after nativeRenderTexture");
            BaseFilter baseFilter2 = baseFilter.mNextFilter;
            if (baseFilter2 != null) {
                if (c41672h3.bJA == null) {
                    c41672h3.bJA = new C41672h();
                }
                c41672h3 = c41672h3.bJA;
            }
            c41672h2 = findFrame;
            baseFilter = baseFilter2;
        }
        AppMethodBeat.m2505o(86331);
    }

    /* Access modifiers changed, original: 0000 */
    public C41672h findFrame(C41672h c41672h, int i) {
        C41672h c41672h2 = c41672h;
        while (c41672h2 != null) {
            if (i == 0) {
                return c41672h2;
            }
            c41672h2 = c41672h2.bJA;
            i--;
        }
        return null;
    }

    public void RenderProcess(int i, int i2, int i3, int i4, double d, C41672h c41672h) {
        AppMethodBeat.m2504i(86333);
        RenderProcess(i, i2, i3, i2, i3, i4, d, c41672h);
        AppMethodBeat.m2505o(86333);
    }

    public void RenderProcessBitmap(Bitmap bitmap, C41672h c41672h) {
        AppMethodBeat.m2504i(86334);
        C36573f as = C36573f.m60612as(bitmap);
        if (C44569b.AIH < 0) {
            RenderProcess(as.texture, as.width, as.height, as.texture, 0.0d, c41672h);
            C41106g.m71539a(as.texture, as.width, as.height, bitmap);
        } else {
            RenderProcess(as.texture, as.width, as.height, -2, 0.0d, c41672h);
            GLSLRender.nativePushBitmapFromTexture(bitmap, C44569b.AIH);
        }
        if (as.texture != HardCoderJNI.ERR_CLIENT_CONNECT) {
            C41106g.m71538Sk(as.texture);
            as.texture = HardCoderJNI.ERR_CLIENT_CONNECT;
        }
        AppMethodBeat.m2505o(86334);
    }

    public void RendProcessImage(QImage qImage, C41672h c41672h) {
        AppMethodBeat.m2504i(86335);
        long currentTimeMillis = System.currentTimeMillis();
        int[] iArr = new int[2];
        iArr = new int[]{1, 1};
        GLSLRender.nativePreprocessJepg(qImage, iArr);
        int[] iArr2 = new int[1];
        C36572f.dSJ().mo58343c(iArr2, true);
        float[] fArr = new float[9];
        fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        int[] iArr3 = new int[]{0, 0};
        for (int i = 0; i < iArr[0]; i++) {
            for (int i2 = 0; i2 < iArr[1]; i2++) {
                GLSLRender.nativePickJepgToTexture(qImage, i, i2, iArr[0], iArr[1], iArr2[0], iArr3);
                fArr[0] = ((float) iArr3[0]) / ((float) qImage.getWidth());
                fArr[4] = ((float) iArr3[1]) / ((float) qImage.getHeight());
                fArr[2] = ((float) i) / ((float) iArr[0]);
                fArr[5] = ((float) i2) / ((float) iArr[1]);
                setGlobalTextureMatrix(fArr);
                if (C44569b.AIH >= 0) {
                    RenderProcess(iArr2[0], iArr3[0], iArr3[1], -2, 0.0d, c41672h);
                    GLSLRender.nativePushJepgFromTexture(qImage, i, i2, iArr[0], iArr[1], C44569b.AIH);
                } else {
                    RenderProcess(iArr2[0], iArr3[0], iArr3[1], -1, 0.0d, c41672h);
                    GLSLRender.nativePushJepgFromTexture(qImage, i, i2, iArr[0], iArr[1], C44569b.AIH);
                }
            }
        }
        setGlobalTextureMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        GLES20.glDeleteTextures(1, iArr2, 0);
        C16371i.m25186k("BaseFilter", "RendProcessImage:" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(86335);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86336);
        C16371i.m25187l("BaseFilterParam", "Class:" + getClass().getSimpleName());
        C16371i.m25187l("BaseFilterParam", "mProgramIds:" + this.mProgramIds);
        C16371i.m25187l("BaseFilterParam", "mParamList:" + this.mParamList);
        boolean nativeRenderTexture = nativeRenderTexture(this.glFilterId, i, i2, i3);
        AppMethodBeat.m2505o(86336);
        return nativeRenderTexture;
    }

    public void beforeRender(int i, int i2, int i3) {
    }

    public void copy(BaseFilter baseFilter) {
        if (baseFilter != null) {
            this.mProgramIds = baseFilter.mProgramIds;
            this.glFilterId = baseFilter.glFilterId;
            this.mParamList = baseFilter.mParamList;
        }
    }

    public void setParams() {
        AppMethodBeat.m2504i(86337);
        for (C25624m params : this.mParamList.values()) {
            params.setParams(this.mProgramIds);
        }
        AppMethodBeat.m2505o(86337);
    }

    public boolean setPositions(float[] fArr) {
        AppMethodBeat.m2504i(86338);
        boolean nativeSetPositions = nativeSetPositions(this.glFilterId, fArr);
        AppMethodBeat.m2505o(86338);
        return nativeSetPositions;
    }

    public boolean setTexCords(float[] fArr) {
        AppMethodBeat.m2504i(86339);
        boolean nativeSetTexCords = nativeSetTexCords(this.glFilterId, fArr);
        AppMethodBeat.m2505o(86339);
        return nativeSetTexCords;
    }

    public boolean setRenderMode(int i) {
        AppMethodBeat.m2504i(86340);
        boolean nativeSetRenderMode = nativeSetRenderMode(this.glFilterId, i);
        AppMethodBeat.m2505o(86340);
        return nativeSetRenderMode;
    }

    public static int getVersionCode() {
        AppMethodBeat.m2504i(86341);
        int nativeGetVersion = nativeGetVersion();
        AppMethodBeat.m2505o(86341);
        return nativeGetVersion;
    }

    public int getmProgramIds() {
        return this.mProgramIds;
    }

    public BaseFilter getmNextFilter() {
        return this.mNextFilter;
    }

    public boolean nativeSetGlobalTextureMatrix(float[] fArr) {
        AppMethodBeat.m2504i(86342);
        boolean nativeSetGlobalTextureMatrix = nativeSetGlobalTextureMatrix(this.glFilterId, fArr);
        AppMethodBeat.m2505o(86342);
        return nativeSetGlobalTextureMatrix;
    }

    public boolean nativeUpdateMatrix(float[] fArr) {
        AppMethodBeat.m2504i(86343);
        boolean nativeUpdateMatrix = nativeUpdateMatrix(this.glFilterId, fArr);
        AppMethodBeat.m2505o(86343);
        return nativeUpdateMatrix;
    }

    public boolean nativeUpdateModelMatrix(float[] fArr) {
        AppMethodBeat.m2504i(86344);
        boolean nativeUpdateModelMatrix = nativeUpdateModelMatrix(this.glFilterId, fArr);
        AppMethodBeat.m2505o(86344);
        return nativeUpdateModelMatrix;
    }

    public boolean nativeSetRotationAndFlip(int i, int i2, int i3) {
        AppMethodBeat.m2504i(86345);
        boolean nativeSetRotationAndFlip = nativeSetRotationAndFlip(this.glFilterId, i, i2, i3);
        AppMethodBeat.m2505o(86345);
        return nativeSetRotationAndFlip;
    }

    private void checkInputOutputValid(BaseFilter baseFilter, C41672h c41672h, int i) {
        RuntimeException runtimeException;
        AppMethodBeat.m2504i(86332);
        if (i == c41672h.texture[0]) {
            C16371i.m25188m("BaseFilter", "input and output texture is same!");
            if (C41106g.isEnableLog()) {
                runtimeException = new RuntimeException("input and output texture is same!");
                AppMethodBeat.m2505o(86332);
                throw runtimeException;
            }
        }
        for (C25624m c25624m : baseFilter.mParamList.values()) {
            if ((c25624m instanceof C25627n) && ((C25627n) c25624m).texture[0] == c41672h.texture[0]) {
                C16371i.m25188m("BaseFilter", "input and output texture is same!");
                if (C41106g.isEnableLog()) {
                    runtimeException = new RuntimeException("input and output texture is same!");
                    AppMethodBeat.m2505o(86332);
                    throw runtimeException;
                }
            }
        }
        AppMethodBeat.m2505o(86332);
    }
}
