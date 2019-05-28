package com.tencent.mm.ui.widget.picker;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.ai;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class YADatePicker extends FrameLayout {
    private static final String LOG_TAG = YADatePicker.class.getSimpleName();
    public final b zSI;

    public interface b {
        void a(int i, int i2, int i3, d dVar);

        Parcelable d(Parcelable parcelable);

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

        void setValidationCallback(e eVar);
    }

    public static class c extends a {
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

        public final /* bridge */ /* synthetic */ void setValidationCallback(e eVar) {
            AppMethodBeat.i(112902);
            super.setValidationCallback(eVar);
            AppMethodBeat.o(112902);
        }

        c(YADatePicker yADatePicker, Context context, AttributeSet attributeSet, int i) {
            super(yADatePicker, context);
            AppMethodBeat.i(112872);
            this.zSJ = yADatePicker;
            this.mContext = context;
            f(Locale.getDefault());
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.cg.a.a.DatePicker, i, 0);
            boolean z = obtainStyledAttributes.getBoolean(3, true);
            boolean z2 = obtainStyledAttributes.getBoolean(4, true);
            int i2 = obtainStyledAttributes.getInt(13, 1900);
            int i3 = obtainStyledAttributes.getInt(14, 2100);
            String string = obtainStyledAttributes.getString(1);
            String string2 = obtainStyledAttributes.getString(2);
            int resourceId = obtainStyledAttributes.getResourceId(6, R.layout.rr);
            obtainStyledAttributes.recycle();
            ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(resourceId, this.zSJ, true);
            AnonymousClass1 anonymousClass1 = new OnValueChangeListener() {
                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    AppMethodBeat.i(112870);
                    c.a(c.this);
                    c.this.jkB.setTimeInMillis(c.this.zSZ.getTimeInMillis());
                    if (numberPicker == c.this.zSN) {
                        int actualMaximum = c.this.jkB.getActualMaximum(5);
                        if (i == actualMaximum && i2 == 1) {
                            c.this.jkB.add(5, 1);
                        } else if (i == 1 && i2 == actualMaximum) {
                            c.this.jkB.add(5, -1);
                        } else {
                            c.this.jkB.add(5, i2 - i);
                        }
                    } else if (numberPicker == c.this.zSO) {
                        if (i == 11 && i2 == 0) {
                            c.this.jkB.add(2, 1);
                        } else if (i == 0 && i2 == 11) {
                            c.this.jkB.add(2, -1);
                        } else {
                            c.this.jkB.add(2, i2 - i);
                        }
                    } else if (numberPicker == c.this.zSP) {
                        c.this.jkB.set(1, i2);
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                        AppMethodBeat.o(112870);
                        throw illegalArgumentException;
                    }
                    c.this.aE(c.this.jkB.get(1), c.this.jkB.get(2), c.this.jkB.get(5));
                    c.this.dLs();
                    c.this.dLt();
                    c.b(c.this);
                    AppMethodBeat.o(112870);
                }
            };
            this.zSQ = (LinearLayout) this.zSJ.findViewById(R.id.b7j);
            this.zSU = (CalendarView) this.zSJ.findViewById(R.id.b7n);
            this.zSU.setOnDateChangeListener(new OnDateChangeListener() {
                public final void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
                    AppMethodBeat.i(112871);
                    c.this.aE(i, i2, i3);
                    c.this.dLs();
                    c.b(c.this);
                    AppMethodBeat.o(112871);
                }
            });
            this.zSN = (NumberPicker) this.zSJ.findViewById(R.id.b7l);
            this.zSN.setFormatter(new g());
            this.zSN.setOnLongPressUpdateInterval(100);
            this.zSN.setOnValueChangedListener(anonymousClass1);
            this.zSR = e.b(this.zSN);
            this.zSO = (NumberPicker) this.zSJ.findViewById(R.id.b7k);
            this.zSO.setMinValue(0);
            this.zSO.setMaxValue(this.zSW - 1);
            this.zSO.setDisplayedValues(this.jkC);
            this.zSO.setOnLongPressUpdateInterval(200);
            this.zSO.setOnValueChangedListener(anonymousClass1);
            this.zSS = e.b(this.zSO);
            this.zSP = (NumberPicker) this.zSJ.findViewById(R.id.b7m);
            this.zSP.setOnLongPressUpdateInterval(100);
            this.zSP.setOnValueChangedListener(anonymousClass1);
            this.zST = e.b(this.zSP);
            if (z || z2) {
                setSpinnersShown(z);
                setCalendarViewShown(z2);
            } else {
                setSpinnersShown(true);
            }
            this.jkB.clear();
            if (TextUtils.isEmpty(string) || !a(string, this.jkB)) {
                this.jkB.set(i2, 0, 1);
            }
            setMinDate(this.jkB.getTimeInMillis());
            this.jkB.clear();
            if (TextUtils.isEmpty(string2) || !a(string2, this.jkB)) {
                this.jkB.set(i3, 11, 31);
            }
            setMaxDate(this.jkB.getTimeInMillis());
            this.zSZ.setTimeInMillis(System.currentTimeMillis());
            a(this.zSZ.get(1), this.zSZ.get(2), this.zSZ.get(5), null);
            dLr();
            if (this.zSJ.getImportantForAccessibility() == 0) {
                this.zSJ.setImportantForAccessibility(1);
            }
            AppMethodBeat.o(112872);
        }

        public final void a(int i, int i2, int i3, d dVar) {
            AppMethodBeat.i(112873);
            aE(i, i2, i3);
            dLs();
            dLt();
            this.zSL = dVar;
            AppMethodBeat.o(112873);
        }

        public final int getYear() {
            AppMethodBeat.i(112874);
            int i = this.zSZ.get(1);
            AppMethodBeat.o(112874);
            return i;
        }

        public final int getMonth() {
            AppMethodBeat.i(112875);
            int i = this.zSZ.get(2);
            AppMethodBeat.o(112875);
            return i;
        }

        public final int getDayOfMonth() {
            AppMethodBeat.i(112876);
            int i = this.zSZ.get(5);
            AppMethodBeat.o(112876);
            return i;
        }

        public final int getFirstDayOfWeek() {
            AppMethodBeat.i(112877);
            int firstDayOfWeek = this.zSU.getFirstDayOfWeek();
            AppMethodBeat.o(112877);
            return firstDayOfWeek;
        }

        public final void setFirstDayOfWeek(int i) {
            AppMethodBeat.i(112878);
            this.zSU.setFirstDayOfWeek(i);
            AppMethodBeat.o(112878);
        }

        public final Calendar dLo() {
            AppMethodBeat.i(112879);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.zSU.getMinDate());
            AppMethodBeat.o(112879);
            return instance;
        }

        public final void setMinDate(long j) {
            AppMethodBeat.i(112880);
            this.jkB.setTimeInMillis(j);
            if (this.jkB.get(1) != this.zSX.get(1) || this.jkB.get(6) == this.zSX.get(6)) {
                this.zSX.setTimeInMillis(j);
                this.zSU.setMinDate(j);
                if (this.zSZ.before(this.zSX)) {
                    this.zSZ.setTimeInMillis(this.zSX.getTimeInMillis());
                    dLt();
                }
                dLs();
                AppMethodBeat.o(112880);
                return;
            }
            AppMethodBeat.o(112880);
        }

        public final Calendar dLp() {
            AppMethodBeat.i(112881);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.zSU.getMaxDate());
            AppMethodBeat.o(112881);
            return instance;
        }

        public final void setMaxDate(long j) {
            AppMethodBeat.i(112882);
            this.jkB.setTimeInMillis(j);
            if (this.jkB.get(1) != this.zSY.get(1) || this.jkB.get(6) == this.zSY.get(6)) {
                this.zSY.setTimeInMillis(j);
                this.zSU.setMaxDate(j);
                if (this.zSZ.after(this.zSY)) {
                    this.zSZ.setTimeInMillis(this.zSY.getTimeInMillis());
                    dLt();
                }
                dLs();
                AppMethodBeat.o(112882);
                return;
            }
            AppMethodBeat.o(112882);
        }

        public final boolean isEnabled() {
            return this.zTa;
        }

        public final void setEnabled(boolean z) {
            AppMethodBeat.i(112883);
            this.zSN.setEnabled(z);
            this.zSO.setEnabled(z);
            this.zSP.setEnabled(z);
            this.zSU.setEnabled(z);
            this.zTa = z;
            AppMethodBeat.o(112883);
        }

        public final CalendarView getCalendarView() {
            return this.zSU;
        }

        public final boolean getCalendarViewShown() {
            AppMethodBeat.i(112884);
            if (this.zSU.getVisibility() == 0) {
                AppMethodBeat.o(112884);
                return true;
            }
            AppMethodBeat.o(112884);
            return false;
        }

        public final void setCalendarViewShown(boolean z) {
            AppMethodBeat.i(112885);
            this.zSU.setVisibility(z ? 0 : 8);
            AppMethodBeat.o(112885);
        }

        public final boolean getSpinnersShown() {
            AppMethodBeat.i(112886);
            boolean isShown = this.zSQ.isShown();
            AppMethodBeat.o(112886);
            return isShown;
        }

        public final void setSpinnersShown(boolean z) {
            AppMethodBeat.i(112887);
            this.zSQ.setVisibility(z ? 0 : 8);
            AppMethodBeat.o(112887);
        }

        public final void onConfigurationChanged(Configuration configuration) {
            AppMethodBeat.i(112888);
            f(configuration.locale);
            AppMethodBeat.o(112888);
        }

        public final Parcelable d(Parcelable parcelable) {
            AppMethodBeat.i(112889);
            SavedState savedState = new SavedState(parcelable, getYear(), getMonth(), getDayOfMonth(), (byte) 0);
            AppMethodBeat.o(112889);
            return savedState;
        }

        public final void onRestoreInstanceState(Parcelable parcelable) {
            AppMethodBeat.i(112890);
            SavedState savedState = (SavedState) parcelable;
            aE(savedState.enV, savedState.enR, savedState.jHz);
            dLs();
            dLt();
            AppMethodBeat.o(112890);
        }

        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.i(112891);
            onPopulateAccessibilityEvent(accessibilityEvent);
            AppMethodBeat.o(112891);
            return true;
        }

        public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            AppMethodBeat.i(112892);
            accessibilityEvent.getText().add(DateUtils.formatDateTime(this.mContext, this.zSZ.getTimeInMillis(), 20));
            AppMethodBeat.o(112892);
        }

        /* Access modifiers changed, original: protected|final */
        public final void f(Locale locale) {
            AppMethodBeat.i(112893);
            super.f(locale);
            this.jkB = a(this.jkB, locale);
            this.zSX = a(this.zSX, locale);
            this.zSY = a(this.zSY, locale);
            this.zSZ = a(this.zSZ, locale);
            this.zSW = this.jkB.getActualMaximum(2) + 1;
            this.jkC = new DateFormatSymbols().getShortMonths();
            if (dLq()) {
                this.jkC = new String[this.zSW];
                for (int i = 0; i < this.zSW; i++) {
                    this.jkC[i] = String.format("%d", new Object[]{Integer.valueOf(i + 1)});
                }
            }
            AppMethodBeat.o(112893);
        }

        private boolean dLq() {
            AppMethodBeat.i(112894);
            boolean isDigit = Character.isDigit(this.jkC[0].charAt(0));
            AppMethodBeat.o(112894);
            return isDigit;
        }

        private static Calendar a(Calendar calendar, Locale locale) {
            AppMethodBeat.i(112895);
            Calendar instance;
            if (calendar == null) {
                instance = Calendar.getInstance(locale);
                AppMethodBeat.o(112895);
                return instance;
            }
            long timeInMillis = calendar.getTimeInMillis();
            instance = Calendar.getInstance(locale);
            instance.setTimeInMillis(timeInMillis);
            AppMethodBeat.o(112895);
            return instance;
        }

        private void dLr() {
            char[] cArr;
            AppMethodBeat.i(112896);
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
                        a(this.zSO, length, i);
                        break;
                    case 'd':
                        this.zSQ.addView(this.zSN);
                        a(this.zSN, length, i);
                        break;
                    case 'y':
                        this.zSQ.addView(this.zSP);
                        a(this.zSP, length, i);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(Arrays.toString(cArr));
                        AppMethodBeat.o(112896);
                        throw illegalArgumentException;
                }
            }
            AppMethodBeat.o(112896);
        }

        private boolean a(String str, Calendar calendar) {
            AppMethodBeat.i(112897);
            try {
                calendar.setTime(this.zSV.parse(str));
                AppMethodBeat.o(112897);
                return true;
            } catch (ParseException e) {
                ai.w(YADatePicker.LOG_TAG, "Date: " + str + " not in format: MM/dd/yyyy", new Object[0]);
                AppMethodBeat.o(112897);
                return false;
            }
        }

        /* Access modifiers changed, original: final */
        public final void aE(int i, int i2, int i3) {
            AppMethodBeat.i(112898);
            this.zSZ.set(i, i2, i3);
            if (this.zSZ.before(this.zSX)) {
                this.zSZ.setTimeInMillis(this.zSX.getTimeInMillis());
                AppMethodBeat.o(112898);
                return;
            }
            if (this.zSZ.after(this.zSY)) {
                this.zSZ.setTimeInMillis(this.zSY.getTimeInMillis());
            }
            AppMethodBeat.o(112898);
        }

        /* Access modifiers changed, original: final */
        public final void dLs() {
            AppMethodBeat.i(112899);
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
            AppMethodBeat.o(112899);
        }

        /* Access modifiers changed, original: final */
        public final void dLt() {
            AppMethodBeat.i(112900);
            this.zSU.setDate(this.zSZ.getTimeInMillis(), false, false);
            AppMethodBeat.o(112900);
        }

        private static void a(NumberPicker numberPicker, int i, int i2) {
            int i3;
            AppMethodBeat.i(112901);
            if (i2 < i - 1) {
                i3 = 5;
            } else {
                i3 = 6;
            }
            EditText b = e.b(numberPicker);
            if (b != null) {
                b.setImeOptions(i3);
            }
            AppMethodBeat.o(112901);
        }

        static /* synthetic */ void a(c cVar) {
            AppMethodBeat.i(112903);
            InputMethodManager inputMethodManager = (InputMethodManager) cVar.zSJ.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                if (inputMethodManager.isActive(cVar.zST)) {
                    cVar.zST.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(cVar.zSJ.getWindowToken(), 0);
                    AppMethodBeat.o(112903);
                    return;
                } else if (inputMethodManager.isActive(cVar.zSS)) {
                    cVar.zSS.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(cVar.zSJ.getWindowToken(), 0);
                    AppMethodBeat.o(112903);
                    return;
                } else if (inputMethodManager.isActive(cVar.zSR)) {
                    cVar.zSR.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(cVar.zSJ.getWindowToken(), 0);
                }
            }
            AppMethodBeat.o(112903);
        }

        static /* synthetic */ void b(c cVar) {
            AppMethodBeat.i(112904);
            cVar.zSJ.sendAccessibilityEvent(4);
            if (cVar.zSL != null) {
                cVar.getYear();
                cVar.getMonth();
                cVar.getDayOfMonth();
            }
            AppMethodBeat.o(112904);
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(112905);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.o(112905);
                return savedState;
            }
        };
        private final int enR;
        private final int enV;
        private final int jHz;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int i, int i2, int i3, byte b) {
            this(parcelable, i, i2, i3);
        }

        static {
            AppMethodBeat.i(112908);
            AppMethodBeat.o(112908);
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.enV = i;
            this.enR = i2;
            this.jHz = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(112906);
            this.enV = parcel.readInt();
            this.enR = parcel.readInt();
            this.jHz = parcel.readInt();
            AppMethodBeat.o(112906);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(112907);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.enV);
            parcel.writeInt(this.enR);
            parcel.writeInt(this.jHz);
            AppMethodBeat.o(112907);
        }
    }

    static abstract class a implements b {
        protected Context mContext;
        protected YADatePicker zSJ;
        protected Locale zSK;
        protected d zSL;
        protected e zSM;

        protected a(YADatePicker yADatePicker, Context context) {
            this.zSJ = yADatePicker;
            this.mContext = context;
            f(Locale.getDefault());
        }

        /* Access modifiers changed, original: protected */
        public void f(Locale locale) {
            if (!locale.equals(this.zSK)) {
                this.zSK = locale;
            }
        }

        public void setValidationCallback(e eVar) {
            this.zSM = eVar;
        }
    }

    public interface e {
    }

    public interface d {
    }

    static {
        AppMethodBeat.i(112935);
        AppMethodBeat.o(112935);
    }

    public YADatePicker(Context context) {
        this(context, null);
    }

    public YADatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.o);
    }

    public YADatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112909);
        this.zSI = new c(this, context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.cg.a.a.DatePicker, i, 0);
        int i2 = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        if (i2 != 0) {
            setFirstDayOfWeek(i2);
        }
        AppMethodBeat.o(112909);
    }

    @Keep
    public b getUIDelegate() {
        return this.zSI;
    }

    public void a(int i, int i2, int i3, d dVar) {
        AppMethodBeat.i(112910);
        this.zSI.a(i, i2, i3, dVar);
        AppMethodBeat.o(112910);
    }

    public int getYear() {
        AppMethodBeat.i(112911);
        int year = this.zSI.getYear();
        AppMethodBeat.o(112911);
        return year;
    }

    public int getMonth() {
        AppMethodBeat.i(112912);
        int month = this.zSI.getMonth();
        AppMethodBeat.o(112912);
        return month;
    }

    public int getDayOfMonth() {
        AppMethodBeat.i(112913);
        int dayOfMonth = this.zSI.getDayOfMonth();
        AppMethodBeat.o(112913);
        return dayOfMonth;
    }

    public long getMinDate() {
        AppMethodBeat.i(112914);
        long timeInMillis = this.zSI.dLo().getTimeInMillis();
        AppMethodBeat.o(112914);
        return timeInMillis;
    }

    public void setMinDate(long j) {
        AppMethodBeat.i(112915);
        this.zSI.setMinDate(j);
        AppMethodBeat.o(112915);
    }

    public long getMaxDate() {
        AppMethodBeat.i(112916);
        long timeInMillis = this.zSI.dLp().getTimeInMillis();
        AppMethodBeat.o(112916);
        return timeInMillis;
    }

    public void setMaxDate(long j) {
        AppMethodBeat.i(112917);
        this.zSI.setMaxDate(j);
        AppMethodBeat.o(112917);
    }

    public void setValidationCallback(e eVar) {
        AppMethodBeat.i(112918);
        this.zSI.setValidationCallback(eVar);
        AppMethodBeat.o(112918);
    }

    public boolean isEnabled() {
        AppMethodBeat.i(112919);
        boolean isEnabled = this.zSI.isEnabled();
        AppMethodBeat.o(112919);
        return isEnabled;
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(112920);
        if (this.zSI.isEnabled() == z) {
            AppMethodBeat.o(112920);
            return;
        }
        super.setEnabled(z);
        this.zSI.setEnabled(z);
        AppMethodBeat.o(112920);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(112921);
        boolean dispatchPopulateAccessibilityEvent = this.zSI.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        AppMethodBeat.o(112921);
        return dispatchPopulateAccessibilityEvent;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(112922);
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.zSI.onPopulateAccessibilityEvent(accessibilityEvent);
        AppMethodBeat.o(112922);
    }

    public CharSequence getAccessibilityClassName() {
        AppMethodBeat.i(112923);
        String name = YADatePicker.class.getName();
        AppMethodBeat.o(112923);
        return name;
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(112924);
        super.onConfigurationChanged(configuration);
        this.zSI.onConfigurationChanged(configuration);
        AppMethodBeat.o(112924);
    }

    public int getFirstDayOfWeek() {
        AppMethodBeat.i(112925);
        int firstDayOfWeek = this.zSI.getFirstDayOfWeek();
        AppMethodBeat.o(112925);
        return firstDayOfWeek;
    }

    public void setFirstDayOfWeek(int i) {
        AppMethodBeat.i(112926);
        if (i <= 0 || i > 7) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
            AppMethodBeat.o(112926);
            throw illegalArgumentException;
        }
        this.zSI.setFirstDayOfWeek(i);
        AppMethodBeat.o(112926);
    }

    public boolean getCalendarViewShown() {
        AppMethodBeat.i(112927);
        boolean calendarViewShown = this.zSI.getCalendarViewShown();
        AppMethodBeat.o(112927);
        return calendarViewShown;
    }

    public void setCalendarViewShown(boolean z) {
        AppMethodBeat.i(112928);
        this.zSI.setCalendarViewShown(z);
        AppMethodBeat.o(112928);
    }

    public CalendarView getCalendarView() {
        AppMethodBeat.i(112929);
        CalendarView calendarView = this.zSI.getCalendarView();
        AppMethodBeat.o(112929);
        return calendarView;
    }

    public boolean getSpinnersShown() {
        AppMethodBeat.i(112930);
        boolean spinnersShown = this.zSI.getSpinnersShown();
        AppMethodBeat.o(112930);
        return spinnersShown;
    }

    public void setSpinnersShown(boolean z) {
        AppMethodBeat.i(112931);
        this.zSI.setSpinnersShown(z);
        AppMethodBeat.o(112931);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        AppMethodBeat.i(112932);
        dispatchThawSelfOnly(sparseArray);
        AppMethodBeat.o(112932);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(112933);
        Parcelable d = this.zSI.d(super.onSaveInstanceState());
        AppMethodBeat.o(112933);
        return d;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(112934);
        BaseSavedState baseSavedState = (BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.zSI.onRestoreInstanceState(baseSavedState);
        AppMethodBeat.o(112934);
    }
}
