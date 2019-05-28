package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t;
import com.tencent.mm.api.u;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0003*\u00017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0011H\u0002J(\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0002J\b\u0010E\u001a\u00020?H\u0016J\b\u0010F\u001a\u00020\u001bH\u0016J\n\u0010G\u001a\u0004\u0018\u00010:H\u0016J\b\u0010H\u001a\u00020?H\u0002J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020JH\u0016J\b\u0010L\u001a\u00020JH\u0016J\b\u0010M\u001a\u00020?H\u0016J\u000e\u0010N\u001a\u00020?2\u0006\u0010(\u001a\u00020)J\u0010\u0010O\u001a\u00020?2\u0006\u0010P\u001a\u00020\nH\u0016J8\u0010Q\u001a\u00020?2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020J2\u0006\u0010T\u001a\u00020J2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>H\u0016J\u0010\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u00020JH\u0016J\"\u0010W\u001a\u00020?2\u0006\u0010V\u001a\u00020J2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020\nH\u0016J\b\u0010[\u001a\u00020?H\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u000207X\u0004¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"})
public final class CaptureEditorContainer extends RelativeLayout implements com.tencent.mm.plugin.emojicapture.c.b.b {
    private final String TAG;
    private final ChatFooterPanel eAk;
    private long eyR;
    private EmojiCaptureReporter lha;
    private com.tencent.mm.plugin.emojicapture.c.b.a lmT;
    private com.tencent.mm.plugin.emojicapture.model.a.a lmU;
    private final ViewGroup lmV;
    private EmojiVideoPlayTextureView lmW;
    private EditorItemContainer lmX;
    private EditorChangeTextView lmY;
    private View lmZ;
    private View lna;
    private View lnb;
    private View lnc;
    private final ImageView lnd;
    private final ImageView lne;
    private final ImageView lnf;
    private ImageView lnh;
    private ImageView lni;
    private final Drawable lnj;
    private final Drawable lnk;
    private final Drawable lnl;
    private final Drawable lnm;
    private final Drawable lnn;
    private final Drawable lno;
    private a.f.a.a<y> lnp;
    private final c lnq;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$4 */
    static final class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        AnonymousClass4(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(3028);
            com.tencent.mm.plugin.emojicapture.c.b.a presenter = this.lnr.getPresenter();
            if (presenter != null) {
                presenter.Ab();
                AppMethodBeat.o(3028);
                return;
            }
            AppMethodBeat.o(3028);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$5 */
    static final class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        AnonymousClass5(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(3029);
            CaptureEditorContainer.c(this.lnr).lgR = System.currentTimeMillis() - CaptureEditorContainer.c(this.lnr).lgN;
            EmojiCaptureReporter.a(17, CaptureEditorContainer.c(this.lnr).ezZ, 0, 0, CaptureEditorContainer.c(this.lnr).lgR, 0, 0, 0, 0, CaptureEditorContainer.c(this.lnr).scene);
            EmojiCaptureReporter.up(3);
            com.tencent.mm.plugin.emojicapture.c.b.a presenter = this.lnr.getPresenter();
            if (presenter != null) {
                presenter.bmz();
                AppMethodBeat.o(3029);
                return;
            }
            AppMethodBeat.o(3029);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$6 */
    static final class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        AnonymousClass6(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(3030);
            if (this.lnr.bmC()) {
                this.lnr.gC(false);
            }
            AppMethodBeat.o(3030);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"})
    public static final class a implements com.tencent.mm.api.t.a {
        final /* synthetic */ CaptureEditorContainer lnr;

        a(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void a(k kVar) {
            AppMethodBeat.i(3034);
            j.p(kVar, "emojiInfo");
            ab.i(this.lnr.TAG, "[onSelectedEmoji] emojiInfo:%s", kVar);
            com.tencent.mm.plugin.emojicapture.c.b.a presenter = this.lnr.getPresenter();
            if (presenter != null) {
                presenter.c(kVar);
            }
            onHide();
            AppMethodBeat.o(3034);
        }

        public final void onHide() {
            AppMethodBeat.i(3035);
            this.lnr.gC(false);
            AppMethodBeat.o(3035);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$3 */
    static final class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        AnonymousClass3(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(3027);
            EmojiCaptureReporter.a(12, CaptureEditorContainer.c(this.lnr).ezZ, 0, 0, 0, 0, 0, 0, 0, CaptureEditorContainer.c(this.lnr).scene);
            this.lnr.gC(!this.lnr.bmC());
            AppMethodBeat.o(3027);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$7", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "onCancel", "", "onConfirm", "text", "", "color", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$7 */
    public static final class AnonymousClass7 implements com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.a {
        final /* synthetic */ CaptureEditorContainer lnr;

        AnonymousClass7(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void i(CharSequence charSequence, int i) {
            AppMethodBeat.i(3031);
            String obj = charSequence != null ? charSequence.toString() : null;
            if (obj != null && obj.length() > 50) {
                obj = obj.substring(0, 50);
                j.o(obj, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            com.tencent.mm.plugin.emojicapture.c.b.a presenter = this.lnr.getPresenter();
            if (presenter != null) {
                presenter.n(obj, i, true);
            }
            this.lnr.lmY.setShow(false);
            AppMethodBeat.o(3031);
        }

        public final void onCancel() {
            AppMethodBeat.i(3032);
            com.tencent.mm.plugin.emojicapture.c.b.a presenter = this.lnr.getPresenter();
            if (presenter != null) {
                presenter.n(null, 0, false);
            }
            this.lnr.lmY.setShow(false);
            AppMethodBeat.o(3032);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$8", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "onStateChange", "", "showDelete", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$8 */
    public static final class AnonymousClass8 implements com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer.b {
        final /* synthetic */ CaptureEditorContainer lnr;

        AnonymousClass8(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void gH(boolean z) {
            AppMethodBeat.i(3033);
            if (z) {
                this.lnr.lmZ.setVisibility(8);
                AppMethodBeat.o(3033);
                return;
            }
            this.lnr.lmZ.setVisibility(0);
            AppMethodBeat.o(3033);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ CaptureEditorContainer lnr;

        b(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void run() {
            AppMethodBeat.i(3036);
            this.lnr.eAk.setVisibility(8);
            AppMethodBeat.o(3036);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        AnonymousClass1(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(3025);
            EmojiCaptureReporter.a(10, CaptureEditorContainer.c(this.lnr).ezZ, 0, 0, 0, 0, 0, 0, 0, CaptureEditorContainer.c(this.lnr).scene);
            View d = this.lnr.lna;
            com.tencent.mm.plugin.emojicapture.c.b.a presenter = this.lnr.getPresenter();
            d.setSelected(presenter != null ? presenter.bmx() : false);
            this.lnr.lnd.setImageDrawable(this.lnr.lna.isSelected() ? this.lnr.lnj : this.lnr.lnk);
            AppMethodBeat.o(3025);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"})
    public static final class c implements com.tencent.mm.pluginsdk.ui.tools.e.a {
        final /* synthetic */ CaptureEditorContainer lnr;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ c lns;

            a(c cVar) {
                this.lns = cVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(3037);
                EmojiVideoPlayTextureView n = this.lns.lnr.lmW;
                if (n != null) {
                    n.setVisibility(0);
                }
                a.f.a.a o = this.lns.lnr.lnp;
                if (o != null) {
                    o.invoke();
                }
                y yVar = y.AUy;
                AppMethodBeat.o(3037);
                return yVar;
            }
        }

        c(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void pL() {
            AppMethodBeat.i(3038);
            EmojiVideoPlayTextureView n = this.lnr.lmW;
            if (n != null) {
                n.setOneTimeVideoTextureUpdateCallback(new a(this));
            }
            this.lnr.setStartTick(bo.yz());
            EmojiVideoPlayTextureView n2 = this.lnr.lmW;
            if (n2 != null) {
                n2.start();
                AppMethodBeat.o(3038);
                return;
            }
            AppMethodBeat.o(3038);
        }

        public final void EA() {
            AppMethodBeat.i(3039);
            ab.i(this.lnr.TAG, "onCompletion cost " + bo.az(this.lnr.getStartTick()) + "ms");
            this.lnr.setStartTick(bo.yz());
            EmojiVideoPlayTextureView n = this.lnr.lmW;
            if (n != null) {
                n.llB = true;
                i iVar = n.llA;
                if (iVar != null) {
                    iVar.yI(0);
                    AppMethodBeat.o(3039);
                    return;
                }
                AppMethodBeat.o(3039);
                return;
            }
            AppMethodBeat.o(3039);
        }

        public final int dG(int i, int i2) {
            return 0;
        }

        public final void dH(int i, int i2) {
        }

        public final void onError(int i, int i2) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$2 */
    static final class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        AnonymousClass2(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(3026);
            EmojiCaptureReporter.a(11, CaptureEditorContainer.c(this.lnr).ezZ, 0, 0, 0, 0, 0, 0, 0, CaptureEditorContainer.c(this.lnr).scene);
            View h = this.lnr.lnb;
            com.tencent.mm.plugin.emojicapture.c.b.a presenter = this.lnr.getPresenter();
            h.setSelected(presenter != null ? presenter.bmy() : false);
            this.lnr.lne.setImageDrawable(this.lnr.lnb.isSelected() ? this.lnr.lnl : this.lnr.lnm);
            AppMethodBeat.o(3026);
        }
    }

    public static final /* synthetic */ EmojiCaptureReporter c(CaptureEditorContainer captureEditorContainer) {
        AppMethodBeat.i(3053);
        EmojiCaptureReporter emojiCaptureReporter = captureEditorContainer.lha;
        if (emojiCaptureReporter == null) {
            j.avw("reporter");
        }
        AppMethodBeat.o(3053);
        return emojiCaptureReporter;
    }

    public CaptureEditorContainer(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(3051);
        this.TAG = "MicroMsg.CaptureEditorContainer";
        this.lmU = new com.tencent.mm.plugin.emojicapture.model.a.a();
        View.inflate(context, R.layout.ts, this);
        View findViewById = findViewById(R.id.bdo);
        j.o(findViewById, "findViewById(R.id.emoji_…e_video_play_view_layout)");
        this.lmV = (ViewGroup) findViewById;
        findViewById = findViewById(R.id.bdp);
        j.o(findViewById, "findViewById(R.id.editor_item_container)");
        this.lmX = (EditorItemContainer) findViewById;
        findViewById = findViewById(R.id.bc_);
        j.o(findViewById, "findViewById(R.id.change_text_root)");
        this.lmY = (EditorChangeTextView) findViewById;
        findViewById = findViewById(R.id.bdq);
        j.o(findViewById, "findViewById(R.id.editor_type_root)");
        this.lmZ = findViewById;
        findViewById = findViewById(R.id.bdr);
        j.o(findViewById, "findViewById(R.id.editor_remove_background)");
        this.lna = findViewById;
        findViewById = findViewById(R.id.bdu);
        j.o(findViewById, "findViewById(R.id.editor_speed_up)");
        this.lnb = findViewById;
        findViewById = findViewById(R.id.bdx);
        j.o(findViewById, "findViewById(R.id.editor_add_emoji)");
        this.lnc = findViewById;
        findViewById = findViewById(R.id.bds);
        j.o(findViewById, "findViewById(R.id.editor_remove_background_icon)");
        this.lnd = (ImageView) findViewById;
        findViewById = findViewById(R.id.bdv);
        j.o(findViewById, "findViewById(R.id.editor_speed_up_icon)");
        this.lne = (ImageView) findViewById;
        findViewById = findViewById(R.id.bdy);
        j.o(findViewById, "findViewById(R.id.editor_add_emoji_icon)");
        this.lnf = (ImageView) findViewById;
        findViewById = findViewById(R.id.be1);
        j.o(findViewById, "findViewById(R.id.to_capture)");
        this.lnh = (ImageView) findViewById;
        findViewById = findViewById(R.id.be3);
        j.o(findViewById, "findViewById(R.id.mix_video)");
        this.lni = (ImageView) findViewById;
        Drawable f = ah.f(context, R.raw.icons_filled_remove_bg, com.tencent.mm.plugin.emojicapture.ui.a.dg(this));
        j.o(f, "getColorDrawable(context…ve_bg, getIconSelColor())");
        this.lnj = f;
        f = ah.f(context, R.raw.icons_outlined_remove_bg, com.tencent.mm.plugin.emojicapture.ui.a.dh(this));
        j.o(f, "getColorDrawable(context…ve_bg, getIconNorColor())");
        this.lnk = f;
        f = ah.f(context, R.raw.icons_filled_play_quickly, com.tencent.mm.plugin.emojicapture.ui.a.dg(this));
        j.o(f, "getColorDrawable(context…ickly, getIconSelColor())");
        this.lnl = f;
        f = ah.f(context, R.raw.icons_outlined_play_quickly, com.tencent.mm.plugin.emojicapture.ui.a.dh(this));
        j.o(f, "getColorDrawable(context…ickly, getIconNorColor())");
        this.lnm = f;
        f = ah.f(context, R.raw.icons_filled_add_emoji, com.tencent.mm.plugin.emojicapture.ui.a.dg(this));
        j.o(f, "getColorDrawable(context…emoji, getIconSelColor())");
        this.lnn = f;
        f = ah.f(context, R.raw.icons_outlined_add_emoji, com.tencent.mm.plugin.emojicapture.ui.a.dh(this));
        j.o(f, "getColorDrawable(context…emoji, getIconNorColor())");
        this.lno = f;
        this.lnd.setImageDrawable(this.lnk);
        this.lne.setImageDrawable(this.lnm);
        this.lnf.setImageDrawable(this.lno);
        this.lnh.setImageDrawable(ah.f(context, R.raw.icons_outlined_previous, com.tencent.mm.plugin.emojicapture.ui.a.dh(this)));
        this.lni.setImageDrawable(ah.f(context, R.raw.icons_filled_done, com.tencent.mm.plugin.emojicapture.ui.a.dg(this)));
        this.lna.setOnClickListener(new AnonymousClass1(this));
        this.lnb.setOnClickListener(new AnonymousClass2(this));
        this.lnc.setOnClickListener(new AnonymousClass3(this));
        findViewById(R.id.be0).setOnClickListener(new AnonymousClass4(this));
        findViewById(R.id.be2).setOnClickListener(new AnonymousClass5(this));
        setOnClickListener(new AnonymousClass6(this));
        this.lmY.setCallback(new AnonymousClass7(this));
        this.lmX.setStateChangeListener(new AnonymousClass8(this));
        SmileyPanel aR = u.aR(context);
        j.o(aR, "SmileyPanelFactory.getmSmileyPanel(context)");
        this.eAk = aR;
        ab.i(this.TAG, "initSmileyPanel " + this.eAk);
        this.eAk.setEntranceScene(ChatFooterPanel.vhl);
        this.eAk.setBackgroundResource(R.drawable.emoji_capture_smiley_panel_bg);
        this.eAk.AE();
        this.eAk.bf(true);
        this.eAk.j(true, true);
        this.eAk.setVisibility(8);
        this.eAk.onResume();
        t AH = u.AH();
        j.o(AH, "callbackWrapper");
        AH.a(new a(this));
        this.eAk.setCallback(AH);
        LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(getContext(), 230));
        layoutParams.addRule(12);
        addView(this.eAk, layoutParams);
        this.eAk.setTranslationY((float) layoutParams.height);
        this.lnq = new c(this);
        AppMethodBeat.o(3051);
    }

    public CaptureEditorContainer(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(3052);
        AppMethodBeat.o(3052);
    }

    public final com.tencent.mm.plugin.emojicapture.c.b.a getPresenter() {
        return this.lmT;
    }

    public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.b.a aVar) {
        this.lmT = aVar;
    }

    public final long getStartTick() {
        return this.eyR;
    }

    public final void setStartTick(long j) {
        this.eyR = j;
    }

    public final void a(com.tencent.mm.plugin.emojicapture.model.a.a aVar, String str, boolean z, boolean z2, a.f.a.a<y> aVar2) {
        AppMethodBeat.i(3040);
        j.p(aVar, "captureInfo");
        j.p(str, "videoPath");
        this.lmU = aVar;
        Context context = getContext();
        j.o(context, "context");
        this.lmW = new EmojiVideoPlayTextureView(context);
        this.lmV.addView(this.lmW);
        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.lmW;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.setRemoveBgEnable(z);
        }
        EmojiVideoPlayTextureView emojiVideoPlayTextureView2 = this.lmW;
        if (emojiVideoPlayTextureView2 != null) {
            emojiVideoPlayTextureView2.setVideoCallback(this.lnq);
        }
        emojiVideoPlayTextureView = this.lmW;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.setVideoPath(str);
        }
        emojiVideoPlayTextureView = this.lmW;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.setAlpha(0.0f);
        }
        if (z) {
            this.lna.setEnabled(true);
            this.lna.setAlpha(1.0f);
            this.lna.setSelected(z2);
            this.lnd.setImageDrawable(this.lna.isSelected() ? this.lnj : this.lnk);
        } else {
            this.lna.setEnabled(false);
            this.lna.setSelected(false);
            this.lnd.setImageDrawable(this.lnk);
            this.lna.setAlpha(0.3f);
        }
        this.lnp = aVar2;
        AppMethodBeat.o(3040);
    }

    public final void bmA() {
        AppMethodBeat.i(3041);
        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.lmW;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.setAlpha(1.0f);
        }
        EmojiCaptureReporter emojiCaptureReporter = this.lha;
        if (emojiCaptureReporter == null) {
            j.avw("reporter");
        }
        emojiCaptureReporter.lgN = System.currentTimeMillis();
        AppMethodBeat.o(3041);
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        AppMethodBeat.i(3042);
        j.p(emojiCaptureReporter, "reporter");
        this.lha = emojiCaptureReporter;
        this.lmY.setReporter(emojiCaptureReporter);
        AppMethodBeat.o(3042);
    }

    public final EmojiVideoPlayTextureView getVideoPlayView() {
        return this.lmW;
    }

    public final EditorItemContainer getItemContainer() {
        return this.lmX;
    }

    public final boolean aFF() {
        AppMethodBeat.i(3043);
        if (getVisibility() == 0) {
            AppMethodBeat.o(3043);
            return true;
        }
        AppMethodBeat.o(3043);
        return false;
    }

    public final boolean bmB() {
        AppMethodBeat.i(3044);
        if (this.lmY.getVisibility() == 0) {
            AppMethodBeat.o(3044);
            return true;
        }
        AppMethodBeat.o(3044);
        return false;
    }

    public final void a(boolean z, CharSequence charSequence, int i) {
        AppMethodBeat.i(3045);
        if (z) {
            this.lmY.setVisibility(0);
            EditorChangeTextView editorChangeTextView = this.lmY;
            editorChangeTextView.jgG.setText(charSequence);
            if (charSequence != null) {
                editorChangeTextView.jgG.setSelection(charSequence.length());
            }
            int k = a.a.i.k(com.tencent.mm.plugin.emojicapture.ui.a.bnQ(), i);
            if (k == -1) {
                k = 0;
            }
            editorChangeTextView.lnw.setSelected(k);
            editorChangeTextView.lnx = com.tencent.mm.plugin.emojicapture.ui.a.bnQ()[k];
            editorChangeTextView.lny = com.tencent.mm.plugin.emojicapture.ui.a.bnR()[k];
            editorChangeTextView.jgG.setTextColor(editorChangeTextView.lnx);
            editorChangeTextView.lnD = false;
            AppMethodBeat.o(3045);
            return;
        }
        this.lmY.cancel();
        AppMethodBeat.o(3045);
    }

    public final boolean bmC() {
        AppMethodBeat.i(3046);
        if (this.eAk.getVisibility() == 0) {
            AppMethodBeat.o(3046);
            return true;
        }
        AppMethodBeat.o(3046);
        return false;
    }

    public final void gC(boolean z) {
        AppMethodBeat.i(3047);
        float f = (float) this.eAk.getLayoutParams().height;
        if (z) {
            this.lnc.setSelected(true);
            this.eAk.setVisibility(0);
            this.eAk.animate().translationY(0.0f).start();
        } else {
            this.lnc.setSelected(false);
            this.eAk.animate().translationY(f).withEndAction(new b(this)).start();
        }
        this.lnf.setImageDrawable(this.lnc.isSelected() ? this.lnn : this.lno);
        AppMethodBeat.o(3047);
    }

    public final void reset() {
        AppMethodBeat.i(3048);
        this.lna.setSelected(false);
        this.lnb.setSelected(false);
        this.lnd.setImageDrawable(this.lnk);
        this.lne.setImageDrawable(this.lnm);
        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.lmW;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.stop();
        }
        this.lmV.removeView(this.lmW);
        this.lmW = null;
        AppMethodBeat.o(3048);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(3049);
        super.setVisibility(i);
        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.lmW;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.setVisibility(i);
            AppMethodBeat.o(3049);
            return;
        }
        AppMethodBeat.o(3049);
    }

    public final void destroy() {
        AppMethodBeat.i(3050);
        ab.i(this.TAG, "destroy " + this.eAk);
        this.eAk.destroy();
        AppMethodBeat.o(3050);
    }
}
