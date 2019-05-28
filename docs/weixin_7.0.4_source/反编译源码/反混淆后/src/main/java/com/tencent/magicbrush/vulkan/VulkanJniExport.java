package com.tencent.magicbrush.vulkan;

import com.tencent.magicbrush.p1173a.C45128b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VulkanJniExport {
    public static native boolean isSupportVulkan();

    static {
        AppMethodBeat.m2504i(116016);
        C45128b.loadLibrary("mmvulkan");
        AppMethodBeat.m2505o(116016);
    }
}
