package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.VideoMaterialMetaData;
import java.util.ArrayList;
import java.util.List;

public class VideoLocalDataInitializer {
    private static String[] LOCAL_MATERIAL_IDS = new String[]{"video_fireburning_db", "video_fengkuangdacall_audio", "video_dangdangdang", "video_jmskull2", "video_mv_gun", "video_yinxingchibang", "video_expression_level1", "video_voice_text_mouth", "video_pikachu", "video_money_1", "video_bubble", "video_mv_comic3", "video_egaoshuangwanzi", "video_newyearlucky_suiji", "video_filters_chazi", "video_filters_hanfeng", "video_filters_hongkong", "video_filters_jiazhou", "video_animalword"};
    public static String[] ONLINE_MATERIAL_IDS = new String[]{"video_3DFace_santaglass", "video_bluecat", "video_huzi_white", "video_nihongshu", "video_Qmaozi", "video_wawaji", "video_nonono", "video_rainbow", "video_mv_fenbimao", "video_baby_agetest", "video_mjdance", "video_astronaut", "video_mv_wing", "video_liuhai", "video_mv_dongwuyuan", "video_handsomeGuy", "video_qixi", "video_guifeiface", "video_huaxianzi", "video_particle_cherryblossom", "video_heart_lips", "video_yinjiuzui", "video_huzi_black", "video_xinniang", "video_xiaobian", "video_mojing_yangyang"};

    public static List<VideoMaterialMetaData> buildVideoMaterials() {
        int i = 0;
        AppMethodBeat.i(84043);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VideoMaterialMetaData(null, "None", null, "assets://none.png"));
        for (Object obj : LOCAL_MATERIAL_IDS) {
            arrayList.add(new VideoMaterialMetaData(obj, "assets://camera/camera_video/CameraVideoAnimal/".concat(String.valueOf(obj)), "", "assets://camera/camera_video/CameraVideoAnimal/" + obj + "/" + obj + ".png"));
        }
        String[] strArr = ONLINE_MATERIAL_IDS;
        int length = strArr.length;
        while (i < length) {
            String str = strArr[i];
            arrayList.add(new VideoMaterialMetaData(str, "", "http://res.tu.qq.com/materials/" + str + "Android.zip", "http://res.tu.qq.com/materials/" + str + ".png"));
            i++;
        }
        arrayList.add(new VideoMaterialMetaData("video_3DFace_fashionglass1", "", "http://st1.xiangji.qq.com/pitu/materials/video_3DFace_fashionglass1Android.zip", "http://st1.xiangji.qq.com/pitu/materials/video_3DFace_fashionglass1.png"));
        AppMethodBeat.o(84043);
        return arrayList;
    }
}
