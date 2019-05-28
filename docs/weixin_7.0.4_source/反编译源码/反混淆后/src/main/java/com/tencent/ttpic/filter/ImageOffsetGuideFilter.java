package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.view.C41106g;

public class ImageOffsetGuideFilter extends BaseFilter {
    private float xOffset = 0.0f;

    public ImageOffsetGuideFilter() {
        super(GLSLRender.bJB);
    }

    public void initFrame(C41672h c41672h) {
        AppMethodBeat.m2504i(82608);
        Bitmap decodeSampleBitmapFromAssets = BitmapUtils.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), "raw/guide_line.png", 1);
        c41672h.texture[0] = C41106g.m71543at(decodeSampleBitmapFromAssets);
        c41672h.width = decodeSampleBitmapFromAssets.getWidth();
        c41672h.height = decodeSampleBitmapFromAssets.getHeight();
        AppMethodBeat.m2505o(82608);
    }

    public void setxOffset(float f) {
        this.xOffset = -f;
    }

    private void updatePosition() {
        AppMethodBeat.m2504i(82609);
        float f = this.xOffset - 0.16f;
        float f2 = this.xOffset + 0.16f;
        setPositions(new float[]{f, -1.0f, f, 1.0f, f2, 1.0f, f2, -1.0f});
        AppMethodBeat.m2505o(82609);
    }

    public void RenderProcess(int i, int i2, int i3, int i4, double d, C41672h c41672h) {
        AppMethodBeat.m2504i(82610);
        if (this.xOffset >= 0.0f || this.xOffset <= -1.0f) {
            AppMethodBeat.m2505o(82610);
            return;
        }
        updatePosition();
        GlUtil.setBlendMode(true);
        super.RenderProcess(i, i2, i3, i4, d, c41672h);
        GlUtil.setBlendMode(false);
        AppMethodBeat.m2505o(82610);
    }
}
