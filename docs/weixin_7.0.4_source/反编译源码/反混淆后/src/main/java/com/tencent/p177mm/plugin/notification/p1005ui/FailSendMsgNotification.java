package com.tencent.p177mm.plugin.notification.p1005ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p230g.p231a.C45340kt;
import com.tencent.p177mm.plugin.notification.p477d.C34636f;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@SuppressLint({"InlinedApi"})
/* renamed from: com.tencent.mm.plugin.notification.ui.FailSendMsgNotification */
public final class FailSendMsgNotification {
    /* renamed from: Fl */
    Notification f17209Fl = null;
    boolean kXv = false;
    public Context mContext;
    private boolean mIsInit = false;
    private int mType;
    public C34641a oWA = null;
    public C34642b oWB = null;
    public C34643c oWC = null;
    public String oWD = null;
    public String oWE = null;
    private PendingIntent oWF = null;
    private PendingIntent oWG = null;
    private PendingIntent oWH = null;
    private PendingIntent oWI = null;
    public boolean oWJ = false;
    public boolean oWK = false;
    public boolean oWL = true;
    public C0358c oWx = null;
    private Intent oWy = null;
    private int oWz = 0;

    /* renamed from: com.tencent.mm.plugin.notification.ui.FailSendMsgNotification$FailSendSnsMsgNotificationService */
    public static class FailSendSnsMsgNotificationService extends FailSendMsgNotificationService {
        /* Access modifiers changed, original: protected|final */
        public final int bWW() {
            return 2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.ui.FailSendMsgNotification$FailSendMsgNotificationService */
    public static abstract class FailSendMsgNotificationService extends Service {
        protected C4884c oWM = new C127331();
        protected FailSendMsgNotification oWN = null;

        /* renamed from: com.tencent.mm.plugin.notification.ui.FailSendMsgNotification$FailSendMsgNotificationService$1 */
        class C127331 extends C4884c<C45340kt> {
            C127331() {
                AppMethodBeat.m2504i(23192);
                this.xxI = C45340kt.class.getName().hashCode();
                AppMethodBeat.m2505o(23192);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(23193);
                if (((C45340kt) c4883b).cGI.type != FailSendMsgNotificationService.this.bWW()) {
                    C4990ab.m7411d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, type mismatch, type:%d, getNotificationType:%d", Integer.valueOf(((C45340kt) c4883b).cGI.type), Integer.valueOf(FailSendMsgNotificationService.this.bWW()));
                    AppMethodBeat.m2505o(23193);
                } else {
                    C4990ab.m7411d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, stop service and show notificaiton, type:%d", Integer.valueOf(((C45340kt) c4883b).cGI.type));
                    FailSendMsgNotificationService.this.stopForeground(true);
                    if (FailSendMsgNotificationService.this.oWN != null) {
                        FailSendMsgNotificationService.this.oWN.kXv = false;
                        FailSendMsgNotificationService.this.oWN.show();
                    }
                    FailSendMsgNotificationService.this.stopSelf();
                    AppMethodBeat.m2505o(23193);
                }
                return false;
            }
        }

        public abstract int bWW();

        public void onCreate() {
            super.onCreate();
            C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
            C4879a.xxA.mo10052c(this.oWM);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        @TargetApi(16)
        public int onStartCommand(Intent intent, int i, int i2) {
            C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "onStartCommand");
            if (intent == null || intent.getExtras() == null) {
                C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
            } else {
                String action = intent.getAction();
                if (C5046bo.isNullOrNil(action)) {
                    C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                } else {
                    int i3 = intent.getExtras().getInt("notification_type", -1);
                    C4990ab.m7411d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", Integer.valueOf(i3));
                    if (C34636f.m56827At(i3) == null) {
                        C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                    } else {
                        C4990ab.m7411d("MicroMsg.FailSendMsgNotification", "action:%s", action);
                        this.oWN = C34636f.m56827At(i3);
                        if (action.startsWith("com.tencent.failnotification.omit")) {
                            if (this.oWN.oWA != null) {
                                C4990ab.m7411d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", Integer.valueOf(i3));
                                this.oWN.oWA.bWH();
                            }
                        } else if (action.startsWith("com.tencent.failnotificaiton.resend")) {
                            if (this.oWN.oWA != null) {
                                boolean z;
                                String str = "MicroMsg.FailSendMsgNotification";
                                String str2 = "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b";
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(i3);
                                if (this.oWN.f17209Fl == null) {
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
                                C4990ab.m7411d(str, str2, objArr);
                                if (this.oWN != null) {
                                    this.oWN.kXv = true;
                                }
                                if (this.oWN.f17209Fl != null && VERSION.SDK_INT >= 16) {
                                    this.oWN.f17209Fl.priority = 0;
                                }
                                if (this.oWN.f17209Fl == null) {
                                    this.oWN.show();
                                }
                                startForeground(i3, this.oWN.f17209Fl);
                                this.oWN.oWA.bWG();
                                C4990ab.m7411d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", Integer.valueOf(i3));
                            }
                        } else if (action.startsWith("com.tencent.failnotification.click")) {
                            if (this.oWN.oWB != null) {
                                C4990ab.m7411d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", Integer.valueOf(i3));
                                this.oWN.oWB.bWI();
                            }
                        } else if (action.startsWith("com.tencent.failnotification.dismiss")) {
                            this.oWN.oWJ = false;
                            this.oWN.kXv = false;
                            if (this.oWN.oWC != null) {
                                C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
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
            C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
            C4879a.xxA.mo10053d(this.oWM);
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.ui.FailSendMsgNotification$FailSendNormalMsgNotificationService */
    public static class FailSendNormalMsgNotificationService extends FailSendMsgNotificationService {
        /* Access modifiers changed, original: protected|final */
        public final int bWW() {
            return 1;
        }
    }

    public FailSendMsgNotification(int i) {
        AppMethodBeat.m2504i(23194);
        this.mType = i;
        this.mContext = C4996ah.getContext();
        this.oWx = C45186a.m83262bt(this.mContext, C45186a.dgM());
        this.oWL = true;
        this.oWE = "";
        try {
            if (this.oWL) {
                bWQ();
            }
            bWR();
            this.mIsInit = true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", e.getMessage());
            this.mIsInit = false;
        }
        String str = "MicroMsg.FailSendMsgNotification";
        String str2 = "create FailSendMsgNotification, type:%d, context==null:%b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.mContext == null);
        C4990ab.m7411d(str, str2, objArr);
        this.oWJ = false;
        AppMethodBeat.m2505o(23194);
    }

    private void bWQ() {
        AppMethodBeat.m2504i(23195);
        this.oWx.f379Fa = true;
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
        this.oWx.mo610a(C25738R.drawable.bdq, this.mContext.getString(C25738R.string.d95), this.oWH);
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
        this.oWx.mo610a(C25738R.drawable.bdr, this.mContext.getString(C25738R.string.d96), this.oWI);
        AppMethodBeat.m2505o(23195);
    }

    public final void bWR() {
        AppMethodBeat.m2504i(23196);
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
        this.oWx.f362EI = this.oWF;
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
        this.oWx.mo611a(this.oWG);
        AppMethodBeat.m2505o(23196);
    }

    public final void bWS() {
        AppMethodBeat.m2504i(23198);
        C4990ab.m7411d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", Boolean.FALSE);
        this.kXv = false;
        AppMethodBeat.m2505o(23198);
    }

    @TargetApi(16)
    public final void show() {
        AppMethodBeat.m2504i(23199);
        if (this.mIsInit) {
            this.oWx.mo625g(this.oWE);
            this.oWx.mo621d(this.mContext.getText(C25738R.string.f9176ru));
            this.oWx.mo616as(FailSendMsgNotification.bWV());
            this.oWx.mo623e(this.oWD);
            this.oWx.mo628z(false);
            this.f17209Fl = this.oWx.build();
            if (VERSION.SDK_INT >= 16 && !this.kXv) {
                this.f17209Fl.priority = 2;
                C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
            }
            C4990ab.m7411d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", Boolean.valueOf(this.kXv));
            C9638aw.getNotification().mo41574a(this.mType, this.f17209Fl, false);
            this.oWJ = true;
            AppMethodBeat.m2505o(23199);
            return;
        }
        C4990ab.m7412e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
        AppMethodBeat.m2505o(23199);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(23200);
        C9638aw.getNotification().cancel(this.mType);
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
        AppMethodBeat.m2505o(23200);
    }

    public final void bWT() {
        AppMethodBeat.m2504i(23201);
        this.oWx.mo627k(2, false);
        this.oWK = false;
        show();
        C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
        AppMethodBeat.m2505o(23201);
    }

    public final void bWU() {
        AppMethodBeat.m2504i(23202);
        this.oWL = true;
        this.oWx = C45186a.m83262bt(this.mContext, C45186a.dgM());
        bWQ();
        bWR();
        AppMethodBeat.m2505o(23202);
    }

    private static int bWV() {
        if (VERSION.SDK_INT < 19) {
            return C25738R.drawable.bdn;
        }
        return C25738R.drawable.bdo;
    }

    /* renamed from: TV */
    public final void mo68888TV(String str) {
        AppMethodBeat.m2504i(23197);
        this.oWD = str;
        show();
        AppMethodBeat.m2505o(23197);
    }
}
