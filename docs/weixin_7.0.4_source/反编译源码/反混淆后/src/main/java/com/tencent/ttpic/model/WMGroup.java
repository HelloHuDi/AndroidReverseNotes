package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C25629b;
import com.tencent.filter.C25624m.C25630d;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.WMAnimationFilterBase;
import com.tencent.ttpic.filter.WMDitheringAnimationFilter;
import com.tencent.ttpic.filter.WMScaleAnimationFilter;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FrameUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WMGroup {
    private int height;
    /* renamed from: id */
    public int f4886id;
    private boolean locked = false;
    private Map<String, WMAnimationFilterBase> mAnimationFilerMap = new HashMap();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mCopyFrame = new C41672h();
    private Map<String, WMElement> mIdElementMap = new HashMap();
    private int[] mTexId = new int[1];
    private int width;
    public List<WMElement> wmElements = new ArrayList();

    public WMGroup() {
        AppMethodBeat.m2504i(83589);
        AppMethodBeat.m2505o(83589);
    }

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public void init() {
        AppMethodBeat.m2504i(83590);
        LogicDataManager.getInstance().getEditableWMElement().clear();
        this.mCopyFilter.addParam(new C25629b("ditheringOffset", 0.0f, 0.0f));
        this.mCopyFilter.addParam(new C0935i("texNeedTransform", 1));
        this.mCopyFilter.addParam(new C25629b("canvasSize", 0.0f, 0.0f));
        this.mCopyFilter.addParam(new C25629b("texAnchor", 0.0f, 0.0f));
        this.mCopyFilter.addParam(new C0933f("texScale", 1.0f));
        this.mCopyFilter.addParam(new C25630d("texRotate", 0.0f, 0.0f, 0.0f));
        this.mCopyFilter.addParam(new C0933f("positionRotate", 0.0f));
        this.mCopyFilter.ApplyGLSLFilter();
        FrameUtil.clearFrame(this.mCopyFrame, 0.0f, 0.0f, 0.0f, 0.0f, this.width, this.height);
        GLES20.glGenTextures(this.mTexId.length, this.mTexId, 0);
        for (WMElement wMElement : this.wmElements) {
            wMElement.init();
            if (!(TextUtils.isEmpty(wMElement.animateType) || this.mAnimationFilerMap.containsKey(wMElement.animateType))) {
                WMAnimationFilterBase createAnimationFilter = createAnimationFilter(wMElement, this.width, this.height);
                if (createAnimationFilter != null) {
                    createAnimationFilter.ApplyGLSLFilter();
                    this.mAnimationFilerMap.put(wMElement.animateType, createAnimationFilter);
                }
            }
            this.mIdElementMap.put(wMElement.f16566id, wMElement);
        }
        AppMethodBeat.m2505o(83590);
    }

    public void clear() {
        AppMethodBeat.m2504i(83591);
        this.mCopyFilter.clearGLSLSelf();
        this.mCopyFrame.clear();
        GLES20.glDeleteTextures(this.mTexId.length, this.mTexId, 0);
        for (WMElement clear : this.wmElements) {
            clear.clear();
        }
        for (Entry value : this.mAnimationFilerMap.entrySet()) {
            ((WMAnimationFilterBase) value.getValue()).ClearGLSL();
        }
        AppMethodBeat.m2505o(83591);
    }

    public int getTexture() {
        return this.mCopyFrame.texture[0];
    }

    public boolean updateTexture(long j) {
        AppMethodBeat.m2504i(83592);
        boolean updateTexture = updateTexture(j, false, false, false);
        AppMethodBeat.m2505o(83592);
        return updateTexture;
    }

    public boolean isAsyncDrawFinished() {
        AppMethodBeat.m2504i(83593);
        for (WMElement wMElement : this.wmElements) {
            if ((wMElement instanceof TextWMElement) && ((TextWMElement) wMElement).isAsyncDrawFinished()) {
                AppMethodBeat.m2505o(83593);
                return true;
            }
        }
        AppMethodBeat.m2505o(83593);
        return false;
    }

    public boolean updateTexture(long j, boolean z, boolean z2, boolean z3) {
        WMElement wMElement;
        boolean z4;
        Object obj;
        AppMethodBeat.m2504i(83594);
        if (z) {
            int i;
            if (this.locked) {
                i = 0;
            } else {
                i = 0;
                for (WMElement wMElement2 : this.wmElements) {
                    if ((wMElement2 instanceof TextWMElement) && z2) {
                        ((TextWMElement) wMElement2).updateTextShaderBmp(j);
                    } else {
                        i = wMElement2.updateBitmap(j, z3) | i;
                    }
                }
            }
            if (i != 0) {
                lock();
            }
        } else {
            for (WMElement wMElement22 : this.wmElements) {
                if ((wMElement22 instanceof TextWMElement) && z2) {
                    ((TextWMElement) wMElement22).updateTextShaderBmp(j);
                } else {
                    wMElement22.updateBitmap(j, z3);
                }
            }
        }
        for (WMElement wMElement222 : this.wmElements) {
            if ((wMElement222 instanceof TextWMElement) && !wMElement222.isContentChanged()) {
                z4 = false;
                break;
            }
        }
        z4 = true;
        for (WMElement wMElement2222 : this.wmElements) {
            if (wMElement2222.isContentChanged()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.mCopyFrame.mo67189a(-1, this.width, this.height, 0.0d);
            boolean z5 = GlUtil.curBlendModeEnabled;
            GlUtil.setBlendMode(true);
            BenchUtil.benchStart("updateTexture");
            BenchUtil.benchStart("clear texture");
            FrameUtil.clearFrame(this.mCopyFrame, 0.0f, 0.0f, 0.0f, 0.0f, this.width, this.height);
            BenchUtil.benchEnd("clear texture");
            for (WMElement wMElement3 : this.wmElements) {
                Bitmap bitmap = wMElement3.getBitmap();
                if (!(bitmap == null || bitmap.isRecycled())) {
                    BenchUtil.benchStart("load texture");
                    GlUtil.loadTexture(this.mTexId[0], bitmap);
                    BenchUtil.benchEnd("load texture");
                    float f = (float) this.width;
                    float f2 = (float) this.height;
                    PointF pointF = new PointF(0.0f, 0.0f);
                    if (!TextUtils.isEmpty(wMElement3.relativeID)) {
                        wMElement2222 = (WMElement) this.mIdElementMap.get(wMElement3.relativeID);
                        if (!(wMElement2222 == null || wMElement2222.finalContentRect == null)) {
                            f = wMElement2222.finalContentRect.width();
                            f2 = wMElement2222.finalContentRect.height();
                            pointF.x = wMElement2222.finalContentRect.left;
                            pointF.y = wMElement2222.finalContentRect.top;
                        }
                    }
                    float f3 = f;
                    PointF pointF2 = new PointF((float) wMElement3.offsetX, (float) wMElement3.offsetY);
                    f3 = (((f3 * wMElement3.relativeAnchor.x) + pointF.x) + pointF2.x) - (((float) wMElement3.width) * wMElement3.anchor.x);
                    float f4 = (((f2 * wMElement3.relativeAnchor.y) + pointF.y) + pointF2.y) - (((float) wMElement3.height) * wMElement3.anchor.y);
                    f = f3 + ((float) wMElement3.width);
                    f2 = ((float) wMElement3.height) + f4;
                    if (wMElement3 instanceof ImageWMElement) {
                        wMElement3.finalContentRect.left = f3;
                        wMElement3.finalContentRect.top = f4;
                        wMElement3.finalContentRect.right = f;
                        wMElement3.finalContentRect.bottom = f2;
                    } else {
                        TextWMElement textWMElement = (TextWMElement) wMElement3;
                        wMElement3.finalContentRect.left = textWMElement.getTextRect().left + f3;
                        wMElement3.finalContentRect.top = textWMElement.getTextRect().top + f4;
                        wMElement3.finalContentRect.right = textWMElement.getTextRect().right + f3;
                        wMElement3.finalContentRect.bottom = textWMElement.getTextRect().bottom + f4;
                    }
                    BaseFilter baseFilter = this.mCopyFilter;
                    if (!TextUtils.isEmpty(wMElement3.animateType) && this.mAnimationFilerMap.containsKey(wMElement3.animateType)) {
                        baseFilter = (WMAnimationFilterBase) this.mAnimationFilerMap.get(wMElement3.animateType);
                        baseFilter.updateParams(wMElement3, this.width, this.height);
                    }
                    BaseFilter baseFilter2 = baseFilter;
                    BenchUtil.benchStart("draw texture");
                    baseFilter2.setPositions(AlgoUtils.calPositions(f3, f2, f, f4, this.width, this.height));
                    baseFilter2.OnDrawFrameGLSL();
                    baseFilter2.renderTexture(this.mTexId[0], this.width, this.height);
                    BenchUtil.benchEnd("draw texture");
                }
            }
            BenchUtil.benchEnd("updateTexture");
            GlUtil.setBlendMode(z5);
        }
        AppMethodBeat.m2505o(83594);
        return z4;
    }

    public int getCurTexture() {
        return this.mCopyFrame.texture[0];
    }

    public void setItemId(String str) {
        AppMethodBeat.m2504i(83595);
        for (WMElement wMElement : this.wmElements) {
            wMElement.itemId = str;
        }
        AppMethodBeat.m2505o(83595);
    }

    public boolean firstDrew() {
        AppMethodBeat.m2504i(83596);
        for (WMElement wMElement : this.wmElements) {
            if (wMElement.firstDrew) {
                AppMethodBeat.m2505o(83596);
                return true;
            }
        }
        AppMethodBeat.m2505o(83596);
        return false;
    }

    public WMAnimationFilterBase createAnimationFilter(WMElement wMElement, int i, int i2) {
        AppMethodBeat.m2504i(83597);
        if (WMElement.ANIMATE_TYPE_SCALE.equals(wMElement.animateType)) {
            WMScaleAnimationFilter wMScaleAnimationFilter = new WMScaleAnimationFilter(wMElement, i, i2);
            AppMethodBeat.m2505o(83597);
            return wMScaleAnimationFilter;
        } else if (WMElement.ANIMATE_TYPE_DITHERING.equals(wMElement.animateType)) {
            WMAnimationFilterBase wMDitheringAnimationFilter = new WMDitheringAnimationFilter(wMElement, i, i2);
            AppMethodBeat.m2505o(83597);
            return wMDitheringAnimationFilter;
        } else {
            AppMethodBeat.m2505o(83597);
            return null;
        }
    }

    public boolean isLock() {
        return this.locked;
    }

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }

    public void reset() {
        AppMethodBeat.m2504i(83598);
        for (WMElement reset : this.wmElements) {
            reset.reset();
        }
        AppMethodBeat.m2505o(83598);
    }
}
