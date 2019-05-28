package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.filter.DynamicNumFilter;
import com.tencent.ttpic.filter.DynamicStickerFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.StaticNumFilter;
import com.tencent.ttpic.filter.StaticStickerFilter;
import com.tencent.ttpic.filter.WatermarkDynamicFilter;
import com.tencent.ttpic.filter.WatermarkStaticFilter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;

public class VideoFilterFactory {
    public static final String FRAGMENT_SHADER_IMAGE = (VideoModule.es_GL_EXT_shader_framebuffer_fetch ? FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShaderImageExt.dat") : FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShaderImage.dat"));
    public static final String FRAGMENT_SHADER_MASK = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/OrigFragmentShader.dat");
    public static final String LEFT_RIGHT_VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonLRVertexShader.dat");
    public static final String UP_DOWN_VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonUDVertexShader.dat");
    public static final String VERTEX_SHADER_COMMON = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonVertexShader.dat");

    public enum POSITION_TYPE {
        STATIC(1),
        DYNAMIC(2),
        RELATIVE(3),
        GESTURE(4),
        BODY(5);
        
        public final int type;

        static {
            AppMethodBeat.o(83981);
        }

        private POSITION_TYPE(int i) {
            this.type = i;
        }
    }

    public enum STICKER_TYPE {
        NORMAL(0),
        WATERMARK(1),
        VIDEO_UP_DOWN(3),
        VIDEO_LEFT_RIGHT(4),
        FACE_FEATURE(5),
        ETC(6);
        
        public final int type;

        static {
            AppMethodBeat.o(83984);
        }

        private STICKER_TYPE(int i) {
            this.type = i;
        }
    }

    static {
        AppMethodBeat.i(83986);
        AppMethodBeat.o(83986);
    }

    public static NormalVideoFilter createFilter(StickerItem stickerItem, String str) {
        AppMethodBeat.i(83985);
        if (stickerItem == null) {
            AppMethodBeat.o(83985);
            return null;
        }
        NormalVideoFilter watermarkStaticFilter;
        if (stickerItem.markMode == 0) {
            if (stickerItem.stickerType != STICKER_TYPE.NORMAL.type && stickerItem.stickerType != STICKER_TYPE.VIDEO_LEFT_RIGHT.type && stickerItem.stickerType != STICKER_TYPE.VIDEO_UP_DOWN.type && stickerItem.stickerType != STICKER_TYPE.FACE_FEATURE.type && stickerItem.stickerType != STICKER_TYPE.ETC.type) {
                if (stickerItem.stickerType == STICKER_TYPE.WATERMARK.type && stickerItem.transition == null) {
                    if (stickerItem.type == POSITION_TYPE.STATIC.type || stickerItem.type == POSITION_TYPE.RELATIVE.type) {
                        watermarkStaticFilter = new WatermarkStaticFilter(stickerItem, str);
                    } else if (stickerItem.type == POSITION_TYPE.DYNAMIC.type || stickerItem.type == POSITION_TYPE.GESTURE.type) {
                        watermarkStaticFilter = new WatermarkDynamicFilter(stickerItem, str);
                    }
                }
                watermarkStaticFilter = null;
            } else if (stickerItem.type == POSITION_TYPE.STATIC.type || stickerItem.type == POSITION_TYPE.RELATIVE.type) {
                watermarkStaticFilter = new StaticStickerFilter(stickerItem, str);
            } else {
                if (stickerItem.type == POSITION_TYPE.DYNAMIC.type || stickerItem.type == POSITION_TYPE.GESTURE.type || stickerItem.type == POSITION_TYPE.BODY.type) {
                    watermarkStaticFilter = new DynamicStickerFilter(stickerItem, str);
                }
                watermarkStaticFilter = null;
            }
        } else if (stickerItem.type == POSITION_TYPE.STATIC.type) {
            watermarkStaticFilter = new StaticNumFilter(stickerItem, str);
        } else {
            if (stickerItem.type == POSITION_TYPE.DYNAMIC.type) {
                watermarkStaticFilter = new DynamicNumFilter(stickerItem, str);
            }
            watermarkStaticFilter = null;
        }
        if (watermarkStaticFilter == null) {
            AppMethodBeat.o(83985);
            return null;
        }
        if (stickerItem.sourceType == ITEM_SOURCE_TYPE.VIDEO_UP_DOWN) {
            watermarkStaticFilter.updateFilterShader(PROGRAM_TYPE.STICKER_UP_DOWN);
        } else if (stickerItem.sourceType == ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT) {
            watermarkStaticFilter.updateFilterShader(PROGRAM_TYPE.STICKER_LEFT_RIGHT);
        }
        if (stickerItem.stickerType == STICKER_TYPE.ETC.type) {
            watermarkStaticFilter.updateFilterShader(PROGRAM_TYPE.STICKER_ETC);
        }
        AppMethodBeat.o(83985);
        return watermarkStaticFilter;
    }
}
