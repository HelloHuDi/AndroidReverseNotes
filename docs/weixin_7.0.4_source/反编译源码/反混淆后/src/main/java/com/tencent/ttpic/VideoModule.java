package com.tencent.ttpic;

import android.content.Context;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.util.GpuInfoUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.YTFaceDetectorBase;
import java.util.HashSet;
import java.util.Set;

public class VideoModule {
    public static final String[] GPU_GL_ONE_THREAD = new String[]{"PowerVR SGX 544MP", "Adreno (TM) 306"};
    public static String PTU_VERSION = "5.5";
    public static final int RENDER_MODE = 1;
    public static final int RENDER_MODE_GLFINISH = 0;
    public static final int RENDER_MODE_GLFLUSH = 1;
    public static String SDK_VERSION = "1.8";
    public static Set<String> blackList = new HashSet();
    private static DeviceType deviceType;
    private static boolean enableEXTShaderFramebufferFetch;
    public static boolean es_GL_EXT_shader_framebuffer_fetch;

    public enum DeviceType {
        HIGH,
        MIDDLE,
        LOW,
        VERY_LOW;

        static {
            AppMethodBeat.m2505o(81641);
        }
    }

    static {
        AppMethodBeat.m2504i(81647);
        AppMethodBeat.m2505o(81647);
    }

    public static void setDeviceType(DeviceType deviceType) {
        deviceType = deviceType;
    }

    public static DeviceType getDeviceType() {
        return deviceType;
    }

    public static void setEnableEXTShaderFramebufferFetch(boolean z) {
        enableEXTShaderFramebufferFetch = z;
    }

    public static boolean isEnableEXTShaderFramebufferFetch() {
        return enableEXTShaderFramebufferFetch;
    }

    public static void init(Context context, String str, String str2, String str3) {
        AppMethodBeat.m2504i(81642);
        VideoGlobalContext.setContext(context);
        VideoPrefsUtil.init(context);
        TTPicFilterFactoryLocal.LUT_DIR_ROOT = str;
        YTFaceDetectorBase.YT_MODEL_DIR = str2;
        YTFaceDetectorBase.YT_MODEL_DIR_BACKUP = str3;
        AppMethodBeat.m2505o(81642);
    }

    private static void initBlackList() {
        AppMethodBeat.m2504i(81643);
        blackList.add("OPPO_OPPO_R11_Plus");
        blackList.add("VIVO_vivo_X6S_A");
        blackList.add("SAMSUNG_SM-G9500");
        blackList.add("VIVO_vivo_X20A");
        AppMethodBeat.m2505o(81643);
    }

    private static boolean isInBlackList(String str) {
        AppMethodBeat.m2504i(81644);
        boolean contains = blackList.contains(str);
        AppMethodBeat.m2505o(81644);
        return contains;
    }

    public static void initExtensionValues() {
        boolean z = true;
        AppMethodBeat.m2504i(81645);
        for (String equals : GLES20.glGetString(7939).split("\\s")) {
            if (equals.equals("GL_EXT_shader_framebuffer_fetch")) {
                es_GL_EXT_shader_framebuffer_fetch = true;
            }
        }
        if (!(es_GL_EXT_shader_framebuffer_fetch && enableEXTShaderFramebufferFetch)) {
            z = false;
        }
        es_GL_EXT_shader_framebuffer_fetch = z;
        AppMethodBeat.m2505o(81645);
    }

    public static boolean isInOneGLThreadBlackList() {
        AppMethodBeat.m2504i(81646);
        String[] split = GpuInfoUtil.getGPUInfo().split(";");
        if (split.length > 0 && !TextUtils.isEmpty(split[0])) {
            String toLowerCase = split[0].trim().toLowerCase();
            for (String toLowerCase2 : GPU_GL_ONE_THREAD) {
                if (toLowerCase.equals(toLowerCase2.toLowerCase())) {
                    AppMethodBeat.m2505o(81646);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(81646);
        return false;
    }

    public static int getVersionCode() {
        return 480;
    }
}
