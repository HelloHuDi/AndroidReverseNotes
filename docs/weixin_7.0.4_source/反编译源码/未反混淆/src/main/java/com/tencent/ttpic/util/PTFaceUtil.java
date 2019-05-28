package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.PTFaceAttr.PTFace;
import com.tencent.ttpic.baseutils.BaseUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PTFaceUtil {
    public static Set<Integer> getTriggeredExpression(Map<PTExpression, Boolean> map) {
        AppMethodBeat.i(83938);
        HashSet hashSet = new HashSet();
        if (map == null) {
            AppMethodBeat.o(83938);
            return hashSet;
        }
        for (Entry entry : map.entrySet()) {
            if (((Boolean) entry.getValue()).booleanValue()) {
                hashSet.add(Integer.valueOf(((PTExpression) entry.getKey()).value));
            }
        }
        AppMethodBeat.o(83938);
        return hashSet;
    }

    public static List<List<PointF>> getAllFaces(List<PTFace> list) {
        AppMethodBeat.i(83939);
        ArrayList arrayList = new ArrayList();
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(83939);
            return arrayList;
        }
        for (PTFace facePoints : list) {
            arrayList.add(facePoints.getFacePoints());
        }
        AppMethodBeat.o(83939);
        return arrayList;
    }

    public static List<float[]> getAllFaceAngles(List<PTFace> list) {
        AppMethodBeat.i(83940);
        ArrayList arrayList = new ArrayList();
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(83940);
            return arrayList;
        }
        for (PTFace faceAngle : list) {
            arrayList.add(faceAngle.getFaceAngle());
        }
        AppMethodBeat.o(83940);
        return arrayList;
    }
}
