package com.tencent.mm.ui.chatting.c.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.v;

public interface aa extends v {
    void B(int i, int i2, String str);

    void a(ContextMenu contextMenu, int i, bi biVar);

    void a(SightCaptureResult sightCaptureResult);

    boolean a(MenuItem menuItem, bi biVar);

    boolean bb(bi biVar);

    boolean g(int i, int i2, Intent intent);

    void z(String str, int i, String str2);
}
