package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.Map;

public abstract class PreLoader {
    public static final Object LOCK_IMAGE_PRE_LOADER = new Object();
    private static final String TAG = PreLoader.class.getSimpleName();
    protected Map<String, Bitmap> cache;
    protected int capacity;
    protected String dataPath;
    protected int frontIndex;
    private volatile boolean isRunning;
    protected StickerItem item;
    protected String materialId;
    private boolean prepared;
    protected int rearIndex;

    public abstract void clear();

    public abstract void preloadNewImages(int i);

    public abstract void prepareImages();

    public PreLoader(Map<String, Bitmap> map, String str, StickerItem stickerItem, int i) {
        this.cache = map;
        this.dataPath = str;
        this.materialId = VideoMaterialUtil.getMaterialId(str);
        this.item = stickerItem;
        this.capacity = i;
    }

    public void prepare() {
        reset();
    }

    public void reset() {
        if (!this.prepared) {
            this.prepared = true;
            VideoThreadPool.getInstance().submit(new Runnable() {
                public void run() {
                    AppMethodBeat.i(81830);
                    PreLoader.this.prepareImages();
                    AppMethodBeat.o(81830);
                }
            });
        }
    }

    public void updateIndex(final int i) {
        if (i != this.frontIndex && !this.isRunning) {
            this.prepared = false;
            releaseExpiredBitmaps(this.frontIndex, i);
            this.isRunning = true;
            VideoThreadPool.getInstance().submit(new Runnable() {
                public void run() {
                    AppMethodBeat.i(81831);
                    PreLoader.this.preloadNewImages(i);
                    PreLoader.this.isRunning = false;
                    AppMethodBeat.o(81831);
                }
            });
        }
    }

    private void releaseExpiredBitmaps(int i, int i2) {
        while (i != i2) {
            Bitmap bitmap = (Bitmap) this.cache.remove(this.materialId + File.separator + this.item.id + "_" + i + ".png");
            synchronized (LOCK_IMAGE_PRE_LOADER) {
                if (BitmapUtils.isLegal(bitmap)) {
                    bitmap.recycle();
                }
            }
            i = (i + 1) % this.item.frames;
        }
    }
}
