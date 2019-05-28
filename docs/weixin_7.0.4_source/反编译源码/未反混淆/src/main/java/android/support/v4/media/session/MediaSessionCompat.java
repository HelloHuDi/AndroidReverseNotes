package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new Creator<QueueItem>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new QueueItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }
        };
        private final MediaDescriptionCompat Ig;
        private final long JD;
        private Object JE;

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.Ig = mediaDescriptionCompat;
                this.JD = j;
                this.JE = obj;
            }
        }

        QueueItem(Parcel parcel) {
            this.Ig = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.JD = parcel.readLong();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.Ig.writeToParcel(parcel, i);
            parcel.writeLong(this.JD);
        }

        public final int describeContents() {
            return 0;
        }

        public static List<QueueItem> m(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                Object obj;
                if (next == null || VERSION.SDK_INT < 21) {
                    obj = null;
                } else {
                    obj = new QueueItem(next, MediaDescriptionCompat.v(((android.media.session.MediaSession.QueueItem) next).getDescription()), ((android.media.session.MediaSession.QueueItem) next).getQueueId());
                }
                arrayList.add(obj);
            }
            return arrayList;
        }

        public final String toString() {
            return "MediaSession.QueueItem {Description=" + this.Ig + ", Id=" + this.JD + " }";
        }
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new Creator<Token>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Token[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                Object readParcelable;
                if (VERSION.SDK_INT >= 21) {
                    readParcelable = parcel.readParcelable(null);
                } else {
                    readParcelable = parcel.readStrongBinder();
                }
                return new Token(readParcelable);
            }
        };
        final Object JG;
        final b Jt;

        Token(Object obj) {
            this(obj, null);
        }

        private Token(Object obj, b bVar) {
            this.JG = obj;
            this.Jt = bVar;
        }

        public static Token z(Object obj) {
            return a(obj, null);
        }

        public static Token a(Object obj, b bVar) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(d.A(obj), bVar);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.JG, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.JG);
            }
        }

        public final int hashCode() {
            if (this.JG == null) {
                return 0;
            }
            return this.JG.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.JG == null) {
                if (token.JG != null) {
                    return false;
                }
                return true;
            } else if (token.JG == null) {
                return false;
            } else {
                return this.JG.equals(token.JG);
            }
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new Creator<ResultReceiverWrapper>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }
        };
        private ResultReceiver JF;

        ResultReceiverWrapper(Parcel parcel) {
            this.JF = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.JF.writeToParcel(parcel, i);
        }
    }
}
