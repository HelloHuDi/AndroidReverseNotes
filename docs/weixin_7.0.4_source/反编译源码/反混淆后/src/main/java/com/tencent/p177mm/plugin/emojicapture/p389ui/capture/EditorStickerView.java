package com.tencent.p177mm.plugin.emojicapture.p389ui.capture;

import android.content.Context;
import android.support.p069v7.widget.C44969ai;
import android.support.p069v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C42971b;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C45864c;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C45864c.C11609a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p1396a.C45871a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p728c.C6849a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C41381u.C41380b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001 \u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010&\u001a\u00020'H\u0016J\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u0014J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\nH\u0002J-\u0010,\u001a\u00020\u00142#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fH\u0016J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020'H\u0016J\u0018\u00100\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u00010\rR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R9\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "Lkotlin/ParameterName;", "name", "info", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "firstSelectSticker", "layoutManager", "Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "selectedPosition", "stickerAdapter", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "stickerCallback", "com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$stickerCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$stickerCallback$1;", "stickerRecycler", "Landroid/support/v7/widget/RecyclerView;", "timeEnter", "", "isShow", "", "refreshSelected", "reset", "selectItem", "position", "setOnVisibleChangeCallback", "visible", "setShow", "show", "setup", "selectSticker", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView */
public final class EditorStickerView extends RelativeLayout {
    private final String TAG;
    private C17126b<? super C42971b, C37091y> exD;
    private long ezZ;
    private int llU;
    private final RecyclerView lmL;
    private final C45871a lmM;
    private final C6849a lmN;
    private String lmO;
    private final C42983c lmP;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView$a */
    static final class C20455a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EditorStickerView lmQ;

        C20455a(EditorStickerView editorStickerView) {
            this.lmQ = editorStickerView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(3004);
            EditorStickerView.m84992a(this.lmQ, this.lmQ.llU);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(3004);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView$1 */
    static final class C389201 extends C25053k implements C31591m<Integer, C42971b, C37091y> {
        final /* synthetic */ EditorStickerView lmQ;

        C389201(EditorStickerView editorStickerView) {
            this.lmQ = editorStickerView;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(3003);
            int intValue = ((Number) obj).intValue();
            C25052j.m39376p((C42971b) obj2, "info");
            int itemCount = this.lmQ.lmM.getItemCount();
            if (intValue >= 0 && itemCount > intValue) {
                this.lmQ.lmL.smoothScrollToPosition(intValue);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(3003);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView$b */
    static final class C42982b implements Runnable {
        final /* synthetic */ EditorStickerView lmQ;

        C42982b(EditorStickerView editorStickerView) {
            this.lmQ = editorStickerView;
        }

        public final void run() {
            AppMethodBeat.m2504i(3005);
            this.lmQ.setVisibility(8);
            AppMethodBeat.m2505o(3005);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$stickerCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerMgr$StickerResCallback;", "notifyUpdate", "", "onItemChange", "position", "", "update", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView$c */
    public static final class C42983c implements C11609a {
        final /* synthetic */ EditorStickerView lmQ;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView$c$b */
        static final class C2962b extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C41380b eOo;
            final /* synthetic */ C42983c lmR;

            C2962b(C42983c c42983c, C41380b c41380b) {
                this.lmR = c42983c;
                this.eOo = c41380b;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(3007);
                this.lmR.lmQ.lmL.smoothScrollToPosition(this.eOo.AVD);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(3007);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "child", "Landroid/view/View;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView$c$a */
        static final class C36763a extends C25053k implements C31591m<Integer, View, C37091y> {
            final /* synthetic */ C42983c lmR;

            C36763a(C42983c c42983c) {
                this.lmR = c42983c;
                super(2);
            }

            /* renamed from: m */
            public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
                AppMethodBeat.m2504i(AuthApiStatusCodes.AUTH_APP_CERT_ERROR);
                int intValue = ((Number) obj).intValue();
                C25052j.m39376p((View) obj2, "child");
                EditorStickerView.m84992a(this.lmR.lmQ, intValue);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(AuthApiStatusCodes.AUTH_APP_CERT_ERROR);
                return c37091y;
            }
        }

        C42983c(EditorStickerView editorStickerView) {
            this.lmQ = editorStickerView;
        }

        /* renamed from: S */
        public final void mo23357S(LinkedList<C42971b> linkedList) {
            AppMethodBeat.m2504i(3008);
            C25052j.m39376p(linkedList, "items");
            C4990ab.m7416i(this.lmQ.TAG, "update: " + linkedList.size());
            C45871a b = this.lmQ.lmM;
            List list = linkedList;
            C25052j.m39376p(list, "audios");
            C4990ab.m7416i(C45871a.TAG, "update: " + list.size());
            b.llT.clear();
            b.llT.addAll(list);
            if (this.lmQ.llU < 0) {
                C41380b c41380b = new C41380b();
                int i = 0;
                for (C42971b c42971b : linkedList) {
                    if (C25052j.m39373j(c42971b.lgY, this.lmQ.lmO)) {
                        break;
                    }
                    i++;
                }
                i = -1;
                c41380b.AVD = i;
                if (this.lmQ.lmO == null) {
                    c41380b.AVD = 1;
                } else if (c41380b.AVD < 0) {
                    c41380b.AVD = 0;
                }
                this.lmQ.lmN.lqs = new C36763a(this);
                C8902b.m16041a(200, (C31214a) new C2962b(this, c41380b));
            }
            AppMethodBeat.m2505o(3008);
        }

        public final void bny() {
            AppMethodBeat.m2504i(3009);
            C4990ab.m7416i(this.lmQ.TAG, "notifyUpdate: ");
            this.lmQ.lmM.notifyDataSetChanged();
            AppMethodBeat.m2505o(3009);
        }

        /* renamed from: uv */
        public final void mo23359uv(int i) {
            AppMethodBeat.m2504i(3010);
            C4990ab.m7416i(this.lmQ.TAG, "onItemChange: ".concat(String.valueOf(i)));
            this.lmQ.lmM.mo66316cg(i);
            AppMethodBeat.m2505o(3010);
        }
    }

    public EditorStickerView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(3014);
        this.TAG = "MicroMsg.EditorStickerView";
        this.llU = -1;
        View.inflate(context, 2130969330, this);
        View findViewById = findViewById(2131823443);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_sticker_recycler)");
        this.lmL = (RecyclerView) findViewById;
        this.lmN = new C6849a(context);
        this.lmL.setLayoutManager(this.lmN);
        this.lmM = new C45871a();
        new C44969ai().mo42393i(this.lmL);
        this.lmL.setAdapter(this.lmM);
        this.lmM.llV = new C389201(this);
        float dimension = ((((float) C5230ak.m7993hy(context).x) - getResources().getDimension(C25738R.dimen.a09)) / 2.0f) - ((float) C1338a.fromDPToPix(context, 8));
        this.lmL.setPadding((int) dimension, 0, (int) dimension, 0);
        this.lmP = new C42983c(this);
        AppMethodBeat.m2505o(3014);
    }

    public EditorStickerView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(3015);
        AppMethodBeat.m2505o(3015);
    }

    public final C17126b<C42971b, C37091y> getCallback() {
        return this.exD;
    }

    public final void setCallback(C17126b<? super C42971b, C37091y> c17126b) {
        this.exD = c17126b;
    }

    /* renamed from: m */
    public final void mo73699m(long j, String str) {
        AppMethodBeat.m2504i(3011);
        this.ezZ = j;
        this.lmO = str;
        C45864c c45864c = C45864c.lhS;
        C45864c.m84966a(this.lmP);
        AppMethodBeat.m2505o(3011);
    }

    public final void boa() {
        AppMethodBeat.m2504i(3012);
        C8902b.m16041a(200, (C31214a) new C20455a(this));
        AppMethodBeat.m2505o(3012);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.m2504i(3013);
        if (z) {
            if (getVisibility() == 0 && getAlpha() == 1.0f) {
                AppMethodBeat.m2505o(3013);
                return;
            }
            setVisibility(0);
            animate().cancel();
            animate().alpha(1.0f).start();
            AppMethodBeat.m2505o(3013);
        } else if (getVisibility() != 0 || getAlpha() == 0.0f) {
            AppMethodBeat.m2505o(3013);
        } else {
            animate().cancel();
            animate().alpha(0.0f).withEndAction(new C42982b(this)).start();
            AppMethodBeat.m2505o(3013);
        }
    }

    public final void setOnVisibleChangeCallback(C17126b<? super Boolean, C37091y> c17126b) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final /* synthetic */ void m84992a(EditorStickerView editorStickerView, int i) {
        C17126b c17126b;
        String str = null;
        AppMethodBeat.m2504i(3016);
        C4990ab.m7416i(editorStickerView.TAG, "selectItem: ".concat(String.valueOf(i)));
        C42971b uE = editorStickerView.lmM.mo73685uE(i);
        editorStickerView.lmM.llU = i;
        if (uE != null) {
            C45864c c45864c = C45864c.lhS;
            if (!C25052j.m39373j(uE, C45864c.bns())) {
                if (uE.ajN) {
                    c17126b = editorStickerView.exD;
                    if (c17126b != null) {
                        c17126b.mo50am(uE);
                    }
                } else {
                    c17126b = editorStickerView.exD;
                    if (c17126b != null) {
                        c17126b.mo50am(null);
                    }
                }
                if (editorStickerView.llU != i) {
                    String str2;
                    if (uE != null) {
                        str2 = uE.lgY;
                    } else {
                        str2 = null;
                    }
                    if (!C5046bo.isNullOrNil(str2)) {
                        long j = editorStickerView.ezZ;
                        if (uE != null) {
                            str = uE.lgY;
                        }
                        EmojiCaptureReporter.m66032a(j, str, i);
                    }
                }
                editorStickerView.llU = i;
                AppMethodBeat.m2505o(3016);
            }
        }
        c17126b = editorStickerView.exD;
        if (c17126b != null) {
            c17126b.mo50am(null);
        }
        if (editorStickerView.llU != i) {
        }
        editorStickerView.llU = i;
        AppMethodBeat.m2505o(3016);
    }
}
