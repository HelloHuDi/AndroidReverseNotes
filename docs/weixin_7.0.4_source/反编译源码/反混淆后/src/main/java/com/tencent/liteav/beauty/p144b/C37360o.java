package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.o */
public class C37360o extends C8796g {
    /* renamed from: v */
    private static String f15906v = "GPUSharpen";
    /* renamed from: r */
    private int f15907r;
    /* renamed from: s */
    private float f15908s;
    /* renamed from: t */
    private int f15909t;
    /* renamed from: u */
    private int f15910u;

    public C37360o() {
        this(0.0f);
    }

    public C37360o(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float imageWidthFactor; \nuniform float imageHeightFactor; \n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate; \nvarying vec2 topTextureCoordinate;\nvarying vec2 bottomTextureCoordinate;\n\n\nvoid main()\n{\n    gl_Position = position;\n    \n    mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);\n    mediump vec2 heightStep = vec2(0.0, imageHeightFactor);\n    \n    textureCoordinate = inputTextureCoordinate.xy;\n    leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n    rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n    topTextureCoordinate = inputTextureCoordinate.xy + heightStep;     \n    bottomTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n}\n", "precision mediump float;\n\nuniform float sharpness;\nvarying mediump vec2 textureCoordinate;\nvarying mediump vec2 leftTextureCoordinate;\nvarying mediump vec2 rightTextureCoordinate; \nvarying mediump vec2 topTextureCoordinate;\nvarying mediump vec2 bottomTextureCoordinate;\n\nuniform sampler2D inputImageTexture;\nfloat centerMultiplier;\nfloat edgeMultiplier;\n\nvoid main()\n{\n    mediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n    mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n    mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n    mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n\n    centerMultiplier = 1.0 + 4.0 * sharpness * (1.0 - textureColor.a);\n    edgeMultiplier = sharpness * (1.0 - textureColor.a);\n    gl_FragColor = vec4((textureColor.rgb * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), textureColor.a);    \n}\n");
        this.f15908s = f;
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66919);
        boolean b = super.mo3848b();
        this.f15907r = GLES20.glGetUniformLocation(mo19894p(), "sharpness");
        this.f15909t = GLES20.glGetUniformLocation(mo19894p(), "imageWidthFactor");
        this.f15910u = GLES20.glGetUniformLocation(mo19894p(), "imageHeightFactor");
        mo60126a(this.f15908s);
        AppMethodBeat.m2505o(66919);
        return b;
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(66920);
        super.mo3839a(i, i2);
        mo19866a(this.f15909t, 1.0f / ((float) i));
        mo19866a(this.f15910u, 1.0f / ((float) i2));
        AppMethodBeat.m2505o(66920);
    }

    /* renamed from: a */
    public void mo60126a(float f) {
        AppMethodBeat.m2504i(66921);
        this.f15908s = f;
        TXCLog.m15677i(f15906v, "set Sharpness ".concat(String.valueOf(f)));
        mo19866a(this.f15907r, this.f15908s);
        AppMethodBeat.m2505o(66921);
    }
}
