package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar;
import com.tencent.ttpic.util.VideoMaterialUtil;

public abstract class g extends WebSearchVideoPlayerSeekBar {
    public abstract void hide();

    public abstract void show();

    public g(Context context) {
        super(context);
    }

    public void setCurrentPlaySecond(int i) {
        this.mPosition = i;
        this.qyp.setText(AdVideoPlayerLoadingBar.oy(i / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.oy(i % 60));
        In(Im(i));
    }
}
