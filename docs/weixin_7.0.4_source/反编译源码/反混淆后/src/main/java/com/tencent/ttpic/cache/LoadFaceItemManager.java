package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class LoadFaceItemManager implements LoadItemManager {
    private final String dataPath;
    private final FaceItem item;
    private final Map<String, Bitmap> mCache;
    private AsyncTask<Void, Integer, Boolean> mFaceImageTask;
    private final Map<FEATURE_TYPE, Bitmap> mGrayCache;
    private AsyncTask<Void, Integer, Boolean> mGrayImageTask;
    private AsyncTask<Void, Integer, Boolean> mImageTask;
    private final int sampleSize;

    public LoadFaceItemManager(Map<String, Bitmap> map, Map<FEATURE_TYPE, Bitmap> map2, String str, FaceItem faceItem, int i) {
        this.dataPath = str;
        this.item = faceItem;
        this.mCache = map;
        this.mGrayCache = map2;
        this.sampleSize = i;
    }

    public void prepareImages() {
        AppMethodBeat.m2504i(81787);
        this.mGrayImageTask = new LoadGrayImageTask(this.mGrayCache, this.item.featureType, this.sampleSize);
        this.mGrayImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
        if (TextUtils.isEmpty(this.item.f3494id)) {
            this.mFaceImageTask = new LoadImageTask(this.mCache, Collections.singletonList(this.item.faceExchangeImage), this.dataPath, VideoMaterialUtil.getMaterialId(this.dataPath), this.sampleSize);
            this.mFaceImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
            AppMethodBeat.m2505o(81787);
            return;
        }
        ArrayList arrayList = new ArrayList(this.item.frames);
        for (int i = 0; i < this.item.frames; i++) {
            arrayList.add(this.item.f3494id + "_" + i + ".png");
        }
        this.mImageTask = new LoadImageTask(this.mCache, arrayList, this.dataPath + File.separator + this.item.f3494id, VideoMaterialUtil.getMaterialId(this.dataPath), this.sampleSize);
        this.mImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
        AppMethodBeat.m2505o(81787);
    }

    public Bitmap loadImage(String str) {
        AppMethodBeat.m2504i(81788);
        Bitmap bitmap = (Bitmap) this.mCache.get(VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + str);
        AppMethodBeat.m2505o(81788);
        return bitmap;
    }

    public Bitmap loadImage(int i) {
        AppMethodBeat.m2504i(81789);
        Bitmap bitmap = (Bitmap) this.mCache.get(VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.f3494id + "_" + i + ".png");
        AppMethodBeat.m2505o(81789);
        return bitmap;
    }

    public ETC1Texture loadETCRGBTexture(int i) {
        return null;
    }

    public ETC1Texture loadETCAlphaTexture(int i) {
        return null;
    }

    public void clear() {
        AppMethodBeat.m2504i(81790);
        if (this.mImageTask != null) {
            this.mImageTask.cancel(true);
        }
        if (this.mGrayImageTask != null) {
            this.mGrayImageTask.cancel(true);
        }
        if (this.mFaceImageTask != null) {
            this.mFaceImageTask.cancel(true);
        }
        AppMethodBeat.m2505o(81790);
    }

    public void reset() {
    }
}
