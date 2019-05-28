package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.p;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ttpic.util.VideoMaterialUtil;

public abstract class k extends p {
    private m mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private final i mFragmentManager;

    public abstract Fragment getItem(int i);

    public k(i iVar) {
        this.mFragmentManager = iVar;
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
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(b(viewGroup.getId(), j));
        if (findFragmentByTag != null) {
            this.mCurTransaction.d(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i);
            this.mCurTransaction.a(viewGroup.getId(), findFragmentByTag, b(viewGroup.getId(), j));
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
        this.mCurTransaction.c((Fragment) obj);
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

    private static String b(int i, long j) {
        return "android:switcher:" + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + j;
    }
}
