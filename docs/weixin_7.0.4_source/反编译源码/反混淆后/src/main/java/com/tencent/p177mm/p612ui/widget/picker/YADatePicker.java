package com.tencent.p177mm.p612ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1594cg.C41922a.C41921a;
import com.tencent.p177mm.p612ui.C5227ai;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.tencent.mm.ui.widget.picker.YADatePicker */
public class YADatePicker extends FrameLayout {
    private static final String LOG_TAG = YADatePicker.class.getSimpleName();
    public final C16010b zSI;

    /* renamed from: com.tencent.mm.ui.widget.picker.YADatePicker$b */
    public interface C16010b {
        /* renamed from: a */
        void mo28347a(int i, int i2, int i3, C44398d c44398d);

        /* renamed from: d */
        Parcelable mo28348d(Parcelable parcelable);

        Calendar dLo();

        Calendar dLp();

        boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        CalendarView getCalendarView();

        boolean getCalendarViewShown();

        int getDayOfMonth();

        int getFirstDayOfWeek();

        int getMonth();

        boolean getSpinnersShown();

        int getYear();

        boolean isEnabled();

        void onConfigurationChanged(Configuration configuration);

        void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onRestoreInstanceState(Parcelable parcelable);

        void setCalendarViewShown(boolean z);

        void setEnabled(boolean z);

        void setFirstDayOfWeek(int i);

        void setMaxDate(long j);

        void setMinDate(long j);

        void setSpinnersShown(boolean z);

        void setValidationCallback(C40904e c40904e);
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.YADatePicker$c */
    public static class C16012c extends C30807a {
        Calendar jkB;
        private String[] jkC;
        public final NumberPicker zSN;
        public final NumberPicker zSO;
        public final NumberPicker zSP;
        private final LinearLayout zSQ;
        private final EditText zSR;
        private final EditText zSS;
        private final EditText zST;
        private final CalendarView zSU;
        private final DateFormat zSV = new SimpleDateFormat("MM/dd/yyyy");
        private int zSW;
        private Calendar zSX;
        private Calendar zSY;
        Calendar zSZ;
        private boolean zTa = true;

        /* renamed from: com.tencent.mm.ui.widget.picker.YADatePicker$c$2 */
        class C160112 implements OnDateChangeListener {
            C160112() {
            }

            public final void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
                AppMethodBeat.m2504i(112871);
                C16012c.this.mo28371aE(i, i2, i3);
                C16012c.this.dLs();
                C16012c.m24328b(C16012c.this);
                AppMethodBeat.m2505o(112871);
            }
        }

        /* renamed from: com.tencent.mm.ui.widget.picker.YADatePicker$c$1 */
        class C160131 implements OnValueChangeListener {
            C160131() {
            }

            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                AppMethodBeat.m2504i(112870);
                C16012c.m24326a(C16012c.this);
                C16012c.this.jkB.setTimeInMillis(C16012c.this.zSZ.getTimeInMillis());
                if (numberPicker == C16012c.this.zSN) {
                    int actualMaximum = C16012c.this.jkB.getActualMaximum(5);
                    if (i == actualMaximum && i2 == 1) {
                        C16012c.this.jkB.add(5, 1);
                    } else if (i == 1 && i2 == actualMaximum) {
                        C16012c.this.jkB.add(5, -1);
                    } else {
                        C16012c.this.jkB.add(5, i2 - i);
                    }
                } else if (numberPicker == C16012c.this.zSO) {
                    if (i == 11 && i2 == 0) {
                        C16012c.this.jkB.add(2, 1);
                    } else if (i == 0 && i2 == 11) {
                        C16012c.this.jkB.add(2, -1);
                    } else {
                        C16012c.this.jkB.add(2, i2 - i);
                    }
                } else if (numberPicker == C16012c.this.zSP) {
                    C16012c.this.jkB.set(1, i2);
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                    AppMethodBeat.m2505o(112870);
                    throw illegalArgumentException;
                }
                C16012c.this.mo28371aE(C16012c.this.jkB.get(1), C16012c.this.jkB.get(2), C16012c.this.jkB.get(5));
                C16012c.this.dLs();
                C16012c.this.dLt();
                C16012c.m24328b(C16012c.this);
                AppMethodBeat.m2505o(112870);
            }
        }

        public final /* bridge */ /* synthetic */ void setValidationCallback(C40904e c40904e) {
            AppMethodBeat.m2504i(112902);
            super.setValidationCallback(c40904e);
            AppMethodBeat.m2505o(112902);
        }

        C16012c(YADatePicker yADatePicker, Context context, AttributeSet attributeSet, int i) {
            super(yADatePicker, context);
            AppMethodBeat.m2504i(112872);
            this.zSJ = yADatePicker;
            this.mContext = context;
            mo28374f(Locale.getDefault());
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C41921a.DatePicker, i, 0);
            boolean z = obtainStyledAttributes.getBoolean(3, true);
            boolean z2 = obtainStyledAttributes.getBoolean(4, true);
            int i2 = obtainStyledAttributes.getInt(13, 1900);
            int i3 = obtainStyledAttributes.getInt(14, 2100);
            String string = obtainStyledAttributes.getString(1);
            String string2 = obtainStyledAttributes.getString(2);
            int resourceId = obtainStyledAttributes.getResourceId(6, 2130969261);
            obtainStyledAttributes.recycle();
            ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(resourceId, this.zSJ, true);
            C160131 c160131 = new C160131();
            this.zSQ = (LinearLayout) this.zSJ.findViewById(2131823191);
            this.zSU = (CalendarView) this.zSJ.findViewById(2131823195);
            this.zSU.setOnDateChangeListener(new C160112());
            this.zSN = (NumberPicker) this.zSJ.findViewById(2131823193);
            this.zSN.setFormatter(new C24106g());
            this.zSN.setOnLongPressUpdateInterval(100);
            this.zSN.setOnValueChangedListener(c160131);
            this.zSR = C24104e.m37071b(this.zSN);
            this.zSO = (NumberPicker) this.zSJ.findViewById(2131823192);
            this.zSO.setMinValue(0);
            this.zSO.setMaxValue(this.zSW - 1);
            this.zSO.setDisplayedValues(this.jkC);
            this.zSO.setOnLongPressUpdateInterval(200);
            this.zSO.setOnValueChangedListener(c160131);
            this.zSS = C24104e.m37071b(this.zSO);
            this.zSP = (NumberPicker) this.zSJ.findViewById(2131823194);
            this.zSP.setOnLongPressUpdateInterval(100);
            this.zSP.setOnValueChangedListener(c160131);
            this.zST = C24104e.m37071b(this.zSP);
            if (z || z2) {
                setSpinnersShown(z);
                setCalendarViewShown(z2);
            } else {
                setSpinnersShown(true);
            }
            this.jkB.clear();
            if (TextUtils.isEmpty(string) || !m24327a(string, this.jkB)) {
                this.jkB.set(i2, 0, 1);
            }
            setMinDate(this.jkB.getTimeInMillis());
            this.jkB.clear();
            if (TextUtils.isEmpty(string2) || !m24327a(string2, this.jkB)) {
                this.jkB.set(i3, 11, 31);
            }
            setMaxDate(this.jkB.getTimeInMillis());
            this.zSZ.setTimeInMillis(System.currentTimeMillis());
            mo28347a(this.zSZ.get(1), this.zSZ.get(2), this.zSZ.get(5), null);
            dLr();
            if (this.zSJ.getImportantForAccessibility() == 0) {
                this.zSJ.setImportantForAccessibility(1);
            }
            AppMethodBeat.m2505o(112872);
        }

        /* renamed from: a */
        public final void mo28347a(int i, int i2, int i3, C44398d c44398d) {
            AppMethodBeat.m2504i(112873);
            mo28371aE(i, i2, i3);
            dLs();
            dLt();
            this.zSL = c44398d;
            AppMethodBeat.m2505o(112873);
        }

        public final int getYear() {
            AppMethodBeat.m2504i(112874);
            int i = this.zSZ.get(1);
            AppMethodBeat.m2505o(112874);
            return i;
        }

        public final int getMonth() {
            AppMethodBeat.m2504i(112875);
            int i = this.zSZ.get(2);
            AppMethodBeat.m2505o(112875);
            return i;
        }

        public final int getDayOfMonth() {
            AppMethodBeat.m2504i(112876);
            int i = this.zSZ.get(5);
            AppMethodBeat.m2505o(112876);
            return i;
        }

        public final int getFirstDayOfWeek() {
            AppMethodBeat.m2504i(112877);
            int firstDayOfWeek = this.zSU.getFirstDayOfWeek();
            AppMethodBeat.m2505o(112877);
            return firstDayOfWeek;
        }

        public final void setFirstDayOfWeek(int i) {
            AppMethodBeat.m2504i(112878);
            this.zSU.setFirstDayOfWeek(i);
            AppMethodBeat.m2505o(112878);
        }

        public final Calendar dLo() {
            AppMethodBeat.m2504i(112879);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.zSU.getMinDate());
            AppMethodBeat.m2505o(112879);
            return instance;
        }

        public final void setMinDate(long j) {
            AppMethodBeat.m2504i(112880);
            this.jkB.setTimeInMillis(j);
            if (this.jkB.get(1) != this.zSX.get(1) || this.jkB.get(6) == this.zSX.get(6)) {
                this.zSX.setTimeInMillis(j);
                this.zSU.setMinDate(j);
                if (this.zSZ.before(this.zSX)) {
                    this.zSZ.setTimeInMillis(this.zSX.getTimeInMillis());
                    dLt();
                }
                dLs();
                AppMethodBeat.m2505o(112880);
                return;
            }
            AppMethodBeat.m2505o(112880);
        }

        public final Calendar dLp() {
            AppMethodBeat.m2504i(112881);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.zSU.getMaxDate());
            AppMethodBeat.m2505o(112881);
            return instance;
        }

        public final void setMaxDate(long j) {
            AppMethodBeat.m2504i(112882);
            this.jkB.setTimeInMillis(j);
            if (this.jkB.get(1) != this.zSY.get(1) || this.jkB.get(6) == this.zSY.get(6)) {
                this.zSY.setTimeInMillis(j);
                this.zSU.setMaxDate(j);
                if (this.zSZ.after(this.zSY)) {
                    this.zSZ.setTimeInMillis(this.zSY.getTimeInMillis());
                    dLt();
                }
                dLs();
                AppMethodBeat.m2505o(112882);
                return;
            }
            AppMethodBeat.m2505o(112882);
        }

        public final boolean isEnabled() {
            return this.zTa;
        }

        public final void setEnabled(boolean z) {
            AppMethodBeat.m2504i(112883);
            this.zSN.setEnabled(z);
            this.zSO.setEnabled(z);
            this.zSP.setEnabled(z);
            this.zSU.setEnabled(z);
            this.zTa = z;
            AppMethodBeat.m2505o(112883);
        }

        public final CalendarView getCalendarView() {
            return this.zSU;
        }

        public final boolean getCalendarViewShown() {
            AppMethodBeat.m2504i(112884);
            if (this.zSU.getVisibility() == 0) {
                AppMethodBeat.m2505o(112884);
                return true;
            }
            AppMethodBeat.m2505o(112884);
            return false;
        }

        public final void setCalendarViewShown(boolean z) {
            AppMethodBeat.m2504i(112885);
            this.zSU.setVisibility(z ? 0 : 8);
            AppMethodBeat.m2505o(112885);
        }

        public final boolean getSpinnersShown() {
            AppMethodBeat.m2504i(112886);
            boolean isShown = this.zSQ.isShown();
            AppMethodBeat.m2505o(112886);
            return isShown;
        }

        public final void setSpinnersShown(boolean z) {
            AppMethodBeat.m2504i(112887);
            this.zSQ.setVisibility(z ? 0 : 8);
            AppMethodBeat.m2505o(112887);
        }

        public final void onConfigurationChanged(Configuration configuration) {
            AppMethodBeat.m2504i(112888);
            mo28374f(configuration.locale);
            AppMethodBeat.m2505o(112888);
        }

        /* renamed from: d */
        public final Parcelable mo28348d(Parcelable parcelable) {
            AppMethodBeat.m2504i(112889);
            SavedState savedState = new SavedState(parcelable, getYear(), getMonth(), getDayOfMonth(), (byte) 0);
            AppMethodBeat.m2505o(112889);
            return savedState;
        }

        public final void onRestoreInstanceState(Parcelable parcelable) {
            AppMethodBeat.m2504i(112890);
            SavedState savedState = (SavedState) parcelable;
            mo28371aE(savedState.enV, savedState.enR, savedState.jHz);
            dLs();
            dLt();
            AppMethodBeat.m2505o(112890);
        }

        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.m2504i(112891);
            onPopulateAccessibilityEvent(accessibilityEvent);
            AppMethodBeat.m2505o(112891);
            return true;
        }

        public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.m2504i(112892);
            accessibilityEvent.getText().add(DateUtils.formatDateTime(this.mContext, this.zSZ.getTimeInMillis(), 20));
            AppMethodBeat.m2505o(112892);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: f */
        public final void mo28374f(Locale locale) {
            AppMethodBeat.m2504i(112893);
            super.mo28374f(locale);
            this.jkB = C16012c.m24324a(this.jkB, locale);
            this.zSX = C16012c.m24324a(this.zSX, locale);
            this.zSY = C16012c.m24324a(this.zSY, locale);
            this.zSZ = C16012c.m24324a(this.zSZ, locale);
            this.zSW = this.jkB.getActualMaximum(2) + 1;
            this.jkC = new DateFormatSymbols().getShortMonths();
            if (dLq()) {
                this.jkC = new String[this.zSW];
                for (int i = 0; i < this.zSW; i++) {
                    this.jkC[i] = String.format("%d", new Object[]{Integer.valueOf(i + 1)});
                }
            }
            AppMethodBeat.m2505o(112893);
        }

        private boolean dLq() {
            AppMethodBeat.m2504i(112894);
            boolean isDigit = Character.isDigit(this.jkC[0].charAt(0));
            AppMethodBeat.m2505o(112894);
            return isDigit;
        }

        /* renamed from: a */
        private static Calendar m24324a(Calendar calendar, Locale locale) {
            AppMethodBeat.m2504i(112895);
            Calendar instance;
            if (calendar == null) {
                instance = Calendar.getInstance(locale);
                AppMethodBeat.m2505o(112895);
                return instance;
            }
            long timeInMillis = calendar.getTimeInMillis();
            instance = Calendar.getInstance(locale);
            instance.setTimeInMillis(timeInMillis);
            AppMethodBeat.m2505o(112895);
            return instance;
        }

        private void dLr() {
            char[] cArr;
            AppMethodBeat.m2504i(112896);
            this.zSQ.removeAllViews();
            if (VERSION.SDK_INT < 17 || this.zSJ.getLayoutDirection() == 0) {
                cArr = new char[]{'y', 'M', 'd'};
            } else {
                cArr = android.text.format.DateFormat.getDateFormatOrder(this.zSJ.getContext());
            }
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                switch (cArr[i]) {
                    case 'M':
                        this.zSQ.addView(this.zSO);
                        C16012c.m24325a(this.zSO, length, i);
                        break;
                    case 'd':
                        this.zSQ.addView(this.zSN);
                        C16012c.m24325a(this.zSN, length, i);
                        break;
                    case 'y':
                        this.zSQ.addView(this.zSP);
                        C16012c.m24325a(this.zSP, length, i);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(Arrays.toString(cArr));
                        AppMethodBeat.m2505o(112896);
                        throw illegalArgumentException;
                }
            }
            AppMethodBeat.m2505o(112896);
        }

        /* renamed from: a */
        private boolean m24327a(String str, Calendar calendar) {
            AppMethodBeat.m2504i(112897);
            try {
                calendar.setTime(this.zSV.parse(str));
                AppMethodBeat.m2505o(112897);
                return true;
            } catch (ParseException e) {
                C5227ai.m7975w(YADatePicker.LOG_TAG, "Date: " + str + " not in format: MM/dd/yyyy", new Object[0]);
                AppMethodBeat.m2505o(112897);
                return false;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: aE */
        public final void mo28371aE(int i, int i2, int i3) {
            AppMethodBeat.m2504i(112898);
            this.zSZ.set(i, i2, i3);
            if (this.zSZ.before(this.zSX)) {
                this.zSZ.setTimeInMillis(this.zSX.getTimeInMillis());
                AppMethodBeat.m2505o(112898);
                return;
            }
            if (this.zSZ.after(this.zSY)) {
                this.zSZ.setTimeInMillis(this.zSY.getTimeInMillis());
            }
            AppMethodBeat.m2505o(112898);
        }

        /* Access modifiers changed, original: final */
        public final void dLs() {
            AppMethodBeat.m2504i(112899);
            if (this.zSZ.equals(this.zSX)) {
                this.zSN.setMinValue(this.zSZ.get(5));
                this.zSN.setMaxValue(this.zSZ.getActualMaximum(5));
                this.zSN.setWrapSelectorWheel(false);
                this.zSO.setDisplayedValues(null);
                this.zSO.setMinValue(this.zSZ.get(2));
                this.zSO.setMaxValue(this.zSZ.getActualMaximum(2));
                this.zSO.setWrapSelectorWheel(false);
            } else if (this.zSZ.equals(this.zSY)) {
                this.zSN.setMinValue(this.zSZ.getActualMinimum(5));
                this.zSN.setMaxValue(this.zSZ.get(5));
                this.zSN.setWrapSelectorWheel(false);
                this.zSO.setDisplayedValues(null);
                this.zSO.setMinValue(this.zSZ.getActualMinimum(2));
                this.zSO.setMaxValue(this.zSZ.get(2));
                this.zSO.setWrapSelectorWheel(false);
            } else {
                this.zSN.setMinValue(1);
                this.zSN.setMaxValue(this.zSZ.getActualMaximum(5));
                this.zSN.setWrapSelectorWheel(true);
                this.zSO.setDisplayedValues(null);
                this.zSO.setMinValue(0);
                this.zSO.setMaxValue(11);
                this.zSO.setWrapSelectorWheel(true);
            }
            this.zSO.setDisplayedValues((String[]) Arrays.copyOfRange(this.jkC, this.zSO.getMinValue(), this.zSO.getMaxValue() + 1));
            this.zSP.setMinValue(this.zSX.get(1));
            this.zSP.setMaxValue(this.zSY.get(1));
            this.zSP.setWrapSelectorWheel(false);
            this.zSP.setValue(this.zSZ.get(1));
            this.zSO.setValue(this.zSZ.get(2));
            this.zSN.setValue(this.zSZ.get(5));
            if (dLq()) {
                this.zSS.setRawInputType(2);
            }
            AppMethodBeat.m2505o(112899);
        }

        /* Access modifiers changed, original: final */
        public final void dLt() {
            AppMethodBeat.m2504i(112900);
            this.zSU.setDate(this.zSZ.getTimeInMillis(), false, false);
            AppMethodBeat.m2505o(112900);
        }

        /* renamed from: a */
        private static void m24325a(NumberPicker numberPicker, int i, int i2) {
            int i3;
            AppMethodBeat.m2504i(112901);
            if (i2 < i - 1) {
                i3 = 5;
            } else {
                i3 = 6;
            }
            EditText b = C24104e.m37071b(numberPicker);
            if (b != null) {
                b.setImeOptions(i3);
            }
            AppMethodBeat.m2505o(112901);
        }

        /* renamed from: a */
        static /* synthetic */ void m24326a(C16012c c16012c) {
            AppMethodBeat.m2504i(112903);
            InputMethodManager inputMethodManager = (InputMethodManager) c16012c.zSJ.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                if (inputMethodManager.isActive(c16012c.zST)) {
                    c16012c.zST.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(c16012c.zSJ.getWindowToken(), 0);
                    AppMethodBeat.m2505o(112903);
                    return;
                } else if (inputMethodManager.isActive(c16012c.zSS)) {
                    c16012c.zSS.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(c16012c.zSJ.getWindowToken(), 0);
                    AppMethodBeat.m2505o(112903);
                    return;
                } else if (inputMethodManager.isActive(c16012c.zSR)) {
                    c16012c.zSR.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(c16012c.zSJ.getWindowToken(), 0);
                }
            }
            AppMethodBeat.m2505o(112903);
        }

        /* renamed from: b */
        static /* synthetic */ void m24328b(C16012c c16012c) {
            AppMethodBeat.m2504i(112904);
            c16012c.zSJ.sendAccessibilityEvent(4);
            if (c16012c.zSL != null) {
                c16012c.getYear();
                c16012c.getMonth();
                c16012c.getDayOfMonth();
            }
            AppMethodBeat.m2505o(112904);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.YADatePicker$SavedState */
    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C240991();
        private final int enR;
        private final int enV;
        private final int jHz;

        /* renamed from: com.tencent.mm.ui.widget.picker.YADatePicker$SavedState$1 */
        static class C240991 implements Creator<SavedState> {
            C240991() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(112905);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.m2505o(112905);
                return savedState;
            }
        }

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int i, int i2, int i3, byte b) {
            this(parcelable, i, i2, i3);
        }

        static {
            AppMethodBeat.m2504i(112908);
            AppMethodBeat.m2505o(112908);
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.enV = i;
            this.enR = i2;
            this.jHz = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.m2504i(112906);
            this.enV = parcel.readInt();
            this.enR = parcel.readInt();
            this.jHz = parcel.readInt();
            AppMethodBeat.m2505o(112906);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(112907);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.enV);
            parcel.writeInt(this.enR);
            parcel.writeInt(this.jHz);
            AppMethodBeat.m2505o(112907);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.YADatePicker$a */
    static abstract class C30807a implements C16010b {
        protected Context mContext;
        protected YADatePicker zSJ;
        protected Locale zSK;
        protected C44398d zSL;
        protected C40904e zSM;

        protected C30807a(YADatePicker yADatePicker, Context context) {
            this.zSJ = yADatePicker;
            this.mContext = context;
            mo28374f(Locale.getDefault());
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: f */
        public void mo28374f(Locale locale) {
            if (!locale.equals(this.zSK)) {
                this.zSK = locale;
            }
        }

        public void setValidationCallback(C40904e c40904e) {
            this.zSM = c40904e;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.YADatePicker$e */
    public interface C40904e {
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.YADatePicker$d */
    public interface C44398d {
    }

    static {
        AppMethodBeat.m2504i(112935);
        AppMethodBeat.m2505o(112935);
    }

    public YADatePicker(Context context) {
        this(context, null);
    }

    public YADatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5473o);
    }

    public YADatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112909);
        this.zSI = new C16012c(this, context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C41921a.DatePicker, i, 0);
        int i2 = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        if (i2 != 0) {
            setFirstDayOfWeek(i2);
        }
        AppMethodBeat.m2505o(112909);
    }

    @Keep
    public C16010b getUIDelegate() {
        return this.zSI;
    }

    /* renamed from: a */
    public void mo28325a(int i, int i2, int i3, C44398d c44398d) {
        AppMethodBeat.m2504i(112910);
        this.zSI.mo28347a(i, i2, i3, c44398d);
        AppMethodBeat.m2505o(112910);
    }

    public int getYear() {
        AppMethodBeat.m2504i(112911);
        int year = this.zSI.getYear();
        AppMethodBeat.m2505o(112911);
        return year;
    }

    public int getMonth() {
        AppMethodBeat.m2504i(112912);
        int month = this.zSI.getMonth();
        AppMethodBeat.m2505o(112912);
        return month;
    }

    public int getDayOfMonth() {
        AppMethodBeat.m2504i(112913);
        int dayOfMonth = this.zSI.getDayOfMonth();
        AppMethodBeat.m2505o(112913);
        return dayOfMonth;
    }

    public long getMinDate() {
        AppMethodBeat.m2504i(112914);
        long timeInMillis = this.zSI.dLo().getTimeInMillis();
        AppMethodBeat.m2505o(112914);
        return timeInMillis;
    }

    public void setMinDate(long j) {
        AppMethodBeat.m2504i(112915);
        this.zSI.setMinDate(j);
        AppMethodBeat.m2505o(112915);
    }

    public long getMaxDate() {
        AppMethodBeat.m2504i(112916);
        long timeInMillis = this.zSI.dLp().getTimeInMillis();
        AppMethodBeat.m2505o(112916);
        return timeInMillis;
    }

    public void setMaxDate(long j) {
        AppMethodBeat.m2504i(112917);
        this.zSI.setMaxDate(j);
        AppMethodBeat.m2505o(112917);
    }

    public void setValidationCallback(C40904e c40904e) {
        AppMethodBeat.m2504i(112918);
        this.zSI.setValidationCallback(c40904e);
        AppMethodBeat.m2505o(112918);
    }

    public boolean isEnabled() {
        AppMethodBeat.m2504i(112919);
        boolean isEnabled = this.zSI.isEnabled();
        AppMethodBeat.m2505o(112919);
        return isEnabled;
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.m2504i(112920);
        if (this.zSI.isEnabled() == z) {
            AppMethodBeat.m2505o(112920);
            return;
        }
        super.setEnabled(z);
        this.zSI.setEnabled(z);
        AppMethodBeat.m2505o(112920);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.m2504i(112921);
        boolean dispatchPopulateAccessibilityEvent = this.zSI.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        AppMethodBeat.m2505o(112921);
        return dispatchPopulateAccessibilityEvent;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.m2504i(112922);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.zSI.onPopulateAccessibilityEvent(accessibilityEvent);
        AppMethodBeat.m2505o(112922);
    }

    public CharSequence getAccessibilityClassName() {
        AppMethodBeat.m2504i(112923);
        String name = YADatePicker.class.getName();
        AppMethodBeat.m2505o(112923);
        return name;
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(112924);
        super.onConfigurationChanged(configuration);
        this.zSI.onConfigurationChanged(configuration);
        AppMethodBeat.m2505o(112924);
    }

    public int getFirstDayOfWeek() {
        AppMethodBeat.m2504i(112925);
        int firstDayOfWeek = this.zSI.getFirstDayOfWeek();
        AppMethodBeat.m2505o(112925);
        return firstDayOfWeek;
    }

    public void setFirstDayOfWeek(int i) {
        AppMethodBeat.m2504i(112926);
        if (i <= 0 || i > 7) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
            AppMethodBeat.m2505o(112926);
            throw illegalArgumentException;
        }
        this.zSI.setFirstDayOfWeek(i);
        AppMethodBeat.m2505o(112926);
    }

    public boolean getCalendarViewShown() {
        AppMethodBeat.m2504i(112927);
        boolean calendarViewShown = this.zSI.getCalendarViewShown();
        AppMethodBeat.m2505o(112927);
        return calendarViewShown;
    }

    public void setCalendarViewShown(boolean z) {
        AppMethodBeat.m2504i(112928);
        this.zSI.setCalendarViewShown(z);
        AppMethodBeat.m2505o(112928);
    }

    public CalendarView getCalendarView() {
        AppMethodBeat.m2504i(112929);
        CalendarView calendarView = this.zSI.getCalendarView();
        AppMethodBeat.m2505o(112929);
        return calendarView;
    }

    public boolean getSpinnersShown() {
        AppMethodBeat.m2504i(112930);
        boolean spinnersShown = this.zSI.getSpinnersShown();
        AppMethodBeat.m2505o(112930);
        return spinnersShown;
    }

    public void setSpinnersShown(boolean z) {
        AppMethodBeat.m2504i(112931);
        this.zSI.setSpinnersShown(z);
        AppMethodBeat.m2505o(112931);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        AppMethodBeat.m2504i(112932);
        dispatchThawSelfOnly(sparseArray);
        AppMethodBeat.m2505o(112932);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        AppMethodBeat.m2504i(112933);
        Parcelable d = this.zSI.mo28348d(super.onSaveInstanceState());
        AppMethodBeat.m2505o(112933);
        return d;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.m2504i(112934);
        BaseSavedState baseSavedState = (BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.zSI.onRestoreInstanceState(baseSavedState);
        AppMethodBeat.m2505o(112934);
    }
}
