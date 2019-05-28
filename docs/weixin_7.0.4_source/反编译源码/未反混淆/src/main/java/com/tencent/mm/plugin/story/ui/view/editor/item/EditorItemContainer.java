package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
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
import com.tencent.mm.R;
import com.tencent.mm.emoji.view.InsectRelativeLayout;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.ui.view.editor.EditorFrameView;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.ah;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001%\u0018\u0000 h2\u00020\u0001:\u0002hiB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0013H\u0002J\u000e\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208J \u00109\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tJ\u0006\u0010>\u001a\u00020\u0013J\u0018\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0010H\u0002J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EJ\u0016\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IJ\u0016\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020IJ\u0010\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\tH\u0016J(\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\tH\u0014J\u0010\u0010U\u001a\u00020\u00132\u0006\u0010A\u001a\u00020BH\u0016J\u0006\u0010V\u001a\u00020\u0017J\u0016\u0010W\u001a\u00020\u00172\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010YJ\u000e\u0010Z\u001a\u00020\u00172\u0006\u00107\u001a\u000208J\u0016\u0010[\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u0013J\u0006\u0010]\u001a\u00020\u0017J\u0006\u0010^\u001a\u00020\u0017J\u000e\u0010_\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)J\u000e\u0010`\u001a\u00020\u00172\u0006\u0010-\u001a\u00020)J\u0010\u0010a\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0010\u0010c\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0010\u0010d\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0010\u0010e\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0010\u0010f\u001a\u00020\u00172\u0006\u0010g\u001a\u00020\u0013H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0004¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomFrame", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorFrameView;", "clearActive", "Ljava/lang/Runnable;", "currActiveItem", "Landroid/view/View;", "deleteStateListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "showDelete", "", "getDeleteStateListener", "()Lkotlin/jvm/functions/Function1;", "setDeleteStateListener", "(Lkotlin/jvm/functions/Function1;)V", "deleteView", "Landroid/widget/TextView;", "deleteViewGroup", "Landroid/view/ViewGroup;", "deleteViewIcon", "Landroid/widget/ImageView;", "deletingItem", "itemLayout", "itemStateResolve", "com/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$itemStateResolve$1;", "leftFrame", "locationClickListener", "Landroid/view/View$OnClickListener;", "locationView", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/PositionItemView;", "rightFrame", "textClickListener", "topFrame", "validArea", "Landroid/graphics/Rect;", "activeDeleteView", "active", "addEmojiItem", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "addLocationItem", "sl", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "addTextItem", "text", "", "textColor", "textBgColor", "checkAddLocationItem", "deleteCheck", "itemView", "event", "Landroid/view/MotionEvent;", "frameCheck", "getAllItemViews", "", "Lcom/tencent/mm/media/editor/item/IEditable;", "initHeightSafeArea", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "removeLocationView", "callback", "Lkotlin/Function0;", "replaceLocationView", "requestEditing", "editing", "reset", "resume", "setOnLocationClick", "setOnTextClick", "showBottomFrame", "isShow", "showLeftFrame", "showRightFrame", "showTopFrame", "toggleDeleteView", "show", "Companion", "ItemStateResolve", "plugin-story_release"})
public final class EditorItemContainer extends InsectRelativeLayout {
    public static final a smV = new a();
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
    private a.f.a.b<? super Boolean, y> smP;
    private View smQ;
    public e smR;
    private OnClickListener smS;
    public OnClickListener smT;
    public final d smU;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-story_release"})
    public static final class d implements b {
        final /* synthetic */ EditorItemContainer smW;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ View lmb;
            final /* synthetic */ d smX;

            a(d dVar, View view) {
                this.smX = dVar;
                this.lmb = view;
            }

            public final void run() {
                AppMethodBeat.i(110633);
                this.smX.smW.lnI.removeView(this.smX.smW.smO);
                this.smX.smW.smO = null;
                this.smX.smW.smQ = null;
                if (this.lmb instanceof e) {
                    this.smX.smW.smR = null;
                }
                AppMethodBeat.o(110633);
            }
        }

        d(EditorItemContainer editorItemContainer) {
            this.smW = editorItemContainer;
        }

        public final void e(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(110634);
            j.p(view, "itemView");
            j.p(motionEvent, "event");
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.smW.removeCallbacks(this.smW.lnN);
                    if (view instanceof e) {
                        this.smW.r(view, false);
                        AppMethodBeat.o(110634);
                        return;
                    }
                    this.smW.r(view, true);
                    AppMethodBeat.o(110634);
                    return;
                case 1:
                case 3:
                    h hVar;
                    if (view instanceof b) {
                        hVar = h.scu;
                        h.EU(7);
                    }
                    if (view instanceof f) {
                        hVar = h.scu;
                        h.EU(9);
                    }
                    if (view instanceof e) {
                        hVar = h.scu;
                        h.EU(11);
                    }
                    if (this.smW.smO != null) {
                        this.smW.post(new a(this, view));
                    } else if (this.smW.smQ != null) {
                        this.smW.postDelayed(this.smW.lnN, 1500);
                    }
                    EditorItemContainer.a(this.smW, false);
                    EditorItemContainer.i(this.smW);
                    EditorItemContainer.j(this.smW);
                    EditorItemContainer.k(this.smW);
                    EditorItemContainer.l(this.smW);
                    break;
                case 2:
                    EditorItemContainer.a(this.smW, view);
                    EditorItemContainer.a(this.smW, view, motionEvent);
                    EditorItemContainer.a(this.smW, true);
                    AppMethodBeat.o(110634);
                    return;
            }
            AppMethodBeat.o(110634);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class f extends k implements a.f.a.a<y> {
        final /* synthetic */ EditorItemContainer smW;
        final /* synthetic */ cei smY;

        public f(EditorItemContainer editorItemContainer, cei cei) {
            this.smW = editorItemContainer;
            this.smY = cei;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(110636);
            this.smW.b(this.smY);
            y yVar = y.AUy;
            AppMethodBeat.o(110636);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ a.f.a.a lix;
        final /* synthetic */ EditorItemContainer smW;

        e(EditorItemContainer editorItemContainer, a.f.a.a aVar) {
            this.smW = editorItemContainer;
            this.lix = aVar;
        }

        public final void run() {
            AppMethodBeat.i(110635);
            if (this.smW.smR != null) {
                this.smW.lnI.removeView(this.smW.smR);
            }
            this.smW.smR = null;
            a.f.a.a aVar = this.lix;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(110635);
                return;
            }
            AppMethodBeat.o(110635);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-story_release"})
    public interface b {
        void e(View view, MotionEvent motionEvent);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$Companion;", "", "()V", "ClearActiveDelay", "", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ EditorItemContainer smW;

        c(EditorItemContainer editorItemContainer) {
            this.smW = editorItemContainer;
        }

        public final void run() {
            AppMethodBeat.i(110632);
            if (this.smW.smQ != null) {
                EditorItemContainer editorItemContainer = this.smW;
                View d = this.smW.smQ;
                if (d == null) {
                    j.dWJ();
                }
                editorItemContainer.r(d, false);
            }
            AppMethodBeat.o(110632);
        }
    }

    static {
        AppMethodBeat.i(110656);
        AppMethodBeat.o(110656);
    }

    public static final /* synthetic */ void i(EditorItemContainer editorItemContainer) {
        AppMethodBeat.i(110660);
        editorItemContainer.lP(false);
        AppMethodBeat.o(110660);
    }

    public static final /* synthetic */ void j(EditorItemContainer editorItemContainer) {
        AppMethodBeat.i(110661);
        editorItemContainer.lQ(false);
        AppMethodBeat.o(110661);
    }

    public static final /* synthetic */ void k(EditorItemContainer editorItemContainer) {
        AppMethodBeat.i(110662);
        editorItemContainer.lR(false);
        AppMethodBeat.o(110662);
    }

    public static final /* synthetic */ void l(EditorItemContainer editorItemContainer) {
        AppMethodBeat.i(110663);
        editorItemContainer.lS(false);
        AppMethodBeat.o(110663);
    }

    public EditorItemContainer(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110654);
        this.smH = new Rect();
        this.lnN = new c(this);
        View.inflate(context, R.layout.axy, this);
        View findViewById = findViewById(R.id.eqh);
        j.o(findViewById, "findViewById(R.id.editor_item_layout)");
        this.lnI = (ViewGroup) findViewById;
        findViewById = findViewById(R.id.bd4);
        j.o(findViewById, "findViewById(R.id.editor_delete_view)");
        this.lnH = (TextView) findViewById;
        findViewById = findViewById(R.id.eqj);
        j.o(findViewById, "findViewById(R.id.editor_delete_view_icon)");
        this.smI = (ImageView) findViewById;
        findViewById = findViewById(R.id.eqi);
        j.o(findViewById, "findViewById(R.id.editor_delete_view_group)");
        this.smJ = (ViewGroup) findViewById;
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
        Rect czI = com.tencent.mm.plugin.story.f.l.czI();
        Resources resources = getResources();
        j.o(resources, "resources");
        int i2 = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = getResources();
        j.o(resources2, "resources");
        czI.set(0, 0, i2, resources2.getDisplayMetrics().heightPixels);
        this.smU = new d(this);
        AppMethodBeat.o(110654);
    }

    public EditorItemContainer(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110655);
        AppMethodBeat.o(110655);
    }

    public final a.f.a.b<Boolean, y> getDeleteStateListener() {
        return this.smP;
    }

    public final void setDeleteStateListener(a.f.a.b<? super Boolean, y> bVar) {
        this.smP = bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(110637);
        super.onSizeChanged(i, i2, i3, i4);
        this.smH.set(0, 0, i, i2);
        AppMethodBeat.o(110637);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(110638);
        j.p(motionEvent, "event");
        if (motionEvent.getActionMasked() == 0 && this.smQ != null) {
            View view = this.smQ;
            if (view == null) {
                j.dWJ();
            }
            r(view, false);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(110638);
        return onTouchEvent;
    }

    public final boolean jn(int i) {
        AppMethodBeat.i(110639);
        LayoutParams layoutParams = this.smJ.getLayoutParams();
        if (layoutParams == null) {
            v vVar = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(110639);
            throw vVar;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = com.tencent.mm.bz.a.fromDPToPix(getContext(), 32) + i;
        this.smJ.setLayoutParams(marginLayoutParams);
        AppMethodBeat.o(110639);
        return true;
    }

    public final boolean cCB() {
        return this.smR != null;
    }

    public final void b(cei cei) {
        AppMethodBeat.i(110640);
        j.p(cei, "sl");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        Context context = getContext();
        j.o(context, "context");
        this.smR = new e(context);
        e eVar = this.smR;
        if (eVar != null) {
            com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
            eVar.setSafeArea(com.tencent.mm.plugin.story.f.l.czI());
        }
        eVar = this.smR;
        if (eVar != null) {
            eVar.setValidArea(this.smH);
        }
        eVar = this.smR;
        if (eVar != null) {
            eVar.setLocation(cei);
        }
        e eVar2 = this.smR;
        if (eVar2 != null) {
            eVar2.setStateResolve(this.smU);
        }
        eVar = this.smR;
        if (eVar != null) {
            eVar.setOnClickListener(this.smS);
        }
        this.lnI.addView(this.smR, layoutParams);
        eVar = this.smR;
        if (eVar == null) {
            j.dWJ();
        }
        r(eVar, false);
        removeCallbacks(this.lnN);
        postDelayed(this.lnN, 1500);
        AppMethodBeat.o(110640);
    }

    public final void f(a.f.a.a<y> aVar) {
        AppMethodBeat.i(110641);
        post(new e(this, aVar));
        AppMethodBeat.o(110641);
    }

    public final void setOnLocationClick(OnClickListener onClickListener) {
        AppMethodBeat.i(110642);
        j.p(onClickListener, "locationClickListener");
        this.smS = onClickListener;
        AppMethodBeat.o(110642);
    }

    public final void setOnTextClick(OnClickListener onClickListener) {
        AppMethodBeat.i(110643);
        j.p(onClickListener, "textClickListener");
        this.smT = onClickListener;
        AppMethodBeat.o(110643);
    }

    public final List<com.tencent.mm.media.editor.a.h> getAllItemViews() {
        AppMethodBeat.i(110644);
        List arrayList = new ArrayList();
        int childCount = this.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lnI.getChildAt(i);
            if (childAt instanceof com.tencent.mm.media.editor.a.h) {
                arrayList.add(childAt);
            }
        }
        AppMethodBeat.o(110644);
        return arrayList;
    }

    public final void r(View view, boolean z) {
        AppMethodBeat.i(110645);
        j.p(view, "itemView");
        if (z) {
            if ((j.j(view, this.smQ) ^ 1) != 0) {
                View view2 = this.smQ;
                if (view2 != null) {
                    view2.setActivated(false);
                }
                this.smQ = view;
            }
        } else if (j.j(view, this.smQ)) {
            this.smQ = null;
        }
        view.setActivated(z);
        AppMethodBeat.o(110645);
    }

    public final void gI(boolean z) {
        AppMethodBeat.i(110646);
        this.smJ.setVisibility(z ? 0 : 8);
        a.f.a.b bVar = this.smP;
        if (bVar != null) {
            bVar.am(Boolean.valueOf(z));
            AppMethodBeat.o(110646);
            return;
        }
        AppMethodBeat.o(110646);
    }

    private final void gJ(boolean z) {
        AppMethodBeat.i(110647);
        this.smJ.setActivated(z);
        if (z) {
            this.lnH.setText(R.string.b8m);
            this.smI.setImageDrawable(ah.f(getContext(), R.raw.icons_filled_delete_on, -1));
            AppMethodBeat.o(110647);
            return;
        }
        this.lnH.setText(R.string.b8l);
        this.smI.setImageDrawable(ah.f(getContext(), R.raw.icons_filled_delete, -1));
        AppMethodBeat.o(110647);
    }

    public final void ac(float f, float f2) {
        AppMethodBeat.i(110648);
        Context context = getContext();
        j.o(context, "context");
        this.smK = new EditorFrameView(context);
        EditorFrameView editorFrameView = this.smK;
        if (editorFrameView != null) {
            editorFrameView.setPosition(com.tencent.mm.plugin.story.ui.view.editor.a.POSITION_LEFT);
        }
        editorFrameView = this.smK;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f2, -1);
        layoutParams.addRule(20);
        addView(this.smK, layoutParams);
        context = getContext();
        j.o(context, "context");
        this.smM = new EditorFrameView(context);
        editorFrameView = this.smM;
        if (editorFrameView != null) {
            editorFrameView.setPosition(com.tencent.mm.plugin.story.ui.view.editor.a.POSITION_RIGHT);
        }
        editorFrameView = this.smM;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(4);
        }
        layoutParams = new RelativeLayout.LayoutParams((int) f2, -1);
        layoutParams.addRule(21);
        addView(this.smM, layoutParams);
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
        com.tencent.mm.plugin.story.f.l.czI().left = (int) f2;
        lVar = com.tencent.mm.plugin.story.f.l.sac;
        com.tencent.mm.plugin.story.f.l.czI().right = ((int) f2) + ((int) f);
        StringBuilder stringBuilder = new StringBuilder("logStory: initWidthSafeArea safeAreaRect:");
        com.tencent.mm.plugin.story.f.l lVar2 = com.tencent.mm.plugin.story.f.l.sac;
        ab.i("MicroMsg.EditorItemContainer", stringBuilder.append(com.tencent.mm.plugin.story.f.l.czI()).toString());
        AppMethodBeat.o(110648);
    }

    public final void ad(float f, float f2) {
        AppMethodBeat.i(110649);
        Context context = getContext();
        j.o(context, "context");
        this.smL = new EditorFrameView(context);
        EditorFrameView editorFrameView = this.smL;
        if (editorFrameView != null) {
            editorFrameView.setPosition(com.tencent.mm.plugin.story.ui.view.editor.a.POSITION_TOP);
        }
        editorFrameView = this.smL;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) f2);
        layoutParams.addRule(10);
        addView(this.smL, layoutParams);
        context = getContext();
        j.o(context, "context");
        this.smN = new EditorFrameView(context);
        editorFrameView = this.smN;
        if (editorFrameView != null) {
            editorFrameView.setPosition(com.tencent.mm.plugin.story.ui.view.editor.a.POSITION_BOTTOM);
        }
        editorFrameView = this.smN;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(4);
        }
        layoutParams = new RelativeLayout.LayoutParams(-1, (int) f2);
        layoutParams.addRule(12);
        addView(this.smN, layoutParams);
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
        com.tencent.mm.plugin.story.f.l.czI().top = (int) f2;
        lVar = com.tencent.mm.plugin.story.f.l.sac;
        com.tencent.mm.plugin.story.f.l.czI().bottom = ((int) f2) + ((int) f);
        StringBuilder stringBuilder = new StringBuilder("logStory: initHeightSafeArea safeAreaRect:");
        com.tencent.mm.plugin.story.f.l lVar2 = com.tencent.mm.plugin.story.f.l.sac;
        ab.i("MicroMsg.EditorItemContainer", stringBuilder.append(com.tencent.mm.plugin.story.f.l.czI()).toString());
        AppMethodBeat.o(110649);
    }

    private final void lP(boolean z) {
        AppMethodBeat.i(110650);
        EditorFrameView editorFrameView = this.smK;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.o(110650);
            return;
        }
        AppMethodBeat.o(110650);
    }

    private final void lQ(boolean z) {
        AppMethodBeat.i(110651);
        EditorFrameView editorFrameView = this.smL;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.o(110651);
            return;
        }
        AppMethodBeat.o(110651);
    }

    private final void lR(boolean z) {
        AppMethodBeat.i(110652);
        EditorFrameView editorFrameView = this.smM;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.o(110652);
            return;
        }
        AppMethodBeat.o(110652);
    }

    private final void lS(boolean z) {
        AppMethodBeat.i(110653);
        EditorFrameView editorFrameView = this.smN;
        if (editorFrameView != null) {
            editorFrameView.setVisibility(z ? 0 : 4);
            AppMethodBeat.o(110653);
            return;
        }
        AppMethodBeat.o(110653);
    }

    public static final /* synthetic */ boolean a(EditorItemContainer editorItemContainer, View view, MotionEvent motionEvent) {
        AppMethodBeat.i(110658);
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
            editorItemContainer.gJ(true);
            if (editorItemContainer.smO == null) {
                editorItemContainer.smO = view;
                view.animate().alpha(0.5f).setDuration(100).start();
            }
        } else {
            editorItemContainer.gJ(false);
            if (editorItemContainer.smO != null) {
                editorItemContainer.smO = null;
                view.animate().alpha(1.0f).setDuration(100).start();
            }
        }
        AppMethodBeat.o(110658);
        return z;
    }
}
