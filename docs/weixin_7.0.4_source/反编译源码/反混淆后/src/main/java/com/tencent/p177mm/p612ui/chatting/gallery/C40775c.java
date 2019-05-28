package com.tencent.p177mm.p612ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p190at.C9022l;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p232b.p233a.C42100e;
import com.tencent.p177mm.p230g.p232b.p233a.C42100e.C26292a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44277u;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.base.WxImageView;
import com.tencent.p177mm.p612ui.chatting.C40707a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C23688d;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40706c;
import com.tencent.p177mm.p612ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.chatting.gallery.C36180k.C237815;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI.C40765a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C45477q;
import com.tencent.p177mm.plugin.comm.p1247a.C20286b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.model.app.C4733l.C4734a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.tencent.mm.ui.chatting.gallery.c */
public final class C40775c extends C44277u {
    public static long jMj = -1;
    public static boolean mgP = false;
    private String egE = null;
    private ArrayList<C7620bi> mnX = new ArrayList();
    public ImageGalleryUI yTI;
    protected C30515a yTJ;
    private String yTK;
    boolean yTL = true;
    public boolean yTM = false;
    public C40780e yTN;
    public C15663j yTO;
    public C30517i yTP;
    public C40779c yTQ;
    boolean yTR;
    protected boolean yTS = true;
    private C42100e yTT = null;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.c$a */
    public static class C30515a {
        int enb;
        C7306ak handler = new C7306ak();
        private int min;
        protected boolean prepared = false;
        private String talker;
        private List<C7620bi> yTY;
        int yTZ;
        protected int yUa;
        protected int yUb;
        protected int yUc;
        protected long yUd;
        private C40775c yUe;
        public HashMap<Long, C25822e> yUf = new HashMap();
        public HashMap<Long, C25822e> yUg = new HashMap();

        public C30515a(long j, String str, final C40775c c40775c, Boolean bool) {
            AppMethodBeat.m2504i(31966);
            this.talker = str;
            this.yTY = new LinkedList();
            this.yUe = c40775c;
            C9638aw.m17190ZK();
            C7620bi jf = C18628c.m29080XO().mo15340jf(j);
            if (jf.field_msgId == 0) {
                Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + j + ", stack = " + C5046bo.dpG(), false);
                AppMethodBeat.m2505o(31966);
                return;
            }
            this.yTY.add(jf);
            final long j2 = j;
            final Boolean bool2 = bool;
            final C40775c c40775c2 = c40775c;
            C9638aw.m17180RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.ui.chatting.gallery.c$a$1$1 */
                class C237781 implements Runnable {
                    C237781() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(31963);
                        C30515a.m48608a(C30515a.this);
                        if (c40775c2.yTQ != null) {
                            c40775c2.yTQ.mo48927pL();
                        }
                        AppMethodBeat.m2505o(31963);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(31964);
                    C30515a.m48609a(C30515a.this, j2);
                    if (bool2.booleanValue()) {
                        C30515a.this.handler.postDelayed(new C237781(), 0);
                    }
                    AppMethodBeat.m2505o(31964);
                }
            });
            c40775c.yTI.yWm = new C40765a() {
                /* renamed from: l */
                public final void mo48930l(Boolean bool) {
                    AppMethodBeat.m2504i(31965);
                    C4990ab.m7416i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(bool)));
                    if (!bool.booleanValue()) {
                        C30515a.m48608a(C30515a.this);
                        if (c40775c.yTQ != null) {
                            c40775c.yTQ.mo48927pL();
                        }
                    }
                    AppMethodBeat.m2505o(31965);
                }
            };
            AppMethodBeat.m2505o(31966);
        }

        /* renamed from: fa */
        private void m48610fa(List<C7620bi> list) {
            AppMethodBeat.m2504i(31967);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                if (C40775c.m70571c((C7620bi) list.get(i))) {
                    arrayList.add(Long.valueOf(((C7620bi) list.get(i)).field_msgSvrId));
                    if (((C7620bi) list.get(i)).field_isSend == 1) {
                        arrayList2.add(Long.valueOf(((C7620bi) list.get(i)).field_msgId));
                    }
                }
            }
            this.yUf.putAll(C32291o.ahl().mo73096a((Long[]) arrayList.toArray(new Long[0])));
            this.yUg.putAll(C32291o.ahl().mo73107b((Long[]) arrayList2.toArray(new Long[0])));
            AppMethodBeat.m2505o(31967);
        }

        /* renamed from: a */
        public final void mo48933a(long j, C25822e c25822e, boolean z) {
            AppMethodBeat.m2504i(31968);
            if (z) {
                this.yUf.put(Long.valueOf(j), c25822e);
                AppMethodBeat.m2505o(31968);
                return;
            }
            this.yUg.put(Long.valueOf(j), c25822e);
            AppMethodBeat.m2505o(31968);
        }

        /* renamed from: OU */
        public final int mo48931OU(int i) {
            return (i - 100000) + this.yTZ;
        }

        /* renamed from: OV */
        public final C7620bi mo48932OV(int i) {
            AppMethodBeat.m2504i(31969);
            int OU = mo48931OU(i);
            int size = (this.min + this.yTY.size()) - 1;
            if (OU < this.min || OU > size) {
                C4990ab.m7412e("MicroMsg.AutoList", "get, invalid pos " + OU + ", min = " + this.min + ", max = " + size);
                AppMethodBeat.m2505o(31969);
                return null;
            }
            C4990ab.m7410d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(OU)));
            C7620bi c7620bi;
            if (OU == this.min) {
                c7620bi = (C7620bi) this.yTY.get(0);
                if (this.prepared) {
                    m48607C(c7620bi.field_msgId, false);
                }
                AppMethodBeat.m2505o(31969);
                return c7620bi;
            } else if (OU != size || size >= this.enb - 1) {
                c7620bi = (C7620bi) this.yTY.get(OU - this.min);
                AppMethodBeat.m2505o(31969);
                return c7620bi;
            } else {
                c7620bi = (C7620bi) this.yTY.get(this.yTY.size() - 1);
                if (this.prepared) {
                    m48607C(c7620bi.field_msgId, true);
                }
                AppMethodBeat.m2505o(31969);
                return c7620bi;
            }
        }

        public final void dFM() {
            this.prepared = false;
        }

        /* renamed from: C */
        private void m48607C(long j, boolean z) {
            List b;
            AppMethodBeat.m2504i(31970);
            C4990ab.m7416i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + j + ", forward = " + z);
            if (C40775c.mgP) {
                C9638aw.m17190ZK();
                b = C18628c.m29081XP().mo74800b(this.talker, C40775c.jMj, j, z);
            } else {
                C9638aw.m17190ZK();
                b = C18628c.m29080XO().mo15336g(this.talker, j, z);
            }
            if (b == null || b.size() == 0) {
                C4990ab.m7420w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(z)));
                AppMethodBeat.m2505o(31970);
                return;
            }
            C4990ab.m7416i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + b.size() + ", forward = " + z);
            long currentTimeMillis = System.currentTimeMillis();
            m48610fa(b);
            C4990ab.m7417i("MicroMsg.AutoList", "loadImgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (z) {
                this.yTY.addAll(b);
                AppMethodBeat.m2505o(31970);
                return;
            }
            this.yTY.addAll(0, b);
            this.min -= b.size();
            if (this.min < 0) {
                C4990ab.m7412e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.min);
                AppMethodBeat.m2505o(31970);
                return;
            }
            C4990ab.m7416i("MicroMsg.AutoList", "min from " + (b.size() + this.min) + " to " + this.min);
            AppMethodBeat.m2505o(31970);
        }

        public final String toString() {
            AppMethodBeat.m2504i(31971);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AutoList, Size = " + this.yTY.size());
            stringBuilder.append("; Content = {");
            for (C7620bi c7620bi : this.yTY) {
                stringBuilder.append(c7620bi.field_msgId);
                stringBuilder.append(",");
            }
            stringBuilder.append("}");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(31971);
            return stringBuilder2;
        }

        /* renamed from: a */
        static /* synthetic */ void m48609a(C30515a c30515a, long j) {
            AppMethodBeat.m2504i(31972);
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7416i("MicroMsg.AutoList", "isBizChat = " + C40775c.mgP);
            if (C40775c.mgP) {
                C9638aw.m17190ZK();
                c30515a.yUa = C18628c.m29081XP().mo74798aS(c30515a.talker, C40775c.jMj);
            } else {
                C9638aw.m17190ZK();
                c30515a.yUa = C18628c.m29080XO().mo15263Rq(c30515a.talker);
            }
            C4990ab.m7416i("MicroMsg.AutoList", "<init>, totalCount = " + c30515a.yUa);
            C4990ab.m7417i("MicroMsg.AutoList", "totalCount spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (C40775c.mgP) {
                C9638aw.m17190ZK();
                c30515a.yUb = C18628c.m29081XP().mo74804z(c30515a.talker, C40775c.jMj, j);
            } else {
                C9638aw.m17190ZK();
                c30515a.yUb = C18628c.m29080XO().mo15297ac(c30515a.talker, j);
            }
            C4990ab.m7417i("MicroMsg.AutoList", "min spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            if (System.currentTimeMillis() - currentTimeMillis2 > 1000) {
                C9638aw.m17190ZK();
                String ad = C18628c.m29080XO().mo15298ad(c30515a.talker, j);
                C4990ab.m7421w("MicroMsg.AutoList", "explain : %s", ad);
            }
            c30515a.yUc = c30515a.yUb;
            c30515a.yUd = j;
            AppMethodBeat.m2505o(31972);
        }

        /* renamed from: a */
        static /* synthetic */ void m48608a(C30515a c30515a) {
            AppMethodBeat.m2504i(31973);
            c30515a.prepared = true;
            c30515a.enb = c30515a.yUa;
            c30515a.min = c30515a.yUb;
            c30515a.yTZ = c30515a.yUc;
            C4990ab.m7417i("MicroMsg.AutoList", "totalCount %s min %s start %s", Integer.valueOf(c30515a.enb), Integer.valueOf(c30515a.min), Integer.valueOf(c30515a.yTZ));
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.AutoList", "min spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            c30515a.m48607C(c30515a.yUd, true);
            C4990ab.m7417i("MicroMsg.AutoList", "loadMsgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            c30515a.m48607C(c30515a.yUd, false);
            C4990ab.m7417i("MicroMsg.AutoList", "loadMsgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            c30515a.yUe.notifyDataSetChanged();
            if (!c30515a.yUe.yTI.isFinishing()) {
                c30515a.yUe.mo64319d(99999, (View) c30515a.yUe.yyL.get(99999));
            }
            AppMethodBeat.m2505o(31973);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.c$b */
    public enum C40774b {
        unkown,
        image,
        video,
        sight,
        appimage;

        static {
            AppMethodBeat.m2505o(31976);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.c$c */
    public interface C40779c {
        /* renamed from: pL */
        void mo48927pL();
    }

    public C40775c(ImageGalleryUI imageGalleryUI, long j, String str, boolean z, long j2, boolean z2, String str2, Boolean bool) {
        AppMethodBeat.m2504i(31977);
        String str3 = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + imageGalleryUI + ", currentMsgId = " + j + ", talker = " + str + ", stack = " + C5046bo.dpG();
        boolean z3 = j > 0 && str != null && str.length() > 0;
        Assert.assertTrue(str3, z3);
        this.yTI = imageGalleryUI;
        mgP = z;
        jMj = j2;
        this.egE = str;
        this.yTJ = new C30515a(j, str, this, bool);
        this.yTM = z2;
        this.yTK = str2;
        this.yTN = new C40780e(this);
        this.yTO = new C15663j(this);
        this.yTP = new C30517i(this);
        AppMethodBeat.m2505o(31977);
    }

    public final void onPageSelected(int i) {
        AppMethodBeat.m2504i(31978);
        if (this.yTN != null && C40775c.m70571c(mo64312Ou(i))) {
            this.yTN.yVa.onPageSelected(i);
        }
        AppMethodBeat.m2505o(31978);
    }

    public final int getCount() {
        C30515a c30515a = this.yTJ;
        return ((c30515a.enb - c30515a.yTZ) + 100000) + 1;
    }

    public final int getRealCount() {
        return this.yTJ.enb;
    }

    /* renamed from: Ou */
    public final C7620bi mo64312Ou(int i) {
        AppMethodBeat.m2504i(31979);
        C7620bi OV = this.yTJ.mo48932OV(i);
        AppMethodBeat.m2505o(31979);
        return OV;
    }

    public final void dFM() {
        AppMethodBeat.m2504i(31980);
        this.yTJ.dFM();
        AppMethodBeat.m2505o(31980);
    }

    /* renamed from: f */
    public final C25822e mo64326f(C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(31981);
        C25822e f = this.yTN.mo64338f(c7620bi, z);
        AppMethodBeat.m2505o(31981);
        return f;
    }

    /* renamed from: c */
    public static boolean m70571c(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31982);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(31982);
            return false;
        } else if (c7620bi.getType() == 3 || c7620bi.getType() == 39 || c7620bi.getType() == 13) {
            AppMethodBeat.m2505o(31982);
            return true;
        } else {
            AppMethodBeat.m2505o(31982);
            return false;
        }
    }

    /* renamed from: f */
    public static boolean m70574f(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31983);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(31983);
            return false;
        } else if (C40775c.m70569bu(c7620bi)) {
            AppMethodBeat.m2505o(31983);
            return false;
        } else if (c7620bi.getType() == 43 || c7620bi.getType() == 44 || c7620bi.getType() == 62) {
            AppMethodBeat.m2505o(31983);
            return true;
        } else {
            AppMethodBeat.m2505o(31983);
            return false;
        }
    }

    /* renamed from: bp */
    public static boolean m70565bp(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31984);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(31984);
            return false;
        } else if (c7620bi.getType() == 62) {
            AppMethodBeat.m2505o(31984);
            return true;
        } else {
            AppMethodBeat.m2505o(31984);
            return false;
        }
    }

    /* renamed from: bq */
    public static boolean m70566bq(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31985);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(31985);
            return false;
        } else if (c7620bi.getType() == 49) {
            AppMethodBeat.m2505o(31985);
            return true;
        } else {
            AppMethodBeat.m2505o(31985);
            return false;
        }
    }

    /* renamed from: br */
    public static boolean m70567br(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31986);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(31986);
            return false;
        } else if (c7620bi.getType() == 268435505) {
            AppMethodBeat.m2505o(31986);
            return true;
        } else {
            AppMethodBeat.m2505o(31986);
            return false;
        }
    }

    /* renamed from: bs */
    public final boolean mo64315bs(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31987);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(31987);
            return false;
        }
        C25822e f = mo64326f(c7620bi, false);
        if (f == null) {
            C26493s bG = C15663j.m23963bG(c7620bi);
            if (bG == null) {
                AppMethodBeat.m2505o(31987);
                return false;
            } else if (bG == null) {
                AppMethodBeat.m2505o(31987);
                return false;
            } else {
                int i = bG.status;
                boolean z = (i == 112 || i == 122) && C26494u.m42255g(bG) < 100;
                C4990ab.m7417i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(r2));
                AppMethodBeat.m2505o(31987);
                return z;
            }
        } else if (c7620bi == null || f == null) {
            AppMethodBeat.m2505o(31987);
            return false;
        } else if (C32291o.ahm().mo33466a(f.fDy, c7620bi.field_msgId, 0) || C40775c.m70564b(c7620bi, f)) {
            AppMethodBeat.m2505o(31987);
            return true;
        } else {
            AppMethodBeat.m2505o(31987);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m70564b(C7620bi c7620bi, C25822e c25822e) {
        AppMethodBeat.m2504i(31988);
        if (c7620bi == null || c25822e == null) {
            AppMethodBeat.m2505o(31988);
            return false;
        }
        boolean a = C32291o.ahm().mo33466a(c25822e.fDy, c7620bi.field_msgId, 1);
        AppMethodBeat.m2505o(31988);
        return a;
    }

    /* renamed from: OL */
    public final void mo64303OL(int i) {
        AppMethodBeat.m2504i(31989);
        C7620bi Ou = mo64312Ou(i);
        switch (C40775c.m70568bt(Ou)) {
            case video:
            case sight:
                mo64316bv(Ou);
                AppMethodBeat.m2505o(31989);
                return;
            case appimage:
                String e = C40775c.m70572e(Ou);
                Intent intent = new Intent(this.yTI, MsgRetransmitUI.class);
                intent.putExtra("Retr_File_Name", e);
                intent.putExtra("Retr_Msg_Id", Ou.field_msgId);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_content", Ou.field_content);
                intent.putExtra("Retr_Compress_Type", 0);
                this.yTI.startActivity(intent);
                AppMethodBeat.m2505o(31989);
                return;
            default:
                mo64317bw(Ou);
                AppMethodBeat.m2505o(31989);
                return;
        }
    }

    /* renamed from: OM */
    public final void mo64304OM(int i) {
        AppMethodBeat.m2504i(31990);
        C7620bi Ou = mo64312Ou(i);
        switch (C40775c.m70568bt(Ou)) {
            case video:
            case sight:
            case image:
                Intent intent = new Intent(this.yTI, ChattingSendDataToDeviceUI.class);
                intent.putExtra("Retr_Msg_Id", Ou.field_msgId);
                this.yTI.startActivity(intent);
                break;
        }
        AppMethodBeat.m2505o(31990);
    }

    /* renamed from: bt */
    public static C40774b m70568bt(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31991);
        C40774b c40774b = C40774b.unkown;
        if (c7620bi == null) {
            c40774b = C40774b.unkown;
        }
        if (C40775c.m70567br(c7620bi)) {
            c40774b = C40774b.appimage;
            AppMethodBeat.m2505o(31991);
            return c40774b;
        } else if (C40775c.m70571c(c7620bi)) {
            c40774b = C40774b.image;
            AppMethodBeat.m2505o(31991);
            return c40774b;
        } else if (C40775c.m70569bu(c7620bi)) {
            c40774b = C40774b.sight;
            AppMethodBeat.m2505o(31991);
            return c40774b;
        } else if (C40775c.m70574f(c7620bi)) {
            c40774b = C40774b.video;
            AppMethodBeat.m2505o(31991);
            return c40774b;
        } else if (C40775c.m70565bp(c7620bi)) {
            c40774b = C40774b.video;
            AppMethodBeat.m2505o(31991);
            return c40774b;
        } else {
            c40774b = C40774b.unkown;
            AppMethodBeat.m2505o(31991);
            return c40774b;
        }
    }

    /* renamed from: bu */
    private static boolean m70569bu(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31992);
        if (c7620bi != null) {
            C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
            if (!(ut == null || ut.fXm == null || (C5046bo.isNullOrNil(ut.fXm.fiG) && ut.fXm.wid <= 0 && C5046bo.isNullOrNil(ut.fXm.fiJ) && C5046bo.isNullOrNil(ut.fXm.fiK) && C5046bo.isNullOrNil(ut.fXm.fiI) && C5046bo.isNullOrNil(ut.fXm.fiL) && C5046bo.isNullOrNil(ut.fXm.fiM) && C5046bo.isNullOrNil(ut.fXm.fiN)))) {
                AppMethodBeat.m2505o(31992);
                return true;
            }
        }
        AppMethodBeat.m2505o(31992);
        return false;
    }

    /* renamed from: bv */
    public final void mo64316bv(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31993);
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
            if (ut == null) {
                C4990ab.m7412e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
                AppMethodBeat.m2505o(31993);
                return;
            }
            Intent intent = new Intent(this.yTI, MsgRetransmitUI.class);
            intent.putExtra("Retr_length", ut.fXd);
            intent.putExtra("Retr_File_Name", c7620bi.field_imgPath);
            intent.putExtra("Retr_video_isexport", ut.fXh);
            intent.putExtra("Retr_Msg_Type", C40775c.m70565bp(c7620bi) ? 11 : 1);
            intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
            intent.putExtra("Retr_From", "gallery");
            this.yTI.startActivity(intent);
            AppMethodBeat.m2505o(31993);
            return;
        }
        C23639t.m36492hO(this.yTI);
        AppMethodBeat.m2505o(31993);
    }

    /* renamed from: j */
    private void m70575j(String str, int i, long j) {
        AppMethodBeat.m2504i(31994);
        Intent intent;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ImageGalleryAdapter", "doRestransmitImg fail, imgPath is null");
            AppMethodBeat.m2505o(31994);
        } else if (C5046bo.isNullOrNil(this.yTK)) {
            C4990ab.m7416i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
            intent = new Intent(this.yTI, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", str);
            intent.putExtra("Retr_Msg_Id", j);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_Compress_Type", i);
            this.yTI.startActivity(intent);
            AppMethodBeat.m2505o(31994);
        } else {
            C4990ab.m7417i("MicroMsg.ImageGalleryAdapter", "directly send user %s", this.yTK);
            if (!C5046bo.isNullOrNil(str)) {
                C9638aw.m17182Rg().mo14541a(new C9022l(C1853r.m3846Yz(), this.yTK, str, i), 0);
                C37907bv.aaq().mo60662c(C37907bv.fnv, null);
            }
            if (this.yTL) {
                intent = new Intent(this.yTI, ChattingUI.class);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", this.yTK);
                this.yTI.startActivity(intent);
            } else {
                C30379h.m48465bQ(this.yTI, this.yTI.getString(C25738R.string.f9219td));
            }
            C7060h.pYm.mo8381e(10424, Integer.valueOf(3), Integer.valueOf(4), this.yTK);
            AppMethodBeat.m2505o(31994);
        }
    }

    /* renamed from: f */
    public static boolean m70573f(Context context, List<C7620bi> list) {
        AppMethodBeat.m2504i(31996);
        if (context == null || list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(31996);
            return false;
        }
        boolean z = list.size() <= 1;
        boolean z2 = false;
        for (C7620bi c7620bi : list) {
            boolean a;
            if (C40775c.m70574f(c7620bi)) {
                a = C40775c.m70562a(context, c7620bi, z);
            } else {
                a = C40775c.m70563b(context, c7620bi, z);
            }
            if (z2 || !a) {
                a = z2;
            } else {
                a = true;
            }
            z2 = a;
        }
        if (!z2 && !z) {
            Toast.makeText(context, context.getString(C25738R.string.dww), 1).show();
        } else if (z2 && !z) {
            Toast.makeText(context, context.getString(C25738R.string.biq, new Object[]{C6457e.euR}), 1).show();
        }
        AppMethodBeat.m2505o(31996);
        return true;
    }

    /* renamed from: a */
    public static boolean m70562a(Context context, C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(31997);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(31997);
            return false;
        }
        C26493s uf = C37961o.all().mo21063uf(c7620bi.field_imgPath);
        boolean z2 = false;
        if (uf != null) {
            int i = 0;
            if (C1855t.m3896kH(uf.getUser())) {
                i = C37921n.m64060mA(uf.getUser());
            }
            boolean alz = uf.alz();
            C7060h.pYm.mo8378a(106, 216, 1, false);
            C7060h.pYm.mo8381e(12084, Integer.valueOf(uf.frO), Integer.valueOf(uf.fXd * 1000), Integer.valueOf(0), Integer.valueOf(2), uf.getUser(), Integer.valueOf(i), C26493s.m42234ue(uf.alw()), Long.valueOf(uf.createTime));
            z2 = alz;
        }
        if (z2) {
            C37961o.all();
            String uu = C26494u.m42269uu(C9720t.m17303uh(c7620bi.field_imgPath));
            if (C5046bo.isNullOrNil(uu)) {
                if (z) {
                    Toast.makeText(context, context.getString(C25738R.string.f1c), 1).show();
                }
                AppMethodBeat.m2505o(31997);
                return false;
            }
            if (z) {
                Toast.makeText(context, context.getString(C25738R.string.f1d, new Object[]{uu}), 1).show();
            }
            C14987n.m23300a(uu, context);
            AppMethodBeat.m2505o(31997);
            return true;
        }
        C4990ab.m7420w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
        if (z) {
            Toast.makeText(context, context.getString(C25738R.string.f1c), 1).show();
        }
        AppMethodBeat.m2505o(31997);
        return false;
    }

    /* renamed from: b */
    public static boolean m70563b(Context context, C7620bi c7620bi, boolean z) {
        String e;
        AppMethodBeat.m2504i(31998);
        if (C40775c.m70567br(c7620bi)) {
            e = C40775c.m70572e(c7620bi);
        } else if (c7620bi == null || c7620bi.field_msgId == 0) {
            C4990ab.m7412e("MicroMsg.ImageGalleryAdapter", "msg is null");
            if (z) {
                Toast.makeText(context, context.getString(C25738R.string.dwv), 1).show();
            }
            AppMethodBeat.m2505o(31998);
            return false;
        } else {
            C25822e d = C40780e.m70619d(c7620bi);
            if (d == null || d.fDy == 0) {
                C4990ab.m7412e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, msgLocalId = " + (c7620bi == null ? BuildConfig.COMMAND : Long.valueOf(c7620bi.field_msgId)) + ", imgLocalId = " + (d == null ? BuildConfig.COMMAND : Long.valueOf(d.fDy)));
                if (z) {
                    Toast.makeText(context, context.getString(C25738R.string.dwv), 1).show();
                }
                AppMethodBeat.m2505o(31998);
                return false;
            }
            e = C40780e.m70601a(c7620bi, d);
        }
        if (e == null || e.length() == 0) {
            C4990ab.m7412e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + c7620bi.field_msgId);
            if (z) {
                Toast.makeText(context, context.getString(C25738R.string.dwv), 1).show();
            }
            AppMethodBeat.m2505o(31998);
            return false;
        } else if (C45477q.m83807a(e, context, z, C25738R.string.b3r)) {
            AppMethodBeat.m2505o(31998);
            return true;
        } else {
            if (z) {
                Toast.makeText(context, context.getString(C25738R.string.dwv), 1).show();
            }
            AppMethodBeat.m2505o(31998);
            return false;
        }
    }

    /* renamed from: ON */
    public final void mo64305ON(int i) {
        AppMethodBeat.m2504i(31999);
        C7620bi Ou = mo64312Ou(i);
        C45316cl c45316cl = new C45316cl();
        C40443e.m69377d(c45316cl, Ou);
        c45316cl.cvA.activity = this.yTI;
        c45316cl.cvA.cvH = 44;
        C4879a.xxA.mo10055m(c45316cl);
        if (c45316cl.cvB.ret == 0) {
            if (Ou.bwt()) {
                C40707a.m70380a(C40706c.Fav, C23688d.Full, Ou, 0);
            }
            C45457b.fRa.mo73248D(Ou);
        }
        AppMethodBeat.m2505o(31999);
    }

    /* renamed from: d */
    public final View mo64319d(int i, View view) {
        C36180k c36180k;
        AppMethodBeat.m2504i(TXRecordCommon.AUDIO_SAMPLERATE_32000);
        final C7620bi Ou = mo64312Ou(i);
        if (view == null) {
            view = View.inflate(this.yTI, 2130969852, null);
            c36180k = new C36180k(this, view);
            view.setTag(c36180k);
        } else {
            c36180k = (C36180k) view.getTag();
        }
        C40774b bt = C40775c.m70568bt(Ou);
        c36180k.mPosition = i;
        c36180k.yXe = bt;
        C36180k.m59559am(c36180k.mRR, 0);
        switch (C237815.yTX[bt.ordinal()]) {
            case 1:
                C36180k.m59559am(c36180k.yXm, 8);
                C36180k.m59559am(c36180k.yXg, 8);
                break;
            case 2:
                c36180k.dGH();
                C36180k.m59559am(c36180k.yXm, 0);
                C36180k.m59559am(c36180k.yXg, 8);
                if (c36180k.yXg != null) {
                    C36180k.m59559am(c36180k.yXi, 8);
                    break;
                }
                break;
            case 3:
                c36180k.dGG();
                C36180k.m59559am(c36180k.yXm, 8);
                C36180k.m59559am(c36180k.yXg, 0);
                break;
            case 4:
                C36180k.m59559am(c36180k.mRR, 8);
                C36180k.m59559am(c36180k.yXm, 8);
                C36180k.m59559am(c36180k.yXg, 8);
                break;
        }
        C36180k.m59559am(c36180k.yXB, 8);
        C36180k.m59559am(c36180k.yXC, 8);
        C36180k.m59559am(c36180k.yXD, 8);
        C36180k.m59559am(c36180k.yXs, 8);
        C36180k.m59559am(c36180k.yXy, 8);
        C36180k.m59559am(c36180k.yXx, 8);
        C4990ab.m7411d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", Integer.valueOf(i), bt);
        switch (bt) {
            case video:
                this.yTO.mo27898a(c36180k, Ou, i);
                break;
            case sight:
                this.yTP.mo27898a(c36180k, Ou, i);
                break;
            case appimage:
                Bitmap vw;
                C36180k.m59559am(c36180k.yXB, 0);
                C36180k.m59559am(c36180k.yXs, 8);
                C36180k.m59559am(c36180k.yXx, 8);
                C36180k.m59559am(c36180k.yXy, 8);
                C36180k.m59559am(c36180k.yXq, 8);
                final String e = C40775c.m70572e(Ou);
                try {
                    vw = C18764x.m29334vw(e);
                } catch (OutOfMemoryError e2) {
                    C4990ab.m7421w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", e);
                    Runtime.getRuntime().gc();
                    Runtime.getRuntime().runFinalization();
                    vw = C18764x.m29333vv(e);
                }
                if (vw == null) {
                    vw = C18764x.m29333vv(C32291o.ahl().mo73074I(Ou.field_imgPath, true));
                    C36180k.m59559am(c36180k.yXx, 0);
                    new C7306ak().post(new Runnable() {

                        /* renamed from: com.tencent.mm.ui.chatting.gallery.c$1$1 */
                        class C407781 implements C4734a {
                            C407781() {
                            }

                            /* renamed from: gK */
                            public final void mo9875gK(int i, int i2) {
                                AppMethodBeat.m2504i(31960);
                                if (i == i2) {
                                    Bitmap vw;
                                    C4990ab.m7411d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", Long.valueOf(Ou.field_msgId));
                                    C36180k.m59559am(c36180k.yXx, 8);
                                    try {
                                        vw = C18764x.m29334vw(e);
                                    } catch (OutOfMemoryError e) {
                                        C4990ab.m7421w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", e);
                                        Runtime.getRuntime().gc();
                                        Runtime.getRuntime().runFinalization();
                                        vw = C18764x.m29333vv(e);
                                    }
                                    if (vw != null) {
                                        c36180k.yXB.setEnableHorLongBmpMode(false);
                                        C46616n.m88171w(c36180k.yXB, vw.getWidth(), vw.getHeight());
                                        c36180k.yXB.mo71980bW(vw.getWidth(), vw.getHeight());
                                        c36180k.yXB.setImageBitmap(vw);
                                        c36180k.yXB.invalidate();
                                    }
                                }
                                AppMethodBeat.m2505o(31960);
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(31961);
                            C4733l.m7095a(Ou, new C407781());
                            AppMethodBeat.m2505o(31961);
                        }
                    });
                }
                if (vw == null) {
                    C4990ab.m7420w("MicroMsg.ImageGalleryAdapter", "get image fail");
                    c36180k.yXB.setVisibility(8);
                    c36180k.dGF().yXy.setVisibility(0);
                    c36180k.dGF().yXA.setImageResource(C1318a.image_download_fail_icon);
                    c36180k.dGF().yXz.setText(this.yTI.getString(C25738R.string.cdi));
                } else {
                    c36180k.yXB.setEnableHorLongBmpMode(false);
                    C46616n.m88171w(c36180k.yXB, vw.getWidth(), vw.getHeight());
                    c36180k.yXB.mo71980bW(vw.getWidth(), vw.getHeight());
                    c36180k.yXB.setImageBitmap(vw);
                    c36180k.yXB.invalidate();
                }
                if (i == 100000) {
                    ((C20286b) C1720g.m3528K(C20286b.class)).mo35522T(Ou);
                    break;
                }
                break;
            case image:
                this.yTN.mo27898a(c36180k, Ou, i);
                if (i == 100000) {
                    ((C20286b) C1720g.m3528K(C20286b.class)).mo35522T(Ou);
                    break;
                }
                break;
        }
        this.yTS = false;
        AppMethodBeat.m2505o(TXRecordCommon.AUDIO_SAMPLERATE_32000);
        return view;
    }

    public final void detach() {
        AppMethodBeat.m2504i(32002);
        this.yTN.detach();
        this.yTO.detach();
        this.yTP.detach();
        if (this.yTT != null) {
            C42100e Fo = this.yTT.mo67664Fo();
            Fo.cUW = C26292a.cancel;
            Fo.ajK();
        }
        super.detach();
        AppMethodBeat.m2505o(32002);
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

    /* renamed from: aF */
    public final void mo64314aF(int i, boolean z) {
        AppMethodBeat.m2504i(32004);
        this.yTN.mo64335aF(i, z);
        AppMethodBeat.m2505o(32004);
    }

    /* renamed from: wx */
    public final MultiTouchImageView mo64332wx(int i) {
        AppMethodBeat.m2504i(32005);
        View Fp = super.mo70155Fp(i);
        if (Fp == null) {
            C4990ab.m7413e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(32005);
            return null;
        }
        Fp = Fp.findViewById(2131820629);
        if (Fp == null || Fp.getVisibility() == 8) {
            AppMethodBeat.m2505o(32005);
            return null;
        }
        MultiTouchImageView multiTouchImageView = (MultiTouchImageView) Fp;
        AppMethodBeat.m2505o(32005);
        return multiTouchImageView;
    }

    /* renamed from: wy */
    public final WxImageView mo64333wy(int i) {
        AppMethodBeat.m2504i(32006);
        View Fp = super.mo70155Fp(i);
        if (Fp == null) {
            AppMethodBeat.m2505o(32006);
            return null;
        }
        Fp = Fp.findViewById(2131824980);
        if (Fp == null || Fp.getVisibility() == 8) {
            AppMethodBeat.m2505o(32006);
            return null;
        }
        WxImageView wxImageView = (WxImageView) Fp;
        AppMethodBeat.m2505o(32006);
        return wxImageView;
    }

    /* renamed from: OO */
    public final View mo64306OO(int i) {
        AppMethodBeat.m2504i(32007);
        View Fp = super.mo70155Fp(i);
        if (Fp == null) {
            C4990ab.m7413e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(32007);
            return null;
        }
        View findViewById = Fp.findViewById(2131824988);
        if (findViewById == null) {
            findViewById = Fp.findViewById(2131823992);
        }
        if (findViewById == null || findViewById.getVisibility() == 8) {
            AppMethodBeat.m2505o(32007);
            return null;
        }
        AppMethodBeat.m2505o(32007);
        return findViewById;
    }

    /* renamed from: OP */
    public final void mo64307OP(int i) {
        AppMethodBeat.m2504i(32008);
        this.yTO.mo27911i(mo64312Ou(i), i);
        AppMethodBeat.m2505o(32008);
    }

    /* renamed from: OQ */
    public final void mo64308OQ(int i) {
        AppMethodBeat.m2504i(32009);
        this.yTO.mo27912j(mo64312Ou(i), i);
        AppMethodBeat.m2505o(32009);
    }

    public final C7620bi dFO() {
        AppMethodBeat.m2504i(32010);
        C7620bi Ou = mo64312Ou(this.yTI.getCurrentItem());
        AppMethodBeat.m2505o(32010);
        return Ou;
    }

    public final C36180k dFP() {
        AppMethodBeat.m2504i(32011);
        C36180k OJ = this.yTN.mo39605OJ(this.yTI.getCurrentItem());
        if (OJ == null) {
            OJ = this.yTO.mo39605OJ(this.yTI.getCurrentItem());
        }
        if (OJ == null) {
            OJ = this.yTP.mo39605OJ(this.yTI.getCurrentItem());
        }
        AppMethodBeat.m2505o(32011);
        return OJ;
    }

    /* renamed from: OR */
    public final void mo64309OR(int i) {
        AppMethodBeat.m2504i(32012);
        this.yTO.mo39606OK(i);
        AppMethodBeat.m2505o(32012);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(32013);
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(32013);
    }

    public final void dFQ() {
        AppMethodBeat.m2504i(32014);
        this.yTO.onResume();
        AppMethodBeat.m2505o(32014);
    }

    /* renamed from: OS */
    public final void mo64310OS(int i) {
        AppMethodBeat.m2504i(32015);
        C7620bi Ou = mo64312Ou(i);
        if (Ou == null || !C40775c.m70571c(Ou)) {
            AppMethodBeat.m2505o(32015);
            return;
        }
        this.yTN.mo64337bB(Ou);
        AppMethodBeat.m2505o(32015);
    }

    /* renamed from: OT */
    public final void mo64311OT(int i) {
        AppMethodBeat.m2504i(32016);
        this.yTP.mo48941OZ(i);
        AppMethodBeat.m2505o(32016);
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        AppMethodBeat.m2504i(32017);
        viewGroup.removeView((View) obj);
        super.destroyItem(viewGroup, i, obj);
        AppMethodBeat.m2505o(32017);
    }

    /* renamed from: g */
    public final void mo64328g(C7620bi c7620bi, boolean z) {
        int i = 2;
        AppMethodBeat.m2504i(32018);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(32018);
            return;
        }
        C7620bi dFO = dFO();
        if (dFO == null || dFO.field_msgId != c7620bi.field_msgId) {
            C4990ab.m7411d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", Long.valueOf(dFO.field_msgId), Long.valueOf(c7620bi.field_msgId));
            AppMethodBeat.m2505o(32018);
            return;
        }
        C42100e Fo;
        long j = c7620bi.field_msgSvrId;
        if (!(this.yTT == null || (this.yTT.cUO == j && this.yTT.cUQ == z))) {
            Fo = this.yTT.mo67664Fo();
            Fo.cUW = C26292a.cancel;
            Fo.ajK();
        }
        this.yTT = new C42100e();
        this.yTT.mo67663Fn();
        Fo = this.yTT;
        Fo.cUO = j;
        Fo.cUP = c7620bi.field_createTime;
        Fo.cUQ = z;
        if (C1855t.m3896kH(this.egE)) {
            i = C37921n.m64060mA(this.egE);
        }
        this.yTT.mo67665er(this.egE).cUN = (long) i;
        AppMethodBeat.m2505o(32018);
    }

    /* renamed from: a */
    public final void mo64313a(C7620bi c7620bi, C25822e c25822e, int i, C26292a c26292a) {
        AppMethodBeat.m2504i(32019);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(32019);
        } else if (this.yTT == null) {
            AppMethodBeat.m2505o(32019);
        } else {
            this.yTT.mo67664Fo().cUW = c26292a;
            long j = c7620bi.field_msgSvrId;
            boolean z = i == 1;
            if (this.yTT.cUO == j || this.yTT.cUQ == z) {
                long j2 = 0;
                j = 0;
                long j3 = 0;
                long yz = C5046bo.m7588yz();
                if (c26292a == C26292a.ok) {
                    String a = C40780e.m70601a(c7620bi, c25822e);
                    if (!C5046bo.isNullOrNil(a)) {
                        j2 = C5730e.asZ(a);
                        Options arv = C40780e.arv(a);
                        j3 = (long) arv.outWidth;
                        j = (long) arv.outHeight;
                    }
                }
                C42100e c42100e = this.yTT;
                c42100e.cUR = j2;
                c42100e.cUT = j;
                c42100e.cUS = j3;
                this.yTT.ajK();
                C4990ab.m7417i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", Long.valueOf(C5046bo.m7525az(yz)), this.yTT.mo4982Fj());
                this.yTT = null;
                AppMethodBeat.m2505o(32019);
                return;
            }
            C4990ab.m7421w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", Long.valueOf(this.yTT.cUO), Long.valueOf(j));
            C42100e c42100e2 = this.yTT;
            c42100e2.cUW = C26292a.cancel;
            c42100e2.ajK();
            AppMethodBeat.m2505o(32019);
        }
    }

    /* renamed from: bw */
    public final void mo64317bw(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31995);
        C25822e d = C40780e.m70619d(c7620bi);
        if (c7620bi == null || c7620bi.field_msgId == 0 || d == null || d.fDy == 0) {
            C4990ab.m7412e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, msgLocalId = " + (c7620bi == null ? BuildConfig.COMMAND : Long.valueOf(c7620bi.field_msgId)) + ", imgLocalId = " + (d == null ? BuildConfig.COMMAND : Long.valueOf(d.fDy)));
            AppMethodBeat.m2505o(31995);
            return;
        }
        String a = C40780e.m70601a(c7620bi, d);
        if (C5046bo.isNullOrNil(a)) {
            C4990ab.m7412e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + c7620bi.field_msgId + ", imgLocalId = " + d.fDy);
            AppMethodBeat.m2505o(31995);
            return;
        }
        m70575j(a, C40775c.m70570c(c7620bi, d), c7620bi.field_msgId);
        AppMethodBeat.m2505o(31995);
    }

    /* renamed from: e */
    public static String m70572e(C7620bi c7620bi) {
        String str = null;
        AppMethodBeat.m2504i(32001);
        C8910b me = C8910b.m16064me(c7620bi.field_content);
        if (me == null) {
            AppMethodBeat.m2505o(32001);
        } else {
            if (me.csD != null && me.csD.length() > 0) {
                C30065b aiE = C14877am.aUq().aiE(me.csD);
                if (aiE != null) {
                    str = aiE.field_fileFullPath;
                }
            }
            AppMethodBeat.m2505o(32001);
        }
        return str;
    }

    /* renamed from: c */
    public static int m70570c(C7620bi c7620bi, C25822e c25822e) {
        AppMethodBeat.m2504i(32003);
        C25822e a;
        if (c7620bi.field_isSend == 1) {
            if (c25822e.agQ()) {
                a = C37478f.m63225a(c25822e);
                if (a != null && a.fDy > 0 && a.agP() && C5730e.m8628ct(C32291o.ahl().mo73118q(a.fDz, "", ""))) {
                    AppMethodBeat.m2505o(32003);
                    return 1;
                }
            }
            AppMethodBeat.m2505o(32003);
            return 0;
        } else if (c25822e.agP()) {
            if (c25822e.agQ()) {
                a = C37478f.m63225a(c25822e);
                if (a != null && a.fDy > 0 && a.agP() && C5730e.m8628ct(C32291o.ahl().mo73118q(a.fDz, "", ""))) {
                    AppMethodBeat.m2505o(32003);
                    return 1;
                }
            }
            AppMethodBeat.m2505o(32003);
            return 0;
        } else {
            AppMethodBeat.m2505o(32003);
            return 0;
        }
    }
}
