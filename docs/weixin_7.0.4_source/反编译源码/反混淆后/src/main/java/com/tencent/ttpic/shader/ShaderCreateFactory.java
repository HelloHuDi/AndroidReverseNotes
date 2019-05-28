package com.tencent.ttpic.shader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class ShaderCreateFactory {
    private static final String FRAGMENT_SHADER_ETC_FILE = (VideoModule.es_GL_EXT_shader_framebuffer_fetch ? "MCCommonFragmentShaderETCExt.dat" : "MCCommonFragmentShaderETC.dat");
    private static final String FRAGMENT_SHADER_IMAGE_FILE = (VideoModule.es_GL_EXT_shader_framebuffer_fetch ? "MCCommonFragmentShaderImageExt.dat" : "MCCommonFragmentShaderImage.dat");
    private static final String FRAGMENT_SHADER_VIDEO_FILE = (VideoModule.es_GL_EXT_shader_framebuffer_fetch ? "MCCommonFragmentShaderVideoExt.dat" : "MCCommonFragmentShaderVideo.dat");
    private static final String SHADER_DIR = "camera/camera_video/shader/";

    public enum PROGRAM_TYPE {
        STICKER_NORMAL("MCCommonVertexShader.dat", ShaderCreateFactory.FRAGMENT_SHADER_IMAGE_FILE),
        STICKER_UP_DOWN("MCCommonUDVertexShader.dat", ShaderCreateFactory.FRAGMENT_SHADER_VIDEO_FILE),
        STICKER_LEFT_RIGHT("MCCommonLRVertexShader.dat", ShaderCreateFactory.FRAGMENT_SHADER_VIDEO_FILE),
        STICKER_ETC("MCCommonVertexShader.dat", ShaderCreateFactory.FRAGMENT_SHADER_ETC_FILE),
        FAST_STICKER("FastRenderVertexShader.dat", "FastRenderFragmentShader.dat"),
        TRANSFORM("TransformVertexShader.dat", "TransformFragmentShader.dat"),
        FACEOFF("FaceOffVertexShader.dat", "FaceOffFragmentShader.dat"),
        CFFACEOFF("CFFaceOffVertexShader.dat", "CFFaceOffFragmentShader.dat"),
        SNAKE_FACE("SnakeFaceVertexShader.dat", "SimpleFragmentShader.dat"),
        DOODLE("DoodleVertexShader.dat", "DoodleFragmentShader.dat"),
        FACE_CROP("FaceCropVertexShader.dat", "FaceCropFragmentShader.dat"),
        HEAD_CROP("HeadCropVertexShader.dat", "HeadCropFragmentShader.dat"),
        LOOKUP("LookupVertexShader.dat", "LookupFragmentShader.dat"),
        ROTATE_SCALE("RotateScaleVertexShader.dat", "RotateScaleFragmentShader.dat"),
        SHAKA_TRIPLE_FACE_TRANSFORM("SimpleVertexShader.dat", "TripleFadeTransformFragmentShader.dat"),
        SHAKA_OFFSET_ALPHA_BLEND("SimpleVertexShader.dat", "OffsetAlphaBlendFragmentShader.dat"),
        SHAKA_NINE_TILE("SimpleVertexShader.dat", "NineTileFragmentShader.dat"),
        SHAKA_FLIP("SimpleVertexShader.dat", "FlipFragmentShader.dat"),
        SHAKA_UP_DOWN("SimpleVertexShader.dat", "UpDownFragmentShader.dat"),
        SHAKA_HORIZONTAL_SKEW("SimpleVertexShader.dat", "HorizontalSkewFragmentShader.dat"),
        EMOJI("EmojiVertexShader.dat", "EmojiFragmentShader.dat"),
        GIF_FRAME("GifFrameVertexShader.dat", "EmojiFragmentShader.dat");
        
        public final String fragmentShaderFile;
        public final String vertexShaderFile;

        static {
            AppMethodBeat.m2505o(83731);
        }

        private PROGRAM_TYPE(String str, String str2) {
            this.vertexShaderFile = str;
            this.fragmentShaderFile = str2;
        }
    }

    public static Shader createShader(PROGRAM_TYPE program_type) {
        AppMethodBeat.m2504i(83732);
        if (program_type == null) {
            AppMethodBeat.m2505o(83732);
            return null;
        }
        Shader shader = new Shader(FileUtils.loadAssetsString(VideoGlobalContext.getContext(), new StringBuilder(SHADER_DIR).append(program_type.vertexShaderFile).toString()), FileUtils.loadAssetsString(VideoGlobalContext.getContext(), new StringBuilder(SHADER_DIR).append(program_type.fragmentShaderFile).toString()));
        AppMethodBeat.m2505o(83732);
        return shader;
    }
}
