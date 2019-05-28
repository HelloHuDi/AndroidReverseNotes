package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class d {
    private static d Gr;
    private static final Object mLock = new Object();
    private final Context Gn;
    private final HashMap<BroadcastReceiver, ArrayList<b>> Go = new HashMap();
    private final HashMap<String, ArrayList<b>> Gp = new HashMap();
    private final ArrayList<a> Gq = new ArrayList();
    private final Handler mHandler;

    static final class a {
        final ArrayList<b> Gt;
        final Intent intent;

        a(Intent intent, ArrayList<b> arrayList) {
            this.intent = intent;
            this.Gt = arrayList;
        }
    }

    static final class b {
        boolean Gu;
        boolean Gv;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.receiver);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.filter);
            if (this.Gv) {
                stringBuilder.append(" DEAD");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static d S(Context context) {
        d dVar;
        synchronized (mLock) {
            if (Gr == null) {
                Gr = new d(context.getApplicationContext());
            }
            dVar = Gr;
        }
        return dVar;
    }

    private d(Context context) {
        this.Gn = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        d.a(d.this);
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.Go) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.Go.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.Go.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                arrayList = (ArrayList) this.Gp.get(action);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.Gp.put(action, arrayList);
                }
                arrayList.add(bVar);
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.Go) {
            ArrayList arrayList = (ArrayList) this.Go.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                b bVar = (b) arrayList.get(size);
                bVar.Gv = true;
                for (int i = 0; i < bVar.filter.countActions(); i++) {
                    String action = bVar.filter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.Gp.get(action);
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = (b) arrayList2.get(size2);
                            if (bVar2.receiver == broadcastReceiver) {
                                bVar2.Gv = true;
                                arrayList2.remove(size2);
                            }
                        }
                        if (arrayList2.size() <= 0) {
                            this.Gp.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:55:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(Intent intent) {
        synchronized (this.Go) {
            Object obj;
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.Gn.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set categories = intent.getCategories();
            if ((intent.getFlags() & 8) != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                new StringBuilder("Resolving type ").append(resolveTypeIfNeeded).append(" scheme ").append(scheme).append(" of intent ").append(intent);
            }
            ArrayList arrayList = (ArrayList) this.Gp.get(intent.getAction());
            if (arrayList != null) {
                if (obj != null) {
                    new StringBuilder("Action list: ").append(arrayList);
                }
                ArrayList arrayList2 = null;
                int i = 0;
                while (i < arrayList.size()) {
                    ArrayList arrayList3;
                    b bVar = (b) arrayList.get(i);
                    if (obj != null) {
                        new StringBuilder("Matching against filter ").append(bVar.filter);
                    }
                    if (bVar.Gu) {
                        if (obj != null) {
                            arrayList3 = arrayList2;
                        }
                        arrayList3 = arrayList2;
                    } else {
                        int match = bVar.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (obj != null) {
                                new StringBuilder("  Filter matched!  match=0x").append(Integer.toHexString(match));
                            }
                            if (arrayList2 == null) {
                                arrayList3 = new ArrayList();
                            } else {
                                arrayList3 = arrayList2;
                            }
                            arrayList3.add(bVar);
                            bVar.Gu = true;
                        }
                        arrayList3 = arrayList2;
                    }
                    i++;
                    arrayList2 = arrayList3;
                }
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        ((b) arrayList2.get(i2)).Gu = false;
                    }
                    this.Gq.add(new a(intent, arrayList2));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:10:0x001b, code skipped:
            r1 = 0;
     */
    /* JADX WARNING: Missing block: B:12:0x001d, code skipped:
            if (r1 >= r4.length) goto L_0x0001;
     */
    /* JADX WARNING: Missing block: B:13:0x001f, code skipped:
            r5 = r4[r1];
            r6 = r5.Gt.size();
            r3 = 0;
     */
    /* JADX WARNING: Missing block: B:14:0x0028, code skipped:
            if (r3 >= r6) goto L_0x0046;
     */
    /* JADX WARNING: Missing block: B:15:0x002a, code skipped:
            r0 = (android.support.v4.content.d.b) r5.Gt.get(r3);
     */
    /* JADX WARNING: Missing block: B:16:0x0034, code skipped:
            if (r0.Gv != false) goto L_0x003f;
     */
    /* JADX WARNING: Missing block: B:17:0x0036, code skipped:
            r0.receiver.onReceive(r9.Gn, r5.intent);
     */
    /* JADX WARNING: Missing block: B:18:0x003f, code skipped:
            r3 = r3 + 1;
     */
    /* JADX WARNING: Missing block: B:23:0x0046, code skipped:
            r1 = r1 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(d dVar) {
        while (true) {
            synchronized (dVar.Go) {
                int size = dVar.Gq.size();
                if (size <= 0) {
                    return;
                }
                a[] aVarArr = new a[size];
                dVar.Gq.toArray(aVarArr);
                dVar.Gq.clear();
            }
        }
        while (true) {
        }
    }
}
