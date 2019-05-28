package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.cache.LoadItemManager.LOAD_TYPE;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LoadStickerItemManager3D implements LoadItemManager {
    private static final int CAPACITY = 5;
    public static final Comparator<String> mPngComperator = new Comparator<String>() {
        public final int compare(String str, String str2) {
            AppMethodBeat.i(81820);
            try {
                String imageName = getImageName(str);
                String imageName2 = getImageName(str2);
                int frameIndex;
                if (imageName.equals(imageName2)) {
                    frameIndex = getFrameIndex(str) - getFrameIndex(str2);
                    AppMethodBeat.o(81820);
                    return frameIndex;
                }
                frameIndex = imageName.compareTo(imageName2);
                AppMethodBeat.o(81820);
                return frameIndex;
            } catch (Exception e) {
                AppMethodBeat.o(81820);
                return 0;
            }
        }

        private String getImageName(String str) {
            AppMethodBeat.i(81821);
            String substring = str.substring(0, str.lastIndexOf(95));
            AppMethodBeat.o(81821);
            return substring;
        }

        private int getFrameIndex(String str) {
            AppMethodBeat.i(81822);
            int parseInt = Integer.parseInt(str.substring(str.lastIndexOf(95) + 1, str.lastIndexOf(46)));
            AppMethodBeat.o(81822);
            return parseInt;
        }
    };
    private String dataPath;
    private StickerItem3D item;
    private LOAD_TYPE loadType;
    private AsyncTask<Void, Integer, Boolean> mImageTask;
    private PreLoader mPreLoader;
    private String realItemId;

    public LoadStickerItemManager3D(String str, StickerItem3D stickerItem3D, String str2, LOAD_TYPE load_type) {
        AppMethodBeat.i(81824);
        this.dataPath = str;
        this.item = stickerItem3D;
        this.realItemId = str2;
        if (stickerItem3D.markMode != 0) {
            this.loadType = LOAD_TYPE.LOAD_ALL;
            AppMethodBeat.o(81824);
            return;
        }
        this.loadType = load_type;
        AppMethodBeat.o(81824);
    }

    public void prepareImages() {
        AppMethodBeat.i(81825);
        if (this.loadType == LOAD_TYPE.LOAD_ALL && this.item.sourceType == ITEM_SOURCE_TYPE.IMAGE) {
            ArrayList arrayList = new ArrayList(this.item.frames);
            if (TextUtils.isEmpty(this.item.extension)) {
                this.item.extension = getImageFileExtension(this.dataPath + File.separator + this.realItemId);
            }
            for (int i = 0; i < this.item.frames; i++) {
                arrayList.add(this.realItemId + File.separator + this.realItemId + "_" + i + "." + this.item.extension);
            }
            Collections.sort(arrayList, mPngComperator);
            this.mImageTask = new LoadImageTask3D(this.dataPath, arrayList);
            this.mImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
        }
        AppMethodBeat.o(81825);
    }

    private String getImageFileExtension(String str) {
        String str2;
        AppMethodBeat.i(81826);
        File[] listFiles = new File(str).listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                AppMethodBeat.i(81819);
                if (str.endsWith(".png") || str.endsWith(FileUtils.PIC_POSTFIX_JPEG)) {
                    AppMethodBeat.o(81819);
                    return true;
                }
                AppMethodBeat.o(81819);
                return false;
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            String[] split = listFiles[0].getName().split("\\.");
            if (split != null && split.length == 2) {
                str2 = split[1];
                AppMethodBeat.o(81826);
                return str2;
            }
        }
        str2 = "png";
        AppMethodBeat.o(81826);
        return str2;
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
        AppMethodBeat.i(81827);
        GamePlaySDK.getInstance().clearItemImage();
        if (this.mImageTask != null) {
            this.mImageTask.cancel(true);
        }
        if (this.mPreLoader != null) {
            this.mPreLoader.clear();
        }
        AppMethodBeat.o(81827);
    }

    public void reset() {
        AppMethodBeat.i(81828);
        if (this.mPreLoader != null) {
            this.mPreLoader.reset();
        }
        AppMethodBeat.o(81828);
    }

    static {
        AppMethodBeat.i(81829);
        AppMethodBeat.o(81829);
    }
}
