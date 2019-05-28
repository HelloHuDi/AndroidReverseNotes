package com.tencent.p177mm.plugin.backup.p1394h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C6663ag;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C45160g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3454c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6978k;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C14884k;
import com.tencent.p177mm.pluginsdk.model.app.C30066c;
import com.tencent.p177mm.pluginsdk.model.app.C35796i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.emotion.C30303d;

/* renamed from: com.tencent.mm.plugin.backup.h.b */
public final class C38657b {
    private String eJM;
    public C7480h eJN = null;
    private C7580z jym;
    private C7309bd jyn;
    private C6977h jyo;
    private C7310be jyp;
    private C45160g jyq;
    private C30303d jyr;
    public C6978k jys;
    private C9720t jyt;
    private C6663ag jyu;
    public C14884k jyv;
    public C35796i jyw;
    private C30066c jyx;
    C3454c jyy;
    public int uin = 0;

    /* renamed from: bF */
    public final void mo61508bF(String str, int i) {
        AppMethodBeat.m2504i(17687);
        C4990ab.m7417i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", str, Integer.valueOf(i), C5046bo.dpG());
        this.uin = i;
        this.eJM = str;
        C9638aw.m17190ZK();
        this.eJN = C18628c.m29069Ru();
        C9638aw.m17190ZK();
        this.jym = C18628c.m29072Ry();
        C9638aw.m17190ZK();
        this.jyn = C18628c.m29078XM();
        C9638aw.m17190ZK();
        this.jyp = C18628c.m29083XR();
        C9638aw.m17190ZK();
        this.jyo = C18628c.m29080XO();
        C9638aw.m17190ZK();
        this.jys = C18628c.m29086XU();
        this.jyq = C32291o.ahl();
        this.jyr = C42952j.getEmojiStorageMgr().xYn;
        this.jyu = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV();
        this.jyt = C37961o.all();
        this.jyv = C34832a.bYK();
        this.jyw = C34832a.bYJ();
        this.jyx = C34832a.aUq();
        C9638aw.m17190ZK();
        this.jyy = C18628c.m29102Yo();
        AppMethodBeat.m2505o(17687);
    }

    /* renamed from: Ry */
    public final C7580z mo61496Ry() {
        AppMethodBeat.m2504i(17688);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17688);
            throw c1819b;
        }
        C7580z c7580z = this.jym;
        AppMethodBeat.m2505o(17688);
        return c7580z;
    }

    /* renamed from: XM */
    public final C7309bd mo61497XM() {
        AppMethodBeat.m2504i(17689);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17689);
            throw c1819b;
        }
        C7309bd c7309bd = this.jyn;
        AppMethodBeat.m2505o(17689);
        return c7309bd;
    }

    /* renamed from: XO */
    public final C6977h mo61498XO() {
        AppMethodBeat.m2504i(17690);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17690);
            throw c1819b;
        }
        C6977h c6977h = this.jyo;
        AppMethodBeat.m2505o(17690);
        return c6977h;
    }

    /* renamed from: XR */
    public final C7310be mo61499XR() {
        AppMethodBeat.m2504i(17691);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17691);
            throw c1819b;
        }
        C7310be c7310be = this.jyp;
        AppMethodBeat.m2505o(17691);
        return c7310be;
    }

    public final C45160g aUo() {
        AppMethodBeat.m2504i(17692);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17692);
            throw c1819b;
        }
        C45160g c45160g = this.jyq;
        AppMethodBeat.m2505o(17692);
        return c45160g;
    }

    public final C30303d aUp() {
        AppMethodBeat.m2504i(17693);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17693);
            throw c1819b;
        }
        C30303d c30303d = this.jyr;
        AppMethodBeat.m2505o(17693);
        return c30303d;
    }

    /* renamed from: XV */
    public final C6663ag mo61500XV() {
        AppMethodBeat.m2504i(17694);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17694);
            throw c1819b;
        }
        C6663ag c6663ag = this.jyu;
        AppMethodBeat.m2505o(17694);
        return c6663ag;
    }

    public final C9720t all() {
        AppMethodBeat.m2504i(17695);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17695);
            throw c1819b;
        }
        C9720t c9720t = this.jyt;
        AppMethodBeat.m2505o(17695);
        return c9720t;
    }

    public final String amg() {
        AppMethodBeat.m2504i(17696);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17696);
            throw c1819b;
        }
        String str = this.eJM + "voice/";
        AppMethodBeat.m2505o(17696);
        return str;
    }

    /* renamed from: XY */
    public final String mo61501XY() {
        AppMethodBeat.m2504i(17697);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17697);
            throw c1819b;
        }
        String str = this.eJM + "voice2/";
        AppMethodBeat.m2505o(17697);
        return str;
    }

    /* renamed from: Yb */
    public final String mo61502Yb() {
        AppMethodBeat.m2504i(17698);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17698);
            throw c1819b;
        }
        String str = this.eJM + "emoji/";
        AppMethodBeat.m2505o(17698);
        return str;
    }

    public final C30066c aUq() {
        AppMethodBeat.m2504i(17699);
        if (this.uin == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(17699);
            throw c1819b;
        }
        C30066c c30066c = this.jyx;
        AppMethodBeat.m2505o(17699);
        return c30066c;
    }
}
