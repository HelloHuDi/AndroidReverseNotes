package com.tencent.p177mm.plugin.story.p536ui.view;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C41757u;
import com.tencent.p177mm.api.SmileyPanel;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.widget.InputPanelFrameLayout;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1035b.C39889a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C13817f;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.C44073a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010B\u001a\u00020\u001aJ\b\u0010C\u001a\u0004\u0018\u00010DJ\b\u0010E\u001a\u00020\u001aH\u0002J\b\u0010F\u001a\u00020\u001aH\u0002J\u0006\u0010G\u001a\u00020\u001aJ\u000e\u0010H\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020\tJ\u0006\u0010J\u001a\u00020\u0010J\u0018\u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u00102\u0006\u00107\u001a\u00020\tH\u0016J\b\u0010M\u001a\u00020\u001aH\u0002J\u000e\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\tJ\u0010\u0010P\u001a\u00020\u001a2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u001a\u0010S\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010T\u001a\u00020\fJ\u0010\u0010U\u001a\u00020\u001a2\u0006\u0010V\u001a\u00020\u0010H\u0002J\u0010\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020\tH\u0016J\u000e\u0010Y\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020\u0010J\u0014\u0010[\u001a\u00020\u001a2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020!0]R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000Ra\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eRL\u0010\u001f\u001a4\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000¨\u0006_"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatar", "Landroid/widget/ImageView;", "canSend", "", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "commentInputCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "content", "success", "isReply", "", "getCommentInputCallback", "()Lkotlin/jvm/functions/Function3;", "setCommentInputCallback", "(Lkotlin/jvm/functions/Function3;)V", "commentReplyCallback", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "comment", "getCommentReplyCallback", "()Lkotlin/jvm/functions/Function2;", "setCommentReplyCallback", "(Lkotlin/jvm/functions/Function2;)V", "emojiBtn", "emojiRoot", "Landroid/widget/FrameLayout;", "fromUser", "Landroid/widget/TextView;", "hintTv", "inputLimit", "inputRootView", "Landroid/view/View;", "inputType", "inputView", "Lcom/tencent/mm/ui/widget/MMEditText;", "isKeyboardShown", "()Z", "setReply", "(Z)V", "keyboardHeight", "limitHighLightColor", "limitNormalColor", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showImeRunnable", "Ljava/lang/Runnable;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "destroy", "getContent", "", "hideSoftInput", "initSmileyPanel", "notifyDataChanged", "notifyItemRemoved", "index", "onBack", "onInputPanelChange", "isKeyboardShow", "refreshBottomPanelHeight", "scrollToPosition", "position", "setHostStory", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setInputHint", "toUser", "setKeyboardVisibility", "visible", "setVisibility", "visibility", "showCommentsList", "show", "updateComments", "storyComments", "", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView */
public final class StoryCommentInputView extends InputPanelFrameLayout {
    public static final C22282a sjo = new C22282a();
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
    final C13817f sjr;
    private final View srw;
    boolean srx;
    private C36933q<? super String, ? super Boolean, ? super Boolean, C37091y> sry;
    private C31591m<? super C39889a, ? super Boolean, C37091y> srz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$2 */
    public static final class C222782 implements TextWatcher {
        final /* synthetic */ StoryCommentInputView sjp;

        C222782(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(139089);
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
                        AppMethodBeat.m2505o(139089);
                        return;
                    }
                    this.sjp.sjh.setTextColor(this.sjp.sjm);
                    AppMethodBeat.m2505o(139089);
                    return;
                }
                this.sjp.sjh.setVisibility(8);
                AppMethodBeat.m2505o(139089);
                return;
            }
            this.sjp.sjk = false;
            this.sjp.sjh.setVisibility(8);
            AppMethodBeat.m2505o(139089);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$6 */
    static final class C222816 implements OnClickListener {
        final /* synthetic */ StoryCommentInputView sjp;

        C222816(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(139091);
            StoryCommentInputView.m68353b(this.sjp, false);
            C36933q commentInputCallback = this.sjp.getCommentInputCallback();
            if (commentInputCallback != null) {
                commentInputCallback.mo9028g("", Boolean.FALSE, Boolean.valueOf(this.sjp.srx));
                AppMethodBeat.m2505o(139091);
                return;
            }
            AppMethodBeat.m2505o(139091);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView$Companion;", "", "()V", "InputEmoji", "", "InputEmojiLater", "InputKeyboard", "InputKeyboardLater", "InputLimit", "InputNone", "MinShowLimit", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$a */
    public static final class C22282a {
        private C22282a() {
        }

        public /* synthetic */ C22282a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "keyEvent", "Landroid/view/KeyEvent;", "onEditorAction"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$5 */
    static final class C293445 implements OnEditorActionListener {
        final /* synthetic */ StoryCommentInputView sjp;

        C293445(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
        }

        /* JADX WARNING: Missing block: B:3:0x0015, code skipped:
            if (r8.getAction() == 66) goto L_0x0017;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(139090);
            if (4 != i) {
                C25052j.m39375o(keyEvent, "keyEvent");
            }
            if (this.sjp.sjk) {
                C22212h c22212h = C22212h.scu;
                C22212h.m33888EX(9);
                Editable text = this.sjp.sjf.getText();
                if (text != null) {
                    StoryCommentInputView.m68361i(this.sjp);
                    C36933q commentInputCallback = this.sjp.getCommentInputCallback();
                    if (commentInputCallback != null) {
                        commentInputCallback.mo9028g(text.toString(), Boolean.TRUE, Boolean.valueOf(this.sjp.srx));
                    }
                }
            }
            AppMethodBeat.m2505o(139090);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "isReply", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$1 */
    static final class C399221 extends C25053k implements C31591m<C39889a, Boolean, C37091y> {
        final /* synthetic */ StoryCommentInputView sjp;

        C399221(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(139088);
            C39889a c39889a = (C39889a) obj;
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            C25052j.m39376p(c39889a, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            C31591m commentReplyCallback = this.sjp.getCommentReplyCallback();
            if (commentReplyCallback != null) {
                commentReplyCallback.mo212m(c39889a, Boolean.valueOf(booleanValue));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(139088);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$c */
    static final class C39923c implements Runnable {
        final /* synthetic */ StoryCommentInputView sjp;

        C39923c(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110394);
            InputMethodManager inputMethodManager = (InputMethodManager) this.sjp.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.sjp.sjf, 0);
                AppMethodBeat.m2505o(110394);
                return;
            }
            AppMethodBeat.m2505o(110394);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$d */
    static final class C39924d implements Runnable {
        final /* synthetic */ int exi;
        final /* synthetic */ StoryCommentInputView sjp;

        C39924d(StoryCommentInputView storyCommentInputView, int i) {
            this.sjp = storyCommentInputView;
            this.exi = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(139092);
            this.sjp.iJP.getLayoutManager().mo1762bY(this.exi);
            AppMethodBeat.m2505o(139092);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, dWq = {"com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$initSmileyPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryCommentInputView$b */
    public static final class C39925b implements C44073a {
        final /* synthetic */ StoryCommentInputView sjp;

        C39925b(StoryCommentInputView storyCommentInputView) {
            this.sjp = storyCommentInputView;
        }

        public final void append(String str) {
            AppMethodBeat.m2504i(110392);
            this.sjp.sjf.asB(str);
            AppMethodBeat.m2505o(110392);
        }

        public final void aRg() {
            AppMethodBeat.m2504i(110393);
            this.sjp.sjf.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
            this.sjp.sjf.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.m2505o(110393);
        }

        /* renamed from: fC */
        public final void mo24351fC(boolean z) {
        }

        public final void aYY() {
        }
    }

    static {
        AppMethodBeat.m2504i(110403);
        AppMethodBeat.m2505o(110403);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m68353b(StoryCommentInputView storyCommentInputView, boolean z) {
        AppMethodBeat.m2504i(110404);
        storyCommentInputView.setKeyboardVisibility(z);
        AppMethodBeat.m2505o(110404);
    }

    public StoryCommentInputView(final Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110400);
        this.TAG = "MicroMsg.StoryCommentInputView";
        View.inflate(context, 2130970868, this);
        setClickable(true);
        View findViewById = findViewById(2131828065);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_emoji_root)");
        this.sje = (FrameLayout) findViewById;
        findViewById = findViewById(2131828061);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_input)");
        this.sjf = (MMEditText) findViewById;
        findViewById = findViewById(2131828063);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_emoji_btn)");
        this.sjg = (ImageView) findViewById;
        findViewById = findViewById(2131828059);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_input_avatar)");
        this.gvq = (ImageView) findViewById;
        findViewById = findViewById(2131828060);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_input_username)");
        this.seQ = (TextView) findViewById;
        findViewById = findViewById(2131828062);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_input_limit)");
        this.sjh = (TextView) findViewById;
        findViewById = findViewById(2131828058);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_input_hint)");
        this.gKr = (TextView) findViewById;
        findViewById = findViewById(2131829249);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_input_recycler)");
        this.iJP = (RecyclerView) findViewById;
        findViewById = findViewById(2131829248);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_comment_input_root)");
        this.srw = findViewById;
        this.sjr = new C13817f();
        this.iJP.setLayoutManager(new LinearLayoutManager());
        this.iJP.setAdapter(this.sjr);
        this.iJP.setVisibility(8);
        this.iJP.setFocusable(false);
        this.sjr.sfI = new C399221(this);
        this.sjl = getResources().getColor(C25738R.color.a2a);
        this.sjm = getResources().getColor(C25738R.color.f11671ct);
        ImageView imageView = this.gvq;
        C4133a c4133a = C43644j.rST;
        C40460b.m69437r(imageView, C4133a.cnk());
        SmileyPanel i2 = C41757u.m73613i(context, true);
        C25052j.m39375o(i2, "SmileyPanelFactory.getSmileyPanel(context, true)");
        this.eAk = i2;
        this.sjj = C40619x.m70073gs(getContext());
        this.sje.addView(this.eAk, new LayoutParams(-1, this.sjj));
        this.eAk.setPortHeightPx(this.sjj);
        this.eAk.setEntranceScene(ChatFooterPanel.vhm);
        this.eAk.mo11687AD();
        this.eAk.mo11691bf(false);
        this.eAk.setVisibility(0);
        this.eAk.setOnTextOperationListener(new C39925b(this));
        this.sjf.addTextChangedListener(new C222782(this));
        this.srw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StoryCommentInputView sjp;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(110390);
                if (!this.sjp.sji) {
                    this.sjp.inputType = 2;
                    StoryCommentInputView.m68353b(this.sjp, true);
                    this.sjp.sjg.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_sticker, -1));
                }
                AppMethodBeat.m2505o(110390);
            }
        });
        this.sjg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StoryCommentInputView sjp;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(110391);
                if (this.sjp.inputType == 0) {
                    this.sjp.inputType = 2;
                    StoryCommentInputView.m68353b(this.sjp, true);
                    this.sjp.sjg.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_sticker, -1));
                    AppMethodBeat.m2505o(110391);
                    return;
                }
                if (this.sjp.sji) {
                    this.sjp.inputType = 0;
                    StoryCommentInputView.m68353b(this.sjp, false);
                } else {
                    this.sjp.inputType = 0;
                    this.sjp.sje.setVisibility(0);
                }
                this.sjp.sjg.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_keyboard, -1));
                AppMethodBeat.m2505o(110391);
            }
        });
        this.sjf.setOnEditorActionListener(new C293445(this));
        setOnClickListener(new C222816(this));
        this.sjg.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_sticker, -1));
        this.sje.setVisibility(0);
        this.sjk = false;
        TextView textView = this.seQ;
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "storage()");
        Object obj = RP.mo5239Ry().get(4);
        if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.m2505o(110400);
            throw c44941v;
        }
        textView.setText(C44089j.m79293b(context, (CharSequence) (String) obj, this.seQ.getTextSize()));
        this.inputType = 2;
        this.lnE = new C39923c(this);
        AppMethodBeat.m2505o(110400);
    }

    public StoryCommentInputView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110401);
        AppMethodBeat.m2505o(110401);
    }

    public StoryCommentInputView(Context context) {
        C25052j.m39376p(context, "context");
        this(context, null);
        AppMethodBeat.m2504i(110402);
        AppMethodBeat.m2505o(110402);
    }

    public final void setReply(boolean z) {
        this.srx = z;
    }

    public final C36933q<String, Boolean, Boolean, C37091y> getCommentInputCallback() {
        return this.sry;
    }

    public final void setCommentInputCallback(C36933q<? super String, ? super Boolean, ? super Boolean, C37091y> c36933q) {
        this.sry = c36933q;
    }

    public final C31591m<C39889a, Boolean, C37091y> getCommentReplyCallback() {
        return this.srz;
    }

    public final void setCommentReplyCallback(C31591m<? super C39889a, ? super Boolean, C37091y> c31591m) {
        this.srz = c31591m;
    }

    /* renamed from: e */
    public final void mo63112e(CharSequence charSequence, String str) {
        String string;
        String Oj;
        String stringBuilder;
        AppMethodBeat.m2504i(139093);
        C25052j.m39376p(str, "toUser");
        this.sjf.setText(C44089j.m79293b(getContext(), charSequence, this.sjf.getTextSize()));
        if (charSequence != null) {
            this.sjf.setSelection(charSequence.length());
        }
        String string2;
        if (this.srx) {
            CharSequence charSequence2;
            string = getResources().getString(C25738R.string.g_q);
            C25052j.m39375o(string, "resources.getString(R.st…story_reply_visible_hint)");
            string2 = getResources().getString(C25738R.string.g_p);
            C25052j.m39375o(string2, "resources.getString(R.st…_reply_visible_edit_hint)");
            C1694a K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
            C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
            StringBuilder append = new StringBuilder().append(getResources().getString(C25738R.string.g_p)).append(' ');
            Context context = this.seQ.getContext();
            if (aoO != null) {
                Oj = aoO.mo16707Oj();
                if (Oj != null) {
                    charSequence2 = Oj;
                    stringBuilder = append.append(C44089j.m79293b(context, charSequence2, this.seQ.getTextSize())).toString();
                    Oj = string2;
                }
            }
            charSequence2 = "";
            stringBuilder = append.append(C44089j.m79293b(context, charSequence2, this.seQ.getTextSize())).toString();
            Oj = string2;
        } else {
            string = getResources().getString(C25738R.string.esd);
            C25052j.m39375o(string, "resources.getString(R.st…ory_comment_visible_hint)");
            string2 = getResources().getString(C25738R.string.g_5);
            C25052j.m39375o(string2, "resources.getString(R.st…omment_visible_edit_hint)");
            Context context2 = getContext();
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "storage()");
            Object obj = RP.mo5239Ry().get(4);
            if (obj == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.m2505o(139093);
                throw c44941v;
            }
            stringBuilder = String.valueOf(C44089j.m79293b(context2, (CharSequence) (String) obj, this.seQ.getTextSize()));
            Oj = string2;
        }
        this.sjf.setHint(Oj);
        this.gKr.setText(string);
        this.seQ.setText(stringBuilder);
        AppMethodBeat.m2505o(139093);
    }

    /* renamed from: ge */
    public final void mo63113ge(List<C39889a> list) {
        AppMethodBeat.m2504i(139095);
        C25052j.m39376p(list, "storyComments");
        list.isEmpty();
        this.sjr.mo25997dI(list);
        AppMethodBeat.m2505o(139095);
    }

    public final CharSequence getContent() {
        AppMethodBeat.m2504i(110396);
        Editable text = this.sjf.getText();
        CharSequence obj = text != null ? text.toString() : null;
        AppMethodBeat.m2505o(110396);
        return obj;
    }

    /* renamed from: bY */
    public final void mo63110bY(int i) {
        AppMethodBeat.m2504i(139096);
        this.iJP.post(new C39924d(this, i));
        AppMethodBeat.m2505o(139096);
    }

    public final void setHostStory(C39879j c39879j) {
        this.sjr.sfH = c39879j;
    }

    /* renamed from: rh */
    public final void mo63117rh(boolean z) {
        AppMethodBeat.m2504i(139097);
        if (z) {
            this.iJP.setVisibility(0);
            AppMethodBeat.m2505o(139097);
            return;
        }
        this.iJP.setVisibility(8);
        AppMethodBeat.m2505o(139097);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(139098);
        this.sjr.mo25997dI(new ArrayList());
        this.sjr.notifyDataSetChanged();
        this.eAk.destroy();
        AppMethodBeat.m2505o(139098);
    }

    private final void setKeyboardVisibility(boolean z) {
        AppMethodBeat.m2504i(110397);
        if (z) {
            post(this.lnE);
            AppMethodBeat.m2505o(110397);
            return;
        }
        removeCallbacks(this.lnE);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.m2505o(110397);
            return;
        }
        AppMethodBeat.m2505o(110397);
    }

    /* renamed from: m */
    public final void mo39878m(boolean z, int i) {
        AppMethodBeat.m2504i(110398);
        super.mo39878m(z, i);
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
            C18175j.m28620x(getContext(), i);
            int gs = C40619x.m70073gs(getContext());
            this.eAk.setPortHeightPx(gs);
            this.eAk.mo11690AG();
            ViewGroup.LayoutParams layoutParams = this.eAk.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = gs;
            }
        }
        AppMethodBeat.m2505o(110398);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(110399);
        super.setVisibility(i);
        if (i == 0) {
            this.sjf.requestFocus();
        }
        AppMethodBeat.m2505o(110399);
    }

    /* renamed from: i */
    public static final /* synthetic */ void m68361i(StoryCommentInputView storyCommentInputView) {
        AppMethodBeat.m2504i(138902);
        InputMethodManager inputMethodManager = (InputMethodManager) storyCommentInputView.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(storyCommentInputView.getWindowToken(), 0);
            AppMethodBeat.m2505o(138902);
            return;
        }
        AppMethodBeat.m2505o(138902);
    }
}
