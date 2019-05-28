package android.support.p057v4.content;

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

/* renamed from: android.support.v4.content.d */
public final class C37116d {
    /* renamed from: Gr */
    private static C37116d f15761Gr;
    private static final Object mLock = new Object();
    /* renamed from: Gn */
    private final Context f15762Gn;
    /* renamed from: Go */
    private final HashMap<BroadcastReceiver, ArrayList<C37117b>> f15763Go = new HashMap();
    /* renamed from: Gp */
    private final HashMap<String, ArrayList<C37117b>> f15764Gp = new HashMap();
    /* renamed from: Gq */
    private final ArrayList<C37115a> f15765Gq = new ArrayList();
    private final Handler mHandler;

    /* renamed from: android.support.v4.content.d$a */
    static final class C37115a {
        /* renamed from: Gt */
        final ArrayList<C37117b> f15760Gt;
        final Intent intent;

        C37115a(Intent intent, ArrayList<C37117b> arrayList) {
            this.intent = intent;
            this.f15760Gt = arrayList;
        }
    }

    /* renamed from: android.support.v4.content.d$b */
    static final class C37117b {
        /* renamed from: Gu */
        boolean f15766Gu;
        /* renamed from: Gv */
        boolean f15767Gv;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        C37117b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.receiver);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.filter);
            if (this.f15767Gv) {
                stringBuilder.append(" DEAD");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    /* renamed from: S */
    public static C37116d m62125S(Context context) {
        C37116d c37116d;
        synchronized (mLock) {
            if (f15761Gr == null) {
                f15761Gr = new C37116d(context.getApplicationContext());
            }
            c37116d = f15761Gr;
        }
        return c37116d;
    }

    private C37116d(Context context) {
        this.f15762Gn = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C37116d.m62126a(C37116d.this);
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
    }

    /* renamed from: a */
    public final void mo59171a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f15763Go) {
            C37117b c37117b = new C37117b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.f15763Go.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f15763Go.put(broadcastReceiver, arrayList);
            }
            arrayList.add(c37117b);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                arrayList = (ArrayList) this.f15764Gp.get(action);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f15764Gp.put(action, arrayList);
                }
                arrayList.add(c37117b);
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f15763Go) {
            ArrayList arrayList = (ArrayList) this.f15763Go.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                C37117b c37117b = (C37117b) arrayList.get(size);
                c37117b.f15767Gv = true;
                for (int i = 0; i < c37117b.filter.countActions(); i++) {
                    String action = c37117b.filter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.f15764Gp.get(action);
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            C37117b c37117b2 = (C37117b) arrayList2.get(size2);
                            if (c37117b2.receiver == broadcastReceiver) {
                                c37117b2.f15767Gv = true;
                                arrayList2.remove(size2);
                            }
                        }
                        if (arrayList2.size() <= 0) {
                            this.f15764Gp.remove(action);
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
    /* renamed from: c */
    public final boolean mo59172c(Intent intent) {
        synchronized (this.f15763Go) {
            Object obj;
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f15762Gn.getContentResolver());
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
            ArrayList arrayList = (ArrayList) this.f15764Gp.get(intent.getAction());
            if (arrayList != null) {
                if (obj != null) {
                    new StringBuilder("Action list: ").append(arrayList);
                }
                ArrayList arrayList2 = null;
                int i = 0;
                while (i < arrayList.size()) {
                    ArrayList arrayList3;
                    C37117b c37117b = (C37117b) arrayList.get(i);
                    if (obj != null) {
                        new StringBuilder("Matching against filter ").append(c37117b.filter);
                    }
                    if (c37117b.f15766Gu) {
                        if (obj != null) {
                            arrayList3 = arrayList2;
                        }
                        arrayList3 = arrayList2;
                    } else {
                        int match = c37117b.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (obj != null) {
                                new StringBuilder("  Filter matched!  match=0x").append(Integer.toHexString(match));
                            }
                            if (arrayList2 == null) {
                                arrayList3 = new ArrayList();
                            } else {
                                arrayList3 = arrayList2;
                            }
                            arrayList3.add(c37117b);
                            c37117b.f15766Gu = true;
                        }
                        arrayList3 = arrayList2;
                    }
                    i++;
                    arrayList2 = arrayList3;
                }
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        ((C37117b) arrayList2.get(i2)).f15766Gu = false;
                    }
                    this.f15765Gq.add(new C37115a(intent, arrayList2));
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
            r6 = r5.f15760Gt.size();
            r3 = 0;
     */
    /* JADX WARNING: Missing block: B:14:0x0028, code skipped:
            if (r3 >= r6) goto L_0x0046;
     */
    /* JADX WARNING: Missing block: B:15:0x002a, code skipped:
            r0 = (android.support.p057v4.content.C37116d.C37117b) r5.f15760Gt.get(r3);
     */
    /* JADX WARNING: Missing block: B:16:0x0034, code skipped:
            if (r0.f15767Gv != false) goto L_0x003f;
     */
    /* JADX WARNING: Missing block: B:17:0x0036, code skipped:
            r0.receiver.onReceive(r9.f15762Gn, r5.intent);
     */
    /* JADX WARNING: Missing block: B:18:0x003f, code skipped:
            r3 = r3 + 1;
     */
    /* JADX WARNING: Missing block: B:23:0x0046, code skipped:
            r1 = r1 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m62126a(C37116d c37116d) {
        while (true) {
            synchronized (c37116d.f15763Go) {
                int size = c37116d.f15765Gq.size();
                if (size <= 0) {
                    return;
                }
                C37115a[] c37115aArr = new C37115a[size];
                c37116d.f15765Gq.toArray(c37115aArr);
                c37116d.f15765Gq.clear();
            }
        }
        while (true) {
        }
    }
}
