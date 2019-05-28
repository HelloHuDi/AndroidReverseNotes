package com.tencent.p177mm.plugin.story.p536ui.view.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.view.InsectRelativeLayout;
import com.tencent.p177mm.media.editor.p252a.C45428h;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.plugin.story.p530f.C22210l;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.C35242a;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.EditorFrameView;
import com.tencent.p177mm.protocal.protobuf.cei;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001%\u0018\u0000 h2\u00020\u0001:\u0002hiB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0013H\u0002J\u000e\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208J \u00109\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tJ\u0006\u0010>\u001a\u00020\u0013J\u0018\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0010H\u0002J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EJ\u0016\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IJ\u0016\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020IJ\u0010\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\tH\u0016J(\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\tH\u0014J\u0010\u0010U\u001a\u00020\u00132\u0006\u0010A\u001a\u00020BH\u0016J\u0006\u0010V\u001a\u00020\u0017J\u0016\u0010W\u001a\u00020\u00172\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010YJ\u000e\u0010Z\u001a\u00020\u00172\u0006\u00107\u001a\u000208J\u0016\u0010[\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u0013J\u0006\u0010]\u001a\u00020\u0017J\u0006\u0010^\u001a\u00020\u0017J\u000e\u0010_\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)J\u000e\u0010`\u001a\u00020\u00172\u0006\u0010-\u001a\u00020)J\u0010\u0010a\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0010\u0010c\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0010\u0010d\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0010\u0010e\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0010\u0010f\u001a\u00020\u00172\u0006\u0010g\u001a\u00020\u0013H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0004¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/PositionItemView;", "rightFrame", "textClickListener", "topFrame", "validArea", "Landroid/graphics/Rect;", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "addTextItem", "text", "", "textColor", "textBgColor", "checkAddLocationItem", "deleteCheck", "itemView", "event", "Landroid/view/MotionEvent;", "frameCheck", "getAllItemViews", "", "Lcom/tencent/mm/media/editor/item/IEditable;", "initHeightSafeArea", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "replaceLocationView", "requestEditing", "editing", "reset", "resume", "setOnLocationClick", "setOnTextClick", "showBottomFrame", "isShow", "showLeftFrame", "showRightFrame", "showTopFrame", "toggleDeleteView", "show", "Companion", "ItemStateResolve", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer */
public final class EditorItemContainer extends InsectRelativeLayout {
    public static final C22306a smV = new C22306a();
    private TextView lnH;
    public final ViewGroup lnI;
    public Runnable lnN;
    public final Rect smH;
    private ImageView smI;
    private ViewGroup smJ;
    private EditorFrameView smK;
    private EditorFrameView smL;
    private EditorFrameView smM;
    private EditorFrameView smN;
    private View smO;
    private C17126b<? super Boolean, C37091y> smP;
    private View smQ;
    public C46289e smR;
    private OnClickListener smS;
    public OnClickListener smT;
    public final C13875d smU;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer$d */
    public static final class C13875d implements C22305b {
        final /* synthetic */ EditorItemContainer smW;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer$d$a */
        static final class C13874a implements Runnable {
            final /* synthetic */ View lmb;
            final /* synthetic */ C13875d smX;

            C13874a(C13875d c13875d, View view) {
                this.smX = c13875d;
                this.lmb = view;
            }

            public final void run() {
                AppMethodBeat.m2504i(110633);
                this.smX.smW.lnI.removeView(this.smX.smW.smO);
                this.smX.smW.smO = null;
                this.smX.smW.smQ = null;
                if (this.lmb instanceof C46289e) {
                    this.smX.smW.smR = null;
                }
                AppMethodBeat.m2505o(110633);
            }
        }

        C13875d(EditorItemContainer editorItemContainer) {
            this.smW = editorItemContainer;
        }

        /* renamed from: e */
        public final void mo26047e(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(110634);
            C25052j.m39376p(view, "itemView");
            C25052j.m39376p(motionEvent, "event");
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.smW.removeCallbacks(this.smW.lnN);
                    if (view instanceof C46289e) {
                        this.smW.mo37837r(view, false);
                        AppMethodBeat.m2505o(110634);
                        return;
                    }
                    this.smW.mo37837r(view, true);
                    AppMethodBeat.m2505o(110634);
                    return;
                case 1:
                case 3:
                    C22212h c22212h;
                    if (view instanceof C46925b) {
                        c22212h = C22212h.scu;
                        C22212h.m33887EU(7);
                    }
                    if (view instanceof C39930f) {
                        c22212h = C22212h.scu;
                        C22212h.m33887EU(9);
                    }
                    if (view instanceof C46289e) {
                        c22212h = C22212h.scu;
                        C22212h.m33887EU(11);
                    }
                    if (this.smW.smO != null) {
                        this.smW.post(new C13874a(this, view));
                    } else if (this.smW.smQ != null) {
                        this.smW.postDelayed(this.smW.lnN, 1500);
                    }
                    EditorItemContainer.m33963a(this.smW, false);
                    EditorItemContainer.m33973i(this.smW);
                    EditorItemContainer.m33974j(this.smW);
                    EditorItemContainer.m33975k(this.smW);
                    EditorItemContainer.m33976l(this.smW);
                    break;
                case 2:
                    EditorItemContainer.m33962a(this.smW, view);
                    EditorItemContainer.m33964a(this.smW, view, motionEvent);
                    EditorItemContainer.m33963a(this.smW, true);
                    AppMethodBeat.m2505o(110634);
                    return;
            }
            AppMethodBeat.m2505o(110634);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer$f */
    public static final class C13876f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EditorItemContainer smW;
        final /* synthetic */ cei smY;

        public C13876f(EditorItemContainer editorItemContainer, cei cei) {
            this.smW = editorItemContainer;
            this.smY = cei;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(110636);
            this.smW.mo37829b(this.smY);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110636);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer$e */
    static final class C22304e implements Runnable {
        final /* synthetic */ C31214a lix;
        final /* synthetic */ EditorItemContainer smW;

        C22304e(EditorItemContainer editorItemContainer, C31214a c31214a) {
            this.smW = editorItemContainer;
            this.lix = c31214a;
        }

        public final void run() {
            AppMethodBeat.m2504i(110635);
            if (this.smW.smR != null) {
                this.smW.lnI.removeView(this.smW.smR);
            }
            this.smW.smR = null;
            C31214a c31214a = this.lix;
            if (c31214a != null) {
                c31214a.invoke();
                AppMethodBeat.m2505o(110635);
                return;
            }
            AppMethodBeat.m2505o(110635);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer$b */
    public interface C22305b {
        /* renamed from: e */
        void mo26047e(View view, MotionEvent motionEvent);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$Companion;", "", "()V", "ClearActiveDelay", "", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer$a */
    public static final class C22306a {
        private C22306a() {
        }

        public /* synthetic */ C22306a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer$c */
    static final class C22307c implements Runnable {
        final /* synthetic */ EditorItemContainer smW;

        C22307c(EditorItemContainer editorItemContainer) {
            this.smW = editorItemContainer;
        }

        public final void run() {
            AppMethodBeat.m2504i(110632);
            if (this.smW.smQ != null) {
                EditorItemContainer editorItemContainer = this.smW;
                View d = this.smW.smQ;
                if (d == null) {
                    C25052j.dWJ();
                }
                editorItemContainer.mo37837r(d, false);
            }
            AppMethodBeat.m2505o(110632);
        }
    }

    static {
        AppMethodBeat.m2504i(110656);
        AppMethodBeat.m2505o(110656);
    }

    /* renamed from: i */
    public static final /* synthetic */ void m33973i(EditorItemContainer editorItemContainer) {
        AppMethodBeat.m2504i(110660);
        editorItemContainer.m33977lP(false);
        AppMethodBeat.m2505o(110660);
    }

    /* renamed from: j */
    public static final /* synthetic */ void m33974j(EditorItemContainer editorItemContainer) {
        AppMethodBeat.m2504i(110661);
        editorItemContainer.m33978lQ(false);
        AppMethodBeat.m2505o(110661);
    }

    /* renamed from: k */
    public static final /* synthetic */ void m33975k(EditorItemContainer editorItemContainer) {
        AppMethodBeat.m2504i(110662);
        editorItemContainer.m33979lR(false);
        AppMethodBeat.m2505o(110662);
    }

    /* renamed from: l */
    public static final /* synthetic */ void m33976l(EditorItemContainer editorItemContainer) {
        AppMethodBeat.m2504i(110663);
        editorItemContainer.m33980lS(false);
        AppMethodBeat.m2505o(110663);
    }

    public EditorItemContainer(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110654);
        this.smH = new Rect();
        this.lnN = new C22307c(this);
        View.inflate(context, 2130970861, this);
        View findViewById = findViewById(2131828035);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_item_layout)");
        this.lnI = (ViewGroup) findViewById;
        findViewById = findViewById(2131823434);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_delete_view)");
        this.lnH = (TextView) findViewById;
        findViewById = findViewById(2131828037);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_delete_view_icon)");
        this.smI = (ImageView) findViewById;
        findViewById = findViewById(2131828036);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_delete_view_group)");
        this.smJ = (ViewGroup) findViewById;
        C22210l c22210l = C22210l.sac;
        Rect czI = C22210l.czI();
        Resources resources = getResources();
        C25052j.m39375o(resources, "resources");
        int i2 = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = getResources();
        C25052j.m39375o(resources2, "resources");
        czI.set(0, 0, i2, resources2.getDisplayMetrics().heightPixels);
        this.smU = new C13875d(this);
        AppMethodBeat.m2505o(110654);
    }

    public EditorItemContainer(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110655);
        AppMethodBeat.m2505o(110655);
    }

    public final C17126b<Boolean, C37091y> getDeleteStateListener() {
        return this.smP;
    }

    public final void setDeleteStateListener(C17126b<? super Boolean, C37091y> c17126b) {
        this.smP = c17126b;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(110637);
        super.onSizeChanged(i, i2, i3, i4);
        this.smH.set(0, 0, i, i2);
        AppMethodBeat.m2505o(110637);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(110638);
        C25052j.m39376p(motionEvent, "event");
        if (motionEvent.getActionMasked() == 0 && this.smQ != null) {
            View view = this.smQ;
            if (view == null) {
                C25052j.dWJ();
            }
            mo37837r(view, false);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(110638);
        return onTouchEvent;
    }

    /* renamed from: jn */
    public final boolean mo20726jn(int i) {
        AppMethodBeat.m2504i(110639);
        LayoutParams layoutParams = this.smJ.getLayoutParams();
        if (layoutParams == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.m2505o(110639);
            throw c44941v;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = C1338a.fromDPToPix(getContext(), 32) + i;
        this.smJ.setLayoutParams(marginLayoutParams);
        AppMethodBeat.m2505o(110639);
        return true;
    }

    public final boolean cCB() {
        return this.smR != null;
    }

    /* renamed from: b */
    public final void mo37829b(cei cei) {
        AppMethodBeat.m2504i(110640);
        C25052j.m39376p(cei, "sl");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        Context context = getContext();
        C25052j.m39375o(context, "context");
        this.smR = new C46289e(context);
        C46289e c46289e = this.smR;
        if (c46289e != null) {
            C22210l c22210l = C22210l.sac;
            c46289e.setSafeArea(C22210l.czI());
        }
        c46289e = this.smR;
        if (c46289e != null) {
            c46289e.setValidArea(this.smH);
        }
        c46289e = this.smR;
        if (c46289e != null) {
            c46289e.setLocation(cei);
        }
        C46289e c46289e2 = this.smR;
        if (c46289e2 != null) {
            c46289e2.setStateResolve(this.smU);
        }
        c46289e = this.smR;
        if (c46289e != null) {
            c46289e.setOnClickListener(this.smS);
        }
        this.lnI.addView(this.smR, layoutParams);
        c46289e = this.smR;
        if (c46289e == null) {
            C25052j.dWJ();
        }
        mo37837r(c46289e, false);
        removeCallbacks(this.lnN);
        postDelayed(this.lnN, 1500);
        AppMethodBeat.m2505o(110640);
    }

    /* renamed from: f */
    public final void mo37831f(C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(110641);
        post(new C22304e(this, c31214a));
        AppMethodBeat.m2505o(110641);
    }

    public final void setOnLocationClick(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(110642);
        C25052j.m39376p(onClickListener, "locationClickListener");
        this.smS = onClickListener;
        AppMethodBeat.m2505o(110642);
    }

    public final void setOnTextClick(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(110643);
        C25052j.m39376p(onClickListener, "textClickListener");
        this.smT = onClickListener;
        AppMethodBeat.m2505o(110643);
    }

    public final List<C45428h> getAllItemViews() {
        AppMethodBeat.m2504i(110644);
        List arrayList = new ArrayList();
        int childCount = this.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lnI.getChildAt(i);
            if (childAt instanceof C45428h) {
                arrayList.add(childAt);
            }
        }
        AppMethodBeat.m2505o(110644);
        return arrayList;
    }

    /* renamed from: r */
    public final void mo37837r(View view, boolean z) {
        AppMethodBeat.m2504i(110645);
        C25052j.m39376p(view, "itemView");
        if (z) {
            if ((C25052j.m39373j(view, this.smQ) ^ 1) != 0) {
                View view2 = this.smQ;
                if (view2 != null) {
                    view2.setActivated(false);
                }
                this.smQ = view;
            }
        } else if (C25052j.m39373j(view, this.smQ)) {
            this.smQ = null;
        }
        view.setActivated(z);
        AppMethodBeat.m2505o(110645);
    }

    /* renamed from: gI */
    public final void mo37832gI(boolean z) {
        AppMethodBeat.m2504i(110646);
        this.smJ.setVisibility(z ? 0 : 8);
        C17126b c17126b = this.smP;
        if (c17126b != null) {
            c17126b.mo50am(Boolean.valueOf(z));
            AppMethodBeat.m2505o(110646);
            return;
        }
        AppMethodBeat.m2505o(110646);
    }

    /* renamed from: gJ */
    private final void m33971gJ(boolean z) {
        AppMethodBeat.m2504i(110647);
        this.smJ.setActivated(z);
        if (z) {
            this.lnH.setText(C25738R.string.b8m);
            this.smI.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_filled_delete_on, -1));
            AppMethodBeat.m2505o(110647);
            return;
        }
        this.lnH.setText(C25738R.string.b8l);
        this.smI.setImageDrawable(C5225ah.m7962f(getContext(), C1318a.icons_filled_delete, -1));
        AppMethodBeat.m2505o(110647);
    }

    /* renamed from: ac */
    public final void mo37827ac(float f, float f2) {
        AppMethodBeat.m2504i(110648);
        Context context = getContext();
        C25052j.m39375o(context, "context");
        this.smK = new EditorFrameView(context);
        EditorFrameView editorFrameView = this.smK;
        if (editorFrameView != null) {
            editorFrameView.setPosition(C35242a.POSITION_LEFT);
        }
        editorFrameView = this.smK;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f2, -1);
        layoutParams.addRule(20);
        addView(this.smK, layoutParams);
        context = getContext();
        C25052j.m39375o(context, "context");
        this.smM = new EditorFrameView(context);
        editorFrameView = this.smM;
        if (editorFrameView != null) {
            editorFrameView.setPosition(C35242a.POSITION_RIGHT);
        }
        editorFrameView = this.smM;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(4);
        }
        layoutParams = new RelativeLayout.LayoutParams((int) f2, -1);
        layoutParams.addRule(21);
        addView(this.smM, layoutParams);
        C22210l c22210l = C22210l.sac;
        C22210l.czI().left = (int) f2;
        c22210l = C22210l.sac;
        C22210l.czI().right = ((int) f2) + ((int) f);
        StringBuilder stringBuilder = new StringBuilder("logStory: initWidthSafeArea safeAreaRect:");
        C22210l c22210l2 = C22210l.sac;
        C4990ab.m7416i("MicroMsg.EditorItemContainer", stringBuilder.append(C22210l.czI()).toString());
        AppMethodBeat.m2505o(110648);
    }

    /* renamed from: ad */
    public final void mo37828ad(float f, float f2) {
        AppMethodBeat.m2504i(110649);
        Context context = getContext();
        C25052j.m39375o(context, "context");
        this.smL = new EditorFrameView(context);
        EditorFrameView editorFrameView = this.smL;
        if (editorFrameView != null) {
            editorFrameView.setPosition(C35242a.POSITION_TOP);
        }
        editorFrameView = this.smL;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) f2);
        layoutParams.addRule(10);
        addView(this.smL, layoutParams);
        context = getContext();
        C25052j.m39375o(context, "context");
        this.smN = new EditorFrameView(context);
        editorFrameView = this.smN;
        if (editorFrameView != null) {
            editorFrameView.setPosition(C35242a.POSITION_BOTTOM);
        }
        editorFrameView = this.smN;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(4);
        }
        layoutParams = new RelativeLayout.LayoutParams(-1, (int) f2);
        layoutParams.addRule(12);
        addView(this.smN, layoutParams);
        C22210l c22210l = C22210l.sac;
        C22210l.czI().top = (int) f2;
        c22210l = C22210l.sac;
        C22210l.czI().bottom = ((int) f2) + ((int) f);
        StringBuilder stringBuilder = new StringBuilder("logStory: initHeightSafeArea safeAreaRect:");
        C22210l c22210l2 = C22210l.sac;
        C4990ab.m7416i("MicroMsg.EditorItemContainer", stringBuilder.append(C22210l.czI()).toString());
        AppMethodBeat.m2505o(110649);
    }

    /* renamed from: lP */
    private final void m33977lP(boolean z) {
        AppMethodBeat.m2504i(110650);
        EditorFrameView editorFrameView = this.smK;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.m2505o(110650);
            return;
        }
        AppMethodBeat.m2505o(110650);
    }

    /* renamed from: lQ */
    private final void m33978lQ(boolean z) {
        AppMethodBeat.m2504i(110651);
        EditorFrameView editorFrameView = this.smL;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.m2505o(110651);
            return;
        }
        AppMethodBeat.m2505o(110651);
    }

    /* renamed from: lR */
    private final void m33979lR(boolean z) {
        AppMethodBeat.m2504i(110652);
        EditorFrameView editorFrameView = this.smM;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.m2505o(110652);
            return;
        }
        AppMethodBeat.m2505o(110652);
    }

    /* renamed from: lS */
    private final void m33980lS(boolean z) {
        AppMethodBeat.m2504i(110653);
        EditorFrameView editorFrameView = this.smN;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.m2505o(110653);
            return;
        }
        AppMethodBeat.m2505o(110653);
    }

    /* renamed from: a */
    public static final /* synthetic */ boolean m33964a(EditorItemContainer editorItemContainer, View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(110658);
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        while (i < pointerCount) {
            float y = motionEvent.getY(i) + f2;
            f += motionEvent.getX(i);
            i++;
            f2 = y;
        }
        f /= (float) pointerCount;
        boolean z = editorItemContainer.smJ.getTop() > 0 && f2 / ((float) pointerCount) > ((float) editorItemContainer.smJ.getTop()) && ((float) editorItemContainer.smJ.getLeft()) < f && ((float) editorItemContainer.smJ.getRight()) > f;
        if (z) {
            editorItemContainer.m33971gJ(true);
            if (editorItemContainer.smO == null) {
                editorItemContainer.smO = view;
                view.animate().alpha(0.5f).setDuration(100).start();
            }
        } else {
            editorItemContainer.m33971gJ(false);
            if (editorItemContainer.smO != null) {
                editorItemContainer.smO = null;
                view.animate().alpha(1.0f).setDuration(100).start();
            }
        }
        AppMethodBeat.m2505o(110658);
        return z;
    }
}
