package com.google.android.gms.common.images.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.gms.base.C25568R;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.images.ImageRequest.ImageViewImageRequest;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class LoadingImageView extends ImageView {
    public static final int ASPECT_RATIO_ADJUST_HEIGHT = 2;
    public static final int ASPECT_RATIO_ADJUST_NONE = 0;
    public static final int ASPECT_RATIO_ADJUST_WIDTH = 1;
    private static ImageManager zzqm;
    private OnImageLoadedListener mOnImageLoadedListener;
    private int mPostProcessingFlags;
    private boolean zzpl;
    private boolean zzpm;
    private Uri zzqn;
    private int zzqo;
    private boolean zzqp;
    private int zzqq;
    private ClipPathProvider zzqr;
    private int zzqs;
    private float zzqt;

    public interface ClipPathProvider {
        Path getClipPath(int i, int i2);
    }

    public LoadingImageView(Context context) {
        this(context, null, 0);
    }

    public LoadingImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(61282);
        this.zzqo = 0;
        this.zzpl = true;
        this.zzpm = false;
        this.zzqp = false;
        this.zzqq = 0;
        this.mPostProcessingFlags = 0;
        this.zzqs = 0;
        this.zzqt = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25568R.styleable.LoadingImageView);
        this.zzqs = obtainStyledAttributes.getInt(0, 0);
        this.zzqt = obtainStyledAttributes.getFloat(1, 1.0f);
        setCircleCropEnabled(obtainStyledAttributes.getBoolean(2, false));
        obtainStyledAttributes.recycle();
        AppMethodBeat.m2505o(61282);
    }

    private final void zzc(boolean z) {
        AppMethodBeat.m2504i(61295);
        if (this.mOnImageLoadedListener != null) {
            this.mOnImageLoadedListener.onImageLoaded(this.zzqn, null, z);
        }
        AppMethodBeat.m2505o(61295);
    }

    public final void clearAspectRatioAdjust() {
        AppMethodBeat.m2504i(61292);
        if (this.zzqs != 0) {
            this.zzqs = 0;
            requestLayout();
        }
        AppMethodBeat.m2505o(61292);
    }

    public final void clearImage() {
        AppMethodBeat.m2504i(61283);
        loadUri(null);
        this.zzqp = true;
        AppMethodBeat.m2505o(61283);
    }

    public final int getLoadedNoDataPlaceholderResId() {
        return this.zzqo;
    }

    public final Uri getLoadedUri() {
        return this.zzqn;
    }

    public final void loadUri(Uri uri) {
        AppMethodBeat.m2504i(61284);
        loadUri(uri, 0, true, false);
        AppMethodBeat.m2505o(61284);
    }

    public final void loadUri(Uri uri, int i) {
        AppMethodBeat.m2504i(61285);
        loadUri(uri, i, true, false);
        AppMethodBeat.m2505o(61285);
    }

    public final void loadUri(Uri uri, int i, boolean z) {
        AppMethodBeat.m2504i(61286);
        loadUri(uri, i, z, false);
        AppMethodBeat.m2505o(61286);
    }

    public final void loadUri(Uri uri, int i, boolean z, boolean z2) {
        boolean z3 = true;
        AppMethodBeat.m2504i(61287);
        boolean equals = uri != null ? uri.equals(this.zzqn) : this.zzqn == null;
        if (equals) {
            if (this.zzqn != null) {
                zzc(true);
                AppMethodBeat.m2505o(61287);
                return;
            } else if (this.zzqo == i) {
                zzc(false);
                AppMethodBeat.m2505o(61287);
                return;
            }
        }
        if (zzqm == null) {
            zzqm = ImageManager.create(getContext(), getContext().getApplicationContext().getPackageName().equals(GooglePlayServicesUtilLight.GOOGLE_PLAY_GAMES_PACKAGE));
        }
        if (!(this.zzpm || this.zzqp)) {
            z3 = false;
        }
        this.zzqp = false;
        ImageViewImageRequest imageViewImageRequest = new ImageViewImageRequest((ImageView) this, uri);
        imageViewImageRequest.setNoDataPlaceholder(i);
        imageViewImageRequest.setCrossFadeEnabled(this.zzpl);
        imageViewImageRequest.setCrossFadeAlwaysEnabled(z3);
        imageViewImageRequest.setLoadingPlaceholderEnabled(z);
        imageViewImageRequest.setPostProcessingFlags(this.mPostProcessingFlags);
        imageViewImageRequest.setOnImageLoadedListener(this.mOnImageLoadedListener);
        imageViewImageRequest.setUseNewDrawable(z2);
        zzqm.loadImage(imageViewImageRequest);
        AppMethodBeat.m2505o(61287);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(61294);
        if (this.zzqr != null) {
            canvas.clipPath(this.zzqr.getClipPath(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzqq != 0) {
            canvas.drawColor(this.zzqq);
        }
        AppMethodBeat.m2505o(61294);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3;
        AppMethodBeat.m2504i(61293);
        super.onMeasure(i, i2);
        switch (this.zzqs) {
            case 1:
                measuredHeight = getMeasuredHeight();
                i3 = (int) (((float) measuredHeight) * this.zzqt);
                break;
            case 2:
                i3 = getMeasuredWidth();
                measuredHeight = (int) (((float) i3) / this.zzqt);
                break;
            default:
                AppMethodBeat.m2505o(61293);
                return;
        }
        setMeasuredDimension(i3, measuredHeight);
        AppMethodBeat.m2505o(61293);
    }

    public final void setCircleCropEnabled(boolean z) {
        if (z) {
            this.mPostProcessingFlags |= 1;
        } else {
            this.mPostProcessingFlags &= -2;
        }
    }

    public final void setClipPathProvider(ClipPathProvider clipPathProvider) {
        AppMethodBeat.m2504i(61290);
        this.zzqr = clipPathProvider;
        if (!PlatformVersion.isAtLeastJellyBean()) {
            setLayerType(1, null);
        }
        AppMethodBeat.m2505o(61290);
    }

    public final void setCrossFadeAlwaysEnabled(boolean z) {
        this.zzpm = z;
    }

    public final void setCrossFadeEnabled(boolean z) {
        this.zzpl = z;
    }

    public final void setImageAspectRatioAdjust(int i, float f) {
        boolean z = true;
        AppMethodBeat.m2504i(61291);
        boolean z2 = i == 0 || i == 1 || i == 2;
        Asserts.checkState(z2);
        if (f <= 0.0f) {
            z = false;
        }
        Asserts.checkState(z);
        this.zzqs = i;
        this.zzqt = f;
        requestLayout();
        AppMethodBeat.m2505o(61291);
    }

    public final void setLoadedNoDataPlaceholderResId(int i) {
        this.zzqo = i;
    }

    public final void setLoadedUri(Uri uri) {
        this.zzqn = uri;
    }

    public final void setOnImageLoadedListener(OnImageLoadedListener onImageLoadedListener) {
        this.mOnImageLoadedListener = onImageLoadedListener;
    }

    public final void setTintColor(int i) {
        AppMethodBeat.m2504i(61289);
        this.zzqq = i;
        if (this.zzqq != 0) {
            setColorFilter(ColorFilters.COLOR_FILTER_BW);
        } else {
            setColorFilter(null);
        }
        invalidate();
        AppMethodBeat.m2505o(61289);
    }

    public final void setTintColorId(int i) {
        AppMethodBeat.m2504i(61288);
        int i2 = 0;
        if (i > 0) {
            Resources resources = getResources();
            if (resources != null) {
                i2 = resources.getColor(i);
            }
        }
        setTintColor(i2);
        AppMethodBeat.m2505o(61288);
    }
}
