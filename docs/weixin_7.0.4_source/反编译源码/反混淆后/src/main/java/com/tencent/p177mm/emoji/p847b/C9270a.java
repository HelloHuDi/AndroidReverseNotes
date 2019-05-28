package com.tencent.p177mm.emoji.p847b;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lcom/tencent/mm/emoji/panel/MMContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "inflater", "Landroid/view/LayoutInflater;", "getSystemService", "", "name", "", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.b.a */
public final class C9270a extends ContextThemeWrapper {
    private LayoutInflater ezi;

    public C9270a(Context context, int i) {
        C25052j.m39376p(context, "base");
        super(context, i);
        AppMethodBeat.m2504i(63251);
        AppMethodBeat.m2505o(63251);
    }

    public final Object getSystemService(String str) {
        AppMethodBeat.m2504i(63250);
        C25052j.m39376p(str, "name");
        Object systemService;
        if (C25052j.m39373j("layout_inflater", str)) {
            if (this.ezi == null) {
                systemService = super.getSystemService(str);
                if (!(systemService instanceof LayoutInflater)) {
                    systemService = null;
                }
                this.ezi = C5616v.m8408a((LayoutInflater) systemService);
            }
            LayoutInflater layoutInflater = this.ezi;
            AppMethodBeat.m2505o(63250);
            return layoutInflater;
        }
        systemService = super.getSystemService(str);
        AppMethodBeat.m2505o(63250);
        return systemService;
    }
}
