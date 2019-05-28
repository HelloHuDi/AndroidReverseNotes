package com.tencent.ttpic.gameplaysdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;

public class StickerItem3D extends StickerItem {
    public String curFrameImagePath;
    public int curPlayCount = 0;
    public String extension = "";
    public long frameStartTime;
    public float[] nodeEulerAngles;
    public NodeParameter nodeParameter;
    public float[] nodePosition;
    public float[] nodeScale;
    public boolean triggered = false;

    public void calFrameIndex(long j) {
        AppMethodBeat.i(83222);
        if (!TextUtils.isEmpty(this.id) && this.id.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
            if (!this.triggered || TextUtils.isEmpty(this.extension)) {
                this.curPlayCount = 0;
                this.curFrameImagePath = "";
                this.frameStartTime = j;
                AppMethodBeat.o(83222);
                return;
            }
            int max = (int) (((double) (j - this.frameStartTime)) / Math.max(this.frameDuration, 1.0d));
            if (max >= this.frames * (this.curPlayCount + 1)) {
                this.curPlayCount++;
            }
            max %= Math.max(this.frames, 1);
            String[] split = this.id.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split.length == 2) {
                String str = split[1];
                this.curFrameImagePath = str + File.separator + str + "_" + max + "." + this.extension;
            }
        }
        AppMethodBeat.o(83222);
    }
}
