package com.tencent.ttpic.p683ar.p684ds;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.Point3D;

/* renamed from: com.tencent.ttpic.ar.ds.ARParticle */
public class ARParticle {
    public Point3D center = new Point3D();
    public float height;
    public Point3D leftBottom = new Point3D();
    public Point3D leftTop = new Point3D();
    public Point3D rightBottom = new Point3D();
    public Point3D rightTop = new Point3D();
    public float width;

    public ARParticle() {
        AppMethodBeat.m2504i(81648);
        AppMethodBeat.m2505o(81648);
    }
}
