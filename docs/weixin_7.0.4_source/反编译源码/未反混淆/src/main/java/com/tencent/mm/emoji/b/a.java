package com.tencent.mm.emoji.b;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.v;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lcom/tencent/mm/emoji/panel/MMContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "inflater", "Landroid/view/LayoutInflater;", "getSystemService", "", "name", "", "plugin-emojisdk_release"})
public final class a extends ContextThemeWrapper {
    private LayoutInflater ezi;

    public a(Context context, int i) {
        j.p(context, "base");
        super(context, i);
        AppMethodBeat.i(63251);
        AppMethodBeat.o(63251);
    }

    public final Object getSystemService(String str) {
        AppMethodBeat.i(63250);
        j.p(str, "name");
        Object systemService;
        if (j.j("layout_inflater", str)) {
            if (this.ezi == null) {
                systemService = super.getSystemService(str);
                if (!(systemService instanceof LayoutInflater)) {
                    systemService = null;
                }
                this.ezi = v.a((LayoutInflater) systemService);
            }
            LayoutInflater layoutInflater = this.ezi;
            AppMethodBeat.o(63250);
            return layoutInflater;
        }
        systemService = super.getSystemService(str);
        AppMethodBeat.o(63250);
        return systemService;
    }
}
