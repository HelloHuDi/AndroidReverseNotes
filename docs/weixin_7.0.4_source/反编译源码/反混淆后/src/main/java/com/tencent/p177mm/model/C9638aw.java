package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1669a;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.C1672d;
import com.tencent.p177mm.kernel.api.C1673e;
import com.tencent.p177mm.kernel.p238a.p240b.C1654a;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C18615ba.C18616a;
import com.tencent.p177mm.model.C18628c.C18634a;
import com.tencent.p177mm.model.C32775bc.C18618a;
import com.tencent.p177mm.model.C9647bb.C9648a;
import com.tencent.p177mm.model.p871b.C18612d;
import com.tencent.p177mm.model.p871b.C42187c;
import com.tencent.p177mm.model.p871b.C45437b;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.modelstat.C42225q;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p183ai.C6300p.C1213a;
import com.tencent.p177mm.p183ai.C7472b.C6295b;
import com.tencent.p177mm.p183ai.C7475t;
import com.tencent.p177mm.p184aj.C8939o;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C6458aa;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.account.friend.p272a.C1985r.C1986a;
import com.tencent.p177mm.plugin.account.friend.p272a.C1988s.C1989a;
import com.tencent.p177mm.plugin.account.friend.p272a.C1990t.C1991a;
import com.tencent.p177mm.plugin.account.friend.p272a.C32965u.C32966a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38271be;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45579bb;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45580bd;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C42475m;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19484j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.report.p499b.C34826b.C28886a;
import com.tencent.p177mm.plugin.report.p499b.C34827c.C34828a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p591a.C4709e;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.C30165k.C30164a;
import com.tencent.p177mm.protocal.C30167n.C7244a;
import com.tencent.p177mm.protocal.C40596q.C40597a;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C30224sk;
import com.tencent.p177mm.protocal.protobuf.ahi;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C15444n;
import com.tencent.p177mm.storage.C23509au;
import com.tencent.p177mm.storage.C30306j;
import com.tencent.p177mm.storage.C30307l;
import com.tencent.p177mm.storage.C36004h;
import com.tencent.p177mm.storage.C40631p;
import com.tencent.p177mm.storage.C5142e;
import com.tencent.p177mm.storage.C5144y;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7309bd.C5131a;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7310be.C5132a;
import com.tencent.p177mm.storage.C7310be.C5133b;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.model.aw */
public final class C9638aw {
    private static C9638aw flB = null;
    private static final C45439bw flD = new C45439bw();
    private final C26412am flA;
    private C1407g flC = null;
    private final int flE = 1;
    final C18634a flF;
    private C45440ca flG = new C45440ca();
    private C9651bs flH = new C9651bs();
    private C42194e flI = new C42194e();
    private C26423cd flJ = new C26423cd();
    private C32802w flK = new C32802w();
    private C5131a flL = new C96374();
    private C5132a flM = new C96445();
    private C5132a flN = new C96426();
    private C42195f flO = new C42195f();
    private final C18628c flr;

    /* renamed from: com.tencent.mm.model.aw$4 */
    class C96374 implements C5131a {
        C96374() {
        }

        /* renamed from: a */
        public final void mo10530a(C7309bd c7309bd, C7616ad c7616ad) {
            AppMethodBeat.m2504i(16279);
            String str = c7616ad.field_username;
            if (C7616ad.m13548mR(c7616ad.field_username)) {
                c7616ad.setUsername(C7616ad.aoC(c7616ad.field_username));
            }
            if (C5046bo.isNullOrNil(c7616ad.mo14676Ht())) {
                c7616ad.mo14704iC(C9790g.m17433vp(c7616ad.field_nickname));
            }
            if (C5046bo.isNullOrNil(c7616ad.mo14677Hu())) {
                c7616ad.mo14705iD(C9790g.m17432vo(c7616ad.field_nickname));
            }
            if (C5046bo.isNullOrNil(c7616ad.field_conRemarkPYShort)) {
                c7616ad.mo14708iG(C9790g.m17433vp(c7616ad.field_conRemark));
            }
            if (C5046bo.isNullOrNil(c7616ad.field_conRemarkPYFull)) {
                c7616ad.mo14707iF(C9790g.m17432vo(c7616ad.field_conRemark));
            }
            if (C1855t.m3889e(c7616ad)) {
                c7616ad.mo14696hu(43);
                c7616ad.mo14704iC(C9790g.m17433vp(c7616ad.mo16706Oi()));
                c7616ad.mo14705iD(C9790g.m17432vo(c7616ad.mo16706Oi()));
                c7616ad.mo14707iF(C9790g.m17432vo(c7616ad.mo16707Oj()));
                c7616ad.mo14708iG(c7616ad.mo16707Oj());
                AppMethodBeat.m2505o(16279);
                return;
            }
            if (C1855t.m3923nI(str)) {
                C7616ad c7616ad2;
                c7616ad.mo16676NB();
                c7616ad.mo14701hz(4);
                c7616ad.mo14696hu(33);
                if (c7616ad == null) {
                    c7616ad2 = new C7616ad();
                } else {
                    c7616ad2 = c7616ad;
                }
                c7616ad2.setUsername(str);
                c7616ad2.mo16676NB();
                C37901ab.m64008y(c7616ad2);
                c7616ad2.mo16685NK();
            }
            if (c7616ad.mo16700Oc()) {
                c7616ad.mo14696hu(c7616ad.mo16696Ny());
            }
            if (C1855t.m3956ny(str)) {
                C4990ab.m7417i("MicroMsg.MMCore", "update official account helper showhead %d", Integer.valueOf(31));
                c7616ad.mo14696hu(31);
            }
            if (c7616ad.mo16698Oa()) {
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo15806c(new String[]{str}, "@blacklist");
            }
            C4990ab.m7411d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", c7616ad.field_username, c7616ad.mo14676Ht());
            AppMethodBeat.m2505o(16279);
        }
    }

    /* renamed from: com.tencent.mm.model.aw$2 */
    class C96392 implements C4709e {
        C96392() {
        }

        /* renamed from: a */
        public final byte[] mo9830a(C4834d c4834d, int i) {
            AppMethodBeat.m2504i(16277);
            byte[] toByteArray;
            switch (i) {
                case 107:
                    toByteArray = ((C32966a) c4834d).gvK.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case 145:
                    toByteArray = ((C7244a) c4834d).vyq.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case v2helper.EMethodSetIosMicAbCheckOff /*429*/:
                    toByteArray = ((C1991a) c4834d).gvI.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case C42475m.CTRL_INDEX /*481*/:
                    toByteArray = ((C1986a) c4834d).gvF.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case C19484j.CTRL_INDEX /*499*/:
                    toByteArray = ((C34828a) c4834d).pXm.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case 572:
                    toByteArray = ((C1989a) c4834d).gvH.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case C45580bd.CTRL_INDEX /*616*/:
                    toByteArray = ((C18616a) c4834d).flW.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case C38271be.CTRL_INDEX /*617*/:
                    toByteArray = ((C18618a) c4834d).fma.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case C45579bb.CTRL_INDEX /*618*/:
                    toByteArray = ((C9648a) c4834d).flY.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case 694:
                    toByteArray = ((C28886a) c4834d).pXm.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case 722:
                    toByteArray = ((C40597a) c4834d).vyy.wej.vLz.getBuffer().toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case 987:
                case TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR /*997*/:
                    toByteArray = ((C30224sk) ((C6295b) c4834d).fsP).vZK.toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case 989:
                    toByteArray = ((ahi) ((C6295b) c4834d).fsP).vZK.toByteArray();
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                case 1000:
                    toByteArray = ((C30164a) c4834d).vxZ;
                    AppMethodBeat.m2505o(16277);
                    return toByteArray;
                default:
                    AppMethodBeat.m2505o(16277);
                    return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.model.aw$1 */
    class C96401 implements C18634a {
        C96401() {
        }

        /* renamed from: cx */
        public final void mo20971cx(boolean z) {
            C7616ad aoO;
            AppMethodBeat.m2504i(16276);
            C4990ab.m7417i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", Long.valueOf(Thread.currentThread().getId()), C5046bo.dpG());
            C9638aw.m17199b(C9638aw.this);
            long currentTimeMillis = System.currentTimeMillis();
            C9638aw.m17190ZK();
            long iV = C18628c.m29069Ru().mo15639iV(Thread.currentThread().getId());
            C9638aw.this.flr;
            if (z) {
                C4990ab.m7416i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
                C18628c.m29078XM().aoU("readerapp");
                C18628c.m29072Ry().set(256, Boolean.TRUE);
                C4990ab.m7416i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
                C4990ab.m7417i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", Integer.valueOf(C1855t.m3876Zm().size()));
                for (C7616ad aoO2 : r0) {
                    if (!(aoO2 == null || ((int) aoO2.ewQ) == 0 || aoO2.field_showHead != 32)) {
                        aoO2.mo14696hu(aoO2.mo16696Ny());
                        C4990ab.m7410d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + aoO2.field_username);
                        C9638aw.m17190ZK();
                        C18628c.m29078XM().mo15724b(aoO2.field_username, aoO2);
                    }
                }
                for (String str : C1855t.fkY) {
                    C7616ad aoO3 = C18628c.m29078XM().aoO(str);
                    if (aoO3 != null && (((int) aoO3.ewQ) != 0 || C7486a.m12942jh(aoO3.field_type))) {
                        aoO3.mo16685NK();
                        C18628c.m29078XM().mo15724b(str, aoO3);
                    }
                }
                C32774ac.m53536Zr();
                C1831bh.m3771oG("ver" + C7243d.vxo);
            }
            C37901ab c37901ab = new C37901ab(C9638aw.this.flr);
            if (z) {
                C7616ad aoO4;
                C37901ab.m64007x(C18628c.m29078XM().aoO("filehelper"));
                String Yz = C1853r.m3846Yz();
                if (!C5046bo.isNullOrNil(Yz)) {
                    aoO4 = C18628c.m29078XM().aoO(Yz);
                    if (((int) aoO4.ewQ) == 0) {
                        aoO4.setUsername(Yz);
                        aoO4.mo16676NB();
                        C9638aw.m17190ZK();
                        C18628c.m29078XM().mo15702Z(aoO4);
                    } else if (!C7486a.m12942jh(aoO4.field_type)) {
                        aoO4.mo16676NB();
                        C9638aw.m17190ZK();
                        C18628c.m29078XM().mo15724b(Yz, aoO4);
                    }
                }
                C37901ab.m64006a(z, "qqmail", false);
                C37901ab.m64006a(z, "floatbottle", false);
                C37901ab.m64006a(z, "shakeapp", false);
                C37901ab.m64006a(z, "lbsapp", false);
                C37901ab.m64006a(z, "medianote", false);
                C37901ab.m64006a(z, "newsapp", true);
                C18628c.m29083XR().aoX("blogapp");
                C18628c.m29080XO().mo15254Rh("blogapp");
                C18628c.m29078XM().aoU("blogapp");
                C37901ab.m64006a(z, "facebookapp", true);
                C37901ab.m64006a(z, "qqfriend", false);
                C37901ab.m64006a(z, "masssendapp", true);
                C37901ab.m64006a(z, "feedsapp", true);
                C18628c.m29083XR().aoX("tmessage");
                C18628c.m29078XM().aoU("tmessage");
                aoO4 = C18628c.m29078XM().aoO("voip");
                aoO2 = C18628c.m29078XM().aoO("voipapp");
                if (aoO2 == null) {
                    aoO2 = new C7616ad();
                }
                if (!(aoO4 == null || ((int) aoO4.ewQ) == 0)) {
                    C18628c.m29078XM().aoU("voip");
                }
                if (((int) aoO2.ewQ) == 0) {
                    aoO2.setUsername("voipapp");
                    aoO2.mo16676NB();
                    C37901ab.m64008y(aoO2);
                    aoO2.mo14701hz(4);
                    aoO2.mo16685NK();
                    C18628c.m29078XM().mo15708aa(aoO2);
                } else if (z) {
                    aoO2.mo16685NK();
                    C18628c.m29078XM().mo15724b("voipapp", aoO2);
                }
                aoO2 = C18628c.m29078XM().aoO("officialaccounts");
                if (aoO2 == null) {
                    aoO2 = new C7616ad();
                }
                C4990ab.m7417i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) aoO2.ewQ));
                if (((int) aoO2.ewQ) == 0) {
                    aoO2.setUsername("officialaccounts");
                    aoO2.mo16677NC();
                    C37901ab.m64008y(aoO2);
                    aoO2.mo14701hz(3);
                    C18628c.m29078XM().mo15708aa(aoO2);
                } else if (z) {
                    C4990ab.m7416i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                    aoO2.mo16677NC();
                    C18628c.m29078XM().mo15724b("officialaccounts", aoO2);
                }
                aoO4 = C18628c.m29078XM().aoO("voipaudio");
                aoO2 = C18628c.m29078XM().aoO("voicevoipapp");
                if (aoO2 == null) {
                    aoO2 = new C7616ad();
                }
                if (!(aoO4 == null || ((int) aoO4.ewQ) == 0)) {
                    C18628c.m29078XM().aoU("voipaudio");
                }
                if (((int) aoO2.ewQ) == 0) {
                    aoO2.setUsername("voicevoipapp");
                    aoO2.mo16676NB();
                    C37901ab.m64008y(aoO2);
                    aoO2.mo14701hz(4);
                    aoO2.mo16685NK();
                    C18628c.m29078XM().mo15708aa(aoO2);
                } else if (z) {
                    aoO2.mo16685NK();
                    C18628c.m29078XM().mo15724b("voicevoipapp", aoO2);
                }
                C37901ab.m64006a(z, "voiceinputapp", false);
                C37901ab.m64006a(z, "linkedinplugin", false);
                aoO2 = C18628c.m29078XM().aoO("notifymessage");
                if (aoO2 == null) {
                    aoO2 = new C7616ad();
                }
                C4990ab.m7417i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) aoO2.ewQ));
                if (((int) aoO2.ewQ) == 0) {
                    aoO2.setUsername("notifymessage");
                    aoO2.mo16677NC();
                    C37901ab.m64008y(aoO2);
                    aoO2.mo14701hz(3);
                    C18628c.m29078XM().mo15708aa(aoO2);
                } else if (z) {
                    C4990ab.m7416i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                    aoO2.mo16677NC();
                    C18628c.m29078XM().mo15724b("notifymessage", aoO2);
                }
                aoO2 = C18628c.m29078XM().aoO("appbrandcustomerservicemsg");
                if (aoO2 == null) {
                    aoO2 = new C7616ad();
                }
                C4990ab.m7417i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) aoO2.ewQ));
                if (((int) aoO2.ewQ) == 0) {
                    aoO2.setUsername("appbrandcustomerservicemsg");
                    aoO2.mo16677NC();
                    C37901ab.m64008y(aoO2);
                    aoO2.setType(0);
                    aoO2.mo14701hz(3);
                    C18628c.m29078XM().mo15708aa(aoO2);
                } else if (z) {
                    C4990ab.m7416i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
                    aoO2.mo16677NC();
                    C18628c.m29078XM().mo15724b("appbrandcustomerservicemsg", aoO2);
                }
                C37901ab.m64006a(z, "downloaderapp", true);
                if (z) {
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().aoX("Weixin");
                    C9638aw.m17190ZK();
                    C18628c.m29078XM().aoU("Weixin");
                }
            }
            C9638aw.m17190ZK();
            C18628c.m29069Ru().mo15640mB(iV);
            C4990ab.m7417i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", Boolean.valueOf(z), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), C5046bo.dpG());
            C9638aw.this.flr;
            C18628c.m29083XR().mo15776a(C9638aw.m17194ZO().flA.mo20414Cb());
            AppMethodBeat.m2505o(16276);
        }
    }

    /* renamed from: com.tencent.mm.model.aw$3 */
    class C96413 implements C1672d {
        C96413() {
        }

        /* renamed from: b */
        public final void mo5171b(C1902e c1902e) {
            AppMethodBeat.m2504i(16278);
            C42225q.m74517e(c1902e);
            C42225q.m74518f(c1902e);
            AppMethodBeat.m2505o(16278);
        }
    }

    /* renamed from: com.tencent.mm.model.aw$6 */
    class C96426 implements C5132a {
        C96426() {
        }

        /* renamed from: a */
        public final void mo10531a(C7617ak c7617ak, C7310be c7310be) {
            if (c7617ak == null) {
            }
        }
    }

    /* renamed from: com.tencent.mm.model.aw$a */
    class C9643a implements C1655b, C1669a, C1671c, C1673e, C1694a {
        C9643a() {
        }

        public void onAccountInitialized(C1705c c1705c) {
            AppMethodBeat.m2504i(16281);
            if (c1705c.eKe) {
                C16112c.m24429PK().mo28556x(262145, false);
            }
            C7060h.pYm.mo8378a(598, 13, 1, false);
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", Long.valueOf(Thread.currentThread().getId()));
            C18628c a = C9638aw.this.flr;
            C7480h c7480h = C1720g.m3536RP().eJN;
            C1720g.m3536RP();
            C6977h bOr = ((C6982j) C1720g.m3528K(C6982j.class)).bOr();
            bOr.mo15290a(new C23509au(bOr));
            C5142e c36004h = new C36004h(bOr);
            a.fkf = c36004h;
            bOr.mo15290a(c36004h);
            a.fkd = new C26418br(c7480h, ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR());
            a.fke = new C9650bq(c7480h, ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM());
            a.fkg = new C42187c();
            a.fkh = new C18612d();
            a.fkl = new C45437b();
            a.fki = new C30306j(c7480h);
            a.fkj = new C15444n(c7480h);
            a.fkk = new C30307l(c7480h);
            C7060h.pYm.mo8378a(598, 14, 1, false);
            C4990ab.m7417i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            C18634a c18634a = C9638aw.this.flF;
            C9638aw.this.flr;
            c18634a.mo20971cx(c1705c.eKe);
            C7060h.pYm.mo8378a(598, 15, 1, false);
            C4990ab.m7417i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            C1445f.m3070Mn();
            C7060h.pYm.mo8378a(598, 16, 1, false);
            C4990ab.m7417i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(16281);
        }

        public void onAccountRelease() {
        }

        public void parallelsDependency() {
            AppMethodBeat.m2504i(16282);
            C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3530M(C6983p.class));
            AppMethodBeat.m2505o(16282);
        }

        public void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
            AppMethodBeat.m2504i(16283);
            C9638aw.this.flr;
            AppMethodBeat.m2505o(16283);
        }

        public void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
        }

        public HashMap<Integer, C1366d> collectDatabaseFactory() {
            AppMethodBeat.m2504i(16284);
            C4990ab.m7416i("MicroMsg.MMCore", "collectDatabaseFactory ");
            HashMap hashMap = new HashMap();
            hashMap.putAll(C18628c.eaA);
            AppMethodBeat.m2505o(16284);
            return hashMap;
        }
    }

    /* renamed from: com.tencent.mm.model.aw$5 */
    class C96445 implements C5132a {
        C96445() {
        }

        /* renamed from: a */
        public final void mo10531a(C7617ak c7617ak, C7310be c7310be) {
            AppMethodBeat.m2504i(16280);
            if (c7617ak == null) {
                AppMethodBeat.m2505o(16280);
            } else if (!C7616ad.aou(c7617ak.field_username) && !C7616ad.aow(c7617ak.field_username) && !C7616ad.m13548mR(c7617ak.field_username) && !C1855t.m3913mZ(c7617ak.field_username) && !C7616ad.aox(c7617ak.field_username)) {
                AppMethodBeat.m2505o(16280);
            } else if (C7616ad.m13548mR(c7617ak.field_username)) {
                int i;
                C7617ak c7617ak2;
                C7617ak aoZ = c7310be.aoZ("floatbottle");
                if (aoZ == null) {
                    i = 1;
                    c7617ak2 = new C7617ak("floatbottle");
                } else {
                    boolean i2 = false;
                    c7617ak2 = aoZ;
                }
                c7617ak2.mo14749hN(1);
                c7617ak2.mo14748hM(C37920l.m64042Yv());
                C9638aw.m17190ZK();
                C7620bi Rd = C18628c.m29080XO().mo15250Rd(" and not ( type = 10000 and isSend != 2 ) ");
                if (Rd == null || Rd.field_msgId <= 0) {
                    c7617ak2.dsI();
                } else {
                    c7617ak2.mo17068ap(Rd);
                    c7617ak2.setContent(C7616ad.aoC(Rd.field_talker) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rd.field_content);
                    c7617ak2.mo14757jg(Integer.toString(Rd.getType()));
                    C5133b Cb = c7310be.mo15765Cb();
                    if (Cb != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Rd.mo14794ju("floatbottle");
                        Rd.setContent(c7617ak2.field_content);
                        Cb.mo10533a(Rd, pString, pString2, pInt, false);
                        c7617ak2.mo14758jh(pString.value);
                        c7617ak2.mo14759ji(pString2.value);
                        c7617ak2.mo14751hP(pInt.value);
                    }
                }
                if (i2 != 0) {
                    c7310be.mo15807d(c7617ak2);
                    AppMethodBeat.m2505o(16280);
                    return;
                }
                c7310be.mo15767a(c7617ak2, c7617ak2.field_username);
                AppMethodBeat.m2505o(16280);
            } else if (C7616ad.aou(c7617ak.field_username) || C7616ad.aow(c7617ak.field_username)) {
                AppMethodBeat.m2505o(16280);
            } else {
                C1720g.m3528K(C8939o.class);
                C40631p.m70169b(c7617ak, c7310be);
                if ("@blacklist".equals(c7617ak.field_parentRef)) {
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(c7617ak.field_username);
                    if (!(aoO == null || C5046bo.isNullOrNil(aoO.field_username) || aoO.mo16698Oa())) {
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().mo15806c(new String[]{c7617ak.field_username}, "");
                    }
                }
                AppMethodBeat.m2505o(16280);
            }
        }
    }

    /* renamed from: ZO */
    static /* synthetic */ C9638aw m17194ZO() {
        AppMethodBeat.m2504i(16313);
        C9638aw ZH = C9638aw.m17187ZH();
        AppMethodBeat.m2505o(16313);
        return ZH;
    }

    static {
        AppMethodBeat.m2504i(16314);
        AppMethodBeat.m2505o(16314);
    }

    /* renamed from: ZD */
    public static boolean m17183ZD() {
        return flB == null;
    }

    /* renamed from: a */
    public static void m17198a(C1923n c1923n) {
        AppMethodBeat.m2504i(16285);
        C1720g.m3537RQ();
        C1720g.m3535RO().mo5187a(c1923n);
        AppMethodBeat.m2505o(16285);
    }

    /* renamed from: b */
    public static void m17200b(C1923n c1923n) {
        AppMethodBeat.m2504i(16286);
        C1720g.m3537RQ();
        C1720g.m3535RO().mo5188b(c1923n);
        AppMethodBeat.m2505o(16286);
    }

    /* renamed from: a */
    public static void m17196a(C1814al c1814al) {
        AppMethodBeat.m2504i(16287);
        C1682b.m3429a(c1814al);
        AppMethodBeat.m2505o(16287);
    }

    /* renamed from: lE */
    public static void m17202lE(String str) {
        AppMethodBeat.m2504i(16288);
        C1668a.m3406lE(str);
        AppMethodBeat.m2505o(16288);
    }

    /* renamed from: ZE */
    public static C45439bw m17184ZE() {
        AppMethodBeat.m2504i(16289);
        C9638aw.m17187ZH();
        C45439bw c45439bw = flD;
        AppMethodBeat.m2505o(16289);
        return c45439bw;
    }

    /* renamed from: ZF */
    public static boolean m17185ZF() {
        AppMethodBeat.m2504i(16290);
        boolean QS = C1668a.m3392QS();
        AppMethodBeat.m2505o(16290);
        return QS;
    }

    /* renamed from: ZG */
    public static void m17186ZG() {
        AppMethodBeat.m2504i(16291);
        C1668a.m3401cm(false);
        AppMethodBeat.m2505o(16291);
    }

    /* renamed from: a */
    public static void m17197a(C26412am c26412am, C1213a c1213a) {
        AppMethodBeat.m2504i(16292);
        flB = new C9638aw(c26412am, c1213a);
        C18698o.m29226ce(C4996ah.getContext());
        AppMethodBeat.m2505o(16292);
    }

    public static C24672an getNotification() {
        AppMethodBeat.m2504i(16293);
        C24672an notification = C9638aw.m17187ZH().flA.getNotification();
        AppMethodBeat.m2505o(16293);
        return notification;
    }

    /* renamed from: Cc */
    public static C9634ae m17176Cc() {
        AppMethodBeat.m2504i(16294);
        C9634ae Cc = C9638aw.m17187ZH().flA.mo20415Cc();
        AppMethodBeat.m2505o(16294);
        return Cc;
    }

    private C9638aw(C26412am c26412am, C1213a c1213a) {
        AppMethodBeat.m2504i(16295);
        this.flA = c26412am;
        this.flF = new C96401();
        C1720g.m3537RQ();
        C1720g.m3542a(C9643a.class, new C9643a());
        C1720g.m3537RQ().eKp.mo14670aD(c1213a);
        this.flr = new C18628c();
        C7060h.pYm.mo8378a(99, 142, 1, false);
        C7475t.m12873a(new C96392());
        C1720g.m3537RQ();
        C1682b RO = C1720g.m3535RO();
        RO.eJn.mo14670aD(new C96413());
        AppMethodBeat.m2505o(16295);
    }

    /* renamed from: ZH */
    private static C9638aw m17187ZH() {
        AppMethodBeat.m2504i(16296);
        Assert.assertNotNull("MMCore not initialized by MMApplication", flB);
        C9638aw c9638aw = flB;
        AppMethodBeat.m2505o(16296);
        return c9638aw;
    }

    /* renamed from: ZI */
    public static C5144y m17188ZI() {
        AppMethodBeat.m2504i(16297);
        C1720g.m3537RQ();
        C5144y c5144y = C1720g.m3536RP().eJH;
        AppMethodBeat.m2505o(16297);
        return c5144y;
    }

    @Deprecated
    /* renamed from: RS */
    public static C5004al m17180RS() {
        AppMethodBeat.m2504i(16298);
        C5004al RS = C1720g.m3539RS();
        AppMethodBeat.m2505o(16298);
        return RS;
    }

    public static C6673bz getSysCmdMsgExtension() {
        AppMethodBeat.m2504i(16299);
        C6673bz sysCmdMsgExtension = ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension();
        AppMethodBeat.m2505o(16299);
        return sysCmdMsgExtension;
    }

    /* renamed from: Rb */
    public static String m17181Rb() {
        AppMethodBeat.m2504i(16300);
        String Rb = C1668a.m3397Rb();
        AppMethodBeat.m2505o(16300);
        return Rb;
    }

    /* renamed from: ZJ */
    public static void m17189ZJ() {
        AppMethodBeat.m2504i(16301);
        C4879a.xxA.mo10055m(new C6458aa());
        AppMethodBeat.m2505o(16301);
    }

    /* renamed from: ZK */
    public static C18628c m17190ZK() {
        AppMethodBeat.m2504i(16302);
        C18628c c18628c = C9638aw.m17187ZH().flr;
        Assert.assertTrue("MMCore has not been initialize ?", c18628c != null);
        AppMethodBeat.m2505o(16302);
        return c18628c;
    }

    /* renamed from: Rg */
    public static C6300p m17182Rg() {
        AppMethodBeat.m2504i(16303);
        C1720g.m3537RQ();
        C6300p c6300p = C1720g.m3535RO().eJo;
        AppMethodBeat.m2505o(16303);
        return c6300p;
    }

    /* renamed from: ZL */
    public static C1407g m17191ZL() {
        AppMethodBeat.m2504i(16304);
        C1407g KK = C1407g.m2946KK();
        AppMethodBeat.m2505o(16304);
        return KK;
    }

    /* renamed from: ZM */
    public static boolean m17192ZM() {
        AppMethodBeat.m2504i(16305);
        C1720g.m3534RN();
        boolean QX = C1668a.m3395QX();
        AppMethodBeat.m2505o(16305);
        return QX;
    }

    /* renamed from: RK */
    public static boolean m17179RK() {
        AppMethodBeat.m2504i(16306);
        if (C4996ah.bqo()) {
            boolean RK = C1720g.m3531RK();
            AppMethodBeat.m2505o(16306);
            return RK;
        }
        AppMethodBeat.m2505o(16306);
        return false;
    }

    /* renamed from: QT */
    public static boolean m17178QT() {
        AppMethodBeat.m2504i(16307);
        boolean QT = C1668a.m3393QT();
        AppMethodBeat.m2505o(16307);
        return QT;
    }

    public static void hold() {
        AppMethodBeat.m2504i(16308);
        C1668a.hold();
        AppMethodBeat.m2505o(16308);
    }

    public static void unhold() {
        AppMethodBeat.m2504i(16309);
        C1668a.unhold();
        AppMethodBeat.m2505o(16309);
    }

    /* renamed from: QH */
    public static String m17177QH() {
        AppMethodBeat.m2504i(16310);
        C1720g.m3537RQ();
        C1720g.m3534RN();
        String QH = C1668a.m3385QH();
        AppMethodBeat.m2505o(16310);
        return QH;
    }

    /* renamed from: ZN */
    public static C42195f m17193ZN() {
        AppMethodBeat.m2504i(16311);
        C42195f c42195f = C9638aw.m17187ZH().flO;
        AppMethodBeat.m2505o(16311);
        return c42195f;
    }
}
