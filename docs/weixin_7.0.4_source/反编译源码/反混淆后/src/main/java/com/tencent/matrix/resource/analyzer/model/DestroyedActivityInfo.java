package com.tencent.matrix.resource.analyzer.model;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class DestroyedActivityInfo {
    public final String mActivityName;
    public final WeakReference<Activity> mActivityRef;
    public int mDetectedCount = 0;
    public final String mKey;
    public final long mLastCreatedActivityCount;

    public DestroyedActivityInfo(String str, Activity activity, String str2, long j) {
        this.mKey = str;
        this.mActivityName = str2;
        this.mActivityRef = new WeakReference(activity);
        this.mLastCreatedActivityCount = j;
    }
}
