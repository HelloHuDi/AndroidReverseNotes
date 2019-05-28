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

public class LoadImageTask extends AsyncTask<Void, Integer, Boolean> {
    private Map<String, Bitmap> cache;
    private String dataPath;
    private final String materialId;
    private List<String> resourceList;
    private final int sampleSize;

    public LoadImageTask(Map<String, Bitmap> map, List<String> list, String str, String str2, int i) {
        AppMethodBeat.i(81793);
        this.cache = map;
        this.resourceList = list;
        if (this.resourceList == null) {
            this.resourceList = new ArrayList();
        }
        this.dataPath = str;
        this.materialId = str2;
        this.sampleSize = i;
        AppMethodBeat.o(81793);
    }

    /* Access modifiers changed, original: protected|varargs */
    public Boolean doInBackground(Void... voidArr) {
        AppMethodBeat.i(81794);
        Boolean bool;
        if (this.cache == null) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(81794);
            return bool;
        }
        Bitmap bitmap = null;
        for (Object obj : this.resourceList) {
            if (isCancelled()) {
                bool = Boolean.FALSE;
                AppMethodBeat.o(81794);
                return bool;
            }
            Object obj2;
            Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + obj2, this.sampleSize);
            if (!TextUtils.isEmpty(this.materialId)) {
                obj2 = this.materialId + File.separator + obj2;
            }
            if (BitmapUtils.isLegal(decodeSampleBitmap)) {
                this.cache.put(obj2, decodeSampleBitmap);
                bitmap = decodeSampleBitmap;
            } else if (BitmapUtils.isLegal(bitmap)) {
                this.cache.put(obj2, bitmap);
            }
        }
        bool = Boolean.TRUE;
        AppMethodBeat.o(81794);
        return bool;
    }
}
