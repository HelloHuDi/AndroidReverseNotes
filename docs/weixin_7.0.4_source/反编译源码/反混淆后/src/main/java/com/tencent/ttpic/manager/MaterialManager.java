package com.tencent.ttpic.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.VideoMaterial;

public enum MaterialManager {
    INSTANCE;
    
    private VideoMaterial material;

    static {
        AppMethodBeat.m2505o(83436);
    }

    public static MaterialManager getInstance() {
        return INSTANCE;
    }

    public final VideoMaterial getCurrentMaterial() {
        return this.material;
    }

    public final void setCurrentMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(83435);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(83435);
            return;
        }
        if (!(this.material == null || this.material.getId() == null)) {
            if (this.material.getId().equals(videoMaterial.getId())) {
                RandomGroupManager.getInstance().clearCurValue();
            } else {
                RandomGroupManager.getInstance().clearAll();
            }
        }
        this.material = videoMaterial;
        AppMethodBeat.m2505o(83435);
    }
}
