package com.tencent.ttpic.shader;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.ProgramTools;
import com.tencent.view.C41106g;

public class Shader {
    private final String fragmentShaderSource;
    private int shaderProgram = 0;
    private final String vertexShaderSource;

    public Shader(String str, String str2) {
        AppMethodBeat.m2504i(50233);
        this.fragmentShaderSource = BaseFilter.nativeDecrypt(str2);
        this.vertexShaderSource = BaseFilter.nativeDecrypt(str);
        AppMethodBeat.m2505o(50233);
    }

    public void compile() {
        AppMethodBeat.m2504i(50234);
        if (this.shaderProgram == 0) {
            this.shaderProgram = ProgramTools.createProgram(this.vertexShaderSource, this.fragmentShaderSource);
        }
        AppMethodBeat.m2505o(50234);
    }

    public void bind() {
        AppMethodBeat.m2504i(50235);
        GLES20.glUseProgram(this.shaderProgram);
        C41106g.checkGlError("glUseProgram:" + this.shaderProgram);
        AppMethodBeat.m2505o(50235);
    }

    public int getShaderProgram() {
        return this.shaderProgram;
    }

    /* Access modifiers changed, original: 0000 */
    public String getFragmentShaderSource() {
        return this.fragmentShaderSource;
    }

    /* Access modifiers changed, original: 0000 */
    public String getVertexShaderSource() {
        return this.vertexShaderSource;
    }

    public void clear() {
        AppMethodBeat.m2504i(50236);
        GLES20.glDeleteProgram(this.shaderProgram);
        this.shaderProgram = 0;
        AppMethodBeat.m2505o(50236);
    }
}
