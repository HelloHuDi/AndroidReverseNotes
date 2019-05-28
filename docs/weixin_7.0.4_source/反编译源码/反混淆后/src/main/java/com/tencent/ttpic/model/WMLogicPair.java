package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WMLogicPair implements Comparable<WMLogicPair> {
    public String key;
    public String value;

    public WMLogicPair(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public int compareTo(WMLogicPair wMLogicPair) {
        AppMethodBeat.m2504i(83602);
        if (Integer.parseInt(this.key) > Integer.parseInt(wMLogicPair.key)) {
            AppMethodBeat.m2505o(83602);
            return 1;
        }
        AppMethodBeat.m2505o(83602);
        return -1;
    }
}
