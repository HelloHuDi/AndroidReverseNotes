package android.support.p057v4.app;

import android.os.Parcelable;
import android.support.p057v4.view.C25365p;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: android.support.v4.app.k */
public abstract class C31856k extends C25365p {
    private C0338m mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private final C0336i mFragmentManager;

    public abstract Fragment getItem(int i);

    public C31856k(C0336i c0336i) {
        this.mFragmentManager = c0336i;
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        long j = (long) i;
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(C31856k.m51630b(viewGroup.getId(), j));
        if (findFragmentByTag != null) {
            this.mCurTransaction.mo563d(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i);
            this.mCurTransaction.mo553a(viewGroup.getId(), findFragmentByTag, C31856k.m51630b(viewGroup.getId(), j));
        }
        if (findFragmentByTag != this.mCurrentPrimaryItem) {
            findFragmentByTag.setMenuVisibility(false);
            findFragmentByTag.setUserVisibleHint(false);
        }
        return findFragmentByTag;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.mo558c((Fragment) obj);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                this.mCurrentPrimaryItem.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.mCurTransaction != null) {
            this.mCurTransaction.commitNowAllowingStateLoss();
            this.mCurTransaction = null;
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public Parcelable saveState() {
        return null;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    /* renamed from: b */
    private static String m51630b(int i, long j) {
        return "android:switcher:" + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + j;
    }
}
