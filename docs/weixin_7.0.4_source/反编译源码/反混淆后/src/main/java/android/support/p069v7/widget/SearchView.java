package android.support.p069v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C41519f;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.view.C0605c;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.SearchView */
public class SearchView extends LinearLayoutCompat implements C0605c {
    static final C25376a arq = new C25376a();
    /* renamed from: Up */
    private final OnItemSelectedListener f17706Up;
    final SearchAutoComplete aqC;
    private final View aqD;
    final View aqE;
    private final View aqF;
    final ImageView aqG;
    final ImageView aqH;
    final ImageView aqI;
    final ImageView aqJ;
    final View aqK;
    private C44967e aqL;
    private Rect aqM;
    private Rect aqN;
    private int[] aqO;
    private int[] aqP;
    private final ImageView aqQ;
    private final Drawable aqR;
    private final int aqS;
    private final int aqT;
    final Intent aqU;
    final Intent aqV;
    private final CharSequence aqW;
    private C44966c aqX;
    private C41535b aqY;
    OnFocusChangeListener aqZ;
    C37141d ara;
    private OnClickListener arb;
    boolean arc;
    private boolean ard;
    C41519f are;
    private boolean arf;
    private CharSequence arg;
    private boolean arh;
    private boolean ari;
    private boolean arj;
    private CharSequence ark;
    private CharSequence arl;
    private boolean arm;
    private int arn;
    SearchableInfo aro;
    Bundle arp;
    private final Runnable arr;
    private Runnable ars;
    private final WeakHashMap<String, ConstantState> art;
    OnKeyListener aru;
    private final OnEditorActionListener arv;
    private final OnItemClickListener arw;
    private TextWatcher arx;
    /* renamed from: di */
    private int f17707di;
    private final OnClickListener mOnClickListener;

    /* renamed from: android.support.v7.widget.SearchView$6 */
    class C84486 implements OnClickListener {
        C84486() {
        }

        public final void onClick(View view) {
            String str = null;
            if (view == SearchView.this.aqG) {
                SearchView.this.mo72210kK();
            } else if (view == SearchView.this.aqI) {
                SearchView.this.mo72209kJ();
            } else if (view == SearchView.this.aqH) {
                SearchView.this.mo72208kI();
            } else if (view == SearchView.this.aqJ) {
                SearchView searchView = SearchView.this;
                if (searchView.aro != null) {
                    SearchableInfo searchableInfo = searchView.aro;
                    try {
                        Intent intent;
                        String str2;
                        if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                            intent = new Intent(searchView.aqU);
                            ComponentName searchActivity = searchableInfo.getSearchActivity();
                            str2 = "calling_package";
                            if (searchActivity != null) {
                                str = searchActivity.flattenToShortString();
                            }
                            intent.putExtra(str2, str);
                            searchView.getContext().startActivity(intent);
                        } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                            String string;
                            Intent intent2 = searchView.aqV;
                            ComponentName searchActivity2 = searchableInfo.getSearchActivity();
                            intent = new Intent("android.intent.action.SEARCH");
                            intent.setComponent(searchActivity2);
                            PendingIntent activity = PendingIntent.getActivity(searchView.getContext(), 0, intent, ErrorDialogData.SUPPRESSED);
                            Bundle bundle = new Bundle();
                            if (searchView.arp != null) {
                                bundle.putParcelable("app_data", searchView.arp);
                            }
                            Intent intent3 = new Intent(intent2);
                            String str3 = "free_form";
                            int i = 1;
                            Resources resources = searchView.getResources();
                            if (searchableInfo.getVoiceLanguageModeId() != 0) {
                                string = resources.getString(searchableInfo.getVoiceLanguageModeId());
                            } else {
                                string = str3;
                            }
                            if (searchableInfo.getVoicePromptTextId() != 0) {
                                str2 = resources.getString(searchableInfo.getVoicePromptTextId());
                            } else {
                                str2 = null;
                            }
                            if (searchableInfo.getVoiceLanguageId() != 0) {
                                str3 = resources.getString(searchableInfo.getVoiceLanguageId());
                            } else {
                                str3 = null;
                            }
                            if (searchableInfo.getVoiceMaxResults() != 0) {
                                i = searchableInfo.getVoiceMaxResults();
                            }
                            intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
                            intent3.putExtra("android.speech.extra.PROMPT", str2);
                            intent3.putExtra("android.speech.extra.LANGUAGE", str3);
                            intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
                            String str4 = "calling_package";
                            if (searchActivity2 != null) {
                                str = searchActivity2.flattenToShortString();
                            }
                            intent3.putExtra(str4, str);
                            intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
                            intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
                            searchView.getContext().startActivity(intent3);
                        }
                    } catch (ActivityNotFoundException e) {
                    }
                }
            } else if (view == SearchView.this.aqC) {
                SearchView.this.mo72212kM();
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$SearchAutoComplete */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private SearchView arD;
        private boolean arE;
        final Runnable arF;
        private int mThreshold;

        /* renamed from: android.support.v7.widget.SearchView$SearchAutoComplete$1 */
        class C84491 implements Runnable {
            C84491() {
            }

            public final void run() {
                SearchAutoComplete.m14956b(SearchAutoComplete.this);
            }
        }

        /* renamed from: b */
        static /* synthetic */ void m14956b(SearchAutoComplete searchAutoComplete) {
            if (searchAutoComplete.arE) {
                ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                searchAutoComplete.arE = false;
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C25738R.attr.f5698g3);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.arF = new C84491();
            this.mThreshold = getThreshold();
        }

        /* Access modifiers changed, original: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* Access modifiers changed, original: 0000 */
        public void setSearchView(SearchView searchView) {
            this.arD = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.mThreshold = i;
        }

        /* Access modifiers changed, original: protected */
        public void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.arD.hasFocus() && getVisibility() == 0) {
                this.arE = true;
                if (SearchView.m82288ac(getContext())) {
                    SearchView.arq.mo42386c(this);
                }
            }
        }

        /* Access modifiers changed, original: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.arD.mo72211kL();
        }

        public boolean enoughToFilter() {
            return this.mThreshold <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.arD.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= VideoFilterUtil.IMAGE_HEIGHT && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i >= 600 || (i >= 640 && i2 >= 480)) {
                return C33250az.CTRL_INDEX;
            }
            return 160;
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.arE) {
                removeCallbacks(this.arF);
                post(this.arF);
            }
            return onCreateInputConnection;
        }

        private void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.arE = false;
                removeCallbacks(this.arF);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.arE = false;
                removeCallbacks(this.arF);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.arE = true;
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m14955a(SearchAutoComplete searchAutoComplete) {
            return TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0;
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$4 */
    class C174844 implements OnFocusChangeListener {
        C174844() {
        }

        public final void onFocusChange(View view, boolean z) {
            if (SearchView.this.aqZ != null) {
                SearchView.this.aqZ.onFocusChange(SearchView.this, z);
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$3 */
    class C253753 implements Runnable {
        C253753() {
        }

        public final void run() {
            if (SearchView.this.are != null && (SearchView.this.are instanceof C37143ax)) {
                SearchView.this.are.changeCursor(null);
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$a */
    static class C25376a {
        private Method arA;
        private Method arB;
        private Method arz;

        C25376a() {
            try {
                this.arz = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.arz.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.arA = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.arA.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.arB = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.arB.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo42384a(AutoCompleteTextView autoCompleteTextView) {
            if (this.arz != null) {
                try {
                    this.arz.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final void mo42385b(AutoCompleteTextView autoCompleteTextView) {
            if (this.arA != null) {
                try {
                    this.arA.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: c */
        public final void mo42386c(AutoCompleteTextView autoCompleteTextView) {
            if (this.arB != null) {
                try {
                    this.arB.invoke(autoCompleteTextView, new Object[]{Boolean.TRUE});
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$10 */
    class C3188310 implements OnItemSelectedListener {
        C3188310() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView searchView = SearchView.this;
            if (searchView.ara == null || !searchView.ara.mo59209kO()) {
                Editable text = searchView.aqC.getText();
                Cursor cursor = searchView.are.getCursor();
                if (cursor == null) {
                    return;
                }
                if (cursor.moveToPosition(i)) {
                    CharSequence convertToString = searchView.are.convertToString(cursor);
                    if (convertToString != null) {
                        searchView.setQuery(convertToString);
                        return;
                    } else {
                        searchView.setQuery(text);
                        return;
                    }
                }
                searchView.setQuery(text);
            }
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$1 */
    class C318841 implements Runnable {
        C318841() {
        }

        public final void run() {
            SearchView.this.mo72207kG();
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$2 */
    class C318852 implements TextWatcher {
        C318852() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.mo72213m(charSequence);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$5 */
    class C318865 implements OnLayoutChangeListener {
        C318865() {
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView searchView = SearchView.this;
            if (searchView.aqK.getWidth() > 1) {
                int dimensionPixelSize;
                int i9;
                Resources resources = searchView.getContext().getResources();
                int paddingLeft = searchView.aqE.getPaddingLeft();
                Rect rect = new Rect();
                boolean bW = C0709bk.m1576bW(searchView);
                if (searchView.arc) {
                    dimensionPixelSize = resources.getDimensionPixelSize(C25738R.dimen.f10092pu) + resources.getDimensionPixelSize(C25738R.dimen.f10091pt);
                } else {
                    dimensionPixelSize = 0;
                }
                searchView.aqC.getDropDownBackground().getPadding(rect);
                if (bW) {
                    i9 = -rect.left;
                } else {
                    i9 = paddingLeft - (rect.left + dimensionPixelSize);
                }
                searchView.aqC.setDropDownHorizontalOffset(i9);
                searchView.aqC.setDropDownWidth((dimensionPixelSize + ((searchView.aqK.getWidth() + rect.left) + rect.right)) - paddingLeft);
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$d */
    public interface C37141d {
        /* renamed from: kO */
        boolean mo59209kO();

        /* renamed from: kP */
        boolean mo59210kP();
    }

    /* renamed from: android.support.v7.widget.SearchView$8 */
    class C415328 implements OnEditorActionListener {
        C415328() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.mo72208kI();
            return true;
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$9 */
    class C415339 implements OnItemClickListener {
        C415339() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.mo72198cy(i);
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$SavedState */
    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C415341();
        boolean arC;

        /* renamed from: android.support.v7.widget.SearchView$SavedState$1 */
        static class C415341 implements ClassLoaderCreator<SavedState> {
            C415341() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.arC = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.arC));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.arC + "}";
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$b */
    public interface C41535b {
        boolean onClose();
    }

    /* renamed from: android.support.v7.widget.SearchView$7 */
    class C449657 implements OnKeyListener {
        C449657() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (SearchView.this.aro == null) {
                return false;
            }
            if (SearchView.this.aqC.isPopupShowing() && SearchView.this.aqC.getListSelection() != -1) {
                return SearchView.this.mo72196b(i, keyEvent);
            }
            if (SearchAutoComplete.m14955a(SearchView.this.aqC) || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView.this.mo72195U(SearchView.this.aqC.getText().toString());
            return true;
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$c */
    public interface C44966c {
        /* renamed from: kN */
        boolean mo72192kN();
    }

    /* renamed from: android.support.v7.widget.SearchView$e */
    static class C44967e extends TouchDelegate {
        private final View arH;
        private final Rect arI = new Rect();
        private final Rect arJ = new Rect();
        private final Rect arK = new Rect();
        private final int arL;
        private boolean arM;

        public C44967e(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.arL = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            mo72193c(rect, rect2);
            this.arH = view;
        }

        /* renamed from: c */
        public final void mo72193c(Rect rect, Rect rect2) {
            this.arI.set(rect);
            this.arK.set(rect);
            this.arK.inset(-this.arL, -this.arL);
            this.arJ.set(rect2);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.arI.contains(x, y)) {
                        this.arM = true;
                        z = true;
                        z2 = true;
                        break;
                    }
                case 1:
                case 2:
                    z2 = this.arM;
                    if (z2 && !this.arK.contains(x, y)) {
                        z = false;
                        break;
                    }
                case 3:
                    z2 = this.arM;
                    this.arM = false;
                    z = true;
                    break;
                default:
                    z = true;
                    z2 = false;
                    break;
            }
            z = true;
            if (!z2) {
                return false;
            }
            if (!z || this.arJ.contains(x, y)) {
                motionEvent.setLocation((float) (x - this.arJ.left), (float) (y - this.arJ.top));
            } else {
                motionEvent.setLocation((float) (this.arH.getWidth() / 2), (float) (this.arH.getHeight() / 2));
            }
            return this.arH.dispatchTouchEvent(motionEvent);
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5665f7);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqM = new Rect();
        this.aqN = new Rect();
        this.aqO = new int[2];
        this.aqP = new int[2];
        this.arr = new C318841();
        this.ars = new C253753();
        this.art = new WeakHashMap();
        this.mOnClickListener = new C84486();
        this.aru = new C449657();
        this.arv = new C415328();
        this.arw = new C415339();
        this.f17706Up = new C3188310();
        this.arx = new C318852();
        C0699bc a = C0699bc.m1555a(context, attributeSet, C0554a.SearchView, i, 0);
        LayoutInflater.from(context).inflate(a.getResourceId(4, 2130968608), this, true);
        this.aqC = (SearchAutoComplete) findViewById(2131820950);
        this.aqC.setSearchView(this);
        this.aqD = findViewById(2131820947);
        this.aqE = findViewById(2131820949);
        this.aqF = findViewById(2131820952);
        this.aqG = (ImageView) findViewById(2131820946);
        this.aqH = (ImageView) findViewById(2131820953);
        this.aqI = (ImageView) findViewById(2131820951);
        this.aqJ = (ImageView) findViewById(2131820954);
        this.aqQ = (ImageView) findViewById(2131820948);
        C0477s.m904a(this.aqE, a.getDrawable(15));
        C0477s.m904a(this.aqF, a.getDrawable(16));
        this.aqG.setImageDrawable(a.getDrawable(10));
        this.aqH.setImageDrawable(a.getDrawable(9));
        this.aqI.setImageDrawable(a.getDrawable(8));
        this.aqJ.setImageDrawable(a.getDrawable(12));
        this.aqQ.setImageDrawable(a.getDrawable(10));
        this.aqR = a.getDrawable(11);
        C0701be.m1558a(this.aqG, getResources().getString(C25738R.string.f8609l));
        this.aqS = a.getResourceId(14, 2130968607);
        this.aqT = a.getResourceId(13, 0);
        this.aqG.setOnClickListener(this.mOnClickListener);
        this.aqI.setOnClickListener(this.mOnClickListener);
        this.aqH.setOnClickListener(this.mOnClickListener);
        this.aqJ.setOnClickListener(this.mOnClickListener);
        this.aqC.setOnClickListener(this.mOnClickListener);
        this.aqC.addTextChangedListener(this.arx);
        this.aqC.setOnEditorActionListener(this.arv);
        this.aqC.setOnItemClickListener(this.arw);
        this.aqC.setOnItemSelectedListener(this.f17706Up);
        this.aqC.setOnKeyListener(this.aru);
        this.aqC.setOnFocusChangeListener(new C174844());
        setIconifiedByDefault(a.getBoolean(5, true));
        int dimensionPixelSize = a.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.aqW = a.getText(7);
        this.arg = a.getText(6);
        dimensionPixelSize = a.getInt(3, -1);
        if (dimensionPixelSize != -1) {
            setImeOptions(dimensionPixelSize);
        }
        dimensionPixelSize = a.getInt(2, -1);
        if (dimensionPixelSize != -1) {
            setInputType(dimensionPixelSize);
        }
        setFocusable(a.getBoolean(0, true));
        a.atG.recycle();
        this.aqU = new Intent("android.speech.action.WEB_SEARCH");
        this.aqU.addFlags(268435456);
        this.aqU.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.aqV = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.aqV.addFlags(268435456);
        this.aqK = findViewById(this.aqC.getDropDownAnchor());
        if (this.aqK != null) {
            this.aqK.addOnLayoutChangeListener(new C318865());
        }
        m82289aq(this.arc);
        m82299kH();
    }

    /* Access modifiers changed, original: 0000 */
    public int getSuggestionRowLayout() {
        return this.aqS;
    }

    /* Access modifiers changed, original: 0000 */
    public int getSuggestionCommitIconResId() {
        return this.aqT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSearchableInfo(SearchableInfo searchableInfo) {
        boolean z = true;
        this.aro = searchableInfo;
        if (this.aro != null) {
            this.aqC.setThreshold(this.aro.getSuggestThreshold());
            this.aqC.setImeOptions(this.aro.getImeOptions());
            int inputType = this.aro.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.aro.getSuggestAuthority() != null) {
                    inputType = (inputType | 65536) | SQLiteGlobal.journalSizeLimit;
                }
            }
            this.aqC.setInputType(inputType);
            if (this.are != null) {
                this.are.changeCursor(null);
            }
            if (this.aro.getSuggestAuthority() != null) {
                int i;
                this.are = new C37143ax(getContext(), this, this.aro, this.art);
                this.aqC.setAdapter(this.are);
                C37143ax c37143ax = (C37143ax) this.are;
                if (this.arh) {
                    i = 2;
                } else {
                    i = 1;
                }
                c37143ax.asC = i;
            }
            m82299kH();
        }
        if (this.aro != null && this.aro.getVoiceSearchEnabled()) {
            Intent intent;
            if (this.aro.getVoiceSearchLaunchWebSearch()) {
                intent = this.aqU;
            } else if (this.aro.getVoiceSearchLaunchRecognizer()) {
                intent = this.aqV;
            } else {
                intent = null;
            }
            if (intent != null) {
                if (getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
                    z = false;
                }
                this.arj = z;
                if (this.arj) {
                    this.aqC.setPrivateImeOptions("nm");
                }
                m82289aq(this.ard);
            }
        }
        z = false;
        this.arj = z;
        if (this.arj) {
        }
        m82289aq(this.ard);
    }

    public void setAppSearchData(Bundle bundle) {
        this.arp = bundle;
    }

    public void setImeOptions(int i) {
        this.aqC.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.aqC.getImeOptions();
    }

    public void setInputType(int i) {
        this.aqC.setInputType(i);
    }

    public int getInputType() {
        return this.aqC.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.ari || !isFocusable()) {
            return false;
        }
        if (this.ard) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.aqC.requestFocus(i, rect);
        if (requestFocus) {
            m82289aq(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.ari = true;
        super.clearFocus();
        this.aqC.clearFocus();
        this.aqC.setImeVisibility(false);
        this.ari = false;
    }

    public void setOnQueryTextListener(C44966c c44966c) {
        this.aqX = c44966c;
    }

    public void setOnCloseListener(C41535b c41535b) {
        this.aqY = c41535b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.aqZ = onFocusChangeListener;
    }

    public void setOnSuggestionListener(C37141d c37141d) {
        this.ara = c37141d;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.arb = onClickListener;
    }

    public CharSequence getQuery() {
        return this.aqC.getText();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.arg = charSequence;
        m82299kH();
    }

    public CharSequence getQueryHint() {
        if (this.arg != null) {
            return this.arg;
        }
        if (this.aro == null || this.aro.getHintId() == 0) {
            return this.aqW;
        }
        return getContext().getText(this.aro.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.arc != z) {
            this.arc = z;
            m82289aq(z);
            m82299kH();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            mo72209kJ();
        } else {
            mo72210kK();
        }
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.arf = z;
        m82289aq(this.ard);
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.arh = z;
        if (this.are instanceof C37143ax) {
            int i;
            C37143ax c37143ax = (C37143ax) this.are;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            c37143ax.asC = i;
        }
    }

    public void setSuggestionsAdapter(C41519f c41519f) {
        this.are = c41519f;
        this.aqC.setAdapter(this.are);
    }

    public C41519f getSuggestionsAdapter() {
        return this.are;
    }

    public void setMaxWidth(int i) {
        this.f17707di = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f17707di;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (this.ard) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case C8415j.INVALID_ID /*-2147483648*/:
                if (this.f17707di <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f17707di, size);
                    break;
                }
            case 0:
                if (this.f17707di <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f17707di;
                    break;
                }
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                if (this.f17707di > 0) {
                    size = Math.min(this.f17707di, size);
                    break;
                }
                break;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        switch (mode2) {
            case C8415j.INVALID_ID /*-2147483648*/:
                mode = Math.min(getPreferredHeight(), mode);
                break;
            case 0:
                mode = getPreferredHeight();
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(mode, ErrorDialogData.SUPPRESSED));
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.aqC;
            Rect rect = this.aqM;
            searchAutoComplete.getLocationInWindow(this.aqO);
            getLocationInWindow(this.aqP);
            int i5 = this.aqO[1] - this.aqP[1];
            int i6 = this.aqO[0] - this.aqP[0];
            rect.set(i6, i5, searchAutoComplete.getWidth() + i6, searchAutoComplete.getHeight() + i5);
            this.aqN.set(this.aqM.left, 0, this.aqM.right, i4 - i2);
            if (this.aqL == null) {
                this.aqL = new C44967e(this.aqN, this.aqM, this.aqC);
                setTouchDelegate(this.aqL);
                return;
            }
            this.aqL.mo72193c(this.aqN, this.aqM);
        }
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10102q4);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10101q3);
    }

    /* renamed from: aq */
    private void m82289aq(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.ard = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.aqC.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.aqG.setVisibility(i2);
        m82290ar(z2);
        View view = this.aqD;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.aqQ.getDrawable() == null || this.arc)) {
            i = 0;
        }
        this.aqQ.setVisibility(i);
        m82297kE();
        if (z2) {
            z3 = false;
        }
        m82291as(z3);
        m82296kD();
    }

    /* renamed from: kC */
    private boolean m82295kC() {
        return (this.arf || this.arj) && !this.ard;
    }

    /* renamed from: ar */
    private void m82290ar(boolean z) {
        int i = 8;
        if (this.arf && m82295kC() && hasFocus() && (z || !this.arj)) {
            i = 0;
        }
        this.aqH.setVisibility(i);
    }

    /* renamed from: kD */
    private void m82296kD() {
        int i = 8;
        if (m82295kC() && (this.aqH.getVisibility() == 0 || this.aqJ.getVisibility() == 0)) {
            i = 0;
        }
        this.aqF.setVisibility(i);
    }

    /* renamed from: kE */
    private void m82297kE() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.aqC.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.arc || this.arm)) {
            i = 0;
        }
        ImageView imageView = this.aqI;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.aqI.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* renamed from: kF */
    private void m82298kF() {
        post(this.arr);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kG */
    public final void mo72207kG() {
        int[] iArr = this.aqC.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.aqE.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = this.aqF.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        invalidate();
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.arr);
        post(this.ars);
        super.onDetachedFromWindow();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo72196b(int i, KeyEvent keyEvent) {
        if (this.aro == null || this.are == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return mo72198cy(this.aqC.getListSelection());
        }
        if (i == 21 || i == 22) {
            int i2;
            if (i == 21) {
                i2 = 0;
            } else {
                i2 = this.aqC.length();
            }
            this.aqC.setSelection(i2);
            this.aqC.setListSelection(0);
            this.aqC.clearListSelection();
            arq.mo42386c(this.aqC);
            return true;
        }
        if (!(i == 19 && this.aqC.getListSelection() == 0)) {
        }
        return false;
    }

    /* renamed from: l */
    private CharSequence m82300l(CharSequence charSequence) {
        if (!this.arc || this.aqR == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.aqC.getTextSize()) * 1.25d);
        this.aqR.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.aqR), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* renamed from: kH */
    private void m82299kH() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.aqC;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m82300l(queryHint));
    }

    /* renamed from: as */
    private void m82291as(boolean z) {
        int i;
        if (this.arj && !this.ard && z) {
            i = 0;
            this.aqH.setVisibility(8);
        } else {
            i = 8;
        }
        this.aqJ.setVisibility(i);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: m */
    public final void mo72213m(CharSequence charSequence) {
        boolean z = true;
        Editable text = this.aqC.getText();
        this.arl = text;
        boolean z2 = !TextUtils.isEmpty(text);
        m82290ar(z2);
        if (z2) {
            z = false;
        }
        m82291as(z);
        m82297kE();
        m82296kD();
        if (!(this.aqX == null || TextUtils.equals(charSequence, this.ark))) {
            charSequence.toString();
        }
        this.ark = charSequence.toString();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kI */
    public final void mo72208kI() {
        Editable text = this.aqC.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.aqX != null) {
                C44966c c44966c = this.aqX;
                text.toString();
                if (c44966c.mo72192kN()) {
                    return;
                }
            }
            if (this.aro != null) {
                mo72195U(text.toString());
            }
            this.aqC.setImeVisibility(false);
            this.aqC.dismissDropDown();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kJ */
    public final void mo72209kJ() {
        if (!TextUtils.isEmpty(this.aqC.getText())) {
            this.aqC.setText("");
            this.aqC.requestFocus();
            this.aqC.setImeVisibility(true);
        } else if (!this.arc) {
        } else {
            if (this.aqY == null || !this.aqY.onClose()) {
                clearFocus();
                m82289aq(true);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kK */
    public final void mo72210kK() {
        m82289aq(false);
        this.aqC.requestFocus();
        this.aqC.setImeVisibility(true);
        if (this.arb != null) {
            this.arb.onClick(this);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m82298kF();
    }

    public final void onActionViewCollapsed() {
        String str = "";
        this.aqC.setText(str);
        this.aqC.setSelection(this.aqC.length());
        this.arl = str;
        clearFocus();
        m82289aq(true);
        this.aqC.setImeOptions(this.arn);
        this.arm = false;
    }

    public final void onActionViewExpanded() {
        if (!this.arm) {
            this.arm = true;
            this.arn = this.aqC.getImeOptions();
            this.aqC.setImeOptions(this.arn | 33554432);
            this.aqC.setText("");
            setIconified(false);
        }
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.arC = this.ard;
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.f507LC);
            m82289aq(savedState.arC);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cy */
    public final boolean mo72198cy(int i) {
        if (this.ara != null && this.ara.mo59210kP()) {
            return false;
        }
        m82293cz(i);
        this.aqC.setImeVisibility(false);
        this.aqC.dismissDropDown();
        return true;
    }

    /* renamed from: cz */
    private boolean m82293cz(int i) {
        Cursor cursor = this.are.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        m82294d(m82292b(cursor));
        return true;
    }

    /* renamed from: d */
    private void m82294d(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                new StringBuilder("Failed launch activity: ").append(intent);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setQuery(CharSequence charSequence) {
        this.aqC.setText(charSequence);
        this.aqC.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* Access modifiers changed, original: final */
    /* renamed from: U */
    public final void mo72195U(String str) {
        getContext().startActivity(m82287a("android.intent.action.SEARCH", null, null, str));
    }

    /* renamed from: a */
    private Intent m82287a(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.arl);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.arp != null) {
            intent.putExtra("app_data", this.arp);
        }
        intent.setComponent(this.aro.getSearchActivity());
        return intent;
    }

    /* renamed from: b */
    private Intent m82292b(Cursor cursor) {
        try {
            String str;
            String a = C37143ax.m62174a(cursor, "suggest_intent_action");
            if (a == null) {
                a = this.aro.getSuggestIntentAction();
            }
            if (a == null) {
                str = "android.intent.action.SEARCH";
            } else {
                str = a;
            }
            a = C37143ax.m62174a(cursor, "suggest_intent_data");
            if (a == null) {
                a = this.aro.getSuggestIntentData();
            }
            if (a != null) {
                String a2 = C37143ax.m62174a(cursor, "suggest_intent_data_id");
                if (a2 != null) {
                    a = a + "/" + Uri.encode(a2);
                }
            }
            return m82287a(str, a == null ? null : Uri.parse(a), C37143ax.m62174a(cursor, "suggest_intent_extra_data"), C37143ax.m62174a(cursor, "suggest_intent_query"));
        } catch (RuntimeException e) {
            int position;
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e2) {
                position = -1;
            }
            new StringBuilder("Search suggestions cursor at row ").append(position).append(" returned exception.");
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kM */
    public final void mo72212kM() {
        arq.mo42384a(this.aqC);
        arq.mo42385b(this.aqC);
    }

    /* renamed from: ac */
    static boolean m82288ac(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kL */
    public final void mo72211kL() {
        m82289aq(this.ard);
        m82298kF();
        if (this.aqC.hasFocus()) {
            mo72212kM();
        }
    }
}
