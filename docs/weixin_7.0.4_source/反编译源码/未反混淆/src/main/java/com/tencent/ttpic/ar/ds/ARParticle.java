package com.tencent.ttpic.ar.ds;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.Point3D;

public class ARParticle {
    public Point3D center = new Point3D();
    public float height;
    public Point3D leftBottom = new Point3D();
    public Point3D leftTop = new Point3D();
    public Point3D rightBottom = new Point3D();
    public Point3D rightTop = new Point3D();
    public float width;

    public ARParticle() {
        AppMethodBeat.i(81648);
        AppMethodBeat.o(81648);
    }
}
