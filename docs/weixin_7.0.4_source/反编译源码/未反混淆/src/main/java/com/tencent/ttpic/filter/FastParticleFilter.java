package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.h;
import com.tencent.filter.m;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.ParticleParam;
import com.tencent.ttpic.shader.Shader;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastParticleFilter {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FastParticleFragmentShader.dat");
    private static final int MAX_DRAW_PER_RENDER = 7;
    private static final int MAX_PARTICLE_NUM = 166;
    private static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FastParticleVertexShader.dat");
    private int blendFuncDst;
    private int blendFuncSrc;
    protected int height;
    private Map<String, AttributeParam> mAttrParams;
    private int mCoordNum;
    private Map<String, m> mParamList;
    protected int mSTextureHandle;
    protected double mScreenScale;
    private Shader shader;
    protected int width;

    static {
        AppMethodBeat.i(82487);
        AppMethodBeat.o(82487);
    }

    public FastParticleFilter() {
        this(new Shader(VERTEX_SHADER, FRAGMENT_SHADER));
        AppMethodBeat.i(82466);
        AppMethodBeat.o(82466);
    }

    private FastParticleFilter(Shader shader) {
        AppMethodBeat.i(82467);
        this.blendFuncSrc = 0;
        this.blendFuncDst = 0;
        this.mSTextureHandle = -1;
        this.shader = shader;
        this.mAttrParams = new HashMap();
        this.mParamList = new HashMap();
        AppMethodBeat.o(82467);
    }

    public void applyGLSLFilter() {
        AppMethodBeat.i(82468);
        initAttribParams();
        this.shader.compile();
        for (m initialParams : this.mParamList.values()) {
            initialParams.initialParams(this.shader.getShaderProgram());
        }
        for (AttributeParam initialParams2 : this.mAttrParams.values()) {
            initialParams2.initialParams(this.shader.getShaderProgram());
        }
        this.mSTextureHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "inputImageTexture");
        AppMethodBeat.o(82468);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82469);
        setCoordNum(6);
        addAttribParam(new AttributeParam("position", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 3));
        addAttribParam(new AttributeParam("inputTextureCoordinate", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 2));
        addAttribParam(new AttributeParam("a_stickerIndex", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 1));
        addAttribParam(new AttributeParam("aColor", new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 4));
        initParams();
        AppMethodBeat.o(82469);
    }

    public void addAttribParam(String str, float[] fArr) {
        AppMethodBeat.i(82470);
        addAttribParam(str, fArr, false);
        AppMethodBeat.o(82470);
    }

    public void addAttribParam(String str, float[] fArr, boolean z) {
        AppMethodBeat.i(82471);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(82471);
            return;
        }
        AttributeParam attributeParam = (AttributeParam) this.mAttrParams.get(str);
        if (attributeParam == null) {
            attributeParam = new AttributeParam(str, fArr, z);
            this.mAttrParams.put(str, attributeParam);
        }
        attributeParam.setVertices(fArr);
        AppMethodBeat.o(82471);
    }

    public void addAttribParam(AttributeParam attributeParam) {
        AppMethodBeat.i(82472);
        if (attributeParam == null) {
            AppMethodBeat.o(82472);
            return;
        }
        AttributeParam attributeParam2 = (AttributeParam) this.mAttrParams.get(attributeParam.name);
        if (attributeParam2 == null) {
            attributeParam2 = new AttributeParam(attributeParam.name, attributeParam.vertices, attributeParam.perVertexFloat, false);
            this.mAttrParams.put(attributeParam.name, attributeParam2);
        }
        attributeParam2.setVertices(attributeParam.vertices);
        attributeParam2.perVertexFloat = attributeParam.perVertexFloat;
        AppMethodBeat.o(82472);
    }

    public AttributeParam getAttribParam(String str) {
        AppMethodBeat.i(82473);
        AttributeParam attributeParam = (AttributeParam) this.mAttrParams.get(str);
        AppMethodBeat.o(82473);
        return attributeParam;
    }

    public void addParam(m mVar) {
        AppMethodBeat.i(82474);
        if (mVar == null) {
            AppMethodBeat.o(82474);
            return;
        }
        m mVar2 = (m) this.mParamList.get(mVar.name);
        if (mVar2 == null) {
            this.mParamList.put(mVar.name, mVar);
            AppMethodBeat.o(82474);
            return;
        }
        mVar.handle = mVar2.handle;
        this.mParamList.put(mVar.name, mVar);
        AppMethodBeat.o(82474);
    }

    public void initParams() {
        AppMethodBeat.i(82475);
        for (int i = 0; i <= 7; i++) {
            addParam(new n("inputImageTexture".concat(String.valueOf(i)), 0, 33986));
        }
        AppMethodBeat.o(82475);
    }

    private boolean mergeRenderParams(List<ParticleParam> list) {
        int i = 0;
        AppMethodBeat.i(82476);
        if (list.isEmpty()) {
            AppMethodBeat.o(82476);
            return false;
        }
        int i2;
        int i3 = 0;
        for (i2 = 0; i2 < list.size(); i2++) {
            i3 += ((ParticleParam) list.get(i2)).coordNum;
        }
        setCoordNum(i3);
        setBlendFuncSrc(((ParticleParam) list.get(0)).blendFuncSrc);
        setBlendFuncDst(((ParticleParam) list.get(0)).blendFuncDst);
        float[] fArr = new float[(i3 * 3)];
        int i4 = 0;
        for (i2 = 0; i2 < list.size(); i2++) {
            for (float f : ((ParticleParam) list.get(i2)).position) {
                fArr[i4] = f;
                i4++;
            }
        }
        addAttribParam(new AttributeParam("position", fArr, 3));
        fArr = new float[(i3 * 2)];
        int i5 = 0;
        int i6 = 0;
        while (i5 < list.size()) {
            i4 = i6;
            for (float f2 : ((ParticleParam) list.get(i5)).inputTextureCoordinate) {
                fArr[i4] = f2;
                i4++;
            }
            i5++;
            i6 = i4;
        }
        setTexCords(fArr);
        fArr = new float[(i3 * 4)];
        i5 = 0;
        i6 = 0;
        while (i5 < list.size()) {
            i4 = i6;
            for (float f22 : ((ParticleParam) list.get(i5)).aColor) {
                fArr[i4] = f22;
                i4++;
            }
            i5++;
            i6 = i4;
        }
        addAttribParam(new AttributeParam("aColor", fArr, 4));
        float[] fArr2 = new float[i3];
        i3 = 0;
        for (i2 = 0; i2 < list.size(); i2++) {
            for (i4 = 0; i4 < ((ParticleParam) list.get(i2)).coordNum; i4++) {
                fArr2[i3] = ((float) i2) + 0.5f;
                i3++;
            }
        }
        addAttribParam(new AttributeParam("a_stickerIndex", fArr2, 1));
        while (i < list.size()) {
            addParam(new n("inputImageTexture".concat(String.valueOf(i)), ((ParticleParam) list.get(i)).texture, (33984 + i) + 1));
            i++;
        }
        AppMethodBeat.o(82476);
        return true;
    }

    public void renderTexture(h hVar) {
        AppMethodBeat.i(82477);
        boolean z = GlUtil.curBlendModeEnabled;
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(getBlendFuncSrc(), getBlendFuncDst());
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, hVar.texture[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glUniform1i(this.mSTextureHandle, 0);
        GLES20.glDrawArrays(4, 0, this.mCoordNum);
        GLES20.glFlush();
        GlUtil.setBlendMode(z);
        AppMethodBeat.o(82477);
    }

    public void render(List<ParticleParam> list, h hVar) {
        AppMethodBeat.i(82478);
        if (list.size() > 0) {
            Collections.sort(list, new Comparator<ParticleParam>() {
                public int compare(ParticleParam particleParam, ParticleParam particleParam2) {
                    return particleParam.blendFuncSrc - particleParam2.blendFuncSrc;
                }
            });
            Collections.sort(list, new Comparator<ParticleParam>() {
                public int compare(ParticleParam particleParam, ParticleParam particleParam2) {
                    return particleParam.blendFuncDst - particleParam2.blendFuncDst;
                }
            });
            for (List mergeRenderParams : splitRenderParams(list)) {
                if (mergeRenderParams(mergeRenderParams)) {
                    GLES20.glBindFramebuffer(36160, hVar.bJz[0]);
                    GLES20.glViewport(0, 0, hVar.width, hVar.height);
                    OnDrawFrameGLSL();
                    renderTexture(hVar);
                }
            }
        }
        AppMethodBeat.o(82478);
    }

    private List<List<ParticleParam>> splitRenderParams(List<ParticleParam> list) {
        int i = 0;
        AppMethodBeat.i(82479);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(82479);
            return null;
        }
        ParticleParam particleParam = (ParticleParam) list.get(0);
        int i2 = particleParam.blendFuncSrc;
        int i3 = particleParam.blendFuncDst;
        int i4 = particleParam.maxParticleNum;
        ArrayList arrayList = new ArrayList();
        int i5 = 1;
        while (true) {
            int i6 = i5;
            if (i6 < list.size()) {
                particleParam = (ParticleParam) list.get(i6);
                i4 += particleParam.maxParticleNum;
                if ((i6 - i) + 1 > 7 || i4 > 166 || particleParam.blendFuncSrc != i2 || particleParam.blendFuncDst != i3) {
                    arrayList.add(list.subList(i, i6));
                    i4 = particleParam.maxParticleNum;
                    i2 = particleParam.blendFuncSrc;
                    i3 = particleParam.blendFuncDst;
                    i = i6;
                }
                i5 = i6 + 1;
            } else {
                arrayList.add(list.subList(i, list.size()));
                AppMethodBeat.o(82479);
                return arrayList;
            }
        }
    }

    public void OnDrawFrameGLSL() {
        AppMethodBeat.i(82480);
        this.shader.bind();
        for (m params : this.mParamList.values()) {
            params.setParams(this.shader.getShaderProgram());
        }
        for (AttributeParam attributeParam : this.mAttrParams.values()) {
            if (attributeParam.handle >= 0) {
                attributeParam.setParams(this.shader.getShaderProgram());
            }
        }
        AppMethodBeat.o(82480);
    }

    public boolean setPositions(float[] fArr) {
        AppMethodBeat.i(82481);
        addAttribParam("position", fArr);
        AppMethodBeat.o(82481);
        return true;
    }

    public boolean setTexCords(float[] fArr) {
        AppMethodBeat.i(82482);
        addAttribParam("inputTextureCoordinate", fArr);
        AppMethodBeat.o(82482);
        return true;
    }

    public boolean setColors(float[] fArr) {
        AppMethodBeat.i(82483);
        addAttribParam("aColor", fArr);
        AppMethodBeat.o(82483);
        return true;
    }

    public boolean setPositions(float[] fArr, boolean z) {
        AppMethodBeat.i(82484);
        addAttribParam("position", fArr, z);
        AppMethodBeat.o(82484);
        return true;
    }

    public boolean setTexCords(float[] fArr, boolean z) {
        AppMethodBeat.i(82485);
        addAttribParam("inputTextureCoordinate", fArr, z);
        AppMethodBeat.o(82485);
        return true;
    }

    public boolean setCoordNum(int i) {
        this.mCoordNum = i;
        return true;
    }

    public int getBlendFuncSrc() {
        return this.blendFuncSrc;
    }

    public void setBlendFuncSrc(int i) {
        this.blendFuncSrc = i;
    }

    public int getBlendFuncDst() {
        return this.blendFuncDst;
    }

    public void setBlendFuncDst(int i) {
        this.blendFuncDst = i;
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82486);
        this.shader.clear();
        for (m clear : this.mParamList.values()) {
            clear.clear();
        }
        for (AttributeParam clear2 : this.mAttrParams.values()) {
            clear2.clear();
        }
        AppMethodBeat.o(82486);
    }
}
