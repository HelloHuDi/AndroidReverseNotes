package android.support.p057v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new C253591();
    /* renamed from: JM */
    final long f5182JM;
    /* renamed from: JN */
    final float f5183JN;
    /* renamed from: JO */
    final long f5184JO;
    /* renamed from: JP */
    final CharSequence f5185JP;
    /* renamed from: JQ */
    final long f5186JQ;
    /* renamed from: JR */
    List<CustomAction> f5187JR;
    /* renamed from: JS */
    final long f5188JS;
    /* renamed from: JT */
    private Object f5189JT;
    final int mErrorCode;
    final Bundle mExtras;
    final long mPosition;
    final int mState;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$1 */
    static class C253591 implements Creator<PlaybackStateCompat> {
        C253591() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new C253581();
        /* renamed from: JU */
        private final String f5190JU;
        /* renamed from: JV */
        private final CharSequence f5191JV;
        /* renamed from: JW */
        private final int f5192JW;
        /* renamed from: JX */
        private Object f5193JX;
        private final Bundle mExtras;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$1 */
        static class C253581 implements Creator<CustomAction> {
            C253581() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CustomAction[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }
        }

        private CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f5190JU = str;
            this.f5191JV = charSequence;
            this.f5192JW = i;
            this.mExtras = bundle;
        }

        CustomAction(Parcel parcel) {
            this.f5190JU = parcel.readString();
            this.f5191JV = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f5192JW = parcel.readInt();
            this.mExtras = parcel.readBundle();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f5190JU);
            TextUtils.writeToParcel(this.f5191JV, parcel, i);
            parcel.writeInt(this.f5192JW);
            parcel.writeBundle(this.mExtras);
        }

        public final int describeContents() {
            return 0;
        }

        /* renamed from: C */
        public static CustomAction m39995C(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(((android.media.session.PlaybackState.CustomAction) obj).getAction(), ((android.media.session.PlaybackState.CustomAction) obj).getName(), ((android.media.session.PlaybackState.CustomAction) obj).getIcon(), ((android.media.session.PlaybackState.CustomAction) obj).getExtras());
            customAction.f5193JX = obj;
            return customAction;
        }

        public final String toString() {
            return "Action:mName='" + this.f5191JV + ", mIcon=" + this.f5192JW + ", mExtras=" + this.mExtras;
        }
    }

    private PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.mState = i;
        this.mPosition = j;
        this.f5182JM = j2;
        this.f5183JN = f;
        this.f5184JO = j3;
        this.mErrorCode = 0;
        this.f5185JP = charSequence;
        this.f5186JQ = j4;
        this.f5187JR = new ArrayList(list);
        this.f5188JS = j5;
        this.mExtras = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.mPosition = parcel.readLong();
        this.f5183JN = parcel.readFloat();
        this.f5186JQ = parcel.readLong();
        this.f5182JM = parcel.readLong();
        this.f5184JO = parcel.readLong();
        this.f5185JP = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f5187JR = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f5188JS = parcel.readLong();
        this.mExtras = parcel.readBundle();
        this.mErrorCode = parcel.readInt();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.mState);
        stringBuilder.append(", position=").append(this.mPosition);
        stringBuilder.append(", buffered position=").append(this.f5182JM);
        stringBuilder.append(", speed=").append(this.f5183JN);
        stringBuilder.append(", updated=").append(this.f5186JQ);
        stringBuilder.append(", actions=").append(this.f5184JO);
        stringBuilder.append(", error code=").append(this.mErrorCode);
        stringBuilder.append(", error message=").append(this.f5185JP);
        stringBuilder.append(", custom actions=").append(this.f5187JR);
        stringBuilder.append(", active item id=").append(this.f5188JS);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mPosition);
        parcel.writeFloat(this.f5183JN);
        parcel.writeLong(this.f5186JQ);
        parcel.writeLong(this.f5182JM);
        parcel.writeLong(this.f5184JO);
        TextUtils.writeToParcel(this.f5185JP, parcel, i);
        parcel.writeTypedList(this.f5187JR);
        parcel.writeLong(this.f5188JS);
        parcel.writeBundle(this.mExtras);
        parcel.writeInt(this.mErrorCode);
    }

    /* renamed from: B */
    public static PlaybackStateCompat m39994B(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Bundle extras;
        List<Object> customActions = ((PlaybackState) obj).getCustomActions();
        List list = null;
        if (customActions != null) {
            list = new ArrayList(customActions.size());
            for (Object C : customActions) {
                list.add(CustomAction.m39995C(C));
            }
        }
        if (VERSION.SDK_INT >= 22) {
            extras = ((PlaybackState) obj).getExtras();
        } else {
            extras = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(((PlaybackState) obj).getState(), ((PlaybackState) obj).getPosition(), ((PlaybackState) obj).getBufferedPosition(), ((PlaybackState) obj).getPlaybackSpeed(), ((PlaybackState) obj).getActions(), ((PlaybackState) obj).getErrorMessage(), ((PlaybackState) obj).getLastPositionUpdateTime(), list, ((PlaybackState) obj).getActiveQueueItemId(), extras);
        playbackStateCompat.f5189JT = obj;
        return playbackStateCompat;
    }
}
