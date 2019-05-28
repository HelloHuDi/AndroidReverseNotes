package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DistortionItem implements Cloneable {
    public int direction;
    public int distortion;
    public int position;
    public float radius;
    public float strength;
    public int targetDx = 0;
    public int targetDy = 0;
    public int x;
    public int y;

    public DistortionItem clone() {
        DistortionItem distortionItem;
        AppMethodBeat.i(83479);
        DistortionItem distortionItem2 = new DistortionItem();
        try {
            Object clone = super.clone();
            if (clone instanceof DistortionItem) {
                distortionItem = (DistortionItem) clone;
                AppMethodBeat.o(83479);
                return distortionItem;
            }
        } catch (CloneNotSupportedException e) {
        }
        distortionItem = distortionItem2;
        AppMethodBeat.o(83479);
        return distortionItem;
    }
}
