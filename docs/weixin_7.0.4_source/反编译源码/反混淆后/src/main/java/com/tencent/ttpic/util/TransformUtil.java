package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import java.util.ArrayList;
import java.util.List;

public class TransformUtil {
    public static List<PointF> getFullPoints(List<PointF> list) {
        AppMethodBeat.m2504i(83977);
        if (list == null || list.size() < 90) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(83977);
            return arrayList;
        }
        while (list.size() > 90) {
            list.remove(list.size() - 1);
        }
        list.add(new PointF((((PointF) list.get(58)).x + ((PointF) list.get(57)).x) * 0.5f, (((PointF) list.get(58)).y + ((PointF) list.get(57)).y) * 0.5f));
        list.add(new PointF((((PointF) list.get(61)).x + ((PointF) list.get(60)).x) * 0.5f, (((PointF) list.get(61)).y + ((PointF) list.get(60)).y) * 0.5f));
        list.add(new PointF((((PointF) list.get(57)).x + (((PointF) list.get(2)).x + ((PointF) list.get(3)).x)) / 3.0f, (((PointF) list.get(57)).y + (((PointF) list.get(2)).y + ((PointF) list.get(3)).y)) / 3.0f));
        list.add(new PointF((((PointF) list.get(61)).x + (((PointF) list.get(16)).x + ((PointF) list.get(15)).x)) / 3.0f, (((PointF) list.get(61)).y + (((PointF) list.get(16)).y + ((PointF) list.get(15)).y)) / 3.0f));
        list.add(new PointF((((PointF) list.get(81)).x + ((PointF) list.get(73)).x) / 2.0f, (((PointF) list.get(81)).y + ((PointF) list.get(73)).y) / 2.0f));
        AppMethodBeat.m2505o(83977);
        return list;
    }

    public static boolean isTransformMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(83978);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(83978);
            return false;
        } else if (videoMaterial.getShaderType() == SHADER_TYPE.TRANSFORM.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_OFF_TRANSFORM.value) {
            AppMethodBeat.m2505o(83978);
            return true;
        } else {
            AppMethodBeat.m2505o(83978);
            return false;
        }
    }
}
