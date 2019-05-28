package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.view.InsectRelativeLayout;
import com.tencent.mm.media.editor.view.TextColorSelector;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.ui.ak;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0014\u001a\u000201J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020)H\u0016J\u0010\u00105\u001a\u0002012\u0006\u00106\u001a\u00020)H\u0002J-\u00107\u001a\u0002012#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110)¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(6\u0012\u0004\u0012\u000201\u0018\u000108H\u0016J\u0010\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020)H\u0016J\u0010\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020\nH\u0016J\u0018\u0010?\u001a\u0002012\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\nR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "setCallback", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;)V", "cancel", "Landroid/view/View;", "colorSelector", "Lcom/tencent/mm/media/editor/view/TextColorSelector;", "confirm", "deleteIcon", "Landroid/widget/ImageView;", "input", "Landroid/widget/EditText;", "lastBottom", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectedColor", "selectedStrokeColor", "showImeRunnable", "Ljava/lang/Runnable;", "textChanged", "", "getTextChanged", "()Z", "setTextChanged", "(Z)V", "waitKeyBoardShown", "windowVisibleRect", "Landroid/graphics/Rect;", "", "insectBottom", "bottom", "isShow", "setImeVisibility", "visible", "setOnVisibleChangeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setShow", "show", "setVisibility", "visibility", "setup", "text", "", "textColor", "AddTextCallback", "plugin-emojicapture_release"})
public final class EditorChangeTextView extends InsectRelativeLayout {
    private final String TAG;
    EditText jgG;
    public EmojiCaptureReporter lha;
    private a lnA;
    private int lnB;
    private boolean lnC;
    boolean lnD;
    private final Runnable lnE;
    private View lnt;
    private View lnu;
    private ImageView lnv;
    TextColorSelector lnw;
    int lnx;
    int lny;
    private final Rect lnz;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "", "onCancel", "", "onConfirm", "text", "", "color", "", "plugin-emojicapture_release"})
    public interface a {
        void i(CharSequence charSequence, int i);

        void onCancel();
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$6 */
    static final class AnonymousClass6 extends k implements a.f.a.b<Integer, y> {
        final /* synthetic */ EditorChangeTextView lnF;

        AnonymousClass6(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(3060);
            int intValue = ((Number) obj).intValue();
            this.lnF.lnx = com.tencent.mm.plugin.emojicapture.ui.a.bnQ()[intValue];
            this.lnF.lny = com.tencent.mm.plugin.emojicapture.ui.a.bnR()[intValue];
            this.lnF.jgG.setTextColor(this.lnF.lnx);
            y yVar = y.AUy;
            AppMethodBeat.o(3060);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$5 */
    static final class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ EditorChangeTextView lnF;

        AnonymousClass5(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(3059);
            this.lnF.jgG.setText("");
            AppMethodBeat.o(3059);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ EditorChangeTextView lnF;

        b(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void run() {
            AppMethodBeat.i(3062);
            InputMethodManager inputMethodManager = (InputMethodManager) this.lnF.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.lnF.jgG, 0);
                AppMethodBeat.o(3062);
                return;
            }
            AppMethodBeat.o(3062);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$1 */
    static final class AnonymousClass1 implements OnFocusChangeListener {
        final /* synthetic */ EditorChangeTextView lnF;

        AnonymousClass1(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(3054);
            EditorChangeTextView.a(this.lnF, z);
            AppMethodBeat.o(3054);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$3 */
    static final class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ EditorChangeTextView lnF;

        AnonymousClass3(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(3057);
            this.lnF.cancel();
            AppMethodBeat.o(3057);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$4 */
    static final class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ EditorChangeTextView lnF;

        AnonymousClass4(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(3058);
            Editable text = this.lnF.jgG.getText();
            a callback = this.lnF.getCallback();
            if (callback != null) {
                callback.i(text, this.lnF.lnx);
            }
            this.lnF.jgG.clearFocus();
            if (this.lnF.getTextChanged()) {
                EmojiCaptureReporter.a(16, this.lnF.getReporter().ezZ, 0, 0, 0, 0, 0, 0, 0, this.lnF.getReporter().scene);
            }
            EmojiCaptureReporter.a(15, this.lnF.getReporter().ezZ, 0, 0, 0, 0, 0, 0, 0, this.lnF.getReporter().scene);
            AppMethodBeat.o(3058);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$7 */
    static final class AnonymousClass7 implements OnClickListener {
        final /* synthetic */ EditorChangeTextView lnF;

        AnonymousClass7(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(3061);
            this.lnF.jgG.requestFocus();
            EditorChangeTextView.a(this.lnF, true);
            AppMethodBeat.o(3061);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$2 */
    public static final class AnonymousClass2 implements TextWatcher {
        final /* synthetic */ EditorChangeTextView lnF;

        AnonymousClass2(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(3055);
            if (editable != null) {
                if ((((CharSequence) editable).length() > 0 ? 1 : 0) != 0) {
                    this.lnF.lnv.setVisibility(0);
                    AppMethodBeat.o(3055);
                    return;
                }
            }
            this.lnF.lnv.setVisibility(8);
            AppMethodBeat.o(3055);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(3056);
            this.lnF.setTextChanged(true);
            AppMethodBeat.o(3056);
        }
    }

    public EditorChangeTextView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(3070);
        this.TAG = "EditorChangeTextView";
        this.lnz = new Rect();
        View.inflate(context, R.layout.tg, this);
        View findViewById = findViewById(R.id.bcg);
        j.o(findViewById, "findViewById(R.id.change_text_input)");
        this.jgG = (EditText) findViewById;
        findViewById = findViewById(R.id.bca);
        j.o(findViewById, "findViewById(R.id.change_text_cancel)");
        this.lnt = findViewById;
        findViewById = findViewById(R.id.bcb);
        j.o(findViewById, "findViewById(R.id.change_text_confirm)");
        this.lnu = findViewById;
        findViewById = findViewById(R.id.bd0);
        j.o(findViewById, "findViewById(R.id.text_color_selector)");
        this.lnw = (TextColorSelector) findViewById;
        findViewById = findViewById(R.id.bcz);
        j.o(findViewById, "findViewById(R.id.delete_text)");
        this.lnv = (ImageView) findViewById;
        this.jgG.setOnFocusChangeListener(new AnonymousClass1(this));
        this.jgG.addTextChangedListener(new AnonymousClass2(this));
        this.lnt.setOnClickListener(new AnonymousClass3(this));
        this.lnu.setOnClickListener(new AnonymousClass4(this));
        this.lnv.setOnClickListener(new AnonymousClass5(this));
        this.lnw.setColorList(com.tencent.mm.plugin.emojicapture.ui.a.bnQ());
        this.lnw.setSelected(0);
        this.lnw.setColorSelectedCallback(new AnonymousClass6(this));
        setOnClickListener(new AnonymousClass7(this));
        this.lnE = new b(this);
        AppMethodBeat.o(3070);
    }

    public EditorChangeTextView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(3071);
        AppMethodBeat.o(3071);
    }

    public final a getCallback() {
        return this.lnA;
    }

    public final void setCallback(a aVar) {
        this.lnA = aVar;
    }

    public final boolean getTextChanged() {
        return this.lnD;
    }

    public final void setTextChanged(boolean z) {
        this.lnD = z;
    }

    public final EmojiCaptureReporter getReporter() {
        AppMethodBeat.i(3063);
        EmojiCaptureReporter emojiCaptureReporter = this.lha;
        if (emojiCaptureReporter == null) {
            j.avw("reporter");
        }
        AppMethodBeat.o(3063);
        return emojiCaptureReporter;
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        AppMethodBeat.i(3064);
        j.p(emojiCaptureReporter, "<set-?>");
        this.lha = emojiCaptureReporter;
        AppMethodBeat.o(3064);
    }

    public final void cancel() {
        EmojiCaptureReporter emojiCaptureReporter;
        long j;
        AppMethodBeat.i(3065);
        a aVar = this.lnA;
        if (aVar != null) {
            aVar.onCancel();
        }
        this.jgG.clearFocus();
        if (this.lnD) {
            emojiCaptureReporter = this.lha;
            if (emojiCaptureReporter == null) {
                j.avw("reporter");
            }
            j = emojiCaptureReporter.ezZ;
            emojiCaptureReporter = this.lha;
            if (emojiCaptureReporter == null) {
                j.avw("reporter");
            }
            EmojiCaptureReporter.a(16, j, 0, 0, 0, 0, 0, 0, 0, emojiCaptureReporter.scene);
        }
        emojiCaptureReporter = this.lha;
        if (emojiCaptureReporter == null) {
            j.avw("reporter");
        }
        j = emojiCaptureReporter.ezZ;
        emojiCaptureReporter = this.lha;
        if (emojiCaptureReporter == null) {
            j.avw("reporter");
        }
        EmojiCaptureReporter.a(14, j, 0, 0, 0, 0, 0, 0, 0, emojiCaptureReporter.scene);
        AppMethodBeat.o(3065);
    }

    private final void setImeVisibility(boolean z) {
        AppMethodBeat.i(3066);
        if (z) {
            post(this.lnE);
            AppMethodBeat.o(3066);
            return;
        }
        removeCallbacks(this.lnE);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.o(3066);
            return;
        }
        AppMethodBeat.o(3066);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.i(3067);
        if (z) {
            setVisibility(0);
            setPadding(0, 0, 0, this.lnB);
            AppMethodBeat.o(3067);
            return;
        }
        this.lnC = true;
        setVisibility(8);
        AppMethodBeat.o(3067);
    }

    public final boolean jn(int i) {
        AppMethodBeat.i(3068);
        this.lnB = i;
        boolean z = i > ak.fr(getContext());
        if (!this.lnC) {
            AppMethodBeat.o(3068);
            return false;
        } else if (z) {
            this.lnC = false;
            AppMethodBeat.o(3068);
            return false;
        } else {
            AppMethodBeat.o(3068);
            return true;
        }
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(3069);
        super.setVisibility(i);
        if (i == 0) {
            this.jgG.requestFocus();
        }
        AppMethodBeat.o(3069);
    }

    public final void setOnVisibleChangeCallback(a.f.a.b<? super Boolean, y> bVar) {
    }
}
