package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.le;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public final class c implements p, d {
    public final void d(com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(26590);
        g jD = f.jD(cVar.field_favLocalId);
        if (jD == null) {
            com.tencent.mm.plugin.wenote.model.d dVar = com.tencent.mm.plugin.wenote.model.c.ddG().uMN;
            if (dVar == null || dVar.uMP == null) {
                AppMethodBeat.o(26590);
                return;
            } else if (cVar.field_favLocalId != dVar.uMP.cHh) {
                ab.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", Long.valueOf(cVar.field_favLocalId), Long.valueOf(dVar.uMP.cHh));
                AppMethodBeat.o(26590);
                return;
            }
        } else if (jD.field_type != 18) {
            ab.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", Long.valueOf(cVar.field_favLocalId));
            AppMethodBeat.o(26590);
            return;
        }
        if (cVar.field_status == 3 && e.ct(cVar.field_path) && cVar.field_path.endsWith("..htm")) {
            f.y(cVar.field_favLocalId, cVar.field_path);
        }
        com.tencent.mm.plugin.wenote.model.e eVar = new com.tencent.mm.plugin.wenote.model.e();
        eVar.field_favLocalId = cVar.field_favLocalId;
        eVar.field_dataId = cVar.field_dataId;
        eVar.field_status = cVar.field_status;
        eVar.field_offset = cVar.field_offset;
        eVar.field_totalLen = cVar.field_totalLen;
        eVar.field_path = cVar.field_path;
        a(eVar);
        AppMethodBeat.o(26590);
    }

    private static void a(com.tencent.mm.plugin.wenote.model.e eVar) {
        int i = 0;
        AppMethodBeat.i(26592);
        com.tencent.mm.plugin.wenote.model.d dVar = com.tencent.mm.plugin.wenote.model.c.ddG().uMN;
        if (dVar == null) {
            AppMethodBeat.o(26592);
            return;
        }
        if (eVar.isFinished()) {
            if (e.ct(eVar.field_path)) {
                String str = (String) dVar.uMS.get(eVar.field_dataId);
                if (!bo.isNullOrNil(str)) {
                    ab.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", str);
                    if (!eVar.field_dataId.endsWith("_t") || dVar.uMT.get(str) == null) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar;
                        if (str.equals("WeNoteHtmlFile")) {
                            w wVar;
                            ab.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
                            if (dVar.uMP.cHh == -1) {
                                wVar = (w) dVar.uMR.get(Long.toString(dVar.uMP.cvx));
                            } else {
                                wVar = (w) dVar.uMR.get(Long.toString(dVar.uMP.cHh));
                            }
                            if (wVar == null) {
                                AppMethodBeat.o(26592);
                                return;
                            }
                            try {
                                wVar.uOE = com.tencent.mm.vfs.e.cy(eVar.field_path);
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().ahd(wVar.uOE);
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", e, "", new Object[0]);
                            }
                        } else if (dVar.uMS.containsValue("WeNoteHtmlFile")) {
                            w wVar2;
                            if (dVar.uMP.cHh == -1) {
                                wVar2 = (w) dVar.uMR.get(Long.toString(dVar.uMP.cvx));
                            } else {
                                wVar2 = (w) dVar.uMR.get(Long.toString(dVar.uMP.cHh));
                            }
                            if (wVar2 == null || wVar2.uOF == null) {
                                AppMethodBeat.o(26592);
                                return;
                            }
                            Iterator it = wVar2.uOF.iterator();
                            while (it.hasNext()) {
                                cVar = (o) it.next();
                                if (cVar.uOo.equals(str)) {
                                    cVar.uOp = true;
                                    if (cVar.type == 4) {
                                        v vVar = (v) cVar;
                                        vVar.hNN = com.tencent.mm.plugin.wenote.model.d.uNb;
                                        aar agV = dVar.agV(eVar.field_dataId);
                                        if (agV == null) {
                                            ab.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                        } else {
                                            i = agV.duration;
                                        }
                                        vVar.length = (int) f.fY((long) i);
                                        vVar.uOC = f.K(ah.getContext(), vVar.length);
                                        vVar.cAP = i;
                                    } else if (cVar.getType() == 2) {
                                        com.tencent.mm.plugin.wenote.b.c.ht(eVar.field_path, ((o) dVar.uMT.get(str)).cHg);
                                    } else {
                                        cVar.cHg = eVar.field_path;
                                    }
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(str, cVar);
                                }
                            }
                        } else {
                            le leVar = new le();
                            leVar.cHe.cGW = str;
                            leVar.cHe.cHg = eVar.field_path;
                            leVar.cHe.type = 1;
                            leVar.cHe.itemType = ((o) dVar.uMT.get(str)).type;
                            if (leVar.cHe.itemType != 4) {
                                cVar = (o) dVar.uMT.get(str);
                                if (leVar.cHe.itemType != 2) {
                                    cVar.cHg = eVar.field_path;
                                } else {
                                    com.tencent.mm.plugin.wenote.b.c.ht(eVar.field_path, cVar.cHg);
                                }
                                cVar.uOp = true;
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(str, cVar);
                            }
                            if (5 == leVar.cHe.itemType) {
                                AppMethodBeat.o(26592);
                                return;
                            }
                            if (leVar.cHe.itemType == 4) {
                                int i2;
                                aar agV2 = dVar.agV(eVar.field_dataId);
                                if (agV2 == null) {
                                    ab.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                    i2 = 0;
                                } else {
                                    i2 = agV2.duration;
                                }
                                leVar.cHe.cAP = i2;
                                ((o) dVar.uMT.get(str)).cHg = eVar.field_path;
                                ((o) dVar.uMT.get(str)).uOp = true;
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(str, (com.tencent.mm.plugin.wenote.model.a.c) dVar.uMT.get(str));
                            }
                            ab.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", leVar.cHe.cGW, leVar.cHe.cHg);
                        }
                        dVar.uMS.remove(eVar.field_dataId);
                    } else {
                        if (((o) dVar.uMT.get(str)).getType() == 2) {
                            ((o) dVar.uMT.get(str)).cHg = eVar.field_path;
                        }
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().a(str, (com.tencent.mm.plugin.wenote.model.a.c) dVar.uMT.get(str));
                        dVar.uMS.remove(eVar.field_dataId);
                        AppMethodBeat.o(26592);
                        return;
                    }
                }
            }
            AppMethodBeat.o(26592);
            return;
        }
        AppMethodBeat.o(26592);
    }

    public final void a(int i, i iVar) {
        AppMethodBeat.i(26591);
        com.tencent.mm.plugin.wenote.model.e eVar = new com.tencent.mm.plugin.wenote.model.e();
        eVar.field_localId = iVar.field_localId;
        eVar.field_dataId = iVar.field_dataId;
        eVar.field_status = iVar.field_status;
        eVar.field_offset = iVar.field_offset;
        eVar.field_totalLen = iVar.field_totalLen;
        eVar.field_path = iVar.field_path;
        a(eVar);
        AppMethodBeat.o(26591);
    }
}
