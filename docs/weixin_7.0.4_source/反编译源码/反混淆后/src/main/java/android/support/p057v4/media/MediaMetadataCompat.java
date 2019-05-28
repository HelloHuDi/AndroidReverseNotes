package android.support.p057v4.media;

import android.media.MediaMetadata;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p057v4.p065f.C6197a;

/* renamed from: android.support.v4.media.MediaMetadataCompat */
public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new C174451();
    /* renamed from: Ja */
    static final C6197a<String, Integer> f3917Ja;
    /* renamed from: Jb */
    private static final String[] f3918Jb = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    /* renamed from: Jc */
    private static final String[] f3919Jc = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    /* renamed from: Jd */
    private static final String[] f3920Jd = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
    /* renamed from: Je */
    private Object f3921Je;
    final Bundle mBundle;

    /* renamed from: android.support.v4.media.MediaMetadataCompat$1 */
    static class C174451 implements Creator<MediaMetadataCompat> {
        C174451() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }
    }

    static {
        C6197a c6197a = new C6197a();
        f3917Ja = c6197a;
        c6197a.put("android.media.metadata.TITLE", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.DURATION", Integer.valueOf(0));
        f3917Ja.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.WRITER", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.DATE", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.YEAR", Integer.valueOf(0));
        f3917Ja.put("android.media.metadata.GENRE", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        f3917Ja.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        f3917Ja.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        f3917Ja.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.ART", Integer.valueOf(2));
        f3917Ja.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        f3917Ja.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        f3917Ja.put("android.media.metadata.RATING", Integer.valueOf(3));
        f3917Ja.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        f3917Ja.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
        f3917Ja.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
        f3917Ja.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
        f3917Ja.put("android.media.metadata.DOWNLOAD_STATUS", Integer.valueOf(0));
    }

    MediaMetadataCompat(Parcel parcel) {
        this.mBundle = parcel.readBundle();
        this.mBundle.setClassLoader(MediaMetadataCompat.class.getClassLoader());
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mBundle);
    }

    /* renamed from: w */
    public static MediaMetadataCompat m27082w(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        ((MediaMetadata) obj).writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        mediaMetadataCompat.f3921Je = obj;
        return mediaMetadataCompat;
    }
}
