package com.tencent.p177mm.plugin.emojicapture.p389ui.editor;

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
import com.tencent.p177mm.emoji.view.InsectRelativeLayout;
import com.tencent.p177mm.media.editor.view.TextColorSelector;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.p389ui.C20443a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0014\u001a\u000201J\u0010\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020)H\u0016J\u0010\u00105\u001a\u0002012\u0006\u00106\u001a\u00020)H\u0002J-\u00107\u001a\u0002012#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110)¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(6\u0012\u0004\u0012\u000201\u0018\u000108H\u0016J\u0010\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020)H\u0016J\u0010\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020\nH\u0016J\u0018\u0010?\u001a\u0002012\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\nR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "setCallback", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;)V", "cancel", "Landroid/view/View;", "colorSelector", "Lcom/tencent/mm/media/editor/view/TextColorSelector;", "confirm", "deleteIcon", "Landroid/widget/ImageView;", "input", "Landroid/widget/EditText;", "lastBottom", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "selectedColor", "selectedStrokeColor", "showImeRunnable", "Ljava/lang/Runnable;", "textChanged", "", "getTextChanged", "()Z", "setTextChanged", "(Z)V", "waitKeyBoardShown", "windowVisibleRect", "Landroid/graphics/Rect;", "", "insectBottom", "bottom", "isShow", "setImeVisibility", "visible", "setOnVisibleChangeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setShow", "show", "setVisibility", "visibility", "setup", "text", "", "textColor", "AddTextCallback", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView */
public final class EditorChangeTextView extends InsectRelativeLayout {
    private final String TAG;
    EditText jgG;
    public EmojiCaptureReporter lha;
    private C11632a lnA;
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

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "", "onCancel", "", "onConfirm", "text", "", "color", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$a */
    public interface C11632a {
        /* renamed from: i */
        void mo23379i(CharSequence charSequence, int i);

        void onCancel();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$6 */
    static final class C204576 extends C25053k implements C17126b<Integer, C37091y> {
        final /* synthetic */ EditorChangeTextView lnF;

        C204576(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(3060);
            int intValue = ((Number) obj).intValue();
            this.lnF.lnx = C20443a.bnQ()[intValue];
            this.lnF.lny = C20443a.bnR()[intValue];
            this.lnF.jgG.setTextColor(this.lnF.lnx);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(3060);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$5 */
    static final class C204585 implements OnClickListener {
        final /* synthetic */ EditorChangeTextView lnF;

        C204585(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(3059);
            this.lnF.jgG.setText("");
            AppMethodBeat.m2505o(3059);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$b */
    static final class C20459b implements Runnable {
        final /* synthetic */ EditorChangeTextView lnF;

        C20459b(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void run() {
            AppMethodBeat.m2504i(3062);
            InputMethodManager inputMethodManager = (InputMethodManager) this.lnF.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.lnF.jgG, 0);
                AppMethodBeat.m2505o(3062);
                return;
            }
            AppMethodBeat.m2505o(3062);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$1 */
    static final class C204601 implements OnFocusChangeListener {
        final /* synthetic */ EditorChangeTextView lnF;

        C204601(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(3054);
            EditorChangeTextView.m31609a(this.lnF, z);
            AppMethodBeat.m2505o(3054);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$3 */
    static final class C204613 implements OnClickListener {
        final /* synthetic */ EditorChangeTextView lnF;

        C204613(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(3057);
            this.lnF.cancel();
            AppMethodBeat.m2505o(3057);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$4 */
    static final class C204624 implements OnClickListener {
        final /* synthetic */ EditorChangeTextView lnF;

        C204624(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(3058);
            Editable text = this.lnF.jgG.getText();
            C11632a callback = this.lnF.getCallback();
            if (callback != null) {
                callback.mo23379i(text, this.lnF.lnx);
            }
            this.lnF.jgG.clearFocus();
            if (this.lnF.getTextChanged()) {
                EmojiCaptureReporter.m66031a(16, this.lnF.getReporter().ezZ, 0, 0, 0, 0, 0, 0, 0, this.lnF.getReporter().scene);
            }
            EmojiCaptureReporter.m66031a(15, this.lnF.getReporter().ezZ, 0, 0, 0, 0, 0, 0, 0, this.lnF.getReporter().scene);
            AppMethodBeat.m2505o(3058);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$7 */
    static final class C204637 implements OnClickListener {
        final /* synthetic */ EditorChangeTextView lnF;

        C204637(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(3061);
            this.lnF.jgG.requestFocus();
            EditorChangeTextView.m31609a(this.lnF, true);
            AppMethodBeat.m2505o(3061);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView$2 */
    public static final class C204642 implements TextWatcher {
        final /* synthetic */ EditorChangeTextView lnF;

        C204642(EditorChangeTextView editorChangeTextView) {
            this.lnF = editorChangeTextView;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(3055);
            if (editable != null) {
                if ((((CharSequence) editable).length() > 0 ? 1 : 0) != 0) {
                    this.lnF.lnv.setVisibility(0);
                    AppMethodBeat.m2505o(3055);
                    return;
                }
            }
            this.lnF.lnv.setVisibility(8);
            AppMethodBeat.m2505o(3055);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(3056);
            this.lnF.setTextChanged(true);
            AppMethodBeat.m2505o(3056);
        }
    }

    public EditorChangeTextView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(3070);
        this.TAG = "EditorChangeTextView";
        this.lnz = new Rect();
        View.inflate(context, 2130969324, this);
        View findViewById = findViewById(2131823410);
        C25052j.m39375o(findViewById, "findViewById(R.id.change_text_input)");
        this.jgG = (EditText) findViewById;
        findViewById = findViewById(2131823404);
        C25052j.m39375o(findViewById, "findViewById(R.id.change_text_cancel)");
        this.lnt = findViewById;
        findViewById = findViewById(2131823405);
        C25052j.m39375o(findViewById, "findViewById(R.id.change_text_confirm)");
        this.lnu = findViewById;
        findViewById = findViewById(2131823430);
        C25052j.m39375o(findViewById, "findViewById(R.id.text_color_selector)");
        this.lnw = (TextColorSelector) findViewById;
        findViewById = findViewById(2131823429);
        C25052j.m39375o(findViewById, "findViewById(R.id.delete_text)");
        this.lnv = (ImageView) findViewById;
        this.jgG.setOnFocusChangeListener(new C204601(this));
        this.jgG.addTextChangedListener(new C204642(this));
        this.lnt.setOnClickListener(new C204613(this));
        this.lnu.setOnClickListener(new C204624(this));
        this.lnv.setOnClickListener(new C204585(this));
        this.lnw.setColorList(C20443a.bnQ());
        this.lnw.setSelected(0);
        this.lnw.setColorSelectedCallback(new C204576(this));
        setOnClickListener(new C204637(this));
        this.lnE = new C20459b(this);
        AppMethodBeat.m2505o(3070);
    }

    public EditorChangeTextView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(3071);
        AppMethodBeat.m2505o(3071);
    }

    public final C11632a getCallback() {
        return this.lnA;
    }

    public final void setCallback(C11632a c11632a) {
        this.lnA = c11632a;
    }

    public final boolean getTextChanged() {
        return this.lnD;
    }

    public final void setTextChanged(boolean z) {
        this.lnD = z;
    }

    public final EmojiCaptureReporter getReporter() {
        AppMethodBeat.m2504i(3063);
        EmojiCaptureReporter emojiCaptureReporter = this.lha;
        if (emojiCaptureReporter == null) {
            C25052j.avw("reporter");
        }
        AppMethodBeat.m2505o(3063);
        return emojiCaptureReporter;
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        AppMethodBeat.m2504i(3064);
        C25052j.m39376p(emojiCaptureReporter, "<set-?>");
        this.lha = emojiCaptureReporter;
        AppMethodBeat.m2505o(3064);
    }

    public final void cancel() {
        EmojiCaptureReporter emojiCaptureReporter;
        long j;
        AppMethodBeat.m2504i(3065);
        C11632a c11632a = this.lnA;
        if (c11632a != null) {
            c11632a.onCancel();
        }
        this.jgG.clearFocus();
        if (this.lnD) {
            emojiCaptureReporter = this.lha;
            if (emojiCaptureReporter == null) {
                C25052j.avw("reporter");
            }
            j = emojiCaptureReporter.ezZ;
            emojiCaptureReporter = this.lha;
            if (emojiCaptureReporter == null) {
                C25052j.avw("reporter");
            }
            EmojiCaptureReporter.m66031a(16, j, 0, 0, 0, 0, 0, 0, 0, emojiCaptureReporter.scene);
        }
        emojiCaptureReporter = this.lha;
        if (emojiCaptureReporter == null) {
            C25052j.avw("reporter");
        }
        j = emojiCaptureReporter.ezZ;
        emojiCaptureReporter = this.lha;
        if (emojiCaptureReporter == null) {
            C25052j.avw("reporter");
        }
        EmojiCaptureReporter.m66031a(14, j, 0, 0, 0, 0, 0, 0, 0, emojiCaptureReporter.scene);
        AppMethodBeat.m2505o(3065);
    }

    private final void setImeVisibility(boolean z) {
        AppMethodBeat.m2504i(3066);
        if (z) {
            post(this.lnE);
            AppMethodBeat.m2505o(3066);
            return;
        }
        removeCallbacks(this.lnE);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            AppMethodBeat.m2505o(3066);
            return;
        }
        AppMethodBeat.m2505o(3066);
    }

    public final void setShow(boolean z) {
        AppMethodBeat.m2504i(3067);
        if (z) {
            setVisibility(0);
            setPadding(0, 0, 0, this.lnB);
            AppMethodBeat.m2505o(3067);
            return;
        }
        this.lnC = true;
        setVisibility(8);
        AppMethodBeat.m2505o(3067);
    }

    /* renamed from: jn */
    public final boolean mo20726jn(int i) {
        AppMethodBeat.m2504i(3068);
        this.lnB = i;
        boolean z = i > C5230ak.m7988fr(getContext());
        if (!this.lnC) {
            AppMethodBeat.m2505o(3068);
            return false;
        } else if (z) {
            this.lnC = false;
            AppMethodBeat.m2505o(3068);
            return false;
        } else {
            AppMethodBeat.m2505o(3068);
            return true;
        }
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(3069);
        super.setVisibility(i);
        if (i == 0) {
            this.jgG.requestFocus();
        }
        AppMethodBeat.m2505o(3069);
    }

    public final void setOnVisibleChangeCallback(C17126b<? super Boolean, C37091y> c17126b) {
    }
}
