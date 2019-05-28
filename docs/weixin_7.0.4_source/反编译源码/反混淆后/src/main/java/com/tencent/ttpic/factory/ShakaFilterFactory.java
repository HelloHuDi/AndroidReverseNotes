package com.tencent.ttpic.factory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.HorizontalSkewFilter;
import com.tencent.ttpic.filter.ShakaFilterBase;
import com.tencent.ttpic.filter.ShakaFlipFilter;
import com.tencent.ttpic.filter.ShakaNineTileFilter;
import com.tencent.ttpic.filter.ShakaOffsetAlphaBlendFilter;
import com.tencent.ttpic.filter.ShakaTripleFadeTransformFilter;
import com.tencent.ttpic.filter.ShakaUpDownFilter;

public class ShakaFilterFactory {

    public enum FILTER_TYPE {
        TRIPLE_FADE_TRANSFORM(1),
        OFFSET_ALPHA_BLEND(2),
        NINE_TILE(3),
        FLIP(4),
        UP_DOWN(5),
        DISTORTION(6);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(81922);
        }

        private FILTER_TYPE(int i) {
            this.value = i;
        }
    }

    public static ShakaFilterBase create(int i) {
        AppMethodBeat.m2504i(81923);
        ShakaFilterBase shakaOffsetAlphaBlendFilter;
        if (i == FILTER_TYPE.TRIPLE_FADE_TRANSFORM.value) {
            ShakaTripleFadeTransformFilter shakaTripleFadeTransformFilter = new ShakaTripleFadeTransformFilter();
            AppMethodBeat.m2505o(81923);
            return shakaTripleFadeTransformFilter;
        } else if (i == FILTER_TYPE.OFFSET_ALPHA_BLEND.value) {
            shakaOffsetAlphaBlendFilter = new ShakaOffsetAlphaBlendFilter();
            AppMethodBeat.m2505o(81923);
            return shakaOffsetAlphaBlendFilter;
        } else if (i == FILTER_TYPE.NINE_TILE.value) {
            shakaOffsetAlphaBlendFilter = new ShakaNineTileFilter();
            AppMethodBeat.m2505o(81923);
            return shakaOffsetAlphaBlendFilter;
        } else if (i == FILTER_TYPE.FLIP.value) {
            shakaOffsetAlphaBlendFilter = new ShakaFlipFilter();
            AppMethodBeat.m2505o(81923);
            return shakaOffsetAlphaBlendFilter;
        } else if (i == FILTER_TYPE.UP_DOWN.value) {
            shakaOffsetAlphaBlendFilter = new ShakaUpDownFilter();
            AppMethodBeat.m2505o(81923);
            return shakaOffsetAlphaBlendFilter;
        } else if (i == FILTER_TYPE.DISTORTION.value) {
            shakaOffsetAlphaBlendFilter = new HorizontalSkewFilter();
            AppMethodBeat.m2505o(81923);
            return shakaOffsetAlphaBlendFilter;
        } else {
            AppMethodBeat.m2505o(81923);
            return null;
        }
    }
}
