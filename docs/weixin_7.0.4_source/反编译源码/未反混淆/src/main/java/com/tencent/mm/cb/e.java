package com.tencent.mm.cb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.vfs.b;
import java.util.ArrayList;

public class e {
    private static e xFX = null;
    private String country;
    private String[] xFY;
    private String[] xFZ;
    private String[] xGa;
    private ArrayList<r> xGb = new ArrayList();
    private SparseArray<r> xGc = new SparseArray();

    public e(Context context) {
        AppMethodBeat.i(62666);
        this.xFY = context.getResources().getStringArray(R.array.a2);
        this.xFZ = context.getResources().getStringArray(R.array.a3);
        this.xGa = context.getResources().getStringArray(R.array.a4);
        this.xGb.clear();
        this.xGc.clear();
        dqJ();
        this.country = aa.dor();
        AppMethodBeat.o(62666);
    }

    private void dqJ() {
        int i = 0;
        AppMethodBeat.i(62667);
        if (!(this.xFY == null || this.xGa == null)) {
            int length = this.xFY.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                r rVar = new r(i3, this.xFY[i2]);
                this.xGb.add(rVar);
                this.xGc.put(i3, rVar);
                i2++;
                i3++;
            }
            i2 = this.xGa.length;
            while (i < i2) {
                r rVar2 = new r(i3, this.xGa[i]);
                this.xGb.add(rVar2);
                this.xGc.put(i3, rVar2);
                i++;
                i3++;
            }
        }
        AppMethodBeat.o(62667);
    }

    public int aRs() {
        ArrayList b;
        int i;
        AppMethodBeat.i(62668);
        ab.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo " + bo.dpG());
        this.xGb.clear();
        ArrayList bjP = ((PluginEmoji) g.M(PluginEmoji.class)).getEmojiMgr().bjP();
        if (bjP == null || bjP.isEmpty()) {
            b = a.b(new b("assets:///panel/".concat(String.valueOf(((d) g.M(d.class)).getEmojiMgr().bjS()))));
        } else {
            b = bjP;
        }
        if (b == null || b.isEmpty()) {
            dqJ();
            ab.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
            i = -1;
        } else {
            ArrayList dqP = f.dqL().dqP();
            int size = b.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                r rVar = (r) b.get(i2);
                String str = rVar.field_key;
                if (!str.startsWith("[") || dqP.contains(str)) {
                    this.xGb.add(rVar);
                    this.xGc.put(i3, rVar);
                    i = i3 + 1;
                } else {
                    ab.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", str);
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            i = 0;
        }
        AppMethodBeat.o(62668);
        return i;
    }

    public int aRt() {
        AppMethodBeat.i(62669);
        if (this.xGb == null) {
            AppMethodBeat.o(62669);
            return 0;
        }
        int size = this.xGb.size();
        AppMethodBeat.o(62669);
        return size;
    }

    public static e dqK() {
        AppMethodBeat.i(62670);
        if (xFX == null) {
            synchronized (e.class) {
                try {
                    xFX = new e(ah.getContext());
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(62670);
                    }
                }
            }
        }
        e eVar = xFX;
        AppMethodBeat.o(62670);
        return eVar;
    }

    public Drawable qJ(int i) {
        AppMethodBeat.i(62671);
        if (this.xGc == null) {
            ab.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
            AppMethodBeat.o(62671);
            return null;
        }
        r rVar = (r) this.xGc.get(i);
        if (rVar == null) {
            ab.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
            AppMethodBeat.o(62671);
            return null;
        }
        Drawable qJ;
        SmileyInfo anY = f.dqL().anY(rVar.field_key);
        int i2;
        if (anY != null) {
            f.dqL();
            i2 = anY.field_position;
            if (i2 >= 0) {
                qJ = b.dqD().qJ(i2);
            } else {
                qJ = f.anX(anY.field_fileName);
            }
        } else {
            c cVar;
            b dqD = b.dqD();
            String str = rVar.field_key;
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
                cVar = null;
            } else {
                i2 = str.codePointAt(0);
                if (dqD.Mi(i2) != null) {
                    cVar = dqD.Mi(i2);
                } else {
                    cVar = dqD.gY(i2, 0);
                }
            }
            qJ = b.dqD().a(cVar, true);
        }
        AppMethodBeat.o(62671);
        return qJ;
    }

    public String getText(int i) {
        AppMethodBeat.i(62672);
        String str;
        if (i < 0 || i >= this.xGb.size()) {
            ab.w("MicroMsg.MergerSmileyManager", "get text, error index");
            str = "";
            AppMethodBeat.o(62672);
            return str;
        }
        r rVar = (r) this.xGb.get(i);
        if (rVar != null) {
            SmileyInfo anY = f.dqL().anY(rVar.field_key);
            if (anY == null) {
                str = rVar.field_key;
                AppMethodBeat.o(62672);
                return str;
            } else if (this.country.equals("zh_CN") && !bo.isNullOrNil(anY.field_cnValue)) {
                str = anY.field_cnValue;
                AppMethodBeat.o(62672);
                return str;
            } else if ((this.country.equals("zh_TW") || this.country.equals("zh_HK")) && !bo.isNullOrNil(anY.field_twValue)) {
                str = anY.field_twValue;
                AppMethodBeat.o(62672);
                return str;
            } else {
                str = anY.field_enValue;
                AppMethodBeat.o(62672);
                return str;
            }
        }
        str = "";
        AppMethodBeat.o(62672);
        return str;
    }

    public String qL(int i) {
        AppMethodBeat.i(62673);
        String str;
        if (i < 0) {
            ab.w("MicroMsg.MergerSmileyManager", "get text, error index");
            str = "";
            AppMethodBeat.o(62673);
            return str;
        }
        r rVar = (r) this.xGb.get(i);
        if (rVar != null) {
            str = rVar.field_key;
            AppMethodBeat.o(62673);
            return str;
        }
        str = "";
        AppMethodBeat.o(62673);
        return str;
    }

    public String qK(int i) {
        AppMethodBeat.i(62674);
        String str;
        if (i < 0) {
            ab.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
            str = "";
            AppMethodBeat.o(62674);
            return str;
        }
        String[] split = dqK().xGa[i].split(" ");
        char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
        char[] toChars2 = Character.toChars(Integer.decode(split[1]).intValue());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toChars);
        stringBuilder.append(toChars2);
        str = stringBuilder.toString();
        AppMethodBeat.o(62674);
        return str;
    }
}
