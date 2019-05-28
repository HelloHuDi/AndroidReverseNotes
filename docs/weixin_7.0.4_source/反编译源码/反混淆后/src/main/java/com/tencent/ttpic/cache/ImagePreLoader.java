package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.Map;

public class ImagePreLoader extends PreLoader {
    private static final String TAG = ImagePreLoader.class.getSimpleName();

    static {
        AppMethodBeat.m2504i(81770);
        AppMethodBeat.m2505o(81770);
    }

    public ImagePreLoader(Map<String, Bitmap> map, String str, StickerItem stickerItem, int i) {
        super(map, str, stickerItem, i);
    }

    public void prepareImages() {
        int i = 0;
        AppMethodBeat.m2504i(81768);
        this.frontIndex = 0;
        while (i < this.capacity && i < this.item.frames) {
            Object obj = this.item.f18271id + "_" + i + ".png";
            Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + this.item.subFolder + File.separator + obj, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
            if (!TextUtils.isEmpty(this.materialId)) {
                obj = this.materialId + File.separator + obj;
            }
            if (BitmapUtils.isLegal(decodeSampleBitmap) && !this.cache.containsKey(obj)) {
                this.cache.put(obj, decodeSampleBitmap);
            }
            this.rearIndex = i;
            i++;
        }
        AppMethodBeat.m2505o(81768);
    }

    public void preloadNewImages(int i) {
        AppMethodBeat.m2504i(81769);
        this.frontIndex = i;
        this.rearIndex = (this.frontIndex + this.capacity) % this.item.frames;
        int i2 = this.frontIndex;
        while (i2 != this.rearIndex) {
            Object obj;
            String str = this.item.f18271id + "_" + i2 + ".png";
            if (TextUtils.isEmpty(this.materialId)) {
                obj = str;
            } else {
                obj = this.materialId + File.separator + str;
            }
            if (!this.cache.containsKey(obj)) {
                Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + this.item.subFolder + File.separator + str, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
                if (BitmapUtils.isLegal(decodeSampleBitmap)) {
                    this.cache.put(obj, decodeSampleBitmap);
                }
            }
            i2 = (i2 + 1) % this.item.frames;
        }
        AppMethodBeat.m2505o(81769);
    }

    public void clear() {
    }
}
