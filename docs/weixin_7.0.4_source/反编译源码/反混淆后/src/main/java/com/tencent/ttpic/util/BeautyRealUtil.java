package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.config.BeautyRealConfig;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.filter.BeautyParam;
import com.tencent.ttpic.model.DistortParam;
import com.tencent.ttpic.model.DistortionItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BeautyRealUtil {
    public static final BeautyParam EMPTY_PARAM = new BeautyParam(false);

    static {
        AppMethodBeat.m2504i(83808);
        AppMethodBeat.m2505o(83808);
    }

    public static DistortParam getDistortParam(DistortParam distortParam, int i, int i2) {
        AppMethodBeat.m2504i(83805);
        DistortParam distortParam2 = new DistortParam();
        if (distortParam == null) {
            AppMethodBeat.m2505o(83805);
            return distortParam2;
        }
        ArrayList arrayList = new ArrayList();
        float f = ((float) i) / 100.0f;
        for (DistortionItem clone : distortParam.getItems()) {
            DistortionItem clone2 = clone2.clone();
            if (i2 != TYPE.CHIN.value) {
                clone2.strength *= f;
            } else if (i < 0) {
                clone2.strength *= -f;
                clone2.direction = 2;
            } else {
                clone2.strength *= f;
                clone2.direction = 4;
            }
            arrayList.add(clone2);
        }
        distortParam2.setLevel(i);
        distortParam2.setItems(arrayList);
        AppMethodBeat.m2505o(83805);
        return distortParam2;
    }

    public static boolean isCombinedType(int i) {
        for (TYPE type : BeautyRealConfig.COMBINED_TYPE) {
            if (type.value == i) {
                return true;
            }
        }
        return false;
    }

    public static Map<TYPE, Integer> getBeautyLevels(int i, boolean z) {
        AppMethodBeat.m2504i(83806);
        HashMap hashMap = new HashMap();
        hashMap.put(TYPE.BEAUTY, Integer.valueOf(60));
        if (i == TYPE.NONE.value) {
            if (z) {
                hashMap.put(TYPE.BEAUTY, Integer.valueOf(0));
                hashMap.put(TYPE.BASIC3, Integer.valueOf(0));
            } else {
                hashMap.put(TYPE.BEAUTY, Integer.valueOf(50));
                hashMap.put(TYPE.BASIC3, Integer.valueOf(65));
            }
            for (Object put : BeautyRealConfig.SINGLE_TRANS_TYPE_574) {
                hashMap.put(put, Integer.valueOf(0));
            }
        } else if (i == TYPE.NATURE.value) {
            hashMap.put(TYPE.FACE_SHORTEN, Integer.valueOf(20));
            hashMap.put(TYPE.FACE_V, Integer.valueOf(40));
            hashMap.put(TYPE.FACE_THIN, Integer.valueOf(40));
            hashMap.put(TYPE.EYE, Integer.valueOf(50));
        } else if (i == TYPE.CUTE.value) {
            hashMap.put(TYPE.FACE_SHORTEN, Integer.valueOf(80));
            hashMap.put(TYPE.CHIN, Integer.valueOf(-20));
            hashMap.put(TYPE.FACE_V, Integer.valueOf(50));
            hashMap.put(TYPE.EYE, Integer.valueOf(100));
            hashMap.put(TYPE.NOSE, Integer.valueOf(40));
        } else if (i == TYPE.MELON.value) {
            hashMap.put(TYPE.CHIN, Integer.valueOf(10));
            hashMap.put(TYPE.FACE_V, Integer.valueOf(80));
            hashMap.put(TYPE.FACE_THIN, Integer.valueOf(80));
            hashMap.put(TYPE.EYE, Integer.valueOf(60));
            hashMap.put(TYPE.NOSE, Integer.valueOf(40));
        } else {
            TYPE type = TYPE.MELON;
        }
        for (Object put2 : BeautyRealConfig.SINGLE_TRANS_TYPE_574) {
            if (!hashMap.containsKey(put2)) {
                hashMap.put(put2, Integer.valueOf(0));
            }
        }
        AppMethodBeat.m2505o(83806);
        return hashMap;
    }

    public static Map<TYPE, Integer> getBeautyLevels573(int i) {
        AppMethodBeat.m2504i(83807);
        HashMap hashMap = new HashMap();
        hashMap.put(TYPE.BEAUTY, Integer.valueOf(60));
        if (i == TYPE.NONE.value) {
            hashMap.put(TYPE.BEAUTY, Integer.valueOf(0));
            for (Object put : BeautyRealConfig.SINGLE_TRANS_TYPE_573) {
                hashMap.put(put, Integer.valueOf(0));
            }
            hashMap.put(TYPE.EYE_LIGHTEN, Integer.valueOf(0));
            hashMap.put(TYPE.REMOVE_POUNCH, Integer.valueOf(0));
        } else if (i == TYPE.NATURE.value) {
            hashMap.put(TYPE.FACE_SHORTEN, Integer.valueOf(20));
            hashMap.put(TYPE.FACE_V, Integer.valueOf(40));
            hashMap.put(TYPE.FACE_THIN, Integer.valueOf(40));
            hashMap.put(TYPE.EYE, Integer.valueOf(50));
        } else if (i == TYPE.CUTE.value) {
            hashMap.put(TYPE.FACE_SHORTEN, Integer.valueOf(80));
            hashMap.put(TYPE.CHIN, Integer.valueOf(-20));
            hashMap.put(TYPE.FACE_V, Integer.valueOf(50));
            hashMap.put(TYPE.EYE, Integer.valueOf(100));
            hashMap.put(TYPE.NOSE, Integer.valueOf(40));
        } else if (i == TYPE.MELON.value) {
            hashMap.put(TYPE.CHIN, Integer.valueOf(10));
            hashMap.put(TYPE.FACE_V, Integer.valueOf(80));
            hashMap.put(TYPE.FACE_THIN, Integer.valueOf(80));
            hashMap.put(TYPE.EYE, Integer.valueOf(60));
            hashMap.put(TYPE.NOSE, Integer.valueOf(40));
        } else {
            TYPE type = TYPE.MELON;
        }
        for (Object put2 : BeautyRealConfig.SINGLE_TRANS_TYPE_573) {
            if (!hashMap.containsKey(put2)) {
                hashMap.put(put2, Integer.valueOf(0));
            }
        }
        AppMethodBeat.m2505o(83807);
        return hashMap;
    }
}
