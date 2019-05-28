package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalCompositeOperationActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import org.json.JSONArray;
import org.json.JSONException;

public final class w implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103254);
        SetGlobalCompositeOperationActionArg setGlobalCompositeOperationActionArg = new SetGlobalCompositeOperationActionArg();
        AppMethodBeat.o(103254);
        return setGlobalCompositeOperationActionArg;
    }

    public final String getMethod() {
        return "setGlobalCompositeOperation";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.i(103255);
        if (jSONArray.length() <= 0) {
            AppMethodBeat.o(103255);
            return z;
        }
        try {
            z = b(dVar, jSONArray.getString(0));
            AppMethodBeat.o(103255);
            return z;
        } catch (JSONException e) {
            AppMethodBeat.o(103255);
            return z;
        }
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103257);
        SetGlobalCompositeOperationActionArg setGlobalCompositeOperationActionArg = (SetGlobalCompositeOperationActionArg) drawActionArg;
        if (setGlobalCompositeOperationActionArg == null) {
            AppMethodBeat.o(103257);
            return false;
        }
        boolean b = b(dVar, setGlobalCompositeOperationActionArg.type);
        AppMethodBeat.o(103257);
        return b;
    }

    private static boolean b(d dVar, String str) {
        AppMethodBeat.i(103256);
        a aVar = dVar.hcF;
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
                aVar.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.SRC_OUT));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.DST_ATOP));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.LIGHTEN));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.ADD));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.XOR));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.OVERLAY));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.DARKEN));
                break;
            case true:
                aVar.setXfermode(new PorterDuffXfermode(Mode.LIGHTEN));
                break;
        }
        AppMethodBeat.o(103256);
        return true;
    }
}
