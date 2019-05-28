package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.f.a;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new Creator<MediaMetadataCompat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }
    };
    static final a<String, Integer> Ja;
    private static final String[] Jb = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    private static final String[] Jc = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    private static final String[] Jd = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
    private Object Je;
    final Bundle mBundle;

    static {
        a aVar = new a();
        Ja = aVar;
        aVar.put("android.media.metadata.TITLE", Integer.valueOf(1));
        Ja.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        Ja.put("android.media.metadata.DURATION", Integer.valueOf(0));
        Ja.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        Ja.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        Ja.put("android.media.metadata.WRITER", Integer.valueOf(1));
        Ja.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        Ja.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        Ja.put("android.media.metadata.DATE", Integer.valueOf(1));
        Ja.put("android.media.metadata.YEAR", Integer.valueOf(0));
        Ja.put("android.media.metadata.GENRE", Integer.valueOf(1));
        Ja.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        Ja.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        Ja.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        Ja.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        Ja.put("android.media.metadata.ART", Integer.valueOf(2));
        Ja.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        Ja.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        Ja.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        Ja.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        Ja.put("android.media.metadata.RATING", Integer.valueOf(3));
        Ja.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        Ja.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        Ja.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        Ja.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        Ja.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        Ja.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        Ja.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
        Ja.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
        Ja.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
        Ja.put("android.media.metadata.DOWNLOAD_STATUS", Integer.valueOf(0));
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

    public static MediaMetadataCompat w(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        ((MediaMetadata) obj).writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        mediaMetadataCompat.Je = obj;
        return mediaMetadataCompat;
    }
}
