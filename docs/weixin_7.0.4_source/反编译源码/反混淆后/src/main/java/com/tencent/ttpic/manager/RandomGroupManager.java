package com.tencent.ttpic.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.model.MemRandomValue;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;
import java.util.Map;

public enum RandomGroupManager {
    INSTANCE;
    
    private static final int HAND_RANDOM_INDEX = 0;
    private Map<Integer, MemRandomValue> mRandomGroupFaceValueMap;
    private Map<Integer, MemRandomValue> mRandomGroupHandValueMap;

    static {
        AppMethodBeat.m2505o(83450);
    }

    public static RandomGroupManager getInstance() {
        return INSTANCE;
    }

    public final int getFaceValue(int i) {
        AppMethodBeat.m2504i(83440);
        if (this.mRandomGroupFaceValueMap.containsKey(Integer.valueOf(i))) {
            int i2 = ((MemRandomValue) this.mRandomGroupFaceValueMap.get(Integer.valueOf(i))).curValue;
            AppMethodBeat.m2505o(83440);
            return i2;
        }
        AppMethodBeat.m2505o(83440);
        return 0;
    }

    public final int getHandValue() {
        AppMethodBeat.m2504i(83441);
        int i = ((MemRandomValue) this.mRandomGroupHandValueMap.get(Integer.valueOf(0))).curValue;
        AppMethodBeat.m2505o(83441);
        return i;
    }

    public final void updateValue(List<Integer> list, boolean z, int i) {
        int i2;
        AppMethodBeat.m2504i(83442);
        if (!z) {
            clearHandRandomGroupStatus();
        }
        clearFaceRandomGroupStatus(list);
        fillEmptyRandomGroupValue(list, i);
        MemRandomValue memRandomValue = (MemRandomValue) this.mRandomGroupHandValueMap.get(Integer.valueOf(0));
        MemRandomValue memRandomValue2 = !BaseUtils.isEmpty(list) ? (MemRandomValue) this.mRandomGroupFaceValueMap.get(list.get(0)) : memRandomValue;
        if (memRandomValue == null || memRandomValue2 == null || ((memRandomValue.curValue >= 0 || !z) && (memRandomValue2.curValue >= 0 || BaseUtils.isEmpty(list)))) {
            i2 = -1;
        } else {
            i2 = AlgoUtils.randValueDiff(memRandomValue.curValue < 0 ? memRandomValue2.lastValue : memRandomValue.lastValue, i);
        }
        if (i2 < 0) {
            AppMethodBeat.m2505o(83442);
            return;
        }
        if (!BaseUtils.isEmpty(list)) {
            this.mRandomGroupFaceValueMap.put(list.get(0), new MemRandomValue(i2, i2));
        }
        if (z) {
            this.mRandomGroupHandValueMap.put(Integer.valueOf(0), new MemRandomValue(i2, i2));
        }
        AppMethodBeat.m2505o(83442);
    }

    private void fillEmptyRandomGroupValue(List<Integer> list, int i) {
        int intValue;
        AppMethodBeat.m2504i(83443);
        for (Integer intValue2 : list) {
            intValue = intValue2.intValue();
            if (!this.mRandomGroupFaceValueMap.containsKey(Integer.valueOf(intValue))) {
                this.mRandomGroupFaceValueMap.put(Integer.valueOf(intValue), new MemRandomValue());
            }
        }
        intValue = 1;
        while (true) {
            int i2 = intValue;
            if (i2 < list.size()) {
                MemRandomValue memRandomValue = (MemRandomValue) this.mRandomGroupFaceValueMap.get(list.get(i2));
                if (memRandomValue != null && memRandomValue.curValue < 0) {
                    int randValueDiff = AlgoUtils.randValueDiff(memRandomValue.lastValue, i);
                    memRandomValue.curValue = randValueDiff;
                    memRandomValue.lastValue = randValueDiff;
                }
                this.mRandomGroupFaceValueMap.put(list.get(i2), memRandomValue);
                intValue = i2 + 1;
            } else {
                AppMethodBeat.m2505o(83443);
                return;
            }
        }
    }

    private void clearFaceRandomGroupStatus(List<Integer> list) {
        AppMethodBeat.m2504i(83444);
        for (Integer intValue : this.mRandomGroupFaceValueMap.keySet()) {
            int intValue2 = intValue.intValue();
            if (!faceExist(list, intValue2)) {
                MemRandomValue memRandomValue = (MemRandomValue) this.mRandomGroupFaceValueMap.get(Integer.valueOf(intValue2));
                if (memRandomValue != null) {
                    memRandomValue.curValue = -1;
                    this.mRandomGroupFaceValueMap.put(Integer.valueOf(intValue2), memRandomValue);
                }
            }
        }
        AppMethodBeat.m2505o(83444);
    }

    private boolean faceExist(List<Integer> list, int i) {
        AppMethodBeat.m2504i(83445);
        for (Integer intValue : list) {
            if (intValue.intValue() == i) {
                AppMethodBeat.m2505o(83445);
                return true;
            }
        }
        AppMethodBeat.m2505o(83445);
        return false;
    }

    private void clearFaceRandomGroupStatus() {
        AppMethodBeat.m2504i(83446);
        for (Integer intValue : this.mRandomGroupFaceValueMap.keySet()) {
            int intValue2 = intValue.intValue();
            MemRandomValue memRandomValue = (MemRandomValue) this.mRandomGroupFaceValueMap.get(Integer.valueOf(intValue2));
            if (memRandomValue != null) {
                memRandomValue.curValue = -1;
                this.mRandomGroupFaceValueMap.put(Integer.valueOf(intValue2), memRandomValue);
            }
        }
        AppMethodBeat.m2505o(83446);
    }

    private void clearHandRandomGroupStatus() {
        AppMethodBeat.m2504i(83447);
        MemRandomValue memRandomValue = (MemRandomValue) this.mRandomGroupHandValueMap.get(Integer.valueOf(0));
        memRandomValue.curValue = -1;
        this.mRandomGroupHandValueMap.put(Integer.valueOf(0), memRandomValue);
        AppMethodBeat.m2505o(83447);
    }

    public final void clearCurValue() {
        AppMethodBeat.m2504i(83448);
        clearFaceRandomGroupStatus();
        clearHandRandomGroupStatus();
        AppMethodBeat.m2505o(83448);
    }

    public final void clearAll() {
        AppMethodBeat.m2504i(83449);
        this.mRandomGroupFaceValueMap.clear();
        this.mRandomGroupHandValueMap.put(Integer.valueOf(0), new MemRandomValue());
        AppMethodBeat.m2505o(83449);
    }
}
