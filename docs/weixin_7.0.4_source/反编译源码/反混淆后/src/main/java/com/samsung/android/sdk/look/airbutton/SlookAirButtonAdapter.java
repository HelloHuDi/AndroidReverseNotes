package com.samsung.android.sdk.look.airbutton;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class SlookAirButtonAdapter {
    private CharSequence mEmptyText;
    private ArrayList<AirButtonItem> mItemList = null;

    public static class AirButtonItem {
        private Object mData = null;
        private String mDescription = null;
        private Drawable mImage = null;
        private String mSubDescription = null;
        private View mView = null;

        public AirButtonItem(View view, Object obj) {
            AppMethodBeat.m2504i(117232);
            if (view == null && obj == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You should set the View and Object in Param");
                AppMethodBeat.m2505o(117232);
                throw illegalArgumentException;
            }
            set(view, obj);
            AppMethodBeat.m2505o(117232);
        }

        public AirButtonItem(Drawable drawable, String str, Object obj) {
            AppMethodBeat.m2504i(117233);
            if (drawable == null && str == null && obj == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You should set the Drawable, String and Object in Param");
                AppMethodBeat.m2505o(117233);
                throw illegalArgumentException;
            }
            set(drawable, str, obj);
            AppMethodBeat.m2505o(117233);
        }

        public AirButtonItem(Drawable drawable, String str, String str2, Object obj) {
            AppMethodBeat.m2504i(117234);
            if (drawable == null && str == null && str2 == null && obj == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You should set the Drawable, String, subDescription and Object in Param");
                AppMethodBeat.m2505o(117234);
                throw illegalArgumentException;
            }
            set(drawable, str, str2, obj);
            AppMethodBeat.m2505o(117234);
        }

        public void set(View view, Object obj) {
            this.mView = view;
            this.mData = obj;
        }

        public void set(Drawable drawable, String str, Object obj) {
            this.mImage = drawable;
            this.mDescription = str;
            this.mData = obj;
        }

        public void set(Drawable drawable, String str, String str2, Object obj) {
            this.mImage = drawable;
            this.mDescription = str;
            this.mSubDescription = str2;
            this.mData = obj;
        }

        public View getView() {
            return this.mView;
        }

        public Drawable getImage() {
            return this.mImage;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public String getSubDescription() {
            return this.mSubDescription;
        }

        public Object getData() {
            return this.mData;
        }
    }

    public SlookAirButtonAdapter(ArrayList<AirButtonItem> arrayList) {
        AppMethodBeat.m2504i(117242);
        addItem((ArrayList) arrayList);
        AppMethodBeat.m2505o(117242);
    }

    public void addItem(AirButtonItem airButtonItem) {
        AppMethodBeat.m2504i(117243);
        if (this.mItemList == null) {
            this.mItemList = new ArrayList();
        }
        this.mItemList.add(airButtonItem);
        AppMethodBeat.m2505o(117243);
    }

    public int addItem(ArrayList<AirButtonItem> arrayList) {
        AppMethodBeat.m2504i(117244);
        if (this.mItemList != null) {
            this.mItemList.clear();
        }
        this.mItemList = arrayList;
        int size = this.mItemList.size() - 1;
        AppMethodBeat.m2505o(117244);
        return size;
    }

    public void insertItem(int i, AirButtonItem airButtonItem) {
        AppMethodBeat.m2504i(117245);
        if (this.mItemList != null) {
            this.mItemList.add(i, airButtonItem);
            AppMethodBeat.m2505o(117245);
        } else if (i == 0) {
            addItem(airButtonItem);
            AppMethodBeat.m2505o(117245);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The list is empty.");
            AppMethodBeat.m2505o(117245);
            throw illegalArgumentException;
        }
    }

    public void removeItem(int i) {
        AppMethodBeat.m2504i(117246);
        if (this.mItemList == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The list is empty.");
            AppMethodBeat.m2505o(117246);
            throw illegalArgumentException;
        }
        this.mItemList.remove(i);
        AppMethodBeat.m2505o(117246);
    }

    public void updateItem(int i, AirButtonItem airButtonItem) {
        AppMethodBeat.m2504i(117247);
        if (this.mItemList == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The list is empty.");
            AppMethodBeat.m2505o(117247);
            throw illegalArgumentException;
        }
        this.mItemList.set(i, airButtonItem);
        AppMethodBeat.m2505o(117247);
    }

    public void clear() {
        AppMethodBeat.m2504i(117248);
        if (this.mItemList == null) {
            AppMethodBeat.m2505o(117248);
            return;
        }
        this.mItemList.clear();
        AppMethodBeat.m2505o(117248);
    }

    public int getCount() {
        AppMethodBeat.m2504i(117249);
        if (this.mItemList == null) {
            AppMethodBeat.m2505o(117249);
            return 0;
        }
        int size = this.mItemList.size();
        AppMethodBeat.m2505o(117249);
        return size;
    }

    public AirButtonItem getItem(int i) {
        AppMethodBeat.m2504i(117250);
        if (this.mItemList == null || i >= this.mItemList.size()) {
            AppMethodBeat.m2505o(117250);
            return null;
        }
        AirButtonItem airButtonItem = (AirButtonItem) this.mItemList.get(i);
        AppMethodBeat.m2505o(117250);
        return airButtonItem;
    }

    public void setEmptyText(CharSequence charSequence) {
        this.mEmptyText = charSequence;
    }

    public CharSequence getEmptyText() {
        return this.mEmptyText;
    }

    public boolean onHoverEnter(View view) {
        return true;
    }

    public void onHoverExit(View view) {
    }

    public void onShow(View view) {
    }

    public void onHide(View view) {
    }

    public void onDismiss(View view) {
    }
}
