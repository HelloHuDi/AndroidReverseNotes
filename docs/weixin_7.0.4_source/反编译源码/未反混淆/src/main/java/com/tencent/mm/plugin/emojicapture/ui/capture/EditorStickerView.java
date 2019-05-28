package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ai;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ak;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001 \u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010&\u001a\u00020'H\u0016J\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u0014J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\nH\u0002J-\u0010,\u001a\u00020\u00142#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fH\u0016J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020'H\u0016J\u0018\u00100\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u00010\rR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R9\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "Lkotlin/ParameterName;", "name", "info", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "firstSelectSticker", "layoutManager", "Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "selectedPosition", "stickerAdapter", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "stickerCallback", "com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$stickerCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$stickerCallback$1;", "stickerRecycler", "Landroid/support/v7/widget/RecyclerView;", "timeEnter", "", "isShow", "", "refreshSelected", "reset", "selectItem", "position", "setOnVisibleChangeCallback", "visible", "setShow", "show", "setup", "selectSticker", "plugin-emojicapture_release"})
public final class EditorStickerView extends RelativeLayout {
    private final String TAG;
    private a.f.a.b<? super com.tencent.mm.plugin.emojicapture.model.a.b, y> exD;
    private long ezZ;
    private int llU;
    private final RecyclerView lmL;
    private final com.tencent.mm.plugin.emojicapture.ui.a.a lmM;
    private final com.tencent.mm.plugin.emojicapture.ui.c.a lmN;
    private String lmO;
    private final c lmP;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ EditorStickerView lmQ;

        a(EditorStickerView editorStickerView) {
            this.lmQ = editorStickerView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(3004);
            EditorStickerView.a(this.lmQ, this.lmQ.llU);
            y yVar = y.AUy;
            AppMethodBeat.o(3004);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView$1 */
    static final class AnonymousClass1 extends k implements m<Integer, com.tencent.mm.plugin.emojicapture.model.a.b, y> {
        final /* synthetic */ EditorStickerView lmQ;

        AnonymousClass1(EditorStickerView editorStickerView) {
            this.lmQ = editorStickerView;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(3003);
            int intValue = ((Number) obj).intValue();
            j.p((com.tencent.mm.plugin.emojicapture.model.a.b) obj2, "info");
            int itemCount = this.lmQ.lmM.getItemCount();
            if (intValue >= 0 && itemCount > intValue) {
                this.lmQ.lmL.smoothScrollToPosition(intValue);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(3003);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ EditorStickerView lmQ;

        b(EditorStickerView editorStickerView) {
            this.lmQ = editorStickerView;
        }

        public final void run() {
            AppMethodBeat.i(3005);
            this.lmQ.setVisibility(8);
            AppMethodBeat.o(3005);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$stickerCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr$StickerResCallback;", "notifyUpdate", "", "onItemChange", "position", "", "update", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
    public static final class c implements com.tencent.mm.plugin.emojicapture.model.a.c.a {
        final /* synthetic */ EditorStickerView lmQ;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class b extends k implements a.f.a.a<y> {
            final /* synthetic */ a.f.b.u.b eOo;
            final /* synthetic */ c lmR;

            b(c cVar, a.f.b.u.b bVar) {
                this.lmR = cVar;
                this.eOo = bVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(3007);
                this.lmR.lmQ.lmL.smoothScrollToPosition(this.eOo.AVD);
                y yVar = y.AUy;
                AppMethodBeat.o(3007);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "child", "Landroid/view/View;", "invoke"})
        static final class a extends k implements m<Integer, View, y> {
            final /* synthetic */ c lmR;

            a(c cVar) {
                this.lmR = cVar;
                super(2);
            }

            public final /* synthetic */ Object m(Object obj, Object obj2) {
                AppMethodBeat.i(AuthApiStatusCodes.AUTH_APP_CERT_ERROR);
                int intValue = ((Number) obj).intValue();
                j.p((View) obj2, "child");
                EditorStickerView.a(this.lmR.lmQ, intValue);
                y yVar = y.AUy;
                AppMethodBeat.o(AuthApiStatusCodes.AUTH_APP_CERT_ERROR);
                return yVar;
            }
        }

        c(EditorStickerView editorStickerView) {
            this.lmQ = editorStickerView;
        }

        public final void S(LinkedList<com.tencent.mm.plugin.emojicapture.model.a.b> linkedList) {
            AppMethodBeat.i(3008);
            j.p(linkedList, "items");
            ab.i(this.lmQ.TAG, "update: " + linkedList.size());
            com.tencent.mm.plugin.emojicapture.ui.a.a b = this.lmQ.lmM;
            List list = linkedList;
            j.p(list, "audios");
            ab.i(com.tencent.mm.plugin.emojicapture.ui.a.a.TAG, "update: " + list.size());
            b.llT.clear();
            b.llT.addAll(list);
            if (this.lmQ.llU < 0) {
                a.f.b.u.b bVar = new a.f.b.u.b();
                int i = 0;
                for (com.tencent.mm.plugin.emojicapture.model.a.b bVar2 : linkedList) {
                    if (j.j(bVar2.lgY, this.lmQ.lmO)) {
                        break;
                    }
                    i++;
                }
                i = -1;
                bVar.AVD = i;
                if (this.lmQ.lmO == null) {
                    bVar.AVD = 1;
                } else if (bVar.AVD < 0) {
                    bVar.AVD = 0;
                }
                this.lmQ.lmN.lqs = new a(this);
                com.tencent.mm.ab.b.a(200, (a.f.a.a) new b(this, bVar));
            }
            AppMethodBeat.o(3008);
        }

        public final void bny() {
            AppMethodBeat.i(3009);
            ab.i(this.lmQ.TAG, "notifyUpdate: ");
            this.lmQ.lmM.notifyDataSetChanged();
            AppMethodBeat.o(3009);
        }

        public final void uv(int i) {
            AppMethodBeat.i(3010);
            ab.i(this.lmQ.TAG, "onItemChange: ".concat(String.valueOf(i)));
            this.lmQ.lmM.cg(i);
            AppMethodBeat.o(3010);
        }
    }

    public EditorStickerView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(3014);
        this.TAG = "MicroMsg.EditorStickerView";
        this.llU = -1;
        View.inflate(context, R.layout.tm, this);
        View findViewById = findViewById(R.id.bdc);
        j.o(findViewById, "findViewById(R.id.emoji_capture_sticker_recycler)");
        this.lmL = (RecyclerView) findViewById;
        this.lmN = new com.tencent.mm.plugin.emojicapture.ui.c.a(context);
        this.lmL.setLayoutManager(this.lmN);
        this.lmM = new com.tencent.mm.plugin.emojicapture.ui.a.a();
        new ai().i(this.lmL);
        this.lmL.setAdapter(this.lmM);
        this.lmM.llV = new AnonymousClass1(this);
        float dimension = ((((float) ak.hy(context).x) - getResources().getDimension(R.dimen.a09)) / 2.0f) - ((float) com.tencent.mm.bz.a.fromDPToPix(context, 8));
        this.lmL.setPadding((int) dimension, 0, (int) dimension, 0);
        this.lmP = new c(this);
        AppMethodBeat.o(3014);
    }

    public EditorStickerView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(3015);
        AppMethodBeat.o(3015);
    }

    public final a.f.a.b<com.tencent.mm.plugin.emojicapture.model.a.b, y> getCallback() {
        return this.exD;
    }

    public final void setCallback(a.f.a.b<? super com.tencent.mm.plugin.emojicapture.model.a.b, y> bVar) {
        this.exD = bVar;
    }

    public final void m(long j, String str) {
        AppMethodBeat.i(3011);
        this.ezZ = j;
        this.lmO = str;
        com.tencent.mm.plugin.emojicapture.model.a.c cVar = com.tencent.mm.plugin.emojicapture.model.a.c.lhS;
        com.tencent.mm.plugin.emojicapture.model.a.c.a(this.lmP);
        AppMethodBeat.o(3011);
    }

    public final void boa() {
        AppMethodBeat.i(3012);
        com.tencent.mm.ab.b.a(200, (a.f.a.a) new a(this));
        AppMethodBeat.o(3012);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(3013);
        if (z) {
            if (getVisibility() == 0 && getAlpha() == 1.0f) {
                AppMethodBeat.o(3013);
                return;
            }
            setVisibility(0);
            animate().cancel();
            animate().alpha(1.0f).start();
            AppMethodBeat.o(3013);
        } else if (getVisibility() != 0 || getAlpha() == 0.0f) {
            AppMethodBeat.o(3013);
        } else {
            animate().cancel();
            animate().alpha(0.0f).withEndAction(new b(this)).start();
            AppMethodBeat.o(3013);
        }
    }

    public final void setOnVisibleChangeCallback(a.f.a.b<? super Boolean, y> bVar) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(EditorStickerView editorStickerView, int i) {
        a.f.a.b bVar;
        String str = null;
        AppMethodBeat.i(3016);
        ab.i(editorStickerView.TAG, "selectItem: ".concat(String.valueOf(i)));
        com.tencent.mm.plugin.emojicapture.model.a.b uE = editorStickerView.lmM.uE(i);
        editorStickerView.lmM.llU = i;
        if (uE != null) {
            com.tencent.mm.plugin.emojicapture.model.a.c cVar = com.tencent.mm.plugin.emojicapture.model.a.c.lhS;
            if (!j.j(uE, com.tencent.mm.plugin.emojicapture.model.a.c.bns())) {
                if (uE.ajN) {
                    bVar = editorStickerView.exD;
                    if (bVar != null) {
                        bVar.am(uE);
                    }
                } else {
                    bVar = editorStickerView.exD;
                    if (bVar != null) {
                        bVar.am(null);
                    }
                }
                if (editorStickerView.llU != i) {
                    String str2;
                    if (uE != null) {
                        str2 = uE.lgY;
                    } else {
                        str2 = null;
                    }
                    if (!bo.isNullOrNil(str2)) {
                        long j = editorStickerView.ezZ;
                        if (uE != null) {
                            str = uE.lgY;
                        }
                        EmojiCaptureReporter.a(j, str, i);
                    }
                }
                editorStickerView.llU = i;
                AppMethodBeat.o(3016);
            }
        }
        bVar = editorStickerView.exD;
        if (bVar != null) {
            bVar.am(null);
        }
        if (editorStickerView.llU != i) {
        }
        editorStickerView.llU = i;
        AppMethodBeat.o(3016);
    }
}
