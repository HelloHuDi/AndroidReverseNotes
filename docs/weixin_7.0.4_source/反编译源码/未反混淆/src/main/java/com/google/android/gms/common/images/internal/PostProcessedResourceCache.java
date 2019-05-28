package com.google.android.gms.common.images.internal;

import android.graphics.drawable.Drawable;
import android.support.v4.f.g;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PostProcessedResourceCache extends g<PostProcessedResource, Drawable> {

    public static final class PostProcessedResource {
        public final int postProcessingFlags;
        public final int resId;

        public PostProcessedResource(int i, int i2) {
            this.resId = i;
            this.postProcessingFlags = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof PostProcessedResource)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PostProcessedResource postProcessedResource = (PostProcessedResource) obj;
            return postProcessedResource.resId == this.resId && postProcessedResource.postProcessingFlags == this.postProcessingFlags;
        }

        public final int hashCode() {
            AppMethodBeat.i(61296);
            int hashCode = Objects.hashCode(Integer.valueOf(this.resId), Integer.valueOf(this.postProcessingFlags));
            AppMethodBeat.o(61296);
            return hashCode;
        }
    }

    public PostProcessedResourceCache() {
        super(10);
    }
}
