package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import android.text.Editable;
import android.text.Spanned;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.wenote.model.C14719f;
import com.tencent.p177mm.plugin.wenote.model.C29980h;
import com.tencent.p177mm.plugin.wenote.model.C40369d;
import com.tencent.p177mm.plugin.wenote.model.C46453c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C14724a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C44005b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1565b.C40377a;
import com.tencent.p177mm.plugin.wenote.model.p585a.C23178g;
import com.tencent.p177mm.plugin.wenote.model.p585a.C24930f;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29978o;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40365i;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40366k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44002d;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44003l;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44794b;
import com.tencent.p177mm.plugin.wenote.p1333b.C23176b;
import com.tencent.p177mm.plugin.wenote.p1333b.C29977c;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.c */
public class C40380c {
    private static volatile C40380c uOZ = null;
    public ArrayList<C44001c> iPr = null;
    public C40377a uPa = null;
    public aar uPb = null;
    public int uPc = 0;
    public int uPd = 0;
    public int uPe = 0;
    public boolean uPf = false;

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.c$3 */
    class C231833 implements Runnable {
        C231833() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26716);
            synchronized (C40380c.this) {
                try {
                    if (C40380c.this.iPr == null) {
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        Iterator it = C40380c.this.iPr.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            C44001c c44001c = (C44001c) it.next();
                            if (c44001c.getType() != 1) {
                                i++;
                            } else {
                                stringBuilder.append(((C40365i) c44001c).content);
                            }
                        }
                        C40380c.this.uPd = C29977c.ahl(stringBuilder.toString());
                        C40380c.this.uPe = i;
                        AppMethodBeat.m2505o(26716);
                    }
                } finally {
                    AppMethodBeat.m2505o(26716);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.c$1 */
    public class C403811 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(26714);
            C4990ab.m7416i("MicroMsg.Note.NoteDataManager", "NoteDataManager onDestroy");
            C40380c.this.den();
            C40380c.this.uPa = null;
            C40380c.this.uPb = null;
            C40380c.this.uPc = 0;
            C40380c.uOZ = null;
            AppMethodBeat.m2505o(26714);
        }
    }

    private C40380c() {
    }

    public static C40380c dem() {
        AppMethodBeat.m2504i(26717);
        if (uOZ == null) {
            synchronized (C40380c.class) {
                try {
                    if (uOZ == null) {
                        uOZ = new C40380c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(26717);
                    }
                }
            }
        }
        C40380c c40380c = uOZ;
        AppMethodBeat.m2505o(26717);
        return c40380c;
    }

    public final int size() {
        AppMethodBeat.m2504i(26718);
        if (this.iPr != null) {
            int size = this.iPr.size();
            AppMethodBeat.m2505o(26718);
            return size;
        }
        AppMethodBeat.m2505o(26718);
        return 0;
    }

    /* renamed from: Ke */
    public final C44001c mo63750Ke(int i) {
        AppMethodBeat.m2504i(26719);
        if (this.iPr == null || i < 0 || i >= this.iPr.size()) {
            AppMethodBeat.m2505o(26719);
            return null;
        }
        C44001c c44001c = (C44001c) this.iPr.get(i);
        AppMethodBeat.m2505o(26719);
        return c44001c;
    }

    /* renamed from: a */
    public final boolean mo63757a(C44001c c44001c) {
        boolean z = true;
        AppMethodBeat.m2504i(26720);
        synchronized (this) {
            if (c44001c != null) {
                try {
                    if (this.iPr != null) {
                        this.iPr.add(c44001c);
                        m69261a(c44001c, true);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(26720);
                    }
                }
            }
            z = false;
        }
        AppMethodBeat.m2505o(26720);
        return z;
    }

    /* renamed from: d */
    public final boolean mo63765d(int i, ArrayList<C44001c> arrayList) {
        AppMethodBeat.m2504i(26721);
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.m2505o(26721);
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
                        C44001c c44001c = (C44001c) arrayList.get(i4);
                        if (c44001c != null) {
                            m69264b(c44001c);
                            this.iPr.add(i3, c44001c);
                            i2++;
                            i3++;
                            m69261a(c44001c, true);
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
                    AppMethodBeat.m2505o(26721);
                }
            }
        }
        if (z && this.uPa != null) {
            this.uPa.mo27051gC(i3 - i2, i2);
        }
        AppMethodBeat.m2505o(26721);
        return z;
    }

    /* renamed from: a */
    public final boolean mo63756a(int i, C44001c c44001c) {
        boolean z = true;
        AppMethodBeat.m2504i(26722);
        synchronized (this) {
            try {
                if (this.iPr == null || i < 0 || i > this.iPr.size()) {
                    z = false;
                } else {
                    this.iPr.add(i, c44001c);
                    m69261a(c44001c, true);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(26722);
                }
            }
        }
        if (z && this.uPa != null) {
            this.uPa.mo27024JY(i);
            if (i > 0) {
                this.uPa.mo27052gD(i - 1, this.iPr.size() - (i - 1));
            } else {
                this.uPa.mo27052gD(i, this.iPr.size() - i);
            }
        }
        AppMethodBeat.m2505o(26722);
        return z;
    }

    /* renamed from: b */
    private boolean m69265b(int i, C44001c c44001c) {
        boolean z = true;
        AppMethodBeat.m2504i(26723);
        if (c44001c == null || this.iPr == null || i < 0 || i > this.iPr.size()) {
            z = false;
        } else {
            this.iPr.add(i, c44001c);
            m69261a(c44001c, true);
        }
        AppMethodBeat.m2505o(26723);
        return z;
    }

    /* renamed from: au */
    public final boolean mo63762au(int i, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(26724);
        synchronized (this) {
            try {
                if (this.iPr != null && i >= 0 && i < this.iPr.size()) {
                    m69261a((C44001c) this.iPr.get(i), false);
                    this.iPr.remove(i);
                    z2 = true;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(26724);
                }
            }
        }
        if (z2 && z && this.uPa != null) {
            this.uPa.mo27025JZ(i);
            if (i > 0) {
                this.uPa.mo27052gD(i - 1, this.iPr.size() - (i - 1));
            } else {
                this.uPa.mo27052gD(i, this.iPr.size() - i);
            }
        }
        AppMethodBeat.m2505o(26724);
        return z2;
    }

    /* renamed from: Kf */
    private boolean m69258Kf(int i) {
        boolean z;
        AppMethodBeat.m2504i(26725);
        if (this.iPr == null || i < 0 || i >= this.iPr.size()) {
            z = false;
        } else {
            m69261a((C44001c) this.iPr.get(i), false);
            this.iPr.remove(i);
            z = true;
        }
        AppMethodBeat.m2505o(26725);
        return z;
    }

    /* renamed from: Kg */
    public final void mo63751Kg(int i) {
        AppMethodBeat.m2504i(26726);
        if (this.uPa != null) {
            this.uPa.mo27023JX(i);
        }
        AppMethodBeat.m2505o(26726);
    }

    /* JADX WARNING: Missing block: B:14:0x0044, code skipped:
            if (r0 == -1) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:16:0x0048, code skipped:
            if (r5.uPa == null) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:17:0x004a, code skipped:
            r5.uPa.mo27023JX(r0);
     */
    /* JADX WARNING: Missing block: B:18:0x004f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(26727);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo63755a(String str, C44001c c44001c) {
        AppMethodBeat.m2504i(26727);
        synchronized (this) {
            try {
                if (this.iPr == null) {
                } else {
                    int i;
                    for (int i2 = 0; i2 < this.iPr.size(); i2++) {
                        if (((C44001c) this.iPr.get(i2)).ddP().equals(str)) {
                            m69261a((C44001c) this.iPr.get(i2), false);
                            this.iPr.set(i2, c44001c);
                            m69261a(c44001c, true);
                            i = i2;
                            break;
                        }
                    }
                    i = -1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(26727);
            }
        }
    }

    public final void ahd(String str) {
        AppMethodBeat.m2504i(26728);
        if (C5046bo.isNullOrNil(str) || this.iPr == null) {
            AppMethodBeat.m2505o(26728);
            return;
        }
        final ArrayList ahg = C23176b.ahg(str);
        if (ahg == null || ahg.size() <= 0) {
            AppMethodBeat.m2505o(26728);
            return;
        }
        synchronized (this) {
            try {
                long j;
                C4990ab.m7417i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, mHasInitDataListFinish :％B", Boolean.valueOf(this.uPf));
                C5004al RS = C9638aw.m17180RS();
                C299852 c299852 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(26715);
                        ArrayList a = C29980h.m47435a(C40380c.this.iPr, ahg, false);
                        C4990ab.m7416i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, start mNotifyListener.setUpNoteData(dataItems, true)");
                        if (C40380c.this.uPa != null) {
                            C40380c.this.uPa.mo27030c(a, true);
                        }
                        AppMethodBeat.m2505o(26715);
                    }
                };
                if (this.uPf) {
                    j = 500;
                } else {
                    j = 1000;
                }
                RS.mo10310m(c299852, j);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.Note.NoteDataManager", "updateDataByHtml exception,%s", e.toString());
            } catch (Throwable th) {
                AppMethodBeat.m2505o(26728);
            }
        }
        AppMethodBeat.m2505o(26728);
    }

    public final void den() {
        AppMethodBeat.m2504i(26729);
        String str = "MicroMsg.Note.NoteDataManager";
        String str2 = "clear mDataList, size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.iPr != null ? this.iPr.size() : 0);
        C4990ab.m7417i(str, str2, objArr);
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    this.iPr.clear();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(26729);
            }
        }
        this.uPe = 0;
        this.uPd = 0;
    }

    /* JADX WARNING: Missing block: B:18:0x0033, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(26730);
     */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: av */
    public final void mo63763av(int i, boolean z) {
        AppMethodBeat.m2504i(26730);
        synchronized (this) {
            try {
                if (this.iPr == null) {
                } else {
                    C44001c c44001c;
                    if (i >= 0) {
                        if (i < this.iPr.size()) {
                            c44001c = (C44001c) this.iPr.get(i);
                            if (!(c44001c == null || c44001c.uOa == z)) {
                                c44001c.uOa = z;
                                if (this.uPa != null) {
                                    this.uPa.mo27023JX(i);
                                }
                            }
                        }
                    }
                    if (i == -1) {
                        for (int i2 = 0; i2 < this.iPr.size(); i2++) {
                            c44001c = (C44001c) this.iPr.get(i2);
                            if (!(c44001c == null || c44001c.uOa == z)) {
                                c44001c.uOa = z;
                                if (this.uPa != null) {
                                    this.uPa.mo27023JX(i2);
                                }
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(26730);
            }
        }
    }

    public final int deo() {
        int i;
        AppMethodBeat.m2504i(26731);
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    for (int i2 = 0; i2 < this.iPr.size(); i2++) {
                        if (((C44001c) this.iPr.get(i2)).uNT) {
                            i = i2;
                            break;
                        }
                    }
                }
                i = -1;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(26731);
            }
        }
        return i;
    }

    public final void dep() {
        AppMethodBeat.m2504i(26732);
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    Iterator it = this.iPr.iterator();
                    while (it.hasNext()) {
                        C44001c c44001c = (C44001c) it.next();
                        c44001c.uNT = false;
                        c44001c.uNZ = false;
                    }
                }
            } finally {
                AppMethodBeat.m2505o(26732);
            }
        }
    }

    private void deq() {
        AppMethodBeat.m2504i(26733);
        if (this.iPr != null) {
            Iterator it = this.iPr.iterator();
            while (it.hasNext()) {
                C44001c c44001c = (C44001c) it.next();
                c44001c.uNT = false;
                c44001c.uNZ = false;
            }
        }
        AppMethodBeat.m2505o(26733);
    }

    /* renamed from: aw */
    public final void mo63764aw(int i, boolean z) {
        AppMethodBeat.m2504i(26734);
        synchronized (this) {
            try {
                if (this.iPr == null || i < 0 || i >= this.iPr.size()) {
                } else {
                    for (int i2 = 0; i2 < this.iPr.size(); i2++) {
                        if (i2 == i) {
                            ((C44001c) this.iPr.get(i2)).uNT = true;
                            ((C44001c) this.iPr.get(i2)).uNZ = z;
                        } else {
                            ((C44001c) this.iPr.get(i2)).uNT = false;
                            ((C44001c) this.iPr.get(i2)).uNZ = false;
                        }
                    }
                    AppMethodBeat.m2505o(26734);
                }
            } finally {
                AppMethodBeat.m2505o(26734);
            }
        }
    }

    public final int der() {
        int i;
        AppMethodBeat.m2504i(26735);
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    int i2 = 0;
                    while (i2 < this.iPr.size()) {
                        if (((C44001c) this.iPr.get(i2)).getType() == 4 && ((C44003l) this.iPr.get(i2)).uOh.booleanValue()) {
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
                AppMethodBeat.m2505o(26735);
            }
        }
        return i;
    }

    public final String des() {
        String stringBuilder;
        AppMethodBeat.m2504i(26736);
        synchronized (this) {
            try {
                if (this.uPc == 0 && this.iPr != null) {
                    Iterator it = this.iPr.iterator();
                    while (it.hasNext()) {
                        C29978o c29978o = (C29978o) ((C44001c) it.next());
                        if (c29978o.uOo.startsWith("WeNote_")) {
                            int i = C5046bo.getInt(c29978o.uOo.substring(7), -1);
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
                AppMethodBeat.m2505o(26736);
            }
        }
        return stringBuilder;
    }

    private String det() {
        AppMethodBeat.m2504i(26737);
        if (this.uPc == 0 && this.iPr != null) {
            Iterator it = this.iPr.iterator();
            while (it.hasNext()) {
                C29978o c29978o = (C29978o) ((C44001c) it.next());
                if (c29978o.uOo.startsWith("WeNote_")) {
                    int i = C5046bo.getInt(c29978o.uOo.substring(7), -1);
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
        AppMethodBeat.m2505o(26737);
        return stringBuilder2;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String deu() {
        String str;
        AppMethodBeat.m2504i(26738);
        String str2 = "";
        synchronized (this) {
            try {
                if (this.iPr == null || this.iPr.size() <= 0) {
                    str = "";
                } else {
                    int i = 0;
                    while (i < this.iPr.size()) {
                        C44001c c44001c = (C44001c) this.iPr.get(i);
                        switch (c44001c.getType()) {
                            case -1:
                                str = str2 + "<hr/>";
                                break;
                            case 1:
                                C40365i c40365i = (C40365i) c44001c;
                                if (!C5046bo.isNullOrNil(c40365i.content)) {
                                    str2 = str2 + c40365i.content;
                                    if (i + 1 < this.iPr.size() && ((C44001c) this.iPr.get(i + 1)).getType() == 1 && !C5046bo.isNullOrNil(((C40365i) this.iPr.get(i + 1)).content)) {
                                        str = str2 + "<br/>";
                                        break;
                                    }
                                }
                                str = str2 + "<br/>";
                                break;
                            case 2:
                                str = str2 + C40380c.m69268dO(((C24930f) c44001c).uOo, 2);
                                break;
                            case 3:
                                str = str2 + C40380c.m69268dO(((C23178g) c44001c).uOo, 3);
                                break;
                            case 4:
                                C44003l c44003l = (C44003l) c44001c;
                                str = str2 + C40380c.m69268dO(c44003l.uOo, c44003l.getType());
                                break;
                            case 5:
                                str = str2 + C40380c.m69268dO(((C44002d) c44001c).uOo, 5);
                                break;
                            case 6:
                                str = str2 + C40380c.m69268dO(((C40366k) c44001c).uOo, 6);
                                break;
                            case 20:
                                str = str2 + C40380c.m69268dO(((C44794b) c44001c).uOo, 20);
                                break;
                            default:
                                str = str2;
                                break;
                        }
                        i++;
                        str2 = str;
                    }
                    str = str2.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "<br/>");
                    AppMethodBeat.m2505o(26738);
                }
            } finally {
                while (true) {
                    AppMethodBeat.m2505o(26738);
                }
            }
        }
        return str;
    }

    /* renamed from: dO */
    private static String m69268dO(String str, int i) {
        AppMethodBeat.m2504i(26739);
        String format = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[]{Integer.valueOf(i), str, str});
        AppMethodBeat.m2505o(26739);
        return format;
    }

    public final abf ahe(String str) {
        abf abf = null;
        AppMethodBeat.m2504i(26740);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
            AppMethodBeat.m2505o(26740);
            return null;
        }
        String o;
        int i;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            int i2 = 0;
            while (i2 < this.iPr.size()) {
                try {
                    C44001c c44001c = (C44001c) this.iPr.get(i2);
                    if (C5046bo.isNullOrNil(c44001c.mnd)) {
                        c44001c.mnd = C14719f.agW(c44001c.toString());
                    }
                    C40365i c40365i;
                    C40365i c40365i2;
                    if (c44001c.getType() == -1) {
                        if (arrayList.size() <= 0 || ((C29978o) arrayList.get(arrayList.size() - 1)).type != 1) {
                            c40365i = new C40365i();
                            c40365i.content = IOUtils.LINE_SEPARATOR_UNIX;
                            c40365i.mnd = c44001c.mnd;
                            c40365i.uOo = "-1";
                            c40365i.type = 1;
                            c40365i.uOn = null;
                            arrayList.add(c40365i);
                        } else {
                            c40365i2 = (C40365i) arrayList.get(arrayList.size() - 1);
                            c40365i2.content += IOUtils.LINE_SEPARATOR_UNIX;
                        }
                    } else if (c44001c.getType() >= -1) {
                        if ((c44001c.getType() == 6 || c44001c.getType() == 4) && C5046bo.isNullOrNil(((C29978o) c44001c).cHg)) {
                            aar aar = new aar();
                            aar.akU(c44001c.mnd);
                            aar.akR(c44001c.ddQ());
                            o = C14719f.m22910o(aar);
                            if (C5730e.m8628ct(o)) {
                                C4990ab.m7413e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", Integer.valueOf(c44001c.getType()));
                                ((C29978o) c44001c).cHg = o;
                            }
                        }
                        if (c44001c.getType() != 1) {
                            arrayList.add((C29978o) c44001c);
                        } else {
                            c40365i2 = (C40365i) c44001c;
                            if (!C5046bo.isNullOrNil(c40365i2.content)) {
                                if (arrayList.size() <= 0 || ((C29978o) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                    c40365i = new C40365i();
                                    c40365i.content = c40365i2.content;
                                    c40365i.mnd = c40365i2.mnd;
                                    c40365i.uOo = c40365i2.uOo;
                                    c40365i.type = c40365i2.type;
                                    c40365i.uOn = null;
                                    arrayList.add(c40365i);
                                } else {
                                    c40365i = (C40365i) arrayList.get(arrayList.size() - 1);
                                    c40365i.content += c40365i2.content;
                                }
                                if (i2 + 1 < this.iPr.size() && ((C44001c) this.iPr.get(i2 + 1)).getType() == 1 && !C5046bo.isNullOrNil(((C40365i) this.iPr.get(i2 + 1)).content)) {
                                    c40365i2 = (C40365i) arrayList.get(arrayList.size() - 1);
                                    c40365i2.content += "<br/>";
                                }
                            } else if (arrayList.size() <= 0 || ((C29978o) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                c40365i = new C40365i();
                                c40365i.content = "<br/>";
                                c40365i.mnd = c40365i2.mnd;
                                c40365i.uOo = c40365i2.uOo;
                                c40365i.type = c40365i2.type;
                                c40365i.uOn = null;
                                arrayList.add(c40365i);
                            } else {
                                c40365i2 = (C40365i) arrayList.get(arrayList.size() - 1);
                                c40365i2.content += "<br/>";
                            }
                        }
                    }
                    i2++;
                } finally {
                    AppMethodBeat.m2505o(26740);
                }
            }
        }
        String replaceAll = Pattern.compile("</wx-", 2).matcher(Pattern.compile("<wx-", 2).matcher(str).replaceAll("<")).replaceAll("</");
        byte[] bytes;
        try {
            bytes = replaceAll.getBytes("UTF-8");
            i = 0;
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.Note.NoteDataManager", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
            boolean i3 = true;
            bytes = null;
        }
        this.uPb.mo27394LE(8);
        this.uPb.ale("WeNoteHtmlFile");
        this.uPb.mo27435oY(true);
        this.uPb.akR(".htm");
        this.uPb.akU(C14719f.agW(this.uPb.toString()));
        o = C14719f.m22910o(this.uPb);
        C4990ab.m7417i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", o);
        C5728b c5728b = new C5728b(o);
        if (c5728b.exists()) {
            c5728b.delete();
        }
        if (!c5728b.exists()) {
            try {
                c5728b.createNewFile();
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.Note.NoteDataManager", e2, "", new Object[0]);
                AppMethodBeat.m2505o(26740);
                return null;
            }
        }
        if (i3 == 0 && C5730e.m8624b(o, bytes, bytes.length) == 0) {
            this.uPb.akV(o);
            C4990ab.m7416i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
            abf = C40369d.m69211a(replaceAll, arrayList, this.uPb);
            return abf;
        }
        C4990ab.m7416i("MicroMsg.Note.NoteDataManager", "writefile error,return");
        Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.bra), 1).show();
        AppMethodBeat.m2505o(26740);
        return null;
    }

    /* renamed from: a */
    public final int mo63752a(C44001c c44001c, WXRTEditText wXRTEditText, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(26741);
        if (c44001c == null) {
            AppMethodBeat.m2505o(26741);
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c44001c);
        int a = mo63754a(arrayList, wXRTEditText, true, z, z2, z3);
        AppMethodBeat.m2505o(26741);
        return a;
    }

    /* JADX WARNING: Missing block: B:68:0x0100, code skipped:
            if ((r2 - 1) < 0) goto L_0x0281;
     */
    /* JADX WARNING: Missing block: B:70:0x010c, code skipped:
            if ((r2 - 1) >= com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.dem().size()) goto L_0x0281;
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
            if (r1 >= com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.dem().size()) goto L_0x028d;
     */
    /* JADX WARNING: Missing block: B:75:0x0123, code skipped:
            r6 = com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.dem().mo63750Ke(r1);
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
            r10.uPa.mo27051gC(r3, r2);
     */
    /* JADX WARNING: Missing block: B:86:0x0145, code skipped:
            if (r3 <= 0) goto L_0x02a4;
     */
    /* JADX WARNING: Missing block: B:87:0x0147, code skipped:
            r10.uPa.mo27052gD(r3 - 1, com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.dem().size() - (r3 - 1));
     */
    /* JADX WARNING: Missing block: B:88:0x015a, code skipped:
            if (r15 == false) goto L_0x0161;
     */
    /* JADX WARNING: Missing block: B:89:0x015c, code skipped:
            r10.uPa.ddV();
     */
    /* JADX WARNING: Missing block: B:90:0x0161, code skipped:
            r10.uPa.mo27026Ka(r1);
     */
    /* JADX WARNING: Missing block: B:91:0x0166, code skipped:
            dew();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(26742);
     */
    /* JADX WARNING: Missing block: B:145:0x0281, code skipped:
            r1 = com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.dem().size() - 1;
     */
    /* JADX WARNING: Missing block: B:146:0x028d, code skipped:
            r6 = new com.tencent.p177mm.plugin.wenote.model.p585a.C40365i();
            r6.type = 1;
            r6.content = "";
            r6.uNV = 0;
            r6.uNT = true;
            r6.uNZ = false;
            m69265b(r1, r6);
     */
    /* JADX WARNING: Missing block: B:147:0x02a4, code skipped:
            if (r3 != 0) goto L_0x015a;
     */
    /* JADX WARNING: Missing block: B:148:0x02a6, code skipped:
            r10.uPa.mo27052gD(r3, com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.dem().size() - r3);
     */
    /* JADX WARNING: Missing block: B:166:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo63754a(ArrayList<C44001c> arrayList, WXRTEditText wXRTEditText, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.m2504i(26742);
        if (arrayList == null || arrayList.size() <= 0 || this.iPr == null) {
            C4990ab.m7412e("MicroMsg.Note.NoteDataManager", "insertItemList,error,return");
            AppMethodBeat.m2505o(26742);
            return -1;
        } else if (C46453c.ddG().uMN == null) {
            C4990ab.m7412e("MicroMsg.Note.NoteDataManager", "insertItemList, but get wnnote base is null, return");
            AppMethodBeat.m2505o(26742);
            return -1;
        } else if (z2 && mo63758af(arrayList) && this.uPa != null) {
            this.uPa.ddW();
            AppMethodBeat.m2505o(26742);
            return -1;
        } else {
            C44001c c44001c;
            int type;
            C40365i c40365i;
            if (z) {
                c44001c = (C44001c) arrayList.get(arrayList.size() - 1);
                c44001c.uNV = -1;
                c44001c.uNT = true;
                c44001c.uNZ = false;
                if (wXRTEditText != null && wXRTEditText.uQc) {
                    if (wXRTEditText.getEditTextType() == 2) {
                        c44001c.uOc = 2;
                    } else if (wXRTEditText.getEditTextType() == 1) {
                        c44001c.uOc = 1;
                    }
                    wXRTEditText.uQc = false;
                    c44001c.uOd = wXRTEditText.uOd;
                    wXRTEditText.uOd = 0;
                }
            }
            if (wXRTEditText != null && wXRTEditText.getRecyclerItemPosition() == 0 && wXRTEditText.getEditTextType() != 2 && wXRTEditText.getSelectionStart() == 0 && arrayList != null && arrayList.size() > 0) {
                type = ((C44001c) arrayList.get(0)).getType();
                if (type == 2 || type == 6 || type == 5 || type == 3 || type == 4) {
                    c40365i = new C40365i();
                    c40365i.content = "";
                    c40365i.uNT = false;
                    c40365i.uNZ = false;
                    arrayList.add(0, c40365i);
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
                            c44001c = (C44001c) it.next();
                            m69264b(c44001c);
                            if (c44001c == null || this.iPr == null) {
                                z6 = false;
                            } else {
                                this.iPr.add(c44001c);
                                m69261a(c44001c, true);
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
                        AppMethodBeat.m2505o(26742);
                    }
                } else {
                    int recyclerItemPosition = wXRTEditText.getRecyclerItemPosition();
                    C44001c Ke = mo63750Ke(recyclerItemPosition);
                    if (Ke == null) {
                        AppMethodBeat.m2505o(26742);
                        return -1;
                    }
                    deq();
                    if (wXRTEditText.getEditTextType() == 0 && Ke.getType() == 1) {
                        C23184e selection = wXRTEditText.getSelection();
                        Editable text = wXRTEditText.getText();
                        CharSequence subSequence = text.subSequence(0, selection.aqm);
                        CharSequence subSequence2 = text.subSequence(selection.f4406Ls, text.length());
                        String a = C44005b.m78993a((Spanned) subSequence);
                        String a2 = C44005b.m78993a((Spanned) subSequence2);
                        c40365i = (C40365i) Ke;
                        if (!C5046bo.isNullOrNil(a)) {
                            c40365i.content = a.endsWith("<br/>") ? a.substring(0, a.length() - 5) : a;
                            recyclerItemPosition++;
                            if (!C5046bo.isNullOrNil(a2)) {
                                c44001c = new C40365i();
                                c44001c.type = 1;
                                if (a2.startsWith("<br/>")) {
                                    a2 = a2.substring(5, a2.length());
                                }
                                c44001c.content = a2;
                                c44001c.uNV = 0;
                                c44001c.uNT = false;
                                c44001c.uNZ = false;
                                m69265b(recyclerItemPosition, c44001c);
                                size = recyclerItemPosition;
                                z5 = true;
                                i = recyclerItemPosition;
                            }
                            size = recyclerItemPosition;
                            z5 = false;
                            i = recyclerItemPosition;
                        } else if (C5046bo.isNullOrNil(a2)) {
                            m69258Kf(recyclerItemPosition);
                            if (this.uPa != null) {
                                this.uPa.mo27025JZ(recyclerItemPosition);
                            }
                            size = recyclerItemPosition;
                            z5 = false;
                            i = recyclerItemPosition;
                        } else {
                            if (a2.startsWith("<br/>")) {
                                a2 = a2.substring(5, a2.length());
                            }
                            c40365i.content = a2;
                            size = recyclerItemPosition;
                            z5 = false;
                            i = recyclerItemPosition;
                        }
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            c44001c = (C44001c) it2.next();
                            m69264b(c44001c);
                            if (m69265b(i, c44001c)) {
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
                            c44001c = (C44001c) it.next();
                            m69264b(c44001c);
                            if (m69265b(i, c44001c)) {
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
            if ((r2 - 1) >= com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.dem().size()) goto L_0x01f2;
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
            r9.uPa.mo27051gC(r5, r2);
     */
    /* JADX WARNING: Missing block: B:92:0x01cb, code skipped:
            if (r5 <= 0) goto L_0x01fd;
     */
    /* JADX WARNING: Missing block: B:93:0x01cd, code skipped:
            r9.uPa.mo27052gD(r5 - 1, com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.dem().size() - (r5 - 1));
     */
    /* JADX WARNING: Missing block: B:94:0x01df, code skipped:
            r9.uPa.mo27026Ka(r1);
     */
    /* JADX WARNING: Missing block: B:95:0x01e4, code skipped:
            dew();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(26743);
     */
    /* JADX WARNING: Missing block: B:100:0x01f2, code skipped:
            r1 = com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.dem().size() - 1;
     */
    /* JADX WARNING: Missing block: B:101:0x01fd, code skipped:
            if (r5 != 0) goto L_0x01df;
     */
    /* JADX WARNING: Missing block: B:102:0x01ff, code skipped:
            r9.uPa.mo27052gD(r5, com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c.dem().size() - r5);
     */
    /* JADX WARNING: Missing block: B:120:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo63753a(ArrayList<C44001c> arrayList, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(26743);
        if (arrayList == null || arrayList.size() <= 0 || this.iPr == null || i2 < 0 || i3 < 0 || i4 < 0 || i4 < i3) {
            C4990ab.m7412e("MicroMsg.Note.NoteDataManager", "pasteItemList,error,return");
            AppMethodBeat.m2505o(26743);
            return -1;
        } else if (C46453c.ddG().uMN == null) {
            C4990ab.m7412e("MicroMsg.Note.NoteDataManager", "pasteItemList, but get wnnote base is null, return");
            AppMethodBeat.m2505o(26743);
            return -1;
        } else {
            C44001c c44001c = (C44001c) arrayList.get(arrayList.size() - 1);
            if (c44001c == null) {
                C4990ab.m7412e("MicroMsg.Note.NoteDataManager", "pasteItemList, lastInsertItem is null");
                AppMethodBeat.m2505o(26743);
                return -1;
            }
            c44001c.uNV = -1;
            c44001c.uNT = true;
            c44001c.uNZ = false;
            C44001c Ke = mo63750Ke(i2);
            if (Ke == null) {
                C4990ab.m7412e("MicroMsg.Note.NoteDataManager", "pasteItemList, item is null");
                AppMethodBeat.m2505o(26743);
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
                        Spanned ahb = C14724a.ahb(((C40365i) Ke).content);
                        if (ahb == null || i3 > ahb.length() || i4 > ahb.length()) {
                            String str = "MicroMsg.Note.NoteDataManager";
                            String str2 = "pasteItemList error, oriText:%d  startOff:%d  endOff:%d";
                            Object[] objArr = new Object[3];
                            objArr[0] = Integer.valueOf(ahb == null ? -1 : ahb.length());
                            objArr[1] = Integer.valueOf(i3);
                            objArr[2] = Integer.valueOf(i4);
                            C4990ab.m7413e(str, str2, objArr);
                        } else {
                            CharSequence subSequence = ahb.subSequence(0, i3);
                            CharSequence subSequence2 = ahb.subSequence(i4, ahb.length());
                            String a = C44005b.m78993a((Spanned) subSequence);
                            String a2 = C44005b.m78993a((Spanned) subSequence2);
                            C40365i c40365i = (C40365i) Ke;
                            if (!C5046bo.isNullOrNil(a)) {
                                c40365i.content = a.endsWith("<br/>") ? a.substring(0, a.length() - 5) : a;
                                i2++;
                                if (!C5046bo.isNullOrNil(a2)) {
                                    Ke = new C40365i();
                                    Ke.type = 1;
                                    if (a2.startsWith("<br/>")) {
                                        a2 = a2.substring(5, a2.length());
                                    }
                                    Ke.content = a2;
                                    Ke.uNV = 0;
                                    Ke.uNT = false;
                                    Ke.uNZ = false;
                                    m69265b(i2, Ke);
                                    z = true;
                                    i5 = i2;
                                    i6 = i2;
                                }
                                z = false;
                                i5 = i2;
                                i6 = i2;
                            } else if (C5046bo.isNullOrNil(a2)) {
                                m69258Kf(i2);
                                if (this.uPa != null) {
                                    this.uPa.mo27025JZ(i2);
                                }
                                z = false;
                                i5 = i2;
                                i6 = i2;
                            } else {
                                if (a2.startsWith("<br/>")) {
                                    a2 = a2.substring(5, a2.length());
                                }
                                c40365i.content = a2;
                                z = false;
                                i5 = i2;
                                i6 = i2;
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                c44001c = (C44001c) it.next();
                                m69264b(c44001c);
                                if (m69265b(i6, c44001c)) {
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
                            c44001c = (C44001c) it2.next();
                            m69264b(c44001c);
                            if (m69265b(i6, c44001c)) {
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
                    AppMethodBeat.m2505o(26743);
                }
            }
        }
        return -1;
    }

    /* renamed from: b */
    private void m69264b(C44001c c44001c) {
        AppMethodBeat.m2504i(26744);
        if (c44001c == null) {
            AppMethodBeat.m2505o(26744);
            return;
        }
        C29978o c29978o = (C29978o) c44001c;
        if (c29978o.getType() > 1) {
            if (C5046bo.isNullOrNil(c29978o.uOo)) {
                c29978o.uOo = det();
            }
            C40369d c40369d = C46453c.ddG().uMN;
            if (c40369d == null) {
                C4990ab.m7413e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", c44001c.toString());
            } else if (c40369d.uMT == null) {
                C4990ab.m7413e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", c44001c.toString());
            } else {
                c40369d.uMT.put(c29978o.uOo, c29978o);
            }
        }
        if (C5046bo.isNullOrNil(c44001c.mnd)) {
            c44001c.mnd = C14719f.agW(c44001c.toString());
        }
        AppMethodBeat.m2505o(26744);
    }

    public final ArrayList<C44001c> dev() {
        AppMethodBeat.m2504i(26745);
        if (this.iPr == null) {
            AppMethodBeat.m2505o(26745);
            return null;
        }
        ArrayList<C44001c> arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.iPr.iterator();
                while (it.hasNext()) {
                    arrayList.add(C29977c.m47428c((C44001c) it.next()));
                }
            } finally {
                AppMethodBeat.m2505o(26745);
            }
        }
        return arrayList;
    }

    /* renamed from: af */
    public final boolean mo63758af(ArrayList<C44001c> arrayList) {
        AppMethodBeat.m2504i(26746);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C44001c c44001c = (C44001c) it.next();
            if (c44001c.getType() != 1) {
                i++;
            } else {
                stringBuilder.append(((C40365i) c44001c).content);
            }
        }
        boolean gF = mo63776gF(C29977c.ahl(stringBuilder.toString()), i);
        AppMethodBeat.m2505o(26746);
        return gF;
    }

    /* renamed from: gF */
    public final boolean mo63776gF(int i, int i2) {
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
        AppMethodBeat.m2504i(26747);
        C9638aw.m17180RS().mo10302aa(new C231833());
        AppMethodBeat.m2505o(26747);
    }

    /* renamed from: a */
    private void m69261a(C44001c c44001c, boolean z) {
        AppMethodBeat.m2504i(26748);
        if (c44001c == null) {
            AppMethodBeat.m2505o(26748);
        } else if (c44001c.getType() == 1) {
            int ahl = C29977c.ahl(((C40365i) c44001c).content);
            if (z) {
                this.uPd = ahl + this.uPd;
                AppMethodBeat.m2505o(26748);
                return;
            }
            this.uPd -= ahl;
            AppMethodBeat.m2505o(26748);
        } else if (z) {
            this.uPe++;
            AppMethodBeat.m2505o(26748);
        } else {
            this.uPe--;
            AppMethodBeat.m2505o(26748);
        }
    }

    /* JADX WARNING: Missing block: B:46:0x010d, code skipped:
            if (r2 == -1) goto L_0x011f;
     */
    /* JADX WARNING: Missing block: B:48:0x0111, code skipped:
            if (r10.uPa == null) goto L_0x011f;
     */
    /* JADX WARNING: Missing block: B:49:0x0113, code skipped:
            r10.uPa.mo27052gD(r2, r10.iPr.size() - r2);
     */
    /* JADX WARNING: Missing block: B:50:0x011f, code skipped:
            dew();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(26749);
     */
    /* JADX WARNING: Missing block: B:60:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: gG */
    public final void mo63777gG(int i, int i2) {
        AppMethodBeat.m2504i(26749);
        C4990ab.m7417i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.TRUE);
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
                        C44001c c44001c = (C44001c) this.iPr.get(i2);
                        C44001c c44001c2 = (C44001c) this.iPr.get(i2 - 1);
                        if (c44001c != null && c44001c.getType() == 1 && c44001c2 != null && c44001c2.getType() == 1) {
                            i3 = i2 - 1;
                            C40365i c40365i = (C40365i) c44001c;
                            C40365i c40365i2 = (C40365i) c44001c2;
                            if (!C5046bo.isNullOrNil(c40365i.content)) {
                                Spanned ahb = C14724a.ahb(c40365i.content);
                                Spanned ahb2 = C14724a.ahb(c40365i2.content);
                                c40365i2.content += "<br/>" + c40365i.content;
                                if (c40365i.uNT) {
                                    c40365i2.uNT = true;
                                    c40365i2.uNZ = false;
                                    if (c40365i.uNV == -1 || c40365i.uNV >= ahb.length()) {
                                        c40365i2.uNV = -1;
                                    } else {
                                        c40365i2.uNV = c40365i.uNV + (ahb2.length() + 1);
                                    }
                                } else if (c40365i2.uNT && c40365i2.uNV == -1) {
                                    c40365i2.uNV = ahb2.length();
                                }
                            } else if (c40365i.uNT) {
                                c40365i2.uNT = true;
                                c40365i2.uNZ = false;
                                c40365i2.uNV = -1;
                            }
                            C4990ab.m7417i("MicroMsg.Note.NoteDataManager", "checkMergeTextDataItem remove position: %d", Integer.valueOf(i2));
                            m69258Kf(i2);
                            if (this.uPa != null) {
                                this.uPa.mo27025JZ(i2);
                            }
                        }
                        i2--;
                        i3 = i3;
                    }
                }
            } finally {
                AppMethodBeat.m2505o(26749);
            }
        }
    }

    public final String ahf(String str) {
        String replace;
        AppMethodBeat.m2504i(26750);
        synchronized (this) {
            try {
                if (this.iPr != null) {
                    int i = 0;
                    String str2 = str;
                    while (i < this.iPr.size()) {
                        if (((C44001c) this.iPr.get(i)).getType() == 1) {
                            replace = C23176b.ahh(((C40365i) this.iPr.get(i)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
                            if (!C5046bo.isNullOrNil(replace)) {
                                int i2;
                                String[] split = replace.split(IOUtils.LINE_SEPARATOR_UNIX);
                                for (int i3 = 0; i3 < split.length; i3++) {
                                    if (!C5046bo.isNullOrNil(split[i3].trim())) {
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
                    AppMethodBeat.m2505o(26750);
                }
            }
        }
        if (replace.length() > 1000) {
            replace = replace.substring(0, 1000);
        }
        AppMethodBeat.m2505o(26750);
        return replace;
    }

    public final int dex() {
        AppMethodBeat.m2504i(26751);
        synchronized (this) {
            try {
                if (this.iPr == null) {
                } else {
                    int i = 0;
                    while (i < this.iPr.size()) {
                        C44001c c44001c = (C44001c) this.iPr.get(i);
                        if (c44001c == null || c44001c.getType() == -3 || c44001c.getType() == -2) {
                            i++;
                        } else {
                            AppMethodBeat.m2505o(26751);
                            return i;
                        }
                    }
                    AppMethodBeat.m2505o(26751);
                    return -1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(26751);
            }
        }
        return -1;
    }

    public final int dey() {
        AppMethodBeat.m2504i(26752);
        synchronized (this) {
            try {
                if (this.iPr == null) {
                } else {
                    int size = this.iPr.size() - 1;
                    while (size >= 0) {
                        C44001c c44001c = (C44001c) this.iPr.get(size);
                        if (c44001c == null || c44001c.getType() == -3 || c44001c.getType() == -2) {
                            size--;
                        } else {
                            AppMethodBeat.m2505o(26752);
                            return size;
                        }
                    }
                    AppMethodBeat.m2505o(26752);
                    return -1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(26752);
            }
        }
        return -1;
    }
}
