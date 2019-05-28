package android.support.p057v4.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.p057v4.app.C8377e;
import android.support.p057v4.media.MediaBrowserCompat.MediaItem;
import android.support.p057v4.media.session.MediaSessionCompat.Token;
import android.support.p057v4.p065f.C0415j;
import android.support.p057v4.p065f.C6197a;
import android.support.p057v4.p066os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserServiceCompat */
public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
    /* renamed from: Io */
    final C6197a<IBinder, C25350b> f16800Io = new C6197a();
    /* renamed from: Ip */
    C25350b f16801Ip;
    /* renamed from: Iq */
    final C41508g f16802Iq = new C41508g();
    /* renamed from: Ir */
    Token f16803Ir;

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$a */
    public static final class C8396a {
        /* renamed from: Ib */
        final String f2372Ib;
        final Bundle mExtras;
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$c */
    public static class C17440c<T> {
        /* renamed from: Dj */
        int f3900Dj;
        /* renamed from: IC */
        final Object f3901IC;
        /* renamed from: IE */
        private boolean f3902IE;
        /* renamed from: IF */
        boolean f3903IF;
        /* renamed from: IG */
        boolean f3904IG;

        C17440c(Object obj) {
            this.f3901IC = obj;
        }

        /* renamed from: dN */
        public final void mo31712dN() {
            if (this.f3903IF || this.f3904IG) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f3901IC);
            }
            this.f3903IF = true;
            mo31710dL();
        }

        /* Access modifiers changed, original: final */
        public final boolean isDone() {
            return this.f3902IE || this.f3903IF || this.f3904IG;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: dL */
        public void mo31710dL() {
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: dM */
        public void mo31711dM() {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f3901IC);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$b */
    class C25350b implements DeathRecipient {
        /* renamed from: IA */
        HashMap<String, List<C0415j<IBinder, Bundle>>> f5168IA = new HashMap();
        /* renamed from: Iw */
        String f5170Iw;
        /* renamed from: Ix */
        Bundle f5171Ix;
        /* renamed from: Iy */
        C37124e f5172Iy;
        /* renamed from: Iz */
        C8396a f5173Iz;

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$b$1 */
        class C253511 implements Runnable {
            C253511() {
            }

            public final void run() {
                MediaBrowserServiceCompat.this.f16800Io.remove(C25350b.this.f5172Iy.asBinder());
            }
        }

        C25350b() {
        }

        public final void binderDied() {
            MediaBrowserServiceCompat.this.f16802Iq.post(new C253511());
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$3 */
    class C318603 extends C17440c<List<MediaItem>> {
        /* renamed from: Iv */
        final /* synthetic */ ResultReceiver f14628Iv;

        C318603(Object obj, ResultReceiver resultReceiver) {
            this.f14628Iv = resultReceiver;
            super(obj);
        }

        /* Access modifiers changed, original: final|synthetic */
        /* renamed from: dL */
        public final /* synthetic */ void mo31710dL() {
            this.f14628Iv.send(-1, null);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$4 */
    class C318614 extends C17440c<Bundle> {
        /* renamed from: Iv */
        final /* synthetic */ ResultReceiver f14630Iv;

        C318614(Object obj, ResultReceiver resultReceiver) {
            this.f14630Iv = resultReceiver;
            super(obj);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dM */
        public final void mo31711dM() {
            this.f14630Iv.send(-1, null);
        }

        /* Access modifiers changed, original: final|synthetic */
        /* renamed from: dL */
        public final /* synthetic */ void mo31710dL() {
            this.f14630Iv.send(0, null);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$e */
    interface C37124e {
        /* renamed from: a */
        void mo59175a(String str, Token token, Bundle bundle);

        /* renamed from: a */
        void mo59176a(String str, List<MediaItem> list, Bundle bundle);

        IBinder asBinder();

        /* renamed from: dO */
        void mo59178dO();
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$f */
    static class C41188f implements C37124e {
        /* renamed from: IQ */
        final Messenger f16583IQ;

        C41188f(Messenger messenger) {
            this.f16583IQ = messenger;
        }

        public final IBinder asBinder() {
            return this.f16583IQ.getBinder();
        }

        /* renamed from: a */
        public final void mo59175a(String str, Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            m71669b(1, bundle2);
        }

        /* renamed from: dO */
        public final void mo59178dO() {
            m71669b(2, null);
        }

        /* renamed from: a */
        public final void mo59176a(String str, List<MediaItem> list, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putBundle("data_options", bundle);
            m71669b(3, bundle2);
        }

        /* renamed from: b */
        private void m71669b(int i, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f16583IQ.send(obtain);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$g */
    final class C41508g extends Handler {
        /* renamed from: IR */
        private final C41510d f16798IR = new C41510d();

        C41508g() {
        }

        public final void handleMessage(Message message) {
            Object obj = null;
            Bundle data = message.getData();
            C41510d c41510d;
            String string;
            Bundle bundle;
            C41188f c41188f;
            C41510d c41510d2;
            ResultReceiver resultReceiver;
            switch (message.what) {
                case 1:
                    c41510d = this.f16798IR;
                    string = data.getString("data_package_name");
                    int i = data.getInt("data_calling_uid");
                    bundle = data.getBundle("data_root_hints");
                    c41188f = new C41188f(message.replyTo);
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
                    MediaBrowserServiceCompat.this.f16802Iq.m72491e(new C253521(c41188f, string, bundle, i));
                    return;
                case 2:
                    c41510d2 = this.f16798IR;
                    MediaBrowserServiceCompat.this.f16802Iq.m72491e(new C174412(new C41188f(message.replyTo)));
                    return;
                case 3:
                    c41510d = this.f16798IR;
                    string = data.getString("data_media_item_id");
                    IBinder c = C8377e.m14783c(data, "data_callback_token");
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaBrowserServiceCompat.this.f16802Iq.m72491e(new C174423(new C41188f(message.replyTo), string, c, bundle2));
                    return;
                case 4:
                    c41510d2 = this.f16798IR;
                    String string2 = data.getString("data_media_item_id");
                    IBinder c2 = C8377e.m14783c(data, "data_callback_token");
                    MediaBrowserServiceCompat.this.f16802Iq.m72491e(new C174434(new C41188f(message.replyTo), string2, c2));
                    return;
                case 5:
                    c41510d = this.f16798IR;
                    string = data.getString("data_media_item_id");
                    ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    c41188f = new C41188f(message.replyTo);
                    if (!TextUtils.isEmpty(string) && resultReceiver2 != null) {
                        MediaBrowserServiceCompat.this.f16802Iq.m72491e(new C174445(c41188f, string, resultReceiver2));
                        return;
                    }
                    return;
                case 6:
                    c41510d2 = this.f16798IR;
                    MediaBrowserServiceCompat.this.f16802Iq.m72491e(new C415046(new C41188f(message.replyTo), data.getBundle("data_root_hints")));
                    return;
                case 7:
                    c41510d2 = this.f16798IR;
                    MediaBrowserServiceCompat.this.f16802Iq.m72491e(new C415057(new C41188f(message.replyTo)));
                    return;
                case 8:
                    c41510d = this.f16798IR;
                    string = data.getString("data_search_query");
                    bundle = data.getBundle("data_search_extras");
                    resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    c41188f = new C41188f(message.replyTo);
                    if (!TextUtils.isEmpty(string) && resultReceiver != null) {
                        MediaBrowserServiceCompat.this.f16802Iq.m72491e(new C415068(c41188f, string, bundle, resultReceiver));
                        return;
                    }
                    return;
                case 9:
                    c41510d = this.f16798IR;
                    string = data.getString("data_custom_action");
                    bundle = data.getBundle("data_custom_action_extras");
                    resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    c41188f = new C41188f(message.replyTo);
                    if (!TextUtils.isEmpty(string) && resultReceiver != null) {
                        MediaBrowserServiceCompat.this.f16802Iq.m72491e(new C415079(c41188f, string, bundle, resultReceiver));
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

        /* renamed from: e */
        private void m72491e(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$2 */
    class C415092 extends C17440c<MediaItem> {
        /* renamed from: Iv */
        final /* synthetic */ ResultReceiver f16805Iv;

        C415092(Object obj, ResultReceiver resultReceiver) {
            this.f16805Iv = resultReceiver;
            super(obj);
        }

        /* Access modifiers changed, original: final|synthetic */
        /* renamed from: dL */
        public final /* synthetic */ void mo31710dL() {
            if ((this.f3900Dj & 2) != 0) {
                this.f16805Iv.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", null);
            this.f16805Iv.send(0, bundle);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d */
    class C41510d {

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$2 */
        class C174412 implements Runnable {
            /* renamed from: IH */
            final /* synthetic */ C37124e f3905IH;

            C174412(C37124e c37124e) {
                this.f3905IH = c37124e;
            }

            public final void run() {
                C25350b c25350b = (C25350b) MediaBrowserServiceCompat.this.f16800Io.remove(this.f3905IH.asBinder());
                if (c25350b != null) {
                    c25350b.f5172Iy.asBinder().unlinkToDeath(c25350b, 0);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$3 */
        class C174423 implements Runnable {
            /* renamed from: IH */
            final /* synthetic */ C37124e f3907IH;
            /* renamed from: IM */
            final /* synthetic */ IBinder f3909IM;
            final /* synthetic */ String val$id;
            final /* synthetic */ Bundle val$options;

            C174423(C37124e c37124e, String str, IBinder iBinder, Bundle bundle) {
                this.f3907IH = c37124e;
                this.val$id = str;
                this.f3909IM = iBinder;
                this.val$options = bundle;
            }

            public final void run() {
                C25350b c25350b = (C25350b) MediaBrowserServiceCompat.this.f16800Io.get(this.f3907IH.asBinder());
                if (c25350b == null) {
                    new StringBuilder("addSubscription for callback that isn't registered id=").append(this.val$id);
                } else {
                    MediaBrowserServiceCompat.this.mo66242a(this.val$id, c25350b, this.f3909IM, this.val$options);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$4 */
        class C174434 implements Runnable {
            /* renamed from: IH */
            final /* synthetic */ C37124e f3910IH;
            /* renamed from: IM */
            final /* synthetic */ IBinder f3912IM;
            final /* synthetic */ String val$id;

            C174434(C37124e c37124e, String str, IBinder iBinder) {
                this.f3910IH = c37124e;
                this.val$id = str;
                this.f3912IM = iBinder;
            }

            public final void run() {
                C25350b c25350b = (C25350b) MediaBrowserServiceCompat.this.f16800Io.get(this.f3910IH.asBinder());
                if (c25350b == null) {
                    new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.val$id);
                } else if (!MediaBrowserServiceCompat.m72492a(this.val$id, c25350b, this.f3912IM)) {
                    new StringBuilder("removeSubscription called for ").append(this.val$id).append(" which is not subscribed");
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$5 */
        class C174445 implements Runnable {
            /* renamed from: IH */
            final /* synthetic */ C37124e f3913IH;
            /* renamed from: IN */
            final /* synthetic */ String f3915IN;
            /* renamed from: Iv */
            final /* synthetic */ ResultReceiver f3916Iv;

            C174445(C37124e c37124e, String str, ResultReceiver resultReceiver) {
                this.f3913IH = c37124e;
                this.f3915IN = str;
                this.f3916Iv = resultReceiver;
            }

            public final void run() {
                C25350b c25350b = (C25350b) MediaBrowserServiceCompat.this.f16800Io.get(this.f3913IH.asBinder());
                if (c25350b == null) {
                    new StringBuilder("getMediaItem for callback that isn't registered id=").append(this.f3915IN);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                String str = this.f3915IN;
                C415092 c415092 = new C415092(str, this.f3916Iv);
                mediaBrowserServiceCompat.f16801Ip = c25350b;
                c415092.f3900Dj = 2;
                c415092.mo31712dN();
                mediaBrowserServiceCompat.f16801Ip = null;
                if (!c415092.isDone()) {
                    throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=".concat(String.valueOf(str)));
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$1 */
        class C253521 implements Runnable {
            /* renamed from: IH */
            final /* synthetic */ C37124e f5175IH;
            /* renamed from: II */
            final /* synthetic */ String f5176II;
            /* renamed from: IJ */
            final /* synthetic */ Bundle f5177IJ;
            /* renamed from: IK */
            final /* synthetic */ int f5178IK;

            C253521(C37124e c37124e, String str, Bundle bundle, int i) {
                this.f5175IH = c37124e;
                this.f5176II = str;
                this.f5177IJ = bundle;
                this.f5178IK = i;
            }

            public final void run() {
                IBinder asBinder = this.f5175IH.asBinder();
                MediaBrowserServiceCompat.this.f16800Io.remove(asBinder);
                C25350b c25350b = new C25350b();
                c25350b.f5170Iw = this.f5176II;
                c25350b.f5171Ix = this.f5177IJ;
                c25350b.f5172Iy = this.f5175IH;
                c25350b.f5173Iz = MediaBrowserServiceCompat.this.mo66243dJ();
                if (c25350b.f5173Iz == null) {
                    new StringBuilder("No root for client ").append(this.f5176II).append(" from service ").append(getClass().getName());
                    try {
                        this.f5175IH.mo59178dO();
                        return;
                    } catch (RemoteException e) {
                        new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.f5176II);
                        return;
                    }
                }
                try {
                    MediaBrowserServiceCompat.this.f16800Io.put(asBinder, c25350b);
                    asBinder.linkToDeath(c25350b, 0);
                    if (MediaBrowserServiceCompat.this.f16803Ir != null) {
                        this.f5175IH.mo59175a(c25350b.f5173Iz.f2372Ib, MediaBrowserServiceCompat.this.f16803Ir, c25350b.f5173Iz.mExtras);
                    }
                } catch (RemoteException e2) {
                    new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.f5176II);
                    MediaBrowserServiceCompat.this.f16800Io.remove(asBinder);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$6 */
        class C415046 implements Runnable {
            /* renamed from: IH */
            final /* synthetic */ C37124e f16786IH;
            /* renamed from: IJ */
            final /* synthetic */ Bundle f16787IJ;

            C415046(C37124e c37124e, Bundle bundle) {
                this.f16786IH = c37124e;
                this.f16787IJ = bundle;
            }

            public final void run() {
                IBinder asBinder = this.f16786IH.asBinder();
                MediaBrowserServiceCompat.this.f16800Io.remove(asBinder);
                C25350b c25350b = new C25350b();
                c25350b.f5172Iy = this.f16786IH;
                c25350b.f5171Ix = this.f16787IJ;
                MediaBrowserServiceCompat.this.f16800Io.put(asBinder, c25350b);
                try {
                    asBinder.linkToDeath(c25350b, 0);
                } catch (RemoteException e) {
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$7 */
        class C415057 implements Runnable {
            /* renamed from: IH */
            final /* synthetic */ C37124e f16789IH;

            C415057(C37124e c37124e) {
                this.f16789IH = c37124e;
            }

            public final void run() {
                IBinder asBinder = this.f16789IH.asBinder();
                C25350b c25350b = (C25350b) MediaBrowserServiceCompat.this.f16800Io.remove(asBinder);
                if (c25350b != null) {
                    asBinder.unlinkToDeath(c25350b, 0);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$8 */
        class C415068 implements Runnable {
            /* renamed from: IH */
            final /* synthetic */ C37124e f16791IH;
            /* renamed from: IP */
            final /* synthetic */ String f16793IP;
            /* renamed from: Iv */
            final /* synthetic */ ResultReceiver f16794Iv;
            final /* synthetic */ Bundle val$extras;

            C415068(C37124e c37124e, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f16791IH = c37124e;
                this.f16793IP = str;
                this.val$extras = bundle;
                this.f16794Iv = resultReceiver;
            }

            public final void run() {
                C25350b c25350b = (C25350b) MediaBrowserServiceCompat.this.f16800Io.get(this.f16791IH.asBinder());
                if (c25350b == null) {
                    new StringBuilder("search for callback that isn't registered query=").append(this.f16793IP);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                String str = this.f16793IP;
                C318603 c318603 = new C318603(str, this.f16794Iv);
                mediaBrowserServiceCompat.f16801Ip = c25350b;
                c318603.f3900Dj = 4;
                c318603.mo31712dN();
                mediaBrowserServiceCompat.f16801Ip = null;
                if (!c318603.isDone()) {
                    throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=".concat(String.valueOf(str)));
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$d$9 */
        class C415079 implements Runnable {
            /* renamed from: IH */
            final /* synthetic */ C37124e f16795IH;
            /* renamed from: Iv */
            final /* synthetic */ ResultReceiver f16797Iv;
            final /* synthetic */ String val$action;
            final /* synthetic */ Bundle val$extras;

            C415079(C37124e c37124e, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f16795IH = c37124e;
                this.val$action = str;
                this.val$extras = bundle;
                this.f16797Iv = resultReceiver;
            }

            public final void run() {
                C25350b c25350b = (C25350b) MediaBrowserServiceCompat.this.f16800Io.get(this.f16795IH.asBinder());
                if (c25350b == null) {
                    new StringBuilder("sendCustomAction for callback that isn't registered action=").append(this.val$action).append(", extras=").append(this.val$extras);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                String str = this.val$action;
                Bundle bundle = this.val$extras;
                C318614 c318614 = new C318614(str, this.f16797Iv);
                mediaBrowserServiceCompat.f16801Ip = c25350b;
                if (c318614.f3903IF || c318614.f3904IG) {
                    throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + c318614.f3901IC);
                }
                c318614.f3904IG = true;
                c318614.mo31711dM();
                mediaBrowserServiceCompat.f16801Ip = null;
                if (!c318614.isDone()) {
                    throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
                }
            }
        }

        C41510d() {
        }
    }

    /* renamed from: dJ */
    public abstract C8396a mo66243dJ();

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo66242a(String str, C25350b c25350b, IBinder iBinder, Bundle bundle) {
        List list = (List) c25350b.f5168IA.get(str);
        List arrayList;
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        for (C0415j c0415j : arrayList) {
            if (iBinder == c0415j.first && C17446c.m27083a(bundle, (Bundle) c0415j.second)) {
                return;
            }
        }
        arrayList.add(new C0415j(iBinder, bundle));
        c25350b.f5168IA.put(str, arrayList);
        final C25350b c25350b2 = c25350b;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        C371231 c371231 = new C17440c<List<MediaItem>>(str) {
            /* Access modifiers changed, original: final|synthetic */
            /* renamed from: dL */
            public final /* synthetic */ void mo31710dL() {
                if (MediaBrowserServiceCompat.this.f16800Io.get(c25350b2.f5172Iy.asBinder()) == c25350b2) {
                    if ((this.f3900Dj & 1) != 0) {
                        MediaBrowserServiceCompat.m72493dK();
                    }
                    try {
                        c25350b2.f5172Iy.mo59176a(str2, null, bundle2);
                    } catch (RemoteException e) {
                        new StringBuilder("Calling onLoadChildren() failed for id=").append(str2).append(" package=").append(c25350b2.f5170Iw);
                    }
                } else if (MediaBrowserServiceCompat.DEBUG) {
                    new StringBuilder("Not sending onLoadChildren result for connection that has been disconnected. pkg=").append(c25350b2.f5170Iw).append(" id=").append(str2);
                }
            }
        };
        this.f16801Ip = c25350b;
        if (bundle != null) {
            c371231.f3900Dj = 1;
        }
        this.f16801Ip = null;
        if (!c371231.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + c25350b.f5170Iw + " id=" + str);
        }
    }

    /* renamed from: a */
    static boolean m72492a(String str, C25350b c25350b, IBinder iBinder) {
        if (iBinder != null) {
            boolean z;
            List list = (List) c25350b.f5168IA.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                z = false;
                while (it.hasNext()) {
                    if (iBinder == ((C0415j) it.next()).first) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    c25350b.f5168IA.remove(str);
                }
            } else {
                z = false;
            }
            return z;
        } else if (c25350b.f5168IA.remove(str) != null) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: dK */
    static List<MediaItem> m72493dK() {
        return null;
    }
}
