package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageRequest.Builder;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.login.R;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ProfilePictureView extends FrameLayout {
    private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
    private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
    private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
    public static final int CUSTOM = -1;
    private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
    private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
    public static final int LARGE = -4;
    private static final int MIN_SIZE = 1;
    public static final int NORMAL = -3;
    private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
    private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
    private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
    public static final int SMALL = -2;
    private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
    public static final String TAG = ProfilePictureView.class.getSimpleName();
    private Bitmap customizedDefaultProfilePicture = null;
    private ImageView image;
    private Bitmap imageContents;
    private boolean isCropped = true;
    private ImageRequest lastRequest;
    private OnErrorListener onErrorListener;
    private int presetSizeType = -1;
    private String profileId;
    private int queryHeight = 0;
    private int queryWidth = 0;

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    static /* synthetic */ void access$000(ProfilePictureView profilePictureView, ImageResponse imageResponse) {
        AppMethodBeat.i(92709);
        profilePictureView.processResponse(imageResponse);
        AppMethodBeat.o(92709);
    }

    static {
        AppMethodBeat.i(92710);
        AppMethodBeat.o(92710);
    }

    public ProfilePictureView(Context context) {
        super(context);
        AppMethodBeat.i(92689);
        initialize(context);
        AppMethodBeat.o(92689);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(92690);
        initialize(context);
        parseAttributes(attributeSet);
        AppMethodBeat.o(92690);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(92691);
        initialize(context);
        parseAttributes(attributeSet);
        AppMethodBeat.o(92691);
    }

    public final int getPresetSize() {
        return this.presetSizeType;
    }

    public final void setPresetSize(int i) {
        AppMethodBeat.i(92692);
        switch (i) {
            case -4:
            case -3:
            case -2:
            case -1:
                this.presetSizeType = i;
                requestLayout();
                AppMethodBeat.o(92692);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must use a predefined preset size");
                AppMethodBeat.o(92692);
                throw illegalArgumentException;
        }
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    public final void setCropped(boolean z) {
        AppMethodBeat.i(92693);
        this.isCropped = z;
        refreshImage(false);
        AppMethodBeat.o(92693);
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final void setProfileId(String str) {
        AppMethodBeat.i(92694);
        boolean z = false;
        if (Utility.isNullOrEmpty(this.profileId) || !this.profileId.equalsIgnoreCase(str)) {
            setBlankProfilePicture();
            z = true;
        }
        this.profileId = str;
        refreshImage(z);
        AppMethodBeat.o(92694);
    }

    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.customizedDefaultProfilePicture = bitmap;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        boolean z = true;
        AppMethodBeat.i(92695);
        LayoutParams layoutParams = getLayoutParams();
        boolean z2 = false;
        int size = MeasureSpec.getSize(i2);
        int size2 = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i2) != ErrorDialogData.SUPPRESSED && layoutParams.height == -2) {
            size = getPresetSizeInPixels(true);
            i2 = MeasureSpec.makeMeasureSpec(size, ErrorDialogData.SUPPRESSED);
            z2 = true;
        }
        if (MeasureSpec.getMode(i) == ErrorDialogData.SUPPRESSED || layoutParams.width != -2) {
            z = z2;
        } else {
            int presetSizeInPixels = getPresetSizeInPixels(true);
            i = MeasureSpec.makeMeasureSpec(presetSizeInPixels, ErrorDialogData.SUPPRESSED);
            size2 = presetSizeInPixels;
        }
        if (z) {
            setMeasuredDimension(size2, size);
            measureChildren(i, i2);
            AppMethodBeat.o(92695);
            return;
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(92695);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(92696);
        super.onLayout(z, i, i2, i3, i4);
        refreshImage(false);
        AppMethodBeat.o(92696);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(92697);
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, onSaveInstanceState);
        bundle.putString(PROFILE_ID_KEY, this.profileId);
        bundle.putInt(PRESET_SIZE_KEY, this.presetSizeType);
        bundle.putBoolean(IS_CROPPED_KEY, this.isCropped);
        bundle.putInt(BITMAP_WIDTH_KEY, this.queryWidth);
        bundle.putInt(BITMAP_HEIGHT_KEY, this.queryHeight);
        bundle.putBoolean(PENDING_REFRESH_KEY, this.lastRequest != null);
        AppMethodBeat.o(92697);
        return bundle;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(92698);
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(92698);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(SUPER_STATE_KEY));
        this.profileId = bundle.getString(PROFILE_ID_KEY);
        this.presetSizeType = bundle.getInt(PRESET_SIZE_KEY);
        this.isCropped = bundle.getBoolean(IS_CROPPED_KEY);
        this.queryWidth = bundle.getInt(BITMAP_WIDTH_KEY);
        this.queryHeight = bundle.getInt(BITMAP_HEIGHT_KEY);
        refreshImage(true);
        AppMethodBeat.o(92698);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(92699);
        super.onDetachedFromWindow();
        this.lastRequest = null;
        AppMethodBeat.o(92699);
    }

    private void initialize(Context context) {
        AppMethodBeat.i(92700);
        removeAllViews();
        this.image = new ImageView(context);
        this.image.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.image.setScaleType(ScaleType.CENTER_INSIDE);
        addView(this.image);
        AppMethodBeat.o(92700);
    }

    private void parseAttributes(AttributeSet attributeSet) {
        AppMethodBeat.i(92701);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_profile_picture_view);
        setPresetSize(obtainStyledAttributes.getInt(0, -1));
        this.isCropped = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(92701);
    }

    private void refreshImage(boolean z) {
        AppMethodBeat.i(92702);
        boolean updateImageQueryParameters = updateImageQueryParameters();
        if (this.profileId == null || this.profileId.length() == 0 || (this.queryWidth == 0 && this.queryHeight == 0)) {
            setBlankProfilePicture();
            AppMethodBeat.o(92702);
            return;
        }
        if (updateImageQueryParameters || z) {
            sendImageRequest(true);
        }
        AppMethodBeat.o(92702);
    }

    private void setBlankProfilePicture() {
        AppMethodBeat.i(92703);
        if (this.lastRequest != null) {
            ImageDownloader.cancelRequest(this.lastRequest);
        }
        if (this.customizedDefaultProfilePicture == null) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), isCropped() ? com.tencent.mm.R.drawable.a_b : com.tencent.mm.R.drawable.a_a));
            AppMethodBeat.o(92703);
            return;
        }
        updateImageQueryParameters();
        setImageBitmap(Bitmap.createScaledBitmap(this.customizedDefaultProfilePicture, this.queryWidth, this.queryHeight, false));
        AppMethodBeat.o(92703);
    }

    private void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(92704);
        if (!(this.image == null || bitmap == null)) {
            this.imageContents = bitmap;
            this.image.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(92704);
    }

    private void sendImageRequest(boolean z) {
        AppMethodBeat.i(92705);
        ImageRequest build = new Builder(getContext(), ImageRequest.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight)).setAllowCachedRedirects(z).setCallerTag(this).setCallback(new Callback() {
            public void onCompleted(ImageResponse imageResponse) {
                AppMethodBeat.i(92688);
                ProfilePictureView.access$000(ProfilePictureView.this, imageResponse);
                AppMethodBeat.o(92688);
            }
        }).build();
        if (this.lastRequest != null) {
            ImageDownloader.cancelRequest(this.lastRequest);
        }
        this.lastRequest = build;
        ImageDownloader.downloadAsync(build);
        AppMethodBeat.o(92705);
    }

    private void processResponse(ImageResponse imageResponse) {
        AppMethodBeat.i(92706);
        if (imageResponse.getRequest() == this.lastRequest) {
            this.lastRequest = null;
            Bitmap bitmap = imageResponse.getBitmap();
            Throwable error = imageResponse.getError();
            if (error != null) {
                OnErrorListener onErrorListener = this.onErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(new FacebookException("Error in downloading profile picture for profileId: " + getProfileId(), error));
                    AppMethodBeat.o(92706);
                    return;
                }
                Logger.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
                AppMethodBeat.o(92706);
                return;
            } else if (bitmap != null) {
                setImageBitmap(bitmap);
                if (imageResponse.isCachedRedirect()) {
                    sendImageRequest(false);
                }
            }
        }
        AppMethodBeat.o(92706);
    }

    private boolean updateImageQueryParameters() {
        boolean z = false;
        AppMethodBeat.i(92707);
        int height = getHeight();
        int width = getWidth();
        if (width <= 0 || height <= 0) {
            AppMethodBeat.o(92707);
        } else {
            int presetSizeInPixels = getPresetSizeInPixels(false);
            if (presetSizeInPixels != 0) {
                width = presetSizeInPixels;
                height = presetSizeInPixels;
            }
            boolean z2;
            if (width <= height) {
                if (isCropped()) {
                    presetSizeInPixels = width;
                } else {
                    z2 = false;
                }
                height = presetSizeInPixels;
            } else {
                if (isCropped()) {
                    presetSizeInPixels = height;
                } else {
                    z2 = false;
                }
                width = presetSizeInPixels;
            }
            if (!(width == this.queryWidth && height == this.queryHeight)) {
                z = true;
            }
            this.queryWidth = width;
            this.queryHeight = height;
            AppMethodBeat.o(92707);
        }
        return z;
    }

    private int getPresetSizeInPixels(boolean z) {
        int i = com.tencent.mm.R.dimen.xt;
        AppMethodBeat.i(92708);
        switch (this.presetSizeType) {
            case -4:
                i = com.tencent.mm.R.dimen.xs;
                break;
            case -3:
                break;
            case -2:
                i = com.tencent.mm.R.dimen.xu;
                break;
            case -1:
                if (!z) {
                    AppMethodBeat.o(92708);
                    return 0;
                }
                break;
            default:
                AppMethodBeat.o(92708);
                return 0;
        }
        i = getResources().getDimensionPixelSize(i);
        AppMethodBeat.o(92708);
        return i;
    }
}
