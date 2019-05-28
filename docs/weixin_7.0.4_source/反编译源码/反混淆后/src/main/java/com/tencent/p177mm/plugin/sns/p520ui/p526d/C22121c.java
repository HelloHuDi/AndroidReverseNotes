package com.tencent.p177mm.plugin.sns.p520ui.p526d;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.d.c */
public abstract class C22121c implements OnCreateContextMenuListener {
    /* renamed from: a */
    public abstract void mo37650a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo);

    /* renamed from: dR */
    public abstract boolean mo37651dR(View view);

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (mo37651dR(view)) {
            mo37650a(contextMenu, view, contextMenuInfo);
        } else {
            C4990ab.m7412e("MicroMsg.TimelineOnCreateContextMenuListener", "onMMCreateContextMenu error");
        }
    }
}
