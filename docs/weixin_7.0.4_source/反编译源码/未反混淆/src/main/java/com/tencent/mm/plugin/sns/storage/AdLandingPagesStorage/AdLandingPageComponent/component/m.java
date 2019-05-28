package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public final class m extends j implements Serializable {
    private View qZG;
    private Button qZH;
    private SnsTextProgressBar qZI;
    a qZJ = new a("apkStateMachine", this.qZK.oAl.getLooper());
    private al qZK = new al("apkStateMachine");
    private b qZL;
    private OnClickListener qZM = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(37100);
            m.this.qZJ.sendMessage(0);
            m.this.cpH();
            AppMethodBeat.o(37100);
        }
    };
    e qZN = new e() {
        public final void ao(Object obj) {
        }

        public final void f(int i, int i2, Object obj) {
            AppMethodBeat.i(37101);
            if (i == 0 && i2 == 0) {
                qc qcVar = new qc();
                try {
                    qcVar.parseFrom((byte[]) obj);
                } catch (IOException e) {
                    ab.e("MicroMsg.AdLandingPageDownloadApkBtnComp", bo.l(e));
                }
                if (!TextUtils.isEmpty(qcVar.vGi)) {
                    ab.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + qcVar.vGi);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", qcVar.vGi);
                    intent.putExtra("showShare", true);
                    d.b(m.this.context, "webview", ".ui.tools.WebViewUI", intent);
                    m.this.qZJ.sendMessage(10);
                    AppMethodBeat.o(37101);
                    return;
                } else if (qcVar.vXh != null) {
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).qVM = qcVar.vXh.kKY;
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).cvZ = qcVar.vXh.kLL;
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).downloadUrl = qcVar.vXh.vXa;
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).fileSize = (long) qcVar.vXh.vXd;
                    m.this.qZJ.sendMessage(6);
                    AppMethodBeat.o(37101);
                    return;
                } else {
                    ab.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp null");
                    m.this.qZJ.sendMessage(5);
                    AppMethodBeat.o(37101);
                    return;
                }
            }
            m.this.qZJ.sendMessage(5);
            AppMethodBeat.o(37101);
        }
    };

    class b extends BroadcastReceiver implements Serializable {
        private b() {
        }

        /* synthetic */ b(m mVar, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(37143);
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    action = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(action) && action.equals(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).Iw)) {
                        m.this.qZJ.sendMessage(3);
                    }
                    AppMethodBeat.o(37143);
                    return;
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    action = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(action) && action.equals(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).Iw)) {
                        m.this.qZJ.sendMessage(4);
                    }
                }
            }
            AppMethodBeat.o(37143);
        }
    }

    class a extends com.tencent.mm.sdk.d.d implements Serializable {
        com.tencent.mm.sdk.d.c qZR = new c();
        com.tencent.mm.sdk.d.c qZS = new g();
        com.tencent.mm.sdk.d.c qZT = new e();
        com.tencent.mm.sdk.d.c qZU = new h();
        com.tencent.mm.sdk.d.c qZV = new i();
        com.tencent.mm.sdk.d.c qZW = new f();
        com.tencent.mm.sdk.d.c qZX = new b();
        com.tencent.mm.sdk.d.c qZY = new a();
        com.tencent.mm.sdk.d.c qZZ = new d();

        class g extends com.tencent.mm.sdk.d.b {
            g() {
            }

            public final void enter() {
                AppMethodBeat.i(37133);
                super.enter();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37129);
                        if (m.this.qZL == null) {
                            m.this.qZL = new b(m.this, (byte) 0);
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                            intentFilter.addDataScheme("package");
                            m.this.context.registerReceiver(m.this.qZL, intentFilter);
                        }
                        AppMethodBeat.o(37129);
                    }
                });
                if (AdLandingPagesProxy.getInstance().isPkgInstalled(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).Iw)) {
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZV);
                    AppMethodBeat.o(37133);
                } else if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZU);
                    AppMethodBeat.o(37133);
                } else if (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZR);
                    AppMethodBeat.o(37133);
                } else if (AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZT);
                    AppMethodBeat.o(37133);
                } else {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37130);
                            m.this.qZI.setVisibility(8);
                            m.this.qZH.setVisibility(0);
                            m.this.qZH.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).title);
                            AppMethodBeat.o(37130);
                        }
                    });
                    AppMethodBeat.o(37133);
                }
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(37134);
                ab.i("LogStateTransitionState", hashCode() + "[ToDownloadState]recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                            a.a(a.this, m.this.context.getString(R.string.eiz));
                        } else {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(37132);
                                    if (NetStatusUtil.isWifi(m.this.context)) {
                                        m.this.qZJ.sendMessage(12);
                                        AppMethodBeat.o(37132);
                                        return;
                                    }
                                    ab.i("LogStateTransitionState", "download not in wifi!");
                                    com.tencent.mm.ui.base.h.a(m.this.context, (int) R.string.fy6, (int) R.string.fy7, new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(37131);
                                            m.this.qZJ.sendMessage(12);
                                            com.tencent.mm.modelstat.d.b(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", g.this.hashCode());
                                            AppMethodBeat.o(37131);
                                        }
                                    }, null);
                                    AppMethodBeat.o(37132);
                                }
                            });
                        }
                        AppMethodBeat.o(37134);
                        return true;
                    case 3:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZV);
                        AppMethodBeat.o(37134);
                        return true;
                    case 11:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZS);
                        AppMethodBeat.o(37134);
                        return true;
                    case 12:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZR);
                        AppMethodBeat.o(37134);
                        return true;
                    default:
                        AppMethodBeat.o(37134);
                        return false;
                }
            }
        }

        class h extends com.tencent.mm.sdk.d.b {
            private boolean rai;

            h() {
            }

            public final void enter() {
                AppMethodBeat.i(37136);
                super.enter();
                if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37135);
                            m.this.qZI.setVisibility(8);
                            m.this.qZH.setVisibility(0);
                            m.this.qZH.setText(R.string.ej2);
                            AppMethodBeat.o(37135);
                        }
                    });
                    this.rai = true;
                    AppMethodBeat.o(37136);
                    return;
                }
                a.this.b((com.tencent.mm.sdk.d.a) a.this.qZS);
                AppMethodBeat.o(37136);
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(37137);
                ab.i("LogStateTransitionState", hashCode() + "[ToInstallState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().installApp(m.this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).Iw, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).cvZ, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).downloadUrl)) {
                            this.rai = true;
                            AppMethodBeat.o(37137);
                            return true;
                        }
                        a.a(a.this, m.this.context.getString(R.string.ej3));
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZW);
                        AppMethodBeat.o(37137);
                        return true;
                    case 2:
                        if (!AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                            a.this.b((com.tencent.mm.sdk.d.a) a.this.qZS);
                        }
                        AppMethodBeat.o(37137);
                        return true;
                    case 3:
                        if (this.rai) {
                            this.rai = false;
                        }
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZV);
                        AppMethodBeat.o(37137);
                        return true;
                    default:
                        AppMethodBeat.o(37137);
                        return false;
                }
            }
        }

        class i extends com.tencent.mm.sdk.d.b {
            i() {
            }

            public final void enter() {
                AppMethodBeat.i(37139);
                super.enter();
                if (AdLandingPagesProxy.getInstance().isPkgInstalled(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).Iw)) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37138);
                            m.this.qZI.setVisibility(8);
                            m.this.qZH.setVisibility(0);
                            m.this.qZH.setText(R.string.ej4);
                            AppMethodBeat.o(37138);
                        }
                    });
                    AppMethodBeat.o(37139);
                    return;
                }
                a.this.b((com.tencent.mm.sdk.d.a) a.this.qZU);
                AppMethodBeat.o(37139);
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(37140);
                ab.i("LogStateTransitionState", hashCode() + "[ToOpenState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (m.this.cpK()) {
                            AppMethodBeat.o(37140);
                            return true;
                        }
                        a.a(a.this, m.this.context.getString(R.string.ej5));
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZV);
                        AppMethodBeat.o(37140);
                        return true;
                    case 4:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZS);
                        AppMethodBeat.o(37140);
                        return true;
                    default:
                        AppMethodBeat.o(37140);
                        return false;
                }
            }
        }

        class a extends com.tencent.mm.sdk.d.b {
            a() {
            }

            public final void enter() {
                AppMethodBeat.i(37108);
                super.enter();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37107);
                        m.this.qZI.setVisibility(8);
                        m.this.qZH.setEnabled(false);
                        m.this.qZH.setText(!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).qVP) ? ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).qVP : "暂不支持安卓手机");
                        m.this.qZH.setVisibility(0);
                        AppMethodBeat.o(37107);
                    }
                });
                AppMethodBeat.o(37108);
            }
        }

        class b extends com.tencent.mm.sdk.d.b {
            b() {
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(37109);
                ab.i("LogStateTransitionState", hashCode() + "[DoNetSceneState]recv msg.what " + message.what);
                if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZU);
                    AppMethodBeat.o(37109);
                    return true;
                }
                switch (message.what) {
                    case 5:
                        a.a(a.this, m.this.context.getString(R.string.ej1));
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZW);
                        AppMethodBeat.o(37109);
                        return true;
                    case 6:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZS);
                        AppMethodBeat.o(37109);
                        return true;
                    case 10:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZS);
                        AppMethodBeat.o(37109);
                        return true;
                    default:
                        AppMethodBeat.o(37109);
                        return false;
                }
            }

            public final void enter() {
                AppMethodBeat.i(37110);
                super.enter();
                AdLandingPagesProxy.getInstance().doAdChannelScene(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).Iw, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).channelId, m.this.qZN);
                ab.i("LogStateTransitionState", hashCode() + "[DoNetSceneState] appid %s, channelId %s", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).Iw, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).channelId);
                AppMethodBeat.o(37110);
            }
        }

        class e extends com.tencent.mm.sdk.d.b {
            e() {
            }

            public final void enter() {
                AppMethodBeat.i(37124);
                super.enter();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37122);
                        m.this.qZI.setVisibility(8);
                        m.this.qZH.setVisibility(0);
                        m.this.qZH.setText(R.string.ej0);
                        AppMethodBeat.o(37122);
                    }
                });
                AppMethodBeat.o(37124);
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(37125);
                ab.i("LogStateTransitionState", hashCode() + "[PauseState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                            a.a(a.this, m.this.context.getString(R.string.eiz));
                        } else if (NetStatusUtil.isWifi(m.this.context)) {
                            a.this.sendMessage(12);
                        } else {
                            ab.i("LogStateTransitionState", "download not in wifi!");
                            com.tencent.mm.ui.base.h.a(m.this.context, (int) R.string.fy6, (int) R.string.fy7, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(37123);
                                    a.this.sendMessage(12);
                                    com.tencent.mm.modelstat.d.b(10, "AdLandingPageDownloadApkBtnComp_PAUSE_MSG_BTN_CLICK", e.this.hashCode());
                                    AppMethodBeat.o(37123);
                                }
                            }, null);
                        }
                        AppMethodBeat.o(37125);
                        return true;
                    case 3:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZV);
                        AppMethodBeat.o(37125);
                        return true;
                    case 8:
                        a.a(a.this, m.this.context.getString(R.string.ej1));
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZW);
                        AppMethodBeat.o(37125);
                        return true;
                    case 12:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZR);
                        AppMethodBeat.o(37125);
                        return true;
                    default:
                        AppMethodBeat.o(37125);
                        return false;
                }
            }
        }

        class c extends com.tencent.mm.sdk.d.b {
            com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a rac;

            class a implements com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a {
                private a() {
                }

                /* synthetic */ a(c cVar, byte b) {
                    this();
                }

                public final void CP(int i) {
                    AppMethodBeat.i(37115);
                    a a = m.this.qZJ;
                    com.tencent.mm.sdk.d.d.c cVar = a.xCt;
                    if (cVar != null) {
                        cVar.sendMessage(Message.obtain(a.xCt, 1, i, 0));
                    }
                    AppMethodBeat.o(37115);
                }

                public final void cmA() {
                    AppMethodBeat.i(37116);
                    ab.i("LogStateTransitionState", "paused");
                    m.this.qZJ.sendMessage(7);
                    AppMethodBeat.o(37116);
                }

                public final void cmB() {
                    AppMethodBeat.i(37117);
                    m.this.qZJ.sendMessage(9);
                    AppMethodBeat.o(37117);
                }

                public final void cmC() {
                    AppMethodBeat.i(37118);
                    m.this.qZJ.sendMessage(8);
                    AppMethodBeat.o(37118);
                }
            }

            c() {
            }

            public final void enter() {
                AppMethodBeat.i(37119);
                super.enter();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37111);
                        m.this.qZH.setVisibility(8);
                        m.this.qZI.setVisibility(0);
                        AppMethodBeat.o(37111);
                    }
                });
                if (AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB) || AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                    if (this.rac == null) {
                        this.rac = new a(this, (byte) 0);
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37112);
                            m.this.qZI.setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB));
                            AppMethodBeat.o(37112);
                        }
                    });
                    if (!AdLandingPagesProxy.getInstance().resumeTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB, this.rac, m.this.cpC().qTL, m.this.cpC().hcx)) {
                        AdLandingPagesProxy.getInstance().stopTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB);
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZR);
                        AppMethodBeat.o(37119);
                        return;
                    }
                } else if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).downloadUrl)) {
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZX);
                    AppMethodBeat.o(37119);
                    return;
                } else if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37113);
                            m.this.qZI.setProgress(100);
                            AppMethodBeat.o(37113);
                        }
                    });
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZU);
                    AppMethodBeat.o(37119);
                    return;
                } else {
                    AdLandingPagesProxy.getInstance().stopTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB);
                    this.rac = new a(this, (byte) 0);
                    AdLandingPagesProxy.getInstance().startDownload(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).Iw, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).cvZ, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).downloadUrl, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).qVM, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).qVN, this.rac, m.this.cpC().qTL, m.this.cpC().hcx);
                }
                AppMethodBeat.o(37119);
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(37120);
                ab.i("LogStateTransitionState", hashCode() + "[DownloadingState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().pauseTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB) && AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                            a.this.b((com.tencent.mm.sdk.d.a) a.this.qZT);
                        }
                        AppMethodBeat.o(37120);
                        return true;
                    case 1:
                        final int i = message.arg1;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(37114);
                                if (i >= 0) {
                                    m.this.qZI.setProgress(i);
                                }
                                AppMethodBeat.o(37114);
                            }
                        });
                        AppMethodBeat.o(37120);
                        return true;
                    case 3:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZV);
                        AppMethodBeat.o(37120);
                        return true;
                    case 7:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZT);
                        AppMethodBeat.o(37120);
                        return true;
                    case 8:
                        a.a(a.this, m.this.context.getString(R.string.ej1));
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZW);
                        AppMethodBeat.o(37120);
                        return true;
                    case 9:
                        m.this.cpL();
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZU);
                        AppMethodBeat.o(37120);
                        return true;
                    default:
                        AppMethodBeat.o(37120);
                        return false;
                }
            }
        }

        class d extends com.tencent.mm.sdk.d.b {
            d() {
            }

            public final void enter() {
                Object obj;
                AppMethodBeat.i(37121);
                super.enter();
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b b = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo);
                if (b.qVO == 0 || b.qVO == 2) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZY);
                    AppMethodBeat.o(37121);
                } else if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB)) {
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZU);
                    AppMethodBeat.o(37121);
                } else if (AdLandingPagesProxy.getInstance().isPkgInstalled(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).Iw)) {
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZV);
                    AppMethodBeat.o(37121);
                } else {
                    a.this.b((com.tencent.mm.sdk.d.a) a.this.qZX);
                    AppMethodBeat.o(37121);
                }
            }
        }

        class f extends com.tencent.mm.sdk.d.b {
            f() {
            }

            public final void enter() {
                AppMethodBeat.i(37127);
                super.enter();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37126);
                        m.this.qZI.setVisibility(8);
                        m.this.qZH.setVisibility(0);
                        m.this.qZH.setText(R.string.ej6);
                        AppMethodBeat.o(37126);
                    }
                });
                AppMethodBeat.o(37127);
            }

            public final boolean k(Message message) {
                AppMethodBeat.i(37128);
                ab.i("LogStateTransitionState", hashCode() + "[ReDownloadState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        a.this.b((com.tencent.mm.sdk.d.a) a.this.qZX);
                        AppMethodBeat.o(37128);
                        return true;
                    default:
                        AppMethodBeat.o(37128);
                        return false;
                }
            }
        }

        protected a(String str, Looper looper) {
            super(str, looper);
            AppMethodBeat.i(37141);
            a(this.qZS);
            a(this.qZR);
            a(this.qZT);
            a(this.qZU);
            a(this.qZV);
            a(this.qZW);
            a(this.qZX);
            a(this.qZY);
            a(this.qZZ);
            b(this.qZZ);
            AppMethodBeat.o(37141);
        }

        static /* synthetic */ void a(a aVar, final String str) {
            AppMethodBeat.i(37142);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(37106);
                    com.tencent.mm.ui.base.h.bQ(m.this.context, str);
                    AppMethodBeat.o(37106);
                }
            });
            AppMethodBeat.o(37142);
        }
    }

    public m(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b bVar, ViewGroup viewGroup) {
        super(context, bVar, viewGroup);
        AppMethodBeat.i(37144);
        AppMethodBeat.o(37144);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.aty;
    }

    public final void cpa() {
        AppMethodBeat.i(37147);
        super.cpa();
        this.qZJ.sendMessage(2);
        AdLandingPagesProxy.getInstance().addReportInfo(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).csB, cpC().qTL, cpC().hcx);
        AppMethodBeat.o(37147);
    }

    public final void coZ() {
        AppMethodBeat.i(37148);
        super.coZ();
        ab.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
        this.qZK.oAl.quit();
        if (this.qZL != null) {
            this.context.unregisterReceiver(this.qZL);
            this.qZL = null;
        }
        AppMethodBeat.o(37148);
    }

    public final boolean cpK() {
        AppMethodBeat.i(37149);
        if (this.context == null || TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).csB) || TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).Iw)) {
            AppMethodBeat.o(37149);
            return false;
        }
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVZ)) {
            com.tencent.mm.ce.a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(37105);
                    g.a(m.this.context, m.this.context.getPackageManager().getLaunchIntentForPackage(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).Iw), g.t(m.this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB), new aj() {
                        public final void dR(boolean z) {
                            AppMethodBeat.i(37104);
                            if (!z) {
                                ad.eQ(m.this.context);
                            }
                            AppMethodBeat.o(37104);
                        }
                    });
                    AppMethodBeat.o(37105);
                }
            });
        } else {
            final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVZ));
            intent.addFlags(268435456);
            List H = bo.H(this.context, intent);
            if (!(H == null || H.isEmpty())) {
                Object b;
                if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
                    b = g.b((ResolveInfo) H.get(0));
                } else {
                    b = intent.getPackage();
                }
                if (!bo.nullAsNil(ah.getPackageName()).equals(b)) {
                    com.tencent.mm.ce.a.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37103);
                            g.a(m.this.context, intent, g.t(m.this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) m.this.qZo).csB), new aj() {
                                public final void dR(boolean z) {
                                    AppMethodBeat.i(37102);
                                    if (!z) {
                                        ad.eQ(m.this.context);
                                    }
                                    AppMethodBeat.o(37102);
                                }
                            });
                            AppMethodBeat.o(37103);
                        }
                    });
                }
            }
        }
        AdLandingPagesProxy.getInstance().reportDownloadInfo(9, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).csB);
        AppMethodBeat.o(37149);
        return true;
    }

    public final void cpL() {
        AppMethodBeat.i(37150);
        ab.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
        AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).Iw, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVZ);
        AppMethodBeat.o(37150);
    }

    private static String gi(String str, String str2) {
        AppMethodBeat.i(37151);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(37151);
            return str2;
        } else if (str.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?")) {
            AppMethodBeat.o(37151);
            return str;
        } else {
            AppMethodBeat.o(37151);
            return str2;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37145);
        HashMap hashMap = new HashMap();
        hashMap.put("fontNormalColor", gi(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVW, "#FFFFFF"));
        hashMap.put("fontDisableColor", gi(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVX, "#4CFFFFFF"));
        hashMap.put("fontPressedColor", gi(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVY, "#99FFFFFF"));
        hashMap.put("NormalColor", gi(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVQ, "#1AAD19"));
        hashMap.put("PressedColor", gi(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVS, "#179B16"));
        hashMap.put("DisableColor", gi(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVR, "#661AAD19"));
        hashMap.put("borderNormalColor", gi(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVT, "#179E16"));
        hashMap.put("borderPressedColor", gi(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVV, "#158E14"));
        hashMap.put("borderDisableColor", gi(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVU, "#00179E16"));
        int parseColor = Color.parseColor((String) hashMap.get("fontNormalColor"));
        int parseColor2 = Color.parseColor((String) hashMap.get("fontDisableColor"));
        int parseColor3 = Color.parseColor((String) hashMap.get("fontPressedColor"));
        int parseColor4 = Color.parseColor((String) hashMap.get("NormalColor"));
        int parseColor5 = Color.parseColor((String) hashMap.get("PressedColor"));
        int parseColor6 = Color.parseColor((String) hashMap.get("DisableColor"));
        int i = (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qWo;
        int parseColor7 = Color.parseColor((String) hashMap.get("borderNormalColor"));
        int parseColor8 = Color.parseColor((String) hashMap.get("borderPressedColor"));
        int parseColor9 = Color.parseColor((String) hashMap.get("borderDisableColor"));
        int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.e6);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable.setColor(parseColor6);
        gradientDrawable.setStroke(i, parseColor9);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable2.setColor(parseColor5);
        gradientDrawable2.setStroke(i, parseColor8);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable3.setColor(parseColor4);
        gradientDrawable3.setStroke(i, parseColor7);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{16842910}, gradientDrawable3);
        this.qZH.setBackground(stateListDrawable);
        int[] iArr = new int[]{parseColor2, parseColor3, parseColor};
        r2 = new int[3][];
        r2[0] = new int[]{-16842910};
        r2[1] = new int[]{16842919};
        r2[2] = new int[]{16842910};
        this.qZH.setTextColor(new ColorStateList(r2, iArr));
        gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable2.setColor(parseColor5);
        gradientDrawable2.setStroke(i, parseColor8);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable4.setColor(parseColor4);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable4, 3, 1);
        gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable4.setColor(parseColor4);
        ClipDrawable clipDrawable2 = new ClipDrawable(gradientDrawable4, 3, 1);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable2, clipDrawable, clipDrawable2});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.qZI.setProgressDrawable(layerDrawable);
        this.qZI.setPaintColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).qVY);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).height > 0.0f) {
            LayoutParams layoutParams = (LayoutParams) this.qZG.getLayoutParams();
            layoutParams.height = (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).height;
            this.qZG.setLayoutParams(layoutParams);
        }
        this.qZH.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qZo).title);
        this.qZJ.sendMessage(11);
        AppMethodBeat.o(37145);
    }

    @TargetApi(17)
    public final void cpk() {
        AppMethodBeat.i(37146);
        this.clickCount = 0;
        View view = this.contentView;
        this.qZG = view.findViewById(R.id.ef5);
        this.qZH = (Button) view.findViewById(R.id.at4);
        this.qZH.setOnClickListener(this.qZM);
        this.qZI = (SnsTextProgressBar) view.findViewById(R.id.ef6);
        this.qZI.setProgress(0);
        this.qZI.setVisibility(8);
        this.qZI.setOnClickListener(this.qZM);
        this.qZJ.start();
        AppMethodBeat.o(37146);
    }
}
