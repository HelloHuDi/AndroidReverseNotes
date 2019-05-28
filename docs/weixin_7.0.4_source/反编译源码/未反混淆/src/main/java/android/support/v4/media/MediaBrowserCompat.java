package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

public final class MediaBrowserCompat {
    static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
    public final d HJ;

    static class SearchResultReceiver extends ResultReceiver {
        public final void onReceiveResult(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null && bundle.containsKey("search_results")) {
                Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
                if (parcelableArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Parcelable parcelable : parcelableArray) {
                        arrayList.add((MediaItem) parcelable);
                    }
                }
            }
        }
    }

    static class e implements a, d, i {
        protected final Object HQ;
        protected final Bundle HR;
        protected final a HS = new a(this);
        private final android.support.v4.f.a<String, k> HT = new android.support.v4.f.a();
        protected int HU;
        protected j HV;
        protected Messenger HW;
        private Token HX;
        final Context mContext;

        e(Context context, ComponentName componentName, b bVar) {
            this.mContext = context;
            Bundle bundle = new Bundle();
            bundle.putInt("extra_client_version", 1);
            this.HR = new Bundle(bundle);
            bVar.HN = this;
            this.HQ = new MediaBrowser(context, componentName, (ConnectionCallback) bVar.HM, this.HR);
        }

        public final void connect() {
            ((MediaBrowser) this.HQ).connect();
        }

        public final void disconnect() {
            if (!(this.HV == null || this.HW == null)) {
                try {
                    this.HV.a(7, null, this.HW);
                } catch (RemoteException e) {
                }
            }
            ((MediaBrowser) this.HQ).disconnect();
        }

        public final Token dH() {
            if (this.HX == null) {
                this.HX = Token.z(((MediaBrowser) this.HQ).getSessionToken());
            }
            return this.HX;
        }

        public final void onConnected() {
            Bundle extras = ((MediaBrowser) this.HQ).getExtras();
            if (extras != null) {
                this.HU = extras.getInt("extra_service_version", 0);
                IBinder c = android.support.v4.app.e.c(extras, "extra_messenger");
                if (c != null) {
                    this.HV = new j(c, this.HR);
                    this.HW = new Messenger(this.HS);
                    this.HS.a(this.HW);
                    try {
                        j jVar = this.HV;
                        Messenger messenger = this.HW;
                        Bundle bundle = new Bundle();
                        bundle.putBundle("data_root_hints", jVar.HR);
                        jVar.a(6, bundle, messenger);
                    } catch (RemoteException e) {
                    }
                }
                android.support.v4.media.session.b d = android.support.v4.media.session.b.a.d(android.support.v4.app.e.c(extras, "extra_session_binder"));
                if (d != null) {
                    this.HX = Token.a(((MediaBrowser) this.HQ).getSessionToken(), d);
                }
            }
        }

        public final void onConnectionSuspended() {
            this.HV = null;
            this.HW = null;
            this.HX = null;
            this.HS.a(null);
        }

        public final void a(Messenger messenger, String str, Token token, Bundle bundle) {
        }

        public final void b(Messenger messenger) {
        }

        public final void a(Messenger messenger, String str, Bundle bundle) {
            if (this.HW == messenger) {
                k kVar = (k) this.HT.get(str);
                if (kVar == null) {
                    boolean z = MediaBrowserCompat.DEBUG;
                } else {
                    kVar.c(this.mContext, bundle);
                }
            }
        }
    }

    static class g extends f {
        g(Context context, ComponentName componentName, b bVar) {
            super(context, componentName, bVar);
        }
    }

    static class h implements d, i {
        final Bundle HR;
        final a HS = new a(this);
        private final android.support.v4.f.a<String, k> HT = new android.support.v4.f.a();
        j HV;
        Messenger HW;
        private Token HX;
        final ComponentName HY;
        final b HZ;
        a Ia;
        private String Ib;
        final Context mContext;
        private Bundle mExtras;
        int mState = 1;

        class a implements ServiceConnection {
            a() {
            }

            public final void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                e(new Runnable() {
                    public final void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            new StringBuilder("MediaServiceConnection.onServiceConnected name=").append(componentName).append(" binder=").append(iBinder);
                            h.this.dump();
                        }
                        if (a.this.N("onServiceConnected")) {
                            h.this.HV = new j(iBinder, h.this.HR);
                            h.this.HW = new Messenger(h.this.HS);
                            h.this.HS.a(h.this.HW);
                            h.this.mState = 2;
                            try {
                                if (MediaBrowserCompat.DEBUG) {
                                    h.this.dump();
                                }
                                j jVar = h.this.HV;
                                Context context = h.this.mContext;
                                Messenger messenger = h.this.HW;
                                Bundle bundle = new Bundle();
                                bundle.putString("data_package_name", context.getPackageName());
                                bundle.putBundle("data_root_hints", jVar.HR);
                                jVar.a(1, bundle, messenger);
                            } catch (RemoteException e) {
                                new StringBuilder("RemoteException during connect for ").append(h.this.HY);
                                if (MediaBrowserCompat.DEBUG) {
                                    h.this.dump();
                                }
                            }
                        }
                    }
                });
            }

            public final void onServiceDisconnected(final ComponentName componentName) {
                e(new Runnable() {
                    public final void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            new StringBuilder("MediaServiceConnection.onServiceDisconnected name=").append(componentName).append(" this=").append(this).append(" mServiceConnection=").append(h.this.Ia);
                            h.this.dump();
                        }
                        if (a.this.N("onServiceDisconnected")) {
                            h.this.HV = null;
                            h.this.HW = null;
                            h.this.HS.a(null);
                            h.this.mState = 4;
                            h.this.HZ.onConnectionSuspended();
                        }
                    }
                });
            }

            private void e(Runnable runnable) {
                if (Thread.currentThread() == h.this.HS.getLooper().getThread()) {
                    runnable.run();
                } else {
                    h.this.HS.post(runnable);
                }
            }

            /* Access modifiers changed, original: final */
            public final boolean N(String str) {
                if (h.this.Ia == this && h.this.mState != 0 && h.this.mState != 1) {
                    return true;
                }
                if (!(h.this.mState == 0 || h.this.mState == 1)) {
                    new StringBuilder().append(str).append(" for ").append(h.this.HY).append(" with mServiceConnection=").append(h.this.Ia).append(" this=").append(this);
                }
                return false;
            }
        }

        public h(Context context, ComponentName componentName, b bVar) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (bVar == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            } else {
                this.mContext = context;
                this.HY = componentName;
                this.HZ = bVar;
                this.HR = null;
            }
        }

        public final void connect() {
            if (this.mState == 0 || this.mState == 1) {
                this.mState = 2;
                this.HS.post(new Runnable() {
                    public final void run() {
                        if (h.this.mState != 0) {
                            h.this.mState = 2;
                            if (MediaBrowserCompat.DEBUG && h.this.Ia != null) {
                                throw new RuntimeException("mServiceConnection should be null. Instead it is " + h.this.Ia);
                            } else if (h.this.HV != null) {
                                throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + h.this.HV);
                            } else if (h.this.HW != null) {
                                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + h.this.HW);
                            } else {
                                Intent intent = new Intent("android.media.browse.MediaBrowserService");
                                intent.setComponent(h.this.HY);
                                h.this.Ia = new a();
                                boolean z = false;
                                try {
                                    z = h.this.mContext.bindService(intent, h.this.Ia, 1);
                                } catch (Exception e) {
                                    new StringBuilder("Failed binding to service ").append(h.this.HY);
                                }
                                if (!z) {
                                    h.this.dI();
                                    h.this.HZ.onConnectionFailed();
                                }
                                if (MediaBrowserCompat.DEBUG) {
                                    h.this.dump();
                                }
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + av(this.mState) + ")");
        }

        public final void disconnect() {
            this.mState = 0;
            this.HS.post(new Runnable() {
                public final void run() {
                    if (h.this.HW != null) {
                        try {
                            h.this.HV.a(2, null, h.this.HW);
                        } catch (RemoteException e) {
                            new StringBuilder("RemoteException during connect for ").append(h.this.HY);
                        }
                    }
                    int i = h.this.mState;
                    h.this.dI();
                    if (i != 0) {
                        h.this.mState = i;
                    }
                    if (MediaBrowserCompat.DEBUG) {
                        h.this.dump();
                    }
                }
            });
        }

        /* Access modifiers changed, original: final */
        public final void dI() {
            if (this.Ia != null) {
                this.mContext.unbindService(this.Ia);
            }
            this.mState = 1;
            this.Ia = null;
            this.HV = null;
            this.HW = null;
            this.HS.a(null);
            this.Ib = null;
            this.HX = null;
        }

        public final void a(Messenger messenger, String str, Token token, Bundle bundle) {
            if (!a(messenger, "onConnect")) {
                return;
            }
            if (this.mState != 2) {
                new StringBuilder("onConnect from service while mState=").append(av(this.mState)).append("... ignoring");
                return;
            }
            this.Ib = str;
            this.HX = token;
            this.mExtras = bundle;
            this.mState = 3;
            if (MediaBrowserCompat.DEBUG) {
                dump();
            }
            this.HZ.onConnected();
            try {
                for (Entry entry : this.HT.entrySet()) {
                    String str2 = (String) entry.getKey();
                    k kVar = (k) entry.getValue();
                    List list = kVar.mO;
                    List list2 = kVar.Ii;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < list.size()) {
                            j jVar = this.HV;
                            IBinder iBinder = ((l) list.get(i2)).BN;
                            Bundle bundle2 = (Bundle) list2.get(i2);
                            Messenger messenger2 = this.HW;
                            Bundle bundle3 = new Bundle();
                            bundle3.putString("data_media_item_id", str2);
                            android.support.v4.app.e.a(bundle3, "data_callback_token", iBinder);
                            bundle3.putBundle("data_options", bundle2);
                            jVar.a(3, bundle3, messenger2);
                            i = i2 + 1;
                        }
                    }
                }
            } catch (RemoteException e) {
            }
        }

        public final void b(Messenger messenger) {
            new StringBuilder("onConnectFailed for ").append(this.HY);
            if (!a(messenger, "onConnectFailed")) {
                return;
            }
            if (this.mState != 2) {
                new StringBuilder("onConnect from service while mState=").append(av(this.mState)).append("... ignoring");
                return;
            }
            dI();
            this.HZ.onConnectionFailed();
        }

        public final void a(Messenger messenger, String str, Bundle bundle) {
            if (a(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.DEBUG) {
                    new StringBuilder("onLoadChildren for ").append(this.HY).append(" id=").append(str);
                }
                k kVar = (k) this.HT.get(str);
                if (kVar == null) {
                    boolean z = MediaBrowserCompat.DEBUG;
                } else {
                    kVar.c(this.mContext, bundle);
                }
            }
        }

        private static String av(int i) {
            switch (i) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTING";
                case 1:
                    return "CONNECT_STATE_DISCONNECTED";
                case 2:
                    return "CONNECT_STATE_CONNECTING";
                case 3:
                    return "CONNECT_STATE_CONNECTED";
                case 4:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    return "UNKNOWN/".concat(String.valueOf(i));
            }
        }

        private boolean a(Messenger messenger, String str) {
            if (this.HW == messenger && this.mState != 0 && this.mState != 1) {
                return true;
            }
            if (!(this.mState == 0 || this.mState == 1)) {
                new StringBuilder().append(str).append(" for ").append(this.HY).append(" with mCallbacksMessenger=").append(this.HW).append(" this=").append(this);
            }
            return false;
        }

        /* Access modifiers changed, original: final */
        public final void dump() {
            new StringBuilder("  mServiceComponent=").append(this.HY);
            new StringBuilder("  mCallback=").append(this.HZ);
            new StringBuilder("  mRootHints=").append(this.HR);
            new StringBuilder("  mState=").append(av(this.mState));
            new StringBuilder("  mServiceConnection=").append(this.Ia);
            new StringBuilder("  mServiceBinderWrapper=").append(this.HV);
            new StringBuilder("  mCallbacksMessenger=").append(this.HW);
            new StringBuilder("  mRootId=").append(this.Ib);
            new StringBuilder("  mMediaSessionToken=").append(this.HX);
        }

        public final Token dH() {
            Object obj;
            if (this.mState == 3) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return this.HX;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }
        };
        private final int Dj;
        private final MediaDescriptionCompat Ig;

        public static List<MediaItem> j(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object next : list) {
                Object obj;
                if (next == null || VERSION.SDK_INT < 21) {
                    obj = null;
                } else {
                    obj = new MediaItem(MediaDescriptionCompat.v(((android.media.browse.MediaBrowser.MediaItem) next).getDescription()), ((android.media.browse.MediaBrowser.MediaItem) next).getFlags());
                }
                arrayList.add(obj);
            }
            return arrayList;
        }

        private MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (TextUtils.isEmpty(mediaDescriptionCompat.IS)) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            } else {
                this.Dj = i;
                this.Ig = mediaDescriptionCompat;
            }
        }

        MediaItem(Parcel parcel) {
            this.Dj = parcel.readInt();
            this.Ig = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.Dj);
            this.Ig.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=").append(this.Dj);
            stringBuilder.append(", mDescription=").append(this.Ig);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static class f extends e {
        f(Context context, ComponentName componentName, b bVar) {
            super(context, componentName, bVar);
        }
    }

    interface i {
        void a(Messenger messenger, String str, Bundle bundle);

        void a(Messenger messenger, String str, Token token, Bundle bundle);

        void b(Messenger messenger);
    }

    static class CustomActionResultReceiver extends ResultReceiver {
        private final c HP;
        private final Bundle mExtras;

        public final void onReceiveResult(int i, Bundle bundle) {
            if (this.HP != null) {
                switch (i) {
                    case -1:
                    case 0:
                    case 1:
                        return;
                    default:
                        new StringBuilder("Unknown result code: ").append(i).append(" (extras=").append(this.mExtras).append(", resultData=").append(bundle).append(")");
                        return;
                }
            }
        }
    }

    static class a extends Handler {
        private final WeakReference<i> HK;
        private WeakReference<Messenger> HL;

        a(i iVar) {
            this.HK = new WeakReference(iVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(Message message) {
            if (this.HL != null && this.HL.get() != null && this.HK.get() != null) {
                Bundle data = message.getData();
                data.setClassLoader(MediaSessionCompat.class.getClassLoader());
                i iVar = (i) this.HK.get();
                Messenger messenger = (Messenger) this.HL.get();
                try {
                    switch (message.what) {
                        case 1:
                            iVar.a(messenger, data.getString("data_media_item_id"), (Token) data.getParcelable("data_media_session_token"), data.getBundle("data_root_hints"));
                            return;
                        case 2:
                            iVar.b(messenger);
                            return;
                        case 3:
                            String string = data.getString("data_media_item_id");
                            data.getParcelableArrayList("data_media_item_list");
                            iVar.a(messenger, string, data.getBundle("data_options"));
                            return;
                        default:
                            new StringBuilder("Unhandled message: ").append(message).append("\n  Client version: 1\n  Service version: ").append(message.arg1);
                            return;
                    }
                } catch (BadParcelableException e) {
                    if (message.what != 1) {
                    }
                }
                if (message.what != 1) {
                    iVar.b(messenger);
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final void a(Messenger messenger) {
            this.HL = new WeakReference(messenger);
        }
    }

    public static abstract class c {
    }

    static class j {
        Bundle HR;
        private Messenger Ih;

        public j(IBinder iBinder, Bundle bundle) {
            this.Ih = new Messenger(iBinder);
            this.HR = bundle;
        }

        /* Access modifiers changed, original: final */
        public final void a(int i, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.Ih.send(obtain);
        }
    }

    public static abstract class l {
        final IBinder BN = new Binder();
        private final Object Ij;
        WeakReference<k> Ik;

        class b extends a implements a {
            b() {
                super();
            }

            public final void l(List<?> list) {
                MediaItem.j(list);
            }
        }

        class a implements c {
            a() {
            }

            public final void k(List<?> list) {
                k kVar = l.this.Ik == null ? null : (k) l.this.Ik.get();
                if (kVar == null) {
                    MediaItem.j(list);
                    return;
                }
                List j = MediaItem.j(list);
                List list2 = kVar.mO;
                List list3 = kVar.Ii;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < list2.size()) {
                        Bundle bundle = (Bundle) list3.get(i2);
                        if (!(bundle == null || j == null)) {
                            int i3 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                            int i4 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                            if (i3 != -1 || i4 != -1) {
                                int i5 = i4 * i3;
                                i = i5 + i4;
                                if (i3 < 0 || i4 <= 0 || i5 >= j.size()) {
                                    List list4 = Collections.EMPTY_LIST;
                                } else {
                                    if (i > j.size()) {
                                        i = j.size();
                                    }
                                    j.subList(i5, i);
                                }
                            }
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public l() {
            if (VERSION.SDK_INT >= 26) {
                this.Ij = new b(new b());
            } else if (VERSION.SDK_INT >= 21) {
                this.Ij = new d(new a());
            } else {
                this.Ij = null;
            }
        }
    }

    static class ItemReceiver extends ResultReceiver {
        public final void onReceiveResult(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null && bundle.containsKey("media_item")) {
                bundle.getParcelable("media_item");
            }
        }
    }

    public static class b {
        final Object HM;
        a HN;

        class b implements a {
            b() {
            }

            public final void onConnected() {
                if (b.this.HN != null) {
                    b.this.HN.onConnected();
                }
                b.this.onConnected();
            }

            public final void onConnectionSuspended() {
                if (b.this.HN != null) {
                    b.this.HN.onConnectionSuspended();
                }
                b.this.onConnectionSuspended();
            }

            public final void onConnectionFailed() {
                b.this.onConnectionFailed();
            }
        }

        interface a {
            void onConnected();

            void onConnectionSuspended();
        }

        public b() {
            if (VERSION.SDK_INT >= 21) {
                this.HM = new b(new b());
            } else {
                this.HM = null;
            }
        }

        public void onConnected() {
        }

        public void onConnectionSuspended() {
        }

        public void onConnectionFailed() {
        }
    }

    public interface d {
        void connect();

        Token dH();

        void disconnect();
    }

    static class k {
        final List<Bundle> Ii = new ArrayList();
        final List<l> mO = new ArrayList();

        public final l c(Context context, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.Ii.size()) {
                    return null;
                }
                if (c.a((Bundle) this.Ii.get(i2), bundle)) {
                    return (l) this.mO.get(i2);
                }
                i = i2 + 1;
            }
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar) {
        if (VERSION.SDK_INT >= 26) {
            this.HJ = new g(context, componentName, bVar);
        } else if (VERSION.SDK_INT >= 23) {
            this.HJ = new f(context, componentName, bVar);
        } else if (VERSION.SDK_INT >= 21) {
            this.HJ = new e(context, componentName, bVar);
        } else {
            this.HJ = new h(context, componentName, bVar);
        }
    }

    public final void disconnect() {
        this.HJ.disconnect();
    }
}
