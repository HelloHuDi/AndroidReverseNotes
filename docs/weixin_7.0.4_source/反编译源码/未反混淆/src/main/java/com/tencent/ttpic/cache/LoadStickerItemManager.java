package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.cache.LoadItemManager.LOAD_TYPE;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;

public class LoadStickerItemManager implements LoadItemManager {
    private static final int CAPACITY = 5;
    public static final Comparator<String> mPngComperator = new Comparator<String>() {
        public final int compare(String str, String str2) {
            AppMethodBeat.i(81808);
            try {
                String imageName = getImageName(str);
                String imageName2 = getImageName(str2);
                int frameIndex;
                if (imageName.equals(imageName2)) {
                    frameIndex = getFrameIndex(str) - getFrameIndex(str2);
                    AppMethodBeat.o(81808);
                    return frameIndex;
                }
                frameIndex = imageName.compareTo(imageName2);
                AppMethodBeat.o(81808);
                return frameIndex;
            } catch (Exception e) {
                AppMethodBeat.o(81808);
                return 0;
            }
        }

        private String getImageName(String str) {
            AppMethodBeat.i(81809);
            String substring = str.substring(0, str.lastIndexOf(95));
            AppMethodBeat.o(81809);
            return substring;
        }

        private int getFrameIndex(String str) {
            AppMethodBeat.i(81810);
            int parseInt = Integer.parseInt(str.substring(str.lastIndexOf(95) + 1, str.lastIndexOf(46)));
            AppMethodBeat.o(81810);
            return parseInt;
        }
    };
    private String dataPath;
    private StickerItem item;
    private LOAD_TYPE loadType;
    private Map<String, Bitmap> mCache;
    private AsyncTask<Void, Integer, Boolean> mImageTask;
    private PreLoader mPreLoader;
    private int sampleSize;

    public LoadStickerItemManager(Map<String, Bitmap> map, String str, StickerItem stickerItem, LOAD_TYPE load_type, int i) {
        AppMethodBeat.i(81812);
        this.dataPath = str;
        this.item = stickerItem;
        this.mCache = map;
        this.sampleSize = i;
        if (stickerItem.markMode != 0) {
            this.loadType = LOAD_TYPE.LOAD_ALL;
            AppMethodBeat.o(81812);
            return;
        }
        this.loadType = load_type;
        AppMethodBeat.o(81812);
    }

    public void prepareImages() {
        AppMethodBeat.i(81813);
        if (this.loadType == LOAD_TYPE.LOAD_ALL) {
            if (this.item.sourceType == ITEM_SOURCE_TYPE.IMAGE) {
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList(this.item.frames);
                int i;
                if (this.item.markMode != 0) {
                    for (int i2 = 0; i2 <= 10; i2++) {
                        for (i = 0; i < this.item.frames; i++) {
                            arrayList.add(this.item.id + "_" + i + "_" + i2 + ".png");
                        }
                    }
                    for (i = 0; i < this.item.frames; i++) {
                        arrayList.add(this.item.id + "_" + i + "_x.png");
                    }
                } else {
                    hashSet.addAll(VideoFilterUtil.getAllPngFileNames(this.dataPath + File.separator + this.item.subFolder));
                    for (i = 0; i < this.item.frames; i++) {
                        hashSet.add(this.item.id + "_" + i + ".png");
                    }
                    arrayList.addAll(hashSet);
                    Collections.sort(arrayList, mPngComperator);
                }
                this.mImageTask = new LoadImageTask(this.mCache, arrayList, this.dataPath + File.separator + this.item.subFolder, VideoMaterialUtil.getMaterialId(this.dataPath), this.sampleSize);
                this.mImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
                AppMethodBeat.o(81813);
                return;
            }
        } else if (this.item.sourceType == ITEM_SOURCE_TYPE.IMAGE) {
            this.mPreLoader = new ImagePreLoader(this.mCache, this.dataPath, this.item, 5);
            this.mPreLoader.prepare();
        }
        AppMethodBeat.o(81813);
    }

    public Bitmap loadImage(int i) {
        AppMethodBeat.i(81814);
        if (this.mPreLoader != null) {
            this.mPreLoader.updateIndex(i);
        }
        Bitmap bitmap = (Bitmap) this.mCache.get(VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.id + "_" + i + ".png");
        AppMethodBeat.o(81814);
        return bitmap;
    }

    public ETC1Texture loadETCRGBTexture(int i) {
        return null;
    }

    public ETC1Texture loadETCAlphaTexture(int i) {
        return null;
    }

    public Bitmap loadImage(String str) {
        AppMethodBeat.i(81815);
        Bitmap bitmap = (Bitmap) this.mCache.get(VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + str);
        AppMethodBeat.o(81815);
        return bitmap;
    }

    public void clear() {
        AppMethodBeat.i(81816);
        if (this.mImageTask != null) {
            this.mImageTask.cancel(true);
        }
        if (this.mPreLoader != null) {
            this.mPreLoader.clear();
        }
        AppMethodBeat.o(81816);
    }

    public void reset() {
        AppMethodBeat.i(81817);
        if (this.mPreLoader != null) {
            this.mPreLoader.reset();
        }
        AppMethodBeat.o(81817);
    }

    static {
        AppMethodBeat.i(81818);
        AppMethodBeat.o(81818);
    }
}
