package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.readerapp.c.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b implements a, com.tencent.mm.sdk.e.n.b {
    Context context;
    private f ehK;
    private ad ehM;

    public b(Context context) {
        this.context = context;
    }

    private static boolean isOpen() {
        AppMethodBeat.i(76790);
        if ((r.YK() & SQLiteGlobal.journalSizeLimit) == 0) {
            AppMethodBeat.o(76790);
            return true;
        }
        AppMethodBeat.o(76790);
        return false;
    }

    static void kc(boolean z) {
        AppMethodBeat.i(76791);
        int YF = r.YF();
        if (z) {
            YF &= -1025;
        } else {
            YF |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        g.RP().Ry().set(40, Integer.valueOf(YF));
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.az.g(26, z ? 2 : 1));
        AppMethodBeat.o(76791);
    }

    public final boolean IO(String str) {
        boolean z = false;
        AppMethodBeat.i(76792);
        ab.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = ".concat(String.valueOf(str)));
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(76792);
            return false;
        } else if (str.equals("contact_info_readerappnews_view")) {
            Intent intent = new Intent(this.context, ReaderAppUI.class);
            intent.putExtra("type", 20);
            this.context.startActivity(intent);
            com.tencent.mm.plugin.readerapp.b.a.gkF.BS();
            AppMethodBeat.o(76792);
            return true;
        } else if (str.equals("contact_info_readerappnews_subscribe")) {
            this.context.startActivity(new Intent(this.context, ReaderAppSubscribeUI.class));
            AppMethodBeat.o(76792);
            return true;
        } else if (str.equals("contact_info_readerappnews_clear_data")) {
            h.d(this.context, this.context.getString(R.string.av_), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(76785);
                    final p b = h.b(b.this.context, b.this.context.getString(R.string.dho), false, null);
                    com.tencent.mm.plugin.readerapp.c.g.a(new com.tencent.mm.plugin.readerapp.c.g.a() {
                        public final void cdW() {
                            AppMethodBeat.i(76784);
                            b.dismiss();
                            AppMethodBeat.o(76784);
                        }
                    });
                    AppMethodBeat.o(76785);
                }
            }, null);
            AppMethodBeat.o(76792);
            return true;
        } else if (str.equals("contact_info_readerappnews_recv_remind")) {
            boolean z2;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO(str);
            boolean cdX = c.cdX();
            if (cdX) {
                com.tencent.mm.plugin.report.service.h.pYm.e(15413, Integer.valueOf(6), "", "");
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.e(15413, Integer.valueOf(7), "", "");
            }
            if (cdX) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference.uOT = z2;
            if (!cdX) {
                z = true;
            }
            kc(z);
            AppMethodBeat.o(76792);
            return true;
        } else if (str.equals("contact_info_readerappnews_install")) {
            com.tencent.mm.plugin.report.service.h.pYm.e(15413, Integer.valueOf(5), "", "");
            u(this.context, true);
            AppMethodBeat.o(76792);
            return true;
        } else if (str.equals("contact_info_readerappnews_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(76786);
                    com.tencent.mm.plugin.report.service.h.pYm.e(15413, Integer.valueOf(4), "", "");
                    b.u(b.this.context, false);
                    AppMethodBeat.o(76786);
                }
            }, null);
            AppMethodBeat.o(76792);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(76792);
            return false;
        }
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.i(76793);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.np(adVar.field_username));
        g.RP().Ry().a(this);
        this.ehM = adVar;
        this.ehK = fVar;
        biW();
        AppMethodBeat.o(76793);
        return true;
    }

    private void biW() {
        AppMethodBeat.i(76794);
        boolean isOpen = isOpen();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.a_);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.az8));
        helperHeaderPreference.sd(isOpen ? 1 : 0);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_readerappnews_recv_remind");
        boolean cdX = c.cdX();
        ab.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = ".concat(String.valueOf(cdX)));
        checkBoxPreference.uOT = cdX;
        if (isOpen) {
            this.ehK.aqP("contact_info_readerappnews_install");
            AppMethodBeat.o(76794);
            return;
        }
        this.ehK.aqP("contact_info_readerappnews_subscribe");
        this.ehK.aqP("contact_info_readerappnews_view");
        this.ehK.aqP("contact_info_readerappnews_clear_data");
        this.ehK.aqP("contact_info_readerappnews_uninstall");
        this.ehK.aqP("contact_info_readerappnews_recv_remind");
        AppMethodBeat.o(76794);
    }

    public static void u(final Context context, final boolean z) {
        AppMethodBeat.i(76795);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        final AnonymousClass3 anonymousClass3 = new ak() {
            final /* synthetic */ com.tencent.mm.ui.p ooo = null;

            public final void handleMessage(Message message) {
                AppMethodBeat.i(76788);
                if (z) {
                    b.kc(true);
                }
                int YK = r.YK();
                if (z) {
                    YK &= -524289;
                } else {
                    YK |= SQLiteGlobal.journalSizeLimit;
                }
                g.RP().Ry().set(34, Integer.valueOf(YK));
                bko bko = new bko();
                bko.vCi = SQLiteGlobal.journalSizeLimit;
                if (z) {
                    YK = 0;
                } else {
                    YK = 1;
                }
                bko.wNJ = YK;
                ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(39, bko));
                if (!z) {
                    final p b = h.b(context, context.getString(R.string.dho), false, null);
                    com.tencent.mm.plugin.readerapp.c.g.a(new com.tencent.mm.plugin.readerapp.c.g.a() {
                        public final void cdW() {
                            AppMethodBeat.i(76787);
                            if (b != null) {
                                b.dismiss();
                            }
                            AppMethodBeat.o(76787);
                        }
                    });
                    b.kc(false);
                }
                if (this.ooo != null) {
                    this.ooo.a(null, null);
                }
                AppMethodBeat.o(76788);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(76789);
                if (b != null) {
                    b.dismiss();
                    anonymousClass3.sendEmptyMessage(0);
                }
                AppMethodBeat.o(76789);
            }
        }, 5000);
        AppMethodBeat.o(76795);
    }

    public final boolean biV() {
        AppMethodBeat.i(76796);
        g.RP().Ry().b(this);
        com.tencent.mm.plugin.readerapp.b.a.gkF.BS();
        AppMethodBeat.o(76796);
        return true;
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(76797);
        int g = bo.g(obj, 0);
        ab.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        if (nVar != g.RP().Ry() || g <= 0) {
            ab.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
            AppMethodBeat.o(76797);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.o(76797);
        } else {
            AppMethodBeat.o(76797);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
