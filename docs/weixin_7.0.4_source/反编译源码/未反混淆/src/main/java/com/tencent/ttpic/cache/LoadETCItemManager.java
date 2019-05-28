package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.Map;

public class LoadETCItemManager implements LoadItemManager {
    public static int FORMAT_COUNT = 3;
    private String dataPath;
    private StickerItem item;
    private Map<String, ETC1Texture> mCache;
    private AsyncTask<Void, Integer, Boolean> mImageTask;

    public LoadETCItemManager(Map<String, ETC1Texture> map, String str, StickerItem stickerItem) {
        this.dataPath = str;
        this.item = stickerItem;
        this.mCache = map;
    }

    public void prepareImages() {
        AppMethodBeat.i(81780);
        this.mImageTask = new LoadETCTextureTask(this.mCache, this.item.id, this.item.frames, this.dataPath + File.separator + this.item.subFolder + ".zip", VideoMaterialUtil.getMaterialId(this.dataPath));
        this.mImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
        AppMethodBeat.o(81780);
    }

    public Bitmap loadImage(int i) {
        return null;
    }

    public Bitmap loadImage(String str) {
        return null;
    }

    public ETC1Texture loadETCRGBTexture(int i) {
        AppMethodBeat.i(81781);
        ETC1Texture eTC1Texture = (ETC1Texture) this.mCache.get(VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.id + "_" + String.format("%0" + FORMAT_COUNT + "d", new Object[]{Integer.valueOf(i)}) + ".pkm");
        AppMethodBeat.o(81781);
        return eTC1Texture;
    }

    public ETC1Texture loadETCAlphaTexture(int i) {
        AppMethodBeat.i(81782);
        ETC1Texture eTC1Texture = (ETC1Texture) this.mCache.get(VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.id + "_" + String.format("%0" + FORMAT_COUNT + "d", new Object[]{Integer.valueOf(i)}) + "_alpha.pkm");
        AppMethodBeat.o(81782);
        return eTC1Texture;
    }

    public void clear() {
        AppMethodBeat.i(81783);
        if (this.mImageTask != null) {
            this.mImageTask.cancel(true);
        }
        AppMethodBeat.o(81783);
    }

    public void reset() {
    }
}
