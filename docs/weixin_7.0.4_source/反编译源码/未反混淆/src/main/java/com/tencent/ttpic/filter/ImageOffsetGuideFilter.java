package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.view.g;

public class ImageOffsetGuideFilter extends BaseFilter {
    private float xOffset = 0.0f;

    public ImageOffsetGuideFilter() {
        super(GLSLRender.bJB);
    }

    public void initFrame(h hVar) {
        AppMethodBeat.i(82608);
        Bitmap decodeSampleBitmapFromAssets = BitmapUtils.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), "raw/guide_line.png", 1);
        hVar.texture[0] = g.at(decodeSampleBitmapFromAssets);
        hVar.width = decodeSampleBitmapFromAssets.getWidth();
        hVar.height = decodeSampleBitmapFromAssets.getHeight();
        AppMethodBeat.o(82608);
    }

    public void setxOffset(float f) {
        this.xOffset = -f;
    }

    private void updatePosition() {
        AppMethodBeat.i(82609);
        float f = this.xOffset - 0.16f;
        float f2 = this.xOffset + 0.16f;
        setPositions(new float[]{f, -1.0f, f, 1.0f, f2, 1.0f, f2, -1.0f});
        AppMethodBeat.o(82609);
    }

    public void RenderProcess(int i, int i2, int i3, int i4, double d, h hVar) {
        AppMethodBeat.i(82610);
        if (this.xOffset >= 0.0f || this.xOffset <= -1.0f) {
            AppMethodBeat.o(82610);
            return;
        }
        updatePosition();
        GlUtil.setBlendMode(true);
        super.RenderProcess(i, i2, i3, i4, d, hVar);
        GlUtil.setBlendMode(false);
        AppMethodBeat.o(82610);
    }
}
