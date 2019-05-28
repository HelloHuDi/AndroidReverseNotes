package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new Creator<PlaybackStateCompat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }
    };
    final long JM;
    final float JN;
    final long JO;
    final CharSequence JP;
    final long JQ;
    List<CustomAction> JR;
    final long JS;
    private Object JT;
    final int mErrorCode;
    final Bundle mExtras;
    final long mPosition;
    final int mState;

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new Creator<CustomAction>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CustomAction[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }
        };
        private final String JU;
        private final CharSequence JV;
        private final int JW;
        private Object JX;
        private final Bundle mExtras;

        private CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.JU = str;
            this.JV = charSequence;
            this.JW = i;
            this.mExtras = bundle;
        }

        CustomAction(Parcel parcel) {
            this.JU = parcel.readString();
            this.JV = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.JW = parcel.readInt();
            this.mExtras = parcel.readBundle();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.JU);
            TextUtils.writeToParcel(this.JV, parcel, i);
            parcel.writeInt(this.JW);
            parcel.writeBundle(this.mExtras);
        }

        public final int describeContents() {
            return 0;
        }

        public static CustomAction C(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(((android.media.session.PlaybackState.CustomAction) obj).getAction(), ((android.media.session.PlaybackState.CustomAction) obj).getName(), ((android.media.session.PlaybackState.CustomAction) obj).getIcon(), ((android.media.session.PlaybackState.CustomAction) obj).getExtras());
            customAction.JX = obj;
            return customAction;
        }

        public final String toString() {
            return "Action:mName='" + this.JV + ", mIcon=" + this.JW + ", mExtras=" + this.mExtras;
        }
    }

    private PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.mState = i;
        this.mPosition = j;
        this.JM = j2;
        this.JN = f;
        this.JO = j3;
        this.mErrorCode = 0;
        this.JP = charSequence;
        this.JQ = j4;
        this.JR = new ArrayList(list);
        this.JS = j5;
        this.mExtras = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.mPosition = parcel.readLong();
        this.JN = parcel.readFloat();
        this.JQ = parcel.readLong();
        this.JM = parcel.readLong();
        this.JO = parcel.readLong();
        this.JP = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.JR = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.JS = parcel.readLong();
        this.mExtras = parcel.readBundle();
        this.mErrorCode = parcel.readInt();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.mState);
        stringBuilder.append(", position=").append(this.mPosition);
        stringBuilder.append(", buffered position=").append(this.JM);
        stringBuilder.append(", speed=").append(this.JN);
        stringBuilder.append(", updated=").append(this.JQ);
        stringBuilder.append(", actions=").append(this.JO);
        stringBuilder.append(", error code=").append(this.mErrorCode);
        stringBuilder.append(", error message=").append(this.JP);
        stringBuilder.append(", custom actions=").append(this.JR);
        stringBuilder.append(", active item id=").append(this.JS);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mPosition);
        parcel.writeFloat(this.JN);
        parcel.writeLong(this.JQ);
        parcel.writeLong(this.JM);
        parcel.writeLong(this.JO);
        TextUtils.writeToParcel(this.JP, parcel, i);
        parcel.writeTypedList(this.JR);
        parcel.writeLong(this.JS);
        parcel.writeBundle(this.mExtras);
        parcel.writeInt(this.mErrorCode);
    }

    public static PlaybackStateCompat B(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Bundle extras;
        List<Object> customActions = ((PlaybackState) obj).getCustomActions();
        List list = null;
        if (customActions != null) {
            list = new ArrayList(customActions.size());
            for (Object C : customActions) {
                list.add(CustomAction.C(C));
            }
        }
        if (VERSION.SDK_INT >= 22) {
            extras = ((PlaybackState) obj).getExtras();
        } else {
            extras = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(((PlaybackState) obj).getState(), ((PlaybackState) obj).getPosition(), ((PlaybackState) obj).getBufferedPosition(), ((PlaybackState) obj).getPlaybackSpeed(), ((PlaybackState) obj).getActions(), ((PlaybackState) obj).getErrorMessage(), ((PlaybackState) obj).getLastPositionUpdateTime(), list, ((PlaybackState) obj).getActiveQueueItemId(), extras);
        playbackStateCompat.JT = obj;
        return playbackStateCompat;
    }
}
