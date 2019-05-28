package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.a.c.f.AnonymousClass1;
import com.tencent.mm.plugin.aa.a.c.f.AnonymousClass2;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.sdk.platformtools.ab;

public class g implements com.tencent.mm.vending.c.b<f> {
    protected f gmR;
    public final d gmS;
    public final a gmT;
    public final e gmU;
    public final c gmV;
    public final b gmW;
    public final f gmX;

    public class a implements com.tencent.mm.vending.h.e<o, Long> {
        public final /* synthetic */ Object call(Object obj) {
            int i;
            AppMethodBeat.i(40698);
            Long l = (Long) obj;
            f fVar = g.this.gmR;
            long longValue = l.longValue();
            String stringExtra = fVar.zXe.getStringExtra("bill_no");
            String stringExtra2 = fVar.zXe.getStringExtra("chatroom");
            if (fVar.zXe.getIntExtra("enter_scene", 0) == 1) {
                i = com.tencent.mm.plugin.aa.a.a.gll;
            } else {
                i = com.tencent.mm.plugin.aa.a.a.glm;
            }
            ab.i("MicroMsg.PaylistAAInteractor", "aaPay, payAmount: %s, billNo: %s, chatroom: %s", Long.valueOf(longValue), stringExtra, stringExtra2);
            com.tencent.mm.vending.g.f.a(com.tencent.mm.vending.g.f.b(stringExtra, Long.valueOf(longValue), Integer.valueOf(i), stringExtra2).c(fVar.gmO.glJ));
            AppMethodBeat.o(40698);
            return null;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public class c implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.d<Long, String, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40700);
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            f fVar = g.this.gmR;
            long longValue = ((Long) dVar.get(0)).longValue();
            String str = (String) dVar.get(1);
            String str2 = (String) dVar.get(2);
            com.tencent.mm.vending.g.b dMj = com.tencent.mm.vending.g.f.dMj();
            String stringExtra = fVar.zXe.getStringExtra("bill_no");
            int intExtra = fVar.zXe.getIntExtra("enter_scene", 0);
            String stringExtra2 = fVar.zXe.getStringExtra("chatroom");
            dMj.dMi();
            new com.tencent.mm.plugin.aa.a.a.a(stringExtra, longValue, intExtra, stringExtra2, str, str2).acy().h(new AnonymousClass1(dMj));
            Void voidR = zXH;
            AppMethodBeat.o(40700);
            return voidR;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public class b implements com.tencent.mm.vending.h.e<Boolean, Void> {
        public final String HZ() {
            return "Vending.LOGIC";
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40699);
            f fVar = g.this.gmR;
            String stringExtra = fVar.zXe.getStringExtra("bill_no");
            int intExtra = fVar.zXe.getIntExtra("enter_scene", 0);
            com.tencent.mm.vending.g.f.a(com.tencent.mm.vending.g.f.h(stringExtra, Integer.valueOf(intExtra), fVar.zXe.getStringExtra("chatroom")).c(fVar.gmP.glM));
            AppMethodBeat.o(40699);
            return null;
        }
    }

    public class d implements com.tencent.mm.vending.h.e<v, Void> {
        public final String HZ() {
            return "Vending.LOGIC";
        }

        public final com.tencent.mm.vending.g.c<v> aor() {
            AppMethodBeat.i(40701);
            com.tencent.mm.vending.g.c c = com.tencent.mm.vending.g.f.dMn().c(this);
            AppMethodBeat.o(40701);
            return c;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40702);
            f fVar = g.this.gmR;
            String stringExtra = fVar.zXe.getStringExtra("bill_no");
            int intExtra = fVar.zXe.getIntExtra("enter_scene", 0);
            String stringExtra2 = fVar.zXe.getStringExtra("chatroom");
            String stringExtra3 = fVar.zXe.getStringExtra("key_sign");
            int intExtra2 = fVar.zXe.getIntExtra("key_ver", 0);
            ab.i("MicroMsg.PaylistAAInteractor", "getPayListDetail, billNo: %s, scene: %s, chatRoom: %s", stringExtra, Integer.valueOf(intExtra), stringExtra2);
            com.tencent.mm.vending.g.f.a(com.tencent.mm.vending.g.f.a(stringExtra, Integer.valueOf(intExtra), stringExtra2, stringExtra3, Integer.valueOf(intExtra2)).c(fVar.gmN.glv));
            AppMethodBeat.o(40702);
            return null;
        }
    }

    public class e implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.d<String, String, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40703);
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            f fVar = g.this.gmR;
            String str = (String) dVar.get(1);
            h.c(str, fVar.zXe.getStringExtra("chatroom"), fVar.zXe.getStringExtra("bill_no"), (String) dVar.get(0), (String) dVar.get(2));
            Void voidR = zXH;
            AppMethodBeat.o(40703);
            return voidR;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public class f implements com.tencent.mm.vending.h.e<Boolean, Void> {
        public final String HZ() {
            return "Vending.LOGIC";
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40704);
            f fVar = g.this.gmR;
            String stringExtra = fVar.zXe.getStringExtra("bill_no");
            String stringExtra2 = fVar.zXe.getStringExtra("chatroom");
            int intExtra = fVar.zXe.getIntExtra("enter_scene", 0);
            ab.i("MicroMsg.PaylistAAInteractor", "urgeAAPay");
            com.tencent.mm.vending.g.b dMj = com.tencent.mm.vending.g.f.dMj();
            dMj.dMi();
            new com.tencent.mm.plugin.aa.a.a.b(stringExtra, stringExtra2, intExtra).acy().h(new AnonymousClass2(dMj));
            AppMethodBeat.o(40704);
            return null;
        }
    }

    public g() {
        this(new f());
        AppMethodBeat.i(40705);
        AppMethodBeat.o(40705);
    }

    private g(f fVar) {
        AppMethodBeat.i(40706);
        this.gmS = new d();
        this.gmT = new a();
        this.gmU = new e();
        this.gmV = new c();
        this.gmW = new b();
        this.gmX = new f();
        this.gmR = fVar;
        AppMethodBeat.o(40706);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.gmR;
    }
}
