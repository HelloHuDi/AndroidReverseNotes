package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.ui.base.preference.Preference */
public class Preference implements Comparable<Preference> {
    /* renamed from: IT */
    private CharSequence f4430IT;
    /* renamed from: MT */
    private int[] f4431MT;
    /* renamed from: OH */
    private boolean f4432OH;
    /* renamed from: ZV */
    protected int f4433ZV;
    private int btQ;
    public int ksd;
    public final Context mContext;
    private Object mDefaultValue;
    private Bundle mExtras;
    public String mKey;
    private CharSequence ppl;
    private ImageView qZa;
    /* renamed from: rP */
    protected Drawable f4434rP;
    private C23632a yCW;
    public C23633b yCX;
    public C23634c yCY;
    private int yCZ;
    private int yDa;
    int yDb;
    private String yDc;
    boolean yDd;
    private boolean yDe;
    public boolean yDf;
    String yDg;
    private boolean yDh;
    private int yDi;
    private boolean yDj;
    private int yDk;
    public int yDl;
    private boolean yDm;
    private List<Preference> yDn;

    /* renamed from: com.tencent.mm.ui.base.preference.Preference$a */
    public interface C23632a {
        /* renamed from: a */
        boolean mo39405a(Preference preference, Object obj);
    }

    /* renamed from: com.tencent.mm.ui.base.preference.Preference$b */
    public interface C23633b {
        boolean car();
    }

    /* renamed from: com.tencent.mm.ui.base.preference.Preference$c */
    public interface C23634c {
        boolean cbK();
    }

    /* renamed from: com.tencent.mm.ui.base.preference.Preference$BaseSavedState */
    public static class BaseSavedState extends AbsSavedState {
        public static final Creator<BaseSavedState> CREATOR = new C236351();

        /* renamed from: com.tencent.mm.ui.base.preference.Preference$BaseSavedState$1 */
        static class C236351 implements Creator<BaseSavedState> {
            C236351() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new BaseSavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(107253);
                BaseSavedState baseSavedState = new BaseSavedState(parcel);
                AppMethodBeat.m2505o(107253);
                return baseSavedState;
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.m2504i(107254);
            AppMethodBeat.m2505o(107254);
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.m2504i(107277);
        Preference preference = (Preference) obj;
        int i;
        if (this.btQ != BaseClientBuilder.API_PRIORITY_OTHER || (this.btQ == BaseClientBuilder.API_PRIORITY_OTHER && preference.btQ != BaseClientBuilder.API_PRIORITY_OTHER)) {
            i = this.btQ - preference.btQ;
            AppMethodBeat.m2505o(107277);
            return i;
        } else if (this.f4430IT == null) {
            AppMethodBeat.m2505o(107277);
            return 1;
        } else if (preference.f4430IT == null) {
            AppMethodBeat.m2505o(107277);
            return -1;
        } else {
            CharSequence charSequence = this.f4430IT;
            CharSequence charSequence2 = preference.f4430IT;
            int length = charSequence.length();
            int length2 = charSequence2.length();
            i = length < length2 ? length : length2;
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 1;
                int i5 = i2 + 1;
                i2 = Character.toLowerCase(charSequence.charAt(i3)) - Character.toLowerCase(charSequence2.charAt(i2));
                if (i2 != 0) {
                    AppMethodBeat.m2505o(107277);
                    return i2;
                }
                i2 = i5;
                i3 = i4;
            }
            i = length - length2;
            AppMethodBeat.m2505o(107277);
            return i;
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        AppMethodBeat.m2504i(107255);
        this.f4431MT = new int[]{C25738R.attr.f5533bl, C25738R.attr.f5532bi};
        this.btQ = BaseClientBuilder.API_PRIORITY_OTHER;
        this.yDb = 0;
        this.f4432OH = true;
        this.yDd = true;
        this.yDf = true;
        this.yDh = true;
        this.ksd = -1;
        this.qZa = null;
        this.yDi = 0;
        this.yDj = true;
        this.yDk = 2130970127;
        this.yDm = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.Preference, i, 0);
        for (int indexCount = obtainStyledAttributes.getIndexCount(); indexCount >= 0; indexCount--) {
            int index = obtainStyledAttributes.getIndex(indexCount);
            if (index == 5) {
                this.f4433ZV = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == 6) {
                this.yDb = obtainStyledAttributes.getColor(index, 0);
            } else if (index == 7) {
                this.mKey = obtainStyledAttributes.getString(index);
            } else if (index == 4) {
                this.yCZ = obtainStyledAttributes.getResourceId(index, 0);
                this.f4430IT = obtainStyledAttributes.getString(index);
                if (this.yCZ != 0) {
                    this.f4430IT = context.getString(this.yCZ);
                }
            } else if (index == 3) {
                this.ppl = obtainStyledAttributes.getString(index);
                this.yDa = obtainStyledAttributes.getResourceId(index, 0);
                if (this.yDa != 0) {
                    this.ppl = context.getString(this.yDa);
                }
            } else if (index == 8) {
                this.btQ = obtainStyledAttributes.getInt(index, this.btQ);
            } else if (index == 1) {
                this.yDc = obtainStyledAttributes.getString(index);
            } else if (index == 14) {
                this.yDk = obtainStyledAttributes.getResourceId(index, this.yDk);
            } else if (index == 9) {
                this.yDl = obtainStyledAttributes.getResourceId(index, this.yDl);
            } else if (index == 0) {
                this.f4432OH = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 10) {
                this.yDd = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 2) {
                this.yDf = obtainStyledAttributes.getBoolean(index, this.yDf);
            } else if (index == 11) {
                this.yDg = obtainStyledAttributes.getString(index);
            } else if (index == 12) {
                this.mDefaultValue = null;
            } else if (index == 13) {
                this.yDj = obtainStyledAttributes.getBoolean(index, this.yDj);
            }
        }
        obtainStyledAttributes.recycle();
        if (!getClass().getName().startsWith("android.preference")) {
            this.yDm = true;
        }
        AppMethodBeat.m2505o(107255);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842894);
    }

    public Preference(Context context) {
        this(context, null);
    }

    public final Bundle getExtras() {
        AppMethodBeat.m2504i(107256);
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        Bundle bundle = this.mExtras;
        AppMethodBeat.m2505o(107256);
        return bundle;
    }

    public final void setLayoutResource(int i) {
        if (i != this.yDk) {
            this.yDm = true;
        }
        this.yDk = i;
    }

    public int getLayoutResource() {
        return this.yDk;
    }

    public final void setWidgetLayoutResource(int i) {
        if (i != this.yDl) {
            this.yDm = true;
        }
        this.yDl = i;
    }

    public View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107257);
        if (view == null) {
            view = onCreateView(viewGroup);
        }
        onBindView(view);
        AppMethodBeat.m2505o(107257);
        return view;
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107258);
        LayoutInflater hu = C5616v.m8409hu(this.mContext);
        View inflate = hu.inflate(this.yDk, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (this.yDl != 0) {
                hu.inflate(this.yDl, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(107258);
        return inflate;
    }

    /* Access modifiers changed, original: protected */
    public void onBindView(View view) {
        int i = 0;
        AppMethodBeat.m2504i(107259);
        View findViewById = view.findViewById(2131821019);
        if (findViewById != null) {
            findViewById.setMinimumHeight((int) (((float) this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9956lc)) * C1338a.m2863fZ(this.mContext)));
            C4990ab.m7411d("dancy test", "resource:%s, height:%s, scale:%s", this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9956lc)), Float.valueOf(C1338a.m2863fZ(this.mContext)));
        }
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            CharSequence title = getTitle();
            if (title == null || !(title instanceof Spannable)) {
                textView.setMovementMethod(null);
            } else if (textView.isClickable()) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            textView.setText(title);
        }
        textView = (TextView) view.findViewById(16908304);
        if (textView != null) {
            if (!TextUtils.isEmpty(getSummary())) {
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setText(getSummary());
                if (this.ksd != -1) {
                    textView.setTextColor(this.ksd);
                }
            } else if (textView.getVisibility() != 8) {
                textView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) view.findViewById(16908294);
        if (imageView != null) {
            if (!(this.f4433ZV == 0 && this.f4434rP == null)) {
                if (this.f4434rP == null) {
                    this.f4434rP = this.mContext.getResources().getDrawable(this.f4433ZV);
                }
                if (this.f4434rP != null) {
                    imageView.setImageDrawable(this.f4434rP);
                    if (this.yDb != 0) {
                        imageView.getDrawable().setColorFilter(this.yDb, Mode.SRC_ATOP);
                    }
                }
            }
            if (this.f4434rP == null) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
        this.qZa = (ImageView) view.findViewById(2131821517);
        if (this.qZa != null) {
            this.qZa.setVisibility(this.yDi);
        }
        if (this.yDj) {
            m36480w(view, isEnabled());
        }
        AppMethodBeat.m2505o(107259);
    }

    /* renamed from: w */
    private void m36480w(View view, boolean z) {
        AppMethodBeat.m2504i(107260);
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                m36480w(viewGroup.getChildAt(childCount), z);
            }
        }
        AppMethodBeat.m2505o(107260);
    }

    public void setTitle(CharSequence charSequence) {
        AppMethodBeat.m2504i(107261);
        if ((charSequence == null && this.f4430IT != null) || !(charSequence == null || charSequence.equals(this.f4430IT))) {
            this.yCZ = 0;
            this.f4430IT = charSequence;
            notifyChanged();
        }
        AppMethodBeat.m2505o(107261);
    }

    public void setTitle(int i) {
        AppMethodBeat.m2504i(107262);
        setTitle(this.mContext.getString(i));
        this.yCZ = i;
        AppMethodBeat.m2505o(107262);
    }

    public CharSequence getTitle() {
        return this.f4430IT;
    }

    /* renamed from: fa */
    public void mo39409fa() {
        AppMethodBeat.m2504i(107263);
        this.f4433ZV = C1318a.addfriend_icon_invite;
        Drawable drawable = this.mContext.getResources().getDrawable(C1318a.addfriend_icon_invite);
        if ((drawable == null && this.f4434rP != null) || !(drawable == null || this.f4434rP == drawable)) {
            this.f4434rP = drawable;
            notifyChanged();
        }
        AppMethodBeat.m2505o(107263);
    }

    public CharSequence getSummary() {
        return this.ppl;
    }

    public void setSummary(CharSequence charSequence) {
        AppMethodBeat.m2504i(107264);
        if ((charSequence == null && this.ppl != null) || !(charSequence == null || charSequence.equals(this.ppl))) {
            this.ppl = charSequence;
            notifyChanged();
        }
        AppMethodBeat.m2505o(107264);
    }

    public void setSummary(int i) {
        AppMethodBeat.m2504i(107265);
        setSummary(this.mContext.getString(i));
        AppMethodBeat.m2505o(107265);
    }

    public final void setEnabled(boolean z) {
        AppMethodBeat.m2504i(107266);
        if (this.f4432OH != z) {
            this.f4432OH = z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
        AppMethodBeat.m2505o(107266);
    }

    public final boolean isEnabled() {
        return this.f4432OH && this.yDh;
    }

    public final void setSelectable(boolean z) {
        AppMethodBeat.m2504i(107267);
        if (this.yDd != z) {
            this.yDd = z;
            notifyChanged();
        }
        AppMethodBeat.m2505o(107267);
    }

    public final void setKey(String str) {
        AppMethodBeat.m2504i(107268);
        this.mKey = str;
        if (this.yDe && !hasKey()) {
            dAF();
        }
        AppMethodBeat.m2505o(107268);
    }

    private void dAF() {
        AppMethodBeat.m2504i(107269);
        if (this.mKey == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Preference does not have a key assigned.");
            AppMethodBeat.m2505o(107269);
            throw illegalStateException;
        }
        this.yDe = true;
        AppMethodBeat.m2505o(107269);
    }

    private boolean hasKey() {
        AppMethodBeat.m2504i(107270);
        if (TextUtils.isEmpty(this.mKey)) {
            AppMethodBeat.m2505o(107270);
            return false;
        }
        AppMethodBeat.m2505o(107270);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean callChangeListener(Object obj) {
        AppMethodBeat.m2504i(107271);
        if (this.yCW == null) {
            AppMethodBeat.m2505o(107271);
            return true;
        }
        boolean a = this.yCW.mo39405a(this, obj);
        AppMethodBeat.m2505o(107271);
        return a;
    }

    /* renamed from: a */
    public void mo27696a(C23632a c23632a) {
        this.yCW = c23632a;
    }

    public final Context getContext() {
        return this.mContext;
    }

    /* Access modifiers changed, original: protected */
    public void notifyChanged() {
    }

    private void notifyDependencyChange(boolean z) {
        AppMethodBeat.m2504i(107272);
        List list = this.yDn;
        if (list == null) {
            AppMethodBeat.m2505o(107272);
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Preference) list.get(i)).m36479qj(z);
        }
        AppMethodBeat.m2505o(107272);
    }

    /* renamed from: qj */
    private void m36479qj(boolean z) {
        AppMethodBeat.m2504i(107273);
        if (this.yDh == z) {
            this.yDh = !z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
        AppMethodBeat.m2505o(107273);
    }

    private boolean shouldDisableDependents() {
        AppMethodBeat.m2504i(107274);
        if (isEnabled()) {
            AppMethodBeat.m2505o(107274);
            return false;
        }
        AppMethodBeat.m2505o(107274);
        return true;
    }

    /* renamed from: NW */
    public final void mo39406NW(int i) {
        AppMethodBeat.m2504i(107275);
        this.yDi = i;
        if (this.qZa != null) {
            this.qZa.setVisibility(i);
        }
        AppMethodBeat.m2505o(107275);
    }

    public String toString() {
        AppMethodBeat.m2504i(107276);
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        title = getSummary();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(107276);
        return stringBuilder2;
    }
}
