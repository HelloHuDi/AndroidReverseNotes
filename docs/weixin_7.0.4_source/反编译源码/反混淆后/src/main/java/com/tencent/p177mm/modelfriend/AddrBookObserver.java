package com.tencent.p177mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C26167it;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C45474a;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C9877al;
import com.tencent.p177mm.plugin.account.p765a.p766a.C45491b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.service.MMService;
import java.util.Random;

/* renamed from: com.tencent.mm.modelfriend.AddrBookObserver */
public final class AddrBookObserver extends ContentObserver {
    private static boolean fAV = false;
    private static Intent fAW;
    private static C7306ak handler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(124497);
            super.handleMessage(message);
            Context context = (Context) message.obj;
            if (AddrBookObserver.fAW == null) {
                AddrBookObserver.fAW = new Intent();
                AddrBookObserver.fAW.setClass(context, AddrBookService.class);
            }
            AddrBookObserver.fAW.putExtra(AddrBookService.fAX, new Random(System.currentTimeMillis()).nextFloat());
            try {
                C4990ab.m7417i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", Float.valueOf(new Random(System.currentTimeMillis()).nextFloat()));
                C25985d.m41463aH(AddrBookObserver.fAW);
                AppMethodBeat.m2505o(124497);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AddrBookObserver", e, "startService failed", new Object[0]);
                AppMethodBeat.m2505o(124497);
            }
        }
    };
    private final Context context;

    /* renamed from: com.tencent.mm.modelfriend.AddrBookObserver$AddrBookService */
    public static class AddrBookService extends MMService {
        public static boolean bqV = false;
        public static boolean fAV = false;
        public static String fAX = "key_sync_session";
        private C45491b fAY = new C96891();

        /* renamed from: com.tencent.mm.modelfriend.AddrBookObserver$AddrBookService$1 */
        class C96891 implements C45491b {
            C96891() {
            }

            /* renamed from: cN */
            public final void mo14963cN(boolean z) {
                AppMethodBeat.m2504i(124498);
                if (z) {
                    System.currentTimeMillis();
                    C38033l.apX();
                    C1720g.m3540Rg().mo14541a(new C9877al(C38033l.aqb(), C38033l.aqa()), 0);
                    AddrBookService.this.stopSelf();
                    AddrBookService.fAV = false;
                    AppMethodBeat.m2505o(124498);
                    return;
                }
                C4990ab.m7418v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
                AddrBookService.this.stopSelf();
                AddrBookService.fAV = false;
                AppMethodBeat.m2505o(124498);
            }
        }

        public AddrBookService() {
            AppMethodBeat.m2504i(124499);
            AppMethodBeat.m2505o(124499);
        }

        public final int onStartCommand(Intent intent, int i, int i2) {
            AppMethodBeat.m2504i(124500);
            super.onStartCommand(intent, i, i2);
            String str = "MicroMsg.AddrBookObserver";
            String str2 = "service start intent:%b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(intent == null);
            C4990ab.m7417i(str, str2, objArr);
            if (intent == null) {
                C4990ab.m7412e("MicroMsg.AddrBookObserver", "intent == null, stop service");
                stopSelf();
                AppMethodBeat.m2505o(124500);
            } else {
                float floatExtra = intent.getFloatExtra(fAX, -1.0f);
                if (floatExtra == -1.0f) {
                    C4990ab.m7412e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
                    stopSelf();
                    AppMethodBeat.m2505o(124500);
                } else {
                    SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
                    if (sharedPreferences.getFloat(fAX, 0.0f) == floatExtra) {
                        C4990ab.m7411d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", Float.valueOf(sharedPreferences.getFloat(fAX, 0.0f)));
                        stopSelf();
                        AppMethodBeat.m2505o(124500);
                    } else {
                        sharedPreferences.edit().putFloat(fAX, floatExtra).commit();
                        C4990ab.m7411d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", Float.valueOf(floatExtra));
                        if (bqV) {
                            C4990ab.m7416i("MicroMsg.AddrBookObserver", "service canceled");
                            bqV = false;
                            stopSelf();
                            AppMethodBeat.m2505o(124500);
                        } else {
                            try {
                                if (C1720g.m3531RK()) {
                                    if (C26373g.m41964Nu().getInt("WCOEntranceSwitch", 0) > 0) {
                                        C4879a.xxA.mo10055m(new C26167it());
                                    }
                                    if (!C38033l.apV() || C38033l.apR()) {
                                        C4990ab.m7412e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
                                        stopSelf();
                                        AppMethodBeat.m2505o(124500);
                                    } else {
                                        C4990ab.m7416i("MicroMsg.AddrBookObserver", "start sync");
                                        if (C26529w.m42360cq(C4996ah.getContext())) {
                                            C4990ab.m7412e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
                                            stopSelf();
                                            AppMethodBeat.m2505o(124500);
                                        } else {
                                            fAV = true;
                                            C45474a.syncAddrBook(this.fAY);
                                            AppMethodBeat.m2505o(124500);
                                        }
                                    }
                                } else {
                                    C4990ab.m7416i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
                                    stopSelf();
                                    AppMethodBeat.m2505o(124500);
                                }
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.AddrBookObserver", e, "", new Object[0]);
                                C4990ab.m7413e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", e.getMessage());
                                stopSelf();
                            }
                        }
                    }
                }
            }
            return 2;
        }

        /* renamed from: Iu */
        public final IBinder mo10421Iu() {
            return null;
        }

        public final String getTag() {
            return "MicroMsg.AddrBookObserver";
        }
    }

    static {
        AppMethodBeat.m2504i(124503);
        AppMethodBeat.m2505o(124503);
    }

    public AddrBookObserver(Context context) {
        super(C7306ak.fetchFreeHandler());
        AppMethodBeat.m2504i(124501);
        this.context = context;
        AppMethodBeat.m2505o(124501);
    }

    public final void onChange(boolean z) {
        AppMethodBeat.m2504i(124502);
        super.onChange(z);
        C4990ab.m7416i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
        if (fAV) {
            C4990ab.m7412e("MicroMsg.AddrBookObserver", "isSyncing:" + fAV + ", is time to sync:" + C38033l.apW() + " , return");
            AppMethodBeat.m2505o(124502);
            return;
        }
        C38033l.apW();
        handler.removeMessages(0);
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = this.context;
        obtainMessage.what = 0;
        handler.sendMessageDelayed(obtainMessage, 20000);
        AppMethodBeat.m2505o(124502);
    }
}
