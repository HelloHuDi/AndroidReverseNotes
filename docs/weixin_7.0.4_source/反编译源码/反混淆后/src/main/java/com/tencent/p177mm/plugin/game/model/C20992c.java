package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.p731d.C28187bx;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.c */
public final class C20992c extends C40439f {
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
    public C28187bx mVF;
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

    public C20992c() {
        AppMethodBeat.m2504i(111194);
        AppMethodBeat.m2505o(111194);
    }

    public final boolean bDP() {
        AppMethodBeat.m2504i(111195);
        if ((this.egi != 1 && this.egi != 2) || this.mVF == null || C5046bo.isNullOrNil(this.mVF.ncG)) {
            AppMethodBeat.m2505o(111195);
            return false;
        }
        AppMethodBeat.m2505o(111195);
        return true;
    }
}
