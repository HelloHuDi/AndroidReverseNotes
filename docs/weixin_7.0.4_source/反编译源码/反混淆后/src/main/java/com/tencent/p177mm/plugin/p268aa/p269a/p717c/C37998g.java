package com.tencent.p177mm.plugin.p268aa.p269a.p717c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p268aa.p269a.C1954a;
import com.tencent.p177mm.plugin.p268aa.p269a.C9797h;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C41216b;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C45481a;
import com.tencent.p177mm.plugin.p268aa.p269a.p717c.C37996f.C187741;
import com.tencent.p177mm.plugin.p268aa.p269a.p717c.C37996f.C379972;
import com.tencent.p177mm.protocal.protobuf.C15369o;
import com.tencent.p177mm.protocal.protobuf.C15389v;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7361c;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7625d;

/* renamed from: com.tencent.mm.plugin.aa.a.c.g */
public class C37998g implements C24135b<C37996f> {
    protected C37996f gmR;
    public final C37999d gmS;
    public final C18775a gmT;
    public final C38000e gmU;
    public final C18776c gmV;
    public final C32893b gmW;
    public final C38001f gmX;

    /* renamed from: com.tencent.mm.plugin.aa.a.c.g$a */
    public class C18775a implements C7368e<C15369o, Long> {
        public final /* synthetic */ Object call(Object obj) {
            int i;
            AppMethodBeat.m2504i(40698);
            Long l = (Long) obj;
            C37996f c37996f = C37998g.this.gmR;
            long longValue = l.longValue();
            String stringExtra = c37996f.zXe.getStringExtra("bill_no");
            String stringExtra2 = c37996f.zXe.getStringExtra("chatroom");
            if (c37996f.zXe.getIntExtra("enter_scene", 0) == 1) {
                i = C1954a.gll;
            } else {
                i = C1954a.glm;
            }
            C4990ab.m7417i("MicroMsg.PaylistAAInteractor", "aaPay, payAmount: %s, billNo: %s, chatroom: %s", Long.valueOf(longValue), stringExtra, stringExtra2);
            C5698f.m8557a(C5698f.m8558b(stringExtra, Long.valueOf(longValue), Integer.valueOf(i), stringExtra2).mo15892c(c37996f.gmO.glJ));
            AppMethodBeat.m2505o(40698);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.g$c */
    public class C18776c implements C7368e<Void, C7625d<Long, String, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40700);
            C7625d c7625d = (C7625d) obj;
            C37996f c37996f = C37998g.this.gmR;
            long longValue = ((Long) c7625d.get(0)).longValue();
            String str = (String) c7625d.get(1);
            String str2 = (String) c7625d.get(2);
            C5688b dMj = C5698f.dMj();
            String stringExtra = c37996f.zXe.getStringExtra("bill_no");
            int intExtra = c37996f.zXe.getIntExtra("enter_scene", 0);
            String stringExtra2 = c37996f.zXe.getStringExtra("chatroom");
            dMj.dMi();
            new C45481a(stringExtra, longValue, intExtra, stringExtra2, str, str2).acy().mo60492h(new C187741(dMj));
            Void voidR = zXH;
            AppMethodBeat.m2505o(40700);
            return voidR;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.g$b */
    public class C32893b implements C7368e<Boolean, Void> {
        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40699);
            C37996f c37996f = C37998g.this.gmR;
            String stringExtra = c37996f.zXe.getStringExtra("bill_no");
            int intExtra = c37996f.zXe.getIntExtra("enter_scene", 0);
            C5698f.m8557a(C5698f.m8561h(stringExtra, Integer.valueOf(intExtra), c37996f.zXe.getStringExtra("chatroom")).mo15892c(c37996f.gmP.glM));
            AppMethodBeat.m2505o(40699);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.g$d */
    public class C37999d implements C7368e<C15389v, Void> {
        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }

        public final C7361c<C15389v> aor() {
            AppMethodBeat.m2504i(40701);
            C7361c c = C5698f.dMn().mo15892c(this);
            AppMethodBeat.m2505o(40701);
            return c;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40702);
            C37996f c37996f = C37998g.this.gmR;
            String stringExtra = c37996f.zXe.getStringExtra("bill_no");
            int intExtra = c37996f.zXe.getIntExtra("enter_scene", 0);
            String stringExtra2 = c37996f.zXe.getStringExtra("chatroom");
            String stringExtra3 = c37996f.zXe.getStringExtra("key_sign");
            int intExtra2 = c37996f.zXe.getIntExtra("key_ver", 0);
            C4990ab.m7417i("MicroMsg.PaylistAAInteractor", "getPayListDetail, billNo: %s, scene: %s, chatRoom: %s", stringExtra, Integer.valueOf(intExtra), stringExtra2);
            C5698f.m8557a(C5698f.m8553a(stringExtra, Integer.valueOf(intExtra), stringExtra2, stringExtra3, Integer.valueOf(intExtra2)).mo15892c(c37996f.gmN.glv));
            AppMethodBeat.m2505o(40702);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.g$e */
    public class C38000e implements C7368e<Void, C7625d<String, String, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40703);
            C7625d c7625d = (C7625d) obj;
            C37996f c37996f = C37998g.this.gmR;
            String str = (String) c7625d.get(1);
            C9797h.m17458c(str, c37996f.zXe.getStringExtra("chatroom"), c37996f.zXe.getStringExtra("bill_no"), (String) c7625d.get(0), (String) c7625d.get(2));
            Void voidR = zXH;
            AppMethodBeat.m2505o(40703);
            return voidR;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.g$f */
    public class C38001f implements C7368e<Boolean, Void> {
        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40704);
            C37996f c37996f = C37998g.this.gmR;
            String stringExtra = c37996f.zXe.getStringExtra("bill_no");
            String stringExtra2 = c37996f.zXe.getStringExtra("chatroom");
            int intExtra = c37996f.zXe.getIntExtra("enter_scene", 0);
            C4990ab.m7416i("MicroMsg.PaylistAAInteractor", "urgeAAPay");
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C41216b(stringExtra, stringExtra2, intExtra).acy().mo60492h(new C379972(dMj));
            AppMethodBeat.m2505o(40704);
            return null;
        }
    }

    public C37998g() {
        this(new C37996f());
        AppMethodBeat.m2504i(40705);
        AppMethodBeat.m2505o(40705);
    }

    private C37998g(C37996f c37996f) {
        AppMethodBeat.m2504i(40706);
        this.gmS = new C37999d();
        this.gmT = new C18775a();
        this.gmU = new C38000e();
        this.gmV = new C18776c();
        this.gmW = new C32893b();
        this.gmX = new C38001f();
        this.gmR = c37996f;
        AppMethodBeat.m2505o(40706);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.gmR;
    }
}
