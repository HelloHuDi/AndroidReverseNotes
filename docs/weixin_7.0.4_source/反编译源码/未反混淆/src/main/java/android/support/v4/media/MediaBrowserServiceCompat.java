package android.support.v4.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.f.j;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
    final android.support.v4.f.a<IBinder, b> Io = new android.support.v4.f.a();
    b Ip;
    final g Iq = new g();
    Token Ir;

    public static final class a {
        final String Ib;
        final Bundle mExtras;
    }

    public static class c<T> {
        int Dj;
        final Object IC;
        private boolean IE;
        boolean IF;
        boolean IG;

        c(Object obj) {
            this.IC = obj;
        }

        public final void dN() {
            if (this.IF || this.IG) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.IC);
            }
            this.IF = true;
            dL();
        }

        /* Access modifiers changed, original: final */
        public final boolean isDone() {
            return this.IE || this.IF || this.IG;
        }

        /* Access modifiers changed, original: 0000 */
        public void dL() {
        }

        /* Access modifiers changed, original: 0000 */
        public void dM() {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.IC);
        }
    }

    class b implements DeathRecipient {
        HashMap<String, List<j<IBinder, Bundle>>> IA = new HashMap();
        String Iw;
        Bundle Ix;
        e Iy;
        a Iz;

        b() {
        }

        public final void binderDied() {
            MediaBrowserServiceCompat.this.Iq.post(new Runnable() {
                public final void run() {
                    MediaBrowserServiceCompat.this.Io.remove(b.this.Iy.asBinder());
                }
            });
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$3 */
    class AnonymousClass3 extends c<List<MediaItem>> {
        final /* synthetic */ ResultReceiver Iv;

        AnonymousClass3(Object obj, ResultReceiver resultReceiver) {
            this.Iv = resultReceiver;
            super(obj);
        }

        /* Access modifiers changed, original: final|synthetic */
        public final /* synthetic */ void dL() {
            this.Iv.send(-1, null);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$4 */
    class AnonymousClass4 extends c<Bundle> {
        final /* synthetic */ ResultReceiver Iv;

        AnonymousClass4(Object obj, ResultReceiver resultReceiver) {
            this.Iv = resultReceiver;
            super(obj);
        }

        /* Access modifiers changed, original: final */
        public final void dM() {
            this.Iv.send(-1, null);
        }

        /* Access modifiers changed, original: final|synthetic */
        public final /* synthetic */ void dL() {
            this.Iv.send(0, null);
        }
    }

    interface e {
        void a(String str, Token token, Bundle bundle);

        void a(String str, List<MediaItem> list, Bundle bundle);

        IBinder asBinder();

        void dO();
    }

    static class f implements e {
        final Messenger IQ;

        f(Messenger messenger) {
            this.IQ = messenger;
        }

        public final IBinder asBinder() {
            return this.IQ.getBinder();
        }

        public final void a(String str, Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            b(1, bundle2);
        }

        public final void dO() {
            b(2, null);
        }

        public final void a(String str, List<MediaItem> list, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putBundle("data_options", bundle);
            b(3, bundle2);
        }

        private void b(int i, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.IQ.send(obtain);
        }
    }

    final class g extends Handler {
        private final d IR = new d();

        g() {
        }

        public final void handleMessage(Message message) {
            Object obj = null;
            Bundle data = message.getData();
            d dVar;
            String string;
            Bundle bundle;
            f fVar;
            d dVar2;
            ResultReceiver resultReceiver;
            switch (message.what) {
                case 1:
                    dVar = this.IR;
                    string = data.getString("data_package_name");
                    int i = data.getInt("data_calling_uid");
                    bundle = data.getBundle("data_root_hints");
                    fVar = new f(message.replyTo);
                    MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                    if (string != null) {
                        String[] packagesForUid = mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i);
                        int length = packagesForUid.length;
                        int i2 = 0;
                        while (i2 < length) {
                            if (packagesForUid[i2].equals(string)) {
                                obj = 1;
                            } else {
                                i2++;
                            }
                        }
                    }
                    if (obj == null) {
                        throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + string);
                    }
                    MediaBrowserServiceCompat.this.Iq.e(new AnonymousClass1(fVar, string, bundle, i));
                    return;
                case 2:
                    dVar2 = this.IR;
                    MediaBrowserServiceCompat.this.Iq.e(new AnonymousClass2(new f(message.replyTo)));
                    return;
                case 3:
                    dVar = this.IR;
                    string = data.getString("data_media_item_id");
                    IBinder c = android.support.v4.app.e.c(data, "data_callback_token");
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaBrowserServiceCompat.this.Iq.e(new AnonymousClass3(new f(message.replyTo), string, c, bundle2));
                    return;
                case 4:
                    dVar2 = this.IR;
                    String string2 = data.getString("data_media_item_id");
                    IBinder c2 = android.support.v4.app.e.c(data, "data_callback_token");
                    MediaBrowserServiceCompat.this.Iq.e(new AnonymousClass4(new f(message.replyTo), string2, c2));
                    return;
                case 5:
                    dVar = this.IR;
                    string = data.getString("data_media_item_id");
                    ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    fVar = new f(message.replyTo);
                    if (!TextUtils.isEmpty(string) && resultReceiver2 != null) {
                        MediaBrowserServiceCompat.this.Iq.e(new AnonymousClass5(fVar, string, resultReceiver2));
                        return;
                    }
                    return;
                case 6:
                    dVar2 = this.IR;
                    MediaBrowserServiceCompat.this.Iq.e(new AnonymousClass6(new f(message.replyTo), data.getBundle("data_root_hints")));
                    return;
                case 7:
                    dVar2 = this.IR;
                    MediaBrowserServiceCompat.this.Iq.e(new AnonymousClass7(new f(message.replyTo)));
                    return;
                case 8:
                    dVar = this.IR;
                    string = data.getString("data_search_query");
                    bundle = data.getBundle("data_search_extras");
                    resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    fVar = new f(message.replyTo);
                    if (!TextUtils.isEmpty(string) && resultReceiver != null) {
                        MediaBrowserServiceCompat.this.Iq.e(new AnonymousClass8(fVar, string, bundle, resultReceiver));
                        return;
                    }
                    return;
                case 9:
                    dVar = this.IR;
                    string = data.getString("data_custom_action");
                    bundle = data.getBundle("data_custom_action_extras");
                    resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    fVar = new f(message.replyTo);
                    if (!TextUtils.isEmpty(string) && resultReceiver != null) {
                        MediaBrowserServiceCompat.this.Iq.e(new AnonymousClass9(fVar, string, bundle, resultReceiver));
                        return;
                    }
                    return;
                default:
                    new StringBuilder("Unhandled message: ").append(message).append("\n  Service version: 2\n  Client version: ").append(message.arg1);
                    return;
            }
        }

        public final boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }

        private void e(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$2 */
    class AnonymousClass2 extends c<MediaItem> {
        final /* synthetic */ ResultReceiver Iv;

        AnonymousClass2(Object obj, ResultReceiver resultReceiver) {
            this.Iv = resultReceiver;
            super(obj);
        }

        /* Access modifiers changed, original: final|synthetic */
        public final /* synthetic */ void dL() {
            if ((this.Dj & 2) != 0) {
                this.Iv.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", null);
            this.Iv.send(0, bundle);
        }
    }

    class d {

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ e IH;

            AnonymousClass2(e eVar) {
                this.IH = eVar;
            }

            public final void run() {
                b bVar = (b) MediaBrowserServiceCompat.this.Io.remove(this.IH.asBinder());
                if (bVar != null) {
                    bVar.Iy.asBinder().unlinkToDeath(bVar, 0);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ e IH;
            final /* synthetic */ IBinder IM;
            final /* synthetic */ String val$id;
            final /* synthetic */ Bundle val$options;

            AnonymousClass3(e eVar, String str, IBinder iBinder, Bundle bundle) {
                this.IH = eVar;
                this.val$id = str;
                this.IM = iBinder;
                this.val$options = bundle;
            }

            public final void run() {
                b bVar = (b) MediaBrowserServiceCompat.this.Io.get(this.IH.asBinder());
                if (bVar == null) {
                    new StringBuilder("addSubscription for callback that isn't registered id=").append(this.val$id);
                } else {
                    MediaBrowserServiceCompat.this.a(this.val$id, bVar, this.IM, this.val$options);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$4 */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ e IH;
            final /* synthetic */ IBinder IM;
            final /* synthetic */ String val$id;

            AnonymousClass4(e eVar, String str, IBinder iBinder) {
                this.IH = eVar;
                this.val$id = str;
                this.IM = iBinder;
            }

            public final void run() {
                b bVar = (b) MediaBrowserServiceCompat.this.Io.get(this.IH.asBinder());
                if (bVar == null) {
                    new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.val$id);
                } else if (!MediaBrowserServiceCompat.a(this.val$id, bVar, this.IM)) {
                    new StringBuilder("removeSubscription called for ").append(this.val$id).append(" which is not subscribed");
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$5 */
        class AnonymousClass5 implements Runnable {
            final /* synthetic */ e IH;
            final /* synthetic */ String IN;
            final /* synthetic */ ResultReceiver Iv;

            AnonymousClass5(e eVar, String str, ResultReceiver resultReceiver) {
                this.IH = eVar;
                this.IN = str;
                this.Iv = resultReceiver;
            }

            public final void run() {
                b bVar = (b) MediaBrowserServiceCompat.this.Io.get(this.IH.asBinder());
                if (bVar == null) {
                    new StringBuilder("getMediaItem for callback that isn't registered id=").append(this.IN);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                String str = this.IN;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, this.Iv);
                mediaBrowserServiceCompat.Ip = bVar;
                anonymousClass2.Dj = 2;
                anonymousClass2.dN();
                mediaBrowserServiceCompat.Ip = null;
                if (!anonymousClass2.isDone()) {
                    throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=".concat(String.valueOf(str)));
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ e IH;
            final /* synthetic */ String II;
            final /* synthetic */ Bundle IJ;
            final /* synthetic */ int IK;

            AnonymousClass1(e eVar, String str, Bundle bundle, int i) {
                this.IH = eVar;
                this.II = str;
                this.IJ = bundle;
                this.IK = i;
            }

            public final void run() {
                IBinder asBinder = this.IH.asBinder();
                MediaBrowserServiceCompat.this.Io.remove(asBinder);
                b bVar = new b();
                bVar.Iw = this.II;
                bVar.Ix = this.IJ;
                bVar.Iy = this.IH;
                bVar.Iz = MediaBrowserServiceCompat.this.dJ();
                if (bVar.Iz == null) {
                    new StringBuilder("No root for client ").append(this.II).append(" from service ").append(getClass().getName());
                    try {
                        this.IH.dO();
                        return;
                    } catch (RemoteException e) {
                        new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.II);
                        return;
                    }
                }
                try {
                    MediaBrowserServiceCompat.this.Io.put(asBinder, bVar);
                    asBinder.linkToDeath(bVar, 0);
                    if (MediaBrowserServiceCompat.this.Ir != null) {
                        this.IH.a(bVar.Iz.Ib, MediaBrowserServiceCompat.this.Ir, bVar.Iz.mExtras);
                    }
                } catch (RemoteException e2) {
                    new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.II);
                    MediaBrowserServiceCompat.this.Io.remove(asBinder);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$6 */
        class AnonymousClass6 implements Runnable {
            final /* synthetic */ e IH;
            final /* synthetic */ Bundle IJ;

            AnonymousClass6(e eVar, Bundle bundle) {
                this.IH = eVar;
                this.IJ = bundle;
            }

            public final void run() {
                IBinder asBinder = this.IH.asBinder();
                MediaBrowserServiceCompat.this.Io.remove(asBinder);
                b bVar = new b();
                bVar.Iy = this.IH;
                bVar.Ix = this.IJ;
                MediaBrowserServiceCompat.this.Io.put(asBinder, bVar);
                try {
                    asBinder.linkToDeath(bVar, 0);
                } catch (RemoteException e) {
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$7 */
        class AnonymousClass7 implements Runnable {
            final /* synthetic */ e IH;

            AnonymousClass7(e eVar) {
                this.IH = eVar;
            }

            public final void run() {
                IBinder asBinder = this.IH.asBinder();
                b bVar = (b) MediaBrowserServiceCompat.this.Io.remove(asBinder);
                if (bVar != null) {
                    asBinder.unlinkToDeath(bVar, 0);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$8 */
        class AnonymousClass8 implements Runnable {
            final /* synthetic */ e IH;
            final /* synthetic */ String IP;
            final /* synthetic */ ResultReceiver Iv;
            final /* synthetic */ Bundle val$extras;

            AnonymousClass8(e eVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.IH = eVar;
                this.IP = str;
                this.val$extras = bundle;
                this.Iv = resultReceiver;
            }

            public final void run() {
                b bVar = (b) MediaBrowserServiceCompat.this.Io.get(this.IH.asBinder());
                if (bVar == null) {
                    new StringBuilder("search for callback that isn't registered query=").append(this.IP);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                String str = this.IP;
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(str, this.Iv);
                mediaBrowserServiceCompat.Ip = bVar;
                anonymousClass3.Dj = 4;
                anonymousClass3.dN();
                mediaBrowserServiceCompat.Ip = null;
                if (!anonymousClass3.isDone()) {
                    throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=".concat(String.valueOf(str)));
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$9 */
        class AnonymousClass9 implements Runnable {
            final /* synthetic */ e IH;
            final /* synthetic */ ResultReceiver Iv;
            final /* synthetic */ String val$action;
            final /* synthetic */ Bundle val$extras;

            AnonymousClass9(e eVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.IH = eVar;
                this.val$action = str;
                this.val$extras = bundle;
                this.Iv = resultReceiver;
            }

            public final void run() {
                b bVar = (b) MediaBrowserServiceCompat.this.Io.get(this.IH.asBinder());
                if (bVar == null) {
                    new StringBuilder("sendCustomAction for callback that isn't registered action=").append(this.val$action).append(", extras=").append(this.val$extras);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                String str = this.val$action;
                Bundle bundle = this.val$extras;
                AnonymousClass4 anonymousClass4 = new AnonymousClass4(str, this.Iv);
                mediaBrowserServiceCompat.Ip = bVar;
                if (anonymousClass4.IF || anonymousClass4.IG) {
                    throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + anonymousClass4.IC);
                }
                anonymousClass4.IG = true;
                anonymousClass4.dM();
                mediaBrowserServiceCompat.Ip = null;
                if (!anonymousClass4.isDone()) {
                    throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
                }
            }
        }

        d() {
        }
    }

    public abstract a dJ();

    /* Access modifiers changed, original: final */
    public final void a(String str, b bVar, IBinder iBinder, Bundle bundle) {
        List list = (List) bVar.IA.get(str);
        List arrayList;
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        for (j jVar : arrayList) {
            if (iBinder == jVar.first && c.a(bundle, (Bundle) jVar.second)) {
                return;
            }
        }
        arrayList.add(new j(iBinder, bundle));
        bVar.IA.put(str, arrayList);
        final b bVar2 = bVar;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        AnonymousClass1 anonymousClass1 = new c<List<MediaItem>>(str) {
            /* Access modifiers changed, original: final|synthetic */
            public final /* synthetic */ void dL() {
                if (MediaBrowserServiceCompat.this.Io.get(bVar2.Iy.asBinder()) == bVar2) {
                    if ((this.Dj & 1) != 0) {
                        MediaBrowserServiceCompat.dK();
                    }
                    try {
                        bVar2.Iy.a(str2, null, bundle2);
                    } catch (RemoteException e) {
                        new StringBuilder("Calling onLoadChildren() failed for id=").append(str2).append(" package=").append(bVar2.Iw);
                    }
                } else if (MediaBrowserServiceCompat.DEBUG) {
                    new StringBuilder("Not sending onLoadChildren result for connection that has been disconnected. pkg=").append(bVar2.Iw).append(" id=").append(str2);
                }
            }
        };
        this.Ip = bVar;
        if (bundle != null) {
            anonymousClass1.Dj = 1;
        }
        this.Ip = null;
        if (!anonymousClass1.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.Iw + " id=" + str);
        }
    }

    static boolean a(String str, b bVar, IBinder iBinder) {
        if (iBinder != null) {
            boolean z;
            List list = (List) bVar.IA.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                z = false;
                while (it.hasNext()) {
                    if (iBinder == ((j) it.next()).first) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    bVar.IA.remove(str);
                }
            } else {
                z = false;
            }
            return z;
        } else if (bVar.IA.remove(str) != null) {
            return true;
        } else {
            return false;
        }
    }

    static List<MediaItem> dK() {
        return null;
    }
}
