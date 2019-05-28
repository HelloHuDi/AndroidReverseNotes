package android.support.v4.app;

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

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private OnTabChangeListener Dv;
    private a Dw;
    private boolean Dx;
    private int mContainerId;
    private Context mContext;
    private i mFragmentManager;
    private final ArrayList<a> rS = new ArrayList();

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        String Dy;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.Dy = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.Dy);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.Dy + "}";
        }
    }

    static final class a {
        final Bundle DA;
        final Class<?> Dz;
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
        this.Dv = onTabChangeListener;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        m mVar = null;
        int size = this.rS.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.rS.get(i);
            aVar.fragment = this.mFragmentManager.findFragmentByTag(aVar.tag);
            if (!(aVar.fragment == null || aVar.fragment.isDetached())) {
                if (aVar.tag.equals(currentTabTag)) {
                    this.Dw = aVar;
                } else {
                    if (mVar == null) {
                        mVar = this.mFragmentManager.beginTransaction();
                    }
                    mVar.c(aVar.fragment);
                }
            }
        }
        this.Dx = true;
        m a = a(currentTabTag, mVar);
        if (a != null) {
            a.commit();
            this.mFragmentManager.executePendingTransactions();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Dx = false;
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Dy = getCurrentTabTag();
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCurrentTabByTag(savedState.Dy);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onTabChanged(String str) {
        if (this.Dx) {
            m a = a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.Dv != null) {
            this.Dv.onTabChanged(str);
        }
    }

    private m a(String str, m mVar) {
        a I = I(str);
        if (this.Dw != I) {
            if (mVar == null) {
                mVar = this.mFragmentManager.beginTransaction();
            }
            if (!(this.Dw == null || this.Dw.fragment == null)) {
                mVar.c(this.Dw.fragment);
            }
            if (I != null) {
                if (I.fragment == null) {
                    I.fragment = Fragment.instantiate(this.mContext, I.Dz.getName(), I.DA);
                    mVar.a(this.mContainerId, I.fragment, I.tag);
                } else {
                    mVar.d(I.fragment);
                }
            }
            this.Dw = I;
        }
        return mVar;
    }

    private a I(String str) {
        int size = this.rS.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.rS.get(i);
            if (aVar.tag.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
