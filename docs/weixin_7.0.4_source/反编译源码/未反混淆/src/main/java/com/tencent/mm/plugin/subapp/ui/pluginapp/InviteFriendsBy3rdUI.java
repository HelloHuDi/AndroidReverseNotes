package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import java.io.RandomAccessFile;

public class InviteFriendsBy3rdUI extends MMPreference implements f, a, b {
    private static int svo = 1;
    private static int svp = 2;
    private static int svq = 3;
    private static int svr = 4;
    private static int svs = 5;
    private static int svt = 0;
    private static int svu = 1;
    private ProgressDialog ehJ = null;
    private int fromScene;
    private ProgressBar mqj = null;
    private ProgressDialog nEK = null;
    private com.tencent.mm.ui.i.a rCx = new com.tencent.mm.ui.i.a();
    private boolean svA = false;
    private boolean svB = false;
    private int svv = 0;
    private Bitmap svw = null;
    private View svx;
    private ImageView svy = null;
    private EditText svz = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public InviteFriendsBy3rdUI() {
        AppMethodBeat.i(25545);
        AppMethodBeat.o(25545);
    }

    public final int JC() {
        return R.xml.ax;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25546);
        super.onCreate(bundle);
        setMMTitle((int) R.string.btf);
        this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
        int i = bo.getInt(g.Nu().getValue("InviteFriendsInviteFlags"), 0);
        h hVar = this.yCw;
        if ((i & 2) <= 0) {
            hVar.aqP("invite_friends_by_message");
        }
        if ((i & 1) <= 0) {
            hVar.aqP("invite_friends_by_mail");
        }
        if ((i & 4) <= 0 || !aD(this.mController.ylL, "com.whatsapp")) {
            hVar.aqP("invite_friends_by_whatsapp");
        }
        if ((i & 8) <= 0 || !r.YX()) {
            hVar.aqP("invite_friends_by_facebook");
        }
        if ((i & 16) <= 0) {
            hVar.aqP("invite_friends_by_twitter");
        }
        hVar.notifyDataSetChanged();
        aw.Rg().a(1803, (f) this);
        aw.Rg().a(1804, (f) this);
        aw.Rg().a(168, (f) this);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25538);
                InviteFriendsBy3rdUI.this.finish();
                AppMethodBeat.o(25538);
                return true;
            }
        });
        AppMethodBeat.o(25546);
    }

    public void onDestroy() {
        AppMethodBeat.i(25547);
        aw.Rg().b(1803, (f) this);
        aw.Rg().b(1804, (f) this);
        aw.Rg().b(168, (f) this);
        if (this.svv == 0) {
            com.tencent.mm.plugin.report.service.h.pYm.e(14035, Integer.valueOf(this.svv), Integer.valueOf(svt), Integer.valueOf(this.fromScene));
        }
        super.onDestroy();
        AppMethodBeat.o(25547);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(25548);
        if ("invite_friends_by_message".equals(preference.mKey)) {
            this.svv = svp;
            Fr(2);
            AppMethodBeat.o(25548);
            return true;
        } else if ("invite_friends_by_mail".equals(preference.mKey)) {
            this.svv = svo;
            Fr(1);
            AppMethodBeat.o(25548);
            return true;
        } else if ("invite_friends_by_whatsapp".equals(preference.mKey)) {
            this.svv = svq;
            Fr(4);
            AppMethodBeat.o(25548);
            return true;
        } else if ("invite_friends_by_facebook".equals(preference.mKey)) {
            this.svv = svr;
            if (r.Za()) {
                this.svB = true;
                Fr(8);
            } else {
                com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.e6v, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(25541);
                        d.b(InviteFriendsBy3rdUI.this.mController.ylL, "account", ".ui.FacebookAuthUI", new Intent());
                        AppMethodBeat.o(25541);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            AppMethodBeat.o(25548);
            return true;
        } else if ("invite_friends_by_twitter".equals(preference.mKey)) {
            this.svv = svs;
            if (this.rCx.dKv()) {
                this.svA = true;
                Fr(16);
            } else {
                com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.ec9, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(25542);
                        InviteFriendsBy3rdUI inviteFriendsBy3rdUI = InviteFriendsBy3rdUI.this;
                        Context context = InviteFriendsBy3rdUI.this.mController.ylL;
                        InviteFriendsBy3rdUI.this.mController.ylL.getString(R.string.tz);
                        inviteFriendsBy3rdUI.nEK = com.tencent.mm.ui.base.h.b(context, InviteFriendsBy3rdUI.this.mController.ylL.getString(R.string.ey0), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        InviteFriendsBy3rdUI.this.rCx.a(InviteFriendsBy3rdUI.this, InviteFriendsBy3rdUI.this.mController.ylL);
                        AppMethodBeat.o(25542);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            AppMethodBeat.o(25548);
            return true;
        } else {
            AppMethodBeat.o(25548);
            return false;
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(25549);
        ab.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!(i == 0 && i2 == 0)) {
            com.tencent.mm.plugin.report.service.h.pYm.e(14035, Integer.valueOf(this.svv), Integer.valueOf(svt), Integer.valueOf(this.fromScene));
        }
        if (mVar.getType() == 1803) {
            if (i == 0 && i2 == 0) {
                String str2;
                String str3;
                Intent intent;
                com.tencent.mm.modelmulti.d dVar = (com.tencent.mm.modelmulti.d) mVar;
                if (bo.isNullOrNil(dVar.title)) {
                    str2 = null;
                } else {
                    str2 = dVar.title;
                }
                dVar = (com.tencent.mm.modelmulti.d) mVar;
                if (bo.isNullOrNil(dVar.content)) {
                    str3 = null;
                } else {
                    str3 = dVar.content;
                }
                String YA = r.YA();
                aw.ZK();
                String str4 = (String) c.Ry().get(6, null);
                if (bo.isNullOrNil(YA)) {
                    YA = str4;
                }
                int i3 = ((com.tencent.mm.modelmulti.d) mVar).fHT;
                if ((i3 & 1) > 0) {
                    if (bo.isNullOrNil(str2)) {
                        str2 = String.format(getString(R.string.cel), new Object[]{r.YB()});
                    }
                    if (bo.isNullOrNil(str3)) {
                        str3 = String.format(getString(R.string.cek), new Object[]{YA});
                    }
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.putExtra("android.intent.extra.SUBJECT", str2);
                    intent2.putExtra("android.intent.extra.TEXT", str3);
                    intent2.setType("plain/text");
                    startActivity(Intent.createChooser(intent2, getString(R.string.cee)));
                    com.tencent.mm.plugin.report.service.h.pYm.e(14035, Integer.valueOf(this.svv), Integer.valueOf(svu), Integer.valueOf(this.fromScene));
                }
                str4 = str3;
                if ((i3 & 2) > 0) {
                    if (bo.isNullOrNil(str4)) {
                        str4 = String.format(getString(R.string.cem), new Object[]{YA});
                    }
                    intent = new Intent("android.intent.action.VIEW");
                    intent.putExtra("sms_body", str4);
                    intent.setType("vnd.android-dir/mms-sms");
                    if (bo.k((Context) this, intent)) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, R.string.e2a, 1).show();
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(14035, Integer.valueOf(this.svv), Integer.valueOf(svu), Integer.valueOf(this.fromScene));
                }
                if ((i3 & 4) > 0) {
                    if (bo.isNullOrNil(str4)) {
                        str4 = String.format(getString(R.string.cem), new Object[]{YA});
                    }
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str4);
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.h.pYm.e(14035, Integer.valueOf(this.svv), Integer.valueOf(svu), Integer.valueOf(this.fromScene));
                }
                if ((i3 & 8) > 0) {
                    if (bo.isNullOrNil(str4)) {
                        if (bo.isNullOrNil(r.YA())) {
                            str4 = getString(R.string.cej);
                        } else {
                            str4 = String.format(getString(R.string.cei), new Object[]{r.YA()});
                        }
                    }
                    str2 = getString(R.string.ceb);
                    if (this.svB) {
                        w(i3, str4, str2);
                        this.svB = false;
                    }
                }
                if ((i3 & 16) > 0) {
                    this.rCx.a((a) this);
                    if (bo.isNullOrNil(str4)) {
                        if (bo.isNullOrNil(r.YA())) {
                            str4 = getString(R.string.cej);
                        } else {
                            str4 = String.format(getString(R.string.cei), new Object[]{r.YA()});
                        }
                    }
                    str2 = getString(R.string.ceg);
                    if (this.svA) {
                        w(i3, str4, str2);
                        this.svA = false;
                    }
                }
            } else {
                com.tencent.mm.ui.base.h.g(this.mController.ylL, R.string.cn3, R.string.tz);
                AppMethodBeat.o(25549);
                return;
            }
        }
        if (mVar.getType() == 1804) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.h.bQ(this, getResources().getString(R.string.ate));
                com.tencent.mm.plugin.report.service.h.pYm.e(14035, Integer.valueOf(this.svv), Integer.valueOf(svu), Integer.valueOf(this.fromScene));
            } else {
                com.tencent.mm.ui.base.h.g(this.mController.ylL, R.string.e3n, R.string.tz);
                AppMethodBeat.o(25549);
                return;
            }
        }
        if (mVar.getType() == 168) {
            if (i != 0 || i2 != 0) {
                AppMethodBeat.o(25549);
                return;
            } else if (this.svy != null) {
                if (this.mqj != null) {
                    this.mqj.setVisibility(8);
                }
                this.svy.setImageBitmap(bIu());
            }
        }
        AppMethodBeat.o(25549);
    }

    private void Fr(int i) {
        AppMethodBeat.i(25550);
        final m dVar = new com.tencent.mm.modelmulti.d(i);
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(25543);
                aw.Rg().c(dVar);
                AppMethodBeat.o(25543);
            }
        });
        aw.Rg().a(dVar, 0);
        AppMethodBeat.o(25550);
    }

    private static boolean aD(Context context, String str) {
        AppMethodBeat.i(25551);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(25551);
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            AppMethodBeat.o(25551);
            return true;
        } catch (NameNotFoundException e) {
            AppMethodBeat.o(25551);
            return false;
        }
    }

    public final void a(com.tencent.mm.ui.i.a.c cVar) {
        AppMethodBeat.i(25553);
        if (this.nEK != null) {
            this.nEK.cancel();
        }
        switch (cVar) {
            case Finished:
                xv(R.string.ey2);
                AppMethodBeat.o(25553);
                return;
            case Canceled:
                AppMethodBeat.o(25553);
                return;
            case Failed:
                xv(R.string.ey1);
                break;
        }
        AppMethodBeat.o(25553);
    }

    public final void b(com.tencent.mm.ui.i.a.c cVar) {
    }

    private static Bitmap bIu() {
        AppMethodBeat.i(25555);
        byte[] Pj = Pj(r.Yz());
        if (Pj == null) {
            AppMethodBeat.o(25555);
            return null;
        }
        Bitmap bQ = com.tencent.mm.sdk.platformtools.d.bQ(Pj);
        AppMethodBeat.o(25555);
        return bQ;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b A:{SYNTHETIC, Splitter:B:19:0x005b} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004f A:{SYNTHETIC, Splitter:B:13:0x004f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] Pj(String str) {
        Throwable e;
        AppMethodBeat.i(25556);
        aw.ZK();
        String XW = c.XW();
        aw.ZK();
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(j.g(XW, c.XX(), "qr_", com.tencent.mm.a.g.x(str.getBytes()), ".png"), "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                }
                AppMethodBeat.o(25556);
                return bArr;
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.InviteFriendsBy3rdUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(25556);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(25556);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            ab.printErrStackTrace("MicroMsg.InviteFriendsBy3rdUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.o(25556);
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.o(25556);
            throw e;
        }
    }

    private static void abr(String str) {
        AppMethodBeat.i(25557);
        aw.ZK();
        aw.Rg().a(new com.tencent.mm.bb.a(str, bo.h((Integer) c.Ry().get(66561, null))), 0);
        AppMethodBeat.o(25557);
    }

    private void xv(int i) {
        AppMethodBeat.i(25552);
        com.tencent.mm.ui.base.h.a(this.mController.ylL, i, (int) R.string.tz, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(25552);
    }

    private void w(final int i, final String str, String str2) {
        AppMethodBeat.i(25554);
        this.svx = View.inflate(this.mController.ylL, R.layout.pn, null);
        this.svz = (EditText) this.svx.findViewById(R.id.b09);
        this.svy = (ImageView) this.svx.findViewById(R.id.b08);
        this.mqj = (ProgressBar) this.svx.findViewById(R.id.a1n);
        ((View) this.svy.getParent()).setVisibility(8);
        this.svz.setText(str);
        this.svw = bIu();
        if (this.svw == null) {
            abr(r.Yz());
            ((ProgressBar) this.svx.findViewById(R.id.a1n)).setVisibility(0);
        } else if (this.svy != null) {
            this.svy.setImageBitmap(this.svw);
        }
        com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, str2, this.svx, getResources().getString(R.string.tf), new q.b() {
            public final void iw(boolean z) {
                AppMethodBeat.i(25539);
                if (z) {
                    InviteFriendsBy3rdUI.a(InviteFriendsBy3rdUI.this, i, InviteFriendsBy3rdUI.this.svz == null ? str : InviteFriendsBy3rdUI.this.svz.getText().toString());
                    AppMethodBeat.o(25539);
                    return;
                }
                AppMethodBeat.o(25539);
            }
        });
        AppMethodBeat.o(25554);
    }

    static /* synthetic */ void a(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, int i, String str) {
        AppMethodBeat.i(25558);
        final m gVar = new com.tencent.mm.modelmulti.g(i, str);
        inviteFriendsBy3rdUI.getString(R.string.tz);
        inviteFriendsBy3rdUI.ehJ = com.tencent.mm.ui.base.h.b((Context) inviteFriendsBy3rdUI, inviteFriendsBy3rdUI.getString(R.string.th), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(25544);
                aw.Rg().c(gVar);
                AppMethodBeat.o(25544);
            }
        });
        aw.Rg().a(gVar, 0);
        AppMethodBeat.o(25558);
    }
}
