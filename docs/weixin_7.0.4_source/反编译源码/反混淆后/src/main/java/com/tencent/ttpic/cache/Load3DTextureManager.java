package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.thread.VideoThreadPool;
import java.util.ArrayList;
import java.util.List;

public class Load3DTextureManager implements LoadItemManager {
    private String dataPath;
    private List<AsyncTask<Void, Integer, Boolean>> mImageTasks;
    private String[] textureImages;

    public Load3DTextureManager(String str, String[] strArr) {
        this.dataPath = str;
        this.textureImages = strArr;
    }

    public void prepareImages() {
        AppMethodBeat.m2504i(81774);
        ArrayList arrayList = new ArrayList();
        if (this.textureImages != null && this.textureImages.length > 0) {
            this.mImageTasks = new ArrayList();
            for (int i = 0; i < 4; i++) {
                arrayList.add(new ArrayList());
            }
            int i2 = 0;
            int i3 = 0;
            while (i3 < this.textureImages.length) {
                ((List) arrayList.get(i2)).add(this.textureImages[i3]);
                i3++;
                i2 = (i2 + 1) % 4;
            }
            this.mImageTasks = new ArrayList();
            for (i2 = 0; i2 < arrayList.size(); i2++) {
                Load3DTextureTask load3DTextureTask = new Load3DTextureTask(this.dataPath, (List) arrayList.get(i2));
                load3DTextureTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
                this.mImageTasks.add(load3DTextureTask);
            }
        }
        AppMethodBeat.m2505o(81774);
    }

    public Bitmap loadImage(int i) {
        return null;
    }

    public ETC1Texture loadETCRGBTexture(int i) {
        return null;
    }

    public ETC1Texture loadETCAlphaTexture(int i) {
        return null;
    }

    public Bitmap loadImage(String str) {
        return null;
    }

    public void clear() {
        AppMethodBeat.m2504i(81775);
        GamePlaySDK.getInstance().clearItemImage();
        if (this.mImageTasks != null) {
            for (AsyncTask cancel : this.mImageTasks) {
                cancel.cancel(true);
            }
        }
        AppMethodBeat.m2505o(81775);
    }

    public void reset() {
    }
}
