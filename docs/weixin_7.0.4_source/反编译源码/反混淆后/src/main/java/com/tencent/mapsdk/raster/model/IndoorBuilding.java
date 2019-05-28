package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class IndoorBuilding {
    private int mActiveLevelIndex;
    private String mBuidlingId;
    private String mBuildingName;
    private List<IndoorLevel> mLevels;

    public IndoorBuilding(String str, String str2, List<IndoorLevel> list, int i) {
        this.mBuidlingId = str;
        this.mBuildingName = str2;
        this.mLevels = list;
        this.mActiveLevelIndex = i;
    }

    public final String getBuidlingId() {
        return this.mBuidlingId;
    }

    public final String getBuildingName() {
        return this.mBuildingName;
    }

    public final List<IndoorLevel> getLevels() {
        return this.mLevels;
    }

    public final int getActiveLevelIndex() {
        return this.mActiveLevelIndex;
    }

    public final String toString() {
        AppMethodBeat.m2504i(101186);
        if (this.mBuidlingId == null || this.mLevels == null || this.mLevels.size() <= this.mActiveLevelIndex) {
            AppMethodBeat.m2505o(101186);
            return null;
        }
        String str = this.mBuidlingId + "_" + ((IndoorLevel) this.mLevels.get(this.mActiveLevelIndex)).getName();
        AppMethodBeat.m2505o(101186);
        return str;
    }
}
