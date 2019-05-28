package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.List;

public class FaceImageLayer {
    public double antiWrinkle;
    public double blendAlpha;
    public String cosFunTemplateFile;
    public double distortionAlpha;
    public List<DistortionItem> distortionList;
    public List<Double> extraDistortionAlphaArray;
    public List<List<Double>> extraFacePointsArray;
    public List<Double> faceColorRange;
    public List<Double> faceMaskFacePoint;
    public String faceMaskImagePath;
    public List<Integer> faceTriangle;
    public FEATURE_TYPE featureType = FEATURE_TYPE.CRAZY_FACE;
    public double height;
    public List<Double> imageFaceColor;
    public List<Double> imageFaceColor2;
    public List<Double> imageFacePoint;
    public String imagePath;
    public int type;
    public double width;
    /* renamed from: x */
    public double f16560x;
    /* renamed from: y */
    public double f16561y;

    public int getVersion() {
        AppMethodBeat.m2504i(83486);
        if (this.imageFaceColor2 == null || this.imageFaceColor2.size() < 12 || this.faceColorRange == null || this.faceColorRange.size() < 2) {
            AppMethodBeat.m2505o(83486);
            return 1;
        }
        AppMethodBeat.m2505o(83486);
        return 2;
    }
}
