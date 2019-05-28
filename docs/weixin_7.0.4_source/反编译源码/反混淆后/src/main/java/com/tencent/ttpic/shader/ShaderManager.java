package com.tencent.ttpic.shader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.HashMap;
import java.util.Map;

public class ShaderManager {
    private static final ThreadLocal<ShaderManager> shaderManager = new C59861();
    private Map<PROGRAM_TYPE, Shader> shaderMap = new HashMap();

    /* renamed from: com.tencent.ttpic.shader.ShaderManager$1 */
    static class C59861 extends ThreadLocal<ShaderManager> {
        C59861() {
        }

        /* Access modifiers changed, original: protected|final */
        public final ShaderManager initialValue() {
            AppMethodBeat.m2504i(83735);
            ShaderManager shaderManager = new ShaderManager();
            AppMethodBeat.m2505o(83735);
            return shaderManager;
        }
    }

    public ShaderManager() {
        AppMethodBeat.m2504i(83737);
        AppMethodBeat.m2505o(83737);
    }

    static {
        AppMethodBeat.m2504i(83744);
        AppMethodBeat.m2505o(83744);
    }

    public boolean bind(PROGRAM_TYPE program_type) {
        AppMethodBeat.m2504i(83738);
        Shader shader = (Shader) this.shaderMap.get(program_type);
        if (shader == null) {
            AppMethodBeat.m2505o(83738);
            return false;
        }
        shader.bind();
        AppMethodBeat.m2505o(83738);
        return true;
    }

    public Shader getShader(PROGRAM_TYPE program_type) {
        AppMethodBeat.m2504i(83739);
        if (!this.shaderMap.containsKey(program_type)) {
            this.shaderMap.put(program_type, ShaderCreateFactory.createShader(program_type));
        }
        Shader shader = (Shader) this.shaderMap.get(program_type);
        AppMethodBeat.m2505o(83739);
        return shader;
    }

    public static ShaderManager getInstance() {
        AppMethodBeat.m2504i(83740);
        ShaderManager shaderManager = (ShaderManager) shaderManager.get();
        AppMethodBeat.m2505o(83740);
        return shaderManager;
    }

    public void compile() {
        AppMethodBeat.m2504i(83741);
        for (Shader compile : this.shaderMap.values()) {
            compile.compile();
        }
        AppMethodBeat.m2505o(83741);
    }

    public boolean clearShader(PROGRAM_TYPE program_type) {
        AppMethodBeat.m2504i(83742);
        Shader shader = (Shader) this.shaderMap.get(program_type);
        if (shader == null) {
            AppMethodBeat.m2505o(83742);
            return false;
        }
        shader.clear();
        this.shaderMap.remove(program_type);
        AppMethodBeat.m2505o(83742);
        return true;
    }

    public void clear() {
        AppMethodBeat.m2504i(83743);
        for (Shader clear : this.shaderMap.values()) {
            clear.clear();
        }
        this.shaderMap.clear();
        AppMethodBeat.m2505o(83743);
    }
}
