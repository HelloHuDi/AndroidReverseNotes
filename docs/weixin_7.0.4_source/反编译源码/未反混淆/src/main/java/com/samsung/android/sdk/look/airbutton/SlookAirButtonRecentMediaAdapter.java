package com.samsung.android.sdk.look.airbutton;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.sdk.look.SlookResourceManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter.AirButtonItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class SlookAirButtonRecentMediaAdapter extends SlookAirButtonAdapter {
    public static final String AUDIO_TYPE = "audio";
    private static final String ID = "id";
    public static final String IMAGE_TYPE = "image";
    private static final String MIME_TYPE = "mime_type";
    private static final String ORIENTATION = "orientation";
    private static final String TAG = "AirButtonRecentMediaAdapter";
    private static final String TITLE = "title";
    public static final String VIDEO_TYPE = "video";
    private static final String VOLUME = "external";
    private boolean DEBUG = false;
    private Context mContext;
    private int mCount = 0;
    private ArrayList<Bundle> mData = new ArrayList();
    private String mFilter;
    private boolean mIsShowing = false;
    private int mMaxCount = 15;
    private boolean mNeedUpdate = true;
    private Slook mSlook = new Slook();

    public SlookAirButtonRecentMediaAdapter(View view, Bundle bundle) {
        AppMethodBeat.i(117221);
        if (view == null && bundle == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You should set the View and Bundle in Param");
            AppMethodBeat.o(117221);
            throw illegalArgumentException;
        } else if (isSupport(1)) {
            this.mFilter = getFilter(bundle);
            if (view != null) {
                this.mContext = view.getContext();
                this.DEBUG = true;
                this.mMaxCount = SlookResourceManager.getInt(3);
                setEmptyText(SlookResourceManager.getText(this.mContext, 1));
            }
            AppMethodBeat.o(117221);
        } else {
            AppMethodBeat.o(117221);
        }
    }

    public final AirButtonItem getItem(int i) {
        AppMethodBeat.i(117222);
        Bundle bundle = (Bundle) this.mData.get(i);
        int i2 = bundle.getInt("id");
        int i3 = bundle.getInt(MIME_TYPE);
        AirButtonItem airButtonItem = new AirButtonItem(getThumbNail(i2, i3, bundle.getString("title"), bundle.getInt(ORIENTATION)), null, getUri(i2, i3));
        AppMethodBeat.o(117222);
        return airButtonItem;
    }

    public final int getCount() {
        return this.mCount;
    }

    private Drawable getThumbNail(int i, int i2, String str, int i3) {
        AppMethodBeat.i(117223);
        Drawable drawable;
        switch (i2) {
            case 1:
                Options options = new Options();
                options.inSampleSize = 2;
                Bitmap thumbnail = Thumbnails.getThumbnail(this.mContext.getContentResolver(), (long) i, 1, options);
                if (thumbnail == null) {
                    drawable = null;
                } else if (i3 == 90 || i3 == 180 || i3 == 270) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate((float) i3);
                    drawable = new BitmapDrawable(this.mContext.getResources(), Bitmap.createBitmap(thumbnail, 0, 0, thumbnail.getWidth(), thumbnail.getHeight(), matrix, true));
                } else {
                    drawable = new BitmapDrawable(this.mContext.getResources(), thumbnail);
                }
                AppMethodBeat.o(117223);
                return drawable;
            case 2:
                drawable = getAudioDrawable(str);
                AppMethodBeat.o(117223);
                return drawable;
            case 3:
                drawable = new BitmapDrawable(this.mContext.getResources(), Video.Thumbnails.getThumbnail(this.mContext.getContentResolver(), (long) i, 3, null));
                AppMethodBeat.o(117223);
                return drawable;
            default:
                AppMethodBeat.o(117223);
                return null;
        }
    }

    private Drawable getAudioDrawable(String str) {
        AppMethodBeat.i(117224);
        Bitmap createBitmap = Bitmap.createBitmap(200, 200, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable drawable = this.mContext.getResources().getDrawable(SlookResourceManager.getDrawableId(2));
        drawable.setBounds(new Rect(0, 0, 200, 200));
        canvas.drawColor(-2236963, Mode.SRC);
        drawable.draw(canvas);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), createBitmap);
        AppMethodBeat.o(117224);
        return bitmapDrawable;
    }

    private Uri getUri(int i, int i2) {
        AppMethodBeat.i(117225);
        Uri withAppendedId;
        switch (i2) {
            case 1:
                withAppendedId = ContentUris.withAppendedId(Media.EXTERNAL_CONTENT_URI, (long) i);
                AppMethodBeat.o(117225);
                return withAppendedId;
            case 2:
                withAppendedId = ContentUris.withAppendedId(Audio.Media.EXTERNAL_CONTENT_URI, (long) i);
                AppMethodBeat.o(117225);
                return withAppendedId;
            case 3:
                withAppendedId = ContentUris.withAppendedId(Video.Media.EXTERNAL_CONTENT_URI, (long) i);
                AppMethodBeat.o(117225);
                return withAppendedId;
            default:
                AppMethodBeat.o(117225);
                return null;
        }
    }

    private String getFilter(Bundle bundle) {
        AppMethodBeat.i(117226);
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (bundle == null || bundle.getBoolean("image")) {
            stringBuilder.append("media_type = ");
            stringBuilder.append(1);
            i = 1;
        }
        if (bundle == null || bundle.getBoolean("video")) {
            if (i != 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("media_type = ");
            stringBuilder.append(3);
            i = 1;
        }
        if (bundle == null || bundle.getBoolean(AUDIO_TYPE)) {
            if (i != 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("media_type = ");
            stringBuilder.append(2);
        }
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2 == null || stringBuilder2.length() <= 0) {
            AppMethodBeat.o(117226);
            return null;
        }
        AppMethodBeat.o(117226);
        return stringBuilder2;
    }

    public final void onShow(View view) {
        AppMethodBeat.i(117227);
        updateData();
        this.mIsShowing = true;
        super.onShow(view);
        AppMethodBeat.o(117227);
    }

    public final void onHide(View view) {
        AppMethodBeat.i(117228);
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onHide(view);
        AppMethodBeat.o(117228);
    }

    public final void onDismiss(View view) {
        AppMethodBeat.i(117229);
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onDismiss(view);
        AppMethodBeat.o(117229);
    }

    private synchronized void updateData() {
        Throwable th;
        AppMethodBeat.i(117230);
        if (!this.mNeedUpdate || this.mIsShowing) {
            AppMethodBeat.o(117230);
        } else {
            this.mNeedUpdate = false;
            this.mData.clear();
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(Files.getContentUri(VOLUME), new String[]{"_id", MessengerShareContentUtility.MEDIA_TYPE, "title", ORIENTATION}, this.mFilter, null, "date_modified DESC LIMIT " + this.mMaxCount);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.o(117230);
                } else {
                    while (query.moveToNext()) {
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", query.getInt(0));
                            bundle.putInt(MIME_TYPE, query.getInt(1));
                            bundle.putInt(ORIENTATION, query.getInt(3));
                            this.mData.add(bundle);
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.o(117230);
                            throw th;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    this.mCount = this.mData.size();
                    AppMethodBeat.o(117230);
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
            }
        }
    }

    private boolean isSupport(int i) {
        AppMethodBeat.i(117231);
        if (this.mSlook.isFeatureEnabled(1)) {
            AppMethodBeat.o(117231);
            return true;
        }
        AppMethodBeat.o(117231);
        return false;
    }
}
