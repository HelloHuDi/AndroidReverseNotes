package com.tencent.ttpic.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.face.Face;
import com.tencent.ttpic.model.VideoFilterEffect;
import java.util.List;

public class VideoEffectFilterBase extends VideoFilterBase {
    private static final String TAG = VideoEffectFilterBase.class.getSimpleName();
    protected VideoFilterEffect mVideoFilterEffect;

    static {
        AppMethodBeat.i(83074);
        AppMethodBeat.o(83074);
    }

    public VideoEffectFilterBase(String str, String str2, VideoFilterEffect videoFilterEffect) {
        super(str, str2);
        this.mVideoFilterEffect = videoFilterEffect;
    }

    public void initParams() {
    }

    public void initAttribParams() {
        AppMethodBeat.i(83072);
        super.initAttribParams();
        setTexCords(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f});
        AppMethodBeat.o(83072);
    }

    public boolean shouldRender(int i, int i2, List<Face> list) {
        AppMethodBeat.i(83073);
        if (i == -1 || i2 == 0 || list == null || list.isEmpty()) {
            AppMethodBeat.o(83073);
            return true;
        } else if (this.mVideoFilterEffect == null) {
            AppMethodBeat.o(83073);
            return false;
        } else {
            switch (this.mVideoFilterEffect.order) {
                case 1:
                    if (i == ((Face) list.get(0)).faceIndex) {
                        AppMethodBeat.o(83073);
                        return true;
                    }
                    AppMethodBeat.o(83073);
                    return false;
                case 2:
                    if (i == ((Face) list.get(list.size() - 1)).faceIndex) {
                        AppMethodBeat.o(83073);
                        return true;
                    }
                    AppMethodBeat.o(83073);
                    return false;
                default:
                    AppMethodBeat.o(83073);
                    return false;
            }
        }
    }
}
