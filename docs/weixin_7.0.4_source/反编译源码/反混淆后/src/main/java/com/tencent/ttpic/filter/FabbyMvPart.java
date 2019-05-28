package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.fabby.FabbyUtil;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.ShakaEffectItem;
import com.tencent.ttpic.model.StickerItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FabbyMvPart {
    public List<Pair<Float, Double>> alphaMap = new ArrayList();
    public List<Pair<Float, Double>> anchorXMap = new ArrayList();
    public List<Pair<Float, Double>> anchorYMap = new ArrayList();
    public String audio;
    public StickerItem bgItem;
    public List<Pair<Float, Double>> blurDirectionMap = new ArrayList();
    public List<Pair<Float, Double>> blurRadiusMap = new ArrayList();
    public StickerItem coverItem;
    public List<Pair<Float, Double>> degreeMap = new ArrayList();
    public long duration;
    public int easeCurve = 0;
    public StickerItem fgItem;
    public String filterId;
    public List<Pair<Float, Integer>> filterParamMap = new ArrayList();
    public int filterType;
    public List<Pair<Float, Integer>> gridModeMap = new ArrayList();
    public List<Pair<Float, Integer>> gridOrderMap = new ArrayList();
    public List<Pair<Float, GridSettingModel>> gridSettingMap = new ArrayList();
    public List<Pair<Float, Integer>> gridTypeMap = new ArrayList();
    public String lutFile;
    public int partIndex;
    public List<Pair<Float, Double>> scaleMap = new ArrayList();
    private ShakaEffectItem shakaEffectItem;
    public long transitionDuration;
    public int transitionEase;
    public int transitionFunction;
    public StickerItem transitionItem;
    public int transitionMaskType = 1;
    public List<Pair<Float, Double>> translateXMap = new ArrayList();
    public List<Pair<Float, Double>> translateYMap = new ArrayList();

    public FabbyMvPart() {
        AppMethodBeat.m2504i(82285);
        AppMethodBeat.m2505o(82285);
    }

    public double getScale(float f) {
        AppMethodBeat.m2504i(82286);
        double rangeValue = FabbyUtil.getRangeValue(this.easeCurve, f, this.scaleMap, 1.0d);
        AppMethodBeat.m2505o(82286);
        return rangeValue;
    }

    public double getDegree(float f) {
        AppMethodBeat.m2504i(82287);
        double rangeValue = FabbyUtil.getRangeValue(this.easeCurve, f, this.degreeMap, 0.0d);
        AppMethodBeat.m2505o(82287);
        return rangeValue;
    }

    public double getAlpha(float f) {
        AppMethodBeat.m2504i(82288);
        double rangeValue = FabbyUtil.getRangeValue(this.easeCurve, f, this.alphaMap, 1.0d);
        AppMethodBeat.m2505o(82288);
        return rangeValue;
    }

    public double getBlurSize(float f) {
        AppMethodBeat.m2504i(82289);
        double rangeValue = FabbyUtil.getRangeValue(this.easeCurve, f, this.blurRadiusMap, 0.0d);
        AppMethodBeat.m2505o(82289);
        return rangeValue;
    }

    public double getBlurAngle(float f) {
        AppMethodBeat.m2504i(82290);
        double rangeValue = FabbyUtil.getRangeValue(this.easeCurve, f, this.blurDirectionMap, 0.0d);
        AppMethodBeat.m2505o(82290);
        return rangeValue;
    }

    public PointF getAnchor(float f) {
        AppMethodBeat.m2504i(82291);
        PointF pointF = new PointF();
        pointF.x = (float) FabbyUtil.getRangeValue(this.easeCurve, f, this.anchorXMap, 0.0d);
        pointF.y = (float) FabbyUtil.getRangeValue(this.easeCurve, f, this.anchorYMap, 0.0d);
        AppMethodBeat.m2505o(82291);
        return pointF;
    }

    public PointF getTranslate(float f) {
        AppMethodBeat.m2504i(82292);
        PointF pointF = new PointF();
        pointF.x = (float) FabbyUtil.getRangeValue(this.easeCurve, f, this.translateXMap, 0.0d);
        pointF.y = (float) FabbyUtil.getRangeValue(this.easeCurve, f, this.translateYMap, 0.0d);
        AppMethodBeat.m2505o(82292);
        return pointF;
    }

    public int getGridMode(float f) {
        AppMethodBeat.m2504i(82293);
        int divideValue = FabbyUtil.getDivideValue(f, this.gridModeMap, 0);
        AppMethodBeat.m2505o(82293);
        return divideValue;
    }

    public int getGridType(float f) {
        AppMethodBeat.m2504i(82294);
        int divideValue = FabbyUtil.getDivideValue(f, this.gridTypeMap, 0);
        AppMethodBeat.m2505o(82294);
        return divideValue;
    }

    public GridSettingModel getGridSetting(float f) {
        AppMethodBeat.m2504i(82295);
        GridSettingModel gridSetting = FabbyUtil.getGridSetting(f, this.gridSettingMap, null);
        AppMethodBeat.m2505o(82295);
        return gridSetting;
    }

    public int getGridOrder(float f) {
        AppMethodBeat.m2504i(82296);
        int divideValue = FabbyUtil.getDivideValue(f, this.gridOrderMap, 0);
        AppMethodBeat.m2505o(82296);
        return divideValue;
    }

    public int getFilterParam(float f) {
        AppMethodBeat.m2504i(82297);
        int divideValue = FabbyUtil.getDivideValue(f, this.filterParamMap, 1);
        AppMethodBeat.m2505o(82297);
        return divideValue;
    }

    public ShakaEffectItem getShakaEffectItem() {
        return this.shakaEffectItem;
    }

    public void setShakaEffectItem(ShakaEffectItem shakaEffectItem) {
        this.shakaEffectItem = shakaEffectItem;
    }

    public Map<String, Float> getShakaValueMap(float f) {
        AppMethodBeat.m2504i(82298);
        Map valueMap = this.shakaEffectItem.getValueMap(this.easeCurve, f);
        AppMethodBeat.m2505o(82298);
        return valueMap;
    }
}
