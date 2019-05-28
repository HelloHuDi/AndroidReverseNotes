package com.tencent.mm.plugin.story.ui.view;

import a.f.a.m;
import a.f.a.q;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.u;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.ui.a.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010B\u001a\u00020\u001aJ\b\u0010C\u001a\u0004\u0018\u00010DJ\b\u0010E\u001a\u00020\u001aH\u0002J\b\u0010F\u001a\u00020\u001aH\u0002J\u0006\u0010G\u001a\u00020\u001aJ\u000e\u0010H\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020\tJ\u0006\u0010J\u001a\u00020\u0010J\u0018\u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u00102\u0006\u00107\u001a\u00020\tH\u0016J\b\u0010M\u001a\u00020\u001aH\u0002J\u000e\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\tJ\u0010\u0010P\u001a\u00020\u001a2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u001a\u0010S\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010T\u001a\u00020\fJ\u0010\u0010U\u001a\u00020\u001a2\u0006\u0010V\u001a\u00020\u0010H\u0002J\u0010\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020\tH\u0016J\u000e\u0010Y\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020\u0010J\u0014\u0010[\u001a\u00020\u001a2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020!0]R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000Ra\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eRL\u0010\u001f\u001a4\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000¨\u0006_"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatar", "Landroid/widget/ImageView;", "canSend", "", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "commentInputCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "content", "success", "isReply", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function3;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function3;)V", "commentReplyCallback", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "comment", "getCommentReplyCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentReplyCallback", "(Lkotlin/jvm/functions/Function2;)V", "emojiBtn", "emojiRoot", "Landroid/widget/FrameLayout;", "fromUser", "Landroid/widget/TextView;", "hintTv", "inputLimit", "inputRootView", "Landroid/view/View;", "inputType", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "()Z", "setReply", "(Z)V", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideSoftInput", "initSmileyPanel", "notifyDataChanged", "notifyItemRemoved", "index", "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "scrollToPosition", "position", "setHostStory", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setInputHint", "toUser", "setKeyboardVisibility", "visible", "setVisibility", "visibility", "showCommentsList", "show", "updateComments", "storyComments", "", "Companion", "plugin-story_release"})
public final class StoryCommentInputView extends InputPanelFrameLayout {
    public static final a sjo = new a();
    private final String TAG;
    private final ChatFooterPanel eAk;
    private final TextView gKr;
    private final ImageView gvq;
    private final RecyclerView iJP;
    private int inputType;
    private final Runnable lnE;
    private final TextView seQ;
    private final FrameLayout sje;
    private final MMEditText sjf;
    private final ImageView sjg;
    private final TextView sjh;
    private boolean sji;
    private int sjj;
    private boolean sjk;
    private final int sjl;
    private final int sjm;
    final f sjr;
    private final View srw;
    boolean srx;
    private q<? super String, ? super Boolean, ? super Boolean, y> sry;
    private m<? super com.tencent.mm.plugin.story.model.b.a, ? super Boolean, y> srz;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$2 */
    public static final class AnonymousClass2 implements TextWatcher {
        final /* synthetic */ StoryCommentInputView sjp;

        AnonymousClass2(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(139089);
            if (editable != null) {
                int length = editable.length();
                int i = 60 - length;
                StoryCommentInputView storyCommentInputView = this.sjp;
                boolean z = (((CharSequence) editable).length() > 0 ? 1 : 0) != 0 && i >= 0 && this.sjp.sjf.getLineCount() <= 10;
                storyCommentInputView.sjk = z;
                if (length >= 55) {
                    this.sjp.sjh.setVisibility(0);
                    this.sjp.sjh.setText(String.valueOf(i));
                    if (i >= 0) {
                        this.sjp.sjh.setTextColor(this.sjp.sjl);
                        AppMethodBeat.o(139089);
                        return;
                    }
                    this.sjp.sjh.setTextColor(this.sjp.sjm);
                    AppMethodBeat.o(139089);
                    return;
                }
                this.sjp.sjh.setVisibility(8);
                AppMethodBeat.o(139089);
                return;
            }
            this.sjp.sjk = false;
            this.sjp.sjh.setVisibility(8);
            AppMethodBeat.o(139089);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$6 */
    static final class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ StoryCommentInputView sjp;

        AnonymousClass6(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(139091);
            StoryCommentInputView.b(this.sjp, false);
            q commentInputCallback = this.sjp.getCommentInputCallback();
            if (commentInputCallback != null) {
                commentInputCallback.g("", Boolean.FALSE, Boolean.valueOf(this.sjp.srx));
                AppMethodBeat.o(139091);
                return;
            }
            AppMethodBeat.o(139091);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView$Companion;", "", "()V", "InputEmoji", "", "InputEmojiLater", "InputKeyboard", "InputKeyboardLater", "InputLimit", "InputNone", "MinShowLimit", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$5 */
    static final class AnonymousClass5 implements OnEditorActionListener {
        final /* synthetic */ StoryCommentInputView sjp;

        AnonymousClass5(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
        }

        /* JADX WARNING: Missing block: B:3:0x0015, code skipped:
            if (r8.getAction() == 66) goto L_0x0017;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.i(139090);
            if (4 != i) {
                j.o(keyEvent, "keyEvent");
            }
            if (this.sjp.sjk) {
                h hVar = h.scu;
                h.EX(9);
                Editable text = this.sjp.sjf.getText();
                if (text != null) {
                    StoryCommentInputView.i(this.sjp);
                    q commentInputCallback = this.sjp.getCommentInputCallback();
                    if (commentInputCallback != null) {
                        commentInputCallback.g(text.toString(), Boolean.TRUE, Boolean.valueOf(this.sjp.srx));
                    }
                }
            }
            AppMethodBeat.o(139090);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "isReply", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$1 */
    static final class AnonymousClass1 extends k implements m<com.tencent.mm.plugin.story.model.b.a, Boolean, y> {
        final /* synthetic */ StoryCommentInputView sjp;

        AnonymousClass1(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(139088);
            com.tencent.mm.plugin.story.model.b.a aVar = (com.tencent.mm.plugin.story.model.b.a) obj;
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            j.p(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            m commentReplyCallback = this.sjp.getCommentReplyCallback();
            if (commentReplyCallback != null) {
                commentReplyCallback.m(aVar, Boolean.valueOf(booleanValue));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(139088);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ StoryCommentInputView sjp;

        c(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
        }

        public final void run() {
            AppMethodBeat.i(110394);
            InputMethodManager inputMethodManager = (InputMethodManager) this.sjp.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.sjp.sjf, 0);
                AppMethodBeat.o(110394);
                return;
            }
            AppMethodBeat.o(110394);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ int exi;
        final /* synthetic */ StoryCommentInputView sjp;

        d(StoryCommentInputView storyCommentInputView, int i) {
            this.sjp = storyCommentInputView;
            this.exi = i;
        }

        public final void run() {
            AppMethodBeat.i(139092);
            this.sjp.iJP.getLayoutManager().bY(this.exi);
            AppMethodBeat.o(139092);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, dWq = {"com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"})
    public static final class b implements com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a {
        final /* synthetic */ StoryCommentInputView sjp;

        b(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
        }

        public final void append(String str) {
            AppMethodBeat.i(110392);
            this.sjp.sjf.asB(str);
            AppMethodBeat.o(110392);
        }

        public final void aRg() {
            AppMethodBeat.i(110393);
            this.sjp.sjf.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
            this.sjp.sjf.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.o(110393);
        }

        public final void fC(boolean z) {
        }

        public final void aYY() {
        }
    }

    static {
        AppMethodBeat.i(110403);
        AppMethodBeat.o(110403);
    }

    public static final /* synthetic */ void b(StoryCommentInputView storyCommentInputView, boolean z) {
        AppMethodBeat.i(110404);
        storyCommentInputView.setKeyboardVisibility(z);
        AppMethodBeat.o(110404);
    }

    public StoryCommentInputView(final Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110400);
        this.TAG = "MicroMsg.StoryCommentInputView";
        View.inflate(context, R.layout.ay5, this);
        setClickable(true);
        View findViewById = findViewById(R.id.era);
        j.o(findViewById, "findViewById(R.id.story_comment_emoji_root)");
        this.sje = (FrameLayout) findViewById;
        findViewById = findViewById(R.id.er7);
        j.o(findViewById, "findViewById(R.id.story_comment_input)");
        this.sjf = (MMEditText) findViewById;
        findViewById = findViewById(R.id.er9);
        j.o(findViewById, "findViewById(R.id.story_comment_emoji_btn)");
        this.sjg = (ImageView) findViewById;
        findViewById = findViewById(R.id.er5);
        j.o(findViewById, "findViewById(R.id.story_comment_input_avatar)");
        this.gvq = (ImageView) findViewById;
        findViewById = findViewById(R.id.er6);
        j.o(findViewById, "findViewById(R.id.story_comment_input_username)");
        this.seQ = (TextView) findViewById;
        findViewById = findViewById(R.id.er8);
        j.o(findViewById, "findViewById(R.id.story_comment_input_limit)");
        this.sjh = (TextView) findViewById;
        findViewById = findViewById(R.id.er4);
        j.o(findViewById, "findViewById(R.id.story_comment_input_hint)");
        this.gKr = (TextView) findViewById;
        findViewById = findViewById(R.id.fma);
        j.o(findViewById, "findViewById(R.id.story_comment_input_recycler)");
        this.iJP = (RecyclerView) findViewById;
        findViewById = findViewById(R.id.fm_);
        j.o(findViewById, "findViewById(R.id.story_comment_input_root)");
        this.srw = findViewById;
        this.sjr = new f();
        this.iJP.setLayoutManager(new LinearLayoutManager());
        this.iJP.setAdapter(this.sjr);
        this.iJP.setVisibility(8);
        this.iJP.setFocusable(false);
        this.sjr.sfI = new AnonymousClass1(this);
        this.sjl = getResources().getColor(R.color.a2a);
        this.sjm = getResources().getColor(R.color.ct);
        ImageView imageView = this.gvq;
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.pluginsdk.ui.a.b.r(imageView, com.tencent.mm.plugin.story.model.j.a.cnk());
        SmileyPanel i2 = u.i(context, true);
        j.o(i2, "SmileyPanelFactory.getSmileyPanel(context, true)");
        this.eAk = i2;
        this.sjj = x.gs(getContext());
        this.sje.addView(this.eAk, new LayoutParams(-1, this.sjj));
        this.eAk.setPortHeightPx(this.sjj);
        this.eAk.setEntranceScene(ChatFooterPanel.vhm);
        this.eAk.AD();
        this.eAk.bf(false);
        this.eAk.setVisibility(0);
        this.eAk.setOnTextOperationListener(new b(this));
        this.sjf.addTextChangedListener(new AnonymousClass2(this));
        this.srw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StoryCommentInputView sjp;

            public final void onClick(View view) {
                AppMethodBeat.i(110390);
                if (!this.sjp.sji) {
                    this.sjp.inputType = 2;
                    StoryCommentInputView.b(this.sjp, true);
                    this.sjp.sjg.setImageDrawable(ah.f(context, R.raw.icons_filled_sticker, -1));
                }
                AppMethodBeat.o(110390);
            }
        });
        this.sjg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StoryCommentInputView sjp;

            public final void onClick(View view) {
                AppMethodBeat.i(110391);
                if (this.sjp.inputType == 0) {
                    this.sjp.inputType = 2;
                    StoryCommentInputView.b(this.sjp, true);
                    this.sjp.sjg.setImageDrawable(ah.f(context, R.raw.icons_filled_sticker, -1));
                    AppMethodBeat.o(110391);
                    return;
                }
                if (this.sjp.sji) {
                    this.sjp.inputType = 0;
                    StoryCommentInputView.b(this.sjp, false);
                } else {
                    this.sjp.inputType = 0;
                    this.sjp.sje.setVisibility(0);
                }
                this.sjp.sjg.setImageDrawable(ah.f(context, R.raw.icons_filled_keyboard, -1));
                AppMethodBeat.o(110391);
            }
        });
        this.sjf.setOnEditorActionListener(new AnonymousClass5(this));
        setOnClickListener(new AnonymousClass6(this));
        this.sjg.setImageDrawable(ah.f(context, R.raw.icons_filled_sticker, -1));
        this.sje.setVisibility(0);
        this.sjk = false;
        TextView textView = this.seQ;
        e RP = g.RP();
        j.o(RP, "storage()");
        Object obj = RP.Ry().get(4);
        if (obj == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(110400);
            throw vVar;
        }
        textView.setText(com.tencent.mm.pluginsdk.ui.e.j.b(context, (CharSequence) (String) obj, this.seQ.getTextSize()));
        this.inputType = 2;
        this.lnE = new c(this);
        AppMethodBeat.o(110400);
    }

    public StoryCommentInputView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110401);
        AppMethodBeat.o(110401);
    }

    public StoryCommentInputView(Context context) {
        j.p(context, "context");
        this(context, null);
        AppMethodBeat.i(110402);
        AppMethodBeat.o(110402);
    }

    public final void setReply(boolean z) {
        this.srx = z;
    }

    public final q<String, Boolean, Boolean, y> getCommentInputCallback() {
        return this.sry;
    }

    public final void setCommentInputCallback(q<? super String, ? super Boolean, ? super Boolean, y> qVar) {
        this.sry = qVar;
    }

    public final m<com.tencent.mm.plugin.story.model.b.a, Boolean, y> getCommentReplyCallback() {
        return this.srz;
    }

    public final void setCommentReplyCallback(m<? super com.tencent.mm.plugin.story.model.b.a, ? super Boolean, y> mVar) {
        this.srz = mVar;
    }

    public final void e(CharSequence charSequence, String str) {
        String string;
        String Oj;
        String stringBuilder;
        AppMethodBeat.i(139093);
        j.p(str, "toUser");
        this.sjf.setText(com.tencent.mm.pluginsdk.ui.e.j.b(getContext(), charSequence, this.sjf.getTextSize()));
        if (charSequence != null) {
            this.sjf.setSelection(charSequence.length());
        }
        String string2;
        if (this.srx) {
            CharSequence charSequence2;
            string = getResources().getString(R.string.g_q);
            j.o(string, "resources.getString(R.st…story_reply_visible_hint)");
            string2 = getResources().getString(R.string.g_p);
            j.o(string2, "resources.getString(R.st…_reply_visible_edit_hint)");
            com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(str);
            StringBuilder append = new StringBuilder().append(getResources().getString(R.string.g_p)).append(' ');
            Context context = this.seQ.getContext();
            if (aoO != null) {
                Oj = aoO.Oj();
                if (Oj != null) {
                    charSequence2 = Oj;
                    stringBuilder = append.append(com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence2, this.seQ.getTextSize())).toString();
                    Oj = string2;
                }
            }
            charSequence2 = "";
            stringBuilder = append.append(com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence2, this.seQ.getTextSize())).toString();
            Oj = string2;
        } else {
            string = getResources().getString(R.string.esd);
            j.o(string, "resources.getString(R.st…ory_comment_visible_hint)");
            string2 = getResources().getString(R.string.g_5);
            j.o(string2, "resources.getString(R.st…omment_visible_edit_hint)");
            Context context2 = getContext();
            e RP = g.RP();
            j.o(RP, "storage()");
            Object obj = RP.Ry().get(4);
            if (obj == null) {
                v vVar = new v("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(139093);
                throw vVar;
            }
            stringBuilder = String.valueOf(com.tencent.mm.pluginsdk.ui.e.j.b(context2, (CharSequence) (String) obj, this.seQ.getTextSize()));
            Oj = string2;
        }
        this.sjf.setHint(Oj);
        this.gKr.setText(string);
        this.seQ.setText(stringBuilder);
        AppMethodBeat.o(139093);
    }

    public final void ge(List<com.tencent.mm.plugin.story.model.b.a> list) {
        AppMethodBeat.i(139095);
        j.p(list, "storyComments");
        list.isEmpty();
        this.sjr.dI(list);
        AppMethodBeat.o(139095);
    }

    public final CharSequence getContent() {
        AppMethodBeat.i(110396);
        Editable text = this.sjf.getText();
        CharSequence obj = text != null ? text.toString() : null;
        AppMethodBeat.o(110396);
        return obj;
    }

    public final void bY(int i) {
        AppMethodBeat.i(139096);
        this.iJP.post(new d(this, i));
        AppMethodBeat.o(139096);
    }

    public final void setHostStory(com.tencent.mm.plugin.story.h.j jVar) {
        this.sjr.sfH = jVar;
    }

    public final void rh(boolean z) {
        AppMethodBeat.i(139097);
        if (z) {
            this.iJP.setVisibility(0);
            AppMethodBeat.o(139097);
            return;
        }
        this.iJP.setVisibility(8);
        AppMethodBeat.o(139097);
    }

    public final void destroy() {
        AppMethodBeat.i(139098);
        this.sjr.dI(new ArrayList());
        this.sjr.notifyDataSetChanged();
        this.eAk.destroy();
        AppMethodBeat.o(139098);
    }

    private final void setKeyboardVisibility(boolean z) {
        AppMethodBeat.i(110397);
        if (z) {
            post(this.lnE);
            AppMethodBeat.o(110397);
            return;
        }
        removeCallbacks(this.lnE);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(110397);
            return;
        }
        AppMethodBeat.o(110397);
    }

    public final void m(boolean z, int i) {
        AppMethodBeat.i(110398);
        super.m(z, i);
        this.sji = z;
        if (z) {
            this.inputType = 2;
            this.sje.setVisibility(4);
        } else if (this.inputType == 0) {
            this.sje.setVisibility(0);
        } else {
            this.sje.setVisibility(8);
            this.inputType = -1;
        }
        if (!(this.sjj == i || i == 0)) {
            this.sjj = i;
            com.tencent.mm.compatible.util.j.x(getContext(), i);
            int gs = x.gs(getContext());
            this.eAk.setPortHeightPx(gs);
            this.eAk.AG();
            ViewGroup.LayoutParams layoutParams = this.eAk.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = gs;
            }
        }
        AppMethodBeat.o(110398);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(110399);
        super.setVisibility(i);
        if (i == 0) {
            this.sjf.requestFocus();
        }
        AppMethodBeat.o(110399);
    }

    public static final /* synthetic */ void i(StoryCommentInputView storyCommentInputView) {
        AppMethodBeat.i(138902);
        InputMethodManager inputMethodManager = (InputMethodManager) storyCommentInputView.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(storyCommentInputView.getWindowToken(), 0);
            AppMethodBeat.o(138902);
            return;
        }
        AppMethodBeat.o(138902);
    }
}
