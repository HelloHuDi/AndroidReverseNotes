package com.tencent.mm.ui.chatting.e;

import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.i.c;

public final class b {

    public interface a extends c<b> {
        String aoy();

        android.support.v7.widget.RecyclerView.a aru(String str);

        <T extends i> T bfC();

        h dFG();

        void dFH();

        e dFI();

        com.tencent.mm.modelvoiceaddr.ui.b.a dFJ();

        String dFK();

        int getType();
    }

    public interface b extends com.tencent.mm.ui.chatting.view.a<a> {
        void ch(String str, boolean z);

        void dFL();

        void onFinish();

        void p(boolean z, int i);
    }
}
