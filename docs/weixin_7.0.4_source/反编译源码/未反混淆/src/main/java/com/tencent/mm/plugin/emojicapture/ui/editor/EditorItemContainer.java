package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0002HIB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0010J\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010,H\u0016J\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\f00j\b\u0012\u0004\u0012\u00020\f`1J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001003J\b\u00104\u001a\u0004\u0018\u00010\fJ\b\u00105\u001a\u0004\u0018\u00010)J\u0006\u00106\u001a\u00020!J\u0016\u00107\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,J\u0010\u00108\u001a\u00020%2\u0006\u0010.\u001a\u00020,H\u0016J\u0012\u00109\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0006\u0010:\u001a\u00020#J\u0006\u0010;\u001a\u00020#J\u0016\u0010<\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010=\u001a\u00020%J\u0006\u0010>\u001a\u00020#J\u000e\u0010?\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0010J&\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020BJ\u0010\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020%H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clearActive", "Ljava/lang/Runnable;", "currActiveItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/IEditorItemView;", "deleteView", "Landroid/widget/TextView;", "deletingItem", "editorMask", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorOutsideView;", "itemLayout", "Landroid/view/ViewGroup;", "stateChangeListener", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "getStateChangeListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "setStateChangeListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;)V", "validAreaView", "Landroid/view/View;", "validRect", "Landroid/graphics/RectF;", "activeDeleteView", "", "active", "", "addEditorItem", "itemView", "createTextItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "getAllEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllItemViews", "", "getAttachedText", "getTextItem", "getValidRect", "handleItemTouch", "onInterceptTouchEvent", "onTouchEvent", "pause", "removeAllItems", "requestEditing", "editing", "resume", "setEditing", "setValidRect", "left", "", "top", "right", "bottom", "toggleDeleteView", "show", "Companion", "OnStateChangeListener", "plugin-emojicapture_release"})
public final class EditorItemContainer extends RelativeLayout {
    public static final a lnP = new a();
    private final String TAG;
    private View lnG;
    private TextView lnH;
    public final ViewGroup lnI;
    public final EditorOutsideView lnJ;
    private b lnK;
    private final RectF lnL;
    private a lnM;
    private Runnable lnN;
    private a lnO;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "", "onStateChange", "", "showDelete", "", "plugin-emojicapture_release"})
    public interface b {
        void gH(boolean z);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ EditorItemContainer lnQ;

        d(EditorItemContainer editorItemContainer) {
            this.lnQ = editorItemContainer;
        }

        public final void run() {
            AppMethodBeat.i(3074);
            if (this.lnQ.lnO != null) {
                a a = this.lnQ.lnO;
                if (a == null) {
                    j.dWJ();
                }
                if (!a.bob()) {
                    ViewGroup c = this.lnQ.lnI;
                    a = this.lnQ.lnO;
                    if (a == null) {
                        v vVar = new v("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(3074);
                        throw vVar;
                    }
                    c.removeView((View) a);
                }
            }
            this.lnQ.lnO = null;
            this.lnQ.lnM = null;
            AppMethodBeat.o(3074);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$Companion;", "", "()V", "ClearActiveDelay", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ EditorItemContainer lnQ;

        c(EditorItemContainer editorItemContainer) {
            this.lnQ = editorItemContainer;
        }

        public final void run() {
            AppMethodBeat.i(3073);
            if (this.lnQ.lnM != null) {
                EditorItemContainer editorItemContainer = this.lnQ;
                a d = this.lnQ.lnM;
                if (d == null) {
                    j.dWJ();
                }
                editorItemContainer.a(d, false);
            }
            AppMethodBeat.o(3073);
        }
    }

    static {
        AppMethodBeat.i(3092);
        AppMethodBeat.o(3092);
    }

    public EditorItemContainer(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(3090);
        this.TAG = "MicroMsg.EditorItemContainer";
        this.lnL = new RectF();
        this.lnN = new c(this);
        View.inflate(context, R.layout.th, this);
        View findViewById = findViewById(R.id.bd1);
        j.o(findViewById, "findViewById(R.id.editor_valid_area)");
        this.lnG = findViewById;
        findViewById = findViewById(R.id.bd4);
        j.o(findViewById, "findViewById(R.id.editor_delete_view)");
        this.lnH = (TextView) findViewById;
        findViewById = findViewById(R.id.bd2);
        j.o(findViewById, "findViewById(R.id.emoji_capture_editor_layout)");
        this.lnI = (ViewGroup) findViewById;
        findViewById = findViewById(R.id.bd3);
        j.o(findViewById, "findViewById(R.id.emoji_capture_editor_mask)");
        this.lnJ = (EditorOutsideView) findViewById;
        AppMethodBeat.o(3090);
    }

    public EditorItemContainer(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(3091);
        AppMethodBeat.o(3091);
    }

    public final b getStateChangeListener() {
        return this.lnK;
    }

    public final void setStateChangeListener(b bVar) {
        this.lnK = bVar;
    }

    public final void a(a aVar, MotionEvent motionEvent) {
        AppMethodBeat.i(3075);
        j.p(aVar, "itemView");
        j.p(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                removeCallbacks(this.lnN);
                a(aVar, true);
                AppMethodBeat.o(3075);
                return;
            case 1:
            case 3:
                this.lnI.bringChildToFront(getTextItem());
                if (this.lnO != null) {
                    post(new d(this));
                } else if (this.lnM != null) {
                    postDelayed(this.lnN, 1500);
                }
                gI(false);
                break;
            case 2:
                b(aVar, motionEvent);
                gI(true);
                AppMethodBeat.o(3075);
                return;
        }
        AppMethodBeat.o(3075);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(3076);
        j.p(motionEvent, "ev");
        if (motionEvent.getActionMasked() != 0 || this.lnL.contains(motionEvent.getX(), motionEvent.getY())) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(3076);
            return onInterceptTouchEvent;
        }
        AppMethodBeat.o(3076);
        return true;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(3077);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(3077);
        return dispatchTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(3078);
        if (motionEvent != null && motionEvent.getActionMasked() == 0) {
            if (!this.lnL.contains(motionEvent.getX(), motionEvent.getY())) {
                AppMethodBeat.o(3078);
                return false;
            } else if (this.lnM != null) {
                a aVar = this.lnM;
                if (aVar == null) {
                    j.dWJ();
                }
                a(aVar, false);
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(3078);
        return onTouchEvent;
    }

    public final TextEditorItemView getTextItem() {
        AppMethodBeat.i(3079);
        int childCount = this.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lnI.getChildAt(i);
            if (childAt instanceof TextEditorItemView) {
                TextEditorItemView textEditorItemView = (TextEditorItemView) childAt;
                AppMethodBeat.o(3079);
                return textEditorItemView;
            }
        }
        AppMethodBeat.o(3079);
        return null;
    }

    public final String getAttachedText() {
        AppMethodBeat.i(3080);
        TextEditorItemView textItem = getTextItem();
        if (textItem == null) {
            AppMethodBeat.o(3080);
            return null;
        } else if (textItem.getText() == null) {
            AppMethodBeat.o(3080);
            return null;
        } else {
            String valueOf = String.valueOf(textItem.getText());
            AppMethodBeat.o(3080);
            return valueOf;
        }
    }

    public final ArrayList<String> getAllEmojiMd5() {
        AppMethodBeat.i(3081);
        ArrayList arrayList = new ArrayList();
        int childCount = this.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lnI.getChildAt(i);
            if (childAt instanceof EmojiEditorItemView) {
                EmojiInfo emojiInfo = ((EmojiEditorItemView) childAt).getEmojiInfo();
                if (emojiInfo != null) {
                    String Aq = emojiInfo.Aq();
                    if (Aq != null) {
                        arrayList.add(Aq);
                    }
                }
            }
        }
        AppMethodBeat.o(3081);
        return arrayList;
    }

    public final List<a> getAllItemViews() {
        AppMethodBeat.i(3082);
        List arrayList = new ArrayList();
        int childCount = this.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lnI.getChildAt(i);
            if (childAt instanceof a) {
                arrayList.add(childAt);
            }
        }
        AppMethodBeat.o(3082);
        return arrayList;
    }

    public final void pause() {
        AppMethodBeat.i(3083);
        int childCount = this.lnI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.lnI.getChildAt(i);
            if (childAt instanceof a) {
                ((a) childAt).pause();
            }
        }
        AppMethodBeat.o(3083);
    }

    public final RectF getValidRect() {
        AppMethodBeat.i(3084);
        this.lnL.set((float) this.lnG.getLeft(), (float) this.lnG.getTop(), (float) this.lnG.getRight(), (float) this.lnG.getBottom());
        RectF rectF = this.lnL;
        AppMethodBeat.o(3084);
        return rectF;
    }

    public final void setEditing(a aVar) {
        AppMethodBeat.i(3085);
        j.p(aVar, "itemView");
        removeCallbacks(this.lnN);
        a(aVar, true);
        postDelayed(this.lnN, 1500);
        AppMethodBeat.o(3085);
    }

    public final void a(a aVar, boolean z) {
        AppMethodBeat.i(3086);
        j.p(aVar, "itemView");
        if (z) {
            if ((j.j(aVar, this.lnM) ^ 1) != 0) {
                a aVar2 = this.lnM;
                if (aVar2 != null) {
                    aVar2.setEditing(false);
                }
                this.lnM = aVar;
            }
        } else if (j.j(aVar, this.lnM)) {
            this.lnM = null;
        }
        aVar.setEditing(z);
        AppMethodBeat.o(3086);
    }

    private final void gI(boolean z) {
        AppMethodBeat.i(3087);
        this.lnH.setVisibility(z ? 0 : 8);
        if (this.lnK != null) {
            b bVar = this.lnK;
            if (bVar == null) {
                j.dWJ();
            }
            bVar.gH(z);
        }
        AppMethodBeat.o(3087);
    }

    private final void gJ(boolean z) {
        AppMethodBeat.i(3088);
        this.lnH.setActivated(z);
        if (z) {
            this.lnH.setText(R.string.b8m);
            AppMethodBeat.o(3088);
            return;
        }
        this.lnH.setText(R.string.b8l);
        AppMethodBeat.o(3088);
    }

    private final boolean b(a aVar, MotionEvent motionEvent) {
        AppMethodBeat.i(3089);
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            f += motionEvent.getY(i);
        }
        boolean z = f / ((float) pointerCount) > ((float) this.lnH.getTop());
        if (z) {
            gJ(true);
            if (this.lnO == null) {
                this.lnO = aVar;
            }
        } else {
            gJ(false);
            if (this.lnO != null) {
                this.lnO = null;
            }
        }
        AppMethodBeat.o(3089);
        return z;
    }
}
