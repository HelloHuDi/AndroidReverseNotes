package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.Map;

public class LoadGrayImageTask extends AsyncTask<Void, Integer, Boolean> {
    private final FEATURE_TYPE featureType;
    private final Map<FEATURE_TYPE, Bitmap> mGrayCache;
    private final int sampleSize;

    public LoadGrayImageTask(Map<FEATURE_TYPE, Bitmap> map, FEATURE_TYPE feature_type, int i) {
        this.mGrayCache = map;
        this.featureType = feature_type;
        this.sampleSize = i;
    }

    /* Access modifiers changed, original: protected|varargs */
    public Boolean doInBackground(Void... voidArr) {
        AppMethodBeat.m2504i(81791);
        Boolean bool;
        if (isCancelled()) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(81791);
            return bool;
        } else if (this.mGrayCache == null) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(81791);
            return bool;
        } else {
            if (!this.mGrayCache.containsKey(this.featureType)) {
                this.mGrayCache.put(this.featureType, FaceOffUtil.getGrayBitmap(this.featureType));
            }
            bool = Boolean.TRUE;
            AppMethodBeat.m2505o(81791);
            return bool;
        }
    }
}
