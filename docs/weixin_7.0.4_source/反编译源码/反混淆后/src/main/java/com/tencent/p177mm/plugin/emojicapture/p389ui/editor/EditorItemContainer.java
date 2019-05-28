package com.tencent.p177mm.plugin.emojicapture.p389ui.editor;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0002HIB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0010J\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010,H\u0016J\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\f00j\b\u0012\u0004\u0012\u00020\f`1J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001003J\b\u00104\u001a\u0004\u0018\u00010\fJ\b\u00105\u001a\u0004\u0018\u00010)J\u0006\u00106\u001a\u00020!J\u0016\u00107\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,J\u0010\u00108\u001a\u00020%2\u0006\u0010.\u001a\u00020,H\u0016J\u0012\u00109\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0006\u0010:\u001a\u00020#J\u0006\u0010;\u001a\u00020#J\u0016\u0010<\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010=\u001a\u00020%J\u0006\u0010>\u001a\u00020#J\u000e\u0010?\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0010J&\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020BJ\u0010\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020%H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clearActive", "Ljava/lang/Runnable;", "currActiveItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/IEditorItemView;", "deleteView", "Landroid/widget/TextView;", "deletingItem", "editorMask", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorOutsideView;", "itemLayout", "Landroid/view/ViewGroup;", "stateChangeListener", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "getStateChangeListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "setStateChangeListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;)V", "validAreaView", "Landroid/view/View;", "validRect", "Landroid/graphics/RectF;", "activeDeleteView", "", "active", "", "addEditorItem", "itemView", "createTextItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "getAllEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllItemViews", "", "getAttachedText", "getTextItem", "getValidRect", "handleItemTouch", "onInterceptTouchEvent", "onTouchEvent", "pause", "removeAllItems", "requestEditing", "editing", "resume", "setEditing", "setValidRect", "left", "", "top", "right", "bottom", "toggleDeleteView", "show", "Companion", "OnStateChangeListener", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer */
public final class EditorItemContainer extends RelativeLayout {
    public static final C27824a lnP = new C27824a();
    private final String TAG;
    private View lnG;
    private TextView lnH;
    public final ViewGroup lnI;
    public final EditorOutsideView lnJ;
    private C11633b lnK;
    private final RectF lnL;
    private C38926a lnM;
    private Runnable lnN;
    private C38926a lnO;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "", "onStateChange", "", "showDelete", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer$b */
    public interface C11633b {
        /* renamed from: gH */
        void mo23381gH(boolean z);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer$d */
    static final class C20465d implements Runnable {
        final /* synthetic */ EditorItemContainer lnQ;

        C20465d(EditorItemContainer editorItemContainer) {
            this.lnQ = editorItemContainer;
        }

        public final void run() {
            AppMethodBeat.m2504i(3074);
            if (this.lnQ.lnO != null) {
                C38926a a = this.lnQ.lnO;
                if (a == null) {
                    C25052j.dWJ();
                }
                if (!a.bob()) {
                    ViewGroup c = this.lnQ.lnI;
                    a = this.lnQ.lnO;
                    if (a == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.m2505o(3074);
                        throw c44941v;
                    }
                    c.removeView((View) a);
                }
            }
            this.lnQ.lnO = null;
            this.lnQ.lnM = null;
            AppMethodBeat.m2505o(3074);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$Companion;", "", "()V", "ClearActiveDelay", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer$a */
    public static final class C27824a {
        private C27824a() {
        }

        public /* synthetic */ C27824a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer$c */
    static final class C27825c implements Runnable {
        final /* synthetic */ EditorItemContainer lnQ;

        C27825c(EditorItemContainer editorItemContainer) {
            this.lnQ = editorItemContainer;
        }

        public final void run() {
            AppMethodBeat.m2504i(3073);
            if (this.lnQ.lnM != null) {
                EditorItemContainer editorItemContainer = this.lnQ;
                C38926a d = this.lnQ.lnM;
                if (d == null) {
                    C25052j.dWJ();
                }
                editorItemContainer.mo45681a(d, false);
            }
            AppMethodBeat.m2505o(3073);
        }
    }

    static {
        AppMethodBeat.m2504i(3092);
        AppMethodBeat.m2505o(3092);
    }

    public EditorItemContainer(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(3090);
        this.TAG = "MicroMsg.EditorItemContainer";
        this.lnL = new RectF();
        this.lnN = new C27825c(this);
        View.inflate(context, 2130969325, this);
        View findViewById = findViewById(2131823431);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_valid_area)");
        this.lnG = findViewById;
        findViewById = findViewById(2131823434);
        C25052j.m39375o(findViewById, "findViewById(R.id.editor_delete_view)");
        this.lnH = (TextView) findViewById;
        findViewById = findViewById(2131823432);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_editor_layout)");
        this.lnI = (ViewGroup) findViewById;
        findViewById = findViewById(2131823433);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_editor_mask)");
        this.lnJ = (EditorOutsideView) findViewById;
        AppMethodBeat.m2505o(3090);
    }

    public EditorItemContainer(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(3091);
        AppMethodBeat.m2505o(3091);
    }

    public final C11633b getStateChangeListener() {
        return this.lnK;
    }

    public final void setStateChangeListener(C11633b c11633b) {
        this.lnK = c11633b;
    }

    /* renamed from: a */
    public final void mo45680a(C38926a c38926a, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3075);
        C25052j.m39376p(c38926a, "itemView");
        C25052j.m39376p(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                removeCallbacks(this.lnN);
                mo45681a(c38926a, true);
                AppMethodBeat.m2505o(3075);
                return;
            case 1:
            case 3:
                this.lnI.bringChildToFront(getTextItem());
                if (this.lnO != null) {
                    post(new C20465d(this));
                } else if (this.lnM != null) {
                    postDelayed(this.lnN, 1500);
                }
                m44227gI(false);
                break;
            case 2:
                m44223b(c38926a, motionEvent);
                m44227gI(true);
                AppMethodBeat.m2505o(3075);
                return;
        }
        AppMethodBeat.m2505o(3075);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3076);
        C25052j.m39376p(motionEvent, "ev");
        if (motionEvent.getActionMasked() != 0 || this.lnL.contains(motionEvent.getX(), motionEvent.getY())) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.m2505o(3076);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.m2505o(3076);
        return true;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3077);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(3077);
        return dispatchTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3078);
        if (motionEvent != null && motionEvent.getActionMasked() == 0) {
            if (!this.lnL.contains(motionEvent.getX(), motionEvent.getY())) {
                AppMethodBeat.m2505o(3078);
                return false;
            } else if (this.lnM != null) {
                C38926a c38926a = this.lnM;
                if (c38926a == null) {
                    C25052j.dWJ();
                }
                mo45681a(c38926a, false);
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(3078);
        return onTouchEvent;
    }

    public final TextEditorItemView getTextItem() {
        AppMethodBeat.m2504i(3079);
        int childCount = this.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lnI.getChildAt(i);
            if (childAt instanceof TextEditorItemView) {
                TextEditorItemView textEditorItemView = (TextEditorItemView) childAt;
                AppMethodBeat.m2505o(3079);
                return textEditorItemView;
            }
        }
        AppMethodBeat.m2505o(3079);
        return null;
    }

    public final String getAttachedText() {
        AppMethodBeat.m2504i(3080);
        TextEditorItemView textItem = getTextItem();
        if (textItem == null) {
            AppMethodBeat.m2505o(3080);
            return null;
        } else if (textItem.getText() == null) {
            AppMethodBeat.m2505o(3080);
            return null;
        } else {
            String valueOf = String.valueOf(textItem.getText());
            AppMethodBeat.m2505o(3080);
            return valueOf;
        }
    }

    public final ArrayList<String> getAllEmojiMd5() {
        AppMethodBeat.m2504i(3081);
        ArrayList arrayList = new ArrayList();
        int childCount = this.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lnI.getChildAt(i);
            if (childAt instanceof EmojiEditorItemView) {
                EmojiInfo emojiInfo = ((EmojiEditorItemView) childAt).getEmojiInfo();
                if (emojiInfo != null) {
                    String Aq = emojiInfo.mo20410Aq();
                    if (Aq != null) {
                        arrayList.add(Aq);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(3081);
        return arrayList;
    }

    public final List<C38926a> getAllItemViews() {
        AppMethodBeat.m2504i(3082);
        List arrayList = new ArrayList();
        int childCount = this.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lnI.getChildAt(i);
            if (childAt instanceof C38926a) {
                arrayList.add(childAt);
            }
        }
        AppMethodBeat.m2505o(3082);
        return arrayList;
    }

    public final void pause() {
        AppMethodBeat.m2504i(3083);
        int childCount = this.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lnI.getChildAt(i);
            if (childAt instanceof C38926a) {
                ((C38926a) childAt).pause();
            }
        }
        AppMethodBeat.m2505o(3083);
    }

    public final RectF getValidRect() {
        AppMethodBeat.m2504i(3084);
        this.lnL.set((float) this.lnG.getLeft(), (float) this.lnG.getTop(), (float) this.lnG.getRight(), (float) this.lnG.getBottom());
        RectF rectF = this.lnL;
        AppMethodBeat.m2505o(3084);
        return rectF;
    }

    public final void setEditing(C38926a c38926a) {
        AppMethodBeat.m2504i(3085);
        C25052j.m39376p(c38926a, "itemView");
        removeCallbacks(this.lnN);
        mo45681a(c38926a, true);
        postDelayed(this.lnN, 1500);
        AppMethodBeat.m2505o(3085);
    }

    /* renamed from: a */
    public final void mo45681a(C38926a c38926a, boolean z) {
        AppMethodBeat.m2504i(3086);
        C25052j.m39376p(c38926a, "itemView");
        if (z) {
            if ((C25052j.m39373j(c38926a, this.lnM) ^ 1) != 0) {
                C38926a c38926a2 = this.lnM;
                if (c38926a2 != null) {
                    c38926a2.setEditing(false);
                }
                this.lnM = c38926a;
            }
        } else if (C25052j.m39373j(c38926a, this.lnM)) {
            this.lnM = null;
        }
        c38926a.setEditing(z);
        AppMethodBeat.m2505o(3086);
    }

    /* renamed from: gI */
    private final void m44227gI(boolean z) {
        AppMethodBeat.m2504i(3087);
        this.lnH.setVisibility(z ? 0 : 8);
        if (this.lnK != null) {
            C11633b c11633b = this.lnK;
            if (c11633b == null) {
                C25052j.dWJ();
            }
            c11633b.mo23381gH(z);
        }
        AppMethodBeat.m2505o(3087);
    }

    /* renamed from: gJ */
    private final void m44228gJ(boolean z) {
        AppMethodBeat.m2504i(3088);
        this.lnH.setActivated(z);
        if (z) {
            this.lnH.setText(C25738R.string.b8m);
            AppMethodBeat.m2505o(3088);
            return;
        }
        this.lnH.setText(C25738R.string.b8l);
        AppMethodBeat.m2505o(3088);
    }

    /* renamed from: b */
    private final boolean m44223b(C38926a c38926a, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3089);
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            f += motionEvent.getY(i);
        }
        boolean z = f / ((float) pointerCount) > ((float) this.lnH.getTop());
        if (z) {
            m44228gJ(true);
            if (this.lnO == null) {
                this.lnO = c38926a;
            }
        } else {
            m44228gJ(false);
            if (this.lnO != null) {
                this.lnO = null;
            }
        }
        AppMethodBeat.m2505o(3089);
        return z;
    }
}
