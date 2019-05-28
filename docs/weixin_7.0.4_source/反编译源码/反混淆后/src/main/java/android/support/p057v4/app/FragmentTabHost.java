package android.support.p057v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.FragmentTabHost */
public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    /* renamed from: Dv */
    private OnTabChangeListener f17674Dv;
    /* renamed from: Dw */
    private C41501a f17675Dw;
    /* renamed from: Dx */
    private boolean f17676Dx;
    private int mContainerId;
    private Context mContext;
    private C0336i mFragmentManager;
    /* renamed from: rS */
    private final ArrayList<C41501a> f17677rS = new ArrayList();

    /* renamed from: android.support.v4.app.FragmentTabHost$SavedState */
    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C174281();
        /* renamed from: Dy */
        String f3877Dy;

        /* renamed from: android.support.v4.app.FragmentTabHost$SavedState$1 */
        static class C174281 implements Creator<SavedState> {
            C174281() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f3877Dy = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f3877Dy);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f3877Dy + "}";
        }
    }

    /* renamed from: android.support.v4.app.FragmentTabHost$a */
    static final class C41501a {
        /* renamed from: DA */
        final Bundle f16781DA;
        /* renamed from: Dz */
        final Class<?> f16782Dz;
        Fragment fragment;
        final String tag;
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f17674Dv = onTabChangeListener;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        C0338m c0338m = null;
        int size = this.f17677rS.size();
        for (int i = 0; i < size; i++) {
            C41501a c41501a = (C41501a) this.f17677rS.get(i);
            c41501a.fragment = this.mFragmentManager.findFragmentByTag(c41501a.tag);
            if (!(c41501a.fragment == null || c41501a.fragment.isDetached())) {
                if (c41501a.tag.equals(currentTabTag)) {
                    this.f17675Dw = c41501a;
                } else {
                    if (c0338m == null) {
                        c0338m = this.mFragmentManager.beginTransaction();
                    }
                    c0338m.mo558c(c41501a.fragment);
                }
            }
        }
        this.f17676Dx = true;
        C0338m a = m82248a(currentTabTag, c0338m);
        if (a != null) {
            a.commit();
            this.mFragmentManager.executePendingTransactions();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17676Dx = false;
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3877Dy = getCurrentTabTag();
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCurrentTabByTag(savedState.f3877Dy);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onTabChanged(String str) {
        if (this.f17676Dx) {
            C0338m a = m82248a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.f17674Dv != null) {
            this.f17674Dv.onTabChanged(str);
        }
    }

    /* renamed from: a */
    private C0338m m82248a(String str, C0338m c0338m) {
        C41501a I = m82247I(str);
        if (this.f17675Dw != I) {
            if (c0338m == null) {
                c0338m = this.mFragmentManager.beginTransaction();
            }
            if (!(this.f17675Dw == null || this.f17675Dw.fragment == null)) {
                c0338m.mo558c(this.f17675Dw.fragment);
            }
            if (I != null) {
                if (I.fragment == null) {
                    I.fragment = Fragment.instantiate(this.mContext, I.f16782Dz.getName(), I.f16781DA);
                    c0338m.mo553a(this.mContainerId, I.fragment, I.tag);
                } else {
                    c0338m.mo563d(I.fragment);
                }
            }
            this.f17675Dw = I;
        }
        return c0338m;
    }

    /* renamed from: I */
    private C41501a m82247I(String str) {
        int size = this.f17677rS.size();
        for (int i = 0; i < size; i++) {
            C41501a c41501a = (C41501a) this.f17677rS.get(i);
            if (c41501a.tag.equals(str)) {
                return c41501a;
            }
        }
        return null;
    }
}
