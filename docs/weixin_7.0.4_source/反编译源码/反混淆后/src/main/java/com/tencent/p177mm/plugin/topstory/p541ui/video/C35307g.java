package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.content.Context;
import com.tencent.p177mm.plugin.sight.decode.p512ui.AdVideoPlayerLoadingBar;
import com.tencent.p177mm.plugin.websearch.p1066ui.WebSearchVideoPlayerSeekBar;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.g */
public abstract class C35307g extends WebSearchVideoPlayerSeekBar {
    public abstract void hide();

    public abstract void show();

    public C35307g(Context context) {
        super(context);
    }

    public void setCurrentPlaySecond(int i) {
        this.mPosition = i;
        this.qyp.setText(AdVideoPlayerLoadingBar.m33392oy(i / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(i % 60));
        mo41766In(mo41765Im(i));
    }
}
