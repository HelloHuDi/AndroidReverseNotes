package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.p161a.p162a.C1094b;
import java.io.File;
import java.io.Serializable;

/* renamed from: com.tencent.matrix.resource.analyzer.model.a */
public final class C1097a implements Serializable {
    public final File bWS;
    public final String bWT;
    public final String mActivityName;

    public C1097a(File file, String str, String str2) {
        this.bWS = (File) C1094b.m2409d(file, "hprofFile");
        this.bWT = (String) C1094b.m2409d(str, "refKey");
        this.mActivityName = (String) C1094b.m2409d(str2, "activityName");
    }
}
