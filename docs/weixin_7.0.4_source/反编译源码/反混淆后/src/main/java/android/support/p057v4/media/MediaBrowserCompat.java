package android.support.p057v4.media;

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
import android.support.p057v4.app.C8377e;
import android.support.p057v4.media.C25355a.C25354d;
import android.support.p057v4.media.C25355a.C25356b;
import android.support.p057v4.media.C25355a.C25357a;
import android.support.p057v4.media.C25355a.C8397c;
import android.support.p057v4.media.C8398b.C0420a;
import android.support.p057v4.media.C8398b.C8399b;
import android.support.p057v4.media.session.C25360b;
import android.support.p057v4.media.session.C25360b.C0424a;
import android.support.p057v4.media.session.MediaSessionCompat;
import android.support.p057v4.media.session.MediaSessionCompat.Token;
import android.support.p057v4.p065f.C6197a;
import android.support.p057v4.p066os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: android.support.v4.media.MediaBrowserCompat */
public final class MediaBrowserCompat {
    static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
    /* renamed from: HJ */
    public final C25348d f5152HJ;

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SearchResultReceiver */
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

    /* renamed from: android.support.v4.media.MediaBrowserCompat$e */
    static class C8388e implements C25347a, C25348d, C25338i {
        /* renamed from: HQ */
        protected final Object f2348HQ;
        /* renamed from: HR */
        protected final Bundle f2349HR;
        /* renamed from: HS */
        protected final C25339a f2350HS = new C25339a(this);
        /* renamed from: HT */
        private final C6197a<String, C25349k> f2351HT = new C6197a();
        /* renamed from: HU */
        protected int f2352HU;
        /* renamed from: HV */
        protected C25341j f2353HV;
        /* renamed from: HW */
        protected Messenger f2354HW;
        /* renamed from: HX */
        private Token f2355HX;
        final Context mContext;

        C8388e(Context context, ComponentName componentName, C25345b c25345b) {
            this.mContext = context;
            Bundle bundle = new Bundle();
            bundle.putInt("extra_client_version", 1);
            this.f2349HR = new Bundle(bundle);
            c25345b.f5164HN = this;
            this.f2348HQ = new MediaBrowser(context, componentName, (ConnectionCallback) c25345b.f5163HM, this.f2349HR);
        }

        public final void connect() {
            ((MediaBrowser) this.f2348HQ).connect();
        }

        public final void disconnect() {
            if (!(this.f2353HV == null || this.f2354HW == null)) {
                try {
                    this.f2353HV.mo42307a(7, null, this.f2354HW);
                } catch (RemoteException e) {
                }
            }
            ((MediaBrowser) this.f2348HQ).disconnect();
        }

        /* renamed from: dH */
        public final Token mo18335dH() {
            if (this.f2355HX == null) {
                this.f2355HX = Token.m27085z(((MediaBrowser) this.f2348HQ).getSessionToken());
            }
            return this.f2355HX;
        }

        public final void onConnected() {
            Bundle extras = ((MediaBrowser) this.f2348HQ).getExtras();
            if (extras != null) {
                this.f2352HU = extras.getInt("extra_service_version", 0);
                IBinder c = C8377e.m14783c(extras, "extra_messenger");
                if (c != null) {
                    this.f2353HV = new C25341j(c, this.f2349HR);
                    this.f2354HW = new Messenger(this.f2350HS);
                    this.f2350HS.mo42305a(this.f2354HW);
                    try {
                        C25341j c25341j = this.f2353HV;
                        Messenger messenger = this.f2354HW;
                        Bundle bundle = new Bundle();
                        bundle.putBundle("data_root_hints", c25341j.f5156HR);
                        c25341j.mo42307a(6, bundle, messenger);
                    } catch (RemoteException e) {
                    }
                }
                C25360b d = C0424a.m730d(C8377e.m14783c(extras, "extra_session_binder"));
                if (d != null) {
                    this.f2355HX = Token.m27084a(((MediaBrowser) this.f2348HQ).getSessionToken(), d);
                }
            }
        }

        public final void onConnectionSuspended() {
            this.f2353HV = null;
            this.f2354HW = null;
            this.f2355HX = null;
            this.f2350HS.mo42305a(null);
        }

        /* renamed from: a */
        public final void mo18332a(Messenger messenger, String str, Token token, Bundle bundle) {
        }

        /* renamed from: b */
        public final void mo18333b(Messenger messenger) {
        }

        /* renamed from: a */
        public final void mo18331a(Messenger messenger, String str, Bundle bundle) {
            if (this.f2354HW == messenger) {
                C25349k c25349k = (C25349k) this.f2351HT.get(str);
                if (c25349k == null) {
                    boolean z = MediaBrowserCompat.DEBUG;
                } else {
                    c25349k.mo42311c(this.mContext, bundle);
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$g */
    static class C8389g extends C25337f {
        C8389g(Context context, ComponentName componentName, C25345b c25345b) {
            super(context, componentName, c25345b);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$h */
    static class C8391h implements C25348d, C25338i {
        /* renamed from: HR */
        final Bundle f2357HR;
        /* renamed from: HS */
        final C25339a f2358HS = new C25339a(this);
        /* renamed from: HT */
        private final C6197a<String, C25349k> f2359HT = new C6197a();
        /* renamed from: HV */
        C25341j f2360HV;
        /* renamed from: HW */
        Messenger f2361HW;
        /* renamed from: HX */
        private Token f2362HX;
        /* renamed from: HY */
        final ComponentName f2363HY;
        /* renamed from: HZ */
        final C25345b f2364HZ;
        /* renamed from: Ia */
        C8393a f2365Ia;
        /* renamed from: Ib */
        private String f2366Ib;
        final Context mContext;
        private Bundle mExtras;
        int mState = 1;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$h$2 */
        class C83902 implements Runnable {
            C83902() {
            }

            public final void run() {
                if (C8391h.this.f2361HW != null) {
                    try {
                        C8391h.this.f2360HV.mo42307a(2, null, C8391h.this.f2361HW);
                    } catch (RemoteException e) {
                        new StringBuilder("RemoteException during connect for ").append(C8391h.this.f2363HY);
                    }
                }
                int i = C8391h.this.mState;
                C8391h.this.mo18340dI();
                if (i != 0) {
                    C8391h.this.mState = i;
                }
                if (MediaBrowserCompat.DEBUG) {
                    C8391h.this.dump();
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$h$1 */
        class C83921 implements Runnable {
            C83921() {
            }

            public final void run() {
                if (C8391h.this.mState != 0) {
                    C8391h.this.mState = 2;
                    if (MediaBrowserCompat.DEBUG && C8391h.this.f2365Ia != null) {
                        throw new RuntimeException("mServiceConnection should be null. Instead it is " + C8391h.this.f2365Ia);
                    } else if (C8391h.this.f2360HV != null) {
                        throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + C8391h.this.f2360HV);
                    } else if (C8391h.this.f2361HW != null) {
                        throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + C8391h.this.f2361HW);
                    } else {
                        Intent intent = new Intent("android.media.browse.MediaBrowserService");
                        intent.setComponent(C8391h.this.f2363HY);
                        C8391h.this.f2365Ia = new C8393a();
                        boolean z = false;
                        try {
                            z = C8391h.this.mContext.bindService(intent, C8391h.this.f2365Ia, 1);
                        } catch (Exception e) {
                            new StringBuilder("Failed binding to service ").append(C8391h.this.f2363HY);
                        }
                        if (!z) {
                            C8391h.this.mo18340dI();
                            C8391h.this.f2364HZ.onConnectionFailed();
                        }
                        if (MediaBrowserCompat.DEBUG) {
                            C8391h.this.dump();
                        }
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$h$a */
        class C8393a implements ServiceConnection {
            C8393a() {
            }

            public final void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                m14807e(new Runnable() {
                    public final void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            new StringBuilder("MediaServiceConnection.onServiceConnected name=").append(componentName).append(" binder=").append(iBinder);
                            C8391h.this.dump();
                        }
                        if (C8393a.this.mo18343N("onServiceConnected")) {
                            C8391h.this.f2360HV = new C25341j(iBinder, C8391h.this.f2357HR);
                            C8391h.this.f2361HW = new Messenger(C8391h.this.f2358HS);
                            C8391h.this.f2358HS.mo42305a(C8391h.this.f2361HW);
                            C8391h.this.mState = 2;
                            try {
                                if (MediaBrowserCompat.DEBUG) {
                                    C8391h.this.dump();
                                }
                                C25341j c25341j = C8391h.this.f2360HV;
                                Context context = C8391h.this.mContext;
                                Messenger messenger = C8391h.this.f2361HW;
                                Bundle bundle = new Bundle();
                                bundle.putString("data_package_name", context.getPackageName());
                                bundle.putBundle("data_root_hints", c25341j.f5156HR);
                                c25341j.mo42307a(1, bundle, messenger);
                            } catch (RemoteException e) {
                                new StringBuilder("RemoteException during connect for ").append(C8391h.this.f2363HY);
                                if (MediaBrowserCompat.DEBUG) {
                                    C8391h.this.dump();
                                }
                            }
                        }
                    }
                });
            }

            public final void onServiceDisconnected(final ComponentName componentName) {
                m14807e(new Runnable() {
                    public final void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            new StringBuilder("MediaServiceConnection.onServiceDisconnected name=").append(componentName).append(" this=").append(this).append(" mServiceConnection=").append(C8391h.this.f2365Ia);
                            C8391h.this.dump();
                        }
                        if (C8393a.this.mo18343N("onServiceDisconnected")) {
                            C8391h.this.f2360HV = null;
                            C8391h.this.f2361HW = null;
                            C8391h.this.f2358HS.mo42305a(null);
                            C8391h.this.mState = 4;
                            C8391h.this.f2364HZ.onConnectionSuspended();
                        }
                    }
                });
            }

            /* renamed from: e */
            private void m14807e(Runnable runnable) {
                if (Thread.currentThread() == C8391h.this.f2358HS.getLooper().getThread()) {
                    runnable.run();
                } else {
                    C8391h.this.f2358HS.post(runnable);
                }
            }

            /* Access modifiers changed, original: final */
            /* renamed from: N */
            public final boolean mo18343N(String str) {
                if (C8391h.this.f2365Ia == this && C8391h.this.mState != 0 && C8391h.this.mState != 1) {
                    return true;
                }
                if (!(C8391h.this.mState == 0 || C8391h.this.mState == 1)) {
                    new StringBuilder().append(str).append(" for ").append(C8391h.this.f2363HY).append(" with mServiceConnection=").append(C8391h.this.f2365Ia).append(" this=").append(this);
                }
                return false;
            }
        }

        public C8391h(Context context, ComponentName componentName, C25345b c25345b) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (c25345b == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            } else {
                this.mContext = context;
                this.f2363HY = componentName;
                this.f2364HZ = c25345b;
                this.f2357HR = null;
            }
        }

        public final void connect() {
            if (this.mState == 0 || this.mState == 1) {
                this.mState = 2;
                this.f2358HS.post(new C83921());
                return;
            }
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + C8391h.m14801av(this.mState) + ")");
        }

        public final void disconnect() {
            this.mState = 0;
            this.f2358HS.post(new C83902());
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dI */
        public final void mo18340dI() {
            if (this.f2365Ia != null) {
                this.mContext.unbindService(this.f2365Ia);
            }
            this.mState = 1;
            this.f2365Ia = null;
            this.f2360HV = null;
            this.f2361HW = null;
            this.f2358HS.mo42305a(null);
            this.f2366Ib = null;
            this.f2362HX = null;
        }

        /* renamed from: a */
        public final void mo18332a(Messenger messenger, String str, Token token, Bundle bundle) {
            if (!m14800a(messenger, "onConnect")) {
                return;
            }
            if (this.mState != 2) {
                new StringBuilder("onConnect from service while mState=").append(C8391h.m14801av(this.mState)).append("... ignoring");
                return;
            }
            this.f2366Ib = str;
            this.f2362HX = token;
            this.mExtras = bundle;
            this.mState = 3;
            if (MediaBrowserCompat.DEBUG) {
                dump();
            }
            this.f2364HZ.onConnected();
            try {
                for (Entry entry : this.f2359HT.entrySet()) {
                    String str2 = (String) entry.getKey();
                    C25349k c25349k = (C25349k) entry.getValue();
                    List list = c25349k.f5167mO;
                    List list2 = c25349k.f5166Ii;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < list.size()) {
                            C25341j c25341j = this.f2360HV;
                            IBinder iBinder = ((C25342l) list.get(i2)).f5158BN;
                            Bundle bundle2 = (Bundle) list2.get(i2);
                            Messenger messenger2 = this.f2361HW;
                            Bundle bundle3 = new Bundle();
                            bundle3.putString("data_media_item_id", str2);
                            C8377e.m14782a(bundle3, "data_callback_token", iBinder);
                            bundle3.putBundle("data_options", bundle2);
                            c25341j.mo42307a(3, bundle3, messenger2);
                            i = i2 + 1;
                        }
                    }
                }
            } catch (RemoteException e) {
            }
        }

        /* renamed from: b */
        public final void mo18333b(Messenger messenger) {
            new StringBuilder("onConnectFailed for ").append(this.f2363HY);
            if (!m14800a(messenger, "onConnectFailed")) {
                return;
            }
            if (this.mState != 2) {
                new StringBuilder("onConnect from service while mState=").append(C8391h.m14801av(this.mState)).append("... ignoring");
                return;
            }
            mo18340dI();
            this.f2364HZ.onConnectionFailed();
        }

        /* renamed from: a */
        public final void mo18331a(Messenger messenger, String str, Bundle bundle) {
            if (m14800a(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.DEBUG) {
                    new StringBuilder("onLoadChildren for ").append(this.f2363HY).append(" id=").append(str);
                }
                C25349k c25349k = (C25349k) this.f2359HT.get(str);
                if (c25349k == null) {
                    boolean z = MediaBrowserCompat.DEBUG;
                } else {
                    c25349k.mo42311c(this.mContext, bundle);
                }
            }
        }

        /* renamed from: av */
        private static String m14801av(int i) {
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

        /* renamed from: a */
        private boolean m14800a(Messenger messenger, String str) {
            if (this.f2361HW == messenger && this.mState != 0 && this.mState != 1) {
                return true;
            }
            if (!(this.mState == 0 || this.mState == 1)) {
                new StringBuilder().append(str).append(" for ").append(this.f2363HY).append(" with mCallbacksMessenger=").append(this.f2361HW).append(" this=").append(this);
            }
            return false;
        }

        /* Access modifiers changed, original: final */
        public final void dump() {
            new StringBuilder("  mServiceComponent=").append(this.f2363HY);
            new StringBuilder("  mCallback=").append(this.f2364HZ);
            new StringBuilder("  mRootHints=").append(this.f2357HR);
            new StringBuilder("  mState=").append(C8391h.m14801av(this.mState));
            new StringBuilder("  mServiceConnection=").append(this.f2365Ia);
            new StringBuilder("  mServiceBinderWrapper=").append(this.f2360HV);
            new StringBuilder("  mCallbacksMessenger=").append(this.f2361HW);
            new StringBuilder("  mRootId=").append(this.f2366Ib);
            new StringBuilder("  mMediaSessionToken=").append(this.f2362HX);
        }

        /* renamed from: dH */
        public final Token mo18335dH() {
            Object obj;
            if (this.mState == 3) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return this.f2362HX;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new C174391();
        /* renamed from: Dj */
        private final int f3898Dj;
        /* renamed from: Ig */
        private final MediaDescriptionCompat f3899Ig;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$1 */
        static class C174391 implements Creator<MediaItem> {
            C174391() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }
        }

        /* renamed from: j */
        public static List<MediaItem> m27078j(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object next : list) {
                Object obj;
                if (next == null || VERSION.SDK_INT < 21) {
                    obj = null;
                } else {
                    obj = new MediaItem(MediaDescriptionCompat.m72497v(((android.media.browse.MediaBrowser.MediaItem) next).getDescription()), ((android.media.browse.MediaBrowser.MediaItem) next).getFlags());
                }
                arrayList.add(obj);
            }
            return arrayList;
        }

        private MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (TextUtils.isEmpty(mediaDescriptionCompat.f16814IS)) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            } else {
                this.f3898Dj = i;
                this.f3899Ig = mediaDescriptionCompat;
            }
        }

        MediaItem(Parcel parcel) {
            this.f3898Dj = parcel.readInt();
            this.f3899Ig = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3898Dj);
            this.f3899Ig.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=").append(this.f3898Dj);
            stringBuilder.append(", mDescription=").append(this.f3899Ig);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$f */
    static class C25337f extends C8388e {
        C25337f(Context context, ComponentName componentName, C25345b c25345b) {
            super(context, componentName, c25345b);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$i */
    interface C25338i {
        /* renamed from: a */
        void mo18331a(Messenger messenger, String str, Bundle bundle);

        /* renamed from: a */
        void mo18332a(Messenger messenger, String str, Token token, Bundle bundle);

        /* renamed from: b */
        void mo18333b(Messenger messenger);
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver */
    static class CustomActionResultReceiver extends ResultReceiver {
        /* renamed from: HP */
        private final C25340c f5153HP;
        private final Bundle mExtras;

        public final void onReceiveResult(int i, Bundle bundle) {
            if (this.f5153HP != null) {
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

    /* renamed from: android.support.v4.media.MediaBrowserCompat$a */
    static class C25339a extends Handler {
        /* renamed from: HK */
        private final WeakReference<C25338i> f5154HK;
        /* renamed from: HL */
        private WeakReference<Messenger> f5155HL;

        C25339a(C25338i c25338i) {
            this.f5154HK = new WeakReference(c25338i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(Message message) {
            if (this.f5155HL != null && this.f5155HL.get() != null && this.f5154HK.get() != null) {
                Bundle data = message.getData();
                data.setClassLoader(MediaSessionCompat.class.getClassLoader());
                C25338i c25338i = (C25338i) this.f5154HK.get();
                Messenger messenger = (Messenger) this.f5155HL.get();
                try {
                    switch (message.what) {
                        case 1:
                            c25338i.mo18332a(messenger, data.getString("data_media_item_id"), (Token) data.getParcelable("data_media_session_token"), data.getBundle("data_root_hints"));
                            return;
                        case 2:
                            c25338i.mo18333b(messenger);
                            return;
                        case 3:
                            String string = data.getString("data_media_item_id");
                            data.getParcelableArrayList("data_media_item_list");
                            c25338i.mo18331a(messenger, string, data.getBundle("data_options"));
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
                    c25338i.mo18333b(messenger);
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo42305a(Messenger messenger) {
            this.f5155HL = new WeakReference(messenger);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$c */
    public static abstract class C25340c {
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$j */
    static class C25341j {
        /* renamed from: HR */
        Bundle f5156HR;
        /* renamed from: Ih */
        private Messenger f5157Ih;

        public C25341j(IBinder iBinder, Bundle bundle) {
            this.f5157Ih = new Messenger(iBinder);
            this.f5156HR = bundle;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo42307a(int i, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f5157Ih.send(obtain);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$l */
    public static abstract class C25342l {
        /* renamed from: BN */
        final IBinder f5158BN = new Binder();
        /* renamed from: Ij */
        private final Object f5159Ij;
        /* renamed from: Ik */
        WeakReference<C25349k> f5160Ik;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$l$b */
        class C25343b extends C25344a implements C0420a {
            C25343b() {
                super();
            }

            /* renamed from: l */
            public final void mo861l(List<?> list) {
                MediaItem.m27078j(list);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$l$a */
        class C25344a implements C8397c {
            C25344a() {
            }

            /* renamed from: k */
            public final void mo18348k(List<?> list) {
                C25349k c25349k = C25342l.this.f5160Ik == null ? null : (C25349k) C25342l.this.f5160Ik.get();
                if (c25349k == null) {
                    MediaItem.m27078j(list);
                    return;
                }
                List j = MediaItem.m27078j(list);
                List list2 = c25349k.f5167mO;
                List list3 = c25349k.f5166Ii;
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

        public C25342l() {
            if (VERSION.SDK_INT >= 26) {
                this.f5159Ij = new C8399b(new C25343b());
            } else if (VERSION.SDK_INT >= 21) {
                this.f5159Ij = new C25354d(new C25344a());
            } else {
                this.f5159Ij = null;
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemReceiver */
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

    /* renamed from: android.support.v4.media.MediaBrowserCompat$b */
    public static class C25345b {
        /* renamed from: HM */
        final Object f5163HM;
        /* renamed from: HN */
        C25347a f5164HN;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b */
        class C25346b implements C25357a {
            C25346b() {
            }

            public final void onConnected() {
                if (C25345b.this.f5164HN != null) {
                    C25345b.this.f5164HN.onConnected();
                }
                C25345b.this.onConnected();
            }

            public final void onConnectionSuspended() {
                if (C25345b.this.f5164HN != null) {
                    C25345b.this.f5164HN.onConnectionSuspended();
                }
                C25345b.this.onConnectionSuspended();
            }

            public final void onConnectionFailed() {
                C25345b.this.onConnectionFailed();
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$a */
        interface C25347a {
            void onConnected();

            void onConnectionSuspended();
        }

        public C25345b() {
            if (VERSION.SDK_INT >= 21) {
                this.f5163HM = new C25356b(new C25346b());
            } else {
                this.f5163HM = null;
            }
        }

        public void onConnected() {
        }

        public void onConnectionSuspended() {
        }

        public void onConnectionFailed() {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$d */
    public interface C25348d {
        void connect();

        /* renamed from: dH */
        Token mo18335dH();

        void disconnect();
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$k */
    static class C25349k {
        /* renamed from: Ii */
        final List<Bundle> f5166Ii = new ArrayList();
        /* renamed from: mO */
        final List<C25342l> f5167mO = new ArrayList();

        /* renamed from: c */
        public final C25342l mo42311c(Context context, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f5166Ii.size()) {
                    return null;
                }
                if (C17446c.m27083a((Bundle) this.f5166Ii.get(i2), bundle)) {
                    return (C25342l) this.f5167mO.get(i2);
                }
                i = i2 + 1;
            }
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, C25345b c25345b) {
        if (VERSION.SDK_INT >= 26) {
            this.f5152HJ = new C8389g(context, componentName, c25345b);
        } else if (VERSION.SDK_INT >= 23) {
            this.f5152HJ = new C25337f(context, componentName, c25345b);
        } else if (VERSION.SDK_INT >= 21) {
            this.f5152HJ = new C8388e(context, componentName, c25345b);
        } else {
            this.f5152HJ = new C8391h(context, componentName, c25345b);
        }
    }

    public final void disconnect() {
        this.f5152HJ.disconnect();
    }
}
