package com.tencent.mm.ui.base.preference;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.v;
import java.util.List;

public class Preference implements Comparable<Preference> {
    private CharSequence IT;
    private int[] MT;
    private boolean OH;
    protected int ZV;
    private int btQ;
    public int ksd;
    public final Context mContext;
    private Object mDefaultValue;
    private Bundle mExtras;
    public String mKey;
    private CharSequence ppl;
    private ImageView qZa;
    protected Drawable rP;
    private a yCW;
    public b yCX;
    public c yCY;
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

    public interface a {
        boolean a(Preference preference, Object obj);
    }

    public interface b {
        boolean car();
    }

    public interface c {
        boolean cbK();
    }

    public static class BaseSavedState extends AbsSavedState {
        public static final Creator<BaseSavedState> CREATOR = new Creator<BaseSavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new BaseSavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(107253);
                BaseSavedState baseSavedState = new BaseSavedState(parcel);
                AppMethodBeat.o(107253);
                return baseSavedState;
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.i(107254);
            AppMethodBeat.o(107254);
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.i(107277);
        Preference preference = (Preference) obj;
        int i;
        if (this.btQ != BaseClientBuilder.API_PRIORITY_OTHER || (this.btQ == BaseClientBuilder.API_PRIORITY_OTHER && preference.btQ != BaseClientBuilder.API_PRIORITY_OTHER)) {
            i = this.btQ - preference.btQ;
            AppMethodBeat.o(107277);
            return i;
        } else if (this.IT == null) {
            AppMethodBeat.o(107277);
            return 1;
        } else if (preference.IT == null) {
            AppMethodBeat.o(107277);
            return -1;
        } else {
            CharSequence charSequence = this.IT;
            CharSequence charSequence2 = preference.IT;
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
                    AppMethodBeat.o(107277);
                    return i2;
                }
                i2 = i5;
                i3 = i4;
            }
            i = length - length2;
            AppMethodBeat.o(107277);
            return i;
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        AppMethodBeat.i(107255);
        this.MT = new int[]{R.attr.bl, R.attr.bi};
        this.btQ = BaseClientBuilder.API_PRIORITY_OTHER;
        this.yDb = 0;
        this.OH = true;
        this.yDd = true;
        this.yDf = true;
        this.yDh = true;
        this.ksd = -1;
        this.qZa = null;
        this.yDi = 0;
        this.yDj = true;
        this.yDk = R.layout.ae4;
        this.yDm = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.ad.a.a.Preference, i, 0);
        for (int indexCount = obtainStyledAttributes.getIndexCount(); indexCount >= 0; indexCount--) {
            int index = obtainStyledAttributes.getIndex(indexCount);
            if (index == 5) {
                this.ZV = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == 6) {
                this.yDb = obtainStyledAttributes.getColor(index, 0);
            } else if (index == 7) {
                this.mKey = obtainStyledAttributes.getString(index);
            } else if (index == 4) {
                this.yCZ = obtainStyledAttributes.getResourceId(index, 0);
                this.IT = obtainStyledAttributes.getString(index);
                if (this.yCZ != 0) {
                    this.IT = context.getString(this.yCZ);
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
                this.OH = obtainStyledAttributes.getBoolean(index, true);
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
        AppMethodBeat.o(107255);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842894);
    }

    public Preference(Context context) {
        this(context, null);
    }

    public final Bundle getExtras() {
        AppMethodBeat.i(107256);
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        Bundle bundle = this.mExtras;
        AppMethodBeat.o(107256);
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
        AppMethodBeat.i(107257);
        if (view == null) {
            view = onCreateView(viewGroup);
        }
        onBindView(view);
        AppMethodBeat.o(107257);
        return view;
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107258);
        LayoutInflater hu = v.hu(this.mContext);
        View inflate = hu.inflate(this.yDk, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (this.yDl != 0) {
                hu.inflate(this.yDl, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        AppMethodBeat.o(107258);
        return inflate;
    }

    /* Access modifiers changed, original: protected */
    public void onBindView(View view) {
        int i = 0;
        AppMethodBeat.i(107259);
        View findViewById = view.findViewById(R.id.m5);
        if (findViewById != null) {
            findViewById.setMinimumHeight((int) (((float) this.mContext.getResources().getDimensionPixelSize(R.dimen.lc)) * com.tencent.mm.bz.a.fZ(this.mContext)));
            ab.d("dancy test", "resource:%s, height:%s, scale:%s", this.mContext.getResources(), Integer.valueOf(this.mContext.getResources().getDimensionPixelSize(R.dimen.lc)), Float.valueOf(com.tencent.mm.bz.a.fZ(this.mContext)));
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
            if (!(this.ZV == 0 && this.rP == null)) {
                if (this.rP == null) {
                    this.rP = this.mContext.getResources().getDrawable(this.ZV);
                }
                if (this.rP != null) {
                    imageView.setImageDrawable(this.rP);
                    if (this.yDb != 0) {
                        imageView.getDrawable().setColorFilter(this.yDb, Mode.SRC_ATOP);
                    }
                }
            }
            if (this.rP == null) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
        this.qZa = (ImageView) view.findViewById(R.id.z_);
        if (this.qZa != null) {
            this.qZa.setVisibility(this.yDi);
        }
        if (this.yDj) {
            w(view, isEnabled());
        }
        AppMethodBeat.o(107259);
    }

    private void w(View view, boolean z) {
        AppMethodBeat.i(107260);
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                w(viewGroup.getChildAt(childCount), z);
            }
        }
        AppMethodBeat.o(107260);
    }

    public void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(107261);
        if ((charSequence == null && this.IT != null) || !(charSequence == null || charSequence.equals(this.IT))) {
            this.yCZ = 0;
            this.IT = charSequence;
            notifyChanged();
        }
        AppMethodBeat.o(107261);
    }

    public void setTitle(int i) {
        AppMethodBeat.i(107262);
        setTitle(this.mContext.getString(i));
        this.yCZ = i;
        AppMethodBeat.o(107262);
    }

    public CharSequence getTitle() {
        return this.IT;
    }

    public void fa() {
        AppMethodBeat.i(107263);
        this.ZV = R.raw.addfriend_icon_invite;
        Drawable drawable = this.mContext.getResources().getDrawable(R.raw.addfriend_icon_invite);
        if ((drawable == null && this.rP != null) || !(drawable == null || this.rP == drawable)) {
            this.rP = drawable;
            notifyChanged();
        }
        AppMethodBeat.o(107263);
    }

    public CharSequence getSummary() {
        return this.ppl;
    }

    public void setSummary(CharSequence charSequence) {
        AppMethodBeat.i(107264);
        if ((charSequence == null && this.ppl != null) || !(charSequence == null || charSequence.equals(this.ppl))) {
            this.ppl = charSequence;
            notifyChanged();
        }
        AppMethodBeat.o(107264);
    }

    public void setSummary(int i) {
        AppMethodBeat.i(107265);
        setSummary(this.mContext.getString(i));
        AppMethodBeat.o(107265);
    }

    public final void setEnabled(boolean z) {
        AppMethodBeat.i(107266);
        if (this.OH != z) {
            this.OH = z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
        AppMethodBeat.o(107266);
    }

    public final boolean isEnabled() {
        return this.OH && this.yDh;
    }

    public final void setSelectable(boolean z) {
        AppMethodBeat.i(107267);
        if (this.yDd != z) {
            this.yDd = z;
            notifyChanged();
        }
        AppMethodBeat.o(107267);
    }

    public final void setKey(String str) {
        AppMethodBeat.i(107268);
        this.mKey = str;
        if (this.yDe && !hasKey()) {
            dAF();
        }
        AppMethodBeat.o(107268);
    }

    private void dAF() {
        AppMethodBeat.i(107269);
        if (this.mKey == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Preference does not have a key assigned.");
            AppMethodBeat.o(107269);
            throw illegalStateException;
        }
        this.yDe = true;
        AppMethodBeat.o(107269);
    }

    private boolean hasKey() {
        AppMethodBeat.i(107270);
        if (TextUtils.isEmpty(this.mKey)) {
            AppMethodBeat.o(107270);
            return false;
        }
        AppMethodBeat.o(107270);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean callChangeListener(Object obj) {
        AppMethodBeat.i(107271);
        if (this.yCW == null) {
            AppMethodBeat.o(107271);
            return true;
        }
        boolean a = this.yCW.a(this, obj);
        AppMethodBeat.o(107271);
        return a;
    }

    public void a(a aVar) {
        this.yCW = aVar;
    }

    public final Context getContext() {
        return this.mContext;
    }

    /* Access modifiers changed, original: protected */
    public void notifyChanged() {
    }

    private void notifyDependencyChange(boolean z) {
        AppMethodBeat.i(107272);
        List list = this.yDn;
        if (list == null) {
            AppMethodBeat.o(107272);
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Preference) list.get(i)).qj(z);
        }
        AppMethodBeat.o(107272);
    }

    private void qj(boolean z) {
        AppMethodBeat.i(107273);
        if (this.yDh == z) {
            this.yDh = !z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
        AppMethodBeat.o(107273);
    }

    private boolean shouldDisableDependents() {
        AppMethodBeat.i(107274);
        if (isEnabled()) {
            AppMethodBeat.o(107274);
            return false;
        }
        AppMethodBeat.o(107274);
        return true;
    }

    public final void NW(int i) {
        AppMethodBeat.i(107275);
        this.yDi = i;
        if (this.qZa != null) {
            this.qZa.setVisibility(i);
        }
        AppMethodBeat.o(107275);
    }

    public String toString() {
        AppMethodBeat.i(107276);
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
        AppMethodBeat.o(107276);
        return stringBuilder2;
    }
}
