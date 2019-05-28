package com.tencent.mm.plugin.notification.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.v.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification {
    Notification Fl = null;
    boolean kXv = false;
    public Context mContext;
    private boolean mIsInit = false;
    private int mType;
    public a oWA = null;
    public b oWB = null;
    public c oWC = null;
    public String oWD = null;
    public String oWE = null;
    private PendingIntent oWF = null;
    private PendingIntent oWG = null;
    private PendingIntent oWH = null;
    private PendingIntent oWI = null;
    public boolean oWJ = false;
    public boolean oWK = false;
    public boolean oWL = true;
    public c oWx = null;
    private Intent oWy = null;
    private int oWz = 0;

    public static class FailSendSnsMsgNotificationService extends FailSendMsgNotificationService {
        /* Access modifiers changed, original: protected|final */
        public final int bWW() {
            return 2;
        }
    }

    public static abstract class FailSendMsgNotificationService extends Service {
        protected com.tencent.mm.sdk.b.c oWM = new com.tencent.mm.sdk.b.c<kt>() {
            {
                AppMethodBeat.i(23192);
                this.xxI = kt.class.getName().hashCode();
                AppMethodBeat.o(23192);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(23193);
                if (((kt) bVar).cGI.type != FailSendMsgNotificationService.this.bWW()) {
                    ab.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, type mismatch, type:%d, getNotificationType:%d", Integer.valueOf(((kt) bVar).cGI.type), Integer.valueOf(FailSendMsgNotificationService.this.bWW()));
                    AppMethodBeat.o(23193);
                } else {
                    ab.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, stop service and show notificaiton, type:%d", Integer.valueOf(((kt) bVar).cGI.type));
                    FailSendMsgNotificationService.this.stopForeground(true);
                    if (FailSendMsgNotificationService.this.oWN != null) {
                        FailSendMsgNotificationService.this.oWN.kXv = false;
                        FailSendMsgNotificationService.this.oWN.show();
                    }
                    FailSendMsgNotificationService.this.stopSelf();
                    AppMethodBeat.o(23193);
                }
                return false;
            }
        };
        protected FailSendMsgNotification oWN = null;

        public abstract int bWW();

        public void onCreate() {
            super.onCreate();
            ab.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
            a.xxA.c(this.oWM);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        @TargetApi(16)
        public int onStartCommand(Intent intent, int i, int i2) {
            ab.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
            if (intent == null || intent.getExtras() == null) {
                ab.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
            } else {
                String action = intent.getAction();
                if (bo.isNullOrNil(action)) {
                    ab.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                } else {
                    int i3 = intent.getExtras().getInt("notification_type", -1);
                    ab.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", Integer.valueOf(i3));
                    if (f.At(i3) == null) {
                        ab.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                    } else {
                        ab.d("MicroMsg.FailSendMsgNotification", "action:%s", action);
                        this.oWN = f.At(i3);
                        if (action.startsWith("com.tencent.failnotification.omit")) {
                            if (this.oWN.oWA != null) {
                                ab.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", Integer.valueOf(i3));
                                this.oWN.oWA.bWH();
                            }
                        } else if (action.startsWith("com.tencent.failnotificaiton.resend")) {
                            if (this.oWN.oWA != null) {
                                boolean z;
                                String str = "MicroMsg.FailSendMsgNotification";
                                String str2 = "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b";
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(i3);
                                if (this.oWN.Fl == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                objArr[1] = Boolean.valueOf(z);
                                if (this.oWN.oWx == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                objArr[2] = Boolean.valueOf(z);
                                ab.d(str, str2, objArr);
                                if (this.oWN != null) {
                                    this.oWN.kXv = true;
                                }
                                if (this.oWN.Fl != null && VERSION.SDK_INT >= 16) {
                                    this.oWN.Fl.priority = 0;
                                }
                                if (this.oWN.Fl == null) {
                                    this.oWN.show();
                                }
                                startForeground(i3, this.oWN.Fl);
                                this.oWN.oWA.bWG();
                                ab.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", Integer.valueOf(i3));
                            }
                        } else if (action.startsWith("com.tencent.failnotification.click")) {
                            if (this.oWN.oWB != null) {
                                ab.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", Integer.valueOf(i3));
                                this.oWN.oWB.bWI();
                            }
                        } else if (action.startsWith("com.tencent.failnotification.dismiss")) {
                            this.oWN.oWJ = false;
                            this.oWN.kXv = false;
                            if (this.oWN.oWC != null) {
                                ab.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
                                this.oWN.oWC.onDismiss();
                            }
                            stopSelf();
                        }
                    }
                }
            }
            return 2;
        }

        public void onDestroy() {
            super.onDestroy();
            ab.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
            a.xxA.d(this.oWM);
        }
    }

    public static class FailSendNormalMsgNotificationService extends FailSendMsgNotificationService {
        /* Access modifiers changed, original: protected|final */
        public final int bWW() {
            return 1;
        }
    }

    public FailSendMsgNotification(int i) {
        AppMethodBeat.i(23194);
        this.mType = i;
        this.mContext = ah.getContext();
        this.oWx = com.tencent.mm.bo.a.bt(this.mContext, com.tencent.mm.bo.a.dgM());
        this.oWL = true;
        this.oWE = "";
        try {
            if (this.oWL) {
                bWQ();
            }
            bWR();
            this.mIsInit = true;
        } catch (Exception e) {
            ab.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", e.getMessage());
            this.mIsInit = false;
        }
        String str = "MicroMsg.FailSendMsgNotification";
        String str2 = "create FailSendMsgNotification, type:%d, context==null:%b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.mContext == null);
        ab.d(str, str2, objArr);
        this.oWJ = false;
        AppMethodBeat.o(23194);
    }

    private void bWQ() {
        AppMethodBeat.i(23195);
        this.oWx.Fa = true;
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.omit_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.omit_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.oWH = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oWx.a(R.drawable.bdq, this.mContext.getString(R.string.d95), this.oWH);
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotificaiton.resend_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotificaiton.resend_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        if (VERSION.SDK_INT >= 16) {
            intent.addFlags(268435456);
        }
        this.oWI = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oWx.a(R.drawable.bdr, this.mContext.getString(R.string.d96), this.oWI);
        AppMethodBeat.o(23195);
    }

    public final void bWR() {
        AppMethodBeat.i(23196);
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.click_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.click_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.oWF = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oWx.EI = this.oWF;
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.dismiss_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.dismiss_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.oWG = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.oWx.a(this.oWG);
        AppMethodBeat.o(23196);
    }

    public final void bWS() {
        AppMethodBeat.i(23198);
        ab.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", Boolean.FALSE);
        this.kXv = false;
        AppMethodBeat.o(23198);
    }

    @TargetApi(16)
    public final void show() {
        AppMethodBeat.i(23199);
        if (this.mIsInit) {
            this.oWx.g(this.oWE);
            this.oWx.d(this.mContext.getText(R.string.ru));
            this.oWx.as(bWV());
            this.oWx.e(this.oWD);
            this.oWx.z(false);
            this.Fl = this.oWx.build();
            if (VERSION.SDK_INT >= 16 && !this.kXv) {
                this.Fl.priority = 2;
                ab.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
            }
            ab.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", Boolean.valueOf(this.kXv));
            aw.getNotification().a(this.mType, this.Fl, false);
            this.oWJ = true;
            AppMethodBeat.o(23199);
            return;
        }
        ab.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
        AppMethodBeat.o(23199);
    }

    public final void dismiss() {
        AppMethodBeat.i(23200);
        aw.getNotification().cancel(this.mType);
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
            this.mContext.stopService(intent);
        } else if (this.mType == 2) {
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
            this.mContext.stopService(intent);
        }
        this.kXv = false;
        this.oWJ = false;
        AppMethodBeat.o(23200);
    }

    public final void bWT() {
        AppMethodBeat.i(23201);
        this.oWx.k(2, false);
        this.oWK = false;
        show();
        ab.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
        AppMethodBeat.o(23201);
    }

    public final void bWU() {
        AppMethodBeat.i(23202);
        this.oWL = true;
        this.oWx = com.tencent.mm.bo.a.bt(this.mContext, com.tencent.mm.bo.a.dgM());
        bWQ();
        bWR();
        AppMethodBeat.o(23202);
    }

    private static int bWV() {
        if (VERSION.SDK_INT < 19) {
            return R.drawable.bdn;
        }
        return R.drawable.bdo;
    }

    public final void TV(String str) {
        AppMethodBeat.i(23197);
        this.oWD = str;
        show();
        AppMethodBeat.o(23197);
    }
}
