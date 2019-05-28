package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;

public class ImageWMElement extends WMElement {
    private static final String TAG = ImageWMElement.class.getSimpleName();
    private long firstTimestamp;
    private boolean loadImageSuccess;

    static {
        AppMethodBeat.i(83506);
        AppMethodBeat.o(83506);
    }

    public void init() {
        AppMethodBeat.i(83499);
        super.init();
        this.curValue = getValue(0);
        AppMethodBeat.o(83499);
    }

    private String getValue(int i) {
        AppMethodBeat.i(83500);
        String str;
        if (TextUtils.isEmpty(this.userValue)) {
            str = "";
            if (this.imgPath != null) {
                str = new String(this.imgPath);
            }
            if (this.logic != null) {
                str = str.replace("[logic]", this.logic.getValue(this.userValue));
            }
            str = LogicDataManager.getInstance().replaceWithData(str, this.dataKeys).replace("%d", String.valueOf(i));
            AppMethodBeat.o(83500);
            return str;
        }
        str = this.userValue;
        AppMethodBeat.o(83500);
        return str;
    }

    public boolean updateBitmap(long j, boolean z, boolean z2) {
        boolean z3 = false;
        AppMethodBeat.i(83501);
        BenchUtil.benchStart("ImageUpdateBitmap");
        this.curValue = getValue(getFrameIndex(j));
        if (needUpdateImage()) {
            Bitmap loadImage;
            if (!z2 || TextUtils.isEmpty(this.dataPath)) {
                loadImage = VideoMemoryManager.getInstance().loadImage(this.itemId, this.curValue);
            } else {
                loadImage = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + this.itemId + File.separator + this.curValue, 1);
            }
            if (loadImage == null || loadImage.isRecycled()) {
                this.loadImageSuccess = false;
            } else {
                setIdleBitmap(loadImage);
                swapActiveBitmap();
                setContentChanged(true);
                this.loadImageSuccess = true;
                if (this.firstDrew) {
                    z3 = true;
                }
                this.firstDrew = true;
            }
        }
        BenchUtil.benchEnd("ImageUpdateBitmap");
        AppMethodBeat.o(83501);
        return z3;
    }

    public boolean updateBitmap(long j, boolean z) {
        AppMethodBeat.i(83502);
        boolean updateBitmap = updateBitmap(j, z, false);
        AppMethodBeat.o(83502);
        return updateBitmap;
    }

    private boolean needUpdateImage() {
        AppMethodBeat.i(83503);
        if (this.curValue.equals(this.lastValue) && this.loadImageSuccess && TextUtils.isEmpty(this.animateType)) {
            AppMethodBeat.o(83503);
            return false;
        }
        AppMethodBeat.o(83503);
        return true;
    }

    private int getFrameIndex(long j) {
        if (this.firstTimestamp <= 0) {
            this.firstTimestamp = j;
        }
        if (this.frames <= 0) {
            return 0;
        }
        return ((int) ((j - this.firstTimestamp) / ((long) this.frameDuration))) % this.frames;
    }

    public Bitmap getBitmap() {
        AppMethodBeat.i(83504);
        this.lastValue = this.curValue;
        setContentChanged(false);
        Bitmap bitmap = super.getBitmap();
        AppMethodBeat.o(83504);
        return bitmap;
    }

    public void reset() {
        AppMethodBeat.i(83505);
        this.firstTimestamp = 0;
        setContentChanged(false);
        AppMethodBeat.o(83505);
    }
}
