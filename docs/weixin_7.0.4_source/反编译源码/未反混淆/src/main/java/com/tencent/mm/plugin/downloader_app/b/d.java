package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static LinkedList<a> kOK = new LinkedList();
    private static LinkedList<b> kOL = new LinkedList();
    private static LinkedList<c> kOM = new LinkedList();
    private static LinkedList<f> kON = new LinkedList();
    private static LinkedList<e> kOO = new LinkedList();
    private static LinkedList<d> kOP = new LinkedList();
    private static LinkedList<g> kOQ = new LinkedList();
    private static com.tencent.mm.plugin.downloader.b.a.b kOR;

    public interface b {
        void onClick();
    }

    public interface c {
        void gh(boolean z);
    }

    public interface d {
        void E(int i, long j);
    }

    public interface a {
        void gg(boolean z);
    }

    public interface f {
        void IJ(String str);
    }

    public interface e {
        void II(String str);
    }

    public interface g {
        void IK(String str);
    }

    static {
        AppMethodBeat.i(136134);
        AppMethodBeat.o(136134);
    }

    public static void bie() {
        AppMethodBeat.i(136110);
        if (kOR == null) {
            kOR = new com.tencent.mm.plugin.downloader.b.a.b() {
                public final void E(int i, long j) {
                    AppMethodBeat.i(136109);
                    d.F(i, j);
                    AppMethodBeat.o(136109);
                }
            };
        }
        com.tencent.mm.plugin.downloader.b.a.a(kOR);
        AppMethodBeat.o(136110);
    }

    public static void bgr() {
        AppMethodBeat.i(136111);
        com.tencent.mm.plugin.downloader.b.a.b(kOR);
        kOR = null;
        kOK.clear();
        kOL.clear();
        kOM.clear();
        kON.clear();
        kOO.clear();
        kOP.clear();
        AppMethodBeat.o(136111);
    }

    public static void hD(long j) {
        AppMethodBeat.i(136112);
        Iterator it = kOP.iterator();
        while (it.hasNext()) {
            ((d) it.next()).E(5, j);
        }
        AppMethodBeat.o(136112);
    }

    public static void a(d dVar) {
        AppMethodBeat.i(136113);
        if (!kOP.contains(dVar)) {
            kOP.add(dVar);
        }
        AppMethodBeat.o(136113);
    }

    public static void b(d dVar) {
        AppMethodBeat.i(136114);
        kOP.remove(dVar);
        AppMethodBeat.o(136114);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(136115);
        kOK.add(aVar);
        AppMethodBeat.o(136115);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(136116);
        kOK.remove(aVar);
        AppMethodBeat.o(136116);
    }

    public static void ge(boolean z) {
        AppMethodBeat.i(136117);
        Iterator it = kOK.iterator();
        while (it.hasNext()) {
            ((a) it.next()).gg(z);
        }
        AppMethodBeat.o(136117);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(136118);
        kOL.add(bVar);
        AppMethodBeat.o(136118);
    }

    public static void b(b bVar) {
        AppMethodBeat.i(136119);
        kOL.remove(bVar);
        AppMethodBeat.o(136119);
    }

    public static void biJ() {
        AppMethodBeat.i(136120);
        Iterator it = kOL.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onClick();
        }
        AppMethodBeat.o(136120);
    }

    public static void a(c cVar) {
        AppMethodBeat.i(136121);
        kOM.add(cVar);
        AppMethodBeat.o(136121);
    }

    public static void b(c cVar) {
        AppMethodBeat.i(136122);
        kOM.remove(cVar);
        AppMethodBeat.o(136122);
    }

    public static void gf(boolean z) {
        AppMethodBeat.i(136123);
        Iterator it = kOM.iterator();
        while (it.hasNext()) {
            ((c) it.next()).gh(z);
        }
        AppMethodBeat.o(136123);
    }

    public static void a(f fVar) {
        AppMethodBeat.i(136124);
        kON.add(fVar);
        AppMethodBeat.o(136124);
    }

    public static void b(f fVar) {
        AppMethodBeat.i(136125);
        kON.remove(fVar);
        AppMethodBeat.o(136125);
    }

    public static void IF(String str) {
        AppMethodBeat.i(136126);
        Iterator it = kON.iterator();
        while (it.hasNext()) {
            ((f) it.next()).IJ(str);
        }
        AppMethodBeat.o(136126);
    }

    public static void a(e eVar) {
        AppMethodBeat.i(136127);
        if (!kOO.contains(eVar)) {
            kOO.add(eVar);
        }
        AppMethodBeat.o(136127);
    }

    public static void b(e eVar) {
        AppMethodBeat.i(136128);
        kOO.remove(eVar);
        AppMethodBeat.o(136128);
    }

    public static void IG(String str) {
        AppMethodBeat.i(136129);
        Iterator it = kOO.iterator();
        while (it.hasNext()) {
            ((e) it.next()).II(str);
        }
        AppMethodBeat.o(136129);
    }

    public static void a(g gVar) {
        AppMethodBeat.i(136130);
        if (!kOQ.contains(gVar)) {
            kOQ.add(gVar);
        }
        AppMethodBeat.o(136130);
    }

    public static void b(g gVar) {
        AppMethodBeat.i(136131);
        kOQ.remove(gVar);
        AppMethodBeat.o(136131);
    }

    public static void IH(String str) {
        AppMethodBeat.i(136132);
        Iterator it = kOQ.iterator();
        while (it.hasNext()) {
            ((g) it.next()).IK(str);
        }
        AppMethodBeat.o(136132);
    }

    static /* synthetic */ void F(int i, long j) {
        AppMethodBeat.i(136133);
        com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
        if (!(hv == null || !hv.field_fromDownloadApp || i == 9)) {
            b.h(hv);
        }
        Iterator it = kOP.iterator();
        while (it.hasNext()) {
            ((d) it.next()).E(i, j);
        }
        AppMethodBeat.o(136133);
    }
}
