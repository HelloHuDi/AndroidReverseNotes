package com.tencent.p177mm.plugin.story.p536ui.view.editor;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.view.InsectRelativeLayout;
import com.tencent.p177mm.media.editor.view.TextColorSelector;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.smtt.sdk.WebView;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0002MNB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0017\u001a\u000206J\u0016\u00108\u001a\u0002062\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:J\u0016\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020:J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\nH\u0016J\b\u0010A\u001a\u00020\u001dH\u0016J\u0010\u0010B\u001a\u0002062\u0006\u00105\u001a\u00020\u001dH\u0002J-\u0010C\u001a\u0002062#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u000206\u0018\u000102H\u0016J\u0010\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020\u001dH\u0016J\u0010\u0010F\u001a\u0002062\u0006\u0010G\u001a\u00020\nH\u0016J \u0010H\u001a\u0002062\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u00100\u001a\u00020\n2\u0006\u0010K\u001a\u00020\nJ\b\u0010L\u001a\u000206H\u0002R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\u000e\u00100\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R+\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u000206\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "bgColor", "bgToggle", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "getCallback", "()Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "setCallback", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;)V", "cancel", "Landroid/view/View;", "colorSelector", "Lcom/tencent/mm/media/editor/view/TextColorSelector;", "confirm", "hasBackground", "", "getHasBackground", "()Z", "setHasBackground", "(Z)V", "input", "Lcom/tencent/mm/plugin/story/ui/view/editor/PhotoEditText;", "inputRoot", "Landroid/view/ViewGroup;", "lastBottom", "value", "selectedIndex", "setSelectedIndex", "(I)V", "showImeRunnable", "Ljava/lang/Runnable;", "textChanged", "getTextChanged", "setTextChanged", "textColor", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "waitKeyBoardShown", "initHeightSafeArea", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "isShow", "setImeVisibility", "setOnVisibleChangeCallback", "setShow", "show", "setVisibility", "visibility", "setup", "text", "", "textBgColor", "updateInput", "AddTextCallback", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView */
public final class EditorInputView extends InsectRelativeLayout {
    static final int[] sjN;
    private static final int slC = -1;
    static final int slD = slD;
    private static final int slE;
    private static final int slF = (sjN[0] & slD);
    public static final C22301b slG = new C22301b();
    private final String TAG;
    private int bgColor;
    int biG;
    private C17126b<? super Boolean, C37091y> eUw;
    private int lnB;
    private boolean lnC;
    boolean lnD;
    private final Runnable lnE;
    private View lnt;
    private View lnu;
    final TextColorSelector lnw;
    C4164a slA;
    boolean slB;
    PhotoEditText slx;
    private ViewGroup sly;
    final ImageView slz;
    private int textColor;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$4 */
    static final class C41624 implements OnClickListener {
        final /* synthetic */ EditorInputView slH;

        C41624(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110553);
            this.slH.slx.requestFocus();
            AppMethodBeat.m2505o(110553);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$5 */
    static final class C41635 implements OnClickListener {
        final /* synthetic */ EditorInputView slH;

        C41635(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110554);
            this.slH.slz.setActivated(!this.slH.slz.isActivated());
            this.slH.setHasBackground(this.slH.slz.isActivated());
            EditorInputView.m33957e(this.slH);
            AppMethodBeat.m2505o(110554);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\"\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "", "onCancel", "", "onConfirm", "text", "", "color", "", "bgColor", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$a */
    public interface C4164a {
        /* renamed from: e */
        void mo9049e(CharSequence charSequence, int i, int i2);

        void onCancel();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$2 */
    static final class C138682 implements OnClickListener {
        final /* synthetic */ EditorInputView slH;

        C138682(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110551);
            EditorInputView editorInputView = this.slH;
            C4164a c4164a = editorInputView.slA;
            if (c4164a != null) {
                c4164a.onCancel();
            }
            editorInputView.slx.clearFocus();
            AppMethodBeat.m2505o(110551);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$3 */
    static final class C138693 implements OnClickListener {
        final /* synthetic */ EditorInputView slH;

        C138693(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110552);
            Editable text = this.slH.slx.getText();
            C4164a callback = this.slH.getCallback();
            if (callback != null) {
                callback.mo9049e(text, this.slH.textColor, this.slH.bgColor);
            }
            this.slH.slx.clearFocus();
            AppMethodBeat.m2505o(110552);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$1 */
    static final class C222991 implements OnFocusChangeListener {
        final /* synthetic */ EditorInputView slH;

        C222991(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(110550);
            EditorInputView.m33953a(this.slH, z);
            AppMethodBeat.m2505o(110550);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$6 */
    static final class C223006 extends C25053k implements C17126b<Integer, C37091y> {
        final /* synthetic */ EditorInputView slH;

        C223006(EditorInputView editorInputView) {
            this.slH = editorInputView;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(110555);
            EditorInputView.m33952a(this.slH, ((Number) obj).intValue());
            EditorInputView.m33957e(this.slH);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110555);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$Companion;", "", "()V", "AlphaBg", "", "getAlphaBg", "()I", "AlphaText", "getAlphaText", "ColorArray", "", "getColorArray", "()[I", "DefaultBgColor", "getDefaultBgColor", "DefaultTextColor", "getDefaultTextColor", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$b */
    public static final class C22301b {
        private C22301b() {
        }

        public /* synthetic */ C22301b(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$c */
    static final class C22302c implements Runnable {
        final /* synthetic */ EditorInputView slH;

        C22302c(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110556);
            InputMethodManager inputMethodManager = (InputMethodManager) this.slH.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.slH.slx, 0);
                AppMethodBeat.m2505o(110556);
                return;
            }
            AppMethodBeat.m2505o(110556);
        }
    }

    /* renamed from: e */
    public static final /* synthetic */ void m33957e(EditorInputView editorInputView) {
        AppMethodBeat.m2504i(110567);
        editorInputView.cCx();
        AppMethodBeat.m2505o(110567);
    }

    public EditorInputView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110563);
        this.TAG = "MicroMsg.EditorInputView";
        View.inflate(context, 2130969321, this);
        setBackgroundColor(getResources().getColor(C25738R.color.a22));
        View findViewById = findViewById(2131823410);
        C25052j.m39375o(findViewById, "findViewById(R.id.change_text_input)");
        this.slx = (PhotoEditText) findViewById;
        findViewById = findViewById(2131823409);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_input_root)");
        this.sly = (ViewGroup) findViewById;
        findViewById = findViewById(2131823404);
        C25052j.m39375o(findViewById, "findViewById(R.id.change_text_cancel)");
        this.lnt = findViewById;
        findViewById = findViewById(2131823405);
        C25052j.m39375o(findViewById, "findViewById(R.id.change_text_confirm)");
        this.lnu = findViewById;
        findViewById = findViewById(2131823407);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_editor_input_bg_toggle)");
        this.slz = (ImageView) findViewById;
        findViewById = findViewById(2131823408);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_…tor_input_color_selector)");
        this.lnw = (TextColorSelector) findViewById;
        this.slx.setOnFocusChangeListener(new C222991(this));
        this.lnt.setOnClickListener(new C138682(this));
        this.lnu.setOnClickListener(new C138693(this));
        setOnClickListener(new C41624(this));
        this.slz.setOnClickListener(new C41635(this));
        this.lnw.setColorSelectedCallback(new C223006(this));
        this.lnw.setColorList(sjN);
        this.lnw.setSelected(0);
        this.slx.setTypeface(this.slx.getTypeface(), 1);
        this.lnE = new C22302c(this);
        AppMethodBeat.m2505o(110563);
    }

    public EditorInputView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110564);
        AppMethodBeat.m2505o(110564);
    }

    static {
        AppMethodBeat.m2504i(110565);
        int[] iArr = new int[]{-1, WebView.NIGHT_MODE_COLOR, -372399, -15616, -16268960, -15683841, -10197008};
        sjN = iArr;
        slE = iArr[1];
        AppMethodBeat.m2505o(110565);
    }

    /* Access modifiers changed, original: final */
    public final void setSelectedIndex(int i) {
        this.biG = i;
        if (this.biG < 0) {
            this.biG = 0;
        }
    }

    public final C4164a getCallback() {
        return this.slA;
    }

    public final void setCallback(C4164a c4164a) {
        this.slA = c4164a;
    }

    public final boolean getTextChanged() {
        return this.lnD;
    }

    public final void setTextChanged(boolean z) {
        this.lnD = z;
    }

    public final boolean getHasBackground() {
        return this.slB;
    }

    public final void setHasBackground(boolean z) {
        this.slB = z;
    }

    /* renamed from: bd */
    public final void mo37813bd(float f) {
        AppMethodBeat.m2504i(110557);
        this.sly.setPadding((int) f, 0, (int) f, 0);
        AppMethodBeat.m2505o(110557);
    }

    /* Access modifiers changed, original: final */
    public final void cCx() {
        AppMethodBeat.m2504i(110558);
        if (this.slB) {
            int i;
            this.bgColor = sjN[this.biG] & slD;
            switch (this.biG) {
                case 0:
                    i = sjN[1];
                    break;
                default:
                    i = sjN[0];
                    break;
            }
            this.textColor = i;
        } else {
            this.textColor = sjN[this.biG] & slC;
            this.bgColor = 0;
        }
        this.slx.setTextColor(this.textColor);
        this.slx.setTextBackground(this.bgColor);
        this.slx.postInvalidate();
        AppMethodBeat.m2505o(110558);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.m2504i(110559);
        C17126b c17126b;
        if (z) {
            setVisibility(0);
            c17126b = this.eUw;
            if (c17126b != null) {
                c17126b.mo50am(Boolean.TRUE);
            }
            setPadding(0, 0, 0, this.lnB);
            AppMethodBeat.m2505o(110559);
            return;
        }
        this.lnC = true;
        setVisibility(8);
        c17126b = this.eUw;
        if (c17126b != null) {
            c17126b.mo50am(Boolean.FALSE);
            AppMethodBeat.m2505o(110559);
            return;
        }
        AppMethodBeat.m2505o(110559);
    }

    public final void setOnVisibleChangeCallback(C17126b<? super Boolean, C37091y> c17126b) {
        this.eUw = c17126b;
    }

    private final void setImeVisibility(boolean z) {
        AppMethodBeat.m2504i(110560);
        if (z) {
            post(this.lnE);
            AppMethodBeat.m2505o(110560);
            return;
        }
        removeCallbacks(this.lnE);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.m2505o(110560);
            return;
        }
        AppMethodBeat.m2505o(110560);
    }

    /* renamed from: jn */
    public final boolean mo20726jn(int i) {
        AppMethodBeat.m2504i(110561);
        this.lnB = i;
        boolean z = i > C5230ak.m7988fr(getContext());
        if (!this.lnC) {
            AppMethodBeat.m2505o(110561);
            return false;
        } else if (z) {
            this.lnC = false;
            AppMethodBeat.m2505o(110561);
            return false;
        } else {
            AppMethodBeat.m2505o(110561);
            return true;
        }
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(110562);
        super.setVisibility(i);
        if (i == 0) {
            this.slx.requestFocus();
        }
        AppMethodBeat.m2505o(110562);
    }
}
