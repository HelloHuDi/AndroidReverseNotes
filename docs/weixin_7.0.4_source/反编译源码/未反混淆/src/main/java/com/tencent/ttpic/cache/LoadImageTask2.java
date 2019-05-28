package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoadImageTask2 extends AsyncTask<Void, Integer, Boolean> {
    private Map<String, Bitmap> cache;
    private String dataPath;
    private final String materialId;
    private List<String> resourceList;
    private final int sampleSize;

    public LoadImageTask2(Map<String, Bitmap> map, List<String> list, String str, String str2, int i) {
        AppMethodBeat.i(81796);
        this.cache = map;
        this.resourceList = list;
        if (this.resourceList == null) {
            this.resourceList = new ArrayList();
        }
        this.dataPath = str;
        this.materialId = str2;
        this.sampleSize = i;
        AppMethodBeat.o(81796);
    }

    /* Access modifiers changed, original: protected|varargs */
    public Boolean doInBackground(Void... voidArr) {
        AppMethodBeat.i(81797);
        Boolean bool;
        if (this.cache == null) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(81797);
            return bool;
        }
        for (Object obj : this.resourceList) {
            if (isCancelled()) {
                bool = Boolean.FALSE;
                AppMethodBeat.o(81797);
                return bool;
            }
            Object obj2;
            Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + obj2, this.sampleSize);
            if (!TextUtils.isEmpty(this.materialId)) {
                obj2 = this.materialId + File.separator + obj2;
            }
            if (BitmapUtils.isLegal(decodeSampleBitmap) && !this.cache.containsKey(obj2)) {
                this.cache.put(obj2, decodeSampleBitmap);
            }
        }
        bool = Boolean.TRUE;
        AppMethodBeat.o(81797);
        return bool;
    }

    /* Access modifiers changed, original: protected */
    public void onCancelled(Boolean bool) {
        AppMethodBeat.i(81798);
        super.onCancelled(bool);
        if (this.cache == null) {
            AppMethodBeat.o(81798);
            return;
        }
        for (Object obj : this.resourceList) {
            Object obj2;
            if (!TextUtils.isEmpty(this.materialId)) {
                obj2 = this.materialId + File.separator + obj2;
            }
            if (this.cache.containsKey(obj2)) {
                this.cache.remove(obj2);
            }
        }
        AppMethodBeat.o(81798);
    }
}
