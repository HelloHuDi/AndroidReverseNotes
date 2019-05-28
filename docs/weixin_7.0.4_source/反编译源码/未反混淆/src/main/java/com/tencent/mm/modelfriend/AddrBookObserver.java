package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.it;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.service.MMService;
import java.util.Random;

public final class AddrBookObserver extends ContentObserver {
    private static boolean fAV = false;
    private static Intent fAW;
    private static ak handler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(124497);
            super.handleMessage(message);
            Context context = (Context) message.obj;
            if (AddrBookObserver.fAW == null) {
                AddrBookObserver.fAW = new Intent();
                AddrBookObserver.fAW.setClass(context, AddrBookService.class);
            }
            AddrBookObserver.fAW.putExtra(AddrBookService.fAX, new Random(System.currentTimeMillis()).nextFloat());
            try {
                ab.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", Float.valueOf(new Random(System.currentTimeMillis()).nextFloat()));
                d.aH(AddrBookObserver.fAW);
                AppMethodBeat.o(124497);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AddrBookObserver", e, "startService failed", new Object[0]);
                AppMethodBeat.o(124497);
            }
        }
    };
    private final Context context;

    public static class AddrBookService extends MMService {
        public static boolean bqV = false;
        public static boolean fAV = false;
        public static String fAX = "key_sync_session";
        private b fAY = new b() {
            public final void cN(boolean z) {
                AppMethodBeat.i(124498);
                if (z) {
                    System.currentTimeMillis();
                    l.apX();
                    g.Rg().a(new al(l.aqb(), l.aqa()), 0);
                    AddrBookService.this.stopSelf();
                    AddrBookService.fAV = false;
                    AppMethodBeat.o(124498);
                    return;
                }
                ab.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
                AddrBookService.this.stopSelf();
                AddrBookService.fAV = false;
                AppMethodBeat.o(124498);
            }
        };

        public AddrBookService() {
            AppMethodBeat.i(124499);
            AppMethodBeat.o(124499);
        }

        public final int onStartCommand(Intent intent, int i, int i2) {
            AppMethodBeat.i(124500);
            super.onStartCommand(intent, i, i2);
            String str = "MicroMsg.AddrBookObserver";
            String str2 = "service start intent:%b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(intent == null);
            ab.i(str, str2, objArr);
            if (intent == null) {
                ab.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
                stopSelf();
                AppMethodBeat.o(124500);
            } else {
                float floatExtra = intent.getFloatExtra(fAX, -1.0f);
                if (floatExtra == -1.0f) {
                    ab.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
                    stopSelf();
                    AppMethodBeat.o(124500);
                } else {
                    SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
                    if (sharedPreferences.getFloat(fAX, 0.0f) == floatExtra) {
                        ab.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", Float.valueOf(sharedPreferences.getFloat(fAX, 0.0f)));
                        stopSelf();
                        AppMethodBeat.o(124500);
                    } else {
                        sharedPreferences.edit().putFloat(fAX, floatExtra).commit();
                        ab.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", Float.valueOf(floatExtra));
                        if (bqV) {
                            ab.i("MicroMsg.AddrBookObserver", "service canceled");
                            bqV = false;
                            stopSelf();
                            AppMethodBeat.o(124500);
                        } else {
                            try {
                                if (g.RK()) {
                                    if (com.tencent.mm.m.g.Nu().getInt("WCOEntranceSwitch", 0) > 0) {
                                        a.xxA.m(new it());
                                    }
                                    if (!l.apV() || l.apR()) {
                                        ab.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
                                        stopSelf();
                                        AppMethodBeat.o(124500);
                                    } else {
                                        ab.i("MicroMsg.AddrBookObserver", "start sync");
                                        if (w.cq(ah.getContext())) {
                                            ab.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
                                            stopSelf();
                                            AppMethodBeat.o(124500);
                                        } else {
                                            fAV = true;
                                            com.tencent.mm.platformtools.a.syncAddrBook(this.fAY);
                                            AppMethodBeat.o(124500);
                                        }
                                    }
                                } else {
                                    ab.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
                                    stopSelf();
                                    AppMethodBeat.o(124500);
                                }
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.AddrBookObserver", e, "", new Object[0]);
                                ab.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", e.getMessage());
                                stopSelf();
                            }
                        }
                    }
                }
            }
            return 2;
        }

        public final IBinder Iu() {
            return null;
        }

        public final String getTag() {
            return "MicroMsg.AddrBookObserver";
        }
    }

    static {
        AppMethodBeat.i(124503);
        AppMethodBeat.o(124503);
    }

    public AddrBookObserver(Context context) {
        super(ak.fetchFreeHandler());
        AppMethodBeat.i(124501);
        this.context = context;
        AppMethodBeat.o(124501);
    }

    public final void onChange(boolean z) {
        AppMethodBeat.i(124502);
        super.onChange(z);
        ab.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
        if (fAV) {
            ab.e("MicroMsg.AddrBookObserver", "isSyncing:" + fAV + ", is time to sync:" + l.apW() + " , return");
            AppMethodBeat.o(124502);
            return;
        }
        l.apW();
        handler.removeMessages(0);
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = this.context;
        obtainMessage.what = 0;
        handler.sendMessageDelayed(obtainMessage, 20000);
        AppMethodBeat.o(124502);
    }
}
