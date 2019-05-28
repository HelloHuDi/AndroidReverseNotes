package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SimpleEffectVideoFilter extends VideoFilterBase {
    public static final String LOOKUP_TABLE_FILE_NAME = "filterEffect.lut";
    private String mDataPath;

    public SimpleEffectVideoFilter(String str) {
        super(PROGRAM_TYPE.LOOKUP);
        AppMethodBeat.m2504i(82855);
        this.mDataPath = str;
        initParams();
        AppMethodBeat.m2505o(82855);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82856);
        addParam(new C25628k("inputImageTexture2", getBitmap(this.mDataPath + "/filterEffect.lut"), 33986, true));
        AppMethodBeat.m2505o(82856);
    }

    public static Bitmap getBitmap(String str) {
        Bitmap decodeSampledBitmapFromFile;
        AppMethodBeat.m2504i(82857);
        if (TextUtils.isEmpty(str) || !str.startsWith("assets://")) {
            decodeSampledBitmapFromFile = BitmapUtils.decodeSampledBitmapFromFile(str, BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        } else {
            decodeSampledBitmapFromFile = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(str), BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        }
        if (BitmapUtils.isLegal(decodeSampledBitmapFromFile)) {
            AppMethodBeat.m2505o(82857);
            return decodeSampledBitmapFromFile;
        }
        AppMethodBeat.m2505o(82857);
        return null;
    }
}
