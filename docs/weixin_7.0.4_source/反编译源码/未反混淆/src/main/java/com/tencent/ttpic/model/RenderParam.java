package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class RenderParam {
    public String id;
    public float[] position = new float[12];
    public float[] texAnchor = new float[2];
    public float[] texCords = new float[12];
    public float[] texRotate = new float[]{0.0f, 0.0f, 0.0f};
    public float texScale = 1.0f;
    public int texture;

    public RenderParam() {
        AppMethodBeat.i(83512);
        AppMethodBeat.o(83512);
    }

    public RenderParam copy() {
        AppMethodBeat.i(83513);
        RenderParam renderParam = new RenderParam();
        renderParam.id = this.id;
        System.arraycopy(this.position, 0, renderParam.position, 0, this.position.length);
        System.arraycopy(this.texCords, 0, renderParam.texCords, 0, this.texCords.length);
        System.arraycopy(this.texAnchor, 0, renderParam.texAnchor, 0, this.texAnchor.length);
        System.arraycopy(this.texRotate, 0, renderParam.texRotate, 0, this.texRotate.length);
        renderParam.texScale = this.texScale;
        renderParam.texture = this.texture;
        AppMethodBeat.o(83513);
        return renderParam;
    }
}
