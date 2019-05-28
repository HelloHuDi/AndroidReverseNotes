package android.support.p057v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.p057v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaSessionCompat */
public class MediaSessionCompat {

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem */
    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new C84101();
        /* renamed from: Ig */
        private final MediaDescriptionCompat f2393Ig;
        /* renamed from: JD */
        private final long f2394JD;
        /* renamed from: JE */
        private Object f2395JE;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$1 */
        static class C84101 implements Creator<QueueItem> {
            C84101() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new QueueItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.f2393Ig = mediaDescriptionCompat;
                this.f2394JD = j;
                this.f2395JE = obj;
            }
        }

        QueueItem(Parcel parcel) {
            this.f2393Ig = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f2394JD = parcel.readLong();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.f2393Ig.writeToParcel(parcel, i);
            parcel.writeLong(this.f2394JD);
        }

        public final int describeContents() {
            return 0;
        }

        /* renamed from: m */
        public static List<QueueItem> m14828m(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                Object obj;
                if (next == null || VERSION.SDK_INT < 21) {
                    obj = null;
                } else {
                    obj = new QueueItem(next, MediaDescriptionCompat.m72497v(((android.media.session.MediaSession.QueueItem) next).getDescription()), ((android.media.session.MediaSession.QueueItem) next).getQueueId());
                }
                arrayList.add(obj);
            }
            return arrayList;
        }

        public final String toString() {
            return "MediaSession.QueueItem {Description=" + this.f2393Ig + ", Id=" + this.f2394JD + " }";
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token */
    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new C174471();
        /* renamed from: JG */
        final Object f3922JG;
        /* renamed from: Jt */
        final C25360b f3923Jt;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token$1 */
        static class C174471 implements Creator<Token> {
            C174471() {
            }

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
        }

        Token(Object obj) {
            this(obj, null);
        }

        private Token(Object obj, C25360b c25360b) {
            this.f3922JG = obj;
            this.f3923Jt = c25360b;
        }

        /* renamed from: z */
        public static Token m27085z(Object obj) {
            return Token.m27084a(obj, null);
        }

        /* renamed from: a */
        public static Token m27084a(Object obj, C25360b c25360b) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(C8411d.m14829A(obj), c25360b);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f3922JG, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f3922JG);
            }
        }

        public final int hashCode() {
            if (this.f3922JG == null) {
                return 0;
            }
            return this.f3922JG.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.f3922JG == null) {
                if (token.f3922JG != null) {
                    return false;
                }
                return true;
            } else if (token.f3922JG == null) {
                return false;
            } else {
                return this.f3922JG.equals(token.f3922JG);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper */
    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new C371251();
        /* renamed from: JF */
        private ResultReceiver f15778JF;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1 */
        static class C371251 implements Creator<ResultReceiverWrapper> {
            C371251() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f15778JF = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.f15778JF.writeToParcel(parcel, i);
        }
    }
}
