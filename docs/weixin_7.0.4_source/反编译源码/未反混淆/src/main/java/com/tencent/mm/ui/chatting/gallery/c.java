package com.tencent.mm.ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.f;
import com.tencent.mm.at.l;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.b.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.gallery.k.AnonymousClass5;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class c extends u {
    public static long jMj = -1;
    public static boolean mgP = false;
    private String egE = null;
    private ArrayList<bi> mnX = new ArrayList();
    public ImageGalleryUI yTI;
    protected a yTJ;
    private String yTK;
    boolean yTL = true;
    public boolean yTM = false;
    public e yTN;
    public j yTO;
    public i yTP;
    public c yTQ;
    boolean yTR;
    protected boolean yTS = true;
    private e yTT = null;

    public static class a {
        int enb;
        ak handler = new ak();
        private int min;
        protected boolean prepared = false;
        private String talker;
        private List<bi> yTY;
        int yTZ;
        protected int yUa;
        protected int yUb;
        protected int yUc;
        protected long yUd;
        private c yUe;
        public HashMap<Long, com.tencent.mm.at.e> yUf = new HashMap();
        public HashMap<Long, com.tencent.mm.at.e> yUg = new HashMap();

        public a(long j, String str, final c cVar, Boolean bool) {
            AppMethodBeat.i(31966);
            this.talker = str;
            this.yTY = new LinkedList();
            this.yUe = cVar;
            aw.ZK();
            bi jf = com.tencent.mm.model.c.XO().jf(j);
            if (jf.field_msgId == 0) {
                Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + j + ", stack = " + bo.dpG(), false);
                AppMethodBeat.o(31966);
                return;
            }
            this.yTY.add(jf);
            final long j2 = j;
            final Boolean bool2 = bool;
            final c cVar2 = cVar;
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31964);
                    a.a(a.this, j2);
                    if (bool2.booleanValue()) {
                        a.this.handler.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(31963);
                                a.a(a.this);
                                if (cVar2.yTQ != null) {
                                    cVar2.yTQ.pL();
                                }
                                AppMethodBeat.o(31963);
                            }
                        }, 0);
                    }
                    AppMethodBeat.o(31964);
                }
            });
            cVar.yTI.yWm = new com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.a() {
                public final void l(Boolean bool) {
                    AppMethodBeat.i(31965);
                    ab.i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(bool)));
                    if (!bool.booleanValue()) {
                        a.a(a.this);
                        if (cVar.yTQ != null) {
                            cVar.yTQ.pL();
                        }
                    }
                    AppMethodBeat.o(31965);
                }
            };
            AppMethodBeat.o(31966);
        }

        private void fa(List<bi> list) {
            AppMethodBeat.i(31967);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                if (c.c((bi) list.get(i))) {
                    arrayList.add(Long.valueOf(((bi) list.get(i)).field_msgSvrId));
                    if (((bi) list.get(i)).field_isSend == 1) {
                        arrayList2.add(Long.valueOf(((bi) list.get(i)).field_msgId));
                    }
                }
            }
            this.yUf.putAll(o.ahl().a((Long[]) arrayList.toArray(new Long[0])));
            this.yUg.putAll(o.ahl().b((Long[]) arrayList2.toArray(new Long[0])));
            AppMethodBeat.o(31967);
        }

        public final void a(long j, com.tencent.mm.at.e eVar, boolean z) {
            AppMethodBeat.i(31968);
            if (z) {
                this.yUf.put(Long.valueOf(j), eVar);
                AppMethodBeat.o(31968);
                return;
            }
            this.yUg.put(Long.valueOf(j), eVar);
            AppMethodBeat.o(31968);
        }

        public final int OU(int i) {
            return (i - 100000) + this.yTZ;
        }

        public final bi OV(int i) {
            AppMethodBeat.i(31969);
            int OU = OU(i);
            int size = (this.min + this.yTY.size()) - 1;
            if (OU < this.min || OU > size) {
                ab.e("MicroMsg.AutoList", "get, invalid pos " + OU + ", min = " + this.min + ", max = " + size);
                AppMethodBeat.o(31969);
                return null;
            }
            ab.d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(OU)));
            bi biVar;
            if (OU == this.min) {
                biVar = (bi) this.yTY.get(0);
                if (this.prepared) {
                    C(biVar.field_msgId, false);
                }
                AppMethodBeat.o(31969);
                return biVar;
            } else if (OU != size || size >= this.enb - 1) {
                biVar = (bi) this.yTY.get(OU - this.min);
                AppMethodBeat.o(31969);
                return biVar;
            } else {
                biVar = (bi) this.yTY.get(this.yTY.size() - 1);
                if (this.prepared) {
                    C(biVar.field_msgId, true);
                }
                AppMethodBeat.o(31969);
                return biVar;
            }
        }

        public final void dFM() {
            this.prepared = false;
        }

        private void C(long j, boolean z) {
            List b;
            AppMethodBeat.i(31970);
            ab.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + j + ", forward = " + z);
            if (c.mgP) {
                aw.ZK();
                b = com.tencent.mm.model.c.XP().b(this.talker, c.jMj, j, z);
            } else {
                aw.ZK();
                b = com.tencent.mm.model.c.XO().g(this.talker, j, z);
            }
            if (b == null || b.size() == 0) {
                ab.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(z)));
                AppMethodBeat.o(31970);
                return;
            }
            ab.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + b.size() + ", forward = " + z);
            long currentTimeMillis = System.currentTimeMillis();
            fa(b);
            ab.i("MicroMsg.AutoList", "loadImgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (z) {
                this.yTY.addAll(b);
                AppMethodBeat.o(31970);
                return;
            }
            this.yTY.addAll(0, b);
            this.min -= b.size();
            if (this.min < 0) {
                ab.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.min);
                AppMethodBeat.o(31970);
                return;
            }
            ab.i("MicroMsg.AutoList", "min from " + (b.size() + this.min) + " to " + this.min);
            AppMethodBeat.o(31970);
        }

        public final String toString() {
            AppMethodBeat.i(31971);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AutoList, Size = " + this.yTY.size());
            stringBuilder.append("; Content = {");
            for (bi biVar : this.yTY) {
                stringBuilder.append(biVar.field_msgId);
                stringBuilder.append(",");
            }
            stringBuilder.append("}");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(31971);
            return stringBuilder2;
        }

        static /* synthetic */ void a(a aVar, long j) {
            AppMethodBeat.i(31972);
            long currentTimeMillis = System.currentTimeMillis();
            ab.i("MicroMsg.AutoList", "isBizChat = " + c.mgP);
            if (c.mgP) {
                aw.ZK();
                aVar.yUa = com.tencent.mm.model.c.XP().aS(aVar.talker, c.jMj);
            } else {
                aw.ZK();
                aVar.yUa = com.tencent.mm.model.c.XO().Rq(aVar.talker);
            }
            ab.i("MicroMsg.AutoList", "<init>, totalCount = " + aVar.yUa);
            ab.i("MicroMsg.AutoList", "totalCount spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (c.mgP) {
                aw.ZK();
                aVar.yUb = com.tencent.mm.model.c.XP().z(aVar.talker, c.jMj, j);
            } else {
                aw.ZK();
                aVar.yUb = com.tencent.mm.model.c.XO().ac(aVar.talker, j);
            }
            ab.i("MicroMsg.AutoList", "min spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            if (System.currentTimeMillis() - currentTimeMillis2 > 1000) {
                aw.ZK();
                String ad = com.tencent.mm.model.c.XO().ad(aVar.talker, j);
                ab.w("MicroMsg.AutoList", "explain : %s", ad);
            }
            aVar.yUc = aVar.yUb;
            aVar.yUd = j;
            AppMethodBeat.o(31972);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(31973);
            aVar.prepared = true;
            aVar.enb = aVar.yUa;
            aVar.min = aVar.yUb;
            aVar.yTZ = aVar.yUc;
            ab.i("MicroMsg.AutoList", "totalCount %s min %s start %s", Integer.valueOf(aVar.enb), Integer.valueOf(aVar.min), Integer.valueOf(aVar.yTZ));
            long currentTimeMillis = System.currentTimeMillis();
            ab.i("MicroMsg.AutoList", "min spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            aVar.C(aVar.yUd, true);
            ab.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            aVar.C(aVar.yUd, false);
            ab.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            aVar.yUe.notifyDataSetChanged();
            if (!aVar.yUe.yTI.isFinishing()) {
                aVar.yUe.d(99999, (View) aVar.yUe.yyL.get(99999));
            }
            AppMethodBeat.o(31973);
        }
    }

    public enum b {
        unkown,
        image,
        video,
        sight,
        appimage;

        static {
            AppMethodBeat.o(31976);
        }
    }

    public interface c {
        void pL();
    }

    public c(ImageGalleryUI imageGalleryUI, long j, String str, boolean z, long j2, boolean z2, String str2, Boolean bool) {
        AppMethodBeat.i(31977);
        String str3 = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + imageGalleryUI + ", currentMsgId = " + j + ", talker = " + str + ", stack = " + bo.dpG();
        boolean z3 = j > 0 && str != null && str.length() > 0;
        Assert.assertTrue(str3, z3);
        this.yTI = imageGalleryUI;
        mgP = z;
        jMj = j2;
        this.egE = str;
        this.yTJ = new a(j, str, this, bool);
        this.yTM = z2;
        this.yTK = str2;
        this.yTN = new e(this);
        this.yTO = new j(this);
        this.yTP = new i(this);
        AppMethodBeat.o(31977);
    }

    public final void onPageSelected(int i) {
        AppMethodBeat.i(31978);
        if (this.yTN != null && c(Ou(i))) {
            this.yTN.yVa.onPageSelected(i);
        }
        AppMethodBeat.o(31978);
    }

    public final int getCount() {
        a aVar = this.yTJ;
        return ((aVar.enb - aVar.yTZ) + 100000) + 1;
    }

    public final int getRealCount() {
        return this.yTJ.enb;
    }

    public final bi Ou(int i) {
        AppMethodBeat.i(31979);
        bi OV = this.yTJ.OV(i);
        AppMethodBeat.o(31979);
        return OV;
    }

    public final void dFM() {
        AppMethodBeat.i(31980);
        this.yTJ.dFM();
        AppMethodBeat.o(31980);
    }

    public final com.tencent.mm.at.e f(bi biVar, boolean z) {
        AppMethodBeat.i(31981);
        com.tencent.mm.at.e f = this.yTN.f(biVar, z);
        AppMethodBeat.o(31981);
        return f;
    }

    public static boolean c(bi biVar) {
        AppMethodBeat.i(31982);
        if (biVar == null) {
            AppMethodBeat.o(31982);
            return false;
        } else if (biVar.getType() == 3 || biVar.getType() == 39 || biVar.getType() == 13) {
            AppMethodBeat.o(31982);
            return true;
        } else {
            AppMethodBeat.o(31982);
            return false;
        }
    }

    public static boolean f(bi biVar) {
        AppMethodBeat.i(31983);
        if (biVar == null) {
            AppMethodBeat.o(31983);
            return false;
        } else if (bu(biVar)) {
            AppMethodBeat.o(31983);
            return false;
        } else if (biVar.getType() == 43 || biVar.getType() == 44 || biVar.getType() == 62) {
            AppMethodBeat.o(31983);
            return true;
        } else {
            AppMethodBeat.o(31983);
            return false;
        }
    }

    public static boolean bp(bi biVar) {
        AppMethodBeat.i(31984);
        if (biVar == null) {
            AppMethodBeat.o(31984);
            return false;
        } else if (biVar.getType() == 62) {
            AppMethodBeat.o(31984);
            return true;
        } else {
            AppMethodBeat.o(31984);
            return false;
        }
    }

    public static boolean bq(bi biVar) {
        AppMethodBeat.i(31985);
        if (biVar == null) {
            AppMethodBeat.o(31985);
            return false;
        } else if (biVar.getType() == 49) {
            AppMethodBeat.o(31985);
            return true;
        } else {
            AppMethodBeat.o(31985);
            return false;
        }
    }

    public static boolean br(bi biVar) {
        AppMethodBeat.i(31986);
        if (biVar == null) {
            AppMethodBeat.o(31986);
            return false;
        } else if (biVar.getType() == 268435505) {
            AppMethodBeat.o(31986);
            return true;
        } else {
            AppMethodBeat.o(31986);
            return false;
        }
    }

    public final boolean bs(bi biVar) {
        AppMethodBeat.i(31987);
        if (biVar == null) {
            AppMethodBeat.o(31987);
            return false;
        }
        com.tencent.mm.at.e f = f(biVar, false);
        if (f == null) {
            s bG = j.bG(biVar);
            if (bG == null) {
                AppMethodBeat.o(31987);
                return false;
            } else if (bG == null) {
                AppMethodBeat.o(31987);
                return false;
            } else {
                int i = bG.status;
                boolean z = (i == 112 || i == 122) && com.tencent.mm.modelvideo.u.g(bG) < 100;
                ab.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(r2));
                AppMethodBeat.o(31987);
                return z;
            }
        } else if (biVar == null || f == null) {
            AppMethodBeat.o(31987);
            return false;
        } else if (o.ahm().a(f.fDy, biVar.field_msgId, 0) || b(biVar, f)) {
            AppMethodBeat.o(31987);
            return true;
        } else {
            AppMethodBeat.o(31987);
            return false;
        }
    }

    public static boolean b(bi biVar, com.tencent.mm.at.e eVar) {
        AppMethodBeat.i(31988);
        if (biVar == null || eVar == null) {
            AppMethodBeat.o(31988);
            return false;
        }
        boolean a = o.ahm().a(eVar.fDy, biVar.field_msgId, 1);
        AppMethodBeat.o(31988);
        return a;
    }

    public final void OL(int i) {
        AppMethodBeat.i(31989);
        bi Ou = Ou(i);
        switch (bt(Ou)) {
            case video:
            case sight:
                bv(Ou);
                AppMethodBeat.o(31989);
                return;
            case appimage:
                String e = e(Ou);
                Intent intent = new Intent(this.yTI, MsgRetransmitUI.class);
                intent.putExtra("Retr_File_Name", e);
                intent.putExtra("Retr_Msg_Id", Ou.field_msgId);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_content", Ou.field_content);
                intent.putExtra("Retr_Compress_Type", 0);
                this.yTI.startActivity(intent);
                AppMethodBeat.o(31989);
                return;
            default:
                bw(Ou);
                AppMethodBeat.o(31989);
                return;
        }
    }

    public final void OM(int i) {
        AppMethodBeat.i(31990);
        bi Ou = Ou(i);
        switch (bt(Ou)) {
            case video:
            case sight:
            case image:
                Intent intent = new Intent(this.yTI, ChattingSendDataToDeviceUI.class);
                intent.putExtra("Retr_Msg_Id", Ou.field_msgId);
                this.yTI.startActivity(intent);
                break;
        }
        AppMethodBeat.o(31990);
    }

    public static b bt(bi biVar) {
        AppMethodBeat.i(31991);
        b bVar = b.unkown;
        if (biVar == null) {
            bVar = b.unkown;
        }
        if (br(biVar)) {
            bVar = b.appimage;
            AppMethodBeat.o(31991);
            return bVar;
        } else if (c(biVar)) {
            bVar = b.image;
            AppMethodBeat.o(31991);
            return bVar;
        } else if (bu(biVar)) {
            bVar = b.sight;
            AppMethodBeat.o(31991);
            return bVar;
        } else if (f(biVar)) {
            bVar = b.video;
            AppMethodBeat.o(31991);
            return bVar;
        } else if (bp(biVar)) {
            bVar = b.video;
            AppMethodBeat.o(31991);
            return bVar;
        } else {
            bVar = b.unkown;
            AppMethodBeat.o(31991);
            return bVar;
        }
    }

    private static boolean bu(bi biVar) {
        AppMethodBeat.i(31992);
        if (biVar != null) {
            s ut = com.tencent.mm.modelvideo.u.ut(biVar.field_imgPath);
            if (!(ut == null || ut.fXm == null || (bo.isNullOrNil(ut.fXm.fiG) && ut.fXm.wid <= 0 && bo.isNullOrNil(ut.fXm.fiJ) && bo.isNullOrNil(ut.fXm.fiK) && bo.isNullOrNil(ut.fXm.fiI) && bo.isNullOrNil(ut.fXm.fiL) && bo.isNullOrNil(ut.fXm.fiM) && bo.isNullOrNil(ut.fXm.fiN)))) {
                AppMethodBeat.o(31992);
                return true;
            }
        }
        AppMethodBeat.o(31992);
        return false;
    }

    public final void bv(bi biVar) {
        AppMethodBeat.i(31993);
        aw.ZK();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            s ut = com.tencent.mm.modelvideo.u.ut(biVar.field_imgPath);
            if (ut == null) {
                ab.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
                AppMethodBeat.o(31993);
                return;
            }
            Intent intent = new Intent(this.yTI, MsgRetransmitUI.class);
            intent.putExtra("Retr_length", ut.fXd);
            intent.putExtra("Retr_File_Name", biVar.field_imgPath);
            intent.putExtra("Retr_video_isexport", ut.fXh);
            intent.putExtra("Retr_Msg_Type", bp(biVar) ? 11 : 1);
            intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
            intent.putExtra("Retr_From", "gallery");
            this.yTI.startActivity(intent);
            AppMethodBeat.o(31993);
            return;
        }
        t.hO(this.yTI);
        AppMethodBeat.o(31993);
    }

    private void j(String str, int i, long j) {
        AppMethodBeat.i(31994);
        Intent intent;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ImageGalleryAdapter", "doRestransmitImg fail, imgPath is null");
            AppMethodBeat.o(31994);
        } else if (bo.isNullOrNil(this.yTK)) {
            ab.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
            intent = new Intent(this.yTI, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", str);
            intent.putExtra("Retr_Msg_Id", j);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_Compress_Type", i);
            this.yTI.startActivity(intent);
            AppMethodBeat.o(31994);
        } else {
            ab.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", this.yTK);
            if (!bo.isNullOrNil(str)) {
                aw.Rg().a(new l(r.Yz(), this.yTK, str, i), 0);
                bv.aaq().c(bv.fnv, null);
            }
            if (this.yTL) {
                intent = new Intent(this.yTI, ChattingUI.class);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", this.yTK);
                this.yTI.startActivity(intent);
            } else {
                h.bQ(this.yTI, this.yTI.getString(R.string.td));
            }
            com.tencent.mm.plugin.report.service.h.pYm.e(10424, Integer.valueOf(3), Integer.valueOf(4), this.yTK);
            AppMethodBeat.o(31994);
        }
    }

    public static boolean f(Context context, List<bi> list) {
        AppMethodBeat.i(31996);
        if (context == null || list == null || list.size() <= 0) {
            AppMethodBeat.o(31996);
            return false;
        }
        boolean z = list.size() <= 1;
        boolean z2 = false;
        for (bi biVar : list) {
            boolean a;
            if (f(biVar)) {
                a = a(context, biVar, z);
            } else {
                a = b(context, biVar, z);
            }
            if (z2 || !a) {
                a = z2;
            } else {
                a = true;
            }
            z2 = a;
        }
        if (!z2 && !z) {
            Toast.makeText(context, context.getString(R.string.dww), 1).show();
        } else if (z2 && !z) {
            Toast.makeText(context, context.getString(R.string.biq, new Object[]{com.tencent.mm.compatible.util.e.euR}), 1).show();
        }
        AppMethodBeat.o(31996);
        return true;
    }

    public static boolean a(Context context, bi biVar, boolean z) {
        AppMethodBeat.i(31997);
        if (biVar == null) {
            AppMethodBeat.o(31997);
            return false;
        }
        s uf = com.tencent.mm.modelvideo.o.all().uf(biVar.field_imgPath);
        boolean z2 = false;
        if (uf != null) {
            int i = 0;
            if (com.tencent.mm.model.t.kH(uf.getUser())) {
                i = n.mA(uf.getUser());
            }
            boolean alz = uf.alz();
            com.tencent.mm.plugin.report.service.h.pYm.a(106, 216, 1, false);
            com.tencent.mm.plugin.report.service.h.pYm.e(12084, Integer.valueOf(uf.frO), Integer.valueOf(uf.fXd * 1000), Integer.valueOf(0), Integer.valueOf(2), uf.getUser(), Integer.valueOf(i), s.ue(uf.alw()), Long.valueOf(uf.createTime));
            z2 = alz;
        }
        if (z2) {
            com.tencent.mm.modelvideo.o.all();
            String uu = com.tencent.mm.modelvideo.u.uu(com.tencent.mm.modelvideo.t.uh(biVar.field_imgPath));
            if (bo.isNullOrNil(uu)) {
                if (z) {
                    Toast.makeText(context, context.getString(R.string.f1c), 1).show();
                }
                AppMethodBeat.o(31997);
                return false;
            }
            if (z) {
                Toast.makeText(context, context.getString(R.string.f1d, new Object[]{uu}), 1).show();
            }
            com.tencent.mm.pluginsdk.ui.tools.n.a(uu, context);
            AppMethodBeat.o(31997);
            return true;
        }
        ab.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
        if (z) {
            Toast.makeText(context, context.getString(R.string.f1c), 1).show();
        }
        AppMethodBeat.o(31997);
        return false;
    }

    public static boolean b(Context context, bi biVar, boolean z) {
        String e;
        AppMethodBeat.i(31998);
        if (br(biVar)) {
            e = e(biVar);
        } else if (biVar == null || biVar.field_msgId == 0) {
            ab.e("MicroMsg.ImageGalleryAdapter", "msg is null");
            if (z) {
                Toast.makeText(context, context.getString(R.string.dwv), 1).show();
            }
            AppMethodBeat.o(31998);
            return false;
        } else {
            com.tencent.mm.at.e d = e.d(biVar);
            if (d == null || d.fDy == 0) {
                ab.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, msgLocalId = " + (biVar == null ? BuildConfig.COMMAND : Long.valueOf(biVar.field_msgId)) + ", imgLocalId = " + (d == null ? BuildConfig.COMMAND : Long.valueOf(d.fDy)));
                if (z) {
                    Toast.makeText(context, context.getString(R.string.dwv), 1).show();
                }
                AppMethodBeat.o(31998);
                return false;
            }
            e = e.a(biVar, d);
        }
        if (e == null || e.length() == 0) {
            ab.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + biVar.field_msgId);
            if (z) {
                Toast.makeText(context, context.getString(R.string.dwv), 1).show();
            }
            AppMethodBeat.o(31998);
            return false;
        } else if (q.a(e, context, z, R.string.b3r)) {
            AppMethodBeat.o(31998);
            return true;
        } else {
            if (z) {
                Toast.makeText(context, context.getString(R.string.dwv), 1).show();
            }
            AppMethodBeat.o(31998);
            return false;
        }
    }

    public final void ON(int i) {
        AppMethodBeat.i(31999);
        bi Ou = Ou(i);
        cl clVar = new cl();
        com.tencent.mm.pluginsdk.model.e.d(clVar, Ou);
        clVar.cvA.activity = this.yTI;
        clVar.cvA.cvH = 44;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        if (clVar.cvB.ret == 0) {
            if (Ou.bwt()) {
                com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, d.Full, Ou, 0);
            }
            com.tencent.mm.modelstat.b.fRa.D(Ou);
        }
        AppMethodBeat.o(31999);
    }

    public final View d(int i, View view) {
        k kVar;
        AppMethodBeat.i(TXRecordCommon.AUDIO_SAMPLERATE_32000);
        final bi Ou = Ou(i);
        if (view == null) {
            view = View.inflate(this.yTI, R.layout.a7o, null);
            kVar = new k(this, view);
            view.setTag(kVar);
        } else {
            kVar = (k) view.getTag();
        }
        b bt = bt(Ou);
        kVar.mPosition = i;
        kVar.yXe = bt;
        k.am(kVar.mRR, 0);
        switch (AnonymousClass5.yTX[bt.ordinal()]) {
            case 1:
                k.am(kVar.yXm, 8);
                k.am(kVar.yXg, 8);
                break;
            case 2:
                kVar.dGH();
                k.am(kVar.yXm, 0);
                k.am(kVar.yXg, 8);
                if (kVar.yXg != null) {
                    k.am(kVar.yXi, 8);
                    break;
                }
                break;
            case 3:
                kVar.dGG();
                k.am(kVar.yXm, 8);
                k.am(kVar.yXg, 0);
                break;
            case 4:
                k.am(kVar.mRR, 8);
                k.am(kVar.yXm, 8);
                k.am(kVar.yXg, 8);
                break;
        }
        k.am(kVar.yXB, 8);
        k.am(kVar.yXC, 8);
        k.am(kVar.yXD, 8);
        k.am(kVar.yXs, 8);
        k.am(kVar.yXy, 8);
        k.am(kVar.yXx, 8);
        ab.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", Integer.valueOf(i), bt);
        switch (bt) {
            case video:
                this.yTO.a(kVar, Ou, i);
                break;
            case sight:
                this.yTP.a(kVar, Ou, i);
                break;
            case appimage:
                Bitmap vw;
                k.am(kVar.yXB, 0);
                k.am(kVar.yXs, 8);
                k.am(kVar.yXx, 8);
                k.am(kVar.yXy, 8);
                k.am(kVar.yXq, 8);
                final String e = e(Ou);
                try {
                    vw = x.vw(e);
                } catch (OutOfMemoryError e2) {
                    ab.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", e);
                    Runtime.getRuntime().gc();
                    Runtime.getRuntime().runFinalization();
                    vw = x.vv(e);
                }
                if (vw == null) {
                    vw = x.vv(o.ahl().I(Ou.field_imgPath, true));
                    k.am(kVar.yXx, 0);
                    new ak().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(31961);
                            com.tencent.mm.pluginsdk.model.app.l.a(Ou, new com.tencent.mm.pluginsdk.model.app.l.a() {
                                public final void gK(int i, int i2) {
                                    AppMethodBeat.i(31960);
                                    if (i == i2) {
                                        Bitmap vw;
                                        ab.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", Long.valueOf(Ou.field_msgId));
                                        k.am(kVar.yXx, 8);
                                        try {
                                            vw = x.vw(e);
                                        } catch (OutOfMemoryError e) {
                                            ab.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", e);
                                            Runtime.getRuntime().gc();
                                            Runtime.getRuntime().runFinalization();
                                            vw = x.vv(e);
                                        }
                                        if (vw != null) {
                                            kVar.yXB.setEnableHorLongBmpMode(false);
                                            com.tencent.mm.sdk.platformtools.n.w(kVar.yXB, vw.getWidth(), vw.getHeight());
                                            kVar.yXB.bW(vw.getWidth(), vw.getHeight());
                                            kVar.yXB.setImageBitmap(vw);
                                            kVar.yXB.invalidate();
                                        }
                                    }
                                    AppMethodBeat.o(31960);
                                }
                            });
                            AppMethodBeat.o(31961);
                        }
                    });
                }
                if (vw == null) {
                    ab.w("MicroMsg.ImageGalleryAdapter", "get image fail");
                    kVar.yXB.setVisibility(8);
                    kVar.dGF().yXy.setVisibility(0);
                    kVar.dGF().yXA.setImageResource(R.raw.image_download_fail_icon);
                    kVar.dGF().yXz.setText(this.yTI.getString(R.string.cdi));
                } else {
                    kVar.yXB.setEnableHorLongBmpMode(false);
                    com.tencent.mm.sdk.platformtools.n.w(kVar.yXB, vw.getWidth(), vw.getHeight());
                    kVar.yXB.bW(vw.getWidth(), vw.getHeight());
                    kVar.yXB.setImageBitmap(vw);
                    kVar.yXB.invalidate();
                }
                if (i == 100000) {
                    ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).T(Ou);
                    break;
                }
                break;
            case image:
                this.yTN.a(kVar, Ou, i);
                if (i == 100000) {
                    ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).T(Ou);
                    break;
                }
                break;
        }
        this.yTS = false;
        AppMethodBeat.o(TXRecordCommon.AUDIO_SAMPLERATE_32000);
        return view;
    }

    public final void detach() {
        AppMethodBeat.i(32002);
        this.yTN.detach();
        this.yTO.detach();
        this.yTP.detach();
        if (this.yTT != null) {
            e Fo = this.yTT.Fo();
            Fo.cUW = com.tencent.mm.g.b.a.e.a.cancel;
            Fo.ajK();
        }
        super.detach();
        AppMethodBeat.o(32002);
    }

    public final boolean dFN() {
        return this.yTJ.prepared;
    }

    public final int firstItemPosForDetermine() {
        return 100000 - this.yTJ.yTZ;
    }

    public final int lastItemPosForDetermine() {
        return ((100000 - this.yTJ.yTZ) + this.yTJ.enb) - 1;
    }

    public final void aF(int i, boolean z) {
        AppMethodBeat.i(32004);
        this.yTN.aF(i, z);
        AppMethodBeat.o(32004);
    }

    public final MultiTouchImageView wx(int i) {
        AppMethodBeat.i(32005);
        View Fp = super.Fp(i);
        if (Fp == null) {
            ab.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", Integer.valueOf(i));
            AppMethodBeat.o(32005);
            return null;
        }
        Fp = Fp.findViewById(R.id.bl);
        if (Fp == null || Fp.getVisibility() == 8) {
            AppMethodBeat.o(32005);
            return null;
        }
        MultiTouchImageView multiTouchImageView = (MultiTouchImageView) Fp;
        AppMethodBeat.o(32005);
        return multiTouchImageView;
    }

    public final WxImageView wy(int i) {
        AppMethodBeat.i(32006);
        View Fp = super.Fp(i);
        if (Fp == null) {
            AppMethodBeat.o(32006);
            return null;
        }
        Fp = Fp.findViewById(R.id.chw);
        if (Fp == null || Fp.getVisibility() == 8) {
            AppMethodBeat.o(32006);
            return null;
        }
        WxImageView wxImageView = (WxImageView) Fp;
        AppMethodBeat.o(32006);
        return wxImageView;
    }

    public final View OO(int i) {
        AppMethodBeat.i(32007);
        View Fp = super.Fp(i);
        if (Fp == null) {
            ab.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", Integer.valueOf(i));
            AppMethodBeat.o(32007);
            return null;
        }
        View findViewById = Fp.findViewById(R.id.ci4);
        if (findViewById == null) {
            findViewById = Fp.findViewById(R.id.bs7);
        }
        if (findViewById == null || findViewById.getVisibility() == 8) {
            AppMethodBeat.o(32007);
            return null;
        }
        AppMethodBeat.o(32007);
        return findViewById;
    }

    public final void OP(int i) {
        AppMethodBeat.i(32008);
        this.yTO.i(Ou(i), i);
        AppMethodBeat.o(32008);
    }

    public final void OQ(int i) {
        AppMethodBeat.i(32009);
        this.yTO.j(Ou(i), i);
        AppMethodBeat.o(32009);
    }

    public final bi dFO() {
        AppMethodBeat.i(32010);
        bi Ou = Ou(this.yTI.getCurrentItem());
        AppMethodBeat.o(32010);
        return Ou;
    }

    public final k dFP() {
        AppMethodBeat.i(32011);
        k OJ = this.yTN.OJ(this.yTI.getCurrentItem());
        if (OJ == null) {
            OJ = this.yTO.OJ(this.yTI.getCurrentItem());
        }
        if (OJ == null) {
            OJ = this.yTP.OJ(this.yTI.getCurrentItem());
        }
        AppMethodBeat.o(32011);
        return OJ;
    }

    public final void OR(int i) {
        AppMethodBeat.i(32012);
        this.yTO.OK(i);
        AppMethodBeat.o(32012);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(32013);
        super.notifyDataSetChanged();
        AppMethodBeat.o(32013);
    }

    public final void dFQ() {
        AppMethodBeat.i(32014);
        this.yTO.onResume();
        AppMethodBeat.o(32014);
    }

    public final void OS(int i) {
        AppMethodBeat.i(32015);
        bi Ou = Ou(i);
        if (Ou == null || !c(Ou)) {
            AppMethodBeat.o(32015);
            return;
        }
        this.yTN.bB(Ou);
        AppMethodBeat.o(32015);
    }

    public final void OT(int i) {
        AppMethodBeat.i(32016);
        this.yTP.OZ(i);
        AppMethodBeat.o(32016);
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        AppMethodBeat.i(32017);
        viewGroup.removeView((View) obj);
        super.destroyItem(viewGroup, i, obj);
        AppMethodBeat.o(32017);
    }

    public final void g(bi biVar, boolean z) {
        int i = 2;
        AppMethodBeat.i(32018);
        if (biVar == null) {
            AppMethodBeat.o(32018);
            return;
        }
        bi dFO = dFO();
        if (dFO == null || dFO.field_msgId != biVar.field_msgId) {
            ab.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", Long.valueOf(dFO.field_msgId), Long.valueOf(biVar.field_msgId));
            AppMethodBeat.o(32018);
            return;
        }
        e Fo;
        long j = biVar.field_msgSvrId;
        if (!(this.yTT == null || (this.yTT.cUO == j && this.yTT.cUQ == z))) {
            Fo = this.yTT.Fo();
            Fo.cUW = com.tencent.mm.g.b.a.e.a.cancel;
            Fo.ajK();
        }
        this.yTT = new e();
        this.yTT.Fn();
        Fo = this.yTT;
        Fo.cUO = j;
        Fo.cUP = biVar.field_createTime;
        Fo.cUQ = z;
        if (com.tencent.mm.model.t.kH(this.egE)) {
            i = n.mA(this.egE);
        }
        this.yTT.er(this.egE).cUN = (long) i;
        AppMethodBeat.o(32018);
    }

    public final void a(bi biVar, com.tencent.mm.at.e eVar, int i, com.tencent.mm.g.b.a.e.a aVar) {
        AppMethodBeat.i(32019);
        if (biVar == null) {
            AppMethodBeat.o(32019);
        } else if (this.yTT == null) {
            AppMethodBeat.o(32019);
        } else {
            this.yTT.Fo().cUW = aVar;
            long j = biVar.field_msgSvrId;
            boolean z = i == 1;
            if (this.yTT.cUO == j || this.yTT.cUQ == z) {
                long j2 = 0;
                j = 0;
                long j3 = 0;
                long yz = bo.yz();
                if (aVar == com.tencent.mm.g.b.a.e.a.ok) {
                    String a = e.a(biVar, eVar);
                    if (!bo.isNullOrNil(a)) {
                        j2 = com.tencent.mm.vfs.e.asZ(a);
                        Options arv = e.arv(a);
                        j3 = (long) arv.outWidth;
                        j = (long) arv.outHeight;
                    }
                }
                e eVar2 = this.yTT;
                eVar2.cUR = j2;
                eVar2.cUT = j;
                eVar2.cUS = j3;
                this.yTT.ajK();
                ab.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", Long.valueOf(bo.az(yz)), this.yTT.Fj());
                this.yTT = null;
                AppMethodBeat.o(32019);
                return;
            }
            ab.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", Long.valueOf(this.yTT.cUO), Long.valueOf(j));
            e eVar3 = this.yTT;
            eVar3.cUW = com.tencent.mm.g.b.a.e.a.cancel;
            eVar3.ajK();
            AppMethodBeat.o(32019);
        }
    }

    public final void bw(bi biVar) {
        AppMethodBeat.i(31995);
        com.tencent.mm.at.e d = e.d(biVar);
        if (biVar == null || biVar.field_msgId == 0 || d == null || d.fDy == 0) {
            ab.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, msgLocalId = " + (biVar == null ? BuildConfig.COMMAND : Long.valueOf(biVar.field_msgId)) + ", imgLocalId = " + (d == null ? BuildConfig.COMMAND : Long.valueOf(d.fDy)));
            AppMethodBeat.o(31995);
            return;
        }
        String a = e.a(biVar, d);
        if (bo.isNullOrNil(a)) {
            ab.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + biVar.field_msgId + ", imgLocalId = " + d.fDy);
            AppMethodBeat.o(31995);
            return;
        }
        j(a, c(biVar, d), biVar.field_msgId);
        AppMethodBeat.o(31995);
    }

    public static String e(bi biVar) {
        String str = null;
        AppMethodBeat.i(32001);
        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(biVar.field_content);
        if (me == null) {
            AppMethodBeat.o(32001);
        } else {
            if (me.csD != null && me.csD.length() > 0) {
                com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(me.csD);
                if (aiE != null) {
                    str = aiE.field_fileFullPath;
                }
            }
            AppMethodBeat.o(32001);
        }
        return str;
    }

    public static int c(bi biVar, com.tencent.mm.at.e eVar) {
        AppMethodBeat.i(32003);
        com.tencent.mm.at.e a;
        if (biVar.field_isSend == 1) {
            if (eVar.agQ()) {
                a = f.a(eVar);
                if (a != null && a.fDy > 0 && a.agP() && com.tencent.mm.vfs.e.ct(o.ahl().q(a.fDz, "", ""))) {
                    AppMethodBeat.o(32003);
                    return 1;
                }
            }
            AppMethodBeat.o(32003);
            return 0;
        } else if (eVar.agP()) {
            if (eVar.agQ()) {
                a = f.a(eVar);
                if (a != null && a.fDy > 0 && a.agP() && com.tencent.mm.vfs.e.ct(o.ahl().q(a.fDz, "", ""))) {
                    AppMethodBeat.o(32003);
                    return 1;
                }
            }
            AppMethodBeat.o(32003);
            return 0;
        } else {
            AppMethodBeat.o(32003);
            return 0;
        }
    }
}
