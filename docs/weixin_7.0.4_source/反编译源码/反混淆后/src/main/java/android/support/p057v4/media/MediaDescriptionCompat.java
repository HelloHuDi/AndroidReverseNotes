package android.support.p057v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new C253531();
    /* renamed from: IS */
    final String f16814IS;
    /* renamed from: IT */
    private final CharSequence f16815IT;
    /* renamed from: IU */
    private final CharSequence f16816IU;
    /* renamed from: IV */
    private final CharSequence f16817IV;
    /* renamed from: IW */
    private final Bitmap f16818IW;
    /* renamed from: IX */
    private final Uri f16819IX;
    /* renamed from: IY */
    private final Uri f16820IY;
    /* renamed from: IZ */
    private Object f16821IZ;
    private final Bundle mExtras;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$1 */
    static class C253531 implements Creator<MediaDescriptionCompat> {
        C253531() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.m72497v(MediaDescription.CREATOR.createFromParcel(parcel));
        }
    }

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$a */
    public static final class C41511a {
        /* renamed from: IS */
        String f16807IS;
        /* renamed from: IT */
        CharSequence f16808IT;
        /* renamed from: IU */
        CharSequence f16809IU;
        /* renamed from: IV */
        CharSequence f16810IV;
        /* renamed from: IW */
        Bitmap f16811IW;
        /* renamed from: IX */
        Uri f16812IX;
        /* renamed from: IY */
        Uri f16813IY;
        Bundle mExtras;
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f16814IS = str;
        this.f16815IT = charSequence;
        this.f16816IU = charSequence2;
        this.f16817IV = charSequence3;
        this.f16818IW = bitmap;
        this.f16819IX = uri;
        this.mExtras = bundle;
        this.f16820IY = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f16814IS = parcel.readString();
        this.f16815IT = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f16816IU = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f16817IV = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f16818IW = (Bitmap) parcel.readParcelable(null);
        this.f16819IX = (Uri) parcel.readParcelable(null);
        this.mExtras = parcel.readBundle();
        this.f16820IY = (Uri) parcel.readParcelable(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f16814IS);
            TextUtils.writeToParcel(this.f16815IT, parcel, i);
            TextUtils.writeToParcel(this.f16816IU, parcel, i);
            TextUtils.writeToParcel(this.f16817IV, parcel, i);
            parcel.writeParcelable(this.f16818IW, i);
            parcel.writeParcelable(this.f16819IX, i);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.f16820IY, i);
            return;
        }
        Object obj;
        if (this.f16821IZ != null || VERSION.SDK_INT < 21) {
            obj = this.f16821IZ;
        } else {
            Bundle bundle;
            Builder builder = new Builder();
            builder.setMediaId(this.f16814IS);
            builder.setTitle(this.f16815IT);
            builder.setSubtitle(this.f16816IU);
            builder.setDescription(this.f16817IV);
            builder.setIconBitmap(this.f16818IW);
            builder.setIconUri(this.f16819IX);
            Bundle bundle2 = this.mExtras;
            if (VERSION.SDK_INT >= 23 || this.f16820IY == null) {
                bundle = bundle2;
            } else {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle2.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f16820IY);
                bundle = bundle2;
            }
            builder.setExtras(bundle);
            if (VERSION.SDK_INT >= 23) {
                builder.setMediaUri(this.f16820IY);
            }
            this.f16821IZ = builder.build();
            obj = this.f16821IZ;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public final String toString() {
        return this.f16815IT + ", " + this.f16816IU + ", " + this.f16817IV;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: v */
    public static MediaDescriptionCompat m72497v(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        MediaDescriptionCompat mediaDescriptionCompat;
        C41511a c41511a = new C41511a();
        c41511a.f16807IS = ((MediaDescription) obj).getMediaId();
        c41511a.f16808IT = ((MediaDescription) obj).getTitle();
        c41511a.f16809IU = ((MediaDescription) obj).getSubtitle();
        c41511a.f16810IV = ((MediaDescription) obj).getDescription();
        c41511a.f16811IW = ((MediaDescription) obj).getIconBitmap();
        c41511a.f16812IX = ((MediaDescription) obj).getIconUri();
        Bundle extras = ((MediaDescription) obj).getExtras();
        if (extras == null) {
            uri = null;
        } else {
            uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                bundle = null;
                c41511a.mExtras = bundle;
                if (uri == null) {
                    c41511a.f16813IY = uri;
                } else if (VERSION.SDK_INT >= 23) {
                    c41511a.f16813IY = ((MediaDescription) obj).getMediaUri();
                }
                mediaDescriptionCompat = new MediaDescriptionCompat(c41511a.f16807IS, c41511a.f16808IT, c41511a.f16809IU, c41511a.f16810IV, c41511a.f16811IW, c41511a.f16812IX, c41511a.mExtras, c41511a.f16813IY);
                mediaDescriptionCompat.f16821IZ = obj;
                return mediaDescriptionCompat;
            }
            extras.remove("android.support.v4.media.description.MEDIA_URI");
            extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = extras;
        c41511a.mExtras = bundle;
        if (uri == null) {
        }
        mediaDescriptionCompat = new MediaDescriptionCompat(c41511a.f16807IS, c41511a.f16808IT, c41511a.f16809IU, c41511a.f16810IV, c41511a.f16811IW, c41511a.f16812IX, c41511a.mExtras, c41511a.f16813IY);
        mediaDescriptionCompat.f16821IZ = obj;
        return mediaDescriptionCompat;
    }
}
