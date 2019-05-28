package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.a.a.b;
import java.io.File;
import java.io.Serializable;

public final class a implements Serializable {
    public final File bWS;
    public final String bWT;
    public final String mActivityName;

    public a(File file, String str, String str2) {
        this.bWS = (File) b.d(file, "hprofFile");
        this.bWT = (String) b.d(str, "refKey");
        this.mActivityName = (String) b.d(str2, "activityName");
    }
}
