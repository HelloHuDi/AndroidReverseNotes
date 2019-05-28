package com.tencent.ttpic.factory;

import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;

public class FabbyFilterFactory {

    public enum FILTER_MODEL {
        WU("cameftOrigin", d.MIC_PTU_WU, 0),
        ZIRAN("cameftNature", d.MIC_PTU_ZIRAN, 0),
        ZIPAI_GRADIENT_LIPNEW("cameftCherry", d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW, 0),
        ZIPAI_FAIRYTALE("cameftFairytale", d.MIC_PTU_ZIPAI_FAIRYTALE, 0),
        XINYE("cameftXinye", 285, 0),
        QIANGWEI("cameftQiangwei", 283, 0),
        TANGGUOMEIGUI("cameftTangguomeigui", 286, 0),
        SHUILIAN("cameftShuilian", d.MIC_PTU_SHUILIAN, 0),
        FENHONGBAO("cameftFenhongbao", 295, 0),
        AMARO("cameftQingyi", 5, 0),
        FBBS_NUANYANG("cameftNuanyang", 292, 6),
        YOUJIALI("cameftYoujiali", d.MIC_PTU_YOUJIALI, 0),
        MIC_PTU_YOUJIALI("cameftShengdai", d.MIC_PTU_ZIPAI_LIGHTWHITE, 0),
        MIC_PTU_ZIPAI_LIGHTRED("cameftYinghong", d.MIC_PTU_ZIPAI_LIGHTRED, 0),
        MIC_PTU_FBBS_LANGMAN("cameftRomantic", 293, 4),
        MIC_PTU_ZIPAI_OKINAWA("cameftFenbi", d.MIC_PTU_ZIPAI_OKINAWA, 0),
        MIC_PTU_ZIPAI_TIANMEI("cameftTianmei", 272, 0),
        MIC_PTU_FEN2("cameftFennen", 215, 0),
        MIC_PTU_ZIPAI_LIGHTGREEN("cameftTianbohe", 252, 0),
        MIC_PTU_ZIPAI_MAPLERED("cameftMoscow", 273, 0),
        MIC_PTU_ZIPAI_RICHRED("cameftSeoul", 244, 0),
        MIC_PTU_ZIPAI_OCEAN("cameftOkinawa", 255, 0),
        MIC_PTU_ZIPAI_YOUNG("cameftShowa", 256, 0),
        MIC_PTU_ZIPAI_TOKYO("cameftTokyo", d.MIC_PTU_ZIPAI_TOKYO, 0),
        MIC_PTU_ZIPAI_SAPPORO("cameftSapporo", d.MIC_PTU_ZIPAI_SAPPORO, 0),
        MIC_PTU_ZIPAI_RICHBLUE("cameftMediterranean", 249, 0),
        MIC_PTU_ZIPAI_RICHYELLOW("cameftFlorence", 250, 0),
        MIC_PTU_ZIPAI_TEAMILK("cameftNaicha", 270, 0),
        WEICO_FILM("cameftDanya", 12, 0),
        MIC_PTU_ZIPAI_BLACKWHITEZIPAI("cameftHeibai", d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI, 0),
        MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM("cameftMenghuan", d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM, 0),
        MIC_PTU_ZIPAI_GRADIENT_FASHION("cameftShishang", d.MIC_PTU_ZIPAI_GRADIENT_FASHION, 0),
        MIC_PTU_ZIPAI_LIGHT("cameftBaicha", 271, 0),
        CUOJUE_2("cameftCuojue2", 1000, 0),
        DISTORTION("cameftNiuqu", 1001, 0);
        
        public final int effectIndex;
        public final int filterId;
        public final String name;

        static {
            AppMethodBeat.o(81918);
        }

        private FILTER_MODEL(String str, int i, int i2) {
            this.name = str;
            this.filterId = i;
            this.effectIndex = i2;
        }
    }

    public static BaseFilter createFilter(String str) {
        BaseFilter baseFilter = null;
        AppMethodBeat.i(81919);
        if (str == null) {
            AppMethodBeat.o(81919);
        } else {
            for (FILTER_MODEL filter_model : FILTER_MODEL.values()) {
                if (filter_model.name.equals(str)) {
                    baseFilter = TTPicFilterFactoryLocal.creatFilterById(filter_model.filterId);
                    if (baseFilter != null) {
                        baseFilter.setEffectIndex(filter_model.effectIndex);
                    }
                }
            }
            AppMethodBeat.o(81919);
        }
        return baseFilter;
    }
}
