package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.List;

public class CustomEffectVideoFilter extends VideoEffectFilterBase {
    private static final String TAG = CustomVideoFilter.class.getSimpleName();
    private List<String> mResourceList;

    static {
        AppMethodBeat.i(82137);
        AppMethodBeat.o(82137);
    }

    public CustomEffectVideoFilter(String str, String str2, List<String> list, String str3, VideoFilterEffect videoFilterEffect) {
        super(str, str2, videoFilterEffect);
        AppMethodBeat.i(82135);
        this.dataPath = str3;
        this.mResourceList = list;
        initInputImageTexture();
        AppMethodBeat.o(82135);
    }

    public void initInputImageTexture() {
        AppMethodBeat.i(82136);
        if (BaseUtils.isEmpty(this.mResourceList)) {
            AppMethodBeat.o(82136);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mResourceList.size()) {
                Bitmap decodeSampledBitmapFromAssets;
                String str = this.dataPath + File.separator + ((String) this.mResourceList.get(i2));
                if (str.startsWith("assets://")) {
                    decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(str), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
                } else {
                    decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromFile(str, MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
                }
                if (BitmapUtils.isLegal(decodeSampledBitmapFromAssets)) {
                    addParam(new k("inputImageTexture" + (i2 + 2), decodeSampledBitmapFromAssets, 33986 + i2, true));
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(82136);
                return;
            }
        }
    }
}
