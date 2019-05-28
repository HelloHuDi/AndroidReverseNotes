package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class DistortParam {
    private List<DistortionItem> items;
    private int level;

    public DistortParam() {
        AppMethodBeat.m2504i(83478);
        this.level = 0;
        this.items = new ArrayList();
        AppMethodBeat.m2505o(83478);
    }

    public DistortParam(int i, List<DistortionItem> list) {
        this.level = i;
        this.items = list;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public List<DistortionItem> getItems() {
        return this.items;
    }

    public void setItems(List<DistortionItem> list) {
        this.items = list;
    }
}
