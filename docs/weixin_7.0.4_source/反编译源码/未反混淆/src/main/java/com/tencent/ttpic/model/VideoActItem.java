package com.tencent.ttpic.model;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.recorder.ActVideoDecoder;
import com.tencent.ttpic.util.BenchUtil;
import java.util.List;

public class VideoActItem extends FrameSourceItem {
    private static final int FRAME_INTERVAL = 83;
    private static String TAG = VideoActItem.class.getSimpleName();
    private ActVideoDecoder decoder;
    private String path;
    private int[] texId = new int[1];

    static {
        AppMethodBeat.i(83579);
        AppMethodBeat.o(83579);
    }

    public VideoActItem(String str, BaseFilter baseFilter) {
        super(baseFilter);
        AppMethodBeat.i(83572);
        this.path = str;
        AppMethodBeat.o(83572);
    }

    public void init() {
        AppMethodBeat.i(83573);
        GLES20.glGenTextures(this.texId.length, this.texId, 0);
        this.decoder = new ActVideoDecoder(this.path, this.texId[0]);
        this.decoder.decodeFrame(0);
        this.decoder.updateFrame();
        AppMethodBeat.o(83573);
    }

    public void update(h hVar, long j, List<List<PointF>> list, List<float[]> list2, int i) {
        AppMethodBeat.i(83574);
        BenchUtil.benchStart(TAG + "[update]");
        super.update(hVar, j, list, list2, i);
        this.decoder.decodeFrame(j);
        this.decoder.updateFrame();
        BenchUtil.benchEnd(TAG + "[update]");
        AppMethodBeat.o(83574);
    }

    public int getTexture(CanvasItem canvasItem, long j) {
        return this.texId[0];
    }

    public void clear() {
        AppMethodBeat.i(83575);
        if (this.decoder != null) {
            this.decoder.release();
            this.decoder = null;
        }
        GLES20.glDeleteTextures(this.texId.length, this.texId, 0);
        AppMethodBeat.o(83575);
    }

    public void reset() {
        AppMethodBeat.i(83576);
        this.decoder.reset();
        AppMethodBeat.o(83576);
    }

    public int getOrigWidth(int i) {
        AppMethodBeat.i(83577);
        int width = this.decoder.getWidth() / 2;
        AppMethodBeat.o(83577);
        return width;
    }

    public int getOrigHeight(int i) {
        AppMethodBeat.i(83578);
        int height = this.decoder.getHeight();
        AppMethodBeat.o(83578);
        return height;
    }
}
