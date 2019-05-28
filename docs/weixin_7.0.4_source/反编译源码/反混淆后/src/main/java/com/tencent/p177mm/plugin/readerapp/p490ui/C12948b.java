package com.tencent.p177mm.plugin.readerapp.p490ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p201az.C9064g;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.readerapp.p1015c.C28795c;
import com.tencent.p177mm.plugin.readerapp.p1015c.C39565g;
import com.tencent.p177mm.plugin.readerapp.p1015c.C39565g.C12945a;
import com.tencent.p177mm.plugin.readerapp.p1654b.C46155a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.HelperHeaderPreference;
import com.tencent.p177mm.protocal.protobuf.bko;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.readerapp.ui.b */
public final class C12948b implements C23233a, C4937b {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.b$1 */
    class C129491 implements OnClickListener {
        C129491() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(76785);
            final C44275p b = C30379h.m48458b(C12948b.this.context, C12948b.this.context.getString(C25738R.string.dho), false, null);
            C39565g.m67622a(new C12945a() {
                public final void cdW() {
                    AppMethodBeat.m2504i(76784);
                    b.dismiss();
                    AppMethodBeat.m2505o(76784);
                }
            });
            AppMethodBeat.m2505o(76785);
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.b$2 */
    class C129532 implements OnClickListener {
        C129532() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(76786);
            C7060h.pYm.mo8381e(15413, Integer.valueOf(4), "", "");
            C12948b.m20925u(C12948b.this.context, false);
            AppMethodBeat.m2505o(76786);
        }
    }

    public C12948b(Context context) {
        this.context = context;
    }

    private static boolean isOpen() {
        AppMethodBeat.m2504i(76790);
        if ((C1853r.m3829YK() & SQLiteGlobal.journalSizeLimit) == 0) {
            AppMethodBeat.m2505o(76790);
            return true;
        }
        AppMethodBeat.m2505o(76790);
        return false;
    }

    /* renamed from: kc */
    static void m20924kc(boolean z) {
        AppMethodBeat.m2504i(76791);
        int YF = C1853r.m3824YF();
        if (z) {
            YF &= -1025;
        } else {
            YF |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        C1720g.m3536RP().mo5239Ry().set(40, Integer.valueOf(YF));
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C9064g(26, z ? 2 : 1));
        AppMethodBeat.m2505o(76791);
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(76792);
        C4990ab.m7410d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = ".concat(String.valueOf(str)));
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(76792);
            return false;
        } else if (str.equals("contact_info_readerappnews_view")) {
            Intent intent = new Intent(this.context, ReaderAppUI.class);
            intent.putExtra("type", 20);
            this.context.startActivity(intent);
            C46155a.gkF.mo38844BS();
            AppMethodBeat.m2505o(76792);
            return true;
        } else if (str.equals("contact_info_readerappnews_subscribe")) {
            this.context.startActivity(new Intent(this.context, ReaderAppSubscribeUI.class));
            AppMethodBeat.m2505o(76792);
            return true;
        } else if (str.equals("contact_info_readerappnews_clear_data")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.av_), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C129491(), null);
            AppMethodBeat.m2505o(76792);
            return true;
        } else if (str.equals("contact_info_readerappnews_recv_remind")) {
            boolean z2;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO(str);
            boolean cdX = C28795c.cdX();
            if (cdX) {
                C7060h.pYm.mo8381e(15413, Integer.valueOf(6), "", "");
            } else {
                C7060h.pYm.mo8381e(15413, Integer.valueOf(7), "", "");
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
            C12948b.m20924kc(z);
            AppMethodBeat.m2505o(76792);
            return true;
        } else if (str.equals("contact_info_readerappnews_install")) {
            C7060h.pYm.mo8381e(15413, Integer.valueOf(5), "", "");
            C12948b.m20925u(this.context, true);
            AppMethodBeat.m2505o(76792);
            return true;
        } else if (str.equals("contact_info_readerappnews_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C129532(), null);
            AppMethodBeat.m2505o(76792);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(76792);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.m2504i(76793);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3947np(c7616ad.field_username));
        C1720g.m3536RP().mo5239Ry().mo10118a(this);
        this.ehM = c7616ad;
        this.ehK = c15541f;
        biW();
        AppMethodBeat.m2505o(76793);
        return true;
    }

    private void biW() {
        AppMethodBeat.m2504i(76794);
        boolean isOpen = C12948b.isOpen();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8493a_);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.az8));
        helperHeaderPreference.mo74732sd(isOpen ? 1 : 0);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_readerappnews_recv_remind");
        boolean cdX = C28795c.cdX();
        C4990ab.m7410d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = ".concat(String.valueOf(cdX)));
        checkBoxPreference.uOT = cdX;
        if (isOpen) {
            this.ehK.aqP("contact_info_readerappnews_install");
            AppMethodBeat.m2505o(76794);
            return;
        }
        this.ehK.aqP("contact_info_readerappnews_subscribe");
        this.ehK.aqP("contact_info_readerappnews_view");
        this.ehK.aqP("contact_info_readerappnews_clear_data");
        this.ehK.aqP("contact_info_readerappnews_uninstall");
        this.ehK.aqP("contact_info_readerappnews_recv_remind");
        AppMethodBeat.m2505o(76794);
    }

    /* renamed from: u */
    public static void m20925u(final Context context, final boolean z) {
        AppMethodBeat.m2504i(76795);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        final C129513 c129513 = new C7306ak() {
            final /* synthetic */ C46692p ooo = null;

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(76788);
                if (z) {
                    C12948b.m20924kc(true);
                }
                int YK = C1853r.m3829YK();
                if (z) {
                    YK &= -524289;
                } else {
                    YK |= SQLiteGlobal.journalSizeLimit;
                }
                C1720g.m3536RP().mo5239Ry().set(34, Integer.valueOf(YK));
                bko bko = new bko();
                bko.vCi = SQLiteGlobal.journalSizeLimit;
                if (z) {
                    YK = 0;
                } else {
                    YK = 1;
                }
                bko.wNJ = YK;
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(39, bko));
                if (!z) {
                    final C44275p b = C30379h.m48458b(context, context.getString(C25738R.string.dho), false, null);
                    C39565g.m67622a(new C12945a() {
                        public final void cdW() {
                            AppMethodBeat.m2504i(76787);
                            if (b != null) {
                                b.dismiss();
                            }
                            AppMethodBeat.m2505o(76787);
                        }
                    });
                    C12948b.m20924kc(false);
                }
                if (this.ooo != null) {
                    this.ooo.mo5248a(null, null);
                }
                AppMethodBeat.m2505o(76788);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.m2504i(76789);
                if (b != null) {
                    b.dismiss();
                    c129513.sendEmptyMessage(0);
                }
                AppMethodBeat.m2505o(76789);
            }
        }, 5000);
        AppMethodBeat.m2505o(76795);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(76796);
        C1720g.m3536RP().mo5239Ry().mo10121b(this);
        C46155a.gkF.mo38844BS();
        AppMethodBeat.m2505o(76796);
        return true;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(76797);
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        if (c7298n != C1720g.m3536RP().mo5239Ry() || g <= 0) {
            C4990ab.m7413e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
            AppMethodBeat.m2505o(76797);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.m2505o(76797);
        } else {
            AppMethodBeat.m2505o(76797);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
