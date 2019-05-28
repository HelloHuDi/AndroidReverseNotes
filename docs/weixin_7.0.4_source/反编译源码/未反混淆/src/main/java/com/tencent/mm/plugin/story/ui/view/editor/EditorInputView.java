package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
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
import com.tencent.mm.R;
import com.tencent.mm.emoji.view.InsectRelativeLayout;
import com.tencent.mm.media.editor.view.TextColorSelector;
import com.tencent.mm.ui.ak;
import com.tencent.smtt.sdk.WebView;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0002MNB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0017\u001a\u000206J\u0016\u00108\u001a\u0002062\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:J\u0016\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020:J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\nH\u0016J\b\u0010A\u001a\u00020\u001dH\u0016J\u0010\u0010B\u001a\u0002062\u0006\u00105\u001a\u00020\u001dH\u0002J-\u0010C\u001a\u0002062#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u000206\u0018\u000102H\u0016J\u0010\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020\u001dH\u0016J\u0010\u0010F\u001a\u0002062\u0006\u0010G\u001a\u00020\nH\u0016J \u0010H\u001a\u0002062\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u00100\u001a\u00020\n2\u0006\u0010K\u001a\u00020\nJ\b\u0010L\u001a\u000206H\u0002R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\u000e\u00100\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R+\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u000206\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "bgColor", "bgToggle", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "getCallback", "()Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "setCallback", "(Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;)V", "cancel", "Landroid/view/View;", "colorSelector", "Lcom/tencent/mm/media/editor/view/TextColorSelector;", "confirm", "hasBackground", "", "getHasBackground", "()Z", "setHasBackground", "(Z)V", "input", "Lcom/tencent/mm/plugin/story/ui/view/editor/PhotoEditText;", "inputRoot", "Landroid/view/ViewGroup;", "lastBottom", "value", "selectedIndex", "setSelectedIndex", "(I)V", "showImeRunnable", "Ljava/lang/Runnable;", "textChanged", "getTextChanged", "setTextChanged", "textColor", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "waitKeyBoardShown", "initHeightSafeArea", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "insectBottom", "bottom", "isShow", "setImeVisibility", "setOnVisibleChangeCallback", "setShow", "show", "setVisibility", "visibility", "setup", "text", "", "textBgColor", "updateInput", "AddTextCallback", "Companion", "plugin-story_release"})
public final class EditorInputView extends InsectRelativeLayout {
    static final int[] sjN;
    private static final int slC = -1;
    static final int slD = slD;
    private static final int slE;
    private static final int slF = (sjN[0] & slD);
    public static final b slG = new b();
    private final String TAG;
    private int bgColor;
    int biG;
    private a.f.a.b<? super Boolean, y> eUw;
    private int lnB;
    private boolean lnC;
    boolean lnD;
    private final Runnable lnE;
    private View lnt;
    private View lnu;
    final TextColorSelector lnw;
    a slA;
    boolean slB;
    PhotoEditText slx;
    private ViewGroup sly;
    final ImageView slz;
    private int textColor;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$4 */
    static final class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ EditorInputView slH;

        AnonymousClass4(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110553);
            this.slH.slx.requestFocus();
            AppMethodBeat.o(110553);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$5 */
    static final class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ EditorInputView slH;

        AnonymousClass5(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110554);
            this.slH.slz.setActivated(!this.slH.slz.isActivated());
            this.slH.setHasBackground(this.slH.slz.isActivated());
            EditorInputView.e(this.slH);
            AppMethodBeat.o(110554);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\"\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "", "onCancel", "", "onConfirm", "text", "", "color", "", "bgColor", "plugin-story_release"})
    public interface a {
        void e(CharSequence charSequence, int i, int i2);

        void onCancel();
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$2 */
    static final class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ EditorInputView slH;

        AnonymousClass2(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110551);
            EditorInputView editorInputView = this.slH;
            a aVar = editorInputView.slA;
            if (aVar != null) {
                aVar.onCancel();
            }
            editorInputView.slx.clearFocus();
            AppMethodBeat.o(110551);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$3 */
    static final class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ EditorInputView slH;

        AnonymousClass3(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110552);
            Editable text = this.slH.slx.getText();
            a callback = this.slH.getCallback();
            if (callback != null) {
                callback.e(text, this.slH.textColor, this.slH.bgColor);
            }
            this.slH.slx.clearFocus();
            AppMethodBeat.o(110552);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$1 */
    static final class AnonymousClass1 implements OnFocusChangeListener {
        final /* synthetic */ EditorInputView slH;

        AnonymousClass1(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(110550);
            EditorInputView.a(this.slH, z);
            AppMethodBeat.o(110550);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.editor.EditorInputView$6 */
    static final class AnonymousClass6 extends k implements a.f.a.b<Integer, y> {
        final /* synthetic */ EditorInputView slH;

        AnonymousClass6(EditorInputView editorInputView) {
            this.slH = editorInputView;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(110555);
            EditorInputView.a(this.slH, ((Number) obj).intValue());
            EditorInputView.e(this.slH);
            y yVar = y.AUy;
            AppMethodBeat.o(110555);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$Companion;", "", "()V", "AlphaBg", "", "getAlphaBg", "()I", "AlphaText", "getAlphaText", "ColorArray", "", "getColorArray", "()[I", "DefaultBgColor", "getDefaultBgColor", "DefaultTextColor", "getDefaultTextColor", "plugin-story_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ EditorInputView slH;

        c(EditorInputView editorInputView) {
            this.slH = editorInputView;
        }

        public final void run() {
            AppMethodBeat.i(110556);
            InputMethodManager inputMethodManager = (InputMethodManager) this.slH.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.slH.slx, 0);
                AppMethodBeat.o(110556);
                return;
            }
            AppMethodBeat.o(110556);
        }
    }

    public static final /* synthetic */ void e(EditorInputView editorInputView) {
        AppMethodBeat.i(110567);
        editorInputView.cCx();
        AppMethodBeat.o(110567);
    }

    public EditorInputView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110563);
        this.TAG = "MicroMsg.EditorInputView";
        View.inflate(context, R.layout.td, this);
        setBackgroundColor(getResources().getColor(R.color.a22));
        View findViewById = findViewById(R.id.bcg);
        j.o(findViewById, "findViewById(R.id.change_text_input)");
        this.slx = (PhotoEditText) findViewById;
        findViewById = findViewById(R.id.bcf);
        j.o(findViewById, "findViewById(R.id.story_editor_input_root)");
        this.sly = (ViewGroup) findViewById;
        findViewById = findViewById(R.id.bca);
        j.o(findViewById, "findViewById(R.id.change_text_cancel)");
        this.lnt = findViewById;
        findViewById = findViewById(R.id.bcb);
        j.o(findViewById, "findViewById(R.id.change_text_confirm)");
        this.lnu = findViewById;
        findViewById = findViewById(R.id.bcd);
        j.o(findViewById, "findViewById(R.id.story_editor_input_bg_toggle)");
        this.slz = (ImageView) findViewById;
        findViewById = findViewById(R.id.bce);
        j.o(findViewById, "findViewById(R.id.story_…tor_input_color_selector)");
        this.lnw = (TextColorSelector) findViewById;
        this.slx.setOnFocusChangeListener(new AnonymousClass1(this));
        this.lnt.setOnClickListener(new AnonymousClass2(this));
        this.lnu.setOnClickListener(new AnonymousClass3(this));
        setOnClickListener(new AnonymousClass4(this));
        this.slz.setOnClickListener(new AnonymousClass5(this));
        this.lnw.setColorSelectedCallback(new AnonymousClass6(this));
        this.lnw.setColorList(sjN);
        this.lnw.setSelected(0);
        this.slx.setTypeface(this.slx.getTypeface(), 1);
        this.lnE = new c(this);
        AppMethodBeat.o(110563);
    }

    public EditorInputView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110564);
        AppMethodBeat.o(110564);
    }

    static {
        AppMethodBeat.i(110565);
        int[] iArr = new int[]{-1, WebView.NIGHT_MODE_COLOR, -372399, -15616, -16268960, -15683841, -10197008};
        sjN = iArr;
        slE = iArr[1];
        AppMethodBeat.o(110565);
    }

    /* Access modifiers changed, original: final */
    public final void setSelectedIndex(int i) {
        this.biG = i;
        if (this.biG < 0) {
            this.biG = 0;
        }
    }

    public final a getCallback() {
        return this.slA;
    }

    public final void setCallback(a aVar) {
        this.slA = aVar;
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

    public final void bd(float f) {
        AppMethodBeat.i(110557);
        this.sly.setPadding((int) f, 0, (int) f, 0);
        AppMethodBeat.o(110557);
    }

    /* Access modifiers changed, original: final */
    public final void cCx() {
        AppMethodBeat.i(110558);
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
        AppMethodBeat.o(110558);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(110559);
        a.f.a.b bVar;
        if (z) {
            setVisibility(0);
            bVar = this.eUw;
            if (bVar != null) {
                bVar.am(Boolean.TRUE);
            }
            setPadding(0, 0, 0, this.lnB);
            AppMethodBeat.o(110559);
            return;
        }
        this.lnC = true;
        setVisibility(8);
        bVar = this.eUw;
        if (bVar != null) {
            bVar.am(Boolean.FALSE);
            AppMethodBeat.o(110559);
            return;
        }
        AppMethodBeat.o(110559);
    }

    public final void setOnVisibleChangeCallback(a.f.a.b<? super Boolean, y> bVar) {
        this.eUw = bVar;
    }

    private final void setImeVisibility(boolean z) {
        AppMethodBeat.i(110560);
        if (z) {
            post(this.lnE);
            AppMethodBeat.o(110560);
            return;
        }
        removeCallbacks(this.lnE);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(110560);
            return;
        }
        AppMethodBeat.o(110560);
    }

    public final boolean jn(int i) {
        AppMethodBeat.i(110561);
        this.lnB = i;
        boolean z = i > ak.fr(getContext());
        if (!this.lnC) {
            AppMethodBeat.o(110561);
            return false;
        } else if (z) {
            this.lnC = false;
            AppMethodBeat.o(110561);
            return false;
        } else {
            AppMethodBeat.o(110561);
            return true;
        }
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(110562);
        super.setVisibility(i);
        if (i == 0) {
            this.slx.requestFocus();
        }
        AppMethodBeat.o(110562);
    }
}
