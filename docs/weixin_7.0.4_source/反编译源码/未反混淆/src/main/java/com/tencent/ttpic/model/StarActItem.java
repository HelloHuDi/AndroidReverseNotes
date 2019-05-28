package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.List;

public class StarActItem extends FrameSourceItem {
    private String[] filePaths;
    private int height;
    private int[] texId;
    private int width;

    public StarActItem(List<ExpressionItem> list, String str, BaseFilter baseFilter) {
        super(baseFilter);
        AppMethodBeat.i(83524);
        this.texId = new int[list.size()];
        this.filePaths = new String[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.filePaths.length) {
                this.filePaths[i2] = str + File.separator + ActUtil.EXPRESSION + File.separator + ((ExpressionItem) list.get(i2)).expressionID;
                i = i2 + 1;
            } else {
                AppMethodBeat.o(83524);
                return;
            }
        }
    }

    public void init() {
        int i = 0;
        AppMethodBeat.i(83525);
        GLES20.glGenTextures(this.texId.length, this.texId, 0);
        while (i < this.filePaths.length) {
            Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.filePaths[i], 720, ActUtil.HEIGHT);
            if (BitmapUtils.isLegal(decodeSampleBitmap)) {
                this.width = decodeSampleBitmap.getWidth();
                this.height = decodeSampleBitmap.getHeight();
                GlUtil.loadTexture(this.texId[i], decodeSampleBitmap);
                decodeSampleBitmap.recycle();
            }
            i++;
        }
        AppMethodBeat.o(83525);
    }

    public int getTexture(CanvasItem canvasItem, long j) {
        return this.texId[canvasItem.index];
    }

    public void clear() {
        AppMethodBeat.i(83526);
        GLES20.glDeleteTextures(this.texId.length, this.texId, 0);
        AppMethodBeat.o(83526);
    }

    public void reset() {
    }

    public int getOrigWidth(int i) {
        return this.width;
    }

    public int getOrigHeight(int i) {
        return this.height;
    }
}
