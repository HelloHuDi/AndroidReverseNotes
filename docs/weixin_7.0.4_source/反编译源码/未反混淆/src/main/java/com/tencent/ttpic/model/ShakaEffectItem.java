package com.tencent.ttpic.model;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.fabby.FabbyUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ShakaEffectItem {
    private static final List<Pair<Float, Double>> EMPTY_LIST = new ArrayList();
    private int filterType;
    private Map<String, List<Pair<Float, Double>>> valueMap;

    static {
        AppMethodBeat.i(83516);
        AppMethodBeat.o(83516);
    }

    public int getFilterType() {
        return this.filterType;
    }

    public void setFilterType(int i) {
        this.filterType = i;
    }

    public List<Pair<Float, Double>> getValues(String str) {
        AppMethodBeat.i(83514);
        if (this.valueMap.containsKey(str)) {
            List<Pair<Float, Double>> list = (List) this.valueMap.get(str);
            AppMethodBeat.o(83514);
            return list;
        }
        List list2 = EMPTY_LIST;
        AppMethodBeat.o(83514);
        return list2;
    }

    public void setValueMap(Map<String, List<Pair<Float, Double>>> map) {
        this.valueMap = map;
    }

    public Map<String, List<Pair<Float, Double>>> getValueMap() {
        return this.valueMap;
    }

    public Map<String, Float> getValueMap(int i, float f) {
        AppMethodBeat.i(83515);
        HashMap hashMap = new HashMap();
        for (Entry entry : this.valueMap.entrySet()) {
            hashMap.put(entry.getKey(), Float.valueOf((float) FabbyUtil.getRangeValue(i, f, (List) entry.getValue(), 0.0d)));
        }
        AppMethodBeat.o(83515);
        return hashMap;
    }
}
