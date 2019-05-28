package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.p */
public class C45107p extends C8796g {
    /* renamed from: v */
    private static String f17787v = "GPUSharpen";
    /* renamed from: r */
    private int f17788r;
    /* renamed from: s */
    private float f17789s;
    /* renamed from: t */
    private int f17790t;
    /* renamed from: u */
    private int f17791u;

    public C45107p() {
        this(0.0f);
    }

    public C45107p(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float imageWidthFactor; \nuniform float imageHeightFactor; \nuniform float sharpness;\n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate; \nvarying vec2 topTextureCoordinate;\nvarying vec2 bottomTextureCoordinate;\n\nvarying float centerMultiplier;\nvarying float edgeMultiplier;\n\nvoid main()\n{\n    gl_Position = position;\n    \n    mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);\n    mediump vec2 heightStep = vec2(0.0, imageHeightFactor);\n    \n    textureCoordinate = inputTextureCoordinate.xy;\n    leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n    rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n    topTextureCoordinate = inputTextureCoordinate.xy + heightStep;     \n    bottomTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n    \n    centerMultiplier = 1.0 + 4.0 * sharpness;\n    edgeMultiplier = sharpness;\n}", "precision highp float;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 leftTextureCoordinate;\nvarying highp vec2 rightTextureCoordinate; \nvarying highp vec2 topTextureCoordinate;\nvarying highp vec2 bottomTextureCoordinate;\n\nvarying highp float centerMultiplier;\nvarying highp float edgeMultiplier;\n\nuniform sampler2D inputImageTexture;\n\nvoid main()\n{\n    mediump vec3 textureColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n    mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n    mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n    mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n    mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n\n    gl_FragColor = vec4((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), 1.0);\n}");
        this.f17789s = f;
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66947);
        boolean b = super.mo3848b();
        this.f17788r = GLES20.glGetUniformLocation(mo19894p(), "sharpness");
        this.f17790t = GLES20.glGetUniformLocation(mo19894p(), "imageWidthFactor");
        this.f17791u = GLES20.glGetUniformLocation(mo19894p(), "imageHeightFactor");
        mo72889a(this.f17789s);
        AppMethodBeat.m2505o(66947);
        return b;
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(66948);
        super.mo3839a(i, i2);
        mo19866a(this.f17790t, 1.0f / ((float) i));
        mo19866a(this.f17791u, 1.0f / ((float) i2));
        AppMethodBeat.m2505o(66948);
    }

    /* renamed from: a */
    public void mo72889a(float f) {
        AppMethodBeat.m2504i(66949);
        this.f17789s = f;
        TXCLog.m15677i(f17787v, "set Sharpness ".concat(String.valueOf(f)));
        mo19866a(this.f17788r, this.f17789s);
        AppMethodBeat.m2505o(66949);
    }
}
