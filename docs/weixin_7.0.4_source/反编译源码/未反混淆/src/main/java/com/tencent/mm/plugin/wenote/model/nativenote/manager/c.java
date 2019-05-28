package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Editable;
import android.text.Spanned;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class c {
    private static volatile c uOZ = null;
    public ArrayList<com.tencent.mm.plugin.wenote.model.a.c> iPr = null;
    public a uPa = null;
    public aar uPb = null;
    public int uPc = 0;
    public int uPd = 0;
    public int uPe = 0;
    public boolean uPf = false;

    private c() {
    }

    public static c dem() {
        AppMethodBeat.i(26717);
        if (uOZ == null) {
            synchronized (c.class) {
                try {
                    if (uOZ == null) {
                        uOZ = new c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(26717);
                    }
                }
            }
        }
        c cVar = uOZ;
        AppMethodBeat.o(26717);
        return cVar;
    }

    public final int size() {
        AppMethodBeat.i(26718);
        if (this.iPr != null) {
            int size = this.iPr.size();
            AppMethodBeat.o(26718);
            return size;
        }
        AppMethodBeat.o(26718);
        return 0;
    }

    public final com.tencent.mm.plugin.wenote.model.a.c Ke(int i) {
        AppMethodBeat.i(26719);
        if (this.iPr == null || i < 0 || i >= this.iPr.size()) {
            AppMethodBeat.o(26719);
            return null;
        }
        com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i);
        AppMethodBeat.o(26719);
        return cVar;
    }

    public final boolean a(com.tencent.mm.plugin.wenote.model.a.c cVar) {
        boolean z = true;
        AppMethodBeat.i(26720);
        synchronized (this) {
            if (cVar != null) {
                try {
                    if (this.iPr != null) {
                        this.iPr.add(cVar);
                        a(cVar, true);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(26720);
                    }
                }
            }
            z = false;
        }
        AppMethodBeat.o(26720);
        return z;
    }

    public final boolean d(int i, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList) {
        AppMethodBeat.i(26721);
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(26721);
            return false;
        }
        int i2;
        int i3;
        boolean z;
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    int i4 = 0;
                    i2 = 0;
                    i3 = i;
                    while (i4 < arrayList.size() && i3 >= 0 && i3 <= this.iPr.size()) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) arrayList.get(i4);
                        if (cVar != null) {
                            b(cVar);
                            this.iPr.add(i3, cVar);
                            i2++;
                            i3++;
                            a(cVar, true);
                        }
                        i4++;
                        i2 = i2;
                    }
                    z = true;
                } else {
                    z = false;
                    i2 = 0;
                    i3 = i;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(26721);
                }
            }
        }
        if (z && this.uPa != null) {
            this.uPa.gC(i3 - i2, i2);
        }
        AppMethodBeat.o(26721);
        return z;
    }

    public final boolean a(int i, com.tencent.mm.plugin.wenote.model.a.c cVar) {
        boolean z = true;
        AppMethodBeat.i(26722);
        synchronized (this) {
            try {
                if (this.iPr == null || i < 0 || i > this.iPr.size()) {
                    z = false;
                } else {
                    this.iPr.add(i, cVar);
                    a(cVar, true);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(26722);
                }
            }
        }
        if (z && this.uPa != null) {
            this.uPa.JY(i);
            if (i > 0) {
                this.uPa.gD(i - 1, this.iPr.size() - (i - 1));
            } else {
                this.uPa.gD(i, this.iPr.size() - i);
            }
        }
        AppMethodBeat.o(26722);
        return z;
    }

    private boolean b(int i, com.tencent.mm.plugin.wenote.model.a.c cVar) {
        boolean z = true;
        AppMethodBeat.i(26723);
        if (cVar == null || this.iPr == null || i < 0 || i > this.iPr.size()) {
            z = false;
        } else {
            this.iPr.add(i, cVar);
            a(cVar, true);
        }
        AppMethodBeat.o(26723);
        return z;
    }

    public final boolean au(int i, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(26724);
        synchronized (this) {
            try {
                if (this.iPr != null && i >= 0 && i < this.iPr.size()) {
                    a((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i), false);
                    this.iPr.remove(i);
                    z2 = true;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(26724);
                }
            }
        }
        if (z2 && z && this.uPa != null) {
            this.uPa.JZ(i);
            if (i > 0) {
                this.uPa.gD(i - 1, this.iPr.size() - (i - 1));
            } else {
                this.uPa.gD(i, this.iPr.size() - i);
            }
        }
        AppMethodBeat.o(26724);
        return z2;
    }

    private boolean Kf(int i) {
        boolean z;
        AppMethodBeat.i(26725);
        if (this.iPr == null || i < 0 || i >= this.iPr.size()) {
            z = false;
        } else {
            a((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i), false);
            this.iPr.remove(i);
            z = true;
        }
        AppMethodBeat.o(26725);
        return z;
    }

    public final void Kg(int i) {
        AppMethodBeat.i(26726);
        if (this.uPa != null) {
            this.uPa.JX(i);
        }
        AppMethodBeat.o(26726);
    }

    /* JADX WARNING: Missing block: B:14:0x0044, code skipped:
            if (r0 == -1) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:16:0x0048, code skipped:
            if (r5.uPa == null) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:17:0x004a, code skipped:
            r5.uPa.JX(r0);
     */
    /* JADX WARNING: Missing block: B:18:0x004f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(26727);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(String str, com.tencent.mm.plugin.wenote.model.a.c cVar) {
        AppMethodBeat.i(26727);
        synchronized (this) {
            try {
                if (this.iPr == null) {
                } else {
                    int i;
                    for (int i2 = 0; i2 < this.iPr.size(); i2++) {
                        if (((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2)).ddP().equals(str)) {
                            a((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2), false);
                            this.iPr.set(i2, cVar);
                            a(cVar, true);
                            i = i2;
                            break;
                        }
                    }
                    i = -1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(26727);
            }
        }
    }

    public final void ahd(String str) {
        AppMethodBeat.i(26728);
        if (bo.isNullOrNil(str) || this.iPr == null) {
            AppMethodBeat.o(26728);
            return;
        }
        final ArrayList ahg = b.ahg(str);
        if (ahg == null || ahg.size() <= 0) {
            AppMethodBeat.o(26728);
            return;
        }
        synchronized (this) {
            try {
                long j;
                ab.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, mHasInitDataListFinish :％B", Boolean.valueOf(this.uPf));
                al RS = aw.RS();
                AnonymousClass2 anonymousClass2 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(26715);
                        ArrayList a = h.a(c.this.iPr, ahg, false);
                        ab.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, start mNotifyListener.setUpNoteData(dataItems, true)");
                        if (c.this.uPa != null) {
                            c.this.uPa.c(a, true);
                        }
                        AppMethodBeat.o(26715);
                    }
                };
                if (this.uPf) {
                    j = 500;
                } else {
                    j = 1000;
                }
                RS.m(anonymousClass2, j);
            } catch (Exception e) {
                ab.e("MicroMsg.Note.NoteDataManager", "updateDataByHtml exception,%s", e.toString());
            } catch (Throwable th) {
                AppMethodBeat.o(26728);
            }
        }
        AppMethodBeat.o(26728);
    }

    public final void den() {
        AppMethodBeat.i(26729);
        String str = "MicroMsg.Note.NoteDataManager";
        String str2 = "clear mDataList, size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.iPr != null ? this.iPr.size() : 0);
        ab.i(str, str2, objArr);
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    this.iPr.clear();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(26729);
            }
        }
        this.uPe = 0;
        this.uPd = 0;
    }

    /* JADX WARNING: Missing block: B:18:0x0033, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(26730);
     */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void av(int i, boolean z) {
        AppMethodBeat.i(26730);
        synchronized (this) {
            try {
                if (this.iPr == null) {
                } else {
                    com.tencent.mm.plugin.wenote.model.a.c cVar;
                    if (i >= 0) {
                        if (i < this.iPr.size()) {
                            cVar = (com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i);
                            if (!(cVar == null || cVar.uOa == z)) {
                                cVar.uOa = z;
                                if (this.uPa != null) {
                                    this.uPa.JX(i);
                                }
                            }
                        }
                    }
                    if (i == -1) {
                        for (int i2 = 0; i2 < this.iPr.size(); i2++) {
                            cVar = (com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2);
                            if (!(cVar == null || cVar.uOa == z)) {
                                cVar.uOa = z;
                                if (this.uPa != null) {
                                    this.uPa.JX(i2);
                                }
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(26730);
            }
        }
    }

    public final int deo() {
        int i;
        AppMethodBeat.i(26731);
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    for (int i2 = 0; i2 < this.iPr.size(); i2++) {
                        if (((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2)).uNT) {
                            i = i2;
                            break;
                        }
                    }
                }
                i = -1;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(26731);
            }
        }
        return i;
    }

    public final void dep() {
        AppMethodBeat.i(26732);
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    Iterator it = this.iPr.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
                        cVar.uNT = false;
                        cVar.uNZ = false;
                    }
                }
            } finally {
                AppMethodBeat.o(26732);
            }
        }
    }

    private void deq() {
        AppMethodBeat.i(26733);
        if (this.iPr != null) {
            Iterator it = this.iPr.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
                cVar.uNT = false;
                cVar.uNZ = false;
            }
        }
        AppMethodBeat.o(26733);
    }

    public final void aw(int i, boolean z) {
        AppMethodBeat.i(26734);
        synchronized (this) {
            try {
                if (this.iPr == null || i < 0 || i >= this.iPr.size()) {
                } else {
                    for (int i2 = 0; i2 < this.iPr.size(); i2++) {
                        if (i2 == i) {
                            ((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2)).uNT = true;
                            ((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2)).uNZ = z;
                        } else {
                            ((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2)).uNT = false;
                            ((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2)).uNZ = false;
                        }
                    }
                    AppMethodBeat.o(26734);
                }
            } finally {
                AppMethodBeat.o(26734);
            }
        }
    }

    public final int der() {
        int i;
        AppMethodBeat.i(26735);
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    int i2 = 0;
                    while (i2 < this.iPr.size()) {
                        if (((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2)).getType() == 4 && ((l) this.iPr.get(i2)).uOh.booleanValue()) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                }
                i = -1;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(26735);
            }
        }
        return i;
    }

    public final String des() {
        String stringBuilder;
        AppMethodBeat.i(26736);
        synchronized (this) {
            try {
                if (this.uPc == 0 && this.iPr != null) {
                    Iterator it = this.iPr.iterator();
                    while (it.hasNext()) {
                        o oVar = (o) ((com.tencent.mm.plugin.wenote.model.a.c) it.next());
                        if (oVar.uOo.startsWith("WeNote_")) {
                            int i = bo.getInt(oVar.uOo.substring(7), -1);
                            if (i <= this.uPc) {
                                i = this.uPc;
                            }
                            this.uPc = i;
                        }
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder("WeNote_");
                int i2 = this.uPc + 1;
                this.uPc = i2;
                stringBuilder = stringBuilder2.append(i2).toString();
            } finally {
                AppMethodBeat.o(26736);
            }
        }
        return stringBuilder;
    }

    private String det() {
        AppMethodBeat.i(26737);
        if (this.uPc == 0 && this.iPr != null) {
            Iterator it = this.iPr.iterator();
            while (it.hasNext()) {
                o oVar = (o) ((com.tencent.mm.plugin.wenote.model.a.c) it.next());
                if (oVar.uOo.startsWith("WeNote_")) {
                    int i = bo.getInt(oVar.uOo.substring(7), -1);
                    if (i <= this.uPc) {
                        i = this.uPc;
                    }
                    this.uPc = i;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("WeNote_");
        int i2 = this.uPc + 1;
        this.uPc = i2;
        String stringBuilder2 = stringBuilder.append(i2).toString();
        AppMethodBeat.o(26737);
        return stringBuilder2;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String deu() {
        String str;
        AppMethodBeat.i(26738);
        String str2 = "";
        synchronized (this) {
            try {
                if (this.iPr == null || this.iPr.size() <= 0) {
                    str = "";
                } else {
                    int i = 0;
                    while (i < this.iPr.size()) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i);
                        switch (cVar.getType()) {
                            case -1:
                                str = str2 + "<hr/>";
                                break;
                            case 1:
                                i iVar = (i) cVar;
                                if (!bo.isNullOrNil(iVar.content)) {
                                    str2 = str2 + iVar.content;
                                    if (i + 1 < this.iPr.size() && ((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i + 1)).getType() == 1 && !bo.isNullOrNil(((i) this.iPr.get(i + 1)).content)) {
                                        str = str2 + "<br/>";
                                        break;
                                    }
                                }
                                str = str2 + "<br/>";
                                break;
                            case 2:
                                str = str2 + dO(((f) cVar).uOo, 2);
                                break;
                            case 3:
                                str = str2 + dO(((g) cVar).uOo, 3);
                                break;
                            case 4:
                                l lVar = (l) cVar;
                                str = str2 + dO(lVar.uOo, lVar.getType());
                                break;
                            case 5:
                                str = str2 + dO(((d) cVar).uOo, 5);
                                break;
                            case 6:
                                str = str2 + dO(((k) cVar).uOo, 6);
                                break;
                            case 20:
                                str = str2 + dO(((com.tencent.mm.plugin.wenote.model.a.b) cVar).uOo, 20);
                                break;
                            default:
                                str = str2;
                                break;
                        }
                        i++;
                        str2 = str;
                    }
                    str = str2.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "<br/>");
                    AppMethodBeat.o(26738);
                }
            } finally {
                while (true) {
                    AppMethodBeat.o(26738);
                }
            }
        }
        return str;
    }

    private static String dO(String str, int i) {
        AppMethodBeat.i(26739);
        String format = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[]{Integer.valueOf(i), str, str});
        AppMethodBeat.o(26739);
        return format;
    }

    public final abf ahe(String str) {
        abf abf = null;
        AppMethodBeat.i(26740);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
            AppMethodBeat.o(26740);
            return null;
        }
        String o;
        int i;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            int i2 = 0;
            while (i2 < this.iPr.size()) {
                try {
                    com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2);
                    if (bo.isNullOrNil(cVar.mnd)) {
                        cVar.mnd = com.tencent.mm.plugin.wenote.model.f.agW(cVar.toString());
                    }
                    i iVar;
                    i iVar2;
                    if (cVar.getType() == -1) {
                        if (arrayList.size() <= 0 || ((o) arrayList.get(arrayList.size() - 1)).type != 1) {
                            iVar = new i();
                            iVar.content = IOUtils.LINE_SEPARATOR_UNIX;
                            iVar.mnd = cVar.mnd;
                            iVar.uOo = "-1";
                            iVar.type = 1;
                            iVar.uOn = null;
                            arrayList.add(iVar);
                        } else {
                            iVar2 = (i) arrayList.get(arrayList.size() - 1);
                            iVar2.content += IOUtils.LINE_SEPARATOR_UNIX;
                        }
                    } else if (cVar.getType() >= -1) {
                        if ((cVar.getType() == 6 || cVar.getType() == 4) && bo.isNullOrNil(((o) cVar).cHg)) {
                            aar aar = new aar();
                            aar.akU(cVar.mnd);
                            aar.akR(cVar.ddQ());
                            o = com.tencent.mm.plugin.wenote.model.f.o(aar);
                            if (e.ct(o)) {
                                ab.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", Integer.valueOf(cVar.getType()));
                                ((o) cVar).cHg = o;
                            }
                        }
                        if (cVar.getType() != 1) {
                            arrayList.add((o) cVar);
                        } else {
                            iVar2 = (i) cVar;
                            if (!bo.isNullOrNil(iVar2.content)) {
                                if (arrayList.size() <= 0 || ((o) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                    iVar = new i();
                                    iVar.content = iVar2.content;
                                    iVar.mnd = iVar2.mnd;
                                    iVar.uOo = iVar2.uOo;
                                    iVar.type = iVar2.type;
                                    iVar.uOn = null;
                                    arrayList.add(iVar);
                                } else {
                                    iVar = (i) arrayList.get(arrayList.size() - 1);
                                    iVar.content += iVar2.content;
                                }
                                if (i2 + 1 < this.iPr.size() && ((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2 + 1)).getType() == 1 && !bo.isNullOrNil(((i) this.iPr.get(i2 + 1)).content)) {
                                    iVar2 = (i) arrayList.get(arrayList.size() - 1);
                                    iVar2.content += "<br/>";
                                }
                            } else if (arrayList.size() <= 0 || ((o) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                iVar = new i();
                                iVar.content = "<br/>";
                                iVar.mnd = iVar2.mnd;
                                iVar.uOo = iVar2.uOo;
                                iVar.type = iVar2.type;
                                iVar.uOn = null;
                                arrayList.add(iVar);
                            } else {
                                iVar2 = (i) arrayList.get(arrayList.size() - 1);
                                iVar2.content += "<br/>";
                            }
                        }
                    }
                    i2++;
                } finally {
                    AppMethodBeat.o(26740);
                }
            }
        }
        String replaceAll = Pattern.compile("</wx-", 2).matcher(Pattern.compile("<wx-", 2).matcher(str).replaceAll("<")).replaceAll("</");
        byte[] bytes;
        try {
            bytes = replaceAll.getBytes("UTF-8");
            i = 0;
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.Note.NoteDataManager", e, "", new Object[0]);
            ab.e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
            boolean i3 = true;
            bytes = null;
        }
        this.uPb.LE(8);
        this.uPb.ale("WeNoteHtmlFile");
        this.uPb.oY(true);
        this.uPb.akR(".htm");
        this.uPb.akU(com.tencent.mm.plugin.wenote.model.f.agW(this.uPb.toString()));
        o = com.tencent.mm.plugin.wenote.model.f.o(this.uPb);
        ab.i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", o);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(o);
        if (bVar.exists()) {
            bVar.delete();
        }
        if (!bVar.exists()) {
            try {
                bVar.createNewFile();
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.Note.NoteDataManager", e2, "", new Object[0]);
                AppMethodBeat.o(26740);
                return null;
            }
        }
        if (i3 == 0 && e.b(o, bytes, bytes.length) == 0) {
            this.uPb.akV(o);
            ab.i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
            abf = com.tencent.mm.plugin.wenote.model.d.a(replaceAll, arrayList, this.uPb);
            return abf;
        }
        ab.i("MicroMsg.Note.NoteDataManager", "writefile error,return");
        Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.bra), 1).show();
        AppMethodBeat.o(26740);
        return null;
    }

    public final int a(com.tencent.mm.plugin.wenote.model.a.c cVar, WXRTEditText wXRTEditText, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(26741);
        if (cVar == null) {
            AppMethodBeat.o(26741);
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        int a = a(arrayList, wXRTEditText, true, z, z2, z3);
        AppMethodBeat.o(26741);
        return a;
    }

    /* JADX WARNING: Missing block: B:68:0x0100, code skipped:
            if ((r2 - 1) < 0) goto L_0x0281;
     */
    /* JADX WARNING: Missing block: B:70:0x010c, code skipped:
            if ((r2 - 1) >= dem().size()) goto L_0x0281;
     */
    /* JADX WARNING: Missing block: B:71:0x010e, code skipped:
            r1 = r2 - 1;
     */
    /* JADX WARNING: Missing block: B:72:0x0110, code skipped:
            if (r16 == false) goto L_0x0133;
     */
    /* JADX WARNING: Missing block: B:73:0x0112, code skipped:
            r1 = r1 + 1;
            r2 = r2 + 1;
            deq();
     */
    /* JADX WARNING: Missing block: B:74:0x0121, code skipped:
            if (r1 >= dem().size()) goto L_0x028d;
     */
    /* JADX WARNING: Missing block: B:75:0x0123, code skipped:
            r6 = dem().Ke(r1);
     */
    /* JADX WARNING: Missing block: B:76:0x012b, code skipped:
            if (r6 == null) goto L_0x0133;
     */
    /* JADX WARNING: Missing block: B:77:0x012d, code skipped:
            r6.uNV = 0;
            r6.uNT = true;
            r6.uNZ = false;
     */
    /* JADX WARNING: Missing block: B:79:0x0135, code skipped:
            if (r10.uPa == null) goto L_0x0166;
     */
    /* JADX WARNING: Missing block: B:80:0x0137, code skipped:
            r2 = r2 - r3;
     */
    /* JADX WARNING: Missing block: B:81:0x0138, code skipped:
            if (r4 == false) goto L_0x013c;
     */
    /* JADX WARNING: Missing block: B:82:0x013a, code skipped:
            r2 = r2 + 1;
     */
    /* JADX WARNING: Missing block: B:83:0x013c, code skipped:
            if (r3 < 0) goto L_0x0145;
     */
    /* JADX WARNING: Missing block: B:84:0x013e, code skipped:
            if (r2 <= 0) goto L_0x0145;
     */
    /* JADX WARNING: Missing block: B:85:0x0140, code skipped:
            r10.uPa.gC(r3, r2);
     */
    /* JADX WARNING: Missing block: B:86:0x0145, code skipped:
            if (r3 <= 0) goto L_0x02a4;
     */
    /* JADX WARNING: Missing block: B:87:0x0147, code skipped:
            r10.uPa.gD(r3 - 1, dem().size() - (r3 - 1));
     */
    /* JADX WARNING: Missing block: B:88:0x015a, code skipped:
            if (r15 == false) goto L_0x0161;
     */
    /* JADX WARNING: Missing block: B:89:0x015c, code skipped:
            r10.uPa.ddV();
     */
    /* JADX WARNING: Missing block: B:90:0x0161, code skipped:
            r10.uPa.Ka(r1);
     */
    /* JADX WARNING: Missing block: B:91:0x0166, code skipped:
            dew();
            com.tencent.matrix.trace.core.AppMethodBeat.o(26742);
     */
    /* JADX WARNING: Missing block: B:145:0x0281, code skipped:
            r1 = dem().size() - 1;
     */
    /* JADX WARNING: Missing block: B:146:0x028d, code skipped:
            r6 = new com.tencent.mm.plugin.wenote.model.a.i();
            r6.type = 1;
            r6.content = "";
            r6.uNV = 0;
            r6.uNT = true;
            r6.uNZ = false;
            b(r1, r6);
     */
    /* JADX WARNING: Missing block: B:147:0x02a4, code skipped:
            if (r3 != 0) goto L_0x015a;
     */
    /* JADX WARNING: Missing block: B:148:0x02a6, code skipped:
            r10.uPa.gD(r3, dem().size() - r3);
     */
    /* JADX WARNING: Missing block: B:166:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList, WXRTEditText wXRTEditText, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(26742);
        if (arrayList == null || arrayList.size() <= 0 || this.iPr == null) {
            ab.e("MicroMsg.Note.NoteDataManager", "insertItemList,error,return");
            AppMethodBeat.o(26742);
            return -1;
        } else if (com.tencent.mm.plugin.wenote.model.c.ddG().uMN == null) {
            ab.e("MicroMsg.Note.NoteDataManager", "insertItemList, but get wnnote base is null, return");
            AppMethodBeat.o(26742);
            return -1;
        } else if (z2 && af(arrayList) && this.uPa != null) {
            this.uPa.ddW();
            AppMethodBeat.o(26742);
            return -1;
        } else {
            com.tencent.mm.plugin.wenote.model.a.c cVar;
            int type;
            i iVar;
            if (z) {
                cVar = (com.tencent.mm.plugin.wenote.model.a.c) arrayList.get(arrayList.size() - 1);
                cVar.uNV = -1;
                cVar.uNT = true;
                cVar.uNZ = false;
                if (wXRTEditText != null && wXRTEditText.uQc) {
                    if (wXRTEditText.getEditTextType() == 2) {
                        cVar.uOc = 2;
                    } else if (wXRTEditText.getEditTextType() == 1) {
                        cVar.uOc = 1;
                    }
                    wXRTEditText.uQc = false;
                    cVar.uOd = wXRTEditText.uOd;
                    wXRTEditText.uOd = 0;
                }
            }
            if (wXRTEditText != null && wXRTEditText.getRecyclerItemPosition() == 0 && wXRTEditText.getEditTextType() != 2 && wXRTEditText.getSelectionStart() == 0 && arrayList != null && arrayList.size() > 0) {
                type = ((com.tencent.mm.plugin.wenote.model.a.c) arrayList.get(0)).getType();
                if (type == 2 || type == 6 || type == 5 || type == 3 || type == 4) {
                    iVar = new i();
                    iVar.content = "";
                    iVar.uNT = false;
                    iVar.uNZ = false;
                    arrayList.add(0, iVar);
                }
            }
            synchronized (this) {
                int size;
                Iterator it;
                int i;
                boolean z5;
                if (wXRTEditText == null) {
                    try {
                        size = size();
                        deq();
                        it = arrayList.iterator();
                        i = size;
                        while (it.hasNext()) {
                            boolean z6;
                            cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
                            b(cVar);
                            if (cVar == null || this.iPr == null) {
                                z6 = false;
                            } else {
                                this.iPr.add(cVar);
                                a(cVar, true);
                                z6 = true;
                            }
                            if (z6) {
                                type = i + 1;
                            } else {
                                type = i;
                            }
                            i = type;
                        }
                        z5 = false;
                    } catch (Throwable th) {
                        AppMethodBeat.o(26742);
                    }
                } else {
                    int recyclerItemPosition = wXRTEditText.getRecyclerItemPosition();
                    com.tencent.mm.plugin.wenote.model.a.c Ke = Ke(recyclerItemPosition);
                    if (Ke == null) {
                        AppMethodBeat.o(26742);
                        return -1;
                    }
                    deq();
                    if (wXRTEditText.getEditTextType() == 0 && Ke.getType() == 1) {
                        e selection = wXRTEditText.getSelection();
                        Editable text = wXRTEditText.getText();
                        CharSequence subSequence = text.subSequence(0, selection.aqm);
                        CharSequence subSequence2 = text.subSequence(selection.Ls, text.length());
                        String a = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) subSequence);
                        String a2 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) subSequence2);
                        iVar = (i) Ke;
                        if (!bo.isNullOrNil(a)) {
                            iVar.content = a.endsWith("<br/>") ? a.substring(0, a.length() - 5) : a;
                            recyclerItemPosition++;
                            if (!bo.isNullOrNil(a2)) {
                                cVar = new i();
                                cVar.type = 1;
                                if (a2.startsWith("<br/>")) {
                                    a2 = a2.substring(5, a2.length());
                                }
                                cVar.content = a2;
                                cVar.uNV = 0;
                                cVar.uNT = false;
                                cVar.uNZ = false;
                                b(recyclerItemPosition, cVar);
                                size = recyclerItemPosition;
                                z5 = true;
                                i = recyclerItemPosition;
                            }
                            size = recyclerItemPosition;
                            z5 = false;
                            i = recyclerItemPosition;
                        } else if (bo.isNullOrNil(a2)) {
                            Kf(recyclerItemPosition);
                            if (this.uPa != null) {
                                this.uPa.JZ(recyclerItemPosition);
                            }
                            size = recyclerItemPosition;
                            z5 = false;
                            i = recyclerItemPosition;
                        } else {
                            if (a2.startsWith("<br/>")) {
                                a2 = a2.substring(5, a2.length());
                            }
                            iVar.content = a2;
                            size = recyclerItemPosition;
                            z5 = false;
                            i = recyclerItemPosition;
                        }
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            cVar = (com.tencent.mm.plugin.wenote.model.a.c) it2.next();
                            b(cVar);
                            if (b(i, cVar)) {
                                type = i + 1;
                            } else {
                                type = i;
                            }
                            i = type;
                        }
                    } else {
                        if (wXRTEditText.getEditTextType() != 1) {
                            size = recyclerItemPosition + 1;
                        } else {
                            size = recyclerItemPosition;
                        }
                        it = arrayList.iterator();
                        i = size;
                        while (it.hasNext()) {
                            cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
                            b(cVar);
                            if (b(i, cVar)) {
                                type = i + 1;
                            } else {
                                type = i;
                            }
                            i = type;
                        }
                        z5 = false;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:80:0x01a9, code skipped:
            if ((r2 - 1) < 0) goto L_0x01f2;
     */
    /* JADX WARNING: Missing block: B:82:0x01b5, code skipped:
            if ((r2 - 1) >= dem().size()) goto L_0x01f2;
     */
    /* JADX WARNING: Missing block: B:83:0x01b7, code skipped:
            r1 = r2 - 1;
     */
    /* JADX WARNING: Missing block: B:85:0x01bb, code skipped:
            if (r9.uPa == null) goto L_0x01e4;
     */
    /* JADX WARNING: Missing block: B:86:0x01bd, code skipped:
            r2 = r2 - r5;
     */
    /* JADX WARNING: Missing block: B:87:0x01be, code skipped:
            if (r3 == false) goto L_0x01c2;
     */
    /* JADX WARNING: Missing block: B:88:0x01c0, code skipped:
            r2 = r2 + 1;
     */
    /* JADX WARNING: Missing block: B:89:0x01c2, code skipped:
            if (r5 < 0) goto L_0x01cb;
     */
    /* JADX WARNING: Missing block: B:90:0x01c4, code skipped:
            if (r2 <= 0) goto L_0x01cb;
     */
    /* JADX WARNING: Missing block: B:91:0x01c6, code skipped:
            r9.uPa.gC(r5, r2);
     */
    /* JADX WARNING: Missing block: B:92:0x01cb, code skipped:
            if (r5 <= 0) goto L_0x01fd;
     */
    /* JADX WARNING: Missing block: B:93:0x01cd, code skipped:
            r9.uPa.gD(r5 - 1, dem().size() - (r5 - 1));
     */
    /* JADX WARNING: Missing block: B:94:0x01df, code skipped:
            r9.uPa.Ka(r1);
     */
    /* JADX WARNING: Missing block: B:95:0x01e4, code skipped:
            dew();
            com.tencent.matrix.trace.core.AppMethodBeat.o(26743);
     */
    /* JADX WARNING: Missing block: B:100:0x01f2, code skipped:
            r1 = dem().size() - 1;
     */
    /* JADX WARNING: Missing block: B:101:0x01fd, code skipped:
            if (r5 != 0) goto L_0x01df;
     */
    /* JADX WARNING: Missing block: B:102:0x01ff, code skipped:
            r9.uPa.gD(r5, dem().size() - r5);
     */
    /* JADX WARNING: Missing block: B:120:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(26743);
        if (arrayList == null || arrayList.size() <= 0 || this.iPr == null || i2 < 0 || i3 < 0 || i4 < 0 || i4 < i3) {
            ab.e("MicroMsg.Note.NoteDataManager", "pasteItemList,error,return");
            AppMethodBeat.o(26743);
            return -1;
        } else if (com.tencent.mm.plugin.wenote.model.c.ddG().uMN == null) {
            ab.e("MicroMsg.Note.NoteDataManager", "pasteItemList, but get wnnote base is null, return");
            AppMethodBeat.o(26743);
            return -1;
        } else {
            com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) arrayList.get(arrayList.size() - 1);
            if (cVar == null) {
                ab.e("MicroMsg.Note.NoteDataManager", "pasteItemList, lastInsertItem is null");
                AppMethodBeat.o(26743);
                return -1;
            }
            cVar.uNV = -1;
            cVar.uNT = true;
            cVar.uNZ = false;
            com.tencent.mm.plugin.wenote.model.a.c Ke = Ke(i2);
            if (Ke == null) {
                ab.e("MicroMsg.Note.NoteDataManager", "pasteItemList, item is null");
                AppMethodBeat.o(26743);
                return -1;
            }
            synchronized (this) {
                try {
                    deq();
                    boolean z;
                    int i5;
                    int i6;
                    int i7;
                    if (i == 0 && Ke.getType() == 1) {
                        Spanned ahb = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ahb(((i) Ke).content);
                        if (ahb == null || i3 > ahb.length() || i4 > ahb.length()) {
                            String str = "MicroMsg.Note.NoteDataManager";
                            String str2 = "pasteItemList error, oriText:%d  startOff:%d  endOff:%d";
                            Object[] objArr = new Object[3];
                            objArr[0] = Integer.valueOf(ahb == null ? -1 : ahb.length());
                            objArr[1] = Integer.valueOf(i3);
                            objArr[2] = Integer.valueOf(i4);
                            ab.e(str, str2, objArr);
                        } else {
                            CharSequence subSequence = ahb.subSequence(0, i3);
                            CharSequence subSequence2 = ahb.subSequence(i4, ahb.length());
                            String a = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) subSequence);
                            String a2 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) subSequence2);
                            i iVar = (i) Ke;
                            if (!bo.isNullOrNil(a)) {
                                iVar.content = a.endsWith("<br/>") ? a.substring(0, a.length() - 5) : a;
                                i2++;
                                if (!bo.isNullOrNil(a2)) {
                                    Ke = new i();
                                    Ke.type = 1;
                                    if (a2.startsWith("<br/>")) {
                                        a2 = a2.substring(5, a2.length());
                                    }
                                    Ke.content = a2;
                                    Ke.uNV = 0;
                                    Ke.uNT = false;
                                    Ke.uNZ = false;
                                    b(i2, Ke);
                                    z = true;
                                    i5 = i2;
                                    i6 = i2;
                                }
                                z = false;
                                i5 = i2;
                                i6 = i2;
                            } else if (bo.isNullOrNil(a2)) {
                                Kf(i2);
                                if (this.uPa != null) {
                                    this.uPa.JZ(i2);
                                }
                                z = false;
                                i5 = i2;
                                i6 = i2;
                            } else {
                                if (a2.startsWith("<br/>")) {
                                    a2 = a2.substring(5, a2.length());
                                }
                                iVar.content = a2;
                                z = false;
                                i5 = i2;
                                i6 = i2;
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
                                b(cVar);
                                if (b(i6, cVar)) {
                                    i7 = i6 + 1;
                                } else {
                                    i7 = i6;
                                }
                                i6 = i7;
                            }
                        }
                    } else {
                        if (i != 1) {
                            i5 = i2 + 1;
                        } else {
                            i5 = i2;
                        }
                        Iterator it2 = arrayList.iterator();
                        i6 = i5;
                        while (it2.hasNext()) {
                            cVar = (com.tencent.mm.plugin.wenote.model.a.c) it2.next();
                            b(cVar);
                            if (b(i6, cVar)) {
                                i7 = i6 + 1;
                            } else {
                                i7 = i6;
                            }
                            i6 = i7;
                        }
                        z = false;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(26743);
                }
            }
        }
        return -1;
    }

    private void b(com.tencent.mm.plugin.wenote.model.a.c cVar) {
        AppMethodBeat.i(26744);
        if (cVar == null) {
            AppMethodBeat.o(26744);
            return;
        }
        o oVar = (o) cVar;
        if (oVar.getType() > 1) {
            if (bo.isNullOrNil(oVar.uOo)) {
                oVar.uOo = det();
            }
            com.tencent.mm.plugin.wenote.model.d dVar = com.tencent.mm.plugin.wenote.model.c.ddG().uMN;
            if (dVar == null) {
                ab.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", cVar.toString());
            } else if (dVar.uMT == null) {
                ab.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", cVar.toString());
            } else {
                dVar.uMT.put(oVar.uOo, oVar);
            }
        }
        if (bo.isNullOrNil(cVar.mnd)) {
            cVar.mnd = com.tencent.mm.plugin.wenote.model.f.agW(cVar.toString());
        }
        AppMethodBeat.o(26744);
    }

    public final ArrayList<com.tencent.mm.plugin.wenote.model.a.c> dev() {
        AppMethodBeat.i(26745);
        if (this.iPr == null) {
            AppMethodBeat.o(26745);
            return null;
        }
        ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.iPr.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.tencent.mm.plugin.wenote.b.c.c((com.tencent.mm.plugin.wenote.model.a.c) it.next()));
                }
            } finally {
                AppMethodBeat.o(26745);
            }
        }
        return arrayList;
    }

    public final boolean af(ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList) {
        AppMethodBeat.i(26746);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
            if (cVar.getType() != 1) {
                i++;
            } else {
                stringBuilder.append(((i) cVar).content);
            }
        }
        boolean gF = gF(com.tencent.mm.plugin.wenote.b.c.ahl(stringBuilder.toString()), i);
        AppMethodBeat.o(26746);
        return gF;
    }

    public final boolean gF(int i, int i2) {
        boolean z;
        boolean z2;
        if (i < 0) {
            z = false;
        } else {
            z = true;
        }
        if (i2 < 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && this.uPd + i > 16384) {
            return true;
        }
        if (!z2 || this.uPe + i2 <= 30) {
            return false;
        }
        return true;
    }

    public final void dew() {
        AppMethodBeat.i(26747);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26716);
                synchronized (c.this) {
                    try {
                        if (c.this.iPr == null) {
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            Iterator it = c.this.iPr.iterator();
                            int i = 0;
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
                                if (cVar.getType() != 1) {
                                    i++;
                                } else {
                                    stringBuilder.append(((i) cVar).content);
                                }
                            }
                            c.this.uPd = com.tencent.mm.plugin.wenote.b.c.ahl(stringBuilder.toString());
                            c.this.uPe = i;
                            AppMethodBeat.o(26716);
                        }
                    } finally {
                        AppMethodBeat.o(26716);
                    }
                }
            }
        });
        AppMethodBeat.o(26747);
    }

    private void a(com.tencent.mm.plugin.wenote.model.a.c cVar, boolean z) {
        AppMethodBeat.i(26748);
        if (cVar == null) {
            AppMethodBeat.o(26748);
        } else if (cVar.getType() == 1) {
            int ahl = com.tencent.mm.plugin.wenote.b.c.ahl(((i) cVar).content);
            if (z) {
                this.uPd = ahl + this.uPd;
                AppMethodBeat.o(26748);
                return;
            }
            this.uPd -= ahl;
            AppMethodBeat.o(26748);
        } else if (z) {
            this.uPe++;
            AppMethodBeat.o(26748);
        } else {
            this.uPe--;
            AppMethodBeat.o(26748);
        }
    }

    /* JADX WARNING: Missing block: B:46:0x010d, code skipped:
            if (r2 == -1) goto L_0x011f;
     */
    /* JADX WARNING: Missing block: B:48:0x0111, code skipped:
            if (r10.uPa == null) goto L_0x011f;
     */
    /* JADX WARNING: Missing block: B:49:0x0113, code skipped:
            r10.uPa.gD(r2, r10.iPr.size() - r2);
     */
    /* JADX WARNING: Missing block: B:50:0x011f, code skipped:
            dew();
            com.tencent.matrix.trace.core.AppMethodBeat.o(26749);
     */
    /* JADX WARNING: Missing block: B:60:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void gG(int i, int i2) {
        AppMethodBeat.i(26749);
        ab.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.TRUE);
        synchronized (this) {
            try {
                if (this.iPr == null) {
                } else {
                    int i3;
                    if (i <= 0) {
                        i = 0;
                    }
                    if (i2 >= this.iPr.size()) {
                        i2 = this.iPr.size() - 1;
                        i3 = -1;
                    } else {
                        i3 = -1;
                    }
                    while (i2 > i) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2);
                        com.tencent.mm.plugin.wenote.model.a.c cVar2 = (com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i2 - 1);
                        if (cVar != null && cVar.getType() == 1 && cVar2 != null && cVar2.getType() == 1) {
                            i3 = i2 - 1;
                            i iVar = (i) cVar;
                            i iVar2 = (i) cVar2;
                            if (!bo.isNullOrNil(iVar.content)) {
                                Spanned ahb = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ahb(iVar.content);
                                Spanned ahb2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ahb(iVar2.content);
                                iVar2.content += "<br/>" + iVar.content;
                                if (iVar.uNT) {
                                    iVar2.uNT = true;
                                    iVar2.uNZ = false;
                                    if (iVar.uNV == -1 || iVar.uNV >= ahb.length()) {
                                        iVar2.uNV = -1;
                                    } else {
                                        iVar2.uNV = iVar.uNV + (ahb2.length() + 1);
                                    }
                                } else if (iVar2.uNT && iVar2.uNV == -1) {
                                    iVar2.uNV = ahb2.length();
                                }
                            } else if (iVar.uNT) {
                                iVar2.uNT = true;
                                iVar2.uNZ = false;
                                iVar2.uNV = -1;
                            }
                            ab.i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem remove position: %d", Integer.valueOf(i2));
                            Kf(i2);
                            if (this.uPa != null) {
                                this.uPa.JZ(i2);
                            }
                        }
                        i2--;
                        i3 = i3;
                    }
                }
            } finally {
                AppMethodBeat.o(26749);
            }
        }
    }

    public final String ahf(String str) {
        String replace;
        AppMethodBeat.i(26750);
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    int i = 0;
                    String str2 = str;
                    while (i < this.iPr.size()) {
                        if (((com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i)).getType() == 1) {
                            replace = b.ahh(((i) this.iPr.get(i)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
                            if (!bo.isNullOrNil(replace)) {
                                int i2;
                                String[] split = replace.split(IOUtils.LINE_SEPARATOR_UNIX);
                                for (int i3 = 0; i3 < split.length; i3++) {
                                    if (!bo.isNullOrNil(split[i3].trim())) {
                                        replace = split[i3];
                                        i2 = 1;
                                        break;
                                    }
                                }
                                i2 = 0;
                                replace = str2;
                                if (i2 != 0) {
                                    break;
                                }
                                i++;
                                str2 = replace;
                            }
                        }
                        replace = str2;
                        i++;
                        str2 = replace;
                    }
                    replace = str2;
                } else {
                    replace = str;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(26750);
                }
            }
        }
        if (replace.length() > 1000) {
            replace = replace.substring(0, 1000);
        }
        AppMethodBeat.o(26750);
        return replace;
    }

    public final int dex() {
        AppMethodBeat.i(26751);
        synchronized (this) {
            try {
                if (this.iPr == null) {
                } else {
                    int i = 0;
                    while (i < this.iPr.size()) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(i);
                        if (cVar == null || cVar.getType() == -3 || cVar.getType() == -2) {
                            i++;
                        } else {
                            AppMethodBeat.o(26751);
                            return i;
                        }
                    }
                    AppMethodBeat.o(26751);
                    return -1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(26751);
            }
        }
        return -1;
    }

    public final int dey() {
        AppMethodBeat.i(26752);
        synchronized (this) {
            try {
                if (this.iPr == null) {
                } else {
                    int size = this.iPr.size() - 1;
                    while (size >= 0) {
                        com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) this.iPr.get(size);
                        if (cVar == null || cVar.getType() == -3 || cVar.getType() == -2) {
                            size--;
                        } else {
                            AppMethodBeat.o(26752);
                            return size;
                        }
                    }
                    AppMethodBeat.o(26752);
                    return -1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(26752);
            }
        }
        return -1;
    }
}
