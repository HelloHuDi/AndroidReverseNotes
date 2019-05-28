package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class ImageRequest {
    private static final String HEIGHT_PARAM = "height";
    private static final String MIGRATION_PARAM = "migration_overrides";
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    private static final String PATH = "%s/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;
    private static final String WIDTH_PARAM = "width";
    private boolean allowCachedRedirects;
    private Callback callback;
    private Object callerTag;
    private Context context;
    private Uri imageUri;

    public static class Builder {
        private boolean allowCachedRedirects;
        private Callback callback;
        private Object callerTag;
        private Context context;
        private Uri imageUrl;

        public Builder(Context context, Uri uri) {
            AppMethodBeat.i(72388);
            Validate.notNull(uri, "imageUri");
            this.context = context;
            this.imageUrl = uri;
            AppMethodBeat.o(72388);
        }

        public Builder setCallback(Callback callback) {
            this.callback = callback;
            return this;
        }

        public Builder setCallerTag(Object obj) {
            this.callerTag = obj;
            return this;
        }

        public Builder setAllowCachedRedirects(boolean z) {
            this.allowCachedRedirects = z;
            return this;
        }

        public ImageRequest build() {
            AppMethodBeat.i(72389);
            ImageRequest imageRequest = new ImageRequest(this);
            AppMethodBeat.o(72389);
            return imageRequest;
        }
    }

    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    public static Uri getProfilePictureUri(String str, int i, int i2) {
        AppMethodBeat.i(72390);
        Validate.notNullOrEmpty(str, "userId");
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (max == 0 && max2 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Either width or height must be greater than 0");
            AppMethodBeat.o(72390);
            throw illegalArgumentException;
        }
        android.net.Uri.Builder path = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon().path(String.format(Locale.US, PATH, new Object[]{FacebookSdk.getGraphApiVersion(), str}));
        if (max2 != 0) {
            path.appendQueryParameter("height", String.valueOf(max2));
        }
        if (max != 0) {
            path.appendQueryParameter("width", String.valueOf(max));
        }
        path.appendQueryParameter(MIGRATION_PARAM, MIGRATION_VALUE);
        Uri build = path.build();
        AppMethodBeat.o(72390);
        return build;
    }

    private ImageRequest(Builder builder) {
        AppMethodBeat.i(72391);
        this.context = builder.context;
        this.imageUri = builder.imageUrl;
        this.callback = builder.callback;
        this.allowCachedRedirects = builder.allowCachedRedirects;
        this.callerTag = builder.callerTag == null ? new Object() : builder.callerTag;
        AppMethodBeat.o(72391);
    }

    public Context getContext() {
        return this.context;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public Callback getCallback() {
        return this.callback;
    }

    public boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    public Object getCallerTag() {
        return this.callerTag;
    }
}
