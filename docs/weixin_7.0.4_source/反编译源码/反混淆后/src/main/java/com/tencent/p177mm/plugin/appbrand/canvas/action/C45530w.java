package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetGlobalCompositeOperationActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.w */
public final class C45530w implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103254);
        SetGlobalCompositeOperationActionArg setGlobalCompositeOperationActionArg = new SetGlobalCompositeOperationActionArg();
        AppMethodBeat.m2505o(103254);
        return setGlobalCompositeOperationActionArg;
    }

    public final String getMethod() {
        return "setGlobalCompositeOperation";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.m2504i(103255);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.m2505o(103255);
            return z;
        }
        try {
            z = C45530w.m83956b(c2102d, jSONArray.getString(0));
            AppMethodBeat.m2505o(103255);
            return z;
        } catch (JSONException e) {
            AppMethodBeat.m2505o(103255);
            return z;
        }
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103257);
        SetGlobalCompositeOperationActionArg setGlobalCompositeOperationActionArg = (SetGlobalCompositeOperationActionArg) drawActionArg;
        if (setGlobalCompositeOperationActionArg == null) {
            AppMethodBeat.m2505o(103257);
            return false;
        }
        boolean b = C45530w.m83956b(c2102d, setGlobalCompositeOperationActionArg.type);
        AppMethodBeat.m2505o(103257);
        return b;
    }

    /* renamed from: b */
    private static boolean m83956b(C2102d c2102d, String str) {
        AppMethodBeat.m2504i(103256);
        C10148a c10148a = c2102d.hcF;
        boolean z = true;
        switch (str.hashCode()) {
            case -2120744511:
                if (str.equals("luminosity")) {
                    z = true;
                    break;
                }
                break;
            case -1763725041:
                if (str.equals("destination-out")) {
                    z = true;
                    break;
                }
                break;
            case -1698458601:
                if (str.equals("source-in")) {
                    z = true;
                    break;
                }
                break;
            case -1427739212:
                if (str.equals("hard-light")) {
                    z = true;
                    break;
                }
                break;
            case -1338968417:
                if (str.equals("darken")) {
                    z = true;
                    break;
                }
                break;
            case -1247677005:
                if (str.equals("soft-light")) {
                    z = true;
                    break;
                }
                break;
            case -1112602980:
                if (str.equals("source-out")) {
                    z = true;
                    break;
                }
                break;
            case -1091287984:
                if (str.equals("overlay")) {
                    z = true;
                    break;
                }
                break;
            case -230491182:
                if (str.equals("saturation")) {
                    z = true;
                    break;
                }
                break;
            case -131372090:
                if (str.equals("source-atop")) {
                    z = true;
                    break;
                }
                break;
            case -130953402:
                if (str.equals("source-over")) {
                    z = false;
                    break;
                }
                break;
            case -120580883:
                if (str.equals("color-dodge")) {
                    z = true;
                    break;
                }
                break;
            case 103672:
                if (str.equals("hue")) {
                    z = true;
                    break;
                }
                break;
            case 118875:
                if (str.equals("xor")) {
                    z = true;
                    break;
                }
                break;
            case 3059573:
                if (str.equals("copy")) {
                    z = true;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    z = true;
                    break;
                }
                break;
            case 170546239:
                if (str.equals("lighten")) {
                    z = true;
                    break;
                }
                break;
            case 170546243:
                if (str.equals("lighter")) {
                    z = true;
                    break;
                }
                break;
            case 653829668:
                if (str.equals("multiply")) {
                    z = true;
                    break;
                }
                break;
            case 912936772:
                if (str.equals("destination-in")) {
                    z = true;
                    break;
                }
                break;
            case 1158680499:
                if (str.equals("destination-atop")) {
                    z = true;
                    break;
                }
                break;
            case 1159099187:
                if (str.equals("destination-over")) {
                    z = true;
                    break;
                }
                break;
            case 1242982905:
                if (str.equals("color-burn")) {
                    z = true;
                    break;
                }
                break;
            case 1686617550:
                if (str.equals("exclusion")) {
                    z = true;
                    break;
                }
                break;
            case 1728361789:
                if (str.equals("difference")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.SRC_OUT));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.DST_ATOP));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.LIGHTEN));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.ADD));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.XOR));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.OVERLAY));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.DARKEN));
                break;
            case true:
                c10148a.setXfermode(new PorterDuffXfermode(Mode.LIGHTEN));
                break;
        }
        AppMethodBeat.m2505o(103256);
        return true;
    }
}
