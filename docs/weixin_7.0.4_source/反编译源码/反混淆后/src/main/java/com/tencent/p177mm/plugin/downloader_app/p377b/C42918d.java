package com.tencent.p177mm.plugin.downloader_app.p377b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p940b.C33903a;
import com.tencent.p177mm.plugin.downloader.p940b.C33903a.C11501b;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.downloader_app.b.d */
public final class C42918d {
    private static LinkedList<C20336a> kOK = new LinkedList();
    private static LinkedList<C11517b> kOL = new LinkedList();
    private static LinkedList<C11518c> kOM = new LinkedList();
    private static LinkedList<C38860f> kON = new LinkedList();
    private static LinkedList<C42919e> kOO = new LinkedList();
    private static LinkedList<C11519d> kOP = new LinkedList();
    private static LinkedList<C42920g> kOQ = new LinkedList();
    private static C11501b kOR;

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.d$b */
    public interface C11517b {
        void onClick();
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.d$c */
    public interface C11518c {
        /* renamed from: gh */
        void mo23233gh(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.d$d */
    public interface C11519d {
        /* renamed from: E */
        void mo7097E(int i, long j);
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.d$a */
    public interface C20336a {
        /* renamed from: gg */
        void mo7098gg(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.d$1 */
    static class C339341 implements C11501b {
        C339341() {
        }

        /* renamed from: E */
        public final void mo23220E(int i, long j) {
            AppMethodBeat.m2504i(136109);
            C42918d.m76195F(i, j);
            AppMethodBeat.m2505o(136109);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.d$f */
    public interface C38860f {
        /* renamed from: IJ */
        void mo7103IJ(String str);
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.d$e */
    public interface C42919e {
        /* renamed from: II */
        void mo7105II(String str);
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.d$g */
    public interface C42920g {
        /* renamed from: IK */
        void mo7102IK(String str);
    }

    static {
        AppMethodBeat.m2504i(136134);
        AppMethodBeat.m2505o(136134);
    }

    public static void bie() {
        AppMethodBeat.m2504i(136110);
        if (kOR == null) {
            kOR = new C339341();
        }
        C33903a.m55476a(kOR);
        AppMethodBeat.m2505o(136110);
    }

    public static void bgr() {
        AppMethodBeat.m2504i(136111);
        C33903a.m55477b(kOR);
        kOR = null;
        kOK.clear();
        kOL.clear();
        kOM.clear();
        kON.clear();
        kOO.clear();
        kOP.clear();
        AppMethodBeat.m2505o(136111);
    }

    /* renamed from: hD */
    public static void m76215hD(long j) {
        AppMethodBeat.m2504i(136112);
        Iterator it = kOP.iterator();
        while (it.hasNext()) {
            ((C11519d) it.next()).mo7097E(5, j);
        }
        AppMethodBeat.m2505o(136112);
    }

    /* renamed from: a */
    public static void m76202a(C11519d c11519d) {
        AppMethodBeat.m2504i(136113);
        if (!kOP.contains(c11519d)) {
            kOP.add(c11519d);
        }
        AppMethodBeat.m2505o(136113);
    }

    /* renamed from: b */
    public static void m76209b(C11519d c11519d) {
        AppMethodBeat.m2504i(136114);
        kOP.remove(c11519d);
        AppMethodBeat.m2505o(136114);
    }

    /* renamed from: a */
    public static void m76199a(C20336a c20336a) {
        AppMethodBeat.m2504i(136115);
        kOK.add(c20336a);
        AppMethodBeat.m2505o(136115);
    }

    /* renamed from: b */
    public static void m76206b(C20336a c20336a) {
        AppMethodBeat.m2504i(136116);
        kOK.remove(c20336a);
        AppMethodBeat.m2505o(136116);
    }

    /* renamed from: ge */
    public static void m76213ge(boolean z) {
        AppMethodBeat.m2504i(136117);
        Iterator it = kOK.iterator();
        while (it.hasNext()) {
            ((C20336a) it.next()).mo7098gg(z);
        }
        AppMethodBeat.m2505o(136117);
    }

    /* renamed from: a */
    public static void m76200a(C11517b c11517b) {
        AppMethodBeat.m2504i(136118);
        kOL.add(c11517b);
        AppMethodBeat.m2505o(136118);
    }

    /* renamed from: b */
    public static void m76207b(C11517b c11517b) {
        AppMethodBeat.m2504i(136119);
        kOL.remove(c11517b);
        AppMethodBeat.m2505o(136119);
    }

    public static void biJ() {
        AppMethodBeat.m2504i(136120);
        Iterator it = kOL.iterator();
        while (it.hasNext()) {
            ((C11517b) it.next()).onClick();
        }
        AppMethodBeat.m2505o(136120);
    }

    /* renamed from: a */
    public static void m76201a(C11518c c11518c) {
        AppMethodBeat.m2504i(136121);
        kOM.add(c11518c);
        AppMethodBeat.m2505o(136121);
    }

    /* renamed from: b */
    public static void m76208b(C11518c c11518c) {
        AppMethodBeat.m2504i(136122);
        kOM.remove(c11518c);
        AppMethodBeat.m2505o(136122);
    }

    /* renamed from: gf */
    public static void m76214gf(boolean z) {
        AppMethodBeat.m2504i(136123);
        Iterator it = kOM.iterator();
        while (it.hasNext()) {
            ((C11518c) it.next()).mo23233gh(z);
        }
        AppMethodBeat.m2505o(136123);
    }

    /* renamed from: a */
    public static void m76204a(C38860f c38860f) {
        AppMethodBeat.m2504i(136124);
        kON.add(c38860f);
        AppMethodBeat.m2505o(136124);
    }

    /* renamed from: b */
    public static void m76211b(C38860f c38860f) {
        AppMethodBeat.m2504i(136125);
        kON.remove(c38860f);
        AppMethodBeat.m2505o(136125);
    }

    /* renamed from: IF */
    public static void m76196IF(String str) {
        AppMethodBeat.m2504i(136126);
        Iterator it = kON.iterator();
        while (it.hasNext()) {
            ((C38860f) it.next()).mo7103IJ(str);
        }
        AppMethodBeat.m2505o(136126);
    }

    /* renamed from: a */
    public static void m76203a(C42919e c42919e) {
        AppMethodBeat.m2504i(136127);
        if (!kOO.contains(c42919e)) {
            kOO.add(c42919e);
        }
        AppMethodBeat.m2505o(136127);
    }

    /* renamed from: b */
    public static void m76210b(C42919e c42919e) {
        AppMethodBeat.m2504i(136128);
        kOO.remove(c42919e);
        AppMethodBeat.m2505o(136128);
    }

    /* renamed from: IG */
    public static void m76197IG(String str) {
        AppMethodBeat.m2504i(136129);
        Iterator it = kOO.iterator();
        while (it.hasNext()) {
            ((C42919e) it.next()).mo7105II(str);
        }
        AppMethodBeat.m2505o(136129);
    }

    /* renamed from: a */
    public static void m76205a(C42920g c42920g) {
        AppMethodBeat.m2504i(136130);
        if (!kOQ.contains(c42920g)) {
            kOQ.add(c42920g);
        }
        AppMethodBeat.m2505o(136130);
    }

    /* renamed from: b */
    public static void m76212b(C42920g c42920g) {
        AppMethodBeat.m2504i(136131);
        kOQ.remove(c42920g);
        AppMethodBeat.m2505o(136131);
    }

    /* renamed from: IH */
    public static void m76198IH(String str) {
        AppMethodBeat.m2504i(136132);
        Iterator it = kOQ.iterator();
        while (it.hasNext()) {
            ((C42920g) it.next()).mo7102IK(str);
        }
        AppMethodBeat.m2505o(136132);
    }

    /* renamed from: F */
    static /* synthetic */ void m76195F(int i, long j) {
        AppMethodBeat.m2504i(136133);
        C42911a hv = C2895c.m5147hv(j);
        if (!(hv == null || !hv.field_fromDownloadApp || i == 9)) {
            C38857b.m65925h(hv);
        }
        Iterator it = kOP.iterator();
        while (it.hasNext()) {
            ((C11519d) it.next()).mo7097E(i, j);
        }
        AppMethodBeat.m2505o(136133);
    }
}
