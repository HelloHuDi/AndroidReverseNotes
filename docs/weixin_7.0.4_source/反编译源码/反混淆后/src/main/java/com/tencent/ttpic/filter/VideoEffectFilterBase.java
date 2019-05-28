package com.tencent.ttpic.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.face.Face;
import com.tencent.ttpic.model.VideoFilterEffect;
import java.util.List;

public class VideoEffectFilterBase extends VideoFilterBase {
    private static final String TAG = VideoEffectFilterBase.class.getSimpleName();
    protected VideoFilterEffect mVideoFilterEffect;

    static {
        AppMethodBeat.m2504i(83074);
        AppMethodBeat.m2505o(83074);
    }

    public VideoEffectFilterBase(String str, String str2, VideoFilterEffect videoFilterEffect) {
        super(str, str2);
        this.mVideoFilterEffect = videoFilterEffect;
    }

    public void initParams() {
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(83072);
        super.initAttribParams();
        setTexCords(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f});
        AppMethodBeat.m2505o(83072);
    }

    public boolean shouldRender(int i, int i2, List<Face> list) {
        AppMethodBeat.m2504i(83073);
        if (i == -1 || i2 == 0 || list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(83073);
            return true;
        } else if (this.mVideoFilterEffect == null) {
            AppMethodBeat.m2505o(83073);
            return false;
        } else {
            switch (this.mVideoFilterEffect.order) {
                case 1:
                    if (i == ((Face) list.get(0)).faceIndex) {
                        AppMethodBeat.m2505o(83073);
                        return true;
                    }
                    AppMethodBeat.m2505o(83073);
                    return false;
                case 2:
                    if (i == ((Face) list.get(list.size() - 1)).faceIndex) {
                        AppMethodBeat.m2505o(83073);
                        return true;
                    }
                    AppMethodBeat.m2505o(83073);
                    return false;
                default:
                    AppMethodBeat.m2505o(83073);
                    return false;
            }
        }
    }
}
