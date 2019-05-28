package com.tencent.magicbrush.vulkan;

import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VulkanJniExport {
    public static native boolean isSupportVulkan();

    static {
        AppMethodBeat.i(116016);
        b.loadLibrary("mmvulkan");
        AppMethodBeat.o(116016);
    }
}
