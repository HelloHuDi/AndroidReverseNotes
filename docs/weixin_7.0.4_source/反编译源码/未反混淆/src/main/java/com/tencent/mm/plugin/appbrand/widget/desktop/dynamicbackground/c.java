package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundManager;", "", "()V", "init", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class c {
    public static final c iZz = new c();

    static {
        AppMethodBeat.i(135250);
        AppMethodBeat.o(135250);
    }

    private c() {
    }

    public static void init(Context context) {
        AppMethodBeat.i(135249);
        j.p(context, "context");
        e eVar = e.iZE;
        File file = new File(e.dn(context));
        if (!file.exists()) {
            file.mkdirs();
        }
        e eVar2 = e.iZE;
        StringBuilder stringBuilder = new StringBuilder();
        e eVar3 = e.iZE;
        e.p(context, "dynamicBg/scene_shaderf.glsl", stringBuilder.append(e.dn(context)).append("scene_shaderf.glsl").toString());
        eVar2 = e.iZE;
        stringBuilder = new StringBuilder();
        eVar3 = e.iZE;
        e.p(context, "dynamicBg/scene_shaderv.glsl", stringBuilder.append(e.dn(context)).append("scene_shaderv.glsl").toString());
        eVar2 = e.iZE;
        stringBuilder = new StringBuilder();
        eVar3 = e.iZE;
        e.p(context, "dynamicBg/frag_framebuffer_plane.glsl", stringBuilder.append(e.dn(context)).append("frag_framebuffer_plane.glsl").toString());
        eVar2 = e.iZE;
        stringBuilder = new StringBuilder();
        eVar3 = e.iZE;
        e.p(context, "dynamicBg/vertex_framebuffer_plane.glsl", stringBuilder.append(e.dn(context)).append("vertex_framebuffer_plane.glsl").toString());
        eVar2 = e.iZE;
        stringBuilder = new StringBuilder();
        eVar3 = e.iZE;
        e.p(context, "dynamicBg/texture_vertex_shader.glsl", stringBuilder.append(e.dn(context)).append("texture_vertex_shader.glsl").toString());
        eVar2 = e.iZE;
        stringBuilder = new StringBuilder();
        eVar3 = e.iZE;
        e.p(context, "dynamicBg/texture_fragment_shader.glsl", stringBuilder.append(e.dn(context)).append("texture_fragment_shader.glsl").toString());
        eVar2 = e.iZE;
        stringBuilder = new StringBuilder();
        eVar3 = e.iZE;
        e.p(context, "dynamicBg/bg_gradient_vertex_shader.glsl", stringBuilder.append(e.dn(context)).append("bg_gradient_vertex_shader.glsl").toString());
        eVar2 = e.iZE;
        stringBuilder = new StringBuilder();
        eVar3 = e.iZE;
        e.p(context, "dynamicBg/bg_gradient_fragment_shader.glsl", stringBuilder.append(e.dn(context)).append("bg_gradient_fragment_shader.glsl").toString());
        AppMethodBeat.o(135249);
    }
}
