package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class c extends f {
    public int cBA = 0;
    public int cKG = 0;
    public String ctu = "";
    public int egi = 0;
    public String haO = "";
    public String mVA = "#222222";
    public String mVB = "";
    public boolean mVC = false;
    public String mVD = "";
    public long mVE = 0;
    public bx mVF;
    public String mVj = "";
    public String mVk = "";
    public String mVl = "#929292";
    public String mVm = "";
    public String mVn = "";
    public boolean mVo = false;
    public String mVp = "";
    public String mVq = "";
    public String mVr = "";
    public LinkedList<String> mVs = new LinkedList();
    public String mVt = "";
    public LinkedList<String> mVu = new LinkedList();
    public boolean mVv = false;
    public boolean mVw = false;
    public String mVx = "";
    public String mVy = "#fca28a";
    public String mVz = "";
    public String name = "";
    public int position = 1;
    public int scene = 0;
    public int status = 0;
    public int type = 0;
    public int versionCode = 0;

    public c() {
        AppMethodBeat.i(111194);
        AppMethodBeat.o(111194);
    }

    public final boolean bDP() {
        AppMethodBeat.i(111195);
        if ((this.egi != 1 && this.egi != 2) || this.mVF == null || bo.isNullOrNil(this.mVF.ncG)) {
            AppMethodBeat.o(111195);
            return false;
        }
        AppMethodBeat.o(111195);
        return true;
    }
}
