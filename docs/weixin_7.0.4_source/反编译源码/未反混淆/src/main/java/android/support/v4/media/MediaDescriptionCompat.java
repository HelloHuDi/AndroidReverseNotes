package android.support.v4.media;

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

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new Creator<MediaDescriptionCompat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.v(MediaDescription.CREATOR.createFromParcel(parcel));
        }
    };
    final String IS;
    private final CharSequence IT;
    private final CharSequence IU;
    private final CharSequence IV;
    private final Bitmap IW;
    private final Uri IX;
    private final Uri IY;
    private Object IZ;
    private final Bundle mExtras;

    public static final class a {
        String IS;
        CharSequence IT;
        CharSequence IU;
        CharSequence IV;
        Bitmap IW;
        Uri IX;
        Uri IY;
        Bundle mExtras;
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.IS = str;
        this.IT = charSequence;
        this.IU = charSequence2;
        this.IV = charSequence3;
        this.IW = bitmap;
        this.IX = uri;
        this.mExtras = bundle;
        this.IY = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.IS = parcel.readString();
        this.IT = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.IU = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.IV = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.IW = (Bitmap) parcel.readParcelable(null);
        this.IX = (Uri) parcel.readParcelable(null);
        this.mExtras = parcel.readBundle();
        this.IY = (Uri) parcel.readParcelable(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.IS);
            TextUtils.writeToParcel(this.IT, parcel, i);
            TextUtils.writeToParcel(this.IU, parcel, i);
            TextUtils.writeToParcel(this.IV, parcel, i);
            parcel.writeParcelable(this.IW, i);
            parcel.writeParcelable(this.IX, i);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.IY, i);
            return;
        }
        Object obj;
        if (this.IZ != null || VERSION.SDK_INT < 21) {
            obj = this.IZ;
        } else {
            Bundle bundle;
            Builder builder = new Builder();
            builder.setMediaId(this.IS);
            builder.setTitle(this.IT);
            builder.setSubtitle(this.IU);
            builder.setDescription(this.IV);
            builder.setIconBitmap(this.IW);
            builder.setIconUri(this.IX);
            Bundle bundle2 = this.mExtras;
            if (VERSION.SDK_INT >= 23 || this.IY == null) {
                bundle = bundle2;
            } else {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle2.putParcelable("android.support.v4.media.description.MEDIA_URI", this.IY);
                bundle = bundle2;
            }
            builder.setExtras(bundle);
            if (VERSION.SDK_INT >= 23) {
                builder.setMediaUri(this.IY);
            }
            this.IZ = builder.build();
            obj = this.IZ;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public final String toString() {
        return this.IT + ", " + this.IU + ", " + this.IV;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static MediaDescriptionCompat v(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        MediaDescriptionCompat mediaDescriptionCompat;
        a aVar = new a();
        aVar.IS = ((MediaDescription) obj).getMediaId();
        aVar.IT = ((MediaDescription) obj).getTitle();
        aVar.IU = ((MediaDescription) obj).getSubtitle();
        aVar.IV = ((MediaDescription) obj).getDescription();
        aVar.IW = ((MediaDescription) obj).getIconBitmap();
        aVar.IX = ((MediaDescription) obj).getIconUri();
        Bundle extras = ((MediaDescription) obj).getExtras();
        if (extras == null) {
            uri = null;
        } else {
            uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                bundle = null;
                aVar.mExtras = bundle;
                if (uri == null) {
                    aVar.IY = uri;
                } else if (VERSION.SDK_INT >= 23) {
                    aVar.IY = ((MediaDescription) obj).getMediaUri();
                }
                mediaDescriptionCompat = new MediaDescriptionCompat(aVar.IS, aVar.IT, aVar.IU, aVar.IV, aVar.IW, aVar.IX, aVar.mExtras, aVar.IY);
                mediaDescriptionCompat.IZ = obj;
                return mediaDescriptionCompat;
            }
            extras.remove("android.support.v4.media.description.MEDIA_URI");
            extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = extras;
        aVar.mExtras = bundle;
        if (uri == null) {
        }
        mediaDescriptionCompat = new MediaDescriptionCompat(aVar.IS, aVar.IT, aVar.IU, aVar.IV, aVar.IW, aVar.IX, aVar.mExtras, aVar.IY);
        mediaDescriptionCompat.IZ = obj;
        return mediaDescriptionCompat;
    }
}
