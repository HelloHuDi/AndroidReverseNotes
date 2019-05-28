package com.tencent.mm.plugin.sns.ui.d;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class c implements OnCreateContextMenuListener {
    public abstract void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo);

    public abstract boolean dR(View view);

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (dR(view)) {
            a(contextMenu, view, contextMenuInfo);
        } else {
            ab.e("MicroMsg.TimelineOnCreateContextMenuListener", "onMMCreateContextMenu error");
        }
    }
}
