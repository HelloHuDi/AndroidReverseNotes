package com.tencent.p177mm.plugin.emojicapture.p389ui.editor;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C17918t;
import com.tencent.p177mm.api.C17918t.C17917a;
import com.tencent.p177mm.api.C41757u;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.api.SmileyPanel;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C27800a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.C20443a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.EmojiVideoPlayTextureView;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.EditorChangeTextView.C11632a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.editor.EditorItemContainer.C11633b;
import com.tencent.p177mm.plugin.emojicapture.p949c.C11605b.C11606a;
import com.tencent.p177mm.plugin.emojicapture.p949c.C11605b.C11607b;
import com.tencent.p177mm.plugin.p468n.C34602i;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0003*\u00017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0011H\u0002J(\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0002J\b\u0010E\u001a\u00020?H\u0016J\b\u0010F\u001a\u00020\u001bH\u0016J\n\u0010G\u001a\u0004\u0018\u00010:H\u0016J\b\u0010H\u001a\u00020?H\u0002J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020JH\u0016J\b\u0010L\u001a\u00020JH\u0016J\b\u0010M\u001a\u00020?H\u0016J\u000e\u0010N\u001a\u00020?2\u0006\u0010(\u001a\u00020)J\u0010\u0010O\u001a\u00020?2\u0006\u0010P\u001a\u00020\nH\u0016J8\u0010Q\u001a\u00020?2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020J2\u0006\u0010T\u001a\u00020J2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>H\u0016J\u0010\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u00020JH\u0016J\"\u0010W\u001a\u00020?2\u0006\u0010V\u001a\u00020J2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020\nH\u0016J\b\u0010[\u001a\u00020?H\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u000207X\u0004¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer */
public final class CaptureEditorContainer extends RelativeLayout implements C11607b {
    private final String TAG;
    private final ChatFooterPanel eAk;
    private long eyR;
    private EmojiCaptureReporter lha;
    private C11606a lmT;
    private C27800a lmU;
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
    private C31214a<C37091y> lnp;
    private final C38922c lnq;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$4 */
    static final class C29634 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        C29634(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(3028);
            C11606a presenter = this.lnr.getPresenter();
            if (presenter != null) {
                presenter.mo23335Ab();
                AppMethodBeat.m2505o(3028);
                return;
            }
            AppMethodBeat.m2505o(3028);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$5 */
    static final class C29645 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        C29645(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(3029);
            CaptureEditorContainer.m66068c(this.lnr).lgR = System.currentTimeMillis() - CaptureEditorContainer.m66068c(this.lnr).lgN;
            EmojiCaptureReporter.m66031a(17, CaptureEditorContainer.m66068c(this.lnr).ezZ, 0, 0, CaptureEditorContainer.m66068c(this.lnr).lgR, 0, 0, 0, 0, CaptureEditorContainer.m66068c(this.lnr).scene);
            EmojiCaptureReporter.m66038up(3);
            C11606a presenter = this.lnr.getPresenter();
            if (presenter != null) {
                presenter.bmz();
                AppMethodBeat.m2505o(3029);
                return;
            }
            AppMethodBeat.m2505o(3029);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$6 */
    static final class C29656 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        C29656(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(3030);
            if (this.lnr.bmC()) {
                this.lnr.mo23353gC(false);
            }
            AppMethodBeat.m2505o(3030);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$a */
    public static final class C2966a implements C17917a {
        final /* synthetic */ CaptureEditorContainer lnr;

        C2966a(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        /* renamed from: a */
        public final void mo7169a(C8955k c8955k) {
            AppMethodBeat.m2504i(3034);
            C25052j.m39376p(c8955k, "emojiInfo");
            C4990ab.m7417i(this.lnr.TAG, "[onSelectedEmoji] emojiInfo:%s", c8955k);
            C11606a presenter = this.lnr.getPresenter();
            if (presenter != null) {
                presenter.mo23341c(c8955k);
            }
            onHide();
            AppMethodBeat.m2505o(3034);
        }

        public final void onHide() {
            AppMethodBeat.m2504i(3035);
            this.lnr.mo23353gC(false);
            AppMethodBeat.m2505o(3035);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$3 */
    static final class C204563 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        C204563(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(3027);
            EmojiCaptureReporter.m66031a(12, CaptureEditorContainer.m66068c(this.lnr).ezZ, 0, 0, 0, 0, 0, 0, 0, CaptureEditorContainer.m66068c(this.lnr).scene);
            this.lnr.mo23353gC(!this.lnr.bmC());
            AppMethodBeat.m2505o(3027);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$7", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "onCancel", "", "onConfirm", "text", "", "color", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$7 */
    public static final class C340187 implements C11632a {
        final /* synthetic */ CaptureEditorContainer lnr;

        C340187(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        /* renamed from: i */
        public final void mo23379i(CharSequence charSequence, int i) {
            AppMethodBeat.m2504i(3031);
            String obj = charSequence != null ? charSequence.toString() : null;
            if (obj != null && obj.length() > 50) {
                obj = obj.substring(0, 50);
                C25052j.m39375o(obj, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            C11606a presenter = this.lnr.getPresenter();
            if (presenter != null) {
                presenter.mo23343n(obj, i, true);
            }
            this.lnr.lmY.setShow(false);
            AppMethodBeat.m2505o(3031);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(3032);
            C11606a presenter = this.lnr.getPresenter();
            if (presenter != null) {
                presenter.mo23343n(null, 0, false);
            }
            this.lnr.lmY.setShow(false);
            AppMethodBeat.m2505o(3032);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$8", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "onStateChange", "", "showDelete", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$8 */
    public static final class C340198 implements C11633b {
        final /* synthetic */ CaptureEditorContainer lnr;

        C340198(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        /* renamed from: gH */
        public final void mo23381gH(boolean z) {
            AppMethodBeat.m2504i(3033);
            if (z) {
                this.lnr.lmZ.setVisibility(8);
                AppMethodBeat.m2505o(3033);
                return;
            }
            this.lnr.lmZ.setVisibility(0);
            AppMethodBeat.m2505o(3033);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$b */
    static final class C34020b implements Runnable {
        final /* synthetic */ CaptureEditorContainer lnr;

        C34020b(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void run() {
            AppMethodBeat.m2504i(3036);
            this.lnr.eAk.setVisibility(8);
            AppMethodBeat.m2505o(3036);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$1 */
    static final class C389211 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        C389211(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(3025);
            EmojiCaptureReporter.m66031a(10, CaptureEditorContainer.m66068c(this.lnr).ezZ, 0, 0, 0, 0, 0, 0, 0, CaptureEditorContainer.m66068c(this.lnr).scene);
            View d = this.lnr.lna;
            C11606a presenter = this.lnr.getPresenter();
            d.setSelected(presenter != null ? presenter.bmx() : false);
            this.lnr.lnd.setImageDrawable(this.lnr.lna.isSelected() ? this.lnr.lnj : this.lnr.lnk);
            AppMethodBeat.m2505o(3025);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$c */
    public static final class C38922c implements C14981a {
        final /* synthetic */ CaptureEditorContainer lnr;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$c$a */
        static final class C11631a extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C38922c lns;

            C11631a(C38922c c38922c) {
                this.lns = c38922c;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(3037);
                EmojiVideoPlayTextureView n = this.lns.lnr.lmW;
                if (n != null) {
                    n.setVisibility(0);
                }
                C31214a o = this.lns.lnr.lnp;
                if (o != null) {
                    o.invoke();
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(3037);
                return c37091y;
            }
        }

        C38922c(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(3038);
            EmojiVideoPlayTextureView n = this.lnr.lmW;
            if (n != null) {
                n.setOneTimeVideoTextureUpdateCallback(new C11631a(this));
            }
            this.lnr.setStartTick(C5046bo.m7588yz());
            EmojiVideoPlayTextureView n2 = this.lnr.lmW;
            if (n2 != null) {
                n2.start();
                AppMethodBeat.m2505o(3038);
                return;
            }
            AppMethodBeat.m2505o(3038);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(3039);
            C4990ab.m7416i(this.lnr.TAG, "onCompletion cost " + C5046bo.m7525az(this.lnr.getStartTick()) + "ms");
            this.lnr.setStartTick(C5046bo.m7588yz());
            EmojiVideoPlayTextureView n = this.lnr.lmW;
            if (n != null) {
                n.llB = true;
                C34602i c34602i = n.llA;
                if (c34602i != null) {
                    c34602i.mo55186yI(0);
                    AppMethodBeat.m2505o(3039);
                    return;
                }
                AppMethodBeat.m2505o(3039);
                return;
            }
            AppMethodBeat.m2505o(3039);
        }

        /* renamed from: dG */
        public final int mo8554dG(int i, int i2) {
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
        }

        public final void onError(int i, int i2) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer$2 */
    static final class C389232 implements OnClickListener {
        final /* synthetic */ CaptureEditorContainer lnr;

        C389232(CaptureEditorContainer captureEditorContainer) {
            this.lnr = captureEditorContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(3026);
            EmojiCaptureReporter.m66031a(11, CaptureEditorContainer.m66068c(this.lnr).ezZ, 0, 0, 0, 0, 0, 0, 0, CaptureEditorContainer.m66068c(this.lnr).scene);
            View h = this.lnr.lnb;
            C11606a presenter = this.lnr.getPresenter();
            h.setSelected(presenter != null ? presenter.bmy() : false);
            this.lnr.lne.setImageDrawable(this.lnr.lnb.isSelected() ? this.lnr.lnl : this.lnr.lnm);
            AppMethodBeat.m2505o(3026);
        }
    }

    /* renamed from: c */
    public static final /* synthetic */ EmojiCaptureReporter m66068c(CaptureEditorContainer captureEditorContainer) {
        AppMethodBeat.m2504i(3053);
        EmojiCaptureReporter emojiCaptureReporter = captureEditorContainer.lha;
        if (emojiCaptureReporter == null) {
            C25052j.avw("reporter");
        }
        AppMethodBeat.m2505o(3053);
        return emojiCaptureReporter;
    }

    public CaptureEditorContainer(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(3051);
        this.TAG = "MicroMsg.CaptureEditorContainer";
        this.lmU = new C27800a();
        View.inflate(context, 2130969336, this);
        View findViewById = findViewById(2131823455);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_…e_video_play_view_layout)");
        this.lmV = (ViewGroup) findViewById;
        findViewById = findViewById(2131823456);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_item_container)");
        this.lmX = (EditorItemContainer) findViewById;
        findViewById = findViewById(2131823403);
        C25052j.m39375o(findViewById, "findViewById(R.id.change_text_root)");
        this.lmY = (EditorChangeTextView) findViewById;
        findViewById = findViewById(2131823457);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_type_root)");
        this.lmZ = findViewById;
        findViewById = findViewById(2131823458);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_remove_background)");
        this.lna = findViewById;
        findViewById = findViewById(2131823461);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_speed_up)");
        this.lnb = findViewById;
        findViewById = findViewById(2131823464);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_add_emoji)");
        this.lnc = findViewById;
        findViewById = findViewById(2131823459);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_remove_background_icon)");
        this.lnd = (ImageView) findViewById;
        findViewById = findViewById(2131823462);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_speed_up_icon)");
        this.lne = (ImageView) findViewById;
        findViewById = findViewById(2131823465);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_add_emoji_icon)");
        this.lnf = (ImageView) findViewById;
        findViewById = findViewById(2131823468);
        C25052j.m39375o(findViewById, "findViewById(R.id.to_capture)");
        this.lnh = (ImageView) findViewById;
        findViewById = findViewById(2131823470);
        C25052j.m39375o(findViewById, "findViewById(R.id.mix_video)");
        this.lni = (ImageView) findViewById;
        Drawable f = C5225ah.m7962f(context, C1318a.icons_filled_remove_bg, C20443a.m31592dg(this));
        C25052j.m39375o(f, "getColorDrawable(context…ve_bg, getIconSelColor())");
        this.lnj = f;
        f = C5225ah.m7962f(context, C1318a.icons_outlined_remove_bg, C20443a.m31593dh(this));
        C25052j.m39375o(f, "getColorDrawable(context…ve_bg, getIconNorColor())");
        this.lnk = f;
        f = C5225ah.m7962f(context, C1318a.icons_filled_play_quickly, C20443a.m31592dg(this));
        C25052j.m39375o(f, "getColorDrawable(context…ickly, getIconSelColor())");
        this.lnl = f;
        f = C5225ah.m7962f(context, C1318a.icons_outlined_play_quickly, C20443a.m31593dh(this));
        C25052j.m39375o(f, "getColorDrawable(context…ickly, getIconNorColor())");
        this.lnm = f;
        f = C5225ah.m7962f(context, C1318a.icons_filled_add_emoji, C20443a.m31592dg(this));
        C25052j.m39375o(f, "getColorDrawable(context…emoji, getIconSelColor())");
        this.lnn = f;
        f = C5225ah.m7962f(context, C1318a.icons_outlined_add_emoji, C20443a.m31593dh(this));
        C25052j.m39375o(f, "getColorDrawable(context…emoji, getIconNorColor())");
        this.lno = f;
        this.lnd.setImageDrawable(this.lnk);
        this.lne.setImageDrawable(this.lnm);
        this.lnf.setImageDrawable(this.lno);
        this.lnh.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_outlined_previous, C20443a.m31593dh(this)));
        this.lni.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_done, C20443a.m31592dg(this)));
        this.lna.setOnClickListener(new C389211(this));
        this.lnb.setOnClickListener(new C389232(this));
        this.lnc.setOnClickListener(new C204563(this));
        findViewById(2131823467).setOnClickListener(new C29634(this));
        findViewById(2131823469).setOnClickListener(new C29645(this));
        setOnClickListener(new C29656(this));
        this.lmY.setCallback(new C340187(this));
        this.lmX.setStateChangeListener(new C340198(this));
        SmileyPanel aR = C41757u.m73612aR(context);
        C25052j.m39375o(aR, "SmileyPanelFactory.getmSmileyPanel(context)");
        this.eAk = aR;
        C4990ab.m7416i(this.TAG, "initSmileyPanel " + this.eAk);
        this.eAk.setEntranceScene(ChatFooterPanel.vhl);
        this.eAk.setBackgroundResource(C25738R.drawable.emoji_capture_smiley_panel_bg);
        this.eAk.mo11688AE();
        this.eAk.mo11691bf(true);
        this.eAk.mo11696j(true, true);
        this.eAk.setVisibility(8);
        this.eAk.onResume();
        C17918t AH = C41757u.m73611AH();
        C25052j.m39375o(AH, "callbackWrapper");
        AH.mo33431a(new C2966a(this));
        this.eAk.setCallback(AH);
        LayoutParams layoutParams = new LayoutParams(-1, C1338a.fromDPToPix(getContext(), 230));
        layoutParams.addRule(12);
        addView(this.eAk, layoutParams);
        this.eAk.setTranslationY((float) layoutParams.height);
        this.lnq = new C38922c(this);
        AppMethodBeat.m2505o(3051);
    }

    public CaptureEditorContainer(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(3052);
        AppMethodBeat.m2505o(3052);
    }

    public final C11606a getPresenter() {
        return this.lmT;
    }

    public final void setPresenter(C11606a c11606a) {
        this.lmT = c11606a;
    }

    public final long getStartTick() {
        return this.eyR;
    }

    public final void setStartTick(long j) {
        this.eyR = j;
    }

    /* renamed from: a */
    public final void mo23346a(C27800a c27800a, String str, boolean z, boolean z2, C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(3040);
        C25052j.m39376p(c27800a, "captureInfo");
        C25052j.m39376p(str, "videoPath");
        this.lmU = c27800a;
        Context context = getContext();
        C25052j.m39375o(context, "context");
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
        this.lnp = c31214a;
        AppMethodBeat.m2505o(3040);
    }

    public final void bmA() {
        AppMethodBeat.m2504i(3041);
        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.lmW;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.setAlpha(1.0f);
        }
        EmojiCaptureReporter emojiCaptureReporter = this.lha;
        if (emojiCaptureReporter == null) {
            C25052j.avw("reporter");
        }
        emojiCaptureReporter.lgN = System.currentTimeMillis();
        AppMethodBeat.m2505o(3041);
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        AppMethodBeat.m2504i(3042);
        C25052j.m39376p(emojiCaptureReporter, "reporter");
        this.lha = emojiCaptureReporter;
        this.lmY.setReporter(emojiCaptureReporter);
        AppMethodBeat.m2505o(3042);
    }

    public final EmojiVideoPlayTextureView getVideoPlayView() {
        return this.lmW;
    }

    public final EditorItemContainer getItemContainer() {
        return this.lmX;
    }

    public final boolean aFF() {
        AppMethodBeat.m2504i(3043);
        if (getVisibility() == 0) {
            AppMethodBeat.m2505o(3043);
            return true;
        }
        AppMethodBeat.m2505o(3043);
        return false;
    }

    public final boolean bmB() {
        AppMethodBeat.m2504i(3044);
        if (this.lmY.getVisibility() == 0) {
            AppMethodBeat.m2505o(3044);
            return true;
        }
        AppMethodBeat.m2505o(3044);
        return false;
    }

    /* renamed from: a */
    public final void mo23347a(boolean z, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(3045);
        if (z) {
            this.lmY.setVisibility(0);
            EditorChangeTextView editorChangeTextView = this.lmY;
            editorChangeTextView.jgG.setText(charSequence);
            if (charSequence != null) {
                editorChangeTextView.jgG.setSelection(charSequence.length());
            }
            int k = C36913i.m61701k(C20443a.bnQ(), i);
            if (k == -1) {
                k = 0;
            }
            editorChangeTextView.lnw.setSelected(k);
            editorChangeTextView.lnx = C20443a.bnQ()[k];
            editorChangeTextView.lny = C20443a.bnR()[k];
            editorChangeTextView.jgG.setTextColor(editorChangeTextView.lnx);
            editorChangeTextView.lnD = false;
            AppMethodBeat.m2505o(3045);
            return;
        }
        this.lmY.cancel();
        AppMethodBeat.m2505o(3045);
    }

    public final boolean bmC() {
        AppMethodBeat.m2504i(3046);
        if (this.eAk.getVisibility() == 0) {
            AppMethodBeat.m2505o(3046);
            return true;
        }
        AppMethodBeat.m2505o(3046);
        return false;
    }

    /* renamed from: gC */
    public final void mo23353gC(boolean z) {
        AppMethodBeat.m2504i(3047);
        float f = (float) this.eAk.getLayoutParams().height;
        if (z) {
            this.lnc.setSelected(true);
            this.eAk.setVisibility(0);
            this.eAk.animate().translationY(0.0f).start();
        } else {
            this.lnc.setSelected(false);
            this.eAk.animate().translationY(f).withEndAction(new C34020b(this)).start();
        }
        this.lnf.setImageDrawable(this.lnc.isSelected() ? this.lnn : this.lno);
        AppMethodBeat.m2505o(3047);
    }

    public final void reset() {
        AppMethodBeat.m2504i(3048);
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
        AppMethodBeat.m2505o(3048);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(3049);
        super.setVisibility(i);
        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.lmW;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.setVisibility(i);
            AppMethodBeat.m2505o(3049);
            return;
        }
        AppMethodBeat.m2505o(3049);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(3050);
        C4990ab.m7416i(this.TAG, "destroy " + this.eAk);
        this.eAk.destroy();
        AppMethodBeat.m2505o(3050);
    }
}
