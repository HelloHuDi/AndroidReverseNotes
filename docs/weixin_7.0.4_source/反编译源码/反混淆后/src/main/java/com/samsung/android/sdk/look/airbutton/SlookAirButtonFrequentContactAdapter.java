package com.samsung.android.sdk.look.airbutton;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.sdk.look.SlookResourceManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter.AirButtonItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class SlookAirButtonFrequentContactAdapter extends SlookAirButtonAdapter {
    public static final String DATA = "data";
    public static final String DISPLAY_NAME = "display_name";
    private static final String EMAIL = "vnd.android.cursor.item/email_v2";
    private static final String FREQUENT_URI = "content://com.android.contacts/contacts/frequent_data";
    /* renamed from: ID */
    public static final String f5226ID = "id";
    public static final String LOOKUP_KEY = "lookup_key";
    private static final String MIME_TYPE = "MIME_TYPE";
    private static final String PHONE = "vnd.android.cursor.item/phone_v2";
    public static final String PHOTO = "photo";
    public static final String PHOTO_URI = "photo_uri";
    private static final String TAG = "AirButtonFrequentContactAdapter";
    private boolean DEBUG = false;
    private final String EXTRA_CONDITION = "extra_condition";
    private final String IS_PRIVATE = "is_private";
    private Context mContext;
    private int mCount = 0;
    private ArrayList<Bundle> mData = new ArrayList();
    private boolean mIsShowing = false;
    private int mMaxCount = 15;
    private boolean mNeedUpdate = true;
    private StringBuilder mSelectionSb;
    private Slook mSlook = new Slook();

    public SlookAirButtonFrequentContactAdapter(View view, Bundle bundle) {
        AppMethodBeat.m2504i(117235);
        if (view == null && bundle == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You should set the View and Bundle in Param");
            AppMethodBeat.m2505o(117235);
            throw illegalArgumentException;
        } else if (isSupport(1)) {
            if (bundle != null) {
                boolean z;
                String string = bundle.getString(MIME_TYPE);
                this.mSelectionSb = new StringBuilder();
                if (string != null) {
                    this.mSelectionSb.append("view_data.");
                    this.mSelectionSb.append("mimetype");
                    this.mSelectionSb.append("='");
                    this.mSelectionSb.append(string);
                    this.mSelectionSb.append("'");
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = bundle.getBoolean("PRIVATE", false);
                if (!z2) {
                    if (z) {
                        this.mSelectionSb.append(" and ");
                    }
                    this.mSelectionSb.append("is_private=0");
                }
                String string2 = bundle.getString("extra_condition");
                if (string2 != null) {
                    if (z || !z2) {
                        this.mSelectionSb.append(" and ");
                    }
                    this.mSelectionSb.append(string2);
                }
            }
            this.mMaxCount = SlookResourceManager.getInt(2);
            this.DEBUG = true;
            if (view != null) {
                this.mContext = view.getContext();
                setEmptyText(SlookResourceManager.getText(this.mContext, 0));
            }
            AppMethodBeat.m2505o(117235);
        } else {
            AppMethodBeat.m2505o(117235);
        }
    }

    public final void onShow(View view) {
        AppMethodBeat.m2504i(117236);
        updateData();
        this.mIsShowing = true;
        super.onShow(view);
        AppMethodBeat.m2505o(117236);
    }

    public final void onHide(View view) {
        AppMethodBeat.m2504i(117237);
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onHide(view);
        AppMethodBeat.m2505o(117237);
    }

    public final void onDismiss(View view) {
        AppMethodBeat.m2504i(117238);
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onDismiss(view);
        AppMethodBeat.m2505o(117238);
    }

    public final int getCount() {
        return this.mCount;
    }

    public final AirButtonItem getItem(int i) {
        Drawable drawable;
        AppMethodBeat.m2504i(117239);
        Bundle bundle = (Bundle) this.mData.get(i);
        String string = bundle.getString(DISPLAY_NAME);
        String string2 = bundle.getString("data");
        byte[] byteArray = bundle.getByteArray("photo");
        if (byteArray == null) {
            drawable = this.mContext.getResources().getDrawable(SlookResourceManager.getDrawableId(1));
        } else {
            drawable = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
        }
        AirButtonItem airButtonItem = new AirButtonItem(drawable, string, string2, bundle);
        AppMethodBeat.m2505o(117239);
        return airButtonItem;
    }

    private synchronized void updateData() {
        AppMethodBeat.m2504i(117240);
        if (!this.mNeedUpdate || this.mIsShowing) {
            AppMethodBeat.m2505o(117240);
        } else {
            this.mNeedUpdate = false;
            this.mData.clear();
            Cursor query = this.mContext.getContentResolver().query(Uri.parse(FREQUENT_URI), new String[]{"_id", DISPLAY_NAME, PHOTO_URI, "data15", "lookup", "mimetype", "data1", "is_private"}, this.mSelectionSb != null ? this.mSelectionSb.toString() : null, null, "_id LIMIT " + this.mMaxCount);
            if (query == null) {
                AppMethodBeat.m2505o(117240);
            } else {
                while (query.moveToNext()) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("id", query.getInt(0));
                        bundle.putString(DISPLAY_NAME, query.getString(1));
                        bundle.putString(PHOTO_URI, query.getString(2));
                        bundle.putByteArray("photo", query.getBlob(3));
                        bundle.putString(LOOKUP_KEY, query.getString(4));
                        bundle.putString(MIME_TYPE, query.getString(5));
                        bundle.putString("data", query.getString(6));
                        bundle.putBoolean("is_private", query.getInt(7) == 1);
                        this.mData.add(bundle);
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(117240);
                    }
                }
                if (query != null) {
                    query.close();
                }
                try {
                    this.mCount = this.mData.size();
                    AppMethodBeat.m2505o(117240);
                } catch (NoSuchMethodError e) {
                    AppMethodBeat.m2505o(117240);
                }
            }
        }
    }

    private boolean isSupport(int i) {
        AppMethodBeat.m2504i(117241);
        if (this.mSlook.isFeatureEnabled(1)) {
            AppMethodBeat.m2505o(117241);
            return true;
        }
        AppMethodBeat.m2505o(117241);
        return false;
    }
}
