package com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundManager;", "", "()V", "init", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.c */
public final class C38584c {
    public static final C38584c iZz = new C38584c();

    static {
        AppMethodBeat.m2504i(135250);
        AppMethodBeat.m2505o(135250);
    }

    private C38584c() {
    }

    public static void init(Context context) {
        AppMethodBeat.m2504i(135249);
        C25052j.m39376p(context, "context");
        C38585e c38585e = C38585e.iZE;
        File file = new File(C38585e.m65394dn(context));
        if (!file.exists()) {
            file.mkdirs();
        }
        C38585e c38585e2 = C38585e.iZE;
        StringBuilder stringBuilder = new StringBuilder();
        C38585e c38585e3 = C38585e.iZE;
        C38585e.m65395p(context, "dynamicBg/scene_shaderf.glsl", stringBuilder.append(C38585e.m65394dn(context)).append("scene_shaderf.glsl").toString());
        c38585e2 = C38585e.iZE;
        stringBuilder = new StringBuilder();
        c38585e3 = C38585e.iZE;
        C38585e.m65395p(context, "dynamicBg/scene_shaderv.glsl", stringBuilder.append(C38585e.m65394dn(context)).append("scene_shaderv.glsl").toString());
        c38585e2 = C38585e.iZE;
        stringBuilder = new StringBuilder();
        c38585e3 = C38585e.iZE;
        C38585e.m65395p(context, "dynamicBg/frag_framebuffer_plane.glsl", stringBuilder.append(C38585e.m65394dn(context)).append("frag_framebuffer_plane.glsl").toString());
        c38585e2 = C38585e.iZE;
        stringBuilder = new StringBuilder();
        c38585e3 = C38585e.iZE;
        C38585e.m65395p(context, "dynamicBg/vertex_framebuffer_plane.glsl", stringBuilder.append(C38585e.m65394dn(context)).append("vertex_framebuffer_plane.glsl").toString());
        c38585e2 = C38585e.iZE;
        stringBuilder = new StringBuilder();
        c38585e3 = C38585e.iZE;
        C38585e.m65395p(context, "dynamicBg/texture_vertex_shader.glsl", stringBuilder.append(C38585e.m65394dn(context)).append("texture_vertex_shader.glsl").toString());
        c38585e2 = C38585e.iZE;
        stringBuilder = new StringBuilder();
        c38585e3 = C38585e.iZE;
        C38585e.m65395p(context, "dynamicBg/texture_fragment_shader.glsl", stringBuilder.append(C38585e.m65394dn(context)).append("texture_fragment_shader.glsl").toString());
        c38585e2 = C38585e.iZE;
        stringBuilder = new StringBuilder();
        c38585e3 = C38585e.iZE;
        C38585e.m65395p(context, "dynamicBg/bg_gradient_vertex_shader.glsl", stringBuilder.append(C38585e.m65394dn(context)).append("bg_gradient_vertex_shader.glsl").toString());
        c38585e2 = C38585e.iZE;
        stringBuilder = new StringBuilder();
        c38585e3 = C38585e.iZE;
        C38585e.m65395p(context, "dynamicBg/bg_gradient_fragment_shader.glsl", stringBuilder.append(C38585e.m65394dn(context)).append("bg_gradient_fragment_shader.glsl").toString());
        AppMethodBeat.m2505o(135249);
    }
}
