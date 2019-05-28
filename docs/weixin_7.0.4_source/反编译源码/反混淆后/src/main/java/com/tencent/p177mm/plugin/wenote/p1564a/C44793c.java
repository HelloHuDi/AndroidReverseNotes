package com.tencent.p177mm.plugin.wenote.p1564a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C26189le;
import com.tencent.p177mm.plugin.fav.p407a.C11855p;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.record.p1016a.C34792i;
import com.tencent.p177mm.plugin.record.p1016a.C43427d;
import com.tencent.p177mm.plugin.wenote.model.C14719f;
import com.tencent.p177mm.plugin.wenote.model.C40369d;
import com.tencent.p177mm.plugin.wenote.model.C46453c;
import com.tencent.p177mm.plugin.wenote.model.C46454e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29978o;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C4667v;
import com.tencent.p177mm.plugin.wenote.model.p585a.C4668w;
import com.tencent.p177mm.plugin.wenote.p1333b.C29977c;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.a.c */
public final class C44793c implements C11855p, C43427d {
    /* renamed from: d */
    public final void mo23673d(C45925c c45925c) {
        AppMethodBeat.m2504i(26590);
        C27966g jD = C14719f.m22909jD(c45925c.field_favLocalId);
        if (jD == null) {
            C40369d c40369d = C46453c.ddG().uMN;
            if (c40369d == null || c40369d.uMP == null) {
                AppMethodBeat.m2505o(26590);
                return;
            } else if (c45925c.field_favLocalId != c40369d.uMP.cHh) {
                C4990ab.m7417i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", Long.valueOf(c45925c.field_favLocalId), Long.valueOf(c40369d.uMP.cHh));
                AppMethodBeat.m2505o(26590);
                return;
            }
        } else if (jD.field_type != 18) {
            C4990ab.m7417i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", Long.valueOf(c45925c.field_favLocalId));
            AppMethodBeat.m2505o(26590);
            return;
        }
        if (c45925c.field_status == 3 && C1173e.m2561ct(c45925c.field_path) && c45925c.field_path.endsWith("..htm")) {
            C14719f.m22911y(c45925c.field_favLocalId, c45925c.field_path);
        }
        C46454e c46454e = new C46454e();
        c46454e.field_favLocalId = c45925c.field_favLocalId;
        c46454e.field_dataId = c45925c.field_dataId;
        c46454e.field_status = c45925c.field_status;
        c46454e.field_offset = c45925c.field_offset;
        c46454e.field_totalLen = c45925c.field_totalLen;
        c46454e.field_path = c45925c.field_path;
        C44793c.m81832a(c46454e);
        AppMethodBeat.m2505o(26590);
    }

    /* renamed from: a */
    private static void m81832a(C46454e c46454e) {
        int i = 0;
        AppMethodBeat.m2504i(26592);
        C40369d c40369d = C46453c.ddG().uMN;
        if (c40369d == null) {
            AppMethodBeat.m2505o(26592);
            return;
        }
        if (c46454e.isFinished()) {
            if (C1173e.m2561ct(c46454e.field_path)) {
                String str = (String) c40369d.uMS.get(c46454e.field_dataId);
                if (!C5046bo.isNullOrNil(str)) {
                    C4990ab.m7411d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", str);
                    if (!c46454e.field_dataId.endsWith("_t") || c40369d.uMT.get(str) == null) {
                        C44001c c44001c;
                        if (str.equals("WeNoteHtmlFile")) {
                            C4668w c4668w;
                            C4990ab.m7410d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
                            if (c40369d.uMP.cHh == -1) {
                                c4668w = (C4668w) c40369d.uMR.get(Long.toString(c40369d.uMP.cvx));
                            } else {
                                c4668w = (C4668w) c40369d.uMR.get(Long.toString(c40369d.uMP.cHh));
                            }
                            if (c4668w == null) {
                                AppMethodBeat.m2505o(26592);
                                return;
                            }
                            try {
                                c4668w.uOE = C5730e.m8631cy(c46454e.field_path);
                                C40380c.dem().ahd(c4668w.uOE);
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", e, "", new Object[0]);
                            }
                        } else if (c40369d.uMS.containsValue("WeNoteHtmlFile")) {
                            C4668w c4668w2;
                            if (c40369d.uMP.cHh == -1) {
                                c4668w2 = (C4668w) c40369d.uMR.get(Long.toString(c40369d.uMP.cvx));
                            } else {
                                c4668w2 = (C4668w) c40369d.uMR.get(Long.toString(c40369d.uMP.cHh));
                            }
                            if (c4668w2 == null || c4668w2.uOF == null) {
                                AppMethodBeat.m2505o(26592);
                                return;
                            }
                            Iterator it = c4668w2.uOF.iterator();
                            while (it.hasNext()) {
                                c44001c = (C29978o) it.next();
                                if (c44001c.uOo.equals(str)) {
                                    c44001c.uOp = true;
                                    if (c44001c.type == 4) {
                                        C4667v c4667v = (C4667v) c44001c;
                                        c4667v.hNN = C40369d.uNb;
                                        aar agV = c40369d.agV(c46454e.field_dataId);
                                        if (agV == null) {
                                            C4990ab.m7412e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                        } else {
                                            i = agV.duration;
                                        }
                                        c4667v.length = (int) C14719f.m22908fY((long) i);
                                        c4667v.uOC = C14719f.m22903K(C4996ah.getContext(), c4667v.length);
                                        c4667v.cAP = i;
                                    } else if (c44001c.getType() == 2) {
                                        C29977c.m47432ht(c46454e.field_path, ((C29978o) c40369d.uMT.get(str)).cHg);
                                    } else {
                                        c44001c.cHg = c46454e.field_path;
                                    }
                                    C40380c.dem().mo63755a(str, c44001c);
                                }
                            }
                        } else {
                            C26189le c26189le = new C26189le();
                            c26189le.cHe.cGW = str;
                            c26189le.cHe.cHg = c46454e.field_path;
                            c26189le.cHe.type = 1;
                            c26189le.cHe.itemType = ((C29978o) c40369d.uMT.get(str)).type;
                            if (c26189le.cHe.itemType != 4) {
                                c44001c = (C29978o) c40369d.uMT.get(str);
                                if (c26189le.cHe.itemType != 2) {
                                    c44001c.cHg = c46454e.field_path;
                                } else {
                                    C29977c.m47432ht(c46454e.field_path, c44001c.cHg);
                                }
                                c44001c.uOp = true;
                                C40380c.dem().mo63755a(str, c44001c);
                            }
                            if (5 == c26189le.cHe.itemType) {
                                AppMethodBeat.m2505o(26592);
                                return;
                            }
                            if (c26189le.cHe.itemType == 4) {
                                int i2;
                                aar agV2 = c40369d.agV(c46454e.field_dataId);
                                if (agV2 == null) {
                                    C4990ab.m7412e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                    i2 = 0;
                                } else {
                                    i2 = agV2.duration;
                                }
                                c26189le.cHe.cAP = i2;
                                ((C29978o) c40369d.uMT.get(str)).cHg = c46454e.field_path;
                                ((C29978o) c40369d.uMT.get(str)).uOp = true;
                                C40380c.dem().mo63755a(str, (C44001c) c40369d.uMT.get(str));
                            }
                            C4990ab.m7417i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", c26189le.cHe.cGW, c26189le.cHe.cHg);
                        }
                        c40369d.uMS.remove(c46454e.field_dataId);
                    } else {
                        if (((C29978o) c40369d.uMT.get(str)).getType() == 2) {
                            ((C29978o) c40369d.uMT.get(str)).cHg = c46454e.field_path;
                        }
                        C40380c.dem().mo63755a(str, (C44001c) c40369d.uMT.get(str));
                        c40369d.uMS.remove(c46454e.field_dataId);
                        AppMethodBeat.m2505o(26592);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(26592);
            return;
        }
        AppMethodBeat.m2505o(26592);
    }

    /* renamed from: a */
    public final void mo25051a(int i, C34792i c34792i) {
        AppMethodBeat.m2504i(26591);
        C46454e c46454e = new C46454e();
        c46454e.field_localId = c34792i.field_localId;
        c46454e.field_dataId = c34792i.field_dataId;
        c46454e.field_status = c34792i.field_status;
        c46454e.field_offset = c34792i.field_offset;
        c46454e.field_totalLen = c34792i.field_totalLen;
        c46454e.field_path = c34792i.field_path;
        C44793c.m81832a(c46454e);
        AppMethodBeat.m2505o(26591);
    }
}
