package com.tencent.mm.ui.chatting.c;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ad;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.b;
import com.tencent.mm.ui.chatting.c.b.l;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.z;

@a(dFp = l.class)
public class n extends a implements l {
    @TargetApi(11)
    public final void dDV() {
        AppMethodBeat.i(31388);
        if (VERSION.SDK_INT < 11) {
            ab.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
            AppMethodBeat.o(31388);
            return;
        }
        if (this.cgL.getListView() != null) {
            this.cgL.getListView().setOnDragListener(null);
        }
        ChatFooter dDX = ((o) this.cgL.aF(o.class)).dDX();
        if (dDX != null) {
            dDX.setOnDragListener(null);
            dDX.setEditTextOnDragListener(null);
        }
        AppMethodBeat.o(31388);
    }

    @TargetApi(11)
    public final void cuB() {
        AppMethodBeat.i(31389);
        boolean dES = ((z) this.cgL.aF(z.class)).dES();
        boolean dET = ((z) this.cgL.aF(z.class)).dET();
        if (dES || dET) {
            AppMethodBeat.o(31389);
        } else if (VERSION.SDK_INT < 11) {
            ab.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
            AppMethodBeat.o(31389);
        } else {
            new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31387);
                    AnonymousClass1 anonymousClass1 = new OnDragListener() {
                        public final boolean onDrag(View view, DragEvent dragEvent) {
                            boolean z = true;
                            AppMethodBeat.i(31386);
                            switch (dragEvent.getAction()) {
                                case 1:
                                    ab.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_STARTED");
                                    break;
                                case 2:
                                    ab.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_LOCATION");
                                    break;
                                case 3:
                                    ab.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DROP");
                                    ClipData clipData = dragEvent.getClipData();
                                    if (clipData != null) {
                                        int itemCount = clipData.getItemCount();
                                        for (int i = 0; i < itemCount; i++) {
                                            Item itemAt = clipData.getItemAt(i);
                                            if (itemAt == null) {
                                                ab.e("MicroMsg.ChattingUI.DragDropComponent", "item == null");
                                            } else if (itemAt.getIntent() != null) {
                                                n.this.cgL.yTx.startActivity(itemAt.getIntent());
                                            } else if (itemAt.getUri() != null) {
                                                com.tencent.mm.pluginsdk.ui.tools.o oVar = new com.tencent.mm.pluginsdk.ui.tools.o(n.this.cgL.yTx.getContext(), itemAt.getUri());
                                                if (oVar.fileType != 0 && oVar.filePath != null) {
                                                    switch (oVar.fileType) {
                                                        case 3:
                                                            String str = oVar.filePath;
                                                            ((aa) n.this.cgL.aF(aa.class)).B(r.g(str, n.this.cgL.getTalkerUserName(), true) ? 1 : 0, 0, str);
                                                            break;
                                                        case 4:
                                                            Intent intent = new Intent();
                                                            intent.setData(itemAt.getUri());
                                                            ((ai) n.this.cgL.aF(ai.class)).ai(intent);
                                                            break;
                                                        default:
                                                            ((b) n.this.cgL.aF(b.class)).a(oVar);
                                                            break;
                                                    }
                                                }
                                                ab.e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
                                            } else if (itemAt.getText() != null && itemAt.getText().length() > 0) {
                                                ((ad) n.this.cgL.aF(ad.class)).arq(itemAt.getText().toString());
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                case 4:
                                    ab.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENDED");
                                    break;
                                case 5:
                                    ab.i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENTERED");
                                    break;
                                default:
                                    ab.e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
                                    z = false;
                                    break;
                            }
                            AppMethodBeat.o(31386);
                            return z;
                        }
                    };
                    if (n.this.cgL.getListView() != null) {
                        n.this.cgL.getListView().setOnDragListener(anonymousClass1);
                    }
                    ChatFooter dDX = ((o) n.this.cgL.aF(o.class)).dDX();
                    if (dDX != null) {
                        dDX.setOnDragListener(anonymousClass1);
                        dDX.setEditTextOnDragListener(anonymousClass1);
                    }
                    AppMethodBeat.o(31387);
                }
            }.run();
            AppMethodBeat.o(31389);
        }
    }

    public final void dxy() {
        AppMethodBeat.i(31390);
        cuB();
        AppMethodBeat.o(31390);
    }

    public final void dxC() {
        AppMethodBeat.i(31391);
        dDV();
        AppMethodBeat.o(31391);
    }
}
