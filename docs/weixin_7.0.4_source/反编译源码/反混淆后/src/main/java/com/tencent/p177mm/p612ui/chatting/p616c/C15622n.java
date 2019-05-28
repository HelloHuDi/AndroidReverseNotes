package com.tencent.p177mm.p612ui.chatting.p616c;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30467ad;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36133b;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44296aa;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46641ai;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46642l;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14988o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C15590a(dFp = C46642l.class)
/* renamed from: com.tencent.mm.ui.chatting.c.n */
public class C15622n extends C44291a implements C46642l {

    /* renamed from: com.tencent.mm.ui.chatting.c.n$1 */
    class C156231 implements Runnable {

        /* renamed from: com.tencent.mm.ui.chatting.c.n$1$1 */
        class C156241 implements OnDragListener {
            C156241() {
            }

            public final boolean onDrag(View view, DragEvent dragEvent) {
                boolean z = true;
                AppMethodBeat.m2504i(31386);
                switch (dragEvent.getAction()) {
                    case 1:
                        C4990ab.m7416i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_STARTED");
                        break;
                    case 2:
                        C4990ab.m7416i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_LOCATION");
                        break;
                    case 3:
                        C4990ab.m7416i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DROP");
                        ClipData clipData = dragEvent.getClipData();
                        if (clipData != null) {
                            int itemCount = clipData.getItemCount();
                            for (int i = 0; i < itemCount; i++) {
                                Item itemAt = clipData.getItemAt(i);
                                if (itemAt == null) {
                                    C4990ab.m7412e("MicroMsg.ChattingUI.DragDropComponent", "item == null");
                                } else if (itemAt.getIntent() != null) {
                                    C15622n.this.cgL.yTx.startActivity(itemAt.getIntent());
                                } else if (itemAt.getUri() != null) {
                                    C14988o c14988o = new C14988o(C15622n.this.cgL.yTx.getContext(), itemAt.getUri());
                                    if (c14988o.fileType != 0 && c14988o.filePath != null) {
                                        switch (c14988o.fileType) {
                                            case 3:
                                                String str = c14988o.filePath;
                                                ((C44296aa) C15622n.this.cgL.mo74857aF(C44296aa.class)).mo70167B(C1853r.m3854g(str, C15622n.this.cgL.getTalkerUserName(), true) ? 1 : 0, 0, str);
                                                break;
                                            case 4:
                                                Intent intent = new Intent();
                                                intent.setData(itemAt.getUri());
                                                ((C46641ai) C15622n.this.cgL.mo74857aF(C46641ai.class)).mo72007ai(intent);
                                                break;
                                            default:
                                                ((C36133b) C15622n.this.cgL.mo74857aF(C36133b.class)).mo57001a(c14988o);
                                                break;
                                        }
                                    }
                                    C4990ab.m7412e("MicroMsg.ChattingUI.DragDropComponent", "get file path failed");
                                } else if (itemAt.getText() != null && itemAt.getText().length() > 0) {
                                    ((C30467ad) C15622n.this.cgL.mo74857aF(C30467ad.class)).arq(itemAt.getText().toString());
                                }
                            }
                            break;
                        }
                        break;
                    case 4:
                        C4990ab.m7416i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENDED");
                        break;
                    case 5:
                        C4990ab.m7416i("MicroMsg.ChattingUI.DragDropComponent", "ACTION_DRAG_ENTERED");
                        break;
                    default:
                        C4990ab.m7412e("MicroMsg.ChattingUI.DragDropComponent", "Unknown action type received by OnDragListener.");
                        z = false;
                        break;
                }
                AppMethodBeat.m2505o(31386);
                return z;
            }
        }

        C156231() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31387);
            C156241 c156241 = new C156241();
            if (C15622n.this.cgL.getListView() != null) {
                C15622n.this.cgL.getListView().setOnDragListener(c156241);
            }
            ChatFooter dDX = ((C15614o) C15622n.this.cgL.mo74857aF(C15614o.class)).dDX();
            if (dDX != null) {
                dDX.setOnDragListener(c156241);
                dDX.setEditTextOnDragListener(c156241);
            }
            AppMethodBeat.m2505o(31387);
        }
    }

    @TargetApi(11)
    public final void dDV() {
        AppMethodBeat.m2504i(31388);
        if (VERSION.SDK_INT < 11) {
            C4990ab.m7410d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
            AppMethodBeat.m2505o(31388);
            return;
        }
        if (this.cgL.getListView() != null) {
            this.cgL.getListView().setOnDragListener(null);
        }
        ChatFooter dDX = ((C15614o) this.cgL.mo74857aF(C15614o.class)).dDX();
        if (dDX != null) {
            dDX.setOnDragListener(null);
            dDX.setEditTextOnDragListener(null);
        }
        AppMethodBeat.m2505o(31388);
    }

    @TargetApi(11)
    public final void cuB() {
        AppMethodBeat.m2504i(31389);
        boolean dES = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dES();
        boolean dET = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dET();
        if (dES || dET) {
            AppMethodBeat.m2505o(31389);
        } else if (VERSION.SDK_INT < 11) {
            C4990ab.m7410d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
            AppMethodBeat.m2505o(31389);
        } else {
            new C156231().run();
            AppMethodBeat.m2505o(31389);
        }
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31390);
        cuB();
        AppMethodBeat.m2505o(31390);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31391);
        dDV();
        AppMethodBeat.m2505o(31391);
    }
}
